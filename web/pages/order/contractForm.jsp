<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>



<title><fmt:message key="contractDetail.title"/></title>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/popupWindow.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/class/contractpayment.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/target.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomePurpose.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/industry.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/address.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/order.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/specific.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDetail.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderPublic.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/contract.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDayInfo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/class/agentInfo.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/class/resourceSort.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/class/category.js'/>"></script>
<!-- script type="text/javascript" src="<c:url value='/scripts/class/carrierType.js'/>"></script -->
<!-- script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script -->




<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<!-- script typr="text/javascript" src="<c:url value='/scripts/contract/public.js'/>"></script -->
<!-- script typr="text/javascript" src="<c:url value='/scripts/contract/order.js'/>"></script -->

<script type="text/javascript" src="<c:url value='/dwr/interface/AgentInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ContractPaymentManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ContractTargetManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDetailManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ContractManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDayInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceSortManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resourceType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CategoryManager.js'/>"></script>
<!-- script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script -->
<!-- script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script -->
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/order/broArrange.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/contract/contractService.js'/>"></script>

<content tag="heading"><fmt:message key="contractDetail.heading"/></content>

<html:form action="saveContract" method="post" styleId="contractForm" onsubmit="return validateContractForm(this)">
<html:hidden property="id" styleId="id"/>
<html:hidden property="version" styleId="version"/>
<html:hidden property="createBy"  styleId="createBy"/>
<html:hidden property="carrierId" styleId="carrierId" />




			                         



<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                  
                  	<td width="1px" id="orgId_td" style="display:none"><select id="orgId"/></td>   
	 				<td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="save" value='保存'></td> 
					<td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="delete" value='删除'></td> 					
					<td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="cancel" value='返回'></td> 			
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
                                <adrm_order:label key="contractForm.id"/>:</td>
                                <td width="350px"><html:text property="id" styleId="contractId" disabled="true" size="10"/><select id="contract_year"  style="CURSOR: pointer;" />  

                              </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel"> 
                                <!-- 合同所有人 -->
                                <adrm_order:label  key="contractForm.owner"/>: 
                                <html:errors property="owner"/> </td>
                              <td align="left"> 
                              <!-- html:text property="owner" styleId="owner" / --> 
                              
 	                    
		                          <html:select property="owner" styleId="owner" style="width:138px;"/> 
		                         
		                                                  
                              
                        
                              </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel"> 
                                <!-- 合同编号 -->
                                <adrm_order:label   key="contractForm.code"/>: 
                                <html:errors property="code"/> </td>
                              <td><html:text property="code" styleId="code" disabled="true"/></td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel"> 
                                <!--  帐户名称-->
                                <adrm_order:label  key="contractForm.customerId"/>: 
                                <html:errors property="customer.customerName"/>
                                </td>
                              <td>
                                <div id="extCustomerDiv" name="extCustomerDiv">
								<!-- div style="position:relative;overflow:visible">
									<input name="customerName" id="customerName" type=text autocomplete=off>
									
								
									<div id="theDivCustomerName" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:450px;height:300px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
								</div -->	

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
                              <td> <html:text property="moneySum" styleId="moneySum" readonly="true"/> 
                              </td>
                            </tr>

                            <input type="hidden" id="moneyExec" name="moneyExec"/>
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
                                <!--  审批状态--> 
                                <adrm_order:label  key="oaWorkFlowCheckStateList.heading"/>: 
                              </td>
                              <td width="350px"> 

								<div style="position:relative;">
									<span style="margin-left:100px;width:18px;overflow:hidden;">
									  	<adrm_order:selectList name="workFlowCheckResults" key="36"  toScope="page"/> 
									     <html:select property="state" styleId="state"  style="width:138px;margin-left:-100px"> 
									     <html:option value=""/> <html:options collection="workFlowCheckResults"  property="value" labelProperty="label"/> 
									     </html:select> 								
									</span>
								</div>  
                              </td>
                            </tr>                          
                            
                            
                            
                            
                            
                                   
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 开始日期 -->
                                <adrm_order:label  key="contractForm.startDate"/>: 
                                <html:errors property="startDate"/> </td>
                              <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                  <tr> 
                                    <td>
                                    	<html:text property="startDate" styleId="startDate"  readonly="true" onclick="button_showdate('osignDate','anchorOsignDate')"/> 
										<span id="anchorStartDate" name="anchorStartDate"></span></DIV>
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
                                <html:errors property="endDate"/> 
                              </td>
                              <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
	                                  <tr> 
	                                      <td>
	                                      		<html:text property="endDate" styleId="endDate"  readonly="true" onclick="button_showdate('osignDate','anchorOsignDate')"/> 
												 <span id="anchorEndDate" name="anchorEndDate"></span>
										  </td>
	                                    <td></td>
	                                  </tr>
	                              </table>
	                          </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!--  合同类别-->
                                <adrm_order:label  key="contractForm.contractType"/>: 
                                <html:errors property="contractType"/> </td>
                              <td>  
                               <div style="position:relative;">
								<span style="margin-left:100px;width:18px;overflow:hidden;">
		                        <adrm_order:selectList name="contractTypes" key="38" toScope="page"/> 
		                          <html:select property="contractType" styleId="contractType" style="width:138px;margin-left:-100px"> 
		                          <html:options collection="contractTypes" property="value" labelProperty="label"/> 
		                          </html:select> <html:errors property="contractType"/>
		                          </span>
		                          </div> 
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!--  到期通知-->
                                <adrm_order:label  key="contractForm.notifyDays"/>: 
                                <html:errors property="notifyDays"/>
                              </td>
                              <td>
                               <div style="position:relative;">
								<span style="margin-left:100px;width:18px;overflow:hidden;">
		                        <adrm_order:selectList name="notifyDay" key="39" toScope="page"/> 
		                          <html:select property="notifyDays" styleId="notifyDays" style="width:138px;margin-left:-100px"> 
		                          <html:options collection="notifyDay" property="value" labelProperty="label"/> 
		                          </html:select> <html:errors property="notifyDays"/>
		                          </span>
		                          </div>    
		                     </td>
                            </tr>

                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!--  合同性质-->
                                <adrm_order:label  key="contractForm.contractSort"/>:	
                                <html:errors property="contractSort"/> 
                              </td>
                              <td>                                 
                               <div style="position:relative;">
								<span style="margin-left:100px;width:18px;overflow:hidden;">
		                        <adrm_order:selectList name="contractSorts" key="37" toScope="page"/> 
		                          <html:select property="contractSort" styleId="contractSort" style="width:138px;margin-left:-100px"> 
		                          <html:options collection="contractSorts" property="value" labelProperty="label"/> 
		                          </html:select> <html:errors property="contractSort"/>
		                          </span>
		                          </div>   
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!--  签字人-->
                                <adrm_order:label  key="contractForm.userId"/>: 
                                <html:errors property="userId"/> </td>
                              <td> 
                              
		                       
		                        
		                          <html:select property="userId" styleId="orderRelation" style="width:138px;"/> 
		                        
		                                            
                              
                              
                              
                              
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
                            <tr > 
                              <td class="dataLabel" nowrap="nowrap" style="display:none;">
                                <!-- 欠款限制下单 -->
                                <adrm_order:label  key="contractForm.isLimitOrder"/>: 
                                <html:errors property="isLimitOrder"/> <html:errors property="osignDate"/> 
                              </td>
                              <td style="display:none;">
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
            <table width="100%" border="0" cellpadding="0" cellspacing="0" >
              <tr> 
                <td aling="top"> 
                  <!--baseinso start-->
                  <fieldset style="width: 95%" id="otherInfoTable"> 
                  <legend><!-- 其它信息 --><adrm_order:label key="contractForm.otherInfo"/></legend>
                  <table width="100%">
                    <tr> 
                      <td width="75px" valign="top" align="right" > <!--  备注--> 
		      <adrm_order:label  key="contractForm.memo"/>:</td>
                      <td align="left"><html:textarea property="memo"  rows="8" style="font-size:12px;overflow: visible; width:81%;"></html:textarea></td>
                    </tr>
                    <tr> 
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                    </tr>
                    <tr> 
                      <td  valign="top" align="right" > <!--  补充--><adrm_order:label  key="contractForm.memoRenew"/>:</td>
                      <td align="left">
                      <html:textarea property="memoRenew"  rows="5" style="font-size:12px;overflow: visible; width:81%;"></html:textarea></td>
                    </tr>
             
                  </table>
                  </fieldset>
                  <!--baseinso end-->
                </td>
              </tr>
            </table>
			</td>
        </tr>
      </table></td>
    <td width="50%" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
 
        
        
        
         <tr> 
          <td width="50%"> 
          
          
          
       <!--baseinso start-->
            <fieldset  style="width: 95%;display:none;" id="contractTarget">
            <legend><!-- 年度计划 --><fmt:message key="contractForm.yearTarget"/></legend>
              
 			<table  id="contractTargetTable" class=ListShort width="100%" cellpadding="0" >
              <thead>
                <TR class=Header>     
					           
             	   <div id="hiddenArea" name="hiddenArea" style="display:none"> 
		                
		                  <adrm_order:selectList name="carriers" key="3"  level="0" toScope="page"/> 
	                          <html:select property="carrierId" styleId="carrierId" name="carrierId"  value="0" > 
	                          <html:option value=""/> 
	                          <html:options collection="carriers"  property="value" labelProperty="label"/> 
                          </html:select>
                          
                          
                          <adrm_order:selectList name="industryTypes" key="6" toScope="page"/> 
		                      <html:select property="industryTypeId" styleId="industryTypeId" name="industryTypeId"  value="0"> 
		                      <html:option value=""/> 
		                      <html:options collection="industryTypes"  property="value" labelProperty="label"/> 
	                      </html:select>                                                               
		           </div>  
		           
		               
                  <!--载体编号-->
                  <TH><fmt:message key="contractTargetForm.carrierId"/></TH>
                  <!--行业类型-->
                  <TH><fmt:message key="contractTargetForm.industryTypeId"/></TH>
                  <!--年投放量-->
                  <TH><fmt:message key="contractTargetForm.target"/></TH>
                  <!--月投放量-->
                  <TH><fmt:message key="contractTargetMonthForm.target"/></TH>
                                    
                  <TH id="button_add_new_obj"  style="cursor:hand" colspan="2" onclick="button_add_new_obj(1)"> 
                  		<img id="contractTargetImgAdd" name="contractTargetImgAdd"  src="image/CRM_ADD.GIF" border="0"> 
                  </TH>
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
              
              <tbody id="targetBody"/>
              
		</table>  
	
		
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  				<tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
	                        <tr  bgcolor="#eee"> 
	                          <td align="right"> 
	                              <div id="pageInfo_target"></div>
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
            <fieldset  style="width: 95%" id="contractPayment">
            <legend><!-- 付款信息 --><fmt:message key="contractForm.paymentInfo"/></legend>
            
           
            
				<table  id="contractPaymentTable" class=ListShort width="100%" cellpadding="0" >
			              <thead>
			                <TR class=Header>   
			                
					          <div id="hiddenArea" name="hiddenArea" style="display:none">
					 				<adrm_order:selectList name="incomePurposeIds" key="18" toScope="page"/> 
					                <html:select property="incomePurposeId" styleId="incomePurposeId" name="incomePurposeId"  value="0"> 
						                <!-- html:option value=""/ --> 
						                <html:options collection="incomePurposeIds" property="value" labelProperty="label"/> 
					                </html:select>                                               
					           </div> 
					           
					        <div id="hiddenArea2" name="hiddenArea2" style="display:none">           
							     <select name="select" id="resourceType"/>                                 
			           		</div> 
					           
					           <!--部门-->
							 <TH style="width:100%;heigth:100%;display:none" id="xmtvBranch"><fmt:message key='branchList.heading'/></TH>
			                  <!--次数-->
			                  <TH><fmt:message key="contractPaymentForm.payNumber"/></TH>
			                  <!--应付款日期-->
			                  <TH><fmt:message key="contractPaymentForm.payDate"/></TH>
			                  <!--付款类型-->
			                  <TH><fmt:message key="contractPaymentForm.incomeModeId"/></TH>
			                  <!--付款金额-->
			                  <TH><fmt:message key="contractPaymentForm.moneyPay"/></TH>
			                  <!--已分配金额-->
			                  <TH><fmt:message key="contractPaymentForm.moneyIn"/></TH>
			                  
			                  <TH id="button_add_new_obj"  style="cursor:pointer" colspan="2" onclick="button_add_new_obj(0)"> 
			                  		<img id="contractPaymentImgAdd" name="contractPaymentImgAdd"  src="image/CRM_ADD.GIF" border="0"> 
			                  </TH>
			                </TR>
			                
			                <tr > 
			                  <td colspan="10">
				                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
				                      <tr> 
				                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
				                      </tr>
				                    </table>
			                    </td>
			                </tr>
			              </thead>
			              
			              <tbody id="paymentBody"/>
			              
				</table>  
	
	
			   <table width="100%" border="0" cellspacing="0" cellpadding="0">
				  				    <tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
			                        <tr  bgcolor="#eee"> 
			                          <td align="right"> 
			                              <div id="pageInfo_payment"></div>
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
            <fieldset  style="width: 95%" id="orderList">
            <legend><!-- 销售订单 --><fmt:message key="customerForm.tabs.orders"/></legend>
			          	<table  id="orderList" class=ListShort width="100%" cellpadding="0" >
			              <thead>
			                <TR class=Header> 
			                  <!--序号>
			                  <TH><fmt:message key="orderDetailForm.tb.number"/></TH -->
			                  <!--订单号-->
			                  <TH><fmt:message key="orderForm.orderCode"/></TH>
			                  <!--合同号-->
			                  <!-- TH><fmt:message key="orderForm.contractId"/></TH -->
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
			                  
			                  <!-- TH id="button_add_new_obj"  style="cursor:hand" colspan="3" onclick="button_add_new_obj(2)"> 
			                  		<img id="orderImgAdd" name="orderImgAdd"  src="image/CRM_ADD.GIF" border="0"> 
			                  </TH -->
			                  
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
			              
			              </table>

						  <table width="100%" border="0" cellspacing="0" cellpadding="0">
			  				 <tr>
				  				 	 <td colspan="2"><IMG src="image/s.gif"  width="100%" height="2">
				  				 	 </td>
				  				 </tr>
		                        <tr  bgcolor="#eee">
		                          <td align="right"> 
		                              <div id="pageInfo_order"></div>
		                          </td>
		                     	</tr>
	
				          </table>

            
            
            </fieldset>

            
            <!--baseinso end-->
            
            
            
            
          </td>
        </tr>  
        <tr> 
          <td width="50%"> 
          
       		<!-- adrm_order:authorizeTag res="table.industryagent" -->
 
          
          
              <!--baseinso start-->
            <fieldset  style="width: 95%;display:none;">
            <legend><!-- 行业代理 --><fmt:message key="customerForm.tabs.industryAgent"/></legend>
			          	<table  id="agentInfoList" class=ListShort width="100%" cellpadding="0" >
			              <thead>
			                <TR class=Header> 
			                  <!--载体类型-->
			                  <TH><fmt:message key="contractTargetForm.carrierId"/></TH>
			                  <!--广告类型-->
			                  <TH><fmt:message key="agentInfoForm.advType"/></TH>
			                  <!--客户类别-->
			                  <TH><fmt:message key="customerForm.customerCategoryId"/></TH>
			                  <!--代理率-->
			                  <TH><fmt:message key="agentInfoForm.agentRate"/></TH>
			                  <!--最低折扣-->
			                  <TH><fmt:message key="agentInfoForm.lowestRate"/></TH>
			                  
			                  <TH id="button_add_new_obj"  style="cursor:hand" colspan="2" onclick="button_add_new_obj(3)"> 
			                  		<img id="agentInfoImgAdd" name="agentInfoImgAdd"  src="image/CRM_ADD.GIF" border="0"> 
			                  </TH>
			                  
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
			              
			              <tbody id="agentInfoBody"/>
			              
			              </table> 
			              
						  <table width="100%" border="0" cellspacing="0" cellpadding="0">
			  				 <tr>
				  				 	 <td colspan="2"><IMG src="image/s.gif"  width="100%" height="2">
				  				 	 </td>
				  				 </tr>
		                        <tr  bgcolor="#eee">
		                          <td align="right"> 
		                              <div id="pageInfo_agentInfo"></div>
		                          </td>
		                     	</tr>
	
				          </table>

            </fieldset>

            <!--baseinso end-->
            
            <!-- /adrm_order:authorizeTag -->
            
            
          </td>
        </tr>          
      </table></td>
  </tr>
</table>
          
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


     	   <div id="hiddenArea" name="hiddenArea" style="display:none"> 
                  <adrm_order:selectList name="customerCategorys" key="12"  level="0" toScope="page" /> 
                            <html:select property="customerCategoryId" styleId="customerCategoryId"> 
                            <html:option value=""></html:option> 
                            <html:options collection="customerCategorys" property="value" labelProperty="label"/> 
                            </html:select> <html:errors property="customerCategoryId"/>
                  
                  <adrm_order:selectList name="resourceSorts" key="40" toScope="page"/> 
                      <html:select property="resourceSortId" styleId="resourceSortId" name="resourceSortId"  value="0"> 
                      <html:option value=""/> 
                      <html:options collection="resourceSorts"  property="value" labelProperty="label"/> 
                  </html:select> 
					
				  <span id="carrierSelect">
					<select name="carrierId1" id="carrierId1"/> 
				  </span>	
				  

				                                                         
           </div> 
           
           
<html:hidden property="customer.customerName" styleId="customer.customerName" />
<html:hidden property="customerId" styleId="customerId"/>
<html:hidden property="customerCategoryId" styleId="categoryId"/>

</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("contractForm"));
</script>

<html:javascript formName="contractForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>

<input name="type" type="hidden" id="type">




<input id="ctxPath" type="hidden" value="<c:url value="/"/>">

<div style="display:none;" >

	<table width="100%" border="0" cellpadding="0" cellspacing="0" id="regCustomer_table">
	
 			<tr>  <td>&nbsp;</td> </tr>      

          <tr> <td id="regCustomerCategoryName_td"> <div id="regCustomerCategoryName"></td> </tr>
          
      		<tr>  <td>&nbsp;</td> </tr>      
                    <tr> <td><div id="regCustomerDiv" name="regCustomerDiv" ></td> </tr>
           <tr> <td>&nbsp;</td> </tr>
           <tr> 
            <td width="100%" >
             
       
	                <!-- span><fmt:message key="orderForm.regCustomerGrid"/></span -->
	                  <center>
                 	<div id="gridbox_regCustomer" width="98%" height="97%" style="background-color:white;"/>
            
            </td>
          </tr>
            
      </table>
      
      <div id="treeGroup2">
      
      	<div><div id="carrierTypeTreebox2"   /></div>
										
		<div><div id="compagesTreebox2"/></div>
		
      </div>

<div>
