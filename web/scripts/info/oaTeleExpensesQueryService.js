
var oaTeleExpenses = new OaTeleExpenses();

callOnLoad(init);	
  
function init(){ 	
	setOaTeleExpensesPara(oaTeleExpenses);
	
	getDate();
	
	buttenEvenFill();
	
	resetHeigth();
}

function buttenEvenFill(){
	var btn_search = $("search");
	btn_search.onclick = queryTeleExpenses;
	
	var Bt_displayChar = $("displayChar");
	Bt_displayChar.onclick = displayChar;
}

function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var teleExpensessQuery = $("teleExpensessQuery");
         
    teleExpensessQuery.style.height = (dialogcontent.offsetHeight -dialogcontent.offsetTop)*0.92 +"px";	
} 
function setOaTeleExpensesPara(obj){
	 
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className   = "oaTeleExpenses";	
	 obj.IdPrefix 	 = obj.className + "Id";
	 obj.fillObjName = obj.className + "Body";
	 obj.tableName   = "oaTeleExpensesList";
	 obj.tBody 		 = $(obj.fillObjName);
	 obj.color1 	 = "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 	 = "BACKGROUND-COLOR: #ECEFF4";
	 
	 obj.pageInfo 	 = "pageInfo" + obj.className;
	 obj.pageSize 	 = "50";
	 obj.page        = new Page(obj.pageInfo,obj.pageSize); 
}

function getDate(){
	Calendar.setup({
		inputField  : "beginDate",	  // id of the input field
		ifFormat	: "%Y%m%d",	  // the date format
		button	  : "beginDate"	// id of the button
	});
	
	Calendar.setup({
		inputField  : "overDate",	  // id of the input field
		ifFormat	: "%Y%m%d",	  // the date format
		button	  : "overDate"	// id of the button
	});
}

function queryTeleExpenses(){
	
	var func = function(objs){
		if(objs.length == 0){
			alert("Ã»ÓÐ¼ÇÂ¼");
			DWRUtil.removeAllRows(oaTeleExpenses.tBody);
		}else{
			oaTeleExpenses.fillTable_Query(objs);
		}
	}
	oaTeleExpenses.beginDate = $("beginDate").value;
	oaTeleExpenses.endDate = $("overDate").value;
	oaTeleExpenses.getOaTeleExpensesByBeginAndEndDate(oaTeleExpenses,func);
}


function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == oaTeleExpenses.pageInfo){
		var page = new Page(oaTeleExpenses.pageInfo,oaTeleExpenses.pageSize);
		page.goNextPage(pageIndex);
		oaTeleExpenses.page = page;
		queryTeleExpenses();
	}
}

function displayChar(){
	var startDate = $("beginDate").value;
	var endDate = $("overDate").value;
	
	parent.location.href ="oaTeleExpensesChart.html?startDate=" + startDate + "&" + endDate ;
}	