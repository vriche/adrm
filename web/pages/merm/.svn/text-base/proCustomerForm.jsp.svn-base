<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="proCustomerDetail.title"/></title>
<content tag="heading"><fmt:message key="proCustomerDetail.heading"/></content>

<html:form action="saveProCustomer" method="post" styleId="proCustomerForm" onsubmit="return validateProCustomerForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="proCustomerForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proCustomerForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="proCustomerForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proCustomerForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proCustomerForm.customerName"/>
        <html:errors property="customerName"/>
        <html:text property="customerName" styleId="customerName" styleClass="text medium"/>

    </li>


    <li>
        <adrm_order:label styleClass="desc" key="proCustomerForm.typeId"/>
        <html:errors property="typeId"/>
        <html:text property="typeId" styleId="typeId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proCustomerForm.accountAddress"/>
        <html:errors property="accountAddress"/>
        <html:text property="accountAddress" styleId="accountAddress" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proCustomerForm.fax"/>
        <html:errors property="fax"/>
        <html:text property="fax" styleId="fax" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proCustomerForm.helpCode"/>
        <html:errors property="helpCode"/>
        <html:text property="helpCode" styleId="helpCode" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proCustomerForm.linkmanName"/>
        <html:errors property="linkmanName"/>
        <html:text property="linkmanName" styleId="linkmanName" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proCustomerForm.telephone"/>
        <html:errors property="telephone"/>
        <html:text property="telephone" styleId="telephone" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('ProCustomer')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("proCustomerForm"));
</script>

<!-- html:javascript formName="proCustomerForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/ -->
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
