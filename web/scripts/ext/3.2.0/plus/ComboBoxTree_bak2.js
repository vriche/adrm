/**
 * ComboBoxTree
 * @extend Ext.form.ComboBox
 * @xtype 'combotree'
 * 
 * @author 
 */

/**
 * ----------------------
 * Demo ComboBoxTree
 * ----------------------
 */
 /*-------------------------------------------------*
        treecombo = {
            xtype:'combotree',
            fieldLabel:'Function',
            name:'department_id',
            allowUnLeafClick:false,
            treeHeight:200,
            url:'/myoa/department/getTrees',
            onSelect:function(id){
            }
        }
*-----------------------------------------------------*/
Ext.ns('Ext.ux.form');
Ext.ux.form.ComboBoxTree = Ext.extend(Ext.form.ComboBox, {
    treeHeight : 180,
    allowUnLeafClick:false,
    url:'',
    setFieldValue:function(id,text){
        this.setValue(text);
        this.hiddenField.value = id;
    },
    onSelect:function(id){
        
    },

    store : new Ext.data.SimpleStore({
            fields : [],
            data : [[]]
    }),

    //Default
    editable : false, // ?????????¡ã????????
    mode : 'local',
    triggerAction : 'all',
    maxHeight : 500,
    selectedClass : '',
    onSelect : Ext.emptyFn,
    emptyText : 'please select...',

    /**
     * ??????
     * Init
     */
    initComponent : function() {
        Ext.ux.form.ComboBoxTree.superclass.initComponent.call(this);
        this.tplId = Ext.id();
//        this.tpl = '<div id="' + this.tplId + '" style="height:' + this.treeHeight + 'px;overflow:hidden;"></div>';
          this.tpl = String.format('<tpl for="."><div style="height:200px"><div id="ext-combobox-tree{0}"></div></div></tpl>', this.tplId);

//        var tree = this.tree;
        var combo = this;
//        this.tree.on('beforeload',function(node){
//            this.tree.loader.dataUrl = combo.url+'?parent_id='+node.id;
//        });
        this.tree.on('click',function(node){
            if (combo.allowUnLeafClick == true){
                combo.setValue(node.text);
                combo.hiddenField.value = node.id;
                combo.collapse();
                combo.onSelect(node.id);
            }
            else if (node.leaf == true){
                combo.setValue(node.text);
                combo.hiddenField.value = node.id;
                combo.collapse();
                combo.onSelect(node.id);
            }
        });
        
        
//        this.on('expand', this.expandHandler, this);
//       this.on('collapse', this.collapseHandler, this);
//        this.tree = tree;
    },

    /**
     * ------------------
     * ?????¨¤???¡Â 
     * Listener
     * ------------------
     */
     
        expandHandler: function expand() {
            this.canCollapse = true;
            if (this.tree) {
                this.tree.render('ext-combobox-tree' + this.treerenderid);
                this.canCollapse = true;          
                this.tree.getRootNode().expand();
                
            }
        },
        collapseHandler: function collapse() {
            if (!this.canCollapse) {
                this.expand();
            }
        },
    listeners : {
        'expand' : {
            fn: function() {
                if (!this.tree.rendered && this.tplId) {
                	  this.tree.render('ext-combobox-tree' + this.tplId);
//                    this.tree.render(this.tplId);
                    this.tree.root.expand();
                    this.tree.root.select();
                }
                
               
                this.tree.show();
            }
        },
        'render':{
            fn:function(){
                this.hiddenField = this.el.insertSibling({
                    tag:'input',
                    type:'hidden',
                    name:this.getName()
                },'before',true);
                this.el.dom.removeAttribute('name');
            }
        }
    }
});

/**
 * --------------------------------- 
 * ??ComboBoxTree¡Á??¨¢??Ext??¡Á¨¦??,??¡À?????
 * Ext???????????¨²????xtype:'combotree' 
 * ---------------------------------
 */
Ext.reg('combotree', Ext.ux.form.ComboBoxTree);
