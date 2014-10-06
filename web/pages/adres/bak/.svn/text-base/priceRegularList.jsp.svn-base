<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="priceRegularList.title"/></title>
<content tag="heading"><fmt:message key="priceRegularList.heading"/></content>
<meta name="menu" content="PriceRegularMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editPriceRegular.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="priceRegularList" cellspacing="0" cellpadding="0"
    id="priceRegularList" pagesize="25" class="tableDisplay priceRegularList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editPriceRegular.html" paramId="id" paramProperty="id"
        titleKey="priceRegularForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="priceRegularForm.name"/>
    <display:column property="multiBase" sortable="true" headerClass="sortable"
         titleKey="priceRegularForm.multiBase"/>
    <display:column property="multiply" sortable="true" headerClass="sortable"
         titleKey="priceRegularForm.multiply"/>
    <display:column property="otherBase" sortable="true" headerClass="sortable"
         titleKey="priceRegularForm.otherBase"/>
    <display:column property="regularExpr" sortable="true" headerClass="sortable"
         titleKey="priceRegularForm.regularExpr"/>
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="priceRegularForm.createBy"/>
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="priceRegularForm.createDate"/>
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="priceRegularForm.modifyBy"/>
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="priceRegularForm.modifyDate"/>
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="priceRegularForm.memo"/>
    <display:setProperty name="paging.banner.item_name" value="priceRegular"/>
    <display:setProperty name="paging.banner.items_name" value="priceRegulars"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("priceRegularList");
</script>
