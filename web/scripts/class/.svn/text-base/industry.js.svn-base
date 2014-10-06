function Industry(){
	//创建对象
	this.obj ={
		id:null,
		name:null,
	    code:null,
	    memo:null,
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
	
	return this;
};

//清空对象
Industry.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.code = null;
  	this.obj.memo = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
};

Industry.prototype.makeSelect = function(obj,name,event){
	DWREngine.setAsync(false);
	IndustryManager.getIndustrySelect(fillFun,obj);
	DWREngine.setAsync(true);
	
	function fillFun(objs){
		makeSelectHtml(objs,name,event);
	}
};

Industry.prototype.makeSelectFromMap = function(obj,name,event){
	//DWREngine.setAsync(false);
	IndustryManager.getIndustrySelectFromMap(fillFun,obj);
	//DWREngine.setAsync(true);
	
	function fillFun(objs){
		makeSelectHtml(objs,name,event);
	}
};

Industry.prototype.makeSelectAnalyze = function(obj,name,event,callBackFun) {

	IndustryManager.getIndustrySelectFromMap(setValueFun,obj);
	
	function setValueFun(objs){
		 makeSelectHtmlAnalyze(objs,name,event);
		 callBackFun();
	}
};



Industry.prototype.getIndustryAutoComplet = function(obj,callBackFun){
	IndustryManager.getIndustrys(callBackFun,obj);	
};



Industry.prototype.getTree =function(id,params,checkBox){
   var baseAttrs ={};
   if(checkBox){baseAttrs ={uiProvider: Ext.tree.TreeCheckNodeUI};}
   var treeload = new Ext.tree.DWRTreeLoader({
		dwrMethod: IndustryManager.getTree,
		params: params,
		baseAttrs: baseAttrs //添加 uiProvider 属性  
	});
	
	
	function search(){
				var searchName = Ext.getDom('searchName').value;
				alert("查询字符串："+searchName);
	}	
		
        
	var tree = new Ext.tree.TreePanel({
		 id:id,
	     height :300,
	     border:true,
	     rootVisible:false,
	     autoScroll:true,
//	     enableDrop:true,
		 enableDD:true,
		 singleExpand:true,
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

   return tree;
};


   

Industry.prototype.getIndustryCmd = function (paras,cmdId,treeId,allowUnLeafClick,renderTo,industryLevelParam,filterFiled,emptyText,width,callFunction){

	
	         var OBJ = this;
	     	 OBJ.obj.parentId = 0;
	     	 var params = [{}]; //tree dataIn。;
	     	 
	
	     	 var tree = OBJ.getTree(treeId,params,false);

	     	if(!OBJ.treecombo){
				var conf = {
					       id: cmdId,
					       fieldLabel : '',
			               width : width,
			               lastQuery:'-l',
			               passName : 'typeId',
			               autoScroll:true,
			               treeHeight:300,
			               tree :tree,
			               params:paras,
			               filterFiled: filterFiled,
			               emptyText: emptyText,
			               allowBlank : false        
				}	
				if(renderTo) conf.renderTo = renderTo;  
				if(allowUnLeafClick) conf.allowUnLeafClick = allowUnLeafClick;  
				if(callFunction) conf.callFunction = callFunction;  
	
				   		
				OBJ.treecombo = new ComboBoxTree(conf);
	     	}
	     	

	     	function onTreeSelected(node){
	     		var params = OBJ.treecombo.params;
               	var name  ='';
               	var nodeLevel = node.attributes.level;
               	if(nodeLevel == '2'){
               		    var parentNode = node.parentNode;
               		    name = parentNode.text + '/' +node.text;
               	}else{
               		 name = node.text;  	
               	}
                OBJ.treecombo.passField.value = node.id;
                OBJ.treecombo.setValue(name);  	
                OBJ.treecombo.nodeLevel = nodeLevel;
               
                
                var search =  OBJ.treecombo.lastQuery !== node.id;
				if(search){ 
					eval("params."+ filterFiled +" =node.id");  
					OBJ.treecombo.lastQuery = node.id;
					OBJ.treecombo.callFunction(params);
				}
	     	
	     	}
	 
			 function func(){
			 	 var filterFiled = OBJ.treecombo.filterFiled;
			 	 var params = OBJ.treecombo.params;
			 	 eval("params."+ filterFiled +" =null");
			 	 OBJ.treecombo.lastQuery = -1;
			 	 OBJ.treecombo.callFunction(params);
			 	 OBJ.treecombo.nodeLevel = 0;
			 }

    	   OBJ.treecombo.on("clear",func,this);	 	     	

           OBJ.treecombo.on('treeselected',onTreeSelected,OBJ.treecombo);  
           
           return OBJ.treecombo;
}

