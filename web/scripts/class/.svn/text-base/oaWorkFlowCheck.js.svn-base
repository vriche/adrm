
function OaWorkFlowCheck(){

	this.obj = {
		id:null,
		workFlowTypeId:null,
		checkUserId:null,
		checkIdea:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    
	    checkStateId:null,
	    workFlowId:null,
	    workFlowType:null,
	    workFlow:null,
	    OaWorkFlowCheckState:null,
	    checkUser:null,
	    contracts:null,
	    orders:null,
	    applys:null
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
OaWorkFlowCheck.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.workFlowTypeId = null;
  	this.obj.checkUserId = null;
  	this.obj.checkIdea = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	
  	this.obj.checkStateId = null;
  	this.obj.workFlowId = null;
  	this.obj.workFlowType = null;
  	this.obj.workFlow = null;
  	this.obj.checkState = null;
  	this.obj.checkUser = null;
  	this.obj.contracts = null;
  	this.obj.orders = null;
  	this.obj.applys = null;
}	



OaWorkFlowCheck.prototype.saveCheckResult = function(mode){
	var OBJ = this;
	var obj = this.obj;
	var id;

	if (mode == 'new') obj.id = null;
	
	DWREngine.setAsync(false);
	OaWorkFlowCheckManager.saveOaWorkFlowCheck(obj,saveFun);
	DWREngine.setAsync(true);
	
	function saveFun(newId){
		OBJ.reset();
		id = newId;
	}
	return id;
}
OaWorkFlowCheck.prototype.getOaWorkFlowCheckByContractId = function(id,fun){
	OaWorkFlowCheckManager.getOaWorkFlowChecksByContractId(fun,id);
}

OaWorkFlowCheck.prototype.getOaWorkFlowCheckByOrderId = function(id,fun){

	OaWorkFlowCheckManager.getOaWorkFlowChecksByOrderId(id,fun);
}

OaWorkFlowCheck.prototype.fillTalbe = function(objs,o){
	var OBJ = o;
	var obj = OBJ.obj;
	var tBody  = OBJ.tBody;
	var color1 = OBJ.color1;
	var color2 = OBJ.color2;
	OBJ.rowNum =(OBJ.page.pageIndex-1)*OBJ.page.pageSize*1+1;
	
	
	 //把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 }	
	 
	//编辑图标的触发的事件
	function edit(event){
		var e = event || window.event;
		var editImg = Event.element(e);
		var id = editImg.getAttribute("paraId"); 
		
		var editRow = $(OBJ.IdPrefix + id);
		OBJ.addNewRow("edit",editRow);
	}
	//删除图标的触发的事件
	function del(event){
		var e = event || window.event;
		var deleImg = Event.element(e);
		var id = deleImg.getAttribute("paraId"); 
		var delRow = deleImg.parentNode.parentNode;
		OBJ.removeOrderDetail(id,delRow);
	}
	
	var i =1;
	
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){return i++;},
					function(obj){return obj.checkUser.fullName },
					function(obj){return obj.checkIdea},
					function(obj){return obj.checkState.name},
					function(obj){return formatDate(obj.createDate)},
//				    function(obj) {
//				    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"");
//				    	if(OBJ.enableEdit) editImg.onclick = edit;
//				    	return editImg;}, 
//				    function(obj) {
//						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deleteOrderDetail","18","18",obj.id,"");
////						if(OBJ.enableDel) deleImg.onclick = del;
//				    	return deleImg;} 
			];	
	
	//先删除 tbody		
	DWRUtil.removeAllRows(tBody);
	//再重新构造新的表
	DWRUtil.addRows(tBody,objs,cellTable,{
				rowCreator:function(options) {  
						   var row = document.createElement("tr");
						   var rowIndex = options.rowIndex;						   
//						   row.setAttribute("detailRowId",options.rowData.id);
////						   row.setAttribute("onclick","javascript:"getOrderDetail(this)");
//						   row.setAttribute("onclick","javascript:getOrderDetail("+ options.rowData.id +")");
////					       row.onmousedown = OBJ.orderDetailMouseDown;							    
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