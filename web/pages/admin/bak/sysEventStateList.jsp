<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="sysEventStateList.title"/></title>
<content tag="heading"><fmt:message key="sysEventStateList.heading"/></content>
<meta name="menu" content="SysEventStateMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editSysEventState.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="sysEventStateList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="sysEventStateList" pagesize="25" class="tableDisplay sysEventStateList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editSysEventState.html" paramId="id" paramProperty="id"
        titleKey="sysEventStateForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="sysEventStateForm.name"/>		<!--name--> 
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="sysEventStateForm.value"/>		<!--value--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="sysEventStateForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="sysEventStateForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="sysEventStateForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="sysEventStateForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="sysEventState"/>
    <display:setProperty name="paging.banner.items_name" value="sysEventStates"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("sysEventStateList");
</script>
