<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaAreaPcDetail.title"/></title>
<content tag="heading"><fmt:message key="oaAreaPcDetail.heading"/></content>

<html:form action="saveOaAreaPc" method="post" styleId="oaAreaPcForm" onsubmit="return validateOaAreaPcForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="oaAreaPcForm.areaCityId"/>
        <html:errors property="areaCityId"/>
        <html:text property="areaCityId" styleId="areaCityId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAreaPcForm.ldCode"/>
        <html:errors property="ldCode"/>
        <html:text property="ldCode" styleId="ldCode" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAreaPcForm.postCode"/>
        <html:errors property="postCode"/>
        <html:text property="postCode" styleId="postCode" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAreaPcForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAreaPcForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaAreaPcForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAreaPcForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaAreaPcForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaAreaPcForm.oaAreaCity"/>
        <html:errors property="oaAreaCity"/>
        <html:text property="oaAreaCity" styleId="oaAreaCity" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('OaAreaPc')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("oaAreaPcForm"));
</script>

<html:javascript formName="oaAreaPcForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
