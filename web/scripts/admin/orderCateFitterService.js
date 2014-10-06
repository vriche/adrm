





Ext.onReady( function() {
	
alert('订单类型过滤')

var orderCategory = new OrderCategory();	
var incomePurpose = new IncomePurpose();	
var tag_order_cate_fitter =  _app_params.rights.tag_order_cate_fitter;
var curYear = _app_params.serviceDate.year;
var utils = new MyUtils( _app_params.sysParam.serviceDate);
var ctxPath = _app_params.ctxPath;	
if(!tag_order_cate_fitter){
	 window.location = ctxPath +"404.jsp";
}



//function getLovCombo(){
//   incomePurpose.obj.version = Ext.getCmp('year').getValue();	
//   return incomePurpose.getLovCombo('incomePurposeComand',true);
//}

function getCheck(){
	
   var yyyy = Ext.getCmp('year').getValue();	

		OrderCateFitterUtil.getFitterIds1(yyyy,0,callBak);

		function callBak(s){
			var ck = s == "1"||s == "true"||s == true?true:false;
		    Ext.getCmp('MyCheckbox').setValue(ck);
		}

}


function getTree1(){
   var yyyy = Ext.getCmp('year').getValue();	
   orderCategory.obj.version = yyyy;
   var orgId = 1;
   params = {orgId:orgId,version:yyyy};
   
   orderCategory.loadData = function(node){
   	
		var tree = Ext.getCmp('tree1');
		var yyyy = Ext.getCmp('year').getValue();	

		
		OrderCateFitterUtil.getFitterIds1(yyyy,1,callBak);
		
		
		function callBak(ids){

			var ids1 = ids.split(',');

			var chs = node.childNodes;
			for(var i = 0 ;i<chs.length;i++){
				var id = chs[i].id;

				if(ids1.contains(id)){
					 chs[i].getUI().checkbox.checked = true;
					 chs[i].attributes.checked = true;
				}
			}
		}
  	  
   }
   return orderCategory.getTree('tree1',params,true);
}

function getTree2(){
   var yyyy = Ext.getCmp('year').getValue();	
   incomePurpose.obj.version = yyyy;
   params = {version:yyyy};
   
   incomePurpose.loadData = function(node){
   	
		var tree = Ext.getCmp('tree2');
		var yyyy = Ext.getCmp('year').getValue();	
//        node = tree.getRootNode();
		OrderCateFitterUtil.getFitterIds1(yyyy,2,callBak);

		function callBak(ids){
		
			var ids1 = ids.split(',');
			var chs = tree.getRootNode().childNodes;
			
			for(var i = 0 ;i<chs.length;i++){
				var id = chs[i].id;
				if(ids1.contains(id)){
					 chs[i].getUI().checkbox.checked = true;
					 chs[i].attributes.checked = true;
				}
			}
		}
  	  
   }
   return incomePurpose.getTree('tree2',params,true);
}
function reloadTree(){
        var tree = Ext.getCmp('tree1');
	    var yyyy = Ext.getCmp('year').getValue();	
	    orderCategory.obj.version = yyyy;
		tree.getLoader().params =[{},orderCategory.obj];
		tree.root.reload(); 
		
        var tree = Ext.getCmp('tree2');
	    incomePurpose.obj.version = yyyy;
		tree.getLoader().params =[{},incomePurpose.obj];
		tree.root.reload(); 		
	
}

function save(){
		var tree1 = Ext.getCmp('tree1');
		var tree2 = Ext.getCmp('tree2');
		var version = Ext.getCmp('year').getValue();	
		
		var checkedNodes1 = tree1.getAllCheckedIds();
		var checkedNodes2 = tree2.getAllCheckedIds();
		
		var checkedNodes3 = getNotChecked(tree1);
		var checkedNodes4 = getNotChecked(tree2);
		

		var str1 = checkedNodes1.join(',') +"@"+ checkedNodes3.join(',');
		var str2 = checkedNodes2.join(',') +"@"+ checkedNodes4.join(',');
		
//		alert(checkedNodes4.join(','));
		
		if(!tree2.getRootNode().childNodes || tree2.getRootNode().childNodes ==''){
			str2 ="notloadTree"
		}		
        

        
		OrderCateFitterUtil.saveOrderCateFitterParam2(version,str1,str2,callbak);
		
		function callbak(){
			alert("保存成功")
		}   
}

function getNotChecked(tree){
	var root = tree.getRootNode();
	var checkedNodes = root.childNodes;
	var ids =[];

	root.eachChild(function(node){
		 if(!node.isLeaf()){
		 	     node.eachChild(function(nd){
			 	    if(nd.getUI().isChecked() == false){
			 	    	 ids.push(nd.id);	
			 	    }
		 	     });
		 }else{
			 	    if(node.getUI().isChecked() == false){
			 	    	 ids.push(node.id);	
			 	    }
		
		 }

     });	
   
	return ids;
}

//alert(curYear);

var swit = false;

var comYear = utils.getComYear('year','年度',150,curYear); 
comYear.on("select",reloadTree,this);	 

getCheck();

var tree1 = getTree1();

var tree2 = getTree2();

var buttons = [
{
            id: 'mybutton',
            text: '保存',
            handler: save,
            scale: 'medium',
            scope: this
        },{
            id: 'mybutton2',
            text: '关闭',
            handler: function(){Ext.getCmp('MyWindow').destroy()},
            scale: 'medium',
            scope: this
        }

];



Ext.MyWindow=Ext.extend(Ext.Window ,{
	xtype:"window",
	id: 'MyWindow',
	title:"我的窗口",
	width:800,
	height:500,
	layout:"auto",
	buttons: buttons,
	buttonAlign: 'center',
	initComponent: function(){
//		this.bbar=[]
		this.items=[
			{
				xtype:"fieldset",
//				title:"开关",
				layout:"form",
				items:[
					{
						xtype:"panel",
						layout:"column",
						items:[
						  
						
							{
								xtype:"checkbox",
								boxLabel:"启用",
								id: 'MyCheckbox',
								checked:false,
								anchor:"100%",
								 listeners: {
						                check: function(ch){
						                
						                    if(ch.getValue() == true){
						                          Ext.getCmp('mybutton').enable();
						                    }else{
						                         Ext.getCmp('mybutton').disable();
						                    }
						                    var s = ch.getValue()?"1":"0";
						                    
						                    OrderCateFitterUtil.saveFitterSwit(s);
						                },
						                scope: this
						            }
							},
							 comYear
						]
					}
				]
			},

			{
				xtype:"tabpanel",
				activeTab:0,
				items:[
					{
						xtype:"panel",
						title:"订单类别",
						items:[tree1]
					}
					,{
						xtype:"panel",
						title:"到款用途",
						items:[tree2]
					}
				]
			}
		]
		Ext.MyWindow.superclass.initComponent.call(this);
	}
})


var win  = new Ext.MyWindow();
win.show();	
		
		
});  		
		