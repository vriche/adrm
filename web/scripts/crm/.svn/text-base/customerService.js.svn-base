
var category = new Category();
var customer = new Customer();
var linkMan = new LinkMan();
var user = new User();
var org = new SysOrg();
 
 callOnLoad(init);

//Ext.onReady(
//function(){
//	getCustomerAutoComplt();
////	var Btn_customerName = Ext.getCmp("customerName").dom;
////	Btn_customerName.onclick = searchCustomer;
//}
//);

 function init(){	
	setCategoryPara(category);
	setCustomerPara(customer);
	setLinkManPara(linkMan);
	
	config_useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;	

	_make_org_select("orgId",120,"getTable");	
	
	config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;
	if(config_oneOrgMoreSuborgsParam == '1'){$('orgId').hide();}
	 
	loginUser =  _app_params.user.username;
			
	buttonEventFill();
	
//	org.makeSelect(org.obj,"orgId","searchCustomer",callBackFun);	
	
//	function callBackFun(){
//
//		if(config_useMoreCarrierSortParam == 0 && $('orgId').options.length<2){
//			$('orgId_td').hide();
//		}		



         getCategorys();
         
//		category.getCategorySelectLimitList(category,fillFun);	
//		category.makeSelectAnalyze(category,category.selectName,"",setCategorySelected);
		
//		function fillFun(objs){
//
//			makeOptionsHtml(objs,"radio",category.radioName,"categoryName","id","","getTable",[]);
//	//		alert(getRadioIdByURL());
//			var value = getRadioIdByURL();
//	        setRadioCheckedByValue($(category.radioName),value);
//	        customer.page.pageIndex = getPageIndexByURL();
//		 	getCustomerTable();	
//		    getCustomerAutoComplt();
//		}
//	}
	

	
}


function getCategorys() {
		 category.obj.loginUser = loginUser;
		 
	
		 
	 	category.makeSelectAnalyze("categoryRN","getTable",function(){
			var value = getRadioIdByURL();
	        setRadioCheckedByValue($(category.radioName),value);
	        customer.page.pageIndex = getPageIndexByURL();
		 	getCustomerTable();	
//		    getCustomerAutoComplt();
		    

		    customer.obj.orgId = $("orgId").value;
		 	customer.obj.loginUser = loginUser;
		    var cmd = customer.getCustomerRemote("extCustomerDiv2","customerName",120,function(){});	
		 	cmd.on("select",searchCustomer,this);	
		 	cmd.on("clear",searchCustomer,this);	
 	
	 	});
}

function buttonEventFill(){
	
	var Btn_new = $("Btn_addNew");
	Btn_new.setAttribute("href","javascript:void 0");
	Btn_new.onclick = addCustomer;
	
//	var Btn_customerName = Ext.getCmp("customerName").dom;
//	Btn_customerName.onclick = searchCustomer;
	
	var btn_searche = $("btn_searche");
	btn_searche.setAttribute("href","javascript:void 0");
	btn_searche.onclick = searchCustomer;
		
//	var Btn_linkmanName = $("linkmanName");
//	Btn_linkmanName.onclick = getLinkManAutoComplt;		
	
	
//	function 
//	Btn_addNew.onclick = parent.location.href ="editCustomer.html";
}
function addCustomer(){
	var state = $("categoryRN").value;
//	alert(state);
	parent.location.href ="editCustomer.html?radioId="+state+"&orgId=" + $("orgId").value;
}

function getTypeByURL(){
	var url = window.location.href;
	var startPos = url.indexOf("=");
	var endPos = url.length;
	var type = url.substring(startPos+1,endPos)*1;
	return  type;
}

function getPageIndexByURL(){
	var url = window.location.href;
	var startPos = url.indexOf("=");
	var endPos = url.indexOf("&");
	var pageIndex = url.substring(startPos+1,endPos)*1;
	pageIndex = pageIndex>0?pageIndex:1;//alert("pageIndex"+"      "+url+"     "+pageIndex);
	return  pageIndex;
}

function getRadioIdByURL(){
	var url = window.location.href;
	var startPos = url.length-1;
	var endPos = url.length;
	var radioId = null;
	radioId = url.substring(startPos,endPos)*1
	radioId = radioId>0?radioId:1; 
	return radioId;
}

function setCustomerPara(obj){
	 
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 
	 obj.className ="customer";
	 obj.IdPrefix 	 = obj.className + "Id";
	 obj.fillObjName = obj.className + "Body";
	 obj.tableName   = "customerList";
	 obj.tBody 		 = $(obj.fillObjName);
	 obj.color1 	 = "BACKGROUND-COLOR: #white";
	 obj.color2 	 = "BACKGROUND-COLOR: #eee";
	 
	 obj.pageInfo 	 = "pageInfo" + obj.className;
	 obj.pageSize 	 = "21";
	 obj.page        = new Page(obj.pageInfo,obj.pageSize); 
}
function setCategoryPara(obj){
	 obj.className ="category";
	 obj.radioName = obj.className +"RN";
}
function setLinkManPara(obj){
	 obj.className ="linkMan";
	 obj.IdPrefix 	 = obj.className + "Id";
}
function getCustomerTable(){
//	var checkedValue = getRadioValue($(category.radioName)); 
	 var checkedValue = $("categoryRN").value;
	 
	if(checkedValue == 1) checkedValue = null;
//	alert("调用");
	
	var pageIndex = customer.page.pageIndex;
	customer.reset();
	customer.page.pageIndex = pageIndex;
	
	customer.obj.customerCategoryId = checkedValue;
	customer.obj.orgId = $('orgId').value;
	customer.obj.loginUser = loginUser;
	customer.getCustomers(customer); 
}
//翻页处理
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == customer.pageInfo){
		var page = new Page(customer.pageInfo,customer.pageSize);
		page.goNextPage(pageIndex);
		customer.page = page;
		
		getCustomerTable();
	}
}

function editInfo(id,radioId){
	 var checkedValue = $("categoryRN").value;
	if(checkedValue ==1 ){//直接进行编辑时用
		radioId = 1;
	}
	parent.location.href ="editCustomer.html?id="+id+"&pageIndex="+customer.page.pageIndex+"&radioId="+radioId;
}

function getTable(){
	var state = $("categoryRN").value;
	if(state ==1 )state = null;
	customer.reset();
	customer.obj.customerCategoryId = state;
	customer.obj.orgId = $('orgId').value;
	customer.obj.loginUser = loginUser;
	
	
	customer.page.pageIndex = 1;
	customer.getCustomers(customer);
//	getCustomerAutoComplt();
}

//function getCustomerAutoComplt(){
//	var type = getRadioValue($(category.radioName));
//	if(type ==1 ) type = null;
////	customer.obj.customerCategoryId= type;
//	
//	
//	function fun(userId){
////		alert(userId);alert(type);
//		customer.getCustomerAutoComplet2(userId,type,payCustomerAutoComplet);
//	}
//	user.getCurUserId($("config_username").value,function(id){fun(id)});
//}
function getCustomerAutoComplt(){
	var type = $("categoryRN").value;
	if(type ==1 ) type = null;

	customer.obj.customerCategoryId= type;
//    customer.obj.customerName =null;
    customer.obj.orgId = $('orgId').value;

    customer.storeCustomer = customer.getStoreCustomersAnalyze('remote',customer.obj);    
	customer.customerCommand =new Ext.form.ComboBox({
	 	  id:'customerName',
	 	  name:'customerName',
		  renderTo:'extCustomerDiv2',
		  tiggerAction:'all',
		  store:customer.storeCustomer,
		  editable: true,
		  triggerAction: 'all', //query all
		  lastQuery:'1',
		  displayField:'customerName',
		  valueField:'id',
		  mode:'remote',
		  allowBlank:false,
		   width:138,
		   forceSelection:false, 
		  allowBlank:false,
		  emptyText:'',
		  minChars:2,
		  hiddenName:'helpCode', //提交传过去的值 
		  filterFiled:'customerName',
		   params:customer.obj,
		  listeners:{beforequery:customer.comboFilterBy2.createDelegate(this)}	
	 });
	 



//	cmd.on("select" , function(box)
//    {
////        alert(box.getValue() + "-" + box.getRawValue());
//		searchCustomer(box.getRawValue());
//    });
//	customer.makeSelectAnalyze2(customer.obj,"customerName","",function(){});
	
//	function fun(userId){
////		alert(userId);alert(type);
//		customer.getCustomerAutoComplet2(userId,type,payCustomerAutoComplet);
//	}
//	user.getCurUserId($("config_username").value,function(id){fun(id)});
}


function getLinkManAutoComplt(){
	linkMan.getLinkManAutoComplet(payLinkManAutoComplet,linkMan.obj);
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
		searchCustomer();
	}
	
	var onTextBlur = function(ev){

		oDiv.style.visibility = "hidden";
		
		if(trim(oText.value) == "" ){
			$("customerId").value = '0';
			$("customerCategoryId").value = '0';
			searchCustomer();
		}
	}
   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown_customerId,onTextBlur,hidenColumName,indexColumName_customerName,allColumsName_customerName,allColumsTitle);
}
function searchCustomer(){
//	var customerId = customerId;
	var type = $("categoryRN").value;
	if(type == 1 ) type = null;
//	if(customerId =='0' ) customerId = null;
//	 alert( Ext.getCmp("customerName").getValue());
//	  alert( Ext.fly("customerName").getValue());

    var linkmanName = $("linkmanName").value;
	  
     
	  
	customer.reset();
//	customer.obj.id = customerId;
    customer.obj.customerName = Ext.fly("customerName").getValue();
    
    customer.obj.linkMan = {linkmanName:linkmanName};
//    customer.obj.linkMan.linkmanName = linkmanName;
    customer.obj.orgId = $('orgId').value;
	customer.obj.customerCategoryId = type;
	customer.page.pageIndex =0;
	customer.obj.loginUser = loginUser;
	customer.getCustomers(customer);
}

function payLinkManAutoComplet(objs){
		
	var oText_linkmanId = $("linkmanName");
	var oDiv_linkmanId = $("theDivMainLinkMan");
	
	var indexColumName_linkmanId = ["linkmanName"];
	var allColumsName_linkmanId =["id","linkmanName"];
	var allColumsTitle_linkmanId = ["联系人"];
	
	var onDivMouseDown_linkmanId = function(ev){
		var tr = getElementByEvent(ev);
		$("linkManId").value = getCellValue(tr,0);
		$("linkmanName").value = getCellValue(tr,1);
		
		oText_linkmanId.value = getCellValue(tr,1);
		
		searchCustomerByLinkmanId();
	}
	
	var hidenColumName = ["id"];
	
	var onTextBlur = function(ev){
		oDiv_linkmanId.style.visibility = "hidden";
		
		if(trim(oText_linkmanId.value) == "" ){
			$("linkManId").value = '0';
			searchCustomerByLinkmanId();
		}
	}
   new AutoComplete(objs,oText_linkmanId,oDiv_linkmanId,-1,onDivMouseDown_linkmanId,onTextBlur,hidenColumName,indexColumName_linkmanId,allColumsName_linkmanId,allColumsTitle_linkmanId);
	
}

function searchCustomerByLinkmanId(){
	var linkmanId = $("linkManId").value;
	var type = $("categoryRN").value;
	if(type == 1 ) type = null;
	
	if(linkmanId == '0'){
		customer.reset();
		customer.page.pageIndex =0;
		customer.obj.orgId = $('orgId').value;
		customer.obj.loginUser = loginUser;
		customer.getCustomers(customer);
	}else{
		var func = function(o){
			var customerId = o.customerId;
			if(customerId==null)customerId=0;
			customer.reset();
			customer.obj.orgId = $('orgId').value;
			customer.obj.id = customerId;
			customer.page.pageIndex =0;
			customer.obj.loginUser = loginUser;
			customer.getCustomers(customer);	
		}
	
		linkMan.getLinkMan(func,linkmanId);
	}
}

