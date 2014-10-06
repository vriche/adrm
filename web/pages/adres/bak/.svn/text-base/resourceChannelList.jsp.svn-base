<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="resourceChannelList.title"/></title>
<content tag="heading"><fmt:message key="resourceChannelList.heading"/></content>
<meta name="menu" content="ResourceChannelMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editResourceChannel.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="resourceChannelList" cellspacing="0" cellpadding="0"
    id="resourceChannelList" pagesize="25" class="tableDisplay resourceChannelList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editResourceChannel.html" paramId="id" paramProperty="id"
        titleKey="resourceChannelForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="resourceChannelForm.name"/>
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="resourceChannelForm.value"/>
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="resourceChannelForm.createBy"/>
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="resourceChannelForm.createDate"/>
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="resourceChannelForm.modifyBy"/>
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="resourceChannelForm.modifyDate"/>
    <display:column property="enable" sortable="true" headerClass="sortable"
         titleKey="resourceChannelForm.enable"/>
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="resourceChannelForm.memo"/>
    <display:setProperty name="paging.banner.item_name" value="resourceChannel"/>
    <display:setProperty name="paging.banner.items_name" value="resourceChannels"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("resourceChannelList");
</script>
