var ctxPath;
//var myDate = new MyDate();
var proProgramType = new ProProgramType();
var proProgram = new ProProgram();
var proOrder = new ProOrder();
var proCheckIdea = new ProCheckIdea();
var user = new User();
var comboCusName ;
var carrier = new Carrier();
var proCustomer = new ProCustomer();
var proCustomerType = new ProCustomerType();
var config_serviceDate;
var oaWorkFlowCheckState = new OaWorkFlowCheckState();
var mygrid;
callOnLoad(init2);


function init2(){
        getServiceDate();
	ctxPath = $F("ctxPath");
	config_serviceDate = $("config_serviceDate").value;
	userName = $("config_username").value;
	programId = getParamFromUrl(document.location.href,"programId");
	isChecked = getParamFromUrl(document.location.href,"isChecked");
	proOrderTypeId=getParamFromUrl(document.referrer,"orderTypeId");
	channelModelParam = $("config_channelModelParam").value;
	setCarrierPara(carrier);
    initGrid();
    initToolbar();
    proChecksIdeaList();
    if(proOrderTypeId==1){
      if(proCusId!=0){
    	
    	getNameByCustomerId();
       }
   }
}
function proChecksIdeaList(){
	
	proCheckIdea.reset();

	if(isChecked=="true"){
		proCheckIdea.obj.programId = programId;
		var func = function(xml){
				mygrid.clearAll();
				mygrid.loadXMLString(xml);
				
		 }
	
		proCheckIdea.getProCheckIdeaXML(proCheckIdea.obj,func);
		
	}else{
		proCheckIdea.obj.programId = programId;
		
		var funu = function(id){
			proCheckIdea.obj.createBy = id;
			
			var func = function(xml){
				mygrid.clearAll();
				mygrid.loadXMLString(xml);
				
				}
	
				proCheckIdea.getProCheckIdeaXML(proCheckIdea.obj,func);
				
		}
		user.getCurUserId(userName,funu);
		
	}
}
 function getServiceDate(){
 	var fuc = function(d){
 		$("config_serviceDate").value = d;
 	}
 	DWREngine.setAsync(false);
 	DateUtil.getServiceDate(fuc);
 	DWREngine.setAsync(true);
 }
function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}
function initGrid(){
	var imagePath = ctxPath + "image/grid/";
	
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath(imagePath);
	mygrid.selMultiRows = true;
	var flds = "频道,审核人,审核日期,审核意见,审核结果";
	mygrid.setHeader(flds);
    mygrid.setInitWidthsP("20,20,20,20,20");
	mygrid.setColAlign("left,left,left,left,left");
	mygrid.setColTypes("co,ed,calendar,txt,acheck");
	mygrid.setDateFormat("y/m/d");
	mygrid.setColSorting("str,str,date,str,str");
	makeCarrierSelectItem();
	mygrid.enableAlterCss("even","uneven"); 
    mygrid.setMultiLine(false);
	mygrid.setEditable(true);
	

//	mygrid.enableDragAndDrop(false);
    mygrid.setSkin("modern2");
	mygrid.init();	 
}

 function makeCarrierSelectItem(){
	//根据是否分频道，取得频道下拉列表
	if(channelModelParam!=1){
		carrier.makeSelectItemAnalyze(carrier.obj,carrier.selectName,"",getCarrierCombo);
	}else{
		carrier.makeSelectItemAnalyze2(carrier,carrier.selectName,"",getCarrierCombo);
	}
}
function getCarrierCombo(){
	var el = $(carrier.selectName);
	var inputs = el.getElementsByTagName("option");
	var command = mygrid.getCombo(0);
	var arr = getCarrierIds();
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
		ids.push(getCellValue(id,0));
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
	if(itemId=='3_save') btnSaveChecksRow();
}
function btnSaveChecksRow(){
		var rowId = mygrid.getSelectedId();
		if(rowId > 0){
			
			proCheckIdea.reset();
			proCheckIdea.obj.id = rowId;
			proCheckIdea.obj.programId = programId;
			proCheckIdea.obj.carrierId = getCellValue(rowId,0);
			
			var funu = function(id){
					proCheckIdea.obj.createBy = id;
					proCheckIdea.obj.checkIdea = getCellValue(rowId,3);
					proCheckIdea.obj.checkResult = getCellValue(rowId,4);
			
						var func = function(id){
							mygrid.changeRowId(rowId,id);
							alert("保存成功！！！");
							}
					proCheckIdea.saveProCheckIdea(proCheckIdea.obj,func);
				}
			user.getCurUserId(userName,funu);

		}else{
			alert("请选择要保存的数据");
		}
}
function deleteChecks(){
	var id = mygrid.getSelectedId();
	if(id > 0){
		var msg = "请确认是否删除这条记录 ?";
		
		ans = confirm(msg);
	    if (ans) {
				proCheckIdea.removeProCheckIdea(id);
				mygrid.deleteSelectedItem(); 
				} 
	}
}

function btnAddRow(){
	var rows = mygrid.getRowsNum() + 1;
	var date1 = getFormatDay(config_serviceDate,'y/m/d');
	var func = function(obj){
		obj.fullName					
	}
	var fullName=user.getUserFullName(userName);
		mygrid.addRow((new Date()).valueOf(),['',fullName,date1,'','0'],mygrid.getRowsNum()+1);
}