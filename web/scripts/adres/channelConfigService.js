var resourceSort = new ResourceSort();
var resourceChannel = new ResourceChannel();


 callOnLoad(init);	
 
 
function init(){
	config_dayangBeiboEnableParam =  _app_params.sysParam.dayangBeiboEnableParam;
	if(config_dayangBeiboEnableParam.split(":")[0] == 1){
		config_dayangBeiboEnableParam = true;
	}else{
		config_dayangBeiboEnableParam = false;
	}

	
	if(!config_dayangBeiboEnableParam){
		$("dayangBeiboEnableParam_table").hide();
	}else{
		buttonEventFill();
		initGrid();
		resetHeigth();
		loadGridData();
	}
	
}
function buttonEventFill(){
	var btn_bro_conf = $("btn_bro_conf");
	btn_bro_conf.onclick=button_config_save;
}



function resetHeigth(){
	
   	var dialogcontent = $("dialogcontentDiv");
    var treebox = $("gridbox");
    
    treebox.style.height = dialogcontent.offsetHeight * 0.45 +"px";	
    if(mygrid) mygrid.setSizes(); 
} 



function button_config_save(){
	var rowCount= mygrid.getRowsNum();
	function callbak(){
		alert('保存完毕!');
	};
	
	var channelConfigs = new Array();
	
	var channelId = document.getElementById("id").value*1;
	
	for(var i=0;i< rowCount;i++){
		var channelConfig = {};
		channelConfig.id = null;
		var rowId = mygrid.getRowId(i);
		channelConfig.channelId = channelId;
		channelConfig.enable = mygrid.cells(rowId,1).getValue()*1;
		channelConfig.preOne = mygrid.cells(rowId,2).getValue();
		channelConfig.sendType = mygrid.cells(rowId,3).getValue()*1;
		channelConfig.sendAddress = mygrid.cells(rowId,4).getValue();
		channelConfig.resourceSort = mygrid.cells(rowId,5).getValue();
		channelConfig.sendZeo = mygrid.cells(rowId,6).getValue()*1;
//		channelConfig.preOne = mygrid.cells(rowId,1).getValue();
//		channelConfig.preTow = mygrid.cells(rowId,1).getValue();
		channelConfigs.push(channelConfig);
//		alert(channelConfigs.toSource());
        
	}
	if(channelConfigs.length >0){
		resourceChannel.channelConfigs = channelConfigs;
		resourceChannel.saveChannelConfig(channelId,callbak);
	}


}

function button_config(){
	
	var dialogcontent = $("dialogcontentDiv");
	var dialogcontentW = dialogcontent.offsetWidth;
	var dialogcontentH = dialogcontent.offsetHeight;
	var winW= dialogcontentW * 0.6;
	var winH = dialogcontentH*0.8;	
	

 	
  var orgId = $("orgId").value;
//  var urlStr="selectPopup/selectRoles.html?orgId="+orgId +"&width="+winW +"&height="+ winH +"&config_useMoreCarrierSortParam="+config_useMoreCarrierSortParam+"&config_username="+config_username;
  var newBtn ={text: '增加',handler: function(){document.getElementById('selectRolesiframe').contentWindow.add();}};	

  var closeBtn ={text: '关闭',handler: function(){removeWin();}};
  
  
        
 var win = new Ext.Window({
   title : '频道播出单发送配置',
   width : winW,
   height : winH,
   isTopContainer : true,
   modal : true,
   resizable : false,
   tbar: [newBtn],
   buttons: [closeBtn],
   contentEl : Ext.DomHelper.append(document.body, {
    tag : 'iframe',
     id : 'selectRolesiframe',
    style : "border 0px none;scrollbar:true",
//    src : urlStr,
    height : "100%",
    width : "100%"
   })
  })
  win.show(); 
  
   function removeWin(){
//   	    getOrgTreeDate();
  		win.destroy();
   	} 
   win.on({'close': {fn: removeWin}});   
  
}


function grid_wspand_add(){
	var rowCount = mygrid.getRowsNum();
	var to_row_id = "new_" + (new Date()).valueOf();
//	var saveImg = ctxPath+"image/save2.png^保存^javascript:grid_wspand_save();^_self";
	var delImg = ctxPath+"image/button_delete.gif^删除^javascript:_remove_work_span();^_self";
//    if(rowCount >0 ){
    	//mygrid.addRow(to_row_id,[],rowCount);
    	mygrid.addRow(to_row_id,['','','','','','','',delImg],rowCount);
//    }
}

function _remove_work_span(){
	
	            var id = mygrid.getSelectedId();
	            
	    		Ext.MessageBox.confirm('系统提示', '请确认是否删除这条记录？', function(btn) {
	    		 
	 			  if (btn == 'yes') {
	                 var id_temp = id+'';
	                 if(id_temp.indexOf("new_")==-1){
	                 	 resourceChannel.remove_resourceChannelConf(id,function(){mygrid.deleteRow(id);});
	                 }else{
	                 	mygrid.deleteRow(id);
	                 }
	              }
	              return false; 	
				 });  	
}

function initGrid(){ 
	
	ctxPath =  _app_params.ctxPath;	 
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath(ctxPath+"image/grid/");
//	var save_btn = "<img onclick='grid_wspand_save()' src='"+ ctxPath +"image/save.png' width='20' heigth='20' alt='保存'/>";
	var add_btn = "<img onclick='grid_wspand_add()' src='"+ ctxPath +"image/CRM_ADD.GIF' width='20' heigth='20' alt='新添'/>";
	var columnIds = "enable,preOne,send_type,send_address,resource_sort,send_zeo,oper1";
	var flds = "&nbsp;,是否启用,目标,发送类型,发送地址,段位类型,广告为0是否发送,"+ add_btn;
	
	mygrid.setColumnIds(columnIds);
	mygrid.setHeader(flds);
	
	mygrid.setInitWidthsP("5,5,10,10,45,10,5,10");
	mygrid.setColAlign("center,center,center,center,left,center,center,center,center,center,center,center,center,center,center,left,center");
	mygrid.setColTypes("cntr,ch,coro,coro,coro,clist,ch,img");
	mygrid.setEditable(true);
	mygrid.selMultiRows = true;
	mygrid.enableMathEditing(true); 
	mygrid.enableAlterCss("even","uneven");
//	mygrid.setOnEditCellHandler(doOnCellEdit);
//	mygrid.setOnEnterPressedHandler(doOnCellEdit);

    mygrid.registerCList(5, ["1", "2", "3", "4", "5"]);

	mygrid.init();	
	

 
   mygrid.setSizes();
   

//    var command= mygrid.getCombo(2);
//    for(var i = 1 ;i<25;i++){
//    		command.put(i,i);
//    }
//    
//    var command2= mygrid.getCombo(3);
//    for(var i = 1 ;i<61;i++){
//    		command2.put(i,i);
//    }
//    

    var command2= mygrid.getCombo(2);
    command2.put(1,'大洋');
    command2.put(2,'新奥特');
    
    var command3= mygrid.getCombo(3);
    command3.put(1,'条目');
    command3.put(2,'播出单');
    
    var command4= mygrid.getCombo(4);
    command4.put('http://10.77.50.242/msbus-webapp/esb/event/ImportMaterialService','http://10.77.50.242/msbus-webapp/esb/event/ImportMaterialService');
    command4.put('http://10.77.50.242/msbus-webapp/esb/event/ImportProgramListService','http://10.77.50.242/msbus-webapp/esb/event/ImportProgramListService');
    


	

//	var command4 = mygrid.getCombo(3);
//	function func(objs){
//		for(var i = 0;i<objs.length;i++){
//			var obj = objs[i];
//			command4.put(obj.id,obj.name);			
//		}
//	}
//	resourceSort.getResourceSorts(func);
}



function loadGridData(){

   var channelId = document.getElementById("id").value*1;

	function callBackFun(xml){
				mygrid.clearAll();
				mygrid.loadXMLString(xml);
				mygrid.setSizes();	 
				Ext.getBody().unmask();
    }
    
  
	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	resourceChannel.getResourceChannelConfigGridXML(channelId,callBackFun);
	
}

	