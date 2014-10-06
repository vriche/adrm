
function MediaOrg(){

	this.obj = {
		id:null,
		name:null,
		value:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    memo:null,
	    enable:null
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

//Çå¿Õ¶ÔÏó
MediaOrg.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.value = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.memo = null;
  	this.obj.enable = null;
}	

MediaOrg.prototype.makeSelectItemAnalyze = function(obj,name,event){
	//DWREngine.setAsync(false);
	MediaOrgManager.getMediaOrgsSelectItem(fillFun,obj);
	//DWREngine.setAsync(true);
	
	function fillFun(objs){
		makeSelectHtmlAnalyze(objs,name,event);
	}
}

	