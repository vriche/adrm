var ctxPath;
var payMent = new PayMent();
var order = new Order();
var price=new Price();
var orderDetail=new OrderDetail();
var user = new User();
var carrier = new Carrier();
var orderDayInfo = new OrderDayInfo();
var resource=new Resource();
var industry=new Industry();
var customerCarrierRel = new CustomerCarrierRel();
var matter = new Matter();
var customer = new Customer();
var resDayInfo = new DayInfo();
var workspan= new Workspan();
var config_serviceDate;
var mygrid;
var userId;
var colLength;
var objsList;
var orderCode=null;
var isNewOrder=true;
var isDisabled=false;
var isChecked="";
var orderDetails=new Array();
var isSaveOrderDayInfo = true;
callOnLoad(init);


function init(){

        winHeight = self.innerHeight*0.93; 
	winWidth = self.innerWidth*0.98;
	ctxPath = getCtxPath();
	document.oncontextmenu=function stop(){return false;};
	
	
	userName =  _app_params.user.username;
	

	
//	userName = $("config_username").value;

	var funu=function(id){
		userId=id;
	}
	user.getCurUserId(userName,funu);
	customerId = getParamFromUrl(document.location.href,"id");
	orderId = getParamFromUrl(document.location.href,"orderId");
//	orgId = getParamFromUrl(document.location.href,"orgId");
	//userId = getParamFromUrl(document.location.href,"userId");
	
	channelModelParam = _app_params.sysParam.channelModelParam;
	config_serviceDate = _app_params.serviceDate.def;

    getDate();
    
	setCarrierPara(carrier);
	setMatterPara(matter);
	
	customerCarrierRel.getCustomerCarrierRelCount(customerCarrierRel.obj,BackFun);

	function BackFun(objs){
		if(objs.length==0) objs[0]=1;
		var lengths=Math.round(60/objs[0]);
		
 		    customerCarrierRel.heads = "品牌,版本,长度,";
 		    customerCarrierRel.widths = "10,15,5,";
 		    customerCarrierRel.colTypes ="co,co,co,";
 		    customerCarrierRel.colAlign ="left,left,center,";
 		    customerCarrierRel.colSorting ="str,str,int,";
 		    customerCarrierRel.attachFooter ="剩余时长：,&nbsp;,&nbsp;,"; 
 		    customerCarrierRel.attachFooter2 = new Array();
                   var stylecss ='text-align:left;'
                    var stylecss2 ='text-align:center;'

 		    customerCarrierRel.attachFooter2.push(stylecss);
 		    customerCarrierRel.attachFooter2.push(stylecss);
 		    customerCarrierRel.attachFooter2.push(stylecss);
 		    for(var i = 0;i<objs[0];i++){
 		    	customerCarrierRel.heads +="";
 		    	customerCarrierRel.widths +=lengths;
 		    	customerCarrierRel.colTypes +="ro";
 		    	customerCarrierRel.colAlign +="center";
 		    	customerCarrierRel.colSorting +="int";
 		    	customerCarrierRel.attachFooter +="<div id='month"+ (i) +"'/>";
 		    	customerCarrierRel.attachFooter2.push(stylecss2);
 		    	
 		    	if(i< objs[0]-1){
 		    		 customerCarrierRel.heads +=","
 		    		 customerCarrierRel.widths +=","
 		    		 customerCarrierRel.colTypes +=","
 		    		 customerCarrierRel.colAlign +=","
 		    		 customerCarrierRel.colSorting +=","
 		    		 customerCarrierRel.attachFooter +=","
 		    		}
 		    }
 		    var num="";
 		customerCarrierRel.heads += ",次数,总计"
 		customerCarrierRel.widths += ",5,5";
 		
 		for(var i =3;i<objs[0]-0+3;i++){
 			num+="c"+i+"+";
 		}
 		num=num.substring(0,num.length-1);
 		var cc=objs[0]-0+3;		
 		customerCarrierRel.colTypes +=",ed[="+num+"],ed[=c2*c"+cc+"]";

 		customerCarrierRel.colAlign +=",center,center";
 		customerCarrierRel.colSorting +="int,int";
 		
		initGrid();     
	}
	    initToolbar();			
}
function getAllValueById(){
	var callBackFun=function(obj){
	   if(obj.length>=1){
		publishDate = obj[0].startDate;
		isChecked   = obj[0].memo;
		payMoney    = obj[0].payMoney;
		orderCode   = obj[0].carrierName;
		if(publishDate!=null) $("orderDate").value = publishDate==0?history.back():getFormatDay(publishDate,'y/m/d');
		if(publishDate==0) return false;	
		if(payMoney!=null)    $("incomeMoney").value = payMoney;
		$("orderDate").disabled=true;
		if(isChecked=="通过"||isChecked=="未审批") {
			$("incomeMoney").disabled=true;
		}else{
			$("incomeMoney").disabled=false;
		}
		customerCarrierRel.obj.id=null;
		selectCarriers();
	   }
		
	}
	customerCarrierRel.obj.id=orderId;
	customerCarrierRel.getDetailsByOrderId(customerCarrierRel.obj,callBackFun);	
}
function getNewOrderDate(){
	var callBackFun=function(obj){
	    if(obj.length!=0){
				var maxDate=obj[obj.length-1].startDate;
				var year=getDayPar(maxDate+"",'y');
				var day=getDayPar(maxDate+"",'d');
				var month=getDayPar(maxDate+"",'m');
		
				if(day==30&&(month==4||month==6||month==9||month==11)){
					var months=month-0+1;
					if(months<10) months="0"+months
					nextDate=year+months+"01";
				}else if(day==31&&(month==1||month==3||month==5||month==7||month==8||month==10)){			
					var months=month-0+1;
					if(months<10) months="0"+months
					nextDate=year+months+"01";
				}else if(day==31&&month==12){
					nextDate=year-0+1+"0101";
							
				}else if(day==28&&month==2&&!isLeapyear(year)){
					nextDate=year+"0301";
					
				}else if(day==29&&month==2&&isLeapyear(year)){
					nextDate=year+"0301";		
				}else{
					nextDate=maxDate+1
				}
				$("orderDate").value = getFormatDay(nextDate,'y/m/d');
	  }else{
			$("orderDate").value = getFormatDay(config_serviceDate,'y/m/d');
	  }
			$("incomeMoney").value="";
			selectCarriers();
	}
	customerCarrierRel.obj.customerId=customerId;
	customerCarrierRel.getDetailsByOrderId(customerCarrierRel.obj,callBackFun);	
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
function selectCarriers(){
	function callBack(){
		selectEventFill();
	    if($("carrier").value=="") {alert("缺少载体,请向我台申请！"); return false;}
	    getCustomerCarrierRelXML();
	}
	if(customerId==null) customerId=0;
	customerCarrierRel.obj.carrierId=null;
	customerCarrierRel.obj.customerId=customerId;
	customerCarrierRel.obj.startDate=getFormatDay($("orderDate").value,'ymd');

	var callBackFun=function(obj){
		for(var i=0;i<obj.length;i++){
			if(obj[i].startDate==customerCarrierRel.obj.startDate){
				alert("请回到主页面进入已签订单");
				$("orderDate").value=getFormatDay(nextDate,'y/m/d');
				customerCarrierRel.obj.startDate=nextDate;
				selectCarriers();
				return false;
			}
		}
		customerCarrierRel.getCarrierXML($("carrierDiv"),"carrier",customerCarrierRel.obj,callBack);			
	}
	if(orderId==null){
		customerCarrierRel.getDetailsByOrderId(customerCarrierRel.obj,callBackFun);
	}else{
		customerCarrierRel.getCarrierXML($("carrierDiv"),"carrier",customerCarrierRel.obj,callBack);
	}
}
function calculateFooterValues(objs){
        for(var i=3;i<colLength+3;i++){
        	var el = $("month"+(i-3));
        	if(isUndefined(sumtimes)) sumtimes=0;
        	el.innerHTML = objs[i-3].length-sumtimes;
        }
        return true;
}
function selectEventFill(){
	var carrier=$("carrier");
	carrier.onchange=getCustomerCarrierRelXML;

	var orderDate=$("orderDate");
	orderDate.onchange=selectCarriers;
}

function getDate(){
	
	Calendar.setup({
		inputField  : "orderDate",	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "orderDate"	// id of the button
	});
	
	$("orderDate").value = getFormatDay(config_serviceDate,'y/m/d');
}
 function getServiceDate(){
 	var fuc = function(d){
 		$("config_serviceDate").value = d;
 	}
 	DWREngine.setAsync(false);
 	DateUtil.getServiceDate(fuc);
 	DWREngine.setAsync(true);
 }
function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}
function setMatterPara(obj){
	 obj.className  = "matter";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}
function initGrid(){
	var imagePath = ctxPath + "image/grid/";

	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath(imagePath);
	mygrid.setHeader(customerCarrierRel.heads);
	mygrid.setInitWidthsP(customerCarrierRel.widths);
	mygrid.setColTypes(customerCarrierRel.colTypes);
	mygrid.setColAlign(customerCarrierRel.colAlign);
	mygrid.setColSorting(customerCarrierRel.colSorting);
	makeMatterSelectItem(null,null);
	mygrid.enableAlterCss("even","uneven"); 
    mygrid.setMultiLine(false);
	mygrid.setEditable(true);	
    mygrid.setSkin("modern2");
	mygrid.init();
	mygrid.attachFooter(customerCarrierRel.attachFooter,customerCarrierRel.attachFooter2);			
	if(orderId!=null){
		isNewOrder=false;
		getAllValueById();
	}else{
		getNewOrderDate();
	}
}

var addEvent = function(el, evname, func) {
	if (el.attachEvent) { // IE
		el.attachEvent("on" + evname, func);
	} else if (el.addEventListener) { // Gecko / W3C
		el.addEventListener(evname, func, true);
	} else {
		el["on" + evname] = func;
	}
};
var add_evs = function(el) {
		addEvent(el, "mousedown", dayMouseDown);
};
var dayMouseDown = function(ev) {
	var el = ev.currentTarget;
		cellClick(el,ev);
	return stopEvent(ev);	
};
var stopEvent = function(ev) {
		ev.preventDefault();
		ev.stopPropagation();
	return false;
};
var cellClick = function(el, ev) {


    
	var curValue = (el.innerHTML >0) ? el.innerHTML*1 : 0;
    
   
	var K =  (ev.type == "keydown" || ev.type == "keypress")? ev.keyCode : ev.which;	

   //鼠标
       
  	if(ev.type == "mousedown"){
		if(K == 2 || (K == 3 && curValue == 0)) return false;
		var step = (K == 1) ? 1 : -1;
		
		if(el.parentNode.childNodes[2].combo_value==null){alert('请先设置广告长度!');return false;}
		 
	    if(!isDisabled){
			if(curValue-0+step==0){
				mygrid.cells4(ev.target).setValue("0");
			}else{
				mygrid.cells4(ev.target).setValue(curValue-0+step);
			}
	    }
	   
		var callBack=function(objs){
	        for(var i=3;i<colLength+3;i++){
	        	var sumtimes=0;
	        	for(var j=0;j<mygrid.getRowsNum();j++){
	       			sumtimes+=mygrid.cells2(j,i).getValue()==''?0:(mygrid.cells2(j,i).getValue()-0)*mygrid.cells2(j,2).getValue();
	        	}
	        	var el = $("month"+(i-3));
	        	if(objs.length==0) return false;
	        	if(objs[i-3].length-sumtimes<0) {
	        		alert("超时！该资源段只允许使用"+objs[i-3].length+"秒");
	        		if(curValue==0){
						mygrid.cells4(ev.target).setValue("");
					}else{
						mygrid.cells4(ev.target).setValue(curValue);
					}
	        	}else{
	        		el.innerHTML = objs[i-3].length-sumtimes;
	        	}
	        }
     	}	
	customerCarrierRel.getCustomerCarrierRels(customerCarrierRel.obj,callBack);
}


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
var addEventAction=function(size){
	var ids=getResourceIds();
	for(var i=0;i<ids.length;i++){
		for(var j=3;j<size+3;j++){
			add_evs(mygrid.cellAll(ids[i],j));
		}	
	}
}

function getCellValue(rowId,col){ 
	return mygrid.cells(rowId,col).getValue();
}
function initToolbar(){
	var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml" ;
	var aToolBar1=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo"); 
	aToolBar1.setOnClickHandler(onButtonClick);
	aToolBar1.loadXML(toolbarDataPath,callBack);
	 
	function callBack(){
		aToolBar1.hideButtons(); 
        aToolBar1.showButtons("1_new,11_check,3_save");
        aToolBar1.showButtons("div_1,div_11,div_3");  
	}
	aToolBar1.showBar();  
}
function cancelChecks(){
	document.location.href="orderIndex.html?id="+customerId;
}
function btnAddRow(){	
	var rows = mygrid.getRowsNum() + 1;
	mygrid.addRow((new Date()).valueOf(),[],mygrid.getRowsNum()+1);
	addEventActionMatter();
	addEventAction(colLength);
}
function onButtonClick(itemId,itemValue){
	if(!isDisabled){
		if(itemId=='1_new') btnAddRow();
		if(itemId=='11_check') cancelChecks(); 
		if(itemId=='3_save') btnSaveRow();
	}
}
function btnSaveRow(){
			customerCarrierRel.reset();
			customerCarrierRel.obj.id=orderId;
			customerCarrierRel.getDetailsByOrderId(customerCarrierRel.obj,callBackFun);	
			var callBackFun=function(obj){
				if(obj.length>=1) payMoney = obj[0].payMoney;
			}
	
			var saveOrderFun=function(objs){
				order.obj.id=objs.id;
				if(objs.orderCode!=null)
					order.obj.orderCode=objs.orderCode;

				ids=getResourceIds();
				isDisabled=true;
				makeElementsDisabled(isDisabled);
				var totalSize=ids.length*colLength;
				var currentPercent=0;
				for(var i=0;i<ids.length;i++){
				    for(var j=3;j<colLength-0+3;j++){
				    	currentPercent++;	startProgress(currentPercent,totalSize);		
						if(mygrid.cells2(i,j).getValue()!=""){
								orderDetail.reset();
								orderDetail.obj.resourceInfoId=objsList[j-3].resourceId;
								orderDetail.obj.matterId = ids[i];
								orderDetail.obj.orderId = order.obj.id;
								orderDetail.obj.publishStartDate = getFormatDay($("orderDate").value,'ymd');
								orderDetail.obj.id=orderDetail.getOrderDetailId(orderDetail.obj);
			
								if(orderDetail.obj.id!=null) {
									orderDetail.obj.sumTimes=orderDetail.getSumTimesByOrderDetailId(orderDetail.obj.id);
									if(orderDetail.obj.sumTimes==getCellValue(ids[i],j)&&$("incomeMoney").value==payMoney) continue;
									
									orderDayInfo.obj.id=orderDetail.getOrderDayInfoId(orderDetail.obj.id);
									if(orderDayInfo.obj.id==null&&getCellValue(ids[i],j)==0&&$("incomeMoney").value==payMoney) continue;
								}else{
									if(getCellValue(ids[i],j)==0&&$("incomeMoney").value==payMoney) continue;
									orderDayInfo.obj.id=null;
									orderDetail.obj.sumTimes=0;
								}
												
			                	btnSaveRowDetail(ids[i],j);
	                	} 
				    }  
//					matter.reset();		
//					matter.obj.name = getCellValue(ids[i],0);
//					matter.obj.edit = getCellValue(ids[i],1);
//					matter.obj.length = getCellValue(ids[i],2); 
//					matter.obj.customerId =  customerId;
//					var obj =  matter.getMatterByNameVerLen(matter.obj);
//				    mygrid.setRowId(i,obj.id);
				}
				
				payMent.saveContractPaymentByOrder(order.obj.contractId,order.obj.id,order.obj.customerId,$("incomeMoney").value,isNewOrder,null,getDayPar(config_serviceDate,'y')); 
				$('progressBar').style.display = 'none';

				isDisabled=false;
				makeElementsDisabled(isDisabled);
			}
			var isPass=isCheckPass();
			if(!isPass) return false;
			   order.obj.customer = (new Customer()).obj;
			   order.obj.isCkecked=0;
			   order.obj.customerId=customerId;
			   order.obj.categoryId= 18;
			   order.obj.paymentId=0;
			   order.obj.version= getFormatDay(config_serviceDate,'y');
			   order.obj.createBy = userId;
			   order.obj.modifyBy = userId;
			   order.obj.orderMeno="";
			   order.obj.contractId = 0;		 
			   order.obj.userId=userId;
			   order.obj.publishMemo=1;

			   var callBacks = function(obj){
			   	 order.obj.customer.customerName=obj.customerName;
			   	 order.obj.customer.customerCategoryId=obj.customerCategoryId;
			   	 if(orderId!=null)  order.obj.id=orderId;
			   	 if(orderCode!=null) order.obj.orderCode=orderCode;
			   	 order.saveOrderReturnObj(order.obj,saveOrderFun);
			   }
			   customer.getCustomerOne(order.obj.customerId,callBacks);	
}
function makeElementsDisabled(isDisabled){
	if(isDisabled){
		$("carrier").disabled=true;
		$("orderDate").disabled=true;
		$("incomeMoney").disabled=true;
	}else{
		$("carrier").disabled=false;
		$("orderDate").disabled=false;
		$("incomeMoney").disabled=false;
	}		
}
function isCheckPass(){
	if($("carrier").value=="") {alert("缺少载体,请向我台申请！"); return false;}
	if($("orderDate").value=="") {alert("播出日期不能为空！"); return false;}
	if(getFormatDay($("orderDate").value,'ymd')<config_serviceDate) {alert("播出日期不能早于今天！"); return false;}
	if($("incomeMoney").value=="") {alert("应付金额不能为空！"); return false;}
	if(isNaN($("incomeMoney").value)) {alert("应付金额只能是数字！"); return false;}
	if(isChecked=="未审批") {alert("订单处于审核状态中,不允许编辑！");return false;}
	if(isChecked=="通过") {alert("订单审核状态为 通过,不允许编辑！");return false;}
	return true;	
}
function btnSaveRowDetail(rowId,col){
	//orderDetail.obj.id=mygrid.getCellId(rowId,col);


		orderDetail.obj.isCkecked=0;
	   	orderDetail.obj.version = getDayPar(config_serviceDate,'y'); 
        orderDetail.obj.orderDayInfos = saveOrderDayInfo(rowId,col);
	
        //orderDetail.obj.orderDayInfosBak = saveOrderDayInfo(rowId,col);
        getOrderDetailObj(rowId,col);
        
        orderDetail.obj.order = (new Order()).obj;
        orderDetail.obj.order.contractId = order.obj.contractId;
        orderDetail.obj.isSaveOrderDayInfo = isSaveOrderDayInfo;
        
	
	//var saveOrderDetailFun = function(id){	

	//}
	//orderDetail.saveOrderDetail(orderDetail.obj,saveOrderDetailFun);
		//alert(orderDetail.obj.orderDayInfos[0].adDayTimes);
		//orderDetails.push(orderDetail.obj);
		orderDetail.saveOrderDetails(orderDetail.obj);
	//if(isPass)

	//mygrid.setCellId(rowId,col,orderDetailId);
		
}

function getOrderDetailObj(rowId,col){

	//var parentId = $("parentId").value;
	var startDate = getFormatDay($("orderDate").value,'ymd');
	var endDate =   getFormatDay($("orderDate").value,'ymd');
        var appRate =  0;
        var ageRate =  0;
	var favourRate =  0;


	//DWRUtil.getValues(orderDetail.obj);
	orderDetail.obj.orderId = order.obj.id;
	
	orderDetail.obj.publishStartDate =  startDate;
	orderDetail.obj.publishEndDate =  endDate;	
	orderDetail.obj.resourceType = 1;
	orderDetail.obj.publishMemo ="";
	orderDetail.obj.isSpaceAdver = false;
	orderDetail.obj.createBy = userId;
	orderDetail.obj.modifyBy = userId;
	orderDetail.obj.execPrice = 0;
	//orderDetail.obj.sysPrice = 0;
	orderDetail.obj.moneyBalance = 0;
	orderDetail.obj.parentId = 0;
	orderDetail.obj.orderCategoryId = 19;
	orderDetail.obj.orderCategoryMain = 0;
	orderDetail.obj.resourcePriceType = 1;
	orderDetail.obj.matterLength = getCellValue(rowId,2);
	orderDetail.obj.industryTypeId = 1;
	orderDetail.obj.compagesId = 0;
	orderDetail.obj.resourceSortId=1;
	orderDetail.obj.resourceSpecificId=0;
	
	orderDetail.obj.ageRate 	 = 0;
	orderDetail.obj.appRate 	 = 0;
	orderDetail.obj.favourRate   	 = 0;
	orderDetail.obj.moneyRealpay     =$("incomeMoney").value;
	
	getMatterObj(orderDetail,rowId);	
}

function getMatterObj(oDetail,rowId){

		matter.reset();		
		matter.obj.name = getCellValue(rowId,0);
		matter.obj.edit = getCellValue(rowId,1);
		matter.obj.length = getCellValue(rowId,2);
		
		matter.obj.customerId =  customerId;
		matter.obj.matterType = 1;
		matter.obj.version = 0;
		matter.obj.enable = true; 
		matter.obj.createBy = userId;
		matter.obj.tapeCode='';

		oDetail.obj.matter = matter.obj; 
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
function saveOrderDayInfo(rowId,col){
	var orderDayInfos = new Array();
	//获得指定的参数
	var curSpecific = 0;
	
	
	  //广告日信息 
	orderDayInfo.obj.needCal = 19;
	orderDayInfo.obj.contractId = 0;

	orderDayInfo.obj.orderId = order.obj.id;

	//orderDayInfo.obj.dayStandardPrice =0;

	orderDayInfo.obj.dayRelIncome = 0;
	orderDayInfo.obj.dayRelPuton = 0;
	orderDayInfo.obj.resourceSpecific = curSpecific;
	orderDayInfo.obj.isPublished = 0;
	orderDayInfo.obj.adlength = getCellValue(rowId,2);
	orderDayInfo.obj.adDayTimes=getCellValue(rowId,col);

	orderDayInfo.obj.customerId = customerId;
	orderDayInfo.obj.publishDate=getFormatDay($("orderDate").value,'ymd');	
	orderDayInfo.obj.linkUserId = userId;	
	orderDayInfo.obj.version = getDayPar(config_serviceDate,'y');
	//资源日信息
	//resDayInfo.carrierId = $("carrier").value;
	resDayInfo.resourceId = orderDetail.obj.resourceInfoId;
	resDayInfo.publishDate = getFormatDay($("orderDate").value,'ymd');

	var func = function(objs){
		resDayInfo.id = objs[0].id;
		resDayInfo.used = objs[0].used-orderDetail.obj.sumTimes*getCellValue(rowId,2)+(getCellValue(rowId,col))*getCellValue(rowId,2);
	}
	workspan.getResourceDayInfo(resDayInfo.publishDate,resDayInfo.resourceId,func);
	//resDayInfo.version = 2;	
	resDayInfo.specific=""
	orderDayInfo.obj.dayInfo = resDayInfo;

	orderDayInfo.obj.dayStandardPrice=price.getSysPriceByResId(orderDetail.obj.resourceInfoId,getCellValue(rowId,2),1);
	if(orderDayInfo.obj.dayStandardPrice==null) orderDayInfo.obj.dayStandardPrice=0;
	orderDetail.obj.sysPrice = orderDayInfo.obj.dayStandardPrice;
	
	orderDayInfos.push(orderDayInfo.obj);
	
	return orderDayInfos;
}

function getCustomerCarrierRelXML(){

		//customerCarrierRel.obj.customerId=customerId;
		
		customerCarrierRel.obj.carrierId=$("carrier").value;
		customerCarrierRel.obj.startDate=getFormatDay($("orderDate").value,"ymd");
		

		var callBack=function(objs){
			objsList=objs;
			var len=mygrid.getColumnCount();
			colLength=objs.length;
			for(var i = 0;i<len-5-objs.length;i++){
				//mygrid.setHeaderCol(len-3-i,"");
				mygrid.setColWidth(len-3-i,0);
			}
			var leftLength=60-Math.floor(60/colLength)*colLength;
			mygrid.setColWidth(0,leftLength+10);
			for(var i = 0;i<objs.length;i++){
				mygrid.setHeaderCol(i+3,objs[i].memo);
				mygrid.setColWidth(i+3,Math.floor(60/objs.length));
				var el = $("month"+(i));
				var sumtimes=0;
        			for(var j=0;j<mygrid.getRowsNum();j++){
       					sumtimes+=mygrid.cells2(j,i-0+3).getValue()==''?0:(mygrid.cells2(j,i-0+3).getValue()-0)*mygrid.cells2(j,2).getValue();
        			}
        			el.innerHTML = objs[i].length-sumtimes;
        			for(var j=objs.length;j<len-5;j++) $("month"+(j)).innerHTML="";
			}
			if(isChecked!="通过"&&isChecked!="未审批")
			addEventAction(objs.length);
			//calculateFooterValues(objs);			
		}
		var func = function(xml){
			mygrid.clearAll();
			mygrid.loadXMLString(xml);	
			customerCarrierRel.getCustomerCarrierRels(customerCarrierRel.obj,callBack);
		 }
		if(isNewOrder&&order.obj.id==null) {
			customerCarrierRel.getCustomerCarrierRels(customerCarrierRel.obj,callBack);
		}else{
			customerCarrierRel.getCustomerCarrierRelXML(customerCarrierRel.obj,func);
		}
	
}
function startProgress(currentPercent,totalSize)
{
	    $('progressBar').style.display = 'block';
	    //$('progressBarText').innerHTML = 'upload in progress: 0%';
	    
	    var progressPercent = Math.ceil((currentPercent /totalSize) * 100);

            $('progressBarText').innerHTML = '保存进度: ' + progressPercent + '%';
	
            $('progressBarBoxContent').style.width = parseInt(progressPercent * 3.5) + 'px';
}

var cellClickMatter = function(el, ev) {

	var K =  (ev.type == "keydown")? ev.keyCode : ev.which;

  	if(ev.type == "mousedown"){		
		if(!ev.target.previousSibling){
	  		//makeMatterSelectItem(null,null);
		}else if(!ev.target.previousSibling.previousSibling){
			var matterName=mygrid.cells4(ev.target.previousSibling).getValue()==""?"0":mygrid.cells4(ev.target.previousSibling).getValue();
	 		makeMatterSelectItem(matterName,null);
	  	}else{
	  		var matterName=mygrid.cells4(ev.target.previousSibling.previousSibling).getValue()==""?0:mygrid.cells4(ev.target.previousSibling.previousSibling).getValue();
	  		var matterEdit=mygrid.cells4(ev.target.previousSibling).getValue()==""?0:mygrid.cells4(ev.target.previousSibling).getValue();
	 		makeMatterSelectItem(matterName,matterEdit);
		}
  	}	
}
var addEventActionMatter=function(){
	var ids=getResourceIds();
	for(var i=0;i<ids.length;i++){
		for(var j=0;j<3;j++)
		add_evs_matter(mygrid.cellAll(ids[i],j));
	}		
}
var add_evs_matter = function(el) {
		addEvent(el, "mousedown", dayMouseDownMatter);
};
var dayMouseDownMatter = function(ev) {
	var el = ev.currentTarget;
		cellClickMatter(el,ev);
	return stopEvent(ev);	
};
function makeMatterSelectItem(matterName,matterEdit){
 	
 	matter.reset();
 	matter.obj.customerId=customerId;
 	if(matterName==null&&matterEdit==null){		
 		matter.makeMatterSelect(matter.obj,matter.selectName,"",getMatterCombo);
 	}else if(matterName!=null&&matterEdit==null){
 		matter.obj.name=matterName;
 		matter.makeMatterEditOrLengthSelect(matter.obj,matter.selectName,"",getEditCombo);		
 	}else{
 		matter.obj.name=matterName;
 		matter.obj.edit=matterEdit;
 		matter.makeMatterEditOrLengthSelect(matter.obj,matter.selectName,"",getLengthCombo);
	}		
}
function getMatterCombo(event){
	var el = $(matter.selectName);
	var inputs = el.getElementsByTagName("option");
	var command = mygrid.getCombo(0);
	command.clear();
	inputs = $A(inputs);
	inputs.each(function(ip){
	    if(ip.value!=""){
		command.put(ip.value,el.options[ip.index].text);

	   }	
	});
}
function getEditCombo(event){
	var el = $(matter.selectName);
	var inputs = el.getElementsByTagName("option");
	var command = mygrid.getCombo(1);
	command.clear();
	inputs = $A(inputs);
	inputs.each(function(ip){
	    if(ip.value!=""){
		command.put(ip.value,el.options[ip.index].text);		
	   }	
	});
}
function getLengthCombo(event){
	var el = $(matter.selectName);
	var inputs = el.getElementsByTagName("option");
	var command = mygrid.getCombo(2);
	command.clear();
	inputs = $A(inputs);
	inputs.each(function(ip){
	    if(ip.value!=0){
		command.put(ip.value,el.options[ip.index].text);		
	   }	
	});
}