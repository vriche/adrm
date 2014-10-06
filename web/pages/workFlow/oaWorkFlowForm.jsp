<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaWorkFlowDetail.title"/></title>
<content tag="heading"><fmt:message key="oaWorkFlowDetail.heading"/></content>

<html:form action="saveOaWorkFlow" method="post" styleId="oaWorkFlowForm" onsubmit="return validateOaWorkFlowForm(this)">
<ul>




<html:hidden property="id"/>



   
    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>
    
    
    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowForm.parentId"/>
        <html:errors property="parentId"/>
        <html:text property="parentId" styleId="parentId" styleClass="text medium"/>

    </li>
    
      <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowForm.nodeLevel"/>
        <html:errors property="nodeLevel"/>
        <html:text property="nodeLevel" styleId="nodeLevel" styleClass="text medium"/>

    </li>  
    
     <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowForm.displayNo"/>
        <html:errors property="displayNo"/>
        <html:text property="displayNo" styleId="displayNo" styleClass="text medium"/>

    </li>  
    
     <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowForm.agreeFlowId"/>
        <html:errors property="agreeFlowId"/>
        <html:text property="agreeFlowId" styleId="agreeFlowId" styleClass="text medium"/>

    </li>    
    
    
         <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowForm.dissentFlowId"/>
        <html:errors property="dissentFlowId"/>
        <html:text property="dissentFlowId" styleId="dissentFlowId" styleClass="text medium"/>

    </li>    
    
         <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowForm.isFirstPoint"/>
        <html:errors property="isFirstPoint"/>
        <html:text property="isFirstPoint" styleId="isFirstPoint" styleClass="text medium"/>

    </li>    
    
        </li>    
    
     <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowForm.isEndPoint"/>
        <html:errors property="isEndPoint"/>
        <html:text property="isEndPoint" styleId="isEndPoint" styleClass="text medium"/>


    
    <!--流程流转方式--!>		
	<div style="position:relative;">
	<adrm_order:label styleClass="" key="oaWorkFlowForm.workFlowMoveTypeId"/>
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="workFlowMoveTypeIds" key="35"  toScope="page"/> 
		     <html:select property="workFlowMoveTypeId" styleId="workFlowMoveTypeId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="workFlowMoveTypeIds"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>   

<html:hidden property="version"/>


	<!--工作流类别--!>		
	<div style="position:relative;">
	<adrm_order:label styleClass="" key="oaWorkFlowCheckForm.workFlowTypeId"/>
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="workFlowTypes" key="21"  toScope="page"/> 
		     <html:select property="workFlowTypeId" styleId="workFlowTypeId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="workFlowTypes"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>   

   
    <li class="buttonBar bottom">
        <html:submit styleClass="" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('OaWorkFlow')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>



<script type="text/javascript">
    Form.focusFirstElement($("oaWorkFlowForm"));
</script>

<html:javascript formName="oaWorkFlowForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
