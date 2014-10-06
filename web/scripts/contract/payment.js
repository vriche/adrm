function button_addPayment(){
	//检测是否处于编辑状态
	var s =  checkPaymentEeitStates();
	if(!s) return false;
    	
	var tddo = document.createElement("td");

	var mytr = paymentBody.firstChild;
	
	if(mytr != "undefined" && mytr != null && mytr !=""){
		var myclass = mytr.getAttribute("class");
		if(myclass =="empty") mytr.remove();		
	}
	

	var tr = document.createElement('TR');

    var td1   = document.createElement('TD');
    var td2   = document.createElement('TD');
    var td3   = document.createElement('TD');
    var td4   = document.createElement('TD');
    var td5   = document.createElement('TD');
    var td6   = document.createElement('TD');
    
    var inp1  = document.createElement('INPUT');  inp1.setAttribute("id","payNumber");
    inp1.style.cssText = "width:100%;aling:center;border:5px;text-align:left;cursor:hand;";
    var inp4  = document.createElement('INPUT');  inp4.setAttribute("id","moneyPay");
    inp4.style.cssText = "width:100%;aling:center;border:5px;text-align:left;cursor:hand;";
    var inp5  = document.createElement('INPUT');  inp5.setAttribute("id","moneyIn");  inp5.setAttribute("readonly","true"); 
    inp5.style.cssText = "width:100%;aling:center;border:5px;text-align:left;cursor:hand;";   
    
    
	var saveImg = makeImagHtml("image/save.png","Btn_SavePayment","18","18",0,"button_save_payment");
	var deleImg = makeImagHtml("image/restore.png","Btn_Cannel_ID","18","18",0,"button_del_payment"); 
	var cannelImg = makeImagHtml("image/restore.png","Btn_Cannel_ID","18","18",0,"button_cannel_edit_payment");
	var editImg = makeImagHtml("mage/edit.png","Btn_Edit_ID","18","18",0,"button_edit_payment"); 
    
    cannelImg.onclick = function(){
    	$("hiddenArea").appendChild($("incomePurposeId"));
    	tr.remove(); 
    	setColors(mytablebody,color1,color2);
    }
	tddo.appendChild(saveImg);
	tddo.appendChild(cannelImg);   
   
    
    paymentBody.appendChild(tr);
    
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tr.appendChild(td4);
    tr.appendChild(td5);
    tr.appendChild(td6);    

    td1.appendChild(inp1);			   
    td3.appendChild($("incomePurposeId"));
    td4.appendChild(inp4);
    td5.appendChild(inp5);
    
    td2.innerHTML = "<input type=\"text\"  style=\"width:100%;aling:center;border:5px;\" id=\"payDate\"  readonly=\"true\" onclick=\"button_showdate('payDate','anchorPayDate')\"/> " +
                    "<span id=\"anchorPayDate\" name=\"anchorPayDate\"></span>";
    td6.appendChild(tddo);

    setColors(paymentBody,color1,color2);
	
}

function button_save_payment(obj) {

	 var contractId = $("contractId").value;

	 var id = obj.getAttribute("paraId");

	 if(contractId != ''&& contractId != "-1" && contractId != "null" ){
		 savePayment(id); 	 
	 }else{
	 	alert("请先保存合同基本信息");
	 } 	
}

function savePayment(id){

	var obj = DWRUtil.getValues(Payment);
	obj.id = id;
	if(id == 0) obj.id = null;

	$("hiddenArea").appendChild($("incomePurposeId"));

	ContractPaymentManager.saveContractPayment(obj,getPayment);

}

function button_del_payment(){
	//检测是否处于编辑状态
	var s =  checkPaymentEeitStates();
	if(!s) return false;

	if (confirmDelete('payment')){ 
		var id = this.getAttribute("paraId");
		ContractPaymentManager.removeContractPayment(id,getPayment);	   	
	}
}

function checkPaymentEeitStates(){
	var Btn_SavePayment = $("Btn_SavePayment");
	if(!isUndefined(Btn_SavePayment)){
	    alert("已在编辑状态.");
	    return false;
	}
	return true;
}

function button_cannel_edit_payment(){
	$("hiddenArea").appendChild($("incomePurposeId"));
	
	getPayment();
}

function button_edit_payment(event){
	//检测是否处于编辑状态
	var s =  checkPaymentEeitStates();
	if (!s) return false;

	var e = event || window.event;
	var obj = Event.element(e);	
	var rows = $("paymentBody").getElementsByTagName("tr");
	var rowNum = rows.length; 
	var id = obj.getAttribute("paraId");
	var tr1= obj.parentNode.parentNode.parentNode;

	var payNumber = tr1.getAttribute("payNumber"); 
	var payDate = tr1.getAttribute("payDate"); 
	var incomePurposeId = tr1.getAttribute("incomePurposeId"); 
	var moneyPay = tr1.getAttribute("moneyPay");

		
	var container = document.createElement("span"); 


	var tr2 =  DWRUtil._addRowInner(cellFunAddRowPaymentEdit,
	{  
		rowCreator:function(options) {  
			var row = document.createElement("tr");  
			var rowIndex = rowNum;
	        row.style.cssText = tr1.style.cssText;
			return row;  
		},   
		cellCreator:function(options) {  
			var td = document.createElement("td");  
			return td;  
		}  
	});
		   
	var inputs = tr2.getElementsByTagName("input");
	var cells = tr1.getElementsByTagName("td");
	
	inputs[0].setAttribute("value",payNumber);
	inputs[1].setAttribute("value",payDate);
	inputs[2].setAttribute("value",moneyPay);


    tr2.setAttribute("id","paymentRow"+id);
    tr2.setAttribute("paraId",id);
	tr2.setAttribute("payNumber",payNumber);
	tr2.setAttribute("payDate",payDate);
	tr2.setAttribute("incomePurposeId",incomePurposeId);
	tr2.setAttribute("moneyPay",moneyPay);
           
	container.appendChild(tr2);
	  
	new Insertion.After($("paymentRow"+id),container.innerHTML);

	tr1.remove();
	
	$("incomePurposeId").value = incomePurposeId;

	var saveImg = $("Btn_SavePayment");
	saveImg.setAttribute("paraId",id);
	
}

var cellFunAddRowPaymentEdit = [
		function() { return makeInputText("payNumber","text","")},
		function() { return makeDateInputTextHmtl("payDate","anchorWStart",curDate,"button_showdate_input_edit").innerHTML},
		function() { return $("incomePurposeId")},
		function() { return makeInputText("moneyPay","text","")},
		function() { return ""},
		function() { 
    	              var paraId = -1;
    	              var saveImg = makeImagHtml("image/save.png","Btn_SavePayment","18","18",paraId,"button_save_payment");
    	              return saveImg;
		           },
		function() { 
    	              var paraId = -1;
    	              var cannelImg = makeImagHtml("image/restore.png","Btn_CanlelPayment","18","18",paraId,"button_cannel_edit_payment");
    	              return cannelImg;
		           }
	]	

function getPayment(){
	var pageIndex_payment = DWRUtil.getValue("pageIndex_payment")*1;
	var contractId = $("contractId").value;

	if(contractId != ''){
		resetPayment();
		Payment.contractId = contractId;
		ContractPaymentManager.getContractPaymentsPage(fillTable_Payment,Payment,pageIndex_payment,pageSize);
	}

}

function fillTable_Payment(Payment) {

	var pageIndex_payment = DWRUtil.getValue("pageIndex_payment")*1;
	rowNum =(pageIndex_payment-1)*pageSize+1;
	
	DWRUtil.removeAllRows("paymentBody");
	DWRUtil.addRows("paymentBody",Payment,cellFunctions_Payment,
	{  
		  rowCreator:function(options) {  
			   var row = document.createElement("tr");  
			   var rowIndex = options.rowIndex;
	           row.setAttribute("id","paymentRow"+options.rowData.id);
	           row.setAttribute("incomePurposeId",options.rowData.incomePurpose.id);
	           row.setAttribute("payDate",options.rowData.payDate);
	           row.setAttribute("payNumber",options.rowData.payNumber);
	           row.setAttribute("moneyPay",options.rowData.moneyPay);
	           row.setAttribute("moneyIn",options.rowData.moneyIn);
			   return row;  
		  },  
		  
		  cellCreator:function(options) {  
			    var td = document.createElement("td"); 
			    return td;  
		  }  
	
	});
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
    incomePurpose:incomePurpose,
    incomePurposeId:null,
    moneyPay:null,
    moneyIn:null
  };
  
 var incomePurpose = 
 {
 	id:null,
 	name:null
 }
  
  
  function resetPayment(){
  	Payment.id = null;
  	Payment.payDate = null;
  	Payment.payNumber = null;
  	Payment.contract.code = null;
  	Payment.order.orderCode = null;
  	Payment.incomePurpose = null;
  	Payment.customerId = null;
  	Payment.incomePurposeId = null;
  	Payment.moneyPay = null;
  	Payment.moneyIn = null;
  }

/***********************obj end*******************/

var cellFunctions_Payment = [
  	function(Payment) { return Payment.payNumber },
  	function(Payment) { return formatDateOrder(Payment.payDate)},
  	function(Payment) { return Payment.incomePurpose.name },
    function(Payment) { return Payment.moneyPay },
    function(Payment) { return Payment.moneyIn },
    function(Payment) {
    	var paraId = Payment.id;
	    var editImg = makeImag("image/edit.png","Btn_editPayment","18","18",paraId,button_edit_payment);
	    var deleImg = makeImag("image/button_delete.gif","Btn_deletePayment","18","18",paraId,button_del_payment);
	    editImg.setAttribute("paraId",paraId);
	    deleImg.setAttribute("paraId",paraId);
	 	var td = document.createElement("td"); 
	 	td.appendChild(editImg);
	 	td.appendChild(deleImg);
	    return td;
    }
];






/*******************************
 * 分页处理
 *******************************/



	
	
function getPageCount_Payment(){
	var contractId = $("contractId").value;
	
	resetPayment();
	Payment.contractId = contractId;
	ContractPaymentManager.getContractPaymentsCount(showPage_Payment,Payment);
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
	var contractId = $("contractId").value;
	DWRUtil.setValue("pageIndex_payment",pageIndex_payment);
	resetPayment();
	Payment.contractId = contractId;
	if(contractId != ''){ContractPaymentManager.getContractPaymentsPage(fillTable_Payment,Payment,pageIndex_payment,pageSize);}
}
	

	