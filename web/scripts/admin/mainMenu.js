
var oaInfo = new OaInfo();
var popupcenter = new Popupcenter();
var MINUTE = 60 * 1000;
var HOUR = 60 * MINUTE;
var DAY = 24 * HOUR;
var WEEK = 7 * DAY;
var order = new Order(); 
var len;
var iscuikAlert = false;
var queryWindow;
var reportWindow;
var customer = new Customer();
var user = new User();
var myDate = new MyDate();
var report = new MyPrint();
var resourceType = new ResourceType();
var loginUser;
var cur_userId;
var fromPannel;
var utils;
var config_serviceDate;
var activeTable = 0;

var config_incomeMessageAlertParam;
var config_isSignUserBalance;
//var queryWindow;

var myMenu;
var cal;
//var year;
var loginUser;
var curYear;
//var win;
var cp;
var def_Date_start;
var	def_Date_end;

var build_more_paraArray;

 callOnLoad(init);	
// callOnFocus(closePopup);


 function init(){
 	
// 	if(check_app_params() == false) return false;




				

        cp = new Ext.state.CookieProvider(); 
		Ext.state.Manager.setProvider(cp); 

 	resetHeight();
//	setOrderPara(order);
//	setOaInfoPara(oaInfo);
//	showFlatCalendar();

	initMyMenu();
	
	ctxPath =  _app_params.ctxPath;	 	
	
	isFirstLogin =  _app_params.isFirstLogin=="1"?true:false;

	
	loginUser = _app_params.user.username;
	cur_userId = _app_params.user.id;
	tvNameParam =  _app_params.sysParam.tvNameParam;
		
	config_incomeMessageAlertParam = _app_params.rights.incomeMessageAlertParam;
	iscuikAlert = _app_params.rights.cuikMessageAlert == "1"?true:false;
	tag_orderList_finance = _app_params.rights.tag_orderList_finance;
	tag_role_fince = _app_params.rights.tag_role_fince;
	tag_publish_arrange = _app_params.rights.tag_publish_arrange;
	tag_publish_arrangeforce =  _app_params.rights.tag_publish_arrangeforce;
	tag_publish_arrange_view =  _app_params.rights.tag_publish_arrange_view;
	
	isEnableArray = tag_publish_arrange || tag_publish_arrangeforce || tag_publish_arrange_view;
	
	
	config_isSignUserBalance = _app_params.sysParam.isSignUserBalance;
	config_financeBalanceModelParam =  _app_params.sysParam.financeBalanceModelParam;
	config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;
	config_fastSignOrderParam = _app_params.sysParam.fastSignOrderParam;

	

	 
	utils = new MyUtils( _app_params.sysParam.serviceDate);
	curYear = _app_params.serviceDate.year;
	

		buttonEventFill();
	

	if(isFirstLogin && iscuikAlert){
		setTimeout("showOrderLog2();",1000);
	}
	

	
 }
 function resetHeight(){
//    var dialogcontent =  document.getElementById("dialogcontentDiv");
//	var main_page_fram = document.getElementById("main_page_fram");
//	main_page_fram.style.height =  dialogcontent.offsetHeight*0.85 +"px";	

    var dialogcontent =  document.getElementById("dialogcontentDiv");
    if(dialogcontent){
		var main_page_fram = document.getElementById("main_page_fram");
		main_page_fram.style.height =  dialogcontent.offsetHeight*0.85 +"px";	    	
    }	
}
 
function initMyMenu(){
	myMenu = new SDMenu("my_menu");
	myMenu.speed = 5;
	myMenu.remember = false;
	myMenu.oneSmOnly = true;
	myMenu.markCurrent = false;
	//myMenu.collapseAll();
	myMenu.init();	
}
 
 
 function buttonEventFill(){
	var btn_modifyPwd = $("btn_modifyPwd");
	btn_modifyPwd.setAttribute("href","javascript:void 0");
	btn_modifyPwd.onclick = selectUpatePwd;	
	
	
	var btn_calculator = $("btn_calculator");
	btn_calculator.setAttribute("href","javascript:void 0");
	btn_calculator.onclick = selectCalculator;	
	
	
	var btn_contractPayment = $("btn_contractPayment");
	btn_contractPayment.setAttribute("href","javascript:void 0");
	btn_contractPayment.onclick = selectContractPayment;		
	
	var btn_fastSignOrder = $("btn_fastSignOrder");	
	
	
	
	if(config_fastSignOrderParam == 1){
		if(btn_fastSignOrder){
			btn_fastSignOrder.show();
			btn_fastSignOrder.setAttribute("href","javascript:void 0");
			btn_fastSignOrder.onclick = add_new_OrderDetail_more;
		}
	
	}else{
		if(btn_fastSignOrder){btn_fastSignOrder.hide();}
		
	}

	
	
	
	var main_menus_fince_img = $("main_menus_fince_img");
	main_menus_fince_img.setAttribute("href","javascript:void 0");
	if(tag_role_fince == 1){
		 if(config_financeBalanceModelParam =='1'){
		 	  	main_menus_fince_img.onclick = function(){window.location.href='incomes2.html';}
		 }else{
		 		  main_menus_fince_img.onclick = function(){window.location.href='incomes.html';}
		 }
		 
	}
	
	var main_menus_arrange_img = $("main_menus_arrange_img");
	main_menus_arrange_img.setAttribute("href","javascript:void 0");
	
	if(isEnableArray){
		 		main_menus_arrange_img.onclick = function(){window.location.href='publishArranges.html';}	 
	}	
	
	


}

 
 
 function resetStore(){
 	
	var orgId =   Ext.getCmp('_org_cmd').getValue();
	var version =  Ext.getCmp('cuikuan_year').getValue();

    var dateField_start = Ext.getCmp('startDate');
    var dateField_end = Ext.getCmp('endDate');
    
    var startDate =    dateField_start.getValue();
    var endDate =    dateField_end.getValue();

	  var myDate=new Date();
	  myDate.setFullYear(version,startDate.getMonth(),startDate.getDate());
	  dateField_start.setValue(myDate); 
	  var myDate=new Date();
      myDate.setFullYear(version,endDate.getMonth(),endDate.getDate());
	  dateField_end.setValue(myDate); 

	var cmd1 =  Ext.getCmp('userId');
	var store1 = cmd1.getStore();
	store1.baseParams.dwrParams[0].orgId = orgId;
	store1.baseParams.dwrParams[0].version = version;
	store1.reload();
	cmd1.clearValue(); 
	
	var cmd2 =  Ext.getCmp('customerName2');
	var store2 = cmd2.getStore();	
	store2.baseParams.dwrParams[0].orgId = orgId;
	store2.baseParams.dwrParams[0].version = version; 
//	cmd2.params = store2.baseParams.dwrParams[0];
	store2.reload();	
	cmd2.clearValue(); 
	
	
	var cmd3 =  Ext.getCmp('resourceTypeId');
	var store3 = cmd3.getStore();	
	store3.baseParams.dwrParams[0].orgId = orgId;
	store3.baseParams.dwrParams[0].version = version;
	store3.reload();	
	cmd3.clearValue(); 
	
//	var cmd3 =  Ext.getCmp('resourceTypeId');
//	cmd3.clearValue(); 
//	var cmd3Tree = Ext.getCmp('resourceTypeTree');
//	cmd3Tree.loader.params[0].orgId = orgId;
//    cmd3Tree.root.reload(); 
	
}


	
function getValueFromStoreByTxt(id,filed1,filed2,def){
	var store = Ext.getCmp(id).getStore();	
	var text = Ext.fly(id).dom.value;
	if(text == '请选择...') return def;
	var index =  store.find(filed1, text);
	if(index == -1)
	  return 0;
	else
	 return store.getAt(index).get(filed2);
}



function getParam(){
	var orgId = Ext.getCmp('_org_cmd').getValue();
	var year = _app_params.serviceDate.year;
	var signUserId = "0";
	var resourceTypeId = "0";
	var customerName = "";
	var contractSortId = "";
	
//	var startDate = Ext.fly('startDate').dom.value;
//	var endDate = Ext.fly('endDate').dom.value;
	
	var startDate = Ext.getCmp('startDate').getValue();
	var endDate = Ext.getCmp('endDate').getValue();
	
//	 Ext.getCmp('startDate').setValue(def_Date_start);
//	 Ext.getCmp('endDate').setValue(def_Date_end);

// 	 startDate = myDate.getStartDay2(startDate);
//	 endDate = myDate.getEndDay2(endDate);   
	 
	 startDate = myDate.myFormatDate(startDate,myDate.dateFormat);
	 endDate = myDate.myFormatDate(endDate,myDate.dateFormat);  	
	 

	if(Ext.fly('cuikuan_year')) year = Ext.fly('cuikuan_year').dom.value;
	
	if(Ext.fly('userId')) signUserId = getValueFromStoreByTxt("userId","fullName","id",signUserId);
	
//	if(Ext.fly('resourceTypeId')) resourceTypeId =  Ext.getCmp('resourceTypeTree').getAllCheckedIds();
	if(Ext.fly('resourceTypeId')) resourceTypeId =  Ext.getCmp('resourceTypeId').getCheckedValue();
//	if(Ext.fly('contractSortId')) contractSortId =  Ext.getCmp('contractSortId').getCheckedValue('id');
    if(Ext.fly('contractSortId')) contractSortId =  Ext.getCmp('contractSortId').getValue();


	if(Ext.fly('customerName2')) customerName = Ext.fly('customerName2').dom.value;

	if(customerName == '请选择...') customerName='';
	                     
	var par={};
	

			                	
	par.orgId = orgId;
	par.year = year;
	par.signUserId = signUserId;
	par.customerName = customerName;
	par.resourceTypeId = resourceTypeId;
	par.startDate = startDate;
	par.endDate = endDate;
	par.contractSortId = contractSortId;
	par.defaultALL = Ext.getCmp(this._rememberMeId).getValue()==true?1:0;
	
	
	
	
	return par;          	
} 
 
 function showOrderLog2(){
	var dialogcontent = $("dialogcontentDiv");
	var dialogcontentW = dialogcontent.offsetWidth;
	var dialogcontentH = dialogcontent.offsetHeight;
	var winWidth= dialogcontentW * 0.8;
	var winHeight = dialogcontentH*0.8;
	var title = "催款提示";
	var reportURL = 'selectPopup/contractPaymentForm.html?winW='+winWidth*0.5+'&winH='+winHeight*0.5;
	var html ='<iframe id="iframeA" scrolling="auto" frameborder="0" width="100%" height="100%" src='+reportURL+'></iframe>';
	
	
//	 var fn = ResourceChannelManager.getResourceChannelSelectFromMap;
//     customer.storeCustomer = customer.getStoreMap('remote',{accountName:loginUser,accountBank:0});
//     user.obj.username = loginUser;
//     user.obj.version = 1;
//     user.storeUser = user.getStoreMap('remote',user.obj);
     
//     var storeChannel = utils.getStore(fn,null,'local',true,{},2);

//     var customerCommand1 = {
//        			xtype:"combo",
//	                fieldLabel: '客户名称',
//	                name: 'customerId',
//	                width:100,
//	                emptyText: '请选择...',
//                    store: storeCustomer,
//                    displayField: 'value',
//                    valueField:'key',
//                    editable: true,
//                    triggerAction: 'all',
//                    mode: 'local',
//                    allowBlank:false
//		            };
	    
	    
	  
	   var comYear = utils.getComYear('cuikuan_year','催款年度',150,curYear);  
	   var yyyy = comYear.getValue();
	   
	    comYear.on("select" , function(box){resetStore(); });  
       var orgCmd = _make_org_select2("","_org_cmd",150);
	   orgCmd.on("select" , function(box){resetStore(); });   	  
	  
	  
	    var paramObJ ={};
	 	paramObJ.type = 1;
	 	paramObJ.version = yyyy;
	 	paramObJ.orgId =  orgCmd.getValue();
	 	paramObJ.loginUser = loginUser;
	 	user.obj = paramObJ;
	    var userCmd = user.getUsersFromOrder("","userId",150,function(){
	    	  Ext.getCmp('userId').store.filterBy(function(record,id){  
	                     var text = record.get("id");  
	                     return (text.indexOf(cur_userId)!=-1);  
	                 });       
	    });
//        Ext.getCmp('userId').setValue(cur_userId);



	    var paramObJ2 ={};
	 	paramObJ2.version = yyyy;
	 	paramObJ2.orgId =  orgCmd.getValue();
	 	paramObJ2.loginUser = loginUser;
	 	customer.obj = paramObJ2;
	    var customerCmd = customer.getCustomerFromOrder("","customerName2",150,function(){})
//        customerCmd.on('beforequery', function(){customer.comboFilterBy2.createDelegate(this);});

	    
	    
	  	var paramObj3 ={};
	 	paramObj3.version = yyyy;
	 	paramObj3.orgId =  orgCmd.getValue();
	 	resourceType.obj = paramObj3;
//	    var resourceTypeCmd = resourceType.getResourceTypeForCmd("","resourceTypeId",150,function(){});
	    var resourceTypeCmd = resourceType.getLovCombo('resourceTypeId',true);
	    resourceTypeCmd.separator="_";
	    
//	    var tree = resourceType.getTree('resourceTypeTree',params,true);
//		var resourceTypeCmd = new ComboBoxTree({
//					        id:"resourceTypeId",
//					         fieldLabel : '归属分类',
//			               width : 150,
//			              // xtype : 'combotree',
//			               passName : 'typeId',
//			               autoScroll:true,
////			                renderTo : 'comboBoxTree',
//			               allowUnLeafClick : false,
//			               treeHeight:230,
//			               tree :tree,
//			               allowBlank : true        
//				});	   
//				
//		 var store = resourceType.store();		
//		 var resourceTypeCmd = new Ext.ux.form.LovCombo({
//		 	     fieldLabel: '催款类型'
//				 ,id:'contractSortId'
//				  ,name:'contractSortId'
//				,width:150
//				,hideOnSelect:false
//				,maxHeight:200
//				,readOnly: false 
//		  		,editable: false
//		  		,typeAhead: true
//				,emptyText: '请选择...' 
//				,store:store
//				,triggerAction:'all'
//				,valueField:'id'
//				,displayField:'name'
//				,mode:'local'
//			});				
				
				
				
				
				
				
				
				 
	    
	    
//	    alert(resourceTypeCmd.tree.loader.load());

   	    
	    
	
//		var startDate = new Ext.form.DateField({    
//                fieldLabel : '开始日期',    
//                emptyText : '请选择',    
////                disabledDays : [1, 2, 5],//将星期一,二,五禁止.数值为0-6,0为星期日,6为星期六    
//                labelWidth : 100,    
//                enableKeyEvents : true,
//                readOnly : true,    
//                allowBlank : false,    
//                format : 'Y-m-d',//日期格式    
//                name : 'startdt',    
//                id : 'startdt',    
//                vtype : 'daterange',//daterange类型为上代码定义的类型    
//                endDateField : 'endDate'//必须跟endDate的id名相同    
//            })    
    
//    curYear = _app_params.serviceDate.year;


    var serDate = myDate.parseDate(getFormatDay(_app_params.serviceDate.format2,"y-m-d"))        
 	var startDate = myDate.getStartDay2(serDate);
	var endDate = myDate.getEndDay2(serDate); 
  	def_Date_start =   myDate.parseDate(getFormatDay(startDate,"y-m-d"));
	def_Date_end =   myDate.parseDate(getFormatDay(endDate,"y-m-d"));   
	
	
  
     var startDateFileld =    new Ext.form.DateField({
        fieldLabel : '开始日期',
        name : 'startDate',
        id : 'startDate',
        enableKeyEvents : true,
        width : 150,
        allowBlank : false,    
        format : 'Y-m-d',
       	value:def_Date_start
       })      
            
      var endDateFileld =    new Ext.form.DateField({
        fieldLabel : '结束日期',
        name : 'endDate',
        id : 'endDate',
        enableKeyEvents : true,
        width : 150,
        allowBlank : false,    
        format : 'Y-m-d',
       	value:def_Date_end
       })    
       
  
       
// 	 var contractSortComboBox = new Ext.form.ComboBox({    
//        	fieldLabel: '催款类型',     //显示文本字段 
//            id:"contractSortId",
//            name: "contractSortId",
//            editable:false,//默认为true，false为禁止手写和联想功能
//            allowBlank:false,
//            store:["订单催款","协议催款"],
//            mode: 'local',//指定数据加载方式，如果直接从客户端加载则为local，如果从服务器断加载 则为remote.默认值为：remote
//            typeAhead: true,
//            triggerAction: 'all',
//            selectOnFocus:true,
//            width:150,
//            frame:true,
//            resizable:true
//        });
//	
//        contractSortComboBox.setValue("订单催款");        


// var contractSortComboBox = new Ext.ux.form.LovCombo({
// 	     fieldLabel: '催款类型'
//		 ,id:'contractSortId'
//		  ,name:'contractSortId'
//		,width:150
//		,hideOnSelect:false
//		,maxHeight:200
//		,readOnly: false 
//  		,editable: false
//  		,typeAhead: true
//		,emptyText: '请选择...' 
//		,store:new Ext.data.SimpleStore({
//			 id:0
//			,fields:[{name:'id',type:'int'}, 'name']
//			,data:[
//				 [1, '订单']
//				,[2, '协议']
//			]
//		})
//		,triggerAction:'all'
//		,valueField:'id'
//		,displayField:'name'
//		,mode:'local'
//	});

 var contractSortComboBox = new Ext.form.ClearableComboBox({
 	     fieldLabel: '催款类型'
		 ,id:'contractSortId'
		  ,name:'contractSortId'
		,width:150
		,hideOnSelect:false
		,maxHeight:200
		,readOnly: false 
  		,editable: false
  		,typeAhead: true
		,emptyText: '请选择...' 
		,store:new Ext.data.SimpleStore({
			 id:0
			,fields:[{name:'id',type:'int'}, 'name']
			,data:[
				 [1, '订单']
				,[2, '协约']
				,[3, '协议']
			]
		})
		,triggerAction:'all'
		,valueField:'id'
		,displayField:'name'
		,mode:'local'
	});

    
	
//	function customerComboCollapse(){  
//            customer.reset();
//	    	customer.obj.id = 1;
//	    	customer.comboCollapse(this,customer.obj);
////	    	alert(customer.obj.helpCode);
//	}
    	
//    var mode = 'remote';
//     customer.obj.orgId = 1;
//   customer.storeCustomer = customer.getStoreCustomersAnalyze(mode,customer.obj);        	
    		            
//   customer.customerCommand = {
//			                    xtype:'combo',
//			                    fieldLabel: '客户名称',
//			                    emptyText: '请选择...',
//			                    id:'customerName2',
//			                    name: 'customerName2',
//			                    store: customer.storeCustomer,
//			                    displayField: 'value',
//			                    valueField:'key',
//			                    editable: true,
//			                    triggerAction: 'all', //query all
//			                    lastQuery:'',
//			                    mode: 'remote', //local , remote
//			                    width:150,
//			                    allowBlank:false,
//			                    forceAll:true,
//			                    minChars:1,
//			                    hiddenName:'value', //提交传过去的值 
//			                    accountName:loginUser,accountBank:0,
//			                    listeners:{ 
//			                    	beforequery:customer.comboFilterBy.createDelegate(this)
//            					}				            
//		            
//		            
// };	          
 
 
 
//        var mode = 'remote';
//        customer.obj.orgId = 1;
//    	customer.storeCustomer = customer.getStoreCustomersAnalyze(mode,customer.obj);    
//
//		 customer.customerCommand = {
//		 	  xtype:'combo',
//		 	  id:'customerName2',
//		 	  name:'customerName2',
//	//	 	  applyTo: 'extCustomerDiv',
//			  renderTo:'extCustomerDiv',
//			  tiggerAction:'all',
//			  store:customer.storeCustomer,
//			  editable: true,
//			  triggerAction: 'all', //query all
//			  lastQuery:'1',
//			  displayField:'customerName',
//			  valueField:'id',
//			  mode:mode,
//			  width:138,
//			  forceSelection:false, 
//			  allowBlank:false,
//			  emptyText:'请选择...',
//			  minChars:2,
//			  hiddenName:'helpCode', //提交传过去的值 
//			  filterFiled:'customerName',
//			  params:customer.obj,
//			  listeners:{
//			  	beforequery:customer.comboFilterBy2.createDelegate(this)}
//			  	
//		 };


 

	
	
		            
    if(!fromPannel) {
    	
      this._rememberMeId = Ext.id();
	  this.rememberMeField = 'displayAllCuiKuan';
	  this.rememberMeLabel ='显示所有催款';
	  
	  var checkboxDisplayAll = {
            xtype       : 'checkbox',
            id          : this._rememberMeId,
            name        : this.rememberMeField,
            boxLabel    : '&nbsp;' + this.rememberMeLabel,
//            checked		: true,
            listeners: {
                render: function() {
//                    Ext.get(Ext.DomQuery.select('#x-form-el-' + this._rememberMeId + ' input')).set({
//                        qtip: '勾选后，30日内保存登录名.'
//                    });

	
			   		if(cp.get(this.rememberMeField)){ 
			           this.setValue(cp.get(this.rememberMeField));
			        }
                    
                },
                check: function(){
//                	alert(Ext.getCmp(this._rememberMeId).getValue())
                    if(Ext.getCmp(this._rememberMeId).getValue() == true){
                    	 Ext.state.Manager.set(this.rememberMeField,Ext.getCmp(this._rememberMeId).getValue());
                    }else{
                        Ext.state.Manager.clear(this.rememberMeField);
                    }
                },
                scope: this
            }
        };       	
    	
    	
    	
   		 fromPannel = new Ext.FormPanel({   
//                onSubmit: Ext.emptyFn,   
//				xtype: 'form',
				xtype:'tabpanel',
//                submit: function() {   
//                    this.getEl().dom.submit();   
//                },   
                labelWidth: 75, // label settings here cascade unless overridden   
                frame:true,   
                title: '',  
                bodyStyle:'padding: 0',   
                width: 350,   
                labelSeparator:'',   
                items: [orgCmd,comYear,startDateFileld,endDateFileld,customerCmd,userCmd,resourceTypeCmd,contractSortComboBox,checkboxDisplayAll]
				});  
				   	
    }
                function searchFun(){
        
			                	
			                	var par = getParam();
			                	
			               
			                	   
						        document.getElementById('iframeA').contentWindow.getContractPayment(par.orgId,par.year,par.signUserId,par.customerName,par.resourceTypeId,par.startDate,par.endDate,par.contractSortId,par.defaultALL);
						        
						        getPulls();
						        
						        queryWindow.hide();
						                  	
                	
                }
				
 
       if(!queryWindow){
			queryWindow = new Ext.Window({
			    title:'查询单据',
			    width:winWidth*0.5,
			    height:winHeight*0.7,
			    modal:true,
			    closeAction:'hide',
			    layout:'fit',
			    
			  
			    buttons:[{text:'确定',
			                handler:function(){
			                	searchFun();} 

			            },
			            {text:'重置',handler:function(){fromPannel.form.reset();}},
			            {text:'取消',handler:function(){queryWindow.hide();}
			            }
			            ],
			          items:fromPannel  
	
			
			 
			});
       }

			
			
			
			
			
	 var moduleId = '111111111';  
	 
	  var viewBtn = new Ext.Action({
		    text:'预览',
		    tooltip:'预览报表',
		    handler:function(){
//		    Ext.getDom('iframeA').src = reportURL;
//		    var desktopEl = Ext.fly('hello-win2');


	
	        var par = getParam();

		    var applet =  document.getElementById('iframeA').contentWindow.btn_display('view',par.orgId,par.year,par.signUserId,par.customerName,par.resourceTypeId,par.startDate,par.endDate,par.contractSortId,par.defaultALL);
		    
//		    alert(applet);
		    
	var moduleId = 'reportWindow';    
	if(!reportWindow){
		
            reportWindow = new Ext.Window({
            	id:moduleId,
            	title:'预览报表',
                //applyTo:'hello-win2',
//                renderTo: desktopEl,
                 modal:true,
                layout:'fit',
                //width:500,
                //height:300,
                closeAction:'hide',
                plain: true,
                width:winWidth,
                height:winHeight,
//				x:this.getWinX(winWidth-200),
//				y:this.getWinY(winHeight-200),
				minimizable:true,
				maximizable: true,
                items: {html:applet},

                buttons: [{
                    text:'Submit',
                    disabled:true
                },{
                    text: 'Close',
                    handler: function(){
                        reportWindow.hide();
                    }
                }]
            });
        }else{
	       
		reportWindow.removeAll();     
	        reportWindow.add({html:applet});
	        reportWindow.doLayout();
               
        	//reportWindow.render();
        }
        
       reportWindow.show(this);
				    
	
        
		    
		    
		    
//		    var a = document.getElementById('iframeA').contentWindow.document.getElementById('searche_pannel');
//		    
//		     var btn = win.getTopToolbar().items.get(0);
		    
		    

    			}
		});


//	  var viewBtn = new Ext.Action({
//		    text:'预览',
//		    tooltip:'预览报表',
//		    handler:function(){
//		    // Ext.getDom('iframeA').src = '/EXTcash/cashOutAction.do?method=lineChart&flag=coutType';
//		    document.getElementById('iframeA').contentWindow.btn_display('print');
//    			}
//		});		
	  var printBtn = new Ext.Action({
		    text:'打印',
		    tooltip:'打印报表',
		    handler:function(){
		    // Ext.getDom('iframeA').src = '/EXTcash/cashOutAction.do?method=lineChart&flag=coutType';
		    
		    
		    var par = getParam();
		    
		    
		    if(activeTable == 0)
		    	document.getElementById('iframeA').contentWindow.btn_display('print',par.orgId,par.year,par.signUserId,par.customerName,par.resourceTypeId,par.startDate,par.endDate,par.contractSortId);
		    else
		     	document.getElementById('iframeB').contentWindow.btn_display2('print',par.orgId,par.year,par.signUserId,par.customerName,par.resourceTypeId,par.startDate,par.endDate,par.contractSortId);

    		}
		});
		
	 var exportBtn = new Ext.Action({
		    text:'导出',
		    tooltip:'导出报表',
		    handler:function(){
		    // Ext.getDom('iframeA').src = '/EXTcash/cashOutAction.do?method=lineChart&flag=coutType';
		    
		    var par = getParam();
		    
		    if(activeTable == 0)
		    	document.getElementById('iframeA').contentWindow.btn_display('export',par.orgId,par.year,par.signUserId,par.customerName,par.resourceTypeId,par.startDate,par.endDate,par.contractSortId,par.defaultALL);
		    else
            	document.getElementById('iframeB').contentWindow.btn_display2('export',par.orgId,par.year,par.signUserId,par.customerName,par.resourceTypeId,par.startDate,par.endDate,par.contractSortId);

    			}
		});
		
		
//	var chartPanel = new Ext.Panel({
//	    title:'财务图表',
//	    width: 540,
//	    height: 400,
//	    tbar:[
//	       '-',printBtn,
//	       '-',exportBtn
//	    ],
//	    html:'<iframe id="iframeA" scrolling="auto" frameborder="0" width="100%" height="100%" src="/adrm"></iframe>'
//    });		
    
    
    

  var sendMsg = new Ext.Action({
		    text:'催款',
		    tooltip:'向业务员发送催款提示',
		    handler:function(){
		    	var grid = document.getElementById('iframeA').contentWindow.mygrid;
		    	document.getElementById('iframeA').contentWindow.sendCuiKuan2SignUser(grid);
		          
    			}
		}); 			
  var balance = new Ext.Action({
		    text:'平帐',
		    tooltip:'平帐',
		    handler:function(){
		    	var grid = document.getElementById('iframeA').contentWindow.mygrid;
		    	
		    	 if(document.getElementById('iframeB')){
		    	 	document.getElementById('iframeB').contentWindow.saveIncomeUsed(grid,searchFun);
		    	 }else{
		    	 	document.getElementById('iframeA').contentWindow.saveIncomeUsed(grid,searchFun);
		    	 }
		          
    			}
		}); 		
		
	  var search = new Ext.Action({
		    text:'搜索',
		    tooltip:'搜索',
		    handler:function(){
		    // Ext.getDom('iframeA').src = '/EXTcash/cashOutAction.do?method=lineChart&flag=coutType';
		    
		    	 queryWindow.show(this);
		    	 
//				    Ext.getCmp('userId').setValue(''); 
//		       	    Ext.getCmp('customerName2').setValue(''); 
//		       	    Ext.getCmp('contractSortId').setValue('');
//		       	    Ext.getCmp('resourceTypeId').clearValue(); 
//		       	    
//		       	    Ext.getCmp('startDate').setValue(def_Date_start);
//	 				Ext.getCmp('endDate').setValue(def_Date_end);
       	    
    			}
		});   	
		
	  var closeBtn ={text: '关闭',handler: function(){
	  	win.hide();
	  	if(fromPannel){
	  		fromPannel.form.reset();
	  	}
	  	}};
	  var buttons =[];
	  
	  
	 
		
		if(tag_role_fince==1 && config_incomeMessageAlertParam ==1){
			if(config_isSignUserBalance == 1){
				 buttons =[balance,sendMsg,search];
			}else{
				 buttons =[sendMsg,search];
			}
			
		}else{
			if(config_isSignUserBalance == 1){
				 buttons =[balance,search];
			}else{
				 buttons =[search];
			}
			
		}

//	   buttons[buttons.length] = viewBtn;
	   buttons[buttons.length] = printBtn;	
       buttons[buttons.length] = exportBtn;
       buttons[buttons.length] = closeBtn;
    
//  var search2 ={  
//         text:'查找',  
//         tooltip:'查找',  
//         iconCls:'search',  
//	 enableToggle: true,  
//	 toggleHandler: function() {  
//	 	   queryWindow.show(this);
//         } 
//  }


    

//  var p_center = new Ext.TabPanel({
//	id: 'centerPnl'
//	, region: 'center'
//	, border: false
//	, iconCls: 'tabs'
//	, enableTabScroll: true
//	, items: [{
//	title: '首页'
//	, autoScroll: true
//	}]
//	, defaults: { autoScroll: true }
//});


    var orgId = Ext.getCmp('_org_cmd').getValue();
//    var contractSortId =  Ext.getCmp('contractSortId').getCheckedValue('id');
    var contractSortId =   Ext.getCmp('contractSortId').getValue();
    
    
//    var reportURL1 = 'selectPopup/contractPaymentForm.html?winW='+winWidth+'&winH='+winHeight+'&mode=1&curYear='+curYear +'&orgId='+orgId+'&startDate='+startDate+'&endDate='+endDate+'&contractSortId='+contractSortId;
//    var reportURL2 = 'selectPopup/contractPaymentForm.html?winW='+winWidth+'&winH='+winHeight+'&mode=2&orgId='+orgId+'&startDate='+startDate+'&endDate='+endDate+'&contractSortId='+contractSortId;
//    var html1 ='<iframe id="iframeA" scrolling="auto" frameborder="0" width="100%" height="100%" src='+reportURL1+'></iframe>';
//    var html2 ='<iframe id="iframeB" scrolling="auto" frameborder="0" width="100%" height="100%" src='+reportURL2+'></iframe>';  
    
//    var tabs = new Ext.TabPanel({
//            region: 'center',
//            id:'cuikan_tab',
//            name:'cuikan_tab',
//            margins:'3 3 3 0', 
//            activeTab: 0,
//            defaults:{autoScroll:true},
//
//            items:[{
//                title: '催款信息',
//                html:html1,
//                listeners: {activate: function(){activeTable = 0;}}
//            },
//            {
//                title: '到款信息',
//                html:html2,
//                listeners: {activate: handleActivate}
//            }
////            ,{
////                title: 'Another Tab',
////                html:"<div id='hello-win2'/>",
////            },{
////                title: 'Closable Tab',
////                html:html,
////                closable:true
////            }
//            ]
//        });  
        
       var win =  Ext.getCmp(moduleId);
       
       if(win){
       	searchFun();
       	win.show(); 
       	return;
       	}  
    
    			
	   // items: {html:html},
	
            win = new Ext.Window({
            	id:moduleId,
            	title:'系统提示',
                //applyTo:'hello-win',
                //renderTo: desktopEl,
                layout:'fit',
                width:500,
                height:300,
                closeAction:'hide',
                plain: true,
                width:winWidth,
                height:winHeight,
                resizable:true, 
                 modal:true,
				minimizable:false,
				maximizable: false,
//                items: [tabs],
                tbar:[],
                buttons: buttons
            });
     
  
        	//win.load({
    			//url: reportURL,
    			//scripts: true // set this to true if there is any javascript
                  	 // on the target page that you would
                  	 // want to be executed
		//});


		
    var reportURL1 = 'selectPopup/contractPaymentForm.html?winW='+winWidth+'&winH='+winHeight+'&mode=1&curYear='+curYear +'&orgId='+orgId+'&startDate='+startDate+'&endDate='+endDate+'&contractSortId='+contractSortId;
    var reportURL2 = 'selectPopup/contractPaymentForm.html?winW='+winWidth+'&winH='+winHeight+'&mode=2&orgId='+orgId+'&startDate='+startDate+'&endDate='+endDate+'&contractSortId='+contractSortId;
    var html1 ='<iframe id="iframeA" scrolling="auto" frameborder="0" width="100%" height="100%" src='+reportURL1+'></iframe>';
    var html2 ='<iframe id="iframeB" scrolling="auto" frameborder="0" width="100%" height="100%" src='+reportURL2+'></iframe>';  		
		
	var tabs = new Ext.TabPanel({
            region: 'center',
            id:'cuikan_tab',
            name:'cuikan_tab',
            margins:'3 3 3 0', 
            activeTab: 0,
            defaults:{autoScroll:true},

            items:[{
                title: '催款信息',
                html:html1,
                listeners: {activate: function(){activeTable = 0;}}
            },
            {
                title: '到款信息',
                html:html2,
                listeners: {activate: handleActivate}
            }
//            ,{
//                title: 'Another Tab',
//                html:"<div id='hello-win2'/>",
//            },{
//                title: 'Closable Tab',
//                html:html,
//                closable:true
//            }
            ]
        });  		
		
		
		win.add(tabs);
		
		
		this.cuikuanWin = win;
		
		 win.show(this);
		 
//		    alert(win.getInnerHeight());
//		var  layout = document.getElementById('iframeA').contentWindow.resetHeigth;
//                Ext.EventManager.onWindowResize(layout);
		  
		//newwin = new Ext.Window.open(reportURL,"2222","");
		//newwin.show();




}

function getPulls(){
          var userName = '0';
          var customerName = '';
          
          if(Ext.fly('userId')){
          	 userName = Ext.getCmp('userId').getValue();
          }else{
               userName = cur_userId;
          
          }
          
	  	var startDate =  Ext.getCmp('startDate').getValue();
		var endDate =  Ext.getCmp('endDate').getValue();
		startDate = myDate.getStartDay2(startDate);
		endDate = myDate.getEndDay2(endDate);    
		
		
//		var contractSortId =  Ext.getCmp('contractSortId').getCheckedValue('id');
		 var contractSortId =   Ext.getCmp('contractSortId').getValue();    
          
          if(Ext.fly('customerName2')){
          	 customerName = Ext.fly('customerName2').getValue(); 
          	 
          	// alert(customerName);
          	 
          	 if(customerName == '请选择...') customerName='';
          }
	 var grid = document.getElementById('iframeA').contentWindow.mygrid;
	 
         var customerIds = document.getElementById('iframeA').contentWindow.getPayMentIds(grid,"customerId");
         
         if(document.getElementById('iframeB')){
         	
         	
		      var par = getParam();
		      
	          if(document.getElementById('iframeB').contentWindow.getIncomePulls){
	             document.getElementById('iframeB').contentWindow.getIncomePulls(par.orgId,par.year,par.resourceTypeId,par.signUserId,par.customerName,customerIds,startDate,endDate,contractSortId); 
	          }else{
	                // alert(userName);
	          	 var customerName2 = Ext.fly('customerName2');
	          	 if(customerName2) customerName =Ext.fly('customerName2').getValue(); 
	          	 if(customerName == '请选择...') customerName='';
	          	 var par = "&customerIds=" +customerIds.join(",")+"&signUserId="+par.signUserId+"&customerName="+par.customerName+"&orgId="+par.orgId+"&year="+par.year+"&resourceTypeId="+par.resourceTypeId;
	          	 par = "&startDate=" +startDate;
	          	 par = "&endDate=" +endDate;
	          	 par = "&contractSortId=" +contractSortId;
	          	 document.getElementById('iframeB').src =document.getElementById('iframeB').src+par;
	          }      	
         }

}
  function handleActivate(tab){
//       alert(tab.title + ' was activated.');
//        alert(tab.activeTab)
        activeTable = 1;
		getPulls();

   }
function showOrderLog(){
	var dialogcontent = $("dialogcontentDiv");
	var dialogcontentW = dialogcontent.offsetWidth;
	var dialogcontentH = dialogcontent.offsetHeight;
	var winW= dialogcontentW * 0.7;
	var winH = dialogcontentH*0.8;
	var title = "催款提示";
	var theme = "leopard"; //vista mac_os_x lighting black_hud leopard window
	var draggable = false;
	var minimize = false;
	var maximize = false;
	var close =  'destroy';
	var resizable = false;
	var urlStr = 'selectPopup/contractPaymentForm.html?winW='+winW+'&winH='+winH;
	openWindow('mywin',urlStr,winW,winH,title,theme,draggable,minimize,maximize,close,resizable);
}	

 	



function selectContractPayment(){
	showOrderLog2();
}

function selectUpatePwd(){
	
	var dialogcontent = $("dialogcontentDiv");
	var dialogcontentW = dialogcontent.offsetWidth;
	var dialogcontentH = dialogcontent.offsetHeight;
	var winW= dialogcontentW * 0.5;
	var winH = dialogcontentH*0.6;
	var title = "修改密码";
	var theme = "leopard"; //vista mac_os_x lighting black_hud leopard window
	var draggable = false;
	var minimize = false;
	var maximize = false;
	var close =  'destroy';
	var resizable = false;
	var urlStr = 'selectPopup/updatePassword.html?orderDetailId='+loginUser+'&winW='+winW+'&winH='+winH;
	//openWindow('mywin',urlStr,winW,winH,title,theme,draggable,minimize,maximize,close,resizable);
	
	var closeBtn ={text: '取消',handler: function(){win.hide();}};
	var okBtn ={text: '修改',handler: function(){document.getElementById('passwdiframe').contentWindow.update();}};
  
        
 var win = new Ext.Window({
   title : '修改密码',
   //maximizable : true,
   // maximized : true,
   width : winW,
   height : winH*1.05,
   // autoScroll : true,
   // bodyBorder : true,
   // draggable : true,
   isTopContainer : true,
   modal : true,
   resizable : false,
    buttons: [okBtn,closeBtn],
   contentEl : Ext.DomHelper.append(document.body, {
    tag : 'iframe',
    id : 'passwdiframe',
    style : "border 0px none;scrollbar:true",
    src : urlStr,
    height : "100%",
    width : "100%"
   })
  })
  win.show(); 
	
	
	
}

function selectCalculator(){
//	var src = "selectPopup/queryAdresChart.html";
//	popupcenter.url = src;
//	popupcenter.model = 12;
//	popupcenter.popupcenter(popupcenter);
	
	
	var dialogcontent = $("dialogcontentDiv");
	var dialogcontentW = dialogcontent.offsetWidth;
	var dialogcontentH = dialogcontent.offsetHeight;
	var winW= dialogcontentW * 0.9;
	var winH = dialogcontentH*0.99;
	var title = "资源查询";
	var theme = "leopard"; //vista mac_os_x lighting black_hud leopard window
	var draggable = false;
	var minimize = false;
	var maximize = false;
	var close =  'destroy';
	var resizable = false;
	var urlStr = 'selectPopup/queryAdresChart.html?winW='+winW+'&winH='+winH+"&loginUser="+loginUser;
	//openWindow('mywin',urlStr,winW,winH,title,theme,draggable,minimize,maximize,close,resizable);
	
var okBtn ={text: '搜索',handler: function(){document.getElementById('resiframe').contentWindow.getFusionChartObjects();}};	
var closeBtn ={text: '关闭',handler: function(){win.hide();}};
  
        
 var win = new Ext.Window({
   title : '资源查询',
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
    buttons: [okBtn,closeBtn],
   contentEl : Ext.DomHelper.append(document.body, {
    tag : 'iframe',
     id : 'resiframe',
    style : "border 0px none;scrollbar:true",
    src : urlStr,
    height : "100%",
    width : "100%"
   })
  })
  win.show(); 
	
}
     

	
 
function getEventNotic(){
    parent.location.href ="oaWorkFlowChecks.html";	
}
 
 function setOrderPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className = "order";	
	 obj.IdPrefix 	= obj.className + "Id";
}
 

 function setOaInfoPara(obj){
	 obj.className ="oaInfo";
	 obj.selectName =  "selectNotice"; 
}
 

function isDisabled(date) {
	  var today = new Date();
	  return (Math.abs(date.getTime() - today.getTime()) / DAY) > 10;
}
	
	
//	
//function showFlatCalendar() {
//	  cal = new Calendar(0, null, null); 
//	  var parent = document.getElementById("display");
//	  // construct a calendar giving only the "selected" handler.
//	  // hide week numbers
//	  cal.weekNumbers = false;
//	  // We want some dates to be disabled; see function isDisabled above
//	  cal.setDisabledHandler(isDisabled);
//	  cal.setDateFormat("%A, %B %e");
//	  // this call must be the last as it might use data initialized above; if
//	  // we specify a parent, as opposite to the "showCalendar" function above,
//	  // then we create a flat calendar -- not popup.  Hidden, though, but...
//	  cal.create(parent);
//	  // ... we can show it here.
//	  cal.onSelected = setYear;
//	  cal.show();
//	  
//	function setYear(){
//  		year =  cal.date.getFullYear();
//  		getOrders();	
// 	}
//}
	

function getOrders(el){
 	    var year = cal.date.getFullYear();
        
        
	function func(data){
		 var html = "";
		
     		if(data>0){
      			//$("checkNotic").options[0]=new Option("" + year + "年 有"+counts+"条未审订单",1,false,false);
      			html += "<a href='javascript:void 0' onclick='getEventNotic()'>" + year + "年有"+ data +"条未审订单</a>"
      		}
      			 
		$("checkNotic").innerHTML = html;
		el = $("evenId");
		//myMenu.toggleMenu(el);
		myMenu.expandMenu(el);	
	}	
	order.getOrdersByCheckState2(1,loginUser,year,func);
}

function getOaInfoSelect(el){
	var func = function(objs){
			myMenu.toggleMenu(el);	
			//myMenu.expandMenu(el);		
	}
	oaInfo.reset();
	oaInfo.makeSelect(oaInfo,$(oaInfo.selectName),"autoBroArrangeOaInfo",func);
}

function autoBroArrangeOaInfo(id){
	popupcenter.url = "selectPopup/selectOaInfo.html?id=" + id;
	popupcenter.model = 6;
	popupcenter.popupcenter(popupcenter);
}


 

function add_new_OrderDetail_more(){
//	var orderCategoryMain = getSelectParamFromAttribute($("categoryId"),"calculateauto");//根据付款分配应收

	var orgCount = _app_params.rights.userOrgs.length;
	
	var func = function(oid){
		var orgId = 1;
		if(oid){orgId = oid;};
		orgId = config_oneOrgMoreSuborgsParam == '1'?1:orgId;
		
		

		var paramObj={
				orgId: orgId,   
				orderId:0,
				fromModel:3
		}   
		
	    
	    build_more_paraArray =  get_fast_sign_order_win(ctxPath,paramObj);
	    
	   
	
	    build_more_paraArray.show();
	}

	if(orgCount > 1){
		showOrg_prompt_whith_comboBox(func);
	}else{
		func();
	}
	



}

//function closePopup(ev){
//	popupcenter.closePopup(popupcenter);
//}
//
//function closePopup(){
//		popupcenter.closePopup(popupcenter);
//}