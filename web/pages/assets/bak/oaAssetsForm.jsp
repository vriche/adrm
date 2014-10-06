<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaAssetsDetail.title"/></title>
<content tag="heading"><fmt:message key="oaAssetsDetail.heading"/></content>

<html:form action="saveOaAssets" method="post" styleId="oaAssetsForm" onsubmit="return validateOaAssetsForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.purchaseDate"/>
        <html:errors property="purchaseDate"/>
        <html:text property="purchaseDate" styleId="purchaseDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.assetsCode"/>
        <html:errors property="assetsCode"/>
        <html:text property="assetsCode" styleId="assetsCode" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.assetsName"/>
        <html:errors property="assetsName"/>
        <html:text property="assetsName" styleId="assetsName" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.assetsStateId"/>
        <html:errors property="assetsStateId"/>
        <html:text property="assetsStateId" styleId="assetsStateId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.assetsTypeId"/>
        <html:errors property="assetsTypeId"/>
        <html:text property="assetsTypeId" styleId="assetsTypeId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.depreciation"/>
        <html:errors property="depreciation"/>
        <html:text property="depreciation" styleId="depreciation" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.oldValue"/>
        <html:errors property="oldValue"/>
        <html:text property="oldValue" styleId="oldValue" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.provider"/>
        <html:errors property="provider"/>
        <html:text property="provider" styleId="provider" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.purchaseMoney"/>
        <html:errors property="purchaseMoney"/>
        <html:text property="purchaseMoney" styleId="purchaseMoney" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.standard"/>
        <html:errors property="standard"/>
        <html:text property="standard" styleId="standard" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.storage"/>
        <html:errors property="storage"/>
        <html:text property="storage" styleId="storage" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.surplusValue"/>
        <html:errors property="surplusValue"/>
        <html:text property="surplusValue" styleId="surplusValue" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.useYearFixed"/>
        <html:errors property="useYearFixed"/>
        <html:text property="useYearFixed" styleId="useYearFixed" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.voucher"/>
        <html:errors property="voucher"/>
        <html:text property="voucher" styleId="voucher" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.oaAssetsState"/>
        <html:errors property="oaAssetsState"/>
        <html:text property="oaAssetsState" styleId="oaAssetsState" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.oaAssetsType"/>
        <html:errors property="oaAssetsType"/>
        <html:text property="oaAssetsType" styleId="oaAssetsType" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.signUser"/>
        <html:errors property="signUser"/>
        <html:text property="signUser" styleId="signUser" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAssetsForm.oaProductInfos"/>
        <html:errors property="oaProductInfos"/>
        <html:text property="oaProductInfos" styleId="oaProductInfos" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('OaAssets')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("oaAssetsForm"));
</script>

<html:javascript formName="oaAssetsForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
