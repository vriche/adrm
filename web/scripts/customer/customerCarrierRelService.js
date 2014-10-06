var ctxPath;
//var myDate = new MyDate();
var proProgramType = new ProProgramType();
var proProgram = new ProProgram();
var proOrder = new ProOrder();
var proCheckIdea = new ProCheckIdea();
var user = new User();
var comboCusName ;
var carrier = new Carrier();
var resource=new Resource();
var customerCarrierRel = new CustomerCarrierRel();
var proCustomer = new ProCustomer();
var proCustomerType = new ProCustomerType();
var config_serviceDate;
var oaWorkFlowCheckState = new OaWorkFlowCheckState();
var mygrid;
var theOldValue=null;
var selectId=null;
var isPermitAccessOtherLine=true;
var orderIndex=null;
var isFirstAccess=true;
var theFirstCarrierValue=null;
var theFirstCarrierCell=null;
var theNewValue=null;
callOnLoad(init);


function init(){

    
    winHeight = self.innerHeight*0.93; 
	winWidth = self.innerWidth*0.98;
	
	ctxPath = getCtxPath();	
	config_serviceDate = _app_params.serviceDate.def;
	userName =  _app_params.user.username;
	customerId = getParamFromUrl(document.location.href,"id");
	channelModelParam = _app_params.sysParam.channelModelParam;
	
	setCarrierPara(carrier);
	setResourcePara(resource);
	setCustomerCarrierRelPara(customerCarrierRel);
    initGrid();
    initToolbar();
    getCustomerCarrierRelXML();
}


function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}

function setResourcePara(obj){
	 obj.className  = "resource";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}
function initGrid(){
	var imagePath = ctxPath + "image/grid/";
	
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath(imagePath);
	mygrid.selMultiRows = true;
	var flds = "序,载体,资源,时长,开始日期,结束日期";
	mygrid.setHeader(flds);
    mygrid.setInitWidthsP("5,20,25,10,20,20");
	mygrid.setColAlign("center,left,left,left,left,left");
	mygrid.setColTypes("ro,coro,coro,ed,calendar,calendar");
	mygrid.setDateFormat("y/m/d");
	mygrid.setColSorting("int,str,str,int,date,date");
	makeCarrierSelectItem();
	getResourceSelectItem();
	mygrid.enableAlterCss("even","uneven"); 
    mygrid.setMultiLine(false);
	mygrid.setEditable(true);
	
//	mygrid.enableDragAndDrop(false);
    mygrid.setSkin("modern2");
	mygrid.init();
	mygrid.setColumnIds('0,1,2,3,4,5');	
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

	var K =  (ev.type == "keydown")? ev.keyCode : ev.which;

  	if(ev.type == "mousedown"){		

  		//selectId=mygrid.getSelectedId();
		//theOldValue=getCellValue(selectId,1);
	if(!ev.target.previousSibling.previousSibling){
  		theOldValue=mygrid.cells4(ev.target).getValue();
  		orderIndexObj=ev.target.previousSibling;
  		if(orderIndex==null){
  			isFirstAccess=false;
  			theFirstCarrierCell=ev.target;
  			theFirstCarrierValue=theOldValue;
  		}else{
  			isFirstAccess=true;
  		}

  		if(theFirstCarrierValue!=mygrid.cells4(theFirstCarrierCell).getValue()&&orderIndex!=mygrid.cells4(orderIndexObj).getValue()&&isFirstAccess){
  			alert("选正行的载体已改变,请选择相应的资源");return false;
  		}
		orderIndex=mygrid.cells4(orderIndexObj).getValue();
	}else{
  		var orderIndexObj2=ev.target.previousSibling.previousSibling;
		var orderIndex2=mygrid.cells4(orderIndexObj2).getValue();
		
		var carrierObj=ev.target.previousSibling;
		
		if(theNewValue!=null) {
			theLastClickValue=theNewValue;
		}else{
			theLastClickValue=mygrid.cells4(carrierObj).getValue();
		}
		
		theNewValue=mygrid.cells4(carrierObj).getValue();
		
		//var isEqualInSameLine=mygrid.cells4(orderIndexObj.nextSibling).getValue()==theOldValue;
		var isEqualInSameLine;
		if(theFirstCarrierCell==null){
			isEqualInSameLine=true;
		}else{
			isEqualInSameLine=theFirstCarrierValue==mygrid.cells4(theFirstCarrierCell).getValue();
		}		

		if(!isEqualInSameLine&&orderIndex!=orderIndex2){
			isPermitAccessOtherLine=false;
			alert("选正行的载体已改变,请选择相应的资源");return false;
		}else if(isEqualInSameLine){
			getResourceSelectItem(theLastClickValue);		
		}else{
			getResourceSelectItem(theNewValue);
  			mygrid.cells4(ev.target).setValue("");
  			//theOldValue=mygrid.cells4(ev.target.previousSibling).getValue();
  			theFirstCarrierValue=mygrid.cells4(theFirstCarrierCell).getValue();
  			orderIndex=null;
		}
  	}
  	}	
}
var cellClick2 = function(el, ev) {
	var K =  (ev.type == "keydown")? ev.keyCode : ev.which;
	
  	if(ev.type == "mousedown"){
  		
  	var orderIndexObj2=ev.target.previousSibling.previousSibling;
	var orderIndex2=mygrid.cells4(orderIndexObj2).getValue();

	var carrierObj=ev.target.previousSibling;
	var theNewValue=mygrid.cells4(carrierObj).getValue();
			
	var isEqualInSameLine=mygrid.cells4(orderIndexObj.nextSibling).getValue()==theOldValue;
	
	if(!isEqualInSameLine&&orderIndex!=orderIndex2){
		isPermitAccessOtherLine=false;
		alert("选正行的载体已改变,请选择相应的资源");return false;
	}else if(isEqualInSameLine){
		getResourceSelectItem(theNewValue);		
	}else{
		getResourceSelectItem(theNewValue);
  		mygrid.cells4(ev.target).setValue("");
  		theOldValue=mygrid.cells4(ev.target.previousSibling).getValue();
	}
  		///var id=mygrid.getSelectedId();
		//var theNewValue=getCellValue(id,1);

		//if(theNewValue!=theOldValue&&theOldValue!=null){
			
			//var row=mygrid.getRow(ev.target);
			
			//var carrierValue=row.firstChild.data;
			
			//alert(carrierValue);
			
  	//		getResourceSelectItem(theNewValue);
  	//		mygrid.cells4(ev.target).setValue("");
  //		}else{
  /	//		getResourceSelectItem(theNewValue);
  //		}
  		//orderIndex=orderIndex2;
  		//theOldValue=null;
  	}	
}
var addEventAction=function(){
	var ids=getCarrierId();
	for(var i=0;i<ids.length;i++){
		add_evs(mygrid.cellAll(ids[i],1));
		add_evs(mygrid.cellAll(ids[i],2));	
	}		
}
 function getCarrierId(){
	var rows = mygrid.getRowsNum();
   	 var ids = new Array();
	for(var i=0;i<rows;i++){
		var id = mygrid.getRowId(i);
		ids.push(id);
	}
	return ids;
}
function getResourceSelectItem(carrierId){
	resource.obj.carrierId  = carrierId;

	//if(carrierId==""||carrierId=="null") return false;
	$(resource.selectName).value = 0;

	resource.obj.resourceYear = getFormatDay(config_serviceDate,'y');
	resource.makeResourceSelect(resource.obj,$(resource.selectName),"",getResourceCombo);

}

 function makeCarrierSelectItem(){
 	
 	carrier.reset();
	//carrier.obj.parentId = 0;
	//carrier.obj.enable = true;
	carrier.obj.version = getFormatDay(config_serviceDate,'y');
	
	carrier.makeCarrierSelect(carrier.obj,carrier.selectName,"",getCarrierCombo);		
}
function getCarrierCombo(event){
	var el = $(carrier.selectName);
	var inputs = el.getElementsByTagName("option");
	var command = mygrid.getCombo(1);
	var arr = getCarrierIds();
	command.clear();
	inputs = $A(inputs);
	inputs.each(function(ip){
	    if(ip.value!=0){
		command.put(ip.value,el.options[ip.index].text);

	   }	
	});
}
function getResourceCombo(event){
	var el = $(resource.selectName);
	var inputs = el.getElementsByTagName("option");
	var command = mygrid.getCombo(2);
	var arr = getResourceIds();
	command.clear();
	inputs = $A(inputs);
	inputs.each(function(ip){
	    if(ip.value!=0){
		command.put(ip.value,el.options[ip.index].text);		
	   }	
	});
}
 function getCarrierIds(){
	var rows = mygrid.getRowsNum();
   	 var ids = new Array();
	for(var i=0;i<rows;i++){
		var id = mygrid.getRowId(i); 
		ids.push(getCellValue(id,1));
	}
	return ids;
}
 function getResourceIds(){
	var rows = mygrid.getRowsNum();
   	 var ids = new Array();
	for(var i=0;i<rows;i++){
		var id = mygrid.getRowId(i); 
		ids.push(getCellValue(id,2));
	}
	return ids;
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
        aToolBar1.showButtons("1_new,2_delete,3_save");  
        aToolBar1.showButtons("div_1,div_2,div_3"); 
	}
	aToolBar1.showBar();  
}

function onButtonClick(itemId,itemValue){ 
	if(itemId=='1_new') btnAddRow();
	if(itemId=='2_delete') deleteChecks();
	if(itemId=='3_save') btnSaveRow();
}
function btnSaveRow(){
		var rowId = mygrid.getSelectedId();
		var isPass=isCheckPass(rowId);
		if(!isPass) return false;
		if(rowId > 0){
			customerCarrierRel.reset();
			customerCarrierRel.obj.id = rowId;
			customerCarrierRel.obj.customerId = customerId;
			customerCarrierRel.obj.carrierId = getCellValue(rowId,1);
			customerCarrierRel.obj.resourceId = getCellValue(rowId,2);
			customerCarrierRel.obj.length = getCellValue(rowId,3);
			customerCarrierRel.obj.startDate = getFormatDate(getCellValue(rowId,4),'ymd');
			customerCarrierRel.obj.endDate = getFormatDate(getCellValue(rowId,5),'ymd');

			customerCarrierRel.obj.version= getFormatDay(config_serviceDate,'y');

			var func = function(id){
				mygrid.changeRowId(rowId,id);
				alert("保存成功！！！");
				}
			customerCarrierRel.saveCustomerCarrierRel(customerCarrierRel.obj,func);

		}else{
			alert("请选择要保存的数据");
		}
}
function isCheckPass(rowId){
	if(getCellValue(rowId,1)=="") {alert("载体不能为空！"); return false;}
	if(getCellValue(rowId,2)=="") {alert("资源不能为空！"); return false;}
	if(getCellValue(rowId,3)=="") {alert("时长不能为空！"); return false;}
	if(getCellValue(rowId,4)=="") {alert("开始日期不能为空！"); return false;}
	if(getCellValue(rowId,5)=="") {alert("结束日期不能为空！"); return false;}
	if(getCellValue(rowId,3)<=0) {alert("时长至少大于0！"); return false;}
	if(getFormatDate(getCellValue(rowId,4))>getFormatDate(getCellValue(rowId,5))) {alert("开始日期不能大于结束日期！"); return false;}
	return true;
}
function getFormatDate(shortDate,format){
	var m =  shortDate.substring(0,2);
	var d =  shortDate.substring(3,5);
	var y =  shortDate.substring(6,10);
	shortDate = y + m + d;
	return shortDate;
}
function deleteChecks(){
	var id = mygrid.getSelectedId();
	if(id > 0){
		var msg = "请确认是否删除这条记录 ?";
		
		ans = confirm(msg);
	    if (ans) {
				customerCarrierRel.removeCustomerCarrierRel(id);
				mygrid.deleteSelectedItem();
				} 
	}
}

function btnAddRow(){
	
	var rows = mygrid.getRowsNum() + 1;
	mygrid.addRow((new Date()).valueOf(),[rows],mygrid.getRowsNum()+1);
	addEventAction();
}
//翻页处理
function goNextPage(pageIndex,pageInfoName){
	
	if(pageInfoName == customerCarrierRel.pageInfo){
		getResourceSelectItem();
		var page = new Page(customerCarrierRel.pageInfo,customerCarrierRel.pageSize);
		page.goNextPage(pageIndex);
		customerCarrierRel.page = page;
		var func =function(){
		}
		loadData(customerCarrierRel.obj,func);
	}
}
function loadData(obj,callBackFun){
	var func = function(xml){
		mygrid.clearAll();
		mygrid.loadXMLString(xml);
		addEventAction();
        	if(callBackFun) callBackFun();
	}			
	customerCarrierRel.getCustomerCarrierRelPageXML(obj,func);
}
function setCustomerCarrierRelPara(obj){
	 var page=Math.round(winHeight* 0.80/20)-3;
	 obj.className  = "customerCarrierRel";
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= page;
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}
function getCustomerCarrierRelXML(){
	customerCarrierRel.obj.customerId=customerId;
	loadData(customerCarrierRel.obj);	
}