/**
 * 给树添加级联选中功能，为树设置属性enableAllCheck则为所有节点添加checkbox；
 * @author chemzqm@gmail.com
 * @version 1.0 (5/4/2010)
 */
Ext.TreeNodeCascade = function(){

    function cascadeParent(){	
        var pn = this.parentNode;	
        if (!pn || !Ext.isBoolean(this.attributes.checked)) 
            return;
        if (this.attributes.checked) {//级联选中
            pn.getUI().toggleCheck(true);
        }
        else {//级联未选中
            var b = true;
            Ext.each(pn.childNodes, function(n){
                if (n.getUI().isChecked()) 
                    return b = false;
            });
            if (b) 
                pn.getUI().toggleCheck(false);
        }
        pn.cascadeParent();
    }
    
    function cascadeChildren(){
        var ch = this.attributes.checked;
        if (!Ext.isBoolean(ch)) 
            return;
        Ext.each(this.childNodes, function(n){
            n.getUI().toggleCheck(ch);
            n.cascadeChildren();
        });
    }
    
    /**
     * 全选或全不选所有结点，必须所有结点都有checked属性
     * @param {Object} checked
     */
    function checkAllNodes(checked){
        this.root.attributes.checked = checked;
        this.root.cascadeChildren();
    }
    
    /**
     * 清空选中，根据nodes数组加载选中节点
     * @param {Object} nodes node或id数组
     */
    function loadCheckedNodes(nodes){
        this.checkAllNodes(false);
        Ext.each(nodes, function(n){
            if (Ext.isString(n)) {
                n = this.getNodeById(n);
            }
            n.getUI().toggleCheck(true);
        }, this);
    }
    /**
     * tree的属性enableAllCheck为true时，所有节点默认渲染未选中的checkbox
     */
    Ext.apply(Ext.tree.TreePanel.prototype, {
        checkAllNodes: checkAllNodes,
        loadCheckedNodes: loadCheckedNodes,
        initComponent: Ext.tree.TreePanel.prototype.initComponent.createInterceptor(function(){
            if (this.enableAllCheck) {
                var loader = this.loader;
                if (!Ext.isDefined(loader.baseAttrs)) {
					loader.baseAttrs = {};
				}
                loader.baseAttrs['checked'] = false;
            }
        })
    });
    /**
     * 为TreeNode对象添加级联父节点和子节点的方法
     */
    Ext.apply(Ext.tree.TreeNode.prototype, {
        cascadeParent: cascadeParent,
        cascadeChildren: cascadeChildren
    });
	/**
	 * 结点加载后级联子节点
	 */
    Ext.override(Ext.tree.AsyncTreeNode, {
        loadComplete: Ext.tree.AsyncTreeNode.prototype.loadComplete.createSequence(function(e, node){
            this.cascadeChildren();
        })
    });
	/**
	 * Checkbox被点击后级联父节点和子节点
	 */
    Ext.override(Ext.tree.TreeEventModel, {
        onCheckboxClick: Ext.tree.TreeEventModel.prototype.onCheckboxClick.createSequence(function(e, node){
            node.cascadeParent();
            node.cascadeChildren();
        })
    });
}();


