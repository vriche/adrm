<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="workspanDetail.title"/></title>
<content tag="heading"><fmt:message key="workspanDetail.heading"/></content>

<html:form action="saveWorkspan" method="post" styleId="workspanForm" onsubmit="return validateWorkspanForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="workspanForm.dayInfos"/>
        <html:errors property="dayInfos"/>
        <html:text property="dayInfos" styleId="dayInfos" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="workspanForm.propertiyTime"/>
        <html:errors property="propertiyTime"/>
        <html:text property="propertiyTime" styleId="propertiyTime" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="workspanForm.beginDate"/>
        <html:errors property="beginDate"/>
        <html:text property="beginDate" styleId="beginDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="workspanForm.broadcastEndTime"/>
        <html:errors property="broadcastEndTime"/>
        <html:text property="broadcastEndTime" styleId="broadcastEndTime" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="workspanForm.broadcastStartTime"/>
        <html:errors property="broadcastStartTime"/>
        <html:text property="broadcastStartTime" styleId="broadcastStartTime" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="workspanForm.carrierId"/>
        <html:errors property="carrierId"/>
        <html:text property="carrierId" styleId="carrierId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="workspanForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="workspanForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="workspanForm.endDate"/>
        <html:errors property="endDate"/>
        <html:text property="endDate" styleId="endDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="workspanForm.friLength"/>
        <html:errors property="friLength"/>
        <html:text property="friLength" styleId="friLength" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="workspanForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="workspanForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="workspanForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="workspanForm.monLength"/>
        <html:errors property="monLength"/>
        <html:text property="monLength" styleId="monLength" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="workspanForm.resourceId"/>
        <html:errors property="resourceId"/>
        <html:text property="resourceId" styleId="resourceId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="workspanForm.resourceType"/>
        <html:errors property="resourceType"/>
        <html:text property="resourceType" styleId="resourceType" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="workspanForm.satLength"/>
        <html:errors property="satLength"/>
        <html:text property="satLength" styleId="satLength" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="workspanForm.sunLength"/>
        <html:errors property="sunLength"/>
        <html:text property="sunLength" styleId="sunLength" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="workspanForm.thiLength"/>
        <html:errors property="thiLength"/>
        <html:text property="thiLength" styleId="thiLength" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="workspanForm.tueLength"/>
        <html:errors property="tueLength"/>
        <html:text property="tueLength" styleId="tueLength" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="workspanForm.wenLength"/>
        <html:errors property="wenLength"/>
        <html:text property="wenLength" styleId="wenLength" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('Workspan')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("workspanForm"));
</script>

<html:javascript formName="workspanForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
