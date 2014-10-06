<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaAssetsTypeList.title"/></title>
<content tag="heading"><fmt:message key="oaAssetsTypeList.heading"/></content>
<meta name="menu" content="OaAssetsTypeMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaAssetsType.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaAssetsTypeList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaAssetsTypeList" pagesize="25" class="tableDisplay oaAssetsTypeList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaAssetsType.html" paramId="id" paramProperty="id"
        titleKey="oaAssetsTypeForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="oaAssetsTypeForm.name"/>		<!--name--> 
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="oaAssetsTypeForm.value"/>		<!--value--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaAssetsTypeForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaAssetsTypeForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaAssetsTypeForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaAssetsTypeForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaAssetsType"/>
    <display:setProperty name="paging.banner.items_name" value="oaAssetsTypes"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaAssetsTypeList");
</script>
