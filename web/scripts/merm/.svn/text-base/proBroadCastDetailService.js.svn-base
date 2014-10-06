var proPublishPlanDetail = new ProPublishPlanDetail();
var carrier = new Carrier();
var proPublishPlan = new ProPublishPlan();
var mygrid;
var ctxPath;
var planId;
var num;
var month;
var year;
var roundNum;
var keycodes = new Array(48,49, 50, 51, 52, 53, 54, 55, 56, 57);
callOnLoad(init);

function init(){
	ctxPath = $F("ctxPath");
	roundNum=0;
	channelModelParam = $("config_channelModelParam").value;
	document.oncontextmenu=function stop(){return false;};
	planId=getParamFromUrl(document.location.href,"id");
	programId=getParamFromUrl(document.location.href,"programId");

	getServiceDate();
	config_serviceDate = $("config_serviceDate").value;
	setCarrierPara(carrier);

	initGrid();
	initToolbar();
	buttonEventFill();
	if(planId!=null){
		getAllValueById();
		getBroadCastDetailTable();
	}
	
}
function getAllValueById(){
	proPublishPlan.reset();
        proPublishPlan.obj.id=planId;
        $("proPublishPlanId").value=planId;
	 var func = function(objs){
		$("carrierName").value=objs.carrierId;
		$("round").value=objs.weeksPlan;
		
		
		$("startHour").value=objs.startDate<10?"0"+objs.startDate:objs.startDate;
		$("startMinute").value=objs.startTime<10?"0"+objs.startTime:objs.startTime;
		$("endHour").value=objs.endDate<10?"0"+objs.endDate:objs.endDate;
		$("endMinute").value=objs.endTime<10?"0"+objs.endTime:objs.endTime;
				
		 }
	
		proPublishPlan.getProPublishPlan(proPublishPlan.obj,func);
}
function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}
function buttonEventFill(){
	var Btn_confim = $("confim");
	Btn_confim.onclick = getBroArrange;

	var Btn_down = $("broDown");
	Btn_down.onclick = closeBroArrangeDiv;
	
	var radiobutton_modes = $A($("selectMode").getElementsByTagName("input"));
	radiobutton_modes.each(function(ip){ip.onclick = changeMode;});	

}
 function getServiceDate(){
 	var fuc = function(d){
 		$("config_serviceDate").value = d;
 	}
 	DWREngine.setAsync(false);
 	DateUtil.getServiceDate(fuc);
 	DWREngine.setAsync(true);
 }
function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");
	
	var flds = "年份,月份,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,合计";
	mygrid.setHeader(flds);

	var columnIds = "year,month," 
					+"day1,day2,day3,day4,day5,"
					+"day6,day7,day8,day9,day10,"
					+"day11,day12,day13,day14,day15,"
					+"day16,day17,day18,day19,day20,"
					+"day21,day22,day23,day24,day25,"
					+"day26,day27,day28,day29,day30,"
					+"day31,monthTimes";
	mygrid.setColumnIds(columnIds);
	mygrid.setInitWidthsP("5.6,5.6,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,2.7,5.1");

	mygrid.setColAlign("center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center");
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed[=c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17+c18+c19+c20+c21+c22+c23+c24+c25+c26+c27+c28+c29+c30+c31+c32]");
    
    mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	//mygrid.setDragBehavior("nextSibling"); //nextSibling complex
	//mygrid.enableDragAndDrop(false);
	
      //mygrid.setOnRowSelectHandler(doOnRowSelected);
      //mygrid.setOnRowDblClickedHandler(doOnReturn);
      //mygrid.setOnRowDblClickedHandler(onValueAdded);
      //mygrid.setOnEnterPressedHandler(onValueSubed);

	mygrid.init();
	makeCarrierSelectItem();
}
 function makeCarrierSelectItem(){
	//根据是否分频道，取得频道下拉列表
	if(channelModelParam!=1){
		carrier.makeSelectItemAnalyze(carrier.obj,carrier.selectName,"");
	}else{
		carrier.makeSelectItemAnalyze2(carrier,carrier.selectName,"",setCarrierSelect);
	}
}
function setCarrierSelect(){
	var id  = $("carrierName").value;
	 	if(id > 0){
	 		$(carrier.selectName).value = id;
	 	}
}
function initToolbar(){
	var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml" ;
	var aToolBar1=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo");
	aToolBar1.setOnClickHandler(onButtonClick);
	aToolBar1.loadXML(toolbarDataPath,callBack);
	function callBack(){
		aToolBar1.hideButtons(); 
        aToolBar1.showButtons("2_delete,3_save,15_set"); 
        aToolBar1.showButtons("div_2,div_3,div_15"); 
	}
	aToolBar1.showBar();  
}

function onButtonClick(itemId,itemValue){
	//if(itemId=='1_new') btnAddRow();
	if(itemId=='2_delete') btnDeleteRow();
	if(itemId=='3_save') btnSaveRow();
	if(itemId=='15_set') autoBroArrange();
}

function btnAddRow(){
	
	if(mygrid.getRowsNum()==0){
		month=getDayPar(config_serviceDate,'m');
		year=getDayPar(config_serviceDate,'y');
		rows = month-0;
	}
			var ids=getResourceIds();


			for(var i=0;i<ids.length;i++){
				if(getCellValue(ids[i],0)!=""){
					year=getCellValue(ids[i],0);
				}	      
			}
	if(mygrid.getRowsNum()!=0){
		var rowsNum = mygrid.getRowsNum();
		rowsId = mygrid.getRowId(rowsNum-1);
		rowsIds = mygrid.getRowId(0);
		firstRowsYear=getCellValue(rowsIds,0);
		firstRowsMonth=getCellValue(rowsIds,1);
		lastRowsMonth=getCellValue(rowsId,1);

		if((rowsNum-(12-firstRowsMonth))%12==1){
			roundNum=Math.ceil((rowsNum-(12-firstRowsMonth))/12);
		}
		if(Math.ceil((rowsNum-(12-firstRowsMonth))/12)==roundNum){	
		
			year=firstRowsYear-0+roundNum
		}


		if(lastRowsMonth<12){

		     rows=lastRowsMonth-0+1;
		}else if(lastRowsMonth=12){
			//year=firstRowsYear-0+1;
			rows=1;	
		}else{return false;}
	}

		mygrid.addRow((new Date()).valueOf(),[year,rows],mygrid.getRowsNum()+1);
		addEventAction();	
}


function btnDeleteRow(){
	var ids=getResourceIds();
	
	if(ids.length > 0){
		var msg = "请确认是否删除所有记录 ?";
		
		ans = confirm(msg);
	    if (ans) {
		proPublishPlanDetail.removeProPublishPlanDetail(ids[0].substring(0,ids[0].length-6));
		mygrid.clearAll(); 
	    } 
	}else{
		alert("没有可删除的记录！");
	}
}
function btnSaveRowDetail(){
   		
		var ids=getResourceIds();
		
		for(var i=0;i<ids.length;i++){
			var time = new Array();
			for(var j=2;j<=32;j++){
				var dayTimes = getCellValue(ids[i],j);
				if(dayTimes=="") dayTimes="0";
				time.push(dayTimes);
			}
			
			years=getCellValue(ids[i],0);
			if(years==""){
				for(var k=0;k<ids.length;k++){
					if(ids[k]<=ids[i]&&getCellValue(ids[k],0)!=""){
						years=getCellValue(ids[k],0);
					}	      
				}
			}
			months=getCellValue(ids[i],1);
			if(months.length==1){
				months="0"+months;	
			}
			
			proPublishPlanDetail.reset();

			proPublishPlanDetail.obj.publishPlanId = $("proPublishPlanId").value;
			proPublishPlanDetail.obj.planDate = years+months;
			proPublishPlanDetail.obj.times = time;
                 var func=function(){
                 	
                }
			proPublishPlanDetail.saveProPublishPlanDetail(proPublishPlanDetail.obj,func);
				
		}
	if(ids.length>0){
		alert("保存成功");
	}else{
		alert("没有可保存的记录，请添加记录！");
	}	
		
	    	
}
function btnSaveRow(){

			proPublishPlan.reset();
			proPublishPlan.obj.id = $("proPublishPlanId").value==null?0:$("proPublishPlanId").value;
			proPublishPlan.obj.programId = programId;
			proPublishPlan.obj.carrierId = $("carrierName").value;
			proPublishPlan.obj.weeksPlan = $("round").value;

				proPublishPlan.obj.startTime = ($("startHour").value*3600 +  $("startMinute").value*60)*1000;
				proPublishPlan.obj.endTime = ($("endHour").value*3600 + $("endMinute").value*60)*1000;
			if($("carrierName").value==0){
				    alert("请选择一个频道！");
				    return false;
			}	
			if($("startHour").value>=24||$("endHour").value>=24){
				    alert("一天不能超过24小时！");
				    return false;
			}
			if($("startMinute").value>=60||$("endMinute").value>=60){
				    alert("一小时不能超过60分钟！");
				    return false;
			}
			    if(proPublishPlan.obj.startTime>proPublishPlan.obj.endTime){
				    alert("开始时间不应早于结束时间！");
				    return false;
			}
				var func = function(id){
				$("proPublishPlanId").value=id;
				btnSaveRowDetail();				
			}
				proPublishPlan.saveProPublishPlanById(proPublishPlan.obj,func);

}
function getResourceIds(){
	var rows = mygrid.getRowsNum();
    var ids = new Array();
	for(var i=0;i<rows;i++){
		var id = mygrid.getRowId(i);
		ids.push(id);
	}
	return ids;
}
function getCellValue(rowId,col){ 
	return mygrid.cells(rowId,col).getValue();
}

function doOnReturn(rowId,col){
	mygrid.setRowTextStyle(rowId,'background-color:white;font-size:12px;');

}
function onValueSubed(rowId,col){
	if(col!=0&&col!=1){
		num=getCellValue(rowId,col);
	if(num!=""&&num!=0){
		mygrid.cells(rowId,col).setValue(num-0-1);
	}	
}
}
function onValueAdded(rowId,col){
	var selectId=mygrid.getSelectedId();
	var id;
	var ids=getResourceIds();
	for(var i=0;i<ids.length;i++){
		if(selectId==ids[i]) 
		id=ids[i-1];
	}
	if(getCellValue(selectId,0)!="") id=selectId;
	var month=getCellValue(selectId,1);
	if(month==4||month==6||month==9||month==11){
	   if(col!=0&&col!=1&&col!=32){num=getCellValue(rowId,col);mygrid.cells(rowId,col).setValue(num-0+1);}
 
	}else if(month==2&&isLeapyear(getCellValue(id,0))){
		
	    if(col!=0&&col!=1&&col!=31&&col!=32) {num=getCellValue(rowId,col);mygrid.cells(rowId,col).setValue(num-0+1);}

	}else if(month==2&&!isLeapyear(getCellValue(id,0))){
		if(col!=0&&col!=1&&col!=30&&col!=31&&col!=32) {num=getCellValue(rowId,col);mygrid.cells(rowId,col).setValue(num-0+1);}

	}else{if(col!=0&&col!=1){num=getCellValue(rowId,col);mygrid.cells(rowId,col).setValue(num-0+1);}}
}

var stopEvent = function(ev) {
		ev.preventDefault();
		ev.stopPropagation();
	return false;
};

var addEvent = function(el, evname, func) {
	if (el.attachEvent) { // IE
		el.attachEvent("on" + evname, func);
	} else if (el.addEventListener) { // Gecko / W3C
		
		el.addEventListener(evname, func, true);
	} else {
		el["on" + evname] = func;
	}
};

var removeEvent = function(el, evname, func) {
	if (el.detachEvent) { // IE
		el.detachEvent("on" + evname, func);
	} else if (el.removeEventListener) { // Gecko / W3C
		el.removeEventListener(evname, func, true);
	} else {
		el["on" + evname] = null;
	}
};
var add_evs = function(el) {
		addEvent(el, "mouseover", dayMouseOver);
		addEvent(el, "mousedown", dayMouseDown);
		addEvent(el, "mouseout", dayMouseOut);
};

var dayMouseOver = function(ev) {

		var el = ev.currentTarget;
		if (el.disabled) return false;
		//alert(isRelated(el, ev));
		return stopEvent(ev);		
};

var dayMouseDown = function(ev) {
	var el = ev.currentTarget;

	if (el.disabled) return false;
	
		cellClick(el,ev);

	return stopEvent(ev);	
};


var dayMouseOut = function(ev) {

		var el = ev.currentTarget;
		//if (isRelated(el, ev))
			//return false;
		return stopEvent(ev);				

};
var cellClick = function(el, ev) {


    
	var curValue = (el.innerHTML >0) ? el.innerHTML*1 : 0;
    
   
	var K =  (ev.type == "keydown" || ev.type == "keypress")? ev.keyCode : ev.which;

	

	

  	if(ev.type == "keypress"){
 	 	if (ev.ctrlKey) {
			switch (K) {
				case 37: // KEY left
				case 39: // KEY right
				    el.innerHTML = (el.nextValue > 0) ? el.nextValue : "&nbsp";
					break;
				default:
					return false;
			}
		}else{
			return false;
		} 		
  	}
  	
   	if(ev.type == "keydown"){

   		if(K > 47 && K < 58){
   			var num =  String.fromCharCode(K);
   			el.innerHTML = (num > 0) ? num : "&nbsp";
   		}

  	} 	

   //鼠标
       
  	if(ev.type == "mousedown"){
  		//alert(K);alert(curValue);
		if(K == 2 || (K == 3 && curValue == 0)) return false;
		var step = (K == 1) ? 1 : -1;
		//el.innerHTML = (curValue + step) > 0 ? curValue + step :"&nbsp";
		
		mygrid.cells4(ev.target).setValue(curValue-0+step);	
  	}	


}
var addEventAction=function(){
	var ids=getResourceIds();
	for(var i=0;i<ids.length;i++){
		for(var j=2;j<33;j++){
			add_evs(mygrid.cellAll(ids[i],j));
			fillColor();
		}
		
	}
	
	
}
function fillColor(){
	var ids=getResourceIds();

	for(var i=0;i<ids.length;i++){
		if(getCellValue(ids[i],0)!="")
			yearNum=getCellValue(ids[i],0);
				
	var month=getCellValue(ids[i],1);
	if(month==4||month==6||month==9||month==11){
		mygrid.cellAll(ids[i],32).disabled=true;
		mygrid.setCellTextStyle(ids[i],32,'background-color:#000;');		
	}else if(month==2&&isLeapyear($("overDate").value.substring(0,4)==""?yearNum:$("overDate").value.substring(0,4))){
		mygrid.cellAll(ids[i],31).disabled=true;
		mygrid.cellAll(ids[i],32).disabled=true;
		mygrid.setCellTextStyle(ids[i],31,'background-color:#000;');	
		mygrid.setCellTextStyle(ids[i],32,'background-color:#000;');			
	}else if(month==2&&!isLeapyear($("overDate").value.substring(0,4)==""?yearNum:$("overDate").value.substring(0,4))){
		mygrid.cellAll(ids[i],30).disabled=true;
		mygrid.cellAll(ids[i],31).disabled=true;
		mygrid.cellAll(ids[i],32).disabled=true;
		mygrid.setCellTextStyle(ids[i],30,'background-color:#000;');	
		mygrid.setCellTextStyle(ids[i],31,'background-color:#000;');	
		mygrid.setCellTextStyle(ids[i],32,'background-color:#000;');		
	}else{}		
}
}

function isLeapyear(year){
	var isLeapYear=false;
	if(year%4==0&&year%100!=0){
		isLeapYear=true;
	}else if(year%400==0){
		isLeapYear=true;
	}else{}
	return isLeapYear;
}
function doOnRowSelected(id){
	

	mygrid.setRowTextStyle(id,'background-color:#FFCC99;font-size:13px;');
      }


function getBroadCastDetailTable(){
	
	var func = function(xml){

		mygrid.loadXMLString(xml);
		        addEventAction();	
	}
	proPublishPlanDetail.getProPublishPlanDetailXML(planId,func);
}