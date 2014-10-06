<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="brandAnalyze.title"/></title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />


<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>


<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>		        
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDayInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/AnalyseManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterManager.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_start.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_nxml.js'/>"></script>  


<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>     
		        
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDayInfo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrierType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/analyzeClass.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/order.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDetail.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/matter.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/specific.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/income.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomePurpose.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/analyze/brandAnalyzeService.js'/>"></script>

<content tag="heading"><fmt:message key="brandAnalyze.title"/></content>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            
            
               <td width="1%" id="orgId_td"> <select id="orgId"/></td>
                <td width="1px"><select id="resource_year"  style="CURSOR: pointer;" /></td>	

               
               
			  <td align="left" width="1px" >
			
			               		<div style="position:relative;overflow:visible">   
			
						 		   <input type="button"   class="button" id="btnSearch" value='查询'>
						 		   
			 				
									<div id="theDivSearch" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:550px;height:400px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1">	
			  						
			  						<table width="100%">              
			               
			               	        <tr>
			               	        		<td width="10px"> <fmt:message key="carrierForm.channelId"/></td>
										    <td width="1px">  <input  style="CURSOR: pointer;" size="12Px" name="carrierName" id="carrierName" type=text autocomplete=off value=""></td>
							 			    <td width="100px"> <fmt:message key="orderForm.customerName"/></td>
										    <td width="1px">  <input  style="CURSOR: pointer;" size="12Px" name="customerName" id="customerName" type=text autocomplete=off value=""></td>							 
								            <td width="80px">业务员</td>
								            <td width="1px"><select name="userOwner" id="userOwner" /> </td>
								            <td>&nbsp</td>
			               	        </tr>
			               	        
			               	        <tr><td align="left" colspan="7">&nbsp</td> </tr>	
			               	        
 									<tr>
 									    <td width="30px"> 品牌</td>
			      						<td  width="1px" align="left" valign="left"><div id="matterName_DIV" name="matterName_DIV"/></td>
 
							               <!-- td width="70px">
							                   		<div style="position:relative;overflow:visible">    
							   						<a href="#"  id="btnSearche3"  class="button"><fmt:message key="analyzeBrand.choseBrand"/></a>  
										
													<div id="theDivSearch3" style="position:absolute; left:0px;top:21px;width:224px;height:345px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1">
														<table border="0" cellpadding="0" cellspacing="0">
														<tr><td>
														&nbsp;<fmt:message key="button.search"/>
														</td>
														<td><input  style="CURSOR: pointer;"  size="15px" name="matter_name" id="matter_name" type=text></td>
														</tr>  
														<tr>
														<td colspan="2">
														<div id="matterTreebox" 
														 style="width:100%;height:100%;
														 height:300px;
														 width:222px;
														 background-color:#f5f5f5;
														 border :1px solid Silver;"/>
														 </div>     
														 </td>
														 </tr></table>

							                 			<input  style="CURSOR: pointer;" type="button"  id="query3" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.confim"/>&nbsp;&nbsp;&nbsp;&nbsp;'>
														<input  style="CURSOR: pointer;" type="button" id="btnSearcheClose3" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.cancel"/>&nbsp;&nbsp;&nbsp;&nbsp;'>
							                 		          
							              </td -->     
							 
							               <td width="80px"> <fmt:message key="orderDayInfoForm.startDate"/></td>
							               <td width="1px"><input type ="text" id ="beginDate" size=10></td>
							
							                <td width="80px"> <fmt:message key="orderDayInfoForm.endDate"/></td>
							                <td width="1px"><input type ="text" id ="overDate" size=10></td>		
							                 <td>&nbsp</td>
			               	        		
			               	        </tr>			               	        
			               	        
			               	         <tr><td align="left" colspan="7">&nbsp</td> </tr>		
			               	        
                					<tr>
					                  <td align="left" colspan="7">
					                    <input  style="CURSOR: pointer;" type="button"  id="query" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="orderDayInfoForm.button.search"/>&nbsp;&nbsp;&nbsp;&nbsp;'>
				                        <input  style="CURSOR: pointer;" type="button"  id="btn_reset_query" value='&nbsp;&nbsp;&nbsp;&nbsp;重置&nbsp;&nbsp;&nbsp;&nbsp;'>
				                        <input  style="CURSOR: pointer;" type="button" id="btnSearcheClose" value='&nbsp;&nbsp;&nbsp;&nbsp;关闭&nbsp;&nbsp;&nbsp;&nbsp;'>
					                 </td>
				            
				                 	   
				                 </tr>			               	        
			               	        
			               	        
			               	   
			                        </table>
               
               
                                   </div>
               
               </td>
               
               
               
                
 			   
               
                <td  width="1px"><div id="printReportDiv" name="printReportDiv"/></td>
                
                <td>&nbsp</td>
              
              
              
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
            <td bgcolor="#f4f3f4"  valing="top">
	  </td>
	  
	  <td valign="top"  bgcolor="#f4f3f4" >
	  
						<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
			<tr><td><div id="adResCount" >
									
				<div id="gridbox" width="100%" height="100%" style="background-color:f4f3f4;"/>
			</div>		</td></tr>
			<tr><td align="right">&nbsp;</td></tr>	
			<tr><td align="right"><div id="pageInfoAnalyzeClass"></div></td></tr>					
											
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

<iframe style="display:none" src='about:blank'   scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
<form name="ReportForm" id="ReportForm" method="post">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="reportType" id="reportType" value="">
	<input type="hidden" name="carrierIdsForm" id="carrierIdsForm" value="">
	<input type="hidden" name="customerIdsForm" id="customerIdsForm" value="">
	<input type="hidden" name="matterNamesForm" id="matterNamesForm" value="">
	<input type="hidden" name="startForm" id="startForm" value="">
	<input type="hidden" name="endForm" id="endForm" value="">
	<input type="hidden" name="userId" id="userId" value="">
	<input type="hidden" name="userName" id="userName" value="">
	<input type="hidden" name="version" id="version" value="">


	
</form>


  	  	    