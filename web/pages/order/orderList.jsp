<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title><fmt:message key="orderList.title"/></title>
<content tag="heading"><fmt:message key="orderList.heading"/></content>
<meta name="menu" content="OrderMenu"/>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customerType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/category.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/matter.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/order.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/oaWorkFlowCheckState.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderCategory.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resourceSort.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrierType.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/OrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaWorkFlowCheckStateManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CategoryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderCategoryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceSortManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/order/orderListService.js'/>"></script>







<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tbody>
                  <tr> 
                  <td width="1px">
                  
                     <select id="order_year"  style="CURSOR: pointer;">
						     <% for(int i= 2008; i< 2014;i++){ %>
						   		 <option value="<%=i%>"><%=i%></option>
					         <%}%>
					 </select>
					
                  </td>
                  

	    
	      <c:if test="${appConfig.useMoreCarrierSortParam == '1'}">
	      		<td width="20px" id="div_carrierSort">
	           		<select name=carrierSort" id="carrierSort"/> 
	           </td>
	     </c:if>	
      
    

        
               
          <c:if test="${appConfig.tvNameParam == 'xmtv'}">
                   <td width="20px"  id="TDcarrierType">
							<select name=carType" id="carType"> 
								<option value="P">时段 </option>
								<option value="L">栏目</option>
							</select>	
					</td>		
		 </c:if>	
					
		 <td width="20px"  id="TDcustomerCategorys">	
				<select name="customerCategorys" id="customerCategorys"/>	
							
		</td>	
		
		
		
	   <adrm_order:authorizeTag res="tag_orderList_print">	 
	      		<td width="20px" >
	           		 <div id="printReportDiv" name="printReportDiv"/>
	           </td>
	   </adrm_order:authorizeTag>      				
					
						
					
                <td>
                     <!--查询-->
		    <div style="position:relative;overflow:visible">                 	
			
			
 			<a href="#"  id="btn_searche"  class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="publishArrangeDownload.query"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>  
			
			<div id="theDivSearch" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:700px;height:400px;visibility:hidden;border:solid green 2px;background-color:white;z-index:0">	
                    
                    

	                  <table width="100%">
	                  <tr>
	                    <td align="left">
	 						<div style="position:relative;overflow:visible;">
	 						 <fmt:message key="orderForm.customerName"/>:
							<input size="12px" name="customer_name" id="customer_name" type=text  value="==<fmt:message key="orderForm.customerName"/>==">
							<div id="theDivCustomerName" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:450px;height:250px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
							</div>		
	                    </td>
	                    
	                    <td align="left">
	                         &nbsp;&nbsp;&nbsp;<fmt:message key="foretArrearageForm.userName"/>:
	 						<select name="userOwner" id="userOwner"/>
	                    </td>  
	                    
	                    <td align="left">
	                     	&nbsp;&nbsp;&nbsp;<fmt:message key="orderFinanceList.theMan"/>:
	 						<select name="createById" id="createById"/>
	                    </td> 
	                    
	                    
	                    <td align="left">
							 <fmt:message key="proProgramForm.checkStatus"/>:
							<select name="select" id="OaWorkFlowCheckStateRN"/>
			     </td>	
	   
	                   
	                            
			    <td align="left"></td>
	                    
	                    </tr>
	                    
	                    
	                    <tr><td align="left" colspan="5">&nbsp</td></tr>
	                    
	                  <tr>
	                    <td align="left">
				            <adrm_order:authorizeTag res="tag_orderList_finance">	
				             					<fmt:message key="orderList.isArrears2"/>:
					                     	    <select name="isArrears" id="isArrears"> 
													<option value="0"><fmt:message key="orderList.isArrears"/></option>
													<option value="2"><fmt:message key="orderList.arrears"/></option>
													<option value="1"><fmt:message key="orderList.noArrears"/></option>
												</select>
							</adrm_order:authorizeTag>
	                    </td>
	                    
	                    <td align="left">
	                        <fmt:message key="orderForm.categoryId"/>:
	 						<select name="orderCategoryId" id="orderCategoryId" />
	                    </td>  
	                    
	                    <td align="left">	
	                    
				     <div id="order_div" style="position:relative;overflow:visible;">
				       <fmt:message key="publishedInfoForm.matterName"/>:
						<input size="12px" name="matter.name" id="matter.name" type=text autocomplete=off value="==<fmt:message key="orderDetailForm.matterName"/>==">
						<div name="theDivMatterName" id="theDivMatterName" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:150px;height:250px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
				     </div>	                    	
	                    	
			     </td>	
	   
	             <td align="left">
	             
	                   <fmt:message key="resourceChannelForm.name"/>:
	                    
			
    	 
 				     
			   				<input name="carrierName" id="carrierName" size="12px" type="text" autocomplete=off/>
			     	 
					
					
				
			    </td>
	                            
	     		    <td align="left">
							
	     		    </td>
	                    
	                    </tr>	                    
	                    
	                    
	                  <tr><td align="left" colspan="5">&nbsp</td></tr>
	                    
	                  <tr>
	                  
	                   	<td align="left">
							<fmt:message key="orderDetailForm.orderId"/>:&nbsp;<input size="12px" name="order_code" id="order_code" type=text  value="==<fmt:message key="orderDetailForm.orderId"/>==">		
	     		    	</td>
	     		    
	     		    	<td align="left">
							<fmt:message key="contractForm.code"/>:&nbsp;<input size="12px" name="contract_code" id="contract_code" type=text  value="==<fmt:message key="contractForm.code"/>==">
	     		    	</td>	
	                  
	                    <td align="left">
							<fmt:message key="orderForm.relationCode"/>:&nbsp;<input type ="text" id ="relation_code" size=12 value="==<fmt:message key="orderForm.relationCode"/>=="/>		
	     		   		</td>
	                    
	                    <td align="left" ><fmt:message key="contractPaymentForm.incomeModeId"/>:
							<select name=moneyRPay" id="moneyRPay"> 
								<option value="0">付款情况 </option>
								<option value="1">应付金额为0</option>
								<option value="2">应付金额大于0</option>
							</select>		
	     		    	</td>
	     		    
	     		    
	                    <td align="left">
							
	     		    	</td>
	     		    
	                 </tr>
	                 
	                 <tr><td align="left" colspan="5">&nbsp</td></tr> 
												
					<tr>	
						
						<td align="left" >
						
	                		<fmt:message key="orderDayInfoForm.startDate"/>:&nbsp;<input type ="text" id ="beginDate" size=11/>
						</td>
						
						 <td> 
						 	<fmt:message key="orderDayInfoForm.endDate"/>:&nbsp;<input type ="text" id ="overDate" size=11/> 
						 
						 </td>
						 <td> </td> 
						 <td> <div style="display:none">
						      <select name="resourceSortId" id="resourceSortId" " />
						      </div>
						 </td>
						      
						
					</tr> 
	                 
	                <tr><td align="left" colspan="5">&nbsp</td></tr> 
	                 	                 
	                 
	                 
	                    	                    
	                     </table>
                     
                     

                 
                     <input style="CURSOR: pointer;" type="button"  id="query" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.confim"/>&nbsp;&nbsp;&nbsp;&nbsp;'>

                     <input style="CURSOR: pointer;" type="button" id="btn_searche_close" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.cancel"/>&nbsp;&nbsp;&nbsp;&nbsp;'>
                    
                    
                    
                  
                    
                     </div>
                     

	                     
                             
                    
	                      <adrm_order:authorizeTag res="tag_orderList_check">	
	                      	<a href="#" id="submitChecked"  class="button"><fmt:message key="button.order.chech"/></a>
	                      	<a href="#" id="isCheckedOrder"  class="button">&nbsp;&nbsp;&nbsp;<fmt:message key="orderDetailForm.tb.ckecked"/>&nbsp;&nbsp;&nbsp;</a> 
	                      </adrm_order:authorizeTag>   
	                      
	                      <a href="#" id="Btn_AllOrder" class="button">&nbsp;&nbsp;<fmt:message key="orderForm.legend6"/>&nbsp;&nbsp;</a>   
	                        &nbsp;&nbsp;&nbsp;&nbsp;
	                       
	                       
	                       
	                       
		                      <select name="selectOrder" id="selectOrder" align='center'> 
									<option value="0"> &nbsp;&nbsp;所有订单&nbsp;&nbsp; </option>
									<option value="1"> &nbsp;&nbsp;普通订单&nbsp;&nbsp; </option>
									<option value="2"> &nbsp;&nbsp;导入订单&nbsp;&nbsp; </option>
							</select>
					      
					

														
							
	                      <adrm_order:authorizeTag res="tag_orderList_new">	
	                      	<a href="#" id="Btn_addNewOrder" class="button">&nbsp;&nbsp;新添订单&nbsp;&nbsp;</a>   
	                      </adrm_order:authorizeTag>         
	                      

							

	                      
	                      
	                      
	                     	 <a href="#" id="Btn_myOrder" class="button">&nbsp;&nbsp;<fmt:message key="orderForm.legend5"/>&nbsp;&nbsp;</a>   
	                       
                    </td>
                    
                    

                  </tr>
                </tbody>
              </table>
               
              
              </td>
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
	
			<display:table name="orderList" cellspacing="1" cellpadding="0" decorator="com.vriche.adrm.webapp.util.orderTableDecorator" 
			    id="orderList" pagesize="18" class="tableDisplay orderList"
			    partialList="true" size="resultSize" sort="list"   varTotals="totals"
			    export="false" requestURI="/orders.html">

			     <display:column  title="<input type=checkbox onclick='selectAll' id=orderAllSelect>" headerClass="sortable"  media="html"> 
			     <c:if test="${orderList.isCkecked == '0' || orderList.isCkecked == '4'}">
			        		<input type="checkbox" value='<c:out value="${orderList.id}"/>'><!--选择-->
				 </c:if>
				</display:column>     	
				
				
				  
			    <display:column property="orderCode" sortable="true" headerClass="sortable" 
			         titleKey="orderForm.orderCode" media="html"/>      <!--订单号-->    
			         
			         
			      <!--联系号-->    
			     <c:if test="${appConfig.tvNameParam == 'xmtv'}">
			        	 <display:column property="relationCode" sortable="true" headerClass="sortable" titleKey="orderForm.relationCode" media="html"/>     
				 </c:if>     
			        
			    <!-- display:column property="contract.code" sortable="true" headerClass="sortable"
			         titleKey="orderForm.contractId"/ -->      <!--合同号-->    
			         
			     <display:column  sortable="true"  headerClass="sortable" titleKey="orderForm.contractId"  media="html">
			       <a href="editContract.html?id=<c:out value="${orderList.contractId}"/>" target="_bank"><c:out value="${orderList.contract.code}"/> </a>
			    </display:column>      
			            
			         
			     <!-- display:column property="customer.customerName" sortable="true"  headerClass="sortable" 
			         href="editCustomer.html"  target="_self" paramId="id" paramProperty="customerId" autolink="true" 
			         titleKey="orderForm.customerName"/ -->    <!--广告单位-->
			     <display:column  sortable="true"  headerClass="sortable" titleKey="orderForm.customerName"  media="html">
			       <a href="editCustomer.html?id=<c:out value="${orderList.customerId}"/>" target="_bank"><c:out value="${orderList.customer.customerName}"/> </a>
			    </display:column>      
			    
			     <display:column property="orderPublic.matterName" sortable="true" headerClass="sortable"
			         titleKey="orderForm.matterName"/> 		<!--广告名称-->     
			     
			    <display:column property="orderPublic.publishStartDate" 
			         sortable="true" headerClass="sortable" 
			         decorator="com.vriche.adrm.webapp.util.ConvertNum2DateWrapper"
			         titleKey="orderForm.publishStartDate"/><!--开始日期-->
			         
			    <display:column property="orderPublic.publishEndDate" sortable="true" headerClass="sortable"
			         decorator="com.vriche.adrm.webapp.util.ConvertNum2DateWrapper"
			         titleKey="orderForm.publishEndDate"/>  <!--结束日期-->         
			                 
			     <display:column property="orderPublic.moneyRealpay" sortable="true" headerClass="sortable" class="sortableRight"
			         format="{0,number,##,###}" 
			         titleKey="orderForm.moneySum"/>		<!--应付金额-->
			         
			     <display:column property="orderPublic.moneyIn" sortable="true" headerClass="sortable" class="sortableRight"
			       format="{0,number,##,###}" 
			         titleKey="orderForm.moneyIn"/> 		<!--已付金额-->      
			
				<display:column  sortable="true"  headerClass="sortable" titleKey="orderForm.userId"  media="html" class="sortableRight">
			      	 <c:out value="${orderList.user.fullName}"/>
			      	 <!-- c:out value="${orderList.user.lastName}"/ -->
			    </display:column> 		                    <!--业务员-->  
			  
			    <display:column property="orderState.name" sortable="true" headerClass="sortable" class="sortableRight"
			         titleKey="orderForm.isCkecked"/>	     <!--审核-->
			
			    <!--display:column property="orderPublic.moneyState" sortable="true" headerClass="sortable"
			         titleKey="orderList.isArrears"/--> 	      <!--平帐-->
				
				<!-- display:column  titleKey="button.operation" headerClass="sortable" style="width: 5%; padding-left: 15px" 
					property="opernation" media="html"/ -->      <!--操作--> 
				
			
			    <display:setProperty name="export.excel.filename" value="Order List.xls"/>
			    <display:setProperty name="export.csv.filename" value="Order List.csv"/>
			    <display:setProperty name="export.pdf.filename" value="Order List.pdf"/>
			    
				<display:setProperty name="paging.banner.placement" value="top" />
			    <display:setProperty name="paging.banner.group_size" value="6"/>
			    <display:setProperty name="paging.banner.item_name" value="order"/>
			    <display:setProperty name="paging.banner.items_name" value="orders"/>
			</display:table>

           
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


<!-- iframe src='about:blank'   scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe -->




<div style="display:none">
customerCategoryId:<input name="customerCategoryId" type="text" id="customerCategoryId">



<html:form action="orders" method="get" styleId="orderFormSearch" >

  <input id="ctxPath" type="hidden" value="<c:url value="/"/>">

  <html:text property="version" styleId="version"/>
  
   <html:text property="createBy" styleId="createBy"/>
   <html:text property="orderStates" styleId="orderStates"/>
   <html:text property="userId" styleId="userId"/>
   <html:text property="customerId" styleId="customerId"/>
   <html:text property="id" styleId="id"/>
   <html:text property="matterId" styleId="matterId"/>  
   
	<html:text property="carrierId" styleId="carrierId"/>
	
	<html:text property="carrIds" styleId="carrIds"/>

	<html:text property="customerForm.customerName" styleId="customerName"/>
	<html:text property="relationCode" styleId="relationCode"/>

	<html:text property="orderCode" styleId="orderCode"/>
	
	<html:text property="contractForm.code" styleId="contractCode"/>
	
	<html:text property="carrierType" styleId="carrierType"/>
	<html:text property="cutCates" styleId="cutCates"/>
	<html:text property="carrSort" styleId="carrSort"/>
	
	
	
	
	<html:text property="categoryId" styleId="categoryId"/>
    <!--存订单类别id	-->publishMemo
	<html:text property="orderMeno" styleId="orderMeno"/>
	
	<html:text property="publishMemo" styleId="publishMemo"/>
	
	<html:text property="orderPublicForm.publishStartDate" styleId="startDate"/>
	<html:text property="orderPublicForm.publishEndDate" styleId="endDate"/>
	matter.name:<html:text property="orderPublicForm.matterName" styleId="matterName"/>
	<html:text property="orderPublicForm.moneyState" styleId="moneyState"/>
	
	<html:text property="orderPublicForm.moneyRealpay" styleId="moneyRealpay"/>
	
</html:form>


<!--input type="text" name="moneyState" id="moneyState"/-->
</div>

<div style="display:none;">
<iframe src='about:blank'   scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
</div>

<form name="ReportForm" id="ReportForm">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="reportType" id="reportType" value="">
	<input type="hidden" name="relationCodeForm" id="relationCodeForm" value="">
	<input type="hidden" name="channelModelForm" id="channelModelForm" value="">
	
	<input type="hidden" name="orderStatesForm" id="orderStatesForm" value="">
	<input type="hidden" name="userIdForm" id="userIdForm" value="">
	<input type="hidden" name="createByForm" id="createByForm" value="">
	<input type="hidden" name="customerIdForm" id="customerIdForm" value="">
	<input type="hidden" name="orderCodeForm" id="orderCodeForm" value="">
	<input type="hidden" name="contractCodeForm" id="contractCodeForm" value="">
	<input type="hidden" name="carrierIdForm" id="carrierIdForm" value="">


	<input type="hidden" name="userNameForm" id="userNameForm" value="">
	<input type="hidden" name="customerNameForm" id="customerNameForm" value="">
	<input type="hidden" name="isArriersForm" id="isArriersForm" value="">
	<input type="hidden" name="moneyRPayForm" id="moneyRPayForm" value="">
	<input type="hidden" name="startDateForm" id="startDateForm" value="">
	<input type="hidden" name="endDateForm" id="endDateForm" value="">
	<input type="hidden" name="categoryForm" id="categoryForm" value="">
	<input type="hidden" name="matterNameForm" id="matterNameForm" value="">
	<input type="hidden" name="selectImportOrderForm" id="selectImportOrderForm" value="">
	
	

	
	<input type="hidden" name="carrierTypeForm" id="carrierTypeForm" value="">
	<input type="hidden" name="cutCatesForm" id="cutCatesForm" value="">
	<input type="hidden" name="carrSortForm" id="carrSortForm" value="">
	
</form>
<script type="text/javascript">
    highlightTableRows("orderList");
</script>
