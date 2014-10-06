

function Target(){
	//创建对象
	this.obj ={
		id:null,
		carrier:{carrierName:null},
		industry:{name:null},
		carrierId:null,
		contractId:null,
		industryTypeId:null,
		target:null
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
Target.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.carrier= null;
  	this.obj.industry = null;
  	this.obj.carrierId = null;
  	this.obj.contractId = null;
  	this.obj.industryTypeId = null;
  	this.obj.target = null;
}

/*******************************************
*			对象的基本操作方法                
*******************************************/

/* 获得列表
 * obj 对象参数
 * fillObjName 界面 TBODY 的ID名
 */
Target.prototype.getTargets = function(func){
	var OBJ = this;
	var obj = this.obj;
	var page   = this.page;

    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		ContractTargetManager.getContractTargetsPage(func,obj,page.pageIndex,page.pageSize);
    }else{
		ContractTargetManager.getContractTargets(OBJ.fillTalbe,obj);	
    }
}
//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
Target.prototype.fillTalbe = function(objs){	
	
	var OBJ = target;
	var obj = OBJ.obj;
	var tBody  = target.tBody;
	var color1 = target.color1;
	var color2 = target.color2;
	
	
	
	//把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	
	 	
	 	row.obj = rowData;
	 	
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("carrierId", rowData.carrierId);
	 	row.setAttribute("industryTypeId", rowData.industryTypeId);
	 	row.setAttribute("target", rowData.target);
	 	row.setAttribute("target", rowData.target);
	 }	
	 
	//编辑图标的触发的事件
	function edit(event){
		var e = event || window.event;
		var editImg = Event.element(e);
		var tr1= editImg.parentNode.parentNode;
		var id = tr1.getAttribute("paraId");
		var editRow = $(OBJ.IdPrefix + id);
		target.addNewRow("edit",editRow);
	}
	//删除图标的触发的事件
	function del(event){
		var e = event || window.event;
		var deleImg = Event.element(e);
		var id = deleImg.getAttribute("paraId"); 
		var delRow = deleImg.parentNode.parentNode;
		OBJ.removeTarget(id,delRow);
	}
	
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){ return obj.carrier.carrierName;},
					function(obj){return obj.industry.name},
					function(obj){return obj.target},
					function(obj){return '<a href="javascript:void 0" onClick="autoBroArrange('+ obj.id +')">'+"月投放量"},
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
Target.prototype.saveTargetCallBackFun = function(OBJ,callBackFun){
	var obj =  OBJ.obj;
	ContractTargetManager.saveContractTarget(obj,saveFun);
	function saveFun(newId){
		callBackFun(newId);
	}
}
/* 保存
 * obj 组装好数据的对象
 * mode 保存模式  状态为 new 时必须设置 id = null
 */
Target.prototype.saveTarget = function(o,mode){
	var OBJ = this;
	var obj =  o;
	var id = obj.id;
	
	$("hiddenArea").appendChild($("carrierSelect"));
	$("hiddenArea").appendChild($("industryTypeId"));

	DWRUtil.getValues(obj);
	obj.id = id;
	obj.carrierId = $("carrierId1").value;
	obj.contractId = $("contractId").value;

	if (mode == 'new') obj.id = null;
	
	DWREngine.setAsync(false);
	ContractTargetManager.saveContractTarget(obj,saveFun);
	DWREngine.setAsync(true);
	
	function saveFun(newId){
		OBJ.reset();
		id = newId;
//		OBJ.getTargets();
	}
	return id;
}
/* 删除
 * 根据id删除对象
 */
Target.prototype.removeTarget = function(id,delRow){
	var OBJ = this;
	var page = target.page;
	var curRow = target.tBody.rows.length;
	var obj = this.obj;
	
	if (!checkEeitState('btn_SaveConTarget')) return false;
	
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	
	DWREngine.setAsync(false);
	ContractTargetManager.removeContractTarget(removeFun,id);
	DWREngine.setAsync(true);
		
	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
//		OBJ.getTargets();
   }
}
/* 总记录数
 * 
 */
Target.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	ContractTargetManager.getContractTargetsCount(getCountFun,obj);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}
/* 添加新行 编辑或删除 
 * 
 */
Target.prototype.addNewRow = function(mode,editRow){
    var OBJ = this;
	var page = this.page;
	var tBody = this.tBody;
	var obj = this.obj;
	
	if (!checkEeitState('btn_SaveConTarget')) return false;
	
	function getRowDataInObj(editRow){
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.carrierId = editRow.getAttribute("carrierId");
	 	obj.industryTypeId = editRow.getAttribute("industryTypeId");
	 	obj.target = editRow.getAttribute("target");
	 }	 
	 
	function save(event){
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");
		var id = saveImgTd.getAttribute("paraId");
		DWRUtil.getValues(obj);
		obj.id = id;
		OBJ.saveTarget(obj,mode);
	}	 
	
	function cannel(event){
		 OBJ.reset();
		 $("hiddenArea").appendChild($("carrierSelect"));
		 $("hiddenArea").appendChild($("industryTypeId"));
		 OBJ.getTargets();
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
		
	var saveImgTd = makeImagTd("image/save.png","btn_SaveConTarget","18","18",obj.id,"");
	var cannelImgTd =makeImagTd("image/restore.png","btn_CannelConTarget","18","18",0,"");
	
	cannelImgTd.onclick = function(){
		$("hiddenArea").appendChild($("carrierSelect"));
		$("hiddenArea").appendChild($("industryTypeId"));
	    newRow.remove(); 
    	setColors(tBody,this.color1,this.color2);
    }
        
	cell[j++] =  makeTdByObj($("carrierSelect"));
	cell[j++] =  makeTdByObj($("industryTypeId"));
	cell[j++] =  makeInputTextTd("target","text","10px",obj.target,"");
	cell[j++] =  makeTextTd("");
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
		
		var new_row = $(obj.id);
		
		new_row.obj = editRow.obj;
		
		editRow.remove();	
		$("carrierId1").value = obj.carrierId;	
		$("industryTypeId").value = obj.industryTypeId;	
	}else{
	//新添状态，直接追加新行
		if(tBody.rows.length == page.pageSize) DWRUtil.removeAllRows(tBody);
		tBody.appendChild(newRow);
		$("carrierId1").value = "";	
		$("industryTypeId").value = "";	
	}
		
	//只能在新行添完后，才能给对象添加事件
	var btn_SaveConTarget = $("btn_SaveConTarget"); btn_SaveConTarget.onclick = saveTarget;
	var btn_CannelConTarget = $("btn_CannelConTarget"); btn_CannelConTarget.onclick = cannelTarget;	
	
	if(mode =='edit'){
		btn_SaveConTarget.setAttribute("mode","edit")
	}else{
		btn_SaveConTarget.setAttribute("mode","new")
	}

	setColors(tBody,this.color1,this.color2);
}

 	