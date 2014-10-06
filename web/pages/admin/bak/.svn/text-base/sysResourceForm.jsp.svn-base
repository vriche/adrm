<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="sysResourceDetail.title"/></title>
<content tag="heading"><fmt:message key="sysResourceDetail.heading"/></content>

<html:form action="saveSysResource" method="post" styleId="sysResourceForm" onsubmit="return validateSysResourceForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="sysResourceForm.authorized"/>
        <html:errors property="authorized"/>
        <html:text property="authorized" styleId="authorized" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysResourceForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysResourceForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="sysResourceForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysResourceForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysResourceForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysResourceForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysResourceForm.resString"/>
        <html:errors property="resString"/>
        <html:text property="resString" styleId="resString" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysResourceForm.resType"/>
        <html:errors property="resType"/>
        <html:text property="resType" styleId="resType" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysResourceForm.roles"/>
        <html:errors property="roles"/>
        <html:text property="roles" styleId="roles" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('SysResource')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("sysResourceForm"));
</script>

<html:javascript formName="sysResourceForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
