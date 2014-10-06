<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="carrierTypeList.title"/></title>
<content tag="heading"><fmt:message key="carrierTypeList.heading"/></content>
<meta name="menu" content="CarrierTypeMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editCarrierType.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="carrierTypeList" cellspacing="0" cellpadding="0"
    id="carrierTypeList" pagesize="25" class="tableDisplay carrierTypeList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editCarrierType.html" paramId="id" paramProperty="id"
        titleKey="carrierTypeForm.id"/>
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="carrierTypeForm.createBy"/>
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="carrierTypeForm.createDate"/>
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="carrierTypeForm.modifyBy"/>
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="carrierTypeForm.modifyDate"/>
    <display:column property="enable" sortable="true" headerClass="sortable"
         titleKey="carrierTypeForm.enable"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="carrierTypeForm.name"/>
    <display:column property="parentId" sortable="true" headerClass="sortable"
         titleKey="carrierTypeForm.parentId"/>
    <display:column property="nodeLevel" sortable="true" headerClass="sortable"
         titleKey="carrierTypeForm.nodeLevel"/>
    <display:column property="displayNo" sortable="true" headerClass="sortable"
         titleKey="carrierTypeForm.displayNo"/>
    <display:column property="nodePath" sortable="true" headerClass="sortable"
         titleKey="carrierTypeForm.nodePath"/>
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="carrierTypeForm.memo"/>
    <display:setProperty name="paging.banner.item_name" value="carrierType"/>
    <display:setProperty name="paging.banner.items_name" value="carrierTypes"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("carrierTypeList");
</script>
