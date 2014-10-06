function ProExpenseProgram(){
	//创建对象
	this.obj ={
		programId:null,
		expenseId:null,
	    expenseMoney:null,
	    
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null
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
	
	this.pageInfo =null ;
	this.pageSize =null ;
//	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	this.curPopupWindow = null;
	this.rowNum = 1;
	
	return this;
}

//清空对象
ProExpenseProgram.prototype.reset = function(){
	this.obj.programId = null;
  	this.obj.expenseId = null;
  	this.obj.expenseMoney = null;
  	
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;

}


ProExpenseProgram.prototype.saveProExpenseMoney = function(obj,callBackFun){
	ProProgramTypeManager.saveProExpenseMoney(callBackFun,obj);
}

ProExpenseProgram.prototype.removeProExpenseMoney = function(id,callBackFun){
	ProProgramTypeManager.removeProExpenseMoney(callBackFun,id);
}
