<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaDocumentDetail.title"/></title>
<content tag="heading"><fmt:message key="oaDocumentDetail.heading"/></content>

<html:form action="saveOaDocument" method="post" styleId="oaDocumentForm" onsubmit="return validateOaDocumentForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentForm.documentCode"/>
        <html:errors property="documentCode"/>
        <html:text property="documentCode" styleId="documentCode" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentForm.documentFileId"/>
        <html:errors property="documentFileId"/>
        <html:text property="documentFileId" styleId="documentFileId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentForm.title"/>
        <html:errors property="title"/>
        <html:text property="title" styleId="title" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaDocumentForm.oaDocumentFile"/>
        <html:errors property="oaDocumentFile"/>
        <html:text property="oaDocumentFile" styleId="oaDocumentFile" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('OaDocument')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("oaDocumentForm"));
</script>

<html:javascript formName="oaDocumentForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
