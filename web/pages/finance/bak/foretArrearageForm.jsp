<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="foretArrearageDetail.title"/></title>
<content tag="heading"><fmt:message key="foretArrearageDetail.heading"/></content>

<html:form action="saveForetArrearage" method="post" styleId="foretArrearageForm" onsubmit="return validateForetArrearageForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="foretArrearageForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="foretArrearageForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="foretArrearageForm.customerName"/>
        <html:errors property="customerName"/>
        <html:text property="customerName" styleId="customerName" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="foretArrearageForm.endDate"/>
        <html:errors property="endDate"/>
        <html:text property="endDate" styleId="endDate" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="foretArrearageForm.incomeCode"/>
        <html:errors property="incomeCode"/>
        <html:text property="incomeCode" styleId="incomeCode" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="foretArrearageForm.incomeDate"/>
        <html:errors property="incomeDate"/>
        <html:text property="incomeDate" styleId="incomeDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="foretArrearageForm.incomeMode"/>
        <html:errors property="incomeMode"/>
        <html:text property="incomeMode" styleId="incomeMode" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="foretArrearageForm.incomeMoney"/>
        <html:errors property="incomeMoney"/>
        <html:text property="incomeMoney" styleId="incomeMoney" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="foretArrearageForm.incomePurpose"/>
        <html:errors property="incomePurpose"/>
        <html:text property="incomePurpose" styleId="incomePurpose" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="foretArrearageForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="foretArrearageForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="foretArrearageForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="foretArrearageForm.payDate"/>
        <html:errors property="payDate"/>
        <html:text property="payDate" styleId="payDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="foretArrearageForm.payMoney"/>
        <html:errors property="payMoney"/>
        <html:text property="payMoney" styleId="payMoney" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="foretArrearageForm.startDate"/>
        <html:errors property="startDate"/>
        <html:text property="startDate" styleId="startDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="foretArrearageForm.userName"/>
        <html:errors property="userName"/>
        <html:text property="userName" styleId="userName" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('ForetArrearage')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("foretArrearageForm"));
</script>

<html:javascript formName="foretArrearageForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
