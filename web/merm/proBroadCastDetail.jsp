<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/sysParam.jsp" %>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title><fmt:message key="selectOrderDetail"/></title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/dhtmlXCombo.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/global.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXToolbar.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlxToolbar_xp.css'/>" />	
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/winjs/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/broArrange.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/prototypeUI/ptotoyeUI.css'/>" / >

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
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_math.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXProtobar.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXToolbar.js'/>"></script>

<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/DateUtil.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProPublishPlanManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proPublishPlanDetail.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proPublishPlan.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/merm/proArrangeService.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/merm/proBroadCastDetailService.js'/>"></script>


</head>
<input id="ctxPath" type="hidden" value="<c:url value="/"/>">   
<body>
	<table>
	<tr>
		<td><fmt:message key="resourceLimitForm.carrierId"/>：</td>
		<td><select name="select" id="carrierName"/></td>
		
		<td><fmt:message key="orderDetailForm.tb.tim"/>：</td>
		<td><select id="round">
			<option value="1">第一轮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
			<option value="2">第二轮</option>
			<option value="3">第三轮</option>
			<option value="4">第四轮</option>
			<option value="5">第五轮</option>
			<option value="6">第六轮</option>
			<option value="7">第七轮</option>
			<option value="8">第八轮</option>
			<option value="9">第九轮</option>
		</select></td>
		<td><fmt:message key="resourceLimitForm.startTime"/>:</td>
		<td><input type="text" id="startHour" size=3>	:</td>
		<td><input type="text" id="startMinute" size=3></td>
		<td><fmt:message key="resourceLimitForm.endTime"/>:</td>
		<td><input type="text" id="endHour" size=3>	:</td>
		<td><input type="text" id="endMinute" size=3></td>
	</tr>
	</table>	
		<div id="gridbox" width="100%" height="93%" style="background-color:white;"></div>

	    <table width="100%" border="0" bgcolor="#808080" cellspacing="0" cellpadding="0">
		  				    <tr><td colspan="39"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
  <tr>
  	
    		<td><div id="toolbar_zone" style="width:100%;border :1px solid Silver;"/> </td>
 		 </tr>
	    </table>
	            <div style="position:relative;overflow:visible">
                
                    <div id="broArrangeDiv" style="position:absolute;OVERFLOW: auto;left:325px;bottom:27px;width:400px;height:130px;visibility:hidden;border:solid green 2px;background-color:white;z-index:0";/> 
				
				<table width="100%" border="0">
			  <tr><td><table><tr> 
			    <td width="40%"><fmt:message key="orderForm.publishStartDate"/><input type="text" name="textfield" id="beginDate" size="10"></td>
			    <td width="40%"><fmt:message key="orderForm.publishEndDate"/><input type="text" name="textfield2" id="overDate" size="10"></td>
			    
			    <td><input type="button" name="Submit" id="confim" value='<fmt:message key="button.confim"/>'></td>
			   <td><input type="button" name="broDown" id="broDown" value='<fmt:message key="button.cancel"/>'></td>
			    </tr></table></td>
			  </tr>
			  <tr><td>
			  
			  <table><tr><td id = "selectMode">
			  	<fmt:message key="orderForm.broarrangeMode"/> 
			    <input type="radio" name="radiobutton" id="radiobutton_month" value="1">
			    <label style="cursor: pointer;width:20px;" for="radiobutton_month"><fmt:message key="contractTargetMonthForm.monthDate"/></label>
			    <input type="radio" name="radiobutton" id="radiobutton_day" value="2">
			    <label style="cursor: pointer;width:20px;" for="radiobutton_day"><fmt:message key="broArrange.day"/></label>
			    <input type="radio" name="radiobutton" id="radiobutton_week" value="3">
			    <label style="cursor: pointer;width:20px;" for="radiobutton_week"><fmt:message key="broArrange.week"/></label>
			    <input type="radio" name="radiobutton" id="radiobutton_evenyDay" value="4">
			    <label style="cursor: pointer;width:20px;" for="radiobutton_evenyDay"><fmt:message key="broArrange.evenyDay"/></label>
			   
			    <select id="times">
			    <% for(int i= 1; i< 10;i++){ %>
			   		 <option value="<%=i%>"><%=i%></option>
		            <%}%>
			    </select>

		                
			      <fmt:message key="contractPaymentForm.payNumber"/>
			      </td>   
			      </tr></table>
			      
			      </td>
			  </tr>
			 <tr id="monthSelect"> <td><table><tr>
			    <td><input type="checkbox" name="checkbox" id="monthValue1" value="1" onClick="changeAutoArrangeStartAndEnd()">
			    	<label style="cursor: pointer;width:20px;" for="monthValue1"><fmt:message key="business.month.jan"/></label>
			     </td>
			    <td><input type="checkbox" name="checkbox" id="monthValue2" value="2" onClick="changeAutoArrangeStartAndEnd()">
			    <label style="cursor: pointer;width:20px;" for="monthValue2"><fmt:message key="business.month.feb"/></label>
			      </td>
			   
			    <td><input type="checkbox" name="checkbox" id="monthValue3" value="3" onClick="changeAutoArrangeStartAndEnd()">
			    <label style="cursor: pointer;width:20px;" for="monthValue3"><fmt:message key="business.month.mar"/></label>
			      </td>
			    <td><input type="checkbox" name="checkbox" id="monthValue4" value="4" onClick="changeAutoArrangeStartAndEnd()">
			    <label style="cursor: pointer;width:20px;" for="monthValue4"><fmt:message key="business.month.apr"/></label>
			   </td>
			     <td><input type="checkbox" name="checkbox" id="monthValue5" value="5" onClick="changeAutoArrangeStartAndEnd()">
			     <label style="cursor: pointer;width:20px;" for="monthValue5"><fmt:message key="business.month.may"/></label>
			     </td>
			    <td><input type="checkbox" name="checkbox" id="monthValue6" value="6" onClick="changeAutoArrangeStartAndEnd()">
			    <label style="cursor: pointer;width:20px;" for="monthValue6"><fmt:message key="business.month.jun"/></label>
			      </td>
			   </tr>
			   <tr>
			    <td><input type="checkbox" name="checkbox" id="monthValue7" value="7" onClick="changeAutoArrangeStartAndEnd()">
			    <label style="cursor: pointer;width:20px;" for="monthValue7"><fmt:message key="business.month.jul"/></label>
			      </td>
			    <td><input type="checkbox" name="checkbox" id="monthValue8" value="8" onClick="changeAutoArrangeStartAndEnd()">
			    <label style="cursor: pointer;width:20px;" for="monthValue8"><fmt:message key="business.month.aug"/></label>
			   </td>
			     <td><input type="checkbox" name="checkbox" id="monthValue9" value="9" onClick="changeAutoArrangeStartAndEnd()">
			     <label style="cursor: pointer;width:20px;" for="monthValue9"><fmt:message key="business.month.sep"/></label>
			     </td>
			    <td><input type="checkbox" name="checkbox" id="monthValue10" value="10" onClick="changeAutoArrangeStartAndEnd()">
			    <label style="cursor: pointer;width:20px;" for="monthValue10"><fmt:message key="business.month.oct"/></label>
			      </td>
			   
			    <td><input type="checkbox" name="checkbox" id="monthValue11" value="11" onClick="changeAutoArrangeStartAndEnd()">
			     <label style="cursor: pointer;width:20px;" for="monthValue11"><fmt:message key="business.month.nov"/></label>
			      </td>
			    <td><input type="checkbox" name="checkbox" id="monthValue12" value="12" onClick="changeAutoArrangeStartAndEnd()">
			     <label style="cursor: pointer;width:20px;" for="monthValue12"><fmt:message key="business.month.dec"/></label>
			   </td>
			 	</tr></table></td>
			  </tr>
			  <tr id="daySelect"> 
			    <td colspan="6">
			      <input type="radio" name="checkbox" id="checkbox_111" value="1">
			      <label style="cursor: pointer;width:20px;" for="checkbox_111"><fmt:message key="broArrange.oneday"/></label>
			      <input type="radio" name="checkbox" id="checkbox_222" value="2">
			      <label style="cursor: pointer;width:20px;" for="checkbox_222"><fmt:message key="broArrange.twoday"/></label>
			      
			  </tr>
			  <tr id="weekSelect"> <td><table><tr>
			    <td>
			      <input type="checkbox" name="checkbox_week" id="week_chose_1" value="1">
			      <label style="cursor: pointer;width:20px;" for="week_chose_1"><fmt:message key="workspanForm.monLength"/></label>
			      <input type="checkbox" name="checkbox_week" id="week_chose_2" value="2">
			      <label style="cursor: pointer;width:20px;" for="week_chose_2"><fmt:message key="workspanForm.tueLength"/></label>
			      <input type="checkbox" name="checkbox_week" id="week_chose_3" value="3">
			      <label style="cursor: pointer;width:20px;" for="week_chose_3"><fmt:message key="workspanForm.wenLength"/></label>
			      <input type="checkbox" name="checkbox_week" id="week_chose_4" value="4">
			      <label style="cursor: pointer;width:20px;" for="week_chose_4"><fmt:message key="workspanForm.thiLength"/></label>
			      </td>
			      </tr>
			      <tr>
			      <td>
			      <input type="checkbox" name="checkbox_week" id="week_chose_5" value="5">
			      <label style="cursor: pointer;width:20px;" for="week_chose_5"><fmt:message key="workspanForm.friLength"/></label>
			      <input type="checkbox" name="checkbox_week" id="week_chose_6" value="6">
			      <label style="cursor: pointer;width:20px;" for="week_chose_6"><fmt:message key="workspanForm.satLength"/></label>
			      <input type="checkbox" name="checkbox_week" id="week_chose_0" value="0">
			      <label style="cursor: pointer;width:20px;" for="week_chose_0"><fmt:message key="workspanForm.sunLength"/></label>
			      </td>
			      </tr></table></td>
			  </tr>
			</table>					
									 
			</div>
<div style="display:none;"> 
proPublishPlanId:<input type="text" id="proPublishPlanId" name="proPublishPlanId"/>
</div>
</body>
</html>