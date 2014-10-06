<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="incomeList.title"/></title>
<content tag="heading"><fmt:message key="incomeList.heading"/></content>
<meta name="menu" content="IncomeMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editIncome.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
        
   <input type="button" onclick="console(this)"
        value="<fmt:message key="button.search"/>"/>       
        
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<script>
function console(obj){
$("searchArea").show();
//obj.setAttribute("value","<fmt:message key="button.done"/>");
}

</script>


<display:table name="incomeList" cellspacing="1" cellpadding="0" 
    id="incomeList" pagesize="9" class="tableDisplay incomeList"
    partialList="true" size="resultSize"  
    export="false" requestURI="">    
    
   <display:column property="incomeDate" sortable="true" headerClass="sortable"
         url="/editIncome.html" paramId="id" paramProperty="id"
         titleKey="incomeForm.incomeDate"/>		 <!--付款日期--> 

    <display:column property="incomeCode" sortable="true" headerClass="sortable"
        titleKey="incomeForm.incomeCode"/>        <!--付款编号-->
        
    <display:column property="customer.customerName" sortable="true" headerClass="sortable"
         url="/editIncome.html" paramId="id" paramProperty="id"
         titleKey="incomeForm.customerId"/>       <!--付款单位-->
               
        
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="incomeForm.createBy"/> <!--应付金额-->
         
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="incomeForm.createDate"/> <!--应付金额-->
         
         
    <display:column property="incomeMoney" sortable="true" headerClass="sortable"
         titleKey="incomeForm.incomeMoney"/><!--应付金额-->
         
    <display:column property="incomeMode.name" sortable="true" headerClass="sortable"
         titleKey="incomeForm.incomeModeId"/><!--方式-->
         
    <display:column property="incomePurpose.name" sortable="true" headerClass="sortable"
         titleKey="incomeForm.incomePurposeId"/><!--用途-->
         
         
    <display:setProperty name="paging.banner.item_name" value="income"/>
    <display:setProperty name="paging.banner.items_name" value="incomes"/>
</display:table>




<html:form action="incomes" method="post" styleId="incomeForm" onsubmit="return validateIncomeForm(this)">

<table width="50%" border="0" id="searchArea" style="display:none">
  <tr>
  
    <td>
        <adrm_order:label styleClass="desc" key="incomeForm.customerId"/>
        <html:errors property="customerId"/>	
	</td>
    <td>
        <div style="position:relative;">
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  		<adrm_order:selectList name="customers" key="8"  toScope="page"/> 
		                          <html:select property="customerId" styleId="customerId"  style="width:140px;margin-left:-100px" onchange="this.parentNode.nextSibling.value=this.value"> 
		                          <html:option value=""/> <html:options collection="customers"  property="value" labelProperty="label"/> 
		                          </html:select> 								
				</span><input name="customerName" style="width:100px;position:absolute;left:0px;"> 
		</div>  	
	</td>  
  
    <td>  
	     <adrm_order:label styleClass="desc" key="incomeForm.incomeModeId"/>
        <html:errors property="incomeModeId"/>
	</td>
    <td>
	  		<adrm_order:selectList name="selects" key="17" toScope="page"/> 
                     <html:select property="incomeModeId" styleId="incomeModeId" styleClass="select"> 
                     <html:option value=""/> <html:options collection="selects" property="value" labelProperty="label"/> 
        </html:select>
	</td>
	

    <td>
        <adrm_order:label styleClass="desc" key="incomeForm.incomePurposeId"/>
        <html:errors property="incomePurposeId"/>  	
	</td>
    <td>
 		<adrm_order:selectList name="selects" key="18" toScope="page"/> 
                     <html:select property="incomePurposeId" styleId="incomePurposeId" styleClass="select"> 
                     <html:option value=""/> <html:options collection="selects" property="value" labelProperty="label"/> 
         </html:select>	
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
    highlightTableRows("incomeList");
</script>
