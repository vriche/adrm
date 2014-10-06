
var calendarEvent = new OaCalendarEvent();
var myDate = new MyDate();
var date = new Date();
var user = new User();

callOnLoad(init);	
  
function init(){
	//获得当前用户
	user.obj = user.getCurrentUser();

	setOaCalendarEventPara(calendarEvent);
	setUserPara(user);
	
//	getBeginAndEndDate();
	show(true);
	buttonEventFill();
	
	resetHeigth();
}
function buttonEventFill(){
	var Btn_save = $("Btn_save");
	Btn_save.onclick = save;	
	
	var Btn_del = $("Btn_del");
	Btn_del.onclick = del;
	
	var Btn_cancel = $("Btn_cancel");
	Btn_cancel.onclick = cancel;	
	
//	var Btn_query = $("Btn_query");
//	Btn_query.onclick = query;
	

}
//设置常量
function setOaCalendarEventPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 obj.className = "calendarEvent";	
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.fillObjName = obj.className + "Body";
	 obj.tableName =  "calendarEventList";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "14";
	 
	 obj.dayHTML = "day_" + obj.className;
	 obj.weekHTML  = "week_" + obj.className;
	 obj.monthHTML = "month_" + obj.className;
	 obj.curDate   = myDate.getdefaultDate("yyyy-MM-dd");

	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}
function setUserPara(obj){
	 obj.className 	= "user";
	 obj.IdPrefix 	= obj.className + "Id";
}




//日计划
function getOaCalendarEventTable(){
//	alert(1);
	setOaCalendarEventPara(calendarEvent);
	//过滤数据
	calendarEvent.reset();
	//1.通过日期	
	var curDate = getCurDate();
	calendarEvent.obj.indexDate = curDate;
	//2.通过类型
	calendarEvent.obj.type = 0;
	//3.通过用户
	calendarEvent.obj.createBy = user.obj.id;
	
	var objs = calendarEvent.getOaCalendarEvents(calendarEvent);
	calendarEvent.fillDayTable(objs);

	$(calendarEvent.dayHTML).innerHTML = calendarEvent.pageHTML;
}
function getId(tim,objs){
	var id = 0;
	for(var k=0;k<objs.length;k++){
		
		var o = objs[k];
		var strDate = Date.parseDate(o.createDate,"%y%m%d%H%M%e");
		var times = strDate.getHours()*1;
		if(tim == times){
			id = o.id;
		}
	}
	return id;
}
function getTitle(tim,objs){
	var title = "&nbsp";
	for(var k=0;k<objs.length;k++){
		
		var o = objs[k];
		var strDate = Date.parseDate(o.createDate,"%y%m%d%H%M%e");
		var times = strDate.getHours()*1;
		if(tim == times){
			title = o.title;
		}
	}
	return title;	
}
function getCurDate(){
	var curDate = myDate.getdefaultDate("yyyyMMdd")*1;
	
	return curDate;
}
function getCurTime(tim){
	var date = calendarEvent.curDate;
	var curDate;
	if(tim.toString().length < 2){
		tim = "0" + tim;
	}
	 curDate = date + " " + tim + ":00:00";
	return curDate;
}
function show(bln){
	if(bln){		
		$("calendarList").show();
		$("calendarWeekList").show();
//		$("calendarMonthList").show();
		$("calendarForm").hide();
		$("queryField").show();
	}else{
		$("calendarList").hide();
		$("calendarWeekList").hide();
//		$("calendarMonthList").hide();
		$("calendarForm").show();
	}
}
function getCalendarEvent(id,tim){
		
	function setValueFun(o){
		$("title").value = o.title;
		$("contentId").value = o.content;
		$("eventStateId").value = o.eventStateId;
	}
	
	if(id != 0){
		
		$("calendarEventId").value = id;

		calendarEvent.getOaCalendarEvent(id,setValueFun);
		calendarEvent.obj.indexDate = getCurDate();
		calendarEvent.obj.indexTime = tim;
		calendarEvent.obj.createDate = tim;
		calendarEvent.obj.createBy = user.obj.id;
	}else{
		
		resetCalendarEvent();
		calendarEvent.obj.indexDate = getCurDate();
		calendarEvent.obj.indexTime = tim;
		calendarEvent.obj.createDate = tim;
		calendarEvent.obj.createBy = user.obj.id;
	}
}
function editDayInfo(id,tim){
	show(false);
		
	getCalendarEvent(id,tim);
	calendarEvent.obj.type = 0;
	
	$("type").value = calendarEvent.obj.type;
}
function save(){
	var id = $("calendarEventId").value;
	var mode = '';
		
	if(id == 0){
		mode = 'new'
	}else{
		mode = 'edit';
	}
		
	calendarEvent.obj.indexTime = Date.parseDate(calendarEvent.obj.indexTime,"%y%m%d");
	calendarEvent.obj.id = id;
	calendarEvent.obj.createBy = user.obj.id;
	DWRUtil.getValues(calendarEvent.obj);
	calendarEvent.obj.content = $("contentId").value;
	
	calendarEvent.saveOaCalendarEvent(calendarEvent,mode,saveFun);
	
	show(true);	
		
	function saveFun(){						
			
		if($("type").value == 0){
			getOaCalendarEventTable();
		}
		if($("type").value == 1){
			getWeekTable();
		}
		if($("type").value == 2){
			getMonthTable();
		}
		if($("type").value == 3){
			getQueryResult();
		}
	}
}
function del(){
	var id = $("calendarEventId").value;
	if(id != null){
		calendarEvent.removeOaCalendarEvent(id);		
	}
	show(true);	
	
	if($("type").value == 0){
		getOaCalendarEventTable();
	}
	if($("type").value == 1){
		getWeekTable();
	}
	if(("type").value == 2){
		getMonthTable();
	}
	if($("type").value == 3){
		getQueryResult();
	}
}
function cancel(){
	show(true);
	resetCalendarEvent();
}
function resetCalendarEvent(){
	calendarEvent.reset();
	$("title").value = null;
	$("contentId").value = null;
	$("eventStateId").value = null;
	$("calendarEventId").value = null;
	$("type").value = null;
}
	

function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var tableHeight = $("calendarEvent");
    var queryField = $("queryField");
    
    
    tableHeight.style.height = (dialogcontent.offsetHeight - dialogcontent.offsetTop)*0.92 + "px";
    
    queryField.style.height = (dialogcontent.offsetHeight - dialogcontent.offsetTop)*0.80 + "px";
}



//周计划
function getWeekTable(){
	setOaCalendarEventPara(calendarEvent);	
	//过滤
	calendarEvent.reset();
	//1.获得当前用户Id
	calendarEvent.obj.createBy = user.obj.id;
	var createBy = calendarEvent.obj.createBy;
	//2.通过日期 类型和用户
	var curDate = myDate.getdefaultDate();
	var curYear = myDate.getYear(curDate);
	var curMonth = myDate.getMonth(curDate);
	var curDayDate = date.getDate();
	var weekNum = date.getDay();
	for(var i=weekNum;i>0;i--){
		curDayDate--;
	}
	var curWeekMaxDate = curDayDate + 6;
	var beginDate = (curYear+curMonth+curDayDate)*1;
	var lastDate = (curYear+curMonth+curWeekMaxDate)*1;
	var objs = calendarEvent.getOaCalendarEventsByWeek(beginDate,lastDate,1,createBy);
		
	var str = calendarEvent.fillWeekTable(objs);
	$(calendarEvent.weekHTML).innerHTML = str;
}
//获得本周是第几周
function getCurWeekNum(){
	var weekDate = date.getWeekNumber();
	var str = '第'+weekDate+'周';
	return str;
}
//获得今天是星期几，几月几号
function getCurNum(){
	var weekNum = date.getDay();
	var curDate = myDate.getdefaultDate();
	var curMonth = myDate.getMonth(curDate);
	var curDayDate = date.getDate();
	
	var str ='星期'+ calendarEvent.changeWeek(weekNum)+' '+curMonth+'/'+curDayDate;
	
	return str;
}
function getWeekTypeId(date,objs){
	var id = 0;
	for(var k=0;k<objs.length;k++){
		var o = objs[k];
		var weekDate = o.createDate;
		var beginIndex = weekDate.indexOf('-');
		var endIndex = weekDate.indexOf(' ');
		var strDate = weekDate.substring(beginIndex+1,endIndex);
		
		if(strDate == date){
			id = o.id;
		}	
	}

	return id;	
}
function getWeekTitle(objs,date){
	var title = "&nbsp";
	for(var k=0;k<objs.length;k++){
		
		var o = objs[k];
		
		var weekDate = o.createDate;
		var beginIndex = weekDate.indexOf('-');
		var endIndex = weekDate.indexOf(' ');
		var strDate = weekDate.substring(beginIndex+1,endIndex);
		
		
		if(strDate == date){
			title = o.title;
		}
	}
	
	return title;	
}
//获得本周的日期
function getCurWeekDate(tim){
	var curDate = myDate.getdefaultDate();
	var curMonth = myDate.getMonth(curDate);
	var curDayDate = date.getDate();
	var weekNum = date.getDay();
	var startDate;
	
	var yearMonthDays = myDate.getNextMonthDay(curDate);
		
	var month = changeMonth(curMonth);
	var curMonthMaxDay = date.getMonthDays(month);

	
	if(curDayDate > 1){
		for(var i=weekNum;i>0;i--){
			curDayDate--;
			if(curDayDate < 10) curDayDate = "0" +	curDayDate;
			startDate = curMonth+'-'+curDayDate;
		}
	}else{
		startDate = curMonth+'-'+curDayDate;		
	}
		
	if(curDayDate <= curMonthMaxDay){
		for(var j= 0;j<tim;j++){
			curDayDate++;
			if(curDayDate < 10) curDayDate = "0" +	curDayDate;
			startDate = curMonth+'-'+curDayDate;
		}
	}
	
	return startDate;
}
function changeMonth(num){
	var n = '';
	
	if(num == '01'){n = '1'};
	if(num == '02'){n = '2'};
	if(num == '03'){n = '3'};
	if(num == '04'){n = '4'};
	if(num == '05'){n = '5'};
	if(num == '06'){n = '6'};
	if(num == '07'){n = '7'};
	if(num == '08'){n = '8'};
	if(num == '09'){n = '9'};
	if(num == '10'){n = '10'};
	if(num == '11'){n = '11'};
	if(num == '12'){n = '13'};
	
	return n;
}
function editWeekInfo(id,tim,i){
	show(false)
	
	var curDate = myDate.getdefaultDate();
	var curYear = myDate.getYear(curDate);
	
	getCalendarEvent(id,tim);
	var date = getCurWeekDate(i);
	
	var createDate = curYear + '-' + date + ' ' + '00:00:00';	
	var beginIndex = createDate.indexOf('-');
	var str1 = createDate.substring(0,beginIndex);
	var lastIndexOf = createDate.lastIndexOf('-');
	var index = createDate.indexOf(' ');
	var str2 = createDate.substring(beginIndex+1,lastIndexOf);
	var str3 = createDate.substring(lastIndexOf+1,index);
	
	var indexDate = (str1+str2+str3)*1;	
		
	calendarEvent.obj.indexDate = indexDate;
	calendarEvent.obj.indexTime = createDate;
	calendarEvent.obj.createDate = createDate;
	calendarEvent.obj.type = 1;
	
	$("type").value = calendarEvent.obj.type;
	
}







////月信息
//function getMonthTable(){
//	setOaCalendarEventPara(calendarEvent);
//	var str = calendarEvent.fillMonthTable();
//	$(calendarEvent.monthHTML).innerHTML = str;
//}	
//function getDate(){
//	var curDate = myDate.getdefaultDate();
//	var curMonth = myDate.getMonth(curDate);
//	var curYear = myDate.getYear(curDate);
//	
//	var str = curYear + '年' + curMonth + '月';
//	
//	return str;
//}
//////获得本周是第几周
////function getWeekNum(tim){
////	var weekDate = date.getWeekNumber();
////	var str = '第'+weekDate+'周';
////	return str;
////}
//function editMonthDate(){
// 	 $("calendarMonthList").hide();
// 	 $("calendarForm").show();
// 	 
//	calendarEvent.obj.type = 2;
//	
//	$("type").value = calendarEvent.obj.type;
//}

//function thisMonth(){
//	var mnth = date.getMonth();
//	var dayOfMonth = date.getDate();
//	var dayOfWeek = date.getDay();
//	var yr = date.getFullYear();
//	
//	var mnthName = getMonthName(mnth)+ " ";
//
//	document.forms[0].month.value = mnth;
//	document.forms[0].year.value = yr;
//	document.forms[0].currMonth.value = mnth;
//	document.forms[0].currYear.value = yr;
//	  
//	document.forms[0].monthYear.value = mnthName+yr;
//	document.forms[1].dateField.value = (mnth+1)+"/"+dayOfMnth+"/"+yr;
//	
//	var startStr = (mnth+1)+"/1/"+yr;
//	var dt1 = new Date(startStr);
//	var dayOfWeek1 = dt1.getDay(); /*0-6*/
//	
//	var noOfDaysInMnth = getNoOfDaysInMnth(mnth+1,yr);
//	fillDates(dayOfWeek1+1,noOfDaysInMnth);	
//}
//function getMonthName(mnth) {
//
//	if (mnth == 0) {
//	  	name = "January";
//	}else if(mnth==1) {
//	  	name = "February";
//	}else if(mnth==2) {
//	  	name = "March";
//	}else if(mnth==3) {
//	  	name = "April";
//	}else if(mnth==4) {
//	  	name = "May";
//	} else if(mnth==5) {
//	  	name = "June";
//	} else if(mnth==6) {
//	  	name = "July";
//	} else if(mnth==7) {
//	  	name = "August";
//	} else if(mnth==8) {
//	  	name = "September";
//	} else if(mnth==9) {
//	  	name = "October";
//	} else if(mnth==10) {
//	  	name = "November";
//	} else if(mnth==11) {
//	  	name = "December";
//	}
//
//	return name;
//
//}
//function getNoOfDaysInMnth(mnth,yr) {
// 
//	var rem = yr % 4;
//	
//	if(rem ==0) {
//		leap = 1;
//	} else {
//		leap = 0;
//	}
//
//	noDays=0;
//
//	if ( (mnth == 1) || (mnth == 3) || (mnth == 5) || (mnth == 7) || (mnth == 8) || (mnth == 10) ||(mnth == 12)) {
//		noDays=31;
//	}else if (mnth == 2) {
//		noDays=28+leap;
//	} else {
//		noDays=30;
//	}
//	
//	return noDays;
//}
//function fillDates(dayOfWeek1,noOfDaysInmnth){
//
//	for(var i=1; i<43; i++) {
//	   str = "s"+i;
//	   document.forms[0].elements[str].value="   ";
//	}
//	
//	
//	startSlotIndx = dayOfWeek1;
//	slotIndx = startSlotIndx;
//	
//	for(var i=1; i<(noOfDaysInmnth+1); i++) {
//		slotName = "s"+slotIndx;
//		
//		val="";
//		if (i<10) {
//		    val = " "+i+" ";
//		} else {
//		    val = i;
//		}
//		
//		document.forms[0].elements[slotName].value = val;
//		slotIndx++;
//	}
//}	
//function setDate(str) {
//	
//	if (str == "   ") {
//	  return;
//	}
//	
//	mnth1 = document.forms[0].month.value;
//	mnth = mnth1;
//	mnth++;
//	year = document.forms[0].year.value;
//	dateStr = mnth+"/"+str+"/"+year;
//	
//	dateStr = trim(dateStr);
//	
//	document.forms[1].dateField.value = dateStr;
//}
//function trim(str) {
//	res="";
//	
//	for(var i=0; i< str.length; i++) {
//	   if (str.charAt(i) != " ") {
//	     res +=str.charAt(i);
//	   }
//	}
//	
//	return res;
//}










//查询
function getQueryResult(){
	setOaCalendarEventPara(calendarEvent);
	
	var func = function(objs){
		calendarEvent.fillTalbe(objs);
	}
	calendarEvent.reset();
	calendarEvent.getOaCalendarEventsByDate(calendarEvent.obj,func);
}
function getBeginAndEndDate(){
//	Calendar.setup({
//		inputField  : "testDate",	  // id of the input field
//		ifFormat	: "%Y%m%d",	  // the date format
//		button	  : "testDate"	// id of the button
//	});
	
	Calendar.setup({
		inputField  : "overDate",	  // id of the input field
		ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "overDate"	// id of the button
	});
}
function query(){
	var beginDate = $("beginDate").value;
	var endDate = $("overDate").value;
	
	var func = function(objs){
		calendarEvent.fillTalbe(objs);
	}
	
	calendarEvent.getOaCalendarEventsByBeginAndEndDate(beginDate,endDate,func);
}
function editOaCalendarEvent(editImg){
	var id = editImg.getAttribute("paraId"); 
	
	$("calendarEventId").value = id;
	

	var date = calendarEvent.curDate + " " + "00:00:00";	

	var str1 = date.substring(0,date.indexOf('-'));
	var str2 = date.substring(date.indexOf('-')+1,date.lastIndexOf('-'));
	var str3 = date.substring(date.lastIndexOf('-')+1,date.indexOf(" "));
	var indexDate = (str1+str2+str3)*1;
		
	var func = function(o){
		$("calendarForm").show();
		$("queryField").hide();

		$("title").value = o.title;
		$("contentId").value = o.content;
		$("eventStateId").value = o.eventStateId;
		
		$("type").value = o.type;
		
		calendarEvent.obj.indexDate = indexDate;
		calendarEvent.obj.indexTime = o.createDate;
		calendarEvent.obj.createDate = o.createDate;
	}
	
	calendarEvent.getOaCalendarEvent(id,func);
}
function button_add_new_obj(type){
	
	var date = calendarEvent.curDate + " " + "00:00:00";
		
	if(type == 0){
		$("calendarForm").show();
		$("queryField").hide();
		getCalendarEvent(0,date);
		$("type").value = 3;
	}
}
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == calendarEvent.pageInfo){
		var page = new Page(calendarEvent.pageInfo,calendarEvent.pageSize);
		page.goNextPage(pageIndex);
		calendarEvent.page = page;
		getQueryResult();
	}
}
function delOaCalendarEvent(deleImg){	
	var id = deleImg.getAttribute("paraId"); 
	calendarEvent.removeOaCalendarEvent(id);
	
	getQueryResult();
}

