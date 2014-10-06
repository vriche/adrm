<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="sysSequenceDetail.title"/></title>
<content tag="heading"><fmt:message key="sysSequenceDetail.heading"/></content>
<link rel="stylesheet" type="text/css" media="all" href="/adrm/styles/adrmworkspance/theme.css" />
<link  rel="stylesheet" type="text/css"  media="all"  href="/adrm/styles/adrmworkspance/tab/common.css" />

<html:form action="saveSysSequence" method="post" styleId="sysSequenceForm" onsubmit="return validateSysSequenceForm(this)">

<html:hidden property="id"/>
<html:hidden property="version"/>

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
							
						<a href="editSysSequence.html"><input type="button" value="&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;&nbsp;&nbsp;" name="add" /></a>
					   		<html:submit styleClass="" property="method.save" onclick="bCancel=false">
				              &nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.save"/>&nbsp;&nbsp;&nbsp;&nbsp;
					        </html:submit>
					
					        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('SysSequence')">
					            &nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.delete"/>&nbsp;&nbsp;&nbsp;&nbsp;
					        </html:submit>
					
					        <html:cancel styleClass="" onclick="bCancel=true">
					            &nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.cancel"/>&nbsp;&nbsp;&nbsp;&nbsp;
					        </html:cancel>
		  			</td>	
				   
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


    <li>
        <adrm_order:label styleClass="desc" key="sysSequenceForm.currentNext"/>
        <html:errors property="currentNext"/>
        <html:text property="currentNext" styleId="currentNext" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysSequenceForm.currentNextSys"/>
        <html:errors property="currentNextSys"/>
        <html:text property="currentNextSys" styleId="currentNextSys" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysSequenceForm.format"/>
        <html:errors property="format"/>
        <html:text property="format" styleId="format" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysSequenceForm.incrementNo"/>
        <html:errors property="incrementNo"/>
        <html:text property="incrementNo" styleId="incrementNo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysSequenceForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysSequenceForm.prefix"/>
        <html:errors property="prefix"/>
        <html:text property="prefix" styleId="prefix" styleClass="text medium"/>

    </li>


    <li>
        <adrm_order:label styleClass="desc" key="sysSequenceForm.startNo"/>
        <html:errors property="startNo"/>
        <html:text property="startNo" styleId="startNo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysSequenceForm.suffix"/>
        <html:errors property="suffix"/>
        <html:text property="suffix" styleId="suffix" styleClass="text medium"/>

    </li>



  
    
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
    Form.focusFirstElement($("sysSequenceForm"));
</script>

<html:javascript formName="sysSequenceForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
