
function OaInfo(){

	this.obj = {
		id:null,
		infoTypeId:null,
		title:null,
		searchKey:null,
		content:null,
		displayTimes:null,
		
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
	this.selectName = null;
		
	this.pageInfo =""
	this.pageSize ="20"
	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	
	return this;	
}	

//Çå¿Õ¶ÔÏó
OaInfo.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.infoTypeId = null;
  	this.obj.title = null;
  	this.obj.content = null;
  	this.obj.displayTimes = null;
  	this.obj.searchKey = null;
  	
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
}	


OaInfo.prototype.makeSelect = function(obj,el,event,callBackfun){
	
	OaInfoManager.getOaInfoSelect(fillFun,obj);	
	
	function fillFun(data){
		 var html = "";
		 for (var prop in data) {
		 	   var id = prop;
        		   var value = data[prop];
        		   html += "<a href='javascript:void 0' onclick='" + event +"(" + id + ")'>" + value +"</a>"
		}
		//makeSelectHtml(objs,targetName,event);
		el.innerHTML =html;
		callBackfun(data);
	}
}	

OaInfo.prototype.getOaInfo = function(obj,callBackfun){
	
	OaInfoManager.getOaInfo(obj.id,fillFun);	
	
	function fillFun(objs){
		callBackfun(objs);
	}
}	
