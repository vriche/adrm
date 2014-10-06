<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<html>
<head>
<title><fmt:message key="incomeList.order"/></title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/dhtmlXCombo.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/global.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXToolbar.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlxToolbar_xp.css'/>" />	
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/winjs/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_ext.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/debug.js'/>"></script>

<script>_js_prefix="dhtmlxTreeGrid/"; </script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxCombo/dhtmlXCombo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_link.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXProtobar.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXToolbar.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/DateUtil.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProOrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProCustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProProgramManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/proOrder.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proCustomer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proProgram.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/merm/proOrderListService.js'/>"></script>
</head>

<input id="ctxPath" type="hidden" value="<c:url value="/"/>">   

<body>

<table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">

  <tr>
  <!--    <td class="text">
      <table>
      <tr>orderDetailForm.orderId
      <td class="text">
                订单编号:
                </td>
                <td>
		<div id="order" style="width:150px; height:20px;"></div>
		</td>
		<td class="text">

               客户名称:
                </td>
                <td>
		<div id="customer" style="width:210px; height:20px;"></div>
               </td>
               <td class="text">

                节目名称:
                </td>
                <td>
		<div id="program" style="width:150px; height:20px;"></div>
		</td>
		 
          <td nowrap="nowrap"  class="dataLabel"><fmt:message key="proOrderForm.date"/></td>
	        <td>
	             <input name="orderDate" type="text" id="orderDate">
	        </td>
		<td>
	
		
      <input type="button" id="query" value="查询" >
      </td>
      <tr>
      <table>
      </td>
  </tr>-->
  <tr> 
    <td valign="top"  width="100%">
  <div style="height:35px">
  <table id="pageInfo_proOrder_table" width="100%" border="0" cellspacing="0" cellpadding="0">
							  				 <tr>
								  				 	 <td colspan="2"><IMG src="<c:url value='/image/s.gif'/>"  width="100%" height="2">
								  				 	 </td>
								  				 </tr>
						                        <tr  bgcolor="#ffffff">
						                          <td align="right" height="15"> 
						                              &nbsp;<div id="pageInfo_proOrder"></div>
						                          </td>
						                     	</tr>
	</table>
	</div>
    <div id="gridbox" width="100%" height="300px" style="background-color:white;overflow:hidden"></div>
    
 <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><div id="toolbar_zone" style="width:100%;border :1px solid Silver;"/> </td>
  </tr>
</table>  
   

      
      </td>
  </tr>
  <tr> 
    <td valign="top" class="text">
     
    
    </td>
  </tr>
  
</table>
<div id="login" style="display:none"> 
	<table width="100%" border="0">
	     <tr> 
          <td nowrap="nowrap" class="dataLabel"  align="right"><fmt:message key="resourceLimitForm.version"/>：</td>
	      <td ><div name="order_year"  id="order_year"></div></td>

	     <!--业务员--> 
         <td nowrap="nowrap"  class="dataLabel"  align="right"> <fmt:message key="orderForm.userId"/>：</td>
		 <td><select name="userName" id="userName"  style="CURSOR: pointer;width:140px;height:20px"/></td>
          
        </tr>
        <tr>
          <td nowrap="nowrap" class="dataLabel"  align="right"><fmt:message key="orderForm.customerName"/>：</td>
           <td>
		<div id="customer" style="width:210px; height:20px;"></div>
               </td>

        <td nowrap="nowrap" class="dataLabel"  align="right"><fmt:message key="proOrderForm.program"/>：</td>
	      <td>
		<div id="program" style="width:150px; height:20px;"></div>
		</td>
        </tr>
        <tr>
                  <td nowrap="nowrap"  class="dataLabel" align="right"><fmt:message key="contractForm.startDate"/>：</td>
	        <td>
	             <input name="startDate" type="text" id="startDate" readonly="true">
	        </td>
	             <td nowrap="nowrap"  class="dataLabel" align="right"><fmt:message key="contractForm.endDate"/>：</td>
	        <td>
	             <input name="endDate" type="text" id="endDate" readonly="true">
	        </td>
        </tr>
      </table>
      <br/><br/>
<center>
<input value=<fmt:message key="orderDayInfoForm.button.search"/> name="btnSearch"   id="btnSearch" type="button" size=10 style="CURSOR: pointer;"> 
<input value=<fmt:message key="proOrderForm.close"/> name="btnClose"   id="btnClose" type="button" size=10 style="CURSOR: pointer;"> 
 </div>
 
<div style="display:none">
proCustomerName:<input name="proCustomerName" type="text" id="proCustomerName">
proProgramName:<input name="proProgramName" type="text" id="proProgramName">
proOrderYear:<input name="proOrderYear" type="text" id="proOrderYear">
</div>
<%@ include file="/common/sysParam.jsp" %>
 