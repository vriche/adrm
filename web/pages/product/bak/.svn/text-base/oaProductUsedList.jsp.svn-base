<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaProductUsedList.title"/></title>
<content tag="heading"><fmt:message key="oaProductUsedList.heading"/></content>
<meta name="menu" content="OaProductUsedMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaProductUsed.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaProductUsedList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaProductUsedList" pagesize="25" class="tableDisplay oaProductUsedList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaProductUsed.html" paramId="id" paramProperty="id"
        titleKey="oaProductUsedForm.id"/>
    <display:column property="amends" sortable="true" headerClass="sortable"
         titleKey="oaProductUsedForm.amends"/>		<!--amends--> 
    <display:column property="attaint" sortable="true" headerClass="sortable"
         titleKey="oaProductUsedForm.attaint"/>		<!--attaint--> 
    <display:column property="playReturnDate" sortable="true" headerClass="sortable"
         titleKey="oaProductUsedForm.playReturnDate"/>		<!--playReturnDate--> 
    <display:column property="productId" sortable="true" headerClass="sortable"
         titleKey="oaProductUsedForm.productId"/>		<!--productId--> 
    <display:column property="relReturnDate" sortable="true" headerClass="sortable"
         titleKey="oaProductUsedForm.relReturnDate"/>		<!--relReturnDate--> 
    <display:column property="returnNum" sortable="true" headerClass="sortable"
         titleKey="oaProductUsedForm.returnNum"/>		<!--returnNum--> 
    <display:column property="useDate" sortable="true" headerClass="sortable"
         titleKey="oaProductUsedForm.useDate"/>		<!--useDate--> 
    <display:column property="useMan" sortable="true" headerClass="sortable"
         titleKey="oaProductUsedForm.useMan"/>		<!--useMan--> 
    <display:column property="useNum" sortable="true" headerClass="sortable"
         titleKey="oaProductUsedForm.useNum"/>		<!--useNum--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaProductUsedForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaProductUsedForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaProductUsedForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaProductUsedForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaProductUsed"/>
    <display:setProperty name="paging.banner.items_name" value="oaProductUseds"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaProductUsedList");
</script>
