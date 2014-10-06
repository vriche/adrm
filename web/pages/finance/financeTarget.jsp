<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/sysParam.jsp" %>
   
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />


		<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
		<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
        <script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>  
        

	    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/ext-all.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/xtheme-gray.css'/>" />


	    <script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/adapter/ext/ext-base.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-all.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-lang-zh_CN.js'/>" charset="utf-8"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/TreeCheckNodeUI.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.form.ClearableComboBox.js'/>"></script>
		

		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.ux.form.LovCombo.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.ux.plugins.js'/>"></script>
		<script>Ext.BLANK_IMAGE_URL = '<c:url value='/scripts/ext/3.2.0/resources/images/default/s.gif'/>';</script>
		<script type="text/javascript" src="<c:url value='/scripts/common/dwr-lib.js'/>"></script>

		<script type="text/javascript" src="<c:url value='/dwr/interface/SysParamUtil.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/admin/sysParams.js'/>"></script>    
		<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script> 
		<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>   




<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_math.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/common/popupWindow.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>


<script type="text/javascript" src="<c:url value='/dwr/interface/FinanceTargetManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<!-- script type="text/javascript" src="<c:url value='/dwr/interface/DateUtil.js'/>"></script -->

<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/financeTarget.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/finance/financeTargetService.js'/>"></script>


<body>

<iframe src='about:blank'   style="display:none" scrolling="no" height="100" width="100" name="tarForm1" id="tarForm1"></iframe>	
	
<form name="ReportForm" id="ReportForm" method="post">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="reportType" id="reportType" value="">

	<input type="hidden" name="yearForm" id="yearForm" value="">
	<input type="hidden" name="userNameForm" id="userNameForm" value="">
	<input type="hidden" name="channelModelForm" id="channelModelForm" value="">
	<input type="hidden" name="carrierIdsForm" id="carrierIdsForm" value="">
	
</form>	

<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td  valign="top"> 
    <div>
    <div id="gridbox" width="100%" height="400" style="background-color:white;"/> 
    </div>
    </td>
</table>

<!-- input  style="CURSOR: pointer;" type="button" name="Btn_add_row" id="Btn_add_row" value='&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;'> 
<input  style="CURSOR: pointer;" type="button" name="Btn_save" id="Btn_save" value='&nbsp;&nbsp;<fmt:message key="button.save"/>&nbsp;&nbsp;'> 
<input  style="CURSOR: pointer;" type="button" name="Btn_delete_row" id="Btn_delete_row" value='&nbsp;&nbsp;<fmt:message key="button.delete"/>&nbsp;&nbsp;' --> 


<div  style="display:none"  >		
<select name="select" id="carrierName"/>
</div>




</body>