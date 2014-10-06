<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="priceTypeDetail.title"/></title>
<content tag="heading"><fmt:message key="priceTypeDetail.heading"/></content>

<html:form action="savePriceType" method="post" styleId="priceTypeForm" onsubmit="return validatePriceTypeForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="priceTypeForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceTypeForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceTypeForm.enable"/>
        <html:errors property="enable"/>
        <html:text property="enable" styleId="enable" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="priceTypeForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceTypeForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceTypeForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceTypeForm.priceTypeName"/>
        <html:errors property="priceTypeName"/>
        <html:text property="priceTypeName" styleId="priceTypeName" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceTypeForm.value"/>
        <html:errors property="value"/>
        <html:text property="value" styleId="value" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('PriceType')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("priceTypeForm"));
</script>

<html:javascript formName="priceTypeForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
