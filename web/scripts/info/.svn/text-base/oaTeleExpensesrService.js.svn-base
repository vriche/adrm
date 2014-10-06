var oaTeleExpenses = new OaTeleExpenses();

callOnLoad(init);	
  
function init(){ 	
	setOaTeleExpensesPara(oaTeleExpenses);
	
	getOaTeleExpensesTable(oaTeleExpenses);
	
	buttenEvenFill();
}

function buttenEvenFill(){
	var Btn_add = $("addNew");
	Btn_add.onclick = add_new;
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
	 obj.pageSize 	 = "20";
	 obj.page        = new Page(obj.pageInfo,obj.pageSize); 
}

function getOaTeleExpensesTable(oaTeleExpenses){
	
	
	var func = function(objs){
		oaTeleExpenses.fillTable(objs);
	}
	
	oaTeleExpenses.getOaTeleExpensess(oaTeleExpenses,func);
}


function editInfo(id){
	parent.location.href ="editOaTeleExpenses.html?id="+id;
}

//∑≠“≥¥¶¿Ì
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == oaTeleExpenses.pageInfo){
		var page = new Page(oaTeleExpenses.pageInfo,oaTeleExpenses.pageSize);
		page.goNextPage(pageIndex);
		oaTeleExpenses.page = page;
		getOaTeleExpensesTable(oaTeleExpenses);
	}
}

function add_new(){
	parent.location.href ="editOaTeleExpenses.html?";
}









