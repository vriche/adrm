<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaWorkFlowList.title"/></title>
<content tag="heading"><fmt:message key="oaWorkFlowList.heading"/></content>
<meta name="menu" content="OaWorkFlowMenu"/>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>


<script type="text/javascript" src="<c:url value='/dwr/interface/OaWorkFlowTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaWorkFlowManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/address.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/oaWorkFlow.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/oaWorkFlowType.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/workFlow/workFlowService.js'/>"></script>

<title><fmt:message key="oaWorkFlowList.title"/></title>
<content tag="heading"><fmt:message key="oaWorkFlowList.heading"/></content>
<meta name="menu" content="OaWorkFlowMenu"/>




<c:out value="${buttons}" escapeXml="false"/>


<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                    <td><span class="tile1">
                    
                     <a id="Btn_add_income_flow" class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.addIncomeFlow"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
                       
                    </span>
                    </td>
                  </tr>
                </tbody>
              </table></td>
            <td width="115"><img src="images/table1/textbox_top_right.jpg" height="27"></td>
          </tr>
        </tbody>
      </table></td>
  </tr>
  <tr>
    <td><table border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td background="images/table1/textbox_left.gif" width="14"></td>
            <td bgcolor="#f4f3f4">


<table width="100%" border="0">
  <!-- tr>
  <td>
  	<input type="button" id="Btn_add_flow" value="add flow">
  </td>
  <td></td>
  </tr -->
  


  <tr>

    <td width="20%" vAlign="top">
    
								<!-- type tree -->
								<div id="workFlowTypeTreebox" 
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
             
             <table width="100%" border="0" cellspacing="0" cellpadding="0">
             	<tr>
             		<td width="10%">				
						<!--工作流类别--!>
						<adrm_order:label styleClass="" key="oaWorkFlowCheckForm.workFlowTypeId"/>
					</td>
					<td>	
						<select name="workFlowTypeId" id="workFlowTypeId"/>
					 	

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
				        <input type="checkBox" id="isFirstPoint">
				    </td>
			 	</tr>	        
				    
				<tr>	    
				     <td>
				        <adrm_order:label styleClass="" key="oaWorkFlowForm.isEndPoint"/>
				     </td>
				     <td>   
				        <html:errors property="isEndPoint"/>
				        <input type="checkBox" id="isEndPoint">
					 </td>
				</tr>	 
				
			
	        </table>   
		
		<hr>
			


			
<table width="75%" border="0">
  <tr> 
    <td>
    



		<table width="100%" border="0" id="userCheckTable">
        <tr>
          <td><fmt:message key="oaWorkFlowDetail.titleUserCheck"/></td>
        </tr>
        <tr>
          <td>
								<div id="userCheckTreebox" 
									 style="width:150px; 
									 height:200px;
									 background-color:#CCCCCC;
									 border :1px solid Silver;"/>
		</td>
        </tr>
      </table>
      
      
	</td>
    <td>

    	<table width="100%" border="0" id="userIncomeTable">
        <tr>
          <td><fmt:message key="oaWorkFlowDetail.titleUserIncome"/></td>
        </tr>
        <tr>
          <td>
								<div id="userIncomeTreebox" 
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
				

            </td>
            <td width="14" background="images/table1/textbox_right.gif"></td>
          </tr>
        </tbody>
      </table></td>
  </tr>
  <tr> 
    <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tbody>
          <tr> 
            <td width="14"><img src="images/table1/textbox_bottom_left.gif" height="19" width="14"></td>
            <td width="100%" background="images/table1/textbox_bottom.gif"></td>
            <td width="14"><img src="images/table1/textbox_bottom_right.gif" height="19" width="14"></td>
          </tr>
        </tbody>
      </table></td>
  </tr>
</table>

