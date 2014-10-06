<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaBusinessCardDetail.title"/></title>
<content tag="heading"><fmt:message key="oaBusinessCardDetail.heading"/></content>

<html:form action="saveOaBusinessCard" method="post" styleId="oaBusinessCardForm" onsubmit="return validateOaBusinessCardForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="oaBusinessCardForm.birthdayDate"/>
        <html:errors property="birthdayDate"/>
        <html:text property="birthdayDate" styleId="birthdayDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaBusinessCardForm.birthdayMonth"/>
        <html:errors property="birthdayMonth"/>
        <html:text property="birthdayMonth" styleId="birthdayMonth" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaBusinessCardForm.birthdayYear"/>
        <html:errors property="birthdayYear"/>
        <html:text property="birthdayYear" styleId="birthdayYear" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaBusinessCardForm.businessCardTypId"/>
        <html:errors property="businessCardTypId"/>
        <html:text property="businessCardTypId" styleId="businessCardTypId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaBusinessCardForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaBusinessCardForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaBusinessCardForm.firstName"/>
        <html:errors property="firstName"/>
        <html:text property="firstName" styleId="firstName" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaBusinessCardForm.fullName"/>
        <html:errors property="fullName"/>
        <html:text property="fullName" styleId="fullName" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaBusinessCardForm.headship"/>
        <html:errors property="headship"/>
        <html:text property="headship" styleId="headship" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaBusinessCardForm.lastName"/>
        <html:errors property="lastName"/>
        <html:text property="lastName" styleId="lastName" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaBusinessCardForm.mob"/>
        <html:errors property="mob"/>
        <html:text property="mob" styleId="mob" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaBusinessCardForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaBusinessCardForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaBusinessCardForm.oaBusinessCardType"/>
        <html:errors property="oaBusinessCardType"/>
        <html:text property="oaBusinessCardType" styleId="oaBusinessCardType" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaBusinessCardForm.sex"/>
        <html:errors property="sex"/>
        <html:text property="sex" styleId="sex" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaBusinessCardForm.tel1"/>
        <html:errors property="tel1"/>
        <html:text property="tel1" styleId="tel1" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaBusinessCardForm.tel2"/>
        <html:errors property="tel2"/>
        <html:text property="tel2" styleId="tel2" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaBusinessCardForm.tel3"/>
        <html:errors property="tel3"/>
        <html:text property="tel3" styleId="tel3" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaBusinessCardForm.work"/>
        <html:errors property="work"/>
        <html:text property="work" styleId="work" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('OaBusinessCard')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("oaBusinessCardForm"));
</script>

<html:javascript formName="oaBusinessCardForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
