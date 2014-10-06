function ProProgramDetail(){
	//创建对象
	this.obj ={
		id:null,
		programId:null,
		inputDate:null,
	    firstDate:null,
	    director:null,
	    actor:null,
	    content:null,
	    opinion:null,
	    incomeMoney:null,
	    rate:null,
	    commendLevel:null,
	    
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
ProProgramDetail.prototype.reset = function(){
	this.obj.id = null;
	this.obj.programId = null;
  	this.obj.inputDate = null;
  	this.obj.firstDate = null;
  	this.obj.director = null;
  	this.obj.actor = null;
  	this.obj.content = null;
  	this.obj.opinion = null;
  	this.obj.incomeMoney = null;
  	this.obj.rate = null;
  	this.obj.commendLevel = null;
  	
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;

}


ProProgramDetail.prototype.saveProProgramDetail = function(obj,callBackFun){
	ProProgramManager.saveProProgramDetail(callBackFun,obj);
}

ProProgramDetail.prototype.getProgramDetailXML = function(obj,callBackFun){
	ProProgramManager.getProgramDetailXML(callBackFun,obj);
}
ProProgramDetail.prototype.getProgramDetail = function(obj,callBackFun){
	ProProgramManager.getProgramDetail(callBackFun,obj);
}

ProProgramDetail.prototype.removeProgramDetail = function(id,callBackFun){
	ProProgramManager.removeProgramDetail(callBackFun,id);
}
