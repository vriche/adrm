<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="branchDetail.title"/></title>
<content tag="heading"><fmt:message key="branchDetail.heading"/></content>

<html:form action="saveBranch" method="post" styleId="branchForm" onsubmit="return validateBranchForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="branchForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="branchForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="branchForm.displayNo"/>
        <html:errors property="displayNo"/>
        <html:text property="displayNo" styleId="displayNo" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="branchForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="branchForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="branchForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>


    <li>
        <adrm_order:label styleClass="desc" key="branchForm.orgId"/>
        <html:errors property="orgId"/>
        <html:text property="orgId" styleId="orgId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="branchForm.parentId"/>
        <html:errors property="parentId"/>
        <html:text property="parentId" styleId="parentId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="branchForm.treeLevel"/>
        <html:errors property="treeLevel"/>
        <html:text property="treeLevel" styleId="treeLevel" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>



    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('Branch')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("branchForm"));
</script>

<html:javascript formName="branchForm" cdata="false" dynamicJavascript="false" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
