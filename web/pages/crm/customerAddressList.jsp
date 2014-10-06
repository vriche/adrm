<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="customerAddressList.title"/></title>
<content tag="heading"><fmt:message key="customerAddressList.heading"/></content>
<meta name="menu" content="CustomerAddressMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editCustomerAddress.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="customerAddressList" cellspacing="0" cellpadding="0"
    id="customerAddressList" pagesize="25" class="tableDisplay customerAddressList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editCustomerAddress.html" paramId="id" paramProperty="id"
        titleKey="customerAddressForm.id"/>
    <display:column property="customerId" sortable="true" headerClass="sortable"
         titleKey="customerAddressForm.customerId"/>
    <display:column property="addressType" sortable="true" headerClass="sortable"
         titleKey="customerAddressForm.addresType"/>
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="customerAddressForm.createBy"/>
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="customerAddressForm.createDate"/>
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="customerAddressForm.modifyBy"/>
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="customerAddressForm.modifyDate"/>
    <display:setProperty name="paging.banner.item_name" value="customerAddress"/>
    <display:setProperty name="paging.banner.items_name" value="customerAddresss"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("customerAddressList");
</script>
