<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="sysSequenceDetail.title"/></title>
<content tag="heading"><fmt:message key="sysSequenceDetail.heading"/></content>

<html:form action="saveSysSequence" method="post" styleId="sysSequenceForm" onsubmit="return validateSysSequenceForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="sysSequenceForm.currentNext"/>
        <html:errors property="currentNext"/>
        <html:text property="currentNext" styleId="currentNext" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysSequenceForm.currentNextSys"/>
        <html:errors property="currentNextSys"/>
        <html:text property="currentNextSys" styleId="currentNextSys" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysSequenceForm.format"/>
        <html:errors property="format"/>
        <html:text property="format" styleId="format" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysSequenceForm.incrementNo"/>
        <html:errors property="incrementNo"/>
        <html:text property="incrementNo" styleId="incrementNo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysSequenceForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysSequenceForm.prefix"/>
        <html:errors property="prefix"/>
        <html:text property="prefix" styleId="prefix" styleClass="text medium"/>

    </li>

<html:hidden property="sequenceID"/>

    <li>
        <adrm_order:label styleClass="desc" key="sysSequenceForm.startNo"/>
        <html:errors property="startNo"/>
        <html:text property="startNo" styleId="startNo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysSequenceForm.suffix"/>
        <html:errors property="suffix"/>
        <html:text property="suffix" styleId="suffix" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('SysSequence')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("sysSequenceForm"));
</script>

<html:javascript formName="sysSequenceForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
