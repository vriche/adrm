<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="orderLogList.title"/></title>
<content tag="heading"><fmt:message key="orderLogList.heading"/></content>
<meta name="menu" content="OrderLogMenu"/>

<html:form action="orderLogs" method="post" styleId="orderLogListForm" onsubmit="return validateOrderLogListForm(this)">
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
                    <tr> 
                    
                       <td align="left">
							 <fmt:message key="contractForm.startDate"/>
                                    <html:text property="orderForm.orderPublicForm.publishStartDate" styleId="orderForm.orderPublicForm.publishStartDate"  readonly="true" onclick="button_showdate('orderForm.orderPublicForm.publishStartDate','anchorCsignStartDate')"/> 
									<span id="anchorCsignStartDate" name="anchorCsignStartDate"></span>
						 
							 <fmt:message key="contractForm.endDate"/>
                                    <html:text property="orderForm.orderPublicForm.publishEndDate" styleId="orderForm.orderPublicForm.publishEndDate"  readonly="true" onclick="button_showdate('orderForm.orderPublicForm.publishEndDate','anchorCsignendDate')"/> 
									<span id="anchorCsignendDate" name="anchorCsignendDate"></span>
						
							<fmt:message key="orderLogForm.orderId"/>:       	
									<html:errors property="logForm.orderCode"/>
		       						<html:text property="orderForm.orderCode" styleId="orderCode" style="width:100px"/>
							
							<fmt:message key="orderLogForm.logForm.modifyBy"/>: 
	 								<span style="margin-left:100px;overflow:hidden;">
		  								<adrm_order:selectList name="users" key="2"  toScope="page"/> 
		    							<html:select property="logForm.modifyBy" styleId="modifyBy"  style="width:100px;margin-left:-100px"> 
		    							<html:option value=""/> <html:options collection="users"  property="value" labelProperty="label"/> 
		    							</html:select> 								
									</span>
	                	 </td> 
						<td align="left"> 
							<html:submit styleClass="" property="method.search" onclick="bCancel=true;">
			      		      <fmt:message key="button.search"/>
			     		   </html:submit>
						 
							<html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('OrderLog')">
			      		      <fmt:message key="button.delete"/>
			     		   </html:submit>
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
 
			<display:table name="orderLogList" cellspacing="2" cellpadding="2"
			    id="orderLogList" pagesize="18" class="tableDisplay orderLogList"
			    export="false" requestURI="">
			
		    <display:column property="id" sortable="true" headerClass="sortable"
		        url="/editOrderLog.html" paramId="id" paramProperty="id"
		        titleKey="orderLogForm.id"/>
			        
		    <display:column  sortable="true"  headerClass="sortable" titleKey="orderLogForm.logForm.clientIp"  media="html" class="sortableRight">
         				 <c:out value="${orderLogList.log.clientIp}"/>
			    </display:column> 	
		         
		    <display:column  sortable="true"  headerClass="sortable" titleKey="orderLogForm.orderId"  media="html" class="sortableRight">
         				 <c:out value="${orderLogList.order.orderCode}"/>
			    </display:column> 
			         
			 <display:column  sortable="true"  headerClass="sortable" titleKey="orderLogForm.logForm.modifyBy"  media="html" class="sortableRight">
         				 <c:out value="${orderLogList.log.user.fullName}"/>
			 </display:column> 	
			 
			 <display:column  sortable="true"  headerClass="sortable" titleKey="orderLogForm.logForm.modifyDate"  media="html" class="sortableRight">
         				 <c:out value="${orderLogList.log.modifyDate}"/>
			 </display:column> 
			 
			 <!--display:column  property="log.modifyDate"    sortable="true" headerClass="sortable"
				
		        titleKey="orderLogForm.logForm.modifyDate"/ -->  
		                         
		    <display:setProperty name="paging.banner.item_name" value="orderLog"/>
		    <display:setProperty name="paging.banner.items_name" value="orderLogs"/>
		</display:table>
            <!--   table end format="{0,date,yyyy-MM-dd  HH:mm:ss}-->
            
            
            
            
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

<div style="display:none">
    <html:text property="logForm.modifyBy" styleId="createBy"/>
	<html:text property="orderForm.orderCode" styleId="orderCode"/>
	<html:text property="orderForm.orderPublicForm.publishStartDate" styleId="publishStartDate"/>
	<html:text property="orderForm.orderPublicForm.publishEndDate" styleId="publishEndDate"/>
</div >

</ul>
</html:form>



<script type="text/javascript">
    highlightTableRows("orderLogList");
</script>
