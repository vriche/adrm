
var resource = new Resource();
var carrier = new Carrier();
var carrierType = new CarrierType();
var specific = new Specific();
var orderDetail = new OrderDetail();
var orderCategory = new OrderCategory();
var category = new Category();
var user = new User();
var oaAreaCity = new OaAreaCity();
var customerAddress = new CustomerAddress();
var customer = new Customer();
var linkMan = new LinkMan();
var orderBackUp = (new Order()).obj;

var brand = new Brand();
var matter_fin = new Matter();
var industry_fin = new Industry();
var customer_fin = new Customer();
var matterType = new MatterType();
var myUtils = new MyUtils();
var report = new MyPrint();

var search_adver_win;
var auto_bro_array_win;
var specific_tree_win;

var build_more_paraArray;

 var winW;
 var winH;
 var orgId =1; 
 var mygrid;
 var mygrid1;
 var mygrid2;
 var menu;
 var regCustomerGrid;
 
 
 var compagesDiaWin;
 var regCustomerWin;
 var displayWeek = false;
 var broArrange_isAlert = false;
 var broArrange_isConfirm = true;
 var copy_grid1_rowid = -1;
 var isBandBro = false;  //绑定排期，单条查看
 var isOrderEditState = false;
 var isDisplayMonDetail = false;  //拆分月份
 
 
 callOnLoad(init);	
 


//Ext.override(Ext.form.field.ComboBox, {
//		onTriggerClick: function(){	
//		 var me = this;
//		 me.clearValue();
//		 
//		if(!me.readOnly && !me.disabled){
//            if(me.isExpanded){
//                me.collapse();
//            }else{
//                me.expand();
//            }
//            me.inputEl.focus();
//        }
//	  },
//	   onKeyUp: function(e, t) {
//        var me = this,
//            key = e.getKey(), 
//		    rv = me.getRawValue();
//        if (!me.readOnly && !me.disabled && me.editable) {
//            me.lastKey = key;
//            // we put this in a task so that we can cancel it if a user is
//            // in and out before the queryDelay elapses
//            // perform query w/ any normal key or backspace or delete
//            if (!e.isSpecialKey() || key == e.BACKSPACE || key == e.DELETE) {
//                me.clearValue();
//                me.setRawValue(key_val);
//                me.doQueryTask.delay(me.queryDelay);
//            }
//        }
//        if (me.enableKeyEvents) {
//            me.callParent(arguments);
//        }
//    }
//});

  
	function init(){

		toolbar =  parent.build_more_paraArray.getTopToolbar();
		footerToolbar =  parent.build_more_paraArray.getFooterToolbar();
		
		displayWeek = $("isDisplayWeak").checked;
		
	

//		alert(toolbar.getButtons())


		var srcStr = decodeURI(window.location.href);
		ctxPath = _app_params.ctxPath;	
		
		tvNameParam =  _app_params.sysParam.tvNameParam;	
		loginUserName =  _app_params.user.username;
		loginUserFullName =  _app_params.user.fullName;
		loginUserId =  _app_params.user.id;
		
		tag_time_out =  _app_params.rights.tag_time_out;
		
		config_orderModCategoryParam =  _app_params.sysParam.orderModCategoryParam;
		config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;
		config_autoPriceTypeParam =  _app_params.sysParam.autoPriceTypeParam;
		config_industryLevelParam =  _app_params.sysParam.industryLevelParam;
		config_orderCalculateModel=  _app_params.sysParam.orderCalculateModel;
		config_withoutSubmit =  _app_params.sysParam.withoutSubmit;
		config_adverCodeModelParam = _app_params.sysParam.adverCodeModelParam;
		config_outLimitBroarrang=  _app_params.sysParam.outLimitBroarrang =="1"?true:false;
		config_resourceUseCustomerCatelog =  _app_params.sysParam.resourceUseCustomerCatelog =="1"?true:false;
		config_orderMoreCarrier =  _app_params.sysParam.orderMoreCarrier =="1"?true:false; 
		
	 	order_check_right =  _app_params.rights.tag_orderList_check;
	 	tag_orderDetail_save =  _app_params.rights.tag_orderDetail_save;
		tag_orderList_new =  _app_params.rights.tag_orderList_new;		
		
		order_year = getParamFromUrl(srcStr,"year");
		if(order_year==null) order_year = _app_params.serviceDate.year;
		
		startDate1 = _app_params.serviceDate.defStartDate;
		startDate2 = _app_params.serviceDate.def;
		endDate1 = _app_params.serviceDate.defEndDate;	

		priceTypeId = config_autoPriceTypeParam;
	
		
		if(order_year != startDate2.substring(0,4)){
			startDate2 = order_year+"0101";
			endDate1 = order_year+"0131";
		}
		
		
		
		order_id = getParamFromUrl(srcStr,"orderId");
		orgId = getParamFromUrl(srcStr,"orgId");
		resource_sort = getParamFromUrl(srcStr,"resource_sort");
		orderCategoryMain = getParamFromUrl(srcStr,"orderCategoryMain");
		orderCategoryMainId = getParamFromUrl(srcStr,"orderCategoryMainId");
		orderCkeckState = getParamFromUrl(srcStr,"orderCkeckState");
		
		fromModel= getParamFromUrl(srcStr,"fromModel");
		
		paymentId= getParamFromUrl(srcStr,"paymentId");
		customerId = getParamFromUrl(srcStr,"customerId");  
		customerName = getParamFromUrl(srcStr,"customerName");  
   		customer_category_id = getParamFromUrl(srcStr,"customerCategoryId");
		userId = getParamFromUrl(srcStr,"userId");  
		fullName = getParamFromUrl(srcStr,"fullName");  
		sum_money = getParamFromUrl(srcStr,"sumMoney");
		sum_times = getParamFromUrl(srcStr,"sumTimes");
		order_code = getParamFromUrl(srcStr,"orderCode");
		relation_code = getParamFromUrl(srcStr,"relationCode");
		ad_length = getParamFromUrl(srcStr,"adLength");
		
		
	
		
		
//		order_check_state = getParamFromUrl(srcStr,"orderCkeckState");
			
		
		isOrderEditState = order_id > 0;
		
	

	    if(config_withoutSubmit == 1){
	    	isDisabledSaveButton = orderCkeckState == 3?true:false;
	    }else{
	    	//通过 审核中
	    	isDisabledSaveButton = orderCkeckState ==1 ||orderCkeckState ==3 ?true:false;
	    }
	    
//	    if(!isOrderEditState) isDisabledSaveButton = false;

		add_build_more_paraArray_win_topToolbar();

		
//		if(orderCategoryMain != 0){
//			parent.document.getElementById("paymoney_for_paraArray").readOnly = true;
//		}else{
//			parent.document.getElementById("paymoney_for_paraArray").readOnly = false;
//		}

		paramFromUrl ={};
		
			paramFromUrl.orgId = orgId;
			paramFromUrl.isLock = false;
			paramFromUrl.version = order_year;
			paramFromUrl.orderCategoryMain = orderCategoryMain;	
			paramFromUrl.startDate = startDate1;
			paramFromUrl.endDate = endDate1;
			paramFromUrl.priceTypeId = priceTypeId;	
			paramFromUrl.resourceIds = new Array();
//			paramFromUrl.resourceIds = resourceIds.replace(/%2C/g, ',');
			paramFromUrl.isTimeOutRight = tag_time_out;	
			
			

	
		resetHeigth();
		initGrid1();
//		initGrid2();
		resetHeigth();


     
     	var Btn_orderCode_for_paraArray = parent.document.getElementById("orderCode_for_paraArray");
		Btn_orderCode_for_paraArray.onkeypress = function a(event){DWRUtil.onReturn(event,getOrder_by_orderCode);}; 	


		
	


//		if(isOrderEditState && paymentId == 0){
//			getOrderDetails_to_mygrid1(order_id,true);
//			rebackBroArrange.show();
//		}else{
//			addGrid1NewRow();
//			rebackBroArrange.hide();
//		}
		
		parent.document.getElementById("paymoney_for_paraArray").value = ForDight(sum_money,2);
		parent.document.getElementById("totalTime_for_paraArray").value = sum_times;	
		parent.document.getElementById("orderCode_for_paraArray").value = order_code;	
		parent.document.getElementById("relationCode_for_paraArray").value = relation_code;	
		
		
		if(isOrderEditState){
			getOrderDetails_to_mygrid1(order_id,true);
			rebackBroArrange.show();
		}else{
			initGrid2();
//			addGrid1NewRow();
			rebackBroArrange.hide();
		}

		
		
		 disableDestop();
//		alert(Ext.lib.Dom.getViewWidth())
  }
  
  
  
  function getOrder_by_orderCode(){
  
  	var orderCode = parent.document.getElementById("orderCode_for_paraArray").value;

  	
  	if(orderId >0){
  		var getOrderFun = function (o){
			int_set_user(o.userId,o.user.fullName);			
	        var cutCmd = toolbar.getComponent("customerName_for_paraArray");
	        var userCmd = toolbar.getComponent("userId_for_paraArray");
			inti_set_cmd(cutCmd,o.customerId,o.customer.customerName,1,o.customer.customerCategoryId);
			inti_set_cmd(userCmd,o.userId,o.user.fullName,2);	
//			alert(o.user.fullName)
  		}
		order.getOrderForEdit(orderId,getOrderFun);
  	}
  }
  
  
  function getOrderDetails_to_mygrid1(orderId,backup,curSelectedRows){


//  	var orderId = mygrid.getSelectedId();
	
	var paramObj = new OrderDetail();
	
//	alert(sum_times)

//	parent.document.getElementById("paymoney_for_paraArray").value = ForDight(sum_money,2);
//	parent.document.getElementById("totalTime_for_paraArray").value = sum_times;	
//	parent.document.getElementById("orderCode_for_paraArray").value = order_code;	
//	parent.document.getElementById("relationCode_for_paraArray").value = relation_code;	
	
	
	
//	parent.build_more_paraArray.setTitle(parent.build_more_paraArray.title+order_code) ;
	
//	mygrid2.detachAllEvents();
//	mygrid2.clearAll();
//	mygrid1.clearAll();
	Ext.getBody().mask('数据处理中……', 'x-mask-loading'); 	 
	
	function loadFun(){

			
		if(backup){
				orderBackUp = save_more_orderDetail(1);
				orderBackUp.mygrid1 = new HashMap();
	
				for (var i = 0; i < mygrid1.getRowsNum(); i++){
					var row_id = mygrid1.getRowId(i);
					var row = mygrid1.getRowById(row_id);
	
					var rows = new Array();
					for (var j = 0; j < row.cells.length; j++){
						if(j == 4||j == 7){
							var command = mygrid1.getCombo(j);
							var spe_txt =  mygrid1.cells(row_id,j).getValue();
							var spe_id = command.getKey(spe_txt);
							rows[j] = spe_id;
						}else{
							rows[j] = mygrid1.cells(row_id,j).getValue();
						}
						
//						if(i==0){
//							alert(j)
//							alert(mygrid1.cells(row_id,j).getValue())
//						}
					}	
	                
					
					var bak_obj = {};
					bak_obj.resourceId = mygrid1.getUserData(row_id,"resourceId"); //15
					bak_obj.pos = mygrid1.getUserData(row_id,"pos");       //16
					bak_obj.matterId = mygrid1.getUserData(row_id,"matterId");   //17
					bak_obj.id = mygrid1.getUserData(row_id,"id");         //18s
					bak_obj.adLength = mygrid1.getUserData(row_id,"length");         //18s

					rows[rows.length] = bak_obj; //15

					orderBackUp.mygrid1.put(row_id,rows);
	
				}				
		}

		

		 window.setTimeout(function(){
			    
				if(curSelectedRows){
					for(var i =0;i<curSelectedRows.length;i++) {
						var rowIndex = mygrid1.getRowIndex(curSelectedRows[i].idd);
						mygrid1.selectRow(rowIndex, true, true, false); 
						break;
					}
				}else{
					if(mygrid1.getRowsNum()>0){
//						mygrid1.selectRow(0,true);
						mygrid1.selectRow(0, true, true, false); 
//						 if(config_resourceUseCustomerCatelog)  toolbar.getComponent("customerName_for_paraArray").setDisabled(true);
					}
				}
				Ext.getBody().unmask(); 
				mygrid1.clearChangedState();
			}, 1000);

	}
	  
	var fnc = function(xml){
//		alert('338>>xml>>'+xml)
		initGrid2();
		resetHeigth_gridbox2();
		mygrid2.clearAll();
		
		mygrid1.clearAll();	
		mygrid1.loadXMLString(xml,loadFun);
//		if(mygrid1.getRowsNum()>0) mygrid1.selectRow(0,true);
	}	


  

	paramObj.obj.orgId = orgId; 
	paramObj.obj.orderId = orderId;
	paramObj.obj.parentId = 0;
	paramObj.obj.loginUser = loginUserName; 
	paramObj.obj.tableModel = isDisplayMonDetail?5:4;
	
	
	paramObj.getOrderDetailsForFztv(fnc);	
  }

  
  function clean_mygrid2_broArray_by_grid1id(mygrid1_row_id){
	var rowId2s = getRowByUserData(mygrid2,"grid1_rowId",mygrid1_row_id);
	for (var j = 0; j < rowId2s.length; j++){
		for (var i = 0; i < 33; i++){
				 var type = mygrid2.getUserData(rowId2s[j],"grid1_row_type");
				   if(type != 0){
						var td = mygrid2.cells(rowId2s[j],i+4).cell;
						 td.innerHTML ='';   
				   }

		}
	}	 
	var sumTime_cindex = mygrid1.getColIndexById('sumTime');
	mygrid1.cells(mygrid1_row_id,sumTime_cindex).setValue(''); 
	reset_grid1_totalTime();
  }
  
  function clean_mygrid2_all_broArray(){
	   var sumTime_cindex = mygrid1.getColIndexById('sumTime');
		var rows =  mygrid1.selectedRows;
		for(var i = 0;i<rows.length;i++){
			var mygrid1_row_id = rows[i].idd;
	 		 clean_mygrid2_broArray_by_grid1id(mygrid1_row_id);  
		}
  }
   
   
  function reback_broArrange(){
		var rows =  mygrid1.selectedRows;
		for(var i = 0;i<rows.length;i++){
			var row_id = rows[i].idd;
			var isNew = (mygrid1.getUserData(row_id,"isNew") == 1);
			if(!isNew){	
			    var rows = orderBackUp.mygrid1.get(row_id);

				for (var j = 0; j < rows.length; j++){
					mygrid1.cells(row_id, j).setValue(rows[j]);
				}

			    var bak_obj = rows[rows.length];

				mygrid1.setUserData(row_id,"resourceId",bak_obj.resourceId);
				mygrid1.setUserData(row_id,"pos",bak_obj.pos);
				mygrid1.setUserData(row_id,"matterId",bak_obj.matterId);
				mygrid1.setUserData(row_id,"id",bak_obj.id);
		
				reset_mygrid2_row(row_id,-1);
			}else{
				
			}
		}
  }
 
 
 
// function displayDetailWithMonth(){
// 	getOrderDetails_to_mygrid1(order_id);
// }


 function display_weak_rows_info(){
	var  hidden = !$("displayAllBroArray").checked;	
	var rowids = getRowByUserData(mygrid2,"grid1_rowId",0,"grid1_row_type",0);

	if(displayWeek){
			if(hidden){
				for(var i =0;i<rowids.length;i++){ 
					mygrid2.setRowHidden(rowids[i],true);
				}	
//				var selectedId = mygrid1.getSelectedRowId();
//				var rowids = getRowByUserData(mygrid2,"grid1_rowId",selectedId,"grid1_row_type",0);
//				for(var i =0;i<rowids.length;i++){ 
//					mygrid2.setRowHidden(rowids[i],false);
//				}	
				
				
				var rows = mygrid1.selectedRows;
				for(var i = 0;i<rows.length;i++){
					var rowId = rows[i].idd;
//					var selectedId = mygrid1.getSelectedRowId();
					var rowids = getRowByUserData(mygrid2,"grid1_rowId",rowId,"grid1_row_type",0);
					for(var j =0;j<rowids.length;j++){ 
						mygrid2.setRowHidden(rowids[j],false);
					}	
				}
				
				
				
				
			}else{
				for(var i =0;i<rowids.length;i++){ 
					mygrid2.setRowHidden(rowids[i],false);
				}		
			}

	}else{
				for(var i =0;i<rowids.length;i++){ 
					mygrid2.setRowHidden(rowids[i],true);
				}	

	}	
 }


 function add_build_more_paraArray_win_topToolbar(){
 	
 	
 	var Btn_isDisplayWeak = $("isDisplayWeak");
	Btn_isDisplayWeak.onclick = function(){
		 displayWeek = this.checked;
		 display_weak_rows_info();
	};
 	
 	var Btn_displayAllBroArray = $("displayAllBroArray");
	Btn_displayAllBroArray.onclick = display_mygrid1_all_broArray; 	
	
	 
 	var Btn_isDisplayMonDetail = $("isDisplayMonDetail");
	Btn_isDisplayMonDetail.onclick = function(){
		isDisplayMonDetail = this.checked;
		if(order_id >0){mygrid2.clearAll();getOrderDetails_to_mygrid1(order_id);};
	}
	
	
	//清除排期
	var Btn_cleanBroArrange = $("cleanBroArrange");
	Btn_cleanBroArrange.onclick = clean_mygrid2_all_broArray; 	

	var Btn_rebackBroArrange = $("rebackBroArrange");
	Btn_rebackBroArrange.onclick = reback_broArrange; 	
	
	
//	var Btn_orderCode_for_paraArray = parent.document.getElementById("orderCode_for_paraArray");
//	Btn_orderCode_for_paraArray.onkeypress = function a(event){DWRUtil.onReturn(event,getOrder_by_orderCode);}; 	
	
	function addNextMonthBroArrange(){
		var rows =  mygrid1.selectedRows;
		for(var i = 0;i<rows.length;i++){
			reset_mygrid2_row(rows[i].idd,5);
		}
	}
	
	var Btn_addNextMonthBroArrange = $("addNextMonthBroArrange");
	Btn_addNextMonthBroArrange.onclick = addNextMonthBroArrange; 		



 	var build_more_paraArray = parent.build_more_paraArray;
// 	var toolbar =  build_more_paraArray.getTopToolbar();
// 	var toolbar =  build_more_paraArray.getButtomToolbar();

//    alert(build_more_paraArray.getBottomToolbar());

	function removeWin(){
		
//		alert(1111)

			if(fromModel == 1){  //订单编辑
					 var url = parent.location.href;
				     var param = $H(url.toQueryParams());
				     param.set("id",or.id);
					 url =  ctxPath + "editOrder.html?" + param.toQueryString();	
					 parent.location.href = url;
					 parent.build_more_paraArray.destroy();
			}        
	        
		build_more_paraArray.destroy();
	} 	
// 	function save_more_orderDetail(){ return  save_more_orderDetail();}	
// 	function setSelectGridChecked(){ return setSelectGridChecked();}
// 		tbbutton tooltip: '加段位',
 	var btnAddResource = {xtype:'button', id:'btn_displayCompagesTree_2', text: '选择段位',iconCls:'admin-tool-add',handler: function(){
 		displayCompagesTree2(2);} 
 		};
 	
    var btnAddGrid1NewRow = {xtype:'button',id:'btn_addGrid1NewRow',text: '新建',iconCls:'admin-tool-add',handler: function(){
    	addGrid1NewRow();gotoNewRow();} }; 

    var btnChoseResource = {xtype:'button',id:'btn_displayCompagesTree_1',text: '单段位',iconCls:'admin-tool-add',handler: function(){
 		if(setSelectGridChecked()) displayCompagesTree2(1);} }; 	

 	var btnChoseEdit = {xtype:'button',id:'btn_search_adver_cont',text: '设版本',iconCls:'admin-tool-add',handler: function(){
 		if(setSelectGridChecked()) search_adver_cont(1);} 
 	};
 	
// 	var btnChoseApp = {xtype:'button',text: '设指定',iconCls:'admin-tool-add',handler: function(){
// 		if(setSelectGridChecked()) getSpecificTreeWin();} }; 
 	
 	var btnChoseArray = {xtype:'button',id:'btn_setAutoBroArray',text: '设排期',iconCls:'admin-tool-add',handler: function(){
 		if(setSelectGridChecked()) setAutoBroArray();} };

    var btnRemove = {xtype:'button',id:'btn_removeGrid1NewRow',text: ' 删 除 ',iconCls:'admin-tool-delete',handler: function(){
    	if(setSelectGridChecked()) removeGrid1NewRow();} };

 	
	var fitterComboBox = report.getFtiterSort('fitter_cmd_id','分组:',80,null,true);
	
//	var monthDetailComboBox = report.getFtiterSort('month_detail_cmd_id','分月显示:',80,null,true);

//   alert('isOrderEditState_'+isOrderEditState)
   
//    alert('fromModel_'+fromModel)
	
    var defValue = (isOrderEditState && fromModel ==1)||orderCategoryMainId ? orderCategoryMainId:config_orderModCategoryParam;
    
   
    
	var cateMain_com = _make_order_cateMain_select2(null,'categoryId_for_paraArray',70,null,null,orgId,null,null,defValue,true);
  
	
	
//	 var div_cateMain_com = document.createElement("div");
//	  div_cateMain_com.setAttribute("style","margin:0px auto; border:solid 1px blue; text-align:left");



	var paymoney_text = "<div id='paymoney_for_paraArray_div'>金额<input type='text' class='single' id='paymoney_for_paraArray' size=6 style='height:16;text-align:right'/></div>";
	var totalTime_text = "<div id='totalTime_for_paraArray_div'>次数<input type='text' id='totalTime_for_paraArray' size=3 style='height:16;text-align:center' readOnly=true/></div>";
	var orderCode_text = "<div id='orderCode_for_paraArray_div'>订单号<input type='text' id='orderCode_for_paraArray' size=5 style='height:16;text-align:right'/></div>";
	var relationCode_text = "<div id='relationCode_for_paraArray_div'>关联号<input type='text' id='relationCode_for_paraArray' size=5 style='height:16;text-align:right'/></div>";
	

	var paramObJ ={};
	paramObJ.orgId =  orgId; 
	paramObJ.loginUser = loginUserName;
	paramObJ.loginUserId = loginUserId;
	user.obj = paramObJ;
	var userCmd = user.getUsersByOrgLimit2(null,"userId_for_paraArray",80,null,true);	


	

	
	var cust = new Customer();
	cust.obj.orgId = orgId;
	var cutCmd = cust.get_custumer_for_order2('remote',180,300,'customerName_for_paraArray',null,'请选择客户...',true);

	var cmdYear = myUtils.getComYear('year_for_paraArray','年份',50,order_year,true) ;
	
	
//,paymoney_text,totalTime_text
//	var tbar =[btnAddResource,btnAddGrid1NewRow,btnChoseResource,btnChoseEdit,btnChoseApp,btnChoseArray,fitterComboBox,cmdYear,cutCmd,userCmd,cateMain_com,paymoney_text,totalTime_text];
   var tbar =[btnAddResource,btnChoseEdit,btnChoseArray,fitterComboBox,cmdYear,cutCmd,userCmd,cateMain_com,paymoney_text,totalTime_text,orderCode_text,relationCode_text];
   
  
   
//	var tbar1 =[btnAddResource,btnAddGrid1NewRow,btnChoseResource,btnChoseEdit,btnChoseApp,btnChoseArray];
//   	var tbar2 =[fitterComboBox,cmdYear,cutCmd,userCmd,cateMain_com,paymoney_text,totalTime_text];
     


 	var btnNew = {text: '新建'
 			,id:'Btn_save_more_new'
 			,handler: function(){
 		
// 		mygrid2.toExcel(ctxPath + 'servlet/dhtmlExcelGeneratorServlet');
// 		
// 		return false;
 		mygrid1.clearAll();mygrid2.clearAll();isOrderEditState = false;
 		footerToolbar.getComponent("Btn_save_more_orderDetail").setDisabled(false);
        orderCkeckState = 0;
        order_id = null;
        isOrderEditState = false;
        sum_money = 0;
        sum_times = 0;
        order_code = '';
		parent.document.getElementById("paymoney_for_paraArray").value = ForDight(sum_money,2);
		parent.document.getElementById("totalTime_for_paraArray").value = sum_times;	
		parent.document.getElementById("orderCode_for_paraArray").value = order_code;	
		parent.document.getElementById("relationCode_for_paraArray").value = relation_code;	
		
		addGrid1NewRow();
		enableDestop();
 	} };
 	

 
 	
  	var btnSave = {text: '保存',id:'Btn_save_more_orderDetail',handler: function(){save_more_orderDetail();},disabled:!tag_orderDetail_save };
  	
  	
 	var btnClose = {text: '关闭',handler: function(){
 		
       

 		if(fromModel == 1){  //订单编辑
 			if(orderBackUp.orderDetailsObj){
					 var url = parent.location.href;
				     var param = $H(url.toQueryParams());
				     param.set("id",order_id);
					 url =  ctxPath + "editOrder.html?" + param.toQueryString();	
					 parent.location.href = url;
 			}
		}else if(fromModel == 2){
			 var url = parent.location.href;
		     var param = $H(url.toQueryParams());
//		     param.set("id",order_id);
		     if(order_id >0){
			     url =  ctxPath + "editOrder.html?id=" + order_id +"&"+ param.toQueryString()+ "&orgId=1";
				 parent.location.href = url;
		     }

		}else if(fromModel == 3){
//			 var url =  ctxPath + "orders.html";
			 if(order_id >0){
				 var url =  ctxPath + "editOrder.html?id="+ order_id + "&orgId=1";
				 parent.location.href = url;
			 }

		}
 		
 		build_more_paraArray.destroy();
 	
 	} };		
 		
// 	var checkBoxDisplayWeek =  {xtype:"checkbox", boxLabel:"显示星期",handler: function(e,v){displayWeek = v;getAllResourceMonthInfos();}};
//   	var	fbar = [btnNew,'->',btnSave,btnClose];
	var	fbar = ['->',btnSave,btnClose];
// 	var fotterBars = [];
// 	fotterBars.push(btnNew);
// 	fotterBars.push('->');
// 	if(tag_orderDetail_save  && order_check_state !=3) fotterBars.push(btnSave);
// 	fotterBars.push(btnClose);
//   	var	fbar = fotterBars;
//    toolbar.remove(toolbar.get(1));  
//    toolbar.addButton(tbar1);
//    toolbar.addItem(tbar2);
//    build_more_paraArray.doLayout();
//    build_more_paraArray.doLayout();
//    toolbar.doLayout();
//     var panel = new Ext.form.FormPanel();
//    	
//     for (var i = 0; i < tbar.length; i++) { 
//
//     	panel.add(tbar[i]); 
//     	
//     }
 
            //添加组件完成后，调用下面的函数重新显示panel及组件
//     panel.doLayout()
    
     toolbar.add(tbar);
     footerToolbar.add(fbar);
     
//	for (var i = 0; i < tbar.length; i++) { 
//     	toolbar.addField(tbar[i]); 
//     }  
 
    toolbar.doLayout();
    footerToolbar.doLayout();
   
    fitterComboBox = toolbar.getComponent("fitter_cmd_id");
   	fitterComboBox.on("select",function(cbo){mygrid1.groupBy(cbo.value)},this);	
	fitterComboBox.on("clear",function(){mygrid1.unGroup();},this);	  
    
    cateMain_com = toolbar.getComponent("categoryId_for_paraArray");
//    cateMain_com.setValue(config_orderModCategoryParam);
    cateMain_com.on("select",function(cbo,value){reset_orderCategoryMain(cbo,value)},this);	
	orderCategoryMain = getValueFromStoreById(cateMain_com,"calculateAuto");
	
	 cmdYear = toolbar.getComponent("year_for_paraArray");
//	 cmdYear.setValue(_app_params.serviceDate.year);
	cmdYear.on("select",function(cbo,value){order_year = cbo.value},this);		
	
	cutCmd = toolbar.getComponent("customerName_for_paraArray");
	if(customerId > 0){inti_set_cmd(cutCmd,customerId,customerName,1,customer_category_id);} 
	
	userCmd = toolbar.getComponent("userId_for_paraArray");
	if(userId > 0){inti_set_cmd(userCmd,userId,fullName,2);}	
	
	if(tvNameParam=='fztv' && order_id=='0'){
		userCmd.setValue(loginUserId);
	}
	

	

//	toolbar.addButton(tbar)	  
	  
 }
 
 function initPosition_compagesDiaWin(){
	   var doc = document, bd = (doc.body || doc.documentElement);
//		var left = bd.scrollLeft + Ext.lib.Dom.getViewWidth()-2-compagesDiaWin.width;
		var top = bd.scrollTop + Ext.lib.Dom.getViewHeight()-6-compagesDiaWin.height;

	  compagesDiaWin.setPosition(bd.scrollLeft+2,top);	
 }

  function initPosition_auto_bro_array_win(){

		if(compagesDiaWin){
			if(!compagesDiaWin.hidden){
				 var left =  compagesDiaWin.width+2;
				 var top = 2;		
				 auto_bro_array_win.setPosition(left,top);	
			}
			
		}

 }
  
  function sleep(n)
  {
    var start=new Date().getTime();
   
    while(true) if(new Date().getTime()-start>n) break;
  }
 
function createGrid1(param,caFun){
	 var objs =  param.resources;
	 var rs_cindex = mygrid1.getColIndexById('resourceName');
	 var newIdArray = new Array();
//	 Ext.getBody().mask('数据处理中……', 'x-mask-loading'); 	

	 for(var i = 0;i<objs.length;i++){
	 	 var row_id = addGrid1NewRow();
//	 	 sleep(2000);
	 	 newIdArray.push(row_id);
	 	 
	 	 var  carrierName = config_orderMoreCarrier?objs[i].carrierName:"";
	 	 var  broTime = objs[i].broTime;
	 	 var  resourceMemo =  objs[i].resourceMemo  ;
	 	 var  resourceName =  objs[i].resourceName  ;
	 	 var  resourceName =  resourceMemo!=resourceName? resourceName:"";
//	 	 var  pos = broTime +' '+ resourceMemo  +' '+ resourceName;
	 	 var  pos =  resourceMemo  +' '+ resourceName +' '+broTime;
	 	 if(config_orderMoreCarrier && carrierName) pos = carrierName+' '+pos;
	 	 
		 mygrid1.cells(row_id,rs_cindex).setValue(pos);
		 mygrid1.setUserData(row_id,"resourceId",objs[i].id);
		 mygrid1.setUserData(row_id,"pos",carrierName+ objs[i].resourceMemo);
	 }
//	 	Ext.getBody().unmask(); 
	 return newIdArray;
}

  
function resetHeigth(){
	resetHeigth_gridbox1();
	resetHeigth_gridbox2();		
} 

function resetHeigth_gridbox1(){
	winW = parent.build_more_paraArray.getInnerWidth();
	winH = parent.build_more_paraArray.getInnerHeight();
	var mid_heigth =  toolbar.getHeight() + footerToolbar.getHeight()/2;
	var gridbox1 = $("gridbox1");
	gridbox1.style.width = winW +"px";	
	gridbox1.style.height = winH*0.35+"px";  
} 

function resetHeigth_gridbox2(){
	winW = parent.build_more_paraArray.getInnerWidth();
	winH = parent.build_more_paraArray.getInnerHeight();
	var mid_heigth =  toolbar.getHeight() + footerToolbar.getHeight()/2;   
	var gridbox2 = $("gridbox2");
	gridbox2.style.width = winW +"px";	
	gridbox2.style.height = winH*0.65- mid_heigth +"px";  
} 

function reset_grid1_date(rowId){
	var s_cindex = mygrid1.getColIndexById('start');
	var e_cindex = mygrid1.getColIndexById('end');
	
	var rowId2s =  getRowByUserData(mygrid2,"grid1_rowId",rowId);
	var used_days = new Array();
	for (var j = 0; j < rowId2s.length; j++){
		for (var i = 0; i < 31; i++){
			var td = mygrid2.cells(rowId2s[j],i+4).cell;
			var times = td.innerHTML;
			if(times >0){
				var dayObj = td.dayObj;
				if(dayObj){
					var day = dayObj.dayDate;
					used_days.push(day);
				}

			}
		}
	}	
		
	var max = Math.max.apply(Math,used_days); 
	var min = Math.min.apply(Math,used_days); 

	if(min !='Infinity'){
		mygrid1.cells(rowId,s_cindex).setValue(getFormatDay(min,'y/m/d'));
		mygrid1.cells(rowId,e_cindex).setValue(getFormatDay(max,'y/m/d'));		
	}else{
		mygrid1.cells(rowId,s_cindex).setValue(getFormatDay(startDate2,'y/m/d'));
		mygrid1.cells(rowId,e_cindex).setValue(getFormatDay(endDate1,'y/m/d'));		
	}				 	
	
}

function reset_grid2_month_sumTimes(grid1_row_id){ 
	var sumTime_cindex = mygrid1.getColIndexById('sumTime');
	var rowId2s =  getRowByUserData(mygrid2,"grid1_rowId",grid1_row_id,"grid1_row_type",1);
	var grid2_month_sumTimes = 0;
	for (var i = 0; i < rowId2s.length; i++){
		for(var j = 0;j<31;j++){
    		var cellIndex = j+4;
    		var b = mygrid2.cells(rowId2s[i],cellIndex).cell.innerHTML; 
    		b = b ==""?0:b*1;
    		if(b >0){
    			grid2_month_sumTimes = grid2_month_sumTimes*1 + b*1;
    		}
		}
		grid2_month_sumTimes = grid2_month_sumTimes ==0?"":grid2_month_sumTimes;
	    mygrid2.cells(rowId2s[i],35).cell.innerHTML = grid2_month_sumTimes;
	}		

}

function reset_grid1_sumTimes(grid1_row_id){ 
	var sumTime_cindex = mygrid1.getColIndexById('sumTime');
	var rowId2s =  getRowByUserData(mygrid2,"grid1_rowId",grid1_row_id,"grid1_row_type",1);
	var sumTime_grid2 = 0;
	for (var i = 0; i < rowId2s.length; i++){
		var b = mygrid2.cells(rowId2s[i],35).cell.innerHTML; 
		if(b >0){
			sumTime_grid2 = b*1 + sumTime_grid2*1;
		}
	}		
    sumTime_grid2 = sumTime_grid2 ==0?"":sumTime_grid2;
	mygrid1.cells(grid1_row_id,sumTime_cindex).setValue(sumTime_grid2);
}
function reset_grid1_sumPay(rowId,cellIndex,wasChanged){ 

					var sumTime_cindex = mygrid1.getColIndexById('sumTime');
					var sumPay_cindex = mygrid1.getColIndexById('sumPay');
					var stantPrice_cindex = mygrid1.getColIndexById('stantPrice');
					var realPrice_cindex = mygrid1.getColIndexById('realPrice');
					var ordersubcate_cindex = mygrid1.getColIndexById('ordersubcate');

					
					var favace_cindex = mygrid1.getColIndexById('favace');
					var appRae_cindex = mygrid1.getColIndexById('appRae');
					var balance_cindex = mygrid1.getColIndexById('balance');
//					var isMonMoney_cindex = mygrid1.getColIndexById('isMonMoney'); 
					

					
					var  sumTime = mygrid1.cells(rowId,sumTime_cindex).getValue();
					var  stantPrice = mygrid1.cells(rowId,stantPrice_cindex).getValue();
					var  relpay = mygrid1.cells(rowId,realPrice_cindex).getValue();
						
					var  favace = mygrid1.cells(rowId,favace_cindex).getValue();
					var  appRae = mygrid1.cells(rowId,appRae_cindex).getValue();
					var moneyBalance = mygrid1.cells(rowId,balance_cindex).getValue();
//					var isMonMoney= mygrid1.cells(rowId,isMonMoney_cindex).getValue();
					
					
					var command = mygrid1.getCombo(ordersubcate_cindex);
					var calculateauto_key = mygrid1.cells(rowId,ordersubcate_cindex).getValue();
					var calculateauto = command.calculateauto[calculateauto_key];	
					

						favace = favace > 0 ? favace/100:favace;
						appRae = appRae > 0 ? appRae/100:appRae;
						favace = favace ==""||favace ==0?1:favace;
						appRae = appRae ==""?0:appRae;
						moneyBalance= moneyBalance ==""?0:moneyBalance;
						
						
//						alert('config_orderCalculateModel_'+config_orderCalculateModel)
//						alert('stantPrice_'+stantPrice)
//						alert('favace_'+favace)
//						alert('appRae_'+appRae)
//						alert('calculateauto_key_'+calculateauto_key)
//						alert('calculateauto_'+calculateauto)
					
					if(config_orderCalculateModel == 0){
						relpay = stantPrice*favace*(1+appRae*1)+moneyBalance;
					}
//						alert('relpay_'+relpay)	
						
					sumTime = sumTime ==""?0:sumTime;	
					relpay = relpay ==""?0:relpay;

					var sum_pay = 0;
					if(config_orderCalculateModel == 0){
						sum_pay = sumTime * relpay;
					}else{
						sum_pay =  relpay * sumTime * favace*(1+appRae*1)+ moneyBalance*1;
					}
					

		
					relpay = relpay ==0?"":relpay;
					sum_pay = sum_pay ==0?"":sum_pay;
				
//	             alert('3 relpay_'+relpay)
	             
//	              alert('3 orderCategoryMain_'+orderCategoryMain)
			
					if(orderCategoryMain != 0){

						relpay = (calculateauto == 1)?ForDight(relpay,2):"";
						sum_pay = (calculateauto == 1)?ForDight(sum_pay,2):"";
					
//						 alert('3 calculateauto_'+calculateauto) 
//						  alert('3 relpay_'+relpay)
						
						if(config_orderCalculateModel == 0){
							mygrid1.cells(rowId,realPrice_cindex).setValue(relpay);
						}
						
			
						mygrid1.cells(rowId,sumPay_cindex).setValue(sum_pay); 
						

						var rowId2s =  getRowByUserData(mygrid2,"grid1_rowId",rowId);
						for (var j = 0; j < rowId2s.length; j++){
							var td_time = mygrid2.cells(rowId2s[j],35).cell;
							var td_month_pay = mygrid2.cells(rowId2s[j],36).cell;
							var times = td_time.innerHTML;
							times = times ==""||times =="&nbsp;"?"0":times;
							relpay = relpay ==""?0:relpay;
							var month_pay =  0;
//							month_pay = ForDight(month_pay,2);
							if(config_orderCalculateModel == 0){
								month_pay =  times * relpay;
							}else{
								month_pay =  relpay * times * favace*(1+appRae);
							}
							month_pay = month_pay ==0?"":month_pay;
							
							td_month_pay.innerHTML = (calculateauto == 1)?ForDight(month_pay,2):"";
						}						 
						 
					}else{

						 mygrid1.cells(rowId,realPrice_cindex).setValue('');
						 mygrid1.cells(rowId,sumPay_cindex).setValue('');

						 var rowId2s =  getRowByUserData(mygrid2,"grid1_rowId",rowId);
						 for (var j = 0; j < rowId2s.length; j++){
							var td_month_pay = mygrid2.cells(rowId2s[j],36).cell;
							td_month_pay.innerHTML = "";
						 }
					}
					
				
			
		if(orderCategoryMain != 0){
			var sum_paymoney= 0;			
			for (var j = 0; j <mygrid1.getRowsNum(); j++){	
				var v = mygrid1.cells2(j,sumPay_cindex).getValue(); 
				v = v ==""?0:v;
				sum_paymoney = sum_paymoney +v*1;
			
			}		
			parent.document.getElementById("paymoney_for_paraArray").value = ForDight(sum_paymoney,2);

		}			
							 
}


	
						
function build_grid1_menuStr(){
	 	var sb;
	sb = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	sb = sb + "<menu id=\"0\">"
//	sb = sb + "<item text=\"设段位\" img=\"green.gif\"  id=\"btnChoseResource\"/>";
//	sb = sb + "<item text=\"设版本\" img=\"green.gif\"  id=\"btnChoseEdit\"/>";
	sb = sb + "<item text=\"设指定\" img=\"green.gif\"  id=\"btnChoseApp\"/>";
//	sb = sb + "<item text=\"设排期\" img=\"green.gif\"  id=\"btnChoseArray\"/>";
	sb = sb + "<item text=\"设类别\" img=\"green.gif\"  id=\"btnChoseOrderSubCate\"/>";
	sb = sb + "<item text=\"设价格\" img=\"green.gif\"  id=\"btnChosePrice\"/>";
	sb = sb + "<item text=\"设折扣\" img=\"green.gif\"  id=\"btnChoseFavu\"/>";
	sb = sb + "<item text=\"设加收\" img=\"green.gif\"  id=\"btnChoseAppRate\"/>";
	sb = sb + "<item text=\"补差\" img=\"green.gif\"  id=\"btnBalance\"/>";
	
	sb = sb + "<item  type=\"separator\"  id=\"file_sep_1\"/>";


	sb = sb + "<item text=\"复制\" img=\"copy.gif\" imgdis=\"copy_dis.gif\"  id=\"copy\"/>";
	sb = sb + "<item text=\"粘贴\" img=\"paste.gif\"  imgdis=\"paste_dis.gif\"  id=\"post\">";
		sb = sb + "<item text=\"段位\" img=\"red.gif\"  id=\"post_pos\"/>";
		sb = sb + "<item text=\"版本\" img=\"red.gif\"  id=\"post_edit\"/>";
		sb = sb + "<item text=\"排期\" img=\"red.gif\"  id=\"post_arr\"/>";
		sb = sb + "<item text=\"所以\" img=\"red.gif\"  id=\"post_all\"/>";
	sb = sb + "</item>";
	
	sb = sb + "<item  type=\"separator\"  id=\"file_sep_2\"/>";
	
	sb = sb + "<item text=\"复制并新添\" img=\"new.gif\"  id=\"copy_post\"/>";	
//	sb = sb + "<item text=\"漂移并新添\" img=\"new.gif\"  id=\"copy_move\"/>";
//	sb = sb + "<item text=\"顺延一个月\" img=\"new.gif\"  id=\"add_one_month\"/>";
	sb = sb + "<item  type=\"separator\"  id=\"file_sep_3\"/>";
	
//	sb = sb + "<item text=\"绑定排期\" img=\"green.gif\"  id=\"menu_ext_radio\"/>";
	
	sb = sb + "<item  type=\"separator\"  id=\"file_sep_4\"/>";
	
	if(!isDisabledSaveButton) sb = sb + "<item text=\"删除\" img=\"delete.gif\"  id=\"remove\"/>";
	
	sb = sb + "<item  type=\"separator\"  id=\"file_sep_5\"/>";
	
	sb = sb + "<item text=\"刷新排期\" img=\"new.gif\"  id=\"refrsh_arr\"/>";	
	
	
	sb = sb + "</menu>";
	return sb;
}
	
function build_grid2_menuStr(){
	 	var sb;
	sb = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	sb = sb + "<menu id=\"0\">"
	sb = sb + "<item text=\"删除本月排期\" img=\"delete.gif\"  id=\"remove_cur_month_array\"/>";
	sb = sb + "<item text=\"清空本月排期\" img=\"delete.gif\"  id=\"clean_cur_month_array\"/>";
	sb = sb + "</menu>";
	return sb;
}	
	
	

	
function display_mygrid1_all_broArray(){
		var  hidden = !$("displayAllBroArray").checked;		
		var ids = mygrid1.getAllItemIds(mygrid1.delim).split(mygrid1.delim);
		
		for(var i =0;i<ids.length;i++){
			 var rowids = getRowByUserData(mygrid2,"grid1_rowId",ids[i],"grid1_row_type",1);
			  if(rowids.length == 0){ 
			  	reset_mygrid2_row(ids[i],0);
			  }else{
			  	 for(var j =0;j<rowids.length;j++){
			  	 	mygrid2.setRowHidden(rowids[j],hidden);
			  	 }
			  } 
		}	
		if(hidden){
			var rows =  mygrid1.selectedRows;
			if(rows.length >0) mygrid1.selectRow(rows[rows.length-1],true);
		}		
		
			
		display_weak_rows_info();

}  	
	
	
	
	
function onButtonClick(menuitemId, type) {
	
	    if(isDisplayMonDetail) return false;
 		
	    var data = mygrid1.contextID.split("_");
	    if(menuitemId =='copy'|| menuitemId =='copy_post'|| menuitemId =='copy_move'|| menuitemId =='add_one_month'){
	    	 if(mygrid1.selectedRows.length >1) {alert('只能选择一条记录！');return false;}
	    	 copy_grid1_rowid = data[0];
	    }
	
 		 if(menuitemId =='btnChoseResource'){    
 		 	displayCompagesTree2(1);
 		 }
	 	 if(menuitemId =='btnChoseEdit'){    

 		 	search_adver_cont(1);
 		 }
 		 if(menuitemId =='btnChoseApp'){    
 		 	getSpecificTreeWin();
 		 }
 		 
 		 if(menuitemId =='refrsh_arr'){  
 			var ids = mygrid1.getSelectedRowId().split(","); 
 			 for(var i =0;i<ids.length;i++){
 				var rowId = ids[i];
 				reset_mygrid2_row(rowId,1);
 			 }
  		 }
  		 
 		 
 	
 		
 		 
 		 if(menuitemId =='btnChoseOrderSubCate'){   
 		 	 function close_sss(id){
 		 	 		var ordersubcate_cindex = mygrid1.getColIndexById('ordersubcate');
					set_spec_to_grid1(id,ordersubcate_cindex);
 		 	 }
 		 	showOrderSubCate_prompt_whith_comboBox(close_sss);
 		 }
 		 
 		 
 		 if(menuitemId =='btnChoseArray'){    
 		 	setAutoBroArray();
 		 }    
 		 

  		 if(menuitemId =='btnChosePrice'){    
  		 	
  		 	setAutoPrice(mygrid1.getColIndexById('realPrice'));
  		 	
//  		 	function funcc(v){
//  		 		setAutoPrice2(mygrid1.getColIndexById('realPrice'),v);
//  		 	}
// 		 	showAutoPrice_prompt_whith_comboBox(funcc);
 		 } 
 		 
 	 	 if(menuitemId =='btnChoseFavu'){    
 	 	 	
 	 	 	setAutoPrice(mygrid1.getColIndexById('favace'));
 	 	 	
// 	 	 	function funcc(v){
//  		 		setAutoPrice2(mygrid1.getColIndexById('favace'),v);
//  		 	}
// 		 	showAutoPrice_prompt_whith_comboBox(funcc);
 		 	
 		 	
 		 } 
 		 
  		 if(menuitemId =='btnChoseAppRate'){    
  		 		setAutoPrice(mygrid1.getColIndexById('appRae'));
//   	 	 	function funcc(v){
//  		 		setAutoPrice2(mygrid1.getColIndexById('appRae'),v);
//  		 	}		 	
// 		 	showAutoPrice_prompt_whith_comboBox(funcc);
 		 } 		 	 		 
  		 if(menuitemId =='btnBalance'){    
  		 		setAutoPrice(mygrid1.getColIndexById('balance'));
 		 } 		
 		 
 		 
	   	if(menuitemId =='remove'){    
 		 	removeGrid1NewRow();
 		 }     

	    
	    if( menuitemId =='post_pos' || menuitemId =='post_edit' || menuitemId =='post_arr' || menuitemId =='post_all' || menuitemId =='copy_post'|| menuitemId =='copy_move'|| menuitemId =='add_one_month'){
	    	
	    	if(copy_grid1_rowid ==-1){alert('请选择要复制记录！');return false;}	
	    	
	    	for(var i = 0;i<mygrid1.selectedRows.length;i++){
	    		var stantPrice_cindex = mygrid1.getColIndexById('stantPrice');

	    		var row_id = menuitemId =='copy_post'|| menuitemId == 'copy_move'?addGrid1NewRow(menuitemId,copy_grid1_rowid):mygrid1.selectedRows[i].idd;

	    		
	    		if(copy_grid1_rowid != row_id){
	    			
					if(menuitemId =='post_pos'){
		    	 		var rs_cindex = mygrid1.getColIndexById('resourceName');
		    	 		var len_cindex = mygrid1.getColIndexById('len');
		    	  	 	var rs_txt = mygrid1.cells(copy_grid1_rowid,rs_cindex).getValue();
		    	  	 	var len_txt = mygrid1.cells(copy_grid1_rowid,len_cindex).getValue();
		    	  	 	var resId = mygrid1.getUserData(copy_grid1_rowid,"resourceId");
//		    	  	    var carrierName = mygrid1.getUserData(copy_grid1_rowid,"carrierName");
		    	  	 	var pos = mygrid1.getUserData(copy_grid1_rowid,"pos");
		    	  	 	var stantPrice = mygrid1.cells(copy_grid1_rowid,stantPrice_cindex).getValue();
		    	  	 	
		    	  	 	mygrid1.cells(row_id,rs_cindex).setValue(rs_txt);
		    	  	 	if(len_txt>0){
		    	  	 		mygrid1.cells(row_id,stantPrice_cindex).setValue(stantPrice);
		    	  	 	}
		    	  	 	mygrid1.setUserData(row_id,"resourceId",resId);
		    	  	 	mygrid1.setUserData(row_id,"pos",pos);
		    	  	 	
		    	  	 	reset_mygrid2_row(row_id,1);
		    	  	}
		    	 	if( menuitemId =='post_edit' ){
						var edit_cindex = mygrid1.getColIndexById('edit');
						var len_cindex = mygrid1.getColIndexById('len');
						var matterId = mygrid1.getUserData(copy_grid1_rowid,"matterId");
						var edit_txt = mygrid1.cells(copy_grid1_rowid,edit_cindex).getValue();
						var len_txt = mygrid1.cells(copy_grid1_rowid,len_cindex).getValue();
		    	  	 	var stantPrice = mygrid1.cells(copy_grid1_rowid,stantPrice_cindex).getValue();
		    	  	 	
	
		    	  	 	
		    	  	 	mygrid1.cells(row_id,edit_cindex).setValue(edit_txt);
		    	  	 	mygrid1.cells(row_id,len_cindex).setValue(len_txt);
		    	  	 	mygrid1.cells(row_id,stantPrice_cindex).setValue(stantPrice);
						mygrid1.setUserData(row_id,"matterId",matterId);
						
						reset_mygrid2_row(row_id,1);
				
		    	  	}
		    	 	if(menuitemId =='post_arr'){
						var s_cindex = mygrid1.getColIndexById('start');
						var e_cindex = mygrid1.getColIndexById('end');
						var startDate = mygrid1.cells(copy_grid1_rowid,s_cindex).getValue();
						var endDate = mygrid1.cells(copy_grid1_rowid,e_cindex).getValue();
						mygrid1.cells(row_id,s_cindex).setValue(startDate);
						mygrid1.cells(row_id,e_cindex).setValue(endDate);
						
		    	    	reset_mygrid2_row(row_id,2,copy_grid1_rowid);
		    	  	}
		    	 	if(menuitemId =='post_all'){
		    	 		var apppos_cindex = mygrid1.getColIndexById('apppos');
		    	 		var apppo_id = mygrid1.cells(copy_grid1_rowid,apppos_cindex).getValue();
		    	 		
		    	    	mygrid1.copyRowContent(copy_grid1_rowid,row_id);
		    	    	
		    	    	var matterId = mygrid1.getUserData(copy_grid1_rowid,"matterId");
		    	    	var resourceId = mygrid1.getUserData(copy_grid1_rowid,"resourceId");
		    	    	var pos = mygrid1.getUserData(copy_grid1_rowid,"pos");
		    	    	var id = mygrid1.getUserData(copy_grid1_rowid,"id");
		    	    	
		    	    	mygrid1.setUserData(row_id,"matterId",matterId);
		    	    	mygrid1.setUserData(row_id,"resourceId",resourceId);
		    	    	mygrid1.setUserData(row_id,"pos",pos);
//		    	    	mygrid1.setUserData(row_id,"id",id);
		    	    	if(apppo_id > 0 ){
		    	    		mygrid1.cells(row_id,apppos_cindex).setValue(0);
		    	    	}
		    	    	
		    	    	
		   	    	
		    	    	reset_mygrid2_row(row_id,2,copy_grid1_rowid);
		    	  	}	
		    	  	
		    	 	if(menuitemId =='copy_post' ){

		    	 		var apppos_cindex = mygrid1.getColIndexById('apppos');
		    	 		var apppo_id = mygrid1.cells(copy_grid1_rowid,apppos_cindex).getValue();
		    	 		
		    	    	mygrid1.copyRowContent(copy_grid1_rowid,row_id);
		    	    	
		    	    	var matterId = mygrid1.getUserData(copy_grid1_rowid,"matterId");
		    	    	var resourceId = mygrid1.getUserData(copy_grid1_rowid,"resourceId");
		    	    	var pos = mygrid1.getUserData(copy_grid1_rowid,"pos");
		    	    	var id = mygrid1.getUserData(copy_grid1_rowid,"id");
		    	    	
		    	    	
		    	    	mygrid1.setUserData(row_id,"matterId",matterId);
		    	    	mygrid1.setUserData(row_id,"resourceId",resourceId);
		    	    	mygrid1.setUserData(row_id,"pos",pos);
//		    	    	mygrid1.setUserData(row_id,"id",id);
		    	    	
		    	    	if(apppo_id > 0 ){
		    	    		mygrid1.cells(row_id,apppos_cindex).setValue(0);
		    	    	}
	
		    	    	reset_mygrid2_row(row_id,2,copy_grid1_rowid);
		    	    	
//		    	    	alert(11)
		    	    	var row = mygrid1.getRowById(row_id); 
		    	    	mygrid1.selectRow(row,true);
		    	    	
		    	  	}	
		    	  	
					if(menuitemId =='copy_move'){

						var s_cindex = mygrid1.getColIndexById('start');
						var e_cindex = mygrid1.getColIndexById('end');
//		    	    	mygrid1.copyRowContent(copy_grid1_rowid,row_id); 
		    	    	var frRow = mygrid1.getRowById(copy_grid1_rowid)
						for (var i = 0; i < frRow.cells.length; i++){
							if(i != s_cindex && i != e_cindex){
								mygrid1.cells(row_id, i).setValue(mygrid1.cells(copy_grid1_rowid, i).getValue());
							}
						}	    	    	
		    	    	
		    	    	
		    	    	var matterId = mygrid1.getUserData(copy_grid1_rowid,"matterId");
		    	    	var resourceId = mygrid1.getUserData(copy_grid1_rowid,"resourceId");
//		    	    	var resourceSortId = mygrid1.getUserData(copy_grid1_rowid,"resourceSortId");
		    	    	var pos = mygrid1.getUserData(copy_grid1_rowid,"pos");
		    	    	var id = mygrid1.getUserData(copy_grid1_rowid,"id");
		    	    	
		    	    	
		    	    	mygrid1.setUserData(row_id,"matterId",matterId);
		    	    	mygrid1.setUserData(row_id,"resourceId",resourceId);
//		    	    	mygrid1.setUserData(row_id,"resourceSortId",resourceSortId);
		    	    	mygrid1.setUserData(row_id,"pos",pos);
//		    	    	mygrid1.setUserData(row_id,"id",id);
		    	    	if(apppo_id > 0 ){
		    	    		mygrid1.cells(row_id,apppos_cindex).setValue(0);
		    	    	}

		    	    	reset_mygrid2_row(row_id,3,copy_grid1_rowid);
		    	  	}		    	  	
		    	  		    	  	

	    	}else{
	    			if(menuitemId =='add_one_month'){reset_mygrid2_row(row_id,5);}		    		    	  	
	    		}
	    	}
	    	
	    	copy_grid1_rowid = -1;
	    }	    
	    
	    mygrid1.setRowTextStyle(data[0], "color:" + menuitemId.split("_")[1]);
	    return true;
	}	
	
function doOnRowSelectedGrid1(rid,cellIndex){
	
//	alert(rid)
//	    var sel_id = mygrid1.getSelectedRowId(); 
//	    var row = mygrid1.getRowById(sel_id);
//	    alert(row.className)
	
//	    var rows = mygrid1.selectedRows;
//		mygrid2.unmarkAll();
//		mygrid2._HideSelection();
////		getOneResourceMonthInfos(rid,0,true,mygrid1.getRowsNum(),0,[]); 
//	    var grid2_row_ids = getRowByUserData(mygrid2,"grid1_rowId",rid);
// 		hidden_mygrid1(rid);
//	    if(grid2_row_ids.length == 0){reset_mygrid2_row(rid,0); }	
  

//	alert(cellIndex)
//	alert(c)
//	alert(d)

	    showGrid2ByBlockSelectedGrid1(); 
	    
//	    var rowIndex = mygrid1.getRowIndex(rid);
//	    setGrid1_nat(null,rowIndex);

}	



	
	
function OnEditCellGrid1(state,rowId,cellIndex){
	


		if(this.getColumnId(cellIndex)=='sumTime' || this.getColumnId(cellIndex)=='sumPay'){
			return false;
		}else{
//			columnIds = "resourceName,edit,len,apppos,start,end,stantPrice,realPrice,favace,appRae,sumTime,sumPay"
			var wasChanged = this.cells(rowId,cellIndex).wasChanged();

			if(this.getColumnId(cellIndex)=='resourceName'){
				 if(isDisplayMonDetail)return false; 
				 if(state == 0) displayCompagesTree2(1,wasChanged);return false; 
			}else if(this.getColumnId(cellIndex)=='edit'){
				if(isDisplayMonDetail)return false; 
				 if(state == 0) search_adver_cont(1,wasChanged);return false;  
			}else if(this.getColumnId(cellIndex)=='realPrice'){
				if(isDisplayMonDetail)return false; 
				if(orderCategoryMain == 0) return false;
				if(state == 2) reset_grid1_sumPay(rowId,cellIndex,wasChanged);return true;
			}else if(this.getColumnId(cellIndex)=='stantPrice' || this.getColumnId(cellIndex)=='len'){
				return false;
//				if(state == 2) reset_grid1_sumPay(rowId,cellIndex,wasChanged,calculateauto);return true;
			}else if(this.getColumnId(cellIndex)=='favace'){
				if(isDisplayMonDetail)return false; 
				if(orderCategoryMain == 0) return false;
				if(state == 2) reset_grid1_sumPay(rowId,cellIndex,wasChanged);return true;
			}else if(this.getColumnId(cellIndex)=='appRae'){
				if(isDisplayMonDetail)return false; 
				if(orderCategoryMain == 0) return false;
				if(state == 2) reset_grid1_sumPay(rowId,cellIndex,wasChanged);return true;
			}else if(this.getColumnId(cellIndex)=='balance'){
				if(orderCategoryMain == 0) return false;
				if(state == 2) reset_grid1_sumPay(rowId,cellIndex,wasChanged);return true;
			}else if(this.getColumnId(cellIndex)=='start' || this.getColumnId(cellIndex)=='end'){
				if(state == 2 && wasChanged)reset_mygrid2_row(rowId,1);return true;	
			}else if(this.getColumnId(cellIndex)=='ordersubcate'){
				if(isDisplayMonDetail)return false; 
				if(state == 2 && wasChanged){reset_grid1_sumPay(rowId,cellIndex,wasChanged);return true;}
			}else if(this.getColumnId(cellIndex)=='apppos'){
				if(isDisplayMonDetail)return false; 
				if(state == 2 && wasChanged)reset_mygrid2_row(rowId,1);return true;	
			}
			


			else{
				return true;
			}
			
		}
		
		
	}
	
	function onBlockSelectedGrid1(){
		this.setActive(true);
		for (var i=this._selectionArea.LeftTopRow; i<=this._selectionArea.RightBottomRow; i++) {
			for (var j=this._selectionArea.LeftTopCol; j<=this._selectionArea.RightBottomCol; j++) {
                var cell =  this.cells2(i,j);
                this.selectRow(i, false, true, false);
			}
		}
		this._HideSelection();
		showGrid2ByBlockSelectedGrid1();
	}	
	
	
	function showGrid2ByBlockSelectedGrid1(){
		var map = new HashMap();
		var rows = mygrid1.selectedRows;
		
		//设置导航
		setGrid1_nat2(rows);
  

		for(var i = 0;i<rows.length;i++){
			var row_id =  rows[i].idd;
			map.put(row_id,row_id);
		}
	
 
       

		if(mygrid2.getRowsNum()>0){
			mygrid2.unmarkAll();
			mygrid2._HideSelection();
		}

 
       
		var rowCount = mygrid1.getRowsNum();


		var ids = mygrid2.getAllItemIds(mygrid2.delim).split(mygrid2.delim);
		
	
		
		for(var i = 0;i<ids.length;i++){
			mygrid2.setRowHidden(ids[i],true);
		}		

	
		
		for(var i = 0;i<rowCount;i++){
			var row_id = mygrid1.getRowId(i);
			


			if(map.contains(row_id)){

				
				var grid2_row_ids = getRowByUserData(mygrid2,"grid1_rowId",row_id);

				 
				 var row_idd = row_id;
				 
	
				
				if(grid2_row_ids.length == 0){
					
					//备份排期
					 
					function backGrid2(row_id_dd){
						
//						alert("row_id_dd>>"+row_id_dd+"    row_idd>>"+row_idd)
						
						 var details = orderBackUp.orderDetailsObj;
						 
						 if(details != null){
							 for(var i =0;i< details.length;i++){
								 var detail = details[i];
								 var detailId = detail.id;
								 
//								 alert(row_idd+"_"+ detailId)
								 
								 if(detailId == row_id_dd){
									 var orderDayInfos = getOrderDayInfos(row_id_dd,detail);  
//									 alert("row_id  5 >>"+detailId)
//									 alert("backGrid2 orderDayInfos.length"+orderDayInfos.length);  
									 details[i].orderDayInfos = orderDayInfos;
								 }
							 }
						 }


					}
					
					
					 
					reset_mygrid2_row(row_id,0,null,null,backGrid2); 
					
				
	
				};
				
				for(var j = 0;j<grid2_row_ids.length;j++){
					var grid2_row_id = grid2_row_ids[j];
					var type = mygrid2.getUserData(grid2_row_id,"grid1_row_type");
					
					mygrid2.setRowHidden(grid2_row_ids[j],false);
                    
					if(type == 0){
						if(displayWeek){
							mygrid2.setRowHidden(grid2_row_ids[j],false);
						}else{
							mygrid2.setRowHidden(grid2_row_ids[j],true);
						}
					}else{
						mygrid2.setRowHidden(grid2_row_ids[j],false);
					}				
					

				}
			}
	
		}		
	
		
		
	}
	

//	function doOnRowSelectedGrid1(rid,cellIndex){
//		   
//		mygrid2.unmarkAll();
//		mygrid2._HideSelection();
////		getOneResourceMonthInfos(rid,0,true,mygrid1.getRowsNum(),0,[]); 
//	    var grid2_row_ids = getRowByUserData(mygrid2,"grid1_rowId",rid);
// 		hidden_mygrid1(rid);
// 	
//	    if(grid2_row_ids.length == 0){reset_mygrid2_row(rid,0); }	
//
//}	
	

	
	
 function initGrid1(){

	menu = new dhtmlXMenuObject("", "dhx_web");
	menu.setIconsPath(ctxPath+"scripts/dhtml/2.6/dhtmlxMenu/codebase/imgs/");
	menu.renderAsContextMenu();
//	menu.attachEvent("onClick", onButtonClick)
	menu.loadXMLString(build_grid1_menuStr());  
	menu.attachEvent("onClick", onButtonClick)	
//	menu.attachEvent("onRadioClick", onRadioClick)	

//	function onShow(){
//		if(isDisplayMonDetail) return false;
//	}
//	menu.attachEvent("onShow", onShow);	



//	if( menu.getRadioChecked("menu_ext_radio") =='menu_ext_radio_yes')
//   (mode, nextToId, pos, itemId, itemText, group, state, disabled) 
//    menu.addRadioButton("child", "menu_ext_radio", 0, "menu_ext_radio_yes", "是", "color");
//    menu.addRadioButton("child", "menu_ext_radio", 1, "menu_ext_radio_no", "否", "color", true);


 	var wd = $("gridbox1").offsetWidth;
	mygrid1 = new dhtmlXGridObject('gridbox1');
	mygrid1.enableContextMenu(menu);
	

		
	mygrid1.setImagePath(ctxPath+"scripts/dhtml/2.6/dhtmlxGrid/codebase/imgs/");
	mygrid1.setHeader(",位置,广告版本,长度,指定,开始时间,结束时间,类别,刊例价,销售价,折扣,加收,补差,次数,应收");
	var columnIds = "cur,resourceName,edit,len,apppos,start,end,ordersubcate,stantPrice,realPrice,favace,appRae,balance,sumTime,sumPay"
	mygrid1.setColumnIds(columnIds);
	var ss =[wd*0.01,wd*0.13,wd*0.18,wd*0.04,wd*0.05,wd*0.08,wd*0.08,wd*0.06,wd*0.06,wd*0.06,wd*0.04,wd*0.04,wd*0.05,wd*0.03,wd*0.08];
	mygrid1.setInitWidths(ss.join(","));

	mygrid1.setColAlign("left,left,left,center,center,center,center,center,right,right,right,right,right,right,right");
	mygrid1.setColTypes("ed,ed,ed,ed,coro,calendar,calendar,coro,ed,ed,ed,ed,ed,ed,ed");
	mygrid1.setColSorting("str,str,str");
	
	mygrid1.enableMultiselect(true); // false by default
	mygrid1.enableBlockSelection(true); // true|false 
//	mygrid1.setEditable(true);
	

	mygrid1.attachEvent("onRowSelect", doOnRowSelectedGrid1);
	mygrid1.attachEvent("OnEditCell", OnEditCellGrid1);
	mygrid1.attachEvent("onBlockSelected", onBlockSelectedGrid1);

	
//	this.cell.wasChanged=true;
	mygrid1.attachEvent("onCellChanged", OnCellChangedGrid1);
	
	
	
	function removeByValue(arr, val) {
		  for(var i=0; i<arr.length; i++) {
		    if(arr[i] == val) {
		      arr.splice(i, 1);
		      break;
		    }
		  }
		}

	function onSelectStateChanged(afinal,initial){
//		alert(' 1589 afinal>>'+afinal+'    initial>>>>'+initial)
		var removeId = 0;
	    if(initial){
//			    	alert(' 1602 afinal>>'+afinal+'    initial>>>>'+initial)
			    		
			    	if(afinal){
				    	if(initial.length>afinal.length){
				    			var before = initial.split(",");
		
				    			 var arr =  initial.split(",");
				    			 after =  afinal.split(",");
		//		    				alert('arr'+arr)
					    		 for(var i=0; i<arr.length; i++) {
					    				removeByValue(before,after[i])
					    		 }
					    		 removeId = before[0];
					    		
				    	}
			    	}else{
			    		var before = initial.split(",");
			    		 removeId = before[0];
			    	}

	    	}
	   
//	    alert(removeId);
	    
	    if(removeId >0){
	    	var row_id = removeId;
			var grid2_row_ids = getRowByUserData(mygrid2,"grid1_rowId",row_id);
			for(var j = 0;j<grid2_row_ids.length;j++){
				var grid2_row_id = grid2_row_ids[j];
				mygrid2.setRowHidden(grid2_row_ids[j],true);
			} 	
	    }
	}

	
    mygrid1.attachEvent("onSelectStateChanged", onSelectStateChanged);
//    mygrid1.attachEvent("onKeyPress", mygrid1OnKeyPressed);
//    mygrid1.setOnRightClick(unSelectGrid1);
    
    
//    mygrid1.setOnRowSelectHandler = function(func,anyClick){
//    	alert(anyClick)
//    	mygrid1.dhx_attachEvent("onRowSelect",func);
//    	mygrid1._chRRS=(!convertStringToBoolean(anyClick));
//    }
    
    
	
	mygrid1.enableAlterCss("even","uneven");
	

	getSpecCmd('apppos_cindex');
	getSpecCmd('ordersubcate_cindex');
	 
	mygrid1.init();
	
//	alert(mygrid1.setOnRowSelectHandler)
//	mygrid1.setOnRowSelectHandler(doOnRowSelectedGrid1,true);

 }

 
 
 function OnCellChangedGrid1(rowId,cellIndex,val){
	 var cell = this.cells(rowId,cellIndex);
	 var row = this.getRowById(rowId);
	 row.childNodes[cellIndex].wasChanged=true;
 }
 
 
 
 function mygrid2OnKeyPressed(keyCode,ctrlKey,shiftKey,ev){
		
     
		if(ctrlKey||shiftKey) return false;

		if (this._selectionArea!= null) {
			for (var i=this._selectionArea.LeftTopRow; i<=this._selectionArea.RightBottomRow; i++) {
				for (var j=this._selectionArea.LeftTopCol; j<=this._selectionArea.RightBottomCol; j++) {
					
//					alert(i+'_'+j);
					
	                var cell =  this.cells2(i,j);
	                var td =  cell.cell;
	       
	                td._cellIndex = j;
				 	var event ={keyCode:keyCode,ctrlKey:ctrlKey,shiftKey:shiftKey,target:td,cell:cell}
				 	mygrid2onKeypressClick(event);
				}
			}

			this._HideSelection();

	    }else if (this.markedRowsArr.length >1) {
	    	
	    	var marked = this.getMarked();
	    	for(var ri = 0; ri < marked.length; ri++){
	    		var rowCells = marked[ri];
	    		for(var ci = 0; ci < rowCells.length; ci++){
	    			var rid = rowCells[0]
	    			var cindex = rowCells[1]
	    			var cell =  this.cells(rid,cindex);
	    			var td =  cell.cell;
	    			td._cellIndex = cindex;
					var event ={keyCode:keyCode,ctrlKey:ctrlKey,shiftKey:shiftKey,target:td,cell:cell};
					mygrid2onKeypressClick(event);	    			
	    		}
	    		
	    	}

			this.unmarkAll();

	    } 
	    
	    else{
			var rowId = this.lastMarkedRow;
			var cellIndex = this.lastMarkedColumn;
			var cell = this.cells(rowId,cellIndex);
			var row = this.getRowById(rowId);
			var td = cell.cell;
		
			td._cellIndex = cellIndex;
		 	var event ={keyCode:keyCode,ctrlKey:ctrlKey,shiftKey:shiftKey,target:td,cell:cell}
		 	mygrid2onKeypressClick(event);
	
		 
		 	if(!shiftKey.button){ 
	            cell.parentNode = row;
	            cell._cellIndex = cellIndex;
	 
				var z = getNextCell(cell, 1); 
			
				if (z){
					this.selectCell(z.parentNode, z._cellIndex, (this.row != z.parentNode), false, true);
				};
			
				
			}

	    } 

}
 
 
 
 function mygrid2onRightClick(rowId,cellIndex,ev){
//		var row = this.getRowById(rowId);
//		var cell = this.cells(rowId,cellIndex);
	
	
	
//		var td = cell.cell;
   this.unmarkAll();	
//     if(cellIndex < 4){	
//			var x= ev.pageX;
//			var y = ev.pageY;
////			this.unmarkAll();
//		   this.mark(rowId,cellIndex,true);
//        this._ctmndx.showContextMenu(x,y);
//        return false;
//     }else{
//     	this._ctmndx.hideContextMenu();
//     }
     
	 	
	 	
		if (this._selectionArea!= null) {
			for (var i=this._selectionArea.LeftTopRow; i<=this._selectionArea.RightBottomRow; i++) {
				for (var j=this._selectionArea.LeftTopCol; j<=this._selectionArea.RightBottomCol; j++) {
	                var cell =  this.cells2(i,j);
	                var td =  cell.cell;
	                td._cellIndex = j;
//	                this.mark(rowId,cellIndex,true);
				 	var event ={keyCode:48,ctrlKey:false,shiftKey:false,target:td,button:2,cell:cell};
				 	mygrid2onKeypressClick(event);
				}
			}
		
			this._HideSelection();
	    } else{
		 	this.mark(rowId,cellIndex,true);
		 	var cell =  this.cells(rowId,cellIndex);
		 	var td = cell.cell;
		 	td._cellIndex = cellIndex;
		
		 	this.selectCell(this.getRowById(rowId), cellIndex, false, false, true);
		 	var event ={keyCode:48,ctrlKey:false,shiftKey:false,target:td,button:2,cell:cell};
		 	mygrid2onKeypressClick(event);
	    }
}	

 
 function mygrid2onLeftClick(parentNodeId,_cellIndex,ev){
//		 this.selectCell(parentNodeId, _cellIndex, false, false, true);
//		alert(_cellIndex)
//		this.unmarkAll();
//	this._HideSelection();
//		if (!this.isActive) this.setActive(true);
//		 this.mark(parentNodeId,_cellIndex,true);
//	 this.setActive(true);
		
	
  
		 this._HideSelection();
      var cell =  this.cells(parentNodeId,_cellIndex);
      var td =  cell.cell;
      td._cellIndex = _cellIndex;
//      var event ={keyCode:48,ctrlKey:false,shiftKey:false,target:td,button:2,cell:cell};
//	  this.selectCell(parentNodeId, _cellIndex, false, false, true);
	  var event ={keyCode:48,ctrlKey:false,shiftKey:false,button:0,target:td,cell:cell}		
	  mygrid2onKeypressClick(event);
}
 
 
	function mygrid2onBlockSelected(cell){
	
		this.unmarkAll();
		this.setActive(true);
//		mygrid1.setActive(false);
//		mygrid1.uncheckAll();
	} 
 
 function onButtonClickMenu2(menuitemId, type){
		
     if(menuitemId =='remove_cur_month_array'){    
		 	var marked = mygrid2.getMarked();
			for(var ri = 0; ri < marked.length; ri++){
    		var rowCells = marked[ri];
    		for(var ci = 0; ci < rowCells.length; ci++){
    			var rowId = rowCells[0];
    			var cindex = rowCells[1];
 		 		mygrid2.deleteRow(rowId);
 		 		
    		}
    	}			 	

		 }else if(menuitemId =='clean_cur_month_array')	{
		 	var marked = mygrid2.getMarked();
		for(var ri = 0; ri < marked.length; ri++){
    		var rowCells = marked[ri];
    		for(var ci = 0; ci < rowCells.length; ci++){
    			var rowId = rowCells[0]
    			var cindex = rowCells[1]
 		 		mygrid2.deleteRow(rowId);
// 		 		this._ctmndx.hideContextMenu();
    		}
    		
    	}		
		 }
		 
//		 this._ctmndx.hideContextMenu();
	 
}
 
function initGrid2(){
//	var menu2 = new dhtmlXMenuObject("", "dhx_web");
//	menu2.setIconsPath(ctxPath+"scripts/dhtml/2.6/dhtmlxMenu/codebase/imgs/");
//	menu2.renderAsContextMenu();
//	menu2.loadXMLString(build_grid2_menuStr());  
//	menu2.attachEvent("onClick", onButtonClickMenu2)		

	var wd = $("gridbox2").offsetWidth;
	mygrid2 = new dhtmlXGridObject('gridbox2');
//	mygrid2.enableContextMenu(menu2);
	mygrid2.selMultiRows = true;
//	mygrid2.setImagePath(ctxPath+"image/grid/");
	mygrid2.setImagePath(ctxPath+"scripts/dhtml/2.6/dhtmlxGrid/codebase/imgs/");
    mygrid2.enableMultiselect(true);
    mygrid2.setEditable(true);

	var wd = $("gridbox2").offsetWidth;
	var flds = "版本,位置,年,月,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,次,应收,grid1_id";
	mygrid2.setHeader(flds);

	var columnIds = "edit,pos,year,month," 
					+"dayTimes[1],dayTimes[2],dayTimes[3],dayTimes[4],dayTimes[5],"
					+"dayTimes[6],dayTimes[7],dayTimes[8],dayTimes[9],dayTimes[10],"
					+"dayTimes[11],dayTimes[12],dayTimes[13],dayTimes[14],dayTimes[15],"
					+"dayTimes[16],dayTimes[17],dayTimes[18],dayTimes[19],dayTimes[20],"
					+"dayTimes[21],dayTimes[22],dayTimes[23],dayTimes[24],dayTimes[25],"
					+"dayTimes[26],dayTimes[27],dayTimes[28],dayTimes[29],dayTimes[30],dayTimes[31],"
					+"times,realPrice,grid1_id";
	mygrid2.setColumnIds(columnIds);

//	var dw = wd*0.026;  //2.6*31=80.6
	var dw = wd*0.025;  //2.6*31=80.6
	var dw2 = wd*0.03;  //3*2 = 6
//	var dw3 = 9+4.8;  
//		80.6 + 6 + 5 = 91.6  8.4
//	var ss =[3,4.8,3.5,2.5,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw2,dw2,0];
//	var ss =[wd*0.03,wd*0.048,wd*0.035,wd*0.025,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw2,dw2,150];
//	var ss =[wd*0.061,wd*0.048,wd*0.035,wd*0.025,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw2,dw2,0];
	var ss =[wd*0.061,wd*0.078,wd*0.035,wd*0.025,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw2,0,0];
	
	mygrid2.setInitWidths(ss.join(","));
	mygrid2.setColAlign("left,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,right,right,left")
	mygrid2.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
//	mygrid2.setOnEditCellHandler(doOnEditCell);
    mygrid2.setColSorting("str,str,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int") ;
//    mygrid2.sortField(37,false);
//    mygrid2.sortRows(37,"str","des");
//    mygrid2.setSortImgState(true,37,"ASC"); 
//	mygrid2.setEditable(true);

//	mygrid2.enableRowspan(true);
//	mygrid2.enableColSpan(true);
	mygrid2.enableMarkedCells(true); // true|false 
//	mygrid2.enableMercyDrag(true); // true|false 
	mygrid2.enableBlockSelection(true); // true|false 
//	mygrid2.enableLightMouseNavigation(true); // true|false 
	mygrid2.enableStableSorting(true); // true|false 
	mygrid2.sortRows(37,"int","asc");    // sort by the sibling column
	mygrid2.setColumnHidden(37,true);
	mygrid2.setColumnHidden(36,true);
	
//	mygrid2.enableEditEvents(true);
//	mygrid2.setOnEditCellHandler(onEditCellHandler);
//	alert(mygrid2.setOnRowSelectHandler)
//	mygrid2.setOnRowSelectHandler(onRowSelectHandler, 1);
	

    var ss_header = "BORDER-RIGHT: #000000 2px solid; 1px solid;  BORDER-BOTTOM: #000000 2px solid;  BORDER-TOP: #000000 2px solid;TEXT-ALIGN: center;"
    var ss_grid = "BORDER-RIGHT: #000000 1px solid; 1px solid; BORDER-BOTTOM: #000000 1px solid; TEXT-ALIGN: center;"
    var ss_selCell ="-moz-opacity: 0.5;filter: alpha(opacity = 50);background-color:yellow;opacity:0.5;border: 1px dotted black;"
//      var ss_selCell ="BORDER-RIGHT: #FF0000 1px solid;BORDER-TOP: #FF0000 1px solid;BORDER-LEFT: #FF0000 2px solid; BORDER-BOTTOM: #FF0000 2px solid; background-color:white;";
     var ss_mark ="BORDER-RIGHT: #FF0000 1px solid;BORDER-TOP: #FF0000 1px solid;BORDER-LEFT: #FF0000 2px solid; BORDER-BOTTOM: #FF0000 2px solid;";
	mygrid2.setStyle(ss_header,ss_grid,ss_selCell,ss_mark);

//	 function unSelectGrid1(){
//		 var rows = mygrid1.getSelectedId();
//		 alert(1113); alert(rows);
//	 }
//	 
//		function onRowSelectHandler(parentNodeId,_cellIndex,ev){
//			alert(111);
//		}
	
//	function doOnRowSelectedGrid2(r1){
//		alert(222222);alert(r1);
//	}
		
	mygrid2.attachEvent("onBlockSelected", mygrid2onBlockSelected);
	mygrid2.attachEvent("onBeforeSelect",function(rowId,psid){return false }); 	
//	mygrid2.setOnRightClick(unSelectGrid1);
//	mygrid2.attachEvent("onRowSelect", doOnRowSelectedGrid2);
	

	mygrid2.customGroupFormat = function(text, count) {
//		return false
	    return "Grouped by " + text + ", there are " + count + " related records";
	};
	
	
	
	
 	
 	
 	
 	
// 	function onLeftClick2(parentNodeId,_cellIndex,ev){
// 		alert(11)
// 	}
    mygrid2.attachEvent("onKeyPress", mygrid2OnKeyPressed);
    mygrid2.attachEvent("onRightClick", mygrid2onRightClick);
//    mygrid2.attachEvent("onLeftClick", mygrid2onLeftClick2);

//    function onRowDblClicked(rowId,_cellIndex){
// 
//    }
//    
//    mygrid2.attachEvent("onRowDblClicked", onRowDblClicked);
    
//    function onbeforeactivate(){
//    	alert(1)
//    }
//     mygrid2.attachEvent("onbeforeactivate", onbeforeactivate);
    
//    mygrid2.setTabOrder("4,5,6,7,8,9");
    
    
//    function onRowDblClicked(){
////    	mygrid2.setActive(true);
////alert(this.isActive)
//    }
//    mygrid2.attachEvent("onRowDblClicked", onRowDblClicked);
    
	mygrid2.init();	
	
	
	
//	mygrid2.setColumnHidden(37,true);
//	mygrid2.enableRowspan(true);
//	mygrid2.enableRowspan();
	
//	 mygrid2.customGroupFormat = function(text, count) {
//       return "Record " + text + "; containing " + count + " related text segments";
//   };
//	mygrid2.setSkin("dhx_skyblue");
	mygrid2.setSizes();

	
	
}




function setSelectGridChecked(){
	
  if(isDisplayMonDetail) return false;
	var selectedRowsCount = mygrid1.selectedRows.length;
	if(selectedRowsCount == 0){
//		if(compagesDiaWin){
//					if(!compagesDiaWin.hidden){
//						return 	true;
//					}
//		}else{
//			 Ext.MessageBox.alert('系统提示','请选择需要处理的记录!',function(){}); 
//			 return false;   
//		}
			 Ext.MessageBox.alert('系统提示','请选择需要处理的记录!',function(){}); 
			 return false;  
	}else{
		return true;
	}
}



function getAllResourceMonthInfos(){
	var  hidden = !$("displayAllBroArray").checked;	
	
	mygrid2.unmarkAll();
	mygrid2._HideSelection();
	var rowCount = mygrid1.getRowsNum();

	for(var i = 0;i<rowCount;i++){
		var row_id = mygrid1.getRowId(i);
		reset_mygrid2_row(row_id,1);
//		var bak_arr = get_bak_arr_by_grid1rowid(row_id);	
//		var rowId2s =  getRowByUserData(mygrid2,"grid1_rowId",row_id);		
//		for (var j = 0; j < rowId2s.length; j++){
//			mygrid2.deleteRow(rowId2s[j]);
//		}		
//
//		getOneResourceMonthInfos(row_id,0,true,rowCount,i,bak_arr);
	}
	
//	mygrid2.setActive(true);	

}

	
		 		

function getOneResourceMonthInfos(row_id,cindex,isMore,rowCount,rowIndex,bak_arr,callBak){
    
	var orderDetail_obj =(new OrderDetail()).obj;
//	var row_id = mygrid1.getRowId(rowIndex);
	var orderDetail_id = mygrid1.getUserData(row_id,"id");
	

	
	var resourceId = mygrid1.getUserData(row_id,"resourceId");
	
	if(resourceId == null || resourceId =='null' || resourceId == 0) return false;

	var matterId = mygrid1.getUserData(row_id,"matterId");
	

	
	var pos = mygrid1.getUserData(row_id,"pos");
	var orderDetailStates = 0;
	var s_cindex = mygrid1.getColIndexById('start');
	var e_cindex = mygrid1.getColIndexById('end');
	var edit_cindex = mygrid1.getColIndexById('edit');
	var len_cindex = mygrid1.getColIndexById('len');
	var apppos_cindex = mygrid1.getColIndexById('apppos');
//	var isMonMoney_cindex = mygrid1.getColIndexById('isMonMoney'); 
	
	
	var resourceSpecific_value= mygrid1.cells(row_id,apppos_cindex).getValue(); 
	var appposCmd = mygrid1.getCombo(apppos_cindex);
	var resourceSpecificId = 0;
	if(resourceSpecific_value > 0){
		resourceSpecificId = resourceSpecific_value;
	}else{
		 resourceSpecificId = appposCmd.getKey(resourceSpecific_value);
	}

	var specificValue = appposCmd.positions[resourceSpecificId];
	specificValue = specificValue==null||specificValue=='0'?'':specificValue;


		
	 var startDate =mygrid1.cells(row_id,s_cindex).getValue();
	if(startDate == ''){
		 startDate = startDate1
		 mygrid1.cells(row_id,s_cindex).setValue(getFormatDay(startDate,'y/m/d'))
	}else{
		startDate = getFormatDay(startDate,'ymd')*1;
	}

	startDate = (startDate+'').substring(0,6)+"01";
	var endDate = mygrid1.cells(row_id,e_cindex).getValue();
	
	if(endDate == ''){
		endDate = getFormatDay(endDate1,'y-m-d'); 
		 mygrid1.cells(row_id,e_cindex).setValue(getFormatDay(endDate1,'y/m/d'))
	}else{
		endDate = getFormatDay(endDate,'y-m-d');
	}
	
//	 endDate = myUtils.parseDate(endDate,'y-m-d');	
	 endDate = new Date(Date.parse(endDate));
	
    
	endDate = new Date(endDate.getFullYear(),endDate.getMonth(),endDate.getMonthDays(), 0, 0, 0); 
	endDate = myUtils.formatDateSimple(endDate,''); 

	var edit = mygrid1.cells(row_id,edit_cindex).getValue();
	var adLength = mygrid1.cells(row_id,len_cindex).getValue();

//	alert(startDate)
//	alert(endDate)
	
	
   
	orderDetail_obj.id = orderDetail_id;
	orderDetail_obj.publishStartDate = startDate;
	orderDetail_obj.publishEndDate = endDate;
	orderDetail_obj.resourceInfoId = resourceId;
	orderDetail_obj.specific.position = specificValue == null?'':specificValue;
	orderDetail_obj.compagesId = 0;
//	orderDetail_obj.version = order_year;
	orderDetail_obj.orderDetailStates = orderDetailStates;
//	orderDetail_obj.isMonMoney = isMonMoney;
	orderDetail_obj.resourceSortId = getValueFromStoreById(toolbar.getComponent("customerName_for_paraArray"),"customerCategoryId");

	
//	alert(orderDetail_obj.resourceSortId)


	var getMonthsFun = function(objs){
//		console.log(objs)
//    	parent.backup_cur_info(null,null,objs);	
//		if(!isMore) mygrid2.clearAll();



		for(var i = 0;i<objs.length;i++){
           
			var month_obj = objs[i];
			month_obj.grid1_rowId = row_id;
	  		month_obj.pos = pos;
	  		month_obj.edit = edit;
	  		month_obj.adLength = adLength;
	  		month_obj.matterId = matterId;
//	  		month_obj.isMonMoney = isMonMoney;
	  		
	  		
//	        alert('2217 row_id>>>'+row_id)	
	  		
	  		var year = month_obj.year;
	  		var month = month_obj.month;
	  		month = month<10?'0'+month:month;
	  		var key = 	year +''+ month;
//	  		if(matterId > 0){
	  			month_obj.bak_arr = bak_arr;
	  			
	  			
	  			//是否从数据库读取
	  			var isFromDB = (bak_arr.length ==0);

	  			if(bak_arr.length > 0){
		  			var used_months = getMonthFrom_bak_arr(bak_arr);
		  			 max = Math.max.apply(Math,used_months);
					 min = Math.min.apply(Math,used_months); 
		  			 var new_start_month = (''+startDate).substring(0,6);
		  			 var new_end_month = (''+endDate).substring(0,6);
//                   alert(used_months+"  "+key)
//				  alert(used_months.contains(key))
		  			//只加有排期的月份
		  			if(used_months.contains(key)){
		  				createMonthRow(month_obj,isFromDB);
		  			}else{
//		  				alert(new_start_month)
//		  				alert(key)
		  				if(new_start_month*1 < min*1 || new_end_month*1 > max*1){
		  					createMonthRow(month_obj,isFromDB);
		  				}
		  			}
	  			}else{
	  				createMonthRow(month_obj,isFromDB);
	  			}

	  			
//	  		}
//			  if((rowCount-1) == rowIndex && i == objs.length -1 ) mygrid2.groupBy(1);
	  			
	  			
//	  			if(month_obj.bak_arr.length == 0){
//	  				alert('abcdedg')
//	  			}
//	  			alert('month_obj.grid1_rowId>>>'+month_obj.grid1_rowId)
	  			
	  			var grid1_row_id = month_obj.grid1_rowId;
	  			var ordersubcate_index = mygrid1.getColIndexById('ordersubcate');
	  			var calculateauto_key = mygrid1.cells(grid1_row_id,ordersubcate_index).getValue();
				var command = mygrid1.getCombo(ordersubcate_index); 
				var calculateauto = command.calculateauto[calculateauto_key];
	  			
	  			reset_grid2_month_sumTimes(grid1_row_id);
	  			
				reset_grid1_sumTimes(grid1_row_id);

				reset_grid1_sumPay(grid1_row_id,0,true,calculateauto);
									
				reset_grid1_date(grid1_row_id);
									
				reset_grid1_totalTime();
	  			
		}
		
		mygrid2.sortRows(37,"int","asc");    // sort by the sibling column
		
		if((rowCount-1) == rowIndex){
//			mygrid2.groupBy(37);
			 mygrid2.setColumnHidden(37,true);
			
//			 mygrid2.groupBy(0);
//			 mygrid2.setColspan(1,0,1);
//             mygrid2.setRowspan(1,0,0);
//			mygrid2.setRowspan(1, 0 ,mygrid2.getRowsNum());
//			 mygrid2.forEachRow(function(id){               	// for each row in the grid
//			 					
//									mygrid2.setRowspan(id, 1,5);
//				 })
		}
		 
	
		 
		mygrid2.setSizes();
		
		if(callBak) callBak(row_id);
	
    }	
	
	orderDetail.getMonthInfos(orderDetail_obj,getMonthsFun);
}


function hidden_mygrid1(rid){ 
	

	
	if(!$("displayAllBroArray").checked){
			
		    var rowId2s =  getRowByUserData(mygrid2,"grid1_rowId",rid);	
			var ids = mygrid2.getAllItemIds(mygrid2.delim).split(mygrid2.delim);
			
			for(var i = 0;i<ids.length;i++){
				mygrid2.setRowHidden(ids[i],true);
			}
			
			for(var i = 0;i<rowId2s.length;i++){
				if(displayWeek){
					mygrid2.setRowHidden(rowId2s[i],false);
				}else{
					var type = mygrid2.getUserData(rowId2s[i],"grid1_row_type");
					if(type == 0){
						mygrid2.setRowHidden(rowId2s[i],true);
					}else{
						mygrid2.setRowHidden(rowId2s[i],false);
					}
				}
				
				
			}

		}else{
			
			var ids = mygrid2.getAllItemIds(mygrid2.delim).split(mygrid2.delim);
			for(var i =0;i<ids.length;i++){
				var type = mygrid2.getUserData(ids[i],"grid1_row_type");
				mygrid2.setRowHidden(ids[i],false);
				if(type == 0 && !displayWeek){
					mygrid2.setRowHidden(ids[i],true);
				}
				if(type == 0 && displayWeek){
					mygrid2.setRowHidden(ids[i],false);
				}
				
			}
		}
}


function createMonthRow(obj,isFromDB){
	  var grid1_rowId = obj.grid1_rowId;
	  var pos = obj.pos;
	  var edit = obj.edit;
	  var adLength = obj.adLength == ''?0:obj.adLength;
	  var specificPos = obj.specificPos;
	  
//	  alert('createMonthRow>>>>>>>>>>')
   
//	  alert('specificPos>>>>>>>>>>'+specificPos)
	   
	  var year = obj.year;
 	  var month = obj.month;
 	  var monthStr = obj.monthStr;
	  var monthTims = obj.monthTims;	 
	  var monthPay = obj.monthPay;
//	  var isMonMoney = obj.isMonMoney;	
	  
	  monthTims = monthTims == null || monthTims == 'null'?'':monthTims;
	  monthPay = monthPay == null || monthPay == 'null'?'':monthPay;
	  
	  var rowArray = new Array();
	  var rowArray2 = new Array();
	  var rowCount = mygrid2.getRowsNum();
	  

	  
	 
//		rowArray.push(edit);
//		rowArray.push(pos);
//		rowArray.push(year);
//		rowArray.push(month);		
		
		rowArray.push('');
		rowArray.push('');
		rowArray.push('');
		rowArray.push('');			  
//		  rowArray.push(monthStr);
		  for(var j = 0;j<31;j++){
		  	 rowArray.push(obj.days[j].weakStr); 
		  }
		  rowArray.push('');
		  rowArray.push('');
		  rowArray.push(grid1_rowId);
			
		  var row_id =  (new Date()).valueOf();
//		  alert('2244>>row_id>>'+row_id)
		  var color ="#CCCCCC";
		  mygrid2.addRow(row_id,rowArray,-1);
		  mygrid2.setRowColor(row_id,color);
		  
//		  mygrid2.lockRow(row_id,true);
		  mygrid2.setUserData(row_id,"grid1_rowId",grid1_rowId);
		  mygrid2.setUserData(row_id,"grid1_row_type",0); 
		 
		  
	      mygrid2.setRowHidden(row_id,!displayWeek);

		  	  rowArray2.push(edit);
		  	  rowArray2.push(pos);
		  	  rowArray2.push(year);
		  	  rowArray2.push(month);		  
	  
//	   if(displayWeek){
//		  	  rowArray2.push('');
//		  	  rowArray2.push('');
//		  	  rowArray2.push('');
//		  	  rowArray2.push('');	
//	   }else{
//		  	  rowArray2.push(edit);
//		  	  rowArray2.push(pos);
//		  	  rowArray2.push(year);
//		  	  rowArray2.push(month);	      	
//	   }
		  for(var j = 0;j<31;j++){
		  	 rowArray2.push('');
		  }
		  rowArray2.push(monthTims);
		  rowArray2.push(monthPay);
		  rowArray2.push(grid1_rowId);


		  var row_id =   (new Date()).valueOf();
		  
//		  console.log(row_id);
//		  alert(row_id)
		  
		  mygrid2.addRow(row_id,rowArray2,-1);
		  mygrid2.setUserData(row_id,"grid1_rowId",grid1_rowId);
  		  mygrid2.setUserData(row_id,"grid1_row_type",1);

		 for(var j = 0;j<37;j++){
		 	
				var cell = mygrid2.cells(row_id,j);
				var td = cell.cell;
				
//				if(j<4){
//					
//				}
				
				if(j>3 && j <35){
					var data = obj.days[j-4];
					
				
//					data.specificPos = specificPos;
					var disabled = data.disabled;
					disabled = disabled == null || disabled == 'null'?false:disabled;
					var adTimes = data.adTimes;
					var bgColor = data.rsColor;
//					if(dayObj.curSpecificed && dayObj.isResSpecificed && dayObj.isAdSpecificed && t >0 && isResChangedOnEdit)  rt =  false;
//					alert('isFromDB>>>'+isFromDB)
//					if(!isFromDB){
						if(data.curSpecificed && data.isResSpecificed && !data.isAdSpecificed ){
							adTimes =  0;
						}
							
							
//							var cell = mygrid2.cells(row_id,35);
//							var times = cell.getValue()*1;
//							cell.setValue(times-adTimes);
						
					
					data.adTimes = adTimes;
						
//					}
					adTimes = adTimes == null || adTimes == 'null'|| adTimes == 0?'':adTimes;
	
					td.navtype = 1;
					td.adLength = adLength;
					td.dayObj = data;
//					td.isMonMoney = isMonMoney;
	
					cell.setBgColor(bgColor);
//					alert(adTimes)
					cell.setValue(adTimes);
					
//					if(adTimes >0) {
//						alert('2331>>td>>'+td)
//					}
					
//					alert(''+adTimes);
					
		
					
					dhtmlxEvent(td,"click", mygrid2onKeypressClick);
				}
               
    

				
			}



//		  alert('2355>>obj.bak_arr.length>>'+ obj.bak_arr.length)

    
	        if(obj.bak_arr.length>0){
	        	
	        	var bak_arr = obj.bak_arr;
	        	for(var i = 0;i<bak_arr.length;i++){
	        		for(var j = 0;j<31;j++){
		        		var cellIndex = j+4;
		        		var cell =  mygrid2.cells(row_id,cellIndex);
		        		var td = cell.cell;
		        		td._cellIndex = cellIndex;
		        		var dayObj = td.dayObj;
		        		if(dayObj){
			        		var day = dayObj.dayDate;
			        		var vvv = bak_arr[i][j];
			        		if(vvv){
				        		var values = vvv.split('_');
				        		var value_day = values[0];
				        		var value = values[1];
//								var row =  mygrid2.getRowById(row_id);
//								cell._cellIndex = cellIndex;
								if(value >0 && value_day == day){
									var keyCode = 48 + value*1;
								 	var event ={keyCode:keyCode,ctrlKey:false,shiftKey:false,target:td,cell:cell};
								 	mygrid2onKeypressClick(event);		
								}	
			        		}

		        		}

	        		}
	        	}
	        }
         
//         if(!isOrderEditState){
//         	display_mygrid1_all_broArray();	
//         }
           
//           mygrid1.setActive(true);

//	mygrid2.setActive(true);	
}






function getSpecCmd(cindex,callBakFun){
	var apppos_cindex = mygrid1.getColIndexById('apppos');
	var ordersubcate_cindex = mygrid1.getColIndexById('ordersubcate');
	
	if(cindex == 'apppos_cindex'){

		function callfn(objs){
			var command = mygrid1.getCombo(apppos_cindex);
			command.clear();
			command.positions = new Array();
			var defvalue = 0;
			for(var i = 0;i< objs.length;i++){
				var id = objs[i].id;
				var txt = objs[i].name;
				command.put(id,txt);
				command.positions[id] = objs[i].position; 
		    }
		    
		    if(callBakFun) callBakFun();
		}	
		
		var obj = specific.obj;
		SpecificManager.getSpecificSelectFromMap3(obj,callfn);
	}
	
	if(cindex == 'ordersubcate_cindex'){
		function callfn(objs){
//			var c_index = mygrid1.getColIndexById('ordersubcate');
			var command = mygrid1.getCombo(ordersubcate_cindex);
			command.clear();
			command.calculateauto = new Array();
			var defvalue = 0;
			for(var i = 0;i< objs.length;i++){
				var id = objs[i].id;
				var txt = objs[i].name;
				command.put(id,txt);
				command.calculateauto[id] = objs[i].calculateAuto; 
//				if(txt =="正常") defvalue = objs[i].id;
		    }	
		    
		      if(callBakFun) callBakFun();
//		    command.obj.value="正常"
//		    command.list.selectedIndex = 1;
	
//			command.setValue(defvalue)
		    
//		    alert(command.getIndexByValue(defvalue))
		    	
		}
		orderCategory.obj.orgId = orgId;
		orderCategory.obj.version = order_year; 
//		orderCategory.obj.parentId = parent.document.getElementById("categoryId_for_paraArray").value; 
		orderCategory.obj.parentId = toolbar.getComponent("categoryId_for_paraArray").getValue(); 
	
		OrderCategoryManager.getStore(orderCategory.obj,callfn);
//		orderCategory.makeSelectFromMap5(orderCategory.obj,"orderSubCategoryId","",callfn)
	}
	
	
	

}







/** keyboard navigation, only for popup calendars */


 function isEnableCellClick(el,ev,adLength,isResChangedOnEdit){

//    if(isUndefined(el)) return false;
//	if(el.navtype == "-1") return false;
	 
	

	var dayObj = el.dayObj;
	if(dayObj == null) return false;
	var dayDate = ''+dayObj.dayDate;
	var resourceDayId = dayObj.resourceDayId;
	var rsTotalTime =  dayObj.rsTotalTime == null || dayObj.rsTotalTime == "" ? 0: dayObj.rsTotalTime; //资源标准
	var rsTotalTime2 =  dayObj.rsTotalTime2 == null || dayObj.rsTotalTime2 == "" ? 0: dayObj.rsTotalTime2; //资源标准
  	var isLocked = dayObj.isLocked; //播出单已出
	var rt = true;
	//keydown 键盘、 keypress 鼠标
	var K =  (ev.type == "keydown" || ev.type == "keypress")? ev.keyCode : ev.which;
	var isKeypress = (ev.type == "keypress"); 
	var t;

//	alert('2602>>ev.type>>'+ev.type)
//	alert('2602>>ev.keyCode>>'+ev.keyCode)

//	alert('2560>>isKeypress>>'+isKeypress)
	
  	var curValue = (el.innerHTML >0) ? el.innerHTML*1 : 0;
	
//	alert('2564>>isKeypress>>'+curValue)
  	
//  	if(resourceDayId == null) return false;
  	

	
	//curSpecificed   当前有指定 isResSpecificed 资源有指定 isAdSpecificed  当前处于修改状态，且在广告资源中就是被当前广告所指定
	
		//没有维护广告时

	
	if(isLocked && config_outLimitBroarrang) return  false; //播出单已出

//	alert('2647'+dayObj.isResSpecificed) //true
//	alert(dayObj.isAdSpecificed) //false
//	alert(dayObj.curSpecificed) //true



	if(ev.type == "keydown"  || ev.type == "keypress"){
		if(K >=96 && K<=105)  K = K-48;
		if(K == 32 ||K == 8 || K == 110) K = 48;
		
		
		
		t = String.fromCharCode(K)*1;	
		
		
		
		if(t >0){
//				alert(dayObj.curSpecificed)
//				alert(dayObj.isResSpecificed)
//				alert(dayObj.isAdSpecificed)
//				alert(isUndefined(dayObj.specificPos))	
		}
		
		if(dayObj.curSpecificed   && (t + curValue) >1)  return  false;
		
//		if(dayObj.curSpecificed && !isUndefined(dayObj.specificPos) && dayObj.specificPos !=''   && t >0)  return  false;
		
//		if(dayObj.curSpecificed && dayObj.isResSpecificed  && (t + curValue) >0)  return  false;
		
//		if(dayObj.curSpecificed && dayObj.specificPos !=''  && t >0)  return  false;
		
//		if(dayObj.curSpecificed && dayObj.isResSpecificed && dayObj.isAdSpecificed && t >0 && isResChangedOnEdit)  rt =  false;
//		if(dayObj.curSpecificed && dayObj.isResSpecificed && dayObj.isAdSpecificed && t >0 && isSpecifChangedOnEdit)  rt =  false;	
//		if(dayObj.curSpecificed && !dayObj.isResSpecificed && dayObj.isAdSpecificed && t >1 && isSpecifChangedOnEdit)  rt =  false;	
		if(dayObj.curSpecificed && dayObj.isResSpecificed && dayObj.isAdSpecificed && t >1 )  return  false;
		if(dayObj.curSpecificed && dayObj.isResSpecificed && !dayObj.isAdSpecificed && t >0 ) return  false;
		if(dayObj.curSpecificed && !dayObj.isResSpecificed && !dayObj.isAdSpecificed && t >1 )  return  false;
		
	
	}else{
		t = (K == 1) ? 1 : -1;
		if(dayObj.curSpecificed && dayObj.isResSpecificed  && (t + curValue) >0)  return  false;
		
		if(dayObj.curSpecificed && dayObj.isResSpecificed && dayObj.isAdSpecificed && t >1 )  return  false;
		if(dayObj.curSpecificed && dayObj.isResSpecificed && !dayObj.isAdSpecificed && t >0 ) return  false;
		if(dayObj.curSpecificed && !dayObj.isResSpecificed && !dayObj.isAdSpecificed && t >1 )  return  false;
	}
	
//	alert(rsTotalTime)
//	alert(rsTotalTime2)
	
	if(rsTotalTime == 0 && t >0) return  false;	
	
	if(rsTotalTime2 == 0 && t >0) return  false;	
	
	var oldValue = dayObj.adTimes*1;

	var afterLeaveTimes = 0;
	var afterLeaveTimes2 = 0;
	var changeTimes = adLength * t;//添加该变量是为了实现：就算该资源已经超时,但是没有超时权限的人依然可以编辑订单（占用的时间只能改小或不变）.
	dayObj.rsReleave2 =  (dayObj.rsReleave < dayObj.rsReleave2)?dayObj.rsReleave:dayObj.rsReleave2;
// 	var afterLeaveTimes = dayObj.rsReleave - adLength * (t + curValue*1);
//	var afterLeaveTimes2 = dayObj.rsReleave2 - adLength * (t + curValue*1);
// 	alert('afterLeaveTimes'+afterLeaveTimes)
	if(isKeypress){
		if(isResChangedOnEdit){
			afterLeaveTimes = dayObj.rsReleave - adLength * (t*1 + curValue*1);
			afterLeaveTimes2 = dayObj.rsReleave2 - adLength * (t*1 + curValue*1);
		}else{
			afterLeaveTimes = dayObj.rsReleave - adLength * (t*1 + curValue*1)+dayObj.adLength*oldValue*1;
			afterLeaveTimes2 = dayObj.rsReleave2 - adLength * (t*1 + curValue*1)+dayObj.adLength*oldValue*1;
		}
	
	}else{
		if(isResChangedOnEdit){
			afterLeaveTimes = dayObj.rsReleave - adLength * (t*1);
			afterLeaveTimes2 = dayObj.rsReleave2 - adLength * (t*1);
			
//			alert('adLength>>'+adLength)
//			alert('t>>'+t)
//			alert('dayObj.rsReleave>>'+dayObj.rsReleave)
//			alert('afterLeaveTimes>>'+afterLeaveTimes)
			
		}else{
			afterLeaveTimes = dayObj.rsReleave - adLength * (t*1)+dayObj.adLength*oldValue*1;
			afterLeaveTimes2 = dayObj.rsReleave2 - adLength * (t*1)+dayObj.adLength*oldValue*1;
		}

	}

	

//	var afterLeaveTimes2 = dayObj.rsReleave2 - adLength * (t*1 + curValue*1)+dayObj.adLength*oldValue*1;
	
	
//	alert('ev.type>>'+ev.type)
//	alert('t'+t)
//	alert('curValue'+curValue)
//	alert('dayObj.adLength'+dayObj.adLength)
//	alert('oldValue'+oldValue)
//	alert('dayObj.rsReleave'+dayObj.rsReleave)
//	alert('afterLeaveTimes'+afterLeaveTimes)
//	alert('changeTimes>>'+ changeTimes)
	
	


//	alert(dayObj.rsReleave+'_'+dayObj.rsReleave2)
	
	//alert(dayObj.rsReleave2 - adLength * (t + curValue*1))
	


	if(dayObj.isLimit && (afterLeaveTimes < 0 || afterLeaveTimes2 < 0) && rsTotalTime > 0 && (t + curValue)>0){
				//下面两个if语句是为了实现根据个人选择来决定是否继续提示"广告超时".
				//isAlert,isConfirm这两个字段在最上面定义了.
				if(broArrange_isAlert){
					extjMessage("该时段"+getFormatDay(dayDate,"yyyy-mm-dd")+"的广告超时!"); 
				}   
				if(broArrange_isConfirm){

					Ext.MessageBox.confirm('系统提示', '是否继续提示广告超时？', function(btn) {
			 			  if (btn == 'yes') {
			 				 broArrange_isAlert = true;
			 				 broArrange_isConfirm = false;
			              }else{
			              	 broArrange_isAlert = false;
			              	 broArrange_isConfirm = false;
			              }
			              rt =  false;	
					 });
//						

					
				}
		         
				if(!tag_time_out && changeTimes>0){rt =  false;}
	}		
	

//	if(dayObj.isPublish) rt =  false; //有待考虑

	return rt;
}



function displayCompagesTree2_bak(model){
	
//	 $("carrierTypeTreebox2").style.height = 300+"px";;
//	 
	var loadDataURL_open =ctxPath+"servlet/resourceTreeServlet?method=open&id=1";	
	var loadDataURL_init =ctxPath+"servlet/resourceTreeServlet?method=init&id=0";
	var obj_tree =new dhtmlXTreeObject("treeboxbox_tree","300px","300px",0);   
    obj_tree.setImagePath(ctxPath+"scripts/dhtml/2.6/dhtmlxTree/codebase/imgs/");
     obj_tree.setXMLAutoLoading(loadDataURL_open);
    obj_tree.loadXML(loadDataURL_init);
    
    
}

	


function displayCompagesTree2(model,wasChanged){
	
	if(config_resourceUseCustomerCatelog){
		var custCmd =  toolbar.getComponent("customerName_for_paraArray");
		var customerId = custCmd.getValue();	
		var customerName =  custCmd.getRawValue();	
		if(custCmd.getValue() == ''){extjMessage('请先选择客户,再选择段位!');return false;};
		if(customerId == customerName){checkCustomer(1);return false;}
	}

	
//	config_resourceUseCustomerCatelog
//	alert('2609')

//	if(cellIndex !=1) return false;
     
	 if(!compagesDiaWin){
	 	
	 	var closeBtn ={text: '关闭',handler: function(){compagesDiaWin.hide(this);}};
	 	var okBtn ={text: '确定',id:'compagesDiaWin_ok',handler: function(){}};

		 compagesDiaWin = new Ext.Window({
			   title : '选择时段',
			   width : 400,
			   height : parent.build_more_paraArray.getInnerHeight() - footerToolbar.getHeight()/5,
			   isTopContainer : true, 
			   modal : true,
			   closeAction:'hide',
			   resizable : false,
			   buttons: [okBtn,closeBtn],
			   contentEl :  $("carrierTypeTreebox2")
		  	}); 
		  	
	    Ext.EventManager.onWindowResize(initPosition_compagesDiaWin, this); //window大小改变时，重新设置坐标
	    Ext.EventManager.on(window, 'scroll', initPosition_compagesDiaWin, this); //window移动滚动条时，重新设置坐标		  	
		  		
	 }
	 
	 
	
	 compagesDiaWin.buttons[0].handler = function(){clos_win_res_tree(model)};

	 initPosition_compagesDiaWin();

	compagesDiaWin.show(this);
	




	if(carrierType.tree==null){
			 carrierType.className  = "carrierType";
			 carrierType.IdPrefix 	= carrierType.className + "Id";
			 carrierType.treebox	= carrierType.className + "Treebox2";
			 carrierType.tree 		= new Tree(carrierType.treebox); 
			 getCarrierTypeTree(carrierType,model);  
			 $("carrierTypeTreebox2").style.height = compagesDiaWin.getInnerHeight()+"px";;	 
			 
	}else{
			if(carrierType.tree.model != model){
				getCarrierTypeTree(carrierType,model);  
			}
	}
	
	carrierType.tree.model = model;
	

};




function set_resInfo_to_grid1(resources,is2win){
		var res_cindex = mygrid1.getColIndexById('resourceName');
		var len_cindex = mygrid1.getColIndexById('len');
		var resourceIds = new Array();
		var count = mygrid1.selectedRows.length; 
		var res_obj = resources[0];
		
		var newIdArray = new Array(); 
		
		for(var i = 0; i< count;i++){
			var row_id =  mygrid1.selectedRows[i].idd;
			
			 var  carrierName =  config_orderMoreCarrier?res_obj.carrierName:"";
		 	 var  broTime = res_obj.broTime;
		 	 var  resourceMemo =  res_obj.resourceMemo  ;
		 	 var  resourceName =  res_obj.resourceName  ;
		 	 var  resourceName =  resourceMemo!=resourceName? resourceName:"";
//		 	 var  pos = broTime +' '+ resourceMemo  +' '+ resourceName;
		 	 var  pos =  resourceMemo  +' '+ resourceName +' '+broTime;
		 	 
		 	 if(config_orderMoreCarrier && carrierName) pos = carrierName+' '+pos;
            
//		 	 alert('2856>>'+mygrid1.getUserData(row_id,"resourceId")+"_"+res_obj.id);
//			alert('2861>>'+ mygrid1.getUserData(row_id,"isNew")+"_"+ detailId);
		 	 
				//为了判断订单明细是否在编辑状态下改变资源，如果是则广告剩余时间的计算方法就要跟着改变
				var isNew =  (mygrid1.getUserData(row_id,"isNew") ==1);
				var detailId = mygrid1.getUserData(row_id,"id"); 
				var isOneditChangeRes = false;
				if(!isNew){ //alert('2873 isNew>>'+ isNew);
				    var rows = orderBackUp.mygrid1.get(row_id); 
				    var bak_obj = rows[rows.length-1];
					var res_old = bak_obj.resourceId;  //alert('2873 res_old>>'+ res_old);
					if(res_old != res_obj.id) isOneditChangeRes = true; //alert('2873  res_obj.id>>'+  res_obj.id);
				}
//				alert('2873 isOneditChangeRes>>'+ isOneditChangeRes);
	
			mygrid1.setUserData(row_id,"isOneditChangeRes",isOneditChangeRes);
		 	
 			mygrid1.cells(row_id,res_cindex).setValue(pos);
			mygrid1.setUserData(row_id,"resourceId",res_obj.id);
			mygrid1.setUserData(row_id,"pos",carrierName + res_obj.resourceMemo);
//			mygrid1.setUserData(row_id,"resourceSortId",res_obj.resourceSort);
			
	
			
			resourceIds.push(res_obj.id);
			var length = mygrid1.cells(row_id,len_cindex).getValue();
			
			if(length >0){
				function cafn(){
						if(!is2win)reset_mygrid2_row(row_id,1);
				}
				var matterOj={length:length};
				setBasePrices(resourceIds,matterOj,cafn);
			}else{
				if(!is2win)reset_mygrid2_row(row_id,1);
			}

			newIdArray.push(row_id);
		}
		
      return newIdArray;
		 
}



function reset_mygrid2_row(rowId1,mode,copy_grid1_rowid,new_arr,callBak){
	
//	alert('reset_mygrid2_row_'+mode)
	

	var rowids = getRowByUserData(mygrid2,"grid1_rowId",rowId1);
	
    var bak_arr = new Array();

		if(mode == 1){  //备份当前
			bak_arr = get_bak_arr_by_grid1rowid(rowId1);	
		}else if(mode == 2){ //copy_post
			bak_arr = get_bak_arr_by_grid1rowid(copy_grid1_rowid,1);	
		}else if(mode == 3){//copy_move
//			alert(copy_grid1_rowid+'_'+rowId1)
			bak_arr = get_bak_arr_by_grid1rowid(copy_grid1_rowid,2,rowId1);
		}else if(mode == 4){//自动配置
			bak_arr = new_arr;	 
		}else if(mode == 5){//顺延一个月
			bak_arr = get_bak_arr_by_grid1rowid(rowId1,3);;	
		}
		
		if(mode != 5 && mode != 0){
			for(var i = 0;i<rowids.length;i++){
				mygrid2.deleteRow(rowids[i]);
			}	
		}

	
		getOneResourceMonthInfos(rowId1,0,true,mygrid1.getRowsNum(),0,bak_arr,callBak); 

}


function get_bak_arr_by_grid1rowid(copy_grid1_rowid,modle,rowId1){
		var bak_arr = new Array();  
		
//	    alert("modle>>>"+modle)
		
		var rowids = getRowByUserData(mygrid2,"grid1_rowId",copy_grid1_rowid,"grid1_row_type",1);
		var have = false;

		if(modle == 2){
			if(rowids.length>0){
				  
			var s_cindex = mygrid1.getColIndexById('start');
			var e_cindex = mygrid1.getColIndexById('end');
							
			var s_date = mygrid1.cells(rowId1,s_cindex).getValue();
			var e_date = mygrid1.cells(rowId1,e_cindex).getValue();	
			
			 s_date = getFormatDay(s_date,'y-m-d');
			 e_date = getFormatDay(e_date,'y-m-d');
			 

//			var startDt = myUtils.parseDate(s_date,'y-m-d');
//			var endDt = myUtils.parseDate(e_date,'y-m-d');	

			var startDt  = new Date(Date.parse(s_date));
			var endDt = new Date(Date.parse(e_date));
	
			var monthDiff = myUtils.monthDiff(startDt,endDt)*1+1;
			

					for(var i = 0;i<rowids.length;i++){
						bak_arr[i] = new Array();  
						
//						var row_type = mygrid2.getUserData(rowids[i],"grid1_row_type");
//						if(row_type == 0) continue;
						
						
					    for(var j = 0 ;j < 31;j++){
					    	 var cellIndex = j+4;
					    	 var cell = mygrid2.cells(rowids[i],cellIndex);
					    	 var td = cell.cell;
					    	 var v = td.innerHTML;
					    	 v = (v =='&nbsp;' || v =='')?0:v;
					    	 var day = ''+td.dayObj.dayDate;

					    	 var year  =  day.substring(0,4)*1;
					    	 var month  =  day.substring(4,6)*1;
					    	 month = month + monthDiff;
					    	 if(month > 12){
					    	 	year = (year*1+1)+'';
					    	 	month = month - 12;
					    	 }
					    	 month = month < 10?'0'+month:month+'';
					    	 var dd = j+1;
					    	 var dd2 = dd  <  10?'0'+ dd:dd+'';
					    	 var day2 = year + month + dd2;

        					 var rowIndex = mygrid2.getRowIndex(rowids[i]);
					         

				             bak_arr[i][j] = day2+'_'+v+'_'+rowIndex+'_'+cellIndex;
				             if(v > 0) have = true;
				        }				
					}
			}
			bak_arr = have?bak_arr:[];
			
		}else if(modle == 3){
			
			if(rowids.length>0){
				  
		
//			var e_cindex = mygrid1.getColIndexById('end');
//			var e_date = mygrid1.cells(rowId1,e_cindex).getValue();	
//			
//			 s_date = getFormatDay(s_date,'y-m-d');
//			 e_date = getFormatDay(e_date,'y-m-d');
//			 
//			var startDt = myUtils.parseDate(s_date,'y-m-d');
//			var endDt = myUtils.parseDate(e_date,'y-m-d');	 


			
			var monthDiff = 1;
			var s_cindex = mygrid1.getColIndexById('start');
			var e_cindex = mygrid1.getColIndexById('end'); 
			var e_date = mygrid1.cells(copy_grid1_rowid,e_cindex).getValue();	
			e_date = getFormatDay(e_date,'y-m-d');
//			var endDt = myUtils.parseDate(e_date,'y-m-d');	
			var endDt  = new Date(Date.parse(e_date));
			
			var endDt0 = new Date(endDt.getFullYear(), endDt.getMonth()*1 +1,1, 0, 0, 0); 
			var endDt1 = new Date(endDt.getFullYear(), endDt.getMonth()*1 +1,endDt0.getMonthDays(), 0, 0, 0); 
			var start_date = myUtils.formatDateSimple(endDt0,''); 
			var end_date = myUtils.formatDateSimple(endDt1,''); 
//			end_date = getFormatDay(end_date,'y/m/d')  	 

//			 alert(start_date +'————'+end_date)

					for(var i = 0;i<rowids.length;i++){
						bak_arr[i] = new Array();  
//						var row_type = mygrid2.getUserData(rowids[i],"grid1_row_type");
//						if(row_type == 0) continue;

					    for(var j = 0 ;j < 31;j++){
					    	 var cellIndex = j+4;
					    	 var cell = mygrid2.cells(rowids[i],cellIndex);
					    	 var td = cell.cell;
					    	 var v = td.innerHTML;
					    	 v = (v =='&nbsp;' || v =='')?0:v;
					    	 var day = ''+td.dayObj.dayDate;

					    	 var year  =  day.substring(0,4)*1;
					    	 var month  =  day.substring(4,6)*1;
					    	 month = month + monthDiff;
					    	 if(month > 12){
					    	 	year = (year*1+1)+'';
					    	 	month = month - 12;
					    	 }
					    	 month = month < 10?'0'+month:month+'';
					    	 var dd = j+1;
					    	 var dd2 = dd  <  10?'0'+ dd:dd+'';
					    	 var day2 = (year + month + dd2)*1;
	
					    	 if(day2 >= start_date && day2 <= end_date){
	        					 var rowIndex = mygrid2.getRowIndex(rowids[i]);
					             bak_arr[i][j] = day2+'_'+v+'_'+rowIndex+'_'+cellIndex;
					             if(v > 0) have = true;
					    	 }


				        }				
					}
			}
			bak_arr = have?bak_arr:[];
			
			mygrid1.cells(copy_grid1_rowid,s_cindex).setValue(getFormatDay(start_date,'y/m/d'));
		    mygrid1.cells(copy_grid1_rowid,e_cindex).setValue(getFormatDay(end_date,'y/m/d'));	
				 
		}else{
			if(rowids.length>0){
					for(var i = 0;i<rowids.length;i++){
						bak_arr[i] = new Array();  

					    for(var j = 0 ;j < 31;j++){
					    	 var cellIndex = j+4;
					    	 var cell = mygrid2.cells(rowids[i],cellIndex);
					    	 var td = cell.cell;
					    	 var v = td.innerHTML;
					    	 v = (v =='&nbsp;' || v =='')?0:v;
					    	
					    	 var dayObj = td.dayObj;
					    	 if(dayObj){
						    	 var day = dayObj.dayDate;
					             var rowIndex = mygrid2.getRowIndex(rowids[i]);
					             bak_arr[i][j] = day+'_'+v+'_'+rowIndex+'_'+ cellIndex;
					             if(v > 0) have = true;	

					             
					    	 }

				        }				
					}
			}
			bak_arr = have?bak_arr:[];
		}

 	
		return bak_arr;	
}


//function get_bak_arr_by_grid1rowid(rowId1){
//		var bak_arr = new Array();  
//		var rowids = getRowByUserData(mygrid2,"grid1_rowId",rowId1);
//	
//		if(rowids.length>0){
//				for(var i = 0;i<rowids.length;i++){
//					bak_arr[i] = new Array();  
//				    for(var j = 0 ;j < 31;j++){
//				    	 var cell = mygrid2.cells(rowids[i],j+4);
//				    	 var v = cell.cell.innerHTML;
//			             bak_arr[i][j] = v;
//			        }				
//				}
//		}
//		
//		return bak_arr;	
//}

function clos_win_res_tree(model,is2win){
	
//	alert('3172 model>>'+model+"_is2win"+is2win)
//	alert('3172 model>>'+carrierType.tree.model+"_is2win"+is2win)
	
	       model = carrierType.tree.model;
	
	
			var tree = carrierType.tree.dhtmlTree;
			var resourceIds = new Array();
			
			if(model == 1){
				resourceIds = [carrierType.tree.getSelectedItemId("resourceId")];
			}else{
			 	resourceIds = carrierType.tree.getAllCheckedBranches("resourceId");				
			}

            
			paramFromUrl.resourceIds = resourceIds+'';

			var resources = new Array();
			for(var i = 0; i< resourceIds.length;i++){
				var obj ={};
				var itemId = 'resourceId' + resourceIds[i];
				obj.id =  resourceIds[i];
				obj.broTime = tree.getUserData(itemId,"broTime");
//				if(tvNameParam=='fztv'){
					var carId = tree.getParentId(tree.getParentId(itemId));
					obj.carrierName = tree.getUserData(carId,"carrierName");
					obj.carrierName = obj.carrierName.substring(0,2);
//					alert(obj.carrierName)
//					obj.carrierParentName = tree.getUserData(carId,"carrierParentName");
//				}


				obj.resourceName = tree.getUserData(itemId,"resourceName");
				obj.resourceMemo = tree.getUserData(itemId,"resourceMemo");
				
//				obj.resourceSortId = tree.getUserData(itemId,"resourceSortId");

				resources.push(obj);
			}
			
			paramFromUrl.resources = resources;
            
            
            var newIdArray = new Array();
            
//        	alert('3153 model>>'+model)
            
            if(model == 1){
            	newIdArray = set_resInfo_to_grid1(resources,is2win);
            }else{
            	newIdArray = createGrid1(paramFromUrl);
            }
	 	
	 		
	 		compagesDiaWin.hide(this);
	 		
	 		return newIdArray;
		
	}

function getCarrierTypeTree(obj,model){
	
		var obj_tree = obj.tree.dhtmlTree;	
//		var rootId = obj_tree.rootId;
		
		
		if(model == 1){
					obj_tree.enableCheckBoxes(false);
		}else{
					obj_tree.enableCheckBoxes(true);
					obj_tree.enableThreeStateCheckboxes(true);
//					obj_tree.enableSmartCheckboxes(true);		
		}	
		
		function doOnSelect(itemId){
			if(model == 2){
				        if(itemId == "root") return false;
				        var isItemChecked = obj_tree.isItemChecked(itemId);
						obj_tree.setSubChecked(itemId,!isItemChecked);	
			}

		}
		
		obj_tree.setOnClickHandler(doOnSelect);//set function to call on dbl click		
		
		function doOnDblClick(itemId){
			
//			alert('3172 model>>'+model+"_itemId"+itemId)
			
//			alert('3172 model>>'+carrierType.tree.model)
			
			model = carrierType.tree.model;
			
			var type = obj_tree.getUserData(itemId,"type");
			if(type != 3) return false;
			compagesDiaWin.hide(this);
			if(model == 1){
//				alert('3172 model>>'+model)
				clos_win_res_tree(model);
			}
		}
		
		
		if(obj_tree.getAllLeafs() ==''){
			obj_tree.setOnDblClickHandler(doOnDblClick);
		}
		
		
//		if(model == 2){
//			obj_tree.setOnDblClickHandler(function(){});
//		}else{
//			obj_tree.setOnDblClickHandler(doOnDblClick);
//		}
		

		obj_tree.setImagePath(ctxPath+"scripts/dhtml/2.6/dhtmlxTree/codebase/imgs/");



	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	var getxml = function(strXML){		
		obj_tree.deleteChildItems(0);
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
	
	obj.getTreeXMLByYear2("carrierId","resourceId",order_year,getxml);

}


function buidArray(resourceIds,startDate,endDate,matterId,respecId,realPrice){

//	var func  = function(xml){
//			mygrid.clearAll();
//			mygrid.loadXMLString(xml);
//	}
	            

//	PublishArrangeManager.getAdversByResourceId(resourceId,publishDate,orgId,func);	
}

//
//function getMonthInfos(param,func){
//	
//	param.isLock =false;
//	param.resourceId =resourceId;
//	param.specificValue =specificValue == null?'':specificValue;
//	param.version =order_year;
//	param.startDate =startDate;
//	param.endDate = endDate;
//	
//	param.adLength = adLength;
//	param.basePrice =basePrice;
//	param.realPrice =realPrice;
//	param.ageRate =ageRate;
//	param.moneyBalance =moneyBalance;
//	param.isTimeOutRight =tag_time_out;
//
//
//
//	var getMonthsFun = function(objs){
//    	
//    	parent.backup_cur_info(null,null,objs);	
//    	 
//    }
// 
//
//	var orderDetail_obj = (new OrderDetail()).obj;
//	orderDetail_obj.id = null;
//	orderDetail_obj.publishStartDate = param.startDate;
//	orderDetail_obj.publishEndDate = param.endDate;
//	orderDetail_obj.resourceInfoId = param.resourceId;
//	orderDetail_obj.specific.position = param.specificValue;
//	orderDetail_obj.compagesId = 0;
//	orderDetail_obj.version = param.version;
//	orderDetail_obj.orderDetailStates = 3;
//	orderDetail_obj.compagesId =999;
//
//	orderDetail.getMonthInfos(orderDetail_obj,getMonthsFun);
//
//};





function setBasePrices(resourceIds,matterOj,callFun){
	
	var map = new HashMap();
	var adlen = matterOj.length;

	function callBakFun(objs){
	
				for(var i = 0;i<objs.length;i++){
					 var rsid = objs[i].value1;
					 var price =  objs[i].value4;
					 var key = rsid +''+ adlen;

					 map.put(key,price);
				}
		var count = mygrid1.selectedRows.length;		
		var stantPrice_cindex = mygrid1.getColIndexById('stantPrice');
		var realPrice_cindex = mygrid1.getColIndexById('realPrice');
		
		
		
		
		for(var i=0;i<count;i++){
			  var row_id = mygrid1.selectedRows[i].idd;
			  var rsId = mygrid1.getUserData(row_id,"resourceId");
			  var key = rsId +''+ adlen;
			  mygrid1.cells(row_id,stantPrice_cindex).setValue(map.get(key));
			  var realPrice = mygrid1.cells(row_id,realPrice_cindex).getValue();
//			  var matterId = mygrid1.getUserData(row_id,"matterId");
			  if(!realPrice && orderCategoryMain != 0){
			  	mygrid1.cells(row_id,realPrice_cindex).setValue(map.get(key));
			  }
		}	
		
		if(callFun) callFun();			
	};
	
	paramFromUrl.version = order_year;
	paramFromUrl.priceTypeId = priceTypeId;	
	paramFromUrl.adLength = adlen;
	paramFromUrl.resourceIds = resourceIds.join(',');
	


	var queryString = $H(paramFromUrl).toQueryString();
	resource.getResourcesByIds(queryString,callBakFun);			

}


function addGrid1NewRow(menuitemId,copy_grid1_rowid){
	
	var group_value = toolbar.getComponent("fitter_cmd_id").getValue();
	var ordersubcate_cindex = mygrid1.getColIndexById('ordersubcate');
	 //		 myrid1.cells(row_id,ordersubcate_cindex).setValue(19);
//		 var command = mygrid1.getCombo(ordersubcate_cindex);
//		 alert(command.setValue)
//		 command.setValue("正常");
//		 command.get[19];

//	mygrid1.uncheckAll();

	var rowArray = new Array();
//	var row_id =  mygrid1.uid();
	var row_id =  new Date().getTime();
//	var row_id =  mygrid1.uid();


	var row_index =  mygrid1.getRowsNum()*1 ;
	var isMoveNextMonth = menuitemId == 'copy_move';
	var start_date = startDate2;
	var end_date = endDate1;
	

	
	if(isMoveNextMonth){

		var s_cindex = mygrid1.getColIndexById('start');
		var e_cindex = mygrid1.getColIndexById('end');
//		var isMonMoney_cindex = mygrid1.getColIndexById('isMonMoney'); 
						
		var s_date = mygrid1.cells(copy_grid1_rowid,s_cindex).getValue();
		var e_date = mygrid1.cells(copy_grid1_rowid,e_cindex).getValue();	
		
		 s_date = getFormatDay(s_date,'y-m-d');
		 e_date = getFormatDay(e_date,'y-m-d');
		  
//		var startDt = myUtils.parseDate(s_date,'y-m-d');
//		var endDt = myUtils.parseDate(e_date,'y-m-d');	

		var startDt  = new Date(Date.parse(s_date));
		var endDt  = new Date(Date.parse(e_date));

		var monthDiff = myUtils.monthDiff(startDt,endDt)*1;

		var startDt1 = new Date(startDt.getFullYear(), startDt.getMonth()*1+monthDiff+1,startDt.getDate(), 0, 0, 0); 
		var endDt0 = new Date(endDt.getFullYear(), endDt.getMonth()*1 + monthDiff +1,1, 0, 0, 0); 
		var endDt1 = new Date(endDt.getFullYear(), endDt.getMonth()*1 + monthDiff +1,endDt0.getMonthDays(), 0, 0, 0); 
		start_date = myUtils.formatDateSimple(startDt1,'');
		end_date = myUtils.formatDateSimple(endDt1,''); 

	}
	

	for(var j = 0;j<16;j++){
		
		if(j == s_cindex){
			rowArray.push(getFormatDay(start_date,'y/m/d')); 
		}else if(j == e_cindex){
		 	rowArray.push(getFormatDay(end_date,'y/m/d')); 
		}else if(j == ordersubcate_cindex){
			var command = mygrid1.getCombo(ordersubcate_cindex); 
			var id = command.keys[0];
		 	rowArray.push(id); 
		}
		
		else{
			 rowArray.push(''); 
		}
		  	
	}
   
  
    
    
    var count = mygrid1.selectedRows.length;	
    
 
    
    if(count ==1){
    	
    	var sel_id = mygrid1.getSelectedRowId(); 
    	
		var rsId = mygrid1.getUserData(sel_id,"resourceId");
//		var resourceSortId = mygrid1.getUserData(sel_id,"resourceSortId");
		var rs_pos =  mygrid1.getUserData(sel_id,"pos");
		var rs_cindex = mygrid1.getColIndexById('resourceName');
		var rs_txt = mygrid1.cells(sel_id,rs_cindex).getValue();
			
		var matterId = mygrid1.getUserData(sel_id,"matterId");
		var edit_cindex = mygrid1.getColIndexById('edit');
		var edit_txt = mygrid1.cells(sel_id,edit_cindex).getValue();
			
	   	if(group_value == 0){
			rowArray[rs_cindex] = rs_txt;
		}
		if(group_value == 1){
			rowArray[edit_cindex] = edit_txt;
		}	
	 
		 mygrid1.addRow(row_id,rowArray,-1);
		   
	   	if(group_value == 0){
			mygrid1.setUserData(row_id,"resourceId",rsId);
//			mygrid1.setUserData(row_id,"resourceSortId",resourceSortId);
			
			mygrid1.setUserData(row_id,"pos",rs_pos);
			mygrid1.cells(row_id,rs_cindex).setValue(rs_txt);
		}
		if(group_value == 1){
			mygrid1.setUserData(row_id,"matterId",matterId);
			mygrid1.cells(row_id,edit_cindex).setValue(edit_txt);
		}			

    }else{
    	 
    	   mygrid1.addRow(row_id,rowArray,-1);
    }
 

    mygrid1.setUserData(row_id,"isNew",1);
    
    mygrid1.clearSelection();
    
    var row = mygrid1.getRowById(row_id);
    
//    mygrid1.selectRow(row,true);

//	mygrid1.callEvent("onRowSelect", [row_id,0]);		

    
    return row_id;

//    mygrid1.setSelectedRow(rowId,mygrid1.selectedRows);
//    row.className += " rowselected2";
//    mygrid1.cells(row_id,0).setValue(1);
    

    
}


function getRowByUserData(grid,name,rowId1,fitterName,fitterValue){
	var rowCount = grid.getRowsNum();
	var rowId2s = new Array();
	var isAll = (rowId1 == 0 || rowId1 == '0');
	for(var i = 0;i<rowCount;i++){
		var _rowId2 = grid.getRowId(i)
		var _rowId1 = grid.getUserData(_rowId2,name);
		var _rowType = fitterName?grid.getUserData(_rowId2,fitterName)*1:-1;
		
		
		
		if(fitterName){
			if(rowId1 == _rowId1 && _rowType == fitterValue){
				rowId2s.push(_rowId2);
			}else if(isAll && _rowType == fitterValue){
					rowId2s.push(_rowId2);
			}
		}else{
			if(rowId1 == _rowId1){
				rowId2s.push(_rowId2);
			}else if(isAll){
				rowId2s.push(_rowId2);
			}	
		}

	}
	return rowId2s;
}

function removeOrderDetail(detailId,rowId1,year_month,callBak){

	 var removeFun = function(rt){
		 if(callBak) callBak(rt,rowId1);
//			var index = mygrid1.getRowsNum()-1;
//			if(rowsId >-1) mygrid1.selectRow(index,true); 
		 
		
	 }  
     orderBackUp.isDisplayMonDetail =  isDisplayMonDetail?5:4;

     orderBackUp.tempString = year_month;
     
	 OrderManager.removeOrderDetailByDetailId(orderBackUp,detailId,year_month,  
		 			{
					　　callback:function(data){removeFun(true);},
					　　errorHandler:function(errorString, exception) { 
							removeFun(false);
						    var msg="<div style='width:300px;height:300px;OVERFLOW-y:auto;OVERFLOW: scroll;'>"+"财务已经平过帐,无法删除!"+"<div>";
									Ext.MessageBox.hide(); 
									Ext.MessageBox.show(
									 	{title:'系统提示',msg:msg,width:380,heigth:300,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
									); 	
								

					    }
		 			}						    
						    
				)		
}
	   

function gotoNewRow(){
	var index = mygrid1.getRowsNum()-1;
	if(index >-1) mygrid1.selectRow(index,true); 
}


function removeGrid1NewRow(){
	var rows = mygrid1.selectedRows;

	if(rows.length > 0){
		Ext.MessageBox.confirm('系统提示', '请确认是否删除这'+rows.length+'条记录？', function(btn) {
 			  if (btn == 'yes') {
 				  
 				 //需要删除资源相同的排期
 				   var map1 = new HashMap();
 				   var map2 = new HashMap();
 				   var map3 = new HashMap();
 				   
 				    var count =  rows.length;
 				 	for (var i = 0; i < count; i++){
 				 		var row = rows[i];
 				 		var row_id = row.idd;
 	 				 	var rsId = mygrid1.getUserData(row_id,"resourceId");
 	 				 	map1.put(rsId,rsId);	
 	 				 	map3.put(row_id,row_id);	
 				 	}
 				  
 				 
 					var count = mygrid1.getRowsNum();
 					for (var i = 0; i < count; i++){
 						var row_id = mygrid1.getRowId(i);
						var rsId = mygrid1.getUserData(row_id,"resourceId");
						if(map1.contains(rsId)){
							map2.put(row_id,row_id);
						}
 					}
 					
 					var keyArr = map2.keySet();  

 					if(keyArr !=null){
 	 				 	for (var i = 0; i < keyArr.length; i++){
 	 				 		var rowId1 = keyArr[i];
 	 				 		var rowId2s =  getRowByUserData(mygrid2,"grid1_rowId",rowId1); 
 	 						for (var j = 0; j < rowId2s.length; j++){
 								mygrid2.deleteRow(rowId2s[j]);
 							}
 	 				 	}
 					}

 					
 					
 				 	var keyArr = map3.keySet();  

 				 	for (var i = 0; i < keyArr.length; i++){
 				 		var rowId1 = keyArr[i];
						var isNew =  (mygrid1.getUserData(rowId1,"isNew") ==1);
						var detailId = mygrid1.getUserData(rowId1,"id"); 
						var year_month = mygrid1.getUserData(rowId1,"year_month"); 

						if(isNew) {
							 mygrid1.deleteRow(rowId1);
							 reset_grid1_totalTime();
						 }else{

							 function removeFun(rt,row_Id1){
								 if(rt){
									 mygrid1.deleteRow(row_Id1);   
									 reset_grid1_totalTime();
								 }else{
									 return false;
								 }
							 }

							 removeOrderDetail(detailId,rowId1,year_month,removeFun);							 
							 
						 }
						 remove_backup(detailId)//删除备份
						 
						
						
					}	
 				 	
 				 
	
 				 	
 				  
// 				    var rowCount =  rows.length;
// 				 	for (var i = 0; i < rowCount; i++){
//						var row = rows[0];
//						var rowId1 = row.idd;
//						var isNew =  (mygrid1.getUserData(rowId1,"isNew") ==1);
//						
//						alert(rowId1)
//
//						var detailId = mygrid1.getUserData(rowId1,"id"); 
//						var year_month = mygrid1.getUserData(rowId1,"year_month"); 
//						if(!isNew) {
//							 function removeFun(rt){
//								 if(rt){
//									 alert(rt)
//									 mygrid1.deleteRow(rowId1);    
//								 }else{
//									 return false;
//								 }
//							 }
//							 removeOrderDetail(detailId,year_month,removeFun);
//							
//						 }else{
//							 mygrid1.deleteRow(rowId1);
//						 }
//
//						 remove_backup(detailId) //删除备份
//					}
					

				}
              return false; 	
		 });
	}
	

}

//删除备份
function remove_backup(detail_id){
	 var details = orderBackUp.orderDetailsObj;
	 var orderDetail_objs = new Array();
	 
	 if(details != null){
		 for(var k =0;k< details.length;k++){
			 var detail = details[k];
			 var detailId = detail.id;
			 if(detail_id == detailId){
				 details[k] = null;
			 }
		 }
		 for(var k =0;k< details.length;k++){
			 var detail = details[k];
			
			 if(detail != null) orderDetail_objs.push(detail);
		 }	 
	 }

	 
	 

	 orderBackUp.orderDetailsObj = orderDetail_objs;		

}


function grid1_groupBy(ColId)
{
//	alert(ColId);
	mygrid1.unGroup();
	if(ColId == 0){
//		alert(ColId);
		mygrid2.unGroup();
	}else{
		mygrid2.groupBy(ColId);
	}
	
	
	
////   mygrid.unGroup();
//   
//   // Group by column id, and hide the column
//   if (ColId == 1)
//   {   
////      mygrid.setColumnHidden(37,false);
//
//      mygrid.groupBy(1);
//
////      mygrid.setColumnHidden(1,true);
//      
////      mygrid.customGroupFormat = function(text, count) {
////          return "Column '" + text + "'; containing " + count + " related text segments";
////      };      
//   }
//   else
//   {   
////      mygrid.setColumnHidden(1,false);
//      
//      mygrid.groupBy(37);
//
////      mygrid.setColumnHidden(37,true);
//      
////      mygrid.customGroupFormat = function(text, count) {
////          return "Record " + text + "; containing " + count + " related text segments";
////      };      
//   }
   
}



function set_grid2_month_times(td,bak_value,curValue,forceReset){
			    var row = td.parentNode;
				var cells = row.cells;
				var realPrice_cindex = mygrid1.getColIndexById('realPrice');
				var sumTime_cindex = mygrid1.getColIndexById('sumTime');
				var sumPay_cindex = mygrid1.getColIndexById('sumPay');
				var ordersubcate_index = mygrid1.getColIndexById('ordersubcate');
				
				var grid1_row_id = cells[37].innerHTML; 
				var calculateauto_key = mygrid1.cells(grid1_row_id,ordersubcate_index).getValue();
				var command = mygrid1.getCombo(ordersubcate_index);
				var calculateauto = command.calculateauto[calculateauto_key];

//				var  relpay = mygrid1.cells(grid1_row_id,realPrice_cindex).getValue();
//				relpay = relpay ==""?0:relpay;
				
				
				

				bak_value = bak_value == ""|| bak_value == "&nbsp;"?0:bak_value*1;	
				curValue = curValue ==""?0:curValue*1;
				var v = curValue - bak_value;
				var times = cells[35].innerHTML;
				
//				alert('3804 curValue>>>'+curValue+"_bak_value"+bak_value)
				
				if(curValue !=  bak_value || forceReset){
					
//					alert('3804 forceReset>>>'+forceReset)
					
					times = times == ""|| times == "&nbsp;"?0:times*1;	
					var sumTime = times*1 + v;

//						var sumPay = sumTime * relpay;	
//						sumPay = sumPay ==0?"":sumPay;
//						cells[36].innerHTML = sumPay;	
				
					
					sumTime = sumTime == 0?"":sumTime;
					cells[35].innerHTML = sumTime;	
					
					
//					var rowId2s =  getRowByUserData(mygrid2,"grid1_rowId",grid1_row_id,"grid1_row_type",1);
//					var sumTime_grid2 = 0;
//					for (var i = 0; i < rowId2s.length; i++){
//						var b = mygrid2.cells(rowId2s[i],35).cell.innerHTML; 
//						if(b >0){
//							sumTime_grid2 = b*1 + sumTime_grid2*1;
//						}
//					}		
//				    sumTime_grid2 = sumTime_grid2 ==0?"":sumTime_grid2;
//					mygrid1.cells(grid1_row_id,sumTime_cindex).setValue(sumTime_grid2);
					
					reset_grid1_sumTimes(grid1_row_id);

					reset_grid1_sumPay(grid1_row_id,0,true,calculateauto);
										
					reset_grid1_date(grid1_row_id);
										
					reset_grid1_totalTime();
										
					
				}
				
				
				

}

function mygrid2onKeypressClick(ev){
	
	
	
//	if(orderCkeckState ==1 || orderCkeckState ==3) return false;
	

	
//	mygrid1._HideSelection();
	mygrid1.setActive(false);
//	mygrid1.selectRow(1,0)
//	alert(mygrid1.getSelectedRows())
//	var row = mygrid1.getRowById(mygrid1.getSelectedId());
//	mygrid1.selectRow(row, false, true, false);
	
	
			
		if(ev.button == 0){ev.keyCode = 49;}
		if(ev.button == 2){ev.keyCode = 48;}
		var keyCode = ev.keyCode;
		var ctrlKey = ev.ctrlKey;
		var shiftKey = ev.shiftKey;
		var isMouse = ev.button == 0 || ev.button == 2;
		
		var start_cellIndex = 4;
		var end_cellIndex = 34;
		
	   
		if(keyCode == 46 || keyCode == 32) keyCode = 48;
		
		var that = mygrid2; 
		
//		alert(that.isActive)
//  		that.unmarkAll();
  		that.setActive(true);
//		if(!that.isActive) that.setActive(true);
      
		
        if(ctrlKey || shiftKey) return false;
		
		var isEnableCell = false;
		var td = ev.target;
		var adLength = td.adLength;
		var cell0 = ev.cell;
		
//        alert(3851)
		//设置导航
		setGrid1_nat(td);

		if(!ev.button){
			
			
			if(td._cellIndex < start_cellIndex || td._cellIndex > end_cellIndex){
			
				 ev.cancelBubble=true;
				 return false;
			}
		}
 
//		 alert(3865)
 
		if(keyCode>= 48 && keyCode <= 58 ){
			

//			显示资源信息
//			getGrid1_ResDayInfo(td);
		
	
			
			if(orderCkeckState ==1 || orderCkeckState ==3) return false;
			
			
			
			var rowId = td.parentNode.idd;
			var _cellIndex = td._cellIndex;
			
//		    var bak_value = cell0.getValue();
		     var bak_value = td.innerHTML;
			
			var num =  String.fromCharCode(keyCode);
			var v = (num > 0) ? num : '';
//			var ev2 ={type:"keypress",keyCode:keyCode};
			if(isMouse){
				var ev2 ={type:"keypress",keyCode:keyCode};
			}else{
				var ev2 ={type:"keydown",keyCode:keyCode};
			}
			
//			alert(3894)
			var grid1_rowId  = mygrid2.getUserData(rowId,"grid1_rowId");
			var isOneditChangeRes = mygrid1.getUserData(grid1_rowId,"isOneditChangeRes",isOneditChangeRes);
			var isOneditChangeLength = mygrid1.getUserData(grid1_rowId,"isOneditChangeLength",isOneditChangeLength);

			isOneditChangeRes = isOneditChangeRes?true:false;
			isOneditChangeLength = isOneditChangeLength?true:false;
			
			
			
//			alert('3915 grid1_rowId>>>'+grid1_rowId)
//			alert('3915 isOneditChangeRes>>>'+isOneditChangeRes)

			isEnableCell = isEnableCellClick(td,ev2,adLength,isOneditChangeRes);
			
//			alert('isEnableCell>>'+isEnableCell);
			
			if(isEnableCell){
				var selectValue = 0;
				if(ev.button == 0){
					 selectValue = td.innerHTML  != "&nbsp;" && td.innerHTML  != "" ? td.innerHTML :0;
					v = selectValue*1 +1;
				}else if(ev.button == 2){
					 selectValue = td.innerHTML  != "&nbsp;" && td.innerHTML  != "" ? td.innerHTML :0;
					 if(selectValue>0){
					 	v = selectValue*1 - 1;
					 }else{
					 	v = "";
					 }
				} 
				td.innerHTML = v == 0?"":v;
				
  				//		显示资源信息
//				getGrid1_ResDayInfo(td);
//                v = v == 0?"":v;
//                cell0.setCValue(v,0);
//                that.cell = cell0;
             
//                alert(rowId)
//                that.mark(rowId,_cellIndex,true);
//				alert("isEnableCell bak_value>>>"+bak_value +" v>>>"+v)
				set_grid2_month_times(td,bak_value,v,true);
				
//				alert('isOneditChangeRes>>'+isOneditChangeRes)
//				alert('isOneditChangeLength>>'+isOneditChangeLength)
//				 mygrid1.setActive(false);
//				 mygrid2.setActive(true);
			}else{
//				alert('isOneditChangeRes>>'+isOneditChangeRes)
				if(isOneditChangeRes){
					if(!isMouse){
//						td.innerHTML="";
//						set_grid2_month_times(td,bak_value,0,true);				
					}
				}
				
				if(isOneditChangeLength){
					if(!isMouse){
						td.innerHTML="";
						set_grid2_month_times(td,bak_value,0,true);
					}

				}
			}
			
			
//			显示资源信息
			getGrid1_ResDayInfo(td);
			
			
		}
		

}

	/**
	*	@desc: 
	*	@type: private
	*/

function getNextCell(acell, dir, i){
	
        var that = mygrid2; 
        
		acell=acell||that.cell;

		var arow = acell.parentNode;

		if (that._tabOrder){
			i=that._tabOrder[acell._cellIndex];

			if (typeof i != "undefined")
				if (i < 0)
					acell=that._nextRowCell(arow, dir, Math.abs(i)-1);
				else
					acell=arow.childNodes[i];
		} else {
			var i = acell._cellIndex+dir;

			if (i >= 4&&i < that._cCount-2){
				if (arow._childIndexes)
					i=arow._childIndexes[acell._cellIndex]+dir;
				acell=arow.childNodes[i];
			} else {

				acell=that._nextRowCell(arow, dir, (dir == 1 ? 4 : (that._cCount-3)));
			}
		}

		if (!acell){
			if ((dir == 1)&&that.tabEnd){
				that.tabEnd.focus();
				that.tabEnd.focus();
				that.setActive(false);
			}

			if ((dir == -1)&&that.tabStart){
				that.tabStart.focus();
				that.tabStart.focus();
				that.setActive(false);
			}
			return null;
		}

		//tab out

		// tab readonly
		if (acell.style.display != "none"
			&&(!that.smartTabOrder||!that.cells(acell.parentNode.idd, acell._cellIndex).isDisabled()))
			return acell;
		return getNextCell(acell, dir);
	// tab readonly

	}
	
	
	
	
	
	
	function close_search_adver_winWin(p,my_grid_matter,model){

		function adver_win_close_fun(matterOj){
				var ed_cindex = mygrid1.getColIndexById('edit');
				var len_cindex = mygrid1.getColIndexById('len');
				var resourceIds = new Array();
				var count = mygrid1.selectedRows.length;
				for(var i = 0; i< count;i++){
					var row_id =  mygrid1.selectedRows[i].idd;
		 			mygrid1.cells(row_id,ed_cindex).setValue(matterOj.edit);
					mygrid1.cells(row_id,len_cindex).setValue(matterOj.length);
					mygrid1.setUserData(row_id,"matterId",matterOj.id)
					var rsId = mygrid1.getUserData(row_id,"resourceId");
					
					var isNew =  (mygrid1.getUserData(row_id,"isNew") ==1);
					var isOneditChangeLength = false;
					if(!isNew){ //alert('2873 isNew>>'+ isNew);
					    var rows = orderBackUp.mygrid1.get(row_id); 
					    var bak_obj = rows[rows.length-1];
						var adLength_old = bak_obj.adLength;   
						if(adLength_old != matterOj.length) isOneditChangeLength = true; //alert('2873  res_obj.id>>'+  res_obj.id);
					}
//					alert('2873 isOneditChangeRes>>'+ isOneditChangeRes);
		
				mygrid1.setUserData(row_id,"isOneditChangeLength",isOneditChangeLength);
					
					
					
					if(rsId >0){
						resourceIds.push(rsId);
						reset_mygrid2_row(row_id,1);
						//alert(4081);
					}
		
				}
				
				if(resourceIds.length>0) setBasePrices(resourceIds,matterOj);
		}		
		
		

		if(p == 1 || p == 2){
   	   		var rowId =(p == 1)? my_grid_matter.getSelectedId():my_grid_matter.id;
   	   		var edit = (p == 1)?my_grid_matter.cells(rowId,2).getValue():my_grid_matter.edit;
   	   		var length = (p == 1)?my_grid_matter.cells(rowId,3).getValue():my_grid_matter.length;
      		var matterOj = {id:rowId,edit:edit,length:length};
			adver_win_close_fun(matterOj);
		}

		search_adver_win.hide();
	}
	
	function search_adver_cont(model){
		
		
		if(orderCkeckState == 1||orderCkeckState==3){
			var len_cindex = mygrid1.getColIndexById('len');	
			var count = mygrid1.selectedRows.length;
			var map = new HashMap();
			for(var i = 0; i< count;i++){
				var row_id =  mygrid1.selectedRows[i].idd;
	 			var len = mygrid1.cells(row_id,len_cindex).getValue();
	 			map.put(len,len);
			}
			var keyArr = map.keySet();   
			if(keyArr.length >1) {
				alert("换版的广告长度为("+keyArr.join(",")+"),订单在审核中或通过状态下，换版的广告长度必须统一，不能出现两种或两种以上的长度 ！") ;
				return false;
			}else{
				ad_length = keyArr[0];
			}
			
		}

		var matter_fin = new Matter();
		var industry_fin = new Industry();
		var customer_fin = new Customer();

	   	var custCmd =  toolbar.getComponent("customerName_for_paraArray");
		var  customerId = custCmd.getValue();	
		var customerName =  custCmd.getRawValue();	

		if(customerId =='') customerName ='';
		
		
   

		function callFunction(params){
	   	   	  document.getElementById('matteriframe').contentWindow.loadGridData(params);	        
	   	}  
	   	

      var urlStr= ctxPath + "selectPopup/selectMatters.html?orgId="+orgId+"&customerId="+customerId+"&version="+order_year;
       urlStr = urlStr + "&customerName="+customerName;
       urlStr = urlStr + "&model="+model;
       urlStr = urlStr + "&orderCkeckState="+orderCkeckState;
       urlStr = urlStr + "&adLength="+ad_length;


       
   if(!search_adver_win){

   	   var addNewBtn ={text: '新添素材',handler: function(){document.getElementById('matteriframe').contentWindow.save_new_matter();}};
   	   var closeBtn ={text: '关闭',handler:close_search_adver_winWin};
   	   var resetBtn ={text: '重置',handler:function(){document.getElementById('matteriframe').contentWindow.resetQueryWhere();}};
   	   var copyBtn ={text: '复制素材',handler:function(){document.getElementById('matteriframe').contentWindow.copyQueryWhere();}};
   	   customer_fin.obj.orgId = orgId;

//   	   var customerCmd = customer_fin.initCustomerCmd(matter_fin.obj,'search_adver_customer',null,'remote',null,'customerName',1,100,300,'请选择客户...',callFunction);
       var brandCmd = brand.getBrandCmd2(brand.obj,null,'search_brand_cmd',null,89,'品牌...','local',callFunction); 
       var industryCmd = industry_fin.getIndustryCmd(matter_fin.obj,'search_adver_brandId_cmd','search_adver_brandId_tree',true,null,config_industryLevelParam,'brandId','选择行业...',100,callFunction);
   	   var nameCmd = matter_fin.getCommandForSelect('search_adver_name','广告名称...','name',1,110,callFunction);
   	   var editCmd = matter_fin.getCommandForSelect('search_adver_edit','请输入广告版本...','edit',1,190,callFunction);
   	   var lengthCmd = matter_fin.getCommandForSelect('search_adver_len','长度...','length',1,70,callFunction);
   	   var tapecodeCmd = matter_fin.getCommandForSelect('search_adver_tapecode','磁带...','tapeCode',2,70,callFunction);
	   var matterTypeCmd = matterType.getMatterTypeCmd(matter_fin.obj,null,'search_adver_matterType','matterType',70,'分类...','local',callFunction);
	   

	   
	   search_adver_win =new Ext.Window({
			title:"素材库-(广告名称、广告版本可以用汉字声母查询，选择素材时用鼠标双击)",
			modal : true,
			resizable : false,
			closeAction:'hide',
			closable: true,
			width : 800,
			height :  parent.build_more_paraArray.getInnerHeight() - footerToolbar.getHeight()/5,
//			tbar:[tapecodeCmd,'-',nameCmd,'-',nameCmd,'-',editCmd,'-',lengthCmd,'-',industryCmd],
//			tbar:[customerCmd,brandCmd,nameCmd,editCmd,lengthCmd,tapecodeCmd,industryCmd,matterTypeCmd],
			tbar:[brandCmd,industryCmd,nameCmd,editCmd,lengthCmd,tapecodeCmd,matterTypeCmd],
			buttons: [addNewBtn,'-',closeBtn], 
			html:"<iframe id='matteriframe' src='"+ urlStr +"' scrolling='auto' style='width:100%;height:100%;border 0px none;scrollbar:true;margin:0;padding:0'></iframe>"
//			contentEl : Ext.DomHelper.append(document.body, {
//			    tag : 'iframe',
//			     id : 'matteriframe',
//			    style : "border 0px none;scrollbar:true",
//			    src : urlStr,
//			    height : "100%",
//			    width : "100%"
//			   })
		});
		
		 search_adver_win.on({'close': {fn: close_search_adver_winWin}});

   }else{
	   var adver_len_cmd = search_adver_win.getTopToolbar().getComponent('search_adver_len');
	   adver_len_cmd.setRawValue(ad_length);
	   adver_len_cmd.setValue(ad_length);
//	   alert(adver_len_cmd.onTrigger1Click)
//	   adver_len_cmd.un("clear",adver_len_cmd.onTrigger2Click);
	   
	   var params={length:ad_length};
	   document.getElementById('matteriframe').contentWindow.loadGridData(params);
      
//	   adver_len_cmd.fireEvent("onclick");
//	   adver_len_cmd.fireEvent("onchange");
   }
   
	
   	search_adver_win.show(this);
//   	mygrid2.setActive(true);
//   	mygrid2._still_active=true;

//	mygrid2.onbeforeactivate();

//    mygrid2.onbeforeactivate();
//	mygrid2.setActive(true);

}

function reset_orderCategoryMain(cmd,value){

//	orderCategoryMain = getSelectParamFromAttribute(e,"calculateauto");//根据付款分配应收
	orderCategoryMain = getValueFromStoreById(cmd,"calculateAuto");
//	orderCategoryMain = getSelectParamFromAttribute(e,"calculateauto");//根据付款分配应收



	var ordersubcate_index = mygrid1.getColIndexById('ordersubcate');

	function callBakFun(){
		 
		var command = mygrid1.getCombo(ordersubcate_index);

		if(orderCategoryMain != 0){
				parent.document.getElementById("paymoney_for_paraArray").readOnly = true;
		}else{
				parent.document.getElementById("paymoney_for_paraArray").readOnly = false;
		}
	
		for(var i = 0;i<mygrid1.getRowsNum();i++){
			var grid1_row_id = mygrid1.getRowId(i);
			var calculateauto_key = mygrid1.cells(grid1_row_id,ordersubcate_index).getValue();
			var calculateauto = command.calculateauto[calculateauto_key];			
			reset_grid1_sumPay(grid1_row_id,0,true,calculateauto); 
			reset_grid1_totalTime();
			mygrid1.cells(grid1_row_id,ordersubcate_index).setValue(0);
		}
	}
	
	getSpecCmd(ordersubcate_index,callBakFun);


}


function reset_grid1_totalTime(){
	var sumTime_cindex = mygrid1.getColIndexById('sumTime');
	var totalTime= 0;			
	for (var j = 0; j <mygrid1.getRowsNum(); j++){	
		var v = mygrid1.cells2(j,sumTime_cindex).getValue(); 
		v = v ==""?0:v;
		totalTime = totalTime +v*1;
	}
	
	 if(config_resourceUseCustomerCatelog){
		 if(mygrid1.getRowsNum() > 0 || totalTime>0){
			  toolbar.getComponent("customerName_for_paraArray").setDisabled(true);
		 }else{
			  toolbar.getComponent("customerName_for_paraArray").setDisabled(false);
		 }
	 }


	parent.document.getElementById("totalTime_for_paraArray").value = totalTime;
}


function setAutoPrice2(colIndex,value){
//	Ext.MessageBox.prompt('修改价格', '', function(btn,value) {
//		if (btn == 'ok') {
			if(!isDigit(value)) return false; 
			var ordersubcate_index = mygrid1.getColIndexById('ordersubcate');	
			var command = mygrid1.getCombo(ordersubcate_index);
			var rows = mygrid1.selectedRows;
			for(var i = 0;i<rows.length;i++){
				var rowId = rows[i].idd;
				var calculateauto_key = mygrid1.cells(rowId,ordersubcate_index).getValue();
				var calculateauto = command.calculateauto[calculateauto_key];
				mygrid1.cells(rowId,colIndex).setValue(value); 
				reset_grid1_sumPay(rowId,0,true,calculateauto); 
			}
//		}
		
//		else{
//			return false; 	
//		}
//	});

}


function setAutoBroArray(){
	
	function handleActivate(tab){
		
//		console.log( Ext.getCmp('mainRadiogroup'))
		
		if(tab.id == 'mainTab_1'){
			  Ext.getCmp('mainRadiogroup').setValue(2);//把是选中
		}
		if(tab.id == 'mainTab_2'){
			Ext.getCmp('mainRadiogroup_week').reset();
 			Ext.getCmp('mainRadiogroup').setValue(3);//把是选中
		}
		if(tab.id == 'mainTab_3'){
			Ext.getCmp('mainRadiogroup_month').reset();
 			Ext.getCmp('mainRadiogroup').setValue(4);//把是选中
		}	

//        alert(tab.title + ' was activated.');
    }

    var radioGroup_one_two = {
            xtype: 'radiogroup',
            id:'mainRadiogroup_one_two',
            labelWidth: 60,
            items: [
            	{boxLabel: '单日', name: 'rb-auto', inputValue: 1 ,checked: true},
            	{boxLabel: '双日', name: 'rb-auto', inputValue: 2}
            ]
        };  
        
//        var weekCom = myUtils.getComWeek("bro_week","星期",45,1);
//        alert(weekCom)


		var checkboxgroup_week ={
            xtype: 'checkboxgroup',
            id:'mainRadiogroup_week',
            items: [
                {boxLabel: '星期一', name: 'cb-week-1', inputValue:'1'},
                {boxLabel: '星期二', name: 'cb-week-2', inputValue:'2'},
                {boxLabel: '星期三', name: 'cb-week-3', inputValue:'3'},
                {boxLabel: '星期四', name: 'cb-week-4', inputValue:'4'},
                {boxLabel: '星期五', name: 'cb-week-5', inputValue:'5'},
                {boxLabel: '星期六', name: 'cb-week-6', inputValue:'6'},
                {boxLabel: '星期日', name: 'cb-week-0', inputValue:'0'}
            ]
        };
        
      function monthCheckboxActivate(checkBox,checked){
      	var objs = Ext.getCmp('mainRadiogroup_month').getValue();
      	if(objs.length == 0){
      		setDateFiled();
      	}else{
      		setDateFiled(2);
      	}
    
      }
  
  		var checkboxgroup_month ={
            xtype: 'checkboxgroup',
            id:'mainRadiogroup_month',
            columns: 6,
            items: [
                {boxLabel: '一月', name: 'cb-month-1', inputValue:'1' ,listeners: {check: monthCheckboxActivate}},
                {boxLabel: '二月', name: 'cb-month-2', inputValue:'2' ,listeners: {check: monthCheckboxActivate}},
                {boxLabel: '三月', name: 'cb-month-3', inputValue:'3' ,listeners: {check: monthCheckboxActivate}},
                {boxLabel: '四月', name: 'cb-month-4', inputValue:'4' ,listeners: {check: monthCheckboxActivate}},
                {boxLabel: '五月', name: 'cb-month-5', inputValue:'5' ,listeners: {check: monthCheckboxActivate}},
                {boxLabel: '六月', name: 'cb-month-6', inputValue:'6' ,listeners: {check: monthCheckboxActivate}},
                {boxLabel: '七月', name: 'cb-month-1', inputValue:'7' ,listeners: {check: monthCheckboxActivate}},
                {boxLabel: '八月', name: 'cb-month-2', inputValue:'8' ,listeners: {check: monthCheckboxActivate}},
                {boxLabel: '九月', name: 'cb-month-3', inputValue:'9' ,listeners: {check: monthCheckboxActivate}},
				{boxLabel: '十月', name: 'cb-month-4', inputValue:'10' ,listeners: {check: monthCheckboxActivate}},
                {boxLabel: '十一月', name: 'cb-month-4', inputValue:'11' ,listeners: {check: monthCheckboxActivate}},
                {boxLabel: '十二月', name: 'cb-month-5', inputValue:'12' ,listeners: {check: monthCheckboxActivate}},
            ]
        };      
        
        
      var fieldset_one_two = {
            xtype:'fieldset',
             title: '1 ',
            checkboxToggle:false,
//            autoHeight:true,
			height:80,
            defaultType: 'textfield',
            collapsed: false,
            items :[radioGroup_one_two]
        }  
        
         var fieldset_week = {
            xtype:'fieldset',
             title: '1',
             layout: 'fit',
//            checkboxToggle:true,
//            autoHeight:true,
			height:80,
            defaultType: 'checkbox',
            collapsed: false,
            items :[checkboxgroup_week]
        }       
        var fieldset_month = {
            xtype:'fieldset',
             title: '1',
             layout: 'fit',
//            autoHeight:true,
			height:80,
            defaultType: 'checkbox',
            collapsed: false,
            items :[checkboxgroup_month]
        }                  
        
        
        
   var tabPanel = new Ext.TabPanel({
//        activeTab: 0,
        plain:true,
        id:"mainTab",
        defaults:{autoScroll: true},
        items:[{
                title: '单双日',
                id:"mainTab_1",
                items:[fieldset_one_two],
//                html: "My content was added during construction.",
//                disabled:true,
                listeners: {activate: handleActivate}
            },{
                title: '星期',
                id:"mainTab_2",
				items:[fieldset_week],
//                 disabled:true,
                 listeners: {activate: handleActivate}
            },{
                title: '月份',
                id:"mainTab_3",
				items:[fieldset_month],
//                  disabled:true,
                  listeners: {activate: handleActivate}
            }
        ]
    });
    
    
    
    
     var def_Date_start =   myUtils.parseDate2(getFormatDay(startDate2,"y-m-d"));
	 var def_Date_end =    myUtils.parseDate2(getFormatDay(endDate1,"y-m-d"));  
	 var timeCom = myUtils.getComMonth("bro_timssss","次数",45,1);
	 var starDateItem =  { fieldLabel: '开始日期',
			        name: 'startdt',
			        id: 'startdt',
			        xtype:'datefield',
			        format : 'Y-m-d',
			         anchor:'95%',
			        endDateField: 'enddt',// id of the end date field
			        enableKeyEvents : true,
			        value:def_Date_start
			      	};
	var endDateItem = {fieldLabel: '结束日期',
							        name: 'enddt',
							        id: 'enddt',
							        xtype:'datefield',
							        format : 'Y-m-d',
							         anchor:'95%',
							        startDateField: 'startdt', // id of the start date field
							        value:def_Date_end
					};		      	
	 
//	 alert(def_Date_start)


     var fieldset_week = {
            xtype:'fieldset',
            checkboxToggle:false,
//            title: '投放期间',
            autoHeight:true,
//            height:300,
//            defaults: {width: 210},
            defaultType: 'textfield',
            collapsed: false,
            items :[{title: 'Normal Tab',html: "My content was added during construction."}]
        }   

   	var listeners_opt = {check : function(checkbox, checked) {if (checked) {displayModel =1;search();  }}}  ; 
	var handler =  function(checkbox, checked) {if(checked){
	   	var groupValue = checkbox.getGroupValue();
		var tabs = Ext.getCmp("mainTab");  
		
		
		
	    tabs.setDisabled(false)
	   	if(groupValue == 2 ){tabs.setActiveTab(0);}
	    if(groupValue == 3 ){tabs.setActiveTab(1);} 
		if(groupValue == 4 ){tabs.setActiveTab(2);} 
		if(groupValue == 1 || groupValue == 5 ){
			tabs.setDisabled(true);
		}
		//月份及全年

		//月份及全年
		if(groupValue == 5){ 
			setDateFiled(1);
		}		
		
   	}};       
   var radioGroup_main = {
            xtype: 'radiogroup',
            id:'mainRadiogroup',
            labelWidth: 60,
            fieldLabel: '选择模式',
            items: [
            	{boxLabel: '每天', name: 'rb-auto', inputValue: 1 ,checked: true,handler:handler},
            	{boxLabel: '单双日', name: 'rb-auto', inputValue: 2,handler:handler},
            	{boxLabel: '星期', name: 'rb-auto', inputValue: 3,handler:handler},
            	{boxLabel: '月份', name: 'rb-auto', inputValue: 4,handler:handler},
                {boxLabel: '全年', name: 'rb-auto', inputValue: 5,handler:handler}
            ]
        };      
        
   var fp_bbar = new Ext.FormPanel({
        frame: true,
        labelWidth: 50,
        width: 480,
        bodyStyle: 'padding:0 10px 0;',
        items: [radioGroup_main]
    });     

   var win_tbar = new Ext.FormPanel({
		labelWidth: 40,
		labelAlign: 'right', //'top'
        frame:true,
        bodyStyle:'padding:5px 5px 0',
        width: 500,
        bbar:fp_bbar,
        items: [{
            layout:'column',
            items:[
	            {
	                columnWidth:.4,
	                layout: 'form',
	                items: [starDateItem]
	            },{
	                columnWidth:.4,
	                layout: 'form',
	                items: [endDateItem]
	            },{
	                columnWidth:.2,
	                layout: 'form',
	                labelWidth: 30,
	                items: [timeCom]
	           	  }
            ]
        }]
    });


	function getAuoArraySelectedValue(mode){
		var selectValue = new Array();
		if(mode == 2){selectValue = [Ext.getCmp('mainRadiogroup_one_two').getValue().inputValue];} //单双日
		if(mode == 3){selectValue = getCheckboxgroupValue('mainRadiogroup_week');} //星期
		if(mode == 4){selectValue  = getCheckboxgroupValue('mainRadiogroup_month');} //月份
		return selectValue;
	}

 	if(!auto_bro_array_win){
 		var closeFun = function(){
 			auto_bro_array_win.destroy();
 			auto_bro_array_win = null;
 		};
		var btnSave = {text: '确定',handler: function(){

				var startDate = Ext.getCmp('startdt').getValue();
				var endDate = Ext.getCmp('enddt').getValue();
				var times = Ext.getCmp('bro_timssss').getValue();
				var mode = Ext.getCmp('mainRadiogroup').getValue().inputValue;
				var selectValue = getAuoArraySelectedValue(mode);
				
				
				if(compagesDiaWin){
						if(!compagesDiaWin.hidden){
							var model = carrierType.tree.model;

							if(model == 2){
								var newIdArray = new Array();
								newIdArray = clos_win_res_tree(model,true);
								mygrid1.clearSelection();
								for(var i = 0;i<newIdArray.length;i++){
	//								mygrid1.selectRowById(newIdArray[i]);
									var row = mygrid1.getRowById(newIdArray[i]);
									mygrid1.selectRow(row, false, true, false);
								}	
							}else{
								clos_win_res_tree(model,true);
							}

							
						}
				}
				
			
			
				fillBroArrange(mygrid1,mygrid2,startDate,endDate,times,mode,selectValue);

				closeFun();				

			} 
		};
		var btnClose = {text: '关闭',handler: closeFun };
		auto_bro_array_win = new Ext.Window({
				title:"自动配置",
				modal : true,
				resizable : false,
				closeAction:'destroy',
				closable: true,
				width : 500,
				height : 270, 
				items:[tabPanel],
				tbar:[win_tbar],
				buttons: [btnSave,'-',btnClose], 
	
			});   		
 	}

	auto_bro_array_win.show(this);
	initPosition_auto_bro_array_win();
//	mygrid2.setActive(true);
}

function fillBroArrange(grid1,grid2,startDt,endDt,times,mode,selectValue){	
	var s_cindex = grid1.getColIndexById('start');
	var e_cindex = grid1.getColIndexById('end');
	var startDate = myUtils.formatDateSimple(startDt,'');
	var endDate = myUtils.formatDateSimple(endDt,'');   
	
	
				

	var rows = grid1.selectedRows;
	
	
	
	var rowCount = rows.length;
	
	
	for (var i = 0; i < rowCount; i++){
		
		var rowId1 = rows[i].idd;

		 startDate = getFormatDay(startDate,'y/m/d');
		 endDate = getFormatDay(endDate,'y/m/d');
		 
		grid1.cells(rowId1,s_cindex).setValue(startDate);
		grid1.cells(rowId1,e_cindex).setValue(endDate);
		
//		var rowId2s =  getRowByUserData(grid2,"grid1_rowId",rowId1);
//		for (var j = 0; j < rowId2s.length; j++){
//			mygrid2.deleteRow(rowId2s[j]); 
//		}
		
		var new_arr = get_bro_arr_by_grid1rowid(rowId1,startDt,endDt,times,mode,selectValue);

	
		reset_mygrid2_row(rowId1,4,null,new_arr);

	} 	
	    
}

 function get_bro_arr_by_grid1rowid(rowId1,startDt,endDt,times,mode,selectValue){
	var new_arr = new Array();  
	var yearDiff = endDt.getFullYear() - startDt.getFullYear();
	var monthDiff = myUtils.monthDiff(startDt,endDt);
	
	var startDate = myUtils.formatDateSimple(startDt,'');
	var endDate = myUtils.formatDateSimple(endDt,''); 

	var start_year =  startDt.getFullYear();
 	var start_month =  startDt.getMonth()+1;

 	var mm = ""; 
 	var dd = "";  
 	var isMatch =false;

    for(var y = 0; y < yearDiff + 1;y++){
    	
		for(var i = 0;i< (monthDiff+1);i++){

	
			new_arr[i] = new Array();  
			mm = start_month<10?'0'+start_month:start_month;

			for(var j = 0 ;j < 31;j++){
				dd = j<9?'0'+(j+1):j+1;
	            var day =   start_year +''+ mm +''+dd;
	            isMatch = false;
	              
	            if(mode == 2){ //单双
	            	var oneOrtwo = selectValue[0]==1?1:0;
	            	if((j+1)%2 == oneOrtwo && day*1 >= startDate*1 && day*1 <= endDate*1){
	            		new_arr[i][j] = day+'_'+times; isMatch = true;
	            	}
	            }else if(mode == 3){ //星期
	            	var dd_week = new Date(start_year, start_month-1, j+1, 0, 0, 0);
	            	var week = ''+dd_week.getDay();
	            	
	            	if(selectValue.contains(week) && day*1 >= startDate*1 && day*1 <= endDate*1){
	            		new_arr[i][j] = day+'_'+times; isMatch = true;
	            	}	            	
	            }else if(mode == 4){ //月份
	            	if(selectValue.contains(''+start_month) && day*1 >= startDate*1 && day*1 <= endDate*1){
	            		new_arr[i][j] = day+'_'+times; isMatch = true;
	            	}	            	
	            }else{
	            	if(day*1 >= startDate*1 && day*1 <= endDate*1){
	            		new_arr[i][j] = day+'_'+times; isMatch = true;
	            	}	  
	            }	            
	            
	            if(!isMatch)new_arr[i][j] = day+'_0';

			}	
			
			start_month  += 1;			
		}
		start_year += 1;
    }

	
	return new_arr;	
}  
function getCheckboxgroupValue(id) {
	var objs = Ext.getCmp(id).getValue();
	var v = [];
	for (var i = 0; i < objs.length; i++) {
		if (objs[i].checked) { v.push(objs[i].inputValue);}
	}
	return v;
}     
function getLastDateOfMonth(Year,Month){
	 return(new Date((new Date(Year, Month+1,1))-1));
}
function setDateFiled(mode){
			var startDt =  Ext.getCmp('startdt');
			var endDt =  Ext.getCmp('enddt');
			var d1 = new Date();
			var d2 = new Date();	
			
			if(mode == 1){
				 var year = startDt.getValue().getFullYear();
				 d1 = new Date(year,"0","1");
				 d2 = new Date(year,"11","31");	
			}else if(mode == 2){
				var selectValue  = getCheckboxgroupValue('mainRadiogroup_month');
				var min =  startDt.getValue().getMonth();
				var max =  endDt.getValue().getMonth();
				
				var yy1 = startDt.getValue().getFullYear();
				var dd1 = startDt.getValue().getDate();
				
				var yy2 = endDt.getValue().getFullYear();
				var dd2 = endDt.getValue().getDate();	
				
			
//				alert(selectValue.length)
								 
				if(selectValue.length>0){
					 max = Math.max.apply(Math,selectValue);
					 min = Math.min.apply(Math,selectValue); 
				}
				
//				alert("mode_"+mode+"_selectValue"+selectValue+"_max"+ max +"_min "+min)
//				endDt.getValue().getLastDateOfMonth()
				
//				 d1 = new Date(yy1,min-1,dd1);
//				 d2 = new Date(yy2,max-1,dd2);	
				 d1 = new Date(yy1,min-1,1);
				 d2 = getLastDateOfMonth(yy2,max-1);	
				 
			}else{
				
				 var startDate1 = _app_params.serviceDate.defStartDate;
				 var endDate = _app_params.serviceDate.defEndDate;

				 var yy1 = startDate1.substring(0,4);
				 var mm1 = startDate1.substring(4,6);
				 var dd1 = startDate1.substring(6,8);
				 
				 var yy2 = endDate.substring(0,4);
				 var mm2 = endDate.substring(4,6);
				 var dd2 = endDate.substring(6,8);		
			 
				 d1 = new Date(yy1,mm1-1,dd1);
				 d2 = new Date(yy2,mm2-1,dd2);
			}

			
			
			startDt.setValue(d1);
			endDt.setValue(d2);       
      }   
 
	function getMonthFrom_bak_arr(bak_arr){
		var arr = new Array();
 			var map = new HashMap();
	        	for(var i = 0;i< bak_arr.length;i++){
	        		for(var j = 0;j<31;j++){
		        		var cellIndex = j+4;
//                        alert(cellIndex+ '_'+ j)
						var vvv =  bak_arr[i][j];
						if(vvv){
			        		var values = vvv.split('_');
			        		var value_day = values[0];
			        		var value = values[1];
							if(value*1 >0){
								map.put(value_day.substring(0,6),value);
							}	
						}

	        		}
	        	}
	        	
	        	
	      arr = map.keySet();   
	  
	      arr = arr == null?[]:arr;
	      return arr; 
	}
		
		
		



function getSpecificTreeWin() {

	if(!specific_tree_win){

 		var closeFun = function(){
 			specific_tree_win.hide(this);
 		};		

		var btnClose = {text: '关闭',handler: closeFun }; 

		specific_tree_win = new Ext.Window({
			   title : '选择指定',
			   width : 400,
			   height : parent.build_more_paraArray.getInnerHeight() - footerToolbar.getHeight()/5,
			   isTopContainer : true, 
			   modal : true,
			   closeAction:'hide',
			   resizable : false,
			   buttons: [btnClose],
			   contentEl : $("specificTreebox2")
		}); 		

		initSpecificTree();
	}
 	
	specific_tree_win.show(this);
} 


function showOrderSubCate_prompt_whith_comboBox(func){
	var ordersubcate_index = mygrid1.getColIndexById('ordersubcate');	
	var command = mygrid1.getCombo(ordersubcate_index);
	var objs = command.getKeys();
	var data = [];
	for(var i = 0;i < objs.length; i++){
		var key =objs[i];
		var value = command.get(key);
		data.push([key,value]);
		} 
	var store = new Ext.data.SimpleStore({ fields: ['id', 'name'],data : data });  
    Ext.Msg.show({
        title: '类别',
        buttons: Ext.MessageBox.OKCANCEL,
        combo: true,
        comboConfig:
        {
            typeAhead: true,
            displayField: 'name',
            valueField:'id',
            store: store,
            mode: 'local',
            triggerAction: 'all',
            forceSelection: true
        },
        fn: function(buttonId, text)
        {
         if (buttonId == 'ok')
                func(text);
//                Ext.Msg.alert('Your Choice', 'You chose: "' + text + '".');
        }
    });

}




//function setAutoPrice(colIndex){
//	Ext.MessageBox.prompt('修改价格', '', function(btn,value) {
//		if (btn == 'ok') {
//			if(!isDigit(value)) return false; 
//			var ordersubcate_index = mygrid1.getColIndexById('ordersubcate');	
//			var command = mygrid1.getCombo(ordersubcate_index);
//			var rows = mygrid1.selectedRows;
//			for(var i = 0;i<rows.length;i++){
//				var rowId = rows[i].idd;
//				var calculateauto_key = mygrid1.cells(rowId,ordersubcate_index).getValue();
//				var calculateauto = command.calculateauto[calculateauto_key];
//				mygrid1.cells(rowId,colIndex).setValue(value); 
//				reset_grid1_sumPay(rowId,0,true,calculateauto); 
//			}
//		}else{
//			return false; 	
//		}
//	});
//}



function setAutoPrice(colIndex){

 	var value = window.prompt("修改价格：","");
 	
	if(!isDigit(value)) return false; 
	
			var ordersubcate_index = mygrid1.getColIndexById('ordersubcate');	
			var command = mygrid1.getCombo(ordersubcate_index);
			var rows = mygrid1.selectedRows;
			for(var i = 0;i<rows.length;i++){
				var rowId = rows[i].idd;
				var calculateauto_key = mygrid1.cells(rowId,ordersubcate_index).getValue();
				var calculateauto = command.calculateauto[calculateauto_key];
				mygrid1.cells(rowId,colIndex).setValue(ForDight(value,2)); 
				reset_grid1_sumPay(rowId,0,true,calculateauto); 
			} 	
 	
    
}




function showAutoPrice_prompt_whith_comboBox(index,func){
	var ordersubcate_index = mygrid1.getColIndexById('ordersubcate');	
	var command = mygrid1.getCombo(ordersubcate_index);

	var data = [];
	var store = new Ext.data.SimpleStore({ fields: ['id', 'name'],data : data });  
    Ext.Msg.show({
        title: '类别',
        buttons: Ext.MessageBox.OKCANCEL,
        combo: true,
        comboConfig:
        {
            typeAhead: true,
            displayField: 'name',
            valueField:'id',
            store: store,
            mode: 'local',
            triggerAction: 'all',
            forceSelection: true
        },
        fn: function(buttonId, text)
        {
         if (buttonId == 'ok')
                func(text);
//                Ext.Msg.alert('Your Choice', 'You chose: "' + text + '".');
        }
    });

}




function set_spec_to_grid1(spec_id,apppos_cindex){
		var count = mygrid1.selectedRows.length; 
		for(var i = 0; i< count;i++){
			var row_id =  mygrid1.selectedRows[i].idd;
 			mygrid1.cells(row_id,apppos_cindex).setValue(spec_id);
//			mygrid1.setUserData(row_id,"pos",res_obj.resourceMemo)
			reset_mygrid2_row(row_id,1);
		}
}
 


function initSpecificTree(){
	specific.tree = new Tree("specificTreebox2");  
	var obj_tree = specific.tree.dhtmlTree;	
	obj_tree.setImagePath(ctxPath+"scripts/dhtml/2.6/dhtmlxTree/codebase/imgs/");
	
//	function doOnSelect(itemId){
// 		if(itemId == "root") return false;
//	}
//	obj_tree.setOnClickHandler(doOnSelect);//set function to call on dbl click	
		function doOnDblClick(itemId){
			if(itemId == "root") return false;
			specific_tree_win.hide(this);
			var position = obj_tree.getUserData(itemId,"position");
			var apppos_cindex = mygrid1.getColIndexById('apppos');
			set_spec_to_grid1(itemId,apppos_cindex);
		}
	obj_tree.setOnDblClickHandler(doOnDblClick);
	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	
	var getxml = function(strXML){		
//		obj_tree.deleteChildItems(0);
		obj_tree.loadXMLString(strXML);   
		Ext.getBody().unmask(); 
	}
	
	specific.getSpecificsXML(getxml);
}







var orderPublic = new OrderPublic();
var orderDetail = new OrderDetail();
var user = new User();

//检测是否有空值
function checkOrder(){ 
	
	var custCmd =  toolbar.getComponent("customerName_for_paraArray");
	var userCmd =  toolbar.getComponent("userId_for_paraArray");
	if(custCmd.getValue() == ''){extjMessage('客户名称为空!不允许保存!');return false;};
    var userName =   userCmd.getRawValue();
    var uid = userCmd.getValue();
    
     if(userName == uid  &&  uid !=''){
    	user.displayUsersBranchs(loginUserId,orgId,userName,userCmd,save_more_orderDetail);
    	return false;
    } 
    
    if(uid =='') {
		Ext.MessageBox.hide(); 
	    Ext.MessageBox.show(
			{title:'系统提示',msg:'没选择业务员,不允许保存!',width:300,heigth:200,buttons: Ext.Msg.OK, icon: Ext.MessageBox.INFO,fn:function callBack(id) {
				userCmd.onTriggerClick();
			} }
		); 		
    	return false;
    	
    };   

	var customerId = custCmd.getValue();	
	var customerName =  custCmd.getRawValue();	

	if(customerId == customerName){checkCustomer(1);return false;}
	
  
	  for(var i = 0;i< mygrid1.getRowsNum();i++){
	  		var row_id = mygrid1.getRowId(i);
	 		var ordersubcate_cindex = mygrid1.getColIndexById('ordersubcate');
	 		var ordersubcateId =  mygrid1.cells(row_id,ordersubcate_cindex).getValue();	
			if(ordersubcateId ==0||ordersubcateId ==''){
//				alert('订单类型不能为空');return false;
				 extjMessage('订单类型不能为空');return false;

			}
	 }   
  
  
    


	return true;
}


function isChangedOrder(orderBackUp,curOrder){
	
	if(orderBackUp.customerId != curOrder.customerId){
		return true;
	}
	if(orderBackUp.categoryId != curOrder.categoryId){
		return true;
	}
	if(orderBackUp.orderCategoryMain != curOrder.orderCategoryMain){
		return true;
	}
	if(orderBackUp.userId != curOrder.userId){
		return true;
	}
	if(orderBackUp.orderPublic.moneyRealpay != curOrder.orderPublic.moneyRealpay){
		return true;
	}
	return false;
}

		
function save_more_orderDetail(opt){
	
	
	
	

//	alert(changeRowIds.split(mygrid1.delim));
//	alert(changeRowIds.split(mygrid1.delim).length);
	
	var order = new Order();
	var isPass = checkOrder();
	if(!isPass) {return false;};
	var obj = order.obj;


//	var relation_code = parent.document.getElementById("relationCode_for_paraArray").value;
	var customerId = toolbar.getComponent("customerName_for_paraArray").getValue();
	var customerId = toolbar.getComponent("customerName_for_paraArray").getValue();
	var userId = toolbar.getComponent("userId_for_paraArray").getValue();
	var year = toolbar.getComponent("year_for_paraArray").getValue();
	var categoryId = toolbar.getComponent("categoryId_for_paraArray").getValue();
	var orderCategoryMain = getValueFromStoreById(toolbar.getComponent("categoryId_for_paraArray"),"calculateAuto");
	var customerCategoryId  = getValueFromStoreById(toolbar.getComponent("customerName_for_paraArray"),"customerCategoryId");
	var relationCode = parent.document.getElementById("relationCode_for_paraArray").value;
	
	
	obj.tempStr = orgId +","+ resource_sort +","+ customerCategoryId;
	
//	alert(obj.tempStr);  
	

	obj.id = order_id>0?order_id:null;
//	obj.orderCode = isOrderEditState?order_code:null; 
	obj.orderCode = order_id>0?order_code:null; 
	obj.relationCode = relationCode;  
	obj.orgId = orgId;
	obj.customerId = customerId;
	obj.isCkecked = "0";
	obj.version = order_year;
	obj.contractId =  0;
	obj.paymentId =  0;
	obj.categoryId =  categoryId;
	obj.userId = userId;	
	obj.createBy = loginUserId;
	obj.modifyBy = loginUserId;
	obj.publishMemo = null;
	obj.orderCategoryMain = orderCategoryMain;
	obj.isCkecked = 0;
	obj.isDisplayMonDetail = isDisplayMonDetail?5:4;
	obj.orderPublic = new OrderPublic();
	var moneyRealpay =  parent.document.getElementById("paymoney_for_paraArray").value;
	obj.orderPublic.moneyRealpay = moneyRealpay ==''?0:moneyRealpay;
	
	obj.customer =  (new Customer()).obj;
	obj.customer.customerName  = toolbar.getComponent("customerName_for_paraArray").getRawValue();
	

//	obj.orderDetails =  get_order_details(obj);
//	alert(obj.toSource())
//	var orderDetailsObj = get_order_details(obj);

	obj.orderDetailsObj = get_order_details(obj,opt);
	
//	alert(opt+">>"+obj.orderDetailsObj.length)
	
//	if(!orderBackUp.orderDetailsObj) {
//		alert('4889>>opt>>'+orderBackUp) 
//
//		orderBackUp.orderDetailsObj  = new Array();
//		var orderDetails = new Array();
//		orderDetails.push((new OrderDetail()).obj);
//		orderBackUp.orderDetailsObj = orderDetails;
//	}
	
//	alert(opt)
//	alert(obj.orderDetailsObj.length)

//    if(obj.orderDetailsObj.length ==0) 	return false;
	
	if(opt != 1 && obj.orderDetailsObj.length ==0){
		if(!isChangedOrder(orderBackUp,obj)){
			return false;
		}
	}
	
	
	if(obj.orderDetailsObj.length == 0){
		if(opt == 1){
			return obj;
		}
	}
	
	

//	console.log(obj);
//	alert(obj.toSource())
	

	
//	if(obj.orderDetailsObj.length == 0){
//		if(opt == 1){
//			return obj;
//		}
//	}

	var saveOrderFun = function(or){
		
//		      alert('5007>>fromModel>>'+fromModel)

				/*
				 if(fromModel == 1){  //订单编辑
					 var url = parent.location.href;
				     var param = $H(url.toQueryParams());
				     param.set("id",or.id);
					 url =  ctxPath + "editOrder.html?" + param.toQueryString();	
					 parent.location.href = url;
					 parent.build_more_paraArray.destroy();
				}
			
				if(fromModel == 2){//订单浏览
					 var url = parent.location.href;
					 var param = $H(url.toQueryParams());
					 url =  ctxPath + "editOrder.html?id=" + or.id  +"&orgId=1";	
					 parent.location.href = url;
					 parent.build_more_paraArray.destroy();
				}				
				
				*/	
				
//				if(fromModel == 2){//订单浏览
//					 parent.fromEditRowId = or.id;
//					 parent.refrshOrderList();
//				}	

		
				Ext.getBody().unmask(); 
				
//				alert('4961>>fromModel>>'+fromModel)
//				alert('4961>>or.id>>'+or.id)
//				alert('4961>>obj.id>>'+obj.id)
				
				if(obj.id != or.id){
					order_id = or.id;
					order_code = or.orderCode;
					isOrderEditState = true;
					parent.document.getElementById("orderCode_for_paraArray").value = order_code;
					
					Ext.MessageBox.hide(); 
					
				    Ext.MessageBox.show(
						{title:'系统提示',msg:'订单保存完毕! <br>新订单号为：[' + or.orderCode +']',width:350,heigth:230,buttons: Ext.Msg.OK, icon: Ext.MessageBox.INFO,fn:function callBack(id){

							
							/*								
							   if(fromModel == 3){
								 	 url =  ctxPath + "editOrder.html?id=" + or.id +"&orgId=1";	
									 parent.location.href = url;
									 parent.build_more_paraArray.destroy();								 	
								}
*/
							
							
//								parent.mygrid.setSelectedRow(or.id);
//								parent.build_more_paraArray.destroy();
						} }
					); 	
				   
				   
					
	
				}
				
				//保存后停留在原界面
				var curSelectedRows =  mygrid1.selectedRows;
//				mygrid2.clearAll();
				getOrderDetails_to_mygrid1(or.id,true,curSelectedRows);
				rebackBroArrange.show();
				reset_grid1_totalTime();
         
         
	}
	if(opt == 1){
		return obj;
	}else{
		Ext.getBody().mask('数据加载中……', 'x-mask-loading');
		
//		alert('4980>>'+orderBackUp);
		
//		if(orderBackUp)
	
		order.saveOrderMoreDetails(obj,orderBackUp,saveOrderFun);
	}


}	



//orderId,year,customerId,userId
function get_order_details(or_obj,opt){

	var orderDetail_objs = new Array();

	var objs = new Array();
	
//	var alerayApppos = false;
	var mapApppos = new HashMap();
	var mapApppos2 = new HashMap();

	var apppos_cindex = mygrid1.getColIndexById('apppos');
	var sumPay_cindex = mygrid1.getColIndexById('sumPay');
	var ordersubcate_cindex = mygrid1.getColIndexById('ordersubcate');
	var realPrice_cindex = mygrid1.getColIndexById('realPrice');
	var sumTime_cindex = mygrid1.getColIndexById('sumTime');
	var stantPrice_cindex = mygrid1.getColIndexById('stantPrice'); 
	var favace_cindex = mygrid1.getColIndexById('favace');
	var appRae_cindex = mygrid1.getColIndexById('appRae');
	var balance_cindex = mygrid1.getColIndexById('balance');
	var len_cindex = mygrid1.getColIndexById('len');	
	var start_cindex = mygrid1.getColIndexById('start');
	var end_cindex = mygrid1.getColIndexById('end');	
	var edit_cindex = mygrid1.getColIndexById('edit');
	
//	var categoryIdSelect = parent.document.getElementById("categoryId_for_paraArray"); 
//	var orderCategoryMain = getSelectParamFromAttribute(categoryIdSelect,"calculateauto");//根据付款分配应收	
	
//	var categoryIdSelect = toolbar.getComponent("categoryId_for_paraArray").getValue();
	
//	var orderCategoryMain = toolbar.getComponent("categoryId_for_paraArray").store.getrec;//根据付款分配应收		

    var orderCategoryMain = or_obj.orderCategoryMain;
	var appposCmd = mygrid1.getCombo(apppos_cindex);
	var ordersubcateCmd = mygrid1.getCombo(ordersubcate_cindex);
	
	

//	parent.document.getElementById("paymoney_for_paraArray").value;
	
	var changeRowIds = mygrid1.getChangedRows(true);
	var rowIds = new Array();
	if(opt !=1 && changeRowIds != ""){
		rowIds = changeRowIds.split(mygrid1.delim);
	}
    
	if(opt == 1){
		for(var i = 0;i< mygrid1.getRowsNum();i++){
			var row_id = mygrid1.getRowId(i);
			rowIds.push(row_id);
		}
	}
	


//	alert(rowIds) 

	for(var i = 0;i< rowIds.length;i++){
		
	 	var obj = (new OrderDetail()).obj; 
	 	
	 	
//		var row_id = mygrid1.getRowId(i);
		var row_id = rowIds[i];

		
		var parentId = 0;
		
		var isNew = mygrid1.getUserData(row_id,"isNew") == 1;
		var publishMemo =  mygrid1.getUserData(row_id,"publishMemo")

		var startDate = getFormatDay(mygrid1.cells(row_id,start_cindex).getValue(),'ymd')*1;
		var endDate = getFormatDay(mygrid1.cells(row_id,end_cindex).getValue(),'ymd')*1;
		var editName = mygrid1.cells(row_id,edit_cindex).getValue();
		


	    var appRate =   mygrid1.cells(row_id,appRae_cindex).getValue();
		var favourRate =  mygrid1.cells(row_id,favace_cindex).getValue();
		var moneyBalance =  mygrid1.cells(row_id,balance_cindex).getValue();

		var adlength =  mygrid1.cells(row_id,len_cindex).getValue();
		var sysPrice =  mygrid1.cells(row_id,stantPrice_cindex).getValue();
		var execPrice =  mygrid1.cells(row_id,realPrice_cindex).getValue();
		
		
		
		
		var ageRate = 0;

		var sumTime = mygrid1.cells(row_id,sumTime_cindex).getValue();
		var moneyRealpay =  mygrid1.cells(row_id,sumPay_cindex).getValue();
		
		
		var resourceSpecific_value = mygrid1.cells(row_id,apppos_cindex).getValue();
	
		var resourceSpecificId =  0;
		
		 if(resourceSpecific_value > 0){
		 	resourceSpecificId = resourceSpecific_value
		 }else{
			resourceSpecificId = appposCmd.getKey(resourceSpecific_value);
		 }
		 resourceSpecificId = (resourceSpecificId==null||resourceSpecificId=='')?0:resourceSpecificId;	
		 
		 var specificValue = appposCmd.positions[resourceSpecificId];
  

		
		var ordersubcateId =  mygrid1.cells(row_id,ordersubcate_cindex).getValue();	
 
		
		var calculateauto = ordersubcateCmd.calculateauto[ordersubcateId];

		var matterId = mygrid1.getUserData(row_id,"matterId");	
		var resourceInfoId = mygrid1.getUserData(row_id,"resourceId");	
		var detailId = mygrid1.getUserData(row_id,"id"); 
		
//		alert(detailId)
//		var resourceSortId = mygrid1.getUserData(row_id,"resourceSortId");

			
		specificValue = (specificValue==null||specificValue=='')?'':specificValue;		
		
		obj.id = isNew?null:detailId;  
		
	
		obj.publishMemo = isNew?null:publishMemo;  
		obj.version = or_obj.version;    
		obj.orderId = or_obj.id;
			
		obj.sysPrice =  sysPrice;
		obj.execPrice =  execPrice;
		obj.ageRate 	 = ageRate*1/100;
		obj.appRate 	 = appRate*1/100;
		obj.favourRate   	 = favourRate*1/100;		
		obj.sumTimes = sumTime;  
		obj.moneyBase = sysPrice * sumTime; 
		obj.moneyBalance = moneyBalance;
		obj.moneyRealpay =  moneyRealpay;
		


  		obj.matterId =  matterId;
  		obj.matterLength =  adlength;
  		
  		obj.matter =  (new Matter()).obj;
  		obj.matter.edit = editName;
  		obj.matter.length = adlength;
  	

  		
		obj.resourceInfoId =  resourceInfoId;
		obj.resourceType = 0; 
		obj.resourceSortId = 0; 


		obj.resourcePriceType = priceTypeId; 
		obj.resourceSpecificId = resourceSpecificId; 

		obj.isSaveOrderDayInfo = true;
		obj.isCompages = false;
		obj.isSpaceAdver = false;
		obj.isNotInSeries = false;
	
		obj.publishStartDate =  startDate;
		obj.publishEndDate =  endDate;

		obj.createBy = 	loginUserId;
		obj.modifyBy = loginUserId;
        
      
		obj.orderCategoryId =  ordersubcateId;	
		obj.specificValue = specificValue;
		obj.orderCategoryMain = orderCategoryMain;
		obj.calculateauto = calculateauto;
		
	
		
		obj.contractId = 0;
		obj.paymentId = 0;
		obj.industryTypeId = 1; 
		obj.parentId = 0;
		obj.compagesId = 0;
		
		obj.carrierId = 0;
		obj.isCkecked = 0;
		obj.matteType = 0;

		obj.moneyIn = 0;
		obj.needPublish = 1;
		obj.resourceWorkspanId = 0;
		obj.tempString = isDisplayMonDetail? mygrid1.getUserData("year_month",row_id):null;
		
//		obj.orderDyInfos = [];
		
//		if(sumTime >0 && matterId >0){
		if(resourceInfoId >0 && matterId >0){	
			obj.orderDayInfos = getOrderDayInfos(row_id,obj,mapApppos,mapApppos2);   
			
			var keyArr = mapApppos2.keySet();   

			if(keyArr != null && keyArr.length >0) {
				alert("不能重复指定位置,请检查 ！") ;
				return new Array();
			}
			
		
//			console.log(obj)
			//获得应收总价和刊例价
	//		getOrderDetailPublic(obj);
	//		alert(obj.toSource()) 
			objs.push(obj);	
		}else{
			var msg = '段位或广告版本不能为空';
			alert(msg);
			return new Array();
		}

	}	 
	
	 return objs;

//	 function saveDetailFnc(detailId,orderDetail_obj){
//	 	save_orderDetail_fun(orderId,detailId,orderDetail_obj); 
//	 };
//
//
//	orderDetail.saveOrderDetailMore(queryStr,orderDetail_objs,
//		 			{
//					　　callback:function(data){
//					　　	saveDetailFnc(data);
//					},
//					　　errorHandler:function(errorString, exception) { 
//						    var msg="<div style='width:300px;height:300px;OVERFLOW-y:auto;OVERFLOW: scroll;'>"+errorString+"<div>";
//							Ext.MessageBox.hide(); 
//							Ext.MessageBox.show(
//									 	{title:'系统提示',msg:msg,width:380,heigth:300,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
//							); 						
//					    }
//		 			}
//		); 
	
};	







function getOrderDayInfos(row_id,detail_obj,mapApppos,mapApppos2){
	var orderDayInfos = new Array();
	 //广告日信息 
		var rowids = getRowByUserData(mygrid2,"grid1_rowId",row_id,"grid1_row_type",1);
		
//		alert(rowids) 

		for(var i = 0;i<rowids.length;i++){ 
			
//			var row_type = mygrid2.getUserData(rowids[i],"grid1_row_type");
//			if(row_type == 0) continue;

			for(var j = 0;j<31;j++) {
				var cell = mygrid2.cells(rowids[i],j+4).cell;
				var dayObj = cell.dayObj;
				if(cell.navtype == "1" && dayObj.dayDate !=null){
				  	var adDayTimes = (cell.innerHTML > 0) ?  cell.innerHTML*1 : "0";
				  	
//				  	alert(dayObj) 
				  	
		            if(adDayTimes > 0) {
		            	
		            	
					  	  var order_Day_Info = (new OrderDayInfo()).obj;
					  	  var publishDate =  dayObj.dayDate;	
					  	  var curUsedTime = detail_obj.adLength * adDayTimes;
					  	  var adUsedTime = dayObj.adUsedTime*1;	
					  	  var dayRelPuton = dayObj.dayRelPuton;	
					  	  
//					  	alert(publishDate) 
					  	  
//					  	  console.log(dayObj)
					  	  order_Day_Info.id = dayObj.adDayInfoId;
						  order_Day_Info.publishDate = publishDate;	
						  order_Day_Info.contractId = 0;
						  order_Day_Info.orderId = 0;
				          order_Day_Info.isPublished = 0;					   
			              order_Day_Info.version = detail_obj.version; 
						  order_Day_Info.dayRelIncome = 0;
						  order_Day_Info.dayRelPuton = dayRelPuton;
						  order_Day_Info.adDayTimes = adDayTimes;
						  
					
//						  order_Day_Info.changedValue(curUsedTime - adUsedTime);
						  

						  order_Day_Info.needPublish = 1;
						  
						  
						  order_Day_Info.rsModifyTime = dayObj.rsModiyTime;
						  order_Day_Info.rsSpecific = dayObj.rsSpecific;
						  
//						  alert(dayObj.rsSpecific)
						  
//			              order_Day_Info.version = (''+publishDate).substring(0,4);	

		//				  order_Day_Info.rsUsed = dayObj.rsUsedTime;

						  order_Day_Info.dayRelIncome = 0;
						  order_Day_Info.dayRelPuton = 0;
						  order_Day_Info.parentId = 0;

						  order_Day_Info.adlength = detail_obj.matterLength*1;
						  order_Day_Info.resourceSpecific = detail_obj.specificValue;
			              order_Day_Info.dayStandardPrice = detail_obj.sysPrice; 
						  order_Day_Info.needCal = detail_obj.calculateauto;
						  
						  //有重复指定
						  if(mapApppos){
							  if(detail_obj.specificValue != ""){
								    var key = detail_obj.resourceInfoId+","+publishDate+","+detail_obj.specificValue;
								  
									if(!mapApppos.contains(key)){
										 mapApppos.put(key,key);
									}else{
										mapApppos2.put(key,key);
									}
							  }					  
						  }

						  
						  orderDayInfos.push(order_Day_Info);
						  
//						  alert(order_Day_Info.toSource())
						  
		              }
				 }
			}
	
		}	
    
  
    
	return orderDayInfos;

}



function inti_set_cmd(cmd,id,name,model,customerCategoryId){
	
	var fileds = model == 1?customer_fin.fileds:user.fileds;
	var conf = model == 1?{id : id,customerName:name,customerCategoryId : customerCategoryId}:{id : id,fullName:name};
	var rc1 = Ext.data.Record.create(fileds);
    var rc = new rc1(conf);	
     cmd.clearValue(); 
   	 cmd.store.add(rc);
   	 cmd.setValue(id);  
}





function getGrid1_ResDayInfo(td){
	if( td.navtype != "1") return false;
	var dayObj = td.dayObj;
	var adLength = td.adLength;
	var cellValue = (td.innerHTML == "&nbsp;")? 0 : td.innerHTML*1;
	if(dayObj){
		var rsTotalTime =  dayObj.rsTotalTime == null || dayObj.rsTotalTime == "" ? 0: dayObj.rsTotalTime; //资源标准
		var rsUsedTime =  dayObj.rsUsedTime;   //资源占用
		var adTimes = dayObj.adTimes;			//该广告原来次数   
		var adUsedTime = dayObj.adUsedTime;			//该广告原来次数   
		 adTimes = (adTimes == "&nbsp"|| adTimes == "&nbsp;" || adTimes == "")? 0 : adTimes*1;   
//		 var adUsed = rsTotalTime > 0 ? cellValue* adLength - adTimes*dayObj.adLength: -(cellValue - adTimes)* adLength;
//		alert(cellValue* adLength)
		 var adUsed = rsTotalTime > 0 ? cellValue* adLength - adUsedTime: -(cellValue - adTimes)* adLength;
		 
//		 alert('rsUsedTime>>>'+rsUsedTime)
//		 alert('adUsed>>>'+adUsed)
		 
		 var dayUsedTime = rsUsedTime*1 + adUsed;
		 $("dayTotalTime").value = rsTotalTime;
		 $("dayUsedTime").value = dayUsedTime;
		 $("dayLeaveTime").value = rsTotalTime - dayUsedTime;
		 $("broWeekTime").value = dayObj.weakStr;

	}
}

function setGrid1_nat(td){
	var cur_cindex = mygrid1.getColIndexById('cur');

		var grid2_row_id = td.parentNode.idd;
		var grid1_rowId = mygrid2.getUserData(grid2_row_id,"grid1_rowId");
		var count = mygrid1.selectedRows.length;
		for(var i = 0; i< count;i++){
			var row_id =  mygrid1.selectedRows[i].idd;
			mygrid1.cells(row_id,cur_cindex).setValue("");
		}
	var value = "<img src="+ctxPath+"image/grid/btn_rt1.gif>";
	mygrid1.cells(grid1_rowId,cur_cindex).setValue(value);

}

function setGrid1_nat2(rows){
	
	
	var cur_cindex = mygrid1.getColIndexById('cur');
	var count = mygrid1.getRowsNum();

	for(var i = 0; i< count;i++){
			mygrid1.cells2(i,cur_cindex).setValue("");
	}
	
	if(rows.length == 1){
		var selectedId = rows[0].idd;
		var value = "<img src="+ctxPath+"image/grid/btn_rt1.gif>";
		mygrid1.cells(selectedId,cur_cindex).setValue(value);
	}

}


//function setGrid1_nat(rowIdex){
//	var cur_cindex = mygrid1.getColIndexById('cur');
//	var count = mygrid1.selectedRows.length;
//	for(var i = 0; i< count;i++){
//		var row_id =  mygrid1.selectedRows[i].idd;
//		mygrid1.cells(row_id,cur_cindex).setValue("");
//	}
//	
//	grid1_rowId =  mygrid1.getRowId(rowIdex);
//	var value = "<img src="+ctxPath+"image/grid/btn_rt1.gif>";
//	mygrid1.cells(grid1_rowId,cur_cindex).setValue(value);
//}


function checkCustomer(){

	var customerName =  ''; 
	var customerId =  '';	
	var custCmd =  toolbar.getComponent("customerName_for_paraArray");
	
	
	var winW = parent.build_more_paraArray.getInnerWidth()*0.8;
	var winH = parent.build_more_paraArray.getInnerHeight()*0.8;
			

	var customerId = custCmd.getValue();	
	var customerName =  custCmd.getRawValue();	


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
			 	    
			 	    
			 	    
			 	     var areaCityId = Ext.getCmp('customterAreaCity').getValue();
			 	
						if(areaCityId ==''){
				 	    	Ext.MessageBox.hide(); 
							Ext.MessageBox.show(
									 	{title:'系统提示!',msg:"请选择客户区域!",width:300,heigth:270,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
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
			 		 
			 		   
			 	    	 inti_set_cmd(custCmd,id,cut.customerName,1,cut.customerCategoryId);

//			 	    	order.obj.customerId = id;
						saveAreaCity(id);
						saveLinkMan(id);
			 	    	regCustomerWin.hide();
			 	    	save_more_orderDetail();	
			 }	

			 function saveAreaCity(cutId){
			 	 		var areaCityId = Ext.getCmp('customterAreaCity').getValue();
			 	 		if(areaCityId >0) customerAddress.saveCustomerAddressFormOrder(cutId,areaCityId);
			 }
			 
			 function saveLinkMan(cutId){
			 	 		var userCmd =  toolbar.getComponent("userId_for_paraArray");
			 	 		var linkmanName = userCmd.getValue();
			 	 		if(cutId >0) linkMan.saveLinkManFormOrder(cutId,linkmanName);
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
     }

	var cmd1 =  Ext.getCmp('customterAreaCity');
	if(cmd1)cmd1.clearValue();   
 	regCustomerWin.show(); 	
 			
	}
	
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
		 inti_set_cmd(customer.regcustomerCommand,id,customerName,1,customerCategoryId);
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


function disableDestop(){
	
//	alert('5614>>disableDestop>>'+'');

	if(order_id > 0){
		 toolbar.getComponent("year_for_paraArray").setDisabled(true);
	}
	
	 if(config_resourceUseCustomerCatelog){ 
		 if(mygrid1.getRowsNum() > 0 ){
			  toolbar.getComponent("customerName_for_paraArray").setDisabled(true);
		 }else{
			 toolbar.getComponent("customerName_for_paraArray").setDisabled(false);
		 }
	 }
	 
	//通过 1  审核中 3 允许换版本，不能改变长度
	if(orderCkeckState ==1 ||orderCkeckState ==3){
		
		 toolbar.getComponent("customerName_for_paraArray").setDisabled(true);
		 toolbar.getComponent("userId_for_paraArray").setDisabled(true);
		 toolbar.getComponent("year_for_paraArray").setDisabled(true);
		 toolbar.getComponent("categoryId_for_paraArray").setDisabled(true);
		 
		 toolbar.getComponent("btn_displayCompagesTree_2").setDisabled(true);
//		 toolbar.getComponent("btn_addGrid1NewRow").setDisabled(true);
//		 toolbar.getComponent("btn_displayCompagesTree_1").setDisabled(true);
//		 toolbar.getComponent("btn_search_adver_cont").setDisabled(true);
		 toolbar.getComponent("btn_setAutoBroArray").setDisabled(true);
//		 toolbar.getComponent("btn_removeGrid1NewRow").setDisabled(true); //没有加载

		 
//		 footerToolbar.getComponent("Btn_save_more_new").setDisabled(true);
		 
		 parent.document.getElementById("paymoney_for_paraArray").readOnly = true; 
		 
		 $("isDisplayMonDetail").disabled = true;
		 $("cleanBroArrange").disabled = true;
		 $("addNextMonthBroArrange").disabled = true;
		 $("rebackBroArrange").disabled = true;
		 

//		 menu.hideContextMenu();
		 menu.unload();
//		 menu.hide();
		 
		 
		 mygrid1.setEditable(false);
		 mygrid2.detachAllEvents(); 

			  
//		 var ids = mygrid2.getAllItemIds(mygrid2.delim).split(mygrid2.delim);
//			for(var i =0;i< ids.length;i++){
//				   for(var j =0;j<33;j++){
//					   var type = mygrid2.getUserData(ids[i],"grid1_row_type");
//					   if(type != 0){
//						   var rowId = ids[i];
//						   var cellIndex = j+4;
//						   var td = mygrid2.cells(rowId,cellIndex).cell;
//							td.removeEventListener("click", mygrid2onKeypressClick, false);
//					   }	
//				   }
//					
//			}
			
		 
	}
}



function enableDestop(){
		
//		 alert(config_resourceUseCustomerCatelog)
		 
		 if(config_resourceUseCustomerCatelog){
			 if(mygrid1.getRowsNum() > 0 || totalTime>0){
				  toolbar.getComponent("customerName_for_paraArray").setDisabled(true);
			 }else{
				 toolbar.getComponent("customerName_for_paraArray").setDisabled(false);
			 }
		 }else{
			 toolbar.getComponent("customerName_for_paraArray").setDisabled(false);
		 }
		 
		 toolbar.getComponent("userId_for_paraArray").setDisabled(false);
		 toolbar.getComponent("year_for_paraArray").setDisabled(false);
		 toolbar.getComponent("categoryId_for_paraArray").setDisabled(false);
		 toolbar.getComponent("btn_displayCompagesTree_2").setDisabled(false);
//		 toolbar.getComponent("btn_addGrid1NewRow").setDisabled(false);
//		 toolbar.getComponent("btn_displayCompagesTree_1").setDisabled(false);
		 toolbar.getComponent("btn_setAutoBroArray").setDisabled(false);
		 parent.document.getElementById("paymoney_for_paraArray").readOnly = false; 
		 
		 $("isDisplayMonDetail").disabled = false;
		 $("cleanBroArrange").disabled = false;
		 $("addNextMonthBroArrange").disabled = false;
		 $("rebackBroArrange").disabled = false;
		 

//		 menu.hideContextMenu();
		 menu.loadXMLString(build_grid1_menuStr()); 
		 menu.renderAsContextMenu();
//		 menu.show();
		 
		 mygrid1.setEditable(true);
		 mygrid2.detachAllEvents();
		
			  
		 var ids = mygrid2.getAllItemIds(mygrid2.delim).split(mygrid2.delim);
			for(var i =0;i< ids.length;i++){
				   for(var j =0;j<33;j++){
					   var type = mygrid2.getUserData(ids[i],"grid1_row_type");
					   if(type != 0){
						   var rowId = ids[i];
						   var cellIndex = j+4;
						   var td = mygrid2.cells(rowId,cellIndex).cell;
							dhtmlxEvent(td,"click", mygrid2onKeypressClick);
					   }	
				   }
					
			}
	
}