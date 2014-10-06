<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="publishArrangeDetail.title"/></title>
<content tag="heading"><fmt:message key="publishArrangeDetail.heading"/></content>

<html:form action="savePublishArrange" method="post" styleId="publishArrangeForm" onsubmit="return validatePublishArrangeForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeForm.carrierId"/>
        <html:errors property="carrierId"/>
        <html:text property="carrierId" styleId="carrierId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeForm.carrierName"/>
        <html:errors property="carrierName"/>
        <html:text property="carrierName" styleId="carrierName" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeForm.filePath"/>
        <html:errors property="filePath"/>
        <html:text property="filePath" styleId="filePath" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeForm.isEnable"/>
        <html:errors property="isEnable"/>
        <html:checkbox property="isEnable" styleId="isEnable" styleClass="checkbox"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeForm.isLocked"/>
        <html:errors property="isLocked"/>
        <html:checkbox property="isLocked" styleId="isLocked" styleClass="checkbox"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeForm.publishDate"/>
        <html:errors property="publishDate"/>
        <html:text property="publishDate" styleId="publishDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeForm.resourceId"/>
        <html:errors property="resourceId"/>
        <html:text property="resourceId" styleId="resourceId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeForm.resourceMeno"/>
        <html:errors property="resourceMeno"/>
        <html:text property="resourceMeno" styleId="resourceMeno" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeForm.resourceName"/>
        <html:errors property="resourceName"/>
        <html:text property="resourceName" styleId="resourceName" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeForm.resourceTotalTimes"/>
        <html:errors property="resourceTotalTimes"/>
        <html:text property="resourceTotalTimes" styleId="resourceTotalTimes" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="publishArrangeForm.resourceUsedTimes"/>
        <html:errors property="resourceUsedTimes"/>
        <html:text property="resourceUsedTimes" styleId="resourceUsedTimes" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>



    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('PublishArrange')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("publishArrangeForm"));
</script>

<html:javascript formName="publishArrangeForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
