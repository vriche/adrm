var orderdayinfo =new OrderDayInfo();
var income = new Income();
var isPutOnORIncome = true;
var isPutOn;
var user = new User();
var carrier = new Carrier();
var userName;
var myDate = new MyDate();
var config_serviceDate;
var incomePurpose = new IncomePurpose();
var myprint =new MyPrint();


callOnLoad(init);
 
function init(){

	isDisplayChartParam = _app_params.sysParam.isDisplayChartParam;
	channelModelParam = _app_params.sysParam.channelModelParam;
	config_serviceDate = _app_params.serviceDate.def;
	userName =  _app_params.user.username;
	config_useCarrierAliname = _app_params.sysParam.useCarrierAliname;
	
	_make_adrm_sys_year_select("order_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);
	
	_make_org_select("orgId",120,"getBusinessAnalyze");		
	
	    config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;
    if(config_oneOrgMoreSuborgsParam == '1'){$('orgId').hide();}
	
	setBusinessAnalyzePara(orderdayinfo);	
	setIncomePara(income);
	setUserPara(user);
	setPurposePara(incomePurpose);
	setCarrierPara(carrier);
	carrier.obj.nodeLevel =1;
//	carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","");
//	hiddenChartButton();
//	makeCarrierSelectItem();
//	user.makeSelectAnalyze(user,user.selectName,"",setUserSelected);	
	getDate(_app_params.serviceDate.year, _app_params.serviceDate.def);	
	buttonEventFill();
	
	resetHeigth();
	
	initGrid();


	incomePurpose.obj.version = $("order_year").value;
	incomePurpose.makeOptionsCallBackFun(incomePurpose.obj,fillFun);	
//	incomePurpose.makeOptionsCallBackFun(incomePurpose,fillFun);	

	function fillFun(objs){
		makeOptionsCheckBoxHtml(objs,"checkbox",incomePurpose.checkBoxName,"name","id","","",[]);     
	}
	
		this.myprint.buildButtons(this,"printReportDiv",[0,1,2,6],80); 
}

function onOrgChanged(){
	$("userOwner").value="";
	$("carrierName").value="";
}

function setPurposePara(obj){
	 obj.className ="incomepurpose";
	 obj.checkBoxName = obj.className +"RN";
}
function hiddenChartButton(){
	if(isDisplayChartParam!=1){
		$("displayChar").hide();
	}else{
		$("displayChar").show();
	}
}
function makeCarrierSelectItem(){
	//根据是否分频道，取得频道下拉列表
	if(channelModelParam!=1){
		carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","");
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
function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}

function setUserPara(obj){
	 obj.className ="user";
	 obj.selectName =  "userOwner"; 
}

function setUserSelected(){
	 	var id  = $("userId").value;
	 	if(id > 0){
	 		$(user.selectName).value = id;
	 	}
}

function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
//    var businessAnalyze_div = $("businessAnalyze_div");
//    businessAnalyze_div.style.width = dialogcontent.offsetWidth -73 +"px";
//    $("userOwner").setAttribute("style","width:100px;margin-left:-100px;font-size:12px;");
//    businessAnalyze_div.style.height = dialogcontent.offsetHeight * 0.8 +"px";	
//    $("businessAnalyzeTable").style.width =  businessAnalyze_div.offsetWidth - 20 +"px";
    
      $("gridbox_body").style.height = dialogcontent.offsetHeight * 0.8 +"px";	
} 

function printReport(mode){
//	 var s=['view','print','excel'];
	 
	if(mode =="view"){
		button_view_order();
	}
	if(mode =="print"){
		button_print_order();
	}
	if(mode =="excel"){
		button_print_export();
	}
	
	if(mode =="chart"){
		getFusionChartObjs();
	}	
	
	   
}

function attachHeaderNew(grid){
	var rows = grid.getRowsNum();
	var lastId = grid.getRowId(rows-1);
	var cl_1 = (rows == 0)?"": grid.cells2(lastId,1).getValue();
	var cl_2 = (rows == 0)?"": grid.cells2(lastId,2).getValue();
	var cl_3 = (rows == 0)?"": grid.cells2(lastId,3).getValue();
	var cl_4 = (rows == 0)?"": grid.cells2(lastId,4).getValue();
	var cl_5 = (rows == 0)?"": grid.cells2(lastId,5).getValue();
	var cl_6 = (rows == 0)?"":grid.cells2(lastId,6).getValue();
	var cl_7 = (rows == 0)?"":grid.cells2(lastId,7).getValue();
	var cl_8 = (rows == 0)?"":grid.cells2(lastId,8).getValue();
	var cl_9 = (rows == 0)?"":grid.cells2(lastId,9).getValue();
	var cl_10 = (rows == 0)?"":grid.cells2(lastId,10).getValue();
	var cl_11 = (rows == 0)?"":grid.cells2(lastId,11).getValue();
	var cl_12 = (rows == 0)?"":grid.cells2(lastId,12).getValue();
	var cl_13 = (rows == 0)?"":grid.cells2(lastId,13).getValue();

	var htm ="#rspan*"+ cl_1 +"*"+ cl_2 +"*"+ cl_3 +"*"+ cl_4 +"*"+ cl_5 +"*"+ cl_6+"*"+ cl_7+"*"+ cl_8+"*"+ cl_9+"*"+ cl_10+"*"+ cl_11+"*"+ cl_12+"*"+ cl_13;

	var h = htm.split("*");
	//alert(h.length);
	var z =  grid.ftr.rows[1];
	
	for(var cin = 0; cin<h.length;cin++){
		if(h[cin].indexOf("#rspan") != 0) {
			var c = z.cells[z._childIndexes?z._childIndexes[parseInt(cin)]:cin];
			c.innerHTML = h[cin];		
		}

	}
	
	grid.deleteRow(lastId);
	
}

function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");

	var flds = "业务员,一月,二月,三月,四月,五月,六月,七月,八月,九月,十月,十一月,十二月,合计";
	mygrid.setHeader(flds);

	mygrid.setInitWidthsP("8,7,7,7,7,7,7,7,7,7,7,7,7,8");
	mygrid.setColAlign("left,right,right,right,right,right,right,right,right,right,right,right,right,right");
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
	mygrid.enableAlterCss("even","uneven"); 
	mygrid.setColSorting("str,int,int,int,int,int,int,int,int,int,int,int,int,int") ;
//	mygrid.setCustomSorting(sort_custom,0);
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	//mygrid.enableDragAndDrop(false);
	mygrid.setSkin("modern2");
	mygrid.init();	 
	mygrid.setSortImgState(true,0,"ASC"); 
	mygrid.attachFooter('合计:, , , , , , , , , , , , , , ',['text-align:center;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;']);
	mygrid.setSizes();	
}

function buttonEventFill(){
	
	var userOwner = $("userOwner");
	userOwner.onclick = displayUsersTree2; 
	
	var Bt_search = $("searchBusiness");
	Bt_search.setAttribute("href","javascript:void 0");
	Bt_search.onclick = getBusinessAnalyze;	
	
//	var Bt_search = $("displayPuton");
//	Bt_search.setAttribute("href","javascript:void 0");
//	Bt_search.onclick = getBusinessAnalyzePutOn;	

	var btn_searche = $("btnSearche");
	btn_searche.onclick=displayDiv;
	
	var btn_searche_close=$("btnSearcheClose");
	btn_searche_close.onclick=closeDiv;
	
//	var Bt_displayChar = $("displayChar");
////	Bt_displayChar.setAttribute("href","javascript:void 0");
//	Bt_displayChar.onclick = getFusionChartObjs;
//	
//	var Btn_view_order = $("Btn_view_order");
//	Btn_view_order.onclick = button_view_order;
//
//	var Btn_print_order = $("Btn_print_order");
//	Btn_print_order.onclick = button_print_order;	
//	
//	var Btn_export_order = $("Btn_export_order");
//	Btn_export_order.onclick = button_print_export;	
	
		var carrierName2 = $("carrierName");
	carrierName2.onclick = displayCarrierTree2; 
	
	var change_order_year = $("order_year");
	change_order_year.onchange = rest_query_order;	
	
	
}

function displayUsersTree2(){
  var ids = $("userOwner").value;
  var loginUser =  userName;
  var parentUserId = 0;
  var urlStr="selectPopup/selectUserRel.html?mode=1&loginUser="+loginUser+"&ids="+ids+"&orgId="+$("orgId").value;
  var cleanBtn ={text: '重置',handler: function(){document.getElementById('userReliframe').contentWindow.refreshTree();}};	
  var closeBtn ={text: '确定',handler: function(){removeWin();}};
  
        
 var winUser = new Ext.Window({
   title : '选择用户',
   //maximizable : true,
   // maximized : true,
   width : 350,
   height : 400,
   // autoScroll : true,
   // bodyBorder : true,
   // draggable : true,
   isTopContainer : true,
   modal : true,
   resizable : false,
    buttons: [cleanBtn,closeBtn],
   contentEl : Ext.DomHelper.append(document.body, {
    tag : 'iframe',
     id : 'userReliframe',
    style : "border 0px none;scrollbar:true",
    src : urlStr,
    height : "100%",
    width : "100%"
   })
  })
  winUser.show(); 
  
     function removeWin(){
    	var ids = document.getElementById('userReliframe').contentWindow.getCheckedIds();
    	if(ids!=null && ids.length>0){
			$("userOwner").value = ids.join(',');
		}else{
			$("userOwner").value ='';
		}
 
  		winUser.destroy();
   	} 
   winUser.on({'close': {fn: removeWin}});   
    
}

function displayCarrierTree2(){
  var ids = $("carrierName").value;
  var loginUser =  userName;
//  var urlStr="selectPopup/selectUserCarrierRel.html?mode=2&loginUser="+loginUser+"&ids="+ids;
  var urlStr="selectPopup/selectUserCarrierRel.html?mode=2&loginUser="+loginUser+"&ids="+ids +"&useCarrierAliname="+config_useCarrierAliname+"&orgId="+$("orgId").value;
  
  var cleanBtn ={text: '重置',handler: function(){document.getElementById('userCarrReliframe').contentWindow.refreshTreeCarriers();}};	
  var closeBtn ={text: '确定',handler: function(){removeWin();}};
  
        
 var win = new Ext.Window({
   title : '选择频道',
   //maximizable : true,
   // maximized : true,
   width : 400,
   height : 300,
   // autoScroll : true,
   // bodyBorder : true,
   // draggable : true,
   isTopContainer : true,
   modal : true,
   resizable : false,
    buttons: [cleanBtn,closeBtn],
   contentEl : Ext.DomHelper.append(document.body, {
    tag : 'iframe',
     id : 'userCarrReliframe',
    style : "border 0px none;scrollbar:true",
    src : urlStr,
    height : "100%",
    width : "100%"
   })
  })
  win.show(); 
  
     function removeWin(){
    	var ids = document.getElementById('userCarrReliframe').contentWindow.getCheckedCarriers();
    	if(ids!=null && ids.length>0){
			$("carrierName").value = ids.join(',');
		}else{
			$("carrierName").value ='';
		}
 
  		win.destroy();
   	} 
   win.on({'close': {fn: removeWin}});   
    
}
function closeDiv(ev){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "hidden";
} 
function displayDiv(ev){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "visible";
	}

function button_view_order(){button_print('view');}	
function button_print_order(){button_print('print');}
function button_print_export(){button_print('export');}

function button_print(model){
	$("model").value = model;
	$("type").value = $("query").value;
	$("reportType").value = "businessAnalyze_report";
	
	$("startForm").value = getFormatDay($("beginDate").value,'ymd');
	$("endForm").value = getFormatDay($("overDate").value,'ymd');
	$("userId").value  = $(user.selectName).value==0?"":$(user.selectName).value;
	$("carrierNameForm").value = $("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
	

	
	$("userName").value=userName;
	$("channelModelForm").value=channelModelParam;
	
	var sortStr = mygrid.getSortingState();
	$("sortStr").value= sortStr[0]+","+sortStr[1];
//	$("putYear").value= $("isPutYear").checked == true?1:0;	
	
	$("putYear").value= $("isPutYear").checked == true?1:0;
	$("returnValue1").value= $("isNotReturnValue").checked == true?1:0;
	
	$("orgIdForm").value = $("orgId").value;
	
	
	var purpose = getCheckBoxValues("incomePur",1);
	if(purpose == '') purpose.push(-1);
	$("incomPurs").value= purpose.toString();
	
//	if(isPutOn==undefined){
//		alert("请选择打印类型");
//		return false;
//	}
	$("isPutOnORIncomeForm").value = false;


	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");

	
	reportForm.target = tarForm;
	reportForm.action="reports/jsp/common_reports.jsp";
	reportForm.submit(); 	
}

function setIncomePara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className   = "income";	
	 obj.IdPrefix 	 = obj.className + "Id";
//	 obj.fillObjName = "orderdayinfoBody";
//	 obj.color1 	 = "BACKGROUND-COLOR: #f5f5f5";
//	 obj.color2 	 = "BACKGROUND-COLOR: #ECEFF4";
////	 obj.tableName   = "incomeList";
//	 obj.tBody 		 = $(obj.fillObjName);
	 obj.pageSize 	= "10000";
	 obj.pageInfo 	= "pageInfoorderdayinfo";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}

//function getDate(){
//	Calendar.setup({
//		inputField  : "beginDate",	  // id of the input field
//		//ifFormat	: "%Y%m%d",	  // the date format
//		singleClick	  : true,
//		button	  : "beginDate"	// id of the button
//	});
//	
//	Calendar.setup({
//		inputField  : "overDate",	  // id of the input field
//		//ifFormat	: "%Y%m%d",	  // the date format
//		singleClick	  : true,
//		button	  : "overDate"	// id of the button
//	});
////	$("beginDate").value = getFormatDay(theYear+'0101','y/m/d');
////	$("overDate").value= getFormatDay(theYear+'1231','y/m/d');
//    $("beginDate").value = getFormatDay(config_serviceDate+'0101','y/m/d');
////	$("beginDate").value = getFormatDay(myDate.getNewDayStartDay1(config_serviceDate),'y/m/d');
//	$("overDate").value = getFormatDay(myDate.getNewDayEndDay1(config_serviceDate),'y/m/d');
//}

function getDate(order_year,serviceDate){
	

	$("order_year").value = order_year;
//	$("beginDate").value = getFormatDay(myDate.getNewDayStartDay1(serviceDate),'y/m/d');
	$("beginDate").value = getFormatDay(order_year+"0101",'y/m/d');
    $("overDate").value = getFormatDay(myDate.getNewDayEndDay1(serviceDate),'y/m/d');
    

	
	function dateDisabledFunc(date,i){
		if(i == 1){
		   var pval = ''+$("overDate").value; 
		   pval = pval.replace("/",'')*1;
		   var calDate = date.print("%Y%m%d")*1;
		   return !(date.getFullYear() == order_year && calDate < pval);
		}else{
		   var pval = $("beginDate").value;
		   pval = pval.replace("/",'')*1;
		   var calDate = date.print("%Y%m%d")*1;
		   return !(date.getFullYear() == order_year && calDate > pval);
		}

//		 return (date.getFullYear() != order_year);
	}

	Calendar.setup({
		inputField  : "beginDate",	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		range:[order_year],
		firstDay:1,
		singleClick	  : true,
		button	  : "beginDate",// id of the button
		dateDisabledFunc : function(date) {
//                      dateDisabledFunc(date,1);
		}
	});
	
	Calendar.setup({
		inputField  : "overDate",	  // id of the input field
		range:[order_year],
		firstDay:1,
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "overDate",	// id of the button
		dateDisabledFunc : function(date) {
//                     dateDisabledFunc(date,2);
		}
	});


}

function rest_query_order(){
	var year = $("order_year").value;
	
     var end = year + ''+ $("overDate").value.substring(5,7)+''+$("overDate").value.substring(8,10);
     getDate(year,end);
     
	 var beginDate= $("beginDate").value;
	 var overDate= $("overDate").value;
	 beginDate = year  + beginDate.substring(4,beginDate.length);
	 overDate = year  + overDate.substring(4,overDate.length);
	 $("beginDate").value = beginDate;
	 $("overDate").value = overDate;
	 
//    getBusinessAnalyze();

}


function setBusinessAnalyzePara(obj){
	 obj.className ="orderdayinfo";
	 obj.IdPrefix = obj.className + "Id";
//	 obj.fillObjName = "orderdayinfoBody";
//	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
//	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
//	 obj.tBody 		= $(obj.fillObjName);
//	 obj.pageSize 	= "10000";
//	 obj.pageInfo 	= "pageInfoorderdayinfo";
//	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}

function getBusinessAnalyze(){
	closeDiv();
	var type = $("query").value;
	var sortStr = mygrid.getSortingState();
	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	var carrierName = $("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
	isPutOnORIncome = true;


	orderdayinfo.reset();
	orderdayinfo.obj.resourceSpecific = sortStr[0]+","+sortStr[1];
//	orderdayinfo.obj.businessFirstName = $("isPutYear").checked == true?1:0;
//	orderdayinfo.obj.id = type;
	orderdayinfo.obj.startDate= getFormatDay($("beginDate").value,'ymd');
	orderdayinfo.obj.endDate= getFormatDay($("overDate").value,'ymd');
	orderdayinfo.obj.adlength  = userName; 
	orderdayinfo.obj.id = type;
	
	orderdayinfo.obj.businessFirstName = $("isPutYear").checked == true?1:0;
	orderdayinfo.obj.businessLastName = $("isNotReturnValue").checked == true?1:0;
	
	
	var purpose = getCheckBoxValues("incomePur",1);
	if(purpose == '') purpose.push(-1);
	orderdayinfo.obj.businessFullName = purpose.toString();
	orderdayinfo.obj.orgId = $("orgId").value;
	
		 var func = function(xml){
				mygrid.clearAll();
				mygrid.loadXMLString(xml);
				mygrid.setSizes();	
				attachHeaderNew(mygrid);	
				
				Ext.getBody().unmask();
				
		 }
	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	
	orderdayinfo.getBusinessAnalyzePagesXML(func,orderdayinfo.obj,userId,carrierName,isPutOnORIncome,channelModelParam);
}

//function getBusinessAnalyzePutOn(){
//	income.startDate=getFormatDay($("beginDate").value,'ymd');
//	income.endDate=getFormatDay($("overDate").value,'ymd');
//	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
//	var carrierName = $("carrierName").value==null?0:$("carrierName").value;
//	isPutOnORIncome = false;
//	isPutOn="false";
//
//	income.getPutOnInfos(income,userId,carrierName,channelModelParam);
//}

function displayChar(){
	var startDate = getFormatDay($("beginDate").value,'ymd');
	
	var endDate = getFormatDay($("overDate").value,'ymd');
	
	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	var carrierName = $("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
	window.open("businessAnalyzeChart.html?startDate=" + startDate + "&" + endDate+"$" + carrierName+"?"+userId+"@"+ isPutOnORIncome+"*"+channelModelParam+"!"+userName,"dispalyChart","")
//	parent.location.href ="businessAnalyzeChart.html?startDate=" + startDate + "&" + endDate+"$" + carrierName+"?"+userId+"@"+ isPutOnORIncome+"*"+channelModelParam+"!"+userName;
}

function getFusionChartObjs(){
	orderdayinfo.reset();
	var type = $("query").value;
	var sortStr = mygrid.getSortingState();
	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	var carrierName = $("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
	isPutOnORIncome = true;

	orderdayinfo.obj.resourceSpecific = sortStr[0]+","+sortStr[1];
	orderdayinfo.obj.startDate= getFormatDay($("beginDate").value,'ymd');
	orderdayinfo.obj.endDate= getFormatDay($("overDate").value,'ymd');
	orderdayinfo.obj.adlength  = userName; 
	orderdayinfo.obj.id = type;
	
	orderdayinfo.obj.businessFirstName = $("isPutYear").checked == true?1:0;
	orderdayinfo.obj.businessLastName = $("isNotReturnValue").checked == true?1:0;
	
	
	var purpose = getCheckBoxValues("incomePur",1);
	if(purpose == '') purpose.push(-1);
	orderdayinfo.obj.businessFullName = purpose.toString();
	
	
	function func(objs){
		fusionChartObjects = objs;
//		alert(fusionChartObjects.length);
	}
		
		var a = {
			    orgId:$("orgId").value,
                startDate: orderdayinfo.obj.startDate,
                endDate: orderdayinfo.obj.endDate,
                sortStr: orderdayinfo.obj.resourceSpecific,
                putYear: orderdayinfo.obj.businessFirstName,
                userId: userId,
                isPutOnORIncome:isPutOnORIncome,
                carrierName: carrierName,
                channelModelParam: channelModelParam,
                userName: orderdayinfo.obj.adlength, 
                type: orderdayinfo.obj.id,
                incomPurs: orderdayinfo.obj.businessFullName,
                returnValue: orderdayinfo.obj.businessLastName
		};		
		

        //now transform it into a hash encodeURI
        var h = $H(a);
		var url = "businessAnalyzeChart.html?"+h.toQueryString();
		window.open(url);

}