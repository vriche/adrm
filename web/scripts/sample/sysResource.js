  
  
//实例化对象
 var branch = new Branch();
 
 var branch2 = new Branch();
  
 callOnLoad(init);	
 function init(){
 	setBranchPara(branch); 	//设置常量	
 	setBranchPara2(branch2); 	//设置常量	
	getBranchTree(branch); 	//获得树	
	getBranchTree(branch2); 	//获得树	
	getBranchTable(branch); //获得表
	getBranchTable(branch2); //获得表
}

//设置常量
function setBranchPara(branch){
	 branch.enableEdit	= true;
	 branch.enableDel	= true;
	
	 branch.IdPrefix 	= "branchId";
	 
	 branch.fillObjName = "branchBody";
	 branch.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 branch.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 branch.tBody 		= $(branch.fillObjName);
	 
	 branch.pageInfo 	= "pageInfo_target";
	 branch.pageSize 	= "4";
	 branch.page = new Page(branch.pageInfo,branch.pageSize);

	 branch.treebox		="branchTreebox";
	 branch.tree 		= new Tree(branch.treebox); 
}
function setBranchPara2(branch){
	 branch.enableEdit	= true;
	 branch.enableDel	= true;
	
	 branch.IdPrefix 	= "branch2Id";
	 
	 branch.fillObjName = "branchBody2";
	 branch.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 branch.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 branch.tBody 		= $(branch.fillObjName);
	 
	 branch.pageInfo 	= "pageInfo_target2";
	 branch.pageSize 	= "4";
	 branch.page = new Page(branch.pageInfo,branch.pageSize);

	 branch.treebox		="branchTreebox2";
	 branch.tree 		= new Tree(branch.treebox); 
}

//动作填充 
function button_add_new_branch(type){

	if(type == 0){
		branch.addNewRow('new',null);
	}
	
	if(type == 1){
		branch2.addNewRow('new',null);
	}	

}
//翻页处理
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == branch.pageInfo){
		var page = new Page(branch.pageInfo,branch.pageSize);
		page.goNextPage(pageIndex);
		branch.page = page;
		getBranchTable(branch);		
	}
	
	if(pageInfoName == branch2.pageInfo){
		var page = new Page(branch2.pageInfo,branch2.pageSize);
		page.goNextPage(pageIndex);
		branch2.page = page;
		getBranchTable(branch2);		
	}
}
//获得树信息
function getBranchTree(branch){
	branch_tree = branch.tree.dhtmlTree;	
	branch_tree.enableCheckBoxes(true);
	branch_tree.enableItemEditor(true);
	branch_tree.enableDragAndDrop(true);
//	branch_tree.setOnClickHandler(branch.doOnSelectTree);
//	branch_tree.setOnItemTextChange(branch.doOnTextChangeTree);
//	branch_tree.setDragHandler(branch.doOnBeforeDropTree);
	//加载数据
	branch.reset();
	branch.obj.parentId = 0;
	branch.getTreeXML();
	branch_tree.loadXMLString(branch.tree.treeXML);
}
//获得列表
function getBranchTable(branch){
	branch.getBranchs(branch.obj);  
}






