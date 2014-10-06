

function User(){
	//创建对象
	this.obj ={
		id:null,
		username:null,
		password:null,
		passwordHint:null,
		firstName:null,
		lastName:null,
		fullName:null,
		email:null,
		phoneNumber:null,
		website:null,
		address:null,
		version:null,
		roles:null,
		branchId:null,
		branchs:null,
		enabled:null,
		accountExpired:null,
		accountLocked:null,
		credentialsExpired:null,
		encryptPass:false
	}
    this.className = null;
	this.treebox = null;
	this.tree = null;
	this.tableName = null;	
	this.selectName =null;
	this.roleTable = null;
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
	
	this.roleId = null;
	
	this.encryptPass = false;
	
	this.fileds =
	[
			{name: "id", type: "int"},
			{name: "username", type: "string"},
			{name: "fullName", type: "string"},
			{name: "firstName", type: "string"},
			{name: "lastName", type: "string"},
			{name: "branchId", type: "int"}
	];

	
	return this;
}

//清空对象
User.prototype.reset = function(){
	this.obj.id = null;
	this.obj.username = null;
	this.obj.password = null;
	this.obj.passwordHint = null;
	this.obj.confirmPassword = null;
	this.obj.firstName = null;
	this.obj.lastName = null;
	this.obj.fullName = null;
	this.obj.email = null;
	this.obj.phoneNumber = null;
	this.obj.website = null;
	this.obj.address = new Address();
	this.obj.version = null;
	this.obj.roles = null;
	this.obj.branchId = null;
	this.obj.branchs = null;
	this.obj.enabled = null;
	this.obj.accountExpired = null;
	this.obj.accountLocked = null;
	this.obj.credentialsExpired = null;
	this.obj.orgId = null;
	this.obj.loginUser = null;
}
User.prototype.backupObject = function(sourObj,targObj){
	targObj.id = sourObj.id;
  	targObj.username = sourObj.username;
  	targObj.password = sourObj.password;
  	targObj.firstName = sourObj.firstName;
  	targObj.lastName = sourObj.lastName;
  	targObj.fullName = sourObj.fullName;
  	return 	targObj;

}



/*******************************************
*			对象的基本操作方法                
*******************************************/

User.prototype.getUser = function(O,id,callBackFun){
	var OBJ = O;
	var obj = O.obj;
//	this.reset();
//	DWRUtil.setValues(this.obj);
//    DWREngine.setAsync(false);
	UserManager.getUser(setValueFun,id);
//	DWREngine.setAsync(true);
		
	function setValueFun(o){
		DWRUtil.setValues(o);
		DWRUtil.setValues(o.address);
		O.obj = o;
		obj = o;
		if(callBackFun) callBackFun();
	}
	return obj;
}


User.prototype.getUserByOrg = function(callBackFun){
	UserManager.getUserByOrg(setValueFun,this.obj);
	function setValueFun(obj){
		if(callBackFun) callBackFun(obj);
	}
}



User.prototype.createOpenFireUser = function(){
	function fun(){
		alert('完成');
	}
  UserManager.createOpenFireUser(fun);
}

User.prototype.getLinkUser = function(id){
	var OBJ = this;
	var obj = this.obj;
//	this.reset();
//	DWRUtil.setValues(this.obj);
    DWREngine.setAsync(false);
	UserManager.getUser(setValueFun,id);
	DWREngine.setAsync(true);
		
	function setValueFun(o){
		DWRUtil.setValues(o);
		obj = o;
	}
	return obj;
}

/* 获得列表
 * obj 对象参数
 * fillObjName 界面 TBODY 的ID名
 */
User.prototype.getUsers = function(){
	var OBJ = this;
	var obj = this.obj;
	var page   = this.page;

    if (page.pageSize > 0){
    	
		var size = this.getCount(obj);

		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		UserManager.getUsersPage(OBJ.fillTalbe,obj,page.pageIndex,page.pageSize);
    }else{
		UserManager.getUsers(OBJ.fillTalbe,obj);	
    }
    
//    this.loadDataCheckBox();
}


User.prototype.delUserInBranch = function(fun){
	  UserManager.removeUserInBranch(removeFun,this.obj);
	  function removeFun(){
	  	if(fun) fun();
	  }
}

	//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
User.prototype.fillTalbe = function(objs){
	var OBJ = this;
	var tBody  = user.tBody;
	var color1 = user.color1;
	var color2 = user.color2;

		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("username", rowData.username);
		 	row.setAttribute("firstName", rowData.firstName);
		 	row.setAttribute("lastName", rowData.lastName);
		 	row.setAttribute("email", rowData.email);
		 	row.setAttribute("enabled", rowData.enabled);
		 	row.setAttribute("branchId", rowData.branchId);
		 
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
			OBJ.removeUser(id,delRow);
		}
		

		


			var	cellTable=[
								function(obj){ return makeInputText(OBJ.checkBoxName,"checkbox",obj.id)},
								function(obj){ return obj.username;},
								function(obj){ return obj.fullName;},
								function(obj){ return obj.email;},  
								function(obj){ return obj.branchName;}, 
								function(obj){ return makeOptitions("neable","checkbox",obj.enabled,null,true);},
								 function(obj) {
									var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"removeUserInBranch");
//									deleImg.onclick = removeUserInBranch;
							    	return deleImg;},
							    	
							    function(obj) {
							    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"editUser");
							    	if(OBJ.enableEdit) editImg.onclick = edit;
							    	return editImg;}, 
							    function(obj) {
									var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"delUser");
									if(OBJ.enableDel) deleImg.onclick = del;
							    	return deleImg;} 
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
User.prototype.saveUser = function(saveUserFunction){

	UserManager.saveUser(this.obj,saveFun);

	function saveFun(newId){
		saveUserFunction(newId);
	}

}



User.prototype.saveUserRel = function(orgId,parentUserId,userids,callBackFun){

	UserManager.saveUserRel(orgId,parentUserId,userids,saveFun);

	function saveFun(){
		callBackFun();
	}
}

User.prototype.saveUserRelByParent = function(orgId,parentUserIds,userId,callBackFun){

	UserManager.saveUserRelByParent(orgId,parentUserIds,userId,saveFun);

	function saveFun(){
		callBackFun();
	}
}


User.prototype.getUserRel = function(orgId,parentUserId,callBack){

	UserManager.getUserRel(orgId,parentUserId,getFun);
	
	function getFun(ids){
		callBack(ids);
	}
}





/* 删除
 * 根据id删除对象
 */
User.prototype.removeUser = function(id,delRow,fuc){
	var OBJ = this;
	var obj = this.obj;
	var page = this.page;
	var curRow = this.tBody.rows.length;

//	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	
	UserManager.removeUser(removeFun,id);

	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
		fuc();
   }
   return true;
}

User.prototype.removeUser2 = function(id,removeFun){

	UserManager.removeUser(id,removeFun);

   return true;
}
/* 总记录数
 * 
 */
User.prototype.getCount = function(obj){
	var count;
	
	DWREngine.setAsync(false);
	UserManager.getUsersCount(getCountFun,obj);	
    DWREngine.setAsync(true);
    
	function getCountFun(size){ count =  size;}
    return count;
}

User.prototype.getUsersByBranchIdCount = function(obj){
	var count;
	
	DWREngine.setAsync(false);
	UserManager.getUsersByBranchIdCount(getCountFun,obj);	
    DWREngine.setAsync(true);
    
	function getCountFun(size){ count =  size;}
    return count;
}

/* 添加新行 编辑或删除 
 * 
 */
User.prototype.addNewRow = function(mode,editRow){
    var OBJ = this;
    var obj = this.obj;
	var page = this.page;
	var tBody = this.tBody;

	
	if (!checkEeitState('btn_SaveImgTd')) return false;
	
	function getRowDataInObj(editRow){
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.username = editRow.getAttribute("username");
	 	obj.branchId = editRow.getAttribute("branchId"); 
	 		 
	 }	 
	 
	function save(event){
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");
		var id = saveImgTd.getAttribute("paraId");

		DWRUtil.getValues(obj);

		OBJ.saveUser(obj,mode);
	}	 
	
	function cannel(event){
		 OBJ.reset();
		 OBJ.getUsers()
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
		
	var saveImgTd = makeImagTd("image/save.png","btn_SaveImgTd","18","18",obj.id,"saveUser");
	var cannelImgTd =makeImagTd("image/restore.png","btn_CannelImgTd","18","18",0,"cannelEditUser");

	cell[j++] =  makeInputTextTd(obj.checkBoxName,"checkbox","10px",1,"");
	cell[j++] =  makeInputTextTd("username","text","10px",obj.username,"");
	cell[j++] =  makeInputTextTd("fullName","text","10px",obj.fullName,"");
	cell[j++] =  makeInputTextTd("email","text","10px",obj.email,"");
	cell[j++] =   makeInputTextTd(obj.checkBoxName,"checkbox","10px",obj.enabled,"");
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



User.prototype.getSysUserColByRoleId = function(roleId){
	var propertyName = "id";
	var str = new Array();
	DWREngine.setAsync(false);
	UserManager.getSysUserColByRoleId(getFun,roleId,propertyName);	
	DWREngine.setAsync(true);
	
	function getFun(strArray){
		str = strArray;
	}
	return str;
}

User.prototype.getUsersByBranchId = function(callBak_Fun){
	var OBJ = this;
	var obj = this.obj;
	var page   = this.page;
	var model = this.model;

//	var mygrid =this.mygrid;
    
    
    
    function callBakFun(objs){
    	if(model ==1){
    		OBJ.fillGrid2(objs)
    	}else{
    		OBJ.fillGrid(objs)
    	}
    	
    	if(callBak_Fun) callBak_Fun();
    }
	

    if (page.pageSize > 0){
		var size = this.getUsersByBranchIdCount(obj);
		page.size = size;

		if(obj.branchId!=branchId){
			branchId = obj.branchId;
			page.pageIndex = 1;
		}
		page.MakePageNav(page.pageIndex,page.pageInfo);

		//UserManager.getUsersByBranchIdPage(OBJ.fillTalbe,obj,page.pageIndex,page.pageSize);
//		UserManager.getUserListByBranchIds(OBJ.fillTalbe,obj,page.pageIndex,page.pageSize);
		UserManager.getUserListByBranchIds(obj,page.pageIndex,page.pageSize,callBakFun);
    }else{
//		UserManager.getUsersByBranchId(obj,OBJ.fillTalbe);	
		UserManager.getUsersByBranchId(obj,callBakFun);	
    }	
}

User.prototype.fillGrid = function(objs){

 			var sb1='';
 			
   			sb1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			sb1 = sb1 + "<rows>";  				

			function createRow(obj){
                var sb ='';
				var uid = obj.id;
				var branchId =  obj.branchId;
				var orgId =  obj.orgId;
				var branchName =  decodeURI(obj.branchName);
				var parentId =  obj.parentId;
				
				sb = sb + "<row  id=\""+ obj.id +"\"" +">";
				sb = sb + "<cell><![CDATA["+ decodeURI(obj.username)    +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ decodeURI(obj.fullName)   +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ decodeURI(obj.email)  +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ decodeURI(obj.branchName)   +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ obj.enabled   +"]]></cell>";
				
				if(obj.branchsCount>1 && decodeURI(obj.username) !='admin'){
					sb = sb + "<cell  image='books.gif'><![CDATA["+ "删除^javascript:removeUserInBranch("+ uid +","+ branchId +");^_self"   +"]]></cell>";
				}else{
					sb = sb + "<cell  image='books.gif'></cell>";
				}

				
				sb = sb + "<cell  image='books.gif'><![CDATA["+ "编辑^javascript:editUser("+ uid +","+ branchId +","+ orgId+","+ parentId +");^_self"   +"]]></cell>";
				
				if(obj.username == 'admin'){
					sb = sb + "<cell  image='books.gif'><![CDATA["+ " " +"]]></cell>";
				}else{
					sb = sb + "<cell  image='books.gif'><![CDATA["+ "删除^javascript:delUser("+ uid +","+ branchId +");^_self"   +"]]></cell>";
				}
				sb = sb + "</row>";		
				
				return sb;
			}
			
			
			for(var i = 0;i< objs.length;i++){

				var obj = objs[i];
				if(loginUserName == 'admin' && decodeURI(obj.username) =='admin'){
					sb1 = sb1 + createRow(obj);
				}
				if(decodeURI(obj.username) !='admin'){
					sb1 = sb1 + createRow(obj);
				}
			}


		    sb1 = sb1 + "</rows>";  	
		    
	       this.mygrid.clearAll();

		     
		   this.mygrid.loadXMLString(sb1);		
		   
		   


}


User.prototype.fillGrid2 = function(objs){
	

	
 			 var sb;
  
  			sb = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			sb = sb + "<rows>";  
			for(var i = 0;i< objs.length;i++){
				var obj = objs[i];
				var uid = obj.id;
				var branchId =  obj.branchId;
				var branchName =  decodeURI(obj.branchName);
				sb = sb + "<row  id=\""+ obj.id +"\"" +">";
				sb = sb + "<cell><![CDATA["+  obj.id    +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ decodeURI(obj.username)    +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ decodeURI(obj.fullName)   +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ decodeURI(obj.email)  +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ decodeURI(obj.branchName)   +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ obj.enabled   +"]]></cell>";
				sb = sb + "</row>";		
			}

		    sb = sb + "</rows>";  	
		    
	      this.mygrid.clearAll();

		     
		   this.mygrid.loadXMLString(sb);		
		   
		   
		   		   	var callbakfn = this.callbakfn;
		   	
		   	if(callbakfn) callbakfn();
		   	
		   
		   this.mygrid.setSizes();	

}

User.prototype.loadDataCheckBox = function(){
//	alert(this.roleId);
	var rescsArrays = this.getSysUserColByRoleId(this.roleId);
//	alert(rescsArrays);
	refreshCheckBox(this.tableName);
	
	putValuesInCheckBox2(this.tableName,rescsArrays);
}


User.prototype.getUserRolesCols = function(userId,propertyName,getFun){  
	UserManager.getUserRolesCol(getFun,userId,propertyName);
}

User.prototype.getUserRolesCol = function(userId,propertyName){
	var rolesArray = new Array();
	DWREngine.setAsync(false);
	UserManager.getUserRolesCol(getFun,userId,propertyName);
	DWREngine.setAsync(true);
	
	function getFun(roleIds){
		rolesArray = roleIds;
	}
	return rolesArray;	
}

User.prototype.getUserRoles = function(parentObj,userId,colName){

	var rolesArray = user.getUserRolesCol(userId,colName);

	refreshCheckBox(parentObj);
	putValuesInCheckBox2(parentObj,rolesArray);	
}



/* 给树加载信息	
 * 先初始化树对象，再加载数据
 */
User.prototype.getTreeXML = function(){
	var OBJ = this;
	var treeXMLString;

	DWREngine.setAsync(false);
	UserManager.getUsersXML(this.obj,this.IdPrefix,getxml);
	DWREngine.setAsync(true);
	
	function getxml(treeXML){ 
		OBJ.tree.treeXML = treeXML; 
		treeXMLString = treeXML;
	} 
    return treeXMLString;
}


User.prototype.passwordChanged = function(passwordField) {
        var origPassword = $("password").value;
        if (passwordField.value != origPassword) {
            createFormElement("input", "hidden",
                              "encryptPass", "encryptPass",
                              "true", passwordField.form);
        }
    }
    
    
    
    
    
    
    
    
 User.prototype.getCurUserId = function(name,callBackFun) {
	UserManager.getCurrentUserIdForEdit(name,callBackFun);
}      
    
    
 User.prototype.getCurrentUser = function() {
 	var user = this.obj;
	DWREngine.setAsync(false);
	UserManager.getCurrentUser(setValueFun);
	DWREngine.setAsync(true);	
	function setValueFun(obj){
		user = obj;
	}
	return user;
}   

 User.prototype.getUserFullName = function(loginName) {
	DWREngine.setAsync(false);
	UserManager.getUserFullName(setValueFun,loginName);
	DWREngine.setAsync(true);	
	var userName;
	function setValueFun(name){
		userName = name.Trim();
	}
	return userName;
} 


 User.prototype.makeCurrentUserSelect = function(name,event) {
	var OBJ = this;
	var obj = this.obj;
	DWREngine.setAsync(false);
	UserManager.getCurrentUserSelect(setValueFun,obj);
	DWREngine.setAsync(true);	
	
	function setValueFun(objs){
		 makeSelectHtml(objs,name);
	}
}  

 User.prototype.makeSelect = function(obj,name,event) {
	DWREngine.setAsync(false);
	UserManager.getUserSelect(setValueFun,obj);
	DWREngine.setAsync(true);	
	
	function setValueFun(objs){
		 makeSelectHtml(objs,name,event);
	}
}  

User.prototype.makeSelectFromMap = function(obj,name,event){
	
	UserManager.getUserSelectFromMap(fillFun,obj);
		
	function fillFun(objs){
		makeSelectHtml(objs,name,event);
	}
}

User.prototype.makeSelectFromMapLimit = function(name,event,width,callBackFun){
	
	UserManager.getUserSelectLimit(fillFun);
	
	function fillFun(objs){
		 makeSelectHtmlWidth(objs,name,event,width);
		 $(name).remove(0);  
		 if(callBackFun) callBackFun();
	}
}

 User.prototype.makeSelect2 = function(obj,name,event,callBackFun) {
//	UserManager.getUserSelect(setValueFun,obj);
	UserManager.getUserSelectLimit(setValueFun);
	
	function setValueFun(objs){
		 makeSelectHtml(objs,name,event);
		 callBackFun();
	}
} 
User.prototype.makeSelectWidth = function(obj,name,event,width,callBackFun) {
//	UserManager.getUserSelect(setValueFun,obj);
	UserManager.getUserSelectLimit(setValueFun);
	
	function setValueFun(objs){
		 makeSelectHtmlWidth(objs,name,event,width);
		 callBackFun();
	}    
}
 User.prototype.makeSelectAnalyze = function(obj,name,event,callBackFun) {
//	UserManager.getUserSelect(setValueFun,obj);
	UserManager.getUserSelectLimit(setValueFun);
	
	function setValueFun(objs){
		 makeSelectHtmlAnalyze(objs,name,event);
		 callBackFun();
	}
}
User.prototype.getUserAutoComplt = function(obj,callBackFun) {
	UserManager.getUserAutoComplet(callBackFun,obj);

}      
User.prototype.saveUserCarrierRel = function(orgId,userId,carrierIds,callBackFun) {
	UserManager.saveUserCarrierRel(orgId,userId,carrierIds,saveFun);

	function saveFun(){
		callBackFun();
	}
} 
User.prototype.getUserCarrierRel = function(userId,callBackFun) {
	UserManager.getUserCarrierRel(userId,getFun);

	function getFun(ids){
		callBackFun(ids);
	}
}
  
 User.prototype.getUserByCarrier = function(carrierId,customerId,el,callbackFun,event) {
	UserManager.getUserByCarrier(carrierId,customerId,fillFun);
	DWRUtil.removeAllOptions(el);
	function fillFun(objs){
		DWRUtil.addOptions(el, objs);
		el.setAttribute("onChange","javascript:"+ event +"(this)");
		el.setAttribute("style","font-size:12px;width:138px;CURSOR: pointer;");
	        if(callbackFun) callbackFun();
	}
}   


 User.prototype.getUserByRole = function(role,name,event,width,callBackFun) {
	UserManager.getUserByRole(role,fillFun);
	function fillFun(objs){
		 makeSelectHtmlWidth(objs,name,event,width);
		 $(name).remove(0);  
		 if(callBackFun) callBackFun();
	}
}   

 User.prototype.updateUserPassword = function(username,password,callBackFun) {
	UserManager.updateUserPassword(username,password,fillFun);
	function fillFun(s){
		 if(callBackFun) callBackFun();
	}
}   


 User.prototype.getUserByNamePwd = function(username,password,callBackFun) {
	UserManager.getUserByNamePwd(username,password,fillFun);
	function fillFun(bln){
		 if(callBackFun) callBackFun(bln);
	}
}

User.prototype.getUserNameByCustomerId = function(customerId,callBackFun) {
	UserManager.getUserNameByCustomerId(customerId,callBackFun);
}   


User.prototype.getFromMapLimit = function(name,event,width,callBackFun){
	
	UserManager.getUserSelectLimit(fillFun);
	
	function fillFun(objs){
		 makeSelectHtmlWidth(objs,name,event,width);
		 $(name).remove(0);  
		 if(callBackFun) callBackFun();
	}
}


User.prototype.getStoreMap = function(mode,paramObj){
	paramObj = paramObj || {};
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: UserManager.getOwnerUsersMapByCurrentUser}),
		reader: new Ext.data.MapReader(),
	});
	
	
	if(mode == 'remote'){
	  	store.on('beforeload', function(){
	    	Ext.apply(this.baseParams, {dwrParams:[paramObj]});
		}); 
		store.load();		
	}else{
		store.load({params:{dwrParams:[paramObj]}});	
	}	
	
		return store;
}

User.prototype.getStoreMap2 = function(mode,paramObj,carrierId){
	paramObj = paramObj || {};
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: UserManager.getUserByCarrier}),
		reader: new Ext.data.MapReader(),
	});
	
	
	if(mode == 'remote'){
	  	store.on('beforeload', function(){
	    	Ext.apply(this.baseParams, {dwrParams:[{},carrierId]});
		}); 
		store.load();		
	}else{
		store.load({params:{dwrParams:[{},carrierId]}});	
	}	
	
		return store;
}





User.prototype.getStoreUsersAnalyze = function(mode,paramObj){
	paramObj = paramObj || {};
	var fileds= this.fileds;

	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: UserManager.getUsersAnalyze}),
		reader: new Ext.data.DWRObjectReader({id: "id"},fileds)
	});
	
	if(mode == 'remote'){
	  	store.on('beforeload', function(){
	    	Ext.apply(this.baseParams, {dwrParams:[paramObj]});
		}); 
		store.load();			
	}else{
		store.load({params:{dwrParams:[paramObj]}});
	}
		return store;
}


 User.prototype.comboFilterBy2 = function(qe){
 var combo = qe.combo;  
 var filterFiled = combo.filterFiled;
 var filterFiled2 = combo.filterFiled2;
 var params = combo.params;
 var q = qe.query;  
 var minChars = combo.minChars;

 
  if(q.length < minChars) return false;
  eval("params."+ filterFiled +" =q");
  
   
  
  


 var forceAll = qe.forceAll;  
	 if(forceAll === true || (q.length >= combo.minChars)){  
	     if(combo.lastQuery !== q){  
	         combo.lastQuery = q;  
	         if(combo.mode == 'local'){  
	             combo.selectedIndex = -1;  
	             
	             
	             if(forceAll){  
	                 combo.store.clearFilter();  
	             }else{  
	                 combo.store.filterBy(function(record,id){  
	                     var text = record.get(filterFiled);  
	                     var match = (text.indexOf(q)!=-1);  
	                     if(!match && filterFiled2){
	                     	match = (record.get(filterFiled2).indexOf(q)!=-1);
	                     }
	                     //在这里写自己的过滤代码  
	                     return match;  
	                 });  
	             }  
	             combo.onLoad();  
	             
	         }else{  
//	         	     alert(combo.queryParam)
		             combo.store.baseParams[combo.queryParam] = q;  
		             combo.store.load({  
						  params:{dwrParams:[params]}   
		             });  

		             combo.expand(); 

	         }  
	     }else{  
	     	
	         combo.selectedIndex = -1;  
	         combo.onLoad();  
	     }  
	 }  
 	return false;  
 	} 
 	
 
 
 
 
 User.prototype.getStoreUsersFromOrder = function(mode,paramObj,type){
	paramObj = [paramObj || {},type];
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: UserManager.getUsersFromOrder}),
		reader: new Ext.data.DWRObjectReader({id: "id"},fileds)
	});
	if(mode == 'remote'){
	  	store.on('beforeload', function(){
	    	Ext.apply(this.baseParams, {dwrParams:paramObj});
		}); 
		store.load();			
	}else{
		store.load({params:{dwrParams:paramObj}});
	}
		return store;
};







 
 
User.prototype.getUsersFromOrder =  function(rederId,elname,width,callBackFun){
	     var OBJ = this;
  	     var paramObj = this.obj;
         var storeUser = user.getStoreUsersFromOrder('remote',paramObj,paramObj.type);
//		 new Ext.form.ComboBox({
//	        		xtype:"combo",	 		
//			 	  	id:elname,
//			 	  	name:elname,
//				 	 renderTo:rederId,
//				  	tiggerAction:'all',
//	                fieldLabel: '用户名称',
//	                emptyText:'请选择...',
//	                width:width,
//                    store: storeUser,
//                    displayField: 'fullName',
//                    valueField:'id',
//                    editable: true,
////                    minChars:1,
//                    mode: 'local',
//                    allowBlank:true,
////                      lastQuery:'1',
////                     filterFiled:'fullName',
////                     params:paramObj
////			  		listeners:{beforequery:OBJ.comboFilterBy2.createDelegate(this)}	
// 
//		 	})


//     new Ext.form.ComboBox({
//        store: storeUser,
//        id:elname,
//        name:elname,
//        width:width,
//        displayField:'fullName',
//         valueField:'id',
//        typeAhead: true,
//        mode: 'local',
//        forceSelection: true,
//        triggerAction: 'all',
//        fieldLabel: '用户名称',
//        emptyText:'请选择...',
//        selectOnFocus:true,
//         mode: 'local',
//        renderTo:rederId
////        params:paramObj
////		filterFiled:'fullName',
////		listeners:{beforequery:OBJ.comboFilterBy2.createDelegate(this)}	
//    });
//    
    
      var cmd =    new Ext.form.ClearableComboBox({
        store: storeUser,
        id:elname,
        name:elname,
        width:width,
        displayField:'fullName',
         valueField:'id',
        typeAhead: true,
        mode: 'local',
        forceSelection: true,
        triggerAction: 'all',
        fieldLabel: '用户名称',
        emptyText:'请选择...',
        selectOnFocus:true,
         mode: 'local',
        renderTo:rederId
//        params:paramObj,
//        minChars:1,
//		filterFiled:'fullName',
//		listeners:{beforequery:OBJ.comboFilterBy2.createDelegate(this)}	
    });
    
    

			 
	storeUser.on('load', function() {callBackFun();});
	
	return cmd;
		            
		            
		            
				//	    storeUser.on('load', function() {
				//	    	
				//	    	        if(callBackFun) callBackFun();
				////	    	        var userId = Ext.fly('userId');
				////	    	        if(!userId){
				////	    	        	 Ext.getCmp('userId').setValue(cur_userId);
				////	    	        }
				//	    	       
				////    			    user.userCommand.setValue(cur_userId);
				//   		 })
 }	;
 	
 
 
  User.prototype.getStoreUsersByOrgLimit = function(mode,paramObj){
	paramObj = [paramObj || {}];
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: UserManager.getUsersByOrgLimit}),
		reader: new Ext.data.DWRObjectReader({id: "id"},fileds)
	});
	if(mode == 'remote'){
	  	store.on('beforeload', function(){
	    	Ext.apply(this.baseParams, {dwrParams:paramObj});
		}); 
		store.load();			
	}else{
		store.load({params:{dwrParams:paramObj}});
	}
		return store;
};
 
  
User.prototype.getUsersByOrgLimit =  function(rederId,elname,width,callBackFun,save_order){
	     var OBJ = this;
  	     var paramObj = this.obj;
         var storeUser = OBJ.getStoreUsersByOrgLimit('remote',paramObj);
       
         var logninUser = paramObj.loginUser;
         var loginUserId =  paramObj.loginUserId;

         var orgId =  paramObj.orgId;
 
      var conf = {
        store: storeUser,
        id:elname,
        name:elname,
        width:width,
        lazyRender: true,
        displayField:'fullName',
         valueField:'id',
        typeAhead: true,
        forceSelection: false,
        triggerAction: 'all',
        fieldLabel: '用户名称',
        emptyText:'请选择...',
        selectOnFocus:true,
         mode: 'local',
         minChars:1
//        renderTo:rederId

    };
    
    if(rederId) conf.renderTo = rederId;
//    alert(conf.renderTo)
    
     var cmd = new Ext.form.ClearableComboBox(conf);
    
    
// 	cmd.getEl().on("mousedown",function(){
//      cmd.onTriggerClick();
//     });
     
     cmd.on("mousedown",function(){
      cmd.onTriggerClick();
     });
			 
	storeUser.on('load', function() {callBackFun();});
 
    
    function checkUser(){
    	var userName =   Ext.fly(elname).dom.value; 
    	var uid = Ext.getCmp(elname).getValue();	
    	
    	if(uid == userName && uid !=''){
            if(userName.length<2){
            	Ext.Msg.alert("提示", "用户名必须不少于两个字？");
            	return false;
            }else{
            	OBJ.displayUsersBranchs(loginUserId,orgId,userName,cmd,save_order);
            }
    		
    	}

    	
//    	function process_Result(btn, text){
//    			
//    			if (btn == 'yes'){
//    				
//    		
//    				OBJ.displayUsersBranchs(logninUser,orgId,userName,cmd);
//
//
//                  return true;
//    			}
//    		}
//    	
//    	
//    	if(uid == userName && uid !=''){
//            if(userName.length<2){
//            	Ext.Msg.alert("提示", "用户名必须不少于两个字？");
//            	return false;
//            }else{
//            	Ext.Msg.confirm("提示", "新用户是否注册？",process_Result);
//            	
//            }
//    	}
    }
	
	return cmd;

 };
 
 
 

 User.prototype.getUsersByOrgLimit2 =  function(rederId,elname,width,callBackFun,xtype){
	     var OBJ = this;
  	     var paramObj = this.obj;
         var storeUser = OBJ.getStoreUsersByOrgLimit('remote',paramObj);
       
         var logninUser = paramObj.loginUser;
         var loginUserId =  paramObj.loginUserId;

         var orgId =  paramObj.orgId;
 
      var conf = {
        store: storeUser,
        id:elname,
        name:elname,
        width:width,
        lazyRender: true,
        displayField:'fullName',
         valueField:'id',
        typeAhead: true,
        forceSelection: false,
        triggerAction: 'all',
        fieldLabel: '用户名称',
        emptyText:'请选择...',
        selectOnFocus:true,
         mode: 'local',
         minChars:1

    };
    
    if(rederId) conf.renderTo = rederId;

	storeUser.on('load', function() {callBackFun();});
	
		if(xtype){
	    	conf.xtype = 'clearableComboBox';
	    	conf.listeners = {mousedown:function(){ this.onTriggerClick()}};
	    	return conf;
	    }else{
		    var comboBox =   new Ext.form.ClearableComboBox(conf);
		     cmd.on("mousedown",function(){ cmd.onTriggerClick();});	 
		    return comboBox
	    }

 };
 
 
 User.prototype.saveUserObj = function(callBakFun){
 	
  	function callBak(id){
 		if(callBakFun) callBakFun(id);
 	}	
 	
 	
 	UserManager.saveUserObj(this.obj,callBak);
 	

 }
 
User.prototype.displayUsersBranchs = function(loginUserId,orgId,userName,cmd,save_order){
  var fileds = this.fileds;
  var OBJ = this;
  
  var parentUserId = 0;
  var urlStr=_app_params.ctxPath+"selectPopup/selectUserBranch.html?mode=1&loginUserId="+loginUserId+"&orgId="+orgId;

  var closeBtn ={text: '确定',handler: function(){removeWin();}};
  var cleanBtn ={text: '关闭',handler: function(){winUser.destroy()}};	

  var winUser = new Ext.Window({
   title : '为新业务员选择部门并对该业务员授权给其它用户',
   width : 450,
   height : 400,
   isTopContainer : true,
   modal : true,
   resizable : false,
    buttons: [closeBtn,cleanBtn],
   contentEl : Ext.DomHelper.append(document.body, {
    tag : 'iframe',
     id : 'userReliframe',
    style : "border 0px none;scrollbar:true",
    src : urlStr,
    height : "100%",
    width : "100%"
   })
  })
  
  winUser.show(); 
  
	  function callBakFun(userId){
	  	
           
            var parentUserIds = new Array();
            var parentUserIds2 = new Array();
	  		var parentUserId = loginUserId;
	  		
//		  	  function callBackFun(userids){

               parentUserIds = document.getElementById('userReliframe').contentWindow.getCheckedIds();
               
   				if(parentUserIds == null||parentUserIds == ''){parentUserIds = new Array(); }
   				
		  		parentUserIds.push(parentUserId);
		  		
//		  		if(!userids.contains(userId)) userids.push(userId);

            
			    for (var i =0;i<parentUserIds.length;i++){
			    	 parentUserIds2.push(parentUserIds[i]+'');
			    }

		  		function callb(){
	 	    	
					var rc1 = Ext.data.Record.create(fileds);
				    var rc = new rc1({
				           id : userId,
				           fullName:userName
				     });

				   	cmd.store.add(rc);
				   	cmd.store.reload();
				   	cmd.setValue(userId);  
				   	if(save_order) save_order();
		  			winUser.destroy();
		  		}
		  		
		  		
		  		
		  		
		  		
		  		
		  		OBJ.saveUserRelByParent(orgId,parentUserIds2,userId,callb);
		  		
//		  	}
		  	
//		  user.getUserRel(orgId,parentUserId,callBackFun);
		  
		  
		  
	  }
  
    function removeWin(){

    	var branchId = document.getElementById('userReliframe').contentWindow.getBranchId()*1;   

        
    	if(branchId >0){
    		    document.getElementById('userReliframe').contentWindow.saveUser(orgId,branchId,userName,callBakFun);  
    		
    	}else{
            	Ext.Msg.alert("提示", "您没有选择部门，无法保存!");
            	return false;
    	}

   	} 
   	
   	
   winUser.on({'close': {fn: removeWin}});   
    
}




User.prototype.getLovCombo =function(rederId,elname,width,checkBox,filter,callBackFun){
	var OBJ = this;
	var paramObj = this.obj;
	var store = OBJ.getStoreUsersAnalyze('remote',paramObj);

	var cmd;
	
	var conf = {
 	     fieldLabel: '用户列表'
		 ,id:elname
		,name:elname
		,width:width
		,hideOnSelect:false
		,maxHeight:200
		,readOnly: false 
  		,editable: true
  		,typeAhead: true
  		,forceAll:true
		,emptyText: '请选择业务员...' 
		,store:store
		,triggerAction:'all'
		,valueField:'id'
		,displayField:'fullName'
		,lastQuery:'ALL'
		,params:paramObj
		,filterFiled:'firstName'
		,filterFiled2:'fullName'
//		,minChars:1
		,mode:'local'		  	
	 };
	 
	 if(rederId) Ext.applyIf(conf, {renderTo:rederId});
	 if(filter) {
	 	Ext.applyIf(conf, {listeners:{ beforequery:OBJ.comboFilterBy2.createDelegate(this)}});
	 }
	 

	 
	 if(checkBox){
		  cmd = new Ext.ux.form.LovCombo(conf);
	 }else{
		  cmd =  new Ext.form.ClearableComboBox(conf);		  
	 }
	 
//	 cmd.bindStore(store);     
	    

	 cmd.on("mousedown",function(){
      	cmd.onTriggerClick();
     });
			 
	store.on('load', function() {if(callBackFun)callBackFun();});

//	if(filter) {	 
//		 cmd.on("beforequery" , function(box){           
//	                        var fullName =   box.dom.value.Trim();
//	                        alert(fullName)
//	                        if(fullName.length >0){
//		                        this.params.fullName = fullName; 
//		                        OBJ.comboFilterBy2(box);                	
//	                        }
//		 });   
//	 } 

			
	return 	cmd;
	
}



User.prototype.getTree =function(id,params,checkBox,orgId,singleExpand){
   var baseAttrs ={};
   if(checkBox){baseAttrs ={uiProvider: Ext.tree.TreeCheckNodeUI};}
   var treeload = new Ext.tree.DWRTreeLoader({
		dwrMethod: UserManager.getTree,
		params: params,
		baseAttrs: baseAttrs //添加 uiProvider 属性  
	});
	
	
	function search(){
				var searchName = Ext.getDom('searchName').value;
				alert("查询字符串："+searchName);
	}	
		

	var tree = new Ext.tree.TreePanel({
		 id:id,
	     height :300,
	     border:true,
	     rootVisible:true,
	     autoScroll:true,
//	     enableDrop:true,
		 enableDD:true,
		 singleExpand:singleExpand,
	     loader: treeload, //使用第2步中创建树的加载器 
	     checkModel: 'cascade',
//	     bbar: ['名称：',{xtype:'trigger',id: 'searchName',width:200,triggerClass:'x-form-search-trigger',onTriggerClick:search}],
	     root:new Ext.tree.AsyncTreeNode({
	      text: '用户信息',
	      allowDrag:false,
	      id: "0",
	      uiProvider: Ext.tree.TreeCheckNodeUI,
	      orgId:orgId
	      })
//	     listeners:{
//                click:gg.createDelegate(this),
//                beforeload:reload.createDelegate(this)
//         }

	 });
	 
//     tree.on('beforeload', function(){this.body.mask('数据加载中……', 'x-mask-loading');});   
//     tree.on('load', function(node){this.body.unmask();}); 


 		tree.getAllCheckedIds = function(fiterType){
	 
	 			var checkedNodes = this.getChecked();
	                    	var ids = [];
				            for(var i=0;i<checkedNodes.length;i++){    
				              		var node = checkedNodes[i];  
				              		 if(node.attributes.type == fiterType){
				              		 	ids.push(node.id);
				              		 }
				            }    
	     	    return ids.join("_");
	     }
   return tree;
};



User.prototype.getUserCmdTree = function (orgId,paras,cmdId,treeId,allowUnLeafClick,renderTo,filterFiled,emptyText,width,checkBox,singleExpand,onSelected,callFunction){
	         var OBJ = this;
	     	 OBJ.obj.parentId = 0;
	     	 var params = [{}]; //tree dataIn。;
	     	 var tree = OBJ.getTree(treeId,params,checkBox,orgId,singleExpand);
	     	 
	     	if(!OBJ.treecombo){
				var conf = {
					       id: cmdId,
					       fieldLabel : '部门用户',
			               width : width,
			               lastQuery:'-l',
			               passName : 'id',
			               autoScroll:true,
			               treeHeight:300,
			               tree :tree,
			               params:paras,
			               filterFiled: filterFiled,
			               emptyText: emptyText,
			               allowBlank : false        
				}	
				if(renderTo) conf.renderTo = renderTo;  
				if(allowUnLeafClick != null) conf.allowUnLeafClick = allowUnLeafClick;  
				if(callFunction) conf.callFunction = callFunction;  
	
				   		
				OBJ.treecombo = new ComboBoxTree(conf);
	     	}
	     	
	     	function onTreeSelected(node){
	     		var params = OBJ.treecombo.params;
               	var name  ='';
               	var nodeType = node.attributes.type;
               	
//               	if(nodeType <3) return false;
                
              
               	
//                if(nodeType ==1 && !node.expanded){
//                	 this.expand();
//                }
//                
//                if(nodeType ==1){
//                	 var checked = node.getUI().isChecked();
//                	 node.getUI().toggleCheck(!checked);
//                }           	
               	
               node.getUI().toggleCheck(true);	
              
               	name = node.text;  	
               
                OBJ.treecombo.passField.value = node.id;
                OBJ.treecombo.setValue(name);  	
                OBJ.treecombo.nodeType = nodeType;
               
                
                var search =  OBJ.treecombo.lastQuery !== node.id;
				if(search){ 
					eval("params."+ filterFiled +" =node.id");  
					OBJ.treecombo.lastQuery = node.id;
					OBJ.treecombo.callFunction(params);
				}
	     	
	     	}
	 
			 function func(){
			 	 var filterFiled = OBJ.treecombo.filterFiled;
			 	 var params = OBJ.treecombo.params;
			 	 eval("params."+ filterFiled +" =null");
			 	 OBJ.treecombo.lastQuery = -1;
			 	 OBJ.treecombo.callFunction(params);
			 	 OBJ.treecombo.nodeType = 0;
			 	 
//			 	 alert(OBJ.treecombo.tree.root);
//			 	 OBJ.treecombo.tree.root.childCheck(false);	
			
//			 	 var checkedNodes = OBJ.treecombo.tree.getChecked();
			 	 OBJ.treecombo.tree.root.getUI().toggleCheck(false);	
			 	 
			 }

    	   OBJ.treecombo.on("clear",func,this);	 	     	

           if(onSelected){
           	 OBJ.treecombo.on('treeselected',onTreeSelected,OBJ.treecombo);  
           }
          
           
           return OBJ.treecombo;
}


User.prototype.saveUserRel2 = function(parentUserId,allCheckedBranches,IdPrefix,callBackFun){

	UserManager.saveUserRel2(parentUserId,allCheckedBranches,IdPrefix,saveFun);

	function saveFun(){
		callBackFun();
	}
}


User.prototype.getUserOrgs = function(userId,callBackFun){

	UserManager.getUserOrgs(userId,saveFun);

	function saveFun(objs){
		if(callBackFun) callBackFun(objs);
	}
}










 	  
