<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="orderCategoryCarrier.title"/></title>
<content tag="heading"><fmt:message key="orderCategoryCarrier.title"/></content>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>


<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />



<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_start.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_nxml.js'/>"></script>


<script type="text/javascript" src="<c:url value='/dwr/interface/CategoryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDayInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomePurposeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/AnalyseManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/sample/broArrange.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/category.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDayInfo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomePurpose.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/analyzeClass.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/analyze/orderCategoryCarrierService.js'/>"></script>


<table width="100%" border="0" id="mainTable" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                    <td><span class="tile1">
                    
	 					<table width="90%" border="0" cellpadding="0" cellspacing="0">
	             			<tr>
							     <td width="1%" id="orgId_td"> <select id="orgId"/></td>	
							     
							     <td width="1px"><select id="order_year"  style="CURSOR: pointer;" /></td>
							     
								
					
				       <td width="1%">
	 <div style="position:relative;overflow:visible">    
	 <input type="button"   class="button" id="btnSearche" value='²éÑ¯'>		

			
	<div id="theDivSearch" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:550px;height:200px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1">	
                    
                 
              <table width="100%">
	                 
		<tr><td align="left" colspan="4">&nbsp</td></tr>
		
		<tr>	
		    <td><select name="userOwner" id="userOwner"/></td>
		    <td><select name="select" id="carrierName"/> </td>	
		    <td>      </td>				 
			<td><fmt:message key="orderDayInfoForm.startDate"/>
				<input style="CURSOR: pointer;"  type ="text" id ="beginDate" size=11>
			</td>
			<td><fmt:message key="orderDayInfoForm.endDate"/>
				<input style="CURSOR: pointer;"  type ="text" id ="overDate" size=11>
			</td>
		</tr>				
		<tr><td align="left" colspan="4">&nbsp</td></tr>
		<tr><td align="left" colspan="4">&nbsp</td></tr>
		<tr><td align="left" colspan="4">&nbsp</td></tr>		
		<tr>	<td align="left">
			<input  style="CURSOR: pointer;" type="button"  id="searchCustomerYear" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="orderDayInfoForm.button.search"/>&nbsp;&nbsp;&nbsp;&nbsp;'>
			<input  style="CURSOR: pointer;" type="button" id="btnSearcheClose" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.cancel"/>&nbsp;&nbsp;&nbsp;&nbsp;'>
			</td>
				            
			<td align="left" colspan="5">&nbsp</td>
		 </tr>

	    </table>		 
				
</div></div>
	 	</td>

			 
			<td  width="1%" ><div id="printReportDiv" name="printReportDiv"/></td>
            <td>&nbsp;</td>
			 
			 
			 
		        			</tr>
		        		</table>
	        		                   
                    
                    </span>
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

				<div id="categoryTreebox" 
					 style="width:100%; 
					 height:370px;
					 width:220px;
					 background-color:#f5f5f5;
					 border :1px solid Silver;"/>

    </td>  
    <!--- ÓÒ²à²¿·Ö--->  
    
    
    <td valign="top">

        <div id="gridbox" width="100%" height="100%" style="background-color:white;z-index:0"/>
      
    


    	
    	
    	
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
	
	<input type="hidden" name="startDate" id="startDate" value="">
	<input type="hidden" name="endDate" id="endDate" value="">
	<input type="hidden" name="userId" id="userId" value="">
	<input type="hidden" name="userName" id="userName" value="">
	<input type="hidden" name="carrierNameForm" id="carrierNameForm" value="">
	
	<input type="hidden" name="customerIdsForm" id="customerIdsForm" value="">
	<input type="hidden" name="yearForm" id="yearForm" value="">
	<input type="hidden" name="channelModelParam" id="channelModelParam" value="">
	
	<input type="hidden" name="yearOrQuarterForm" id="yearOrQuarterForm" value="">
	<input type="hidden" name="sortStr" id="sortStr" value=""> 
	<!--input type="hidden" name="putYear" id="putYear" value=""> 
	<input type="hidden" name="returnValue" id="returnValue" value=""> 
	<input type="hidden" name="incomPurs" id="incomPurs" value=""--> 
</form>
