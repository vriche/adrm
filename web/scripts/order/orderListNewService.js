
 var order = new Order();
 var orderCategory = new OrderCategory();
 var checkState = new OaWorkFlowCheckState();
 var user = new User();
 var customer = new Customer();
 var category = new Category();
 var customerType = new CustomerType();
 var matter = new Matter();
 var carrier =new  Carrier();
 var resourceSort = new ResourceSort();
 var carrierType = new CarrierType();
 var report = new MyPrint();
 var orderDetail = new OrderDetail();
 var myDate = new MyDate();
  
 var channelModelParam;
 var config_serviceDate;
 var useCarrierAliname;
 var curSessionId;
 var carrSortIds;
 var mygrid;
 var myUtils = new MyUtils();
 var scrollTop = 0;
 var posStart = 0;
// var posCount = 0;
 var total_count = 0;
 var fromEditRowId = 0;
 var initparamObj ={};
 var f_int = false;
 var ctxPath;
 var order_check_right;
 var defOrgIds;
 var order_year;
 var loginUserId;
 
 var mygrid3;
var mygrid4;
var proveWin;
var checkAdvWin;


var build_more_paraArray;
// Ext.onReady(function(){  
//    var menu = new Ext.menu.Menu({  
//        minWidth:200,  
//        items:[{  
//            text:"first",  
//            handler:function(){Ext.Msg.alert("hello","我是菜单")}  
//        }]  
//    });  
////        var el = Ext.get("menu_test");  
////    el.on("click",function(e){  
////        //menu.showAt(e.getXY());//作用于该位置  
////        menu.show(this);//作用于元素上  
////        //e.getXY();//得到事件触发的坐标  
////    })  
//        //作用于页面上的鼠标右键  
//    Ext.getDoc().on("contextmenu",function(e){  
//    	alert(e.id);
//        e.stopEvent();//终止之前的事件响应，不然还会在页面上弹出讨厌的ie右键菜单  
//        menu.showAt(e.getXY());  
//    })  
////        //当然我们也可以让他租用在el的鼠标右键事件中  
////        el.on("contextmenu",function(e){  
////        menu.showAt(e.getXY());  
////        e.stopEvent();  
////        menu.show(this);  
////        //e.getXY();  
////    })  
//});
// 
 

    
callOnLoad(init);	
  
 function init(){
 	

 	ctxPath =  _app_params.ctxPath;	 	
 	
 	config_serviceDate = _app_params.serviceDate.def;
 	
// 	alert(_app_params.serviceDate.adrmSysYear);
   
 	_make_adrm_sys_year_select("order_year",_app_params.serviceDate.adrmSysYear);
 	
 	userName =  _app_params.user.username;
 	loginUserId =  _app_params.user.id;
 	
 	channelModelParam = _app_params.sysParam.channelModelParam;
 	tvNameParam =  _app_params.sysParam.tvNameParam;
 	withoutSubmit =  _app_params.sysParam.withoutSubmit;
 	useCarrierAliname =  _app_params.sysParam.useCarrierAliname;
 	useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
 	useLanmuSingleParam = _app_params.sysParam.useLanmuSingleParam;
 	
 	order_check_right =  _app_params.rights.tag_orderList_check;
 	tag_orderDetail_save =  _app_params.rights.tag_orderDetail_save;
	tag_orderList_new =  _app_params.rights.tag_orderList_new;
	tag_order_submitbtn =  _app_params.rights.tag_order_submitbtn;
	tag_order_leadmemo =  _app_params.rights.tag_order_leadmemo;
 	tag_order_paymentbtn =  _app_params.rights.tag_order_paymentbtn;
 	tag_bro_prove =  _app_params.rights.tag_bro_prove;
 	

 	config_channelModelParam = _app_params.sysParam.channelModelParam;
 	config_orderDisplayRelcodeParam = _app_params.sysParam.orderDisplayRelcodeParam;
 	config_orderDisplayIncomeParam = _app_params.sysParam.orderDisplayIncomeParam;
 	config_oneOrgMoreSuborgsParam = _app_params.sysParam.oneOrgMoreSuborgsParam;
 	config_fastSignOrderParam = _app_params.sysParam.fastSignOrderParam;
  
// 	defOrgIds = _app_params.rights.userOrgIds.split(",");
 	getDate(_app_params.serviceDate.year);
 	
 	 var srcStr= window.location.href;
 	 scrollTop  = getParamFromUrl(srcStr,"scrollTop");	
 	 posStart = getParamFromUrl(srcStr,"posStart");	
// 	 posCount = getParamFromUrl(srcStr,"count");	
     total_count = getParamFromUrl(srcStr,"total_count");	
     fromEditRowId = getParamFromUrl(srcStr,"id");	
     
    
//						alert($("orderRelPay").value)
     
     var f_int = getInitparamObj(posStart);
     
//     						alert($("orderRelPay").value)
    
 	
    this.ctxPath = ctxPath;
	this.report.buildButtons(this,"printReportDiv",[0,1,2,7],80);
 	
 	setRelationCodePara(order);
 	setOrderPara(order);
 	setCheckStatePara(checkState);
 	setUserPara(user);
// 	setCustomerPara(customer);
	setOrderCategoryPara(orderCategory);
	setMatterPara(matter);	
	setCarrierPara(carrier);
	setResourceSortPara(resourceSort);
	
	carrier.obj.nodeLevel =1;
	carrier.obj.enable = false;
//	carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","");makeSelectItemFromMap
//	carrier.makeSelectItemFromMapOrderList(carrier.obj,"carrierName","",setCarrierSelected);

//    if(useMoreCarrierSortParam =='0' || isUndefined(useMoreCarrierSortParam)) makeCarrierSelectItem();


 	 _make_org_select("orgId",120,"onOrgChange");	
// 	 alert(posStart)
// 	 alert(f_int)
// 	 alert(initparamObj.orgId)
	 if(f_int && initparamObj.orgId) $("orgId").value = initparamObj.orgId; 
	 
	 
	 
	 
 	customer.obj.orgId = config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value; 	 
// 		customer.obj.orgId = $("orgId").value;
 	customer.obj.version = _app_params.serviceDate.year;
 	customer.obj.loginUser = userName;
 	customer.obj.model = "1";

 	var callBackFun = function(){};
 
 	var cmd = customer.getCustomerRemote("theDivCustomerName","customer_name",100,function(){
// 		alert(initparamObj.customerName);
//  	 	if(f_int && initparamObj.customerName){
//  	 		 Ext.getCmp('customer_name').setValue(initparamObj.customerName);
//  	 		  Ext.getCmp('customer_name').setRawValue(initparamObj.customerName);
// 		}		
 	});
 	
 	function resetUserStore(){
 		var customerId =  Ext.getCmp('customer_name').getValue();
 		if(customerId > 0){
 			var cmd1 =  Ext.getCmp('userOwner');
			var store1 = cmd1.getStore();
		    store1.baseParams.dwrParams[0].customerIds = customerId;
	
			store1.reload();
 		}
 	}
 	cmd.on("select",resetUserStore,this);	
 	cmd.on("clear",function(){
 		var store1 =Ext.getCmp('userOwner').getStore();
 		store1.baseParams.dwrParams[0].customerIds =null;
 		store1.reload();
 		},this);	
 	
 	
 	
  	 	if(f_int && initparamObj.customerName){
  	 		 Ext.getCmp('customer_name').setValue(initparamObj.customerName);
  	 		  Ext.getCmp('customer_name').setRawValue(initparamObj.customerName);
 		  }		
 		  
 	  	 	if(f_int && initparamObj.customerId){
  	 		 Ext.getCmp('customer_name').setValue(initparamObj.customerId);
  	 		  Ext.getCmp('customer_name').setRawValue(initparamObj.customerName);
 		  }			  
 		  

 	function specialKey(field, e){
		 if (e.getKey() == Ext.EventObject.ENTER) {//响应回车  
		      DWRUtil.onReturn(e,loadGridData);	
		 }
 	}
 	cmd.on("specialKey",specialKey,this);	




    category.obj.loginUser = userName;
 	category.makeSelectAnalyze("customerCategorys","loadGridData",function(){
  	 	if(f_int){
  	 		if(initparamObj.cutCates)
 			$("customerCategorys").value = initparamObj.cutCates;
 		}		
 	});
 		

	var width1=100;
 	checkState.makeSelectFromMap(checkState.selectName,"",width1,function(){
 		if(f_int){
 			if(initparamObj.orderStates){
 				$(checkState.selectName).value = initparamObj.orderStates;
 			}else{
 				$(checkState.selectName).value ='';
 			}
 			
 		}
 	});
 	


    /************************get user cmd*********************************/
 	user.obj.type = 1;
 	user.obj.version = $("order_year").value;
 	user.obj.orgId = f_int == true?initparamObj.orgId:$("orgId").value;
 	user.obj.loginUser = userName;
 	user.getUsersFromOrder("signUserDiv","userOwner",100,function(){
 	if(f_int){
 	 		if(initparamObj.userId)
 	 		 Ext.getCmp('userOwner').setValue(initparamObj.userId);
 		}	
 	});		
    /*******************************************************************/

    /************************get user cmd*********************************/
 	user.obj.type = 2;
 	user.getUsersFromOrder("createByIdDiv","createById",100,function(){
  	 	if(f_int){
  	 		if(initparamObj.createBy)
  	 		 Ext.getCmp('createById').setValue(initparamObj.createBy);
 		}		
 	});		
    /*******************************************************************/	

 	
// 	orderCategory.makeCategoryFromMap($("orgId").value,$("order_year").value,"orderCategoryId",function(){
//  	 	if(f_int){
//  	 		if(initparamObj.categoryId)
// 			$("orderCategoryId").value = initparamObj.categoryId;
// 		}			
// 	});
 	
// 	orderCategory.obj.orgId = $("orgId").value;
 	orderCategory.obj.orgId = config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value; 	
 	 
 	orderCategory.obj.version = $("order_year").value;
  	orderCategory.makeSubCategoryFromOrder("orderCategoryIdDiv","orderCategoryId",100,'remote',function(){
  	 	if(f_int){
  	 		if(initparamObj.categoryId)
 			 Ext.getCmp('orderCategoryId').setValue(initparamObj.categoryId);
 		}			
 	});	
     	
 	


// 	$("orderCategoryId").setAttribute("style","width:100px;font-size:12px;");
 	
 	resourceSort.makeSelectFromMap2("resourceSortId",null,width1,function(){
	 	if(f_int){
	 		    if(initparamObj.carrierType)
	 			$("resourceSortId").value = initparamObj.carrierType;
	 	}				
 	});

// 	customerType.makeSelectAnalyze(customerType,"customerTypes","getTable",function(){});




	var selectIsArrears = $("isArrears");
 	if(!isUndefined(selectIsArrears)){ 	
		$("isArrears").setAttribute("style","width:100px;font-size:12px;");
	}
	
	var selectmoneyRealpay = $("moneyRPay");
 	if(!isUndefined(selectmoneyRealpay)){
		$("moneyRPay").setAttribute("style","width:100px;font-size:12px;");
	}
	
//	$('Btn_myOrder').hide();  
//
//	if(withoutSubmit==1){
////		$('submitChecked').hide(); 
//		$('selectOrder').hide();
// 	}else{
// 		$('selectOrder').hide();
// 		var isCheckedOrder = $("isCheckedOrder");
////		if(!isUndefined(isCheckedOrder)){
////			$('isCheckedOrder').hide();
////		} 	
// 	}


 	if(tvNameParam =='fztv'){
 		$('selectOrder').show();
// 		$('Btn_myOrder').show();   	
// 		span1.setAttribute("id","span1");
 	 	var func=function(userId){
			curSessionId = userId;
		}
		user.getCurUserId(userName,func)	
 	}

	if(useLanmuSingleParam =='1'){
		$('TDcarrierType').show();
	}
	
	
	
	
	

	
	$('TDcustomerCategorys').show();
	
 	buttonEventFill();
 	
 	//提交完查询后，把隐藏区的值设置到查询条件中

// 	if(useMoreCarrierSortParam =='1'){
//
//         function funct(){ 
//         	var obj = $("carrierSort");
//
//	 	 	if(f_int){
//	 	 		if(initparamObj.carrSort){
//	 	 			for(var k = 0; k < obj.options.length;k++){
//		 	 			 if(obj.options[k].value.split("_")[0] == initparamObj.carrSort){
//		 	 			 	obj.options[k].selected = true;
//		 	 			 }
//	 	 			}
//	 	 		}
//
//	 		}	         	
////         	geuserCmd();
//         	initGrid();	
//         }
// 		 carrierType.makeSelectByLoginUser("carrierSort","onCarrierSortChange",null,funct,userName,1);
// 	}else{
//// 		geuserCmd();
//// 		carrierType.makeSelectByLoginUser("carrierSort","onCarrierSortChange",null,null,userName,1);
////		initGrid();
// 	}
// 	
 	
 	

 	
 	
 	initGrid();	
 	initGrid3();
// 	initGrid4();
 	
 	
 	
 	
 	
	 //customer.getCustomerAutoComplet(payCustomerAutoComplet,customer.obj);
	 
//	 initGrid();
 }
 
 




//function geuserCmd(){
// 	function getUserParams(){
// 		user.obj.type = 1;
// 		user.obj.orgId = $("carrierSort").value.split("_")[0];
// 		user.obj.loginUser = userName;
// 	}
// 	
// 	getUserParams();
// 	
// 	user.getUsersFromOrder("signUserDiv","userOwner",100,1,function(){
// 	 	if(f_int){
// 	 		if(initparamObj.userId)
//// 			$(user.selectName).value = initparamObj.userId;
// 			user.commandFromOrder.setValue(initparamObj.userId);
//// 			Ext.getCmp('userOwner').setValue(initparamObj.userId);
////            Ext.getCmp('userOwner').getValue();	
// 		}	
// 	});	
//	
//}







//function attachFooter(a,b,c){
//	alert(a);
//}
 
 
 
 function edit_order(id){
	 load_data(id);
 }
 
 function onRowDblClicked(id,cellInd){
	 load_data(id);
}

function load_data(id){
	 var url = mygrid.getUserData(id,"href");
//	 var orgId = mygrid.getUserData(id,"orgId");
     var param = $H(url.toQueryParams());
     
//     var orgId = config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value; 	
//     param.orgId = orgId;
	 param.set("scrollTop",mygrid.objBox.scrollTop);
	 url =  ctxPath + "editOrder.html?" + param.toQueryString();	
	 self.location =url;	
}
 function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
mygrid.selMultiRows = false;
		mygrid.delim ="*"
	mygrid.setImagePath("image/grid/");
	var displayRelcode = (config_orderDisplayRelcodeParam ==1);
	var displayIncomeParam = (config_orderDisplayIncomeParam ==1);
	

	
	var	flds = "";

		if(displayRelcode){
				if(displayIncomeParam){
			    	flds = "订单编号*关联编号*合同编号*客户名称*广告名称*备注*开始日期*结束日期*应付*分配*业务员*状态";
			    }else{
			    	flds = "订单编号*关联编号*合同编号*客户名称*广告名称*备注*开始日期*结束日期*应付*业务员*状态";
			    }
			
		}else{
				if(displayIncomeParam){
			    	flds = "订单编号*合同编号*客户名称*广告名称*备注*开始日期*结束日期*应付*分配*业务员*状态";
			    }else{
			    	flds = "订单编号*合同编号*客户名称*广告名称*备注*开始日期*结束日期*应付*业务员*状态";
			    }
			
		}
		

	
	mygrid.flds = flds;
	var	columnIds ="";
	if(displayRelcode){
		if(displayIncomeParam){
			columnIds =  "checkboxall*seq*pos*name*edit*len*spec*start*end*times*opter*opter2*opter3";  
			mygrid.setHeader("checkboxall*"+flds);
			mygrid.setColumnIds(columnIds);
		    mygrid.setInitWidthsP("2*8*9*8*14*13*5*8*8*7*7*6*5");
		    mygrid.setColSorting("str*int*str*str*str*str*str*str*str*int*int*str*str");
			mygrid.setColAlign("center*center*center*center*left*left*left*center*center*right*right*center*center");
			mygrid.setColTypes("ed*ed*ed*ed*ed*ed*ed*ed*ed*ed*ed*ed*ed");
		}else{
			columnIds =  "checkboxall*seq*pos*name*edit*len*spec*start*end*times*opter2*opter3";  
			mygrid.setHeader("checkboxall*"+flds);
			mygrid.setColumnIds(columnIds);
		    mygrid.setInitWidthsP("2*8*9*8*18*16*5*8*8*7*6*5");
		    mygrid.setColSorting("str*int*str*str*str*str*str*str*str*int*str*str");
			mygrid.setColAlign("center*center*center*center*left*left*left*center*center*right*center*center");
			mygrid.setColTypes("ed*ed*ed*ed*ed*ed*ed*ed*ed*ed*ed*ed");			
		}

	}else{
		if(displayIncomeParam){
			columnIds =  "checkboxall*seq*name*edit*len*spec*start*end*times*opter*opter2*opter3";  
			mygrid.setHeader("checkboxall*"+flds);
			mygrid.setColumnIds(columnIds);
		    mygrid.setInitWidthsP("2*8*9*18*13*5*8*8*9*9*6*5");
		    mygrid.setColSorting("str*int*str*str*str*str*int*str*str*int*str*str");
			mygrid.setColAlign("center*center*center*left*left*left*center*center*right*right*center*center");
			mygrid.setColTypes("ed*ed*ed*ed*ed*ed*ed*ed*ed*ed*ed*ed");
		}else{
			columnIds =  "checkboxall*seq*name*edit*len*spec*start*end*times*opter2*opter3";  
			mygrid.setHeader("checkboxall*"+flds);
			mygrid.setColumnIds(columnIds);
		    mygrid.setInitWidthsP("2*8*9*23*17*5*8*8*9*6*5");
		    mygrid.setColSorting("str*int*str*str*str*str*int*str*str*str*str");
			mygrid.setColAlign("center*center*center*left*left*left*center*center*right*center*center");
			mygrid.setColTypes("ed*ed*ed*ed*ed*ed*ed*ed*ed*ed*ed");	
		}


	}

	
	

	mygrid.setEditable(false);
	//mygrid.setOnRowSelectHandler(onRowSelectd,true);
	mygrid.setOnScrollHandler(OnScrollHandler);
	mygrid.setSkin("modern2");
//	mygrid.enableAlterCss("even","uneven");
	
//    mygrid.enableMultiline(true); 
	mygrid.enableMultiselect(true); 
//	mygrid.enableLightMouseNavigation(true);  
	mygrid.enableKeyboardSupport(true);  
	mygrid.setOnRowSelectHandler(onRowSelected,true);
	mygrid.setOnRowDblClickedHandler(onRowDblClicked,true);
//	mygrid.enableAutoSizeSaving();
	
	
//	mygrid.enableBlockSelection(true);
	
//	alert(mygrid.setOnBlockSelectHandler)
//	
//	function aa(){alert(1)};
//	mygrid.setOnBlockSelectHandler(aa);
//	grid.attachEvent("onBlockSelected", function(){});
//	mygrid.saveSizeToCookie();
//	mygrid.saveSizeToCookie("order_List_grid_cooker","expires=Fri, 31-Dec-2015 23:59:59 GMT");
	
//	mygrid.enableAutoSizeSaving("order_List_grid_cooker","expires=Fri, 31-Dec-2015 23:59:59 GMT");
//	mygrid.setOnBeforeSelect(onBeforeSelect,true);
//	mygrid.enableBlockSelection(true);
//    mygrid.setOnBlockSelected(onBlockSelected,true);
    
//	onBlockSelected


//	 	mygrid.dynScroll = true;
//	    mygrid.recordsNoMore = true;
//	    mygrid.dynScrollPos = 200;
//	 	mygrid.rowsBufferOutSize = 100;





	resetHeigth();
		
	mygrid.init();	
	

	
//	mygrid.attachHeader("合计,<div id='total_Q' align='left'>大写：</div>,#cspan,#cspan,#cspan,<div id='total_A'>?0.00</div>,#cspan,#cspan,#cspan,#cspan,#cspan,#cspan,#cspan,#cspan,","height:20px;","ftr");
//		mygrid.attachFooter('G,H,I');
//        mygrid.setSizes();
	


	attachHeaderNew(mygrid,"<input type='checkBox' id='allSelect' value='' >,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan");
	
	
//			mygrid.setColumnHidden(0,true);
//			mygrid.setInitWidthsP("11,9,8,16,13,8,8,8,8,6,5");

	loadGridData(posStart);
	
	
}

function resetHeigth(){
    var dialogcontent = $("dialogcontentDiv");
    var gridbox = $("gridbox");
//    gridbox.style.height = dialogcontent.offsetHeight * 0.86 +"px";	
    if(mygrid){
    	gridbox.style.height = dialogcontent.offsetHeight * 0.86 +"px";	
    	mygrid.setSizes();
    }
} 
 function selectCheckBoxAll(){
 	var v = $("allSelect").checked;
 	mygrid.setAllChecks(0,v);

 }

function onRowSelected(id,cellInd){

	if(cellInd != 1){
		var checkeds = [];
		if(mygrid.getSelectedId() != null){
		     checkeds =mygrid.getSelectedId().split(mygrid.delim);  
		}	
		
		if(checkeds.length >1){
			for(var i=0;i<checkeds.length;i++){
				setCellCheck(this,checkeds[i],0,1);
			} 
		}else{
			setCellCheck(this,checkeds[0],0);
		}
		
		
	}
}

function onBeforeSelect(id,cellInd){
	if(cellInd != 1){
		setCellCheck(this,id,0);
	}
}

function onBlockSelected(id,cellInd){

}





function getInitparamObj(posStart){


//	if(posStart > 0 || posStart == 0){
		var srcStr = window.location.href;
		
	
		
        var param =  srcStr.toQueryParams();

        param.fromEdit = posStart;	
        
        initparamObj = $H(param);
        
       

        initparamObj.unset("posStart");initparamObj.unset("count");initparamObj.unset("total_count");initparamObj.unset("scrollTop");initparamObj.unset("sn");   
             
        initparamObj = initparamObj.toObject();
        
        

//        if(initparamObj.customerName)
//        $("customer_name").value = initparamObj.customerName;
        if(initparamObj.orgId)
        $("orgId").value = initparamObj.orgId;
        
         if(initparamObj.version)
        $("order_year").value = initparamObj.version;       

        
        if(initparamObj.orderCode)
        $("order_code").value = initparamObj.orderCode;
        if(initparamObj.contractCode)
 		$("contract_code").value = initparamObj.contractCode;
 		 if(initparamObj.relationCode)
  		$("relation_code").value = initparamObj.relationCode;
  		 if(initparamObj.matterName)
   		$("matter.name").value = initparamObj.matterName;
   		 if(initparamObj.publishStartDate)
//   		$("beginDate").value =  getFormatDay(initparamObj.publishStartDate,'y/m/d');
   		Ext.getCmp('beginDate').setValue(myDate.parseDate(getFormatDay(initparamObj.publishStartDate,'y-m-d')));
   		
   		 if(initparamObj.publishEndDate)
//   		$("overDate").value =  getFormatDay(initparamObj.publishEndDate,'y/m/d');
				Ext.getCmp('overDate').setValue(myDate.parseDate(getFormatDay(initparamObj.publishEndDate,'y-m-d')));
   		
   		 if(initparamObj.carrIds)
   		$("carrierName").value = initparamObj.carrIds;
   		 if(initparamObj.carrierType)
        $("carType").value = initparamObj.carrierType;
         if(initparamObj.moneyState)
        $("isArrears").value = initparamObj.moneyState;
         if(initparamObj.version)
         $("order_year").value = initparamObj.version;
          if(initparamObj.orderMeno)
         $("orderMeno").value = initparamObj.orderMeno;        
          if(initparamObj.isDayRealPlay)
         $("isDayRealPlay").checked  = (initparamObj.isDayRealPlay == 'true')?true:false;      

          if(initparamObj.orderRelPay) {$("orderRelPay").value  = initparamObj.orderRelPay; }    
          	  
						if(initparamObj.orderRate1)  {$("orderRate1").value  = initparamObj.orderRate1; }
						if(initparamObj.orderRate2) {$("orderRate2").value  = initparamObj.orderRate2;  }    
						
						
						

						       
        return true;
//	}else{
//		 return false;
//	}

}

function setCellCheck(grid,id,colIndex,state){
	var cell = grid.cells(id,colIndex);
	var v = cell.getValue()==0?1:0;
	v = state || v;
	if(cell.getValue() && cell.isCheckbox())cell.setValue(v);	
	return v;
}
function attachHeaderNew(grid,htm){
	var cin =1;
	var h = htm.split(",");
	//alert(h.length);
	var z =  grid.hdr.rows[1];
	var c = z.cells[z._childIndexes?z._childIndexes[parseInt(cin)]:cin];

	for(var cin = 0; cin<h.length;cin++){
		if(h[cin].indexOf("#rspan") != 0) {
			var c = z.cells[z._childIndexes?z._childIndexes[parseInt(cin)]:cin];
			c.innerHTML = h[cin];
		}

	}
	
	$("allSelect").onclick  = selectCheckBoxAll;
	
}




function OnScrollHandler(sLeft,sTop){

	 
//	 alert(mygrid.scrollTop);
	
//		if(posStart > 0 ){ 	  
//			mygrid.scrollTop = null;
//			mygrid.posStart = null;   
//			mygrid.fromEditRowId = null;   
//		}

	
	
//	 mygrid.posStart = null;
//	 mygrid.scrollTop = null;
	 
//    var loadDataURL =getLoadDataURL();
    
//    alert(mygrid._dload);
//     mygrid._dload = loadDataURL;      
}


 function getLoadDataParams(posStart,isNew){
 	
 	
 	var startd = Ext.getCmp('beginDate').getValue().format("Y/m/d");			
 	var endd = Ext.getCmp('overDate').getValue().format("Y/m/d");	
 	var isPass = searchyear(startd,endd);
//	var isPass = searchyear($("beginDate").value,$("overDate").value);
	

		 
		 
		
	if(!isPass) return false;

	var carrierId = $("carrierName").value;
	carrierId = carrierId == 'undefined' ||isUndefined(carrierId)||carrierId==null?'':carrierId;

    var customerId =  Ext.getCmp("customer_name").getValue();
    var customerName = Ext.getCmp("customer_name").getRawValue();
    var mofuFind = customerName !='' && customerName == customerId;
    if(mofuFind){customerId = null; }

//	   if(customerId =='') customerName = null;

	var orderCode = $("order_code").value;
	if(orderCode.indexOf("=") > -1) orderCode = null;
	 
	var contractCode = $("contract_code").value;
	if(contractCode.indexOf("=") > -1) contractCode = null;	 
	

	
	var relationCode = $("relation_code").value;
	if(relationCode.indexOf("=") > -1) relationCode = null;

	
	var matterName = $("matter.name").value;
	if(matterName.indexOf("=") > -1) matterName = null;	
	
	
	var paramObj ={};
	
//	if($(checkState.selectName).value == 7 ){
//		$("beginDate").value = 0;
//		$("overDate").value = 0;
//	}else{
//		if($("beginDate").value == 0 || $("overDate").value == 0){
//			$("beginDate").value = getFormatDay($("order_year").value+'0101','y/m/d');
//			$("overDate").value= getFormatDay($("order_year").value+'1231','y/m/d');
//		}
//		
//	}
	if($(checkState.selectName).value == 7 ){
		Ext.getCmp('beginDate').setValue('1900-01-01');
		Ext.getCmp('overDate').setValue('1900-01-01');
	}else{
		if(Ext.getCmp('beginDate').getValue() == 0 || Ext.getCmp('overDate').getValue() == 0){
				Ext.getCmp('beginDate').setValue(myDate.parseDate(getFormatDay($("order_year").value+'0101','y-m-d')));
				Ext.getCmp('overDate').setValue(myDate.parseDate(getFormatDay($("order_year").value+'1231','y-m-d')));
		}
		
	}
	
	
	
	
	

	
	
	
	
	var orderRate1 = $("orderRate1").value;
	orderRate1 = orderRate1 == 'undefined' ||isUndefined(orderRate1)||orderRate1==null?'':orderRate1;	

 
 	var orderRate2 = $("orderRate2").value;
	orderRate2 = orderRate2 == 'undefined' ||isUndefined(orderRate2)||orderRate2==null?'':orderRate2;	
	
	
	
	if(orderRate1 !='' && orderRate2 ==''){
		 orderRate2 = 100;
		 $("orderRate2").value = orderRate2;
	}
 
    
		if(posStart > 0 || posStart == 0){ 	  
//			 var srcStr= window.location.href;
////		     var pos = srcStr.indexOf("createXML");
////			 var paramStr = srcStr.substring(0,pos+9);
//             var param =  srcStr.toQueryParams();
//             param.fromEdit = posStart;	
////             param.customerName = '';
//
//      
//             var paramObj = $H(param);
//             paramObj.unset("posStart");paramObj.unset("count");paramObj.unset("total_count");paramObj.unset("scrollTop");paramObj.unset("sn");
////             paramObj.unset("fromEditRowId");
////             paramObj = paramObj.toObject();
//
////              alert(paramObj.toQueryString());
//
////             paramObj = initparamObj;
////            alert( $H(paramObj).toQueryString());

              paramObj = initparamObj;

		}else{
			  var parentOrgId = config_oneOrgMoreSuborgsParam == '1' && isNew?1:$("orgId").value;

			  
			  var orgId = $("orgId").value;
			  var publishStartDate = Ext.getCmp('beginDate').getValue().format("Ymd"); 
				var publishEndDate = Ext.getCmp('beginDate').getValue().format("Ymd"); 
				if(publishStartDate =='19000101'){
					publishStartDate = 0;
					publishEndDate = 0;
				}

			  
	 		  paramObj = {
				 	customerName: customerName,
				 	customerId:customerId,
	                orderCode: orderCode,
	                contractCode:contractCode,
	                relationCode:relationCode,
	                matterName: matterName,
	//                matterId: $("matterId").value,
	                carrIds: carrierId,
	                userId:  Ext.getCmp('userOwner').getValue(),
	                createBy: Ext.getCmp('createById').getValue(),
	                cutCates: $("customerCategorys").value,
	                carrierType: $("carType").value,
	//                carrSort: $("carrierSort").value,
	//                publishMemo: $("publishMemo").value,
	                moneyState: $("isArrears").value,
	                moneyRealpay: $("moneyRPay").value,
	                orderStates:$(checkState.selectName).value,
	                orderMeno:$("orderMeno").value,
//	                categoryId:$("orderCategoryId").value,
	                categoryId: Ext.getCmp('orderCategoryId').getValue(),
	                
//	                publishStartDate:getFormatDay($("beginDate").value,'ymd'),
//	                publishEndDate:getFormatDay($("overDate").value,'ymd'),
	                
	    	            publishStartDate: Ext.getCmp('beginDate').getValue().format("Ymd"),	
	                publishEndDate: Ext.getCmp('overDate').getValue().format("Ymd"),		
	               	
	                
	                version:$("order_year").value,
//	                parentOrgId: parentOrgId,
	                orgId: orgId,
	                loginUser:userName,
	                isDayRealPlay:$("isDayRealPlay").checked,
	                orderRelPay:$("orderRelPay").value,
	                orderRate1:orderRate1,
	                orderRate2:orderRate2
//	                posStart:mygrid.posStart?mygrid.posStart:0,
//	                scrollTop:mygrid.scrollTop?mygrid.scrollTop:0
			};	
		
		}
		
		
//		alert($("orderCategoryId").value);
        
//        if(posStart > 0 || posStart == 0) {
//        	paramObj.fromEdit = posStart;	
//        }

		return paramObj;

 }

 function loadGridData(posStart){
       
        var paramObj = getLoadDataParams(posStart);
        
	 	mygrid.clearAll();
	 	mygrid.detachFooter(0);
	 	
	 	if(posStart > 0 || posStart == 0){
//	 		alert(total_count)
	 		 mygrid.posStart = posStart;
//	 		 mygrid.posCount = posCount;
	 		 mygrid.scrollTop = scrollTop;
	 		 mygrid.fromEditRowId = fromEditRowId; 
	 		 mygrid.enableSmartRendering(true,total_count);

		}else{
			 mygrid.enableSmartRendering(true);
		}	

//		 console.log($H(paramObj).toQueryString());
//		 var par = encodeURI(h.toQueryString());
		 loadDataURL ="servlet/orderListServlet?" + $H(paramObj).toQueryString();	
//		 loadDataURL ="servlet/orderListServlet?" + $H(paramObj).toQueryString();		
		 
//		 var srcStr = unescape(window.location.search);
//		 var srcStr = unescape(loadDataURL);
//		 alert(srcStr);
		 
	
		 mygrid.loadXML(loadDataURL);
//		 mygrid.loadXML(encodeURI(loadDataURL));
//		  mygrid.loadXML(unescape(loadDataURL));
//		 mygrid.loadSizeFromCookie();	
//		 mygrid.loadSizeFromCookie('order_List_grid_cooker');		
		 mygrid.setSizes();	
		
		closeSearchDiv();        
 }


function resetUserStore(){
	var orgId =  config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value; 
	var orgIdRel =  $("orgId").value; 		
			  
	var version = $("order_year").value;
	
	var cmd1 =  Ext.getCmp('userOwner');
	var store1 = cmd1.getStore();
	store1.baseParams.dwrParams[0].orgId = orgIdRel;
    store1.baseParams.dwrParams[0].version = version; 
	store1.reload();
	cmd1.clearValue(); 
	
	var cmd2 =  Ext.getCmp('createById');
	var store2 = cmd2.getStore();	
	store2.baseParams.dwrParams[0].orgId = orgIdRel;
	store2.baseParams.dwrParams[0].version = version; 
	store2.reload();	
	cmd2.clearValue(); 
	
	
	var cmd3 =  Ext.getCmp('orderCategoryId');
	var store3 = cmd3.getStore();	
	store3.baseParams.dwrParams[0].orgId = orgId;
	store3.baseParams.dwrParams[0].version = version; 
	store3.reload();	
	cmd3.clearValue(); 
	

	var cmd4 =  Ext.getCmp('customer_name');
	var store4 = cmd4.getStore();	


	if(store4.baseParams.dwrParams){
		store4.baseParams.dwrParams.loginUser = userName;
		store4.baseParams.dwrParams.orgId = orgId;
		store4.baseParams.dwrParams.version = version; 
		store4.reload();
		if(cmd4.mode == 'local'){
			store4.clearValue(); 
		}else{
			cmd4.setValue('');
		}
			
	}else{
		
		customer.obj.orgId = orgId;
	 	customer.obj.version = version;
	 	customer.obj.loginUser = userName;
	 	customer.obj.model = "1";
//	    Ext.apply(store4.baseParams, {dwrParams:customer.obj});
	}

}
 
function onOrgChange(e){
	     
// 		 $("carrierName").value = e.value.split("_")[1];
 		 $("carrierName").value ='';

 		 resetUserStore();
 		 
// 		 refrshOrderList();
 		 
 		 loadGridData();
 		 

 		 
// 		 orderCategory.makeCategoryFromMap($("orgId").value,$("order_year").value,"orderCategoryId",function(){});
}
 		 
 function makeCarrierSelectItem(){
	//根据是否分频道，取得频道下拉列表
	
	carrier.makeSelectItemAnalyze5(carrier,"carrierName","",100,false,userName,setCarrierSelected); 
}
 function setRelationCodePara(obj){
	 obj.className  = "order";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "relationCode";
	 
}
 
 function setCarrierPara(obj){
	obj.className  = "carrier";
	obj.IdPrefix 	= obj.className + "Id";
	obj.selectName = obj.className+"Name";
}
function setResourceSortPara(obj){
	 obj.selectName =  "resourceSortId";
}
 
 
 function setMatterPara(obj){
	 obj.className  = "matter";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "matterId";
}
 
 function setOrderCategoryPara(obj){
	 obj.className  = "orderCategory";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "orderCategoryId";
}




function getDate(order_year){
	

	$("order_year").value = order_year;
//	$("beginDate").value = getFormatDay(order_year+'0101','y/m/d');
//	$("overDate").value= getFormatDay(order_year+'1231','y/m/d');
	
//	 var def_start_Dat =   myDate.parseDate(getFormatDay(_app_params.serviceDate.format2,"y-m-d"));
	 

	
				 	var startDateFileld =  new Ext.form.DateField({
		        fieldLabel : '开始日期',
		        id : 'beginDate',
		        name : 'beginDate',
		        enableKeyEvents : true,
		        width : 85,
		        allowBlank : false,    
		        format : 'Y-m-d',
//		        value:def_start_Dat,
//		        value: myDate.parseDate(getFormatDay(_app_params.serviceDate.format2,"y-m-d"))
		        renderTo:'beginDateDiv',
//		       	value:myDate.parseDate(myDate.getStartDay3(def_Dat,"yyyy-MM-01"))
		       });  
		  	var endDateFileld =  new Ext.form.DateField({
		        fieldLabel : '结束日期',
		        id : 'overDate',
		        name : 'overDate',
		        enableKeyEvents : true,
		        width : 85,
		        allowBlank : false,    
		        format : 'Y-m-d',
//		        	value:new Date()
// 							value:def_start_Dat,
		        renderTo:'overDateDiv',
//		       	value: myDate.getEndDay3(def_Dat,"yyyy-MM-dd")
		       });  
		       



	Ext.getCmp('beginDate').setValue(getFormatDay($("order_year").value+'0101','y-m-d'));
	
	Ext.getCmp('overDate').setValue(getFormatDay($("order_year").value+'1231','y-m-d'));
	

	
//	function dateDisabledFunc(date,i){
//		if(i == 1){
//		   var pval = ''+$("overDate").value; 
//		   pval = pval.replace("/",'')*1;
//		   var calDate = date.print("%Y%m%d")*1;
//		   return !(date.getFullYear() == order_year && calDate < pval);
//		}else{
//		   var pval = $("beginDate").value;
//		   pval = pval.replace("/",'')*1;
//		   var calDate = date.print("%Y%m%d")*1;
//		   return !(date.getFullYear() == order_year && calDate > pval);
//		}
//
////		 return (date.getFullYear() != order_year);
//	}

//	Calendar.setup({
//		inputField  : "beginDate",	  // id of the input field
//		//ifFormat	: "%Y%m%d",	  // the date format
//		range:[order_year],
//		firstDay:1,
//		singleClick	  : true,
//		button	  : "beginDate",// id of the button
//		dateDisabledFunc : function(date) {
////                      dateDisabledFunc(date,1);
//		}
//	});
//	
//	Calendar.setup({
//		inputField  : "overDate",	  // id of the input field
//		range:[order_year],
//		firstDay:1,
//		//ifFormat	: "%Y%m%d",	  // the date format
//		singleClick	  : true,
//		button	  : "overDate",	// id of the button
//		dateDisabledFunc : function(date) {
////                     dateDisabledFunc(date,2);
//		}
//	});
	
	


		  



}



 
function setCheckStateSelected(){
	 	var id  = $("orderStates").value;
	 	if(id =="0,1,2,4") id = 5;
//	 	if(id > 0){
	 		$(checkState.selectName).value = id;
//	 	}
}

function setUserSelected(){
	 	var id  = $("userId").value;
	 	if(id > 0){
	 		$(user.selectName).value = id;
	 	}
}

function setUserSelected2(){
	 
	
	   $("createById").options[0].text ="==签订人=="
	 	var id  = $("createBy").value;
	 	if(id > 0){
	 		$("createById").value = id;
	 	}
}

function setCategoryIdSelected(){
	 	var categoryId  = $("categoryId").value;

	 	if(categoryId!=0){
	 		$(orderCategory.selectName).value = categoryId;
	 	}
}

function setCarrierSelected(){
	 	var carrierId  = $("carrierId").value;
//alert(carrierId);
	 	if(carrierId!=0){
	 		$(carrier.selectName).value = carrierId;
	 	}
}

function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "customerId";
	 obj.treebox	= obj.className + "Treebox";
//	 obj.tree 		= new Tree(obj.treebox); 
} 
 


function resetMatterNameText(ev){
	 $("matterId").value=null;
	 $("matter.name").value = null;
}


function add_new_OrderDetail_more(){
//	var orderCategoryMain = getSelectParamFromAttribute($("categoryId"),"calculateauto");//根据付款分配应收
	var orgCount = _app_params.rights.userOrgs.length;
	var orgId =  config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;
	var resource_sort = $("carType").value;

	function func(oid){
		
		if(oid) orgId = oid;
		
		var paramObj={
				orgId: orgId,  
				resource_sort:resource_sort,
				orderId:0,
				year:$("order_year").value,
				fromModel:2
		}      
	    build_more_paraArray =  get_fast_sign_order_win(ctxPath,paramObj);
	    build_more_paraArray.show();
	}
	

	 checkOrg(func);

}

function checkOrg(func){
	var orgCount = _app_params.rights.userOrgs.length;
	var orgId =  config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;
	if(orgCount > 1 && config_oneOrgMoreSuborgsParam != '1' && orgId =='1'){
		showOrg_prompt_whith_comboBox(func);
	}else{
		func();
	}
}


function buttonEventFill(){

	if(!tag_orderList_new || !tag_orderDetail_save) $("Btn_addNewOrder").hide();
	if(!tag_order_submitbtn) $("btn_no_submitOrder").hide();
	if(!order_check_right) $("btn_no_checkedOrder").hide();
	if(!tag_order_paymentbtn){$("search_order_rate_table").hide();}
	if(!tag_bro_prove){$("Btn_printProve").hide();}
	
	if(config_fastSignOrderParam == 1){
		$("add_new_OrderDetail_more").show();
	}else{
		$("add_new_OrderDetail_more").hide();
	}
	

 	
	if(withoutSubmit == 1){
		 $("btn_no_passOrder").hide(); 
		 $("btn_no_submitOrder").hide(); 
	}
	


//	if(order_check_right){
//		$("isCheckedOrderPass").show()
//	}else{
//		$("isCheckedOrderPass").hide()
//	}

//	var isCheckedOrderPass = $("isCheckedOrderPass");
//	
//	 if(withoutSubmit == 1 && !isUndefined(isCheckedOrderPass)){
//	 	$("isCheckedOrderPass").hide();
//	 }
//	var orderAllSelect = $("orderAllSelect");
//	if(!isUndefined(orderAllSelect)){
//		orderAllSelect.onclick = allSelectCheckBox;	
//		orderAllSelect.setAttribute("parnetObjName",order.tableName);	
//	 }

//	var Btn_myOrder = $("Btn_myOrder");
//	if(!isUndefined(Btn_myOrder)){
//		Btn_myOrder.setAttribute("href","javascript:void 0");
//		Btn_myOrder.onclick = selectMyOrder;
//	 }	
	 
	var Btn_AllOrder = $("Btn_AllOrder");
	if(!isUndefined(Btn_AllOrder)){
//		Btn_AllOrder.setAttribute("href","javascript:void 0");
		Btn_AllOrder.onclick = refrshOrderList;
	 }	

//	var isCheckedOrder = $("isCheckedOrder");
//	if(!isUndefined(isCheckedOrder)){
////		isCheckedOrder.setAttribute("href","javascript:void 0");
//		isCheckedOrder.onclick = updateOrderStates;
//	 }	
	 

//	if(!isUndefined(isCheckedOrderPass)){
////		isCheckedOrderPass.setAttribute("href","javascript:void 0");
//		isCheckedOrderPass.onclick = updateOrderStates;
//	 }	
	 	
	 var btn_no_passOrder = $("btn_no_passOrder");
	 btn_no_passOrder.onclick = updateOrderStates;
	  
	 var btn_no_submitOrder = $("btn_no_submitOrder");
	 btn_no_submitOrder.onclick = updateOrderStates;
	 
	 var btn_no_checkedOrder = $("btn_no_checkedOrder");
	 btn_no_checkedOrder.onclick = updateOrderStates;
	 	 
	    
//	var submitChecked = $("submitChecked");
//	if(!isUndefined(submitChecked)){
//		submitChecked.setAttribute("href","javascript:void 0");
//		submitChecked.onclick = updateOrderStates;
//	 }	
	
//	var Btn_customerName = $("customer_name");
//	if(!isUndefined(Btn_customerName)){
////		Btn_customerName.onkeypress= getCustomerAutoCompltByName;
//		Btn_customerName.onclick = resetText;
//	 }	
	 
//	 Btn_customerName.onblur = function (){
//	 	alert($("customer_name").value);
//	 	$("customerName").value = $("customer_name").value;
//	 }



	var Btn_matter = $("matter.name");
	if(!isUndefined(Btn_matter)){
		Btn_matter.onclick = resetMatterText;
	}	
	
	
	var Btn_orderName = $("order_code");
	if(!isUndefined(Btn_orderName)){
		Btn_orderName.onclick = resetOrderText;
	}	
	
	var Btn_contractName = $("contract_code");
	if(!isUndefined(Btn_contractName)){
		Btn_contractName.onclick = resetContractText;
	}
	var Btn_relationCode = $("relation_code");
	if(!isUndefined(Btn_orderName)){
		Btn_relationCode.onclick = resetRelationCodeText;
	}
	var Btn_orderMeno = $("orderMeno");
	if(!isUndefined(Btn_orderMeno)){
		Btn_orderMeno.onclick = resetOrderMenoText;
	}	
	
	

	
	
	
	var Btn_query = $("query");
	Btn_query.onclick = loadGridData;
	
	var Btn_view_order = $("Btn_view_order");
	if(!isUndefined(Btn_view_order)){
		Btn_view_order.onclick = button_view_order;
	}
	var Btn_print_order = $("Btn_print_order");
	if(!isUndefined(Btn_print_order)){
		Btn_print_order.onclick = button_print_order;	
	}
	
	var Btn_export_order = $("Btn_export_order");
	if(!isUndefined(Btn_export_order)){
		Btn_export_order.onclick = button_print_export;	
	}
//	var Btn_matterName = $("matter.name");
//	Btn_matterName.onclick = resetMatterNameText;
//	Btn_matterName.onkeypress = getMatterAutoCompltByName;
	
	var Btn_searche = $("btn_searche");
	Btn_searche.onclick = displaySearchDiv;
	
	var Btn_reset_query = $("btn_reset_query");
	Btn_reset_query.onclick =resetQueryWhere;

	
	
	var Btn_searche_close = $("btn_searche_close");
	Btn_searche_close.onclick = closeSearchDiv;
	
		//新添定单按钮
	var Btn_addNewOrder = $("Btn_addNewOrder");
	if(Btn_addNewOrder!=null){
		Btn_addNewOrder.setAttribute("href","javascript:void 0");
		Btn_addNewOrder.onclick = addNewOrder;
	}
	
	if(tvNameParam =='fztv'){
		var Btn_selectOrder = $("selectOrder");
		Btn_selectOrder.onchange = loadGridData;
	} 
	
	
	var change_order_year = $("order_year");
	change_order_year.onchange = rest_query_order;
	
	
	var Btn_carrierType = $("carType");
	if(!isUndefined(Btn_carrierType)){
		Btn_carrierType.onchange = loadGridData;	
	}	
	
	var Btn_customerCategorys = $("customerCategorys");
	if(!isUndefined(Btn_customerCategorys)){
		Btn_customerCategorys.onchange = loadGridData;	
	}		
	
//	if(useMoreCarrierSortParam =='1'){
		var carrierName2 = $("carrierName");
		carrierName2.onclick = displayCarrierTree2; 	
//	}

	var Btn_order_code = $("order_code");
	if(!isUndefined(Btn_order_code)){
		Btn_order_code.onkeypress = function a(event){DWRUtil.onReturn(event,loadGridData);	}
	}	

	var Btn_contract_code = $("contract_code");
	if(!isUndefined(Btn_contract_code)){
		Btn_contract_code.onkeypress = function a(event){DWRUtil.onReturn(event,loadGridData);	}
	}	
	
	var Btn_relation_code = $("relation_code");
	if(!isUndefined(Btn_relation_code)){
		Btn_relation_code.onkeypress = function a(event){DWRUtil.onReturn(event,loadGridData);	}
	}		
		
	var Btn_matter_name = $("matter.name");
	if(!isUndefined(Btn_matter_name)){
		Btn_matter_name.onkeypress = function a(event){DWRUtil.onReturn(event,loadGridData);	}
	}	
	

	var Btn_printProve = $("Btn_printProve");
	Btn_printProve.onclick = button_chose_prove;
	
	var Btn_addNewAdver2 = $("add_new_OrderDetail_more");
	Btn_addNewAdver2.onclick = add_new_OrderDetail_more;	
	
	
	
	
	
//		if(tvNameParam =='hbtv'){
//			var Btn_printProve = $("Btn_printProve");
//			Btn_printProve.onclick = button_chose_prove;
//			Btn_printProve.show();
//		}else{
//			$("Btn_printProve").hide();
//		}
	
	
//	var Btn_customer_name = $("customer_name");
//	if(!isUndefined(Btn_customer_name)){
//		Btn_customer_name.onkeypress = function a(event){DWRUtil.onReturn(event,loadGridData);	}
//	}	
	
	$("orderMeno").onkeypress = function a(event){DWRUtil.onReturn(event,loadGridData);	}
	$("orderRelPay").onkeypress = function a(event){DWRUtil.onReturn(event,loadGridData);	}
	$("orderRate1").onkeypress = function a(event){DWRUtil.onReturn(event,loadGridData);	}
	
	
	
	
	var menu_print = { text:"打印", iconCls:'admin-tool-print', handler:function(){button_print_order();}} ;
	var menu_view = { text:"预览", iconCls:'admin-tool-view', handler:function(){button_view_order();}} ;
	var menu_export_xls = { text:"导出", iconCls:'admin-tool-export-xls', handler:function(){button_print_export();}} ;
	
//    this.report.buildButtonPanel(this,"printReportDiv",2,[0,1],80); 
    
	
	//判断是否有审核权限
	var	items =[
	        {  
	            text:"新签",  
	            iconCls:'admin-tool-add',
	            handler:function(){addNewOrder();}  
	        }
		];
		
		

		
//	if(order_check_right){
//		   items[items.length] ={  
//	            text:"审核",  
//	            iconCls:'admin-tool-query',
//	            handler:function(){
//	            	var btnValue1 = "待审核";
//	            	$("btn_no_checkedOrder").value = btnValue1;
////	            	DWRUtil.setValue("isCheckedOrder",btnValue1);
//	            	updateOrderStates('checkOrder');
//	            	}   
//	        }
//	        
//	       
//	};		

	
	items[items.length] ={  
	            text:"刷新",  
	            iconCls:'admin-tool-refresh',
	            handler:function(){refrshOrderList();}  
	};	
	
	
 
			

   
   	items[items.length] = "-";
   	

	items[items.length] ={  
	            text:"预览",  
	            iconCls:'admin-tool-view',
	            handler:function(){button_view_order();}  
	};	   	
   	
	items[items.length] ={  
	            text:"打印",  
	            iconCls:'admin-tool-print',
	            handler:function(){button_print_order();}  
	};	
	
	items[items.length] ={  
	            text:"导出",  
	            iconCls:'admin-tool-export-xls',
	            handler:function(){button_print_export();}  
	};		   	
   	
	items[items.length] = "-";	
		
    if(withoutSubmit == 0){
    	
    	  if(order_check_right){	
		     items[items.length] = {  
			            text:"通过",  
			            iconCls:'admin-tool-check',
			            handler:function(){updateOrderStates(this,3);}  
			      };    
    	  }
    	  
    	  if(tag_order_submitbtn){	
    	  	items[items.length] ={  
		            text:"提交",  
		            iconCls:'admin-tool-check',
		            handler:function(){
		            	updateOrderStates(this,1);
		            	}  
		    }
    	  }
    	  
    	  


	}else{
		 if(order_check_right){	
		     items[items.length] = {  
			            text:"通过",  
			            iconCls:'admin-tool-check',
			            handler:function(){updateOrderStates(this,3);}  
			      };  
		 }
	}
		
	
	
   if(order_check_right){
   	
		 if(withoutSubmit == 0){
	        items[items.length] = {  
		            text:"退回",  
		            iconCls:'admin-tool-return',
		            handler:function(){updateOrderStates(this,4);}  
		        };	
		 }else{
	        items[items.length] = {  
		            text:"退回",  
		            iconCls:'admin-tool-return',
		            handler:function(){updateOrderStates(this,0);}  
		        };	
		 }		    
   };
   
		
	var menu = new Ext.menu.Menu({  
	        minWidth:200,  
	        width:150,
	        items:items 
	});  
	
	         //作用于页面上的鼠标右键  
	Ext.getDoc().on("contextmenu",function(e){  
	    	e.stopEvent();//终止之前的事件响应，不然还会在页面上弹出讨厌的ie右键菜单  
	    	menu.showAt(e.getXY()); 
	});  

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
		button_print_copy();
	}
	   
}

function displayCarrierTree2(){
  var ids = $("carrierName").value;
  var loginUser =  $("config_username").value;
  var orgId = config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value; 
  var urlStr="selectPopup/selectUserCarrierRel.html?mode=2&loginUser="+loginUser+"&ids="+ids +"&useCarrierAliname="+useCarrierAliname +"&orgId="+ orgId;
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
	
function rest_query_order(){
	
	 var year = $("order_year").value;
	 
	 getDate(year);
	
//	 var beginDate= $("beginDate").value;
//	 var overDate= $("overDate").value;
	 
	 var beginDate = Ext.getCmp('beginDate').getValue().format("Y-m-d");			
 	 var overDate = Ext.getCmp('overDate').getValue().format("Y-m-d");	
	 
	 
	 beginDate = year  + beginDate.substring(4,beginDate.length);
	 overDate = year  + overDate.substring(4,overDate.length);
	 
	
//	 $("beginDate").value = beginDate;
//	 $("overDate").value = overDate;

	 Ext.getCmp('beginDate').setValue(myDate.parseDate(beginDate));
	 Ext.getCmp('overDate').setValue(myDate.parseDate(overDate));
	  
	  
	 
 	 resetUserStore();
 		 
 	


	 loadGridData();
	
//	 $("order_year").value = year;

//     alert($("version").value);
//	 $("version").value = year;
	 

}


function addNewOrder(){ 
	var orgId =  config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;
	function func(oid){
		if(oid) orgId = oid;
		var paramObj = getLoadDataParams(null,true);
		paramObj.orgId = orgId;
		var url = ctxPath +  "editOrder.html?"+$H(paramObj).toQueryString();
		parent.location.href = url;	
	}
	
	checkOrg(func);

}
  

function displaySearchDiv(){
	var oDiv = $("theDivSearch");	
	if(oDiv.style.visibility == "hidden"){
		oDiv.style.visibility = "visible";
	}else{
		oDiv.style.visibility = "hidden";
	}
	
//	resetQueryWhere();
	
}





function closeSearchDiv(){
	var oDiv = $("theDivSearch");
	oDiv.style.visibility = "hidden";	
}


function button_view_order(){
//	 $("model").value = "view";
//	 $("reportType").value = "orderList";
	 button_print("view");
}	
function button_print_order(){
//	 $("model").value = "print";
//	 $("reportType").value = "orderList";
	 button_print("print");
}
function button_print_export(){
//	 $("model").value = "export";
//	 $("reportType").value = "orderList";
	 button_print("export");
}

function button_print_copy(){
	
	var checkeds = [];
	if(mygrid.getSelectedId() != null){
		checkeds =mygrid.getSelectedId().split(mygrid.delim);  
	}
	if(checkeds.length ==0){
		extjMessage('请选择要复制的订单!');return false;
//		alert("请选择要复制的订单");return false;
	}else{
		if(checkeds.length ==1) mygrid.setSelectedRow(checkeds[0]);
	}	
	
	
	
	Ext.MessageBox.confirm('系统提示', '请确认是否复制？', function(btn) {
		      
 			  if (btn == 'yes') {
				if(checkeds.length ==1){
					order.saveOrderClone(checkeds[0],loginUserId,refrshOrderList);
				} 			  	
              }	    	
	});		
	
}

	

function button_print(model){

	 
	 var heads = mygrid.flds.replace(/\*/g,",");

	 var displayRelcode = (config_orderDisplayRelcodeParam ==1);
	 var displayIncomeParam = (config_orderDisplayIncomeParam ==1);
	 
	 var paramObj = getLoadDataParams();
	 var printParam ={};
	 if(displayRelcode){
		  if(displayIncomeParam){
		  			  printParam = {
						model:  model,
					 	title:'订单信息',
		                reportType: "orderList",
		                reportFile:'',
		                headers:heads, 
		                displaySumColum:"0,0,0,0,0,0,0,0,1,1,0,0",
		                colAlign:"center,center,center,left,left,left,center,center,right,right,center,center",
		                colTypes:"ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed",
		                widthsP:"9,10,8,14,13,5,8,8,7,7,6,5",
		                isSum:true,
		                isVertical:false
		 				}; 
		  }else{
		  			  printParam = {
						model:  model,
					 	title:'订单信息',
		                reportType: "orderList",
		                reportFile:'',
		                headers:heads,
		                displaySumColum:"0,0,0,0,0,0,0,0,1,0,0",
		                colAlign:"center,center,center,left,left,left,center,center,right,center,center",
		                colTypes:"ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed",
		                widthsP:"9,10,8,18,16,5,8,8,7,6,5",
		                isSum:true,
		                isVertical:false
		 				}; 
		  }
	 }else{
	 	  if(displayIncomeParam){
			  printParam = {
							model:  model,
						 	title:'订单信息',
			                reportType: "orderList",
			                reportFile:'',
			                headers:heads,
			                displaySumColum:"0,0,0,0,0,0,0,1,1,0,0",
			                colAlign:"center,center,left,left,left,center,center,right,right,center,center",
			                colTypes:"ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed",
			                widthsP:"9,9,19,13,5,8,8,9,9,6,5",
			                isSum:true,
			                isVertical:false
			 }; 		 	  	
	 	  }else{
	 	  		printParam = {
						model:  model,
					 	title:'订单信息',
		                reportType: "orderList",
		                reportFile:'',
		                headers:heads,
		                displaySumColum:"0,0,0,0,0,0,0,1,0,0",
		                colAlign:"center,center,left,left,left,center,center,right,center,center",
		                colTypes:"ed,ed,ed,ed,ed,ed,ed,ed,ed,ed",
		                widthsP:"9,9,24,17,5,8,8,9,6,5",
		                isSum:true,
		                isVertical:false
				 }; 	
	 	  }

	 }

	 

	 
    var a = Object.extend(paramObj,printParam);
 	 
//	  var h = $H(c);	
//	  alert(h.toQueryString());
        

	 report.loadApplet(a,ctxPath,800,500);	
	        
	
}








function setOrderPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className = "order";	
	 obj.IdPrefix 	= obj.className + "Id";
	 
	 obj.fillObjName = obj.className + "Body";
	 obj.tableName =  "orderList";
	 obj.tBody 		= $(obj.fillObjName);
//	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
//	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
//	 
//	 obj.pageInfo 	= "pageInfo" + obj.className;
//	 obj.pageSize 	= "4";
//	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}
function setCheckStatePara(obj){
	 obj.className ="OaWorkFlowCheckState";
	 obj.selectName = obj.className +"RN";
}

function setUserPara(obj){
	 obj.className ="user";
	 obj.selectName =  "userOwner"; 
}


function resetQueryWhere(){
	 order_year = $("order_year").value;
	 
//	 $("beginDate").value = getFormatDay(order_year+'0101','y/m/d');
//	 $("overDate").value= getFormatDay(order_year+'1231','y/m/d');
	 
		Ext.getCmp('beginDate').setValue(myDate.parseDate(getFormatDay($("order_year").value+'0101','y-m-d')));
		Ext.getCmp('overDate').setValue(myDate.parseDate(getFormatDay($("order_year").value+'1231','y-m-d'))); 
	 
	
	 $(carrier.selectName).value = "";
//     $("customer_name").value;
	 $("order_code").value = "";
     $("contract_code").value = "";
     $("relation_code").value = "";
	 $("matter.name").value = "";
//	 $(user.selectName).value = 0;
//	 ("createById").value = 0;
	 $("isArrears").value = 0;
	 $(checkState.selectName).value = "";
	 $("orderRelPay").value = "";
	 $("orderMeno").value = "";
	 $("orderRate1").value = "";
	 $("orderRate2").value = "";	 

	  Ext.getCmp('customer_name').setValue('');
	  Ext.getCmp('userOwner').setValue('');
	  Ext.getCmp('createById').setValue('');
      Ext.getCmp('orderCategoryId').setValue('');
      
  
	 
	 changeCkeckBtnValue(1);
	 
	 $("allSelect").checked = false;	
	 $("isDayRealPlay").checked = false;	
	 
}

function refrshOrderList(){
	
//	var isCheckedOrder = $("isCheckedOrder");
//	
//	if(tag_order_submitbtn||order_check_right) $("isCheckedOrder").show();

	
     resetQueryWhere();
	 
	 loadGridData();
}

//function changeCkeckBtnValue(v){
//	
//	var isCheckedOrder = $("isCheckedOrder");
////	
////	if(!tag_order_submitbtn) isCheckedOrder.hide();
//	
//	if(isUndefined(isCheckedOrder)) return false;
//	
//	var btnValue1 = "审核";
//	var btnValue2 = "提交";
//
//	var btnValue =  DWRUtil.getValue("isCheckedOrder");
//	
//
//
//	if(v){
//		if(btnValue.indexOf('提交') >-1 ){
//			DWRUtil.setValue("isCheckedOrder",btnValue1);
//		}
//	}else{
//		if(btnValue.indexOf('审核') >-1 ){
//			DWRUtil.setValue("isCheckedOrder",btnValue2);
//		
//		}else{
//			DWRUtil.setValue("isCheckedOrder",btnValue1);
//		}		
//	}
//	
//}



function changeCkeckBtnValue(v){
	
	var btn_no_submitOrder = $("btn_no_submitOrder");
	var btn_no_checkedOrder = $("btn_no_checkedOrder");

	var btnValue1 = "提交";
	var btnValue2 = "通过";

	var btnValue11 = "待提交";
	var btnValue22 = "待审核";
	
	
	
  
	if(v){
		btn_no_submitOrder.value = btnValue11;
		btn_no_checkedOrder.value = btnValue22;	
	}else{
		btn_no_submitOrder.value = btnValue1;
		btn_no_checkedOrder.value = btnValue2;	
	}
	
}

function updateOrderStates(el,check_State){
//	var checkeds = getCheckBoxValues(order.tableName,1);
//     var btnValue;
//      var btnValue2;
     
//     btnValue1 =  DWRUtil.getValue("isCheckedOrder");
//     
//    var isCheckedOrderPass = $("isCheckedOrderPass");
//	if(isUndefined(isCheckedOrderPass)){
//		btnValue2 ="通过";
//	}else{
//		btnValue2 =  DWRUtil.getValue("isCheckedOrderPass");
//	}
	
	var displayRelcode = (config_orderDisplayRelcodeParam ==1);
	
	  var defMsg ="【订单浏览上提交审核】";

	var changeState = 1;

	var opt="check";
//	if(btnValue1.indexOf('提交') >-1 ) opt ="submit";
//	if(btnValue2.indexOf('通过') >-1 ) opt ="pass";
	$("allSelect").checked = false;
	

	if(el.type == 'click' || el =='checkOrder' ){
		
      	var checkeds = mygrid.getCheckedRows(0);  
      	
      
      	
      	if(mygrid.getCheckedRows(0) == ""){
      		 checkeds =[];
      	}else{
      		checkeds = mygrid.getCheckedRows(0).split(",");  
      				}
      		
		
			if(el !='checkOrder'){
	
				 var ell = getElementByEvent(el);
				 
				
				 var btnValue = ell.value;
				 if(btnValue =='提交') opt ="submit";
				 if(btnValue =='通过') opt ="pass";
	
			}
		

		
//    			alert(33)  
//	alert(el.type)  
//	alert(checkeds)  	
		
		if(checkeds.length ==0 ){
			
				if(opt =="submit"){
					  alert("您没有选择需要提交的订单!");
					  return false;
				}

			 var ell = getElementByEvent(el);
			 var btnValue = ell.value;
			 var stateValue = -1;

			 if(btnValue =='未通过' ){
			 	 stateValue = 5;
			 	 $("btn_no_checkedOrder").value='待审核';
			 	 $("btn_no_submitOrder").value='待提交';
			 }	
			
			 if( btnValue =='待提交' ){
			 	 stateValue = 6;ell.value='提交';
			 	 $("btn_no_checkedOrder").value='待审核';
			 }			 
			 
			 if( btnValue =='待审核' ){
			 	 stateValue = withoutSubmit == 0?1:0;ell.value='通过';
			 	 $("btn_no_submitOrder").value='待提交';
			 }
			 
		
			  if(stateValue >-1 ){
			  	$(checkState.selectName).value = stateValue;
			  }
			
			
			
		}else{
			
		
		    if(withoutSubmit == 1){
		    	 changeState = 3;
		    	 order.updateOrderStates2(checkeds,changeState,loginUserId,0,defMsg);
		    }else{
		    	       	if(opt =="submit") changeState = 1;
		    	       	if(opt =="pass") changeState = 3;
		    	       		
		    	        var checkeds22 = [];//被退回
		    	         var checkeds23 = []; //""
		    	          var checkeds24 = []; //未审批
		    	          
//		    	          var colNum = displayRelcode?12:11;
		    	          
		    	           var colIndex = mygrid.getColIndexById('opter3');
		    	           
		    	        
		    	          
		    			for(var i=0;i<checkeds.length;i++){
		    				
						 	var v = mygrid.cells(checkeds[i],colIndex).getValue();
						 	if(opt =="submit"){
							 	if(v.indexOf("被退回")> -1){
							 		checkeds22.push(checkeds[i]);
							 	}
							 	if(v ==""){
							 		checkeds23.push(checkeds[i]);
							 	}
						 	}else{
							 	if(v.indexOf("未审批")> -1){
							 		checkeds24.push(checkeds[i]);
							 	}
						 	}

		    			}
		    			
		    	if(checkeds22.length >0) order.updateOrderStates2(checkeds22,changeState,loginUserId,4,defMsg);
		    	if(checkeds23.length >0) order.updateOrderStates2(checkeds23,changeState,loginUserId,0,defMsg);
		    	if(checkeds24.length >0) order.updateOrderStates2(checkeds24,changeState,loginUserId,1,defMsg);
		    	
		    }
			
		}
		
        loadGridData();
        
    }else{
    	

 		    	var checkeds = [];
 		    	var pass = []; 
 		    	var pass1 = []; //""
 		    	var pass2 = []; //"未审批"
 		    	var pass3 = []; //"审核中"
 		    	var pass4 = []; //"通过"
 		    	var pass5 = []; //"被退回"
 		    	

		      	if( mygrid.getSelectedId() != null){
		      		checkeds =mygrid.getSelectedId().split(mygrid.delim);  
		      	}		    	
		      	
		      	
		 
		      	
		    	
		    	if(checkeds.length > 0){

		    		    var colIndex = mygrid.getColIndexById('opter3');
		  
		 				for(var i=0;i<checkeds.length;i++){
						 	var v = mygrid.cells(checkeds[i],colIndex).getValue();

						 		    if(v =="") pass1.push(checkeds[i]);
						 		    
									if(v.indexOf("未审批")> -1) pass2.push(checkeds[i]);
									
									if(v.indexOf("审核中")> -1) pass3.push(checkeds[i]);
									
									if(v.indexOf("通过")> -1 ) pass4.push(checkeds[i]);
									
								 	if(v.indexOf("被退回")> -1) pass5.push(checkeds[i]);

						}   
						


				        
				        
				        if(withoutSubmit == 0){
				        	
							if(check_State == 1){
								if(pass1.length > 0)  pass = pass.concat(pass1);
						        if(pass5.length > 0)  pass = pass.concat(pass5);
						        if(pass.length == 0){
									alert("未能找到退回的订单!");
									return false;
						        }
						        if(pass1.length > 0)   order.updateOrderStates2(pass1,check_State,loginUserId,0,defMsg,loadGridData());
						        if(pass5.length > 0)   order.updateOrderStates2(pass5,check_State,loginUserId,4,defMsg,loadGridData());
						        
							}
							
							if(check_State == 3){
								if(pass2.length > 0)  pass = pass.concat(pass2);
						        if(pass3.length > 0)  pass = pass.concat(pass3);

						        if(pass.length == 0){
						        	if(pass1.length > 0 || pass5.length > 0){
						        		alert("请先提交，才能进行通过审核!");
						        	}else{
						        		alert("未能找到符合条件的订单!");
						        	}
									return false;
						        }
						        if(pass2.length > 0)   order.updateOrderStates2(pass2,check_State,loginUserId,1,defMsg,loadGridData());
						        if(pass3.length > 0)   order.updateOrderStates2(pass3,check_State,loginUserId,2,defMsg,loadGridData()); 
						        
							}
							
							if(check_State == 4){
								
							
								if(pass2.length > 0)  pass = pass.concat(pass2);
						        if(pass3.length > 0)  pass = pass.concat(pass3);
						        if(pass4.length > 0)  pass = pass.concat(pass4);
						        
					
						        
						        if(pass.length == 0){
									alert("未能找到退回的订单!");
									return false;
						        }
			
	       					    if(pass2.length > 0)   order.updateOrderStates2(pass2,check_State,loginUserId,1,defMsg,loadGridData());
						        if(pass3.length > 0)   order.updateOrderStates2(pass3,check_State,loginUserId,2,defMsg,loadGridData()); 
						        if(pass4.length > 0)   order.updateOrderStates2(pass4,check_State,loginUserId,3,defMsg,loadGridData()); 
							}
							
				        }else{
				        	
							if(check_State == 0){
						        if(pass4.length == 0){
									alert("未能找到退回的订单!");
									return false;
						        }
	       					    if(pass4.length > 0)   order.updateOrderStates2(pass4,check_State,loginUserId,3,defMsg,loadGridData());
 
							}
							
							if(check_State == 3){
						        if(pass1.length == 0){
									alert("未能找到可以通过的订单!");
									return false;
						        }
						        if(pass1.length > 0)   order.updateOrderStates2(pass1,check_State,loginUserId,0,defMsg,loadGridData());
							}

				        }	
								
		    	}      	

    	
// 		    	if(pass.length > 0){
//                       
////		    		    order.updateOrderStates2(pass,check_State,loadGridData());
//		    		    
// 		    	        if(pass1.length > 0)   order.updateOrderStates2(pass1,check_State,loginUserId,0,defMsgloadGridData());
//				        if(pass2.length > 0)   order.updateOrderStates2(pass2,check_State,loginUserId,1,defMsgloadGridData());
//				        if(pass3.length > 0)   order.updateOrderStates2(pass3,check_State,loginUserId,2,defMsgloadGridData());
//				        if(pass4.length > 0)   order.updateOrderStates2(pass4,check_State,loginUserId,4,defMsgloadGridData());
//				        if(pass5.length > 0)   order.updateOrderStates2(pass5,check_State,loginUserId,4,defMsgloadGridData());
//		    		    
//		    	}   	
    	


    }

}

function submitOrderForm(){
//	var tarForm =  $("tarForm");
	var orderFormSearch = $("orderFormSearch");
//	orderFormSearch.target = tarForm;
	orderFormSearch.submit(); 
	//	alert("提交成功!");
}

function searchyear(beginDate,endDate){
	var beginYear = getFormatDay(beginDate,'y');
	var endYear = getFormatDay(endDate,'y');
	var ispass = true;
	
 	if(beginDate == "" || endDate == ""){
		alert("请选择日期");
		ispass =  false;
		return ispass;
	}
	
	if(beginDate > endDate){
		alert("开始日期不能大于结束日期");
		ispass =  false;
		return ispass;
	}	
	
//	if(resource_year!=beginYear || resource_year!=endYear){
//		alert("选定年份应该等于实际年份");
//		ispass =  false;
//	}

	return ispass;
}



function resetText(ev){
//	 $("customer_name").value = null;
	  Ext.getCmp('customer_name').setValue('');
}
function resetOrderText(ev){
	 $("order_code").value = null;
}
function resetContractText(ev){
	 $("contract_code").value = null;
}
function resetRelationCodeText(ev){
	 $("relation_code").value = null;
}

function resetMatterText(ev){
	 $("matter.name").value = null;
}
function resetOrderMenoText(ev){
	 $("orderMeno").value = null;
}
function resetOrderRelPayText(ev){
	 $("orderRelPay").value = null;
}



function button_chose_prove(){
	
	var orderId = mygrid.getSelectedId();

	
	if(!orderId) {
		alert('请选择订单!');
		return false;
	}
	
	
	  var colIndex1 = mygrid.getColIndexById('start');
		var ddd1 = myDate.parseDate(mygrid.cells(orderId,colIndex1).getValue());
		var def_Dat =   myDate.parseDate(getFormatDay(_app_params.serviceDate.format2,"y-m-d"));
	
		
//		var ddd1= myDate.parseDate(myDate.getStartDay3(def_Dat,"yyyy-MM-01"));
//		var ddd2= myDate.parseDate(myDate.getEndDay3(def_Dat,"yyyy-MM-dd"));
		var ddd2 = def_Dat;
		

			 
	if(!proveWin){

		var checkNoInputBtn = {
			text:'检查',
//			width:50,
			handler:function(){
			
							var publishDateStart = Ext.getCmp('start_date_query').getValue().format("Ymd");
							var publishDateEnd = Ext.getCmp('end_date_query').getValue().format("Ymd");
							var orgId = $("orgId").value;
							var carrierId =  Ext.getCmp('carrier_cmd').getValue() == ""?null: Ext.getCmp('carrier_cmd').getValue();
							
							
							if(!checkAdvWin){ 
										var check_closeBtn ={text: '关闭',handler: function(){checkAdvWin.hide();}};
										checkAdvWin=new Ext.Window({
				 												 closeAction:'hide',
									           contentEl:"gridbox4",//主体显示的html元素，也可以写为el:"win"
									           width:800,
									           height:500,
									           modal : true,
									           title:"检查未输时间的广告" ,
									           buttons: [check_closeBtn],
									        });
							}

							var param ={
									orgId:orgId,
				//					resourceIds:'',
									carrierId:carrierId,
				        publishDateStart:publishDateStart,
				        publishDateEnd:publishDateEnd,
				        opt:2
				         	}
				
				 			var queryString =  $H(param).toQueryString();	
							var func  = function(xml){
						 function fn(){Ext.getBody().unmask();}
						   checkAdvWin.show();		
								mygrid4.clearAll();
								mygrid4.loadXMLString(xml,fn);
				      mygrid4.setSizes();	
							}
							
							Ext.getBody().mask('数据加载中……', 'x-mask-loading');
							PublishArrangeManager.getArrangedAdversByResourceId(queryString,func);	
		} 
	};		

		  var previewBtn ={text: '预览',handler: function(){button_print2('view');}};
		  var execlBtn ={text: '导出',handler: function(){button_print2('excel');}};
		  var printBtn ={text: '打印',handler: function(){button_print2('print');}};
		  var closeBtn ={text: '关闭',handler: function(){proveWin.hide();mygrid3.deleteSelectedItem();}}; 
		  var refreshBtn ={text: '刷新',handler: function(){loadData();},xtype:'button',cls:'refresh',width:50};
		  var customerCheckbox = {boxLabel:'显示客户', id: 'cb-col-1', name: 'cb-col-1',xtype:'checkbox',checked: true,inputValue :1};
		  var moneyCheckbox ={boxLabel: '显示金额',  id:'cb-col-2',name: 'cb-col-2',xtype:'checkbox',inputValue :2};
		  var noBroCheckbox ={boxLabel: '不显未播',  id:'cb-col-3',name: 'cb-col-3',xtype:'checkbox',inputValue :3};
		  
		  
		  
	
		  

//				var refreshBtn= new Ext.Button({
//						text:"刷新",
//				   iconCls : 'save',
//				   width:100,
//						listeners:{
//						"click":function(){alert("Hello");}
//						}
//				});


		 	var startDateFileld =  new Ext.form.DateField({
		        fieldLabel : '开始日期',
		        id : 'start_date_query',
		        name : 'start_date_query',
		        enableKeyEvents : true,
		        width : 80,
		        allowBlank : false,    
		        format : 'Y-m-d',
//		        value: new Date()
//		        renderTo:'beginDateDiv',
//		       	value:myDate.parseDate(myDate.getStartDay3(def_Dat,"yyyy-MM-01"))
		       });  
////		       
////
////	  
	  	var endDateFileld =  new Ext.form.DateField({
		        fieldLabel : '结束日期',
		        id : 'end_date_query',
		        name : 'end_date_query',
		        enableKeyEvents : true,
		        width : 80,
		        allowBlank : false,    
		        format : 'Y-m-d',
//		        value: new Date()
//		        	value:new Date()
//		        renderTo:'overDateDiv',
//		       	value: myDate.getEndDay3(def_Dat,"yyyy-MM-dd")
		       });  

				carrier.obj.callback = function aa(){};
				carrier.obj.orgId =  config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;
				carrier.obj.enable =  true;
		  	var carrierCmd = carrier.getLovCombo3('carrier_cmd',130,'remote',false,'频道名称','请选择频道...' );  
		  	
		  proveWin = new Ext.Window({
		   title : '播出证明',
				width : 800,
				height : 500,
		   isTopContainer : true,
		   modal : true,
		   		closeAction:'hide',
		   resizable : false,
		    buttons: [previewBtn,execlBtn,printBtn,closeBtn],
			 tbar:['开始日期',startDateFileld,'结束日期',endDateFileld,carrierCmd,refreshBtn,customerCheckbox,moneyCheckbox,noBroCheckbox],
//			  tbar:[timeFiledSet1],
		   contentEl : "gridbox3"
		  });
		  

		  

		  
		   
	}
	

	
		Ext.getCmp('start_date_query').setValue(ddd1);
	Ext.getCmp('end_date_query').setValue(ddd2);

	loadData();
	
	proveWin.show();
	


	
//	 Ext.getCmp('start_date_query').setValue(new Date());
//	 Ext.getCmp('end_date_query').setValue(new Date());
//  Ext.getCmp('end_date_query').setValue(myDate.getEndDay3(def_Dat,"yyyy-MM-dd"));
   
  
}	


function loadData(){
	
	 
	 
	 var startDate = Ext.getCmp('start_date_query').getValue().format("Ymd"); 
	 var endDate = Ext.getCmp('end_date_query').getValue().format("Ymd"); 
	 if(endDate < startDate){
	 	alert("结束日期小于开始日期,请调整日期!");
	 	mygrid3.clearAll();
	 	return false;
	 }
	 
	 var carrierId =  Ext.getCmp('carrier_cmd').getValue() == ""?null: Ext.getCmp('carrier_cmd').getValue();
  var orderId = mygrid.getSelectedId();
	
		var paramObj = new OrderDetail();
	
	mygrid3.clearAll();
	Ext.getBody().mask('数据处理中……', 'x-mask-loading'); 	 
	  
	var fnc = function(xml){
		mygrid3.loadXMLString(xml,null);
		Ext.getBody().unmask(); 
	}	



	paramObj.obj.orderId = orderId;
	paramObj.obj.carrierId = carrierId;
//	paramObj.obj.orderIds = orderIds;
	paramObj.obj.parentId = 0;
	paramObj.obj.loginUser = userName; 
	paramObj.obj.orgId = config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;
	paramObj.obj.tableModel = 3;
	paramObj.obj.orderPublic = (new OrderPublic()).obj;
	paramObj.obj.orderPublic.publishStartDate = startDate;
	paramObj.obj.orderPublic.publishEndDate =  endDate; 
	
//	paramObj.obj.detailIds = detailIds;
 
	paramObj.getOrderDetailsForFztv(fnc);	
}


//function selectCheckBoxAll3(type){
//	var el = $("detailAllSelect");
//	var grid = mygrid3;
//	var col = el.value;
//	var rows = grid.getRowsNum();
//	for(var i=0; i< rows;i++){
//		var ch =  grid.cells2(i,0);
//		if(grid.getRowByIndex(i).style.display ==""){
//		     ch.setValue(el.checked);
//		}else{
//		     ch.setValue(0);
//		} 
//	}	
//}	



function initGrid3(){

//			function onRowSelectd3(id,cellInd){
//					var cell = mygrid3.cells(id,0);
//					var v = cell.getValue()==0?1:0;
//					cell.setValue(v);	
//			}
//			
//			function attachHeaderNew3(grid){
//				var htm ="<center><input type='checkBox' id='detailAllSelect' value='0' onclick= 'javascript:selectCheckBoxAll3(1)'></center>,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan";
//				var h = htm.split(",");
//				var z =  grid.hdr.rows[1];
//				
//				for(var cin = 0; cin<h.length;cin++){
//					if(h[cin].indexOf("#rspan") != 0) {
//						var c = z.cells[z._childIndexes?z._childIndexes[parseInt(cin)]:cin];
//						c.innerHTML = h[cin];		
//					}
//			
//				}
//				
//			}
			


			

	mygrid3 = new dhtmlXGridObject('gridbox3');
	mygrid3.selMultiRows = true;
	mygrid3.setImagePath(ctxPath+"image/grid/");
	var	flds = "序,位置,名称,版本,秒,指定,开始,结束,次";
	var	columnIds =  "seq,pos,name,edit,len,spec,start,end,times";  
	mygrid3.setHeader(flds);
	mygrid3.setColumnIds(columnIds);
	mygrid3.setInitWidthsP("9,21,11,21,5,9,9,9,6");
    mygrid3.setColSorting("int,int,str,str,str,str,int,str,str,int");
	mygrid3.setColAlign("center,left,left,left,center,center,center,center,center,center");
	mygrid3.setColTypes("ed,ed,ed,ed,ed,coro,ed,ed,ed,ed,ed");
//	mygrid3.getCombo(5).put(2,2);

	mygrid3.setEditable(false);
//	mygrid3.setOnRowSelectHandler(onRowSelectd3,true);
mygrid3.setOnRowDblClickedHandler(onRowDblClicGrid3);

	mygrid3.setSkin("modern2");
	mygrid3.enableAlterCss("even","uneven");
	

	  
	mygrid3.init();	
	
	
	function onRowDblClicGrid3(rowId,cidx){
		var no_input_time_dates = mygrid3.getUserData(rowId,"no_input_time_dates")
		var noDates = no_input_time_dates.split(',');
		var size = noDates.length;
	
		if(noDates[0] =='[]') return false;
		var html="<table style='100%'>"
		for(var i = 0;i<size;i++){
			html+="<tr><td>";
			html+=noDates[i];
			html+="</td></tr>";
		}
		html+="</table>";
		
//		alert(no_input_time_dates)
			
		var msg="<div style='width:300px;height:300px;OVERFLOW-y:auto;OVERFLOW: scroll;'>"+html+"<div>";
//		eval('var datas='+no_input_time_dates);
//		var test = eval('('+ no_input_time_dates + ')');  
		
//		alert(datas)
		
		
		Ext.MessageBox.hide(); 
		Ext.MessageBox.show(
									 	{title:'系统提示,还未录入时间的日期',msg:msg,width:380,heigth:300,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
		); 	
	}

	//	mygrid3.enableTooltips("false,false,false,false,false,false,false,false,false,false,false");
//	mygrid3.enableTooltips("false,true,true,true,true,true,true,true,true,true,true");
//	mygrid3.attachEvent("onMouseOver",grid_onMouseOver);
	
//  attachHeaderNew3(mygrid3);

//function onRowDoubleClick(rowId,b){
//	 var memo = mygrid3.getUserData(rowId,"no_input_time_dates");
//}
  

}

//function initGrid4(){
//					mygrid4 = new dhtmlXGridObject('gridbox4');
//					mygrid4.selMultiRows = false;
//					mygrid4.setImagePath(getCtxPath()+"image/grid/");
//					var flds = "频道,时段, 序 ,广告名称/版本,长度,监播";
//					var columnIds = "channel,shiduan,publishSort,matterName,matterLength,realTime";
//					mygrid4.setInitWidthsP("10,20,7,40,10,13");  
//					mygrid4.setHeader(flds);
//					mygrid4.setColumnIds(columnIds);
//					mygrid4.setColAlign("left,left,center,left,center,center");
//					mygrid4.setColTypes("ed,ed,ed,ed,ed,ed"); 
//					mygrid4.setMultiLine(false);
//					mygrid4.setEditable(false);
//					mygrid4.enableAlterCss("even","uneven"); 
//					mygrid4.setSkin("modern2");
//					mygrid4.setSizes();		
//					mygrid4.init();	 
//
//}





		



function getPrintParams(orderDetailIds){

	var paramObj = {
				 	orgId:  config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value,
				 	carrierId:Ext.getCmp('carrier_cmd').getValue() == ""?null: Ext.getCmp('carrier_cmd').getValue(),
					channelId:null,
				 	startDate:Ext.getCmp('start_date_query').getValue().format("Ymd"),
 					endDate:Ext.getCmp('end_date_query').getValue().format("Ymd"),
 					loginUser : userName,
 					displayCustomer : Ext.getCmp('cb-col-1').getValue(),
 					displayMoeny : Ext.getCmp('cb-col-2').getValue(),
 					displayNoBro : Ext.getCmp('cb-col-3').getValue(),
 					orderDetailIds:orderDetailIds
	};	


//alert(paramObj.toSource())
	return paramObj;	
	
}


function button_print2(model){

//	 var heads = mygrid.flds.replace(/\*/g,",");


	var orderDetailIds = mygrid3.getSelectedId();

	if(orderDetailIds == null){
		orderDetailIds = mygrid3.getAllItemIds(',');
	}

//	mygrid3.deleteSelectedItem();

//alert(orderDetailIds)


//	 if(orderDetailIds =='') return false;
	 
	 var paramObj = getPrintParams(orderDetailIds);

	 var printParam = {
													model:  model,
												 	title:'广告播出证明',
		                reportType: "bro_report_hbtv",
		                reportFile:'bro_report_hbtv.jasper',
//		                headers:heads, 
		                displaySumColum:"0,0,0,0,0,0,0,0,1,1,0,0",
		                colAlign:"center,center,center,left,left,left,center,center,right,right,center,center",
		                colTypes:"ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed",
		                widthsP:"9,10,8,14,13,5,8,8,7,7,6,5",
		                isSum:true,
		                isVertical:false
		 }; 
		 

    var a = Object.extend(paramObj,printParam);

	 report.loadApplet(a,ctxPath,800,500);	
	        
	
}
