var carrierType = new CarrierType();
var carrier =new  Carrier();
var resource = new Resource();
var matter = new Matter();
var customer = new Customer();
var resourceType = new ResourceType();
callOnLoad(init);	

function init(){
	setCarrierTypePara(carrierType);
	setCarrierPara(carrier);
	setResourcePara(resource);
	setMatterPara(matter);
	setCustomerPara(customer);
	setResourceTypePara(resourceType);
	
	carrier.obj.nodeLevel =1;
	carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","getCarrierTypeTree");
	
	resourceType.makeSelectItemAnalyze(resourceType.obj,"resourceTypeName","getCarrierTypeTree");
	carrierType.makeSelectItemAnalyze(carrierType.obj,"carrierTypeName","");
	
//	getCarrierTypeTree(carrierType); 
	getDate();
	buttonEventFill();
 	resetHeigth();
	getCustomerAutoComplt();
	getMatterAutoComplet();
}
function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var adResCount = $("adResCount");
    var carrierTypeTreebox = $("carrierTypeTreebox");
    var treebox = $("treebox");
    var customerProduct_div = $("customerProduct_div");
    treebox.style.width = dialogcontent.offsetWidth*0.25+"px";
    adResCount.style.height = (dialogcontent.offsetHeight -dialogcontent.offsetTop)*0.9 +"px";	
    customerProduct_div.style.height = dialogcontent.offsetHeight * 0.8 +"px";	
    carrierTypeTreebox.style.height = (dialogcontent.offsetHeight -dialogcontent.offsetTop)*0.85 +"px";
} 
function setCarrierTypePara(obj){
	obj.className  = "carrierType";
	obj.IdPrefix   = obj.className + "Id";
	obj.treebox	   = obj.className + "Treebox";
	obj.tree = new Tree(obj.treebox); 
	obj.selectName =  "carrierTypeName";
}

function setResourceTypePara(obj){
	obj.className  = "resourceType";
	obj.IdPrefix   = obj.className + "Id";
	obj.selectName =  "resourceTypeName";
}
function getCarrierTypeTree(){
	carrierType.tree.dhtmlTree.deleteChildItems(0);
	var obj_tree = carrierType.tree.dhtmlTree;	
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.enableItemEditor(false);
	obj_tree.enableDragAndDrop(false);
	carrierType.reset();
	carrierType.obj.parentId = 0;
	
	carrierType.obj.id = $(carrierType.selectName).value;
	var carrierId = $(carrier.selectName).value==0?null: $(carrier.selectName).value;
	var resourceTypeId = $(resourceType.selectName).value==0?null:$(resourceType.selectName).value;
	
	carrierType.getTreeXMLResourceAnalyze(carrierType.obj,carrier.IdPrefix,resource.IdPrefix,carrierId,resourceTypeId);
	obj_tree.loadXMLString(carrierType.tree.treeXML);
}
	
function setMatterPara(obj){
	 
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className   = "matter";	
	 obj.IdPrefix 	 = obj.className + "Id";

}
function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "customerId";
}

function setCarrierPara(obj){
	obj.className  = "carrier";
	obj.IdPrefix 	= obj.className + "Id";
	obj.selectName = obj.className+"Name";
}
function setResourcePara(obj){
	obj.className  = "resource";
 	obj.IdPrefix 	= obj.className + "Id";
}

function getDate(){
	Calendar.setup({
		inputField  : "beginDate",	  // id of the input field
		ifFormat	: "%Y%m%d",	  // the date format
		button	  : "beginDate"	// id of the button
	});
	
	Calendar.setup({
		inputField  : "overDate",	  // id of the input field
		ifFormat	: "%Y%m%d",	  // the date format
		button	  : "overDate"	// id of the button
	});
	$("beginDate").value = theYear+'0101';
	$("overDate").value= theYear+'1231';
	
}

function buttonEventFill(){
	var btn_search=$("searchRes");
	btn_search.onclick=search;
	
	var Btn_customerName = $("customerName");
	if(!isUndefined(Btn_customerName)){
		Btn_customerName.onclick = resetText;
	 }	
	
	
	
	var Btn_matterName = $("matter.name");
	if(!isUndefined(Btn_matterName)){
		Btn_matterName.onclick = resetMatterText;
	}	
	
}

function search(){
	var beginDate = $("beginDate").value;
	var endDate = $("overDate").value;
	var resIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
	alert(resIds);

}

function getCustomerAutoComplt(){
	customer.getCustomerAutoComplet(payCustomerAutoComplet,customer.obj);
}
function getMatterAutoComplet(){
	matter.getMatterAutoComplet(mattersAutoComplete,matter.obj);
}

function payCustomerAutoComplet(objs)
{
	var oText = $("customerName");
	var oDiv = $("theDivCustomerName");

	var indexColumName_customerName = ["helpCode"];
	var allColumsName_customerName =["id","helpCode","customerName","customerCategoryId","category.categoryName"];
	var hidenColumName = ["id","customerCategoryId"];
	var allColumsTitle = ["助记码","客户名称","客户类别"];
	
	var onDivMouseDown_customerId = function(ev){

		var tr = getElementByEvent(ev);
		$("customerId").value = getCellValue(tr,0);
		$("customerName").value = getCellValue(tr,2);
		$("customerCategoryId").value = getCellValue(tr,3);
		
		oText.value = getCellValue(tr,2);
//		searchCustomerName();
	}
	
	var onTextBlur = function(ev){

		oDiv.style.visibility = "hidden";
		
		if(trim(oText.value) == "" ){
			$("customerId").value = '';
			$("customerCategoryId").value = '';
//			searchCustomerName();
		}
	}
   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown_customerId,onTextBlur,hidenColumName,indexColumName_customerName,allColumsName_customerName,allColumsTitle);

}



function mattersAutoComplete(objs)
{
	var oText_name = $("matter.name");
	var oDiv_name = $("theDivMatterName");
	var indexColumName_name = ["name"];
	var allColumsName_name =["id","name"];
	var allColumsTitle_name = ["广告名称"];
	var onDivMouseDown_name = function(ev){
		var tr = getElementByEvent(ev);
		$("dt_matter.id").value = getCellValue(tr,0);
		$("matter.name").value = getCellValue(tr,1);
		oText_name.value = getCellValue(tr,1);
		
		
//		searchMatterName();
	}
	
	var hidenColumName = ["id"];
	
	var onTextBlur = function(ev){
		oDiv_name.style.visibility = "hidden";
		
//		if(trim(oText_name.value) == "" ) $("matter.name").value = "";
		
		if(trim(oText_name.value) == ""){
			$("dt_matter.id").value = '0';
			$("matter.name").value = "";
//			searchMatterName();
		}	
	}
	
   new AutoComplete(objs,oText_name,oDiv_name,-1,onDivMouseDown_name,onTextBlur,hidenColumName,indexColumName_name,allColumsName_name,allColumsTitle_name);
}
function resetText(ev){
	 $("customerName").value = null;
	 $("customerId").value = null;
}
function resetMatterText(ev){
	 $("matter.name").value = null;
	 $("dt_matter.id").value = null;
}



