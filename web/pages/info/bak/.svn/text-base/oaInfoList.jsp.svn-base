<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaInfoList.title"/></title>
<content tag="heading"><fmt:message key="oaInfoList.heading"/></content>
<meta name="menu" content="OaInfoMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaInfo.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaInfoList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaInfoList" pagesize="25" class="tableDisplay oaInfoList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaInfo.html" paramId="id" paramProperty="id"
        titleKey="oaInfoForm.id"/>
    <display:column property="content" sortable="true" headerClass="sortable"
         titleKey="oaInfoForm.content"/>		<!--content--> 
    <display:column property="displayTimes" sortable="true" headerClass="sortable"
         titleKey="oaInfoForm.displayTimes"/>		<!--displayTimes--> 
    <display:column property="infoTypeId" sortable="true" headerClass="sortable"
         titleKey="oaInfoForm.infoTypeId"/>		<!--infoTypeId--> 
    <display:column property="searchKey" sortable="true" headerClass="sortable"
         titleKey="oaInfoForm.searchKey"/>		<!--searchKey--> 
    <display:column property="title" sortable="true" headerClass="sortable"
         titleKey="oaInfoForm.title"/>		<!--title--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaInfoForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaInfoForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaInfoForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaInfoForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaInfo"/>
    <display:setProperty name="paging.banner.items_name" value="oaInfos"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaInfoList");
</script>
