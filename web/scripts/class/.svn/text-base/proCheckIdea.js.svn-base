function ProCheckIdea(){
	//创建对象
	this.obj ={
		id:null,
		programId:null,
		carrierId:null,
	    checkResult:null,
	    checkIdea:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
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
ProCheckIdea.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.programId = null;
  	this.obj.carrierId = null;
  	this.obj.checkResult = null;
  	this.obj.checkIdea = null;
  
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;

}

ProCheckIdea.prototype.getProCheckIdeaXML = function(obj,callBackFun){
	ProCheckIdeaManager.getProCheckIdeasXML(callBackFun,obj);
}

ProCheckIdea.prototype.saveProCheckIdea = function(obj,callBackFun){
	ProCheckIdeaManager.saveProCheckIdea(callBackFun,obj);
}

ProCheckIdea.prototype.removeProCheckIdea = function(id){
	ProCheckIdeaManager.removeProCheckIdea(id);
}
