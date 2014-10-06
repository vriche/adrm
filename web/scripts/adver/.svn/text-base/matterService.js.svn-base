var matter = new Matter();
var customer = new Customer();
var matterType = new MatterType(); 
var org = new SysOrg();
var report = new MyPrint();
callOnLoad(init);	
  
function init(){ 	
   ctxPath =  _app_params.ctxPath;	
   
   useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
    loginUser =  _app_params.user.username;

	setMatterPara(matter);
	setCustomerPara(customer);
	setMatterTypePara(matterType);
	
	
	
		
	matterType.makeSelect(matterType.selectName,"getMatterType",setMatterTypeSelected);
	
//	org.makeSelect(org.obj,"orgId","getMatterTable1",callBackFun);	
	_make_org_select("orgId",143,"onOrgChanged");
	
	getMatterTable1();
	
//	function callBackFun(){	
//		
//		getMatterTable1();
//
////		if(useMoreCarrierSortParam == 0 && $('orgId').options.length<2){
////			$('orgId_td').hide();
////		}	
//	}
		

	
//	customer.makeSelect(customer.obj,customer.selectName,"");
//	getCustomerAutoComplt();
//	getMatterAutoComplet();
//	getMatterVersionAutoComplet();
 	buttonEventFill();
 	
 	this.report.buildButtons(this,"printReportDiv",[0,1,2],80);
 	
     getcustomerCmd(true);

	
}
 	function onOrgChanged(){
	   getcustomerCmd(false);
       search();
	}



// 	function setCustomerSelected(){
//	   $("customerCmd").value =  $("orgId").value;
////	   $("customerCmd").remove(0);
//	}
//	function oncustomerCmdchange(){
//	
//		$("customerId").value = $("customerCmd").value;
//		$("customerName").value = DWRUtil.getText("customerCmd");
//
//	} 	
//function getcustomerCmd(isSetValue){
//	
// 	customer.obj.orgId = $("orgId").value;;
//	customer.obj.loginUser = loginUser;
//
//	if(isSetValue){
//		customer.makeSelectAnalyzeWidth(customer.obj,"customerCmd","oncustomerCmdchange","143",function(){});	
//	}else{
//		customer.makeSelectAnalyzeWidth(customer.obj,"customerCmd","oncustomerCmdchange","143",setCustomerSelected);	
//	}
//
//}

function getcustomerCmd(isSetValue){
		    customer.obj.orgId = $("orgId").value;
		 	customer.obj.loginUser = loginUser;
		    var cmd = customer.getCustomerRemote("customerCmd","customerName",160,function(){});	
//		 	cmd.on("select",searchCustomer,this);	
//		 	cmd.on("clear",searchCustomer,this);		
}



function buttonEventFill(){	
	
		
	var btn_add = $("btn_add");
	btn_add.onclick = addNew;
	
	var btn_search = $("searchMatter");
	btn_search.onclick = search;
	
	var btn_searche = $("btnSearche");
	btn_searche.onclick=displayDiv;
	
	var btn_searche_close=$("btnSearcheClose");
	btn_searche_close.onclick=closeDiv;

//	var Btn_view_order = $("Btn_view_order");
//	Btn_view_order.onclick = button_view_order;
//	
//	var Btn_print_order = $("Btn_print_order");
//	Btn_print_order.onclick = button_print_order;	
//	
//	var Btn_export_order = $("Btn_export_order");
//	Btn_export_order.onclick = button_print_export;	

//	var Btn_customerName = $("customerName");
//	Btn_customerName.onkeypress= getCustomerAutoCompltByName;
//	Btn_customerName.onclick = resetText;
	
	var Btn_matterName = $("matter.name");
	Btn_matterName.onclick = resetMatterNameText;
	Btn_matterName.onkeypress = getMatterAutoCompltByName;
	
	var Btn_matterEdit = $("matter.edit");
	Btn_matterEdit.onkeypress = getMatterVersionAutoCompletByName;
	Btn_matterEdit.onclick =resetMatterEditText;
}
function addNew(){
	window.location.href = ctxPath + "editMatter.html?model=new&orgId=" + $("orgId").value;	
}


function printReport(mode){
//	 var s=['view','print','excel'];
	 
	if(mode =="view"){
		button_view_order();
	}
	if(mode =="print"){
		button_print_order();
	}
	if(mode =="excel"){
		button_print_export();
	}
	   
}


function displayDiv(ev){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "visible";
}
function closeDiv(ev){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "hidden";
} 

function setMatterPara(obj){
	 
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className   = "matter";	
	 obj.IdPrefix 	 = obj.className + "Id";
	 obj.fillObjName = obj.className + "Body";
	 obj.tableName   = "matterList";
	 obj.tBody 		 = $(obj.fillObjName);
	 obj.color1 	 = "BACKGROUND-COLOR: #white";
	 obj.color2 	 = "BACKGROUND-COLOR: #eee";
	 

	 
	 
	 obj.pageInfo 	 = "pageInfo" + obj.className;
	 obj.pageSize 	 = "20";
	 obj.page        = new Page(obj.pageInfo,obj.pageSize); 
}
function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "customerId";
}


function getMatterTable1(){
	matter.obj.orgId = $("orgId").value
	matter.getMattersSearch(matter,null,null,null,null);
	
//	customer.obj.orgId = $("orgId").value;
//	customer.getCustomerAutoComplet(payCustomerAutoComplet,customer.obj);	

}

function getMatterTable(matter,matterName,customerName,matterEdit,matterType){
	matter.getMattersSearch(matter,matterName,customerName,matterEdit,matterType);
}

function setMatterTypeSelected(){
	 	var id  = $("matterTypeId").value;
	 		$(matterType.selectName).value = id;

}

function getMatterType(){
	
	var matterTypeId = $(matterType.selectName).value;
	$("matterTypeId").value = matterTypeId;
}

function setMatterTypePara(obj){
	 obj.className ="MatterType";
	 obj.selectName = obj.className +"RN";
}

function searchCustomerName(){
	var customerId = $("customerId").value;
	
	if(customerId == '0'){
		matter.reset();
		matter.getMatters(matter);
	}else{
		matter.reset();
		matter.obj.customerId = customerId;
		matter.getMatters(matter);
	}
}

function getTable(){
	var state = $(matterType.selectName).value;
	if(state == ""){
		matter.reset();
		matter.getMatters(matter);
	}else{
		$("matterTypeId").value = state;
		matter.reset();
		matter.obj.matterType=$("matterTypeId").value
		matter.getMatters(matter);
	}
}

function searchMatterName(){
	var matterName = $("matter.name").value;
	
	if(matterName == ""){
		matter.reset();
		matter.getMatters(matter);
	}else{
		matter.reset();
		matter.obj.name = matterName;
		matter.getMatters(matter);
	}
}

function searchMatterVersion(){
	var matterEdit = $("matter.edit").value;
	if(matterEdit == ""){
		matter.reset();
		matter.getMatters(matter);
	}else{
		matter.reset();
		matter.obj.edit = matterEdit;
		matter.getMatters(matter);
	}
}

function editInfo(id){
	parent.location.href ="editMatter.html?id="+id;
}

//翻页处理
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == matter.pageInfo){
		var page = new Page(matter.pageInfo,matter.pageSize);
		page.goNextPage(pageIndex);
		matter.page = page;
		var matterName = $("matter.name").value==""?null:$("matter.name").value;
		
//		var customerName = $("customerName").value==""?null:$("customerName").value;
	    var customerName = Ext.fly("customerName").getValue();
	    var cutId = Ext.getCmp("customerName").getValue();
	    var customerName = customerName==""||cutId==''?null:customerName;		
		
		
		var matterEdit = $("matter.edit").value==""?null:$("matter.edit").value;
		var matterType = $("matterTypeId").value==""?null:$("matterTypeId").value;
		getMatterTable(matter,matterName,customerName,matterEdit,matterType);
	}
}

//function getCustomerAutoComplt(){
//	customer.getCustomerAutoComplet(payCustomerAutoComplet,customer.obj);
//}

function getCustomerAutoCompltByName(ev){
	
	var customerName =$("customerName").value;
	customer.obj.customerName = customerName;
//	function fnc(userId){
//			var categoryId = 1;
//			customer.getCustomerAutoCompletByName(userId,categoryId,customerName,payCustomerAutoComplet);
//	}
	
	if(ev.keyCode == 13){
		customer.getCustomerAutoComplet(payCustomerAutoComplet,customer.obj);
		$("customerName").value="";
	}
}

//function getMatterAutoComplet(){
//	matter.getMatterAutoComplet(mattersAutoComplete,matter.obj);
//}

function getMatterAutoCompltByName(ev){
	matter.obj.name = $("matter.name").value;
	if(ev.keyCode == 13){
//		matter.getMatterAutoComplet(mattersAutoComplete,matter.obj);
		matter.getMatterAutoCompletDIV(mattersAutoComplete,matter.obj);
		$("matter.name").value="";
	}
}

function getMatterVersionAutoCompletByName(ev){
	matter.obj.edit = $("matter.edit").value;
	if(ev.keyCode == 13){
		matter.getMatterAutoComplet(mattersVersionAutoComplete,matter.obj);
		$("matter.edit").value="";
	}
}

function mattersVersionAutoComplete(objs)
{
	var oText_name = $("matter.edit");
	var oDiv_name = $("theDivMatterEditName");
	var indexColumName_name = ["edit"];
	var allColumsName_name =["edit"];
	var allColumsTitle_name = ["广告版本"];
	var onDivMouseDown_name = function(ev){
		var tr = getElementByEvent(ev);
//		$("dt_matter.id").value = getCellValue(tr,0);
		$("matter.edit").value = getCellValue(tr,0);
		oText_name.value = getCellValue(tr,0);
		
		
//		searchMatterVersion();
	}
	
//	var hidenColumName = ["id"];
	
	var onTextBlur = function(ev){
		oDiv_name.style.visibility = "hidden";
		
//		if(trim(oText_name.value) == "" ) $("matter.name").value = "";
		
		if(trim(oText_name.value) == ""){
//			$("dt_matter.id").value = '0';
			$("matter.edit").value = "";
//			searchMatterVersion();
		}	
	}
	
   new AutoComplete(objs,oText_name,oDiv_name,-1,onDivMouseDown_name,onTextBlur,"",indexColumName_name,allColumsName_name,allColumsTitle_name);
}

function payCustomerAutoComplet(objs)
{
	var oText = $("customerName");
	var oDiv = $("theDivCustomerName");

	var indexColumName_customerName = ["helpCode"];
	var allColumsName_customerName =["id","helpCode","customerName","customerCategoryId","category.categoryName"];
//	var hidenColumName = ["id","customerCategoryId"];
//	var allColumsTitle = ["助记码","客户名称","客户类别"];
	var hidenColumName = ["id","helpCode","customerCategoryId"];
	var allColumsTitle = ["客户名称","客户类别"];
	
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
//		$("dt_matter.id").value = getCellValue(tr,0);
		$("matter.name").value = getCellValue(tr,1);
		oText_name.value = getCellValue(tr,1);
		
		
//		searchMatterName();
	}
	
	var hidenColumName = ["id"];
	
	var onTextBlur = function(ev){
		oDiv_name.style.visibility = "hidden";
		
//		if(trim(oText_name.value) == "" ) $("matter.name").value = "";
		
		if(trim(oText_name.value) == ""){
//			$("dt_matter.id").value = '0';
			$("matter.name").value = "";
//			searchMatterName();
		}	
	}
	
   new AutoComplete(objs,oText_name,oDiv_name,-1,onDivMouseDown_name,onTextBlur,hidenColumName,indexColumName_name,allColumsName_name,allColumsTitle_name);
}

function search(){
	closeDiv();
	
//	var matterName = $("matter.name").value==""?null:$("matter.name").value;
//	var customerId = $("customerId").value==""?null:$("customerId").value;
//	var matterEdit = $("matter.edit").value==""?null:$("matter.edit").value;
//	var matterType = $("matterTypeId").value==""?null:$("matterTypeId").value;
    var customerName = Ext.fly("customerName").getValue();
    var cutId = Ext.getCmp("customerName").getValue();
    var customerName = customerName==""||cutId==''?null:customerName;
    
	var matterName = $("matter.name").value==""?null:$("matter.name").value;
	var matterEdit = $("matter.edit").value==""?null:$("matter.edit").value;
	var matterType = $("matterTypeId").value==""?null:$("matterTypeId").value;
//	alert( matterEdit+" 1  "+matterType+"  2  "+customerId+"  3  "+matterName);
//	alert($("matterTypeId").value=="");
//	alert(name=="NaN");
//	matter.reset();
//	matter.obj.name = matterName;
//	matter.obj.customerId = customerId;
//	matter.obj.edit = matterEdit;
//	matter.obj.matterType = matterType;
//	matter.getMatters(matter);
	matter.obj.orgId = $("orgId").value;
	matter.getMattersSearch(matter,matterName,customerName,matterEdit,matterType);
}

function button_view_order(){button_print('view');}	
function button_print_order(){button_print('print');}
function button_print_export(){button_print('export');}

function button_print(model){
	$("model").value = model;
	$("reportType").value = "matter_report";

	$("matterNameForm").value = $("matter.name").value==""?null:$("matter.name").value;
	$("customerIdForm").value = $("customerId").value==""?null:$("customerId").value;
	$("matterEditForm").value = $("matter.edit").value==""?null:$("matter.edit").value;
	$("matterTypeForm").value = $("matterTypeId").value==""?null:$("matterTypeId").value;
	

	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");

	
	reportForm.target = tarForm;
	reportForm.action="reports/jsp/common_reports.jsp";
	reportForm.submit(); 	
}

function resetText(ev){
//	 $("customerName").value = null;
	Ext.getCmp("customerName").setValue('');
	/// $("customerId").value = null;
}

function resetMatterNameText(ev){
	 $("matter.name").value = null;

}

function resetMatterEditText(ev){
	 $("matter.edit").value = null;

}