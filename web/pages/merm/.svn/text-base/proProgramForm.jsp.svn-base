<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="proProgramDetail.title"/></title>
<content tag="heading"><fmt:message key="proProgramDetail.heading"/></content>

<html:form action="saveProProgram" method="post" styleId="proProgramForm" onsubmit="return validateProProgramForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="proProgramForm.customerId"/>
        <html:errors property="customerId"/>
        <html:text property="customerId" styleId="customerId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proProgramForm.copyrightNum"/>
        <html:errors property="copyrightNum"/>
        <html:text property="copyrightNum" styleId="copyrightNum" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proProgramForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proProgramForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proProgramForm.endDate"/>
        <html:errors property="endDate"/>
        <html:text property="endDate" styleId="endDate" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="proProgramForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proProgramForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proProgramForm.proName"/>
        <html:errors property="proName"/>
        <html:text property="proName" styleId="proName" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proProgramForm.startDate"/>
        <html:errors property="startDate"/>
        <html:text property="startDate" styleId="startDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proProgramForm.typeId"/>
        <html:errors property="typeId"/>
        <html:text property="typeId" styleId="typeId" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('ProProgram')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("proProgramForm"));
</script>


<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
