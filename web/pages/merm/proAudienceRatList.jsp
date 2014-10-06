<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="proAudienceRatList.title"/></title>
<content tag="heading"><fmt:message key="proAudienceRatList.heading"/></content>
<meta name="menu" content="ProAudienceRatMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editProAudienceRat.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="proAudienceRatList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="proAudienceRatList" pagesize="25" class="tableDisplay proAudienceRatList"
    export="true" requestURI="">

    <display:column property="audienceDate" sortable="true" headerClass="sortable"
         titleKey="proAudienceRatForm.audienceDate"/>		<!--audienceDate--> 
    <display:column property="audienceRat" sortable="true" headerClass="sortable"
         titleKey="proAudienceRatForm.audienceRat"/>		<!--audienceRat--> 
    <display:column property="audienceTime" sortable="true" headerClass="sortable"
         titleKey="proAudienceRatForm.audienceTime"/>		<!--audienceTime--> 
    <display:column property="carrierId" sortable="true" headerClass="sortable"
         titleKey="proAudienceRatForm.carrierId"/>		<!--carrierId--> 
    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editProAudienceRat.html" paramId="id" paramProperty="id"
        titleKey="proAudienceRatForm.id"/>
    <display:setProperty name="paging.banner.item_name" value="proAudienceRat"/>
    <display:setProperty name="paging.banner.items_name" value="proAudienceRats"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("proAudienceRatList");
</script>
