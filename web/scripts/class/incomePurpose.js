function IncomePurpose(){
	//��������
	this.obj ={
		id:null,
		name:null,
	    value:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
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

//��ն���
IncomePurpose.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.value = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
}

IncomePurpose.prototype.makeOptionsCallBackFun = function(obj,callBackFun){
	IncomePurposeManager.getIncomePurposes(obj,callBackFun);	
	
}
IncomePurpose.prototype.makeSelect = function(obj,name,event){
	DWREngine.setAsync(false);
	IncomePurposeManager.getIncomePurposesSelect(fillFun,obj);
	DWREngine.setAsync(true);
	
	function fillFun(objs){
		makeSelectHtml(objs,name,event);
	}
}

IncomePurpose.prototype.makeSelectFromMap = function(obj,name,event,width,callBackFun){
	IncomePurposeManager.getIncomePurposesFromMap(obj,fillFun);
	function fillFun(objs){
//		console.log(objs)
//		alert(objs)
		 makeSelectHtmlWidth(objs,name,event,width);
		 $(name).remove(0);  
		 if(callBackFun) callBackFun();
	}
}

IncomePurpose.prototype.makeSelectFromMap2 = function(obj,name,event,width,callBackFun){
	IncomePurposeManager.getIncomePurposesFromMap2(obj,fillFun);
	function fillFun(objs){
		 makeSelectHtmlWidth(objs,name,event,width);
		 $(name).remove(0);  
		 if(callBackFun) callBackFun();
	}
}

IncomePurpose.prototype.makeSelectItemAnalyze = function(obj,name,event,callback){
	 obj.nodeLevel = 1;
	IncomePurposeManager.getIncomePurposesFromMap(fillFun,obj);
	
	function fillFun(objs){
		makeSelectHtmlAnalyze(objs,name,event);
		if(callback) callback();
	}
}




 IncomePurpose.prototype.getStoreList = function(mode,paramObj){
	paramObj = [paramObj || {}];
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: IncomePurposeManager.getIncomePurposes}),
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
 
 
IncomePurpose.prototype.getLovCombo = function(id,checkBox){
	
   var OBJ = this;
   var paramObj = this.obj;
   var store = this.getStoreList('remote',paramObj);
   
    return  new Ext.ux.form.LovCombo({
 	     fieldLabel: '������;'
		 ,id:id
		,name:id
		,width:150
		,hideOnSelect:false
		,maxHeight:200
		,readOnly: false 
  		,editable: false
  		,typeAhead: true
		,emptyText: '��ѡ�񵽿���;...' 
		,store:store
		,triggerAction:'all'
		,valueField:'id'
		,displayField:'name'
		,mode:'local'		  	
		});		
 }
 
IncomePurpose.prototype.getCombo = function(id,width,checkBox,renderTo){
	
   var OBJ = this;
   var paramObj = this.obj;
   var store = this.getStoreList('remote',paramObj);
      
  

   
   var conf = {
 	     fieldLabel: '������;'
		 ,id:id
		,name:id
		,width:width
		,hideOnSelect:false
		,maxHeight:230
		,readOnly: false 
  		,editable: false
  		,typeAhead: true
  		,selectOnFocus:true
  		 ,forceSelection: true
		,emptyText: '��ѡ�񵽿���;...' 
		,store:store
		,triggerAction:'all'
		,valueField:'id'
		,displayField:'name'
		,mode:'local'
		};
    if(renderTo) conf.renderTo = renderTo;
    
	var cmd;
    if(checkBox){
    	  cmd = new Ext.ux.form.LovCombo(conf);
    }else{
    	  cmd = new Ext.form.ClearableComboBox(conf);	
    }
    
    cmd.store.on('load', function(){cmd.setValue(1);}); 

  	
  	return cmd;
 } 
 
 
 
 IncomePurpose.prototype.getTree =function(id,params,checkBox){
   var Obj = this;
   params = [{},params];
   var baseAttrs ={};
   if(checkBox){baseAttrs ={uiProvider: Ext.tree.TreeCheckNodeUI};}
   var treeload = new Ext.tree.DWRTreeLoader({
		dwrMethod: IncomePurposeManager.getTreeForJosin,
		params: params,
		baseAttrs: baseAttrs //��� uiProvider ����  
	});
        
	var tree = new Ext.tree.TreePanel({
		 id:id,
	     height :330,
	     border:true,
	     rootVisible:false,
	     autoScroll:true,
//	     enableDrop:true,
		 enableDD:false,
		 onlyLeafCheckable : true,
	     loader: treeload, //ʹ�õ�2���д������ļ�����
	     checkModel: 'cascade',
	     root:new Ext.tree.AsyncTreeNode({
	      text: '������;',
	      expanded:true,
	      allowDrag:false,
	      id: "0"
	      })

	 });
	 
     tree.on('beforeload', function(){this.body.mask('���ݼ����С���', 'x-mask-loading');});   
     tree.on('load', function(node){
	     	this.body.unmask();
	     	if(Obj.loadData)Obj.loadData(node);
     	}); 

     	
    tree.getAllCheckedIds = function(){
 
 			var checkedNodes = this.getChecked();
                    	var ids = [];
			            for(var i=0;i<checkedNodes.length;i++){    
			               var node = checkedNodes[i];    
			               if(node.id >0){
			               		ids.push(node.id);
			               }

			            }    
     	    return ids;
     }     	
     	
     	

   return tree;
};
 
 
 