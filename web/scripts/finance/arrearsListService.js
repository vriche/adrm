 var order = new Order();
 var orderCategory = new OrderCategory();
 var checkState = new OaWorkFlowCheckState();
 var user = new User();
 var customer = new Customer();
 var category = new Category();
 var customerType = new CustomerType();
 var matter = new Matter();
 var carrier =new  Carrier();
 var resourceSort = new ResourceSort();
 var carrierType = new CarrierType();
 var report = new MyPrint();
 var financeTarget =new FinanceTarget();
 
 var channelModelParam;
 var config_serviceDate;
 var useCarrierAliname;
 var curSessionId;
 var carrSortIds;
 var mygrid;
 var myUtils = new MyUtils();
 var scrollTop = 0;
 var posStart = 0;
// var posCount = 0;
 var total_count = 0;
 var fromEditRowId = 0;
 var initparamObj ={};
 var f_int = false;
 var ctxPath;
 var order_check_right;
 var defOrgIds;
 var order_year;
 
 callOnLoad(init);	
 
 
 
 function init(){

 	ctxPath =  _app_params.ctxPath;	 	
 	config_serviceDate = _app_params.serviceDate.def;
 	cur_month = _app_params.serviceDate.month;
 	userName =  _app_params.user.username;
 	channelModelParam = _app_params.sysParam.channelModelParam;
 	tvNameParam =  _app_params.sysParam.tvNameParam;
 	withoutSubmit =  _app_params.sysParam.withoutSubmit;
 	useCarrierAliname =  _app_params.sysParam.useCarrierAliname;
 	useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
 	order_check_right =  _app_params.rights.tag_orderList_check;
 	config_channelModelParam = _app_params.sysParam.channelModelParam;
	config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;

 	

 	getDate(_app_params.serviceDate.year);
 	
 	 var srcStr= window.location.href;
 	 scrollTop  = getParamFromUrl(srcStr,"scrollTop");	
 	 posStart = getParamFromUrl(srcStr,"posStart");	
     total_count = getParamFromUrl(srcStr,"total_count");	

 	
    this.ctxPath = ctxPath;
	this.report.buildButtons(this,"printReportDiv",[0,1,2],80);
 	

	carrier.obj.nodeLevel =1;
	carrier.obj.enable = false;
	

	
 	_make_org_select("orgId",120,"loadGridData");	
 	
    category.obj.loginUser = userName;
 	category.makeSelectAnalyze("customerCategorys","loadGridData",function(){ });


 	buttonEventFill();
 	

 	
 	initGrid();	
 	
 	resetHeigth();	
 	

 }
 

 function buttonEventFill(){

		
	var change_order_year = $("order_year");
	change_order_year.onchange = loadGridData;

	
	var Btn_customerCategorys = $("customerCategorys");
	Btn_customerCategorys.onchange = loadGridData;	
		
	var carrierName2 = $("carrierName");
	carrierName2.onclick = displayCarrierTree2; 	
	
			
 	var Btn_selectOrder = $("query");
 	Btn_selectOrder.setAttribute("href","javascript:void 0");
	Btn_selectOrder.onclick = loadGridData;		
 }
 
 
 
function displayCarrierTree2(){
  var ids = $("carrierName").value;
  var loginUser =  userName;
  var orgId = config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;
  
    
  
  var urlStr="selectPopup/selectUserCarrierRel.html?mode=2&loginUser="+loginUser+"&ids="+ids +"&useCarrierAliname="+useCarrierAliname +"&orgId="+ orgId;
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
  		
  		loadGridData();
   	} 
   win.on({'close': {fn: removeWin}});   
    
}
 
  function resetHeigth(){
    var dialogcontent = $("dialogcontentDiv");
    var gridbox = $("gridbox");
    gridbox.style.height = dialogcontent.offsetHeight * 0.86 +"px";	
} 

function getDate(order_year){
	

	$("order_year").value = order_year;
	$("beginDate").value = getFormatDay(order_year + ''+ cur_month +'01','y/m/d');
	$("overDate").value= getFormatDay(order_year + ''+ cur_month +'31','y/m/d');
	
	
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



 function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = false;
	mygrid.setImagePath("image/grid/");
	var	flds = "客户名称,应收,到账,欠款";
	mygrid.flds = flds;
	var	columnIds =  "name,opter,opter2,opter3";  
	mygrid.setHeader(flds);
	mygrid.setColumnIds(columnIds);
    mygrid.setInitWidthsP("40,20,20,20");
    mygrid.setColSorting("str,int,int,int");
	mygrid.setColAlign("left,right,right,right");
	mygrid.setColTypes("ed,ed,ed,ed,ed");
	mygrid.setEditable(false);

//	mygrid.setOnScrollHandler(OnScrollHandler);
	mygrid.setSkin("modern2");
	mygrid.enableAlterCss("even","uneven");
	
	
	
	

	mygrid.enableMultiselect(true); 
	mygrid.enableKeyboardSupport(true);  
//	mygrid.setOnRowSelectHandler(onRowSelected,true);
//	mygrid.setOnRowDblClickedHandler(onRowDblClicked,true);


	mygrid.init();	
	
	mygrid.attachHeader("合计,,,","color:black;text-align:center;,color:black;text-align:right;,color:black;text-align:right;,color:black;text-align:right;,color:black;text-align:right;","_aFoot");
		
	loadGridData(posStart);
}
 	
 	

 function loadGridData_bak(posStart){
        var paramObj = getLoadDataParams(posStart);
	 	mygrid.clearAll();
	 	mygrid.detachFooter(0);
		mygrid.enableSmartRendering(true);
		loadDataURL ="servlet/orderListServlet?" + $H(paramObj).toQueryString();		
		mygrid.loadXML(loadDataURL); 		
		mygrid.setSizes();	
 }
 
 
 function loadGridData(posStart){
 	
 	 var paramObj = getLoadDataParams(posStart);
 	 
     function getFun(xml){
//     	    alert(xml);
    	    mygrid.clearAll();
			mygrid.loadXMLString(xml);
			attachHeaderNew(mygrid);
			Ext.getBody().unmask();
			
			mygrid.setSizes();	
    }	
    
  	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
  	
  
	financeTarget.getArrearsXML($H(paramObj).toQueryString(),getFun);
    
 } 
 

function attachHeaderNew(grid){
	var rows = grid.getRowsNum();
	var lastId = grid.getRowId(rows-1);
	var cl_1 = (rows == 0)?"": grid.cells2(lastId,1).getValue()*1;
	var cl_2 = (rows == 0)?"": grid.cells2(lastId,2).getValue()*1;
	var cl_3 = (rows == 0)?"": grid.cells2(lastId,3).getValue()*1;


	var htm ="#rspan,"+ cl_1 +","+ cl_2 +","+ cl_3 +"";

	var h = htm.split(",");
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
 
 
 
 
function button_view_order(){
	 printReport("view");
}	
function button_print_order(){
	 printReport("print");
}
function button_print_export(){
	 printReport("export");
}
function printReport(model){
	
	 var paramObj = getLoadDataParams();
	 	  
	 var printParam = {
					model:  model,
				 	title:'欠款浏览',
	                reportType: "arrearsList",
	                reportFile:'',
	                headers:mygrid.flds, 
	                displaySumColum:"0,1,1,1",
	                widthsP:"40,20,20,20",
	                colAlign:"left,right,right,right",
	                colTypes:"ed,ed,ed,ed,ed",
	                isSum:true,
	                isVertical:false
	 }; 
	 
	 

	 
    var a = Object.extend(paramObj,printParam);
 	 
//	  var h = $H(c);	
//	  alert(h.toQueryString());
        

	 report.loadApplet(a,ctxPath,800,500);	
	        
	
}


 function getLoadDataParams(posStart){
 	
	var carrierId = $("carrierName").value;
	carrierId = carrierId == 'undefined' ||isUndefined(carrierId)||carrierId==null?'':carrierId;

	var cutCates = $("customerCategorys").value;
	cutCates = cutCates == 'undefined' ||isUndefined(cutCates)||cutCates==null||cutCates == ''?'1':cutCates;
	
	var paramObj = {
					loginUser: userName,
	                carrierIds: carrierId,
	                cutCates: cutCates,
	                startDate:getFormatDay($("beginDate").value,'ymd'),
	                endDate:getFormatDay($("overDate").value,'ymd'),
	                year:$("order_year").value,
	                orgId: $("orgId").value
		};	
		
		return paramObj;

 }
 
 
 
 
 
 
 
 
 
 	