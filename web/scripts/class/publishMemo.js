
function PublishMemo(){

	this.obj = {
		id:null,
		name:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    value:null
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
PublishMemo.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.value = null;
}	

PublishMemo.prototype.getPublishMemo = function(id,func){
	PublishMemoManager.getPublishMemo(func,id);
}
	
PublishMemo.prototype.getPublishMemos = function(o,func){
	var OBJ = this;
	var obj = o;
	var page   = this.page;
	
    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		
		PublishMemoManager.getPublishMemosPage(func,obj,page.pageIndex,page.pageSize);
    }else{
		PublishMemoManager.getPublishMemos(func,obj);	
    }
}	
	
PublishMemo.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	PublishMemoManager.getPublishMemosCount(getCountFun,obj);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}	

PublishMemo.prototype.fillTable = function(objs){
	var OBJ = this;
	var obj = OBJ.obj;
	var tBody  = this.tBody;
	var color1 = this.color1;
	var color2 = this.color2;
	
	
	//把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("id", rowData.id);
	 	row.setAttribute("name", rowData.name);
	 	row.setAttribute("modifyDate", rowData.modifyDate);
	 }	
	 
	 
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){return obj.id},
					function(obj){return obj.name},
					function(obj){return obj.modifyDate},
//				    function(obj) {
//				    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"editDocument");
////				    	if(OBJ.enableEdit) editImg.onclick = edit;
//				    	return editImg;}, 
//				    function(obj) {
//						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"delDocument");
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
				           row.setAttribute("onclick","javascript:editInfo("+ options.rowData.id +")");
//						   row.onclick = function(){parent.location.href = "editCustomer.html?id="+options.rowData.id+"";};
						   return row;  
					  },  
					  
				cellCreator:function(options) {  
						    var td = document.createElement("td"); 
						    td.style.cssText = "cursor: pointer;";	 
						    return td;  
					  }  
				});
				
	//给表格每一行上颜色，调用 global.js 中的setColors函数
	setColors(tBody, color1, color2); 
	 
}		