//实例化对象
 var org = new SysOrg();
 var user = new User();
 var branch = new Branch();
 var popupcenter = new Popupcenter();
 var role = new Role();
 var channelModelParam=0;
 var isUserCustomerRelParam=0;
 var config_isUserOrderYearRel;
 var branchId=null;
 var loginUser;
 var yearWin;
 var utils = new MyUtils();
 var financeTarget = new FinanceTarget();
 var org = new SysOrg();
 var mygrid;
 var selectbranchWin;
 var userRelWin;
 var selectCarrierWin;
 var customerTypeWin;
 
var customerType = new CustomerType();
  
var category = new Category();

 callOnLoad(init);	
 


 function init(){	
	setOrgPara(org); 					//设置常量	
	setBranchPara(branch); 				//设置常量	
	setUserPara(user); 					//设置常量	
//	branch.makeSelect(branch,branch.selectName,"");
	buttonEventFill();                  //事件
//	getOrgTree(org); 		//获得树
//	getRoleTree();

	
	resetHeigth();	
	
	initGrid();
	
	channelModelParam = _app_params.sysParam.channelModelParam;
	isUserCustomerRelParam = _app_params.sysParam.isUserCustomerRelParam;
	customerOwnerParam = _app_params.sysParam.customerOwnerParam;
	config_incomeMessageAlertParam = _app_params.sysParam.incomeMessageAlertParam;
    config_isUserOrderYearRel = _app_params.sysParam.isUserOrderYearRel;
	config_username =  _app_params.user.username;
	config_useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
	config_customerCateFiter = _app_params.sysParam.customerCateFiter;
	config_oneOrgMoreSuborgsParam = _app_params.sysParam.oneOrgMoreSuborgsParam;
	
	loginUserName =  _app_params.user.username;
	loginUserFullName =  _app_params.user.fullName;
	loginUserId =  _app_params.user.id;
	
	_make_org_select("orgId",120,"getOrgTreeDate");	
	  
	  
	  
//    if(config_oneOrgMoreSuborgsParam == '1'){$('orgId').hide();}
	$('orgId').hide();
	
//	$("orgId_td").hide();
	
  	 getOrgTree();
  	 
// 	org.makeSelect(org.obj,"orgId","getOrgTreeDate",function(objs){
//
// 
////	$('orgId_td').hide();
//	 		if(config_useMoreCarrierSortParam == 0 || $('orgId').options.length<2){
//					$('orgId_td').hide();
//			}
//
//	 		getOrgTree();
//
// 		});	
 	
    
	
	loginUser =  config_username;
	
	isDisplay();
}


function initGrid(){
	ctxPath =  getCtxPath();
	mygrid = new dhtmlXGridObject('gridbox');

	mygrid.setImagePath(ctxPath+"image/grid/");

	var flds = "登录名,全名,邮箱,部门,有效,删除所在的部门,编辑,删除此用户";
	var columnIds = "filed1,filed2,filed3,filed4,filed5,filed6,filed7,filed8";
	mygrid.setHeader(flds);
	mygrid.setColumnIds(columnIds);
    mygrid.setInitWidthsP("11,10,10,10,10,22,9,18");
	mygrid.setColAlign("left,left,left,left,center,center,center,center");
//	mygrid.setColTypes("ed,ed,calendar,ed,ed");
	mygrid.setColTypes("ed,ed,ed,ed,ch,link,link,link");
	mygrid.setEditable(false);
	mygrid.selMultiRows = false;
	mygrid.setSkin("modern2");
	mygrid.enableAlterCss("even","uneven");
//	mygrid.setOnEditCellHandler(doOnCellEdit);

	mygrid.init();	

//    mygrid.loadXMLString(createTables(s));

  
}

function isDisplay(){
	if(channelModelParam!=1){
		$("Btn_select_carrier_rel").setAttribute("type","hidden");
	}
	if(isUserCustomerRelParam!=1&&customerOwnerParam!=1){
		$("Btn_select_customer_rel").setAttribute("type","hidden");
	}
	
	if(config_incomeMessageAlertParam == 0){
		$("span_province1").hide();
        $("createOpenFireU_td").hide();
	}else{
		
		$("createOpenFireU_td").show();
	}
	
	if(config_isUserOrderYearRel!=1){
		$("Btn_user_year_rel").setAttribute("type","hidden");
	}
	
	if(config_customerCateFiter!=1){
		$("Btn_user_customerType_rel").setAttribute("type","hidden");
	}	
	
	
	
	
	
//	if(loginUser != 'admin'){
//		$("createOpenFireU").hide();
//	}
	
	
}
function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var treebox = $("sysOrgTreebox");
//    var treebox2 = $("roleTree");
//    var userTable1 = $("userTable1");
    
    
    
    var v = treebox.offsetHeight*0.1;
    
    treebox.style.height = dialogcontent.offsetHeight -(dialogcontent.offsetTop - treebox.offsetTop) - v +"px";	 
//    treebox2.style.height =treebox.style.height;
    
//     userTable1.style.height =treebox.style.height;
     
    
    var userList = $("userList");
	userList.style.height =  treebox.style.height;
	
    var userForm = $("userForm");
	userForm.style.height = userList.style.height;

	var gridbox = $("gridbox");
    gridbox.style.height =  userList.style.height;	
    
	
    var  roleTable= $("roleTable");
    roleTable.style.height = treebox.style.height;
    roleTable.style.width = dialogcontent.offsetWidth*0.15+"px";
    
    var roleTable_div = $("roleTable_div");
    roleTable_div.style.width =  dialogcontent.offsetWidth*0.15 +"px";	
    
//    var v2 = treebox.offsetHeight*0.105;
//    v2 = dialogcontent.offsetHeight -(dialogcontent.offsetTop - treebox.offsetTop) - v2 +"px";	 
//    roleTable_div.style.height = v2;
      roleTable_div.style.height =  $("sysOrgTreebox").offsetHeight*0.96+"px";	
      
      if(mygrid)  mygrid.setSizes();	
      
   
}  
 

function buttonEventFill(){
	var userAllSelect = $("userAllSelect");
	userAllSelect.onclick = allSelectCheckBox;		
	userAllSelect.setAttribute("parnetObjName",user.tableName);
	
	
	
	var btn_createOpenFireU = $("createOpenFireU");
	btn_createOpenFireU.onclick = createOpenFireUser;	
	
//	var btn_SaveImgTd = $("addNewUser");
//	btn_SaveImgTd.onclick = addUser;	
	
	
	var Btn_cannel_edit_user = $("Btn_cannel_edit_user");
	Btn_cannel_edit_user.onclick = cannelEdit;		
	
	var Btn_save_user = $("Btn_save_user");
	Btn_save_user.onclick = saveUser;	
	
	var Btn_remove_user = $("Btn_remove_user");
	Btn_remove_user.onclick = function(){
		var userId = $("id").value;
//		userId = org.tree.getIdByPrefix(userId,user.IdPrefix);
		var branchId = user.obj.branchId;
		delUser(userId,branchId);
	};		
	
	
	var Btn_addUserr = $("Btn_addUserr");
	Btn_addUserr.onclick = addUser;		
	
	var Btn_add_user = $("Btn_add_user");
	Btn_add_user.onclick = addUser;	
		
	var Btn_branchMan = $("Btn_branchMan");
	Btn_branchMan.onclick = selectbranchiframe;	
	
	var Btn_roleMan = $("Btn_roleMan");
	Btn_roleMan.onclick = selectRolesiframe;	
	
//	var Btn_refresh = $("Btn_refresh");
//	Btn_refresh.onclick = getOrgTree;
		

	
	
			

	
	var Btn_select_user_rel = $("Btn_select_user_rel");
	Btn_select_user_rel.onclick = selectUserRel;	
	
	var Btn_select_carrier_rel = $("Btn_select_carrier_rel");
	Btn_select_carrier_rel.onclick = selectUserCarrierRel;
	
		var Btn_select_customer_rel = $("Btn_select_customer_rel");
		if(Btn_select_customer_rel!=null)
	Btn_select_customer_rel.onclick = selectUserCustomerRel;	
	
	
	var Btn_year_user = $("Btn_user_year_rel");
	Btn_year_user.onclick = showYearWin;	
	
	
	var Btn_customerType_user = $("Btn_user_customerType_rel");
	Btn_customerType_user.onclick = showCustomerTypeWin;	
	
	
	
	document.body.onfocus = closePopup;	
	
}


function removeUserInBranch_bak(deleImg){
	
		var row = deleImg.parentNode.parentNode;
		
		var userId = row.getAttribute("paraId"); 
		var branchId = row.getAttribute("branchId"); 
		var branchName = row.cells[4].innerHTML;
		
		var orgId = $("orgId").value;

		ans = confirm("请确认是否要删除用户所在的部门!");
		if(ans){
			user.obj.id = userId;
			user.obj.branchId = branchId;
			user.obj.username = branchName;

			function removeFun(){
				 var itemId = orgId+"_"+ branchId +"_"+user.IdPrefix + userId;
				 org.tree.dhtmlTree.deleteItem(itemId);
//				 row.remove(); 
			}

			user.delUserInBranch(removeFun);	
		}
	
}

function removeUserInBranch(userId,branchId,branchName){
	
//		var row = deleImg.parentNode.parentNode;
		
//		var userId = row.getAttribute("paraId"); 
//		var branchId = row.getAttribute("branchId"); 
//		var branchName = row.cells[4].innerHTML;


		
		var orgId = $("orgId").value;
		
		 
		ans = confirm("请确认是否要删除用户所在的部门!");
		if(ans){
			user.obj.id = userId;
			user.obj.branchId = branchId;
//			user.obj.username = branchName;
			

            
			function removeFun(){
				 var itemId = orgId+"_"+ branchId +"_"+user.IdPrefix + userId;
				 org.tree.dhtmlTree.deleteItem(itemId);
                 getSysUserTable(user);
//				 row.remove(); 
			}

			user.delUserInBranch(removeFun);	
		}
	
}


function showYearWin(){
		var parentUserId = $("id").value;
	
	if(parentUserId =='' || parentUserId ==null){
//	   	alert("请先保存用户基本信息，再执行此操作！");
	   	 Ext.MessageBox.alert('系统提示','请先保存用户基本信息，再执行此操作！',function(){});     
	   	return false;
    }
    
//	if(!yearWin){
           
            var yearWin = new Ext.Window({
            	title:'允许访问订单的年份',
                layout:'fit',
                width:500,
                height:300,
                closeAction:'hide',
                plain: true,
                items: getYearTree(),

                buttons: [{
                    text:'保存',
                    disabled:false,
                     handler: function(){
                     	saveUserYears();
                        removeWin();
                    }
                },{
                    text: '关闭',
                    handler: function(){
                        removeWin();
                    }
                }]
            });
//        }
        yearWin.show(this);
        
        
     function removeWin(){
//    	var ids = document.getElementById('userReliframe').contentWindow.getUserRels();
  		yearWin.destroy();
   	} 
     yearWin.on({'close': {fn: removeWin}});   
         
        
      var list = $('country').value.split(',');
      

      	  
//      .setChecked( { '1', '2', '4', '6' } );
	  setUserYearTree(Ext.getCmp('myYearTree'),list);
}





function saveUserYears(){
	var tree = Ext.getCmp('myYearTree');
	var checkedNodes = utils.getChecked(tree,'id',tree.root);
	//alert(checkedNodes.join(','));
	$('country').value = checkedNodes.join(',');
	saveUser(null,true);
	
}




function getYearTree(){
	
	var childrenData = new Array();
	var y = 0;
	function aa(objs){
		var size = objs.tarMonths.length;
		for(var i = 0 ;i < size;i++){
		 	y = objs.tarMonths[i];
		 	//var item =eval('{id:'+ y +',text:'+y+',leaf:true}');
		 	childrenData.push({id:y,text:y,leaf:true});
	 	}
	 	y = y*1+1;
	 	y =y+'';
	 	childrenData.push({id:y,text:y,leaf:true});
	}
	
	
//		for(var y = 2006 ;y < 2013;y++){
////			var item =eval('{id:'+ y +',text:'+y+',leaf:true}');
////			childrenData.push(item);
//		 	childrenData.push({id:y+'',text:y+'',leaf:true});
//	 	}	
	
	
	
	financeTarget.getCustomerYearRelPut2(financeTarget,aa);
	
	var baseAttrs ={uiProvider: Ext.tree.TreeCheckNodeUI};
	
//      	 var childrenData =[
//      	 					{id:'2008',text:'2008',leaf:true},
//      	 					{id:'2009',text:'2009',leaf:true},
//      	 					{id:'2010',text:'2010',leaf:true},
//      	 					{id:'2011',text:'2011',leaf:true}
//      	 					];
      	 					
         var root = new  Ext.tree.AsyncTreeNode({
                  text: '订单年份',
                  draggable:false, // disable root node dragging
                  id:'0',
                  expanded:true,
		 uiProvider: Ext.tree.TreeCheckNodeUI,
		 
                  children:childrenData
         });  
        
		 var tree=new Ext.tree.TreePanel({
		       //title:"基础数据",
		       id:'myYearTree',
		       collapsible:false,
		       rootVisible:true,
		       autoScroll:true,
		       border:true,
		       //autoHeight:true,
		       //width:150,
		       checkModel: 'cascade',
		       loader:new Ext.tree.TreeLoader(
		       {baseAttrs: baseAttrs}
		       )
		   });      	 					
       tree.setRootNode(root);	 					
      return tree; 	 					
      	 						
}





function createOpenFireUser(){
	user.createOpenFireUser();
}
//设置常量
function setOrgPara(obj){
	 obj.className  = "sysOrg";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 		= new Tree(obj.treebox); 
}
function setBranchPara(obj){
	 obj.className  = "branch";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName  = "branchId";
}
function setUserPara(obj){
	 obj.className ="user";
	 
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
	 obj.pageSize 	= "500";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
	 obj.obj.address = new Address();
	 obj.roleTable = "roleTable"
}

function closePopup(ev){
//	alert(0);
	popupcenter.closePopup(popupcenter);
}
function selectUserRel(){
	var parentUserId = $("id").value;
	
	if(parentUserId =='' || parentUserId ==null){
//	   	alert("请先保存用户基本信息，再执行此操作！");
	   	Ext.MessageBox.alert('系统提示','请先保存用户基本信息，再执行此操作！',function(){});    
	   	return false;
    }
    
    
    


//	popupcenter.url ="selectPopup/selectUserRel.html?id=" + parentUserId;
//	popupcenter.model = 6;
//	popupcenter.popupcenter(popupcenter);
  var urlStr="selectPopup/selectUserRel.html?id=" + parentUserId+"&mode=1&orgId="+$("orgId").value;
  var okBtn ={text: '保存',handler: function(){document.getElementById('userReliframe').contentWindow.saveUserRel();}};	
  var closeBtn ={text: '关闭',handler: function(){removeWin();}};
  
        
 userRelWin = new Ext.Window({
   title : '用户隶属关系',
   //maximizable : true,
   // maximized : true,
   width : 400,
   height : 300,
   // autoScroll : true,
   // bodyBorder : true,
   // draggable : true,
   isTopContainer : true,
   modal : true,
   resizable : false,
    buttons: [okBtn,closeBtn],
   contentEl : Ext.DomHelper.append(document.body, {
    tag : 'iframe',
     id : 'userReliframe',
    style : "border 0px none;scrollbar:true",
    src : urlStr,
    height : "100%",
    width : "100%"
   })
  })
  userRelWin.show(); 
  
   function removeWin(){
//    	var ids = document.getElementById('userReliframe').contentWindow.getUserRels();
  		userRelWin.destroy();
   	} 
   userRelWin.on({'close': {fn: removeWin}});   
  
  
}
function selectUserCarrierRel(){
	var parentUserId = $("id").value;
	
	if(parentUserId =='' || parentUserId ==null){
//	   	alert("请先保存用户基本信息，再执行此操作！");
	   	Ext.MessageBox.alert('系统提示','请先保存用户基本信息，再执行此操作！',function(){});    
	   	return false;
    }
//    popupcenter.url ="selectPopup/selectUserCarrierRel.html?id=" + parentUserId;
//	popupcenter.model = 6;
//	popupcenter.popupcenter(popupcenter);

  var urlStr="selectPopup/selectUserCarrierRel.html?id=" + parentUserId+"&mode=1&orgId="+$("orgId").value;
  var okBtn ={text: '保存',handler: function(){document.getElementById('userCarrReliframe').contentWindow.saveUserCarrierRel();}};	
  var closeBtn ={text: '关闭',handler: function(){removeWin();}};
  
        
  selectCarrierWin = new Ext.Window({
   title : '用户与频道隶属关系',
   //maximizable : true,
   // maximized : true,
   width : 400,
   height : 300,
   // autoScroll : true,
   // bodyBorder : true,
   // draggable : true,
   isTopContainer : true,
   modal : true,
   resizable : false,
    buttons: [okBtn,closeBtn],
   contentEl : Ext.DomHelper.append(document.body, {
    tag : 'iframe',
     id : 'userCarrReliframe',
    style : "border 0px none;scrollbar:true",
    src : urlStr,
    height : "100%",
    width : "100%"
   })
  })
  selectCarrierWin.show(); 
  
     function removeWin(){
//    	var ids = document.getElementById('userReliframe').contentWindow.getUserRels();
  		selectCarrierWin.destroy();
   	} 
   selectCarrierWin.on({'close': {fn: removeWin}});   
    
}

function selectUserCustomerRel(){
	var parentUserId = $("id").value;
	
	if(parentUserId =='' || parentUserId ==null){
//	   	alert("请先保存用户基本信息，再执行此操作！");
	   	Ext.MessageBox.alert('系统提示','请先保存用户基本信息，再执行此操作！',function(){});    
	   	return false;
    }
    popupcenter.url ="selectPopup/selectUserCustomerRel.html?id=" + parentUserId;
	popupcenter.model = 6;
	popupcenter.popupcenter(popupcenter);
    
}

function showUserForm(bln){
  if(bln){
	$("userList").hide();
	$("userForm").show();  	
	$("roleTree_div").show();  	
	
  }else{
	$("userList").show();
	$("userForm").hide(); 
	$("roleTree_div").hide();  	 	
  }
//  	resetHeigth();	
}
function resetUserform(){
	user.reset();
	DWRUtil.setValues(user.obj);
	DWRUtil.setValues(user.obj.address);	
	
//	$("province1").checked = false;
//	$("province2").checked = false;
	
	refreshCheckBox("isOpenFire");
	refreshCheckBox(user.roleTable);
}
function cannelEdit(){
//   var parentId = branch.IdPrefix + getBranchId();
//   user.obj.branchId = parentId; 
//   user.obj.branchId = getBranchIdForSel();
   var u = new User();
   u.page = user.page; 
   getSysUserTable(u); 	
   showUserForm(false);
}


function addUser(){

    var selectedItemId =  org.tree.dhtmlTree.getSelectedItemId();

    if(selectedItemId == "-1" ){return false;}  

    var parentId =  org.tree.dhtmlTree.getParentId(selectedItemId);
    var parentNodeType =  org.tree.dhtmlTree.getUserData(parentId,"type");
 	var nodeType = org.tree.getCurNodeType();   
	if(nodeType == 1){
//		alert("请先选择部门节点");
		Ext.MessageBox.alert('系统提示','请先选择部门节点！',function(){});    
		return false;}
	if(parentNodeType == 2)   org.tree.dhtmlTree.selectItem(parentId,true);

	resetUserform();
	getBranchId();
	showUserForm(true);
	
	var btn = $("Btn_save_user");
	btn.setAttribute("mode","new");
	
	var selectedItemId = org.tree.dhtmlTree.getSelectedItemId();
	var orgId = org.tree.dhtmlTree.getUserData(selectedItemId,"orgid");
	var branchId = org.tree.dhtmlTree.getUserData(selectedItemId,"branchId");

	
	
	var newItemId = "-1";
	var newItemLabel = org.tree.newItemLabel;
	
    org.tree.insertNewItem(selectedItemId,newItemId,newItemLabel,"support.png","support.png","support.png","SELECT,CALL",0);
    
    $("branchId").value = branchId;
	
	$("username").value  = newItemLabel;

	
}
function editUser_bak(editImg){
	var row = editImg.parentNode.parentNode;
	var userId = row.getAttribute("paraId"); 
	var branchId = row.getAttribute("branchId"); 
//	user.getUser(userId);
//	var sNode= org.tree.dhtmlTree._globalIdStorageFind(newItemId);

	getSysUser(branchId,userId); 


	showUserForm(true);
	var btn = $("Btn_save_user");
	btn.setAttribute("mode","edit");
}

function editUser(userId,branchId,orgId,parentOId){
//	var row = editImg.parentNode.parentNode;
//	var userId = row.getAttribute("paraId"); 
//	var branchId = row.getAttribute("branchId"); 
//	user.getUser(userId);
//	var sNode= org.tree.dhtmlTree._globalIdStorageFind(newItemId);


	getSysUser(branchId,userId,orgId); 
	
// 	var selectedItemId =  org.tree.dhtmlTree.getSelectedItemId();
// 	var parentId = org.tree.dhtmlTree.getParentId(selectedItemId); 
//    var parentOrgId = org.tree.dhtmlTree.getUserData(parentId,"parentOrgId");	
//	if(parentOrgId > 0) orgId = parentOrgId; 
	    
	
	
	function getRols(){

//		user.getUserRoles(user.roleTable,userId,"name");
//		var userId = org.tree.dhtmlTree.getUserData(itemId,"id");
//		user.getUserRoles(user.roleTable,userId,"name"); 			
		
	}
  

	 if (isUndefined(parentOId)){
	 	parentOId  = orgId;
	 }
    
  
   
    
	getRoleTree(getRols,true,parentOId);	
	
	user.getUserRoles(user.roleTable,userId,"name");
	
	
	showUserForm(true);
	var btn = $("Btn_save_user");
	btn.setAttribute("mode","edit");
}
function delUser_bak(delImg){
        var row = delImg.parentNode.parentNode;
        
		ans = confirm("请确认是否要删除此用户!");
		
		if(ans){
			var userId = row.getAttribute("paraId"); 
			function removeFun(){
				var branchId = row.getAttribute("branchId"); 
				var orgId = $("orgId").value;		
				var itemId = orgId+"_"+ branchId +"_"+user.IdPrefix + userId;
				removeUserInTree(userId);
				
//				row.remove(); 
			}
			
		 user.removeUser(userId,row,removeFun);
						
		}
		
}

function delUser(userId,branchId){
//        var row = delImg.parentNode.parentNode;
        
		ans = confirm("请确认是否要删除此用户!");
		
		if(ans){
//			var userId = row.getAttribute("paraId"); 
			function removeFun(){
//				var branchId = row.getAttribute("branchId"); 
				var orgId = $("orgId").value;		
				var itemId = orgId+"_"+ branchId +"_"+user.IdPrefix + userId;
				removeUserInTree(userId);
				getSysUserTable(user);
//				row.remove(); 
			}
			
		 user.removeUser2(userId,removeFun);
						
		}
		
}
				
function removeUserInTree(uid){
	var orid,branchId,key;
	var ids =  org.tree.dhtmlTree.getAllLeafs().split(",");
     
	for (var i = 0; i < ids.length; i++){
		if(ids[i].indexOf(user.IdPrefix)>-1){
        	key = ids[i].split("_");
        	userId = key[2].substring(user.IdPrefix.length,key[2].length);
        	orgId = key[0];
        	branchId = key[1];
        	if(uid == userId){
	            var itemId = orgId+"_"+ branchId +"_"+user.IdPrefix + userId;
				org.tree.dhtmlTree.deleteItem(itemId);
        	}			
		}   

	}
	
}





function passwordChanged(passwordField) {
//        alert(passwordField.value);
      
        var origPassword = user.obj.password;
//          alert(origPassword);
        if (passwordField.value != origPassword) {
           $("encryptPass").value = "true";
        }else{
           $("encryptPass").value = "false";
        }
}
    
function checkEncryptPass(u){
	var usrName = $("username").value;
	var encryptPass = $("encryptPass").value == "true";
	if(usrName == null || usrName == ''|| encryptPass) u.encryptPass = true;
}

//保存 role user res 关系
function saveUser(a,isSaveYear){
	var isPass = onSubmitUser();if(!isPass) return false;


    var selectedItemId = org.tree.dhtmlTree.getSelectedItemId();
    
    var isNew = selectedItemId == "-1";
    var btn = $("Btn_save_user");
 
    var oldBranch = user.obj.branchId;

   	if($("branchId").value ==0 ){
//   		alert("请选择部门！");
   		Ext.MessageBox.alert('系统提示','请先选择部门节点！',function(){});    
   		return false;
   	}
   	var username = $("username").value;
   	var func = function(id){
   		

   		if($("id").value!=id){
	   		if(id > 0){
//	   			alert("用户名已存在，请您从新输入！");
	   			Ext.MessageBox.alert('系统提示','用户名已存在，请您从新输入！',function(){});    
	   			$("username").focus();
	   			return false;
	   		}
   		}
   		DWRUtil.getValues(user.obj);
	   	user.obj.address = new Address();
	    DWRUtil.getValues(user.obj.address);  	
	    user.obj.address.country = $('country').value;
	    
	    var s ="";
		if($("province1").checkeds) s= "1,";
		if($("province2").checked)  s = s+"2,";
		
		
		user.obj.address.province = s;
	    var roles = getCheckBoxValues(user.roleTable,1);

	    
	    user.obj.roles = roles;
	    checkEncryptPass(user.obj);

	    var orgId = $("orgId").value;
		var branchId = $("branchId").value;
        user.obj.orgId = orgId;
     
        user.obj.branchId = branchId;
        
        if(isNew) user.obj.id = null;


 
	   user.saveUser(saveUserFunction);

	   function saveUserFunction(userId){
	   	        $("id").value = userId;
	   	        user.obj.id = userId;
	   		    branch.saveBranchUser(orgId,userId,branchId);
	   		    //把用户插入树
				 var newItemId = orgId+"_"+ branchId +"_"+user.IdPrefix + userId;
				 var newItemLabel = $("firstName").value +  $("lastName").value;	

	   		     if(isNew) {
	   		     	org.tree.dhtmlTree.deleteItem("-1");	
	   		     	insertNewItemToTree(1,orgId,branchId,userId,newItemLabel);
//	   		     	org.tree.dhtmlTree.setItemText("-1",newItemLabel,"");
	   		     }else{
	   		     	

	   		       
		    		if( oldBranch != $("branchId").value){
                        org.tree.dhtmlTree.deleteItem(newItemId);
                        orgId = getSelectParamFromText($("branchId"),"||",2);
		                insertNewItemToTree(1,orgId,branchId,userId,newItemLabel);                      
		    		}else{
//		    			org.tree.dhtmlTree.setItemText(newItemId,newItemLabel,"");
		    			changeAllNodesInTree(userId,newItemLabel)
		    		}
	   		     }
	   		  
	   		  

	   		    
	   		   if(userId != null) {
			    	if(isSaveYear){
			    		
			    	}else{
			    		 Ext.MessageBox.alert('系统提示','保存成功！',function(){});      
			    	}
			    	btn.setAttribute("mode","edit");
	   			 }
	    
	   }


   	}

   	user.getCurUserId(username,func)

}


function changeAllNodesInTree(uid,newItemLabel){
	var orid,branchId,key;
	var ids =  org.tree.dhtmlTree.getAllLeafs().split(",");
     
	for (var i = 0; i < ids.length; i++){
		if(ids[i].indexOf(user.IdPrefix)>-1){
        	key = ids[i].split("_");
        	userId = key[2].substring(user.IdPrefix.length,key[2].length);
        	orgId = key[0];
        	branchId = key[1];
        	if(uid == userId){
	            var itemId = orgId+"_"+ branchId +"_"+user.IdPrefix + userId;
				org.tree.dhtmlTree.setItemText(itemId,newItemLabel,"");
        	}			
		}   

	}
	
}


//function moveNewItemToTree(newItemId,newItemLabel){
//	var tree = org.tree.dhtmlTree;
//	var parentId = branch.IdPrefix + $("branchId").value;
//
//	var img = "support.png";
//	var imgopen = "support.png";
//	var imgClose = "support.png";
//	var rootId = 0;
//	var type = tree.getUserData(newItemId,"type");
//	
//	//	删除原来节点
//	tree.deleteItem(newItemId);
//
////	移动原来节点到指定的部门下面
//	org.tree.insertNewItem(parentId,newItemId,newItemLabel,img,imgopen,imgClose,rootId);
//	tree.setUserData(newItemId,"type",type);
//
//}



function getBranchIdForSel(){
	var selectedItemId = org.tree.dhtmlTree.getSelectedItemId();
	var nodeType = org.tree.dhtmlTree.getUserData(selectedItemId,"type");
	var branchId = null;
	//如果是用户节点，则取父节点
	if(nodeType == 3){
		var parentId = org.tree.dhtmlTree.getParentId(selectedItemId);
		branchId = org.tree.getIdByPrefix(parentId,branch.IdPrefix);
	}else{
		branchId = org.tree.getIdByPrefix(selectedItemId,branch.IdPrefix);
	}	

//    alert(branchId);
//	$(branch.selectName).value =  branchId;
//	DWRUtil.setValue(branch.selectName,branchId);
	
	return branchId;
}

function onSubmitUser(){
	if ($("username").value ==""){extjMessage("用户名不能为空");return false;}
	if ($("password").value ==""){extjMessage("密码不能为空");return false;}
	if ($("email").value ==""){extjMessage("email不能为空");return false;}	
	if ($("firstName").value ==""){extjMessage("姓不能为空");return false;}
	if ($("lastName").value ==""){extjMessage("名字不能为空");return false;}	
	if ($("password").value != $("confirmPassword").value){
		extjMessage("验证码与密码不符");
		$("confirmPassword").focus();
		return false;
	}	
	
	return true;
}

function getBranchId(){
	var selectedItemId = org.tree.dhtmlTree.getSelectedItemId();
	var nodeType = org.tree.dhtmlTree.getUserData(selectedItemId,"type");
	var branchId = null;
	//如果是用户节点，则取父节点
	if(nodeType == 3){
		var parentId = org.tree.dhtmlTree.getParentId(selectedItemId);
		branchId = org.tree.getIdByPrefix(parentId,branch.IdPrefix);
	}else{
		branchId = org.tree.getIdByPrefix(selectedItemId,branch.IdPrefix);
	}	

//    alert(branchId);
	$(branch.selectName).value =  branchId;
//	DWRUtil.setValue(branch.selectName,branchId);
	
	return branchId;
}

//获得列表
function getSysUserTable(u){ 
	
		var selectedItemId =  org.tree.dhtmlTree.getSelectedItemId();
        var selectedType = org.tree.dhtmlTree.getUserData(selectedItemId,"type");
     
//        alert(selectedType)
        
		if(selectedType == 1){
			
			var orgId = org.tree.dhtmlTree.getUserData(selectedItemId,"orgid");
			
			if(config_oneOrgMoreSuborgsParam == 1){ 
				var level = org.tree.dhtmlTree.getLevel(selectedItemId);
				if(level ==1){
					u.obj.branchId = null;
					u.obj.version = 0; 
				}
				if(level ==2){
						u.obj.branchId = null;
					    u.obj.version = orgId; 
				}
				
			}else{
				
				u.obj.branchId = null;
				u.obj.version = orgId; 
			}

		}
		else{
			u.obj.branchId = org.tree.dhtmlTree.getUserData(selectedItemId,"branchId"); //13502976496
		}		
		
		
//	u.obj = 	obj;

  
     function unMask(){
     	Ext.getBody().unmask();
     }
     
    Ext.getBody().mask('数据处理中……', 'x-mask-loading');
    
    u.mygrid = mygrid;
	u.getUsersByBranchId(unMask);  
}

//翻页处理
function goNextPage(pageIndex,pageInfoName){

	
	if(pageInfoName == user.pageInfo){
		var page = new Page(user.pageInfo,user.pageSize);
		page.goNextPage(pageIndex);
		user.page = page;
		getSysUserTable(user);	
	}	
}

//function showView(){
//	
//	var selectedItemId =  org.tree.dhtmlTree.getSelectedItemId();
//    var selectedType = org.tree.dhtmlTree.getUserData(selectedItemId,"type");
//    
//	user.reset();
//    if(selectedType == 1 || selectedType == 2){
//		getSysUserTable(user);
//    }else{
//    	var userId = org.tree.getIdByPrefix(selectedItemId,user.IdPrefix);
//    	 getSysUser(userId);
//    }
//
//}

function setUserYearTree(tree,list){
    var root = tree.root;
    var cs = root.childNodes;    
     var csui;    
     for(var i = 0; i < cs.length; i++) {    
          csui = cs[i].getUI();    
          var a = cs[i].attributes;  
                
          if(list.contains(a.id)) csui.check(true);    
     }           
}

function getSysUser(branchId,userId,orgId){
	var selectedItemId =  org.tree.dhtmlTree.getSelectedItemId();
	var bakOrgId = $("orgId").value;
//	var orgId =  $("orgId").value;

	if(userId =="-1" || userId =="") return false;
	  

	    
	if(orgId =='' && selectedItemId.indexOf('_')>0){
		  orgId = selectedItemId.substring(0,selectedItemId.indexOf('_'));
	}	
	
	

	branch.orgId = orgId;
	branch.makeSelect(branch,branch.selectName);
	$("orgId").value = orgId;

	user.reset();
	user.obj.id = userId;
	user.obj.orgId = orgId;
	user.obj.branchId = branchId;
    user.getUserByOrg(callBackFun);
    

    user.getUserRoles(user.roleTable,userId,"name");

  
	
	function callBackFun(obj){
		DWRUtil.setValues(obj);
		DWRUtil.setValues(obj.address);
		$("confirmPassword").value = $("password").value;
		var s = $("province").value;
		if(s.indexOf("1")>-1) $("province1").checked = true;
		if(s.indexOf("2")>-1) $("province2").checked = true;
		$("orgId").value = bakOrgId;
	}
	

	

//	getBranchId();
}

//获得树信息
function getOrgTree(){
	obj_tree = org.tree.dhtmlTree;	
	obj_tree.enableCheckBoxes(false);
	obj_tree.enableItemEditor(false);
	obj_tree.enableThreeStateCheckboxes(false);
	obj_tree.enableDragAndDrop(true);
	obj_tree.setOnClickHandler(doOnSelectOrgTree);
	obj_tree.setDragHandler(doOnBeforeDropOrgTree);
	obj_tree.setDropHandler(doOnAfterDropOrgTree);

    getOrgTreeDate();
}


function getOrgTreeDate(){	
	//加载数据
	org.reset();
	org.obj.id = $("orgId").value;
   

	org.tree.dhtmlTree.deleteChildItems(0);	
	
//	org.tree.dhtmlTree.closeAllItems(0);

	function getFun(treeXML){
			org.tree.dhtmlTree.loadXMLString(treeXML);
//			getRoleTree();
			branch.orgId = $("orgId").value;
			branch.makeSelect(branch,branch.selectName);
		
	}

	org.getTreeXML3(branch.IdPrefix,user.IdPrefix,getFun);

}




//点角色，加载权限
function doOnSelectOrgTree(itemId){
    var obj_tree = org.tree.dhtmlTree;
	var newItemId = "-1"; 
	

	
//alert('itemId>>>>>>>>>'+itemId);

	if(itemId!=newItemId){
		if(obj_tree.getLevel(newItemId) != 0){
			if(confirm("你是否想要保存改变信息?")){//save changes to new item		
    
	            obj_tree.selectItem(newItemId,false);
	            saveUser()
				return;
			}
			obj_tree.deleteItem(newItemId);	
		}
	}else{
		obj_tree.setItemColor(itemId,"red","pink");
		
		return false;
	}
	

	
	var orgId = org.tree.dhtmlTree.getUserData(itemId,"orgid");
	var branchId = org.tree.dhtmlTree.getUserData(itemId,"branchId");
	var userId = org.tree.getIdByPrefix(itemId,orgId+"_"+branchId+"_"+user.IdPrefix);
	var selectedNodeType = org.tree.dhtmlTree.getUserData(itemId,"type");
	
//	alert('itemId>>>>>>>>>'+itemId);
//	alert('orgId>>>>>>>>>'+orgId);alert('branchId>>>>>>>>>'+branchId);
	
//		alert('new orgId>>>>>>>>>'+orgId);
//		alert('old orgId>>>>>>>>>'+ $("orgId").value);
//      alert('branchId>>>>>>>>>'+branchId);

		
	getRoleTree();	
			
	if(orgId != $("orgId").value && !isUndefined(orgId)){
		

//		    if(selectedNodeType == 3){
			    branch.obj.orgId = orgId;
				branch.makeSelect(branch.obj,branch.selectName,setBranchValue);
//		    }

//			function getRols(){
//						
//
//			}
			
//			getRoleTree();
			
			if(selectedNodeType == 3){
					var userId = org.tree.dhtmlTree.getUserData(itemId,"id");
					user.getUserRoles(user.roleTable,userId,"name"); 	
			}
	}
	

	if(isUndefined(orgId)){
		  orgId = $("orgId").value;
	}else{
		 $("orgId").value =  orgId;
	}
	if(orgId =='' && itemId.indexOf('_')>0){
		  orgId = itemId.substring(0,itemId.indexOf('_'));

	}
	
	
	function setBranchValue(){
		if(!isUndefined(branchId)){
			 $("branchId").value =  branchId;
		}
	}

	


//		alert('new itemId>>>>>>>>>'+itemId);
//		alert('new itemId>>>>>>>>>'+(orgId ==''));
//		alert('old orgId>>>>>>>>>'+ $("orgId").value);
//      alert('branchId>>>>>>>>>'+branchId);
	
//	$("orgId").value = orgId;

	
	if(selectedNodeType == 1 || selectedNodeType == 2){
//		showView();
        showUserForm(false);	
        user.reset();
		getSysUserTable(user);
	}else{
//		var userId = org.tree.getIdByPrefix(itemId,orgId+"_"+user.IdPrefix);
  	     var userId = org.tree.getIdByPrefix(itemId,orgId+"_"+branchId+"_"+user.IdPrefix);
  	     showUserForm(true);	

		  getSysUser(branchId,userId);
				
	}
	 
//	 alert($("orgId").innerHTML);
	 $("orgId").value = orgId;
//	alert('new orgId>>>>>>>>>'+orgId);
}

function doOnAfterDropOrgTree(itemId,parentId){
	var tree = org.tree.dhtmlTree;
	var selectedNodeType = tree.getUserData(itemId,"type");
	var orgId,branchId,newId,id;
//	 alert('doOnAfterDropOrgTree itemId  >>' +itemId);
	
	
	if(selectedNodeType == 2 ){
		
	}else{
//		  branchId = tree.getParentId(parentId);  
		  branchId = org.tree.getIdByPrefix(parentId,branch.IdPrefix);
		  
//		  alert(tree.getParentId(itemId));
//		    alert(branchId);
//		      alert(parentId);
		  
		  orgId = itemId.substring(0,1);
		  id = tree.getUserData(itemId,"id");
//          var last = itemId.split("_")[2];
//          last = last.substring(user.IdPrefix.length,last.length);
//          id = last;

		  
		  if(!id){
		  	alert("can't fined id,error!");
		  	return false;
		  }
		  
		  

          newId = orgId+"_"+ branchId +"_"+user.IdPrefix+ id;
          
          tree.changeItemId(itemId,newId)
//           tree.refreshItem(newId);
          	tree.setUserData(newId,"branchId",branchId);
			tree.setUserData(newId,"orgId",orgId);
			tree.setUserData(newId,"id",id);	

          
//          tree.refreshItem(newId);
   
          

			
//			tree.refreshItem(itemId);
			

	}
	
	

	return true;
}

function doOnBeforeDropOrgTree(itemId,parentId,beforeNode){

//	alert('doOnBeforeDropOrgTree>itemId>>>> '+itemId);
//	alert('doOnBeforeDropOrgTree>>>parentId>>>>>'+parentId);
	
	var tree = org.tree.dhtmlTree;


		var selectedNodeType = tree.getUserData(itemId,"type");
		var selectedNodeParnetType = tree.getUserData(parentId,"type");
		
		if(selectedNodeType == 1) return false;
		if(selectedNodeType == 3 && selectedNodeParnetType == 1) return false;
		if(selectedNodeType == 3 && selectedNodeParnetType == 3) return false;
//        if(selectedNodeType == 2 && selectedNodeParnetType == 3) return false;
        if(selectedNodeType == 2) return false;
		
		if(selectedNodeType == 3 && selectedNodeParnetType == 3) {
			var p1 = tree.getParentId(itemId);
			var p2 = tree.getParentId(parentId);
			var p3 = tree.getParentId(p2);
			var b2 = org.tree.getIdByPrefix(parentId,branch.IdPrefix);
			
//			alert(p1);alert(p3);
			
			if(p1 == p3)  return false;
			
//			parentId = org.tree.dhtmlTree.getParentId(parentId);
			
		}
		
		if(selectedNodeType == 2){
			 var oId1 = org.tree.dhtmlTree.getUserData(itemId,"orgid");
			 var oId2 = org.tree.dhtmlTree.getUserData(parentId,"orgid");
			 if(oId1 != oId2) return false;
		}
		
		
		var orgId = org.tree.dhtmlTree.getUserData(parentId,"orgid");

	   //用户在部门之间移动
		if(selectedNodeType == 3){
			
			if(selectedNodeParnetType == 3)   parentId = org.tree.dhtmlTree.getParentId(parentId);
			
//		   var orgId = org.tree.dhtmlTree.getUserData(parentId,"orgid");

		    var branchId = org.tree.getIdByPrefix(parentId,branch.IdPrefix);

		    $(branch.selectName).value =  branchId;
		    

		    
//		    var userId = org.tree.getIdByPrefix(itemId,orgId+"_"+ branchId +"_"+user.IdPrefix);
            var userId = org.tree.dhtmlTree.getUserData(itemId,"id");
		    var is =  checkUserInBranch(parentId,userId);
		   
		   
		   
		   if(is) return false;
		   


		   branch.saveBranchUser(orgId,userId,branchId);
		   
		   branchId = org.tree.dhtmlTree.getParentId(itemId);  
		   branchId = org.tree.getIdByPrefix(branchId,branch.IdPrefix);


//           alert(userId);
           
		   branch.removeBranchUser(userId,branchId);
		 
		}
		//部门父子关系
		if(selectedNodeType == 2 && (selectedNodeParnetType == 1 || selectedNodeParnetType == 2)){
			branch.obj.id = org.tree.getIdByPrefix(itemId,branch.IdPrefix);
			
			var parId = 0;
			
            if (selectedNodeParnetType == 1 ){
            	 parId = 0;
            }else{
			     parId = org.tree.getIdByPrefix(parentId,branch.IdPrefix);
            }

//		    var rootId = org.tree.getSecondNodeId();
//		    var rootId = org.IdPrefix + orgId;	
			
			branch.saveBranchRelation(parId);
		}	
		return true;

}
function checkUserInBranch(bid,uid){
	var orid,branchId,key;
	var b = false;

	var ids =  org.tree.dhtmlTree.getAllSubItems(bid).split(",");


	for (var i = 0; i < ids.length; i++){
		if(ids[i].indexOf(user.IdPrefix)>-1){
        	key = ids[i].split("_");
        	orgId = key[0];
        	branchId = key[1];
//        	var p1 = branch.IdPrefix + branchId;
        	userId = key[2].substring(user.IdPrefix.length,key[2].length);
        	
//        	alert(ids[i] +"_______"+uid);
        	var p1 = org.tree.getIdByPrefix(bid,branch.IdPrefix);
//        	if(ids[i] == uid )  b = true; 
          
        	if(userId == uid && branchId ==p1)  b = true; 
//        	
//        	orgId = key[0];
//        	branchId = key[1];
////            if(uid == userId ) b = true; 
////              alert(userId)
//        	if(uid == userId ) {
//        		var p1 = branch.IdPrefix + branchId;
////        		alert(p1);alert(bid);
//        		if( p1 == bid ) b = true; 
//        	}
		}   

	}
	
	return b;
	
}
function insertNewItemToTree(mode,orgId,branchId,userId,newItemLabel){
	var tree = org.tree.dhtmlTree;
	
//    mode =1 插入  mode =2 移动
	var img = "support.png";
	var imgopen = "support.png";
	var imgClose = "support.png";

    var newItemId = orgId+"_"+ branchId +"_"+user.IdPrefix + userId;
    var parentId = branch.IdPrefix + $("branchId").value;
    var rootId = org.IdPrefix + orgId;	
    
    if(mode = 2) tree.deleteItem(newItemId);
	tree.insertNewItem(parentId,newItemId,newItemLabel,"",img,imgopen,imgClose,"SELECT,CALL",rootId);
	tree.setItemText(newItemId,newItemLabel,"");
	tree.setUserData(newItemId,"type",3);
	tree.setUserData(newItemId,"branchId",branchId);
	tree.setUserData(newItemId,"orgid",orgId);
	tree.setUserData(newItemId,"id",userId);

	
}


 function aa(){
   	alert(11111) 
   }

function getRoleTree(callBakFun,isEdit,parentOId){
	var selectedItemId =  org.tree.dhtmlTree.getSelectedItemId();
	var nodeType = org.tree.dhtmlTree.getUserData(selectedItemId,"type");
    var orgId = org.tree.dhtmlTree.getUserData(selectedItemId,"orgid");
    
     
      
      
    var parentOrgId = 0;
    
//      alert(orgId);
 
// 			branch.orgId = $("orgId").value;
//			branch.makeSelect(branch,branch.selectName);   

  
    
    if(isEdit|| nodeType ==3) {
    	   var parentId = org.tree.dhtmlTree.getParentId(selectedItemId);

			parentOrgId = org.tree.dhtmlTree.getUserData(parentId,"parentOrgId");

//    	   if(config_oneOrgMoreSuborgsParam == '1'){
//    	   	
//    	   }else{
//    	   	 orgId = org.tree.dhtmlTree.getUserData(parentId,"orgid");
//    	   	 if(parentOrgId > 0) orgId = parentOrgId;
//    	   }
    	  
    	  
    	    
    }
    
  
//  alert(orgId);
  
  if(isUndefined(orgId)){
  	orgId = parentOId;
  }
 
  
    
//    role.call_Back = function(objs){if(callBakFun) callBakFun();}

//   alert(orgId)
    role.call_Back = callBakFun;
    role.obj.orgId = orgId;
	role.getRoles2("checkbox","roleTree","lable","name","checkbox","choice","",[]);
	
	if(callBakFun) callBakFun();
}



function selectbranchiframe(){
	
	var dialogcontent = $("dialogcontentDiv");
	var dialogcontentW = dialogcontent.offsetWidth;
	var dialogcontentH = dialogcontent.offsetHeight;
	var winW= dialogcontentW * 0.6;
	var winH = dialogcontentH*0.8;	
	
  var orgId = $("orgId").value;
  
  if(orgId> 0){
  	
  }else{
//  	alert("请选择部门归属的组织");
  	Ext.MessageBox.alert('系统提示','请选择部门归属的组织！',function(){});    
  	return false;
  }
  

  var urlStr="selectPopup/selectBranchs.html?orgId="+orgId +"&width="+winW +"&height="+ winH +"&config_useMoreCarrierSortParam="+config_useMoreCarrierSortParam;

  
  var newBtn ={text: '新添部门',handler: function(){document.getElementById('selectbranchiframe').contentWindow.btn_add_new();}};	
//   var newBtn ={text: '取消添加',handler: function(){document.getElementById('selectbranchiframe').contentWindow.btn_add_new();}};	
  var saveBtn ={text: '保存',handler: function(){document.getElementById('selectbranchiframe').contentWindow.save_branch();getOrgTreeDate();}};	
  var closeBtn ={text: '关闭',handler: function(){removeWin();}};
  
        
  selectbranchWin = new Ext.Window({ 
   title : '部门维护',
   width : winW,
   height : winH,
   isTopContainer : true,
   modal : true,
   resizable : false,
   tbar: [newBtn],
   buttons: [saveBtn,closeBtn],
   contentEl : Ext.DomHelper.append(document.body, {
    tag : 'iframe',
     id : 'selectbranchiframe',
    style : "border 0px none;scrollbar:true",
    src : urlStr,
    height : "100%",
    width : "100%"
   })
  })
  selectbranchWin.show(); 
  
   function removeWin(){
  		selectbranchWin.destroy();
   	} 
   selectbranchWin.on({'close': {fn: removeWin}});   
   

  
}


function selectRolesiframe(){
	
	var dialogcontent = $("dialogcontentDiv");
	var dialogcontentW = dialogcontent.offsetWidth;
	var dialogcontentH = dialogcontent.offsetHeight;
	var winW= dialogcontentW * 0.6;
	var winH = dialogcontentH*0.8;	
	

 	
  var orgId = $("orgId").value;
  var urlStr="selectPopup/selectRoles.html?orgId="+orgId +"&width="+winW +"&height="+ winH +"&config_useMoreCarrierSortParam="+config_useMoreCarrierSortParam+"&config_username="+config_username;
  var newBtn ={text: '添加职位',handler: function(){document.getElementById('selectRolesiframe').contentWindow.add();}};	

  var closeBtn ={text: '关闭',handler: function(){removeWin();}};
  
  
        
 var win = new Ext.Window({
   title : '职位维护',
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




function showCustomerTypeWin(){
	
		var parentUserId = $("id").value;
	
	if(parentUserId =='' || parentUserId ==null){
//	   	alert("请先保存用户基本信息，再执行此操作！");
	   	Ext.MessageBox.alert('系统提示','请先保存用户基本信息，再执行此操作！',function(){});    
	   	return false;
    }
	
//	if(!yearWin){
           
      customerTypeWin = new Ext.Window({
            	title:'允许访问客户类别',
                layout:'fit',
                width:500,
                height:300,
                closeAction:'hide',
                plain: true,
                items: getCustTypeTree(),

                buttons: [{
                    text:'保存',
                    disabled:false,
                     handler: function(){
                     	saveUserCutType();
                        removeWin();
                    }
                },{
                    text: '关闭',
                    handler: function(){
                        removeWin();
                    }
                }]
            });
//        }
        customerTypeWin.show(this);
        
        
        
     function removeWin(){
//    	var ids = document.getElementById('userReliframe').contentWindow.getUserRels();
  		customerTypeWin.destroy();
   	} 
     customerTypeWin.on({'close': {fn: removeWin}});   
         
      var cats = $("city").value;  
      if(cats == 'Denver') cats='2,3,4';
	  var list = cats.split(",");
	  

	  
	  setUserYearTree(Ext.getCmp('myCusTypeTree'),list);
}


function getCustTypeTree(){
	
	var childrenData = new Array();
	
	function funnc(objs){
		var size = objs.length;
		var id;
		var name;

		for(var i = 0 ;i < size;i++){
			id = ''+ objs[i].id;
			if(id >1){
			 	text =  objs[i].categoryName ;
			 	childrenData.push({id:id,text:text,leaf:true});
			}


	 	}
	 	


	}

     
	category.getCategorys(funnc);

	
	var baseAttrs ={uiProvider: Ext.tree.TreeCheckNodeUI};

      	 					
         var root = new  Ext.tree.AsyncTreeNode({
                  text: '客户类别',
                  draggable:false, // disable root node dragging
                  id:'0',
                  expanded:true,
		 uiProvider: Ext.tree.TreeCheckNodeUI,
		 
                  children:childrenData
         });  
        
		 var tree=new Ext.tree.TreePanel({
		       //title:"基础数据",
		       id:'myCusTypeTree',
		       collapsible:false,
		       rootVisible:true,
		       autoScroll:true,
		       border:true,
		       //autoHeight:true,
		       //width:150,
		       checkModel: 'cascade',
		       loader:new Ext.tree.TreeLoader(
		       {baseAttrs: baseAttrs}
		       )
		   });      	 					
       tree.setRootNode(root);	 					
      return tree; 	 					
      	 						
}


function saveUserCutType(i){
	var tree = Ext.getCmp('myCusTypeTree');
	var checkedNodes = utils.getChecked(tree,'id',tree.root);
	$('city').value = checkedNodes.join(',');
	saveUser(null,true);
}