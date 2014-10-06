
var carrier =new  Carrier();
var resource = new Resource();
var carrierType = new CarrierType();
var resourceType = new ResourceType();


var user = new User();
var mode = 0;
var loginUser;
var alisnameType = 0;
var resource_year;
var orgId;
callOnLoad(init);

function init(){
	ctxPath = $("ctxPath").value;
	userId =  getParamFromUrl(window.location.href,"id");
	mode =  getParamFromUrl(window.location.href,"mode");
	loginUser =  getParamFromUrl(window.location.href,"loginUser");
	orgId = getParamFromUrl(window.location.href,"orgId");
	resource_year = getParamFromUrl(window.location.href,"resourceYear");
	config_useCarrierAliname =  getParamFromUrl(window.location.href,"useCarrierAliname");
	config_useCarrierAliname =(config_useCarrierAliname ==''||config_useCarrierAliname =='0'||isUndefined(config_useCarrierAliname))?false:true;
   
	setCarrierTypePara(carrierType);
	setCarrierPara(carrier);
	setUserPara(user);
	setResourcePara(resource);
	resetHeigth();
	
	getCarrierTypeTree(callBakFun);

	function callBakFun(){
			resourceType.obj.orgId = orgId;
			resourceType.obj.version = resource_year;
			resourceType.makeSelectItemAnalyze2(resourceType.obj,"resourceType","loadgetResourceIds",150,3,callBack);
		    function callBack(){
		    	if(mode == '1') loadgetResourceIds();
		    }
	}
	
	buttonEventFill(); 

	
}
function getParentUserIdByURL(){
	var url = window.location.href;
	var startPos = url.indexOf("=");
	var endPos = url.length;
	var id = null;
	id = url.substring(startPos+1,endPos)*1
	return  id;
}
function setCarrierTypePara(obj){
	obj.className  = "carrierType";
	obj.IdPrefix   = obj.className + "Id";
	obj.treebox	   = obj.className + "Treebox";
	obj.tree = new Tree(obj.treebox); 
}
function setResourcePara(obj){
	 obj.className  = "resource";
	 obj.IdPrefix 	= obj.className + "Id";
}
function setCarrierPara(obj){
	obj.className  = "carrier";
	obj.IdPrefix 	= obj.className + "Id";
	obj.selectName = obj.className+"Name";
}
function setUserPara(obj){
	 obj.className ="user";
	 obj.IdPrefix 	= obj.className +"Id";
	 obj.tableName   = obj.className +"Table";
	 obj.fillObjName = obj.className +"Tbody";
	 obj.checkBoxName = obj.className +"Check";
	 obj.obj.address = new Address();
}
function resetHeigth(){
   var treebox = $("carrierTypeTreebox");
   var Btn_saveUserCarrierRel = $("Btn_saveUserCarrierRel");
   var height = window.innerHeight;
   treebox.style.height = height*0.9  +"px";	
//   treebox.style.height = height - Btn_saveUserCarrierRel.offsetHeight*2  + "px";
} 



function getCarrierTypeTree(callBakFun){
	var obj_tree = carrierType.tree.dhtmlTree;	
	obj_tree.setImagePath($F("ctxPath")+"image/tree/");
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.enableItemEditor(false);
	obj_tree.enableDragAndDrop(false);
	obj_tree.setOnClickHandler(doOnSelect);
	obj_tree.enableThreeStateCheckboxes(true);
	
	carrierType.reset();
	carrierType.obj.parentId = 0;
//	carrierType.obj.nodeLevel = 999;
	carrierType.obj.orgId = orgId;

	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	var getxml = function(strXML){	
		carrierType.tree.dhtmlTree.loadXMLString(strXML);
		Ext.getBody().unmask();
		if(callBakFun) callBakFun();
	}

	
	carrierType.getTreeXMLByYear("carrierId","resourceId",resource_year,getxml);
}


function buttonEventFill(){
	var Btn_saveUserCarrierRel = $("Btn_saveUserCarrierRel");	
	Btn_saveUserCarrierRel.setAttribute("href","javascript:void 0");
	Btn_saveUserCarrierRel.onclick = saveResCarrTypeRel;
	
	var Btn_close = $("Btn_close");	
	Btn_close.setAttribute("href","javascript:void 0");
	Btn_close.onclick = closeWin;
	
	var Btn_refresh = $("btn_refresh");	
	Btn_refresh.setAttribute("href","javascript:void 0");
	Btn_refresh.onclick = loadgetResourceIds;	
	
	

	
}
function closeWin(){
	window.top.close();
}





function saveResCarrTypeRel(){ 
   var resIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
   var resourceType =  $("resourceType").value;
   
   if(resIds == null) carrierIds = []; 
   
   var callBackFun = function(){alert("保存成功！");};
   
   resource.saveResCarrTypeRel(resourceType,resIds,callBackFun);
}



function getAllCheckedBranches(IdPrefix){
	var idStr=  carrierType.tree.dhtmlTree.getAllCheckedBranches();
	var type;
	var idsArray = new Array();
	if(idStr.substring(idStr.length-1,idStr.length) == ","){
		idStr = idStr.substring(0,idStr.length-1);
	}
	var ids = idStr.split(",");

	for(var i = 0;i<ids.length;i++){
		var index = ids[i].indexOf(IdPrefix);
		if(index>-1){
			var carrierIds = carrierType.tree.dhtmlTree.getUserData(ids[i],"alisname").split(","); 
			for(var j = 0;j<carrierIds.length;j++){
				idsArray.push(carrierIds[j]);
			}
		}
	}
	
	if (idsArray == ""){
		 return null;
	}else{
		return idsArray;
	}
}


function loadgetResourceIds(){
	var resourceType =  $("resourceType").value;
	
	
	if(resourceType>0){
		
		    carrierType.tree.refreshTree();
		
			function callBackFun(ids){
		//		alert(ids);
				
			 	carrierType.tree.loadDataTreeArray1(resource.IdPrefix,ids);
			}
			
			resource.reset();
			resource.obj.resourceType = $("resourceType").value;
			resource.obj.version = resource_year;
			resource.getResourceIds(callBackFun);
	}


}
function doOnSelect(itemId){
	if(itemId == "root") return false;
	var isItemChecked = carrierType.tree.dhtmlTree.isItemChecked(itemId);
	carrierType.tree.dhtmlTree.setSubChecked(itemId,!isItemChecked); 
}
function getCheckedCarriers(){

//    var carrierIds = getAllCheckedBranches(carrier.IdPrefix);
    var carrierIds = new Array();
   
    
    if(config_useCarrierAliname){
    	carrierIds = getAllCheckedBranches(carrier.IdPrefix);
    }else{
    	carrierIds = carrierType.tree.getAllCheckedBranches(carrier.IdPrefix); 
    }
    
   if(carrierIds == null) carrierIds = []; 
   return carrierIds;
}

function getCheckedCarrSortIds(){
    var carrierIds = new Array();
    carrierIds = carrierType.tree.getAllCheckedBranches(carrierType.IdPrefix); 
    if(carrierIds == null) carrierIds = []; 
    return carrierIds;
}


function refreshTreeCarriers(){
	carrierType.tree.refreshTree();
}