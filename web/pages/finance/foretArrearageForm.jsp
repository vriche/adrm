<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="foretArrearageDetail.title"/></title>
<content tag="heading"><fmt:message key="foretArrearageDetail.heading"/></content>

<html:form action="saveForetArrearage" method="post" styleId="foretArrearageForm" onsubmit="return validateForetArrearageForm(this)">
<html:hidden property="id"/>

<table width="20%" border="0" cellpadding="0" cellspacing="0">
<tr>
    <td  nowrap="nowrap" class="dataLabel">
        <adrm_order:label key="foretArrearageForm.customerName"/>:
        <html:errors property="customerName"/>
        </td>
        <td>
        <html:text property="customerName" styleId="customerName"/>
    </td>
    </tr>
  
<tr>
    <td  nowrap="nowrap" class="dataLabel">
        <adrm_order:label key="foretArrearageForm.incomeCode"/>:
        <html:errors property="incomeCode"/>
        </td>
        <td>
        <html:text property="incomeCode" styleId="incomeCode" />
    </td>
</tr>
<tr>
    <td  width="30%" nowrap="nowrap" class="dataLabel">
        <adrm_order:label key="foretArrearageForm.incomeDate"/>:
        <html:errors property="incomeDate"/>
       </td>
        <td>
        <html:text property="incomeDate" styleId="incomeDate" />

    </td>
</tr>
<tr>
    <td  width="30%" nowrap="nowrap" class="dataLabel">
        <adrm_order:label key="foretArrearageForm.incomeMode"/>:
        <html:errors property="incomeMode"/>
       </td>
        <td>
        <html:text property="incomeMode" styleId="incomeMode" />

    </td>
<tr>
    <td  nowrap="nowrap" class="dataLabel">
        <adrm_order:label styleClass="dataLabel" key="foretArrearageForm.incomeMoney"/>:
        <html:errors property="incomeMoney"/>
        </td>
        <td>
        <html:text property="incomeMoney" styleId="incomeMoney" />

    </td>
</tr>
<tr>
    <td  nowrap="nowrap" class="dataLabel">
        <adrm_order:label key="foretArrearageForm.incomePurpose"/>:
        <html:errors property="incomePurpose"/>
        </td>
        <td>
        <html:text property="incomePurpose" styleId="incomePurpose" />

    </td>
</tr>
<tr>
    <td  nowrap="nowrap" class="dataLabel">
        <adrm_order:label key="foretArrearageForm.memo"/>:
        <html:errors property="memo"/>
       </td>
        <td>
        <html:text property="memo" styleId="memo" />

    </td>
</tr>
<tr>
    <td nowrap="nowrap" class="dataLabel">
        <adrm_order:label key="foretArrearageForm.payDate"/>:
        <html:errors property="payDate"/>
        </td>
        <td>
        <html:text property="payDate" styleId="payDate" />

    </td>
</tr>
<tr>
    <td nowrap="nowrap" class="dataLabel">
        <adrm_order:label styleClass="dataLabel" key="foretArrearageForm.payMoney"/>:
        <html:errors property="payMoney"/>
        </td>
        <td>
        <html:text property="payMoney" styleId="payMoney" />

    </td>
    </tr>
<tr>
    <td nowrap="nowrap" class="dataLabel">
        <adrm_order:label  key="foretArrearageForm.userName"/>:
        <html:errors property="userName"/>
        </td>
        <td>
        <html:text property="userName" styleId="userName" />

    </td>
 </tr>
 </table>
 &nbsp;&nbsp;
 
<table width="28%" border="0" cellspacing="0" cellpadding="0">
					 <tr>
						<td>
							<div align="center">
							
					             <html:hidden property="version"/>
                                 <class="buttonBar bottom">                                
                                 <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
                                 <fmt:message key="button.save"/>
                                 </html:submit>
                                 <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('ForetArrearage')">
                                 <fmt:message key="button.delete"/>
                                 </html:submit>
                                 <html:cancel styleClass="button" onclick="bCancel=true">
                                 <fmt:message key="button.cancel"/>
                                 </html:cancel>   
                                 <!--
                                 <input type="button" property="method.save" onclick="bCancel=false" value='<fmt:message key="button.save"/>'>
					             <input type="button" property="method.delete" onclick="bCancel=true; return confirmDelete('ForetArrearage')" value='<fmt:message key="button.delete"/>'>
					             <input type="button" onclick="bCancel=true" value='<fmt:message key="button.cancel"/>'>
                                 -->
					        </div>
						 </td>
					</tr>
				</table>

</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("foretArrearageForm"));
</script>

<html:javascript formName="foretArrearageForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
