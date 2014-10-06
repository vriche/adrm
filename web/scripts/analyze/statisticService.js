Ext.apply(Ext.form.VTypes, {
    daterange : function(val, field) {
        var date = field.parseDate(val);

        if(!date){
            return;
        }
        if (field.startDateField && (!this.dateRangeMax || (date.getTime() != this.dateRangeMax.getTime()))) {
            var start = Ext.getCmp(field.startDateField);
            start.setMaxValue(date);
            start.validate();
            this.dateRangeMax = date;
        } 
        else if (field.endDateField && (!this.dateRangeMin || (date.getTime() != this.dateRangeMin.getTime()))) {
            var end = Ext.getCmp(field.endDateField);
            end.setMinValue(date);
            end.validate();
            this.dateRangeMin = date;
        }
        /*
         * Always return true since we're only using this vtype to set the
         * min/max allowed values (these are tested for after the vtype test)
         */
        return true;
    },

    password : function(val, field) {
        if (field.initialPassField) {
            var pwd = Ext.getCmp(field.initialPassField);
            return (val == pwd.getValue());
        }
        return true;
    },

    passwordText : 'Passwords do not match'
});

//var myDate = new MyDate();
var resource = new Resource();
var user = new User();
var customer = new Customer();
var myDate = new MyDate();
var myprint =new MyPrint();
var paramObj =new ParamObj();

var  utils;

//var win_query;
var currentWindow;
var resourceCommandTree;
var userCommandTree;
var customerCommandTree;
var weekCheckBoxCommand;
var orgCmd;
var comYear;
var win_width = 0;
var win_heigth = 0;
var utils;
var loginUser;
var def_Date_start;
var def_Date_end;   
var firstLoad = false;

var branch_sum_grid;
var branch_sum_grid2;
var channel_sum_grid;
var channel_sum_grid2;
var pos_sum_grid;
var pos_sum_grid2;
var sign_cut_sum_grid;
var sign_cut_sum_grid2;
var instry_sum_grid;
var instry_sum_grid2;
var order_cate_sum_grid;
var order_cate_sum_grid2;
var brand_edit_sum_grid;
var brand_edit_sum_grid2;
var customer_cate_sum_grid;
var customer_cate_sum_grid2;
var customer_brand_sum_grid;
var customer_brand_sum_grid2;


var fusionCharts = new Charts();
var fusionChartObjects;
var ctxPath;
var chartWidth = 0;
var chartHeight = 0;   
	


callOnLoad(init);	


function init(){ 

	ctxPath = _app_params.ctxPath;	
	tvNameParam =  _app_params.sysParam.tvNameParam;  	
	config_serviceDate = _app_params.serviceDate.def;		
	isDisplayChartParam = _app_params.sysParam.isDisplayChartParam;
	channelModelParam = _app_params.sysParam.channelModelParam;
	loginUser =  _app_params.user.username;	
	
	config_useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
	config_useCarrierAliname = _app_params.sysParam.useCarrierAliname;
	config_withResourceSort = _app_params.sysParam.withResourceSort;//是否启用播出入点(启用1,不启用0)系统参数默认是0;
	config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;
		
	utils = new MyUtils( _app_params.sysParam.serviceDate);
	curYear = _app_params.serviceDate.year;
	curMonth = _app_params.serviceDate.month;

	resetHeigth();

	orgCmd = _make_org_select2("","_org_cmd",150);
	orgCmd.on("select" , function(box){resetStore(); });  
	 
	initYearCom();


	initResourceComTree();

	showWindows();
	
	
}

function resetHeigth(){
	var dialogcontent = $("dialogcontentDiv");	
	win_width = dialogcontent.offsetWidth*0.99;	
	win_heigth = dialogcontent.offsetHeight*0.93;		
	
//    var chartdiv = $("chartdiv");
//    chartdiv.style.height = $("theDivChart").offsetHeight +"px";	
//    chartWidth = chartdiv.offsetWidth;
//	chartHeight = chartdiv.offsetHeight;	
} 

function initResourceComTree(){
	
	  function callFunction(){} 
	  
	  var orgId = orgCmd.getValue();
	  
	
	  
	
	  var search_year = Ext.getCmp('search_year');
	  if(search_year){
	  	 resource_year = Ext.getCmp('search_year').getValue();
	  }else{ 
	  	 resource_year =_app_params.serviceDate.year;
	  }
	   resource.obj.version = resource_year; 
	   resource.obj.enable =null;
	   
	   
	 var orgId_res = config_oneOrgMoreSuborgsParam == '1'?1:orgId;
	 resourceCommandTree = resource.getResourceCmdTree(orgId_res,resource.obj,'search_resource_cmd','search_resource_tree',true,null,'resourceId','请选择...',100,true,false,true,callFunction);
	   
	 var orgId_user = config_oneOrgMoreSuborgsParam == '1' && orgId == '1'?" ":orgId;  
	 userCommandTree = user.getUserCmdTree(orgId_user,resource.obj,'search_user_cmd','search_user_tree',true,null,'userId','请选择...',100,true,true,true,callFunction);
		
//	 customer.obj.orgId = orgId;
//	 var paramObj =[customer.obj,{orgId:orgId}];
//	 customerCommandTree = customer.getCustomerCmdTree(orgId,paramObj,'search_customer_cmd','search_customer_tree',true,null,'customerId','选择客户...',350,true,true,true,callFunction);




 	customer.obj.orgId = config_oneOrgMoreSuborgsParam == '1'?1:orgId;
 	customer.obj.loginUser = loginUser; 
 	customer.obj.model = "1";
	customerCommandTree = customer.getCustomerRemote(null,"customer_name",100,function(){});
    



	 weekCheckBoxCommand = this.myprint.getWeekCheckBox(null,"weekCheckBox","星期",100,"");
 	
 	
}



//function initCustomerComTree(){
//	function callFunction(){} 
//	customerCommandTree = customer.getCustomerCmdTree(orgId,resource.obj,'search_customer_cmd','search_customer_tree',false,null,'customerId','选择客户...',200,false,true,true,callFunction);
//}



function initYearCom(){
//	comYear = utils.getComYear('search_year','催款年度',150,curYear);  
//	var yyyy = comYear.getValue();
//	comYear.on("select" , function(box){}); 	
	

  comYear = {           
	                            id:'search_year',
	                            xtype: 'combo',
	                            name: 'POWERSHOW',
	                            hiddenName: 'POWER',  
	                            width:100,
	                            allowBlank: false,
	                            mode: 'local',
	                            blankText: '请选择用户身份.',
	                            store:["2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016"],
	                            fieldLabel: "年份",
	                            editable: false, //false则不可编辑，默认为true
	                            triggerAction: "all" //请设置为"all",否则默认为"query"的情况下，你选择某个值后，再此下拉时，只出现匹配选项，如果设为"all"的话，每次下拉均显示全部选项
	
	};	
	

	
	  
	 
//	comYear = new Ext.form.ComboBox({           
//	                            id:'search_year',
//	                            xtype: 'combo',
//	                            name: 'POWERSHOW',
//	                            hiddenName: 'POWER',  
//	                            width:150,
//	                            allowBlank: false,
//	                            mode: 'local',
//	                            blankText: '请选择用户身份.',
//	                            store:["2006","2007","2008","2009","2010","2011","2012","2013"],
//	                            fieldLabel: "年份",
//	                            editable: false, //false则不可编辑，默认为true
//	                            triggerAction: "all" //请设置为"all",否则默认为"query"的情况下，你选择某个值后，再此下拉时，只出现匹配选项，如果设为"all"的话，每次下拉均显示全部选项
//	
//	});	
//	
//	comYear.setValue(curYear);  
//	var yyyy = comYear.getValue();
//	comYear.on("select" , function(box){
//		 var cmdRes = Ext.getCmp('search_resource_tree');
//		 if(cmdRes){
//			 cmdRes.root.attributes.version = resource_year;
//		 	 cmdRes.root.reload();
////		 	 mygrid.clearAll();
//		 }
//
//		
//	}); 		
}

var curActiveTabIndex = 1;
var displayModel = 1;

function getParams(){
	var tabs = Ext.getCmp("mainTab");  
	var tab = tabs.getActiveTab(); 	
	if(tab.getId() =='branch_sum_tab'){
	 	curActiveTabIndex = 1;
	}
	if(tab.getId() == 'channel_sum_tab'){
	  	curActiveTabIndex = 2;
	}
	if(tab.getId() == 'resource_sum_tab'){
	  	curActiveTabIndex = 3;
	}	
	
	if(tab.getId() == 'sign_customer_sum_tab'){
	  	curActiveTabIndex = 4;
	}	
	
 	if(tab.getId() == 'instry_sum_tab'){
	  	curActiveTabIndex = 5;
	}	
 	if(tab.getId() == 'order_cate_sum_tab'){
	  	curActiveTabIndex = 6;
	}	
 	if(tab.getId() == 'brand_edit_sum_tab'){
	  	curActiveTabIndex = 7;
	}	
 	if(tab.getId() == 'customer_cate_sum_tab'){
	  	curActiveTabIndex = 8;
	}		
 	if(tab.getId() == 'customer_brand_sum_tab'){
	  	curActiveTabIndex = 9;
	}		
	
	
	 
	   
    var checkedItem;

    
    if(currentWindow){
		 checkedItem = Ext.getCmp('opt_package').getValue();
		 displayModel = checkedItem.getGroupValue();  //1、总览  2、明细
    }
 
 
	
		
	var orgId = Ext.getCmp('_org_cmd').getValue();

	var startDate = Ext.getCmp('startdt').getValue();
	var endDate = Ext.getCmp('enddt').getValue();

	startDate = myDate.myFormatDate(startDate,myDate.dateFormat);
	endDate = myDate.myFormatDate(endDate,myDate.dateFormat);   
	if(endDate =='') endDate = myDate.myFormatDate(def_Date_end,myDate.dateFormat);

	var resourceIds =  Ext.getCmp('search_resource_tree').getAllCheckedIds(3);
	var userIds =  Ext.getCmp('search_user_tree').getAllCheckedIds(2);
//	var customerIds =  Ext.getCmp('search_customer_tree').getAllCheckedIds(2);
	var customerIds = 	Ext.getCmp('customer_name').getValue();
	var inWeekDates = Ext.getCmp('weekCheckBox').getCheckedValue();
	
	


	
//	var paramObj= (new ParamObj()).obj;

//	if(curActiveTabIndex == 1){
		orgId = config_oneOrgMoreSuborgsParam == '1' && orgId ==1?"":orgId;
//	}


	var paramObj = {orgId:orgId,loginUser:loginUser,whereModel:curActiveTabIndex,displayModel:displayModel,value1:startDate,value2:endDate,value3:resourceIds,value4:userIds,value5:customerIds,value6:inWeekDates};
//	paramObj.orgId = orgId;
//	paramObj.loginUser = loginUser;
//	paramObj.value1 = startDate;
//	paramObj.value2 = endDate;
	
	return paramObj;
}

 function search(){ 
	var tabs = Ext.getCmp("mainTab");  
	var tab = tabs.getActiveTab(); 
	

	var paramObj = getParams();
    var theDiv = $("theDivChart");
    

    
    if(theDiv.style.visibility == "visible"){
    	 theDiv.style.visibility = "hidden"
    }
 	
// 	var displayModel = paramObj.displayModel;




	 	 if(tab.getId() =='branch_sum_tab'){
	 	 
//		 	 	curActiveTabIndex = 1;
//		 	 	paramObj.whereModel = curActiveTabIndex;
	
		 	 	var grid = displayModel==1?branch_sum_grid:branch_sum_grid2;
	            if(displayModel==1){
	            	if(branch_sum_grid2) branch_sum_grid2.hide();
	            }else{
	            	if(branch_sum_grid) branch_sum_grid.hide();
	            }
		 	 	if(grid){
			  		var branchStore = grid.store;
			  		branchStore.load({params:{dwrParams:[paramObj]}});	
			  		grid.show();
		 	 	}else{
		 	 		
	                if(currentWindow){
		 	 	 		grid = get_statistic_sum_tables();
//			 	 		tab.add(grid);  
			 	 		grid.show();  
	                }
		 	 	}
	 	 }
	 	 
  
	 	 if(tab.getId() == 'channel_sum_tab'){

		 	 	paramObj.whereModel = curActiveTabIndex;
				var grid = displayModel ==1?channel_sum_grid:channel_sum_grid2;
	            if(displayModel==1){
	            	if(channel_sum_grid2) channel_sum_grid2.hide();
	            }else{
	            	if(channel_sum_grid) channel_sum_grid.hide();
	            }
		 	 	if(grid){
			  		var channelStore = grid.store;
			  		channelStore.load({params:{dwrParams:[paramObj]}});	
		 	 	}else{
		 	 		grid = get_statistic_sum_tables();
//		 	 		tab.add(grid);
		 	 	}
		 	 	grid.show();
	 	 } 	 
	 	 
	 	 if(tab.getId() == 'resource_sum_tab'){

		 	 	paramObj.whereModel = curActiveTabIndex;
				var grid = displayModel ==1?pos_sum_grid:pos_sum_grid2;
	            if(displayModel==1){
	            	if(pos_sum_grid2) pos_sum_grid2.hide();
	            }else{
	            	if(pos_sum_grid) pos_sum_grid.hide();
	            }
		 	 	if(grid){
			  		var store = grid.store;
			  		store.load({params:{dwrParams:[paramObj]}});	
		 	 	}else{
		 	 		grid = get_statistic_sum_tables();
//		 	 		tab.add(grid);
		 	 	}
		 	 	grid.show();
	 	 } 		 	 
	 	 
	 	 if(tab.getId() == 'sign_customer_sum_tab'){

		 	 	paramObj.whereModel = curActiveTabIndex;
				var grid = displayModel ==1?sign_cut_sum_grid:sign_cut_sum_grid2;
	            if(displayModel==1){
	            	if(sign_cut_sum_grid2) sign_cut_sum_grid2.hide();
	            }else{
	            	if(sign_cut_sum_grid) sign_cut_sum_grid.hide();
	            }
		 	 	if(grid){
			  		var store = grid.store;
			  		store.load({params:{dwrParams:[paramObj]}});	
		 	 	}else{
		 	 		grid = get_statistic_sum_tables();
//		 	 		tab.add(grid);
		 	 	}
		 	 	grid.show();
	 	 } 	
	 	 
	 	 if(tab.getId() == 'instry_sum_tab'){

		 	 	paramObj.whereModel = curActiveTabIndex;
				var grid = displayModel ==1?instry_sum_grid:instry_sum_grid2;
	            if(displayModel==1){
	            	if(instry_sum_grid2) instry_sum_grid2.hide();
	            }else{
	            	if(instry_sum_grid) instry_sum_grid.hide();
	            }
		 	 	if(grid){
			  		var store = grid.store;
			  		store.load({params:{dwrParams:[paramObj]}});	
		 	 	}else{
		 	 		grid = get_statistic_sum_tables();
//		 	 		tab.add(grid);
		 	 	}
		 	 	grid.show();
	 	 } 	
	 	 

	 	 if(tab.getId() == 'order_cate_sum_tab'){

		 	 	paramObj.whereModel = curActiveTabIndex;
				var grid = displayModel ==1?order_cate_sum_grid:order_cate_sum_grid2;
	            if(displayModel==1){
	            	if(order_cate_sum_grid2) order_cate_sum_grid2.hide();
	            }else{
	            	if(order_cate_sum_grid) order_cate_sum_grid.hide();
	            }
		 	 	if(grid){
			  		var store = grid.store;
			  		store.load({params:{dwrParams:[paramObj]}});	
		 	 	}else{
		 	 		grid = get_statistic_sum_tables();
//		 	 		tab.add(grid);
		 	 	}
		 	 	grid.show();
	 	 } 		 	 
	 	 
	 	 if(tab.getId() == 'brand_edit_sum_tab'){

		 	 	paramObj.whereModel = curActiveTabIndex;
				var grid = displayModel ==1?brand_edit_sum_grid:brand_edit_sum_grid2;
	            if(displayModel==1){
	            	if(brand_edit_sum_grid2) brand_edit_sum_grid2.hide();
	            }else{
	            	if(brand_edit_sum_grid) brand_edit_sum_grid.hide();
	            }
		 	 	if(grid){
			  		var store = grid.store;
			  		store.load({params:{dwrParams:[paramObj]}});	
		 	 	}else{
		 	 		grid = get_statistic_sum_tables();
//		 	 		tab.add(grid);
		 	 	}
		 	 	grid.show();
	 	 } 		 	 
	 	 
	 	 if(tab.getId() == 'customer_cate_sum_tab'){

		 	 	paramObj.whereModel = curActiveTabIndex;
				var grid = displayModel ==1?customer_cate_sum_grid:customer_cate_sum_grid2;
	            if(displayModel==1){
	            	if(customer_cate_sum_grid2) customer_cate_sum_grid2.hide();
	            }else{
	            	if(customer_cate_sum_grid) customer_cate_sum_grid.hide();
	            }
		 	 	if(grid){
			  		var store = grid.store;
			  		store.load({params:{dwrParams:[paramObj]}});	
		 	 	}else{
		 	 		grid = get_statistic_sum_tables();
//		 	 		tab.add(grid);
		 	 	}
		 	 	grid.show();
	 	 } 		 	
	 	 
	 	 
		if(tab.getId() == 'customer_brand_sum_tab'){

		 	 	paramObj.whereModel = curActiveTabIndex;
				var grid = displayModel ==1?customer_brand_sum_grid:customer_brand_sum_grid2;
	            if(displayModel==1){
	            	if(customer_brand_sum_grid2) customer_brand_sum_grid2.hide();
	            }else{
	            	if(customer_brand_sum_grid) customer_brand_sum_grid.hide();
	            }
		 	 	if(grid){
			  		var store = grid.store;
			  		store.load({params:{dwrParams:[paramObj]}});	
		 	 	}else{
		 	 		grid = get_statistic_sum_tables();
//		 	 		tab.add(grid);
		 	 	}
		 	 	grid.show();
	 	 } 	 	 
	 	 
	 	 
	 	 
	 	 
	 	 
	 	  	 	 
	 	 	 	 
} 


function showWindows(){

    var serDate = myDate.parseDate(getFormatDay(_app_params.serviceDate.format2,"y-m-d"));       
 	var startDate = myDate.getStartDay2(serDate);
	var endDate = myDate.getEndDay2(serDate); 
	
  	 def_Date_start =   myDate.parseDate(getFormatDay(startDate,"y-m-d"));
	 def_Date_end =   myDate.parseDate(getFormatDay(endDate,"y-m-d"));   
	
    var comYear = {           
	                            id:'search_year',
	                            xtype: 'combo',
	                            name: 'search_year',
	                            hiddenName: 'POWER',  
	                            width:100,
	                            allowBlank: false,
	                            mode: 'local',
	                            blankText: '请选择用户身份.',
	                            store:["2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016"],
	                            fieldLabel: "年份",
	                            editable: false, //false则不可编辑，默认为true
	                            listeners:{select:resetDay.createDelegate(this)},
	                            triggerAction: "all" //请设置为"all",否则默认为"query"的情况下，你选择某个值后，再此下拉时，只出现匹配选项，如果设为"all"的话，每次下拉均显示全部选项
	
	};	
	
//	comYear.on("select" , function(box){resetDay(); resetStore(); });  
	
//	var month_keys = new Array(1,2,3,4,5,6,7,8,9,10,11,12);
	var comMonth = {           
	                            id:'search_month',
	                            xtype: 'combo',
	                            name: 'search_month',
	                            hiddenName: 'POWER',  
	                            width:100,
	                            allowBlank: false,
	                            mode: 'local',
	                            blankText: '请选择用户身份.',
	                            store:["1","2","3","4","5","6","7","8","9","10","11","12"],
	                            fieldLabel: "月份",
	                            editable: false, //false则不可编辑，默认为true
	                            triggerAction: "all" //请设置为"all",否则默认为"query"的情况下，你选择某个值后，再此下拉时，只出现匹配选项，如果设为"all"的话，每次下拉均显示全部选项
	
	};		

//	var yearMonth = {
//                region:'center',
//                margins:'35 5 5 0',
//                layout:'column',
//                autoScroll:true,
////                defaultType: 'combo',
//                labelWidth: 30,
//                labelAlign: 'right',
//                items:[{
//                    columnWidth:.50,
////                    xtype:'combo',
//                    baseCls:'x-plain',
//                    bodyStyle:'padding:5px 0 5px 5px',
//                    items:[comYear]
//                },{
//                    columnWidth:.50, 
////                    xtype:'combo',
//                    baseCls:'x-plain',
//                    bodyStyle:'padding:5px 0 5px 5px',
//                    items:[]
//                }]
//            };
	
 
    var dr = new Ext.FormPanel({
      labelWidth: 60,
      labelAlign: 'right',
      frame: true,
//      title: 'Date Range',
	  bodyStyle:'padding:5px 5px 0',
	  width: 350,
	  height:1000,
      defaults: {width: 100},
//      defaultType: 'datefield',
      items: [orgCmd,comYear,{
        fieldLabel: '开始日期',
        name: 'startdt',
        id: 'startdt',
        xtype:'datefield',
        vtype: 'daterange',
        format : 'Y-m-d',
        endDateField: 'enddt',// id of the end date field
//         enableKeyEvents : true,
        value:def_Date_start
      },{
        fieldLabel: '结束日期',
        name: 'enddt',
        id: 'enddt',
        xtype:'datefield',
        vtype: 'daterange',
        format : 'Y-m-d',
        startDateField: 'startdt' // id of the start date field
//        value:def_Date_end
//         enableKeyEvents : true,
//        value:def_Date_end
      },resourceCommandTree,userCommandTree,customerCommandTree,weekCheckBoxCommand,
      	     	{
	     		iconCls:'admin-tool-query',
	     		xtype:'button',
	     		text:'检索',
	     		handler:this.search.createDelegate(this)
	     	}
      
      ]
    });
    
    function resetWin(){
    	
	        if(currentWindow){ 
	        	resetHeigth();
	        	currentWindow.setWidth(win_width);   
	            currentWindow.setHeight(win_heigth);  
//	            currentWindow.center();
                var grid;

                
			 	 if(curActiveTabIndex == 1){  
			 	 	    grid = displayModel ==1?branch_sum_grid:branch_sum_grid2;
			 	 }	
			 	 
			 	 if(curActiveTabIndex == 2){
			 	 		grid = displayModel ==1?channel_sum_grid:channel_sum_grid2;	 	  	 	
			 	 }		
			 	 
			 	 if(curActiveTabIndex == 3){
			 	 		grid = displayModel ==1?pos_sum_grid:pos_sum_grid2;	 	  	 	
			 	 }				 	 
			 	 
			 	 if(curActiveTabIndex == 4){
			 	 		grid = displayModel ==1?sign_cut_sum_grid:sign_cut_sum_grid2;	 	  	 	
			 	 }		
			 	 
			 	 if(curActiveTabIndex == 5){
			 	 		grid = displayModel ==1?instry_sum_grid:instry_sum_grid2;	 	  	 	
			 	 }				 	 		 	 
			 	 
//			 	 if(curActiveTabIndex == 6){
//			 	 		grid = displayModel ==1?instry_sum_grid:instry_sum_grid2;	 	  	 	
//			 	 }			 	 
			 	 
			 	 
			 	 
			 	 		 	 
				grid.setWidth((currentWindow.getInnerWidth() - Ext.get("main_nav").getWidth())*0.96);
				grid.setHeight(currentWindow.getInnerHeight()*0.79);	
	        }      	
    }

  function resetGrid(){
  	var tabs = Ext.getCmp("mainTab");  
	var tab = tabs.getActiveTab(); 	
  	if(curActiveTabIndex == 1){
//  		tab.remove(this,branch_ssum_grid);
//  		branch_sum_grid.removeAll();
//  		branch_sum_grid.store.destroy();
		branch_sum_grid.setWidth(0);
		branch_sum_grid.hide();
		branch_sum_grid.destroy();
		branch_sum_grid = null; 
  	}
  	if(curActiveTabIndex == 2){
  		tab.remove(this,channel_sum_grid);
//  		channel_sum_grid.removeAll();
  		channel_sum_grid.store.destroy();
 		channel_sum_grid.destroy();		
		channel_sum_grid = null;
  	}
          
 
//   if(branch_sum_grid){
////   		tab.remove(this,branch_sum_grid);
//		branch_sum_grid.removeAll();
//		branch_sum_grid.store.destroy();
//    	branch_sum_grid = null;   	
//   }
//   
//   if(channel_sum_grid){
////   		tab.remove(this,channel_sum_grid);
//		channel_sum_grid.removeAll();
//		channel_sum_grid.store.destroy();
//    	channel_sum_grid = null;   	
//   }
         	 	
	search();	
	
	
    resetWin();
	
	
  }

     	
    
    var buttons =[
    		{
            // Use the default, automatic layout to distribute the controls evenly
            // across a single row
            xtype: 'radiogroup',
//            vertical: true,
//            allowBlank: false,
            fieldLabel: 'Auto Layout',
			style:'margin-left:100px;align:middle;CURSOR:pointer;', 
			vertical :false, 
			width : 150,
			columns : 2, 
			name:'opt_package',
			id:"opt_package",
            items: [
	                {boxLabel: '总览', name: 'cb-auto-1',inputValue:1,width :40,checked: true,listeners : {
	                     	 check : function(checkbox, checked) { 
	                     	 		  if (checked) {displayModel =1;search();  } 
	                     	 	  }
	                     }               
	
	                },
	                {boxLabel: '明细', name: 'cb-auto-1',inputValue:2,width :40,listeners : {
	                     	 check : function(checkbox, checked) { 
	                     	 		  if (checked) {displayModel =2;search();} 
	                     	 	  }
	                     }      
	                
	                },
            	]
       		 },'-',
       
       		 
//	     	{
//	     		iconCls:'admin-tool-query',
//	     		xtype:'button',
//	     		text:'检索',
//	     		handler:this.search.createDelegate(this)
//	     	},'-',
//            {
//            	
//                text:'预览',
//                iconCls:'admin-tool-view',
////                disabled:true,
////                handler:this.onRemovePrice.createDelegate(this)
//            },'-',
            {
                text:'打印',
                iconCls:'admin-tool-print',
//                disabled:true,
                handler:this.printReport.createDelegate(this,['print'])
            },'-',
            {
                text:'导出',
                iconCls:'admin-tool-export-xls',
//                disabled:true,
                handler:this.printReport.createDelegate(this,['excel'])
            }
            ,'-',
            {
                text:'图表',
                iconCls:'admin-tool-chart',
//                disabled:true,
                handler:this.printReport.createDelegate(this,['chart'])
            }
//             ,'-',
//            {
//            text: 'Toggle',
//            handler: function(){summaryGroup.toggleSummaries();}
//        	}
         ]; 
         
         
// var tbar = [{
//        xtype: 'buttongroup',
//        columns: 3,
//        title: 'Clipboard',
//        items: [{
//            text: 'Paste',
//            scale: 'large',
//            rowspan: 3, iconCls: 'add',
//            iconAlign: 'top',
//            cls: 'x-btn-as-arrow'
//        },{
//            xtype:'splitbutton',
//            text: 'Menu Button',
//            scale: 'large',
//            rowspan: 3,
//            iconCls: 'add',
//            iconAlign: 'top',
//            arrowAlign:'bottom',
//            menu: [{text: 'Menu Item 1'}]
//        },{
//            xtype:'splitbutton', text: 'Cut', iconCls: 'add16', menu: [{text: 'Cut Menu Item'}]
//        },{
//            text: 'Copy', iconCls: 'add16'
//        },{
//            text: 'Format', iconCls: 'add16'
//        }]
//    }];
         
         


         
     
 	
 var tabs = new Ext.TabPanel({
            region: 'center',
            id:'mainTab',
            margins:'3 3 3 0', 
            activeTab: 0,
            defaults:{autoScroll:true},
	        resizeTabs:true, // turn on tab resizing
//	        deferredRender: false,
	        minTabWidth: 80,
	        tabWidth:100,
	        enableTabScroll:true,
//	         tbar : buttons,
             buttonAlign:"center",
	         buttons:buttons,
//	        tbar : [{  
//            text : '获取',  
//            handler : function() {  
//                var arr = new Array();  
//                tp.items.each(function(item) {  
//                    item.show();  
//                    arr.push(item.items.itemAt(0).form.getValues());  
//                });  
//                alert(Ext.encode(arr));  
//            }  
//       	  }],  
        
//	        plugins: new Ext.ux.TabCloseMenu(),
            items:[{
                title: '部门收入欠款',
                id:'branch_sum_tab', 
//                 html: '<div id="grid-branch_sum_div" style="width:100%"></div><div id="grid-branch_sum_print_div" style="width:100%"/>',
                  html: '<div id="branch_sum_chart_div" style="width:100%"/>',
//                items:[branch_sum_grid],
                listeners:{activate:search.createDelegate(this)}
            },{
                title: '频道收入欠款',
                id:'channel_sum_tab',
                html: '<div id="channel_sum_chart_div" style="width:100%"/>',
                listeners:{activate:search.createDelegate(this)}
            },{
                title: '时段收入欠款',
                id:'resource_sum_tab',
                html: '<div id="pos_sum_chart_div" style="width:100%"/>',
                listeners:{activate:search.createDelegate(this)}
//                closable:true
            },{
                title: '业务员及单位',
                id:'sign_customer_sum_tab',
                 html: '<div id="sign_user_customer_sum_chart_div" style="width:100%"/>',
                listeners:{activate:search.createDelegate(this)}
//                closable:true
            },{
                title: '行业类别',
                id:'instry_sum_tab',
                html: '<div id="instry_sum_chart_div" style="width:100%"/>',
                listeners:{activate:search.createDelegate(this)}
//                closable:true
            },{
                title: '订单类别',
                id:'order_cate_sum_tab',
                html: '<div id="order_cate_sum_chart_div" style="width:100%"/>',
                listeners:{activate:search.createDelegate(this)}
//                closable:true
            },{
                title: '品牌版本',
                id:'brand_edit_sum_tab',
                html: '<div id="brand_edit_sum_chart_div" style="width:100%"/>',
                listeners:{activate:search.createDelegate(this)}
//                closable:true
            },{
                title: '客户类别',
                id:'customer_cate_sum_tab',
                html: '<div id="customer_cate_sum_chart_div" style="width:100%"/>',
                listeners:{activate:search.createDelegate(this)}
//                closable:true
            },{
                title: '客户品牌',
                id:'customer_brand_sum_tab',
                html: '<div id="customer_brand_sum_chart_div" style="width:100%"/>',
                listeners:{activate:search.createDelegate(this)}
//                closable:true
            }]
        });
        



        // Panel for the west
        var nav = new Ext.Panel({
            title: '检索条件',
            region: 'west',
            split: true,
            id:'main_nav',
            width: 200,
//            anchor : '60%',
            height:win_heigth-50,
            collapsible: true,
            margins:'3 0 3 3',
            cmargins:'3 3 3 3',
            items:[dr]
        });
        
         var dialogcontent = $("dialogcontentDiv");
		 var r = getAbsolutePos(dialogcontent);
		 var xx = r.x;
		 var yy = r.y*2;


        var win_query = new Ext.Window({
//            title: '统计',
            closable:true,
            width:win_width,
            height:win_heigth,
            
//            width : Ext.getBody().getWidth(),     
//			height : Ext.getBody().getHeight(), 
//            X:100,
//            Y:100,
            //border:false,
            plain:true,
            layout: 'border',
            renderTo:document.body,
//            renderTo:'mainDive',
//			modal : true, 
            items: [nav, tabs]
        });
        

	    Ext.EventManager.onWindowResize(function(){  
//	    	alert(222)
            resetWin();
	    });     
	    
		win_query.addListener('beforeshow',function(o){     
	        currentWindow=o;  
	    });   
	    win_query.addListener('destroy',function(o){    
	        currentWindow=null;  
	    });  	    

        win_query.show(this);	
        
      
   


        
//        if(firstLoad){
////	 	 		get_branch_sum_tables();
////	 	 		var dv = '<div id="grid-branch_sum_div" style="100%"></div>';
////				Ext.getCmp('branch_sum_tab').add(dv);
//				get_branch_sum_tables();
//	 	 		Ext.getCmp('branch_sum_tab').add(branch_sum_grid);
//        }
        
        var search_year = Ext.getCmp('search_year');
        search_year.setValue(curYear); 
        search_year.on("select" , function(box){resetStore(); });  
        
//        var search_month = Ext.getCmp('search_month');
//        search_month.setValue(curMonth*1);        
   
        var dateField_end = Ext.getCmp('enddt');
//            var endDate =    dateField_end.getValue();
//            myDate.setFullYear(version,endDate.getMonth(),endDate.getDate());

	  	dateField_end.setValue(def_Date_end); 
	 
	  	  search();
	  	
	
}

 function resetDay(){
 	var version =  Ext.getCmp('search_year').getValue();	
	var dateField_start = Ext.getCmp('startdt');
	var dateField_end = Ext.getCmp('enddt');
	var startDate = dateField_start.getValue();
	var endDate = dateField_end.getValue();    

	  var myDate=new Date();
	  myDate.setFullYear(version,startDate.getMonth(),startDate.getDate());
	  dateField_start.setValue(myDate); 
	  var myDate=new Date();
      myDate.setFullYear(version,endDate.getMonth(),endDate.getDate());
	  dateField_end.setValue(myDate); 	
	  
	  resetStore(); 
 }



 function resetStore(){

	var orgId = Ext.getCmp('_org_cmd').getValue();
	var version =  Ext.getCmp('search_year').getValue();	
 	var orgId_res = config_oneOrgMoreSuborgsParam == '1'?1:orgId;

	var cmd1 =  Ext.getCmp('search_resource_cmd');
	var tree1 = Ext.getCmp('search_resource_tree');
	tree1.root.attributes.orgId = orgId_res;
	tree1.root.attributes.version = version;
	if(tree1.root.isLoaded()){
		cmd1.clearValue(); 
		tree1.root.reload(); 
	}	
	

	  search();
	
	var cmd2 =  Ext.getCmp('search_user_cmd');
	var tree2 = Ext.getCmp('search_user_tree');
	tree2.root.attributes.orgId = orgId;
//	tree2.root.attributes.version = version;	
	if(tree2.root.isLoaded()){
		cmd2.clearValue(); 
		tree2.root.reload(); 
	}	
	
//	var cmd3 =  Ext.getCmp('search_customer_cmd');
//	var tree3 = Ext.getCmp('search_customer_tree');
//	tree2.root.attributes.orgId = orgId;
//	tree2.root.attributes.version = version;	
//	if(tree2.root.isLoaded()){
//		cmd2.clearValue(); 
//		tree2.root.reload(); 
//	}		

}
















function printReport(model){
	
	if(model =="chart"){
		getFusionChartObjs();
	}else{
		
	
	    var paramObj = {};
	    var printParam = {};
	    var print_div;
//		var tabs = Ext.getCmp("mainTab");  
//		var tab = tabs.getActiveTab(); 
		
        paramObj = getParams(); 

		if(curActiveTabIndex ==1){
			 printParam = {
					 	model: model,
					 	title:'部门汇总统计',
		                reportType: "branch_sum_report",
		                reportFile:'',
		                headers:"部门,业务员,长度,应收,应收比例,实收,欠款,到款率",
		                displaySumColum:"0,0,1,1,1,0,1,1",
		                
		                colAlign:"center,center,right,right,right,right,right,right",
		            	widthsP:"10,10,10,10,10,10,10,10", 
		            	
		                isSum:false,
		                isVertical:false,	            	
				};	
				
				print_div = 'branch_sum_chart_div';
		}
		
		if(curActiveTabIndex ==2){
			 printParam = {
					 	model: model,
					 	title:'频道汇总统计',
		                reportType: "branch_sum_report",
		                reportFile:'',
		                headers:"频道,业务员,长度,应收,应收比例,实收,欠款,到款率",
		                displaySumColum:"0,0,1,1,1,0,1,1",
		                
		                colAlign:"center,center,right,right,right,right,right,right",
		            	widthsP:"10,10,10,10,10,10,10,10", 
		            	
		                isSum:false,
		                isVertical:false,	            	
				};	
			print_div = 'channel_sum_chart_div';	
		}	
		
		if(curActiveTabIndex ==3){
			 printParam = {
					 	model: model,
					 	title:'时段收入欠款汇总表',
		                reportType: "branch_sum_report",
		                reportFile:'',
		                headers:"时段类型,时段名称,长度,应收,应收比例,实收,欠款,到款率",
		                displaySumColum:"0,0,1,1,1,0,1,1",
		                
		                colAlign:"center,center,right,right,right,right,right,right",
		            	widthsP:"10,10,10,10,10,10,10,10", 
		            	
		                isSum:false,
		                isVertical:false,	            	
				};	
			print_div = 'pos_sum_chart_div';	
		}		
		
		if(curActiveTabIndex ==4){
			 printParam = {
					 	model: model,
					 	title:'业务员及单位汇总表',
		                reportType: "branch_sum_report",
		                reportFile:'',
		                headers:"时段类型,时段名称,长度,应收,应收比例,实收,欠款,到款率",
		                displaySumColum:"0,0,1,1,1,0,1,1",
		                
		                colAlign:"center,center,right,right,right,right,right,right",
		            	widthsP:"10,10,10,10,10,10,10,10", 
		            	
		                isSum:false,
		                isVertical:false,	            	
				};	
			print_div = 'sign_user_customer_sum_chart_div';	
		}		
		
		
		if(curActiveTabIndex == 5){
			 printParam = {
					 	model: model,
					 	title:'行业广告收入欠款汇总表',
		                reportType: "branch_sum_report",
		                reportFile:'',
		                headers:"时段类型,时段名称,长度,应收,应收比例,实收,欠款,到款率",
		                displaySumColum:"0,0,1,1,1,0,1,1",
		                
		                colAlign:"center,center,right,right,right,right,right,right",
		            	widthsP:"10,10,10,10,10,10,10,10", 
		            	
		                isSum:false,
		                isVertical:false,	            	
				};	
			print_div = 'instry_sum_chart_div';	
		}				
		
		if(curActiveTabIndex == 6){
			 printParam = {
					 	model: model,
					 	title:'订单类别广告收入欠款汇总表',
		                reportType: "branch_sum_report",
		                reportFile:'',
		                headers:"时段类型,时段名称,长度,应收,应收比例,实收,欠款,到款率",
		                displaySumColum:"0,0,1,1,1,0,1,1",
		                
		                colAlign:"center,center,right,right,right,right,right,right",
		            	widthsP:"10,10,10,10,10,10,10,10", 
		            	
		                isSum:false,
		                isVertical:false,	            	
				};	
			print_div = 'order_cate_sum_chart_div';	
		}		
		
		if(curActiveTabIndex == 7){
			 printParam = {
					 	model: model,
					 	title:'品牌版本广告收入欠款汇总表',
		                reportType: "branch_sum_report",
		                reportFile:'',
		                headers:"品牌,版本,长度,应收,应收比例,实收,欠款,到款率",
		                displaySumColum:"0,0,1,1,1,0,1,1",
		                
		                colAlign:"center,center,right,right,right,right,right,right",
		            	widthsP:"10,10,10,10,10,10,10,10", 
		            	
		                isSum:false,
		                isVertical:false,	            	
				};	
			print_div = 'brand_edit_sum_chart_div';	
		}			
		
		
		if(curActiveTabIndex ==8){
			 printParam = {
					 	model: model,
					 	title:'客户类别广告收入欠款汇总表',
		                reportType: "branch_sum_report",
		                reportFile:'',
		                headers:"客户类别,客户,长度,应收,应收比例,实收,欠款,到款率",
		                displaySumColum:"0,0,1,1,1,0,1,1",
		                
		                colAlign:"center,center,right,right,right,right,right,right",
		            			widthsP:"10,10,10,10,10,10,10,10", 
		            	
		                isSum:false,
		                isVertical:false,	            	
				};	
			print_div = 'customer_cate_sum_chart_div';	
		}			
		
		
		if(curActiveTabIndex ==9){
			 printParam = {
					 	model: model,
					 	title:'客户品牌收入欠款汇总表',
		                reportType: "branch_sum_report",
		                reportFile:'',
		                headers:"客户名称,品牌,长度,应收,应收比例,实收,欠款,到款率",
		                displaySumColum:"0,0,1,1,1,0,1,1",
		                
		                colAlign:"center,center,right,right,right,right,right,right",
		            	widthsP:"10,10,10,10,10,10,10,10", 
		            	
		                isSum:false,
		                isVertical:false,	            	
				};	
			print_div = 'customer_brand_sum_chart_div';	
		}				
			
		
	 	var a = Object.extend(paramObj,printParam);
	 	
        myprint.loadApplet(a,ctxPath,800,500,print_div);	
	}
}


	var cols =[];
	var parentYAxisP =[];
	var parentYAxisS =[];

function get_startDay_endDay_str(){
	var startDate = Ext.getCmp('startdt').getValue();
	var endDate = Ext.getCmp('enddt').getValue();

	startDate = myDate.myFormatDate(startDate,"y-m-d");
	endDate = myDate.myFormatDate(endDate,"y-m-d");  
	var str_start_end = startDate +"至" +endDate;
	return str_start_end;
}
function getFusionChartObjs(){
	var caption_name = "";
	var args2 = "";
	var str_start_end = get_startDay_endDay_str();

	if(curActiveTabIndex ==1){
//		branch_sum_grid.hide();		
		
		if(displayModel==1){
			if(branch_sum_grid) branch_sum_grid.hide();
		}else{
			if(branch_sum_grid2) branch_sum_grid2.hide();
		}		

		$("branch_sum_chart_div").appendChild($("theDivChart"));
		caption_name = "部门汇总统计";
	    args2 ="时长,应收,实收,欠款";
	    cols = ["部门","业务员","时长","应收","应收比例","实收","欠款","到款率"];
		parentYAxisP = [3,5,6];
		parentYAxisS =[2];	
	}
	
	if(curActiveTabIndex ==2){
//		channel_sum_grid.hide();	
		if(displayModel==1){
			if(channel_sum_grid) channel_sum_grid.hide();
		}else{
			if(channel_sum_grid2) channel_sum_grid2.hide();
		}		
		$("channel_sum_chart_div").appendChild($("theDivChart"));
		caption_name = "频道汇总统计";
	    args2 ="时长,应收,实收,欠款";	
	    cols = ["频道","业务员","时长","应收","应收比例","实收","欠款","到款率"];
		parentYAxisP = [3,5,6];
		parentYAxisS =[2];	
	}
	

	
	if(curActiveTabIndex == 3){
//		pos_sum_grid.hide();	
		if(displayModel==1){
			if(pos_sum_grid) pos_sum_grid.hide();
		}else{
			if(pos_sum_grid2) pos_sum_grid2.hide();
		}		
		$("pos_sum_chart_div").appendChild($("theDivChart"));
		caption_name = "时段汇总统计";
	    args2 ="时长,应收,实收,欠款";	
	    cols = ["时段类型","时段名称","时长","应收","应收比例","实收","欠款","到款率"];
		parentYAxisP = [3,5,6];
		parentYAxisS =[2];	
	}	


	if(curActiveTabIndex == 4){
//		sign_cut_sum_grid.hide();	
// 
		if(displayModel==1){
			if(sign_cut_sum_grid) sign_cut_sum_grid.hide();
		}else{
			if(sign_cut_sum_grid2) sign_cut_sum_grid2.hide();
		}		
		$("sign_user_customer_sum_chart_div").appendChild($("theDivChart"));
		caption_name = "业务员及单位汇总表";
	    args2 ="时长,应收,实收,欠款";	
	    cols = ["业务员","客户","时长","应收","应收比例","实收","欠款","到款率"];
		parentYAxisP = [3,5,6];
		parentYAxisS =[2];	    
	}

	if(curActiveTabIndex == 5){
//		instry_sum_grid.hide();	
		if(displayModel==1){
			if(instry_sum_grid) instry_sum_grid.hide();
		}else{
			if(instry_sum_grid2) instry_sum_grid2.hide();
		}		
		$("instry_sum_chart_div").appendChild($("theDivChart"));
		caption_name = "行业广告收入欠款汇总表";
	    args2 ="时长,应收,实收,欠款";		
	    cols = ["行业类别","子类别","时长","应收","应收比例","实收","欠款","到款率"];
		parentYAxisP = [3,5,6];
		parentYAxisS =[2];	  
	}
	
	if(curActiveTabIndex == 6){
//		order_cate_sum_grid.hide();	
		if(displayModel==1){
			if(order_cate_sum_grid) order_cate_sum_grid.hide();
		}else{
			if(order_cate_sum_grid2) order_cate_sum_grid2.hide();
		}		
		$("order_cate_sum_chart_div").appendChild($("theDivChart"));
		caption_name = "订单类别广告收入欠款汇总表";
	    args2 ="时长,应收,实收,欠款";	
	    cols = ["订单类别","子类别","时长","应收","应收比例","实收","欠款","到款率"];
		parentYAxisP = [3,5,6];
		parentYAxisS =[2];	
	}
	
	if(curActiveTabIndex == 7){
//		brand_edit_sum_grid.hide();		
		if(displayModel==1){
			if(brand_edit_sum_grid) brand_edit_sum_grid.hide();
		}else{
			if(brand_edit_sum_grid2) brand_edit_sum_grid2.hide();
		}	
		$("brand_edit_sum_chart_div").appendChild($("theDivChart"));
		caption_name = "品牌版本广告收入欠款汇总表";
	    args2 ="时长,应收,实收,欠款";	
	    cols = ["品牌","版本","时长","应收","应收比例","实收","欠款","到款率"];
		parentYAxisP = [3,5,6];
		parentYAxisS =[2];	    
	}
	
	if(curActiveTabIndex == 8){
//		customer_cate_sum_grid.hide();	
		if(displayModel==1){
			if(customer_cate_sum_grid) customer_cate_sum_grid.hide();
		}else{
			if(customer_cate_sum_grid2) customer_cate_sum_grid2.hide();
		}		
		$("customer_cate_sum_chart_div").appendChild($("theDivChart"));
		caption_name = "客户类别广告收入欠款汇总表";
	    args2 ="时长,应收,实收,欠款";
	    cols = ["客户类别","客户","时长","应收","应收比例","实收","欠款","到款率"];
		parentYAxisP = [3,5,6];
		parentYAxisS =[2];	
	}	
	

	if(curActiveTabIndex == 9){
//		customer_cate_sum_grid.hide();	
		if(displayModel==1){
			if(customer_brand_sum_grid) customer_brand_sum_grid.hide();
		}else{
			if(customer_brand_sum_grid2) customer_brand_sum_grid2.hide();
		}		
		$("customer_brand_sum_chart_div").appendChild($("theDivChart"));
		caption_name = "客户品牌收入欠款汇总表";
		args2 ="时长,应收,实收,欠款";
		cols = ["客户名称","品牌","时长","应收","应收比例","实收","欠款","到款率"];
		parentYAxisP = [3,5,6];
		parentYAxisS =[2];	
	}	

		

    $("theDivChart").style.visibility = "visible";
    
 
	$("caption").value = caption_name +","+str_start_end;
	//如果 args2="" 则不显示
	
	
	var colunmCheckCmd = Ext.getCmp("clums2");
	if(colunmCheckCmd){
		    colunmCheckCmd.clearValue();
			colunmCheckCmd.destroy();
	}
	fusionCharts.makeColunmCheck("clums","clums2",100,args2,true);

	var defChartType = "scrollcombidy2d";
	fusionCharts.makeStyleCommand($("chartTypeDiv"),"chartType",100,defChartType);
	
	var defFontSie = "12";
	fusionCharts.makeFontSizeCommand($("baseFontSizeDiv"),"baseFontSize",40,defFontSie);
    
    //加载时就获得所有数据

    loadChartObjects();    

}



function loadChartObjects(){
	function func(objs){
		fusionChartObjects = objs;	
		renderFromQS();
	}
    
    var params = getParams();
    AnalyseSumManager.getChartObjs(params,func);	
}



function buildCustomXML(){

		var customXML ="";
		
	   customXML ="<styles>"
	      customXML +="<definition>";
	         customXML +="<style name='myFont' type='font' isHTML='1' bold='1' size='15' color='333333' />";
	         customXML +="<style name='myShadow' type='shadow' color='333333' angle='45' strength='2'/>";
	      customXML +="</definition>";
	      customXML +="<application>";
	         //customXML +="<apply toObject='YAxisValues' styles='myFont,myShadow' />";
	         //customXML +="<apply toObject='DataLabels' styles='myFont,myShadow' />";
	        // customXML +="<apply toObject='DataValues' styles='myFont,myShadow' />";
	         customXML +="<apply toObject='Caption' styles='myFont,myShadow' />";
	      customXML +="</application>";
	   customXML +="</styles>";
	   
		return customXML;
}	
	
function renderFromQS(){
	  

	chartWidth =   currentWindow.get("mainTab").getInnerWidth()-20;
	chartHeight = currentWindow.get("mainTab").getInnerHeight()-30;
//	$("chartdiv").style.width = ($("theDivChart").offsetWidth-10) +"px";
	
	var FCharts = new Charts();
	//chart属性
	FCharts.Chart.objs = fusionChartObjects;
	FCharts.Chart.transparent = "fasle" //true>>transparent false>>Opaque 
	FCharts.Chart.name = "myChart";
	FCharts.Chart.chartdiv = "chartdiv";
	FCharts.Chart.contPath = ctxPath;
	FCharts.Chart.chartType = $("chartType").value;
	FCharts.Chart.chartWidth = chartWidth;
	FCharts.Chart.chartHeight = chartHeight;
	FCharts.Chart.imageSave = 1;
	FCharts.Chart.imageSaveURL = ctxPath+"fusionChartsSave";
	FCharts.Chart.customXML = buildCustomXML(); //自定义风格

	//chart参数
	//labelDisplay='WRAP'
	//labelDisplay='ROTATE'
	//labelDisplay='Rotate' slantLabels='1'
	//labelDisplay='Stagger' staggerLines='n' caption
	var captions =  ($("caption").value).split(",");
	var caption ="";var subCation ="";
	if(!isUndefined(captions[0])) caption = captions[0];
	if(captions.length >1) subCation = captions[1];
	
	FCharts.ChartParams.caption = caption; 
	FCharts.ChartParams.subCaption = subCation;
	FCharts.ChartParams.labelDisplay = "WRAP";
//	FCharts.ChartParams.useEllipsesWhenOverflow = 1;
	
	FCharts.ChartParams.slantLabels = 5;
	FCharts.ChartParams.baseFontSize = $("baseFontSize").value; 
	FCharts.ChartParams.showValues = $("showValues").checked == true?1:0;
//	FCharts.ChartParams.placeValuesInside = 1;
	FCharts.ChartParams.showAboutMenuItem = 1;
	FCharts.ChartParams.aboutMenuItemLabel='';

	
//	FCharts.ChartParams.bgColor = "FFFFFF";




	//Data 及 lable ,
	//列名
	FCharts.LabelsData.cols = cols;
	//显示列
	FCharts.LabelsData.displays = fusionCharts.getDisplay("clums2",FCharts.LabelsData.cols);
	//alert(z.getSelectedValue());
	//parentYAxis=P
	FCharts.LabelsData.parentYAxisP = parentYAxisP;
	//parentYAxis=S
	FCharts.LabelsData.parentYAxisS = parentYAxisS;	

	

	FCharts.buildFusionCharts();
}

function replaceCaption() {
        var caption = window.prompt("请输入新标题如果有子标题请用逗号隔开","");
        $("caption").value = caption;
        renderFromQS();
}
  
function saveChart(){
         //Get chart from its ID
         var chartToPrint = getChartFromId("myChart");
         chartToPrint.saveAsImage();
}


function printChart(){
		//Get chart from its ID
		var chartToPrint = getChartFromId("chart1Id");
		chartToPrint.print();
}
	

	
function showHidden(){
	var oDiv = $("clums2");	
	var display = !(oDiv.style.visibility == "hidden")
	oDiv.style.visibility = display?"hidden":"visible";
	
}
