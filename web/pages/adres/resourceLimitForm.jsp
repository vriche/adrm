<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="resourceLimitDetail.title"/></title>
<content tag="heading"><fmt:message key="resourceLimitDetail.heading"/></content>

<html:form action="saveResourceLimit" method="post" styleId="resourceLimitForm" onsubmit="return validateResourceLimitForm(this)">
<ul>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="resourceLimitForm.carrierId"/>
        <html:errors property="carrierId"/>
        <html:text property="carrierId" styleId="carrierId" styleClass="text medium"/>

    </li>


    
    <li>
        <adrm_order:label styleClass="desc" key="resourceLimitForm.startTime"/>
        <adrm_order:label styleClass="desc" key="resourceLimitForm.starTh"/>
        <html:errors property="starTh"/>
        <html:text property="starTh" styleId="starTh" styleClass="text medium"/>

    </li>
    
      <li>
        <adrm_order:label styleClass="desc" key="resourceLimitForm.startTime"/>
         <adrm_order:label styleClass="desc" key="resourceLimitForm.starTm"/>
        <html:errors property="starTm"/>
        <html:text property="starTm" styleId="starTm" styleClass="text medium"/>

    </li>  
    
    
     <li>
        <adrm_order:label styleClass="desc" key="resourceLimitForm.endTime"/>
        <adrm_order:label styleClass="desc" key="resourceLimitForm.endTh"/>
        <html:errors property="endTh"/>
        <html:text property="endTh" styleId="endTh" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceLimitForm.endTime"/>
        <adrm_order:label styleClass="desc" key="resourceLimitForm.endTm"/>
        <html:errors property="endTm"/>
        <html:text property="endTm" styleId="endTm" styleClass="text medium"/>

    </li>



    <li>
        <adrm_order:label styleClass="desc" key="resourceLimitForm.version"/>
        <html:errors property="version"/>
        <html:text property="version" styleId="version" styleClass="text medium"/>
    </li>

   

    <li>
        <adrm_order:label styleClass="desc" key="resourceLimitForm.limitTime"/>
        <html:errors property="limitTime"/>
        <html:text property="limitTime" styleId="limitTime" styleClass="text medium"/>

    </li>

    

   

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('ResourceLimit')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("resourceLimitForm"));
</script>

<html:javascript formName="resourceLimitForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
