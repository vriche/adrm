function OrderCategory(){
	//创建对象
	this.obj ={
		id:null,
		name:null,
	    parentId:null,
	    nodeLevel:null,
	    displayNo:null,
	    nodePath:null,
	    value:null,
	    calculateAuto:null,
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
			{name: "name", type: "string"},
			{name: "calculateAuto", type: "string"},
			{name: "parentId", type: "string"}
			
	];
	
	return this;
}

//清空对象
OrderCategory.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.parentId = null;
  	this.obj.nodeLevel = null;
  	this.obj.displayNo = null;
  	this.obj.nodePath = null;
  	this.obj.value = null;
  	this.obj.calculateAuto = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
}

OrderCategory.prototype.getOrderCategory = function(id){
	this.reset();
	DWRUtil.setValues(this.obj);
	OrderCategoryManager.getOrderCategory(setValueFun,id);
		
	function setValueFun(obj){
		DWRUtil.setValues(obj);
	}
}

/* 获得列表
 * obj 对象参数
 * fillObjName 界面 TBODY 的ID名
 */
OrderCategory.prototype.getOrderCategorys = function(){

	var obj = this.obj;
	var page   = this.page;

    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		
		page.MakePageNav(page.pageIndex,page.pageInfo);
		OrderCategoryManager.getOrderCategorysPage2(this.fillTalbe,obj,page.pageIndex,page.pageSize);
    }else{
		OrderCategoryManager.getOrderCategorys(this.fillTalbe,obj);	
    } 
}

OrderCategory.prototype.fillTalbe = function(objs){
	var OBJ = orderCategory;
	var obj = OBJ.obj;
	var tBody  = orderCategory.tBody;
	var color1 = orderCategory.color1;
	var color2 = orderCategory.color2;
	
	
	 //把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("parentId", rowData.parentId);
	 	row.setAttribute("name", rowData.name);
	 	row.setAttribute("value", rowData.value);
	 	row.setAttribute("calculateAuto", rowData.calculateAuto);
	 	row.setAttribute("version", rowData.version);
	 }	
	 
	//编辑图标的触发的事件
	function edit(event){
		var e = event || window.event;
		var editImg = Event.element(e);
		var id = editImg.getAttribute("paraId"); 
		
		
		
		var editRow = $(OBJ.IdPrefix + id);
//		alert(editRow.getAttribute("version"))
//		$("version").value = editRow.getAttribute("version"); 
		
//		alert(editRow.getAttribute("calculateAuto"))
		
		OBJ.addNewRow("edit",editRow);
	}
	//删除图标的触发的事件
	function del(event){
		var e = event || window.event;
		var deleImg = Event.element(e);
		var id = deleImg.getAttribute("paraId"); 
		var delRow = deleImg.parentNode.parentNode;
		OBJ.removeOrderCategory(id,delRow);
	}
	
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){ return obj.name},
					function(obj){ return obj.value},
					function(obj){ return obj.calculateAuto},
				    function(obj) {
				    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"editOrderCategory");
				    	if(obj.parentId !=0 || loginUser=='admin'){    
					    	 editImg.onclick = edit;
				    	}else{
				    		 editImg.onclick = function(){alert("订单主类别不能编辑，只能修改子类别");};
				    	}
				    	return editImg;
					}, 
				    function(obj) {
						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"delOrderCategory");
						
				    	if(obj.parentId !=0 || loginUser=='admin'){    
					    	 deleImg.onclick = del;
				    	}else{
				    		 deleImg.onclick = function(){alert("订单主类别不能删除，只能删除子类别");};
				    	}
				    	return deleImg;} 
			];	
	
	//先删除 tbody		
	DWRUtil.removeAllRows(tBody);
	//再重新构造新的表
	DWRUtil.addRows(tBody,objs,cellTable,{
				rowCreator:function(options) {  
						   var row = document.createElement("tr"); 
				           putRowDataInHidden(row,options.rowData);
						   return row;  
					  },  
					  
				cellCreator:function(options) {  
						    var td = document.createElement("td"); 
						    return td;  
					  }  
				});
				
	//给表格每一行上颜色，调用 global.js 中的setColors函数
	setColors(tBody, color1, color2);
}

/* 总记录数
 * 
 */
OrderCategory.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	OrderCategoryManager.getOrderCategorysCount(getCountFun,obj);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}

/* 保存
 * obj 组装好数据的对象
 * mode 保存模式  状态为 new 时必须设置 id = null
 */
OrderCategory.prototype.saveOrderCategory = function(mode){
	var OBJ = this;
	var obj = this.obj;
	var id  = obj.id;
	var parentId  = obj.parentId;
	var version =  obj.version;
	
	DWRUtil.getValues(obj);
	
	obj.id = id;
	obj.version = version;
	obj.parentId = parentId;

	if (mode == 'new') obj.id = null;
	
	DWREngine.setAsync(false);
	OrderCategoryManager.saveOrderCategory(obj,saveFun);
	DWREngine.setAsync(true);
	
	function saveFun(newId){
		OBJ.reset();
		id = newId;
		OBJ.getOrderCategorys();
	}
	return id;
}

OrderCategory.prototype.saveCategory = function(o,mode){
	var OBJ = o;
	var obj = OBJ.obj;
	var id;
	
	if (mode == 'new') obj.id = null;
	
	DWREngine.setAsync(false);
	OrderCategoryManager.saveOrderCategory(obj,saveFun);
	DWREngine.setAsync(true);

	function saveFun(newId){
		OBJ.reset();
		id = newId;
	}
	return id;
}


OrderCategory.prototype.saveCategory2 = function(obj,callbak){

	OrderCategoryManager.saveOrderCategory(obj,saveFun);

	function saveFun(newId){
		callbak(newId);
	}

}

/* 删除
 * 根据id删除对象
 */
OrderCategory.prototype.removeOrderCategory = function(id,delRow){
	var OBJ = this;
	var obj = this.obj;
	var page = this.page;
	var curRow = this.tBody.rows.length;
	
	if (!checkEeitState('btn_SaveImgTd')) return false;
	
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	DWREngine.setAsync(false);
	OrderCategoryManager.removeOrderCategory(removeFun,id);	
	DWREngine.setAsync(true);
	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
//		OBJ.getOaDocuments();
   }
   return true;
}

/* 添加新行 编辑或删除 
 * 
 */
OrderCategory.prototype.addNewRow = function(mode,editRow){
    var OBJ = this;
    var obj = this.obj;
	var page = this.page;
	var tBody = this.tBody;

	
	if (!checkEeitState('btn_SaveImgTd')) return false;
	
	function getRowDataInObj(editRow){
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.name = editRow.getAttribute("name");
	 	obj.parentId = editRow.getAttribute("parentId");
	 	obj.calculateAuto = editRow.getAttribute("calculateAuto");
	 	obj.value = editRow.getAttribute("value");
	 	obj.version = editRow.getAttribute("version");
	 }	 
	 
	function save(event){
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");
		var id = saveImgTd.getAttribute("paraId");
        var parentId = 	obj.parentId;
        var version = obj.version;
		DWRUtil.getValues(obj);
        obj.parentId = parentId;
        obj.version = version;
		OBJ.saveOrderCategory(obj,mode);
	}	 
	
	function cannel(event){
		 btn_cancel_edit();
//		 alert(111111)
//		 OBJ.reset();
//		 OBJ.getOrderCategorys()
	}	 	
	 
	//从编辑行中获得数据，来添对象
	if(mode =='edit'){ 
		getRowDataInObj(editRow);
	}


	//////////////////构造新行 start //////////////////
	
	var container = document.createElement("span");
	var newRow = document.createElement("tr");
	//给新行设置ID属性
	newRow.setAttribute("id",obj.id);
		
	var cell = []; var j = 0;
		
	var saveImgTd = makeImagTd("image/save.png","btn_SaveImgTd","18","18",obj.id,"");
	var cannelImgTd =makeImagTd("image/restore.png","btn_CannelImgTd","18","18",0,"");

	cannelImgTd.onclick = function(){
	    newRow.remove(); 
    	setColors(tBody,color1,color2);
    }

	cell[j++] =  makeInputTextTd("name","text","10px",obj.name,"");
	cell[j++] =  makeInputTextTd("value","text","10px",obj.value,"");
//	alert(obj.calculateAuto);
	cell[j++] =  makeInputTextTd("calculateAuto","text","10px",obj.calculateAuto,"");
	cell[j++] =  saveImgTd;
	cell[j++] =  cannelImgTd;

	for (var i = 0;i < cell.length;i++ ){
		newRow.appendChild(cell[i]);
	}
	container.appendChild(newRow);
	
	//////////////////构造新行 end ///////////////////
	
	
	
	//编辑状态：追加新行，删除旧行	
	if(mode =='edit'){
		new Insertion.After(editRow,container.innerHTML);
		editRow.remove();	
	}else{
	//新添状态，直接追加新行
		if(tBody.rows.length == page.pageSize) DWRUtil.removeAllRows(tBody);
		tBody.appendChild(newRow);
	}
		
	//只能在新行添完后，才能给对象添加事件
	var btn_SaveImgTd = $("btn_SaveImgTd"); btn_SaveImgTd.onclick = save;
	var btn_CannelImgTd = $("btn_CannelImgTd"); btn_CannelImgTd.onclick = cannel;	
	
	if(mode =='edit'){
		btn_SaveImgTd.setAttribute("mode","edit")
		btn_SaveImgTd.setAttribute("version",obj.version)
	}else{
		btn_SaveImgTd.setAttribute("mode","new")
	}

	setColors(tBody,this.color1,this.color2);
}

OrderCategory.prototype.makeSelect = function(obj,name,event){
	
	DWREngine.setAsync(false);
	OrderCategoryManager.getOrderCategorySelect(fillFun,obj);
	DWREngine.setAsync(true);
	
	
	function fillFun(objs){
		makeSelectHtml(objs,name,event);
	}
}


//OrderCategory.prototype.makeSelectOrderList = function(name,callback){
OrderCategory.prototype.makeCategoryFromMap = function(orgId,version,name,callback){	
//	DWREngine.setAsync(false);
	OrderCategoryManager.getOrderCategorySelectOrderList(orgId,version,fillFun);
//	DWREngine.setAsync(true);
	
	
	function fillFun(objs){
//		makeSelectHtml(objs,name,"");
		
		
//	var div = document.createElement("div");
//    var span = document.createElement("span");
//    var parnetNode = $(name).parentNode;
//    
//    div.setAttribute("style","position:relative;");
//    span.setAttribute("style","margin-left:100px;width:18px;overflow:hidden;");
    
    DWRUtil.removeAllOptions(name);
	DWRUtil.addOptions(name, objs);
//	var select = $(name);
//	select.setAttribute("style","width:138px;font-size:12px;");
////	select.setAttribute("onChange","javascript:"+ event +"(this)");
//	
//	div.appendChild(span);
//	span.appendChild(select);
//	parnetNode.appendChild(div);
//		
		
		callback();
	}
}



OrderCategory.prototype.makeSelectFromMap = function(obj,name,event,callbackFun){
	
//	DWREngine.setAsync(false);
	OrderCategoryManager.getOrderCategorySelectFromMap(fillFun,obj);
//	DWREngine.setAsync(true);

	function fillFun(objs){
		makeSelectHtml(objs,name,event);
		callbackFun();
	}
}
OrderCategory.prototype.makeSelectFromMap2 = function(obj,name,event,callbackFun,selectedIndex){
	
//	DWREngine.setAsync(false);
	OrderCategoryManager.getOrderCategorySelectFromMap(fillFun,obj);
//	DWREngine.setAsync(true);

	function fillFun(objs){
		makeSelectHtml(objs,name,event);
		callbackFun();
		if(selectedIndex*1>0) $(name).value = selectedIndex;
	}
}

OrderCategory.prototype.makeSelectFromMap3 = function(obj,name,event,callbackFun,selectedIndex,width){
	
//	DWREngine.setAsync(false);
	OrderCategoryManager.getOrderCategorySelectFromMap(fillFun,obj);
//	DWREngine.setAsync(true);

	function fillFun(objs){
		makeSelectHtmlWidth(objs,name,event,width)
		
		if(selectedIndex*1>0) $(name).value = selectedIndex;
		
		callbackFun();
	}
}

OrderCategory.prototype.getOrderCategorySelectParentFromMap = function(obj,name,event){
	
	//DWREngine.setAsync(false);
	OrderCategoryManager.getOrderCategorySelectParentFromMap(fillFun,obj);
	//DWREngine.setAsync(true);
	
	
	function fillFun(objs){
		makeSelectHtml(objs,name,event);
	}
}

/* 给树加载信息	
 * 先初始化树对象，再加载数据
 */
OrderCategory.prototype.getTreeXML = function(){
	var OBJ = this;
	var treeXMLString;
	
	DWREngine.setAsync(false);
	OrderCategoryManager.getOrderCategoryXML(this.obj,this.IdPrefix,getxml);
	DWREngine.setAsync(true);
	
	function getxml(treeXML){ 
		OBJ.tree.treeXML = treeXML; 
		treeXMLString = treeXML;
	} 

    return treeXMLString;
}



OrderCategory.prototype.getValueFromCommand = function(selectCommand,type){
	var value = 0;
    var length = selectCommand.length;
 	if (length > 0){   
		for (var i=0; i<length;i++){
			if(selectCommand.item(i).text.indexOf(type) >-1)  value = selectCommand.item(i).value;
		}	
 	}
 	return value;
}


OrderCategory.prototype.getStore = function(mode,paramObj){
	paramObj = paramObj || {};
	var fileds= this.fileds;

	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: OrderCategoryManager.getStore}),
		reader: new Ext.data.DWRObjectReader({id: "id"},fileds)
	});
	
	if(mode == 'remote'){
	  	store.on('beforeload', function(){
	    	Ext.apply(this.baseParams, {dwrParams:[paramObj]});
		}); 
		store.load();			
	}else{
		store.load({params:{dwrParams:[paramObj]}});
	}
		return store;
}











OrderCategory.prototype.getOrderCategoryFromOrder = function(mode,paramObj){
	paramObj = paramObj || {};

	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: OrderCategoryManager.getOrderCategoryFromOrder}),
		reader: new Ext.data.MapReader(),
	});
	
	
	if(mode == 'remote'){
	  	store.on('beforeload', function(){
	    	Ext.apply(this.baseParams, {dwrParams:[paramObj]});
		}); 
		store.load();		
	}else{
		store.load({params:{dwrParams:[paramObj]}});	
	}	
	
		return store;
}



OrderCategory.prototype.makeSubCategoryFromOrder =  function(rederId,elname,width,mode,callBackFun){
	    
  	    var paramObj = this.obj;
        var store = this.getOrderCategoryFromOrder('remote',paramObj);
		var conf = {
		        store: store,
		        id:elname,
		        name:elname,
		        width:width,
		        displayField:'value',
		         valueField:'key',
		        typeAhead: true,
		         editable: false,
		        mode: mode,
		        forceSelection: true,
		          allowBlank:true,
		        triggerAction: 'all',
		        fieldLabel: '订单子类别',
		        emptyText:'请选择订单类别...',
		        selectOnFocus:true
//		        renderTo:rederId
		    };
		if(rederId) conf.renderTo =  rederId;  
        var cmd =new Ext.form.ClearableComboBox(conf);
    
    

			 
	store.on('load', function() {callBackFun();});
	
	return cmd;

 }	

 
 OrderCategory.prototype.makeSelectFromMap5 = function(obj,name,event,callBackFun,selectedIndex,width){
	var OBJ = this;
	OrderCategoryManager.getOrderCategorySelectFromMap5(obj,setValueFun);
	function setValueFun(objs){
		 OBJ.makeSelectHtml(objs,name,width,event);
		 if(selectedIndex*1>0) $(name).value = selectedIndex;
		 if(callBackFun) callBackFun();
	}	
}


 
OrderCategory.prototype.makeSelectHtml= function(objs,name,width,event){
    var div = document.createElement("div");
    var span = document.createElement("span");
    var parnetNode = $(name).parentNode;
    
    div.setAttribute("style","position:relative;");
    span.setAttribute("style","margin-left:100px;width:18px;overflow:hidden;font-size:13px;");
    
    DWRUtil.removeAllOptions(name);
    
    var select = $(name);

    for(var i = 0;i< objs.length;i++){
	   var  option = new Option(objs[i].name, objs[i].id);
	   option.calculateauto = objs[i].calculateAuto;
//	   option.setAttribute("calculateauto",objs[i].calculateAuto);
       option.style.cssText ="font-size:13px;";
	   select.options.add(option);
    }

//	select.setAttribute("style","width:138px;margin-left:-100px;font-size:12px;");
	select.setAttribute("style","width:" + width +"px;margin-left:-100px;CURSOR: pointer;font-size:13px;");
//	if(event) select.setAttribute("onChange","javascript:"+ event +"(this)");
	if(event) select.setAttribute("onChange","javascript:"+ event +"(this)");
	
	div.appendChild(span);
	span.appendChild(select);
	parnetNode.appendChild(div);
 }
 
 

 
 


OrderCategory.prototype.getTree =function(id,params,checkBox){
   var Obj = this;
   params = [{},params];
   var baseAttrs ={};
   if(checkBox){baseAttrs ={uiProvider: Ext.tree.TreeCheckNodeUI};}
   var treeload = new Ext.tree.DWRTreeLoader({
		dwrMethod: OrderCategoryManager.getTreeForJosin,
		params: params,
		baseAttrs: baseAttrs //添加 uiProvider 属性  
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
	     loader: treeload, //使用第2步中创建树的加载器
	     checkModel: 'cascade',
	     root:new Ext.tree.AsyncTreeNode({
	      text: '订单类别',
	      expanded:true,
	      allowDrag:false,
	      id: "0"
	      })

	 });
	 
     tree.on('beforeload', function(){this.body.mask('数据加载中……', 'x-mask-loading');});   
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
			              
//						 	node.getUI().checkbox.checked = false;
//						     node.attributes.checked = false;
			            }    
     	    return ids;
     }     	
     	
     	

   return tree;
};

// OrderCategory.prototype.getStoreObj = function(mode,paramObj){
//	paramObj = [paramObj || {}];
//	var fileds= this.fileds;
//	var store = new Ext.data.Store({
//		proxy: new Ext.data.DWRHttpProxy({url: CategoryManager.getCategorySelectLimit}),
//		reader: new Ext.data.DWRObjectReader({id: "id"},fileds)
//	});
//	if(mode == 'remote'){
//	  	store.on('beforeload', function(){
//	    	Ext.apply(this.baseParams, {dwrParams:paramObj});
//		}); 
//		store.load();			
//	}else{
//		store.load({params:{dwrParams:paramObj}});
//	}
//		return store;
//};
//
//OrderCategory.prototype.getSortCmd = function(el_id,mode,width){
//		var paramObj = this.obj;
////		var store = this.getStoreObj('remote',paramObj);
//		var store = this.getOrderCategoryFromOrder('remote',paramObj);
//		var resourceSortCmd =new Ext.form.ClearableComboBox({
//						 	  id:el_id,
//						 	  name:el_id,
//							  tiggerAction:'all',
//							  fieldLabel: '订单类型',
//							  store:store,
//							  editable: true,
//							  triggerAction: 'all', //query all
//							  lastQuery:'1',
//							  displayField:'name',
//							  valueField:'id',
//							  mode:mode,
//							  allowBlank:false,
//							   width:width,
//							   listWidth:300,
//							   forceSelection:false, 
//							  allowBlank:false,
//							  emptyText:'请选择...',
////							  minChars:2,
////							  hiddenName:'helpCode', //提交传过去的值 
//							  filterFiled:'name'
//
//						 });			
//	return resourceSortCmd;
//}
// 
 
