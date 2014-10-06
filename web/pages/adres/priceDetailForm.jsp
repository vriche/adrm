<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="priceDetailDetail.title"/></title>
<content tag="heading"><fmt:message key="priceDetailDetail.heading"/></content>

<html:form action="savePriceDetail" method="post" styleId="priceDetailForm" onsubmit="return validatePriceDetailForm(this)">
<ul>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="priceDetailForm.length"/>
        <html:errors property="length"/>
        <html:text property="length" styleId="length" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceDetailForm.price"/>
        <html:errors property="price"/>
        <html:text property="price" styleId="price" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('PriceDetail')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("priceDetailForm"));
</script>

<html:javascript formName="priceDetailForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
