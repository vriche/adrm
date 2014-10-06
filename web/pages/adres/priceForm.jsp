<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="priceDetail.title"/></title>
<content tag="heading"><fmt:message key="priceDetail.heading"/></content>

<html:form action="savePrice" method="post" styleId="priceForm" onsubmit="return validatePriceForm(this)">

<html:hidden property="id"/>
<html:hidden property="version"/>

<ul>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
   <tr> 
   <td width="50%">	

	<table width="20%" border="0" cellspacing="0" cellpadding="0">
	<tbody>

		<tr> 
			<td nowrap="nowrap" class="requiredInput">
				<fmt:message key="priceForm.name"/>:     	
			</td>
			<td>
		        <html:errors property="name"/>
		        <html:text property="name" styleId="name"/>
			</td>
		</tr>
		
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="priceForm.createBy"/>:       	
			</td>
			<td>
		        <html:errors property="createBy"/>
		        <html:text property="createBy" styleId="createBy"/>
			</td>
		</tr>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="priceForm.createDate"/>:       	
			</td>
			<td>
		        <html:errors property="createDate"/>
		        <html:text property="createDate" styleId="createDate"/>
			</td>
		</tr>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="priceForm.isDefault"/>:       	
			</td>
			<td>
		        <html:errors property="isDefault"/>
		        <html:text property="isDefault" styleId="isDefault"/>
			</td>
		</tr>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="priceForm.isUseRegular"/>:       	
			</td>
			<td>
		        <html:errors property="isUseRegular"/>
		        <html:text property="isUseRegular" styleId="isUseRegular"/>
			</td>
		</tr>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="priceForm.meno"/>:       	
			</td>
			<td>
		        <html:errors property="memo"/>
		        <html:text property="memo" styleId="meno"/>
			</td>
		</tr>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="priceForm.modifyBy"/>:       	
			</td>
			<td>
		        <html:errors property="modifyBy"/>
		        <html:text property="modifyBy" styleId="modifyBy"/>
			</td>
		</tr>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="priceForm.modifyDate"/>:       	
			</td>
			<td>
		        <html:errors property="modifyDate"/>
		        <html:text property="modifyDate" styleId="modifyDate"/>
			</td>
		</tr>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="priceForm.moneyType"/>:       	
			</td>
			<td>
		        <html:errors property="moneyType"/>
		        <html:text property="moneyType" styleId="moneyType"/>
			</td>
		</tr>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="priceForm.resourcePriceType"/>:       	
			</td>
			<td>
		        <html:errors property="resourcePriceType"/>
		        <html:text property="resourcePriceType" styleId="resourcePriceType"/>
			</td>
		</tr>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="priceForm.resourceType"/>:       	
			</td>
			<td>
		        <html:errors property="resourceType"/>
		        <html:text property="resourceType" styleId="resourceType"/>
			</td>
		</tr>
	</tbody>
 </table>
 </td></tr>
 </table>
    
&nbsp;&nbsp;


<table width="26%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		  	<td>
		  		<div align="center">
			        <html:submit styleClass="" property="method.save" onclick="bCancel=false">
			            <fmt:message key="button.save"/>
			        </html:submit>
			
			        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('Price')">
			            <fmt:message key="button.delete"/>
			        </html:submit>
			
			        <html:cancel styleClass="" onclick="bCancel=true">
			            <fmt:message key="button.cancel"/>
			        </html:cancel>
			      </div>
			 </td>
		 </tr>
</table>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("priceForm"));
</script>

<html:javascript formName="priceForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
