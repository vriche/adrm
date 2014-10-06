/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
QueryWindow = Ext.extend(Ext.Window, {
    title:'查询条件',
    width:400,
    height:450,
//    modal:true,
    closeAction:'hide',
    params:{},
//    orgId:1,
//    searchTarg:[],
//    searchFunction:function(){},
    
    initComponent:function(){
        Ext.apply(this, {
            buttons:[{
                text:'确定',
                handler:this.onOk.createDelegate(this)
            },
            {
                text:'重置',
                handler:this.reset.createDelegate(this)
            },{
                text:'取消',
                handler:this.onCancel.createDelegate(this)
            }]
        });
        
        QueryWindow.superclass.initComponent.call(this);

        var myContainer = new Ext.MyContainer({owner:this}); 
        
        this.add(myContainer);
        
        this.owner = this;
    },
    

    onOk:function(){
        if(this.params.searchFunction) this.params.searchFunction();
        this.hide();
    },
    reset:function(){
//        this.fromPannel.form.reset();
        this.tree.root.reload(); 
   
    },
    onCancel:function(){
        this.hide();
    }

 
});




Ext.MyContainer=Ext.extend(Ext.Panel ,{
	xtype:"panel",
//	title:"11111",
	width:400,
	height:450,
	initComponent: function(){

		var searchTarg  = this.owner.params.searchTarg;
		this.treePannel = this.createTreePannel();
		this.detailPannel = this.createDetailPannel();
		this.items=[this.treePannel];
		
		Ext.MyContainer.superclass.initComponent.call(this);
	},
	
	createTreePannel:function(owner){
		
	   var checkBox = true
	   var baseAttrs ={};
//	   if(checkBox){baseAttrs ={uiProvider: Ext.tree.TreeCheckNodeUI};}

       
	   var treeload = new Ext.tree.DWRTreeLoader({
			dwrMethod: SearchManager.getTreeForJosin,
			params: [{},this.owner.params],
			baseAttrs: baseAttrs //添加 uiProvider 属性  
		});
		
		
//		var root = new Ext.tree.AsyncTreeNode({
//		      text: '根节点',
//		      allowDrag:false,
//		      id: "0",
////		      uiProvider: Ext.tree.TreeCheckNodeUI,
//		      expanded:true
//		});
	 var root = new Ext.tree.AsyncTreeNode({id:'0',text:'根节点',expanded:true,searchTarg: this.owner.params.searchTarg});       		
//	 var customerRoot = new Ext.tree.AsyncTreeNode({id:'-1',text:'客户信息',iconCls:'x-tree-node-icon',checked:false,type:1,level:0, uiProvider: Ext.tree.TreeCheckNodeUI});  
//     var carrierRoot = new Ext.tree.AsyncTreeNode({id:'-2',text:'频道',iconCls:'ico-customer',checked:false,type:2,level:0, uiProvider: Ext.tree.TreeCheckNodeUI,});  	
     
//	 root.appendChild(customerRoot);  
//	 root.appendChild(carrierRoot);  		
	 
	 
	var tree = new Ext.tree.TreePanel({
//		 id:treeId,
	     border:true,
	     rootVisible:false,
	     autoScroll:true,
         height:380,
	     singleExpand:true,
	     lazyRender:true,
//	     width:width,
	     autoWidth:true,
	     loader: treeload, //使用第2步中创建树的加载器
	     checkModel: 'cascade',
	     root:root

	 });	 
	 
	 
	
//            var item1 = new Ext.Panel({
//                title: 'Accordion Item 1',
//                html: '&lt;empty panel&gt;',
//                 height:400,
//                cls:'empty'
//            });
//
//            var item2 = new Ext.Panel({
//                title: 'Accordion Item 2',
//                 height:400,
//                html: '&lt;empty panel&gt;',
//                cls:'empty'
//            });
	
	

		
		
		
//		   var panel1=new Ext.Panel(//Ext.formPanel就是Panel中用了form布局
//		      {
//		
////		       title:'容器组件',
//		       layout:'accordion',     
//		        layoutConfig:{columns:1},  
// 				height:380,
//
////                margins:'5 0 5 5',
////                split:true,
//                width: 390,
//		       layoutConfig:{animate:false},
//		       items:[tree,tree]
//		      }
//		     );	
//		     
		     
		     
		     

		     
		     this.owner.tree = tree;   
		     
		     return tree;
	},
	
	createDetailPannel:function(){
		
		
		
		
		   var MyForm=new Ext.form.FormPanel(//Ext.formPanel就是Panel中用了form布局
                {
				title:"222222222",
				labelWidth:100,
				labelAlign:"left",
				 height:50,
				layout:"form"

			});

		     
		      return MyForm;
	},	
	
	
})
