<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="contractPaymentList.title"/></title>
<content tag="heading"><fmt:message key="contractPaymentList.heading"/></content>
<meta name="menu" content="ContractPaymentMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editContractPayment.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="contractPaymentList" cellspacing="0" cellpadding="0"
    id="contractPaymentList" pagesize="25" class="table contractPaymentList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editContractPayment.html" paramId="id" paramProperty="id"
        titleKey="contractPaymentForm.id"/>
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="contractPaymentForm.createBy"/>
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="contractPaymentForm.createDate"/>
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="contractPaymentForm.modifyBy"/>
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="contractPaymentForm.modifyDate"/>
    <display:column property="incomeModeId" sortable="true" headerClass="sortable"
         titleKey="contractPaymentForm.incomeModeId"/>
    <display:column property="payNumber" sortable="true" headerClass="sortable"
         titleKey="contractPaymentForm.payNumber"/>
    <display:column property="payDate" sortable="true" headerClass="sortable"
         titleKey="contractPaymentForm.payDate"/>
    <display:column property="contractId" sortable="true" headerClass="sortable"
         titleKey="contractPaymentForm.contractId"/>
    <display:column property="orderId" sortable="true" headerClass="sortable"
         titleKey="contractPaymentForm.orderId"/>
    <display:column property="moneyPay" sortable="true" headerClass="sortable"
         titleKey="contractPaymentForm.moneyPay"/>
    <display:column property="moneyIn" sortable="true" headerClass="sortable"
         titleKey="contractPaymentForm.moneyIn"/>
    <display:column property="urgencyAlert" sortable="true" headerClass="sortable"
         titleKey="contractPaymentForm.urgencyAlert"/>
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="contractPaymentForm.memo"/>
    <display:setProperty name="paging.banner.item_name" value="contractPayment"/>
    <display:setProperty name="paging.banner.items_name" value="contractPayments"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("contractPaymentList");
</script>
