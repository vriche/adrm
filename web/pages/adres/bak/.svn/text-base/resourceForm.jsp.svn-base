<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="resourceDetail.title"/></title>
<content tag="heading"><fmt:message key="resourceDetail.heading"/></content>

<html:form action="saveResource" method="post" styleId="resourceForm" onsubmit="return validateResourceForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="resourceForm.workspans"/>
        <html:errors property="workspans"/>
        <html:text property="workspans" styleId="workspans" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceForm.carrierId"/>
        <html:errors property="carrierId"/>
        <html:text property="carrierId" styleId="carrierId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceForm.displayNo"/>
        <html:errors property="displayNo"/>
        <html:text property="displayNo" styleId="displayNo" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="resourceForm.isClosed"/>
        <html:errors property="isClosed"/>
        <html:text property="isClosed" styleId="isClosed" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceForm.isManual"/>
        <html:errors property="isManual"/>
        <html:text property="isManual" styleId="isManual" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceForm.isOverweight"/>
        <html:errors property="isOverweight"/>
        <html:text property="isOverweight" styleId="isOverweight" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceForm.isSeralized"/>
        <html:errors property="isSeralized"/>
        <html:text property="isSeralized" styleId="isSeralized" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceForm.isValidate"/>
        <html:errors property="isValidate"/>
        <html:text property="isValidate" styleId="isValidate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceForm.propertiyTime"/>
        <html:errors property="propertiyTime"/>
        <html:text property="propertiyTime" styleId="propertiyTime" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceForm.proResourceId"/>
        <html:errors property="proResourceId"/>
        <html:text property="proResourceId" styleId="proResourceId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceForm.proResourceMemo"/>
        <html:errors property="proResourceMemo"/>
        <html:text property="proResourceMemo" styleId="proResourceMemo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceForm.resourceName"/>
        <html:errors property="resourceName"/>
        <html:text property="resourceName" styleId="resourceName" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceForm.resourceType"/>
        <html:errors property="resourceType"/>
        <html:text property="resourceType" styleId="resourceType" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="resourceForm.enable"/>
        <html:errors property="enable"/>
        <html:text property="enable" styleId="enable" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="resourceForm.prices"/>
        <html:errors property="prices"/>
        <html:text property="prices" styleId="prices" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('Resource')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("resourceForm"));
</script>

<html:javascript formName="resourceForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
