<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/sysParam.jsp" %>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>


<html>
<head>
<title>远程订单输入 | 广告资源管理</title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/global.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXToolbar.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTabbar.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlxToolbar_xp.css'/>" />	

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/winjs/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/dhtmlXCombo.css'/>" />

        <style type="text/css">
            body { font: 11px Lucida Grande, Verdana, Arial, Helvetica, sans serif; }
            #progressBar { padding-top: 5px; }
            #progressBarBox { width: 350px; height: 18px; border: 1px inset; background: #eee;}
            #progressBarBoxContent { width: 0; height: 18px; border-right: 1px solid #444; background: #9ACB34; }
        </style>
        





		<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
		<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
        <script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>    
        <script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>


  		<script type="text/javascript" src="<c:url value='/dwr/interface/SysParamUtil.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/admin/sysParams.js'/>"></script>  
		

		

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTabbar/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTabbar/dhtmlXTabbar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxtabbar/dhtmlXTabbar_start.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/winjs/prototype.js'/>"></script>	
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
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_acheck.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_combo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_math.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXProtobar.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXToolbar.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>








<script type="text/javascript" src="<c:url value='/dwr/interface/DateUtil.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/PriceManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDayInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDetailManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IndustryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/WorkspanManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ContractPaymentManager'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/contractpayment.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/order.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/price.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/dayInfo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDayInfo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/specific.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDetail.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customerCarrierRel.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/industry.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/matter.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/workspan.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/customer/orderDetailService.js'/>"></script>

</head>


<input id="ctxPath" type="hidden" value="<c:url value="/"/>">


<body>
<table width="100%" height="130px" border="0" cellspacing="0" cellpadding="3" align="center">

<tr>
<td>
<table>
<tr>
<td>载体：</td><td><div id="carrierDiv"></div></td>
<td></td>
<td>播出日期：</td><td><input type="text" id="orderDate" readonly="true"/></td>
<td></td>
<td>应付金额：</td><td><input type="text" id="incomeMoney"/>	元</td>
</tr>
</table>
</td>
</tr>
<tr>
<td>
<div id="gridbox" width="100%" height="500" style="background-color:white;overflow:hidden"></div>
</td>
 </tr>
  <tr><td align='center'>
  <div id="progressBar" style="display: none;">

            <div id="theMeter">
                <div id="progressBarText"></div>

                <div id="progressBarBox">
                    <div id="progressBarBoxContent"></div>
                </div>
            </div>
 </div>
 </td></tr>
 <tr>
  	
    	<td><div id="toolbar_zone" style="width:100%;border :1px solid Silver;"/> </td>
 </tr>
  <tr> 
    <td valign="top" class="text">
     
    
    </td>
  </tr>
  
</table>


<div style="display:none">
proProgramId:<input name="proProgramId" type="text" id="proProgramId">
proProgramName:<input name="proProgramName" type="text" id="proProgramName">
proCustomerId:<input name="proCustomerId" type="text" id="proCustomerId">
proCustomerTypeId:<input name="proCustomerTypeId" type="text" id="proCustomerTypeId">
proCustomerName:<input name="proCustomerName" type="text" id="proCustomerName">
proCopyrightNum:<input name="proCopyrightNum" type="text" id="proCopyrightNum">
proTypeId:<input name="proTypeId" type="text" id="proTypeId">
proMakeUnit:<input name="proMakeUnit" type="text" id="proMakeUnit">
proStartDate:<input name="proStartDate" type="text" id="proStartDate">
proEndDate:<input name="proEndDate" type="text" id="proEndDate">

checkStateForm:<input name="checkStateForm" type="text" id="checkStateForm">

createBy:<input name="createBy" type="text" id="createBy">
createDate:<input name="createDate" type="text" id="createDate">
version:<input name="version" type="text" id="version">
</div>
<div  style="display:none"  >		
<select name="select" id="carrierName"/>
<select name="select" id="matterName"/>
</div>
</body>
</html>