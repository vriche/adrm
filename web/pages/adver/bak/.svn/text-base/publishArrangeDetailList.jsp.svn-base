<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="publishArrangeDetailList.title"/></title>
<content tag="heading"><fmt:message key="publishArrangeDetailList.heading"/></content>
<meta name="menu" content="PublishArrangeDetailMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editPublishArrangeDetail.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="publishArrangeDetailList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="publishArrangeDetailList" pagesize="25" class="tableDisplay publishArrangeDetailList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editPublishArrangeDetail.html" paramId="id" paramProperty="id"
        titleKey="publishArrangeDetailForm.id"/>
    <display:column property="publishSort" sortable="true" headerClass="sortable"
         titleKey="publishArrangeDetailForm.publishSort"/>		<!--publishSort--> 
    <display:column property="specificValue" sortable="true" headerClass="sortable"
         titleKey="publishArrangeDetailForm.specificValue"/>		<!--specificValue--> 
    <display:column property="contractId" sortable="true" headerClass="sortable"
         titleKey="publishArrangeDetailForm.contractId"/>		<!--contractId--> 
    <display:column property="customerId" sortable="true" headerClass="sortable"
         titleKey="publishArrangeDetailForm.customerId"/>		<!--customerId--> 
    <display:column property="matterId" sortable="true" headerClass="sortable"
         titleKey="publishArrangeDetailForm.matterId"/>		<!--matterId--> 
    <display:column property="orderDayId" sortable="true" headerClass="sortable"
         titleKey="publishArrangeDetailForm.orderDayId"/>		<!--orderDayId--> 
    <display:column property="orderDetailId" sortable="true" headerClass="sortable"
         titleKey="publishArrangeDetailForm.orderDetailId"/>		<!--orderDetailId--> 
    <display:column property="orderId" sortable="true" headerClass="sortable"
         titleKey="publishArrangeDetailForm.orderId"/>		<!--orderId--> 
    <display:column property="ownerUserId" sortable="true" headerClass="sortable"
         titleKey="publishArrangeDetailForm.ownerUserId"/>		<!--ownerUserId--> 
    <display:column property="customerName" sortable="true" headerClass="sortable"
         titleKey="publishArrangeDetailForm.customerName"/>		<!--customerName--> 
    <display:column property="tapeCode" sortable="true" headerClass="sortable"
         titleKey="publishArrangeDetailForm.tapeCode"/>		<!--tapeCode--> 
    <display:column property="matterEdit" sortable="true" headerClass="sortable"
         titleKey="publishArrangeDetailForm.matterEdit"/>		<!--matterEdit--> 
    <display:column property="matterLength" sortable="true" headerClass="sortable"
         titleKey="publishArrangeDetailForm.matterLength"/>		<!--matterLength--> 
    <display:column property="matterName" sortable="true" headerClass="sortable"
         titleKey="publishArrangeDetailForm.matterName"/>		<!--matterName--> 
    <display:column property="specificName" sortable="true" headerClass="sortable"
         titleKey="publishArrangeDetailForm.specificName"/>		<!--specificName--> 
    <display:column property="adverTimes" sortable="true" headerClass="sortable"
         titleKey="publishArrangeDetailForm.adverTimes"/>		<!--adverTimes--> 
    <display:column property="ownerUserName" sortable="true" headerClass="sortable"
         titleKey="publishArrangeDetailForm.ownerUserName"/>		<!--ownerUserName--> 
    <display:column property="publishMemo" sortable="true" headerClass="sortable"
         titleKey="publishArrangeDetailForm.publishMemo"/>		<!--publishMemo--> 
    <display:setProperty name="paging.banner.item_name" value="publishArrangeDetail"/>
    <display:setProperty name="paging.banner.items_name" value="publishArrangeDetails"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("publishArrangeDetailList");
</script>
