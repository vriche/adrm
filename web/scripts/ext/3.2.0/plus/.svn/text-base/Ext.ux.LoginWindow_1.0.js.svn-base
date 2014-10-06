
/**
 * @class Ext.ux.form.IconComboBox
 * @extends Ext.form.ComboBox
 */

Ext.namespace('Ext.ux.form');

Ext.ux.form.IconCombo = Ext.extend(
                Ext.form.ComboBox,
                {
                    initComponent : function() {
                        var css = '.ux-icon-combo-icon {background-repeat: no-repeat;background-position: 0 50%;width: 18px;height: 14px;}'
                                + '.ux-icon-combo-input {padding-left: 25px;}'
                                + '.x-form-field-wrap .ux-icon-combo-icon {top: 4px;left: 5px;}'
                                + '.ux-icon-combo-item {background-repeat: no-repeat ! important;background-position: 3px 50% ! important;padding-left: 24px ! important;}'
                                + ".ux-flag-zh_cn {background-image:url(security/images/framework/cn_zh.png) !important;}"
                                + ".ux-flag-us {background-image:url(security/images/framework/en_us.png) !important;}";

                        Ext.util.CSS.createStyleSheet(css, this._cssId);

                        Ext.apply(
                                        this,
                                        {
                                            tpl : '<tpl for=".">'
                                                    + '<div class="x-combo-list-item ux-icon-combo-item '
                                                    + '{' + this.iconClsField
                                                    + '}">' + '{'
                                                    + this.displayField + '}'
                                                    + '</div></tpl>'
                                        });

                        // call parent initComponent
                        Ext.ux.form.IconCombo.superclass.initComponent.apply(
                                this, arguments);

                    } // eo function initComponent

                    ,
                    onRender : function(ct, position) {
                        // call parent onRender
                        Ext.ux.form.IconCombo.superclass.onRender.apply(this,
                                arguments);

                        // adjust styles
                        this.wrap.applyStyles( {
                            position : 'relative'
                        });
                        this.el.addClass('ux-icon-combo-input');

                        // add div for icon
                        this.icon = Ext.DomHelper.append(this.el
                                .up('div.x-form-field-wrap'), {
                            tag : 'div',
                            style : 'position:absolute'
                        });
                    } // eo function onRender

                    ,
                    afterRender : function() {
                        Ext.ux.form.IconCombo.superclass.afterRender.apply(
                                this, arguments);
                        if (undefined !== this.value) {
                            this.setValue(this.value);
                        }
                    } // eo function afterRender
                    ,
                    setIconCls : function() {
                        var rec = this.store.query(this.valueField,
                                this.getValue()).itemAt(0);
                        if (rec && this.icon) {
                            this.icon.className = 'ux-icon-combo-icon ' + rec
                                    .get(this.iconClsField);
                        }
                    } // eo function setIconCls

                    ,
                    setValue : function(value) {
                        Ext.ux.form.IconCombo.superclass.setValue.call(this,
                                value);
                        this.setIconCls();
                    } // eo function setValue

                    ,
                    _cssId : 'ux-IconCombo-css'

                });

// register xtype
Ext.reg('iconcombo', Ext.ux.form.IconCombo);

/**
 * @Description Ext.ux.LoginWindow for ExtJS 2.x and 3.x
 * @author  Wemerson Januario (Brazil - Goiania)
 * @author  Albert Varaksin
 * @author  Sumit Madan
 * @license LGPLv3 http://www.opensource.org/licenses/lgpl-3.0.html
 * @version 1.0, 09/05/2009
 */
Ext.namespace('Ext.ux');
Ext.namespace('micrite.security.framework');
/**
 * Construtor da janela de login
 *
 * @param {Object} config
 * @extends {Ext.util.Observable}
 */
 
		
Ext.ux.LoginWindow = function(config) {
    Ext.apply(this, config);
    var css = "#login-logo .x-plain-body {background:#f9f9f9 url('"
            + this.basePath + "/" + this.winBanner + "') no-repeat;}"
            + "#login-form  {background: " + this.formBgcolor + " none;}"
            + ".ux-auth-header-icon {background: url('" + this.basePath
            + "/locked.gif') 0 4px no-repeat !important;}"
            + ".ux-auth-form {padding:10px;}"
            + ".ux-auth-login {background-image: url('" + this.basePath
            + "/key.gif') !important}"
            + ".ux-auth-close {background-image: url('" + this.basePath
            + "/close.gif') !important}";

    Ext.util.CSS.createStyleSheet(css, this._cssId);
   
    this.addEvents( {
        'show' : true,
        'reset' : true,
        'submit' : true
    });
    Ext.ux.LoginWindow.superclass.constructor.call(this, config);
    
     Ext.Ajax.on('beforerequest', function(){  
       Ext.Ajax.extraParams={'ajax_extraParams':'true'};  
     }, this);//     
    
     Ext.Ajax.on('requestcomplete', function(conn,response){  
     	
     	 alert("请重新登陆!")  
        try{  
          var resp=Ext.decode(response.responseText);  
          if(resp.ajax_session_invalid){  
            alert("请重新登陆!")  
            location=g_rootPath+"login.jsp";  
          }  
        }catch(e){  }  
    }, this);     
    

    this._logoPanel = new Ext.Panel( {
        baseCls : 'x-plain',
        id : 'login-logo',
        region : 'center'
    });
    this.usernameId = Ext.id();
    this.passwordId = Ext.id();
    this.languageId = Ext.id();
    this.rememberMeId = Ext.id();
    this._loginButtonId = Ext.id();
    this._resetButtonId = Ext.id();
    this._rememberMeId = Ext.id();

    this._formPanel = new Ext.form.FormPanel( {
        region : 'south',
        border : false,
        frame:true, //属性frame：把四个角变成圆角   
        bodyStyle : "padding: 5px;",
        baseCls : 'x-plain',
        id : 'login-form',
        waitMsgTarget : true,
        labelWidth : 70,
        labelAlign : 'left',
        style : 'padding-left:10px;',
        defaults : {
            width : 300
        },
        baseParams : {
            task : 'login'
        },
        height : 110,
        items : [
                {
                    xtype : 'textfield',
                    id : this.usernameId,
                    name : this.usernameField,
                    fieldLabel : this.usernameLabel,
                    vtype : this.usernameVtype,
                    validateOnBlur : false,
                    allowBlank : false
                },
                {
                    xtype : 'textfield',
                    inputType : 'password',
                    id : this.passwordId,
                    name : this.passwordField,
                    fieldLabel : this.passwordLabel,
                    vtype : this.passwordVtype,
                    validateOnBlur : false,
                    allowBlank : false
                },
                {
                    xtype : 'iconcombo',
                    id : this.languageId,
                    hiddenName : this.languageField,
                    fieldLabel : this.languageLabel,
                    store : new Ext.data.SimpleStore( {
                        fields : [ 'languageCode', 'languageName',
                                'countryFlag' ],
                        data : [
                                [ 'zh_CN', '简体中文','ux-flag-zh_cn' ],
                                [ 'en', 'English','ux-flag-us' ] 
                              ]
                    }),
                    valueField : 'languageCode',
                    value : this.defaultLanguage,
                    displayField : 'languageName',
                    iconClsField : 'countryFlag',
                    triggerAction : 'all',
                    editable : false,
                    mode : 'local'
                }, 
                {
		            xtype       : 'checkbox',
		            id          : this._rememberMeId,
		            name        : this.rememberMeField,
		            boxLabel    : '&nbsp;' + this.rememberMeLabel,
		            listeners: {
		                render: function() {
		                    Ext.get(Ext.DomQuery.select('#x-form-el-' + this._rememberMeId + ' input')).set({
		                        qtip: '111111111111'
		                    });
		                },
		                check: function(){
		                    if(Ext.getCmp(this._rememberMeId).getValue() == true){
		                        Ext.state.Manager.set('username', Ext.getCmp(this._usernameId).getValue());
		                    }else{
		                        Ext.state.Manager.clear('username');
		                    }
		                },
		                scope: this
		            }
		        }
                
                ]
    });
    Ext.getCmp(this.languageId).on('select', function() {
        this.defaultLanguage = Ext.getCmp(this.languageId).getValue(); //var lang = this.defaultLanguage;   
            this.setlanguage();
        }, this);

    var buttons = [ {
        id : this._loginButtonId,
        text : this.loginButton,
        handler : this.submit,
        scale : 'medium',
        scope : this
    } ];
    var keys = [ {
        key : [ 10, 13 ],
        handler : this.submit,
        scope : this
    } ];

    if (typeof this.resetButton == 'string') {
        buttons.push( {
            id : this._resetButtonId,
            text : this.resetButton,
            handler : this.reset,
            scale : 'medium',
            scope : this
        });
        keys.push( {
            key : [ 27 ],
            handler : this.reset,
            scope : this
        });
    }
    this._window = new Ext.Window( {
        width : 420,
        height : 280,
        closable : false,
        shadow : false,
        draggable : false,
        forceLayout: true,
        resizable : false,
        draggable : false,
        modal : this.modal,
        iconCls : 'ux-auth-header-icon',
        title : this.title,
        layout : 'border',
        buttons : buttons,
        buttonAlign : 'center',
        keys : keys,
        footerCfg: {
            cls: 'x-panel-footer' ,       // same as the Default class
            html: '<div id="forgotIt" style="position:absolute;right:20px;padding-top:22px"><a href="forgotPasswordStepOne.action?request_locale=en">forgot password?</a></div>'
        },
        footerStyle : 'font-size:11px;text-align:right;',
        plain : false,
        onEsc : function(){
            this.center();
        },
        items : [ this._logoPanel, this._formPanel ]
    });

    this._window.on('show', function() {
        this.setlanguage();
        this.fireEvent('show', this);
    }, this);    
};

// Extende a classe Ext.util.Observable
Ext.extend(Ext.ux.LoginWindow, Ext.util.Observable, {
    title : '',
    Passwordtitle : '',
    waitMessage : '',
    loginButton : '',
    resetButton : '',
    usernameLabel : '',
    usernameField : 'j_username',
    usernameVtype : 'alphanum',
    passwordLabel : '',
    passwordField : 'j_password',
    passwordVtype : 'alphanum',
    languageField : 'lang',
    languageLabel : '',
    rememberMeLabel : '记住 ?',
    rememberMeField : 'rememberMe',
    url : '',
    locationUrl : '',
    basePath : 'img',
    winBanner : '',
    formBgcolor : '',
    method : 'post',
    modal : false,
    _cssId : 'ux-LoginWindow-css',
    _logoPanel : null,
    _formPanel : null,
    _window : null,
     errorMsg : null,
    show : function(el) {
        this._window.show(el);
        (function(){
            Ext.getCmp(this.usernameId).focus(true,true);
       }).defer(1000, this);
        var html = '<div id="errMsg" style="text-align:center;padding-top:0px;color:red;"></div>';
        Ext.select('.x-form-clear-left').each(function(o,g,i){
            if (i==2)
            o.insertSibling(html,'after')
        });
    },

    reset : function() {
        if (this.fireEvent('reset', this)) {
            Ext.getDom(this.usernameId).value = '';
            Ext.getDom(this.passwordId).value = '';
            Ext.get('errMsg').update('');
        }
    },
    defaultLanguage : 'zh_CN',
    setlanguage : function() {
        Ext.override(Ext.form.Field, {
            setFieldLabel : function(text) {
                if (this.rendered) {
                    this.el.up('.x-form-item', 10, true).child(
                            '.x-form-item-label').update(text);
                } else {
                    this.fieldLabel = text;
                }
            },
            setBoxLabel : function(text) {
                if (this.rendered) {
                    this.el.up('.x-form-item', 10, true).child(
                            '.x-form-cb-label').update(text);
                } else {
                    this.boxLabel = text;
                }
            }
        });
        if (this.defaultLanguage == 'zh_CN') {
            this._window.setTitle('认证');
            Ext.getCmp(this._loginButtonId).setText('登录');
            Ext.getCmp(this._resetButtonId).setText('清除');
            Ext.getCmp(this.usernameId).setFieldLabel('用户名:');
            Ext.getCmp(this.passwordId).setFieldLabel('密码:');
            Ext.getCmp(this.languageId).setFieldLabel('语言:');
            Ext.getCmp(this.rememberMeId).setFieldLabel('记住我:');
            Ext.get('forgotIt').update('<a href="forgotPasswordStepOne.action?request_locale=' + Ext.getCmp(this.languageId).getValue()+'">忘记密码?</a>');
            this.errorMsg = '用户名或者密码不正确.';
            this.waitMessage = '发送数据中...';
        } else if (this.defaultLanguage == 'en') {
            this._window.setTitle('Authentication');
            Ext.getCmp(this._loginButtonId).setText('Login');
            Ext.getCmp(this._resetButtonId).setText('Clear');
            Ext.getCmp(this.usernameId).setFieldLabel('Username:');
            Ext.getCmp(this.passwordId).setFieldLabel('Password:');
            Ext.getCmp(this.languageId).setFieldLabel('Language:');
            Ext.getCmp(this.rememberMeId).setFieldLabel('rememberMe:');
            Ext.get('forgotIt').update('<a href="forgotPasswordStepOne.action?request_locale=' + Ext.getCmp(this.languageId).getValue()+'">forgot password?</a>');
            this.errorMsg = 'The username or password you entered is incorrect.';
            this.waitMessage = 'Sending data...';
        }
    },

    submit : function() {
        var form = this._formPanel.getForm();

//        if (form.isValid()) {
//            if (this.fireEvent('submit', this, form.getValues())) {
//                form.submit({
//                    url : this.url,
//                    method : this.method,
//                    waitMsg : this.waitMessage,
//                    success : this.onSuccess,
//                    failure : this.onFailure,
//                    scope : this
//                });
//            }
//        }
        
        var OBJ = this;             
        
         var myMask = new Ext.LoadMask(Ext.getBody(), {
                        msg: OBJ.waitMessage,
                        removeMask: true //完成后移除
                    });
         myMask.show();       
         
		Ext.Ajax.request({
	                    			url: OBJ.url,
       				    			method : OBJ.method,
       				    			params: form.getValues(),
//       				    			waitMsg : OBJ.waitMessage,
       				    		    success: function(response, opts){
			 					        myMask.hide();
							            var lang = '?request_locale=' + Ext.getCmp(OBJ.languageId).getValue();
//							            semx= window.open(OBJ.locationUrl,"main","toolbar=no,location=no,status=no,resizable=no,scrollbars=yes,menubar=no,fullscreen=1");
							            window.location = OBJ.locationUrl+lang;
//			                            OBJ.close();							            
							            
       				    		    },
       				    		    failure: function(response, opts){
								        Ext.getCmp(OBJ._loginButtonId).enable();
								        if (Ext.getCmp(OBJ._resetButtonId)) {
								            Ext.getCmp(OBJ._resetButtonId).enable();
								        }
								        Ext.getCmp(OBJ.usernameId).focus(true,true);
								        //var res = action.result.errorMsg.reason;
								        Ext.get('errMsg').update(OBJ.errorMsg);
       				    		    }
       				    		    	
		});


    }

//    onSuccess : function(form, action) {
//        if (action && action.result) {
//            var lang = '?request_locale=' + Ext.getCmp(this.languageId).getValue();
//            window.location = this.locationUrl+lang;
//        }
//    },
//    onFailure : function(form, action) { // enable buttons
//        Ext.getCmp(this._loginButtonId).enable();
//        if (Ext.getCmp(this._resetButtonId)) {
//            Ext.getCmp(this._resetButtonId).enable();
//        }
//        Ext.getCmp(this.usernameId).focus(true,true);
//        //var res = action.result.errorMsg.reason;
//        Ext.get('errMsg').update(this.errorMsg);
//    }
});