<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="orgDetail.title"/></title>
<content tag="heading"><fmt:message key="orgDetail.heading"/></content>

<html:form action="saveOrg" method="post" styleId="orgForm" onsubmit="return validateOrgForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="orgForm.bankCode"/>
        <html:errors property="bankCode"/>
        <html:text property="bankCode" styleId="bankCode" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orgForm.bankName"/>
        <html:errors property="bankName"/>
        <html:text property="bankName" styleId="bankName" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orgForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orgForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orgForm.fax"/>
        <html:errors property="fax"/>
        <html:text property="fax" styleId="fax" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="orgForm.linkMan"/>
        <html:errors property="linkMan"/>
        <html:text property="linkMan" styleId="linkMan" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orgForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orgForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orgForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orgForm.tel"/>
        <html:errors property="tel"/>
        <html:text property="tel" styleId="tel" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="orgForm.addressForm.address"/>
        <html:errors property="addressForm.address"/>
        <html:text property="addressForm.address" styleId="addressForm.address" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orgForm.addressForm.city"/>
        <html:errors property="addressForm.city"/>
        <html:text property="addressForm.city" styleId="addressForm.city" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orgForm.addressForm.country"/>
        <html:errors property="addressForm.country"/>
        <html:text property="addressForm.country" styleId="addressForm.country" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orgForm.addressForm.postalCode"/>
        <html:errors property="addressForm.postalCode"/>
        <html:text property="addressForm.postalCode" styleId="addressForm.postalCode" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="orgForm.addressForm.province"/>
        <html:errors property="addressForm.province"/>
        <html:text property="addressForm.province" styleId="addressForm.province" styleClass="text medium"/>

    </li>



    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('Org')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("orgForm"));
</script>

<html:javascript formName="orgForm" cdata="false" dynamicJavascript="false" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
