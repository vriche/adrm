<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<html>
<title>客户类型</title>

<link rel="stylesheet" href="style/Style.css" type="text/css" />

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/dhtmlXCombo.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/global.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXToolbar.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlxToolbar_xp.css'/>" />	
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>"
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/winjs/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_ext.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/debug.js'/>"></script>

<script>_js_prefix="dhtmlxTreeGrid/"; </script>
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
<script type="text/javascript" src="<c:url value='/dwr/interface/ProCustomerTypeManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/proCustomerType.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/merm/editCustomerTypeService.js'/>"></script>


</head>
<input id="ctxPath" type="hidden" value="<c:url value="/"/>">   
<body>

<table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">

  <tr> 
    <td valign="top" class="text">
 


 <table width="75%" border="0">
         <tr>
          <td class="text"> 客户类型:
				<input name="cusType" id="cusType"  type="text" size="15">
          </td>
        </tr>
        
      </table>	            

 <table width="100%" border="0">
  <tr>
    <td><div id="toolbar_zone" style="width:100%;border :1px solid Silver;"/> </td>
  </tr>
</table>   
    
      
     </td>
  </tr>
  
</table>

<div style="display:none">
Id:<input name="cusTypeId" type="text" id="cusTypeId">
Id:<input name="cusTypeName" type="text" id="cusTypeName">

</div>
</body>
</html>