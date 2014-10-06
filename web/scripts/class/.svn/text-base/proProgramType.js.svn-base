function ProProgramType(){
	//创建对象
	this.obj ={
		id:null,
		name:null,
	    parentId:null,
	    treeLevel:null,
	    displayNo:null,
	    
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
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
	this.curPopupWindow = null;
	this.rowNum = 1;
	
	return this;
}

//清空对象
ProProgramType.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.parentId = null;
  	this.obj.treeLevel = null;
  	this.obj.displayNo = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
}
	
	
ProProgramType.prototype.getProgramTypesXML = function(el,name,width) {
	ProProgramTypeManager.getProProgramTypes(setValueFun);
	
	function setValueFun(objs){
		 
		 var html="";
		html += "<select name='"+ name +"' id='"+ name +"' style='cursor: pointer;width:"+ width +"px;'  >";	
		html +="<option  value='0'>" + "==节目类别== " +"</option>";
		for(var i = 0;i<objs.length;i++){
			var value = objs[i].id;
			var lable = objs[i].name;
			var treeLevel = objs[i].treeLevel;
			
			if(treeLevel==2){
				html +="<option  value='"+ value +"'>" + "&nbsp;&nbsp;"+lable +"</option>";	
			}else{
				html +="<option  value='"+ value +"'>" + lable +"</option>";
			}		
		}
		html += "</select>";	
		el.innerHTML = html;
		
	}
}
ProProgramType.prototype.getProgramStatusXML = function(el,name,width) {
	ProProgramTypeManager.getProProgramStatusList(setValueFun);
	
	function setValueFun(objs){
		 
		 var html="";
		html += "<select name='"+ name +"' id='"+ name +"' style='cursor: pointer;width:"+ width +"px;'  >";	
		html +="<option  value='0'>" + "==节目状态== " +"</option>";
		for(var i = 0;i<objs.length;i++){
			var value = objs[i].id;
			var lable = objs[i].name;
			html +="<option  value='"+ value +"'>" + lable +"</option>";
		}
		html += "</select>";	
		el.innerHTML = html;		
	}
}


/* 给树加载信息	
 * 先初始化树对象，再加载数据
 */
ProProgramType.prototype.getTreeXML = function(callBackFun){
	var OBJ = this;
	var treeXMLString;
	ProProgramTypeManager.getProProgramTypesXML(this.obj,this.IdPrefix,getxml);
	
	function getxml(treeXML){ 
		OBJ.tree.treeXML = treeXML; 
		treeXMLString = treeXML;
		callBackFun(treeXMLString);
	} 
}

ProProgramType.prototype.getProgarmTypeTableXML = function(obj,callBackFun){
	ProProgramTypeManager.getProgarmTypeTableXML(callBackFun,obj);
}

ProProgramType.prototype.removeProProgramType = function(id){
	ProProgramTypeManager.removeProProgramType(id);
}

ProProgramType.prototype.saveProProgramType = function(obj,callBackFun){
	ProProgramTypeManager.saveProProgramType(saveFun,obj);

	function saveFun(newId){
		
		callBackFun(newId);
		
	}
}
ProProgramType.prototype.getProProgramTypeById = function(id,callBackFun){
	ProProgramTypeManager.getProProgramTypeById(callBackFun,id);
}


ProProgramType.prototype.saveProExpenseType = function(obj,callBackFun){
	ProProgramTypeManager.saveProExpenseType(saveFun,obj);

	function saveFun(newId){
		
		callBackFun(newId);
		
	}
}

ProProgramType.prototype.getProProgramStatusXML = function(obj,callBackFun){
	ProProgramTypeManager.getProProgramStatusXML(callBackFun,obj);
}
ProProgramType.prototype.getProProgramStatus = function(obj,callBackFun){
	ProProgramTypeManager.getProProgramStatus(callBackFun,obj);
}

ProProgramType.prototype.saveProProgramStatus = function(obj,callBackFun){
	ProProgramTypeManager.saveProProgramStatus(saveFun,obj);

	function saveFun(newId){
		
		callBackFun(newId);
		
	}
}
ProProgramType.prototype.removeProProgramStatus = function(id){
	ProProgramTypeManager.removeProProgramStatus(id);
}
ProProgramType.prototype.removeProExpenseType = function(id){
	ProProgramTypeManager.removeProExpenseType(id);
}
ProProgramType.prototype.getProExpenseTypeById = function(id,callBackFun){
	ProProgramTypeManager.getProExpenseTypeById(callBackFun,id);
}
ProProgramType.prototype.getProExpenseTypeXML = function(obj,callBackFun){
	ProProgramTypeManager.getProExpenseTypeXML(callBackFun,obj);
}

ProProgramType.prototype.getExpenseId = function(obj,callBackFun){
	ProProgramTypeManager.getExpenseId(callBackFun,obj);
}