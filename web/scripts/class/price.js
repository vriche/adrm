
function Price(){

	this.obj = {
		id:null,
		name:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    memo:null,
	    
	    resourceType:null,
	    resourcePriceType:null,
	    moneyType:null,
	    isDefault:null,
	    isUseRegular:null,
	    resource:null,
	    priceDetails:null,
	    priceDetail:null,
	    
	    compages:null,
	    
	    priceType:null
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
Price.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.memo = null;
  	
  	this.obj.resourceType = null;
  	this.obj.resourcePriceType = null;
  	this.obj.moneyType = null;
  	this.obj.isDefault = null;
  	this.obj.isUseRegular = null;
  	this.obj.resource = null;
  	this.obj.priceDetails = null;
  	this.obj.priceDetail = null;
  	this.obj.priceType = null;
  	
  	this.obj.compages = null;
}	

Price.prototype.makeSelectItemAnalyze = function(obj,name,event){
	//DWREngine.setAsync(false);
	PriceManager.makeSelectItemAnalyze(fillFun,obj);
	//DWREngine.setAsync(true);
	
	function fillFun(objs){
		makeSelectHtmlAnalyze(objs,name,event);
	}
}


Price.prototype.getPricesForImport = function(obj,name,event){

	PriceManager.getPricesForImport(fillFun,obj);
	
	function fillFun(objs){
		makeSelectHtmlAnalyze(objs,name,event);
	}
}





Price.prototype.saveResourcePriceRel = function(resourceId,priceId,callback){
	PriceManager.saveResourcePriceRel(resourceId,priceId,callback);
}

Price.prototype.getPriceMap = function(resourceInfoId,matterLength,callBackFun){
//	var OBJ = price;
//	var obj = OBJ.obj;
	PriceManager.getPricesByResourceInfoAndLength(callBackFun,resourceInfoId,matterLength);
}

Price.prototype.getOnePriceFromCommand = function(selectCommand,type){
	var sysPrice = 0;
    var length = selectCommand.length;
 	if (length > 0){   
		for (var i=0; i<length;i++){
			if(selectCommand.item(i).value == type)  sysPrice = selectCommand.item(i).text;
		}	
 	}
 	return sysPrice;
}

Price.prototype.getPricesFromCommand = function(selectCommand){
	var prices = new Array();
    var length = selectCommand.length;
 	if (length > 0){   
		for (var i=0; i<length;i++){
			var index = selectCommand.item(i).value;
			var value = selectCommand.item(i).text;
			prices[index] = value;
		}	
 	}
 	return prices;
}

//Price.prototype.isPass = function(execPrice,selectCommand){
//	//销售价格		execPrice 3
//	//刊例价格		sysPrice  4 
//	//最低价格		priceBaseLine 5
//	//季节代理价格		monthAgentPrice 2
//	//正常代理价格		normalAgentPrice 1
//	var retValue = true;
//	    
//    var prices = this.getPricesFromCommand(selectCommand);
//    var normalAgentPrice = isUndefined(prices[1])? 0:prices[1];
//    var monthAgentPrice = isUndefined(prices[2])? 0:prices[2];
//    var priceBaseLine =isUndefined(prices[5])? 0:prices[5];
//    var sysPrice = isUndefined(prices[4])? 0:prices[4];
//    
////    alert(execPrice);
////    alert(normalAgentPrice);
////    alert(monthAgentPrice);
////    alert(priceBaseLine);
//    
//    if(normalAgentPrice > 0){
//      if(execPrice < normalAgentPrice) retValue = false;  	
//    }
//    if(monthAgentPrice > 0){
//     if(execPrice < monthAgentPrice) retValue = false;   	
//    }
//    if(priceBaseLine > 0){
//        if(execPrice < priceBaseLine) retValue = false;	
//    }
//
//    
//    return retValue;
//}

Price.prototype.isPass = function(value,lowestRate){
	var isPass = true;
	
//	if(lowestRate ==0 || lowestRate == '') isPass = true;
	lowestRate = lowestRate == null ? 0 : lowestRate;
	value = value == null ? 0 : value;

//	value = 100-value;
//	lowestRate =1- lowestRate/100;

//	alert(value);
//	alert(lowestRate);
	if(lowestRate > 0 && value < lowestRate && value != 1 && lowestRate != 1 && value != 0 && lowestRate != 0){
		isPass = false;
	}
	return isPass;
}

Price.prototype.savePriceByCompage = function(price,mode,func){
	var OBJ = price;
	var obj = OBJ.obj;
		
	if (mode == 'new') obj.id = null;
	PriceManager.savePriceByCompage(price.obj,func);
}

Price.prototype.getSysPriceByResId = function(resId,length,type){
	
	var sysPrice;
	
	DWREngine.setAsync(false);
	PriceManager.getSysPriceByResId(func,resId,length,type);
	DWREngine.setAsync(false);
	
	function func(price){
		sysPrice = price;
	}
	return sysPrice;
}

Price.prototype.getSysPriceByResId2 = function(resId,length,type,callBackFun){

	PriceManager.getSysPriceByResId(resId,length,type,func);
	
	function func(price){
		callBackFun(price);
	}
}

Price.prototype.removeCompagesPrice = function(priceId,func){
	PriceManager.removeCompagesPrice(func,priceId);
}
Price.prototype.removePrice = function(id,delRow){
	var OBJ = this;
	var page = this.page;
	var curRow = this.tBody.rows.length;
	var obj = this.obj;
	
	if (!checkEeitState('btn_SaveImgTd')) return false;
	
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	
	DWREngine.setAsync(false);
	PriceManager.removePrice(removeFun,id);	
	DWREngine.setAsync(true);
	
	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
   }
}
Price.prototype.removeResourcePriceRel = function(id,resourceId,delRow){
	var OBJ = this;
	var page = this.page;
	var curRow = this.tBody.rows.length;
	var obj = this.obj;
	
	if (!checkEeitState('btn_SaveImgTd')) return false;
	
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	
	DWREngine.setAsync(false);
	PriceManager.removeResourcePriceRel(removeFun,id,resourceId);	
	DWREngine.setAsync(true);
	
	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
   }
}


Price.prototype.getPricesByResId = function(resId,func){
	var page = this.page;	
		
    if (page.pageSize > 0){
		var size = this.getCountByResId(resId);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);	
		
		PriceManager.getPricePageByResoruceId(func,resId,page.pageIndex,page.pageSize);
    }
}
Price.prototype.savePrice = function(o,func){
	PriceManager.savePrice(func,o);
}

Price.prototype.getCountByResId = function(resId){
	var count;
	DWREngine.setAsync(false);
	PriceManager.getPriceCountByResoruceId(getCountFun,resId);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}
Price.prototype.getPriceDetailByPriceId = function(priceId,func){
	PriceManager.getPriceDetailByPriceId(func,priceId);
}
Price.prototype.fillTable = function(objs){
	var OBJ = price;
	var obj = OBJ.obj;
	var tBody  = price.tBody;
	var color1 = price.color1;
	var color2 = price.color2;
	
	
	
	//把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	
//	 	var rowIndex = options.rowIndex;
	 	
	 	row.setAttribute("id","pricesRow" + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("name", rowData.name);
	 	row.setAttribute("resourcePriceType", rowData.resourcePriceType);
	 	row.setAttribute("isDefault", rowData.isDefault);
	 	row.setAttribute("isUseRegular", rowData.isUseRegular);

//		if(rowIndex%2 == 0) { row.style.cssText="BACKGROUND-COLOR: #ECEFF4"}else{row.style.cssText="BACKGROUND-COLOR: #f5f5f5"};
	 }	
	 
	//编辑图标的触发的事件
	function edit(event){
		var e = event || window.event;
		var editImg = Event.element(e);
		var id = editImg.getAttribute("paraId"); 
		
		var editRow = $("pricesRow" + id);
		OBJ.addNewRow("edit",editRow);
	}
	//删除图标的触发的事件
	function del(event){
		var e = event || window.event;
		var deleImg = Event.element(e);
		var id = deleImg.getAttribute("paraId"); 
		var delRow = deleImg.parentNode.parentNode;
		OBJ.removePrice(id,delRow);
	}
	
	//一行中，各单元格返回的内容
	var cellTable = [
	    function(obj) { if(obj.isDefault == 1) return "&nbsp&nbsp&nbsp<img src=\"image/tick.png\">"},
	    function(obj) { return obj.name },
	  	function(obj) { return obj.priceType.priceTypeName},
	    function(obj) { if(obj.isUseRegular == 1) return "&nbsp&nbsp&nbsp<img src=\"image/tick.png\">"},
	    function(obj) {
	    	
	    		return "<a href='javascript:void 0' id=\"Btn_displayPriceDetailLink\" onclick=\"button_displayPriceDetail(this)\">显 示</a>"
	    	
	    	},
	    function(obj) { 
		                    var paraId = obj.id;
		                    var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",paraId,"");
					    	if(OBJ.enableEdit) editImg.onclick = edit;
		                    return editImg;
					  }, 
	    function(obj) { 
    	                    var paraId = obj.id;
    	                    var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",paraId,"deletePrice");
//    	                    if(OBJ.enableDel) deleImg.onclick = del;
    	                    return deleImg;
    				  } 
	];
				
	//先删除 tbody		
	DWRUtil.removeAllRows(tBody);
	//再重新构造新的表
	DWRUtil.addRows(tBody,objs,cellTable,{
				rowCreator:function(options) {  
						   var row = document.createElement("tr"); 
//						   
//						   var rowIndex = options.rowIndex;
//						   if(rowIndex%2 == 0) { row.style.cssText="BACKGROUND-COLOR: #ECEFF4"}else{row.style.cssText="BACKGROUND-COLOR: #f5f5f5"};
//						   
//						   alert(rowIndex);
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

Price.prototype.addNewRow = function(mode,editRow){
    var OBJ = this;
    var obj = this.obj;
	var page = this.page;
	var tBody = this.tBody;
	
	if (!checkEeitState('Btn_savePrices')) return false;
	
	function getRowDataInObj(editRow){
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.resourcePriceType = editRow.getAttribute("resourcePriceType");
	 	obj.name = editRow.getAttribute("name");
	 	obj.isDefault = editRow.getAttribute("isDefault");
	 	obj.isUseRegular = editRow.getAttribute("isUseRegular");
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
		
	var saveImgTd = makeImagTd("image/save.png","Btn_savePrices","18","18",obj.id,"");
	var cannelImgTd =makeImagTd("image/restore.png","btn_CannelImgTd","18","18",0,"");

    cell[j++] =  makeInputTextTd("isDefault","checkbox","",obj.isDefault,"");
    if(mode =='edit'){
          cell[j++] =  makeInputTextTD_TEST("name","text",obj.name,"",'20%');
    }else{
    	var resParentTxt = getResParentText();
        var v = resParentTxt+$("memo").value+"_"+ $("resourceName").value;
         cell[j++] =  makeInputTextTD_TEST("name","text",v,"",'20%');
//        cell[j++] =  makeInputText("name","text",$("resourceName").value,"");
    }
  
    
	cell[j++] =  makeTdByObj_test($("resourcePriceType"),"15%");
	cell[j++] =  makeInputTextTd("isUseRegular","checkbox","",obj.isUseRegular,"");
	cell[j++] =  makeTh("");

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
		$("resourcePriceType").value = obj.resourcePriceType;
	}else{
	//新添状态，直接追加新行
		if(tBody.rows.length == page.pageSize) DWRUtil.removeAllRows(tBody);
		tBody.appendChild(newRow);
		if(config_autoPriceTypeParam > 0){
			$("resourcePriceType").value = config_autoPriceTypeParam;
		}else{
			$("resourcePriceType").value = "1";
		}
		
		var change_resourceType = $("resourcePriceType");
		change_resourceType.onchange=selectResourceType;
	}
		
	//只能在新行添完后，才能给对象添加事件
	var btn_SaveImgTd = $("Btn_savePrices"); btn_SaveImgTd.onclick = saveAddandEditPrice;
	var btn_CannelImgTd = $("btn_CannelImgTd"); btn_CannelImgTd.onclick = cannelAddandEditPrice;	
	
	if(mode =='edit'){
		btn_SaveImgTd.setAttribute("mode","edit")
	}else{
		btn_SaveImgTd.setAttribute("mode","new");
	}

	setColors(tBody,this.color1,this.color2);
}

//Price.prototype.getPriceMap = function(resourceInfoId,matterLength){
//	var OBJ = price;
//	var obj = OBJ.obj;
//	
//	PriceManager.getPricesByResourceInfoAndLength(getPricesFun,resourceInfoId,matterLength);
//	
//	function getPricesFun(pricesMapInfo){
//		  DWRUtil.removeAllOptions("dtPricesAndType");
//		  DWRUtil.addOptions("dtPricesAndType", pricesMapInfo);
//		  //取值
//		  OBJ.setPriceFromList2Dest();
//
//	}
//}
//
////根据价格类别，从价格的列表中取价格类型相同的数放到桌面上
//Price.prototype.setPriceFromList2Dest = function(){
//
//	  var dtResourcePriceTypeId = $("resourcePriceType").value;
//	  
//      $("execPrice").value = 0;
//      $("sysPrice").value = 0;
//      $("dtPriceBaseLine").value = 0;
//  	  $("dtMonthAgentPrice").value = 0;
//  	  $("dtNormalAgentPrice").value = 0;
//      
//	  if(dtResourcePriceTypeId !='' && dtResourcePriceTypeId != 0){
//	  	 var length =$("dtPricesAndType").length;
//	  	 var obj = $("dtPricesAndType");
//	  	 var isFinedExecPrice ="false";
//	  	 var isFinedSysPrice ="false";
//	  	 var isFinedPriceBaseLine ="false";
//	  	 var isFinedNormalAgentPrice ="false";
//	  	 var isFinedMonthAgentPrice ="false";
//	  	 
//	  	 if (length > 0){
//	  	 	for (var i=0; i<length;i++){
//	  	 		//销售价格
//	  	 		if (dtResourcePriceTypeId == obj.item(i).value && isFinedExecPrice == "false"){
//	  	 			 $("execPrice").value = obj.item(i).text;
//	  	 			 isFinedExecPrice="true";
//	  	 		}
//				//刊例价格
//	  	 		if (4 == obj.item(i).value && isFinedSysPrice == "false"){
//	  	 			 $("sysPrice").value = obj.item(i).text;
//	  	 			 isFinedSysPrice="true";
//	  	 		}
//				//最低价格
//	  	 		if (5 == obj.item(i).value && isFinedPriceBaseLine == "false"){
//	  	 			 $("dtPriceBaseLine").value = obj.item(i).text;
//	  	 			 isFinedPriceBaseLine="true";
//	  	 		}		  	 		
//				//季节代理价格
//	  	 		if (2 == obj.item(i).value && isFinedMonthAgentPrice == "false"){
//	  	 			 $("dtMonthAgentPrice").value = obj.item(i).text;
//	  	 			 isFinedMonthAgentPrice="true";
//	  	 		}	
//				//正常代理价格
//	  	 		if (1 == obj.item(i).value && isFinedNormalAgentPrice == "false"){
//	  	 			 $("dtNormalAgentPrice").value = obj.item(i).text;
//	  	 			 isFinedNormalAgentPrice="true";
//	  	 		}	
//	  	 	}
//	  	 	
//	  	 }else{
//	  	 	$("execPrice").value = 0;
//	  	 	$("sysPrice").value = 0;
//	  	 	$("dtPriceBaseLine").value = 0;
//	  	 	$("dtMonthAgentPrice").value = 0;
//	  	 	$("dtNormalAgentPrice").value = 0;
//	  	 }
//
//	  }
//}	 
