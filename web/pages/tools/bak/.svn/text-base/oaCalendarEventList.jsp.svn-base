<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaCalendarEventList.title"/></title>
<content tag="heading"><fmt:message key="oaCalendarEventList.heading"/></content>
<meta name="menu" content="OaCalendarEventMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaCalendarEvent.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaCalendarEventList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaCalendarEventList" pagesize="25" class="tableDisplay oaCalendarEventList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaCalendarEvent.html" paramId="id" paramProperty="id"
        titleKey="oaCalendarEventForm.id"/>
    <display:column property="content" sortable="true" headerClass="sortable"
         titleKey="oaCalendarEventForm.content"/>		<!--content--> 
    <display:column property="eventStateId" sortable="true" headerClass="sortable"
         titleKey="oaCalendarEventForm.eventStateId"/>		<!--eventStateId--> 
    <display:column property="title" sortable="true" headerClass="sortable"
         titleKey="oaCalendarEventForm.title"/>		<!--title--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaCalendarEventForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaCalendarEventForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaCalendarEventForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaCalendarEventForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaCalendarEvent"/>
    <display:setProperty name="paging.banner.items_name" value="oaCalendarEvents"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaCalendarEventList");
</script>
