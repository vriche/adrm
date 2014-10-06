
function IncomePull(){

	this.obj = {
		incomeId:null,
		resourceCarrierId:null,
		moneyPull:null,
		moneyIn:null,
		carrier:null,
		id:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    income:null,
	    
	    incomeDate:null,
	    moneyList:null,
	    incomeCode:null,
	    incomeMone:null,
	    arrearMoney:null,
	    customerName:null,
	    firstName:null,
	    lastName:null,
	    purposeName:null,
	    modeName:null,
	    memo:null
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
	
	this.enableEdit = true;
	this.enableDel = false;
	
	return this;	
}	



//清空对象
IncomePull.prototype.reset = function(){
	this.obj.incomeId = null;
  	this.obj.resourceCarrierId = null;
  	this.obj.moneyPull = null;
  	this.obj.moneyIn = null;
  	
  	this.obj.id = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.income = null;
    
    this.obj.resourceTypeId = null,
    
    this.obj.incomeDate = null,
	this.obj.incomeCode = null,
	this.obj.incomeMoney = null,
	this.obj.arrearMoney = null,
	this.obj.customerName = null,
	this.obj.firstName = null,
	this.obj.lastName = null,
	this.obj.purposeName = null,
	this.obj.modeName = null,
	this.obj.moneyList = null,
	this.obj.memo = null
}	
IncomePull.prototype.getIncomeMoneyList = function(orgId,putYear,userName,channelModelParam,customerId,carrierName,userId,start,end,purpose,arrears,func){
	IncomePullManager.getCustomerIncomeMoneyListGrid(orgId,putYear,userName,channelModelParam,customerId,carrierName,userId,start,end,purpose,arrears,func);
}

IncomePull.prototype.incomeMoneyFillTalbe= function(objs){
	var OBJ = incomePull;
	var obj = OBJ.obj;
	var tBody  = incomePull.tBody;
	var color1 = incomePull.color1;
	var color2 = incomePull.color2;
	
	 //把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
//	 	row.setAttribute("row",OBJ.IdPrefix + rowData.id);
//	 	row.setAttribute("paraId", rowData.id);
//	 	row.setAttribute("incomeDate", rowData.incomeDate);
//	 	row.setAttribute("incomeCode", rowData.incomeCode);
//	 	row.setAttribute("incomeMoney", rowData.incomeMoney);
//	 	row.setAttribute("customerId", rowData.customerId);
		row.setAttribute("rowData", rowData);
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
		OBJ.removeOrderCategory(id,delRow);
	}
//	alert(1);
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){
						var incomeDate = obj.incomeDate==""?"":getFormatDay(obj.incomeDate,'y/m/d');
						return incomeDate;
						},
					function(obj){ return obj.incomeCode},
					function(obj){ return obj.incomeMoney},
					function(obj){ return obj.moneyIn},
					
					
					function(obj){ return (config_withResourceSort==0)?obj.carrier.carrierName:obj.resourceType.name},
//					function(obj){ return obj.carrier.carrierName},
					
					
					function(obj){return obj.moneyPull},
					
				
					
					function(obj){ return obj.arrearMoney},
					function(obj){ return obj.customerName},
					function(obj){return obj.fullName},
					
					function(obj){ return obj.modeName},
					function(obj){return obj.purposeName},
					function(obj){ return obj.fullName},
					function(obj){return obj.memo},

			];	
	
	//先删除 tbody		
	DWRUtil.removeAllRows(tBody);
	//再重新构新的表
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

IncomePull.prototype.getIncomePullsByIncomeId = function(o,func){
		IncomePullManager.getIncomePulls(o,func);
}

IncomePull.prototype.addIncomePulls = function(func){
		incomePull.addNewRow('new',null);
		func();
}

IncomePull.prototype.removeIncomePullByIncomeId = function(incomeId,func){
	var OBJ = this;
		IncomePullManager.removeIncomePullByIncomeId(func,incomeId);
}

IncomePull.prototype.removeIncomePull = function(id,delRow){
	var OBJ = this;
//	var page = incomePull.page;
	var curRow = incomePull.tBody.rows.length;
	var func = function (objs){
		if(objs.length>0){
			alert("此项到款已分配不能删除！");
			return false;
		}
	}
//	IncomePullManager.checkRemoveIncomePullByIncomeUsed(func,id);
	
	if (!checkEeitState('btn_SaveIncomePull')) return false;
	
	if(!confirmDelete("")) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	
	DWREngine.setAsync(false);
	IncomePullManager.removeIncomePull(removeFun,id);	
	DWREngine.setAsync(true);
	
	function removeFun(){
		OBJ.reset();
		getIncomePullTable(income.obj.id);
//		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
//		OBJ.getContractPayments();
   }
}

//IncomePull.prototype.saveIncomePull = function(obj,mode,func){
//	if (mode == 'new')obj.id = null;
//		IncomePullManager.saveIncomePull(func,obj);
//}
IncomePull.prototype.saveIncomePull = function(obj,func){
		IncomePullManager.saveIncomePull(obj,func);
}

IncomePull.prototype.fillTalbe = function(objs){
	var OBJ = incomePull;
	var obj = OBJ.obj;
	var tBody  = incomePull.tBody;
	var color1 = "BACKGROUND-COLOR: #f5f5f5";
	var color2 = "BACKGROUND-COLOR: #ECEFF4";
	 //把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("moneyPull",rowData.moneyPull);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("resourceCarrierId", rowData.resourceCarrierId);
	 	if(this.tvNameParam =='fztv'){
	 		row.setAttribute("createBy", rowData.createBy);
	 		row.setAttribute("modifyBy", rowData.modifyBy);          
	 	}
	 	
	 	row.setAttribute("resourceTypeId", rowData.resourceTypeId);
	 	
	 	
	 	row.setAttribute("incomeId", rowData.incomeId);
//	 	row.setAttribute("incomeMoney", rowData.incomeMoney);
//	 	row.setAttribute("customerId", rowData.customerId);
		row.obj = rowData;
	 }	
	 
	//编辑图标的触发的事件
	function edit(event){
		if(moreChannelNoPullParam == 1) return false;
		var e = event || window.event;
		var editImg = Event.element(e);
		var id = editImg.getAttribute("paraId"); 
		var editRow = $(OBJ.IdPrefix + id);
		OBJ.addNewRow("edit",editRow);
	}
	//删除图标的触发的事件
	function del(event){
		if(moreChannelNoPullParam == 1) return false;
		var e = event || window.event;
		var deleImg = Event.element(e);
		var id = deleImg.getAttribute("paraId"); 
		var delRow = deleImg.parentNode.parentNode;
		var trs = incomePull.tBody.getElementsByTagName("tr");
		//var moneyIn = getCellValue(trs[i],2);
		var moneyIn = deleImg.obj.moneyIn== null||deleImg.obj.moneyIn==""?0:deleImg.obj.moneyIn;
		//alert(moneyIn);
		//var tr = getElementByEvent(event);
	        //alert(deleImg.obj.moneyIn);
	        //if(moneyIn!=0&&moneyIn!=''){
		if(moneyIn > 0){
			alert("此项到款已分配不能删除！");
			return false;
		}
		OBJ.removeIncomePull(id,delRow);
	}
	
	
	function formatNum(v){
		     v= v==null||v==''||v== undefined||v=='null'?v=0:v;
		     if(!isInteger(v)){
		     	 return v.toFixed(2); //00
		     }
		     return v;
//		     if(i == 0){
//		     	return v.toFixed(2);  // 00.00
//		     }else{
//		     	return v.toPrecision(2); //00
//		     }

	}
//	alert(1);
	//一行中，各单元格返回的内容
	var cellTable=[
//					function(obj){ return makeInputText(OBJ.radioName,"radio",obj.id,getTable)},
//					function(obj){ return obj.carrier.carrierName},
					function(obj){ return (config_withResourceSort==0)?obj.carrier.carrierName:obj.resourceType.name},
					function(obj){ return obj.moneyPull},
					function(obj){ return formatNum(obj.moneyIn)},
					function(obj){ return formatNum(obj.moneyPull - obj.moneyIn)},
//					function(obj){ return obj.incomeMoney},
//					function(obj){ 
////						if(obj.incomeUsed == obj.incomeMoney){
////							return 0;
////						}else{
//							return obj.incomeMoney-obj.incomeUsed
////						}
//					}
//					,
				    function(obj) {
				    	var editImg = makeImagHtml("image/edit.png","Btn_editIncomePull","18","18",obj.id,"");
					    	 editImg.onclick = edit;
				    	return editImg;}, 
				    function(obj) {
						var deleImg = makeImagHtml("image/button_delete.gif","Btn_delIncomePull","18","18",obj.id,"");
							 deleImg.onclick = del;
						deleImg.obj = obj;	 
				    	return deleImg;} 
			];
		if(this.tvNameParam=='fztv'){
				cellTable=[
					function(obj){  return (config_withResourceSort==0)?obj.carrier.carrierName:obj.resourceType.name},
					function(obj){ return obj.fullName},
					function(obj){ return obj.modifyBy},
					function(obj){ return obj.moneyPull},
					function(obj){ return obj.moneyIn},
					function(obj){ return obj.moneyPull - obj.moneyIn},

				    function(obj) {
				    	var editImg = makeImagHtml("image/edit.png","Btn_editIncomePull","18","18",obj.id,"");
					    	 editImg.onclick = edit;
				    	return editImg;}, 
				    function(obj) {
						var deleImg = makeImagHtml("image/button_delete.gif","Btn_delIncomePull","18","18",obj.id,"");
							 deleImg.onclick = del;
						deleImg.obj = obj;	 
				    	return deleImg;} 
				];
		}
       
	//先删除 tbody		
	DWRUtil.removeAllRows(tBody);
	//再重新构新的表
	DWRUtil.addRows(tBody,objs,cellTable,{
				rowCreator:function(options) { 
						   var row = document.createElement("tr"); 
				           putRowDataInHidden(row,options.rowData);
				           row.obj = options.rowData;
						   return row;  
					  },  
					  
				cellCreator:function(options) {
						    var td = document.createElement("td"); 
						    return td;  
					  }  
				});
				
	//给表格每一行上颜色，调用 global.js 中的setColors函数
	setColors(tBody, color1, color2);
	

	OBJ.sumRow(tBody);
}

IncomePull.prototype.sumRow = function(tBody){

	var moneyPull = 0;
	var moneyIn = 0;
	var leave = 0;
	var trs = tBody.getElementsByTagName("tr");
	var tbodySum = $("incomePullBodySum");
	DWRUtil.removeAllRows(tbodySum);
	
	if(trs.length<2) return false;
	if(this.tvNameParam=='fztv'){
		for(var i = 0;i<trs.length;i++){
		
		if(getCellValue(trs[i],3)!=0&&getCellValue(trs[i],3)!=''){
			 moneyPull = (moneyPull*100+getCellValue(trs[i],3)*100)/100;
		}
		if(getCellValue(trs[i],4)!=0&&getCellValue(trs[i],4)!=''){
			 moneyIn = (moneyIn*100+getCellValue(trs[i],4)*100)/100;
		}
	}	
			
	leave = (moneyPull*100 - moneyIn*100)/100;
	//alert(moneyPull);alert(moneyIn);
	
	var row = document.createElement("tr"); 
	for(var i = 0;i<5;i++){
	   var td = document.createElement("td"); 
	   if(i==0) td.innerHTML = "合计：";
	   if(i==3) td.innerHTML = (moneyPull==0)?"&nbsp":moneyPull;
	   if(i==4) td.innerHTML = (moneyIn==0)?"&nbsp":moneyIn;
	   if(i==5) td.innerHTML = leave;
	   row.appendChild(td);
	}
	}else{
		for(var i = 0;i<trs.length;i++){
		
			if(getCellValue(trs[i],1)!=0&&getCellValue(trs[i],1)!=''){
				 moneyPull = (moneyPull*100+getCellValue(trs[i],1)*100)/100;
			}
			if(getCellValue(trs[i],2)!=0&&getCellValue(trs[i],2)!=''){
				 moneyIn = (moneyIn*100+getCellValue(trs[i],2)*100)/100;
			}
		}
		
	leave = (moneyPull*100 - moneyIn*100)/100;
	//alert(moneyPull);alert(moneyIn);
	
	var row = document.createElement("tr"); 
//	alert(moneyPull+">>"+moneyIn+">>"+leave);
	for(var i = 0;i<5;i++){
	   var td = document.createElement("td"); 
	   if(i==0) td.innerHTML = "合计：";
	   if(i==1) td.innerHTML = (moneyPull==0)?"&nbsp":moneyPull;
	   if(i==2) td.innerHTML = (moneyIn==0)?"&nbsp":moneyIn;
	   if(i==3) td.innerHTML = leave;
	   row.appendChild(td);
	}
	}

	

	tbodySum.appendChild(row);
	
	
}

IncomePull.prototype.addNewRow = function(mode,editRow){

    var OBJ = this;
	var page = this.page;
	var tBody = this.tBody;
	var obj = this.obj;
	var color1 = "BACKGROUND-COLOR: #f5f5f5";
	var color2 = "BACKGROUND-COLOR: #ECEFF4";
	
	if (!checkEeitState('btn_SaveIncomePull')) return false;
	
	function getRowDataInObj(editRow){
		
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.incomeId = editRow.getAttribute("incomeId");
	 	obj.moneyPull = editRow.getAttribute("moneyPull");
	 	obj.resourceCarrierId = editRow.getAttribute("resourceCarrierId");
	 	obj.resourceTypeId = editRow.getAttribute("resourceTypeId");
	 	
	 	if(this.tvNameParam=='fztv'){
	 		obj.createBy = editRow.getAttribute("createBy");
	 		obj.modifyBy = editRow.getAttribute("modifyBy");
	 	}
	 	obj.moneyIn = editRow.obj.moneyIn;
//	 	obj.moneyList = editRow.getAttribute("moneyPay");
//	 	obj.moneyIn = editRow.getAttribute("moneyIn");
	 	
	 }	 

	//从编辑行中获得数据，来添对象
	if(mode =='edit'){
		getRowDataInObj(editRow);
	}else{
		 if(obj.moneyPull == null){
       	  var sumIn = $("incomeMoney").value*1;
       	  var tem = 0;
       	  var trs = $("incomePullBody").getElementsByTagName("tr");
       	  for(var i = 0; i < trs.length; i++) {
       	  	if(this.tvNameParam=='fztv'){
       	  		tem = (tem*100+getCellValue(trs[i],3)*100)/100;
       	  	}else{
       	  		tem = (tem*100+getCellValue(trs[i],1)*100)/100;
       	  	}
	     	  
	   		}  

       	  obj.moneyPull = (sumIn*100 - tem*100)/100;
    	 }
	}


//////////////////构造新行 start //////////////////
	
	var container = document.createElement("span");
	var newRow = document.createElement("tr");
	//给新行设置ID属性
	newRow.setAttribute("id",obj.id);
		
	var cell = []; var j = 0;
		
	var saveImgTd = makeImagTd("image/save.png","btn_SaveIncomePull","18","18",obj.id,"");
	var cannelImgTd =makeImagTd("image/restore.png","btn_CannelIncomePull","18","18",0,"");
	
	cannelImgTd.onclick = function(){
		if(config_withResourceSort == 0){
			$("hiddenArea").appendChild($("carrierName"));
		}else{
			$("hiddenAreaa2").appendChild($("resourceTypeName"));
		}
    	
    	
    	if(this.tvNameParam=='fztv'){
    		$("hiddenUser").appendChild($("createName"));
    	}  
	    newRow.remove(); 
    	setColors(tBody,color1,color2);
    }
    function makeTdByObjCarrierName(obj){
   		var td = document.createElement("td");  
   		
		td.appendChild(obj);
		td.setAttribute("align","right");
		return td;
   }
   


	
	if(config_withResourceSort == 0){
		
	    if(obj.moneyIn>0){
	        	$("carrierName").disabled = true;
	    }else{
	        	$("carrierName").disabled = false;
		}  
	
	}else{
	    if(obj.moneyIn>0){
	        	$("resourceTypeName").disabled = true;
	    }else{
	        	$("resourceTypeName").disabled = false;
		}  
	
	}
	if(config_withResourceSort == 0){
//		cell[j++] =  makeTdByObj($("carrierName"),obj.resourceCarrierId);
		cell[j++] =  makeTdByObj_test($("carrierName"),"15%");
	}else{
//		cell[j++] =  makeTdByObj($("resourceTypeName"),obj.resourceTypeId);
		cell[j++] =  makeTdByObj_test($("resourceTypeName"),"15%");
	}
	
	
	
	
	if(this.tvNameParam=='fztv'){
		cell[j++] =  makeTdByObjCarrierName($("createName"),obj.createBy);
		cell[j++] =  makeInputTextTd3("modifyBy","text","20px",obj.modifyBy,"");
	}
	cell[j++] =  makeInputTextTd3Money("moneyPull","text","20px",obj.moneyPull,"");
//	cell[j++] =  makeTextTd(obj.moneyIn);
//	var miTxt = makeInputText("moneyIn","text",obj.moneyIn,"");
//	miTxt.setAttribute("readonly",true);
	
	cell[j++] =  makeInputTextTd3Money("moneyIn","text","20px",obj.moneyIn,"",true);
	
//	cell[j++] =  document.createElement("td").appendChild(miTxt);
	//cell[j++] =  document.createElement("td");
	cell[j++] =  document.createElement("td");
	cell[j++] =  saveImgTd;
	cell[j++] =  cannelImgTd;

  
    
	for (var i = 0;i < cell.length;i++ ){
		newRow.appendChild(cell[i]);
	}
	

  	
	container.appendChild(newRow);
	

//	alert(editRow.obj);

	
//	alert(newRow.obj);
//////////////////构造新行 end ///////////////////

	
	//编辑状态：追加新行，删除旧行	
	if(mode =='edit'){
		new Insertion.After(editRow,container.innerHTML);
		
		var new_row = $(obj.id);
		
	
		
		new_row.obj = editRow.obj;
//		alert(new_row.obj);
		editRow.remove();
		if(config_withResourceSort == 0){
			$("carrierName").value = obj.resourceCarrierId;	
		}else{
			$("resourceTypeName").value = obj.resourceTypeId;	
		}
		
		if(this.tvNameParam=='fztv') $("createName").value = obj.createBy;
	}else{
	//新添状态，直接追加新行
//		if(tBody.rows.length == page.pageSize) DWRUtil.removeAllRows(tBody);
		tBody.appendChild(newRow);
		
		if(config_withResourceSort == 0){
			$("carrierName").value = 0;
		}else{
			$("resourceTypeName").value = 0;
		}
		
		if(this.tvNameParam=='fztv') $("createName").value = $("userId").value;
	}
		
	//只能在新行添完后，才能给对象添加事件
	var btn_SaveIncomePull = $("btn_SaveIncomePull"); btn_SaveIncomePull.onclick = saveIncome;
	var btn_CannelIncomePull = $("btn_CannelIncomePull"); btn_CannelIncomePull.onclick = cannelIncomePull;	
	
	if(mode =='edit'){
		btn_SaveIncomePull.setAttribute("mode","edit")
	}else{
		btn_SaveIncomePull.setAttribute("mode","new")
	}

	setColors(tBody,color1,color2);
//	    this.getDate();
}




IncomePull.prototype.saveIncomePullVersion = function(o,callbackFun){
		IncomePullManager.saveIncomePullVersion(o,callbackFun);
}


IncomePull.prototype.getIncomesPullsXML = function(o,callbackFun){
		IncomePullManager.getIncomesPullsXML(o,callbackFun);
}
IncomePull.prototype.getIncomesPullsXML2 = function(o,callbackFun){
		IncomePullManager.getIncomesPullsXML2(o,callbackFun);
}
IncomePull.prototype.getIncomesPullsXM3 = function(o,callbackFun){
		IncomePullManager.getIncomesPullsXM3(o,callbackFun);
}


IncomePull.prototype.getOrdersByIncomeId = function(id,callbackFun){
		IncomePullManager.getOrdersByIncomeId(id,callbackFun);
}
