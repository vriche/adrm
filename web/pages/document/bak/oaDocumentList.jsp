<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaDocumentList.title"/></title>
<content tag="heading"><fmt:message key="oaDocumentList.heading"/></content>
<meta name="menu" content="OaDocumentMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaDocument.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaDocumentList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaDocumentList" pagesize="25" class="tableDisplay oaDocumentList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaDocument.html" paramId="id" paramProperty="id"
        titleKey="oaDocumentForm.id"/>
    <display:column property="documentCode" sortable="true" headerClass="sortable"
         titleKey="oaDocumentForm.documentCode"/>		<!--documentCode--> 
    <display:column property="documentFileId" sortable="true" headerClass="sortable"
         titleKey="oaDocumentForm.documentFileId"/>		<!--documentFileId--> 
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="oaDocumentForm.memo"/>		<!--memo--> 
    <display:column property="title" sortable="true" headerClass="sortable"
         titleKey="oaDocumentForm.title"/>		<!--title--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaDocumentForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaDocumentForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaDocumentForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaDocumentForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaDocument"/>
    <display:setProperty name="paging.banner.items_name" value="oaDocuments"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaDocumentList");
</script>
