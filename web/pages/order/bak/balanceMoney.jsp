<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title><fmt:message key="orderDetail.title"/></title>


<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
<script type='text/javascript' src='/adrm/dwr/engine.js'></script>
<script type='text/javascript' src='/adrm/dwr/util.js'></script>
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/order/sumMoneyService.js'/>"></script>

</head>

<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
	<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
	<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
    <tr>
        <td align="right" width="50%"><font color="#000000" size="1.5"><fmt:message key="orderForm.sumMoney"/>:</font></td>
        <td><input name="sumMoney" type="text" id="sumMoney" size="10"></td>
  	</tr>
</table>

&nbsp;

<table width="100%" border="0" cellspacing="0" cellpadding="0">	
	<tr>
		<td align="center">
			<input type="button" id="btn_confim" value="<fmt:message key="button.confim"/>">
		</td>
	</tr>
</table>
</body>
</html>










