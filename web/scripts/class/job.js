function Job(){
	//创建对象
	this.obj ={};
	
	this.fileds =
	[
	        {name: "jobName", type: "string"},
	        {name: "jobGroup", type: "string"},
			{name: "name", type: "string"},
			{name: "triggerGroup", type: "string"},
			{name: "triggerType", type: "string"},
			{name: "cronExpression", type: "string"},
			{name: "prevFireTime", type: "string"},
			{name: "prevFireTime", type: "string"},
			{name: "priority", type: "string"},
			{name: "state", type: "string"},
			{name: "startTime", type: "string"},
			{name: "endTime", type: "string"},
			{name: "stop", type: "string"},
			{name: "delete", type: "string"},
			{name: "start", type: "string"},
			{name: "cronExpression", type: "string"},
			{name: "opts", type: "string"},
			{name: "startTriger", type: "string"}
	];
	
//	new Ext.form.TimeField({format:"H:i:s"}
//{name: "nextFireTime", type: "string",format:"yyyy-MM-dd HH:mm:ss"},
//			{name: "nextFireTime", type:Ext.data.Types.DATE,dateFormat:'Y-m-d\\TH:i:s'},
	
//	    private JobDataMap jobData;

	
	var opter = function(value,t){  
		alert(value);
	}; 
	
	

	/*列模型中渲染的按钮*/  
	var stopRender = function stop(value){  
	    stopRender='<TABLE class="x-btn-wrap x-btn x-btn-text-icon" id=save style="WIDTH:55px" cellSpacing=0 cellPadding=0 border=0>';  
	    stopRender+='<TBODY><TR><TD class=x-btn-left><I> </I></TD>';  
	    stopRender+='<TD class=x-btn-center><EM unselectable="on"><BUTTON id=ext-gen97 onclick=opter('+value+',0)>暂停</BUTTON></EM></TD>';  
	    stopRender+='<TD class=x-btn-right><I> </I></TD></TR></TBODY></TABLE>';  
	    return stopRender;  
	};  
  
	var startRender = function start(value){  
	    startRender='<TABLE class="x-btn-wrap x-btn x-btn-text-icon" id=save style="WIDTH:55px" cellSpacing=0 cellPadding=0 border=0>';  
	    startRender+='<TBODY><TR><TD class=x-btn-left><I> </I></TD>';  
	    startRender+='<TD class=x-btn-center><EM unselectable="on"><BUTTON id=ext-gen98 onclick=opter('+ value +',1)>启动</BUTTON></EM></TD>';  
	    startRender+='<TD class=x-btn-right><I> </I></TD></TR></TBODY></TABLE>';  
	    return startRender;  
	};  	
	
	var OBJ = this;
	
	
	var cm_job = new Ext.grid.ColumnModel([
	
		 new Ext.grid.RowNumberer(),  
	
	 {
		header : 'jobName',
		sortable : true,
		width : 160,
		id:'jobName',
		dataIndex : 'jobName',
		editor : new Ext.form.TextField({
			allowBlank : false,
			maxLength : 50
		})
	}, {
		header : 'jobGroup',
		width : 160,
		id:'jobGroup',
		dataIndex : 'jobGroup',
		menuDisabled : true,
		editor : new Ext.form.TextField({
			maxLength : 70
		})
	}, {
		header : '触发器名称',
		sortable : true,
		width : 160,
		id:'name',
		dataIndex : 'name',
		editor : new Ext.form.TextField({
			allowBlank : false,
			maxLength : 50
		})
	}, {
		header : '分组',
		width : 160,
		dataIndex : 'triggerGroup',
		menuDisabled : true,
		editor : new Ext.form.TextField({
			maxLength : 70
		})
	}, {
		header : 'trigger类型',
		width : 60,
		dataIndex : 'triggerType',
		menuDisabled : true,
		editor : new Ext.form.TextField({
			maxLength : 70
		})
	}, { 
		header : 'cronExp',
		width :160,
		dataIndex : 'cronExpression',
		menuDisabled : true,
//		resizable : false,
		editor : new Ext.form.TextField({
			maxLength : 70
		})

	}, { 
		xtype:'datecolumn',
		format:'Y-m-d H:i:s',
		header : '下次执行时间',
		width :160,
		dataIndex : 'nextFireTime',
		menuDisabled : true,
//		resizable : false,
		editor:new Ext.grid.GridEditor(new Ext.form.TimeField({format:"Y-m-d H:i:s"}))

	}, {
		header : '上次执行时间',
		width : 160,
		dataIndex : 'prevFireTime',
//		resizable : false,
		renderer:Ext.util.Format.dateRenderer('Y-m-d H:i:s'),
		editor : new Ext.form.TextField({
			allowBlank : false,
			maxLength : 20
		})
	}, {
		header : '优先级',
		width : 50,
		dataIndex : 'priority',
//		resizable : false,
		menuDisabled : true,
		editor : new Ext.form.TextField({
			maxLength : 20
		})
	}, {
		header : '状态',
		dataIndex : 'state',
		width : 50,
		menuDisabled : true,
		editor : new Ext.form.TextField({
			maxLength : 200
		})
	}, {
		header : '开始时间',
		dataIndex : 'startTime',
		width : 160,
		menuDisabled : true,
		renderer:Ext.util.Format.dateRenderer('Y-m-d H:i:s'),
		editor : new Ext.form.TextField({
			maxLength : 200
		})
	}, {
		header : '结束时间',
		dataIndex : 'endTime',
		width : 160,
		menuDisabled : true,
		renderer:Ext.util.Format.dateRenderer('Y-m-d H:i:s'),
		editor : new Ext.form.TextField({
			maxLength : 200
		})
	},
	
//	{header:'',width:50,dataIndex:'name',renderer:stopRender},
//	{header:'',width:50,dataIndex:'name',renderer:startRender}  
	{
		header : '',
		dataIndex : 'name',
		width : 80,
		menuDisabled : true,
		renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
			
			
			 var contentId = Ext.id();
			 var btn = createGridButton.defer(1, this, [contentId]);

			 function createGridButton(){
			  return new Ext.Button({
				 text: '暂停',
				 iconCls: 'stop',
				 handler: function(value){
				 	var triggerName = record.data['name'];
				 	var triggerGroup = record.data['triggerGroup'];
				 	 SchedulerManager.pauseTrigger(triggerName, triggerGroup);  
				 	 record.set('state', '暂停');
				 	 alert("该Trigger己经暂停！");      
				 }
				 }).render(document.body, contentId);
			 }
			 
			 return('<div id="'+contentId+'"/>');

		}
	},{
		header : '',
		dataIndex : 'delete',
		width :80,
		menuDisabled : true,
		renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){

			 var contentId = Ext.id();
			 var btn = createGridButton.defer(1, this, [contentId]);

			 function createGridButton(){
			  return new Ext.Button({
				 text: '删除',
				 iconCls: 'stop',
				 handler: function(value){
				 	var triggerName = record.data['name'];
				 	var triggerGroup = record.data['triggerGroup'];
				 	 SchedulerManager.removeTrigger(triggerName, triggerGroup);  
				 	 alert("删除！");        
				 }
				 }).render(document.body, contentId);
			 }
			 
			 return('<div id="'+contentId+'"/>');

		}
	},
		{
		header : '',
		dataIndex : 'name',
		width :80,
		menuDisabled : true,
		renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){

			 var contentId = Ext.id();
			 var btn = createGridButton.defer(1, this, [contentId]);

			 function createGridButton(){
			  return new Ext.Button({
				 text: '启动',
				 iconCls: 'stop',
				 handler: function(value){
				 	var triggerName = record.data['name'];
				 	var triggerGroup = record.data['triggerGroup'];
				 	 SchedulerManager.resumeTrigger(triggerName, triggerGroup);  
				 	 
				 	 record.set('state', '正在运行中');
				 	 
				 	alert("该Trigger正在运行中！");        
				 }
				 }).render(document.body, contentId);
			 }
			 
			 return('<div id="'+contentId+'"/>');

		}
	},{
		header : '',
		dataIndex : 'cronExpression', 
		width :80,
		menuDisabled : true,
		renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){

			 var contentId = Ext.id();
			 var btn = createGridButton.defer(1, this, [contentId]);

			 function createGridButton(){
			  return new Ext.Button({
				 text: 'cronEx',
				 iconCls: 'stop',
				 handler: function(value){
				 	var triggerName = record.data['name'];
				 	var cronExpression = record.data['cronExpression'];
				 	function callBackFunc(cronExp){
				 		 if(cronExp !='cancel'){
				 		 	 record.set('cronExpression',cronExp);
				 		 	//	 					 SchedulerManager.updateCronExpression(triggerName, cronExp,function aa(){alert("修改完成！");});  
				 		 }
				 	}
				 	
				 	OBJ.showCronExpressionWin(triggerName,cronExpression,callBackFunc);
//				 	Ext.Msg.prompt("标题", "消息提示",callBackFunc, this, 200, cronExpression);
				 	
			     
				 }
				 }).render(document.body, contentId);
			 }
			 
			 return('<div id="'+contentId+'"/>');

		}
	},
		{
		header : '',
		dataIndex : 'name',
		width :80,
		menuDisabled : true,
		renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){

			 var contentId = Ext.id();
			 var btn = createGridButton.defer(1, this, [contentId]);

			 function createGridButton(){
			  return new Ext.Button({
				 text: '配置',
				 iconCls: 'stop',
				 handler: function(value){
				 	var triggerName = record.data['name'];
//				 	var opts = record.data['opts'];
				 	
				 	
				 	function callFun(opts) {  
				 		Ext.Msg.prompt("标题", "消息提示",callBackFunc, this, 200, opts);
				 	}

				 	SchedulerManager.getJobConfigs(triggerName,callFun);
				 	
		            

  					function save(v) {  	
                        var params={};
                        v = v.split('|');                       
                        
//                        v = hostname +","+database+","+dbpath+","+username+","+password;
                        if(triggerName =='triggerSQLDump'){
					 	 	params.db_host = v[0];
					 	 	params.db_database = v[1];
					 	 	params.db_user = v[2];
					 	 	params.db_pass = v[3];
                        }

                        if(triggerName =='triggerTransfersdb'){
//                        	  v = serviceType +","+ hostname +","+targpath+","+username+","+password+","+existDate;
					 	 	params.serviceType = v[0],
					 	 	params.targ_hostname = v[1];
					 	 	params.targ_path = v[2];
					 	 	params.targ_username = v[3];
					 	 	params.targ_password = v[4];
					 	 	params.existDate = v[5];
                        }			


				 	    SchedulerManager.saveJobConfigs(triggerName, $H(params).toQueryString()); 
  					}			 	
	 	
					
	
					  
					
					
					function callBackFunc(id, text){
					         if (btn = "ok") {  
					                     save(text);
					           }  
					}
					  
					  
 
    
				 }
				 }).render(document.body, contentId);
			 }
			 
			 return('<div id="'+contentId+'"/>');

		}
	},
		{
		header : '',
		dataIndex : 'startTriger',
		width :80,
		menuDisabled : true,
		renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){

			 var contentId = Ext.id();
			 var btn = createGridButton.defer(1, this, [contentId]);

			 function createGridButton(){
			  return new Ext.Button({
				 text: '立即执行',
				 iconCls: 'stop',
				 handler: function(value){
				 	var jobName = record.data['jobName'];
				 	var jobGroup = record.data['jobGroup'];
				 	 SchedulerManager.startTriggerNow(jobName, jobGroup);  
				 	 
				 	 record.set('state', '正在运行中');
				 	 
				 	alert("该Trigger正在运行中！");        
				 }
				 }).render(document.body, contentId);
			 }
			 
			 return('<div id="'+contentId+'"/>');

		}
	}

	]);
	
	
	
	


   cm_job.defaultSortable = false;	
   
   
	this.cm_job = cm_job;

	return this;
};


	
Job.prototype.showCronExpressionWin= function(triggerName,cronExp1,callBackFunc){
  var OBJ = this;
  var urlStr=OBJ.ctxPath+"selectPopup/selectCronmaker.html";
  

  
   function removeWin(){win.destroy();}  
 
//  var closeFun = function(){ removeWin();	};

	var okBtn ={text: '保存',handler: function(){ 
  		var express =document.getElementById('conExpreiframe').contentWindow.getExp();
  		if(express !=''){
  			 SchedulerManager.updateCronExpression(triggerName, express,function aa(){callBackFunc(express);alert("修改完成！");});  
  		}
 
  	}};	
  	
	var closeBtn ={text: '关闭',handler: removeWin}; 

	 var win = new Ext.Window({
	   title : '生成CRON表达式',
	   width : 550,
	   height : 300,
	   isTopContainer : true,
	   modal : true,
	   resizable : false,
	    buttons: [okBtn,closeBtn],
	   contentEl : Ext.DomHelper.append(document.body, {
	    tag : 'iframe',
	     id : 'conExpreiframe',
	    style : "border 0px none;scrollbar:true",
	    src : urlStr,
	    height : "100%",
	    width : "100%"
	   })
	  })

  

   win.on({'close': {fn: removeWin}});
   
   	  win.show(); 
}


//Job.prototype.getStoreList = function(mode,paramObj){
//
//
////	mode = mode || 'local';
////	paramObj = paramObj || {};
//	var fileds= this.fileds;
//
//
//	var store = new Ext.data.Store({
//		proxy: new Ext.data.DWRHttpProxy({url: SchedulerManager.getQrtzTriggersJosn}),
//		reader: new Ext.data.DWRJsonReader({id:'name',root:'data',totalProperty:'totalSize'},fileds)
//	});
//	
//	if(mode == 'remote'){
//	  	store.on('beforeload', function(){
//	    	Ext.apply(this.baseParams, {dwrParams:[paramObj]});
//		}); 
//		store.load();			
//	}else{
//		store.load({params:{dwrParams:[paramObj]}});
//	}
//    
//
//	return store;
//};
//
//
//

Job.prototype.editJobs = function(){
	
	var ds_job_select = new Ext.data.Store({
		url : 'findAllCategoryName.action',
		reader : new Ext.data.JsonReader({
			root : 'root'
		}, [{name : 'categoryId',type : 'int'},
			{name : 'categoryName',type : 'string'}
		])
	});
	
	
	var cbb_jobName_for_job_edit = new Ext.form.ComboBox({
	name : '_companyName',
	width : 120,
	valueField : 'companyId',
	displayField : 'companyName',
	editable : false,
	selectOnFocus : true,
	mode : 'remote',
//	store :  ds_job_select,
	triggerAction : 'all',
	loadingText : '加载中...',
	fieldLabel : '任务名称',
	listeners : {
		'select' : function() {
			cbb_dept_for_book_update.reset();
			ds_dept_select.baseParams.companyId = cbb_company_for_book_update.getValue();
			ds_dept_select.reload();
			_editAddress = cbb_company_for_book_update.getEl().dom.value;
			bookEditForm.getForm().findField('address').setValue(_editAddress);
		}
	}
});
	
	
	var window_job = new Ext.Window({
		id:"window_job_id",
		title : '添加任务',
		width : 400,
		height : 440,
		resizable : false,
		autoHeight : true,
		modal : true,
		closeAction : 'hide',
		listeners : {
			'hide' : function() {
				this.setTitle('添加任务');
				this.findById('subject.subjectName').ownerCt.form.reset();
			}
		},
		items : [new Ext.FormPanel({
			labelWidth : 120,
			labelAlign : 'right',
			url : 'saveSubject.action',
			border : false,
			baseCls : 'x-plain',
			bodyStyle : 'padding:5px 5px 0',
			anchor : '100%',
			defaults : {
				width : 233,
				msgTarget : 'side' // 验证信息显示右边
			},
			defaultType : 'textfield',
			items : [{
				fieldLabel : '触发器名称',
				id : 'job.trigerName',
				name : 'job.trigerName',
				allowBlank : false,
				maxLength : 20
			},{
				fieldLabel : '扫描频率(分钟)',
				id : 'job.priority',
				name : 'job.priority',
				allowBlank : false,
				maxLength : 20
			},{
				fieldLabel : 'corn表达式',
				id : 'job.cornExpress',
				name : 'job.cornExpress',
				allowBlank : false,
				maxLength : 20
			},
			cbb_jobName_for_job_edit,
			 {
				fieldLabel : '任务描述',
				id : 'job.description',
				name : 'job.description',
				xtype : 'textarea',
				maxLength : 100
			}],
			buttonAlign : 'right',
			minButtonWidth : 60,
			buttons : [{
				text : '保存',
				handler : function(btn) {
					var frm = Ext.getCmp("window_job_id").ownerJOB.form;
					if (frm.isValid()) {
						btn.disable();
						var cnfield = frm.findField('subject.subjectName');
						frm.submit({
							waitTitle : '请稍候',
							waitMsg : '正在提交表单数据,请稍候...',
							success : function(form, action) {
								var store = grid_subject.getStore();
								var subject = new Subject({
									subjectId : action.result.subjectId,
									subjectName : cnfield.getValue(),
									remark : form.findField('subject.remark').getValue()
								});
								store.insert(0, [subject]);
								window_add_subject.setTitle('[ ' + cnfield.getValue() + ' ]   添加成功!!');
								cnfield.reset();
								btn.enable();
							},
							failure : function() {
								Ext.Msg.show({
									title : '错误提示',
									msg : '"' + cnfield.getValue() + '" ' + '名称可能已经存在!',
									buttons : Ext.Msg.OK,
									fn : function() {
										cnfield.focus(true);
										btn.enable();
									},
									icon : Ext.Msg.ERROR
								});
							}
						});
					}
				}
			}, {
				text : '重置',
				handler : function() {
//					this.ownerJOB.form.reset();
					Ext.getCmp("window_job_id").form.reset();
				}
			}, {
				text : '取消',
				handler : function() {
//					this.ownerJOB.hide();
						Ext.getCmp("window_job_id").hide();
				}
			}]
		})]
	});
	
//	window_job.ownerJOB = window_job;
   this.ownerJOB = window_job;
   return window_job;

}
Job.prototype.startSchedule = function(){
	SchedulerManager.startScheduler();
}

Job.prototype.stopSchedule = function(){
	SchedulerManager.shutdownScheduler();
}

Job.prototype.getQrtzTriggers = function(renderTo,mode,paramObj,callBackFun){
    var OBJ = this;
	var fileds= this.fileds;
	var win_job = this.editJobs();

	var store  = new Ext.data.Store(
            { 
            	proxy: new Ext.data.DWRHttpProxy({url: SchedulerManager.getQrtzTriggersJosn}),
            	reader:new Ext.data.DWRJsonReader({id:'name',root:'data',totalProperty:'totalSize'},fileds)
    });
            
    store.load();
   
	var btn_add = new Ext.Button({
		text : '新建任务',
		iconCls : 'icon-add',
		handler : function() {
			win_job.show();
		}
	});
	
	var btn_start_schedule = new Ext.Button({
		text : '启动调度',
		iconCls : 'icon-add',
		handler : function() {
			OBJ.startSchedule();
		}
	});
	
	var btn_stop_schedule = new Ext.Button({
		text : '停止调度',
		iconCls : 'icon-add',
		handler : function() {
			OBJ.stopSchedule();
		}
	});	
	 
//	alert(store.getAt(0));
	

	var cm_job = this.cm_job;
//	alert(store.getCount());
//	alert(cm_job);
//	var grid_job = new Ext.grid.EditorGridPanel({
	var grid_job = new Ext.grid.GridPanel({
		title : '任务调度管理',
		iconCls : 'icon-grid',
		loadMask : {msg : '数据加载中...'},
		region : 'center',
		cm : cm_job,
		ds : store,
		sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
		
		height: 320,    //10条记录时的行高;  
        view: new Ext.grid.GridView({  
                 forceFit:true  
       }), 

		enableColumnMove : false,
		trackMouseOver : false,
		frame : true,
		renderTo:renderTo,
//		bbar : new Ext.PagingToolbar({
//			pageSize : 20,
//			store : store,
//			displayInfo : true,
//			displayMsg : '第 {0} - {1} 条  共 {2} 条',
//			emptyMsg : "没有记录"
//		}),
		autoExpandColumn : 'name',
//		clicksToEdit : 0,
		tbar : [btn_add,btn_start_schedule,btn_stop_schedule]

//		listeners : {
//			'afteredit' : function(e) {
//				Ext.Ajax.request({
//					url : 'updateCompany.action',
//					params : {
//						fieldName : e.field,
//						fieldValue : e.value,
//						companyId : e.record.data.companyId
//					},
//					success : function() {
//						// alert("数据修改成功！");
//					},
//					failure : function() {
//						Ext.Msg.show({
//							title : '错误提示',
//							msg : '修改数据发生错误,操作将被回滚!',
//							fn : function() {
//								e.record.set(e.field, e.originalValue);
//							},
//							buttons : Ext.Msg.OK,
//							icon : Ext.Msg.ERROR
//						});
//					}
//				});
//			}
//		}
	});	
	
	
	
	
	
	
//var window_add_category = new Ext.Window({
//	title : '添加分类',
//	width : 500,
//	height : 300,
////	resizable : false,
//	renderTo:renderTo,
//	autoHeight : true,
//	modal : true,
//	closeAction : 'hide',
//	items : [grid_job]
//});	
	
	
	
//	window_add_category.show();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

};



