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
	var flds = "Ƶ��,�����,�������,������,��˽��";
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
            tabbar.addTab("ProgramInfo","��Ŀ��Ϣ",100);
            tabbar.addTab("Check","�����Ϣ",100);
		
		if(checkId == 3){
			tabbar.addTab("BroadCast","������Ϣ",100);
	    		tabbar.addTab("OrderPro","������Ϣ",100);
	    		tabbar.addTab("FinanceStatus","������Ϣ",100);
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
			$("checkState").value = objs.isChecked;   //���״̬
		}
 		$("checkStateForm").value = objs.isChecked;
 		var reachDate = objs.arriveDate==null?"":getFormatDay(objs.arriveDate,'y/m/d');  //��������
 		$("reachDate").value = reachDate==null+"//"?0:reachDate;
 		
 		$("playFather").value = objs.sowCount;  //��������
 		$("unitPrice").value = objs.price;   //����
 		$("audience").value = objs.audienceRat;  //������
 		$("copyrightArea").value = objs.copyrightArea;  //��Ȩ����
 		$("isSecondLunch").checked = objs.isSell==1?true:false;  //�Ƿ���η���
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
//				alert("����еĽ�Ŀ�������޸ģ�����");
//			}
//			if(checkId == 3){
//				alert("ͨ���Ľ�Ŀ�������޸ģ�����");
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
			$("checkState").value = 1;   //���״̬
		}
 	$("reachDate").value = null;  //��������
 	$("playFather").value = null;  //��������
 	$("unitPrice").value = null;   //����
 	$("audience").value = null;  //������
 	$("copyrightArea").value = null;  //��Ȩ����
 	$("isSecondLunch").checked = false;  //��Ȩ����
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
					proProgram.obj.isChecked = $("checkState").value;   //���״̬
				}else{
					proProgram.obj.isChecked = 1;   //���״̬
				}
			
		 	proProgram.obj.arriveDate = getFormatDay($("reachDate").value,'ymd');  //��������
		 	proProgram.obj.sowCount = $("playFather").value;  //��������
		 	proProgram.obj.price = $("unitPrice").value;   //����
		 	proProgram.obj.audienceRat = $("audience").value;  //������
		 	proProgram.obj.copyrightArea = $("copyrightArea").value;  //��Ȩ����
		 	proProgram.obj.isSell = $("isSecondLunch").checked ==true?1:0;  //���η���
		 	
			if($("proType").value==0){
				alert("��Ŀ���Ͳ���Ϊ�գ�������ѡ���Ŀ���ͣ���");
			}else if(proCustomerName==""){
				alert("�ͻ����Ʋ���Ϊ�գ���������д����������");
			}else if($("proProgramStatus").value==0){
				alert("��ѡ���Ŀ״̬��");
			}else if(proProgram.obj.startDate>proProgram.obj.endDate){
				alert("��ʼʱ�䲻��С�ڽ���ʱ�䣡����������ѡ�񣡣���");
			}else{
				proProgram.saveProProgram(proProgram.obj,proCustomerName,customerTypeId);
				alert('���ݱ���ɹ�������');
				if($("proProgramId").value==""){
					window.location.href=ctxPath +"merm/proProgramSearch.jsp";
				}
			}
	}else{
		if(checkId == 2 ){alert("��Ŀ������˹����У��������޸ġ�");}
		if(checkId == 3 ){alert("��Ŀ�Ѿ�ͨ�����������޸ġ�");}
	}
}

function deletePrograms(){
	if(checkId == 2||checkId == 3) {alert("��Ŀ��ͨ��,����ɾ����");return false;}
	var isDelete=confirm("ȷ��ɾ����");
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




