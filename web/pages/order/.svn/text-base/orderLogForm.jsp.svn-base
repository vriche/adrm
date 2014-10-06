<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="orderLogDetail.title"/></title>
<content tag="heading"><fmt:message key="orderLogDetail.heading"/></content>

<html:form action="saveOrderLog" method="post" styleId="orderLogForm" onsubmit="return validateOrderLogForm(this)">
<ul>

<html:hidden property="id"/>
<html:hidden property="orderId"/>
<html:hidden property="logForm.modifyBy"/>
<html:hidden property="orderDetailId"/>
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
				<fmt:message key="orderLogForm.logForm.clientIp"/>:       	
			</td>
			<td>
		        <html:errors property="logForm.clientIp"/>
		        <!--html:text property="logForm.clientIp" styleId="logForm.clientIp"/-->
		         <c:out value="${orderLogForm.logForm.clientIp}"/>
			</td>
		</tr>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="orderLogForm.orderId"/>:       	
			</td>
			<td>
		        <html:errors property="logForm.orderCode"/>
		        <!--html:text property="orderCode" styleId="orderCode"/-->
		        <c:out value="${orderLogForm.orderForm.orderCode}"/>
			</td>
		</tr>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="orderLogForm.orderDetailId"/>:       	
			</td>
			<td>
		        <html:errors property="orderDetailId"/>
		        <c:out value="${orderLogForm.orderDetailId}"/>
			</td>
		</tr>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="orderLogForm.logForm.modifyBy"/>:       	
			</td>
			<td>
		        <html:errors property="logForm.modifyBy"/>
		        <!--html:text property="logForm.modifyBy" styleId="logForm.modifyBy"/-->
		        <c:out value="${orderLogForm.logForm.userForm.fullName}"/>
		        	<!--ÒµÎñÔ±-->

		<!--span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="users" key="2"  toScope="page"/> 
		     <html:select property="logForm.modifyBy" styleId="modifyBy"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="users"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span-->
		
			</td>
		</tr>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="orderLogForm.logForm.modifyDate"/>:       	
			</td>
			<td>
		        <html:errors property="logForm.modifyDate"/>
		        <!--html:text property="logForm.modifyDate" styleId="logForm.modifyDate"/-->
		        <c:out value="${orderLogForm.logForm.modifyDate}"/>
			</td>
		</tr>
		<tr> 
			<td width="50%" nowrap="nowrap" class="dataLabel">
				<fmt:message key="orderLogForm.logForm.changeContent"/>:       	
			</td>
			<td>
		        <html:errors property="logForm.changeContent"/>
		        <html:textarea  property="changeContent" styleId="changeContent" rows="6"  cols="60" style="font-size:13px"/>
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
			        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('OrderLog')">
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

<input type="hidden" name="startDateForm" id="startDateForm" value="">
<input type="hidden" name="endDateForm" id="endDateForm" value="">
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("orderLogForm"));
</script>

<!--html:javascript formName="orderLogForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script-->
