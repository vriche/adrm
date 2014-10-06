<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="feedbackInfoDetail.title"/></title>
<content tag="heading"><fmt:message key="feedbackInfoDetail.heading"/></content>

<html:form action="saveFeedbackInfo" method="post" styleId="feedbackInfoForm" onsubmit="return validateFeedbackInfoForm(this)">
<html:hidden property="id"/>
<html:hidden property="version"/>

<table width="75%">
  <tr> 
    <td>
	<ul>
	
    <li>
        <adrm_order:label styleClass="desc" key="feedbackInfoForm.customerId"/>

        <div style="position:relative;">
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  		<adrm_order:selectList name="customers" key="8"  toScope="page"/> 
		                          <html:select property="customerId" styleId="customerId"  style="width:140px;margin-left:-100px"> 
		                          <html:option value=""/> <html:options collection="customers"  property="value" labelProperty="label"/> 
		         </html:select> 								
		</span></div>        
        

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="feedbackInfoForm.dealDate"/>
        <html:errors property="dealDate"/>

       <html:text property="dealDate" styleId="dealDate"  readonly="true" onclick="button_showdate('dealDate','anchorCsignDate')"/> 
		<span id="anchorCsignDate" name="anchorCsignDate"></span>

    </li>



    <li>
        <adrm_order:label styleClass="desc" key="feedbackInfoForm.feedContent"/>
        <html:errors property="feedContent"/>
 		<html:textarea property="feedContent" cols="50%" rows="3"></html:textarea>
 
    </li>

		</ul>
	</td>
	
    <td>

	</td>
  </tr>
  <tr> 
    <td colspan="2">
        <html:submit styleClass="" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('FeedbackInfo')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
	</td>
  </tr>
</table>



</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("feedbackInfoForm"));
</script>

<html:javascript formName="feedbackInfoForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
