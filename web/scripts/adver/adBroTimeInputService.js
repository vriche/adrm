var carrierType = new CarrierType();
var carrier =new  Carrier();
var channel = new ResourceChannel();
var resourceSort = new ResourceSort();
var user = new User();
var resource = new Resource();
var customerProduct = new CustomerProduct();
var customer = new Customer();
var orderCategory = new OrderCategory();
var myDate = new MyDate();
var myUtils;
var config_serviceDate;
var tvNameParam;
var myprint =new MyPrint();
var winAdver;
var ctxPath;
var mygrid;
var mygrid2;
var inputTimeWin;
var checkAdvWin;


var resourceGridHeigth = 0;

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
	
		resetHeigth();
		
	ctxPath = _app_params.ctxPath;	 	
	myUtils = new MyUtils(config_serviceDate);
	_make_org_select("orgId",100,"resetStore");	
		
	get_resource_tables();
	
	get_ctrdata_tables();
	
	initGrid();
	
	initGrid2();
			
  }
  
	function resetHeigth(){
			var dialogcontent = $("dialogcontentDiv");
			var adBroTimeInput_const_div = $("adBroTimeInput_const_div");
			adBroTimeInput_const_div.style.height = dialogcontent.offsetHeight * 0.86 +"px";	
			resourceGridHeigth = dialogcontent.offsetHeight * 0.85;
    var adResCount = $("adResCount");
    adResCount.style.height = dialogcontent.offsetHeight * 0.85 +"px";		
    
//    var adResCount = $("adResCount2");
//    adResCount.style.height = dialogcontent.offsetHeight * 0.85 +"px";						
			
			
  } 
  

  
function get_resource_tables(){
	
  Ext.QuickTips.init();
    
//  var xg = Ext.grid;	
	
	var cm = new Ext.grid.ColumnModel([  
	 {header:'时间',dataIndex:'broadStartTimeS',menuDisabled:true,width:60,filterable: true,align:'center'},
  {header:'段位',dataIndex:'resourceName',menuDisabled:true,filterable: true,width:100},  
  {header:'描述',dataIndex:'memo',menuDisabled:true,filterable: true,width:50}
 ]); 	
 
 
 
 

//  var columnModel=new Ext.grid.ColumnModel({
//    columns:cm,
//    defaults: {
//	            sortable: true,
//	            menuDisabled: false,
////	            height:'auto',
//	            align: 'right'
////	            width:30
//	        }
//    });   
    
    
  var def_start_Dat =   myDate.parseDate(getFormatDay(_app_params.serviceDate.format2,"y-m-d"));
  var startDateFileld =  new Ext.form.DateField({
	        fieldLabel : '日期',
	        id : 'resource_date',
	        enableKeyEvents : true,
	        width : 100,
	        allowBlank : false,    
	        format : 'Y-m-d',
						renderTo: "resource_date_render_div",
//	         menuListeners : { 
//
//							select: function(m, d){ 
////							       this.setValue(d); 
//							       alert(d); 
//							   }, 
//							   show : function(){ // retain focus styling 
////							       this.onFocus(); 
//							   },hide : function(){ 
////							       this.focus.defer(10, this); 
////							       var ml = this.menuListeners; 
////							       this.menu.un("select", ml.select,  this); 
////							       this.menu.un("show", ml.show,  this); 
////							       this.menu.un("hide", ml.hide,  this); 
//							   } 
//	         				},
//	       	value:myDate.getStartDay3(def_Dat,"yyyy-MM-dd")

	       	value:def_start_Dat
	      });   
  
// startDateFileld.change = function(){alert(1);}
 startDateFileld.on("select" , function(box, d){
 	
 		 	var store8 = Ext.getCmp('carrier_cmd2').getStore();
			store8.baseParams.dwrParams[0].orgId =  config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;	
			store8.baseParams.dwrParams[0].memo =  Ext.getCmp('resource_date').getValue().format("Ymd"); 
			store8.reload();
			
			if(checkAdvWin) checkAdvWin.hide();
			
			
 				resetResourceStore();
 	
 	});
//	var my_cur_year =_app_params.serviceDate.year;
//	var comYear = myUtils.getComYear('year','年份',80,my_cur_year);  	
//	comYear.render("year_render_div");
	

	carrier.obj.callback = function aa(){};
	carrier.obj.orgId =  config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;
	carrier.obj.enable =  true;
	var carrierCmd = carrier.getLovCombo3('carrier_cmd',130,'remote',false,'频道名称','请选择频道...' );  
	carrierCmd.on("select" , function(box){resetResourceStore();});		
	carrierCmd.on("clear" , function(box){
				Ext.getCmp('resource_GridPanel').getStore().removeAll();
				mygrid.clearAll();
				DWRUtil.setValue("shiduan_desc", '');
//				mygrid2.clearAll();
				checkAdvWin.hide();		
		});		
		

         
  resourceSort.obj.orgId =  config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;	
	var resourceSortCmd  = resourceSort.getResourceSortCmd('resourceSort_cmd','remote',90,'时段属性','时段属性...');
	resourceSortCmd.on("select" , function(box){resetResourceStore2(0);});		
 	resourceSortCmd.on("clear" , function(box){resetResourceStore2(-1);});		
 	resourceSortCmd.hide();
 	
	resource.obj.orgId =  config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;	
	resource.obj.version = Ext.getCmp('resource_date').getValue().format("Y");
	resource.obj.carrierId =  Ext.getCmp('carrier_cmd').getValue() == ""?null: Ext.getCmp('carrier_cmd').getValue();
	resource.obj.inPublishDate = Ext.getCmp('resource_date').getValue().format("Ymd");
	resource.obj.resourceSort = resourceSortCmd.getValue() == ""?null:resourceSortCmd.getValue();
	resource.obj.orderBy = 1; //按时间先后并结合频道的玻出开始时间
	resource.obj.loginUser = loginUser;
	

	
	var checkNoInputBtn = {
		text:'检查',
		width:50,
		handler:function(){
			
			var publishDate = Ext.getCmp('resource_date').getValue().format("Ymd");
			var orgId = $("orgId").value;
			var carrierId =  Ext.getCmp('carrier_cmd').getValue() == ""?null: Ext.getCmp('carrier_cmd').getValue();
			
			
			if(!checkAdvWin){
						var closeBtn ={text: '关闭',handler: function(){checkAdvWin.hide();}};
						checkAdvWin=new Ext.Window({
//												id:"checkAdvWin",
//												name:"checkAdvWin",
 												 closeAction:'hide',
					           contentEl:"gridbox2",//主体显示的html元素，也可以写为el:"win"
					           width:600,
					           height:400,
					           title:"检查未输时间的广告" ,
					           buttons: [closeBtn],
					        });
			}
		
	 
//			alert(carrierId)
			

			var param ={
					orgId:orgId,
//					resourceIds:'',
					carrierId:carrierId,
        publishDate:publishDate,
        opt:2
         	}
         	
        
         	
 			var queryString =  $H(param).toQueryString();	
 			
			var func  = function(xml){
		function fn(){
			
		Ext.getBody().unmask();
 				//merge first 2 cells in the row with id "row1"
// 				mygrid2.setColspan("channel",0,0);
//      var colspan = mygrid2.getRowsNum();
//      for(var i = 0;i<colspan;i++){
//      	 var rowId = mygrid2.getRowId(i);
//      		mygrid2.setColspan(rowId,0,3);
//      			}
// 			mygrid2.groupBy(0);
// 			mygrid2.groupBy(1);

		}
		
		   checkAdvWin.show();		
				mygrid2.clearAll();
				
				mygrid2.loadXMLString(xml,fn);
//				mygrid2.setSizes();
   
      
      mygrid2.setSizes();	
				
				
			}
			
			Ext.getBody().mask('数据加载中……', 'x-mask-loading');
			PublishArrangeManager.getArrangedAdversByResourceId(queryString,func);	
		} 
	};




	var store = resource.getStoreObj2('remote',resource.obj);
	
//	var store = new Ext.data.Store();
	
	var storeBak = new Ext.data.Store();	
	Ext.apply(storeBak,store);		

	
	var grid = new Ext.grid.GridPanel({
    // A groupingStore is required for a GroupingView
    id:"resource_GridPanel",
    name:"resource_GridPanel",
    store: store,
//    colModel: columnModel,
			viewConfig : {
       forceFit : true //让grid的列自动填满grid的整个宽度，不用一列一列的设定宽度。
      		},
			cm:cm,
    frame:true,
    width: "100%",
    height: resourceGridHeigth,
    layout : 'fit',  
    animCollapse: false,
         loadMask: true,
     columnLines: true,
     	stripeRows: true,
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),  
    title: '广告资源',
    iconCls: 'icon-grid',
//    tbar:[startDateFileld,carrierCmd,resourceSortCmd],
     tbar:[carrierCmd,resourceSortCmd,checkNoInputBtn],
//    fbar  : ['->', {
//            text:'Clear Grouping',
//            iconCls: 'icon-clear-group',
//            handler : function(){
//                store.clearGrouping();//去除分组，好像没见添加分组的函数。
//            }
//        }],
    renderTo: "resource_grid_render_div"
	});
	
	
	
		carrierCmd.getStore().on("load" , function(box){
//				box.setValue(this.getAt(0).data.id)
				 Ext.getCmp('carrier_cmd').setValue(this.getAt(0).data.id);
//				 var store = resource.getStoreObj2('remote',resource.obj);
//					var cmdGrid =  Ext.getCmp('resource_GridPanel');
//					cmdGrid.bindStore(store);     
//					cmdGrid.store.load();
				 resetResourceStore();
		});		
		
//	store.load();
	
	grid.on('rowclick', function(grid, rowIndex, e) {

//    selectMenu.hide();

   
      
      if(checkAdvWin) checkAdvWin.hide();		

       var selections = grid.getSelectionModel().getSelections();
      
					var resourceId = 0;
       if (selections.length == 0) { Ext.Msg.alert('提示', "先选择行"); return; }
					var ids = new Array();
       for (var i = 0; i < selections.length; i++) {

           var record = selections[i];
   
           ids.push(record.get("id"));
							resourceId = record.get("id");
							
							var pos_desc1 = "&nbsp;&nbsp;&nbsp;"+record.get("broadStartTimeS");
							var pos_desc2 = record.get("resourceName");
							var pos_desc3 = record.get("memo");
							if(pos_desc2 !='') {
								pos_desc2 = "&nbsp;"+pos_desc2 + "&nbsp;";
							}
							
							if(pos_desc3 !='') {
								pos_desc3 = "&nbsp;"+pos_desc3 + "&nbsp;";
							}				
	
							
							pos_desc1 += pos_desc2 + pos_desc3
							
//							 +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ record.get("resourceName")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + record.get("memo");
							DWRUtil.setValue("shiduan_desc", pos_desc1);

							
//           field.setValue(record.get("name"));

       				}
       				
       				
       				
					var publishDate = Ext.getCmp('resource_date').getValue().format("Ymd");
		//			publishDate = myDate.myFormatDate(publishDate,myDate.dateFormat);
					var orgId = $("orgId").value;
			
		
					var paramObj ={
							orgId:orgId,
							resourceIds:ids,
		        publishDate:publishDate,
		        opt:1
		         	}
		         	
		     
		         	
		 			var queryString =  $H(paramObj).toQueryString();	
		 			
					var func  = function(xml){
						mygrid.clearAll();
						mygrid.loadXMLString(xml);
						Ext.getBody().unmask();	
					}
					
					Ext.getBody().mask('数据加载中……', 'x-mask-loading');
					PublishArrangeManager.getArrangedAdversByResourceId(queryString,func);	
		//			PublishArrangeManager.getAdversByResourceId(resourceId,publishDate,orgId,func);	
		        //field.setValue(rowIndex+"行");

    });
	
	
	
	
  function resetResourceStore2(i){
			
			if(i == -1){
					var sortId = resourceSortCmd.getValue();
					Ext.apply(store,storeBak);	
					resource.getFitterStore(store,sortId);		
			}		
			if(i == 0){
					var sortId = resourceSortCmd.getValue();
					resource.getFitterStore(store,sortId);			
			}		



	}	
	
	
	return grid;
	
}
  
 function get_ctrdata_tables(){
	
  Ext.QuickTips.init();

	var cm = new Ext.grid.ColumnModel([  
	 {header:'播出时间',dataIndex:'broTimeStr',menuDisabled:true,width:95,filterable: true,align: 'center'},
  {header:'节目/广告主题',dataIndex:'advContents',menuDisabled:true,filterable: true,width:150,align: 'left'},  
  {header:'时长',dataIndex:'broLength',menuDisabled:true,filterable: true,width:50,align: 'left'}
 ]); 	
 
 
 

//  var columnModel=new Ext.grid.ColumnModel({
//    columns:cm,
//    defaults: {
//	            sortable: true,
//	            menuDisabled: false,
//	            align: 'left',
//	            width:100
//	        }
//    });   
    

	

	carrier.obj.callback = function aa(){};
	carrier.obj.orgId =  config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;
	carrier.obj.memo = Ext.getCmp('resource_date').getValue().format("Ymd");
//	carrier.obj.memo = 20130101;
	
	
	var carrierCmd2 = carrier.getLovComboForCtr('carrier_cmd2',180,'remote',false,'频道名称','请选择频道...' );  
	carrierCmd2.on("select" , function(box){getCtrFitterStore();});		
	carrierCmd2.on("clear" , function(box){
		Ext.getCmp('ctrdata_GridPanel').getStore().removeAll();
//		getCtrFitterStore();
		});		
		

		
		
		
         
	resource.obj.resourceName = "-1";
	resource.obj.memo =   Ext.getCmp('resource_date').getValue().format("Ymd");
//	resource.obj.memo = 20130101;

			
	var store = resource.getStoreResourceCtrData('remote',resource.obj);

//	var store = resource.getStoreObj('remote',resource.obj);
//	var store = new Ext.data.Store();	
	
//	var storeBak = new Ext.data.Store();	
//	Ext.apply(storeBak,store);		
	
//	
//	 var store = new Ext.data.Store({
//	               proxy: new Ext.data.MemoryProxy([[1,2,3,4,5,6]]),
//	               reader: new Ext.data.ArrayReader({},[//注意在用数组填充数据时，为ArrayReader
//	                     {name:"id"},
//	                     {name:"channelName"},
//	                     {name:"broDate"},
//	                     {name:"brotime"},
//	                     {name:"advContents"},
//	                     {name:"broLength"}
//	             		  ])
//	              		});
	
	
//	store.load();

	
	
	var form = new Ext.FormPanel({
          region : 'center',
          labelWidth : 35,
          frame : true,
          bodyStyle : 'padding:5px 5px 0',
          autoScroll : true,
          border : false,
          fileUpload : true,
          items : [
             {
             xtype : 'textfield',
             fieldLabel : '文件1',
             name : 'userfile',
             id:'txtFile1',
             inputType : 'file',
             width : 130,
             allowBlank : true,
             blankText : 'File cannot be empty',
             height : 25,
             anchor : '90%'
             },
                          {
             xtype : 'textfield',
             fieldLabel : '文件2',
             name : 'userfile',
             id:'txtFile2',
             inputType : 'file',
             width : 130,
             allowBlank : true,
             blankText : 'File cannot be empty',
             height : 25,
             anchor : '90%'
             },
                          {
             xtype : 'textfield',
             fieldLabel : '文件3',
             name : 'userfile',
             id:'txtFile3',
             inputType : 'file',
             width : 130,
             allowBlank : true,
             blankText : 'File cannot be empty',
             height : 25,
             anchor : '90%'
             },
                          {
             xtype : 'textfield',
             fieldLabel : '文件4',
             name : 'userfile',
             id:'txtFile4',
             inputType : 'file',
             width : 130,
             allowBlank : true,
             blankText : 'File cannot be empty',
             height : 25,
             anchor : '90%'
             },
                          {
             xtype : 'textfield',
             fieldLabel : '文件5',
             name : 'userfile',
             id:'txtFile5',
             inputType : 'file',
             width : 130,
             allowBlank : true,
             blankText : 'File cannot be empty',
             height : 25,
             anchor : '90%'
             },
             {
             bodyStyle:"padding-left:60px",
             html:"<br/><span><font color='#666666'></font></span>"
             }],
//          buttons : [{
//            text : 'Upload',
//            type : 'submit',
//            handler : function() {
//             if(document.getElementById("txtFile").value == '') return;
//             if (!fp.form.isValid()) {return;}
//             		fp.form.submit({
//                waitMsg : 'Uploading ....',
//                url : 'FileUpload.ashx',
//                success : function(form, action) {win.close(this);},
//                failure : function(form, action) { win.close(this);}
//                						});
//             						}
//					             }, {
//					             text : 'Close',
//					             type : 'submit',
//					             handler : function() {
//					              win.close(this);
//					              }
//					              }]
              
              
              
          }); 
	
	
	
	var win_upload = new Ext.Window({ 
    title : '选择文件', 
    width :350, 
    height : 380, 
    modal : true, 
//    x : 100, 
//    y : 50, 
    layout : 'form', 
    autoScroll : true, 
    constrain : true, 
    bodyStyle : 'padding:10px 10px 10px 10px;', 
    items:form, 
    buttons : [{
    	 
        text : '开始导入', 
        
      	handler : function() { 

       	if (form.form.isValid()) { 
       		 
	        if(Ext.getCmp('txtFile1').getValue() == '' && Ext.getCmp('txtFile2').getValue() == '' && Ext.getCmp('txtFile3').getValue() == '' && Ext.getCmp('txtFile4').getValue() == '' && Ext.getCmp('txtFile5').getValue() == ''){ 
	         Ext.Msg.alert('溫馨提示','请选择要导入的文件'); 
	         return; 
	       				 } 
	       				 
	       				 
        	Ext.MessageBox.show(
        		{ 
           title : '请稍后......', 
           msg : '文件正在导入中....', 
           progressText : '', 
           width : 300, 
           progress : true, 
           closable : false, 
           animEl : 'loding' 
        				}); 
        				
        				
        	form.getForm().submit(
        					{ 
            url : 'servlet/importCtrExcelServlet', 
            method : 'POST', 
            success : function(form, action) { 
//            							console.log(form);
//            							console.log(action)




//								var fileds =
//								[
//										{name: "id", type: "int"},
//										{name: "carrierName", type: "string"}
//								];




							 				 
//    			 var ctr_data_grid =  Ext.getCmp('ctrdata_GridPanel');
//    			 ctr_data_grid.bak_store = action.result.res;
//    			 var store = ctr_data_grid.getStore();
    	
    			 
//    			 store.proxy = new Ext.data.MemoryProxy(action.result.res);
//    			 store.reader = new Ext.data.ArrayReader({},[//注意在用数组填充数据时，为ArrayReader
//	                     {name:"id"},
//	                     {name:"broDate"},
//	                     {name:"brotime"},
//	                     {name:"advContents"},
//	                     {name:"broLength"}
//	             		  ]);
// 					 store.proxy =  new Ext.data.MemoryProxy(action.result.res);
//					 store.load();
//		 			 store.load();  
					
						
//					  console.log(store)
    			 
//	       store = new Ext.data.Store({
//	               proxy: new Ext.data.MemoryProxy(action.result.res),
//	               reader: new Ext.data.ArrayReader({},[//注意在用数组填充数据时，为ArrayReader
//	                     {name:"id"},
//	                     {name:"broDate"},
//	                     {name:"broTime"},
//	                     {name:"advContents"},
//	                     {name:"broLength"}
//	             		  ])
//	              		});
						
								

							
								var carrier_cmd2 =  Ext.getCmp('carrier_cmd2');
								var store2 = carrier_cmd2.getStore();
//								console.log(action)


  
//        var json = action.response.responseText;  
//        var data = Ext.decode(json);  
        
//        alert(action.response.responseText)

//						console.log(action)
						
//						alert(action.result.carrierLable)
        
//        eval('var aa = '+action.result.carrierLable);
        
        			
//        console.log(aa)
        
       
//          console.log(Ext.decode(data.carrierLable))
//         store.loadData(aa);
         
//      	alert(action.result.carrierLable)
      	
//      	var data = action.result.carrierLable;
        
//        store.readRecords(data); 
//        store.reload();
//        store.loadData(data, true);
        
								
//								alert(eval(form.responseText)[0].name);
								
								
//								this.dom.value = action.responseText;
//								var aa =eval(action.result.carrierLable);
//								
//								alert(aa);
//								alert(Ext.isArray(action.result.carrierLable))
//								store6.load(eval(action.result.carrierLable))
//								store.loadData(eval(action.result.carrierLable))
//									store.loadData(action.result.carrierLable);
//									store2.proxy = new Ext.data.MemoryProxy(action.result.carrierLable);
//									store2.load();
									
									
									store2.baseParams.dwrParams[0].orgId =  config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;	
									store2.baseParams.dwrParams[0].memo =  Ext.getCmp('resource_date').getValue().format("Ymd"); 
									store2.reload();
									
//									Ext.Msg.alert('成功','恭喜！文件上传成功！'+action.result.success); 
            							
		            Ext.Msg.alert('成功','恭喜！文件导入成功！'); 
		                               
		            win_upload.hide(); 
     				    		}, 
		         failure : function(form, action) { 
		            Ext.Msg.alert('错误',"文件导入失敗，请重新操作！"); 
		        				 } 
       				 		}) 
      			 } 
      } 
    }, { 
        text : '关闭', 
        handler : function() { 
            win_upload.hide(); 
    } 
    }], 
    closable: false, 
    draggable: false, 
    resizable: false 
}); 
	
	

	
	
	
	
	var upBtn = 
	{id:"upload_excel",
	xtype: "button",
//	cls:"x-btn-icon",
//	cls:"admin-tool-export-xls",
	
//	icon:"/_static/icon/upload_excel.png",
	tooltip:"upload",
	scope:this,
	text:"数据导入",
	handler: function(){win_upload.show();}} ;
	
	
	
//	var upBtn ={
//                    text:'选择',
//                    iconCls:'admin-tool-export-xls',
//                    handler:function(){win_upload.show();}}
//                };

//	var upBtn ={ 
//					 id:"upload_excel",
//        text : '选择文件', 
////        iconCls:'admin-tool-export-xls',
//        handler : function() { function(){win_upload.show();}} 
//	};
	
	
	var grid = new Ext.grid.GridPanel({
    // A groupingStore is required for a GroupingView
    id:"ctrdata_GridPanel",
    name:"ctrdata_GridPanel",
    store: store,
//    colModel: columnModel,
         viewConfig : {
       forceFit : true //让grid的列自动填满grid的整个宽度，不用一列一列的设定宽度。
      		},
			cm:cm,
    frame:true,
    width: "100%",
    height: resourceGridHeigth,
    layout : 'fit',  
    animCollapse: false,
     loadMask: true,
     columnLines: true,
     	stripeRows: true,
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),  
    title: '广告监播数据',
//    iconCls: 'icon-grid',
    tbar:[carrierCmd2,upBtn],
    renderTo: "ctrdata_grid_render_div"
	});
	
//	grid.getSelectionModel().on("selectionchange", function(csm, rowIndex, record){
////			var c = _sub_grid_new_msg.getSelectionModel().getCount();
//			var c = self.getSelectionModel().getCount();
//			for (var i = 0; i < abuttons.length; i ++)
//			{
////	    			c > 0 ? abuttons[i].enable() : abuttons[i].disable();
//		    	if(!abuttons[i].disabledPrivilege && abuttons[i].disabledIfLessThan > 0 ){
//					c > 0 ? abuttons[i].enable() : abuttons[i].disable();
//				}
//			}
//		});	


//	grid.getSelectionModel().on("selectionchange", function(csm, rowIndex, record){
//		alert(rowIndex)
//	});
	
//	grid.on('rowclick', function(csm, rowIndex, record)  {
//	 	alert(record.broTime)
//	});
	
	
//	 grid.on('rowclick', function(grid2, rowIndex, ee)  {
//            var store = grid2.getStore();  
//            var oRecord = store.getAt(rowIndex); 
//            var broTimeStr =oRecord.data.broTimeStr.split(":")
//            Ext.getCmp('ctr_hour').setValue(broTimeStr[0]);
//            Ext.getCmp('ctr_min').setValue(broTimeStr[1]);
//            Ext.getCmp('ctr_sec').setValue(broTimeStr[2]);
//	 });
	 
	 
	 
	 

//	 if (grid.singleClick) {  
//        grid.on('rowclick', function(grid2, rowIndex, ee)  
//        			{  
//  
//            var store = grid2.getStore();  
//            var oRecord = store.getAt(rowIndex); 
//             alert(oRecord.broTime)
//             
//            grid.singleClick(oRecord);  
//            ee.stopEvent();  
//        }, grid);  
//    }  
	return grid;
	
} 









function getCtrFitterStore(){
	 var carrierId = Ext.getCmp('carrier_cmd2').getValue();
	 
	  if(carrierId =='') return false;
	 
	 var store6 = Ext.getCmp('ctrdata_GridPanel').getStore();

		var resourceName = Ext.getCmp('carrier_cmd2').getValue();
		if(carrierId >0){
			store6.baseParams.dwrParams[0].resourceName =   Ext.getCmp('carrier_cmd2').getRawValue();
			store6.baseParams.dwrParams[0].memo = Ext.getCmp('resource_date').getValue().format("Ymd");
//			store6.baseParams.dwrParams[0].memo  = 20130101;
			store6.reload();
		}

	 
//		store.filterBy(function(record,id){    
//					if(record.get('carrierName') == carrierName && carrierName !=''){          
//												return true;         
//											} else return false;  
//					});		
}




function resetResourceStore(){
	
		DWRUtil.setValue("shiduan_desc", '');
		
	 var carrierId = Ext.getCmp('carrier_cmd').getValue();
	 
	 Ext.getCmp('carrier_cmd2').fireEvent("clear",this);
	 Ext.getCmp('carrier_cmd2').setValue('');
	 


	 

//	 	 getCtrFitterStore();

	 if(carrierId =='') return false;
		 

	var cmdGrid =  Ext.getCmp('resource_GridPanel');
	var store6 = cmdGrid.getStore();

	
	var cmd7 =  Ext.getCmp('resourceSort_cmd');
	cmd7.clearValue(); 	 
//	var store6 = cmd6.getStore();
	if(store6.baseParams){
		if(store6.baseParams.dwrParams){
			var sortId = cmd7.getValue()== ""?null: cmd7.getValue();
			store6.baseParams.dwrParams[0].orgId =  config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;	
			store6.baseParams.dwrParams[0].version =   Ext.getCmp('resource_date').getValue().format("Y");
			store6.baseParams.dwrParams[0].carrierId =   Ext.getCmp('carrier_cmd').getValue()== ""?null: Ext.getCmp('carrier_cmd').getValue();
			store6.baseParams.dwrParams[0].resourceSort = sortId;
			
			store6.baseParams.dwrParams[0].orgId =  config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;	
			store6.baseParams.dwrParams[0].version =   Ext.getCmp('resource_date').getValue().format("Y");
			store6.baseParams.dwrParams[0].carrierId =   Ext.getCmp('carrier_cmd').getValue()== ""?null: Ext.getCmp('carrier_cmd').getValue();
			store6.baseParams.dwrParams[0].resourceSort = sortId;		
			store6.baseParams.dwrParams[0].inPublishDate = Ext.getCmp('resource_date').getValue().format("Ymd");			
		  store6.baseParams.dwrParams[0].orderBy = 1; //按时间先后并结合频道的玻出开始时间
			
			store6.reload();

			
			
			
//			store6.baseParams.dwrParams[0].orderBy = 1; //按时间先后并结合频道的玻出开始时间
//			store6.baseParams.dwrParams[0].loginUser = loginUser;




			
			

	
//			Ext.apply(store5,store6);	
//			cmd6.clearValue(); 	 
		}
	}	
}
  



  
function resetStore(){
	
	var orgId =   $("orgId").value;
	var version = Ext.getCmp('resource_date').getValue().format("Y");

}
  
  
  
  
  
  
  
  
  
function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = false;
	mygrid.setImagePath(getCtxPath()+"image/grid/");
	var flds = "序,广告名称,版本,订单号,长度,监播";
	var columnIds = "publishSort,matterName,matterEdit,matterLength,orderId,realTime";
	mygrid.setInitWidthsP("5,20,45,10,7,13");  
	mygrid.setHeader(flds);
	mygrid.setColumnIds(columnIds);

//    mygrid.enableLightMouseNavigation(true);
	mygrid.setColAlign("left,left,left,left,center,center");
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed"); 

	mygrid.setMultiLine(false);
//	mygrid.enableEditEvents()
	mygrid.setEditable(false);
	mygrid.enableDragAndDrop(true);
	mygrid.setDropHandler(do_drag);
	mygrid.setDragBehavior("nextSibling"); //nextSibling complex
//	mygrid.setOnEditCellHandler(do_onEditCell);
	mygrid.setOnRowDblClickedHandler(show_InputTime_win1);


	mygrid.enableAlterCss("even","uneven"); 
	mygrid.setSkin("modern2");
	//  mygrid.lockRow(3,true);
	mygrid.init();	 

}
function do_drag(r1,r2){
	if(isUndefined(r1)) return false;
	if(isUndefined(r2)) return false;
//	alert(r1);alert(r2);
	resetAdverOrder(mygrid,0);
}

function resetAdverOrder(grid,col_order){
	var cssText ="cursor: pointer;";
	var rowCount = grid.getRowsNum();
	var ctr_datas = new Array();
	for(var i = 0; i< rowCount;i++){
		var id = 	grid.getRowId(i);
		var cell = grid.cells(id,col_order);
		var sort = i+1;
		cell.setValue(sort);
		grid.setRowTextStyle(id,cssText);

		var ctrData = (new CtrData()).obj;
		ctrData.id = id;
		ctrData.broSort = sort;
		ctr_datas.push(ctrData);	

	}

	function func(){};
	PublishArrangeManager.saveArrangedAdversCtrTime(ctr_datas,2,func);	
	
	
}

function initGrid2(){

					mygrid2 = new dhtmlXGridObject('gridbox2');
					mygrid2.selMultiRows = false;
					mygrid2.setImagePath(getCtxPath()+"image/grid/");
					var flds = "频道,时段, 序 ,广告名称/版本,长度,监播";
					var columnIds = "channel,shiduan,publishSort,matterName,matterLength,realTime";
					mygrid2.setInitWidthsP("10,20,7,40,10,13");  
					mygrid2.setHeader(flds);
					mygrid2.setColumnIds(columnIds);
					mygrid2.setColAlign("left,left,center,left,center,center");
					mygrid2.setColTypes("ed,ed,ed,ed,ed,ed"); 
					mygrid2.setMultiLine(false);
					mygrid2.setEditable(false);
//					mygrid2.enableColSpan(true);
					mygrid2.setOnRowDblClickedHandler(show_InputTime_win2);

						
					mygrid2.enableAlterCss("even","uneven"); 
					mygrid2.setSkin("modern2");
					mygrid2.setSizes();		
					mygrid2.init();	 



	


		
//  var adResCount2 = $("adResCont2");
//  aResCount2.style.width = checkAdvWin.innerWidth +"px";	
//  $("gridbox2").style.width =  adResCount2.style.width;
//  alert(adResCount2.style.width)			
		 

				

}

function show_InputTime_win1(rowId,columnIndex){
	show_InputTime_win(rowId,columnIndex,1);
}
function show_InputTime_win2(rowId,columnIndex){
	show_InputTime_win(rowId,columnIndex,2);
}
 
function show_InputTime_win(rowId,columnIndex,model){

    var grid = (model == 1)?mygrid:mygrid2;

	 if(!inputTimeWin){

            
	 var timeFiledSet1 =    new Ext.form.FieldSet({
                title: '播出时',
                autoHeight: true,
                 layout:'column',
                defaultType: 'numberfield',
 											anchor:'98%',
                items: [{
																allowDecimals: false, // 是否与许小数
																decimalPrecision: 0, // 小数位精度
																allowNegative: false, // 是否允许负数
																selectOnFocus: true, // 
																maxLength:2,
																maxValue:24,
																minValue:0,    
//																xtype: 'textfield',
                        emptyText: '',
                        name: 'ctr_hour',
                        id: 'ctr_hour',
                         cls:'textfield-align-right',  
                        enableKeyEvents:true,
                        listeners : {  
//		                    			specialKey : function(field, e) {  
//		                    				 	alert(e.getKey())
//		                        		if (e.getKey() == Ext.EventObject.ENTER) {//响应回车  
//		                        		   Ext.getCmp('ctr_min').focus();
//		                        		  
////		                            queryHandler();//处理回车事件  
////		                            comName.selectText();//处理回车事件后选中输入框的文字  
//														                        }  
//														                    } ,
																		 keyup:function(field,e){
																		 	
																		 	  if((e.getKey()>47 && e.getKey()<58)||(e.getKey()>95 && e.getKey()<106)||e.getKey()==Ext.EventObject.ENTER){
						 																	var inputLength =  this.getValue()+"";
						 																	
						 																	if(this.getValue() >23){
						 																		 this.selectText();return false;
						 																	}
						 																	
																					   if(e.getKey() == Ext.EventObject.ENTER || inputLength.length ==2){
																					       			Ext.getCmp('ctr_min').focus();
																					       	}
																		 	   }
															
																		     }
												                },  
                        width:90
                    },  {
                               xtype: 'displayfield',
                               width:15,
                               align:'right',
                               value: '时'
                           },{
																allowDecimals: false, // 是否与许小数
																decimalPrecision: 0, // 小数位精度
																allowNegative: false, // 是否允许负数
																selectOnFocus: true, // 
																maxValue:60,
																minValue:0,    
                        emptyText: '',
                        name: 'ctr_min',
                        id: 'ctr_min',
                         cls:'textfield-align-right',  
                        enableKeyEvents:true,
                        listeners : { 
																	 keyup:function(field,e){
																		 	 if((e.getKey()>47 && e.getKey()<58)||(e.getKey()>95 && e.getKey()<106)||e.getKey()==Ext.EventObject.ENTER){
																		 	 				if(this.getValue() >60){
						 																		 this.selectText();return false;
						 																	}
						 																	
						 																	var inputLength =  this.getValue()+"";
																							if(e.getKey() == Ext.EventObject.ENTER || inputLength.length ==2){
																							       			Ext.getCmp('ctr_sec').focus();
																							 }
																		 	   }
															
																		     }	
                                                 					},
                        width:90
                    },  {
                               xtype: 'displayfield',
                               width:15, 
                               align: 'right',
                               value: '分'
                           },{
																allowDecimals: false, // 是否与许小数
																decimalPrecision: 0, // 小数位精度
																allowNegative: false, // 是否允许负数
																selectOnFocus: true, // 
																maxValue:60,
																minValue:0,  
																emptyText: '',
																id: 'ctr_sec',
                        name: 'ctr_sec',
                         cls:'textfield-align-right',  
                        enableKeyEvents:true,
                        listeners : { 
															 keyup:function(field,e){
																					 	 if((e.getKey()>47 && e.getKey()<58)||(e.getKey()>95 && e.getKey()<106)){
																					 	 				if(this.getValue() >60){
						 																		 				this.selectText();return false;
						 																				}
						 																	
									 																	var inputLength =  this.getValue()+"";
																										if(inputLength.length >2){
																										   this.setValue(inputLength.substring(0,inputLength.length-1));
																										    this.selectText();//处理回车事件后选中输入框的文字  
//																												e.stopEvent();  
																										 }
																					 	   }
															
																		     }																		     
                                                 				},
                        width:90
                    },  
                    
                          {
                               xtype: 'displayfield',
                               width:15, 
                               align: 'right',
                               value: '秒'
                           },{
                           	         xtype: 'displayfield',
                               width:5, 
                               align: 'right',
                               value: ''
                           },{
                    text: '重置',
                    width:50, 
                    xtype: 'button',
                    handler: function(){
                         Ext.getCmp('ctr_hour').setValue('00');
															  Ext.getCmp('ctr_min').setValue('00');
															  Ext.getCmp('ctr_sec').setValue('00');
                    							}
                           }
                ]
            });
            
            
    function selectGridRow(startIndex,endIndex,model,checkedItem){
    	
    	


				var ctrHour = Ext.getCmp('ctr_hour').getValue();
				var ctrMin = Ext.getCmp('ctr_min').getValue();
				var ctrSec = Ext.getCmp('ctr_sec').getValue();
				var ctrTime = ctrHour*3600 + ctrMin*60 + ctrSec*1;				
				
				var col_adLen = 4;
				var col_broTime = 5;
				
      for(var i = startIndex;i<(endIndex+1);){
	      	var rowId = 	grid.getRowId(i);
//	      	alert(i)
						if(model == 0){
								ctrTime = '';
								grid.cells2(i,col_broTime).setValue(ctrTime);
						}else{
							
								if(checkedItem == 4){
											var adlen = grid.cells2(i,col_adLen).getValue()*1;
//											ctrTime +=  adlen*1;
								}else{
			      				if(i>startIndex){
													var adlen = grid.cells2(i-1,col_adLen).getValue()*1;
													ctrTime +=  adlen*1;
											}
								}

									var time = myDate.FormatDate2(ctrTime,2);
									time = time =='undefined'|| isUndefined(time)?'00:00:00':time;
									grid.cells2(i,col_broTime).setValue(time);
						}

						i++;
            	}
            	
            
            }
            
            
    function getSelectGridRowObjs(){

				var col_adLen = 4;
				var col_broTime = 5;
				var rowCount = grid.getRowsNum();

				var objs = new Array();

      for(var i = 0;i< rowCount;){
      			
      			var id = grid.getRowId(i);
      	
	    				var ctrTimes = grid.cells2(i,col_broTime).getValue();
	    				
//	    				ctrTimes = (ctrTimes =='')? "00:00:00":ctrTimes;
	    				
							if(ctrTimes !=''){
		    				var ctrTime = ctrTimes.split(":");
		    				ctrTime  = ctrTime[0]*3600 + ctrTime[1]*60 + ctrTime[2]*1;	
								var ctrData = (new CtrData()).obj;
								ctrData.id = id;
								ctrData.broTime = ctrTime;
								objs.push(ctrData);
							}else{
									var ctrData = (new CtrData()).obj;
									ctrData.id = id;
									ctrData.broTime = null;
									objs.push(ctrData);
							}

							
						  i++;
            	}
            	
      return objs;
            	
            }
            
            
            
       function checkFun_switch(model) {

            							 var checkedItem = Ext.getCmp('rb-custwidth').getValue().inputValue;		
												
																 switch(checkedItem)
																	{
																	case 1: //修改首条到尾条
																				var startIndex = 0;
																				var endIndex = grid.getRowsNum()-1;
																				selectGridRow(startIndex,endIndex,model,checkedItem);
																	  break;
																	case 2: //修改本条到尾条
																				var startIndex = grid.getRowIndex(grid.getSelectedId());
																				var endIndex = grid.getRowsNum()-1;
																				selectGridRow(startIndex,endIndex,model,checkedItem);
//																	   alert(checkedItem);
																	  break;
																	case 3: //修改首条到本条
																				var startIndex = 0;
																				var endIndex = grid.getRowIndex(grid.getSelectedId());
																				selectGridRow(startIndex,endIndex,model,checkedItem);
																	  break;
																	case 4: //修改本条
																			  var startIndex = grid.getRowIndex(grid.getSelectedId());
																				var endIndex = startIndex;
																				selectGridRow(startIndex,endIndex,model,checkedItem);
																	  break;
																	default:
																	  
																	}		
             }     
            
//      function checkFun(checkbox,checked) {if(checked) checkFun_switch(1);}
      function checkFun(checkbox,checked) {}
      
	     var timeFiledSet2 =    new Ext.form.FieldSet({
                title: '处理模式',
                autoHeight: true,
                 layout:'column',
                defaultType: 'numberfield',
//                defaults: {width: 130},
 											anchor:'98%',
                items: [  {
						            xtype: 'radiogroup',
//						            fieldLabel: 'Multi-Column<br />(custom widths)',
						            columns: [180, 180],
						            vertical: true,
						            name:'rb-custwidth',
														id:"rb-custwidth",
						            items: [
						                {boxLabel: '修改首条到尾条', name: 'rb-custwidth', inputValue: 1,checked: true,listeners :{check : checkFun}},
						                {boxLabel: '修改本条到尾条', name: 'rb-custwidth', inputValue: 2, listeners :{check : checkFun}},
						                {boxLabel: '修改首条到本条', name: 'rb-custwidth', inputValue: 3,listeners :{check : checkFun}},
						                {boxLabel: '修改本条', name: 'rb-custwidth', inputValue: 4,listeners :{check : checkFun}}
						  
						            						]
						        }
                ]
            });
            
            


	 	
			var fp = new Ext.FormPanel({
		        labelAlign: 'top',
		        frame:true,
//		        bodyStyle:'padding:5px 5px 5px',
		        width: 600,
		        items: [timeFiledSet1,timeFiledSet2]
		    }); 	

	 	
        inputTimeWin = new Ext.Window({
//                applyTo:'hello-win',
											title: '录入播出时间 ',
                layout:'fit',
                width:430,
                height:280,
                closeAction:'hide',
//                closable:false,
                plain: true,
                modal : true, 
											items: [fp],
 

                buttons: [{
                    text:'保存',
                    disabled:false,
                    handler: function(){
																		var ctrHour = Ext.getCmp('ctr_hour').getValue();
																		var ctrMin = Ext.getCmp('ctr_min').getValue();
																		var ctrSec = Ext.getCmp('ctr_sec').getValue();
																		
																		if(ctrHour >23 || ctrMin >60 || ctrSec>60){
																			alert("时间输入有误，请检查!");return false;
																		}

                   	                                         
                    					checkFun_switch(1);
                    			
                    					
																		var ctr_datas = getSelectGridRowObjs();
																		
														
																		
																	  function func(){inputTimeWin.hide();};
																	  
																	
																	  
																		PublishArrangeManager.saveArrangedAdversCtrTime(ctr_datas,1,func);	
                    						}
                    
                							},{
                    text: '清除',
                    handler: function(){
                    	
                       checkFun_switch(0);
                       var ctr_datas = getSelectGridRowObjs();
															function func(){inputTimeWin.hide();};
															PublishArrangeManager.saveArrangedAdversCtrTime(ctr_datas,1,func);	
                    							}
               								 },{
                    text: '关闭',
                    handler: function(){
                        inputTimeWin.hide();
                    							}
               								 }
               								 
               								 
               								 ]
           						 });

        }
        

	 	
   inputTimeWin.show();
   
   
   
   
   
//  alert(Ext.getCmp('ctr_sec').getValue());
   	 	 
//   alert(Ext.getCmp('rb-custwidth'))
//   console.log(Ext.getCmp('rb-custwidth'))
//   alert(Ext.getCmp('rb-custwidth').items[0])

   var defCheckedValue = (model == 1)?1:4;

   Ext.getCmp('rb-custwidth').setValue(defCheckedValue);

//	var selections = Ext.getCmp('rb-ctrdata_GridPanel').getSelectionModel().getSelections();
	
	
	var gp =  Ext.getCmp('ctrdata_GridPanel').getSelectionModel();
  var oRecord = gp.getSelected();//返回收割选择的记录 
  if(oRecord){
	  var broTimeStr = oRecord.data.broTimeStr.split(":")
	  Ext.getCmp('ctr_hour').setValue(broTimeStr[0]);
	  Ext.getCmp('ctr_min').setValue(broTimeStr[1]);
	  Ext.getCmp('ctr_sec').setValue(broTimeStr[2]);
 	 }else{
 	 	  var bro_t = mygrid.cells(rowId,5).getValue();
 	 	  if(bro_t ==''){
			  Ext.getCmp('ctr_hour').setValue('00');
			  Ext.getCmp('ctr_min').setValue('00');
			  Ext.getCmp('ctr_sec').setValue('00');
 	 	  }else{
 	 	  	var broTimeStr = bro_t.split(":");
			  Ext.getCmp('ctr_hour').setValue(broTimeStr[0]);
			  Ext.getCmp('ctr_min').setValue(broTimeStr[1]);
			  Ext.getCmp('ctr_sec').setValue(broTimeStr[2]);
 	 	  }

 	  }



//    top.render(document.body);
}

// function initGrid(){
//	mygrid = new dhtmlXGridObject('gridbox');
//	mygrid.selMultiRows = true;
//	mygrid.setImagePath(getCtxPath()+"image/grid/");
//	var flds = "序,磁带号,广告名称,版本,长度,指定,备注,订单号,监播";
//	var columnIds = "publishSort,tapeCode,matterName,matterEdit,matterLength,specificName,publishMemo,orderId,realTime";
//	mygrid.setInitWidthsP("3,10,20,25,7,7,11,10,7");  
//	mygrid.setHeader(flds);
//	mygrid.setColumnIds(columnIds);
//
////    mygrid.enableLightMouseNavigation(true);
//	mygrid.setColAlign("left,left,left,left,left,left,left,left,center");
//	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed"); 
//
//	mygrid.setMultiLine(false);
////	mygrid.setEditable(true);
////	mygrid.setDragBehavior("nextSibling"); //nextSibling complex
////	mygrid.setOnEditCellHandler(do_onEditCell);
//
//	mygrid.enableAlterCss("even","uneven"); 
//	mygrid.setSkin("modern2");
//	//  mygrid.lockRow(3,true);
//	mygrid.init();	 
//
//} 
  
  
  
  
function initGrid_bak(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath( getCtxPath()+"image/grid/");
	flds = "序,广告名称,版本,长度,业务员,客户名称,订单编号,审核状态"; 
	mygrid.setInitWidthsP("5,15,15,10,10,20,15,10");
	mygrid.setHeader(flds);
	
	var columnIds = "publishSort,matterName,matterEdit,matterLength,ownerUserName,customerName,orderCode,checkState";
	mygrid.setColumnIds(columnIds);

	mygrid.setColAlign("center,left,left,center,center,left,center,center");
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,link,ed"); 

	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	mygrid.setDragBehavior("nextSibling"); //nextSibling complex

	mygrid.enableAlterCss("even","uneven");   
//	mygrid.setSkin("modern");  
	mygrid.init();  
}

function getAdversByResourceIdAndPublishDate(){
	
	var func  = function(xml){
		mygrid.clearAll();
		mygrid.loadXMLString(xml);
	}
	            

	PublishArrangeManager.getAdversByResourceId(resourceId,publishDate,orgId,func);	
}









