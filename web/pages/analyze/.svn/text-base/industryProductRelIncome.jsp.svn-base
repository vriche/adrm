<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="industryProductRelIncome.title"/></title>
<content tag="heading"><fmt:message key="industryProductRelIncome.heading"/></content>
<meta name="menu" content="CustomerMenu"/>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXTreeGrid.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>


<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDetailManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>	

<script type="text/javascript" src="<c:url value='/scripts/class/customerProduct.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/analyze/industryTypeProductService.js'/>"></script>

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
         
                    
				      <td width="1%"><input type="text" value="开始"  width="120px" class="myLable2"/></td>
					 <td width="1%"><input type ="text" id ="beginDate" name="beginDate" size=10></td>
				
 					 <td width="1%"><input  type="text" value="结束"  size="6" class="myLable2"/></td>
					 <td width="1%"><input type ="text" id ="overDate" name="overDate" size=10></td>  
                   	
                    <td width="1%" style="display:none"><select name="userOwner" id="userOwner" /></td>
	                <td width="1%"> <select name="select" id="carrierName"/></td>
	                
	            	 <td width="1%"><input type="button"   class="button" id="search" value='查询'>	</td>   

                     <td  width="1%"><div id="printReportDiv" name="printReportDiv"/></td>
                     
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


<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
	<td>
	
			 <!--行业明细-->
			<table width="100%" border="0" id="industryDetailed">
				<tr><td>	
					<div id="industryProductAnalyze_gridbox" width="100%" height="100%" style="background-color:white;z-index:0"></div>
				</td></tr>
			 </table>
		 
		
		 
		 <!--行业总览>
		 <table width="100%" border="0" id="totalBrowser">
				<tr><td>
					<div id="industryTotalBrowserAnalyze_gridbox" width="100%" height="100%" style="background-color:white;z-index:0"></div>
				</td></tr>
		 </table-->
		 
		 
		 
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

<iframe src='about:blank' style="display:none"  scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
<form name="ReportForm" id="ReportForm" method="post">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="reportType" id="reportType" value="">
	
	<input type="hidden" name="isPrint" id="isPrint" value="">
	<input type="hidden" name="userId" id="userId" value="">
	<input type="hidden" name="userName" id="userName" value="">
	<input type="hidden" name="carrierNameForm" id="carrierNameForm" value="">
	
	<input type="hidden" name="startDate" id="startDate" value="">
	<input type="hidden" name="isDetail" id="isDetail" value="">
	<input type="hidden" name="endDate" id="endDate" value="">
	<input type="hidden" name="channelModelForm" id="channelModelForm" value="">
	<input type="hidden" name="totalOrdetailForm" id="totalOrdetailForm" value="">
</form>