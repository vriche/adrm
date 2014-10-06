

function LinkMan(){
	//创建对象
	this.obj ={
		id:null,
		linkmanName:null,
	    customerId:null,
	    isCustomerMain:null,
	    nickleName:null,
        
	    sex:null,
		birthdayYear:null,
		birthdayMonth:null,
	    birthdayDay:null,
	    anniYear:null,

	    anniMonth:null,
	    anniDay:null,
		jobTitle:null,
		companyWebsite:null,
	    homeCountry:null,

	    homeProvince:null,
	    homeCity:null,
	    homeScarriert:null,
		homeZip:null,
		companyCountry:null,

	    companyProvince:null,
	    companyCity:null,
	    companyScarriert:null,
	    companyZip:null,
	    homeTel:null,
  
	    officeTel:null,
	    mobile:null,
	    favorEmail:null,
	    bakEmail:null,
	    msn:null,
	    
		oicq:null,
		memo:null,
		enable:null,
		mainTel:null,
	    homePage:null,
	    customerName:null,

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
LinkMan.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.linkmanName = null;
  	this.obj.customerId = null;
  	this.obj.isCustomerMain = null;
  	this.obj.nickleName = null;
	
	this.obj.sex = null;
  	this.obj.birthdayYear = null;
  	this.obj.birthdayMonth = null;
  	this.obj.birthdayDay = null;
  	this.obj.anniYear = null;

	this.obj.anniMonth = null;
  	this.obj.anniDay = null;
  	this.obj.jobTitle = null;
  	this.obj.companyWebsite = null;
  	this.obj.homeCountry = null;

	this.obj.homeProvince = null;
  	this.obj.homeCity = null;
  	this.obj.homeScarriert = null;
  	this.obj.homeZip = null;
  	this.obj.companyCountry = null;
	
  	this.obj.companyProvince = null;
	this.obj.companyCity = null;
  	this.obj.companyScarriert = null;
  	this.obj.companyZip = null;
  	this.obj.homeTel = null;
	
  	this.obj.officeTel = null;
  	this.obj.mobile = null;
  	this.obj.favorEmail = null;
  	this.obj.bakEmail = null;
  	this.obj.msn = null;

  	this.obj.oicq = null;
  	this.obj.memo = null;
  	this.obj.enable = null;
  	this.obj.mainTel = null;
  	this.obj.homePage = null;
  	
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.customerName = null;
}

LinkMan.prototype.getLinkMans = function(O,func){
	var OBJ = O;
	var obj = OBJ.obj;
	var page = OBJ.page;

    if (page.pageSize > 0){

		var size = this.getCount(obj);

		page.size = size;
		
		page.MakePageNav(page.pageIndex,page.pageInfo);
	
		LinkManManager.getLinkManPage(func,obj,page.pageIndex,page.pageSize);
    }else{
		LinkManManager.getLinkMans(func,obj);	
    }
}
LinkMan.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	LinkManManager.getLinkManCount(getCountFun,obj);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}
LinkMan.prototype.saveLinkMan = function(o,func){
	LinkManManager.saveLinkMan(func,o);
}

LinkMan.prototype.saveCustomerLinkMan = function(o,func){
	LinkManManager.saveCustomerLinkMan(func,o);
}

LinkMan.prototype.removeCustomerLinkMan = function(id){
	LinkManManager.removeLinkMan(id);	
}

LinkMan.prototype.removeLinkMan = function(id,delRow){
	var OBJ = this;
	var page = this.page;
	var curRow = this.tBody.rows.length;
	var obj = this.obj;
	
	if (!checkEeitState('Btn_SaveLinkMan')) return false;
	
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	
	DWREngine.setAsync(false);
	LinkManManager.removeLinkMan(removeFun,id);	
	DWREngine.setAsync(true);
	
	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
   }
}
LinkMan.prototype.fillTableCS = function(objs){
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
	 	row.setAttribute("linkmanName", rowData.linkmanName);
	 	row.setAttribute("customerName", rowData.customerName);
	 	row.setAttribute("jobTitle", rowData.jobTitle);
	 	row.setAttribute("homeCountry", rowData.homeCountry);
	 	row.setAttribute("homeProvince", rowData.homeProvince);
	 	row.setAttribute("homeScarriert", rowData.homeScarriert);
	 	row.setAttribute("homeZip", rowData.homeZip);
	 	row.setAttribute("homeTel", rowData.homeTel);
	 	row.setAttribute("officeTel", rowData.officeTel);
	 	row.setAttribute("mobile", rowData.mobile);
	 	row.setAttribute("favorEmail", rowData.favorEmail);
	 	row.setAttribute("memo", rowData.memo);
	 }

	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){return obj.linkmanName},
					function(obj){return obj.customerName},
					function(obj){return obj.jobTitle},
					function(obj){return obj.homeCountry},
					function(obj){return obj.homeProvince},
					function(obj){return obj.homeScarriert},
					function(obj){return obj.homeZip},
					function(obj){return obj.homeTel},
					function(obj){return obj.officeTel},
					function(obj){return obj.mobile},
					function(obj){return obj.favorEmail},
					function(obj){return obj.memo},
//					function(obj){
//						
////						alert(obj.isCustomerMain);
//						var check = obj.isCustomerMain == 0 ? "" : "checked";
//						
////							alert(check);
//						 
//									return "<input type='radio' name='isCustomerMain' id='isCustomerMain' value='"+obj.isCustomerMain+"'"+check+">"},
////				   							return	makeRadioTd("isCustomerMain","radio","",obj.isCustomerMain,"");},
//				    function(obj) {
//				    	var editImg = makeImagHtml("image/edit.png","Btn_editLinkMan","18","18",obj.id,"");
//				    	if(OBJ.enableEdit) editImg.onclick = edit;
//				    	return editImg;}, 
//				    function(obj) {
//						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deleteLinkMan","18","18",obj.id,"delLinkMan");
////						if(OBJ.enableDel) deleImg.onclick = del;
//				    	return deleImg;} 
			];	
				
	//先删除 tbody		
	DWRUtil.removeAllRows(tBody);
	//再重新构造新的表
	DWRUtil.addRows(tBody,objs,cellTable,{
				rowCreator:function(options) {  
						   var row = document.createElement("tr"); 
				           putRowDataInHidden(row,options.rowData);
				           row.setAttribute("onclick","javascript:editInfo("+ options.rowData.id +")");
						   return row;  
					  },  
					  
				cellCreator:function(options) {  
						    var td = document.createElement("td"); 
						    td.style.cssText = "cursor: pointer;";
						    return td;  
					  }  
				});
				
	//给表格每一行上颜色，调用 global.js 中的setColors函数
	setColors(tBody, color1, color2);
}
LinkMan.prototype.fillTable = function(objs){
	
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
	 	row.setAttribute("linkmanName", rowData.linkmanName);
	 	row.setAttribute("homeTel", rowData.homeTel);
	 	row.setAttribute("officeTel", rowData.officeTel);
	 	row.setAttribute("mobile", rowData.mobile);
	 	row.setAttribute("favorEmail", rowData.favorEmail);
	 	row.setAttribute("isCustomerMain", rowData.isCustomerMain);
	 	
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
		OBJ.removeLinkMan(id,delRow);
	}
	
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){return "<a href='editLinkMan.html?id=" +obj.id +"'>" + obj.linkmanName +"</a>"},
					function(obj){return obj.homeTel},
					function(obj){return obj.officeTel},
					function(obj){return obj.mobile},
					function(obj){return obj.favorEmail},
					function(obj){
						
//						alert(obj.isCustomerMain);
						var check = obj.isCustomerMain == 0 ? "" : "checked";
						
//							alert(check);
						 
									return "<input type='radio' name='isCustomerMain' id='isCustomerMain' value='"+obj.isCustomerMain+"'"+check+">"},
//				   							return	makeRadioTd("isCustomerMain","radio","",obj.isCustomerMain,"");},
				    function(obj) {
				    	var editImg = makeImagHtml("image/edit.png","Btn_editLinkMan","18","18",obj.id,"");
				    	if(OBJ.enableEdit) editImg.onclick = edit;
				    	return editImg;}, 
				    function(obj) {
						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deleteLinkMan","18","18",obj.id,"delLinkMan");
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

LinkMan.prototype.addNewRow = function(mode,editRow){
    var OBJ = this;
    var obj = this.obj;
	var page = this.page;
	var tBody = this.tBody;
	
	if (!checkEeitState('Btn_SaveLinkMan')) return false;
	
	function getRowDataInObj(editRow){
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.linkmanName = editRow.getAttribute("linkmanName");
	 	obj.homeTel = editRow.getAttribute("homeTel");
	 	obj.officeTel = editRow.getAttribute("officeTel");
	 	obj.mobile = editRow.getAttribute("mobile");
	 	obj.favorEmail = editRow.getAttribute("favorEmail");
	 	obj.isCustomerMain = editRow.getAttribute("isCustomerMain");
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
		
	var saveImgTd = makeImagTd("image/save.png","Btn_SaveLinkMan","18","18",obj.id,"");
	var cannelImgTd =makeImagTd("image/restore.png","btn_CannelLinkMan","18","18",0,"");


		
	
    
    cell[j++] =  makeInputTextTd("linkmanName","text","10px",obj.linkmanName,"")
    cell[j++] =  makeInputTextTd("homeTel","text","10px",obj.homeTel,"")
	cell[j++] =  makeInputTextTd("officeTel","text","10px",obj.officeTel,"");
	cell[j++] =  makeInputTextTd("mobile","text","10px",obj.mobile,"");
	cell[j++] =  makeInputTextTd("favorEmail","text","10px",obj.favorEmail,"");
	cell[j++] =  makeRadioTd("isCustomerMain","radio","",obj.isCustomerMain,"");
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
	var btn_SaveImgTd = $("Btn_SaveLinkMan"); btn_SaveImgTd.onclick = saveAddandEditLinkMan;
	var btn_CannelImgTd = $("btn_CannelLinkMan"); btn_CannelImgTd.onclick = cannelAddandEditLinkMan;	
	
	if(mode =='edit'){
		btn_SaveImgTd.setAttribute("mode","edit")
	}else{
		btn_SaveImgTd.setAttribute("mode","new")
	}

	setColors(tBody,this.color1,this.color2);
}

LinkMan.prototype.resetMainLinkMan = function(cusId,func){
	
	LinkManManager.resetMainLinkMan(func,cusId);

}
LinkMan.prototype.getLinkManAutoComplet = function(obj,callBackFun){
	LinkManManager.getLinkMans(callBackFun,obj);	
}

LinkMan.prototype.getLinkManXML = function(obj,callBackFun){
	LinkManManager.getLinkManXML(callBackFun,obj);	
}

LinkMan.prototype.getLinkMan = function(func,id){
	LinkManManager.getLinkMan(func,id);
}

LinkMan.prototype.saveLinkManFormOrder = function(custId,linkmanName){
	        this.obj.id = null;
			this.obj.customerId = custId;
			this.obj.linkmanName = linkmanName;
			this.obj.homeTel = "";
			this.obj.officeTel = "";
			this.obj.mobile = "";
			this.obj.favorEmail = "";
			this.obj.isCustomerMain = 1;
			this.obj.version = 0;
			LinkManManager.saveCustomerLinkMan(this.obj);	
}



LinkMan.prototype.buildTextField = function(rederId,elname,width) {
	
		   new Ext.form.ComboBox({
	        store:  new Ext.data.Store(),
	        hideLabels:true,
	        id:elname,
	        name:elname,
	        width:width,
	        displayField:'name',
	         valueField:'id',
	        typeAhead: true,
	        forceSelection: true,
	        triggerAction: 'all',
	        fieldLabel: '请填写联系人',
	        emptyText:'请填写联系人...',
	        selectOnFocus:true,
	         mode: 'local',
	        renderTo:rederId
	    });	

//	new Ext.form.TextField({
//     id:elname,
//      name : elname,
//     width : width,
//      anchor:'25%' ,
////     width:"auto",
//     allowBlank : false,
//      renderTo:rederId,
//     blankText : '请填写联系人',
//     emptyText: '请填写联系人',
////     maskRe : new RegExp('[a-zA-Z0-9]', 'gi')
//     enableKeyEvents:true
//    });
}









