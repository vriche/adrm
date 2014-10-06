/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
QueryWindow = Ext.extend(Ext.Window, {
    title:'��ѯ����',
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
                text:'ȷ��',
                handler:this.onOk.createDelegate(this)
            },
            {
                text:'����',
                handler:this.reset.createDelegate(this)
            },{
                text:'ȡ��',
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
			baseAttrs: baseAttrs //��� uiProvider ����  
		});
		
		
//		var root = new Ext.tree.AsyncTreeNode({
//		      text: '���ڵ�',
//		      allowDrag:false,
//		      id: "0",
////		      uiProvider: Ext.tree.TreeCheckNodeUI,
//		      expanded:true
//		});
	 var root = new Ext.tree.AsyncTreeNode({id:'0',text:'���ڵ�',expanded:true,searchTarg: this.owner.params.searchTarg});       		
//	 var customerRoot = new Ext.tree.AsyncTreeNode({id:'-1',text:'�ͻ���Ϣ',iconCls:'x-tree-node-icon',checked:false,type:1,level:0, uiProvider: Ext.tree.TreeCheckNodeUI});  
//     var carrierRoot = new Ext.tree.AsyncTreeNode({id:'-2',text:'Ƶ��',iconCls:'ico-customer',checked:false,type:2,level:0, uiProvider: Ext.tree.TreeCheckNodeUI,});  	
     
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
	     loader: treeload, //ʹ�õ�2���д������ļ�����
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
	
	

		
		
		
//		   var panel1=new Ext.Panel(//Ext.formPanel����Panel������form����
//		      {
//		
////		       title:'�������',
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
		
		
		
		
		   var MyForm=new Ext.form.FormPanel(//Ext.formPanel����Panel������form����
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
