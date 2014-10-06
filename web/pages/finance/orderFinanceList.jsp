<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="orderFinanceList.title"/></title>
<content tag="heading"><fmt:message key="orderFinanceList.heading"/></content>
<meta name="menu" content="IncomeMenu"/>

<script type="text/javascript" src="<c:url value='/scripts/class/incomePull.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/income.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/dwr/interface/IncomeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomePullManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/finance/orderFinanceListService.js'/>"></script>

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
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tbody>
                  <tr> 
                  <td><table><tr>
                      <td  align="left" width="12px">
						<div style="position:relative;overflow:visible">
							<input size="12px" name="customerName" id="customerName" type=text autocomplete=off value="==<fmt:message key="orderForm.customerName"/>==">
							<div name="theDivCustomerName" id="theDivCustomerName" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:370px;height:250px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
						</div>
					 </td>
					    <td  align="left">
	                    <select name="select" id="carrierName"/>
	                    </td>
	                    <td align="left">
	                     <select name="userOwner" id="userOwner"/>
					    </td>
					    <td>&nbsp;&nbsp;&nbsp;</td>
					   <td id="checklist">
					   
						<!-- 零单 --> 
						<input name="checkboxbutton" id="checkboxbutton" type="checkbox" value="1" >
							  <fmt:message key="customerForm.tabs.lingdan"/>
							  
					     <!-- 合同 -->
	                    <input name="checkboxbutton" id="checkboxbutton" type="checkbox" value="2">
							  <fmt:message key="customerForm.tabs.contracts"/>
						</td>
						<td>
					    <td>&nbsp;&nbsp;&nbsp;</td>
                        <td  align="left">
						<!--fmt:message key="orderDayInfoForm.startDate"/><input size="12px" type ="text" id ="beginDate">
                    	<fmt:message key="orderDayInfoForm.endDate"/><input size="12px" type ="text" id ="overDate"-->
						 <input  style="CURSOR: pointer;" type="button" name="search" id="query" value="&nbsp;&nbsp;<fmt:message key="oaCalendarEventForm.query"/>&nbsp;&nbsp;"/>           
                        </td>
                       </tr></table>
                        </td>
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
					
	              
	              <table width="100%" border="0" cellpadding="0" cellspacing="0">
	                   <tr>
			   			 <td>
						<table width="100%" border="0">
							<tr><td>
							<div id="financeList_div" style="position:relative;OVERFLOW: auto;width:880px;visibility:inherit;border:solid white 2px;background-color:#f5f5f5;z-index:0"-->
								<table  id="financeListTable" class=ListShort width="100%">
									      
								          <thead>
								            <tr class=Header> 
								              <!--订单号-->
								              <th><fmt:message key="orderDayInfoForm.orderId"/></th>
								              <!--合同号-->
								              <th><fmt:message key="incomeUsedForm.contractId"/></th>
								              <!--客户名称-->
								              <th><fmt:message key="linkManForm.customerId"/></th>
								              <!--已平帐金额-->
								              <th><fmt:message key="orderDetailForm.moneyIn"/></th>
								              <!--发票号-->
								              <th><fmt:message key="incomeDetail.id"/></th>
								              <!--到款日期-->
								              <th><fmt:message key="incomeForm.incomeDate"/></th>
								              <!--到款用途-->
								              <th><fmt:message key="incomeForm.incomePurposeId"/></th>
								              <!--应收总计-->
								              <th><fmt:message key="orderFinanceList.allMayGet"/></th>
								              <!--到款总计-->
								              <th><fmt:message key="orderFinanceList.allInMoney"/></th>
								             <!--未付金额-->
								              <th><fmt:message key="orderFinanceList.balanceMoney"/></th>
								              <!--签订人-->
								              <th><fmt:message key="orderFinanceList.theMan"/></th>
								               <!--频道名称-->
								              <th><fmt:message key="resourceChannelForm.name"/></th>
								              <!--首播日期-->
								              <th><fmt:message key="orderFinanceList.dateStart"/></th>
								              <!--尾播日期-->
								              <th><fmt:message key="orderFinanceList.dateEnd"/></th>
								              
								            </tr>
								          </thead>
								         <tbody id="incomePullBody"/>  
										</table>  
									   </div>	
						             </td></tr>
					               </table>
			                    </td>
			                  </tr>
			             </table> 
         
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
customerId2:<input name="customerId" type="text" id="customerId">
userdid:<input name="userId" type="text" id="userId">
customerCategoryId:<input name="customerCategoryId" type="text" id="customerCategoryId">

</div>

<div style="display:none;">
</div>

<script type="text/javascript">
    highlightTableRows("incomeList");
</script>



<iframe src='about:blank'   scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
<form name="ReportForm" id="ReportForm">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="reportType" id="reportType" value="">
	<input type="hidden" name="startDateForm" id="startDateForm" value="">
	<input type="hidden" name="endDateForm" id="endDateForm" value="">
	
	
	<input type="hidden" name="customerIdForm" id="customerIdForm" value="">
</form>