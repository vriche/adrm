<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/sysParam.jsp" %>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title>节目搜索</title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/global.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXToolbar.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlxToolbar_xp.css'/>" />	

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>"
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/winjs/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/dhtmlXCombo.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/winjs/prototype.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/winjs/effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_ext.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/debug.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXProtobar.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXToolbar.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTabbar/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTabbar/dhtmlXTabbar_start.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTabbar/dhtmlXTabbar.js'/>"></script>
	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxCombo/dhtmlXCombo.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/DateUtil.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProCustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProProgramManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProProgramTypeManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/proProgramType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proCustomer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proProgram.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/merm/proProgramSearchService.js'/>"></script>

<input id="ctxPath" type="hidden" value="<c:url value="/"/>">

<table width="100%" border="0" cellpadding="0" cellspacing="0">
 <tr>
   <td>
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
      <tr>
	    <td valign="top">
	    <div style="height:35px">
	      <table id="pageInfo_proProgram_table" width="100%" border="0" cellspacing="0" cellpadding="0">
  				 <tr>
	  				 	 <td colspan="2"><IMG src="<c:url value='/image/s.gif'/>"  width="100%" height="2">
	  				 	 </td>
	  				 </tr>
                    <tr  bgcolor="#ffffff">
                      <td align="right" height="15"> 
                          &nbsp;<div id="pageInfo_proProgram"></div>
                      </td>
                 	</tr>
			</table>
			</div>
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

<div id="searcheDiv" style="display:none"> 
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
	<td></td>
	<td>
	 <select id="dateType" style="CURSOR: pointer;width:150px;" >
	 	<option value="0">==样片时间分类==</option>
		<option value="1">样片时间</option>
		<option value="2">到带时间</option>
	</select>
	</td>
	</tr>

	 <tr> 
  
         <td  nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="workspanForm.beginDate"/></td>
			 <td align="left">
			 <input name="startDate"   id="startDate" type="text"style="width:150px; height:20px;CURSOR: pointer;"> 
	         </td>
	         
	         <td  nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="workspanForm.endDate"/></td>
			 <td align="left">
			 <input name="endDate"   id="endDate" type="text" style="width:150px; height:20px;CURSOR: pointer;"> 
        	 </td>       
   
  </tr>
	<tr>
	 <td nowrap="nowrap" class="dataLabel" align="right">  
  		<fmt:message key="proOrderForm.proProgramType"/><td><div id="programTypeDiv" style="width:150px; height:20px;"></td>
  		</td>
  		<td  nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="proProgramForm.copyrightNo"/></td>
		  <td class="text" align="left">
		  	<div id="combo_zone3" style="width:150px; height:20px;"></div>
		  </td>
	</tr>
	<tr>	 
   <td  nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="proOrderForm.program"/></td>
			 <td class="text" align="left">
			  	<div id="combo_zone2" style="width:150px; height:20px;"></div>
			 </td>
       <td nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="foretArrearageForm.customerName"/></td>
		  <td class="text" align="left">
		  	<div id="combo_zone1" style="width:150px; height:20px;"></div>
		  </td>
       
  </tr>	
 	<tr>	 
   <td  nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="proProgramForm.programStatus"/></td>
			 <td class="text" align="left">
			  	<div id="programStatusDiv" style="width:150px; height:20px;"></div>
			 </td>
       <td nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="proProgramForm.commendLevel"/></td>
		  <td class="text" align="left">
		  	<select name="commendLevel"  id="commendLevel" style="width:150px;height:20px">
	  <option value="0">==推荐级别==</option>  	
	  <option value="1">一星级</option>
	  <option value="2">两星级</option>
	  <option value="3">三星级</option>
	  <option value="4">四星级</option>
	  <option value="5">五星级</option>
	  </select>
		  </td>
       
  </tr>	
   
  <tr>	 
		<td nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="proProgramForm.isSell"/></td>
		<td class="text" align="left">
		  	<select name="isSell"  id="isSell" style="width:150px;height:20px">
	  			<option value="2">==是否可以销售==</option>  	
	 			<option value="1">允许销售</option>
	  			<option value="0">不允许销售</option>
	  		</select>
		  </td>
		
		<td nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="proProgramForm.isBuy"/></td>
		<td class="text" align="left">
		  	<select name="isBuy"  id="isBuy" style="width:150px;height:20px">
	  			<option value="2">==是否已购==</option>  	
	 			<option value="1">已购</option>
	  			<option value="0">未购</option>
	  		</select>
		  </td>
	</tr>
	<tr>	
		<td nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="proProgramForm.isCheckPass"/></td>
		<td class="text" align="left">
		  	<select name="isCheckPass"  id="isCheckPass" style="width:150px;height:20px">
	  			<option value="2">==审核是否通过==</option>  	
	 			<option value="1">通过</option>
	  			<option value="0">未通过</option>
	  		</select>
		  </td>
		
		<td nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="proProgramForm.isPay"/></td>
		<td class="text" align="left">
		  	<select name="isPay"  id="isPay" style="width:150px;height:20px">
	  			<option value="2">==是否已付款==</option>  	
	 			<option value="1">已付</option>
	  			<option value="0">未付</option>
	  		</select>
		  </td>
	</tr>
</table>
<br/><br/>
<center>
<input value="搜索" name="btnSearch"   id="btnSearch" type="button" size=10 style="CURSOR: pointer;"> 
<input value="关闭" name="btnClose"   id="btnClose" type="button" size=10 style="CURSOR: pointer;"> 
 </div>
 
 
<div style="display:none">
proProgramId:<input name="proProgramId" type="text" id="proProgramId">
proProgramName:<input name="proProgramName" type="text" id="proProgramName">
proCustomerName:<input name="proCustomerName" type="text" id="proCustomerName">
proCopyrightNum:<input name="proCopyrightNum" type="text" id="proCopyrightNum">
proTypeId:<input name="proTypeId" type="text" id="proTypeId">
proMakeUnit:<input name="proMakeUnit" type="text" id="proMakeUnit">
proStartDate:<input name="proStartDate" type="text" id="proStartDate">
proEndDate:<input name="proEndDate" type="text" id="proEndDate">
</div>


