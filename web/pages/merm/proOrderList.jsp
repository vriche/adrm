<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="proOrderList.title"/></title>
<content tag="heading"><fmt:message key="proOrderList.heading"/></content>
<meta name="menu" content="ProOrderMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editProOrder.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="proOrderList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="proOrderList" pagesize="25" class="tableDisplay proOrderList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editProOrder.html" paramId="id" paramProperty="id"
        titleKey="proOrderForm.id"/>
    <display:column property="orderCode" sortable="true" headerClass="sortable"
         titleKey="proOrderForm.orderCode"/>		<!--orderCode--> 
    <display:column property="orderMeno" sortable="true" headerClass="sortable"
         titleKey="proOrderForm.orderMeno"/>		<!--orderMeno--> 
    <display:column property="payMoney" sortable="true" headerClass="sortable"
         titleKey="proOrderForm.payMoney"/>		<!--payMoney--> 
    <display:column property="payDate" sortable="true" headerClass="sortable"
         titleKey="proOrderForm.payDate"/>		<!--payDate--> 
    <display:column property="paidMoney" sortable="true" headerClass="sortable"
         titleKey="proOrderForm.paidMoney"/>		<!--paidMoney--> 
    <display:column property="paidDate" sortable="true" headerClass="sortable"
         titleKey="proOrderForm.paidDate"/>		<!--paidDate--> 
    <display:column property="lessMoney" sortable="true" headerClass="sortable"
         titleKey="proOrderForm.lessMoney"/>		<!--lessMoney--> 
    <display:column property="moreMoney" sortable="true" headerClass="sortable"
         titleKey="proOrderForm.moreMoney"/>		<!--moreMoney--> 
    <display:column property="relationCode" sortable="true" headerClass="sortable"
         titleKey="proOrderForm.relationCode"/>		<!--relationCode--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="proOrderForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="proOrderForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="proOrderForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="proOrderForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="proOrder"/>
    <display:setProperty name="paging.banner.items_name" value="proOrders"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("proOrderList");
</script>
