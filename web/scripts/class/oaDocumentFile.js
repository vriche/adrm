function OaDocumentFile(){
	//创建对象
	this.obj ={
		id:null,
		documentId:null,
	    filePath:null,
	    fileName:null,
	    picName:null,
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
}

//清空对象
OaDocumentFile.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.documentId = null;
  	this.obj.filePath = null;
  	this.obj.fileName = null;
  	this.obj.picName = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
}

/*******************************************
*			对象的基本操作方法                
*******************************************/

/* 获得列表
 * obj 对象参数
 * fillObjName 界面 TBODY 的ID名
 */
OaDocumentFile.prototype.getOaDocumentFile = function(id){
	var OBJ = this;
	
	this.reset();
	DWRUtil.setValues(this.obj);
	DWREngine.setAsync(false);
	OaDocumentFileManager.getOaDocumentFile(setValueFun,id);
	DWREngine.setAsync(true);
	
	function setValueFun(obj){
		DWRUtil.setValues(obj);
		OBJ.obj = obj;
	}
}
 
OaDocumentFile.prototype.getOaDocumentFiles = function(){
	var OBJ = this;
	var obj = this.obj;
	var page   = this.page;

    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		OaDocumentFileManager.getOaDocumentFilesPage(OBJ.fillTalbe,obj,page.pageIndex,page.pageSize);
    }else{
		OaDocumentFileManager.getOaDocumentFiles(OBJ.fillTalbe,obj);	
    }
}
   
//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
OaDocumentFile.prototype.fillTalbe = function(objs){
	var OBJ = oaDocumentFile;
	var obj = OBJ.obj;
	var tBody  = oaDocumentFile.tBody;
	var color1 = oaDocumentFile.color1;
	var color2 = oaDocumentFile.color2;
	
	 //把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("fileName", rowData.fileName);
	 	row.setAttribute("filePath",rowData.filePath);
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
		OBJ.removeOaDocumentFile(id,delRow);
	}
	
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){return "<a href=\"" + obj.filePath + "\" target=\"_blank\">" + obj.fileName + "</a>"},
					function(obj){return obj.filePath},
				    function(obj) {
				    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"");
				    	if(OBJ.enableEdit) editImg.onclick = edit;
				    	return editImg;}, 
				    function(obj) {
						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"");
						if(OBJ.enableDel) deleImg.onclick = del;
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
	
/* 保存
 * obj 组装好数据的对象
 * mode 保存模式  状态为 new 时必须设置 id = null
 */
OaDocumentFile.prototype.saveOaDocumentFile = function(o,mode){
	var OBJ = o;
	var obj = OBJ.obj;
	var id  = obj.id;
	
//	DWRUtil.getValues(obj);
//	obj.id = id;
	
	if (mode == 'new') obj.id = null;
	DWREngine.setAsync(false);
	OaDocumentFileManager.saveOaDocumentFile(obj,saveFun);
	DWREngine.setAsync(true);
	function saveFun(newId){
		OBJ.reset();
		id = newId;
//		OBJ.getOaDocumentFiles();
	}
	return id;
}

/* 删除
 * 根据id删除对象
 */
OaDocumentFile.prototype.removeOaDocumentFile = function(id,delRow){
	var OBJ = this;
	var obj = this.obj;
	var page = this.page;
	var curRow = this.tBody.rows.length;
	
	if (!checkEeitState('btn_SaveImgTd')) return false;
	
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	OaDocumentFileManager.removeOaDocumentFile(removeFun,id);	
	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
//		OBJ.getOaDocumentFiles();
   }
   return true;
}
/* 总记录数
 * 
 */
OaDocumentFile.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	OaDocumentFileManager.getOaDocumentFilesCount(getCountFun,obj);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}

/* 添加新行 编辑或删除 
 * 
 */
OaDocumentFile.prototype.addNewRow = function(mode,editRow){
    var OBJ = this;
    var obj = this.obj;
	var page = this.page;
	var tBody = this.tBody;
	
	if (!checkEeitState('btn_SaveImgTd')) return false;
	
	function getRowDataInObj(editRow){
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.fileName = editRow.getAttribute("fileName");
	 	obj.filePath = editRow.getAttribute("filePath");
	 }	 
	 
	function save(event){
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");
		var id = saveImgTd.getAttribute("paraId");
		DWRUtil.getValues(obj);
		obj.id = id;
		OBJ.saveOaDocumentFile(obj,mode);
	}	 
	
	function cannel(event){
		 OBJ.reset();
		 OBJ.getOaDocumentFiles();
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
		
	var saveImgTd = makeImagTd("image/save.png","btn_SaveImgTd","18","18",obj.id,"saveFile");
	var cannelImgTd =makeImagTd("image/restore.png","btn_CannelImgTd","18","18",0,"cannelFile");
	
        
	cell[j++] =  makeInputTextTd("name","text","10px",obj.fileName,"");
	cell[j++] =  makeInputTextTd("file","file","10px",obj.filePath,"");
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
//	var btn_SaveImgTd = $("btn_SaveImgTd"); btn_SaveImgTd.onclick = save;
//	var btn_CannelImgTd = $("btn_CannelImgTd"); btn_CannelImgTd.onclick = cannel;	
//	
//	if(mode =='edit'){
//		btn_SaveImgTd.setAttribute("mode","edit")
//	}else{
//		btn_SaveImgTd.setAttribute("mode","new")
//	}

	setColors(tBody,this.color1,this.color2);
}
	