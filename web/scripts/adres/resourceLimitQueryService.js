var carrierType = new CarrierType();
var carrier =new  Carrier();
var resource = new Resource();
var customerProduct = new CustomerProduct();
var customer = new Customer();
var resourceLimit = new ResourceLimit();
var resource_year;

var mygrid;

callOnLoad(init);	

function init(){
	channelModelParam = _app_params.sysParam.channelModelParam;
    config_serviceDate = _app_params.serviceDate.def;
    
    
    _make_adrm_sys_year_select("resource_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);
    
	get_cur_year();

	setCarrierPara(carrier);

	setResourcePara(resource);
	setResourceLimitPara(resourceLimit);
	setCustomerProductPara(customerProduct);
	
	
	
	getDate();
	buttonEventFill();
	initGrid();
	var fct = function(){ }
	initCarrier(fct);
	
	resetHeigth();
}
function initCarrier(fct){
	carrier.obj.nodeLevel =1;
	carrier.obj.enable = false;
	carrier.obj.version = resource_year;
	
	
	//根据是否分频道，取得频道下拉列表
	function fnct(){
		if(fct) fct();
	}
	if(channelModelParam!=1){
		carrier.makeSelectItemFromMapOrderList(carrier.obj,"carrierName","",fnct);
	}else{
		carrier.makeSelectItemAnalyze3(carrier,"carrierName","",100,true,fnct);
	}	
		
}
function get_cur_year(){
	var yyyy = getDayPar(config_serviceDate,'y');
	setSelectByValue($("resource_year"),yyyy);
	resource_year = $("resource_year").value;
}

function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");

	var flds = "开始,结束,月份,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,规定";
	mygrid.setHeader(flds);
	
	var columnIds = "resourceName1,resourceName2，month,dayTimes[0]," 
					+"dayTimes[1],dayTimes[2],dayTimes[3],dayTimes[4],dayTimes[5],"
					+"dayTimes[6],dayTimes[7],dayTimes[8],dayTimes[9],dayTimes[10],"
					+"dayTimes[11],dayTimes[12],dayTimes[13],dayTimes[14],dayTimes[15],"
					+"dayTimes[16],dayTimes[17],dayTimes[18],dayTimes[19],dayTimes[20],"
					+"dayTimes[21],dayTimes[22],dayTimes[23],dayTimes[24],dayTimes[25],"
					+"dayTimes[26],dayTimes[27],dayTimes[28],dayTimes[29],dayTimes[30],"
					+"total";
	mygrid.setColumnIds(columnIds);

	mygrid.setInitWidthsP("5,5,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,4");
//	mygrid.setInitWidthsP("5,5,3,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4");

	mygrid.setColAlign("left,left,center,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right")
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	mygrid.setDragBehavior("nextSibling"); //nextSibling complex
//	mygrid.enableRowsHover(true,'grid_hover')
//	mygrid.setOnRowSelectHandler(doOnRowSelected);
	mygrid.enableDragAndDrop(false);
//  mygrid.lockRow(3,true);
	mygrid.init();	 
}

function resetHeigth(){
	var dialogcontent = $("dialogcontentDiv");
	var adResCount = $("adResCount");
	adResCount.style.height = (dialogcontent.offsetHeight -dialogcontent.offsetTop)*0.9 +"px";	
} 



	
function setCustomerProductPara(obj){
	obj.enableEdit	= true;
	obj.enableDel	= true;
	 
	obj.className = "customerProduct";
	obj.IdPrefix 	= obj.className + "Id";
	obj.tableName   = obj.className + "List";
//	obj.fillObjName = obj.className + "TBody";
	obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
//	obj.tBody 		= $(obj.fillObjName);
	 
	obj.pageInfo 	= "pageInfo_" + obj.className;
	obj.pageSize 	= "20";
	 
	obj.page = new Page(obj.pageInfo,obj.pageSize);

}
function setCarrierPara(obj){
	obj.className  = "carrier";
	obj.IdPrefix 	= obj.className + "Id";
}
function setResourcePara(obj){
	obj.className  = "resource";
 	obj.IdPrefix 	= obj.className + "Id";
}
function setResourceLimitPara(obj){
	obj.className  = "resourceLimit";
	obj.IdPrefix 	= obj.className + "Id";
	obj.pageSize 	= "0";
	obj.page = new Page(obj.pageInfo,obj.pageSize);
}


function getDate(){

    var month = theMonth-1;
	var endDay = getMonthEndDay(theYear,month);
	
	Calendar.setup({
		inputField  : "beginDate",	  // id of the input field
//		ifFormat	: "%Y%        m%d",	  // the date format
		singleClick	  : true,
		button	  : "beginDate"	// id of the button
	});
	
	Calendar.setup({
		inputField  : "overDate",	  // id of the input field
//		ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "overDate"	// id of the button
	});
	$("beginDate").value = getFormatDay(curDate,'y/m/d');
	$("overDate").value= theYear+'/'+theMonth+'/'+endDay;
	
}
function getMonthEndDay(theYear,month){
	//Date._MD = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
	var days = new Array();
	days.push(31);
	days.push(28);
	days.push(31);
	days.push(30);
	days.push(31);
	days.push(30);
	days.push(31);
	days.push(31);
	days.push(30);
	days.push(31);
	days.push(30);
	days.push(31);
	if (typeof month == "undefined") {
		month = this.getMonth();
	}
	if (((0 == (theYear % 4)) && ( (0 != (theYear % 100)) || (0 == (theYear % 400)))) && month == 1) {
		return 29;
	} else {
		return days[month];
	}
}
function buttonEventFill(){
	var btn_search=$("searchRes");
	btn_search.onclick=search;

	var Btn_view_queryAdre = $("Btn_view_queryAdre");
	Btn_view_queryAdre.onclick = btn_view_queryAdre;

	var Btn_print_queryAdre = $("Btn_print_queryAdre");
	Btn_print_queryAdre.onclick = btn_print_queryAdre;	
	
	var Btn_export_queryAdre = $("Btn_export_queryAdre");
	Btn_export_queryAdre.onclick = btn_export_queryAdre;	
	
	var change_resource_year = $("resource_year");
	change_resource_year.onchange = resetYear;
	
	
}

function resetYear(){
	resource_year = $("resource_year").value;
	
	 var beginDate= $("beginDate").value;
	 var overDate= $("overDate").value;
	 beginDate = resource_year  + beginDate.substring(4,beginDate.length);
	 overDate = resource_year  + overDate.substring(4,overDate.length);
	 $("beginDate").value = beginDate;
	 $("overDate").value = overDate;
}


function btn_view_queryAdre(){
	 $("model").value = "view";
	// $("reportType").value = "queryAdre_report";
	 button_print();
}	
function btn_print_queryAdre(){
	 $("model").value = "print";
	 //$("reportType").value = "queryAdre_report";
	 button_print();
}
function btn_export_queryAdre(){
	 $("model").value = "export";
	// $("reportType").value = "queryAdre_report";
	 button_print();
}
function button_print(){
//	alert(11);
     $("reportType").value = "resourceLimit_report";
	$("carrierIdForm").value =$("carrierName").value;
	$("startDateForm").value = getFormatDay($("beginDate").value,'ymd');
	$("endDateForm").value = getFormatDay($("overDate").value,'ymd');
	$("yearForm").value = resource_year;
	$("typeFrom").value = $("seach_type").value;


	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");

//	alert(22);
	reportForm.target = tarForm;
	reportForm.action="reports/jsp/common_reports.jsp";
	reportForm.submit(); 	
}

function searchyear(beginDate,endDate){
	var beginYear = getFormatDay(beginDate,'y');
	var endYear = getFormatDay(endDate,'y');
	var ispass = true;
	
	
 	if(beginDate == null || endDate == null){
		alert("请选择日期");
		ispass =  false;
		return ispass;
	}
	
	if(beginDate > endDate){
		alert("开始日期不能大于结束日期");
		ispass =  false;
		return ispass;
	}	
	
	if(resource_year!=beginYear || resource_year!=endYear){
		alert("选定年份应该等于实际年份");
		ispass =  false;
	}

	return ispass;
}


function search(){
	var beginDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
	var carrierId = $("carrierName").value;
	var seachType = $("seach_type").value;
	
	
	var isPass = searchyear(beginDate,endDate);
	if(!isPass) return false;
	
	
	if(carrierId > 0){
		
			var func = function(xml){
				//alert(xml);
			    mygrid.clearAll();
				mygrid.loadXMLString(xml);

			}

			resourceLimit.reset();
			resourceLimit.obj.carrierId = carrierId;
			resourceLimit.obj.version = resource_year;
			resourceLimit.obj.startTime = beginDate,
			resourceLimit.obj.endTime = endDate;
			resourceLimit.obj.preT = seachType;
			
	        resourceLimit.getResourceLimits(func,2);
		//customerProduct.getTreeGrid(beginDate,endDate,resIds,customerId,func);	
			
		//	customerProduct.getResourceByDate(beginDate,endDate,resIds,func);
			
		
	}else{
		alert("请选择资源");
	}
}

function showTree(bln){
	if(bln){
		$("treebox").show();
		
		$("customerProduct_div").hide();
	}else{
		var dialogcontent = $("dialogcontentDiv");
		$("treebox").hide();

		$("customerProduct_div").show();
		$("customerProduct_div").style.width=dialogcontent.offsetWidth*0.9+"px";
		
	}
}



