

function Role(){
	//创建对象
	this.obj ={
		id:null,
		name:null,
		lable:null,
		description:null,
		rescs:[],
		users:[],
		rescsNo:[],
		usersNo:[]
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
Role.prototype.reset = function(){
	this.obj.id = null;
	this.obj.name = null;
	this.obj.lable = null;
	this.obj.description = null;
	this.obj.rescs = [];
	this.obj.users = [];
	this.obj.rescsNo = [];
	this.obj.usersNo = [];	
}

/*******************************************
*			对象的基本操作方法                
*******************************************/

Role.prototype.getRole = function(id){
	this.reset();
	DWRUtil.setValues(this.obj);
	RoleManager.getRole(setValueFun,id);
		
	function setValueFun(obj){
		DWRUtil.setValues(obj);
	}
}

Role.prototype.getRoles2 = function(type,name,fName,fId,styleClass1,styleClass2,event,without){
		DWREngine.setAsync(false);
	    RoleManager.getRoless(this.obj,callBackFun);	
		DWREngine.setAsync(true);

		
			
	function callBackFun(objs){

	        var parnetNode = $(name).parentNode;
	        var span = document.createElement("div");
	        span.setAttribute("id",name);
	 	   
			for(var i = 0;i < objs.length;i++){    

				eval("var filedName = objs[i]." + fName);
				eval("var filedId = objs[i]." + fId);
				eval("var fileddesc = objs[i].description");
				var input = document.createElement("input");
				var lab = document.createElement("label");
				var txt = document.createTextNode(filedName);
				var link = document.createElement("A");
				link.setAttribute("href","javascript:void 0");
				link.appendChild(document.createTextNode("明细")); 
				link.setAttribute("class","choice");
				link.onclick =function(){}
				
	
				
				input.setAttribute("type",type);
//				input.setAttribute("name","userRoles");
				input.setAttribute("id",name+filedId);
				input.setAttribute("value",filedId);
				input.setAttribute("onClick","javascript:"+ event +"(this)");
//				input.setAttribute("checked",true);
				input.setAttribute("class",styleClass1);
				

				lab.appendChild(txt);
	//			"choice" 竖排;
			
				lab.setAttribute("style","cursor: pointer;");
				lab.setAttribute("class",styleClass2);
				lab.setAttribute("for", name+filedId);
				lab.setAttribute("ext:qtip", "my tooltip3");
//				lab.onmouseover= function(){
//					alert(fileddesc);
//				
//				}
	
				var index = without.indexOf(filedId);
				if(index == -1){
					span.appendChild(input);
					span.appendChild(lab);	
//					span.appendChild(link);				
				}
			}
		    $(name).remove();
			parnetNode.appendChild(span);
			
	    
			
//			if(this.call_Back) this.call_Back();
	}	
		
	
	
	
}


Role.prototype.getRoleResUser = function(id){
	var resIds=[];
	var userIds=[];
	DWREngine.setAsync(false);
	RoleManager.getRoleById(setValueFun,id);
	DWREngine.setAsync(true);
	function setValueFun(obj){
		resIds  = obj.rescs;
		userIds = obj.users;
	}
	this.obj.rescs = resIds;
	this.obj.users = userIds;

	return this.obj;
}

/* 获得列表
 * obj 对象参数
 * fillObjName 界面 TBODY 的ID名
 */
Role.prototype.getRoles = function(O){
	var OBJ = O;
	var obj = OBJ.obj;
	var page   = OBJ.page;
	
    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		RoleManager.getRolesPage(OBJ.fillTalbe,obj,page.pageIndex,page.pageSize);
    }else{
		RoleManager.getRoless(OBJ.fillTalbe,obj);	
    }
}


	//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
Role.prototype.fillTalbe = function(objs){
		var OBJ = role;
		var tBody  = role.tBody;
		var color1 = role.color1;
		var color2 = role.color2;
		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("name", rowData.name);
		 	row.setAttribute("lable", rowData.lable);
		 	row.setAttribute("description", rowData.description);
		 	row.roleId = rowData.id;
		 }	
		 
		//编辑图标的触发的事件
		function edit(event){
			var e = event || window.event;
			var editImg = Event.element(e);
			var id = editImg.getAttribute("paraId"); 
			
//			alert(paraId);
//			alert(OBJ.IdPrefix);
			
//			var editRow = $(OBJ.IdPrefix + id);
			var editRow =  editImg.parentNode.parentNode;
			OBJ.addNewRow("edit",editRow);
		}
		//删除图标的触发的事件
		function del(event){
			var e = event || window.event;
			var deleImg = Event.element(e);
			var id = deleImg.getAttribute("paraId"); 
			var delRow = deleImg.parentNode.parentNode;
			OBJ.removeRole(id,delRow);
		}
		
		//一行中，各单元格返回的内容
		var cellTable=[
						function(obj){ return obj.name;},
						function(obj){ return obj.lable;},
						function(obj){ return obj.description;},
					    function(obj) {
					    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"");
					    	if(OBJ.enableEdit) editImg.onclick = edit;
					    	if(obj.name =='ROLE_ADMIN'){
					    		 return ;
					    	}else{
					    		return editImg;
					    	}
					    },	
					    function(obj) {

							var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"");
							if(OBJ.enableDel) deleImg.onclick = del;
					    	if(obj.name =='ROLE_ADMIN'){			    	
					    		return ;
					    	}else{
					    		return deleImg;
					    	}
							
					    } 
				];	
		
		//先删除 tobdy		
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
Role.prototype.saveRole = function(obj,mode){
	var OBJ = this;
	var obj =  this.obj;
	var id;
	
	if (mode == 'new') obj.id = null;
	
	DWREngine.setAsync(false);
	RoleManager.saveRole(obj,saveFun);
	DWREngine.setAsync(true);

	function saveFun(newId){
		OBJ.reset();
		id = newId;
		OBJ.getRoles(OBJ);
		if(role.callBakFun) role.callBakFun();
//		this.callBakFun();
	}
	return id;
}
/* 保存
 * 角色 用户 资源 关系
 */
Role.prototype.saveRoleUserRes = function(mode){
	var obj =  this.obj;
	var saveFunction = function(){};
	
//	DWREngine.setAsync(false);
	if (mode == 'resc'){
		if(obj.rescsNo != "") {
//			obj.users = null; obj.usersNo = null;
			DWREngine.setAsync(false);
			RoleManager.saveRoleUserRes(obj,saveFunction);
			DWREngine.setAsync(true);
		}
	}
	if (mode == 'user'){
//		obj.rescs = null; obj.rescsNo = null;
		if(obj.usersNo != "") {
			DWREngine.setAsync(false);
			RoleManager.saveRoleUserRes(obj,saveFunction);	
			DWREngine.setAsync(true);
		}
	
	}	
//	DWREngine.setAsync(true);
}







/* 删除
 * 根据id删除对象
 */
Role.prototype.removeRole = function(id,delRow){
	var OBJ = this;
	var page = role.page;
	var curRow = role.tBody.rows.length;
	var obj = this.obj;
	
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	RoleManager.removeRoleById(id,removeFun);	
	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
		OBJ.getRoles(OBJ);
		if(OBJ.callBakFun) OBJ.callBakFun();
   }
}
/* 总记录数
 * 
 */
Role.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	RoleManager.getRolesCount(getCountFun,obj);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}
/* 添加新行 编辑或删除 
 * 
 */
Role.prototype.addNewRow = function(mode,editRow){
    var OBJ = this;
	var page = this.page;
	var tBody = this.tBody;
	var obj = this.obj;
	
	if (!checkEeitState('btn_SaveImgTd')) return false;
	
	function getRowDataInObj(editRow){
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.name = editRow.getAttribute("name");
	 	obj.lable = editRow.getAttribute("lable");
	 	obj.description = editRow.getAttribute("description");
	 }	 
	 
	function save(event){
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");

		DWRUtil.getValues(obj);
		
//		if(mode !='edit'){
//			obj.name = "ROLE_"+Math.round(Math.random()*10000);
//		}
		
		OBJ.saveRole(obj,mode);
	}	 
	
	function cannel(event){
		 OBJ.reset();
		 OBJ.getRoles(OBJ);
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
		
	var saveImgTd = makeImagTd("image/save.png","btn_SaveImgTd","18","18",0,"");
	var cannelImgTd =makeImagTd("image/restore.png","btn_CannelImgTd","18","18",0,"");

	cell[j++] =  makeInputTextTdReadOnly("name","text","10px",obj.name,"");
	cell[j++] =  makeInputTextTd("lable","text","10px",obj.lable,"");
	cell[j++] =  makeInputTextTd("description","text","10px",obj.description,"");
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
	var btn_SaveImgTd =$("btn_SaveImgTd"); btn_SaveImgTd.onclick = save;
	var btn_CannelImgTd =$("btn_CannelImgTd"); btn_CannelImgTd.onclick = cannel;	
	
	if(mode =='edit'){
		btn_SaveImgTd.setAttribute("mode","edit")
	}else{
		btn_SaveImgTd.setAttribute("mode","new")
	}

	setColors(tBody,this.color1,this.color2);
}


/***********************************************
* 		       树形处理                               
************************************************/
/* 给树加载信息	
 * 先初始化树对象，再加载数据
 */
Role.prototype.getTreeXML = function(){
	var OBJ = this;
	var treeXMLString;

	DWREngine.setAsync(false);
	RoleManager.getRolesXML(this.obj,this.IdPrefix,getxml);
	DWREngine.setAsync(true);
	
	function getxml(treeXML){ 
//			alert(treeXML);
		OBJ.tree.treeXML = treeXML; 
		treeXMLString = treeXML;
	} 

    return treeXMLString;
}
//节点得到焦点，触发的事件
Role.prototype.doOnSelectGetRes = function(itemId){
	
	var dhtmlTree = this.tree.dhtmlTree;
	
	var id = OBJ.tree.getIdByPrefix(itemId,OBJ.IdPrefix);
	if(id !=-1) dhtmlTree.getRoleRes(id);
}


//节点改变时，触发的事件
Role.prototype.doOnTextChangeTree  = function(itemId){
	var dhtmlTree = this.tree.dhtmlTree;
	

}
//节点被拖动前，触发的事件
Role.prototype.doOnBeforeDropTree  = function(itemId,parentId){
	var dhtmlTree = this.tree.dhtmlTree;
}
















 	