
var compages = new Compages();
var priceDetail = new PriceDetail();
var carrierType = new CarrierType();
var resource = new Resource();
var carrier = new Carrier();
var price = new Price();
var resourceSort = new ResourceSort();
var priceType = new PriceType();
var tvNameParam = 0;
var orgId =1;
var ctxPath;

var org = new SysOrg();


callOnLoad(init);	


function init(){
	
    ctxPath =  _app_params.ctxPath;	 	
	tvNameParam =  _app_params.sysParam.tvNameParam;
	config_serviceDate = _app_params.serviceDate.def;
	
	_make_adrm_sys_year_select("resource_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);
	
	$("resource_year").value = _app_params.serviceDate.year;	
	
	orgId =  getParamFromUrl(window.location.href,"orgId");
	config_useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
	config_autoPriceTypeParam =  _app_params.sysParam.autoPriceTypeParam;
	config_useLanmuSingleParam= _app_params.sysParam.useLanmuSingleParam;
		

	setPriceDetailPara(priceDetail);
	setCompagesPara(compages);
	setCarrierTypePara(carrierType);
	setResourcePara(resource);
	setCarrierPara(carrier);
	setPricePara(price);	
	
	   _make_org_select("orgId",120,"onOrgChange");	
	   
	   

		
		if(orgId > 0) $("orgId").value = orgId;	
		
		
		
		function onchangeResourceSort(){
			
			getCarrierTypeTree(carrierType);
			getCompagesTree(compages);	
		}
		
		
		if(config_useLanmuSingleParam == 0) $("resourceSortId").hide();

		resourceSort.makeSelectFromMap5("resourceSortId","80","reLoadTree",onchangeResourceSort);	
		


		priceType.makeSelectFromMap(priceType.obj,"resourcePriceType","90",null,function(){
			
//		var value = getSelectIndexByValu3($("resourcePriceType"),"paramvalue",'A');
            if(config_autoPriceTypeParam > 0)$("resourcePriceType").value = config_autoPriceTypeParam;
//			if(value > 0){
//				$("resourcePriceType").value = value;
//			}else{
//				$("resourcePriceType").value = config_autoPriceTypeParam;
//			}
		
	});	
		
//	function callBackFun(){
//		
//		if(config_useMoreCarrierSortParam == 0|| $('orgId').options.length<2){$('orgId_td').hide();}		
//		
//		if(orgId > 0) $("orgId").value = orgId;
//		
//		getCarrierTypeTree(carrierType);
//		
//		getCompagesTree(compages);
//	}	
//
//		org.makeSelect(org.obj,"orgId","onOrgChange",callBackFun);	

	
	buttonEventFill();
	
	resetHeigth();
}


function onOrgChange(){
	orgId = $("orgId").value;

	reLoadTree();
}

function buttonEventFill(){
	var Btn_add = $("Btn_addCompages");
	Btn_add.onclick = addCompages;  
	
	var Btn_save = $("Bt_Save");
	Btn_save.onclick = saveCompagesResourceRel;
	
	var Btn_del = $("Bt_Delete");
	Btn_del.onclick = delAllRel;
	
	var change_resource_year = $("resource_year");
	change_resource_year.onchange = reLoadTree;
	
	
	
//	var Btn_radiobutton1 = $("radiobutton1");
//	Btn_radiobutton1.onclick = select_reeResType;
//	
//	var Btn_radiobutton2 = $("radiobutton2");
//	Btn_radiobutton2.onclick = select_reeResType;	
	
}

function select_reeResType(){
	var url = ctxPath + 'resources.html'
	var btn_radiobutton1 = $("radiobutton1");

	if(btn_radiobutton1.checked == false){
		url= ctxPath +'compages.html?orgId='+$("orgId").value;

	}
    window.location.href = url;

}


function resetHeigth(){
	
	

	
	
   	var dialogcontent = $("dialogcontentDiv");
    var treebox = $("compagesTreebox");
    
    var resTreeBox = $("carrierTypeTreebox");
    
    var Btn_addCompages = $("Btn_addCompages");
    var v = Btn_addCompages.offsetHeight*3;
//    treebox.style.height = dialogcontent.offsetHeight -(dialogcontent.offsetTop - treebox.offsetTop) - v +"px";	
    treebox.style.height = dialogcontent.offsetHeight*0.75 +"px";	
    
    resTreeBox.style.height = treebox.style.height;
//     if(config_signCompages == 1){
//     	resTreeBox.style.height = treebox.offsetHeight*0.96 + "px";   	
//     }else{
//     	resTreeBox.style.height = treebox.offsetHeight*0.94 + "px";   	
//     }
    
    
     var manin_body = $("manin_body");
	manin_body.style.height =  resTreeBox.style.height;   
	
	$('radiobutton2').defaultChecked= true;
    
} 
 
 
function reLoadTree(){
	compages.tree.dhtmlTree.deleteChildItems(0);
	getCompagesTree(compages);
	carrierType.obj.orgId =orgId ;
	carrierType.tree.dhtmlTree.deleteChildItems(0);
	getCarrierTypeTree(carrierType);
}
function setPriceDetailPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 obj.className = "priceDetail";	
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.fillObjName = obj.className + "Body";
	 obj.tableName =  "priceDetailList";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.pageInfo 	= "pageInfo" + obj.className;
	 obj.pageSize 	= "14";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}

function setCompagesPara(obj){
	 obj.className  = "compages";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 		= new Tree(obj.treebox); 
}
function setCarrierTypePara(obj){
	 obj.className  = "carrierType";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 		= new Tree(obj.treebox); 
}
function setResourcePara(obj){
	 obj.className  = "resource";
	 obj.IdPrefix 	= obj.className + "Id";
}
function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
}
function setPricePara(obj){
	 obj.className  = "price";
	 obj.IdPrefix 	= obj.className + "Id";
}
function getCompagesTree(obj){
	var obj_tree = obj.tree.dhtmlTree;	
	obj_tree.enableCheckBoxes(false);
//	obj_tree.enableItemEditor(false);
	obj_tree.enableDragAndDrop(false);
	obj_tree.setOnClickHandler(doOnSelectGetRes);
	obj.reset();
	obj.obj.parentId = 0;
	obj.obj.version= $("resource_year").value;
	obj.obj.orgId = orgId;
	obj.obj.mediaorgId = $("resourceSortId").value;
	
	obj.getTreeXML(resource.IdPrefix);
	obj_tree.loadXMLString(obj.tree.treeXML);
}
function getCarrierTypeTree(obj){
	var obj_tree = obj.tree.dhtmlTree;	
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.enableItemEditor(false);
	obj_tree.enableDragAndDrop(false);
	obj.reset();
	
	carrierType.obj.parentId = 0;
	carrierType.obj.orgId = orgId ;
	
	if(tvNameParam == 'fztv'){
		carrierType.obj.enable = 1;
		carrierType.obj.nodeLevel = 3;  
	}
//	obj.obj.parentId = 0;
//	obj.getTreeXML(carrier.IdPrefix,resource.IdPrefix);
//	obj_tree.loadXMLString(obj.tree.treeXML);


	var getxml = function(strXML){
		obj_tree.loadXMLString(strXML);
	}
	obj.getTreeXMLByYear(carrier.IdPrefix,resource.IdPrefix,$("resource_year").value,getxml);
}

function getPriceDetailTable(priceDetail){
	priceDetail.getPriceDetails();
}
//动作填充 
function button_add_new_obj(type){
	var selectedItemId = compages.tree.dhtmlTree.getSelectedItemId();

	if(selectedItemId == 'root'){
		alert("根节点不能添加");
		return false;
	}
	
//	if(selectedItemId == -1){
//		alert("请先保存组合方案");
//		return false;
//	}
	
	if(type == 1){
		priceDetail.addNewRow('new',null);
		
		$("priceDetailId").value = 0;
		
		$("length").value = null;
		$("price").value = null;
	}
}

function editPriceDetail(editImg){
//	var e = event || window.event;
//	var editImg = Event.element(e);

	var id = editImg.getAttribute("paraId"); 

	$("priceDetailId").value = id;

	var editRow = $(priceDetail.IdPrefix + id);
	priceDetail.addNewRow("edit",editRow);
}

//翻页处理
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == priceDetail.pageInfo){
		var page = new Page(priceDetail.pageInfo,priceDetail.pageSize);
		page.goNextPage(pageIndex);
		priceDetail.page = page;
		getPriceDetailTable(priceDetail);
	}
}	

function doOnSelectGetRes(itemId){
	var obj_tree = compages.tree.dhtmlTree;
	var newItemId = compages.tree.newItemId;
	var nodeType = obj_tree.getUserData(itemId,"type");
	

	
//	var priceId = compages.obj.priceId;

//	if(itemId == 'root'){
//		resetAll();
//	}
	//控制根节点；
	compages.tree.disableRootEdit();
	
	//设置目录ID
	compages.tree.setCurSelectItemId(compages.IdPrefix);
	var compagesId = compages.tree.curSelectItemId;
	
	if(itemId == -1){
		$("packagePriceId").value = 0;
	}
	var priceId = obj_tree.getUserData(itemId,"priceId");
	var priceTypeId = obj_tree.getUserData(itemId,"priceTypeId");

	priceId = priceId == "undefined" ?0:priceId;
	
	
	
	$("packagePriceId").value = priceId;
	
    $("resourcePriceType").value = priceTypeId; 
	
	if(itemId != newItemId){
		if(obj_tree.getLevel(newItemId)!=0){
			if(confirm("Do you want to save changes?")){
				obj_tree.selectItem(newItemId,false);

					saveCompagesResourceRel();

				return;
			}
			obj_tree.deleteItem(newItemId);
		}
	}else{
		obj_tree.setItemColor(itemId,"red","pink");
	}
		
	if(itemId != 'root' && itemId != newItemId && nodeType == 1){
		
		var callback =function(o){
				var isAutoPrice = o.isAutoPrice;
				var enable = o.enable;
				
				$("isAutoPrice").checked = isAutoPrice;
				$("enable").checked = enable;
		
				$("packageName").value = o.name;
				$("packageId").value = compagesId;
				priceDetail.getPriceDetailsByCompagesId(compagesId);
		
//				var resArrays = resource.getResourcesByCompagesId(compagesId);
				loadResource();  
		}
		compages.getCompage(compagesId,callback);
	}
}
//装载资源
function loadResource(){
	
	var ids = resource.getResourcesByCompagesId($("packageId").value );
	carrierType.tree.loadDataTreeArray1(resource.IdPrefix,ids);
}

function cannelAddandEdit(){
	var id = $("packageId").value;
	var id = (id == '')?0:id;
	priceDetail.getPriceDetailsByCompagesId(id);
}

function savePriceDetailByPar(mode,priceDetailId,compagesId,length,relPrice){

	var obj_tree = compages.tree.dhtmlTree;
	
	var saveFun = function(detailId){
		
		$("priceDetailId").value = detailId;
		priceDetail.getPriceDetailsByCompagesId(compagesId);
	}

	var func = function(priceId){
		$("packagePriceId").value = priceId;
		
		var newItemId = compages.IdPrefix + compagesId;
		
		priceDetail.obj.id = priceDetailId;
		priceDetail.obj.priceId = priceId;
		priceDetail.obj.length = length;
		priceDetail.obj.price = relPrice; 
		priceDetail.obj.version = $("resource_year").value;
		priceDetail.savePriceDetail(priceDetail.obj,mode,saveFun);
		
		obj_tree.setUserData(newItemId,"priceId",priceId);
		obj_tree.setUserData(newItemId,"priceTypeId",$("resourcePriceType").value);
	}
	
	var mode1;
	
	if($("packagePriceId").value == 0){
		mode1 = 'new';
	}else{
		mode1 = 'edit';
	}
		
	
	price.reset();
	price.obj.name = $("packageName").value;
	price.obj.compages = (new Compages()).obj;
	price.obj.compages.id = compagesId;
	price.obj.resourcePriceType = $("resourcePriceType").value;
	price.obj.isDefault = true;
	price.obj.id = $("packagePriceId").value == "undefined" ?0:$("packagePriceId").value;
	price.obj.version = $("resource_year").value;
	price.savePriceByCompage(price,mode1,func);
}

function savePriceDetail(event){
	var compagesId = $("packageId").value;
	var e = event || window.event;

	var saveImgTd = Event.element(e);	

	var mode = saveImgTd.getAttribute("mode");
	var priceDetailId = saveImgTd.getAttribute("paraId");


	if(compagesId == ''){
		saveCompagesResourceRel();
	}else{
		savePriceDetailByPar(mode,priceDetailId,compagesId,$("length").value,$("price").value);
	}}

function delPriceDetail(deleImg){
	var compagesId = $("packageId").value;
	
	var id = deleImg.getAttribute("paraId"); 
	var delRow = deleImg.parentNode.parentNode;

	priceDetail.removePriceDetail(id,delRow);

	var pageIndex = priceDetail.page.getPageIndex();
	var curRow = priceDetail.tBody.rows.length;
	
	var priceId = $("packagePriceId").value == "undefined" ?0:$("packagePriceId").value;

	if(pageIndex == 1 && curRow == 0){
		
		var func = function(){
			$("packagePriceId").value = 0;
		}
		
		price.removeCompagesPrice(priceId,func);
	}
	
	priceDetail.getPriceDetailsByCompagesId(compagesId);
}

function saveCompagesResourceRel(){
	
	var obj_tree = compages.tree.dhtmlTree;
	var compagesId = compages.tree.getSelectedItemId(compages.IdPrefix);
	var compageResources = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
	var priceDetailId = $("priceDetailId").value;
	var mode;  
	
	if(priceDetailId == 0){
		mode = 'new';
	}else{
		mode = 'edit';
	}
	
	if(compageResources == null) compageResources = [];

	var state = checkEditState("btn_SaveImgTd");

	if(compagesId == ''){
		var saveFun = function(id){
			doUpdateItemCompages(id);
			$("packageId").value = id;
			$("packageName").value = compages.obj.name;
//			insertResourceToCompagesTree(id,compageResources);
//			reLoadTree();   
			
			loadResource;
			
			var compId = compages.IdPrefix + id;
			obj_tree.selectItem(compId,true);
			
			if(state){
				var length = $("length").value;
				var relPrice = $("price").value;
				savePriceDetailByPar('new',priceDetailId,id,length,relPrice);
			}else{
				$("packagePriceId").value = 0;				
			}
		}
		
		DWRUtil.getValues(compages.obj);
		
		
		
		compages.obj.orgId = orgId;
		compages.obj.version = $("resource_year").value;
		compages.obj.resources = compageResources;
		compages.obj.id = null;
		compages.obj.name = $("packageName").value;
		compages.obj.mediaorgId = $("resourceSortId").value;

		compages.obj.priceId = $("packagePriceId").value == "undefined" ?0:$("packagePriceId").value;

		compages.saveCompagesAndResourceRel(compages.obj,saveFun);
		
	}else{
	
		var saveFun = function(id){ 
			doUpdateItemCompages(id);
			
//			insertResourceToCompagesTree(id,compageResources);
//			reLoadTree();
			loadResource;
			var compId = compages.IdPrefix + id;
			obj_tree.selectItem(compId,true);
			
			if(state){
				var length = $("length").value;
				var relPrice = $("price").value;
				savePriceDetailByPar(mode,priceDetailId,id,length,relPrice);
			}
		}
		compages.obj.version = $("resource_year").value;
		compages.obj.resources = compageResources;
		compages.obj.id = compagesId;
		compages.obj.name = $("packageName").value;	
		DWRUtil.getValues(compages.obj);
		compages.obj.priceId = $("packagePriceId").value == "undefined" ?0:$("packagePriceId").value;
		compages.obj.orgId = orgId;
			
		compages.saveCompagesAndResourceRel(compages.obj,saveFun);
		
	}

}
//将资源插入到套播树中
function insertResourceToCompagesTree(compagesId,compageResources){
	var obj_tree = compages.tree.dhtmlTree;
//	alert("compagesId---"+compagesId);
	//先删除所有的,再插入
	obj_tree.deleteChildItems(compages.IdPrefix + compagesId);

	//把resource插入树
	for(var i=0;i<compageResources.length;i++){

		var resourceId = compageResources[i];
		var res = resource.getResource(resourceId);

	    
	    var newItemId = resource.IdPrefix + resourceId;
		//var name = carrierType.tree.dhtmlTree.getUserData(newItemId,"name");
	    var newItemLabel = res.memo;

		insertNewItemToTree(newItemId,newItemLabel,compagesId);
	
	}
}
//给树设置属性
function doUpdateItemCompages(id){
	var obj_tree = compages.tree.dhtmlTree;
	var newId = compages.IdPrefix + id;
	var name = compages.obj.name;
	
	obj_tree.changeItemId(obj_tree.getSelectedItemId(),newId);
    obj_tree.setUserData(newId,"id",id);
	obj_tree.setItemText(newId,name);
	obj_tree.setUserData(newId,"type",1);
	obj_tree.setItemColor(newId,"black","white");
}

function insertNewItemToTree(newItemId,newItemLabel,compagesId){
	var tree = compages.tree.dhtmlTree;
	var parentId = compages.IdPrefix + compagesId;
		
	var img = "book.gif";
	var imgopen = "books_open.gif";
	var imgClose = "books_close.gif";
	var rootId = 0;
	
	compages.tree.insertNewItem(parentId,newItemId,newItemLabel,img,imgopen,imgClose,rootId);
	tree.setUserData(newItemId,"type",2);
	tree.setUserData(newItemId,"name",2);
}


function delAllRel(){
	
	var compagesId = $("packageId").value;
	var priceId = $("packagePriceId").value == "undefined" ?0:$("packagePriceId").value;

	
	if(compagesId == ''){
		alert("根节点不允许删除");
		return false;
	}
	
	var func = function(){
		compages.tree.removeNodeItem(compages.IdPrefix + compagesId);
	}
	var obj_tree = compages.tree.dhtmlTree;
	var newItemId = compages.tree.newItemId;

	if(obj_tree.getSelectedItemId() != newItemId){
		if(!confirmDelete('Compages')) return false;
		compages.removeCompages(compagesId,priceId,func);
	}
}

function resetAll(){
	$("packageId").value = null;
	$("packageName").value = null;
	
	priceDetail.getPriceDetailsByCompagesId(0);
	
	$("isAutoPrice").checked = false;
	
	carrierType.tree.refreshTree();
}

//添加
function addCompages(event){
	resetAll();
	var obj_tree = compages.tree.dhtmlTree;
	var newItemId = compages.tree.newItemId;
	var newItemLabel = compages.tree.newItemLabel;
	//选择根节点
	var selectedId = compages.tree.getSecondNodeId();
	
	$("packageName").value = newItemLabel;
	compages.obj.name = newItemLabel;
	compages.obj.id = 0;
	compages.obj.isAutoPrice = 0;
	compages.obj.enable = 0;
		compages.obj.orgId = orgId;
	obj_tree.insertNewItem(selectedId,newItemId,newItemLabel,"","book.gif","books_open.gif","books_close.gif","SELECT,CALL",0);
	
	obj_tree.setUserData(newItemId,"type",2);
}

