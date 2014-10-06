<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaDocumentCatalogDetail.title"/></title>
<content tag="heading"><fmt:message key="oaDocumentCatalogDetail.heading"/></content>

<html:form action="saveOaDocumentCatalog" method="post" styleId="oaDocumentCatalogForm" onsubmit="return validateOaDocumentCatalogForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentCatalogForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentCatalogForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentCatalogForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentCatalogForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentCatalogForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentCatalogForm.displayNo"/>
        <html:errors property="displayNo"/>
        <html:text property="displayNo" styleId="displayNo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentCatalogForm.nodeLevel"/>
        <html:errors property="nodeLevel"/>
        <html:text property="nodeLevel" styleId="nodeLevel" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentCatalogForm.parentId"/>
        <html:errors property="parentId"/>
        <html:text property="parentId" styleId="parentId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentCatalogForm.permitTypeId"/>
        <html:errors property="permitTypeId"/>
        <html:text property="permitTypeId" styleId="permitTypeId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentCatalogForm.permitUsers"/>
        <html:errors property="permitUsers"/>
        <html:text property="permitUsers" styleId="permitUsers" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentCatalogForm.permitBranchs"/>
        <html:errors property="permitBranchs"/>
        <html:text property="permitBranchs" styleId="permitBranchs" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentCatalogForm.permitRoles"/>
        <html:errors property="permitRoles"/>
        <html:text property="permitRoles" styleId="permitRoles" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('OaDocumentCatalog')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("oaDocumentCatalogForm"));
</script>

<html:javascript formName="oaDocumentCatalogForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
