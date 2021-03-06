<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="orderDayInfoForm.customer.title"/></title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />


<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_start.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_nxml.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDayInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomePurposeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/BranchManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CategoryManager.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDayInfo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomePurpose.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/branch.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/category.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/searchWin.js'/>" charset="gbk"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/SearchManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resourceType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/ComboBoxTree.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/localStorage/store.min.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/analyze/customerAnalyzeService.js'/>"></script>



<content tag="heading"><fmt:message key="orderDayInfoForm.customer.title"/></content>

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
                    <td width="1px"><select id="order_year"  style="CURSOR: pointer;" /></td>
                
                   
                 
                    <td align="left" width="1px" >

               		<div style="position:relative;overflow:visible">   

			 		   <input type="button"   class="button" id="btnSearche" value='查询'>
 				
						<div id="theDivSearch" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:600px;height:400px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1">	
                    
                 
               			 <table width="100%">
	                 
			              	 <tr><td align="left" colspan="5">&nbsp</td></tr>
			              	 
			                 <tr>
					                 <td>
						                 <div style="position:relative;overflow:visible">
												<fmt:message key="orderForm.customerName"/><input  style="CURSOR: pointer;" size="12Px" name="customerName" id="customerName" type=text autocomplete=off value="">
												<div name="theDivCustomerName" id="theDivCustomerName" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:460px;height:250px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
										</div>
									 </td>
							
									<td id='orgTreeBox'> 
									     <div  style="position:relative;overflow:visible">
									      		<fmt:message key="orderForm.userId"/><input name="userOwner1" id="userOwner1" size="12px" type="text" autocomplete=off/>
									      		 <div id="sysOrgTreebox" 
													 style="position:absolute;OVERFLOW: auto;left:0px;top:21px;width:300px;height:300px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"; 
												 >
													<input  style="CURSOR: pointer;" type="button" id="btn_treeConfirm" value="&nbsp;<fmt:message key="button.confim"/>&nbsp;"/> 
							        				<input  style="CURSOR: pointer;" type="button" id="btn_treeCancel" value="&nbsp;<fmt:message key="button.cancel"/>&nbsp;"/> 
												 </div>
										</div>  
									</td>
									
			                 		<td id='userSelect'><select name="userOwner" id="userOwner"/> </td>
			                 		
					                 <td>
						                  <div  style="position:relative;overflow:visible">
										      		<fmt:message key="carrierForm.channelId"/><input name="carrierName" id="carrierName" size="12px" type="text" autocomplete=off/>
										      		 <div id="carrierTree" 
														 style="position:absolute;OVERFLOW: auto;left:0px;top:21px;width:150px;height:300px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"; 
													 >
														<input  style="CURSOR: pointer;" type="button" id="btn_carrierTreeConfirm" value="&nbsp;<fmt:message key="button.confim"/>&nbsp;"/> 
								        				<input  style="CURSOR: pointer;" type="button" id="btn_carrierTreeCancel" value="&nbsp;<fmt:message key="button.cancel"/>&nbsp;"/> 
													 </div>
											</div>  
					                 </td>
			                 
			                      
			                       <td>&nbsp</td>
			                 
							 </tr> 
							 
							 <tr><td colspan="5">&nbsp</td></tr>
							 
							 <tr><td colspan="5"></td></tr>
							 
							 
				             <tr><td  colspan="5">&nbsp</td></tr>
								 
				             <tr>
								 <td><fmt:message key="orderDayInfoForm.startDate"/><input style="CURSOR: pointer;"  type ="text" id ="beginDate" size=11></td>
								 <td><fmt:message key="orderDayInfoForm.endDate"/><input style="CURSOR: pointer;"  type ="text" id ="overDate" size=11></td>

								  <td align="left" width="1px"  >
											<table width="100%">
											<tr>
											<td width="100px">星期</td>
											<td width="1px" align="left"><div id="weekDiv" name="weekDiv"/></TD>
											<td >&nbsp</td>
											</tr>
											</table>
									</td>					             
					             
	
					             <td>&nbsp</td>
					             <td>&nbsp</td>
							</tr>
							
								<tr><td align="left" colspan="5">&nbsp</TD></tr>
								
								<tr>
									<td align="left" >
											<table width="100%">
											<tr>
											<td width="1px"><input id="isNotReturnValue" name="isNotReturnValue" type='checkbox' value=0/></TD>
											<td width="53px"><label for="isNotReturnValue" style="cursor: pointer;"><fmt:message key="incomePurposeDetail.notReturnValue"/></label></td>
											<td >&nbsp</td>
											</tr>
											</table>
									</td>
									
									
									<td align="left" >
											<table width="100%" >
											<tr>
											<td width="1px"><input id="isPutYear" name="isPutYear" type='checkbox' value=0/></TD>
											<td width="60px"><label for="isPutYear" style="cursor: pointer;"><fmt:message key="analyzeBrand.putYear"/></label></td>
											<td >&nbsp</td>
											</tr>
											</table>
									</td>	
									
									
									<td align="left" >
											<table width="100%" >
											<tr>
											<td width="1px"><input id="isMoreCustomer" name="isMoreCustomer" type='checkbox'  value=0/></TD>
											<td width="60px"><label for="isMoreCustomer" style="cursor: pointer;">客户多选</label></td>
											<td >&nbsp</td>
											</tr>
											</table>
									</td>									
									
					
									
						            <td>
											<table width="100%"  id="resourceType_table">
											<tr>
											<td width="100px">分类</td>
											<td width="1px"><div id="resourceType_div"/></TD>
											<td >&nbsp</td>
											</tr>
											</table>

									</td>
									<td>&nbsp</td>
									
								
								</tr>
								
								<tr>
									<td align="left" colspan="5"></TD>
								</tr>
								
								<tr>
									<td align="left" colspan="5" id="incomePur">
										 <fieldset id="order_baseInfo_frm">
										 <legend>到款用途</legend>
										 <input type="checkbox" name="incomepurposeRN" id="incomepurposeRN">
										</fieldset>
									</td>
								</tr>
								
								
								
						         <tr><td align="left" colspan="5">&nbsp</td></tr>		
						         
						         <tr>
								
					                  <td align="left" colspan="5">欠款统计方式:
											<select name="select_qiankuan" id="select_qiankuan"  style="CURSOR: pointer;" > 
												<option value="0" >欠款 = 投放-分配</option>
												<option value="1" >欠款 = 投放-到帐</option>
											</select>	
					                 </td>
				                 </tr>
						         
						     <tr><td align="left" colspan="5">&nbsp</td></tr>		     
								
				                 <tr>
					                  <td align="left" colspan="5">
					                    <input  style="CURSOR: pointer;" type="button"  id="query" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="orderDayInfoForm.button.search"/>&nbsp;&nbsp;&nbsp;&nbsp;'>
				                        <input  style="CURSOR: pointer;" type="button"  id="btn_reset_query" value='&nbsp;&nbsp;&nbsp;&nbsp;重置&nbsp;&nbsp;&nbsp;&nbsp;'>
				                        <input  style="CURSOR: pointer;" type="button" id="btnSearcheClose" value='&nbsp;&nbsp;&nbsp;&nbsp;关闭&nbsp;&nbsp;&nbsp;&nbsp;'>
					                 </td>
				            
				                 	   
				                 </tr>
								 
				                 					
		
								
								
			
			</table>		 
					 
				
                    
                     </div>
                     	 
		

                       </td>
                       
                  
                          <td  width="1px" align="left" valign="left"><div id="printReportDiv" name="printReportDiv"/></td>
                          
                          
  						                     
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
           
			
							<table width="100%" border="0" cellpadding="0" cellspacing="0">
								<tr><td>
								<div id="gridbox" width="100%" height="100%" style="background-color:white;z-index:0"></div>
							</td></tr>
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
carrierId:<input name="carrierId" type="text" id="carrierId">
customerCategoryId:<input name="customerCategoryId" type="text" id="customerCategoryId">
<input id="ctxPath" type="hidden" value="<c:url value="/"/>">
</div>


<div id="gridbox_brand" width="98%" height="100%" style="background-color:white;"/>

<iframe src='about:blank'   style="display:none" scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
<form name="ReportForm" id="ReportForm" method="post">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="reportType" id="reportType" value="">
	<input type="hidden" name="userIdForm" id="userIdForm" value="">
	<input type="hidden" name="userName" id="userName" value="">
	<input type="hidden" name="carrierNameForm" id="carrierNameForm" value="">
	<input type="hidden" name="startDate" id="startDate" value="">
	<input type="hidden" name="endDate" id="endDate" value="">
	<input type="hidden" name="customerIdForm" id="customerIdForm" value="">
	<input type="hidden" name="channelModelParam" id="channelModelParam" value="">
	<input type="hidden" name="nowUser" id="nowUser" value=""> 
	<input type="hidden" name="sortStr" id="sortStr" value=""> 
	<input type="hidden" name="putYear" id="putYear" value=""> 
	<input type="hidden" name="returnValue" id="returnValue" value=""> 
	<input type="hidden" name="incomPurs" id="incomPurs" value=""> 
	
</form>

