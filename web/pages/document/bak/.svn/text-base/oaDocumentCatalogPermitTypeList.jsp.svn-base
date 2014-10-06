<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaDocumentCatalogPermitTypeList.title"/></title>
<content tag="heading"><fmt:message key="oaDocumentCatalogPermitTypeList.heading"/></content>
<meta name="menu" content="OaDocumentCatalogPermitTypeMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaDocumentCatalogPermitType.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaDocumentCatalogPermitTypeList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaDocumentCatalogPermitTypeList" pagesize="25" class="tableDisplay oaDocumentCatalogPermitTypeList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaDocumentCatalogPermitType.html" paramId="id" paramProperty="id"
        titleKey="oaDocumentCatalogPermitTypeForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="oaDocumentCatalogPermitTypeForm.name"/>		<!--name--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaDocumentCatalogPermitTypeForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaDocumentCatalogPermitTypeForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaDocumentCatalogPermitTypeForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaDocumentCatalogPermitTypeForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaDocumentCatalogPermitType"/>
    <display:setProperty name="paging.banner.items_name" value="oaDocumentCatalogPermitTypes"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaDocumentCatalogPermitTypeList");
</script>
