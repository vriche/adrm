<%@ include file="/common/taglibs.jsp"%>

<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title><fmt:message key="carrierAllYearAnalyze.title"/></title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>		        
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDayInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>	

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>	


<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_start.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_nxml.js'/>"></script>  
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXTreeGrid.js'/>"></script>    
		        
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDayInfo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrierType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/analyze/carrierAllAnalyzeService.js'/>"></script>	        
 
<content tag="heading"><fmt:message key="carrierAllYearAnalyze.title"/></content> 
 
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                  
                    <td width="1%" id="orgId_td"> <select id="orgId"/></td>
                    <td width="1px"><select id="resource_year"  style="CURSOR: pointer;" /></td>
  
				    		   
				    		   
				     <td width="1%">	
						<select id="query" style="CURSOR: pointer;" >
							<option value="1"><fmt:message key="orderDayInfoForm.button.displayIncome"/></option>
							<option value="2"><fmt:message key="orderDayInfoForm.button.incomePuton"/></option>
						</select>
					</td>   
					 		   
	                 <td width="1%" style="display:none"><select name="userOwner" id="userOwner" /> </td>
  					<td width="1%"><input type="button"   class="button" id="search" value='²éÑ¯'>	</td>        
	      
	                 
	                 <td  width="1%" align="left" valign="left"><div id="printReportDiv" name="printReportDiv"/></td>
	                 
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
            <td background="images/table1/textbox_left.gif" width="14"></td>
            <td bgcolor="#f4f3f4"> 
 
 
 <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
	      <td width="15%" valign="top"> 
			
						<div id="carrierTypeTreebox" 
							 style="width:100%; 
							 height:300px;
							 background-color:#f5f5f5;
							 border :1px solid Silver;"/>
				
	       </td>
	       
	    <td valign="top">
			<table width="100%" border="0">
				<tr>
				<td valign="top">
				
				<div id="gridbox" width="100%" height="100%" style="background-color:white;"/>		
	
				
			
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

<iframe style="display:none" src='about:blank'   scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
<form name="ReportForm" id="ReportForm" method="post">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="reportType" id="reportType" value="">
	
	<input type="hidden" name="carrierIdsForm" id="carrierIdsForm" value="">
	<input type="hidden" name="yearForm" id="yearForm" value="">
	
	<input type="hidden" name="isPrint" id="isPrint" value="">
	<input type="hidden" name="userId" id="userId" value="">
	<input type="hidden" name="userName" id="userName" value="">
	<input type="hidden" name="isType" id="isType" value="">
	<input type="hidden" name="isDetail" id="isDetail" value="">
</form>
