<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="sysParamDetail.title"/></title>
<content tag="heading"><fmt:message key="sysParamDetail.heading"/></content>


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
                    	 <!--a href="editSysParam.html" class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;&nbsp;&nbsp;</a-->
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


<html:form action="saveSysParam" method="post" styleId="sysParamForm" onsubmit="return validateSysParamForm(this)">
<ul>

    <!--li>
        <adrm_order:label styleClass="desc" key="sysParamForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysParamForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li-->

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="sysParamForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>

    <!--li>
        <adrm_order:label styleClass="desc" key="sysParamForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li-->

    <!--li>
        <adrm_order:label styleClass="desc" key="sysParamForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li-->

    <li>
        <adrm_order:label styleClass="desc" key="sysParamForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="sysParamForm.value"/>
        <html:errors property="value"/>
        <html:text property="value" styleId="value" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="" property="method.save" onclick="bCancel=false">
            &nbsp;&nbsp;&nbsp;<fmt:message key="button.save"/>&nbsp;&nbsp;&nbsp;
        </html:submit>

        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('SysParam')">
            &nbsp;&nbsp;&nbsp;<fmt:message key="button.delete"/>&nbsp;&nbsp;&nbsp;
        </html:submit>

        <html:cancel styleClass="" onclick="bCancel=true">
            &nbsp;&nbsp;&nbsp;<fmt:message key="button.cancel"/>&nbsp;&nbsp;&nbsp;
        </html:cancel>
    </li>
</ul>
</html:form>

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

<script type="text/javascript">
    Form.focusFirstElement($("sysParamForm"));
</script>

<html:javascript formName="sysParamForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
