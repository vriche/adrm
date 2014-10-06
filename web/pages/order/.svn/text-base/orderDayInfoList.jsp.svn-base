<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="orderDayInfoList.title"/></title>
<content tag="heading"><fmt:message key="orderDayInfoList.heading"/></content>
<meta name="menu" content="OrderDayInfoMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOrderDayInfo.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="orderDayInfoList" cellspacing="0" cellpadding="0"
    id="orderDayInfoList" pagesize="25" class="table orderDayInfoList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOrderDayInfo.html" paramId="id" paramProperty="id"
        titleKey="orderDayInfoForm.id"/>
    <display:column property="orderId" sortable="true" headerClass="sortable"
         titleKey="orderDayInfoForm.orderId"/>
    <display:column property="orderDetailId" sortable="true" headerClass="sortable"
         titleKey="orderDayInfoForm.orderDetailId"/>
    <display:column property="publishDate" sortable="true" headerClass="sortable"
         titleKey="orderDayInfoForm.publishDate"/>
    <display:column property="adlength" sortable="true" headerClass="sortable"
         titleKey="orderDayInfoForm.adlength"/>
    <display:column property="dayStandardPrice" sortable="true" headerClass="sortable"
         titleKey="orderDayInfoForm.dayStandardPrice"/>
    <display:column property="dayRelIncome" sortable="true" headerClass="sortable"
         titleKey="orderDayInfoForm.dayRelIncome"/>
    <display:column property="adDayTimes" sortable="true" headerClass="sortable"
         titleKey="orderDayInfoForm.adDayTimes"/>
    <display:column property="resourceSpecific" sortable="true" headerClass="sortable"
         titleKey="orderDayInfoForm.resourceSpecific"/>
    <display:column property="isPublished" sortable="true" headerClass="sortable"
         titleKey="orderDayInfoForm.isPublished"/>
    <display:setProperty name="paging.banner.item_name" value="orderDayInfo"/>
    <display:setProperty name="paging.banner.items_name" value="orderDayInfos"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("orderDayInfoList");
</script>
