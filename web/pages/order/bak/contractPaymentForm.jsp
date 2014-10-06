<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="contractPaymentDetail.title"/></title>
<content tag="heading"><fmt:message key="contractPaymentDetail.heading"/></content>

<html:form action="saveContractPayment" method="post" styleId="contractPaymentForm" onsubmit="return validateContractPaymentForm(this)">

<fieldset style="width:50%">
<legend><!-- 基本信息 --><fmt:message key="contractForm.baseInfo"/></legend>
<table width="100%" border="0">
  <tr> 
    <td width="50%"><table width="100%" border="0">
	
        <tr> 
          <td nowrap="nowrap" class="dataLabel"> <adrm_order:label styleClass="" key="contractPaymentForm.payNumber"/> :
            <html:errors property="payNumber"/></td>
          <td> <html:text property="payNumber" styleId="payNumber" styleClass="text medium"/> 
          </td>
        </tr>
		
		<tr>
          <td nowrap="nowrap" class="dataLabel">
				   <adrm_order:label styleClass="" key="contractPaymentForm.incomeModeId"/>:
				  <html:errors property="incomeModeId"/>
		</td>
          <td>
		  			<html:text property="incomeModeId" styleId="incomeModeId" styleClass="text medium"/>
		  </td>
        </tr>
		
		  <tr>
          <td nowrap="nowrap" class="dataLabel">
				  <adrm_order:label styleClass="" key="contractPaymentForm.payDate"/>:
				  <html:errors property="payDate"/>
		  </td>
          <td>
		  		 <html:text property="payDate" styleId="payDate" styleClass="text medium"/>
		   </td>
        </tr>
		

		<tr>
          <td nowrap="nowrap" class="dataLabel">
		  <adrm_order:label styleClass="" key="contractPaymentForm.moneyIn"/>:
        <html:errors property="moneyIn"/></td>
          <td>
		   <html:text property="moneyIn" styleId="moneyIn" styleClass="text medium"/>
		  </td>
        </tr>
		
		
		<tr>
          <td nowrap="nowrap" class="dataLabel">
				<adrm_order:label styleClass="" key="contractPaymentForm.moneyIn"/>:
				<html:errors property="moneyIn"/>
		</td>
          <td>
		  		<html:text property="moneyIn" styleId="moneyIn" styleClass="text medium"/>
		</td>
        </tr>

		
      </table></td>
    <td>
    </td>
  </tr>
</table>

<br>


<ul>
    <li class="buttonBar bottom">
        <html:submit styleClass="" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('ContractPayment')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <input type="button" class="" value="<fmt:message key="button.cancel"/>" onclick="javascript:history.go(-1)"/>
    </li>
</ul>

</fieldset>

<table width="100%" border="0"  style="display:none;">
        <tr>
          <td>
		      <li>
        <adrm_order:label styleClass="" key="contractPaymentForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>



    <li>
        <adrm_order:label styleClass="" key="contractPaymentForm.orderId"/>
        <html:errors property="orderId"/>
        <html:text property="orderId" styleId="orderId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="" key="contractPaymentForm.urgencyAlert"/>
        <html:errors property="urgencyAlert"/>
        <html:checkbox property="urgencyAlert" styleId="urgencyAlert"/>

    </li>
		  </td>
        </tr>
        <tr> 
          <td>
          
           id:<html:text property="id"/><br>
          
           version:<html:hidden property="version"/> <br>
           
           param.method: <c:out value="${param.method}"/> <adrm_order:label styleClass="" key="contractPaymentForm.contractId"/> <br>
            
            <br>
            <c:choose> <c:when test="${param.method != 'edit'}"> 
          	  	 <input type="text" name="contractId" Class="text medium" value='<c:out value="${param.contractId}"/>'/> <br>
            </c:when> <c:when test="${param.method == 'edit'}"> 
           		 <html:text property="contractId" styleId="contractId" styleClass="text medium"/> <br>
            </c:when> </c:choose> </td>
            
            <br>
        </tr>
      </table>


</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("contractPaymentForm"));
</script>

<html:javascript formName="contractPaymentForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>


