 
 //实例化对象
 var oaDocument = new OaDocument();
 var oaDocumentCatalog = new OaDocumentCatalog();
 var user = new User();
 var oaDocumentFile = new OaDocumentFile();

 callOnLoad(init);

function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var treebox = $("oaDocumentCatalogTreebox");
//    var Btn_addCatalogChild = $("Btn_addCatalogChild");
    var v = treebox.offsetHeight*0.07;
    treebox.style.height = dialogcontent.offsetHeight -(dialogcontent.offsetTop - treebox.offsetTop) - v +"px";	   	
} 
	
 function init(){
 	
	buttonEventFill();
	
 	user.obj = user.getCurrentUser();
	
    setUserPara(user);
    
 	setOaDocumentFilePara(oaDocumentFile); 	//设置常量
	getOaDocumentFileTable(oaDocumentFile); //获得表
 	
 	setOaDocumentPara(oaDocument); 	//设置常量
	getOaDocumentTable(oaDocument); //获得表
	
 	setOaDocumentCatalogPara(oaDocumentCatalog);	//设置常量
	getOaDocumentCatalogTree(oaDocumentCatalog); 	// 获得树	
	
	resetHeigth();
}

//动作填充
function buttonEventFill(){	
	//添加
	var Btn_add_document = $("Btn_add_document");
	Btn_add_document.onclick = addOaDuocument_documentFile;
	
	var btn_SaveImgTd = $("addNewDocument");
	btn_SaveImgTd.onclick = addOaDuocument;
	
	//保存
	var Btn_save_document = $("Btn_save_document");
	Btn_save_document.onclick = saveOaDuocument_documentFile;

	//取消编辑
	var Btn_cancel_Edit = $("Btn_cancel_Edit");
	Btn_cancel_Edit.onclick = cannelEdit;
	
	
	
//	var Btn_delete = $("Btn_delete");
//	Btn_delete.onclick = deleteDocumentAndFile;
}

//设置常量
function setUserPara(obj){
	 obj.className 	= "user";
	 obj.IdPrefix 	= obj.className + "Id";
}

//设置常量
function setOaDocumentFilePara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className  = "oaDocumentFile";	
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.tableName   = obj.className +"Table";
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
	 obj.fillObjName = obj.className +"Body";
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

function showDocumentForm(bln){
  if(bln){
	$("oaDocumentList").hide();
	$("oaDocumentForm").show();  	
  }else{
	$("oaDocumentList").show();
	$("oaDocumentForm").hide();  	
  }
}

function onSubmitDocument(){
	if ($("title").value ==""){alert("标题不能为空");return false;}
	if ($("documentCode").value ==""){alert("文档编号不能为空");return false;}
	if ($("memo").value ==""){alert("备注不能为空");return false;}	
	return true;
}

function addOaDuocument(){
	var selectedItemId = oaDocumentCatalog.tree.dhtmlTree.getSelectedItemId();
	var nodeType = oaDocumentCatalog.tree.dhtmlTree.getUserData(selectedItemId,"type");

	if(nodeType == 0){alert("请先选择目录节点");return false;}
	
	resetDocument();
	oaDocumentFile.obj.documentId = $("documentId").value;
	oaDocumentFile.getOaDocumentFiles(oaDocumentFile);
	showDocumentForm(true);
	
	var btn = $("Btn_save_document");
	btn.setAttribute("mode","new");
}

function editDocument(editImg){
	var documentId = editImg.getAttribute("paraId"); 
	oaDocument.getOaDocument(documentId);
	
	oaDocumentFile.reset();
	oaDocumentFile.obj.documentId = documentId;
	oaDocumentFile.getOaDocumentFiles();

	showDocumentForm(true);
	var btn = $("Btn_save_document");
	btn.setAttribute("mode","edit");
}

//动作填充 
function button_add_new_obj(type){

	if(type == 1){
		oaDocumentFile.addNewRow('new',null);
	}
}

//新添
function addOaDuocument_documentFile(){
	resetDocument();
	oaDocumentFile.obj.documentId = $("documentId").value;
	oaDocumentFile.getOaDocumentFiles(oaDocumentFile);
	var catalog = $("Btn_save_document");
	catalog.setAttribute("mode","new");
}

//保存
function saveOaDuocument_documentFile(){
   	  
   	var state = checkEditState("btn_SaveImgTd");  
	
	var isPass = onSubmitDocument();if(!isPass) return false;
	
    var catalog = $("Btn_save_document");
   	var mode = catalog.getAttribute("mode");
   	
   	oaDocument.obj.documentCatalogId = getDocumentCatalogId();
   	
//   	alert(state);
   	if(state){
//   		alert(0);
   		saveFile();
   	}else{

//	   	var documentId = oaDocument.saveDocument(oaDocument,mode,saveFun);
//	   	   	alert(documentId);
//	    //把document插入树
//	    var newItemId = oaDocument.IdPrefix + documentId;
//	    var newItemLabel = $("title").value;
//	
//	    if(mode == 'new') insertNewItemToTree(newItemId,newItemLabel);
//	    if(mode != 'new') oaDocumentCatalog.tree.dhtmlTree.setItemText(newItemId,newItemLabel,"");
//	    
//	    if(documentId != null) {
//	    	//清空表格
//		    oaDocumentFile.reset();
//			oaDocumentFile.obj.documentId = $("documentId").value;
//			oaDocumentFile.getOaDocumentFiles(oaDocumentFile);
//			
//	    	alert('保存成功！!');
//	    	catalog.setAttribute("mode","edit");
//	    	$("documentId").value = documentId;
//	    }
		var saveFun = function(documentId){
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
		oaDocument.saveDocument(oaDocument,mode,saveFun);

   	}    
}

//翻页处理
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == oaDocument.pageInfo){
		var page = new Page(oaDocument.pageInfo,oaDocument.pageSize);
		page.goNextPage(pageIndex);
		oaDocument.page = page;
		getOaDocumentTable(oaDocument);
	}
	if(pageInfoName == oaDocumentFile.pageInfo){
		var page = new Page(oaDocumentFile.pageInfo,oaDocumentFile.pageSize);
		page.goNextPage(pageIndex);
		oaDocumentFile.page = page;
		getOaDocumentFileTable(oaDocumentFile);
	}
}

//清空
function resetDocument(){
	oaDocument.reset();
	DWRUtil.setValues(oaDocument.obj);
	$("documentId").value = null;
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
function getOaDocumentTable(oaDocument){
	oaDocument.getOaDocuments();  
}

//获得列表
function getOaDocumentFileTable(oaDocumentFile){
	oaDocumentFile.getOaDocumentFiles();  
}

function doOnSelectGetRes(itemId){
//	alert(itemId);
	var selectedNodeType = oaDocumentCatalog.tree.dhtmlTree.getUserData(itemId,"type");
//	alert(selectedNodeType);
	if(selectedNodeType == 0 || selectedNodeType == 1){
		showView();
		showDocumentForm(false);
	}else{
		showView();
		showDocumentForm(true);
	}
}

function showView(){
	var selectedItemId = oaDocumentCatalog.tree.dhtmlTree.getSelectedItemId();
//	alert(selectedItemId);
	var nodeType = oaDocumentCatalog.tree.dhtmlTree.getUserData(selectedItemId,"type");

	if(nodeType == 0){
		oaDocument.reset();
		oaDocument.getOaDocuments();
	}
	
	if(nodeType == 1){
    	var oaDocumentCatalogId = oaDocumentCatalog.tree.getIdByPrefix(selectedItemId,oaDocumentCatalog.IdPrefix);
		oaDocument.reset();
		oaDocument.obj.documentCatalogId = oaDocumentCatalogId;	
		oaDocument.getOaDocuments();
	}   

    if(nodeType == 2){
//    	alert(1);
		var id = oaDocumentCatalog.tree.getIdByPrefix(selectedItemId,oaDocument.IdPrefix);
//		alert("id---"+id)
		oaDocument.getOaDocument(id);
		oaDocument.getOaDocuments();
		
		$("documentId").value = oaDocument.obj.id;
		oaDocumentFile.reset();
		oaDocumentFile.obj.documentId = id;
		oaDocumentFile.getOaDocumentFiles();	
    }	
}

//点击表格取消按纽时激发的事件
function cannelFile(event){
	var documentId = oaDocument.obj.id;
	
	oaDocumentFile.reset();
	oaDocumentFile.obj.documentId = documentId;
	oaDocumentFile.getOaDocumentFiles();
}

//点击表格保存按纽时激发的事件
function saveFile(){
	
	var isPass = onSubmitDocument();if(!isPass) return false;
	
    var catalog = $("Btn_save_document");
    
    var docId = $("documentId").value;
    
   	var mode = catalog.getAttribute("mode");
    
    if(docId == ''){
		var saveFun = function(documentId){
		    //把document插入树
		    var newItemId = oaDocument.IdPrefix + documentId;
		    var newItemLabel = $("title").value;
		
		    if(mode == 'new') insertNewItemToTree(newItemId,newItemLabel);
		    if(mode != 'new') oaDocumentCatalog.tree.dhtmlTree.setItemText(newItemId,newItemLabel,"");
	
			oaDocumentFile.obj.fileName = $("name").value;
			oaDocumentFile.obj.filePath = "./resources/" + user.obj.username + "/" + subStringPath($("file").value);
		    save_file();
		    DWRUtil.getValues(oaDocumentFile.obj);
		    oaDocumentFile.obj.documentId = documentId;
			oaDocumentFile.saveOaDocumentFile(oaDocumentFile,mode);
			
			oaDocumentFile.reset();
			oaDocumentFile.obj.documentId = documentId;
			oaDocumentFile.getOaDocumentFiles();
			
			$("documentId").value = documentId;
	
		}
	
	   	oaDocument.obj.documentCatalogId = getDocumentCatalogId();
	   	oaDocument.saveDocument(oaDocument,mode,saveFun);
    }else{
    		var documentId = $("documentId").value;
    		;
			oaDocumentFile.obj.fileName = $("name").value;
			oaDocumentFile.obj.filePath = "./resources/" + user.obj.username + "/" + subStringPath($("file").value);
		    save_file();
		    DWRUtil.getValues(oaDocumentFile.obj);
		    oaDocumentFile.obj.documentId = documentId;
			oaDocumentFile.saveOaDocumentFile(oaDocumentFile,mode);
			
			oaDocumentFile.reset();
			oaDocumentFile.obj.documentId = documentId;
			oaDocumentFile.getOaDocumentFiles();
    }
    
    
//   	var mode = catalog.getAttribute("mode");
//
//	var saveFun = function(documentId){
//	    //把document插入树
//	    var newItemId = oaDocument.IdPrefix + documentId;
//	    var newItemLabel = $("title").value;
//	
//	    if(mode == 'new') insertNewItemToTree(newItemId,newItemLabel);
//	    if(mode != 'new') oaDocumentCatalog.tree.dhtmlTree.setItemText(newItemId,newItemLabel,"");
//
//		oaDocumentFile.obj.fileName = $("name").value;
//		oaDocumentFile.obj.filePath = "./resources/" + user.obj.username + "/" + subStringPath($("file").value);
//	    save_file();
//	    DWRUtil.getValues(oaDocumentFile.obj);
//	    oaDocumentFile.obj.documentId = documentId;
//		oaDocumentFile.saveOaDocumentFile(oaDocumentFile,mode);
//		
//		oaDocumentFile.reset();
//		oaDocumentFile.obj.documentId = documentId;
//		oaDocumentFile.getOaDocumentFiles();
//
//	}
//
//   	oaDocument.obj.documentCatalogId = getDocumentCatalogId();
//   	oaDocument.saveDocument(oaDocument,mode,saveFun);
}

function subStringPath(path){
	var pos = path.lastIndexOf('\\');
	var relPath = path.substring(pos+1,path.length);
	return relPath;
}

function save_file(){
       	 $('uploadForm').submit();
        // startProgress('file','save');
}

//点击表格删除按纽时激发的事件
function delDocument(deleImg){
	var id = deleImg.getAttribute("paraId"); 
	var delRow = deleImg.parentNode.parentNode;
	
	var isAgree = oaDocument.removeOaDocument(id,delRow);
	
	if(isAgree){
		oaDocumentCatalog.tree.removeNodeFromTree(id,oaDocument.IdPrefix);
	}
}

function cannelEdit(){
	showDocumentForm(false);
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
	tree.setUserData(newItemId,"type",2);
}

//获得目录id;
function getDocumentCatalogId(){
	var selectedItemId = oaDocumentCatalog.tree.dhtmlTree.getSelectedItemId();
	var nodeType = oaDocumentCatalog.tree.dhtmlTree.getUserData(selectedItemId,"type");
	var documentCatalogId = null;
	
	//如果是文档节点，则取父节点
	if(nodeType == 2){
		var parentId = oaDocumentCatalog.tree.dhtmlTree.getParentId(selectedItemId);
		documentCatalogId = oaDocumentCatalog.tree.getIdByPrefix(parentId,oaDocumentCatalog.IdPrefix);
	}else{
		documentCatalogId = oaDocumentCatalog.tree.getIdByPrefix(selectedItemId,oaDocumentCatalog.IdPrefix);
	}	
	return documentCatalogId;
}

//function deleteDocumentAndFile(){
//	
//}






