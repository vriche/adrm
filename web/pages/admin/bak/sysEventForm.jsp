<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="sysEventDetail.title"/></title>
<content tag="heading"><fmt:message key="sysEventDetail.heading"/></content>

<html:form action="saveSysEvent" method="post" styleId="sysEventForm" onsubmit="return validateSysEventForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.eventstateid"/>
        <html:errors property="eventstateid"/>
        <html:text property="eventstateid" styleId="eventstateid" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.eventtypeid"/>
        <html:errors property="eventtypeid"/>
        <html:text property="eventtypeid" styleId="eventtypeid" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.infoid"/>
        <html:errors property="infoid"/>
        <html:text property="infoid" styleId="infoid" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.linkpath"/>
        <html:errors property="linkpath"/>
        <html:text property="linkpath" styleId="linkpath" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.mesgmemo"/>
        <html:errors property="mesgmemo"/>
        <html:text property="mesgmemo" styleId="mesgmemo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.promptend"/>
        <html:errors property="promptend"/>
        <html:text property="promptend" styleId="promptend" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.promptmodeid"/>
        <html:errors property="promptmodeid"/>
        <html:text property="promptmodeid" styleId="promptmodeid" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.promptstart"/>
        <html:errors property="promptstart"/>
        <html:text property="promptstart" styleId="promptstart" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.eventState"/>
        <html:errors property="eventState"/>
        <html:text property="eventState" styleId="eventState" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.eventStateId"/>
        <html:errors property="eventStateId"/>
        <html:text property="eventStateId" styleId="eventStateId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.eventType"/>
        <html:errors property="eventType"/>
        <html:text property="eventType" styleId="eventType" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.eventTypeId"/>
        <html:errors property="eventTypeId"/>
        <html:text property="eventTypeId" styleId="eventTypeId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.info"/>
        <html:errors property="info"/>
        <html:text property="info" styleId="info" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.infoId"/>
        <html:errors property="infoId"/>
        <html:text property="infoId" styleId="infoId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.linkPath"/>
        <html:errors property="linkPath"/>
        <html:text property="linkPath" styleId="linkPath" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.mesgMemo"/>
        <html:errors property="mesgMemo"/>
        <html:text property="mesgMemo" styleId="mesgMemo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.promptEnd"/>
        <html:errors property="promptEnd"/>
        <html:text property="promptEnd" styleId="promptEnd" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.promptMode"/>
        <html:errors property="promptMode"/>
        <html:text property="promptMode" styleId="promptMode" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.promptModeId"/>
        <html:errors property="promptModeId"/>
        <html:text property="promptModeId" styleId="promptModeId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysEventForm.promptStart"/>
        <html:errors property="promptStart"/>
        <html:text property="promptStart" styleId="promptStart" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('SysEvent')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("sysEventForm"));
</script>

<html:javascript formName="sysEventForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
