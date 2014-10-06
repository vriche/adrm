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

    <display:column property="customerName" sortable="true" headerClass="sortable"
         paramId="id" paramProperty="id" url="/editForetArrearage.html"
         titleKey="foretArrearageForm.customerName"/>		<!--customerName--> 
    <display:column property="incomeCode" sortable="true" headerClass="sortable"
         titleKey="foretArrearageForm.incomeCode"/>		<!--incomeCode--> 
    <display:column property="incomeDate" sortable="true" headerClass="sortable"
         decorator="com.vriche.adrm.webapp.util.ConvertNum2DateWrapper"
         titleKey="foretArrearageForm.incomeDate"/>		<!--incomeDate--> 
    <display:column property="incomeMode" sortable="true" headerClass="sortable"
         titleKey="foretArrearageForm.incomeMode"/>		<!--incomeMode--> 
    <display:column property="incomeMoney" sortable="true" headerClass="sortable" class="sortableRight"
         titleKey="foretArrearageForm.incomeMoney"/>		<!--incomeMoney--> 
    <display:column property="incomePurpose" sortable="true" headerClass="sortable"
         titleKey="foretArrearageForm.incomePurpose"/>		<!--incomePurpose--> 
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="foretArrearageForm.memo"/>		<!--memo--> 
    <display:column property="payDate" sortable="true" headerClass="sortable"
    	 decorator="com.vriche.adrm.webapp.util.ConvertNum2DateWrapper"
         titleKey="foretArrearageForm.payDate"/>		<!--payDate--> 
    <display:column property="payMoney" sortable="true" headerClass="sortable" class="sortableRight"
         titleKey="foretArrearageForm.payMoney"/>		<!--payMoney--> 
    <display:column property="userName" sortable="true" headerClass="sortable"
         titleKey="foretArrearageForm.userName"/>		<!--userName--> 
    
    <display:setProperty name="paging.banner.item_name" value="foretArrearage"/>
    <display:setProperty name="paging.banner.items_name" value="foretArrearages"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("foretArrearageList");
</script>
