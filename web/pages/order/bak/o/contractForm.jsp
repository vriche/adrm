<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="contractDetail.title"/></title>
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
                              <td ><html:text property="id" styleId="id" />

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
            <legend><!-- 付款信息 --><fmt:message key="contractForm.paymentInfo"/></legend>
            <TABLE class=ListShort>
              <TBODY>

                <TR class=Header> 
                    <!--次数--><TH><fmt:message key="contractPaymentForm.payNumber"/></TH>
                    <!--付款类型--><TH><fmt:message key="contractPaymentForm.incomeModeId"/></TH>
                    <!--应付款日期--><TH><fmt:message key="contractPaymentForm.payDate"/></TH>
                    <!--应付金额--><TH><fmt:message key="contractPaymentForm.moneyPay"/></TH>
                    <!--已分配金额--><TH><fmt:message key="contractPaymentForm.moneyIn"/></TH>
                    <TH width="10%">
	                    <fmt:message key="button.operation"/>
	                    <img onClick="window.location='<c:url value="/editContractPayment.html?contractId="/><c:out value="${contractForm.id}"/>'"  src="image/CRM_ADD.GIF" border="0" height="14" width="14">
                    </TH>
                </TR>
                
                 	<%int i = 0;String myClass = "DataLight";%>
	                <c:forEach var="payment" items="${contractForm.contractPayments}" >
	                <% if(i++%2 == 0){myClass = "DataDark";}else{myClass = "DataLight";}%>
	                <TR class=<%=myClass%> onClick="selectpos()"> 
		                <TD>
		                 <c:out value="${payment.payNumber}"/>
		                </TD>  
						<TD><c:out value="${payment.incomeModeId}"/></TD>                 				      
	                    <TD><c:out value="${payment.payNumber}"/></TD>
						<TD><c:out value="${payment.payDate}"/></TD>  
	                    <TD><c:out value="${payment.moneyIn}"/></TD>
						<TD width="10%">
							  <!-- input onClick="window.location='<c:url value="/editContractPayment.html?id="/><c:out value="${payment.id}"/>&method=delete'"  name="submitDelete" type="image" src="image/button_delete.gif" width="17" height="17" border="0" -->
		                      <img   style="cursor:hand" onClick="window.location='<c:url value="/editContractPayment.html?id="/><c:out value="${payment.id}"/>&method=edit'"   src="image/EDIT.GIF" alt="版本拆分" width="16" height="16">
                      	</TD>
					</TR>								      
				    </c:forEach>

              </TBODY>
            </TABLE>
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

