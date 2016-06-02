//确定按钮
function getBroArrange(appParams,detailBackUp,broArr,callFun){
	var mode = getRadioValue($("selectMode"));
	var month;
	var day;
	var week;
	var selectValue = null;

	otherFocus();


  
      broArr.startDate = getFormatDay($("beginDate").value,'ymd');	
      broArr.endDate = getFormatDay($("overDate").value,'ymd');	
	
	//根据月份
//	if(mode == 0){
//
//      $("beginDate").value = getFormatDay(order_year+'0101','y/m/d');
//	  $("overDate").value= getFormatDay(order_year+'1231','y/m/d');
//	}
	if(mode == 1){
		month = ""+getCheckBoxValues("monthSelect",1);
		selectValue = month.split(",");
	}
	
	//单双日
	if(mode == 2){
		day = ""+getRadioValue($("daySelect"));
		selectValue = day.split(",");
		}
	//星期	
	if(mode == 3){
		week = ""+getCheckBoxValues("weekSelect",1);
		selectValue = week.split(",");
	}
	
	var times = $("times").value;
	

	var func = function() {
		broArr.cleanBroArrange();
		fillBroArrange(broArr,times,mode,selectValue);
		broArr.getBroArrangeStarEndDate(appParams);

		if(alertStr1.indexOf('-')!=-1){
			extjMessage(alertStr1); 
			alertStr1='该时段播出单已出的日期:\n\r';
		}
		
		if(alertStr2.indexOf('-')!=-1){
			extjMessage(alertStr2); 
			alertStr2='该时段超时日期:\n\r';
		}		
		
		
	}
	
	closeBroArrangeDiv();	
	
	if(callFun) callFun(func);
	
//	getMonthInfos(bro_satr,bro_end,func);
};


//排期并填充价格信息等。
function fillBroArrange(broArr,times,mode,selectValue){	
	var trs = broArr.targ.getElementsByTagName("tr");
	var trnum = trs.length;
   	//var keycodes = new Array(48,49, 50, 51, 52, 53, 54, 55, 56, 57);
   	//var start = $("beginDate").value;
	//var end = $("overDate").value;
   	var start = getFormatDay($("beginDate").value,'ymd');
	var end = getFormatDay($("overDate").value,'ymd');	

	var trs = broArr.targ.getElementsByTagName("tr");
	for(var i = 0; i< trs.length;i++){
		var cells = trs[i].cells;
		var navtype =cells[0].navtype;
		
		if(navtype !="-1"){
			for (var j = 0 ; j < 32;j++){
				var el = cells[j];
				
		      		var isDay = isMatchMode(el,mode,selectValue,start,end);
		      		if(isDay){
			      		 var ev = Event; ev.type ="keydown" ;
			      		 ev.keyCode = BroArrange.keycodes[times];
			      		 if(broArr.isEnableCellClick(el,ev)){
			      		 	 broArr.cellClick(el,ev);
			      		 }else{
				      		 if(el.dayObj.isLocked && config_outLimitBroarrang){
				      		 		alertStr1+=getFormatDay(el.dayObj.dayDate,"yyyy-mm-dd")+'\n\r';	
				      		 }else{
					      		 	if(el.dayObj.rsTotalTime > 0){
					      		 		alertStr2+=getFormatDay(el.dayObj.dayDate,"yyyy-mm-dd")+'\n\r';	
					      		 	}
				      		 }
			      			 

			      		 }
		      		}	
	
			}
		}

	}	
		
};


function isMatchMode(el,mode,selectValue,start,end){
	var shortDate = '' + el.dayObj.dayDate;
	var yy =  shortDate.substring(0,4);
	var mm =  shortDate.substring(4,6);
	var dd =  shortDate.substring(6,8);

	if (isUndefined(shortDate)|| shortDate == 'undefined') return false;

        if (!myDate.isDate(shortDate,"yyyyMMdd")) return false;
        
	if(mode == 1 || mode == 3){
		for(var j=0;j<selectValue.length;j++){
			if(mode == 1){	
				if(mm*1 == selectValue[j] && shortDate >= start && shortDate <= end){return true;}
			}
			
			if(mode == 3){
				var d = new Date(yy,mm-1,dd,0,0,0);
				if(d.getDay()==selectValue[j] && shortDate >= start && shortDate <= end){return true;}
			}
		}	
	}

	
	if(mode == 2){
		var oneOrtwo = selectValue[0]==1?1:0;
		if(dd*1%2 == oneOrtwo && shortDate >= start && shortDate <= end){return true;}	
	}
	
	if(mode==0 || mode==4){ 
		if(shortDate >= start && shortDate <= end) return true;
	}		
	
};

function changeAutoArrangeStartAndEnd(){
			month = ""+getCheckBoxValues("monthSelect",1);
			var monthValue = month.split(",");
			//var start = $("beginDate").value;
			//var end = $("overDate").value;
			
			var start = getFormatDay($("beginDate").value,'ymd');
			var end = getFormatDay($("overDate").value,'ymd');
			
			var mmStart =  start.substring(4,6)*1;
			var mmEnd = end.substring(4,6)*1;
			
			var mmStart = 0;
			var mmEnd = 0;
			
			var minDate = 13;
			var maxDate = 0
			for(var i = 0;i<monthValue.length;i++){
				
				if(monthValue[i]*1 < minDate){
					minDate	 =monthValue[i];
				}
				if(monthValue[i]*1 > maxDate){
					maxDate	 =monthValue[i];
				}			
			}
			if(minDate>mmStart){
				var yy =  start.substring(0,4)*1;
				//var dd = myDate.
				if(minDate.length<2) minDate = "0"+minDate;
				//$("beginDate").value = yy+minDate+"01";
				$("beginDate").value = getFormatDay(yy+minDate+"01",'y/m/d');
	
	
			}
			if(maxDate>mmEnd){
				var yy =  end.substring(0,4)*1;
				if(maxDate.length<2) maxDate = "0"+maxDate;
				//alert(yy+''+maxDate+"11");
				var dd = myDate.getEndDay(yy+''+maxDate+"11");
				//alert(dd);	
				//$("overDate").value = dd;
				$("overDate").value= getFormatDay(dd,'y/m/d');
			}
};


function changeMode(){
	var mode = getRadioValue($("selectMode").firstChild);
	isDisPlay(mode);
};



function isDisPlay(mode){
	$("monthSelect").hide();
	$("daySelect").hide();
	$("weekSelect").hide();	

	if(mode==1)$("monthSelect").show();
	if(mode==2)$("daySelect").show();
	if(mode==3)$("weekSelect").show();		
	
	if(mode == 0){
      $("beginDate").value = getFormatDay(order_year+'0101','y/m/d');
	  $("overDate").value= getFormatDay(order_year+'1231','y/m/d');
	}
};

function autoBroArrange(appParams,orderYear,oDiv,selectMonthCmd,startEl,endEl,detailBackUp,broArr,orderStates){
	

	
	var isDisplay = oDiv.style.visibility == "visible";
	if(isDisplay){
			oDiv.style.visibility = "hidden";
			return false;
	}else{
			oDiv.style.visibility = "visible";
	}

	get_broarray_Date(orderYear);
	

		
	var def_serviceDate = appParams.serviceDate.def;
	var def_year = appParams.serviceDate.year;
	var start = def_serviceDate;
	var end = def_serviceDate;
	var newstart = (orderYear != def_year)? broArr.myDate.getStartDay(orderYear+"0101"):def_serviceDate;
	

		
	if(orderStates == 1 || orderStates == 3){
//		start = detailBackUp.orderPublic.publishStartDate;
//		end = detailBackUp.orderPublic.publishEndDate;

 		if(broArr.broSumTime.value>0){
 					broArrange.getBroArrangeStarEndDate(appParams);
 		}

		
		 start =  broArrange.broArrangeStartDate.value;
  		 end =   broArrange.broArrangeEndDate.value;
		start = (start == null||start == 0)? newstart:start;
		end = (end == null||end == 0)? newstart:end;
	}else{
		start = newstart;
//		end =   broArr.myDate.getNextMonthDay(start);
        var cur_day = appParams.serviceDate.date;
		var nextMonth = 0;
		if(tvNameParam =='hbtv'){
			nextMonth = broArr.myDate.getMonth(start)*1;
			if(cur_day >24){
				nextMonth = nextMonth + 1;
			}
		}else{
			nextMonth = broArr.myDate.getMonth(start)*1 + config_orderArrangDefaultMonths;
		}
		if(nextMonth*1 > 12){
			 nextMonth = 12;
		}
		
		end = broArr.myDate.getNewDayEndDay(start,nextMonth);
	}

		startEl.value = getFormatDay(start,'y/m/d');
		endEl.value = getFormatDay(end,'y/m/d');		
	


	
	var selectedValue = getRadioValue(selectMonthCmd.firstChild);
	
	if (selectedValue == '') selectedValue = 4;
	setRadioCheckedByValue(selectMonthCmd,selectedValue);
	isDisPlay(selectedValue);
};

function get_broarray_Date(orderYear){
	
//	function dateDisabledFunc(date,i){
//		if(i == 1){
//		   var pval = ''+$("overDate").value; 
//		   pval = pval.replace("/",'')*1;
//		   var calDate = date.print("%Y%m%d")*1;
//		   return !(date.getFullYear() == order_year && calDate < pval);
//		}else{
//		   var pval = $("beginDate").value;
//		   pval = pval.replace("/",'')*1;
//		   var calDate = date.print("%Y%m%d")*1;
//		   return !(date.getFullYear() == order_year && calDate > pval);
//		}
//
////		 return (date.getFullYear() != order_year);
//	}	
	
	//Calendar.activeDiv = $("broArrangeDiv");
	
		Calendar.setup({
		inputField  : "beginDate",	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		range:[orderYear],
		button	  : "beginDate",	// id of the button
		dateDisabledFunc : function(date) {
//                     dateDisabledFunc(date,1);
		}
	});	
	
	Calendar.setup({
		inputField  : "overDate",	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		range:[orderYear],
		button	  : "overDate",	// id of the button
		dateDisabledFunc : function(date) {
//			     return (date.getFullYear() != order_year);
//                     dateDisabledFunc(date,2);
		}
	});

};

function closeBroArrangeDiv(){
	var oDiv = $("broArrangeDiv");
	oDiv.style.visibility = "hidden";
	refreshCheckBox("monthSelect");
	refreshCheckBox("weekSelect");
};