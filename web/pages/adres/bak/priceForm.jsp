<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="priceDetail.title"/></title>
<content tag="heading"><fmt:message key="priceDetail.heading"/></content>

<html:form action="savePrice" method="post" styleId="priceForm" onsubmit="return validatePriceForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="priceForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="priceForm.isDefault"/>
        <html:errors property="isDefault"/>
        <html:text property="isDefault" styleId="isDefault" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceForm.isUseRegular"/>
        <html:errors property="isUseRegular"/>
        <html:text property="isUseRegular" styleId="isUseRegular" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="meno" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceForm.moneyType"/>
        <html:errors property="moneyType"/>
        <html:text property="moneyType" styleId="moneyType" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>


    <li>
        <adrm_order:label styleClass="desc" key="priceForm.resourcePriceType"/>
        <html:errors property="resourcePriceType"/>
        <html:text property="resourcePriceType" styleId="resourcePriceType" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceForm.resourceType"/>
        <html:errors property="resourceType"/>
        <html:text property="resourceType" styleId="resourceType" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('Price')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("priceForm"));
</script>

<html:javascript formName="priceForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
