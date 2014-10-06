<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaDocumentCatalogList.title"/></title>
<content tag="heading"><fmt:message key="oaDocumentCatalogList.heading"/></content>
<meta name="menu" content="OaDocumentCatalogMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaDocumentCatalog.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaDocumentCatalogList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaDocumentCatalogList" pagesize="25" class="tableDisplay oaDocumentCatalogList"
    export="true" requestURI="">


    <display:column property="name" sortable="true" headerClass="sortable"
    	 url="/editOaDocumentCatalog.html" paramId="id" paramProperty="id"
         titleKey="oaDocumentCatalogForm.name"/>				<!--name--> 
    <display:column property="permitTypeId" sortable="true" headerClass="sortable"
         titleKey="oaDocumentCatalogForm.permitTypeId"/>		<!--permitTypeId--> 
    <display:column property="displayNo" sortable="true" headerClass="sortable"
         titleKey="oaDocumentCatalogForm.displayNo"/>		<!--displayNo--> 
    <display:column property="nodeLevel" sortable="true" headerClass="sortable"
         titleKey="oaDocumentCatalogForm.nodeLevel"/>		<!--nodeLevel--> 
    <display:column property="parentId" sortable="true" headerClass="sortable"
         titleKey="oaDocumentCatalogForm.parentId"/>		<!--parentId--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaDocumentCatalogForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaDocumentCatalogForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaDocumentCatalogForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaDocumentCatalogForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaDocumentCatalog"/>
    <display:setProperty name="paging.banner.items_name" value="oaDocumentCatalogs"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaDocumentCatalogList");
</script>
