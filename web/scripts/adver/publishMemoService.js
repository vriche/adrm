
var publishMemo = new PublishMemo();

callOnLoad(init);

function init(){
	setPublishMemoPara(publishMemo);
	
	getPublishMemoTable();
}

function setPublishMemoPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 
	 obj.className ="publishMemo";
	 obj.IdPrefix 	 = obj.className + "Id";
	 obj.fillObjName = obj.className + "Body";
	 obj.tableName   = obj.className + "List";
	 obj.tBody 		 = $(obj.fillObjName);
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 
	 obj.pageInfo 	 = "pageInfo_" + obj.className;
	 obj.pageSize 	 = "15";
	 obj.page        = new Page(obj.pageInfo,obj.pageSize); 
}

function getPublishMemoTable(){
	publishMemo.reset();
	
	var func = function(objs){
		publishMemo.fillTable(objs);
	}
	
	publishMemo.getPublishMemos(publishMemo.obj,func);
}

function editInfo(id){
	parent.location.href = "editPublishMemo.html?id=" + id;
}

function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == publishMemo.pageInfo){
		var page = new Page(publishMemo.pageInfo,publishMemo.pageSize);
		page.goNextPage(pageIndex);
		publishMemo.page = page;
		getPublishMemoTable();
	}
}








