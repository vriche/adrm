<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="industryList.title"/></title>
<content tag="heading"><fmt:message key="industryList.heading"/></content>
<meta name="menu" content="IndustryMenu"/>


<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editIndustry.html"/>'"
        value="<fmt:message key="button.add"/>"/>
        
    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>


<c:out value="${buttons}" escapeXml="false"/>

<display:table name="industryList"  partialList="true" size="resultSize" cellspacing="1" cellpadding="0" 
    id="industryList" pagesize="9" class="tableDisplay" 
    export="false" requestURI="/industrys.html">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editIndustry.html" paramId="id" paramProperty="id" 
        titleKey="industryForm.id"/>
        
    <!-- display:column property="id" href="editIndustry.html" paramId="id" paramName="industry" paramScope="request" 
     sortable="true" headerClass="sortable"  titleKey="industryForm.id"/ --> 

    <display:column property="name" sortable="true" headerClass="sortable "
         titleKey="industryForm.name"/>
    <display:column property="code" sortable="true" headerClass="sortable"
         titleKey="industryForm.code"/>
         
    <display:setProperty name="paging.banner.group_size" value="6"/>
    <display:setProperty name="paging.banner.item_name" value="industry"/>
    <display:setProperty name="paging.banner.items_name" value="industrys"/>
    
</display:table>







<script type="text/javascript">
    highlightTableRows("industryList");
</script>
