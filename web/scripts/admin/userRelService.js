//实例化对象
 var org = new SysOrg();
 var user = new User();
 var branch = new Branch();
 var parentUserId;
 var mode = 0;
 var orgId =1;

 callOnLoad(init);	
 
 function init(){	
 	
 	ctxPath = $("ctxPath").value;
 	

 	
 	setOrgPara(org); 					//设置常量	
	setBranchPara(branch); 				//设置常量	
	setUserPara(user); 					//设置常量	

	buttonEventFill();                  //事件
				

	mode =  getParamFromUrl(window.location.href,"mode");
	orgId =  getParamFromUrl(window.location.href,"orgId");
	

	
	getOrgTree(org); 				    //获得树
	
	resetHeigth();			
	
	

	
	
	if(mode == '1'){
//		orgId =  getParamFromUrl(window.location.href,"orgId");
		if(isUndefined(orgId)||orgId == '') orgId=1;
		parentUserId =  getParamFromUrl(window.location.href,"id");
//		loadUserRel(orgId);
		loadUserRel2(parentUserId);
	}

	if(mode == '2') {
		ids =  getParamFromUrl(window.location.href,"ids").split(",");
		org.tree.loadDataTreeArray1(carrier.IdPrefix,ids);
	}
}

function resetHeigth(){
   var treebox = $("sysOrgTreebox");
   var Btn_saveUserRel = $("Btn_saveUserRel");
   var height = window.innerHeight;
   treebox.style.height = height*0.9  +"px";	 
//   treebox.style.height = height - Btn_saveUserRel.offsetHeight*2  + "px";	 

}  


function buttonEventFill(){
	var Btn_saveUserRel = $("Btn_saveUserRel");	
	Btn_saveUserRel.setAttribute("href","javascript:void 0");
	Btn_saveUserRel.onclick = saveUserRel;		
	
	var Btn_close = $("Btn_close");	
	Btn_close.setAttribute("href","javascript:void 0");
	Btn_close.onclick = closeWin;		
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
	 obj.checkBoxName = obj.className +"Check";
	 obj.obj.address = new Address();
}

//获得树信息
function getOrgTree(obj){
//	alert(ctxPath);
	obj_tree = obj.tree.dhtmlTree;	
	obj_tree.setImagePath(ctxPath+"image/tree/");
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableItemEditor(false);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.enableDragAndDrop(true);
	obj_tree.setOnClickHandler(doOnSelect);
//	obj_tree.setDragHandler(doOnBeforeDropOrgTree);
	//加载数据
	obj.reset();
	obj.obj.id = orgId;

	obj.getTreeXML(branch.IdPrefix,user.IdPrefix);
	obj_tree.loadXMLString(obj.tree.treeXML);
}

//function doOnSelectOrgTree(itemId){
//	alert(itemId);
//}

function doOnSelect(itemId){
//	if(itemId == "root") return false;
	if(itemId.indexOf('sysOrgId')>-1) return false;
	var isItemChecked = org.tree.dhtmlTree.isItemChecked(itemId);
	org.tree.dhtmlTree.setSubChecked(itemId,!isItemChecked); 
	
//	var state = this.isItemChecked(itemId);
//	alert(state)
//	state = state == 0?false:true;
//	this.setCheck(itemId,!state);
	
}




function getParentUserIdByURL(){
	var url = window.location.href;
	var startPos = url.indexOf("=");
	var endPos = url.length;
	var id = null;
	id = url.substring(startPos+1,endPos)*1
	return  id;
}
function closeWin(){
	window.top.close();
//	window.close();return false;
//	window.opener.location.reload();
}


//装载资源
//function loadUserRel(orgId){
//	function callBackFun(ids){
//        var rootId = org.IdPrefix + orgId;	
//	 	org.tree.loadDataTreeArray3(rootId,ids);
//	}
//
//	if(parentUserId =='' || parentUserId == null){
//		 org.tree.refreshTree();return false;
//	}else{
//		var objs = _app_params.rights.userOrgs;
//
//		user.getUserRel(orgId,parentUserId,callBackFun);
//	}	
//}	







function loadUserRel2(uId){
 var orgs =[];

  
  
	if(parentUserId =='' || parentUserId == null){
		 org.tree.refreshTree();return false;
	}else{
		 
			function callbak(objs){
				orgs  = objs;
			}	
		
     
	 DWREngine.setAsync(false);
	 UserManager.getUserOrgs(parentUserId,callbak);
   DWREngine.setAsync(true);	 

   for(var i = 0;i< orgs.length;i++){

		   	   var org_Id = orgs[i];
		   	   
							var  getFun = function(ids){
								
										var rootId = org.IdPrefix + org_Id;	

										org.tree.loadDataTreeArray3(org_Id,ids,true);	
							}	   	   
		   	   
		   	   DWREngine.setAsync(false);
		   	   UserManager.getUserRel(org_Id,parentUserId,getFun);
		   	   DWREngine.setAsync(true);	

		   	   
		}
   
   
  
   

		
	}	
	
	
}	


function saveUserRel(){
	var map = new HashMap();
	var orgidStr=  org.tree.dhtmlTree.getAllLeafs();
	

	var ids = orgidStr.split(",");
	for(var i =0;i<ids.length;i++){
		var orgids = ids[i].split("_");
		if(orgids.length>1){
			map.put(orgids[0],orgids[0]);
			 
		}
	}
	var curOrgs = map.values();
	
   var idStr =  org.tree.dhtmlTree.getAllCheckedBranches();
   var userids = uniqueArray(org.tree.getAllCheckedBranches(user.IdPrefix));
   if(userids == null) {userids = []; }

   var callBackFun = function(){
   	parent.userRelWin.close();
//   	alert("保存成功！");
   	};
   
//   if(parentUserId =='' || parentUserId ==null){
//   	alert("请先保存用户基本信息，再执行此操作！");
//   	return false;
//   }
//   user.saveUserRel(orgId,parentUserId,userids,callBackFun);
   // var orgs = org.tree.getAllBranchesByPrefix(org.IdPrefix);
    
//  alert(curOrgs);
  
   user.saveUserRel2(curOrgs,parentUserId,idStr,user.IdPrefix,callBackFun);
   
}

function getCheckedIds(){
   var ids = org.tree.getAllCheckedBranches(user.IdPrefix);
   if(ids == null) ids = []; 
   return ids;
}

function refreshTree(){
	org.tree.refreshTree();
}



