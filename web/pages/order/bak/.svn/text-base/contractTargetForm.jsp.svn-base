<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="contractTargetDetail.title"/></title>
<content tag="heading"><fmt:message key="contractTargetDetail.heading"/></content>

<html:form action="saveContractTarget" method="post" styleId="contractTargetForm" onsubmit="return validateContractTargetForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="contractTargetForm.carrierId"/>
        <html:errors property="carrierId"/>
        <html:text property="carrierId" styleId="carrierId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractTargetForm.contractId"/>
        <html:errors property="contractId"/>
        <html:text property="contractId" styleId="contractId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractTargetForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractTargetForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="contractTargetForm.industryTypeId"/>
        <html:errors property="industryTypeId"/>
        <html:text property="industryTypeId" styleId="industryTypeId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractTargetForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractTargetForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractTargetForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractTargetForm.target"/>
        <html:errors property="target"/>
        <html:text property="target" styleId="target" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('ContractTarget')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("contractTargetForm"));
</script>

<html:javascript formName="contractTargetForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
