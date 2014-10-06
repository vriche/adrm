<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="linkHisotryDetail.title"/></title>
<content tag="heading"><fmt:message key="linkHisotryDetail.heading"/></content>

<html:form action="saveLinkHisotry" method="post" styleId="linkHisotryForm" onsubmit="return validateLinkHisotryForm(this)">


<html:hidden property="id"/>
<html:hidden property="version"/>

<table width="75%">
  <tr> 
    <td>
	<ul>
 <li>
        <adrm_order:label styleClass="desc" key="linkHisotryForm.counterpartMan"/>
        <html:errors property="counterpartMan"/>
        <html:text property="counterpartMan" styleId="counterpartMan" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="linkHisotryForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="linkHisotryForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="linkHisotryForm.linkDate"/>
        <html:errors property="linkDate"/>
        <html:text property="linkDate" styleId="linkDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="linkHisotryForm.linkManId"/>
        <html:errors property="linkManId"/>
        <html:text property="linkManId" styleId="linkManId" styleClass="text medium"/>

    </li>
		</ul>
	</td>
    <td>
	<ul>
  <li>
        <adrm_order:label styleClass="desc" key="linkHisotryForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="linkHisotryForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="linkHisotryForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="linkHisotryForm.subject"/>
        <html:errors property="subject"/>
        <html:text property="subject" styleId="subject" styleClass="text medium"/>

    </li>	
	</ul>
	</td>
  </tr>
  <tr> 
    <td colspan="2">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('LinkHisotry')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
	</td>
  </tr>
</table>


</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("linkHisotryForm"));
</script>

<html:javascript formName="linkHisotryForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
