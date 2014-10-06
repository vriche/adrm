<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaProductUsedDetail.title"/></title>
<content tag="heading"><fmt:message key="oaProductUsedDetail.heading"/></content>

<html:form action="saveOaProductUsed" method="post" styleId="oaProductUsedForm" onsubmit="return validateOaProductUsedForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductUsedForm.amends"/>
        <html:errors property="amends"/>
        <html:text property="amends" styleId="amends" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductUsedForm.attaint"/>
        <html:errors property="attaint"/>
        <html:text property="attaint" styleId="attaint" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductUsedForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductUsedForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductUsedForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductUsedForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductUsedForm.playReturnDate"/>
        <html:errors property="playReturnDate"/>
        <html:text property="playReturnDate" styleId="playReturnDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductUsedForm.productId"/>
        <html:errors property="productId"/>
        <html:text property="productId" styleId="productId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductUsedForm.relReturnDate"/>
        <html:errors property="relReturnDate"/>
        <html:text property="relReturnDate" styleId="relReturnDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductUsedForm.returnNum"/>
        <html:errors property="returnNum"/>
        <html:text property="returnNum" styleId="returnNum" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductUsedForm.useDate"/>
        <html:errors property="useDate"/>
        <html:text property="useDate" styleId="useDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductUsedForm.useMan"/>
        <html:errors property="useMan"/>
        <html:text property="useMan" styleId="useMan" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductUsedForm.useNum"/>
        <html:errors property="useNum"/>
        <html:text property="useNum" styleId="useNum" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductUsedForm.product"/>
        <html:errors property="product"/>
        <html:text property="product" styleId="product" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('OaProductUsed')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("oaProductUsedForm"));
</script>

<html:javascript formName="oaProductUsedForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
