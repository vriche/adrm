<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="resourceLimitList.title"/></title>
<content tag="heading"><fmt:message key="resourceLimitList.heading"/></content>
<meta name="menu" content="ResourceLimitMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editResourceLimit.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="resourceLimitList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="resourceLimitList" pagesize="25" class="tableDisplay resourceLimitList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editResourceLimit.html" paramId="id" paramProperty="id"
        titleKey="resourceLimitForm.id"/>
        
    <display:column property="startTime" sortable="true" headerClass="sortable"
         titleKey="resourceLimitForm.startTime"/>		<!--startTime-->      
    <display:column property="starTh" sortable="true" headerClass="sortable"
         titleKey="resourceLimitForm.startTime"/>		<!--startTime--> 
     <display:column property="starTm" sortable="true" headerClass="sortable"
         titleKey="resourceLimitForm.startTime"/>		<!--startTime-->  
         
         
    <display:column property="endTime" sortable="true" headerClass="sortable"
         titleKey="resourceLimitForm.endTime"/>		<!--endTime-->                 
    <display:column property="endTh" sortable="true" headerClass="sortable"
         titleKey="resourceLimitForm.endTime"/>		<!--endTime--> 
     <display:column property="endTm" sortable="true" headerClass="sortable"
         titleKey="resourceLimitForm.endTime"/>		<!--endTime--> 
         
    <display:column property="limitTime" sortable="true" headerClass="sortable"
         titleKey="resourceLimitForm.limitTime"/>		<!--limitTime--> 
         
    <display:setProperty name="paging.banner.item_name" value="resourceLimit"/>
    <display:setProperty name="paging.banner.items_name" value="resourceLimits"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("resourceLimitList");
</script>
