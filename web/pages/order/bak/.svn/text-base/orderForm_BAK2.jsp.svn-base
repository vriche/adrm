<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="orderDetail.title"/></title>
<content tag="heading"><fmt:message key="orderDetail.heading"/></content>

<html:form action="saveOrder" method="post" styleId="orderForm" onsubmit="return validateOrderForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="orderForm.categoryId"/>
        <html:errors property="categoryId"/>
        <html:text property="categoryId" styleId="categoryId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderForm.contractId"/>
        <html:errors property="contractId"/>
        <html:text property="contractId" styleId="contractId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderForm.customerId"/>
        <html:errors property="customerId"/>
        <html:text property="customerId" styleId="customerId" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="orderForm.isCkecked"/>
        <html:errors property="isCkecked"/>
        <html:text property="isCkecked" styleId="isCkecked" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderForm.moneyIn"/>
        <html:errors property="moneyIn"/>
        <html:text property="moneyIn" styleId="moneyIn" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderForm.moneySum"/>
        <html:errors property="moneySum"/>
        <html:text property="moneySum" styleId="moneySum" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderForm.orderCode"/>
        <html:errors property="orderCode"/>
        <html:text property="orderCode" styleId="orderCode" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderForm.orderMeno"/>
        <html:errors property="orderMeno"/>
        <html:text property="orderMeno" styleId="orderMeno" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderForm.publishMemo"/>
        <html:errors property="publishMemo"/>
        <html:text property="publishMemo" styleId="publishMemo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderForm.relationCode"/>
        <html:errors property="relationCode"/>
        <html:text property="relationCode" styleId="relationCode" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderForm.userId"/>
        <html:errors property="userId"/>
        <html:text property="userId" styleId="userId" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="orderForm.contractPayments"/>
        <html:errors property="contractPayments"/>
        <html:text property="contractPayments" styleId="contractPayments" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderForm.orderDetails"/>
        <html:errors property="orderDetails"/>
        <html:text property="orderDetails" styleId="orderDetails" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderForm.publishEndDate"/>
        <html:errors property="publishEndDate"/>
        <html:text property="publishEndDate" styleId="publishEndDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderForm.publishStartDate"/>
        <html:errors property="publishStartDate"/>
        <html:text property="publishStartDate" styleId="publishStartDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderForm.sumTimes"/>
        <html:errors property="sumTimes"/>
        <html:text property="sumTimes" styleId="sumTimes" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('Order')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("orderForm"));
</script>

<html:javascript formName="orderForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
