<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaAreaPcList.title"/></title>
<content tag="heading"><fmt:message key="oaAreaPcList.heading"/></content>
<meta name="menu" content="OaAreaPcMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaAreaPc.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaAreaPcList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaAreaPcList" pagesize="25" class="tableDisplay oaAreaPcList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaAreaPc.html" paramId="id" paramProperty="id"
        titleKey="oaAreaPcForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="oaAreaPcForm.name"/>		<!--name--> 
    <display:column property="areaCityId" sortable="true" headerClass="sortable"
         titleKey="oaAreaPcForm.areaCityId"/>		<!--areaCityId--> 
    <display:column property="ldCode" sortable="true" headerClass="sortable"
         titleKey="oaAreaPcForm.ldCode"/>		<!--ldCode--> 
    <display:column property="postCode" sortable="true" headerClass="sortable"
         titleKey="oaAreaPcForm.postCode"/>		<!--postCode--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaAreaPcForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaAreaPcForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaAreaPcForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaAreaPcForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaAreaPc"/>
    <display:setProperty name="paging.banner.items_name" value="oaAreaPcs"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaAreaPcList");
</script>
