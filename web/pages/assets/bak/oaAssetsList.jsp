<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaAssetsList.title"/></title>
<content tag="heading"><fmt:message key="oaAssetsList.heading"/></content>
<meta name="menu" content="OaAssetsMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaAssets.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaAssetsList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaAssetsList" pagesize="25" class="tableDisplay oaAssetsList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaAssets.html" paramId="id" paramProperty="id"
        titleKey="oaAssetsForm.id"/>
    <display:column property="assetsCode" sortable="true" headerClass="sortable"
         titleKey="oaAssetsForm.assetsCode"/>		<!--assetsCode--> 
    <display:column property="assetsName" sortable="true" headerClass="sortable"
         titleKey="oaAssetsForm.assetsName"/>		<!--assetsName--> 
    <display:column property="assetsStateId" sortable="true" headerClass="sortable"
         titleKey="oaAssetsForm.assetsStateId"/>		<!--assetsStateId--> 
    <display:column property="assetsTypeId" sortable="true" headerClass="sortable"
         titleKey="oaAssetsForm.assetsTypeId"/>		<!--assetsTypeId--> 
    <display:column property="depreciation" sortable="true" headerClass="sortable"
         titleKey="oaAssetsForm.depreciation"/>		<!--depreciation--> 
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="oaAssetsForm.memo"/>		<!--memo--> 
    <display:column property="oldValue" sortable="true" headerClass="sortable"
         titleKey="oaAssetsForm.oldValue"/>		<!--oldValue--> 
    <display:column property="provider" sortable="true" headerClass="sortable"
         titleKey="oaAssetsForm.provider"/>		<!--provider--> 
    <display:column property="purchaseMoney" sortable="true" headerClass="sortable"
         titleKey="oaAssetsForm.purchaseMoney"/>		<!--purchaseMoney--> 
    <display:column property="purchaseDate" sortable="true" headerClass="sortable"
         titleKey="oaAssetsForm.purchaseDate"/>		<!--purchaseDate--> 
    <display:column property="standard" sortable="true" headerClass="sortable"
         titleKey="oaAssetsForm.standard"/>		<!--standard--> 
    <display:column property="storage" sortable="true" headerClass="sortable"
         titleKey="oaAssetsForm.storage"/>		<!--storage--> 
    <display:column property="surplusValue" sortable="true" headerClass="sortable"
         titleKey="oaAssetsForm.surplusValue"/>		<!--surplusValue--> 
    <display:column property="useYearFixed" sortable="true" headerClass="sortable"
         titleKey="oaAssetsForm.useYearFixed"/>		<!--useYearFixed--> 
    <display:column property="voucher" sortable="true" headerClass="sortable"
         titleKey="oaAssetsForm.voucher"/>		<!--voucher--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaAssetsForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaAssetsForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaAssetsForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaAssetsForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaAssets"/>
    <display:setProperty name="paging.banner.items_name" value="oaAssetss"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaAssetsList");
</script>
