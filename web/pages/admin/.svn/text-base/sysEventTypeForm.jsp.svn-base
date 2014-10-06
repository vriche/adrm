<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="sysEventTypeDetail.title"/></title>
<content tag="heading"><fmt:message key="sysEventTypeDetail.heading"/></content>

<html:form action="saveSysEventType" method="post" styleId="sysEventTypeForm" onsubmit="return validateSysEventTypeForm(this)">

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
			<td width="50%" nowrap="nowrap" class="dataLabel">
			    <!--系统事件类型--!>
				<adrm_order:label styleClass="" key="sysEventTypeForm.name"/>:
		    </td>
		    <td>
				<div style="position:relative;">
					<span style="margin-left:100px;width:18px;overflow:hidden;">
					  	<adrm_order:selectList name="systemEventTypes" key="31"  toScope="page"/> 
					     <html:select property="name" styleId="sysEventTypeId"  style="width:140px;margin-left:-100px"> 
					     <html:option value=""/> <html:options collection="systemEventTypes"  property="value" labelProperty="label"/> 
					     </html:select> 								
					</span>
					<html:errors property="name"/>
				</div> 
			</td>
    	</tr>
    	
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="sysEventTypeForm.value"/>:       	
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
			        <html:submit styleClass="" property="method.save" onclick="bCancel=false">
			            <fmt:message key="button.save"/>
			        </html:submit>
			
			        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('SysEventType')">
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
    Form.focusFirstElement($("sysEventTypeForm"));
</script>

<html:javascript formName="sysEventTypeForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
