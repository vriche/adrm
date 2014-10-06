<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaApplyInfoDetail.title"/></title>
<content tag="heading"><fmt:message key="oaApplyInfoDetail.heading"/></content>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" href="sample.css" type="text/css"/>


<html:form action="saveOaApplyInfo" method="post" styleId="oaApplyInfoForm" onsubmit="return validateOaApplyInfoForm(this)">
<html:hidden property="id"/>
<html:hidden property="version"/>
<ul>
<script>

  callOnLoad(init);	
  function init(){
	   getDate();
	   getDate2();
	} 
	
function getDate(){
	Calendar.setup({
		inputField  : "applyStart",	  // id of the input field
		ifFormat	: "%Y%m%d",	  // the date format
		button	  : "applyStart"	// id of the button
	});
	
}

function getDate2(){
	Calendar.setup({
		inputField  : "applyEnd",	  // id of the input field
		ifFormat	: "%Y%m%d",	  // the date format
		button	  : "applyEnd"	// id of the button
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
		    	<fmt:message key="oaApplyInfoForm.applyStart"/>:  
		        <html:errors property="applyStart"/>     	
	        </td>
	        <td>		       	
	        	<html:text property="applyStart" styleId="applyStart"  readonly="true"/>
			</td>
		</tr>
	    <tr> 
		    <td nowrap="nowrap" class="requiredInput">
		    	<fmt:message key="oaApplyInfoForm.applyEnd"/>:   
		        <html:errors property="applyEnd"/>    	
	        </td>
	        <td>
		        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr> 
                    <td width="20%">
                    <html:text property="applyEnd" styleId="applyEnd"  readonly="true" />
                    </td>
                    <td></td>
                  </tr>
                </table>
			</td>
		</tr>
  		
	    
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaApplyInfoForm.reason"/>:       	
	        </td>
	        <td>
		        <html:errors property="reason"/>
		        <html:textarea property="reason" cols="50%" rows="3"></html:textarea>
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
		
		        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('OaApplyInfo')">
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
    Form.focusFirstElement($("oaApplyInfoForm"));
</script>

<html:javascript formName="oaApplyInfoForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
