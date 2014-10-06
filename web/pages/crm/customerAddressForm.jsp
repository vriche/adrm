<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="customerAddressDetail.title"/></title>
<content tag="heading"><fmt:message key="customerAddressDetail.heading"/></content>

<html:form action="saveCustomerAddress" method="post" styleId="customerAddressForm" onsubmit="return validateCustomerAddressForm(this)">
<ul>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="customerAddressForm.customerId"/>
        <html:errors property="customerId"/>
        <html:text property="customerId" styleId="customerId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="customerAddressForm.addresType"/>
        <html:errors property="addressType"/>
        <html:text property="addressType" styleId="addressType" styleClass="text medium"/>

    </li>

 	<li>
        <adrm_order:label styleClass="desc" key="customerAddressForm.address"/>
        <html:errors property="address"/>
        <html:text property="address" styleId="address" styleClass="text medium"/>

    </li>   
   <li>
        <adrm_order:label styleClass="desc" key="customerAddressForm.city"/>
        <html:errors property="city"/>
        <html:text property="city" styleId="city" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="customerAddressForm.country"/>
        <html:errors property="country"/>
        <html:text property="country" styleId="country" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="customerAddressForm.postalCode"/>
        <html:errors property="postalCode"/>
        <html:text property="postalCode" styleId="postalCode" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="customerAddressForm.province"/>
        <html:errors property="province"/>
        <html:text property="province" styleId="province" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="customerAddressForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="customerAddressForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="customerAddressForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="customerAddressForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>    
<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('CustomerAddress')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("customerAddressForm"));
</script>

<html:javascript formName="customerAddressForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
