<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaDocumentFileDetail.title"/></title>
<content tag="heading"><fmt:message key="oaDocumentFileDetail.heading"/></content>

<html:form action="saveOaDocumentFile" method="post" styleId="oaDocumentFileForm" onsubmit="return validateOaDocumentFileForm(this)">

<html:hidden property="id"/>
<html:hidden property="version"/>

<ul>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
   <tr> 
   <td width="50%">	    

	<table width="20%" border="0" cellspacing="0" cellpadding="0">
	<tbody>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaDocumentFileForm.fileName"/>:       	
	        </td>
	        <td>
		        <html:errors property="fileName"/>
		        <html:text property="fileName" styleId="fileName"/>
			</td>
		</tr>
		
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaDocumentFileForm.documentCatalogId"/>:       	
	        </td>
	        <td>
		        <html:errors property="documentCatalogId"/>
		        <html:text property="documentCatalogId" styleId="documentCatalogId"/>
			</td>
		</tr>
		
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaDocumentFileForm.picName"/>:       	
	        </td>
	        <td>
		        <html:errors property="picName"/>
		        <html:text property="picName" styleId="picName"/>
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
		
		        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('OaDocumentFile')">
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
    Form.focusFirstElement($("oaDocumentFileForm"));
</script>

<html:javascript formName="oaDocumentFileForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
