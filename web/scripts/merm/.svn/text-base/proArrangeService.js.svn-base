//确定按钮
function getBroArrange(){
	var mode = getRadioValue($("selectMode"));
	var month;
	var day;
	var week;
	var selectValue = null;

	//根据月份
	if(mode == 1){
		month = ""+getCheckBoxValues("monthSelect",1);
		selectValue = month.split(",");
	}
	
	//单双日
	if(mode == 2){
		day = ""+getRadioValue($("daySelect"));
		selectValue = day .split(",");
		}
	//星期	
	if(mode == 3){
		week = ""+getCheckBoxValues("weekSelect",1);
		selectValue = week .split(",");
	}
	
	var times = $("times").value;
	autoAddRows();
	fillBroArrange(times,mode,selectValue);
	
	closeBroArrangeDiv();	
}






//排期
function fillBroArrange(times,mode,selectValue){	


   	var start = getFormatDay($("beginDate").value,'ymd');
	var end = getFormatDay($("overDate").value,'ymd');	
	var ids=getResourceIds();
	for(var i = 0; i< ids.length;i++){

		if(getCellValue(ids[i],0)!=""){
			year=getCellValue(ids[i],0);
		}	   
		var month=getCellValue(ids[i],1);
		if(month.length==1) month="0"+month;
		for (var j = 1;j<=31;j++){
			var el = mygrid.cellAll(ids[i],j+1);
			var dayDate;
	
			if(j<10){
			        dayDate=year+month+"0"+j
			}else{
				dayDate=year+month+j
			}

	      		var isDay = isMatchMode(el,mode,selectValue,start,end,dayDate);
	      		if(isDay){
		      		 var ev = Event; ev.type ="keydown" ;
		      		 ev.keyCode = keycodes[times];
					if(!mygrid.cellAll(ids[i],j+1).disabled)
		      		 cellClick(el,ev);
	      		}	

		}
	}	
		
}


function isMatchMode(el,mode,selectValue,start,end,dayDate){
	var shortDate = '' + dayDate;
	var yy =  shortDate.substring(0,4);
	var mm =  shortDate.substring(4,6);
	var dd =  shortDate.substring(6,8);

	if (isUndefined(shortDate)|| shortDate == 'undefined') return false;
        
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
	
	if(mode==4){ 
		if(shortDate >= start && shortDate <= end) return true;
	}		
	
}

function changeMode(){
	var mode = getRadioValue($("selectMode").firstChild);

	isDisPlay(mode);
}



function isDisPlay(mode){
	$("monthSelect").hide();
	$("daySelect").hide();
	$("weekSelect").hide();	


	if(mode==1)$("monthSelect").show();
	if(mode==2)$("daySelect").show();
	if(mode==3)$("weekSelect").show();		
}

function autoAddRows(){		
		
		for(var i=$("beginDate").value.substring(5,7);i<=$("overDate").value.substring(5,7);i++){
			var isEqual=false;
			var ids=getResourceIds();			

			for(var j=0;j<ids.length;j++){
				
				for(var k=2;k<=32;k++){
					mygrid.cells(ids[j],k).setValue("");
				}
				
				month=getCellValue(ids[j],1);

				if(month==i){
					isEqual=true;
				}
			
			}

			if(!isEqual){
				mygrid.addRow((new Date()).valueOf(),[$("beginDate").value.substring(0,4),i],mygrid.getRowsNum()+1);
				addEventAction();				
			}		
	}	
}

function autoBroArrange(){
	
	var oDiv = $("broArrangeDiv");
	oDiv.style.visibility = "visible";
	get_broarray_Date();
	var newstart;
	var newend;
	newstart =  config_serviceDate;	

	var selectedValue = getRadioValue($("selectMode").firstChild);
	
	if (selectedValue == '') selectedValue = 4;
	setRadioCheckedByValue($("selectMode"),selectedValue);
	
	isDisPlay(selectedValue);
}

function get_broarray_Date(){
	Calendar.setup({
		inputField  : "overDate",	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "overDate"	// id of the button
	});
		Calendar.setup({
		inputField  : "beginDate",	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "beginDate"	// id of the button
	});
	$("beginDate").value=getFormatDay(config_serviceDate,'y/m/d');
	$("overDate").value=getFormatDay(config_serviceDate,'y/m/d');
}


function closeBroArrangeDiv(){
	var oDiv = $("broArrangeDiv");
	oDiv.style.visibility = "hidden";
	refreshCheckBox("monthSelect");
	refreshCheckBox("weekSelect");
}

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

				if(minDate.length<2) minDate = "0"+minDate;

				$("beginDate").value = getFormatDay(yy+minDate+"01",'y/m/d');
	
	
			}
			if(maxDate>mmEnd){
				var yy =  end.substring(0,4)*1;
				if(maxDate.length<2) maxDate = "0"+maxDate;

				//var dd = myDate.getEndDay(yy+''+maxDate+"11");
				if(maxDate==4||maxDate==6||maxDate==9||maxDate==11){
					daysOfMonth="30";
				}else if(maxDate==2&&isLeapyear(yy)){
					daysOfMonth="29";
				}else if(maxDate==2&&!isLeapyear(yy)){
					daysOfMonth="28";
				}else{
					daysOfMonth="31";
				}
				$("overDate").value= getFormatDay(yy+maxDate+daysOfMonth,'y/m/d');
			}
	
		
}
