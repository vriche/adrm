<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="contractPaymentForm.urgencyAlert"/></title>
<content tag="heading"><fmt:message key="contractPaymentForm.urgencyAlert"/></content>
<meta name="menu" content="ContractMenu"/>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ContractPaymentManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/contractpayment.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/finance/contractPaymentListService.js'/>"></script>




<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                  
                    <td>
                  		<div style="position:relative;overflow:visible">
							<fmt:message key="orderForm.customerName"/><input  style="CURSOR: pointer;" size="12px" name="customerName" id="customerName" type=text autocomplete=off value="">
							<div name="theDivCustomerName" id="theDivCustomerName" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:450px;height:250px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
						</div>
                  </td>
                    <td>
 						<div><select name="carrierName" id="carrierName"/></div>
                  </td>
                 
                  
                  <td align="left">
                    
                    	<fmt:message key="orderForm.publishStartDate"/><input  style="CURSOR: pointer;" type="text" name="startDate" id="startDate" size="11">
						<fmt:message key="orderForm.publishEndDate"/><input  style="CURSOR: pointer;" type="text" name="endDate" id="endDate" size="11">
					
						 	<input  style="CURSOR: pointer;" type="button" id="Submit" value="&nbsp;&nbsp;<fmt:message key="oaCalendarEventForm.query"/>&nbsp;&nbsp;"/>
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


	<table class=ListShort width="100%" cellpadding="0" id="contractPaymentTable">
		<thead>
		<TR class=Header> 
		
		<!--合同号-->
		<TH><fmt:message key="contractForm.code"/></TH>
		<!--订单号-->
		<TH><fmt:message key="contractPaymentForm.orderId"/></TH>	
		<!--客户名称-->
		<TH><fmt:message key="contractForm.customerId"/></TH>
			
		<!--应付日期-->
		<TH><fmt:message key="contractPaymentForm.payDate"/></TH>				
		<!--应付金额-->
		<TH><fmt:message key="contractPaymentForm.moneyPay"/></TH>
		<!--已付金额-->
		<TH><fmt:message key="contractPaymentForm.money_In"/></TH>	
		<!--欠款-->
		<TH><fmt:message key="contractPaymentForm.moneyLeft"/></TH>
		
		
	
		</TR>
			<tr > 
			<td colspan="11">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr> 
			 	<td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
			   	</tr>
			   	</table>
			</td>
			</tr>
			</thead>
			
		<tbody id="contractPaymentTbody"/>
		
		<tbody>
			<tr height="2"><td colspan="11">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
					<tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
					<tr bgcolor="#D8DFE7"> 
						<td align="right"> 
							<div id="contractPaymentPageInfo"></div>
						</td>
					</tr>
				</table>	              
			</td></tr>
		</tbody>
		              
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
customerId:<input name="customerId" type="text" id="customerId">
userdid:<input name="userId" type="text" id="userId">
customerCategoryId:<input name="customerCategoryId" type="text" id="customerCategoryId">

</div>

