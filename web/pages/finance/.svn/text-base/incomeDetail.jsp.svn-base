<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="incomeDetail1.title"/></title>
<content tag="heading"><fmt:message key="incomeDetail1.title"/></content>
<meta name="menu" content="IncomeMenu"/>


<script type="text/javascript" src="<c:url value='/scripts/class/income.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomeUsed.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>


<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_start.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/IncomeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomeUsedManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/analyze/incomeDetailservice.js'/>"></script>

<script>
function console(obj){
$("searchArea").show();
//obj.setAttribute("value","<fmt:message key="button.done"/>");
}

</script>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom">
            <table border="0" cellpadding="0" cellspacing="0" width="55%">
                <tbody>
                  <tr> 
                      <!--td align="left">
                   	   <a href="editIncome.html" class="button">&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;</a>
                      </td-->
                      
                      <td width="1%" id="orgId_td" > <select id="orgId"/></td>		
                       <td width="1px"><select id="year"  style="CURSOR: pointer;" /></td>
               
			 
                      <td  align="left" width="1%" ><div id="theDivCustomerName"/></td>
                      
                      <td  align="left">
                      	
						<!--fmt:message key="orderDayInfoForm.startDate"/><input size="12px" type ="text" id ="beginDate">
                    	<fmt:message key="orderDayInfoForm.endDate"/><input size="12px" type ="text" id ="overDate"-->
                       
       
                    </td>
                    <td  width="1%" align="left" valign="left"><div id="printReportDiv" name="printReportDiv"/></td>
                    <td>&nbsp;</td>
                    
                  </tr>
                </tbody>
              </table></td>
            <td width="115"><img src="images/table1/textbox_top_right.jpg" height="27"></td>
          </tr>
        </tbody>
      </table></td>
  </tr>
  <tr>
    <td><table border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td background="images/table1/textbox_left.gif" width="14"></td>
            <td bgcolor="#f4f3f4">
            
            <!--   table start -->
              
	            <table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
			    <td>
						<table width="100%" border="0">
							<tr><td>
							<div id="gridbox" width="100%" height="100%" style="background-color:white;"/>	

							</td></tr>
						 </table>
					 
			    </td>
			    </tr>
			    </table> 
	                
	                
            <!--   table end -->  
            
            </td>
            <td width="14" background="images/table1/textbox_right.gif"></td>
          </tr>
        </tbody>
      </table></td>
  </tr>
  <tr> 
    <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tbody>
          <tr> 
            <td width="14"><img src="images/table1/textbox_bottom_left.gif" height="19" width="14"></td>
            <td width="100%" background="images/table1/textbox_bottom.gif"></td>
            <td width="14"><img src="images/table1/textbox_bottom_right.gif" height="19" width="14"></td>
          </tr>
        </tbody>
      </table></td>
  </tr>
</table>


<div style="display:none">
customerId2:<input name="customerId2" type="text" id="customerId2">
customerCategoryId:<input name="customerCategoryId" type="text" id="customerCategoryId">
<html:form action="incomes" method="post" styleId="incomeListForm" >
	<html:text property="startDate" styleId="startDate"/>
	<html:text property="endDate" styleId="endDate"/>
    <html:text property="customerId" styleId="customerId"/>
</html:form>
</div>





<iframe src='about:blank'   scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
<form name="ReportForm" id="ReportForm">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="reportType" id="reportType" value="">
	
	<!--input type="hidden" name="startDateForm" id="startDateForm" value=""-->
	<!--input type="hidden" name="endDateForm" id="endDateForm" value=""-->
	
	<input type="hidden" name="customerIdForm" id="customerIdForm" value="">
	<input type="hidden" name="versionFrom" id="versionFrom" value="">
</form>