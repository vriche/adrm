<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<html>
<title><fmt:message key="orderDetail.title"/></title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/dhtmlXCombo.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/global.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXToolbar.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlxToolbar_xp.css'/>" />	
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/winjs/theme.css'/>" />

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_ext.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/debug.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>

<script>_js_prefix="../scripts/dhtmlxTreeGrid/"; </script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxCombo/dhtmlXCombo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_calendar.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXProtobar.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXToolbar.js'/>"></script>

<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/DateUtil.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProOrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProFinanceManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomeModeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomePurposeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProOrderTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProProgramTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProProgramManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProCustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProCustomerTypeManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/proOrder.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proFinance.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomeMode.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomePurpose.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proOrderType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proProgramType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proProgram.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proCustomer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proCustomerType.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/merm/proOrderEditService.js'/>"></script>




</head>
<body>
<input id="ctxPath" type="hidden" value="<c:url value="/"/>">   

        
<table width="100%" border="0" cellspacing="0" cellpadding="3" align="center"  height="50%" >
<tr>
<td>
<div id="toolbar_zone" style="width:92%;border :1px solid Silver;"/>
</td>
<tr>
  <tr> 
    <td>
 
 <!-- div class="pageHeader"><fmt:message key="orderForm.legend1"/></div -->
 
    
<fieldset id="" style="width: 90%" >
<legend class="pageHeader"><fmt:message key="proOrderForm.legend1"/></legend>

 <table width="70%" border="0">
        <tr>
          <!-- 订单编号 -->
          <td nowrap="nowrap" class="dataLabel"><fmt:message key="orderForm.orderCode"/></td>
          <td size=20>
	      <table border="0" cellspacing="0">
	      <tr>
	      <td>
	      <input name="orderCode" type="text" id="orderCode" size=10></td><td>
<div id="order_year"></div><td>
</tr>
</table>
	      </td>
	      
	      <!--  节目名称 -->
          <td nowrap="nowrap" class="dataLabel"><fmt:message key="proOrderForm.program"/></td>
	      <td><div id="program"></div></td>
	      
	            <!--签订日期--> 
          <td nowrap="nowrap"  class="dataLabel"><fmt:message key="proOrderForm.date"/></td>
	        <td>
	             <input name="orderDate" type="text" id="orderDate">
	        </td>
        
	      
        </tr>
        <tr>
         <!-- 关联编号 -->
          <td nowrap="nowrap" class="dataLabel"><fmt:message key="orderForm.relationCode"/></td>
          <td><input name="relationCode" type="text" id="relationCode"></td>
          
          <!--客户名称-->
          <td nowrap="nowrap" class="dataLabel"><fmt:message key="orderForm.customerName"/></td>
	  <td>
		<div id="customer"></div>
	    </td>  
	     <!--业务员--> 
         <td nowrap="nowrap"  class="dataLabel"> <fmt:message key="orderForm.userId"/></td>
		 <td><select name="userName" id="userName"  style="CURSOR: pointer;width:140px;height:20px"/></td>
        </tr>
        <tr>
            <!--订单类别-->
            <td nowrap="nowrap"  class="dataLabel"><fmt:message key="orderForm.categoryId"/></td>
	         <td>
	            <div name="proOrderTypeDiv" id="proOrderTypeDiv"></div>
	        </td>
	         <!--客户类别-->
            <td nowrap="nowrap"  class="dataLabel"><fmt:message key="customerForm.customerCategoryId"/></td>
	        <td>
	        <div name="proCustomerTypeDiv" id="proCustomerTypeDiv"></div>
	        </td> 
	        	 
          <!-- 订单备注 -->
        <td nowrap="nowrap" class="dataLabel"><fmt:message key="orderForm.orderMeno"/></td>
	                        <td>
	                        <div style="position:relative;overflow:visible">
	                        <input name="orderMeno" type="text" id="orderMeno"> 
	                        <div id="theDivOrderMeno" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1">	
	                        <textarea id="textareaOrderMeno" rows="10"  style="font-size:12px"></textarea>
	                         </div>
	                        </td>
        </tr>

      </table>	            

</fieldset>
</td>
</tr>
  <tr>
    <td valign="top">
	<fieldset id="" style="width: 90%" >
<legend class="pageHeader"><fmt:message key="proOrderForm.legend2"/></legend>	
	<div id="gridbox" width="100%" height="300px" style="background-color:white;overflow:hidden"></div>
   </fieldset>
    </td>
  </tr>
  <tr> 
    <td><div id="toolbar_zone1" style="width:97.4%;border :1px solid Silver;"/></td>
  </tr>
</table>
<div  style="display:none"> 
proOrderId:<input name="proOrderId" type="text" id="proOrderId">
<select name="select" id="proProgramName"/>
<select name="select1" id="incomeModeName"/>
<select name="select2" id="incomePurposeName"/>
</div>
<%@ include file="/common/sysParam.jsp" %>
</body>
<html>