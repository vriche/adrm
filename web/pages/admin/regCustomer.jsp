<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title><fmt:message key="contractTargetMonthForm.targetInfo"/></title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customerType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/category.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CategoryManager.js'/>"></script>


		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/ext-all.css'/>" />
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/adapter/ext/ext-base.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-all.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-lang-zh_CN.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/TreeCheckNodeUI.js'/>"></script>
		
		<script type="text/javascript" src="<c:url value='/scripts/common/dwr-lib.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/admin/regCustomerService.js'/>"></script>


</head>

<body>
<input id="ctxPath" type="hidden" value="<c:url value="/"/>">   

<input type="hidden" id="id"/>



<table width="100%" border="1">
  <tr>
    <td >
		 <table width="100%" border="0" cellpadding="0" cellspacing="0" style="display:none">
		  <tr>
		    <td width="33%">&nbsp;</td>
		    <td  width="33%" align="center"><fmt:message key="userCarrierRel"/></td>
		    <td align="right">
		       <a id="Btn_saveUserCarrierRel" class="button">&nbsp;&nbsp;&nbsp;<fmt:message key="button.save"/>&nbsp;&nbsp;&nbsp;</a>
		       <a id="Btn_close" class="button">&nbsp;&nbsp;&nbsp;<fmt:message key="button.cancel"/>&nbsp;&nbsp;&nbsp;</a>
		    </td>
		  </tr>
		</table>   

	</td>
  </tr>
  
    <tr>
  		    <td>
			  <select name="resourceType" id="resourceType"/><input id="btn_refresh" type="button" value="<fmt:message key="adrm.refresh"/>">
		
			</td>   

  </tr>   
  
  <tr>

    <td>
		<div id="carrierTypeTreebox" 
					style="width:100%; 
					height:0px;
					background-color:#f5f5f5;
					border :1px solid Silver;"/>
	</td>
  </tr>
</table>

<input id="ctxPath" type="hidden" value="<c:url value="/"/>">

</body>


</html>

