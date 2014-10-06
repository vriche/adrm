<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="customerTypeList.title"/></title>
<content tag="heading"><fmt:message key="customerTypeList.heading"/></content>
<meta name="menu" content="CustomerTypeMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editCustomerType.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="customerTypeList" cellspacing="1" cellpadding="0"
    id="customerTypeList" pagesize="9" class="tableDisplay customerTypeList"
    export="false" requestURI="">

    <display:column property="name" sortable="true" headerClass="sortable"
        url="/editCustomerType.html" paramId="id" paramProperty="id"
        titleKey="customerTypeForm.name"/>
    <display:column property="code" sortable="true" headerClass="sortable"
         titleKey="customerTypeForm.code"/>

    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="customerTypeForm.memo"/>
    <display:setProperty name="paging.banner.item_name" value="customerType"/>
    <display:setProperty name="paging.banner.items_name" value="customerTypes"/>
</display:table>



<script type="text/javascript">
    highlightTableRows("customerTypeList");
</script>
