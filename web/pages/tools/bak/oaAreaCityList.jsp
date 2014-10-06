<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaAreaCityList.title"/></title>
<content tag="heading"><fmt:message key="oaAreaCityList.heading"/></content>
<meta name="menu" content="OaAreaCityMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaAreaCity.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaAreaCityList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaAreaCityList" pagesize="25" class="tableDisplay oaAreaCityList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaAreaCity.html" paramId="id" paramProperty="id"
        titleKey="oaAreaCityForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="oaAreaCityForm.name"/>		<!--name--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaAreaCityForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaAreaCityForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaAreaCityForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaAreaCityForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaAreaCity"/>
    <display:setProperty name="paging.banner.items_name" value="oaAreaCitys"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaAreaCityList");
</script>
