<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title><fmt:message key="contractTargetMonthForm.targetInfo"/></title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />

<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/BranchManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/address.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/branch.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/admin/selectUserBranchRelService.js'/>"></script>


</head>

<body>


<input type="hidden" id="id"/>



<table width="100%" border="0">
  <tr>
    <td >
		 <table width="100%" border="0" cellpadding="0" cellspacing="0" style="display:none">
		  <tr>
		    <td width="33%">&nbsp;</td>
		   
		    <td align="right">
		       <a id="Btn_saveUserRel" class="button">&nbsp;&nbsp;&nbsp;关闭&nbsp;&nbsp;&nbsp;</a>

		    </td>
		  </tr>
		</table>   

	</td>
  </tr>
  <tr>
    <td>
    	<fieldset id="order_baseInfo_frm">
	    <legend>请选择该业务员归属部门</legend>
				<div id="branchTreebox" 
					style="width:100%; 
					height:0px;
					background-color:#f5f5f5;
					border :1px solid Silver;"/>
		</fieldset>			
	</td>
	
	 <td>
    	<fieldset id="order_baseInfo_frm">
	    <legend>此用户订单授权给以下的用户</legend>
			<div id="sysOrgTreebox" 
					style="width:100%; 
					height:0px;
					background-color:#f5f5f5;
					border :1px solid Silver;"/>
		</fieldset>					
	</td>
  </tr>
</table>

<input id="ctxPath" type="hidden" value="<c:url value="/"/>">

</body>


</html>