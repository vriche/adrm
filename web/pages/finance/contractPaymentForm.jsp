<!-- HTTP 1.1 -->
        <meta http-equiv="Cache-Control" content="no-store"/>
<!-- HTTP 1.0 -->
        <meta http-equiv="Pragma" content="no-cache"/>
<!-- Prevents caching at the Proxy Server -->
        <meta http-equiv="Expires" content="0"/>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/sysParam.jsp" %>

<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
<!-- script type="text/javascript" src="<c:url value='/dwr/interface/DateUtil.js'/>"></script -->
     

<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/SysParamUtil.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/admin/sysParams.js'/>"></script>   



<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />


<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />


<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_srnd.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_link.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_nxml.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/popupWindow.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/extutils.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/ContractPaymentManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomePullManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomeMsgManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/contractpayment.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomePull.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/income.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/finance/contractPaymentFormService.js'/>"></script>


<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/ext-all.css'/>" />
<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/adapter/ext/ext-base.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-all.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-all.js'/>"></script>


		
		
  <!-- style type='text/css'>
  body { 
	  background: url('<c:url value='/images/body_bg.jpg'/>') repeat; 
		margin:0;
		padding:0;
  }
  </style -->
  

 <div id="main-win" name="main-win">
    
		 <table border="0" cellspacing="0" cellpadding="0" align="center">
		  <tr>
		    <td colspan="2"></td>
		  </tr>
		  <tr> 
		    <td  valign="top"> <div id="gridbox" height="100%" width="100%" style="background-color:white;z-index:0"></div></td>
		    <td  valign="top"> <div id="gridbox_incomePull" width="300" height=100 style="background-color:white;"/></td>
		  </tr>
		</table>  
		 
</div>
 
  
 <div id="print-win" name="print-win">
 
 
 
 
 <div id="hello-win" class="x-hidden">
    <div class="x-window-header">Hello Dialog</div>
    <div id="hello-tabs">
        <!-- Auto create tab 1 -->
        <div class="x-tab" title="Hello World 1">
            <p>Hello...</p>
        </div>
        <!-- Auto create tab 2 -->
        <div class="x-tab" title="Hello World 2">
            <p>... World!</p>
        </div>
    </div>
    

 <input type="hidden" id="contPath" value="<c:url value="/"/>">	
 <input id="tag_orderList_finance" type="hidden" value="0">
 <adrm_order:authorizeTag res="tag_orderList_finance">
	<script>$("tag_orderList_finance").value = 1 ;</script>
</adrm_order:authorizeTag>

