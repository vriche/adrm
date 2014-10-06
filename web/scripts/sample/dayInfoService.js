
var myDate = new MyDate();
var resDayInfo = new DayInfo();
var orderDayInfo = new OrderDayInfo();
var broArrange = new BroArrange();


callOnLoad(init);	
  
function init(){
	setDayInfoPara(resDayInfo);	
	setOrderDayInfoPara(orderDayInfo);
	
	broArrange.startDate = myDate.getStartDay("20070205");
	broArrange.endDate = myDate.getEndDay("20070306");  
	//动态修改

	broArrange.lastMonthDay = broArrange.endDate; 
	
	broArrange.dayTotalTime = $("dayTotalTime");
	broArrange.dayUsedTime = $("dayUsedTime");
	broArrange.dayLeaveTime = $("dayLeaveTime");
	broArrange.broSumTime = $("broSumTime");
	broArrange.broArrangeStartDate = $("broArrangeStartDate");
	broArrange.broArrangeEndDate = $("broArrangeEndDate");
	
	broArrange.sumMonthBasePrice =$("sumMonthBasePrice");
	broArrange.sumMonthRealPrice = $("sumMonthRealPrice");
	
	broArrange.makeSelectMonth("selectMonth",12,1,"selectMonth");


	getMonthInfos(broArrange.startDate,broArrange.endDate);
    buttonEventFill();
	
//	Calendar.setup({
//		inputField  : "publishDate",	  // id of the input field
//		ifFormat	: "%Y-%m-%d",	  // the date format
//		button	  : "publishDateBt"	// id of the button
//	});
	
}

function buttonEventFill(){
	
	var Bt_cleanBroArrange = $("cleanBroArrange");
	Bt_cleanBroArrange.onclick= broArrange.cleanBroArrange;	
	
	var Bt_resumeBroArrange = $("resumeBroArrange");
	Bt_resumeBroArrange.onclick= resumeBroArrange;	
	
	var Bt_addBroArrange = $("addBroArrange");
	Bt_addBroArrange.onclick= addBroArrange;		

	var Bt_selectMonth = $("selectMonth");
	Bt_selectMonth.onchange= selectMonth;	
	
	var Bt_displayLeavTimes = $("isDisplayLeavTimes");
	Bt_displayLeavTimes.onclick= displayLeavTimes;		
		
	
	var Bt_addNewOrderDayInfo = $("addNewOrderDayInfo");
	Bt_addNewOrderDayInfo.onclick= addNewOrderDayInfo;		
	
	var Bt_saveOrderDayInfo = $("saveOrderDayInfo");
	Bt_saveOrderDayInfo.onclick= saveOrderDayInfo;		
	
}

function setDayInfoPara(obj){
	 obj.className ="resDayInfo";
}

function setOrderDayInfoPara(obj){
	 obj.className ="orderDayInfo";
	 obj.IdPrefix 	= obj.className +"Id";
	 obj.tableName   = obj.className +"Table";
	 obj.fillObjName = obj.className +"Tbody";
	 obj.targ = $(orderDayInfo.fillObjName);
}

function getMonthInfos(startDate,endDate){
	var orderDetailId =  "1";
    var resourceId =     "1";
    var specific =       "";
//    var specific =       getSelectParam("dtResourceSpecificId",orderDetail.resourceSpecificId);	

//    alert(startDate);
//    alert(endDate);

	var objs = orderDayInfo.getMonthInfos(orderDetailId,startDate,endDate,resourceId,specific);
	
	broArrange.adLength = 5;
	broArrange.basePrice = 100;
	broArrange.realPrice = 50;

	broArrange.setup(orderDayInfo.targ,objs,broArrange.adLength,broArrange.basePrice,broArrange.realPrice);
    //设置开始结束日期
    broArrange.getBroArrangeStarEndDate();
}


function selectMonth(ev){
	var choseMonth = $("selectMonth").value;
	var oldEndMonth = myDate.getMonth(broArrange.endDate) * 1;
	var startDate = broArrange.startDate;
	var endDate =   broArrange.endDate;

	if(choseMonth == "=全年=" || choseMonth == "选择月份"){
        if(choseMonth == "选择月份"){
        	resumeBroArrange(ev);
        }else{
	 		var year = broArrange.endDate.substring(0,4);
			startDate =  myDate.yearFirstDay(year);
			endDate =  myDate.yearLastDay(year);
			broArrange.lastMonthDay = endDate;       	
        }

	}else{
		if(choseMonth < oldEndMonth){
			alert("选择的月份不能小于 已有播出的月份");
			return false;
		}else{
			startDate = broArrange.startDate;
			endDate =  myDate.getNewDayEndDay(broArrange.endDate,choseMonth);
			
			broArrange.lastMonthDay = endDate;		
		}		
	}

	getMonthInfos(startDate,endDate);
}

function resumeBroArrange(ev){
	var startDate = broArrange.startDate;
	var endDate =   broArrange.endDate;
	broArrange.lastMonthDay = endDate;	
	DWRUtil.setValue("selectMonth", 0);
	getMonthInfos(startDate,endDate);
}


function addBroArrange(ev){
	var startDate = broArrange.startDate;
	var endDate =   myDate.getNextMonthDay(broArrange.lastMonthDay);
	var m = broArrange.myDate.getMonth(endDate)*1;
	DWRUtil.setValue("selectMonth", m);
	
	if(endDate){
		broArrange.lastMonthDay = endDate;
		getMonthInfos(startDate,endDate);		
	}
}

function addNewOrderDayInfo(ev){
	var startDate = myDate.getStartDay(myDate.curDate);
	var nextMonth = myDate.getMonth(startDate)*1 + 2;
	var endDate   = myDate.getNewDayEndDay(startDate,nextMonth);

	DWRUtil.setValue("selectMonth", 0);

	if(endDate){
		broArrange.lastMonthDay = endDate;
		getMonthInfos(startDate,endDate);		
	}
}



function displayLeavTimes(ev){
	broArrange.displayLeave = $("isDisplayLeavTimes").checked;
	var startDate = broArrange.startDate;
	var endDate =   broArrange.lastMonthDay;
	getMonthInfos(startDate,endDate);		
}



function saveOrderDayInfo(ev){
	  var orderDayInfos = new Array();
	  var k = 0;
	  //广告日信息
	  orderDayInfo.orderId = $("orderId").value;
	  orderDayInfo.orderDetailId = $("dtId").value;
	  orderDayInfo.dayStandardPrice =$("dtExecPrice").value;
	  orderDayInfo.dayStandardPrice =$("dtSysPrice").value; 
	  orderDayInfo.dayRelIncome = 0;
	  orderDayInfo.resourceSpecific = curSpecific;
	  orderDayInfo.isPublished = 0;
	  orderDayInfo.adlength = $("dtMatterLength").value;
	  orderDayInfo.customerId = $("orderCustomerName").value;
	  orderDayInfo.linkUserId = $("orderRelation").value;
	  orderDayInfo.version = 0;	
	  
	  
	   //资源日信息
	  resDayInfo.carrierId = $("dtResourceInfoId").value;
	  resDayInfo.resourceId = $("dtResourceInfoId").value;
	
	 
	  var trs = orderDayInfo.targ.getElementsByTagName("tr");
	  var trnum = trs.length;  
	
	  
	  for (var i = 0; i < trnum; i++) { 
	  
	      var row = trs[i].firstChild;
	
	      for (var j = 0; j < 32; ++j,cell = cell.nextSibling) {
	     	      var dayObj = cell.dayObj;
	              //资源日信息 
	              //使用时间=(单前次数-原来次数)*广告规格
	
				  var resDayUsedTime = dayObj.dayUsedTime; 
				  var adTimes = dayObj.adTimes;
				  var changeLength = (values[j].value - adTimes)* orderDayInfo.adlength;
				  var adSpecific = dayObj.adSpecific;
				  var rsSpecific = dayObj.rsSpecific;
				  
	
				  var curValue = (cell.innerHTML > 0) ?  cell.innerHTML*1 : "0";
				  resDayUsedTime = resDayUsedTime*1 + changeLength*1;
				  
				  //返回当前资源的指定信息
				  rsSpecific = getResSpecific(rsSpecific,adSpecific,curSpecific,adTimes,curValue);
	
	
	              resDayInfo.id = dayObj.resourceDayId;
				  resDayInfo.publishDate = dayObj.publishDate;
				  resDayInfo.specific = rsSpecific;
				  resDayInfo.used = resDayUsedTime;  
	     
				  //为了跟原来正常下的增删该区分开
				  resDayInfo.version = 2;
				  
				  //广告日信息
				  orderDayInfo.id = dayObj.adDayInfoId;
				  orderDayInfo.adDayTimes = curValue;
				  orderDayInfo.publishDate = resDayInfo.publishDate;
				  orderDayInfo.dayInfo = resDayInfo;
				  //1、保存广告日信息同时，联动修改资源日信息
				  //2、如果有广告日信息编号，进入修改
				  //3、如果没有广告日信息编号，单有次数，进入新添
				  //4、修改和新添广告的同时，对广告资源日信息进行处理
	              orderDayInfos[k++] = orderDayInfo;
	      }
	  }

//  OrderDayInfoMnager.saveOrderDayInfo(orderDayInfos);
}




//资源指定的判断
function getResSpecific(rsSpecific,adSpecific,curSpecific,adTimes,curValue){
		  
	//如果原来有指定，现在也是相同指定，删除次数时 需要去了资源中的指定
	if (adSpecific !='' && (curValue == 0||curValue == '')){
		rsSpecific = resetSpecificStr(rsSpecific,adSpecific);
	}
	//如果原来有指定，现在也是相同指定，增加次数时 需要追加资源中的指定
	if (adSpecific =='' && curSpecific !='' &&  curValue == 1){
		rsSpecific = rsSpecific + curSpecific;
	}	
	//修改无播出但有指定
	if (adSpecific !=''&& curSpecific !='' &&  curValue == 1 && adTimes == 0 ){
		rsSpecific = rsSpecific + curSpecific;
	}		
	
	return  rsSpecific;
}

//替换资源里的指定字符串
function resetSpecificStr(rsSpecific,adSpecific){
	
	var newSpecific =  rsSpecific.gsub(adSpecific, '');
	
//	alert(newSpecific);
	
	return newSpecific;
	
}

//获得指定的参数
function getSelectParam(objName,specificID){
	var e = $(objName);
	var index = e.selectedIndex; 
	var sour = e.options[index].text;
	if(specificID > 0){
		index = specificID;
	}
	var i = sour.indexOf("||");
	var c = ''
	if (i > 0) 
        c = sour.substring(i+2);  
       
    return c.Trim();
}






		