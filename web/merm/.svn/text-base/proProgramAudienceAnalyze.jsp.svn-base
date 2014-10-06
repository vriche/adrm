<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/sysParam.jsp" %>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title>节目收视分析</title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/global.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXToolbar.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlxToolbar_xp.css'/>" />	

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>"/>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/winjs/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/dhtmlXCombo.css'/>" />

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

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXTreeGrid.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXProtobar.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXToolbar.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTabbar/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTabbar/dhtmlXTabbar_start.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTabbar/dhtmlXTabbar.js'/>"></script>
	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxCombo/dhtmlXCombo.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/DateUtil.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProProgramManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProAnalyzeManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/proProgram.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/merm/proProgramAudienceAnalyzeService.js'/>"></script>

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

	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>	      
	 <td></td>
	 <td class="text">
		        <select id="query" style="CURSOR: pointer;" >
					<option value="1">按月份</option>
					<option value="2">按日期</option>
				</select>
		      </td>
	
	</tr>
  <tr> 
  
   <td nowrap="nowrap" class="dataLabel"><fmt:message key="proOrderForm.program"/></td>
			 <td>
			  	<div id="combo_zone2" style="width:150px; height:20px;"></div>
			 </td>
         <td></td>
	 <td></td>
       
  </tr>	
<tr></tr>
	
  <tr> 
  
         <td  nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="workspanForm.beginDate"/></td>
			 <td align="left">
			 <input name="startDate"   id="startDate" type="text" size=12 style="CURSOR: pointer;"> 
	         </td>
	         
	         <td  nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="workspanForm.endDate"/></td>
			 <td align="left">
			 <input name="endDate"   id="endDate" type="text" size=12 style="CURSOR: pointer;"> 
        	 </td>       
   
  </tr>
  

    <tr> 
  
 <td  nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="resourceLimitForm.startTime"/></td>
			 <td align="left">
			 <select name="startTime_h" id="startTime_h" style="font-size:12px;CURSOR: pointer;">
		 	    <% for(int i= 0; i< 24;i++){ %>
			   		 <option value="<%=i%>"><%=i%></option>
			            <%}%>
			</select><fmt:message key="audienceRat.hour"/>
			 <select name="startTime_m" id="startTime_m" style="font-size:12px;CURSOR: pointer;">
		 	    <% for(int i= 0; i< 60;i++){ %>
			   		 <option value="<%=i%>"><%=i%></option>
		            <%}%>
			</select><fmt:message key="audienceRat.minute"/>
	         </td>
	         
	         <td nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="resourceLimitForm.endTime"/></td>
			 <td align="left">
			 <select name="endTime_h" id="endTime_h" style="font-size:12px;CURSOR: pointer;">
		 	    <% for(int i= 0; i< 24;i++){ %>
			   		 <option value="<%=i%>"><%=i%></option>
		            <%}%>
			</select><fmt:message key="audienceRat.hour"/>
			 <select name="endTime_m" id="endTime_m" style="font-size:12px;CURSOR: pointer;">
		 	    <% for(int i= 0; i< 60;i++){ %>
			   		 <option value="<%=i%>"><%=i%></option>
		            <%}%>
		</select><fmt:message key="audienceRat.minute"/>
         	</td> 
  </tr>
  
  
  
</table>
<br/><br/>
<center>
<input value="搜索" name="btnSearch"   id="btnSearch" type="button" size=10 style="CURSOR: pointer;"> 

<input value="关闭" name="btnClose"   id="btnClose" type="button" size=10 style="CURSOR: pointer;"> 

 </div>
