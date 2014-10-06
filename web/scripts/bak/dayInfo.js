 

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
  
//������� 
function otherFill (){
	var Bt_selectAll = $("Bt_selectAll");
	Bt_selectAll.setAttribute("href","javascript:void 0");
	Bt_selectAll.onclick=selectAll;
}
  
//ȡ���·ݹ��м���
function getMonthLen(theYear, theMonth) {
   theMonth--;
   var oneDay = 1000 * 60 * 60 * 24;
   var thisMonth = new Date(theYear, theMonth, 1);
   var nextMonth = new Date(theYear, theMonth + 1, 1);
   var len = Math.ceil((nextMonth.getTime() - thisMonth.getTime())/oneDay);
   return len;
 } 

//��ʽ������
function getMonthDay(theYear, month) {
   var len = getMonthLen(theYear, month);
   var monthStrLength = month.toString().length;
   if (monthStrLength < 2){month = '0'+ month}
   var monthDay = theYear +'' + month +''+len;
   return monthDay;
 } 

//�����������  
function getNextMonthDay(theYear, lastMonth) {
   if(globalLastMonth < 12){
	   lastMonth++;
	   globalLastMonth++; 
   }
   var NextMonthDay = getMonthDay(theYear,lastMonth);
   return NextMonthDay;
 } 
 
//���Ի����ڱ�
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

//����������ڴ���
function clearMonthInfo() {
	var inputs = $("monthInfosBody").getElementsByTagName("input");
	inputs = $A(inputs);
	inputs.each(function(ip){
		ip.value="";
		}
	);
	//�����ܴ���Ϊ 0
	DWRUtil.setValue("totalBroTimes", "0");
}

//�ڹ����Դ����Ϣ��׷�ӹ��ʱ��
function saveOrderDayInfo(){
  var orderDayObj = orderDayInfo;
  var resDayObj = resourceDayInfo;
  //�������Ϣ
  orderDayObj.orderId = $("orderId").value;
  orderDayObj.orderDetailId = $("dtId").value;
  orderDayObj.dayStandardPrice =$("dtExecPrice").value;
  orderDayObj.dayRelIncome = 0;
  orderDayObj.resourceSpecific = $("dtResourceSpecificId").value;
  orderDayObj.isPublished = 0;
  orderDayObj.adlength = $("dtMatterLength").value;
  orderDayObj.version = 0;
  //��Դ����Ϣ
  resDayObj.carrierId = $("dtResourceInfoId").value;
  resDayObj.resourceId = $("dtResourceInfoId").value;
  
  var trs = $("monthInfosBody").getElementsByTagName("tr");
  var trnum = trs.length;
  

   
  for (var i = 0; i < trnum; i++) { 
  
      var values = trs[i].getElementsByTagName("input");

      for (var j = 1; j < values.length-2; j++) {
          if (j>0 && j<31){
              //��Դ����Ϣ
              resDayObj.id = values[j].getAttribute("resourceDayId");
			  resDayObj.publishDate = values[j].getAttribute("publishDate");
			  resDayObj.specific = values[j].getAttribute("specific")+ $("dtResourceSpecificId").value;
			  resDayObj.used = values[j].value * $("dtMatterLength").value;
			  resDayObj.version =2;
			  
			  //�������Ϣ
			  orderDayObj.id = values[j].getAttribute("adDayInfoId");
			  orderDayObj.adDayTimes = values[j].value;
			  orderDayObj.publishDate = resDayObj.publishDate;
			  orderDayObj.dayInfo = resDayObj;
			  //1������������Ϣͬʱ�������޸���Դ����Ϣ
			  //2������й������Ϣ��ţ������޸�
			  //3�����û�й������Ϣ��ţ����д�������������
			  //4���޸ĺ��������ͬʱ���Թ����Դ����Ϣ���д���

              //DayInfoManager.saveDayInfo(resDayObj);
              OrderDayInfoManager.saveOrderDayInfo(orderDayObj);
           }
      }


  } 

}


//�޸Ķ�����ϸ��ʼ���������
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


//�༭״̬
function readMonthInfo(orderDetail) {
    var orderDetailId =  orderDetail.id;
    var startDate  =     orderDetail.publishStartDate;
    var endDate  =       orderDetail.publishEndDate;
    var resourceId =     orderDetail.resourceInfoId;
    
    globalLastMonth  = endDate.toString().substring(4,6);
    
    //��������Ϣ�������Ӻ�ߵĲ���ʱ����Ҫ�õ���ߵ�ʱ����Դ
    var year = endDate.toString().substring(0,4);
    endDate = getMonthDay(year,globalLastMonth);
    
    //alert("startDate: "+ startDate);
    //alert("endDate: "+ endDate);
    //alert("resourceId: "+resourceId);
    //alert("orderDetailId: "+orderDetailId);
 	OrderDayInfoManager.getMonthInfosByParameter(fillMonthInfos,orderDetailId,startDate,endDate,resourceId);
}

function fillMonthInfos(monthInfoMap) {
    //�ܲ�������
    DWRUtil.setValue("dtSumTimes", "0");
    
	DWRUtil.removeAllRows("monthInfosBody");
	DWRUtil.addRows("monthInfosBody", monthInfoMap,cellFunctionsDayInfo);
}

//����һ����
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

//�ָ�
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
  	function(monthInfoMap) { return monthInfoMap.month+'��' },
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

//���ñ������Ϣ
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

//���ñ���´���
function getMonthTims(data){
	var input  = document.createElement("input");
	input.style.cssText = "width:100%;border:none;text-align:center;";
    //input.setAttribute("id","monthTims");
    input.value = data.monthTims;
    if (input.value == 0) input.value='';
    
    //�ܲ�������
     var totalBroTimes = $("dtSumTimes").value*1 + data.monthTims;
     DWRUtil.setValue("dtSumTimes", totalBroTimes);
	return input;
}
//���ñ���¼۸�
function getMonthPrice(data){
	var input  = document.createElement("input");
	input.style.cssText = "width:100%;border:none;text-align:center;";
    input.value = data.monthTims * $("dtExecPrice").value ;
    if (input.value == 0) input.value='';
	return input;
}


//////////////////////////////////////////������̲���///////////////////////////////////////
//�����¼�
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

//��������¼�
function keyDown(event){
	var e = event || window.event;
	alert(e.keyCode);
	//if(e.keyCode==45){initMonthInfo()}
	//if(e.keyCode==46){delTr()}
}


//������۽�
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
		//�޸��´���
		resetMonthTims(rowIndex,toSumTimes);
		//�޸��ܴ���
        totalBroTimes = $("dtSumTimes").value*1 + toSumTimes;
        DWRUtil.setValue("dtSumTimes", totalBroTimes);
    }		
	
	setStarEndDate();
	
	document.oncontextmenu=function stop(){return false;};
}

//�޸��ܴ���
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


//�����´����������۸�
function resetMonthTims (rowIndex,value) {
	var inputs = $("monthInfosBody").getElementsByTagName("input");
	var i = rowIndex-1
    inputs[rowIndex*32+2*i].value = inputs[rowIndex*32+2*i].value*1 + value*1 ;
    if(inputs[rowIndex*32+2*i].value == 0 ) inputs[rowIndex*32+2*i].value='';
    inputs[rowIndex*33+1*i].value = inputs[rowIndex*32+2*i].value * $("dtExecPrice").value ;
    if(inputs[rowIndex*33+1*i].value == 0) inputs[rowIndex*33+1*i].value='';
}


//�ƶ�����
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
    


//ȫѡ��ť
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
