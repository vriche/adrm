<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="customerYearAnalyze.title"/></title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>			        
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/dwr/interface/FinanceTargetManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomePurposeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>	

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_start.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_nxml.js'/>"></script>    
		        
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/financeTarget.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomePurpose.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/analyze/customerYearAnalyzeService.js'/>"></script>	  	        
 
<content tag="heading"><fmt:message key="customerYearAnalyze.title"/></content> 
 
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr>   
                  
                   <td width="1px" id="orgId_td"> <select id="orgId"/></td>		
                   
	                 <td width="1px">    
	                		<div style="position:relative;overflow:visible">    
			            <input type="button"   class="button" id="btnSearche" value='查询'>
 						
						<div id="theDivSearch" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:550px;height:400px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1">	
                    
                 
               			 <table width="100%">
	                 
			              	 <tr><td align="left" colspan="5">&nbsp</td></tr>
			                 <tr>
			                 <td>
			                   	    <div style="position:relative;overflow:visible">
									<fmt:message key="orderForm.customerName"/><input  style="CURSOR: pointer;" size="12Px" name="customerName" id="customerName" type=text autocomplete=off value="">
									<div name="theDivCustomerName" id="theDivCustomerName" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:450px;height:250px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
							</div>
			                 </td>
			                 <td>	
	                 				<select id="query" style="CURSOR: pointer;" >
										<option value="1"><fmt:message key="orderDayInfoForm.button.displayIncome"/></option>
										<option value="2"><fmt:message key="orderDayInfoForm.button.incomePuton"/></option>
										<option value="3"><fmt:message key="orderDayInfoForm.datelength"/></option>
									</select>
							</td> 
							
							
							<td><label for="isPutYear" style="cursor: pointer;"><fmt:message key="analyzeBrand.putYear"/></label><input id="isPutYear" name="isPutYear" type='checkbox' value=0/></td>
							<td align="left" ><label for="isNotReturnValue" style="cursor: pointer;"><fmt:message key="incomePurposeDetail.notReturnValue"/></label><input id="isNotReturnValue" name="isNotReturnValue" type='checkbox' value=0/></TD>
								
							 </tr> 
							 
							 <tr><td align="left" colspan="5">&nbsp</td></tr>
							 <tr>
			                    <td align="left">
				                 </td>
				                 </tr>
				                 <tr><td align="left" colspan="5">&nbsp</td></tr>
								
								
								<tr>
								<td align="left" colspan="4">&nbsp</TD>
								</tr>
								
								<tr>
								<td align="left" colspan="4" id="incomePur">
								 <fieldset id="order_baseInfo_frm">
								 <legend> 
					           		 <!--到款用途-->
					            	<fmt:message key="incomeForm.incomePurposeId"/>
					            	
				            	</legend>
								<input type="checkbox" name="incomepurposeRN" id="incomepurposeRN">
								</fieldset>
								</td>
								 
								</tr>
								
								 <tr><td align="left" colspan="5">&nbsp</td></tr>		
								
				                 <tr>
				                  <td align="left">
				              		      <input  style="CURSOR: pointer;" type="button"  id="search" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="orderDayInfoForm.button.search"/>&nbsp;&nbsp;&nbsp;&nbsp;'>
			                          	  <input  style="CURSOR: pointer;" type="button" id="btnSearcheClose" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.cancel"/>&nbsp;&nbsp;&nbsp;&nbsp;'>
				                 </td>
				            
				                 <td align="left" colspan="4">&nbsp</td>
				                 </tr>

			
							</table>	 
                    	 </div>
                     
	                 </td>
	                 
	                 
	
                    
                    <td  width="1%" align="left" valign="left"><div id="printReportDiv" name="printReportDiv"/></td>
                    <td>&nbsp</td>
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
 
 
 <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
	    <td valign="top">
			<table width="100%" border="0">
				<tr>
				<td>
						<div id="adResCount" >
							
							<div id="gridbox" width="100%" height="100%" style="background-color:white;"/>		
						</div>	

	      		</td>
	      		</tr>
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
<div style="display:none;">
customerId:<input name="customerId" type="text" id="customerId">
customerCategoryId:<input name="customerCategoryId" type="text" id="customerCategoryId">
<input id="ctxPath" type="hidden" value="<c:url value="/"/>">
</div> 
<iframe style="display:none" src='about:blank'   scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
<form name="ReportForm" id="ReportForm" method="post">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="reportType" id="reportType" value="">
	<input type="hidden" name="type" id="type" value="">
	<input type="hidden" name="size" id="size" value="">
	<input type="hidden" name="headers" id="headers" value="">

	<input type="hidden" name="userName" id="userName" value="">
	<input type="hidden" name="customerIdForm" id="customerIdForm" value="">
	<input type="hidden" name="channelModelParam" id="channelModelParam" value="">

	<input type="hidden" name="putYearForm" id="putYearForm" value=""> 
	<input type="hidden" name="returnValue" id="returnValue" value=""> 
	<input type="hidden" name="incomPurs" id="incomPurs" value=""> 
	
</form>
