<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="proProgramList.title"/></title>
<content tag="heading"><fmt:message key="proProgramList.heading"/></content>
<meta name="menu" content="ProProgramMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editProProgram.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="proProgramList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="proProgramList" pagesize="25" class="tableDisplay proProgramList"
    export="true" requestURI="">

    <display:column property="copyrightNum" sortable="true" headerClass="sortable"
         titleKey="proProgramForm.copyrightNum"/>		<!--copyrightNum--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="proProgramForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="proProgramForm.createDate"/>		<!--createDate--> 
    <display:column property="endDate" sortable="true" headerClass="sortable"
         titleKey="proProgramForm.endDate"/>		<!--endDate--> 
    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editProProgram.html" paramId="id" paramProperty="id"
        titleKey="proProgramForm.id"/>
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="proProgramForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="proProgramForm.modifyDate"/>		<!--modifyDate--> 
    <display:column property="proName" sortable="true" headerClass="sortable"
         titleKey="proProgramForm.proName"/>		<!--proName--> 
    <display:column property="startDate" sortable="true" headerClass="sortable"
         titleKey="proProgramForm.startDate"/>		<!--startDate--> 
    <display:setProperty name="paging.banner.item_name" value="proProgram"/>
    <display:setProperty name="paging.banner.items_name" value="proPrograms"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("proProgramList");
</script>
