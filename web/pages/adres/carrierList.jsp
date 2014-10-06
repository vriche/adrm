<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="carrierList.title"/></title>
<content tag="heading"><fmt:message key="carrierList.heading"/></content>
<meta name="menu" content="CarrierMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editCarrier.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="carrierList" cellspacing="0" cellpadding="0"
    id="carrierList" pagesize="25" class="tableDisplay carrierList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editCarrier.html" paramId="id" paramProperty="id"
        titleKey="carrierForm.id"/>
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="carrierForm.createBy"/>
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="carrierForm.createDate"/>
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="carrierForm.modifyBy"/>
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="carrierForm.modifyDate"/>
    <display:column property="enable" sortable="true" headerClass="sortable"
         titleKey="carrierForm.enable"/>
    <display:column property="carrierName" sortable="true" headerClass="sortable"
         titleKey="carrierForm.carrierName"/>
    <display:column property="aliasName" sortable="true" headerClass="sortable"
         titleKey="carrierForm.aliasName"/>
    <display:column property="parentId" sortable="true" headerClass="sortable"
         titleKey="carrierForm.parentId"/>
    <display:column property="nodeLevel" sortable="true" headerClass="sortable"
         titleKey="carrierForm.nodeLevel"/>
    <display:column property="displayNo" sortable="true" headerClass="sortable"
         titleKey="carrierForm.displayNo"/>
    <display:column property="nodePath" sortable="true" headerClass="sortable"
         titleKey="carrierForm.nodePath"/>
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="carrierForm.memo"/>
    <display:setProperty name="paging.banner.item_name" value="carrier"/>
    <display:setProperty name="paging.banner.items_name" value="carriers"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("carrierList");
</script>
