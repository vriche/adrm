<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="specificList.title"/></title>
<content tag="heading"><fmt:message key="specificList.heading"/></content>
<meta name="menu" content="SpecificMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editSpecific.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="specificList" cellspacing="1" cellpadding="0"
    id="specificList" pagesize="20" class="tableDisplay specificList"
    export="false" requestURI="">

    <display:column property="name" sortable="true" headerClass="sortable"
        url="/editSpecific.html" paramId="id" paramProperty="id"
        titleKey="specificForm.name"/>
    
     <display:column property="position" sortable="true" headerClass="sortable"
         titleKey="specificForm.position"/>

    <display:column property="overRate" sortable="true" headerClass="sortable"
         titleKey="specificForm.overRate"/>       
        
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="specificForm.memo"/>

    <display:setProperty name="paging.banner.item_name" value="specific"/>
    <display:setProperty name="paging.banner.items_name" value="specifics"/>
</display:table>


<script type="text/javascript">
    highlightTableRows("specificList");
</script>
