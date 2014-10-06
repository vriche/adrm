<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaCalendarEventDetail.title"/></title>
<content tag="heading"><fmt:message key="oaCalendarEventDetail.heading"/></content>

<html:form action="saveOaCalendarEvent" method="post" styleId="oaCalendarEventForm" onsubmit="return validateOaCalendarEventForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="oaCalendarEventForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaCalendarEventForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaCalendarEventForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaCalendarEventForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaCalendarEventForm.content"/>
        <html:errors property="content"/>
        <html:text property="content" styleId="content" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaCalendarEventForm.eventStateId"/>
        <html:errors property="eventStateId"/>
        <html:text property="eventStateId" styleId="eventStateId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaCalendarEventForm.title"/>
        <html:errors property="title"/>
        <html:text property="title" styleId="title" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('OaCalendarEvent')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("oaCalendarEventForm"));
</script>

<html:javascript formName="oaCalendarEventForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
