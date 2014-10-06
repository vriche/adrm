<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaTeleExpensesDetail.title"/></title>
<content tag="heading"><fmt:message key="oaTeleExpensesDetail.heading"/></content>

<html:form action="saveOaTeleExpenses" method="post" styleId="oaTeleExpensesForm" onsubmit="return validateOaTeleExpensesForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="oaTeleExpensesForm.branchId"/>
        <html:errors property="branchId"/>
        <html:text property="branchId" styleId="branchId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaTeleExpensesForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaTeleExpensesForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaTeleExpensesForm.expenses"/>
        <html:errors property="expenses"/>
        <html:text property="expenses" styleId="expenses" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaTeleExpensesForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaTeleExpensesForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaTeleExpensesForm.registerDate"/>
        <html:errors property="registerDate"/>
        <html:text property="registerDate" styleId="registerDate" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('OaTeleExpenses')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("oaTeleExpensesForm"));
</script>

<html:javascript formName="oaTeleExpensesForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
