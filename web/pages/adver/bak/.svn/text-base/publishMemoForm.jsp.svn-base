<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="publishMemoDetail.title"/></title>
<content tag="heading"><fmt:message key="publishMemoDetail.heading"/></content>

<html:form action="savePublishMemo" method="post" styleId="publishMemoForm" onsubmit="return validatePublishMemoForm(this)">
<ul>



<html:hidden property="id"/>


    <li>
        <adrm_order:label styleClass="desc" key="publishMemoForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('PublishMemo')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("publishMemoForm"));
</script>

<html:javascript formName="publishMemoForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
