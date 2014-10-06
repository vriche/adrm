<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title>订单列表</title>
<content tag="heading">订单列表</content>
<meta name="menu" content="OrderMenu"/>
         
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />



<!-- script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script -->
<!-- script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script -->
<!-- script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script -->


<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_srnd.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_link.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlxgrid_excell_sub_row.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_combo.js'/>"></script>




<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_selection.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_nxml.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/ext/dhtmlXGrid_ssc.js'/>"></script>

<!-- script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_dload.js'/>"></script -->

<!-- script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/ext/dhtmlxgrid_filter.js'/>"></script -->



<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/utils.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>



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
<script type="text/javascript" src="<c:url value='/scripts/class/orderDetail.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderPublic.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/specific.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>

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
<script type="text/javascript" src="<c:url value='/scripts/order/orderListNewService.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/PublishArrangeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDetailManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/MessageBox.js'/>"></script>



<!-- title><fmt:message key="orderDetail.title"/></title>
<content tag="heading"><fmt:message key="orderDetail.heading"/></content -->

<div style="display:none">
<form name="orderListForm" id="orderListForm" method="post"/>

</div>




<div style="display:block" id="orderListForm_div"  height="100%" width="100%">

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tbody>
                  <tr> 
                  
                  
                  <td width="1px"><select id="order_year"  style="CURSOR: pointer;" /></td>
                  
                  <!-- td width="1px">
                     <select id="order_year">
						     <% for(int i= 2008; i< 2014;i++){ %>
						   		 <option  value="<%=i%>"><%=i%></option>
					         <%}%>
					 </select>
                  </td -->
	    
	      	<td width="1px" id="div_orgId"><select name=orgId" id="orgId"/>  </td>

               
         
           <td width="1px"  id="TDcarrierType" style="display:none">
							<select name=carType" id="carType" > 
							    <!-- option value="">选择.. </option -->
								<option value="1" >时段 </option>
								<option value="3" >栏目</option>
							</select>	
			</td>		

					
		 <td width="1px"  id="TDcustomerCategorys">	
				<select name="customerCategorys" id="customerCategorys"/>					
		</td>	
		
		
	
  				
					
						
					
           <td width="1px">
                
                
             <!--查询-->
		    <div style="position:relative;overflow:visible">                 	
			
			<input type="button"    class="button"  id="btn_searche" value='查询'  onmouseover="this.className='button mouseover'"  onmouseout="this.className='button'"> 
 			
			
			<div id="theDivSearch" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:500px;height:400px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1">	
                    
   
	                  <table width="100%">
	                  <tr>
	                    <td align="left">
	 						<div style="position:relative;overflow:visible;">
	 						 <fmt:message key="orderForm.customerName"/>:
	 						 
	 						<div  id="theDivCustomerName"/>            
						
								
	                    </td>
	                    
	                    <td align="left">
	                            业务员:
	                         <div id="signUserDiv">
	 						<!-- select name="userOwner" id="userOwner"/ -->
	                    </td>  
	                    
	                    <td align="left">
	                     	录入员:
	                     	 <div id="createByIdDiv">
	 						<!-- select name="createById" id="createById"/ -->
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
				             					<fmt:message key="orderList.isArrears2"/>:
					                     	    <select name="isArrears" id="isArrears"> 
													<option value="0"><fmt:message key="orderList.isArrears"/></option>
													<option value="2"><fmt:message key="orderList.arrears"/></option>
													<option value="1"><fmt:message key="orderList.noArrears"/></option>
												</select>
	                    </td>
	                    
	                    <td align="left"><fmt:message key="orderForm.categoryId"/>:<div id="orderCategoryIdDiv"></td>  
	                    
	   
	                    
	 	              <td align="left">	
	                    
						     <div id="order_div" style="position:relative;overflow:visible;">
						       <fmt:message key="publishedInfoForm.matterName"/>:
								<input size="12px" name="matter.name" id="matter.name" type=text autocomplete=off value="">
						                    	
	                    	
			           </td>	
	                    

	   
	                    <td align="left"><fmt:message key="resourceChannelForm.name"/>:<input name="carrierName" id="carrierName" size="12px" type="text" autocomplete=off/></td>
	                            
	     		        <td align="left"></td>
	                    
	                    </tr>	                    
	                    
	                    
	                  <tr><td align="left" colspan="5">&nbsp</td></tr>
	                    
	                  <tr>
	                  
	                   	<td align="left">
							<fmt:message key="orderDetailForm.orderId"/>:&nbsp;<input size="12px" name="order_code" id="order_code" type=text  value="">		
	     		    	</td>
	     		    
	     		    	<td align="left">
							<fmt:message key="contractForm.code"/>:&nbsp;<input size="12px" name="contract_code" id="contract_code" type=text  value="">
	     		    	</td>	
	                  
	                    <td align="left">
							<fmt:message key="orderForm.relationCode"/>:&nbsp;<input type ="text" id ="relation_code" size=12 value=""/>		
	     		   		</td>
	                    
	                    <td align="left" ><fmt:message key="contractPaymentForm.incomeModeId"/>:
							<select name=moneyRPay" id="moneyRPay"> 
								<option value="0">付款情况 </option>
								<option value="1">应付金额为0</option>
								<option value="2">应付金额大于0</option>
							</select>		
	     		    	</td>
	     		    
	     		    
	                    <td align="left"></td>
	     		    
	                 </tr>
	                 
	                 <tr><td align="left" colspan="5">&nbsp</td></tr> 
												
					<tr>	
						
						<td align="left" >
	                		<fmt:message key="orderDayInfoForm.startDate"/>:&nbsp;<!-- input type ="text" id ="beginDate" size=11/ -->
	                		<div id="beginDateDiv" name="beginDateDiv" />
						</td>
						 <td> 
						 				<fmt:message key="orderDayInfoForm.endDate"/>:&nbsp;<!-- input type ="text" id ="overDate" size=11/ --> 
						 				<div id="overDateDiv" name="overDateDiv" />
						 </td>
						 

						 <td> 订单备注:&nbsp;<input type ="text" id="orderMeno" size=11/> </td>
						      
						 <td>
						 
						     <input id="isDayRealPlay" name="isDayRealPlay" type='checkbox' value=0/> <label for="isDayRealPlay" style="cursor: pointer;">根据时间看投放</label>
							
							 <div style="display:none">
						      		<select name="resourceSortId" id="resourceSortId" " />
						      </div>
						  </td> 
						   <td align="left"></td>
					</tr> 
	                 
	                <tr><td align="left" colspan="5">&nbsp</td></tr> 
	                
	                
      
	                
	                
	                 	                 
	                <tr>
	                	<td align="left">投放金额:<input type="text" id="orderRelPay" size="11"/></td>
	                	<td align="left">
	                	
											      <table id="search_order_rate_table" width="80%" border="0" cellpadding="0" cellspacing="0" >
											          
											         <tr> 
										            <td colspan="5">折扣范围:</td>
										          </tr>										      
											      
										          <tr> 
										            <td align="left"><input type="text" id="orderRate1" name="orderRate1" size="3"/></td>
										            <td width="0px">%</td>
										            <td width="0px">－</td>
										            <td align="left"><input type="text" id="orderRate2" name="orderRate2" size="3"/></td>
										            <td width="0px">%</td>
										          </tr>
										      	</table> 
	                	</td>
												<td align="left">&nbsp</td>
												<td align="left">&nbsp</td>
												<td align="left">&nbsp</td>
											</tr>
	                 
	                  <tr><td align="left" colspan="5">&nbsp</td></tr>   	                    
	                     </table>
                     
                     

                 
                     <input style="CURSOR: pointer;" type="button"  id="query" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.confim"/>&nbsp;&nbsp;&nbsp;&nbsp;'>
					 <input style="CURSOR: pointer;" type="button" id="btn_reset_query" value='&nbsp;&nbsp;&nbsp;&nbsp;重置&nbsp;&nbsp;&nbsp;&nbsp;'>
                     <input style="CURSOR: pointer;" type="button" id="btn_searche_close" value='&nbsp;&nbsp;&nbsp;&nbsp;关闭&nbsp;&nbsp;&nbsp;&nbsp;'>
                    
                    
                    
                  
                    
                     </div>
                     
                       </td>
	                     
  	                    
                           <td width="1px"> <input type="button"    class="button"  id="btn_no_passOrder" value='未通过' onmouseover="this.className='button mouseover'"  onmouseout="this.className='button'"> </td>
                           <td width="1px"> <input type="button"    class="button"  id="btn_no_submitOrder" value='待提交' onmouseover="this.className='button mouseover'"  onmouseout="this.className='button'"> </td>             
                           <td width="1px"> <input type="button"    class="button"  id="btn_no_checkedOrder" value='待审核' onmouseover="this.className='button mouseover'"  onmouseout="this.className='button'"> </td>             
                           
                    
	         

     
	                      <td width="1px"> 
	                      <!-- a href="#" id="Btn_AllOrder" class="button">&nbsp;&nbsp;&nbsp;&nbsp;刷新&nbsp;&nbsp;&nbsp;&nbsp;</a -->
	                      <input type="button"    class="button"  id="Btn_AllOrder" value='刷新' onmouseover="this.className='button mouseover'"  onmouseout="this.className='button'"> 
	                      </td>       
                     
					   <!-- adrm_order:authorizeTag res="tag_orderList_print" -->	
					       <!-- /adrm_order:authorizeTag -->    
					        

				  
				      
				      
				      	  <!-- adrm_order:authorizeTag res="tag_orderList_new" -->	  <!-- /adrm_order:authorizeTag -->      
	                     	<td width="1px">
	                     	<input type="button"    class="button"  id="Btn_addNewOrder" value='新添' onmouseover="this.className='button mouseover'"  onmouseout="this.className='button'"> 
	                     	</td>	 
	                      
	                       <td width="1px"><input type="button"   class="button" id="add_new_OrderDetail_more" value='快速下单'  onmouseover="this.className='button mouseover'"  onmouseout="this.className='button'"></td> 
					              
	                      
	                       	<td width="1px">
	                     	<input type="button"    class="button"  id="Btn_printProve" value='播出证明' onmouseover="this.className='button mouseover'"  onmouseout="this.className='button'"> 
	                     	</td>	 
	                       
						 <td id="selectOrder_div" style="display:none">   	                        
							                      <select name="selectOrder" id="selectOrder" align='center'> 
														<option value="0"> &nbsp;&nbsp;所有订单&nbsp;&nbsp; </option>
														<option value="1"> &nbsp;&nbsp;普通订单&nbsp;&nbsp; </option>
														<option value="2"> &nbsp;&nbsp;导入订单&nbsp;&nbsp; </option>
												</select>
										      
										
					     </td>

							
				      		<td width="1px" ><div id="printReportDiv" name="printReportDiv"/></td>
	                      
	         	<!-- td><a href="#" id="Btn_myOrder" class="button">&nbsp;&nbsp;<fmt:message key="orderForm.legend5"/>&nbsp;&nbsp;</a> </td -->
                    
            
 						<td></td>     
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
	
			 <div id="gridbox" height="100%" width="100%" style="background-color:white;z-index:0"></div>
           
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

		<div style="display:none;">

  
  			<input id="model" type="hidden" value="">
  
  			<input id="reportType" type="hidden" value="">
  
     <div id="gridbox3" width="100%" height="100%" style="background-color:white;"></div>	
      <div id="gridbox4" width="100%" height="100%" style="background-color:white;"></div>	
      

			 </div>					 
  </div>





