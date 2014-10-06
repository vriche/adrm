//实例化对象
var customer = new Customer();
 var org = new SysOrg();
 var user = new User();
 var branch = new Branch();
 var customerId;
//alert(customerId);
//var parentUserId;
 callOnLoad(init);	
 
 function init(){	
 	setOrgPara(org); 					//设置常量	
	setBranchPara(branch); 				//设置常量	
	setUserPara(user); 					//设置常量	
	setCustomerPara(customer);
	getOrgTree(org); 				    //获得树
	
	buttonEventFill();                  //事件
	resetHeigth();						
//	parentUserId = getCustomerIdByURL();
	customerId = getCustomerIdByURL();
// 	alert(parentUserId);
	loadCustomerUserRel();
}

function resetHeigth(){
   var treebox = $("sysOrgTreebox");
   var Btn_saveCustomerRel = $("Btn_saveCustomerRel");
   var height = window.innerHeight;
//   treebox.style.height = height*0.9  +"px";	 
   treebox.style.height = height - Btn_saveCustomerRel.offsetHeight*2  + "px";	 

}  


function buttonEventFill(){
	var Btn_saveCustomerRel = $("Btn_saveCustomerRel");	
	Btn_saveCustomerRel.setAttribute("href","javascript:void 0");
	Btn_saveCustomerRel.onclick = saveCustomerRel;		
	
	var Btn_close = $("Btn_close");	
	Btn_close.setAttribute("href","javascript:void 0");
	Btn_close.onclick = closeWin;		
}

//设置常量
function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
}

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
	obj_tree = obj.tree.dhtmlTree;	
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableItemEditor(false);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.enableDragAndDrop(true);
	//加载数据
	obj.reset();
	obj.obj.id = 1;
	obj.getTreeXML(branch.IdPrefix,user.IdPrefix);
	obj_tree.loadXMLString(obj.tree.treeXML);
}

function getCustomerIdByURL(){
	var url = window.location.href;
	var startPos = url.indexOf("=");
	var endPos = url.length;
	var id = null;
	id = url.substring(startPos+1,endPos)*1
	return  id;
}
function closeWin(){
	window.top.close();
//	return false;
//	window.close();return false;
//	window.opener.location.reload();
}


//装载资源
function loadCustomerUserRel(){
	function callBackFun(ids){
//		alert(ids);
	 	org.tree.loadDataTreeArray1(user.IdPrefix,ids);
	}

	if(customerId =='' || customerId == null){
		 org.tree.refreshTree();return false;
	}else{
		customer.getCustomerUserRel(customerId,callBackFun);
	}	
}	


function saveCustomerRel(){
   var userids = org.tree.getAllCheckedBranches(user.IdPrefix);
   if(userids == null) userids = []; 
   var callBackFun = function(){alert("保存成功！");};
   
   if(customerId =='' || customerId ==null){
   	alert("请先保存客户基本信息，再执行此操作！");
   	return false;
   }
   customer.saveCustomerUserRel(customerId,userids,callBackFun);
}

//function saveUserRel(){
//   var userids = org.tree.getAllCheckedBranches(user.IdPrefix);
//   if(userids == null) userids = []; 
//   var callBackFun = function(){alert("保存成功！");};
//   
////   if(parentUserId =='' || parentUserId ==null){
////   	alert("请先保存用户基本信息，再执行此操作！");
////   	return false;
////   }
//   user.saveUserRel(parentUserId,userids,callBackFun);
//}




