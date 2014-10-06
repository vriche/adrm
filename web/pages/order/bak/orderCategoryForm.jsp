<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="orderCategoryDetail.title"/></title>
<content tag="heading"><fmt:message key="orderCategoryDetail.heading"/></content>

<html:form action="saveOrderCategory" method="post" styleId="orderCategoryForm" onsubmit="return validateOrderCategoryForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="orderCategoryForm.calculateAuto"/>
        <html:errors property="calculateAuto"/>
        <html:text property="calculateAuto" styleId="calculateAuto" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderCategoryForm.displayNo"/>
        <html:errors property="displayNo"/>
        <html:text property="displayNo" styleId="displayNo" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>



    <li>
        <adrm_order:label styleClass="desc" key="orderCategoryForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderCategoryForm.nodeLevel"/>
        <html:errors property="nodeLevel"/>
        <html:text property="nodeLevel" styleId="nodeLevel" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderCategoryForm.nodePath"/>
        <html:errors property="nodePath"/>
        <html:text property="nodePath" styleId="nodePath" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderCategoryForm.parentId"/>
        <html:errors property="parentId"/>
        <html:text property="parentId" styleId="parentId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderCategoryForm.value"/>
        <html:errors property="value"/>
        <html:text property="value" styleId="value" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('OrderCategory')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("orderCategoryForm"));
</script>

<html:javascript formName="orderCategoryForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
