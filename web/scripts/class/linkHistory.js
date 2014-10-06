
function LinkHistory(){

	this.obj = {
		id:null,
		linkDate:null,
	    subject:null,
		linkManId:null,
	    counterpartMan:null,
	    memo:null,
		
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    customerId:null,
	    linkUser:null
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
LinkHistory.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.linkDate = null;
  	this.obj.subject = null;
  	this.obj.linkManId = null;
  	this.obj.counterpartMan = null;
  	
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.memo = null;
  	this.obj.customerId = null;
  	this.obj.linkUser = null;
}	

LinkHistory.prototype.getLinkHistorys = function(O,func){
	var OBJ = O;
	var obj = OBJ.obj;
	var page = OBJ.page;

    if (page.pageSize > 0){

		var size = this.getCount(obj);

		page.size = size;
		
		page.MakePageNav(page.pageIndex,page.pageInfo);
	
		LinkHisotryManager.getLinkHisotryPage(func,obj,page.pageIndex,page.pageSize);
    }else{
		LinkHisotryManager.getLinkHisotrys(func,obj);	
    }
}
LinkHistory.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	LinkHisotryManager.getLinkHisotryCount(getCountFun,obj);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}
LinkHistory.prototype.saveLinkHistory= function(o,func){
	LinkHisotryManager.saveLinkHisotry(func,o);
}

LinkHistory.prototype.saveCustomerLinkHisotry = function(o,func){
	LinkHisotryManager.saveCustomerLinkHisotryList(func,o);
}

LinkHistory.prototype.removeCustomerAddressById = function(id){
	LinkHisotryManager.removeLinkHisotry(id);		
}

LinkHistory.prototype.getlinkHistoryXML = function(obj,callBackFun){
	LinkHisotryManager.getlinkHistoryXML(callBackFun,obj);	
}

LinkHistory.prototype.removeLinkHistory = function(id,delRow){
	var OBJ = this;
	var page = this.page;
	var curRow = this.tBody.rows.length;
	var obj = this.obj;
	
	if (!checkEeitState('Btn_SaveLinkHisotry')) return false;
	
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	
	DWREngine.setAsync(false);
	LinkHisotryManager.removeLinkHisotry(removeFun,id);	
	DWREngine.setAsync(true);
	
	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
   }
}
LinkHistory.prototype.fillTable = function(objs){
	
	var OBJ = this;
	var obj = this.obj;
	var tBody  = this.tBody;
	var color1 = this.color1;
	var color2 = this.color2;
	
	
	
	//把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("subject", rowData.subject);
	 	row.setAttribute("linkDate", rowData.linkDate);
	 	row.setAttribute("linkManId", rowData.linkManId);
	 	row.setAttribute("counterpartMan", rowData.counterpartMan);
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
		OBJ.removeAgentInfo(id,delRow);
	}
	
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){return "<a href='editLinkHisotry.html?id=" +obj.id +"'>" + obj.subject +"</a>"},
					function(obj){return obj.linkDate},
					function(obj){return obj.linkUser.username},
					function(obj){return obj.counterpartMan},
				    function(obj) {
				    	var editImg = makeImagHtml("image/edit.png","Btn_editLinkHistory","18","18",obj.id,"");
				    	if(OBJ.enableEdit) editImg.onclick = edit;
				    	return editImg;}, 
				    function(obj) {
						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deleteLinkHistory","18","18",obj.id,"deletLinkHistory");
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

LinkHistory.prototype.addNewRow = function(mode,editRow){
    var OBJ = this;
    var obj = this.obj;
	var page = this.page;
	var tBody = this.tBody;
	
	if (!checkEeitState('Btn_SaveLinkHisotry')) return false;
	
	function getRowDataInObj(editRow){
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.subject = editRow.getAttribute("subject");
	 	obj.linkDate = editRow.getAttribute("linkDate");
	 	obj.linkManId = editRow.getAttribute("linkManId");
	 	obj.counterpartMan = editRow.getAttribute("counterpartMan");
	 }	 
	 
	function save(event){
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");
		var id = saveImgTd.getAttribute("paraId");

		DWRUtil.getValues(obj);
		obj.id = id;
	}	 
	
	function cannel(event){
		 OBJ.reset();
//		 OBJ.getPriceDetails();
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
		
	var saveImgTd = makeImagTd("image/save.png","Btn_SaveLinkHisotry","18","18",obj.id,"");
	var cannelImgTd =makeImagTd("image/restore.png","btn_CanneLinkHistory","18","18",0,"");
	
    
    cell[j++] =  makeInputTextTd("subject","text","10px",obj.subject,"")
    cell[j++] =  makeInputTextTd("linkDate","text","10px",obj.linkDate,"")
	cell[j++] =  makeTdByObj($("linkManId"));
	cell[j++] =  makeInputTextTd("counterpartMan","text","10px",obj.counterpartMan,"");
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
		$("linkManId").value = obj.linkManId;	
	}else{
	//新添状态，直接追加新行
		if(tBody.rows.length == page.pageSize) DWRUtil.removeAllRows(tBody);
		tBody.appendChild(newRow);
		$("linkManId").value = "";
	}
		
	//只能在新行添完后，才能给对象添加事件
	var btn_SaveImgTd = $("Btn_SaveLinkHisotry"); btn_SaveImgTd.onclick = saveAddandEditLinkHistory;
	var btn_CannelImgTd = $("btn_CanneLinkHistory"); btn_CannelImgTd.onclick = cannelAddandEditLinkHistory;	
	
	if(mode =='edit'){
		btn_SaveImgTd.setAttribute("mode","edit")
	}else{
		btn_SaveImgTd.setAttribute("mode","new")
	}

	setColors(tBody,this.color1,this.color2);
}







