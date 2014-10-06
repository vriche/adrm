var proOrder = new ProOrder();
var proCustomer = new ProCustomer();
var proProgram = new ProProgram();
var user     = new User();
var ctxPath;
var order;
var program;
var customer;
var type;
var myWin;
callOnLoad(init);



function init(){
	    winHeight = self.innerHeight*0.93; 
	    winWidth = self.innerWidth*0.98;
        type = getParamFromUrl(document.location.href,"type");
        if(type==1){
        	headers = "节目名称,客户名称,应付金额,付款金额,业务员,签订日期,应付日期,付款日期";
        }else{
        	headers = "节目名称,客户名称,应收金额,到款金额,业务员,签订日期,应收日期,到款日期";
}
		ctxPath = $F("ctxPath");
	 	setProOrderPara(proOrder);
        initGrid();
        resetHeigth();
        initToolbar();
        buttonEvent();
      //  buttonEventFill();
       // order();  
        customer();
        program();
        getServiceDate();
        config_serviceDate = $("config_serviceDate").value;
        getDate();
        setUserPara(user);
	user.makeSelectAnalyze(user,user.selectName,"",setUserSelected); 
	 getYearByVersion();
	    getProOrderList();
}
function getYearByVersion(){
	proOrder.obj.orderTypeId=type;
	proOrder.getYearByVersion($("order_year"),"orderYear",proOrder.obj,callBackFun);
		function callBackFun(){
			setSelectByValue($("orderYear"),getFormatDay(config_serviceDate,'y'));
	}
}
function buttonEvent(){
	
	var btn_searchediv = $("btnSearch");
	btn_searchediv.onclick= getProOrderList;
	
	var btn_close = $("btnClose");
	btn_close.onclick= searchClose;	
		
    var order_year = $("order_year");
	order_year.onchange = getNewOrder_year;
	
}

function getNewOrder_year(){
	 order_year = $("orderYear").value;
	
	 var startDate= $("startDate").value;
	 var endDate= $("endDate").value;
	 startDate = order_year  + startDate.substring(4,startDate.length);
	 endDate = order_year  + endDate.substring(4,endDate.length);
	 $("startDate").value = startDate;
	 $("endDate").value = endDate;
}
 function searchClose() {
 	if(!isUndefined(myWin)) myWin.close();
 	
}
 function getServiceDate(){
 	var fuc = function(d){
 		$("config_serviceDate").value = d;
 	}
 	DWREngine.setAsync(false);
 	DateUtil.getServiceDate(fuc);
 	DWREngine.setAsync(true);
 }
 
function getDate(){
	
	Calendar.setup({
		inputField  : "startDate",	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "startDate"	// id of the button
	});
	Calendar.setup({
		inputField  : "endDate",	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "endDate"	// id of the button
	});
	$("startDate").value = getFormatDay(getFormatDay(config_serviceDate,'y')+'0101','y/m/d');
	$("endDate").value = getFormatDay(getFormatDay(config_serviceDate,'y')+'1230','y/m/d');
}
function resetHeigth(){
    $("gridbox").style.height = winHeight* 0.80 +"px";
}
function buttonEventFill(){
	var query=$("query");
	query.onclick=getOrderList;

}

function setUserPara(obj){
	 obj.className ="user";
	 obj.selectName =  "userName"; 
}

function setUserSelected(){
	
$("userName").setAttribute("style","margin-left:-100px;width:140px;height:20px");

}
function getOrderList(){
	
	$("proCustomerName").value=customer.getComboText();
	$("proProgramName").value=program.getComboText();
	getProOrderList();
}
function getProOrderList(){

	proOrder.reset();
	setProOrderPara(proOrder);
	var programs ={proName:program.getComboText(),proCustomer:{customerName:customer.getComboText()}};
	
	proOrder.obj.program =programs;
	proOrder.obj.payDate=getFormatDay($("startDate").value,'ymd')==""?null:getFormatDay($("startDate").value,'ymd');
	proOrder.obj.paidDate=getFormatDay($("endDate").value,'ymd')==""?null:getFormatDay($("endDate").value,'ymd');
	proOrder.obj.userId=$("userName").value==0?null:$("userName").value;
	proOrder.obj.orderTypeId=type;
	proOrder.obj.version=$("order_year").value==null?"":$("order_year").value;
	
	loadData(proOrder.obj);
	searchClose();
	
}
function setProOrderPara(obj){
	 var page=Math.round(winHeight* 0.80/20)-3;
	 obj.className  = "proOrder";
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= page;
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}
function loadData(obj,callBackFun){
	var func = function(xml){
		mygrid.clearAll();
		mygrid.loadXMLString(xml);
        if(callBackFun) callBackFun();
	}
	proOrder.getProOrderPageXML(obj,func);
}
//翻页处理
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == proOrder.pageInfo){
		var page = new Page(proOrder.pageInfo,proOrder.pageSize);
		page.goNextPage(pageIndex);
		proOrder.page = page;
		var func =function(){

		}
		loadData(proOrder.obj,func);
	}
}	

function order(){
	    order=new dhtmlXCombo("order","order",130); 
		order.enableFilteringMode(true); 
		//z.loadXML("sampleData/order_code.xml");
		proOrder.obj.orderTypeId=type;
		proOrder.getProOrderCodeXML(proOrder.obj,getFun);
		function getFun(xml){
			order.clearAll();
    	    order.loadXMLString(xml); 
    }	

}

function customer(){
	    customer=new dhtmlXCombo("customer","customer",138); 
		customer.enableFilteringMode(true); 
		//z.loadXML("sampleData/customer_name.xml");
		if(type==1){
			proCustomer.obj.typeId=1;
		}else{
			proCustomer.obj.typeId=2;
		}	
		proCustomer.getProCustomersXML(proCustomer.obj,getFun);
        function getFun(xml){
        	customer.clearAll();
    	customer.loadXMLString(xml); 
   }	
}

function program(){
	    program=new dhtmlXCombo("program","program",138); 
		program.enableFilteringMode(true); 
		//z.loadXML("sampleData/program_name.xml"); 
		proProgram.obj.typeId=type;
       proProgram.getProgramNameByOrderXML(proProgram.obj,getFun);
        function getFun(xml){
        	program.clearAll();
    	program.loadXMLString(xml); 
   }	
}

	
function initGrid(){
	var imagePath = ctxPath + "image/grid/";
		mygrid = new dhtmlXGridObject('gridbox');
		mygrid.setImagePath(imagePath);
		if(type==1){
		mygrid.setHeader(",节目名称,,客户名称,应付金额,付款金额,业务员,签订日期,应付日期,付款日期");
		}else{
		mygrid.setHeader(",节目名称,,客户名称,应收金额,到款金额,业务员,签订日期,应收日期,到款日期");	
		}
		mygrid.setInitWidthsP("0,20,0,20,10,10,10,10,10,10")
		mygrid.setColAlign("left,left,right,left,right,right,left,right,right,right")
		mygrid.setColTypes("ro,link,ro,link,ro,ro,ro,ro,ro,ro");
		mygrid.setColSorting("str,str,str,str,int,int,str,date,date,date")
		mygrid.enableMultiselect(true)
		mygrid.init();
		
		mygrid.setSkin("modern2");
		mygrid.enableAlterCss("even","uneven");
//		mygrid.setOnRowDblClickedHandler(rowDblClick);
		mygrid.setOnRowSelectHandler(onRowSelectd,true);
}
	
function onRowSelectd(rowId){
	if(type ==1){
			window.location.href=ctxPath+"merm/proOrderEdit.jsp?type=1&id="+rowId;
		}else{
			window.location.href=ctxPath+"merm/proOrderEdit.jsp?type=2&id="+rowId;
		}
}
function rowDblClick(rowId,colIndex){

	if(colIndex ==0){
		if(type ==1){
			window.location.href=ctxPath+"merm/proOrderEdit.jsp?type=1&id="+rowId;
		}else{
			window.location.href=ctxPath+"merm/proOrderEdit.jsp?type=2&id="+rowId;
		}
	}
		
	if(colIndex ==1){
        var row=mygrid.getRowById(rowId);
	var customers = getCellValue(row,1);
	var customer ={customerName:customers,typeId:type};
		
            function callBackFun(objs){
		var id=objs.id;
	        window.location.href=ctxPath+"merm/editCustomer.jsp?id="+id+"&orderTypeId="+type;
	         }
	    
		proCustomer.getProCustomersId(customer,callBackFun);
	
	}
	
	if(colIndex ==2){
        var row = mygrid.getRowById(rowId);
		var programer = getCellValue(row,2);

		var program ={proName:programer};
		function callBackFun(objs){
			var id=objs.id;
			window.location.href=ctxPath+"merm/proProgramEdit.jsp?id="+id+"&orderId="+rowId;
		}
		proProgram.getProProgramId(program,callBackFun)
		
		
	}
	
}

function initToolbar(){
	   		var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml"
		var aToolBar=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo"); 
		aToolBar.setOnClickHandler(onButtonClick);

		//aToolBar.addItem(new dhtmlXImageTextButtonObject('dhtmlXToolbar/imgs/iconNewNewsEntry.gif',"新添",100,25,0,'0_new','新添','','','dhtmlXToolbar/imgs/iconNewNewsEntry_dis.gif'));
                //aToolBar.addItem(new dhtmlXToolbarDividerXObject('b_'+(new Date()).valueOf()));		
		
		aToolBar.loadXML(toolbarDataPath,callBack);
		 
		function callBack(){
			aToolBar.hideButtons(); 
	                aToolBar.showButtons("1_new,4_search,5_print,6_view,7_export,14_chart");  
	                aToolBar.showButtons("div_1,div_4,div_5,div_6,div_7,div_14"); 
	                aToolBar.setBarAlign("right");
		}
		
		
		 aToolBar.showBar();  
}
	
function onButtonClick(itemId,itemValue)
	{              
		if(type ==1){
		if(itemId=='1_new') window.location.href=ctxPath+"merm/proOrderEdit.jsp?type=1";
	}else{
	    if(itemId=='1_new') window.location.href=ctxPath+"merm/proOrderEdit.jsp?type=2";
}               
       // if(itemId=='2_delete') deleteRow();
		if(itemId=='4_search') search();
		if(itemId=='5_print') print();
		if(itemId=='6_view') printView();
		if(itemId=='7_export') printExport();
		if(itemId=='14_chart') printChart();
	}

function print(){
		//window.location.href=getReportURL('print')	
		var title ="";
		var urlStr = getReportURL('print');
		openNewWin(title,urlStr);			
}	
function printView(){
		//window.location.href=getReportURL('view')
		var title ="";
		var urlStr = getReportURL('view');
		 openNewWin(title,urlStr);					
}
function printExport(){
		window.location.href=getReportURL('export');
}
function printChart(){
		window.location.href=getReportURL('chart',true);
}
function openNewWin(title,urlStr,w,h) {
   
   w = w > 0?w:winWidth;
   h = h > 0?w:winHeight;

   var parameters ={
   	title:"<strong>" + title +"</strong>",
   	className:"alphacube",
	width:w,
	height:h,
	draggable:false,
	minimizable:false,
	maximizable:false,
	closable:true
   	// parameters.effectOptions = {className: "popup_effect1"};
   };

	myWin = new Window(parameters);
	myWin.setURL(urlStr);
	myWin.showCenter(true);
	
}
function getReportURL(model,isChart){
	
        var url = ctxPath;

		var a = {
			 	model: model,
                reportType: "proOrder_report",
                headers:headers,
                displaySumColum:"0,0,1,1,0,0,0,0",
                isSum:true,
                isVertical:true,
                startDate: getFormatDay($("startDate").value,'ymd')==null?0:getFormatDay($("startDate").value,'ymd'),
                endDate: getFormatDay($("endDate").value,'ymd')==null?0:getFormatDay($("endDate").value,'ymd'),
                customerName: customer.getComboText(),
                programName: program.getComboText(),
                proOrderTypeId: type,
                userId:$("userName").value,
                version:$("proOrderYear").value
		};		
		var h = $H(a);	
		if(isChart){
			url = ctxPath +"/merm/proOrderChart.jsp?type="+type+"&"+ encodeURI(h.toQueryString());	
		}else{
			url = ctxPath +"/reports/printServlet?"+ encodeURI(h.toQueryString());	
		}

		return url;
}
function deleteRow()
{ var id = mygrid.getSelectedId();
	if(id > 0){
		var msg = "请确认是否删除这条记录 ?";
		
		ans = confirm(msg);
		if(ans){
	  	proOrder.removeProOrder(id);
	         mygrid.deleteSelectedItem(); 
	  }
	}else{
	alert("一次只能删除一条");
        }
}
function deleteRows()
	{  if(mygrid.getSelectedId().split(",").length>1){alert("一次只能删除一条！");return false;};
	   //if (confirm("Do you want to delete  ")) mygrid.deleteSelectedItem(); 
	   //WindowCloseKey.init(); 
	    Dialog.confirm("请确认是否删除", {className: "alphacube", width:300, height:80,okLabel: "确定",cancelLabel: "取消",
	     onOk:function(win){               
	             Dialog.closeInfo();
	            var id = mygrid.getSelectedId();
	  			 proOrder.removeProOrder(id);
	             mygrid.deleteSelectedItem(); 

	         }});
	  
	}
function search() {
	var parameters ={
	   	title:"<strong>订单搜索</strong>",
	   	className:"alphacube",
		width:550,
		draggable:false,
		minimizable:false,
		maximizable:false,
		closable:false
   	};
	myWin = new Window(parameters);
	myWin.setContent("login");
	myWin.showCenter(true);
}
