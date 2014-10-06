
var sysMenu = new SysMenu();

callOnLoad(init);

function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var treebox = $("sysMenuTreebox");
    var Btn_add = $("Btn_add");
    
    var v = Btn_add.offsetHeight*2.5;
    treebox.style.height = dialogcontent.offsetHeight -(dialogcontent.offsetTop - treebox.offsetTop) - v +"px";	
    
}

function setSysMenuPara(obj){
	 obj.className  = "sysMenu";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tableName   = obj.className +"Table";
	 obj.fillObjName = obj.className +"Body";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.checkBoxName = obj.className +"Check";
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.enableEdit	= true;
	 obj.enableDel	= true;	 
	 obj.pageInfo 	= obj.className +"PageInfo";
	 obj.pageSize 	= "16";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
	 obj.tree 		= new Tree(obj.treebox); 
	 
}

function init(){
	setSysMenuPara(sysMenu);
	getSysMenuTree(sysMenu);
	getSysMenuTable(sysMenu);
	buttonEventFill();
	resetHeigth();
} 

function buttonEventFill(){
	
	//添加
	var btn_add = $("Btn_add");
//	btn_add.setAttribute("href","javascript:void 0");
	btn_add.onclick =  btn_add_new;
	
	var image_add = $("Image_add");
	image_add.onclick =  btn_add_new;
	
	var btn_cancel = $("Btn_cancel_Edit");
	btn_cancel.onclick =  btn_cancel_edit;
	

	var btn_save = $("Btn_save_sysMenu");
	btn_save.onclick =  save_sysMenu;
	
	var btn_load = $("Btn_load_default");
	btn_load.onclick =  load_default;
	
}
function getSysMenuTree(obj){
	obj_tree = obj.tree.dhtmlTree;	
	obj_tree.enableCheckBoxes(false);
	obj_tree.enableItemEditor(false);
	obj_tree.enableDragAndDrop(true);
	obj_tree.setOnClickHandler(doOnSelectGetRes);
	obj_tree.setDragHandler(doOnBeforeDropMenuTree);
	obj.reset();
	obj.obj.parentId = 0;
	obj.getTreeXML();
	obj_tree.loadXMLString(obj.tree.treeXML);
}

function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == sysMenu.pageInfo){
		var page = new Page(sysMenu.pageInfo,sysMenu.pageSize);
		page.goNextPage(pageIndex);
		sysMenu.page = page;
		getSysMenuTable(sysMenu);
	}
}

function getSysMenuTable(sysMenu){
	showSysMenu(true);
	sysMenu.getSysMenus(sysMenu);
}

function resetSysMenu(){
	sysMenu.reset();
	DWRUtil.setValues(sysMenu.obj);
}

function doOnSelectGetRes(itemId){
	var selectItemId = sysMenu.tree.getSelectedItemId(sysMenu.IdPrefix);
	var selectedNodeType = sysMenu.tree.dhtmlTree.getUserData(itemId,"type");
	var isLeaf = (sysMenu.tree.dhtmlTree.getSubItems(itemId) == null || sysMenu.tree.dhtmlTree.getSubItems(itemId) == '');
	$("id").value = selectItemId;
		
	sysMenu.reset();

	if(isLeaf){
		showSysMenu(false);
		getSysMenu(selectItemId);
	}else{
		sysMenu.obj.parentId = selectItemId;
		sysMenu.getSysMenus(sysMenu);
		showSysMenu(true);
	}
	

	var btn = $("Btn_save_sysMenu");
	btn.setAttribute("mode","edit");
}

function btn_add_new(){
//	alert("sdfsdfsdf");
	resetSysMenu();
	showSysMenu(false);
	var selectId = sysMenu.tree.getSelectedItemId(sysMenu.IdPrefix);
	if(selectId == ''){
		$("parentId").value = 0;
	}else{
		$("parentId").value = selectId;
	}
	var btn = $("Btn_save_sysMenu");
	btn.setAttribute("mode","new");
}

function btn_cancel_edit(){
	var sysmenuId = $("id").value;
	
    showSysMenu(true);
	getListTable(sysmenuId);
	
	resetSysMenu();
}

function editSysMenu(editImg){
	
	var sysmenuId = editImg.getAttribute("paraId"); 
	$("id").value = sysmenuId;
	getSysMenu(sysmenuId);
	showSysMenu(false);
	
	var btn = $("Btn_save_sysMenu");
	btn.setAttribute("mode","edit");
	
	var image_add = $("Image_add");
	image_add.onclick =  btn_add_new;
}

function getSysMenu(id){
	var callBackFun = function(obj){
		DWRUtil.setValues(obj);
	}
	sysMenu.getSysMenu(id,callBackFun);
}


function save_sysMenu(){

	DWRUtil.getValues(sysMenu.obj);
	
	if(!isCheck(sysMenu.obj)) return false;
	
	var isNew = (sysMenu.obj.id ==""|| sysMenu.obj.id ==null);
	if(isNew) sysMenu.obj.id ==null;
	var callBackFun = function(id){
		$("id").value = id;
		var newItemId = sysMenu.IdPrefix + id;
		var newItemLabel = $("name").value;
		if(isNew){
			insertNewItemToTree(newItemId,newItemLabel);
		}else{
			sysMenu.tree.dhtmlTree.setItemText(newItemId,newItemLabel,"");
		}
	}
		
	sysMenu.saveSysMenu(sysMenu.obj,callBackFun)
         
}

function load_default(){
    function callBackFun(r){
    	window.location.href = "reload.html";
	    //alert('保存成功！!');
    	//alert(r+"结束");
    }
	sysMenu.saveSysMenuDefault(sysMenu.obj,callBackFun);     
}






function getListTable(id){
    if(id != ''){
    	sysMenu.reset();
    	var parentId = sysMenu.tree.dhtmlTree.getParentId(sysMenu.IdPrefix + id);
    	var id =(parentId == 'root')?0:sysMenu.tree.getIdByPrefix(parentId,sysMenu.IdPrefix);
    	sysMenu.obj.parentId = id;
    	sysMenu.getSysMenus(sysMenu);
    }
}

function insertNewItemToTree(newItemId,newItemLabel){//newItemLabel为页面的 名字 项
	var tree = sysMenu.tree.dhtmlTree;
	var parentId = tree.getSelectedItemId(sysMenu.IdPrefix);
	var nodeType = tree.getUserData(parentId,"type");
//	alert(nodeType)
	var img = "book.gif";
	var imgopen = "books_open.gif";
	var imgClose = "books_close.gif";
	var rootId = 0;
	sysMenu.tree.insertNewItem(parentId,newItemId,newItemLabel,img,imgopen,imgClose,rootId);
	
	tree.setUserData(newItemId,"type",nodeType*1+1);
}


function delSysMenu(deleImg){
	var id = deleImg.getAttribute("paraId"); 
	var delRow = deleImg.parentNode.parentNode;
	
	var isAgree = sysMenu.removeSysMenu(id,delRow);
	if(isAgree){
		sysMenu.tree.removeNodeFromTree(id,sysMenu.IdPrefix);
	}
}


function isCheck(obj){
	if ($("name").value ==""){alert("名称不能为空");return false;}
//	if ($("value").value ==""){alert("参数不能为空");return false;}
//	if (!issafe(sysMenu.obj.name)) return false;
//	if (!issafe(sysMenu.obj.title)) return false;
	return true;
}



function doOnBeforeDropMenuTree(itemId,parentId){
	var tree = sysMenu.tree.dhtmlTree;
	var selectedNodeType = sysMenu.tree.dhtmlTree.getUserData(itemId,"type");
	var selectedNodeParnetType = sysMenu.tree.dhtmlTree.getUserData(parentId,"type");
		
	if(selectedNodeType == 1 && selectedNodeParnetType == 0) return false;
	//Menu 父子关系
	if((selectedNodeType == 1 || selectedNodeType == 2 )&& (selectedNodeParnetType == 0 || selectedNodeParnetType == 1 ||selectedNodeParnetType == 2)){
			sysMenu.obj.id = sysMenu.tree.getIdByPrefix(itemId,sysMenu.IdPrefix);
			var parId= sysMenu.tree.getIdByPrefix(parentId,sysMenu.IdPrefix);
			var id = sysMenu.tree.getIdByPrefix(itemId,sysMenu.IdPrefix);
		    var rootId = sysMenu.tree.getSecondNodeId();
			if (parentId == rootId) parId = 0;
			sysMenu.saveMenuRelation(id,parId);
			
			$("parentId").value = parId;
			tree.setUserData(itemId,"type",selectedNodeParnetType+1);
	}	
	return true;

	
}





function showSysMenu(bln){
	if(bln){
		$("sysMenuList").show();
		$("sysMenuForm").hide();
	}else{
		$("sysMenuList").hide();
		$("sysMenuForm").show();
	}
}