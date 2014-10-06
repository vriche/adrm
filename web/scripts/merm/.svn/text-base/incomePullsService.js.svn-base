var ctxPath;
var proCustomer = new ProCustomer();
var proCustomerType = new ProCustomerType();
var proProgram = new ProProgram();
var proOrder = new ProOrder();
var proOrderType = new ProOrderType();
var comboCustomer;
var comboProgram;
var headers ="订单号,客户名称,业务员,应付金额,应付时间,已付金额,已付时间";
callOnLoad(init);


function init(){
	    winHeight = self.innerHeight*0.93; 
	    winWidth = self.innerWidth*0.98; 
		ctxPath = $F("ctxPath");
		setProIncomePullPara(proOrder);
		proOrderType.getOrderType($("proOrderTypeDiv"),"proOrderType",100);
        initGrid();
        resetHeigth();
        initToolbar();
		comboCustomerDiv();
		comboProgramDiv();
		proCustomerType.makeSelectCustomerType($("customerTypeDiv"),"cusType","107");
		buttonEventFill();
		getIncomePullListByCustomer();
}
function resetHeigth(){
    $("gridbox").style.height = winHeight* 0.80 +"px";
}
function buttonEventFill(){
	var btn_searche = $("search");
	btn_searche.onclick=searchDiv;

}
function searchDiv(){
	
	var customerName = comboCustomer.getComboText();
	var programName = comboProgram.getComboText();
	$("proOrderCode").value = $("orderCode").value;
	$("proCustomerName").value = customerName;
	$("proProgramName").value = programName;
	$("orderTypeId").value = $("proOrderType").value;
	$("typeId").value="";
	getIncomePullListByCustomer();
}

function setProIncomePullPara(obj){
	 var page=Math.round(winHeight* 0.80/20)-3;
	 obj.className  = "proIncomePull";	
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= page;
	 obj.page = new Page(obj.pageInfo,obj.pageSize);	
}

function comboCustomerDiv(){
       		comboCustomer=new dhtmlXCombo("cus_name","alfa2",150);
	  			comboCustomer.enableFilteringMode(true);

				proCustomer.reset();
//				proCustomer.obj.typeId;
 			var func = function(xml){
					comboCustomer.clearAll();
					comboCustomer.loadXMLString(xml);
 			}
 			proCustomer.getProCustomersXML(proCustomer.obj,func);

}
function comboProgramDiv(){
			comboProgram=new dhtmlXCombo("pro_name","alfa2",150);
		  		comboProgram.enableFilteringMode(true);
 
				proProgram.reset();
//				proCustomer.obj.typeId;
 			var func = function(xml){
					comboProgram.clearAll();
					comboProgram.loadXMLString(xml);
 			}
 			proProgram.getProgramNameXML(proProgram.obj,func);
}
	

function initGrid(){
		var imagePath = ctxPath + "image/grid/";
		mygrid = new dhtmlXGridObject('gridbox');
		mygrid.setImagePath(imagePath);
		mygrid.setHeader("订单号,客户名称,业务员,应付金额,应付时间,已付金额,已付时间");
		mygrid.setInitWidthsP("14,16,14,14,14,14,14")
		mygrid.setColAlign("left,left,left,right,right,right,right")
		mygrid.setColTypes("ro,ro,ro,ro,ro,ed,calendar");
		mygrid.setDateFormat("y/m/d");
		mygrid.setColSorting("int,str,str,str,str,str,date")
		mygrid.enableMultiselect(true)
		mygrid.init();
//		mygrid.loadXML("sampleData/incomepull_grid.xml");
		mygrid.setSkin("modern2");
		mygrid.enableAlterCss("even","uneven");
		//mygrid.setOnRowDblClickedHandler(rowDblClick);
}
	
function rowDblClick(id){
	     window.location.href=ctxPath +"merm/editCustomer.jsp?id="+id;
}

function initToolbar(){
		var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml"
		var aToolBar=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo"); 
			aToolBar.setOnClickHandler(onButtonClick);	
			aToolBar.loadXML(toolbarDataPath,callBack);
		 
		function callBack(){
			aToolBar.hideButtons(); 
	        aToolBar.showButtons("3_save,4_search,5_print,6_view,7_export,14_chart");  
	        aToolBar.showButtons("div_3,div_4,div_5,div_6,div_7"); 
	                
		}

			aToolBar.showBar();  

}
	
function onButtonClick(itemId,itemValue)
	{              
		if(itemId=='3_save') saveIncomePull();
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
                reportType: "incomePulls_report",
                headers:headers,
                displaySumColum:"0,0,0,1,0,1,0",
                isSum:true,
                isVertical:true,
                orderCode: $("proOrderCode").value,
                customerName: $("proCustomerName").value,
                programName: $("proProgramName").value,
                typeId:$("typeId").value,
                orderTypeId:$("orderTypeId").value
		};		
		var h = $H(a);	
		if(isChart){
			url = ctxPath +"/merm/incomePullsChart.jsp?"+ encodeURI(h.toQueryString());
		}else{
			url = ctxPath +"/reports/printServlet?"+ encodeURI(h.toQueryString());	
		}

		return url;
}
	
function deleteRow()
	{  
	   //if (confirm("Do you want to delete  ")) mygrid.deleteSelectedItem(); 
	   //WindowCloseKey.init(); 
	    Dialog.confirm("请确认是否删除", {className: "alphacube", width:300, height:80,okLabel: "确定",cancelLabel: "取消",
	     onOk:function(win){               
	             Dialog.closeInfo();
	             mygrid.deleteSelectedItem(); 
	         }});
	  
	}
	

function search() {
		Dialog.confirm($('login').innerHTML,
		 {className:"alphacube", width:400, okLabel: "确定", cancelLabel: "取消",
		
		         onOk:function(win){               
		             Dialog.closeInfo();
		             $("proCustomerName").value = $("cusName").value;
		         	 $("proProgramName").value = $("programName").value;
		         	 $("typeId").value = $("cusType").value;
		         	 $("orderTypeId").value="";
		         	 getIncomePullListByCustomer();
		             return true;
		         }
	         }
	                                        
	         );
	}	

function getIncomePullListByCustomer(){
	proOrder.reset();
	proOrder.obj.orderCode=$("proOrderCode").value;
	
	var customerName = $("proCustomerName").value;
	var programName = $("proProgramName").value;
	if($("typeId").value!=""){
			var cusType= $("typeId").value;
		}
	if($("orderTypeId").value!=0){
			proOrder.obj.orderTypeId = $("orderTypeId").value;
		}
	 
	 var func = function(xml){
				mygrid.clearAll();
				mygrid.loadXMLString(xml);
				
		 }
	
		proOrder.getProIncomePullPageXML(customerName,programName,cusType,proOrder.obj,func);
}

//翻页处理
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == proOrder.pageInfo){
		var page = new Page(proOrder.pageInfo,proOrder.pageSize);
		page.goNextPage(pageIndex);
		proOrder.page = page;

		getIncomePullListByCustomer();
	}

}	

function getFormatDate(shortDate,format){
	var m =  shortDate.substring(0,2);
	var d =  shortDate.substring(3,5);
	var y =  shortDate.substring(6,10);
	shortDate = y + m + d;
	return shortDate;
}
function saveIncomePull()
	{  
	
	var proOrders = new Array();

	var rows = getResourceIds();
	 for(var i =0;i< rows.length;i++){
			var row_id = rows[i];
			
			var pOrder = (new ProOrder()).obj;
			pOrder.id = row_id;
			pOrder.paidMoney = getCellValue(row_id,5);
			pOrder.paidDate = getFormatDate(getCellValue(row_id,6),'ymd');
			
		proOrders.push(pOrder);
	}
	
	 var func = function(){
				alert("保存成功！");
				
		 }
	
	 if(proOrders.length> 0 )proOrder.saveProIncomePulls(proOrders,func);
	 
	}
	function getCellValue(rowId,col){ 
	return mygrid.cells(rowId,col).getValue();
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

