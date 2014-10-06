<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="incomeList.title"/></title>
<content tag="heading"><fmt:message key="incomeList.heading"/></content>
<meta name="menu" content="IncomeMenu"/>


<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXMenu/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />


<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_start.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_nxml.js'/>"></script> 


<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXTree_ed.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_drag.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_srnd.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_start.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid.js'/>"></script>





<script type="text/javascript" src="<c:url value='/dwr/interface/CategoryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ContractPaymentManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomePullManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomeUsedManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomeManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/popupWindow.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/utils.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/category.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/contractpayment.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomePull.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/income.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomePurpose.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/order/broArrange.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomeUsed.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/income.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/finance/incomeCountService.js'/>"></script>


<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
               
                    <td valign="top">

  	  				<table width="100%" id="radioList" border="0" cellpadding="0" cellspacing="0">
	          	  		<tr >
	          	  		
	          	  		  <td width="1px" id="orgId_td"> <select id="orgId" name="orgId"/> </td>
	    
		     
						    	          	  		
	          	  		  <td  align="middle"  width="120px" >
	          	  			
	          	  			  	  	<table width="100%" id="radioList" border="0" cellpadding="0" cellspacing="0">
				          	  		<tr>
					          	  			<td  align="right">
						          	  			<input type="radio" name="chooseRN" id="chooseCN" value="1"  checked>
						          	  			<!--label style="cursor: pointer;width:20px;" for="chooseCN"><fmt:message key="radio.putOn"/></label-->
										    </td>
										    
											<td  align="left">
						          	  			<!-- font color="#000000"><fmt:message key="radio.putOn"/></font -->
						          	  			<label style="cursor: pointer;width:20px; COLOR:RED;" for="chooseCN"><fmt:message key="radio.putOn"/></label>
						          	  		</td>
						          	  		<td  align="right">
						          	  			<input type="radio" name="chooseRN" id="chooseCN2" value="2" >
						          	  			<!--label style="cursor: pointer;width:20px;" for="chooseCN" ><fmt:message key="radio.putBack"/></label-->
						          	  		</td>
					          	  			<td  align="left">
						          	  			<!-- font color="#000000"><fmt:message key="radio.putBack"/></font -->
						          	  			<label style="cursor: pointer;width:20px;COLOR:RED;" for="chooseCN2" ><fmt:message key="radio.putBack"/></label>
						          	  		</td>	
	          	  			         </tr>
		                             </table>
						    </td>	   	
						    
		          	  	   <td width="1px" ><div id="extCustomerDiv2" name="extCustomerDiv2"/> </td>
						   <td width="1px" ><div id="extPaymentCode" name="extPaymentCode"/> </td>							    
						              	  		
	          	  		
	          	  		    <td width="1%" >&nbsp;</td>
	          	  		    
	          	  			<td  align="middle" >
	          	  			
	          	  			  	  	<table width="250px" id="radioList" border="0" cellpadding="0" cellspacing="0" >
				          	  		<tr>
				          	  		   
				          	  			<td  align="right">
					          	  			<input type="radio" name="chooseFAPAI" id="chooseFAPAI1" value="1"  checked>
									    </td>
										<td  align="left">
					          	  			<label id="lable_chooseFAPAI1" name="lable_chooseFAPAI1" style="cursor: pointer;width:20px;" for="chooseFAPAI1"><fmt:message key="button.balanceMode1"/></label>
					          	  		</td>
					          	  		<td  align="right">
					          	  			<input type="radio" name="chooseFAPAI" id="chooseFAPAI2" value="2" >
					          	  		</td>
				          	  			<td  align="left">
					          	  			<!-- font color="#000000"><fmt:message key="radio.putBack"/></font -->
					          	  			<label  id="lable_chooseFAPAI2"  name="lable_chooseFAPAI2" style="cursor: pointer;width:20px;" for="chooseFAPAI2" ><fmt:message key="button.balanceMode2"/></label>
					          	  		</td>		
	          	  			         </tr>
		                             </table>
						    </td>	  
						    
						    
						    
     	  		
	          	  							    
						    
						            	  		
       	  		
		          	  		
		          	  	</tr>
		          	  </table>                  
                    
                    
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

    <td valign="top">
          <table width="100%" border="0" cellpadding="0" cellspacing="0" >
              <tr>
                <td valign="top">
	                  <fieldset style="height:100%;width:100%">
	                  <legend><!-- 到款信息 --><fmt:message key="incomeList.heading"/>
	             
					  
					   <select id="income_year"  style="CURSOR: pointer;" />
				       <div style="display:none">
                        <input  name="vdtgvsddfsfsdfddqw" type='checkbox' value=0/>	
                        </div> 

		                      <!-- 显示分配明细 -->    
							&nbsp;&nbsp;&nbsp;
		          	  		<label for="displayBalanceDetail" id="displayBalanceDetailLabel" style="cursor: pointer;">
		          	  		<fmt:message key="incomeList.displayBalanceDetail"/>
		          	  		</label>
		          	  		<input id="displayBalanceDetail" name="displayBalanceDetail" type='checkbox' value=0/>	
					   	

	                  </legend>
	                  
					<div style="display:none">
						<!-- div id="title_flt_box"><input type="100%" style="border:1px solid gray;" onclick="(arguments[0]||window.event).cancelBubble=true;" onkeyup="filterBy()"></div -->
						
						<div id="paydt_flt_box"><select style="width:110%;margin-left:-10px;CURSOR: pointer;" onclick="(arguments[0]||window.event).cancelBubble=true;" onchange="filterBy()"/></select></div>
						 
						 
						 <c:set var="withResourceSort" value='${appConfig["withResourceSort"]}'/>
						 <c:if test="${withResourceSort == '0'}">
						 			<div id="title_flt_box"><select id="carrierId" style="width:110%;margin-left:-10px;CURSOR: pointer;" onclick="(arguments[0]||window.event).cancelBubble=true;" onchange="filterBy()"></select></div>
						 </c:if>
						 
						 <c:if test="${withResourceSort == '1'}">
						 			<div id="title_flt_box"><select id="resourceTypeId" style="width:110%;margin-left:-10px;CURSOR: pointer;" onclick="(arguments[0]||window.event).cancelBubble=true;" onchange="filterBy()"></select></div>
						 </c:if>
						 

						
						<div id="author_flt_box"><select  style="width:110%;margin-left:-10px;CURSOR: pointer;" onclick="(arguments[0]||window.event).cancelBubble=true;" onchange="filterBy()"></select></div>
						<div id="signuser_flt_box"><select id="signUserId" style="width:110%;margin-left:-10px;CURSOR: pointer;" onclick="(arguments[0]||window.event).cancelBubble=true;" onchange="filterBy()"></select></div>
						<div id="pulldate_flt_box"><select  style="width:110%;margin-left:-10px;CURSOR: pointer;" onclick="(arguments[0]||window.event).cancelBubble=true;" onchange="filterBy()"></select></div>
					</div>
	                <div id="gridbox_incomePull_div">   
						<div id="gridbox_incomePull" width="99%" height="98%" style="background-color:white;"></div>
	                </div> 
	                </fieldset>
                </td>
              </tr>
              <tr>
                <td valign="top" >

		            <fieldset style="height:100%;width:100%">
		            
		            	<legend>订单信息<select id="order_year"  style="CURSOR: pointer;" />&nbsp;&nbsp;&nbsp;</legend>
		            	
                        <div style="display:none">
                        <input  name="vdssfsdfsfsdf" type='checkbox' value=0/>	
                        </div> 
                        
				        <div id="gridbox_payment_div">   
							<div id="gridbox_payment" width="99%" height="98%" style="background-color:white;"></div>
		                </div> 

		            </fieldset>
   
				</td>
				
				
              </tr>
              
              <tr>

              	<td  align="middle" width="100%">
                      <center>
	                  <input  style="CURSOR: pointer;" type="button" name="btn_search" id="btn_search" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.puton"/>&nbsp;&nbsp;&nbsp;&nbsp;'> 
	               &nbsp;&nbsp;&nbsp;&nbsp;
	                  <input  style="CURSOR: pointer;" type="button" name="btn_cancel" id="btn_cancel" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.cancel"/>&nbsp;&nbsp;&nbsp;&nbsp;'> 
	                  
	            </td>
	            

		          
	         </tr>
	         
            </table>
<div style="display:none;">
customerId:<input name="customerId" type="text" id="customerId">
customerCategoryId:<input name="customerCategoryId" type="text" id="customerCategoryId">
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


 <input id="tag_orderList_finance" type="hidden" value="0">
 <adrm_order:authorizeTag res="tag_orderList_finance">
	<script>$("tag_orderList_finance").value = 1 ;</script>
</adrm_order:authorizeTag>


