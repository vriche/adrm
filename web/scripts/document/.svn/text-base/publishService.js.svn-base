  
//实例化对象
 var oaDocumentFile = new OaDocumentFile(); 
 var oaDocument = new OaDocument();
 var oaDocumentCatalog = new OaDocumentCatalog();
 var user = new User();
  
 callOnLoad(init);	
 
 function init(){
 	
 	buttonEventFill();
 	
 	user.obj = user.getCurrentUser();
 	
    setUserPara(user);
    
 	setOaDocumentFilePara(oaDocumentFile); 	//设置常量
	getOaDocumentFileTable(oaDocumentFile); //获得表

	setOaDocumentPara(oaDocument);

 	setOaDocumentCatalogPara(oaDocumentCatalog);	//设置常量
	getOaDocumentCatalogTree(oaDocumentCatalog); 	// 获得树	
}

//设置常量
function setUserPara(obj){
	 obj.className 	= "user";
	 obj.IdPrefix 	= obj.className + "Id";
}

//动作填充
function buttonEventFill(){	
	//添加
	var Btn_add_document = $("Btn_add_document");
	Btn_add_document.onclick = addOaDuocument_documentFile;
	
	//保存
	var Btn_save_document = $("Btn_save_document");
	Btn_save_document.onclick = saveOaDuocument_documentFile;
	
}

//设置常量
function setOaDocumentFilePara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className  = "oaDocumentFile";	
	 obj.IdPrefix 	= obj.className + "Id";
	 
	 obj.fillObjName= obj.className + "Body";
	 obj.color1 	= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 	= "BACKGROUND-COLOR: #ECEFF4";
	 
	 obj.tBody 		= $(obj.fillObjName);
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "4";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);

}

//设置常量
function setOaDocumentPara(obj){
	
	 obj.className ="oaDocument";
	 
	 obj.IdPrefix 	= obj.className +"Id";
	 obj.tableName   = obj.className +"Table";
	 obj.fillObjName = obj.className +"Tbody";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.checkBoxName = obj.className +"Check";
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.enableEdit	= true;
	 obj.enableDel	= true;	 
	 obj.pageInfo 	= obj.className +"PageInfo";
	 obj.pageSize 	= "4";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}

//设置常量
function setOaDocumentCatalogPara(obj){
	 obj.className  = "oaDocumentCatalog";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 		= new Tree(obj.treebox); 
	 
}

//获得树信息
function getOaDocumentCatalogTree(obj){
	obj_tree = obj.tree.dhtmlTree;	
	obj_tree.enableCheckBoxes(false);
	obj_tree.enableItemEditor(false);
	obj_tree.enableDragAndDrop(false);
	obj_tree.setOnClickHandler(doOnSelectGetRes);
	//加载数据
	obj.reset();
	obj.obj.parentId = 0;
	obj.getDocumentTreeXML(oaDocument.IdPrefix,user.obj.id);
	obj_tree.loadXMLString(obj.tree.treeXML);
}

//获得列表
function getOaDocumentFileTable(oaDocumentFile){
	oaDocumentFile.getOaDocumentFiles();  
}

//动作填充 
function button_add_new_obj(type){

	if(type == 1){
		oaDocumentFile.addNewRow('new',null);
	}
}

//翻页处理
function goNextPage(pageIndex,pageInfoName){
	
	if(pageInfoName == oaDocumentFile.pageInfo){
		var page = new Page(oaDocumentFile.pageInfo,oaDocumentFile.pageSize);
		page.goNextPage(pageIndex);
		oaDocumentFile.page = page;
		getOaDocumentFileTable(oaDocumentFile);
	}
}

//点击文档并显示
function doOnSelectGetRes(itemId){
	var selectedNodeType = oaDocumentCatalog.tree.dhtmlTree.getUserData(itemId,"type");
	
	oaDocumentCatalog.tree.setCurSelectItemId(oaDocumentCatalog.IdPrefix);
		
	if(selectedNodeType!=1){
		oaDocumentFile.obj.documentId = null;
		oaDocumentFile.getOaDocumentFiles(oaDocumentFile);
	}else{
		var id = oaDocumentCatalog.tree.getIdByPrefix(itemId,oaDocument.IdPrefix);
		oaDocument.obj.documentCatalogId = id;
		oaDocument.getOaDocument(id);
		$("documentId").value = oaDocument.obj.id;
		
		oaDocumentFile.obj.documentId = id;
		oaDocumentFile.getOaDocumentFiles(oaDocumentFile);
	}
}

//清空
function resetDocument(){
	oaDocument.reset();
	DWRUtil.setValues(oaDocument.obj);
	$("documentId").value = null;
}


//新添
function addOaDuocument_documentFile(){
	resetDocument();
	oaDocumentFile.obj.documentId = $("documentId").value;
	oaDocumentFile.getOaDocumentFiles(oaDocumentFile);
	var catalog = $("Btn_save_document");
	catalog.setAttribute("mode","new");
}

//点击表格保存按纽时激发的事件
function saveFile(saveImgTd){
	
	var mode = saveImgTd.getAttribute("mode");
	var documentId = $("documentId").value;
	
	if(documentId == ""){
		alert("请先保存基本信息!");
	    oaDocumentFile.reset();
		oaDocumentFile.obj.documentId = $("documentId").value;
		oaDocumentFile.getOaDocumentFiles(oaDocumentFile);
	}else{
		oaDocumentFile.obj.documentId = documentId;
		
	    save_file();
		oaDocumentFile.saveOaDocumentFile(oaDocumentFile,mode);
	    
		oaDocumentFile.reset();
		oaDocumentFile.obj.documentId = documentId;
		oaDocumentFile.getOaDocumentFiles();
	}

}


function save_file(){
         alert(0);
       	 $('uploadForm').submit();
        // startProgress('file','save');
}

//点击表格取消按纽时激发的事件
function cannelFile(event){
	var documentId = oaDocument.obj.id;
	
	oaDocumentFile.reset();
	oaDocumentFile.obj.documentId = documentId;
	oaDocumentFile.getOaDocumentFiles();
}

//保存
function saveOaDuocument_documentFile(){
    var catalog = $("Btn_save_document");
   	var mode = catalog.getAttribute("mode");
   	
   	oaDocument.obj.documentCatalogId = getDocumentCatalogId();
   	var documentId = oaDocument.saveDocument(oaDocument,mode);
   	   	
    //把document插入树
    var newItemId = oaDocument.IdPrefix + documentId;
    var newItemLabel = $("title").value;

    if(mode == 'new') insertNewItemToTree(newItemId,newItemLabel);
    if(mode != 'new') oaDocumentCatalog.tree.dhtmlTree.setItemText(newItemId,newItemLabel,"");
    
    if(documentId != null) {
    	//清空表格
	    oaDocumentFile.reset();
		oaDocumentFile.obj.documentId = $("documentId").value;
		oaDocumentFile.getOaDocumentFiles(oaDocumentFile);
		
    	alert('保存成功！!');
    	catalog.setAttribute("mode","edit");
    	$("documentId").value = documentId;
    }
}

//将文档插入到目录树中
function insertNewItemToTree(newItemId,newItemLabel){
	var tree = oaDocumentCatalog.tree.dhtmlTree;
	var parentId = oaDocumentCatalog.IdPrefix + getDocumentCatalogId();

	var img = "book.gif";
	var imgopen = "books_open.gif";
	var imgClose = "books_close.gif";
	var rootId = 0;
	
	oaDocumentCatalog.tree.insertNewItem(parentId,newItemId,newItemLabel,img,imgopen,imgClose,rootId);
	tree.setUserData(newItemId,"type",1);
}

//获得目录id;
function getDocumentCatalogId(){
	var selectedItemId = oaDocumentCatalog.tree.dhtmlTree.getSelectedItemId();
	var nodeType = oaDocumentCatalog.tree.dhtmlTree.getUserData(selectedItemId,"type");
	var documentCatalogId = null;
	
	//如果是文档节点，则取父节点
	if(nodeType == 1){
		var parentId = oaDocumentCatalog.tree.dhtmlTree.getParentId(selectedItemId);
		documentCatalogId = oaDocumentCatalog.tree.getIdByPrefix(parentId,oaDocumentCatalog.IdPrefix);
	}else{
		documentCatalogId = oaDocumentCatalog.tree.getIdByPrefix(selectedItemId,oaDocumentCatalog.IdPrefix);
	}	
	return documentCatalogId;
}


