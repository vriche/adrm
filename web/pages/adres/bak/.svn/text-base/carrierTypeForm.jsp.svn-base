<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="carrierTypeDetail.title"/></title>
<content tag="heading"><fmt:message key="carrierTypeDetail.heading"/></content>

<html:form action="saveCarrierType" method="post" styleId="carrierTypeForm" onsubmit="return validateCarrierTypeForm(this)">
<ul>

    <li>
        <adrm_adres:label styleClass="desc" key="carrierTypeForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_adres:label styleClass="desc" key="carrierTypeForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_adres:label styleClass="desc" key="carrierTypeForm.displayNo"/>
        <html:errors property="displayNo"/>
        <html:text property="displayNo" styleId="displayNo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_adres:label styleClass="desc" key="carrierTypeForm.enable"/>
        <html:errors property="enable"/>
        <html:text property="enable" styleId="enable" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_adres:label styleClass="desc" key="carrierTypeForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_adres:label styleClass="desc" key="carrierTypeForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_adres:label styleClass="desc" key="carrierTypeForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_adres:label styleClass="desc" key="carrierTypeForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>

    <li>
        <adrm_adres:label styleClass="desc" key="carrierTypeForm.nodeLevel"/>
        <html:errors property="nodeLevel"/>
        <html:text property="nodeLevel" styleId="nodeLevel" styleClass="text medium"/>

    </li>

    <li>
        <adrm_adres:label styleClass="desc" key="carrierTypeForm.nodePath"/>
        <html:errors property="nodePath"/>
        <html:text property="nodePath" styleId="nodePath" styleClass="text medium"/>

    </li>

    <li>
        <adrm_adres:label styleClass="desc" key="carrierTypeForm.parentId"/>
        <html:errors property="parentId"/>
        <html:text property="parentId" styleId="parentId" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('CarrierType')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("carrierTypeForm"));
</script>

<html:javascript formName="carrierTypeForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
