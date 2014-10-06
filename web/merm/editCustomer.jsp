<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<html>
<head>
<title>客户添加</title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/global.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTabbar.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXToolbar.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlxToolbar_xp.css'/>" />		
	
<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTabbar/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTabbar/dhtmlXTabbar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxtabbar/dhtmlXTabbar_start.js'/>"></script>

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

<script type="text/javascript" src="<c:url value='/scripts/merm/editCustomerService.js'/>"></script>

</head>

 <input id="ctxPath" type="hidden" value="<c:url value="/"/>">              

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center"><div id="toolbar_zone" style="width:96%;border :1px solid Silver;"/> </td>
  </tr>
</table>  
	            
<table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">

  <tr> 
    <td valign="top" class="text">
 
 <!-- div class="pageHeader">客户基本信息</div -->

    
<fieldset id="">
<legend class="pageHeader">客户基本信息</legend -->
   
   


 <table>
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



</fieldset>

 
    
      
     </td>
  </tr>
 
  <tr> 
    <td valign="top">
   
	<div id="tabbarconteiner" style="width: 100%; height: 100%; margin: 0 0 0 8px;">
		<div id="a_tabbar" ></div>
	</div>
	
	<iframe src="<c:url value="/blank.jsp"/>" style="height:400px; width:100%" frameborder="0" id="details" name="details"></iframe>
					
    
    </td>
  </tr>
  <tr>
    <td valign="top" class="text">&nbsp;</td>
  </tr>
  <tr> 
    <td valign="top" class="text">&nbsp;</td>
  </tr>
</table>

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