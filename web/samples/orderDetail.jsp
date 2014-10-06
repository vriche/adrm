<%@ include file="/common/taglibs.jsp"%>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/broArrange.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/OrderCategoryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IndustryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/SpecificManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDetailManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/PriceTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/DayInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDayInfoManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/PriceManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/orderCategory.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/industry.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/specific.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/matter.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDetail.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/order.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/priceType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderPublic.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/price.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/dayInfo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDayInfo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/sample/broArrange.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/sample/orderService.js'/>"></script>

<title><fmt:message key="orderDetail.title"/></title>
<content tag="heading"><fmt:message key="orderDetail.heading"/></content>

<style>
tbody .day {
/* Cells <TD> containing month days dates */
	font-family: verdana, tahoma, sans-serif;
	width: 2em;
	color: #000;
	text-align: right;
	padding: 2px 4px 2px 2px;
}
</style>

<fieldset style="width: 98%" id="orderForm">
 <table width="100%" border="0">
  <tr>
    <td>
<fieldset style="width: 97%">

	<table width="100%" border="0">
	  <tr> 
	    <td width="50%">
	    <table width="100%" border="0" cellpadding="0" cellspacing="0">
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
	                          <fmt:message key="orderForm.orderCode"/>:</td>
	                        <td> <input name="orderCode" type="text" id="orderCode">
	                        </td>
	                      </tr>
	                      <tr> 
	                        <td nowrap="nowrap" class="dataLabel"> 
	                          <!-- 关联编号 -->
	                          <fmt:message key="orderForm.relationCode"/>: </td>
	                        <td > <input name="relationCode" type="text" id="relationCode">
	                        </td>
						    <tr> 
						      <td nowrap="nowrap" class="requiredInput"><!--定单类别--> <fmt:message key="orderForm.categoryId"/>:</td>
						      <td><!--定单类别-->
						           <select name="categoryId" id="categoryId"/>
						       </td>
						    </tr>
	                      <tr> 
	                        <td nowrap="nowrap" class="dataLabel"> 
	                          <!-- 应付金额 -->
	                          <fmt:message key="orderForm.moneySum"/>: </td>
	                        <td> <input name="orderPublic.moneyRealpay" type="text" id="orderPublic.moneyRealpay">
	                        <input name="orderMeno" type="hidden" id="orderMeno">
	                        </td>
	                      </tr>
	                  </table></td>
	                <td valign="top"> <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
	                    <tbody>
	                      <tr> 
	                        <td nowrap="nowrap" class="dataLabel"> 
	                          <!-- 合同编号 -->
	                          <fmt:message key="orderForm.contractId"/>: </td>
	                        <td ><input name="contract.code" type="text" id="contract.code"> 
	                        </td>
	                      </tr>
						    <tr> 
						      <td nowrap="nowrap" class="dataLabel"><!--客户名称--> <fmt:message key="orderForm.customerName"/>:</td>
						      <td><!--客户名称-->
						           <select name="customerId" id="customerId"/>
						       </td>
						    </tr>
	                      </tr>
						    <tr> 
						      <td nowrap="nowrap" class="requiredInput"><!--业务员--> <fmt:message key="orderForm.userId"/>:</td>
						      <td><!--业务员-->
						           <select name="userId" id="userId"/>
						       </td>
						    </tr>
	                      <tr> 
	                        <td height="17" nowrap="nowrap" class="dataLabel"> 
	                          <!-- 总应收 -->
	                          <fmt:message key="orderForm.moneyIn"/>: </td>
	                        <td ><input name="orderPublic.moneyIn" type="text" id="orderPublic.moneyIn"> 
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
						      <td nowrap="nowrap" class="requiredInput"><!-- 订单子类 --> <fmt:message key="orderForm.categoryId"/>:</td>
						      <td><!-- 订单子类 -->
						           <select name="orderCategoryId" id="orderCategoryId"/>
						       </td>
						    </tr>   
	                      <tr> 
	                        <td nowrap="nowrap" class="dataLabel"> 
	                          <!-- 磁带编码 -->
	                          <fmt:message key="orderDetailForm.matterId"/>: 
	                        </td>
	                        <td><input name="matter.tapeCode" type="text" id="matter.tapeCode"> 
	                      </tr>
	                      <tr> 
	                        <td nowrap="nowrap" class="dataLabel"> 
	                          <!-- 广告名称 -->
	                          <fmt:message key="orderDetailForm.matterName"/>: 
	                        </td>
	                        <td > <input type="text" name="matter.name" id="matter.name"> 
	                        </td>
	                      </tr>
	                      <tr> 
	                        <td nowrap="nowrap" class="dataLabel"> 
	                          <!-- 广告版本 -->
	                          <fmt:message key="orderDetailForm.matterEdit"/>: 
	                        </td>
	                        <td > <input type="text" name="matter.edit" id="matter.edit"> 
	                        </td>
	                      </tr>
						    <tr> 
						      <td nowrap="nowrap" class="requiredInput"><!--广告长度--> <fmt:message key="orderDetailForm.matterLength"/>:</td>
						      <td><!--广告长度-->
						           <select name="matterLength" id="matterLength"/>
						       </td>
						    </tr>
						    <tr> 
						      <td nowrap="nowrap" class="dataLabel"><!--行业--> <fmt:message key="orderDetailForm.industryTypeId"/>:</td>
						      <td><!--行业-->
						           <select name="industryTypeId" id="industryTypeId"/>
						       </td>
						    </tr>  
	
	                      <tr> 
	                        <td class="dataLabel" nowrap="nowrap"><!-- 价格类别 --><fmt:message key="orderDetailForm.resourcePriceType"/></td> 
	                          
	                        <td> <select name="resourcePriceType" id="resourcePriceType" ></td>
	
	                      </tr>  
	                    </tbody>
	                  </table></td>
	                <td valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
	                    <tbody>
						    <tr> 
						      <td nowrap="nowrap" class="requiredInput"><!--广告载体--> <fmt:message key="orderDetailForm.carrity"/></td>
						      <td><!--广告载体-->
						           <select name="carrierId" id="carrierId"/>
						       </td>
						    </tr>
	                      <tr> 
	                        <td class="requiredInput" nowrap="nowrap"><!-- 广告位置 --><fmt:message key="orderDetailForm.posision"/></td> 
	                          
	                        <td> <select name="resourceInfoId" id="resourceInfoId" ></td>
							
	                      </tr>
							<tr><!--价格类别隐藏域-->
							 	<td class="requiredInput" nowrap="nowrap"></td>
								<td>
									<select name="dtPricesAndType" id="dtPricesAndType" style="display:none;">
								</td>
							</tr>
						    <tr> 
						      <td nowrap="nowrap" class="dataLabel"><!--指定--> <fmt:message key="orderDetailForm.appPosition"/>:</td>
						      <td><!--指定-->
						           <select name="resourceSpecificId" id="resourceSpecificId"/>
						       </td>
						    </tr>
						    <tr> 
	                        <td class="dataLabel" nowrap="nowrap"> 
	                          <!-- 销售价格 -->
	                          <fmt:message key="orderDetailForm.execPrice"/>: 
	                        </td>
	                        <td> <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                            <tr> 
	                              <td width="63"> 
	                                <!-- 销售价格 -->
	                                <input name="execPrice" type="text" id="execPrice" tabindex="10" size="5" maxlength="40"> 
	                              </td>
	                              <td width="305"> <table width="91" border="0" cellspacing="0" cellpadding="0">
	                                  <tr> 
	                                    <!-- 刊例价格 -->
	                                    <td width="45" align="right"><fmt:message key="orderDetailForm.sysPrice"/>: 
	                                    </td>
	                                    <td width="45"><input name="sysPrice" type="text" id="sysPrice"  size="5" ></td>
	                                  </tr>
	                                </table></td>
	                            </tr>
	                          </table></td>
	                      </tr>
	                      <tr> 
	                        <td class="dataLabel" nowrap="nowrap"> 
	                          <!-- 加收 -->
	                          <fmt:message key="orderDetailForm.appRate"/>: </td>
	                        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
	                            <tr> 
	                              <td width="63"> 
	                                <!-- 加收 -->
	                                <input name="dtAppRate" type="text" id="appRate" tabindex="10" value="100" size="5" maxlength="40"> 
	                              </td>
	                              <td width="305"> <table width="88" border="0" cellspacing="0" cellpadding="0">
	                                  <tr> 
	                                    <!-- 折扣 -->
	                                    <td width="44" align="right"><fmt:message key="orderDetailForm.favourRate"/>: 
	                                    </td>
	                                    <td width="44"><input name="dtFavourRate" type="text" id="favourRate" tabindex="10" value="100" size="5"></td>
	                                  </tr>
	                                </table></td>
	                            </tr>
	                          </table></td>
	                      </tr>
	                      <tr> 
	                        <td class="dataLabel" nowrap="nowrap"> 
	                          <!-- 明细应收总计 -->
	                          <fmt:message key="orderDetailForm.moneyRealpay"/>: 
	                        </td>
	                        <td> <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                            <tr> 
	                              <td width="73"> 
	                                <!-- 明细应收总计 -->
	                                <input name="dtMoneyRealpay" type="text" id="moneyRealpay" tabindex="10" value="100" size="5" maxlength="40"> 
	                              </td>
	                              <td width="350"> <table width="88" border="0" cellspacing="0" cellpadding="0">
	                                  <tr> 
	                                    <!-- 明细刊例总计 -->
	                                    <td width="46" align="right"><fmt:message key="orderDetailForm.moneyBase"/>: 
	                                    </td>
	                                    <td width="42"><input name="dtMoneyBase" type="text" id="moneyBase" tabindex="10" value="100" size="5" maxlength="40" class="FieldDisable" ></td>
	                                  </tr>
	                                </table></td>
	                            </tr>
	                          </table></td>
	                      </tr>
	                      <tr> 
	                        <td class="dataLabel" nowrap="nowrap"> 
	                          <!-- 播出备注 -->
	                          <fmt:message key="orderDetailForm.publishMemo"/>: 
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
			    <fieldset style="heigth: 47%;">
			    
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
					                  <input type="button" id="Btn_addNewOrder" value="<fmt:message key="button.order.newOrder"/>" name="add">
					         
					                  <!--取消-->
	                 				  <input type="button" id="Btn_cancel" value="<fmt:message key="button.cancel"/>">
	
					
					 				  <!--新添广告-->
					                  <input type="button"  id="Btn_addNewAdver" value='<fmt:message key="button.order.addAd"/>'> 
					                  <!--新添并粘贴-->
					                  <input type="button" id="Btn_addAndPost"  value='<fmt:message key="button.order.addWpost"/>'> 
					                  <!--保 存-->
									  <input type="button" id="Btn_save"  value='<fmt:message key="button.order.save"/>'>
									
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
				          <td> 
				          	<table  id="orderDetailTable" class=ListShort width="100%" cellpadding="0" >
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
	
				                  <TH id="orderDetailTableRow" name="orderDetailTableRow" style="cursor:hand" colspan="1"> 
				                 	 <img id="orderDetailImgAdd" name="orderDetailImgAdd"  src="image/CRM_ADD.GIF" border="0"> 
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
					              
				              
				              <tbody id="orderDetailBody"/>
				              
				              </thead>
				              
					          <tbody>
					          <tr height="20"><td colspan="8">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
							  				 <tr>
								  				 	 <td colspan="2"><IMG src="image/s.gif"  width="100%" height="2">
								  				 	 </td>
								  				 </tr>
						                        <tr  bgcolor="#D8DFE7">
						                          <td><fmt:message key="orderDetailForm.tb.total"/>:</td>
						                          <td align="left"><div id = "orderDetail_num" disabled="false"/></td>
						                          <td align="right"> 
						                              <div id="pageInfo_orderDetail"></div>
						                          </td>
						                     	</tr>
								  </table>
					          </tr>
					          </tbody>
				              
				            </table>
				        </td>
					   </tr>
					</table>            
		  		</td>
			</tr>
		</table>
		</fieldset>
		</td>
	</tr>
	</table>	
</fieldset>
	</td>
  </tr>
  <tr>
    <td>
<table width="100%" border="1">
  <tr>
    <td>
	
	
<table width="100%" border="5" cellspacing="0" cellpadding="0">
        <tr> 
          <td><table cellspacing=0 cellpadding=0 width="100%" border=0>
              <tbody>
                <tr> 
                  <td align=left nowrap> 
                    <!--选择-->
                    <fmt:message key="orderDayInfoForm.pickMonth"/>
                  </td> 
                  <td>                     
                     <select name="selectMonth" id="selectMonth"/> 
                  </td> 
                  <td>  
                    <!--清除排期-->
                    <input type="button" value='<fmt:message key="button.order.clean"/>' id="cleanBroArrange"> 
                    <!--恢复排期-->
                    <input  type="button" value='<fmt:message key="orderDayInfoForm.resumeMonthInfo"/>' id="resumeBroArrange">	
                    <!--自动配置-->
                    <!-- input type="button"  value='<fmt:message key="button.order.autoPlay"/>' name="Submit2" -->
                    <!--显示星期-->
                    <!-- input  type="button" value='<fmt:message key="button.order.displayW"/>' name=cc -->
                    <!--剩余时间-->
                    <!-- input type="button" value='<fmt:message key="button.order.releve"/>' name=c -->
                    <!--增加月份-->
                    <input  type="button" value='<fmt:message key="orderDayInfoForm.addNextMonth"/>' id="addBroArrange"> 
                    <!--显示剩余时间-->
                    <!-- input type="checkbox" name="isDisplayLeavTimes" id="isDisplayLeavTimes" -->
                    <!--标准-->
                    <fmt:message  key="orderDayInfoForm.totalTime"/>: <input name="dayTotalTime" id="dayTotalTime" size="3"> 
                    <!--占用-->
                    <!-- fmt:message key="orderDayInfoForm.usedTimee"/ -->
                    <input name="dayUsedTime"   id="dayUsedTime" size="3" type="hidden"> 
                    <!--剩余-->
                    <fmt:message  key="orderDayInfoForm.leaveTime"/>: 
                    	<input name="dayLeaveTime"   id="dayLeaveTime" size="3"> 
                    <!--总次数-->
                    <fmt:message key="orderDetailForm.tb.total"/>:
                     <input type="text" class="FieldxShort" id="broSumTime" name="broSumTime"   size="2"/> 
                    <!--显示剩余时间-->
                    <fmt:message key="orderDayInfoForm.displayLeavTimes"/> 
                    <input name="isDisplayLeavTimes" id="isDisplayLeavTimes" type="checkbox"> 
                  </td>
                  <td align="right">
						<TABLE cellSpacing=0 cellPadding=0 width=180 border=0 class="arrange">
						  <TBODY>
						  <TR>
						    <TD class=forcetime align=middle width=30><fmt:message key="orderForm.color.lable1"/></TD><!--过期-->
						    <TD class=weekend   align=middle width=30><fmt:message key="orderForm.color.lable2"/></TD><!--周末-->
						    <TD class=notday    align=middle width=30><fmt:message key="orderForm.color.lable3"/></TD><!--无效-->
						    <TD class=specific  align=middle width=30><fmt:message key="orderForm.color.lable4"/></TD><!--指定-->
						    <TD class=fulltime  align=middle width=30><fmt:message key="orderForm.color.lable5"/></TD><!--占满-->
						    <TD class=overtime  align=middle width=30><fmt:message key="orderForm.color.lable6"/></TD><!--超时-->
						   </TR>
						   </TBODY>
						</TABLE>
	
                    </td>
                </tr>
                <tr> 
                  <td colspan=4><img height=1 src="image/s.gif" 
              width=1></td>
                </tr>
              </tbody>
            </table>	
	
	
	</td>
  </tr>
  <tr>
    <td>
	
				<table width="98%" border="1" id="orderDayInfoTable" cellpadding="0" cellspacing="0"  class=ListShort>
		              <tr> 
		                <!-- 播出月份 -->
		                <th nowrap width="5%" bgcolor="#D8DFE7" align="center"><fmt:message key="orderDayInfoForm.broMonth"/></th>
		                <!-- 播出日期 -->
		                <% for(int i= 1; i< 32;i++){ %>
		                   <th nowrap width="22" bgcolor="#D8DFE7" align="center"><%=i%></th>
		                <%}%>
		                <!-- 总次数 -->
		                <th nowrap width="5%" bgcolor="#D8DFE7" align="center"><fmt:message key="orderDayInfoForm.monthTimes"/></th>
		                <!-- 刊例价 -->
		                <th nowrap width="5%" bgcolor="#D8DFE7" align="center"><fmt:message key="orderDetailForm.sysPrice"/></th>
		                <!-- 销售价格 -->
		                <th nowrap width="5%" bgcolor="#D8DFE7" align="center"><fmt:message key="orderDetailForm.execPrice"/></th>                
		              </tr>
		              <TBODY id="orderDayInfoTbody" name="orderDayInfoTbody" class="arrange"/>
		
		            </table>
            </td>
        </tr>
      </table>
	  
	  	
	
	</td>
  </tr>
</table>

<div style="display:block;">
<!-- 定单信息 -->
<input type="hidden" id="dt_orderId">
<input type="hidden" id="dt_matter.id">
<input type="hidden" id="dt_orderDetailId">
PriceBaseLine:<input name="dtPriceBaseLine" type="text" id="dtPriceBaseLine"  size="5" >
NormalAgentPrice:<input name="dtNormalAgentPrice" type="text" id="dtNormalAgentPrice"  size="5" >
MonthAgentPrice:<input name="dtMonthAgentPrice" type="text" id="dtMonthAgentPrice"  size="5" >

<!-- 播出信息 -->			
startDate:<input type="text" id = "broArrangeStartDate" name="broArrangeStartDate"/>
endDate:<input type="text" id = "broArrangeEndDate" name="broArrangeEndDate"/>
sumMonthBasePrice <input type="text" id = "sumMonthBasePrice" name="sumMonthBasePrice"/>
sumMonthRealPrice<input type="text" id = "sumMonthRealPrice" name="sumMonthRealPrice"/>
<input type="button" value="new orderDetail" id="addNewOrderDayInfo"> 
<input type="button" value="save orderDetail" id="saveOrderDayInfo"> 
</div>

	</td>
  </tr>
</table>
</fieldset>