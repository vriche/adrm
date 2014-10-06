

function Branch(){
	//创建对象
	this.obj ={
		id:null,
		name:null,
		makeSelect:null,
		parentId:null,
		treeLevel:null,
		displayNo:null,
		createBy:null,
		version:null
	}

	this.treebox = null;
	this.tree = null;
		
	this.tBody = null;
	this.IdPrefix = null;
	this.fillObjName = null;
	this.selectName =null;
	this.color1 = null;
	this.color2 = null;
	
	this.pageInfo =""
	this.pageSize ="20"
	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	
	return this;
}

//清空对象
Branch.prototype.reset = function(){
	this.obj.id = null;
	this.obj.name = null;
	this.obj.orgId = null;
	this.obj.parentId = null;
	this.obj.treeLevel = null;
	this.obj.displayNo = null;
	this.obj.createBy = null;
	this.obj.version = null;
}

/*******************************************
*			对象的基本操作方法                
*******************************************/

Branch.prototype.getBranch = function(id){
	var o = null;
	this.reset();
	DWRUtil.setValues(this.obj);

	DWREngine.setAsync(false);
	BranchManager.getBranch(id,setValueFun);
	DWREngine.setAsync(true);	
	function setValueFun(obj){
		DWRUtil.setValues(obj);
		o = obj;
	}
	return o;
}
/* 获得列表
 * obj 对象参数
 * fillObjName 界面 TBODY 的ID名
 */
Branch.prototype.getBranchs = function(){
	var OBJ = this;
	var obj = this.obj;
	var page   = this.page;
	var tBody  = this.tBody;
	var color1 = this.color1;
	var color2 = this.color2;

    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		BranchManager.getBranchsPage(obj,page.pageIndex,page.pageSize,fillTalbe);
    }else{
		BranchManager.getBranchs(obj,fillTalbe);	
    }

   
	//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
    function fillTalbe(objs){
		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("name", rowData.name);
//		 	row.setAttribute("treeLevel", rowData.treeLevel);
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
			OBJ.removeBranch(id,delRow);
		}
		
		//一行中，各单元格返回的内容
		var cellTable=[
						function(obj){ return obj.name;},
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
	}
}
/* 保存
 * obj 组装好数据的对象
 * mode 保存模式  状态为 new 时必须设置 id = null
 */
Branch.prototype.saveBranch = function(mode){
	var OBJ = this;
	var obj =  this.obj;
	var id = null;

	if (mode == 'new') obj.id = null;
	
	DWREngine.setAsync(false);
	BranchManager.saveBranch(obj,saveFun);
	DWREngine.setAsync(true);

	function saveFun(newId){
		OBJ.reset();
		id = newId;
	}
	return id;
}

Branch.prototype.saveBranchUser = function(orgId,userId,branchId){
	DWREngine.setAsync(false);
	BranchManager.saveBranchUser(orgId,userId,branchId,saveFun);
	DWREngine.setAsync(true);
	function saveFun(){}
}

Branch.prototype.removeBranchUser = function(userId,branchId){
	BranchManager.removeBranchUser(userId,branchId,saveFun);
	function saveFun(){}
}

Branch.prototype.saveBranchRelation = function(parentId){
	var obj = this.obj
	var o = this.getBranch(obj.id);
	o.parentId = parentId;
//	alert(o.parentId);
	this.obj = o;
	this.saveBranch(o,saveFun);
	function saveFun(){}
}

Branch.prototype.saveBranchRelation2 = function(parentId,orgId){
	var obj = this.obj
	var o = this.getBranch(obj.id);
	o.parentId = parentId;
	o.orgId = orgId;
	if(obj.displayNo == ''|| isUndefined(obj.displayNo)) o.displayNo = 0;
	this.obj = o;
	this.saveBranch(o,saveFun);
	function saveFun(){}
}

Branch.prototype.saveUserOrg = function(orgId_old,orgId,branchId){
	BranchManager.saveUserOrg(orgId_old,orgId,branchId,saveFun);
	function saveFun(){}
}



/* 删除
 * 根据id删除对象
 */
Branch.prototype.removeBranch = function(id,delRow){
	var OBJ = this;
	var obj = this.obj;
	var page = this.page;
	var curRow = OBJ.tBody.rows.length;
	
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	BranchManager.removeBranch(id,removeFun);	
	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
		OBJ.getBranchs(obj);
   }
}
/* 总记录数
 * 
 */
Branch.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	BranchManager.getBranchsCount(obj,getCountFun);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}
/* 添加新行 编辑或删除 
 * 
 */
Branch.prototype.addNewRow = function(mode,editRow){
    var OBJ = this;
	var obj = this.obj;
	var page = this.page;
	var tBody = this.tBody;
	
	if (!checkEeitState('btn_SaveImgTd')) return false;
	
	function getRowDataInObj(editRow){
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.name = editRow.getAttribute("name");
//	 	obj.treeLevel = editRow.getAttribute("treeLevel");
	 }	 
	 
	function save(event){
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");
		var id = saveImgTd.getAttribute("paraId");

		DWRUtil.getValues(obj);

		OBJ.saveBranch(obj,mode);
	}	 
	
	function cannel(event){
		 OBJ.reset();
		 OBJ.getBranchs();
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

	cell[j++] =  makeInputTextTd("name","text","10px",obj.name,"");
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


 Branch.prototype.makeSelect = function(obj,name,event,callBakFun) {
	DWREngine.setAsync(false);
	BranchManager.getBranchSelect(obj,setValueFun);
	DWREngine.setAsync(true);	
	
	function setValueFun(objs){
		// makeSelectHtml(objs,name,event);
		makeSelectHtmlWidth(objs,name,event,100)
		 if(callBakFun) callBakFun();
	}
}    
   
 Branch.prototype.makeSelect2 = function(obj,name,event,callBakFun) {
		DWREngine.setAsync(false);
		BranchManager.getBranchSelect(obj,setValueFun);
		DWREngine.setAsync(true);	
		
		function setValueFun(objs){
			makeSelectHtmlWidth(objs,name,event,155)
			 if(callBakFun) callBakFun();
		}
	}  

/***********************************************
* 		       树形处理                               
************************************************/
/* 给树加载信息	
 * 先初始化树对象，再加载数据
 */
Branch.prototype.getTreeXML = function(){
	var OBJ = this;
	var treeXMLString;

	DWREngine.setAsync(false);
	BranchManager.getBranchsXML(this.obj,this.IdPrefix,getxml);
	DWREngine.setAsync(true);
	
	function getxml(treeXML){ 
		
		OBJ.tree.treeXML = treeXML; 
		treeXMLString = treeXML;
	} 
	

    return treeXMLString;
}


Branch.prototype.getTreeXML2 = function(getxml){

	BranchManager.getBranchsXML(this.obj,this.IdPrefix,callBakFun);
	DWREngine.setAsync(true);
	
	function callBakFun(treeXML){ 
		if(getxml) getxml(treeXML)
	} 

}



////节点得到焦点，触发的事件
//Branch.prototype.doOnSelectTree = function(itemId){
//	var dhtmlTree = branch.tree.dhtmlTree;
//	dhtmlTree.setItemColor(itemId,"red","pink"); 
//	
//}
////节点改变时，触发的事件
//Branch.prototype.doOnTextChangeTree  = function(itemId){
//	var dhtmlTree = branch.tree.dhtmlTree;
//	
//	branch.obj.parentId = 0;
//	branch.obj.id = 0;
//	branch.obj.name = dhtmlTree.getItemText(itemId);
//	branch.saveBranch(branch);
//}
////节点被拖动前，触发的事件
//Branch.prototype.doOnBeforeDropTree  = function(itemId,parentId){
//	var dhtmlTree = branch.tree.dhtmlTree;
//
//}

Branch.prototype.getBranchLists = function(o){
	var OBJ = o;
	var obj = this.obj;
	var page   = this.page;
	var tBody  = this.tBody;
	var color1 = this.color1;
	var color2 = this.color2;


    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		BranchManager.getBranchsPage(obj,page.pageIndex,page.pageSize,fillTalbe);
    }else{
		BranchManager.getBranchs(obj,fillTalbe);	
    }


   
	//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
    function fillTalbe(objs){
		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("name", rowData.name);
//		 	row.setAttribute("treeLevel", rowData.treeLevel);
		 }	
		 
		//编辑图标的触发的事件
		function edit(event){
			var e = event || window.event;
			var editImg = Event.element(e);
			var id = editImg.getAttribute("paraId"); 
			
			var editRow = $(OBJ.IdPrefix + id);
//			OBJ.addNewRow("edit",editRow);
		}
		//删除图标的触发的事件
		function del(event){
			var e = event || window.event;
			var deleImg = Event.element(e);
			var id = deleImg.getAttribute("paraId"); 
			var delRow = deleImg.parentNode.parentNode;
			OBJ.removeBranch(id,delRow);
		}
		
		//一行中，各单元格返回的内容
		var cellTable=[
						function(obj){ return obj.name;},
						function(obj){ return obj.displayNo;},
						function(obj){ 
							var ck = makeInputCheckBox("treeLevel_2","checkbox","1",obj.treeLevel,null);
							return ck;
							},
					    function(obj) {
//					    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"edit('branchId"+obj.id+"')");
					    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"edit('"+obj.id+"')");
//					    	if(OBJ.enableEdit) editImg.onclick = edit;
					    	return editImg;}, 
					    function(obj) {
							var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"delBranch");
//							if(OBJ.enableDel) deleImg.onclick = del;
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
	}
}


Branch.prototype.saveBranchList = function(obj,callBackFun){

BranchManager.saveBranch(obj,saveFun);

	function saveFun(newId){
		
		callBackFun(newId);
		
	}

}
Branch.prototype.getBranchMenu= function(id,callBackFun){
	this.reset();
	DWRUtil.setValues(this.obj);
	BranchManager.getBranch(id,setValueFun);
	function setValueFun(obj){
		callBackFun(obj);
	}
}

Branch.prototype.removeBranchList = function(id,delRow,parentId,branch){
	var OBJ = this;
	var obj = this.obj;
	var page = this.page;
	var curRow = OBJ.tBody.rows.length;
	
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	BranchManager.removeBranch(id,removeFun);	
	function removeFun(){
//		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
//		var fid = branch.tree.getSelectedItemId(branch.IdPrefix) == -1?0:branch.tree.getSelectedItemId(branch.IdPrefix);
//		branch.obj.parentId = parentId;
//		OBJ.getBranchLists(obj);
//		page.pageIndex  = 0;

		branch.tree.dhtmlTree.selectItem(parentId);		
	
		
   }
}











 	