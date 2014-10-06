<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="incomeUsedDetail.title"/></title>
<content tag="heading"><fmt:message key="incomeUsedDetail.heading"/></content>

<html:form action="saveIncomeUsed" method="post" styleId="incomeUsedForm" onsubmit="return validateIncomeUsedForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="incomeUsedForm.contractId"/>
        <html:errors property="contractId"/>
        <html:text property="contractId" styleId="contractId" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="incomeUsedForm.incomeId"/>
        <html:errors property="incomeId"/>
        <html:text property="incomeId" styleId="incomeId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="incomeUsedForm.incomePullId"/>
        <html:errors property="incomePullId"/>
        <html:text property="incomePullId" styleId="incomePullId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="incomeUsedForm.moneyIn"/>
        <html:errors property="moneyIn"/>
        <html:text property="moneyIn" styleId="moneyIn" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="incomeUsedForm.orderDayInfoId"/>
        <html:errors property="orderDayInfoId"/>
        <html:text property="orderDayInfoId" styleId="orderDayInfoId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="incomeUsedForm.orderDetailId"/>
        <html:errors property="orderDetailId"/>
        <html:text property="orderDetailId" styleId="orderDetailId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="incomeUsedForm.orderId"/>
        <html:errors property="orderId"/>
        <html:text property="orderId" styleId="orderId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="incomeUsedForm.publishDate"/>
        <html:errors property="publishDate"/>
        <html:text property="publishDate" styleId="publishDate" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('IncomeUsed')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("incomeUsedForm"));
</script>

<html:javascript formName="incomeUsedForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
