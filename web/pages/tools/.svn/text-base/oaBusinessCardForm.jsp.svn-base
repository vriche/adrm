<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaBusinessCardDetail.title"/></title>
<content tag="heading"><fmt:message key="oaBusinessCardDetail.heading"/></content>

<html:form action="saveOaBusinessCard" method="post" styleId="oaBusinessCardForm" onsubmit="return validateOaBusinessCardForm(this)">

<html:hidden property="version"/>
<html:hidden property="id"/>

<ul>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                    <td><span class="tile1">
                    </span>
                    </td>
                  </tr>
                </tbody>
              </table></td>
            <td width="115"><img src="images/table1/textbox_top_right.jpg" height="27"></td>
          </tr>
        </tbody>
      </table></td>
  </tr>
  <tr>
    <td><table border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td background="images/table1/textbox_left.gif" width="14"></td>
            <td bgcolor="#f4f3f4">
            
            
            
<table width="100%" border="0" cellpadding="0" cellspacing="0">
   <tr> 
   <td width="50%">	

	<table width="20%" border="0" cellspacing="0" cellpadding="0">
	<tbody>
		<tr> 
			<td nowrap="nowrap" class="requiredInput">
				<fmt:message key="oaBusinessCardForm.firstName"/>:       	
			</td>
			<td>
		        <html:errors property="firstName"/>
		        <html:text property="firstName" styleId="firstName"/>
			</td>
		</tr>
		
		<tr> 
			<td nowrap="nowrap" class="requiredInput">
				<fmt:message key="oaBusinessCardForm.lastName"/>:       	
			</td>
			<td>
		        <html:errors property="lastName"/>
		        <html:text property="lastName" styleId="lastName"/>
			</td>
		</tr>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="oaBusinessCardForm.sex"/>:       	
			</td>
			<td>
		        <html:errors property="sex"/>
		        <html:text property="sex" styleId="sex"/>
			</td>
		</tr>
		
		<!-- tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="oaBusinessCardForm.birthdayDate"/>:       	
			</td>
			<td>
		        <html:errors property="birthdayDate"/>
		        <html:text property="birthdayDate" styleId="birthdayDate"/>
			</td>
		</tr>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="oaBusinessCardForm.birthdayMonth"/>:       	
			</td>
			<td>
		        <html:errors property="birthdayMonth"/>
		        <html:text property="birthdayMonth" styleId="birthdayMonth"/>
			</td>
		</tr>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="oaBusinessCardForm.birthdayYear"/>:       	
			</td>
			<td>
		        <html:errors property="birthdayYear"/>
		        <html:text property="birthdayYear" styleId="birthdayYear"/>
			</td>
		</tr -->
		<!-- tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="oaBusinessCardForm.fullName"/>:       	
			</td>
			<td>
		        <html:errors property="fullName"/>
		        <html:text property="fullName" styleId="fullName"/>
			</td>
		</tr -->
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="oaBusinessCardForm.headship"/>:       	
			</td>
			<td>
		        <html:errors property="headship"/>
		        <html:text property="headship" styleId="headship"/>
			</td>
		</tr>
		<!-- tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="oaBusinessCardForm.tel2"/>:       	
			</td>
			<td>
		        <html:errors property="tel2"/>
		        <html:text property="tel2" styleId="tel2"/>
			</td>
		</tr>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="oaBusinessCardForm.tel3"/>:       	
			</td>
			<td>
		        <html:errors property="tel3"/>
		        <html:text property="tel3" styleId="tel3"/>
			</td>
		</tr -->
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="oaBusinessCardForm.mob"/>:       	
			</td>
			<td>
		        <html:errors property="mob"/>
		        <html:text property="mob" styleId="mob"/>
			</td>
		</tr>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="oaBusinessCardForm.tel1"/>:       	
			</td>
			<td>
		        <html:errors property="tel1"/>
		        <html:text property="tel1" styleId="tel1"/>
			</td>
		</tr>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="oaBusinessCardForm.work"/>:       	
			</td>
			<td>
		        <html:errors property="work"/>
		        <html:text property="work" styleId="work"/>
			</td>
		</tr>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="oaBusinessCardForm.businessCardTypId"/>:       	
			</td>
			<td>
		        <html:errors property="businessCardTypId"/>
		        <html:text property="businessCardTypId" styleId="businessCardTypId"/>
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
			
			        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('OaBusinessCard')">
			            <fmt:message key="button.delete"/>
			        </html:submit>
			
			        <html:cancel styleClass="" onclick="bCancel=true">
			            <fmt:message key="button.cancel"/>
			        </html:cancel>
			      </div>
			 </td>
		 </tr>
</table>



            </td>
            <td width="14" background="images/table1/textbox_right.gif"></td>
          </tr>
        </tbody>
      </table></td>
  </tr>
  <tr> 
    <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tbody>
          <tr> 
            <td width="14"><img src="images/table1/textbox_bottom_left.gif" height="19" width="14"></td>
            <td width="100%" background="images/table1/textbox_bottom.gif"></td>
            <td width="14"><img src="images/table1/textbox_bottom_right.gif" height="19" width="14"></td>
          </tr>
        </tbody>
      </table></td>
  </tr>
</table>


</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("oaBusinessCardForm"));
</script>

<html:javascript formName="oaBusinessCardForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
