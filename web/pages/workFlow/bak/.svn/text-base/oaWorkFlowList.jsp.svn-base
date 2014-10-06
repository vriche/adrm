<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaWorkFlowList.title"/></title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/OaWorkFlowTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaWorkFlowManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/workFlow/public.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/workFlow/typeTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/workFlow/userTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/workFlow/flow.js'/>"></script>



<content tag="heading"><fmt:message key="oaWorkFlowList.heading"/></content>
<meta name="menu" content="OaWorkFlowMenu"/>

<c:out value="${buttons}" escapeXml="false"/>
<table width="100%" border="0">
  <!-- tr>
  <td>
  	<input type="button" id="Btn_add_flow" value="add flow">
  </td>
  <td></td>
  </tr -->
  
  <tr>
  
    <td width="20%" vAlign="top">

    <input type="button" id="Btn_add_income_flow" value="<fmt:message key="add_income_flow"/>"  onclick="addIncomeWorkFlow(0)">
    
								<!-- type tree -->
								<div id="treebox" 
									 style="width:100%; 
									 height:500px;
									 background-color:#f5f5f5;
									 border :1px solid Silver;"/>
								<iframe name="actionframe" id="actionframe" frameborder="0" width="100%" height="0"></iframe>
								
	</td>
	
    <td vAlign="top">
    <br>
	<span id="viewFlowSchem" style="display:block;"></span>
    
    <html:form action="saveOaWorkFlow" method="post" styleId="oaWorkFlowForm" onsubmit="return validateOaWorkFlowForm(this)">	
 	<html:hidden property="id" styleId="id"/>
	<html:hidden property="version"/>   	
	<html:hidden property="parentId" styleId="parentId"/>				
    					
		<fieldset style="width: 95%"> 
             <legend></legend>
             <table width="100%" border="0" cellspacing="0" cellpadding="0">
             	<tr>
             		<td width="10%">				
						<!--工作流类别--!>
						<adrm_order:label styleClass="" key="oaWorkFlowCheckForm.workFlowTypeId"/>
					</td>
					<td>			
						<div style="position:relative;">
							<span style="margin-left:100px;width:18px;overflow:hidden;">
							  	<adrm_order:selectList name="workFlowTypes" key="21"  toScope="page"/> 
							     <html:select property="workFlowTypeId" styleId="workFlowTypeId"  style="width:137px;margin-left:-100px" > 
							     <html:option value=""/> <html:options collection="workFlowTypes"  property="value" labelProperty="label" /> 
							     </html:select> 								
							</span>
						</div>   
		           </td>
	           </tr>
	           
				<tr>
			  	   <td>
			        <adrm_order:label styleClass="" key="oaWorkFlowForm.name"/>
			       </td>
			       <td> 
			        <html:errors property="name"/>
			        <html:text property="name" styleId="name" styleClass=""/>
			       </td>
			    </tr>
			    
				 <tr>
				     <td>
				        <adrm_order:label styleClass="" key="oaWorkFlowForm.agreeFlowId"/>
				     </td>
				     <td>   
				        <html:errors property="agreeFlowId"/>
				        <select name="agreeFlowId" id="agreeFlowId"></select>
				    </td>    
				</tr>    
				    
				<tr>    
				    <td>
				        <adrm_order:label styleClass="" key="oaWorkFlowForm.dissentFlowId"/>
				    </td>
				    <td>    
				        <html:errors property="dissentFlowId"/>
				        <select name="dissentFlowId" id="dissentFlowId"></select>
				    </td>    
				</tr>  
				
				<tr>  
				   <td>
				        <adrm_order:label styleClass="" key="oaWorkFlowForm.isFirstPoint"/>
				   </td>
				   <td>    
				        <html:errors property="isFirstPoint"/>
				        <html:checkbox styleClass="checkbox" property="isFirstPoint" styleId="isFirstPoint"  value="0"/>
				    </td>
			 	</tr>	        
				    
				<tr>	    
				     <td>
				        <adrm_order:label styleClass="" key="oaWorkFlowForm.isEndPoint"/>
				     </td>
				     <td>   
				        <html:errors property="isEndPoint"/>
				        <html:checkbox styleClass="checkbox" property="isEndPoint" styleId="isEndPoint"/>
					 </td>
				</tr>	 
				
				<tr>
				  	<td>  
					    <!--流程流转方式--!>
						<adrm_order:label styleClass="" key="oaWorkFlowForm.workFlowMoveTypeId"/>		
					</td>
					<td>	
						<div style="position:relative;">
							<span style="margin-left:100px;width:18px;overflow:hidden;">
							  	<adrm_order:selectList name="workFlowMoveTypeIds" key="35"  toScope="page"/> 
							     <html:select property="workFlowMoveTypeId" styleId="workFlowMoveTypeId"  style="width:140px;margin-left:-100px"> 
							     <html:option value=""/> <html:options collection="workFlowMoveTypeIds"  property="value" labelProperty="label"/> 
							     </html:select> 								
							</span>
						</div>   
				 	</td>	
				</tr>
	        </table>   
	       <br>
	       

			<br><hr>
			


			
<table width="75%" border="0">
  <tr> 
    <td>
    



		<table width="100%" border="0">
        <tr>
          <td>treeBoxUserCheck</td>
        </tr>
        <tr>
          <td>
								<div id="treeBoxUserCheck" 
									 style="width:150px; 
									 height:200px;
									 background-color:#CCCCCC;
									 border :1px solid Silver;"/>
		</td>
        </tr>
      </table>
      
      
	</td>
    <td>

    	<table width="100%" border="0">
        <tr>
          <td>treeBoxUserIncome</td>
        </tr>
        <tr>
          <td>
								<div id="treeBoxUserIncome" 
									 style="width:150px; 
									 height:200px;
									 background-color:#CCCCCC;
									 border :1px solid Silver;"/>
		</td>
        </tr>
      </table>


	</td>
  </tr>
</table>
			
			
				
		</fieldset>		 
	
		
		<fieldset style="width: 95%">
			<legend></legend>
				<input type="button" id="Btn_save_flow" value="<fmt:message key="button.save"/>">
				<input type="button" id="Btn_delete_flow" value="<fmt:message key="button.delete"/>">
				<input type="button" id="Btn_view_flow" value="<fmt:message key="button.cancel"/>">			
		</fieldset>	
		
	</html:form>  	
		
	</td>
  </tr>
</table>








	<table>
					<tbody id="workFlowTbody" name="workFlowTbody"></tbody>
					<tr><td><td><tr>
					
	</table>
				



