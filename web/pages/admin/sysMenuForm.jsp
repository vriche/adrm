<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="sysMenuDetail.title"/></title>
<content tag="heading"><fmt:message key="sysMenuDetail.heading"/></content>

<html:form action="saveSysMenu" method="post" styleId="sysMenuForm" onsubmit="return validateSysMenuForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.action"/>
        <html:errors property="action"/>
        <html:text property="action" styleId="action" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.altImage"/>
        <html:errors property="altImage"/>
        <html:text property="altImage" styleId="altImage" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.description"/>
        <html:errors property="description"/>
        <html:text property="description" styleId="description" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.displayNo"/>
        <html:errors property="displayNo"/>
        <html:text property="displayNo" styleId="displayNo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.forward"/>
        <html:errors property="forward"/>
        <html:text property="forward" styleId="forward" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.height"/>
        <html:errors property="height"/>
        <html:text property="height" styleId="height" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.image"/>
        <html:errors property="image"/>
        <html:text property="image" styleId="image" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.location"/>
        <html:errors property="location"/>
        <html:text property="location" styleId="location" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.onclick"/>
        <html:errors property="onclick"/>
        <html:text property="onclick" styleId="onclick" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.onmouseout"/>
        <html:errors property="onmouseout"/>
        <html:text property="onmouseout" styleId="onmouseout" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.onmouseover"/>
        <html:errors property="onmouseover"/>
        <html:text property="onmouseover" styleId="onmouseover" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.pageNum"/>
        <html:errors property="pageNum"/>
        <html:text property="pageNum" styleId="pageNum" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.parentId"/>
        <html:errors property="parentId"/>
        <html:text property="parentId" styleId="parentId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.roles"/>
        <html:errors property="roles"/>
        <html:text property="roles" styleId="roles" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.target"/>
        <html:errors property="target"/>
        <html:text property="target" styleId="target" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.title"/>
        <html:errors property="title"/>
        <html:text property="title" styleId="title" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.tooltip"/>
        <html:errors property="tooltip"/>
        <html:text property="tooltip" styleId="tooltip" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.treeLevel"/>
        <html:errors property="treeLevel"/>
        <html:text property="treeLevel" styleId="treeLevel" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="sysMenuForm.width"/>
        <html:errors property="width"/>
        <html:text property="width" styleId="width" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('SysMenu')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("sysMenuForm"));
</script>

<html:javascript formName="sysMenuForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
