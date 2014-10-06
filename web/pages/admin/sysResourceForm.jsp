<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="sysResourceDetail.title"/></title>
<content tag="heading"><fmt:message key="sysResourceDetail.heading"/></content>

<html:form action="saveSysResource" method="post" styleId="sysResourceForm" onsubmit="return validateSysResourceForm(this)">
<html:hidden property="id"/>

<ul>


    <li>
        <adrm_order:label styleClass="desc" key="sysResourceForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>
    
     <li>
        <adrm_order:label styleClass="desc" key="sysResourceForm.resType"/>
        <html:errors property="resType"/>
		 <select name="resType" ="resType">
		  <option selected value="URL">URL</option>
		  <option value="METHOD">METHOD</option>
		  <option value="TAG">TAG</option>
		</select>       
        

    </li>   

    <li>
        <adrm_order:label styleClass="desc" key="sysResourceForm.authorized"/>
        <html:errors property="authorized"/>
        <html:text property="authorized" styleId="authorized" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysResourceForm.resString"/>
        <html:errors property="resString"/>
        <html:text property="resString" styleId="resString" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysResourceForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>



<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('SysResource')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("sysResourceForm"));
</script>

<html:javascript formName="sysResourceForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
