<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="carrierDetail.title"/></title>
<content tag="heading"><fmt:message key="carrierDetail.heading"/></content>

<html:form action="saveCarrier" method="post" styleId="carrierForm" onsubmit="return validateCarrierForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="carrierForm.enable"/>
        <html:errors property="enable"/>
        <html:text property="enable" styleId="enable" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="carrierForm.aliasName"/>
        <html:errors property="aliasName"/>
        <html:text property="aliasName" styleId="aliasName" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="carrierForm.carrierName"/>
        <html:errors property="carrierName"/>
        <html:text property="carrierName" styleId="carrierName" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="carrierForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="carrierForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="carrierForm.displayNo"/>
        <html:errors property="displayNo"/>
        <html:text property="displayNo" styleId="displayNo" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="carrierForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="carrierForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="carrierForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="carrierForm.nodeLevel"/>
        <html:errors property="nodeLevel"/>
        <html:text property="nodeLevel" styleId="nodeLevel" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="carrierForm.nodePath"/>
        <html:errors property="nodePath"/>
        <html:text property="nodePath" styleId="nodePath" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="carrierForm.parentId"/>
        <html:errors property="parentId"/>
        <html:text property="parentId" styleId="parentId" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('Carrier')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("carrierForm"));
</script>

<html:javascript formName="carrierForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
