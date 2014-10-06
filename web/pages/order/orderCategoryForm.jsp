<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="orderCategoryDetail.title"/></title>
<content tag="heading"><fmt:message key="orderCategoryDetail.heading"/></content>

<html:form action="saveOrderCategory" method="post" styleId="orderCategoryForm" onsubmit="return validateOrderCategoryForm(this)">
<html:hidden property="id"/>
<html:hidden property="version"/>
<ul>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
   <tr> 
   <td width="50%">	    

	<table width="30%" border="0" cellspacing="0" cellpadding="0">
	<tbody>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="orderCategoryForm.calculateAuto"/>:       	
	        </td>
	        <td>
		        <html:errors property="calculateAuto"/>
		        <html:text property="calculateAuto" styleId="calculateAuto"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="orderCategoryForm.displayNo"/>:       	
	        </td>
	        <td>
		        <html:errors property="displayNo"/>
		        <html:text property="displayNo" styleId="displayNo"/>
			</td>
		</tr>
	    <tr> 
		    <td nowrap="nowrap" class="requiredInput">
		    	<fmt:message key="orderCategoryForm.name"/>:       	
	        </td>
	        <td>
		        <html:errors property="name"/>
		        <html:text property="name" styleId="name"/>
			</td>
		</tr>
  	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="orderCategoryForm.nodeLevel"/>:       	
	        </td>
	        <td>
		        <html:errors property="nodeLevel"/>
		        <html:text property="nodeLevel" styleId="nodeLevel"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="orderCategoryForm.nodePath"/>:       	
	        </td>
	        <td>
		        <html:errors property="nodePath"/>
		        <html:text property="nodePath" styleId="nodePath"/>
			</td>
		</tr>
	    <tr> 
		    <td nowrap="nowrap" class="requiredInput">
		    	<fmt:message key="orderCategoryForm.parentId"/>:       	
	        </td>
	        <td>
		        <html:errors property="parentId"/>
		        <html:text property="parentId" styleId="parentId"/>
			</td>
		</tr>
	    <tr> 
		    <td nowrap="nowrap" class="requiredInput">
		    	<fmt:message key="orderCategoryForm.value"/>:       	
	        </td>
	        <td>
		        <html:errors property="value"/>
		        <html:text property="value" styleId="value"/>
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
		        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
		            <fmt:message key="button.save"/>
		        </html:submit>
		
		        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('OrderCategory')">
		            <fmt:message key="button.delete"/>
		        </html:submit>
		
		        <html:cancel styleClass="button" onclick="bCancel=true">
		            <fmt:message key="button.cancel"/>
		        </html:cancel>
	        </div>
		 </td>
	</tr>
</table>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("orderCategoryForm"));
</script>

<html:javascript formName="orderCategoryForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
