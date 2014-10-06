<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="priceRegularDetail.title"/></title>
<content tag="heading"><fmt:message key="priceRegularDetail.heading"/></content>









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
            
            <!--   table start -->
 
<html:form action="savePriceRegular" method="post" styleId="priceRegularForm" onsubmit="return validatePriceRegularForm(this)">
<ul>


<html:hidden property="version"/>
<html:hidden property="id"/>
<html:hidden property="multiply" styleId="multiply" value="0"/>
    <li>
        <adrm_order:label styleClass="desc" key="priceRegularForm.name"/>
        <html:errors property="name"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>

    </li>
 

    <li>
        <adrm_order:label styleClass="desc" key="priceRegularForm.multiBase"/>
        <html:errors property="multiBase"/>
        <html:text property="multiBase" styleId="multiBase" styleClass="text medium"/>

    </li>




    <li>
        <adrm_order:label styleClass="desc" key="priceRegularForm.otherBase"/>
        <html:errors property="otherBase"/>
        <html:text property="otherBase" styleId="otherBase" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="priceRegularForm.regularExpr"/>
        <html:errors property="regularExpr"/>
        <html:text property="regularExpr" styleId="regularExpr" styleClass="text medium"/>

    </li>
    
   <li>
        <adrm_order:label styleClass="desc" key="priceRegularForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>
<li>

   	 <table width="26%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		  <td>
		  	&nbsp;&nbsp;&nbsp;
		  </td>
		  	<td >
		  		<div align="center">
			        <html:submit styleClass="" property="method.save" onclick="bCancel=false">
			            <fmt:message key="button.save"/>
			        </html:submit>
			        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('CarrierType')">
			            <fmt:message key="button.delete"/>
			        </html:submit>
			
			        <html:cancel styleClass="" onclick="bCancel=true">
			            <fmt:message key="button.cancel"/>
			        </html:cancel>
			      </div>
			 </td>
		 </tr>
	</table> 
</li>
</ul>
</html:form>
           
            <!--   table end -->
            
            
            
            
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
    Form.focusFirstElement($("priceRegularForm"));
</script>

<html:javascript formName="priceRegularForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
