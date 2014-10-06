<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="feedbackInfoList.title"/></title>
<content tag="heading"><fmt:message key="feedbackInfoList.heading"/></content>
<meta name="menu" content="FeedbackInfoMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editFeedbackInfo.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="feedbackInfoList" cellspacing="2" cellpadding="2"
    id="feedbackInfoList" pagesize="9" class="tableDisplay feedbackInfoList"
    export="false" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editFeedbackInfo.html" paramId="id" paramProperty="id"
        titleKey="feedbackInfoForm.id"/>
    <display:column property="customerId" sortable="true" headerClass="sortable"
         titleKey="feedbackInfoForm.customerId"/>
    <display:column property="feeder" sortable="true" headerClass="sortable"
         titleKey="feedbackInfoForm.feeder"/>
    <display:column property="submitDate" sortable="true" headerClass="sortable"
         titleKey="feedbackInfoForm.submitDate"/>
    <display:column property="feedContent" sortable="true" headerClass="sortable"
         titleKey="feedbackInfoForm.feedContent"/>
    <display:column property="dealDate" sortable="true" headerClass="sortable"
         titleKey="feedbackInfoForm.dealDate"/>

         
    <display:setProperty name="paging.banner.item_name" value="feedbackInfo"/>
    <display:setProperty name="paging.banner.items_name" value="feedbackInfos"/>
</display:table>


<script type="text/javascript">
    highlightTableRows("feedbackInfoList");
</script>
