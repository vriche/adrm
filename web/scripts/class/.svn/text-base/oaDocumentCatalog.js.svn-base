function OaDocumentCatalog(){
	//创建对象
	this.obj ={
		id:null,
		name:null,
	    parentId:null,
	    nodeLevel:null,
	    displayNo:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    documents:null,
	    permitUsers:null,
	    permitBranchs:null,
	    permitRoles:null,
	    permitTypes:null
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
OaDocumentCatalog.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.parentId = null;
  	this.obj.nodeLevel = null;
  	this.obj.displayNo = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.documents = null;
  	this.obj.permitUsers = null;
  	this.obj.permitBranchs = null;
  	this.obj.permitRoles = null;
  	this.obj.permitTypes = null;
}

OaDocumentCatalog.prototype.getOaDocumentCatalog = function(id){

	var obj = this.obj;
	this.reset();
	DWRUtil.setValues(obj);
	OaDocumentCatalogManager.getOaDocumentCatalog(setValueFun,id);
		
	function setValueFun(obj){
		DWRUtil.setValues(obj);
		
		if(obj.permitUsers == '' || obj.permitUsers == null){
			 oaDocumentCatalog.tree.getAllCheckedBranches(oaDocumentCatalog.IdPrefix) =[];
		}
		
		oaDocumentCatalog.tree.getAllCheckedBranches(oaDocumentCatalog.IdPrefix);
	}
}

OaDocumentCatalog.prototype.saveOaDocumentCatalog = function(mode){

	var OBJ = this;
	var obj =  this.obj;
	var IdPrefix = this.IdPrefix;
	var docuCatalogId = oaDocumentCatalog.tree.curSelectItemId;;
	var obj_tree = oaDocumentCatalog.tree.dhtmlTree;

	if (mode == 'new') obj.id = null;

	DWRUtil.getValues(oaDocumentCatalog);
	
	oaDocumentCatalog.obj.id = docuCatalogId;

	DWREngine.setAsync(false);
	OaDocumentCatalogManager.saveOaDocumentCatalog(obj,documentCatalogsaveFun);
	DWREngine.setAsync(true);

    function documentCatalogsaveFun(newId){
		if (newId) {
			docuCatalogId = newId;

			saveFun(newId);
		}
   }

	function saveFun(id){			
		var name = oaDocumentCatalog.obj.name;
   		var newId = IdPrefix + id;
		obj_tree.changeItemId(obj_tree.newItemId,newId);
		obj_tree.selectItem(newId,true);
        obj_tree.setUserData(newId,"id",id);
		obj_tree.setItemText(newId,name);
		obj_tree.setUserData(newId,"type",1);
	}
}

/* 保存
 * obj 组装好数据的对象
 * mode 保存模式  状态为 new 时必须设置 id = null
 */
OaDocumentCatalog.prototype.saveDocuCataPermitTypeAndUser = function(id,mode){
	var OBJ = this;
	var obj =  this.obj;	
	
	var IdPrefix = this.IdPrefix;
	var obj_tree = oaDocumentCatalog.tree.dhtmlTree;
	var idsUserPermit = user.tree.getAllCheckedBranches(user.IdPrefix);
	var idsPermitType = oaDocumentCatalogPermitType.getPermitTypeIdArray();

	if(mode == 'new') oaDocumentCatalog.obj.id = null;	
		
	if(idsUserPermit == null) idsUserPermit = [];
	if(idsPermitType == null) idsPermitType = [];
//		alert("idsUserPermit=" + idsUserPermit);
//		alert("idsPermitType=" + idsPermitType);
	oaDocumentCatalog.obj.permitUsers = idsUserPermit;
	oaDocumentCatalog.obj.permitTypes = idsPermitType;
				
	oaDocumentCatalog.obj.id = id;
	
	DWREngine.setAsync(false);
	OaDocumentCatalogManager.saveOaDocumentCatalog(obj,documentCatalogsaveFun);
	DWREngine.setAsync(true);
   		
    function documentCatalogsaveFun(newId){

		if (newId) {
			
			docuCatalogId = newId;

			doUpdateItemDocumentCatalog(newId);
		}
   }
   
   function doUpdateItemDocumentCatalog(id){
		
   		var newId = IdPrefix + id;

   		var name = oaDocumentCatalog.obj.name;

		obj_tree.changeItemId(obj_tree.getSelectedItemId(),newId);
        obj_tree.setUserData(newId,"id",id);
		obj_tree.setItemText(newId,name);
		obj_tree.setUserData(newId,"type",1);
		obj_tree.setItemColor(newId,"black","white");
   }
   
}

/* 删除
 * 根据id删除对象
 */
OaDocumentCatalog.prototype.removeOaDocumentCatalog = function(id){
	var OBJ = oaDocumentCatalog;
	var obj = oaDocumentCatalog.obj;
	var obj_tree = oaDocumentCatalog.tree.dhtmlTree;
	var newItemId = oaDocumentCatalog.tree.newItemId;
	
	if(obj_tree.getSelectedItemId()!= newItemId){
		if(!confirmDelete('OaDocumentCatalog')) return false;
		doDeleteTreeItem(oaDocumentCatalog,oaDocumentCatalog.IdPrefix + id);
		OaDocumentCatalogManager.removeOaDocumentCatalog(id);
	}	
	
	function doDeleteTreeItem(obj,id){
		obj.tree.removeNodeItem(id);
	}
}


/* 给树加载信息	
 * 先初始化树对象，再加载数据
 */
OaDocumentCatalog.prototype.getTreeXML = function(){
	var OBJ = this;
	var treeXMLString;
	
	DWREngine.setAsync(false);
	OaDocumentCatalogManager.getOaDocumentCatalogsXML(this.obj,this.IdPrefix,getxml);
	DWREngine.setAsync(true);
	
	function getxml(treeXML){ 
		OBJ.tree.treeXML = treeXML; 
		treeXMLString = treeXML;
	} 
    return treeXMLString;
}


OaDocumentCatalog.prototype.getDocumentTreeXML = function(oaDocumentIdPrefix,userId){
	var OBJ = this;
	var treeXMLString;
	
	DWREngine.setAsync(false);
	OaDocumentCatalogManager.getOaDocumentCatalogDocumentXml(this.obj,this.IdPrefix,oaDocumentIdPrefix,userId,getxml);
	DWREngine.setAsync(true);
	
	function getxml(treeXML){ 
		OBJ.tree.treeXML = treeXML; 
		treeXMLString = treeXML;
	} 

    return treeXMLString;
}

OaDocumentCatalog.prototype.getPermitUsersColByCatalogId = function(catalogId){
	var propertyName = "id";
	var str = new Array();
	DWREngine.setAsync(false);
	OaDocumentCatalogManager.getPermitUsersColByCatalogId(getFun,catalogId,propertyName);	
	DWREngine.setAsync(true);
	
	function getFun(strArray){
		str = strArray;
	}
	return str;
}

OaDocumentCatalog.prototype.getCatalogPermitsColByCatalogId = function(catalogId){
	var propertyName = "id";
	var str = new Array();
	
	DWREngine.setAsync(false);
	OaDocumentCatalogManager.getCatalogPermitsColByCatalogId(getFun,catalogId,propertyName);	
	DWREngine.setAsync(true);
	
	function getFun(strArray){
		str = strArray;
	}
	return str;
}

