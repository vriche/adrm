   
   
   
   
    /** 
     *  
     *     部分特定配置方法如下（其他的和ComboBox一样）： 
     *     ------------------------------------------ 
     *     如果需要对grid有特殊的配置，请使用 gridCfg 配置项 
     *     url:     [必须] 数据源url 
     *     columns：[必须] grid的cm 
     *     displayField :   [必须] 显示对应的列 默认为 text 
     *     valueField :     [必须] 值对应的列 默认为 value 
     *     paging： [可选] 是否分页 默认false不分页 
     *     fields： [可选] store的数据列、默认是根据columns的dataIndex构造出了的 
     *     ------------------------------------------ 
     * @class Ext.SteelComboGrid  
     *                              依赖：Ext.SteelGridPanel 、 Ext.SteelGridSearchField 
     * @extends Ext.form.ComboBox  
     */  
     
//         {  
//        xtype:'steelfield'  
//        ,type:'combogrid'  
//        ,fieldLabel:'下拉列表'  
//        ,name:'steelcombo1111'  
//        ,displayField : 'functionName'  
//    ,valueField : 'functionId'  
//    //这个不是必须的-当要用到影藏列时，可以单独定义  
//        ,fields:[  
//            'functionId', 'functionName', 'parent', 'type', 'sort', 'status'  
//        ]  
//        ,columns:[  
//         {dataIndex:'functionId',   header:'ID'     ,sortable:true }  
//        ,{dataIndex:'functionName', header:'功能名称',sortable:true }    
//        ,{dataIndex:'parent',       header:'父节点'    ,sortable:true }  
//        ,{dataIndex:'type',         header:'类型' ,sortable:true}  
//        ,{dataIndex:'status',       header:'状态' ,sortable:true }  
//        ,{dataIndex:'sort',         header:'排序' ,sortable:true}  
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
        emptyText : this.emptyText||"请选择",  
        allowBlank : this.allowBlank||true,  
        blankText : this.blankText||"必须输入!",  
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
         * grid的配置参数【可选】 
         * @type  
         */  
        gridCfg:{},  
          
        url: '',  
          
        //grid 的 Store  
        store1:null,  
          
        paging:false,  
          
        fields: [],  
          
        columns: [],  
          
        initComponent : function() {  
            Ext.SteelComboGrid.superclass.initComponent.call(this);  
            var me = this;  

                  	
            this.tpl = "<tpl for='.'><div id='steel-"+this.getId()+"'></div></tpl>";  
              
            //如果没有定义fields 按照columns初始化  
            if(0==this.fields.length && this.columns){  
                if(0==this.columns.length)console.log("请为"+this.getName()+"定义columns属性");  
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