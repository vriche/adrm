<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="proAudienceRatDetail.title"/></title>
<content tag="heading"><fmt:message key="proAudienceRatDetail.heading"/></content>

<html:form action="saveProAudienceRat" method="post" styleId="proAudienceRatForm" onsubmit="return validateProAudienceRatForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="proAudienceRatForm.audienceDate"/>
        <html:errors property="audienceDate"/>
        <html:text property="audienceDate" styleId="audienceDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proAudienceRatForm.audienceRat"/>
        <html:errors property="audienceRat"/>
        <html:text property="audienceRat" styleId="audienceRat" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="proAudienceRatForm.audienceTime"/>
        <html:errors property="audienceTime"/>
        <html:text property="audienceTime" styleId="audienceTime" styleClass="text medium"/>

    </li>



    <li>
        <adrm_order:label styleClass="desc" key="proAudienceRatForm.carrierId"/>
        <html:errors property="carrierId"/>
        <html:text property="carrierId" styleId="carrierId" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('ProAudienceRat')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("proAudienceRatForm"));
</script>

<html:javascript formName="proAudienceRatForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
