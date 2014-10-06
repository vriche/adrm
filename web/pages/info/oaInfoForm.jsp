<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaInfoDetail.title"/></title>
<content tag="heading"><fmt:message key="oaInfoDetail.heading"/></content>

<html:form action="saveOaInfo" method="post" styleId="oaInfoForm" onsubmit="return validateOaInfoForm(this)">
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
		    	<fmt:message key="oaInfoForm.title"/>:       	
	        </td>
	        <td>
		        <html:errors property="title"/>
		        <html:text property="title" styleId="title" />
			</td>
		</tr>
		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaInfoForm.infoTypeId"/>:       	
	        </td>
	        <td>
		        <html:errors property="infoTypeId"/>
		        <html:text property="infoTypeId" styleId="infoTypeId"/>
			</td>
		</tr>
	    <!-- tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaInfoForm.displayTimes"/>:       	
	        </td>
	        <td>
		        <html:errors property="displayTimes"/>
		        <html:text property="displayTimes" styleId="displayTimes"/>
			</td>
		</tr -->
		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaInfoForm.searchKey"/>:       	
	        </td>
	        <td>
		        <html:errors property="searchKey"/>
		        <html:text property="searchKey" styleId="searchKey"/>
			</td>
		</tr>
	    <tr> 
		    <td nowrap="nowrap" class="requiredInput">
		    	<fmt:message key="oaInfoForm.content"/>:       	
	        </td>
	        <td>
		        <html:errors property="content"/>
		        <html:textarea property="content" styleId="content" cols="1" rows=""/>
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
		    <li class="buttonBar bottom">
		        <html:submit styleClass="" property="method.save" onclick="bCancel=false">
		            <fmt:message key="button.save"/>
		        </html:submit>
		
		        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('OaInfo')">
		            <fmt:message key="button.delete"/>
		        </html:submit>
		
		        <html:cancel styleClass="" onclick="bCancel=true">
		            <fmt:message key="button.cancel"/>
		        </html:cancel>
		       </li> 
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
    Form.focusFirstElement($("oaInfoForm"));
</script>

<html:javascript formName="oaInfoForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
