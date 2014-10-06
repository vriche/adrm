var user = new User();
var carrier = new Carrier();
var incomePurpose = new IncomePurpose();
var userName ;
var config_serviceDate;
var financeTarget = new FinanceTarget();
var size;
var report =new MyPrint();
var resourceChannel = new ResourceChannel();
var ctxPath;

callOnLoad(init);


function init(){
	
	ctxPath =  _app_params.ctxPath;	 
	isDisplayChartParam = _app_params.sysParam.isDisplayChartParam;
	channelModelParam = _app_params.sysParam.channelModelParam;
	config_serviceDate = _app_params.serviceDate.def;
	userName =  _app_params.user.username;	
	
	config_isDisplayStandPrice = _app_params.sysParam.isDisplayStandPrice;
	config_useCarrierAliname = _app_params.sysParam.useCarrierAliname;
    config_useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
    config_withResourceSort = _app_params.sysParam.withResourceSort;//是否启用播出入点(启用1,不启用0)系统参数默认是0;
	
	
	_make_adrm_sys_year_select("order_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);
	
	_make_org_select("orgId",120,"");	
	

	buttonEventFill();
	
 	initGrid();
 	
 
 	$("month").value = getFormatDay(_app_params.serviceDate.format2,"m");
 	$("order_year").value = getFormatDay(_app_params.serviceDate.format2,"y");
 
	

	this.report.buildButtons(this,"printReportDiv",[0,1,2],70);
}

function getAllyearTargetInfos(){

	 var func = function(xml){
				mygrid.clearAll();
				mygrid.loadXMLString(xml);	
				Ext.getBody().unmask();				
		 }
	
	if(size>0){
		Ext.getBody().mask('数据加载中……', 'x-mask-loading');
//		financeTarget.getYearTargetAnalyzeXml(size,type,carrierId,channelModelParam,theUser,isPutYear,isNotReturnValue,purpose,func);
	}
}

function initGrid(){
	var callback =function(objs){
		size = objs.length;
		initGridHead(objs);
   		resetHeigth(); 
   		fillGridFixRow();
	}
	
	resourceChannel.obj.enable =1;
	resourceChannel.getResourceChannels(resourceChannel.obj,callback);
	
}

function initGridHead(objs){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");
	var flds=',统计指标(万),';
	var initWidthsP = '3,12,';
	var colAlign = 'center,left,';
	var colTypes = 'ed,ed,';
	
	displaySumColum = '0,';
	
	for(var i=0;i<objs.length;i++){
		flds+=objs[i].name+',';
		initWidthsP+='9,';
		colAlign+='right,';
		colTypes +='ed,';
		displaySumColum +='1,';
	}
	flds += "合计";
//	initWidthsP+=',';
	colAlign +='right';
	colTypes +='ed';
	displaySumColum +='1';
	var sum=0;
	for(var i =0;i<initWidthsP.split(',').length;i++){
			sum+=initWidthsP.split(',')[i]-0; 
	}

	initWidthsP+=(100-sum);
	 
	headers = flds;
//	alert(headers)
//	alert(initWidthsP)
	mygrid.setHeader(flds);
	mygrid.setInitWidthsP(initWidthsP);
	mygrid.setColAlign(colAlign);
	mygrid.setColTypes(colTypes);
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	mygrid.enableCollSpan(true);
	mygrid.setSkin("modern2");
	mygrid.enableAlterCss("even","uneven"); 
	
	
				            mygrid.headers = headers;
			                mygrid.displaySumColum = displaySumColum;
			                mygrid.colAlign = colAlign;
			                mygrid.colTypes= colTypes;
			                mygrid.widthsP = initWidthsP;

	
	mygrid.init();
//	mygrid.groupBy(0);
//	mygrid.collapseAllGroups();
//	console.log(mygrid.hdr)
//	console.log(mygrid.hdr.rows[0])
//	console.log(mygrid.hdr.rows[1])
//	
//	var rowId = mygrid.hdr.rows[1].idd;
//	alert(rowId);
//	mygrid.setColspan(rowId,0,2);


				
						
}

function fillGridFixRow(k){
	var sb;
	var col1 =['累','计','本','期'];
	var col2 =['收入任务数','实际到款额','实到款任务完成率','载播量','载播量任务完成率','载播量到款额','载播量实际到款率','载播量超欠款率','合同应收额','合同实收额','合同欠款率','收入任务数','实际到款额','实到款任务完成率','载播量','载播量任务完成率','载播量到款额','载播量实际到款率','载播量超欠款率'];
  	
	sb = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	sb = sb + "<rows>";  
			
	for(var i = 0;i<col2.length;i++){
				
			sb +=  "<row  id=\""+ i +"\"" +">";
			var vv = "";
	
			if(i==0) vv =col1[0];
			if(i==1) vv =col1[1];
			if(i==10) vv =col1[2];
			if(i==11) vv =col1[3];
			
			sb += "<cell><![CDATA["+ vv   +"]]></cell>";
			
			sb +="<cell><![CDATA["+ col2[i]   +"]]></cell>";
			
				for(var j = 0;j<size;j++){
					sb +="<cell></cell>";
				}
	
			sb +="</row>";						
	}

	sb = sb + "</rows>";  
		    
	function aa(){
//		mygrid.setSizes();
//        if(k){
//       		mygrid.groupBy(0);
//		mygrid.collapseAllGroups(); 	
//        }

	}		    
		    
		    
	mygrid.clearAll();
	mygrid.loadXMLString(sb,aa);	

	

//	for(var i = 0;i<10;i++){
//		mygrid.setColspan(i,0,2);
//	}
	
	
	
}	

function getLoadDataParams(){
	var orgId = $("orgId").value;
	var year = $("order_year").value;
	var month = $("month").value;
	var paramObj = {
		year:year,
		month:month,
		orgId:orgId
	}
	return paramObj;		
}
function loadData(){
	var paramObj = getLoadDataParams();
	var searchQuery =  $H(paramObj).toQueryString();
	var callBakFn = function(objs){
		for(var i =0;i<objs.length;i++){
			for(var j =0;j<size;j++){
//				console.log(objs[i].value1)
				eval('var v = objs['+ i +'].value'+(j+1));
				if(v) mygrid.cells(i,j+2).setValue(v);
				
			}
			if(objs[i].sum1) mygrid.cells(i,size+2).setValue(objs[i].sum1);
		}
		Ext.getBody().unmask();
	};
	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
 	financeTarget.getIncomeRelpayQiankArray(searchQuery,callBakFn);	
}
 

function resetHeigth(){
    var dialogcontent = $("dialogcontentDiv");
    $("gridbox").style.height = dialogcontent.offsetHeight * 0.85 +"px";	
} 
function buttonEventFill(){
	
	var btn_searche = $("btnSearche");
	btn_searche.onclick=loadData;

}

function printReport(model){
//	 var s=['view','print','excel'];
	 
//	var tarForm =  $("tarForm");
//	var reportForm = $("ReportForm");
//
//
//	reportForm.target = tarForm;
//	reportForm.action="reports/jsp/yearTarget_print.jsp";
//	reportForm.submit(); 	


	var param = getLoadDataParams();
	var printParam = {
							model:model,
							title:param.year+'年广告到款、载播量、合同欠款统计分析表',
			                reportType: "adIncomeRelpayQiank_report",
			                reportFile:'adIncomeRelpayQiank_report.jasper',
//			                headers:mygrid.headers,
			                headers:"1,统计指标(万),一套,二套,三套,四套,五套,六套,七套,八套,合计",
			                displaySumColum:mygrid.displaySumColum,
			                colAlign:mygrid.colAlign,
			                colTypes:mygrid.colTypes,
			                widthsP:mygrid.initWidthsP,
			                isSum:false,
			                isVertical:true
		}; 	
		
	 var aa = Object.extend(param,printParam);

	 report.loadApplet(aa,ctxPath,800,500);	
   
}


