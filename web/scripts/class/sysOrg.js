

function SysOrg(){
	//创建对象
	this.obj ={
		id:null,
		name:null,
		tel:null,
		fax:null,
		linkMan:null,
		bankName:null,
		bankCode:null,
		
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    
	    address:null,
	    branchs:null
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
SysOrg.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name= null;
  	this.obj.tel = null;
  	this.obj.fax = null;
  	this.obj.linkMan = null;
  	this.obj.bankName = null;
  	this.obj.bankCode = null;
  	
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	
  	this.obj.address = null;
  	this.obj.branchs = null;
}


/* 给树加载信息	
 * 先初始化树对象，再加载数据
 */
SysOrg.prototype.getTreeXML = function(branchIdPrefix,userIdPrefix){
	var OBJ = this;
	var treeXMLString;

	DWREngine.setAsync(false);
//	OrgManager.getOrgsXml(this.obj.id,this.IdPrefix,getxml);
    OrgManager.getOrgsXml(this.obj.id,this.IdPrefix,branchIdPrefix,userIdPrefix,getxml);
	DWREngine.setAsync(true);
	
	function getxml(treeXML){ 
		OBJ.tree.treeXML = treeXML; 
		treeXMLString = treeXML;
//		OBJ.tree.dhtmlTree.loadXMLString(treeXML);
	} 
	
    return treeXMLString;
}


SysOrg.prototype.getTreeXML3 = function(branchIdPrefix,userIdPrefix,callbackFun){
   OrgManager.getOrgsXml(this.obj.id,this.IdPrefix,branchIdPrefix,userIdPrefix,getxml);
	function getxml(treeXML){ 
		if(callbackFun) callbackFun(treeXML);
	} 
}



SysOrg.prototype.getTreeXML2 = function(branchIdPrefix,userIdPrefix,loginUser,callbackFun){
  
    OrgManager.getOrgsXml2(this.obj,this.IdPrefix,branchIdPrefix,userIdPrefix,loginUser,getxml);

	function getxml(treeXML){ 
		if(callbackFun) callbackFun(treeXML);
	} 

}





 SysOrg.prototype.makeSelect = function(obj,name,event,callBackFun) {
//	DWREngine.setAsync(false);
	var kk = OrgManager.getOrgSelect(setValueFun,obj);
	
//	DWREngine.setAsync(true);	
	
	function setValueFun(objs){

		 makeSelectHtml(objs,name,event);
		 
		 if(callBackFun) callBackFun(objs);
	}
} 

 SysOrg.prototype.makeSelectWidth = function(obj,name,event,Width,callBackFun) {
//	DWREngine.setAsync(false);
	var kk = OrgManager.getOrgSelect(setValueFun,obj);
	
//	DWREngine.setAsync(true);	
	
	function setValueFun(objs){

		 makeSelectHtmlWidth(objs,name,event,Width);
		 
		 if(callBackFun) callBackFun(objs);
	}
} 


