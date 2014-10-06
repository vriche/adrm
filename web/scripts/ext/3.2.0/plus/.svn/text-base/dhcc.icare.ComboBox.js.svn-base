    /**------------------------------------------------------------ 
     *@Copyright (c) 2011 DHC Software Co.,Ltd. ALL RIGHTS RESERVED 
     *@ComponentName dhcc.icare.ComboBox   
     *@extendFrom Ext.form.ComboBox 
     *@xType icombobox 
     *@forModel MComboBox 
     *@Author  wanghc 
     *@Date 2011-03-28 
     *@Resume 重写Ext.form.ComboBox 
     *------------------------------------------------------------*/  
       
     /**----------------------------------------------------------  
     *@class   dhcc.icare.ComboBox 
     *@extends Ext.form.ComboBox 
     *@constructor wanghc 
     *@xtype icombobox 
     *@param {Object} config The config object  
      
     *@cfg {String} displayFields  
     *@cfg {boolean} queryInFields 
     *@cfg {String} queryFields 
     *------------------------------------------------------------*/  

//var cbArr = [['4',"张麻子",'man'], ['6',"汤师爷",'man'], ['8',"黄四郎",'man'],['12',"夫人",'woman'], ['33',"小六子",'man']] ;  
//var cbJson = [{id:'4',name:'张麻子',sex:'man'},{id:'6',name:'汤师爷',sex:'man'},{id:'12',name:'夫人',sex:'woman'}];  
//  
//var customDataCB = new dhcc.icare.ComboBox({  
//    fieldLabel:'自定义数据',  
//    minChars:0,  
//    width : 245,          
//    triggerAction : 'all',        
//      
//    customData :  cbArr,    //cbJson ,  
//    displayFields : [0,1,2],  
//    queryInFields : true,  
//    queryFields : [0,1,"field2"]                  
//}); 

    Ext.ns("dhcc","dhcc.icare");  
    dhcc.icare.ComboBox = Ext.extend(Ext.form.ComboBox, {     
        /** 
        *@desc 通过displayFields属性确定生成多列的combobox 
        *通过customData属性生成store 
        *生成queryFields属性值 
        */  
        initComponent : function(){  
            dhcc.icare.ComboBox.superclass.initComponent(this);           
                      
        },    
        onRender : function(ct,position){     
            dhcc.icare.ComboBox.superclass.onRender.call(this,ct,position);       
            if(this.customData){     // 自动生成store  
                var cd = this.customData ;  
                this.mode = 'local' ;   
                var cdField = [] ;    
                if(Ext.isArray(cd)){  
                    if(Ext.isArray(cd[0])){ //[[],[]] 二维数组                
                        this.valueField = this.valueField || 'field0' ;  
                        for (var i = 0,len = cd[0].length ; i<len; i++){  
                            cdField.push('field'+i) ;  
                        }     
                        this.store = new Ext.data.ArrayStore({ fields: cdField, data: cd});  
                    }else if(Ext.isObject(cd[0])){ //[{},{}] json数组                           
                        for (var i  in cd[0] ){               
                            cdField.push(i) ;  
                        }     
                        this.store = new Ext.data.JsonStore({ fields: cdField, data: cd});  
                    }  
                    this.displayField = this.displayField || (cdField.length>1? cdField[1]:cdField[0]) ;  
                }  
            }  
            if((this.queryInFields===true)&&(this.mode=='local')){  //默认在全部列中查询  
                if(this.queryFields.length==0){  
                    this.store.fields.each(function(f){this.queryFields.push(f.name);},this);  
                }  
            }  
        },  
        initList : function(){  
            if((!this.tpl)&&(this.displayFields)){  // 展示多列  
                var tplString = "" ;  
                var cls = 'x-combo-list';   
                var cbW = this.width || 150 ;         
                var dfLen = this.displayFields.length ;  
                var w = (cbW/dfLen).toFixed(2) ;              
                var f = this.store.fields ;  
                Ext.each(this.displayFields , function(name){  
                    name = f.containsKey(name) ? name : f.keys[name] ;  //列名或列号  
                    tplString += '<td width='+w+'>{'+name+'}</td>' ;  
                },this);                      
                this.tpl = new Ext.XTemplate(  
                    '<table><tpl for="."><tr class="'+cls+'-item" height="20px" >',  
                        tplString,  
                    '</tr></tpl></table>'  
                );  
            }  
            dhcc.icare.ComboBox.superclass.initList.call(this);  
        },  
          
        /** 
         * @param {String} query  查询参数的值q   
         * @param {Boolean} forceAll  如果forceAll为true 显示全部记录,为false时则通过query参数查询 
         */  
        doQuery : function(q,forceAll){  
            dhcc.icare.ComboBox.superclass.doQuery.call(this,q,forceAll);         
            q = Ext.isEmpty(q) ? '' : q;  
            if(!forceAll && (q.length >= this.minChars)){  
                if((this.queryInFields===true)&&(this.mode=='local')){                
                    var len = this.queryFields.length ;  
                    this.selectedIndex = -1;  
                    var f = this.store.fields ;  
                    this.store.filterBy(function(r,id){  
                        for(var i=0 ; i<len ; i++){  
                            var name = this.queryFields[i] ;  
                            name = f.containsKey(name) ? name : f.keys[name] ;                
                            if(RegExp("^"+q).test(r.get(name))){return true;}  
                        }  
                        return false ;   
                    },this);  
                    this.onLoad();  
                };  
            }  
        },  
        /** 
        *@param String/Json       增加对json的支持 
        */  
        setValue : function(obj){         
            if(Ext.isString(obj)){  
                dhcc.icare.ComboBox.superclass.setValue.call(this,obj);   
            }else if(Ext.isObject(obj)){          
                this.setValue(obj[this.valueField || this.displayField]);  
            }  
        },  
        /** 
        *@param Ext.data.Record 把record作为combobox的选中值  
        */  
        setRecordValue : function(r){                 
            this.setValue(r.data[this.valueField || this.displayField]);  
            this.recordValue = r ;  
            return this;  
        },  
        /** 
        *@return Ext.data.Record 拿到combobox当前选中的记录 
        */  
        getRecordValue : function(){          
            return this.recordValue  ;  
        },  
        /** 
        *@desc overwrite 
        */  
        select : function(index, scrollIntoView){  
            dhcc.icare.ComboBox.superclass.select.call(this,index, scrollIntoView);   
            if(this.selectedIndex == -1) {  
                this.recordValue = '' ;  
            }else{  
                this.recordValue = this.store.getAt(this.selectedIndex) ;  
            }  
        },  
        /** 
        *调用store的load方法 
        */  
        load : function(options){  
            this.store.load(options) ;  
        },  
        /** 
        *调用store的loadData方法 
        */  
        loadData : function(data,append){  
            this.store.loadData(data,append) ;  
        },  
        /** 
        *@desc 显示多列时用到 
        *@property displayFields Array  field的列名或列号(丛0开始)组成的数组 如: [0,name,age,3] 
        */  
        displayFields : '' ,  
        /** 
        *@property queryInFields boolean   
        *@desc true时 在多字段中查询(doQuery).false则在displayField中查询, 数据是本地时才有效 
        */  
        queryInFields : false ,  
        /** 
        *@property queryFields Array  
        *@desc 多列查询的字段名,在queryInFields为true下，默认在全部列中查询,数据是本地时才有效 如: [0,name,age,3] 
        */  
        queryFields : [],  
        /** 
        *@property recordValue Ext.data.Recode 
        */  
        recordValue : '' ,  
        /** 
        *@property customData Array[Array]/Array[json] 
        *@desc 如果参数是二维数组则自动生成store,store的fields是field0.field1..., data则是二维数组, valueField:'field0', displayField:'field1'||'field0'   
        */  
        customData : []  
    });  
    Ext.reg('icombobox', dhcc.icare.ComboBox);  