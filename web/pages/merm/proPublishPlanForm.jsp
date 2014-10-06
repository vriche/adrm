<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="proPublishPlanDetail.title"/></title>
<content tag="heading"><fmt:message key="proPublishPlanDetail.heading"/></content>

<html:form action="saveProPublishPlan" method="post" styleId="proPublishPlanForm" onsubmit="return validateProPublishPlanForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="proPublishPlanForm.carrier"/>
        <html:errors property="carrier"/>
        <html:text property="carrier" styleId="carrier" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proPublishPlanForm.carrierId"/>
        <html:errors property="carrierId"/>
        <html:text property="carrierId" styleId="carrierId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proPublishPlanForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proPublishPlanForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proPublishPlanForm.endDate"/>
        <html:errors property="endDate"/>
        <html:text property="endDate" styleId="endDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proPublishPlanForm.endTime"/>
        <html:errors property="endTime"/>
        <html:text property="endTime" styleId="endTime" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="proPublishPlanForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proPublishPlanForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proPublishPlanForm.programId"/>
        <html:errors property="programId"/>
        <html:text property="programId" styleId="programId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proPublishPlanForm.proProgram"/>
        <html:errors property="proProgram"/>
        <html:text property="proProgram" styleId="proProgram" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proPublishPlanForm.startDate"/>
        <html:errors property="startDate"/>
        <html:text property="startDate" styleId="startDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proPublishPlanForm.startTime"/>
        <html:errors property="startTime"/>
        <html:text property="startTime" styleId="startTime" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="proPublishPlanForm.weeksPlan"/>
        <html:errors property="weeksPlan"/>
        <html:text property="weeksPlan" styleId="weeksPlan" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('ProPublishPlan')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("proPublishPlanForm"));
</script>

<html:javascript formName="proPublishPlanForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
