<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaProductInfoList.title"/></title>
<content tag="heading"><fmt:message key="oaProductInfoList.heading"/></content>
<meta name="menu" content="OaProductInfoMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaProductInfo.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaProductInfoList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaProductInfoList" pagesize="25" class="tableDisplay oaProductInfoList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaProductInfo.html" paramId="id" paramProperty="id"
        titleKey="oaProductInfoForm.id"/>
    <display:column property="fittings" sortable="true" headerClass="sortable"
         titleKey="oaProductInfoForm.fittings"/>		<!--fittings--> 
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="oaProductInfoForm.memo"/>		<!--memo--> 
    <display:column property="picture" sortable="true" headerClass="sortable"
         titleKey="oaProductInfoForm.picture"/>		<!--picture--> 
    <display:column property="price" sortable="true" headerClass="sortable"
         titleKey="oaProductInfoForm.price"/>		<!--price--> 
    <display:column property="productTypeId" sortable="true" headerClass="sortable"
         titleKey="oaProductInfoForm.productTypeId"/>		<!--productTypeId--> 
    <display:column property="provider" sortable="true" headerClass="sortable"
         titleKey="oaProductInfoForm.provider"/>		<!--provider--> 
    <display:column property="quantity" sortable="true" headerClass="sortable"
         titleKey="oaProductInfoForm.quantity"/>		<!--quantity--> 
    <display:column property="stockDate" sortable="true" headerClass="sortable"
         titleKey="oaProductInfoForm.stockDate"/>		<!--stockDate--> 
    <display:column property="stockUser" sortable="true" headerClass="sortable"
         titleKey="oaProductInfoForm.stockUser"/>		<!--stockUser--> 
    <display:column property="storageDate" sortable="true" headerClass="sortable"
         titleKey="oaProductInfoForm.storageDate"/>		<!--storageDate--> 
    <display:column property="unit" sortable="true" headerClass="sortable"
         titleKey="oaProductInfoForm.unit"/>		<!--unit--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaProductInfoForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaProductInfoForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaProductInfoForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaProductInfoForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaProductInfo"/>
    <display:setProperty name="paging.banner.items_name" value="oaProductInfos"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaProductInfoList");
</script>
