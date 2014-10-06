<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="resourceTypeList.title"/></title>
<content tag="heading"><fmt:message key="resourceTypeList.heading"/></content>
<meta name="menu" content="ResourceTypeMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editResourceType.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="resourceTypeList" cellspacing="0" cellpadding="0"
    id="resourceTypeList" pagesize="25" class="tableDisplay resourceTypeList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editResourceType.html" paramId="id" paramProperty="id"
        titleKey="resourceTypeForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="resourceTypeForm.name"/>
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="resourceTypeForm.value"/>
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="resourceTypeForm.createBy"/>
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="resourceTypeForm.createDate"/>
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="resourceTypeForm.modifyBy"/>
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="resourceTypeForm.modifyDate"/>
    <display:column property="enable" sortable="true" headerClass="sortable"
         titleKey="resourceTypeForm.enable"/>
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="resourceTypeForm.memo"/>
    <display:setProperty name="paging.banner.item_name" value="resourceType"/>
    <display:setProperty name="paging.banner.items_name" value="resourceTypes"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("resourceTypeList");
</script>
