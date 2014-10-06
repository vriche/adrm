
function ContractTargetMonth(){
	//创建对象
	
	this.obj = {
		id:null,
	    contractTargetId:null,
	    monthDate:null,
	    monthTarg:null,
	    monthReal:null,
	    version:null,
	    yearDate:null,
	    contractTarget:null
		
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
ContractTargetMonth.prototype.reset = function(){
	
	this.obj.id = null;
	this.obj.contractTargetId = null;
	this.obj.monthDate = null;
	this.obj.monthTarg = null;
	this.obj.monthReal = null;
	this.obj.version = null;
	this.obj.yearDate = null;
	this.obj.contractTarget = null;
}

ContractTargetMonth.prototype.getContractTargetMonth = function(id){
	var OBJ = this;
	var obj = OBJ.obj;
	
	this.reset();
	DWRUtil.setValues(this.obj);
	DWREngine.setAsync(false);
	ContractTargetMonthManager.getContractTargetMonth(setValueFun,id);
	DWREngine.setAsync(true);
	
	function setValueFun(o){
		DWRUtil.setValues(o);
		obj = o;
	}
	return obj;
}

ContractTargetMonth.prototype.getContractTargetMonths = function(o,func){
	var OBJ = this;
	var obj = o;
	var page   = OBJ.page;
	
	

    if (page.pageSize > 0){
		var size = this.getCount(obj);

		page.size = size;
		
		page.MakePageNav(page.pageIndex,page.pageInfo);
		
		ContractTargetMonthManager.getContractTargetMonthsPage(func,obj,page.pageIndex,page.pageSize);
    }else{
		ContractTargetMonthManager.getContractTargetMonths(func,obj);	
    }
}
  
//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
ContractTargetMonth.prototype.fillTalbe = function(objs){	

	var OBJ = contractTargetMonth;
	var obj = OBJ.obj;
	var tBody  = contractTargetMonth.tBody;
	var color1 = contractTargetMonth.color1;
	var color2 = contractTargetMonth.color2;
	
	
	//把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("contractTargetId", rowData.contractTargetId);
	 	row.setAttribute("yearDate", rowData.yearDate);
	 	row.setAttribute("monthDate", rowData.monthDate);
	 	row.setAttribute("monthTarg", rowData.monthTarg);
	 	row.setAttribute("monthReal", rowData.monthReal);
	 }	
	 
	//编辑图标的触发的事件
	function edit(event){
		
		var e = event || window.event;
		var editImg = Event.element(e);
		var tr1= editImg.parentNode.parentNode;
		var id = tr1.getAttribute("paraId"); 
		
		var editRow = $(OBJ.IdPrefix + id);
		OBJ.addNewRow("edit",editRow);
	}
	//删除图标的触发的事件
	function del(event){
		var e = event || window.event;
		var deleImg = Event.element(e);
		var id = deleImg.getAttribute("paraId"); 
		var delRow = deleImg.parentNode.parentNode;
		OBJ.removeContractTargetMonth(id,delRow);
	}
	
	//一行中，各单元格返回的内容
	var cellTable=[
//					function(obj){return obj.contractTarget.industry.name},
					function(obj){return obj.yearDate},
					function(obj){return obj.monthDate},
					function(obj){return obj.monthTarg},
					function(obj){return obj.monthReal},
				    function(obj) {
				    	var editImg = makeImagHtml("../image/edit.png","Btn_editPrices","18","18",obj.id,"");
				    	if(OBJ.enableEdit) editImg.onclick = edit;
				    	return editImg;}, 
				    function(obj) {
						var deleImg = makeImagHtml("../image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"");
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
/* 总记录数
 * 
 */
ContractTargetMonth.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	ContractTargetMonthManager.getContractTargetMonthsCount(getCountFun,obj);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}

ContractTargetMonth.prototype.saveContractTargetMonth = function(o,mode){
//	alert(1);
	var OBJ = this;
	var obj = o;
	var id = obj.id;

	$("hiddenArea").appendChild($("monthDate"));
	$("hiddenArea").appendChild($("yearDate"));

	DWRUtil.getValues(obj);
	obj.id = id;
	
	obj.monthReal = 0;
	if (mode == 'new') obj.id = null;

//	alert(obj.contractTargetId);
	DWREngine.setAsync(false);
	ContractTargetMonthManager.saveContractTargetMonth(obj,saveFun);
	DWREngine.setAsync(true);
	
	function saveFun(newId){
		OBJ.reset();
		id = newId;
	}
	return id;
}
/* 删除
 * 根据id删除对象
 */
ContractTargetMonth.prototype.removeContractTargetMonth = function(id,delRow){
	var OBJ = this;
	var obj = this.obj;
	var page = this.page;
	var curRow = OBJ.tBody.rows.length;
	
	
	if (!checkEeitState('btn_SaveImgTd')) return false;
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	
	DWREngine.setAsync(false);
	ContractTargetMonthManager.removeContractTargetMonth(removeFun,id);	
	DWREngine.setAsync(true);
	
	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
   }
}
/* 添加新行 编辑或删除 
 * 
 */
ContractTargetMonth.prototype.addNewRow = function(mode,editRow){
    var OBJ = this;
    var obj = this.obj;
	var page = this.page;
	var tBody = this.tBody;
	
	if (!checkEeitState('btn_SaveImgTd')) return false;

	function getRowDataInObj(editRow){
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.contractTargetId = editRow.getAttribute("contractTargetId");
	 	obj.yearDate = editRow.getAttribute("yearDate");
	 	obj.monthDate = editRow.getAttribute("monthDate");
	 	obj.monthTarg = editRow.getAttribute("monthTarg");
	 	obj.monthReal = editRow.getAttribute("monthReal");
	 }	 
	 
	function save(event){
//		alert(0);
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");
		var id = saveImgTd.getAttribute("paraId");
		DWRUtil.getValues(obj);
		obj.id = id;
		OBJ.saveContractTargetMonth(obj,mode);
		
	}	 
	
	function cannel(event){
//		alert(2222);
		 OBJ.reset();
		 OBJ.getContractTargetMonths(contractTargetMonth);
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
		
	var saveImgTd = makeImagTd("../image/save.png","btn_SaveImgTd","18","18",obj.id,"");
	var cannelImgTd =makeImagTd("../image/restore.png","btn_CannelImgTd","18","18",0,"");
	
	cannelImgTd.onclick = function(){
	    newRow.remove(); 
    	setColors(tBody,this.color1,this.color2);
    }

//	cell[j++] =  makeTextTd(obj.contractTarget.industry.name);
	cell[j++] =  makeTdByObj($("yearDate"));
	cell[j++] =  makeTdByObj($("monthDate"));
	cell[j++] =  makeInputTextTd("monthTarg","text","10px",obj.monthTarg,"");
	cell[j++] =  makeTextTd(obj.monthReal);

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
		$("monthDate").value = obj.monthDate;
		$("yearDate").value = obj.yearDate;
	}else{
	//新添状态，直接追加新行
		if(tBody.rows.length == page.pageSize) DWRUtil.removeAllRows(tBody);
		tBody.appendChild(newRow);
		$("monthDate").value = '';
		$("yearDate").value = '';
	}
		
	//只能在新行添完后，才能给对象添加事件
	var btn_SaveImgTd = $("btn_SaveImgTd"); btn_SaveImgTd.onclick = saveContractTargetMonth;
	var btn_CannelImgTd = $("btn_CannelImgTd"); btn_CannelImgTd.onclick = cannelContractTargetMonth;	
	
	if(mode =='edit'){
		btn_SaveImgTd.setAttribute("mode","edit");
	}else{
		btn_SaveImgTd.setAttribute("mode","new")
	}

	setColors(tBody,this.color1,this.color2);
}
	
	