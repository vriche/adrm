<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/sysParam.jsp" %>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title><fmt:message key="customerDetail.title"/></title>


<link  rel="stylesheet" type="text/css"  media="all"  href="<c:url value='/styles/${appConfig["theme"]}/tab/common.css'/>" />
<link  rel="stylesheet" type="text/css"   media="all" href="<c:url value='/styles/${appConfig["theme"]}/tab/news_style.css'/>" />
<link  rel="stylesheet" type="text/css"   media="all" href="<c:url value='/styles/${appConfig["theme"]}/tab/function_style.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>


<!-- 日历 -->
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/common/popupWindow.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/tab/tooltip.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/tab/customer_index.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/tab/ajax_inject.js'/>"></script>
       
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
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
<script type="text/javascript" src="<c:url value='/dwr/interface/ContractPaymentManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerAddressManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/LinkManManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/LinkHisotryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ContractManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/FeedbackInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/customer/customerService1.js'/>"></script>

<content tag="heading"><fmt:message key="customerDetail.heading"/></content>



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
 
<table width="100%" border="0">
  <tr>
    <td>
      <html:form action="saveCustomer" method="post" styleId="customerForm" onsubmit="return validateCustomerForm(this)">
      <html:hidden property="id" styleId="customerId"/>
      <html:hidden property="version"/>	
	
	
	
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
                  <table width="99%" border="0" cellpadding="0" cellspacing="0">
                    <tr> 
                      <td width="50%" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" id="ep">
                          <tbody>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel"> 
                                <!-- 客户类别 -->
                                <adrm_order:label key="customerForm.customerCategoryId"/>: 
                              </td>
                              <td > 
                                <div style="position:relative;">
								<span style="margin-left:100px;width:18px;overflow:hidden;">
                              <adrm_order:selectList name="customerCategorys" key="12"  level="0" toScope="page" /> 
                                <html:select property="customerCategoryId" styleId="customerCategory" style="width:137px;margin-left:-100px"> 
                                
                                <html:options collection="customerCategorys" property="value" labelProperty="label"/> 
                                </html:select> <html:errors property="customerCategoryId"/>	
		                          </span>
		                          </div> 
                              </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel"> 
                                <!-- 客户性质 -->
                                <adrm_order:label key="customerForm.customerTypeId"/>: 
                              </td>
                              <td > 
                                <div style="position:relative;">
									<span style="margin-left:100px;width:18px;overflow:hidden;">
			                              <adrm_order:selectList name="customerTypes" key="9"  toScope="page"/> 
			                                <html:select property="customerTypeId" styleId="customerTypeId" style="width:137px;margin-left:-100px"> 
			                                <html:option value=""></html:option> 
			                                <html:options collection="customerTypes" property="value" labelProperty="label"/> 
			                                </html:select> <html:errors property="customerTypeId"/>	
			                          </span>
		                          </div> 
                              </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="requiredInput"> 
                                <!-- 帐户名 -->
                                <adrm_order:label key="customerForm.customerName"/>: 
                              </td>
                              <td> <html:errors property="customerName"/> 
                              <html:text property="customerName" styleId="customerName"/> 
                              </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel"> 
                                <!-- 父级帐户 -->
                                <adrm_order:label key="customerForm.parentId"/>: 
                              </td>
                              <td> 

		                          
                                <div style="position:relative;">
									<span style="margin-left:100px;width:18px;overflow:hidden;">
			  						  <adrm_order:selectList name="customers" key="8"  toScope="page"/> 
			                          <html:select property="parentId" styleId="parentId"  style="width:140px;margin-left:-100px" onchange="this.parentNode.nextSibling.value=this.value"> 
			                          <html:option value=""></html:option><html:options collection="customers"  property="value" labelProperty="label"/> 
			                          </html:select> 								
									</span><input name="customerName" style="width:100px;position:absolute;left:0px;"> 
										<html:errors property="parentId"/>  
								</div>   		                          
		                          
		                          
		                          
		                            
                                <img src="../image/tab/lookup.gif" width="24" height="16"> 
                              </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel"> 
                                <!-- 行业类别 -->
                                <adrm_order:label key="customerForm.industryTypeId"/>: 
                              </td>
                              <td> 
                              
                                <div style="position:relative;">
								<span style="margin-left:100px;width:18px;overflow:hidden;">
                              <adrm_order:selectList name="industryTypes" key="6"  toScope="page"/> 
                                <html:select property="industryTypeId" styleId="industryTypeId" style="width:140px;margin-left:-100px"> 
                                <html:option value=""/> 
                                <html:options collection="industryTypes"  property="value" labelProperty="label"/> 
                                </html:select> 
                                <html:errors property="industryTypeId"/>	
                                </span></div>
                                
                              </td>
                            </tr>
                          </tbody>
                        </table></td>
                      <td valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                          <tbody>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 帐户级别 -->
                                <adrm_order:label key="customerForm.customerLevel"/>: 
                              </td>
                              <td> 
                                <div style="position:relative;">
								<span style="margin-left:100px;width:18px;overflow:hidden;">
                              <html:select property="customerLevel" styleId="customerLevel" style="width:137px;margin-left:-100px"> 
                                <html:option value="0">0</html:option> <html:option value="1">1</html:option> 
                                <html:option value="2">2</html:option> </html:select> 
                                <html:errors property="customerLevel"/> 
                                </span></div>
                                </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 电话 -->
                                <adrm_order:label key="customerForm.telephone"/>: 
                              </td>
                              <td> 
                              <html:errors property="telephone"/> 
                              <html:text property="telephone" styleId="telephone"/> 
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 传真 -->
                                <adrm_order:label key="customerForm.fax"/>:
                              </td>
                              <td> 
                              <html:errors property="fax"/>
                               <html:text property="fax" styleId="fax" /> 
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 公司主页 -->
                                <adrm_order:label key="customerForm.webSite"/>: 
                              </td>
                              <td> 
                                <html:errors property="webSite"/>
                               <html:text property="webSite" styleId="webSite"/> 
                              </td>
                            </tr>
                            <tr> 
                              <td  class="requiredInput" nowrap="nowrap"> 
                                <!-- 助记码 -->
                                <adrm_order:label key="customerForm.helpCode"/>: 
                              </td>
                              <td> 
                                <html:errors property="helpCode"/>
                               <html:text property="helpCode" styleId="helpCode"/> 
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
                  <adrm_order:label key="customerForm.accountInfo"/></legend>
                  <table width="99%" border="0" cellpadding="0" cellspacing="0">
                    <tr> 
                      <td width="50%" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                          <tbody>
                            <tr> 
                              <td  nowrap="nowrap" class="dataLabel"> 
                                <!-- 信用额度 -->
                                <adrm_order:label key="customerForm.creditAccount"/>: 
                              </td>
                              <td> 
                               <html:errors property="creditAccount"/>
                               <html:text property="creditAccount" styleId="creditAccount"  /> 
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 信用期间 -->
                                <adrm_order:label key="customerForm.creditSpan"/>: 
                              </td>
                              <td> <html:errors property="creditSpan"/> <html:text property="creditSpan" styleId="creditSpan"  /> 
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 优惠比率 -->
                                <adrm_order:label key="customerForm.discountRate"/>(%): 
                              </td>
                              <td> 
                                 <html:errors property="discountRate"/> 
                                 <html:text property="discountRate" styleId="discountRate"/>
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 付款延期 -->
                                <adrm_order:label key="customerForm.delayDays"/>: 
                              </td>
                              <td> <adrm_order:selectList name="days" key="11"  toScope="page"/> 
                                <html:select property="delayDays" styleId="delayDays" > 
                                <html:options collection="days" property="value" labelProperty="label"/> 
                                </html:select> <html:errors property="delayDays"/>	
                                <html:select property="delayDateUnit" styleId="delayDateUnit"> 
                                <html:option value="0">
                                <!-- 天 -->
                                <adrm_order:label key="contractForm.unit.date"/></html:option> 
                                <html:option value="1">
                                <!-- 月 -->
                                <adrm_order:label key="contractForm.unit.month"/></html:option> 
                                </html:select> <html:errors property="delayDateUnit"/> 
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 帐期 -->
                                <adrm_order:label key="customerForm.paymentExpireDays"/>: 
                              </td>
                              <td> <adrm_order:selectList name="days" key="11"  toScope="page"/> 
                                <html:select property="paymentExpireDays" styleId="paymentExpireDays"> 
                                <html:options collection="days" property="value" labelProperty="label"/> 
                                </html:select> <html:errors property="paymentExpireDays"/> 
                                <!-- 号  -->
                                <adrm_order:label key="customerForm.day"/></td>
                            </tr>
                          </tbody>
                        </table></td>
                      <td valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                          <tbody>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 开户名 -->
                                <adrm_order:label key="customerForm.accountName"/>: 
                              </td>
                              <td> <html:errors property="accountName"/> <html:text property="accountName" styleId="accountName"  /> 
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 开户银行 -->
                                <adrm_order:label key="customerForm.accountBank"/>: 
                              </td>
                              <td> <html:errors property="accountBank"/> <html:text property="accountBank" styleId="accountBank"  /> 
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 银行帐号 -->
                                <adrm_order:label key="customerForm.accountNumber"/>: 
                              </td>
                              <td> <html:errors property="accountNumber"/> <html:text property="accountNumber" styleId="accountNumber"  /> 
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 法人代表 -->
                                <adrm_order:label key="customerForm.ownerAgent"/>: 
                              </td>
                              <td> <html:errors property="ownerAgent"/> <html:text property="ownerAgent" styleId="ownerAgent"  /> 
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 开户地址 -->
                                <adrm_order:label key="customerForm.accountAddress"/>: 
                              </td>
                              <td> <html:errors property="accountAddress"/> <html:text property="accountAddress" styleId="accountAddress"  /> 
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
          <!-- fieldset style="width:99%">
                  <legend></legend>
                  
					        <input type="button" id="Btn_add" value="<fmt:message key="button.add"/>">
					          
					        <input type="button" id="Btn_save" value="<fmt:message key="button.save"/>">
				
							<input type="button" id="Btn_del" value="<fmt:message key="button.delete"/>">

					        <input type="button" id="Btn_cancel" value="<fmt:message key="button.cancel"/>">
	        
		 </fieldset -->
		  </td>
        </tr>
      </table>
      
      
           <div id="hiddenArea" style="display:none">
                
	      		<adrm_order:selectList name="industryTypes" key="6"  toScope="page"/> 
	            <html:select property="id" styleId="dtIndustryTypeId" name="dtIndustryTypeId"  value="0" > 
	            	<html:option value=""/> 
	            	<html:options collection="industryTypes"  property="value" labelProperty="label"/> 
	            </html:select> <html:errors property="id"/>	
	            
                <adrm_order:country name="countries" toScope="page"/>
                <html:select property="id" styleId="country" styleClass="select">
                    <html:option value=""/>
                    <html:options collection="countries" property="value" labelProperty="label"/>
                </html:select>
                <html:errors property="id"/>	   
                
				<adrm_order:selectList name="areaCitys" key="27"  toScope="page"/> 
				<html:select property="id" styleId="province"  styleClass="select"> 
					 <html:options collection="areaCitys"  property="value" labelProperty="label"/> 
		  		</html:select>
				<html:errors property="id"/>								
		
                
 				<adrm_order:selectList name="selects" key="2" toScope="page"/> 
                     <html:select property="id" styleId="linkManId" styleClass="select"> 
                     <html:option value=""/> <html:options collection="selects" property="value" labelProperty="label"/> 
                </html:select>
                <html:errors property="id"/>        
                        
 				<adrm_order:selectList name="selects" key="17" toScope="page"/> 
                     <html:select property="id" styleId="incomeModeId" styleClass="select"> 
                     <html:option value=""/> <html:options collection="selects" property="value" labelProperty="label"/> 
                </html:select>
                <html:errors property="id"/>     
                
 				<adrm_order:selectList name="selects" key="18" toScope="page"/> 
                     <html:select property="id" styleId="incomePurposeId" styleClass="select"> 
                     <html:option value=""/> <html:options collection="selects" property="value" labelProperty="label"/> 
                </html:select>
                <html:errors property="id"/>   
                
                
                                                         
           </div>
   </html:form>	  
	  
	  </td>
  </tr>
  <tr>
       <td valign="top">
    
    
    <div id="div1" style="display:none "><input id="txt" type="text" style="width:97%; background-color:#EAEAEA"></div>

				 <!--bodyTabs start-->    
				<div id="tabcontainer" >
				
				
				
					<div class="tab-pane" id="top">
					
					
					
					
					<div class="tab-page" >
				      <h2 class="tab">
	<!-- 地址信息 -->
		                  <span id="top_address">
						  	<fmt:message key="customerForm.tabs.address"/>
						  </span>
						  
					  </h2>
					  	
				      <div id="top-customerAddress"> 
							
							<table id="customerAddressList" class=ListShort width="100%" cellpadding="0" >
					              <thead>
					                <TR class=Header>   
					                  <!--地址类别-->
					                  <TH><fmt:message key="customerAddressForm.addresType"/></TH>
					                  <!--地址-->
					                  <TH><fmt:message key="customerAddressForm.address"/></TH>
									  <!--城市 -->
									  <TH><fmt:message key="customerAddressForm.city"/></TH>
					                  <!--国家 -->
					                  <TH><fmt:message key="customerAddressForm.country"/></TH>									  
					                  <!--邮编-->
					                  <TH><fmt:message key="customerAddressForm.postalCode"/></TH>
					                  <!--直辖市/省-->
					                  <TH><fmt:message key="customerAddressForm.province"/></TH>
					                  
					                  
					                    <th width="10%" id="button_add_new_obj"  style="cursor:hand" colspan="2" onclick="button_add_new_obj(0)">
					                    
						                      <fmt:message key="button.operation"/>
						                      <img  name="Bt_addNewCustomerAddress" id="Bt_addNewCustomerAddress" src="image/CRM_ADD.GIF" border="0">
					                    
					                     </th>
					                  
					                </TR>
					                
					                <tr > 
					                  <td colspan="8">
						                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
						                      <tr> 
						                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
						                      </tr>
						                    </table>
					                    </td>
					                </tr>
					              </thead>
					              
					              <tbody id="customerAddressBody"/>
					              
						 
			
									<tbody>
										<tr height="2"><td colspan="8">
										   <table width="100%" border="0" cellspacing="0" cellpadding="0">
								  				    <tr><td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td></tr>
							                        <tr  bgcolor="#D8DFE7"> 
							                          <td align="right"> 
							                              <div id="pageInfo_customerAddress"></div>
							                          </td>
							                      </tr>
										   </table>	  						
										</td></tr>
									</tbody>
						</table> 				        
				      
				      

				      </div>
				    </div>
	
	
	
	
	
	
	
					<div class="tab-page">
							
				      <h2 class="tab">
				      
	<!-- 联系人 -->        <span id="top_linkman">
						  	<fmt:message key="customerForm.tabs.linkMan"/>
						  </span>
						  
					  </h2>
							
				      <div id="top-linkman"> 
					         
							<table id="linkmanList" class=ListShort width="100%" cellpadding="0" >
					              <thead>
					                <TR class=Header>   
					                  <!--姓名-->
					                  <TH><fmt:message key="linkManForm.linkmanName"/></TH>
					                  <!--家庭电话-->
					                  <TH><fmt:message key="linkManForm.homeTel"/></TH>
									  <!--办公电话 -->
									  <TH><fmt:message key="linkManForm.officeTel"/></TH>
					                  <!--移动电话 -->
					                  <TH><fmt:message key="linkManForm.mobile"/></TH>									  
					                  <!--邮件-->
					                  <TH><fmt:message key="linkManForm.favorEmail"/></TH>
					                  
					                  <TH><fmt:message key="linkman.mainLinkMan"/></TH>
					                  
					                  
					                    <th width="10%" id="button_add_new_obj"  style="cursor:hand" colspan="2" onclick="button_add_new_obj(1)">
					                    
						                      <fmt:message key="button.operation"/>
						                      <img  name="Bt_addNewLinkMan" id="Bt_addNewLinkMan" src="image/CRM_ADD.GIF" border="0">
					                    
					                     </th>
					                  
					                </TR>
					                
					                <tr > 
					                  <td colspan="8">
						                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
						                      <tr> 
						                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
						                      </tr>
						                    </table>
					                    </td>
					                </tr>
					              </thead>
					              
					              <tbody id="linkmanBody"/>
					              
						 
			
									<tbody>
										<tr height="2"><td colspan="8">
										   <table width="100%" border="0" cellspacing="0" cellpadding="0">
								  				    <tr><td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td></tr>
							                        <tr  bgcolor="#D8DFE7"> 
							                          <td align="right"> 
							                              <div id="pageInfo_linkman"></div>
							                          </td>
							                      </tr>
										   </table>	  						
										</td></tr>
									</tbody>
						</table> 					      
				      
				      
	
				      </div>
						</div>
						
				    <div class="tab-page"> 
				      <h2 class="tab">
<!-- 联系记录 -->       <span id="top_linkHisotry">
					  <fmt:message key="customerForm.tabs.linkHistory"/>
					  </span>
					  </h2>
							
				      <div id="top-linkHisotry"> 
	

							<table id="linkHisotryList" class=ListShort width="100%" cellpadding="0" >
					              <thead>
					                <TR class=Header>   
					                  <!--主题-->
					                  <TH><fmt:message key="linkHisotryForm.subject"/></TH>
					                  <!--时间-->
					                  <TH><fmt:message key="linkHisotryForm.linkDate"/></TH>
									  <!--联系人 -->
									  <TH><fmt:message key="linkHisotryForm.counterpartMan"/></TH>
					                  <!--接洽人 -->
					                  <TH><fmt:message key="linkHisotryForm.linkManId"/></TH>	
					                  
					                  
					                    <th width="10%" id="button_add_new_obj"  style="cursor:hand" colspan="2" onclick="button_add_new_obj(2)">
					                    
						                      <fmt:message key="button.operation"/>
						                      <img  name="Bt_addNewLinkHisotry" id="Bt_addNewLinkHisotry" src="image/CRM_ADD.GIF" border="0">
					                    
					                     </th>
					                  
					                </TR>
					                
					                <tr > 
					                  <td colspan="7">
						                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
						                      <tr> 
						                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
						                      </tr>
						                    </table>
					                    </td>
					                </tr>
					              </thead>
					              
					              <tbody id="linkHistoryBody"/>
					              
						 
			
									<tbody>
										<tr height="2"><td colspan="7">
										   <table width="100%" border="0" cellspacing="0" cellpadding="0">
								  				    <tr><td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td></tr>
							                        <tr  bgcolor="#D8DFE7"> 
							                          <td align="right"> 
							                              <div id="pageInfo_linkHistory"></div>
							                          </td>
							                      </tr>
										   </table>	  						
										</td></tr>
									</tbody>
						</table> 	
					
				      </div>
						</div>
						
				    <div class="tab-page"> 
				      <h2 class="tab"> 
<!-- 合同 -->		  <span id="top_contract">
					  <fmt:message key="customerForm.tabs.contracts"/>
					  </span>
					  </h2>
					  <div id="top-contract">
							
					         
							<table id="contractList" class=ListShort width="100%" cellpadding="0" >
					              <thead>
					                <TR class=Header>   
					                  <!--主题-->
					                  <TH><fmt:message key="contractForm.code"/></TH>
					                  <!--时间-->
					                  <TH><fmt:message key="contractForm.moneySum"/></TH>
									  <!--联系人 -->
									  <TH><fmt:message key="contractForm.moneyExec"/></TH>
					                  <!--接洽人 -->
					                  <TH><fmt:message key="contractForm.moneyIn"/></TH>
					                  <!--接洽人 -->
					                  <TH><fmt:message key="contractForm.startDate"/></TH>
					                  <!--接洽人 -->
					                  <TH><fmt:message key="contractForm.endDate"/></TH>
					                  <!--接洽人 -->
					                  <TH><fmt:message key="contractForm.state"/></TH>	
					                  
					                  
					                    <th width="10%"  style="cursor:hand" colspan="1">
						                      <img  name="Bt_addNewContract" id="Bt_addNewContract" src="image/CRM_ADD.GIF" border="0">
					                    
					                     </th>
					                  
					                </TR>
					                
					                <tr > 
					                  <td colspan="8">
						                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
						                      <tr> 
						                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
						                      </tr>
						                    </table>
					                    </td>
					                </tr>
					              </thead>
					              
					              <tbody id="contractBody"/>
					              
						 
			
									<tbody>
										<tr height="2"><td colspan="8">
										   <table width="100%" border="0" cellspacing="0" cellpadding="0">
								  				    <tr><td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td></tr>
							                        <tr  bgcolor="#D8DFE7"> 
							                          <td align="right"> 
							                              <div id="pageInfo_contract"></div>
							                          </td>
							                      </tr>
										   </table>	  						
										</td></tr>
									</tbody>
						</table> 

				      </div>
						</div>
						
						
						
						
						
						<div class="tab-page">
							
				      <h2 class="tab">
<!-- 销售订单 -->
					   <fmt:message key="customerForm.tabs.orders"/>
					  </h2>
						<div name="container" id="top-mr">
						
	
							<table id="orderList" class=ListShort width="100%" cellpadding="0" >
					              <thead>
					                <TR class=Header>   
					                  <!--主题-->
					                  <TH><fmt:message key="orderDetailForm.tb.number"/></TH>
					                  <!--时间-->
					                  <TH><fmt:message key="orderForm.orderCode"/></TH>
									  <!--联系人 -->
									  <TH><fmt:message key="orderForm.contractId"/></TH>
					                  <!--接洽人 -->
					                  <TH><fmt:message key="orderForm.publishStartDate"/></TH>	
					                  <!--时间-->
					                  <TH><fmt:message key="orderForm.publishEndDate"/></TH>
									  <!--联系人 -->
									  <TH><fmt:message key="orderForm.moneySum"/></TH>
					                  <!--接洽人 -->
					                  <TH><fmt:message key="orderForm.moneyIn"/></TH>
					                  <!--接洽人 -->
					                  <TH><fmt:message key="orderForm.isCkecked"/></TH>	
					                  
					                  
					                    <!--th width="10%" id=""  style="cursor:hand" colspan="2">
					                         <img  name="Bt_addNewOrder" id="Bt_addNewOrder" src="image/CRM_ADD.GIF" border="0">
					                    
					                     </th-->
					                  
					                </TR>
					                
					                <tr > 
					                  <td colspan="9">
						                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
						                      <tr> 
						                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
						                      </tr>
						                    </table>
					                    </td>
					                </tr>
					              </thead>
					              
					              <tbody id="orderBody"/>
					              
						 
			
									<tbody>
										<tr height="2"><td colspan="9">
										   <table width="100%" border="0" cellspacing="0" cellpadding="0">
								  				    <tr><td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td></tr>
							                        <tr  bgcolor="#D8DFE7"> 
							                          <td align="right"> 
							                              <div id="pageInfo_order"></div>
							                          </td>
							                      </tr>
										   </table>	  						
										</td></tr>
									</tbody>
						</table> 					
						
						

				      </div>
						</div>
						
						
						
						
					 <div class="tab-page">
				      <h2 class="tab">
<!-- 付款记录 -->
					<fmt:message key="customerForm.tabs.payment"/>
					  </h2>
					  
					  <div name="container" id="top-mr">

						         
								<table id="incomeList" class=ListShort width="100%" cellpadding="0" >
					              <thead>
					                <TR class=Header>   
					                  <!--主题-->
					                  <TH><fmt:message key="incomeForm.incomeDate"/></TH>
					                  <!--时间-->
					                  <TH><fmt:message key="incomeForm.incomeCode"/></TH>
									  <!--联系人 -->
									  <TH><fmt:message key="incomeForm.incomeMoney"/></TH>
					                  <!--接洽人 -->
					                  <TH><fmt:message key="incomeForm.incomeModeId"/></TH>	
					                  <!--接洽人 -->
					                  <TH><fmt:message key="incomeForm.incomePurposeId"/></TH>	
					                  <!--备注 -->
					                  <TH><fmt:message key="sysResourceForm.memo"/></TH>	
					                  
					                    <!--th width="10%" id=""  style="cursor:hand" colspan="2">
					                    
						                      <img  name="Bt_addNewIncome" id="Bt_addNewIncome" src="image/CRM_ADD.GIF" border="0">
					                    
					                     </th-->
					                  
					                </TR>
					                
					                <tr > 
					                  <td colspan="6">
						                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
						                      <tr> 
						                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
						                      </tr>
						                    </table>
					                    </td>
					                </tr>
					              </thead>
					              
					              <tbody id="incomeBody"/>
					              
						 
			
									<tbody>
										<tr height="2"><td colspan="6">
										   <table width="100%" border="0" cellspacing="0" cellpadding="0">
								  				    <tr><td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td></tr>
							                        <tr  bgcolor="#D8DFE7"> 
							                          <td align="right"> 
							                              <div id="pageInfo_income"></div>
							                          </td>
							                      </tr>
										   </table>	  						
										</td></tr>
									</tbody>
						</table> 							
						
				      </div>
						</div>
						
						
					<div class="tab-page">
				      <h2 class="tab">
<!-- 欠款记录 -->
					  <fmt:message key="customerForm.tabs.arrearage"/>
					  
					  </h2>
					  
					 <div name="container" id="top-mr">
							
						<table id="contractPaymentTable" class=ListShort width="100%" cellpadding="0" >
					              <thead>
					                <TR class=Header>              

					                   
					                  <!--次数-->
					                  <TH><fmt:message key="contractPaymentForm.payNumber"/></TH>
					                  <!--应付款日期-->
					                  <TH><fmt:message key="contractPaymentForm.payDate"/></TH>
									  <!--合同号 -->
									  <TH><fmt:message key="contractForm.code"/></TH>
					                  <!--定单号 -->
					                  <TH><fmt:message key="orderForm.orderCode"/></TH>									  
					                  <!--付款金额-->
					                  <TH><fmt:message key="contractPaymentForm.moneyPay"/></TH>
					                  <!--已分配金额-->
					                  <TH><fmt:message key="contractPaymentForm.moneyIn"/></TH>
					                </TR>
					                
					                <tr > 
					                  <td colspan="6">
						                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
						                      <tr> 
						                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
						                      </tr>
						                    </table>
					                    </td>
					                </tr>
					              </thead>
					              
					              <tbody id="paymentBody"/>
					              
						 
			
									<tbody>
										<tr height="2"><td colspan="6">
										   <table width="100%" border="0" cellspacing="0" cellpadding="0">
								  				    <tr><td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td></tr>
							                        <tr  bgcolor="#D8DFE7"> 
							                          <td align="right"> 
							                              <div id="pageInfo_payment"></div>
							                          </td>
							                      </tr>
										   </table>	  						
										</td></tr>
									</tbody>
						</table> 
				      </div>
						</div>
						

						
				    <div class="tab-page"> 
				      <h2 class="tab">
<!-- 关心产品 -->
 					  <fmt:message key="customerForm.tabs.products"/>					  
					  </h2>
					  <div name="container" id="top-product">
     
						         
						         
							<table id="matterList" class=ListShort width="100%" cellpadding="0" >
					              <thead>
					                <TR class=Header>   
					                  <!--主题-->
					                  <TH><fmt:message key="matterForm.name"/></TH>
					                  <!--时间-->
					                  <TH><fmt:message key="matterForm.edit"/></TH>
									  <!--联系人 -->
									  <TH><fmt:message key="matterForm.length"/></TH>
					                  <!--接洽人 -->
					                  <TH><fmt:message key="matterForm.tapeCode"/></TH>	
					                  
					                  
					                    <!--th width="10%" id=""  style="cursor:hand" colspan="2">
					                    
						                      <img  name="Bt_addNewMatter" id="Bt_addNewMatter" src="image/CRM_ADD.GIF" border="0">
					                    
					                     </th-->
					                  
					                </TR>
					                
					                <tr > 
					                  <td colspan="5">
						                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
						                      <tr> 
						                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
						                      </tr>
						                    </table>
					                    </td>
					                </tr>
					              </thead>
					              
					              <tbody id="matterBody"/>
					              
						 
			
									<tbody>
										<tr height="2"><td colspan="5">
										   <table width="100%" border="0" cellspacing="0" cellpadding="0">
								  				    <tr><td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td></tr>
							                        <tr  bgcolor="#D8DFE7"> 
							                          <td align="right"> 
							                              <div id="pageInfo_matter"></div>
							                          </td>
							                      </tr>
										   </table>	  						
										</td></tr>
									</tbody>
						</table> 	
													
						

					</div>
				</div>
				
				
				<div class="tab-page"> 
				      <h2 class="tab">
<!-- 意见反馈 -->
					  <fmt:message key="customerForm.tabs.feedback"/>					  
					  </h2>
					  <div name="container" id="top-pp">
					  
						         
							<table id="feedbackInfoList" class=ListShort width="100%" cellpadding="0" >
					              <thead>
					                <TR class=Header>   
						                  <!--主题-->
						                  <TH><fmt:message key="feedbackInfoForm.submitDate"/></TH>
						                  <!--时间-->
						                  <TH><fmt:message key="feedbackInfoForm.feeder"/></TH>
										  <!--联系人 -->
										  <TH><fmt:message key="feedbackInfoForm.feedContent"/></TH>
						                  <!--接洽人 -->
						                  <TH><fmt:message key="feedbackInfoForm.dealDate"/></TH>	
						                  <!--接洽人 -->
						                  <TH><fmt:message key="feedbackInfoForm.satisfactoryDegree"/></TH>	
					                  
					                  
					                      <!--TH width="10%" id=""  style="cursor:hand" colspan="2">
						                      <img  name="Bt_addNewFeedbackInfo" id="Bt_addNewFeedbackInfo" src="image/CRM_ADD.GIF" border="0">
					                      </TH-->
					                  
					                </TR>
					                
					                <tr > 
					                  <td colspan="6">
						                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
						                      <tr> 
						                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
						                      </tr>
						                    </table>
					                    </td>
					                </tr>
					              </thead>
					              
					              <tbody id="feedbackInfoBody"/>
					              
						 
			
									<tbody>
										<tr height="2"><td colspan="6">
										   <table width="100%" border="0" cellspacing="0" cellpadding="0">
								  				    <tr><td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td></tr>
							                        <tr  bgcolor="#D8DFE7"> 
							                          <td align="right"> 
							                              <div id="pageInfo_feedbackInfo"></div>
							                          </td>
							                      </tr>
										   </table>	  						
										</td></tr>
									</tbody>
						</table> 	
					

					</div>
				</div>
				
				<div id="tooltipdiv"></div> 
				<!-- script>getnews();</script --> 
				
				<table width="100%" border="0">
				  <tr>
				    <td>
				    <img id="pic_bank" src="image/cmenu/blank.gif">
				    </td>
				  </tr>
				</table>
				
					      
<!--bodyTabs  end-->                 	
	</div>
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
