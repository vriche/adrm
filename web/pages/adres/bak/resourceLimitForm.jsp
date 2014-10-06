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
        <html:errors property="startTime"/>
        <html:text property="startTime" styleId="startTime" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceLimitForm.endTime"/>
        <html:errors property="endTime"/>
        <html:text property="endTime" styleId="endTime" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="resourceLimitForm.carrier"/>
        <html:errors property="carrier"/>
        <html:text property="carrier" styleId="carrier" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceLimitForm.endT"/>
        <html:errors property="endT"/>
        <html:text property="endT" styleId="endT" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceLimitForm.limitT"/>
        <html:errors property="limitT"/>
        <html:text property="limitT" styleId="limitT" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceLimitForm.limitTime"/>
        <html:errors property="limitTime"/>
        <html:text property="limitTime" styleId="limitTime" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceLimitForm.starT"/>
        <html:errors property="starT"/>
        <html:text property="starT" styleId="starT" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceLimitForm.usedT"/>
        <html:errors property="usedT"/>
        <html:text property="usedT" styleId="usedT" styleClass="text medium"/>

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
