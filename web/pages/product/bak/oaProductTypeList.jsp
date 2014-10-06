<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaProductTypeList.title"/></title>
<content tag="heading"><fmt:message key="oaProductTypeList.heading"/></content>
<meta name="menu" content="OaProductTypeMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaProductType.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaProductTypeList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaProductTypeList" pagesize="25" class="tableDisplay oaProductTypeList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaProductType.html" paramId="id" paramProperty="id"
        titleKey="oaProductTypeForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="oaProductTypeForm.name"/>		<!--name--> 
    <display:column property="displayNo" sortable="true" headerClass="sortable"
         titleKey="oaProductTypeForm.displayNo"/>		<!--displayNo--> 
    <display:column property="nodeLevel" sortable="true" headerClass="sortable"
         titleKey="oaProductTypeForm.nodeLevel"/>		<!--nodeLevel--> 
    <display:column property="parentId" sortable="true" headerClass="sortable"
         titleKey="oaProductTypeForm.parentId"/>		<!--parentId--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaProductTypeForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaProductTypeForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaProductTypeForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaProductTypeForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaProductType"/>
    <display:setProperty name="paging.banner.items_name" value="oaProductTypes"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaProductTypeList");
</script>
