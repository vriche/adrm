<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>用户与客户隶属关系</title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />

<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CategoryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>


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
<script type="text/javascript" src="<c:url value='/scripts/class/category.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/admin/userRelCustomerService.js'/>"></script>


</head>

<body>


<input type="hidden" id="id"/>



<table width="100%" border="1">
  <tr>
    <td >
		 <table width="100%" border="0" cellpadding="0" cellspacing="0">
		  <tr>
		    <td width="33%">&nbsp;</td>
		    <td  width="33%" align="center">用户与客户隶属关系</td>
		    <td align="right">
		       <a id="Btn_saveUserCustomerRel" class="button">&nbsp;&nbsp;&nbsp;<fmt:message key="button.save"/>&nbsp;&nbsp;&nbsp;</a>
		       <a id="Btn_close" class="button">&nbsp;&nbsp;&nbsp;<fmt:message key="button.cancel"/>&nbsp;&nbsp;&nbsp;</a>
		    </td>
		  </tr>
		</table>   

	</td>
  </tr>
  <tr>
    <td>
		<div id="categoryTreebox" 
					style="width:100%; 
					height:0px;
					background-color:#f5f5f5;
					border :1px solid Silver;"/>
	</td>
  </tr>
</table>
</body>


</html>