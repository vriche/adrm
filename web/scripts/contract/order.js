

function button_addOrder(){
	var s =  checkEeitStates();
	if (!s) return false;
	
	location.href="editOrder.html";
	
}

function getOrder(){
	var pageIndex_order = DWRUtil.getValue("pageIndex_order")*1;
	var contractId = $("contractId").value;
	if(contractId != ''){
		resetOrder();
		Order.contractId = contractId;
		OrderManager.getOrdersPage(fillTable_Order,Order,pageIndex_order,pageSize);
	}
}

function fillTable_Order(OrderList) {
	var pageIndex_order = DWRUtil.getValue("pageIndex_order")*1;
	rowNum =(pageIndex_order-1)*pageSize+1;
	
	DWRUtil.removeAllRows("orderBody");
	DWRUtil.addRows("orderBody",OrderList,cellFunctions_Order);
	setColors(orderBody,color1,color2);
	
	getPageCount_Order();
}



/***********************obj start*****************/
  var Order = 
	{
	id:null,
	customerId:null,
	contractId:null,
    orderCode:null,
    contract:{code:null},
    orderPublic:{publishStartDate:null},
    orderPublic:{publishEndDate:null},
    orderPublic:{moneyRealpay:null},
    orderPublic:{moneyIn:null},
    isCkecked:null
  };
  
  
  function resetOrder(){
  	Order.id = null;
  	Order.customerId = null;
  	Order.code = null;
  	Order.contractId = null;
  	Order.contract.code = null;
  	Order.orderPublic.publishStartDate = null;
  	Order.orderPublic.publishEndDate = null;
  	Order.orderPublic.moneyRealpay = null;
  	Order.orderPublic.moneyIn = null;
  	Order.isCkecked = null;
  }

/***********************obj end*******************/

var cellFunctions_Order = [
    function(Order) { return rowNum++},
  	function(Order) { return "<a href='editOrder.html?id=" +Order.id +"'>" + Order.orderCode +"</a>"},
  	function(Order) { return Order.contract.code },
 	function(Order) { return formatDateOrder(Order.orderPublic.publishStartDate) },
    function(Order) { return formatDateOrder(Order.orderPublic.publishEndDate) },
    function(Order) { return Order.orderPublic.moneyRealpay },
    function(Order) { return Order.orderPublic.moneyIn },
    function(Order) { return Order.isCkecked },
    function(Order) { return "" }
];






/*******************************
 * 分页处理
 *******************************/

function getPageCount_Order(){
	var contractId = $("contractId").value;
	resetOrder();
	Order.contractId = contractId;
	OrderManager.getOrdersCount(showPage_Order,Order);
}	


function showPage_Order(size){
	var tmp ="";
	var curSize = DWRUtil.getValue("totalRecords_order")*1;
    var trs = orderBody.getElementsByTagName("tr");
    var curRows = trs.length;  
	var pageIndex_order = DWRUtil.getValue("pageIndex_order")*1;
    var pageCount = Math.ceil(size/pageSize);  
    
    DWRUtil.setValue("totalRecords_order",size);	

	
    if( size > curSize && size > pageSize*pageIndex_order && curSize > 0 && curRows == pageSize && pageIndex_order > 0){
    	 pageIndex_order = pageCount;
    	 DWRUtil.setValue("pageIndex_order",pageIndex_order);
    	 goNextPage_Order(pageIndex_order);	
    	 return false;
    }
    
    if( size < curSize && curSize > 0 && curRows == 0 && pageIndex_order > 1){
    	 pageIndex_order = pageIndex_order*1 - 1;
    	 DWRUtil.setValue("pageIndex_order",pageIndex_order);
    	 goNextPage_Order(pageIndex_order);	
    	 return false;
    }    
    
	
	if (pageCount == 0){
		tmp ="没有找到记录";
	}
	if (pageCount > 0){
        tmp +='第<b style="color:green;">'+(pageIndex_order)+'</b>页 共<b>'+(pageCount)+'</b>页';
        tmp +='&nbsp;&nbsp;&nbsp;';
	}
	        
    if (pageCount > 1){
    	
    	if(pageIndex_order != 1){
	 	   tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Order(1)">首页</a>';  
		   tmp +='&nbsp;&nbsp;&nbsp;';      		
    	}
     	
        if(pageIndex_order > 1){
	       tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Order('+ (pageIndex_order*1-1) +')">上一页</a>';  
	       tmp +='&nbsp;&nbsp;&nbsp;';          	
        }
 
        if(pageIndex_order < pageCount){  
	       tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Order('+ (pageIndex_order*1+1) +')">下一页</a>';  
	       tmp +='&nbsp;&nbsp;&nbsp;';           	
        }
   	
        if(pageIndex_order != pageCount){
       	   tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Order('+ (pageCount) +')">尾页</a>'; 
       	   tmp +='&nbsp;&nbsp;&nbsp;';            	
        }
    	
     }        


	$("pageInfo_order").innerHTML = tmp;
}

function goNextPage_Order(pageIndex_order){
	var contractId = $("contractId").value;
	DWRUtil.setValue("pageIndex_order",pageIndex_order);
	resetOrder();
	Order.contractId = contractId;
	if(contractId != ''){OrderManager.getOrdersPage(fillTable_Order,Order,pageIndex_order,pageSize);}
}
	

