<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaAssetsStateList.title"/></title>
<content tag="heading"><fmt:message key="oaAssetsStateList.heading"/></content>
<meta name="menu" content="OaAssetsStateMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaAssetsState.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaAssetsStateList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaAssetsStateList" pagesize="25" class="tableDisplay oaAssetsStateList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaAssetsState.html" paramId="id" paramProperty="id"
        titleKey="oaAssetsStateForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="oaAssetsStateForm.name"/>		<!--name--> 
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="oaAssetsStateForm.value"/>		<!--value--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaAssetsStateForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaAssetsStateForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaAssetsStateForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaAssetsStateForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaAssetsState"/>
    <display:setProperty name="paging.banner.items_name" value="oaAssetsStates"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaAssetsStateList");
</script>
