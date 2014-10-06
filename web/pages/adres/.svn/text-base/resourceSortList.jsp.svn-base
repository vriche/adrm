<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="resourceSortList.title"/></title>
<content tag="heading"><fmt:message key="resourceSortList.heading"/></content>
<meta name="menu" content="ResourceSortMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editResourceSort.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="resourceSortList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="resourceSortList" pagesize="25" class="tableDisplay resourceSortList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editResourceSort.html" paramId="id" paramProperty="id"
        titleKey="resourceSortForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="resourceSortForm.name"/>		<!--name--> 
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="resourceSortForm.value"/>		<!--value--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="resourceSortForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="resourceSortForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="resourceSortForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="resourceSortForm.modifyDate"/>		<!--modifyDate--> 
    <display:column property="enable" sortable="true" headerClass="sortable"
         titleKey="resourceSortForm.enable"/>		<!--enable--> 
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="resourceSortForm.memo"/>		<!--memo--> 
    <display:setProperty name="paging.banner.item_name" value="resourceSort"/>
    <display:setProperty name="paging.banner.items_name" value="resourceSorts"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("resourceSortList");
</script>
