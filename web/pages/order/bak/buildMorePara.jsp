<!-- HTTP 1.1 -->
        <meta http-equiv="Cache-Control" content="no-store"/>
<!-- HTTP 1.0 -->
        <meta http-equiv="Pragma" content="no-cache"/>
<!-- Prevents caching at the Proxy Server -->
        <meta http-equiv="Expires" content="0"/>
<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<%@ include file="/common/sysParam.jsp" %>


	


<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/SysParamUtil.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/admin/sysParams.js'/>"></script>   
<!-- script type="text/javascript" src="<c:url value='/dwr/interface/DateUtil.js'/>"></script -->

<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/hashMap.js'/>"></script>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>


<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_broarray.css'/>" / >

<!-- link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" / -->

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_drag.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_srnd.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_start.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_nxml.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_link.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_selection.js'/>"></scrip>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_math.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_splt.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/ext/dhtmlxgrid_keymap_excel.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/ext/dhtmlXgrid_colspan.js'/>"></scrip>
<!-- script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/ext/dhtmlxgrid_rowspan.js'/>"></scrip -->
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/ext/dhtmlXGrid_ssc.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/ext/dhtmlxgrid_group.js'/>"></scrip>




<!-- script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/ext/dhtmlxgrid_keymap_excel.js'/>"></script -->





<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_excell_calendar2.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/popupWindow.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/specific.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/SpecificManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/PublishArrangeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/carrierType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/orderDetail.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDetailManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/order/buildMoreParaService.js'/>"></script>


		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/ext-all.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/xtheme-gray.css'/>" />
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/adapter/ext/ext-base.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-all.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-lang-zh_CN.js'/>" charset="utf-8"></script>



  <style type='text/css'>
  body { 
	  background: url('<c:url value='/images/body_bg.jpg'/>') repeat; 
		margin:0;
		padding:0;
  }
  </style>

<body>
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td  valign="top"> <div id="gridbox1" width="100%"  style="background-color:white;"/></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td  valign="top"> <div id="gridbox2" width="100%"  style="background-color:white;"/></td>
  </tr>
</table>

</body>

<div style="display:none;">
    <div>
	<div id="carrierTypeTreebox2"/>
	</div>
	
	<div><select id="resourceSpecificId"/></div>
	

	
</div>


	<div>
	<input  id="edit_flt_box_1" type="text" style="width:100%;margin-left:0px;CURSOR: pointer;height:100%;"  value="" onclick="(arguments[0]||window.event).cancelBubble=true;">
	<input  id="edit_flt_box_2" type="text" style="width:100%;margin-left:0px;CURSOR: pointer;height:100%;"  value="" onclick="(arguments[0]||window.event).cancelBubble=true;">
	<input  id="edit_flt_box_3" type="text" style="width:100%;margin-left:0px;CURSOR: pointer;height:100%;"  value="" onclick="(arguments[0]||window.event).cancelBubble=true;">

	</div>

