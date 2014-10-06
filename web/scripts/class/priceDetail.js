
function PriceDetail(){

	this.obj = {
		id:null,
		length:null,
	    price:null,
	    version:null,
	    priceId:null
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
PriceDetail.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.length = null;
  	this.obj.price = null;
  	this.obj.version = null;
  	this.obj.priceId = null;
}	
	
PriceDetail.prototype.getPriceDetail = function(id){
	var OBJ = this;
	var obj = OBJ.obj;
	
	this.reset();
	DWRUtil.setValues(this.obj);
	DWREngine.setAsync(false);
	PriceDetailManager.getPriceDetail(setValueFun,id);
	DWREngine.setAsync(true);
	
	function setValueFun(o){
		DWRUtil.setValues(o);
		obj = o;
	}
	return obj;
}	

PriceDetail.prototype.getPriceDetails = function(){
	var OBJ = this;
	var obj = this.obj;
	var page   = this.page;
	
    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		
		PriceDetailManager.getPriceDetailsPage(OBJ.fillTalbe,obj,page.pageIndex,page.pageSize);
    }else{
		PriceDetailManager.getPriceDetails(OBJ.fillTalbe,obj);	
    }
}

//PriceDetail.prototype.getPriceDetailAutoComplet = function(callBackFun,obj){	
//		PriceDetailManager.getPriceDetails(callBackFun,obj);	
//}

PriceDetail.prototype.getPriceDetailAutoComplet = function(callBackFun){	
		PriceDetailManager.getPriceLengthDetailFromMap(callBackFun);
}

//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
PriceDetail.prototype.fillTalbe = function(objs){	
	var OBJ = priceDetail;
	var obj = OBJ.obj;
	var tBody  = priceDetail.tBody;
	var color1 = priceDetail.color1;
	var color2 = priceDetail.color2;
	
	
	
	//把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("length", rowData.length);
	 	row.setAttribute("price", rowData.price);
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
		OBJ.removePriceDetail(id,delRow);
	}
	
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){return obj.length},
					function(obj){return obj.price},
				    function(obj) {
				    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"editPriceDetail");
//				    	if(OBJ.enableEdit) editImg.onclick = edit;
				    	return editImg;}, 
				    function(obj) {
						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"delPriceDetail");
//						if(OBJ.enableDel) deleImg.onclick = del;
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
PriceDetail.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	PriceDetailManager.getPriceDetailsCount(getCountFun,obj);	
    DWREngine.setAsync(true);
    
	function getCountFun(size){ count =  size;}
    return count;
}

/* 添加新行 编辑或删除 
 * 
 */
PriceDetail.prototype.addNewRow = function(mode,editRow){
    var OBJ = this;
    var obj = this.obj;
	var page = this.page;
	var tBody = this.tBody;
	
	if (!checkEeitState('btn_SaveImgTd')) return false;
	
	function getRowDataInObj(editRow){
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.length = editRow.getAttribute("length");
	 	obj.price = editRow.getAttribute("price");
	 }	 
	 
	function save(event){
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");
		var id = saveImgTd.getAttribute("paraId");

		DWRUtil.getValues(obj);
		obj.id = id;

		OBJ.savePriceDetail(obj,mode);
	}	 
	
	function cannel(event){
		 OBJ.reset();
		 OBJ.getPriceDetails();
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
	
        
	cell[j++] =  makeInputTextTd("length","text","10px",obj.length,"");
	cell[j++] =  makeInputTextTd("price","text","10px",obj.price,"");
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
	var btn_SaveImgTd = $("btn_SaveImgTd"); btn_SaveImgTd.onclick = savePriceDetail;
	var btn_CannelImgTd = $("btn_CannelImgTd"); btn_CannelImgTd.onclick = cannelAddandEdit;	
	
	if(mode =='edit'){
		btn_SaveImgTd.setAttribute("mode","edit")
	}else{
		btn_SaveImgTd.setAttribute("mode","new")
	}

	setColors(tBody,this.color1,this.color2);
}

PriceDetail.prototype.savePriceDetail = function(doc,mode,saveFun){
	var OBJ = this;
	var obj = doc;
	
	if (mode == 'new') obj.id = null;
	
//	DWREngine.setAsync(false);
	PriceDetailManager.savePriceDetail(obj,saveFun);
//	DWREngine.setAsync(true);

}

PriceDetail.prototype.makeSelectFromMap = function(name,event){
	DWREngine.setAsync(false);
	PriceDetailManager.getPriceLengthDetailSelectFromMap(func);
	DWREngine.setAsync(true);
	function func(objs){
		makeSelectHtml(objs,name,event);
	}
}

/* 删除
 * 根据id删除对象
 */
PriceDetail.prototype.removePriceDetail = function(id,delRow){
	var OBJ = this;
	var obj = this.obj;
	var page = this.page;
	var curRow = this.tBody.rows.length;
	
	if (!checkEeitState('btn_SaveImgTd')) return false;
	
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	DWREngine.setAsync(false);
	PriceDetailManager.removePriceDetail(removeFun,id);	
	DWREngine.setAsync(true);
	
	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
//		OBJ.getPriceDetails();
   }
   return true;
}

PriceDetail.prototype.removePriceDetailById = function(id,func){
	PriceDetailManager.removePriceDetail(func,id);
}
PriceDetail.prototype.getPriceDetailsByCompagesId = function(compageId){
	var OBJ = this;
	var obj = this.obj;
	var page   = this.page;
	
    if (page.pageSize > 0){
		var size = this.getPriceDetailCountByIdList(compageId);

		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		
		PriceDetailManager.getPriceDetailsByCompagesId(OBJ.fillTalbe,compageId,page.pageIndex,page.pageSize);
    }else{
		PriceDetailManager.getPriceDetails(OBJ.fillTalbe,obj);	
    }
}

PriceDetail.prototype.getPriceDetailCountByIdList = function(compageId){
	
	var count;
	DWREngine.setAsync(false);
	PriceDetailManager.getPriceDetailCountByIdList(getCountFun,compageId);	
    DWREngine.setAsync(true);
    
	function getCountFun(size){ count =  size;}
	
    return count;	
}



