    /**------------------------------------------------------------ 
     *@Copyright (c) 2011 DHC Software Co.,Ltd. ALL RIGHTS RESERVED 
     *@ComponentName dhcc.icare.ComboBox   
     *@extendFrom Ext.form.ComboBox 
     *@xType icombobox 
     *@forModel MComboBox 
     *@Author  wanghc 
     *@Date 2011-03-28 
     *@Resume ��дExt.form.ComboBox 
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

//var cbArr = [['4',"������",'man'], ['6',"��ʦү",'man'], ['8',"������",'man'],['12',"����",'woman'], ['33',"С����",'man']] ;  
//var cbJson = [{id:'4',name:'������',sex:'man'},{id:'6',name:'��ʦү',sex:'man'},{id:'12',name:'����',sex:'woman'}];  
//  
//var customDataCB = new dhcc.icare.ComboBox({  
//    fieldLabel:'�Զ�������',  
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
        *@desc ͨ��displayFields����ȷ�����ɶ��е�combobox 
        *ͨ��customData��������store 
        *����queryFields����ֵ 
        */  
        initComponent : function(){  
            dhcc.icare.ComboBox.superclass.initComponent(this);           
                      
        },    
        onRender : function(ct,position){     
            dhcc.icare.ComboBox.superclass.onRender.call(this,ct,position);       
            if(this.customData){     // �Զ�����store  
                var cd = this.customData ;  
                this.mode = 'local' ;   
                var cdField = [] ;    
                if(Ext.isArray(cd)){  
                    if(Ext.isArray(cd[0])){ //[[],[]] ��ά����                
                        this.valueField = this.valueField || 'field0' ;  
                        for (var i = 0,len = cd[0].length ; i<len; i++){  
                            cdField.push('field'+i) ;  
                        }     
                        this.store = new Ext.data.ArrayStore({ fields: cdField, data: cd});  
                    }else if(Ext.isObject(cd[0])){ //[{},{}] json����                           
                        for (var i  in cd[0] ){               
                            cdField.push(i) ;  
                        }     
                        this.store = new Ext.data.JsonStore({ fields: cdField, data: cd});  
                    }  
                    this.displayField = this.displayField || (cdField.length>1? cdField[1]:cdField[0]) ;  
                }  
            }  
            if((this.queryInFields===true)&&(this.mode=='local')){  //Ĭ����ȫ�����в�ѯ  
                if(this.queryFields.length==0){  
                    this.store.fields.each(function(f){this.queryFields.push(f.name);},this);  
                }  
            }  
        },  
        initList : function(){  
            if((!this.tpl)&&(this.displayFields)){  // չʾ����  
                var tplString = "" ;  
                var cls = 'x-combo-list';   
                var cbW = this.width || 150 ;         
                var dfLen = this.displayFields.length ;  
                var w = (cbW/dfLen).toFixed(2) ;              
                var f = this.store.fields ;  
                Ext.each(this.displayFields , function(name){  
                    name = f.containsKey(name) ? name : f.keys[name] ;  //�������к�  
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
         * @param {String} query  ��ѯ������ֵq   
         * @param {Boolean} forceAll  ���forceAllΪtrue ��ʾȫ����¼,Ϊfalseʱ��ͨ��query������ѯ 
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
        *@param String/Json       ���Ӷ�json��֧�� 
        */  
        setValue : function(obj){         
            if(Ext.isString(obj)){  
                dhcc.icare.ComboBox.superclass.setValue.call(this,obj);   
            }else if(Ext.isObject(obj)){          
                this.setValue(obj[this.valueField || this.displayField]);  
            }  
        },  
        /** 
        *@param Ext.data.Record ��record��Ϊcombobox��ѡ��ֵ  
        */  
        setRecordValue : function(r){                 
            this.setValue(r.data[this.valueField || this.displayField]);  
            this.recordValue = r ;  
            return this;  
        },  
        /** 
        *@return Ext.data.Record �õ�combobox��ǰѡ�еļ�¼ 
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
        *����store��load���� 
        */  
        load : function(options){  
            this.store.load(options) ;  
        },  
        /** 
        *����store��loadData���� 
        */  
        loadData : function(data,append){  
            this.store.loadData(data,append) ;  
        },  
        /** 
        *@desc ��ʾ����ʱ�õ� 
        *@property displayFields Array  field���������к�(��0��ʼ)��ɵ����� ��: [0,name,age,3] 
        */  
        displayFields : '' ,  
        /** 
        *@property queryInFields boolean   
        *@desc trueʱ �ڶ��ֶ��в�ѯ(doQuery).false����displayField�в�ѯ, �����Ǳ���ʱ����Ч 
        */  
        queryInFields : false ,  
        /** 
        *@property queryFields Array  
        *@desc ���в�ѯ���ֶ���,��queryInFieldsΪtrue�£�Ĭ����ȫ�����в�ѯ,�����Ǳ���ʱ����Ч ��: [0,name,age,3] 
        */  
        queryFields : [],  
        /** 
        *@property recordValue Ext.data.Recode 
        */  
        recordValue : '' ,  
        /** 
        *@property customData Array[Array]/Array[json] 
        *@desc ��������Ƕ�ά�������Զ�����store,store��fields��field0.field1..., data���Ƕ�ά����, valueField:'field0', displayField:'field1'||'field0'   
        */  
        customData : []  
    });  
    Ext.reg('icombobox', dhcc.icare.ComboBox);  