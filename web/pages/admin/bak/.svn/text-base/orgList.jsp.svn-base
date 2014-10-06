<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="orgList.title"/></title>
<content tag="heading"><fmt:message key="orgList.heading"/></content>
<meta name="menu" content="OrgMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOrg.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="orgList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="orgList" pagesize="25" class="tableDisplay orgList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOrg.html" paramId="id" paramProperty="id"
        titleKey="orgForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="orgForm.name"/>		<!--name--> 
    <display:column property="bankCode" sortable="true" headerClass="sortable"
         titleKey="orgForm.bankCode"/>		<!--bankCode--> 
    <display:column property="bankName" sortable="true" headerClass="sortable"
         titleKey="orgForm.bankName"/>		<!--bankName--> 
    <display:column property="fax" sortable="true" headerClass="sortable"
         titleKey="orgForm.fax"/>		<!--fax--> 
    <display:column property="linkMan" sortable="true" headerClass="sortable"
         titleKey="orgForm.linkMan"/>		<!--linkMan--> 
    <display:column property="tel" sortable="true" headerClass="sortable"
         titleKey="orgForm.tel"/>		<!--tel--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="orgForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="orgForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="orgForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="orgForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="org"/>
    <display:setProperty name="paging.banner.items_name" value="orgs"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("orgList");
</script>
