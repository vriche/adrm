<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="workspanList.title"/></title>
<content tag="heading"><fmt:message key="workspanList.heading"/></content>
<meta name="menu" content="WorkspanMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editWorkspan.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="workspanList" cellspacing="0" cellpadding="0"
    id="workspanList" pagesize="25" class="table workspanList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editWorkspan.html" paramId="id" paramProperty="id"
        titleKey="workspanForm.id"/>
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="workspanForm.createBy"/>
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="workspanForm.createDate"/>
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="workspanForm.modifyBy"/>
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="workspanForm.modifyDate"/>
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="workspanForm.memo"/>
    <display:column property="carrierId" sortable="true" headerClass="sortable"
         titleKey="workspanForm.carrierId"/>
    <display:column property="resourceId" sortable="true" headerClass="sortable"
         titleKey="workspanForm.resourceId"/>
    <display:column property="resourceType" sortable="true" headerClass="sortable"
         titleKey="workspanForm.resourceType"/>
    <display:column property="propertiyTime" sortable="true" headerClass="sortable"
         titleKey="workspanForm.propertiyTime"/>
    <display:column property="broadcastStartTime" sortable="true" headerClass="sortable"
         titleKey="workspanForm.broadcastStartTime"/>
    <display:column property="beginDate" sortable="true" headerClass="sortable"
         titleKey="workspanForm.beginDate"/>
    <display:column property="endDate" sortable="true" headerClass="sortable"
         titleKey="workspanForm.endDate"/>
    <display:column property="broadcastEndTime" sortable="true" headerClass="sortable"
         titleKey="workspanForm.broadcastEndTime"/>
    <display:column property="sunLength" sortable="true" headerClass="sortable"
         titleKey="workspanForm.sunLength"/>
    <display:column property="monLength" sortable="true" headerClass="sortable"
         titleKey="workspanForm.monLength"/>
    <display:column property="tueLength" sortable="true" headerClass="sortable"
         titleKey="workspanForm.tueLength"/>
    <display:column property="thiLength" sortable="true" headerClass="sortable"
         titleKey="workspanForm.thiLength"/>
    <display:column property="wenLength" sortable="true" headerClass="sortable"
         titleKey="workspanForm.wenLength"/>
    <display:column property="friLength" sortable="true" headerClass="sortable"
         titleKey="workspanForm.friLength"/>
    <display:column property="satLength" sortable="true" headerClass="sortable"
         titleKey="workspanForm.satLength"/>
    <display:setProperty name="paging.banner.item_name" value="workspan"/>
    <display:setProperty name="paging.banner.items_name" value="workspans"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("workspanList");
</script>
