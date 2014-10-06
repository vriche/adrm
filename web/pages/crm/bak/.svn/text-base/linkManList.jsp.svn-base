<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="linkManList.title"/></title>
<content tag="heading"><fmt:message key="linkManList.heading"/></content>
<meta name="menu" content="LinkManMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editLinkMan.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="linkManList" cellspacing="1" cellpadding="0"
    id="linkManList" pagesize="9" class="tableDisplay"
    export="false" requestURI="">

    <display:column property="linkmanName" sortable="true" headerClass="sortable"
        url="/editLinkMan.html" paramId="id" paramProperty="id"
        titleKey="linkManForm.linkmanName"/>
    <display:column property="customerId" sortable="true" headerClass="sortable"
         titleKey="linkManForm.customerId"/>
    <display:column property="jobTitle" sortable="true" headerClass="sortable"
         titleKey="linkManForm.jobTitle"/>
    <display:column property="homeCountry" sortable="true" headerClass="sortable"
         titleKey="linkManForm.homeCountry"/>
    <display:column property="homeProvince" sortable="true" headerClass="sortable"
         titleKey="linkManForm.homeProvince"/>
    <display:column property="homeCity" sortable="true" headerClass="sortable"
         titleKey="linkManForm.homeCity"/>
    <display:column property="homeScarriert" sortable="true" headerClass="sortable"
         titleKey="linkManForm.homeScarriert"/>
    <display:column property="homeZip" sortable="true" headerClass="sortable"
         titleKey="linkManForm.homeZip"/>
    <display:column property="homeTel" sortable="true" headerClass="sortable"
         titleKey="linkManForm.homeTel"/>
    <display:column property="officeTel" sortable="true" headerClass="sortable"
         titleKey="linkManForm.officeTel"/>
    <display:column property="mobile" sortable="true" headerClass="sortable"
         titleKey="linkManForm.mobile"/>
    <display:column property="favorEmail" sortable="true" headerClass="sortable"
         titleKey="linkManForm.favorEmail"/>
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="linkManForm.memo"/>
         
    <display:setProperty name="paging.banner.item_name" value="linkMan"/>
    <display:setProperty name="paging.banner.items_name" value="linkMans"/>
</display:table>


<script type="text/javascript">
    highlightTableRows("linkManList");
</script>
