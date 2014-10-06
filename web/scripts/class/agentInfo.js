
function AgentInfo(){
	//创建对象
	
	this.obj = {
		id:null,
	    customerId:null,
	    agenetType:null,
	    resourcePriceTypeId:null,
	    industryTypeId:null,
	    agentRate:null,
	    beginDate:null,
	    endDate:null,
	    state:null,
	    industry:{name:null},
	    carrier:{carrierName:null},
	    resourceSort:{name:null},
	    category:{categoryName:null},
	    contractId:null,
	
	    createBy:null,				  //default sysdate
	    createDate:null,				  
	    modifyBy:null,				  //default sysdate
	    modifyDate:null,
	    carrierId:null,
	    resourceSortId:null,	
	    lowestRate:null,
	    enable:null,
	    customerCategoryId:null,			  
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
AgentInfo.prototype.reset = function(){
	
	this.obj.id = null;
	this.obj.customerId = null;
	this.obj.agenetType = null;
	this.obj.resourcePriceTypeId = null;
	this.obj.industryTypeId = null;
	this.obj.agentRate = null;
	this.obj.beginDate = null;
	this.obj.endDate = null;
	this.obj.state = null;
	this.obj.industry = null;
	this.obj.carrier = null;
	this.obj.resourceSort = null;
	
	this.obj.contractId = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.resourceSortId = null;
  	this.obj.carrierId = null;
  	this.obj.lowestRate = null;
  	this.obj.enable = null;
  	this.obj.customerCategoryId = null;
	
}
AgentInfo.prototype.getAgentInfoRate = function(getAgentInfoFun,customerId,industryTypeId){
	AgentInfoManager.getAgentInfoByCustIndus(customerId,industryTypeId,getAgentInfoFun);
}

AgentInfo.prototype.getAgentInfo = function(id){
	var OBJ = this;
	var obj = OBJ.obj;
	
	this.reset();
	DWRUtil.setValues(this.obj);
	DWREngine.setAsync(false);
	AgentInfoManager.getAgentInfo(id,setValueFun);
	DWREngine.setAsync(true);
	
	function setValueFun(o){
		DWRUtil.setValues(o);
		obj = o;
	}
	return obj;
}

AgentInfo.prototype.getAgentInfos = function(o){
	var OBJ = o;
	var obj = OBJ.obj;
	var page   = OBJ.page;
	
	

    if (page.pageSize > 0){

		var size = this.getCount(obj);

		page.size = size;
		
		page.MakePageNav(page.pageIndex,page.pageInfo);
	
		AgentInfoManager.getAgentInfosPage(obj,page.pageIndex,page.pageSize,OBJ.fillTalbe);
    }else{
		AgentInfoManager.getAgentInfos(obj,OBJ.fillTalbe);	
    }
}
 
AgentInfo.prototype.getAgentInfosByContractId = function(o,func){
	var OBJ = o;
	var obj = OBJ.obj;
	var page   = OBJ.page;
	
	

    if (page.pageSize > 0){

		var size = this.getCountByContractId(obj);
		
		page.size = size;
		
		page.MakePageNav(page.pageIndex,page.pageInfo);
		AgentInfoManager.getAgentInfosPage(obj,page.pageIndex,page.pageSize,func);
    }else{
		AgentInfoManager.getAgentInfos(obj,OBJ.fillTalbe);	
    }
}
  
//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
AgentInfo.prototype.fillTalbe = function(objs){	
	
	var OBJ = agentInfo;
	var obj = OBJ.obj;
	var tBody  = agentInfo.tBody;
	var color1 = agentInfo.color1;
	var color2 = agentInfo.color2;
	
	
	
	//把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	
	 	
	 	row.obj = rowData;
	 	
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("carrierId", rowData.carrierId);
	 	row.setAttribute("resourceSortId", rowData.resourceSortId);
	 	row.setAttribute("customerCategoryId", rowData.customerCategoryId);
	 	row.setAttribute("agentRate", rowData.agentRate);
	 	row.setAttribute("lowestRate", rowData.lowestRate);
	 }	
	 
	//编辑图标的触发的事件
	function edit(event){
		var e = event || window.event;
		var editImg = Event.element(e);
		var tr1= editImg.parentNode.parentNode;
		var id = tr1.getAttribute("paraId"); 
		
		var editRow = $(OBJ.IdPrefix + id);
		
//		alert("editRow=="+editRow);
		
		OBJ.addNewRow("edit",editRow);
	}
	//删除图标的触发的事件
	function del(event){
		var e = event || window.event;
		var deleImg = Event.element(e);
		var id = deleImg.getAttribute("paraId"); 
		var delRow = deleImg.parentNode.parentNode;
		OBJ.removeAgentInfo(id,delRow);
	}
	
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){return obj.carrier.carrierName},
					function(obj){return obj.resourceSort.name},
					function(obj){return obj.category.categoryName},
					function(obj){return ForDight(obj.agentRate*100,0) +"%" },
					function(obj){return ForDight(obj.lowestRate*100,0) +"%" },
				    function(obj) {
				    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"");
				    	if(OBJ.enableEdit) editImg.onclick = edit;
				    	return editImg;}, 
				    function(obj) {
						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"delAgentInfo");
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
AgentInfo.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	AgentInfoManager.getAgentInfosCount(obj,getCountFun);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}

AgentInfo.prototype.getCountByContractId = function(obj){
	var count;
	DWREngine.setAsync(false);
	AgentInfoManager.getAgentInfosCountByContractId(obj,getCountFun);	
    DWREngine.setAsync(true);
	function getCountFun(size){count =  size;}

    return count;
}

AgentInfo.prototype.saveAgentInfoCallBackFun = function(OBJ,callBackFun){
	var obj =  OBJ.obj;
	AgentInfoManager.saveAgentInfo(obj,callBackFun);
}

AgentInfo.prototype.saveAgentInfo = function(o,mode){
	
	var OBJ = this;
	var obj = o;
	var id = obj.id;
	
//	alert($("carrierId1").value);
//	
	$("hiddenArea").appendChild($("carrierSelect"));
	$("hiddenArea").appendChild($("resourceSortId"));
	$("hiddenArea").appendChild($("customerCategoryId"));

	DWRUtil.getValues(obj);
	obj.carrierId = $("carrierId1").value;
	obj.id = id;
	
	obj.contractId = $("contractId").value;

	if (mode == 'new') obj.id = null;
	agentInfo.obj.endDate=getFormatDay(agentInfo.obj.endDate,'ymd');
	DWREngine.setAsync(false);
	AgentInfoManager.saveAgentInfo(obj,saveFun);
	DWREngine.setAsync(true);
	
	function saveFun(newId){
		OBJ.reset();
		id = newId;
//		OBJ.getAgentInfos();
	}
	return id;
}
/* 删除
 * 根据id删除对象
 */
AgentInfo.prototype.removeAgentInfo = function(id,delRow){
	var OBJ = this;
	var obj = this.obj;
	var page = this.page;
	var curRow = OBJ.tBody.rows.length;
	
	
	if (!checkEeitState('btn_SaveAgentInfo')) return false;
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	
	DWREngine.setAsync(false);
	AgentInfoManager.removeAgentInfo(id,removeFun);	
	DWREngine.setAsync(true);
	
	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
//		OBJ.getAgentInfos();
   }
}
/* 添加新行 编辑或删除 
 * 
 */
AgentInfo.prototype.addNewRow = function(mode,editRow){
//	alert(editRow);
    var OBJ = this;
    var obj = this.obj;
	var page = this.page;
	var tBody = this.tBody;
	
	if (!checkEeitState('btn_SaveAgentInfo')) return false;
		
	function getRowDataInObj(editRow){
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.carrierId = editRow.getAttribute("carrierId");
	 	obj.resourceSortId = editRow.getAttribute("resourceSortId");
	 	obj.customerCategoryId = editRow.getAttribute("customerCategoryId");
	 	obj.agentRate = editRow.getAttribute("agentRate");
	 	obj.lowestRate = editRow.getAttribute("lowestRate");
	 }	 
	 
	function save(event){
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");
		var id = saveImgTd.getAttribute("paraId");
		DWRUtil.getValues(obj);
		obj.id = id;
		OBJ.saveAgentInfo(obj,mode);
	}	 
	
	function cannel(event){
		 OBJ.reset();
		 $("hiddenArea").appendChild($("carrierSelect"));
		 $("hiddenArea").appendChild($("resourceSortId"));
		 $("hiddenArea").appendChild($("customerCategoryId"));
		 OBJ.getAgentInfos(agentInfo);
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
		
	var saveImgTd = makeImagTd("image/save.png","btn_SaveAgentInfo","18","18",obj.id,"");
	var cannelImgTd =makeImagTd("image/restore.png","btn_CannelAgentInfo","18","18",0,"");
	
	cannelImgTd.onclick = function(){
		$("hiddenArea").appendChild($("carrierSelect"));
		$("hiddenArea").appendChild($("resourceSortId"));
		$("hiddenArea").appendChild($("customerCategoryId"));
	    newRow.remove(); 
    	setColors(tBody,this.color1,this.color2);
    }

	cell[j++] =  makeTdByObj($("carrierSelect"));
//	cell[j++] =  $("carrierId1").innerHTML;
//	cell[j++] =  makeInputTextTd("carrierId","text","10px",obj.carrierId,"");
	cell[j++] =  makeTdByObj($("resourceSortId"));
	cell[j++] =  makeTdByObj($("customerCategoryId"));
//	cell[j++] =  makeInputTextTd("resourceSortId","text","10px",obj.resourceSortId,"");
	cell[j++] =  makeInputTextTd("agentRate","text","5px",obj.agentRate,"");
	cell[j++] =  makeInputTextTd("lowestRate","text","5px",obj.lowestRate,"");

	cell[j++] =  saveImgTd;
	cell[j++] =  cannelImgTd;


	for (var i = 0;i < cell.length;i++ ){

		newRow.appendChild(cell[i]);
	}
	container.appendChild(newRow);

//	alert(editRow.obj);
//////////////////构造新行 end ///////////////////
//alert(newRow.obj);

	//编辑状态：追加新行，删除旧行	
	if(mode =='edit'){
		new Insertion.After(editRow,container.innerHTML);
		
		
		var new_row = $(obj.id);
		
		new_row.obj = editRow.obj;
		
		editRow.remove();
		
		$("carrierId1").value = obj.carrierId;
		$("resourceSortId").value = obj.resourceSortId;
		$("customerCategoryId").value = obj.customerCategoryId;	
	}else{
	//新添状态，直接追加新行
		if(tBody.rows.length == page.pageSize) DWRUtil.removeAllRows(tBody);
		tBody.appendChild(newRow);
		$("carrierId1").value = "";
		$("resourceSortId").value = "";
		$("customerCategoryId").value = "";
	}
		
	//只能在新行添完后，才能给对象添加事件
	var btn_SaveAgentInfo = $("btn_SaveAgentInfo"); btn_SaveAgentInfo.onclick = saveAgentInfo;
	var btn_CannelAgentInfo = $("btn_CannelAgentInfo"); btn_CannelAgentInfo.onclick = cannelAgentInfo;	
	
	if(mode =='edit'){
		btn_SaveAgentInfo.setAttribute("mode","edit")
	}else{
		btn_SaveAgentInfo.setAttribute("mode","new")
	}

	setColors(tBody,this.color1,this.color2);
}

AgentInfo.prototype.getAgentInfoByObj = function(func,obj){
	AgentInfoManager.getAgentInfoByObj(obj,func);
}	
	
AgentInfo.prototype.getTree = function(){

}	
	