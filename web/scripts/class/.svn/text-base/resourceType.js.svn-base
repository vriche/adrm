function ResourceType(){
	//创建对象
	this.obj ={
		id:null,
		name:null,
	    value:null,
	    memo:null,
        enable:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null
	}
	
    this.className = null;
	this.treebox = null;
	this.tree = null;
	this.tableName = null;	
	this.tBody = null;
	this.checkBoxName = null;
	this.checkBox =null;
	this.IdPrefix = null;
	this.fillObjName = null;
	this.color1 = null;
	this.color2 = null;
	
	this.pageInfo =""
	this.pageSize ="20"
	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	
	this.fileds =
	[
			{name: "id", type: "int"},
			{name: "name", type: "string"}
			
	];
	
	return this;
}

//清空对象
ResourceType.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.value = null;
  	this.obj.memo = null;
	this.obj.enable = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
}

ResourceType.prototype.makeSelectItemAnalyze = function(obj,name,event){
	//DWREngine.setAsync(false);
	ResourceTypeManager.getResourceTypeSelectItem(fillFun,obj);
	//DWREngine.setAsync(true);
	
	function fillFun(objs){
		makeSelectHtmlAnalyze(objs,name,event);
		if(resourceType.obj.space){
	 	   var  option = new Option('', 0);
	       $(name).options.add(option);
		}
	}
}




ResourceType.prototype.makeSelectItemAnalyze2 = function(obj,name,event,width,type,callBack){

	ResourceTypeManager.getResourceTypeSelectItem(obj,fillFun);

	function fillFun(objs){
		
		var old_value = $(name).value;
		
	    DWRUtil.removeAllOptions(name);
		
        var el =$(name);
        
        el.setAttribute("onChange","javascript:"+ event +"(this)");
    	el.setAttribute("style","font-size:12px;width:"+width+"px;CURSOR: pointer;");
    	
    	if(type == '1'||type == '2'||type == '3') el.options.add(new Option("==所有分类==","999"));
    	
        if(type == '0') el.options.add(new Option("","0"));  
        
        

    		
//        var k = 0;
    	for (var value in objs) {

       		var key = objs[value];

       		 if(key =='' && type == '3'){
       		 	
       		 }else{
       		 	 el.options.add(new Option(key,value));
       		 }

       		
//       		k++;
    	}
    	if(type == 2) el.options.add(new Option("==配置==","add"));
    	
    	if(old_value > 0) el.value = old_value;
//    	if(k == 1){
//    		 el.readOnly= true;
//    		 $("div_carrierSort").hide();
//    	}
//    	
		if(!isUndefined(callBack)) callBack();
	}
}





 
 ResourceType.prototype.getStoreMap = function(mode,paramObj){
	paramObj = [paramObj || {}];
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: ResourceTypeManager.getResourceTypeSelectItem}),
		reader: new Ext.data.MapReader(),
	});
	if(mode == 'remote'){
	  	store.on('beforeload', function(){
	    	Ext.apply(this.baseParams, {dwrParams:paramObj});
		}); 
		store.load();			
	}else{
		store.load({params:{dwrParams:paramObj}});
	}
		return store;
};


 ResourceType.prototype.getStoreList = function(mode,paramObj){
	paramObj = [paramObj || {}];
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: ResourceTypeManager.getResourceTypes}),
		reader: new Ext.data.DWRObjectReader({id: "id"},fileds)
	});
	if(mode == 'remote'){
	  	store.on('beforeload', function(){
	    	Ext.apply(this.baseParams, {dwrParams:paramObj});
		}); 
		store.load();			
	}else{
		store.load({params:{dwrParams:paramObj}});
	}
		return store;
};
 
 
ResourceType.prototype.getResourceTypeForCmd =  function(rederId,elname,width,callBackFun){
	     var OBJ = this;
  	     var paramObj = this.obj;
         var storeUser = this.getStoreList('remote',paramObj);

      var cmd =    new Ext.form.ClearableComboBox({
        store: storeUser,
        id:elname,
        name:elname,
        width:width,
        displayField:'name',
         valueField:'id',
        typeAhead: true,
        mode: 'local',
        forceSelection: true,
        triggerAction: 'all',
        fieldLabel: '归属分类',
        emptyText:'请选择...',
        selectOnFocus:true,
         mode: 'local',
        renderTo:rederId
//        params:paramObj
//		filterFiled:'fullName',
//		listeners:{beforequery:OBJ.comboFilterBy2.createDelegate(this)}	
    });
    
    return cmd;
    
}

ResourceType.prototype.getLovCombo =function(id,checkBox){
		 var OBJ = this;
  	     var paramObj = this.obj;
         var store = this.getStoreList('remote',paramObj);

	   
	 var resourceTypeCmd;
	 
	 if(checkBox){
		  resourceTypeCmd = new Ext.ux.form.LovCombo({
		  	
 	     fieldLabel: '归属分类'
		 ,id:id
		,name:id
		,width:150
		,hideOnSelect:false
		,maxHeight:200
		,readOnly: false 
  		,editable: false
  		,typeAhead: true
		,emptyText: '请选择...' 
		,store:store
//		,store:new Ext.data.SimpleStore({
//			 id:0
//			,fields:[{name:'id',type:'int'}, 'name']
//			,data:[
//				 [1, '订单']
//				,[2, '协议']
//			]
//		})
		,triggerAction:'all'
		,valueField:'id'
		,displayField:'name'
		,mode:'local'		  	
		  	
		  	

			});		
	 }else{
		  resourceTypeCmd =  new Ext.form.ClearableComboBox({
		 	     fieldLabel: '归属分类'
				 ,id:id
				  ,name:id
				,width:150
				,hideOnSelect:false
				,maxHeight:200
				,readOnly: false 
		  		,editable: false
		  		,typeAhead: true
				,emptyText: '请选择...' 
				,store:store
				,triggerAction:'all'
				,valueField:'id'
				,displayField:'name'
				,mode:'local'
			});		
	 }

			
			
		return 	resourceTypeCmd
	
}



ResourceType.prototype.getTree =function(id,params,checkBox){
   var baseAttrs ={};
   if(checkBox){baseAttrs ={uiProvider: Ext.tree.TreeCheckNodeUI};}
   var treeload = new Ext.tree.DWRTreeLoader({
		dwrMethod: ResourceTypeManager.getTree,
		params: params,
		baseAttrs: baseAttrs //添加 uiProvider 属性  
	});
	
	
	function search(){
		var searchName = Ext.getDom('searchName').value;
		alert("查询字符串："+searchName);
	}	
		
        
	var tree = new Ext.tree.TreePanel({
		 id:id,
	     height :230,
	     border:true,
	     rootVisible:false,
	     autoScroll:true,
//	     enableDrop:true,
		 enableDD:true,
//		 singleExpand:true,
	     loader: treeload, //使用第2步中创建树的加载器 
	     checkModel: 'cascade',
//	     bbar: ['名称：',{xtype:'trigger',id: 'searchName',width:200,triggerClass:'x-form-search-trigger',onTriggerClick:search}],
	     root:new Ext.tree.AsyncTreeNode({
	      text: '行业分类',
	      allowDrag:false,
	      id: "0"
	      })
//	     listeners:{
//                click:gg.createDelegate(this),
//                beforeload:reload.createDelegate(this)
//         }

	 });
	 
//     tree.on('beforeload', function(){this.body.mask('数据加载中……', 'x-mask-loading');});   
//     tree.on('load', function(node){this.body.unmask();}); 


	 tree.getAllCheckedIds = function(fiterType){
	 
	 			var checkedNodes = this.getChecked();
	
	                    	var ids = [];
				            for(var i=0;i<checkedNodes.length;i++){    
				               var node = checkedNodes[i];    
				               		ids.push(node.id);
				            }    
	     	    return ids.join("_");
	     }
     
   return tree;
};
