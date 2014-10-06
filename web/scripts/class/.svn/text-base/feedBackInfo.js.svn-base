
function FeedbackInfo(){

	this.obj = {
		id:null,
		customerId:null,
		feeder:null,
		customerId:null,
		departmentId:null,
		feedType:null,
		submitDate:null,
		feedContent:null,
		dealDate:null,
		satisfactoryDegree:null,
		
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    memo:null
	}

    this.className = null;
	this.treebox = null;
	this.tree = null;
	this.tableName = null;	
	this.tBody = null;
	this.checkBoxName = null;
	this.checkBox =null;
	this.IdPrefix = null;
	this.fillObjName = null;
	this.color1 = null;
	this.color2 = null;
	
	this.pageInfo =""
	this.pageSize ="20"
	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	
	return this;	
}	

//清空对象
FeedbackInfo.prototype.reset = function(){
	this.obj.id = null;
	
  	this.obj.customerId = null;
  	this.obj.feeder = null;
  	this.obj.departmentId = null;
  	this.obj.feedType = null;
  	this.obj.submitDate = null;
  	this.obj.feedContent = null;
  	this.obj.dealDate = null;
  	this.obj.satisfactoryDegree = null;
  	
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.memo = null;
  	this.obj.enable = null;
}	

FeedbackInfo.prototype.getFeedbackInfos = function(O,func){
	var OBJ = O;
	var obj = OBJ.obj;
	var page = OBJ.page;

    if (page.pageSize > 0){

		var size = this.getCount(obj);

		page.size = size;
		
		page.MakePageNav(page.pageIndex,page.pageInfo);
	
		FeedbackInfoManager.getFeedbackInfosPage(func,obj,page.pageIndex,page.pageSize);
    }else{
		FeedbackInfoManager.getFeedbackInfos(func,obj);	
    }
}
FeedbackInfo.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	FeedbackInfoManager.getFeedbackInfosCount(getCountFun,obj);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}

FeedbackInfo.prototype.fillTable = function(objs){
	
	var OBJ = this;
	var obj = this.obj;
	var tBody  = this.tBody;
	var color1 = this.color1;
	var color2 = this.color2;
	
	
	
	//把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("submitDate", rowData.submitDate);
	 	row.setAttribute("feeder", rowData.feeder);
	 	row.setAttribute("feedContent", rowData.feedContent);
	 	row.setAttribute("dealDate", rowData.dealDate);
	 	row.setAttribute("satisfactoryDegree", rowData.satisfactoryDegree);
	 }	
	 
	//编辑图标的触发的事件
	function edit(event){
		var e = event || window.event;
		var editImg = Event.element(e);
		var tr1= editImg.parentNode.parentNode;
		var id = tr1.getAttribute("paraId"); 
		
		var editRow = $(OBJ.IdPrefix + id);
		
		OBJ.addNewRow("edit",editRow);
	}
	//删除图标的触发的事件
	function del(event){
		var e = event || window.event;
		var deleImg = Event.element(e);
		var id = deleImg.getAttribute("paraId"); 
		var delRow = deleImg.parentNode.parentNode;
		OBJ.removeAgentInfo(id,delRow);
	}
	
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){return obj.submitDate},
					function(obj){return obj.feeder},
					function(obj){return obj.feedContent},
					function(obj){return obj.dealDate},
					function(obj){return obj.satisfactoryDegree},
					function(obj){return ""}
//				    function(obj) {
//				    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"");
//				    	if(OBJ.enableEdit) editImg.onclick = edit;
//				    	return editImg;}, 
//				    function(obj) {
//						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"delAgentInfo");
////						if(OBJ.enableDel) deleImg.onclick = del;
//				    	return deleImg;} 
			];	
				
	//先删除 tbody		
	DWRUtil.removeAllRows(tBody);
	//再重新构造新的表
	DWRUtil.addRows(tBody,objs,cellTable,{
				rowCreator:function(options) {  
						   var row = document.createElement("tr"); 
				           putRowDataInHidden(row,options.rowData);
						   return row;  
					  },  
					  
				cellCreator:function(options) {  
						    var td = document.createElement("td"); 
						    return td;  
					  }  
				});
				
	//给表格每一行上颜色，调用 global.js 中的setColors函数
	setColors(tBody, color1, color2);	
}

FeedbackInfo.prototype.getFeedbackInfosListXML = function(obj,callBackFun){
	FeedbackInfoManager.getFeedbackInfosListXML(obj,callBackFun);	
}












