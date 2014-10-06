
var rowNum = 1;
var pageSize = 9;

function button_addIncome(){
	var s =  checkEeitStates();
	if (!s) return false;
	
	location.href="editIncome.html";
}

function getIncome(){
	var pageIndex_income = DWRUtil.getValue("pageIndex_income")*1;
	var customerId = $("customerId").value;
	if(customerId != ''){
		resetIncome();
		Income.customerId = customerId;
		IncomeManager.getIncomesPage(fillTable_Income,Income,pageIndex_income,pageSize);
	}
}

function fillTable_Income(IncomeList) {
	var pageIndex_income = DWRUtil.getValue("pageIndex_income")*1;
	rowNum =(pageIndex_income-1)*pageSize+1;
	
	DWRUtil.removeAllRows("incomeBody");
	DWRUtil.addRows("incomeBody",IncomeList,cellFunctions_Income);
	setColors(incomeBody,color1,color2);
	
	getPageCount_Income();
}

/***********************obj start*****************/
  var Income = 
	{
	id:null,
	customerId:null,
    incomeDate:null,
    incomeCode:null,
    incomeMoney:null,
    incomeMode:{name:null},
    incomePurpose:{name:null},
    createDate:null
  };
  
  
  
  function resetIncome(){
  	Income.id = null;
  	Income.customerId = null;
  	Income.incomeCode = null;
  	Income.incomeDate = null;
  	Income.incomeMoney = null;
  	Income.incomeMode.name = null;
  	Income.incomePurpose.name = null;
  	Income.createDate = null;
  }

/***********************obj end*******************/
var cellFunctions_Income = [
 	function(Income) { return "<a href='editIncome.html?id=" +Income.id +"'>" + Income.incomeDate +"</a>"},
 	function(Income) { return Income.IncomeCode },
    function(Income) { return Income.incomeMoney },
    function(Income) { return ""},
    function(Income) { return ""},
    function(Income) { return "" }
];


/*******************************
 * 分页处理
 *******************************/

	
function getPageCount_Income(){
	var customerId = $("customerId").value;
	resetIncome();
	Income.customerId = customerId;
	IncomeManager.getIncomeCount(showPage_Income,Income);
}	


function showPage_Income(size){
	var tmp ="";
	var curSize = DWRUtil.getValue("totalRecords_income")*1;
    var trs = incomeBody.getElementsByTagName("tr");
    var curRows = trs.length;  
	var pageIndex_income = DWRUtil.getValue("pageIndex_income")*1;
    var pageCount = Math.ceil(size/pageSize);  
    
    DWRUtil.setValue("totalRecords_income",size);	
    
//    alert(pageCount);

	
    if( size > curSize && size > pageSize*pageIndex_income && curSize > 0 && curRows == pageSize && pageIndex_income > 0){
    	 pageIndex_income = pageCount;
    	 DWRUtil.setValue("pageIndex_income",pageIndex_income);
    	 goNextPage_Income(pageIndex_income);	
    	 return false;
    }
    
    if( size < curSize && curSize > 0 && curRows == 0 && pageIndex_income > 1){
    	 pageIndex_income = pageIndex_income*1 - 1;
    	 DWRUtil.setValue("pageIndex_income",pageIndex_income);
    	 goNextPage_Income(pageIndex_income);	
    	 return false;
    }    
    
	
	if (pageCount == 0){
		tmp ="没有找到记录";
	}
	if (pageCount > 0){
        tmp +='第<b style="color:green;">'+(pageIndex_income)+'</b>页 共<b>'+(pageCount)+'</b>页';
        tmp +='&nbsp;&nbsp;&nbsp;';
	}
	        
    if (pageCount > 1){
    	
    	if(pageIndex_income != 1){
	 	   tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Income(1)">首页</a>';  
		   tmp +='&nbsp;&nbsp;&nbsp;';      		
    	}
     	
        if(pageIndex_income > 1){
	       tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Income('+ (pageIndex_income*1-1) +')">上一页</a>';  
	       tmp +='&nbsp;&nbsp;&nbsp;';          	
        }
 
        if(pageIndex_income < pageCount){  
	       tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Income('+ (pageIndex_income*1+1) +')">下一页</a>';  
	       tmp +='&nbsp;&nbsp;&nbsp;';           	
        }
   	
        if(pageIndex_income != pageCount){
       	   tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Income('+ (pageCount) +')">尾页</a>'; 
       	   tmp +='&nbsp;&nbsp;&nbsp;';            	
        }
    	
     }        


	$("pageInfo_income").innerHTML = tmp;
}

function goNextPage_Income(pageIndex_income){
	var customerId = $("customerId").value;
	DWRUtil.setValue("pageIndex_income",pageIndex_income);
	resetIncome();
	Income.customerId = customerId;
	if(customerId != ''){IncomeManager.getIncomesPage(fillTable_Income,Income,pageIndex_income,pageSize);}
}
	

