  
  
//实例化对象
 var role = new Role();
 
  var org = new SysOrg();

 callOnLoad(init);	
 
 function init(){	

	    config_username =  getParamFromUrl(window.location.href,"config_username");
		config_useMoreCarrierSortParam =  getParamFromUrl(window.location.href,"config_useMoreCarrierSortParam");
		width =  getParamFromUrl(window.location.href,"width");
		height =  getParamFromUrl(window.location.href,"height");	
	
	
	   _make_org_select("orgId",120,"getRoles");	
	   
	 orgId =  getParamFromUrl(window.location.href,"orgId");
 	
 	if(orgId > 0) $("orgId").value = orgId;
 	
 		$('orgId_td').hide();
	   
	setRolePara(role); 					//设置常量	
	
	
	
//	function callBackFun(){
		getRoleTable(role); 				//获得列表	
		buttonEventFill();
//		if(config_useMoreCarrierSortParam == 0|| $('orgId').options.length<2){
//				$('orgId_td').hide();
//		}
//	}

	
//	if(useMoreCarrierSortParam == 1 && config_username =='admin'){
//		org.makeSelect(org.obj,"orgId","getRoles",callBackFun);	
//	}

	
	
}

function buttonEventFill(){
//	var roleImgAdd = $("roleImgAdd");
//	roleImgAdd.onclick = add;

//	var orgSel = $("orgSelComd");
//	orgSel.onchange = getRoles;
	
	
}

function add(){
	
	role.addNewRow('new',null);

}

//设置常量
function setRolePara(obj){
	 obj.className  = "role";
	 obj.IdPrefix 	= obj.className +"Id";
	 obj.tableName   = obj.className +"Table";
	 obj.fillObjName = obj.className +"Tbody";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.checkBoxName = obj.className +"Check";
	 obj.color1 		= "BACKGROUND-COLOR: white";
	 obj.color2 		= "BACKGROUND-COLOR: #eee";
 
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 
	 obj.pageInfo 	= obj.className +"PageInfo";
	 obj.pageSize 	= "0";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
	 
	 obj.callBakFun = window.parent.getRoleTree;
}


//动作填充 
function button_add_new(type){
//	if(type == 0){ sysResource.addNewRow('new',null);}
//	if(type == 1){ user.addNewRow('new',null);}
}

//翻页处理
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == role.pageInfo){
		var page = new Page(role.pageInfo,role.pageSize);
		page.goNextPage(pageIndex);
		role.page = page;
       
		getRoleTable(role);	
	}
}


function getRoleTable(obj){
//	if(useMoreCarrierSortParam =='1'){
		obj.obj.orgId = $("orgId").value;
//	}
	
	obj.getRoles(obj);  
}

function getRoles(){

//	if(useMoreCarrierSortParam =='1'){
		if($("orgId").value>0){
				role.obj.orgId = $("orgId").value;
		}

//	}
	
	role.getRoles(role);  
	

	
//	window.parent.getRoleTree();
}





