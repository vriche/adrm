<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/sysParam.jsp" %>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title>播出计划</title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/global.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXToolbar.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlxToolbar_xp.css'/>" />	

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/winjs/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/dhtmlXCombo.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/prototypeUI/ptotoyeUI.css'/>" / >

<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/CalendarPopup.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/prototypeUI/window.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/prototypeUI/utils.js'/>"></script>


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
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_clist.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_acheck.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_link.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXProtobar.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXToolbar.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/popupWindow.js'/>"></script>

<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/DateUtil.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProProgramManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProPublishPlanManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/proPublishPlan.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proProgram.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/merm/proPublishPlanService.js'/>"></script>

<input id="ctxPath" type="hidden" value="<c:url value="/"/>">

<table width="100%" border="0" cellpadding="0" cellspacing="0">

 <tr>
   <td>
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
      <tr>
	    <td valign="top">
	    
			<table width="100%" border="0">
				<tr>
				<td>
				<div style="height:35px">
				  		 <table id="pageInfo_proPublishPlan_table" width="100%" border="0" cellspacing="0" cellpadding="0">
							  				 <tr>
								  				 	 <td colspan="2"><IMG src="<c:url value='/image/s.gif'/>"  width="100%" height="2">
								  				 	 </td>
								  				 </tr>
						                        <tr  bgcolor="#ffffff">
						                          <td align="right" height="15"> 
						                              &nbsp;<div id="pageInfo_proPublishPlan"></div>
						                          </td>
						                     	</tr>
						</table>
						</div>
					<div id="gridbox" width="100%" height="300px" style="background-color:white;overflow:hidden"></div>
	      		</td>
	      		</tr>
	      	</table>		
	     </td>	
     </tr>
  </table>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  	
    <td><div id="toolbar_zone" style="width:100%;border :1px solid Silver;"/> </td>
  </tr>
 </table> 
 </td>
 </tr>  
</table>

<!-- 搜索 -->
<div id="searcheDiv" style="display:none"> 
<br/><br/>

	<table align="center">
	
  <tr> 
         <td  nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="proOrderForm.program"/></td>
	 <td align="left"><div name="proName" id="proName"></td>
  </tr>	
	
  <tr> 
  
         <td  nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="workspanForm.beginDate"/></td>
		 <td align="left">
		 <input name="beginDate"   id="beginDate" type="text" size=15 style="CURSOR: pointer;"> 
         </td>
   </tr>
   <tr>      
         <td  nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="workspanForm.endDate"/></td>
		 <td align="left">
		 <input name="overDate"   id="overDate" type="text" size=15 style="CURSOR: pointer;"> 
         </td>         
   
  </tr>

  
</table> 


<center>
<input value="搜索" name="btnSearch"   id="btnSearch" type="button" size=10 style="CURSOR: pointer;"> 

<input value="关闭" name="btnClose"   id="btnClose" type="button" size=10 style="CURSOR: pointer;"> 

 </div>
 
<div  style="display:none"  >		
<select name="select" id="carrierName"/>
<select name="select" id="proProgramName"/>

programId:<input name="programId" type="text" id="programId">
</div>