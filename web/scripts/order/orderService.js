//实例化对象
var myDate = new MyDate();
var orderDetailColl = new OrderDetailColl();
var contract = new Contract();
var payMent = new PayMent();
var matter = new Matter();
var matterType = new MatterType();
var orderCategory = new OrderCategory();
var orderCategory1 = new OrderCategory();
var carrier = new Carrier();
var customer = new Customer();
var category = new Category();
var industry = new Industry(); 
var specific = new Specific();
var oaAreaCity = new OaAreaCity();
var customerAddress = new CustomerAddress();
var linkMan = new LinkMan();
var brand = new Brand();

 
var report = new MyPrint();
var user = new User();

var myUtils = new MyUtils();

var order = new Order();
var orderPublic = new OrderPublic();
var orderDetail = new OrderDetail();

var orderBackUp = (new Order()).obj;
var orderDetailBackUp = (new OrderDetail()).obj;

var resource = new Resource();
var priceType = new PriceType();
var carrierType = new CarrierType();
var priceDetail = new PriceDetail();
var priceRegular = new PriceRegular();
var resourceSort = new ResourceSort();
var compages = new Compages();
var resDayInfo = new DayInfo();
var orderDayInfo = new OrderDayInfo();
var broArrange = new BroArrange();
var popupcenter = new Popupcenter();
var popupOrderDetail = new Popupcenter();
var agentInfo = new AgentInfo();  
var price = new Price();
var mygrid;
var mygrid1;
var mygrid2;
var mygrid3;
var mygrid4;
var regCustomerGrid;

var orderDetailStates = 0;          //1编辑  2新建 3新建并贴 4套播浏览
var config_contractsort = 0;        //判断协议类型 0 根据付款分配应收 1 跟正常合同一样
var config_orderContractParam = 0;  //订单协约 0 是无效 1 是有效
var config_adverCodeModelParam = 0; //0磁带号手动  1自动
var config_permitModAdverParam = 0;  //审后订单，允许修改广告素材，但不能修改长度 
var isPackage = false;
var initMatterButton=false;
var startDateInit=0;
var endDateInit = 0;
var sessionUserId = 0;
var isSaveOrderDayInfo = true;
var isSaveOrderDetail = true;
var isResChangedOnEdit = false;
var isSpecifChangedOnEdit = false;
var isFree = false;   //福州台的宣传片录入

var order_year;
var config_serviceDate;
var config_orderModCategoryParam;
var config_isOpenOrderOrgParam;
var withoutSubmit;
var alertStr1='该时段播出单已出的日期:\n'; 
var alertStr2='该时段超时日期:\n'; 
var orgId = 1;
var orgIdRel = 1;
//var orgType =1;
var resource_sort =1;
var regCustomerWin;
var compagesDiaWin;
var ctxPath;
var compagesId_new = 0;
var change_edit_win;
var search_adver_win;
var build_more_paraArray;



//Ext.onReady(function(){});

callOnLoad(init);	
  
function init(){
	ctxPath = _app_params.ctxPath;	
	loginUserName =  _app_params.user.username;
	loginUserFullName =  _app_params.user.fullName;
	loginUserId =  _app_params.user.id;
	tvNameParam =  _app_params.sysParam.tvNameParam;	
	config_serviceDate = _app_params.serviceDate.def;
	config_orderModCategoryParam = _app_params.sysParam.orderModCategoryParam;
	config_isOpenOrderOrgParam = _app_params.sysParam.isOpenOrderOrgParam;
	config_orderContractParam = _app_params.sysParam.orderContractParam;
	config_addCustomerInOrderParam = _app_params.sysParam.addCustomerInOrderParam;
	config_adverCodeModelParam = _app_params.sysParam.adverCodeModelParam;
	config_contractsort = _app_params.sysParam.contractSortParam; //协议合同类型
	config_permitModAdverParam = _app_params.sysParam.permitModAdverParam; //协议合同类型
	config_signCompages = _app_params.sysParam.signCompages; //是否启用套装参数(启用1,不启用0)系统参数默认是0;
	config_resourceDisplay= _app_params.sysParam.resourceDisplayParam; //
	config_orderCarrierLevelParam= _app_params.sysParam.orderCarrierLevelParam;
	config_useMoreCarrierSortParam =  _app_params.sysParam.useMoreCarrierSortParam;
	config_autoRelationCodeParam = _app_params.sysParam.autoRelationCodeParam;
	config_withResourceSort =  _app_params.sysParam.withResourceSort;
	config_autoPriceTypeParam =  _app_params.sysParam.autoPriceTypeParam;
	config_allowModiyPassedOrderParam =  _app_params.sysParam.allowModiyPassedOrderParam;
	config_withoutSubmit =  _app_params.sysParam.withoutSubmit;
	config_industryLevelParam =  _app_params.sysParam.industryLevelParam;
	useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
	config_useLanmuSingleParam= _app_params.sysParam.useLanmuSingleParam;
	config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;
	config_financeBalanceModelParam= _app_params.sysParam.financeBalanceModelParam;
	config_fastSignOrderParam = _app_params.sysParam.fastSignOrderParam;
	config_orderCalculateModel=  _app_params.sysParam.orderCalculateModel;
	config_orderArrangDefaultMonths=  _app_params.sysParam.orderArrangDefaultMonths*1;
	config_resourceUseCustomerCatelog = _app_params.sysParam.resourceUseCustomerCatelog;
	config_outLimitBroarrang=  _app_params.sysParam.outLimitBroarrang =="1"?true:false;
	


	tag_time_out =  _app_params.rights.tag_time_out;
	tag_check_right =  _app_params.rights.tag_orderList_check;
	tag_order_submitbtn =  _app_params.rights.tag_order_submitbtn;
	tag_order_paymentbtn =  _app_params.rights.tag_order_paymentbtn;
	tag_orderDetail_save =  _app_params.rights.tag_orderDetail_save;
	tag_order_leadmemo =  _app_params.rights.tag_order_leadmemo;
	tag_order_force_modify =  _app_params.rights.tag_order_force_modify;
	tag_order_returnbtn =  _app_params.rights.tag_order_returnbtn;
	
	
	if(tag_order_force_modify) config_allowModiyPassedOrderParam =1;
	
	
//	alert(_app_params.serviceDate.adrmSysYear)
	
	_make_adrm_sys_year_select("order_year",_app_params.serviceDate.adrmSysYear);
	
	var brandCmd = brand.getBrandCmd(brand.obj,'extBrandIdDiv','search_brand',null,89,'品牌...',null);

//	brandCmd.on('expand', function(comboBox) {
//	        comboBox.list.setWidth('240px'); //auto
//	        comboBox.innerList.setWidth('auto');
//	    }, this, { single: true }); 
	
	//如果订单号存在，则为编辑状态
	var srcStr = window.location.href;
	var orderId = getParamFromUrl(srcStr,"id");
	
	if(config_oneOrgMoreSuborgsParam == '1'){
		orgId =  '1'; 
		orgIdRel = getParamFromUrl(window.location.href,"orgId")+'';
	}else{
		orgId =  getParamFromUrl(window.location.href,"orgId")+'';
	}
	
	
	if(orgId !=''){if(orgId.indexOf('#') >-1) orgId = orgId.substring(0,1); }
	
	
	


	resetHeigth();   

    if(orgId == 0){extjMessage('系统意外出错,无法找到组织编号!');return false;}
    
//    eval('var orgType = _app_params.orgTypes.orgId_'+ orgId);
	
	var compagesId = getCompagesIdByURL();
	
	order.obj.orgId = orgId;
	order.obj.id = orderId;
	order.obj.compagesId = compagesId;

	
	if(orderId > 0 ){
		orderDetailStates = 1;
		order.obj.id = orderId;
	}else{
	 	orderDetailStates = 2;
	 	get_cur_year();
	}
	if(compagesId > 0) {$("Btn_save").hide();isPackage = true;}

	//设置常量
	setResourceSortPara(resourceSort);
	setOrderCategoryPara(orderCategory);	
	setOrderCategory1Para(orderCategory1);  
	setCarrierPara(carrier);				
	setCustomerPara(customer);
	setIndustryPara(industry);				
	setSpecificPara(specific);				
	setUserPara(user);						
	setOrderDetailPara(orderDetail);
	setOrderPara(order);	
	setResourcePara(resource);
	setPriceTypePara(priceType);
	setPricePara(price);
	setDayInfoPara(resDayInfo);	
	setOrderDayInfoPara(orderDayInfo);
	setAgentInfoPara(agentInfo);
	setBroArrangePara(broArrange);          
	setPriceDetailPara(priceDetail);  
	setCompagesPara(compages);  


	initGrid();
	initGrid1();


	initCustomerCmd();

	initIndustry();

	init_order_cate_main(orderId);




//    var sortWidth = config_signCompages?80:140;
    if(orderDetailStates == 1){
    	resourceSort.makeSelectFromMap5("resourceSortId",80,"onchangeResourceSort",getPosition);
    }else{
    	resourceSort.makeSelectFromMap5("resourceSortId",80,"onchangeResourceSort",init_resourceCarrier);
    }

	priceType.makeSelectFromMap(priceType.obj,"resourcePriceType","145","onResourceChange",function(){
		if(config_autoPriceTypeParam > 0){
			$("resourcePriceType").value = config_autoPriceTypeParam;
		}else{
			$("resourcePriceType").value = 1;
		}
	});
	


	var paramObJ ={};
	
	
	paramObJ.orgId =  config_oneOrgMoreSuborgsParam == '1'?orgIdRel:orgId; 
//	paramObJ.orgId =  orgId; 
	paramObJ.loginUser = loginUserName;
	paramObJ.loginUserId = loginUserId;
	user.obj = paramObJ;
	
 
	var userCmd = user.getUsersByOrgLimit("extUserIdDiv","userId",144,setCurUserId,null);
	if(tvNameParam=='fztv' && orderDetailStates==2){
		userCmd.setValue(loginUserId);
	}
	

//	if(tvNameParam=='fztv'){
//		$('gridbox1').hide(); 
//	}else{
//		$('gridbox1').hide(); 	
//	}
//	
	$('gridbox1').hide(); 
	
	this.ctxPath = ctxPath;
	
	var btns =[0,1,2];
	
	if(orderDetailStates != 2||tag_orderDetail_save){
		btns.push(7);
		btns.push(13);
	}
	
	 
	if(tag_check_right){
		btns.push(11);
		btns.push(12);
	}else{
		if(tag_order_returnbtn){
			btns.push(12);
		};
	}
	

	
	
//	if(orderDetailStates == 2||!tag_orderDetail_save){
//		this.report.buildButtons(this,"printReportDiv",[0,1,2],70);
//	}else{
//		this.report.buildButtons(this,"printReportDiv",[0,1,2,7],70);
//	}

	this.report.buildButtons(this,"printReportDiv",btns,70);

	
//	if(config_signCompages ==1)$('resourceSortId').disabled=false; 		

	broArrange.dayTotalTime = $("dayTotalTime");
	broArrange.dayUsedTime = $("dayUsedTime");
	broArrange.dayLeaveTime = $("dayLeaveTime");
	broArrange.broSumTime = $("broSumTime");
	broArrange.makeSelectMonth("selectMonth",12,1,"selectMonth");
	broArrange.broArrangeStartDate = $("broArrangeStartDate");
	broArrange.broArrangeEndDate = $("broArrangeEndDate");
	broArrange.sumMonthBasePrice =$("moneyBase");
	broArrange.sumMonthRealPrice = $("moneyRealpay");
//	broArrange.sumMonthBasePrice =$("sumMonthBasePrice");
	broArrange.broWeekTime  = $("broWeekTime");
    
 
    
	// 1 编辑 2新添
	if(orderDetailStates == 1){
		getOrder(orderId);
	}else{
//		init_order_cate_main(orderId);
		getMatterLengthComplt();
		init_resourceSpeci();
		getContarctAuto();
		
	}



	//取消从列表中点新添时，加载素材信息，改用点客户时才加载
	buttonEventFill();

	disableContrlGlobal();
	
	
//	if(tvNameParam !='hbtv'){
//		$("Btn_addNewAdver2").hide();
//	}
	

	if(config_adverCodeModelParam == '1')$("tapCode").setAttribute("class","dataLabel");
	
	


};




//extjMessage('系统意外出错,无法找到组织编号!');


//显示订单审核历史
function order_check_history_bak(){
	var orderId = order.obj.id;
	if(orderId == null) return false;
	
	var dialogcontent = $("dialogcontentDiv");
	var dialogcontentW = dialogcontent.offsetWidth;
	var dialogcontentH = dialogcontent.offsetHeight;
	var winW= dialogcontentW * 0.6;
	var winH = dialogcontentH*0.8;
	var title = "审批结果";
	var theme = "leopard"; //vista mac_os_x lighting black_hud leopard window
	var draggable = false;
	var minimize = false;
	var maximize = false;
	var close =  'destroy';
	var resizable = false;
	var urlStr = 'selectPopup/selectOrderCheckResult.html?orderId='+orderId+'&winW='+winW+'&winH='+winH;
	openWindow('mywin',urlStr,winW,winH,title,theme,draggable,minimize,maximize,close,resizable);
};


//显示订单审核历史
function order_check_history(){
	var dialogcontent = $("dialogcontentDiv");
	var dialogcontentW = dialogcontent.offsetWidth;
	var dialogcontentH = dialogcontent.offsetHeight;
	var winW= dialogcontentW * 0.6;
	var winH = dialogcontentH*0.8;
	var orderId = order.obj.id;
	
	if(orderId == null) return false;
	var urlStr = 'selectPopup/selectOrderCheckResult.html?orderId='+orderId+'&winW='+winW+'&winH='+winH;
    var closeBtn ={text: '关闭',handler: function(){win.destroy();}};	

	 var win = new Ext.Window({
	   title : '审批历史',
	   width : winW,
	   height : winH,
	   isTopContainer : true,
	   modal : true,
	   resizable : false,
	    buttons: [closeBtn],
	   contentEl : Ext.DomHelper.append(document.body, {
	    tag : 'iframe',
	     id : 'orderPaymentiframe',
	    style : "border 0px none;scrollbar:true",
	    src : urlStr,
	    height : "100%",
	    width : "100%"
	   })
	  })
	  win.show(this); 

};


//资源类型改变的时候，如时段、栏目
function  onchangeResourceSort(){
	var  resourceSort = $("btn_packeg").value;
	getPosition(resourceSort);
	if(resourceSort == 2) { //如果是套装不初始化频道
		displayCompagesTree2(null,true);
	}else{
		init_resourceCarrier();
	}
};


function get_cur_year(){
	var year = getParamFromUrl(window.location.href,"version");
	var yyyy = getDayPar(config_serviceDate,'y');
	if(year>0) yyyy = year;
	setSelectByValue($("order_year"),yyyy);
	order_year = $("order_year").value;
};
	
         
function init_selectComd(el,items){
	DWRUtil.removeAllOptions(el);
	DWRUtil.addOptions(el,items);
};

function set_selectComd1(id,val,txt){
	 var el = $(id);
	 if(val==0) txt ="";
     txt = txt.replace(/\\/g,"\\\\").replace(/'/g,"\\\'") 
	 eval("var items = {"+ val +":'" + txt +"'}");
	 init_selectComd(el,items);	
};

function set_selectComd2(id,val,txt,isInit){
		 var el = $(id);
		 if(val==0) txt ="";
		 txt = txt.replace(/\\/g,"\\\\").replace(/'/g,"\\\'") 
		 if(el.options.length>1){
		 	el.value = val;
		 }else{
		 	eval("var items = {"+ val +":'" + txt +"'}");
		 	init_selectComd(el,items); 
		 }  
};

function set_selectComdResource(id,val,txt,isManual,carrierId,isInit){

	 if(isInit){
	 	   
	 		init_resourceInfo(carrierId,val,isManual);
	 		 
	 }else{
		 var el = $(id);
		 if(el.options.length>1){
		 	el.value = val;
		 }else{
			 if(val==0) txt ="";
		     txt = txt.replace(/\\/g,"\\\\").replace(/'/g,"\\\'") 
			 eval("var items = {"+ val +":'" + txt +"'}");
			 init_selectComd(el,items);	
		 }  		 
	 }

};



function set_selectComdCarrier(id,val,txt,resourceSortId,isInit){
		
	 if(isInit){
	 		init_resourceCarrier(resourceSortId,val);
	 }else{
		 var el = $(id);
		 if(val==0) txt ="";
		 txt = txt.replace(/\\/g,"\\\\").replace(/'/g,"\\\'") 
		 if(el.options.length>1){
		 	el.value = val;
		 }else{
		 	eval("var items = {"+ val +":'" + txt +"'}");
		 	init_selectComd(el,items); 
		 }  
	 }	
};


function init_set_orderCate(obj,id,name,width,even){
	obj.id = id;
	var objs = [obj];
	orderCategory.makeSelectHtml(objs,name,width,even); 	
	$(name).value = id;
};

function init_resourceCarrier(resourceSortId,defValue){
	var el = $("carrierId");
	var id = 0;
 
	if(orderDetailStates == 2 && order.obj.id > 0 && el.value > 0){
		id = el.value;
	}
	


	
    if(!resourceSortId) resourceSortId =  getSelectParamFromAttribute($("resourceSortId"),"paramvalue");

	var fuc = function(){
			el.value = id;
			if(defValue) el.value = defValue;
			el.value = defValue;

//			if(callBackFun) callBackFun();
	}

		carrier.reset();
		DWRUtil.removeAllOptions($("carrierId"));
		DWRUtil.removeAllOptions($("resourceInfoId"));
	    //编辑状态，需要所有 
		if(orderDetailStates == 1){
			carrier.obj.enable = false;
		}else{
			carrier.obj.enable = true;
		}	

//        alert(orgId)
// 		alert(resourceSortId)

 		 
		carrier.obj.version = $("order_year").value;
		carrier.obj.orgId = orgId; 
		carrier.obj.resourceSort = resourceSortId; 
		carrier.obj.loginUser = loginUserName;
	    carrier.makeSelectFromMap2(carrier.obj,el,fuc,"getResource");	
};

function init_resourceInfo(carrierId,val,isManual){
	var el = $(resource.selectName);
	var fuc = function(){
		
		el.value =val;
		el.setAttribute("isManual",isManual);
		
	}
	getResource(carrierId,fuc);	
}

function init_resourceSpeci(){
	var el = $(specific.selectName);
	var id = orderDetail.obj.resourceSpecificId;
	var fuc = function(){
		$(specific.selectName).value =id;
	}
	if(el.options.length>1){
		el.value = id;
	}else{
		specific.makeSelectFromMap3(specific.obj,"resourceSpecificId","45",fuc,"getSpecificRate");	
	}	
}

//function init_order_cate_main_bak(orderId){ 
//	var el = $("categoryId");
//	var id = order.obj.categoryId;
//	var fuc = function(){el.value = id;}
//
//	if(el.options.length > 1){
//		el.value = id;
//	}else{
//		orderCategory.obj.parentId = 0;
//		orderCategory.obj.orgId = orgId;
//		var defValue = config_orderModCategoryParam;
//		if(order.obj.id ||  orderDetailStates == 3) defValue  = id;
//			orderCategory.makeSelectFromMap5(orderCategory.obj,"categoryId","reloadOrderCategory1Store",function(){
//			if(!orderId){
//				initOrderCategory1Cmd();
//				if(config_orderModCategoryParam == $("categoryId").value) return false;
//				reloadOrderCategory1Store();
//			}
//			
//			},defValue,145);
//	}	
//};


function init_order_cate_main(orderId){ 
		function callBackFun(){reloadOrderCategory1Store();};
		
        if(orderId > 0){
							_make_order_cateMain_select(orgId,"categoryId","reloadOrderCategory1Store",null,0,145);
        }else{
							_make_order_cateMain_select(orgId,"categoryId","reloadOrderCategory1Store",callBackFun,config_orderModCategoryParam,145);
        }
	
//		orderCategory.obj.parentId = 0;
//		orderCategory.obj.orgId = orgId;		
//		orderCategory.makeSelectFromMap5(orderCategory.obj,"categoryId","reloadOrderCategory1Store",
//		function(){reloadOrderCategory1Store(); },config_orderModCategoryParam,145);
		
};


function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = false;
	mygrid.setImagePath(ctxPath+"image/grid/");
	var	flds = "序,广告位置,名称,版本,秒,指定,开始,结束,次,";
	
	var	columnIds =  "seq,pos,name,edit,len,spec,start,end,times,opter";  
	
	mygrid.flds = flds;
	
	mygrid.setHeader(flds);
	mygrid.setColumnIds(columnIds);
//    mygrid.setInitWidthsP("5,13,16,19,8,9,9,9,8,4");
    mygrid.setInitWidthsP("5,19,15,22,5,7,9,9,5,4");
    mygrid.setColSorting("int,str,str,str,str,int,str,str,int");
	mygrid.setColAlign("center,left,left,left,center,center,center,center,center,center");
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
	mygrid.setEditable(false);
	mygrid.setOnRowSelectHandler(onRowSelectd,true);
	mygrid.setOnRowDblClickedHandler(onRowDblClicked,true);
	
//	mygrid.enableAutoSizeSaving();
	mygrid.setSkin("modern2");
//	mygrid.enableAlterCss("even","uneven");
   
	mygrid.attachHeader(["#rspan","<div id='orderDetail_grid_title_flt1'></div>","<div id='orderDetail_grid_title_flt2'></div>","<div id='orderDetail_grid_title_flt3'></div>","<div id='orderDetail_grid_title_flt4'></div>","<div id='orderDetail_grid_title_flt5'></div>","<div id='orderDetail_grid_title_flt6'></div>","<div id='orderDetail_grid_title_flt7'></div>","<div id='orderDetail_grid_title_flt8'></div>","#rspan"]);
 
	mygrid.init();	
	
//	attachHeaderNew(grid,"<center><input type='checkBox' id='incPullAllSelect' value='0' onclick= 'javascript:selectCheckBoxAll(1)'></center>,<div id='paydt_flt'></div>,<div id='title_flt'></div>,<div id='author_flt'></div>,<div id='signuser_flt'></div>,#rspan,#rspan,<div id='pulldate_flt'></div>,#rspan,#rspan");
	 
	

	$("orderDetail_grid_title_flt1").appendChild(document.getElementById("pos_flt_box").childNodes[0]);
	$("orderDetail_grid_title_flt2").appendChild(document.getElementById("name_flt_box").childNodes[0]);
	$("orderDetail_grid_title_flt3").appendChild(document.getElementById("edit_flt_box").childNodes[0]);
	$("orderDetail_grid_title_flt4").appendChild(document.getElementById("len_flt_box").childNodes[0]);
	$("orderDetail_grid_title_flt5").appendChild(document.getElementById("spec_flt_box").childNodes[0]);
	$("orderDetail_grid_title_flt6").appendChild(document.getElementById("satrt_flt_box").childNodes[0]);
	$("orderDetail_grid_title_flt7").appendChild(document.getElementById("end_flt_box").childNodes[0]);
	$("orderDetail_grid_title_flt8").appendChild(document.getElementById("time_flt_box").childNodes[0]);	
    
//	orderDetail.attachHeaderNew(mygrid,"#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,<center><input type='checkBox' id='incPullAllSelect' value='0' onclick= 'javascript:show_details_fiter(this)'></center>");

//	show_details_fiter();
}

//function show_details_fiter(t){
//	var show = false;
//	if(t){
//		 show = t.checked;
//	}
//	if(show){
//		$("orderDetail_grid_title_flt1").show();
//		$("orderDetail_grid_title_flt2").show();
//		$("orderDetail_grid_title_flt3").show();
//		$("orderDetail_grid_title_flt4").show();
//		$("orderDetail_grid_title_flt5").show();
//		$("orderDetail_grid_title_flt6").show();
//		$("orderDetail_grid_title_flt7").show();
//		$("orderDetail_grid_title_flt8").show();
//	}else{
//		$("orderDetail_grid_title_flt1").hide();
//		$("orderDetail_grid_title_flt2").hide();
//		$("orderDetail_grid_title_flt3").hide();
//		$("orderDetail_grid_title_flt4").hide();
//		$("orderDetail_grid_title_flt5").hide();
//		$("orderDetail_grid_title_flt6").hide();
//		$("orderDetail_grid_title_flt7").hide();
//		$("orderDetail_grid_title_flt8").hide();
//	}
//}





function initGrid1(){
	mygrid1 = new dhtmlXGridObject('gridbox1');
//	mygrid1.selMultiRows = true;
	mygrid1.setImagePath(ctxPath+"image/grid/");
	
//	mygrid1.setSkin("modern2");

	mygrid1.enableAlterCss("even","uneven");
	
//	mygrid1.setRowTextStyle(id,'background-color:white;font-size:13px;');
	
	var flds = "审,频道,时段,磁带,名称,版本,长度,类别,指定,备注,月,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,总次,应付";

	var columnIds = "order,carrier,resource,tapCode,advName,edit,length,subcate,specific,publishMemo,month," 
					+"day1,day2,day3,day4,day5,"
					+"day6,day7,day8,day9,day10,"
					+"day11,day12,day13,day14,day15,"
					+"day16,day17,day18,day19,day20,"
					+"day21,day22,day23,day24,day25,"
					+"day26,day27,day28,day29,day30,"
					+"day31,monthTimes,price";
					
	mygrid1.setHeader(flds);  				
	mygrid1.setColumnIds(columnIds);


	
//	1.5*10 =15 + 2 =17
//	23*2 = 46
//	3*5 =15
//  3*3 =9
//	2*7 =14
	

	mygrid1.setInitWidthsP("2,4,6,4,4,5,3,3,3,3,2,1.5,1.5,1.5,1.5,1.5,1.5,1.5,1.5,1.5,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3.5,3");
	mygrid1.setColAlign("center,left,left,left,left,left,center,center,right,right,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,right,right");
	mygrid1.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
//    mygrid1.setColHidden("order,carrier");
//    mygrid1.setMultiLine(false);
//    mygrid1.enableMultiselect(true); 
//    mygrid1.enableKeyboardSupport(true);  
		mygrid1.setEditable(false);
//    mygrid1.setOnRowSelectHandler(doOnRowSelected,true);
    mygrid1.setOnRowDblClickedHandler(doOnRowSelected,true);
    
//    mygrid1.enableAutoSizeSaving();
    
//    var expires = new Date();
//    expires.setTime(expires.getTime() + 24 * 30 * 60 * 60 * 1000); // sets it for approx 30 days.
//    mygrid1.enableAutoSizeSaving("order_details_grid_cooker","expires=Fri, 31-Dec-2015 23:59:59 GMT");
//    mygrid1.setOnRowDblClickedHandler(doOnReturn);
//    mygrid1.setColSorting("int,str,str,str,str,str,int,str,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int") ;

	
	mygrid1.head2 = new Array();
//	mygrid1.head2.push("#rspan");
	mygrid1.head2.push("<div id='orderDetail2_grid_title_flt0'></div>");//频道
	mygrid1.head2.push("<div id='orderDetail2_grid_title_flt1'></div>");//频道
	mygrid1.head2.push("<div id='orderDetail2_grid_title_flt2'></div>");//时段
	mygrid1.head2.push("<div id='orderDetail2_grid_title_flt3'></div>");
	mygrid1.head2.push("<div id='orderDetail2_grid_title_flt4'></div>");//名称
	mygrid1.head2.push("<div id='orderDetail2_grid_title_flt5'></div>");//版本
	mygrid1.head2.push("<div id='orderDetail2_grid_title_flt6'></div>");//长度
	mygrid1.head2.push("<div id='orderDetail2_grid_title_flt7'></div>");//类别
	mygrid1.head2.push("<div id='orderDetail2_grid_title_flt8'></div>");
	mygrid1.head2.push("<div id='orderDetail2_grid_title_flt9'></div>");//指定
	mygrid1.head2.push("<div id='orderDetail2_grid_title_flt10'></div>");
	for(var i = 0;i<33;i++){
		mygrid1.head2.push("#rspan");
	}



	
	mygrid1.attachHeader(mygrid1.head2);
	
	
	
	
	mygrid1.footer2 = new Array();
	mygrid1.footer2.push("<div id='grid1_total_rows'/>");
	for(var i = 1;i<42;i++){
		mygrid1.footer2.push("<span/>");
	}
	mygrid1.footer2.push("<div id='grid1_total_times'/>");
	mygrid1.footer2.push("<div id='grid1_month_relplay'/>");
//	mygrid1.footer2.push("<span/>");
	mygrid1.attachFooter(mygrid1.footer2);		
	

	
	mygrid1.init();
	
	
	mygrid1.setColSorting(",str,str,str,str,str,int,str,str,str,int") ;
	mygrid1.setSortImgState(true,1,"ASC"); 

	$("orderDetail2_grid_title_flt0").appendChild(document.getElementById("grid2_flt_box0").childNodes[0]);	
	$("orderDetail2_grid_title_flt1").appendChild(document.getElementById("grid2_flt_box1").childNodes[0]);
	$("orderDetail2_grid_title_flt2").appendChild(document.getElementById("grid2_flt_box2").childNodes[0]);
	$("orderDetail2_grid_title_flt3").appendChild(document.getElementById("grid2_flt_box3").childNodes[0]);
	$("orderDetail2_grid_title_flt4").appendChild(document.getElementById("grid2_flt_box4").childNodes[0]);
	$("orderDetail2_grid_title_flt5").appendChild(document.getElementById("grid2_flt_box5").childNodes[0]);
	$("orderDetail2_grid_title_flt6").appendChild(document.getElementById("grid2_flt_box6").childNodes[0]);
	$("orderDetail2_grid_title_flt7").appendChild(document.getElementById("grid2_flt_box7").childNodes[0]);
	$("orderDetail2_grid_title_flt8").appendChild(document.getElementById("grid2_flt_box8").childNodes[0]);
 	$("orderDetail2_grid_title_flt9").appendChild(document.getElementById("grid2_flt_box9").childNodes[0]);
	$("orderDetail2_grid_title_flt10").appendChild(document.getElementById("grid2_flt_box10").childNodes[0]);


    mygrid1.setSizes();	
}






function doOnRowSelected(id,id2){

   if(tvNameParam !='hbtv'){
   	
	    function draw(rowId){
			var row = mygrid1.getRowById(rowId);
			var s = row.getAttribute("mybgcolor");
			if(isUndefined(s)) s ="";
		
			if(s == 'red') {
				row.setAttribute("mybgcolor","");
				var css = row.className.indexOf(mygrid._cssUnEven) >-1 ?"background-color:#eee;":"background-color:white;";
				mygrid1.setRowTextStyle(rowId,css); 
			}else{
				row.setAttribute("mybgcolor","red");
				mygrid1.setRowTextStyle(rowId,'background-color:#FFCC99;font-size:13px;CURSOR: pointer;');
			}
	    } 
	    
	    if(id){
	    	draw(id)
	    }else{
	        var fined =false;
	    	for(var i = 1;i<mygrid1.getRowsNum()+1;i++){
	    		var orderDetailId = mygrid1.getUserData(i,"orderDetailId");
	    		if(id2 == orderDetailId && fined ==false){
	    			draw(i);fined =true;
	    			mygrid1.showRow(i);
	//    			mygrid1.scrollTop = i*20;
	    		}else{
	    			var row = mygrid1.getRowById(i);
					row.setAttribute("mybgcolor","");
					var css = row.className.indexOf(mygrid._cssUnEven) >-1 ?"background-color:#eee;":"background-color:white;";
					mygrid1.setRowTextStyle(i,css); 
	    		}
	    	}
	    }
   }else{
   	 
                
				var orderDetailId = mygrid1.getUserData(id,"orderDetailId");
				var isStartRow = mygrid1.getUserData(id,"isStartRow");
				var grid  = mygrid1;
   	  var ids  = new Array();
   	  var changeState = 3;//passed state
   	  var passCount = 0;
   	  var passOrderDetailIds = new Array();
   	  var sumCount = mygrid.getRowsNum();
   	  var rowIndex = 0;
   	  
   	  if(isStartRow == 1){
						var rows = grid.getRowsNum();
						  try {
							  			for(var i=0; i< rows;i++){
												var i_d = grid.getRowId(i);
												var isVisiable = grid.getRowByIndex(i).style.display =="";
												var checkState =  grid.getUserData(i_d,"checkState");			
												var isStartRow2 = grid.getUserData(i_d,"isStartRow");
											  var detailId =  grid.getUserData(i_d,"orderDetailId");
																					
												if(checkState == changeState && isStartRow2 ==1){
													passCount++;
													passOrderDetailIds.push(detailId);
												}
												if(isVisiable){
													
													if(orderDetailId == detailId && checkState !=changeState){
														 mygrid1.setRowHidden(i_d,true);
//														 grid.cells(i_d,0).setValue("是");
														 grid.setUserData(i_d,"checkState",changeState);
														 	if(isStartRow2 ==1){
														 		 ids.push(orderDetailId);
														 		 rowIndex = i_d;
														 		 passOrderDetailIds.push(detailId);
														 		 }
													}
												}
												

												
												
					
											}	
						  	} catch (e) {
						    	
						    }

   	  	  
   				  }
   				  
   		function callbakFun(){
   				  	
   				  }
   				   
   		if(ids.length > 0){
   			
   				  	orderDetailColl.saveOrderDetailCheckState(ids.join(','),changeState,callbakFun);
   				  	
   				  	grid.cells(rowIndex,0).setValue("是");
   				  	
						 		function callBak(){
						            if(config_allowModiyPassedOrderParam ==0)lockDestopOrderDetail(false);
//						            if(changeState == 3) getOrderDetailTable(orderDetail,null);
								}  				  	

								passCount++;

								if(sumCount == passCount){
										var defMsg ="【订单总览上全部审核通过】";
									 var oldState = $("isCkecked").value;
									 var checkeds = [order.obj.id];
   				  			order.updateOrderStates2(checkeds,changeState,loginUserId,oldState,defMsg,callBak); 
   				  			$("orderDetail_mod_states").value="通过"; 
   				  			$("isCkecked").value =3;
   				  	        	}

							resetMygrid1RowClass(orderDetailId,1);

   				  }
   	  
   }


    
}


function resetMygrid1RowClass(orderDetailId,type){
   				  	var row = mygrid.getRowById(orderDetailId);
   				  	var s = row.getAttribute("class");
								//remove red
   				  	if(type ==1){
   				  		  	s = s.replace("uneven_red","")
   				  				}
								//add red
   				  	if(type ==2){
   				  		  	s = s + " uneven_red";
   				  				}
								row.setAttribute("class",s);
}



function onRowDblClicked(rowId,colIndex){
	var  orderDetailId = orderDetail.obj.id;
    if(config_isOpenOrderOrgParam == 1) showOrderLog(orderDetailId);
}
function onRowSelectd(rowId,colIndex){
    selected_OrderDetails_grid(rowId);
	var colName = mygrid.getColumnId(colIndex);
	var rowIndex = mygrid.getRowIndex(rowId);
	getOrderDetail(rowId,colIndex);
}

function resetHeigth(){
	var orderBaseInfoFrm = $("order_baseInfo_frm");
	var orderDetailFrm = $("order_detail_frm");
	var orderBaseInfoFrm_div = $("gridbox");
	orderBaseInfoFrm_div.style.height = (orderBaseInfoFrm.offsetHeight+orderDetailFrm.offsetHeight)*0.9 +"px";
	
	
//	$("theDivPublishMemo").style.width = $("dtPublishMemo").offsetWidth*2.6 +"px";
//	$("textareaPublishMemo").style.width =  $("theDivPublishMemo").style.width +"px";	
};


function setCurUserId(){
	

//		if(tvNameParam=='fztv'){
//			var callback=function(objs){
//				for(var i in objs){
//					if(objs[i]=='宣传片录入') isFree = true;
//				}
//			}
//			user.getUserRolesCols(loginUserId,'lable',callback); 
//		}
		if(orderDetailStates == 2) {
			int_set_user(loginUserId,loginUserFullName);
//			Ext.getCmp("userId").setValue(loginUserId);
			
		}
};

function getMatterLengthComplt(){
	priceDetail.getPriceDetailAutoComplet(payMatterLengthAutoComplet);
};

function payMatterLengthAutoComplet(objs)
{
	var oText_MatterLength = $("matterLength");
	var oDiv_MatterLength = $("theDivmatterLength");
	var indexColumName_MatterLength = ["length"];
	var allColumsName_MatterLength =["length"];

	var onDivMouseDown_MatterLength = function(ev){
		var tr = getElementByEvent(ev);
		$("length").value = getCellValue(tr,0);
		oText_MatterLength.value = getCellValue(tr,0);
		getMatterAutoComplet();
	}

	var onTextBlur = function(ev){
		$("Btn_addAndPost2").disabled = false;
		var isd = isDigit(oText_MatterLength.value);
	    if(!isd){ oText_MatterLength.value ="";extjMessage('必须数字!');return false;}
		oDiv_MatterLength.style.visibility = "hidden";
		if(trim(oText_MatterLength.value) == "" ){$("length").value = '0';}

		if($("length").value != '0'){getMatterAutoComplet();}
		
	    function fnc(){
	        	var isNewOrderDetail = (orderDetailStates == 2||orderDetailStates == 3);
	        	backupBroarrayToCur(isNewOrderDetail,null,true);//用来防止超时:因为原来第一次占用超时会报超时，第二次就不会清除；坏处是再次回到不超时状态也会清除。
	    }
	   getSysPrice(false,fnc);
	}
   new AutoComplete(objs,oText_MatterLength,oDiv_MatterLength,-1,onDivMouseDown_MatterLength,onTextBlur,"",indexColumName_MatterLength,allColumsName_MatterLength,null);
};



function getContarctAuto(){
	if(config_contractsort == 0){
		getContractPayMentsAutoComplete();
	}else{
		getContractsAutoComplete();
	}	
}

function addOrderDetail(){
	if(checkOrderStates('不允许添加','edit')) return false;
//	orderDetail.obj.id=null;  
//	orderDetailBackUp ={id:null};
	save_Order();
}
function editOrderDetail(){
	if(order.obj.id <1) return false;
	if(checkOrderStates('不允许编辑','edit')) return false;
	save_Order();
}

function changeOrderStates(){
	    var changeState = 0;
	    var oldState = $("isCkecked").value;
	    var Btn_submit = $("Btn_submit");
		var checkeds =[order.obj.id]; var defMsg ="【订单编辑】";
		
		if(orderDetailStates == 2){
			 extjMessage('新添状态无法操作!');
			return false;
		}
		
		function callBak(){
//			$("orderDetail_mod_states").value="未审批"; 
////			$("Btn_submit").hide();
//            if(state == 0){
//				$("Btn_submit").value="提交";
//			}else{
//				$("Btn_submit").value="通过";
//			}
            if(config_allowModiyPassedOrderParam ==0)lockDestopOrderDetail(false);
            
             
            
					if(config_withoutSubmit == 1){
						
						   var rows = mygrid.getRowsNum();
						
								for(var kk = 0 ;kk<rows;kk++){
									var order_detail_id = mygrid.getRowId(kk);
			
		            if(changeState == 0 ) {
													resetMygrid1RowClass(order_detail_id,2); 
		           						 }
		            if(changeState == 3) {
													resetMygrid1RowClass(order_detail_id,1);
		           						 }	
								}
								
								var displayBtnValue = $("Btn_orderDetail").value;
								if(displayBtnValue.indexOf('关闭')>-1){
								   var rows = mygrid1.getRowsNum();
								
										for(var kk = 0 ;kk<rows;kk++){
											var row_id = mygrid1.getRowId(kk);
											var value = changeState == 3?"是":"";
											mygrid1.setUserData(row_id,"checkState",changeState);
											mygrid1.cells(row_id,0).setValue(value);
										}
								}	
								
	 
           						 
					}else{
           	if(changeState == 3) getOrderDetailTable(orderDetail,null);
                      }
            
			
		}
		


		if(oldState == 0||oldState == 4){
			if(config_withoutSubmit == 1){
				 changeState = 3;
				 Btn_submit.value="退回";
 					if(tag_check_right){
						Btn_submit.show();
				 }else{
						Btn_submit.hide();
				 }
				 $("orderDetail_mod_states").value="通过"; 
				 $("isCkecked").value = changeState;
				 orderBackUp.isCkecked = changeState;
				 extjMessage('此订单审批通过!');				 
				 
			}else{
				 changeState = 1;
				 Btn_submit.value="通过";
				 if(tag_check_right){
					Btn_submit.show();
				 }else{
					Btn_submit.hide();
				 }
				 
				 $("orderDetail_mod_states").value="未审批"; 
				 $("isCkecked").value = changeState;
				 orderBackUp.isCkecked = changeState;
				 extjMessage('此订单进入审批环节!');
			}

			 
		}else{
			
			if(config_withoutSubmit == 1){
				 if(oldState == 3){
				 	 changeState = 0;
				 	 $("isCkecked").value = changeState;
				 	 Btn_submit.value="通过";
				 	 $("orderDetail_mod_states").value="被退回"; 

				 	 if(tag_order_submitbtn){
				 	  	 Btn_submit.show();
				 	 }else{
				 	 	 Btn_submit.hide();
				 	 }	
				 	 
					 if(tag_check_right){
						Btn_submit.show();
					 }else{
						Btn_submit.hide();
					 }
				 	 orderBackUp.isCkecked = changeState;	
				 	 extjMessage('此订单已被退回!');
				 }

			}else{
				
					 if(oldState == 3){
				 	 changeState = 4;
				 	  $("orderDetail_mod_states").value="被退回"; 
				 	  $("isCkecked").value = changeState;
				 	   extjMessage('此订单已被退回!');
				 	   
				 	   Btn_submit.value="提交";
				 	   
				 	 if(tag_order_submitbtn){
				 	  	 Btn_submit.show();
				 	 }else{
				 	 	 Btn_submit.hide();
				 	 }	
				 	 orderBackUp.isCkecked = changeState;	
				 }else{
					 changeState = 3;
	//				 Btn_submit.hide();
					 Btn_submit.value="退回";
					 $("orderDetail_mod_states").value="通过"; 
					 $("isCkecked").value = changeState;
					  extjMessage('此订单审核通过!');
					 if(tag_check_right){
						Btn_submit.show();
					 }else{
						Btn_submit.hide();
					 }
					 
					 orderBackUp.isCkecked = changeState;
	//				 orderDetailBackUp.order.isCkecked
					
				 }			
				
				
			}


		}
		
		order.updateOrderStates2(checkeds,changeState,loginUserId,oldState,defMsg,callBak);
		
//	}else{
//		if(oldState == 3){
//			  changeState = 0;
//			   Btn_submit.value="退回";
////			   Btn_submit.hide();
//			  $("isCkecked").value = changeState;
//		}else{
//			   changeState = 3;
//			   Btn_submit.hide();
//			  $("isCkecked").value = changeState;
//		}		
//	}
		
		

		
		
		
		
}

function close_order_memo(){
	closeDiv();
	
	if(order.obj.id > 0){
		var obj = (new Order()).obj;
		obj.orderMeno = $("textareaOrderMeno").value;
		obj.publishMemo = $("textareaOrderPublishMemo").value;
		function callFun(){};
		order.saveOrderMemo(obj,callFun);
	}
}

//事件填充
function buttonEventFill(){
//	function doResize(){
//	   alert('resize');
//	   resetDialogcontentHeigth();
//	   resetHeigth();
//	}
//	window.onresize = function(){
//	   setTimeout(doResize,0);
//	}
//	
//	var Btn_addOrderDetail = $("Btn_addOrderDetail");
//	if(!isUndefined(Btn_addOrderDetail)){ 	
//		Btn_addOrderDetail.onclick = addOrderDetail;
//	}
//	
//	var Btn_editOrderDetail = $("Btn_editOrderDetail");
//	if(!isUndefined(Btn_editOrderDetail)){ 	
//		Btn_editOrderDetail.onclick = editOrderDetail;
//	}
	//新添定单按钮
	var Btn_addNewOrder = $("Btn_addNewOrder");
	Btn_addNewOrder.setAttribute("href","javascript:void 0");
	Btn_addNewOrder.onclick = addNewOrder;
	
//	var Btn_editOrder = $("Btn_editOrder");
//	Btn_editOrder.setAttribute("href","javascript:void 0");
//	Btn_editOrder.onclick = editOrderInfo;

	//保存按钮
	var Btn_save = $("Btn_save");
	Btn_save.onclick = save_Order;
	
	var Btn_search_adver_cont = $("search_adver_cont");
	Btn_search_adver_cont.onclick = search_adver_cont;

	var order_check_history1= $("order_check_history1");
	order_check_history1.onclick = order_check_history;
	
	
	//订单提交
	var Btn_submit = $("Btn_submit");
	Btn_submit.onclick = changeOrderStates;
	
	//广告素材自动下拉
	var Bt_tapeCode = $("matter.tapeCode");
	Bt_tapeCode.onclick = getMatterAutoCompletTapeCode;	
	Bt_tapeCode.onkeypress = function a(event){DWRUtil.onReturn(event,getMatterCodes);}
	
	var Bt_matterName = $("matter.name");
	Bt_matterName.onclick = getMatterAutoComplet;	
	Bt_matterName.onkeypress = function a(event){DWRUtil.onReturn(event,getMatterNames);}
//	Bt_matterName.onkeypress = function a(event){DWRUtil.onReturn(event,getMatterAutoComplet);}
	
	var Bt_matterEdit = $("matter.edit");
	Bt_matterEdit.onclick = getMatterAutoComplet;

	function getMatter_new(){
		getMatterAutoComplet(false);
	}
	//自动排期
//	var Btn_autoBroArrange = $("autoBroArrange");
//	Btn_autoBroArrange.onclick = autoBroArrange;

	//取消
	var Btn_cancel = $("Btn_cancel");
//	Btn_cancel.setAttribute("href","javascript:void 0");
	Btn_cancel.onclick = cancelOrder;
	//新添广告1
	var Btn_addNewAdver1 = $("Btn_addNewAdver1"); 
	Btn_addNewAdver1.onclick = addnewOrderDetail1;
	
	//快速下单
	var Btn_addNewAdver2 = $("Btn_addNewAdver2");
	Btn_addNewAdver2.onclick = add_new_OrderDetail_more;
	//单击广告长度 183
	var Btn_matterLength = $("matterLength");
	Btn_matterLength.onclick = Disable_addAndPost2;	 
	//新添广告
	var Btn_addAndPost1 = $("Btn_addAndPost1");
	Btn_addAndPost1.onclick = function(ev){postOrderDetailt(true);};
	//新添并粘贴
	var Btn_addAndPost2 = $("Btn_addAndPost2");
	Btn_addAndPost2.onclick = function(ev){postOrderDetailt(false);}; 
	//清除排期按钮
	var Bt_cleanBroArrange = $("cleanBroArrange");
	Bt_cleanBroArrange.onclick= function (){broArrange.cleanBroArrange();}
	//恢复
	var Bt_resumeBroArrange = $("resumeBroArrange");
	Bt_resumeBroArrange.onclick= resumeBroArrange;	
	//排期初试化
	var Bt_addBroArrange = $("addBroArrange");
	Bt_addBroArrange.onclick= addBroArrange;		
    //选择月份
	var Bt_selectMonth = $("selectMonth");
	Bt_selectMonth.onchange= selectMonth;
	//显示剩余时间
	var Bt_displayLeavTimes = $("isDisplayLeavTimes");
	Bt_displayLeavTimes.onclick = displayLeavTimes;	
	//获得加收
	var appRate = $("appRate");
	appRate.onkeyup = resetFavourRate;
	appRate.onafterpaste =  resetFavourRate;
	//获得折扣
	var favourRate = $("favourRate");
	favourRate.onkeyup = resetFavourRate;
	favourRate.onafterpaste =  resetFavourRate;
	
	var moneyRealpay = $("moneyRealpay");
//	moneyRealpay.onclick = displaySumMoney2;
	moneyRealpay.onkeyup = displaySumMoney2;
	
	
	//重载播出表 ，重新计算价格
//	var sysPrice = $("sysPrice");
//	sysPrice.onblur = setBroArrayangeMonthOnPriceChange;
//	sysPrice.onkeyup = resetFavourRate;
//	sysPrice.onafterpaste =  resetFavourRate;
	
	
	var execPrice = $("execPrice");
	execPrice.onkeyup = resetFavourRate;
	execPrice.onblur = setBroArrayangeMonthOnPriceChange;
	execPrice.onafterpaste =  resetFavourRate;
	
	var sysPrice = $("sysPrice");
	sysPrice.onkeyup = resetFavourRate;
	sysPrice.onblur = setBroArrayangeMonthOnPriceChange;
	sysPrice.onafterpaste =  resetFavourRate;	
	
	
	
	var moneyRealpay = $("orderPublic.moneyRealpay");
	moneyRealpay.onblur = isDigit2;	
	
	
// 	var Btn_composRadio = $("composRadioId");
//	Btn_composRadio.onclick=displayTreeGroupDiv;
//	
//	var Btn_basePosRadio = $("basePosRadioId");
//	Btn_basePosRadio.onclick=displayTreeGroupDiv;
	
//	显示套播资源树
	var carrierName = $("carrierName");
	carrierName.onclick = displayCompagesTree2; 

	var btn_packeg = $("btn_packeg");

	btn_packeg.onchange = function(e){ 
			getPosition(this.value);
			if(this.value == 2) displayCompagesTree2(e,true);
	}
//	btn_packeg.setAttribute("href","javascript:void 0");
//	btn_packeg.onclick = function getPacked(ev){
//		if(orderDetailStates == 1){
//			getPosition(2);displayCompagesTree2();
//		}
//	};

//	var btn_treeConfirm = $("btn_treeConfirm");
//	btn_treeConfirm.onclick = confirmCompages; 
//	
//	var btn_treeCancel = $("btn_treeCancel");
//	btn_treeCancel.onclick = closeCompagesTree; 


//	//显示套播资源树
//	var compagesPos = $("compages.pos");
//	compagesPos.onclick = displayCarrierTree;	
//	
//	//保存套播与价格
//	var confimRes = $("treeBt");
//	confimRes.onclick = confimResource;
//	
//	//关闭套播自动下拉框
//	var closeRes = $("treeBtCancel");
//	closeRes.onclick = colesResource;
//	
//	var isAutoPrice = $("compages.isAutoPrice");
//	isAutoPrice.onclick = autoPrice;	
	
		
	
	//显示付款信息
	var Btn_displayPayment = $("Btn_display");
	Btn_displayPayment.onclick = displayPayment;
	
	//获得补差
	var changeMoney = $("moneyBalance");
//	changeMoney.onclick = displaySumMoney;
//	changeMoney.onkeypress = displaySumMoneyKeypress;
//	changeMoney.onblur = displaySumMoney;
	
	changeMoney.onkeyup = displaySumMoney;
	changeMoney.onafterpaste =  displaySumMoney;	
	
	
	
	document.body.onfocus = closePopup;
	
//	var Btn_view_order = $("Btn_view_order");
//	Btn_view_order.onclick = button_view_order;
//
//	var Btn_print_order = $("Btn_print_order");
//	Btn_print_order.onclick = button_print_order;	
//	
//	var Btn_export_order = $("Btn_export_order");
//	Btn_export_order.onclick = button_print_export;	
	
	var Bt_orderDetail = $("Btn_orderDetail");
	Bt_orderDetail.onclick = displayOrderDetail;
	
//	var Btn_closeDetail = $("Btn_closeDetail");
//	Btn_closeDetail.onclick = closeOrderDetail;		
	
	var Bt_autoBroArrange = $("autoBroArrange");
	Bt_autoBroArrange.onclick = autoBroArrange_from_broArrangService;	
	
	var radiobutton_modes = $A($("selectMode").getElementsByTagName("input"));
	radiobutton_modes.each(function(ip){ip.onclick = changeMode;});	
	
	var Btn_confim = $("confim");
	Btn_confim.onclick = getBroArrange_from_broArrangService;
	
	var Btn_down = $("broDown");
	Btn_down.onclick = closeBroArrangeDiv;

	var change_order_year = $("order_year");
	change_order_year.onchange = rest_order_year;
	
 	var btn_orderMeno = $("orderMeno");
	btn_orderMeno.onclick = displayDiv;
	
	var btn_textareaOrderMeno = $("textareaOrderMeno");
//	btn_textareaOrderMeno.onblur=close_order_memo;
	
	var btn_textareaOrderPublishMemo = $("textareaOrderPublishMemo");
//	btn_textareaOrderPublishMemo.onblur=close_order_memo;

//	btn_textareaOrderMeno.onblur=closeDiv;
//	btn_textareaOrderMeno.onkeypress = displayOrderMeno;
	
	
	var btn_dtPublishMemo = $("dtPublishMemo");
	if(tvNameParam == 'sjz'){
		btn_dtPublishMemo.onclick = function(){
				$("theDivPublishMemo").style.visibility = "visible";
				$("textareaPublishMemo").value = this.value;		
				$("textareaPublishMemo").focus();		
		};
		
		$("textareaPublishMemo").onblur =  function(){
			$("theDivPublishMemo").style.visibility = "hidden";
			$("dtPublishMemo").value = this.value;
		}
//		$("Btn_close_publish_memo").onclick = function(){
//			$("theDivPublishMemo").style.visibility = "hidden";
//			$("dtPublishMemo").value = this.value;
//		}
	}else{
		btn_dtPublishMemo.setAttribute("maxlength",16);
	}

	
	
	
	var Btn_change_matter_brotime = $("Btn_change_matter_brotime");
	Btn_change_matter_brotime.onclick = changeMatterEdit;
	
	var Btn_save_order_memo = $("Btn_save_order_memo");
	Btn_save_order_memo.onclick = function(){
		closeDiv();save_Order();
	};	
	
	var Btn_close_order_memo = $("Btn_close_order_memo");
	Btn_close_order_memo.onclick = function(){closeDiv();};	

	
	var postFlt = $("orderDetail_grid_title_flt1").childNodes[0];
	var nameFlt = $("orderDetail_grid_title_flt2").childNodes[0];
	var editFlt = $("orderDetail_grid_title_flt3").childNodes[0];
	var lenFlt = $("orderDetail_grid_title_flt4").childNodes[0];	
	var specFlt = $("orderDetail_grid_title_flt5").childNodes[0];
	var startFlt = $("orderDetail_grid_title_flt6").childNodes[0];
	var endFlt = $("orderDetail_grid_title_flt7").childNodes[0];
	var timeFlt = $("orderDetail_grid_title_flt8").childNodes[0];		
	
  var selObjs =[postFlt,nameFlt,editFlt,lenFlt,specFlt,startFlt,endFlt,timeFlt];
    
//    resetDetailsTableSumBland();
    
    for (var k = 0; k < selObjs.length; k++){
		    	var selObj = selObjs[k];
		    	if( k == 0 || k == 2){
		    			selObj.onkeyup = function(ev){
//					    	var el = getElementByEvent(ev);
					    	orderDetail.filterBy(mygrid,selObjs,resetDetailsTableSumBland);
				    		}
		    	}else{
			    	selObj.onchange = function(ev){
//						    	var el = getElementByEvent(ev);
						    	orderDetail.filterBy(mygrid,selObjs,resetDetailsTableSumBland);
					    	}
		    	   }
    		}
    		
    		
 	var grid2_flt0 = $("orderDetail2_grid_title_flt0").childNodes[0];   		
	var grid2_flt1 = $("orderDetail2_grid_title_flt1").childNodes[0];
	var grid2_flt2 = $("orderDetail2_grid_title_flt2").childNodes[0];
	var grid2_flt3 = $("orderDetail2_grid_title_flt3").childNodes[0];
	var grid2_flt4 = $("orderDetail2_grid_title_flt4").childNodes[0];	
	var grid2_flt5 = $("orderDetail2_grid_title_flt5").childNodes[0];
	var grid2_flt6 = $("orderDetail2_grid_title_flt6").childNodes[0];
	var grid2_flt7 = $("orderDetail2_grid_title_flt7").childNodes[0];
	var grid2_flt8 = $("orderDetail2_grid_title_flt8").childNodes[0];	
	var grid2_flt9 = $("orderDetail2_grid_title_flt9").childNodes[0];		
	var grid2_flt10 = $("orderDetail2_grid_title_flt10").childNodes[0];		
	
			
				
	
  var selObjs1 =[grid2_flt0,grid2_flt1,grid2_flt2,grid2_flt3,grid2_flt4,grid2_flt5,grid2_flt6,grid2_flt7,grid2_flt8,grid2_flt9,grid2_flt10];
    
  mygrid1.selObjs1 = selObjs1;
    
//    resetDetailsTableSumBland();
    
    for (var k = 0; k < selObjs1.length; k++){
		    	var selObj = selObjs1[k];
			    	selObj.onchange = function(ev){
//						    	var el = getElementByEvent(ev);
						    	orderDetail.filterBy1(mygrid1,selObjs1,resetDetailsTableSumBland1);
					    	}

		    	
    		}  		

};


function resetDetailsTableSumBland1(){
	var grid = mygrid1;
	var rows = grid.getRowsNum();
	var sum_times = 0;
	var sum_price =0;

	  try {
		  			for(var i=0; i< rows;i++){
							var id = grid.getRowId(i);
							var isVisiable = grid.getRowByIndex(i).style.display =="";
							if(isVisiable){
								var times =  grid.getUserData(id,"times");
								var price =  grid.getUserData(id,"price");
								sum_times += times*1; 
								sum_price += price*1;
							}

						}	
	  	} catch (e) {
	    	
	    }
	  	
	  	
	  	
	  		DWRUtil.setValue("grid1_total_rows", grid.getRowsNum());
	    	DWRUtil.setValue("grid1_total_times", sum_times);
	    	DWRUtil.setValue("grid1_month_relplay", sum_price);

	    

}


//显示剩余时间 resetDetailsTableSumBland();
function displayLeavTimes(ev){
    var v = $("isDisplayLeavTimes").value;
//    if(v.indexOf')
	broArrange.displayLeave = !broArrange.displayLeave;
	
	if(broArrange.displayLeave){
		$("isDisplayLeavTimes").value ="关闭星期";
	}else{
		$("isDisplayLeavTimes").value ="显示星期";
	}
	
	var rsId =$("resourceInfoId").value;
	var specificValue = getSelectParamFromAttribute($("resourceSpecificId"),"position");
//	var isLock = broArrange.displayLeave;
	var isLock = false;
	getMonthInfos(isLock,rsId,specificValue,broArrange.startDate,broArrange.endDate,null,false);
}
//function grid_titile_filterBy(col){
//	var postFlt = document.getElementById("pos_flt_box").childNodes[0];
//	orderDetail.filterBy(mygrid,col,postFlt.value,"resourceInfoId");
//}

function autoBroArrange_from_broArrangService(){ 
	
//	alert(1)
	
//	broArrange.reset();
	
    var targDiv = $("broArrangeDiv");
    var startEl =  $("beginDate");
	var endEl =  $("overDate");
	var selectMonthCmd = $("selectMode");
	autoBroArrange(_app_params,order_year,targDiv,selectMonthCmd,startEl,endEl,orderDetailBackUp,broArrange,orderDetailStates);
};

function getBroArrange_from_broArrangService(){ 

	var rsId =$("resourceInfoId").value;
	var specificValue = getSelectParamFromAttribute($("resourceSpecificId"),"position");
	var isLock = false;
    function fun(callBakFun){
    	getMonthInfos(isLock,rsId,specificValue,broArrange.startDate,broArrange.endDate,callBakFun,false);
    }
	getBroArrange(_app_params,orderDetailBackUp,broArrange,fun);  
};

function getMatterNames(matter_name){
   var name = matter_name||$("matter.name").value;
 
   if(name !='' && name.length>0){
//	    $("matter.name").value = name;
//       getMatterAutoComplet();
		matter.reset();
		matter.obj.orgId =orgId;
		matter.obj.customerId = null;
	    matter.obj.name= name;
//	    matter.obj.length =  $("length").value*1;
		matter.getMatterAutoCompletDIV(mattersAutoComplete3,matter.obj);
//	    matter.getMattersByCustomerIdAndLength(matter.obj,mattersAutoComplete);   
		
//		if(name.length>0){
//			var name2 = name.substring(0,1);
//			var cmd = Ext.getCmp('search_brand');
//			cmd.setRawValue(name2);
////			this.fireEvent('losfoce', cmd);   
//			cmd.onTriggerClick(); 
//		}
   }
};

function getMatterCodes(){
   var code = $("matter.tapeCode").value;
   
   if(code !='' && code.length>0){
   	  var obj = (new Matter()).obj;
   	  obj.tapeCode = code;
   	  obj.orgId = orgId;
   	  
   	  function callBak(o){
   	  	var id = o.id;
		var oDiv_tapeCode = $("theDivTapeCode");
		oDiv_tapeCode.style.visibility = "hidden";
		
   	  		$("dt_matter.id").value = '';
   	  		$("matter.edit").value = '';
   	  		$("matter.name").value = '';
   	  		$("matterLength").value = '';
   	  		$("matterType").value = '';
   	  		industry.treecombo.setValue('');			
		
   	  	if(id > 0){
   	  		$("dt_matter.id").value = o.id;
   	  		$("matter.edit").value = o.edit;
   	  		$("matter.name").value = o.name;
   	  		$("matterLength").value = o.length;
   	  		$("matter.tapeCode").value = o.tapeCode;
   	  		$("matterType").value = o.matterType;
   	  		var brandName  = o.industry.name;
   	  		var brandId  = o.brandId;
   	  		industry.treecombo.passField.value =  brandId;
            industry.treecombo.setValue(brandName);	

            mattersAutoCompleteTapeCode([o]);         

   	  	}else{
   	  		 extjMessage('未能找到匹配的素材!');
   	  		$("matter.tapeCode").focus();
   	  	}
   	  }
       matter.getMatterByTapCode(obj,callBak)
   }
};

function displayCompagesTree2(ev,changed){
	var dialogcontent = $("dialogcontentDiv");
	var dialogcontentW = dialogcontent.offsetWidth;
	var dialogcontentH = dialogcontent.offsetHeight;
	var winW= dialogcontentW * 0.35;
	var winH = dialogcontentH*0.8;
//	var el = getElementByEvent(ev);
	
	var resourceSort =  getSelectParamFromAttribute($("resourceSortId"),"paramvalue");
	


	 if(!compagesDiaWin){
	 	
	 	var rd = new Ext.form.RadioGroup({
		hideLabel : true,   //隐藏RadioGroup标签
		style:'margin-left:100px;align:middle;CURSOR:pointer;', 
		vertical :false, 
		width : 150,
		columns : 2, 
		name:'opt_package',
		id:"opt_package",
                 items:[
                     new Ext.form.Radio({boxLabel:'固定套装', name:'opt_package1', checked:'true',inputValue:"1",width : 40,listeners : {
                     	 check : function(checkbox, checked) {   if (checked) { 
                     	 		$("compagesTreebox2").show(); $("carrierTypeTreebox2").hide();
                     	   } }
                     } }),
                     
                     new Ext.form.Radio({boxLabel:'自选段位  ', name:'opt_package1',inputValue:"2",width :40,listeners : {
                     	 check : function(checkbox, checked) {   if (checked) { displayCompagesTree2(); } }
                     } })
                 ]
     	});
//		var okBtn1 ={text: '生成排期',handler: function(){compagesDiaWin.hide();addnewOrderDetail2();}};
		var okBtn ={text: '确定',handler: function(){compagesDiaWin.hide();confirmCompages(function(){compagesDiaWin.hide();});}};
	 	var closeBtn ={text: '关闭',handler: function(){compagesDiaWin.hide();}};
		 compagesDiaWin = new Ext.Window({
			   title : '套装广告',
			   width : winW,
			   height : winH,
			   isTopContainer : true, 
			   modal : true,
			   resizable : false,
			   tbar:[rd],
			   buttons: [okBtn,closeBtn],
			   contentEl :  $("treeGroup2")
		  	}); 	
	 }
	 
	compagesDiaWin.show(this);
	
 var checkedItem = Ext.getCmp('opt_package').getValue();
 
// var el_vslue = el? el.value:null;
 
 if(checkedItem.getGroupValue() == 1){

 	 	getCompagesTree(compages,resourceSort);
 	 	$("compagesTreebox2").style.height = compagesDiaWin.getInnerHeight()+"px";;
		if(compages.tree!=null && compages.tree.dhtmlTree.getXMLState() && changed){
			 compages.tree.refreshTree();
		}

		$("compagesTreebox2").show(); 
		$("carrierTypeTreebox2").hide();
 }else{
		if(carrierType.tree==null){
			setCarrierTypePara(carrierType);  
			getCarrierTypeTree(carrierType);  
	//		$("carrierTypeTreebox2").style.height  = winH*0.8+"px";
			 $("carrierTypeTreebox2").style.height = compagesDiaWin.getInnerHeight()+"px";;
		}
		if(carrierType.tree !=null && carrierType.tree.dhtmlTree.getXMLState() && changed){
			 carrierType.tree.refreshTree();
		}

		$("compagesTreebox2").hide();     
		$("carrierTypeTreebox2").show();  	
 }
 
 
};

function displaySumMoney2(){
	

    
	if(config_orderCalculateModel == 0){
 		var old_Realpay = $("moneyBase").value*1;
		var broSumTime = $("broSumTime").value*1;
		var sumTotal = $("moneyRealpay").value*1;
		var moneyBalance = $("moneyBalance").value*1;
		sumTotal = sumTotal + moneyBalance;
		
//		 alert(sumTotal)
		
        if(old_Realpay == 0 && broSumTime == 0){
	            extjMessage('请先输入排期!');
	        	return false;
        }
		var rate = 0;
		if(old_Realpay==0){
			$("favourRate").value = 0;
			$("appRate").value = 0;
			$("execPrice").value= sumTotal/broSumTime;	
//			$("execPrice").value=0;
		}else{
			rate = sumTotal/old_Realpay;
			if(rate<1){
				$("favourRate").value = rate*100;
				$("appRate").value = 0;
			}else{
				$("appRate").value = rate*100;
				$("favourRate").value = 0;
			}
			$("execPrice").value=$("sysPrice").value*rate;
		}
	}else{
		
		  
		    
		var old_Realpay = $("moneyBase").value*1;
        var sumTotal = $("moneyRealpay").value*1;
        var moneyBalance = $("moneyBalance").value*1;
        var broSumTime = $("broSumTime").value*1;
        var execPrice = $("execPrice").value*1;
        var appRate = $("appRate").value*1;
        var favourRate = $("favourRate").value*1;
        
        
//        alert('moneyBase'+old_Realpay)
//         alert('sumTotal'+sumTotal)
//          alert('moneyBalance'+moneyBalance)
//           alert('broSumTime'+broSumTime)
//            alert('execPrice'+execPrice)
//             alert('execPrice'+execPrice)
//              alert('appRate'+appRate)
//         		alert('favourRate'+favourRate)
        
  		if(old_Realpay == 0 && broSumTime == 0){
	            extjMessage('请先输入排期!');
	        	return false;
        }      
        
  	    if(moneyBalance > 0 || moneyBalance <0){
        	sumTotal = sumTotal + moneyBalance;
        }    
        
//        alert('1 sumTotal'+sumTotal)
          
        if(appRate > 0){
        	sumTotal = sumTotal/(1 + appRate/100);
        }

//        alert('2 sumTotal'+sumTotal)
        
        if(favourRate > 0){
        	sumTotal = sumTotal/(favourRate/100);
        }
        
//        alert('3 sumTotal'+sumTotal)
       
        $("execPrice").value = sumTotal/broSumTime;
        
//        alert($("execPrice").value)
//         alert('4 sumTotal'+sumTotal/broSumTime)
         
	}
	
		broArrange.basePrice =  $("moneyBase").value*1;
		broArrange.realPrice = $("execPrice").value*1;	 	
		broArrange.favourRate =  $("favourRate").value*1;
		broArrange.appRate = $("appRate").value*1;		
		broArrange.moneyBalance = $("moneyBalance").value*1;	

}


function Disable_addAndPost2(event){
	var Btn_addAndPost2 = $("Btn_addAndPost2");
	if(!isUndefined(Btn_addAndPost2)) Btn_addAndPost2.disabled = true;
};

function confirmCompages(callFunc){
	var obj;
	var parentId='';
	var checkedItem = Ext.getCmp('opt_package').getValue();
	
	 if(checkedItem.getGroupValue() == 1){	
	 	obj=compages.tree;
	 }else{
	 	obj=carrierType.tree;
	 }
	
	 var text='';
	 var resourceIds = obj.getAllCheckedBranches(resource.IdPrefix);
	 if(resourceIds.length>0){
	 	parentId=obj.dhtmlTree.getParentId(resource.IdPrefix+resourceIds[0]);
	 	var catMain = DWRUtil.getText(orderCategory.selectName);
	 	if(catMain.indexOf("部门订单")>-1) {
	 		text = obj.dhtmlTree.getItemText(resource.IdPrefix+resourceIds[0]);
	 		var resourceTypeId = obj.dhtmlTree.getUserData(resource.IdPrefix+resourceIds[0],"resourceTypeId"); 
	 		text = text+"||"+ resourceTypeId;
	 	}else{
	 		text = obj.dhtmlTree.getItemText(resource.IdPrefix+resourceIds[0]);
	 	}
	 }

	 $("compagesId").value =-1;
	  compagesId_new = obj.getIdByPrefix(parentId,compages.IdPrefix); 
	  var priceTypeId = obj.dhtmlTree.getUserData(parentId,"priceTypeId");
	  if(priceTypeId > 0)  {
	  	 $("resourcePriceType").value = priceTypeId;
	  }else{
	  	if(config_autoPriceTypeParam > 0) $("resourcePriceType").value = config_autoPriceTypeParam;
	  }

	$("carrierName").value =obj.dhtmlTree.getItemText(parentId);
	$("compages.pos").value = text;
	$("compages.resourceIds").value = resourceIds;
//	orderDetail.obj.id = null;
//	orderDetailBackUp ={id:null};
//	closeCompagesTree();
    if(callFunc) callFunc();
	onResourceChange();
}
function displayDiv(ev){
	var oDiv = $("theDivOrderMeno");	
	oDiv.style.visibility = "visible";
	oDiv.style.width = "300px";
	$("textareaOrderMeno").style.width =  "290px";
	$("textareaOrderPublishMemo").style.width =  "290px";
	$("textareaOrderMeno").focus();	
	$("textareaOrderMeno").value = $("orderMeno").value;
}

function closeDiv(ev){
	var oDiv = $("theDivOrderMeno");	
	oDiv.style.visibility = "hidden";
	$("orderMeno").value = 	$("textareaOrderMeno").value;
//	$("orderMeno").value = 	$("textareaOrderPublishMemo").value;
} 

function displayOrderMeno(ev){
	if(ev.keyCode == 13){
		$("orderMeno").value = 	$("textareaOrderMeno").value;
	}
} 

function rest_order_year(){
	order_year = $("order_year").value;
	init_resourceCarrier();
	DWRUtil.removeAllOptions($(resource.selectName));
	getContarctAuto();
}


function resetHeigth1(){
//	var orderBaseInfoFrm = $("order_baseInfo_frm");
	 var dialogcontent = $("dialogcontentDiv");
	 var gridbox1 = $("gridbox1");
	 var z = getAbsolutePos($("Btn_addNewOrder"));
	 var v =dialogcontent.offsetHeight-z.y;
 	 gridbox1.style.height = v +"px";	

// 	var displayBtnValue = $("Btn_orderDetail").value;
// 	mygrid.setSizes();	
// 	if(displayBtnValue.indexOf('总览')>-1){
// 		$("gridbox").show();
// 		$("div_gridbox_detail").show();
// 	}else{
// 		
// 	}
// 	 
 	 


};

function displayOrderDetail(){
	if(!mygrid1) initGrid1();

	if(order.obj.id==null) return false;

			var displayBtnValue = $("Btn_orderDetail").value;
			if(displayBtnValue.indexOf('关闭')>-1){
				close_OrderDetails();
			}else{
		

				
				
				if(tvNameParam =='hntv' || tvNameParam =='sjz'){
					popupOrderDetail.url = "selectPopup/orderDetail.html?id=" + order.obj.id +"&orgId="+ orgId;
					popupOrderDetail.popupcenter(popupOrderDetail);		
				}else{
					
					
					var func = function(xml){
						mygrid1.clearAll();
						mygrid1.loadXMLString(xml);

						orderDetail.restHeadComnand1(mygrid1,mygrid1.selObjs1,resetDetailsTableSumBland1);

//						mygrid1.selObjs1[0].value ="0,1,2,4";
//						orderDetail.filterBy1(mygrid1,mygrid1.selObjs1[0],null);
							
//						resetDetailsTableSumBland1();
		
//						mygrid1.loadSizeFromCookie();
	//					doOnRowSelected(null,mygrid.getSelectedId());

						mygrid1.setSizes();	
					}					
					
					resetHeigth1();
					
					$("orderDayInfo_Array").hide();

					 $("main_info_body").hide();   
	  
   					  mygrid1.setSizes();	

	 				 $("gridbox1").show();
	 				 
//					 $("gridbox").show();
//					 $("div_gridbox_detail").show(); 				 
	 				 
					
					
					
					$("Btn_orderDetail").value ="关闭"
					orderDetailColl.getOrderDetailXml(orgId,order.obj.id,func);	
				}

				
			}
	
//	}
};

function close_OrderDetails(){
	   	var displayBtnValue = $("Btn_orderDetail").value;
	   	if(displayBtnValue.indexOf('关闭')>-1){
			$("gridbox1").hide();
          
   		    $("gridbox").show();
//			$("div_gridbox_detail").show();
//			mygrid.setSizes();	
			
			$("main_info_body").show();

			$("orderDayInfo_Array").show();
			$("Btn_orderDetail").value ="总览"
	   	}
};

//function close_OrderDetails(){
//	   	var displayBtnValue = $("Btn_orderDetail").value;
//	   	if(displayBtnValue.indexOf('关闭')>-1){
//			$("gridbox1").hide();
//			$("orderDayInfo_Array").show();
//			$("Btn_orderDetail").value ="总览"
//	   	}
//};

function selected_OrderDetails_grid(id){
	    getOrderDetail(id);
	    
//	    if(tvNameParam =='hntv' || tvNameParam =='sjz'){
////	    	doOnRowSelected(null,id);
//	    	getOrderDetail(id);
//	    }else{
//		   	var displayBtnValue = $("Btn_orderDetail").value;
//		   	if(displayBtnValue.indexOf('关闭')>-1){
//	            doOnRowSelected(null,id);
//		   	}	
//	    }

};



function initMatter(){
	if(initMatterButton){
		initMatterButton=false;
	}else{
		initMatterButton=true;
	}
};

function setCarrierTypePara(obj){
	 obj.className  = "carrierType";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox2";
	 obj.tree 		= new Tree(obj.treebox); 
};

//设置属性
function setResourceSortPara(obj){
	 obj.selectName =  "resourceSortId";
};
function setBroArrangePara(obj){
	 obj.targ  = $(orderDayInfo.fillObjName);
};
function setOrderCategoryPara(obj){
	 obj.className  = "orderCategory";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "categoryId";
};
function setResourcePara(obj){
	 obj.className  = "resource";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "resourceInfoId";
};
function setPriceTypePara(obj){
	 obj.className  = "priceType";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "resourcePriceType";
};
function setPricePara(obj){
	 obj.className  = "price";
	 obj.IdPrefix 	= obj.className + "Id";
};
function setOrderCategory1Para(obj){
	 obj.className  = "orderCategory1";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "orderCategoryId";
};
function setAgentInfoPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "carrierId";
};
function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "carrierId";
};
function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "customerId";
};
function setIndustryPara(obj){
	 obj.className  = "industry";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "industryTypeId";
};
function setSpecificPara(obj){
	 obj.className  = "specfic";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "resourceSpecificId";
};
function setUserPara(obj){
	 obj.className  = "user";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "userId";
};

function setPriceDetailPara(obj){
	 obj.className = "priceDetail";	
	 obj.IdPrefix 	= obj.className + "Id";
};

function setOrderPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 obj.className = "order";	
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.fillObjName = obj.className + "Body";
	 obj.tableName =  "orderList";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.pageInfo 	= "pageInfo" + obj.className;
	 obj.pageSize 	= "4";
//	 obj.page = new Page(obj.pageInfo,obj.pageSize);
};
function setOrderDetailPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 obj.className  = "orderDetail";	
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.tableName   = obj.className +"Table";
	 obj.fillObjName= obj.className + "Body";
	 obj.color1 	= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 	= "BACKGROUND-COLOR: #ECEFF4";
	 //obj.tBody 		= $(obj.fillObjName);
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "10";
	 obj.obj.specific= (new Specific()).obj;
	 obj.obj.compages =  new Compages();
//	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}
function setDayInfoPara(obj){
	 obj.className ="resDayInfo";
};
function setOrderDayInfoPara(obj){
	 obj.className ="orderDayInfo";
	 obj.IdPrefix 	= obj.className +"Id";
	 obj.tableName   = obj.className +"Table";
	 obj.fillObjName = obj.className +"Tbody";
//	 obj.targ = $(orderDayInfo.fillObjName);
	 obj.dayInfo = (new DayInfo()).obj;
};

function setCompagesPara(obj){
	 obj.className  = "compages";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox2";
	 obj.tree 		= new Tree(obj.treebox); 
	 obj.treeXMLObj1 		= null; 
	 obj.treeXMLObj2 		= null; 
};



function setMatter(o){
	$("dt_matter.id").value = o.id;	
	$("matter.tapeCode").value = o.tapeCode;
	$("matter.name").value = o.name;  
	$("matter.edit").value = o.edit;
	$("matterLength").value = o.length;
	$("matterType").value = o.matterType;
};

function setOrder(o){
	DWRUtil.setValues(o);
	order.setObject(o);
	$("order_year").value = o.version;
	order_year =  o.version;
	$("contract.code").value = setContractCode(o);
//	$("contract.code").value = o.contract.code +' '+ null2empty(o.contractPayment.payDate) +' '+ null2empty(o.contractPayment.moneyPay);
	$("contractPayment.moneyPay").value = o.contractPayment.moneyPay;
	$("contractPayment.moneyIn").value = o.contractPayment.moneyIn;
	$("contractPayment.contractMoneySum").value = o.contract.moneySum;
	$("contractPayment.payDate").value = o.contractPayment.payDate;
	$("order.contractId").value = o.contractId;
//	$("customer.customerName").value = o.customer.customerName;
//	Ext.fly('customerName').dom.value= o.customer.customerName;
//	Ext.fly('customerName').value= o.customerId;
	$("customerCategoryId").value = o.customer.customerCategoryId;
	$("order.contractCode").value = o.contract.code;
	$("orderDetail_mod_states").value = o.orderState.name;	//审核状态
	$("categoryId").value = o.categoryId;
	$("orderDetail_mod_by").value =o.modUser.fullName;
	
	$("textareaOrderPublishMemo").value =o.publishMemo;
	
	
	inti_set_customer(customer.customerCommand,1,o.customerId,o.customer.customerName,o.customer.customerCategoryId);
	int_set_user(o.userId,o.user.fullName);
//	init_set_orderCate(o.orderCategory,o.categoryId,"categoryId",145,null);
	setOrderPublic(o.orderPublic);
	
	document.title= "订单号:"+ order.obj.orderCode;
};

function setContractCode(o){
		var code ="";
		var contractCode = null2empty(o.contract.code);
		
		if(contractCode == '') return contractCode;
		
		if(config_contractsort == 0){
			code = contractCode +' '+ null2empty(o.contractPayment.payDate) +' '+ null2empty(o.contractPayment.moneyPay);
		}else{
			var startDate = null2empty(o.contract.startDate);
			var endDate = null2empty(o.contract.endDate);
			contractCode = contractCode !=""?contractCode+' ':"";
			startDate = startDate !=""?startDate+' ':"";
			endDate = endDate !=""?endDate+' ':"";
//			code = (contractCode + startDate + endDate).Trim();
			code = contractCode;
		}
		return code.Trim();		
};

function setOrderPublic(o){
	order.obj.orderPublic = o;
	$("orderPublic.publishStartDate").value = o.publishStartDate;	 //订单开始日期
	$("orderPublic.publishEndDate").value = o.publishEndDate;	//订单结束日期
//	DWRUtil.setValue("orderPublic.times",o.times); //订单总次数
	$("orderPublic.times").value = o.useTimes;	//订单总次数
//	$("orderPublic.usedtimes").value = o.times;	//订单总次数
	$("order_check_history1").value ="审核历史";	//订单总次数
//	$("orderDetail_mod_states").value = o.orderStates;	//审核状态
//	$("orderPublic.moneyBase").value = o.moneyBase;//订单总刊例价
	$("orderPublic.moneyBase").value = o.moneyBase;//订单总刊例价
//	$("orderPublic.moneyRealpay").value = o.moneyRealpay;	//订单总销售价
	$("orderPublic.moneyRealpay").value = ForDight(o.moneyRealpay,2);	//订单总销售价
	

	
	$("orderPublic.moneyIn").value = o.moneyIn; //订单总到到帐分配金额
}
function setOrderDetail(o,isEdit,isRemove){
		      
	orderDetail.setObject(o);
	
		     
		      
	var isInitCarr = false;
	var isResource = false;
	var cur_resourceSortId= $("resourceSortId").value;
	var cur_carrier_id = $(carrier.selectName).value;
	var isBackuped = orderDetailBackUp.resourceSortId != null;
	$("btn_packeg").value = 1;
	if(isEdit && cur_resourceSortId != o.resourceSortId) isInitCarr = true;
	$("resourceSortId").value = o.resourceSortId;
	var carrier_id = 0;
	var carrier_id_bak = 0;
	
    eval('var orgType = _app_params.orgTypes.orgId_'+ orgId);


	if(config_orderCarrierLevelParam =='1'|| (tvNameParam =='xmtv' && orgType == 2 && o.resourceSortId ==1)){  
			carrier_id = o.carrier.parentId;
			carrier_id_bak = orderDetailBackUp.carrier.parentId;
	}else{		
		 
			carrier_id = o.carrier.id;
			carrier_id_bak = orderDetailBackUp.carrier.id;		  
	}
	
		    
	
	
	var el = $("resourceInfoId");
	if(isEdit && (carrier_id_bak != carrier_id || cur_carrier_id != carrier_id || el.options.length == 1)) isResource = true;
	if(!isEdit && isRemove && (carrier_id_bak != carrier_id || cur_carrier_id != carrier_id) ) {isResource = true;};
	  
	var el = $("carrierId");
//	alert(isInitCarr)
//	alert(isEdit)
//	alert(el.options.length)

	if(!isInitCarr && isEdit  && el.options.length <2) isInitCarr = true;
	
	set_selectComdCarrier(carrier.selectName,carrier_id,o.carrier.carrierName,o.resourceSortId,isInitCarr);
	$("carrierName").value = o.compages.name;  
	

	set_selectComdResource("resourceInfoId",o.resourceInfoId,o.resource.resourceName,o.resource.isManual,carrier_id,isResource);
		   
	
//	alert(o.orderCategory.name +'_'+o.orderCategoryId+"_"+o.orderCategory.calculateAuto)
	
	inti_set_orderSubCate(o.orderCategoryId,o.orderCategory.name,o.orderCategory.calculateAuto);
    inti_set_industry(o.industry);
    Ext.getCmp('search_brand').setValue(o.matter.brand.id);
    Ext.getCmp('search_brand').setRawValue(o.matter.brand.name)
//    alert(o.matter.brand.name)
    
//	$("orderDetail_mod_by").value = Ext.fly('userId').dom.value;
	$("orderDetail_mod_date").value = formatDateGlobal5(o.modifyDate);
    getPosition();
	$("compagesId").value = o.compagesId;
	$("compages.resourceIds").value = o.compagesId;
	$("parentId").value = o.parentId;
	$("isSpaceAdver").checked =o.isSpaceAdver==1?true:false;
	$("dtPublishMemo").value = o.publishMemo;
	$("resourcePriceType").value =  o.resourcePriceType;
	set_selectComd2("resourceSpecificId",o.resourceSpecificId,o.specific.name);
	setOrderDetailfavourRate(o);
	$("sysPrice").value = o.sysPrice;
	$("execPrice").value = o.execPrice;
	$("moneyBalance").value = o.moneyBalance;
	$("appRate").value  = o.appRate * 100;
	$("favourRate").value  = o.favourRate * 100;
	$("ageRate").value  = o.ageRate * 100;
	
   	     
    
	//如果是协约，不需要修改总应收//设置 BroArrange.isCal;
	if($("resourceInfoId").value>0) getSysPrice(true);
 	getCalculateModel();
	setMatter(o.matter);
	setOrderDetailPublic(o);
		     
//	 alert(1)
};

function setOrderDetailfavourRate(o){
	var catMain = getSelectParamFromAttribute($("categoryId"),"calculateauto");
    var catSub =  orderCategory1.calculateAuto;
	if((catMain == 0 ||catMain == 2)&& catSub == 1){
		var moneyBase = o.orderPublic.moneyBase;
		moneyBase = (moneyBase == null ||moneyBase =="")? 1:moneyBase;
		var moneyRealpay = o.orderPublic.moneyRealpay;
		moneyRealpay = (moneyRealpay == null ||moneyRealpay =="")? 0:moneyRealpay;
		 o.favourRate  = moneyRealpay/moneyBase;
//		$("appRate").disabled = true;
	}else{
//		$("appRate").disabled= false;
	}
}




function setOrderDetailPublic(o){
	$("moneyBase").value = o.orderPublic.moneyBase; //总刊例价
//	$("broTimes").value = o.orderPublic.times; //总刊例价
//	$("moneyRealpay").value = o.orderPublic.moneyRealpay;    //总销售价
		$("moneyRealpay").value = ForDight(o.orderPublic.moneyRealpay,2);    //总销售价
    $("broSumTime").value = o.orderPublic.times;			 //总次数
    $("broArrangeStartDate").value = o.orderPublic.publishStartDate;	//总次数
    $("broArrangeEndDate").value = o.orderPublic.publishEndDate;		//总次数
};

//清空订单
function resetOrder(){
	order.reset();
	orderBackUp = (new Order()).obj;
	$("orderCode").value = null;
	document.title= "订单号:";
	$("relationCode").value = null;
	$("orderMeno").value = null;
	$("textareaOrderMeno").value = null;
	$("categoryId").value = 0;
	$("customerId").value = 0;
	$("contract.code").value = null;
	$("order.contractId").value = null;
	$("order.contractCode").value = null;
	$("customerCategoryId").value = null;
	$("isCkecked").value = 0;
	//清空合计信息
	$("orderPublic.publishStartDate").value = "";	
	$("orderPublic.publishEndDate").value = "";	
	$("orderPublic.moneyBase").value = "0";
	$("orderPublic.moneyRealpay").value = "0";	
	$("orderPublic.moneyIn").value = "0";
	$("contractPayment.contractMoneySum").value = "0";
	$("orderPublic.times").value = "0";
	$("orderPublic.usedtimes").value = "0";
	$("orderDetail_mod_states").value = "";	//审核状态
	if(Ext.getCmp("customerName")){
		Ext.getCmp("customerName").setValue('');
	}
}
//清空订单明细
function resetOrderDetail(removeRows){
	orderDetail.reset();
	orderDetailBackUp = (new OrderDetail()).obj;  
	if(config_autoPriceTypeParam > 0){
			$("resourcePriceType").value = config_autoPriceTypeParam;
	}else{
			$("resourcePriceType").value = 1;
	}

	$("resourceSpecificId").value = 0;
//	$("orderCategoryId").value = 0;
    if (Ext.getCmp("orderCategoryId") && orderDetailStates !='2') {
    		Ext.getCmp("orderCategoryId").setValue('');
    }

//	$("industryTypeId").value = 0;
	if(!industry.treecombo) initIndustry();
	industry.treecombo.passField.value = 0;
	industry.treecombo.setValue('');
	
	//$("dt_orderDetailId").value = null;
	$("dtPublishMemo").value = null;
	$("dt_matter.id").value = null;
	$("matter.name").value = null;  
	$("matter.tapeCode").value = null;
	$("matter.edit").value = null;	
	$("matterLength").value = null;
	$("matterType").value = null;

	if(removeRows){
		mygrid.clearAll();
//		orderDetail.page.pageIndex = 1;
	}
	resetOrderDetailPublic();		
}
function resetOrderDetailPublic(removeRows){
	if(removeRows){
		$("moneyBase").value = 0; 		//总刊例价
		$("moneyRealpay").value = 0;    //总销售价
		$("broSumTime").value = 0;	    //总次数
		$("moneyBalance").value = 0;	//补差
		$("appRate").value = 0;	    	//折扣
		$("favourRate").value = 0;	    //加收
		$("sysPrice").value = 0;	    //刊例价格
		$("execPrice").value = 0;	    //销售价格
	}
}
//清空播出信息
function resetDayInfo(removeRows){
    $("broArrangeStartDate").value = null;
    $("broArrangeEndDate").value = null;	
    $("sumMonthBasePrice").value = null;
    $("sumMonthRealPrice").value = null;
    
    $("moneyBalance").value = null;
    
//    $("sysPrice").value = 0;
//    $("execPrice").value = 0;
    
    if(removeRows) {
//    	DWRUtil.removeAllOptions("dtPricesAndType");
    	DWRUtil.removeAllRows(broArrange.targ); 
    }	   
    resetOrderDetailPublic(removeRows);
}

function resetFavourRate(){

		if(!isDigit(this.value)) return false; 
		var value =this.value;
//		var value = this.value.replace(/\D/g,'');
//		var value = this.value.replace(/\D/g,'');
        
		if(this.name == 'dtFavourRate'){
     		if(value <100){
						this.value = value;
			}else{
				this.value ='';
			}   	
        }
		
//		var execPrice = getExecPrice(sysPrice);
//		var lowestRate = $("lowestRate").value;



//alert(config_orderCalculateModel)

  if(config_orderCalculateModel == 0){
        if(this.name != 'moneyBalance'){
            var sysPrice = $("sysPrice").value;
	        if(this.name != 'execPrice'){
	        	$("execPrice").value = getExecPrice(sysPrice);
	        }else{
	        			if(sysPrice > 0){
	        				
					        	var rate = $("execPrice").value/sysPrice;
					      
											if(rate<1){
												$("favourRate").value = rate*100;
												$("appRate").value = 0;
											}else{
												$("appRate").value = rate*100;
												$("favourRate").value = 0;
											}
											
	        			}
	        }
 		}
  }else{
	  	if(this.name == 'favourRate'){
			if(value<1 && value> 0){
				$("favourRate").value = value*100;
			}else if(value<0){
				$("favourRate").value ='';
			}
	  	}
	  	if(this.name == 'appRate'){
			if(value<1 && value> 0){
				$("appRate").value = value*100;
			}else if(value<0){
				$("appRate").value ='';
			}
	  	}	  	
	  	
  }   


   resetMoneyRealpay(true);
}

function resetMoneyRealpay(getExp){
    $("moneyRealpay").value = 0;
    
//     alert('getCalculateModel'+getCalculateModel())
     
	if(getCalculateModel()){
        var sysPrice = $("sysPrice").value;
        
       
        
         if(config_orderCalculateModel == 0){
         	var execPrice = 0;
	        if(!getExp){
	        	 execPrice = getExecPrice(sysPrice);
	        	 $("execPrice").value = execPrice;
	        }
         }
        

// alert($("moneyBalance").value)
 
        
        broArrange.basePrice = sysPrice;
		broArrange.ageRate =$("ageRate").value;
		broArrange.appRate =$("appRate").value;
//		broArrange.balance = $("moneyBalance").value;
		broArrange.realPrice =$("execPrice").value;
	    broArrange.favourRate =$("favourRate").value;
	    broArrange.moneyBalance =$("moneyBalance").value;
	}else{
		$("execPrice").value = 0;
		$("appRate").value = 0;
		$("ageRate").value = 0;
//		$("moneyBalance").value = 0;
		$("favourRate").value = 0;
		$("moneyBalance").value = 0;
		
		broArrange.appRate = 0;
		broArrange.ageRate = 0;
//		broArrange.balance = 0;
		broArrange.realPrice = 0;
	    broArrange.favourRate = 0;
	    broArrange.moneyBalance = 0;		
	}
	

	broArrange.setBroArrayangeMonthPrice();
}

function getOrderDetailByURL(){
	var url = window.location.href;
	var startPos = url.indexOf("&");
	var endPos = url.indexOf("#");
	var orderDetailId = url.substring(startPos+1,endPos)*1;
	return  orderDetailId;
}

function getCompagesIdByURL(){
	var url = window.location.href;
	var startPos = url.indexOf("#");
	var endPos = url.indexOf("%");
	var compagesId = url.substring(startPos+1,endPos)*1;
	return  compagesId;
}
//通过订单类别选择计算应收方式
function getCalculateModel(){
	 broArrange.isCal = true;
	 var catMain = getSelectParamFromAttribute($("categoryId"),"calculateauto");
	 
//	 alert(catMain)
	 
	 if(catMain == '') catMain = 0;
     var catSub =  orderCategory1.calculateAuto;
     
//     alert(catSub)
     
	 if(catSub == '') catSub = 0;
	 //如果是 0 则根据付款信息 来确定应收
	 if(config_contractsort == 0){
		 if(catMain == "0" ||catMain == "2" ||  catSub == "0"){
		 	broArrange.isCal= false;
		 }	 	
	 }
	 if(catSub == "0") broArrange.isCal = false;
	 return broArrange.isCal;
}

function closePopup(ev){popupcenter.closePopup(popupcenter);}

function editOrderInfo(){
	if(order.obj.id <1) return false;
	orderDetailStates = 1;
//	init_order_cate_main();
	init_resourceSpeci();
	getMatterLengthComplt();
	getContarctAuto();
}		

function backup_cur_info(order,detail,monthInfos){
	if(order) orderBackUp = Object.clone(order);
	
	if(detail){
		orderDetailBackUp = Object.clone(detail);
		orderDetailBackUp.order = orderBackUp;
	}	

	if(monthInfos){
		var orderDayInfos = orderDayInfo.getOrderDayByDayInfoArray(monthInfos);
        orderDetailBackUp.orderDayInfos = orderDayInfos;
	}	
};

function getPosition(model){ 
	var resourceSort =  getSelectParamFromAttribute($("resourceSortId"),"paramvalue");
	//套装
	if(model == 2){
		 $("carrier_area").hide();
		 $("resourceInfoId_area").hide();
		 $("compages_area_name").show();
		 $("compages_area_pos").show();
//		 $("carrierId").value = 0;
//		 $("resourceInfoId").value = 0; 
	}else{
	//时段,
		 $("carrier_area").show();
		 $("resourceInfoId_area").show();
		 $("compages_area_name").hide();
		 $("compages_area_pos").hide();
		 $("compagesId").value = null;
		 $("compages.pos").value = null;
		 $("compages.resourceIds").value = null;
		 $("parentId").value = 0;
		 $("compagesMoneyRealpay").value = 0;
	}

	resetDayInfo(true);	
}

//qzj
function getCompagesTree(obj,resourceSort){
	
	var obj_tree = obj.tree.dhtmlTree;	
		
	function doOnSelect(itemId){
		var isItemChecked = obj_tree.isItemChecked(itemId);
		obj_tree.setSubChecked(itemId,!isItemChecked);
	}

	obj_tree.enableCheckBoxes(true);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.enableMercyDrag(true);
	obj_tree.enableItemEditor(false);
	obj_tree.enableDragAndDrop(false);
	
	obj_tree.setOnClickHandler(doOnSelect);  
	obj_tree.setOnDblClickHandler(doOnDblClick);
	obj.reset();
	obj.obj.parentId = 0;
	obj.obj.version= order_year;
	obj.obj.orgId = orgId;
	obj.obj.mediaorgId = resourceSort;
	obj.obj.enable=true;  
	
	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	var getxml = function(strXML){
		obj_tree.deleteChildItems(0);
		if(obj !='' && resourceSort == 1){
			obj.treeXMLObj1 = strXML;
		}else{
			obj.treeXMLObj2 = strXML;
		}
		
		obj_tree.loadXMLString(strXML);   
//		obj_tree.openAllItems(0);
		Ext.getBody().unmask(); 
	}   
	
	if(resourceSort == 1){
		if(obj.treeXMLObj1) {
			getxml(obj.treeXMLObj1);
		}else{
			obj.getTreeXML2(resource.IdPrefix,getxml);
		}
	}else{
		if(obj.treeXMLObj2){
			getxml(obj.treeXMLObj2);
		}else{
			obj.getTreeXML2(resource.IdPrefix,getxml);
		}
	}
};

function getCarrierTypeTree(obj){
	var obj_tree = obj.tree.dhtmlTree;	
	
	function doOnSelect(itemId){
		var isItemChecked = obj_tree.isItemChecked(itemId);
		obj_tree.setSubChecked(itemId,!isItemChecked);
	}
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.enableMercyDrag(true);
	obj_tree.enableItemEditor(false);
	obj_tree.enableDragAndDrop(false);
	obj_tree.setOnClickHandler(doOnSelect);  
	obj_tree.setOnDblClickHandler(doOnDblClick);
	obj.reset();
	
	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	var getxml = function(strXML){
		obj_tree.loadXMLString(strXML);   
		Ext.getBody().unmask(); 
	}   

	obj.obj.parentId = 0;
	obj.obj.nodeLevel = 999;
	obj.obj.orgId = orgId;
	obj.obj.memo = "3";
	obj.obj.enable = 1;
	obj.obj.fitterCarrier = 1;
	obj.obj.loginUser = loginUserName;
	
	obj.getTreeXMLByYear(carrier.IdPrefix,resource.IdPrefix,order_year,getxml);

}

function doOnDblClick(itemId){
	        var isOpenState = this.getOpenState(itemId);
	        if(isOpenState == -1){
	        	this.openItem(itemId);	
	        }else{
	        	this.closeItem(itemId);
		}	
}

//获得order和orderDetail信息；
function getOrder(orderId,orderDetailId){

	resetOrder();

	resetOrderDetail(false);

	resetDayInfo(false);

	var getOrderFun = function (o){
		setOrder(o);
		backup_cur_info(o,null,null);

		function getDetailTableFun(){

			if(mygrid.getRowsNum() > 0){
				var firstRowId = mygrid.getRowId(0);
				firstRowId = orderDetailId?orderDetailId:firstRowId;
				if(firstRowId){
					getOrderDetail(firstRowId);
				}else{
					orderDetailStates = 2;
				}	
				
				
			}else{ 
				orderDetailStates = 2;
//				init_order_cate_main(orderId);
				reloadOrderCategory1Store();
				getMatterLengthComplt();
				init_resourceCarrier();
				init_resourceSpeci();
				getContarctAuto();
				disableContrlGlobal();
				lockDestopOrderDetail(true);
			}

		}
		
		//获得定单明系表
		getOrderDetailTable(orderDetail,getDetailTableFun);
	}	
	

	order.getOrderForEdit(orderId,getOrderFun);
}

function getEditOrderStates(colIndex,isCkecked){
        if(config_allowModiyPassedOrderParam == 1){
				if(isCkecked == 1||isCkecked == 2||isCkecked == 3){
				        if(colIndex > 0) {
				        	var colName = mygrid.getColumnId(colIndex);
				        	if(colName != 'opter'){
				        		   return true;
				        	}
				        }else{
				        	 return true;
				        }
	        	  }else{
	        	  	      return true;
	        	  }
        }else{
	        	  if(isCkecked == 0 ||isCkecked == 4){
				        if(colIndex > 0) {
				        	var colName = mygrid.getColumnId(colIndex);
				        	if(colName != 'opter'){
				        		     return true;
				        	}
				        }else{
				        	   return true;
				        }
	        	  }	
        }
}

//鼠标点击事件
function getOrderDetail(orderDetailId,colIndex){
   	orderDetailStates = 0;
   	var Btn_addAndPost1 = $("Btn_addAndPost1");
	var Btn_addAndPost2 = $("Btn_addAndPost2");
	var Btn_addNewAdver1 = $("Btn_addNewAdver1");
	var Btn_addNewAdver2 = $("Btn_addNewAdver2");
	var Btn_save = $("Btn_save");
	Btn_addAndPost1.disabled = true;
	Btn_addAndPost2.disabled = true;
	Btn_addNewAdver1.disabled = true;
	Btn_addNewAdver2.disabled = true;
	Btn_save.disabled = true;
	var unlock = function(){
		Btn_addAndPost1.disabled = false;
		Btn_addAndPost2.disabled = false;
		Btn_addNewAdver1.disabled = false;
		Btn_addNewAdver2.disabled = false;
		Btn_save.disabled = false;
	};

	orderDetail.obj.orderDayInfosBak = new Array();
	isResChangedOnEdit = false;
	isSpecifChangedOnEdit= false;

	//通过索引给每一行上色

	mygrid.setSelectedRow(orderDetailId);

   function check_is_remove(){
				if(colIndex > 0){ 
					var colName = mygrid.getColumnId(colIndex);
					if(colName == 'opter') return true;
				}
   }
	
	var getOrderDetailFun = function (o){
		 
		    var isEdit = getEditOrderStates(colIndex,$("isCkecked").value);
		     
		    var isRemove = check_is_remove();
		 
		    setOrderDetail(o,isEdit,isRemove);	
		  
		    backup_cur_info(null,o,null);
	
			//获得dayInfo的信息
			var rsId =  o.resourceInfoId;
			var specificValue = o.specific.position;
			var isLock = false;
	         if(tag_orderDetail_save && isEdit){
	         	  editOrderInfo(); 
	         	  lockDestopOrderDetail(true);
	         }else{
	         	  lockDestopOrderDetail(false);
	         	  isLock = true;
	         }	
	      
			getMonthInfos(isLock,rsId,specificValue,o.orderPublic.publishStartDate,o.orderPublic.publishEndDate,unlock,true);
			
			
		    if(isRemove){deleteOrderDetail(orderDetailId);};
	}
     orderDetail.getOrderDetail(orderDetailId,getOrderDetailFun);

//     if(colIndex == 0 && config_isOpenOrderOrgParam == 1) showOrderLog(orderDetailId);
};




function resetDetailsTableSumBland(){
	var grid = mygrid;
	var rows = grid.getRowsNum();
	var sum_times = 0;
	var sum_useTime =0;

	  try {
		  			for(var i=0; i< rows;i++){
							var id = grid.getRowId(i);
							var isVisiable = grid.getRowByIndex(i).style.display =="";
							if(isVisiable){
							var times =  grid.getUserData(id,"times");
							var useTime =  grid.getUserData(id,"useTime");
							sum_times += times*1; 
							sum_useTime += useTime*1;
							}

						}	
	  	} catch (e) {
	    	
	    }
   
  
	$("orderPublic.times").value = sum_times;
	$("orderPublic.usedtimes").value = sum_useTime;
}



//获得表
function getOrderDetailTable(orderDetail,callBackFun){	
	var orderId = orderDetail.obj.orderId
	if(orderDetail.obj.orderId == null) orderId = orderBackUp.id;
	var paramObj = new OrderDetail();

	
	var postFlt = $("orderDetail_grid_title_flt1").childNodes[0];
	var nameFlt = $("orderDetail_grid_title_flt2").childNodes[0];
	var editFlt = $("orderDetail_grid_title_flt3").childNodes[0];
	var lenFlt = $("orderDetail_grid_title_flt4").childNodes[0];	
	
	var specFlt = $("orderDetail_grid_title_flt5").childNodes[0];
	var startFlt = $("orderDetail_grid_title_flt6").childNodes[0];
	var endFlt = $("orderDetail_grid_title_flt7").childNodes[0];
	var timeFlt = $("orderDetail_grid_title_flt8").childNodes[0];		
	
	
	
   var selObjs =[postFlt,nameFlt,editFlt,lenFlt,specFlt,startFlt,endFlt,timeFlt];		



	mygrid.clearAll();
	
	function getOrderDetailsForFztv_callBackFun(){
		if(callBackFun) callBackFun();
		orderDetail.restHeadComnand(mygrid,selObjs,resetDetailsTableSumBland);
//		alert(3019)
		
		 if(config_resourceUseCustomerCatelog == 1 && mygrid.getRowsNum()>0 ) Ext.getCmp("customerName").disable();
//		alert(mygrid.getRowsNum())
//		resetDetailsTableSumBland();
	} 
	
	var fnc = function(xml){
		mygrid.loadXMLString(xml,getOrderDetailsForFztv_callBackFun);

//		mygrid.loadSizeFromCookie();
//		mygrid.setSizes();	
	}	
	paramObj.page = orderDetail.page;
	paramObj.obj.orderId = orderId;
	paramObj.obj.parentId = 0;
	paramObj.obj.loginUser = loginUserName;
	paramObj.obj.orgId = orgId;
	paramObj.getOrderDetailsForFztv(fnc);	
};

function getOrderDetailCompages(el){
	var rowData = el.rowData;
	var compagesId = rowData.compagesId;
	var resourceSort = rowData.resourceSortId;
	var id = rowData.id;
	if(resourceSort == 1 || resourceSort == 3) return false;
	orderDetail.reset();
	orderDetail.obj.parentId = id;
	orderDetail.getOrderDetails(orderDetail);
}

function getResource(event,fnct){
		resource.obj.resourceYear = order_year;
		resource.obj.carrierId  = event >0 ?event:$(carrier.selectName).value;
		 

//		if(config_allowModiyPassedOrderParam ==0)
		
	
		resource.obj.orgId = orgId;
		$(resource.selectName).value = 0;
		//下面的if语句是为了实现广告资源随着启用与否来决定在新订单中是否出现.
		if(orderDetailStates!=1 && config_allowModiyPassedOrderParam ==0) {
			//非编辑订单只出现启用的资源
			resource.obj.enable =true;
		}else{
			//编辑订单出现全部的资源
			resource.obj.enable =null;
		}
		
		
		  
//			alert(resource.obj.toSource())
//		resource.makeSelectFromMap2(resource.obj,$(resource.selectName),fnct,"onResourceChange");
		resource.getResourceSelectFromMap3(resource.obj,$(resource.selectName),145,"onResourceChange",fnct);
		
		
}

//广告资源改变的时候，重新获得价格
//
function onResourceChange(){
	var compagesId = $("compagesId").value;
	var resourceId = $(resource.selectName).value;
	var specificId = $("resourceSpecificId").value ;
	if(orderDetailBackUp.resourceInfoId != resourceId && orderDetailStates == 1){
        	isResChangedOnEdit = true;
        }else{
        	isResChangedOnEdit = false;
	}	 
	orderDetail.obj.carrier.id = $(carrier.selectName).value;
	orderDetail.obj.resourceInfoId = resourceId ;
	if(config_signCompages ==1 && compagesId==-1){ 
		var ids = $("compages.resourceIds").value;
		resourceId = ids.substring(0,ids.indexOf(','))
		orderDetail.obj.resourceInfoId = resourceId ;
	}
	if(resourceId > 0 || compagesId > 0|| compagesId_new>0){
	//根据资源判断是否手动刊例价格
        var broSumTime = $("broSumTime").value;
		//新添状态 
		if(orderDetailStates == 2){
			var fnc = function(){backupBroarrayToCur(true);}
			if(broSumTime > 0){
				getSysPrice(false,fnc);
			}else{
				addNewOrderDayInfo();
				getSysPrice(false);	
			}
		}
		//新添并粘贴状态 
		if(orderDetailStates == 3){
			var fnc = function(){backupBroarrayToCur(true);}
			if(broSumTime > 0){
				getSysPrice(false,fnc);
			}else{
				getSysPrice(false,fnc);
			}
		}
		if(orderDetailStates == 1){
			var fnc = function(){backupBroarrayToCur(false,null,true);}
			getSysPrice(false,fnc);
		}
	}else{
		$("execPrice").value = 0;
		$("sysPrice").value = 0;
//		$("sysPrice").value = 0;
		copyBroTimesToCurBroArrange();
	}
}

//根据资源判断是否手动刊例价格
function checkIsManualPrice(resourceId){
		 resource.reset();
		 resource.obj.id = resourceId;
		 resource.obj.carrierId = $("carrierId").value;
		 var fuc = function(obj){
		 	if(obj != null) {
		 		var isManual = obj.isManual;
		 		isManual = isManual == true?false:true;
				$("sysPrice").disabled = isManual;
		 	}else{
				$("sysPrice").disabled = false;
		 	}	
		 }
		 resource.getResourceByIdFromMap(resource.obj,fuc); 
}

function copyBroTimesToCurBroArrange(){
	
	    var resourceSort =  getSelectParamFromAttribute($("resourceSortId"),"paramvalue");
	    var resourceInfoId = $("resourceInfoId").value;
	    var compagesId = $("compagesId").value;
		var funcc = function() {
			broArrange.setBroArrayangeMonthPrice();
		}
		var broArray = broArrange.copyTimesFromTargToArray();
		var func = function(){
			broArrange.copyDatetimesToTarget(broArray);
			getSysPrice(false,funcc);	
		}
		var rsId =$("resourceInfoId").value;
	    var specificValue = getSelectParamFromAttribute($("resourceSpecificId"),"position");
		var isLock = false;
		getMonthInfos(isLock,rsId,specificValue,broArrange.startDate,broArrange.endDate,func,false);	
}

//通过广告位置和长度获得价格
function getSysPrice(noResetDestPrice,funcc){
	
	
	var resourceSort =  getSelectParamFromAttribute($("resourceSortId"),"paramvalue");
	var resIsManual = getSelectParamFromAttribute($(resource.selectName),"isManual");

	
	if(resIsManual){
		 $("sysPrice").disabled = false;
//		 sysPrice.onkeyup = resetFavourRate;
//		 sysPrice.onafterpaste =  resetFavourRate;			
	}

	if(resIsManual && noResetDestPrice){
				var sysPrice = $("sysPrice");
				return false;
	}
	


	
	
	if($("compagesId").value==-1){
		getSysPriceResource(noResetDestPrice,funcc);
	}else{
		if($("btn_packeg").value == 2){
			 getSysPriceCompages(noResetDestPrice,funcc);
		}else{
			getSysPriceResource(noResetDestPrice,funcc);
		}
	}
} 

//手动修改刊例价格时，重新计算月价格
function setBroArrayangeMonthOnPriceChange(){
		broArrange.basePrice = $("sysPrice").value;
		broArrange.realPrice = $("execPrice").value;
		
		broArrange.favourRate =  $("favourRate").value*1;
		broArrange.appRate = $("appRate").value*1;		
		broArrange.moneyBalance = $("moneyBalance").value*1;			
		
		broArrange.setBroArrayangeMonthPrice();
}

function getSysPriceResource(noResetDestPrice,funcc){

	//获得广告位置和广告长度的值
	var resourceInfoId = $("resourceInfoId").value;
	var compagesId = $("compagesId").value;
	if(config_signCompages == 1 && compagesId==-1){
		resourceInfoId = orderDetail.obj.resourceInfoId;
	}
	var adLength = $("matterLength").value*1;
	var priceTypeId = $("resourcePriceType").value;
	
	
	if (resourceInfoId > 0){
		
		
	


		var callBackFun = function(sysPrice){

		  	if(!noResetDestPrice){
		  		sysPrice = (sysPrice == null || sysPrice =="" )? 0: sysPrice;
		  		sysPrice = sysPrice*1;
		  		if(sysPrice == 0 && compagesId != -1){
		  			priceRegular.getPriceRegularByName(resourceInfoId,priceTypeId,adLength,function(s){sysPrice = s;});
		  		}
				$("sysPrice").value = sysPrice;
				var isCal = getCalculateModel();
				
				
//							alert(config_orderCalculateModel) 
//							alert($("moneyBalance").value) 
				
				if( config_orderCalculateModel== 0){
					var execPrice = 0;
					if(isCal){
						 execPrice = getExecPrice(sysPrice);	
					}else{
						execPrice = 0;
					}				
					
					$("execPrice").value = execPrice;
					broArrange.basePrice = sysPrice;
					broArrange.realPrice = execPrice;
					
					broArrange.favourRate =  $("favourRate").value*1;
					broArrange.appRate = $("appRate").value*1;		
					broArrange.moneyBalance = $("moneyBalance").value*1;
				}else{
					broArrange.basePrice = sysPrice;
					broArrange.realPrice = isCal?$("execPrice").value:0;
					
					broArrange.favourRate =  $("favourRate").value*1;
					broArrange.appRate = $("appRate").value*1;		
					broArrange.moneyBalance = $("moneyBalance").value*1;					
				}				


				if(funcc) funcc();		  		
		  	}
		}
		

		
		if(!noResetDestPrice){
            //泉州台折扣特殊要求
	        getFavourRateForQZTV();

            if(compagesId == -1 && compagesId_new > 0){ 
            	compages.getPriceByLegth(compagesId_new,adLength,$("resourcePriceType").value,callBackFun)
            }else{
				price.getSysPriceByResId2(resourceInfoId,adLength,priceTypeId,callBackFun);	
            }
		}else{
			
//			alert( $("moneyBalance").value)
		  	broArrange.basePrice = $("sysPrice").value;
			broArrange.realPrice = $("execPrice").value;
			
			broArrange.favourRate =  $("favourRate").value*1;
			broArrange.appRate = $("appRate").value*1;		
			broArrange.moneyBalance = $("moneyBalance").value*1;	
			
		}
	}else{
		$("sysPrice").value = 0;
		$("execPrice").value = 0;
		setBroArrayangeMonthOnPriceChange();
	}
} 

function getSysPriceCompages(noResetDestPrice,funcc){
//	var isAutoPrice =  $("compages.isAutoPrice").checked;
	var ids  = $("compages.resourceIds").value;
	var length = $("matterLength").value*1;
	var priceTypeId = $("resourcePriceType").value;
	var obj = compages.getCompages($("compagesId").value);
	compages.obj.id = $("compagesId").value;
	function getFun(sysPrice){
		if(!noResetDestPrice){
			sysPrice = (sysPrice == null || sysPrice =="" )? 0: sysPrice;
			$("sysPrice").value = sysPrice;
			var isCal = getCalculateModel();
			
			if( config_orderCalculateModel == 0){
				var execPrice = 0;
				if(isCal){
					 execPrice = getExecPrice(sysPrice);	
				}else{
					execPrice = 0;
				}				
				
				$("execPrice").value = execPrice;
				broArrange.basePrice = sysPrice;
				broArrange.realPrice = execPrice;
				
				broArrange.favourRate =  $("favourRate").value*1;
				broArrange.appRate = $("appRate").value*1;		
				broArrange.moneyBalance = $("moneyBalance").value*1;	
			}else{
				broArrange.basePrice = sysPrice;
				broArrange.realPrice = isCal?$("execPrice").value:0;
				
				broArrange.favourRate =  $("favourRate").value*1;
				broArrange.appRate = $("appRate").value*1;		
				broArrange.moneyBalance = $("moneyBalance").value*1;					
			}

			if(funcc) funcc();
		}
		broArrange.basePrice = $("sysPrice").value;
		broArrange.realPrice = $("execPrice").value;
	}
	
	if(obj.isAutoPrice){
		compages.getPriceByResIdListAndLength(ids.split(','),length,priceTypeId,getFun);	
	}else{
		compages.getPrice(compages.obj,length,1,priceTypeId,getFun)
	}
}
//获得销售价格
function getExecPrice(sysPrice){
	var appRate  = $("appRate").value;
	var favourRate  = $("favourRate").value;
	var balance =  $("moneyBalance").value;
	appRate =  (isUndefined(appRate) || appRate == null || appRate =="")? 0:appRate;
	favourRate = (isUndefined(favourRate) || favourRate == null || favourRate =="") ? 0:favourRate;
	//balance =  (isUndefined(balance) || balance == null || balance =="") ? 0:balance;
	appRate = appRate > 0 ? appRate/100:appRate;
	favourRate = favourRate > 0 ? favourRate/100:favourRate;
	favourRate = favourRate == 0 ? 1:favourRate;
	sysPrice =  sysPrice *(1 + appRate*1)*favourRate;
	return ForDight(sysPrice,6);
}

function getFavourRateForQZTV(){
	if(tvNameParam == 'qztv'){
		var catMain = DWRUtil.getText("categoryId");
		if(catMain.indexOf("正常订单")>-1){
			var carName = DWRUtil.getText("carrierId");
			var rate = 0;
			if(carName.indexOf('新闻综合频道')>-1) rate =50;
			if(carName.indexOf('影视剧频道')>-1||carName.indexOf('都市生活频道')>-1) rate =40;
			if(carName.indexOf('闽南语频道')>-1) rate =60;
			if(rate>0) $("favourRate").value = rate;
		}
	}
} 

//通过客户，和行业类别，查找客户代理表中的 代理率 ==订单中的优惠率
function getAgentRate(){
	var customerId = $("customerId").value;
	var industryTypeId =industry.treecombo.passField.getValue();
			
	$("favourRate").value = null;
	var getAgentInfoFun = function(obj){
		var agentRate = obj.agentRate;
		agentRate = (agentRate == 1 || agentRate ==100 || agentRate== null|| agentRate=='') ? 0:agentRate*100;
		$("favourRate").value = agentRate;
		//重新计算应收总价
		resetMoneyRealpay();
	}
	
	if(industryTypeId > 0 && customerId >0){
		agentInfo.getAgentInfoRate(getAgentInfoFun,customerId,industryTypeId);		
	}else{
		resetMoneyRealpay();
	}
}

function getCustomerAgentRate(){
	var customerId = $("customerId").value;
	var getAgentInfoFun = function(obj){
		var ageRate = obj.discountRate;
		ageRate = (ageRate == 1 || ageRate ==100 || ageRate== null|| ageRate=='') ? 0:ageRate*100;
		$("ageRate").value = ageRate;
		//重新计算应收总价
		resetMoneyRealpay();
	}
	
	if(customerId >0){
		customer.getCustomerOne(customerId,getAgentInfoFun);		
	}else{
		resetMoneyRealpay();
	}
}

//获得指定的加收率 == 订单中的假收
function getSpecificRate(){
	
	function fnc(){
    	   var isNewOrderDetail = (orderDetailStates == 2||orderDetailStates == 3);
    	    backupBroarrayToCur(isNewOrderDetail,null,true);
    }
  
 	var specificId = $("resourceSpecificId").value;
	orderDetail.obj.resourceSpecificId = $("resourceSpecificId").value ;
	orderDetail.obj.specific.position = getSelectParamFromAttribute($("resourceSpecificId"),"position");


	//isSpecifChangedOnEdit 用于broArrange.js
	if(orderDetailBackUp.resourceSpecificId != specificId && orderDetailStates == 1){
        	isSpecifChangedOnEdit = true;
	}else{
        	isSpecifChangedOnEdit = false;
	}	
  
    
	
	if(orderDetailStates == 1){
			fnc();
		 return false;
	}
	
	
	

	$("appRate").value = null;
	var getSpecificfun =  function(o){
		var specificRate = o.overRate;
		specificRate = (specificRate == 1 || specificRate ==100 || specificRate== null || specificRate=='') ? 0:specificRate*100;
		$("appRate").value = specificRate;
		//重新计算应收总价
		getSysPrice(false,fnc);
	}
	if(specificId > 0){
		specific.getSpecific(getSpecificfun,specificId);		
	}else{
	    getSysPrice(false,fnc);
	}
}
	
function getMatterObj(oDetail){
		var matterType = $("matterType").value;
		matterType = matterType =="" ?1:matterType;
		matter.reset();
		matter.obj.tapeCode = $("matter.tapeCode").value;
		matter.obj.name = $("matter.name").value;
		matter.obj.edit = $("matter.edit").value;
		matter.obj.length = $("matterLength").value;
		matter.obj.customerId =  Ext.getCmp('customerName').getValue();
		matter.obj.matterType = matterType;
//		matter.obj.brandId = $("industryTypeId").value; 
		matter.obj.brandId = industry.treecombo.passField.getValue();
		matter.obj.brandId2 =  Ext.getCmp('search_brand').getValue();
		matter.obj.version = 0;
		matter.obj.enable = true;
		matter.obj.createBy = loginUserId;
		matter.obj.orgId = orgId;
		oDetail.matter = matter.obj;
}

function getOrderDetailObj(orderId,isNewDetail,isPackeg){
    var obj = (new OrderDetail()).obj;
    DWRUtil.getValues(obj);
	var parentId = $("parentId").value;
	var startDate = broArrange.startDate;
	var endDate =   broArrange.endDate; 
    var appRate =  $("appRate").value ==""? 0: $("appRate").value;
    var ageRate =  $("ageRate").value ==""? 0: $("ageRate").value;
	var favourRate =  $("favourRate").value ==""? 0: $("favourRate").value;	
//	alert(orderId);
	
	obj.id = isNewDetail||isPackeg?null:orderDetailBackUp.id;    
	obj.isCompages = isPackeg;
	obj.version = order_year;    
	obj.orderDayInfos = saveOrderDayInfo();      
	obj.orderDetailBak = isNewDetail||isPackeg?{orderDetailBak:{orderDayInfos:new Array()}}:Object.clone(orderDetailBackUp);
	obj.isSaveOrderDayInfo = isSaveOrderDayInfo;
	broArrange.getBroArrangeStarEndDate(_app_params); 	
	startDate = broArrange.broArrangeStartDate.value;
	endDate = broArrange.broArrangeEndDate.value; 		
	
	obj.orderId = orderId;
	obj.publishStartDate =  startDate;
	obj.publishEndDate =  endDate;
	obj.sumTimes = $("broSumTime").value;
	

	
	obj.resourceType = $("resourcePriceType").value;
	obj.publishMemo =$("dtPublishMemo").value;
	obj.isSpaceAdver =$("isSpaceAdver").checked;
	obj.createBy = 	loginUserId;
	obj.modifyBy = loginUserId;
	obj.industryTypeId = industry.treecombo.passField.getValue();
	obj.parentId = parentId =="" ? 0: parentId;
	
//	obj.carrier ={carrierName: DWRUtil.getText(carrier.selectName)};
	
	obj.compages = (new Compages()).obj;
	obj.compages.resourceIds =$("compages.resourceIds").value.split(',');
	obj.compagesId = isPackeg?compagesId_new:0;
	obj.orderCategoryId =  Ext.getCmp('orderCategoryId').getValue();	
	obj.specific.position = getSelectParamFromAttribute($("resourceSpecificId"),"position");

	if($('resourceInfoId').value==0 && obj.compages.resourceIds!=0) obj.resourceInfoId = obj.compages.resourceIds[0];
	
	var orderCategoryMain = getSelectParamFromAttribute($("categoryId"),"calculateauto");//根据付款分配应收
	

	
	if(config_contractsort == 0){
		obj.orderCategoryMain = orderCategoryMain;
	}else{
		obj.orderCategoryMain = 1;
	}

//	if(config_withResourceSort == 1){
//		obj.resource = (new Resource()).obj;
//		var ids = $("compages.resourceIds").value;
//		if(ids != '' && ids != '0') {
//			var sour = $("compages.pos").value;
//			var i = sour.indexOf('||');
//		    if (i > 0){ var c = sour.substring(i+2*1)};
//			obj.resource.resourceType =  c;
//		}else{
//			obj.resource.resourceType = getSelectParamFromText($("resourceInfoId"),"||",2);
//		}
//		
//		alert(obj.resource.resourceType);
//	}
	
	obj.contractId = $("order.contractId").value;
	obj.paymentId = $("paymentId").value;
	obj.ageRate 	 = ageRate*1/100;
	obj.appRate 	 = appRate*1/100;
	obj.favourRate   	 = favourRate*1/100;	




	//获得应收总价和刊例价
	if(obj.orderCategoryMain == 1){
		if(parentId > 0) {
			obj.moneyRealpay = $("compagesMoneyRealpay").value; 
		}else{
			obj.moneyRealpay = $("moneyRealpay").value;
		}	
		
	
		
	}else{
		
		
		if(config_contractsort == 0){
			if(obj.paymentId =="" ||obj.paymentId == null || obj.paymentId == 0){
				obj.moneyRealpay = $("orderPublic.moneyRealpay").value;
			}else{
				obj.moneyRealpay = $("contractPayment.moneyPay").value;
			}
		}else{
			
			
			
			if(parentId > 0) {
				obj.moneyRealpay = $("compagesMoneyRealpay").value; 
			}else{
				obj.moneyRealpay = $("moneyRealpay").value;
			}				
		}
			
	}
	
	
	


	
//	alert(obj.moneyRealpay)

	getMatterObj(obj);
	getOrderDetailPublic(obj);
	
//	if( == 1){
//		//A 正常订单    C 协约合同   D 固定金额(协约订单)
//		var catMainValue = getSelectParamFromAttribute($("categoryId"),"obj_value").toLowerCase();
//		if(catMainValue.indexOf('d')>-1){
//			if(obj.sumTimes >0){
//				var times = obj.orderPublic.times ==0?1:obj.orderPublic.times;
//				obj.execPrice = obj.orderPublic.moneyRealpay/times;
//			}
//		}
//	}	
	
	
	return obj;
}

function getOrderDetailPublic(orderDetail){
    orderDetail.orderPublic = (new OrderPublic()).obj;
    orderDetail.orderPublic.moneyBase =  $("moneyBase").value;
    orderDetail.orderPublic.moneyRealpay =  $("moneyRealpay").value;
    orderDetail.orderPublic.times =  $("broSumTime").value;
    orderDetail.orderPublic.publishStartDate =  $("broArrangeStartDate").value;
    orderDetail.orderPublic.publishEndDate =  $("broArrangeEndDate").value;		
}

function displayPayment(){
	if(order.obj.id==null) return false;
	var contractId = $("order.contractId").value;
	

	var resourceSort =  getSelectParamFromAttribute($("resourceSortId"),"paramvalue");
	var pay_ment = (new PayMent()).obj;
	var moneyRealpay = 0;
	pay_ment.customerId = $("customerId").value;
	pay_ment.version = order_year;
	//正常及协议合同	
	if(contractId == '' || contractId == 0|| resourceSort == 0){
		pay_ment.orderId = order.obj.id;
		pay_ment.contractId = 0;
		moneyRealpay = $("orderPublic.moneyRealpay").value;
	}else{
		pay_ment.orderId = order.obj.id;
		pay_ment.contractId = contractId;
		moneyRealpay = $("contractPayment.contractMoneySum").value;
	}
	autoBroArrangePayment(pay_ment,moneyRealpay);
}

function autoBroArrangePayment(o,moneyRealpay){
	var isCkecked = $("isCkecked").value;
	
	var urlStr = "selectPopup/selectPayment.html?orderId=" + o.orderId+"&orderCkecked="+isCkecked+"&contractId="+o.contractId+"&moneyRealpay="+moneyRealpay+"&customerId="+o.customerId +"&version="+o.version+"&serDate="+config_serviceDate;
	urlStr = urlStr +"&tvNameParam=" +tvNameParam;
	var orderMainType =getSelectParamFromAttribute($("categoryId"),"calculateauto");
	urlStr = urlStr +"&orderMainType=" +orderMainType;
	urlStr = urlStr +"&orgId=" +orgId;
	urlStr = urlStr +"&paymentId=" +$("paymentId").value;
	urlStr = urlStr +"&orderDetailId=" +orderDetailBackUp.id;
	urlStr = urlStr +"&year=" +$("order_year").value;
	
	
	var dialogcontent = $("dialogcontentDiv");
	var dialogcontentW = dialogcontent.offsetWidth;
	var dialogcontentH = dialogcontent.offsetHeight;
	var winW= dialogcontentW * 0.6;
	var winH = dialogcontentH*0.8;
	var title = "付款信息";
	var theme = "leopard"; //vista mac_os_x lighting black_hud leopard window
	var draggable = false;
	var minimize = false;
	var maximize = false;
	var close =  'destroy';
	var resizable = false;
	
	var modle = getSelectParamFromAttribute($("categoryId"),"calculateauto");
    var paymentId =$("paymentId").value;
    paymentId =paymentId ==''?0:paymentId*1;	
	if(modle == 0) modle = 8;
	if(paymentId>0) modle = 9;	
	
	
	function getPayMentTable(){
                    var pay = document.getElementById('orderPaymentiframe').contentWindow.payment;
                    if(paymentId == 0) {pay.obj.id = null};
				 	document.getElementById('orderPaymentiframe').contentWindow.refreshPaymentsTable(pay);

//				     Ext.getBody().unmask();
//					extjMessage('自动分类完成!');
	} 	
	
	
    var closeBtn ={text: '关闭',handler: function(){
    	 Ext.getBody().unmask();
    	 
    	 if(config_withResourceSort == 1){
	         if(modle !=1){
	         	 getOrder(o.orderId,orderDetailBackUp.id);
	         }else{
	         	 getOrderDetail(orderDetailBackUp.id); 
	         }
    	 }

    	

    	win.destroy();
    	}};
    var autoBtn ={text: '自动分类',handler: function(){
//			Ext.getBody().mask('数据处理中……', 'x-mask-loading'); 	
//			getPayMentTable();   
//			if (!checkEeitState('btn_SavePayment')){
//				document.getElementById('orderPaymentiframe').contentWindow.cannelPayment();
//			}
			document.getElementById('orderPaymentiframe').contentWindow.saveCuiKuanByNortomOrder(modle, true, paymentId,o.orderId, o.customerId, o.version,false,getPayMentTable);

    	}};
    	
      var clearBtn ={text: '取消分类',handler: function(){
			
//			document.getElementById('orderPaymentiframe').contentWindow.check_Eeit_State();
			
//			Ext.getBody().mask('数据处理中……', 'x-mask-loading'); 	   		
			 document.getElementById('orderPaymentiframe').contentWindow.saveCuiKuanByNortomOrder(modle, true, paymentId,o.orderId, o.customerId, o.version,true,getPayMentTable);
    	}};    	
    	
    
    var btns =[];
    
    if((modle == 1 || modle == 0  || modle == 8)&& config_withResourceSort == 1){
    	btns.push(clearBtn);
    	btns.push(autoBtn);
    }
    
    btns.push(closeBtn);
    

 var win = new Ext.Window({
   title : '付款信息',
   width : winW,
   height : winH,
   isTopContainer : true,
   modal : true,
   resizable : false,
    buttons: btns,
   contentEl : Ext.DomHelper.append(document.body, {
    tag : 'iframe',
     id : 'orderPaymentiframe',
    style : "border 0px none;scrollbar:true",
    src : urlStr,
    height : "100%",
    width : "100%"
   })
  })
  win.show(this); 
}

function displaySumMoney_bak(){
	var sumTotal = window.prompt("总金额：","");
	if(sumTotal == null){
		$("moneyBalance").value = 0;
	}else{
		var moneyRealpay = $("orderPublic.moneyRealpay").value*1;
		var sysPrice = $("moneyRealpay").value*1;
		var moneyBalance =  ForDight(sumTotal*1-(moneyRealpay + sysPrice),2);
		$("moneyBalance").value = moneyBalance;
	}
	resetMoneyRealpay();
}

function displaySumMoney_bak3(){
	var old_Realpay = $("execPrice").value*1 * $("broSumTime").value*1;
	var sumTotal = window.prompt("请输入总金额，系统将为您自动补差","")*1;
	sumTotal = (sumTotal == "")?0:sumTotal
        if(sumTotal > 0){
		var moneyRealpay = $("moneyRealpay").value*1;
		var moneyBalance = ForDight( sumTotal - old_Realpay,2);
		$("moneyBalance").value = moneyBalance;
		resetMoneyRealpay();	
        }
}

function displaySumMoney(){
		var moneyBalance = ForDight($("moneyBalance").value,2);
//		if(moneyBalance > 0)resetMoneyRealpay();
	    resetMoneyRealpay();	
}
function displaySumMoneyKeypress(ev){
		if(ev.keyCode == 13){
			var moneyBalance = ForDight($("moneyBalance").value,2)
	        if(moneyBalance > 0){
				resetMoneyRealpay();	
	        }
		}
};

function setOrderCategoryDef(){

	reloadOrderCategory1Store(); 
	if(config_orderModCategoryParam == 0){
		  return false;
	}else{
		$("categoryId").value = config_orderModCategoryParam;
	}
	
	
		var catMain = DWRUtil.getText("categoryId");
  	if(catMain.indexOf('协议')>-1) config_contractsort =1;

	
//	
//	var orderCategorySelect = $("categoryId");
//	if(config_orderModCategoryParam == $("categoryId").value) return false;
//	var id = order.obj.id;
//	var isNotEditMode = !(id > 0);
//	if(isNotEditMode && config_orderModCategoryParam >0){
//			orderCategorySelect.value = config_orderModCategoryParam;
//			reloadOrderCategory1Store(); 	
//	}
};

//检查订单状态
function checkOrderStates(msg,mode){
	//定单状态 不为0 和4
	var isCkecked = $("isCkecked").value;
	if(isCkecked != 0 && isCkecked != 4){

		 isSaveOrderDetail = false;
		 isSaveOrderDayInfo = false;
		if(config_allowModiyPassedOrderParam == 1){
			   var moneyIn =  $("orderPublic.moneyIn").value;
			   isSaveOrderDetail = true;
			   isSaveOrderDayInfo = true
			    if(moneyIn >0 && config_financeBalanceModelParam == 0) isSaveOrderDayInfo = false;
	         	return false;	
		}else{
			
			if(config_permitModAdverParam =="1") return false;
			
			if(isCkecked == 3){
				Ext.MessageBox.alert('系统提示',"订单审核状态为通过，"+msg +"<br>",function(){});         
			}else{
			 	Ext.MessageBox.alert('系统提示',"订单处于审核过程中，"+msg+"<br>",function(){});         
			}        
			return true;	
		}		
	}else{
		return false;
	}
}

function saveOrderUnable(){

	//检查订单状态
	if(checkOrderStates('不允许保存','save')){return true;}

	//显示星期，不允许保存
//	if(broArrange.displayLeave) {
//		 extjMessage('显示星期状态下，不允许保存!');
//		return true;
//	}	
	
	
	var catMain = DWRUtil.getText("categoryId");
	var contractId = $("order.contractId").value;
	contractId = (contractId =='' ||contractId == '0')?null:contractId;
	

	if(catMain.indexOf("协约合同")!= -1 && contractId == null){
			 extjMessage('订单类别为 协约合同，合同号为空，不允许保存!');
			 return true;
	}
	if(catMain.indexOf("协约合同")!= -1 && contractId == null){
			 extjMessage('订单类别为 协约合同，合同号为空，不允许保存!');
			 return true;
	}
	if(catMain.indexOf("协议合同")!= -1 && contractId == null){
			 extjMessage('订单类别为 协议合同，合同号为空，不允许保存!');
			 return true;
	}
	if(catMain.indexOf("正常订单")!= -1 && contractId != null){
			 extjMessage('订单类别为 正常订单，不需要合同号，不允许保存!');
			 return true;
	}
	if(catMain.indexOf("协约订单")!= -1 && catMain.indexOf("固定金额")!= -1 && contractId != null){
		   extjMessage('订单类别为'+ catMain +'，不需要合同号，不允许保存!');
			 return true;
	}
	var contractCode = ($("contract.code").value).Trim();
	contractCode = (contractCode =='' ||contractCode == '0')?null:contractCode;
	if(contractCode != null && contractId == null){
		extjMessage('请重新选择合同号，不允许保存!'); return true;	
	}	

	var resourceSort =  getSelectParamFromAttribute($("resourceSortId"),"paramvalue");
	var resourceInfoId = $("resourceInfoId").value;
	var compagesId = $("compagesId").value;
	compagesId = compagesId != "" && compagesId !=null ? compagesId:0;

	//时段、栏目
	if((resourceSort == 1 ||resourceSort == 3) && $("btn_packeg").value == 1 && resourceInfoId == 0 ){
		 extjMessage('没选择广告位置，不允许保存!');
		 return true;			
	}
	 //套装 
	if($("btn_packeg").value == 2 && compagesId == 0 ){
		 extjMessage('没选择广告位置，不允许保存!');
		 return true;			
	}	
	//检测磁带号 ,先判断是手动 还是自动
	if(config_adverCodeModelParam == '0'){
		if(checkTapeCode()) return true;
	}
	//检测付款情况， paymentId  orderId
	if(contractId == null){
		var orderMoneyIn = $("orderPublic.moneyIn").value;
		orderMoneyIn = orderMoneyIn ==''|| orderMoneyIn ==null?0:orderMoneyIn;
		var msg;
		if(orderMoneyIn > 0 && config_financeBalanceModelParam == 0){
			isSaveOrderDetail = true;
			isSaveOrderDayInfo = false;
			if(contractId == null){
				msg ="订单已平过帐,不能修改订单!";	
			}else{
				msg ="合同已平过帐,不能修改订单!";
			}
		}
	}else{
		var orderMoneyIn = $("contractPayment.moneyIn").value;
	    	if(orderMoneyIn >0 && config_financeBalanceModelParam == 0){
	    		isSaveOrderDetail = true;
				isSaveOrderDayInfo = false;
	    		extjMessage('财务已平过帐，要修改请通知财务!'); return true;
	    	}
	}
//	检测播出次数
//    if()
	
	
	//检测客户是否注册
	var customerName =  Ext.fly('customerName').dom.value; 
	var customerId =  Ext.getCmp('customerName').getValue();
	if(customerId == customerName){checkCustomer(1);return true;}
	
	
//	var yewuName =  Ext.fly('userId').dom.value; 
//	var yewuId =  Ext.getCmp('userId').getValue();	
//
//    if(yewuName == yewuId && yewuId !=''){
//    	user.displayUsersBranchs(loginUserId,orgId,yewuName,Ext.getCmp('userId'),save_Order);
//    	return true;
//    }
	
	
    return checkOrderSubCate(1);
};


function getOrderPublic(fun){
	order.getOrderPublic(fun,order.obj.id)
};

function savePayMent(isNew,isRemovePayment){
	    var payMoney = order.obj.orderPublic.moneyRealpay;
	    var resourceType = 0;
	    var orderMainType = getSelectParamFromAttribute($("categoryId"),"calculateauto");
	    var isWithResourceSort = (config_withResourceSort ==1);
	    var categroyName = order.obj.orderCategory.name;
	    
	    
	    
//        if(isWithResourceSort) {
//	    	 resourceType= getSelectParamFromText($("resourceInfoId"),"||",2);
//	    }    			    
	    var func = function(){
//	    	if(isNew  && isWithResourceSort && categroyName.indexOf("协约订单")>-1) displayPayment(); 
	    }

	    if(isWithResourceSort){
	    	
//	    	if(isNew  || $("orderPublic.moneyRealpay").value == 0){
	            if(isRemovePayment){
	            	 payMent.saveContractPaymentByOrder(orderMainType,0,order.obj.id,order.obj.customerId,0,isNew,resourceType,order_year,func);    
	            }else{
			    	if(categroyName.indexOf("协约合同")>-1) return false;
			    	payMent.saveContractPaymentByOrder(orderMainType,order.obj.contractId,order.obj.id,order.obj.customerId,payMoney,isNew,resourceType,order_year,func);    
	            }
//	    	}
	    }else{
            if(isRemovePayment){
            	 payMent.saveContractPaymentByOrder(orderMainType,0,order.obj.id,order.obj.customerId,0,isNew,resourceType,order_year,func);    
            }else{
	 			var categroyName = order.obj.orderCategory.name;
		    	if(categroyName.indexOf("协约合同")>-1) return false;
		    	payMent.saveContractPaymentByOrder(orderMainType,order.obj.contractId,order.obj.id,order.obj.customerId,payMoney,isNew,resourceType,order_year,func);    
            }
	    }
};


function getOrderValue(obj,isNewOder){
	DWRUtil.getValues(obj);
	obj.orgId = orgId;
	obj.customerId =  Ext.getCmp('customerName').getValue();
	obj.isCkecked = isNewOder?"0":orderBackUp.isCkecked;
	obj.version = order_year;
	obj.contractId =  $("order.contractId").value;
	obj.categoryId =  $("categoryId").value;
	obj.userId = Ext.getCmp('userId').getValue();	
	obj.createBy = loginUserId;
	obj.modifyBy = loginUserId;
	obj.publishMemo = $("textareaOrderPublishMemo").value;
}
//保存定单
function save_Order(){
	var Btn_save = $("Btn_save");
	Btn_save.disabled = true;
	otherFocus();
	var isPass = checkOrder();if(!isPass) {Btn_save.disabled = false;return false;};
	var isNewOder = (order.obj.id == null)?true:false;

	getOrderValue(order.obj,isNewOder);
	

	


//	if(order.obj.contractId >0) order.obj.paymentId = 0;
	
	
	 
    var resource_sort = getSelectParamFromAttribute($("resourceSortId"),"paramvalue");
    var customerCategoryId  = getValueFromStoreById(Ext.getCmp('customerName'),"customerCategoryId");
	order.obj.tempStr = orgId +","+ resource_sort +","+ customerCategoryId;
    var isOrderChanged = order.isChanged(orderBackUp,order.obj,_app_params.sysParam);


    if(isOrderChanged){
    	    var saveOrderFun = function(or){
    	    	 save_order_detail(or.id,isPass,isOrderChanged,isNewOder);
    	    }
    	    order.saveOrderReturnObj(order.obj,saveOrderFun);	
    }else{
    	    save_order_detail(orderBackUp.id,isPass,isOrderChanged,isNewOder);
    }
};

function save_order_detail(orderId,isPass,isOrderChanged,isNewOder){
	 if(!isPass) return false;

	 var isNewDetail = (orderDetailStates >1) ?true:false;
	 var isPackeg = ($("btn_packeg").value == 2) ?true:false;
	 var orderDetail_obj = getOrderDetailObj(orderId,isNewDetail,isPackeg);
	 var resourceSort = getSelectParamFromAttribute($("resourceSortId"),"paramvalue");
	 var isOrderDetailChanged = orderDetail.isChanged(orderDetailBackUp,orderDetail_obj,_app_params.sysParam);
	 
//	 var isCkecked = $("isCkecked").value;
//	 var isOnlyChangedMeno = orderDetail.isOnlyChangedMeno(orderDetailBackUp,orderDetail_obj,_app_params.sysParam,isCkecked);
//	 var orderDayInfos = orderDetail_obj.orderDayInfos;
	
	 function saveDetailFnc(detailId,orderDetail_obj){save_orderDetail_fun(isPackeg,orderId,detailId,isNewOder,orderDetail_obj); };

   
//	 alert(orderDetail_obj.publishStartDate)   
//	 alert(orderDetail_obj.publishEndDate)

	 if(isOrderDetailChanged) {
		 orderDetail.saveOrderDetail(orderDetail_obj,isPackeg,
		 			{
					　　callback:function(data){saveDetailFnc(data,orderDetail_obj);},
					　　errorHandler:function(errorString, exception) { 

						    var msg="<div style='width:300px;height:300px;OVERFLOW-y:auto;OVERFLOW: scroll;'>"+errorString+"<div>";
							Ext.MessageBox.hide(); 
							Ext.MessageBox.show(
									 	{title:'系统提示',msg:msg,width:380,heigth:300,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
							); 						
					        $("Btn_save").disabled = false;
//					   		 saveDetailFnc(orderDetailBackUp.id);
					    }
		 			}
		); 
	
	 }else{
		 saveDetailFnc(detailId,orderDetail_obj);
	 }
};

function save_orderDetail_fun(isPackeg,orderId,id,isNewOder,orderDetail_obj){
    
	if(isPackeg){
	    id = id+'';
		var  indexId = id.indexOf('_');
		if(indexId!=-1){
			   var msg="<div style='width:350px;height:300px;OVERFLOW-y:auto;OVERFLOW: scroll;'>"+id.substring(indexId+1)+"<div>";
				Ext.MessageBox.hide(); 
				Ext.MessageBox.show(
						 	{title:'系统提示',msg:msg,width:380,heigth:300,buttons: Ext.MessageBox.OK}
				); 				
				id = id.substring(0,indexId);     
		}
	}
		//通过当前orderId获得当前定单的所有定单明系
		
//		function getDetailTableFun(){
//			mygrid.setSelectedRow(id);
//			save_payMent_fun(orderId,id,isNewOder,orderDetail_obj);
////			getOrderDetail(id);
//		}
//	    orderDetail.obj.orderId = orderId;
//	    orderDetail.obj.id = id;
//		getOrderDetailTable(orderDetail,getDetailTableFun);
		

        function callBakFun(){
			function getDetailTableFun(){
				mygrid.setSelectedRow(id);
				getOrderDetail(id);	 
			}
		    orderDetail.obj.orderId = orderId;
		    orderDetail.obj.id = id;
			getOrderDetailTable(orderDetail,getDetailTableFun);		
        }
	
		
		save_payMent_fun(orderId,id,isNewOder,orderDetail_obj,callBakFun);
		
		initMatterButton=true;
		initMatter();
}	


function save_payMent_fun(orderId,id,isNewOder,orderDetail_obj,callBakFun){
	
	 function getPayMent(or){
	 	    setOrder(or); 
            backup_cur_info(or,null,null);
            var orderPublicMoneyRealpay = (isUndefined(or.orderPublic))?0: or.orderPublic.moneyRealpay;
	 		var isNewPayment = orderPublicMoneyRealpay == 0 && $("orderPublic.moneyRealpay").value>0 ?true:false;
	        var isRemovePayment = (orderBackUp.contractId == 0 && $("order.contractId").value >0)?true:false;//订单类别由正常改协约 需要扫除原来的订单付款
	        
	         var isNewDetail = (orderDetailStates >1) ?true:false;

	        
			if(isNewOder){
					savePayMent(true,false);
			}else{
					savePayMent(false,isRemovePayment);
			}
			

			
			//在编辑状态下，并且启用历史记录功能,才保存订单修改日志
			if(orderDetailStates == 1  && orderDetailBackUp.id*1 > 0){
				
							 order.obj.loginUser = loginUserName;
		        orderDetail_obj.order = order.obj;
		        var returnState = config_withoutSubmit == 1?0:4; 
//		        alert(orderDayInfos.length)
//		        orderDetail.obj.orderDayInfos = orderDayInfos;
//		        console.log(orderDetail.obj.matterId);
//		        console.log(orderDetail.obj.matter);
	
		        orderDetail.saveOrderLog(orderDetailBackUp,orderDetail_obj,function(b){
		        	if(b !=""){
		        		 var msg = "此订单审核状态从{"+ $("orderDetail_mod_states").value +"}=>{被退回}";
		        		 if(config_withoutSubmit == 1) msg = "此订单审核状态已改,需要重审,才可正常播出!";
		        		 	 $("isCkecked").value = returnState;
		        		 	 orderBackUp.isCkecked = returnState;
		        		 	 var v = config_withoutSubmit == 1?"":"被退回";
		        		 	 $("orderDetail_mod_states").value = v; 
		        		 	 
		        		 	 var Btn_submit = $("Btn_submit");
		        		 	 if(returnState == 4){
		        		 	 	 Btn_submit.value="提交";
		        		 	 	 
							 	 if(tag_order_submitbtn){
							 	  	 Btn_submit.show();
							 	 }else{
							 	 	 Btn_submit.hide();
							 	 }		        		 	 	 
		        		 	 }else{
		        		 	 	 Btn_submit.value="通过";
		        		 	 	 
							 	 if(tag_check_right){
							 	  	 Btn_submit.show();
							 	 }else{
							 	 	 Btn_submit.hide();
							 	 }		        		 	 	 
		        		 	 }
						 	
		        		 	 
		        		 	 
		        		 	 
//		        		 getOrderDetail(id);	 
                         if(callBakFun) callBakFun();	
		        		 Ext.MessageBox.alert('系统提示',msg,function(){});      
		        	}else{
//		        		 getOrderDetail(id);	 
                         if(callBakFun) callBakFun();	
		        	}
		        	
		        });
			}else{
//				getOrderDetail(id);
				if(callBakFun) callBakFun();	
			}		
			
			
	 };	
	 order.getOrderForEdit(orderId,getPayMent);	
};


function checkResourceChanged(){
	var isNoChanged = true;
    var resourceId = $(resource.selectName).value;
    var resourceId_bak = orderDetailBackUp.resourceInfoId;
    var specificId = $("resourceSpecificId").value;
    var specificId_bak = orderDetailBackUp.resourceSpecificId;
    if(orderDetailStates == 1){
    	isNoChanged = (resourceId == resourceId_bak);
    	if(isNoChanged) isNoChanged = (specificId == specificId_bak);
    }
    return !isNoChanged;
};

function checkCustomer(aaa){
	var dialogcontent = $("dialogcontentDiv");
	var dialogcontentW = dialogcontent.offsetWidth;
	var dialogcontentH = dialogcontent.offsetHeight;
	var winW= dialogcontentW * 0.35;
	var winH = dialogcontentH*0.4;
	var customerName =  ''; 
	var customerId =  '';	
	if(aaa == 1){
		 customerName =  Ext.fly('customerName').dom.value; 
		 customerId =  Ext.getCmp('customerName').getValue();	
	}
	if(aaa == 2){
		 customerName =  Ext.fly('search_adver_customer').dom.value; 
		 customerId =  Ext.getCmp('search_adver_customer').getValue();	
	}
	

	if(customerId == customerName && customerId !=''){
			var cut = (new Customer()).obj;
			 var closeBtn ={text: '取消',handler: function(){regCustomerWin.hide();}};
			 var regBtn ={text: '注册',handler: function(){
			 	
			 	    cut.id = null;
			 	    cut.orgId = orgId;
			 	    cut.customerName = Ext.fly('regCustomerName').dom.value.Trim();
			 	    cut.customerCategoryId = getRadioValue($("regCustomerCategoryName_td"));
			 	    cut.parentId = 0;
			 	    
  
			 	    if(cut.customerCategoryId =='' || cut.customerCategoryId == null){
			 	    	Ext.MessageBox.hide(); 
						Ext.MessageBox.show(
								 	{title:'系统提示!',msg:"请选择客户类型!",width:300,heigth:270,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
						);  
			 	    	return false;
			 	    }
			 	    
			 	   if(tvNameParam=='hntv') {

			 		var areaCityId = Ext.getCmp('customterAreaCity').getValue();
			 		if(areaCityId == 0){
			 	    	Ext.MessageBox.hide(); 
						Ext.MessageBox.show(
								 	{title:'系统提示!',msg:"请选择区域!",width:300,heigth:270,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
						);  
			 	    	return false;
			 	    } 	
			 		
			 	    var linkmanName =  Ext.fly('customterLinkMan').dom.value; 			 		
			 		if(linkmanName =='' || linkmanName =='请填写联系人...'){
			 	    	Ext.MessageBox.hide(); 
						Ext.MessageBox.show(
								 	{title:'系统提示!',msg:"请填写联系人!",width:300,heigth:270,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
						);  
			 	    	return false;
			 	    } 				 		
			 		
			 	    var customterAddress =  Ext.fly('customterAddress').dom.value; 			 		
			 		if(customterAddress =='' || customterAddress =='请填写地址...'){
			 	    	Ext.MessageBox.hide(); 
						Ext.MessageBox.show(
								 	{title:'系统提示!',msg:"请填写地址!",width:300,heigth:270,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
						);  
			 	    	return false;
			 	    } 		
			 		
			 	    var linkManOfficeTel =  Ext.fly('linkManOfficeTel').dom.value; 			 		
			 		if(linkManOfficeTel =='' || linkManOfficeTel =='请填写办公电话...'){
			 	    	Ext.MessageBox.hide(); 
						Ext.MessageBox.show(
								 	{title:'系统提示!',msg:"请填写办公电话!",width:300,heigth:270,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
						);  
			 	    	return false;
			 	    } 				 		
			 		
			 		
			 }	
			
				   var regcustomerName =  Ext.fly('regCustomerName').dom.value; 
				   var regcustomerId =  Ext.getCmp('regCustomerName').getValue();	
	               if(regcustomerId == regcustomerName && regcustomerId !=''){
	               	  customer.saveCustomerForm(cut,callBakFun);
	               }else{
	               	  callBakFun(regcustomerId);
	               }

			 }};	
			 
			 function callBakFun(id){
			 	    	inti_set_customer(customer.customerCommand,1,id,cut.customerName,cut.customerCategoryId);  
			 	    	order.obj.customerId = id;
						saveAreaCity(id);
						if(tvNameParam=='hntv') saveLinkMan(id);
			 	    	regCustomerWin.hide();
			 	    	if(aaa == 1) save_Order();	
			 	    	if(aaa == 2) {
			 	    		inti_set_customer(Ext.getCmp("search_adver_customer"),2,id,cut.customerName,cut.customerCategoryId);  
			 	    		document.getElementById('matteriframe').contentWindow.save_new_matter();	 
			 	    	}
			 }	

			 function saveAreaCity(cutId){
				        var customterAddress = "";
			 	 		var areaCityId = Ext.getCmp('customterAreaCity').getValue();
			 	 	    customterAddress = Ext.fly('customterAddress')? Ext.fly('customterAddress').dom.value:""; 
			 	 		if(areaCityId >0) customerAddress.saveCustomerAddressFormOrder2(cutId,areaCityId,customterAddress);
			 }
			 
			 function saveLinkMan(cutId){
//			 	 		var linkmanName = Ext.getCmp('customterLinkMan').getValue();
			 	 	    var linkmanName =  Ext.fly('customterLinkMan').dom.value; 
			 	 	    var linkManOfficeTel =  Ext.fly('linkManOfficeTel').dom.value; 
//			 	 		if(linkmanName !='' && linkmanName !='请填写联系人...'){
			 	 			linkMan.saveLinkManFormOrder2(cutId,linkmanName,linkManOfficeTel);
//			 	 		}
			 }			 

     if(!regCustomerWin){
     	
     	  buildRegCustomer(winW,winH*0.8,customerName);
		  oaAreaCity.buildCommand("regCustomerAreaDiv","customterAreaCity",winW*0.2);
		  if(tvNameParam=='hntv'){
			  linkMan.buildTextField("regCustomterLinkManDiv","customterLinkMan",winW*0.2);  
			  linkMan.buildOfficeTelField("regCustomterLinkManOfficeTelDiv","linkManOfficeTel",winW*0.5);  
			  customerAddress.buildOfficeTelField("regCustomterAddressDiv","customterAddress",winW*0.95);  
		  }

		  regCustomerWin = new Ext.Window({
			   title : '新客户注册',
			   width : winW,
			   height : winH,
			   isTopContainer : true,
			   modal : true,
			   resizable : false,
			   buttons: [regBtn,closeBtn],
			   contentEl :  $("regCustomer_table")
		  	})     	
     }else{
     	 customer.regcustomerCommand.setValue(customerName);  
     }

	var cmd1 =  Ext.getCmp('customterAreaCity');
	var cmd2 =  Ext.getCmp('customterLinkMan');
	var cmd3 =  Ext.getCmp('linkManOfficeTel');
	var cmd4 =  Ext.getCmp('customterAddress');
	
	if(cmd1)cmd1.clearValue();   
	if(cmd2)cmd2.clearValue();  
	if(cmd3)cmd3.clearValue();   
	if(cmd4)cmd4.clearValue();  
 	regCustomerWin.show(); 	
 			
	}
	
}

//显示修改历史记录
function showOrderLog(orderDetailId){
	var dialogcontent = $("dialogcontentDiv");
	var dialogcontentW = dialogcontent.offsetWidth;
	var dialogcontentH = dialogcontent.offsetHeight;
	var winW= dialogcontentW * 0.6;
	var winH = dialogcontentH*0.8;
	var title = "修改记录";
	var theme = "leopard"; //vista mac_os_x lighting black_hud leopard window
	var draggable = false;
	var minimize = false;
	var maximize = false;
	var close =  'destroy';
	var resizable = false;
	var urlStr = 'selectPopup/selectOrderLog.html?orderDetailId='+orderDetailId+'&winW='+winW+'&winH='+winH;
 	var closeBtn ={text: '关闭',handler: function(){win.hide();}};
  
        
 var win = new Ext.Window({
   title : '修改记录',
   width : winW,
   height : winH,
   isTopContainer : true,
   modal : true,
   resizable : false,
    buttons: [closeBtn],
   contentEl : Ext.DomHelper.append(document.body, {
    tag : 'iframe',
     id : 'orderHistoryiframe',
    style : "border 0px none;scrollbar:true",
    src : urlStr,
    height : "100%",
    width : "100%"
   })
  })
  win.show(this);
};
	

	
//删除按纽事件
function deleteOrderDetail(orderDetailId){
	orderDetailStates = 5;
	var state = $("isCkecked").value;
	var moneyIn =  $("orderPublic.moneyIn").value;
//	var isLastRow = mygrid.getRowsNum()== 1;


if(config_financeBalanceModelParam == 0){
	if(state ==1 || state ==2 || state ==3){
		Ext.MessageBox.alert('系统提示','订单已在审核状态，不能删除！'+'<br>',function(){});     
		return false;
	}else{
		if(moneyIn >0 ){
			Ext.MessageBox.alert('系统提示','订单已平过帐，不能删除！'+'<br>',function(){});     
			return false;
		}
	}
}



	if(orderDetailId != orderDetailBackUp.id) return false;
//	if(isLastRow){
//            Ext.MessageBox.alert('系统提示','已是最后一条记录，不能删除！'+'<br>',function(){}); 
//            setTimeout(function () {Ext.MessageBox.hide();},8000); 
//	}else{
		
		Ext.MessageBox.confirm('系统提示', '请确认是否删除这条记录？', function(btn) {
 			  if (btn == 'yes') {
 				       if(state != 0 && state != 4){
 				    	   alert('当前订单已处于审核中，不允许删除')
 				    	  return false; 	
 				       }
 				       
 				      remove_orderDetail_fun(orderDetailId);
 				 		
				}else{
//              editOrderInfo(); 
//         	  	lockDestopOrderDetail(true); 
//         	  	getOrderDetail(orderDetailId);
             	 }
              return false; 	
		 });
//	}
}

function remove_orderDetail_fun(orderDetailId){

   	var removeFun = function(){
 		var curRows = mygrid.getRowsNum(); 
 		var curRowIndex  = orderDetailId > 0 ? mygrid.getRowIndex(orderDetailId):0;
 		curRowIndex = curRowIndex == curRows-1? curRowIndex -1:curRowIndex;
 		mygrid.deleteSelectedItem();
		curRows--;
		orderDetail.reset();
        getDetailFun(curRowIndex);
    }   

    orderDetail.obj =  getOrderDetailObj(orderBackUp.id,false,false);
    orderDetail.obj.id = orderDetailId;
    orderDetail.obj.isLastDetail = (mygrid.getRowsNum()== 1);
    
//    if(orderDetail.obj.isLastDetail){
////    	 Ext.MessageBox.alert('系统提示','已是最后一条记录，不能删除！'+'<br>',function(){});   
//         orderDetail.orderDetailBak ={orderDetailBak:{orderDayInfos:new Array()}}; 
//    }else{
//    	 orderDetail.removeOrderDetail3(removeFun);
//    }

						    
						    
			orderDetail.removeOrderDetail3(
		 			{
					　　callback:function(data){removeFun();},
					　　errorHandler:function(errorString, exception) { 
						    var msg="<div style='width:300px;height:300px;OVERFLOW-y:auto;OVERFLOW: scroll;'>"+"财务已经平过帐,无法删除!"+"<div>";
									Ext.MessageBox.hide(); 
									Ext.MessageBox.show(
									 	{title:'系统提示',msg:msg,width:380,heigth:300,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
									); 						

					    }
		 			}						    
						    
				)		    
  
		
	function getDetailFun(curRowIndex){
	   		//获得第一行id的值，并激发鼠标点击事件
			resetOrderDetail(false);
			resetDayInfo(true);
			orderDetail.orderDetailBak ={orderDetailBak:{orderDayInfos:new Array()}}; 

			if(orderDetail.obj.isLastDetail || curRowIndex ==-1){
				 orderDetailStates = 2;
				 getOrder(order.obj.id);
				 return false;
			}
			for(var i = curRowIndex; i< mygrid.getRowsNum();i++){
				var id = mygrid.getRowId(i);
				var cell = mygrid.cells2(i,0);
				cell.setValue(i+1);
			}			
			
			var nextRowId  = mygrid.getRowId(curRowIndex);
			if(nextRowId > 0){
				getOrderDetail(nextRowId);
			}else{
				orderDetailStates = 2;
			}
			//重新读取定单合计信息
			function savePayMentFun(orderPublic){
				order.obj.orderCategory.name = DWRUtil.getText("categoryId") ;
				setOrderPublic(orderPublic);
				savePayMent(false,false);
				orderDetailStates = 0;
			}
	    	getOrderPublic(savePayMentFun);
	   }
}

//新添定单
function addNewOrder(){
	
	if(orderBackUp.id == null){extjMessage('您当前处于新添状态，无法新添!'); return false;}
	close_OrderDetails();
	get_cur_year();
	orderDetailStates = 2;	
	resetOrder();
	resetOrderDetail(true);
	resetDayInfo(true); 
	getMatterLengthComplt();
//	$("categoryId").value = 1;
//	reloadOrderCategory1Store();
	lockDestopOrderDetail(true);//封锁
	$("customerId").value = null;
	closeBroArrangeDiv();
	getContarctAuto();
	initMatterButton=true;
	initMatter();
//	init_order_cate_main();
    onchangeResourceSort();
	init_resourceSpeci();
	setOrderCategoryDef();
}

//新添定单明系
function addnewOrderDetail1(){
	orderDetailStates = 2;
	otherFocus();
	displaySumMoney();
	closeBroArrangeDiv();
	close_OrderDetails();
	resetOrderDetail(false);
	resetDayInfo(true);
	lockDestopOrderDetail(true);
	initMatterButton=true;
//	init_order_cate_main();
	initMatter();
	init_resourceSpeci();
	getMatterLengthComplt();
}

//取消
function cancelOrder(){
	var srcStr = window.location.href;
	var pos = srcStr.indexOf("?");
	var paramStr = srcStr.substring(pos+1);
	var paramObj =  $H(paramStr.toQueryParams());
	paramObj.set("id",order.obj.id);
	paramObj.set("version",$("order_year").value);
	
	
	if(config_oneOrgMoreSuborgsParam == '1'){
		paramObj.set("orgId",orgIdRel);
	}
	
	self.location =   ctxPath + "orders.html?" + paramObj.toQueryString();
}

//新添并粘贴 
function postOrderDetailt(isNoBroArrange){
	close_OrderDetails();
	if(orderBackUp.id == null){
		 extjMessage('您当前处于新添状态，无法复制！'); return false;
	}
	if(orderDetailBackUp.id == null){
		    var id = mygrid.getSelectedId();
		 	if(id > 0) {
		 		 getOrderDetail(id);
		 		 extjMessage('您当前处于新添状态，系统先要恢复原有的信息！');return false;
		 	}else{
		 		 extjMessage('请您先选择要复制的行');return false;
		 	}
	}
	
	var start = orderDetailBackUp.orderPublic.publishStartDate;
	var end = orderDetailBackUp.orderPublic.publishEndDate;
	orderDetailBackUp = (new OrderDetail()).obj;
	
	if(!isNoBroArrange){
		 $("Btn_save").disabled = true;
		 $("Btn_addAndPost1").disabled = true;
		 $("Btn_addAndPost2").disabled = true;
		 $("resourceSpecificId").value = 0;

//		 broArrange.broArrangeStartDate.value = start;
//         broArrange.broArrangeEndDate.value = end;
	}
	
	
	
	
	orderDetailStates = 3;
//	init_order_cate_main();
	getMatterLengthComplt();
	closeBroArrangeDiv();
	otherFocus();  
	
		function callfun(){
			broArrange.broArrangeStartDate.value = start;
			broArrange.broArrangeEndDate.value = end;
	}
	
	
	backupBroarrayToCur(true,callfun,true,isNoBroArrange);
	lockDestopOrderDetail(true);
}

//防止 keypress space
function otherFocus(){
	$("dayUsedTime").focus();	
}

function backupBroarrayToCur(newDetail,callfun,isCleanBroArrange,isNoBroArrange){

	$("Btn_save").disabled = true;//开始排期时将保存按钮锁定
	var broArray = broArrange.copyTimesFromTargToArray();
		
	var func = function(){
		if(isCleanBroArrange) broArrange.cleanBroArrange();
		if(isNoBroArrange) {if(!isUndefined($("Btn_save"))) $("Btn_save").disabled = false;if(callfun) callfun();return false;}//[复制广告]完成将保存按钮恢复,因为[复制全部]在下面已经恢复了保存按钮，所以改动这一处即可；
		var ev = Event; ev.type ="keydown" ;
		//var keycodes = new Array(48,49, 50, 51, 52, 53, 54, 55, 56, 57);
		var trs = broArrange.targ.getElementsByTagName("tr");
	   	var k = 0;
		for(var i = 0; i< trs.length;i++){
			var cells = trs[i].cells;
			var navtype = cells[0].navtype;
			if(navtype !="-1"){
				for (var j = 1 ; j < 33;j++){
					var times = broArray[k++];
					var el = cells[j];
					if(times > 0){
					    ev.keyCode = BroArrange.keycodes[times];
					    if(broArrange.isEnableCellClick(el,ev)){
					      	broArrange.cellClick(el,ev);
					    }else{
					    	ev.keyCode = BroArrange.keycodes[0];
					    	broArrange.cellClick(el,ev);
					    }
					}
				}	
			}

		}

		if(!isNoBroArrange){
			 $("Btn_save").disabled = false;
			 $("Btn_addAndPost1").disabled = false;	
			 $("Btn_addAndPost2").disabled = false;			 
		}
			
		var detailSumTimes = $("broSumTime").value;
		if(callfun) callfun(detailSumTimes);
	}
	var rsId =$("resourceInfoId").value;
	var specificValue = getSelectParamFromAttribute($("resourceSpecificId"),"position");
    var isLock = false;
	getMonthInfos(isLock,rsId,specificValue,broArrange.startDate,broArrange.endDate,func,false);	
};

//检测是否有空值
function checkOrder(){ 
	if($("categoryId").value == 0){extjMessage('定单类别为空!不允许保存!');return false;};
	if(Ext.getCmp('customerName').getValue() == ''){extjMessage('客户名称为空!不允许保存!');return false;};
    var userName =   Ext.fly('userId').dom.value; 
    var uid = Ext.getCmp('userId').getValue();	

    if(userName == uid  &&  uid !=''){
    	user.displayUsersBranchs(loginUserId,orgId,userName,Ext.getCmp('userId'),save_Order);
    	return false;
    } 
    
    if(uid =='') {
//    	extjMessage('没有选择业务员,不允许保存!');Ext.getCmp('userId').onTriggerClick();
//	    Ext.MessageBox.alert('系统提示', '没选择业务员,不允许保存!', function callBack(id) {
//			Ext.getCmp('userId').onTriggerClick();
//		} );
		Ext.MessageBox.hide(); 
	    Ext.MessageBox.show(
			{title:'系统提示',msg:'没选择业务员,不允许保存!',width:300,heigth:200,buttons: Ext.Msg.OK, icon: Ext.MessageBox.INFO,fn:function callBack(id) {
				Ext.getCmp('userId').onTriggerClick();
			} }
		); 		
    	return false;
    	
    };
    
    
    

   
    
    
    
    if(Ext.getCmp('orderCategoryId').getValue() == ''){extjMessage('定单子类别为空,不允许保存!');return false;}
    
    var search_brand_id = Ext.getCmp('search_brand').getValue();	
    if(search_brand_id =='') {
    	Ext.MessageBox.hide(); 
	    Ext.MessageBox.show(
			{title:'系统提示',msg:'没选择品牌,不允许保存!',width:300,heigth:200,buttons: Ext.Msg.OK, icon: Ext.MessageBox.INFO,fn:function callBack(id) {
				Ext.getCmp('search_brand').onTriggerClick();
			} }
		); 		
    	return false;
    }
    
//    if(Ext.getCmp('search_brand').getValue() == ''){extjMessage('品牌为空,不允许保存!');Ext.getCmp('search_brand').onTriggerClick();return false;}
    
 
    
	if(config_adverCodeModelParam == '0'){
		if($("matter.tapeCode").value == ""){extjMessage('磁带号为空,不允许保存!');return false;}
	}
	if($("matter.name").value == ""){extjMessage('广告名称为空,不允许保存!');return false;};
	if($("matterLength").value == '') $("matterLength").value = 0;
	if(industry.treecombo.passField.getValue() == 0) {extjMessage('行业类别为空,不允许保存!');return false;};
	if(!price.isPass($("favourRate").value,$("lowestRate").value)) {extjMessage('低于最低折扣,不允许保存!');return false;};
	if(saveOrderUnable()) return false;
	return true;
}

function checkTapeCode(){
	var isBug = false;
	var curtapeCode = $("matter.tapeCode").value;
	curtapeCode = curtapeCode == ""?null:curtapeCode;
	
	matter.reset();
	matter.obj.orgId = orgId;
	matter.obj.name = $("matter.name").value;
	matter.obj.edit = $("matter.edit").value;
	matter.obj.length = $("matterLength").value;
	var obj =  matter.getMatterByNameVerLen(matter.obj);

	if(obj != null){
		obj.tapeCode = obj.tapeCode == ""?null:obj.tapeCode;
		if(curtapeCode != obj.tapeCode && obj.tapeCode != null){
			extjMessage('磁带号有冲突,已存在的磁带号为:["+ obj.tapeCode +"],系统为您自动修正');isBug = true;
			$("matter.tapeCode").value = obj.tapeCode;
			$("matter.tapeCode").focus();
		}
	}else{
		if(curtapeCode != null){
			
			matter.reset();
			matter.obj.tapeCode = curtapeCode;
			var object =  matter.getMatterByTapeCode(matter.obj);
			
			if(object != null){
				object.tapeCode = object.tapeCode == ""?null:object.tapeCode;
				if(curtapeCode == object.tapeCode){
					extjMessage('磁带号有冲突,请重新输入新的磁带号!');isBug = true;
				    $("matter.tapeCode").focus();
				}
			}
		}
	}
	return isBug;
}

//全局锁定控制
function disableContrlGlobal(){
	//如果不是订单协约 锁定

	$("sysPrice").disabled= true;	 
//	$("execPrice").disabled= true;	
//	$("favourRate").disabled= true;   
	$("ageRate").disabled= true;
	$("moneyBase").disabled= true;
	$("order_year").disabled = true; 
	
	set_el_backgroundColor($("order_year"));    
	
 
	if(config_orderContractParam == '0'){
		$("orderPublic.moneyRealpay").readOnly= true;	 
	}  
	
	$("moneyRealpay").readOnly= true; 
	$("orderCode").readOnly = true; 
	
	
	

	if(!tag_order_paymentbtn){
	 		$("favourRate").style.backgroundColor="#000000";
	 		$("favourRate").style.color="#000000";
	 		$("moneyRealpay").style.backgroundColor="#000000";
	 		$("moneyRealpay").style.color="#000000";
	 		$("execPrice").style.backgroundColor="#000000";
	 		$("execPrice").style.color="#000000";	 		
	 		$("sysPrice").style.backgroundColor="#000000";
	 		$("sysPrice").style.color="#000000";		 		
	 		
	 		$("sysPrice").disabled= true; 
	 		$("execPrice").disabled= true; 
	 		$("favourRate").disabled= true; 
	 		$("moneyRealpay").disabled= true; 
	}else{
	 	  $("favourRate").style.backgroundColor="#ffffff";
	 	  $("favourRate").style.color="#000000";
	 	  $("moneyRealpay").style.backgroundColor="#ffffff";
	 	  $("moneyRealpay").style.color="#000000";
	 	  $("execPrice").style.backgroundColor="#ffffff";
	 	  $("execPrice").style.color="#000000";	 	 
		 	 $("sysPrice").style.backgroundColor="#ffffff";
	 	  $("sysPrice").style.color="#000000";	 	  
	 	   
	 	  
//	 	  $("favourRate").disabled= false; 
//	 	  $("moneyRealpay").disabled= false; 
	 }
	 
//	if(config_useLanmuSingleParam == 0) $("resourceSortId").disabled = true;

    //订单保存权限

    if(!tag_orderDetail_save){
    	$("Btn_addNewOrder").hide();
    	$("Btn_addNewAdver1").hide();
    	$("Btn_addNewAdver2").hide();
    	$("Btn_addAndPost1").hide();
    	$("Btn_addAndPost2").hide();
    	$("Btn_save").hide();
    	$("Btn_save_order_memo").hide();
    	$("Btn_change_matter_brotime").hide();
    	
    }
    

    
	if(tag_order_leadmemo) {
	  	$("leadmemo_lable").show();
	  	$("leadmemo_const").show();
	}else{
		$("leadmemo_lable").hide();
		$("leadmemo_const").hide();
	}
	
	
	if(tvNameParam !='qztv' && tvNameParam !='hbtv' && tvNameParam !='xmtv'){
		$("td_Btn_submit").hide();
	}
	

	if(config_fastSignOrderParam == 1){
		$("Btn_addNewAdver2").show();
	}else{
		$("Btn_addNewAdver2").hide();
	}

    
//    if(config_useLanmuSingleParam == 1) {
//	  	$("resourceSortId").removeAttribute("disabled");
//	}
	
	

	  
}

function lockOrderDestop(unlock,catMain){
	var rows = mygrid.getRowsNum();
    if(rows>1){
//    	$("categoryId").disabled= "true";
    	$("contract.code").disabled= true;

        if(catMain.indexOf("协约合同") > -1 || catMain.indexOf("部门订单")>  -1){
            Ext.getCmp("customerName").disable();
        }else{
        	if(unlock){
        		if(config_resourceUseCustomerCatelog == 1 && mygrid.getRowsNum()>0 ){
        			Ext.getCmp("customerName").disable();
        		}else{
        			Ext.getCmp("customerName").enable(); 
        		}
        		
        		$("categoryId").disabled= false;
        	}else{
        		Ext.getCmp("customerName").disable();
        		$("categoryId").disabled= true;
        	}
        }

        
    }else{
    	    
        	if(unlock){
//        		Ext.getCmp("customerName").enable(); 
        		
        		if(config_resourceUseCustomerCatelog == 1 && mygrid.getRowsNum()>0 ){
        			Ext.getCmp("customerName").disable();
        		}else{
        			Ext.getCmp("customerName").enable(); 
        		}       		
        		
        		
        		$("categoryId").disabled= false;
        		$("contract.code").disabled= false;
        	}else{
				Ext.getCmp("customerName").disable();
				$("categoryId").disabled= true;
    			$("contract.code").disabled= true;
        	}    	
    	
    }
    
      	
   
   	set_el_backgroundColor($("categoryId"));    
    set_el_backgroundColor($("contract.code"));   
    
}

//封锁控制，通过每一条定单明系的次数来判断
function lockDestopOrderDetail(forceUnlock){
	var broSumTime = $("broSumTime").value;
	broSumTime = broSumTime ==''?0:broSumTime;
	var catMain = DWRUtil.getText("categoryId");
	var isCkecked = $("isCkecked").value;
	var Btn_submit = $("Btn_submit");
	//隐藏按钮，如果是强制保存不需要检测
	
//	if(config_allowModiyPassedOrderParam == 0){
//   	 	lockedByState(isCkecked);
//	}else{
//		Btn_submit.hide();
////		if(isCkecked == 3){
////			   		Btn_submit.value ="退回";
////		}else{
////			   		Btn_submit.value ="通过";
////		 }		
//		
//	}
	
	lockedByState(isCkecked);
	
    lockOrderDestop(forceUnlock,catMain);
    

    if(config_useLanmuSingleParam == 1 && $("orderPublic.times").value >0) {
	  	$("resourceSortId").disabled = true;
	  	 set_el_backgroundColor($("resourceSortId"));  
	}else{
	 	$("resourceSortId").disabled = false;
	}

   


   if (forceUnlock ){
   	    $("btn_packeg").disabled= false;
   	   
   	    if(config_fastSignOrderParam == 1){
   	    	$("Btn_addNewAdver2").show();
   	    }
   	    	 
   	    $("Btn_addNewAdver1").show();
   	    $("Btn_addAndPost1").show();
   	    $("Btn_addAndPost2").show();
     		 $("Btn_save").show();
     		 $("Btn_change_matter_brotime").show();
     		 
     		
     		

  	    var orderSumTimes = $("resourcePriceType").value;
        if(orderSumTimes == 0){$("categoryId").disabled= false; }
	  	if(loginUserName =='admin'){
	  		$("orderCode").readOnly = false; 
	  	}	
	  	   	
//	  	 var resIsManual = getSelectParamFromAttribute($(resource.selectName),"isManual");
				$("sysPrice").disabled = false;
      $("execPrice").disabled =  false;
      $("autoBroArrange").disabled =  false;
      $("cleanBroArrange").disabled =  false;
      $("resumeBroArrange").disabled =  false;
      $("addBroArrange").disabled =  false;
	  $("isSpaceAdver").disabled =  false;
//	  $("moneyRealpay").disabled =  false;


       Ext.getCmp("userId").enable();
       industry.treecombo.enable();	  
       Ext.getCmp("orderCategoryId").enable();       

	  $("carrierId").disabled =  false;
      $("resourceInfoId").disabled =  false;
      $("resourceSpecificId").disabled =  false;
      $("resourcePriceType").disabled =  false;
    


	   if(isCkecked != 0 && isCkecked != 4){
   	   	if(config_permitModAdverParam != "1" ){
   	   		 $("matter.edit").readOnly = false;
   	   	}
   	   }else{
   	   	 	$("matter.edit").readOnly = false;
   	   }
   	   


		$("moneyRealpay").readOnly = false;  
		$("carrierName").readOnly = false;    
		$("orderCode").readOnly = false;     	    
 		$("orderPublic.moneyRealpay").readOnly = false;  
		$("relationCode").readOnly = false;        
		$("matterLength").readOnly = false;
		$("favourRate").readOnly = false;	    	  
		$("appRate").readOnly = false;
		$("matter.tapeCode").readOnly = false;
		$("matter.name").readOnly = false;
		$("compages.pos").readOnly = false; 
		$("moneyBalance").readOnly = false; 

   }else{

   	   	$("Btn_addNewAdver1").hide();
   	   
   	   	$("Btn_addAndPost1").hide();
   	    $("Btn_addAndPost2").hide();
   	    
   	    
   	  

 	   if(config_permitModAdverParam != "1" ||!tag_orderDetail_save) {
 			$("Btn_addNewAdver2").hide();
 	  	 	$("Btn_change_matter_brotime").hide();
 	  	 	$("Btn_save").hide();
 	   }

   	   $("autoBroArrange").disabled =  true;
   	   $("cleanBroArrange").disabled =  true;
   	   $("resumeBroArrange").disabled =  true;
   	   $("addBroArrange").disabled =  true;
		$("isSpaceAdver").disabled =  true;
 
   	  

  	   Ext.getCmp("userId").disable();	
       Ext.getCmp("orderCategoryId").disable(); 	   
   	   industry.treecombo.disable();
   	   
   	   
   	   var select_btn_packeg = $("btn_packeg");
   	   select_btn_packeg.disabled= true;
   	   set_el_backgroundColor(select_btn_packeg);  

   	 
    	var select_carrierId = $("carrierId");
   	    select_carrierId.disabled = true;
   	    set_el_backgroundColor(select_carrierId);     	  
   	  
     	var select_resourceInfoId = $("resourceInfoId");
   	    select_resourceInfoId.disabled = true;
   	    set_el_backgroundColor(select_resourceInfoId);   	  
   	  

       	var select_resourceSpecificId = $("resourceSpecificId");
   	    select_resourceSpecificId.disabled = true;
   	    set_el_backgroundColor(select_resourceSpecificId);  	  
   	  
     
      	var select_resourcePriceType = $("resourcePriceType");
   	    select_resourcePriceType.disabled = true;
   	    set_el_backgroundColor(select_resourcePriceType);  	 
   	    

	   if(isCkecked != 0 && isCkecked != 4){
   	   	if(config_permitModAdverParam != "1" ){
   	   		 $("matter.edit").readOnly = true;
   	   	}
   	   }else{
   	   	 	$("matter.edit").readOnly = true;
   	   }
   	   

		$("sysPrice").readOnly =  true;
		$("execPrice").readOnly =  true;
		$("moneyRealpay").readOnly = true;  
		$("carrierName").readOnly = true; 
		$("orderCode").readOnly = true;     	    
 		$("orderPublic.moneyRealpay").readOnly = true;  
		$("relationCode").readOnly = true;        
		$("matterLength").readOnly = true;
		$("favourRate").readOnly = true;	    	  
		$("appRate").readOnly = true;
		$("matter.tapeCode").readOnly = true;
		$("matter.name").readOnly = true;
		$("compages.pos").readOnly = true; 
		$("moneyBalance").readOnly = true;  	   

   }
}

function set_el_backgroundColor(el){
	el.style.backgroundColor="#ffffff";
}

function lockedByState(state){
	
	var Btn_submit = $("Btn_submit");
	
	if(config_withoutSubmit == 1){
   if(!tag_order_submitbtn) Btn_submit.hide();
		if(state == 3){
			Btn_submit.value ="退回";
		}else{
			Btn_submit.value ="通过";
		}
		
	}else{
		
		if(state == 0 ||state == 4){
			    Btn_submit.value ="提交";
				if(tag_order_submitbtn){
					Btn_submit.show();
				}else{
					Btn_submit.hide();
				}
		}else{
			   if(state == 3){
			   		Btn_submit.value ="退回";
			   }else{
			   		Btn_submit.value ="通过";
			   }
				
				if(tag_check_right){
					Btn_submit.show();
				}else{
					Btn_submit.hide();
				}
		}
					

	}
	
	if(config_allowModiyPassedOrderParam == 0){
		if(state != 0 && state != 4){
	//		alert(tag_order_force_modify)
	//		if(tag_order_force_modify) return false;
			$("Btn_addNewAdver1").hide();
//			$("Btn_addNewAdver2").hide();
			$("Btn_addAndPost1").hide();
			$("Btn_addAndPost2").hide();
	//		$("Btn_submit").hide();
			//$("orderMeno").disabled= true;
			orderDetail.enableDel = false;
			//$("orderDetailImgAdd").onclick = function(){return false};
			if(config_permitModAdverParam =="0"||!tag_orderDetail_save ){
				$("Btn_addNewAdver2").hide();
				$("Btn_change_matter_brotime").hide();
				
			}
			

			
		}else{
//			$("Btn_addNewAdver1").show();
//			$("Btn_addNewAdver2").show();
			
	  	    if(config_fastSignOrderParam == 1){
	   	    	$("Btn_addNewAdver2").show();
	   	    }		
			
			$("Btn_addNewAdver1").show();
			$("Btn_addAndPost1").show();
			$("Btn_addAndPost2").show();
			
			 if(!tag_orderDetail_save){
			 				$("Btn_change_matter_brotime").hide();
			 }else{
			 				$("Btn_change_matter_brotime").show();
			 }

			
	//		alert(config_withoutSubmit);alert(tag_order_submitbtn);
	//	    if(config_withoutSubmit == 1 || !tag_order_submitbtn){
	//	    	$("Btn_submit").hide();
	//	    }		
			
		}	
	}


}

function getBroDate(startDate,endDate){
	startDate = (startDate == null|| startDate==0)? config_serviceDate:startDate;
	endDate = (endDate == null || endDate == 0)? config_serviceDate:endDate;

	broArrange.startDate = myDate.getStartDay(startDate);
	broArrange.endDate = myDate.getEndDay(endDate);  
	broArrange.lastMonthDay = broArrange.endDate; 
	
}

//获得月信息
function getMonthInfos(isLock,rsId,specificValue,startDate,endDate,func,isFirstLoadMonthsInfo){
	
 		var isPackeg = ($("btn_packeg").value == 2) ?true:false;

       if($('resourceInfoId').value==0 && $("compages.resourceIds").value!=0){
       	 	resourceId = $("compages.resourceIds").value.split(',')[0];
       }else{
       		resourceId = rsId;
       }
       
       
       var resourceSort =  getSelectParamFromAttribute($("resourceSortId"),"paramvalue");
       
       
	var getMonthsFun = function(objs){
    	
   if(isFirstLoadMonthsInfo) backup_cur_info(null,null,objs);	
   
//   backup_cur_info(null,null,objs);	

   broArrange.reset();	
		broArrange.adLength = $("matterLength").value*1;
		broArrange.basePrice = $("sysPrice").value;
		broArrange.realPrice = $("execPrice").value;
		broArrange.ageRate = $("ageRate").value;
		broArrange.moneyBalance = $("moneyBalance").value;
		
		broArrange.favourRate =  $("favourRate").value*1;
		broArrange.appRate = $("appRate").value*1;		
	
		
		
		
		broArrange.isLock = isLock;
		broArrange.objs = objs;
		//超时封签
		if(tag_time_out){BroArrange.isTimeOutRight = true;}

		broArrange.setup(); 
		//设置开始结束日期
		broArrange.getBroArrangeStarEndDate(_app_params);
		if(func) func();
    }
 	getBroDate(startDate,endDate);
 	  
     var orderDetail_id = null; 
     if(orderDetailStates == 1){
     	orderDetail_id = orderDetailBackUp.id;
     }
     else  if(orderDetailStates == 0 ){
     	orderDetail_id = orderDetail.obj.id;
//     	orderDetail_id = orderDetail.obj.id;
     }
     


//     alertbroArrange.endDate)

	var orderDetail_obj = (new OrderDetail()).obj;
	orderDetail_obj.id = orderDetail_id;
	orderDetail_obj.publishStartDate = broArrange.startDate;
	orderDetail_obj.publishEndDate = broArrange.endDate;
	orderDetail_obj.resourceInfoId = resourceId;
	orderDetail_obj.specific.position = specificValue == null?'':specificValue;
	orderDetail_obj.compagesId = $("compagesId").value;
	orderDetail_obj.version = order_year;
	orderDetail_obj.orderDetailStates = orderDetailStates;
//	orderDetail_obj.orderDetailStates = $("isCkecked").value;
	
//	 var customerCategoryId  = getValueFromStoreById(Ext.getCmp('customerName'),"customerCategoryId");
	orderDetail_obj.resourceSortId = getValueFromStoreById(Ext.getCmp('customerName'),"customerCategoryId");
	
//	alert('5300>>>getMonthInfos>>>customerCategoryId>>'+orderDetail_obj.resourceSortId)

	
	if(resourceSort == 2){
    	orderDetail_obj.compagesId =999;
//    		orderDetail_obj.resourceInfoId = 0;
    }
	
  if(isPackeg){
     	orderDetail_obj.resourceInfoId = 0;
     }
   
	if(isFree){
		orderDetail.getMonthInfosForFree(orderDetail_obj,getMonthsFun);
	}else{ 
		if(resourceId>0) orderDetail.getMonthInfos(orderDetail_obj,getMonthsFun);
	}
};

//选择月份下拉框事件
function selectMonth(ev){
	var choseMonth = $("selectMonth").value;
	var oldStartMonth = myDate.getMonth(broArrange.startDate) * 1;
	var oldEndMonth = myDate.getMonth(broArrange.endDate) * 1;
	var startDate = broArrange.startDate;
	var endDate =   broArrange.endDate;

	if(choseMonth == "=全年=" || choseMonth == "选择月份"){
        if(choseMonth == "选择月份"){
        	resumeBroArrange();
        }else{
	 		var year = broArrange.endDate.substring(0,4);
			startDate =  myDate.yearFirstDay(year);
			endDate =  myDate.yearLastDay(year); 	
        }
	}else{
		if(choseMonth < oldEndMonth){
			if(choseMonth < oldStartMonth){
				startDate = myDate.getNewDayStartDay(broArrange.endDate,choseMonth);
			}else{
				return false;				
			}
		}else{
			startDate = broArrange.startDate;
			endDate =  myDate.getNewDayEndDay(broArrange.endDate,choseMonth);
		}		
	}
	var rsId =$("resourceInfoId").value;
	var specificValue = getSelectParamFromAttribute($("resourceSpecificId"),"position");
	var isLock = false;
	getMonthInfos(isLock,rsId,specificValue,startDate,endDate,null,false);
};

function resumeBroArrange(){
	var id = orderDetailBackUp.id;
	if(id != null && id !='null'&& id !=''){
		getOrderDetail(id);
	}
};
//添加新月
function addBroArrange(ev){
	var isPackeg = ($("btn_packeg").value == 2) ?true:false;
	var resourceSort =  getSelectParamFromAttribute($("resourceSortId"),"paramvalue");
	
	if(!isPackeg){
			if($("resourceInfoId").value <1 && (resourceSort == 1||resourceSort == 3)){
				 extjMessage('增加月份前，请选择广告资源');
				 return false;
			}
	}

	otherFocus();
	var startDate = broArrange.startDate;
	var endDate =   myDate.getNextMonthDay(broArrange.lastMonthDay);
	var m = broArrange.myDate.getMonth(endDate)*1;
	DWRUtil.setValue("selectMonth", m);

	if(endDate){//alert(endDate);
		broArrange.endDate = endDate;
		endDateInit=endDate;
		broArrange.startDate = startDate;
		broArrange.endDate =endDate;
	    var isNewOrderDetail = (orderDetailStates == 2||orderDetailStates == 3);
	    backupBroarrayToCur(isNewOrderDetail,null,true);
	}
}
function addNewOrderDayInfo(ev){
	var cur_year = _app_params.serviceDate.year;
	var cur_day = _app_params.serviceDate.date;
	
	var cur_date = (order_year != cur_year )?order_year +"0101":config_serviceDate;
	var startDate = myDate.getStartDay(cur_date);
	var temp = myDate.getMonth(startDate)*1;
//	var nextMonth = myDate.getMonth(startDate)*1 + 2;

	var nextMonth = 0;
	if(tvNameParam =='hbtv'){
		nextMonth = myDate.getMonth(startDate)*1;
		if(cur_day >24){
			nextMonth = nextMonth + config_orderArrangDefaultMonths;
		}
	}else{
		nextMonth = myDate.getMonth(startDate)*1 + config_orderArrangDefaultMonths;
	}
	

	
	if( temp+2 >= 13)  nextMonth = 12;
	var endDate   = myDate.getNewDayEndDay(startDate,nextMonth);
	DWRUtil.setValue("selectMonth", 0);
	if(endDate){
		var rsId = $("resourceInfoId").value;
		var specificValue = getSelectParamFromAttribute($("resourceSpecificId"),"position");
		var isLock = false;
		getMonthInfos(isLock,rsId,specificValue,startDate,endDate,null,false);		
	}
}
//保存dayInfo信息
function saveOrderDayInfo(){
	var orderDayInfos = new Array();
	var curSpecific = getSelectParamFromAttribute($("resourceSpecificId"),"position");
	curSpecific = isUndefined(curSpecific)?'':curSpecific;
    var adlength  = $("matterLength").value*1;
    var sysPrice = $("sysPrice").value;
	var paymentId = $("paymentId").value;
	var contractId = $("order.contractId").value;
	var customerId =  $("customerId").value;
	var linkUserId = Ext.getCmp('userId').getValue();
	orderDayInfo.obj.needCal = orderCategory1.calculateAuto;
	orderDayInfo.obj.contractId = contractId;
	orderDayInfo.obj.paymentId = paymentId;
//	orderDayInfo.obj.orderId = order.obj.id;
	//orderDayInfo.obj.orderDetailId = $("dt_orderDetailId").value;
	orderDayInfo.obj.orderDetailId = orderDetail.obj.id;
	orderDayInfo.obj.dayStandardPrice = sysPrice;
//	orderDayInfo.obj.dayStandardPrice =$("sysPrice").value; 
	orderDayInfo.obj.dayRelIncome = 0;
	orderDayInfo.obj.dayRelPuton = 0;
	orderDayInfo.obj.resourceSpecific = curSpecific;
	orderDayInfo.obj.isPublished = 0;
	orderDayInfo.obj.adlength = adlength;
	orderDayInfo.obj.customerId = customerId;
	orderDayInfo.obj.linkUserId = linkUserId;
	orderDayInfo.obj.version = order_year;	

	//资源日信息
//	resDayInfo.obj.carrierId = $("carrierId").value;
//	resDayInfo.obj.resourceId = $("resourceInfoId").value;
//	resDayInfo.obj.version = 2;  //为了跟原来正常下的增删该区分开
	 //广告日信息 
	var trs = broArrange.targ.getElementsByTagName("tr");
	var trnum = trs.length;  
	
	for (var i = 0; i < trnum; i++) {      
	   var cell = trs[i].firstChild;
	      for (var j = 0; j < 32; j++,cell = cell.nextSibling) {
	  		  if(cell.navtype == "1" && cell.dayObj.dayDate !=null){
	  		  	
	  		  var curValue = (cell.innerHTML > 0) ?  cell.innerHTML*1 : "0";

              if(curValue > 0) {
//               dayObj == DayInfoArray
				  var dayObj = cell.dayObj;
			  	  var order_Day_Info = (new OrderDayInfo()).obj;
				  order_Day_Info.publishDate = dayObj.dayDate;	
				  order_Day_Info.rsModifyTime = dayObj.rsModifyTime;
				  order_Day_Info.rsSpecific = dayObj.rsSpecific;
//				  order_Day_Info.rsUsed = dayObj.rsUsedTime;
				  order_Day_Info.adlength = orderDayInfo.obj.adlength;
				  order_Day_Info.adDayTimes = curValue;
				  order_Day_Info.resourceSpecific = orderDayInfo.obj.resourceSpecific;
	              order_Day_Info.isPublished = orderDayInfo.obj.isPublished;
	              order_Day_Info.version = orderDayInfo.obj.version;
	               order_Day_Info.contractId = 0;
	               order_Day_Info.orderId = 0;
				   order_Day_Info.dayRelIncome = 0;
				   order_Day_Info.dayRelPuton = 0;
	              order_Day_Info.dayStandardPrice = orderDayInfo.obj.dayStandardPrice; 
				  order_Day_Info.dayRelIncome = orderDayInfo.obj.dayRelIncome;
				  order_Day_Info.needCal = orderDayInfo.obj.needCal;

				  orderDayInfos.push(order_Day_Info);
              }
		  	  
		  }
	  }
	}


	return orderDayInfos;

}




//资源指定的判断
function getMatterAutoComplet(isFromNameKeypress){
	
	var customerName =  Ext.fly('customerName').dom.value; 
	var customerId =  Ext.getCmp('customerName').getValue();
	customerId = customerId > 0?customerId:"";
	var matterLength = $("matterLength");
	var stopAuto=false;
	
	matter.reset();
	matter.obj.orgId =orgId;

	if(matterLength.disabled){
		 if(matterLength.value!=""){
		 	matter.obj.length = matterLength.value*1;
		}
	}else{
	   	if(initMatterButton==false && customerId!=""){
		    if(matterLength.value == 0){
		    	matter.obj.length = null;
		    }else{
		    	matter.obj.length = matterLength.value*1;
		    } 	 
		}else if(initMatterButton==true && customerId!=""){
		    if(matterLength.value == 0){
		    	matter.obj.length = null;
		    	stopAuto = true;
		    }else{
		    	matter.obj.length = matterLength.value*1;
		    }    			
		}
	}
	
	
//	alert(($("matter.name").value).trim()=="")
     if(($("matter.name").value).trim()==""){
		 if(customerId=="" ){
		 	if(initMatterButton==false) matter.obj.customerId=-1;	
		 }else if(initMatterButton==false){
		 	matter.obj.customerId=customerId;
		 }
     }


	if(stopAuto && ($("matter.name").value).trim() ==""){
		extjMessage('请输入广告长度!');return false;
	}else{
		
			if($("matter.name").value!="" ){
				matter.obj.name=$("matter.name").value;
				matter.getMattersByCustomerIdAndLength(matter.obj,mattersAutoComplete);
			}else{
				matter.getMatterAutoCompletDIV(mattersAutoComplete2,matter.obj);
			}         

	}
}


function getMatterAutoCompletTapeCode(){
	
	var customerName =  Ext.fly('customerName').dom.value; 
	var customerId =  Ext.getCmp('customerName').getValue();
	customerId = customerId > 0?customerId:"";
	var matterLength = $("matterLength");
	var stopAuto=false;
	matter.reset();
	if(matterLength.disabled){
		 if(matterLength.value!=""){
		 	matter.obj.length = matterLength.value*1;
		}
	}else{
	   	if(initMatterButton==false && customerId!=""){
		    if(matterLength.value == 0){
		    	matter.obj.length = null;
		    }else{
		    	matter.obj.length = matterLength.value*1;
		    } 	 
		}else if(initMatterButton==true && customerId!=""){
		    if(matterLength.value == 0){
		    	matter.obj.length = null;
		    	stopAuto = true;
		    }else{
		    	matter.obj.length = matterLength.value*1;
		    }    			
		}
	}
	
	 if(customerId=="" ){
			matter.obj.customerId=-1;
	 }else if(initMatterButton==false){
	 	matter.obj.customerId=customerId;
	 }

	if(stopAuto && ($("matter.name").value).trim() ==""){
		 extjMessage('请输入广告长度！');return false;
	}else{
		matter.obj.orgId = orgId;
		matter.getMattersByCustomerIdAndLength(matter.obj,mattersAutoCompleteTapeCode);
	}
}

function getContractsAutoComplete(){
	var customerId = $("customerId").value;
	customerId = customerId ==''||customerId =='0'?customerId=null:customerId;
	contract.reset();
//	contract.obj.state = 3;
	contract.obj.customerId = customerId;
	contract.obj.version = order_year;
	contract.getContractPaymentAutoComplet(contract,contractAutoComplete);
}
function getContractPayMentsAutoComplete(){
	
	var customerId = $("customerId").value;
	customerId = customerId ==''||customerId =='0'?customerId=null:customerId;
	payMent.reset();
//	payMent.obj.state = 3;
	payMent.obj.customerId = customerId;
	payMent.obj.version = order_year;
	payMent.obj.contractSorts = "0,2";
	payMent.getContractPaymentAutoComplet(payMent,contractCodeAutoComplete);
}

function contractAutoComplete(objs){
	var oText = $("contract.code");
	var oDiv = $("theDiv");
	var hidenColumName = ["id","customerId","customerCategoryId","moneySum","contractSort"];
//	var indexColumName = [];
	var indexColumName = ["code","startDate","endDate","id"];
	var allColumsName =["id","code","startDate","endDate","customerId","customerName","customerCategoryId","moneySum","contractSort"];
	var allColumsTitle = ["合同编号","开始日期","结束日期","客户名称"];

	var onDivMouseDown = function(ev){
		var tr = getElementByEvent(ev);
		$("order.contractId").value = getCellValue(tr,0);
		$("customerId").value = getCellValue(tr,4);
		$("customerCategoryId").value = getCellValue(tr,6);
		
		var id = getCellValue(tr,4);
		var customerName = getCellValue(tr,5);
		var customerCategoryId = getCellValue(tr,6);
        inti_set_customer(customer.customerCommand,1,id,customerName,customerCategoryId);		
		$("contractPayment.contractMoneySum").value = getCellValue(tr,7);
		oText.value = getCellValue(tr,2);
		lockOrderMainCategory(getCellValue(tr,8));
		$("orderPublic.moneyRealpay").disabled = true;
	}
	
	var onTextBlur = function(ev){
		oDiv.style.visibility = "hidden";
		
		if(trim(oText.value) == "" ){
			$("paymentId").value = "";
			$("order.contractId").value = "";	
			$("contractPayment.payDate").value = "";
		    $("contractPayment.moneyPay").value = 0;
		    Ext.fly('customerName').dom.value= "";
		    $("customerId").value = 0;
		    $("customerCategoryId").value = 0;
		    $("contractPayment.contractMoneySum").value = 0;
		    lockOrderMainCategory(-1);	
		    $("orderPublic.moneyRealpay").disabled = false;
		    $("orderPublic.moneyIn").value = 0;
		}else{
			//检测合同编号是否存在
			var paymentId =$("paymentId").value;
			if(paymentId == ''){
				 extjMessage('请选择合同号的下拉列表！');return false;
			}
		}
		getContarctAuto();
	}
   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown,onTextBlur,hidenColumName,indexColumName,allColumsName,allColumsTitle);
}


function contractCodeAutoComplete(objs)
{
	var oText = $("contract.code");
	var oDiv = $("theDiv");
	var hidenColumName = ["id","contractId","customerId","customerCategoryId","contractMoneySum","contractSort"];
	var indexColumName = ["contractCode","payDate","id","customerId","contractSort"];
	var allColumsName =["id","contractId","contractCode","payDate","moneyPay","customerId","customerName","customerCategoryId","contractMoneySum","contractSort"];
	var allColumsTitle = ["合同编号","付款日期","付款金额","客户名称"];
	var onDivMouseDown = function(ev){
		var tr = getElementByEvent(ev);
		$("paymentId").value = getCellValue(tr,0);
		$("order.contractId").value = getCellValue(tr,1);
		$("contractPayment.payDate").value = getCellValue(tr,3);
		$("contractPayment.moneyPay").value = getCellValue(tr,4);
		$("customerId").value = getCellValue(tr,5);
		$("customerCategoryId").value = getCellValue(tr,7);
		var id = getCellValue(tr,5);
		var customerName = getCellValue(tr,6);
		var customerCategoryId = getCellValue(tr,7);
        inti_set_customer(customer.customerCommand,1,id,customerName,customerCategoryId);		
		$("contractPayment.contractMoneySum").value = getCellValue(tr,8);
		oText.value = getCellValue(tr,2);
        lockOrderMainCategory(getCellValue(tr,9));
		$("orderPublic.moneyRealpay").disabled = true;
	}
	
	var onTextBlur = function(ev){
		oDiv.style.visibility = "hidden";
		if(trim(oText.value) == "" ){
			$("paymentId").value = "";
			$("order.contractId").value = "";	
			$("contractPayment.payDate").value = "";
		    $("contractPayment.moneyPay").value = 0;
		    Ext.getCmp('customerName').setValue('');
		    Ext.getCmp('customerName').disabled = false;
		    $("customerId").value = 0;
		    $("customerCategoryId").value = 0;
		    $("contractPayment.contractMoneySum").value = 0;
		    lockOrderMainCategory(-1);	
		    $("orderPublic.moneyRealpay").disabled = false;
		    $("orderPublic.moneyIn").value = 0;
		}else{
			//检测合同编号是否存在
//			var paymentId =$("paymentId").value;
//			if(paymentId == ''){
//				extjMessage('系统意外出错,请选择合同号的下拉列表!');return false;
//			}
		}
		
		getContarctAuto();
	}

   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown,onTextBlur,hidenColumName,indexColumName,allColumsName,allColumsTitle);
}

function lockOrderMainCategory(contractSort){
	var contractId = $("order.contractId");
	var categoryId = $("categoryId");
	var customerId = Ext.fly('customerName').dom;
	var moneyPay =$("contractPayment.moneyPay")
	var value =  0;
	if(contractId.value =="0" || contractId.value =="" || contractId.value ==null){
		value =  orderCategory.getValueFromCommand(categoryId,"正常订单");
		categoryId.removeAttribute("disabled");	
		customerId.removeAttribute("disabled");	
		$("paymentId").value = 0;
		
	}
	if((contractId.value !="0" && contractId.value !="" && contractId.value !=null) && contractSort == 0){
		value =  orderCategory.getValueFromCommand(categoryId,"协约合同");
		categoryId.disabled = "true"; 
		customerId.disabled = "true";
	}
	
//	if( tvNameParam =='xmtv'){
//		if((contractId.value !="0" && contractId.value !="" && contractId.value !=null) && contractSort == 2){
//			value =  orderCategory.getValueFromCommand(categoryId,"部门订单");
//			categoryId.disabled = "true"; 
//			customerId.disabled = "true";
//		}
//	}
	
	if((contractId.value !="0" && contractId.value !="" && contractId.value !=null) && contractSort == 1){
		value =  orderCategory.getValueFromCommand(categoryId,"协议合同");
		categoryId.disabled = "true";
		customerId.disabled = "true"; 
	}
	categoryId.value = value; 
}

function mattersAutoCompleteTapeCode(objs){   
	var oText_tapeCode = $("matter.tapeCode");
	var oDiv_tapeCode = $("theDivTapeCode");
	var indexColumName_tapeCode = ["tapeCode","id"];
	var allColumsName_tapeCode =["id","tapeCode","name","edit","length","matterType","industryType","industry.name","brandId2"];
	var allColumsTitle_tapeCode = ["磁带号","广告名称","广告版本","长度"];
	var onDivMouseDown_tapeCode = function(ev){
		var tr = getElementByEvent(ev);
		$("dt_matter.id").value = getCellValue(tr,0);
		$("matter.tapeCode").value = getCellValue(tr,1);
		$("matter.name").value = decode_string_xml(getCellValue(tr,2));
		$("matter.edit").value = decode_string_xml(getCellValue(tr,3));
		
		var isChanged = mattersAutoCompleteChange($("matterLength").value,getCellValue(tr,4));
		$("matterLength").value = getCellValue(tr,4);	
		$("matterType").value = getCellValue(tr,5);
		var industryName =  getCellValue(tr,7);
 		industry.treecombo.passField.value =  getCellValue(tr,6);
   		industry.treecombo.setValue(industryName);	
   		
   		var brandId2 =  getCellValue(tr,8);
   	    Ext.getCmp('search_brand').setValue(brandId2);
   	 
		if(isChanged) copyBroTimesToCurBroArrange();
		oText_tapeCode.value = getCellValue(tr,1);
	}
	var hidenColumName = ["id","matterType","industryType","industry.name","brandId2"];
	var onTextBlur = function(ev){
		oDiv_tapeCode.style.visibility = "hidden";
		if(trim(oText_tapeCode.value) == "" )$("matter.tapeCode").value = "";
	}
   new AutoComplete(objs,oText_tapeCode,oDiv_tapeCode,-1,onDivMouseDown_tapeCode,onTextBlur,hidenColumName,indexColumName_tapeCode,allColumsName_tapeCode,allColumsTitle_tapeCode);
}

function mattersAutoComplete(objs){   
	var oText_tapeCode = $("matter.tapeCode");
	var oDiv_tapeCode = $("theDivTapeCode");
	var indexColumName_tapeCode = ["tapeCode","id"];
	var allColumsName_tapeCode =["id","tapeCode","name","edit","length","matterType","industryType","industry.name","brandId2"];
	var allColumsTitle_tapeCode = ["磁带号","广告名称","广告版本","长度"];
	var onDivMouseDown_tapeCode = function(ev){
		var tr = getElementByEvent(ev);
		$("dt_matter.id").value = getCellValue(tr,0);
		$("matter.tapeCode").value = getCellValue(tr,1);
		$("matter.name").value = getCellValue(tr,2);
		$("matter.edit").value = getCellValue(tr,3);
		var isChanged = mattersAutoCompleteChange($("matterLength").value,getCellValue(tr,4));
		$("matterLength").value = getCellValue(tr,4);	
		$("matterType").value = getCellValue(tr,5);
		var industryName =  getCellValue(tr,7);
 		industry.treecombo.passField.value =  getCellValue(tr,6); 
   		industry.treecombo.setValue(industryName);	
   		
   		var brandId2 =  getCellValue(tr,8);
   	    Ext.getCmp('search_brand').setValue(brandId2);
   	    
		if(isChanged) copyBroTimesToCurBroArrange();
		oText_tapeCode.value = getCellValue(tr,1);
	}
	
	var oText_name = $("matter.name");
	var oDiv_name = $("theDivMatterName");
	var indexColumName_name = ["name","id"];
	var allColumsName_name =["id","name","edit","length","tapeCode","matterType","industryType","industry.name","brandId2"];
	var allColumsTitle_name = ["广告名称","广告版本","长度","磁带号"];
	var onDivMouseDown_name = function(ev){
		var tr = getElementByEvent(ev);
		$("dt_matter.id").value = getCellValue(tr,0);
		$("matter.name").value = getCellValue(tr,1);
		$("matter.edit").value = getCellValue(tr,2);
		var isChanged = mattersAutoCompleteChange($("matterLength").value,getCellValue(tr,3));
		$("matterLength").value = getCellValue(tr,3);
		if(isChanged) copyBroTimesToCurBroArrange();
		$("matter.tapeCode").value = getCellValue(tr,4);
		$("matterType").value = getCellValue(tr,5);
		var industryName =  getCellValue(tr,7);
 		industry.treecombo.passField.value =  getCellValue(tr,6);
   		industry.treecombo.setValue(industryName);	
   		
   		var brandId2 =  getCellValue(tr,8);
   	    Ext.getCmp('search_brand').setValue(brandId2);
   	    
		oText_name.value = getCellValue(tr,1);
	}	
	
	var oText_edit = $("matter.edit");
	var oDiv_edit = $("theDivMatterEdit");
	var indexColumName_edit = ["edit","id"];
	var allColumsName_edit =["id","edit","name","length","tapeCode","matterType","industryType","industry.name","brandId2"];
	var allColumsTitle_edit = ["广告版本","广告名称","长度","磁带号"];
	var onDivMouseDown_edit = function(ev){
		var tr = getElementByEvent(ev);
		var edit =  decode_string_xml(getCellValue(tr,1));
		var adName = decode_string_xml(getCellValue(tr,2));
	
		$("dt_matter.id").value = getCellValue(tr,0);
		$("matter.edit").value = edit;
		$("matter.name").value = adName;

		var isChanged = mattersAutoCompleteChange($("matterLength").value,getCellValue(tr,3));
		$("matterLength").value = getCellValue(tr,3);
		if(isChanged) copyBroTimesToCurBroArrange();
		$("matter.tapeCode").value = getCellValue(tr,4);
		$("matterType").value = getCellValue(tr,5);
		var industryName =  getCellValue(tr,7);
 		industry.treecombo.passField.value =  getCellValue(tr,6);
   		industry.treecombo.setValue(industryName);		
   		
   		var brandId2 =  getCellValue(tr,8);
   	    Ext.getCmp('search_brand').setValue(brandId2);
   	    
		oText_edit.value = edit;
	}		
	

	var hidenColumName = ["id","matterType","industryType","industry.name","brandId2"];
	var onTextBlur = function(ev){
		oDiv_tapeCode.style.visibility = "hidden";
		oDiv_name.style.visibility = "hidden";
		oDiv_edit.style.visibility = "hidden";

		if(trim(oText_tapeCode.value) == "" )$("matter.tapeCode").value = "";
		if(trim(oText_name.value) == "" )$("matter.name").value = "";
		if(trim(oText_edit.value) == "" )$("matter.edit").value = "";
		if(trim(oText_name.value) == "" && trim(oText_edit.value) == ""){
			$("dt_matter.id").value = "";
			copyBroTimesToCurBroArrange();	
		}		
	}
      
   new AutoComplete(objs,oText_tapeCode,oDiv_tapeCode,-1,onDivMouseDown_tapeCode,onTextBlur,hidenColumName,indexColumName_tapeCode,allColumsName_tapeCode,allColumsTitle_tapeCode);
   new AutoComplete(objs,oText_edit,oDiv_edit,-1,onDivMouseDown_edit,onTextBlur,hidenColumName,indexColumName_edit,allColumsName_edit,allColumsTitle_edit);
}

function mattersAutoComplete2(objs){
	var oText_name = $("matter.name");
	var oDiv_name = $("theDivMatterName");
	var indexColumName_name = ["name"];
	var allColumsName_name =["id","name"];
	var allColumsTitle_name = ["广告名称"];
	var onDivMouseDown_name = function(ev){
		var tr = getElementByEvent(ev);
		var adName = decode_string_xml(getCellValue(tr,1));
		$("matter.name").value = adName;
		oText_name.value = adName;
		$("matter.edit").value = "";
	}
	var hidenColumName = ["id"];
	var onTextBlur = function(ev){
		oDiv_name.style.visibility = "hidden";
		if(trim(oText_name.value) == ""){
			$("matter.name").value = "";
			$("matter.edit").value = "";
		}	
	}
   new AutoComplete(objs,oText_name,oDiv_name,-1,onDivMouseDown_name,onTextBlur,hidenColumName,indexColumName_name,allColumsName_name,allColumsTitle_name);


}





function mattersAutoComplete3(objs){
	var oText_name = $("matter.name");
	var oDiv_name = $("theDivMatterName");
	var indexColumName_name = ["name"];
	var allColumsName_name =["id","name"];
	var allColumsTitle_name = ["广告名称"];
	var onDivMouseDown_name = function(ev){
		var tr = getElementByEvent(ev);
		$("matter.name").value = getCellValue(tr,1);
		oText_name.value = getCellValue(tr,1);
		$("matter.edit").value = "";
	}
	var hidenColumName = ["id"];
	var onTextBlur = function(ev){
		oDiv_name.style.visibility = "hidden";
		
		if(trim(oText_name.value) == ""){
			$("matter.name").value = "";
			$("matter.edit").value = "";
		}	
	}
   new AutoComplete(objs,oText_name,oDiv_name,-1,onDivMouseDown_name,onTextBlur,hidenColumName,indexColumName_name,allColumsName_name,allColumsTitle_name);
   
   
   
	var oText_tapeCode = $("matter.tapeCode");
	var oDiv_tapeCode = $("theDivTapeCode");
	var indexColumName_tapeCode = ["tapeCode","id"];
	var allColumsName_tapeCode =["id","tapeCode","name","edit","length","matterType","industryType","industry.name","brandId2"];
	var allColumsTitle_tapeCode = ["磁带号","广告名称","广告版本","长度"];
	var onDivMouseDown_tapeCode = function(ev){
		var tr = getElementByEvent(ev);
		$("dt_matter.id").value = getCellValue(tr,0);
		$("matter.tapeCode").value = getCellValue(tr,1);
		$("matter.name").value = getCellValue(tr,2);
		$("matter.edit").value = getCellValue(tr,3);
		var isChanged = mattersAutoCompleteChange($("matterLength").value,getCellValue(tr,4));
		$("matterLength").value = getCellValue(tr,4);	
		$("matterType").value = getCellValue(tr,5);
		var industryName =  getCellValue(tr,7);
 		industry.treecombo.passField.value =  getCellValue(tr,6); 
   		industry.treecombo.setValue(industryName);	
   		
   		var brandId2 =  getCellValue(tr,8);
   	    Ext.getCmp('search_brand').setValue(brandId2);
   	    
		if(isChanged) copyBroTimesToCurBroArrange();
		oText_tapeCode.value = getCellValue(tr,1);
	}   
   
	var oText_edit = $("matter.edit");
	var oDiv_edit = $("theDivMatterEdit");
	var indexColumName_edit = ["edit","id"];
	var allColumsName_edit =["id","edit","name","length","tapeCode","matterType","industryType","industry.name","brandId2"];
	var allColumsTitle_edit = ["广告版本","广告名称","长度","磁带号"];
	var onDivMouseDown_edit = function(ev){
		var tr = getElementByEvent(ev);
		$("dt_matter.id").value = getCellValue(tr,0);
		$("matter.edit").value = getCellValue(tr,1);
		$("matter.name").value = getCellValue(tr,2);
		var isChanged = mattersAutoCompleteChange($("matterLength").value,getCellValue(tr,3));
		$("matterLength").value = getCellValue(tr,3);
		if(isChanged) copyBroTimesToCurBroArrange();
		$("matter.tapeCode").value = getCellValue(tr,4);
		$("matterType").value = getCellValue(tr,5);
		var industryName =  getCellValue(tr,7);
 		industry.treecombo.passField.value =  getCellValue(tr,6);
   		industry.treecombo.setValue(industryName);		
   		
   		var brandId2 =  getCellValue(tr,8);
   	    Ext.getCmp('search_brand').setValue(brandId2);
   	    
		oText_edit.value = getCellValue(tr,1);
	}		
	

      
   new AutoComplete(objs,oText_tapeCode,oDiv_tapeCode,-1,onDivMouseDown_tapeCode,onTextBlur,hidenColumName,indexColumName_tapeCode,allColumsName_tapeCode,allColumsTitle_tapeCode);
   new AutoComplete(objs,oText_edit,oDiv_edit,-1,onDivMouseDown_edit,onTextBlur,hidenColumName,indexColumName_edit,allColumsName_edit,allColumsTitle_edit);   
   

}



function mattersAutoCompleteChange(oldValue,newValue){
	if(oldValue!=newValue)return true;
}

function getCustomerAutoCompltByName(){

	  var customerName = "";
		var categoryId = 0;
        var mode = 'remote';
        customer.obj.orgId = orgId;
    	customer.storeCustomer = customer.getStoreCustomersAnalyze(mode,customer.obj);   
	   if(!customer.customerCommand){
//	   //模板
        var tpl2= customer.getCustomerCmdTemple1();

		customer.customerCommand = new Ext.form.ClearableComboBox({
		 	  id:'customerName',
		 	  name:'customerName',
		 	  applyTo: 'extCustomerDiv',
//			  renderTo:'extCustomerDiv',
//			  tiggerAction:'all',
			  listWidth:300,
			  store:customer.storeCustomer,
			  editable: true,
//			  triggerAction: 'all', //query all
			  lastQuery:'-1',
			  displayField:'customerName',
			  valueField:'id',
			  mode:mode,
			   width:144,
//			   forceSelection:false, 
			  allowBlank:false, 
//			  selectOnFocus:true,
//			   forceAll:true,
//			   typeAhead :true,
			  emptyText:'请选择...',
			  minChars:2,
			  hiddenName:'customerCategoryId', //提交传过去的值 
			  filterFiled:'customerName',
			  filterFiled2:'helpCode',
			  params:customer.obj,
			  tpl:tpl2,
			  listeners:{
			  	beforequery:customer.comboFilterBy2.createDelegate(this)}
			  	
		 });

	   }

		function callBack_bak(cbo,e){
		  	    var id = cbo.value;
	            var rec = cbo.store.getById(id)
			    $("customerId").value = id;
				$("customerCategoryId").value = rec.get('customerCategoryId');
	    }

	    function callBack(cbo,e){
	    	       var rec = cbo.store.getById(cbo.value)
	    }
}

function inti_set_customer(cmd,i,id,customerName,customerCategoryId){
//	alert('6071>>>>inti_set_customer>>customerCategoryId>>>'+customerCategoryId)
	if(cmd == null) cmd = customer.customerCommand;
	var rc1 = Ext.data.Record.create(customer.fileds);
    var rc = new rc1({
           id : id,
           customerCategoryId : customerCategoryId,
           customerName:customerName
     });

   if(i == 1){
   	   if(!cmd) initCustomerCmd();
       cmd.clearValue(); 
   	   cmd.store.add(rc);
   	   cmd.setValue(id);  
   }else{
   	   cmd.clearValue(); 
   	   cmd.store.add(rc);
   	   cmd.setValue(id);  
   }
	$("customerId").value = id;
	$("customerCategoryId").value = customerCategoryId;
}


function int_set_user(id,fullName){
   var cmd = Ext.getCmp("userId");
   if(!cmd.store.getById(id)){
		var rc1 = Ext.data.Record.create(user.fileds);
	    var rc = new rc1({
	           id : id,
	           fullName:fullName
	     });
//	   	 cmd.clearValue(); 
	   	 cmd.store.add(rc);
	   	 cmd.setValue(id);  
   }else{
   	 cmd.setValue(id);  
   }
}


function getLowestRateAndAgentRate(){
	var func = function(o){
		if(o == null){
			$("lowestRate").value = 0;
			$("ageRate").value = 0;
		}else{
			$("lowestRate").value = ForDight(o.lowestRate*100,0);
			$("ageRate").value = ForDight(o.agentRate*100,0);
		}
	}
	var contractId = $("order.contractId").value;
	var resourceSortId = $("resourceSortId").value;
	var customerCategoryId = $("customerCategoryId").value;
	var carrierId = $("carrierId").value;
	agentInfo.reset();	
	agentInfo.obj.contractId = contractId;
	agentInfo.obj.resourceSortId = resourceSortId ;
	agentInfo.obj.customerCategoryId = customerCategoryId ;
	agentInfo.obj.carrierId = carrierId;
	if(contractId>0 && resourceSortId>0 && customerCategoryId>0 && carrierId>0){
		agentInfo.getAgentInfoByObj(func,agentInfo.obj);
	}else{
		$("lowestRate").value = 0;
		$("ageRate").value = 0;
	}
}

function disabledDestop(){
	var orderId = order.obj.id;
	if(orderId == '' || orderId == 0|| orderId == null){
		$("Btn_display").hide();
		$("Btn_orderDetail").hide();
	}else{
		$("Btn_display").show();
		$("Btn_orderDetail").show();
	}	
}

function colesResource(){
	var oDiv = $("carrierTypeTreebox");
	oDiv.style.visibility = "hidden";
}

//装载资源
function autoPrice(){
	var isAutoPrice = $("compages.isAutoPrice").checked;
	if(isAutoPrice == true){
		$("relPrice").disabled = true;
	}else{
		$("relPrice").disabled = false;
	}
}

function getCompagesDetailPage(compagesId,orderDetailId){
	autoBroArrangeCompageDetail(order.obj.id,orderDetailId,compagesId);
}

function autoBroArrangeCompageDetail(orderId,orderDetailId,compagesId){
	popupcenter.url = "editOrder.html?id="+orderId+"&"+orderDetailId+"#"+compagesId+"%";
	popupcenter.model = 10;
	popupcenter.popupcenter(popupcenter);
}

function checkRelpay(orderId){
	var orderRelpay = $("orderPublic.moneyRealpay").value;
	var func = function(sumMoneyPay){
		if(sumMoneyPay != 0 && orderRelpay > sumMoneyPay){
			displayPayment();
			var monBlance = orderRelpay - sumMoneyPay;
		}
	}
	payMent.getMoneyPayByOrderId(orderId,func);
}
function printReport(mode){
//	 var s=['view','print','excel'];
	 
	if(mode =="view"){
		button_view_order();
	}
	if(mode =="print"){
		button_print_order();
	}
	if(mode =="excel"){
		button_print_export();
	}
	if(mode =="copy"){
		button_print_copy(1);
	}	
	if(mode =="copy2"){
		button_print_copy(2);
	}	
	
	if(mode =="copy3"){
		button_print_copy(3);
	}	
	

	if(order.obj.id >0){
		var checkeds=[order.obj.id];
		var changeState = 1;
		var defMsg ="【订单编辑上提交审核】";
		
		function callBak(){
	        if(config_allowModiyPassedOrderParam ==0)lockDestopOrderDetail(false);
		}  
		
		if(mode =="pass"){
			//document.title=order.obj.id;
		     changeState = 3;
			 var oldState = $("isCkecked").value;
			 if(oldState != 3){
				   Ext.MessageBox.confirm('系统提示', '请确认是否通过？', function(btn) {
			 			  if (btn == 'yes') {
								order.updateOrderStates2(checkeds,changeState,loginUserId,oldState,defMsg,callBak); 
								$("orderDetail_mod_states").value="通过";  
								$("isCkecked").value = changeState; 							
			              } });					 

			 }

		}
	
		if(mode =="return"){
		    changeState = 4;
			var oldState = $("isCkecked").value;
			 if(oldState != 1 && oldState != 4){
				   Ext.MessageBox.confirm('系统提示', '请确认是否退回？', function(btn) {
			 			  if (btn == 'yes') {
								order.updateOrderStates2(checkeds,changeState,loginUserId,oldState,defMsg,callBak); 
								$("orderDetail_mod_states").value="被退回";  
								$("isCkecked").value = changeState; 						
			              } });					 

			 }

		}
	}
	
	
				  	



   
	
	
	
	
	
	
	
	
	
	
	
	

	
//	if(mode =="prove"){
//		button_chose_prove();
//	}	   	
}


function button_view_order(){
	 $("model").value = "view";
	 $("copys").value = "1";
	 button_print();
}	
function button_print_order(){
	 $("model").value = "print";
	 $("copys").value = "1";
	 button_print();
}
function button_print_export(){
	 $("model").value = "export";
	 $("copys").value = "1";
	 button_print();
}




function button_print_copy(model){ 

		    Ext.MessageBox.confirm('系统提示', '请确认是否复制？', function(btn) {
 			  if (btn == 'yes') {
					var orderId = order.obj.id;
					if(orderDetailStates != 2 && orderId >0){
						function reload(orderId){
							var srcStr = window.location.href;
							var pos = srcStr.indexOf("?");
							var paramStr = srcStr.substring(pos+1);
							var paramObj =  $H(paramStr.toQueryParams());
							paramObj.set("id",orderId);
							self.location =   ctxPath + "editOrder.html?" + paramObj.toQueryString();
						}
					
						order.saveOrderClone(orderId,model,loginUserId,reload);
					}
              }	    	
		     });	
}

function button_print(){
	$("orderId").value = order.obj.id;
	var orderId = order.obj.id;
	$("printOrgid").value = orgId;
	if(orderId == null || orderId =="" || orderId=="NaN"){
		extjMessage('"没有数据，不能执行此操作!');
		return false;
	}
	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");
	reportForm.target = tarForm;
	reportForm.action="reports/jsp/order_preView.jsp";
	reportForm.submit(); 	
}

function buildRegCustomer(winW,height,customerName){
	//创建客户类别
	category.makeOptionsCallBackFun(category,fillFun);	
//	function fillFun(objs){
//			makeOptionsHtml(objs,"radio","regCustomerCategoryName","categoryName","id","","",[1]);
//			setRadioCheckedByValue($("regCustomerCategoryName_td"),2);
//	}	
	
	function fillFun(objs){
		var items = getOptionsItemsByObjs(objs,"regCustomerCategoryName","categoryName","id",[1],2);
		 new Ext.form.RadioGroup({  
	            id:'myGroupCategoryName',  
	            fieldLabel: 'Single Column',  
	            itemCls: 'x-check-group-alt',  
	            style:'margin-left:5px;align:middle;CURSOR:pointer;', 
	            renderTo:'regCustomerCategoryName',
	            columns: 3,  
	            vertical: false,
	            items: items
	    });  
	}


	regCustomerComboBox(winW,customerName);
	function onRowSelectd(id,cellInd){
		 var customerName = this.getUserData(id,"customerName");
		 var customerCategoryId = this.getUserData(id,"customerCategoryId"); 
		 inti_set_customer(customer.regcustomerCommand,2,id,customerName,customerCategoryId);
	}
    $("gridbox_regCustomer").style.height =  0 +"px";
    $("gridbox_regCustomer").style.width =  winW*0.98 +"px";
}

function loadRegCustomerGrid(customerName){
	var callBackFun = function(strXML){
		regCustomerGrid.clearAll();
		regCustomerGrid.loadXMLString(strXML);
	}
	var  paraObj = (new Customer()).obj;
	paraObj.orgId = orgId;
	paraObj.customerName = customerName;
	customer.getCustomerForReg(paraObj,callBackFun);
}

function regCustomerComboBox(winW,customerName){

        var mode = 'remote';
        customer.obj.orgId = orgId;
        if(!customer.regcustomerCommand){
        	var storeCustomer = customer.getStoreCustomersAnalyze(mode,customer.obj);    
 			customer.regcustomerCommand = new Ext.form.ComboBox({
 			  fieldLabel: '待注册客户',
 			  hideLabels:true,
		 	  id:'regCustomerName',
		 	  name:'regCustomerName',
			  renderTo:'regCustomerDiv',
			  tiggerAction:'all',
			  store:storeCustomer,
			  editable: true,
			  triggerAction: 'all', //query all
			  lastQuery:'1',
			  displayField:'customerName',
			  valueField:'id',
			  mode:mode,
			  width:winW*0.5,
//			  readOnly:true,
			  forceSelection:false, 
//			  blankText: "不能为空，请填写",
			  allowBlank:false,
			  emptyText:'请选择...',
			  minChars:2,
			  hiddenName:'helpCode', //提交传过去的值 
			  filterFiled:'customerName',
			  params:customer.obj,
//			  valueNotFoundText:"新客户",
			  listeners:{
			  beforequery:customer.comboFilterBy2.createDelegate(this)}
			  	
			 });       	
        }

		 
		 customer.regcustomerCommand.setValue(customerName);  
		 
		function callBack(cbo,e){
		  	    var id = cbo.value;
	            var rec = cbo.store.getById(id)
	    }
}


function inti_set_orderSubCate(id,name,calculateAuto){
	
//	alert('inti_set_orderSubCate 11 >>'+calculateAuto)

  
	
    if(!orderCategory1.orderCateoryCommand){
    	initOrderCategory1Cmd();
    }
    if(!orderCategory1.orderCategoryCommand.store.getById(id)){
	 	var rc1 = Ext.data.Record.create(orderCategory.fileds);
	    var rc = new rc1({
	           id : id,
	           name : name,
	           calculateAuto : calculateAuto
	     });
   	   orderCategory1.orderCategoryCommand.store.add(rc);
   	   orderCategory1.orderCategoryCommand.store.reload();
   	   orderCategory1.orderCategoryCommand.setValue(id);  	
   	   orderCategory1.calculateAuto = calculateAuto;
    }else{
    	  orderCategory1.orderCategoryCommand.setValue(id);  	
    }
    
    orderCategory1.calculateAuto = calculateAuto;
    
//    alert('inti_set_orderSubCate 22 >>'+orderCategory1.calculateAuto)
    
};

function inti_set_industry(o){
        var id = o.id;
        var name = o.name;
	    if(!industry.treecombo){
	    	initIndustry();
	    	industry.treecombo.setValue(name);
	    }else{
	   	   industry.treecombo.setValue(name);
	   	   industry.treecombo.passField.value = id; 	
	    }
};

//级联事件
function onOrderSubCategoryChange(){
	    var categoryMainName = "categoryId";
	    var categoryMainId = $(categoryMainName).value;
	    
	    if(categoryMainId > 0){
	    	var catMain = DWRUtil.getText(categoryMainName);
	    	
					if(catMain.indexOf("正常订单") > -1 || catMain.indexOf("协约订单") > -1 ||  catMain.indexOf("固定金额") > -1){
								  $("order.contractId").value ='';
								  $("contract.code").value ='';
								  $("paymentId").value ='';	  
						}
						
						if(catMain.indexOf("协约合同") > -1 || catMain.indexOf("部门订单") > -1){
							   
								if(order.obj.id > 0) {
									var cnt = order.obj.contract;
									var contractId = order.obj.contractId;
								
									if(cnt && contractId > 0){
										var contractSort = cnt.contractSort;
										var cont_sort = catMain.indexOf("协约合同") > -1?0:2;
										if(contractSort == cont_sort){
											$("order.contractId").value = order.obj.contractId;
										    $("contract.code").value = setContractCode(order.obj);	
										    $("paymentId").value = order.obj.paymentId;	  
										}else{
											  $("order.contractId").value ='';
											  $("contract.code").value ='';
											  $("paymentId").value ='';	  
										}
									}
			
								}
						}		
						
		}
};


function checkOrderSubCate(a){
	var name =  Ext.fly('orderCategoryId').dom.value; 
	var id =  Ext.getCmp('orderCategoryId').getValue();	
	 function callBakFun(id){
		inti_set_orderSubCate(id,name,1);
		orderCategory1.calculateAuto = 1;	
		if(a == 1) save_Order();  
	}	

	if(id == name && id !=''){
		    
//		    var btn = confirm("订单子类别不存在，是否注册");

		    Ext.MessageBox.confirm('系统提示', '订单子类别不存在，是否新注册？', function(btn) {
 			  if (btn == 'yes') {
				var cut = (new OrderCategory()).obj;
				cut.id = null;
				cut.orgId = orgId;
				cut.version = $("order_year").value;
				cut.name = name.Trim();
				cut.calculateAuto = 1;
				cut.parentId = $("categoryId").value;
				cut.value = '';
				cut.nodeLevel = 0;
				cut.nodePath = '';
		        orderCategory1.saveCategory2(cut,callBakFun);
              }	    	
		     });
		     
		  return true; 
	}else{
		 return false; 
	}
//	alert("checkOrderSubCate 1 显示值="+industry.treecombo.getRawValue()+"   真实值="+industry.treecombo.passField.getValue());
};

function initIndustry(){
			 var id ="industryTree"
	     	 industry.obj.parentId = 0;
	     	 var params = [{}]; //tree dataIn。;
	     	 var tree = industry.getTree(id,params,false);
	     	 
	     	if(!industry.treecombo){
				industry.treecombo = new ComboBoxTree({
					        id:"industryCmd",
					         fieldLabel : '',
					         renderTo : 'initIndustryComboBoxTree',
			               width : 144,
			               passName : 'typeId',
			               autoScroll:true,
			               allowUnLeafClick : false,
			               treeHeight:300,
			               tree :tree,
			               allowBlank : false        
				});
	     	}
	     	
	     	function onTreeSelected(node){
               	var name  ='';
               	if(config_industryLevelParam == '1'){
               		    var parentNode = node.parentNode;
               		    name = parentNode.text + '/' +node.text;
               	}else{
               		 name = node.text;  	
               	}
                industry.treecombo.passField.value = node.id;
                industry.treecombo.setValue(name);  	
	     	
	     	}

           industry.treecombo.on('treeselected',onTreeSelected,industry.treecombo);  
}



function initCustomerCmd(){
	 customer.get_custumer_for_order('remote',144,300,orgId,'customerName','extCustomerDiv','请选择...');
}


//function initCustomerCmd_bak(){
//
//    	var customerName = "";
//		var categoryId = 0;
//        var mode = 'remote';
//        customer.obj.orgId = orgId;
//    	customer.storeCustomer = customer.getStoreCustomersAnalyze(mode,customer.obj);   
//	   if(!customer.customerCommand){
////	   //模板
//        var tpl2= customer.getCustomerCmdTemple1();
//        
//        get_custumer_for_order('remote',width,orgId,customerName,extCustomerDiv)
//  
//
//		customer.customerCommand = new Ext.form.ClearableComboBox({
//		 	  id:id,
//		 	  name:id,
//			  renderTo:renderId,
//			  tiggerAction:'all',
//			  listWidth:listWidth,
//			  store:customer.storeCustomer,
//			  editable: true,
//			  triggerAction: 'all', //query all
//			  lastQuery:'1',
//			  displayField:'customerName',
//			  valueField:'id',
//			  mode:mode,
//			   width:width,
////			   typeAhead: true,
////			   forceSelection:false, 
//			  allowBlank:false,
//			  lazyRender: false,
//			  forceAll: true,
//			  emptyText:'请选择...',
//			  minChars:2,
//			  hiddenName:'customerCategoryId', //提交传过去的值 
//			  filterFiled:'customerName',
//			  filterFiled2:'helpCode',
//			  params:customer.obj,
//			  tpl:tpl2,
//			  listeners:{
//			  	beforequery:customer.comboFilterBy2.createDelegate(this)}
//		 });
//	   }
//};

function reloadOrderCategory1Store(){
		var catMain = DWRUtil.getText("categoryId");
  	if(catMain.indexOf('协议')>-1) config_contractsort =1;
	
	
        if (!orderCategory1.orderCategoryCommand){
        	initOrderCategory1Cmd();
        }
		var cmd2 =  orderCategory1.orderCategoryCommand;
		var store2 = cmd2.getStore();	
		store2.baseParams.dwrParams[0].orgId = orgId;
		store2.baseParams.dwrParams[0].version = $("order_year").value;
		store2.baseParams.dwrParams[0].parentId = $("categoryId").value; 
		store2.reload();	
//		cmd2.clearValue(); 
// 	
		function callBack_bak(cmd){
//					if(order.obj.id > 0 && order.obj.categoryId == $("categoryId").value){
//						 orderCategory1.orderCategoryCommand.setValue(orderDetail.obj.orderCategoryId);  	
//                          alert(order.obj.categoryId)
//						 inti_set_orderSubCate(orderDetail.obj.orderCategoryId,orderDetail.obj.orderCategory.name,orderDetail.obj.orderCategory.calculateAuto);
//					}else{
					     getValueFromStoreByText(orderCategory1.orderCategoryCommand,"正常");
//					}		
		};
		orderCategory1.storeOrderCategory.on("load",callBack_bak,this);	
		if(orderDetailBackUp.id == null && $("resourceInfoId").value >0 ) {
			onResourceChange();
		}
}


function initOrderCategory1Cmd(){

	       if (!orderCategory1.orderCategoryCommand){
		        var mode = 'remote';
				orderCategory1.obj.parentId = $("categoryId").value;
			    orderCategory1.obj.orgId = orgId;
				orderCategory1.obj.version = $("order_year").value;
	//            orderCategory1.storeOrderCategory =  new Ext.data.Store();
//	             alert($("categoryId").value)
	             orderCategory1.storeOrderCategory = orderCategory1.getStore(mode,orderCategory1.obj);   	       	

				  orderCategory1.orderCategoryCommand = new Ext.form.ComboBox({
			 	  id:'orderCategoryId',
			 	  name:'orderCategoryId',
				  renderTo:'extorderCategoryIdDiv',
				  tiggerAction:'all',
				  store:  orderCategory1.storeOrderCategory,
				  editable: true,
				  triggerAction: 'all', //query all
				  lastQuery:'1',
				  displayField:'name',
				  valueField:'id',
				  mode:mode,
				  cls:'CURSOR: pointer;',
		//		  readOnly:true,
				   width:55,
				   listWidth: 150,
		//		   typeAhead: true,
				   forceSelection:false, 
				  allowBlank:false,
		//		  lazyRender: false,
				  emptyText:'请选择...',
				  minChars:2,
				  hiddenName:'', 
				  filterFiled:'name',
				  params:orderCategory1.obj,
				  listeners:{
//				  	beforequery:customer.comboFilterBy2.createDelegate(this)
				  	}
				  	
					 });
					 
					 
			 	orderCategory1.orderCategoryCommand.getEl().on("mousedown",function(){
			      orderCategory1.orderCategoryCommand.onTriggerClick();
			     });	
			     
			     orderCategory1.orderCategoryCommand.store.on("load",function(){
//			     	 orderCategory1.orderCategoryCommand.onTriggerClick();

						if(this.getCount()>0 && orderDetailStates == 2){
							var rec = this.getAt(0);
							var id = rec.get("id");
							var calculateAuto = rec.get("calculateAuto");
							orderCategory1.orderCategoryCommand.setValue(id);  	
//   	   						orderCategory1.calculateAuto = calculateAuto;
//   	  						 orderCategory1.orderCategoryCommand.select(0);
							
//							orderCategory1.orderCategoryCommand.setValue(id);
						}
//			       orderCategory1.orderCategoryCommand.select(0);
			     });					 
					 

			     orderCategory1.orderCategoryCommand.on("select" , function(box)
					    {
					    		orderCategory1.calculateAuto =   getValueFromStoreById(Ext.getCmp("orderCategoryId"),"calculateAuto");
					    		

					    		
					    		function callBak(){
						    		if(orderCategory1.calculateAuto == 0){
					    				$("moneyRealpay").value = 0;
					    				$("favourRate").value = 0;
					    			}
					    			setBroArrayangeMonthOnPriceChange();
					    		}
					    		
					    	    if($("resourceInfoId").value>0){
					       	    	getSysPrice(false,callBak);
					    	    }

					    });
	       }
	 
};



function getEditCom(adv_name,adv_length){
	
      var orderId = order.obj.id;
      matter.reset();
      matter.obj.orgId = orgId;
      matter.obj.name = adv_name ;
      matter.obj.length = adv_length; 
      matter.obj.orderId = orderId;

      var mode = 'remote';
      var store = matter.getStoreMatterByOrderId(mode,matter.obj);    


	  var matterCommand = new Ext.form.ComboBox({
				 id:'edit_cmd',
				 name:'edit_cmd',
		        store: store,
		        width: '100%',
		        listWidth:300,
		        valueField: 'id',
		        displayField: 'edit',
		        typeAhead: true,
		        mode: mode,
		        lastQuery:'-1',
		        forceAll:true,
		        triggerAction: 'all',
		        emptyText: '请选择要更换的版本...',
		        forceSelection: false,
		        selectOnFocus: true,
		        msgTarget: 'side',
		        allowBlank: false,
		        lazyRender: false,
		        blankText: '不能为空！',
		        minChars:2,
//		        renderTo: 'matterEditDiv',
		        filterFiled:'edit',
				params:matter.obj,
				listeners:{ beforequery:matter.comboFilterBy2.createDelegate(this)} 
		    });
		    
	   function resetCmd(cmd){
	   	 	document.getElementById('userReliframe').contentWindow.selectdSameMatter(cmd.getValue(),"matterId");
	   }
	      
		    
		    
	    matterCommand.on("select",resetCmd,this);	    
		    
		return     matterCommand;

}




function getResourceCom(orderId){
	
      resource.reset();
      resource.obj.carrierId = orderId;

      var mode = 'remote';
      var store = resource.getStoreResourceByOrderId(mode,resource.obj);    


	  var matterCommand = new Ext.form.ComboBox({
				 id:'resource_cmd',
				 name:'resource_cmd',
		        store: store,
		        width: '100%',
		        listWidth:300,
		        valueField: 'id',
		        displayField: 'resourceName',
		        typeAhead: true,
		        mode: mode,
		        lastQuery:'-1',
		        forceAll:true,
		        triggerAction: 'all',
		        emptyText: '请选择要更换的段位...',
		        forceSelection: false,
		        selectOnFocus: true,
		        msgTarget: 'side',
		        allowBlank: false,
		        lazyRender: false,
		        blankText: '不能为空！',
		        minChars:2,
//		        renderTo: 'matterEditDiv',
		        filterFiled:'resourceName',
				params:resource.obj,
				listeners:{ beforequery:resource.comboFilterBy2.createDelegate(this)} 
		    });
		    
	   function resetCmd(cmd){
	   	 	document.getElementById('userReliframe').contentWindow.selectdSameMatter(cmd.getValue(),"resourceInfoId");
	   }
	      
		    
		    
	    matterCommand.on("select",resetCmd,this);	    
		    
		return     matterCommand;	
}





function getdetailIds(grid){
	
	var detailIds = new Array();
	
	for(var i=0; i< grid.getRowsNum();i++){
		
		var isVisiable = grid.getRowByIndex(i).style.display =="";
		
		if(isVisiable){
		     detailIds.push(grid.getRowId(i));
		}
		
	}
	return detailIds;
}

function changeMatterEdit(){
	
	if(orderBackUp.id == null){
		extjMessage('"您当前处于新添状态，换版无法进行!');
		 return false;
	}

	if(orderDetailBackUp.id == null){
		    var id = mygrid.getSelectedId();
		 	if(id > 0) {
		 		 getOrderDetail(id);
		 		 extjMessage('"您当前处于新添状态，系统先要恢复原有的信息, 才能继续下一步!');
		 	}
	}	

  var rowId = mygrid.getSelectedId();
  var name = mygrid.cells(rowId,2).getValue();
  var edit = mygrid.cells(rowId,3).getValue();
  var length = mygrid.cells(rowId,4).getValue();
  var start = mygrid.getUserData(rowId,"startDate");
  var end = mygrid.getUserData(rowId,"endDate");
  var matterId = mygrid.getUserData(rowId,"matterId");
  var customerId =  Ext.getCmp('customerName').getValue();	
  var matterType = mygrid.getUserData(rowId,"matterType");
  var brandId = mygrid.getUserData(rowId,"brandId"); 
  var resourceInfoId = mygrid.getUserData(rowId,"resourceInfoId"); 
//  var orderCkeckState = $("isCkecked").value;
//  var brandId2 = mygrid.getUserData(rowId,"brandId2"); 
  var brandId2 = Ext.getCmp('search_brand').getValue();	
  
//  alert(brandId2)


  
  

  var num = mygrid.cells(rowId,8).getValue();
  var cont = rowId+","+ name+","+ edit+","+ length+","+ start+","+ end +","+ num+","+ matterId;
  var urlStr="selectPopup/selectMatterEditChange.html?mode=1&orgId="+orgId+"&order_year="+order_year +"&ctxPath="+ ctxPath +"&orderDetailId="+rowId;
  var urlStr= urlStr + "&brandId="+brandId + "&brandId2="+brandId2 +"&customerId="+customerId +"&matterType="+matterType+"&advname="+name+"&advlength="+length+"&createBy="+loginUserId;
  
  urlStr =urlStr +"&order_ckecked=" +$("isCkecked").value;
  urlStr = urlStr +"&order_state_name=" +$("orderDetail_mod_states").value;
  urlStr = urlStr +"&order_id=" +order.obj.id; 
  urlStr = urlStr +"&edit=" +edit; 
  urlStr = urlStr +"&resource_info_id=" +resourceInfoId;  
  
  urlStr = encodeURI(urlStr +"&cnt=" +cont);
  



  
  var orderId = order.obj.id;
  
      
  
  var detailIds = getdetailIds(mygrid).join(",");
  


  function getDetailTableFun(){
//  	getOrder(order.obj.id,rowId);
        mygrid.setSelectedRow(rowId);
        getOrderDetail(rowId);
      
       
  }

  var closeFun = function(s,isStop){

	    
	 
 		if(s !=""){
 			var state = s.substring(0,1);
 			if(state == 0){
 				 var msg = s.substring(1);
 				 msg="<div style='width:280px;height:300px;OVERFLOW-y:auto;OVERFLOW: scroll;'>"+ msg +"<div>";
				 Ext.MessageBox.hide(); 
				 Ext.MessageBox.show(
					{title:'指定冲突提示',msg:msg,width:380,heigth:300,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
				 ); 						 
 				 
// 				 return false;
// 				 Ext.MessageBox.alert('指定冲突信息',msg,function(){});     
 			}else{
				 var returnState = config_withoutSubmit == 1?0:4; 
				 var msg = "此订单审核状态从{"+ $("orderDetail_mod_states").value +"}=>{被退回}";
				 if(config_withoutSubmit == 1) msg = "此订单审核状态已改,需要重审,才可正常播出!";
		        		 	 $("isCkecked").value = returnState;
		        		 	 orderBackUp.isCkecked = returnState;
		        		 	 var v = config_withoutSubmit == 1?"":"被退回";
		        		 	 $("orderDetail_mod_states").value = v; 
		        		 Ext.MessageBox.alert('系统提示',msg,function(){});     
		        		 
		        		 	  var Btn_submit = $("Btn_submit");
		        		 	 if(returnState == 4){
		        		 	 	 Btn_submit.value="提交";
							 	 if(tag_order_submitbtn){
							 	  	 Btn_submit.show();
							 	 }else{
							 	 	 Btn_submit.hide();
							 	 }	
		        		 	 }else{
		        		 	 	 Btn_submit.value="通过";
								 if(tag_check_right){
									Btn_submit.show();
								 }else{
									Btn_submit.hide();
								 }
		        		 	 }
 			}
 			 
		        		 
		        		  
		}
		        	
		 getOrderDetailTable(orderDetail,getDetailTableFun);

		 if(isStop){
		 	
		  			function savePayMentFun(orderPublic){
							order.obj.orderCategory.name = DWRUtil.getText("categoryId") ;
							setOrderPublic(orderPublic);
							savePayMent(false,false);
							orderDetailStates = 0;
						}
			    	getOrderPublic(savePayMentFun);  
		 }
		 
		 
		 removeWin();

  				
  	};
  	
  var okBtn ={text: '确定',handler: function(){
  	
//  	    var rdv1 = Ext.getCmp('rb-auto1').getValue();
  	    var rdv2 = Ext.getCmp('rb-auto2').getValue();
  	    var rdv3 = Ext.getCmp('rb-auto3').getValue();
  	    var rdv4 = Ext.getCmp('rb-auto4').getValue();
  	    var rdv5 = Ext.getCmp('rb-auto5').getValue();
  	    var rdv6 = Ext.getCmp('rb-auto6').getValue();
  	    
//		if(rdv1){
//  	     	document.getElementById('userReliframe').contentWindow.save(false,closeFun);
//  	     }
		if(rdv2){
  	     	document.getElementById('userReliframe').contentWindow.save_more_paragraph(false,orderId,closeFun);
  	     }
  	 	if(rdv3){
  	     	document.getElementById('userReliframe').contentWindow.save_more_paragraph(true,orderId,closeFun);
  	     }
		if(rdv4){
			var ord = order.obj;
			getOrderValue(ord,false);
			ord.loginUser = loginUserName;
			var orderCategoryMain = getSelectParamFromAttribute($("categoryId"),"calculateauto");//根据付款分配应收
			ord.orderCategory.value = orderCategoryMain;
  	     	document.getElementById('userReliframe').contentWindow.save_stop_bro(ord,closeFun);
  	     }   
   		if(rdv5){
   			var ord = order.obj;
			getOrderValue(ord,false);
			ord.loginUser = loginUserName;
			var orderCategoryMain = getSelectParamFromAttribute($("categoryId"),"calculateauto");// 根据付款分配应收
			ord.orderCategory.value = orderCategoryMain;
  	     	document.getElementById('userReliframe').contentWindow.save_moid_spec(ord,closeFun);
  	     } 	    
  	     
  	     
    	if(rdv6){
   				var ord = order.obj;
						(ord,false);
						ord.loginUser = loginUserName;
						var orderCategoryMain = getSelectParamFromAttribute($("categoryId"),"calculateauto");//根据付款分配应收
						ord.orderCategory.value = orderCategoryMain;
  	     	document.getElementById('userReliframe').contentWindow.save_moid_price(ord,closeFun);

  	     }  	     
  	}};	
  
  var closeBtn ={text: '关闭',handler: function(){removeWin();}}; 
  
  var editCom = getEditCom(name,length);
  var resourceCom = getResourceCom(orderId);


//  editCom.hide();
  resourceCom.hide();
  
  


  
  var listener = {check : function(checkbox, checked) {
  						if (checked) {
  							
  							var i = checkbox.inputValue;
  							
  										document.getElementById('userReliframe').contentWindow.document.getElementById("matterLength_td").show();
  										document.getElementById('userReliframe').contentWindow.document.getElementById("change_time").show();
										document.getElementById('userReliframe').contentWindow.document.getElementById("change_time_end").show();	
										document.getElementById('userReliframe').contentWindow.document.getElementById("change_time_td").show();
										document.getElementById('userReliframe').contentWindow.document.getElementById("change_time_end_td").show();

    						    		document.getElementById('userReliframe').contentWindow.specCommand.hide();
    						    		document.getElementById('userReliframe').contentWindow.document.getElementById("sysPrice_td").hide();
										document.getElementById('userReliframe').contentWindow.document.getElementById("sysPrice").hide();
			   							document.getElementById('userReliframe').contentWindow.document.getElementById("execPrice_td").hide();
										document.getElementById('userReliframe').contentWindow.document.getElementById("execPrice").hide();
										document.getElementById('userReliframe').contentWindow.document.getElementById("favourRate_td").hide();
										document.getElementById('userReliframe').contentWindow.document.getElementById("favourRate").hide();
										document.getElementById('userReliframe').contentWindow.document.getElementById("appRate_td").hide();
										document.getElementById('userReliframe').contentWindow.document.getElementById("appRate").hide();  	 
	 		
  							
  							if(i == 2||i == 3||i == 4||i == 5||i == 6){
  								
                
										if(i == 2){
		  								 	resourceCom.hide();
		  								 	editCom.show();
		  								 	document.getElementById('userReliframe').contentWindow.matterCommand.show();
		  								 	document.getElementById('userReliframe').contentWindow.matterCommandImgSearch.show();
		  								 	document.getElementById('userReliframe').contentWindow.matterLengthCommand.show();
											document.getElementById('userReliframe').contentWindow.resourceCommandTree.hide();
  									 	};
  							
		  							if(i == 3){
		  								 	 editCom.hide();
		  								 	 resourceCom.show();
		  								 	 document.getElementById('userReliframe').contentWindow.matterCommand.hide();
		  								 	 document.getElementById('userReliframe').contentWindow.matterCommandImgSearch.hide();
		  								 	 document.getElementById('userReliframe').contentWindow.matterLengthCommand.show();
											 document.getElementById('userReliframe').contentWindow.resourceCommandTree.show();
		  								 };
  								 
  								 
		  							if(i == 4){
		  								 	 editCom.hide();
		  								 	 resourceCom.hide();
		  								 	 document.getElementById('userReliframe').contentWindow.matterCommand.hide();
		  								 	 document.getElementById('userReliframe').contentWindow.matterCommandImgSearch.hide();
											 document.getElementById('userReliframe').contentWindow.resourceCommandTree.hide();
											 document.getElementById('userReliframe').contentWindow.matterLengthCommand.hide();
											 document.getElementById('userReliframe').contentWindow.document.getElementById("matterLength_td").hide();
		  								 };
		  								 
		  							if(i == 5){
		  								 	 editCom.hide();
		  								 	 resourceCom.hide();
		  								 	 document.getElementById('userReliframe').contentWindow.specCommand.show();
		  								 	 document.getElementById('userReliframe').contentWindow.matterCommand.hide();
		  								 	 document.getElementById('userReliframe').contentWindow.matterCommandImgSearch.hide();
											 document.getElementById('userReliframe').contentWindow.resourceCommandTree.hide();
											 document.getElementById('userReliframe').contentWindow.matterLengthCommand.hide();
											 document.getElementById('userReliframe').contentWindow.document.getElementById("matterLength_td").hide();
		  								 };	 
		  								 
		  							if(i == 6){
		  								 	 editCom.hide();
		  								 	 resourceCom.hide();
		  								 	 document.getElementById('userReliframe').contentWindow.matterCommand.hide();
		  								 	 document.getElementById('userReliframe').contentWindow.matterCommandImgSearch.hide();
											 document.getElementById('userReliframe').contentWindow.resourceCommandTree.hide();
											 document.getElementById('userReliframe').contentWindow.matterLengthCommand.hide();
											 document.getElementById('userReliframe').contentWindow.document.getElementById("matterLength_td").hide();
											 		
											 document.getElementById('userReliframe').contentWindow.document.getElementById("change_time").hide();
											 document.getElementById('userReliframe').contentWindow.document.getElementById("change_time_end").hide();
											 		
											 document.getElementById('userReliframe').contentWindow.document.getElementById("change_time_td").hide();
											 document.getElementById('userReliframe').contentWindow.document.getElementById("change_time_end_td").hide();

//											 document.getElementById('userReliframe').contentWindow.document.getElementById("sysPrice_td").show();
//											document.getElementById('userReliframe').contentWindow.document.getElementById("sysPrice").show();
											document.getElementById('userReliframe').contentWindow.document.getElementById("execPrice_td").show();
											document.getElementById('userReliframe').contentWindow.document.getElementById("execPrice").show();
											document.getElementById('userReliframe').contentWindow.document.getElementById("favourRate_td").show();
											document.getElementById('userReliframe').contentWindow.document.getElementById("favourRate").show();
											document.getElementById('userReliframe').contentWindow.document.getElementById("appRate_td").show();
											document.getElementById('userReliframe').contentWindow.document.getElementById("appRate").show();										 		
											 		
											 		
		  								 };		 
		  								 
  								 
  								 
  								 function callBackFun(){
//  								 	unSelectdGrid1();
  									  var ds = document.getElementById('userReliframe').contentWindow.getStartEndDateFromGiid1();
  									  document.getElementById('userReliframe').contentWindow.getDate_change_time(ds[0],ds[1],2);
  								 	};
  								 document.getElementById('userReliframe').contentWindow.getOrderDetailTable(orderId,detailIds,callBackFun);
  							}else{
  								 editCom.hide();
  								 resourceCom.hide();
  								 document.getElementById('userReliframe').contentWindow.matterLengthCommand.show();
  								 document.getElementById('userReliframe').contentWindow.matterCommand.show();
  								 document.getElementById('userReliframe').contentWindow.matterCommandImgSearch.show();
								 document.getElementById('userReliframe').contentWindow.resourceCommandTree.hide();
  								 	 
  								 
  							}
  							document.getElementById('userReliframe').contentWindow.showGrid(i);
  						 } 
                     } };
  
  var radiogroup ={
            xtype: 'radiogroup',
            items: [
               // {boxLabel: '单段换版 ', id: 'rb-auto1',name: 'rb-auto',  width:100,inputValue: 1,listeners:listener},
                {boxLabel: '换 版 ', id: 'rb-auto2',name: 'rb-auto', inputValue: 2, checked: true,listeners:listener},
                {boxLabel: '换段位 ', id: 'rb-auto3',name: 'rb-auto', inputValue: 3,listeners:listener},
                {boxLabel: '停 播 ', id: 'rb-auto4',name: 'rb-auto', inputValue: 4,listeners:listener},
                {boxLabel: '换指定 ', id: 'rb-auto5',name: 'rb-auto',  width:100, inputValue: 5,listeners:listener},
                {boxLabel: '换价格 ', id: 'rb-auto6',name: 'rb-auto',  width:100, inputValue: 6,listeners:listener}
            ]
        };

 var win = new Ext.Window({
   title : '广告换版本',
	width : 800,
	height : 500,
   isTopContainer : true,
   modal : true,
   resizable : false,
    buttons: [okBtn,closeBtn],
   tbar:['-',radiogroup,'-',editCom,'-',resourceCom],
   contentEl : Ext.DomHelper.append(document.body, {
    tag : 'iframe',
     id : 'userReliframe',
    style : "border 0px none;scrollbar:true",
    src : urlStr,
    height : "100%",
    width : "100%"
   })
  })

  
   function removeWin(){
  		win.destroy();
   	} 
   win.on({'close': {fn: removeWin}});
   
   win.show(this);
   
   var orderCategoryMain = getSelectParamFromAttribute($("categoryId"),"calculateauto");//根据付款分配应收
  if(orderCategoryMain == 1){
  	 Ext.getCmp('rb-auto6').show();
  }else{
  	 Ext.getCmp('rb-auto6').hide();
  }
   
   
//     						    			document.getElementById('userReliframe').contentWindow.specCommand.hide();
//			   							document.getElementById('userReliframe').contentWindow.document.getElementById("execPrice_td").hide();
//										document.getElementById('userReliframe').contentWindow.document.getElementById("execPrice").hide();
//										document.getElementById('userReliframe').contentWindow.document.getElementById("favourRate_td").hide();
//										document.getElementById('userReliframe').contentWindow.document.getElementById("favourRate").hide();
//										document.getElementById('userReliframe').contentWindow.document.getElementById("appRate_td").hide();
//										document.getElementById('userReliframe').contentWindow.document.getElementById("appRate").hide();  	
   
   change_edit_win = win;
}



function close_search_adver_winWin(p,my_grid_matter,model){
	
    //p =1  订单中选择素材 
	if(p == 1 || p == 2){
		var rowId =(p == 1)? my_grid_matter.getSelectedId():my_grid_matter.id;
//		var customerName =  (p == 1)?my_grid_matter.cells(rowId,0).getValue():my_grid_matter.customerName;
		var name = (p == 1)?decode_string_xml(my_grid_matter.cells(rowId,1).getValue()):decode_string_xml(my_grid_matter.name);
		var edit = (p == 1)?decode_string_xml(my_grid_matter.cells(rowId,2).getValue()):decode_string_xml(my_grid_matter.edit);
		var length = (p == 1)?my_grid_matter.cells(rowId,3).getValue():my_grid_matter.length;
		var tapeCode = (p == 1)?my_grid_matter.cells(rowId,4).getValue():my_grid_matter.tapeCode;
		var industryName = (p == 1)?my_grid_matter.cells(rowId,5).getValue():my_grid_matter.industryName;
		
		var brandId =  (p == 1)?my_grid_matter.getUserData(rowId,"brandId"):my_grid_matter.brandId;
		var brandId2 =  (p == 1)?my_grid_matter.getUserData(rowId,"brandId2"):my_grid_matter.brandId2;
		var matterType =  (p == 1)?my_grid_matter.getUserData(rowId,"matterType"):my_grid_matter.matterType;
//		var customerId =  (p == 1)?my_grid_matter.getUserData(rowId,"customerId"):my_grid_matter.customerId;
//		var customerCategoryId =  (p == 1)?my_grid_matter.getUserData(rowId,"customerCategoryId"):my_grid_matter.customerCategoryId;


		if(model ==1){
			var matterOj = {id:rowId,edit:edit,length:length};
			document.getElementById('openwinMorePara_fram').contentWindow.adver_win_close_fun(matterOj);
		}else{
			$("dt_matter.id").value = rowId;
			$("matter.tapeCode").value = tapeCode;
			$("matter.name").value = name;
			$("matter.edit").value = edit;
			
			var isChanged = mattersAutoCompleteChange(length);
			$("matterLength").value =length;	
			$("matterType").value = matterType;
	
	 		industry.treecombo.passField.value =  brandId;
	   		industry.treecombo.setValue(industryName);	
	   		
	   	    Ext.getCmp('search_brand').setValue(brandId2);

	//   		if(my_grid_matter.initCustomer){
	//   			  inti_set_customer(null,1,customerId,customerName,customerCategoryId); 
	//   		}
			if(isChanged) copyBroTimesToCurBroArrange();
		}

	}
	
	search_adver_win.hide();
}  	

function search_adver_cont(model){
   var matter_fin = new Matter();
   var industry_fin = new Industry();
   var customer_fin = new Customer();
   var customerId = Ext.getCmp('customerName').getValue();	
   var customerName =  Ext.fly('customerName').dom.value; 
   var brandId2 = Ext.getCmp('search_brand').getValue();	
   var ad_length = $("matterLength").value;
   var orderCkeckState = $("isCkecked").value;
   
   if(customerId =='') customerName ='';
   

   function callFunction(params){

   	   	   document.getElementById('matteriframe').contentWindow.loadGridData(params);	     

   	      var search_brand_cmd = search_adver_win.getTopToolbar().getComponent('search_brand_cmd');
   	      search_brand_cmd.collapse();
//   		 combo.list.hide();
   	}  
   

      var urlStr= ctxPath + "selectPopup/selectMatters.html?orgId="+orgId+"&customerId="+customerId+"&version="+$("order_year").value;
      
       urlStr = urlStr + "&customerName="+customerName;
       urlStr = urlStr + "&model="+model;
       urlStr = urlStr + "&brandId2="+brandId2;
       urlStr = urlStr + "&orderCkeckState="+orderCkeckState;
       urlStr = urlStr + "&adLength="+ad_length;


//      
   
   if(!search_adver_win){


       
   	   var addNewBtn ={text: '新添素材',handler: function(){
			document.getElementById('matteriframe').contentWindow.save_new_matter();	 
		}};
		
   	   var closeBtn ={text: '关闭',handler:close_search_adver_winWin};
//   	   var closeBtn ={text: '关闭'};
//   	   if(close_fun){
//   	   		closeBtn.handler = function aa(){
//   	   			 close_fun;
//   	   		}
//   	   }else{
//   	   		closeBtn.handler = close_search_adver_winWin;
//   	   }
   	   
   	   
   	   
   	   var resetBtn ={text: '重置',handler:function(){
			document.getElementById('matteriframe').contentWindow.resetQueryWhere();	
   	   }};
   	   
   	   var copyBtn ={text: '复制素材',handler:function(){
			document.getElementById('matteriframe').contentWindow.copyQueryWhere();	

   	   }};
   	   

   	   customer_fin.obj.orgId = orgId;
   	   matter_fin.obj.orgId = orgId;
   	   
   	   
//    	var brandCmd = brand.getBrandCmd(brand.obj,null,'search_brand_cmd',null,80,'品牌...',null);
    	var brandCmd2 = brand.getCommandForSelect3(brand.obj,null,'search_brand_cmd','brandId2',110,'品牌...',callFunction);
//   	   var customerCmd = customer_fin.initCustomerCmd(matter_fin.obj,'search_adver_customer',null,'remote',null,'customerName',1,133,300,'请选择客户...',callFunction);
   	   var nameCmd = matter_fin.getCommandForSelect('search_adver_name','广告名称...','name',1,110,callFunction);
   	   var editCmd = matter_fin.getCommandForSelect('search_adver_edit','请输入广告版本...','edit',1,190,callFunction);
   	   var lengthCmd = matter_fin.getCommandForSelect('search_adver_len','长度...','length',1,70,callFunction);
   	   var tapecodeCmd = matter_fin.getCommandForSelect('search_adver_tapecode','磁带...','tapeCode',2,70,callFunction);
   	   var industryCmd = industry_fin.getIndustryCmd(matter_fin.obj,'search_adver_brandId_cmd','search_adver_brandId_tree',true,null,config_industryLevelParam,'brandId','选择行业...',100,callFunction);
	   var matterTypeCmd = matterType.getMatterTypeCmd(matter_fin.obj,null,'search_adver_matterType','matterType',70,'分类...',callFunction);
//	   matterTypeCmd.setValue(1);
	 
  
	   search_adver_win =new Ext.Window({
			title:"素材库-(广告名称、广告版本可以用汉字声母查询，选择素材时用鼠标双击)",
			modal : true,
			resizable : false,
			closeAction:'hide',
			closable: true,
			width : 800,
			height : 500, 
//			tbar:[tapecodeCmd,'-',nameCmd,'-',nameCmd,'-',editCmd,'-',lengthCmd,'-',industryCmd],
//			tbar:[customerCmd,nameCmd,editCmd,lengthCmd,tapecodeCmd,industryCmd,matterTypeCmd],
//			tbar:[nameCmd,editCmd,lengthCmd,tapecodeCmd,industryCmd,matterTypeCmd],
			tbar:[brandCmd2,nameCmd,editCmd,lengthCmd,tapecodeCmd,industryCmd,matterTypeCmd],
			buttons: [addNewBtn,'-',closeBtn], 
//			buttons: [closeBtn], 
			contentEl : Ext.DomHelper.append(document.body, {
			    tag : 'iframe',
			     id : 'matteriframe',
			    style : "border 0px none;scrollbar:true",
			    src : urlStr,
			    height : "100%",
			    width : "100%"
			   })
		});
//		 this.search_adver_win = search_adver_win;
		 search_adver_win.on({'close': {fn: close_search_adver_winWin}});
//		 if(customerName !='') Ext.getCmp('search_adver_customer').setValue(customerName); 
//		 search_adver_win.show(this);

		 
   }else{
	   var adver_len_cmd = search_adver_win.getTopToolbar().getComponent('search_adver_len');
	   var search_brand_cmd = search_adver_win.getTopToolbar().getComponent('search_brand_cmd');
	   adver_len_cmd.setRawValue(ad_length);
	   adver_len_cmd.setValue(ad_length);
	   search_brand_cmd.setValue(brandId2);
//	   alert(adver_len_cmd.superclass.un)
//	   adver_len_cmd.un("click",adver_len_cmd.onTrigger2Click);
	   
	
	
	   var params={length:ad_length,brandId2:brandId2};
	   
	   if(ad_length>0 || brandId2>0){
		   document.getElementById('matteriframe').contentWindow.loadGridData(params);
	   }else{
		   document.getElementById('matteriframe').contentWindow.mygrid.clearAll();
	   }
	 
   }
   
//   else{
////   	    if(customerName !=''){
////   	    	 Ext.getCmp('search_adver_customer').setValue(customerName); 
////   	   		 Ext.getCmp("search_adver_tapecode").params.customerName = customerName;
////   	    }
//
//   	    document.getElementById('matteriframe').src = urlStr;
//   	    callFunction(Ext.getCmp("search_adver_tapecode").params);
//   	   	search_adver_win.show(this);
//   }
   
//    callFunction(Ext.getCmp("search_adver_tapecode").params);
   	search_adver_win.show(this);
    
   

//		Ext.getDom('matteriframe').src = urlStr;


}

//快速下单
function add_new_OrderDetail_more(){

	var orderCategoryMain = getSelectParamFromAttribute($("categoryId"),"calculateauto");//根据付款分配应收 
	var orderCategoryMainId = $("categoryId").value;//根据付款分配应收 
    var cmdCustomer = Ext.getCmp("customerName");
    var cmdUser = Ext.getCmp("userId");
	var sumMoney = $("orderPublic.moneyRealpay").value;
	var sumTimes = $("orderPublic.times").value;
	var orderCode = $("orderCode").value;
//	var customerCategoryId = $("customerCategoryId").value;
	var customerCategoryId  = getValueFromStoreById(Ext.getCmp('customerName'),"customerCategoryId");
	var paymentId = $("paymentId").value;

	var relationCode = $("relationCode").value;
	

//	var adLength = $("matterLength").value;
//	var orderCheckState =  $("paymentId").value;
//	var isEdit = getEditOrderStates(colIndex,$("isCkecked").value);
	
	
	var resource_sort = getSelectParamFromAttribute($("resourceSortId"),"paramvalue");
	
	//alert(resource_sort);
	
	var paramObj={
			orgId:orgId, 
			year:$("order_year").value,
			resource_sort:resource_sort,
			orderId:order.obj.id,
			orderCategoryMain:orderCategoryMain,
			orderCategoryMainId:orderCategoryMainId,
			customerId:cmdCustomer.getValue(),
			customerName:cmdCustomer.getRawValue(),
			userId:cmdUser.getValue(),
			fullName:cmdUser.getRawValue(),
			sumMoney:sumMoney,
			sumTimes:sumTimes,
			orderCode:orderCode,
			relationCode:relationCode,
			orderCkeckState:$("isCkecked").value,
			customerCategoryId:customerCategoryId,
			paymentId:paymentId,
//			adLength:adLength,
			fromModel:1
	}      
    build_more_paraArray =  get_fast_sign_order_win(ctxPath,paramObj);
    build_more_paraArray.show();
}


//检测设定时间范围内是否有被锁定的日期
function check_locked(callFun){
	var startDate =  getFormatDay($("change_time").value,'ymd')*1;  
	var endDate =  getFormatDay($("change_time_end").value,'ymd')*1;  
	var grid = mygrid1;
	for(var i=0; i< grid.getRowsNum();i++){
		var v = grid.cells2(i,0).getValue();
		if(v == 1){
			var det = (new OrderDetail()).obj;
			det.id = grid.getRowId(i)*1;

			var resourceInfoId = grid.getUserData(det.id,"resourceInfoId");
			resIdArray.push(resourceInfoId);

		}
	}	
	
	if(resIdArray.length >0){
//		 extjMessage('"版本已存在!'); 
		function callBack(s){
			if(s.length == 0){
				callFun();
			}else{
				var msgArray = s.split(",");
				var errorString ="";
				for(var i = 0;i<msgArray.length;i++){
					errorString += msgArray[i]+"<br>";
				}
				
				 var msg="<div style='width:300px;height:300px;OVERFLOW-y:auto;OVERFLOW: scroll;'>"+errorString+"<div>";
					Ext.MessageBox.hide(); 
					Ext.MessageBox.show(
							 	{title:'系统提示，被锁定信息',msg:msg,width:380,heigth:300,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
					); 						
				
				return false;
			}
		}
		orderDetail.getDayInfosLockedByResourceIds(resIdArray,startDate,endDate,callBack);
		
	}
	
	
}
