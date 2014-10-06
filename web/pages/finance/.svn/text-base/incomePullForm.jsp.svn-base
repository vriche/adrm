<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="incomePullDetail.title"/></title>
<content tag="heading"><fmt:message key="incomePullDetail.heading"/></content>

<html:form action="saveIncomePull" method="post" styleId="incomePullForm" onsubmit="return validateIncomePullForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="incomePullForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="incomePullForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="incomePullForm.incomeId"/>
        <html:errors property="incomeId"/>
        <html:text property="incomeId" styleId="incomeId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="incomePullForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="incomePullForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="incomePullForm.moneyIn"/>
        <html:errors property="moneyIn"/>
        <html:text property="moneyIn" styleId="moneyIn" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="incomePullForm.moneyPull"/>
        <html:errors property="moneyPull"/>
        <html:text property="moneyPull" styleId="moneyPull" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="incomePullForm.resourceCarrierId"/>
        <html:errors property="resourceCarrierId"/>
        <html:text property="resourceCarrierId" styleId="resourceCarrierId" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('IncomePull')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("incomePullForm"));
</script>

<html:javascript formName="incomePullForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
