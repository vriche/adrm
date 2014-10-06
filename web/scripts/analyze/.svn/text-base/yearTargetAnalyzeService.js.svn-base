var user = new User();
var carrier = new Carrier();
var incomePurpose = new IncomePurpose();
var userName ;
var config_serviceDate;
var financeTarget = new FinanceTarget();
var size;
var myprint =new MyPrint();

callOnLoad(init);

function init(){
	
	isDisplayChartParam = _app_params.sysParam.isDisplayChartParam;
	channelModelParam = _app_params.sysParam.channelModelParam;
	config_serviceDate = _app_params.serviceDate.def;
	userName =  _app_params.user.username;	
	
	config_isDisplayStandPrice = _app_params.sysParam.isDisplayStandPrice;
	config_useCarrierAliname = _app_params.sysParam.useCarrierAliname;
    config_useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
    config_withResourceSort = _app_params.sysParam.withResourceSort;//是否启用播出入点(启用1,不启用0)系统参数默认是0;
	
	_make_org_select("orgId",120,"");	
		
	setCarrierPara(carrier);
	setPurposePara(incomePurpose);
	carrier.obj.nodeLevel =1;
//	hiddenChartButton();
//	makeCarrierSelectItem();

	buttonEventFill();
 	//initGrid();
 	resetHeigth();
 	incomePurpose.makeOptionsCallBackFun(incomePurpose,fillFun);	

	function fillFun(objs){
		makeOptionsCheckBoxHtml(objs,"checkbox",incomePurpose.checkBoxName,"name","id","","",[]);     
	}
	
	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
 	financeTarget.getFinanceTargetYear(financeTarget,BackFun)
 	function BackFun(objs){
 		    size = objs.tarMonths.length;
 		    var w = 80/size;
 		    var oneWidth= 100-w*size-1;
 	
 	
 		    financeTarget.heads = "频道,";
 		    financeTarget.widths = oneWidth+",";
 		    financeTarget.colTypes ="ed,";
 		    financeTarget.colAlign ="left,";
 		    financeTarget.colSorting ="str,";
 		    financeTarget.attachFooter ="合计(万)：,";
 		    financeTarget.attachFooter2 = new Array();
                    var stylecss ='text-align:center;'
                    var stylecss2 ='text-align:right;'
 		 //   alert(size)
 		    financeTarget.attachFooter2.push(stylecss);
 		    for(var i = 0 ;i < size;i++){
 		    	financeTarget.heads +=objs.tarMonths[i]+"年"
 		    	financeTarget.widths +=w
 		    	financeTarget.colTypes +="ed";
 		    	financeTarget.colAlign +="right";
 		    	financeTarget.colSorting +="int";
 		    	financeTarget.attachFooter +="<div id='month"+ (i+1) +"'/>";
 		    	financeTarget.attachFooter2.push(stylecss2);
 		    	
 		    	if(i< size-1){
 		    		 financeTarget.heads +=","
 		    		 financeTarget.widths +=","
 		    		 financeTarget.colTypes +=","
 		    		 financeTarget.colAlign +=","
 		    		 financeTarget.colSorting +=","
 		    		 financeTarget.attachFooter +=","
 		    		}
 		    }
 
		initGrid();     
		
		Ext.getBody().unmask();
	}
	
	
	this.myprint.buildButtons(this,"printReportDiv",[0,1,2,6],80);
}

function calculateFooterValues(){
//        var nrQ = document.getElementById("nr_q");
//        nrQ.innerHTML = sumColumn(1)
//        var srQ = document.getElementById("sr_q");
//        srQ.innerHTML = sumColumn(2);
        for(var i=0;i<size;i++){
        	var el = $("month"+(i+1));
        	el.innerHTML = sumColumn(i+1);
        }
        return true;
    }
    
function sumColumn(ind){
        var out = 0;
        for(var i=0;i<mygrid.getRowsNum();i++){
       	var value =mygrid.cells2(i,ind).getValue()==""?0:mygrid.cells2(i,ind).getValue();
            out+= parseFloat(value)
        }
        return out/10000;
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

//function hiddenChartButton(){
//	if(isDisplayChartParam!=1){
//		$("displayChar").hide();
//	}else{
//		$("displayChar").show();
//	}
//}

function setPurposePara(obj){
	 obj.className ="incomepurpose";
	 obj.checkBoxName = obj.className +"RN";
}


function resetHeigth(){
    var dialogcontent = $("dialogcontentDiv");
    var gridbox = $("adResCount");
    
    gridbox.style.height = dialogcontent.offsetHeight * 0.85 +"px";	
   
} 


function buttonEventFill(){
	
	var btn_searche = $("btnSearche");
	btn_searche.onclick=displayDiv;
	
	var btn_searche_close=$("btnSearcheClose");
	btn_searche_close.onclick=closeDiv;
	
	var search = $("search");
	search.onclick = getAllyearTargetInfos;
	
//	var Bt_displayChar = $("displayChar");
//	Bt_displayChar.onclick = getFusionChartObjs;		
//
//	var Btn_view_yearTarget = $("Btn_view_yearTarget");
//	Btn_view_yearTarget.onclick = btn_view_yearTarget;
//
//	var Btn_print_yearTarget = $("Btn_print_yearTarget");
//	Btn_print_yearTarget.onclick = btn_print_yearTarget;	
//	
//	var Btn_export_yearTarget = $("Btn_export_yearTarget");
//	Btn_export_yearTarget.onclick = btn_export_yearTarget;	
	
	var carrierName2 = $("carrierName");
	carrierName2.onclick = displayCarrierTree2; 
	
}

function printReport(mode){
//	 var s=['view','print','excel'];
	 
	if(mode =="view"){
		btn_view_yearTarget();
	}
	if(mode =="print"){
		btn_print_yearTarget();
	}
	if(mode =="excel"){
		btn_export_yearTarget();
	}
	
	if(mode =="chart"){
		getFusionChartObjs();
	}	
   
}

function displayCarrierTree2(){
  var ids = $("carrierName").value;
  var loginUser =  userName;
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
function resetText(ev){
	 $("customerName").value = null;
	 $("customerId").value = null;
}

function btn_view_yearTarget(){
	$("model").value = "view";
	button_print();
}	
function btn_print_yearTarget(){
	$("model").value = "print";
	button_print();
}
function btn_export_yearTarget(){
	$("model").value = "export";
	button_print();
}

function button_print(model){
	$("type").value = $("query").value; 
	$("userName").value=userName;
	$("carrierIdForm").value = $("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
	$("channelModelParam").value=channelModelParam;
	$("headers").value = financeTarget.heads;
	$("size").value = size;
	$("putYearForm").value= $("isPutYear").checked == true?1:0;
	$("returnValue").value= $("isNotReturnValue").checked == true?1:0;
	
	var purpose = getCheckBoxValues("incomePur",1);
	if(purpose == '') purpose.push(-1);
	$("incomPurs").value= purpose.toString();
 

	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");


	reportForm.target = tarForm;
	reportForm.action="reports/jsp/yearTarget_print.jsp";
	reportForm.submit(); 	
}


function getAllyearTargetInfos(){
	closeDiv();
	
	var carrierId = $("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
	var type = $("query").value;
	var theUser = userName;
//	var sortStr = mygrid.getSortingState();
//	//列排序号
//	orderdayinfo.obj.resourceSpecific = sortStr[0]+","+sortStr[1];
	var isPutYear = $("isPutYear").checked == true?1:0;
	var isNotReturnValue = $("isNotReturnValue").checked == true?1:0;
	
	
	var purpose = getCheckBoxValues("incomePur",1);
	if(purpose == '') purpose.push(-1);
	purpose = purpose.toString();

	 var func = function(xml){

				mygrid.clearAll();
				mygrid.loadXMLString(xml);
				calculateFooterValues();	
				Ext.getBody().unmask();				
		 }
	
	if(size>0){
		Ext.getBody().mask('数据加载中……', 'x-mask-loading');
		financeTarget.getYearTargetAnalyzeXml(size,type,carrierId,channelModelParam,theUser,isPutYear,isNotReturnValue,purpose,func);
	}else{
		alert("请给你需要查询的年份设定 年度指标！！！");
	}
}

function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");
	mygrid.setHeader(financeTarget.heads);
	mygrid.setInitWidthsP(financeTarget.widths);
	mygrid.setColTypes(financeTarget.colTypes);
	mygrid.setColAlign(financeTarget.colAlign);
	mygrid.setColSorting(financeTarget.colSorting) ;
    mygrid.setMultiLine(false);
	mygrid.setEditable(false);
    mygrid.setSkin("modern2");
    mygrid.enableAlterCss("even","uneven"); 
	mygrid.init();	 
	mygrid.setSortImgState(true,0,"ASC"); 
	mygrid.attachFooter(financeTarget.attachFooter,financeTarget.attachFooter2);
	 //mygrid.ftr.rows[0].hide();
	//mygrid.attachHeader('aaaaaaaaaa,sum{#daokuan},#cspan1,#cspan2,#cspan3,#cspan4',[],'_aFoot');
}


//var fusionChartObjects;
//
//
function getFusionChartObjs(){
	 
	var type = $("query").value;
	var carrierId = $("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
	var theUser = userName;
	var isPutYear = $("isPutYear").checked == true?1:0;
	var returnValue = $("isNotReturnValue").checked == true?1:0;
    
	var incomPurs = getCheckBoxValues("incomePur",1);
	if(incomPurs == '') incomPurs.push(-1);
	incomPurs = incomPurs.toString();
	
	
	function func(objs){
		fusionChartObjects = objs;
		alert(fusionChartObjects.length);
	}
	

	
	//startDate,endDate,sorCol,sorType,putYear
	if(size>0 ){
		
		var a = {
//			    headers:financeTarget.heads,
			 	type: type,
                carrierId: carrierId,
                size: size,
                isPutYear: isPutYear, 
                channelModelParam: channelModelParam,
                theUser: theUser,
                incomPurs: incomPurs,
                returnValue: returnValue
		};		
		 
        var h = $H(a);
 
		var url = "yearTargetAnalyzeChart.html?"+h.toQueryString();
 
		window.open(url);
		
	}else{
		
		alert("请给你需要查询的年份设定 年度指标！！！");
	}
	
	
}
