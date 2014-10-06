<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaScratchpadDetail.title"/></title>
<content tag="heading"><fmt:message key="oaScratchpadDetail.heading"/></content>

<html:form action="saveOaScratchpad" method="post" styleId="oaScratchpadForm" onsubmit="return validateOaScratchpadForm(this)">
<ul>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
   <tr> 
   <td width="50%">	

	<table width="20%" border="0" cellspacing="0" cellpadding="0">
	<tbody>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="oaScratchpadForm.content"/>:       	
			</td>
			<td>
		        <html:errors property="content"/>
		        <html:text property="content" styleId="content"/>
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
			
			        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('OaScratchpad')">
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
    Form.focusFirstElement($("oaScratchpadForm"));
</script>

<html:javascript formName="oaScratchpadForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
