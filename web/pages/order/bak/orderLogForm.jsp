<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="orderLogDetail.title"/></title>
<content tag="heading"><fmt:message key="orderLogDetail.heading"/></content>

<html:form action="saveOrderLog" method="post" styleId="orderLogForm" onsubmit="return validateOrderLogForm(this)">
<ul>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="orderLogForm.logForm.clientIp"/>
        <html:errors property="logForm.clientIp"/>
        <html:text property="logForm.clientIp" styleId="logForm.clientIp" styleClass="text medium"/>

    </li>
    
        <li>
        <adrm_order:label styleClass="desc" key="orderLogForm.orderId"/>
        <html:errors property="logForm.orderId"/>
        <html:text property="orderId" styleId="orderId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderLogForm.logForm.linkPath"/>
        <html:errors property="logForm.linkPath"/>
        <html:text property="logForm.linkPath" styleId="logForm.linkPath" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderLogForm.logForm.modifyBy"/>
        <html:errors property="logForm.modifyBy"/>
        <html:text property="logForm.modifyBy" styleId="logForm.modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderLogForm.logForm.modifyDate"/>
        <html:errors property="logForm.modifyDate"/>
        <html:text property="logForm.modifyDate" styleId="logForm.modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderLogForm.logForm.operateModel"/>
        <html:errors property="logForm.operateModel"/>
        <html:text property="logForm.operateModel" styleId="logForm.operateModel" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderLogForm.logForm.operateModelFunction"/>
        <html:errors property="logForm.operateModelFunction"/>
        <html:text property="logForm.operateModelFunction" styleId="logForm.operateModelFunction" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderLogForm.logForm.operateType"/>
        <html:errors property="logForm.operateType"/>
        <html:text property="logForm.operateType" styleId="logForm.operateType" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('OrderLog')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("orderLogForm"));
</script>

<html:javascript formName="orderLogForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
