
var orderCategory = new OrderCategory();
var org = new SysOrg();


var loginUser;
var obj_tree;


callOnLoad(init);	
 
function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var treebox = $("orderCategoryTreebox");
    var Btn_add = $("Btn_add");
    
    var v = Btn_add.offsetHeight*2.5;
    treebox.style.height = dialogcontent.offsetHeight -(dialogcontent.offsetTop - treebox.offsetTop) - v +"px";	
    
} 
 
 function init(){

	ctxPath = _app_params.ctxPath;	
	loginUser =  _app_params.user.username;
	loginUserFullName =  _app_params.user.fullName;
	loginUserId =  _app_params.user.id;
	tvNameParam =  _app_params.sysParam.tvNameParam;	
	config_serviceDate = _app_params.serviceDate.def;	
	useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
	
 	
 	setOrderCategoryPara(orderCategory);	//设置常量
 	
 	 _make_org_select("orgId",120,"changeOrgSelect");	

// 	org.makeSelect(org.obj,"orgId","changeOrgSelect",callBackFun);	
 	
// 	function callBackFun(){
 		
 		var orgId = $("orgId").value;
 		
 	_make_adrm_sys_year_select("order_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);
 		
      $("order_year").value =  _app_params.serviceDate.year;
		
		showOrderCategory(true);

//        initOrderCategoryTree();
        
		getOrderCategoryTree();	//获得checkbox
		
		getOrderCategoryTable(); //获得表
		
//		if(useMoreCarrierSortParam == 0|| $('orgId').options.length<2){
//				$('orgId_td').hide();
//		}
//		
//
// 	}
 	
		
		buttonEventFill();
		
		resetHeigth();
}


function changeOrgSelect(){
	
		getOrderCategoryTree();	//获得checkbox
		
		getOrderCategoryTable(); //获得表
}

function buttonEventFill(){
	
	//添加
	var btn_add = $("Btn_add");
	btn_add.onclick =  btn_add_new;
	
	var btn_cancel = $("Btn_cancel_Edit");
	btn_cancel.onclick =  btn_cancel_edit;

	//添加
	var image_add = $("Image_add");
	image_add.onclick =  btn_add_new;
	
	var btn_save = $("Btn_save_orderCategory");
	btn_save.onclick =  save_orderCategory;
	
	var change_order_year = $("order_year");
	change_order_year.onchange = getOrderCategoryTree;
}

//设置常量
function setOrderCategoryPara(obj){
	 obj.className  = "orderCategory";
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


//function initOrderCategoryTree(){
//	obj_tree = orderCategory.tree.dhtmlTree;	
//	obj_tree.enableCheckBoxes(false);
//	obj_tree.enableItemEditor(false);
//	obj_tree.enableDragAndDrop(false);
//	obj_tree.setOnClickHandler(doOnSelectGetRes);
//}

//获得目录树信息
function getOrderCategoryTree(){
	if(!obj_tree){
		obj_tree = orderCategory.tree.dhtmlTree;	
		obj_tree.enableCheckBoxes(false);
		obj_tree.enableItemEditor(false);
		obj_tree.enableDragAndDrop(false);
		obj_tree.setOnClickHandler(doOnSelectGetRes);	
	}

	orderCategory.reset();
	orderCategory.obj.orgId = $("orgId").value;
	orderCategory.obj.parentId = 0;
	orderCategory.obj.version = $("order_year").value;
	
	orderCategory.getTreeXML();
	 if(obj_tree.getSubItems(0) == 'root'){
			obj_tree.deleteChildItems(0);	
	}
	obj_tree.loadXMLString(orderCategory.tree.treeXML);
}

//翻页处理
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == orderCategory.pageInfo){
		var page = new Page(orderCategory.pageInfo,orderCategory.pageSize);
		page.goNextPage(pageIndex);
		orderCategory.page = page;
		
		getOrderCategoryTable(orderCategory);
	}
}

function getOrderCategoryTable(){
	
	orderCategory.obj.orgId = $("orgId").value;
	orderCategory.obj.version = $("order_year").value;
	orderCategory.getOrderCategorys(orderCategory);
}

function doOnSelectGetRes(itemId){
	var selectItemId = orderCategory.tree.getSelectedItemId(orderCategory.IdPrefix);
	var selectedNodeType = orderCategory.tree.dhtmlTree.getUserData(itemId,"type");
//	alert(selectedNodeType);
	$("category_id").value = selectItemId;
		
	orderCategory.reset();
	
	orderCategory.obj.orgId = $("orgId").value;
	orderCategory.obj.version = $("order_year").value;
	
	if(selectedNodeType == 0){
		orderCategory.obj.parentId = 0;
	}
	if(selectedNodeType == 1){
		orderCategory.obj.parentId = selectItemId;
	}
	if(selectedNodeType >= 2){
		showOrderCategory(true);
		orderCategory.obj.id = $("category_id").value;
		orderCategory.getOrderCategorys(orderCategory);
	}
	if(selectedNodeType < 2){
		showOrderCategory(true);
		orderCategory.getOrderCategorys(orderCategory);
	}
	
	var btn = $("Btn_save_orderCategory");
	btn.setAttribute("mode","edit");
}

function showOrderCategory(bln){
	if(bln){
		$("orderCategoryList").show();
		$("orderCategoryForm").hide();
	}else{
		$("orderCategoryList").hide();
		$("orderCategoryForm").show();
	}
}
function resetOrderCategory(){
	orderCategory.reset();
	$("calculateAuto").value = null;
	$("displayNo").value = null;
	$("name").value = null;
	$("nodeLevel").value = null;
	$("nodePath").value = null;
	$("parentId").value = null;
	$("value").value = null;
	$("category_id").value = null;
}

function editOrderCategory(editImg){
	
	var categoryId = editImg.getAttribute("paraId"); 
	$("category_id").value = categoryId;

	
	orderCategory.getOrderCategory(categoryId);
	showOrderCategory(false);
	
	var btn = $("Btn_save_orderCategory");
	btn.setAttribute("mode","edit");
}

function btn_add_new(){
	 
	 var selectedItemId =  orderCategory.tree.dhtmlTree.getSelectedItemId();
	 var selectedType = orderCategory.tree.dhtmlTree.getUserData(selectedItemId,"type"); 
	 
//	 alert(selectId); alert(selectedItemId);
	 
	 if((selectedType == 0) && loginUser!='admin'){
	 	alert("订单主类别不能新添，只能增加子类别");
	 	return false;
	 }
	
	var selectId = orderCategory.tree.getSelectedItemId(orderCategory.IdPrefix);
	
	resetOrderCategory();
	
	showOrderCategory(false);
	

	if(selectId == ''){
		$("parentId").value = 0;
	}else{
		$("parentId").value = selectId;
	}
	
	var btn = $("Btn_save_orderCategory");
	btn.setAttribute("mode","new");
}

function btn_cancel_edit(){
	var categoryId = $("category_id").value;
	

	
    showOrderCategory(true);
	getListTable(categoryId);
	
	resetOrderCategory();
}
function getListTable(categoryId){
	
    if(categoryId != ''){
    	
    	orderCategory.reset();
    	var id;
    	var parentId = orderCategory.tree.dhtmlTree.getParentId(orderCategory.IdPrefix + categoryId);
		if(parentId == 'root'){
			id = 0;
		}else{
    		id = orderCategory.tree.getIdByPrefix(parentId,orderCategory.IdPrefix);
//    		id = categoryId;
    	}
    	
    	id = categoryId;
//    	alert(categoryId);

		orderCategory.obj.orgId = $("orgId").value;
		
		orderCategory.obj.version = $("order_year").value;
		
//		      alert(orderCategory.obj.orgId);
		
    	orderCategory.obj.parentId = id;
    	
    	orderCategory.getOrderCategorys();
    }
}
function delOrderCategory(deleImg){
//	alert(deleImg);
	
	var id = deleImg.getAttribute("paraId"); 
	var delRow = deleImg.parentNode.parentNode;
	
	var isAgree = orderCategory.removeOrderCategory(id,delRow);
	if(isAgree){
		orderCategory.tree.removeNodeFromTree(id,orderCategory.IdPrefix);
	}
}

function save_orderCategory(){
	
//	var isPass = isCheck(); if(!isPass) return false;
	
    var category = $("Btn_save_orderCategory");
   	var mode = category.getAttribute("mode");
   	var version =  category.getAttribute("version");
   	
	DWRUtil.getValues(orderCategory.obj);
	
//	alert(mode);
//	alert($("category_id").value);
//	orderCategory.reset();
   	orderCategory.obj.id = $("category_id").value;
   	
   	orderCategory.obj.orgId = $("orgId").value;
   	

   	 if(mode == 'new'){
   	 		orderCategory.obj.version = $("order_year").value;
   	 }else{
   	 		orderCategory.obj.version = version;
   	 }
   	
   	var orderCategoryId = orderCategory.saveCategory(orderCategory,mode);
    //把orderCategory插入树
    var newItemId = orderCategory.IdPrefix + orderCategoryId;

    var newItemLabel = $("name").value;
	
    if(mode == 'new') insertNewItemToTree(newItemId,newItemLabel);
    if(mode != 'new') orderCategory.tree.dhtmlTree.setItemText(newItemId,newItemLabel,"");
    
    showOrderCategory(true);
	getListTable(orderCategoryId);
//	category.obj.version = 0;
	
	category.setAttribute("mode","edit");
}
//将文档插入到目录树中
function insertNewItemToTree(newItemId,newItemLabel){
	var tree = orderCategory.tree.dhtmlTree;
	var parentId = tree.getSelectedItemId(orderCategory.IdPrefix);
	
	var nodeType = tree.getUserData(parentId,"type");
//	alert(nodeType)
	var img = "book.gif";
	var imgopen = "books_open.gif";
	var imgClose = "books_close.gif";
	var rootId = 0;
	orderCategory.tree.insertNewItem(parentId,newItemId,newItemLabel,img,imgopen,imgClose,rootId);
	
	tree.setUserData(newItemId,"type",nodeType*1+1);
}

function isCheck(){
	if ($("name").value ==""){alert("名称不能为空");return false;}
	if ($("value").value ==""){alert("参数不能为空");return false;}
	return true;
}


















