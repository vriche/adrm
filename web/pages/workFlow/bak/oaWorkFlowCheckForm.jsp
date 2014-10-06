<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaWorkFlowCheckDetail.title"/></title>
<content tag="heading"><fmt:message key="oaWorkFlowCheckDetail.heading"/></content>

<html:form action="saveOaWorkFlowCheck" method="post" styleId="oaWorkFlowCheckForm" onsubmit="return validateOaWorkFlowCheckForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowCheckForm.checkidea"/>
        <html:errors property="checkidea"/>
        <html:text property="checkidea" styleId="checkidea" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowCheckForm.checkresultid"/>
        <html:errors property="checkresultid"/>
        <html:text property="checkresultid" styleId="checkresultid" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowCheckForm.checkuserid"/>
        <html:errors property="checkuserid"/>
        <html:text property="checkuserid" styleId="checkuserid" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowCheckForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowCheckForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowCheckForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowCheckForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowCheckForm.workflowtypeid"/>
        <html:errors property="workflowtypeid"/>
        <html:text property="workflowtypeid" styleId="workflowtypeid" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowCheckForm.checkIdea"/>
        <html:errors property="checkIdea"/>
        <html:text property="checkIdea" styleId="checkIdea" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowCheckForm.checkResult"/>
        <html:errors property="checkResult"/>
        <html:text property="checkResult" styleId="checkResult" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowCheckForm.checkResultId"/>
        <html:errors property="checkResultId"/>
        <html:text property="checkResultId" styleId="checkResultId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowCheckForm.checkUser"/>
        <html:errors property="checkUser"/>
        <html:text property="checkUser" styleId="checkUser" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowCheckForm.checkUserId"/>
        <html:errors property="checkUserId"/>
        <html:text property="checkUserId" styleId="checkUserId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowCheckForm.sysEvent"/>
        <html:errors property="sysEvent"/>
        <html:text property="sysEvent" styleId="sysEvent" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowCheckForm.workFlowType"/>
        <html:errors property="workFlowType"/>
        <html:text property="workFlowType" styleId="workFlowType" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowCheckForm.workFlowTypeId"/>
        <html:errors property="workFlowTypeId"/>
        <html:text property="workFlowTypeId" styleId="workFlowTypeId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowCheckForm.sysEventId"/>
        <html:errors property="sysEventId"/>
        <html:text property="sysEventId" styleId="sysEventId" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('OaWorkFlowCheck')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("oaWorkFlowCheckForm"));
</script>

<html:javascript formName="oaWorkFlowCheckForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
