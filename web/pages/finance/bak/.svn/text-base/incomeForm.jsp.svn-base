<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="incomeDetail.title"/></title>
<content tag="heading"><fmt:message key="incomeDetail.heading"/></content>

<html:form action="saveIncome" method="post" styleId="incomeForm" onsubmit="return validateIncomeForm(this)">

<html:hidden property="id"/>

<ul>


    <li>
        <adrm_order:label styleClass="desc" key="incomeForm.customerId"/>
        <html:errors property="customerId"/>
        <div style="position:relative;">
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  		<adrm_order:selectList name="customers" key="8"  toScope="page"/> 
		                          <html:select property="customerId" styleId="customerId"  style="width:180px;margin-left:-100px" onchange="this.parentNode.nextSibling.value=this.value"> 
		                          <html:option value=""/> <html:options collection="customers"  property="value" labelProperty="label"/> 
		                          </html:select> 								
				</span><input name="customerName" style="width:100px;position:absolute;left:0px;"> 
		</div>          
        

    </li>



    <li>
        <adrm_order:label styleClass="desc" key="incomeForm.incomeCode"/>
        <html:errors property="incomeCode"/>
        <html:text property="incomeCode" styleId="incomeCode" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="incomeForm.incomeDate"/>
        <html:errors property="incomeDate"/>
        
        <html:text property="incomeDate" styleId="incomeDate"  readonly="true" onclick="button_showdate('incomeDate','anchorCsignDate')"/> 
		<span id="anchorCsignDate" name="anchorCsignDate"></span>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="incomeForm.incomeModeId"/>
        <html:errors property="incomeModeId"/>
  		<adrm_order:selectList name="selects" key="17" toScope="page"/> 
                     <html:select property="incomeModeId" styleId="incomeModeId" styleClass="select"> 
                     <html:option value=""/> <html:options collection="selects" property="value" labelProperty="label"/> 
        </html:select>
   
                

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="incomeForm.incomeMoney"/>
        <html:errors property="incomeMoney"/>
        <html:text property="incomeMoney" styleId="incomeMoney" styleClass="text medium"/>

                
    </li>

    <li>
        <adrm_order:label styleClass="desc" key="incomeForm.incomePurposeId"/>
        <html:errors property="incomePurposeId"/>   
 		<adrm_order:selectList name="selects" key="18" toScope="page"/> 
                     <html:select property="incomePurposeId" styleId="incomePurposeId" styleClass="select"> 
                     <html:option value=""/> <html:options collection="selects" property="value" labelProperty="label"/> 
         </html:select>
       

    </li>




<html:hidden property="version"/>


    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('Income')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("incomeForm"));
</script>

<html:javascript formName="incomeForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
