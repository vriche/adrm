<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="orderList.title"/></title>
<content tag="heading"><fmt:message key="orderList.heading"/></content>
<meta name="menu" content="OrderMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOrder.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
        

</c:set>

<c:out value="${buttons}" escapeXml="false"/>


<script>function console(obj){$("searchArea").show();}</script>


<display:table name="orderList" cellspacing="1" cellpadding="0" decorator="com.vriche.adrm.webapp.util.orderTableDecorator" 
    id="orderList" pagesize="9" class="tableDisplay orderList"
    partialList="true" size="resultSize" sort="list"   varTotals="totals"
    export="false" requestURI="/orders.html">
    
    <display:column  title="<input type=checkbox id=checkbox  onclick='selectAll' id=Bt_selectAll>"
     headerClass="sortable"  media="html"> 
 		<input type="checkbox" value='<c:out value="${orderList.id}"/>'><!--选择-->
	</display:column>  
	
    <display:column property="orderCode" sortable="true" headerClass="sortable"
         titleKey="orderForm.orderCode"/>      <!--订单号-->         
        
    <display:column property="contractId" sortable="true" headerClass="sortable"
         titleKey="orderForm.contractId"/>      <!--合同号-->       
         
     <display:column property="customer.customerName" sortable="true"  headerClass="sortable" 
         href="editCustomer.html"  paramId="id" paramProperty="customerId" autolink="true" 
         titleKey="orderForm.customerName"/>    <!--广告单位-->
                
    <display:column property="orderPublic.publishStartDate" 
         sortable="true" headerClass="sortable" 
         decorator="com.vriche.adrm.webapp.util.ConvertNum2DateWrapper"
         titleKey="orderForm.publishStartDate"/><!--开始日期-->
         
    <display:column property="orderPublic.publishEndDate" sortable="true" headerClass="sortable"
         decorator="com.vriche.adrm.webapp.util.ConvertNum2DateWrapper"
         titleKey="orderForm.publishEndDate"/>  <!--结束日期-->         
                 
     <display:column property="orderPublic.moneyRealpay" sortable="true" headerClass="sortable"
         format="{0,number,##,###.00}" 
         titleKey="orderForm.moneySum"/>		<!--应付金额-->
         
     <display:column property="orderPublic.moneyIn" sortable="true" headerClass="sortable"
        format="{0,number,###.00}"
         titleKey="orderForm.moneyIn"/> 		<!--已付金额-->      


     <display:column  titleKey="orderForm.isCkecked" headerClass="sortable" media="html"> <!--审核-->
 		<html-el:checkbox name="orderList" property="isCkecked" disabled="true"/>
	</display:column>   

	
	<display:column  titleKey="button.operation" 
		headerClass="sortable" style="width: 5%; padding-left: 15px" 
		property="opernation" media="html"/> <!--操作--> 
	

    <display:setProperty name="export.excel.filename" value="Order List.xls"/>
    <display:setProperty name="export.csv.filename" value="Order List.csv"/>
    <display:setProperty name="export.pdf.filename" value="Order List.pdf"/>
    
	<display:setProperty name="paging.banner.placement" value="top" />
    <display:setProperty name="paging.banner.group_size" value="6"/>
    <display:setProperty name="paging.banner.item_name" value="order"/>
    <display:setProperty name="paging.banner.items_name" value="orders"/>
</display:table>


<html:form action="orders" method="post" styleId="orderForm" onsubmit="return validateOrderForm(this)">

<table width="100%" border="0" id="searchArea" style="display:none">
  <tr>
  
    <td>
 		<adrm_order:label key="orderForm.orderCode"/>	
	</td>
    <td>
		<html:text property="orderCode" styleId="orderCode"/>  	
	</td>  
  
    <td>  
		<adrm_order:label key="orderForm.contractId"/>
	</td>
    <td>
		<html:text property="contract.code" styleId="orderContractCode"/> 
	</td>
	

    <td>
 		<adrm_order:label key="orderForm.userId"/>
	</td>
    <td>
                   <div style="position:relative;">
						<span style="margin-left:100px;width:18px;overflow:hidden;">
                        <adrm_order:selectList name="selects" key="2" toScope="page"/> 
                          <html:select property="userId" styleId="orderRelation" style="width:137px;margin-left:-100px"> 
                          <html:option value=""/> <html:options collection="selects" property="value" labelProperty="label"/> 
                          </html:select> <html:errors property="userId"/>
                          </span>
                 </div>
	</td>
	
    <td>
 		<adrm_order:label key="orderForm.customerName"/>
	</td>
	<td>
                                <div style="position:relative;">
								<span style="margin-left:100px;width:18px;overflow:hidden;">
		  						  <adrm_order:selectList name="customers" key="8"  toScope="page"/> 
		                          <html:select property="customerId" styleId="orderCustomerName"  style="width:137px;margin-left:-100px" onchange="this.parentNode.nextSibling.value=this.value"> 
		                          <html:option value=""/> <html:options collection="customers"  property="value" labelProperty="label"/> 
		                          </html:select> 								
								</span><input name="customerName" style="width:100px;position:absolute;left:0px;">
								</div>      
	</td>	
	
	<td>
         <html:submit styleClass="button" property="method.search" onclick="bCancel=true">
            <fmt:message key="button.search"/>
        </html:submit>	
	</td>
  </tr>
</table>
               
</html:form>

<script type="text/javascript">
    highlightTableRows("orderList");
</script>
