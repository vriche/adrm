<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="customerTypeDetail.title"/></title>
<content tag="heading"><fmt:message key="customerTypeDetail.heading"/></content>

<html:form action="saveCustomerType" method="post" styleId="customerTypeForm" onsubmit="return validateCustomerTypeForm(this)">

<html:hidden property="id"/>


<ul>

    <li>
        <adrm_order:label styleClass="desc" key="customerTypeForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="customerTypeForm.code"/>
        <html:errors property="code"/>
        <html:text property="code" styleId="code" styleClass="text medium"/>

    </li>


    <li>
        <adrm_order:label styleClass="desc" key="customerTypeForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>


<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('CustomerType')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("customerTypeForm"));
</script>

<html:javascript formName="customerTypeForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
