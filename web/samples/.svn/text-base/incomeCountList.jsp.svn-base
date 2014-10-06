<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="incomeList.title"/></title>
<content tag="heading"><fmt:message key="incomeList.heading"/></content>
<meta name="menu" content="IncomeMenu"/>



<script type="text/javascript" src="<c:url value='/dwr/interface/OrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/order.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/income.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/finance/incomeCountService.js'/>"></script>

    
<table width="100%" border="1" cellpadding="0" cellspacing="0">
  <tr>
  	<td><table width="30%" border="0">
  		<tr>
		    <td width="200" nowrap="nowrap">
				<select name="customerId" id="customerId"/>
		    </td>
		    <td><input type="button" id="btn_search" value='<fmt:message key="button.search"/>'></td>
	    </tr>
	    </table>
    </td>
    <td width="45%">
    <table width="100%" border="1" cellpadding="0" cellspacing="0">
        <tr> 
          <td width="30%"> 
			          	<table id="incomeList" class=ListShort width="100%" cellpadding="0" >
			              <thead>
			                <TR class=Header> 
			                  <TH><input type="checkbox" id="incomeAllSelect" headerClass="sortable"  media="html"/></TH>
			                  <!--付款日期-->
			                  <TH><fmt:message key="incomeForm.incomeDate"/></TH>
			                  <!--付款单位-->
			                  <TH><fmt:message key="incomeForm.customerId"/></TH>
			                  <!--付款编号-->
			                  <TH><fmt:message key="incomeForm.incomeCode"/></TH>
			                  <!--到宽金额-->
			                  <TH><fmt:message key="incomeForm.incomeMoney"/></TH>
			                  <!--分配金额-->
			                  <!-- TH><fmt:message key="incomeForm.incomeUsed"/></TH -->
			                  
			                  <!-- TH id="incomeListRow" name="incomeListRow" style="cursor:hand" colspan="2">
			                  		<fmt:message key="button.operation"/> </TH -->
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
				              
			              
			              <tbody id="incomeBody"/>
			              
			              </thead>
				          <tbody>
				          <tr height="20"><td colspan="11">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
						  				 <tr>
						  				 	 <td colspan="2"><IMG src="image/s.gif"  width="100%" height="2">
						  				 	 </td>
						  				 </tr>
				                        <tr  bgcolor="#D8DFE7">
				                          <td align="right"> 
				                              <div id="pageInfoincome"></div>
				                          </td>
				                     	</tr>
							  </table>
							  </td>
				          </tr>
				          </tbody>
				          
				          </table>
				          
          </td>
        </tr>
      </table>
    </td>
    <td width="5%">
    &nbsp;
    </td>
    <td width="50%">
    <table width="100%" border="1" cellpadding="0" cellspacing="0">
        <tr> 
          <td width="30%"> 
			          	<table  id="orderList" class=ListShort width="100%" cellpadding="0" >
			              <thead>
			                <TR class=Header> 
			                  <TH><input type="checkbox" id="orderAllSelect" headerClass="sortable"  media="html"/></TH>
			                  <!--订单号-->
			                  <TH><fmt:message key="orderForm.orderCode"/></TH>
			                  <!--合同号-->
			                  <TH><fmt:message key="orderForm.contractId"/></TH>
			                  <!--广告单位-->
			                  <TH><fmt:message key="orderForm.customerName"/></TH>
			                  <!--开始日期-->
			                  <TH><fmt:message key="orderForm.publishStartDate"/></TH>
			                  <!--结束日期-->
			                  <TH><fmt:message key="orderForm.publishEndDate"/></TH>
			                  <!--应付金额-->
			                  <TH><fmt:message key="orderForm.moneySum"/></TH>
			                  <!--已付金额-->
			                  <TH><fmt:message key="orderForm.moneyIn"/></TH>
			                  <!--审核-->
			                  <TH><fmt:message key="orderForm.isCkecked"/></TH>
			                  
			                  <TH id="orderListRow" name="orderListRow" style="cursor:hand" colspan="2">
			                  		<fmt:message key="button.operation"/> </TH>
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
				              
			              
			              <tbody id="orderBody"/>
			              
			              </thead>
				          <tbody>
				          <tr height="20"><td colspan="11">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
						  				 <tr>
							  				 	 <td colspan="2"><IMG src="image/s.gif"  width="100%" height="2">
							  				 	 </td>
							  				 </tr>
					                        <tr  bgcolor="#D8DFE7">
					                          <td align="right"> 
					                              <div id="pageInfoorder"></div>
					                          </td>
					                     	</tr>
							  </table>
							  </td>
				          </tr>
				          </tbody>
				          
				          </table>
				          
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>






