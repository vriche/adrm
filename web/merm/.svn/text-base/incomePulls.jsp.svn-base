<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<html>
<title>到款分配</title>

<link rel="stylesheet" href="style/Style.css" type="text/css" />

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/dhtmlXCombo.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/global.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXToolbar.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlxToolbar_xp.css'/>" />	
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>"
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/winjs/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_ext.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/debug.js'/>"></script>

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
<script type="text/javascript" src="<c:url value='/dwr/interface/ProCustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProCustomerTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProProgramManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProOrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProOrderTypeManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/proCustomer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proCustomerType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proProgram.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proOrder.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proOrderType.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/merm/incomePullsService.js'/>"></script>


</head>
<input id="ctxPath" type="hidden" value="<c:url value="/"/>">   
<body>

<table width="95%" border="0" cellspacing="0" cellpadding="0">
  <tr > 
  
  		<td class="text" align="right">  
          		订单编号:<td align="left"><input name="orderCode"  id="orderCode" type="text" size="15" style="CURSOR: pointer;width:100px;height:20"></td>
		</td>
		<td class="text" align="right">节目名称: </td>
		<td align="left">
			<div id="pro_name" style="width:150px;"></div>
		</td>
		<td class="text" align="right"> 客户名称:</td>
		<td align="left">
			<div id="cus_name" style="width:150px;"></div>
		</td>
		
	         <td>
	            <div name="proOrderTypeDiv" id="proOrderTypeDiv"></div>
	        </td>
	        
		<td class="text" align="left">
			<input name="search"   id = "search" type="button"  value="搜索">
		</td>
  </tr>
</table>  


<table width="98%" border="0" cellspacing="0" align="center">

  <tr> 
    <td valign="top"  width="100%">
<div style="height:35px">
    <table id="pageInfo_proIncomePull_table" width="100%" border="0" cellspacing="0" cellpadding="0">
							  				 <tr>
								  				 	 <td colspan="2"><IMG src="<c:url value='/image/s.gif'/>"  width="100%" height="2">
								  				 	 </td>
								  				 </tr>
						                        <tr  bgcolor="#ffffff">
						                          <td align="right" height="15"> 
						                              &nbsp;<div id="pageInfo_proIncomePull"></div>
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
           <td class="text" align="right">  
          		客户类型:<td align="left"><div id="customerTypeDiv"></td>
          </td>
       </tr>
          
       <tr>
           <td class="text" align="right">  
          		节目名称:<td align="left"> <input name="programName"  id="programName" type="text" size="15"></td>
           </td>
        </tr>
          
        <tr>
           <td class="text" align="right">  
          		客户名称:<td align="left"><input name="cusName"  id="cusName" type="text" size="15"></td>
          </td>
        </tr>
 
      </table>	 
 </div>

<div style="display:none">
customerId:<input name="customerId" type="text" id="customerId">
CustomerTypeId:<input name="CustomerTypeId" type="text" id="CustomerTypeId">

proOrderCode:<input name="proOrderCode" type="text" id="proOrderCode">
proCustomerName:<input name="proCustomerName" type="text" id="proCustomerName">
typeId:<input name="typeId" type="text" id="typeId">
orderTypeId:<input name="orderTypeId" type="text" id="orderTypeId">
proProgramName:<input name="proProgramName" type="text" id="proProgramName">
</div>


</body>
</html>