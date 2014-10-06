
var carrier =new  Carrier();
var carrierType = new CarrierType();
var user = new User();
var mode = 0;
var loginUser;
var alisnameType = 0;
//var org = new SysOrg();

callOnLoad(init);

function init(){
	ctxPath = $("ctxPath").value;
	customerName =  getParamFromUrl(window.location.href,"customerName");
	orgId =  getParamFromUrl(window.location.href,"orgId");

 	setCustomerPara(customer);

	resetHeigth();
	

	getCarrierTypeTree(carrierType,callBakFun);
	
	
	function callBakFun(){
		
		buttonEventFill(); 
		
		if(mode == '1')loadUserCarrierRel();
		if(mode == '2') {
			ids =  getParamFromUrl(window.location.href,"ids").split(",");
			carrierType.tree.loadDataTreeArray1(carrier.IdPrefix,ids);
		}

	}

	
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
function getCarrierTypeTree(obj,callbakFun){
	var obj_tree = obj.tree.dhtmlTree;	
	obj_tree.setImagePath(ctxPath+"image/tree/");
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.enableItemEditor(false);
	obj_tree.enableDragAndDrop(false);
	obj_tree.setOnClickHandler(doOnSelect);
	obj.reset();
	obj.obj.parentId = 0;
	if(mode == '2') obj.obj.memo = loginUser;

		
	

		
	
	obj.getUserCarrirTreeXML2(carrier.IdPrefix,function(strxml){
		obj_tree.loadXMLString(strxml);
		obj_tree.openAllItems(0);
		if(callbakFun) callbakFun();
	});

}
function buttonEventFill(){
	var Btn_saveUserCarrierRel = $("Btn_saveUserCarrierRel");	
	Btn_saveUserCarrierRel.setAttribute("href","javascript:void 0");
	Btn_saveUserCarrierRel.onclick = saveUserCarrierRel;
	
	var Btn_close = $("Btn_close");	
	Btn_close.setAttribute("href","javascript:void 0");
	Btn_close.onclick = closeWin;
	
}
function closeWin(){
	window.top.close();
}
function saveUserCarrierRel(){
   var carrierIds = carrierType.tree.getAllCheckedBranches(carrier.IdPrefix);

   
   if(carrierIds == null) carrierIds = []; 
   
   var callBackFun = function(){alert("±£´æ³É¹¦£¡");};
   
   user.saveUserCarrierRel(userId,carrierIds,callBackFun);
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


function loadUserCarrierRel(){
	function callBackFun(ids){
	 	carrierType.tree.loadDataTreeArray1(carrier.IdPrefix,ids);
	}
	
	if(userId==""||userId==null){
		carrierType.tree.refreshTree();
		return false;
	}else{
		user.getUserCarrierRel(userId,callBackFun);
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

function getOrgIds(){
    var carrierIds = new Array();
    carrierIds = carrierType.tree.getAllCheckedBranches("root");  
    if(carrierIds == null) carrierIds = []; 
    return carrierIds;
}

function refreshTreeCarriers(){
	carrierType.tree.refreshTree();
}