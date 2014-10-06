<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="sysParamList.title"/></title>
<content tag="heading"><fmt:message key="sysParamList.heading"/></content>
<meta name="menu" content="SysParamMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editSysParam.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="sysParamList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="sysParamList" pagesize="25" class="tableDisplay sysParamList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editSysParam.html" paramId="id" paramProperty="id"
        titleKey="sysParamForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="sysParamForm.name"/>		<!--name--> 
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="sysParamForm.memo"/>		<!--memo--> 
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="sysParamForm.value"/>		<!--value--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="sysParamForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="sysParamForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="sysParamForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="sysParamForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="sysParam"/>
    <display:setProperty name="paging.banner.items_name" value="sysParams"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("sysParamList");
</script>
