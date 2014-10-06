function YearAnalyze(){
	this.obj = {
		year:null,
		incomeDate:null,
		customerId:null,
		incomeMoney:null,
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
	this.radioTarg = null;
	this.radioName = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	
}

YearAnalyze.prototype.reset = function(){
	this.obj.incomeCode = null;
  	this.obj.incomeDate = null;
  	this.obj.customerId = null;
  	this.obj.incomeMoney = null;
  	this.obj.incomeUsed = null;
  	this.obj.balanceMoney = null;
  	this.obj.incomeModeId = null;
  	this.obj.incomePurposeId = null;
  	
  	this.obj.id = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	
  	this.obj.incomeMode = null;
  	this.obj.incomePurpose = null;
  	this.obj.customer = null;
  	this.obj.state = null;
}

Income.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	IncomeManager.getIncomeCount(getCountFun,obj);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}
YearAnalyze.prototype.fillTalbe = function(objs){	
	var OBJ = customer;
	var obj = OBJ.obj;
	var tBody  = customer.tBody;
	var color1 = customer.color1;
	var color2 = customer.color2;
	
	
	
	//把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("customerName", rowData.customerName);
	 	row.setAttribute("helpCode", rowData.helpCode);
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
		OBJ.removeOaDocument(id,delRow);
	}
	
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){return '<a href="javascript:void 0" onClick="editInfo('+ obj.id +')">' + obj.customerName +'</a>'},
					function(obj){return obj.helpCode},
					function(obj){return obj.telephone},
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