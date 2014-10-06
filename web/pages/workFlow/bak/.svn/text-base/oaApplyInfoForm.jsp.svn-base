<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaApplyInfoDetail.title"/></title>
<content tag="heading"><fmt:message key="oaApplyInfoDetail.heading"/></content>

<html:form action="saveOaApplyInfo" method="post" styleId="oaApplyInfoForm" onsubmit="return validateOaApplyInfoForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="oaApplyInfoForm.applyEnd"/>
        <html:errors property="applyEnd"/>
        <html:text property="applyEnd" styleId="applyEnd" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaApplyInfoForm.applyStart"/>
        <html:errors property="applyStart"/>
        <html:text property="applyStart" styleId="applyStart" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaApplyInfoForm.checkResult"/>
        <html:errors property="checkResult"/>
        <html:text property="checkResult" styleId="checkResult" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaApplyInfoForm.checkResultId"/>
        <html:errors property="checkResultId"/>
        <html:text property="checkResultId" styleId="checkResultId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaApplyInfoForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaApplyInfoForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaApplyInfoForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaApplyInfoForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaApplyInfoForm.reason"/>
        <html:errors property="reason"/>
        <html:text property="reason" styleId="reason" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaApplyInfoForm.workFlowType"/>
        <html:errors property="workFlowType"/>
        <html:text property="workFlowType" styleId="workFlowType" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaApplyInfoForm.workFlowTypeId"/>
        <html:errors property="workFlowTypeId"/>
        <html:text property="workFlowTypeId" styleId="workFlowTypeId" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('OaApplyInfo')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("oaApplyInfoForm"));
</script>

<html:javascript formName="oaApplyInfoForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
