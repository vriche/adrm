<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="agentInfoDetail.title"/></title>
<content tag="heading"><fmt:message key="agentInfoDetail.heading"/></content>

<html:form action="saveAgentInfo" method="post" styleId="agentInfoForm" onsubmit="return validateAgentInfoForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="agentInfoForm.agenetType"/>
        <html:errors property="agenetType"/>
        <html:text property="agenetType" styleId="agenetType" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="agentInfoForm.agentRate"/>
        <html:errors property="agentRate"/>
        <html:text property="agentRate" styleId="agentRate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="agentInfoForm.beginDate"/>
        <html:errors property="beginDate"/>
        <html:text property="beginDate" styleId="beginDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="agentInfoForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="agentInfoForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="agentInfoForm.customerId"/>
        <html:errors property="customerId"/>
        <html:text property="customerId" styleId="customerId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="agentInfoForm.endDate"/>
        <html:errors property="endDate"/>
        <html:text property="endDate" styleId="endDate" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="agentInfoForm.industryTypeId"/>
        <html:errors property="industryTypeId"/>
        <html:text property="industryTypeId" styleId="industryTypeId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="agentInfoForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="agentInfoForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="agentInfoForm.state"/>
        <html:errors property="state"/>
        <html:text property="state" styleId="state" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('AgentInfo')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("agentInfoForm"));
</script>

<html:javascript formName="agentInfoForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
