<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="resourceScopeAnalyze.title"/></title>


<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_start.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>		        
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDayInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderCategoryManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>	 

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXTreeGrid.js'/>"></script>       
		        
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDayInfo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrierType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderCategory.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/analyze/resourceScopeAnalyzeService.js'/>"></script>

<content tag="heading"><fmt:message key="resourceScopeAnalyze.title"/></content>

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
           
                   		
 					 <td width="1%"><input type="text" value="开始"  width="120px" class="myLable2"></td>
				
					 <td width="1%"><input type ="text" id ="beginDate" name="beginDate" size=10></td>
					  
 					 <td width="1%"><input  type="text" value="结束"  width="120px" class="myLable2"></td>
 					 
					 <td width="1%"><input type ="text" id ="overDate" name="overDate" size=10></td>      
					 
				
					 
	                <td width="1%" style="display:none"><select name="userOwner" id="userOwner" /></td>
	                <td width="1%"><div id="orderCategoryIdDiv"></td>
	                 <td width="1%" > <div id="weekDiv" name="weekDiv"/> </td>
					
	                
               
                    <td width="1%"><input type="button"   class="button" id="search" value='查询'>	</td>   
                   

                     
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
    <td>
    
    
     <table border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
          
      		<td background="images/table1/textbox_left.gif" width="14"></td>
      		
      		<td bgcolor="#f4f3f4"> 
      		
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
	      <tr>     		
      
            <td bgcolor="#f4f3f4"  valing="top" width="17%">
              				<div id="carrierTypeTreebox" 
							 style="width:100%; 
							 height:300px;
							 background-color:#f5f5f5;
							 border :1px solid Silver;"/>
			
	  		</td>
	  
			<td valign="top"  bgcolor="#f4f3f4" >
				
				<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
				<tr><td><div id="adResCount" >
										
					<div id="gridbox" width="100%" height="100%" style="background-color:white;"/>
				</div>		</td></tr>
				<tr><td align="right"><div id="pageInfoAnalyzeClass"></div></td></tr>											
				</table>	

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

<iframe src='about:blank' style="display:none"  scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
<form name="ReportForm" id="ReportForm" method="post">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="reportType" id="reportType" value="">
	<input type="hidden" name="carrierIdsForm" id="carrierIdsForm" value="">
	<input type="hidden" name="startForm" id="startForm" value="">
	<input type="hidden" name="endForm" id="endForm" value="">
	
	<input type="hidden" name="isPrint" id="isPrint" value="">
	
	<input type="hidden" name="userId" id="userId" value="">
	<input type="hidden" name="userName" id="userName" value="">
	<input type="hidden" name="carrierNameForm" id="carrierNameForm" value="">
	<input type="hidden" name="isDetail" id="isDetail" value="">
	<input type="hidden" name="orderCategoryIdForm" id="orderCategoryIdForm" value="">
	
	<input type="hidden" name="weekStrForm" id="weekStrForm" value="">
	
</form>


  	  	    