<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="publishedInfoDetail.title"/></title>
<content tag="heading"><fmt:message key="publishedInfoDetail.heading"/></content>

<html:form action="savePublishedInfo" method="post" styleId="publishedInfoForm" onsubmit="return validatePublishedInfoForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="publishedInfoForm.adResourceId"/>
        <html:errors property="adResourceId"/>
        <html:text property="adResourceId" styleId="adResourceId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishedInfoForm.adResourceWorkspanId"/>
        <html:errors property="adResourceWorkspanId"/>
        <html:text property="adResourceWorkspanId" styleId="adResourceWorkspanId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishedInfoForm.adverMatterId"/>
        <html:errors property="adverMatterId"/>
        <html:text property="adverMatterId" styleId="adverMatterId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishedInfoForm.appPosition"/>
        <html:errors property="appPosition"/>
        <html:text property="appPosition" styleId="appPosition" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishedInfoForm.contractId"/>
        <html:errors property="contractId"/>
        <html:text property="contractId" styleId="contractId" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="publishedInfoForm.linkUser"/>
        <html:errors property="linkUser"/>
        <html:text property="linkUser" styleId="linkUser" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishedInfoForm.matterEdit"/>
        <html:errors property="matterEdit"/>
        <html:text property="matterEdit" styleId="matterEdit" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishedInfoForm.matterLength"/>
        <html:errors property="matterLength"/>
        <html:text property="matterLength" styleId="matterLength" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishedInfoForm.matterName"/>
        <html:errors property="matterName"/>
        <html:text property="matterName" styleId="matterName" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishedInfoForm.orderId"/>
        <html:errors property="orderId"/>
        <html:text property="orderId" styleId="orderId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishedInfoForm.position"/>
        <html:errors property="position"/>
        <html:text property="position" styleId="position" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishedInfoForm.positionDes"/>
        <html:errors property="positionDes"/>
        <html:text property="positionDes" styleId="positionDes" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishedInfoForm.proResourceMemo"/>
        <html:errors property="proResourceMemo"/>
        <html:text property="proResourceMemo" styleId="proResourceMemo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishedInfoForm.publishDate"/>
        <html:errors property="publishDate"/>
        <html:text property="publishDate" styleId="publishDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishedInfoForm.publishMemo"/>
        <html:errors property="publishMemo"/>
        <html:text property="publishMemo" styleId="publishMemo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishedInfoForm.publishOrder"/>
        <html:errors property="publishOrder"/>
        <html:text property="publishOrder" styleId="publishOrder" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishedInfoForm.resourceCarrier"/>
        <html:errors property="resourceCarrier"/>
        <html:text property="resourceCarrier" styleId="resourceCarrier" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishedInfoForm.tapeCode"/>
        <html:errors property="tapeCode"/>
        <html:text property="tapeCode" styleId="tapeCode" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('PublishedInfo')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("publishedInfoForm"));
</script>

<html:javascript formName="publishedInfoForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
