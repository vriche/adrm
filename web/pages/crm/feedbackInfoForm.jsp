<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="feedbackInfoDetail.title"/></title>
<content tag="heading"><fmt:message key="feedbackInfoDetail.heading"/></content>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>

<script>

callOnLoad(init);


	function oncustomerCmdchange(){
	
		$("customerId").value = $("customerCmd").value;
	}

function init(){

    var customer = new Customer();
	var orgId =  getParamFromUrl(window.location.href,"orgId")+'';
    loginUser = $("config_username").value;		
	
	
	function setCustomerSelected(){
	   $("customerCmd").value =  $("customerId").value;
	    $("customerCmd").remove(0);
	}
	
	customer.obj.orgId = $("orgId").value; 
	customer.obj.loginUser = loginUser;
	customer.makeSelectAnalyzeWidth(customer.obj,"customerCmd","oncustomerCmdchange","160",setCustomerSelected);
	

	
	
}
</script>
<html:form action="saveFeedbackInfo" method="post" styleId="feedbackInfoForm" onsubmit="return validateFeedbackInfoForm(this)">
<html:hidden property="id"/>
<html:hidden property="version"/>
 <html:hidden property="customerId"  styleId="customerId" />
 <html:hidden property="orgId"  styleId="orgId" />
 
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
	        	<adrm_order:label styleClass="" key="feedbackInfoForm.customerId"/>:
			</td>
			<td>
			
			        <select id="customerCmd" name="customerCmd" >

			</td>
		</tr>

		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="feedbackInfoForm.feeder"/>:       	
	        </td>
            <td> <html:errors property="feeder"/> 
                 <html:text property="feeder" styleId="feeder"/> 
            </td>
		</tr>
		<tr> 
		    <td nowrap="nowrap" class="requiredInput">
		    	<fmt:message key="feedbackInfoForm.feedContent"/>:       	
	        </td>
	        <td>
		        <html:errors property="feedContent"/>
		 		<html:textarea property="feedContent" cols="50%" rows="3"></html:textarea>
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
			
			        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('FeedbackInfo')">
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



</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("feedbackInfoForm"));
</script>

<html:javascript formName="feedbackInfoForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
