<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title><fmt:message key="incomeList.title"/></title>
<content tag="heading"><fmt:message key="incomeList.heading"/></content>




<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />




<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_srnd.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_link.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_selection.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_nxml.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/ext/dhtmlXGrid_ssc.js'/>"></script>

<!-- script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/ext/dhtmlXgrid_colspan.js'/>"></script -->



<script type="text/javascript" src="<c:url value='/dwr/interface/ContractPaymentManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDetailManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDayInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomePurposeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/BranchManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CategoryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceChannelManager.js'/>"></script>

<!-- script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script -->
<!-- script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script -->
<!-- script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script -->



<script type="text/javascript" src="<c:url value='/scripts/class/contractpayment.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/specific.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDetail.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDayInfo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomePurpose.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomeMode.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/branch.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/category.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/income.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resourceChannel.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/class/category.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/extutils.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/resourceType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceTypeManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/ComboBoxTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.ux.NuberFiledFormat.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.ux.form.LovCombo.js'/>"></script>




<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/incomePull.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomePullManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/IncomeModeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomePurposeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CategoryManager.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/finance/incomeListNewService.js'/>"></script>




<input id="ctxPath" type="hidden" value="<c:url value="/"/>">


<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom">
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tbody>
                  <tr> 
                	  <td width="1px" id="orgId_td"> <select id="orgId" name="orgId"/> </td>
						<td width="1px"><select id="order_year"  style="CURSOR: pointer;" /></td>	
	
	                              	  
                      <td align="left" width="1px">
                      			<select name="month" id="month">  
                      				<option value="0">到款月份</option>
	                      			<option value="01"><fmt:message key="business.month.jan"/></option>
	                      			<option value="02"><fmt:message key="business.month.feb"/></option>
									<option value="03"><fmt:message key="business.month.mar"/></option>
									<option value="04"><fmt:message key="business.month.apr"/></option>
	                      			<option value="05"><fmt:message key="business.month.may"/></option>
									<option value="06"><fmt:message key="business.month.jun"/></option>
									<option value="07"><fmt:message key="business.month.jul"/></option>
	                      			<option value="08"><fmt:message key="business.month.aug"/></option>
									<option value="09"><fmt:message key="business.month.sep"/></option>
									<option value="10"><fmt:message key="business.month.oct"/></option>
	                      			<option value="11"><fmt:message key="business.month.nov"/></option>
									<option value="12"><fmt:message key="business.month.dec"/></option> 
								</select>
            </td>
                      
             <!-- td width="25px">开始</td>
 								 <td width="1px"><input style="CURSOR: pointer;"  type ="text" id ="beginDate" size=10></td>
                      
								 <td width="25px">结束</td>  
								 <td width="1px"><input style="CURSOR: pointer;"  type ="text" id ="overDate" size=10></td -->  
								 
								 
								  <td width="25px">开始</td>
								   <td align="left" width="1px"><div id="beginDateDiv" name="beginDateDiv" /></td>   
								   <td width="25px">结束</td>    
								   <td align="left" width="1px"><div id="overDateDiv" name="overDateDiv" /></td>     
								 
								               	  
        			 <!-- td align="left" width="1px"><select name="select" id="carrierName"/></td --> 
        			 
        			 <!-- td width="1px"><div id="extResourceTypeIdDiv" name="extResourceTypeIdDiv"/></td -->		
        			 
        		
                	  
                      <td align="left" width="1px">
                      	<select name="fenpeiInfo" id="fenpeiInfo">
                      			<option value="0">=所有到款=</option>
                      			<!-- option value="1">重新分配</option -->
                      			<option value="2">所有涨款</option>
                      			<option value="3">有欠款涨款</option>
                      			<option value="4">无欠款涨款</option>
																	<option value="5">分后有余款</option>
																	<option value="6">未分配过的</option>
															</select>
                      </td>     
                      
                                      <td align="left" width="1px">
		                      	<select name="fenpeiInfo2" id="fenpeiInfo2">
		                      			<option value="1">分配信息</option>
		                      			<option value="2">时段属性</option>
		                      			<option value="3">行业分类</option>
		                      			<option value="4">年度月份</option>
																	</select>
                      </td>            
                            
                         	  
                	   <td align="left" width="1px"><div id="extCustomerDiv" name="extCustomerDiv" /></td>       
                	  
            						<td width="1px"><input type="button"  id="btn_refresh"     class="button" value='刷新'></td>  
                	    <td width="1px"><input type="button"  id="btn_searche"     class="button" value='查询'></td>   
                        <td width="1px"><input type="button"  id="Btn_addIncome"     class="button" value='新添'></td> 
                        <td width="1px"><input type="button"  id="Btn_modIncome"     class="button" value='修改'></td>    
                        <td width="1px"><input type="button"  id="Btn_deleteIncome"  class="button" value='删除'> </td>
                        <td width="1px"><input type="button"  id="btn_returnPuton"  class="button" value='反款'> </td>
                        
                                           
                       <td width="1px"><div id="printReportDiv" name="printReportDiv"/></td>			
                       
              
                       	  
					  
                            <td>&nbsp;</td>
    
                    
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
          
          
          
     	<td>
     
	     <table border="0" cellpadding="0" cellspacing="0" width="100%">
	        <tbody>
	          <tr> 
	            <td background="images/table1/textbox_left.gif" width="14"></td>
	            <td bgcolor="#f4f3f4">
	            
	            
	             <table border="0" cellpadding="0" cellspacing="0" width="100%">
	             
	             <tr><td>
		             <table border="0" cellpadding="0" cellspacing="0" width="100%">
		             <tr>
			             <td width="70%">
						 <div id="gridbox" height="100%" width="100%" style="background-color:white;z-index:0"></div>
						 </td>
						 
			             <!-- td>
						 <div id="gridbox2" height="100%" width="100%" style="background-color:white;z-index:0"></div>
						 </td -->					 
					 </tr>
					  </table>
				 </td></tr>
	
	             <tr><td heigth="1px"><img src="<c:url value='images/s.gif'/>" height="2"></td></tr>		
				 
	             
	              <tr>
		             	<td>
						 							<div id="gridbox3" height="100%" width="100%" style="background-color:white;z-index:0"></div>
						 					</td>
				 						</tr>	
				 						
				 						
					
				 										 						
				 		 
				 </table>
				 
				 
				 
				 
	            </td>
	            <td width="14" background="images/table1/textbox_right.gif"></td>
	          </tr>
	        </tbody>
	      </table>
      
      	</td>         
          
          
          
          
          
          
          
          
          
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
 <div id="gridbox2" height="100%" width="100%" style="background-color:white;z-index:0"></div>
 
 
 
 
 <table width="100%" border="0" cellpadding="0" cellspacing="0" id="regCustomer_table">
	
 			 <tr> <td colspan="2">&nbsp;</td> </tr>   

           <tr> 
	           <td  colspan="2" id="regCustomerCategoryName_td"> 
		            <!-- fieldset><legend></legend> </fieldset -->
		          		 <div id="regCustomerCategoryName">
	           </td> 
           </tr>
           <tr> 
	           <td heigth="2px" bgcolor="black" colspan="2"></td> 
           </tr>
           
      		 <tr> <td colspan="2">&nbsp;</td> </tr>
      		  
            <tr> 

              <td><div id="regCustomerDiv" name="regCustomerDiv"></td> 
              <td><div id="regCustomerAreaDiv" name="regCustomerAreaDiv"></td> 
  			  <1-- td><div id="regCustomterLinkManDiv" name="regCustomterLinkManDiv"></td --> 
  			
            </tr>
           <tr> <td colspan="2">&nbsp;</td> </tr>
           <tr> 
            <td width="100%" colspan="2">
	                <!-- span><fmt:message key="orderForm.regCustomerGrid"/></span -->
	                  <center>
                 	<div id="gridbox_regCustomer" width="98%" height="97%" style="background-color:white;"/>
            
            </td>
          </tr>
            
      </table>
</div>


<div style="display:none">
	<div id="orderId_flt_box"><select style="width:100%;margin-left:0px;CURSOR: pointer;" onclick="(arguments[0]||window.event).cancelBubble=true;" onchange="filterBy()"/></select></div>				
	<div id="month_flt_box"><select style="width:100%;margin-left:0px;CURSOR: pointer;" onclick="(arguments[0]||window.event).cancelBubble=true;" onchange="filterBy()"/></select></div>
	<div id="channel_flt_box"><select  style="width:100%;margin-left:0px;CURSOR: pointer;" onclick="(arguments[0]||window.event).cancelBubble=true;" onchange="filterBy()"></select></div>
	<div id="resort_flt_box"><select id="signUserId" style="width:100%;margin-left:0px;CURSOR: pointer;" onclick="(arguments[0]||window.event).cancelBubble=true;" onchange="filterBy()"></select></div>
	<div id="adname_flt_box"><select  style="width:100%;margin-left:0px;CURSOR: pointer;" onclick="(arguments[0]||window.event).cancelBubble=true;" onchange="filterBy()"></select></div>
</div>


<div style="display:none">
						 							<div id="gridbox4" height="100%" width="100%" style="background-color:white;z-index:0"></div>
	
</div>

<div style="display:none">
						 							<div id="gridbox5" height="100%" width="100%" style="background-color:white;z-index:0"></div>
			
</div>

<!-- form name="ReportForm" id="ReportForm">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="reportType" id="reportType" value="">
	<input type="hidden" name="startDateForm" id="startDateForm" value="">
	<input type="hidden" name="endDateForm" id="endDateForm" value="">
	<input type="hidden" name="startDatePullForm" id="startDatePullForm" value="">
	<input type="hidden" name="endDatePullForm" id="endDatePullForm" value="">
	<input type="hidden" name="customerNameForm" id="customerNameForm" value="">
	<input type="hidden" name="resourceCarrierIdForm" id="resourceCarrierIdForm" value="">
	<input type="hidden" name="customerIdForm" id="customerIdForm" value="">
	<input type="hidden" name="currentUser" id="currentUser" value="">
	<input type="hidden" name="incomePullDateForm" id="incomePullDateForm" value="">
	<input type="hidden" name="orgIdForm" id="orgIdForm" value="">
	<input type="hidden" name="incomeCodeForm" id="incomeCodeForm" value="">
</form -->



