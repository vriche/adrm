<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="mediaOrgList.title"/></title>
<content tag="heading"><fmt:message key="mediaOrgList.heading"/></content>
<meta name="menu" content="MediaOrgMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editMediaOrg.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="mediaOrgList" cellspacing="0" cellpadding="0"
    id="mediaOrgList" pagesize="25" class="table mediaOrgList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editMediaOrg.html" paramId="id" paramProperty="id"
        titleKey="mediaOrgForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="mediaOrgForm.name"/>
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="mediaOrgForm.value"/>
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="mediaOrgForm.createBy"/>
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="mediaOrgForm.createDate"/>
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="mediaOrgForm.modifyBy"/>
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="mediaOrgForm.modifyDate"/>
    <display:column property="enable" sortable="true" headerClass="sortable"
         titleKey="mediaOrgForm.enable"/>
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="mediaOrgForm.memo"/>
    <display:setProperty name="paging.banner.item_name" value="mediaOrg"/>
    <display:setProperty name="paging.banner.items_name" value="mediaOrgs"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("mediaOrgList");
</script>
