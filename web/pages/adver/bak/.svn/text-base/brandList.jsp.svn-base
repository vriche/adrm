<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="brandList.title"/></title>
<content tag="heading"><fmt:message key="brandList.heading"/></content>
<meta name="menu" content="BrandMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editBrand.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="brandList" cellspacing="1" cellpadding="0"
    id="brandList" pagesize="9" class="tableDisplay brandList"
    export="false" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editBrand.html" paramId="id" paramProperty="id"
        titleKey="brandForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="brandForm.name"/>
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="brandForm.memo"/>
    <display:column property="enable" sortable="true" headerClass="sortable"
         titleKey="brandForm.enable"/>
    <display:setProperty name="paging.banner.item_name" value="brand"/>
    <display:setProperty name="paging.banner.items_name" value="brands"/>
</display:table>


<script type="text/javascript">
    highlightTableRows("brandList");
</script>
