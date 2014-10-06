//var orderdayinfo =new OrderDayInfo();
var user = new User();
var carrier = new Carrier();
var customer = new Customer();

var incomePull = new IncomePull();
//var userName ;
callOnLoad(init);

function init(){
	
    setIncomePullPara(incomePull);
	setCustomerPara(customer);
	setCarrierPara(carrier);
	setUserPara(user);
	
	carrier.obj.nodeLevel =1;
	carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","");
	user.makeSelectAnalyze(user,user.selectName,"",setUserSelected);

	buttonEventFill();
	getCustomerAutoComplt();
	
	resetHeigth();
	
}
function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var customerAnalyze_div = $("financeList_div");
    customerAnalyze_div.style.height = dialogcontent.offsetHeight * 0.8 +"px";	
    customerAnalyze_div.style.width = dialogcontent.offsetWidth -73 +"px";
    $("financeListTable").style.width =  customerAnalyze_div.offsetWidth - 20 +"px";
} 
function setIncomePullPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className   = "incomePull";	
	 obj.IdPrefix 	 = obj.className + "Id";
	 obj.fillObjName = obj.className + "Body";
	 obj.tableName   = "incomeMoneyTable";
	 obj.tBody 		 = $(obj.fillObjName);
	 obj.color1 	 = "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 	 = "BACKGROUND-COLOR: #ECEFF4";
	 obj.tBody 		= $(obj.fillObjName);
//	 obj.radioName = obj.className +"RN";

//	 obj.pageInfo 	 = "pageInfo" + obj.className;
//	 obj.pageSize 	 = "4";
//	 obj.page        = new Page(obj.pageInfo,obj.pageSize);
}

function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.selectName =  "customerId";

}



function buttonEventFill(){
	var Btn_query = $("query");
	Btn_query.onclick =getOrderFinanceList;

	var Btn_customerName = $("customerName");
	Btn_customerName.onclick = resetText;
	
}
function getOrderFinanceList(){
		 var customerId = $("customerId").value;
         var carrierName = $(carrier.selectName).value;
	     var userId = $(user.selectName).value;
	     
		 var arrears =getCheckBoxValues("checklist",1);
//		 var func = function(objs){
//		 	incomePull.incomeMoneyFillTalbe(objs);
//		 }
//		 incomePull.getIncomeMoneyList(customerId,carrierName,userId,start,end,purpose,arrears,func);	
//	     alert(">>"+customerId+">>"+carrierName+">>"+userId+">>"+arrears);
}


function resetText(ev){
	 $("customerName").value = null;
	 $("customerId").value = null;
}
function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}
function setUserPara(obj){
	 obj.className ="user";
	 obj.selectName =  "userOwner"; 
}

function setUserSelected(){
	 	var id  = $("userId").value;
	 	if(id > 0){
	 		$(user.selectName).value = id;
	 	}
}


function getCustomerAutoComplt(){
	customer.getCustomerAutoComplet(customer.obj,payCustomerAutoComplet);
}


function payCustomerAutoComplet(objs)
{
	var oText = $("customerName");
	var oDiv = $("theDivCustomerName");

	var indexColumName_customerName = ["helpCode"];
	var allColumsName_customerName =["id","helpCode","customerName","customerCategoryId","category.categoryName"];
	var hidenColumName = ["id","customerCategoryId"];
	var allColumsTitle = ["助记码","客户名称","客户类别"];
	
	var onDivMouseDown_customerId = function(ev){

		var tr = getElementByEvent(ev);
		$("customerId").value = getCellValue(tr,0);
		$("customerName").value = getCellValue(tr,2);
		$("customerCategoryId").value = getCellValue(tr,3);
		
		oText.value = getCellValue(tr,2);
	}
	
	var onTextBlur = function(ev){

		oDiv.style.visibility = "hidden";
		
		if(trim(oText.value) == "" ){
			$("customerId").value = '0';
			$("customerCategoryId").value = '0';
		
		}
	}
   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown_customerId,onTextBlur,hidenColumName,indexColumName_customerName,allColumsName_customerName,allColumsTitle);
   var index =  $("customerId").value;
   if(index > 0){
   		$("customerName").value =  getColValueFromObjs(objs,index,"id","customerName");
   }else{
//   		$("customerName").value = null;
   }

}

