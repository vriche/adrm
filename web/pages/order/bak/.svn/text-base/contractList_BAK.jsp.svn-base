<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="contractList.title"/></title>
<content tag="heading"><fmt:message key="contractList.heading"/></content>
<meta name="menu" content="ContractMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editContract.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="contractList" cellspacing="0" cellpadding="0"
    id="contractList" pagesize="25" class="table contractList"
    export="true" requestURI="">
    <display:column property="code" sortable="true" headerClass="sortable"
         url="/editContract.html" titleKey="contractForm.code"/>
    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editContract.html" paramId="id" paramProperty="id"
        titleKey="contractForm.id"/>
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="contractForm.createBy"/>
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="contractForm.createDate"/>
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="contractForm.modifyBy"/>
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="contractForm.modifyDate"/>
    <display:column property="owner" sortable="true" headerClass="sortable"
         titleKey="contractForm.owner"/>
    <display:column property="customerId" sortable="true" headerClass="sortable"
         titleKey="contractForm.customerId"/>
    <display:column property="signUser" sortable="true" headerClass="sortable"
         titleKey="contractForm.signUser"/>
    <display:column property="signHeadship" sortable="true" headerClass="sortable"
         titleKey="contractForm.signHeadship"/>
    <display:column property="moneySum" sortable="true" headerClass="sortable"
         titleKey="contractForm.moneySum"/>
    <display:column property="moneyExec" sortable="true" headerClass="sortable"
         titleKey="contractForm.moneyExec"/>
    <display:column property="moneyIn" sortable="true" headerClass="sortable"
         titleKey="contractForm.moneyIn"/>
    <display:column property="csignDate" sortable="true" headerClass="sortable"
         titleKey="contractForm.csignDate"/>
    <display:column property="state" sortable="true" headerClass="sortable"
         titleKey="contractForm.state"/>
    <display:column property="startDate" sortable="true" headerClass="sortable"
         titleKey="contractForm.startDate"/>
    <display:column property="endDate" sortable="true" headerClass="sortable"
         titleKey="contractForm.endDate"/>
    <display:column property="contractType" sortable="true" headerClass="sortable"
         titleKey="contractForm.contractType"/>
    <display:column property="notifyDays" sortable="true" headerClass="sortable"
         titleKey="contractForm.notifyDays"/>
    <display:column property="isLimitOrder" sortable="true" headerClass="sortable"
         titleKey="contractForm.isLimitOrder"/>
    <display:column property="contractSort" sortable="true" headerClass="sortable"
         titleKey="contractForm.contractSort"/>
    <display:column property="userId" sortable="true" headerClass="sortable"
         titleKey="contractForm.userId"/>
    <display:column property="osignDate" sortable="true" headerClass="sortable"
         titleKey="contractForm.osignDate"/>
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="contractForm.memo"/>
    <display:column property="memoRenew" sortable="true" headerClass="sortable"
         titleKey="contractForm.memoRenew"/>
    <display:setProperty name="paging.banner.item_name" value="contract"/>
    <display:setProperty name="paging.banner.items_name" value="contracts"/>
</display:table>


<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("contractList");
</script>
