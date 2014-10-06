/************************************************
 *   功能：流程管理 
 *   目的：管理业务的流转关系
 * **********************************************/
 
var workFlow = new OaWorkFlow();
var workFlowType = new OaWorkFlowType();
var userCh= new User();
var userIn = new User();
 
callOnLoad(init);	

function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var treebox = $("workFlowTypeTreebox");
    var Btn_add_income_flow = $("Btn_add_income_flow");
    
    var userCheckTreebox = $("userCheckTreebox");
    var userIncomeTreebox = $("userIncomeTreebox");
    
    var v = Btn_add_income_flow.offsetHeight*4;
    
    treebox.style.height = dialogcontent.offsetHeight -(dialogcontent.offsetTop - treebox.offsetTop) - v +"px";	   	

	userCheckTreebox.style.height = treebox.offsetHeight*0.32 + "px";
	userIncomeTreebox.style.height = treebox.offsetHeight*0.32 + "px";
} 

function init(){	
	setWorkFlowTypePara(workFlowType);
 	setWorkFlowPara(workFlow);
 	setUserChPara(userCh);
 	setUserInPara(userIn);
 	
    workFlowType.makeSelect(workFlowType.selectName,"");
    
    setWorkFlowSelect();

 	showForm(false);
 	getWorkFlowTypeTree(workFlowType);
 	getUserChTree(userCh);
 	getUserInTree(userIn);
 	
 	buttonEventFill();
	
	resetHeigth();
}

function buttonEventFill(){
	var Btn_save_flow = $("Btn_save_flow");
	Btn_save_flow.onclick = saveWorkFlow;
			
	var Btn_delete_flow = $("Btn_delete_flow");
	Btn_delete_flow.onclick = removeOaWorkFlow;
			
	var Btn_view_flow = $("Btn_view_flow");
	Btn_view_flow.onclick = showViewWorkFlows;	
	
	var Btn_add_income_flow = $("Btn_add_income_flow");
	Btn_add_income_flow.onclick = addIncomeWorkFlow;			
}

function setWorkFlowTypePara(obj){ 
	 obj.className  = "workFlowType";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 		= new Tree(obj.treebox); 
	 obj.selectName =  "workFlowTypeId";
}

function setWorkFlowPara(obj){
	 obj.className  = "workFlow";
	 obj.IdPrefix 	= obj.className + "Id";
}

function setUserChPara(obj){ 
	 obj.className  = "userCheck";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 		= new Tree(obj.treebox); 
	 obj.tableName  = obj.className + "Table";
}

function setUserInPara(obj){ 
	 obj.className  = "userIncome";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 		= new Tree(obj.treebox); 
	 obj.tableName  = obj.className + "Table";
}

//获得树信息
function getWorkFlowTypeTree(obj){
	obj_tree = obj.tree.dhtmlTree;	
	obj_tree.enableCheckBoxes(false);
	obj_tree.enableItemEditor(false);
	obj_tree.enableThreeStateCheckboxes(false);
	obj_tree.enableDragAndDrop(false);
	obj_tree.setOnClickHandler(doOnSelectWorkFlowTypeTree);
	//加载数据
	obj.reset();
	obj.obj.parentId = 0;
	obj.getTreeXML();
	obj_tree.loadXMLString(obj.tree.treeXML);
}

function getUserChTree(obj){
	obj_tree = obj.tree.dhtmlTree;	
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableItemEditor(false);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.enableDragAndDrop(true);
	loadUserTreeData(obj);
}
function getUserInTree(obj){
	obj_tree = obj.tree.dhtmlTree;	
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableItemEditor(false);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.enableDragAndDrop(true);
	loadUserTreeData(obj);
}

//加载数据
function loadUserTreeData(obj){
	obj_tree = obj.tree.dhtmlTree;	
	obj.reset();
	obj.getTreeXML();
	obj_tree.loadXMLString(obj.tree.treeXML);	
}

function doOnSelectWorkFlowTypeTree(itemId){
	workFlowType.tree.setCurSelectItemId(workFlowType.IdPrefix);
	
	var selectedItemId = workFlowType.tree.dhtmlTree.getSelectedItemId();
	var secondNodeId = workFlowType.tree.getSecondNodeId();
	
	if(selectedItemId != secondNodeId){
//		$(workFlowType.selectName).value = workFlowType.tree.curSelectItemId;
		showViewWorkFlows();	
	}
	
}

function validateOaWorkFlowForm() { 
	if ($("name").value =='') { 
		alert('流程名为必填项')
		return false; 
	} else{
		return true; 
	}
} 

function showForm(bn){
	
	if(bn){
		$("oaWorkFlowForm").show();	
		$("viewFlowSchem").hide();
        //如果是入口，需要显示被审核的用户
		if($("isFirstPoint").checked){
			$("userCheckTable").show();
			$("userIncomeTable").show();
			$("isFirstPoint").show();
		}else{
			$("userIncomeTable").hide();
			$("isFirstPoint").hide();
		}

	}else{
		$("oaWorkFlowForm").hide();	
		$("viewFlowSchem").show();
	}
}

function addIncomeWorkFlow(event){
    var parnetId = 0;
	if(!isDigit(event)){
		var e = event || window.event;
		var obj = Event.element(e);
		if(isUndefined(obj)){parnetId = event;}	
	}else{
		parnetId = event;
	}

    
   
//	if(obj.tagName != 'INPUT') parnetId = enent;


	
	var selectedItemId = workFlowType.tree.dhtmlTree.getSelectedItemId();
	

	
	var secondNodeId = workFlowType.tree.getSecondNodeId();


	
	
	if(selectedItemId != secondNodeId){

	   workFlow.reset();
	   workFlow.obj.workFlowTypeId = workFlowType.tree.curSelectItemId;
	   workFlow.obj.parentId = parnetId;
	   $(workFlowType.selectName).value = workFlow.obj.workFlowTypeId;
	   workFlow.obj.isFirstPoint = true;
	   
	   setWorkFlowSelect();
	   userCh.tree.refreshTree();
	   userIn.tree.refreshTree();
	   
	   DWRUtil.setValues(workFlow.obj);
	    $("parentId").value = parnetId;
	
	   
	   if(parnetId !=0){
	  	 $("isFirstPoint").checked = false;	   	
	  	 $("isFirstPoint").hide();
	   }else{
	   	 $("isFirstPoint").checked = true;	
	   	 $("isFirstPoint").show();
	   }

	   $("isEndPoint").checked = false;
	   
	   showForm(true);
	}
}


function setWorkFlowSelect(){
    var workFlowTypeId = $(workFlowType.selectName).value;
//    workFlow.makeSelect(workFlowTypeId,null,"agreeFlowId","");
//    workFlow.makeSelect(workFlowTypeId,null,"dissentFlowId","");
	 workFlow.reset();
	 workFlow.obj.workFlowTypeId = workFlowTypeId;
     workFlow.makeSelects(workFlow,"agreeFlowId","");
     workFlow.makeSelects(workFlow,"dissentFlowId","");   
}

    
function showViewWorkFlows(){
	showForm(false);
	var workFlowTypeId = workFlowType.tree.curSelectItemId;
	var viewStr = workFlow.getOaWorkFlowsView(workFlowTypeId,0);
	DWRUtil.setValue("viewFlowSchem",viewStr);	
}

function getWorkFlow(id){

	setWorkFlowSelect();
	
	workFlow.getOaWorkFlow(id);

	DWRUtil.setValues(workFlow.obj);

	userCh.tree.loadDataTreeArray2(userCh.IdPrefix,workFlow.obj.checkUsers);
	userIn.tree.loadDataTreeArray2(userIn.IdPrefix,workFlow.obj.cominUsers);
	
	showForm(true);
}


function saveWorkFlow(){
    var mode = "";
    if (validateOaWorkFlowForm()){

		DWRUtil.getValues(workFlow.obj);  
		


		var idsUserCheck = userCh.tree.getAllCheckedBranches(userCh.IdPrefix);
 		var idsUserIncome =  userIn.tree.getAllCheckedBranches(userIn.IdPrefix)

 		
 		if(idsUserIncome == '' || idsUserIncome == null) idsUserIncome =[];
 		if(idsUserCheck == '' || idsUserCheck == null) idsUserCheck =[];

		workFlow.obj.cominUsers = idsUserIncome;
		workFlow.obj.checkUsers = idsUserCheck;

		if($("id").value == "") mode = "new"
       
       
		workFlow.saveOaWorkFlow(workFlow.obj,mode);
		//显示视图
		showViewWorkFlows();
    }

}

function removeOaWorkFlow(){
	var id =$("id").value;
	workFlow.obj.id = id;
	workFlow.removeOaWorkFlow(id);
	//显示视图
	showViewWorkFlows();
}




















