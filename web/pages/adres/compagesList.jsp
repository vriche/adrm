<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="compagesList.title"/></title>
<content tag="heading"><fmt:message key="compagesList.heading"/></content>
<meta name="menu" content="CompagesMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editCompages.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="compagesList" cellspacing="2" cellpadding="2"
    id="compagesList" pagesize="25" class="tableDisplay compagesList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editCompages.html" paramId="id" paramProperty="id"
        titleKey="compagesForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="compagesForm.name"/>
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="compagesForm.createBy"/>
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="compagesForm.createDate"/>
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="compagesForm.modifyBy"/>
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="compagesForm.modifyDate"/>
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="compagesForm.memo"/>
    <display:column property="enable" sortable="true" headerClass="sortable"
         titleKey="compagesForm.enable"/>
    <display:setProperty name="paging.banner.item_name" value="compages"/>
    <display:setProperty name="paging.banner.items_name" value="compagess"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("compagesList");
</script>
