<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaDocumentFileList.title"/></title>
<content tag="heading"><fmt:message key="oaDocumentFileList.heading"/></content>
<meta name="menu" content="OaDocumentFileMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaDocumentFile.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaDocumentFileList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaDocumentFileList" pagesize="25" class="tableDisplay oaDocumentFileList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaDocumentFile.html" paramId="id" paramProperty="id"
        titleKey="oaDocumentFileForm.id"/>
    <display:column property="documentCatalogId" sortable="true" headerClass="sortable"
         titleKey="oaDocumentFileForm.documentCatalogId"/>		<!--documentCatalogId--> 
    <display:column property="fileName" sortable="true" headerClass="sortable"
         titleKey="oaDocumentFileForm.fileName"/>		<!--fileName--> 
    <display:column property="picName" sortable="true" headerClass="sortable"
         titleKey="oaDocumentFileForm.picName"/>		<!--picName--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaDocumentFileForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaDocumentFileForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaDocumentFileForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaDocumentFileForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaDocumentFile"/>
    <display:setProperty name="paging.banner.items_name" value="oaDocumentFiles"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaDocumentFileList");
</script>
