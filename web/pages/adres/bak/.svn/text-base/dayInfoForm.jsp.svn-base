<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="dayInfoDetail.title"/></title>
<content tag="heading"><fmt:message key="dayInfoDetail.heading"/></content>

<html:form action="saveDayInfo" method="post" styleId="dayInfoForm" onsubmit="return validateDayInfoForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="dayInfoForm.carrierId"/>
        <html:errors property="carrierId"/>
        <html:text property="carrierId" styleId="carrierId" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="dayInfoForm.propertiyTime"/>
        <html:errors property="propertiyTime"/>
        <html:text property="propertiyTime" styleId="propertiyTime" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="dayInfoForm.publishDate"/>
        <html:errors property="publishDate"/>
        <html:text property="publishDate" styleId="publishDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="dayInfoForm.resourceId"/>
        <html:errors property="resourceId"/>
        <html:text property="resourceId" styleId="resourceId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="dayInfoForm.resourceType"/>
        <html:errors property="resourceType"/>
        <html:text property="resourceType" styleId="resourceType" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="dayInfoForm.specific"/>
        <html:errors property="specific"/>
        <html:text property="specific" styleId="specific" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="dayInfoForm.total"/>
        <html:errors property="total"/>
        <html:text property="total" styleId="total" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="dayInfoForm.used"/>
        <html:errors property="used"/>
        <html:text property="used" styleId="used" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="dayInfoForm.version"/>
        <html:errors property="version"/>
        <html:text property="version" styleId="version" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="dayInfoForm.workspanId"/>
        <html:errors property="workspanId"/>
        <html:text property="workspanId" styleId="workspanId" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('DayInfo')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("dayInfoForm"));
</script>

<html:javascript formName="dayInfoForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
