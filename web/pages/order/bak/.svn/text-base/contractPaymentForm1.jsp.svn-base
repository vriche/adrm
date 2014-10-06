<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="contractPaymentDetail.title"/></title>
<content tag="heading"><fmt:message key="contractPaymentDetail.heading"/></content>

<html:form action="saveContractPayment" method="post" styleId="contractPaymentForm" onsubmit="return validateContractPaymentForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="contractPaymentForm.contractId"/>
        <html:errors property="contractId"/>
        <html:text property="contractId" styleId="contractId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractPaymentForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractPaymentForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="contractPaymentForm.incomeModeId"/>
        <html:errors property="incomeModeId"/>
        <html:text property="incomeModeId" styleId="incomeModeId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractPaymentForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractPaymentForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractPaymentForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractPaymentForm.moneyIn"/>
        <html:errors property="moneyIn"/>
        <html:text property="moneyIn" styleId="moneyIn" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractPaymentForm.moneyPay"/>
        <html:errors property="moneyPay"/>
        <html:text property="moneyPay" styleId="moneyPay" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractPaymentForm.orderId"/>
        <html:errors property="orderId"/>
        <html:text property="orderId" styleId="orderId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractPaymentForm.payDate"/>
        <html:errors property="payDate"/>
        <html:text property="payDate" styleId="payDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractPaymentForm.payNumber"/>
        <html:errors property="payNumber"/>
        <html:text property="payNumber" styleId="payNumber" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractPaymentForm.urgencyAlert"/>
        <html:errors property="urgencyAlert"/>
        <html:text property="urgencyAlert" styleId="urgencyAlert" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('ContractPayment')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("contractPaymentForm"));
</script>

<html:javascript formName="contractPaymentForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
