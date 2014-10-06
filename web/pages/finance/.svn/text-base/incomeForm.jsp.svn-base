<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="incomeDetail.title"/></title>
<content tag="heading"><fmt:message key="incomeDetail.heading"/></content>

<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/income.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomeMode.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomePurpose.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomePull.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/branch.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/class/category.js'/>"></script>

<!-- 自动下拉框 -->
<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/order/broArrange.js'/>"></script>

<!-- 日历 -->
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_drag.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_srnd.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_start.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomePullManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomeModeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomePurposeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/BranchManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/SysSequenceManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CategoryManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/resourceType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceTypeManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/finance/incomeFormService.js'/>"></script>




<input id="ctxPath" type="hidden" value="<c:url value="/"/>">

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom">
            <table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                    <td width="1px" ><input type="button"  class="button" id="btn_save" value='保存'> </td>
                    <td width="1px" ><input type="button"  class="button" id="btn_addIncome" value='新添'> </td>
                    <td width="1px" ><input type="button"  class="button" id="btn_delete" value='删除'> </td>
                    <td width="1px" ><input type="button"  class="button" id="btn_pull" value='分配'> </td>
                    <td width="1px" ><input type="button"  class="button" id="btn_cancel" value='返回'> </td>
                    <td width="1px" style="display:none"><input type="button"  class="button" id="btn_export" value='导出'>  </td>
                    <td>  &nbsp; </td>
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
    <td>
    
     
    
    
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td background="images/table1/textbox_left.gif" width="14"></td>
            <td bgcolor="#f4f3f4" >

               <div id="main_concst">
               
               <table><tr><td>&nbsp;</td></tr></table>   
               
               
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
				   <tr> 
				   <td width="40%">	    
				
					<table width="20%" border="0" cellspacing="0" cellpadding="0">
					<tbody>
					
					

					     <tr id="orgId_td"> 
									  <td  nowrap="nowrap" class="dataLabel">
									    	组织机构:
								        </td>
								    	<td width="1px"><select id="orgId2" name="orgId2"/></td>    	
						 </tr> 	
						
					
					
			      		<tr id="carrierName_row"> 
									  <td width="50%" nowrap="nowrap" class="requiredInput">
									    	<fmt:message key="orgForm.name"/>:
								        </td>
		
								        <td><select name="select" id="carrierName2"/></td>							
						</tr> 	
						
						

			
						
						
				  		<tr> 
						   <td width="50%" nowrap="nowrap" class="requiredInput">
						    	<fmt:message key="incomeForm.customerId"/>:
						    	
					        </td>

					        <td><div id="extCustomerDiv" name="extCustomerDiv" />
					            
								<div style="position:relative;overflow:visible;display:none">
									<input name="customerName" id="customerName" type=text autocomplete=off>
									<div id="theDivCustomerName" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:450px;height:250px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
								</div>	
							</td>							
						</tr> 
						
						
						 <tr> <!--业务员--> 
						      <td nowrap="nowrap" class="requiredInput"> <fmt:message key="orderForm.userId"/>:</td>
						      <td><div id="signUserDiv"/></td>
						    </tr>
					    <tr> 					
						
									
						
					    	<tr style="display:none"> 
						      <td nowrap="nowrap" class="requiredInput"> 
						      
						      <c:set var="isSignUserBalance" value='${appConfig["isSignUserBalance"]}'/>
						      <c:if test="${isSignUserBalance == '0'}">
  									<fmt:message key="business.name"/>:
							 </c:if>
							 <c:if test="${isSignUserBalance == '1'}">
  									<fmt:message key="moneyIn.name"/>:
							 </c:if>
						      
						      
						      </td>
						      <td><select name="userId" id="userId" style="width:140px;"/></td>
						    </tr>
						    
						    
						    
						    
						    
						    
					    <tr> 
						    <td width="50%" nowrap="nowrap" class="requiredInput">
						    	<fmt:message key="incomeForm.incomeCode"/>:       	
					        </td>
					        <td>
					        	<input name="incomeCode" type="text" id="incomeCode" style="width:140px;">
							</td>
						</tr>
						
					    <tr> 
						    <td width="50%" nowrap="nowrap" class="dataLabel">
						    	<fmt:message key="incomeForm.incomeDate"/>:       	
					        </td>
					        <td>
								<input name="incomeDates" type="text" id="incomeDates" readonly="true" style="width:140px;">
							</td>
						</tr>
						
						  <tr> 
						    <td width="50%" nowrap="nowrap" class="dataLabel">
						    	<fmt:message key="incomeForm.incomePullDate"/>:       	
					        </td>
					        <td>
								<input name="incomePullDate" type="text" id="incomePullDate" readonly="true" style="width:140px;">
							</td>
						</tr>
						
				  		<tr> 
						    <td width="50%" nowrap="nowrap" class="dataLabel">
						    	<fmt:message key="incomeForm.incomeModeId"/>:
					        </td>
					        <td>
					        	<select name="incomeModeId" id="incomeModeId"/>	
							</td>
						</tr> 
				
					    <tr> 
						    <td width="50%" nowrap="nowrap" class="dataLabel">
						    	<fmt:message key="incomeForm.incomeMoney"/>:       	
					        </td>
					        <td>
					        	<input name="incomeMoney" type="text" id="incomeMoney" style="width:140px;">	
							</td>
						</tr>
						<tr id='bank_id'> 
						    <td width="50%" nowrap="nowrap" class="dataLabel">
						    	<fmt:message key="customerForm.customerName"/>:       	
					        </td>
					        <td>
					        	<select name="accountId" id="accountId"/>
							</td>
						</tr>
				  		<tr> 
						    <td width="50%" nowrap="nowrap" class="dataLabel">
						    	<fmt:message key="incomeForm.incomePurposeId"/>:
					        </td>
					        <td>
					        	<select name="incomePurposeId" id="incomePurposeId"/>	
							</td>
						</tr> 
						<tr> 
						   <td width="50%" nowrap="nowrap" class="dataLabel">
						      <fmt:message key="sysResourceForm.memo"/>:
					       </td>
					       <td>
					         <textarea name="textarea" rows="3" cols="18" id="memo" style="width:180px;"></textarea>
						   </td>
						</tr> 
						
						<tr> 
						   <td width="50%" nowrap="nowrap" class="dataLabel">
						     <input name="sendMsg2User"  id="sendMsg2User" style="cursor:pointer" type="checkbox" checked />
					       </td>
					       <td>
					        
					          <label id="sendMsg2User_lable" for="sendMsg2User" style="cursor:pointer">:<fmt:message key="incomeForm.sendMsg2User"/></label>
					         <!-- html:checkbox styleClass="checkbox" property="sendMsg2User" styleId="sendMsg2User"/ -->
						   </td>
						</tr> 
				
					</tbody>
				 </table>
				 </td>
				 
				 	 <td valign="top" width="60%" align="left">
				<div id="incomePull_div" style="position:relative;OVERFLOW: auto;width:280px;visibility:inherit;border:solid white 2px;background-color:#f5f5f5;z-index:0">
			    <table id="incomePullTable" class=ListShort width="100%"  cellspacing="0" cellpadding="0">
	              <thead>
	                <TR class=Header> 
	                
	                
	                  <span>
			          <div id="hiddenArea" name="hiddenArea" style="display:none">
			               <select name="select" id="carrierName"/>                                               
			           </div> 
			           </span> 
			           

			           
			            <c:set var="withResourceSort" value='${appConfig["withResourceSort"]}'/>
			            
						<c:if test="${withResourceSort == '0'}">
			 	                  <!--频道名称-->
				                  <TH><fmt:message key="resourceChannelForm.name"/></TH>
						</c:if>
						
						
						<c:if test="${withResourceSort == '1'}">
			 	                  <!--资源分类-->
				                  <TH><fmt:message key="resourceForm.resourceType"/></TH>
						</c:if>
             
	                  
	                  <!--业务员-->
	                  <div id="hiddenUser" name="hiddenUser" style="display:none">
			               <select name="select" id="createName"/>                                               
			           </div>   
	                  <TH id='user_id'><fmt:message key="foretArrearageForm.userName"/></TH>
	                  <!--发票号-->
	                  <TH id='income_no'><fmt:message key="incomeDetail.id"/></TH>
	                  <!--划帐金额-->
	                  <TH><fmt:message key="incomeForm.incomePulls"/></TH>
	                  <!--己划账金额-->
	                  <TH><fmt:message key="incomeForm.ChannelbalanceMoney"/></TH>
	                  <!--剩余金额-->
	                  <TH><fmt:message key="incomeForm.balanceMoney"/></TH>
	                  <TH id="button_add_new_obj"  style="cursor:hand" colspan="3" onclick="button_add_new_obj(0)"> 
	                  		<img id="incomeImgAdd" name="incomeImgAdd"  src="<c:url value='/image/CRM_ADD.GIF'/>" border="0"> 
	                  </TH>
	                  
	                </TR>
	                
			                <tr > 
	                  <td colspan="10">
		                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
		                      <tr> 
		                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
		                      </tr>
		                    </table>
	                    </td>
	                </tr>
	              </thead>
	              
	              <tbody id="incomePullBody"/>
	              
	              <tbody id="incomePullBodySum"/>
	              
		</table>  
<!--<div id="gridbox" width="100%" height="100%" style="background-color:white;"></div>-->
				 </div>
				 
				 </td>
				 </tr>
				 </table>
				
				&nbsp;&nbsp;
				
				<!-- table width="26%" border="0" cellspacing="0" cellpadding="0">
					 <tr>
						<td>
							<div align="center">
              						<input style="CURSOR: pointer;" type="button" id="btn_save" value='&nbsp;<fmt:message key="button.save"/>&nbsp;'>
					              	<input style="CURSOR: pointer;" type="button" id="btn_delete" value='&nbsp;<fmt:message key="button.delete"/>&nbsp;'>
					              	<input style="CURSOR: pointer;" type="button" id="btn_pull" value='&nbsp;<fmt:message key="button.puton"/>&nbsp;'>
					              	<input style="CURSOR: pointer;" type="button" id="btn_cancel" value='&nbsp;<fmt:message key="button.cancel"/>&nbsp;'>
					                <input style="CURSOR: pointer;" type="button" id="btn_export" value='&nbsp;<fmt:message key="publishedInfoForm.button.export"/>&nbsp;'> 
					             
					        </div>
						 </td>
					</tr>
				</table -->

						<div style="display:none;">
						
						incomeId:<input name="incomeId" type="text" id="incomeId">
						<html:form action="saveIncome" method="post" styleId="incomeForm" >
						incomeId: <html:text property="id" styleId="id" />
						orgId:<html:text property="orgId" styleId="orgId" />
						customerId:<html:text property="customerId" styleId="customerId" />
						</html:form>
						customerCategoryId:<input name="customerCategoryId" type="text" id="customerCategoryId">
						</div>  
						
		    </div>				
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
			            <span>
			          	<div id="hiddenAreaa2" name="hiddenArea2" style="display:none">
			               <select name="resourceTypeName" id="resourceTypeName"/>                                           
			           </div> 
			           </span>  

 <input id="tag_orderList_finance" type="hidden" value="0">
 <adrm_order:authorizeTag res="tag_orderList_finance">
	<script>$("tag_orderList_finance").value = 1 ;</script>
</adrm_order:authorizeTag>





<div style="display:none;" >

	<table width="100%" border="0" cellpadding="0" cellspacing="0" id="regCustomer_table">
	
 			<tr>  <td>&nbsp;</td> </tr>      

          <tr> <td id="regCustomerCategoryName_td"> <div id="regCustomerCategoryName"></td> </tr>
          
      		<tr>  <td>&nbsp;</td> </tr>      
                    <tr> <td><div id="regCustomerDiv" name="regCustomerDiv" ></td> </tr>
           <tr> <td>&nbsp;</td> </tr>
           <tr> 
            <td width="100%" >
             
       
	                <!-- span><fmt:message key="orderForm.regCustomerGrid"/></span -->
	                  <center>
                 	<div id="gridbox_regCustomer" width="98%" height="97%" style="background-color:white;"/>
            
            </td>
          </tr>
            
      </table>
      
      <div id="treeGroup2">
      
      	<div><div id="carrierTypeTreebox2"   /></div>
										
		<div><div id="compagesTreebox2"/></div>
		
      </div>

<div>
