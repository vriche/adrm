<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<%@ include file="/common/sysParam.jsp" %>
<html>
<title>节目类型</title>

<link rel="stylesheet" href="style/Style.css" type="text/css" />

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/dhtmlXCombo.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/global.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXToolbar.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlxToolbar_xp.css'/>" />	
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>"
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/winjs/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />


<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_ext.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/debug.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

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
<script type="text/javascript" src="<c:url value='/dwr/interface/ProProgramTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/DateUtil.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proProgramType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/merm/proProgramStatusListService.js'/>"></script>

</head>
<input id="ctxPath" type="hidden" value="<c:url value="/"/>">   
<body>

<table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">
<tr>
	<td><table width="98%" border="0" cellspacing="0" cellpadding="3" >
  		
  		  <td vAlign="top"> 
				<fieldset style="width: 97%" id="branchList" > 
           			<legend></legend>	
						<table  class=ListShort width="100%" cellpadding="0" >
  							<tr>
   							 	<td><div id="toolbar_zone" style="width:100%;border :1px solid Silver;"/> </td>
  							</tr>
					
  
 							<tr> 
						  		  <td valign="top"  width="100%">
						
						  		 	 <div id="gridbox" width="100%" height="300px" style="background-color:white;overflow:hidden"></div>
							 	  </td>
						  	</tr>
	  					</table>
				</fieldset>
	  
	  			<fieldset style="width: 97%" id="branchForm" > 
          			 <legend></legend>
          			 
          			 <table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">
 						 <tr> 
   							 <td valign="top" class="text">
 
									 <table>
		         <tr>
		          <td nowrap="nowrap" class="dataLabel" >
		          	<fmt:message key="proOrderForm.proProgramType"/><td><input name="proProgramStatusName" id="proProgramStatusName" type="text" size="15"></td>
		          </td>
		        </tr>
		          <tr>
		          <td nowrap="nowrap" class="dataLabel" align="right">
		          	<fmt:message key="customerCategoryForm.displayNo"/><td><input name="displayNo" id="displayNo" type="text" size="15"></td>
		          </td>
		        </tr>

									    </table>	 
							</td>    
						</tr>  
			    		<tr> 
			    			<td> 
										 <table width="100%" border="0">
										  <tr>
										    <td><div id="toolbar_zone2" style="width:100%;border :1px solid Silver;"/> </td>
										  </tr>
										</table>   
			    			 </td>
			  			</tr>
			  
					</table>
        		</fieldset>
		  </td> 
	
	</td>

 </tr>
</table>

<div style="display:none">
proProgramStatusId:<input name="proProgramStatusId" type="text" id="proProgramStatusId">

</div>
</body>
</html>