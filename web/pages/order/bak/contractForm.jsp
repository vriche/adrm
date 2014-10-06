<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="contractDetail.title"/></title>
<script typr="text/javascript" src="<c:url value='/scripts/contract/public.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/contract/payment.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/contract/order.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/contract/target.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ContractPaymentManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ContractTargetManager.js'/>"></script>

<content tag="heading"><fmt:message key="contractDetail.heading"/></content>

<html:form action="saveContract" method="post" styleId="contractForm" onsubmit="return validateContractForm(this)">
<html:hidden property="id"/>
<html:hidden property="version"/>
<html:hidden property="createBy"/>



  
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td width="50%"> <table width="100%" border="0" align="right" cellpadding="0" cellspacing="0">
        <tr> 
          <td width="50%" valign="top"> <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr> 
                <td width="50%" valign="top"> 
                  <!--baseinso start-->
                  <fieldset style="width: 95%"> 
                  <legend><!-- 基本信息 --><adrm_order:label key="contractForm.baseInfo"/></legend>
                  <table width="99%" border="0" cellpadding="0" cellspacing="0">
                    <tr> 
                      <td width="50%" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                          <tbody>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel"> 
                                <!-- 系统编号 --> 
                                <adrm_order:label key="contractForm.id"/>: </td>
                              <td ><html:text property="id" styleId="contractId" disabled="true"/>

                              </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="requiredInput"> 
                                <!-- 合同所有人 -->
                                <adrm_order:label  key="contractForm.owner"/>: 
                                <html:errors property="owner"/> </td>
                              <td> <html:text property="owner" styleId="owner" /> 
                              </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel"> 
                                <!-- 合同编号 -->
                                <adrm_order:label   key="contractForm.code"/>: 
                                <html:errors property="code"/> </td>
                              <td><html:text property="code" styleId="code" /></td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel"> 
                                <!--  帐户名称-->
                                <adrm_order:label  key="contractForm.customerId"/>: 
                                <html:errors property="customerId"/>
                                </td>
                              <td>
                              
                               <div style="position:relative;">
								<span style="margin-left:100px;width:18px;overflow:hidden;">
		  						  <adrm_order:selectList name="customers" key="8"  toScope="page"/> 
		                          <html:select property="customerId" styleId="customerId"  style="width:140px;margin-left:-100px"> 
		                          <html:option value=""/> <html:options collection="customers"  property="value" labelProperty="label"/> 
		                          </html:select> 								
								</span>
								</div>

                                 </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel"> 
                                <!-- 客户签字人 -->
                                <adrm_order:label  key="contractForm.signUser"/>: 
                                <html:errors property="signUser"/> </td>
                              <td> <html:text property="signUser" styleId="signUser" /> 
                              </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel"> 
                                <!-- 签字人职务 -->
                                <adrm_order:label  key="contractForm.signHeadship"/>: 
                                <html:errors property="signHeadship"/> </td>
                              <td> <html:text property="signHeadship" styleId="signHeadship" /> 
                              </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel"> 
                                <!-- 合同金额 -->
                                <adrm_order:label  key="contractForm.moneySum"/>: 
                                <html:errors property="moneySum"/> </td>
                              <td> <html:text property="moneySum" styleId="moneySum" /> 
                              </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel"> 
                                <!-- 已付金额 -->
                                <adrm_order:label  key="contractForm.moneyExec"/>: 
                                <html:errors property="moneyExec"/> </td>
                              <td> <html:text property="moneyExec" styleId="moneyExec" /> 
                              </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel"> 
                                <!-- 客户签字日期 -->
                                <adrm_order:label  key="contractForm.csignDate"/>: 
                                <html:errors property="csignDate"/> </td>
                              <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                  <tr> 
                                    <td width="20%"> 
                                    <html:text property="csignDate" styleId="csignDate"  readonly="true" onclick="button_showdate('csignDate','anchorCsignDate')"/> 
									<span id="anchorCsignDate" name="anchorCsignDate"></span>
                                    </td>
                                    <td>
                                    </td>
                                  </tr>
                                </table></td>
                            </tr>
                          </tbody>
                        </table></td>
                      <td valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                          <tbody>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!--  状态--> 
                                <adrm_order:label  key="contractForm.state"/>: 
                              </td>
                              <td> 
                              <html:errors property="state"/> 
                              <html:select property="state" styleClass="select" > 
                                <html:option value="0"><fmt:message key="contractForm.select.stats0"/></html:option> 
                                <html:option value="1"><fmt:message key="contractForm.select.stats1"/></html:option> 
                                <html:option value="2"><fmt:message key="contractForm.select.stats2"/></html:option> 
                                </html:select> 
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 开始日期 -->
                                <adrm_order:label  key="contractForm.startDate"/>: 
                                <html:errors property="startDate"/> </td>
                              <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                  <tr> 
                                    <td width="20%"><DIV>
                                    <html:text property="startDate" styleId="startDate"  readonly="true" onclick="button_showdate('startDate','anchorStartDate')" /> 
                                    <span id="anchorStartDate" name="anchorStartDate"></span><DIV>
                                    </td>
                                    <td>
                                    </td>
                                  </tr>
                                </table></td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 结束日期 -->
                                <adrm_order:label  key="contractForm.endDate"/>: 
                                <html:errors property="endDate"/> </td>
                              <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                  <tr> 
                                    <td width="20%">
                                    <html:text property="endDate" styleId="endDate"  readonly="true" onclick="button_showdate('endDate','anchorEndDate')"/> 
                                    <span id="anchorEndDate" name="anchorEndDate"></span>
                                    </td>
                                    <td></td>
                                  </tr>
                                </table></td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!--  合同类别-->
                                <adrm_order:label  key="contractForm.contractType"/>: 
                                <html:errors property="contractType"/> </td>
                              <td> 
                              <html:select property="contractType" styleClass="select" > 
                                <html:option value="0" ><fmt:message key="contractForm.select.contractType0"/></html:option> 
                                <html:option value="1" ><fmt:message key="contractForm.select.contractType1"/></html:option> 
                                </html:select>
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!--  到期通知-->
                                <adrm_order:label  key="contractForm.notifyDays"/>: 
                              </td>
                              <td> <html:select property="notifyDays" styleClass="select"> 
                                <html:errors property="notifyDays"/> <html:option value="15" >15<fmt:message key="contractForm.unit.date"/></html:option> 
                                <html:option value="30" >30<fmt:message key="contractForm.unit.date"/></html:option> 
                                <html:option value="45" >45<fmt:message key="contractForm.unit.date"/></html:option> 
                                <html:option value="60" >60<fmt:message key="contractForm.unit.date"/></html:option> 
                                <html:option value="90" >90<fmt:message key="contractForm.unit.date"/></html:option> 
                                </html:select> </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!--  合同性质-->
                                <adrm_order:label  key="contractForm.contractSort"/>:	
                              </td>
                              <td> <html:select property="contractSort" styleClass="select"> 
                                <html:errors property="contractSort"/> 
                                <!--  正常--><html:option value="0" ><fmt:message key="contractForm.select.contractSort0"/></html:option> 
                                <!--  协议--><html:option value="1"><fmt:message key="contractForm.select.contractSort1"/></html:option> 
                                </html:select>
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!--  签字人-->
                                <adrm_order:label  key="contractForm.userId"/>: 
                                <html:errors property="userId"/> </td>
                              <td> <html:text property="userId" styleId="userId" /> 
                              </td>
                            </tr>
                            <tr>
                              <td class="dataLabel" nowrap="nowrap">
                                <!--  签字日期-->
                                <adrm_order:label  key="contractForm.osignDate"/>: 
                              </td>
                              <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                  <tr> 
                                    <td width="20%"> 
                                    <html:text property="osignDate" styleId="osignDate"  readonly="true" onclick="button_showdate('osignDate','anchorOsignDate')"/> 
                                    <span id="anchorOsignDate" name="anchorOsignDate"></span>
                                    </td>
                                    <td></td>
                                  </tr>
                                </table></td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap">
                                <!-- 欠款限制下单 -->
                                <adrm_order:label  key="contractForm.isLimitOrder"/>: 
                                <html:errors property="isLimitOrder"/> <html:errors property="osignDate"/> 
                              </td>
                              <td>
                               <html:checkbox property="isLimitOrder" styleId="isLimitOrder"/></td>
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
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr> 
                <td > 
                  <!--baseinso start-->
                  <fieldset style="width: 95%"> 
                  <legend><!-- 其它信息 --><adrm_order:label key="contractForm.otherInfo"/></legend>
                  <table width="100%">
                    <tr> 
                      <td width="1%" valign="top"> 
                        <table width="50%">
                          <tr> 
                            <td nowrap="nowrap" class="dataLabel">
								<!--  备注--> 
								 <adrm_order:label  key="contractForm.memo"/>:
								 <html:errors property="memo"/> 
								 </td>
                          </tr>
                        </table></td>
                      <td>
                      
					 <html:textarea property="memo" cols="50%" rows="3"></html:textarea>
   
					  </td>
                    </tr>
                    <tr> 
                      <td width="1%">&nbsp;</td>
                      <td>&nbsp;</td>
                    </tr>
                    <tr> 
                      <td width="1%" valign="top"> 
                        <table width="50%">
                          <tr> 
                            <td nowrap="nowrap" class="dataLabel">
								<!--  补充--> 
								 <adrm_order:label  key="contractForm.memoRenew"/>:
								 <html:errors property="memoRenew"/> 
								 </td>
                          </tr>
                        </table></td>
                      <td>
                      <html:textarea property="memoRenew" cols="50%" rows="3"></html:textarea>
					 </td>
                    </tr>
                    <tr> 
                      <td width="1%">&nbsp;</td>
                      <td>&nbsp;</td>
                    </tr>
                  </table>
                  </fieldset>
                  <!--baseinso end-->
                </td>
              </tr>
            </table>
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr> 
                <td width="50%"> 
                  <!--baseinso start-->
                  <fieldset  style="width: 95%">
                  <legend></legend>
                  <table width="99%" border="0" cellpadding="0" cellspacing="0">
                    <tr> 
                      <td width="50%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr> 
                            <td><div align="center"> 
                            
						        <html:submit styleClass="" property="method.save" onclick="bCancel=false">
						            <fmt:message key="button.save"/>
						        </html:submit>
						        
						        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('Contract')">
						            <fmt:message key="button.delete"/>
						        </html:submit>

							     <c:choose>
							        <c:when test='${param.id >0}'>
							            <html:cancel styleClass="" onclick="bCancel=true"><fmt:message key="button.cancel"/></html:cancel>	
							        </c:when>
							        <c:otherwise>  
							            <input type="button" onclick="window.location='<c:url value='contracts.html'/>'" value='<fmt:message key="button.cancel"/>'>
							        </c:otherwise>
							    </c:choose>     	        
						        
						        
						        
						        
						        
                              </div></td>
                          </tr>
                        </table></td>
                    </tr>
                  </table>
                  </fieldset>
                  <!--baseinso end-->
                </td>
              </tr>
            </table></td>
        </tr>
      </table></td>
    <td width="50%" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
 
        
        
        
         <tr> 
          <td width="50%"> 
            <!--baseinso start-->
            <fieldset  style="width: 98%">
            <legend><!-- 销售订单 --><fmt:message key="customerForm.tabs.orders"/></legend>
            
 
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
            
            
            </fieldset>

            
            <!--baseinso end-->
          </td>
        </tr>
        

       <tr> 
          <td width="50%"> 
            <!--baseinso start-->
            <fieldset  style="width: 98%">
            <legend><!-- 付款信息 --><fmt:message key="contractForm.paymentInfo"/></legend>
            
            
            
		          <div id="hiddenArea" style="display:none">
		 				<adrm_order:selectList name="selects" key="18" toScope="page"/> 
		                     <html:select property="id" styleId="incomeModeId" styleClass="select"> 
		                     <html:option value=""/> <html:options collection="selects" property="value" labelProperty="label"/> 
		                </html:select>
		                <html:errors property="id"/>                                               
		           </div>           
            

						<display:table name="paymentList" cellspacing="1" cellpadding="0"
						    id="paymentList" pagesize="9" class="tableDisplay paymentList"
						    export="false" requestURI="">
						    
						    <display:column property="payNumber" sortable="true"  headerClass="sortable" 
						         titleKey="contractPaymentForm.payNumber"/>	
						         
						    <display:column property="payDate" sortable="true" headerClass="sortable"
						         titleKey="contractPaymentForm.payDate"/>							         
						         
						    <display:column property="incomeModeId" sortable="true" headerClass="sortable"
						         titleKey="contractPaymentForm.incomeModeId"/>					         
						         
						    <display:column property="moneyPay" sortable="true" headerClass="sortable"
						         titleKey="contractPaymentForm.moneyPay"/>
						         
						    <display:column property="moneyIn" sortable="true" headerClass="sortable"
						         titleKey="contractPaymentForm.moneyIn"/>
						         
							<display:column  title="&nbsp;&nbsp;&nbsp;<img  name='Bt_addPayment' id='Bt_addPayment' src='image/CRM_ADD.GIF'>&nbsp;&nbsp;&nbsp;" headerClass="sortable"  media="html">
							 		<img  name="Bt_delPayment" id="Bt_delPayment" src="image/button_delete.gif" >
							</display:column> 						         
						         
	
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

            
            
            </fieldset>

            
            <!--baseinso end-->
          </td>
        </tr>
        
                               
 
        <tr> 
          <td width="50%"> 
            <!--baseinso start-->
            <fieldset  style="width: 98%">
            <legend><!-- 年度计划 --><fmt:message key="contractForm.yearTarget"/></legend>
              
             	   <div id="hiddenArea" style="display:none"> 
		                
		                  <adrm_order:selectList name="carriers" key="3"  level="0" toScope="page"/> 
	                          <html:select property="id" styleId="carrierId" name="carrierId" value="0" > 
	                          <html:option value=""/> <html:options collection="carriers"  property="value" labelProperty="label"/> 
                          </html:select>
                          <html:errors property="id"/>
                          
                          
                          <adrm_order:selectList name="industryTypes" key="6" level="0" toScope="page"/> 
		                      <html:select property="id" styleId="industryTypeId" name="industryTypeId"  value="0" > 
		                      <html:option value=""/> <html:options collection="industryTypes"  property="value" labelProperty="label"/> 
	                      </html:select> 
	                      <html:errors property="carrierId"/>	                                                                
		           </div>                
            

						<display:table name="targetList" cellspacing="1" cellpadding="0"
						    id="targetList" pagesize="9" class="tableDisplay targetList"
						    export="false" requestURI="">
						    
						    <display:column property="carrierId" sortable="true"  headerClass="sortable" 
						         titleKey="contractTargetForm.carrierId"/>						         
						    					         
						         
						    <display:column property="industryTypeId" sortable="true" headerClass="sortable"
						         titleKey="contractTargetForm.industryTypeId"/>					         
						         
						    <display:column property="target" sortable="true" headerClass="sortable"
						         titleKey="contractTargetForm.target"/>						         
				         
							<display:column  title="&nbsp;&nbsp;&nbsp;<img  name='Bt_addTarget' id='Bt_addTarget' src='image/CRM_ADD.GIF'>&nbsp;&nbsp;&nbsp;" headerClass="sortable"  media="html">
							 		<img  name="Bt_delTarget" id="Bt_delTarget" src="image/button_delete.gif" >
							</display:column> 						         
						         
	
						    <display:setProperty name="paging.banner.item_name" value="contractTarget"/>
						    <display:setProperty name="paging.banner.items_name" value="contractTargets"/>
						    
						</display:table>
						
		  				 <table width="100%" border="0" cellspacing="0" cellpadding="0">
		  				    <tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
	                        <tr  bgcolor="#D8DFE7"> 
	                          <td  align="left">
	                            <fmt:message key="orderDetailForm.tb.recs"/>: 
	                            <span id="totalRecords_target" style="font-weight:bold;"></span> 
	                            <fmt:message key="contractForm.unit.rec"/> 
	                          </td>
	                          <td align="right"> 
	                              <div id="pageInfo_target"></div>
	                              <!--当前页-->
	                              <span id="pageIndex_target" style="font-weight:bold;"></span> 
	                          </td>
	                      </tr>
	                   </table>	           

            
            
            </fieldset>

            
            <!--baseinso end-->
          </td>
        </tr>  
               
      </table></td>
  </tr>
</table>


</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("contractForm"));
</script>

<html:javascript formName="contractForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>

