<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="foretArrearageList.title"/></title>
<content tag="heading"><fmt:message key="foretArrearageList.heading"/></content>
<meta name="menu" content="ForetArrearageMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editForetArrearage.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="foretArrearageList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="foretArrearageList" pagesize="25" class="tableDisplay foretArrearageList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editForetArrearage.html" paramId="id" paramProperty="id"
        titleKey="foretArrearageForm.id"/>
    <display:column property="customerName" sortable="true" headerClass="sortable"
         titleKey="foretArrearageForm.customerName"/>		<!--customerName--> 
    <display:column property="incomeCode" sortable="true" headerClass="sortable"
         titleKey="foretArrearageForm.incomeCode"/>		<!--incomeCode--> 
    <display:column property="incomeDate" sortable="true" headerClass="sortable"
         titleKey="foretArrearageForm.incomeDate"/>		<!--incomeDate--> 
    <display:column property="incomeMode" sortable="true" headerClass="sortable"
         titleKey="foretArrearageForm.incomeMode"/>		<!--incomeMode--> 
    <display:column property="incomeMoney" sortable="true" headerClass="sortable"
         titleKey="foretArrearageForm.incomeMoney"/>		<!--incomeMoney--> 
    <display:column property="incomePurpose" sortable="true" headerClass="sortable"
         titleKey="foretArrearageForm.incomePurpose"/>		<!--incomePurpose--> 
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="foretArrearageForm.memo"/>		<!--memo--> 
    <display:column property="payDate" sortable="true" headerClass="sortable"
         titleKey="foretArrearageForm.payDate"/>		<!--payDate--> 
    <display:column property="payMoney" sortable="true" headerClass="sortable"
         titleKey="foretArrearageForm.payMoney"/>		<!--payMoney--> 
    <display:column property="userName" sortable="true" headerClass="sortable"
         titleKey="foretArrearageForm.userName"/>		<!--userName--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="foretArrearageForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="foretArrearageForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="foretArrearageForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="foretArrearageForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="foretArrearage"/>
    <display:setProperty name="paging.banner.items_name" value="foretArrearages"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("foretArrearageList");
</script>
