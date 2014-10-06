<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="customerList.title"/></title>
<content tag="heading"><fmt:message key="customerList.heading"/></content>
<meta name="menu" content="CustomerMenu"/>


<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editCustomer.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

 <c:out value="${buttons}" escapeXml="false"/> 
 
 <display:table name="customerList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="customerList" pagesize="9" class="tableDisplay" 
    export="false" requestURI="/customers.html">

    <display:column property="customerName" sortable="true" headerClass="sortable"
        url="/editCustomer.html" paramId="id" paramProperty="id"
        titleKey="customerForm.customerName"/>			<!--客户名称--> 
    <display:column property="helpCode" sortable="true" headerClass="sortable"
     	titleKey="customerForm.helpCode"/> 				<!--助记码-->   
    <display:column property="telephone" sortable="true" headerClass="sortable"
        titleKey="customerForm.telephone"/> 			<!--电话-->
    <display:column property="fax" sortable="true" headerClass="sortable"
        titleKey="customerForm.fax"/> 					<!--传真-->
    <display:column property="creditAccount" sortable="true" headerClass="sortable"
     	titleKey="customerForm.creditAccount"/>			<!--信用额度-->
    <display:column property="ownerAgent" sortable="true" headerClass="sortable"
        titleKey="customerForm.ownerAgent"/>			<!--法人代表-->
    <display:column property="customerState" sortable="true" headerClass="sortable"
        titleKey="customerForm.customerState"/> 		<!--用户状态-->
    <display:column property="category.categoryName" sortable="true" headerClass="sortable"
        titleKey="customerForm.customerCategoryId"/>	<!--客户类别-->
    <display:column property="linkMan.linkmanName" sortable="true" headerClass="sortable"
        url="/editLinkMan.html" paramId="id" paramProperty="linkMan.id"
        titleKey="customerForm.customerMainLinkMan"/>	<!--主要联系人-->        
                     
    <display:setProperty name="basic.show.header" value="true"/>
    <display:setProperty name="paging.banner.group_size" value="6"/>     
    <display:setProperty name="paging.banner.item_name" value="customer"/>
    <display:setProperty name="paging.banner.items_name" value="customers"/>
</display:table>       
        
      
        
        
<script type="text/javascript">
    highlightTableRows("customerList");
</script>
        