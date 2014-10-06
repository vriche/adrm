<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="categoryDetail.title"/></title>
<content tag="heading"><fmt:message key="customerCategoryDetail.heading"/></content>

<html:form action="saveCategory" method="post" styleId="customerCategoryForm" onsubmit="return validateCategoryForm(this)">
<html:hidden property="id"/>
<html:hidden property="version"/>

<ul>
    <li>
        <adrm_order:label styleClass="desc" key="customerCategoryForm.categoryName"/>
        <html:errors property="categoryName"/>
        <html:text property="categoryName" styleId="categoryName" styleClass="text medium"/>

    </li>
    <li>
        <adrm_order:label styleClass="desc" key="customerCategoryForm.categoryCode"/>
        <html:errors property="categoryCode"/>
        <html:text property="categoryCode" styleId="categoryCode" styleClass="text medium"/>

    </li>
    <li>
        <adrm_order:label styleClass="desc" key="customerCategoryForm.adResourcePriceType"/>
        <html:errors property="adResourcePriceType"/>
        <html:text property="adResourcePriceType" styleId="adResourcePriceType" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="customerCategoryForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>




    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('Category')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("categoryForm"));
</script>

<html:javascript formName="categoryForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
