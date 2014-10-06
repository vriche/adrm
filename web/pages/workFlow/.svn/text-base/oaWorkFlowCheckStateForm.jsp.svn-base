<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaWorkFlowCheckStateDetail.title"/></title>
<content tag="heading"><fmt:message key="oaWorkFlowCheckStateDetail.heading"/></content>

<html:form action="saveOaWorkFlowCheckState" method="post" styleId="oaWorkFlowCheckStateForm" onsubmit="return validateOaWorkFlowCheckStateForm(this)">
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
					<td width="10%">    
						
						
						<!--li class="buttonBar bottom"-->
						
					        <html:submit styleClass="" property="method.save" onclick="bCancel=false">
					            &nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.save"/>&nbsp;&nbsp;&nbsp;&nbsp;
					        </html:submit>
					
					        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('OaWorkFlowCheckState')">
					            &nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.delete"/>&nbsp;&nbsp;&nbsp;&nbsp;
					        </html:submit>
					
					        <html:cancel styleClass="" onclick="bCancel=true">
					            &nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.cancel"/>&nbsp;&nbsp;&nbsp;&nbsp;
					        </html:cancel>
					    <!--/li-->
						
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


  

<html:hidden property="id"/>



    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowCheckStateForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="oaWorkFlowCheckStateForm.value"/>
        <html:errors property="value"/>
        <html:text property="value" styleId="value" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    
    

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
    Form.focusFirstElement($("oaWorkFlowCheckStateForm"));
</script>

<html:javascript formName="oaWorkFlowCheckStateForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
