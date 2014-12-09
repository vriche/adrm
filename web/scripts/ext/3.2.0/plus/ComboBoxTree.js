ComboBoxTree = Ext.extend(Ext.form.ClearableComboBox, {  

    /**
     * -------------------------------------  
     * 浣滀负闅愯棌鍩熺殑name灞烇拷??
     * -------------------------------------
     */
    passName : 'id',  

    /**
     * -------------------------------------  
     * 鏄惁鍏佽闈炲彾瀛愮粨鐐圭殑鍗曞嚮浜嬩欢
     *  
     * @default false  
     * -------------------------------------
     */
    allowUnLeafClick : true,  

    /**
     * ---------------------  
     * 鏍戞覆鏌撶殑妯℃澘tpl  
     * ---------------------
     */
    // tpl: '<div id="treeTpl"></div>', //html浠ｇ爜  
    /**
     * -----------------------
     * 鏍戞樉绀虹殑楂樺害锛岄粯璁や负180
     * -----------------------
     */
    treeHeight : 180,  

    treeWidth : 180, 
    
    store : new Ext.data.SimpleStore({  
        fields : [],  
        data : [[]]  
    }),  
      
    //Default  
    editable : false, // 绂佹鎵嬪啓鍙婅仈鎯冲姛锟�??  
    mode : 'local',  
    triggerAction : 'all',  
    maxHeight : 500,  
    selectedClass : '',  
    onSelect : Ext.emptyFn,  
    canCollapse: true,
    emptyText : '...',  

    /**
     * 娓呯┖锟�??
     */
    clearValue : function() {  
        if (this.passField) {  
            this.passField.value = '';  
        }  

        this.setRawValue('');  
            },  
      
    /**
     * 璁剧疆浼狅拷??
     * @param passvalue
     */
    setPassValue: function(passvalue){  
        if (this.passField)  
            this.passField.value = passvalue;  
    },  

    /**
     * --------------------------------------  
     * 涓嬫媺鏍戣鐐瑰嚮浜嬩欢娣诲姞锟�??澶勭悊鏂规硶
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
     * 鏍戠殑鍗曞嚮浜嬩欢澶勭悊
     * @param node,event
     * ----------------------------------
     */
    treeClk : function(node, e) {  
        if (!node.isLeaf() && !this.allowUnLeafClick) {  
            e.stopEvent();// 闈炲彾瀛愯妭鐐瑰垯涓嶈Е锟�??  
            return;  
        }  
        
                    
                    	
        this.setValue(node.text);// 璁剧疆option锟�??  
        this.value = node.id;
        this.collapse();// 闅愯棌option鍒楄〃  

        if (this.passField)  
            this.passField.value = node.id;// 浠ユ爲鐨勮妭鐐笽D浼狅拷??  

        // 閫変腑鏍戣妭鐐瑰悗鐨勮Е鍙戜簨锟�??  
        this.fireEvent('treeselected', node);  

    },  


//    //鏂板 闅愯棌涓嬫媺
//    collapsed:function(){
//      this.collapse();
//    },
    /**
     * 鍒濆锟�??
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
         * 娣诲姞treeselected浜嬩欢锟�??
         * 閫変腑鏍戣妭鐐逛細锟�??鍙戣繖涓簨
         * 浠讹紝 鍙傛暟涓烘爲鐨勮妭锟�??
         * ------------------------
         */
        this.addEvents('treeselected');  
        
        
        // this.on('treeselected',this.onTreeSelected,this);  
    }, 
    


    /**
     * ------------------
     * 浜嬩欢鐩戝惉锟�??  
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
                this.tree.root.reload();//姣忔涓嬫媺鑿滃崟鍑虹幇鐨勬椂鍊欓兘閲嶅埛鏂版爲
                this.tree.show();  
            },  
            single : true //true 鎴戞劅瑙夋槸鎵ц锟�??娆★紝鎴戞敼鎴愪簡false  
        },  

        'render' : {  
            fn : function() {  

                this.tree.on('click', this.treeClk, this);  
                
//                this.tree.on('render', this.resizeToFitContent, this);
                

                /**
                 * -------------------------------------------  
                 * 鍒涘缓闅愯棌杈撳叆锟�??<input />
                 * 骞跺皢鍏禿om浼犵粰passField  
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
* 灏咰omboBoxTree娉ㄥ唽涓篍xt鐨勭粍锟�??,浠ヤ究浣跨敤
* Ext鐨勫欢杩熸覆鏌撴満鍒讹紝xtype:'combotree'  
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