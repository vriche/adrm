<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="linkHisotryList.title"/></title>
<content tag="heading"><fmt:message key="linkHisotryList.heading"/></content>
<meta name="menu" content="LinkHisotryMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editLinkHisotry.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="linkHisotryList" cellspacing="1" cellpadding="0"
    id="linkHisotryList" pagesize="9" class="tableDisplay linkHisotryList"
    export="false" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editLinkHisotry.html" paramId="id" paramProperty="id"
        titleKey="linkHisotryForm.id"/>
    <display:column property="linkDate" sortable="true" headerClass="sortable"
         titleKey="linkHisotryForm.linkDate"/>
    <display:column property="subject" sortable="true" headerClass="sortable"
         titleKey="linkHisotryForm.subject"/>
    <display:column property="linkManId" sortable="true" headerClass="sortable"
         titleKey="linkHisotryForm.linkManId"/>
    <display:column property="counterpartMan" sortable="true" headerClass="sortable"
         titleKey="linkHisotryForm.counterpartMan"/>
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="linkHisotryForm.memo"/>
    <display:setProperty name="paging.banner.item_name" value="linkHisotry"/>
    <display:setProperty name="paging.banner.items_name" value="linkHisotrys"/>
</display:table>


<script type="text/javascript">
    highlightTableRows("linkHisotryList");
</script>
