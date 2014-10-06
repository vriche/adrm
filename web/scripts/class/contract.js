

function Contract(){
	//创建对象
	this.obj ={
		carrierId:null,
		id:null,
		customerId:null,
	    owner:null,
	    code:null,																				
	    signUser:null,
	    moneySum:null,
	    moneyIn:null,
	    moneyExec:null,
	    csignDate:null,
	    state:null,
	    startDate:null,
	    endDate:null,
	    contractType:null,
	    notifyDays:null,
	    isLimitOrder:null,
	    contractSort:null,
	    userId:null,
	    osignDate:null,
	    memo:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    signHeadship:null,
	    memoRenew:null,
	    version:null,
	    
	    customerCategoryId:null,
	    customer:null,
	    ownerUser:null
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
	
	this.radioName = null;
	
	this.pageInfo =""
	this.pageSize ="20"
	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	
	return this;
}

//清空对象
Contract.prototype.reset = function(){
	this.obj.carrierId=null;
	this.obj.id=null;
	this.obj.customerId=null;
	this.obj.owner=null;
	this.obj.code=null;																				
	this.obj.signUser=null;
	this.obj.moneySum=null;
	this.obj.moneyIn=null;
	this.obj.moneyExec=null;
	this.obj.csignDate=null;
	this.obj.state=null;
	this.obj.startDate=null;
	this.obj.endDate=null;
	this.obj.contractType=null;
	this.obj.notifyDays=null;
	this.obj.isLimitOrder=null;
	this.obj.contractSort=null;
	this.obj.userId=null;
	this.obj.osignDate=null;
	this.obj.memo=null;
	this.obj.createBy=null;
	this.obj.createDate=null;
	this.obj.modifyBy=null;
	this.obj.modifyDate=null;
	this.obj.signHeadship=null;
	this.obj.memoRenew=null;
	this.obj.version=null;
	
	this.obj.radioName=null;
	
	this.obj.customerCategoryId=null;
	this.obj.customer = null;
	this.obj.ownerUser = null;
}

/*******************************************
*			对象的基本操作方法                
*******************************************/

/* 获得列表
 * obj 对象参数
 * fillObjName 界面 TBODY 的ID名
 */
Contract.prototype.getContract = function(getContractFun,id){
//	var OBJ = this;
//	
//	this.reset();
//	DWRUtil.setValues(this.obj);
	ContractManager.getContract(id,getContractFun);
		
//	function setValueFun(obj){
//		DWRUtil.setValues(obj);
//		OBJ.obj = obj;
//	}
}
 
Contract.prototype.getContracts = function(){
	var OBJ = this;
	var obj = this.obj;
	var page   = this.page;

    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		ContractManager.getContractsPage(obj,page.pageIndex,page.pageSize,OBJ.fillTalbe);
    }else{
		ContractManager.getContracts(obj,OBJ.fillTalbe);	
    }
}
Contract.prototype.getContractsByType = function(OBJ,callBackFun){
	var obj = OBJ.obj;
	var page   = OBJ.page;
 	function makePage(size){
			page.size = size;
			page.MakePageNav(page.pageIndex,page.pageInfo);
	 }

    if (page.pageSize > 0){
				this.getCountType(obj,makePage);
				ContractManager.getContractsPage(obj,page.pageIndex,page.pageSize,callBackFun);
		
    }else{
				ContractManager.getContracts(obj,callBackFun);	
   		 } 



	
}
Contract.prototype.getContractsAll = function(callBackFun,obj){
	ContractManager.getContracts(callBackFun,obj);	
}
Contract.prototype.getContractsByCusId = function(O,func){
	var OBJ = O;
	var obj = OBJ.obj;
	var page = OBJ.page;

    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		ContractManager.getContractsPage(obj,page.pageIndex,page.pageSize,func);
    }else{
		ContractManager.getContracts(obj,func);	
    }
}

//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
Contract.prototype.fillTalbe = function (objs){
	var OBJ = this;
	var tBody  = contract.tBody;
	var color1 = contract.color1;
	var color2 = contract.color2;
		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("code", rowData.code);
		 	row.setAttribute("customerId", rowData.customerId);
		 	row.setAttribute("moneyExec", rowData.moneyExec);
		 	row.setAttribute("startDate", rowData.startDate);
		 	row.setAttribute("endDate", rowData.endDate);
		 	row.setAttribute("userId", rowData.userId);
		 	row.setAttribute("state", rowData.state);
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
			OBJ.removeContract(id,delRow);
		}

						
		
		//一行中，各单元格返回的内容
		var cellTable=[
						function(obj){return makeInputText(OBJ.checkBoxName,"checkBox",obj.id)},
						//function(obj){return '<a href="javascript:void 0" onClcheckboxick="editInfo('+ obj.id +')">' + obj.code +'</a>'},
						function(obj){return "<a href=editContract.html?id="+ obj.id +" target=_bank>" + obj.code +'</a>'},
						function(obj){return obj.customer.customerName},
						function(obj){return obj.moneyExec},
						function(obj){return formatDateGlobal(obj.startDate)},
						function(obj){return formatDateGlobal(obj.endDate)},
						function(obj){return (obj.ownerUser.firstName + obj.ownerUser.lastName)},
						function(obj){return '<a href="javascript:void 0" onClick="autoBroArrange('+ obj.id +')">'+"结果明系"},
						function(obj){return obj.checkState.name},
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
//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
Contract.prototype.fillTalbeByType = function (objs){
	var OBJ = this;
	var tBody  = contract.tBody;
	var color1 = contract.color1;
	var color2 = contract.color2;
		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.rowData = rowData;
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
			OBJ.removeContract(id,delRow);
		}
		
		//一行中，各单元格返回的内容
		var cellTable=[
						function(obj){
							
							if(obj.state == 0 || obj.state == 4)
								return makeInputText(OBJ.checkBoxName,"checkbox",obj.id);
							},
//						function(obj){return '<a href="javascript:void 0" onClick="editInfo(\'' + obj.id + '\',\'' + obj.customer.customerCategoryId+ '\')">' + obj.code +'</a>'},
						function(obj){return obj.code},
						function(obj){return obj.customer.customerName},
						
//						function(obj){return "<a href='editCustomer.html?id="+ obj.customer.id +"' target='_blank'>" + obj.customer.customerName +'</a>'},
						function(obj){return (obj.contractSort==0)?"协约":"协议"},
						function(obj){return obj.ownerUser.fullName},
						function(obj){return obj.moneySum},
						//function(obj){return obj.moneyExec},
						function(obj){return obj.moneyIn},
						function(obj){return getFormatDay(obj.startDate+"",'y/m/d');},
						function(obj){return getFormatDay(obj.endDate+"",'y/m/d');},
						function(obj){return obj.checkState.name},
//					    function(obj) {
//					    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"");
//					    	if(OBJ.enableEdit) editImg.onclick = edit;
//					    	return editImg;}, 
//					    function(obj) {
//							var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"");
//							if(OBJ.enableDel) deleImg.onclick = del;
//					    	return deleImg;} 
				];	
		
		//先删除 tbody		
		DWRUtil.removeAllRows(tBody);
		//再重新构造新的表
		DWRUtil.addRows(tBody,objs,cellTable,{
					rowCreator:function(options) {  
							   var row = document.createElement("tr"); 
//							   row.setAttribute("onclick","javascript:editInfo(\'' + options.rowData.id + '\',\'' + options.rowData.customer.customerCategoryId+ '\')");
//					           row.setAttribute("onclick","javascript:editInfo("+ options.rowData.id +"," + options.rowData.customerCategoryId+ ")");
					           putRowDataInHidden(row,options.rowData);
					           
							   return row;  
						  },  
						  
					cellCreator:function(options) {  
							    var td = document.createElement("td"); 
							     td.setAttribute("onclick","javascript:editInfo("+ options.rowData.id +"," + options.rowData.customerCategoryId+ "," + options.rowData.orgId+",this)");
							    td.style.cssText = "cursor: pointer;";	 
							    return td;  
						  }  
					});
					
		//给表格每一行上颜色，调用 global.js 中的setColors函数
		setColors(tBody, color1, color2);
	}
	
//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
Contract.prototype.fillTalbeByCusId = function (objs){
	var OBJ = this;
	var tBody  = contract.tBody;
	var color1 = contract.color1;
	var color2 = contract.color2;
		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("code", rowData.code);
		 	row.setAttribute("moneySum", rowData.moneySum);
		 	row.setAttribute("moneyExec", rowData.moneyExec);
		 	row.setAttribute("moneyIn", rowData.moneyIn);
		 	row.setAttribute("startDate", rowData.startDate);
		 	row.setAttribute("endDate", rowData.endDate);
		 	row.setAttribute("state", rowData.state);
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
			OBJ.removeContract(id,delRow);
		}
		
		//一行中，各单元格返回的内容
		var cellTable=[
						function(obj){return '<a href="javascript:void 0" onClick="editInfo('+ obj.id +')">' + obj.code +'</a>'},
						function(obj){return obj.moneySum},
						function(obj){return obj.moneyExec},
						function(obj){return obj.moneyIn},
						function(obj){return obj.startDate},
						function(obj){return obj.endDate},
						function(obj){return obj.checkState.name},
						function(obj){return ""},
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


Contract.prototype.saveContract = function(O,callBackFun){
	
	ContractManager.saveContract(O.obj,saveFun);
	function saveFun(newId){
		if(newId*1 > 0){
			callBackFun(newId);
		}else{
			alert("保存失败!");
		}
	}
}


Contract.prototype.saveContractReturnObj = function(O,callBackFun){
	
	
	ContractManager.saveContractReturnObj(O.obj,saveFun);
	
	function saveFun(obj){
		if(obj.id  > 0){
			callBackFun(obj);
		}else{
			alert("保存失败!");
		}
	}
}
/* 删除
 * 根据id删除对象
 */
Contract.prototype.removeContract = function(id,delRow){
	var OBJ = this;
	var obj = this.obj;
	var page = contract.page;
	var curRow = OBJ.tBody.rows.length;
	
	
	if (!checkEeitState('btn_SaveImgTd')) return false;
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	ContractManager.removeContract(id,removeFun);	
	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
//		OBJ.getContracts();
   }
}

Contract.prototype.removeContractR = function(removeFun,id){
	
	ContractManager.removeContract(id,removeFun);
}
/* 总记录数
 * 
 */
Contract.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	ContractManager.getContractsCount(obj,getCountFun);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}

Contract.prototype.getCountType = function(obj,callBackFun){
	ContractManager.getContractsCount(obj,getCountFun);	
	function getCountFun(size){ callBackFun(size);}
}

/* 添加新行 编辑或删除 
 * 
 */
Contract.prototype.addNewRow = function(mode,editRow){
    var OBJ = this;
    var obj = this.obj;
	var page = this.page;
	var tBody = this.tBody;
	
	if (!checkEeitState('btn_SaveImgTd')) return false;
		
	function getRowDataInObj(editRow){
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.payNumber = editRow.getAttribute("code");
	 	obj.payDate = editRow.getAttribute("moneySum");
	 	obj.incomePurposeId = editRow.getAttribute("moneyExec");
	 	obj.moneyPay = editRow.getAttribute("moneyIn");
	 	obj.moneyIn = editRow.getAttribute("startDate");
	 	obj.moneyPay = editRow.getAttribute("endDate");
	 	obj.moneyIn = editRow.getAttribute("state");
	 }	 
	 
	function save(event){
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");
		var id = saveImgTd.getAttribute("paraId");
		DWRUtil.getValues(obj);
		obj.id = id;
		OBJ.saveContract(obj,mode);
	}	 
	
	function cannel(event){
		 OBJ.reset();
		 OBJ.getContracts();
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
	
	cannelImgTd.onclick = function(){
	    newRow.remove(); 
    	setColors(tBody,color1,color2);
    }
        
	cell[j++] =  makeInputTextTd("code","text","10px",obj.code,"");
	cell[j++] =  makeInputTextTd("moneySum","text","10px",obj.moneySum,"");
	cell[j++] =  makeInputTextTd("moneyExec","text","10px",obj.moneyExec,"");
	cell[j++] =  makeInputTextTd("moneyIn","text","10px",obj.moneyIn,"");
	cell[j++] =  makeDateInputTextTd("publishStartDate","anchorWStart",obj.startDate,"button_showdate_input");
	cell[j++] =  makeDateInputTextTd("publishEndDate","anchorWEnd",obj.endDate,"button_showdate_input");
	cell[j++] =  makeInputTextTd("state","text","10px",obj.state,"");
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
	var btn_SaveImgTd = $("btn_SaveImgTd"); btn_SaveImgTd.onclick = save;
	var btn_CannelImgTd = $("btn_CannelImgTd"); btn_CannelImgTd.onclick = cannel;	
	
	if(mode =='edit'){
		btn_SaveImgTd.setAttribute("mode","edit")
	}else{
		btn_SaveImgTd.setAttribute("mode","new")
	}

	setColors(tBody,this.color1,this.color2);
}


Contract.prototype.getContractsByWorkFlowCount = function(workFlowId,state){
	var count;
	DWREngine.setAsync(false);
	ContractManager.getContractsByWorkFlowCount(workFlowId,state,getCountFun);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}

Contract.prototype.getContractsByWorkFlowPage = function(workFlowId,state,callbak){ 
	var OBJ = this;
	var obj = this.obj;
	var page   = this.page;

    if (page.pageSize > 0){
		var size = this.getContractsByWorkFlowCount(workFlowId,state);

		function call(objs){
			page.size = objs.length;
			page.MakePageNav(page.pageIndex,page.pageInfo);
			OBJ.fillTalbe(objs);
			if(callbak) callbak();
		}
		ContractManager.getContractsByWorkFlowPage(workFlowId,state,page.pageIndex,page.pageSize,call);
    }else{
		ContractManager.getContracts(obj,OBJ.fillTalbe);	
    }    
 
}

Contract.prototype.updateContractStates = function(ids,state){ 
	var saveFunction = function(){};
		if(ids != "" && state !="") {
			DWREngine.setAsync(false);
			ContractManager.updateContractStates(ids,state,saveFunction);
			DWREngine.setAsync(true);
		}	
}

Contract.prototype.getContractPaymentAutoComplet = function(O,callBackFun){
	ContractManager.getContractPaymentAutoComplet(O.obj,callBackFun);
}

Contract.prototype.getcontractXML = function(obj,callBackFun){
	ContractManager.getcontractXML(obj,callBackFun);	
}
 	