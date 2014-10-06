<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="industryDetail.title"/></title>
<content tag="heading"><fmt:message key="industryDetail.heading"/></content>

<html:form action="saveIndustry" method="post" styleId="industryForm" onsubmit="return validateIndustryForm(this)">

<html:hidden property="id"/>
<html:hidden property="version"/>

<ul>

    <li>
        <adrm_order:label styleClass="desc" key="industryForm.code"/>
        <html:errors property="code"/>
        <html:text property="code" styleId="code" styleClass="text medium"/>

    </li>
    
    <li>
        <adrm_order:label styleClass="desc" key="industryForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>
    

    <li>
        <adrm_order:label styleClass="desc" key="industryForm.memo"/>
        <html:errors property="memo"/>
        <html:textarea property="memo" styleId="memo"  cols="70%" rows="6" />

    </li>




    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('Industry')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
        
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("industryForm"));
</script>

<html:javascript formName="industryForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
