<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="productCategoryList.title"/></title>
<content tag="heading"><fmt:message key="productCategoryList.heading"/></content>
<meta name="menu" content="ProductCategoryMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editProductCategory.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="productCategoryList" cellspacing="1" cellpadding="0"
    id="productCategoryList" pagesize="9" class="tableDisplay productCategoryList"
    export="false" requestURI="">
    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editProductCategory.html" paramId="id" paramProperty="id"
        titleKey="productCategoryForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="productCategoryForm.name"/>
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="productCategoryForm.modifyDate"/>
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="productCategoryForm.memo"/>
    <display:column property="enable" sortable="true" headerClass="sortable"
         titleKey="productCategoryForm.enable"/>
    <display:setProperty name="paging.banner.item_name" value="productCategory"/>
    <display:setProperty name="paging.banner.items_name" value="productCategorys"/>
</display:table>


<script type="text/javascript">
    highlightTableRows("productCategoryList");
</script>
