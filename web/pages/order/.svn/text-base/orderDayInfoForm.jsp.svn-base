<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="orderDayInfoDetail.title"/></title>
<content tag="heading"><fmt:message key="orderDayInfoDetail.heading"/></content>

<html:form action="saveOrderDayInfo" method="post" styleId="orderDayInfoForm" onsubmit="return validateOrderDayInfoForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="orderDayInfoForm.adDayTimes"/>
        <html:errors property="adDayTimes"/>
        <html:text property="adDayTimes" styleId="adDayTimes" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderDayInfoForm.adlength"/>
        <html:errors property="adlength"/>
        <html:text property="adlength" styleId="adlength" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderDayInfoForm.dayRelIncome"/>
        <html:errors property="dayRelIncome"/>
        <html:text property="dayRelIncome" styleId="dayRelIncome" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderDayInfoForm.dayStandardPrice"/>
        <html:errors property="dayStandardPrice"/>
        <html:text property="dayStandardPrice" styleId="dayStandardPrice" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="orderDayInfoForm.isPublished"/>
        <html:errors property="isPublished"/>
        <html:text property="isPublished" styleId="isPublished" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderDayInfoForm.orderDetailId"/>
        <html:errors property="orderDetailId"/>
        <html:text property="orderDetailId" styleId="orderDetailId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderDayInfoForm.orderId"/>
        <html:errors property="orderId"/>
        <html:text property="orderId" styleId="orderId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderDayInfoForm.publishDate"/>
        <html:errors property="publishDate"/>
        <html:text property="publishDate" styleId="publishDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orderDayInfoForm.resourceSpecific"/>
        <html:errors property="resourceSpecific"/>
        <html:text property="resourceSpecific" styleId="resourceSpecific" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('OrderDayInfo')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("orderDayInfoForm"));
</script>

<html:javascript formName="orderDayInfoForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
