<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="publishMemoList.title"/></title>
<content tag="heading"><fmt:message key="publishMemoList.heading"/></content>
<meta name="menu" content="PublishMemoMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editPublishMemo.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="publishMemoList" cellspacing="1" cellpadding="0"
    id="publishMemoList" pagesize="9" class="tableDisplay publishMemoList"
    export="false" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editPublishMemo.html" paramId="id" paramProperty="id"
        titleKey="publishMemoForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="publishMemoForm.name"/>
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="publishMemoForm.modifyDate"/>
    <display:setProperty name="paging.banner.item_name" value="publishMemo"/>
    <display:setProperty name="paging.banner.items_name" value="publishMemos"/>
</display:table>



<script type="text/javascript">
    highlightTableRows("publishMemoList");
</script>
