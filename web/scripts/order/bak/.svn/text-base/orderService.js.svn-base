//实例化对象
var myDate = new MyDate();
var orderDetailColl = new OrderDetailColl();
var contract = new Contract();
var payMent = new PayMent();
var matter = new Matter();
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


var user = new User();

var order = new Order();
var orderPublic = new OrderPublic();
var orderDetail = new OrderDetail();

var orderBackUp = (new Order()).obj;
var orderDetailBackUp = (new OrderDetail()).obj;

//var orderBackUp ={id:null};
//var orderDetailBackUp ={id:null};

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
var alertStr='该时段超时日期:\n'; 
var orgId = 1;
var resource_sort =1;
var regCustomerWin;
var compagesDiaWin;
var ctxPath;
var compagesId_new = 0;









Ext.onReady(
	function(){

		resetHeigth();   
		initGrid();

		orgId =  getParamFromUrl(window.location.href,"orgId")+'';
		if(orgId !='') {if(orgId.indexOf('#') >-1) orgId = orgId.substring(0,1)}; 
		initCustomerCmd();
//		getCustomerAutoCompltByName();
		initIndustry();
	}

);


callOnLoad(init);	
  
  
function init(){
	//orderDetail.obj.specific = specific.obj; 
	
//	orgId =  getParamFromUrl(window.location.href,"carrSort");
	
	ctxPath = _app_params.ctxPath;	
	loginUserName =  _app_params.user.username;
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

	
	
	tag_time_out =  _app_params.rights.tag_time_out;
	tag_order_paymentbtn =  _app_params.rights.tag_order_paymentbtn;
	tag_orderDetail_save =  _app_params.rights.tag_orderDetail_save;
	
 
  
//    initGrid();
//    initGrid1();

//    resetHeigth();    

	//test_start = new Date().getTime();

	//如果订单号存在，则为编辑状态
//	var orderId = getOrderIdByURL();
	var srcStr = window.location.href;
	var orderId = getParamFromUrl(srcStr,"id");
	
//	resource_sort =  getParamFromUrl(srcStr,"carrierType");
	

		
//	var carrierSort = getParamFromUrl(srcStr,"carrierSort");
	
	orgId =  getParamFromUrl(window.location.href,"orgId")+'';
	if(orgId !=''){if(orgId.indexOf('#') >-1) orgId = orgId.substring(0,1); }
	
	

			
    
    if(orgId == 0){
    	alert("系统意外出错,无法找到组织编号");
    	return false;
    }
	
	var compagesId = getCompagesIdByURL();
	
	order.obj.orgId = orgId;
	order.obj.id = orderId;
	order.obj.compagesId = compagesId;
	
	//alert("init:" + "<" + orderId +">");
	
	if(orderId > 0 ){
		orderDetailStates = 1;
		//alert("init:" + "<" + orderId +">");
		order.obj.id = orderId;
	}else{
	 	orderDetailStates = 2;
	 	get_cur_year();
	}
	if(compagesId > 0) {
		var Btn_save = $("Btn_save");
	    if(!isUndefined(Btn_save)) Btn_save.hide();
//		$('Btn_save').hide();
		isPackage = true;
	}
//	$("Btn_matter_Customer").hide();
	
	

	
	
	
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
	


//	//getCarrierTypeTree(carrierType);
	//getCarrierSelect();
//	resourceSort.makeSelectFromMap("resourceSortId","getPosition",getPosition);
    var sortWidth = config_signCompages?80:140;
    if(orderDetailStates == 1){
    		resourceSort.makeSelectFromMap5("resourceSortId",sortWidth,"onchangeResourceSort",getPosition);
    }else{
    		resourceSort.makeSelectFromMap5("resourceSortId",sortWidth,"onchangeResourceSort",init_resourceCarrier);
    }

	
	

//	orderCategory.makeSelectFromMap3(orderCategory.obj,orderCategory.selectName,"getOrderSubCateCommand",getOrderSubCateCommand,config_orderModCategoryParam,138);
	
//	priceType.makeSelectFromMap(priceType.obj,"resourcePriceType","onResourceChange",function(){if(tvNameParam=='xmtv') $("resourcePriceType").value = 3;});

	priceType.makeSelectFromMap(priceType.obj,"resourcePriceType","145","onResourceChange",function(){
		if(config_autoPriceTypeParam > 0){
			$("resourcePriceType").value = config_autoPriceTypeParam;
		}else{
			$("resourcePriceType").value = 1;
		}
	});
	
	
	
	
	
	
	
//	industry.makeSelectFromMap(industry.obj,industry.selectName,"");
	//specific.makeSelectFromMap(specific.obj,specific.selectName,"getSpecificRate");
//	user.makeSelectFromMapLimit(user.selectName,"",setCurUserId);
//	user.makeSelectFromMapLimit(user.selectName,"",138,setCurUserId);
	var paramObJ ={};
	paramObJ.orgId =  orgId;
	paramObJ.loginUser = loginUserName;
	paramObJ.loginUserId = loginUserId;
	user.obj = paramObJ;
	var userCmd = user.getUsersByOrgLimit("extUserIdDiv","userId",144,setCurUserId,null);
	
//	userCmd.filterFiled ='fullName';
//	userCmd.params = paramObJ;
//	userCmd.listeners ={beforequery:user.comboFilterBy2.createDelegate(this)};

	
	
//	init_resourceSpeci();
//	init_resourceCarrier();
//	getMatterLengthComplt();
//	getContarctAuto();
	
	
	

	if(tvNameParam=='fztv'){
//		$('Btn_editOrder').hide();
//		$('Btn_addNewAdver').hide();
//		$('Btn_addAndPost1').hide();
//		$('Btn_addAndPost2').hide();
//		$('Btn_save').hide();
//		$('Btn_view_order').hide();
		$('Btn_print_order').hide();
		$('Btn_export_order').hide();
		$('gridbox1').hide(); 
//		$("Btn_closeDetail").hide();
//		initGrid1();
		
		if(config_signCompages ==1)$('resourceSortId').disabled=false; 
	}else{
//		$('Btn_editOrder').hide();
//		$('Btn_addNewAdver').hide();
//		$('Btn_addAndPost1').hide();
//		$('Btn_view_order').hide();
		$('Btn_export_order').hide();
		$('gridbox1').hide(); 
//		$("Btn_closeDetail").hide();
		
		if(config_signCompages ==1)$('resourceSortId').disabled=false; 		
	}
	
	if(config_signCompages ==1)$('resourceSortId').disabled=false; 		

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

//	disabledDestop();
	
	
    
	  
	// 1 编辑 2新添
	if(orderDetailStates == 1){
//		Ext.getBody().mask('数据加载中……', 'x-mask-loading');
		getOrder(orderId);
	}else{
		init_order_cate_main(orderId);
//		init_resourceCarrier();
		getMatterLengthComplt();
		init_resourceSpeci();
		getContarctAuto();
//		setOrderCategoryDef();
	}

	//取消从列表中点新添时，加载素材信息，改用点客户时才加载
	buttonEventFill();
	
	
//	getContarctAuto();
	disableContrlGlobal();
	
	
//	getCustomerAutoCompltByName(disableContrlGlobal);
	
//	$("Btn_editOrder").onclick=function(){};
	if(config_adverCodeModelParam == '1')$("tapCode").setAttribute("class","dataLabel");

	//TimeDiff(test_start);
}
function autoOrderArrange(){
	var orderId = order.obj.id;
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
}


function  onchangeResourceSort(){
	
	var  resourceSort = $("btn_packeg").value;
//	var resourceSort =  getSelectParamFromAttribute($("resourceSortId"),"paramvalue");
	getPosition(resourceSort);
	if(resourceSort == 2) {
		displayCompagesTree2();
	}else{
		init_resourceCarrier();
	}
	//如果是套装不初始化频道

//	if(resourceSort == 2) return false;
	
//	DWRUtil.removeAllOptions($("resourceInfoId"));
	



}

function reCheckcustomerName(){
//	var v = $("customer.customerName").value;
	var v = Ext.fly('customerName').dom.value;
	var targel = $("customerId");
	getAutoCompleteIdByValue($("theDivCustomerName"),targel,v,2,0);
	//alert(targel.value);	
}

function get_cur_year(){
	var year = getParamFromUrl(window.location.href,"version");
	var yyyy = getDayPar(config_serviceDate,'y');
//	year = year!= ''&& year!=null ?getDayPar(year,'y'):yyyy;
	if(year>0) yyyy = year;
	setSelectByValue($("order_year"),yyyy);
	order_year = $("order_year").value;
}
	
         
function init_selectComd(el,items){
	DWRUtil.removeAllOptions(el);
	DWRUtil.addOptions(el,items);
}

function set_selectComd1(id,val,txt){
	 var el = $(id);
	 if(val==0) txt ="";
     txt = txt.replace(/\\/g,"\\\\").replace(/'/g,"\\\'") 
	 eval("var items = {"+ val +":'" + txt +"'}");
	 init_selectComd(el,items);	
}

function set_selectComd2(id,val,txt,isInit){
		 var el = $(id);
		 if(val==0) txt ="";
		 
	//	  var test = {show:function(str){alert(txt);}};
		 txt = txt.replace(/\\/g,"\\\\").replace(/'/g,"\\\'") 
		 if(el.options.length>1){
		 	el.value = val;
		 }else{
		 	eval("var items = {"+ val +":'" + txt +"'}");
		 	init_selectComd(el,items); 
		 }  

}


function set_selectComdResource(id,val,txt,carrierId,isInit){
	 if(isInit){
	 		init_resourceInfo(carrierId,val);
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

}



function set_selectComdCarrier(id,val,txt,resourceSortId,isInit){
	 if(isInit){
	 		init_resourceCarrier(resourceSortId,val);
	 }else{
		 var el = $(id);
		 if(val==0) txt ="";
		 
	//	  var test = {show:function(str){alert(txt);}};
		 txt = txt.replace(/\\/g,"\\\\").replace(/'/g,"\\\'") 
		 if(el.options.length>1){
		 	el.value = val;
		 }else{

		 	eval("var items = {"+ val +":'" + txt +"'}");
		 	init_selectComd(el,items); 
		 }  
	 }
  	
}






function init_set_orderCate(obj,id,name,width,even){
	obj.id = id;
	var objs = [obj];
	orderCategory.makeSelectHtml(objs,name,width,even); 	
	$(name).value = id;
}

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

		carrier.obj.version = $("order_year").value;
		carrier.obj.orgId = orgId; 
		carrier.obj.resourceSort = resourceSortId; 
	    carrier.makeSelectFromMap2(carrier.obj,el,fuc,"getResource");	

}


function init_resourceInfo(carrierId,val){
	var el = $(resource.selectName);
	var fuc = function(){
		el.value =val;
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
		specific.makeSelectFromMap3(specific.obj,"resourceSpecificId","145",fuc,"getSpecificRate");	
	}	
}

function init_order_cate_main(orderId){ 

	var el = $("categoryId");
	var id = order.obj.categoryId;
	var fuc = function(){
		el.value = id;
	}

	if(el.options.length>1){
		el.value = id;
	}else{
		orderCategory.obj.parentId = 0;
		orderCategory.obj.orgId = orgId;
		var defValue = config_orderModCategoryParam;
		if(order.obj.id ||  orderDetailStates == 3) defValue  = id;
			orderCategory.makeSelectFromMap5(orderCategory.obj,"categoryId","reloadOrderCategory1Store",function(){
			if(!orderId){
				initOrderCategory1Cmd();
				if(config_orderModCategoryParam == $("categoryId").value) return false;
				reloadOrderCategory1Store();
			}
			
			},defValue,145);
//		orderCategory.makeSelectFromMap5(orderCategory.obj,"categoryId","initOrderCategory1",function(){},config_orderModCategoryParam,145);
	}	
}


function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = false;
	mygrid.setImagePath("image/grid/");
	var	flds = "序,位置,名称,版本,秒,指定,开始,结束,次,";
	var	columnIds =  "seq,pos,name,edit,len,spec,start,end,times,opter";  
	mygrid.setHeader(flds);
	mygrid.setColumnIds(columnIds);
    mygrid.setInitWidthsP("5,15,19,19,5,9,9,9,6,4");
    mygrid.setColSorting("int,str,str,str,str,int,str,str,int");
	mygrid.setColAlign("center,left,left,left,center,center,center,center,center,center");
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
	mygrid.setEditable(false);
	mygrid.setOnRowSelectHandler(onRowSelectd,true);
	mygrid.enableAutoSizeSaving();
	mygrid.setSkin("modern2");
	mygrid.enableAlterCss("even","uneven");
	mygrid.init();	
}


function initGrid1(){
	mygrid1 = new dhtmlXGridObject('gridbox1');
	mygrid1.selMultiRows = true;
	mygrid1.setImagePath("image/grid/");
	
	mygrid1.setSkin("xp");
	mygrid1.enableAlterCss("even","uneven");
	
//	mygrid1.setRowTextStyle(id,'background-color:white;font-size:13px;');
	
	var flds = "序,频道,时段,磁带,名称,版本,长度,类别,应付,指定,月,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,总次";

	var columnIds = "order,carrier,resource,tapCode,advName,edit,length,subcate,price,specific,month," 
					+"day1,day2,day3,day4,day5,"
					+"day6,day7,day8,day9,day10,"
					+"day11,day12,day13,day14,day15,"
					+"day16,day17,day18,day19,day20,"
					+"day21,day22,day23,day24,day25,"
					+"day26,day27,day28,day29,day30,"
					+"day31,monthTimes";
					
	mygrid1.setHeader(flds);  				
	mygrid1.setColumnIds(columnIds);

	
//	1.5*10 =15 + 2 =17
//	23*2 = 46
//	3*5 =15
//  3*3 =9
//	2*7 =14
	
	
	mygrid1.setInitWidthsP("2,4,7,4,4,7,3,3,3,3,2,1.5,1.5,1.5,1.5,1.5,1.5,1.5,1.5,1.5,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3.5");
	mygrid1.setColAlign("center,left,left,left,left,left,center,center,right,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,right");
	mygrid1.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
//    mygrid1.setColHidden("order,carrier");
    mygrid1.setMultiLine(false);
	mygrid1.setEditable(false);
    mygrid1.setOnRowSelectHandler(doOnRowSelected,true);
    mygrid1.enableAutoSizeSaving();
    
//    var expires = new Date();
//    expires.setTime(expires.getTime() + 24 * 30 * 60 * 60 * 1000); // sets it for approx 30 days.
//    mygrid1.enableAutoSizeSaving("order_details_grid_cooker","expires=Fri, 31-Dec-2015 23:59:59 GMT");
//    mygrid1.setOnRowDblClickedHandler(doOnReturn);
//    mygrid1.setColSorting("int,str,str,str,str,str,int,str,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int") ;
	mygrid1.init();
    mygrid1.setSizes();	
}

function doOnRowSelected(id,id2){

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
	var orderBaseInfoFrm_div = $("div_gridbox_detail");
	orderBaseInfoFrm_div.style.height = (orderBaseInfoFrm.offsetHeight+orderDetailFrm.offsetHeight)*0.9 +"px";	
} 



function setCurUserId_BAK(){
		sessionUserId = loginUserId;
		if(tvNameParam=='fztv'){
			var callback=function(objs){
				for(var i in objs){
					if(objs[i]=='宣传片录入') isFree = true;
				}
			}
			user.getUserRolesCols(loginUserId,'lable',callback); 
		}

		if(orderDetailStates == 2) $(user.selectName).value = loginUserId;

}


function setCurUserId(){

//	var fnc = function(id){
		sessionUserId = loginUserId;
		if(tvNameParam=='fztv'){
			var callback=function(objs){
				for(var i in objs){
					if(objs[i]=='宣传片录入') isFree = true;
				}
			}
			user.getUserRolesCols(loginUserId,'lable',callback); 
		}
		
		if(orderDetailStates == 2) Ext.getCmp("userId").setValue(loginUserId);;
		
		
//		if(orderDetailStates == 2) $(user.selectName).value = loginUserId;
//	}

}




function getMatterLengthComplt(){
	priceDetail.getPriceDetailAutoComplet(payMatterLengthAutoComplet);
}

function payMatterLengthAutoComplet(objs)
{
	var oText_MatterLength = $("matterLength");
	var oDiv_MatterLength = $("theDivmatterLength");
	
	var indexColumName_MatterLength = ["length"];
	var allColumsName_MatterLength =["length"];
	
//   if(orderDetailStates == 2) oText_MatterLength.value = 5;
	
			
//	var allColumsTitle = ["广告长度"];
	var onDivMouseDown_MatterLength = function(ev){
		var tr = getElementByEvent(ev);
		$("length").value = getCellValue(tr,0);
//		$("customerName").value = getCellValue(tr,1);
		
		oText_MatterLength.value = getCellValue(tr,0);
		
//		copyBroTimesToCurBroArrange();
			getMatterAutoComplet();
	}
	
//	var hidenColumName = ["length"];
	
	var onTextBlur = function(ev){
		
		var Btn_addAndPost2 = $("Btn_addAndPost2");
		if(!isUndefined(Btn_addAndPost2)) Btn_addAndPost2.disabled = false;
		
		var isd = isDigit(oText_MatterLength.value);
	    if(!isd){
	    	  alert("必须数字!");
	    	  oText_MatterLength.value ="";
	    }
	        
		oDiv_MatterLength.style.visibility = "hidden";
		
		if(trim(oText_MatterLength.value) == "" ){
			$("length").value = '0';
		}
		
		//copyBroTimesToCurBroArrange();
		if($("length").value != '0'){
			getMatterAutoComplet();
		}
		
	    function fnc(){
	        	var isNewOrderDetail = (orderDetailStates == 2||orderDetailStates == 3);
    
	        	//backupBroarrayToCur(isNewOrderDetail);
	        	backupBroarrayToCur(isNewOrderDetail,null,true);//用来防止超时:因为原来第一次占用超时会报超时，第二次就不会清除；坏处是再次回到不超时状态也会清除。

	    }
	    
	   getSysPrice(false,fnc);
	   
	}
   new AutoComplete(objs,oText_MatterLength,oDiv_MatterLength,-1,onDivMouseDown_MatterLength,onTextBlur,"",indexColumName_MatterLength,allColumsName_MatterLength,null);
}



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
	if(!isUndefined(Btn_save)){ 	
		Btn_save.onclick = save_Order;
	}
	//订单明细表格右上角增加格图片
	//var Bt_selectOrderDetailImgAdd = $("orderDetailImgAdd");
	//Bt_selectOrderDetailImgAdd.onclick = addnewOrderDetail;
	
	var order_check_history = $("order_check_history");
	order_check_history.setAttribute("href","javascript:void 0");
	order_check_history.onclick = autoOrderArrange;
	
//	var Btn_matter_all = $("Btn_matter_All");
//	Btn_matter_all.setAttribute("href","javascript:void 0");
////	Btn_matter.DWRUtil.set.dhtmlXLabelButtonObject
//	Btn_matter_all.onclick = initMatter;
	
//	var Btn_matter_customer = $("Btn_matter_Customer");
//	Btn_matter_customer.setAttribute("href","javascript:void 0");
////	Btn_matter.setAttribute("text","大师傅");
//	Btn_matter_customer.onclick = initMatter;
	
//	var oText = $("customer.customerName");
//	oText.onkeypress= getCustomerAutoCompltByName;	
//	getCustomerAutoCompltByName();
	
	//广告素材自动下拉
	var Bt_tapeCode = $("matter.tapeCode");
	Bt_tapeCode.onclick = getMatterAutoCompletTapeCode;	
	Bt_tapeCode.onkeypress = function a(event){DWRUtil.onReturn(event,getMatterCodes);}
	
	var Bt_matterName = $("matter.name");
	Bt_matterName.onclick = getMatterAutoComplet;	
//	Bt_matterName.onkeypress = function a(event){DWRUtil.onReturn(event,getMatterNames);}
//	Bt_matterName.onkeypress = function a(event){DWRUtil.onReturn(event,getMatterAutoComplet);}
	
	
	var Bt_matterEdit = $("matter.edit");
	Bt_matterEdit.onclick = getMatterAutoComplet();
	
	
	function getMatter_new(){
		getMatterAutoComplet(false);
	}
		
	

	//自动排期
//	var Btn_autoBroArrange = $("autoBroArrange");
//	Btn_autoBroArrange.onclick = autoBroArrange;
		
	//取消
	var Btn_cancel = $("Btn_cancel");
	Btn_cancel.setAttribute("href","javascript:void 0");
	Btn_cancel.onclick = cancelOrder;
	
	//新添广告
	var Btn_addNewAdver = $("Btn_addNewAdver");
	Btn_addNewAdver.onclick = addnewOrderDetail;
	
	//单击广告长度 183
	var Btn_matterLength = $("matterLength");
	Btn_matterLength.onclick = Disable_addAndPost2;	 
	
	//新添广告
//	var Btn_addAndPost1 = $("Btn_addAndPost1");
//	Btn_addAndPost1.onclick = addAndPostOrderDetailt1;
	//新添并粘贴
	var Btn_addAndPost2 = $("Btn_addAndPost2");
	Btn_addAndPost2.onclick = addAndPostOrderDetailt2;
	
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
//	var Bt_displayLeavTimes = $("isDisplayLeavTimes");
//	Bt_displayLeavTimes.onclick = displayLeavTimes;	
	
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
	var sysPrice = $("sysPrice");
	sysPrice.onblur = setBroArrayangeMonthOnPriceChange;
	
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
			if(this.value == 2) displayCompagesTree2();
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
	changeMoney.onkeypress = displaySumMoneyKeypress;
	changeMoney.onblur = displaySumMoney;
	
	document.body.onfocus = closePopup;
	
	var Btn_view_order = $("Btn_view_order");
	Btn_view_order.onclick = button_view_order;

	var Btn_print_order = $("Btn_print_order");
	Btn_print_order.onclick = button_print_order;	
	
	var Btn_export_order = $("Btn_export_order");
	Btn_export_order.onclick = button_print_export;	
	
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
	btn_orderMeno.onclick=displayDiv;
	
	var btn_textareaOrderMeno = $("textareaOrderMeno");
	btn_textareaOrderMeno.onblur=closeDiv;
	btn_textareaOrderMeno.onkeypress = displayOrderMeno;
	
	
	var Btn_change_matter_brotime = $("Btn_change_matter_brotime");
	Btn_change_matter_brotime.onclick = changeMatterEdit;
	
}
function autoBroArrange_from_broArrangService(){ 
    var targDiv = $("broArrangeDiv");
    var startEl =  $("beginDate");
	var endEl =  $("overDate");
	var selectMonthCmd = $("selectMode");

	autoBroArrange(_app_params,order_year,targDiv,selectMonthCmd,startEl,endEl,orderDetailBackUp,broArrange,orderDetailStates);
}

function getBroArrange_from_broArrangService(){ 
	var rsId =$("resourceInfoId").value;
	var specificValue = getSelectParamFromAttribute($("resourceSpecificId"),"position");
	var isLock = false;
    
    function fun(callBakFun){
    	
    	getMonthInfos(isLock,rsId,specificValue,broArrange.startDate,broArrange.endDate,callBakFun);
    }
	
	getBroArrange(orderDetailBackUp,broArrange,fun);
}


function getMatterNames(){
   var name = $("matter.name").value
   if(name !='' && name.length>0){
//   	   initMatterButton = true;
       getMatterAutoComplet();
   }
}
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
   	  		alert("未能找到匹配的素材!");
   	  		$("matter.tapeCode").focus();
   	  	}
   	  }
  
       matter.getMatterByTapCode(obj,callBak)
   }
}



//function displayTreeGroupDiv(){
//	
//	if($("composRadioId").checked){ 
//		$("compagesTreebox").show(); 
//		$("carrierTypeTreebox").hide();
//	}else if($("basePosRadioId").checked){
//		if(carrierType.tree==null){
//			setCarrierTypePara(carrierType);  
//			getCarrierTypeTree(carrierType);  
//		} 
//		$("compagesTreebox").hide();     
//		$("carrierTypeTreebox").show(); 
//	} 
//
//}

function displayCompagesTree2(){
	var dialogcontent = $("dialogcontentDiv");
	var dialogcontentW = dialogcontent.offsetWidth;
	var dialogcontentH = dialogcontent.offsetHeight;
	var winW= dialogcontentW * 0.3;
	var winH = dialogcontentH*0.8;
	
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
	    var okBtn ={text: '确定',handler: function(){compagesDiaWin.hide();confirmCompages(function(){compagesDiaWin.hide();});}};
	 	var closeBtn ={text: '关闭',handler: function(){compagesDiaWin.hide();}};
		 compagesDiaWin = new Ext.Window({
			   title : '套装广告',
			   width : winW,
			   height : winH,
			   isTopContainer : true, 
			   modal : false,
			   resizable : false,
			   tbar:[rd],
			   buttons: [okBtn,closeBtn],
			   contentEl :  $("treeGroup2")
		  	}); 	
	 }


	compagesDiaWin.show();


 var checkedItem = Ext.getCmp('opt_package').getValue();
 
//	$("treeGroup2").style.height  = winH*0.7 +"px";

 if(checkedItem.getGroupValue() == 1){
    
 	  
 	 getCompagesTree(compages,resourceSort);  
 	 
//  	  if(compages.tree==null){
 	  	$("compagesTreebox2").style.height  = winH*0.7 +"px";
// 	  }	 

	if(compages.tree!=null && compages.tree.dhtmlTree.getXMLState()) compages.tree.refreshTree();
	
	$("compagesTreebox2").show(); 
	$("carrierTypeTreebox2").hide();
 }else{
	if(carrierType.tree==null){
		setCarrierTypePara(carrierType);  
		getCarrierTypeTree(carrierType);  
		$("carrierTypeTreebox2").style.height  = winH*0.8+"px";
		
	} 

	if(carrierType.tree !=null && carrierType.tree.dhtmlTree.getXMLState()) carrierType.tree.refreshTree();
	$("compagesTreebox2").hide();     
	$("carrierTypeTreebox2").show();  	
 }

}




function displaySumMoney2(){
	
//	var resourcePriceType = getSelectParamFromAttribute($("resourcePriceType"),"paramvalue");
//	var price_auto_man = $("price_auto_man").value;
	
	

        var old_Realpay = $("moneyBase").value*1;
		var broSumTime = $("broSumTime").value*1;
		var sumTotal = $("moneyRealpay").value*1

        if(old_Realpay == 0 && broSumTime == 0){
	        	alert("请先输入排期!");
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
		
		broArrange.basePrice =  $("moneyBase").value*1;
		broArrange.realPrice = $("execPrice").value*1;	 		
	
}
function Disable_addAndPost2(event){
	var Btn_addAndPost2 = $("Btn_addAndPost2");
	if(!isUndefined(Btn_addAndPost2)) Btn_addAndPost2.disabled = true;
}



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
	 
//	 if(obj==compages.tree){
//	 	$("compagesId").value = parentId.substring(10); 
//	 }else{
//	 	$("compagesId").value =-1;
//	 }
	 
	 $("compagesId").value =-1;
//     alert(parentId)compagesId_new
//     alert(compages.IdPrefix) 
	  compagesId_new = obj.getIdByPrefix(parentId,compages.IdPrefix); 
	  var priceTypeId = obj.dhtmlTree.getUserData(parentId,"priceTypeId");
	  

	  if(priceTypeId > 0)  {
	  	 $("resourcePriceType").value = priceTypeId;
	  }else{
	  	if(config_autoPriceTypeParam > 0) $("resourcePriceType").value = config_autoPriceTypeParam;
	  }
	
	 
	 
//	  alert(compagesId_new)
	 
//	$("carrierName").value = obj.dhtmlTree.getSelectedItemText();
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
	oDiv.style.width = $("orderMeno").offsetWidth*2.6 +"px";
	$("textareaOrderMeno").style.width = oDiv.style.width;
	oDiv.style.heigth = $("textareaOrderMeno").style.height +"px";
	
	$("textareaOrderMeno").focus();	
	//$("orderMeno").disabled= true;
	$("textareaOrderMeno").value = $("orderMeno").value;
}

function closeDiv(ev){
	var oDiv = $("theDivOrderMeno");	
	oDiv.style.visibility = "hidden";
	$("orderMeno").value = 	$("textareaOrderMeno").value;
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
//	getResource();
	getContarctAuto();
}

function displayOrderDetail(){
	if(!mygrid1) initGrid1();

	if(order.obj.id==null) return false;
			
//	if(tvNameParam =='cctv' || tvNameParam =='sjz'){
//			popupOrderDetail.url = "selectPopup/orderDetail.html?id=" + order.obj.id ;
//			//popupOrderDetail.model = 10;
//			popupOrderDetail.popupcenter(popupOrderDetail);
//	}else{
		
			var displayBtnValue = $("Btn_orderDetail").value;
			
			if(displayBtnValue.indexOf('关闭')>-1){
				close_OrderDetails();
			}else{
		
				resetHeigth1();
				$("Btn_orderDetail").value ="关闭"
		//		$("Btn_orderDetail").hide();
		//		$("Btn_closeDetail").show();  
				$("gridbox1").show();
				$("orderDayInfo_Array").hide();
				var func = function(xml){
					mygrid1.clearAll();
					mygrid1.loadXMLString(xml);
					mygrid1.loadSizeFromCookie();
					doOnRowSelected(null,mygrid.getSelectedId());
					mygrid1.setSizes();	
				}
				orderDetailColl.getOrderDetailXml(order.obj.id,func);
			}
	
//	}
}




function close_OrderDetails(){
	   	var displayBtnValue = $("Btn_orderDetail").value;
	   	if(displayBtnValue.indexOf('关闭')>-1){
			$("gridbox1").hide();
			$("orderDayInfo_Array").show();
			$("Btn_orderDetail").value ="查看明细"
	   	}
}
function selected_OrderDetails_grid(id){
	   	var displayBtnValue = $("Btn_orderDetail").value;
	   	if(displayBtnValue.indexOf('关闭')>-1){
            doOnRowSelected(null,id);
	   	}
}



function resetHeigth1(){
//	var orderBaseInfoFrm = $("order_baseInfo_frm");
	 var dialogcontent = $("dialogcontentDiv");
	 var z = getAbsolutePos($("dtPublishMemo"));
	 v =dialogcontent.offsetHeight-z.y;
	 var gridbox1 = $("gridbox1");
	 gridbox1.style.height = v +"px";	
	 mygrid1.setSizes();	
} 


function initMatter(){
	if(initMatterButton){
		initMatterButton=false;
	}else{
		initMatterButton=true;
	}
}


function setCarrierTypePara(obj){
	 obj.className  = "carrierType";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox2";
	 obj.tree 		= new Tree(obj.treebox); 
}


//设置属性
function setResourceSortPara(obj){
	 obj.selectName =  "resourceSortId";
}
function setBroArrangePara(obj){
	 obj.targ  = $(orderDayInfo.fillObjName);
}
function setOrderCategoryPara(obj){
	 obj.className  = "orderCategory";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "categoryId";
}
function setResourcePara(obj){
	 obj.className  = "resource";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "resourceInfoId";
}
function setPriceTypePara(obj){
	 obj.className  = "priceType";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "resourcePriceType";
}
function setPricePara(obj){
	 obj.className  = "price";
	 obj.IdPrefix 	= obj.className + "Id";
}
function setOrderCategory1Para(obj){
	 obj.className  = "orderCategory1";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "orderCategoryId";
}
function setAgentInfoPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "carrierId";
}
function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "carrierId";
}
function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "customerId";
}
function setIndustryPara(obj){
	 obj.className  = "industry";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "industryTypeId";
}
function setSpecificPara(obj){
	 obj.className  = "specfic";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "resourceSpecificId";
}
function setUserPara(obj){
	 obj.className  = "user";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "userId";
}

function setPriceDetailPara(obj){
	 obj.className = "priceDetail";	
	 obj.IdPrefix 	= obj.className + "Id";
}

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
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}
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
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}
function setDayInfoPara(obj){
	 obj.className ="resDayInfo";
}
function setOrderDayInfoPara(obj){
	 obj.className ="orderDayInfo";
	 obj.IdPrefix 	= obj.className +"Id";
	 obj.tableName   = obj.className +"Table";
	 obj.fillObjName = obj.className +"Tbody";
//	 obj.targ = $(orderDayInfo.fillObjName);
	 obj.dayInfo = (new DayInfo()).obj;
}

function setCompagesPara(obj){
	 obj.className  = "compages";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox2";
	 obj.tree 		= new Tree(obj.treebox); 
	 obj.treeXMLObj1 		= null; 
	 obj.treeXMLObj2 		= null; 
}

function setMatter(o){
	$("dt_matter.id").value = o.id;	
	$("matter.tapeCode").value = o.tapeCode;
	$("matter.name").value = o.name;  
	$("matter.edit").value = o.edit;
	$("matterLength").value = o.length;
	$("matterType").value = o.matterType;
	
}
function setOrder(o){
	DWRUtil.setValues(o);
	order.setObject(o);


	$("order_year").value = o.version;
	order_year =  o.version;
//	initOrderCategory1();
	
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
	

	inti_set_customer(1,o.customerId,o.customer.customerName,o.customer.customerCategoryId);

	int_set_user(o.userId,o.user.fullName);
	
	init_set_orderCate(o.orderCategory,o.categoryId,"categoryId",145,null);


    

    
	setOrderPublic(o.orderPublic);
	

}

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
}
	
	
function setOrderPublic(o){
	order.obj.orderPublic = o;
	$("orderPublic.publishStartDate").value = o.publishStartDate;	 //订单开始日期
	$("orderPublic.publishEndDate").value = o.publishEndDate;	//订单结束日期
	
//	DWRUtil.setValue("orderPublic.times",o.times); //订单总次数
	$("orderPublic.times").value = o.times;	//订单总次数

//	$("orderDetail_mod_states").value = o.orderStates;	//审核状态
	
//	$("orderPublic.moneyBase").value = o.moneyBase;//订单总刊例价
	$("orderPublic.moneyBase").value = o.moneyBase;//订单总刊例价
	$("orderPublic.moneyRealpay").value = o.moneyRealpay;	//订单总销售价
	$("orderPublic.moneyIn").value = o.moneyIn; //订单总到到帐分配金额
}
function setOrderDetail(o,isEdit){
    
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
	if(config_orderCarrierLevelParam =='1'|| (tvNameParam =='xmtv' && orgId == 2)){  
			carrier_id = o.carrier.parentId;
			carrier_id_bak = orderDetailBackUp.carrier.parentId;
	}else{		
			carrier_id = o.carrier.id;
			carrier_id_bak = orderDetailBackUp.carrier.id;
	}
	

	var el = $("resourceInfoId");
	if(isEdit && (carrier_id_bak != carrier_id || cur_carrier_id != carrier_id || el.options.length == 1)) isResource = true;


	var el = $("carrierId");
	if(!isInitCarr && isEdit  && el.options.length == 1) isInitCarr = true;

	set_selectComdCarrier(carrier.selectName,carrier_id,o.carrier.carrierName,o.resourceSortId,isInitCarr);
	$("carrierName").value = o.compages.name;  
	
//	alert(isResource)
	set_selectComdResource("resourceInfoId",o.resourceInfoId,o.resource.resourceName,carrier_id,isResource);

	inti_set_orderSubCate(o.orderCategoryId,o.orderCategory.name,o.orderCategory.calculateAuto);

     inti_set_industry(o.industry);

	$("orderDetail_mod_by").value = Ext.fly('userId').dom.value;
	$("orderDetail_mod_date").value = formatDateGlobal2(o.modifyDate);

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

	//如果是协约，不需要修改总应收
	//设置 BroArrange.isCal;
	
	if($("resourceInfoId").value>0) getSysPrice(true);

 	getCalculateModel();
	setMatter(o.matter);
	setOrderDetailPublic(o);
	
}


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
//	alert(o.orderPublic.moneyRealpay);
	$("moneyBase").value = o.orderPublic.moneyBase; //总刊例价
	$("moneyRealpay").value = o.orderPublic.moneyRealpay;    //总销售价
	

	
    $("broSumTime").value = o.orderPublic.times;			 //总次数
    $("broArrangeStartDate").value = o.orderPublic.publishStartDate;	//总次数
    $("broArrangeEndDate").value = o.orderPublic.publishEndDate;		//总次数
    
//    orderDetail.publishStartDate_bak = o.orderPublic.publishStartDate;
//    orderDetail.publishEndDate_bak = o.orderPublic.publishEndDate;
    
   // endDate = $("broArrangeEndDate").value ;
//	if(fztvSpecialParam==0) 
//	lockDestopOrderDetail(false);
}
//清空订单
function resetOrder(){
	
	order.reset();
	
	orderBackUp = (new Order()).obj;

	$("orderCode").value = null;
	$("relationCode").value = null;
	$("orderMeno").value = null;
	$("textareaOrderMeno").value = null;
	
//	$("userId").value = sessionUserId;
//	 Ext.fly('userId').dom.value= sessionUserId;
	
	$("categoryId").value = 0;
	$("customerId").value = 0;
	$("contract.code").value = null;
//	$("customer.customerName").value = null;
//	Ext.fly('customerName').dom.value= '';
	
	if(Ext.getCmp("customerName")){
		Ext.getCmp("customerName").setValue('');
	}

//	if(!Ext.getCmp("customerName")){
//		getCustomerAutoCompltByName();
//	}else{
//		Ext.getCmp("customerName").setValue('');
//	}	
	

//	Ext.getCmp("userId").setValue('');
	
	
	$("order.contractId").value = null;
	$("order.contractCode").value = null;
	$("customerCategoryId").value = null;
	//清空合计信息
	$("orderPublic.publishStartDate").value = "";	
	$("orderPublic.publishEndDate").value = "";	
	$("orderPublic.moneyBase").value = "0";
	$("orderPublic.moneyRealpay").value = "0";	
	$("orderPublic.moneyIn").value = "0";
	$("contractPayment.contractMoneySum").value = "0";
	$("orderPublic.times").value = "0";
	$("orderDetail_mod_states").value = null;	//审核状态
	
//	DWRUtil.setValue("orderPublic.times",0);
}
//清空订单明细
function resetOrderDetail(removeRows){

	orderDetail.reset();
	
	orderDetailBackUp = (new OrderDetail()).obj;  

	//DWRUtil.setValues(orderDetail.obj);
	
//	if(tvNameParam == 'xmtv') {
//		$("resourcePriceType").value = 3;
//	}else{
//		$("resourcePriceType").value = 1;
//	}
	
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
	

//	DWRUtil.removeAllOptions("resourceInfoId");
	//DWRUtil.removeAllOptions(specific.selectName);
	//getPosition()

	$("dt_matter.id").value = null;
	$("matter.name").value = null;  
	$("matter.tapeCode").value = null;
	$("matter.edit").value = null;	
	$("matterLength").value = null;
	$("matterType").value = null;
//	$("isCkecked").value = null;
	//if(removeRows)DWRUtil.removeAllRows(orderDetail.fillObjName);	
	if(removeRows){
		mygrid.clearAll();
		//alert(orderDetail.page.pageIndex);
		orderDetail.page.pageIndex = 1;
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

		if(value <100){
			this.value = value;
		}else{
			this.value ='';
		}
		var sysPrice = $("sysPrice").value;
		var execPrice = getExecPrice(sysPrice);
		var lowestRate = $("lowestRate").value;

        $("execPrice").value = getExecPrice(sysPrice);
        resetMoneyRealpay();
}


function resetMoneyRealpay(){
    $("moneyRealpay").value = 0;
	if(getCalculateModel()){
        var sysPrice = $("sysPrice").value;
		var execPrice = getExecPrice(sysPrice);
        $("execPrice").value = execPrice;
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
//

function getCalculateModel(){
	 broArrange.isCal = true;
//	 var catMain = getSelectParamFromText($("categoryId"),"||",2);
	 var catMain = getSelectParamFromAttribute($("categoryId"),"calculateauto");
	 
	 
	 if(catMain == '') catMain = 0;
//	 var catSub = getSelectParamFromText($("orderCategoryId"),"||",2);
//	 var catSub =  Ext.getCmp('orderCategoryId').store.getAt(0).get('calculateAuto');
//	 var catSub =  Ext.getCmp('orderCategoryId').store.getAt(0).data.calculateAuto;

    
     
//     if(!orderCategory1.orderCategoryCommand) {
//
//     	initOrderCategory1();
//
//     }
     
//     var catSub =  getValueFromStoreById(orderCategory1.orderCategoryCommand,"calculateAuto");
  
      var catSub =  orderCategory1.calculateAuto;
     

	 if(catSub == '') catSub = 0;
	 
	 //如果是 0 则根据付款信息 来确定应收
	 if(config_contractsort == 0){
		 if(catMain == "0" ||catMain == "2" ||  catSub == "0"){
		 	broArrange.isCal= false;
		 }	 	
	 }
	 
	 if(catSub == "0") broArrange.isCal = false;
//	 alert(BroArrange.isCal);
	 return broArrange.isCal;
}

function closePopup(ev){
//	alert(0);
	popupcenter.closePopup(popupcenter);
}
//function autoBroArrange(ev){
//	popupcenter.url = "selectPopup/selectAutobro.html";
//	popupcenter.model = 6;
//	popupcenter.popupcenter(popupcenter);
//}


function editOrderInfo(){
   
	if(order.obj.id <1) return false;
	
//	if(checkOrderStates('不允许编辑','edit')) return false;
	
//	close_OrderDetails();
				
	orderDetailStates = 1;
	
	init_order_cate_main();
	
//	reloadOrderCategory1Store();
//	initOrderCategory1();
//	init_resourceInfo();
	
	init_resourceSpeci();

//	init_resourceCarrier(false,2);
	getMatterLengthComplt();
	getContarctAuto();

//  getCustomerAutoComplt();
//	getMatterAutoComplet();	
	
//	lockDestopOrderDetail(true);

//	setOrderDayInfosBak();
}		

function backup_cur_info(order,detail,monthInfos){
	
	if(order){
		orderBackUp = Object.clone(order);
//		Object.extend(orderBackUp.ordr)
//		console.log(orderBackUp);
	}
	if(detail){
		orderDetailBackUp = Object.clone(detail);
		orderDetailBackUp.order = orderBackUp;
//		console.log(orderDetailBackUp);
	}	
	
	
	
	if(monthInfos){
		
//		console.log(monthInfos);
		
		var orderDayInfos = orderDayInfo.getOrderDayByDayInfoArray(monthInfos);
		
        orderDetailBackUp.orderDayInfos = orderDayInfos;
        
//		console.log(orderDetailBackUp);
	}	
}




function getPosition(model){ 

	var resourceSort =  getSelectParamFromAttribute($("resourceSortId"),"paramvalue");
//   	alert(22222222222222222)
	

	//套装
	if(model == 2){
		 $("carrier_area").hide();
		 $("resourceInfoId_area").hide();
		 $("compages_area_name").show();
		 $("compages_area_pos").show();
		 $("carrierId").value = 0;
		 $("resourceInfoId").value = 0; 
	}else{
	//时段,
	
		
//		 var carrierId = $(carrier.selectName).value;
		 //if(carrierId > 0) getResource();
//		 getCarrier();
		 $("carrier_area").show();
		 $("resourceInfoId_area").show();
		 $("compages_area_name").hide();
		 $("compages_area_pos").hide();
		 $("compagesId").value = null;
		 
		
		  
		 $("compages.pos").value = null;
		 $("compages.resourceIds").value = null;
		 $("parentId").value = 0;
		 $("compagesMoneyRealpay").value = 0;

     
//		 init_resourceCarrier();
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

	

	
	

}
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
//	obj.obj.parentId = 0;
//	obj.obj.nodeLevel=0;
//	obj.obj.displayNo = 0;
//	carrierType.obj.orgId = orgId;
	
	
	obj.obj.parentId = 0;
	obj.obj.nodeLevel = 999;
	carrierType.obj.orgId = orgId;
	
	
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

//function getCarrier(){
//	carrier.reset();
//	carrier.obj.parentId = 0;
//	carrier.makeSelectItem(carrier.obj,carrier.selectName,"getResource");	
////	resetDayInfo(true);
//}

//function getCompages(){
//	getCompagesAutoComplete();
//}

	
//获得order和orderDetail信息；
function getOrder(orderId){
	resetOrder();
	resetOrderDetail(false);
	resetDayInfo(false);
	

	var getOrderFun = function (o){
		
		setOrder(o);
		
		backup_cur_info(o,null,null);
		
		function getDetailTableFun(){
			//lockDestopOrder();
			//默认显示第一行定单明系的信息
			var firstRowId = mygrid.getRowId(0);
			//var firstRowId = getFirstRow($(orderDetail.fillObjName));
			if(firstRowId){
				getOrderDetail(firstRowId);
			}else{
				orderDetailStates = 2;
			}	

		}
		
		//获得定单明系表
		//orderDetail.reset();
		//orderDetail.obj.orderId = orderId;
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
				        }
	        	  }	
        }	
        
    
}


//鼠标点击事件
function getOrderDetail(orderDetailId,colIndex){
	//if(colIndex > 0 && colIndex == 8) return false;

   	orderDetailStates = 0;
	
//	var Btn_addAndPost1 = $("Btn_addAndPost1");
	var Btn_addAndPost2 = $("Btn_addAndPost2");
	var Btn_addNewAdver = $("Btn_addNewAdver");
	var Btn_save = $("Btn_save");
//	Btn_addAndPost1.disabled = true;
	Btn_addAndPost2.disabled = true;
	Btn_addNewAdver.disabled = true;
	Btn_save.disabled = true;

	var unlock = function(){
//		Btn_addAndPost1.disabled = false;
		Btn_addAndPost2.disabled = false;
		Btn_addNewAdver.disabled = false;
		Btn_save.disabled = false;
	}

	
	orderDetail.obj.orderDayInfosBak = new Array();
	isResChangedOnEdit = false;
	isSpecifChangedOnEdit= false;

	//通过索引给每一行上色
	//var rowIndex = getEditRowIndexById(orderDetailId);
	var rowIndex = mygrid.getRowIndex(orderDetailId);
	

	drawColorOrderDetailTable(rowIndex);

	
	var getOrderDetailFun = function (o){
    var isEdit = getEditOrderStates(colIndex,$("isCkecked").value);
	    setOrderDetail(o,isEdit);	
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
         


		getMonthInfos(isLock,rsId,specificValue,o.orderPublic.publishStartDate,o.orderPublic.publishEndDate,unlock);
		
		
		

	    
		if(colIndex > 0){ 
			var colName = mygrid.getColumnId(colIndex);
			if(colName == 'opter'){
				 deleteOrderDetail(orderDetailId);
			}
//			if(colName == 'seq' && config_isOpenOrderOrgParam == 1) showOrderLog(orderDetailId);
       
		}
		
	
		
		
		
		
	}
	

	
     orderDetail.getOrderDetail(orderDetailId,getOrderDetailFun);
 
     
     if(colIndex == 0 && config_isOpenOrderOrgParam == 1) showOrderLog(orderDetailId);
}






//获得表
function getOrderDetailTable_bakk(orderDetail,callBackFun){	
	
	var fnc = function(objs){
		orderDetail.fillTalbe(objs);
		callBackFun();
	}
	if(isPackage == true){
		var orderDetailId = getOrderDetailByURL();
		var paramObj = new OrderDetail();
		paramObj.page = orderDetail.page;
		paramObj.obj.parentId = orderDetailId;
		paramObj.getOrderDetails2(fnc);
	}else{
		var paramObj = new OrderDetail();
		paramObj.page = orderDetail.page;
		paramObj.obj.orderId = order.obj.id;
		paramObj.obj.parentId = 0;
		paramObj.getOrderDetails2(fnc);		
	} 
}


function getOrderDetailTable(orderDetail,callBackFun){	
	mygrid.clearAll();
	var fnc = function(xml){
		//alert(xml);
		//test_start = new Date().getTime();//TimeDiff(test_start);
		mygrid.loadXMLString(xml,callBackFun);
		mygrid.loadSizeFromCookie();
		//TimeDiff(test_start);
//		callBackFun();
	}
	
	var orderId = orderDetail.obj.orderId
	if(orderDetail.obj.orderId == null) orderId = orderBackUp.id;
	
	if(isPackage == true){
		var orderDetailId = getOrderDetailByURL();
		var paramObj = new OrderDetail();
		paramObj.page = orderDetail.page;
		paramObj.obj.parentId = orderDetailId;
		paramObj.obj.loginUser = loginUserName;
		paramObj.getOrderDetailsForFztv(fnc);  
	}else{
		var paramObj = new OrderDetail();
		paramObj.page = orderDetail.page;
//		paramObj.obj.orderId = order.obj.id;
		paramObj.obj.orderId = orderId;
		paramObj.obj.parentId = 0;
		paramObj.obj.loginUser = loginUserName;
		paramObj.getOrderDetailsForFztv(fnc);
		
	} 
}


function getOrderDetailCompages(el){
//	var rowData = el.getAttribute("rowData");
	var rowData = el.rowData;
	var compagesId = rowData.compagesId;
	var resourceSort = rowData.resourceSortId;
	var id = rowData.id;
	if(resourceSort == 1 || resourceSort == 3) return false;

	orderDetail.reset();
	orderDetail.obj.parentId = id;
//	orderDetail.obj.resourceSortId = 1;
	orderDetail.getOrderDetails(orderDetail);
}


function getResource(event,fnct){
//		var resourceSort =  getSelectParamFromAttribute($("resourceSortId"),"paramvalue");
		resource.obj.resourceYear = order_year;
		resource.obj.carrierId  = event >0 ?event:$(carrier.selectName).value;
		resource.obj.orgId = orgId;
//		resource.obj.resourceSort = resourceSort;

		$(resource.selectName).value = 0;
		
//		getLowestRateAndAgentRate();
		
		//下面的if语句是为了实现广告资源随着启用与否来决定在新订单中是否出现.
		if(orderDetailStates!=1) {
			//非编辑订单只出现启用的资源
			resource.obj.enable =true;
		}else{
			//编辑订单出现全部的资源
			resource.obj.enable =null;
		}
		resource.makeSelectFromMap2(resource.obj,$(resource.selectName),fnct,"onResourceChange");
//	}
	
}



//广告资源改变的时候，重新获得价格
//
function onResourceChange(){
	

	var compagesId = $("compagesId").value;
	var resourceId = $(resource.selectName).value;
	var specificId = $("resourceSpecificId").value ;
	
	//if(orderDetail.obj.resourceInfoId != resourceId && orderDetailStates == 1){
	if(orderDetailBackUp.resourceInfoId != resourceId && orderDetailStates == 1){
        	//alert(resourceId);alert(orderDetail.obj.resourceInfoId);
        	isResChangedOnEdit = true;
        }else{
        	isResChangedOnEdit = false;
	}	 

	//alert(isResChangedOnEdit);
	orderDetail.obj.carrier.id = $(carrier.selectName).value;
	orderDetail.obj.resourceInfoId = resourceId ;
	
	

	if(config_signCompages ==1 && compagesId==-1){ 
		var ids = $("compages.resourceIds").value;
		resourceId = ids.substring(0,ids.indexOf(','))
//		orderDetailStates =1;   
		orderDetail.obj.resourceInfoId = resourceId ;
	}
	
   
	
	if(resourceId > 0 || compagesId > 0|| compagesId_new>0){
		
	//根据资源判断是否手动刊例价格
	//if(resourceId!="" && resourceId>0){checkIsManualPrice(resourceId);}

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
//		alert(1);
//		resetDayInfo(true);
//		alert(2);
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
	    
//	    if(resourceSort == 1 && resourceInfoId < 1) return false;
//	    if(resourceSort == 2 && compagesId < 1) return false;

	
	    
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
		
	
		getMonthInfos(isLock,rsId,specificValue,broArrange.startDate,broArrange.endDate,func);	
//		alert(3);
}


//通过广告位置和长度获得价格


function getSysPrice(noResetDestPrice,funcc){
	
//	alert('getSysPrice');
	
	var resourceSort =  getSelectParamFromAttribute($("resourceSortId"),"paramvalue");
	
//	 alert('compagesId_new>>>>>>>>>'+compagesId_new)
//	  alert('compagesId_new>>>>>>>>>'+$("compagesId").value)
	 
//	var resourceInfoId = $("resourceInfoId").value;
//	var compagesId = $("compagesId").value;
//	alert("resourceSort=="+resourceSort);
	if($("compagesId").value==-1){
		getSysPriceResource(noResetDestPrice,funcc);
//		 getSysPriceCompages(noResetDestPrice,funcc);
	}else{
	    
	  
		if($("btn_packeg").value == 2){
			 getSysPriceCompages(noResetDestPrice,funcc);
		}else{
			getSysPriceResource(noResetDestPrice,funcc);
		}
		
		
		
	}

	
//		alert(sysPrice);

} 

//手动修改刊例价格时，重新计算月价格
function setBroArrayangeMonthOnPriceChange(){
		broArrange.basePrice = $("sysPrice").value;
		broArrange.realPrice = $("execPrice").value;
		broArrange.setBroArrayangeMonthPrice();
}

function getSysPriceResource(noResetDestPrice,funcc){
	
//	var resourcePriceType = getSelectParamFromAttribute($("resourcePriceType"),"paramvalue");
//	
//		if(resourcePriceType == '0'){
//            
//				if(!noResetDestPrice){
////					$("sysPrice").value = 0;
////					$("execPrice").value = 0;
////					$("execPrice").disabled= false;	
//					
////					broArrange.basePrice = 0;
////				    broArrange.realPrice = 0;
//				
////					setBroArrayangeMonthOnPriceChange();		
//				}
//
//
//		return false;
//		
//	}
	//获得广告位置和广告长度的值
	var resourceInfoId = $("resourceInfoId").value;
	var compagesId = $("compagesId").value;
	if(config_signCompages == 1 && compagesId==-1){
		resourceInfoId = orderDetail.obj.resourceInfoId;
	}
	
	var adLength = $("matterLength").value*1;
	var priceTypeId = $("resourcePriceType").value;
	


	if (resourceInfoId > 0){
//		var callBackFun = function(obj){
//          
//		  	var sysPrice = price.getSysPriceByResId(resourceInfoId,adLength,priceTypeId);
//
//		  	if(!noResetDestPrice){
//		  		sysPrice = (sysPrice == null || sysPrice =="" )? 0: sysPrice;
//		  		if(sysPrice == 0){
//		  			priceRegular.getPriceRegularByName(resourceInfoId,priceTypeId,adLength,function(s){sysPrice = s;});
//		  		}
//			
//				$("sysPrice").value = sysPrice;
//				var isCal = getCalculateModel();
//				var execPrice = 0;
//				if(isCal){
//					 execPrice = getExecPrice(sysPrice);	
//				}else{
//					execPrice = 0;
//				}
//				$("execPrice").value = execPrice;
//				
////				execPrice = (execPrice == null || "" )? 0: execPrice;
////				sysPrice = (sysPrice == null || "" )? 0: sysPrice;
//				
//				broArrange.basePrice = sysPrice;
//				broArrange.realPrice = execPrice;
//			
//				if(funcc) funcc();		  		
//		  	}
//		  	
//		  	broArrange.basePrice = $("sysPrice").value;
//			broArrange.realPrice = $("execPrice").value;
//		  	
//		}
//
//		price.getPriceMap(resourceInfoId,adLength,callBackFun);	

			var callBackFun = function(sysPrice){
                   
		  	//var sysPrice = price.getSysPriceByResId(resourceInfoId,adLength,priceTypeId);
		  	// alert(sysPrice);

		  	if(!noResetDestPrice){
		  		sysPrice = (sysPrice == null || sysPrice =="" )? 0: sysPrice;
		  		sysPrice = sysPrice*1;
		  		if(sysPrice == 0 && compagesId != -1){
		  			priceRegular.getPriceRegularByName(resourceInfoId,priceTypeId,adLength,function(s){sysPrice = s;});
		  		}
			
				$("sysPrice").value = sysPrice;
				
				var isCal = getCalculateModel();
				
				var execPrice = 0;
				if(isCal){
					 execPrice = getExecPrice(sysPrice);	
				}else{
					execPrice = 0;
				}
				$("execPrice").value = execPrice;
				
//				execPrice = (execPrice == null || "" )? 0: execPrice;
//				sysPrice = (sysPrice == null || "" )? 0: sysPrice;
				
				broArrange.basePrice = sysPrice;
				broArrange.realPrice = execPrice;
			
				if(funcc) funcc();		  		
		  	}
		  	
		  	//broArrange.basePrice = $("sysPrice").value;
			//broArrange.realPrice = $("execPrice").value;
		  	
		}
		
 
		if(!noResetDestPrice){
//			alert(resourceInfoId);alert(adLength);alert(priceTypeId);
            //泉州台折扣特殊要求
	        getFavourRateForQZTV();

            if(compagesId == -1 && compagesId_new > 0){ 
            	compages.getPriceByLegth(compagesId_new,adLength,$("resourcePriceType").value,callBackFun)
            }else{
				price.getSysPriceByResId2(resourceInfoId,adLength,priceTypeId,callBackFun);	
            }

		}else{
//			 alert('priceTypeId>>>>>2>>>>>>>>>>'+priceTypeId)
		  	broArrange.basePrice = $("sysPrice").value;
			broArrange.realPrice = $("execPrice").value;
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
			var execPrice = 0;
			if(isCal){
				 execPrice = getExecPrice(sysPrice);	
			}else{
				execPrice = 0;
			}				
			
			$("execPrice").value = execPrice;
			
			broArrange.basePrice = sysPrice;
			broArrange.realPrice = execPrice;
		
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
    
	//alert(appRate);
	//alert(favourRate);	
	//alert(sysPrice);
	return ForDight(sysPrice,2);
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
//	var industryTypeId = $("industryTypeId").value;
	
	var industryTypeId =industry.treecombo.passField.getValue();
			
	$("favourRate").value = null;
//	var customerObj = customer.getCustomer(customerId);
//	$("industryTypeId").value = customerObj.industryTypeId;
//	agentInfo.obj.industryTypeId = $("industryTypeId").value;

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
	$("appRate").value = null;
	var specificId = $("resourceSpecificId").value;
	orderDetail.obj.resourceSpecificId = $("resourceSpecificId").value ;
//	orderDetail.obj.specific.position = getSelectParamFromText($("resourceSpecificId"),"||",2);
	orderDetail.obj.specific.position = getSelectParamFromAttribute($("resourceSpecificId"),"position");
	
	
	if(orderDetailBackUp.resourceSpecificId != specificId && orderDetailStates == 1){
        	//alert(resourceId);alert(orderDetail.obj.resourceInfoId);
        	isSpecifChangedOnEdit = true;
        	
        }else{
        	isSpecifChangedOnEdit = false;
	}	
	
	
	//alert(orderDetailBackUp.resourceSpecificId);
	//alert(specificId);


    function fnc(){
    	        var isNewOrderDetail = (orderDetailStates == 2||orderDetailStates == 3);
    	        //alert(isNewOrderDetail);
    	        backupBroarrayToCur(isNewOrderDetail,null,true);
        	//backupBroarrayToCur(isNewOrderDetail);
    }
			
	var getSpecificfun =  function(o){
		var specificRate = o.overRate;
		specificRate = (specificRate == 1 || specificRate ==100 || specificRate== null || specificRate=='') ? 0:specificRate*100;
		$("appRate").value = specificRate;
		//重新计算应收总价
		getSysPrice(false,fnc);
	}
	if (specificId > 0){
		specific.getSpecific(getSpecificfun,specificId);		
	}else{
	    getSysPrice(false,fnc);
	}
}

	
function getMatterObj(oDetail){

		var matterType = $("matterType").value;
		matterType = matterType =="" ?1:matterType;
		//alert(matterType);
		matter.reset();
		matter.obj.tapeCode = $("matter.tapeCode").value;
		matter.obj.name = $("matter.name").value;
		matter.obj.edit = $("matter.edit").value;
		matter.obj.length = $("matterLength").value;
		matter.obj.customerId =  Ext.getCmp('customerName').getValue();
		matter.obj.matterType = matterType;
//		matter.obj.brandId = $("industryTypeId").value; 
	
		matter.obj.brandId = industry.treecombo.passField.getValue();
		
		
		
		matter.obj.version = 0;
		matter.obj.enable = true;
		matter.obj.createBy = sessionUserId;
		matter.obj.orgId = orgId;
		//matter.obj.modifyBy = sessionUserId;
		
		//o.obj.matter = (new Matter()).obj;
		oDetail.matter = matter.obj;
		
//		alert(matter.obj.tapeCode);
//		alert(matter.obj.name);
//		alert(matter.obj.edit);
//		alert(matter.obj.length);
//		alert(matter.obj.customerId);

		
//   	}




}

function getOrderDetailObj(orderId){
	
	var isNewDetail = (orderDetailStates != 1) ?true:false;
	var isPackeg = ($("btn_packeg").value == 2) ?true:false;

	
    var obj = (new OrderDetail()).obj;

    DWRUtil.getValues(obj);

//    obj.order = orderObj;    
    
	var parentId = $("parentId").value;
	var startDate = broArrange.startDate;
	var endDate =   broArrange.endDate; 
    var appRate =  $("appRate").value ==""? 0: $("appRate").value;
    var ageRate =  $("ageRate").value ==""? 0: $("ageRate").value;
	var favourRate =  $("favourRate").value ==""? 0: $("favourRate").value;	
	
	obj.id = isNewDetail||isPackeg?null:orderDetailBackUp.id;    
	obj.version = order_year;    
	obj.orderDayInfos = saveOrderDayInfo();      
	obj.orderDetailBak = isNewDetail||isPackeg?{orderDetailBak:{orderDayInfos:new Array()}}:Object.clone(orderDetailBackUp);
	obj.isSaveOrderDayInfo = isSaveOrderDayInfo;
	

	
//	console.log(obj.orderDetailBak);

//	if(orderDetailStates == 2 || orderDetailStates == 3){
	broArrange.getBroArrangeStarEndDate(config_serviceDate); 	
	startDate = broArrange.broArrangeStartDate.value;
	endDate = broArrange.broArrangeEndDate.value; 		
//	}

	obj.orderId = orderId;
	obj.publishStartDate =  startDate;
	obj.publishEndDate =  endDate;

	obj.sumTimes = 0;  
	obj.resourceType = $("resourcePriceType").value;
	obj.publishMemo =$("dtPublishMemo").value;
	obj.isSpaceAdver =$("isSpaceAdver").checked;
	obj.createBy = 	sessionUserId;
	obj.modifyBy = sessionUserId;
	obj.industryTypeId = industry.treecombo.passField.getValue();
	obj.parentId = parentId =="" ? 0: parentId;
	
	obj.compages = (new Compages()).obj;
	obj.compages.resourceIds =$("compages.resourceIds").value.split(',');
	obj.compagesId = isPackeg?compagesId_new:0;
	
	obj.orderCategoryId =  Ext.getCmp('orderCategoryId').getValue();	
	obj.specific.position = getSelectParamFromAttribute($("resourceSpecificId"),"position");
	
	
	
		
	if($('resourceInfoId').value==0 && obj.compages.resourceIds!=0) obj.resourceInfoId = obj.compages.resourceIds[0];

	//根据付款分配应收
	var orderCategoryMain = getSelectParamFromAttribute($("categoryId"),"calculateauto");
	

	if(config_contractsort == 0){
		obj.orderCategoryMain = orderCategoryMain;
	}else{
		obj.orderCategoryMain = 1;
	}
	

	
	if(orderCategoryMain == 2){
		obj.resource = (new Resource()).obj;
		var ids = $("compages.resourceIds").value;
		if(ids != '' && ids != '0') {
			var sour = $("compages.pos").value;
			var i = sour.indexOf('||');
		    if (i > 0){ var c = sour.substring(i+2*1)};
			obj.resource.resourceType =  c;
		}else{
			obj.resource.resourceType = getSelectParamFromText($("resourceInfoId"),"||",2);
		}
	}
	
	
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
	//alert(obj.paymentId);
	//alert(obj.ageRate);
	//alert(obj.orderCategoryMain);
	//alert(parentId);
	//alert(obj.moneyRealpay);

	getMatterObj(obj);
	
	getOrderDetailPublic(obj);
	
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
//		alert(contractId);
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

	
	
	//popupcenter.url = urlStr;
	//popupcenter.model = 6;
	//popupcenter.popupcenter(popupcenter);

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
	//var urlStr = 'selectPopup/selectOrderLog.html?orderDetailId='+orderDetailId+'&winW='+winW+'&winH='+winH;
//	openWindow('mywin',urlStr,winW,winH,title,theme,draggable,minimize,maximize,close,resizable);
  var closeBtn ={text: '关闭',handler: function(){win.hide();}};
  
        
 var win = new Ext.Window({
   title : '付款信息',
   //maximizable : true,
   // maximized : true,
   width : winW,
   height : winH,
   // autoScroll : true,
   // bodyBorder : true,
   // draggable : true,
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
  win.show(); 	


}

function displaySumMoney_bak(){

	var sumTotal = window.prompt("总金额：","");

//	alert("sumTotal="+sumTotal);
	
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
		var moneyBalance = ForDight($("moneyBalance").value,2)
	     if(moneyBalance > 0)resetMoneyRealpay();	
}
function displaySumMoneyKeypress(ev){
		if(ev.keyCode == 13){
			var moneyBalance = ForDight($("moneyBalance").value,2)
	        if(moneyBalance > 0){
				resetMoneyRealpay();	
	        }
		}

}



//
//function autoBroArrangeSumMoney(orderId,moneyRealpay,sysPrice){
//	alert(10);
//	popupcenter.url = "selectPopup/balanceMoney.html?id=" + orderId+"&"+moneyRealpay+"#"+sysPrice;
//	popupcenter.model = 6;
//	popupcenter.popupcenter(popupcenter);
////	closePopup();
//}


function setOrderCategoryDef(){
	var orderCategorySelect = $("categoryId");
	if(config_orderModCategoryParam == $("categoryId").value) return false;

	var id = order.obj.id;
	//alert(id);
	var isNotEditMode = !(id > 0);
	if(isNotEditMode && config_orderModCategoryParam >0){
			orderCategorySelect.value = config_orderModCategoryParam;
			reloadOrderCategory1Store(); 	
	}	
//	initOrderCategory1();	
}






//检查订单状态
function checkOrderStates(msg,mode){
	//定单状态 不为0 和4
	var isCkecked = $("isCkecked").value;
	


	if(isCkecked != 0 && isCkecked != 4){
        //广告版本改变情况下也需要备份订单信息
//		if(checkMatterIsChanged()){
//			isSaveOrderDetail = true;
//			isSaveOrderDayInfo = false;
//			
//			if(config_isOpenOrderOrgParam == 1){
//				backup_orderInfo();
//				orderDetailStates = 1;	
//			}
//
//		}else{
//			isSaveOrderDetail = false;
//		}
		 
		 isSaveOrderDetail = false;
		 isSaveOrderDayInfo = false;
//			if((config_permitModAdverParam =="1" && mode !='edit')||config_allowModiyPassedOrderParam == 1){
//			    if(config_allowModiyPassedOrderParam == 1) isSaveOrderDetail = true;
//	         	return false;	
//		}else{	 


		if(config_allowModiyPassedOrderParam == 1){
			   var moneyIn =  $("orderPublic.moneyIn").value;
			   isSaveOrderDetail = true;
			   isSaveOrderDayInfo = true
			    if(moneyIn >0) isSaveOrderDayInfo = false;
	         	return false;	
		}else{
			if(isCkecked == 3){
				Ext.MessageBox.alert('系统提示',"订单审核状态为通过，"+msg +"<br>",function(){});         
//			 	alert("订单审核状态为 通过，"+msg);
			}else{
//			 	alert("订单处于审核过程中，"+msg);
			 	Ext.MessageBox.alert('系统提示',"订单处于审核过程中，"+msg+"<br>",function(){});         
			}        
			return true;	
		}		
	}else{
		return false;
	}
	
}

function saveOrderUnable(){
	

  
	//显示剩余时间时，不允许保存
//	if($("isDisplayLeavTimes").checked) {
//		alert("显示剩余时间状态下，不允许保存");
//		return true;
//	}
	//检查订单状态
//	return checkOrderStates('不允许保存','save');
	if(checkOrderStates('不允许保存','save')){
		return true;
	}
	
//	var isCkecked = $("isCkecked").value;
//	if(isCkecked != 0 && isCkecked != 4){
//		 if(isCkecked == 3){
//		 	alert("订单审核状态为 通过，不允许保存");
//		 }else{
//		 	alert("订单处于审核过程中，不允许保存");
//		 }
//		 
//		 return true;		
//	}
	
//	if(orderDetailStates != 5){
//		var broSumTime = $("broSumTime").value;
//		if(broSumTime < 1 || broSumTime == ''){
//			 alert("订单没有播出，不允许保存");
//			 return true;		
//		}
//	}



   
   
   
	var catMain = DWRUtil.getText("categoryId");
	var contractId = $("order.contractId").value;
	contractId = (contractId =='' ||contractId == '0')?null:contractId;

	if(catMain.indexOf("协约合同")!= -1 && contractId == null){
			 alert("订单类别为 协约合同，合同号为空，不允许保存");
			 return true;
	}
	if(catMain.indexOf("协约合同")!= -1 && contractId == null){
			 alert("订单类别为 协约合同，合同号为空，不允许保存");
			 return true;
	}
	
	if(catMain.indexOf("协议合同")!= -1 && contractId == null){
			 alert("订单类别为 协议合同，合同号为空，不允许保存");
			 return true;
	}
	if(catMain.indexOf("正常订单")!= -1 && contractId != null){
			 alert("订单类别为 正常订单，不需要合同号，不允许保存");
			 return true;
	}
	if(catMain.indexOf("协约订单")!= -1 && contractId != null){
			 alert("订单类别为 协约订单，不需要合同号，不允许保存");
			 return true;
	}
	
	

	   
	var contractCode = ($("contract.code").value).Trim();
	contractCode = (contractCode =='' ||contractCode == '0')?null:contractCode;
	if(contractCode != null && contractId == null){
		alert("请重新选择合同号!"); return true;	
	}	


   
	var resourceSort =  getSelectParamFromAttribute($("resourceSortId"),"paramvalue");
	var resourceInfoId = $("resourceInfoId").value;
	var compagesId = $("compagesId").value;
	compagesId = compagesId != "" && compagesId !=null ? compagesId:0;
	
	
	//时段、栏目
	if((resourceSort == 1 ||resourceSort == 3) && $("btn_packeg").value == 1 && resourceInfoId == 0 ){
		 alert("没选择广告位置,不允许保存！");
		 return true;			
	}
	

	 //套装 
	if($("btn_packeg").value == 2 && compagesId == 0 ){
		 alert("没选择广告位置,不允许保存！");
		 return true;			
	}	
	

	
		//检测磁带号 ,先判断是手动 还是自动
	if(config_adverCodeModelParam == '0'){
//		 return checkTapeCode();
		if(checkTapeCode()) return true;
	}
	

	  
	 
	//检测付款情况， paymentId  orderId
	if(contractId == null){
		var orderMoneyIn = $("orderPublic.moneyIn").value;
		orderMoneyIn = orderMoneyIn ==''|| orderMoneyIn ==null?0:orderMoneyIn;
		var msg;
		if(orderMoneyIn > 0){
			
			
			isSaveOrderDetail = true;
			isSaveOrderDayInfo = false;

			if(contractId == null){
				msg ="订单已平过帐,不能修改订单!";	
			}else{
				msg ="合同已平过帐,不能修改订单!";
			}
//			alert(msg); return true;
		}
	}else{
		var orderMoneyIn = $("contractPayment.moneyIn").value;
	    	if(orderMoneyIn >0){
	    		isSaveOrderDetail = true;
				isSaveOrderDayInfo = false;
	    		alert("财务已平过帐，要修改请通知财务!"); return true;
	    	}
	
	}
	
	
	
	  
//检测客户是否注册
	var customerName =  Ext.fly('customerName').dom.value; 
	var customerId =  Ext.getCmp('customerName').getValue();
//	alert('customerName>>>'+customerName +'customerId>>>>>>'+customerId);
	if(customerId == customerName){
		checkCustomer(1);
		return true;
	}
	
    return checkOrderSubCate(1);

}


function getOrderPublic(fun){
	order.getOrderPublic(fun,order.obj.id)
}


function savePayMent(isNew,isRemovePayment){
	

	    var payMoney = order.obj.orderPublic.moneyRealpay;
	    var resourceType = 0;
	    var orderMainType = getSelectParamFromAttribute($("categoryId"),"calculateauto");
	    
//	    if(isNew && tvNameParam=='xmtv') {
//	    	 resourceType= getSelectParamFromText($("resourceInfoId"),"||",2);
//	    }
	    
        if(isNew && orderMainType == '2') {
	    	 resourceType= getSelectParamFromText($("resourceInfoId"),"||",2);
	    }    			    
		    	
	    
	    var func = function(){
//	    	alert(isNew); 
	    	if(isNew  && orderMainType ==2) displayPayment();
	    }
	    
	   
	    //var isNew = (order.obj.id == null) ?true:false;
	    //alert(order.obj.id);
	    
	    if(tvNameParam=='xmtv'){
	    	if(isNew || orderMainType !=2 || $("orderPublic.moneyRealpay").value == 0){
	    		
//	    		var isNewPayment = orderPublicMoneyRealpay == 0 && $("orderPublic.moneyRealpay").value>0 ?true:false;
//               alert('contractId'+contractId);
	            if(isRemovePayment){
	            	 payMent.saveContractPaymentByOrder(0,order.obj.id,order.obj.customerId,0,isNew,resourceType,order_year,func);    
	            }else{
		 			var categroyName = order.obj.orderCategory.name;
			    	if(categroyName.indexOf("协约合同")>-1) return false;
			    	if(categroyName.indexOf("部门订单")>-1 && (order.obj.contractId !="0" && order.obj.contractId !="" && order.obj.contractId !=null)) return false;
			    	payMent.saveContractPaymentByOrder(order.obj.contractId,order.obj.id,order.obj.customerId,payMoney,isNew,resourceType,order_year,func);    
	            }
	    	}

	    }else{
            if(isRemovePayment){
            	 payMent.saveContractPaymentByOrder(0,order.obj.id,order.obj.customerId,0,isNew,resourceType,order_year,func);    
            }else{
	 			var categroyName = order.obj.orderCategory.name;
		    	if(categroyName.indexOf("协约合同")>-1) return false;
		    	//alert(order.obj.customerId);
		    	payMent.saveContractPaymentByOrder(order.obj.contractId,order.obj.id,order.obj.customerId,payMoney,isNew,resourceType,order_year,func);    
            }
	    }
            
       	
	   
}


function save_Order(){
	var Btn_save = $("Btn_save");
	Btn_save.disabled = true;
	

	
	otherFocus();
	
	var isPass = checkOrder();if(!isPass) {Btn_save.disabled = false;return false;};
	var isNewOder = (order.obj.id == null)?true:false;
    DWRUtil.getValues(order.obj);


	order.obj.orgId = orgId;
	order.obj.customerId =  Ext.getCmp('customerName').getValue();
	order.obj.isCkecked = isNewOder?"0":orderBackUp.isCkecked;
	order.obj.version = order_year;
	order.obj.contractId =  $("order.contractId").value;
	order.obj.categoryId =  $("categoryId").value;
	order.obj.userId = Ext.getCmp('userId').getValue();	
	order.obj.createBy = loginUserId;
	order.obj.modifyBy = loginUserId;
	order.obj.publishMemo ='';    
	 
    var resource_sort = getSelectParamFromAttribute($("resourceSortId"),"paramvalue");
    var customerCategoryId  = getValueFromStoreById(Ext.getCmp('customerName'),"customerCategoryId");
    
	order.obj.tempStr = orgId +","+ resource_sort +","+ customerCategoryId;
	
    var isOrderChanged = order.isChanged(orderBackUp,order.obj,_app_params.sysParam);
    
//    alert(isOrderChanged);

    if(isOrderChanged){
    	    var saveOrderFun = function(or){
    	    	 save_order_detail(or.id,isPass,isOrderChanged,isNewOder);
    	    }
    	    order.saveOrderReturnObj(order.obj,saveOrderFun);	
    }else{
    	    save_order_detail(orderBackUp.id,isPass,isOrderChanged,isNewOder);
    }

}

function save_order_detail(orderId,isPass,isOrderChanged,isNewOder){
	
	 
	
	 if(!isPass) return false;
	 
	 var isNewDetail = (orderDetailStates != 1) ?true:false;
	 
	 var orderDetail_obj = getOrderDetailObj(orderId);
	 
	 var resourceSort = getSelectParamFromAttribute($("resourceSortId"),"paramvalue");

	 var isOrderDetailChanged = orderDetail.isChanged(orderDetailBackUp,orderDetail_obj,_app_params.sysParam);
	 
	 function saveDetailFnc(detailId){save_orderDetail_fun(orderId,detailId); };
	 
	
	 if(isOrderDetailChanged) {
		//套装为2 
		 if($("btn_packeg").value == 2){
			orderDetail.saveOrderDetailsNew(orderDetail_obj,{
					　　callback:function(data){saveDetailFnc(data);},
					　　errorHandler:function(errorString, exception) { alert(errorString);	saveDetailFnc(orderDetailBackUp.id);}
		 			});
		 }else{

		 		orderDetail.saveOrderDetail(orderDetail_obj,
		 			{
					　　callback:function(data){saveDetailFnc(data);},
					　　errorHandler:function(errorString, exception) { alert(errorString);	saveDetailFnc(orderDetailBackUp.id);}
		 			}
				); 
		 }	 
	 }else{
		 saveDetailFnc(detailId);
	 }
}

function save_orderDetail_fun(orderId,id){

	var isNewOder = (orderId == null)?true:false;
	var isNewDetail = (orderDetailStates != 1) ?true:false; 
	var isPackeg = $("btn_packeg").value == 2?true:false;
	
	if(isPackeg){
	    id = id+'';
		var  indexId = id.indexOf('_');
		if(indexId!=-1){
				alert(id.substring(indexId+1));
				id = id.substring(0,indexId);     
		}
	}




		//判断是否翻页
//		isChangePage(isNewOder,isNewDetail);
		//通过当前orderId获得当前定单的所有定单明系
		function getDetailTableFun(){

			var rowIndex = mygrid.getRowIndex(id);
			
			drawColorOrderDetailTable(rowIndex);

			if(id >0){
				 save_payMent_fun(orderId,id);
			}else{
				 var curRowId = mygrid.getRowId(0);
				 if(curRowId >0) getOrderDetail(curRowId);
			}

//			 isResChangedOnEdit = false;
//			 isSpecifChangedOnEdit = false;
		}
	    
	    orderDetail.obj.orderId = orderId;
	    orderDetail.obj.id = id;
		getOrderDetailTable(orderDetail,getDetailTableFun);
		
		initMatterButton=true;
		initMatter();

}	


function save_payMent_fun(orderId,id){
	
	 function getPayMent(or){
	 	
	 	    setOrder(or); 
	 	    
            backup_cur_info(or,null,null);
            
            var orderPublicMoneyRealpay = (isUndefined(or.orderPublic))?0: or.orderPublic.moneyRealpay;
            
	 		var isNewPayment = orderPublicMoneyRealpay == 0 && $("orderPublic.moneyRealpay").value>0 ?true:false;
	        var isRemovePayment = (orderBackUp.contractId == 0 && $("order.contractId").value >0)?true:false;//订单类别由正常改协约 需要扫除原来的订单付款
			if(isNewPayment){
					savePayMent(true,false);
			}else{
					savePayMent(false,isRemovePayment);
			}	
			
			//在编辑状态下，并且启用历史记录功能,才保存订单修改日志
//			if(orderDetailStates == 1 && config_isOpenOrderOrgParam == 1 && orderDetailBackUp.id*1 > 0){
			if(orderDetailStates == 1  && orderDetailBackUp.id*1 > 0){
		        orderDetail.obj.order = order.obj;
		        var returnState = config_withoutSubmit == 1?0:4; 

		        orderDetail.saveOrderLog(orderDetailBackUp,orderDetail.obj,function(b){
		        
		        	if(b !=""){
		        		 var msg = "此订单审核状态从{"+ $("orderDetail_mod_states").value +"}=>{被退回}";
		        		 if(config_withoutSubmit == 1) msg = "此订单审核状态已改,需要重审,才可正常播出!";
		        		 
		        		 	 $("isCkecked").value = returnState;
		        		 	 var v = config_withoutSubmit == 1?"":"被退回";
		        		 	 $("orderDetail_mod_states").value = v; 
		        		 	 
		        		 getOrderDetail(id);	 
		        		 
		        		 Ext.MessageBox.alert('系统提示',msg,function(){});      
		        	}else{

		        		 getOrderDetail(id);	 
		        		 
//		        		 $("Btn_save").disabled = false;
		        	}  
		        	
		        	
		        });
			}else{
				getOrderDetail(id);
			}			

	        
	 };		

	 order.getOrderForEdit(orderId,getPayMent);	
}


//保存定单
function save_Order22222222(){

	var isPass = checkOrder();if(!isPass) {$("Btn_save").disabled = false;return false;}
	var orderPublicMoneyRealpay = (isUndefined(order.obj.orderPublic))?0: order.obj.orderPublic.moneyRealpay;
	var isNewOder = (order.obj.id == null)?true:false;
	var isNewDetail = (orderDetailStates != 1) ?true:false;
	var isNewPayment = orderPublicMoneyRealpay == 0 && $("orderPublic.moneyRealpay").value>0 ?true:false;
	var isRemovePayment = (orderBackUp.contractId == 0 && $("order.contractId").value >0)?true:false;//订单类别由正常改协约 需要扫除原来的订单付款

	otherFocus();

	function saveOrderDayInfosFun2(id){

	        $("Btn_save").disabled = true;

		//重新读取定单获得总次数	
		function savePayMentFun(orderPublic){

			    setOrderPublic(orderPublic);
			
				if(isNewPayment){
					savePayMent(true,false);
				}else{
					savePayMent(false,isRemovePayment);
				}	


          

			//在编辑状态下，并且启用历史记录功能,才保存订单修改日志
//			if(orderDetailStates == 1 && config_isOpenOrderOrgParam == 1 && orderDetailBackUp.id*1 > 0){
			if(orderDetailStates == 1  && orderDetailBackUp.id*1 > 0){
		        orderDetail.obj.order = order.obj;
		        var returnState = config_withoutSubmit == 1?0:4; 

		        orderDetail.saveOrderLog(orderDetailBackUp,orderDetail.obj,function(b){
		        
		        	if(b !=""){
		        		 var msg = "此订单审核状态从{"+ $("orderDetail_mod_states").value +"}=>{被退回}";
		        		 if(config_withoutSubmit == 1) msg = "此订单审核状态已改,需要重审,才可正常播出!";
		        		 
		        		 	 $("isCkecked").value = returnState;
		        		 	 var v = config_withoutSubmit == 1?"":"被退回";
		        		 	 $("orderDetail_mod_states").value = v; 
		        		 	 
		        		 getOrderDetail(id);	 
		        		 
		        		 Ext.MessageBox.alert('系统提示',msg,function(){});      
		        	}else{

		        		 getOrderDetail(id);	 
		        		 
//		        		 $("Btn_save").disabled = false;
		        	}  
		        	
		        	
		        });
			}else{
				getOrderDetail(id);
			}
			
		}
		
		
	    getOrderPublic(savePayMentFun);	    	
	    	
	    	
	} 
	

	var saveOrderDetailFun = function(id){
//		var checkedItem = Ext.getCmp('opt_package').getValue();
		 
		var  indexId = id.indexOf('_');
		if(indexId!=-1){
//		if(checkedItem.getGroupValue() == 2 && indexId!=-1){
			var arr=id.substring(indexId+1).split(',');
			var str='';
			for(var i=0;i<arr.length;i++){
				str+=arr[i]+'\n';
			}
			alert("未保存的资源段为：\n"+str);
			id = id.substring(0,indexId);     
		}
		orderDetail.obj.id =id;
//		orderDetail.setObject(obj);
//		orderDetail.obj.id = obj.id;
//		alert(orderDetail.obj.id);
//		alert(orderDetail.obj.matterId);
//		alert(orderDetail.obj.matter.tapeCode);
//		$("matter.tapeCode").value = orderDetail.obj.matter.tapeCode;

        

      
		
		//判断是否翻页
		

		isChangePage(isNewOder,isNewDetail);
		

		

		//通过当前orderId获得当前定单的所有定单明系
		
		function getDetailTableFun(){
			//var rowIndex = getEditRowIndexById(orderDetail.obj.id);
			
			
			var rowIndex = mygrid.getRowIndex(orderDetail.obj.id);
		
			
			drawColorOrderDetailTable(rowIndex);
//			if(fztvSpecialParam==0) 
//			lockDestopOrderDetail(false);
			//保存dayInfo信息
			//saveOrderDayInfosFun();
			if(id >0){
				 saveOrderDayInfosFun2(id);
			}else{
				 var curRowId = mygrid.getRowId(0);
				 if(curRowId >0) getOrderDetail(curRowId);
				 
			}
			
			
			 isResChangedOnEdit = false;
			 isSpecifChangedOnEdit = false;
		}
	
		getOrderDetailTable(orderDetail,getDetailTableFun);
			
	
	}	
	
    var saveOrderFun = function(obj){

    	if(!isSaveOrderDetail) return false;

    	 //给对象
    	 order.setObject(obj);

		//如果是新订单  必须反回 orderCode
		$("orderCode").value = obj.orderCode;
		$("customerId").value = obj.customerId; 
		$("relationCode").value = obj.relationCode;
//		order.obj.orderCategory.name = DWRUtil.getText("categoryId") ;


	    //保订单明系

        var orderDetail_obj = getOrderDetailObj(obj);
        

//         alert(orderDetail.obj.order.paymentId);

         if(config_allowModiyPassedOrderParam == 1){
         	
	         var orderCkeckState =  $("isCkecked").value;
	         

	         if(orderDetailStates != 1){
          
                var returnState = config_withoutSubmit == 1?0:4;
                var defMsg ="【系统自动】由于增加订单明细,";
	         	order.updateOrderStates2([order.obj.id],returnState,loginUserId,orderCkeckState,defMsg,function(){
	                     
	                     
		        		 var msg = "此订单审核状态从{"+ $("orderDetail_mod_states").value +"}=>{被退回}";
		        		 if(config_withoutSubmit == 1) msg = "此订单审核状态已改,需要重审,才可正常播出!";
		        		 
		        		     $("isCkecked").value = returnState;
		        		 	 var v = config_withoutSubmit == 1?"":"被退回";
		        		 	 $("orderDetail_mod_states").value = v; 
		        		 
		        		 Ext.MessageBox.alert('系统提示',msg,function(){});     
	         		
	         		
	         		
	         	});

	          }  
         }


//		 var checkedItem = Ext.getCmp('opt_package').getValue();
		 
//         $("basePosRadioId").checked
//		if(resourceSort==2 && checkedItem.getGroupValue() == 2){

		var resourceSort = getSelectParamFromAttribute($("resourceSortId"),"paramvalue");
		
		//套装为2 
		if($("btn_packeg").value == 2){
			 orderDetail.saveOrderDetailsNew(orderDetail.obj,saveOrderDetailFun);
		}else{
			orderDetail.saveOrderDetail(orderDetail.obj,saveOrderDetailFun);
		}
       
	
	//orderDetail.saveOrderDetailReturnObj(orderDetail.obj,saveOrderDetailFun);
		
//	disabledDestop();
    }
    

	
	
	//保存定单

	DWRUtil.getValues(order.obj);

	//order.obj.id = orderId;
	order.obj.isCkecked = isNewOder?"0":orderBackUp.isCkecked;
	order.obj.version = order_year;
	order.obj.contractId =  $("order.contractId").value;
	order.obj.orderCategory = (new OrderCategory()).obj;
	order.obj.orderCategory.name = DWRUtil.getText("categoryId") ;
	
	order.obj.userId = Ext.getCmp('userId').getValue();	
	order.obj.modifyBy = loginUserId;
	order.obj.orgId = orgId;
	
	
	
	order.obj.customerId =  Ext.getCmp('customerName').getValue();
	order.obj.customer = (new Customer()).obj;
	order.obj.customer.id  =   Ext.getCmp('customerName').getValue();	
	order.obj.customer.orgId = orgId; 
	order.obj.customer.customerName = Ext.fly('customerName').dom.value; 
//	order.obj.customer.customerCategoryId = Ext.getCmp('customerName').store.getAt(0).get('customerCategoryId');
    order.obj.customer.customerCategoryId = getValueFromStoreById(Ext.getCmp('customerName'),"customerCategoryId");
    
//    var resource_sort = $("resourceSortId").options[0].getAttribute("value");
    var resource_sort = getSelectParamFromAttribute($("resourceSortId"),"paramvalue");

    

//    var resource_sort = getSelectParamFromText($("resourceSortId"),"||",2);
    
	order.obj.tempStr = orgId +","+ resource_sort +","+order.obj.customer.customerCategoryId;
	

	
//	alert(order.obj.orderState.name);
//	alert(order.obj.tempStr); 

	
//	alert(Ext.getCmp('customerName'))
//	alert(Ext.getCmp('customerName').store.getAt(0))
//	alert(order.obj.customerId)
//	alert(Ext.getCmp('customerName').store.find('customerCategoryId',order.obj.customerId))
//	console.log(Ext.getCmp('customerName').store);
	
	
//	var record =  Ext.getCmp('customerName').store.getAt(0).get('customerCategoryId');
//	alert(record)
//	console.log(record);
//	var v = record.get('customerCategoryId'); 
//	alert(v)
	
	//保存订单前如果是新客户 需要提示信息 customerCategoryId
	
	
	
	if(config_useMoreCarrierSortParam == 1){
		 order.obj.customer.orgId = orgId;
	}else{
		 order.obj.customer.orgId = 1;
	}
//	order.obj.user =(new User()).obj;
//	order.obj.user.id = $("userId").value;
//	order.obj.user.fullName = DWRUtil.getText("userId");
	
	
	order.obj.createBy = sessionUserId;
	order.obj.modifyBy = sessionUserId;
	order.obj.publishMemo ='';          
	
	//订单的应付金额

    var isOrderChanged = order.isChanged(orderBackUp,order.obj,_app_params.sysParam);
    
    alert(isOrderChanged);
    
//    var isOrderDetailChanged = check_order_detail_info_change();
//    var isOrderDaysChanged = check_order_day_infos_change();
//    
//    if(isOrderChanged){
//		order.saveOrderReturnObj(order.obj,saveOrderFun);	
//    }else{
//		if(isOrderChanged){
//			 save_order_detail();
//		}else{
//		   if(isOrderDaysChanged){
//			  save_order_orderDays();
//		   }
//		}
//		
//    }
    order.saveOrderReturnObj(order.obj,saveOrderFun);	
	initMatterButton=true;
	initMatter();
	
}


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
	
}



function checkCustomer(aaa){
	
	var dialogcontent = $("dialogcontentDiv");
	var dialogcontentW = dialogcontent.offsetWidth;
	var dialogcontentH = dialogcontent.offsetHeight;
	var winW= dialogcontentW * 0.35;
	var winH = dialogcontentH*0.4;
	var customerName =  Ext.fly('customerName').dom.value; 
//	var customerName =  Ext.getCmp('customerName').getRawValue();
//	var customerName =  Ext.fly('customerName').dom.value
	var customerId =  Ext.getCmp('customerName').getValue();	


//	alert('customerId'+customerId);
//	alert('customerId'+$("customerId").value);
//	!isInteger(customerId) && 
	

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
								 	{title:'系统提示!',msg:"请选择客户类型!",width:300,heigth:200,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
						);  
			 	    	return false;
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
//			 	    	alert(id);
			 	    	inti_set_customer(1,id,cut.customerName,cut.customerCategoryId);
			 	    	order.obj.customerId = id;
						saveAreaCity(id);
//						saveLinkMan(id);
			 	    	regCustomerWin.hide();

			 	    	if(aaa == 1) save_Order();
//			 	    	alert(isSveOrder);
//			 	    	if(isSveOrder) save_Order();
//			 	    	
			 }	
			 
			 
			 function saveAreaCity(cutId){
			 	 		var areaCityId = Ext.getCmp('customterAreaCity').getValue();
			 	 		if(areaCityId >0) customerAddress.saveCustomerAddressFormOrder(cutId,areaCityId);
			 }
			 
			 function saveLinkMan(cutId){
			 	 		var linkmanName = Ext.getCmp('customterLinkMan').getValue();
			 	 		if(areaCityId >0) linkMan.saveLinkManFormOrder(cutId,linkmanName);
			 }			 
			 


    
     if(!regCustomerWin){
     	
     	  buildRegCustomer(winW,winH*0.8,customerName);

		  oaAreaCity.buildCommand("regCustomerAreaDiv","customterAreaCity",winW*0.2);
		  
//		  linkMan.buildTextField("regCustomterLinkManDiv","customterLinkMan",winW*0.2);

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
     	 
//     	 loadRegCustomerGrid(customerName);
     }

			var cmd1 =  Ext.getCmp('customterAreaCity');
			if(cmd1)cmd1.clearValue();   
//			var cmd3 =  Ext.getCmp('customterLinkMan');
//			if(cmd3)cmd3.clearValue(); 
//			alert(cmd3.emptyText);
//			alert(cmd3.blankText);
//			cmd3.markInvalid(cmd3.blankText);
//			if(cmd3)cmd3.clearValue(); 
//			if(cmd3)cmd3.setValue('');


 	regCustomerWin.show(); 	
 	
//			var customer = new Customer();
//			customer.obj.orgId = $("orgId").value;
//			customer.obj.customerName = $("customerName").value;
//			customer.getCustomerByObject(customer.obj,func);		
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
//	openWindow('mywin',urlStr,winW,winH,title,theme,draggable,minimize,maximize,close,resizable);
	
 var closeBtn ={text: '关闭',handler: function(){win.hide();}};
  
        
 var win = new Ext.Window({
   title : '修改记录',
   //maximizable : true,
   // maximized : true,
   width : winW,
   height : winH,
   // autoScroll : true,
   // bodyBorder : true,
   // draggable : true,
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
  win.show(); 		
	
	
	
	
	
	
	
}	
	
	
//删除按纽事件
function deleteOrderDetail(orderDetailId){
	orderDetailStates =5;
	var state = $("isCkecked").value;
	var moneyIn =  $("orderPublic.moneyIn").value;
	if(state ==1 || state ==2 || state ==3){
//		alert("订单已在审核状态，不能删除！");
		Ext.MessageBox.alert('系统提示','订单已在审核状态，不能删除！'+'<br>',function(){});     
		return false;
	}else{
		if(moneyIn >0 ){
//			alert("订单已平过帐，不能删除！");
			Ext.MessageBox.alert('系统提示','订单已平过帐，不能删除！'+'<br>',function(){});     
			return false;
		}
	
	}


	if(orderDetailId != orderDetailBackUp.id) return false;
	if(!confirmDelete("")) return false;
	
	
//	
//
////	var orderDetailId = deleImg.getAttribute("paraId");
//  	var startDate = myDate.getStartDay($("broArrangeStartDate").value);
//	var endDate = myDate.getEndDay($("broArrangeEndDate").value);  
////Ext.MessageBox.confirm(
//
//	broArrange.cleanBroArrange();
//	
//	order.obj.orderCategory.name = DWRUtil.getText("categoryId") ; 
//
//	orderDetail.obj.orderDayInfos = saveOrderDayInfo();
//	
//	getOrderDetailObj();
//	
//	orderDetail.obj.publishStartDate =  startDate;
//	orderDetail.obj.publishEndDate =  endDate;	  
//	orderDetail.obj.id = orderDetailId;
//	orderDetail.obj.order = (new Order()).obj;
//	
//	
//	
//	orderDetail.obj.order.contractId = order.obj.contractId;
//	orderDetail.obj.isSaveOrderDayInfo = isSaveOrderDayInfo;
//	orderDetail.obj.order.paymentId = $("paymentId").value;
     
     
   	var removeFun = function(){
// 	    Ext.getBody().mask('数据加载中……', 'x-mask-loading');
 		var curRows = mygrid.getRowsNum(); 
 		var page = orderDetail.page;
 		var curRowIndex  = orderDetailId > 0 ? mygrid.getRowIndex(orderDetailId):0;
 		curRowIndex = curRowIndex == curRows-1? curRowIndex -1:curRowIndex;
 		mygrid.deleteSelectedItem();
		curRows--;
		orderDetail.reset();
		//判断是否翻页
//		if(curRows == 0 && page.pageIndex > 1) page.pageIndex--;
//		isChangePage(false,false);
		
		function getFun(){
			getDetailTableFun(curRowIndex);
		}
		getOrderDetailTable(orderDetail,getFun);
    }   

    orderDetail.obj =  getOrderDetailObj(orderBackUp.id);
    orderDetail.obj.id = orderDetailId;
    orderDetail.obj.isLastDetail = (mygrid.getRowsNum()== 1);
	orderDetail.removeOrderDetail3(removeFun);

		
	function getDetailTableFun(curRowIndex){
	   	    
	   		//获得第一行id的值，并激发鼠标点击事件
			resetOrderDetail(false);
			resetDayInfo(true);
			
			if(orderDetail.obj.isLastDetail || curRowIndex ==-1) return false;
			
			var nextRowId  = mygrid.getRowId(curRowIndex);

			if(nextRowId > 0){
				getOrderDetail(nextRowId);
			}else{
				orderDetailStates = 2;
//				getCustomerAutoComplt();
			}
			
			
			//重新读取定单合计信息
			function savePayMentFun(orderPublic){
				
				order.obj.orderCategory.name = DWRUtil.getText("categoryId") ;
				setOrderPublic(orderPublic);
				savePayMent(false,false);
				orderDetailStates = 0;
			}
		      
	    	getOrderPublic(savePayMentFun);
	    
//			if(fztvSpecialParam==0) 
//			lockDestopOrderDetail(false);
	   	
	   }
		


}


//翻页处理
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == orderDetail.pageInfo){
		var page = new Page(orderDetail.pageInfo,orderDetail.pageSize);
		page.goNextPage(pageIndex);
		orderDetail.page = page;
		var fuc =function(){
			     var firstRowId = mygrid.getRowId(0);
			     if(firstRowId > 0)  getOrderDetail(firstRowId);
			     //var rowIndex = mygrid.getRowId(0);
	                     drawColorOrderDetailTable(0);
		}
		//orderDetail.reset();
		//orderDetail.obj.orderId = order.obj.id;
		//getOrderDetailTable(orderDetail,function(){});
		getOrderDetailTable(orderDetail,fuc);
	}
	if(pageInfoName == order.pageInfo){
		var page = new Page(order.pageInfo,order.pageSize);
		page.goNextPage(pageIndex);
		order.page = page;
		getOrderTable(order);
	}
}
//判断是否翻页	
function isChangePage(isNewOrder,isNewDetail){
	
	//var trs  = mygrid.getRowsNum();;
	//var trs = $(orderDetail.fillObjName).getElementsByTagName("tr");
	var curRows = mygrid.getRowsNum(); 
	var size = orderDetail.page.size*1;
         
	if((isNewOrder||isNewDetail) && orderDetail.page.pageIndex > 0){
		orderDetail.page.size = size + 1;
		orderDetail.page.pageIndex = orderDetail.page.getPageCount();
	}
	
	if(curRows == 0 && orderDetail.page.pageIndex > 1){
		
		orderDetail.page.size = size - 1;
    	
	}
} 

//通过id获得行索引
//function getEditRowIndexById(id){
//	
//	if(id == false) return false;
//	var trs = $(orderDetail.fillObjName).getElementsByTagName("tr");
//    var trnum = trs.length;  
//    var rowIndex = 0;
//    for (var i = 0;i<trnum;i++){
//       if(trs[i].getAttribute("detailRowId")*1 == id*1)
//       		rowIndex = i;	
//    }
//    return rowIndex;
//}
//获得明细表第一行的id;
function getFirstRow(tableObj){
	var firstRow = tableObj.firstChild;
	if(firstRow == null) return false;
	var firstRowId = firstRow.getAttribute("detailRowId"); 
	return firstRowId;	
}
//点击行时改变颜色
function drawColorOrderDetailTable_bak(rowIndex){
		
     var trnum = mygrid.getRowsNum();
     var cssText;
     var cssTextSelected = "BACKGROUND-COLOR:#CCCCCC;CURSOR: pointer;";
     for (var i = 0;i<trnum;i++){
          if(i%2 == 0){
          	cssText = "BACKGROUND-COLOR: white;CURSOR: pointer;";
          }else{
        	cssText = "BACKGROUND-COLOR: #eee;CURSOR: pointer;";
	  }
	  var rowId = mygrid.getRowId(i);
	  mygrid.setRowTextStyle(rowId,cssText);	
     }	
     
     if(trnum>0){
          var curRowId = mygrid.getRowId(rowIndex);
	     //alert(curRowId);
	     mygrid.setRowTextStyle(mygrid.getRowId(rowIndex),cssTextSelected);	
     }
}


function drawColorOrderDetailTable(rowIndex){
	if(rowIndex == -1) rowIndex = 0;
     var trnum = mygrid.getRowsNum();
     if(trnum>0){
	    var curRowId = mygrid.getRowId(rowIndex);
	    mygrid.setSelectedRow(mygrid.getRowId(rowIndex));
     }
}



//新添定单
function addNewOrder(){
	
	if(orderBackUp.id == null){
		 alert("您当前处于新添状态，无法新添!");
		 return false;
	}
	

	close_OrderDetails();
	get_cur_year();
	orderDetailStates = 2;	
	resetOrder();
	resetOrderDetail(true);
	resetDayInfo(true); 
	
	

    	//getCarrierSelect();
	getMatterLengthComplt();
	
  
	$("categoryId").value = 1;

	

	//封锁
//	lockDestopOrder();
	lockDestopOrderDetail(true);
//	if(fztvSpecialParam==0)
//	lockedByState();
//	disabledDestop();
	
	$("customerId").value = null;
	closeBroArrangeDiv();
//	getCustomerAutoComplt();
	getContarctAuto();
	initMatterButton=true;
	initMatter();

	init_order_cate_main();
	init_resourceSpeci();
	
//	var resourceSort =  getSelectParamFromAttribute($("resourceSortId"),"paramvalue");
//	init_resourceCarrier();
	
//	init_resourceInfo();
	setOrderCategoryDef();
	
	
	
//	orderDetail.page = new Page(orderDetail.pageInfo,orderDetail.pageSize);
//	$(orderDetail.page.pageInfo).innerHTML ="没有找到记录";
	
}

//新添定单明系
function addnewOrderDetail(){
	orderDetailStates = 2;
	otherFocus();
	displaySumMoney();
	closeBroArrangeDiv();
	close_OrderDetails();
	resetOrderDetail(false);
	resetDayInfo(true);
//	lockDestopOrder();
	lockDestopOrderDetail(true);
	
//	disabledDestop();
	initMatterButton=true;
	init_order_cate_main();
	initMatter();
//	init_resourceInfo();
	init_resourceSpeci();
//	if(fztvSpecialParam == 0 || tvNameParam!='xmtv'){
//	init_resourceCarrier(false,1);
//	}
	getMatterLengthComplt();
}
//取消
function cancelOrder(){

	var srcStr = window.location.href;

//	 parent.location.href =document.referrer;
	 
//	if(srcStr.indexOf('orderPublicForm.publishStartDate')>-1){
//			 parent.location.href =document.referrer;
//	}else{
//		    var ctxPath = $("ctxPath").value;
			var pos = srcStr.indexOf("?");
			var paramStr = srcStr.substring(pos+1);
			var paramObj =  $H(paramStr.toQueryParams());
			paramObj.set("id",order.obj.id);
//			paramObj.id = order.obj.id;
//			paramObj.cutCates = getValueFromStoreById(Ext.getCmp('customerName'),"customerCategoryId");

//	         alert(paramObj.toQueryString());
//	         alert($H(paramObj).toQueryString());
	         self.location =   ctxPath + "orders.html?" + paramObj.toQueryString();
//	        self.location =   ctxPath + "orderListNew.html?" + $H(paramObj).toQueryString();

//	}


}
//新添并粘贴
function addAndPostOrderDetailt_bak(event){
	orderDetailStates = 3;
	var specific = $("resourceSpecificId").value;
//	if(specific > 0) {alert("有指定不能使用粘贴功能"); return false;}
		
	
	//只清空定单明系的id
	//$("dt_orderDetailId").value = null;

	var obj ={
		id:null,
		orderPublic:{
			publishStartDate:detailBackUp.orderPublic.publishStartDate,
			publishEndDate:edetailBackUp.orderPublic.publishEndDated
		},
		specific:{position:orderDetailBackUp.specific.position},
		orderDayInfos:new Array()
	};

	
	orderDetailBackUp = obj;
	//清空datInfo
	resetDayInfo(false);
	if(specific > 0){
		broArrange.addAndPost(true);		
	}else{
		broArrange.addAndPost(false);
	}

//	getLowestRateAndAgentRate();
	//解锁
//	$("broSumTime").value = 0;
//	lockDestopOrderDetail(true);
	
//	disabledDestop();
	
	resetMoneyRealpay();
	initMatterButton=true;
	initMatter();
}


function addAndPostOrderDetailt1(event){
	postOrderDetailt(true);
}
function addAndPostOrderDetailt2(event){

	postOrderDetailt(false);
	
}

//function resetOrderDetailBackUp(event){
//	var obj ={
//		id:null,
//		orderPublic:{
//			publishStartDate:detailBackUp.orderPublic.publishStartDate,
//			publishEndDate:edetailBackUp.orderPublic.publishEndDated
//		},
//		specific:{position:orderDetailBackUp.specific.position},
//		orderDayInfos:new Array()
//	};
//
//	orderDetailBackUp = obj;
//}







function postOrderDetailt(isNoBroArrange){

	close_OrderDetails();
	
	if(orderBackUp.id == null){
		 alert("您当前处于新添状态，无法复制!");
		 return false;
	}

	if(orderDetailBackUp.id == null){
		    var id = mygrid.getSelectedId();
		 	if(id > 0) {
		 		 getOrderDetail(id);
		 		 alert("您当前处于新添状态，系统先要恢复原有的信息!");
		 	}else{
		 		alert("请您先选择要复制的行!"); return false;
		 	}
	}	
	
	
	
	
	orderDetailBackUp = (new OrderDetail()).obj;
//	orderDetailBackUp.orderDayInfos = new Array(); 
//
//	  var order_Day_Info = (new OrderDayInfo()).obj;

	if(!isNoBroArrange){

//		 $("Btn_save").disabled = true;	
		 var Btn_save =$("Btn_save");
//		 var Btn_addAndPost1 =$("Btn_addAndPost1");
		 var Btn_addAndPost2 =$("Btn_addAndPost2");
		 
		 if(!isUndefined(Btn_save)) Btn_save.disabled = true;
//		 if(!isUndefined(Btn_addAndPost1)) Btn_addAndPost1.disabled = true;
		 if(!isUndefined(Btn_addAndPost2)) Btn_addAndPost2.disabled = true;
//		 $("Btn_addAndPost1").disabled = true;	
//		 $("Btn_addAndPost2").disabled = true;
		 	
	}
	
	orderDetailStates = 3;
	init_order_cate_main();
//	init_resourceInfo();
//	init_resourceSpeci();
	
//	if(fztvSpecialParam == 0 || tvNameParam!='xmtv'){
//    var parentId = $(carrier.selectName).value;
//    function fnct(){
//    	 $(carrier.selectName).value = parentId;
//    }
//    
//	init_resourceCarrier(fnct);
//	}
//	init_resourceCarrier();
	
	getMatterLengthComplt();
	closeBroArrangeDiv();
	otherFocus();

//	lockDestopOrderDetail(true);
    
   
	backupBroarrayToCur(true,null,true,isNoBroArrange);
	
	lockDestopOrderDetail(true);
	
}



//防止 keypress space
function otherFocus(){
	$("dayUsedTime").focus();	
}


function backupBroarrayToCur(newDetail,callfun,isCleanBroArrange,isNoBroArrange){

//	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	
	//把订单明细编号清空，getMonthInfos才能初试为新订单，否则会认为修改状态
//	if(newDetail) orderDetailBackUp ={id:null};
	$("Btn_save").disabled = true;//开始排期时将保存按钮锁定
	var broArray = broArrange.copyTimesFromTargToArray();
		
	var func = function(){

		if(isCleanBroArrange) broArrange.cleanBroArrange();
		
		if(isNoBroArrange) {if(!isUndefined($("Btn_save"))) $("Btn_save").disabled = false;return false;}//[复制广告]完成将保存按钮恢复,因为[复制全部]在下面已经恢复了保存按钮，所以改动这一处即可；
		
		var ev = Event; ev.type ="keydown" ;
		//var keycodes = new Array(48,49, 50, 51, 52, 53, 54, 55, 56, 57);
		
		var trs = broArrange.targ.getElementsByTagName("tr");
		
	   	var k = 0;
		for(var i = 0; i< trs.length;i++){
			var cells = trs[i].cells;
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
		

		
		if(!isNoBroArrange){
//			 $("Btn_save").disabled = false;
//			 $("Btn_addAndPost1").disabled = false;	
//			 $("Btn_addAndPost2").disabled = false;	
		 var Btn_save =$("Btn_save");
//		 var Btn_addAndPost1 =$("Btn_addAndPost1");
		 var Btn_addAndPost2 =$("Btn_addAndPost2");
		 
		 Btn_save.disabled = false;
//		 Btn_addAndPost1.disabled = false;
		 Btn_addAndPost2.disabled = false;			 
			 
			 
		}
		
		var detailSumTimes = $("broSumTime").value;
		if(callfun) callfun(detailSumTimes);
		
//		 Ext.getBody().unmask();
	
	
		
	}
	
	var rsId =$("resourceInfoId").value;
	var specificValue = getSelectParamFromAttribute($("resourceSpecificId"),"position");
    var isLock = false;
	getMonthInfos(isLock,rsId,specificValue,broArrange.startDate,broArrange.endDate,func);	
}



//检测是否有空值
function checkOrder(){ 
	

		
	if($("categoryId").value == 0){alert("定单类别为空!不允许保存!");return false;}
	
//	if(Ext.fly('customerName').dom.value == ''||Ext.fly('customerName').dom.value == '请选择...'){alert("客户名称为空!不允许保存!");return false;}
//    var customerName =   Ext.fly('customerName').dom.value; 
//    var customerId = Ext.getCmp('customerName').getValue();	
//    if(customerId == customerName || customerId ==''){alert("客户名称为空!不允许保存!");return false;}
	if(Ext.getCmp('customerName').getValue() == ''){alert("客户名称为空!不允许保存!");return false;}
//	if($("userId").value == 0){alert("用户为空!不允许保存!");return false;}

    var userName =   Ext.fly('userId').dom.value; 
    var uid = Ext.getCmp('userId').getValue();	
    if(uid == userName || uid =='') {
    	alert("没有选择业务员,不允许保存!");
    	Ext.getCmp('userId').onTriggerClick();
    	return false;
    	}
//	if(Ext.getCmp('userId').getValue() == ''){alert("没有选择业务员,不允许保存!");return false;}
	
//	if($("orderCategoryId").value == 0){alert("定单子类别为空!不允许保存!");return false;}
//    var orderCategoryName =   Ext.fly('orderCategoryId').dom.value; 
//    var orderCategoryId = Ext.getCmp('orderCategoryId').getValue();	
//    if(orderCategoryId == orderCategoryName || orderCategoryId =='') {alert("定单子类别为空,不允许保存!");return false;}

    if(Ext.getCmp('orderCategoryId').getValue() == ''){alert("定单子类别为空!不允许保存!");return false;}
	
	if(config_adverCodeModelParam == '0'){
		if($("matter.tapeCode").value == ""){alert("磁带号为空!不允许保存!");return false;}
	}
	if($("matter.name").value == ""){alert("广告名称为空!不允许保存!");return false;}
//	if($("matterLength").value == 0){alert("广告长度为空!不允许保存!");return false;}
	if($("matterLength").value == '') $("matterLength").value = 0;
//	if($("sysPrice").value == 0){alert("没有刊例价,不允许保存,请与系统管理员联系!");return false;}
	
//	if($("industryTypeId").value == 0){alert("行业类别为空!不允许保存!");return false;}


	
	if(industry.treecombo.passField.getValue() == 0) {alert("行业类别为空!不允许保存!");return false;}
	
//	if(resource_sort ==''){alert("系统出错,由于不能找到广告资源类型，如{时段、栏目}");return false;}
	
	
	
	if(!price.isPass($("favourRate").value,$("lowestRate").value)) {
		alert("低于最低折扣!不允许保存!");return false;
	}

//	if($("carrierId").value == 0){alert("广告载体为空!不允许保存!");return false;}
//	if($("resourceInfoId").value == 0){alert("广告位置为空!不允许保存!");return false;}
     
     

	if(saveOrderUnable()) return false;
	

	return true;
}

function checkTapeCode(){
	var isBug = false;
	var curtapeCode = $("matter.tapeCode").value;
	curtapeCode = curtapeCode == ""?null:curtapeCode;
	
	matter.reset();
	matter.obj.name = $("matter.name").value;
	matter.obj.edit = $("matter.edit").value;
	matter.obj.length = $("matterLength").value;
	var obj =  matter.getMatterByNameVerLen(matter.obj);

	if(obj != null){
		obj.tapeCode = obj.tapeCode == ""?null:obj.tapeCode;
		if(curtapeCode != obj.tapeCode && obj.tapeCode != null){
			alert("磁带号有冲突,正确的合同号为:["+ obj.tapeCode +"],系统为您自动修正");isBug = true;
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
					alert("磁带号有冲突,请重新输入新的磁带号!");isBug = true;
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
	if(config_orderContractParam == '0'){
		$("orderPublic.moneyRealpay").disabled= true;	 
	}  
	
//	alert(config_addCustomerInOrderParam);
	if(config_addCustomerInOrderParam == '1'){
//		$("customer.customerName").removeAttribute("readonly");
//		Ext.fly('customerName').dom.readOnly = false;
//        Ext.getCmp('customerName').readonly = false;
	}
	
	if(config_autoRelationCodeParam == '1'){
//		$("relationCode").readonly= true;	 
	}
	
	
	
//	if(fztvSpecialParam ==0 || tvNameParam!='xmtv'){
	$("moneyRealpay").disabled= true; 
//	}
	
	$("sysPrice").disabled= true;	 
	$("execPrice").disabled= true;	
//	$("favourRate").disabled= true;   
	$("ageRate").disabled= true;
	$("moneyBase").disabled= true;
    $("orderCode").disabled= true;

	
	//$("contract.code").disabled= true;
	 $("order_year").disabled= true;
	 
	 if(config_useLanmuSingleParam == 0) $("resourceSortId").disabled = true;


    //订单保存权限
    if(!tag_orderDetail_save){
    	$("Btn_addNewOrder").hide();
    	$("Btn_addNewAdver").hide();
    	$("Btn_addAndPost2").hide();
    	$("Btn_change_matter_brotime").hide();
    	$("Btn_save").hide();
    }

	

//	$("orderMoneySum").disabled= true;
//	$("resourcePriceType").disabled= true;
}
////封锁控制，通过总次数来判断
function lockDestopOrder(){
//  var orderSumTimes = DWRUtil.getValue("orderPublic.times");
////   var orderId = $("dt_orderId").value;
////   orderId = orderId ==''?0:orderId;

//  alert(orderSumTimes);
//
//  
//   
//   //var rows = orderDetail.tBody.rows;
//   var rows = mygrid.getRowsNum();
//   
//   $("customer.customerName").disabled= "true";
//   
//   
//  
////   if($("orderCode").value == '') {
////   	$("order_year").disabled= false;
//////   	$("contract.code").disabled= false;
////   }else{
////        $("order_year").disabled= true;
//////        $("contract.code").disabled= true;
////   }
//   
//
//   if (rows > 0){
//   	  $("contract.code").disabled = "true";
//   	  $("categoryId").disabled= "true";
//   	  $("contract.code").disabled= "true";
//   	  $("customer.customerName").disabled= "true";
//   	 // $("relationCode").disabled= "true";
//   }else{
//   	  $("contract.code").removeAttribute("disabled");
//      $("categoryId").removeAttribute("disabled");
//      $("contract.code").removeAttribute("disabled");
//      //$("relationCode").removeAttribute("disabled");
//      $("customer.customerName").removeAttribute("disabled");	
//     // $("relationCode").disabled= false;  
//   }
//   
//   
//	
//   
// function lockOrder(lock){
//	// var rows = orderDetail.tBody.rows;
//	 var rows = mygrid.getRowsNum();
//	 
//	 //alert(11111111);
//	 
//	 if (lock){
//	 	$("customer.customerName").disabled= "true";
//	 	$("relationCode").disabled= "true";
//	 	$("categoryId").disabled= "true";
//		$("orderPublic.moneyRealpay").disabled= "true";
//		$("userId").disabled= "true";
////		$("orderMeno").disabled= "true";
//		$("contract.code").disabled= "true";
//	 }else{
//	 	$("customer.customerName").removeAttribute("disabled");
//	 	$("relationCode").removeAttribute("disabled");
//	 	$("categoryId").removeAttribute("disabled");	
//	 	$("contract.code").removeAttribute("disabled");
//		$("orderPublic.moneyRealpay").removeAttribute("disabled");
//		$("userId").removeAttribute("disabled");
////		$("orderMeno").removeAttribute("disabled");
//	 }
//	 
//   if (rows > 0){
//   	  $("categoryId").disabled= "true";
//   	  $("contract.code").disabled= "true";
//   }else{
//      $("categoryId").removeAttribute("disabled");
//      $("contract.code").removeAttribute("disabled");	  
//   }
//   
//
//}  
//   
//	if($("contract.code") != ''){
//		$("orderPublic.moneyRealpay").disabled= true;	 
//	}else{
//		$("orderPublic.moneyRealpay").disabled= f;	 
//	}
   
}

function lockOrderDestop(unlock,catMain){
	var rows = mygrid.getRowsNum();
    if(rows>1){
    	$("categoryId").disabled= "true";
    	$("contract.code").disabled= "true";

        if(catMain.indexOf("协约合同") > -1 || catMain.indexOf("部门订单")>  -1){
            Ext.getCmp("customerName").disable();
        }else{
        	if(unlock){
        		Ext.getCmp("customerName").enable(); 
        	}else{
        		Ext.getCmp("customerName").disable();
        	}
        }
        
        
    }else{
    	$("categoryId").removeAttribute("disabled");
    	$("contract.code").removeAttribute("disabled");
	    if(unlock) Ext.getCmp("customerName").enable();
    }
 	 	 
}

//封锁控制，通过每一条定单明系的次数来判断
function lockDestopOrderDetail(forceUnlock){
	

	var broSumTime = $("broSumTime").value;
	broSumTime = broSumTime ==''?0:broSumTime;
	var catMain = DWRUtil.getText("categoryId");
	var isCkecked = $("isCkecked").value;

	//隐藏按钮，如果是强制保存不需要检测
	if(config_allowModiyPassedOrderParam == 0){
   	 	lockedByState(isCkecked);
	}
	
	
	
    lockOrderDestop(forceUnlock,catMain)
    

//	BroArrange.isLocked = forceUnlock;		

   if (forceUnlock ){
   	

   	   $("btn_packeg").disabled= false;
   	
   	    $("Btn_addNewAdver").show();
   	    $("Btn_addAndPost2").show();
     	$("Btn_save").show();
     	$("Btn_change_matter_brotime").show();
   	
//   	    broArrange.lockBroArray(false); 
   	    
   	    
   	    
//  	    var orderSumTimes = DWRUtil.getValue("orderPublic.times");
  	    var orderSumTimes = $("resourcePriceType").value;
  	    
        if(orderSumTimes == 0){
        	$("categoryId").disabled= false;
//        	broArrange.lockBroArray(false); 
        }
   	
	  	if(loginUserName =='admin'){
			$("orderCode").disabled= false;
		}	   	
   	
   	
      $("orderPublic.moneyRealpay").removeAttribute("disabled");
//   	  $("orderMeno").removeAttribute("disabled");
      $("relationCode").removeAttribute("disabled");
      $("autoBroArrange").removeAttribute("disabled");
      $("cleanBroArrange").removeAttribute("disabled");
      $("resumeBroArrange").removeAttribute("disabled");
      $("addBroArrange").removeAttribute("disabled");

//	  if( tvNameParam=='xmtv'){
	  		$("moneyRealpay").removeAttribute("disabled");  
	  		$("carrierName").removeAttribute("disabled");
//	  }
	  
	  if(config_signCompages ==1){
	  	$("resourceSortId").removeAttribute("disabled");
	  	$("carrierName").removeAttribute("disabled");
	  }

//      $("customer.customerName").removeAttribute("disabled");
//      $("userId").removeAttribute("disabled");	
       Ext.getCmp("userId").enable();


      $("matterLength").removeAttribute("disabled");
//      $("industryTypeId").removeAttribute("disabled");
//       Ext.getCmp("industryTree").enable();
       industry.treecombo.enable();

      //if(broSumTime ==0){
	     // $("resourceSortId").removeAttribute("disabled");
	      $("carrierId").removeAttribute("disabled");
	//}
	
	
//       if(catMain.indexOf("正常订单")!= -1 ||mygrid.getRowsNum()==1){
//       	$("categoryId").removeAttribute("disabled");
//       	$("contract.code").removeAttribute("disabled");
       	 //$("customer.customerName").removeAttribute("disabled");
//       }
//       	   alert(222222)
       	   
//       if(catMain.indexOf("正常订单")!= -1 || catMain.indexOf("协约订单")!= -1|| catMain.indexOf("部门订单")!= -1){
//       	 $("customer.customerName").removeAttribute("disabled");
//       	 	Ext.fly('customerName').dom.removeAttribute("disabled");
//       	 	Ext.fly('customerName').dom.disabled = false;	
//       	 	 Ext.getCmp("customerName").enable();
//       }
       
       

//       if(resourcePriceType == '0')    $("execPrice").disabled= false;	
    
       
       
//      $("orderCategoryId").removeAttribute("disabled");
//      Ext.fly('orderCategoryId').dom.disabled = false;	
//      orderCategory1.orderCategoryCommand.enable();
      Ext.getCmp("orderCategoryId").enable();
      
      
      $("resourceInfoId").removeAttribute("disabled");
      $("resourceSpecificId").removeAttribute("disabled");	
      $("favourRate").removeAttribute("disabled");
      $("appRate").removeAttribute("disabled");	 
      $("resourcePriceType").removeAttribute("disabled");
      $("matter.tapeCode").removeAttribute("disabled");
      $("matter.name").removeAttribute("disabled");	 
      $("isSpaceAdver").removeAttribute("disabled");
//      if(config_permitModAdverParam != "1"){       
//	      $("matter.edit").removeAttribute("disabled");
////	      $("orderMeno").removeAttribute("disabled");
//      }

	   if(isCkecked != 0 && isCkecked != 4){
   	   	if(config_permitModAdverParam != "1" ){
   	   		 $("matter.edit").removeAttribute("disabled");
   	   	}
   	   }else{
   	   	 $("matter.edit").removeAttribute("disabled");
   	   }

         
      $("compages.pos").removeAttribute("disabled");	           
      $("moneyBalance").removeAttribute("disabled");
//      $("sysPrice").removeAttribute("disabled");
   }else{
   	
   	    $("btn_packeg").disabled= true;
   	
   	   	$("Btn_addNewAdver").hide();
   	    $("Btn_addAndPost2").hide();
     	$("Btn_save").hide();
     	$("Btn_change_matter_brotime").hide();
   	
//   	   broArrange.lockBroArray(true);  
   	
   	  $("orderCode").disabled= true;
   	  
   	  $("orderPublic.moneyRealpay").disabled= "true";
//	  $("orderMeno").disabled= "true";
   	  $("relationCode").disabled= "true";
   	  $("autoBroArrange").disabled= "true";
   	   $("cleanBroArrange").disabled= "true";
   	   $("resumeBroArrange").disabled= "true";
   	   $("addBroArrange").disabled= "true";
   	  
   	  $("moneyRealpay").disabled= "true";
   	   $("carrierName").disabled= "true";
   	  $("resourceSortId").disabled= "true";
   	 
//   	   if(resourcePriceType == '0')     $("execPrice").disabled= "true";
   	  
//  	  $("customer.customerName").disabled= "true";
  	  
//  	  	Ext.fly('customerName').dom.disabled = "true";
//  	  	Ext.fly('customerName').dom.disabled = true;
//  	  	 Ext.getCmp("customerName").disable();
  	  	
//  	  	Ext.fly('customerName').setStyle('backgroundColor:#000;border-right:1px solid #3674A7;');
  	  
//  	  $("userId").disabled= "true";
  	    Ext.getCmp("userId").disable();	
	  
   	  $("matterLength").disabled= "true";
//   	  $("industryTypeId").disabled= "true";
//   	  Ext.getCmp("industryTree").disable();
   	  industry.treecombo.disable();
   	 // $("resourceSortId").disabled= "true";
   	  $("carrierId").disabled= "true";
//   	  $("categoryId").disabled= "true";
//   	  $("contract.code").disabled= "true";
   	  
//   	  $("orderCategoryId").disabled= "true";
//   	    Ext.fly('orderCategoryId').dom.disabled = true;	
//   	    orderCategory1.orderCategoryCommand.disable();
   	  Ext.getCmp("orderCategoryId").disable();

   	  

   	    
   	  
   	  $("resourceInfoId").disabled= "true";
   	  $("resourceSpecificId").disabled= "true";
   	  $("favourRate").disabled= "true";
   	  $("appRate").disabled= "true";  
   	  $("resourcePriceType").disabled= "true";  
   	  //           $("matter.tapeCode").setAttribute("readonly","1"); 
   	  $("matter.tapeCode").disabled= "true"; 
   	  $("matter.name").disabled= "true"; 	
	  $("isSpaceAdver").disabled= "true"; 
	  

//   	  if(config_permitModAdverParam != "1"){
//	   	  $("matter.edit").disabled= "true"; 
////	   	  $("orderMeno").disabled= "true";  	
//   	  }
	   if(isCkecked != 0 && isCkecked != 4){
   	   	if(config_permitModAdverParam != "1" ){
   	   		 $("matter.edit").disabled= "true"; 
   	   	}
   	   }else{
   	   	 	$("matter.edit").disabled= "true"; 
   	   }
   	  
   	  
   	  $("compages.pos").disabled= "true"; 	 
   	   
//	  $("sysPrice").disabled= "true";	
	    
	  $("moneyBalance").disabled= "true";

   }
   



   
   //重新获得广告内容
//   getMatterAutoComplet();	
}




function lockedByState(state){
	
//	var state = $("isCkecked").value;



	if(state != 0 && state != 4){
		
//	if(state == 3){
		$("Btn_addNewAdver").hide();
//		$("Btn_addAndPost1").hide();
		$("Btn_addAndPost2").hide();
//		$("Btn_save").hide();
		//$("relationCode").disabled= true;	
		//$("userId").disabled= true;
		//$("orderMeno").disabled= true;
		orderDetail.enableDel = false;
		//$("orderDetailImgAdd").onclick = function(){return false};
//		alert(config_permitModAdverParam)
		if(config_permitModAdverParam =="0" ){
			$("Btn_change_matter_brotime").hide();
		}
		
	}else{
		$("Btn_addNewAdver").show();
//		$("Btn_addAndPost1").show();
		$("Btn_addAndPost2").show();
		$("Btn_change_matter_brotime").show();
//		$("Btn_save").show();
		
		//$("relationCode").disabled= false;	 
		//$("orderPublic.moneyRealpay").disabled= false;
		//$("userId").disabled= false; 
		//$("orderMeno").disabled= false; 
		
//		orderDetail.enableDel = true;
//		$("orderDetailImgAdd").onclick = addnewOrderDetail;
	}
	

	
}



function getBroDate(startDate,endDate){
	
//	if(startDate == 0){
//	 	startDate = order_year+'0101';
//	 	endDate = order_year+'1231';
//	 }
	 
	startDate = (startDate == null|| startDate==0)? config_serviceDate:startDate;
	endDate = (endDate == null || endDate == 0)? config_serviceDate:endDate;

	broArrange.startDate = myDate.getStartDay(startDate);
	broArrange.endDate = myDate.getEndDay(endDate);  
	broArrange.lastMonthDay = broArrange.endDate; 
	
}

//获得月信息
function getMonthInfos(isLock,rsId,specificValue,startDate,endDate,func){



       // alert(orderDetailStates);
       
//       var resourceId = orderDetail.obj.resourceInfoId;
       
       if($('resourceInfoId').value==0 && $("compages.resourceIds").value!=0){
       	 	resourceId = $("compages.resourceIds").value.split(',')[0];
       }else{
       		resourceId = rsId;
       }
       //orderDetail.obj.resourceSpecificId =  $("resourceSpecificId").value;	
  	//获得指定的参数
	//var specific = getSelectParamFromText($("resourceSpecificId"),"||",2);
	//alert(orderDetail.obj.specific.position);
//	var specific = orderDetail.obj.specific.position == null?"":orderDetail.obj.specific.position;

	//alert(specific=="");
	


	var getMonthsFun = function(objs){
    	
    	 backup_cur_info(null,null,objs);	
    	 
//    	 console.log(objs);
    	broArrange.reset();	
		broArrange.adLength = $("matterLength").value*1;
		broArrange.basePrice = $("sysPrice").value;
		broArrange.realPrice = $("execPrice").value;
		broArrange.ageRate = $("ageRate").value;
		broArrange.moneyBalance = $("moneyBalance").value;
		broArrange.isLock = isLock;
		broArrange.objs = objs;
   

		//画单元格
//		var orderDayInfoTbody =  $("orderDayInfoTbody");
	//超时封签
	    if(tag_time_out){BroArrange.isTimeOutRight = true;}
	    
	    
		broArrange.setup(); 
//		this.fillTable();
//    	this.getBroSumTime();
//    	this.setSumMonthPrice();

//alert($("broArrangeEndDate").value+"ddd");	
		//设置开始结束日期
		

	    broArrange.getBroArrangeStarEndDate(config_serviceDate);
	    if(func) func();
//	    Ext.getBody().unmask();
    }
    
    
//	orderDayInfo.getMonthInfos(orderDetailId,broArrange.startDate,broArrange.endDate,resourceId,specific,getMonthsFun);


 	getBroDate(startDate,endDate);
 	  
     var orderDetail_id = null; 
     if(orderDetailStates == 1){
     	orderDetail_id = orderDetailBackUp.id;
     }else{
     	orderDetail_id = orderDetail.obj.id;
     }
   
  

    var orderDetail_obj = (new OrderDetail()).obj;

    orderDetail_obj.id = orderDetail_id;
	orderDetail_obj.publishStartDate = broArrange.startDate;
	orderDetail_obj.publishEndDate = broArrange.endDate;
	orderDetail_obj.resourceInfoId = resourceId;
    


	orderDetail_obj.specific.position = specificValue == null?'':specificValue;
	
//	options[0]
//	alert(orderDetail_obj.specific.position);
	

	
	orderDetail_obj.compagesId = $("compagesId").value;
	orderDetail_obj.version = order_year;
	orderDetail_obj.orderDetailStates = orderDetailStates;
	
	
	
//	alert(broArrange.startDate);
//	alert(broArrange.endDate);
//	alert(orderDetailStates);
//	alert(orderDetail_obj.id);
//	alert(specific);
	if(isFree){
		orderDetail.getMonthInfosForFree(orderDetail_obj,getMonthsFun);
	}else{ 
		if(resourceId>0) orderDetail.getMonthInfos(orderDetail_obj,getMonthsFun);

	}
	

}
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
//			broArrange.lastMonthDay = endDate;       	
        }
	}else{
		if(choseMonth < oldEndMonth){
//			alert("选择的月份不能小于 已有播出的月份");
			if(choseMonth < oldStartMonth){
				startDate = myDate.getNewDayStartDay(broArrange.endDate,choseMonth);
			}else{
				return false;				
			}

		}else{
			startDate = broArrange.startDate;
			endDate =  myDate.getNewDayEndDay(broArrange.endDate,choseMonth);
			
//			broArrange.lastMonthDay = endDate;		
		}		
	}
	
	var rsId =$("resourceInfoId").value;
	var specificValue = getSelectParamFromAttribute($("resourceSpecificId"),"position");
	var isLock = false;
	getMonthInfos(isLock,rsId,specificValue,startDate,endDate);
	
}
function resumeBroArrange(){
	var id = orderDetailBackUp.id;
	if(id != null && id !='null'&& id !=''){
		getOrderDetail(id);
	}
	
}
//function resumeBroArrange_bak(ev){
////	var startDate = broArrange.startDate;
////	var endDate =   broArrange.endDate;
////	broArrange.lastMonthDay = endDate;	
//	DWRUtil.setValue("selectMonth", 0);
//
//	broArrange.startDate =  orderDetailBackUp.orderPublic.publishStartDate;
//	broArrange.endDate = orderDetailBackUp.orderPublic.publishEndDate;
//
//	$("resourceInfoId").value =  orderDetailBackUp.resourceInfoId;
//	$("resourceSpecificId").value =  orderDetailBackUp.resourceSpecificId;
//
//	var rsId =  orderDetailBackUp.resourceInfoId;
//	var specificValue = orderDetailBackUp.specific.position;
//    var isLock = false;
//    
//
//	getMonthInfos(isLock,rsId,specificValue,broArrange.startDate,broArrange.endDate);
//	
//	otherFocus();
//}
//添加新月
function addBroArrange(ev){
	var resourceSort =  getSelectParamFromAttribute($("resourceSortId"),"paramvalue");
	if($("resourceInfoId").value <1 && (resourceSort == 1||resourceSort == 3)){
		 alert("增加月份前，请选择广告资源");
		 return false;
	}
	
	otherFocus();
		
	var startDate = broArrange.startDate;
	var endDate =   myDate.getNextMonthDay(broArrange.lastMonthDay);
	var m = broArrange.myDate.getMonth(endDate)*1;
	DWRUtil.setValue("selectMonth", m);

	if(endDate){//alert(endDate);
		broArrange.endDate = endDate;
		endDateInit=endDate;
		//alert($("broArrangeEndDate").value+"xxx");
		
		broArrange.startDate = startDate;
		broArrange.endDate =endDate;

	    var isNewOrderDetail = (orderDetailStates == 2||orderDetailStates == 3);
	    backupBroarrayToCur(isNewOrderDetail,null,true);
	   // backupBroarrayToCur(isNewOrderDetail);
		
	}
}
function addNewOrderDayInfo(ev){
	
	var cur_year = _app_params.serviceDate.year;
	var cur_date = (order_year != cur_year )?order_year +"0101":config_serviceDate;
	var startDate = myDate.getStartDay(cur_date);
	var temp = myDate.getMonth(startDate)*1;
	var nextMonth = myDate.getMonth(startDate)*1 + 2;
	if( temp+2 >= 13)  nextMonth = 12;
	var endDate   = myDate.getNewDayEndDay(startDate,nextMonth);

	DWRUtil.setValue("selectMonth", 0);
	

	if(endDate){
		var rsId =$("resourceInfoId").value;
		var specificValue = getSelectParamFromAttribute($("resourceSpecificId"),"position");
		var isLock = false;
		getMonthInfos(isLock,rsId,specificValue,startDate,endDate);		
	}
}
//显示剩余时间

//保存dayInfo信息
function saveOrderDayInfo(){
	var orderDayInfos = new Array();
	  //广告日信息 

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
//              	  dayObj == DayInfoArray
				  var dayObj = cell.dayObj;
			  	  var order_Day_Info = (new OrderDayInfo()).obj;
			  	  
//			  	  order_Day_Info.needCal = orderDayInfo.obj.needCal;
//			  	  order_Day_Info.contractId = orderDayInfo.obj.contractId;
//			  	  order_Day_Info.paymentId = orderDayInfo.obj.paymentId;
//			  	  order_Day_Info.orderId = orderDayInfo.obj.orderId;
//				  order_Day_Info.orderDetailId =  orderDayInfo.obj.orderDetailId;
//				  order_Day_Info.dayStandardPrice = orderDayInfo.obj.dayStandardPrice;
//				  order_Day_Info.dayStandardPrice = orderDayInfo.obj.dayStandardPrice; 
//				  order_Day_Info.dayRelIncome = orderDayInfo.obj.dayRelIncome;
//				  order_Day_Info.dayRelPuton = orderDayInfo.obj.dayRelPuton;
//				  order_Day_Info.customerId = orderDayInfo.obj.customerId;
//				  order_Day_Info.linkUserId = orderDayInfo.obj.linkUserId;
//				  order_Day_Info.needPublish = 0;
//				  order_Day_Info.id = dayObj.adDayInfoId;
				  
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
	              
//	              alert(dayObj)
	              
//                order_Day_Info.adSumTimes = order_Day_Info.adDayTimes*order_Day_Info.adlength;	
//	              order_Day_Info.dayInfo = res_Day_Info;
	             

	              order_Day_Info.dayStandardPrice = orderDayInfo.obj.dayStandardPrice; 
				  order_Day_Info.dayRelIncome = orderDayInfo.obj.dayRelIncome;
				  
				  console.log(order_Day_Info);
				  
				  orderDayInfos.push(order_Day_Info);
				   
				  //返回当前资源的指定信息
	//			  if(isUndefined(rsSpecific)) rsSpecific = '';
	//			  if(isUndefined(adSpecific)) adSpecific = '';
	//			  if(isUndefined(adTimes)|| adTimes == null || adTimes == '') adTimes = 0;
		
	//			  rsSpecific = getResSpecific(rsSpecific,adSpecific,curSpecific,adTimes,curValue);
		
	//			  res_Day_Info.carrierId = resDayInfo.obj.carrierId;
	//			  res_Day_Info.resourceId =resDayInfo.obj.resourceId;
	//	          res_Day_Info.id = dayObj.resourceDayId;
	//			  res_Day_Info.publishDate = dayObj.dayDate;
	//			  res_Day_Info.modifyTime = dayObj.modifyTime;
	//			  res_Day_Info.specific = dayObj.specific;
	////			  res_Day_Info.specific = rsSpecific;
	//			  res_Day_Info.used = dayObj.used;
	////              res_Day_Info.used = order_Day_Info.adDayTimes*order_Day_Info.adlength;  
	////              res_Day_Info.specific = rsSpecific;
	//			  res_Day_Info.version = resDayInfo.obj.version;
				  
				 
	//			  if((fztvSpecialParam==1 || tvNameParam=='xmtv')&& orderDetail.obj.id==null) dayObj.adDayInfoId=null;
	
	//			 
				  //1、保存广告日信息同时，联动修改资源日信息
				  //2、如果有广告日信息编号，进入修改
				  //3、如果没有广告日信息编号，单有次数，进入新添
				  //4、修改和新添广告的同时，对广告资源日信息进行处理
				  
		          
              }
		  	  
		  }
	  }
	}


	return orderDayInfos;

}
//资源指定的判断
//function getResSpecific(rsSpecific,adSpecific,curSpecific,adTimes,curValue){
//	//如果原来有指定，现在也是相同指定，删除次数时 需要去了资源中的指定
//	if (adSpecific !='' && ((curValue == 0||curValue == '')|| curSpecific != adSpecific )){
//		//替换资源里的指定字符串
//		rsSpecific = replaceRestring(rsSpecific,adSpecific,'');
//	}
//	
//	if (adSpecific !=''&& curSpecific != adSpecific){
//		rsSpecific = rsSpecific + curSpecific;
//	}
//	
//	//如果原来有指定，现在也是相同指定，增加次数时 需要追加资源中的指定
//	if (adSpecific =='' && curSpecific !='' &&  curValue == 1){
//		rsSpecific = rsSpecific + curSpecific;
//	}	
//	//修改无播出但有指定
//	//if (adSpecific !=''&& curSpecific !='' &&  curValue == 1 && adTimes == 0 ){
//		//rsSpecific = rsSpecific + curSpecific;
//	//}
//			
//	return  rsSpecific;
//}















function getMatterAutoComplet(isFromNameKeypress){
	
	var customerName =  Ext.fly('customerName').dom.value; 
	var customerId =  Ext.getCmp('customerName').getValue();
	customerId = customerId > 0?customerId:"";
	
//	alert(customerId);alert(customerName);
//	if(customerId == customerName) return false;
	
	
//	var customerId = $("customerId").value;
	var matterLength = $("matterLength");
	var stopAuto=false;
	matter.reset();
	
	matter.obj.orgId =orgId;
	
//	alert(orgId);
	
//	if(matterLength.disabled){
//		 if(matterLength.value!=""){
//		 	matter.obj.length = matterLength.value*1;
//		}
//	}else{
//	   	if(initMatterButton==false && customerId!=""){
//		    if(matterLength.value == 0){
//		    	matter.obj.length = null;
//		    }else{
//		    	matter.obj.length = matterLength.value*1;
//		    } 	 
//		}else if(initMatterButton==false && customerId==""){
//		     
//		    if(matterLength.value == 0){
//		    	matter.obj.length = null;
//		    	stopAuto = true;
////		    	alert("请输入广告长度！");
////		    	return false;
//		    }else{
//		    	matter.obj.length = matterLength.value*1;
//		    } 	
//		    			
//		}else if(initMatterButton==true){
//		     
//		    if(matterLength.value == 0){
//		    	matter.obj.length = null;
//		    	stopAuto = true;
////		    	alert("请输入广告长度！");
////		    	return false;
//		    }else{
//		    	matter.obj.length = matterLength.value*1;
//		    } 	
//		    			
//		}
//	}
//	if(initMatterButton==false){
//		if(customerId == 0 || customerId == null || customerId == ""){
//		   matter.obj.customerId = null;
//		}else{
//		   matter.obj.customerId = customerId;
//		} 	
//		
//	}
	
//		alert(matter.obj.customerId == null);
//alert(matter.obj.customerId == '');
   

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
	
	
	
//	alert(initMatterButton)
//	
	 if(customerId=="" ){
	 	
//	 	  if(isFromNameKeypress){
//	 	
//		 	  	if(matterLength.value > 0 && ($("matter.name").value).trim() !=""){
//			 	  	 matter.obj.customerId = null;
//			 	  	 matter.obj.name=$("matter.name").value;
//			 	  	 matter.obj.length = matterLength.value*1;
//		 	  	}else{
//		 	  	 	alert("请输入广告长度！"); 
//			    	return false;
//		 	  	}
//	
//	 	  }else{
	 	  	if(initMatterButton==false) matter.obj.customerId=-1;
//	 	  }
	 	  
	 	  
			
	 }else if(initMatterButton==false){
	 	matter.obj.customerId=customerId;
	 }
//	  if(initMatterButton ==true){
//	  	
//	  }
	 
	 
     
	if(stopAuto && ($("matter.name").value).trim() ==""){
		alert("请输入广告长度！"); 
		    	return false;
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
		alert("请输入广告长度！"); 
		    	return false;
	}else{
		matter.obj.orgId = orgId;
		matter.getMattersByCustomerIdAndLength(matter.obj,mattersAutoCompleteTapeCode);
	}
}
//function getCompagesAutoComplete(){
//	compages.obj.enable=true;
//	compages.getCompagesAutoComplet(compages.obj,compagesAutoComplete);
//}


function getContractsAutoComplete(){
	var customerId = $("customerId").value;
	customerId = customerId ==''||customerId =='0'?customerId=null:customerId;
	contract.reset();
//	contract.obj.state = 3;
	contract.obj.customerId = customerId;
	contract.obj.version = order_year;
	
//	alert('getContractsAutoComplete');
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
	
//	alert('memo');
//	if( tvNameParam =='xmtv'){
//		indexColumName.push('memo');
//		allColumsName.push('memo');
//		allColumsTitle.push('部门');
//	}
	
	var onDivMouseDown = function(ev){
		var tr = getElementByEvent(ev);
		$("order.contractId").value = getCellValue(tr,0);
//		$("paymentId").value = getCellValue(tr,1);
//		$("contractPayment.payDate").value = getCellValue(tr,3);
//		$("contractPayment.moneyPay").value = getCellValue(tr,4);
		$("customerId").value = getCellValue(tr,4);
//		$("customer.customerName").value = getCellValue(tr,5);

//		Ext.fly('customerName').value =  $("customerId").value;
//		Ext.fly('customerName').dom.value = getCellValue(tr,5);
		$("customerCategoryId").value = getCellValue(tr,6);
		
		var id = getCellValue(tr,4);
		var customerName = getCellValue(tr,5);
		var customerCategoryId = getCellValue(tr,6);
        inti_set_customer(1,id,customerName,customerCategoryId);		
		
		
		$("contractPayment.contractMoneySum").value = getCellValue(tr,7);

//		oText.value = getCellValue(tr,1) +' ' + getCellValue(tr,2) + ' ' + getCellValue(tr,3);
		oText.value = getCellValue(tr,2);
		
//		getLowestRateAndAgentRate();
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
//		    $("customer.customerName").value ="";
		  
		    Ext.fly('customerName').dom.value= "";
		    
		    $("customerId").value = 0;
		    $("customerCategoryId").value = 0;
		    $("contractPayment.contractMoneySum").value = 0;
//		    getLowestRateAndAgentRate();	
		    lockOrderMainCategory(-1);	
		    $("orderPublic.moneyRealpay").disabled = false;
		    $("orderPublic.moneyIn").value = 0;
		}else{
			//检测合同编号是否存在
			var paymentId =$("paymentId").value;
			if(paymentId == ''){
				alert("请选择合同号的下拉列表！")
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
	
//	alert(objs.length);
//	alert('memo');
//	if( tvNameParam =='xmtv'){
//		indexColumName.push('memo');
//		allColumsName.push('memo');
//		allColumsTitle.push('部门');
//	}
	
	
	var onDivMouseDown = function(ev){
		var tr = getElementByEvent(ev);
		$("paymentId").value = getCellValue(tr,0);
		$("order.contractId").value = getCellValue(tr,1);
		$("contractPayment.payDate").value = getCellValue(tr,3);
		$("contractPayment.moneyPay").value = getCellValue(tr,4);
		$("customerId").value = getCellValue(tr,5);
//		$("customer.customerName").value = getCellValue(tr,6);
		
//		Ext.fly('customerName').dom.value= getCellValue(tr,6);
//		Ext.fly('customerName').dom.value = getCellValue(tr,6);
		$("customerCategoryId").value = getCellValue(tr,7);
		
	
		var id = getCellValue(tr,5);
		var customerName = getCellValue(tr,6);
		var customerCategoryId = getCellValue(tr,7);
        inti_set_customer(1,id,customerName,customerCategoryId);		
		
		
		
		$("contractPayment.contractMoneySum").value = getCellValue(tr,8);

//		oText.value = getCellValue(tr,2) +' ' + getCellValue(tr,3) + ' ' + getCellValue(tr,4);
		oText.value = getCellValue(tr,2);
		
//		getLowestRateAndAgentRate();
       
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
//		    $("customer.customerName").value ="";

		    Ext.getCmp('customerName').setValue('');
		    Ext.getCmp('customerName').disabled = false;
		    
		    
//		    Ext.fly('customerName').dm.value= "";
		    
		    $("customerId").value = 0;
		    $("customerCategoryId").value = 0;
		    $("contractPayment.contractMoneySum").value = 0;
//		    getLowestRateAndAgentRate();	
		    lockOrderMainCategory(-1);	
		    $("orderPublic.moneyRealpay").disabled = false;
		    $("orderPublic.moneyIn").value = 0;
		}else{
			//检测合同编号是否存在
			var paymentId =$("paymentId").value;
			if(paymentId == ''){
				alert("请选择合同号的下拉列表！")
			}
		}
		
		getContarctAuto();
	}

   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown,onTextBlur,hidenColumName,indexColumName,allColumsName,allColumsTitle);
}

function lockOrderMainCategory(contractSort){
	var contractId = $("order.contractId");
	var categoryId = $("categoryId");
//	var customerId = $("customer.customerName");
	var customerId = Ext.fly('customerName').dom;
	

	var moneyPay =$("contractPayment.moneyPay")
	var value =  0;
    

	if(contractId.value =="0" || contractId.value =="" || contractId.value ==null){
		value =  orderCategory.getValueFromCommand(categoryId,"正常订单");
		categoryId.removeAttribute("disabled");	
		customerId.removeAttribute("disabled");	
	}
	if((contractId.value !="0" && contractId.value !="" && contractId.value !=null) && contractSort == 0){
		value =  orderCategory.getValueFromCommand(categoryId,"协约合同");
		categoryId.disabled = "true"; 
		customerId.disabled = "true";
	}
	
	if( tvNameParam =='xmtv'){
		if((contractId.value !="0" && contractId.value !="" && contractId.value !=null) && contractSort == 2){
			value =  orderCategory.getValueFromCommand(categoryId,"部门订单");
			categoryId.disabled = "true"; 
			customerId.disabled = "true";
		}
	}
	
	if((contractId.value !="0" && contractId.value !="" && contractId.value !=null) && contractSort == 1){
		value =  orderCategory.getValueFromCommand(categoryId,"协议合同");
		categoryId.disabled = "true";
		customerId.disabled = "true"; 
	}
	
	categoryId.value = value;
	
	
	
//	initOrderCategory1(contractSort);
	  	 
}





function mattersAutoCompleteTapeCode(objs){   
	
	
	var oText_tapeCode = $("matter.tapeCode");
	var oDiv_tapeCode = $("theDivTapeCode");
	var indexColumName_tapeCode = ["tapeCode","id"];
	var allColumsName_tapeCode =["id","tapeCode","name","edit","length","matterType","industryType","industry.name"];
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
//		$("industryTypeId").value = getCellValue(tr,6);
		
		var industryName =  getCellValue(tr,7);
 		industry.treecombo.passField.value =  getCellValue(tr,6);
   		industry.treecombo.setValue(industryName);	
   		
		
		if(isChanged) copyBroTimesToCurBroArrange();
		oText_tapeCode.value = getCellValue(tr,1);
	}
	var hidenColumName = ["id","matterType","industryType","industry.name"];
	var onTextBlur = function(ev){
		oDiv_tapeCode.style.visibility = "hidden";
//		oDiv_name.style.visibility = "hidden";
//		oDiv_edit.style.visibility = "hidden";
//		$("dt_matter.id").value = "";
		
		if(trim(oText_tapeCode.value) == "" )$("matter.tapeCode").value = "";
//		if(trim(oText_name.value) == "" )$("matter.name").value = "";
//		if(trim(oText_edit.value) == "" )$("matter.edit").value = "";
//        if( trim(oText_edit.value) == ""){
//		if(trim(oText_name.value) == "" && trim(oText_edit.value) == ""){
//			$("dt_matter.id").value = "";
		//	$("matterLength").value = "";
//			copyBroTimesToCurBroArrange();	
//		}		
	}
   new AutoComplete(objs,oText_tapeCode,oDiv_tapeCode,-1,onDivMouseDown_tapeCode,onTextBlur,hidenColumName,indexColumName_tapeCode,allColumsName_tapeCode,allColumsTitle_tapeCode);

}

function mattersAutoComplete(objs){   
	
//	alert(objs.length);
	var oText_tapeCode = $("matter.tapeCode");
	var oDiv_tapeCode = $("theDivTapeCode");
	var indexColumName_tapeCode = ["tapeCode","id"];
	var allColumsName_tapeCode =["id","tapeCode","name","edit","length","matterType","industryType","industry.name"];
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
//		$("industryTypeId").value = getCellValue(tr,6);
		
		var industryName =  getCellValue(tr,7);
 		industry.treecombo.passField.value =  getCellValue(tr,6);
//  		industry.treecombo.setRawValue.setRawValue(industryName);  
   		industry.treecombo.setValue(industryName);	
   		

		
		
		
		if(isChanged) copyBroTimesToCurBroArrange();
		oText_tapeCode.value = getCellValue(tr,1);
	}
	
	var oText_name = $("matter.name");
	var oDiv_name = $("theDivMatterName");
	var indexColumName_name = ["name","id"];
	var allColumsName_name =["id","name","edit","length","tapeCode","matterType","industryType","industry.name"];

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
//		$("industryTypeId").value = getCellValue(tr,6);
		
		
		var industryName =  getCellValue(tr,7);
 		industry.treecombo.passField.value =  getCellValue(tr,6);
//  		industry.treecombo.setRawValue.setRawValue(industryName);  
   		industry.treecombo.setValue(industryName);			
		
		oText_name.value = getCellValue(tr,1);
	}	
	
	var oText_edit = $("matter.edit");
	var oDiv_edit = $("theDivMatterEdit");
	var indexColumName_edit = ["edit","id"];
	var allColumsName_edit =["id","edit","name","length","tapeCode","matterType","industryType","industry.name"];
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
//		$("industryTypeId").value = getCellValue(tr,6); 
		
		var industryName =  getCellValue(tr,7);
 		industry.treecombo.passField.value =  getCellValue(tr,6);
//  		industry.treecombo.setRawValue.setRawValue(industryName);  
   		industry.treecombo.setValue(industryName);		
		
		oText_edit.value = getCellValue(tr,1);
	}		
	

	var hidenColumName = ["id","matterType","industryType","industry.name"];
	var onTextBlur = function(ev){
		oDiv_tapeCode.style.visibility = "hidden";
		oDiv_name.style.visibility = "hidden";
		oDiv_edit.style.visibility = "hidden";
//		$("dt_matter.id").value = "";
		
		if(trim(oText_tapeCode.value) == "" )$("matter.tapeCode").value = "";
		if(trim(oText_name.value) == "" )$("matter.name").value = "";
		if(trim(oText_edit.value) == "" )$("matter.edit").value = "";
		if(trim(oText_name.value) == "" && trim(oText_edit.value) == ""){
			$("dt_matter.id").value = "";
		//	$("matterLength").value = "";
			copyBroTimesToCurBroArrange();	
		}		
	}
      
   new AutoComplete(objs,oText_tapeCode,oDiv_tapeCode,-1,onDivMouseDown_tapeCode,onTextBlur,hidenColumName,indexColumName_tapeCode,allColumsName_tapeCode,allColumsTitle_tapeCode);
//   new AutoComplete(objs,oText_name,oDiv_name,-1,onDivMouseDown_name,onTextBlur,hidenColumName,indexColumName_name,allColumsName_name,allColumsTitle_name);
   new AutoComplete(objs,oText_edit,oDiv_edit,-1,onDivMouseDown_edit,onTextBlur,hidenColumName,indexColumName_edit,allColumsName_edit,allColumsTitle_edit);
}

function mattersAutoComplete2(objs)
{
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
}
function mattersAutoCompleteChange(oldValue,newValue){
//	alert(oldValue+"   "+newValue);
	if(oldValue!=newValue){
//		copyBroTimesToCurBroArrange();
       return true;
	}
}



function getCustomerAutoCompltByName(){

	  var customerName = "";

		var categoryId = 0;

        var mode = 'remote';
        customer.obj.orgId = orgId;

    	customer.storeCustomer = customer.getStoreCustomersAnalyze(mode,customer.obj);   

//     customer.storeCustomer.on('load', function() {
//     	Ext.getCmp('customerName').expand();  
//    });  
	   if(!customer.customerCommand){
	   	 
//	   //模板
        var tpl2= customer.getCustomerCmdTemple1();

		customer.customerCommand = new Ext.form.ClearableComboBox({
		 	  id:'customerName',
		 	  name:'customerName',
		 	  applyTo: 'extCustomerDiv',
//			  renderTo:'extCustomerDiv',
			  tiggerAction:'all',
			  listWidth:300,
			  store:customer.storeCustomer,
			  editable: true,
			  triggerAction: 'all', //query all
			  lastQuery:'1',
			  displayField:'customerName',
			  valueField:'id',
			  mode:mode,
	//		  readOnly:true,
			   width:144,
	//		   typeAhead: true,
			   forceSelection:false, 
			  allowBlank:false,
	//		  lazyRender: false,
			  emptyText:'请选择...',
			  minChars:2,
			  hiddenName:'customerCategoryId', //提交传过去的值 
			  filterFiled:'customerName',
			  params:customer.obj,
			  tpl:tpl2,
			  listeners:{
			  	beforequery:customer.comboFilterBy2.createDelegate(this)}
			  	
		 });
		 
		 
		 

			//是combo的valueField的字段
//			myTpl.showAddress=function(value){
//			var record = customer.customerCommand.findRecord(customer.customerCommand.valueField, value);
//		        return record ? record.get(customer.customerCommand.displayField) : '';
//			}; 
	

	   }


//		var customerCommand = customer.buildCommand('customerName','extCustomerDiv','remote',paramObj);
		
		
		function callBack_bak(cbo,e){
		  	    var id = cbo.value;
	            var rec = cbo.store.getById(id)
			    $("customerId").value = id;
//			    Ext.fly('customerName').getValue();
			    
//			    alert(Ext.get('customerName').getValue());
//			    alert(Ext.getCmp('customerName').value);
//			     alert(Ext.getCmp('customerName').getValue());
			   
				$("customerCategoryId").value = rec.get('customerCategoryId');	
				
//				alert(rec.get('customerCategoryId'));
				
				
	    }
	    
	    
	    function callBack(cbo,e){
//	    	       alert(cbo.value);
	    	       var rec = cbo.store.getById(cbo.value)
//	    	       alert( rec.get('customerCategoryId'));
	    	       

//	    	      inti_set_customer(1,id,customerName,customerCategoryId);	
	    }
	            
//		customer.customerCommand.on("select",callBack,this);	


//       function getcheckCustomer(){
//       		checkCustomer();
//       }
//       

		
//		customer.customerCommand.on("blur",checkCustomer,this);	
		
			
    
		

				    
//		customer.customerCommand.on("blur",callBack,this);	
		
		
		
		
//		customerCommand.on("blur",callBack,this);	
		
//	}
	
//	if(ev.keyCode == 13){
//		var userName = $("config_username").value; 
//		user.getCurUserId(userName,fnc);
//	}
}

function inti_set_customer(i,id,customerName,customerCategoryId){
	 	    	
	var rc1 = Ext.data.Record.create(customer.fileds);
    var rc = new rc1({
           id : id,
           customerCategoryId : customerCategoryId,
           customerName:customerName
     });

   if(i == 1){
   	   if(!customer.customerCommand) initCustomerCmd();
       customer.customerCommand.clearValue(); 
   	   customer.customerCommand.store.add(rc);
   	   customer.customerCommand.setValue(id);  
   }else{
   	   customer.regcustomerCommand.clearValue(); 
   	   customer.regcustomerCommand.store.add(rc);
   	   customer.regcustomerCommand.setValue(id);  
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
	   	 cmd.clearValue(); 
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
	
//	if(tvNameParam =='qztv'){
//		if(tag_order_paymentbtn){
//			$("Btn_display").show();
//		}else{
//			$("Btn_display").hide();
//		}
//	}		
	
	
	
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
	
//	alert("orderRelpay = " + orderRelpay);
	
	var func = function(sumMoneyPay){
		if(sumMoneyPay != 0 && orderRelpay > sumMoneyPay){
			displayPayment();
			var monBlance = orderRelpay - sumMoneyPay;
			
//			alert("付款不足，还差 " + monBlance);
		}
	}
	
	payMent.getMoneyPayByOrderId(orderId,func);
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
function button_print(){
	$("orderId").value = order.obj.id;
	var orderId = order.obj.id;
	$("printOrgid").value = orgId;

	if(orderId == null || orderId =="" || orderId=="NaN"){
		alert("没有数据，不能执行此操作!");
		return false;
	}
	
	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");

	
	reportForm.target = tarForm;
	reportForm.action="reports/jsp/order_preView.jsp";
	reportForm.submit(); 	
}

function buildRegCustomer(winW,height,customerName){
//	ctxPath = $("ctxPath").value;
	
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

	

	
	
	
//	$("regCustomerName").value = customerName;
	regCustomerComboBox(winW,customerName);
	
	
	
	function onRowSelectd(id,cellInd){
		 var customerName = this.getUserData(id,"customerName");
		 var customerCategoryId = this.getUserData(id,"customerCategoryId"); 
		 inti_set_customer(2,id,customerName,customerCategoryId);
	}

	
//	regCustomerGrid = new dhtmlXGridObject('gridbox_regCustomer');
//	regCustomerGrid.selMultiRows = true;
//	regCustomerGrid.setImagePath(ctxPath+"image/grid/");
//	
//	var flds = "客户名称,客户类别";
//	var columnIds = "filed1,filed2";
//	regCustomerGrid.setHeader(flds);
//	regCustomerGrid.setColumnIds(columnIds);
//	
//    regCustomerGrid.setInitWidthsP("80,19");
// 
//	regCustomerGrid.setColAlign("left,center");
//	regCustomerGrid.setColTypes("ed,ed");
//    
//    regCustomerGrid.setMultiLine(false);
//	regCustomerGrid.setEditable(false);
//	regCustomerGrid.enableDragAndDrop(false);
//	
//	regCustomerGrid.setOnRowSelectHandler(onRowSelectd,true);
//	regCustomerGrid.setSkin("modern2");
//	regCustomerGrid.enableAlterCss("even","uneven");
//	regCustomerGrid.init();	
//	
//	loadRegCustomerGrid(customerName);
	
//    $("gridbox_regCustomer").style.height =  height*0.81 +"px";
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
    	
//    	alert('regCustomerComboBox')
        
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
//			    $("customerId").value = id;
//				$("customerCategoryId").value = rec.get('customerCategoryId');	
//				loadRegCustomerGrid(rec.get('customerName'));
	    }
	            
//		customer.regcustomerCommand.on("select",callBack,this);	
//		customer.regcustomerCommand.on("collapse",callBack,this);	

}





//
//function selectCarrTreeResTypeRel(){
//  var orgId = $("orgId").value;
//  var urlStr="selectPopup/selectCarrTreeResTypeRel.html?mode=1&orgId="+orgId+"&resourceYear="+resource_year;
//  var okBtn ={text: '保存',handler: function(){document.getElementById('userReliframe').contentWindow.saveResCarrTypeRel();}};	
//  var closeBtn ={text: '关闭',handler: function(){removeWin();}};
//  
//        
// var win = new Ext.Window({
//   title : '广告分类与段位关系',
//   //maximizable : true,
//   // maximized : true,
//   width : 300,
//   height : 500,
//   isTopContainer : true,
//   modal : false,
//   resizable : false,
//    buttons: [okBtn,closeBtn],
//   contentEl : Ext.DomHelper.append(document.body, {
//    tag : 'iframe',
//     id : 'userReliframe',
//    style : "border 0px none;scrollbar:true",
//    src : urlStr,
//    height : "100%",
//    width : "100%"
//   })
//  })
//  win.show(); 
//  
//   function removeWin(){
//  		win.destroy();
//   	} 
//   win.on({'close': {fn: removeWin}});   
//  
//  
//}


function inti_set_orderSubCate(id,name,calculateAuto){

    if(!orderCategory1.orderCategoryCommand){
    	initOrderCategory1Cmd();
    }

    if(!orderCategory1.orderCategoryCommand.store.getById(id)){
	 	var rc1 = Ext.data.Record.create(orderCategory.fileds);
	    var rc = new rc1({
	           id : id,
	           name : name,
	           calculateAuto : calculateAuto
	     });

//       orderCategory1.orderCategoryCommand.clearValue(); 
//       orderCategory1.orderCategoryCommand.store.removeAll();
   	   orderCategory1.orderCategoryCommand.store.add(rc);
   	   orderCategory1.orderCategoryCommand.store.reload();
   	   orderCategory1.orderCategoryCommand.setValue(id);  	
   	   orderCategory1.calculateAuto = calculateAuto;
    }else{
    	  orderCategory1.orderCategoryCommand.setValue(id);  	
    }



}

//function inti_set_industry(id,name){
function inti_set_industry(o){
//	var rc1 = Ext.data.Record.create(orderCategory.fileds);
//    var rc = new rc1({
//           id : id,
//           name : name,
//     });
        var id = o.id;
        var name = o.name;
	    if(!industry.treecombo){
	    	initIndustry();
	    	industry.treecombo.setValue(name);
	    }else{
//	   	   industry.treecombo.store.add(rc);
	   	   industry.treecombo.setValue(name);
	   	   industry.treecombo.passField.value = id; 	
	    }
    
//       industry.treecombo.clearValue(); 
//   	   industry.treecombo.store.add(rc);
//   	   industry.treecombo.setValue(name);
//   	   industry.treecombo.passField.value = id; 	
}

// industry.treecombo.passField.value = 0
//  industry.treecombo.setRawValue.setRawValue('');  
//   industry.treecombo.setValue('');
//级联事件
function onOrderSubCategoryChange(){
	    var categoryMainName = "categoryId";
	    var categoryMainId = $(categoryMainName).value;
	    
	    if(categoryMainId > 0){
	    	var catMain = DWRUtil.getText(categoryMainName);
	    	
					if(catMain.indexOf("正常订单") > -1 || catMain.indexOf("协约订单") > -1){
								  $("order.contractId").value ='';
								  $("contract.code").value ='';
								  $("paymentId").value ='';	  
						}
						
						if(catMain.indexOf("协约合同") > -1 || catMain.indexOf("部门订单") > -1){
							   
								if(order.obj.id > 0) {
			//						 alert(order.obj.id);
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
						
//			initOrderCategory1();	
		}
}


function checkOrderSubCate(a){
	var name =  Ext.fly('orderCategoryId').dom.value; 
	var id =  Ext.getCmp('orderCategoryId').getValue();	
//	alert('customerId'+customerId);
//	alert('customerId'+$("customerId").value);
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

}


//	alert("显示值="+industry.treecombo.getRawValue()+"   真实值="+industry.treecombo.passField.getValue());
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
			              // xtype : 'combotree',
			               passName : 'typeId',
			               autoScroll:true,
			               allowUnLeafClick : false,
			               treeHeight:300,
			               tree :tree,
			               allowBlank : false        
				});
	     	}
	     	
	     	function onTreeSelected(node){
//	     		  industry.treecombo.setValue(node.id);  	
//                  industry.treecombo.relId = node.id;
               
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
			  renderTo:'extCustomerDiv',
			  tiggerAction:'all',
			  listWidth:300,
			  store:customer.storeCustomer,
			  editable: true,
			  triggerAction: 'all', //query all
			  lastQuery:'1',
			  displayField:'customerName',
			  valueField:'id',
			  mode:mode,
			   width:144,
	//		   typeAhead: true,
			   forceSelection:false, 
			  allowBlank:false,
	//		  lazyRender: false,
			  emptyText:'请选择...',
			  minChars:2,
			  hiddenName:'customerCategoryId', //提交传过去的值 
			  filterFiled:'customerName',
			  params:customer.obj,
			  tpl:tpl2,
			  listeners:{
			  	beforequery:customer.comboFilterBy2.createDelegate(this)}
			  	
		 });

	   }

//       function getcheckCustomer(){checkCustomer();}
//	   customer.customerCommand.on("blur",getcheckCustomer,this);	

}


function reloadOrderCategory1Store(){
		var cmd2 =  orderCategory1.orderCategoryCommand;
		var store2 = cmd2.getStore();	
		store2.baseParams.dwrParams[0].orgId = orgId;
		store2.baseParams.dwrParams[0].version = $("order_year").value;
		store2.baseParams.dwrParams[0].parentId = $("categoryId").value; 
		store2.reload();	
		cmd2.clearValue(); 	
		function callBack_bak(cmd){
					if(order.obj.id > 0 && order.obj.categoryId == $("categoryId").value){
						 orderCategory1.orderCategoryCommand.setValue(orderDetail.obj.orderCategoryId);  	
					}else{
					     getValueFromStoreByText(orderCategory1.orderCategoryCommand,"正常");
					}		
		};
		orderCategory1.storeOrderCategory.on("load",callBack_bak,this);	
		if(orderDetailBackUp.id == null && $("resourceInfoId").value >0 ) {
			onResourceChange();
		}
}


function initOrderCategory1Cmd(){

	       if (!orderCategory1.orderCategoryCommand){
	       	
		        var mode = 'remote';
				orderCategory1.obj.parentId = config_orderModCategoryParam;
			    orderCategory1.obj.orgId = orgId;
				orderCategory1.obj.version = $("order_year").value;
	//            orderCategory1.storeOrderCategory =  new Ext.data.Store();
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
		//		  readOnly:true,
				   width:144,
		//		   typeAhead: true,
				   forceSelection:false, 
				  allowBlank:false,
		//		  lazyRender: false,
				  emptyText:'请选择...',
				  minChars:1,
				  hiddenName:'', 
				  filterFiled:'name',
				  params:orderCategory1.obj,
				  listeners:{
//				  	beforequery:customer.comboFilterBy2.createDelegate(this)
				  	}
				  	
					 });
//			     orderCategory1.orderCategoryCommand.on("blur",checkOrderSubCate,this);	
			     
			     
			     orderCategory1.orderCategoryCommand.on("select" , function(box)
					    {
					    		orderCategory1.calculateAuto =   getValueFromStoreById(Ext.getCmp("orderCategoryId"),"calculateAuto");
					    	    if($("resourceInfoId").value>0){
					       	    	getSysPrice(false,setBroArrayangeMonthOnPriceChange);
					    	    }

					    });
			     
			     
//			     function aa(){
//			     	if($("resourceInfoId").value>0 ) {
//			     		onResourceChange();	
//			     	}
//			     }
//			     orderCategory1.orderCategoryCommand.on("select",aa,this);	
	       }



		 
}



function changeMatterEdit(){
	
	if(orderBackUp.id == null){
		 alert("您当前处于新添状态，换版无法进行!");
		 return false;
	}

	if(orderDetailBackUp.id == null){
		    var id = mygrid.getSelectedId();
		 	if(id > 0) {
		 		 getOrderDetail(id);
		 		 alert("您当前处于新添状态，系统先要恢复原有的信息, 才能继续下一步!");
		 	}
	}	
  
  
 //  urlStr = urlStr +"&matterId="+order_year;
  var rowId = mygrid.getSelectedId();
  var name = mygrid.cells(rowId,2).getValue();
  var edit = mygrid.cells(rowId,3).getValue();
  var length = mygrid.cells(rowId,4).getValue();
  
//  var start = mygrid.cells(rowId,6).getValue();
//  var end = mygrid.cells(rowId,7).getValue();
  var start = mygrid.getUserData(rowId,"startDate");
  var end = mygrid.getUserData(rowId,"endDate");
  var matterId = mygrid.getUserData(rowId,"matterId");
  
  var customerId =  Ext.getCmp('customerName').getValue();	
  var matterType = mygrid.getUserData(rowId,"matterType");
  var brandId = mygrid.getUserData(rowId,"brandId");  
  

  
  
  var num = mygrid.cells(rowId,8).getValue();
  var cont = rowId+","+ name+","+ edit+","+ length+","+ start+","+ end +","+ num+","+ matterId;
  
  var urlStr="selectPopup/selectMatterEditChange.html?mode=1&orgId="+orgId+"&order_year="+order_year +"&ctxPath="+ ctxPath +"&orderDetailId="+rowId;
  
  var urlStr= urlStr + "&brandId="+brandId +"&customerId="+customerId +"&matterType="+matterType+"&advname="+name+"&advlength="+length+"&createBy="+sessionUserId;


  urlStr = encodeURI(urlStr +"&cnt=" +cont);
  
  
  
  
   function getDetailTableFun(){
//			getOrderDetail(rowId);
			getOrder(order.obj.id);
	}
		
  
  var closeFun = function(){removeWin();};
  var okBtn ={text: '保存',handler: function(){
  		document.getElementById('userReliframe').contentWindow.save(closeFun);
  		getOrderDetailTable(orderDetail,getDetailTableFun);
  	}};	
  var closeBtn ={text: '关闭',handler: function(){removeWin();}}; 
  
  
  
  
        
 var win = new Ext.Window({
   title : '广告换版本',
   width : 500,
   height : 300,
   isTopContainer : true,
   modal : false,
   resizable : false,
    buttons: [okBtn,closeBtn],
   contentEl : Ext.DomHelper.append(document.body, {
    tag : 'iframe',
     id : 'userReliframe',
    style : "border 0px none;scrollbar:true",
    src : urlStr,
    height : "100%",
    width : "100%"
   })
  })
  win.show(); 
  
   function removeWin(){
  		win.destroy();
   	} 
   win.on({'close': {fn: removeWin}});   
  
  
}
