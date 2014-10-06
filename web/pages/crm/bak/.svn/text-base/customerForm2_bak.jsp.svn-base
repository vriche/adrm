 <%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="customerDetail.title"/></title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXToolbar.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTabbar.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlxToolbar_xp.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/dhtmlXCombo.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxCombo/dhtmlXCombo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>	

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTabbar/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTabbar/dhtmlXTabbar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxtabbar/dhtmlXTabbar_start.js'/>"></script>

<!-- 日历 -->
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/popupWindow.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/category.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customerType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/industry.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/contractpayment.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customerAddress.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/linkMan.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/linkHistory.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/contract.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/order.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/income.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/matter.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/feedBackInfo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderPublic.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CategoryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IndustryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerAddressManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/LinkManManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/LinkHisotryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ContractManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/FeedbackInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/customer/customerService2.js'/>"></script>

<content tag="heading"><fmt:message key="customerDetail.heading"/></content>
<input id="ctxPath" type="hidden" value="<c:url value="/"/>">    


<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                    <td><span class="tile1">
                   
                   <a href="#" id="Btn_save" class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.save"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
				   <a href="#" id="Btn_del"  class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.delete"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
				   <a href="#"  id="Btn_add"  class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
				   <a href="#" id="Btn_cancel" class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.cancel"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
				  
				   <a href="#" id="customer_Rel" class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="customerForm.cusRel"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
				<a href="#" id="customer_carrier_Rel" class="button">&nbsp;&nbsp;&nbsp;&nbsp;客户载体隶属关系&nbsp;&nbsp;&nbsp;&nbsp;</a>
				<a href="#" id="order_detail" class="button">&nbsp;&nbsp;&nbsp;&nbsp;远程签单&nbsp;&nbsp;&nbsp;&nbsp;</a>
   
   
                    </span>
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
            
            <!--   table start -->
 
<table width="99%" border="0" align="center">
  <tr>
    <td>
	
	<table width="100%" border="0">
        <tr> 
          <td>
          
          <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr> 
                <td width="50%"> 
                  <!--baseinso start-->
                  <fieldset>
                  <legend>
                  <!-- 基本信息 -->
                  <fmt:message key="customerForm.baseInfo"/></legend>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr> 
                      <td width="50%" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" id="ep">
                          <tbody>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel"> 
                                <!-- 客户类别 -->
                                <fmt:message key="customerForm.customerCategoryId"/>:
		                          	<td><select name="customerCategoryId" id="customerCategoryId"  style="CURSOR: pointer;width:120px;height:20px"/></td>
		                          
                              </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel"> 
                                <!-- 客户性质 --> 
                               <fmt:message key="customerForm.customerTypeId"/>:
		                          	<td><select name="customerTypeId" id="customerTypeId"  style="CURSOR: pointer;width:120px;height:20px"/></td>
		                          
                              </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="requiredInput"> 
                                <!-- 帐户名 -->
          						<fmt:message key="customerForm.customerName"/>:
          							<td><input name="customerName" id="customerName" type="text" style="CURSOR: pointer;width:116px;height:15px" size="20"></td>
                              
                              </td>
                            </tr>
                            
                             <tr> 
                              <td nowrap="nowrap" class="dataLabel"> 
                                <!-- 行业类别 -->
                                
                                <fmt:message key="customerForm.industryTypeId"/>:
		                          	<td><select name="industryTypeId" id="industryTypeId"  style="CURSOR: pointer;width:120px;height:20px"/></td>
		                          
                              </td>
                            </tr>
                            
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel"> 
                                <!-- 父级帐户 -->
                                <fmt:message key="customerForm.parentId"/>:
                                	<td><select name="parentId" id="parentId"  style="CURSOR: pointer;width:120px;height:20px"/></td>
                              		<!-- td><div id="theDivCustomerName" style="width:120px; height:20px;"></div>
                              		</td --> 
                              		
                              </td>
                            </tr>
                           
                          </tbody>
                        </table></td>
                      <td valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                          <tbody>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 帐户级别 -->
                                <fmt:message key="customerForm.customerLevel"/>:
                                	<td><select id="customerLevel" style="CURSOR: pointer; width:60px;" >
										<option value="0">0</option>
										<option value="1">1</option>
										<option value="2">2</option>
									</select></td>
									
                                </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 电话 -->
                              <fmt:message key="customerForm.telephone"/>:
          							<td><input name="telephone" id="telephone" type="text" style="CURSOR: pointer;width:116px;height:15px" size="20"></td>
          							
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 传真 -->
                               <fmt:message key="customerForm.fax"/>:
          							<td><input name="fax" id="fax" type="text" style="CURSOR: pointer;width:116px;height:15px" size="20"></td>
                               
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 公司主页 -->
                               <fmt:message key="customerForm.webSite"/>:
          							<td><input name="webSite" id="webSite" type="text" style="CURSOR: pointer;width:116px;height:15px" size="20"></td>
                               
                              </td>
                            </tr>
                            <tr> 
                              <td  class="requiredInput" nowrap="nowrap"> 
                                <!-- 助记码 -->
                               <fmt:message key="customerForm.helpCode"/>:
          							<td><input name="helpCode" id="helpCode" type="text" style="CURSOR: pointer;width:116px;height:15px" size="20"></td>
                               
                              </td>
                            </tr>
                          </tbody>
                        </table></td>
                    </tr>
                  </table>
                  </fieldset>
                  <!--baseinso end-->
                </td>
              </tr>
            </table>
            </td>
          <td>
          
          
          <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr> 
                <td width="50%"> 
                  <!--baseinso start-->
                  <fieldset>
                  <legend>
                  <!-- 帐务信息 -->
                  <fmt:message key="customerForm.accountInfo"/></legend>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr> 
                      <td width="50%" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                          <tbody>
                            <tr> 
                              <td  nowrap="nowrap" class="dataLabel" > 
                                <!-- 信用额度 -->
                               <fmt:message key="customerForm.creditAccount"/>:
          							<td colspan="2"><input name="creditAccount" id="creditAccount" type="text" style="CURSOR: pointer;width:116px;height:15px" size="20"></td>
                               
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap" > 
                                <!-- 信用期间 -->
                               <fmt:message key="customerForm.creditSpan"/>:
          							<td colspan="2"><input name="creditSpan" id="creditSpan" type="text" style="CURSOR: pointer;width:116px;height:15px" size="20"></td>
                              
                              </td>
                            </tr>
                            <tr>  
                              <td class="dataLabel" nowrap="nowrap" > 
                                <!-- 优惠比率 -->
                               <fmt:message key="customerForm.discountRate"/>:
          							<td colspan="2"><input name="discountRate" id="discountRate" type="text" style="CURSOR: pointer;width:116px;height:15px" size="20"></td>
                                
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 付款延期 -->
                                <fmt:message key="customerForm.delayDays"/>:
		                          	<td width="20%" ><div id="delayDateUnit" style="width:60px; height:18px;"></td>
		                          	
		                          	<td width="80%" ><select id="unit" style="CURSOR: pointer;" onChange="getDateTypeXML()">
                                		<!-- 日 -->
										<option value="1"><fmt:message key="contractForm.unit.date"/></option>
										<!-- 月 -->
										<option value="0"><fmt:message key="contractForm.unit.month"/></option>
									</select></td>
                                
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 帐期 -->
                                <fmt:message key="customerForm.paymentExpireDays"/>:
		                          	<td width="20%"><div id="paymentExpireDays" style="width:60px; height:18px;"></td>
		                          	
                                <!-- 号  -->
                                <td width="80%"><fmt:message key="customerForm.day"/></td>
                               </td>
                            </tr>
                          </tbody>
                        </table></td>
                      <td valign="top"><table width="900%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                          <tbody>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 开户名 -->
                                
                               <fmt:message key="customerForm.accountName"/>:
          							<td><input name="accountName" id="accountName" type="text" style="CURSOR: pointer;width:116px;height:15px" size="20"></td>
                                
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 开户银行 -->
                                
                               <fmt:message key="customerForm.accountBank"/>:
          							<td><input name="accountBank" id="accountBank" type="text" style="CURSOR: pointer;width:116px;height:15px" size="20"></td>
                                
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 银行帐号 -->
                                
                               	<fmt:message key="customerForm.accountNumber"/>:
          							<td><input name="accountNumber" id="accountNumber" type="text" style="CURSOR: pointer;width:116px;height:15px" size="20"></td>
                                
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 法人代表 -->
                                
                                <fmt:message key="customerForm.ownerAgent"/>:
          							<td><input name="ownerAgent" id="ownerAgent" type="text" style="CURSOR: pointer;width:116px;height:15px" size="20"></td>
          							
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 开户地址 -->
                                
                               	<fmt:message key="customerForm.accountAddress"/>:
          							<td><input name="accountAddress" id="accountAddress" type="text" style="CURSOR: pointer;width:116px;height:15px" size="20"></td>
          							
                              </td>
                            </tr>
                          </tbody>
                        </table></td>
                    </tr>
                  </table>
                  </fieldset>
                  <!--baseinso end-->
                </td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td colspan="2">

		  </td>
        </tr>
      </table>
	  
	  </td>
  </tr>
  <tr>
         <td valign="top">
   
			<div id="tabbarconteiner" style="width: 100%; height: 50%; margin: 0 0 0 8px;">
				<div id="a_tabbar" ></div>
			</div>
	
			<iframe src="<c:url value="/blank.jsp"/>" style="height:243px; width:100%" frameborder="0" id="details" name="details"></iframe>
					
    
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
customerIds:<input name="customerIds" type="text" id="customerIds">
customerCategoryIds:<input name="customerCategoryIds" type="text" id="customerCategoryIds">
customerTypeIds:<input name="customerTypeIds" type="text" id="customerTypeIds">
industryTypeIds:<input name="industryTypeIds" type="text" id="industryTypeIds">

customerLevelForm:<input name="customerLevelForm" type="text" id="customerLevelForm">
telephoneForm:<input name="telephoneForm" type="text" id="telephoneForm">
faxForm:<input name="faxForm" type="text" id="faxForm">
webSitesForm:<input name="webSitesForm" type="text" id="webSitesForm">

creditAccountForm:<input name="creditAccountForm" type="text" id="creditAccountForm">
creditSpanForm:<input name="creditSpanForm" type="text" id="creditSpanForm">
discountRateForm:<input name="discountRateForm" type="text" id="discountRateForm">
delayDaysForm:<input name="delayDaysForm" type="text" id="delayDaysForm">
delayDateUnitForm:<input name="delayDateUnitForm" type="text" id="delayDateUnitForm">
paymentExpireDaysForm:<input name="paymentExpireDays" type="text" id="paymentExpireDays">

accountNameForm:<input name="accountNameForm" type="text" id="accountNameForm">
accountBankForm:<input name="accountBankForm" type="text" id="accountBankForm">
accountNumberForm:<input name="accountNumberForm" type="text" id="accountNumberForm">
ownerAgentForm:<input name="ownerAgentForm" type="text" id="ownerAgentForm">
accountAddressForm:<input name="accountAddressForm" type="text" id="accountAddressForm">

memoForm:<input name="memoForm" type="text" id="memoForm">
customerStateForm:<input name="customerStateForm" type="text" id="customerStateForm">



</div>


