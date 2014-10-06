<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="priceTypeDetail.title"/></title>
<content tag="heading"><fmt:message key="priceTypeDetail.heading"/></content>

<html:form action="savePriceType" method="post" styleId="priceTypeForm" onsubmit="return validatePriceTypeForm(this)">

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
		    	<fmt:message key="priceTypeForm.priceTypeName"/>:       	
	        </td>
	        <td>
		        <html:errors property="name"/>
		        <html:text property="priceTypeName" styleId="priceTypeName"/>
			</td>
		</tr>
    
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="requiredInput">
		    	<fmt:message key="priceTypeForm.value"/>:       	
	        </td>
	        <td>
		        <html:errors property="edit"/>
		        <html:text property="value" styleId="value"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="priceTypeForm.enable"/>:       	
	        </td>
	        <td>
		        <html:errors property="enable"/>
		        <html:checkbox property="enable"/>
			</td>
		</tr>
	</tbody>
 </table>
 </td></tr>
 </table>  		
    <!-- li>
        <adrm_order:label styleClass="desc" key="priceTypeForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceTypeForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceTypeForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceTypeForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>
    <li>
        <adrm_order:label styleClass="desc" key="priceTypeForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceTypeForm.priceTypeName"/>
        <html:errors property="priceTypeName"/>
        <html:text property="priceTypeName" styleId="priceTypeName" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceTypeForm.value"/>
        <html:errors property="value"/>
        <html:text property="value" styleId="value" styleClass="text medium"/>

    </li>
    <li>
        <adrm_order:label styleClass="desc" key="priceTypeForm.enable"/>
        <html:errors property="enable"/>
        <html:checkbox property="enable" styleId="enable" styleClass="text medium"/>

    </li -->
&nbsp;&nbsp;

<table width="26%" border="0" cellspacing="0" cellpadding="0">
	 <tr>
		<td>
			<div align="center">
    <li class="buttonBar bottom">
        <html:submit styleClass="" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('PriceType')">
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
    Form.focusFirstElement($("priceTypeForm"));
</script>

<html:javascript formName="priceTypeForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
