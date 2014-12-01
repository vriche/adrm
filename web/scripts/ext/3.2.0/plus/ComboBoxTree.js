ComboBoxTree = Ext.extend(Ext.form.ClearableComboBox, {  

    /**
     * -------------------------------------  
     * 作为隐藏域的name属�??
     * -------------------------------------
     */
    passName : 'id',  

    /**
     * -------------------------------------  
     * 是否允许非叶子结点的单击事件
     *  
     * @default false  
     * -------------------------------------
     */
    allowUnLeafClick : true,  

    /**
     * ---------------------  
     * 树渲染的模板tpl  
     * ---------------------
     */
    // tpl: '<div id="treeTpl"></div>', //html代码  
    /**
     * -----------------------
     * 树显示的高度，默认为180
     * -----------------------
     */
    treeHeight : 180,  

    treeWidth : 180, 
    
    store : new Ext.data.SimpleStore({  
        fields : [],  
        data : [[]]  
    }),  
      
    //Default  
    editable : false, // 禁止手写及联想功�???  
    mode : 'local',  
    triggerAction : 'all',  
    maxHeight : 500,  
    selectedClass : '',  
    onSelect : Ext.emptyFn,  
    canCollapse: true,
    emptyText : '请选择...',  

    /**
     * 清空�???
     */
    clearValue : function() {  
        if (this.passField) {  
            this.passField.value = '';  
        }  

        this.setRawValue('');  
            },  
      
    /**
     * 设置传�??
     * @param passvalue
     */
    setPassValue: function(passvalue){  
        if (this.passField)  
            this.passField.value = passvalue;  
    },  

    /**
     * --------------------------------------  
     * 下拉树被点击事件添加�???处理方法
     * @param node
     * --------------------------------------
     */
    onTreeSelected : function(node) {  

    }, 
    
    
// resizeToFitContent: function(){
//		 if (!this.elMetrics){
//		            this.elMetrics = Ext.util.TextMetrics.createInstance(this.getEl());
//		 }
//		 var m = this.elMetrics, width = 0, el = this.el, s = this.getSize();
//		 this.store.each(function (r) {
//		            var text = r.get(this.displayField);
//		            width = Math.max(width, m.getWidth(text));
//		        }, this);
//		 if (el) {
//		            width += el.getBorderWidth('lr');
//		            width += el.getPadding('lr');
//		        }
//		 if (this.trigger) {
//		            width += this.trigger.getWidth();
//		 }
//		 s.width = width;
//		 this.setSize(s);
//		 this.store.on({
//		            'datachange': this.resizeToFitContent,
//		            'add': this.resizeToFitContent,
//		            'remove': this.resizeToFitContent,
//		            'load': this.resizeToFitContent,
//		            'update': this.resizeToFitContent,
//		            buffer: 10,
//		            scope: this
//		 });
//    },
    
    
    
	 resizeToFitContent: function(){
		 if (!this.elMetrics){
		            this.elMetrics = Ext.util.TextMetrics.createInstance(this.getEl());
		 }
		 var m = this.elMetrics, width = 0, el = this.el, s = this.getSize();
		 this.store.each(function (r) {
		            var text = r.get(this.displayField);
		            width = Math.max(width, m.getWidth(text));
		        }, this);
		 if (el) {
		            width += el.getBorderWidth('lr');
		            width += el.getPadding('lr');
		        }
		 if (this.trigger) {
		            width += this.trigger.getWidth();
		 }
		 s.width = width;
		 this.setSize(s);
		 this.store.on({
		            'datachange': this.resizeToFitContent,
		            'add': this.resizeToFitContent,
		            'remove': this.resizeToFitContent,
		            'load': this.resizeToFitContent,
		            'update': this.resizeToFitContent,
		            buffer: 10,
		            scope: this
		 });
    }, 
     

    /**
     * ----------------------------------  
     * 树的单击事件处理
     * @param node,event
     * ----------------------------------
     */
    treeClk : function(node, e) {  
        if (!node.isLeaf() && !this.allowUnLeafClick) {  
            e.stopEvent();// 非叶子节点则不触�???  
            return;  
        }  
        
                    
                    	
        this.setValue(node.text);// 设置option�???  
        this.value = node.id;
        this.collapse();// 隐藏option列表  

        if (this.passField)  
            this.passField.value = node.id;// 以树的节点ID传�??  

        // 选中树节点后的触发事�???  
        this.fireEvent('treeselected', node);  

    },  


//    //新增 隐藏下拉
//    collapsed:function(){
//      this.collapse();
//    },
    /**
     * 初始�???
     * Init
     */
    initComponent : function() {  
        ComboBoxTree.superclass.initComponent.call(this);  
        this.tree.autoScroll = true;  
        this.tree.height = this.treeHeight;  

        this.tree.containerScroll = false;  
        this.tplId = Ext.id();  
        // overflow:auto"  
//        this.tpl = '<div id="' + this.tplId + '" style="' + this.treeHeight  + ';overflow:hidden;"></div>';  
        this.tpl = String.format('<tpl for="."><div style="height:200px"><div id="ext-combobox-tree{0}"></div></div></tpl>', this.tplId);
//        this.tpl = '<div id="' + this.tplId + '" style="' + this.treeHeight  + ';overflow:hidden;"><div id="ext-combobox-tree{0}"></div></div>';  
        
        /**
         * -----------------------  
         * 添加treeselected事件�???
         * 选中树节点会�???发这个事
         * 件， 参数为树的节�???
         * ------------------------
         */
        this.addEvents('treeselected');  
        
        
        // this.on('treeselected',this.onTreeSelected,this);  
    }, 
    


    /**
     * ------------------
     * 事件监听�???  
     * Listener
     * ------------------
     */
    listeners : {
        'expand' : {  
            fn : function() {  

                if (!this.tree.rendered && this.tplId) {  
                        if(this.treeWidth>0){
		                	this.list.setWidth(this.treeWidth);
		                	this.innerList.setWidth(this.treeWidth);
                        }
//                    this.tree.render(this.tplId);  
                   
				
                    this.tree.render('ext-combobox-tree' + this.tplId);
                }  
                this.tree.root.reload();//每次下拉菜单出现的时候都重刷新树
                this.tree.show();  
            },  
            single : true //true 我感觉是执行�???次，我改成了false  
        },  

        'render' : {  
            fn : function() {  

                this.tree.on('click', this.treeClk, this);  
                
//                this.tree.on('render', this.resizeToFitContent, this);
                

                /**
                 * -------------------------------------------  
                 * 创建隐藏输入�???<input />
                 * 并将其dom传给passField  
                 * ------------------------------------------
                 */
                if (this.passName) {  
                    this.passField = this.getEl().insertSibling({  
                        tag : 'input',  
                        type : 'hidden',  
                        name : this.passName,  
                        id : this.passId || Ext.id()  
                    }, 'before', true)  
                }  

                this.passField.value = this.passValue !== undefined  
                        ? this.passValue  
                        : (this.value !== undefined ? this.value : '');  

                this.el.dom.removeAttribute('name');  
            }  
        },  
        'beforedestroy' : {  
            fn : function(cmp) {  
                this.purgeListeners();  
                this.tree.purgeListeners();  
            }  
        }  
    }  

});  
Ext.override(Ext.form.ComboBox, {  
      onViewClick : function(doFocus) {  
        var index = this.view.getSelectedIndexes()[0], s = this.store, r = s.getAt(index);  
        if (r) {  
          this.onSelect(r, index);  
        } else if (s.getCount() === 0) {  
          this.collapse();  
        }  
        if (doFocus !== false) {  
          this.el.focus();  
        }  
      }  
    });  
/**
* ---------------------------------  
* 将ComboBoxTree注册为Ext的组�???,以便使用
* Ext的延迟渲染机制，xtype:'combotree'  
* ---------------------------------
*/
Ext.reg('combotree', ComboBoxTree);




Ext.override(Ext.form.ComboBox,{
        onLoad : function(){
        if(!this.hasFocus){
            return;
        }
                
        if(this.store.getCount() > 0){
                    if (this.autoListWidth){
                        if(!this.metrics){
                this.metrics = Ext.util.TextMetrics.createInstance(this.el);
                }
                        this.store.each(function(record){
                    var v = record.get(this.displayField) + " ";
                    var w = Math.min(this.growMax, Math.max(this.metrics.getWidth(v) + /* add extra padding */ 20, this.growMin));
                            if (w > this.innerList.getWidth()) {
                                this.innerList.setWidth(w);
                                this.list.setWidth(w);
                            }
                        },this)
                    }
            this.expand();
            this.restrictHeight();
            if(this.lastQuery == this.allQuery){
                if(this.editable){
                    this.el.dom.select();
                }
                if(!this.selectByValue(this.value, true)){
                    this.select(0, true);
                }
            }else{
                this.selectNext();
                if(this.typeAhead && this.lastKey != Ext.EventObject.BACKSPACE && this.lastKey != Ext.EventObject.DELETE){
                    this.taTask.delay(this.typeAheadDelay);
                }
            }
        }else{
            this.onEmptyResults();
        }
            }
});