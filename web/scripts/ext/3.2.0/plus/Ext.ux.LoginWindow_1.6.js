/**
 * 
 *
 * @author  Wemerson Januario (ExtJS 3.x)
 * @license LGPLv3 http://www.opensource.org/licenses/lgpl-3.0.html
 * @version 1.0 beta, 07/12/2008 - ExtJS 2.x
 * @version 1.0, 05/03/2009 - ExtJS 3.x
 * @version 1.1, 07/18/2009 - ExtJS 3.x
 * @version 1.6, 16/06/2010 - ExtJS 3.2.1 ++
 */
 
 
 

//new Ext.ux.Notification({
//  iconCls:    'x-icon-error',
//  title:      'Ruh-row',
//  html:       'This is just a stub.  This is only a stub.  If this would have been a real functioning doo-dad, you never would have even seen this stub.',
//  autoDestroy: true,
//   hideDelay:  5000
//}).show(document);
//*/
//
//Ext.ux.NotificationMgr = {
//    positions: []
//};
//
//Ext.ux.Notification = Ext.extend(Ext.Window, {
//    initComponent: function(){
//          Ext.apply(this, {
//                  closable: true,
//            iconCls: this.iconCls || 'x-icon-information',
//            width: 200,
//            //height: 100,
//                  autoHeight: true,
//            autoScroll: true,
//            autoDestroy: true,
//                  draggable: false,
//            plain: false
//          });
//        this.task = new Ext.util.DelayedTask(this.hide, this);
//        Ext.ux.Notification.superclass.initComponent.call(this);
//    },
//    setMessage: function(msg){
//        this.body.update(msg);
//    },
//    setTitle: function(title, iconCls){
//        Ext.ux.Notification.superclass.setTitle.call(this, title, iconCls||this.iconCls);
//    },
//    onRender:function(ct, position) {
//        Ext.ux.Notification.superclass.onRender.call(this, ct, position);
//    },
//    onDestroy: function(){
//        Ext.ux.NotificationMgr.positions.remove(this.pos);
//        Ext.ux.Notification.superclass.onDestroy.call(this);
//    },
//    afterShow: function(){
//        Ext.ux.Notification.superclass.afterShow.call(this);
//        this.on('move', function(){
//               Ext.ux.NotificationMgr.positions.remove(this.pos);
//            this.task.cancel();}
//        , this); this.task.delay(4000);
//    },
//    animShow: function(){
//        this.pos = 0;
//        while(Ext.ux.NotificationMgr.positions.indexOf(this.pos)>-1)
//            this.pos++;
//        Ext.ux.NotificationMgr.positions.push(this.pos);
//        this.setSize(200,100);
//        this.el.alignTo(this.animateTarget || document, "br-br", [ -4, -34-((this.getSize().height+10)*this.pos) ]);
//        this.el.slideIn('b', {
//            duration: 1,
//            callback: this.afterShow,
//            scope: this
//        });   
//    },
//    animHide: function(){
//           Ext.ux.NotificationMgr.positions.remove(this.pos);
//        this.el.ghost("b", {
//            duration: 1,
//            remove: true,
//        scope: this,
//        callback: this.destroy
//        });   
//    }
//}); 


/*
new Ext.ux.Notification({
  iconCls:    'x-icon-error',
  title:      'Ruh-row',
  html:       'This is just a stub.  This is only a stub.  If this would have been a real functioning doo-dad, you never would have even seen this stub.',
  autoDestroy: true,
   hideDelay:  5000
}).show(document);
*/
/*
 * qWikiOffice Desktop 0.8.1
 * Copyright(c) 2007-2008, Integrated Technologies, Inc.
 * licensing@qwikioffice.com
 * 
 * http://www.qwikioffice.com/license
 *
 * Ext.ux.Notification is based on code from the Ext JS forum.
 * I have made some minor modifications.
 */
Ext.ns('MyLib');

;(function($) {
    //新建window组，避免被其它window影响显示在最前的效果
    var tipsGroupMgr = new Ext.WindowGroup();
    tipsGroupMgr.zseed=99999; //将小贴士窗口前置

    $.TipsWindow = Ext.extend(Ext.Window, {
        width:200,
        height:150,
        layout:'fit',
        modal : false,
        plain: true,
        shadow:false, //去除阴影
        draggable:false, //默认不可拖拽
        resizable:false,
        closable: true,
        closeAction:'hide', //默认关闭为隐藏
        autoHide:3, //n秒后自动隐藏，为false时,不自动隐藏
        manager: tipsGroupMgr, //设置window所属的组
        constructor: function(conf){
            $.TipsWindow.superclass.constructor.call(this, conf);
            this.initPosition(true);
        },
        initEvents: function() {
            $.TipsWindow.superclass.initEvents.call(this);
            //自动隐藏
            if(false !== this.autoHide){
                var task = new Ext.util.DelayedTask(this.hide, this), second = (parseInt(this.autoHide) || 3) * 1000;
                this.on('beforeshow', function(self) {
                    task.delay(second);
                });
            }
            this.on('beforeshow', this.showTips);
            this.on('beforehide', this.hideTips);

            Ext.EventManager.onWindowResize(this.initPosition, this); //window大小改变时，重新设置坐标
            Ext.EventManager.on(window, 'scroll', this.initPosition, this); //window移动滚动条时，重新设置坐标
        },
        //参数: flag - true时强制更新位置
        initPosition: function(flag) {
            if(true !== flag && this.hidden){ //不可见时，不调整坐标
                return false;
            }
            var doc = document, bd = (doc.body || doc.documentElement);
            //ext取可视范围宽高(与上面方法取的值相同), 加上滚动坐标
            var left = bd.scrollLeft + Ext.lib.Dom.getViewWidth()-4-this.width;
            var top = bd.scrollTop + Ext.lib.Dom.getViewHeight()-4-this.height;
            this.setPosition(left, top);
        },
        showTips: function() {
            var self = this;
            if(!self.hidden){return false;}

            self.initPosition(true); //初始化坐标
            self.el.slideIn('b', {
                callback: function() {
                    //显示完成后,手动触发show事件,并将hidden属性设置false,否则将不能触发hide事件
                    self.fireEvent('show', self);
                    self.hidden = false;
                }
            });
            return false; //不执行默认的show
        },
        hideTips: function() {
            var self = this;
            if(self.hidden){return false;}

            self.el.slideOut('b', {
                callback: function() {
                    //渐隐动作执行完成时,手动触发hide事件,并将hidden属性设置true
                    self.fireEvent('hide', self);
                    self.hidden = true;
                }
            });
            return false; //不执行默认的hide
        }
    });
})(MyLib);
 
 



Ext.namespace('Ext.ux');



///验证码文本框  
Ext.ux.CodeField = Ext.extend(Ext.form.TextField,{  
    /*获取验证码图片的后台Url*/  
    codeUrl:Ext.BLANK_IMAGE_URL,  
      
    /*是否自动加载验证码图片*/  
    autoLoad:true,  
      
    onRender: function(ct, position){  
        Ext.ux.CodeField.superclass.onRender.call(this, ct, position);  
        this.codeEl = ct.createChild({tag:'img',src:Ext.BLANK_IMAGE_URL});  
        this.codeEl.addClass('x-form-code');  
        this.codeEl.on('click',this.loadCodeImg,this);  
          
        if(this.autoLoad) this.loadCodeImg();  
    },  
  
    alignErrorIcon : function(){  
        this.errorIcon.alignTo(this.codeEl,'tl-tr',[2, 0]);  
    },  
      
    /*加载验证码图片方法，加上随机数参数让图片刷新*/  
    loadCodeImg: function(){  
        this.codeEl.set({src:this.codeUrl+'?id='+Math.random()});  
    }  
});  
Ext.reg('codefield', Ext.ux.CodeField);  



//utils
Ext.apply(Ext.form.VTypes,{
    cpf: function(val,field){
        if (val!='___.___.___-__') {
            if((val = val.replace(/[^\d]/g,"").split("")).length != 11) return false;
            if(new RegExp("^" + val[0] + "{11}$").exec(val.join(""))) return false;
            for(var s = 10, n = 0, i = 0; s >= 2; n += val[i++] * s--);
            if(val[9] != (((n %= 11) < 2) ? 0 : 11 - n)) return false;
            for(var s = 11, n = 0, i = 0; s >= 2; n += val[i++] * s--);
            if(val[10] != (((n %= 11) < 2) ? 0 : 11 - n)) return false;
            return true;
        } else {
            return true;
        }
    },
    cpfText: 'CPF informado n鉶 ?v醠ido!',
    cpfMask: /[0-9\.\-]/i
});



/**
 * Construtor
 *
 * @param {Object} config
 * @extends {Ext.util.Observable}
 */
Ext.ux.LoginWindow = function (config) {

    Ext.apply(this, config);

    // Css usado para criar a janela
    // #login-logo .x-plain-body {background:#f9f9f9 url('" + this.basePath + "/" + this.winBanner + "') no-repeat;}
    var css = "#login-logo .x-plain-body {background:#ffffff url('" + this.basePath + "/" + this.winBanner + "') no-repeat;}" + "#login-form  {background: " + this.formBgcolor + " none;}" + ".ux-auth-header-icon {background: url('" + this.basePath + "/locked.gif') 0 4px no-repeat !important;}" + ".ux-auth-form {padding:10px;}" + ".ux-auth-login {background-image: url('" + this.basePath + "/key.gif') !important}" + ".ux-auth-close {background-image: url('" + this.basePath + "/close.gif') !important}" 
    + " .ux-flag-zh_cn {'" + this.basePath + "/cn_zh.png') !important;}"
    + " .ux-flag-us {background-image:url('" + this.basePath + "/us.png') !important;}"
    + " .ux-virtualkeyboard-icon {'" + this.basePath + "/keyboard.png') !important;}"
	+ " .x-form-code{width:56px;height:22px;vertical-align:middle;padding-left:2px;cursor:pointer;} "
//	+ " .login_user{background:url('" + this.basePath + "/login_user.gif') !important;background-repeat:no-repeat 1px 2px; font-weight:bold;padding-left:20px;} "
//	+ " .pass_word{background:url('" + this.basePath + "/login_pass.gif') !important; background-repeat:no-repeat 1px 2px; font-weight:bold;padding-left:20px;} ";
	
	+ " .login_user{ background:url('" + this.basePath + "/login_user.png') no-repeat 1px 2px; }"
	+ " .pass_word{ background:url('" + this.basePath + "/login_pass.png') no-repeat 1px 2px;  }"
	+ " .login_user,.pass_word{background-color:#FFFFFF;padding-left:20px;font-weight:bold;color:#000033;}"
	
//	+ "  #splash-back .x-plain2-body {background:#ffffff url('" + this.basePath + "/splash.png') no-repeat;}";
	
	+ "  #splash-back .x-plain-body{ background:#ffffff url('" + this.basePath + "/splash.png') no-repeat;}";

	
	

	
	
    
    Ext.util.CSS.createStyleSheet(css, this._cssId);

    if (this.forceVirtualKeyboard) {
        this.enableVirtualKeyboard = true;
    }

    // Eventos
    this.addEvents({
        'show': true,
        'reset': true,
        'success': true,
        'failure': true,
        'submit': true,
        'submitpass': true
    });
    
    Ext.EventManager.onWindowResize(this.initPosition, this); //window大小改变时，重新设置坐标
    Ext.EventManager.on(window, 'scroll', this.initPosition, this); //window移动滚动条时，重新设置坐标
    
//     window.onresize = function() {    
//				var left = ($(window).width() - loginWindow.getWidth())/2;
//				loginWindow.setPosition(left);
//	};
            
    Ext.ux.LoginWindow.superclass.constructor.call(this, config);
    
    
//      Ext.Ajax.on('beforerequest', function(){  
//       Ext.Ajax.extraParams={'ajax_extraParams':'true'};  
//     }, this);//     
//    
//     Ext.Ajax.on('requestcomplete', function(conn,response){  
//        try{  
//          var resp=Ext.decode(response.responseText);  
//          if(resp.ajax_session_invalid){  
//            alert("请重新登陆!")  
//            location=g_rootPath+"login.jsp";  
//          }  
//        }catch(e){  }  
//    }, this);        
    

    
    var title = "<table width='100%' border=0 cellspacing=1 cellpadding=1> <tr><td>&nbsp;</td></tr><tr><td>&nbsp;</td></tr><tr><td>&nbsp;</td></tr><tr><td>&nbsp;</td></tr><tr><td> <div align='center'><font color='#000000' size=6><strong>"+ this.logoOrgName +"</strong></font></div></td></tr></table>";
    // '<center><font size=6 color=red style="FONT-FAMILY: 隶书">'+ "1111111111111111"+ '</font></center>',
    //Painel topo (Logotipo do sistema)
    this._logoPanel = new Ext.Panel({
        baseCls: 'x-plain',
 		html : title,
        id: 'login-logo',
//        height:this.languageSelection == true ? 130 : 400,
        region: 'center'
    });
    

    


    // Seta id para o elementos
    this._usernameId = Ext.id();
    this._passwordId = Ext.id();
    this._randcodeId = Ext.id();
    this._rememberMeId = Ext.id();
    this._emailId = Ext.id();
    this._recoverFieldsetId = Ext.id();
    this._RecoverUsernameId = Ext.id();
    this._languageId = Ext.id();
    this._loginButtonId = Ext.id();
    this._resetButtonId = Ext.id();
    this._passwordButtonId = Ext.id();
    this._winPasswordButtonId = Ext.id();
    this._splashProgressBarId = Ext.id();
    

    this.cp = new Ext.state.CookieProvider({
        expires: new Date(new Date().getTime()+(1000*60*60*24*30)) //30 dias
    });
   
    Ext.state.Manager.setProvider(this.cp);
    
    var filed_items =[];
    
    
    
    filed_items.push(
	{
	            xtype: 'textfield',
	            id: this._usernameId,
	            name: this.usernameField,
	            emptyText: '',
	            fieldLabel: this.usernameLabel,
	            vtype: this.usernameVtype,
	            validateOnBlur: false,
	            maxLength : 11,
	            cls : "login_user",
	            allowBlank: false
	        }
    );
    


    filed_items.push(
 		{
            xtype: 'textfield',
            inputType: 'password',
            cls : "pass_word",
            id: this._passwordId,
            name: this.passwordField,
            fieldLabel: this.passwordLabel,
            vtype: this.passwordVtype,
//            width: this.enableVirtualKeyboard == true ? 280 : 300,
            validateOnBlur: false,
            allowBlank: false,
            validationEvent: this.forceVirtualKeyboard == true ? 'blur' : 'keyup',
            enableKeyEvents: true,
            keyboardConfig: {
                showIcon: true,
                showKeyboardtbar:false,
//                languageSelection: false,
//                deadKeysButtonText: 'Type accented letters',
//                closeKeysButtonText: '关闭',
//                showdeadKeysButton: false,
//                showCloseButton: true
            },
      
            plugins: this.enableVirtualKeyboard == true ? new Ext.ux.plugins.VirtualKeyboard() : null,
            listeners: {
                render: function () {
                    this.capsWarningTooltip = new Ext.ToolTip({
                        target: this.id,
                        anchor: 'top',
                        width: 305,
                        html: '<div class="ux-auth-warning">Caps Lock est?ativado</div><br />' +
                    '<div>Aten玢o, com a tecla Caps Lock ativada voce pode digitar a senha incorreta.</div><br />' +
                    '<div>Desative a tecla Caps Lock antes de digitar a sua senha.</div>'
                    });

                    // disable to tooltip from showing on mouseover
                    this.capsWarningTooltip.disable();

                    // When the password field fires the blur event,
                    // the tootip gets enabled automatically (possibly an ExtJS bug).
                    // Disable the tooltip everytime it gets enabled
                    // The tooltip is shown explicitly by calling show()
                    // and enabling/disabling does not affect the show() function.
                    this.capsWarningTooltip.on('enable', function () {
                        this.disable();
                    });
                },

                keypress: {
                    fn: function (field, e) {
                        if (this.forceVirtualKeyboard) {
                            field.plugins.expand();
                            e.stopEvent();
                        }
                        else {
                            var charCode = e.getCharCode();
                            if ((e.shiftKey && charCode >= 97 && charCode <= 122) || (!e.shiftKey && charCode >= 65 && charCode <= 90)) {

                                field.capsWarningTooltip.show();
                            }
                            else {
                                if (field.capsWarningTooltip.hidden == false) {
                                    field.capsWarningTooltip.hide();
                                }
                            }
                        }
                    },
                    scope: this
                },

                blur: function (field) {
                    if (this.capsWarningTooltip.hidden == false) {
                        this.capsWarningTooltip.hide();
                    }
                }
            }
        }   
   
   );  
   
   
   
// filed_items.push(  
//   					{  
//                                        layout : 'table', // 把整个空间划分成两列  
//                                        items : [{  
//                                            layout : 'form', // 右边列再分成上下两行  
//                                            width : 85,  
//                                            items : [{  
//                                                name : 'login.validateCode',  
//                                                xtype : 'textfield',  
//                                                fieldLabel : '验证码',  
//                                                regex : /^[0-9]{4}$/,  
//                                                regexText : '图片不清楚吗？请点击图片进行刷新，验证码为4位数字!',  
//                                                width : 70,  
//                                                allowBlank : false,  
//                                                blankText : '验证码不能为空!'  
//                                            }]  
//                                        }, {  
//                                            html : '<img id="photo" src="user.action"  onmousedown="changeImg(this)"/>'  
//                                        }]  
//                                    }
//   ); 
   
   
   
   
   
   
   
   
   
   
   
   if(this.languageSelection){
	   filed_items.push(
			 {
	            xtype: 'iconcombo',
	            id: this._languageId,
	            hiddenName: this.languageField,
	            fieldLabel: this.languageLabel,
	            store: new Ext.data.SimpleStore({
	                fields: ['languageCode', 'languageName', 'countryFlag'],
	                data: [
                                [ 'zh_CN', '简体中文','ux-flag-zh_cn' ],
                                [ 'en', 'English','ux-flag-us' ] 
	                ] 
	            }),
	            valueField: 'languageCode',
	            value: this.defaultLanguage,
	            displayField: 'languageName',
	            iconClsField: 'countryFlag',
	            triggerAction: 'all',
	            editable: false,
	            mode: 'local'
	        }   
	   
	   );
   };
   
   
   
      if(this.enableRandCode){
		  filed_items.push(
			     {
			     	xtype:'codefield',
					name:this.randCodeField,  
					id:this._randcodeId,  
			     	fieldLabel: this.randCodeLabel,
			     	cls : "pass_word",
			     	width:240,
			     	allowBlank: false,
			     	validateOnBlur: false, 
					codeUrl:this._codeUrl,
					blankText:'验证码不能为空!'     
					}
		  );
      }


	
   filed_items.push(
 		{
            xtype       : 'checkbox',
            id          : this._rememberMeId,
            name        : this.rememberMeField,
            boxLabel    : '&nbsp;' + this.rememberMeLabel,
//            checked		: true,
            listeners: {
                render: function() {
                    Ext.get(Ext.DomQuery.select('#x-form-el-' + this._rememberMeId + ' input')).set({
                        qtip: '勾选后，30日内保存登录名.'
                    });
                },
                check: function(){
                	
                    if(Ext.getCmp(this._rememberMeId).getValue() == true){
                        Ext.state.Manager.set(this.usernameField, Ext.getCmp(this._usernameId).getValue());
                    }else{
                        Ext.state.Manager.clear(this.usernameField);
                    }
                },
                scope: this
            }
        }   
   
   );    

    // form panel
    this._formPanel = new Ext.form.FormPanel({
        region: 'south',
        border: false,
        bodyStyle: "padding: 10px;",
        waitMsgTarget: true,
        id: 'login-form',
        baseCls: 'x-plain',
        labelWidth: 60,
        labelAlign : 'right',
        defaults: {
            width: 300
//            width: this.enableVirtualKeyboard == true ? 300 : 300
        },
        baseParams: {
            task: 'login'
        },
        listeners: {
//            'actioncomplete': {
//                fn: this.onSuccess,
//                scope: this
//            },
//            'actionfailed': {
//                fn: this.onFailure,
//                scope: this
//            }
        },
//        height:this.languageSelection == true ? 130 : 110,
         height:this.languageSelection == true ? 130 : 110,
        items: filed_items
    });
    
    if(this.languageSelection){
	    Ext.getCmp(this._languageId).on('select', function () {
	        this.defaultLanguage = Ext.getCmp(this._languageId).getValue();
	        this.setlanguage();
	    },
	    this);
    }

    
    //Painel do formul醨io de recupera玢o de senha
    this._formPasswordPanel = new Ext.form.FormPanel({
        bodyStyle: "padding: 5px;",
        id: 'password-form',
        waitMsgTarget: true,
        labelWidth: 80,
        autoHeight: true,
        buttonAlign: 'center',
        baseParams: {
            task: 'forgotPassword'
        },
        items: [{
            layout: 'form',
            border: false,
            items: [{
                xtype: 'fieldset',
                title: this.recoverFieldset,
                id: this._recoverFieldsetId,
                autoHeight: true,
                items: [{
                    xtype: 'textfield',
                    id: this._RecoverUsernameId,
                    name: this.RecoverUsernameField,
                    fieldLabel: this.RecorverUsernameLabel,
                    vtype: this.RecoverUsernameVtype,
                    validateOnBlur: false,
                    maxLength : 11,
                    allowBlank: false
                },{
                    xtype: 'textfield',
                    vtype: this.emailVtype,
                    id: this._emailId,
                    name: this.emailField,
                    fieldLabel: this.emailLabel,
                    validateOnBlur: false,
                    anchor: '98%',
                    allowBlank: false
                }]
            }]
        }],
        buttons: [{
            text: this.passwordButton,
            id: this._winPasswordButtonId,
            width: 100,
            handler: this.Passwordsubmit,
            scale: 'medium',
            scope: this
        }]
    });

    // bot鮡s padr鮡s
    var buttons = [{
        id: this._loginButtonId,
        text: this.loginButton,
        handler: this.submit,
        scale: 'medium',
        scope: this
    }];
    var keys = [{
        key: [10, 13],
        handler: this.submit,
        scope: this
    }];
    
    if (typeof this.passwordButton == 'string') {
        buttons.push({
            id: this._passwordButtonId,
            text: this.passwordButton,
            handler: this.password,
            scale: 'medium',
            scope: this
        });
    }
    if (typeof this.resetButton == 'string') {
        buttons.push({
            id: this._resetButtonId,
            text: this.resetButton,
            //iconCls : 'ux-auth-cslose',
            handler: this.reset,
            scale: 'medium',
            scope: this
        });
    /**keys.push({
            key     : [27],
            handler : this.reset,
            scope   : this
        });**/
    }



    // cria a  window
    this._window = new Ext.Window({
        width: this.width,
//        height: this.languageSelection == true ? 300 : 280,
        height: this.languageSelection == true ? 320 : 300,
        closable: false,
        shadow:true, //去除阴影
        resizable: false,
        draggable: true,
        modal: this.modal,
        iconCls: 'ux-auth-header-icon',
        title: this.title,
        layout: 'border',
        bodyStyle: 'padding:5px;',
        buttons: buttons,
        buttonAlign: 'center',
        keys: keys,
        plain: false,
        items: [this._logoPanel, this._formPanel]
    });
    
    

     
    

     
	var splashWidth = Ext.lib.Dom.getViewWidth()*0.7;
	var splashHeigth = Ext.lib.Dom.getViewHeight()*0.8;	
	var oImgs=new Array('splash.png','splash01.png','splash03.png','splash04.png','splash05.png','splash06.png','splash07.png',
	'splash51.jpg','splash52.jpg','splash53.jpg','splash54.jpg','splash55.jpg','splash56.jpg','splash57.jpg','splash58.jpg','splash59.jpg',
	'splash60.jpg','splash61.jpg','splash62.jpg','splash63.jpg','splash64.jpg'
	);    

//alert(currIndex);

//  alert(parseInt(Math.random ()*oImgs.length+1))
  var currIndex = parseInt(Math.random ()*(oImgs.length-1)+1);
//  alert(currIndex)
  
//console.log(currIndex+'___'+oImgs[currIndex]);
 
// alert(oImgs.splice(parseInt(Math.random ()*(oImgs.length+1)) , 1);
// oImgs.splice(Math.floor(Math.random () * oImgs.length) , 1)


//document.body.style.backgroundImage="url("+oImgs[currIndex]+")" 
    　
    this._splashScreenPanel= new Ext.Panel({
//        baseCls: 'x-plain',
        height: splashHeigth -50,  
//        html : {html:"1111111111111111111"},
//        contentEl:
//        frame:true,
        items:[
			         {  
				        xtype: 'box', //或者xtype: 'component',  
//				        width: 100, //图片宽度  
//				        height: 200, //图片高度  
				        autoEl: {  
				            tag: 'img',    //指定为img标签  
				            src: this.basePath + '/'+ oImgs[currIndex]  //指定url路径  
				        }  
			    	}     
        
        ],

 		
 		layout:"fit",  
 		border : false,
        id: 'splash-back',
        region: 'center',
//        bbar:[{text:'11111111'}]
    });
       
    this._splashProgressBar =new Ext.ProgressBar( 
            {
					id: this._splashProgressBarId,
//					hidden:true,
					width: splashWidth,
					text:'请稍后...'
			});
			
	
//	var copyRight = "<div align='center'><font color='#000000' size=3><strong>欢迎使用 &nbsp;&nbsp; 博瑞广告经营管理系统 &nbsp;&nbsp; &copy;2006-2013 "+ this.logoOrgName + "&nbsp;&nbsp;&nbsp;北京博瑞科技&nbsp;&nbsp;&nbsp;联合开发 </strong></font></div>"       
   var copyRight = "<font color='#000000' size=3><strong>&nbsp;&nbsp; &copy;2006-2013 "+ this.logoOrgName + "&nbsp;&nbsp;&nbsp;北京博瑞科技&nbsp;&nbsp;&nbsp;联合开发 </strong></font>"  ;     

   
    this._windowSplashScreen = new Ext.Window({
        width: splashWidth,
        height: splashHeigth,
        closable: false,
        shadow:true, //去除阴影
        resizable: false,
        draggable: false,
        modal: false,
//        iconCls: 'ux-auth-header-icon',
//        title: this.title,
//        layout: 'border',
        bodyStyle: 'padding:5px;',
//        buttonAlign: 'center',
//        keys: keys,
        plain: true,
        items: [this._splashScreenPanel],
        bbar: [this._splashProgressBar],
        buttons:[{html:copyRight}],
//        buttons:[{text:copyRight}],
        buttonAlign:"center"
//        bbar: ['->',{html:copyRight}],
//		bbar:[{text:"bitem",aling:"middle"}], 
//        buttons:[this._splashProgressBar]
    });   
    
    
    
    
    
    Ext.getCmp(this._passwordButtonId).setVisible(false);
    if(this.enableRandCode)  Ext.getCmp(this._rememberMeId).setVisible(false);
   
    
    

    // and fire "show" event
    this._window.on('show', function () {
        this.setlanguage();
        Ext.getCmp(this._passwordId).setRawValue('admin');
//         Ext.getCmp(this._passwordId).setRawValue('');
        if(this.enableRandCode){
        	  Ext.getCmp(this._randcodeId).setRawValue('');
        }
      
        this.fireEvent('show', this);

    },
    this);

    //Cria a janela de recupera玢o de senha
    this._windowPassword = new Ext.Window({
        width: 400,
        height: 220,
        closable: true,
        resizable: false,
        draggable: true,
        modal: this.modal,
        iconCls: 'ux-auth-header-icon',
        title: this.Passwordtitle,
        bodyStyle: 'padding:5px;',
        keys: keys,
        closeAction: 'hide',
        items: this._formPasswordPanel
    });

    this._windowPassword.on('show', function () {
        this._formPasswordPanel.getForm().reset();
    }, this);
    
    this._windowSplashScreen.on('show', function () {
    	
    	    var pbar = Ext.getCmp(this._splashProgressBarId);


 			var Runner = function(){
			    var f = function(v, pbar, count, cb){
			        return function(){
			            if(v > count){
			                cb();
			            }else{
//			                if(pbar.id=='pbar4'){
//			                    //give this one a different count style for fun
//			                    var i = v/count;
//			                    pbar.updateProgress(i, Math.round(100*i)+'% completed...');
//			                }else{
//			                    pbar.updateProgress(v/count, '正在加载 ' + v + ' of '+count+'...');
			                    pbar.updateProgress(v/count, '正在加载数据 ...');
//			                }
			            }
			       };
			    };
			    return {
			        run : function(pbar, count, cb){
			            var ms = 1000/count;
			            for(var i = 1; i < (count+2); i++){
			               setTimeout(f(i, pbar, count, cb), i*ms);
			            }
			        },
			        restart : function(pbar,count, cb){
			        	pbar.reset();	
			        	this.run(pbar, count, cb);
			        }
			    }
			}();   	
			
    	 function aa(){
    	 	Runner.restart(pbar,100,aa)
    	 }
    	  Runner.run(pbar,100,aa)
    	
    	
    	
    	
    	
//		pbar.updateText("正在加载数据...");	//更新进度条的文本信息
//	
//		var waitConf = {					//开始执行进度条
//						interval:100,				//每次进度的时间间隔
//						duration:5000,				//进度条跑动的持续时间
//						increment:50,				//进度条的增量，这个值设的越大，进度条跑的越慢，不能小于1，如果小于1，进度条会跑出范围
//						fn:function(){				//进度条完成时执行的函数，也可设为nulll
//							pbar.updateText("更新完成.");//更新进度条的文本信息
//                            callBakWait();
//						}
//					};
//					
//		function callBakWait(){
//			pbar.wait(waitConf);
//		}					
//	
//	   callBakWait();


    }, this);
    
    
   
};

// Extend the Observable class
Ext.extend(Ext.ux.LoginWindow, Ext.util.Observable, {

    /**
     * LoginDialog window title
     *
     * @type {String}
     */
    title: '',

    /**
     * Alert title
     *
     * @type {String}
     */
    sucesso: '',

    /**
     * Alert title
     *
     * @type {String}
     */
    falha: '',

    /**
     * T铆tulo da janela de recupera莽茫o de senha
     *
     * @type {String}
     */
    Passwordtitle: '',
    /**
     * T铆tulo do fieldset da janela de recupera莽茫o de senha
     *
     * @type {String}
     */
    recoverFieldset: '',
    /**
     * Mensagem de espera ao enviar os dados
     *
     * @type {String}
     */
    waitMessage: '',

    /**
     * The login button text
     *
     * @type {String}
     */
    loginButton: '',

    /**
     * Texto do bot鉶 de recupera玢o de senha
     *
     * @type {String}
     */
    passwordButton: '',
    /**
     * Reset button
     *
     * @type {String}
     */
    resetButton: '',

    /**
     * Username field label
     *
     * @type {String}
     */
    usernameLabel: '',

    /**
     * Username field name
     *
     * @type {String}
     */
    usernameField: 'j_username',
    
    
    randCodeLabel: '',

    randCodeField: 'j_randcode',
    
    randCodeLabel: '',
    

    /**
     * Username validation
     *
     * @type {String}
     */
    usernameVtype: 'alphanum',

    /**
     * Password field label
     *
     * @type {String}
     */
    passwordLabel: ' ',

    /**
     * Password field name
     *
     * @type {String}
     */
    passwordField: 'j_password',

    /**
     * Password field validation
     *
     * @type {String}
     */
    passwordVtype: 'alphanum',
    /**
     * T韙ulo do campo email
     *
     * @type {String}
     */
    emailLabel: '',
    /**
     * Nome do campo email
     *
     * @type {String}
     */
    emailField: 'email',

    /**
     * Valida玢o do campo email
     *
     * @type {String}
     */
    emailVtype: 'email',
    
    /**
     * T韙ulo do campo email
     *
     * @type {String}
     */
    RecorverUsernameLabel: '',

    /**
     * Nome do campo email
     *
     * @type {String}
     */
    RecoverUsernameField: 'j_username',

    /**
     * Valida玢o do campo email
     *
     * @type {String}
     */
    RecoverUsernameVtype: 'alphanum',

    /**
     * Language field label
     *
     * @type {String}
     */
    languageLabel: '',

    /**
     * Language field name
     *
     * @type {String}
     */
    languageField: 'lang',

    /**
     * RememberMe field label
     *
     * @type {String}
     */
    rememberMeLabel : '记住我',

    /**
     * RememberMe field name
     *
     * @type {String}
     */
    rememberMeField : 'appfuseRocks',

    /**
     * Tooltip notRecommended
     *
     * @type {String}
     */
    notRecommended: 'recomendado para computadores compartilhados.',
    
    
    /**
     * Enable Virtual Keyboard for password
     *
     * @type {Bool}
     */
    enableVirtualKeyboard: false,

    /**
     * Force Virtual Keyboard for password entry
     * If true, also sets enableVirtualKeyboard property to true
     *
     * @type {Bool}
     */
    forceVirtualKeyboard: false,
    
    
    enableRandCode: false,
    
    logoOrgName: '单位名称',
    
    softVerison: '1.0',


    /**
     * encrypt password using md5 and sha1
     *
     * @type {Bool}
     */
    encryptType: 'md5',

    /**
     * Salt prepended to password, before encryption
     * If encrypt property is false, salt is not used
     *
     * @type {String}
     */
    salt: '',

    /**
     * Request url
     *
     * @type {String}
     */
    url: '',
    /**
     * Url de requisi玢o de recupera玢o de senha
     *
     * @type {String}
     */
    emailUrl: '',
    /**
     * Url de destino caso login seja efetivado
     *
     * @type {String}
     */
    locationUrl: '',

    /**
     * Path to images
     *
     * @type {String}
     */
    basePath: '',
    /**
     * Logotipo do sistema (Banner)
     *
     * @type {String}
     */
    winBanner: '',
    /**
     * Cor de fundo do formul醨io
     *
     * @type {String}
     */
    formBgcolor: '',
    /**
     * Idioma padr茫o do formul醨io
     */
    defaultLanguage: 'zh_CN',

    /**
     * Form submit method
     *
     * @type {String}
     */
    method: 'POST',

    /**
     * Open modal window
     *
     * @type {Bool}
     */
    modal: false,
    
    
    callBakFun: null,
    
    errorMsg1 : null,
    
    errorMsg2 : null,

    /**
     * CSS identifier
     *
     * @type {String}
     */
    _cssId: 'ux-LoginWindow-css',
    
    _codeUrl:'image.jsp',

    /**
     * Head info panel
     *
     * @type {Ext.Panel}
     */
    _logoPanel: null,
    
    
    _splashScreenPanel: null,
    
    _splashProgressBar: null,

    /**
     * Form panel
     *
     * @type {Ext.form.FormPanel}
     */
    _formPanel: null,

    /**
     * The window object
     *
     * @type {Ext.Window}
     */
    _window: null,
    
     _windowSplashScreen: null,
    /**
     * Objeto da janela de recupera玢o de senha
     *
     * @type {Ext.Window}
     */
    _windowPassword: null,

    /**
     * Show the LoginDialog
     *
     * @param {Ext.Element} el
     */
    show: function (el) {
    	
        this._window.show(el);
        
//        if(this.enableRandCode){
//	        var bd = Ext.getDom(this._randcodeId);    
//			var bd2 = Ext.get(bd.parentNode);   
//			var img = bd2.createChild({tag: 'img', src: this._codeUrl,align:'absbottom',alt:'如果看不清单击图片更换图片。'});   
//			this.codeEl = img;
//			img.on('click',this.loadCodeImg,this); 
//        } 
        
  

        
//        (function(){Ext.getCmp(this._usernameId).focus(true,true);}).defer(1000, this);
       
        if(Ext.state.Manager.get(this.usernameField)){ 
            Ext.getCmp(this._usernameId).setValue(Ext.state.Manager.get(this.usernameField));
            Ext.getCmp(this._passwordId).focus(true);
        }else{
            Ext.getCmp(this._usernameId).emptyText = '';
            Ext.getCmp(this._usernameId).focus(true);
        }
        
//        Ext.getCmp(this._usernameId).focus(true);
        
        
	
//        if(Ext.state.Manager.get(this.randCodeField)== null){ 
//        	Ext.state.Manager.set(this.randCodeField,this.enableRandCode);
//        }

        
        
//        var html = '<div id="errMsg" style="text-align:center;padding-top:0px;color:red;"></div>';
//        Ext.select('.x-form-clear-left').each(function(o,g,i){
//            if (i==2)
//            o.insertSibling(html,'after')
//        });       
        
        
    },
    		    
//	loadCodeImg: function(){  /*加载验证码图片方法，加上随机数参数让图片刷新*/  
//		        alert( this.codeEl)
//		        this.codeEl.set({src:this._codeUrl});  
//	},
    /**
     * Exibe a  janela de recupera玢o de senha
     *
     * @param {Ext.Element} el
     */
    password: function (el) {
        this._windowPassword.show(el);
    },
    /**
     * Limpa o formul醨io
     */
    reset: function () {
        if (this.fireEvent('reset', this)) {
            this._formPanel.getForm().reset();
            if(this.languageSelection){
            	 this.defaultLanguage = Ext.getCmp(this._languageId).getValue();
            	 this.setlanguage();
            }
//            Ext.get('errMsg').update('');
            
        }
    },

    /**
     * Seleciona o idioma
     */
    setlanguage: function () {
        Ext.override(Ext.form.Field, {
            setFieldLabel: function (text) {
                if (this.rendered) {
                    this.el.up('.x-form-item', 10, true).child('.x-form-item-label').update(text);
                } else {
                    this.fieldLabel = text;
                }
            }
        });
        if (this.defaultLanguage == 'zh_CN') {
            this._window.setTitle('登录');
            this._windowPassword.setTitle('覆盖密码');
            Ext.getCmp(this._loginButtonId).setText('登录');
            Ext.getCmp(this._passwordButtonId).setText('覆盖密码');
            Ext.getCmp(this._resetButtonId).setText('清除');
            Ext.getCmp(this._winPasswordButtonId).setText('覆盖密码');
            Ext.getCmp(this._emailId).setFieldLabel('邮箱');
            Ext.getCmp(this._RecoverUsernameId).setFieldLabel('帐号');
            Ext.getCmp(this._recoverFieldsetId).setTitle('输入用户名和邮箱');
            Ext.getCmp(this._usernameId).setFieldLabel('帐号:');
            Ext.getCmp(this._passwordId).setFieldLabel('密码:'); 
            
             if(this.enableRandCode){
             	Ext.getCmp(this._randcodeId).setFieldLabel('验证:');
             }
            
            
            
            
//            Ext.getCmp(this._rememberMeId).setFieldLabel('30天内可自动登录?');
            
           
            if(this.languageSelection){
            	 Ext.getCmp(this._languageId).setFieldLabel('语言:');
            }
            this.waitMessage = '发送数据中...';
            this.sucesso = '成功';
            this.falha = '失败';  
            this.errorMsg1 = '验证码不正确.';   
            this.errorMsg2 = '用户名或者密码不正确.';   

  
            
        } else if (this.defaultLanguage == 'en') {
            this._window.setTitle('Authentication');
            this._windowPassword.setTitle('Recover password');
            Ext.getCmp(this._loginButtonId).setText('Login');
            Ext.getCmp(this._passwordButtonId).setText('Recover password');
            Ext.getCmp(this._resetButtonId).setText('Clear');
            Ext.getCmp(this._winPasswordButtonId).setText('Recover password');
            Ext.getCmp(this._emailId).setFieldLabel('Email');
            Ext.getCmp(this._RecoverUsernameId).setFieldLabel('Username');
            Ext.getCmp(this._recoverFieldsetId).setTitle('Enter your username and email');
            Ext.getCmp(this._usernameId).setFieldLabel('Username:');
            Ext.getCmp(this._passwordId).setFieldLabel('Password:');
            if(this.enableRandCode){
             	Ext.getCmp(this._randcodeId).setFieldLabel('RandCode:');
             }
            
            
//            Ext.getCmp(this._rememberMeId).setFieldLabel('30 day remember?');
            if(this.languageSelection){
          	  Ext.getCmp(this._languageId).setFieldLabel('Language:');	
            }

            this.waitMessage = 'Sending data...';
            this.sucesso = 'Success';
            this.falha = 'Failure';
   
            this.errorMsg1 = 'error randomCode1.';   
            this.errorMsg2 = 'error user or pwd';                 
            
        }
    },

    /**
     * Hide and cleanup the LoginWindow
     */
    destroy: function () {
        this._window.hide();
        this.purgeListeners();
        Ext.util.CSS.removeStyleSheet(this._cssId);
        var self = this;
        delete self;
    },

    /**
     * Submit login details to the server
     */
    submit: function () {
    	
    
        var form = this._formPanel.getForm();

 
        if (form.isValid()) {
            Ext.getCmp(this._loginButtonId).disable();
            if (Ext.getCmp(this._resetButtonId)) {
                Ext.getCmp(this._resetButtonId).disable();
            }
            if (Ext.getCmp(this._passwordButtonId)) {
                Ext.getCmp(this._passwordButtonId).disable();
            }
            if (this.encryptType == 'md5') {
//                Ext.getCmp(this._passwordId).setRawValue(Ext.util.MD5(Ext.getCmp(this._passwordId).getValue()));
            } else if(this.encryptType == 'sha1') {
//                Ext.getCmp(this._passwordId).setRawValue(Ext.ux.Crypto.SHA1.hash(this.salt + Ext.getCmp(this._passwordId).getValue()));
            }

      
            
        
//	            if (this.fireEvent('submit', this, form.getValues())) {
//	                form.submit({
//	                    url: this.url,
//	                    method: this.method,
//	                    waitMsg: this.waitMessage,
//	                    success: this.onSuccess,
//	                    failure: this.onFailure,
//	                    scope: this
//	                });
//	            }	
          
 
//		            var OBJ = this;         
//		     		Ext.Ajax.request({
//			                    			url: OBJ.url,
//		       				    			method : OBJ.method,
//		       				    			waitMsg: OBJ.waitMessage,
//		       				    			params: form.getValues(),
//		       				    		    success: function(response, opts){
// 												var obj=Ext.decode(response.responseText);  
// 												if(obj.success){
// 													OBJ.onSuccess();
// 												}else{
// 													OBJ.onFailure();
// 												}
//		       				    		    }
//				});     
				
				
				 var OBJ = this; 
	            if (this.fireEvent('submit', this, form.getValues())) {
			     	Ext.Ajax.request({
				                    			url: this.url,
			       				    			method : this.method,
			       				    			waitMsg: this.waitMessage,
			       				    			params: form.getValues(),
			       				    		    success: function(response, opts){
	 												var obj=Ext.decode(response.responseText);  
	 												if(obj.success){
	 													OBJ.onSuccess(response, opts);
	 												}else{
	 													OBJ.onFailure(response, opts);
	 												}
			       				    		    }
					});  
	            }					

            
            
        }
    },
    /**
     * Envia a requisi玢o de recupera玢o de senha
     */
    Passwordsubmit: function () {
        var form = this._formPasswordPanel.getForm();

        if (form.isValid()) {
            Ext.getCmp(this._winPasswordButtonId).disable();
            if (this.fireEvent('submitpass', this, form.getValues())) {
                form.submit({
                    url: this.emailUrl,
                    method: this.method,
                    waitMsg: this.waitMessage,
                    success: this.onEmailSuccess,
                    failure: this.onEmailFailure,
                    scope: this
                });
            }
        }
        
        
        
// 	 	try
//            {
//               // Some declarations and validations performed here...
//				if (form.isValid()) {
//			            Ext.getCmp(this._winPasswordButtonId).disable();
//			            if (this.fireEvent('submitpass', this, form.getValues())) {
//			                form.submit({
//			                    url: this.emailUrl,
//			                    method: this.method,
//			                    waitMsg: this.waitMessage,
//			                    success: this.onEmailSuccess,
//			                    failure: this.onEmailFailure,
//			                    scope: this
//			                });
//			            }
//			        }
//            }
//            catch(message)
//            {
//               Ext.MessageBox.alert("Error", message);
//            }       
        
        
        
        
        
        
        
    },
    
    showSplashScreen: function(){
         
    },

    /**
     * On success
     *
     * @param {Ext.form.BasicForm} form
     * @param {Ext.form.Action} action
     */
    onSuccess: function (form, action) {
//    	 Ext.get('errMsg').update('');

//        if (action && action.result) {
        	var lang = this.languageSelection? '?request_locale=' + Ext.getCmp(this.languageId).getValue():"";
//        	window.location = this.locationUrl + lang;
//        }
        

        if(form.responseText){
	        var respText = Ext.util.JSON.decode(form.responseText);    
            
//            alert(this.locationUrl)
	    	if(form.responseText){
		        var respText = Ext.util.JSON.decode(form.responseText);    
	            var url = "";
		        if(respText.targetUrl){
		        	 url = respText.targetUrl + lang;
		        }else{
	 				url =  this.locationUrl + lang;
		        }
//		        window.location =  "desktop";
                Ext.onReady(function(){window.location = url;},this,{delay:1000});  
                
	        }       
	        
	
                this._window.hide();
                this._windowSplashScreen.show();      
                
           
	        
	        
//	        this._window.buttons.remove(true);
//               var aaa = this._window.buttons.remove(true);
//	          alert(aaa)
////           alert(111111111)
//	       var count  =  this._window.removeAll(true) ;
//	      
//	       alert(count)
//	           this._window.doLayout()  
//            this._window.hide();
//	        this.showSplashScreen();
//	         this._windowSplashScreen.show();
//	         Ext.getBody().mask(false, '<div class=".splash">Loading&hellip;</div>') 
//	         Ext.getBody().mask('数据加载中……', 'x-mask-loading');
//	         Ext.getBody().unmask();

     		 
	        
//	        		Ext.Ajax.request({
//				                    			url: 'mainMenu.html',
//				                    			scriptTag: true, 
//			       				    			method : 'GET',
//			       				    			waitMsg: this.waitMessage,
//			       				    		    success: function(response, opts){
//			       				    		    	console.log(response)
//	 			                                     alert(3);
//			       				    		    }
//					});  
        }       
        
        
        
        Ext.getCmp(this._loginButtonId).enable();
        
        if (Ext.getCmp(this._resetButtonId)) {
            Ext.getCmp(this._resetButtonId).enable();
        }
        if (Ext.getCmp(this._passwordButtonId)) {
            Ext.getCmp(this._passwordButtonId).enable();
        }
        
        this.locationUrl = null;
        
//        this.destroy();
//        _window.destroy();


       


//			var chartPanel = new Ext.Panel({
//		    //title:'财务图表',
////		      width: 540,
////		    height: 400,
//             layout: 'fit',  
//		    html:'<iframe id="iframeA" scrolling="auto" frameborder="0" width="100%" height="100%" src="mainMenu.html"></iframe>'
//		    });    
//	      
//	        var myWin = new Ext.Window({
////		       title:'本月支出图表',  
////		       width:540,  
////		       height:400,
//               closable: false,
//		       animCollapse: true,
//		       resizable:false,  
//		       modal:true,  
//		       closeAction :'hide',
//		       layout: 'fit',  
////		       window:{layout:'fitall'},
//		       items:chartPanel
//		    });
//			var vs = Ext.getBody().getViewSize();  
//			myWin.setSize(vs.width-100, vs.height-100);  
//			myWin.show();  







    },


    /**
     * On failures
     *
     * @param {Ext.form.BasicForm} form
     * @param {Ext.form.Action} action
     */
    onFailure: function (form, action) {
//    	if (action && action.result) {
//    		  Ext.Msg.alert("登录错误",action.result.errors.reason);      //返回失败
//    		  Ext.get('errMsg').update(this.errorMsg1);
//    	}

        
        if(form.responseText){
	        var respText = Ext.util.JSON.decode(form.responseText);           
	        if(respText.errors == 1){
//	        	 Ext.get('errMsg').update(this.errorMsg1);
//				 alert(this.errorMsg1)
                 if(this.enableRandCode){Ext.getCmp(this._randcodeId).focus(true);}  
	        	 this.showNotification('<p><font color="#FF0000" size="3">'+this.errorMsg1+'</font> </p>');
	        }else{
//	        	 Ext.get('errMsg').update(this.errorMsg2);
//                 alert(this.errorMsg2)
	        	 this.showNotification('<p><font color="#FF0000" size="3">'+this.errorMsg2+'</font> </p>');
	        	 Ext.getCmp(this._passwordId).focus(true);
	        }

        }

      	Ext.getCmp(this._loginButtonId).enable();
 

        if (Ext.getCmp(this._resetButtonId)) {
            Ext.getCmp(this._resetButtonId).enable();
        }
        if (Ext.getCmp(this._passwordButtonId)) {
            Ext.getCmp(this._passwordButtonId).enable();
        }
        if (this.encrypt) {
            Ext.getCmp(this._passwordId).setRawValue('');
        }

     

    },
    /**
     * Se receber sucesso
     *
     * @param {Ext.form.BasicForm} form
     * @param {Ext.form.Action} action
     */
    onEmailSuccess: function (form, action) {
        Ext.getCmp(this._winPasswordButtonId).enable();
        if (action && action.result.msg) {
            Ext.MessageBox.alert(this.sucesso, action.result.msg, this._windowPassword.hide());
        }
       
    },
    /**
     * Se receber falha
     *
     * @param {Ext.form.BasicForm} form
     * @param {Ext.form.Action} action
     */
    onEmailFailure: function (form, action) {
        // Ativa os bot鮡s
        Ext.getCmp(this._winPasswordButtonId).enable();
        if (action && action.result.msg) {
            Ext.MessageBox.alert(this.falha, action.result.msg);
        }
        
    },
    
//    showNotis: function(){
//		new Ext.ux.Notification({
//		  iconCls:    'x-icon-error',
//		  title:      'Ruh-row',
//		  html:       'This is just a stub.  This is only a stub.  If this would have been a real functioning doo-dad, you never would have even seen this stub.',
//		  autoDestroy: true,
//		   hideDelay:  5000
//		}).show(document);
//    }

	showNotification: function(msg){
		var tipw = new MyLib.TipsWindow({  
		    title:"系统提示",  
		    autoHide:5, //5秒自动关闭  
		    html:msg
		});  
		tipw.show(); 
	
//		var target = Ext.get(this._usernameId).dom.id;
//		new Ext.ToolTip({  
//		        target: target,
//		        html: '看官方示例你就什么都会了!!!'  
//		    });  
		
	},
	 initPosition: function() {
//            var doc = document, bd = (doc.body || doc.documentElement);
//            //ext取可视范围宽高(与上面方法取的值相同), 加上滚动坐标
//            var left = bd.scrollLeft + Ext.lib.Dom.getViewWidth()-4-this.width;
//            var top = bd.scrollTop + Ext.lib.Dom.getViewHeight()-4-this.height;
//            this.setPosition(left);
  
	          var left = (Ext.lib.Dom.getViewWidth() - this._window.getWidth())/2;
	          var top =  (Ext.lib.Dom.getViewHeight()- this._window.getHeight())/2;
			  this._window.setPosition(left,top);
			  
			  if(this._windowSplashScreen){
			  	  var viewWidth = Ext.lib.Dom.getViewWidth();
   				  var viewHeight = Ext.lib.Dom.getViewHeight();
   				  
   				  
   				  
				  this._splashScreenPanel.setHeight(viewHeight-200);	   				  		
		          this._windowSplashScreen.setWidth(viewWidth*0.7);
				  this._windowSplashScreen.setHeight(viewHeight*0.8);
	  			  this._splashProgressBar.setWidth(viewWidth*0.7);
				  
		          left = (viewWidth - this._windowSplashScreen.getWidth())/2;
		          top =  (viewHeight- this._windowSplashScreen.getHeight())/2;				  
				  this._windowSplashScreen.setPosition(left,top);
			  }
			  

        },

	getWinX : function(width){
		return (Ext.lib.Dom.getViewWidth() - width) / 2;
	},
		
	getWinY : function(height){
		return (Ext.lib.Dom.getViewHeight()-taskbarEl.getHeight() - height) / 2;
	}


});










