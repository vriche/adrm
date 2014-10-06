//ʵ��������
var customer = new Customer();
 var org = new SysOrg();
 var user = new User();
 var branch = new Branch();
 var customerId;
//alert(customerId);
//var parentUserId;
 callOnLoad(init);	
 
 function init(){	
 	setOrgPara(org); 					//���ó���	
	setBranchPara(branch); 				//���ó���	
	setUserPara(user); 					//���ó���	
	setCustomerPara(customer);
	getOrgTree(org); 				    //�����
	
	buttonEventFill();                  //�¼�
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

//���ó���
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

//�������Ϣ
function getOrgTree(obj){
	obj_tree = obj.tree.dhtmlTree;	
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableItemEditor(false);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.enableDragAndDrop(true);
	//��������
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


//װ����Դ
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
   var callBackFun = function(){alert("����ɹ���");};
   
   if(customerId =='' || customerId ==null){
   	alert("���ȱ���ͻ�������Ϣ����ִ�д˲�����");
   	return false;
   }
   customer.saveCustomerUserRel(customerId,userids,callBackFun);
}

//function saveUserRel(){
//   var userids = org.tree.getAllCheckedBranches(user.IdPrefix);
//   if(userids == null) userids = []; 
//   var callBackFun = function(){alert("����ɹ���");};
//   
////   if(parentUserId =='' || parentUserId ==null){
////   	alert("���ȱ����û�������Ϣ����ִ�д˲�����");
////   	return false;
////   }
//   user.saveUserRel(parentUserId,userids,callBackFun);
//}




