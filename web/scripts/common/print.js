

function MyPrint(){
	this.win = null;
 	return this;
}

MyPrint.prototype.getWinX = function(width){
        return (Ext.lib.Dom.getViewWidth() - width) / 2
};

MyPrint.prototype.getWinY = function(height){
        return (Ext.lib.Dom.getViewHeight() - height) / 2;
};  

MyPrint.prototype.getDatas = function(){
	return datas2 =[
	   			{
                    text:'预览',
                    iconCls:'admin-tool-view',
                    handler:self.printReport.createDelegate(self,['view'])
                },{
                    text:'打印',
                    iconCls:'admin-tool-print',
                    handler:self.printReport.createDelegate(self,['print'])
                },{
                    text:'导出',
                    iconCls:'admin-tool-export-xls',
                    handler:self.printReport.createDelegate(self,['excel'])
                }
                ,{
                    text:'导出pdf',
                    iconCls:'admin-tool-export-pdf',
                    handler:self.printReport.createDelegate(self,['pdf'])
                },{
                    text:'导出html',
                    iconCls:'admin-tool-edit',
                    handler:self.printReport.createDelegate(self,['html'])
                },{
                    text:'导出word',
                    iconCls:'admin-tool-edit',
                    handler:self.printReport.createDelegate(self,['word'])
                },{
                    text:'图表',
                    iconCls:'admin-tool-chart',
                    handler:self.printReport.createDelegate(self,['chart'])
                },{
                    text:'复制订单',
                    iconCls:'admin-tool-copy',
                    handler:self.printReport.createDelegate(self,['copy'])
                },{
                    text:'查询',
                    iconCls:'admin-tool-query',
                    handler:self.printReport.createDelegate(self,['query'])
                },{
                    text:'播出证明',
                    iconCls:'admin-tool-prove',
                    handler:self.printReport.createDelegate(self,['prove'])
                }                  
                ];	
}



MyPrint.prototype.buildButtons = function(self,renderTo,btnArrayIndex,width){

	var menu_items =[];
	var datas2 = this.getDatas();
    if(Ext.isArray(btnArrayIndex)){
       		for (var i = 0; i < btnArrayIndex.length; i++){
       			if(btnArrayIndex[i] != 1){
       				menu_items.push(datas2[btnArrayIndex[i]]);
       			}
       				
       		}
    }	

    var printButton = new Ext.Toolbar.SplitButton(
   	 {
            text: '打印',
             renderTo : renderTo,
             handler:self.printReport.createDelegate(self,['print']),
             iconCls: 'admin-tool-print',
             width:width,
            // Menus can be built/referenced by using nested menu config objects
              menu : {items: menu_items},scope:this

        });

    return printButton;
}


MyPrint.prototype.buildButtons2 = function(self,renderTo,btnArrayIndex,width){

	var menu_items =[];
	var datas2 = this.getDatas();
    if(Ext.isArray(btnArrayIndex)){
       		for (var i = 0; i < btnArrayIndex.length; i++){
       			if(btnArrayIndex[i] != 8){
       				menu_items.push(datas2[btnArrayIndex[i]]);
       			}
       				
       		}
    }	

    var printButton = new Ext.Toolbar.SplitButton(
   	 {
            text: '查询',
             renderTo : renderTo,
             handler:self.printReport.createDelegate(self,['query']),
             iconCls: 'admin-tool-query',
             width:width,
            // Menus can be built/referenced by using nested menu config objects
              menu : {items: menu_items}

        });

    return printButton;
}


MyPrint.prototype.buildButtons3 = function(self,renderTo,btnArrayIndex,width){
	var conf ={};
	var printButton ={};
    conf.renderTo = renderTo;
    conf.width = width;
	var menu_items =[];
	var datas2 = this.getDatas();
	if(btnArrayIndex.length >1){
	       		for (var i = 1; i < btnArrayIndex.length; i++){
	       			if(btnArrayIndex[i] != 8){
	       				menu_items.push(datas2[btnArrayIndex[i]]);
	       			}	
	       		}
	       		var btnMenuConf = Object.extend(conf,datas2[btnArrayIndex[0]]);
	       		btnMenuConf.menu = {items: menu_items};
	       		printButton = new Ext.Toolbar.SplitButton(conf);
	}else{
		conf.xtype ='button';
		var btnConf = Object.extend(conf,datas2[btnArrayIndex[0]]);
	    printButton = new  Ext.Button(btnConf);
	}

    return printButton;
}


MyPrint.prototype.buildButtons_bak = function(self,renderTo,btnArrayIndex,width){
//	    var ttb =  self.getTopToolbar();
       var items;
       var datas =[
       ['view','预览','admin-tool-view'],
       ['print','打印','admin-tool-print'],
       ['excel','导出','admin-tool-export-xls'],
       ['pdf','导出pdf','admin-tool-export-pdf'],
       ['html','导出html','admin-tool-export-xls'],
       ['word','导出word','admin-tool-export-xls'],
       ['chart','图表','admin-tool-chart'],
       ['check','审核','admin-tool-check'],
       ['return','退回','admin-tool-return']
       ];
       var dataStore =[];
       

       
      
       var dataStore2 =[]; 
        
       if(width){

       	if(Ext.isArray(btnArrayIndex)){
       		for (var i = 0; i < btnArrayIndex.length; i++){
       			dataStore.push(datas[btnArrayIndex[i]]);
       		}
       	}
       	
        var store = new Ext.data.SimpleStore
        ({
            fields:["key","value","iconCls"],
            data:dataStore
        });   
        

              	
       	
		 items = new Ext.form.ComboBox({    
        	fieldLabel: '下拉框',    
            id:'roportComboBox',
            name: 'roportComboBox',
            renderTo : renderTo,
            editable:false,
            allowBlank:true,
            store:store,
            displayField: 'value',
            valueField:'key',
            iconClsField: 'iconCls',
            emptyText:'报表..',
            mode: 'local',//指定数据加载方式，如果直接从客户端加载则为local，如果从服务器断加载 则为remote.默认值为：remote
            typeAhead: true,
            triggerAction: 'all',
            selectOnFocus:true,
            width:width,
            frame:true,
            resizable:false,
            plugins:new Ext.ux.plugins.IconCombo(),
            listeners:{ 
				select: function(box, record, index) {
					self.printReport(this.value);
				}
            }
        });
      
        
       }else{
       	    
       	  if(Ext.isArray(btnArrayIndex)){
       	  	    var datas2 = this.getDatas();
	       		for (var i = 0; i < btnArrayIndex.length; i++){
	       			dataStore2.push(datas2[btnArrayIndex[i]]);
	       		}
       		}
	   		items = dataStore2;
       	
       }

       return items;

}


MyPrint.prototype.loadApplet = function(parObj,contextPath,winWidth,winHeight,renderTo){
	var model = parObj.model;
	var reportType = parObj.reportType;

	

	var h = $H(parObj);
//    var par = encodeURI(h.toQueryString());
     var par = h.toQueryString();
    var applet;
	var reportURL = contextPath +'servlet/reportServlet?'+ par;
	
	
	var code = 'PublishViewerApplet';
	var codeBase =contextPath+'reports/applets';
	var archive = 'jasperreports-1.2.8-applet.jar,report.jar';
	var type = 'application/x-java-applet;version=1.2.8';
//	var jreURL = contextPath + 'download/jre-1_5_0_18-windows-i586-p.exe';
//	var jreURL = contextPath + 'download/jre-7u1-windows-i586-s.exe';
	var jreURL = contextPath + 'download/jre-7u1-windows-i586.exe#Version=1,7,0,1';
	

   if(model =='view'){
   
    
	var isIE = Ext.isIE;
	
	if(isIE){
//	    var URL = "system/reports/applets/jre-1_5_0_18-windows-i586-p.exe";
        applet ='<OBJECT id="myApplet" name="myApplet"';
		applet +='classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93" WIDTH ="100%" HEIGHT ="100%" MAYSCRIPT name="myApplet"';
		applet +='codebase='+ jreURL +'>';
		applet +='<PARAM NAME="CODE" VALUE="'+ code +'"/>';
		applet +='<PARAM NAME="CODEBASE" VALUE="'+ codeBase +'" />';
		applet +='<PARAM NAME="ARCHIVE" VALUE="'+ archive +'" />';
		applet +='<PARAM NAME="type" VALUE="'+ type +'" />';
		applet +='<PARAM NAME="scriptable" VALUE="false" />';
		applet +='<PARAM NAME="REPORT_URL" VALUE="'+ reportURL +'">';
		applet +='no support java';
		applet +='<comment>';
		applet +='<embed type="'+ type +'"';
		applet +='CODE="'+ code +'"';
		applet +='JAVA_CODEBASE="'+ codeBase +'" ARCHIVE="'+ archive +'"';
		applet +='scriptable=true';
		applet +='pluginspage="'+ jreURL +'">';
		applet +='<noembed></noembed>';
		applet +='</embed>';
		applet +='</comment>';
		applet +='</OBJECT>';
	}else{
//		applet ='<EMBED type="'+ type +'" CODE = "'+ code +'" CODEBASE = "'+ codeBase +'" ARCHIVE = "' + archive +'" WIDTH = "100%" HEIGHT = "100%" REPORT_URL = "'+ reportURL +'" scriptable=false pluginspage="http://java.sun.com/products/plugin/1.1.2/plugin-install.html"><NOEMBED><XMP>';
//		applet = '<APPLET  name="myApplet" id="myApplet"  WIDTH ="100%" HEIGHT ="100%">';
		applet = '<APPLET  name="myApplet" id="myApplet"  WIDTH ="100%" HEIGHT ="'+ winHeight*0.9 +'">';
		applet +='</XMP>';
		applet +='<PARAM NAME = "CODE" VALUE ="'+ code +'">';
		applet +='<PARAM NAME = "CODEBASE" VALUE ="'+ codeBase +'" >';
		applet +='<PARAM NAME = "ARCHIVE" VALUE ="'+ archive +'" >';
		applet +='<PARAM NAME="type" VALUE="'+ type +'" />';
		applet +='<PARAM NAME = "scriptable" VALUE="true">';
		applet +='<PARAM NAME = "REPORT_URL" VALUE ="'+ reportURL +'">';
		applet +='</APPLET>';
	}
	
	
//	return 	applet;
	

	var moduleId = reportType;    
	
//	if(!this.printwin){


//												{
//                                     xtype: 'panel',
//                                     id:'InputXMLSourcePanel',
//                                     html:"<iframe width=100% height=100% id='InputXMLSource'name='InputXMLSource' src='"+dataSourceURL+"in'/>",
//                                     title: 'xml源文件'
//                                     
//                                 }
//		 Ext.getCmp('InputXMLStylePanel').update(applet);

           this.printwin = new Ext.Window({
            	id:moduleId,
            	title:'报表',
                //applyTo:'print-win',
//                renderTo: desktopEl,
                 modal:true,
                layout:'fit',
                width:winWidth,
                height:winHeight,
                closeAction:'destroy',
                plain: true,

				x:this.getWinX(winWidth),
				y:this.getWinY(winHeight),
				minimizable:true,
				maximizable: false,
                items: {html:applet},
//                html: "<iframe width='100%' height='100%' frameborder='0' src='taf_uploadScript.action'></iframe>",

                buttons: [{
                    text: '关闭',
                    handler: function(){
                        removeWin();
                    }
                }]
            });
//        }

        if(renderTo){
        	 this.printwin.render(renderTo);
        }
        this.printwin.show();	
        
   var this_printwin =  this.printwin;
	
	
	function removeWin(){this_printwin.destroy();} 	
//    printwin.on({'close': {fn: removeWin}});   	
	
	
	
	
	
	
	
	
//	var moduleId = reportType;    
//	if(!this.win){
//		
//
//            this.win = new Ext.Window({
//            	id:moduleId,
//            	title:'11111111',
//                //applyTo:'print-win',
////                renderTo: desktopEl,
//                 modal:true,
//                layout:'fit',
//                //width:500,
//                //height:300,
//                closeAction:'hide',
//                plain: true,
//                width:winWidth,
//                height:winHeight,
//				x:this.getWinX(winWidth-200),
//				y:this.getWinY(winHeight-200),
//				minimizable:true,
//				maximizable: true,
//                items: {html:applet},
//
//                buttons: [{
//                    text:'Submit',
//                    disabled:true
//                },{
//                    text: 'Close',
//                    handler: function(){
//                        this.win.hide();
//                    }
//                }]
//            });
//        }
//        this.win.show();
//		


	
   }else{
   
           
   	    if(model !='print'&& model !='view'){
	    	window.location.href = reportURL;
   	    }else{ 
   	    	  var  myMessage = this.myMessage;
   	    	  Ext.Ajax.request({
                url:reportURL,
                method:'POST',
                success:function(response){
//                	alert(response.statusText == 'OK');
                    myMessage('打印结束!');
                }
            })
   	    }

   }
	
};



MyPrint.prototype.myMessage =function(msg){
	Ext.MessageBox.hide(); 
	Ext.MessageBox.show(
			 	{title:'系统消息',msg:msg,width:200,heigth:100,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
	);  
};

MyPrint.prototype.getWeekCheckBox =function(rederId,id,fieldLabel,width,defValue){

    var store = new Ext.data.SimpleStore({  
            fields : ['value', 'text'],  
            data : [['2', '星期一'], ['3', '星期二'], ['4', '星期三'], ['5', '星期四'], ['6', '星期五'], ['7', '星期六'], ['1', '星期日']]  
        });
        
	var conf ={  
		id:id,
		name:id,
        store : store,  
        width:width,
        hiddenName:'product_code',//提交到后台的input的name 
        mode:'local',//数据加载模式，'local'本地加载，'remote'远程加载
        valueField : 'value',   //值字段  
        displayField : 'text',  //显示字段  
//        value:'1001',       //默认值,要设置为提交给后台的值，不要设置为显示文本  
        emptyText : '选星期...',  //提示信息  
        mode : 'local', //数据加载模式，local代表本地数据  
        triggerAction : 'all',  // 显示所有下列数据，一定要设置属性triggerAction为a  
        readOnly : false,   //只读，为true时不能编辑不能点击  
        editable:false,     //是否可编辑，为true时可以手写录入  
        pageSize:0      //当设置大于0时会显示分页按钮
    };
	
	if(fieldLabel) Ext.applyIf(conf, {fieldLabel:fieldLabel});
	if(rederId) Ext.applyIf(conf, {renderTo:rederId});
	
    var combo = new Ext.ux.form.LovCombo(conf);

   return combo;
 
};


MyPrint.prototype.getFtiterSort = function(comboBox_ID,fieldLabel,width,defValue,xtype){

    Ext.QuickTips.init();
    var names = [['0','段位分组'],['1','版本分组']];
    var store = new Ext.data.SimpleStore({fields:["id","name"],data:names});    

     var conf = {    
        	fieldLabel: fieldLabel,    
            id:comboBox_ID,
            name: comboBox_ID,
            emptyText: '请选择分组...',
            editable:false,
            allowBlank:false,
            store:store,
            mode: 'local',
            typeAhead: true,
            triggerAction: 'all',
            selectOnFocus:true,
            width:width,
            readOnly : false,
            frame:true,
			displayField:'name',
			valueField:'id',
            resizable:true
        };
        

	    if(xtype){
	    	conf.xtype = 'clearableComboBox';
	    	 if(defValue)  conf.value = defValue; 
	    	return conf;
	    }else{
		    var comboBox =   new Ext.form.ClearableComboBox(conf);
		    if(defValue)  comboBox.setValue(defValue);  
		    return comboBox
	    }      
        
};

MyPrint.prototype.getComMonth = function(model,checkBox,comboBox_ID,fieldLabel,width,defValue,xtype,renderTo){

    Ext.QuickTips.init();
    
    var data = [[1,"1"],[2,"2"],[3,"3"],[4,"4"],[5,"5"],[6,"6"],[7,"7"],[8,"8"],[9,"9"],[10,"10"],[11,"11"],[12,"12"]];
    if(model ==1){
    	 data = [[1,'一月'], [2,'二月'], [3,'三月'], [4,'四月'], [5,'五月'], [6,'六月'], [7,'七月'], [8,'八月'],[9,'九月'], [10,'十月'], [11,'十一月'], [12,'十二月']];
    }else if(model ==2){
    	 data = [[1,"01"],[2,"02"],[3,"03"],[4,"04"],[5,"05"],[6,"06"],[7,"07"],[8,"08"],[9,"9"],[10,"10"],[11,"11"],[12,"12"]]; 
    }
    var store = new Ext.data.SimpleStore({fields:["id","name"],data:data});    

    var conf = {    
        	fieldLabel: fieldLabel,    
            id:comboBox_ID,
            name: comboBox_ID,
            emptyText: '请选择...',
            editable:false,
            allowBlank:false,
            store:store,
            mode: 'local',
            typeAhead: true,
            triggerAction: 'all',
            selectOnFocus:true,
            width:width,
            readOnly : false,
            frame:true,
			displayField:'name',
			valueField:'id',
            resizable:true
        };
    
         if(renderTo) conf.renderTo = renderTo;
      
        
	    if(xtype){
	    	conf.xtype = 'clearableComboBox';
	    	 if(defValue)  conf.value = defValue; 
	    	return conf;
	    }else{
		    var cmd;
		    if(checkBox){
		    	  cmd = new Ext.ux.form.LovCombo(conf);
		    }else{
		    	  cmd = new Ext.form.ClearableComboBox(conf);	
		    }
		    if(defValue)  cmd.setValue(defValue);  
		    
		    return cmd;
	    }      
        
};


//MyPrint.prototype.getComMonth = function(comboBox_ID,fieldLabel,width,defValue,model,renderTo){
//
//    Ext.QuickTips.init();
//	
//    var store  = new Ext.data.SimpleStore({
//        fields : ['text', 'value'],
//        data :  [[1,"1"],[2,"2"],[3,"3"],[4,"4"],[5,"5"],[6,"6"],[7,"7"],[8,"8"],[9,"9"],[10,"10"],[11,"11"],[12,"12"]]
//    });
//    
//
// 
//         if(model ==1){
//         	store.data= [[1,'一月'], [2,'二月'], [3,'三月'], [4,'四月'], [5,'五月'], [6,'六月'], [7,'七月'], [8,'八月'],[9,'九月'], [10,'十月'], [11,'十一月'], [12,'十二月']];
//         }else if(model ==2){
//         	store.data = [[1,"01"],[2,"02"],[3,"03"],[4,"04"],[5,"05"],[6,"06"],[7,"07"],[8,"08"],[9,"9"],[10,"10"],[11,"11"],[12,"12"]]; 
//         }
//
//         
//         var conf = {
//         	     fieldLabel: fieldLabel
//        		,id:comboBox_ID
//        		,name:comboBox_ID
//        		,width:width
//        		,hideOnSelect:false
//        		,maxHeight:230
//        		,readOnly: false 
//          		,editable: false
//          		,typeAhead: true
//          		,selectOnFocus:true
//          		,forceSelection: true
//        		,emptyText: '请选择月分...' 
//        		,store:store
//        		,triggerAction:'all'
//        		,valueField:'value'
//        		,displayField:'text'
//        		,mode:'local'
//        		};
//         
//         
//         if(renderTo) conf.renderTo = renderTo;  
//		 var comboBox = new Ext.form.ComboBox(conf);
//        if(defValue) comboBox.setValue(defValue);  
//
//        return comboBox;
//};
