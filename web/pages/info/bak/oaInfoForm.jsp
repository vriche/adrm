<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaInfoDetail.title"/></title>
<content tag="heading"><fmt:message key="oaInfoDetail.heading"/></content>

<html:form action="saveOaInfo" method="post" styleId="oaInfoForm" onsubmit="return validateOaInfoForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="oaInfoForm.content"/>
        <html:errors property="content"/>
        <html:text property="content" styleId="content" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaInfoForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaInfoForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaInfoForm.displayTimes"/>
        <html:errors property="displayTimes"/>
        <html:text property="displayTimes" styleId="displayTimes" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="oaInfoForm.infoType"/>
        <html:errors property="infoType"/>
        <html:text property="infoType" styleId="infoType" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaInfoForm.infoTypeId"/>
        <html:errors property="infoTypeId"/>
        <html:text property="infoTypeId" styleId="infoTypeId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaInfoForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaInfoForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaInfoForm.searchKey"/>
        <html:errors property="searchKey"/>
        <html:text property="searchKey" styleId="searchKey" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaInfoForm.title"/>
        <html:errors property="title"/>
        <html:text property="title" styleId="title" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('OaInfo')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("oaInfoForm"));
</script>

<html:javascript formName="oaInfoForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
