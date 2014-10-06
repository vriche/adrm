
function OaTeleExpenses(){
	//��������
	this.obj ={
		id:null,
		branchId:null,
		expenses:null,
		registerDate:null,
		
		createBy:null,
		createDate:null,
		modifyBy:null,
		modifyDate:null,
		version:null,
		branch:null
	}
	
	this.beginDate = null;
	this.endDate =null;
	
	
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

//��ն���
OaTeleExpenses.prototype.reset = function(){
	this.obj.id = null;
	this.obj.branchId = null;
	this.obj.expenses = null;
	this.obj.registerDate = null;
	
	this.obj.createBy = null;
	this.obj.createDate = null;
	this.obj.modifyBy = null;
	this.obj.modifyDate = null;
	this.obj.version = null;
	this.obj.branch = null;
}

OaTeleExpenses.prototype.getOaTeleExpenses = function(id,func){
	
	OaTeleExpensesManager.getOaTeleExpenses(func,id);
	
}

OaTeleExpenses.prototype.getOaTeleExpensess = function(o,func){
	var OBJ    = this;
	var obj    = o;
	var page   = this.page;
	
    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		OaTeleExpensesManager.getOaTeleExpensessPage(func,obj,page.pageIndex,page.pageSize);
    }else{
		OaTeleExpensesManager.getOaTeleExpensess(func,obj);	
    }
}

//��֯�б� objs �Ƿ��صĶ������飬��DWRUtil.addRows����
OaTeleExpenses.prototype.fillTable = function (objs){
	var OBJ = this;
	var tBody  = oaTeleExpenses.tBody;
	var color1 = oaTeleExpenses.color1;
	var color2 = oaTeleExpenses.color2;
	
	 //���е����ݷŵ��е�������
	 //row �Ǵ������ж���  options��������
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("branchId", rowData.branchId);
	 	row.setAttribute("expenses", rowData.expenses);
	 	row.setAttribute("registerDate", rowData.registerDate);
	 }	
	 
	//�༭ͼ��Ĵ������¼�
	function edit(event){
		var e = event || window.event;
		var editImg = Event.element(e);
		var id = editImg.getAttribute("paraId"); 
		
		var editRow = $(OBJ.IdPrefix + id);
		OBJ.addNewRow("edit",editRow);
	}
	//ɾ��ͼ��Ĵ������¼�
	function del(event){
		var e = event || window.event;
		var deleImg = Event.element(e);
		var id = deleImg.getAttribute("paraId"); 
		var delRow = deleImg.parentNode.parentNode;
		OBJ.removeContract(id,delRow);
	}
	
	//һ���У�����Ԫ�񷵻ص�����
	var cellTable=[
					function(obj){return '<a href="javascript:void 0" onClick="editInfo('+ obj.id +')">' + obj.id +'</a>'},
					function(obj){return obj.branch.name},
					function(obj){return obj.expenses},
					function(obj){return obj.registerDate},
//				    function(obj) {
//				    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"");
//				    	if(OBJ.enableEdit) editImg.onclick = edit;
//				    	return editImg;}, 
//				    function(obj) {
//						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"");
//						if(OBJ.enableDel) deleImg.onclick = del;
//				    	return deleImg;} 
			];	
	
	//��ɾ�� tbody		
	DWRUtil.removeAllRows(tBody);
	//�����¹����µı�
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
				
	//�����ÿһ������ɫ������ global.js �е�setColors����
	setColors(tBody, color1, color2);
}

/* �ܼ�¼��
 * 
 */
OaTeleExpenses.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	OaTeleExpensesManager.getOaTeleExpensessCount(getCountFun,obj);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}
OaTeleExpenses.prototype.getOaTeleExpensessCountByBeginAndEndDate = function(beginDate,endDate){
	var count;
	DWREngine.setAsync(false);
	OaTeleExpensesManager.getOaTeleExpensessCountByBeginAndEndDate(getCountFun,beginDate,endDate);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}
OaTeleExpenses.prototype.getOaTeleExpensesByBeginAndEndDate = function(O,func){
	var OBJ    = O;
	var obj    = O.obj;
	var page   = O.page;
	
    if (page.pageSize > 0){
		var size = this.getOaTeleExpensessCountByBeginAndEndDate(O.beginDate,O.endDate);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		
		OaTeleExpensesManager.getOaTeleExpensesByBeginAndEndDate(func,O.beginDate,O.endDate,page.pageIndex,page.pageSize)
    }else{
    	OaTeleExpensesManager.getOaTeleExpensess(func,obj);	
    }
}

OaTeleExpenses.prototype.fillTable_Query = function (objs){
	var OBJ = this;
	var tBody  = oaTeleExpenses.tBody;
	var color1 = oaTeleExpenses.color1;
	var color2 = oaTeleExpenses.color2;
	
	 //���е����ݷŵ��е�������
	 //row �Ǵ������ж���  options��������
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("branchId", rowData.branchId);
	 	row.setAttribute("expenses", rowData.expenses);
	 }	
	 
	//һ���У�����Ԫ�񷵻ص�����
	var cellTable=[
					function(obj){return obj.branch.name},
					function(obj){return obj.expenses},
			];	
			
	//��ɾ�� tbody		
	DWRUtil.removeAllRows(tBody);
	//�����¹����µı�
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
				
	//�����ÿһ������ɫ������ global.js �е�setColors����
	setColors(tBody, color1, color2);		
}

















