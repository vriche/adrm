<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="customerDetail.title"/></title>


<link  rel="stylesheet" type="text/css"  media="all"  href="<c:url value='/styles/${appConfig["theme"]}/tab/common.css'/>" />
<link  rel="stylesheet" type="text/css"   media="all" href="<c:url value='/styles/${appConfig["theme"]}/tab/news_style.css'/>" />
<link  rel="stylesheet" type="text/css"   media="all" href="<c:url value='/styles/${appConfig["theme"]}/tab/function_style.css'/>" />
        
<script typr="text/javascript" src="<c:url value='/scripts/customer/public.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/customer/agentInfo.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/customer/address.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/customer/linkMan.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/customer/linkHisotry.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/customer/contract.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/customer/order.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/customer/income.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/customer/payment.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/customer/matter.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/customer/feedbackInfo.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/AgentInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerAddressManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/LinkManManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/LinkHisotryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ContractManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ContractPaymentManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/FeedbackInfoManager.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/tab/tooltip.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/tab/news_index.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/tab/ajax_inject.js'/>"></script>


<content tag="heading"><fmt:message key="customerDetail.heading"/></content>
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
                              <td > <adrm_order:selectList name="customerCategorys" key="12"  level="0" toScope="page"/> 
                                <html:select property="customerCategoryId" styleId="customerCategory"> 
                                <html:option value="0">==Select==</html:option> 
                                <html:options collection="customerCategorys" property="value" labelProperty="label"/> 
                                </html:select> <html:errors property="customerCategoryId"/>	
                              </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel"> 
                                <!-- 客户性质 -->
                                <adrm_order:label key="customerForm.customerTypeId"/>: 
                              </td>
                              <td > <adrm_order:selectList name="customerTypes" key="9"  toScope="page"/> 
                                <html:select property="customerTypeId" styleId="customerTypeId"> 
                                <html:option value="0">==Select==</html:option> 
                                <html:options collection="customerTypes" property="value" labelProperty="label"/> 
                                </html:select> <html:errors property="customerTypeId"/>	
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
		                          <html:option value=""/> <html:options collection="customers"  property="value" labelProperty="label"/> 
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
                              <td> <html:select property="customerLevel" styleId="customerLevel"> 
                                <html:option value="0">0</html:option> <html:option value="1">1</html:option> 
                                <html:option value="2">2</html:option> </html:select> 
                                <html:errors property="customerLevel"/> </td>
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
                                <adrm_order:label key="customerForm.fax"/>: </td>
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
          <fieldset style="width:99%">
                  <legend></legend>
 						    <html:submit property="method.save" onclick="bCancel=false">
					            <fmt:message key="button.save"/>
					        </html:submit>
					
					        <html:submit property="method.delete" onclick="bCancel=true; return confirmDelete('Customer')">
					            <fmt:message key="button.delete"/>
					        </html:submit>
					
					        <html:cancel  onclick="bCancel=true">
					            <fmt:message key="button.cancel"/>
					        </html:cancel>
					        
					        <input type="button" style="margin-right: 5px"  onclick="location.href='<c:url value="/editCustomer.html"/>'"  value="<fmt:message key="button.add"/>"/>
		 </fieldset>
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
    <td>
    
    
    <div id="div1" style="display:none "><input id="txt" type="text" style="width:97%; background-color:#FFFFEF"></div>

				 <!--bodyTabs start-->    
				<div id="tabcontainer" >
				
				
				
					<div class="tab-pane" id="top">
					
					<div class="tab-page" >
				
				      <h2 class="tab">
<!-- 行业代理 -->       <span   id="top_agentInfo">
					  <fmt:message key="customerForm.tabs.industryAgent"/>
					  </span>
					  </h2>
							
				      
		              <div>

						<display:table name="agentInfoList" cellspacing="1" cellpadding="0"
							id="agentInfoList" pagesize="9" class="tableDisplay agentInfoList"
							export="false" requestURI="">
						
							<display:column property="industryTypeId" sortable="false" headerClass="sortable"
								 titleKey="agentInfoForm.industryTypeId"/>
							<display:column property="agentRate" sortable="false" headerClass="sortable"
								 titleKey="agentInfoForm.agentRate"/>
							<display:column property="beginDate" sortable="false" headerClass="sortable"
								 titleKey="agentInfoForm.beginDate"/>
							<display:column property="endDate" sortable="false" headerClass="sortable"
								 titleKey="agentInfoForm.endDate"/>
							<display:column property="state" sortable="false" headerClass="sortable"
								 titleKey="agentInfoForm.state"/>
								 
						     <display:column  title="<img  name='Bt_addAgentInfo' id='Bt_addAgentInfo' src='image/CRM_ADD.GIF'>" headerClass="sortable" media="html">
						 		<img  name="Bt_delAgentInfo_id" id="Bt_delAgentInfo_id" src="image/button_delete.gif" >
							</display:column>   								 
								 
							<display:setProperty name="paging.banner.item_name" value="agentInfo"/>
							<display:setProperty name="paging.banner.items_name" value="agentInfos"/>
							
						</display:table>
						
						
		              </div>
					</div>
						
						
					<div class="tab-page">
							
				      <h2 class="tab">
	<!-- 地址信息 -->
	                  <span   id="top_address">
					  <fmt:message key="customerForm.tabs.address"/>
					  </span>
					  </h2>
							
				      <div id="top-customerAddress"> 
				      
				      
					<display:table name="customerAddressList" cellspacing="1" cellpadding="0"
					    id="customerAddressList" pagesize="9" class="tableDisplay customerAddressList"
					    export="false" requestURI="">
					
					    <display:column property="addresType" sortable="false" headerClass="sortable"
					         titleKey="customerAddressForm.addresType"/><!--地址类别-->
					        
					    <display:column property="address" sortable="false" headerClass="sortable"
					         titleKey="customerAddressForm.address"/>	<!--地址-->
					         
					    <display:column property="city" sortable="false" headerClass="sortable"
					         titleKey="customerAddressForm.city"/>		<!--城市-->
					         
					    <display:column property="country" sortable="false" headerClass="sortable"
					         titleKey="customerAddressForm.country"/>	<!--国家-->
					         
					    <display:column property="postalCode" sortable="false" headerClass="sortable"
					         titleKey="customerAddressForm.postalCode"/><!--邮编-->
					         
					    <display:column property="province" sortable="false" headerClass="sortable"
					         titleKey="customerAddressForm.province"/>	<!--州/省-->
					         
						<display:column  title="<img  name='Bt_addAddress' id='Bt_addAddress' src='image/CRM_ADD.GIF'>" headerClass="sortable" media="html">
						 		<img  name="Bt_delAddress_id" id="Bt_delAddress_id" src="image/button_delete.gif" >
						</display:column>  					         
					         
					    <display:setProperty name="paging.banner.item_name" value="customerAddress"/>
					    <display:setProperty name="paging.banner.items_name" value="customerAddresss"/>
					</display:table>				      
				      
				      

				      </div>
						</div>
	
						<div class="tab-page">
							
				      <h2 class="tab">
				      
<!-- 联系人 -->        <span id="top_linkman">
					  <fmt:message key="customerForm.tabs.linkMan"/>
					  </span>
					  </h2>
							
				      <div id="top-linkman"> 
				      
				      
					<display:table name="linkManList" cellspacing="1" cellpadding="0"
					    id="linkManList" pagesize="3" class="tableDisplay"
					    export="false" requestURI="">
					
					    <display:column property="linkmanName" sortable="true" headerClass="sortable"
					        url="/editLinkMan.html" paramId="id" paramProperty="id"
					        titleKey="linkManForm.linkmanName"/>  <!--姓名-->
					    <display:column property="homeTel" sortable="false" headerClass="sortable"
					         titleKey="linkManForm.homeTel"/>	  <!--家庭电话-->
					    <display:column property="officeTel" sortable="false" headerClass="sortable"
					         titleKey="linkManForm.officeTel"/>	  <!--办公电话-->
					    <display:column property="mobile" sortable="false" headerClass="sortable"
					         titleKey="linkManForm.mobile"/>	  <!--移动电话-->
					    <display:column property="favorEmail" sortable="false" headerClass="sortable"
					         titleKey="linkManForm.favorEmail"/>  <!--邮件-->
					         
					         
						<display:column  title="<img  name='Bt_addLinkMan' id='Bt_addLinkMan' src='image/CRM_ADD.GIF'>" headerClass="sortable" media="html">
						 		<img  name="Bt_delLinkMan_id" id="Bt_delLinkMan_id" src="image/button_delete.gif" >
						</display:column> 
					         
					    <display:setProperty name="paging.banner.item_name" value="linkMan"/>
					    <display:setProperty name="paging.banner.items_name" value="linkMans"/>
					</display:table>				      
				      
				      
	
				      </div>
						</div>
						
				    <div class="tab-page"> 
				      <h2 class="tab">
<!-- 联系记录 -->       <span id="top_linkHisotry">
					  <fmt:message key="customerForm.tabs.linkHistory"/>
					  </span>
					  </h2>
							
				      <div id="top-linkHisotry"> 
				      
					<display:table name="linkHisotryList" cellspacing="1" cellpadding="0"
					    id="linkHisotryList" pagesize="9" class="tableDisplay linkHisotryList"
					    export="false" requestURI="">
				         					
					    <display:column property="subject" sortable="false" headerClass="sortable"
					         titleKey="linkHisotryForm.subject"/>     <!--主题-->
					         
					    <display:column property="linkDate" sortable="false" headerClass="sortable"
					         titleKey="linkHisotryForm.linkDate"/>   <!--时间-->

					    <display:column property="linkManId" sortable="false" headerClass="sortable"
					         titleKey="linkHisotryForm.linkManId"/>   <!-- 	联系人-->
					         
					    <display:column property="counterpartMan" sortable="false" headerClass="sortable"
					         titleKey="linkHisotryForm.counterpartMan"/>   <!--接洽人-->

						<display:column  title="<img  name='Bt_addLinkHisotry' id='Bt_addLinkHisotry' src='image/CRM_ADD.GIF'>" headerClass="sortable" media="html">
						 		<img  name="Bt_delLinkHisotry_id" id="Bt_delLinkHisotry_id" src="image/button_delete.gif" >
						</display:column>   
					         
					    <display:setProperty name="paging.banner.item_name" value="linkHisotry"/>
					    <display:setProperty name="paging.banner.items_name" value="linkHisotrys"/>
					</display:table>
					
				      </div>
						</div>
						
				    <div class="tab-page"> 
				      <h2 class="tab"> 
<!-- 合同 -->		  <span id="top_contract">
					  <fmt:message key="customerForm.tabs.contracts"/>
					  </span>
					  </h2>
					  <div id="top-contract">
							
							
					<display:table name="contractList" cellspacing="1" cellpadding="0"
					    id="contractList" pagesize="9" class="tableDisplay contractList"
					    export="false" requestURI="contracts.html">
					    
					     <display:column property="code" sortable="false" headerClass="sortable"
					        url="/editContract.html" paramId="id" paramProperty="id"
					        titleKey="contractForm.code"/>       					 <!--合同编号-->      
					         					         
					    <display:column property="moneySum" sortable="false" headerClass="sortable"
					         format="{0,number,##,###.00}" 
					         titleKey="contractForm.moneySum"/>						<!--预投放总金额-->
					                  
					    <display:column property="moneyExec" sortable="false" headerClass="sortable"
					         format="{0,number,##,###.00}" 
					         titleKey="contractForm.moneyExec"/>					<!--已投放金额-->
					         
					    <display:column property="moneyIn" sortable="false" headerClass="sortable"
					         format="{0,number,##,###.00}" 
					         titleKey="contractForm.moneyIn"/>						<!--已分配金额-->         
					         
					    <display:column property="startDate" sortable="false" headerClass="sortable"
					         titleKey="contractForm.startDate"/>					<!--开始日期-->
					         
					    <display:column property="endDate" sortable="false" headerClass="sortable"
					         titleKey="contractForm.endDate"/>						<!--结束日期-->
					         
					    <display:column property="state" sortable="false" headerClass="sortable"
					         titleKey="contractForm.state"/>						<!--合同状态-->      
					         
						<display:column  title="<img  name='Bt_addContract' id='Bt_addContract' src='image/CRM_ADD.GIF'>" headerClass="sortable" media="html">
						 		<img  name="Bt_delContract_id" id="Bt_delContract_id" src="image/button_delete.gif" >
						</display:column>   					           
					
					    <display:setProperty name="paging.banner.item_name" value="contract"/>
					    <display:setProperty name="paging.banner.items_name" value="contracts"/>
					    <display:setProperty name="paging.banner.group_size" value="6"/>
					</display:table>

		  				 <table width="100%" border="0" cellspacing="0" cellpadding="0">
		  				    <tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
	                        <tr  bgcolor="#D8DFE7"> 
	                          <td  align="left">
	                            <fmt:message key="orderDetailForm.tb.recs"/>: 
	                            <span id="totalRecords_contract" style="font-weight:bold;"></span> 
	                            <fmt:message key="contractForm.unit.rec"/> </td>
	                          <td align="right"> 
	                              <div id="pageInfo_contract"></div>
	                              <!--当前页-->
	                              <span id="pageIndex_contract" style="font-weight:bold;"></span> 
	                            </td>
	                        </tr>
	                      </table>	

				      </div>
						</div>
						<div class="tab-page">
							
				      <h2 class="tab">
<!-- 销售订单 -->
					   <fmt:message key="customerForm.tabs.orders"/>
					  </h2>
						<div name="container" id="top-mr">
						
						<display:table name="orderList" cellspacing="1" cellpadding="0" 
						    id="orderList" pagesize="9" class="tableDisplay orderList"
						    sort="list"   varTotals="totals"
						    export="false" requestURI="/orders.html">
						    
						    <display:column property="orderCode" sortable="false" headerClass="sortable"
						         titleKey="orderDetailForm.tb.number"/>      <!--序号-->      						    
							
						    <display:column property="orderCode" sortable="false" headerClass="sortable"
						         titleKey="orderForm.orderCode"/>      <!--订单号-->         
						        
						    <display:column property="contractId" sortable="false" headerClass="sortable"
						         titleKey="orderForm.contractId"/>      <!--合同号-->       
						                
						    <display:column property="orderPublic.publishStartDate"  sortable="false" headerClass="sortable" 
						         titleKey="orderForm.publishStartDate"/><!--开始日期-->
						         
						    <display:column property="orderPublic.publishEndDate" sortable="false" headerClass="sortable"
						         titleKey="orderForm.publishEndDate"/>  <!--结束日期-->         
						                 
						     <display:column property="orderPublic.moneyRealpay" sortable="false" headerClass="sortable"
						         format="{0,number,##,###.00}" 
						         titleKey="orderForm.moneySum"/>		<!--应付金额-->
						         
						     <display:column property="orderPublic.moneyIn" sortable="false" headerClass="sortable"
						        format="{0,number,###.00}"
						         titleKey="orderForm.moneyIn"/> 		<!--已付金额-->      
						
						
						     <display:column  titleKey="orderForm.isCkecked" headerClass="sortable" media="html" /> <!--审核-->
	
							<display:column  title="<img  name='Bt_addOrder' id='Bt_addOrder' src='image/CRM_ADD.GIF'>" headerClass="sortable" media="html">
							 		<img  name="Bt_delOrder_id" id="Bt_delOrder_id" src="image/button_delete.gif" >
							</display:column>							

							<display:setProperty name="paging.banner.placement" value="top" />
						    <display:setProperty name="paging.banner.group_size" value="6"/>
						    <display:setProperty name="paging.banner.item_name" value="order"/>
						    <display:setProperty name="paging.banner.items_name" value="orders"/>
						</display:table>
						

						
						
	  				 <table width="100%" border="0" cellspacing="0" cellpadding="0">
	  				    <tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
                        <tr  bgcolor="#D8DFE7"> 
                          <td  align="left">
                            <fmt:message key="orderDetailForm.tb.recs"/>: 
                            <span id="totalRecords_order" style="font-weight:bold;"></span> 
                            <fmt:message key="contractForm.unit.rec"/> </td>
                          <td align="right"> 
                              <div id="pageInfo_order"></div>
                              <!--当前页-->
                              <span id="pageIndex_order" style="font-weight:bold;"></span> 
                            </td>
                        </tr>
                      </table>					
						
						

				      </div>
						</div>
						
						
					 <div class="tab-page">
				      <h2 class="tab">
<!-- 付款记录 -->
					<fmt:message key="customerForm.tabs.payment"/>
					  </h2>
					  
					  <div name="container" id="top-mr">
							
						<display:table name="incomeList" cellspacing="1" cellpadding="0" 
						    id="incomeList" pagesize="9" class="tableDisplay incomeList"
						    export="false" requestURI="">    
						    
						   <display:column property="incomeDate" sortable="false" headerClass="sortable"
						         url="/editIncome.html" paramId="id" paramProperty="id"
						         titleKey="incomeForm.incomeDate"/>		 <!--付款日期--> 
						
						    <display:column property="incomeCode" sortable="false" headerClass="sortable"
						        titleKey="incomeForm.incomeCode"/>        <!--付款编号-->
	
						    <display:column property="incomeMoney" sortable="false" headerClass="sortable"
						         titleKey="incomeForm.incomeMoney"/> 		 <!--应付金额-->
						         
						    <display:column property="incomeModeId" sortable="false" headerClass="sortable"
						         titleKey="incomeForm.incomeModeId"/> 	 <!--应付金额-->
	
						    <display:column property="incomePurposeId" sortable="false" headerClass="sortable"
						         titleKey="incomeForm.incomePurposeId"/>	 <!--应付金额-->
						         
							<display:column  title="<img  name='Bt_addIncome' id='Bt_addIncome' src='image/CRM_ADD.GIF'>" headerClass="sortable" media="html">
							 		<img  name="Bt_delIncome_id" id="Bt_delIncome_id" src="image/button_delete.gif" >
							</display:column>	
													         
						    <display:setProperty name="paging.banner.item_name" value="income"/>
						    <display:setProperty name="paging.banner.items_name" value="incomes"/>
						</display:table>
						
		  				 <table width="100%" border="0" cellspacing="0" cellpadding="0">
		  				    <tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
	                        <tr  bgcolor="#D8DFE7"> 
	                          <td  align="left">
	                            <fmt:message key="orderDetailForm.tb.recs"/>: 
	                            <span id="totalRecords_income" style="font-weight:bold;"></span> 
	                            <fmt:message key="contractForm.unit.rec"/> </td>
	                          <td align="right"> 
	                              <div id="pageInfo_income"></div>
	                              <!--当前页-->
	                              <span id="pageIndex_income" style="font-weight:bold;"></span> 
	                            </td>
	                        </tr>
	                      </table>								
						
				      </div>
						</div>
						
						
					<div class="tab-page">
				      <h2 class="tab">
<!-- 欠款记录 -->
					  <fmt:message key="customerForm.tabs.arrearage"/>
					  
					  </h2>
					  
					 <div name="container" id="top-mr">
							
						<display:table name="contractPaymentList" cellspacing="1" cellpadding="0"
						    id="contractPaymentList" pagesize="9" class="tableDisplay contractPaymentList"
						    export="false" requestURI="">
						
						    <display:column property="payDate" sortable="true" headerClass="sortable"
						        url="/editContractPayment.html" paramId="id" paramProperty="id"
						        titleKey="contractPaymentForm.payDate"/>
						         
						    <display:column property="payNumber" sortable="true" headerClass="sortable"
						         titleKey="contractPaymentForm.payNumber"/>						         
						         
						    <display:column property="contractId" sortable="true" headerClass="sortable"
						         titleKey="contractPaymentForm.contractId"/>
						         
						    <display:column property="orderId" sortable="true" headerClass="sortable"
						         titleKey="contractPaymentForm.orderId"/>
						         
						    <display:column property="moneyPay" sortable="true" headerClass="sortable"
						         titleKey="contractPaymentForm.moneyPay"/>
						         
						    <display:column property="moneyIn" sortable="true" headerClass="sortable"
						         titleKey="contractPaymentForm.moneyIn"/>
	
						    <display:setProperty name="paging.banner.item_name" value="contractPayment"/>
						    <display:setProperty name="paging.banner.items_name" value="contractPayments"/>
						</display:table>
						
		  				 <table width="100%" border="0" cellspacing="0" cellpadding="0">
		  				    <tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
	                        <tr  bgcolor="#D8DFE7"> 
	                          <td  align="left">
	                            <fmt:message key="orderDetailForm.tb.recs"/>: 
	                            <span id="totalRecords_payment" style="font-weight:bold;"></span> 
	                            <fmt:message key="contractForm.unit.rec"/> </td>
	                          <td align="right"> 
	                              <div id="pageInfo_payment"></div>
	                              <!--当前页-->
	                              <span id="pageIndex_payment" style="font-weight:bold;"></span> 
	                            </td>
	                        </tr>
	                      </table>							
						
						
				      </div>
						</div>
						

						
				    <div class="tab-page"> 
				      <h2 class="tab">
<!-- 关心产品 -->
 					  <fmt:message key="customerForm.tabs.products"/>					  
					  </h2>
					  <div name="container" id="top-product">
					  
						<display:table name="matterList" cellspacing="1" cellpadding="0"
						    id="matterList" pagesize="20" class="tableDisplay matterList"
						    export="false" requestURI="">
						
						    <display:column property="name" sortable="false" headerClass="sortable"
						        url="/editMatter.html" paramId="id" paramProperty="id"
						        titleKey="matterForm.name"/>

						    <display:column property="edit" sortable="false" headerClass="sortable"
						         titleKey="matterForm.edit"/>
						         
						    <display:column property="length" sortable="false" headerClass="sortable"
						         titleKey="matterForm.length"/>
						         
						    <display:column property="tapeCode" sortable="false" headerClass="sortable"
						         titleKey="matterForm.tapeCode"/>
						         
							<display:column  title="<img  name='Bt_addMatter' id='Bt_addMatter' src='image/CRM_ADD.GIF'>" headerClass="sortable" media="html">
							 		<img  name="Bt_delMatter_id" id="Bt_delMatter_id" src="image/button_delete.gif" >
							</display:column>							         
						         
						    <display:setProperty name="paging.banner.item_name" value="matter"/>
						    <display:setProperty name="paging.banner.items_name" value="matters"/>
						</display:table>
						
		  				 <table width="100%" border="0" cellspacing="0" cellpadding="0">
		  				    <tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
	                        <tr  bgcolor="#D8DFE7"> 
	                          <td  align="left">
	                            <fmt:message key="orderDetailForm.tb.recs"/>: 
	                            <span id="totalRecords_matter" style="font-weight:bold;"></span> 
	                            <fmt:message key="contractForm.unit.rec"/> </td>
	                          <td align="right"> 
	                              <div id="pageInfo_matter"></div>
	                              <!--当前页-->
	                              <span id="pageIndex_matter" style="font-weight:bold;"></span> 
	                            </td>
	                        </tr>
	                      </table>								
						

					</div>
				</div>
				
				
				<div class="tab-page"> 
				      <h2 class="tab">
<!-- 意见反馈 -->
					  <fmt:message key="customerForm.tabs.feedback"/>					  
					  </h2>
					  <div name="container" id="top-pp">
					  
					  
						<display:table name="feedbackInfoList" cellspacing="1" cellpadding="0"
						    id="feedbackInfoList" pagesize="9" class="tableDisplay feedbackInfoList"
						    export="false" requestURI="">
						    

						
						    <display:column property="submitDate" sortable="false" headerClass="sortable"
						        url="/editFeedbackInfo.html" paramId="id" paramProperty="id"
						        titleKey="feedbackInfoForm.submitDate"/>
						         
						    <display:column property="feeder" sortable="false" headerClass="sortable"
						         titleKey="feedbackInfoForm.feeder"/>
						         
						    <display:column property="feedContent" sortable="false" headerClass="sortable"
						         titleKey="feedbackInfoForm.feedContent"/>
						         
						    <display:column property="dealDate" sortable="false" headerClass="sortable"
						         titleKey="feedbackInfoForm.dealDate"/>
						         
						    <display:column property="satisfactoryDegree" sortable="false" headerClass="sortable"
						         titleKey="feedbackInfoForm.satisfactoryDegree"/>
						         
							<display:column  title="<img  name='Bt_addFeedbackInfo' id='Bt_addFeedbackInfo' src='image/CRM_ADD.GIF'>" headerClass="sortable" media="html">
							 		<img  name="Bt_delFeedbackInfo_id" id="Bt_delFeedbackInfo_id" src="image/button_delete.gif" >
							</display:column>  						         
						         
						         
						    <display:setProperty name="paging.banner.item_name" value="feedbackInfo"/>
						    <display:setProperty name="paging.banner.items_name" value="feedbackInfos"/>
						</display:table>
						
						
		  				 <table width="100%" border="0" cellspacing="0" cellpadding="0">
		  				    <tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
	                        <tr  bgcolor="#D8DFE7"> 
	                          <td  align="left">
	                            <fmt:message key="orderDetailForm.tb.recs"/>: 
	                            <span id="totalRecords_feedbackInfo" style="font-weight:bold;"></span> 
	                            <fmt:message key="contractForm.unit.rec"/> </td>
	                          <td align="right"> 
	                              <div id="pageInfo_feedbackInfo"></div>
	                              <!--当前页-->
	                              <span id="pageIndex_feedbackInfo" style="font-weight:bold;"></span> 
	                            </td>
	                        </tr>
	                      </table>								

					</div>
				</div>
				
				<div id="tooltipdiv"></div> 
				<!-- script>getnews();</script --> 
				                  
<!--bodyTas  end-->                 	
	
	</td>
  </tr>
</table>

<html:javascript formName="customerAddressForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<html:javascript formName="customerForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<html:javascript formName="linkManForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<html:javascript formName="linkHisotryForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>


<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>

