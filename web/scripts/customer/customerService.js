var customer = new Customer();
var category = new Category();
var customerType = new CustomerType();
var industryType = new Industry();
var payment = new PayMent();
var customerAddress = new CustomerAddress();
var linkman = new LinkMan();
var linkHistory = new LinkHistory();
var contract = new Contract();
var order = new Order();
var income = new Income();
var matter = new Matter();
var feedbackInfo = new FeedbackInfo();
var user = new User();
  var org = new SysOrg();
var comboCusName;
var ctxPath;
var editMode;
var popupcenter = new Popupcenter();
var config_customerOwnerParam;
var config_isUserCustomerRelParam;
var tempID;
var orgId = 1;
var tabbar;

callOnLoad(init);

function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
//    var picBank = $("pic_bank");
//	picBank.style.height = dialogcontent.offsetHeight * 0.45 +"px";

    var details = $("details");
  
    details.style.height = dialogcontent.offsetHeight * 0.58 +"px";	
    
} 

function init(){
	
    config_useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
    config_customerOwnerParam = _app_params.sysParam.customerOwnerParam;
    config_isUserCustomerRelParam = _app_params.sysParam.isUserCustomerRelParam;   
    
    if(config_customerOwnerParam == 0&&$("customer_Rel")!=null) {$("customer_Rel").style.cssText ="display:none;"}
	if(config_useMoreCarrierSortParam == 0){$('orgId_td').hide();}
	ctxPath = _app_params.ctxPath;
	userName =  _app_params.user.username;
    userId=  _app_params.user.id;
    
    _make_org_select("orgId",120,"refreshForm");	    
  	
// 	org.makeSelect(org.obj,"orgId","refreshForm",function(){
// 		if(config_useMoreCarrierSortParam ==1){
//			orgId =  getParamFromUrl(window.location.href,"orgId");
//		}else{
//			orgId = 1;
//		}	
//
//		 $('orgId').value = orgId;		
//		 
//		if($('orgId').options.length<2){
//			$('orgId_td').hide();
//		}		
// 		
// 	});	
 	

//	getCategorys();
	

	if(config_isUserCustomerRelParam == 0){
		if($("customer_carrier_Rel")!=null)
		$("customer_carrier_Rel").style.cssText ="display:none;"
	}
	
//	oaAreaCity.makeSelectAnalyze(oaAreaCity,oaAreaCity.selectName,"",setOaAreaCitySelected);
	
	setCustomerPara(customer);
	setCustomerContractPara(category);
	setCustomerCustomerTypePara(customerType);
	setIndustryTypePara(industryType);
	setCustomerParentPara(customer);
	setUserPara(user);
	


 	category.obj.loginUser = userName;
	category.makeSelectAnalyze2(category.selectName,"",setCategorySelected);
	


	customerType.makeSelectAnalyze(customerType.obj,customerType.selectName,"",setCustomerTypeSelected);
//	customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
	industryType.makeSelectAnalyze(industryType,industryType.selectName,"",setIndustryTypeSelected);
//	customer.makeSelectAnalyze(customer,customer.selectName,"",setCustomerSelected);


	getDateTypeXML($("delayDateUnit"),"dateUnit","60");
	

	getExpireDaysXML($("paymentExpireDays"),"expireDays","60");

	buttonEventFill();
	resetHeigth();
//	comboEvent();
	var radioId = getRadioIdByURL();
	if(radioId > 0&& radioId != 1) $("customerCategoryId").value = radioId;
	
	editMode = getParamFromUrl(document.location.href,"id")
//	if(editMode*1>0){
		$("customerIds").value = editMode;
		if(editMode*1 >0) getCustomerForm();
		
		initTabbar();
		
//	}

    customer.obj.orgId = orgId;
	customer.makeSelectAnalyze(customer.obj,customer.selectName,"",setCustomerSelected);
	
	
	
	

}





function refreshForm(){
	    var orgId = $("orgId").value;
		customer.reset();
		DWRUtil.setValues(customer.obj);
		$("customerIds").value =  null;
		 $("orgId").value = orgId;
		
		        
		getDateTypeXML(1);
} 
function comboEvent(){
	comboCusName=new dhtmlXCombo("theDivCustomerName","alfa2",120);
  	comboCusName.enableFilteringMode(true);
  	customer.reset();
	var func = function(xml){
			comboCusName.clearAll();
			comboCusName.loadXMLString(xml);
	}
	customer.getParentCustomersXML(customer.obj,func);
}

function getCustomerForm(){

		 function func(objs){
		 	
		 		$("customerCategoryId").value = objs.customerCategoryId;
		 		$("customerTypeId").value = objs.customerTypeId;
		 		$("customerName").value = objs.customerName;
		 		$("industryTypeId").value = objs.industryTypeId;
		 		$("parentId").value = objs.parentId;
//		 		comboCusName.setComboText(objs.parentId) ;

				tempID =  objs.parentId;
		 		
		 		$("customerLevel").value = objs.customerLevel;
		 		$("telephone").value = objs.telephone;
		 		$("fax").value = objs.fax;
		 		$("webSite").value = objs.webSite;
		 		$("helpCode").value = objs.helpCode;
		 		
		 		$("creditAccount").value = objs.creditAccount;
		 		$("creditSpan").value = objs.creditSpan;
		 		$("discountRate").value = objs.discountRate;
		 		$("dateUnit").value = objs.delayDays; 			//�������� 0 �� 1 ��
				$("unit").value = objs.delayDateUnit; 			// 0 �� 1 ��
				$("expireDays").value = objs.paymentExpireDays; 	   //����
		
				$("accountName").value = objs.accountName ; 	   //������
				$("accountBank").value = objs.accountBank; 	   //��������
				$("accountNumber").value = objs.accountNumber; 	   //������
				$("ownerAgent").value = objs.ownerAgent; 	   //���˴���
				$("accountAddress").value = objs.accountAddress; 	   //������ַ
				
				$("orgId").value = objs.orgId; 	   //��֯
		 		
   				    }
   				
		        customer.getCustomerOne($("customerIds").value,func);

}

function getPageIndexByURL(){
	var url = window.location.href;
	var start = url.indexOf("&");
//	alert(startPos + "     "+url);
	var end = url.length;
	var str = url.substring(start+1,end);
	var startPos = str.indexOf("=");
	var endPos = str.indexOf("&");
	var pageIndex = null;
	pageIndex = str.substring(startPos+1,endPos)*1;
	pageIndex = pageIndex>0?pageIndex:1;
//	alert(startPos+"         "+endPos+"    "+pageIndex);
	return pageIndex;
	
}

function getRadioIdByURL(){
	var url = window.location.href;
	var startPos = url.length-1;
	var endPos = url.length;
	var radioId = null;
	radioId = url.substring(startPos,endPos)*1;
	return radioId;
	
}


function selectCustomerCarrierRel(){
	var customrerId = $("customerIds").value;
//	 alert(customrerId);
	if(customrerId =='' || customrerId ==null){
	   	alert("���ȱ���ͻ�������Ϣ����ִ�д˲�����");
	   	return false;
    }
	popupcenter.url ="selectPopup/customerCarrierRel.html?id=" +customrerId;
	popupcenter.model = 8;
	popupcenter.popupcenter(popupcenter);
}
function selectCustomerRel(){
	var customrerId = $("customerIds").value;
//	 alert(customrerId);
	if(customrerId =='' || customrerId ==null){
	   	alert("���ȱ���ͻ�������Ϣ����ִ�д˲�����");
	   	return false;
    }
	popupcenter.url ="selectPopup/selectCustomerRel.html?id=" +customrerId;
	popupcenter.model = 6;
	popupcenter.popupcenter(popupcenter);
}

function selectOrderDetail(){
	var customrerId = $("customerIds").value;
//	 alert(customrerId);
	if(customrerId =='' || customrerId ==null){
	   	alert("���ȱ���ͻ�������Ϣ����ִ�д˲�����");
	   	return false;
    }
	popupcenter.url ="selectPopup/orderIndex.html?id=" +customrerId+"&userId="+userId;
	popupcenter.model = 8;
	popupcenter.popupcenter(popupcenter);
}

function buttonEventFill(){
	
	var Bt_save = $("Btn_save");
	Bt_save.setAttribute("href","javascript:void 0");
	Bt_save.onclick = saveCustomer;
	
	var Btn_del = $("Btn_del");
	Btn_del.setAttribute("href","javascript:void 0");
	Btn_del.onclick = delCustomer;
	
	var Btn_cancel = $("Btn_cancel");
	Btn_cancel.setAttribute("href","javascript:void 0");
	Btn_cancel.onclick = cancelCustomer;
	
	var Btn_add = $("Btn_add");
	Btn_add.setAttribute("href","javascript:void 0");
	Btn_add.onclick = addCustomer;		

var Bt_customer_Rel = $("customer_Rel");
if(Bt_customer_Rel!=null){
	Bt_customer_Rel.setAttribute("href","javascript:void 0");
	
	Bt_customer_Rel.onclick = selectCustomerRel;}
	
	var Bt_customer_carrier_Rel = $("customer_carrier_Rel");
	if(Bt_customer_carrier_Rel!=null){
	Bt_customer_carrier_Rel.setAttribute("href","javascript:void 0");
	Bt_customer_carrier_Rel.onclick = selectCustomerCarrierRel;}
	
	//var Bt_order_detail = $("order_detail");
	//Bt_order_detail.setAttribute("href","javascript:void 0");
	//Bt_order_detail.onclick = selectOrderDetail;

}

function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
}
function setCustomerContractPara(obj){
	 obj.className  = "category";
	 obj.selectName =  "customerCategoryId"; 
}
function setCustomerCustomerTypePara(obj){
	 obj.className  = "customerType";
	 obj.selectName =  "customerTypeId"; 
}
function setIndustryTypePara(obj){
	 obj.className  = "industryType";
	 obj.selectName =  "industryTypeId"; 
}
function setCustomerParentPara(obj){
	 obj.className  = "customer";
	 obj.selectName =  "parentId"; 
}

function setCategorySelected(){
	$("customerCategoryId").setAttribute("style","margin-left:-100px;width:120px;height:20px");
}
function setCustomerTypeSelected(){
	$("customerTypeId").setAttribute("style","margin-left:-100px;width:120px;height:20px");
}
function setIndustryTypeSelected(){
	$("industryTypeId").setAttribute("style","margin-left:-100px;width:120px;height:20px");
}
function setCustomerSelected(){
	$("parentId").setAttribute("style","margin-left:-100px;width:120px;height:20px");
	$("parentId").value = tempID;
}
function setOaAreaCitySelected(){
	$("areaCitys").setAttribute("style","margin-left:-100px;width:120px;height:20px");
}
function getCustomerAutoCompltByName(ev){
	var customerName =$("customerNames").value;
	customer.obj.customerName = customerName;
	
	if(ev.keyCode == 13){
		customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
		$("customerNames").value="";
	}
}
function resetText(ev){
	 $("customerNames").value = null;
	 $("customerIds").value = null;
}

function getDateTypeXML(i){
	var el = $("delayDateUnit");
	var name = "dateUnit";
	var width = 60;
	var typeDate = $("unit").value;
	if (i == 1) {
		if(typeDate==1){
			dateXml(el,name,width);
		}else{
			monthXml(el,name,width);
		}

		dateXml($("paymentExpireDays"),"expireDays",width);
	}else{
		if(typeDate==1){
			dateXml(el,name,width);
		}else{
			monthXml(el,name,width);
		}
	}

}
function getExpireDaysXML(el,name,width){
	dateXml(el,name,width);
}

function setUserPara(obj){
	 obj.className  = "user";
	 obj.IdPrefix 	= obj.className + "Id";
}

//����б�
function initTabbar(){
	
	     if(!tabbar){
			var imagePath = ctxPath + "image/dhtmlXTabbar/";
			
            tabbar=new dhtmlXTabBar("a_tabbar","top");
            
            tabbar.setImagePath(imagePath);
            tabbar.setStyle("silver");
            //tabbar.setOffset(3);     
            tabbar.enableContentZone(false);
            //tabbar.loadXML("tabs7.xml");

            tabbar.addTab("Addresses","��ַ��Ϣ",100);
	    	tabbar.addTab("Linkman","��ϵ��",100);
	    	tabbar.addTab("LinkHisotry","��ϵ��¼",100);
	    	tabbar.addTab("Contract","��ͬ",100);
	    	tabbar.addTab("Order","���۶���",100);
	    	tabbar.addTab("Income","�����¼",100);
	    	tabbar.addTab("ContractPayment","Ƿ���¼",100);
	    	tabbar.addTab("Matter","���Ĳ�Ʒ",100);
	    	tabbar.addTab("FeedbackInfo","�ͻ����",100);

 	    	tabbar.setOnSelectHandler(function(id){
 	    	              //alert(id)
			 var cusId = $("customerIds").value==null||$("customerIds").value==""?0:$("customerIds").value;
				window.frames.details.document.location.href="selectPopup/customer"+id+"List.html?cusId="+ cusId;
				return true;
			});
			
	     	setTimeout( function() {tabbar.setTabActive("Addresses",true);},5);
	     }
	
	}	  

function button_add_new_obj(type){
	if(type == 0){
		customerAddress.addNewRow('new',null);
	}
	if(type == 1){

		linkman.addNewRow('new',null);

	}	
	if(type == 2){
		linkHistory.addNewRow('new',null);
		getDate();
	}		
}

function getDate(){
	Calendar.setup({
		inputField  : "linkDate",	  // id of the input field
		ifFormat	: "%Y%m%d",	  // the date format
		button	  : "linkDate"	// id of the button
	});
}

//��Ŧ����¼�

function saveCustomer(){
	var testId = $("customerIds").value;
	
	
	var func = function(obj){
		
		$("customerIds").value = obj.id;
	   $("helpCode").value = obj.helpCode;
 
		alert("����ɹ���")
//		if(testId == 0){
//			getCustomerForm();
//			
//			if(testId > 0){
//					initTabbar();
//			}
//		
//
//		}
		
	}
	
	
	var customerName = $("customerName").value;

	if(customerName == ''){
		alert("�ʻ����Ʋ���Ϊ��");
		return false;
	}else{
		var parentId =  $("parentId").value;
		parentId = parentId != '' ? parentId :'0';
		
		customer.reset();
		customer.obj.customerName = customerName;
		customer.obj.id = $("customerIds").value;
		customer.obj.customerTypeId = $("customerTypeId").value;
		customer.obj.parentId = parentId;
		customer.obj.customerCategoryId = $("customerCategoryId").value;
		customer.obj.industryTypeId = $("industryTypeId").value;
		
		customer.obj.customerLevel = $("customerLevel").value;
		customer.obj.webSite = $("webSite").value;
		customer.obj.helpCode = $("helpCode").value;
		customer.obj.telephone = $("telephone").value;
		customer.obj.fax = $("fax").value;
		customer.obj.version = 0;
		
		customer.obj.creditAccount = $("creditAccount").value; 			//���ö��
		customer.obj.creditSpan = $("creditSpan").value; 			//�����ڼ�
		customer.obj.discountRate = $("discountRate").value; 			//�Żݱ���
		customer.obj.delayDays = $("dateUnit").value; 			//�������� 0 �� 1 ��
		customer.obj.delayDateUnit = $("unit").value; 			// 0 �� 1 ��
		customer.obj.paymentExpireDays = $("expireDays").value; 	   //����
		
		customer.obj.accountName = $("accountName").value; 	   //������
		customer.obj.accountBank = $("accountBank").value; 	   //��������
		customer.obj.accountNumber = $("accountNumber").value; 	   //������
		customer.obj.ownerAgent = $("ownerAgent").value; 	   //���˴���
		customer.obj.accountAddress = $("accountAddress").value; 	   //������ַ
		
		customer.obj.orgId =$("orgId").value; 	   //������ַ
	
		
//		customer.saveCustomerForm(customer.obj,func);
        customer.saveCustomerFormReturnObj(customer.obj,func);
       
	}
}

function delCustomer(){
	var id = $("customerIds").value;
	
	var func = function(){
		parent.location.href ="customers.html";
	}
	
	customer.removeCustomer(id,func);
}

function cancelCustomer(){
//	alert(getRadioIdByURL());
//	var radioId = getRadioIdByURL();
	
	var radioId = $("customerCategoryId").value;
//	alert("�ڶ�"+getPageIndexByURL());
	parent.location.href ="customers.html?pageIndex="+getPageIndexByURL()+"&radioId="+getRadioIdByURL();
}

function addCustomer(){
	parent.location.href ="editCustomer.html";
}

function dateXml(el,name,width){
	 var html="";
		html += "<select name='"+ name +"' id='"+ name +"' style='cursor: pointer;width:"+ width +"px;'  >";	
		
		html +="<option  value='0'>0</option>";
		html +="<option  value='1'>1</option>";
		html +="<option  value='2'>2</option>";
		html +="<option  value='3'>3</option>";
		html +="<option  value='4'>4</option>";
		html +="<option  value='5'>5</option>";
		html +="<option  value='6'>6</option>";
		html +="<option  value='7'>7</option>";
		html +="<option  value='8'>8</option>";
		html +="<option  value='9'>9</option>";
		html +="<option  value='10'>10</option>";
		html +="<option  value='11'>11</option>";
		html +="<option  value='12'>12</option>";
		html +="<option  value='13'>13</option>";
		html +="<option  value='14'>14</option>";
		html +="<option  value='15'>15</option>";
		html +="<option  value='16'>16</option>";
		html +="<option  value='17'>17</option>";
		html +="<option  value='18'>18</option>";
		html +="<option  value='19'>19</option>";
		html +="<option  value='20'>20</option>";
		html +="<option  value='21'>21</option>";
		html +="<option  value='22'>22</option>";
		html +="<option  value='23'>23</option>";
		html +="<option  value='24'>24</option>";
		html +="<option  value='25'>25</option>";
		html +="<option  value='26'>26</option>";
		html +="<option  value='27'>27</option>";
		html +="<option  value='28'>28</option>";
		html +="<option  value='29'>29</option>";
		html +="<option  value='30'>30</option>";
		html +="<option  value='31'>31</option>";

		html += "</select>";	
		el.innerHTML = html;
}
function monthXml(el,name,width){
	 var html="";
		html += "<select name='"+ name +"' id='"+ name +"' style='cursor: pointer;width:"+ width +"px;'  >";	
		
		html +="<option  value='0'>0</option>";
		html +="<option  value='1'>1</option>";
		html +="<option  value='2'>2</option>";
		html +="<option  value='3'>3</option>";
		html +="<option  value='4'>4</option>";
		html +="<option  value='5'>5</option>";
		html +="<option  value='6'>6</option>";
		html +="<option  value='7'>7</option>";
		html +="<option  value='8'>8</option>";
		html +="<option  value='9'>9</option>";
		html +="<option  value='10'>10</option>";
		html +="<option  value='11'>11</option>";
		html +="<option  value='12'>12</option>";
		
		html += "</select>";	
		el.innerHTML = html;
}


