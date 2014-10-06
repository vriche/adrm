<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaWorkFlowCheckDetail.title"/></title>
<content tag="heading"><fmt:message key="oaWorkFlowCheckDetail.heading"/></content>

<html:form action="saveOaWorkFlowCheck" method="post" styleId="oaWorkFlowCheckForm" onsubmit="return validateOaWorkFlowCheckForm(this)">
<ul>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
   <tr> 
   <td width="50%">	    

	<table width="20%" border="0" cellspacing="0" cellpadding="0">
	<tbody>

	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaWorkFlowCheckForm.workFlowTypeId"/>:       	
	        </td>
	        <td>
		        <html:errors property="workFlowTypeId"/>
		        <html:text property="workFlowTypeId" styleId="workFlowTypeId"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaWorkFlowCheckForm.checkIdea"/>:       	
	        </td>
	        <td>
		        <html:errors property="checkIdea"/>
		        <html:text property="checkIdea" styleId="checkIdea"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaWorkFlowCheckForm.checkStateId"/>:       	
	        </td>
	        <td>
		        <html:errors property="checkStateId"/>
		        <html:text property="checkStateId" styleId="checkStateId"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaWorkFlowCheckForm.workFlowId"/>:       	
	        </td>
	        <td>
		        <html:errors property="workFlowId"/>
		        <html:text property="workFlowId" styleId="workFlowId"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaWorkFlowCheckForm.checkUserId"/>:       	
	        </td>
	        <td>
		        <html:errors property="checkUserId"/>
		        <html:text property="checkUserId" styleId="checkUserId"/>
			</td>
		</tr>
  		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">	
		    	<adrm_order:label styleClass="" key="oaWorkFlowCheckForm.workFlowTypeId"/>:
	        </td>
	        <td>
				<div style="position:relative;">
				<span style="margin-left:100px;width:18px;overflow:hidden;">
				  	<adrm_order:selectList name="workFlowTypes" key="21"  toScope="page"/> 
				     <html:select property="workFlowTypeId" styleId="workFlowTypeId"  style="width:140px;margin-left:-100px"> 
				     <html:option value=""/> <html:options collection="workFlowTypes"  property="value" labelProperty="label"/> 
				     </html:select> 								
				</span>
				<html:errors property="workFlowTypeId"/>
				</div>  	
			</td>
		</tr>    
	</tbody>
 </table>
 </td></tr>
 </table>  

&nbsp;&nbsp;

<table width="26%" border="0" cellspacing="0" cellpadding="0">
	 <tr>
		<td>
			<div align="center">
		        <html:submit styleClass="" property="method.save" onclick="bCancel=false">
		            <fmt:message key="button.save"/>
		        </html:submit>
		
		        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('OaWorkFlowCheck')">
		            <fmt:message key="button.delete"/>
		        </html:submit>
		
		        <html:cancel styleClass="" onclick="bCancel=true">
		            <fmt:message key="button.cancel"/>
		        </html:cancel>
	        </div>
		 </td>
	</tr>
</table>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("oaWorkFlowCheckForm"));
</script>

<html:javascript formName="oaWorkFlowCheckForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
