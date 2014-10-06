<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<html>
<head>
<title>节目供应商</title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/global.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/dhtmlXCombo.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXToolbar.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlxToolbar_xp.css'/>" />	

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>"
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/winjs/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/winjs/prototype.js'/>"></script>	
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

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXProtobar.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXToolbar.js'/>"></script>

<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProCustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProCustomerTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProProgramManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProOrderManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/proCustomer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proCustomerType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proProgram.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proOrder.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/merm/customerListService.js'/>"></script>

</head>

<input id="ctxPath" type="hidden" value="<c:url value="/"/>">   

<body>


<table width="70%" border="0" cellspacing="0" cellpadding="0">
  <tr > 
         <td nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="foretArrearageForm.customerName"/>
		 <td align="left">
		 <div id="cus_name" style="width:200px; height:30px;"></div>
        </td></td>
         <td class="text" align="left">
          <input name="search"   id = "search" type="button"  value="搜索">
          </td>
  </tr>
</table> 

<table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">
  <tr> 
    <td><h2 class="pageHeader"><span id="head"></h2></td>
  </tr>
  <tr> 
    <td valign="top"  width="100%">
    
<div style="height:35px">
   <table id="pageInfo_proCustomer_table" width="100%" border="0" cellspacing="0" cellpadding="0">
							  				 <tr>
								  				 	 <td colspan="2"><IMG src="<c:url value='/image/s.gif'/>"  width="100%" height="2">
								  				 	 </td>
								  				 </tr>
						                        <tr  bgcolor="#ffffff">
						                          <td align="right" height="15"> 
						                              &nbsp;<div id="pageInfo_proCustomer"></div>
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
        
           <td nowrap="nowrap" class="dataLabel" align="right">  
          <fmt:message key="customerTypeDetail.heading"/><td align="left"><div id="customerTypeDiv"></td>
          </td>
          
          
           <td nowrap="nowrap" class="dataLabel" align="right">
         <fmt:message key="orgForm.linkMan"/><td align="left"><input name="linkMen" id="linkMen" type="text" size="20"></td>
          </td>
          
        </tr>
        <tr>
          <td nowrap="nowrap" class="dataLabel" align="right">
          <fmt:message key="foretArrearageForm.customerName"/><td align="left"><input name="cusName" id="cusName" type="text" size="20"></td>
          </td>
          
          <td nowrap="nowrap" class="dataLabel" align="right">
         <fmt:message key="customerAddressDetail.heading"/><td align="left"><input name="accAddress" id="accAddress" type="text" size="20"></td>
          </td>
          
        </tr>
        <tr>
          <td nowrap="nowrap" class="dataLabel" align="right">
       <fmt:message key="customerForm.helpCode"/><td align="left"><input name="helpCode" id="helpCode"type="text" size="20"></td>
          </td>
          
         <td nowrap="nowrap" class="dataLabel" align="right">
        <fmt:message key="linkManForm.title.linkFun"/><td align="left"><input name="telphone" id="telphone" type="text" size="20"></td>
          </td>
        </tr>
      </table>	 
 </div>

<div style="display:none">
proCustomerId:<input name="proCustomerId" type="text" id="proCustomerId">
proCustomerName:<input name="proCustomerName" type="text" id="proCustomerName">
proHelpCode:<input name="proHelpCode" type="text" id="proHelpCode">
typeId:<input name="typeId" type="text" id="typeId">
proTelephone:<input name="proTelephone" type="text" id="proTelephone">
proLinkmanName:<input name="proLinkmanName" type="text" id="proLinkmanName">
proAccountAddress:<input name="proAccountAddress" type="text" id="proAccountAddress">
</div>

</body>

</html>