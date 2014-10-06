<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="financeTargetDetail.title"/></title>
<content tag="heading"><fmt:message key="financeTargetDetail.heading"/></content>

<html:form action="saveFinanceTarget" method="post" styleId="financeTargetForm" onsubmit="return validateFinanceTargetForm(this)">
<ul>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="financeTargetForm.carrierId"/>
        <html:errors property="carrierId"/>
        <html:text property="carrierId" styleId="carrierId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="financeTargetForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="financeTargetForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="financeTargetForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="financeTargetForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="financeTargetForm.targetDateMonth"/>
        <html:errors property="targetDateMonth"/>
        <html:text property="targetDateMonth" styleId="targetDateMonth" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="financeTargetForm.targetDateYear"/>
        <html:errors property="targetDateYear"/>
        <html:text property="targetDateYear" styleId="targetDateYear" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="financeTargetForm.targetMoney"/>
        <html:errors property="targetMoney"/>
        <html:text property="targetMoney" styleId="targetMoney" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="financeTargetForm.carrier"/>
        <html:errors property="carrier"/>
        <html:text property="carrier" styleId="carrier" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="financeTargetForm.tarMonths"/>
        <html:errors property="tarMonths"/>
        <html:text property="tarMonths" styleId="tarMonths" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('FinanceTarget')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("financeTargetForm"));
</script>

<html:javascript formName="financeTargetForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
