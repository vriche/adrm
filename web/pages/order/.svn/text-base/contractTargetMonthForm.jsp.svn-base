<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="contractTargetMonthDetail.title"/></title>
<content tag="heading"><fmt:message key="contractTargetMonthDetail.heading"/></content>

<html:form action="saveContractTargetMonth" method="post" styleId="contractTargetMonthForm" onsubmit="return validateContractTargetMonthForm(this)">
<ul>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="contractTargetMonthForm.contractTargetId"/>
        <html:errors property="contractTargetId"/>
        <html:text property="contractTargetId" styleId="contractTargetId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractTargetMonthForm.monthDate"/>
        <html:errors property="monthDate"/>
        <html:text property="monthDate" styleId="monthDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractTargetMonthForm.monthReal"/>
        <html:errors property="monthReal"/>
        <html:text property="monthReal" styleId="monthReal" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractTargetMonthForm.monthTarg"/>
        <html:errors property="monthTarg"/>
        <html:text property="monthTarg" styleId="monthTarg" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="contractTargetMonthForm.contractTarget"/>
        <html:errors property="contractTarget"/>
        <html:text property="contractTarget" styleId="contractTarget" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('ContractTargetMonth')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("contractTargetMonthForm"));
</script>

<html:javascript formName="contractTargetMonthForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
