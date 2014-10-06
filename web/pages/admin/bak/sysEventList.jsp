<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="sysEventList.title"/></title>
<content tag="heading"><fmt:message key="sysEventList.heading"/></content>
<meta name="menu" content="SysEventMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editSysEvent.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="sysEventList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="sysEventList" pagesize="25" class="tableDisplay sysEventList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editSysEvent.html" paramId="id" paramProperty="id"
        titleKey="sysEventForm.id"/>
    <display:column property="eventstateid" sortable="true" headerClass="sortable"
         titleKey="sysEventForm.eventstateid"/>		<!--eventstateid--> 
    <display:column property="eventTypeid" sortable="true" headerClass="sortable"
         titleKey="sysEventForm.eventTypeid"/>		<!--eventTypeid--> 
    <display:column property="infoId" sortable="true" headerClass="sortable"
         titleKey="sysEventForm.infoId"/>		<!--infoId--> 
    <display:column property="linkpath" sortable="true" headerClass="sortable"
         titleKey="sysEventForm.linkpath"/>		<!--linkpath--> 
    <display:column property="mesgmemo" sortable="true" headerClass="sortable"
         titleKey="sysEventForm.mesgmemo"/>		<!--mesgmemo--> 
    <display:column property="promptend" sortable="true" headerClass="sortable"
         titleKey="sysEventForm.promptend"/>		<!--promptend--> 
    <display:column property="promptmodeid" sortable="true" headerClass="sortable"
         titleKey="sysEventForm.promptmodeid"/>		<!--promptmodeid--> 
    <display:column property="promptstart" sortable="true" headerClass="sortable"
         titleKey="sysEventForm.promptstart"/>		<!--promptstart--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="sysEventForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="sysEventForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="sysEventForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="sysEventForm.modifyDate"/>		<!--modifyDate--> 
    <display:column property="eventStateId" sortable="true" headerClass="sortable"
         titleKey="sysEventForm.eventStateId"/>		<!--eventStateId--> 
    <display:column property="eventTypeId" sortable="true" headerClass="sortable"
         titleKey="sysEventForm.eventTypeId"/>		<!--eventTypeId--> 
    <display:column property="linkPath" sortable="true" headerClass="sortable"
         titleKey="sysEventForm.linkPath"/>		<!--linkPath--> 
    <display:column property="mesgMemo" sortable="true" headerClass="sortable"
         titleKey="sysEventForm.mesgMemo"/>		<!--mesgMemo--> 
    <display:column property="promptEnd" sortable="true" headerClass="sortable"
         titleKey="sysEventForm.promptEnd"/>		<!--promptEnd--> 
    <display:column property="promptModeId" sortable="true" headerClass="sortable"
         titleKey="sysEventForm.promptModeId"/>		<!--promptModeId--> 
    <display:column property="promptStart" sortable="true" headerClass="sortable"
         titleKey="sysEventForm.promptStart"/>		<!--promptStart--> 
    <display:setProperty name="paging.banner.item_name" value="sysEvent"/>
    <display:setProperty name="paging.banner.items_name" value="sysEvents"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("sysEventList");
</script>
