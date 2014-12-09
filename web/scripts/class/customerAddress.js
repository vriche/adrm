
function CustomerAddress(){

	this.obj = {
		id:null,
		addressType:null,
		customerId:null,
		address:null,
		city:null,
		province:null,
		country:null,
		postalCode:null,
		oaAreaCity:null,
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
CustomerAddress.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.addressType = null;
  	this.obj.customerId = null;
  	this.obj.address = null;
  	this.obj.city = null;
  	this.obj.province = null;
  	this.obj.country = null;
  	this.obj.postalCode = null;
  	this.obj.oaAreaCity = null,
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
}

CustomerAddress.prototype.getCustomerAddresss = function(O,func){
	var OBJ = O;
	var obj = OBJ.obj;
	var page = OBJ.page;

    if (page.pageSize > 0){

		var size = this.getCount(obj);

		page.size = size;
		
		page.MakePageNav(page.pageIndex,page.pageInfo);
	
		CustomerAddressManager.getCustomerAddressPage(func,obj,page.pageIndex,page.pageSize);
    }else{
		CustomerAddressManager.getCustomerAddresss(obj,func);	
    }
}

CustomerAddress.prototype.getCustomerAddresssXML= function(cusId,callBackFun){
	CustomerAddressManager.getCustomerAddresssXML(cusId,getxml);
	function getxml(treeXML){ 
		callBackFun(treeXML);
	} 
}

CustomerAddress.prototype.saveCustomerAddress = function(o,func){
	CustomerAddressManager.saveCustomerAddressList(o,func);
}

CustomerAddress.prototype.saveCustomerAddressFormOrder = function(custId,province){
			this.obj.id = null;
			this.obj.customerId = custId;
			this.obj.addressType = "";
			this.obj.address = "";
			this.obj.city =  "";
			this.obj.country = "中国";
			this.obj.postalCode = "";
			this.obj.province = province;
			this.obj.version = 0;
			CustomerAddressManager.saveCustomerAddressList(this.obj);
}

CustomerAddress.prototype.saveCustomerAddressFormOrder2 = function(custId,province,address){
	this.obj.id = null;
	this.obj.customerId = custId;
	this.obj.addressType = "";
	this.obj.address = address;
	this.obj.city =  "";
	this.obj.country = "中国";
	this.obj.postalCode = "";
	this.obj.province = province;
	this.obj.version = 0;
	CustomerAddressManager.saveCustomerAddressList(this.obj);
}

CustomerAddress.prototype.removeCustomerAddressById = function(id){
	CustomerAddressManager.removeCustomerAddress(id);	
}


CustomerAddress.prototype.removeCustomerAddress = function(id,delRow){
	var OBJ = this;
	var page = this.page;
	var curRow = this.tBody.rows.length;
	var obj = this.obj;
	
	if (!checkEeitState('Btn_SaveCustomerAddress')) return false;
	
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	
	DWREngine.setAsync(false);
	CustomerAddressManager.removeCustomerAddress(removeFun,id);	
	DWREngine.setAsync(true);
	
	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
   }
}
CustomerAddress.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	CustomerAddressManager.getCustomerAddressCount(getCountFun,obj);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}

CustomerAddress.prototype.fillTable = function(objs){
	
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
	 	row.setAttribute("addressType", rowData.addressType);
	 	row.setAttribute("address", rowData.address);
	 	row.setAttribute("city", rowData.city);
	 	row.setAttribute("country", rowData.country);
	 	row.setAttribute("postalCode", rowData.postalCode);
	 	row.setAttribute("province", rowData.province);
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
		OBJ.removeCustomerAddress(id,delRow);
	}
	
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){return obj.addressType},
					function(obj){return obj.address},
					function(obj){return obj.city},
					function(obj){return obj.country},
					function(obj){return obj.postalCode},
					function(obj){return obj.oaAreaCity.name},
				    function(obj) {
				    	var editImg = makeImagHtml("image/edit.png","Btn_editCustomerAddress","18","18",obj.id,"");
				    	if(OBJ.enableEdit) editImg.onclick = edit;
				    	return editImg;}, 
				    function(obj) {
						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deleteCustomerAddress","18","18",obj.id,"delCustomerAddress");
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

CustomerAddress.prototype.addNewRow = function(mode,editRow){
    var OBJ = this;
    var obj = this.obj;
	var page = this.page;
	var tBody = this.tBody;
	
	if (!checkEeitState('Btn_SaveCustomerAddress')) return false;
	
	function getRowDataInObj(editRow){
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.addressType = editRow.getAttribute("addressType");
	 	obj.address = editRow.getAttribute("address");
	 	obj.city = editRow.getAttribute("city");
	 	obj.country = editRow.getAttribute("country");
	 	obj.postalCode = editRow.getAttribute("postalCode");
	 	obj.province = editRow.getAttribute("province");
	 }	 
	 
	function save(event){
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");
		var id = saveImgTd.getAttribute("paraId");

		DWRUtil.getValues(obj);
		obj.id = id;

//		OBJ.savePriceDetail(obj,mode);
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
		
	var saveImgTd = makeImagTd("image/save.png","Btn_SaveCustomerAddress","18","18",obj.id,"");
	var cannelImgTd =makeImagTd("image/restore.png","btn_CannelCustomerAddress","18","18",0,"");
	
    
    cell[j++] =  makeInputTextTd("addressType","text","10px",obj.addressType,"")
    cell[j++] =  makeInputTextTd("address","text","10px",obj.address,"")
	cell[j++] =  makeInputTextTd("city","text","10px",obj.city,"");
	cell[j++] =  makeTdByObj($("country"));
	cell[j++] =  makeInputTextTd("postalCode","text","10px",obj.postalCode,"");
	//cell[j++] =  makeInputTextTd("province","text","10px",obj.province,"");
	cell[j++] =  makeTdByObj($("province"));
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
		$("country").value = obj.country;
		$("province").value = obj.province;	
	}else{
	//新添状态，直接追加新行
		if(tBody.rows.length == page.pageSize) DWRUtil.removeAllRows(tBody);
		tBody.appendChild(newRow);
		$("country").value = "";
	}
		
	//只能在新行添完后，才能给对象添加事件
	var btn_SaveImgTd = $("Btn_SaveCustomerAddress"); btn_SaveImgTd.onclick = saveAddandEditCustomerAddress;
	var btn_CannelImgTd = $("btn_CannelCustomerAddress"); btn_CannelImgTd.onclick = cannelAddandEdit;	
	
	if(mode =='edit'){
		btn_SaveImgTd.setAttribute("mode","edit")
	}else{
		btn_SaveImgTd.setAttribute("mode","new")
	}

	setColors(tBody,this.color1,this.color2);
}

CustomerAddress.prototype.buildOfficeTelField = function(rederId,elname,width) {
	
	new Ext.form.ComboBox({
     store:  new Ext.data.Store(),
     hideLabels:true,
     id:elname,
     name:elname,
     width:width,
     displayField:'name',
      valueField:'id',
     typeAhead: true,
     forceSelection: false,
     triggerAction: 'all',
     fieldLabel: '请填地址',
     emptyText:'请填写地址...',
     selectOnFocus:true,
      mode: 'local',
     renderTo:rederId
 });	

}

