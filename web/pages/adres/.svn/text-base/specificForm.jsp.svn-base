<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="specificDetail.title"/></title>
<content tag="heading"><fmt:message key="specificDetail.heading"/></content>

<html:form action="saveSpecific" method="post" styleId="specificForm" onsubmit="return validateSpecificForm(this)">

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
		    	<fmt:message key="specificForm.name"/>:   	       	
	        </td>
	        <td>
		        <html:errors property="name"/>
		        <html:text property="name" styleId="name"/>
			</td>
		</tr>

		<tr> 
		    <td nowrap="nowrap" class="requiredInput">
		    	<fmt:message key="specificForm.position"/>:    	       	
	        </td>
	        <td>
		        <html:errors property="position"/>
		        <html:text property="position" styleId="position"/>
			</td>
		</tr>
		<tr> 
		    <td nowrap="nowrap" class="requiredInput">
		    	<adrm_order:label key="specificForm.overRate"/>:	    	       	
	        </td>
	        <td>
		        <html:errors property="overRate"/>
		        <html:text property="overRate" styleId="overRate"/>
			</td>
		</tr>
		<!-- tr> 
		    <td nowrap="nowrap" class="dataLabel">
		    	<adrm_order:label key="specificForm.createBy"/>:	    	       	
	        </td>
	        <td>
		        <html:errors property="createBy"/>
		        <html:text property="createBy" styleId="createBy"/>
			</td>
		</tr -->
		<!-- tr> 
		    <td nowrap="nowrap" class="dataLabel">
		    	<adrm_order:label key="specificForm.createDate"/>:	    	       	
	        </td>
	        <td>		       	
	        	<html:text property="createDate" styleId="createDate"  readonly="true" onclick="button_showdate('createDate','anchorCsignDate')"/> 
				<span id="anchorCsignDate" name="anchorCsignDate"></span>
			</td>
		</tr -->
		<!-- tr> 
		    <td nowrap="nowrap" class="dataLabel">
		    	<adrm_order:label key="specificForm.modifyBy"/>:	    	       	
	        </td>
	        <td>
		        <html:errors property="modifyBy"/>
		        <html:text property="modifyBy" styleId="modifyBy"/>
			</td>
		</tr -->
		<!-- tr> 
		    <td nowrap="nowrap" class="dataLabel">
		    	<adrm_order:label key="specificForm.modifyDate"/>:	    	       	
	        </td>
	        <td>		       	
	        	<html:text property="modifyDate" styleId="modifyDate"  readonly="true" onclick="button_showdate('modifyDate','anchorCsignDate')"/> 
				<span id="anchorCsignDate" name="anchorCsignDate"></span>
			</td>
		</tr -->
		<tr> 
		    <td nowrap="nowrap" class="dataLabel">
		    	<adrm_order:label key="specificForm.memo"/>:	    	       	
	        </td>
	        <td>
		        <html:errors property="memo"/>
		        <html:text property="memo" styleId="memo"/>
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
			
			        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('Specific')">
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
    Form.focusFirstElement($("specificForm"));
</script>

<html:javascript formName="specificForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
