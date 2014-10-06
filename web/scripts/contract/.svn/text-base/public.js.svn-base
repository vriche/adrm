var rowNum = 1;
var pageSize = 9;

var color1 = "BACKGROUND-COLOR: #f5f5f5";
var color2 = "BACKGROUND-COLOR: #ECEFF4";


callOnLoad(init);


function init() {
	
	buttonEventFill();
	
	initPage();
	
//	var payment_table = $("paymentList");
//	var payment_body = payment_table.getElementsByTagName("tbody")[0];
//	payment_body.setAttribute("id","paymentBody");
//    paymentBody = $("paymentBody");
//    
//    var target_table = $("targetList");
//	var target_body = target_table.getElementsByTagName("tbody")[0];
//	target_body.setAttribute("id","targetBody");
//    targetBody = $("targetBody");
    
    var order_table = $("orderList");
	var order_body = order_table.getElementsByTagName("tbody")[0];
	order_body.setAttribute("id","orderBody");	
    orderBody = $("orderBody");    
          
//	getPayment();
	getOrder();
//	getTarget();

}

//¶¯×÷Ìî³ä 
function buttonEventFill(){
//	var Bt_addPayment = $("Bt_addPayment");
//	Bt_addPayment.onclick=button_addPayment;	
	
	var Bt_addOrder = $("Bt_addOrder");
	Bt_addOrder.onclick=button_addOrder;
	
//	var Bt_addTarget = $("Bt_addTarget");
//	Bt_addTarget.onclick=button_addTarget;	
	
}


function initPage(){
	
//	DWRUtil.setValue("pageIndex_payment",1);
//	DWRUtil.setValue("totalRecords_payment",0);
//	$("pageIndex_payment").hide();
	
	DWRUtil.setValue("pageIndex_order",1);
	DWRUtil.setValue("totalRecords_order",0);
	$("pageIndex_order").hide();
	
//	DWRUtil.setValue("pageIndex_target",1);
//	DWRUtil.setValue("totalRecords_target",0);
//	$("pageIndex_target").hide();

}	



function checkEeitStates2(){
	var Btn_Save_ID = $("Btn_Save_ID");
	if(!isUndefined(Btn_Save_ID)){
		   return false;
    }
	return true;
}	

function formatDateOrder(mydate){
		//d : 19991231
		var d = mydate.toString();
		
		if (d != '' && d != null && !isUndefined(d) && d.length == 8){
			d = d.substring(0,4) +"/" + d.substring(4,6) +"/" + d.substring(6,8)
		}else{
			d = "1999/12/31";
		}
		return d;
}
	

	