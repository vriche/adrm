<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<title><fmt:message key="contractTargetMonthForm.targetInfo"/></title>

<script>_js_prefix="<c:url value='/scripts'/>/dhtmlxGrid/"; </script>


<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/theme.css'/>" />

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>


<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/SysParamUtil.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/admin/sysParams.js'/>"></script>   

<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceChannelManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDetailManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDayInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IndustryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/SpecificManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/BrandManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/brand.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/address.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrierType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resourceType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/matter.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/matterType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/order.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDetail.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDayInfo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/specific.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/industry.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/specific.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderCategoryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderCategory.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/orderPublic.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/oaWorkFlowCheckState.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_excell_calendar2.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>







		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/ext-all.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/xtheme-gray.css'/>" />
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/adapter/ext/ext-base.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-all.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-lang-zh_CN.js'/>" charset="utf-8"></script>
		<script type="text/javascript" src="<c:url value='/scripts/common/dwr-lib.js'/>"></script>

		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/TreeCheckNodeUI.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.form.ClearableComboBox.js'/>"></script>
		
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/ComboBoxTree.js'/>"></script>






<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>



		



<script type="text/javascript" src="<c:url value='/scripts/admin/selectMatterEditChange.js'/>"></script>


</head>

<body>
<input id="ctxPath" type="hidden" value="<c:url value="/"/>">   

<input type="hidden" id="id"/>



<table width="99%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td >
		 <table width="100%" border="0" cellpadding="0" cellspacing="0" style="display:none">
		  <tr>
		    <td width="33%">&nbsp;</td>
		    <td  width="33%" align="center"><fmt:message key="userCarrierRel"/></td>
		    <td align="right">
		       <a id="Btn_saveUserCarrierRel" class="button">&nbsp;&nbsp;&nbsp;<fmt:message key="button.save"/>&nbsp;&nbsp;&nbsp;</a>
		       <a id="Btn_close" class="button">&nbsp;&nbsp;&nbsp;<fmt:message key="button.cancel"/>&nbsp;&nbsp;&nbsp;</a>
		    </td>
		  </tr>
		</table>   

	</td>
  </tr>
  
    <tr>
         <td>
         	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			 	 <tr>
			 	 
			 	 
			          <td width="36px" id="sysPrice_td" style="display:none">刊例价</td> 
		              <td width="1px" ><input name="sysPrice" type="text" id="sysPrice" disabled  size="10" style="display:none"></td>  		 	 
			 	 
			          <td width="43px" id="execPrice_td" style="display:none">销售价</td> 
		              <td width="1px" ><input name="execPrice" type="text" id="execPrice"  size="10" style="display:none"></td>  
		              
		              <td width="50px" id="favourRate_td" style="display:none">折扣(%)</td> 
		              <td width="1px" ><input name="favourRate" type="text" id="favourRate" size="10" style="display:none"></td>  
		              
		              <td width="50px" id="appRate_td" style="display:none">加收(%)</td> 
		              <td width="1px" ><input name="appRate" type="text" id="appRate"  size="10" style="display:none"></td>  
	
	
			 	 
			 	 
		              <td width="29px" id="change_time_td">开始</td> 
		              <td width="1px" ><input name="change_time" type="text" id="change_time" readonly="true" size="10"></td>  
		              <td width="29px" id="change_time_end_td">结束</td> 
		              <td width="1px"><input name="change_time_end" type="text" id="change_time_end" readonly="true" size="10"></td>  
		  		      <td width="29px" id="matterLength_td">长度</td> 
		  		      <td width="1px"><div id="matterLengthDiv" name="matterLengthDiv" /></td> 
		  		      <td width="1px"><div id="specCommanDiv" name="specCommanDiv" /></td> 
		              <!-- td width="29px">版本</td --> 
		  		      <td width="1px"><div id="matterEditDiv" name="matterEditDiv" /></td> 
		  		      <td><img src="<c:url value='/image/search.gif'/>" id="search_adver_cont" width="16" height="16" style="CURSOR: pointer;"></td> 
		  		      <td width="1px"><div id="resourceDiv" name="resourceDiv" /></td>   
					  <td width="1px"><input type="button"    class="button"   id="btn_add" value='添加'></td>  
					  <!-- td ><div id="matterEditDivBtn" name="matterEditDivBtn" /></td --> 
					  
					  
					  
					  
					  
				  </tr>
			</table>   	  
		</td> 
           
  </tr>   
  
  
  
  <tr>

    <td>
                <div id="gridbox_div" >
					
					 <div id="gridbox" width="100%" height="100%" style="background-color:#f5f5f5;"></div>
					 
				</div>
			
				
	</td>
  </tr>
   <tr>

    <td>

                <div id="gridbox_div1" >
					
					 <div id="gridbox1" width="100%" height="100%" style="background-color:#f5f5f5;"></div>
					 
				</div>				
				
	</td>
  </tr> 
  
</table>

<input id="ctxPath" type="hidden" value="<c:url value="/"/>">

</body>


</html>

