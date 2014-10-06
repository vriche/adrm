<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="publishArrangeList.title"/></title>
<content tag="heading"><fmt:message key="publishArrangeList.heading"/></content>
<meta name="menu" content="PublishArrangeMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editPublishArrange.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="publishArrangeList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="publishArrangeList" pagesize="25" class="tableDisplay publishArrangeList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editPublishArrange.html" paramId="id" paramProperty="id"
        titleKey="publishArrangeForm.id"/>
    <display:column property="carrierId" sortable="true" headerClass="sortable"
         titleKey="publishArrangeForm.carrierId"/>		<!--carrierId--> 
    <display:column property="carrierName" sortable="true" headerClass="sortable"
         titleKey="publishArrangeForm.carrierName"/>		<!--carrierName--> 
    <display:column property="filePath" sortable="true" headerClass="sortable"
         titleKey="publishArrangeForm.filePath"/>		<!--filePath--> 
    <display:column property="isEnable" sortable="true" headerClass="sortable"
         titleKey="publishArrangeForm.isEnable"/>		<!--isEnable--> 
    <display:column property="isLocked" sortable="true" headerClass="sortable"
         titleKey="publishArrangeForm.isLocked"/>		<!--isLocked--> 
    <display:column property="publishDate" sortable="true" headerClass="sortable"
         titleKey="publishArrangeForm.publishDate"/>		<!--publishDate--> 
    <display:column property="resourceId" sortable="true" headerClass="sortable"
         titleKey="publishArrangeForm.resourceId"/>		<!--resourceId--> 
    <display:column property="resourceMeno" sortable="true" headerClass="sortable"
         titleKey="publishArrangeForm.resourceMeno"/>		<!--resourceMeno--> 
    <display:column property="resourceName" sortable="true" headerClass="sortable"
         titleKey="publishArrangeForm.resourceName"/>		<!--resourceName--> 
    <display:column property="resourceTotalTimes" sortable="true" headerClass="sortable"
         titleKey="publishArrangeForm.resourceTotalTimes"/>		<!--resourceTotalTimes--> 
    <display:column property="resourceUsedTimes" sortable="true" headerClass="sortable"
         titleKey="publishArrangeForm.resourceUsedTimes"/>		<!--resourceUsedTimes--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="publishArrangeForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="publishArrangeForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="publishArrangeForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="publishArrangeForm.modifyDate"/>		<!--modifyDate--> 
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="publishArrangeForm.memo"/>		<!--memo--> 
    <display:setProperty name="paging.banner.item_name" value="publishArrange"/>
    <display:setProperty name="paging.banner.items_name" value="publishArranges"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("publishArrangeList");
</script>
