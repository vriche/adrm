<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="dayInfoList.title"/></title>
<content tag="heading"><fmt:message key="dayInfoList.heading"/></content>
<meta name="menu" content="DayInfoMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editDayInfo.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="dayInfoList" cellspacing="0" cellpadding="0"
    id="dayInfoList" pagesize="25" class="tableDisplay dayInfoList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editDayInfo.html" paramId="id" paramProperty="id"
        titleKey="dayInfoForm.id"/>
    <display:column property="carrierId" sortable="true" headerClass="sortable"
         titleKey="dayInfoForm.carrierId"/>
    <display:column property="resourceId" sortable="true" headerClass="sortable"
         titleKey="dayInfoForm.resourceId"/>
    <display:column property="resourceType" sortable="true" headerClass="sortable"
         titleKey="dayInfoForm.resourceType"/>
    <display:column property="propertiyTime" sortable="true" headerClass="sortable"
         titleKey="dayInfoForm.propertiyTime"/>
    <display:column property="workspanId" sortable="true" headerClass="sortable"
         titleKey="dayInfoForm.workspanId"/>
    <display:column property="publishDate" sortable="true" headerClass="sortable"
         titleKey="dayInfoForm.publishDate"/>
    <display:column property="specific" sortable="true" headerClass="sortable"
         titleKey="dayInfoForm.specific"/>
    <display:column property="total" sortable="true" headerClass="sortable"
         titleKey="dayInfoForm.total"/>
    <display:column property="used" sortable="true" headerClass="sortable"
         titleKey="dayInfoForm.used"/>
    <display:setProperty name="paging.banner.item_name" value="dayInfo"/>
    <display:setProperty name="paging.banner.items_name" value="dayInfos"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("dayInfoList");
</script>
