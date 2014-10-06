<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaProductInfoDetail.title"/></title>
<content tag="heading"><fmt:message key="oaProductInfoDetail.heading"/></content>

<html:form action="saveOaProductInfo" method="post" styleId="oaProductInfoForm" onsubmit="return validateOaProductInfoForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductInfoForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductInfoForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductInfoForm.fittings"/>
        <html:errors property="fittings"/>
        <html:text property="fittings" styleId="fittings" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductInfoForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductInfoForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductInfoForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductInfoForm.picture"/>
        <html:errors property="picture"/>
        <html:text property="picture" styleId="picture" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductInfoForm.price"/>
        <html:errors property="price"/>
        <html:text property="price" styleId="price" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductInfoForm.productType"/>
        <html:errors property="productType"/>
        <html:text property="productType" styleId="productType" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductInfoForm.productTypeId"/>
        <html:errors property="productTypeId"/>
        <html:text property="productTypeId" styleId="productTypeId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductInfoForm.provider"/>
        <html:errors property="provider"/>
        <html:text property="provider" styleId="provider" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductInfoForm.quantity"/>
        <html:errors property="quantity"/>
        <html:text property="quantity" styleId="quantity" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductInfoForm.stockDate"/>
        <html:errors property="stockDate"/>
        <html:text property="stockDate" styleId="stockDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductInfoForm.stockUser"/>
        <html:errors property="stockUser"/>
        <html:text property="stockUser" styleId="stockUser" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductInfoForm.storageDate"/>
        <html:errors property="storageDate"/>
        <html:text property="storageDate" styleId="storageDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaProductInfoForm.unit"/>
        <html:errors property="unit"/>
        <html:text property="unit" styleId="unit" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('OaProductInfo')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("oaProductInfoForm"));
</script>

<html:javascript formName="oaProductInfoForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
