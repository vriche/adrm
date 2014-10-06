      
        callOnLoad(init);	


		//动作填充 
		function buttonEventFill(){
			//保存载体
			var Btn_save_flow = $("Btn_save_flow");
			Btn_save_flow.onclick=button_saveWorkFlow;
			
			var Btn_delete_flow = $("Btn_delete_flow");
			Btn_delete_flow.onclick=button_removeWorkFlow;

//			var Btn_add_income_flow = $("Btn_add_income_flow");
//			Btn_add_income_flow.onclick=button_addIncomeWorkFlow;		
			
			var Btn_view_flow = $("Btn_view_flow");
			Btn_view_flow.onclick=button_viewWorkFlows;		

			var Btn_workFlowTypeId = $("workFlowTypeId");
			Btn_workFlowTypeId.onchange=getOaWorkFlowsMapOnChange;	
			
			var Btn_agreeFlowId = $("agreeFlowId");
			Btn_agreeFlowId.onchange=changeParent;							
						
		}  
		
		function init(){
       	    preLoadImages();
       	    buttonEventFill();
       	    workFlowType.parentId = 0;
       	    OaWorkFlowTypeManager.getOaWorkFlowTypesXml(workFlowType,IdPrefix,getxml);
       	    UserManager.getUsersXML(user,IdPrefix,getUserXML);
       	    $("oaWorkFlowForm").hide();
       }
       
       
       