var rowNum = 1;
var pageSize = 9;

//function button_addPayment(){
//	var s =  checkEeitStates();
//	if (!s) return false;
//	
//	location.href="editContractPayment.html";
//	
//}

function getPayment(){
	var pageIndex_payment = DWRUtil.getValue("pageIndex_payment")*1;
	var customerId = $("customerId").value;
	if(customerId != ''){
		resetPayment();
		Payment.customerId = customerId;
		Payment.moneyIn = 0;
		ContractPaymentManager.getContractPaymentsPage_nopay(fillTable_Payment,Payment,pageIndex_payment,pageSize);
	}
}

function fillTable_Payment(PaymentList) {
	

	var pageIndex_payment = DWRUtil.getValue("pageIndex_payment")*1;
	rowNum =(pageIndex_payment-1)*pageSize+1;
	
	DWRUtil.removeAllRows("paymentBody");
	DWRUtil.addRows("paymentBody",PaymentList,cellFunctions_Payment);
	setColors(paymentBody,color1,color2);
	
	getPageCount_Payment();
}



/***********************obj start*****************/
  var Payment = 
	{
	id:null,
	customerId:null,
    payDate:null,
    payNumber:null,
    contract:{code:null},
    order:{orderCode:null},
    moneyPay:null,
    moneyIn:null
  };
  
 
  
  
  function resetPayment(){
  	Payment.id = null;
  	Payment.payDate = null;
  	Payment.payNumber = null;
  	Payment.contract.code = null;
  	Payment.order.orderCode = null;
  	Payment.customerId = null;
  	Payment.moneyPay = null;
  	Payment.moneyIn = null;
  }

/***********************obj end*******************/

var cellFunctions_Payment = [
  	function(Payment) { return formatDate(Payment.payDate)},
  	function(Payment) { return Payment.payNumber },
  	function(Payment) { return  "<a href='editContract.html?id=" +Payment.contractId +"'>" + Payment.contract.code +"</a>"},
  	function(Payment) { return  "<a href='editOrder.html?id=" +Payment.orderId +"'>" + Payment.order.orderCode +"</a>"},
    function(Payment) { return Payment.moneyPay },
    function(Payment) { return Payment.moneyIn }
];






/*******************************
 * 分页处理
 *******************************/



	
	
function getPageCount_Payment(){
	var customerId = $("customerId").value;
	resetPayment();
	Payment.customerId = customerId;
	Payment.moneyIn = 0;
	ContractPaymentManager.getContractPaymentsCount_nopay(showPage_Payment,Payment);
}	


function showPage_Payment(size){
	var tmp ="";
	var curSize = DWRUtil.getValue("totalRecords_payment")*1;
    var trs = paymentBody.getElementsByTagName("tr");
    var curRows = trs.length;  
	var pageIndex_payment = DWRUtil.getValue("pageIndex_payment")*1;
    var pageCount = Math.ceil(size/pageSize);  
    
    DWRUtil.setValue("totalRecords_payment",size);	

	
    if( size > curSize && size > pageSize*pageIndex_payment && curSize > 0 && curRows == pageSize && pageIndex_payment > 0){
    	 pageIndex_payment = pageCount;
    	 DWRUtil.setValue("pageIndex_payment",pageIndex_payment);
    	 goNextPage_Payment(pageIndex_payment);	
    	 return false;
    }
    
    if( size < curSize && curSize > 0 && curRows == 0 && pageIndex_payment > 1){
    	 pageIndex_payment = pageIndex_payment*1 - 1;
    	 DWRUtil.setValue("pageIndex_payment",pageIndex_payment);
    	 goNextPage_Payment(pageIndex_payment);	
    	 return false;
    }    
    
	
	if (pageCount == 0){
		tmp ="没有找到记录";
	}
	if (pageCount > 0){
        tmp +='第<b style="color:green;">'+(pageIndex_payment)+'</b>页 共<b>'+(pageCount)+'</b>页';
        tmp +='&nbsp;&nbsp;&nbsp;';
	}
	        
    if (pageCount > 1){
    	
    	if(pageIndex_payment != 1){
	 	   tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Payment(1)">首页</a>';  
		   tmp +='&nbsp;&nbsp;&nbsp;';      		
    	}
     	
        if(pageIndex_payment > 1){
	       tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Payment('+ (pageIndex_payment*1-1) +')">上一页</a>';  
	       tmp +='&nbsp;&nbsp;&nbsp;';          	
        }
 
        if(pageIndex_payment < pageCount){  
	       tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Payment('+ (pageIndex_payment*1+1) +')">下一页</a>';  
	       tmp +='&nbsp;&nbsp;&nbsp;';           	
        }
   	
        if(pageIndex_payment != pageCount){
       	   tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Payment('+ (pageCount) +')">尾页</a>'; 
       	   tmp +='&nbsp;&nbsp;&nbsp;';            	
        }
    	
     }        


	$("pageInfo_payment").innerHTML = tmp;
}

function goNextPage_Payment(pageIndex_payment){
	var customerId = $("customerId").value;
	DWRUtil.setValue("pageIndex_payment",pageIndex_payment);
	resetPayment();
	Payment.customerId = customerId;
	Payment.moneyIn = 0;
	if(customerId != ''){ContractPaymentManager.getContractPaymentsPage_nopay(fillTable_Payment,Payment,pageIndex_payment,pageSize);}
}
	

