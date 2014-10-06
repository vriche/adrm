<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="orderList.title"/></title>
<content tag="heading"><fmt:message key="orderList.heading"/></content>
<meta name="menu" content="OrderMenu"/>


<script type="text/javascript" src="<c:url value='/dwr/interface/OrderManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/order.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/order/orderListService.js'/>"></script>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOrder.html"/>'"
        value="<fmt:message key="button.add"/>"/>
        
    <input type="button" id="submitChecked" value="<fmt:message key="button.order.chech"/>"/>    

</c:set>

<c:out value="${buttons}" escapeXml="false"/>

    <table width="100%" border="0" cellpadding="0" cellspacing="0">
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
				          </tr>
				          </tbody>
				          
				          </table>
				          
          </td>
        </tr>
      </table>