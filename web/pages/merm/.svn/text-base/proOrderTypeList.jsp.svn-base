<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="proOrderTypeList.title"/></title>
<content tag="heading"><fmt:message key="proOrderTypeList.heading"/></content>
<meta name="menu" content="ProOrderTypeMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editProOrderType.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="proOrderTypeList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="proOrderTypeList" pagesize="25" class="tableDisplay proOrderTypeList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editProOrderType.html" paramId="id" paramProperty="id"
        titleKey="proOrderTypeForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="proOrderTypeForm.name"/>		<!--name--> 
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="proOrderTypeForm.value"/>		<!--value--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="proOrderTypeForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="proOrderTypeForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="proOrderTypeForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="proOrderTypeForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="proOrderType"/>
    <display:setProperty name="paging.banner.items_name" value="proOrderTypes"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("proOrderTypeList");
</script>
