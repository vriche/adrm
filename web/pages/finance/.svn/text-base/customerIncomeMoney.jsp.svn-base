<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="customerIncomeMoney.heading"/></title>
<content tag="heading"><fmt:message key="customerIncomeMoney.title"/></content>
<meta name="menu" content="IncomeMenu"/>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />




<script type="text/javascript" src="<c:url value='/scripts/class/incomePull.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/income.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomePurpose.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_start.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_start.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_nxml.js'/>"></script> 
  
<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/dwr/interface/IncomeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomePurposeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomePullManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/analyze/customerIncomeMoneyService.js'/>"></script>

<script>
function console(obj){
$("searchArea").show();
//obj.setAttribute("value","<fmt:message key="button.done"/>");
}

</script>


<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom">

                  <table border="0" cellpadding="0" cellspacing="1" width="100%">
                  
                  <tr>
                  
                        <td width="1%" id="orgId_td"> <select id="orgId"/></td>		

	                  	
                        <td width="1px" >
                    
                       <div style="position:relative;overflow:visible">    
		                 <input type="button"   class="button" id="btnSearche" value='查询'>
 						
						<div id="theDivSearch" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:550px;height:400px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1">	
                    
                        <table width="100%">
                        
                         <tr> <td  colspan="3">&nbsp;</td></tr>
                    
                        <tr>
                            <td  align="left"><div id="theDivCustomerName"/></td>
		                    <!-- td  align="left" ><fmt:message key="orderForm.customerName"/><input  style="CURSOR: pointer;" size="12Px" name="customerName" id="customerName" type=text autocomplete=off value=""></td -->
						    <td  align="left">频道名称<input name="carrierName" id="carrierName" size="12px" type="text" autocomplete=off/> </td>
						    <td><fmt:message key="orderForm.userId"/><input name="userOwner" id="userOwner" size="12px" type="text" autocomplete=off/></td>
		                </tr>
		                
		                 <tr> <td  colspan="3">&nbsp;</td></tr>
		                
		                 <tr>
                        	<td  align="left"><fmt:message key="orderDayInfoForm.startDate"/><input size="10px" type ="text" id ="beginDate"></td>
						    <td><fmt:message key="orderDayInfoForm.endDate"/><input size="10px" type ="text" id ="overDate"></td>
                            <td></td>
                         </tr>
                         
                          <tr> <td  colspan="3">&nbsp;</td></tr>
                          
                          <tr>
                         
  								<td>
											<table><tr><td><input name="radiobutton" id="radiobutton" type="radio" value="1" >
					                          <!-- 余款 --> 
											  <fmt:message key="balanceMoney"/><input name="radiobutton" id="radiobutton" type="radio" value="2" checked>
					                          <!-- 所有 -->
											  <fmt:message key="allMoney"/>
											  </td>
						                      </tr>
						                  </table>					
								
			                    </td>    
			                      
			                      
			              <td><label for="isPutYear" style="cursor: pointer;"><fmt:message key="analyzeBrand.putYear"/></label><input id="isPutYear" name="isPutYear" type='checkbox' value=0/></td>
                       
                          	<td>   </td>    
                            
                         </tr>
                         
                          <tr> <td colspan="3">&nbsp;</td></tr>
                         
                           <tr> <td  id="incomePur" colspan="3"><input type="checkbox" name="incomepurposeRN" id="incomepurposeRN"></td></tr>
                           
                            <tr> <td  colspan="3">&nbsp;</td></tr>
                            
                            <tr> 
                            <td colspan="3">
                            <input type="button" name="search" id="query" value="&nbsp;&nbsp;<fmt:message key="orderDayInfoForm.button.search"/>&nbsp;&nbsp;"/> 
                            <input  style="CURSOR: pointer;" type="button" id="btnSearcheClose" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.cancel"/>&nbsp;&nbsp;&nbsp;&nbsp;'>
                            </td>
                            
                            </tr>
                         
                         </table>
                         </div>
                         
                         </td>
                        
                        	
	 					<td  width="1%"><div id="printReportDiv" name="printReportDiv"/></td>
	 					 <td></td>
                       </tr></table>
                       
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
         			<table width="100%" border="0" cellpadding="0" cellspacing="0">

	              <table width="100%" border="0" cellpadding="0" cellspacing="0">
	                   <tr>
			   			 <td>
						<table width="100%" border="0">
							<tr><td>
							<div id="gridbox" width="100%" height="100%" style="background-color:white;"></div>
						
						</td></tr>
				 </table>
					 
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


<div style="display:none">
customerId:<input name="customerId" type="text" id="customerId">
userdid:<input name="userId" type="text" id="userId">
customerCategoryId:<input name="customerCategoryId" type="text" id="customerCategoryId">

</div>

<div style="display:none;">
</div>




<iframe src='about:blank' style="display:none"   scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
<form name="ReportForm" id="ReportForm"  method="post">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="reportType" id="reportType" value="">
	
	<input type="hidden" name="startDateForm" id="startDateForm" value="">
	<input type="hidden" name="endDateForm" id="endDateForm" value="">
	<input type="hidden" name="customerIdForm" id="customerIdForm" value="">
	<input type="hidden" name="carrierNameForm" id="carrierNameForm" value="">
	<input type="hidden" name="userOwnerForm" id="userOwnerForm" value="">
	<input type="hidden" name="arrearsForm" id="arrearsForm" value="">
	<input type="hidden" name="incomepurposeForm" id="incomepurposeForm" value="">
	<input type="hidden" name="putYear" id="putYear" value=""> 
	<input type="hidden" name="usrNameForm" id="usrNameForm" value="">
	<input type="hidden" name="channelModelParam" id="channelModelParam" value="">
	<input type="hidden" name="orgIdForm" id="orgIdForm" value="">
	
</form>