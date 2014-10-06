<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="priceRegularDetail.title"/></title>
<content tag="heading"><fmt:message key="priceRegularDetail.heading"/></content>

<html:form action="savePriceRegular" method="post" styleId="priceRegularForm" onsubmit="return validatePriceRegularForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="priceRegularForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceRegularForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="priceRegularForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceRegularForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceRegularForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceRegularForm.multiBase"/>
        <html:errors property="multiBase"/>
        <html:text property="multiBase" styleId="multiBase" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceRegularForm.multiply"/>
        <html:errors property="multiply"/>
        <html:text property="multiply" styleId="multiply" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceRegularForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceRegularForm.otherBase"/>
        <html:errors property="otherBase"/>
        <html:text property="otherBase" styleId="otherBase" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceRegularForm.regularExpr"/>
        <html:errors property="regularExpr"/>
        <html:text property="regularExpr" styleId="regularExpr" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('PriceRegular')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("priceRegularForm"));
</script>

<html:javascript formName="priceRegularForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
