   
   
   
   
    /** 
     *  
     *     �����ض����÷������£������ĺ�ComboBoxһ������ 
     *     ------------------------------------------ 
     *     �����Ҫ��grid����������ã���ʹ�� gridCfg ������ 
     *     url:     [����] ����Դurl 
     *     columns��[����] grid��cm 
     *     displayField :   [����] ��ʾ��Ӧ���� Ĭ��Ϊ text 
     *     valueField :     [����] ֵ��Ӧ���� Ĭ��Ϊ value 
     *     paging�� [��ѡ] �Ƿ��ҳ Ĭ��false����ҳ 
     *     fields�� [��ѡ] store�������С�Ĭ���Ǹ���columns��dataIndex������˵� 
     *     ------------------------------------------ 
     * @class Ext.SteelComboGrid  
     *                              ������Ext.SteelGridPanel �� Ext.SteelGridSearchField 
     * @extends Ext.form.ComboBox  
     */  
     
//         {  
//        xtype:'steelfield'  
//        ,type:'combogrid'  
//        ,fieldLabel:'�����б�'  
//        ,name:'steelcombo1111'  
//        ,displayField : 'functionName'  
//    ,valueField : 'functionId'  
//    //������Ǳ����-��Ҫ�õ�Ӱ����ʱ�����Ե�������  
//        ,fields:[  
//            'functionId', 'functionName', 'parent', 'type', 'sort', 'status'  
//        ]  
//        ,columns:[  
//         {dataIndex:'functionId',   header:'ID'     ,sortable:true }  
//        ,{dataIndex:'functionName', header:'��������',sortable:true }    
//        ,{dataIndex:'parent',       header:'���ڵ�'    ,sortable:true }  
//        ,{dataIndex:'type',         header:'����' ,sortable:true}  
//        ,{dataIndex:'status',       header:'״̬' ,sortable:true }  
//        ,{dataIndex:'sort',         header:'����' ,sortable:true}  
//    ]  
//    ,paging:true  
//    ,url:'Function/list'  
//    },  
     
     
     
     
     
    Ext.SteelComboGrid = Ext.extend(Ext.form.ComboBox, {  
        store : new Ext.data.SimpleStore({  
                    fields : [],  
                    data : [[]]  
                }),  
        editable : this.editable||false,  
        mode : 'local',  
        emptyText : this.emptyText||"��ѡ��",  
        allowBlank : this.allowBlank||true,  
        blankText : this.blankText||"��������!",  
        triggerAction : 'all',  
        anchor : '95%',  
        displayField : 'text',  
        valueField : 'value',  
        tpl : '',  
        selectedClass : '',  
          
        onSelect : Ext.emptyFn,  
          
        loadingText: Steel.LOADINGTEXT,  
          
        grid: null,  
        /** 
         * grid�����ò�������ѡ�� 
         * @type  
         */  
        gridCfg:{},  
          
        url: '',  
          
        //grid �� Store  
        store1:null,  
          
        paging:false,  
          
        fields: [],  
          
        columns: [],  
          
        initComponent : function() {  
            Ext.SteelComboGrid.superclass.initComponent.call(this);  
            var me = this;  

                  	
            this.tpl = "<tpl for='.'><div id='steel-"+this.getId()+"'></div></tpl>";  
              
            //���û�ж���fields ����columns��ʼ��  
            if(0==this.fields.length && this.columns){  
                if(0==this.columns.length)console.log("��Ϊ"+this.getName()+"����columns����");  
                Ext.each(this.columns,function(c){  
                    me.fields.push(c.dataIndex);      
                });  
            }  
            this.store1 = new Ext.data.JsonStore({  
                url:this.url,  
                root:Steel.JSONSTORE_ROOT,  
                totalProperty:Steel.JSONSTORE_TOTALPROPERTY,  
                fields:this.fields  
            });  
              
            this.listWidth = 500;  
              
            this.maxHeight = 300;  
              
    /*      this.grid = new Ext.grid.GridPanel({ 
                    border: false, 
                    ds : this.store1, 
                    columns : this.columns, 
                    sm : new Ext.grid.RowSelectionModel({ 
                                singleSelect : true 
                            }), 
                    title : '', 
                    height : 300, 
                    bbar : this.paging ? 
                            new Ext.PagingToolbar({ 
                                pageSize : Steel.PAGESIZE, 
                                store : this.store1, 
                                displayInfo : true 
                            }) 
                            :null 
                });*/  
                  
            this.grid = new Ext.SteelGridPanel(Ext.apply({  
                title: ''  
                ,border: false  
                ,height : 300  
                ,paging: this.paging  
                ,searchField:'local'  
                ,store: this.store1  
                ,colModel:new Ext.grid.ColumnModel(this.columns)  
            },this.gridCfg));  
              
            this.grid.on('rowclick', function(grid, rowIndex, e) {  
                var r = me.store1.getAt(rowIndex);  
                if(me.fireEvent('beforeselect', me, r, rowIndex) !== false){  
                    me.setValue(r.data[me.valueField || me.displayField]);  
                    me.collapse();  
                    me.fireEvent('select', me, r, rowIndex);  
                }  
            });  
              
            this.on('expand', function() {  
                me.grid.render('steel-'+me.getId());  
                if(me.store1.getCount() == 0){  
                    me.grid.doLoad();  
                }  
            });  
              
            this.onViewClick = function(doFocus){};  
                     
    /*      this.itemSelector = 'tr.item'; 
            var t ='<table border=0 class="">'+ 
                    '<tpl for=".">'+ 
                        '<tr class="item">'; 
                            Ext.each(this.fields, function(f){ 
                              t += '<td>{'+(f.name ? f.name : f)+'}</td>'; 
                            }); 
                   t += '</tr>' + 
                    '</tpl>'+ 
                   '</table>'; 
            this.tpl = new Ext.XTemplate(t);*/  
        }  
        ,getStore : function(){  
            return this.store1;  
        }  
        ,getGrid : function(){  
            return this.grid;  
        }  
        ,setValue : function(v){  
            var text = v;  
            if(this.valueField){  
                var r = this.findRecord(this.valueField, v);  
                if(r){  
                    text = r.data[this.displayField];  
                }else if(Ext.isDefined(this.valueNotFoundText)){  
                    text = this.valueNotFoundText;  
                }  
            }  
            this.lastSelectionText = text;  
            if(this.hiddenField){  
                this.hiddenField.value = Ext.value(v, '');  
            }  
            Ext.form.ComboBox.superclass.setValue.call(this, text);  
            this.value = v;  
            return this;  
        }  
        ,findRecord : function(prop, value){  
            var record;  
            if(this.store1.getCount() > 0){  
                this.store1.each(function(r){  
                    if(r.data[prop] == value){  
                        record = r;  
                        return false;  
                    }  
                });  
            }  
            return record;  
        }  
    });  
      
    Ext.reg('steelcombogird', Ext.SteelComboGrid);  