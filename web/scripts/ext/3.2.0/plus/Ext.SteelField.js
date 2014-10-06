    /** 
     * 继承自 Container  
     * 默认功能配置项：  
     *   
     * @class SteelField 
     * @extends Container 
     *   
     *     部分特定配置方法如下（其他的和XXXField一样）： 
     *     ------------------------------------------ 
     *     xhide: 标签是否显示（注意：如果xhide为true，则控件在表单的位置将由随后的控件所占据，其默认值将由xvalue指定） 
     *     xvalue: 控件影藏时，表单提交的值。默认为 null 
     *     fieldLabel: 标签 
     *     labelWidth：（可选）标签的宽度，默认为文字长度+1 * 12 像素 
     *     labelAlign：（可选）标签位置，默认靠左 
     *     inputWidth：文本框宽度，默认 100 像素 
     *     type: （text/number/date/date2/combo/steelcombogird）控件类型，默认为 text 
     *     ------------------------------------------ 
     */  
    Ext.SteelField = Ext.extend(Ext.Container, {  
          
        xhide : false,  
          
        xvalue : null,  
          
        isFormField : true,  
          
        autoHeight : true,  
      
        initComponent : function() {  
            Ext.SteelField.superclass.initComponent.call(this);  
        },  
        constructor : function(options) {  
            Ext.apply(this, options);  
            Ext.SteelField.superclass.addEvents.call(this);  
              
            //文本框类型 xtype  
            var typeMap = {  
                text : 'textfield',  
                area : 'textarea',  
                number : 'numberfield',  
                date : 'datefield',  
                combo : 'combo',  
                combogrid : 'steelcombogird',  
                date2 : 'steel2date'  
            }, fieldType = typeMap[this.type || 'text'];  
      
            this.labelAlign = 'left';  
              
            if(fieldType=='textarea'){  
                this.height = options.height ? options.height : 22;  
                options.height = this.height;  
            }  
              
            if(this.xhide){  
                this.field = new Ext.form.Hidden(Ext.applyIf({  
                                value: this.xvalue || null  
                            }, options));  
                this.hidden = true;  
                this.width = 0;  
                this.height = 0;  
            }else{  
                this.layout = 'form';  
                this.defaults = {  
                    labelSeparator : Steel.LABELSEPARATOR,  
                    labelStyle : Steel.LABELSTYLE  
                };  
                this.margins = Steel.LABELMARGINS;  
                  
                //标签宽度  
                if (this.fieldLabel) {  
                      
                    //计算fieldLabel里面包含的西文字符数  
                    var ec = 0;  
                    for(var i = 0, l = this.fieldLabel.length; i < l; ++i){  
                        if(/[a-zA-Z0-9]/.test(this.fieldLabel.substring(i,i+1))){  
                            ec++;  
                        }  
                    }  
                    this.labelWidth = this.labelWidth  
                            || eval('Math.ceil((this.fieldLabel.length + 1) * ' + Steel.LABLEFACTOR + ')') - ec*5;  
                      
                      
                    this.width = this.labelWidth + (this.inputWidth || Steel.DEFAULTFIELDWIDTH);  
                }else{  
                    this.labelWidth = 0;  
                    this.width = this.inputWidth || Steel.DEFAULTFIELDWIDTH;  
                }  
                  
                this.field = Ext.create(Ext.applyIf({  
                                xtype : fieldType,  
                                width : this.inputWidth || Steel.DEFAULTFIELDWIDTH  
                            }, options));  
            }  
      
            this.items = [this.field];  
              
            //灰掉只读项  
            if(this.readOnly)  
                this.setDisabled(true);  
              
              
            //获得相应控件的属性方法 Field 和 XXXField 的特有属性  
            Ext.applyIf(this,this.field.prototype);  
      
            Ext.SteelField.superclass.constructor.call(this);  
        },  
        getText : function() {  
            return this.field.fieldLabel;  
        },  
        setText : function(t){  
            this.fieldLabel = t;  
            this.doLayout();  
        }  
    });  
      
    Ext.reg('steelfield', Ext.SteelField);  