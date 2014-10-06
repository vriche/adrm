
var viewFlowSchem  = "";
 
//�������
var workFlow = 
	{
	id:null, 					
	name:null,
	workFlowTypeId:null, 					
	workFlowMoveTypeId:null,
	parentId:null, 										
	agreeFlowId:null,	
	dissentFlowId:null, 					
	isFirstPoint:null,	
	isEndPoint:null,	
	createBy:null, 					
	createDate:null,	
	modifyBy:null,
	cominUsers:[],
	checkUsers:[],
	modifyDate:null
};



//��ն���
function reset(){
	workFlow.id = null;
	workFlow.name = null;
	workFlow.workFlowTypeId = null;
	workFlow.workFlowMoveTypeId = null;
	workFlow.parentId = null;				
	workFlow.agreeFlowId = null,	
	workFlow.dissentFlowId = null, 					
	workFlow.isFirstPoint = null,	
	workFlow.isEndPoint = null,
	workFlow.createBy = null, 					
	workFlow.createDate = null,	
	workFlow.modifyBy = null,
	workFlow.cominUsers = [],
	workFlow.checkUsers = [],
	workFlow.modifyDate = null
}

//����������ڣ�Ĭ�� parentId Ϊ0
function addIncomeWorkFlow(parentId){
	$("viewFlowSchem").hide();
	$("oaWorkFlowForm").show();
	
	//ˢ�¶���
	reset();
	DWRUtil.setValues(workFlow);
	
	//ˢ����
	refreshTree(treeUserIncome);
	refreshTree(treeUserCheck);

	//������ڽڵ㲻��Ҫ ѡ������û�
    checkParentIsViewUserIncome(parentId);

	var workFlowTypeId = getWorkFlowTypeId();
	$("workFlowTypeId").value = workFlowTypeId;
	$("parentId").value = parentId;
	
	DWREngine.setAsync(false);
	getOaWorkFlowsMap(workFlowTypeId);
	DWREngine.setAsync(true);

	DWRUtil.setValue("agreeFlowId",0);
	DWRUtil.setValue("dissentFlowId",0);

}




function checkParentIsViewUserIncome(parentId){
	if (parentId == 0){
		$("treeBoxUserIncome").show();
	}else{
		$("treeBoxUserIncome").hide();
	}
}

function changeParent(){
	
	if( DWRUtil.getValue("agreeFlowId") != 0){
		$("parentId").value = DWRUtil.getValue("agreeFlowId");
	}
	
}

//�����������
function button_viewWorkFlows(){
	
	$("viewFlowSchem").show();
	$("oaWorkFlowForm").hide();
	    
	var workFlowTypeId = getWorkFlowTypeId();
	
//	alert(workFlowTypeId);
	getWorkFlows(workFlowTypeId,0);		
}



//����������𣬻�ȡ������Ϣ
function getWorkFlows(workFlowTypeId,parentId){
	    reset();
		workFlow.workFlowTypeId = workFlowTypeId;
		workFlow.parentId = parentId;
//		OaWorkFlowManager.getOaWorkFlows(fillWorkFlowTable,workFlow);
		OaWorkFlowManager.getOaWorkFlowsView(function(workFlowViewStr){DWRUtil.setValue("viewFlowSchem",workFlowViewStr);},workFlow);
}



//����ID��ýڵ���Ϣ
function getWorkFlow(id){
		$("viewFlowSchem").hide();
	    $("oaWorkFlowForm").show();
	
	    reset();
	    DWRUtil.setValues(workFlow);
	    
	    var workFlowTypeId = getWorkFlowTypeId()
	    
	     //���ó�ͬ��
	    DWREngine.setAsync(false);
	    getOaWorkFlowsMap(workFlowTypeId);
	    //��������Ϊ�첽��ʽ
        DWREngine.setAsync(true);
        OaWorkFlowManager.getOaWorkFlow(
	       function(workFlow)
	       {
	       	DWRUtil.setValues(workFlow);
	       	//�ж��Ƿ����
	       	checkParentIsViewUserIncome(workFlow.parentId);
	       	// cominUsers checkUsers ����һ���Ƕ�ά���� 
            loadDataTree(treeUserIncome,workFlow.cominUsers);
            loadDataTree(treeUserCheck,workFlow.checkUsers);
	       },
       id);
       
}


//����
function button_saveWorkFlow(){

    if (validateOaWorkFlowForm()){
		DWRUtil.getValues(workFlow);
//		convertBoolean2Integer(workFlow);
 		var idsUserIncome =convertIdByPrefix(treeUserIncome.getAllChecked().split(","),IdPrefix);
 		var idsUserCheck = convertIdByPrefix(treeUserCheck.getAllChecked().split(","),IdPrefix);
 		
 		if(idsUserIncome == '') idsUserIncome =[];
 		if(idsUserCheck == '') idsUserCheck =[];

		workFlow.cominUsers = idsUserIncome;
		workFlow.checkUsers = idsUserCheck;
		OaWorkFlowManager.saveOaWorkFlow(workFlow,function(){button_viewWorkFlows();});    	
    }

}

function convertIdByPrefix(ids,IdPrefix){

	var id = [];
	for(var i =0;i<ids.length;i++){
		var source = ids[i];
		var fixLen = IdPrefix.length;
		var end  = source.length;
		id[i] = source.substring(fixLen,end);
	}
	
	return id;
}


//ɾ��
function button_removeWorkFlow(){
	 if (confirmDelete('oaWorkFlowForm')){  
		var id =$("id").value;
		OaWorkFlowManager.removeOaWorkFlow(function(){button_viewWorkFlows();},id);	 	
	 }

}


function getOaWorkFlowsMap(workFlowTypeId){
	workFlow.workFlowTypeId = workFlowTypeId;
	OaWorkFlowManager.getOaWorkFlowsMap(workFlowFillForm,workFlow);	
}

function getOaWorkFlowsMapOnChange(event){
	var e = event || window.event;
	var obj = Event.element(e);
	getOaWorkFlowsMap(obj.selectedIndex);
}


//��������ʼ����������
function workFlowFillForm(workFlowsMap){
 
  DWRUtil.removeAllOptions("agreeFlowId");
  DWRUtil.addOptions("agreeFlowId", workFlowsMap);

  DWRUtil.removeAllOptions("dissentFlowId");
  DWRUtil.addOptions("dissentFlowId", workFlowsMap); 
}



//������ͱ��
function getWorkFlowTypeId(){
	var workFlowTypeId = $("workFlowTypeId").value;

	if(isUndefined(workFlowTypeId) || (workFlowTypeId !='0')){
		var selectedId = tree.getSelectedItemId();
		workFlowTypeId = tree.getUserData(selectedId,"workFlowTypeId");	
	}
	if(isUndefined(workFlowTypeId))workFlowTypeId = 0;
    return workFlowTypeId;	
}


function refreshTree(treeName){
			// -1 ��root �ڵ� id
			var secondNodeId = getItemIdByIndex(treeName,0);
			treeName.setCheck(secondNodeId,0);
}		
		
		
function getItemIdByIndex(treeName,index){
            var rootId = treeName.rootId;
            var i = treeName.getChildItemIdByIndex(rootId,0);
			return i;
}	



    function validateOaWorkFlowForm() { 
//        alert($("name").value);
        if ($("name").value =='') { 
        	alert('������Ϊ������')
            return false; 
        } else{
        	return true; 
        }
    } 
    
    

