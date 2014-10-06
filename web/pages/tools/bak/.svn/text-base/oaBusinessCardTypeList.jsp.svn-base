<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaBusinessCardTypeList.title"/></title>
<content tag="heading"><fmt:message key="oaBusinessCardTypeList.heading"/></content>
<meta name="menu" content="OaBusinessCardTypeMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaBusinessCardType.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaBusinessCardTypeList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaBusinessCardTypeList" pagesize="25" class="tableDisplay oaBusinessCardTypeList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaBusinessCardType.html" paramId="id" paramProperty="id"
        titleKey="oaBusinessCardTypeForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardTypeForm.name"/>		<!--name--> 
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardTypeForm.value"/>		<!--value--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardTypeForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardTypeForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardTypeForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardTypeForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaBusinessCardType"/>
    <display:setProperty name="paging.banner.items_name" value="oaBusinessCardTypes"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaBusinessCardTypeList");
</script>
