
function BroArrange(){
	this.targ = null;
	this.objs = null;

	this.currentDateEl = null;
	this.ar_days = [];
	this.myDate = new MyDate();
	this.lastMonthDay = null;
	this.startDate = null;
	this.endDate = null;
	
	this.broArrangeStartDate = null;
	this.broArrangeEndDate = null;
	this.broWeekTime = null;
	
	//广告资源日信息

	this.basePrice = 0;
	this.realPrice = 0;
	this.favourRate = 0;
	this.appRate = 0;
	this.moneyBalance = 0;
	
	this.ageRate = 0;
	this.adLength = 0;   
	this.resLimit = null;
	this.displayLeave = false;
		
	this.dayTotalTime = null;
	this.dayUsedTime = null;
	this.dayLeaveTime = null;
	this.broSumTime = null;
	this.sumMonthBasePrice = null;
	this.sumMonthRealPrice = null;
	this.isAlert = true;
	this.isConfirm = true;
    this.isCal = true;
    this.isLock = false;
    
    this.displayLeave = false;
    
	return this;
}



/// detect a special case of "web browser"
BroArrange.is_ie = ( /msie/i.test(navigator.userAgent) &&
					   !/opera/i.test(navigator.userAgent) );
BroArrange.is_ie5 = ( this.is_ie && /msie 5\.0/i.test(navigator.userAgent) );
		/// detect Opera browser
BroArrange.is_opera = /opera/i.test(navigator.userAgent);
		/// detect KHTML-based browsers
BroArrange.is_khtml = /Konqueror|Safari|KHTML/i.test(navigator.userAgent);	

//BroArrange.isCal = true;

BroArrange.isTimeOutRight = false;

BroArrange.keycodes = new Array(48,49, 50, 51, 52, 53, 54, 55, 56, 57);

//BroArrange.isLocked = false;


//
//BroArrange.tbMouseOver = function(ev){
//
//	broArrange.tbMouseOver(ev);
//}
//
//BroArrange.tbMouseOut = function(ev){
//
//	broArrange.tbMouseOut(ev);
//}



BroArrange.prototype.setup = function(){
// 	this.reset();
//	this.isLock = isLock;
//	this.targ = targ;
//	this.objs = objs;
//	this.adLength = adLength;
//	this.basePrice = basePrice;
//	this.realPrice = realPrice;
//	this.ageRate  = ageRate;
//	this.moneyBalance = moneyBalance;
	var displayLeave = window.broArrange.displayLeave;
	
//	var OBJ = this;
	
	var stop = function(){return false;};
	document.oncontextmenu=function stop(){return false;};
	
	
//    var T = this;
    
//    function tbMouseOver(ev){T.tbMouseOver(ev);}
//    function tbMouseOut(ev){T.tbMouseOut(ev);}   
    	
    	
//    this.removeEvent(this.targ, "mouseove", tbMouseOver);	 	
// 	this.removeEvent(this.targ, "mouseover", tbMouseOver);	
//	this.removeEvent(this.targ, "mouseout", tbMouseOut);	


	DWRUtil.removeAllRows(this.targ);

	
    this.fillTable();
    this.getBroSumTime();
    this.setSumMonthPrice();
 

    if(!this.isLock){
     	 this.addEvent(this.targ, "mouseove", broArrange.tbMouseOver);	
		 this.addEvent(this.targ, "mouseover", broArrange.tbMouseOver);	
		 this.addEvent(this.targ, "mouseout", broArrange.tbMouseOut);			
    }else{
     	 this.removeEvent(this.targ, "mouseove", broArrange.tbMouseOver);	
		 this.removeEvent(this.targ, "mouseover", broArrange.tbMouseOver);	
		 this.removeEvent(this.targ, "mouseout", broArrange.tbMouseOut);	
    }
    

//    if(!displayLeave){
//	     this.addEvent(document, "keydown", this._keyEvent);
//		 this.addEvent(document, "keypress", this._keyEvent);   

//    }

	
	
//	this.addEvent(document, "mousedown", this._checkBroArrange);
//  this.addEvent($(this.targ), "mousedown", this.tableMouseDown);	

}	

BroArrange.prototype.tbMouseOver = function (ev) {
	broArrange.addEvent(document, "keydown", broArrange._keyEvent);
	broArrange.addEvent(document, "keypress", broArrange._keyEvent);  
}

BroArrange.prototype.tbMouseOut = function (ev) {
	broArrange.removeEvent(document, "keydown", broArrange._keyEvent);
	broArrange.removeEvent(document, "keypress", broArrange._keyEvent); 
}

BroArrange.prototype.reset = function (){
    this.objs = null;
    this.adLength = 0;
	this.basePrice = 0;
	this.realPrice = 0;
	this.ageRate = 0;
	this.moneyBalance = 0;
	this.favourRate = 0;
	this.appRate = 0;
	this.ar_days = [];
	return this;
};

BroArrange.prototype.cellCreatorMonth = function(rowData){
	var displayLeave = rowData.displayLeave;
	var displayLeave2 = rowData.displayLeave2;
	
	var cell = document.createElement("td"); 
	cell.navtype = "0";   
	cell.setAttribute("align","center");
	cell.dayObj = rowData;
	if(displayLeave){
		cell.navtype = "-1";  
		cell.style.backgroundColor = "#CCCCCC";
		cell.innerHTML = rowData.month <10?'&nbsp;&nbsp;'+rowData.month+'&nbsp月':rowData.month+'&nbsp月';
	}else{
		if(displayLeave2){
			cell.innerHTML = "&nbsp";
		}else{
			cell.innerHTML = rowData.month <10?'&nbsp;&nbsp;'+rowData.month+'&nbsp月':rowData.month+'&nbsp月';
		}
	}

//    cell.broArrange = this;
	return cell;
}



BroArrange.prototype.getBroWeekTime = function(data){
		var wks =["日","一","二","三","四","五","六"];
		var d = data.dayDate; 
		var dt = this.myDate.getDateFromFormat(d,"yyyyMMdd");
		var d = new Date(dt);
		return  wks[d.getDay()];
}




BroArrange.prototype.cellCreatorDay = function(rowData,data){

	var cell = document.createElement("td"); 
//	var displayLeave = window.broArrange.displayLeave;
	var displayLeave = rowData.displayLeave;
	
//    var leavTimes = data.rsTotalTime - data.rsUsedTime; 
     var leavTimes = ''; 
     if(displayLeave){
     	   leavTimes = this.getBroWeekTime(data); 
     }


//    var cellText = data.adTimes;
	var cellText = displayLeave ? leavTimes: data.adTimes;
	
//	alert(data.adTimes);
	
	
	cell.className = "day";
	cell.setAttribute("width","22");
	cell.setAttribute("align","center");
	cell.dayObj = data;
	 if(displayLeave){
	 	    cell.style.backgroundColor = "#CCCCCC";
	 		cell.navtype = "-1";
	 }else{
	 		cell.style.backgroundColor = data.rsColor;
	 		cell.navtype = "1";
	 }

	
//	cell.publishDate = dayObj.dayDate;	
//	cell.rsModifyTime = dayObj.modifyTime;
			
	

	cell.innerHTML = (cellText > 0) || displayLeave ? cellText : "&nbsp";

	
	

//	if(data.rsColor == null || data.rsColor == "null" || data.rsColor == ""){
//		cell.disabled  = true;
//	}else{
//		cell.disabled = false;
//	}
	if(data.disabled) cell.disabled  = true;

		 
		 

    var i = data.dayDate;
    cell.index = i;
//    window.broArrange.ar_days[i] = cell;
    this.ar_days[i] = cell;
    
//    cell.broArrange = this;

     if(!this.isLock){
     	   broArrange._add_evs(cell);  
     }

	return cell;
}

BroArrange.prototype.cellCreatorMonthTimes = function(rowData){
	var displayLeave = rowData.displayLeave;

	var cell = document.createElement("td"); 
//	cell.style.backgroundColor ="#FFFFFF";
    if(displayLeave){
    	cell.navtype = "-1";   
    	cell.style.backgroundColor = "#CCCCCC";
    }else{
    	cell.navtype = "2";   
    }
	
	cell.setAttribute("align","center");	
	cell.dayObj = rowData;
	var monthTimes = rowData.monthTims > 0 && !displayLeave? rowData.monthTims:"&nbsp";
	cell.innerHTML = monthTimes;

//    cell.broArrange = this;
 
	return cell;
}

BroArrange.prototype.cellCreatorMonthBasePrice = function(rowData){
	var displayLeave = rowData.displayLeave;
	var cell = document.createElement("td"); 
	 if(displayLeave){
	 	cell.navtype = "-1";
	 	cell.style.backgroundColor = "#CCCCCC";
	 }else{
	 	cell.navtype = "3";
	 }
	   
	cell.setAttribute("align","right");	

	cell.dayObj = rowData;
	
	var monthTimes = rowData.monthTims >= 0 && !displayLeave? rowData.monthTims:"&nbsp";
    var basePrice  = ForDight(monthTimes * this.basePrice,0);
	cell.innerHTML = basePrice > 0 ? basePrice:"&nbsp";
//    cell.broArrange = this;
 
	return cell;
}



BroArrange.prototype.cellCreatorMonthRealPrice = function(rowData){
	var displayLeave = rowData.displayLeave;
	var cell = document.createElement("td"); 
	 if(displayLeave){
	 	cell.navtype = "-1";  
	 	cell.style.backgroundColor = "#CCCCCC";
	 }else{
	 	cell.navtype = "4";  
	 }
	 
	cell.setAttribute("align","right");	
	cell.dayObj = rowData;
	
	var monthTimes = rowData.monthTims >= 0 && !displayLeave? rowData.monthTims:"&nbsp";
	var realPrice  = ForDight(monthTimes * this.realPrice,2);
	var realPrice  = 0;
	if(config_orderCalculateModel == 0){
		 realPrice  = ForDight(monthTimes * this.realPrice,2);
	}else{
		var favourRate = this.favourRate;
		
		var appRate = this.appRate;		
		favourRate = favourRate==0?100:favourRate;
		var value = this.realPrice * monthTimes*(favourRate/100)*(1+appRate/100);
		realPrice = ForDight(value,2);
	}	
	
	
	cell.innerHTML = realPrice > 0 ? realPrice:"&nbsp";

//    cell.broArrange = this;
 
	return cell;
}


BroArrange.prototype.setMonthTimes_bak = function(el){
	var row = el.parentNode;
	//var cell = row.firstChild;
	var monthTimes = 0;

	monthTimes = row.cells[32].innerHTML !="&nbsp;" ?  row.cells[32].innerHTML * 1 : 0;
	if(el.navtype == "1"){
			monthTimes += (el.innerHTML == "&nbsp;")? 0 : el.innerHTML*1;
	}
	
	 row.cells[32].innerHTML = (monthTimes != 0)? monthTimes : "&nbsp";

	return monthTimes;			
}


BroArrange.prototype.setMonthTimes = function(el){
	var row = el.parentNode;
	var cell = row.firstChild;
	var monthTimes = 0;

	for (var j = 0; j < 33; ++j,cell = cell.nextSibling) {

		if(cell.navtype == "1"){
			monthTimes += (cell.innerHTML == "&nbsp;")? 0 : cell.innerHTML*1;
		}
		if(cell.navtype == "2"){
			cell.innerHTML = (monthTimes != 0)? monthTimes : "&nbsp";
		}	 
	}
	
	return monthTimes;			
}

BroArrange.prototype.getResDayInfo = function(el){
	var navtype = el.navtype;
	if(navtype == "-1") return false;
		
	var dayObj = el.dayObj;
	var cellValue = (el.innerHTML == "&nbsp;")? 0 : el.innerHTML*1;
	var isdisable = false;
	var dayLeaveTime = 0;

    var isLimit = dayObj.isLimit;
//	var rsTotalTime =  dayObj.rsTotalTime; //资源标准
	var rsTotalTime =  dayObj.rsTotalTime == null || dayObj.rsTotalTime == "" ? 0: dayObj.rsTotalTime; //资源标准
	var rsUsedTime =  dayObj.rsUsedTime;   //资源占用
    var adTimes = dayObj.adTimes;			//该广告原来次数   
    if(isResChangedOnEdit) adTimes = 0;
	adTimes = (adTimes == "&nbsp"|| adTimes == "&nbsp;" || adTimes == "")? 0 : adTimes*1;   
//	var adLength = el.broArrange.adLength;
	var adLength = this.adLength;
	
//	var dayTotalTime = rsTotalTime;  //广告标准时长
    var adUsed = rsTotalTime > 0 ? cellValue* adLength - adTimes*dayObj.adLength: -(cellValue - adTimes)* adLength;
   //  var adUsed = rsTotalTime > 0 ? (cellValue - adTimes)* adLength: -(cellValue - adTimes)* adLength;//编辑状态长度变化时‘占用’显示错误
	var dayUsedTime = rsUsedTime*1 + adUsed;

	
	if(rsTotalTime > 0){
		dayLeaveTime = rsTotalTime - dayUsedTime;
	}else{
		dayLeaveTime = 0;
	}
	
	
	if(dayLeaveTime < 0 && isLimit){
//		alert("广告超时");
		isdisable =  true;
	}
	
	
		

//		var wks =["日","一","二","三","四","五","六"];
//		var d = el.dayObj.dayDate; 
////		var dt = el.broArrange.myDate.getDateFromFormat(d,"yyyyMMdd");
//		var dt = this.myDate.getDateFromFormat(d,"yyyyMMdd");
//		var d = new Date(dt);
//		var broWeekTime = wks[d.getDay()];
		
    var broWeekTime = this.getBroWeekTime(el.dayObj); 
   
//	el.broArrange.setDestResDayInfo(rsTotalTime,dayUsedTime,dayLeaveTime,broWeekTime);
	this.setDestResDayInfo(rsTotalTime,dayUsedTime,dayLeaveTime,broWeekTime);
	
	return isdisable;
}


BroArrange.prototype.addAndPost = function(noBro){ 
	var trs = this.targ.getElementsByTagName("tr");
	for(var i = 0; i< trs.length;i++){
		var cells = trs[i].cells;
		var navtype = cells[0].navtype;
		if(navtype != "-1"){
			for (var j = 1 ; j < 32;j++){
	//			var adTimes = cells[j].dayObj.adTimes;
	//			cells[j].innerHTML = (adTimes > 0)?adTimes:"&nbsp";
				cells[j].dayObj.adTimes = 0;
				cells[j].dayObj.adDayInfoId = null;
				cells[j].dayObj.isAdSpecificed = false;
				cells[j].dayObj.adSpecific ='';
			}	
		}

	}
	if(noBro){
		this.cleanBroArrange();
		this.getBroSumTime();		
	}

}

//从原来的单元格对象取次数，到当前的排期表中
BroArrange.prototype.copyDatetimesToTarget = function(arg){ 
	var trs = this.targ.getElementsByTagName("tr");
    var k = 0;
	for(var i = 0; i< trs.length;i++){
		var cells = trs[i].cells;
		var navtype = cells[0].navtype;
		if(navtype != "-1"){
			for (var j = 1 ; j < 33;j++){
				var v = arg[k++];
	//			var dayObj = cells[j].dayObj;
	//			alert(trim(dayObj.rsSpecific).length); 
	//			if(trim(dayObj.rsSpecific).length == 0 && j <33) v = 0;
				cells[j].innerHTML = v > 0?v:"&nbsp;";
			}			
		}

	}	
	this.getBroSumTime();
}

BroArrange.prototype.copyTimesFromTargToArray = function(){
	var trs = this.targ.getElementsByTagName("tr");
	var broArray = new Array();
	for(var i = 0; i< trs.length;i++){
		var cells = trs[i].cells;
		var navtype = cells[0].navtype;
		if(navtype != "-1"){
			for (var j = 1 ; j < 33;j++){
				var adTimes = cells[j].innerHTML;
				adTimes = adTimes > 0 ? adTimes: 0;
				broArray.push(adTimes);			
			}			
		}


	}	
	return broArray;
}

//BroArrange.prototype.copyTimes = function(source,target){
//	var trs2 = source.getElementsByTagName("tr");
//    var trs = target.getElementsByTagName("tr");
//	for(var i = 0; i< trs.length;i++){
//		var cells = trs[i].cells;
//		var cells2 = trs2[i].cells;
//		for (var j = 1 ; j < 32;j++){
//			if(cells2[j].innerHTML > 0) alert(cells2[j].innerHTML);
//			cells[j].innerHTML = cells2[j].innerHTML;		
//		}
//
//	}	
//}
	
BroArrange.prototype.setDestResDayInfo = function(dayTotalTime,dayUsedTime,dayLeaveTime,broWeekTime){
   this.dayTotalTime.value = dayTotalTime;
   this.dayUsedTime.value = dayUsedTime;
   this.dayLeaveTime.value = dayLeaveTime;
   this.broWeekTime.value = broWeekTime;
   

}	
	
BroArrange.prototype.setBroSumTime = function(el){
	var trs = this.targ.getElementsByTagName("tr");
	var sumTime = 0;
	for(var i = 0; i< trs.length;i++){
		var navtype = trs[i].cells[0].navtype;
		if(navtype != "-1"){
	        var value = trs[i].cells[32].innerHTML !="&nbsp;" ?  trs[i].cells[32].innerHTML * 1 : 0;
			sumTime += value;		
		}
	}	
	this.broSumTime.value = sumTime;
}

BroArrange.prototype.getBroSumTime = function(){
	var trs = this.targ.getElementsByTagName("tr");
	var sumTime = 0;
	for(var i = 0; i< trs.length;i++){

		var navtype = trs[i].cells[0].navtype;
		if(navtype != "-1"){
	        var value = trs[i].cells[32].innerHTML !="&nbsp;" ?  trs[i].cells[32].innerHTML * 1 : 0;
			sumTime += value;
		}		
		

	}	
	this.broSumTime.value = sumTime;
}





BroArrange.prototype.cleanBroArrange = function(){
	var trs = this.targ.getElementsByTagName("tr");
	for(var i = 0; i< trs.length;i++){
		var cells = trs[i].cells;
		var navtype =cells[0].navtype;
		if(navtype !="-1"){
			for (var j = 1 ; j < 35;j++){
				cells[j].innerHTML = "&nbsp";
			}	
		}

	}	
	
	this.broSumTime.value = "0";
	this.sumMonthBasePrice.value = "0";
	this.sumMonthRealPrice.value = "0";

	this.moneyBalance.value = "0";
//	$("moneyBalance").value = "0";
	
	this.broArrangeStartDate.value = config_serviceDate;
	this.broArrangeEndDate.value = config_serviceDate;
	
}




BroArrange.prototype.setMonthPrice = function(el){
	var row = el.parentNode;
	var cell = row.firstChild;
	var monthTimes = 0;
	var monthPrices = 0;
	

	for (var j = 0; j < 35; ++j,cell = cell.nextSibling) {
		if(cell.navtype == "2"){
			monthTimes = (cell.innerHTML == "&nbsp;")? 0 : cell.innerHTML*1;
		}			

		if(cell.navtype == "3"){
//			monthPrices = monthTimes * el.broArrange.basePrice; 
//			monthPrices = ForDight(monthTimes * el.broArrange.basePrice,0);
			monthPrices = ForDight(monthTimes * this.basePrice,2);
			cell.innerHTML = (monthPrices != 0)? monthPrices : "&nbsp";

		}	
		
		if(cell.navtype == "4"){
			if(config_orderCalculateModel == 0){
				monthPrices = ForDight(monthTimes * this.realPrice,2);
			}else{
				
						
				var favourRate = this.favourRate;
				var appRate = this.appRate;		
//				var moneyBalance = this.moneyBalance;
				favourRate = favourRate==0?100:favourRate;
				var value = this.realPrice*(favourRate/100)*(1+appRate/100)*monthTimes;
								
				monthPrices = ForDight(value,2);
			}
			
			cell.innerHTML = (monthPrices != 0)? monthPrices : "&nbsp";
		}			
	}	
	
	
	this.setSumMonthPrice();		
}

//设置每行的月价格
BroArrange.prototype.setBroArrayangeMonthPrice = function(){
	

	
	var table = this.targ;
    var trs = table.getElementsByTagName("tr");
    
   for(var i = 0; i < trs.length; i++) { 
		var cell = trs[i].firstChild;
		var monthTimes = 0;
		var monthPrices = 0;
		
	
		for (var j = 0; j < 35; ++j,cell = cell.nextSibling) {
			if(cell.navtype == "2"){
				monthTimes = (cell.innerHTML == "&nbsp;")? 0 : cell.innerHTML*1;
			}			
	
			if(cell.navtype == "3"){
				
//				monthPrices = monthTimes * obj.basePrice; 
				monthPrices = ForDight(monthTimes * this.basePrice,2);
				cell.innerHTML = (monthPrices != 0)? monthPrices : "&nbsp";
			}	
			
			if(cell.navtype == "4"){
//				monthPrices = monthTimes * obj.realPrice; 
				if(config_orderCalculateModel == 0){
					monthPrices = ForDight(monthTimes * this.realPrice,2);
				}else{
					var favourRate = this.favourRate;
					var appRate = this.appRate;		
					favourRate = favourRate==0?100:favourRate;
					var value = this.realPrice* monthTimes*(favourRate/100)*(1+appRate/100);
					monthPrices = ForDight(value,2);
				}			

				cell.innerHTML = (monthPrices != 0)? monthPrices : "&nbsp";
			}			
		}	
  }	
	
	this.setSumMonthPrice();		
}

BroArrange.prototype.setSumMonthPrice = function(){
	var table = this.targ;
    var trs = table.getElementsByTagName("tr");
    var sumMonthBasePrice = 0 ,sumMonthRealPrice = 0;

   for(var i = 0; i < trs.length; i++) {
   	    var cell = trs[i].firstChild;
		for (var j = 0; j < 35; ++j,cell = cell.nextSibling) {

			if(cell.navtype == "3"){
				var selectValue = cell.innerHTML  != "&nbsp;" ? cell.innerHTML*1 :0;
				if(selectValue > 0 ) sumMonthBasePrice += selectValue;
			}
			if(cell.navtype == "4"){
				var selectValue = cell.innerHTML  != "&nbsp;" ? cell.innerHTML*1 :0;
				if(selectValue > 0 ) sumMonthRealPrice += selectValue;
			}				
		}
	
   }	
   
   


      var ageRate =  (isUndefined(this.ageRate) || this.ageRate == null || this.ageRate =="")? 0:this.ageRate;
//    var appRate =  (isUndefined(broArrange.appRate) || broArrange.appRate == null || broArrange.appRate =="")? 0:broArrange.appRate;
//    var favourRate = (isUndefined(broArrange.favourRate) || broArrange.favourRate == null || broArrange.favourRate =="") ? 0:broArrange.favourRate;
      var balance =  (isUndefined(this.moneyBalance) || this.moneyBalance == null || this.moneyBalance =="") ? 0:this.moneyBalance;
//    
	  ageRate = ageRate > 0 ? ageRate/100:ageRate;
//    appRate = appRate > 0 ? appRate/100:appRate;
//    favourRate = favourRate > 0 ? favourRate/100:favourRate;
//    sumMonthRealPrice =  sumMonthBasePrice *(1 + appRate*1)*(1-favourRate) - balance;
//alert("sumMonthBasePrice="+sumMonthBasePrice);   

     
   
	  this.sumMonthBasePrice.value = ForDight(sumMonthBasePrice,2);
//	alert(BroArrange.isCal);
//alert("sumMonthRealPrice="+sumMonthRealPrice);
//alert("balance="+balance);
	if(this.isCal){
//		sumMonthRealPrice =  sumMonthRealPrice *(1 - ageRate*1)- balance;
//   var How = balance+'';
//   How = How.indexOf('.')>-1?How =2:0;
	    
		this.sumMonthRealPrice.value = ForDight((sumMonthRealPrice + balance*1),2);		
	}

}



BroArrange.prototype.fillTable = function(){
	var objs = this.objs;
	var displayLeave = window.broArrange.displayLeave;
	
	for(var i = 0 ; i< objs.length; i++){
		
		  if(displayLeave){
			  var row = document.createElement("tr"); 
			  var cellFuncs = this.cellFun;
			  var rowData = objs[i];
			  rowData.displayLeave = true;
			  rowData.displayLeave2 = true;
			  
			  for (var cellNum = 0; cellNum < cellFuncs.length; cellNum++) {
				    var func = cellFuncs[cellNum];
				    var cell = func(rowData);
				    row.appendChild(cell);
				    rowData.row = row;
				    
			  }		
			  this.targ.appendChild(row);	
		  }
		  
		  var row = document.createElement("tr"); 
		  var cellFuncs = this.cellFun;
		  var rowData = objs[i];
		  rowData.displayLeave = false;
		  for (var cellNum = 0; cellNum < cellFuncs.length; cellNum++) {
			    var func = cellFuncs[cellNum];
			    var cell = func(rowData);
			    row.appendChild(cell);
			    rowData.row = row;
			   
		  }		
		  this.targ.appendChild(row);		
		
		
		
	}
	
}

BroArrange.prototype.cellFun = [
	  	function(rowData) { return this.broArrange.cellCreatorMonth(rowData) },
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[0])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[1])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[2])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[3])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[4])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[5])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[6])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[7])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[8])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[9])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[10])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[11])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[12])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[13])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[14])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[15])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[16])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[17])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[18])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[19])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[20])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[21])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[22])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[23])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[24])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[25])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[26])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[27])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[28])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[29])},
	    function(rowData) { return this.broArrange.cellCreatorDay(rowData,rowData.days[30])},  
	    function(rowData) { return this.broArrange.cellCreatorMonthTimes(rowData)},
	    function(rowData) { return this.broArrange.cellCreatorMonthBasePrice(rowData)},
	    function(rowData) { return this.broArrange.cellCreatorMonthRealPrice(rowData)}          
	];
	

	
BroArrange.prototype.createElement = function(type, parent) {
	var el = null;
	if (document.createElementNS) {
		// use the XHTML namespace; IE won't normally get here unless
		// _they_ "fix" the DOM2 implementation.
		el = document.createElementNS("http://www.w3.org/1999/xhtml", type);
	} else {
		el = document.createElement(type);
	}
	if (typeof parent != "undefined") {
		parent.appendChild(el);
	}
	return el;
};

// FIXME: the following 2 functions totally suck, are useless and should be replaced immediately.
BroArrange.prototype.getElement = function(ev) {
	var f = BroArrange.is_ie ? window.event.srcElement : ev.currentTarget;
	while (f.nodeType != 1 || /^div$/i.test(f.tagName))
		f = f.parentNode;
	return f;
};



BroArrange.stopEvent = function(ev) {
	ev || (ev = window.event);
	if (BroArrange.is_ie) {
		ev.cancelBubble = true;
		ev.returnValue = false;
	} else {
		ev.preventDefault();
		ev.stopPropagation();
	}
	return false;
};

BroArrange.prototype.addEvent = function(el, evname, func) {
	if (el.attachEvent) { // IE
		el.attachEvent("on" + evname, func);
	} else if (el.addEventListener) { // Gecko / W3C
		el.addEventListener(evname, func, true);
	} else {
		el["on" + evname] = func;
	}
};

BroArrange.prototype.removeEvent = function(el, evname, func) {
	if (el.detachEvent) { // IE
		el.detachEvent("on" + evname, func);
	} else if (el.removeEventListener) { // Gecko / W3C
		el.removeEventListener(evname, func, true);
	} else {
		el["on" + evname] = null;
	}
};



//BroArrange._checkBroArrange = function(ev) {
//	var broArrange = window.broArrange;
//	if (!broArrange) {
//		return false;
//	}
//	var el = BroArrange.is_ie ? BroArrange.getElement(ev) : BroArrange.getTargetElement(ev);
//	for (; el != null && el != broArrange.element; el = el.parentNode);
//	if (el == null) {
//		return BroArrange.stopEvent(ev);
//	}
//};


BroArrange.prototype._add_evs = function(el){
	
	    var T = this;
	    
	    function dayMouseOver(ev){
	    	T.dayMouseOver(ev)
	    }
	    function dayMouseDown(ev){
	    	T.dayMouseDown(ev)
	    }
	   function dayMouseOut(ev){
	    	T.dayMouseOut(ev)
	    }
	    
	   function dayMouseDblClick(ev){
	    	T.dayMouseDblClick(ev)
	    }	    
	    
		this.addEvent(el, "mouseover", dayMouseOver);
		this.addEvent(el, "mousedown", dayMouseDown);
		this.addEvent(el, "mouseout", dayMouseOut);
		if (BroArrange.is_ie) {
			this.addEvent(el, "dblclick", dayMouseDblClick);
			el.setAttribute("unselectable", true);
		}
	
};



BroArrange.prototype.dayMouseOver = function(ev) {
      
		var el = this.getElement(ev);
		if (el.disabled) return false;
		if(el.navtype == "-1") return false;	
		
		
		if(ev.ctrlKey){
//			var bro = el.broArrange;
			this.removeClass(broArrange.currentDateEl, "selected");
	        this.addClass(el, "selected");
	        broArrange.currentDateEl = el;
			if(ev.shiftKey){
			    el.innerHTML =  "&nbsp";
			    this.setOtherInfo(el);
			}else{
				this.getResDayInfo(el);	
			}        

		}
		
//		alert(isRelated(el, ev));
		return BroArrange.stopEvent(ev);		

};

BroArrange.prototype.dayMouseDown = function(ev) {
	var el = this.getElement(ev);
	if (el.disabled) return false;
	if(el.navtype == "-1") return false;
	
	if(ev.ctrlKey){
//		var bro = el.broArrange;
		this.removeClass(broArrange.currentDateEl, "selected");
        this.addClass(el, "selected");
        broArrange.currentDateEl = el;
		this.getAdvers($('resourceInfoId').value,el.dayObj.dayDate);
	}else if(this.isEnableCellClick(el,ev)){
		this.cellClick(el,ev);
		this.getResDayInfo(el);	
	}
	


   
	return BroArrange.stopEvent(ev);	
};



BroArrange.prototype.getAdvers = function(resourceId,publishDate) {
		function hidek(){
			$('CNZZ_AD_BOTTOM_').hide();
		}	
	
		$('CNZZ_AD_BOTTOM_').show();
		$("CNZZ_AD_BOTTOM__c_buttons").onclick=hidek;
		$("CNZZ_AD_BOTTOM__buttons").onclick=hidek;  
//		var dialogcontent = $("dialogcontentDiv");
//		var dialogcontentW = dialogcontent.offsetWidth;
//		var dialogcontentH = dialogcontent.offsetHeight;
//		var winW= dialogcontentW * 0.6;
//		var winH = dialogcontentH*0.8;
//		var title = "";            
		var urlStr = "selectPopup/checkAdver.html?publishDate="+publishDate+"&resourceId="+resourceId;$('CNZZ_AD_content_box').src=urlStr;
//		openWindow(urlStr,title,'width='+winW+',height='+winH);	
}

BroArrange.prototype.dayMouseOut = function(ev) {

		var el = this.getElement(ev);
		
		if (this.isRelated(el, ev) || el.disabled)
			return false;
		return BroArrange.stopEvent(ev);			
	
};

BroArrange.prototype.dayMouseDblClick = function(ev) {
		this.cellClick(this.getElement(ev), ev || window.event);
		if (BroArrange.is_ie) {
			document.selection.empty();
		}		
};


	
BroArrange.prototype.isRelated = function (el, evt) {
	var related = evt.relatedTarget;
	if (!related) {
		var type = evt.type;
		if (type == "mouseover") {
			related = evt.fromElement;
		} else if (type == "mouseout") {
			related = evt.toElement;
		}
	}
	while (related) {
		if (related == el) {
			return true;
		}
		related = related.parentNode;
	}
	return false;
};

BroArrange.prototype.removeClass = function(el, className) {
	if (!(el && el.className)) {
		return;
	}
	var cls = el.className.split(" ");
	var ar = new Array();
	for (var i = cls.length; i > 0;) {
		if (cls[--i] != className) {
			ar[ar.length] = cls[i];
		}
	}
	el.className = ar.join(" ");
};

BroArrange.prototype.addClass = function(el, className) {
	this.removeClass(el, className);
	el.className += " " + className;
};	

//BroArrange.prototype.tableMouseDown = function (ev) {
//		if (this.getTargetElement(ev) == this.getElement(ev)) {
//			return stopEvent(ev);
//		}		
//};
BroArrange.prototype.getTargetElement = function(ev) {
	var f = BroArrange.is_ie ? window.event.srcElement : ev.target;
	while (f.nodeType != 1)
		f = f.parentNode;
	return f;
};	
	
	
/** keyboard navigation, only for popup calendars */
BroArrange.prototype._keyEvent = function(ev) {
	if (!ev) var ev=window.event;
	var el = broArrange.currentDateEl;
	if (el.disabled) return false;
//	if(el.navtype == "-1") return false;

	var act = (BroArrange.is_ie || ev.type == "keypress"),
			K = ev.keyCode;	


  
//	if(K == 32) K = 48;
	if(K >=96 && K<=105)  K = K-48;
	if(K == 32 || K == 110 ) K = 48;
	if((K > 47 && K < 58)||(!act && K == 8) || K == 110 ) {
		
		if(broArrange.isEnableCellClick(el,ev)){
		        broArrange.cellClick(el,ev);
		        var step = 1;
		        if(K == 8) step = -1; 
		        var ne = broArrange.getNextDay(el,step);
		        if(broArrange.isEnableCellClick(ne,ev)) broArrange.cellClick(ne,ev);
		}
	}
	
	if(act & (K == 37 ||K == 38 ||K == 39 ||K == 40 ) & !ev.ctrlKey ) {
		if(K == 37) var step = -1; // KEY left
		if(K == 38) var step = -31; // KEY up
		if(K == 39) var step = 1; // KEY right
		if(K == 40) var step = 31; // KEY down
		if(broArrange.isEnableCellClick(el,ev)){
			var ne = broArrange.getNextDay(el,step);
			if(broArrange.isEnableCellClick(ne,ev)) broArrange.cellClick(ne,ev);			
		}
	}	


	return BroArrange.stopEvent(ev);
};	


//有指定，次数只能为 1
//如果这一天 有超时限制，超过总时间也是不允许
//如果这一天广告播出单已出，也是不允许
BroArrange.prototype.isEnableCellClick = function(el,ev){
//	var bro = el.broArrange;
    if(isUndefined(el)) return false;
	if(el.navtype == "-1") return false;
	
	var dayObj = el.dayObj;
	var dayDate = ''+dayObj.dayDate;
	var rsTotalTime =  dayObj.rsTotalTime == null || dayObj.rsTotalTime == "" ? 0: dayObj.rsTotalTime; //资源标准
//	var afterLeaveTimes = 0;
	var rt = true;
	var K =  (ev.type == "keydown" || ev.type == "keypress")? ev.keyCode : ev.which;
	var isKeypress = (ev.type == "keydown");
	var t;
//	var adLength = el.broArrange.adLength;
	var adLength = broArrange.adLength;
 	
  	var curValue = (el.innerHTML >0) ? el.innerHTML*1 : 0;
//  	el.innerHTML = (curValue + step) > 0 ? curValue + step :"&nbsp";
  	
  	//播出单已出
  	var isLocked = dayObj.isLocked;
//  	alert(isLocked);
  	if(isLocked && config_outLimitBroarrang)  rt =  false;


	if(ev.type == "keydown"  || ev.type == "keypress"){

		if(K >=96 && K<=105)  K = K-48;
		if(K == 32 ||K == 8 || K == 110) K = 48;
		
		t = String.fromCharCode(K);	
//		alert('curSpecificed  '+dayObj.curSpecificed);
//		alert('isResSpecificed  '+dayObj.isResSpecificed);
//		alert('isAdSpecificed  '+dayObj.isAdSpecificed);
		//alert(isResChangedOnEdit);isSpecifChangedOnEdit
		if(dayObj.curSpecificed && dayObj.isResSpecificed && dayObj.isAdSpecificed && t >0 && isResChangedOnEdit)  rt =  false;
		if(dayObj.curSpecificed && dayObj.isResSpecificed && dayObj.isAdSpecificed && t >0 && isSpecifChangedOnEdit)  rt =  false;	
		
		if(dayObj.curSpecificed && !dayObj.isResSpecificed && dayObj.isAdSpecificed && t >1 && isSpecifChangedOnEdit)  rt =  false;	
			
		if(dayObj.curSpecificed && dayObj.isResSpecificed && dayObj.isAdSpecificed && t >1 )  rt =  false;
		if(dayObj.curSpecificed && dayObj.isResSpecificed && !dayObj.isAdSpecificed && t >0 )  rt =  false;
		if(dayObj.curSpecificed && !dayObj.isResSpecificed && !dayObj.isAdSpecificed && t >1 )  rt =  false;
	}else{

		t = (K == 1) ? 1 : -1;
		if(dayObj.curSpecificed && dayObj.isResSpecificed && dayObj.isAdSpecificed && (t + curValue) >0 && isResChangedOnEdit)  rt =  false;
		if(dayObj.curSpecificed && dayObj.isResSpecificed && dayObj.isAdSpecificed && (t + curValue) >0 && isSpecifChangedOnEdit)  rt =  false;
		
		if(dayObj.curSpecificed && !dayObj.isResSpecificed && dayObj.isAdSpecificed && (t + curValue) >1 && isSpecifChangedOnEdit)  rt =  false;
		
		if(dayObj.curSpecificed && dayObj.isResSpecificed && dayObj.isAdSpecificed &&  (t + curValue) >1 )  rt =  false;
		if(dayObj.curSpecificed && dayObj.isResSpecificed && !dayObj.isAdSpecificed && (t + curValue) >0  )  rt =  false;
		if(dayObj.curSpecificed && !dayObj.isResSpecificed && !dayObj.isAdSpecificed && (t + curValue) >1  )  rt =  false;
		

	}
	
	



//	if(rsTotalTime > 0){
//		afterLeaveTimes = dayObj.rsReleave - dayObj.adLength * t;
//	}else{
//		afterLeaveTimes = dayObj.rsReleave - dayObj.adLength * t;
//	}
	var changeTimes =0;//添加该变量是为了实现：就算该资源已经超时,但是没有超时权限的人依然可以编辑订单（占用的时间只能改小或不变）.
	var afterLeaveTimes =0;
	var groupLeaveTimes = 0;
	var oldValue = dayObj.adTimes*1;
	if(dayObj.dayShort ==null) dayObj.dayShort = 0;
	if(isKeypress){
		
		//alert(isResChangedOnEdit);
		//alert(adLength);
	  afterLeaveTimes = dayObj.rsReleave - adLength * (t*1 -oldValue*1);
	  groupLeaveTimes = dayObj.dayShort - adLength * (t*1 -oldValue*1);
	  
	  if(!isResChangedOnEdit){
	  	changeTimes = t*adLength -oldValue*dayObj.adLength;
	  	afterLeaveTimes = dayObj.rsReleave - (t*adLength -oldValue*dayObj.adLength);
	  	groupLeaveTimes = dayObj.dayShort - (t*adLength -oldValue*dayObj.adLength);
	  }
	  
	  if(isResChangedOnEdit){ 
	  	changeTimes = adLength * t;
	  	afterLeaveTimes = dayObj.rsReleave - adLength * t;
	  	groupLeaveTimes = dayObj.dayShort - adLength * t;
	   }
	  
	
	}else{
	    if(isResChangedOnEdit){
			  changeTimes = adLength * (t*1 + curValue*1)
			  afterLeaveTimes = dayObj.rsReleave - adLength * (t*1 + curValue*1);
			  groupLeaveTimes = dayObj.dayShort - adLength * (t*1 + curValue*1);			
		}else{
	 		  changeTimes = adLength * (t*1 + curValue*1)-dayObj.adLength*oldValue*1;
	  		  afterLeaveTimes = dayObj.rsReleave - adLength * (t*1 + curValue*1)+dayObj.adLength*oldValue*1;
	  		  groupLeaveTimes = dayObj.dayShort - adLength * (t*1 + curValue*1)+dayObj.adLength*oldValue*1;
		}
	  //afterLeaveTimes = dayObj.rsReleave - adLength * (t*1 + curValue*1-oldValue*1);
	}
	
	
	
	
//	if(dayObj.dayShort ==0) groupLeaveTimes=100000;
//
//    if(tvNameParam=='fztv' ){
//    	var overTime= dayObj.rsAlert-0;
//    	if(isFree) overTime=0;   
//    	if(dayObj.isLimit && (afterLeaveTimes+overTime < 0||groupLeaveTimes<0)&& rsTotalTime > 0){ 
//				//alert(getFormatDay(dayDate,"yyyy-mm-dd")+"的广告超时!");
//				//注释了上面一行
//				//下面两个if语句是为了实现根据个人选择来决定是否继续提示"广告超时".
//				//isAlert,isConfirm这两个字段在最上面定义了.
//					if(!isKeypress){
//						if(groupLeaveTimes<0){
//							rt =  false;         
//							alert("该时段组"+getFormatDay(dayDate,"yyyy-mm-dd")+"的广告可用时间只有"+(groupLeaveTimes+overTime+adLength*1)+"秒");
//						}else if(afterLeaveTimes+overTime < 0&&groupLeaveTimes==100000){
//							rt =  false;
//							alert("该时段"+getFormatDay(dayDate,"yyyy-mm-dd")+"的广告可用时间只有"+(afterLeaveTimes+overTime+adLength*1)+"秒");
//						}
//					}else{
//						if(groupLeaveTimes<0){
//							rt =  false;         
//						}else if(afterLeaveTimes+overTime < 0&&groupLeaveTimes==100000){
//							rt =  false;
//						}
//					}
//		}
//
//    }else{
    	      	
    	  if(dayObj.isLimit && afterLeaveTimes< 0 && rsTotalTime > 0){
				//alert(getFormatDay(dayDate,"yyyy-mm-dd")+"的广告超时!");
				//注释了上面一行
				//下面两个if语句是为了实现根据个人选择来决定是否继续提示"广告超时".
				//isAlert,isConfirm这两个字段在最上面定义了.
				if(broArrange.isAlert){
//					alert("该时段"+getFormatDay(dayDate,"yyyy-mm-dd")+"的广告超时!");
					extjMessage("该时段"+getFormatDay(dayDate,"yyyy-mm-dd")+"的广告超时!"); 
				}   
				if(broArrange.isConfirm){
//					broArrange.isAlert = confirm("是否继续提示广告超时？");

					Ext.MessageBox.confirm('系统提示', '是否继续提示广告超时？', function(btn) {
			 			  if (btn == 'yes') {
			 				 broArrange.isAlert = true;
			 				 broArrange.isConfirm = false;
			              }else{
			              	 broArrange.isAlert = false;
			              	 broArrange.isConfirm = false;
			              }
			              rt =  false;	
					 });
//						

					
				}
		  
				if(!BroArrange.isTimeOutRight && changeTimes>0){
					 rt =  false;
				}
		}		
//	}


		
	if(dayObj.isPublish) rt =  false;

	//没有维护广告时
	if(rsTotalTime == 0 && t >0) rt =  false;

//	alert(dayObj.isPublish) 
//	alert(t);
//	alert(dayObj.curSpecificed);
//	alert(dayObj.isResSpecificed);
//	alert(dayObj.isAdSpecificed);
//	alert(dayObj.adSpecific != null);
//	alert(dayObj.isSpecificed);
//	alert(dayObj.isLimit);
//	alert(dayObj.isPublish);
//	alert(afterLeaveTimes);
//	alert(rt);
	return rt;
}
	
BroArrange.prototype.setOtherInfo = function(el) {
		this.setMonthTimes(el);
		this.setMonthPrice(el);
		this.setBroSumTime(el);
}
/**
 *  A generic "click" handler :) handles all types of buttons defined in this
 *  calendar.
 */
BroArrange.prototype.cellClick = function(el, ev) {
//	var bro = el.broArrange;
//      console.log(this)
	if(broArrange.currentDateEl !="undefined" && broArrange.currentDateEl != null){
		this.removeClass(broArrange.currentDateEl, "selected");
	}
	this.addClass(el, "selected");
	
//    window.broArrange.currentDateEl = el;
//      this.currentDateEl = el;
      broArrange.currentDateEl = el;
    
	var curValue = (el.innerHTML >0) ? el.innerHTML*1 : 0;
	var oldValue = (el.dayObj.adTimes >0) ? el.dayObj.adTimes*1 : 0;	    
    
    var act = (BroArrange.is_ie || ev.type == "keydown" || ev.type == "keypress");
	var K =  (ev.type == "keydown" || ev.type == "keypress")? ev.keyCode : ev.which;
	
 
	
//	function setOtherInfo(el){
//		this.setMonthTimes(el);
//		this.setMonthPrice(el);
//		this.setBroSumTime(el);
//	}
	

	

  	if(ev.type == "keypress"){
 	 	if (ev.ctrlKey) {
			switch (K) {
				case 37: // KEY left
				case 39: // KEY right
				    el.innerHTML = (el.nextValue > 0) ? el.nextValue : "&nbsp";
					this.setOtherInfo(el);
					break;
				default:
					return false;
			}
		}else{
			return false;
		} 	
			
  	}
  	
   	if(ev.type == "keydown"){
   		//小键盘
//   		if(K == 32) K = 48;
   		if(K >=96 && K<=105)  K = K-48;
   		if(K == 32||K == 8 || K == 110) K = 48;
   		if(K > 47 && K < 58){
   			var num =  String.fromCharCode(K);
   			el.innerHTML = (num > 0) ? num : "&nbsp";
			this.setOtherInfo(el);
   		}

  	} 	

   //鼠标
       
  	if(ev.type == "mousedown"){
  		//alert(K);alert(curValue);
		if(K == 2 || (K == 3 && curValue == 0)) return false;
		var step = (K == 1) ? 1 : -1;
		el.innerHTML = (curValue + step) > 0 ? curValue + step :"&nbsp";
		this.setOtherInfo(el);

  	}	


}


BroArrange.prototype.getNextDay = function(el,step){
	var index = el.index;
	var dt = broArrange.myDate.getDateFromFormat(index,"yyyyMMdd");
	
	var d = new Date(dt);
	if(step == 31) step = d.getMonthDays(d.getMonth());
	if(step == -31) step = -1 * (d.getMonthDays(d.getMonth()-1));
	d.setDate(d.getDate() + step);
	var k = broArrange.myDate.formatDate(d,"yyyyMMdd");
	var ne = broArrange.ar_days[k]; 	
	if(ne =="undefined") ne = el;
	return ne;
}



BroArrange.prototype.makeSelectMonth = function(name,end,step,event){
    var div = document.createElement("div");
    var span = document.createElement("span");
    var parnetNode = $(name).parentNode;
    var select = $(name);
    var obj = [];
    
    
    div.setAttribute("style","position:relative;");
    span.setAttribute("style","margin-left:100px;width:18px;overflow:hidden;");
    
    DWRUtil.removeAllOptions(name);
    obj[0] = "选择月份";
	for(var i = 1; i <= end/step; i++){
		obj[i] = i*step;
	}
	obj[13] = "=全年=";
	 
	DWRUtil.addOptions(name, obj);
	
	select.setAttribute("style","width:70px;margin-left:-100px;");
	
	div.appendChild(span);
	span.appendChild(select);
	parnetNode.appendChild(div);
}

BroArrange.prototype.getBroArrangeStarEndDate = function(appParams){
	var config_serviceDate = appParams.serviceDate.def;
	var trs = this.targ.getElementsByTagName("tr");
	var min = 0, max = 0;
	var isfirstDate = false;

   for(var i = 0; i < trs.length; i++) {
   	    var cell = trs[i].firstChild;
		for (var j = 0; j < 35; ++j,cell = cell.nextSibling) {

			if(cell.navtype == "1"){
				var selectDate = cell.index;
				var selectValue = cell.innerHTML  != "&nbsp;" ? cell.innerHTML :0;

				if(selectValue > 0 && !isfirstDate){
					min = max = selectDate; isfirstDate = true;
				}

				if (selectDate < min && selectValue > 0) min = selectDate;
				if (selectDate > max && selectValue > 0) max = selectDate;
			}			
		}
	
   }	
   if(min == 0) min = config_serviceDate;
//   if(max == 0) max = config_serviceDate;
   
   if(max == 0){
        var cur_day = appParams.serviceDate.date;
		var nextMonth = 0;
		if(tvNameParam =='hbtv'){
			nextMonth = broArrange.myDate.getMonth(min)*1;
			if(cur_day >24){
				nextMonth = nextMonth + 1;
			}
		}else{
			nextMonth = broArrange.myDate.getMonth(min)*1 + 2;
		}
		max = broArrange.myDate.getNewDayEndDay(min,nextMonth);   	
   }

		
		

//    this.startDate = min;
//	this.endDate = max;
//	window.broArrange.minDate = min;
//	window.broArrange.maxDate = max;
	this.broArrangeStartDate.value = min;
	this.broArrangeEndDate.value = max;
}



BroArrange.prototype.autoSet = function(startDay,endDay,days){
	
}
