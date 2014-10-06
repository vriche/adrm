<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title>节目成本分析</title>

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

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXProtobar.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXToolbar.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTabbar/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTabbar/dhtmlXTabbar_start.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTabbar/dhtmlXTabbar.js'/>"></script>
	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxCombo/dhtmlXCombo.js'/>"></script>

<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProProgramManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProAnalyzeManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/proOrder.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proProgram.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/merm/proProgramCostAnalyzeService.js'/>"></script>

<input id="ctxPath" type="hidden" value="<c:url value="/"/>">

<table width="100%" border="0" cellpadding="0" cellspacing="0">

  <tr> 
    <td valign="top" class="text">  
	      <table  border="0">
	        <tr>
	        <td  nowrap="nowrap"  class="dataLabel"  align="right"><fmt:message key="proOrderForm.program"/></td>
		  <td class="text">
		  	<div id="combo_zone2" style="width:150px; height:20px;"></div>
		  </td>
	        
		  <td>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <input  style="CURSOR: pointer;" type="button"  id="search" value='搜索'></td>
	        </tr>
	      </table>
   </td>
 </tr>
 <tr>
   <td>
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
      <tr>
	    <td valign="top">
	    <div style="height:35px">
	    <table id="pageInfo_proCost_table" width="100%" border="0" cellspacing="0" cellpadding="0">
  		<tr>
  			<td colspan="2"><IMG src="<c:url value='/image/s.gif'/>"  width="100%" height="2">
  			</td>
  		</tr>
         <tr  bgcolor="#ffffff">
           <td align="right" height="15"> 
              &nbsp;<div id="pageInfo_proCost"></div>
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
<div id="login" style="display:none">   
      <table  border="0" align="center">
       
	<tr >
	  <td nowrap="nowrap"  class="dataLabel"  ><fmt:message key="proOrderForm.program"/><td><input name="textfield" id="proName" type="text" size="20"></td></td>
	</tr>
	
      </table>
</div>

