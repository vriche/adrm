<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="sysPromptModeList.title"/></title>
<content tag="heading"><fmt:message key="sysPromptModeList.heading"/></content>
<meta name="menu" content="SysPromptModeMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editSysPromptMode.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="sysPromptModeList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="sysPromptModeList" pagesize="25" class="tableDisplay sysPromptModeList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editSysPromptMode.html" paramId="id" paramProperty="id"
        titleKey="sysPromptModeForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="sysPromptModeForm.name"/>		<!--name--> 
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="sysPromptModeForm.value"/>		<!--value--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="sysPromptModeForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="sysPromptModeForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="sysPromptModeForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="sysPromptModeForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="sysPromptMode"/>
    <display:setProperty name="paging.banner.items_name" value="sysPromptModes"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("sysPromptModeList");
</script>
