<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="sysEventTypeList.title"/></title>
<content tag="heading"><fmt:message key="sysEventTypeList.heading"/></content>
<meta name="menu" content="SysEventTypeMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editSysEventType.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="sysEventTypeList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="sysEventTypeList" pagesize="25" class="tableDisplay sysEventTypeList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editSysEventType.html" paramId="id" paramProperty="id"
        titleKey="sysEventTypeForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="sysEventTypeForm.name"/>		<!--name--> 
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="sysEventTypeForm.value"/>		<!--value--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="sysEventTypeForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="sysEventTypeForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="sysEventTypeForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="sysEventTypeForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="sysEventType"/>
    <display:setProperty name="paging.banner.items_name" value="sysEventTypes"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("sysEventTypeList");
</script>
