function ProProgram(){
	//创建对象
	this.obj ={
		id:null,
		proName:null,
	    typeId:null,
	    copyrightNum:null,
	    startDate:null,
	    endDate:null,
	    customerId:null,
	    proProgramType:null,
	    proCustomer:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    businessName:null,
	    
	    isChecked:null,
	    sowCount:null,
	    arriveDate:null,
	    checkedDate:null,
	    audienceRat:null,
	    isSell:null,
	    copyrightArea:null,
	    price:null,
	    programStatusId:null,
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
	
	this.pageInfo =null ;
	this.pageSize =null ;
//	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	this.curPopupWindow = null;
	this.rowNum = 1;
	
	return this;
}

//清空对象
ProProgram.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.proName = null;
  	this.obj.typeId = null;
  	this.obj.copyrightNum = null;
  	this.obj.startDate = null;
  	this.obj.endDate = null;
  	this.obj.customerId = null;
  	this.obj.proProgramType = null;
  	this.obj.proCustomer = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.businessName = null;
  	
  	this.obj.isChecked = null;
	this.obj.sowCount = null;
	this.obj.arriveDate = null;
	this.obj.checkedDate = null;
	this.obj.audienceRat = null;
	this.obj.isSell = null;
	this.obj.copyrightArea = null;
	this.obj.price = null;
	this.obj.programStatusId = null;
}

ProProgram.prototype.getProgramNameXML = function(obj,callBackFun){
	ProProgramManager.getProgramNameXML(callBackFun,obj);
}

ProProgram.prototype.getProgramNameByOrderXML = function(obj,callBackFun){
	ProProgramManager.getProgramNameByOrderXML(callBackFun,obj);
}

ProProgram.prototype.getCopyrightNumXML = function(obj,callBackFun){
	ProProgramManager.getCopyrightNumXML(callBackFun,obj);
}

ProProgram.prototype.saveProProgram = function(obj,proCustomerName,customerTypeId,callBackFun){
	ProProgramManager.saveProProgramByName(callBackFun,obj,proCustomerName,customerTypeId);
}

ProProgram.prototype.getProgramByCustomerXML = function(cusName,callBackFun){
	ProProgramManager.getProgramByCustomerXML(callBackFun,cusName);
}

ProProgram.prototype.getProgramsPageXML = function(obj,dateType,callBackFun){
	 var obj = obj;
	    var page = this.page;
			
	    if (page.pageSize > 0){
	    		function getCountFun(size){ 
	    		
				page.size = size;
				page.MakePageNav(page.pageIndex,page.pageInfo);
				ProProgramManager.getProgramsPageXML(callBackFun,obj,dateType,page.pageIndex-1,page.pageSize);
			}
			ProProgramManager.getProProgramsCountByName(getCountFun,obj,dateType);	
	    }else{
			ProProgramManager.getProPrograms(callBackFun,obj);	
	    }
	
}


ProProgram.prototype.getProProgram = function(id,callBackFun){
	ProProgramManager.getProProgram(callBackFun,id);
}

ProProgram.prototype.getProProgramId = function(obj,callBackFun){
	ProProgramManager.getProProgramId(callBackFun,obj);
}

ProProgram.prototype.removeProProgram = function(id){
	ProProgramManager.removeProProgram(id);
}
ProProgram.prototype.makeSelectItemAnalyze = function(obj,name,event,callback){
	 obj.nodeLevel = 1;
	ProProgramManager.getProProgramAllFromMap(fillFun,obj,true,true);
	
	function fillFun(objs){
		makeSelectHtmlAnalyze(objs,name,event);
		if(callback) callback();
	}
}
ProProgram.prototype.getProgramXML = function(el,name,obj,callBackFun) {
	ProProgramManager.getProPrograms(obj,setValueFun);
	
	function setValueFun(objs){
		 
		 var html="";
		html += "<select name='"+ name +"' id='"+ name +"' style='cursor: pointer;width:140px;height:20px'>";	
		html +="<option  value='0'>" + "==节目名称== " +"</option>";
		for(var i = 0;i<objs.length;i++){
			var value = objs[i].id;
			var lable = objs[i].proName;
			html +="<option  value='"+ value +"'>" + lable +"</option>";
		}
		html += "</select>";	
		el.innerHTML = html;
		callBackFun();
		
	}
}
ProProgram.prototype.getProgramByOrderXML = function(el,name,obj,callBackFun) {
	ProProgramManager.getProProgramsByOrder(obj,setValueFun);
	
	function setValueFun(objs){
		 
		 var html="";
		html += "<select name='"+ name +"' id='"+ name +"' style='cursor: pointer;width:140px;height:20px'>";	
		html +="<option  value='0'>" + "==节目名称== " +"</option>";
		for(var i = 0;i<objs.length;i++){
			var value = objs[i].id;
			var lable = objs[i].proName;
			html +="<option  value='"+ value +"'>" + lable +"</option>";
		}
		html += "</select>";	
		el.innerHTML = html;
		callBackFun();
		
	}
}
ProProgram.prototype.getCustomerXML = function(el,name,id) {
	
	ProProgramManager.getProCustomerXML(setValueFun,id);
	
	function setValueFun(objs){

		 var html="";
		html += "<select name='"+ name +"' id='"+ name +"' style='cursor: pointer;width:140px;height:20px'>";	
		//html +="<option  value='0'>" + "==客户名称== " +"</option>";
		
			var value = objs.id;
			var lable = objs.customerName;
			html +="<option  value='"+ value +"'>" + lable +"</option>";		
		
		html += "</select>";	
		el.innerHTML = html;
		
	}
}
ProProgram.prototype.getProgramAllXML = function(el,name,obj,callBackFun) {
	
	ProProgramManager.getProProgramsAll(obj,setValueFun);
	
	function setValueFun(objs){
		 
		 var html="";
		html += "<select name='"+ name +"' id='"+ name +"' style='cursor: pointer;width:140px;height:20px'>";	
		html +="<option  value='0'>" + "==节目名称== " +"</option>";
		for(var i = 0;i<objs.length;i++){
			var value = objs[i].id;
			var lable = objs[i].proName;
			html +="<option  value='"+ value +"'>" + lable +"</option>";
		}
		html += "</select>";	
		el.innerHTML = html;
		callBackFun();
		
	}
}
