<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaInfoTypeList.title"/></title>
<content tag="heading"><fmt:message key="oaInfoTypeList.heading"/></content>
<meta name="menu" content="OaInfoTypeMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaInfoType.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaInfoTypeList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaInfoTypeList" pagesize="25" class="tableDisplay oaInfoTypeList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaInfoType.html" paramId="id" paramProperty="id"
        titleKey="oaInfoTypeForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="oaInfoTypeForm.name"/>		<!--name--> 
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="oaInfoTypeForm.value"/>		<!--value--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaInfoTypeForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaInfoTypeForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaInfoTypeForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaInfoTypeForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaInfoType"/>
    <display:setProperty name="paging.banner.items_name" value="oaInfoTypes"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaInfoTypeList");
</script>
