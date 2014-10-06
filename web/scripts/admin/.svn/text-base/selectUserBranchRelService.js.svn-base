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

	
//	getOrgTree(org); 				    //获得树

    getBranchListTree();
    getOrgTree2();
	
	resetHeigth();			
	
}


function getBranchListTree(){
	
	var obj_tree = branch.tree.dhtmlTree;
	obj_tree.enableCheckBoxes(false);
	obj_tree.enableItemEditor(false);
	obj_tree.enableDragAndDrop(false);
//	obj_tree.setOnClickHandler(doOnSelectGetRes);
	
//	obj_tree.setDragHandler(doOnBeforeDropMenuTree);

	branch.reset();
    branch.obj.orgId = orgId;

    function callBakFun(xml){
    	    branch.tree.dhtmlTree.deleteChildItems(0);	
    		branch.tree.dhtmlTree.loadXMLString(xml);
    }
	branch.getTreeXML2(callBakFun);

}

function getOrgTree2(){
//	alert(ctxPath);
	var obj_tree = org.tree.dhtmlTree;	
	obj_tree.setImagePath(ctxPath+"image/tree/");
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableItemEditor(false);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.enableDragAndDrop(true);
	obj_tree.setOnClickHandler(doOnSelect);
//	obj_tree.setDragHandler(doOnBeforeDropOrgTree);
	//加载数据
	org.reset();
	org.obj.id = orgId;
	
    function callBakFun(xml){
//    	    obj_tree.deleteChildItems(0);	
    		obj_tree.loadXMLString(xml);
    }
	org.getTreeXML3(branch.IdPrefix,user.IdPrefix,callBakFun);	
	


}

function resetHeigth(){
   var branchTreebox = $("branchTreebox");
   var sysOrgTreebox = $("sysOrgTreebox");
   var Btn_saveUserRel = $("Btn_saveUserRel");
   var height = window.innerHeight;
   branchTreebox.style.height = height-60  +"px";	 
   sysOrgTreebox.style.height = height-60  +"px";	 
//   treebox.style.height = height - Btn_saveUserRel.offsetHeight*2  + "px";	 

}  


function buttonEventFill(){
	var Btn_saveUserRel = $("Btn_saveUserRel");	
	Btn_saveUserRel.setAttribute("href","javascript:void 0");
	Btn_saveUserRel.onclick = closeWin;		
	
	

	
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
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 		= new Tree(obj.treebox); 	 
	 
	 
	 
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
	obj_tree.enableDragAndDrop(false);
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




function getBranchId(){

  return branch.tree.getSelectedItemId(branch.IdPrefix);

}		
function saveUser(orgId,branchId,userName,callBakFun){
	
   if(branchId > 0){
	   var u =  new User();
	   alert(userName)
	   var obj =  u.obj;
	   obj.id = null;
	   obj.orgId = orgId;
	   obj.username = userName;
	   obj.password = userName;
	   obj.firstName = userName.substring(0,1);
	   obj.lastName =  userName.substring(1,userName.length);;
	   obj.fullName = userName;
	   obj.email = userName +"@vriche.com";
	   obj.enabled = true;
	   obj.branchId = branchId;
	   obj.version = 0;
	   obj.accountExpired = false
	   obj.accountLocked = false
	   obj.credentialsExpired = false	   
	   
	   
	   obj.address = new Address();
	   obj.address.city = '';
	   obj.address.country = '';
	   obj.address.postalCode = '';
	   

    ;
	   
	   

   }

  	try {
  		 
  		 u.saveUserObj(callBakFun);
  		 
  	} catch (e) {
  		return 0;
//				alert(e.name + " : " + e.message); 
	} 
 

}

function getCheckedIds(){
   var ids = org.tree.getAllCheckedBranches(user.IdPrefix);
   if(ids == null) ids = []; 
   return ids;
}


