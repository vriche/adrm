var ctxPath;
//var myDate = new MyDate();
var proProgramType = new ProProgramType();
var proProgram = new ProProgram();
var proOrder = new ProOrder();
var proCheckIdea = new ProCheckIdea();
var user = new User();
var comboCusName ;
var checkId;
var carrier = new Carrier();
var proCustomer = new ProCustomer();
var proCustomerType = new ProCustomerType();
var config_serviceDate;
var oaWorkFlowCheckState = new OaWorkFlowCheckState();

callOnLoad(init);

function init(){  
	getServiceDate();
	ctxPath = $F("ctxPath");
	editMode = getParamFromUrl(document.location.href,"id")*1>0?true:false;
	channelModelParam = $("config_channelModelParam").value;
	setCarrierPara(carrier);
	userName = $("config_username").value;
	var funu = function(id){
			userId = id;
	}
	user.getCurUserId(userName,funu);
	config_serviceDate = $("config_serviceDate").value;
	proProgramType.getProgramTypesXML($("programTypeDiv"),"proType","150");
	if(!isUndefined($("checkStateDiv"))){
		oaWorkFlowCheckState.getCheckStatesXML($("checkStateDiv"),"checkState","150");
	}
	var func = function(){
			$("cusType").disabled="true";
			setSelectByValue($("cusType"),"1");
	}
	proCustomerType.makeSelectCustomerTypeByOrder($("customerTypeDiv"),"cusType","150",func);
	
	proProgramType.getProgramStatusXML($("proProgramStatusDiv"),"proProgramStatus","150")
	initToolbar();
	
	comboEvent();
	//initGrid(); 
	getDate();
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
	//makeCarrierSelectItem();
	mygrid.enableAlterCss("even","uneven"); 
    mygrid.setMultiLine(false);
	mygrid.setEditable(true);
	

//	mygrid.enableDragAndDrop(false);
    mygrid.setSkin("modern2");
	mygrid.init();	 
}

function initTabbar(){
	
			var imagePath = ctxPath + "image/dhtmlXTabbar/";

            tabbar=new dhtmlXTabBar("a_tabbar","top");
            tabbar.setImagePath(imagePath);
            tabbar.setStyle("silver");
            //tabbar.setOffset(3);     
            tabbar.enableContentZone(false);
            //tabbar.loadXML("tabs7.xml");
            tabbar.addTab("ProgramInfo","节目信息",100);
            tabbar.addTab("Check","审核信息",100);
		
		if(checkId == 3){
			tabbar.addTab("BroadCast","播出信息",100);
	    		tabbar.addTab("OrderPro","订单信息",100);
	    		tabbar.addTab("FinanceStatus","财务信息",100);
		}
            

 	    	tabbar.setOnSelectHandler(function(id){
 	    		var isChecked=false;
 	    		if(!isUndefined($("checkStateDiv"))){
 	    			isChecked=true;
 	    		}
 	    	              //alert(id)

			 var proId = $("proProgramId").value==null||$("proProgramId").value==""?0:$("proProgramId").value;
				window.frames.details.document.location.href=$F("ctxPath")+"merm/"+"pro"+id+"List.jsp?programId="+ proId+"&isChecked="+isChecked;
				return true;
			});
			
	     	setTimeout( function() {tabbar.setTabActive("ProgramInfo",true);},5);
	}	
	
function comboEvent(){
	comboCusName=new dhtmlXCombo("customer","alfa2",150);
  	comboCusName.enableFilteringMode(true);
  	proCustomer.reset();
  	proCustomer.obj.typeId = 1;
	var func = function(xml){
			comboCusName.clearAll();
			comboCusName.loadXMLString(xml);
	}
	proCustomer.getProCustomersXML(proCustomer.obj,func);
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
	
	Calendar.setup({
		inputField  : "reachDate",	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "reachDate"	// id of the button
	});
	//$("beginDate").value = getFormatDay(theYear+'0101','y/m/d');
	//$("overDate").value = getFormatDay(theYear+'1231','y/m/d');
	$("startDate").value = getFormatDay(config_serviceDate,'y/m/d');
	$("endDate").value = getFormatDay(config_serviceDate,'y/m/d');
	//$("reachDate").value = getFormatDay(config_serviceDate,'y/m/d');
	
}
 function getServiceDate(){
 	var fuc = function(d){
 		$("config_serviceDate").value = d;
 	}
 	DWREngine.setAsync(false);
 	DateUtil.getServiceDate(fuc);
 	DWREngine.setAsync(true);
 }
function initToolbar(){
	var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml"
	
	aToolBar=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo"); 
	aToolBar.setOnClickHandler(onButtonClick);

	aToolBar.loadXML(toolbarDataPath,callBack);
	
	function callBack(){
	aToolBar.hideButtons(); 
	if(editMode){

 		aToolBar.showButtons("16_edit,1_new,2_delete,3_save");  
        aToolBar.showButtons("div_16,div_1,div_2,div_3"); 
        $("proProgramId").value = getParamFromUrl(document.location.href,"id");
        //initToolbar1();
        getAllValueById();
        		
		//proChecksIdeaList();
	}else{
		aToolBar.showButtons("1_new,3_save");  
        aToolBar.showButtons("div_1,div_3"); 
	}
   	 aToolBar.setBarAlign("right"); 
	}
   	aToolBar.showBar();  
}

function onButtonClick(itemId,itemValue){
	if(itemId=='1_new') newAdd();
	if(itemId=='2_delete') deletePrograms();
	if(itemId=='3_save') savePrograms() ;
	if(itemId=='16_edit') lockProgramDetail(true) ;
}

function getAllValueById(){
 	function func(objs){
 		if(!isUndefined($("checkStateDiv"))){
			$("checkState").value = objs.isChecked;   //审核状态
		}
 		$("checkStateForm").value = objs.isChecked;
 		var reachDate = objs.arriveDate==null?"":getFormatDay(objs.arriveDate,'y/m/d');  //到带日期
 		$("reachDate").value = reachDate==null+"//"?0:reachDate;
 		
 		$("playFather").value = objs.sowCount;  //播出集数
 		$("unitPrice").value = objs.price;   //单价
 		$("audience").value = objs.audienceRat;  //收视率
 		$("copyrightArea").value = objs.copyrightArea;  //版权区域
 		$("isSecondLunch").checked = objs.isSell==1?true:false;  //是否二次发行
 		$("proProgramStatus").value = objs.programStatusId;
 		if($("proProgramStatus").value==3) $("proProgramStatus").disabled=true;
 		$("createBy").value = objs.createBy;
		$("createDate").value = objs.createDate;
		$("version").value = objs.version;
 		
		$("proName").value = objs.proName;
		
		
		function funct(proCustomer){
			comboCusName.setComboText(proCustomer.customerName) ;
			$("cusType").value = proCustomer.typeId;
		}
		var type=getParamFromUrl(document.referrer,"type");
		var orderId=getParamFromUrl(document.location.href,"orderId");
		
		function funcc(obj){
		objs.customerId=obj.customerId;
		proCustomer.getProCustomer(objs.customerId,funct);
		}
	    if(type==2){
	    $("customerType").setAttribute("style","display:none");
	    $("customerTypeDiv").setAttribute("style","display:none");
	    $("customerBase").setAttribute("style","margin-top:-5px");
		proOrder.getProOrder(orderId,funcc);
	    }
	    proCustomer.getProCustomer(objs.customerId,funct);
		$("copyrightNum").value = objs.copyrightNum;
		$("makeUnit").value = objs.businessName;
		var start = getFormatDay(objs.startDate,'y/m/d');
		var end = getFormatDay(objs.endDate,'y/m/d');
	
		checkId = $("checkStateForm").value;
		$("startDate").value = start==null+"//"?0:start;
		$("endDate").value = end==null+"//"?0:end;
		$("proType").value = objs.typeId;
		initTabbar();
//		if(isUndefined($("checkStateDiv"))){
//			if(checkId == 2){
//				alert("审核中的节目不可以修改！！！");
//			}
//			if(checkId == 3){
//				alert("通过的节目不可以修改！！！");
//			}
//		}
//		 if($("checkStateForm").value==5 || $("checkStateForm").value == null ){
//	    $("customerType").setAttribute("style","display:none");
//	    $("customerTypeDiv").setAttribute("style","display:none");
//	    $("customerBase").setAttribute("style","margin-top:-5px");
//		proOrder.getProOrder(orderId,funcc);
//	    }
	lockProgramDetail(false);	
	}
		proProgram.getProProgram($("proProgramId").value,func);
		
}
function newAdd(){
	editMode=false;
	$("proProgramId").value = null;
	$("proProgramStatus").value=0;
	$("proType").value = 0 ;
	$("proName").value = null;
	comboCusName.setComboText(null) ;
	$("copyrightNum").value = null;
	$("makeUnit").value = null;
	$("startDate").value = getFormatDay(config_serviceDate,'y/m/d');
	$("endDate").value = getFormatDay(config_serviceDate,'y/m/d');
	
	if(!isUndefined($("checkStateDiv"))){
			$("checkState").value = 1;   //审核状态
		}
 	$("reachDate").value = null;  //到带日期
 	$("playFather").value = null;  //播出集数
 	$("unitPrice").value = null;   //单价
 	$("audience").value = null;  //收视率
 	$("copyrightArea").value = null;  //版权区域
 	$("isSecondLunch").checked = false;  //版权区域
 	if(!editMode) {
 		aToolBar.hideButtons(); 		
 		aToolBar.showButtons("1_new,3_save");  
        	aToolBar.showButtons("div_1,div_3"); 
	}
 	lockProgramDetail(true);
}
function savePrograms(){
	if(!editMode) checkId=1;

	if(checkId == 1 || checkId == 4 || checkId == 5 ||!isUndefined($("checkStateDiv"))){

			proProgram.reset();
			var programId = $("proProgramId").value;
			proProgram.obj.id= programId;
			proProgram.obj.proName = $("proName").value ;
			proProgram.obj.businessName = $("makeUnit").value;
			proProgram.obj.copyrightNum = $("copyrightNum").value ;
			proProgram.obj.programStatusId = $("proProgramStatus").value;
			var customerTypeId = $("cusType").value;
			var proCustomerName = comboCusName.getComboText() ;
			proProgram.obj.typeId = $("proType").value;
			proProgram.obj.endDate = getFormatDay($("endDate").value,'ymd');
			proProgram.obj.startDate=getFormatDay($("startDate").value,'ymd');
			
			if(programId==""){
		  		proProgram.obj.createBy = userId;
		  		proProgram.obj.createDate = new Date();
			}else{
				proProgram.obj.modifyBy = userId;
		  		proProgram.obj.modifyDate = new Date();
		  		proProgram.obj.version = $("version").value;
			}
			
			if(!isUndefined($("checkStateDiv"))){
					proProgram.obj.isChecked = $("checkState").value;   //审核状态
				}else{
					proProgram.obj.isChecked = 1;   //审核状态
				}
			
		 	proProgram.obj.arriveDate = getFormatDay($("reachDate").value,'ymd');  //到带日期
		 	proProgram.obj.sowCount = $("playFather").value;  //播出集数
		 	proProgram.obj.price = $("unitPrice").value;   //单价
		 	proProgram.obj.audienceRat = $("audience").value;  //收视率
		 	proProgram.obj.copyrightArea = $("copyrightArea").value;  //版权区域
		 	proProgram.obj.isSell = $("isSecondLunch").checked ==true?1:0;  //二次发行
		 	
			if($("proType").value==0){
				alert("节目类型不能为空，请重新选择节目类型！！");
			}else if(proCustomerName==""){
				alert("客户名称不能为空，请重新填写！！！！！");
			}else if($("proProgramStatus").value==0){
				alert("请选择节目状态！");
			}else if(proProgram.obj.startDate>proProgram.obj.endDate){
				alert("开始时间不能小于结束时间！！！请重新选择！！！");
			}else{
				proProgram.saveProProgram(proProgram.obj,proCustomerName,customerTypeId);
				alert('数据保存成功！！！');
				if($("proProgramId").value==""){
					window.location.href=ctxPath +"merm/proProgramSearch.jsp";
				}
			}
	}else{
		if(checkId == 2 ){alert("节目还在审核过程中，不可以修改。");}
		if(checkId == 3 ){alert("节目已经通过，不可以修改。");}
	}
}

function deletePrograms(){
	if(checkId == 2||checkId == 3) {alert("节目已通过,不能删除！");return false;}
	var isDelete=confirm("确认删除？");
	if(!isDelete)  return false;

	proProgram.removeProProgram($("proProgramId").value);
	window.location.href=ctxPath +"merm/proProgramSearch.jsp";
}

function lockProgramDetail(isLocked){
  
   if (isLocked){
      $("proProgramStatus").removeAttribute("disabled");

      $("isSecondLunch").removeAttribute("disabled");
      $("proType").removeAttribute("disabled");
      $("playFather").removeAttribute("disabled");
      $("proName").removeAttribute("disabled");
      $("unitPrice").removeAttribute("disabled"); 

      comboCusName.disable("false");

      $("audience").removeAttribute("disabled");
      $("reachDate").removeAttribute("disabled");     
      
      $("copyrightNum").removeAttribute("disabled");
      $("startDate").removeAttribute("disabled");
      $("copyrightArea").removeAttribute("disabled");
      $("endDate").removeAttribute("disabled");
      $("makeUnit").removeAttribute("disabled");
      if(!isUndefined($("checkStateDiv"))){
      		$("checkState").removeAttribute("disabled");
      }

   }else{
   	  $("proProgramStatus").disabled= "true";

   	  $("isSecondLunch").disabled= "true";
   	  $("proType").disabled= "true";
   	   $("playFather").disabled= "true";
   	   $("proName").disabled= "true";
   	   $("unitPrice").disabled= "true";
   	  
   	  
   	  
  	  comboCusName.disable("true");
  	  $("audience").disabled= "true";
  	  	
	  
   	  $("reachDate").disabled= "true";  	  

   	  $("copyrightNum").disabled= "true";
   	  $("startDate").disabled= "true";
   	  $("copyrightArea").disabled= "true";
   	  $("endDate").disabled= "true";
   	  $("makeUnit").disabled= "true";
   	  if(!isUndefined($("checkStateDiv"))){
   	  		$("checkState").disabled= "true";
   	  }
}
}




