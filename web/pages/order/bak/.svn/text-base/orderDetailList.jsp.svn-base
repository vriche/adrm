<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="orderDetailList.title"/></title>
<content tag="heading"><fmt:message key="orderDetailList.heading"/></content>
<meta name="menu" content="OrderDetailMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOrderDetail.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>
<display:table name="orderDetailList" cellspacing="0" cellpadding="0"
    id="orderDetailList" pagesize="25" class="table orderDetailList"
    export="true" requestURI="">
<!--url="/editOrderDetail.html"-->
    <display:column property="id" sortable="true" headerClass="sortable"
         href="javascript:refreshCat('http://localhost:8080/adrm_order/editOrderDetail.html?id=1');"  paramProperty="id" 
        titleKey="orderDetailForm.id"/>
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.createBy"/>
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.createDate"/>
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.modifyBy"/>
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.modifyDate"/>
    <display:column property="orderId" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.orderId"/>
    <display:column property="orderCategoryId" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.orderCategoryId"/>
    <display:column property="carrierId" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.carrierId"/>
    <display:column property="resourceType" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.resourceType"/>
    <display:column property="resourceInfoId" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.resourceInfoId"/>
    <display:column property="resourceWorkspanId" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.resourceWorkspanId"/>
    <display:column property="resourceSpecificId" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.resourceSpecificId"/>
    <display:column property="matteType" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.matteType"/>
    <display:column property="matterId" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.matterId"/>
    <display:column property="matterLength" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.matterLength"/>
    <display:column property="industryTypeId" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.industryTypeId"/>
    <display:column property="publishMemo" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.publishMemo"/>
    <display:column property="resourcePriceType" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.resourcePriceType"/>
    <display:column property="sysPrice" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.sysPrice"/>
    <display:column property="execPrice" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.execPrice"/>
    <display:column property="sumTimes" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.sumTimes"/>
    <display:column property="moneyBase" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.moneyBase"/>
    <display:column property="appRate" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.appRate"/>
    <display:column property="favourRate" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.favourRate"/>
    <display:column property="moneyBalance" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.moneyBalance"/>
    <display:column property="moneyRealpay" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.moneyRealpay"/>
    <display:column property="moneyIn" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.moneyIn"/>
    <display:column property="isCkecked" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.isCkecked"/>
    <display:column property="publishStartDate" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.publishStartDate"/>
    <display:column property="publishEndDate" sortable="true" headerClass="sortable"
         titleKey="orderDetailForm.publishEndDate"/>
    <display:setProperty name="paging.banner.item_name" value="orderDetail"/>
    <display:setProperty name="paging.banner.items_name" value="orderDetails"/>
</display:table>

  
<input type="text"  style="width:50px" name="aaaaaaaaaaaaaaaaa" value="s" >

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("orderDetailList");
</script>
