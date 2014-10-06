<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="brandDetail.title"/></title>
<content tag="heading"><fmt:message key="brandDetail.heading"/></content>

<html:form action="saveBrand" method="post" styleId="brandForm" onsubmit="return validateBrandForm(this)">

<html:hidden property="id"/>
<html:hidden property="version"/>

<ul>

    <li>
        <adrm_order:label styleClass="desc" key="brandForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>


    <li>
        <adrm_order:label styleClass="desc" key="brandForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="brandForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

  
    <li>
        <adrm_order:label styleClass="desc" key="brandForm.enable"/>
        <html:errors property="enable"/>
        <html:checkbox property="enable"/>

    </li>




    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('Brand')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("brandForm"));
</script>

<html:javascript formName="brandForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
