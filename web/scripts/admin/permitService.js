  
  
//ʵ��������
 var role = new Role();
 var user = new User();
 var sysResource = new SysResource();
 var 	branchId = 0;
 var orgId_bak = 0;
 var mygrid;
 var mygrid2;
  
 callOnLoad(init);	

		
 function init(){	
 	
 	config_username =  _app_params.user.username;
 	config_useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
 	
 	 _make_org_select("orgId",120,"getRoleTreeData");	

	setRolePara(role); 					//���ó���	
	setUserPara(user); 					//���ó���	
	setSysResourcePara(sysResource); 	//���ó���
	buttonEventFill();
	
	

	initGrid();
	initGrid2();
	getRoleTree(role); 					//�����	
	showTable();	
	
	
	resetHeigth();						//����б�	
	
	
}

function initGrid(){
	ctxPath =  getCtxPath();
	mygrid = new dhtmlXGridObject('gridbox');

	mygrid.setImagePath(ctxPath+"image/grid/");

	var flds = ",��¼��,ȫ��,����,����,��Ч";
	var columnIds = "filed1,filed2,filed3,filed4,filed5,filed6";
	mygrid.setHeader(flds);
	mygrid.setColumnIds(columnIds);
    mygrid.setInitWidthsP("10,15,15,20,20,20");
	mygrid.setColAlign("center,left,left,left,left,center");
//	mygrid.setColTypes("ed,ed,calendar,ed,ed");
	mygrid.setColTypes("ch,ed,ed,ed,ed,ch");
	mygrid.setEditable(false);
	mygrid.selMultiRows = false;
	mygrid.setSkin("modern2");
	mygrid.enableAlterCss("even","uneven");
	 mygrid.setOnRowSelectHandler(onRowSelected,true);

	mygrid.init();	
}

function onRowSelected(id,cellInd){
	var cell = mygrid.cells(id,0);
	var v = cell.getValue()==0?1:0;
	cell.setValue(v);	  
}
function initGrid2(){
	ctxPath =  getCtxPath();
	mygrid2 = new dhtmlXGridObject('gridbox2');

	mygrid2.setImagePath(ctxPath+"image/grid/");

	var flds = ",��Դ����,��Դ����,ϵͳ��Դ,��ע";
	var columnIds = "filed1,filed2,filed3,filed4,filed5";
	mygrid2.setHeader(flds);
	mygrid2.setColumnIds(columnIds);
    mygrid2.setInitWidthsP("5,45,10,30,10");
	mygrid2.setColAlign("center,left,center,left,left");
//	mygrid2.setColTypes("ed,ed,calendar,ed,ed");
	mygrid2.setColTypes("ch,ed,ed,ed,ed");
	mygrid2.setEditable(false);
	mygrid2.selMultiRows = false;
	mygrid2.setSkin("modern2");
	mygrid2.enableAlterCss("even","uneven");
	mygrid2.setOnRowSelectHandler(onRowSelected2,true);

	mygrid2.init();	
}


function onRowSelected2(id,cellInd){
	
//	var selectedItemId =  role.tree.dhtmlTree.getSelectedItemId();
//	var selectedType = role.tree.dhtmlTree.getUserData(selectedItemId,"type");
//	if(selectedType == 1) {extjMessage('û��ѡ��ְλ!');return false;}	
	
	var cell = mygrid2.cells(id,0);
	var v = cell.getValue()==0?1:0;
	cell.setValue(v);
		  
	cell = mygrid2.cells(id,1);
	var v = cell.getValue();
	$("name").value = v;

	cell = mygrid2.cells(id,2);
	var v = cell.getValue();
	$("resType").value = v;	
	
	cell = mygrid2.cells(id,3);
	var v = cell.getValue();
	$("resString").value = v;		
	
	cell = mygrid2.cells(id,4);
	var v = cell.getValue();
	$("memo").value = v;	
	
	$("id").value = mygrid2.getSelectedId();		
}
 
 

 
function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var treebox = $("roleTreebox");
    var radioResources = $("radioResources");
//		    alert(bro_date.offsetHeight);
//			var treeTable = $("treeTable");
//	var gridbox = $("gridbox");


    
    var v = radioResources.offsetHeight*7;
    v = dialogcontent.offsetHeight -(dialogcontent.offsetTop - treebox.offsetTop) - v 
	treebox.style.height = v+"px";	
    var gridbox = $("gridbox");
    gridbox.style.height = v*0.95+"px";	
    $("gridbox2").style.height = v*0.95+"px";	


    
    
//    gridbox.style.height = treebox.offsetHeight * 1.3 + "px";	
} 

function buttonEventFill(){
	var radioResources = $("radioResources");
	radioResources.onclick = showTable;
	
	var radioUsers = $("radioUsers");
	radioUsers.onclick = showTable;	
	
	var Btn_save_role_user_res = $("Btn_save_role_user_res");
	Btn_save_role_user_res.onclick = save_res;	
	
	var Btn_del_res = $("Btn_del_res");
	Btn_del_res.onclick = remove_res;		

	var Btn_add_res = $("Btn_add_res");
	Btn_add_res.onclick = function(){
		$("id").value = '';
		save_res();
	}
	
	
	
	
//	var sysResourceAllSelect = $("sysResourceAllSelect");
//	sysResourceAllSelect.onclick = allSelectCheckBox;		
//	sysResourceAllSelect.setAttribute("parnetObjName",sysResource.tableName);
	
//	var userAllSelect = $("userAllSelect");
//	userAllSelect.onclick = allSelectCheckBox;		
//	userAllSelect.setAttribute("parnetObjName",user.tableName);
	
	var btn_load = $("Btn_load_default");
	if(!isUndefined(btn_load)){
			btn_load.onclick =  load_default;
	}
	
	var Btn_roleMan = $("Btn_roleMan");
	Btn_roleMan.onclick = selectRolesiframe;	

}


function remove_res(){
	var selectedItemId =  mygrid2.getSelectedId();

	if(selectedItemId > 0){
 			Ext.MessageBox.confirm('ϵͳ��ʾ','�Ƿ�ɾ��?',function (value){  
	             if(value == 'yes'){  
	                 sysResource.remove(selectedItemId,showTable);
	               }
   				})     
		
	}else{
		extjMessage('��ѡ��Ҫɾ���ļ�¼!');return false; 
	}
	
}

//function add_res(){
//	var selectedItemId =  mygrid2.getSelectedId();
//	if(selectedItemId > 0){
// 			Ext.MessageBox.confirm('ϵͳ��ʾ','�Ƿ�ɾ��?',function (value){  
//	             if(value == 'yes'){  
//	                 sysResource.remove(selectedItemId,showTable);
//	               }
//   				})     
//		
//	}else{
//		extjMessage('��ѡ��Ҫɾ���ļ�¼!');return false; 
//	}
//	
//}



function save_res(){
	
		var selectedItemId =  role.tree.dhtmlTree.getSelectedItemId();
		var selectedType = role.tree.dhtmlTree.getUserData(selectedItemId,"type");
		var noRole = false;
		if(selectedType == 1) {
//			extjMessage('û��ѡ��ְλ!');return false;
            noRole = true;
		}		
	
	if($("radioResources").checked) {
	

		var id = $("id").value;
		
//		if(id > 0){
			
			var obj = sysResource.obj;
			obj.displayNo = 0;
			obj.orgId = $("orgId").value;;
			obj.id = id == ''?null:id;
			obj.name = $("name").value;
			obj.resType = $("resType").value;
			obj.resString = $("resString").value;
			obj.memo = $("memo").value;
			
			if(!noRole){
				saveRole_user_res();
			}else{
				function callbakFun(){
					
					sysResource.reset();
					sysResource.obj.orgId = $("orgId").value;
					sysResource.getSysResources();
				}
				sysResource.saveSysResource(callbakFun);				
			}
		
//		}		
	}else{
		if(!noRole){saveRole_user_res();}
	}


	
}







function selectRolesiframe(){
	
	var dialogcontent = $("dialogcontentDiv");
	var dialogcontentW = dialogcontent.offsetWidth;
	var dialogcontentH = dialogcontent.offsetHeight;
	var winW= dialogcontentW * 0.6;
	var winH = dialogcontentH*0.8;	
	

 	
  var orgId = $("orgId").value;
  var urlStr="selectPopup/selectRoles.html?orgId="+orgId +"&width="+winW +"&height="+ winH +"&config_useMoreCarrierSortParam="+config_useMoreCarrierSortParam+"&config_username="+config_username;
  var newBtn ={text: '���ְλ',handler: function(){document.getElementById('selectRolesiframe').contentWindow.add();}};	

  var closeBtn ={text: '�ر�',handler: function(){removeWin();}};
  
  
        
 var win = new Ext.Window({
   title : 'ְλά��',
   width : winW,
   height : winH,
   isTopContainer : true,
   modal : true,
   resizable : false,
   tbar: [newBtn],
   buttons: [closeBtn],
   contentEl : Ext.DomHelper.append(document.body, {
    tag : 'iframe',
     id : 'selectRolesiframe',
    style : "border 0px none;scrollbar:true",
    src : urlStr,
    height : "100%",
    width : "100%"
   })
  })
  win.show(); 
  
   function removeWin(){
//   	    getOrgTreeDate();
  		win.destroy();
   	} 
   win.on({'close': {fn: removeWin}});   
  
}

//���ó���
function setRolePara(obj){
	 obj.className  = "role";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 		= new Tree(obj.treebox); 
}

function setSysResourcePara(obj){
	 obj.className ="sysResource";
	 
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
	 obj.pageSize 	= "1000";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}

function setUserPara(obj){
	 obj.className ="user";
	 
	 obj.IdPrefix 	= obj.className +"Id";
	 obj.tableName   = obj.className +"Table";
//	 obj.fillObjName = obj.className +"Tbody";
//	 obj.tBody 		= $(obj.fillObjName);
//	 obj.checkBoxName = obj.className +"Check";
//	 obj.color1 		= "BACKGROUND-COLOR: white";
//	 obj.color2 		= "BACKGROUND-COLOR: #eee";
//	 obj.enableEdit	= true;
//	 obj.enableDel	= true;	 
	 obj.pageInfo 	= obj.className +"PageInfo";
	 obj.pageSize 	= "1000";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
	 obj.address = new Address();
}

//������� 
function button_add_new(type){
	if(type == 0){ sysResource.addNewRow('new',null);}
	if(type == 1){ user.addNewRow('new',null);}
}

//��ҳ����
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == sysResource.pageInfo){
		var page = new Page(sysResource.pageInfo,sysResource.pageSize);
		page.goNextPage(pageIndex);
		sysResource.page = page;
		getSysResourceTable(sysResource);	
		loadDataCheckBox();
	}
	if(pageInfoName == user.pageInfo){
		var page = new Page(user.pageInfo,user.pageSize);
		page.goNextPage(pageIndex);
		user.page = page;
		getSysUserTable(user);	
		loadDataCheckBox();
	}	
	
}

function load_default(){
    function callBackFun(r){
    	window.location.href = "reload.html";
	    //alert('����ɹ���!');
    	//alert(r+"����");
    }
	sysResource.saveSysPermitDefault(sysResource.obj,callBackFun);     
}



function loadDataUserCheckBox(user){

//	var rescsArrays = user.getSysUserColByRoleId(user.roleId);
	

	//alert(user.roleId);
	var rescsArrays = user.getSysUserColByRoleIdOrgId(user.roleId,user.obj.version);
    	//alert(rescsArrays);
    refreshUserCheckBox(mygrid);
//	refreshCheckBox(this.tableName);

	putValuesInUserCheckBox2(mygrid,rescsArrays);
}


function loadDataResCheckBox(res){
//	var rescsArrays = user.getSysUserColByRoleId(user.roleId);
//    refreshUserCheckBox(mygrid2);
//	putValuesInUserCheckBox2(mygrid2,rescsArrays);	
	
	if(res.roleId > 0){
		
	    var rescsArrays = sysResource.getSysResourceColByRoleId(res.roleId);  
	    refreshUserCheckBox(mygrid2);
		putValuesInUserCheckBox2(mygrid2,rescsArrays);
	}	
	

}



function showTable(){
	var selectedItemId =  role.tree.dhtmlTree.getSelectedItemId();
	var selectedType = role.tree.dhtmlTree.getUserData(selectedItemId,"type");
	var orgId = role.tree.dhtmlTree.getUserData(selectedItemId,"orgId");


		if($("radioResources").checked){
			$(sysResource.tableName).show();
			$(user.tableName).hide();
			getSysResourceTable(sysResource);	
//			if(selectedType == 2){
//					sysResource.loadDataCheckBox();
//			}
		}else{
//			user.reset();
			user.obj.version = orgId; 
			user.obj.branchId = null;
		
			getSysUserTable(user);
			$(user.tableName).show();
			$(sysResource.tableName).hide();	
			if(selectedType == 2){
				loadDataUserCheckBox(user);
//				user.loadDataCheckBox();
			}
		
		}	
	//	loadDataCheckBox();


}



function getUserIds(grid,model){
	var ids = new Array();
	for(var i=0; i< grid.getRowsNum();i++){
		if(model ==0){
			ids.push(grid.getRowId(i));
		}else{
			var v = grid.cells2(i,0).getValue();
			if(v == 1)ids.push(grid.getRowId(i));
		}
	}
	return ids;
}

function refreshUserCheckBox(grid){
	var ids = new Array();
	for(var i=0; i< grid.getRowsNum();i++){
		grid.cells2(i,0).setValue(0);
	}
}

function putValuesInUserCheckBox2(grid,values){
    var len = values.length;
	if(len > 0){
		for(var i=0; i<len;i++){
			var id= values[i];
			grid.cells(id,0).setValue(1);
			
//			try{
//				grid.cells(id,0).setValue(1);
//			}catch(err){
//				
//			}

			
		}
	
	}		
	
	
}	



//���� role user res ��ϵ
function saveRole_user_res(){
	


//	var roleIds = role.tree.getAllCheckedBranches(role.IdPrefix);
	var roleId = role.tree.curSelectItemId;
//	
//	var roleId =  role.tree.getIdByPrefix(roleIds,role.IdPrefix);
	role.obj.id = roleId;
	
//	if (roleIds == null) alert("û��ѡ��ְλ");
//    alert(roleId);
//	if(roleId ==-1 || roleId =="" || roleId =="") {
//		 alert("û��ѡ��ְλ");
//		 return false;
//	}

	if($("radioResources").checked){
//		var all = getCheckBoxValues(mygrid2,0);
//		var checkeds = getCheckBoxValues(mygrid2,1);
		
		var all = getUserIds(mygrid2,0);
		var checkeds = getUserIds(mygrid2,1);		
		
		role.obj.rescsNo = all;
		role.obj.rescs = checkeds;
//		for(var i =0; i< roleIds.length;i++){ 
//			role.obj.id = roleIds[i];
			role.saveRoleUserRes("resc");
		
//		}
	}else{
		var all = getUserIds(mygrid,0);
		var checkeds = getUserIds(mygrid,1);
		role.obj.usersNo = all;
		role.obj.users = checkeds;
//		for(var i =0; i< roleIds.length;i++){ 
//			role.obj.id = roleIds[i];
			role.saveRoleUserRes("user");	
//		}
	}	
//	alert('����ɹ�!');

	extjMessage('�������!');return false;
}

//����б�
function getSysResourceTable(obj){
	obj.mygrid = mygrid2;
	obj.model =1;	
	obj.getSysResources();  
	obj.callbakfn =function(){
			loadDataCheckBox();
	}
}

function getSysUserTable(obj){
	obj.mygrid = mygrid;
	obj.model =1;
	
//alert(obj.branchId);
//alert(branchId);
	
	

	obj.getUsersByBranchId(); 
	
	obj.callbakfn =function(){
			loadDataCheckBox();
	}
//	obj.getUsers();  

//	loadDataUserCheckBox(obj);
}

//�������Ϣ
function getRoleTree(obj){
	obj_tree = role.tree.dhtmlTree;	
	obj_tree.enableCheckBoxes(false);
	obj_tree.enableItemEditor(false);
	obj_tree.enableDragAndDrop(false);
	obj_tree.enableThreeStateCheckboxes(false);
	obj_tree.setOnClickHandler(doOnSelectRoleTree);
//	obj_tree.setOnItemTextChange(obj.doOnTextChangeTree);
//	obj_tree.setDragHandler(role.doOnBeforeDropTree);
	//��������
	getRoleTreeData();
}

function getRoleTreeData(){
	obj_tree = role.tree.dhtmlTree;	
	obj_tree.deleteChildItems(0);	
	//��������
	role.reset();
	role.obj.orgId = $("orgId").value;
	role.getTreeXML();
	obj_tree.loadXMLString(role.tree.treeXML);
}


//���ɫ������Ȩ��
function doOnSelectRoleTree(itemId){
//	var dhtmlTree = role.tree.dhtmlTree;
//	var id = role.tree.getIdByPrefix(itemId,role.IdPrefix);
	var selectedItemId =  role.tree.dhtmlTree.getSelectedItemId();
	var selectedType = role.tree.dhtmlTree.getUserData(selectedItemId,"type");
	var orgId  = role.tree.dhtmlTree.getUserData(selectedItemId,"orgId");
	
	if(orgId_bak != orgId){
	 		if(!$("radioResources").checked ){
				user.obj.version = orgId; 
				user.obj.branchId = null;
			
				getSysUserTable(user);
				$(user.tableName).show();
				$(sysResource.tableName).hide();	
				if(selectedType == 2){
//					user.loadDataCheckBox();
					loadDataUserCheckBox(user);
				}
	 		}
	 		orgId_bak  = orgId;
	 }else{
	 	if($("radioResources").checked && selectedType == 1){
	 		if($("radioResources").checked ){
	 			 refreshUserCheckBox(mygrid2);
	 		}else{
	 			 refreshUserCheckBox(mygrid);
	 		}
	 		
			
	 		 return false;
	 	}
	 }
	 
	 
//	if(selectedType == 1){
//		 return false;
//	}else{
//		
//	}
	

	
	role.tree.setCurSelectItemId(role.IdPrefix);
	sysResource.roleId = role.tree.curSelectItemId;
	user.roleId = role.tree.curSelectItemId;

	loadDataCheckBox();

	
}

function loadDataCheckBox(){
//	var id = role.tree.curSelectItemId;
//	alert(id);
	
	var selectedItemId =  role.tree.dhtmlTree.getSelectedItemId();
	

	
	
	var selectedType = role.tree.dhtmlTree.getUserData(selectedItemId,"type");
	

	
	
	if(selectedType != 1 ){
		if($("radioResources").checked) {
			role.obj.users = [];
			role.obj.usersNo = [];
//			sysResource.loadDataCheckBox();
            
			loadDataResCheckBox(sysResource);
		}else{
			role.obj.rescs = [];
			role.obj.rescsNo = [];
//			user.loadDataCheckBox();
			loadDataUserCheckBox(user);
		}		 
	}else{
		
	
		
		if($("radioResources").checked) {
//			refreshCheckBox(sysResource.tableName);
		
			 refreshUserCheckBox(mygrid2);
		}else{
			 refreshUserCheckBox(mygrid);
//			refreshCheckBox(user.tableName);
		}

	}

}











