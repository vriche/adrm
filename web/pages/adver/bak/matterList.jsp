<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="matterList.title"/></title>
<content tag="heading"><fmt:message key="matterList.heading"/></content>
<meta name="menu" content="MatterMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editMatter.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="matterList" cellspacing="1" cellpadding="0"
    id="matterList" pagesize="20" class="tableDisplay matterList"
    export="false" requestURI="">

    <display:column property="name" sortable="true" headerClass="sortable"
        url="/editMatter.html" paramId="id" paramProperty="id"
        titleKey="matterForm.name"/>
    <display:column property="edit" sortable="true" headerClass="sortable"
         titleKey="matterForm.edit"/>
    <display:column property="length" sortable="true" headerClass="sortable"
         titleKey="matterForm.length"/>
    <display:column property="tapeCode" sortable="true" headerClass="sortable"
         titleKey="matterForm.tapeCode"/>
    <display:column property="customerId" sortable="true" headerClass="sortable"
         titleKey="matterForm.customerId"/>
    <display:column property="matterType" sortable="true" headerClass="sortable"
         titleKey="matterForm.matterType"/>
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="matterForm.memo"/>
    <display:column property="enable" sortable="true" headerClass="sortable"
         titleKey="matterForm.enable"/>
    <display:setProperty name="paging.banner.item_name" value="matter"/>
    <display:setProperty name="paging.banner.items_name" value="matters"/>
</display:table>



<script type="text/javascript">
    highlightTableRows("matterList");
</script>
