<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="matterTypeDetail.title"/></title>
<content tag="heading"><fmt:message key="matterTypeDetail.heading"/></content>

<link rel="stylesheet" type="text/css" media="all" href="/adrm/styles/adrmworkspance/theme.css" />
<link  rel="stylesheet" type="text/css"  media="all"  href="/adrm/styles/adrmworkspance/tab/common.css" />


<html:form action="saveMatterType" method="post" styleId="matterTypeForm" onsubmit="return validateMatterTypeForm(this)">
<ul>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            
          <td>
        <html:submit styleClass="" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('MatterType')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </td>
            
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
        		<fmt:message key="matterTypeForm.createBy"/>:       	
	        </td>
	        <td>
				<html:errors property="createBy"/>
				<html:text property="createBy" styleId="createBy"/>
			</td>
		 </tr>
		 <!--tr>
	  		<td nowrap="nowrap" class="requiredInput">
        		<fmt:message key="matterTypeForm.createDate"/>:       	
	        </td>
	        <td>
				<html:errors property="createDate"/>
				<html:text property="createDate" styleId="createDate"/>
			</td>
	     </tr-->	

    
<html:hidden property="id"/>
		 <tr>	
			<td nowrap="nowrap" class="requiredInput">
        		<fmt:message key="matterTypeForm.modifyBy"/>:       	
	       </td>
	        <td>
				<html:errors property="modifyBy"/>
				<html:text property="modifyBy" styleId="modifyBy"/>
			</td>
		</tr>	
		<!--tr>
			<td nowrap="nowrap" class="requiredInput">
        		<fmt:message key="matterTypeForm.modifyDate"/>:       	
	       </td>
	        <td> 
				<html:errors property="modifyDate"/>
				<html:text property="modifyDate" styleId="modifyDate"/>
			</td>
		</tr-->
		<tr>	
    		<td nowrap="nowrap" class="requiredInput">
        		<fmt:message key="matterTypeForm.name"/>:       	
	         </td>
	        <td>
				<html:errors property="name"/>
				<html:text property="name" styleId="name"/>
			</td>
		</tr>
		<tr>	
			<td nowrap="nowrap" class="requiredInput">
        		<fmt:message key="matterTypeForm.value"/>:       	
	        </td>
	        <td> 
				<html:errors property="value"/>
				<html:text property="value" styleId="value"/>
			</td>
    	</tr>


<html:hidden property="version"/>

    <!--li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('MatterType')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li-->
</tbody>
 </table>
 </td></tr>
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
    Form.focusFirstElement($("matterTypeForm"));
</script>

<html:javascript formName="matterTypeForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
