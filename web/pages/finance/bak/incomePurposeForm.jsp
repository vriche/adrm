<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="incomePurposeDetail.title"/></title>
<content tag="heading"><fmt:message key="incomePurposeDetail.heading"/></content>

<html:form action="saveIncomePurpose" method="post" styleId="incomePurposeForm" onsubmit="return validateIncomePurposeForm(this)">

<html:hidden property="id"/>
<html:hidden property="version"/>

<ul>


    <li>
        <adrm_order:label styleClass="desc" key="incomePurposeForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="incomePurposeForm.value"/>
        <html:errors property="value"/>
        <html:text property="value" styleId="value" styleClass="text medium"/>

    </li>



    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('IncomePurpose')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("incomePurposeForm"));
</script>

<html:javascript formName="incomePurposeForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
