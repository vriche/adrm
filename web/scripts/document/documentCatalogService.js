
//实例化对象
var oaDocumentCatalog = new OaDocumentCatalog();

var user = new User();

var oaDocumentCatalogPermitType = new OaDocumentCatalogPermitType();

callOnLoad(init);	

function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var treebox = $("oaDocumentCatalogTreebox");
    
    var userTreebox = $("userTreebox");
    
    var Btn_addCatalogChild = $("Btn_addCatalogChild");
    var v = Btn_addCatalogChild.offsetHeight*2.5;
    treebox.style.height = dialogcontent.offsetHeight -(dialogcontent.offsetTop - treebox.offsetTop) - v +"px";	   	

	userTreebox.style.height = treebox.offsetHeight*0.5 + "px";
} 
 
 function init(){
 	
 	buttonEventFill();	
	
 	setOaDocumentCatalogPara(oaDocumentCatalog);	//设置常量
 	setUserPara(user);  //设置常量
	setPermitTypePara(oaDocumentCatalogPermitType); //设置常量
	
	getUserTree(user); 	// 获得树
	getOaDocumentCatalogTree(oaDocumentCatalog); 	// 获得树	
	getPermitTypeCheckBox(oaDocumentCatalogPermitType);	//获得checkbox
	
	resetHeigth();
}

//动作填充
function buttonEventFill(){
	
	//添加目录
	var Btn_addCatalogChild = $("Btn_addCatalogChild");
	Btn_addCatalogChild.onclick = btn_addCatalog;
	
	//保存
	var Btn_save_catalog = $("Btn_save_catalog");
	Btn_save_catalog.onclick = saveOaDuocument_permitType_permitUser;
	
	//删除目录
	var Btn_delete_catalog = $("Btn_delete_catalog");
	Btn_delete_catalog.onclick=button_removeDocument;

}

//设置常量
function setOaDocumentCatalogPara(obj){
	 obj.className  = "oaDocumentCatalog";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 		= new Tree(obj.treebox); 
	 
}

//设置常量
function setUserPara(obj){
	 obj.className 	= "user";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 		= new Tree(obj.treebox); 
}

//设置常量
function setPermitTypePara(obj){
	obj.className = "oaDocumentCatalogPermitType";
	obj.tableName = obj.className + "Table";
	
}

//获得目录树信息
function getOaDocumentCatalogTree(obj){
	obj_tree = obj.tree.dhtmlTree;	
	obj_tree.enableCheckBoxes(false);
	obj_tree.enableItemEditor(false);
	obj_tree.enableDragAndDrop(false);
	obj_tree.setOnClickHandler(doOnSelectGetRes);
//	obj_tree.setOnItemTextChange(doOnTextChangeTree);
	obj.reset();
	obj.obj.parentId = 0;
	obj.getTreeXML();
	obj_tree.loadXMLString(obj.tree.treeXML);
}

//获得用户树信息
function getUserTree(obj){
	obj_tree = obj.tree.dhtmlTree;	
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.enableItemEditor(false);
	obj_tree.enableDragAndDrop(false);
	//加载数据
	obj.reset();
	obj.obj.parentId = 0;
	obj.getTreeXML();
	obj_tree.loadXMLString(obj.tree.treeXML);
}

//获得checkbox
function getPermitTypeCheckBox(obj){
	obj.reset();
	obj.getOaDocumentCatalogPermitTypes(obj);
}

function doOnSelectGetRes(itemId){	
	if(itemId == 'root'){
		resetAll();
//		return false;
	}
	//控制根节点；
	oaDocumentCatalog.tree.disableRootEdit();
	
	var obj_tree = oaDocumentCatalog.tree.dhtmlTree;
	var newItemId = oaDocumentCatalog.tree.newItemId;


	//设置目录ID
	oaDocumentCatalog.tree.setCurSelectItemId(oaDocumentCatalog.IdPrefix);
	var oaDocumentCatalogId = oaDocumentCatalog.tree.curSelectItemId;

//	if(oaDocumentCatalogId==''){
//		$("documentCatelogName").value = null;
//	}else{
	if(oaDocumentCatalogId !=''){
		var name = obj_tree.getItemText(oaDocumentCatalog.IdPrefix+oaDocumentCatalogId);
		$("documentCatelogName").value = name;
	}

	if(itemId != newItemId){
		if(obj_tree.getLevel(newItemId)!=0){
			if(confirm("Do you want to save changes?")){
				var nodeType = oaDocumentCatalog.tree.dhtmlTree.getUserData(itemId,"type");
				obj_tree.selectItem(newItemId,false);
//				if(nodeType == 1){ 
					saveOaDuocument_permitType_permitUser();
//				}	
				return;
			}
			obj_tree.deleteItem(newItemId);
		}
	}else{//set color to new item label
		obj_tree.setItemColor(itemId,"red","pink");
	}
	
	if(itemId != 'root' && itemId != newItemId){
		var permitUsers = oaDocumentCatalog.getPermitUsersColByCatalogId(oaDocumentCatalogId);
		var permitType = oaDocumentCatalog.getCatalogPermitsColByCatalogId(oaDocumentCatalogId);
		
		loadDataPermitUserTree(user,permitUsers);	
		getPermitTypeId(oaDocumentCatalogPermitType,permitType);		
	}
}

//编辑
//function doOnTextChangeTree(itemId){
//	
//	var obj_tree = oaDocumentCatalog.tree.dhtmlTree;
//	var id = oaDocumentCatalog.tree.getIdByPrefix(itemId,oaDocumentCatalog.IdPrefix);
//	var name = obj_tree.getItemText(itemId);
//	var mode ="";
//	var permitUserIds = user.tree.getAllCheckedBranches(user.IdPrefix);
//	var permitTypesIds = oaDocumentCatalogPermitType.getPermitTypeIdArray();
//	var selectedId = obj_tree.getSelectedItemId();
//
//	//判断是新添 ID = -1 
//	if(itemId == oaDocumentCatalog.tree.newItemId){
//		id = null;
//		mode = 'new';
//	}
//	
//	var relId = obj_tree.getParentId(selectedId);
//	var parentId = obj_tree.getUserData(relId,"id");
//	
//	oaDocumentCatalog.obj.id  = id;
//	oaDocumentCatalog.obj.name = name;
//	oaDocumentCatalog.obj.parentId = parentId;
//
//	if(permitUserIds == null) permitUserIds = [];
//	if(permitTypesIds == null) permitTypesIds = [];
//	oaDocumentCatalog.obj.permitUsers = permitUserIds;
//	oaDocumentCatalog.obj.permitTypes = permitTypesIds;
//
//	oaDocumentCatalog.saveOaDocumentCatalog(mode);
//
//}

function getPermitTypeId(obj,ids){	
	
	refreshCheckBox(obj.tableName);
	
	var checkboxs = document.getElementsByName("checkboxPermitType");
	var checkboxsA = $A(checkboxs);
	
	if(ids != '' || ids != null){
		for (var i = 0; i < ids.length; i++){
			for (var j = 0; j < ids[i].length; j++){
				checkboxsA.each(function(chb){
					if(chb.value == ids[i][j]){
						chb.checked=true;
					}
				});
			}
		}
	}	
}

//添加
function btn_addCatalog(event){
	resetAll();
	
	var obj_tree = oaDocumentCatalog.tree.dhtmlTree;
	var newItemId = oaDocumentCatalog.tree.newItemId;
	var newItemLabel = oaDocumentCatalog.tree.newItemLabel;
	var selectedId = obj_tree.getSelectedItemId();
	
	$("documentCatelogName").value = newItemLabel;
	
	if(selectedId != ''){
		
    	oaDocumentCatalog.obj.id = 0;
		
		var parentId = obj_tree.getUserData(selectedId,"id");

		oaDocumentCatalog.obj.parentId = parentId;
		oaDocumentCatalog.obj.name = newItemLabel;

   		obj_tree.insertNewItem(selectedId,newItemId,newItemLabel,"","book.gif","books_open.gif","books_close.gif","SELECT,CALL",0);

	} 
}

//保存
function saveOaDuocument_permitType_permitUser(){
	var obj_tree = oaDocumentCatalog.tree.dhtmlTree;
	var mode = '';
	var catalogId = oaDocumentCatalog.tree.getSelectedItemId(oaDocumentCatalog.IdPrefix);
	var selectedId = obj_tree.getSelectedItemId();
	var id = oaDocumentCatalog.tree.getIdByPrefix(catalogId,oaDocumentCatalog.IdPrefix);
//	doOnTextChangeTree(oaDocumentCatalog.IdPrefix + catalogId);

//	alert($("documentCatelogName").value);

	if($("documentCatelogName").value == ''){
		alert("目录名称不能为空");
		return false;
	}

	oaDocumentCatalog.obj.name = $("documentCatelogName").value;
	if(catalogId == ''){
		mode = 'new';
		
//		DWRUtil.getValues(oaDocumentCatalog.obj);;
		oaDocumentCatalog.saveDocuCataPermitTypeAndUser(catalogId,mode);
		doOnSelectGetRes(oaDocumentCatalog.IdPrefix + catalogId);
	}else{
		mode = 'edit';
		
		var relId = obj_tree.getParentId(selectedId);
		var parentId = obj_tree.getUserData(relId,"id");
//		var name = obj_tree.getItemText(oaDocumentCatalog.IdPrefix + catalogId);

		oaDocumentCatalog.obj.id = catalogId;
		oaDocumentCatalog.obj.name = $("documentCatelogName").value;
		oaDocumentCatalog.obj.parentId = parentId;
		DWRUtil.getValues(oaDocumentCatalog.obj);
		oaDocumentCatalog.obj.version = 0;
		
		oaDocumentCatalog.saveDocuCataPermitTypeAndUser(catalogId,mode);
	}
}

//删除目录  
function button_removeDocument(){
	var id = oaDocumentCatalog.tree.curSelectItemId;
	if(id == ''){
		alert("根节点不允许删除");
		return false;
	}
	oaDocumentCatalog.removeOaDocumentCatalog(id);
}

//根据oaDocumentCatalogId获得user树的信息
function loadDataPermitUserTree(obj,ids){
	obj.tree.loadDataTreeArray1(obj.IdPrefix,ids);
}

//清空
function resetAll(){
	$("documentCatelogName").value = null;
	
	user.tree.refreshTree();
	refreshCheckBox(oaDocumentCatalogPermitType.tableName);
}
	
	
		