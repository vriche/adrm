
 var contract = new Contract();
 var category = new Category();
 var carrier =new  Carrier();
 var user = new User();
 var customer = new Customer();
 var channelModelParam;
 var config_serviceDate;
 var contract_year;
 var config_withResourceSort;

 var myprint = new MyPrint();
 
 callOnLoad(init);	
  
 function init(){


	ctxPath = _app_params.ctxPath;	
	
 	config_serviceDate = _app_params.serviceDate.def;
 	channelModelParam = _app_params.sysParam.channelModelParam;
 	tvNameParam =  _app_params.sysParam.tvNameParam;
 	loginUser =   _app_params.user.username;	
	config_useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;	
	config_withResourceSort = _app_params.sysParam.withResourceSort;
	
	
	_make_adrm_sys_year_select("contract_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);
	
//	if(config_withResourceSort == 1){
//		var  option = new Option('部门订单', 2);
//        $("contract_sort").options.add(option);
//	}
	
	
	var srcStr= window.location.href;	
	orgId  = getParamFromUrl(srcStr,"orgId");	
	

	
	contract_sort  = getParamFromUrl(srcStr,"contractSort");	
//	customerCategorys  = getParamFromUrl(srcStr,"customerCategorys");	
	
	
	
	 _make_org_select("orgId",120,"rest_customer_store");	
	 
	 	config_oneOrgMoreSuborgsParam = _app_params.sysParam.oneOrgMoreSuborgsParam;
	  if(config_oneOrgMoreSuborgsParam == '1'){$('orgId').hide();}
	 

	 if(orgId > 0 ) $("orgId").value = orgId;
	
// 	if(config_useMoreCarrierSortParam == 0){$('orgId_td').hide();}

 	
 	setContractPara(contract);
 	setCategoryPara(category);
 	setCarrierPara(carrier);
 	
 	buttonEventFill();

 	get_cur_year();
 	
    buildcustomerCommand();
 	
 	if(tvNameParam =='hntv' && tvNameParam =='sjz'){
 		$("contract_sort").hide();
 	}else{
 		if(contract_sort > 0) $("contract_sort").value = contract_sort;
 	}
 	
 	
 	
 	
 	
 	
 	 function getCategorys() {
// 		category.getCategorySelectLimitList(category,fillFun);

	    category.obj.loginUser = loginUser;
	 	category.makeSelectAnalyze("customerCategorys","getTable",function(){
	 		var type = getParamFromUrl(window.location.href,"type");
			var pageIndex = getParamFromUrl(window.location.href,"pageIndex");
			if(pageIndex == null || pageIndex =="") pageIndex = 1;
			if(type == null || type =="") type = 1;
			
			if(type > 0) $("customerCategorys").value =type;
			
//	        setRadioCheckedByValue($(category.radioName),type);
	        contract.page.pageIndex = pageIndex;
	        getContractTable($("orgId").value);	 	 	
	  	 	
	 	});	
 	}
 	
 	

 	
 	
 	if(channelModelParam == 1 && tvNameParam =='hntv'){
 	    initCarrier(getCategorys);
 	    
 	}else{
 	    $("carrierName").hide();
// 	    category.getCategorySelectLimitList(category,fillFun);
        getCategorys();
 	
	}
 	

 	
// 	function fillFun(objs){
////		makeOptionsHtml(objs,"radio",category.radioName,"categoryName","id","","getTable",[]);
////		alert(getRadioIdByURL());
//		var type = getParamFromUrl(window.location.href,"type");
//		var pageIndex = getParamFromUrl(window.location.href,"pageIndex");
//		if(pageIndex == null || pageIndex =="") pageIndex = 1;
//		if(type == null || type =="") type = 1;
//		
//        setRadioCheckedByValue($(category.radioName),type);
//        contract.page.pageIndex = pageIndex;
//        getContractTable($("orgId").value);	
//	}
	
 	
// 	category.makeOptions("categoryRN","radio","getContractTable","",[]);
//// 	var type = getTypeByURL();
// 	getContractTable();

    	this.myprint.buildButtons(this,"printReportDiv",[0,1,2],80);
 }
 
 
 function buildcustomerCommand(){
  	

   	customer.obj.orgId = $("orgId").value;
 	customer.obj.version = $("contract_year").value;
 	customer.obj.loginUser = loginUser;
 	customer.obj.model = "3";


 	var callBackFun = function(){};
 	var cmd = customer.getCustomerRemote("theDivCustomerName","customer_name",120,function(){
	
 	});	
 		
 	cmd.on("select",getContractTable,this);	
 	cmd.on("clear",getContractTable,this);	
	 
  }
 
 function get_cur_year(){
 	
 	var year = getParamFromUrl(window.location.href,"year");
	config_serviceDate =  _app_params.serviceDate.def;
	var yyyy =  _app_params.serviceDate.year;
	if(year>0) yyyy = year;
	contract_year =  _app_params.serviceDate.year;
	$("contract_year").value = contract_year;	
}

function initCarrier(fct){
    carrier.obj.nodeLevel =1;
	carrier.obj.enable = false;
	//根据是否分频道，取得频道下拉列表
	function fnct(){
		var carrierId = getParamFromUrl(window.location.href,"carrierId");
		if(carrierId > 0) $("carrierName").value = carrierId;
		if(fct) fct();
	}
	if(channelModelParam!=1 || tvNameParam =='xmtv'){
		carrier.makeSelectItemFromMapOrderList(carrier.obj,"carrierName","",fnct);
	}else{
		
//		carrier.makeSelectItemAnalyze3(carrier,carrier.selectName,"getContractTable",100,true,fnct);
		carrier.makeSelectItemAnalyze5(carrier,carrier.selectName,"getContractTable",100,true,loginUser,fnct);
	}	
		
}
 

  function setCarrierPara(obj){
	obj.className  = "carrier";
	obj.IdPrefix 	= obj.className + "Id";
	obj.selectName = obj.className+"Name";
}
 



 
function buttonEventFill(){
	var contractAllSelect = $("contractAllSelect");
	contractAllSelect.onclick = allSelectCheckBox;		
	contractAllSelect.setAttribute("parnetObjName",contract.tableName);	

	var submitChecked = $("submitChecked");
	submitChecked.onclick = updateContractStates;	
	
	
	var Bt_new = $("new");
	Bt_new.onclick = addnew;
	
//	var Btn_customerName = $("customerName");
//	Btn_customerName.onkeypress= getCustomerAutoComplt;
//	Btn_customerName.onclick = resetText;
//	
	var change_contract_year = $("contract_year");
	change_contract_year.onchange = rest_contract_year;
	
	var change_contract_sort = $("contract_sort");
	change_contract_sort.onchange = rest_contract_year;
	
}


function printReport(mode){
    button_print(mode)
	if(mode =="chart"){
		getFusionChartObjs();
	}	
   
}




function button_print(model){
	
	   var paramObj = getParam();

	   var printParam = {
				 	model: model,
				 	title:'合同列表',
	                reportType: "contractListTable",
	                reportFile:'',
	                headers:"合同编号,客户名称,合同性质,签订日期,合同总金额,签订人,开始日期,结束日期",
	                displaySumColum:"0,0,0,0,0,0,0,0",
	                colAlign:"center,left,center,center,right,center,center,center",
	                colTypes:"ed,ed,ed,ed,ed,ed,ed,ed",
	            	widthsP:"10,20,10,10,10,10,15,15", 
	            	isSum:false,
	                isVertical:false
			};	
			

 
        var a = Object.extend(paramObj,printParam);      
       
        myprint.loadApplet(a,ctxPath,800,500);	
	
}

function rest_contract_year(){
	contract_year = $("contract_year").value;
	contract.page.pageIndex =1;
	getContractTable($("orgId").value);
}


function rest_customer_store(){
	var version = $("contract_year").value;
	var orgId = $("orgId").value;
	var cmd4 =  Ext.getCmp('customer_name');
	var store4 = cmd4.getStore();	
	if(store4.baseParams.dwrParams){
		store4.baseParams.dwrParams.orgId = orgId;
		store4.baseParams.dwrParams.version = version; 
		store4.reload();
		if(cmd4.mode == 'local'){
			store4.clearValue(); 
		}else{
			cmd4.setValue('');
		}
			
	}
	contract.page.pageIndex =1;
  getContractTable($("orgId").value);	
}

function getCustomerAutoComplt(){
//	var type = getRadioValue($(category.radioName));
	
	
	 var type = $("customerCategorys").value;
	 
	if(type ==1 ) type = null;
	
	function fun(userId){
		customer.getCustomerAutoComplet2(userId,type,payCustomerAutoComplet);
	}
	user.getCurUserId($("config_username").value,function(id){fun(id)});
}
function payCustomerAutoComplet(objs)
{
	var oText = $("customerName");
	var oDiv = $("theDivCustomerName");

	var indexColumName_customerName = ["helpCode"];
	var allColumsName_customerName =["id","helpCode","customerName","customerCategoryId","category.categoryName"];
	var hidenColumName = ["id","customerCategoryId","helpCode"];
	var allColumsTitle = ["客户名称","客户类别"];
	
	var onDivMouseDown_customerId = function(ev){

		var tr = getElementByEvent(ev);
		$("customerId").value = getCellValue(tr,0);
		$("customerName").value = getCellValue(tr,2);
		$("customerCategoryId").value = getCellValue(tr,3);
		
		oText.value = getCellValue(tr,2);
		searchContract();
	}
	
	var onTextBlur = function(ev){

		oDiv.style.visibility = "hidden";
		
		if(trim(oText.value) == "" ){
			$("customerId").value = '0';
			$("customerCategoryId").value = '0';
			searchContract();
		}
	}
   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown_customerId,onTextBlur,hidenColumName,indexColumName_customerName,allColumsName_customerName,allColumsTitle);
}

function searchContract(){
	var customerId = $("customerId").value;
//	var type = getRadioValue($(category.radioName));
	var type = $("customerCategorys").value ;
	if(type == 1 ) type = null;
//	if(customerId =='0' ) customerId = null;
	if(customerId =='0' ||customerId ==''  ) customerId = null;
	
	var carrierId =$("carrierName").value;
	
	var func = function(objs){
		contract.fillTalbeByType(objs);
	}
	
	contract.reset();
	contract.obj.version = contract_year;
	contract.obj.customerCategoryId = type;
	contract.obj.carrierId = carrierId;
	contract.obj.customerId = customerId;
	contract.obj.orgId = $("orgId").value;
	
	contract.getContractsByType(contract,func);
}


function setContractPara(obj){
	 obj.className ="contract";
	 obj.IdPrefix 	= obj.className +"Id";
	 obj.tableName   = obj.className +"Table";
	 obj.fillObjName = obj.className +"Tbody";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.checkBoxName = obj.className +"Check";
	 obj.color1 		= "BACKGROUND-COLOR: #white";
	 obj.color2 		= "BACKGROUND-COLOR: #eee";
	 obj.enableEdit	= true;
	 obj.enableDel	= true;	 
	 obj.pageInfo 	= obj.className +"PageInfo";
	 obj.pageSize 	= "20";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
	 
	 obj.className ="contractType";
	 obj.radioName = obj.className +"RN";
}

function setCategoryPara(obj){
	 obj.className ="category";
	 obj.radioName = obj.className +"RN";
}

function updateContractStates(){
	var checkeds = getCheckBoxValues(contract.tableName,1);
	if(checkeds=="") return false;
	contract.updateContractStates(checkeds,1);
	alert("提交成功!");
	
	var type = getParamFromUrl(window.location.href,"type");
	var pageIndex = getParamFromUrl(window.location.href,"pageIndex");
	var carrierId = getParamFromUrl(window.location.href,"carrierId");
	parent.location.href ="contracts.html?type="+type+"&pageIndex=" +pageIndex+"&carrierId=" +carrierId+"&orgId="+$("orgId").value;
}
function editInfo(contractId,type,orgId,el){
//	if(getRadioValue($(category.radioName)) ==1 ){//直接进行编辑时用
//		type = 1;
//	}
 
 
    var contractSort =  $("contract_sort").value;
    
	if(!isUndefined(el.firstChild)){
	   if(el.firstChild.type == "checkbox") return false;	
	    var targEl = el.firstChild;
	    targEl = targEl ==''||isUndefined(targEl)?"":targEl+'';
	    if(targEl.indexOf("http") >-1) return false;
	}

    
//	var type = getRadioValue($(category.radioName));
	var type = $("customerCategorys").value ;
	var carrierId = $("carrierName").value;
	parent.location.href ="editContract.html?id="+contractId+"&pageIndex="+contract.page.pageIndex+"&type="+type +"&carrierId="+carrierId+"&orgId="+orgId + "&contractSort="+contractSort;
}

function getTable(){
//	var state = getRadioValue($(category.radioName));
	var state = $("customerCategorys").value ;
	var carrierId =$("carrierName").value;
	var curUserName = $("config_username").value;
	var contractSort =  $("contract_sort").value;
	
	if(channelModelParam != 1 || tvNameParam =='xmtv'){
		carrierId = null;
		curUserName = null;
	}
	if(state ==1 ){
		state = null;
	}
	var func = function(objs){
		contract.fillTalbeByType(objs);
	}	
	
	var customerId = $("customerId").value;
//	if(customerId =='0' ) customerId = null;
	if(customerId =='0' ||customerId ==''  ) customerId = null;
	
	contract.reset();
	contract.obj.customerCategoryId = state;
	contract.obj.version = contract_year;
	contract.obj.carrierId = carrierId;
	contract.obj.customerId = customerId;
	contract.obj.contractSort = contractSort;
//	contract.obj.orgId = $("orgId").value;
//	contract.obj.signUser = curUserName;
	
	contract.page.pageIndex = 1;
	contract.getContractsByType(contract,func);
}

//翻页处理
function goNextPage(pageIndex,pageInfoName){
//	var type = getTypeByURL();
	
	var type = getParamFromUrl(window.location.href,"type");
	
	if(pageInfoName == contract.pageInfo){
		var page = new Page(contract.pageInfo,contract.pageSize);

		page.goNextPage(pageIndex);
		contract.page = page;
		getContractTable($("orgId").value);
	}
}

function addnew(){
//	var type = getRadioValue($(category.radioName));
	var type = $("customerCategorys").value ;
	var carrierId = $("carrierName").value;
	var contractSort =  $("contract_sort").value;
//	if(type==1){
//		alert("请您选择客户类型！");
//	}else{
		parent.location.href ="editContract.html?type="+type+"&carrierId="+carrierId+"&year="+contract_year+"&orgId="+$("orgId").value+ "&contractSort="+contractSort;
//	}	
}


function getParam(){
	
//	var state = getRadioValue($(category.radioName));
	var state = $("customerCategorys").value ;
	var carrierId =$("carrierName").value;
	var curUserName = $("config_username").value;
	var contractSort =  $("contract_sort").value;
	
	if(channelModelParam != 1 || tvNameParam =='xmtv'){
		carrierId = null;
		curUserName = null;
	}

    var customerId =  Ext.getCmp("customer_name").getValue();
    var customerName = Ext.getCmp("customer_name").getRawValue();
	if(customerId =='') customerId = null;
	
	if(state == 1) state = null;


   
    var a = {
	    version :contract_year,
		orgId : $("orgId").value,
		customerCategoryId : state,
		carrierId : carrierId,
		customerId : customerId,
		contractSort : contractSort
    }
    
    return a;
}

function getContractTable(i){
//	if(i> 0){
//		 
//	}else{
//		contract.page.pageIndex =1;
//	}
//	var state = getRadioValue($(category.radioName));
	var state = $("customerCategorys").value ;
	var carrierId =$("carrierName").value;
	var curUserName = $("config_username").value;
	var contractSort =  $("contract_sort").value;
	
	if(channelModelParam != 1 || tvNameParam =='xmtv'){
		carrierId = null;
		curUserName = null;
	}
		 
//	var customerId = $("customerId").value;
//	if(customerId =='0' ) customerId = null;

    var customerId =  Ext.getCmp("customer_name").getValue();
    var customerName = Ext.getCmp("customer_name").getRawValue();
	if(customerId =='') customerId = null;
	
	if(state == 1) state = null;
	var func = function(objs){

		contract.fillTalbeByType(objs);
	}
   
    i = i>0?i:$("orgId").value;
    
    
//    alert(i);


    
    if(contractSort =='') contractSort =null;
	contract.reset();
	contract.obj.version = contract_year;
	contract.obj.orgId = i;
	contract.obj.customerCategoryId = state;
	contract.obj.carrierId = carrierId;
	contract.obj.customerId = customerId;
	contract.obj.contractSort = contractSort;
//	contract.obj.signUser = curUserName;
	
	
	contract.getContractsByType(contract,func);
}
function resetText(ev){
	  Ext.getCmp("customer_name").setValue('');
//	 $("customerName").value = null;
	 $("customerId").value = null;
}

	