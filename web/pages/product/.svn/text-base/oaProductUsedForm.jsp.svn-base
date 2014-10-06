<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaProductUsedDetail.title"/></title>
<content tag="heading"><fmt:message key="oaProductUsedDetail.heading"/></content>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" href="sample.css" type="text/css"/>

<html:form action="saveOaProductUsed" method="post" styleId="oaProductUsedForm" onsubmit="return validateOaProductUsedForm(this)">
<ul>

<script>

  callOnLoad(init);	
  function init(){
	   getDate();
	   getDate2();
	   getDate3();
	} 
	
function getDate(){
	Calendar.setup({
		inputField  : "playReturnDate",	  // id of the input field
		ifFormat	: "%Y%m%d",	  // the date format
		button	  : "playReturnDate"	// id of the button
	});
	
}
function getDate2(){
	Calendar.setup({
		inputField  : "relReturnDate",	  // id of the input field
		ifFormat	: "%Y%m%d",	  // the date format
		button	  : "relReturnDate"	// id of the button
	});
	
}
function getDate3(){
	Calendar.setup({
		inputField  : "useDate",	  // id of the input field
		ifFormat	: "%Y%m%d",	  // the date format
		button	  : "useDate"	// id of the button
	});
	
}
	
</script>

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
		    	<fmt:message key="oaProductUsedForm.useMan"/>:       	
	        </td>
	        <td>
				<div style="position:relative;">
					<span style="margin-left:100px;width:18px;overflow:hidden;">
					  	<adrm_order:selectList name="users" key="2"  toScope="page"/> 
					     <html:select property="useMan" styleId="userId"  style="width:140px;margin-left:-100px"> 
					     <html:option value=""/> <html:options collection="users"  property="value" labelProperty="label"/> 
					     </html:select> 								
					</span>
				</div>  
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaProductUsedForm.amends"/>:       	
	        </td>
	        <td>
		        <html:errors property="amends"/>
		        <html:text property="amends" styleId="amends"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaProductUsedForm.attaint"/>:       	
	        </td>
	        <td>
		        <html:errors property="attaint"/>
		        <html:text property="attaint" styleId="attaint"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaProductUsedForm.playReturnDate"/>:       	
	        </td>
	        <td>		       	
	        	<html:text property="playReturnDate" styleId="playReturnDate"  readonly="true" />
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaProductUsedForm.productId"/>:       	
	        </td>
	        <td>
		        <html:errors property="productId"/>
		        <html:text property="productId" styleId="productId"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaProductUsedForm.relReturnDate"/>:       	
	        </td>
	        <td>		       	
	        	<html:text property="relReturnDate" styleId="relReturnDate"  readonly="true" />
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaProductUsedForm.returnNum"/>:       	
	        </td>
	        <td>
		        <html:errors property="returnNum"/>
		        <html:text property="returnNum" styleId="returnNum"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaProductUsedForm.useDate"/>:       	
	        </td>
	        <td>		       	
	        	<html:text property="useDate" styleId="useDate"  readonly="true" />
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaProductUsedForm.useNum"/>:       	
	        </td>
	        <td>
		        <html:errors property="useNum"/>
		        <html:text property="useNum" styleId="useNum"/>
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
		
		        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('OaProductUsed')">
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
    Form.focusFirstElement($("oaProductUsedForm"));
</script>

<html:javascript formName="oaProductUsedForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
