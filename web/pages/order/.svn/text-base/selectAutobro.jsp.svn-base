<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title><fmt:message key="button.order.autoPlay"/></title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/order/broArrange.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/order/broArrangeService.js'/>"></script>
</head>

<body>
<table width="100%" border="0">
  <tr><td><table><tr> 
    <td><fmt:message key="orderForm.publishStartDate"/><input type="text" name="textfield" id="beginDate"></td>
    <td><fmt:message key="orderForm.publishEndDate"/><input type="text" name="textfield2" id="overDate"></td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td><input type="button" name="Submit" id="confim" value='<fmt:message key="button.confim"/>'></td>
    </tr></table></td>
  </tr>
  <tr><td><table><tr><td id = "selectMode">
  	<fmt:message key="orderForm.broarrangeMode"/> 
    <input type="radio" name="radiobutton" id="month" value="1">
     <fmt:message key="contractTargetMonthForm.monthDate"/>
 	<input type="radio" name="radiobutton" id="sordDay" value="2">
       <fmt:message key="broArrange.day"/>
    <input type="radio" name="radiobutton" id="week" value="3">
      <fmt:message key="broArrange.week"/>
    <input type="radio" name="radiobutton" id="everyDay" value="4">
      <fmt:message key="broArrange.evenyDay"/>
    <input type="text" name="times" id="times" size=5>
      <fmt:message key="contractPaymentForm.payNumber"/>
      </td>   
      </tr></table></td>
  </tr>
  <tr id="monthSelect"> <td><table><tr>
    <td><input type="checkbox" name="checkbox" value="1">
    <fmt:message key="business.month.jan"/>
     </td>
    <td><input type="checkbox" name="checkbox" value="2">
    <fmt:message key="business.month.feb"/>
      </td>
   
    <td><input type="checkbox" name="checkbox" value="3">
    <fmt:message key="business.month.mar"/>
      </td>
    <td><input type="checkbox" name="checkbox" value="4">
    <fmt:message key="business.month.apr"/>
   </td>
     <td><input type="checkbox" name="checkbox" value="5">
     <fmt:message key="business.month.may"/>
     </td>
    <td><input type="checkbox" name="checkbox" value="6">
    <fmt:message key="business.month.jun"/>
      </td>
   </tr>
   <tr>
    <td><input type="checkbox" name="checkbox" value="7">
    <fmt:message key="business.month.jul"/>
      </td>
    <td><input type="checkbox" name="checkbox" value="8">
    <fmt:message key="business.month.aug"/>
   </td>
     <td><input type="checkbox" name="checkbox" value="9">
     <fmt:message key="business.month.sep"/>
     </td>
    <td><input type="checkbox" name="checkbox" value="10">
    <fmt:message key="business.month.oct"/>
      </td>
   
    <td><input type="checkbox" name="checkbox" value="11">
     <fmt:message key="business.month.nov"/>
      </td>
    <td><input type="checkbox" name="checkbox" value="12">
     <fmt:message key="business.month.dec"/>
   </td>
 	</tr></table></td>
  </tr>
  <tr id="daySelect"> 
    <td colspan="6">
      <input type="checkbox" name="checkbox" value="1">
      <fmt:message key="broArrange.oneday"/>
      <input type="checkbox" name="checkbox2" value="2">
      <fmt:message key="broArrange.twoday"/>
      
  </tr>
  <tr id="weekSelect"> <td><table><tr>
    <td>
      <input type="checkbox" name="checkbox" value="1">
      <fmt:message key="workspanForm.monLength"/>
      <input type="checkbox" name="checkbox2" value="2">
      <fmt:message key="workspanForm.tueLength"/>
      <input type="checkbox" name="checkbox3" value="3">
      <fmt:message key="workspanForm.wenLength"/>
      <input type="checkbox" name="checkbox4" value="4">
      <fmt:message key="workspanForm.thiLength"/>
      </td>
      </tr>
      <tr>
      <td>
      <input type="checkbox" name="checkbox5" value="5">
      <fmt:message key="workspanForm.friLength"/>
      <input type="checkbox" name="checkbox6" value="6">
      <fmt:message key="workspanForm.satLength"/> 
      <input type="checkbox" name="checkbox7" value="7">
      <fmt:message key="workspanForm.sunLength"/></td>
      </tr></table></td>
  </tr>
  <!--tr> 
    <td colspan="6">
	 <div align="center">
        <input type="button" name="Submit" value='<fmt:message key="button.confim"/>'>
        <input type="submit" name="button" value='<fmt:message key="button.cancel"/>'>
      </div>
	 </td>
  </tr-->
</table>
</body>
</html>
