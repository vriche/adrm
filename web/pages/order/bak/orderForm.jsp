<%@ include file="/common/taglibs.jsp"%>

<script type="text/javascript" src="<c:url value='/dwr/interface/OrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDetailManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDayInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/DayInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/SelectListManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/AgentInfoManager.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/order.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dayInfo.js'/>"></script>
<style type="text/css">
<!--

#tbBomOpt a{
	display:block;
	width:70px;
	padding:5px;
	background-color:buttonface;
	border:solid 2px #999999;
	color:blue;
	text-decoration: none;
}
#tbBomOpt a:hover{
	background-color:#DDE3EC;
}
-->
</style>

<title><fmt:message key="orderDetail.title"/></title>
<content tag="heading"><fmt:message key="orderDetail.heading"/></content>

<iframe name="actionframe" id="actionframe" frameborder="0" width="100%" height="0"></iframe>
<!--target="actionframe"-->
<html:form action="saveOrder"  method="get" styleId="orderForm" >

<span id="alert" style="display:none; background:#FFFFDD; font-weight:bold;">submitFunction called</span>

<table width="100%" border="0">
  <tr> 
    <td width="50%"><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td width="50%"> 
            <!--baseinso start-->
            <fieldset>
            <legend> 
            <!--订单基本信息-->
            <fmt:message key="orderForm.legend1"/></legend>
            <table width="99%" border="0" cellpadding="0" cellspacing="0">
              <tr> 
                <td width="50%" valign="top"> <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                    <tbody>
                      <tr> 
                        <td nowrap="nowrap" class="dataLabel"> 
                          <!-- 订单编号 -->
                          <adrm_order:label key="orderForm.orderCode"/>:</td>
                        <td> <html:text property="orderCode" styleId="orderCode"/> 
                        </td>
                      </tr>
                      <tr> 
                        <td nowrap="nowrap" class="dataLabel"> 
                          <!-- 关联编号 -->
                          <adrm_order:label key="orderForm.relationCode"/>: </td>
                        <td > <html:text property="relationCode" styleId="orderRelationCode"/> 
                        </td>
                      <tr> 
                        <td nowrap="nowrap" class="dataLabel"> 
                          <!-- 订单类别 -->
                          <adrm_order:label key="orderForm.categoryId"/>: </td>
                        <td> <adrm_order:selectList name="categoryMains" key="0"  toScope="page"/> 
                          <html:select property="categoryId" styleId="orderCategoryMain"> 
                          <html:option value=""/> <html:options collection="categoryMains" property="value" labelProperty="label"/> 
                          </html:select> <html:errors property="categoryId"/>	
                        </td>
                      </tr>
                      <tr> 
                        <td nowrap="nowrap" class="dataLabel"> 
                          <!-- 订单备注 -->
                          <adrm_order:label key="orderForm.orderMeno"/>: </td>
                        <td> <html:text property="orderMeno" styleId="orderMeno"/> 
                        </td>
                      </tr>
                  </table></td>
                <td valign="top"> <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                    <tbody>
                      <tr> 
                        <td nowrap="nowrap" class="dataLabel"> 
                          <!-- 合同编号 -->
                          <adrm_order:label key="orderForm.contractId"/>: </td>
                        <td ><html:text property="contract.code" styleId="orderContractCode"/> 
                        </td>
                      </tr>
                      <tr> 
                        <td class="requiredInput" nowrap="nowrap"> 
                          <!-- 客户名称 -->
                          <adrm_order:label key="orderForm.customerName"/>: </td>
                        <td >
                        

                                <div style="position:relative;">
								<span style="margin-left:100px;width:18px;overflow:hidden;">
		  						  <adrm_order:selectList name="customers" key="8"  toScope="page"/> 
		                          <html:select property="customerId" styleId="orderCustomerName"  style="width:137px;margin-left:-100px" onchange="this.parentNode.nextSibling.value=this.value"> 
		                          <html:option value=""/> <html:options collection="customers"  property="value" labelProperty="label"/> 
		                          </html:select> 								
								</span><input name="customerName" style="width:100px;position:absolute;left:0px;">
								</div>                         
                          
                          
                        </td>
                      </tr>
                      <tr> 
                        <td class="requiredInput" nowrap="nowrap"> 
                          <!-- 业务员 orderRelation-->
                          <adrm_order:label key="orderForm.userId"/>: </td>
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
                      </tr>
                      <tr> 
                        <td height="17" nowrap="nowrap" class="dataLabel"> 
                          <!-- 总应收 -->
                          <adrm_order:label key="orderForm.moneyIn"/>: </td>
                        <td > <html:text property="orderPublic.moneyRealpay" styleId="orderMoneySum" /> 
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
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td width="30%"> 
            <!--baseinso start-->
            <fieldset>
            <legend> 
            <!--订单明细-->
            <fmt:message key="orderForm.legend2"/> </legend>
            <table width="99%" border="0" cellpadding="0" cellspacing="0">
              <tr> 
                <td width="50%" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                    <tbody>
                      <tr> 
                        <td nowrap="nowrap" class="dataLabel"> 
                          <!-- 订单子类 -->
                          <adrm_order:label key="orderForm.categoryId"/>: </td>
                        <td> <select name="dtOrderCategoryId" id="dtOrderCategoryId">
                          </select> </td>
                      </tr>
                      <tr> 
                        <td nowrap="nowrap" class="dataLabel"> 
                          <!-- 磁带编码 -->
                          <adrm_order:label key="orderDetailForm.matterId"/>: 
                        </td>
                        <td> <input name="dtMatterCode" type="text" id="dtMatterCode"></td>
                      </tr>
                      <tr> 
                        <td nowrap="nowrap" class="dataLabel"> 
                          <!-- 广告名称 -->
                          <adrm_order:label key="orderDetailForm.matterName"/>: 
                        </td>
                        <td > <input type="text" name="dtMatterName" id="dtMatterName"> 
                        </td>
                      </tr>
                      <tr> 
                        <td nowrap="nowrap" class="dataLabel"> 
                          <!-- 广告版本 -->
                          <adrm_order:label key="orderDetailForm.matterEdit"/>: 
                        </td>
                        <td > <input type="text" name="dtMatterEdit" id="dtMatterEdit"> 
                        </td>
                      </tr>
                      <tr> 
                        <td nowrap="nowrap" class="requiredInput"> 
                          <!-- 广告长度 -->
                          <adrm_order:label key="orderDetailForm.matterLength"/>: 
                        </td>
                        <td > <select name="dtMatterLength" id="dtMatterLength">
                            <option value=" " selected> </option>
                            <c:forEach var="x" begin="5" end="300" step="5"> 
                            <option value="<c:out value="${x}"/>"><c:out value="${x}"/> 
                            </c:forEach> </select> </td>
                      </tr>
                      <tr> 
                        <td class="dataLabel" nowrap="nowrap"> 
                          <!-- 行业 -->
                          <adrm_order:label key="orderDetailForm.industryTypeId"/>: 
                        </td>
                        <td> 
                        
                        <div style="position:relative;">
							<span style="margin-left:100px;width:18px;overflow:hidden;">
	                        <adrm_order:selectList name="industryTypes" key="6"  toScope="page"/> 
	                          <html:select property="categoryId" styleId="dtIndustryTypeId" name="dtIndustryTypeId"  value="0" style="width:137px;margin-left:-100px"> 
	                          <html:option value=""/> <html:options collection="industryTypes"  property="value" labelProperty="label"/> 
	                          </html:select> <html:errors property="carrierId"/> 
                         </span></div>                         
                          
                          </td>
                      </tr>
                      <tr> 
                        <td class="dataLabel" nowrap="nowrap"> 
                          <!-- 价格类别 -->
                          <adrm_order:label key="orderDetailForm.resourcePriceType"/>: 
                        </td>
                        <td > 
                        
                        <div style="position:relative;">
						<span style="margin-left:100px;width:18px;overflow:hidden;">
	                        <adrm_order:selectList name="resourcePriceTypes" key="7"  toScope="page"/> 
	                          <html:select property="resourcePriceType" styleId="dtResourcePriceType"  name="dtResourcePriceType"  value="0" style="width:137px;margin-left:-100px"> 
	                          <html:option value=""/> <html:options collection="resourcePriceTypes"  property="value" labelProperty="label"/> 
	                          </html:select> <html:errors property="resourcePriceType"/> 
                         </span></div>  
                          
                          
                          <!-- 加收 -->
                          <!-- adrm_order:label key="orderDetailForm.appRate"/ -->
                          <!-- input name="dtAppRate" type="text" id="dtAppRate" tabindex="10" value="100" size="3" maxlength="40" -->
                        </td>
                      </tr>
                    </tbody>
                  </table></td>
                <td valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                    <tbody>
                      <tr> 
                        <td class="dataLabel" nowrap="nowrap"> 
                          <!-- 广告载体 -->
                          <adrm_order:label key="orderDetailForm.carrity"/>: </td>
                        <td> <adrm_order:selectList name="carriers" key="3"  level="0" toScope="page"/> 
                          <!--styleClass="select"-->
                          <html:select property="categoryId" styleId="dtCarrierId" name="dtCarrierId" value="0" > 
                          <html:option value=""/> <html:options collection="carriers"  property="value" labelProperty="label"/> 
                          </html:select> <html:errors property="carrierId"/> </td>
                      </tr>
                      <tr> 
                        <td class="dataLabel" nowrap="nowrap"> 
                          <!-- 广告位置 -->
                          <adrm_order:label key="orderDetailForm.posision"/>: 
                        </td>
                        <td> <select name="dtResourceInfoId" id="dtResourceInfoId" >
                          </select> 
                          <!-- 价格表 -->
                          <div style="display:none;"> 
                            <select name="dtPricesAndType" id="dtPricesAndType" >
                            </select>
                            <div> </div>
                          </div></td>
                      </tr>
                      <tr> 
                        <td class="dataLabel" nowrap="nowrap"> 
                          <!-- 指定 -->
                          <adrm_order:label key="orderDetailForm.appPosition"/>: 
                        </td>
                        <td> <adrm_order:selectList name="specifics" key="5"  toScope="page"/> 
                          <html:select property="categoryId" styleId="dtResourceSpecificId"> 
                          <html:option value=""/> <html:options collection="specifics"  property="value" labelProperty="label"/> 
                          </html:select> <html:errors property="resourceSpecificId"/>	
                          <!-- 最低销售价格 -->
                          <input name="dtPriceBaseLine" type="hidden" id="dtPriceBaseLine"  size="5" > 
                        </td>
                      </tr>
                      <tr> 
                        <td class="dataLabel" nowrap="nowrap"> 
                          <!-- 销售价格 -->
                          <adrm_order:label key="orderDetailForm.execPrice"/>: 
                        </td>
                        <td> <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr> 
                              <td width="63"> 
                                <!-- 销售价格 -->
                                <input name="dtExecPrice" type="text" id="dtExecPrice" tabindex="10" value="100" size="5" maxlength="40"> 
                              </td>
                              <td width="305"> <table width="91" border="0" cellspacing="0" cellpadding="0">
                                  <tr> 
                                    <!-- 刊例价格 -->
                                    <td width="45" align="right"><adrm_order:label key="orderDetailForm.sysPrice"/>: 
                                    </td>
                                    <td width="45"><input name="dtSysPrice" type="text" id="dtSysPrice"  size="5" ></td>
                                  </tr>
                                </table></td>
                            </tr>
                          </table></td>
                      </tr>
                      <tr> 
                        <td class="dataLabel" nowrap="nowrap"> 
                          <!-- 加收 -->
                          <adrm_order:label key="orderDetailForm.appRate"/>: </td>
                        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr> 
                              <td width="63"> 
                                <!-- 加收 -->
                                <input name="dtAppRate" type="text" id="dtAppRate" tabindex="10" value="100" size="5" maxlength="40"> 
                              </td>
                              <td width="305"> <table width="88" border="0" cellspacing="0" cellpadding="0">
                                  <tr> 
                                    <!-- 折扣 -->
                                    <td width="44" align="right"><adrm_order:label key="orderDetailForm.favourRate"/>: 
                                    </td>
                                    <td width="44"><input name="dtFavourRate" type="text" id="dtFavourRate" tabindex="10" value="100" size="5"></td>
                                  </tr>
                                </table></td>
                            </tr>
                          </table></td>
                      </tr>
                      <tr> 
                        <td class="dataLabel" nowrap="nowrap"> 
                          <!-- 明细应收总计 -->
                          <adrm_order:label key="orderDetailForm.moneyRealpay"/>: 
                        </td>
                        <td> <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr> 
                              <td width="73"> 
                                <!-- 明细应收总计 -->
                                <input name="dtMoneyRealpay" type="text" id="dtMoneyRealpay" tabindex="10" value="100" size="5" maxlength="40"> 
                              </td>
                              <td width="350"> <table width="88" border="0" cellspacing="0" cellpadding="0">
                                  <tr> 
                                    <!-- 明细刊例总计 -->
                                    <td width="46" align="right"><adrm_order:label key="orderDetailForm.moneyBase"/>: 
                                    </td>
                                    <td width="42"><input name="dtMoneyBase" type="text" id="dtMoneyBase" tabindex="10" value="100" size="5" maxlength="40" class="FieldDisable" ></td>
                                  </tr>
                                </table></td>
                            </tr>
                          </table></td>
                      </tr>
                      <tr> 
                        <td class="dataLabel" nowrap="nowrap"> 
                          <!-- 播出备注 -->
                          <adrm_order:label key="orderDetailForm.publishMemo"/>: 
                        </td>
                        <td> <input name="dtPublishMemo"type="text" id="dtPublishMemo" size="12"> 
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
    <td  valign="top">
    
    
	<!--baseinso start-->
    <fieldset style="heigth: 49%;">
    <legend><!--订单明细--><fmt:message key="orderForm.legend2"/></legend>
    
    
<table width="100%" border="0">
  <tr>
    <td width="0px">
    	<IMG src="image/s.gif"  width=0 height=263>
    </td>
    <td valign="top">    
    
    
			
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td> 
                  <!--新签订单-->
                  <!-- a id="Bt_newOrder"><fmt:message key="button.order.newOrder"/></a -->
                  <input name="button" type="button" id="Bt_newOrder" value='<fmt:message key="button.order.newOrder"/>'>	
                  <!--付款明细-->
                  <!--input onClick="selectPaymentDetail()"  type="button"  value='<fmt:message key="button.order.payment"/>' name="Submit2" -->
                  <!--排期总浏-->
                  <!--input  onClick="javascript:queryOrderAllBro()"   type="button" value='<fmt:message key="button.order.arrayList"/>' name=cancel3232223 -->
                  <!--明细查询-->
                  <!-- input  onClick="javascript:queryOrderDetail()"   type="button" value='<fmt:message key="button.order.detailSeach"/>' name=cancel32322222 -->
                  <!--查看日志-->
                  <!--input onClick="window.location='orderList.htm'" type="button" value='<fmt:message key="button.order.logs"/>' name=cancel32232232222 -->
                  <!--取消-->
                 
                  <c:choose> 
                  <c:when test='${param.id >0}'> 
                  	<html:cancel styleClass="" onclick="javascript:history.go(-1)"><fmt:message key="button.cancel"/></html:cancel>	
                  </c:when>
                   <c:otherwise> 
                    <input name="button" type="button" onclick="window.location='<c:url value='orders.html'/>'" value='<fmt:message key="button.cancel"/>'>
                  </c:otherwise>
                  </c:choose> 
                   

 				  <!--新添广告-->
                  <input name="button" type="button"  id="Bt_newOrderDetail" value='<fmt:message key="button.order.addAd"/>'> 
                  <!--新添并粘贴-->
                  <input name="button" type="button" id="Bt_newAndPostOrderDetailt"  value='<fmt:message key="button.order.addWpost"/>'> 
                  <!--复制-->
                  <!--input  id="Bt_copyOrderDetail"   type="button" value='<fmt:message key="button.order.copy"/>' name=cancel3232223 -->
                  <!--粘贴-->
                  <!--input  id="Bt_postOrderDetail"   type="button" value='<fmt:message key="button.order.post"/>' name=cancel32322222 -->
                  <!--提交审核-->
                  <!-- input id="Bt_sendCkeck" type="button" value='<fmt:message key="button.order.chech"/>' name='checked' -->
                  <!--保 存-->
                  <!--input onClick="bCancel=false;return validateOrderForm(this.form.orderForm); saveOrder();" name="orderForm" type="button" value='<fmt:message key="button.order.save"/>' -->
                  <!-- input onClick="saveOrder();" name="orderForm" type="button" value='<fmt:message key="button.order.save"/>' -->
                  <input name="button" type="button" id="Bt_saveOrder" value='<fmt:message key="button.order.save"/>'> 
                  <span id="progressMsg" style="display:none;"><img alt="Indicator" src="<c:url value='image/indicator.gif'/>"  width="14" heigth="8"/> 
                  Loading</span>				  
				  
				  
				  
				  </td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td ><IMG src="image/s.gif"  width=1 height=5></td>
        </tr>
        <tr> 
          <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
        </tr>
        <tr> 
          <td> <table  id="orderDetailTable" class=ListShort width="100%" cellpadding="0" >
              <thead>
                <TR class=Header> 
                  <!--编号-->
                  <TH><fmt:message key="orderDetailForm.tb.number"/></TH>
                  <!--位置-->
                  <TH><fmt:message key="orderDetailForm.tb.pos"/></TH>
                  <!--版本-->
                  <TH><fmt:message key="orderDetailForm.tb.ver"/></TH>
                  <!--长度-->
                  <TH><fmt:message key="orderDetailForm.tb.len"/></TH>
                  <!--开始日期-->
                  <TH><fmt:message key="orderDetailForm.tb.start"/></TH>
                  <!--结束日期-->
                  <TH><fmt:message key="orderDetailForm.tb.end"/></TH>
                  <!--次数-->
                  <TH><fmt:message key="orderDetailForm.tb.tim"/></TH>
                  <!--审核-->
                  <!-- TH><fmt:message key="orderDetailForm.tb.ckecked"/></TH -->
                  <TH id="orderDetailTableRow" name="orderDetailTableRow" style="cursor:hand" colspan="1" > 
                  <img id="orderDetailImgAdd" name="orderDetailImgAdd"  src="image/CRM_ADD.GIF" border="0"> 
                  </TH>
                </TR>
                <tr > 
                  <td colspan="10"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr> 
                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
                      </tr>
                    </table></td>
                </tr>
              </thead>
              <tbody id="orderDetailBody">
              </tbody>
            </table></td>
        </tr>
        <tr> 
          <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
        </tr>
        <tr> 
          <td> <table width="100%" class=ListShort>
              <tbody>
                <tr   bgcolor="#D8DFE7"> 
                  <td colspan="9"> <div align="right"> 
                      <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr> 
                          <td  align="left"> <fmt:message key="orderDetailForm.tb.total"/> 
                            <html:text property="orderPublic.times" styleId="orderSumTimes" styleClass="FieldLable" disabled="true"/> 
                            <!-- html:text property="sumTimes" styleId="dtSumTimes"/ -->
                            <!-- input type="text" id="dtSumTimes"  id="dtSumTimes" style="width:20%;border:none;text-align:center;background-color:#D8DFE7"/ -->
                            <fmt:message key="contractForm.unit.times"/> <fmt:message key="orderDetailForm.tb.recs"/>: 
                            <span id="totalRecords" style="font-weight:bold;"></span> 
                            <fmt:message key="contractForm.unit.rec"/> </td>
                          <td align="right"> 
                              <div id="pageInfo"></div>
                              <!--当前页-->
                              <span id="pageIndex" style="font-weight:bold;"></span> 
                            </td>
                        </tr>
                      </table>
                    </div></td>
                </tr>
              </tbody>
            </table></td>
        </tr>
        <tr> 
          <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
        </tr>
        <tr> 
          <td ><IMG src="image/s.gif"  width=1 height=5></td>
        </tr>
        <tr> 
          <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td> 
                </td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td ><IMG src="image/s.gif"  width=1 height=5></td>
        <tr> 
        </table>
        
        
		</td>
		  </tr>
		</table>        
		            
            </fieldset>
            <!--baseinso end-->




		
		
		</td>
  </tr>
  <tr> 
    <td colspan="2" valign="top"><table width="100%" border="5" cellspacing="0" cellpadding="0">
        <tr> 
          <td><table cellspacing=0 cellpadding=0 width="100%" border=0>
              <tbody>
                <tr> 
                  <td width="65%" align=left nowrap> 
                    <!--选择-->
                    <fmt:message key="orderDayInfoForm.pickMonth"/> 
					<select name="choseArangeM" id="choseArangeM" tabindex="8">
                      <option value="13" selected></option>
                      <option value="0">=<adrm_order:label key="orderDayInfoForm.allYear"/>=</option>
                      <c:forEach var="x" begin="1" end="12" step="1"> 
                      <option value="<c:out value="${x}"/>"><c:out value="${x}"/> 
                      </c:forEach> </select> &nbsp;&nbsp; 
                    <!--清除排期-->
                    <input onClick="javascript:clearMonthInfo()"  type="button" value='<fmt:message key="button.order.clean"/>' name=ccc> 
                    <!--恢复排期-->
                    <input  onClick="javascript:resumeMonthInfo()"   type="button" value='<fmt:message key="orderDayInfoForm.resumeMonthInfo"/>' name=c>	
                    <!--自动配置-->
                    <!-- input onClick="selectPaymentDetail()"  type="button"  value='<fmt:message key="button.order.autoPlay"/>' name="Submit2" -->
                    <!--显示星期-->
                    <!-- input  onClick="javascript:queryOrderAllBro()"   type="button" value='<fmt:message key="button.order.displayW"/>' name=cc -->
                    <!--剩余时间-->
                    <!-- input  onClick="javascript:queryOrderDetail()"   type="button" value='<fmt:message key="button.order.releve"/>' name=c -->
                    <!--增加月份-->
                    <input  onClick="javascript:addNextMonth()"   type="button" value='<fmt:message key="orderDayInfoForm.addNextMonth"/>' name=c> 
                    <!--显示剩余时间-->
                    <!-- input type="checkbox" name="isDisplayLeavTimes" id="isDisplayLeavTimes" onclick="displayLeavTimes()" -->
                    <!--标准-->
                    <adrm_order:label key="orderDayInfoForm.totalTime"/>: <input name="dayTotalTime" id="dayTotalTime" size="3"> 
                    <!--占用-->
                    <!-- adrm_order:label key="orderDayInfoForm.usedTimee"/ -->
                    <input name="dayUsedTime"   id="dayUsedTime" size="3" type="hidden"> 
                    <!--剩余-->
                    <adrm_order:label key="orderDayInfoForm.leaveTime"/>: <input name="dayLeaveTime"   id="dayLeaveTime" size="3"> 
                    <!--总次数-->
                    <fmt:message key="orderDetailForm.tb.total"/>: <input name="text" type="text" class="FieldxShort" id="dtSumTimes"  onchange="resetSumPriceInfo()"  size="2"/> 
                    <!--显示剩余时间-->
                    <fmt:message key="orderDayInfoForm.displayLeavTimes"/> <input name="isDisplayLeavTimes" id="isDisplayLeavTimes" type="checkbox"> 
                  </td>
                  <td class=bodySmall ><table width="100%" border="0">
                      <tr> 
                        <td width="10%"><img src="image/bro_gray_02.gif" width="12" height="12"> 
                          <fmt:message key="orderForm.color.lable1"/> 
                          <!--过期-->
                        </td>
                        <td width="10%"><img src="image/bro_sky_blue.gif" width="12" height="12"> 
                          <fmt:message key="orderForm.color.lable2"/> 
                          <!--周末-->
                        </td>
                        <td width="10%"><img src="image/bro_gray_05.gif" width="12" height="12"> 
                          <fmt:message key="orderForm.color.lable3"/> 
                          <!--无效-->
                        </td>
                        <td width="10%"><img src="image/bro_purple.gif" width="12" height="12"> 
                          <fmt:message key="orderForm.color.lable4"/> 
                          <!--指定-->
                        </td>
                        <td width="10%"><img src="image/bro_gray_03.gif" width="12" height="12"> 
                          <fmt:message key="orderForm.color.lable5"/> 
                          <!--占满-->
                        </td>
                        <td width="10%"><img src="image/bro_red.gif" width="12" height="12"> 
                          <fmt:message key="orderForm.color.lable6"/> 
                          <!--超时-->
                        </td>
                      </tr>
                    </table></td>
                </tr>
                <tr> 
                  <td colspan=4><img height=1 src="image/s.gif" 
              width=1></td>
                </tr>
              </tbody>
            </table></td>
        </tr>
        <tr> 
          <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
        </tr>
        <tr> 
          <td><table width="98%" border="1" id="dayInfoArrange" cellpadding="0" cellspacing="0"  class=ListShort>
              <colgroup>
              <col width="100%">
              <tr> 
                <th nowrap width="20" bgcolor="#D8DFE7"><div align="center"><a id="Bt_selectAll" > 
                    <!-- 全选 -->
                    <adrm_order:label key="orderDayInfoForm.selectAll"/></a></div></th>
                <th nowrap width="10%" bgcolor="#D8DFE7"><div align="center"> 
                    <!-- 播出月份 -->
                    <fmt:message key="orderDayInfoForm.broMonth"/></div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">&nbsp;1&nbsp; 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">&nbsp;2&nbsp; 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">&nbsp;3&nbsp; 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">&nbsp;4&nbsp; 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">&nbsp;5&nbsp; 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">&nbsp;6&nbsp; 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">&nbsp;7&nbsp; 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">&nbsp;8&nbsp; 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">&nbsp;9&nbsp; 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">10 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">11 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">12 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">13 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">14 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">15 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">16 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">17 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">18 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">19 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">20 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">21 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">22 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">23 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">24 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">25 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">26 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">27 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">28 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">29 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">30 
                  </div></th>
                <th nowrap width="22" bgcolor="#D8DFE7"><div align="center">31 
                  </div></th>
                <th nowrap width="50" bgcolor="#D8DFE7"><div align="center"><strong> 
                    <!-- 总次数 -->
                    <fmt:message key="orderDayInfoForm.monthTimes"/></strong></div></th>
                <th nowrap width="50" bgcolor="#D8DFE7"><div align="center"><strong> 
                    <!-- 刊例价 -->
                    <fmt:message key="orderDetailForm.execPrice"/></strong></div></th>
              </tr>
              <tbody id="monthInfosBody" name="monthInfosBody">
              </tbody>
            </table></td>
        </tr>
      </table></td>
  </tr>
</table>


<div style="display:none;">
<table width="100%" border="1">
  <tr>
    <td>
    	contractId:			<html:text property="contractId" styleId="orderContractId"/> <br>
		orderId:			<html:text property="id" styleId="orderId"/> <br>
		customerId:			<!-- html:text property="customerId" styleId="orderCustomerId"/ --> <br>
		moneyIn:			<html:text property="orderPublic.moneyIn" styleId="orderMoneyIn"/><br>
		isCkecked:			<html:text property="isCkecked" styleId="orderIsCkecked"/><br>
		createBy:			<html:text property="createBy" styleId="orderCreateBy"/><br>
		modifyBy:			<html:text property="modifyBy" styleId="orderModifyBy"/><br>
		publishStartDate:	<html:text property="orderPublic.publishStartDate" styleId="orderPublishStartDate"/> <br>
		publishEndDate:		<html:text property="orderPublic.publishEndDate" styleId="orderPublishEndDate"/> <br>
		sumTimes:			<!-- html:text property="orderPublic.times" styleId="orderSumTimes"/ --> <br>
		publishMemo:		<html:text property="publishMemo" styleId="orderPublishMemo"/> <br>
		
    </td>
    <td>
		dtId:				 <input type="text"  name="dtId" id="dtId"/><br>
		dtOrderId			 <html:text property="id" styleId="dtOrderId"/><br>
    	dtResourceType:		 <input type="text"  name="dtResourceType" id="dtResourceType"/> <br>
		dtMoneyBase:		 <!-- input type="text"  name="dtMoneyBase" id="dtMoneyBase"/ --> <br>
		dtSumTimes:			 <!-- input type="text"  name="dtSumTimes" id="dtSumTimes"/ --> <br>
		dtSysPrice:			 <!-- input type="text"  name="dtSysPrice" id="dtSysPrice"/ --><br>
		dtPublishStartDate:	 <input type="text"  name="dtPublishStartDate" id="dtPublishStartDate"/><br>
		dtPublishEndDate:	 <input type="text"  name="dtPublishEndDate" id="dtPublishEndDate"/><br>
		dtMatteType:		 <input type="text"  name="dtMatteType" id="dtMatteType"/> <br>
		dtIsCkecked:		 <input type="text"  name="dtIsCkecked" id="dtIsCkecked"/> <br>
		dtMoneyIn:			 <input type="text"  name="dtMoneyIn" id="dtMoneyIn"/> <br>
		dtMatterId:		 	 <input type="text"  name="dtMatterId" id="dtMatterId"/> <br>
		dtResourceWorkspanId:<input type="text"  name="dtResourceWorkspanId" id="dtResourceWorkspanId"/> <br>		
		dtCreateBy:			 <input type="text"  name="dtCreateBy" id="dtCreateBy"/> <br>	
		dtCreateDate:		 <input type="text"  name="dtCreateDate" id="dtCreateDate"/> <br>	
		dtModifyBy:			 <input type="text"  name="dtModifyBy" id="dtModifyBy"/> <br>	
		dtModifyDate:		 <input type="text"  name="dtModifyDate" id="dtModifyDate"/> <br>	
		
		<!-- 补差 --><adrm_order:label key="orderDetailForm.moneyBalance"/>
		<input name="dtMoneyBalance" type="text" id="dtMoneyBalance" tabindex="10"  size="10" maxlength="40">
	</td>
  </tr>
</table>
</div>

</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("orderForm"));
</script>

<html:javascript formName="orderForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>

