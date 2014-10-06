
function SysResource(){
	//创建对象
	this.obj ={
		id:null,
		name:null,
		resType:null,
		resString:null,
		roles:null,
		memo:null
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
	
	this.roleId = null;
	
	return this;
}

//清空对象
SysResource.prototype.reset = function(){
	this.obj.id = null;
	this.obj.name = null;
	this.obj.resType = null;
	this.obj.resString = null;
	this.obj.memo = null;
	this.obj.roles =null;
}

/*******************************************
*			对象的基本操作方法                
*******************************************/

SysResource.prototype.getSysResource = function(id){
	this.reset();
	DWRUtil.setValues(this.obj);
	SysResourceManager.getSysResource(setValueFun,id);
		
	function setValueFun(obj){
		DWRUtil.setValues(obj);
	}
}

SysResource.prototype.getSysResources = function(callBak_Fun){
	var OBJ = this;
	var obj = this.obj;
	var page   = this.page;
	var model = this.model;

    
    function callBakFun(objs){
    	
    	OBJ.fillGrid(objs)

    	if(callBak_Fun) callBak_Fun();
    }
	

    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.pageIndex = 1;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		SysResourceManager.getSysResourcesPage(obj,page.pageIndex,page.pageSize,callBakFun);
    }else{

		SysResourceManager.getSysResources(obj,callBakFun);	
    }	
}
/* 获得列表
 * obj 对象参数
 * fillObjName 界面 TBODY 的ID名
 */
SysResource.prototype.getSysResources_bak = function(){
	var OBJ = this;
	var obj = 	this.obj;
	var page   = this.page;
	var tBody  = this.tBody;
	var color1 = this.color1;
	var color2 = this.color2;

    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);

		SysResourceManager.getSysResourcesPage(fillTalbe,obj,page.pageIndex,page.pageSize);

    }else{
    	DWREngine.setAsync(false);
		SysResourceManager.getSysResources(fillTalbe,obj);	
		DWREngine.setAsync(true);
    }
    
//    this.loadDataCheckBox();

   
	//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
    function fillTalbe(objs){
		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("name", rowData.name);
		 	row.setAttribute("resType", rowData.resType);
		 	row.setAttribute("resString", rowData.resString);
		 	row.setAttribute("memo", rowData.memo);
		 }	
		 
		//编辑图标的触发的事件
		function edit(event){
			var e = event || window.event;
			var editImg = Event.element(e);
			var id = editImg.getAttribute("paraId"); 
			
			var editRow = $(OBJ.IdPrefix + id);
			OBJ.addNewRow("edit",editRow);
		}
		//删除图标的触发的事件
		function del(event){
			var e = event || window.event;
			var deleImg = Event.element(e);
			var id = deleImg.getAttribute("paraId"); 
			var delRow = deleImg.parentNode.parentNode;
			OBJ.removeSysResource(id,delRow);
		}
		
		//一行中，各单元格返回的内容
		var cellTable=[
		                function(obj){ return makeInputText(OBJ.checkBoxName,"checkbox",obj.id)},
						function(obj){ return obj.name;},
						function(obj){ return obj.resType;},
						function(obj){ return obj.resString;},
						function(obj){ return obj.memo;},
					    function(obj) {
					    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"");
					    	if(OBJ.enableEdit) editImg.onclick = edit;
					    	return editImg;}, 
					    function(obj) {
							var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"");
							if(OBJ.enableDel) deleImg.onclick = del;
					    	return deleImg;} 
				];	
		
		//先删除 tobdy		
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
		
		OBJ.loadDataCheckBox();
	}
}
/* 保存
 * obj 组装好数据的对象
 * mode 保存模式  状态为 new 时必须设置 id = null
 */
SysResource.prototype.saveSysResource_bak = function(mode){
	var OBJ = this;
	var obj =  sysResource.obj;
	var id;
	obj.displayNo = 0;
	obj.orgId = 1;
	obj.parentId = 0;
	
	
	
	if (mode == 'new') obj.id = null;
	
//	DWREngine.setAsync(false);
	SysResourceManager.saveSysResource(obj,saveFun);
//	DWREngine.setAsync(true);

	function saveFun(newId){
		OBJ.reset();
		id = newId;
		OBJ.getSysResources();
	}
	
//	this.loadDataCheckBox();
	
	return id;
}

SysResource.prototype.saveSysResource = function(callbakFun){
	SysResourceManager.saveSysResource(this.obj,saveFun);
	function saveFun(newId){
		if(callbakFun){callbakFun();}
	}
}



/* 删除
 * 根据id删除对象
 */
SysResource.prototype.removeSysResource = function(id,delRow){
	var OBJ = this;
	var page = this.page;
	var curRow = this.tBody.rows.length;
	var obj = this.obj;
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	SysResourceManager.removeSysResource(removeFun,id);	
	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
		OBJ.getSysResources();
   }
}

SysResource.prototype.remove = function(id,callBakFun){
	var OBJ = this;
	SysResourceManager.removeSysResource(id,removeFun);	
	function removeFun(){
		if(callBakFun){
			callBakFun();
		}
		
//		OBJ.getSysResources();
   }
}
/* 总记录数
 * 
 */
SysResource.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	SysResourceManager.getSysResourcesCount(getCountFun,obj);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}
/* 添加新行 编辑或删除 
 * 
 */
SysResource.prototype.addNewRow = function(mode,editRow){
    var OBJ = this;
	var page = this.page;
	var tBody = this.tBody;
	var obj = this.obj;
	
	if (!checkEeitState('btn_SaveImgTd')) return false;
	
	function getRowDataInObj(editRow){
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.name = editRow.getAttribute("name");
	 	obj.resType = editRow.getAttribute("resType");
	 	obj.resString = editRow.getAttribute("resString");
	 	obj.memo = editRow.getAttribute("memo");
	 }	 
	 
	function save(event){
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");
		DWRUtil.getValues(obj);
		OBJ.saveSysResource(mode);
	}	 
	
	function cannel(event){
		 OBJ.reset();
		 OBJ.getSysResources()
		 OBJ.loadDataCheckBox();
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
		
	var saveImgTd = makeImagTd("image/save.png","btn_SaveImgTd","18","18",0,"");
	var cannelImgTd =makeImagTd("image/restore.png","btn_CannelImgTd","18","18",0,"");

	cell[j++] =  makeInputTextTd(obj.checkBoxName,"checkbox","10px",1,"");
	cell[j++] =  makeInputTextTd3("name","text","10px",obj.name,"",true);
	cell[j++] =  makeInputTextTd3("resType","text","10px",obj.resType,"",true);
	cell[j++] =  makeInputTextTd3("resString","text","20px",obj.resString,"",true);
	cell[j++] =  makeInputTextTd3("memo","text","10px",obj.memo,"",true);
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
	var btn_SaveImgTd =$("btn_SaveImgTd"); btn_SaveImgTd.onclick = save;
	var btn_CannelImgTd =$("btn_CannelImgTd"); btn_CannelImgTd.onclick = cannel;	
	
	if(mode =='edit'){
		btn_SaveImgTd.setAttribute("mode","edit")
	}else{
		btn_SaveImgTd.setAttribute("mode","new")
	}

	setColors(tBody,this.color1,this.color2);
}


SysResource.prototype.loadDataCheckBox = function(){
	
	if(this.roleId > 0){
	    var rescsArrays = this.getSysResourceColByRoleId(this.roleId);
	
		refreshCheckBox(this.tableName);
	//	alert(rescsArrays);
		putValuesInCheckBox2(this.tableName,rescsArrays);
	}

}

SysResource.prototype.getSysResourceColByRoleId = function(roleId){
	var propertyName = "id";
	var str = new Array();
	DWREngine.setAsync(false);
	SysResourceManager.getSysResourceColByRoleId(getFun,roleId,propertyName);	
	DWREngine.setAsync(true);
	
	function getFun(strArray){
		str = strArray;
	}
	return str;
}



/***********************************************
* 		       树形处理                               
************************************************/
/* 给树加载信息	
 * 先初始化树对象，再加载数据
 */
//SysResource.prototype.getTreeXML = function(){
//	var sysResource = this;
//	var treeXMLString;
//
//	DWREngine.setAsync(false);
//	SysResourceManager.getSysResourcesXML(this.obj,this.IdPrefix,getxml);
//	DWREngine.setAsync(true);
//	
//	function getxml(treeXML){ 
//		sysResource.tree.treeXML = treeXML; 
//		treeXMLString = treeXML;
//	} 
//    return treeXMLString;
//}
////节点得到焦点，触发的事件
//SysResource.prototype.doOnSelectTree = function(itemId){
//	var barnch = this;
//	var sysResource_tree = sysResource.tree;
//	var dhtmlTree = sysResource_tree.dhtmlTree;
//	dhtmlTree.setItemColor(itemId,"red","pink"); 
//	
//}
////节点改变时，触发的事件
//SysResource.prototype.doOnTextChangeTree  = function(itemId){
//	var barnch = this;
//	var sysResource_tree = sysResource.tree;
//	var dhtmlTree = sysResource_tree.dhtmlTree;
//	
//	sysResource.obj.parentId = 0;
//	sysResource.obj.id = 0;
//	sysResource.obj.name = dhtmlTree.getItemText(itemId);
//	sysResource.saveSysResource(sysResource);
//}
////节点被拖动前，触发的事件
//SysResource.prototype.doOnBeforeDropTree  = function(itemId,parentId){
//	var sysResource = this;
//	var sysResource_tree = sysResource.tree;
//	var dhtmlTree = sysResource_tree.dhtmlTree;
//	
//
//}

SysResource.prototype.saveSysPermitDefault = function(obj,callBackFun){
		SysResourceManager.saveSysPermitDefault(obj,callBackFun);
}




SysResource.prototype.fillGrid = function(objs){
	
//		var cellTable=[
//		                function(obj){ return makeInputText(OBJ.checkBoxName,"checkbox",obj.id)},
//						function(obj){ return obj.name;},
//						function(obj){ return obj.resType;},
//						function(obj){ return obj.resString;},
//						function(obj){ return obj.memo;},
//					    function(obj) {
//					    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"");
//					    	if(OBJ.enableEdit) editImg.onclick = edit;
//					    	return editImg;}, 
//					    function(obj) {
//							var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"");
//							if(OBJ.enableDel) deleImg.onclick = del;
//					    	return deleImg;} 
//				];	
//	
// 			 var sb;
  
  			sb = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			sb = sb + "<rows>";  
			for(var i = 0;i< objs.length;i++){
				var obj = objs[i];

				sb = sb + "<row  id=\""+ obj.id +"\"" +">";
				sb = sb + "<cell><![CDATA["+  obj.id    +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ decodeURI(obj.name)    +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ decodeURI(obj.resType)   +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ decodeURI(obj.resString)  +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ decodeURI(obj.memo)   +"]]></cell>";
				sb = sb + "</row>";		
			}

		    sb = sb + "</rows>";  	
		    
	      this.mygrid.clearAll();

		     
		   this.mygrid.loadXMLString(sb);		
		   
		   
		   		   	var callbakfn = this.callbakfn;
		   	
		   	if(callbakfn) callbakfn();
		   	
		   
		   this.mygrid.setSizes();	

}










 	