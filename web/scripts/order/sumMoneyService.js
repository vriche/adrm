
callOnLoad(init);	
 
function init(){
	buttonEventFill();
}

function buttonEventFill(){
	var btn_confim = $("btn_confim");
	btn_confim.onclick = getMoneyBalance;
}

function getMoneyRealPayByURL(){
	var url = window.location.href;
	
	var startPos = url.lastIndexOf("&");
	var endPos = url.lastIndexOf("#");
	var money = url.substring(startPos+1,endPos)*1;
		
	return  money;
}

function getSysPriceByURL(){
	var url = window.location.href;
	
	var startPos = url.lastIndexOf("#");
	var endPos = url.length;
	var sysPrice = url.substring(startPos+1,endPos)*1;
	
	return  sysPrice;
}

function getMoneyBalance(){
	var realpay = getMoneyRealPayByURL();
	var sysPrice = getSysPriceByURL();
	var sumMoney = $("sumMoney").value;
	
	var moneyBalance =  ForDight(sumMoney-(realpay + sysPrice),2);
	
	alert("moneyBalance="+moneyBalance);
//	var element = document.getElementById("moneyBalance");
//	alert(element);
}



