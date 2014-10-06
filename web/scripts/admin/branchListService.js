var branch = new Branch();
 var org = new SysOrg();
 var orgId;
 
 
callOnLoad(init);

function init(){
	
 	setBranchPara(branch);
 	setOrgPara(org);
 	
   _make_org_select("orgId",120,"getBranchListTreeDate");	
   
// 	org.makeSelect(org.obj,org.selectName,"getBranchListTreeDate",callBakFun);
 	
 	orgId =  getParamFromUrl(window.location.href,"orgId");
 	
 	if(orgId > 0) $("orgId").value = orgId;
 	
 	
 	
 	
 	
// 	function callBakFun(objs){
	 	getBranchListTree();	
		getBranchListTable(branch);
		branch.obj.orgId =  $('orgId').value;
		

 		branch.makeSelect(branch.obj,branch.selectName,"");
        
      
//		config_useMoreCarrierSortParam = $("config_useMoreCarrierSortParam").value;
		
		config_useMoreCarrierSortParam =  getParamFromUrl(window.location.href,"config_useMoreCarrierSortParam");
	
		
		width =  getParamFromUrl(window.location.href,"width");
		height =  getParamFromUrl(window.location.href,"height");


	$('orgId_td').hide();
	
//	 	if(config_useMoreCarrierSortParam == 0 || $('orgId').options.length<2){
//	 		$('orgId_td').hide();
//	 	}

//		buttonEventFill();
		resetHeigth(width,height);		
// 	}

	

}
function setBranchPara(obj){
	
	 obj.className  = "branch";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 	= new Tree(obj.treebox); 
	
	 obj.tableName   = obj.className +"Table";
	 obj.fillObjName = obj.className +"Body";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.checkBoxName = obj.className +"Check";
	 obj.color1 		= "BACKGROUND-COLOR: white";
	 obj.color2 		= "BACKGROUND-COLOR: #eee";
	 obj.enableEdit	= true;
	 obj.enableDel	= true;	 
	 obj.pageInfo 	= obj.className +"PageInfo";
	 obj.pageSize 	= "16";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
     obj.selectName ="branchParentIdRN";
}
function setOrgPara(obj){
	 obj.className  = "sysOrg";
	 obj.IdPrefix 	= obj.className + "Id"; 
     obj.selectName ="orgId";  
}
function buttonEventFill(){
	
//	//添加
//	var btn_add = $("Btn_add");
////	btn_add.setAttribute("href","javascript:void 0");
//	btn_add.onclick =  btn_add_new;
//	
//	var image_add = $("Image_add");
//	image_add.onclick =  btn_add_new;
//	
////	var btn_delete = $("Btn_delete_branch");
////	btn_delete.onclick =  Btn_delete_branch;
//	
//	var btn_cancel = $("Btn_cancel_branch");
//	btn_cancel.onclick =  Btn_cancel_branch;
//	
//
//	var btn_save = $("Btn_save_branch");
//	btn_save.onclick =  save_branch;
}



function delBranch(deleImg){
	 
	
    
	var id = deleImg.getAttribute("paraId"); 
	var delRow = deleImg.parentNode.parentNode;
	
	
	var selectedItemId =  branch.IdPrefix+id;
	var selectedType = branch.tree.dhtmlTree.getUserData(selectedItemId,"type");
	var parentId = 	selectedItemId;
	if(selectedType == 1) parentId = branch.tree.dhtmlTree.getUserData(selectedItemId,"orgid");
	if(selectedType == 3) parentId = branch.tree.dhtmlTree.getParentId(selectedItemId);
		
    
	
	var isAgree = branch.removeBranchList(id,delRow,parentId, branch);

	if(isAgree == null&&!isAgree){
//		branch.tree.removeNodeFromTree(id,branch.IdPrefix);


		

//		var parentId = this.dhtmlTree.getParentId(ItemId);
		 branch.tree.dhtmlTree.deleteItem(selectedItemId);
//		if(parentId != this.dhtmlTree.rootId){
//		  this.dhtmlTree.selectItem(parentId,true);
//		}
		
		
//	  window.parent.getOrgTreeDate();

//		branch.tree.selectItem(parentId,true);		
//		
		
		
//		getOrgTree();
		
	}
	
		
//	
//	if(selectedType == 1) parentId = branch.tree.dhtmlTree.getUserData(selectedItemId,"orgid");
//	if(selectedType == 3) parentId = branch.tree.dhtmlTree.getParentId(selectedItemId);
//	branch.tree.selectItem(parentId);







	
}

function save_branch(){
	
	var selectedItemId =  branch.tree.dhtmlTree.getSelectedItemId();
	var selectedNodeType = branch.tree.dhtmlTree.getUserData(selectedItemId,"type");
	var selectedNodeParnetType = branch.tree.dhtmlTree.getUserData(parentId,"type");
	
	


	DWRUtil.getValues(branch.obj);
	
//	alert($(org.selectName).value)
//	branch.obj.orgId	= $(org.selectName).value;
//    if(selectedNodeParnetType ==1){
      var ogId = branch.tree.dhtmlTree.getUserData(selectedItemId,"orgid");
    		branch.obj.orgId	=  ogId;
    		
//    }else{
//    	
//    }

//	 var orgId = branch.tree.dhtmlTree.getUserData(parentId,"orgid");
	
	    
	if(selectedNodeType ==1 ){
		branch.obj.parentId = 0;
	}else{
		var id = branch.tree.dhtmlTree.getUserData(selectedItemId,"id");
		
	   if(branch.obj.id ==''){
	   	    branch.obj.parentId = id;
	   }else{
	   	    branch.obj.parentId = $("parentId").value;
	   }

//       branch.obj.parentId = id;
//		branch.obj.parentId = $(branch.selectName).value;
	}


//
//    alert(branch.obj.orgId);alert(branch.obj.parentId);


	if(!isCheck(branch.obj)) return false;
	
	var isNew = (branch.obj.id ==""|| branch.obj.id ==null);
	if(isNew) branch.obj.id ==null;
	var callBackFun = function(id){
		$("id").value = id;
		var newItemId = branch.IdPrefix + id;
		var newItemLabel = $("name").value;
		//alert(id);
		if(isNew){
			insertNewItemToTree(newItemId,newItemLabel);
			 getBranchMenu(id);		
		}else{
			branch.tree.dhtmlTree.setItemText(newItemId,newItemLabel,"");
//			moveNewItemToTree(newItemId,newItemLabel);
		}
		Ext.MessageBox.show(
								 	{title:'系统提示!',msg:"保存成功!",width:300,heigth:200,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
		); 		
		
	}
	
	branch.obj.version = 0;
	branch.obj.treeLevel = branch.obj.treeLevel == true?1:0;
	branch.saveBranchList(branch.obj,callBackFun);
//	alert("保存成功！");
	

						
}

//function moveNewItemToTree(newItemId,newItemLabel){
//	var tree = branch.tree.dhtmlTree;
//	var parentId = branch.IdPrefix + $(branch.selectName).value;
//
//	var img = "book.gif";
//	var imgopen = "books_open.gif";
//	var imgClose = "books_close.gif";
//	var rootId = 0;
//	var id = tree.getUserData(newItemId,"id");
//	
//	//	删除原来节点
//	tree.deleteItem(newItemId);
//
////	移动原来节点到指定的部门下面
//	branch.tree.insertNewItem(parentId,newItemId,newItemLabel,img,imgopen,imgClose,rootId);
//	tree.setUserData(newItemId,"id",id);
//}

function isCheck(obj){
	if ($("name").value ==""){
//		alert("部门名不能为空");
						Ext.MessageBox.show(
								 	{title:'系统提示!',msg:"部门名不能为空!",width:300,heigth:200,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
						);  		
		
		return false;
		}

	return true;
}
function insertNewItemToTree(newItemId,newItemLabel){//newItemLabel为页面的 名字 项
	var tree = branch.tree.dhtmlTree;
	//alert(newItemId+"    sss   "+newItemLabel);
	
	var selectedItemId =  branch.tree.dhtmlTree.getSelectedItemId();
	var selectedNodeType = branch.tree.dhtmlTree.getUserData(selectedItemId,"type");
	var orgId = branch.tree.dhtmlTree.getUserData(selectedItemId,"orgid");
	var parentId = 0;
		
	
	if(selectedNodeType ==1 ){
		parentId ="orgId"+orgId;
	}else{
		parentId = selectedItemId;
	}
//	var parentId = 	selectedItemId;
//	if(selectedType == 1) parentId = branch.tree.dhtmlTree.getUserData(selectedItemId,"orgid");
//	if(selectedType == 3) parentId = branch.tree.dhtmlTree.getParentId(selectedItemId);


//	var parentId = selectedItemId;
//	var parentId = branch.tree.dhtmlTree.getParentId(selectedItemId);
//	var selectedType = branch.tree.dhtmlTree.getUserData(selectedItemId,"type");
//	$(branch.selectName).value = selectedType == 1?"0":branch.tree.getIdByPrefix(selectedItemId,branch.IdPrefix);; 
//	var parentId = selectedType == 1?selectedItemId:branch.tree.dhtmlTree.getParentId(selectedItemId);
	
	//var parentId = tree.getSelectedItemId(branch.IdPrefix);
	
	
//	var nodeType = tree.getUserData(parentId,"id");
	
	var id = branch.tree.getIdByPrefix(newItemId,branch.IdPrefix);
	
	var img = "book.gif";
	var imgopen = "books_open.gif";
	var imgClose = "books_close.gif";
	

	var rootId = "orgId"+orgId;
	

	
	
	
	branch.tree.insertNewItem(parentId,newItemId,newItemLabel,img,imgopen,imgClose,rootId);
	
	tree.setUserData(newItemId,"id",id*1);
	tree.setUserData(newItemId,"orgid",orgId);
	tree.setUserData(newItemId,"type",2);


	
//alert(1+"x");
	
}
function Btn_cancel_branch(){
	 var selectedItemId =  branch.tree.dhtmlTree.getSelectedItemId();
	 doOnSelectGetRes(selectedItemId);
	 
//	var sysmenuId = $("id").value;
//	
//    showBranchMenu(true);
//	getListTable(sysmenuId);
//	
//	resetBranchMenu();
	
	
}
//function editBranch(editImg){
//	
//	var branchSysId = editImg.getAttribute("paraId"); 
//	$("id").value = branchSysId;
//	 var parentId = branch.tree.dhtmlTree.getParentId(branch.IdPrefix + branchSysId);
//	 var pid = branch.tree.getIdByPrefix(parentId,branch.IdPrefix);
//	 
//      var parid = (pid == -1)?0:pid;
//	//alert(pid);
//	
//	$(branch.selectName).value = parid ;
//	getBranchMenu(branchSysId);
//	showBranchMenu(false);
//	
//	var btn = $("Btn_save_branch");
//	btn.setAttribute("mode","edit");
//	
//	var image_add = $("Image_add");
//	image_add.onclick =  btn_add_new;
//}

//function getListTable(id){
//    if(id != ''){
//    	branch.reset();
//    	var parentId = branch.tree.dhtmlTree.getParentId(branch.IdPrefix + id);
//    	//alert(parentId);
//    	var id =(parentId == "branchId-1")?0:branch.tree.getIdByPrefix(parentId,branch.IdPrefix);
//    	//alert(id);
//    	branch.obj.parentId = id;
//    	branch.getBranchLists(branch);
//       
//    }
//    else{
//    	branch.obj.parentId = 0;
//    	branch.getBranchLists(branch);
//    }
//}

function getBranchListTable(branch){

	 showBranchMenu(true);

	 branch.obj.parentId = 0;
	 branch.getBranchLists(branch);
	
}


function btn_add_new(){

	resetBranchMenu();
	showBranchMenu(false);
	
	var selectedItemId =  branch.tree.dhtmlTree.getSelectedItemId();
	var selectedType = branch.tree.dhtmlTree.getUserData(selectedItemId,"type");
//	if(parentType ==1){
//		
//	}else{
//		
//	}
//	
//	alert(selectedItemId);
//	var parentId = branch.tree.dhtmlTree.getParentId(selectedItemId);
//    var parentType = branch.tree.dhtmlTree.getUserData(parentId,"type");

	$(branch.selectName).value = selectedType == 1?"0":branch.tree.getIdByPrefix(selectedItemId,branch.IdPrefix); 
	      
	
//	$(branch.selectName).value =branch.tree.getSelectedItemId(branch.IdPrefix);
	
	
  // $(branch.selectName).value = 0;

//	var btn = $("Btn_save_branch");
//	btn.setAttribute("mode","new");
}
function resetBranchMenu(){
	branch.reset();
	DWRUtil.setValues(branch.obj);
}

function showBranchMenu(bln){
	
	
	if(bln){
		$("branchList").show();
		$("branchForm").hide();
	}else{

		$("branchList").hide();

		$("branchForm").show();

	}
}


function getBranchListTree(){

	obj_tree = branch.tree.dhtmlTree;
	obj_tree.enableCheckBoxes(false);
	obj_tree.enableItemEditor(false);
	obj_tree.enableDragAndDrop(true);
	obj_tree.setOnClickHandler(doOnSelectGetRes);
	
	obj_tree.setDragHandler(doOnBeforeDropMenuTree);
	getBranchListTreeDate();
}


function getBranchListTreeDate(){
	obj_tree = branch.tree.dhtmlTree;
	branch.reset();
    branch.obj.orgId = $("orgId").value;
    branch.tree.dhtmlTree.deleteChildItems(0);	
	branch.getTreeXML();
	branch.tree.dhtmlTree.loadXMLString(branch.tree.treeXML);
 	branch.makeSelect(branch.obj,branch.selectName,"");

}



function doOnBeforeDropMenuTree(itemId,parentId){
	var tree = branch.tree.dhtmlTree;
	var selectedNodeType = branch.tree.dhtmlTree.getUserData(itemId,"type");
	var selectedNodeParnetType = branch.tree.dhtmlTree.getUserData(parentId,"type");
	var parentOrgId = 0;
	

	
	
	if(selectedNodeType == 1 ) return false;
//	
//	alert(selectedNodeType);
//	alert(selectedNodeParnetType);
	
//	if(selectedNodeType == 1 && selectedNodeParnetType == 0) return false;
	//Menu 父子关系
	//if((selectedNodeType == 1 || selectedNodeType == 2 )&& (selectedNodeParnetType == 0 || selectedNodeParnetType == 1 ||selectedNodeParnetType == 2)){

			var parId=selectedNodeParnetType == 1?"0" :branch.tree.getIdByPrefix(parentId,branch.IdPrefix);
			var id = branch.tree.getIdByPrefix(itemId,branch.IdPrefix);
		    var rootId = branch.tree.getSecondNodeId();
		    var orgId = branch.tree.dhtmlTree.getUserData(parentId,"orgid");
		    
		    var orgId_old = branch.tree.dhtmlTree.getUserData(itemId,"orgid");
		    

		    
//		    parentOrgId = org.tree.dhtmlTree.getUserData(parentId,"parentOrgId");
		    
//		    if(parentOrgId > 0) orgId = 

		    branch.obj.id = id;
		    branch.obj.orgId = orgId;
			branch.saveBranchRelation2(parId,orgId);
			
			if(orgId_old != orgId){
				branch.saveUserOrg(orgId_old,orgId,id);
			}
			
			
			
			tree.setUserData(itemId,"orgid",orgId);
			tree.setUserData(itemId,"type",selectedNodeParnetType);
			
	//}	
	
			branch.obj.parentId = parId;
			branch.getBranchLists(branch);
			getBranchMenu(id);		
			
//			window.parent.getOrgTree();
	return true;

	
}

function resetHeigth(width,height){
    var treebox = $("branchTreebox");
    treebox.style.height = height*0.78 +"px";	 
    
    branchList.style.height =height*0.78 +"px";	 
    branchForm.style.height = branchList.style.height;
}

function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == branch.pageInfo){
		var page = new Page(branch.pageInfo,branch.pageSize);
		page.goNextPage(pageIndex);
		branch.page = page;
		getBranchTable(branch);
	}
}
function getBranchTable(branch){
	showBranchMenu(true);
	branch.getBranchLists(branch);
}

function getBranchMenu(id){
	var callBackFun = function(obj){
		DWRUtil.setValues(obj);
	}
	branch.getBranchMenu(id,callBackFun);
}


function edit(id){
	 showBranchMenu(false); 
//	 var id = branch.tree.getIdByPrefix(itemId,branch.IdPrefix);
	  getBranchMenu(id);
}
function doOnSelectGetRes(itemId,a){
   
	var selectItemId =branch.tree.dhtmlTree.getUserData(itemId,"id"); 
	var selectedNodeType = branch.tree.dhtmlTree.getUserData(itemId,"type");
	var orgId = branch.tree.dhtmlTree.getUserData(itemId,"orgid");
	
	
	  
	   
	var isLeaf = (branch.tree.dhtmlTree.getSubItems(itemId) == null || branch.tree.dhtmlTree.getSubItems(itemId) == '');


    showBranchMenu(!isLeaf); 
    

   
	if((selectedNodeType ==2 && isLeaf) ){
		
		  $(org.selectName).value = orgId;

    	  var parentId = branch.tree.dhtmlTree.getParentId(itemId);
    	  var parentType = branch.tree.dhtmlTree.getUserData(parentId,"type");
    	  
    	  branch.reset();
    	  branch.obj.orgId = orgId;
    	  branch.obj.parentId = 0;
//    	  alert(orgId);
    	  branch.makeSelect(branch.obj,branch.selectName,"");
    	  
	      $(branch.selectName).value = parentType == 1?"0":branch.tree.getIdByPrefix(parentId,branch.IdPrefix);; 
	      $("id").value =  selectItemId;
	      getBranchMenu(selectItemId);		
	}else{
//		  alert(orgId);
		   orgId = (isUndefined(orgId))?$(org.selectName).value:orgId;
	       branch.reset();
	       branch.obj.orgId = orgId;
		   branch.obj.parentId = selectedNodeType ==1?"0":selectItemId;
		   branch.getBranchLists(branch);
		  
	}
		
	
		

//    selectItemId = (selectItemId ==-1)?0:selectItemId;
  
//    var parentId = selectedNodeType==1? branch.tree.dhtmlTree.getUserData(itemId,"id"):
//    var pid = branch.tree.getIdByPrefix(parentId,branch.IdPrefix);
//    var parid = (pid == -1)?0:pid;
    
   // var parid = getid(parentId)==-1?0:getid(parentId);
    

	

	
//    if(isLeaf){
//    	  showBranchMenu(false);
//	      $(branch.selectName).value = selectItemId ;
//	      getBranchMenu(selectItemId);
//	     
//    }else{
//    	 if(selectedNodeType == null){
//		       branch.obj.parentId = 0;
//		       branch.obj.parentId = 0;
//		       branch.getBranchLists(branch);
//		       showBranchMenu(true);
//		}
//	else{
//	  
//		        branch.obj.parentId = selectItemId;
//				branch.getBranchLists(branch);
//				showBranchMenu(true);       
//         	}
//
//	}
//  	var btn = $("Btn_save_branch");
//	btn.setAttribute("mode","edit");
}
//function getid(pid){
//	
//    var id;
//    for(x=-100;x<=100;x++){
//    if( "branchId"+x == pid){
//     id = x;
//     }
//}
//   return id;
//}


