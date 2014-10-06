<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="proCustomerList.title"/></title>
<content tag="heading"><fmt:message key="proCustomerList.heading"/></content>
<meta name="menu" content="ProCustomerMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editProCustomer.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="proCustomerList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="proCustomerList" pagesize="25" class="tableDisplay proCustomerList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editProCustomer.html" paramId="id" paramProperty="id"
        titleKey="proCustomerForm.id"/>
    <display:column property="customerName" sortable="true" headerClass="sortable"
         titleKey="proCustomerForm.customerName"/>		<!--customerName--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="proCustomerForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="proCustomerForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="proCustomerForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="proCustomerForm.modifyDate"/>		<!--modifyDate--> 
    <display:column property="accountAddress" sortable="true" headerClass="sortable"
         titleKey="proCustomerForm.accountAddress"/>		<!--accountAddress--> 
    <display:column property="fax" sortable="true" headerClass="sortable"
         titleKey="proCustomerForm.fax"/>		<!--fax--> 
    <display:column property="helpCode" sortable="true" headerClass="sortable"
         titleKey="proCustomerForm.helpCode"/>		<!--helpCode--> 
    <display:column property="linkmanName" sortable="true" headerClass="sortable"
         titleKey="proCustomerForm.linkmanName"/>		<!--linkmanName--> 
    <display:column property="telephone" sortable="true" headerClass="sortable"
         titleKey="proCustomerForm.telephone"/>		<!--telephone--> 
    <display:setProperty name="paging.banner.item_name" value="proCustomer"/>
    <display:setProperty name="paging.banner.items_name" value="proCustomers"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("proCustomerList");
</script>
