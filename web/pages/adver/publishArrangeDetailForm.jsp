<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="publishArrangeDetailDetail.title"/></title>
<content tag="heading"><fmt:message key="publishArrangeDetailDetail.heading"/></content>

<html:form action="savePublishArrangeDetail" method="post" styleId="publishArrangeDetailForm" onsubmit="return validatePublishArrangeDetailForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeDetailForm.adverTimes"/>
        <html:errors property="adverTimes"/>
        <html:text property="adverTimes" styleId="adverTimes" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeDetailForm.contractId"/>
        <html:errors property="contractId"/>
        <html:text property="contractId" styleId="contractId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeDetailForm.customerId"/>
        <html:errors property="customerId"/>
        <html:text property="customerId" styleId="customerId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeDetailForm.customerName"/>
        <html:errors property="customerName"/>
        <html:text property="customerName" styleId="customerName" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeDetailForm.matterEdit"/>
        <html:errors property="matterEdit"/>
        <html:text property="matterEdit" styleId="matterEdit" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeDetailForm.matterId"/>
        <html:errors property="matterId"/>
        <html:text property="matterId" styleId="matterId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeDetailForm.matterLength"/>
        <html:errors property="matterLength"/>
        <html:text property="matterLength" styleId="matterLength" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeDetailForm.matterName"/>
        <html:errors property="matterName"/>
        <html:text property="matterName" styleId="matterName" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeDetailForm.orderDayId"/>
        <html:errors property="orderDayId"/>
        <html:text property="orderDayId" styleId="orderDayId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeDetailForm.orderDetailId"/>
        <html:errors property="orderDetailId"/>
        <html:text property="orderDetailId" styleId="orderDetailId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeDetailForm.orderId"/>
        <html:errors property="orderId"/>
        <html:text property="orderId" styleId="orderId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeDetailForm.ownerUserId"/>
        <html:errors property="ownerUserId"/>
        <html:text property="ownerUserId" styleId="ownerUserId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeDetailForm.ownerUserName"/>
        <html:errors property="ownerUserName"/>
        <html:text property="ownerUserName" styleId="ownerUserName" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeDetailForm.publishArrangeId"/>
        <html:errors property="publishArrangeId"/>
        <html:text property="publishArrangeId" styleId="publishArrangeId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeDetailForm.publishMemo"/>
        <html:errors property="publishMemo"/>
        <html:text property="publishMemo" styleId="publishMemo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeDetailForm.publishSort"/>
        <html:errors property="publishSort"/>
        <html:text property="publishSort" styleId="publishSort" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeDetailForm.specificName"/>
        <html:errors property="specificName"/>
        <html:text property="specificName" styleId="specificName" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeDetailForm.specificValue"/>
        <html:errors property="specificValue"/>
        <html:text property="specificValue" styleId="specificValue" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeDetailForm.tapeCode"/>
        <html:errors property="tapeCode"/>
        <html:text property="tapeCode" styleId="tapeCode" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('PublishArrangeDetail')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("publishArrangeDetailForm"));
</script>

<html:javascript formName="publishArrangeDetailForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
