<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaDocumentFileDetail.title"/></title>
<content tag="heading"><fmt:message key="oaDocumentFileDetail.heading"/></content>

<html:form action="saveOaDocumentFile" method="post" styleId="oaDocumentFileForm" onsubmit="return validateOaDocumentFileForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentFileForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentFileForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentFileForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentFileForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentFileForm.documentCatalogId"/>
        <html:errors property="documentCatalogId"/>
        <html:text property="documentCatalogId" styleId="documentCatalogId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentFileForm.fileName"/>
        <html:errors property="fileName"/>
        <html:text property="fileName" styleId="fileName" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentFileForm.picName"/>
        <html:errors property="picName"/>
        <html:text property="picName" styleId="picName" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentFileForm.oaDocumentCatalog"/>
        <html:errors property="oaDocumentCatalog"/>
        <html:text property="oaDocumentCatalog" styleId="oaDocumentCatalog" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('OaDocumentFile')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("oaDocumentFileForm"));
</script>

<html:javascript formName="oaDocumentFileForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
