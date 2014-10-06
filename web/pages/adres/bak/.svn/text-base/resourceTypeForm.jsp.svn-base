<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="resourceTypeDetail.title"/></title>
<content tag="heading"><fmt:message key="resourceTypeDetail.heading"/></content>

<html:form action="saveResourceType" method="post" styleId="resourceTypeForm" onsubmit="return validateResourceTypeForm(this)">
<ul>

    <li>
        <adrm_adres:label styleClass="desc" key="resourceTypeForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_adres:label styleClass="desc" key="resourceTypeForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_adres:label styleClass="desc" key="resourceTypeForm.enable"/>
        <html:errors property="enable"/>
        <html:text property="enable" styleId="enable" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_adres:label styleClass="desc" key="resourceTypeForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_adres:label styleClass="desc" key="resourceTypeForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_adres:label styleClass="desc" key="resourceTypeForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_adres:label styleClass="desc" key="resourceTypeForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>

    <li>
        <adrm_adres:label styleClass="desc" key="resourceTypeForm.value"/>
        <html:errors property="value"/>
        <html:text property="value" styleId="value" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('ResourceType')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("resourceTypeForm"));
</script>

<html:javascript formName="resourceTypeForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
