<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="proOrderDetail.title"/></title>
<content tag="heading"><fmt:message key="proOrderDetail.heading"/></content>

<html:form action="saveProOrder" method="post" styleId="proOrderForm" onsubmit="return validateProOrderForm(this)">
<ul>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="proOrderForm.programId"/>
        <html:errors property="programId"/>
        <html:text property="programId" styleId="programId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proOrderForm.orderCode"/>
        <html:errors property="orderCode"/>
        <html:text property="orderCode" styleId="orderCode" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proOrderForm.orderMeno"/>
        <html:errors property="orderMeno"/>
        <html:text property="orderMeno" styleId="orderMeno" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proOrderForm.payMoney"/>
        <html:errors property="payMoney"/>
        <html:text property="payMoney" styleId="payMoney" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proOrderForm.payDate"/>
        <html:errors property="payDate"/>
        <html:text property="payDate" styleId="payDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proOrderForm.paidMoney"/>
        <html:errors property="paidMoney"/>
        <html:text property="paidMoney" styleId="paidMoney" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proOrderForm.paidDate"/>
        <html:errors property="paidDate"/>
        <html:text property="paidDate" styleId="paidDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proOrderForm.lessMoney"/>
        <html:errors property="lessMoney"/>
        <html:text property="lessMoney" styleId="lessMoney" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proOrderForm.moreMoney"/>
        <html:errors property="moreMoney"/>
        <html:text property="moreMoney" styleId="moreMoney" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proOrderForm.orderTypeId"/>
        <html:errors property="orderTypeId"/>
        <html:text property="orderTypeId" styleId="orderTypeId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proOrderForm.relationCode"/>
        <html:errors property="relationCode"/>
        <html:text property="relationCode" styleId="relationCode" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proOrderForm.userId"/>
        <html:errors property="userId"/>
        <html:text property="userId" styleId="userId" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="proOrderForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proOrderForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proOrderForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proOrderForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('ProOrder')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("proOrderForm"));
</script>

<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
