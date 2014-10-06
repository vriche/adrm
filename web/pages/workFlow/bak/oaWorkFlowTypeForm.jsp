<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaWorkFlowTypeDetail.title"/></title>
<content tag="heading"><fmt:message key="oaWorkFlowTypeDetail.heading"/></content>

<html:form action="saveOaWorkFlowType" method="post" styleId="oaWorkFlowTypeForm" onsubmit="return validateOaWorkFlowTypeForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowTypeForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowTypeForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowTypeForm.displayNo"/>
        <html:errors property="displayNo"/>
        <html:text property="displayNo" styleId="displayNo" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowTypeForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowTypeForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowTypeForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowTypeForm.nodeLevel"/>
        <html:errors property="nodeLevel"/>
        <html:text property="nodeLevel" styleId="nodeLevel" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowTypeForm.parentId"/>
        <html:errors property="parentId"/>
        <html:text property="parentId" styleId="parentId" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('OaWorkFlowType')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("oaWorkFlowTypeForm"));
</script>

<html:javascript formName="oaWorkFlowTypeForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
