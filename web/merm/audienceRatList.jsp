<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<html>
<head>
<title>收视率</title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/global.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/dhtmlXCombo.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXToolbar.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlxToolbar_xp.css'/>" />	

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>"
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/winjs/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>


<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/SysParamUtil.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/admin/sysParams.js'/>"></script>   



	
<script type="text/javascript" src="<c:url value='/scripts/winjs/effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_ext.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/debug.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxCombo/dhtmlXCombo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXProtobar.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXToolbar.js'/>"></script>



<script type="text/javascript" src="<c:url value='/dwr/interface/DateUtil.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProAudienceRatManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proAudienceRat.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/merm/audienceRatListService.js'/>"></script>


</head>
<body>


<table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">
  <tr> 
    <td><h2 class="pageHeader"><span id="head"></h2></td>
  </tr>
  <tr> 
    <td valign="top"  width="100%">
    <div style="height:35px">
    <table id="pageInfo_proAudienceRat_table" width="100%" border="0" cellspacing="0" cellpadding="0">
							  				 <tr>
								  				 	 <td colspan="2"><IMG src="<c:url value='/image/s.gif'/>"  width="100%" height="2">
								  				 	 </td>
								  				 </tr>
						                        <tr  bgcolor="#ffffff">
						                          <td align="right" height="15"> 
						                              &nbsp;<div id="pageInfo_proAudienceRat"></div>
						                          </td>
						                     	</tr>
	</table>
	</div>
								  
    <div id="gridbox" width="100%" height="360px" style="background-color:white;overflow:hidden"></div>
    
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



<!-- 搜索 -->
<div id="searcheDiv" style="display:none"> 
<br/><br/>

	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	
  <tr> 
         <td  nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="resourceLimitForm.carrierId"/></td>
	 <td align="left"><select id="carrierName"/></td>
         <td></td>
	 <td></td>
  </tr>	
	
  <tr> 
  
         <td  nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="workspanForm.beginDate"/></td>
		 <td align="left">
		 <input name="beginDate"   id="beginDate" type="text" size=15 style="CURSOR: pointer;"> 
         </td>
         
         <td  nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="workspanForm.endDate"/></td>
		 <td align="left">
		 <input name="overDate"   id="overDate" type="text" size=15 style="CURSOR: pointer;"> 
         </td>         
   
  </tr>
  

    <tr> 
  
  <td  nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="resourceLimitForm.startTime"/></td>
		 <td align="left">
		 <select name="startTime_h" id="startTime_h" style="font-size:12px;CURSOR: pointer;">
		 	    <% for(int i= 1; i< 24;i++){ %>
			   		 <option value="<%=i%>"><%=i%></option>
		            <%}%>
		</select><fmt:message key="audienceRat.hour"/>
		
		 <select name="startTime_m" id="startTime_m" style="font-size:12px;CURSOR: pointer;">
		 	    <% for(int i= 1; i< 60;i++){ %>
			   		 <option value="<%=i%>"><%=i%></option>
		            <%}%>
		</select><fmt:message key="audienceRat.minute"/>

		  
         </td>
         
         <td nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="resourceLimitForm.endTime"/></td>
		 <td align="left">

		 
		 
		 <select name="endTime_h" id="endTime_h" style="font-size:12px;CURSOR: pointer;">
		 	    <% for(int i= 1; i< 24;i++){ %>
			   		 <option value="<%=i%>"><%=i%></option>
		            <%}%>
		</select><fmt:message key="audienceRat.hour"/>
		
		 <select name="endTime_m" id="endTime_m" style="font-size:12px;CURSOR: pointer;">
		 	    <% for(int i= 1; i< 60;i++){ %>
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
 
 


<%@ include file="/common/sysParam.jsp" %>


<input id="ctxPath" type="hidden" value="<c:url value="/"/>">   

</body>

</html>