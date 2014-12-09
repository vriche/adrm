
function Brand(){

	this.obj = {
		id:null,
		name:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    helpCode:null,
	    memo:null,
	    enable:null
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
				{name: "name", type: "string"},
				{name: "helpCode", type: "string"}
		];
	
	return this;	
}	

//清空对象
Brand.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.memo = null;
  	this.obj.helpCode = null;
  	this.obj.enable = null;
}	
Brand.prototype.getBrand = function(id,func){
	
}
Brand.prototype.getBrands = function(o,func){
	var OBJ = this;
	var obj = o;
	var page   = this.page;
	
    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		
		BrandManager.getBrandsPage(obj,page.pageIndex,page.pageSize,func);
    }else{
		BrandManager.getBrands(obj,func);	
    }
}


Brand.prototype.getStoreBrands = function(mode,paramObj){
	paramObj = [paramObj || {}];
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: BrandManager.getBrands}),
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



Brand.prototype.comboFilterBy2 = function(qe){
	 var combo = qe.combo;  
	 var filterFiled = combo.filterFiled;
	 var filterFiled2 = combo.filterFiled2;
	 var params = combo.params;
	 var q = qe.query;  
	 var minChars = combo.minChars;


	 
	//  if(q.length < minChars) return false;
	  eval("params."+ filterFiled +" =q");
	  eval("params."+ filterFiled2 +" =q");

	 var forceAll = qe.forceAll;  
	 
	
	 
		 if(forceAll === true || (q.length >= combo.minChars)){  
		     if(combo.lastQuery !== q){  
		         combo.lastQuery = q;  

		         if(combo.mode == 'local'){  
		             combo.selectedIndex = -1;  
		             if(forceAll){  
		                 combo.store.clearFilter();  
		             }else{  
		            	 
//		            	 alert(filterFiled)
//		            	 alert(filterFiled2)
		                 combo.store.filterBy(function(record,id){  
		                 	
//		                     var text = record.get(filterFiled);  
//		                     //在这里写自己的过滤代码  
//		                     return (text.indexOf(q)!=-1);  
		                     
		                     
		                     var text = record.get(filterFiled);  
		                     var match = (text.indexOf(q)!=-1);  
		                     if(!match && filterFiled2){
		                     	match = (record.get(filterFiled2).indexOf(q)!=-1);
		                     }
		                     
		                    
		                     
		                     //在这里写自己的过滤代码  
		                     return match;  	                     

		                 });  
		             }  
		             combo.onLoad();   
		             
		         }else{  
		         	
		         	 if(q !== ''){
			             combo.store.baseParams[combo.queryParam] = q;  
			             combo.store.load({  
							  params:{dwrParams:[params]}   
			             });  
		         	 }

			         combo.expand(); 

		         }  
		     }else{  
		     	
		         combo.selectedIndex = -1;  
		         combo.onLoad();  
		     }  
		 }  
	 	return false;  
	 	} 

Brand.prototype.getBrandCmd =  function(paramObj,renderTo,elname,filterFiled,width,emptyText,callFunction){
	
	var store = this.getStoreBrands('local',this.obj);
         
	var conf ={
        store: store,
        id:elname,
        name:elname,
        listWidth: 200,
        width:width,
        lazyRender: true,
        displayField:'name',
         valueField:'id',
//        typeAhead: true,
        forceSelection: true,
        triggerAction: 'all',
        emptyText:emptyText,
        selectOnFocus:true,
         mode: 'local',
         minChars:1,
         params:paramObj,
		 filterFiled:'name',
		 filterFiled2:'helpCode',
         listeners:{beforequery:this.comboFilterBy2.createDelegate(this)}	

    };  

    if(renderTo) conf.renderTo = renderTo;
    if(filterFiled) conf.filterFiled = filterFiled;
    if(callFunction) conf.callFunction = callFunction;
    
	var cmd = new Ext.form.ClearableComboBox(conf);
//	var cmd = new Ext.form.ComboBox(conf);
	

// 	cmd.getEl().on("mousedown",function(){cmd.onTriggerClick();});
     
//	 function func(){
//	 	 var filterFiled = cmd.filterFiled;
//	 	 var params = cmd.params;
//	 	 eval("params."+ filterFiled +" =null");
//	 	 cmd.callFunction(params);
//	 }
//	 
//	function func2(){
//	 	 var filterFiled = cmd.filterFiled;
//	 	 var params = cmd.params;
//	 	 var value = cmd.getValue();
//	 	 eval("params."+ filterFiled +" =value");
//	 	 cmd.callFunction(params);
//	 }
//
//     cmd.on("clear",func,this);	 
	
	function func2(){
		cmd.callFunction(cmd.getRawValue());
//		getMatterNames(cmd.getRawValue());
	}
//     cmd.on("select",func2,this);	 
//	function func2(){
//		 if(callFunction) callFunction();
//	}
//	 cmd.on("load",func2,this);	 
     
	return cmd;

 };




Brand.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	BrandManager.getBrandsCount(obj,getCountFun);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}

Brand.prototype.fillTable = function(objs){
	var OBJ = this;
	var obj = OBJ.obj;
	var tBody  = this.tBody;
	var color1 = this.color1;
	var color2 = this.color2;
	
	
	//把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("name", rowData.name);
	 	row.setAttribute("memo", rowData.memo);
	 	row.setAttribute("enable", rowData.enable);
		row.setAttribute("helpCode", rowData.helpCode);
	 	
	 }	
	 
	 
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){return obj.name},
					function(obj){return obj.helpCode},
					function(obj){return obj.enable},
//				    function(obj) {
//				    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"editDocument");
////				    	if(OBJ.enableEdit) editImg.onclick = edit;
//				    	return editImg;}, 
//				    function(obj) {
//						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"delDocument");
////						if(OBJ.enableDel) deleImg.onclick = del;
//				    	return deleImg;} 
			];	
				
	//先删除 tbody		
	DWRUtil.removeAllRows(tBody);
	//再重新构造新的表
	DWRUtil.addRows(tBody,objs,cellTable,{
				rowCreator:function(options) {  
						   var row = document.createElement("tr"); 
				           putRowDataInHidden(row,options.rowData);
				           row.setAttribute("onclick","javascript:editInfo("+ options.rowData.id +")");
//						   row.onclick = function(){parent.location.href = "editCustomer.html?id="+options.rowData.id+"";};
						   return row;  
					  },  
					  
				cellCreator:function(options) {  
						    var td = document.createElement("td"); 
						    td.style.cssText = "cursor: pointer;";	 
						    return td;  
					  }  
				});
				
	//给表格每一行上颜色，调用 global.js 中的setColors函数
	setColors(tBody, color1, color2); 
	 
}	






Brand.prototype.getCommandForSelect =  function(paramObj,renderTo,elname,searchFilterFiled,width,emptyText,callFunction){
	var OBJ = this;
	var store = OBJ.getStoreBrands('remote',OBJ.obj);
         
	var conf ={
	        store: store,
	        id:elname,
	        name:elname,
	        listWidth: 200,
	        width:width,
	        lazyRender: true,
	        displayField:'name',
	         valueField:'id',
//	        typeAhead: true,
	        forceSelection: true,
	        triggerAction: 'all',
	        emptyText:emptyText,
	        selectOnFocus:true,
	         mode: 'local',
	         minChars:1,
	         params:paramObj,
			 filterFiled:'name',
			 filterFiled2:'helpCode'
	         ,listeners:{beforequery:this.comboFilterBy2.createDelegate(this)}	

    };  

    if(renderTo) conf.renderTo = renderTo;
    if(searchFilterFiled) conf.searchFilterFiled = searchFilterFiled;
    if(callFunction) conf.callFunction = callFunction;
    
	var cmd = new Ext.form.ClearableComboBox(conf);

// 	cmd.getEl().on("mousedown",function(){cmd.onTriggerClick();});
     
	 function clear(){
	 	 var searchFilterFiled = cmd.searchFilterFiled;
	 	 var params = cmd.params;
	 	 eval("params."+ searchFilterFiled +" =null");
	 	 cmd.callFunction(params);
	 }
	 
	function select(){
	 	 var searchFilterFiled = cmd.searchFilterFiled;
	 	 var params = cmd.params;
	 	 var value = cmd.getValue();
	 	 eval("params."+ searchFilterFiled +" =value");
	 	 cmd.callFunction(params);
	 }
	
//	function beforequery(){
//		 alert(99)
//	}
	

     cmd.on("clear",clear,this);	 
     cmd.on("select",select,this);	
//     cmd.on("beforequery",this.comboFilterBy2,this);	

     
	return cmd;

 };