<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="incomeList.title"/></title>
<content tag="heading"><fmt:message key="incomeList.heading"/></content>
<meta name="menu" content="IncomeMenu"/>

<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/income.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>



<!-- script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.form.ClearableComboBox.js'/>"></script -->
<script type="text/javascript" src="<c:url value='/scripts/finance/incomeListService.js'/>"></script>



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
                  
                      <td width="1px" id="orgId_td"> <select id="orgId2" name="orgId2"/> </td>
                   


                      
                      <td align="left" width="1px"><select name="select" id="carrierName2"/></td>
                      
                      <td align="left" width="1px">
                      			<select name="month" id="month">  
                      				<option value="0"><fmt:message key="orderDayInfoForm.pickMonth"/><fmt:message key="yearAnalyze.moneyPull"/><fmt:message key="contractTargetMonthForm.monthDate"/>...</option>
	                      			<option value="01"><fmt:message key="business.month.jan"/></option>
	                      			<option value="02"><fmt:message key="business.month.feb"/></option>
									<option value="03"><fmt:message key="business.month.mar"/></option>
									<option value="04"><fmt:message key="business.month.apr"/></option>
	                      			<option value="05"><fmt:message key="business.month.may"/></option>
									<option value="06"><fmt:message key="business.month.jun"/></option>
									<option value="07"><fmt:message key="business.month.jul"/></option>
	                      			<option value="08"><fmt:message key="business.month.aug"/></option>
									<option value="09"><fmt:message key="business.month.sep"/></option>
									<option value="10"><fmt:message key="business.month.oct"/></option>
	                      			<option value="11"><fmt:message key="business.month.nov"/></option>
									<option value="12"><fmt:message key="business.month.dec"/></option> 
								</select>
                      </td>
                              
                      <td align="left" width="1px">
                      	<select name="putToChannel" id="putToChannel">
                      			<option value="-100">==<fmt:message key="incomePullList.heading"/>==</option>
                      			<option value="-1"><fmt:message key="incomePullList.notpull"/></option>
								<option value="-2"><fmt:message key="incomePullList.pull"/></option>
						</select>
                      </td>
                      
                      
                      <td width="1px">
                      
                     	 <div style="position:relative;overflow:visible">    
		    
		       			 <input type="button"    class="button" style="CURSOR: pointer;" id="btn_searche" value='查询'>

		      	
		     			 <div id="theDivSearch" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:500px;height:400px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1">	
			
						       <table width="100%">
					                 
							              	 <tr>
							              	 <td align="left" colspan="5">&nbsp</td>
							              	 </tr>
							              	 
							              	  <tr> 
							              	  <td><fmt:message key="incomeForm.incomeCode"/><input  type ="text" id ="income_code" style="width:138px;"></td>
							              	 <td>
							                   <fmt:message key="yearAnalyze.moneyPull"/><fmt:message key="orderDayInfoForm.startDate"/><input size="10px" type ="text" id ="beginDatePull">
							                 </td>
							                
							                 <td>
							                   <fmt:message key="yearAnalyze.moneyPull"/><fmt:message key="orderDayInfoForm.endDate"/><input size="10px" type ="text" id ="overDatePull">
							                 </td>
							                 <td>&nbsp</td>
							              	 </tr>
							              	 
							                 <tr>
							                 
							                 <td><fmt:message key="orderForm.customerName"/>
							                 <sapn>
							                 <div id="extCustomerDiv" name="extCustomerDiv" />
										       </sapn>
									          
								           	</td>
									
							                 <td>
							                  <fmt:message key="yearAnalyze.toaccount"/><fmt:message key="orderDayInfoForm.startDate"/><input size="10px" type ="text" id ="beginDate">
							                </td>
							                
							                 <td>
							                   <fmt:message key="yearAnalyze.toaccount"/><fmt:message key="orderDayInfoForm.endDate"/><input size="10px" type ="text" id ="overDate">
							                 </td>
							                 
							                  <td>&nbsp</td>
									</tr> 
											 
									<tr><td align="left" colspan="5">&nbsp</td></tr>
				
								         <tr><td align="left" colspan="5">&nbsp</td></tr>
												 
								         <tr>
												 <td>
												 <input  style="CURSOR: pointer;" type="button"  id="query" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.confim"/>&nbsp;&nbsp;&nbsp;&nbsp;'>
												 </td>
												 
												 <td>
												 <input  style="CURSOR: pointer;" type="button" id="btn_searche_close" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.cancel"/>&nbsp;&nbsp;&nbsp;&nbsp;'>
												 </td>
												 
												<td></td><td></td>
									 
									</tr>
							
							</table>		 

                     </div>
					  
  					  </td>	
  
                       
                       <td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_addIncome" value='添加'></td>   
                                           
                       <td width="1px"><div id="printReportDiv" name="printReportDiv"/></td>
	
					 
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
           
			<display:table name="incomeList" cellspacing="1" cellpadding="0"  decorator="com.vriche.adrm.webapp.util.IncomTableDecorator" 
			    id="incomeList" pagesize="18" class="tableDisplay"
			    partialList="true" size="resultSize"  
	    		export="false" requestURI="incomes.html">    

			<display:column property="createBy" sortable="true" headerClass="sortable" class="sortableCenter"
		         titleKey="orderDayInfoForm.number"/><!--序号-->
		         
			<display:column  property="incomeCode"    sortable="true" headerClass="sortable" media="html"
		        titleKey="incomeForm.incomeCode"/>        <!--付款编号-->
		        
		    <display:column  property="incomeDate"    sortable="true" headerClass="sortable"
				decorator="com.vriche.adrm.webapp.util.ConvertNum2DateWrapper"
		        titleKey="incomeForm.incomeDate"/>        <!--付款日期-->     
		        
		    <display:column property="customer.customerName" sortable="true" headerClass="sortable"
		         url="/editCustomer.html" paramId="id" paramProperty="customerId"
		         titleKey="incomeForm.customerId"/>       <!--付款单位-->
		               

		     
		     
		     <c:set var="isSignUserBalance" value='${appConfig["isSignUserBalance"]}'/>
			 <c:if test="${isSignUserBalance == '0'}">
			     <display:column sortable="true" headerClass="sortable" titleKey="business.name" media="html" >
			     		 <c:out value="${incomeList.user.firstName}"/>
				      	 <c:out value="${incomeList.user.lastName}"/>
			     </display:column>       <!--业务员-->   
			</c:if>
			<c:if test="${isSignUserBalance == '1'}">
			     <display:column sortable="true" headerClass="sortable" titleKey="moneyIn.name" media="html" >
			     		 <c:out value="${incomeList.user.firstName}"/>
				      	 <c:out value="${incomeList.user.lastName}"/>
			     </display:column>       <!--业务员-->   
			</c:if>
		     
		     
		     
		     
		         
		    <display:column property="incomeMoney" sortable="true" headerClass="sortable" class="sortableRight"
		         titleKey="incomeForm.incomeMoney" format="{0,number,##,###.##}" total="true"/><!--到宽金额-->
		         
		       
		     <display:column property="incomeUsed" sortable="true" headerClass="sortable" class="sortableRight"
		         titleKey="incomeForm.incomeUsed" format="{0,number,##,###.##}" /><!--分配金额-->          
		         
		         
		    <display:column property="incomeMode.name" sortable="true" headerClass="sortable" class="sortableRight"
		         titleKey="incomeForm.incomeModeId"/><!--方式-->
		         
		    <display:column property="incomePurpose.name" sortable="true" headerClass="sortable" class="sortableCenter"
		         titleKey="incomeForm.incomePurposeId"/><!--用途-->
		         
		  
		    <display:setProperty name="paging.banner.item_name" value="income"/>
		    <display:setProperty name="paging.banner.items_name" value="incomes"/>
		</display:table>
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
<html:form action="incomes" method="get" styleId="incomeListForm" >
	<html:text property="startDate" styleId="startDate"/>
	<html:text property="endDate" styleId="endDate"/>
	<html:text property="incomeModeName" styleId="incomeModeName"/>
	<html:text property="incomePurposeName" styleId="incomePurposeName"/>
    <html:text property="customerId" styleId="customerId"/>
    <html:text property="customerName" styleId="customerName"/>
    <html:text property="incomeCode" styleId="incomeCode"/>
    <html:text property="resourceCarrierId" styleId="resourceCarrierId"/>
    <html:text property="incomePullDate" styleId="incomePullDate"/>
    <html:text property="orgId" styleId="orgId"/>
</html:form>

<iframe src='about:blank'   scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
</div>

<script type="text/javascript">
   //highlightTableRows("incomeList");
</script>





<form name="ReportForm" id="ReportForm">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="reportType" id="reportType" value="">
	<input type="hidden" name="startDateForm" id="startDateForm" value="">
	<input type="hidden" name="endDateForm" id="endDateForm" value="">
	<input type="hidden" name="startDatePullForm" id="startDatePullForm" value="">
	<input type="hidden" name="endDatePullForm" id="endDatePullForm" value="">
	<input type="hidden" name="customerNameForm" id="customerNameForm" value="">
	<input type="hidden" name="resourceCarrierIdForm" id="resourceCarrierIdForm" value="">
	<input type="hidden" name="customerIdForm" id="customerIdForm" value="">
	<input type="hidden" name="currentUser" id="currentUser" value="">
	<input type="hidden" name="incomePullDateForm" id="incomePullDateForm" value="">
	<input type="hidden" name="orgIdForm" id="orgIdForm" value="">
	<input type="hidden" name="incomeCodeForm" id="incomeCodeForm" value="">
</form>