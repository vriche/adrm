<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="matterTypeList.title"/></title>
<content tag="heading"><fmt:message key="matterTypeList.heading"/></content>
<meta name="menu" content="MatterTypeMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editMatterType.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="matterTypeList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="matterTypeList" pagesize="25" class="tableDisplay matterTypeList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editMatterType.html" paramId="id" paramProperty="id"
        titleKey="matterTypeForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="matterTypeForm.name"/>		<!--name--> 
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="matterTypeForm.value"/>		<!--value--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="matterTypeForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="matterTypeForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="matterTypeForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="matterTypeForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="matterType"/>
    <display:setProperty name="paging.banner.items_name" value="matterTypes"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("matterTypeList");
</script>
