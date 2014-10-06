    /**
     * 下拉表格ComboBoxGrid
     * @extend Ext.form.ComboBox
     *
     * @author MSN/Email:onebodysoftware@hotmail.com
     */
    ComboBoxGrid = function(cfg) {
        Ext.apply(this, cfg);
        ComboBoxGrid.superclass.constructor.call(this, {
            editable : false, // 禁止手写及联想功能
            mode : 'local',
            triggerAction : 'all',
            maxHeight : 500,
            selectedClass : '',
            onSelect : Ext.emptyFn,
            emptyText : '请选择...',
            gridWidth:600,
            gridHeight : 180,
            listAlign : 'tr-br',
            listWidth : 300,
            resizable : false,
            grid:new MainGrid({
                id:Ext.id(),
                height : this.gridHeight || 180,
                width :this.gridWidth || 600,
                cm:this.cm,
                sm:this.sm,
                store:this.store,
                detailActList:this.detailActList
            })
        });
    };
    Ext.extend(ComboBoxGrid, Ext.form.ComboBox, {
        gridClk : function(grid, rowIndex, e) {
            var record = grid.getStore().getAt(rowIndex);
            var idValue = record.get(this.valueField);
            var displayValue = record.get(this.hiddenName);
            this.setRawValue(idValue);
            this.setValue(displayValue);
            this.collapse();
            this.fireEvent('gridselected', grid.getRecord(rowIndex));
        },
        initLayout : function() {
            this.grid.autoScroll = true;
            this.grid.height = this.gridHeight;
            this.grid.containerScroll = false;
            this.grid.border = false;
            this.listWidth = this.grid.width + 3;
        },
        initComponent : function() {
            ComboBoxGrid.superclass.initComponent.call(this);
            this.initLayout();
            this.tplId = Ext.id();
            this.tpl = '<div id="' + this.tplId + '" style="height:' + (this.gridHeight || 180)
                    + '";overflow:hidden;"></div>';
            //Add Event
            this.addEvents('gridselected');
        },
        listeners : {
            'expand' : {
                fn : function() {
                    if (!this.grid.rendered && this.tplId) {
                        this.initLayout();
                        this.grid.render(this.tplId);
                        //                    this.store.reload();
                        if (this.store.getCount() == 0) {
                            this.store.add(new Ext.data.Record([{}]));
                        }
                        this.grid.on('rowclick', this.gridClk, this);
                    }
                    this.grid.show();
                }
            },
            'render' : {
                fn : function() {
                }
            },
            'beforedestroy' : {
                fn : function(cmp) {
                    this.purgeListeners();
                    this.grid.purgeListeners();
                }
            },
            'collapse' : {
                fn : function(cmp) {
                    /**
                     *  防止当store的记录为0时不出现下拉的状况
                     */
                    if (this.grid.store.getCount() == 0) {
                        this.store.add(new Ext.data.Record([{}]));
                    }
                }
            }
        }
    });
