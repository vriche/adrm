<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaCalendarEventDetail.title"/></title>
<content tag="heading"><fmt:message key="oaCalendarEventDetail.heading"/></content>

<html:form action="saveOaCalendarEvent" method="post" styleId="oaCalendarEventForm" onsubmit="return validateOaCalendarEventForm(this)">
<ul>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
   <tr> 
   <td width="50%">	

	<table width="20%" border="0" cellspacing="0" cellpadding="0">
	<tbody>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="oaCalendarEventForm.title"/>:       	
			</td>
			<td>
		        <html:errors property="title"/>
		        <html:text property="title" styleId="title"/>
			</td>
		</tr>
		
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="oaCalendarEventForm.content"/>:       	
			</td>
			<td>
		        <html:errors property="content"/>
		        <html:text property="content" styleId="content"/>
			</td>
		</tr>
		
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="oaCalendarEventForm.eventStateId"/>:       	
			</td>
			<td>
		        <html:errors property="eventStateId"/>
		        <html:text property="eventStateId" styleId="eventStateId"/>
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
			
			        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('OaCalendarEvent')">
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
    Form.focusFirstElement($("oaCalendarEventForm"));
</script>

<html:javascript formName="oaCalendarEventForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
