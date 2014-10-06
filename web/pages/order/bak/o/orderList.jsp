<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="orderList.title"/></title>
<content tag="heading"><fmt:message key="orderList.heading"/></content>
<meta name="menu" content="OrderMenu"/>



<c:set var="buttons">
           <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td><div align="right"> 
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr> 
                    <td width="30%">
	                    <!--合同编号--><fmt:message key="orderForm.orderCode"/>   
	                    <input type="text" name="textfield">
	                    <!--搜 索--> 
	    				<input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'" value="<fmt:message key="button.search"/>"/>
	                    </td>
                    <td>&nbsp;</td>
                    <td> 
                    	<div align="right"> 
                    	<!--新增 -->
                    	<input type="button" style="margin-right: 5px"  onclick="location.href='<c:url value="/editOrder.html"/>'"  value="<fmt:message key="button.add"/>"/>
                        <!--查找未审-->
                        <!--input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'" value="<fmt:message key="button.searchNoChecked"/>"/ -->
                        <!--提交审核-->
                        <!--input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'" value="<fmt:message key="button.submitChecked"/>"/ -->
                      </div></td>
                  </tr>
                </table>
          </c:set>
          <c:out value="${buttons}" escapeXml="false"/>
              </div></td>
          </tr>
          <tr> 
            <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
          </tr>
          <tr> 
            <td><TABLE class=ListShort >

                  <TR class=Header> 
                    <TH><input type="checkbox" name="allbox" value="allbox" onClick="selectAllCheckBox('orderCheckbox')"></TH>
                    <!--订单号--><TH><fmt:message key="orderForm.orderCode"/></TH>
                    <!--合同号--><TH><fmt:message key="orderForm.contractId"/></TH>
                    <!--广告单位--><TH><fmt:message key="orderForm.customerName"/></TH>
                    <!--开始日期--><TH><fmt:message key="orderForm.publishStartDate"/></TH>
                    <!--结束日期--><TH><fmt:message key="orderForm.publishEndDate"/></TH>
                    <!--应付金额--><TH><fmt:message key="orderForm.moneySum"/></TH>
                    <!--已付金额--><TH><fmt:message key="orderForm.moneyIn"/></TH>
                    <!--审核--><TH><fmt:message key="orderForm.isCkecked"/></TH>                    
                    <TH width="10%"><fmt:message key="button.done"/><img onClick="window.location='editOrder.html'"  src="image/CRM_ADD.GIF" border="0" height="14" width="14"></TH>
                  </TR>
                   <TBODY name="tbody" id="tbody">
                   
                    <%int i = 0;String myClass = "DataLight";%>
	                <logic:iterate id="orderList" name="orderList">
	                <% if(i++%2 == 0){myClass = "DataDark";}else{myClass = "DataLight";}%>
	                <TR class=<%=myClass%> > 
		                <TD  width="2%">
		                	<input type="checkbox" name="orderCheckbox" id="orderCheckbox" value="<bean:write name="orderList" property="id"/>">
		                </TD>
		                <TD>
		                 	 <html:link paramId="id" paramName="orderList" paramProperty="id" page="/editOrder.html">
		                 	 <bean:write name="orderList" property="orderCode"/></html:link>
		                </TD>
				        <TD><bean:write name="orderList" property="contract.code"/></TD>  
				        <TD><bean:write name="orderList" property="customer.customerName"/></TD> 
						<TD><bean:write name="orderList" property="orderPublic.publishStartDate"/></TD>                 				      
	                    <TD><bean:write name="orderList" property="orderPublic.publishEndDate"/></TD>
						<TD><bean:write name="orderList" property="orderPublic.moneyRealpay"/></TD>  
	                    <TD><bean:write name="orderList" property="orderPublic.moneyIn"/></TD>
						<TD><html-el:checkbox name="orderList" property="isCkecked"/></TD>  
						<TD width="10%">	
							  <img onClick="javascript:if(confirmDelete('OrderDetail')){ window.location='<c:url value="/editOrder.html?id="/><c:out value="${orderList.id}"/>&method=delete'}" src="image/button_delete.gif" >
		                      <img  style="cursor:hand" onClick="window.location='<c:url value="/editOrder.html?id="/><c:out value="${orderList.id}"/>'"  src="image/EDIT.GIF">
                      	</TD>
					</TR>								      
				    </logic:iterate>
				    

				    
		
				    
                </TBODY>
              </TABLE></td>
          </tr>
          <tr> 
            <td><TABLE width="100%" class=ListShort>
                <TBODY>
                  <TR class="Header"> 
                    <TD colspan="9"><div align="right">
                    
                 	    <logic:notEqual name="page" property="isEmpty" value="true">
						  <a href="orders.html?pageDirection=first"><fmt:message key="paging.banner.first"/></a>
						</logic:notEqual>
						
                        <logic:notEqual name="page" property="isFirstPage" value="true">
						  <a href="orders.html?pageDirection=previous"><fmt:message key="paging.banner.previous"/></a>
						</logic:notEqual>
						
						<logic:notEqual name="page" property="isLastPage" value="true">
						  <a href="orders.html?pageDirection=next"><fmt:message key="paging.banner.next"/></a>
						</logic:notEqual>
						
                         </div></TD>
                  </TR>
                </TBODY>
              </TABLE></td>
          </tr>
          <tr> 
            <td>&nbsp;</td>
          </tr>
        </table>


<script type="text/javascript">
    highlightTableRows("orderList");
</script>
