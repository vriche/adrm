<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaDocumentCatalogDetail.title"/></title>
<content tag="heading"><fmt:message key="oaDocumentCatalogDetail.heading"/></content>

<html:form action="saveOaDocumentCatalog" method="post" styleId="oaDocumentCatalogForm" onsubmit="return validateOaDocumentCatalogForm(this)">
<ul>


<table width="100%" border="0" cellpadding="0" cellspacing="0">
   <tr> 
   <td width="50%">	

	<table width="20%" border="0" cellspacing="0" cellpadding="0">
	<tbody>

		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="oaDocumentCatalogForm.name"/>:       	
			</td>
			<td>
		        <html:errors property="name"/>
		        <html:text property="name" styleId="name"/>
			</td>
		</tr>

     

		<tr>
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<!--目录权限类别--!>
				<adrm_order:label styleClass="" key="oaDocumentCatalogForm.permitTypeId"/>:
		    </td>
		    <td>
				<div style="position:relative;">
					<span style="margin-left:100px;width:18px;overflow:hidden;">
					  	<adrm_order:selectList name="documentCatalogPermitTypes" key="26"  toScope="page"/> 
					     <html:select property="permitTypeId" styleId="documentCatalogPermitTypeId"  style="width:140px;margin-left:-100px"> 
					     	<html:option value=""/> <html:options collection="documentCatalogPermitTypes"  property="value" labelProperty="label"/> 
					     </html:select> 								
					</span>
					 <html:errors property="permitTypeId"/>
				</div>  
			</td>
    	</tr>

		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="oaDocumentCatalogForm.displayNo"/>:       	
			</td>
			<td>
		        <html:errors property="displayNo"/>
		        <html:text property="displayNo" styleId="displayNo"/>
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
					
			        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('OaDocumentCatalog')">
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
    Form.focusFirstElement($("oaDocumentCatalogForm"));
</script>

<html:javascript formName="oaDocumentCatalogForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
