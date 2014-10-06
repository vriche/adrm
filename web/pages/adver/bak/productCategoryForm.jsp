<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="productCategoryDetail.title"/></title>
<content tag="heading"><fmt:message key="productCategoryDetail.heading"/></content>

<html:form action="saveProductCategory" method="post" styleId="productCategoryForm" onsubmit="return validateProductCategoryForm(this)">


<html:hidden property="id"/>

<ul>

    <li>
        <adrm_order:label styleClass="desc" key="productCategoryForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>
    
    <li>
        <adrm_order:label styleClass="desc" key="productCategoryForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>


    <li>
        <adrm_order:label styleClass="desc" key="productCategoryForm.enable"/>
        <html:errors property="enable"/>
		<html:checkbox property="enable"/>
    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('ProductCategory')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("productCategoryForm"));
</script>

<html:javascript formName="productCategoryForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
