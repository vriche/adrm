var ctxPath;
var proCustomer = new ProCustomer();
var proOrder = new ProOrder();
var proOrderType = new ProOrderType();
var comboCustomer;
var headers="订单号,客户名称,业务员,应付金额,应付时间,已付金额,已付时间,欠款金额";
callOnLoad(init);


function init(){
		ctxPath = $F("ctxPath");
		winHeight = self.innerHeight*0.93; 
	    winWidth = self.innerWidth*0.98; 	
		setProPayMentPara(proOrder);
		proOrderType.getOrderType($("proOrderTypeDiv"),"proOrderType",100);
        initGrid();
        resetHeigth();
        initToolbar();
		comboCustomerDiv();
		buttonEventFill();
		getPaymentListByCustomer();
}
function resetHeigth(){
    $("gridbox").style.height = winHeight* 0.80 +"px";
}
function comboCustomerDiv(){
       		comboCustomer = new dhtmlXCombo("cus_name","alfa2",150);
	  			 comboCustomer.enableFilteringMode(true);

				proCustomer.reset();
//				proCustomer.obj.typeId;
 			var func = function(xml){
					comboCustomer.clearAll();
					comboCustomer.loadXMLString(xml);
 			}
 			proCustomer.getProCustomersXML(proCustomer.obj,func);
}

function buttonEventFill(){
	var btn_searche = $("search");
	btn_searche.onclick=searchDiv;

}

function searchDiv(){
	    
	var customerName = comboCustomer.getComboText();
	$("proCustomerName").value = customerName;
	$("orderTypeId").value = $("proOrderType").value;
	getPaymentListByCustomer();
}
	
	
function initGrid(){
		var imagePath = ctxPath + "image/grid/";
		mygrid = new dhtmlXGridObject('gridbox');
		mygrid.setImagePath(imagePath);
		mygrid.setHeader("订单号,客户名称,业务员,应付金额,应付时间,已付金额,已付时间,欠款金额");
		mygrid.setInitWidthsP("12,16,12,12,12,12,12,12")
		mygrid.setColAlign("left,left,left,right,right,right,right,right")
		mygrid.setColTypes("ro,ro,ro,ro,ro,ro,ro,ro");
		mygrid.setColSorting("int,str,str,str,str,str,str,str")
		mygrid.enableMultiselect(true)
		mygrid.init();
//		mygrid.loadXML("sampleData/payment_grid.xml");
		
		mygrid.setSkin("modern2");
		mygrid.enableAlterCss("even","uneven");
		//mygrid.setOnRowDblClickedHandler(rowDblClick);
}
	
function rowDblClick(id){
	     window.location.href=ctxPath +"merm/editCustomer.jsp?id="+id;
}

function setProPayMentPara(obj){
	 var page=Math.round(winHeight* 0.80/20)-3;
	 obj.className  = "payMent";	
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= page;
	 obj.page = new Page(obj.pageInfo,obj.pageSize);	
}

function initToolbar(){
		var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml"
		var aToolBar=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo"); 
			aToolBar.setOnClickHandler(onButtonClick);	
			aToolBar.loadXML(toolbarDataPath,callBack);
		 
		function callBack(){
			aToolBar.hideButtons(); 
	        aToolBar.showButtons("4_search,5_print,6_view,7_export,14_chart");  
	        aToolBar.showButtons("div_4,div_5,div_6,div_7,div_14"); 
	                
		}

			aToolBar.showBar();  

}
	
	
function onButtonClick(itemId,itemValue)
	{              
		
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
                reportType: "payment_report",
                headers:headers,
                displaySumColum:"0,0,0,1,0,1,0,1",
                isSum:true,
                isVertical:true,
                customerName: $("proCustomerName").value,
                orderTypeId:$("orderTypeId").value
		};		
		var h = $H(a);	
		if(isChart){
			url = ctxPath +"/merm/paymentChart.jsp?"+ encodeURI(h.toQueryString());
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
		         	$("orderTypeId").value="";
		             getPaymentListByCustomer();
		             return true;
		         }
	         }
	                                        
	         );
	}	

function getPaymentListByCustomer(){
		proOrder.reset();
		var customerName = $("proCustomerName").value;
		if($("orderTypeId").value!=0){
			proOrder.obj.orderTypeId = $("orderTypeId").value;
		}
	 
	 var func = function(xml){
				mygrid.clearAll();
				mygrid.loadXMLString(xml);
				
		 }
	
		proOrder.getPaymentPageXML(customerName,proOrder.obj,func);
}

//翻页处理
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == proOrder.pageInfo){
		var page = new Page(proOrder.pageInfo,proOrder.pageSize);
		page.goNextPage(pageIndex);
		proOrder.page = page;

		getPaymentListByCustomer();
	}

}	