Ext.require([
    'Ext.tree.*',
    'Ext.data.*',
    'Ext.window.MessageBox'
]);

Ext.onReady(function() {
	

    var store = Ext.create('Ext.data.TreeStore', {
        proxy: {
            type: 'ajax',
            url: ctx + '/check-nodes.json'
        },
        sorters: [{
            property: 'leaf',
            direction: 'ASC'
        }, {
            property: 'text',
            direction: 'ASC'
        }]
    });
    
    
    
Ext.create('Ext.tree.Panel',{
    title: 'Tree test',
    renderTo: 'tree-div',
    autoScroll:true,  
    minWidth: 135,
    maxWidth: 200,
    treemodel: 'cascade',
    frame: true,

    store : Ext.create('Ext.data.TreeStore', {
    	model: 'ctreemodel',
		root : {
        	text: 'Tree Node',
            checked: false,
			expanded : true,
			children : [ {
				text : "detention",
				checked: false,
				aa:'bb',
				leaf : true
			}, {
				text : "homework",
				checked: false,
				expanded : true,
				children : [ {
					text : "book report",
					checked: false,
					leaf : true
				}, {
					text : "alegrbra",
					checked: false,
					leaf : true
				} ]
			}, {
				text : "buy lottery tickets",
				leaf : true
			} ]
		}
    })
});
    
    
    
    
    
    });

    

//    var tree = Ext.create('Ext.tree.Panel', {
//    	 root:Ext.create('Ext.tree.AsyncTreeNode', { id:'0' }),
//        store: store,
//        rootVisible: false,
//        useArrows: true,
//        frame: true,
//        title: 'Check Tree',
//        renderTo: 'tree-div',
//        width: 200,
//        height: 250,
//        dockedItems: [{
//            xtype: 'toolbar',
//            items: {
//                text: 'Get checked nodes',
//                handler: function(){
//                    var records = tree.getView().getChecked(),
//                        names = [];
//                    
//                    Ext.Array.each(records, function(rec){
//                        names.push(rec.get('text'));
//                    });
//                    
//                    Ext.MessageBox.show({
//                        title: 'Selected Nodes',
//                        msg: names.join('<br />'),
//                        icon: Ext.MessageBox.INFO
//                    });
//                }
//            }
//        }]
//    });
//});
