
var customer = new Customer();
var foretArrearage = new ForetArrearage();

callOnLoad(init);

function init(){
	initGrid();
	initGrid2();
	
	resetHeigth();
	setCustomerPara(customer);
	getForetArrearages();
	buttonEventFill();
}
function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "customerId";
} 
function resetHeigth(){
    var dialogcontent = $("dialogcontentDiv");
    var analyCarriermatterBox2 = $("analyCarriermatterBox2");
    var analyCarriermatterBox = $("analyCarriermatterBox");
   
   analyCarriermatterBox.style.height = dialogcontent.offsetHeight*0.77 + "px";
   analyCarriermatterBox2.style.height = dialogcontent.offsetHeight*0.77 + "px";
}
function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");
	 
	mygrid.setHeader("年份,客户,一月,#cspan,#cspan,二月,#cspan,#cspan,三月,#cspan,#cspan,四月,#cspan,#cspan,五月,#cspan,#cspan,六月,#cspan,#cspan,七月,#cspan,#cspan,八月,#cspan,#cspan,九月,#cspan,#cspan,十月,#cspan,#cspan,十一月,#cspan,#cspan,十二月,#cspan,#cspan,合计,#cspan,#cspan");
	

    mygrid.setInitWidthsP("7,14,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6");
	mygrid.setColAlign("right,left,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right");
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
    
    mygrid.setMultiLine(false);
	mygrid.setEditable(false);

	mygrid.enableDragAndDrop(false);

    mygrid.setSkin("modern2");
	mygrid.init();	
	mygrid.attachHeader("#rspan,#rspan,应付,已付,欠款,应付,已付,欠款,应付,已付,欠款,应付,已付,欠款,应付,已付,欠款,应付,已付,欠款,应付,已付,欠款,应付,已付,欠款,应付,已付,欠款,应付,已付,欠款,应付,已付,欠款,应付,已付,欠款,应付,已付,欠款");
    mygrid.setSizes();
}
function initGrid2(){
	mygrid2 = new dhtmlXGridObject('gridbox2');
	mygrid2.selMultiRows = true;
	mygrid2.setImagePath("image/grid/");
	
	mygrid2.setHeader("年份,客户,一月,二月,三月,四月,五月,六月,七月,八月,九月,十月,十一月,十二月,合计");
	

    mygrid2.setInitWidthsP("7,14,6,6,6,6,6,6,6,6,6,6,6,6,7");
	mygrid2.setColAlign("right,left,right,right,right,right,right,right,right,right,right,right,right,right,right");
	mygrid2.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
    
    mygrid2.setMultiLine(false);
	mygrid2.setEditable(false);
	mygrid2.enableDragAndDrop(false);

    mygrid2.setSkin("modern2");
	mygrid2.init();	
}
function showGrid(type){
	if(type == 4){
		$("analyCarriermatterBox").show();
		$("analyCarriermatterBox2").hide();
	}else{
		$("analyCarriermatterBox2").show();
		$("analyCarriermatterBox").hide();
	}
}
function buttonEventFill(){
	var Radio_payMoney = $("payMoneyRN");
	Radio_payMoney.onclick = getForetArrearages;
	
	var Radio_incomeMoney = $("incomeMoneyRN");
	Radio_incomeMoney.onclick = getForetArrearages;
	
	var Radio_moneyLeft = $("moneyLeftRN");	
	Radio_moneyLeft.onclick = getForetArrearages;
	
	var Radio_seeAll = $("seeAllRN");
	Radio_seeAll.onclick = getForetArrearages;
	
	var Btn_customerName = $("customer_name");
	Btn_customerName.onkeypress= getCustomerAutoCompltByName;
	Btn_customerName.onclick = resetText;
	
	var Btn_searche = $("btn_searche");
	Btn_searche.onclick = getForetArrearages;
}
function getCustomerAutoCompltByName(ev){
	var customerName =$("customer_name").value;
	customer.obj.customerName = customerName;

	if(ev.keyCode == 13){
		customer.getCustomerAutoComplet(payCustomerAutoComplet,customer.obj);
		$("customer_name").value="";
	}
}
function resetText(ev){
	 $("customer_name").value = null;
	 $("customerId").value = null;
}
function getForetArrearages(){
	
	var type = getCheckBoxValues("check_types",1);
	type = type[0];
	showGrid(type);
	function func(xml){
		if(type == 4){
			mygrid.clearAll();
			mygrid.loadXMLString(xml);	
		}else{
			mygrid2.clearAll();
			mygrid2.loadXMLString(xml);
		}
	}
	
	var customerName =  $("customer_name").value;
	customerName = customerName =="" ? customerName =null:customerName;
	foretArrearage.reset();
	foretArrearage.obj.year = $("year").value;	
	foretArrearage.obj.customerName = customerName;	
	foretArrearage.getForetArrearagesForXML(func,foretArrearage.obj,type);
	
}
function payCustomerAutoComplet(objs){
	var oText = $("customer_name");
	var oDiv = $("theDivCustomerName");

	var indexColumName_customerName = ["helpCode"];
	var allColumsName_customerName =["id","helpCode","customerName","customerCategoryId","category.categoryName"];
	var hidenColumName = ["id","customerCategoryId"];
	var allColumsTitle = ["助记码","客户名称","客户类别"];
	
	var onDivMouseDown_customerId = function(ev){

		var tr = getElementByEvent(ev);
		$("customerId").value = getCellValue(tr,0);
		oText.value = getCellValue(tr,2);

	}
	
	var onTextBlur = function(ev){

		oDiv.style.visibility = "hidden";
		
		if(trim(oText.value) == "" ){
			$("customerId").value = '';
		}
	}
   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown_customerId,onTextBlur,hidenColumName,indexColumName_customerName,allColumsName_customerName,allColumsTitle);

}