<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="sysUserTypeList.title"/></title>
<content tag="heading"><fmt:message key="sysUserTypeList.heading"/></content>
<meta name="menu" content="SysUserTypeMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editSysUserType.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="sysUserTypeList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="sysUserTypeList" pagesize="25" class="tableDisplay sysUserTypeList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editSysUserType.html" paramId="id" paramProperty="id"
        titleKey="sysUserTypeForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="sysUserTypeForm.name"/>		<!--name--> 
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="sysUserTypeForm.value"/>		<!--value--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="sysUserTypeForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="sysUserTypeForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="sysUserTypeForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="sysUserTypeForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="sysUserType"/>
    <display:setProperty name="paging.banner.items_name" value="sysUserTypes"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("sysUserTypeList");
</script>
