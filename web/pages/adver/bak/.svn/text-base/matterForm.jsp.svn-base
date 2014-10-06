<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="matterDetail.title"/></title>
<content tag="heading"><fmt:message key="matterDetail.heading"/></content>

<html:form action="saveMatter" method="post" styleId="matterForm" onsubmit="return validateMatterForm(this)">

<html:hidden property="id"/>
<html:hidden property="version"/>


<ul>



    <li>
        <adrm_order:label styleClass="desc" key="matterForm.customerId"/>
        <div style="position:relative;">
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  		<adrm_order:selectList name="customers" key="8"  toScope="page"/> 
		                          <html:select property="customerId" styleId="customerId"  style="width:180px;margin-left:-100px"> 
		                          <html:option value=""/> <html:options collection="customers"  property="value" labelProperty="label"/> 
		         </html:select> 								
		</span></div>       
    </li>
    
    <li>
        <adrm_order:label styleClass="desc" key="matterForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>
    </li>
    
    <li>
        <adrm_order:label styleClass="desc" key="matterForm.edit"/>
        <html:errors property="edit"/>
        <html:text property="edit" styleId="edit" styleClass="text medium"/>
    </li>

    <li>
        <adrm_order:label styleClass="desc" key="matterForm.length"/>
        <html:errors property="length"/>
        <html:text property="length" styleId="length" styleClass="text medium"/>
    </li>

    <li>
        <adrm_order:label styleClass="desc" key="matterForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>
    </li>


    <li>
        <adrm_order:label styleClass="desc" key="matterForm.tapeCode"/>
        <html:errors property="tapeCode"/>
        <html:text property="tapeCode" styleId="tapeCode" styleClass="text medium"/>
    </li>
    
 
    <li>
        <adrm_order:label styleClass="desc" key="matterForm.enable"/>
        <html:errors property="enable"/>
        <html:checkbox property="enable"/>

    </li>   
    

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('Matter')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("matterForm"));
</script>

<html:javascript formName="matterForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
