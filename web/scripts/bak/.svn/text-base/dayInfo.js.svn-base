 

  today=[]; 
  var dftDate = new Date ();
  
  today[0] = dftDate.getFullYear();
  today[1] = dftDate.getMonth()+1;
  today[2] = dftDate.getDate();

  var monthStrLength = today[1].toString().length;
  var dateStrLength = today[2].toString().length;
  if (monthStrLength < 2){today[1] = '0'+ today[1]}
  if (dateStrLength < 2) {today[2] = '0'+ today[2]}
    
  theYear  =  today[0];
  theMonth =  today[1];
  theDay   =  today[2];
  
  globalLastMonth =theMonth;
  
  curDate = theYear +''+  theMonth +''+theDay;
  
//动作填充 
function otherFill (){
	var Bt_selectAll = $("Bt_selectAll");
	Bt_selectAll.setAttribute("href","javascript:void 0");
	Bt_selectAll.onclick=selectAll;
}
  
//取得月份共有几天
function getMonthLen(theYear, theMonth) {
   theMonth--;
   var oneDay = 1000 * 60 * 60 * 24;
   var thisMonth = new Date(theYear, theMonth, 1);
   var nextMonth = new Date(theYear, theMonth + 1, 1);
   var len = Math.ceil((nextMonth.getTime() - thisMonth.getTime())/oneDay);
   return len;
 } 

//格式化日期
function getMonthDay(theYear, month) {
   var len = getMonthLen(theYear, month);
   var monthStrLength = month.toString().length;
   if (monthStrLength < 2){month = '0'+ month}
   var monthDay = theYear +'' + month +''+len;
   return monthDay;
 } 

//获得下月日期  
function getNextMonthDay(theYear, lastMonth) {
   if(globalLastMonth < 12){
	   lastMonth++;
	   globalLastMonth++; 
   }
   var NextMonthDay = getMonthDay(theYear,lastMonth);
   return NextMonthDay;
 } 
 
//初试化排期表
function initMonthInfo() {
    var orderDetailId = 0;
    var startDate     = curDate;
    var endDate       = curDate;
    var resourceId    = $("dtResourceInfoId").value; 
    
    var nextMonth = theMonth;
    
    if(today[1] < 11) nextMonth = today[1]+2;
    if(today[1] == 11) nextMonth = today[1]+1;
    if(today[1] == 12) nextMonth = today[1];
    
    endDate = getMonthDay(theYear,nextMonth)

    globalLastMonth = nextMonth;
    //alert("startDate: "+ startDate);
    //alert("endDate: "+ endDate);
    //alert("resourceId: "+resourceId);
    OrderDayInfoManager.getMonthInfosByParameter(fillMonthInfos,orderDetailId,startDate,endDate,resourceId);
}

//清除界面排期次数
function clearMonthInfo() {
	var inputs = $("monthInfosBody").getElementsByTagName("input");
	inputs = $A(inputs);
	inputs.each(function(ip){
		ip.value="";
		}
	);
	//设置总次数为 0
	DWRUtil.setValue("totalBroTimes", "0");
}

//在广告资源日信息中追加广告时间
function saveOrderDayInfo(){
  var orderDayObj = orderDayInfo;
  var resDayObj = resourceDayInfo;
  //广告日信息
  orderDayObj.orderId = $("orderId").value;
  orderDayObj.orderDetailId = $("dtId").value;
  orderDayObj.dayStandardPrice =$("dtExecPrice").value;
  orderDayObj.dayRelIncome = 0;
  orderDayObj.resourceSpecific = $("dtResourceSpecificId").value;
  orderDayObj.isPublished = 0;
  orderDayObj.adlength = $("dtMatterLength").value;
  orderDayObj.version = 0;
  //资源日信息
  resDayObj.carrierId = $("dtResourceInfoId").value;
  resDayObj.resourceId = $("dtResourceInfoId").value;
  
  var trs = $("monthInfosBody").getElementsByTagName("tr");
  var trnum = trs.length;
  

   
  for (var i = 0; i < trnum; i++) { 
  
      var values = trs[i].getElementsByTagName("input");

      for (var j = 1; j < values.length-2; j++) {
          if (j>0 && j<31){
              //资源日信息
              resDayObj.id = values[j].getAttribute("resourceDayId");
			  resDayObj.publishDate = values[j].getAttribute("publishDate");
			  resDayObj.specific = values[j].getAttribute("specific")+ $("dtResourceSpecificId").value;
			  resDayObj.used = values[j].value * $("dtMatterLength").value;
			  resDayObj.version =2;
			  
			  //广告日信息
			  orderDayObj.id = values[j].getAttribute("adDayInfoId");
			  orderDayObj.adDayTimes = values[j].value;
			  orderDayObj.publishDate = resDayObj.publishDate;
			  orderDayObj.dayInfo = resDayObj;
			  //1、保存广告日信息同时，联动修改资源日信息
			  //2、如果有广告日信息编号，进入修改
			  //3、如果没有广告日信息编号，单有次数，进入新添
			  //4、修改和新添广告的同时，对广告资源日信息进行处理

              //DayInfoManager.saveDayInfo(resDayObj);
              OrderDayInfoManager.saveOrderDayInfo(orderDayObj);
           }
      }


  } 

}


//修改订单名细开始与结束日期
function setStarEndDate(){

        var publishStartDate = curDate*1 + 10000;
        var publishEndDate = 0;
        
        var trs = $("monthInfosBody").getElementsByTagName("tr");
        var trnum = trs.length;  
        
		 for (var i = 0; i < trnum; i++) { 
		      var values = trs[i].getElementsByTagName("input");
		      for (var j = 1; j < values.length-2; j++) {   
		           var s = values[j].getAttribute("publishDate");
		           if (s < publishStartDate && values[j].value > 0) publishStartDate = s;
		           if (s > publishEndDate && values[j].value > 0) publishEndDate = s;
		      }
		  }     
		 DWRUtil.setValue("dtPublishStartDate", publishStartDate);
		 DWRUtil.setValue("dtPublishEndDate", publishEndDate);
}


//编辑状态
function readMonthInfo(orderDetail) {
    var orderDetailId =  orderDetail.id;
    var startDate  =     orderDetail.publishStartDate;
    var endDate  =       orderDetail.publishEndDate;
    var resourceId =     orderDetail.resourceInfoId;
    
    globalLastMonth  = endDate.toString().substring(4,6);
    
    //读整月信息，在增加后边的播出时，需要用到后边的时间资源
    var year = endDate.toString().substring(0,4);
    endDate = getMonthDay(year,globalLastMonth);
    
    //alert("startDate: "+ startDate);
    //alert("endDate: "+ endDate);
    //alert("resourceId: "+resourceId);
    //alert("orderDetailId: "+orderDetailId);
 	OrderDayInfoManager.getMonthInfosByParameter(fillMonthInfos,orderDetailId,startDate,endDate,resourceId);
}

function fillMonthInfos(monthInfoMap) {
    //总播出次数
    DWRUtil.setValue("dtSumTimes", "0");
    
	DWRUtil.removeAllRows("monthInfosBody");
	DWRUtil.addRows("monthInfosBody", monthInfoMap,cellFunctionsDayInfo);
}

//增加一个月
function addNextMonth(){
    var orderDetailId = $("dtId").value;
    var startDate     = $("dtPublishStartDate").value;
    var endDate       = $("dtPublishEndDate").value;
    var resourceId    = $("dtResourceInfoId").value;
    
    if (globalLastMonth < 13){
	   endDate = getNextMonthDay(theYear,globalLastMonth);

    //alert("startDate: "+ startDate);
    //alert("endDate: "+ endDate);
    //alert("resourceId: "+resourceId);
    //alert("orderDetailId: "+orderDetailId);
    
	   OrderDayInfoManager.getMonthInfosByParameter(fillMonthInfos,orderDetailId,startDate,endDate,resourceId);
	} 	
}

//恢复
function resumeMonthInfo(){
    var orderDetailId = $("dtId").value;
    var startDate     = $("dtPublishStartDate").value;
    var endDate       = $("dtPublishEndDate").value;
    var resourceId    = $("dtResourceInfoId").value; 
    globalLastMonth  = endDate.toString().substring(4,6);
	OrderDayInfoManager.getMonthInfosByParameter(fillMonthInfos,orderDetailId,startDate,endDate,resourceId);
}

var cellFunctionsDayInfo = [

	function(monthInfoMap) { return "<input style=\"width:13px;\" type=\"checkbox\" name=\"checkbox\" value=\'"+ monthInfoMap.monthStr +"'>" },
  	function(monthInfoMap) { return monthInfoMap.month+'月' },
    function(monthInfoMap) { return setTbCell(monthInfoMap.day1)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day2)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day3)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day4)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day5)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day6)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day7)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day8)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day9)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day10)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day11)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day12)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day13)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day14)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day15)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day16)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day17)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day18)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day19)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day20)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day21)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day22)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day23)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day24)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day25)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day26)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day27)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day28)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day29)},
    function(monthInfoMap) { return setTbCell(monthInfoMap.day30)},  
    function(monthInfoMap) { return setTbCell(monthInfoMap.day31)},
    function(monthInfoMap) { return getMonthTims(monthInfoMap) },
    function(monthInfoMap) { return getMonthPrice(monthInfoMap) }               
];

//设置表格日信息
function setTbCell(data){
	var input  = document.createElement("input");
 	if(data.adTimes == 0) data.adTimes='';
    input.style.cssText = "width:100%;border:none;text-align:center;cursor:hand;";

    input.setAttribute("publishDate",data.dayDate); 
    input.setAttribute("resourceDayId",data.resourceDayId); 
    input.setAttribute("specific",data.rsSpecific);
    input.setAttribute("adDayInfoId",data.adDayInfoId);    
    
    input.value = data.adTimes;

    input.onmouseover = function(){    
		                DWRUtil.setValue("dayTotalTime", data.rsTotalTime);
					    DWRUtil.setValue("dayUsedTime", data.rsUsedTime);
	    				}
    input.onmousedown = readyedit;

   // input.onkeydown = gonext;
   // input.onfocus=stopListen;
   // input.onblur=beginListen;

	return input;
}

//设置表格月次数
function getMonthTims(data){
	var input  = document.createElement("input");
	input.style.cssText = "width:100%;border:none;text-align:center;";
    //input.setAttribute("id","monthTims");
    input.value = data.monthTims;
    if (input.value == 0) input.value='';
    
    //总播出次数
     var totalBroTimes = $("dtSumTimes").value*1 + data.monthTims;
     DWRUtil.setValue("dtSumTimes", totalBroTimes);
	return input;
}
//设置表格月价格
function getMonthPrice(data){
	var input  = document.createElement("input");
	input.style.cssText = "width:100%;border:none;text-align:center;";
    input.value = data.monthTims * $("dtExecPrice").value ;
    if (input.value == 0) input.value='';
	return input;
}


//////////////////////////////////////////处理键盘操作///////////////////////////////////////
//键盘事件
function beginListen(){
	if(document.addEventListener){
		document.addEventListener("keydown",keyDown,true);
	}else{
		document.attachEvent("onkeydown",keyDown);
	}
}
function stopListen(){
	if(document.removeEventListener){
		document.removeEventListener("keydown",keyDown,true);
	}else{
		document.detachEvent("onkeydown",keyDown);
	}
}

//处理键盘事件
function keyDown(event){
	var e = event || window.event;
	alert(e.keyCode);
	//if(e.keyCode==45){initMonthInfo()}
	//if(e.keyCode==46){delTr()}
}


//鼠标点击聚焦
function readyedit(event){
	var e = event || window.event;
	var obj = Event.element(e);
	var toSumTimes = 0 ;
	
	if(e.button == 0 || e.button == 1){ obj.value = obj.value*1+1; toSumTimes = 1;}
	if(e.button == 2 && obj.value > 0){obj.value = obj.value*1-1;  toSumTimes = -1;}
	
    if(obj.value == 0) {obj.value =''}

	//Field.select(obj);

    if(toSumTimes != 0){
		var rowIndex = obj.parentNode.parentNode.rowIndex;
		//修改月次数
		resetMonthTims(rowIndex,toSumTimes);
		//修改总次数
        totalBroTimes = $("dtSumTimes").value*1 + toSumTimes;
        DWRUtil.setValue("dtSumTimes", totalBroTimes);
    }		
	
	setStarEndDate();
	
	document.oncontextmenu=function stop(){return false;};
}

//修改总次数
function resetTotalBroTimes(){
  var trs = $("monthInfosBody").getElementsByTagName("tr");
  var trnum = trs.length;
  var totalBroTimes = 0;
  for (var i = 0; i < trnum; i++) { 
       var values = trs[i].getElementsByTagName("input");
       var times =values[(i+1)*32+2*i].value;
       totalBroTimes = totalBroTimes*1 + times*1;
       DWRUtil.setValue("dtSumTimes", totalBroTimes);
  }
}


//计算月次数及基本价格
function resetMonthTims (rowIndex,value) {
	var inputs = $("monthInfosBody").getElementsByTagName("input");
	var i = rowIndex-1
    inputs[rowIndex*32+2*i].value = inputs[rowIndex*32+2*i].value*1 + value*1 ;
    if(inputs[rowIndex*32+2*i].value == 0 ) inputs[rowIndex*32+2*i].value='';
    inputs[rowIndex*33+1*i].value = inputs[rowIndex*32+2*i].value * $("dtExecPrice").value ;
    if(inputs[rowIndex*33+1*i].value == 0) inputs[rowIndex*33+1*i].value='';
}


//移动焦点
function gonext(event) {
	var e = event || window.event;
	var obj = e.target || e.srcElement;
	if(e.keyCode==13){
		var nextobj = obj.parentNode.parentNode.nextSibling;
		var objindex = obj.parentNode.cellIndex;
		if(nextobj){
			if (nextobj.nodeType==3){
				var nextinput = nextobj.nextSibling.getElementsByTagName("input")[objindex];
				nextinput.focus();
				nextinput.select();
			}else{
				var nextinput = nextobj.getElementsByTagName("input")[objindex];
				nextinput.focus();
				nextinput.select();
			}
		}
	}
}


//******************************
//  define obj
//******************************
 
var resourceDayInfo = 
	{
	id:null,
    carrierId:null,
    resourceId:null,
    resourceType:null,
    propertiyTime:null,
    workspanId:null,
    publishDate:19990101,
    specific:"",
    total:0,
    used:0,
    version:0
  };
	
//******************************
//  orderDayInfo obj
//******************************
 
var orderDayInfo = 
	{
	orderId:null,
    orderDetailId:null,
    publishDate:19990101,
    adlength:0,
    dayStandardPrice:0,
    dayRelIncome:0,
    adDayTimes:0,
    resourceSpecific:"",
    isPublished:0,
    id:null,
    dayInfo:resourceDayInfo,
    version:0
  };    
    


//全选按钮
function selectAll() {
	var checkboxs = document.getElementsByName("checkbox");
	var mark = true;
	checkboxs = $A(checkboxs);
	checkboxs.each(function(chb){
		if (chb.checked==false){mark = false}
		}
	);

	if (mark){
		checkboxs.each(function(chb){
			chb.checked = false;
			}
		);
	}else{
		checkboxs.each(function(chb){
			chb.checked = true;
			}
		);
	}
}
