function Job(){
	//��������
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
	
	

	/*��ģ������Ⱦ�İ�ť*/  
	var stopRender = function stop(value){  
	    stopRender='<TABLE class="x-btn-wrap x-btn x-btn-text-icon" id=save style="WIDTH:55px" cellSpacing=0 cellPadding=0 border=0>';  
	    stopRender+='<TBODY><TR><TD class=x-btn-left><I> </I></TD>';  
	    stopRender+='<TD class=x-btn-center><EM unselectable="on"><BUTTON id=ext-gen97 onclick=opter('+value+',0)>��ͣ</BUTTON></EM></TD>';  
	    stopRender+='<TD class=x-btn-right><I> </I></TD></TR></TBODY></TABLE>';  
	    return stopRender;  
	};  
  
	var startRender = function start(value){  
	    startRender='<TABLE class="x-btn-wrap x-btn x-btn-text-icon" id=save style="WIDTH:55px" cellSpacing=0 cellPadding=0 border=0>';  
	    startRender+='<TBODY><TR><TD class=x-btn-left><I> </I></TD>';  
	    startRender+='<TD class=x-btn-center><EM unselectable="on"><BUTTON id=ext-gen98 onclick=opter('+ value +',1)>����</BUTTON></EM></TD>';  
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
		header : '����������',
		sortable : true,
		width : 160,
		id:'name',
		dataIndex : 'name',
		editor : new Ext.form.TextField({
			allowBlank : false,
			maxLength : 50
		})
	}, {
		header : '����',
		width : 160,
		dataIndex : 'triggerGroup',
		menuDisabled : true,
		editor : new Ext.form.TextField({
			maxLength : 70
		})
	}, {
		header : 'trigger����',
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
		header : '�´�ִ��ʱ��',
		width :160,
		dataIndex : 'nextFireTime',
		menuDisabled : true,
//		resizable : false,
		editor:new Ext.grid.GridEditor(new Ext.form.TimeField({format:"Y-m-d H:i:s"}))

	}, {
		header : '�ϴ�ִ��ʱ��',
		width : 160,
		dataIndex : 'prevFireTime',
//		resizable : false,
		renderer:Ext.util.Format.dateRenderer('Y-m-d H:i:s'),
		editor : new Ext.form.TextField({
			allowBlank : false,
			maxLength : 20
		})
	}, {
		header : '���ȼ�',
		width : 50,
		dataIndex : 'priority',
//		resizable : false,
		menuDisabled : true,
		editor : new Ext.form.TextField({
			maxLength : 20
		})
	}, {
		header : '״̬',
		dataIndex : 'state',
		width : 50,
		menuDisabled : true,
		editor : new Ext.form.TextField({
			maxLength : 200
		})
	}, {
		header : '��ʼʱ��',
		dataIndex : 'startTime',
		width : 160,
		menuDisabled : true,
		renderer:Ext.util.Format.dateRenderer('Y-m-d H:i:s'),
		editor : new Ext.form.TextField({
			maxLength : 200
		})
	}, {
		header : '����ʱ��',
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
				 text: '��ͣ',
				 iconCls: 'stop',
				 handler: function(value){
				 	var triggerName = record.data['name'];
				 	var triggerGroup = record.data['triggerGroup'];
				 	 SchedulerManager.pauseTrigger(triggerName, triggerGroup);  
				 	 record.set('state', '��ͣ');
				 	 alert("��Trigger������ͣ��");      
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
				 text: 'ɾ��',
				 iconCls: 'stop',
				 handler: function(value){
				 	var triggerName = record.data['name'];
				 	var triggerGroup = record.data['triggerGroup'];
				 	 SchedulerManager.removeTrigger(triggerName, triggerGroup);  
				 	 alert("ɾ����");        
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
				 text: '����',
				 iconCls: 'stop',
				 handler: function(value){
				 	var triggerName = record.data['name'];
				 	var triggerGroup = record.data['triggerGroup'];
				 	 SchedulerManager.resumeTrigger(triggerName, triggerGroup);  
				 	 
				 	 record.set('state', '����������');
				 	 
				 	alert("��Trigger���������У�");        
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
				 		 	//	 					 SchedulerManager.updateCronExpression(triggerName, cronExp,function aa(){alert("�޸���ɣ�");});  
				 		 }
				 	}
				 	
				 	OBJ.showCronExpressionWin(triggerName,cronExpression,callBackFunc);
//				 	Ext.Msg.prompt("����", "��Ϣ��ʾ",callBackFunc, this, 200, cronExpression);
				 	
			     
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
				 text: '����',
				 iconCls: 'stop',
				 handler: function(value){
				 	var triggerName = record.data['name'];
//				 	var opts = record.data['opts'];
				 	
				 	
				 	function callFun(opts) {  
				 		Ext.Msg.prompt("����", "��Ϣ��ʾ",callBackFunc, this, 200, opts);
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
				 text: '����ִ��',
				 iconCls: 'stop',
				 handler: function(value){
				 	var jobName = record.data['jobName'];
				 	var jobGroup = record.data['jobGroup'];
				 	 SchedulerManager.startTriggerNow(jobName, jobGroup);  
				 	 
				 	 record.set('state', '����������');
				 	 
				 	alert("��Trigger���������У�");        
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

	var okBtn ={text: '����',handler: function(){ 
  		var express =document.getElementById('conExpreiframe').contentWindow.getExp();
  		if(express !=''){
  			 SchedulerManager.updateCronExpression(triggerName, express,function aa(){callBackFunc(express);alert("�޸���ɣ�");});  
  		}
 
  	}};	
  	
	var closeBtn ={text: '�ر�',handler: removeWin}; 

	 var win = new Ext.Window({
	   title : '����CRON���ʽ',
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
	loadingText : '������...',
	fieldLabel : '��������',
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
		title : '�������',
		width : 400,
		height : 440,
		resizable : false,
		autoHeight : true,
		modal : true,
		closeAction : 'hide',
		listeners : {
			'hide' : function() {
				this.setTitle('�������');
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
				msgTarget : 'side' // ��֤��Ϣ��ʾ�ұ�
			},
			defaultType : 'textfield',
			items : [{
				fieldLabel : '����������',
				id : 'job.trigerName',
				name : 'job.trigerName',
				allowBlank : false,
				maxLength : 20
			},{
				fieldLabel : 'ɨ��Ƶ��(����)',
				id : 'job.priority',
				name : 'job.priority',
				allowBlank : false,
				maxLength : 20
			},{
				fieldLabel : 'corn���ʽ',
				id : 'job.cornExpress',
				name : 'job.cornExpress',
				allowBlank : false,
				maxLength : 20
			},
			cbb_jobName_for_job_edit,
			 {
				fieldLabel : '��������',
				id : 'job.description',
				name : 'job.description',
				xtype : 'textarea',
				maxLength : 100
			}],
			buttonAlign : 'right',
			minButtonWidth : 60,
			buttons : [{
				text : '����',
				handler : function(btn) {
					var frm = Ext.getCmp("window_job_id").ownerJOB.form;
					if (frm.isValid()) {
						btn.disable();
						var cnfield = frm.findField('subject.subjectName');
						frm.submit({
							waitTitle : '���Ժ�',
							waitMsg : '�����ύ������,���Ժ�...',
							success : function(form, action) {
								var store = grid_subject.getStore();
								var subject = new Subject({
									subjectId : action.result.subjectId,
									subjectName : cnfield.getValue(),
									remark : form.findField('subject.remark').getValue()
								});
								store.insert(0, [subject]);
								window_add_subject.setTitle('[ ' + cnfield.getValue() + ' ]   ��ӳɹ�!!');
								cnfield.reset();
								btn.enable();
							},
							failure : function() {
								Ext.Msg.show({
									title : '������ʾ',
									msg : '"' + cnfield.getValue() + '" ' + '���ƿ����Ѿ�����!',
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
				text : '����',
				handler : function() {
//					this.ownerJOB.form.reset();
					Ext.getCmp("window_job_id").form.reset();
				}
			}, {
				text : 'ȡ��',
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
		text : '�½�����',
		iconCls : 'icon-add',
		handler : function() {
			win_job.show();
		}
	});
	
	var btn_start_schedule = new Ext.Button({
		text : '��������',
		iconCls : 'icon-add',
		handler : function() {
			OBJ.startSchedule();
		}
	});
	
	var btn_stop_schedule = new Ext.Button({
		text : 'ֹͣ����',
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
		title : '������ȹ���',
		iconCls : 'icon-grid',
		loadMask : {msg : '���ݼ�����...'},
		region : 'center',
		cm : cm_job,
		ds : store,
		sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
		
		height: 320,    //10����¼ʱ���и�;  
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
//			displayMsg : '�� {0} - {1} ��  �� {2} ��',
//			emptyMsg : "û�м�¼"
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
//						// alert("�����޸ĳɹ���");
//					},
//					failure : function() {
//						Ext.Msg.show({
//							title : '������ʾ',
//							msg : '�޸����ݷ�������,���������ع�!',
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
//	title : '��ӷ���',
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



