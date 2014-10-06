 
//   callOnLoad(init);	



	var _app_params;
	var _app_rights;
	var _g_login_Name;   
//	var config_username_from_page =  document.getElementById("config_username");
//	var _g_login_Name;   
//	var config_username_from_url = getParamFromUrl(window.location.href,"loginUser")+'';
//	if(config_username_from_url) _g_login_Name = config_username_from_url;
	
//	_g_login_Name = getParamFromUrl(window.location.href,"username");
	

	
//	  if(Ext.state.Manager.get('j_username')){ 
//     	 
//     }
//	var cookie = Ext.state.Manager.getProvider();
//	var cookie = Ext.state.Manager.getProvider();  
//	alert(cookie.get('j_username'))
	
//	var cookie1 = Ext.state.Manager.getProvider();  
//    var getsaveacct = cookie1.get('j_username');  
    
//	alert(getCookie("adrm_sys_gloable_param"))
	
//	alert(Ext.state.Manager.get('j_username'));
	
//	alert(Ext.util.Cookies.get("ys-j_username"));
	
  

//	var json = getCookie('_app_params');

//	var cp = new Ext.state.CookieProvider(); 
//	Ext.state.Manager.setProvider(cp); 
//	var cpUsername = cp.get("_app_params");
//	 alert(cpUsername)
	
//	 alert(Ext.state.Manager.get('_app_params'))
//	console.log(json);
//	
//	 alert(json)
//	
//	_app_params = eval('('+ json + ')');  
//	
//	 alert(_app_params)
//	
//	 console.log(_app_params);
//	 
//	 alert(33333)
	 
	
	 
//	var cookie1 = Ext.state.Manager.getProvider();  
//	 var file = cookie1.get('abcde');  
//	 
//	 alert(file)
	
	
//	alert(document.getElementById("config_username").value)

//	var start = new Date().getTime();

//  	var callBakFun=function(json){
//  		
//  		 alert(json)
//  		 
//         if(json == ''){
//         	check_app_params();
////         	setTimeout("check_app_params();",1000);
//         }else{
//	 		_app_params = eval('('+ json + ')');  
//	 		_app_rights = $H(_app_params.rights);
////	 		setTimeout("set_golabal_login_user();",1000);
//            set_golabal_login_user();
////	 		callOnLoad(init);	
//         }
// 	}
//// 	
// 	SysParamUtil.getGlobalParams(_g_login_Name,callBakFun);

// 	DWREngine.setAsync(false);
// 	SysParamUtil.getGlobalParams(_g_login_Name,callBakFun);
// 	DWREngine.setAsync(true);	 

  

//function reset_app_params_bak(){
//
//  	var callBakFun=function(json){
//         if(json == ''){
//         	setTimeout("check_app_params();",1000);
//         }
// 		_app_params = eval('('+ json + ')');  
// 		_app_rights = $H(_app_params.rights);
//
// 		callOnLoad(init);	
// 	}	
//	SysParamUtil.getGlobalParams(_g_login_Name,callBakFun);	
//}

//function reset_app_params(params){
//	    alert(params);
// 		_app_params = params;  
// 		_app_rights = $H(_app_params.rights);
//}
	
//
//function aaa_bb(){
//	alert(222222)
//}
//	
function init_app_params(init){
	
	
	 
//	alert(_g_login_Name)

			try {
				if(!isUndefined(resetDialogcontentHeigth)){ resetDialogcontentHeigth(); }
			} catch (e) {
//				alert(e.name + " : " + e.message); 
			} 	
	
	
	
	
  	var callBakFun=function(json){
  	
         if(json == ''){
         	check_app_params();
         }else{
	 		_app_params = eval('('+ json + ')');  
	 		_app_rights = $H(_app_params.rights);
            set_golabal_login_user(init);
         }

 	}
 	
 	    
 			try {

 				DWREngine.setAsync(false);
				SysParamUtil.getGlobalParams(_g_login_Name,callBakFun);
			    DWREngine.setAsync(true);
			} catch (e) {
//				alert(e.name + " : " + e.message); 
			} 
			

 	
}	
	
function check_app_params(){
		
	if(_app_params){
		 return true;
	}else{
//         	var referrer = document.referrer;
//         	alert(window.location.href)
//         	alert(window.location.href)
//	     	Ext.onReady( function() {
//	     		    spring-security-redirect
//                    var url = getCtxPath()+"login.jsp";
//                    window.location.href = url;
	    	       var ctxPath = getCtxPath();
	    	       
	  var parentWin =  window.parent;
	  if(parentWin){
	  	parentWin.location= ctxPath+"login.jsp";
	  }else{
	  	window.location=ctxPath+"login.jsp";
	  }
	

//	    	       	showLoginWin(window.location.href,true);
//			});          	
         	return false;
	}
}
 

		
 function set_golabal_login_user(init){	

	 	    if($("loginUser_fullName")){
			 	$("config_username").value =   _app_params.user.username;
	            DWRUtil.setValue($("loginUser_fullName"), _app_params.user.fullName);
	 	    } 	
	 	    
//	 	      var dialogcontent = $("dialogcontentDiv"); 
//	 	      if(dialogcontent){
//	 	        var main_page_fram = document.getElementById("main_page_fram");
//	 	        if(main_page_fram){
//					main_page_fram.style.height =  dialogcontent.offsetHeight*0.85 +"px";		 	        	
//	 	        }
//	 	      }
             
           
 	        if(init){ init(); }
//		Event.observe(document, 'dom:loaded', function(){
//	 	    if($("loginUser_fullName")){
//			 	$("config_username").value =   _app_params.user.username;
//	            DWRUtil.setValue($("loginUser_fullName"), _app_params.user.fullName);
//	 	    }
//		}.bind(this));	
 }
 
function check_authorize(res){
 	var permit = _app_rights.get(res);
 	if(permit) return permit; else return false;
}

function _make_org_select(selectItemId,width,event){
	var objs = _app_params.rights.userOrgs;
	var sel = document.getElementById(selectItemId);

	sel.setAttribute("onChange","javascript:"+ event +"(this)");
	sel.options.length = 0;

	
	if(objs.length <2) {
		sel.setAttribute("style","width:"+width+"px;margin-left:-100px;font-size:13px;display:none;cursor: pointer;position:absolute;");
	}
	sel.style.cssText ="cursor: pointer;width:"+width+"px;font-size:13px;";

	for(var i = 0;i < objs.length; i++){
		eval("var lable = objs[i].name");
		eval("var id = objs[i].id");
	    var varItem = new Option(lable, id);//option中的第一个值为显示的值，第二个值为value

	    sel.options.add(varItem);
	} 
	
	if(objs.length ==1) sel.hide();
	
	
	
}

function _make_org_select2(rederId,elname,width){

	var objs = _app_params.rights.userOrgs;
	var data = [];
	for(var i = 0;i < objs.length; i++){data.push([objs[i].id,objs[i].name]);} 
	var store = new Ext.data.SimpleStore({ fields: ['id', 'name'],data : data });  
     

      var comboBox =   new Ext.form.ComboBox({    
        store: store,
        id:elname,
        name:elname,
        width:width,
        displayField:'name',
         valueField:'id',
        typeAhead: true,
        mode: 'local',
        forceSelection: true,
        triggerAction: 'all',
        fieldLabel: '组织机构',
        allowBlank:false,
//        emptyText:'请选择...',
        selectOnFocus:true,
         mode: 'local',
        renderTo:rederId
    });
    
    
    if(objs.length ==1){
    	 comboBox.hide();
    	 comboBox.fieldLabel = '';
    }    

    comboBox.setValue(1);  
    
    return comboBox
	
}


function _make_adrm_sys_year_select(selectItemId,objs,def){
    objs = objs.split(",");
	var sel = document.getElementById(selectItemId);
	for(var i = 0;i< objs.length;i++){
	   var  option = new Option(objs[i], objs[i]);
	   sel.options.add(option);
    }
    
     if(def) sel.value = def;
    
}

function _make_order_cateMain_select(orgId,selectItemId,event,callBackFun,selectedIndex,width){
	

	var div = document.createElement("div");
    var span = document.createElement("span");
	var parnetNode;
	

	if(document.getElementById(selectItemId) != null){
		parnetNode= $(selectItemId).parentNode;
		DWRUtil.removeAllOptions(selectItemId);
	}
	 

	var sel = document.getElementById(selectItemId);
	if(sel ==null){
		sel = document.createElement("select"); 
		sel.setAttribute("id",selectItemId);
	}

    var objs = eval('_app_params.orderCateMain.orgId_'+orgId);
//	var objs = _app_params.orderCateMain[orgId*1];
    div.setAttribute("style","position:relative;");
    span.setAttribute("style","margin-left:100px;width:18px;overflow:hidden;font-size:13px;");
    
    
	for(var i = 0;i< objs.length;i++){
	   var  option = new Option(objs[i].name, objs[i].id);
	   option.calculateauto = objs[i].calculateAuto;
	   option.obj_value = objs[i].value;
       option.style.cssText ="font-size:13px;";
	   sel.options.add(option);
    }
   
    
 	sel.setAttribute("style","width:" + width +"px;margin-left:-100px;CURSOR: pointer;font-size:13px;");  
 	 
    if(event) sel.setAttribute("onChange","javascript:"+ event +"(this)");
    if(selectedIndex*1>0) sel.value = selectedIndex;
	if(callBackFun) callBackFun(sel);
	
	div.appendChild(span);
	span.appendChild(sel);
	
	
	if(parnetNode){
		parnetNode.appendChild(div);
	}else{
		return div;
	}
	
}



function _make_order_cateMain_select2(rederId,elname,width,fieldLabel,emptyText,orgId,event,callBackFun,defValue,xtype){
	var objs_temp = _app_params.orderCateMain[orgId*1-1];
	var objs = new Array();
	for(var i = 0;i<objs_temp.length;i++){
		var obj = objs_temp[i];
		if(obj.name !='协约合同'){
			objs.push(obj);
		}
	}
	var data = [];
	for(var i = 0;i < objs.length; i++){data.push([objs[i].id,objs[i].name,objs[i].calculateAuto]);} 
	var store = new Ext.data.SimpleStore({ fields: ['id', 'name','calculateAuto'],data : data });  
    var conf = {    
        store: store,
        id:elname,
        name:elname,
        width:width,
        displayField:'name',
         valueField:'id',
        typeAhead: true,
        editable: false,
        forceSelection: true,
        triggerAction: 'all',
        allowBlank:false,
        selectOnFocus:true,
         mode: 'local'
    };

    if(rederId) conf.renderTo = rederId;
    if(fieldLabel) conf.fieldLabel = fieldLabel;
    if(emptyText) conf.emptyText = emptyText;
    
    if(xtype){
    	conf.xtype = 'combo';
    	if(defValue)  conf.value = defValue; 
    	return conf;
    }else{
	    var comboBox =   new Ext.form.ComboBox(conf);
	    if(defValue)  comboBox.setValue(defValue);  
	    return comboBox
    }

}



function showOrg_prompt_whith_comboBox(func){
	var objs = _app_params.rights.userOrgs;
	var data = [];
	for(var i = 0;i < objs.length; i++){data.push([objs[i].id,objs[i].name]);} 
	var store = new Ext.data.SimpleStore({ fields: ['id', 'name'],data : data });  
    Ext.Msg.show({
        title: '选择组织',
//        msg: 'Which one?',
//        value: 'choice 2',
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


function get_fast_sign_order_win(ctxPath,paramObj){
	   var urlStr =  ctxPath +"selectPopup/buildMorePara.html?"+$H(paramObj).toQueryString();//$('CNZZ_AD_content_box').src=urlStr;


//    var btns = [
//        {
//            text        : "Add",
//            iconCls     : "icon-add"
//        },
//        "-",
//        {
//            text        : "Update",
//            iconCls     : "icon-update"
//        },
//        "-",
//        {
//            text        : "Delete",
//            iconCls     : "icon-delete"
//        }
//    ];
//    	   
//	    var tbar = {
//        xtype        : "toolbar",
//        layout       : "hbox",
//        items        : btns,        
//        height       : 30,
//        layoutConfig : {
//            align : "stretch"
//        },
//        defaults : {
//            flex : 1  
//        }
//    };
	
	    return  new Ext.Window({
            	id:'moduleIdwinMoreParaArray',
            	title:'播出',
                modal:false,
                layout:'fit',
// 				layout: 'column',  
                width:1024,
                height:600,
                closeAction:'destroy',
                plain: false,
				tbar:[],
				bbar:[new Ext.Toolbar.Spacer()],
				x:report.getWinX(1024),
				y:report.getWinY(600),
				minimizable:false,
				closable: false,
				maximizable: false,
//				renderTo:Ext.getBody(),
//                items: {html:applet},
    			html:"<iframe id='openwinMorePara_fram' src='"+ urlStr +"' scrolling='auto' style='width:100%;height:100%;margin:0;padding:0'></iframe>",    
    			buttonAlign:"left",
                buttons: [new Ext.Toolbar.Spacer()]
            });
}



function get_analyze_chart_win(ctxPath,paramObj){
	
	   var urlStr =  ctxPath +"selectPopup/chartService.html?"+$H(paramObj).toQueryString();//$('CNZZ_AD_content_box').src=urlStr;
	   
		function getWinX(width){
		        return (Ext.lib.Dom.getViewWidth() - width) / 2
		};
		
		function getWinY(height){
		        return (Ext.lib.Dom.getViewHeight() - height) / 2;
		}; 
		
		
		var viewWidth = Ext.lib.Dom.getViewWidth()*0.8;
		var viewHeight = Ext.lib.Dom.getViewHeight()*0.9;
  
   		
	    var myWin =   new Ext.Window({
            	id:'module_chart_service_win',
            	title:"分析图",
                modal:false,
                layout:'fit',
// 				layout: 'column',  
                width:viewWidth,
                height:viewHeight,
                closeAction:'destroy',
                plain: false,
				tbar:[],
				bbar:[new Ext.Toolbar.Spacer()],
				x:getWinX(viewWidth),
				y:getWinY(viewHeight),
				minimizable:false,
//				resizable:false, //变大小 
				closable: true,
				maximizable: false,
    			html:"<iframe id='open_chart_win_fram' src='"+ urlStr +"' scrolling='auto' style='width:100%;height:100%;margin:0;padding:0'></iframe>",    
    			buttonAlign:"left",
                buttons: [new Ext.Toolbar.Spacer()]
            });
            
//           var vs = Ext.getBody().getViewSize();  
//			myWin.setSize(vs.width, vs.height);   
//           Ext.EventManager.onWindowResize(this.initPosition, win); //window大小改变时，重新设置坐标
           
           return myWin;
}


 