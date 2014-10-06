var matter = new Matter();
var customer = new Customer();
var startOrend;
var selectDays;
var beginDateSel;
callOnLoad(init);	
  
function init(){ 	
	setMatterPara(matter);
	getDate();

	getMatterTable(curDate,"endDate");
 	buttonEventFill();
}
function buttonEventFill(){	
	var btn_search = $("searchMatterBegin");
	btn_search.onclick = searchBegin;
	
	var btn_search = $("searchMatterOver");
	btn_search.onclick = searchOver;
	
	var Sel_days = $("days");
	Sel_days.onchange = searchDays;
	
}
function setMatterPara(obj){
	 
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className   = "matter";	
	 obj.IdPrefix 	 = obj.className + "Id";
	 obj.fillObjName = obj.className + "Body";
	 obj.tableName   = "matterList";
	 obj.tBody 		 = $(obj.fillObjName);
	 obj.color1 	 = "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 	 = "BACKGROUND-COLOR: #ECEFF4";
	 
	 obj.pageInfo 	 = "pageInfo" + obj.className;
	 obj.pageSize 	 = "20";
	 obj.page        = new Page(obj.pageInfo,obj.pageSize); 
}
function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "customerId";
}

function getMatterTable(beginDate,startDate){
	var beginDate = getFormatDay($("beginDate").value,'ymd');
	matter.getMattersByDate(beginDate,startDate);
}

function getDate(){
	Calendar.setup({
		inputField  : "beginDate",	  // id of the input field
//		ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "beginDate"	// id of the button
	});
	
	$("beginDate").value = getFormatDay(curDate,'y/m/d');
}
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == matter.pageInfo){
		var page = new Page(matter.pageInfo,matter.pageSize);
		page.goNextPage(pageIndex);
		matter.page = page;
		
		var beginDate = getFormatDay($("beginDate").value,'ymd');
		if(selectDays =="selectDays"){
			matter.getMattersByDate(beginDateSel,startOrend);
		}else{
			matter.getMattersByDate(beginDate,startOrend);
		}
	}
}
function searchDays(){
	var days = $("days").value;
	var beginDate = getFormatDay($("beginDate").value,'ymd');
	selectDays = "selectDays";
	var d = new Date();
	if(days=="½ñÌì"){
		beginDateSel = curDate;
	}else{
	 var now = new Date(d.getFullYear(), d.getMonth(), d.getDate()+days*1, 0, 0, 0);
	 var y = now.getFullYear();
	 var m = now.getMonth()+1;
	 var dd = now.getDate();
	 var monthStrLength = m.toString().length;
	 var dateStrLength = dd.toString().length;
	 if (monthStrLength < 2){m = '0'+ m}
	 if (dateStrLength < 2) {dd = '0'+ dd}
	 beginDateSel = y.toString()+m.toString()+dd.toString();
	}
	startOrend = "endDate";
	matter.getMattersByDate(beginDateSel,startOrend);
}

function searchBegin(){
	var startDate = "startDate";
	startOrend = startDate;
	var beginDate = getFormatDay($("beginDate").value,'ymd');
	matter.getMattersByDate(beginDate,startDate);
}

function searchOver(){
	var endDate = "endDate";
	startOrend = endDate;
	var beginDate = getFormatDay($("beginDate").value,'ymd');
	matter.getMattersByDate(beginDate,endDate);
}