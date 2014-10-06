
var color1 = "BACKGROUND-COLOR: #f5f5f5";
var color2 = "BACKGROUND-COLOR: #ECEFF4";


callOnLoad(init);

function init() {
	
	buttonEventFill();
	
	initPage();
	
	var agentInfo_table = $("agentInfoList");
	var agentInfo_body = agentInfo_table.getElementsByTagName("tbody")[0];
	agentInfo_body.setAttribute("id","agentInfoBody");
    agentInfoBody = $("agentInfoBody");
	
	var address_table = $("customerAddressList");
	var address_body = address_table.getElementsByTagName("tbody")[0];
	address_body.setAttribute("id","addressBody");	
    addressBody = $("addressBody");
    
	var linkMan_table = $("linkManList");
	var linkMan_body = linkMan_table.getElementsByTagName("tbody")[0];
	linkMan_body.setAttribute("id","linkManBody");	
    linkManBody = $("linkManBody");    
    
 	var linkHisotry_table = $("linkHisotryList");
	var linkHisotry_body = linkHisotry_table.getElementsByTagName("tbody")[0];
	linkHisotry_body.setAttribute("id","linkHisotryBody");	
    linkHisotryBody = $("linkHisotryBody");    
    
    var contract_table = $("contractList");
	var contract_body = contract_table.getElementsByTagName("tbody")[0];
	contract_body.setAttribute("id","contractBody");	
    contractBody = $("contractBody");  
    
    var order_table = $("orderList");
	var order_body = order_table.getElementsByTagName("tbody")[0];
	order_body.setAttribute("id","orderBody");	
    orderBody = $("orderBody");     
    
    var income_table = $("incomeList");
	var income_body = income_table.getElementsByTagName("tbody")[0];
	income_body.setAttribute("id","incomeBody");	
    incomeBody = $("incomeBody");         
     
    var payment_table = $("contractPaymentList");
	var payment_body = payment_table.getElementsByTagName("tbody")[0];
	payment_body.setAttribute("id","paymentBody");	
    paymentBody = $("paymentBody");    
    
    var matter_table = $("matterList");
	var matter_body = matter_table.getElementsByTagName("tbody")[0];
	matter_body.setAttribute("id","matterBody");	
    matterBody = $("matterBody");     
    
    var feedbackInfo_table = $("feedbackInfoList");
	var feedbackInfo_body = feedbackInfo_table.getElementsByTagName("tbody")[0];
	feedbackInfo_body.setAttribute("id","feedbackInfoBody");	
    feedbackInfoBody = $("feedbackInfoBody");      
    
          
//	getAgentInfo();
}


//¶¯×÷Ìî³ä 
function buttonEventFill(){
	
	var Bt_addAgentInfo = $("Bt_addAgentInfo");
	Bt_addAgentInfo.onclick=button_addAgentInfo;	
	
	var Bt_addAddress = $("Bt_addAddress");
	Bt_addAddress.onclick=button_addAddress;
	
	var Bt_addLinkMan = $("Bt_addLinkMan");
	Bt_addLinkMan.onclick=button_addLinkMan;
	
	var Bt_addLinkHisotry = $("Bt_addLinkHisotry");
	Bt_addLinkHisotry.onclick=button_addLinkHisotry;
	
	var Bt_addContract = $("Bt_addContract");
	Bt_addContract.onclick=button_addContract;	
	
	var Bt_addOrder = $("Bt_addOrder");
	Bt_addOrder.onclick=button_addOrder;	
	
	var Bt_addIncome = $("Bt_addIncome");
	Bt_addIncome.onclick=button_addIncome;
	
	var Bt_addMatter = $("Bt_addMatter");
	Bt_addMatter.onclick=button_addMatter;
	
	var Bt_addFeedbackInfo = $("Bt_addFeedbackInfo");
	Bt_addFeedbackInfo.onclick=button_addFeedbackInfo;	
	
			
}


function initPage(){
	
	DWRUtil.setValue("pageIndex_contract",1);
	DWRUtil.setValue("totalRecords_contract",0);
	$("pageIndex_contract").hide();
	
	DWRUtil.setValue("pageIndex_order",1);
	DWRUtil.setValue("totalRecords_order",0);
	$("pageIndex_order").hide();
	
	DWRUtil.setValue("pageIndex_income",1);
	DWRUtil.setValue("totalRecords_income",0);
	$("pageIndex_income").hide();	
	
	DWRUtil.setValue("pageIndex_payment",1);
	DWRUtil.setValue("totalRecords_payment",0);
	$("pageIndex_payment").hide();
	
	DWRUtil.setValue("pageIndex_matter",1);
	DWRUtil.setValue("totalRecords_matter",0);
	$("pageIndex_matter").hide();
	
	DWRUtil.setValue("pageIndex_feedbackInfo",1);
	DWRUtil.setValue("totalRecords_feedbackInfo",0);
	$("pageIndex_feedbackInfo").hide();
}	



function checkEeitStates2(){
	var Btn_Save_ID = $("Btn_Save_ID");
	if(!isUndefined(Btn_Save_ID)){
		   return false;
    }
	return true;
}	

function formatDate(mydate){
		//d : 19991231
		var d = mydate.toString();
		
		if (d != '' && d != null && !isUndefined(d) && d.length == 8){
			d = d.substring(0,4) +"/" + d.substring(4,6) +"/" + d.substring(6,8)
		}else{
			d = "1999/12/31";
		}
		return d;
}
	

	