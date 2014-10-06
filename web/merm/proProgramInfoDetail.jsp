<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<html>
<title><fmt:message key="orderDetail.title"/></title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/dhtmlXCombo.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/global.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXToolbar.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlxToolbar_xp.css'/>" />	
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/winjs/theme.css'/>" />

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

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXProtobar.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXToolbar.js'/>"></script>

<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/DateUtil.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProOrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProFinanceManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomeModeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomePurposeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProOrderTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProProgramTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProProgramManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProCustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProCustomerTypeManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/proOrder.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proFinance.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomeMode.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomePurpose.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proOrderType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proProgramType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proProgram.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proProgramDetail.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proCustomer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proCustomerType.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/merm/proProgramInfoDetailService.js'/>"></script>




</head>
<body>
<input id="ctxPath" type="hidden" value="<c:url value="/"/>">   

        
<table width="100%" border="0" cellspacing="0" cellpadding="3" align="center"  height="30%" >

  <tr> 
    <td>

<fieldset id="" style="width: 90%" >
<legend class="pageHeader"><fmt:message key="proProgramForm.programInfo"/></legend>
 <table width="70%" border="0">
	            <!--创建日期--> 
           <td nowrap="nowrap"  class="dataLabel"><fmt:message key="matterTypeForm.createDate"/></td>
	   <td><input name="inputDate" type="text" id="inputDate"></td>
	   
	          <!--首映日期--> 
           <td nowrap="nowrap"  class="dataLabel"><fmt:message key="proProgramForm.firstDate"/></td>
	   <td><input name="firstDate" type="text" id="firstDate"></td>          
   
	      <!--  导演 -->
          <td nowrap="nowrap" class="dataLabel"><fmt:message key="proProgramForm.director"/></td>
	  <td><input name="director" type="text" id="director"></td>

        </tr>
        <tr>
        	            <!--主演--> 
          <td nowrap="nowrap"  class="dataLabel"><fmt:message key="proProgramForm.actor"/></td>
	   <td><input name="actor" type="text" id="actor"> </td>    
 
 		      <!--票房-->
        <td nowrap="nowrap" class="dataLabel"><fmt:message key="proProgramForm.incomeMoney"/></td>
	    <td><input name="incomeMoney" type="text" id="incomeMoney"></td>
	    <!--收视率-->
	    
        <td nowrap="nowrap" class="dataLabel"><fmt:message key="audienceRat.name"/></td>
	    <td><input name="rate" type="text" id="rate"></td>
          
        </tr>
        <tr>
		<!--内容简介-->
         <td nowrap="nowrap" class="dataLabel"><fmt:message key="proProgramForm.content"/></td>
	                        <td>
	                        <div style="position:relative;overflow:visible">
	                        <input name="content" type="text" id="content"> 
	                        <div id="theDivContent" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1">	
	                        <textarea id="textareaContent" rows="10"  style="font-size:12px"></textarea>
	                         </div>
	                        </td>
	     <!--评价--> 
                 <td nowrap="nowrap" class="dataLabel"><fmt:message key="proProgramForm.opinion"/></td>
	                        <td>
	                        <div style="position:relative;overflow:visible">
	                        <input name="opinion" type="text" id="opinion"> 
	                        <div id="theDivOpinion" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1">	
	                        <textarea id="textareaOpinion" rows="10"  style="font-size:12px"></textarea>
	                         </div>
	                        </td>
	        	 
          <!-- 推荐指数 -->
          <td nowrap="nowrap" class="dataLabel"><fmt:message key="proProgramForm.commendLevel"/></td>
	  <td><select name="commendLevel"  id="commendLevel" style="width:140;height:19">
	  <option value="1">一星级</option>
	  <option value="2">二星级</option>
	  <option value="3">三星级</option>
	  <option value="4">四星级</option>
	  <option value="5">五星级</option>
	  </select>
	  </td>
        </tr>
      </table>	            
</fieldset>
</td>
</tr>
<tr>
<td>
<div id="toolbar_zone" style="width:92%;border :1px solid Silver;"/>
</td>
<tr>
</table>
<div  style="display:none"> 
proOrderId:<input name="proOrderId" type="text" id="proOrderId">
<select name="select" id="proProgramName"/>
<select name="select1" id="incomeModeName"/>
<select name="select2" id="incomePurposeName"/>
</div>
<%@ include file="/common/sysParam.jsp" %>
</body>
<html>