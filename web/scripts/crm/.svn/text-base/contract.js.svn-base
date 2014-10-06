var rowNum = 1;
var pageSize = 9;

function button_addContract(){
	var s =  checkEeitStates();
	if (!s) return false;
	location.href="editContract.html";
}

function getContract(){
	var pageIndex_contract = DWRUtil.getValue("pageIndex_contract")*1;
	var customerId = $("customerId").value;
	if(customerId != ''){
		resetContract();
		Contract.customerId = customerId;
		ContractManager.getContractsPage(fillTable_Contract,Contract,pageIndex_contract,pageSize);
	}
}

function fillTable_Contract(ContractList) {
	DWRUtil.removeAllRows("contractBody");
	DWRUtil.addRows("contractBody",ContractList,cellFunctions_Contract);
	setColors(contractBody,color1,color2);
	getPageCount_Contract();
}



/***********************obj start*****************/
  var Contract = 
	{
	id:null,
	customerId:null,
    code:null,
    moneySum:null,
    moneyExec:null,
    moneyIn:null,
    startDate:null,
    endDate:null,
    state:null
  };
  
  
  function resetContract(){
  	Contract.id = null;
  	Contract.customerId = null;
  	Contract.code = null;
  	Contract.moneySum = null;
  	Contract.moneyExec = null;
  	Contract.moneyIn = null;
  	Contract.startDate = null;
  	Contract.endDate = null;
  	Contract.state = null;
  }

/***********************obj end*******************/

var cellFunctions_Contract = [
  	function(Contract) { return "<a href='editContract.html?id=" +Contract.id +"'>" + Contract.code +"</a>"},
 	function(Contract) { return Contract.moneySum },
    function(Contract) { return Contract.moneyExec },
    function(Contract) { return Contract.moneyIn },
    function(Contract) { return formatDate(Contract.startDate) },
    function(Contract) { return formatDate(Contract.endDate) },
    function(Contract) { return Contract.state },
    function(Contract) { return "" }
];




/*******************************
 * 分页处理
 *******************************/

	
function getPageCount_Contract(){
	var customerId = $("customerId").value;
	resetContract();
	Contract.customerId = customerId;
	ContractManager.getContractsCount(showPage_Contract,Contract);
}	


function showPage_Contract(size){
	var tmp ="";
	var curSize = DWRUtil.getValue("totalRecords_contract")*1;
    var trs = contractBody.getElementsByTagName("tr");
    var curRows = trs.length;  
	var pageIndex_contract = DWRUtil.getValue("pageIndex_contract")*1;
    var pageCount = Math.ceil(size/pageSize);  
    
    DWRUtil.setValue("totalRecords_contract",size);	

	
    if( size > curSize && size > pageSize*pageIndex_contract && curSize > 0 && curRows == pageSize && pageIndex_contract > 0){
    	 pageIndex_contract = pageCount;
    	 DWRUtil.setValue("pageIndex_contract",pageIndex_contract);
    	 goNextPage_Contract(pageIndex_contract);	
    	 return false;
    }
    
    if( size < curSize && curSize > 0 && curRows == 0 && pageIndex_contract > 1){
    	 pageIndex_contract = pageIndex_contract*1 - 1;
    	 DWRUtil.setValue("pageIndex_contract",pageIndex_contract);
    	 goNextPage_Contract(pageIndex_contract);	
    	 return false;
    }    
    
	
	if (pageCount == 0){
		tmp ="没有找到记录";
	}
	if (pageCount > 0){
        tmp +='第<b style="color:green;">'+(pageIndex_contract)+'</b>页 共<b>'+(pageCount)+'</b>页';
        tmp +='&nbsp;&nbsp;&nbsp;';
	}
	        
    if (pageCount > 1){
    	
    	if(pageIndex_contract != 1){
	 	   tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Contract(1)">首页</a>';  
		   tmp +='&nbsp;&nbsp;&nbsp;';      		
    	}
     	
        if(pageIndex_contract > 1){
	       tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Contract('+ (pageIndex_contract*1-1) +')">上一页</a>';  
	       tmp +='&nbsp;&nbsp;&nbsp;';          	
        }
 
        if(pageIndex_contract < pageCount){  
	       tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Contract('+ (pageIndex_contract*1+1) +')">下一页</a>';  
	       tmp +='&nbsp;&nbsp;&nbsp;';           	
        }
   	
        if(pageIndex_contract != pageCount){
       	   tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Contract('+ (pageCount) +')">尾页</a>'; 
       	   tmp +='&nbsp;&nbsp;&nbsp;';            	
        }
    	
     }        

	$("pageInfo_contract").innerHTML = tmp;
}

function goNextPage_Contract(pageIndex_contract){
	var customerId = $("customerId").value;
	DWRUtil.setValue("pageIndex_contract",pageIndex_contract);
	resetContract();
	Contract.customerId = customerId;
	if(customerId != ''){ContractManager.getContractsPage(fillTable_Contract,Contract,pageIndex_contract,pageSize);}
}
	



