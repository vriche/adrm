<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/broArrange.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/prototypeUI/ptotoyeUI.css'/>" / >
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />


<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/prototypeUI/window.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/prototypeUI/utils.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>


<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGridCell.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_math.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/ext/dhtmlXGrid_ssc.js'/>"></script>

<!-- script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_srnd.js'/>"></script -->
<!-- script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/ext/dhtmlxgrid_filter.js'/>"></script -->





<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/popupWindow.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/extutils.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/ContractManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ContractPaymentManager.js'/>"></script>
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
<script type="text/javascript" src="<c:url value='/dwr/interface/AgentInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IndustryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceSortManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CompagesManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/PriceDetailManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/PriceRegularManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CategoryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaAreaCityManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerAddressManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/LinkManManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/BrandManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/contract.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/contractpayment.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderCategory.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/industry.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/specific.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/matter.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/matterType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDetail.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/order.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/priceType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderPublic.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/agentInfo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resourceSort.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/compages.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrierType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/priceDetail.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/priceRegular.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDetailColl.js'/>"></script> 
<script type="text/javascript" src="<c:url value='/scripts/class/price.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/category.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/oaAreaCity.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customerAddress.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/linkMan.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/oaWorkFlowCheckState.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/brand.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/class/dayInfo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDayInfo.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/order/broArrange.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/order/orderService.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/order/broArrangeService.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/ComboBoxTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/MessageBox.js'/>"></script>

<title><fmt:message key="orderDetail.title"/></title>
<content tag="heading"><fmt:message key="orderDetail.heading"/></content>






<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                    <td>
                    
                    
			            <table border="0" cellpadding="0" cellspacing="0" width="100%">
			                  <tr> 
								    <td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_addNewOrder" value='新签订单'  onmouseover="this.className='button mouseover'"  onmouseout="this.className='button'"></td> 
								    <!-- td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_editOrder" value='编辑订单'></td --> 
								    <td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_cancel" value='返回'  onmouseover="this.className='button mouseover'"  onmouseout="this.className='button'"></td> 
								    <td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_display" value='付款'  onmouseover="this.className='button mouseover'"  onmouseout="this.className='button'"></td> 
								    <td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_orderDetail" value='总览'  onmouseover="this.className='button mouseover'"  onmouseout="this.className='button'"></td> 
								    


								    <!-- td width="1px" ><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_view_order" value='预览'  onmouseover="this.className='button mouseover'"  onmouseout="this.className='button'"></td> 
								    <td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_print_order" value='打印'  onmouseover="this.className='button mouseover'"  onmouseout="this.className='button'"></td> 
								    <td width="1px" style="display:none"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_export_order" value='导出'  onmouseover="this.className='button mouseover'"  onmouseout="this.className='button'"></td --> 

			                         <td width="1px" ><div id="printReportDiv" name="printReportDiv"/></td>
			                         
			                         <td width="1px" id="td_Btn_submit"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_submit" value='提交'  onmouseover="this.className='button mouseover'"  onmouseout="this.className='button'"></td> 
								    
			                    <td>  &nbsp; </td>
			                  </tr>
			        
			              </table>	 


	                    
                    </td>
                     <td>&nbsp;</td> 
                     
                    <td align="right">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
					              <tr> 
					                   <td>&nbsp;</td> 

					                  <adrm_order:authorizeTag res="tag_time_out">	 </adrm_order:authorizeTag>  

  									<!--新添广告-->
					 				   <td width="1px"><input type="button"   class="button" id="Btn_addNewAdver1" value='新添'  onmouseover="this.className='button mouseover'"  onmouseout="this.className='button'"></td> 
					 				  <!--新添广告-->
					 				   <td width="1px"><input type="button"   class="button" id="Btn_addNewAdver2" value='快速下单'  onmouseover="this.className='button mouseover'"  onmouseout="this.className='button'"></td> 
					              
					              
					              
					                  <!--复制广告-->
					                   <td width="1px"> <input type="button"   class="button"  id="Btn_addAndPost1"  value='复制广告' > </td> 
					                  <!--复制所有-->
					                  <td width="1px"> <input type="button"   class="button" style="CURSOR: pointer;" id="Btn_addAndPost2"  value='复制所有' > </td> 
					                  <!--换版-->
					                    <td width="1px">  <input type="button"   class="button"   id="Btn_change_matter_brotime" value='批处理' > </td> 
					                  <!--保 存-->
					                  <!-- adrm_order:authorizeTag res="tag_orderDetail_save" --> <!--/adrm_order:authorizeTag -->
									  		 <td width="1px"> <input type="button"   class="button" style="CURSOR: pointer;" id="Btn_save"  value='保存'>  </td> 
									 

					              </tr>
					            </table>                  
                    
                    <td>
                    
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
 

<!-- fieldset style="width: 98%" id="orderForm" -->
 <table width="100%" border="0" >
  <tr>
    <td>
<!-- fieldset style="width: 97%" -->






	<table width="100%" border="0" id="main_info_body">
	  <tr> 
	    <td width="50%">
	    
	    
	    
	    <table width="100%" border="0" cellpadding="0" cellspacing="0">
	        <tr> 
	          <td width="50%"> 
	          
	          
	            <!--baseinso start-->
	            <fieldset id="order_baseInfo_frm">
	            <legend> 基本信息</legend>
	            
	            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" >
	              <tr> 
	                <td width="50%" valign="top"> 
	                
	                	<table width="1%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
	                    <tbody>
	                      <tr> <!-- 订单编号 -->
	                        <td nowrap="nowrap" class="dataLabel"><fmt:message key="orderForm.orderCode"/></td>
	                        <td  width="350px">
	                        
	                        <table  border="0" cellpadding="0" cellspacing="0"><tr>
	                        <td>
	                         <input name="orderCode" type="text" id="orderCode" style="width:80px;">
	                        </td>
	                        <td align="center" valign="middle"><select id="order_year" style="CURSOR: pointer;width:60px;font-size: 11px;" /></td>
							</tr>
							</table>

								
	                        </td>
	                      </tr>
	                      <tr> <!-- 关联编号 -->
	                        <td nowrap="nowrap" class="dataLabel">
	                        <fmt:message key="orderForm.relationCode"/> 
	                        </td>
	                        <td><input name="relationCode" type="text" id="relationCode"  style="width:140px;">
	                        </td>
						    <tr> <!--订单类别-->
						      <td nowrap="nowrap"  class="dataLabel"><fmt:message key="orderForm.categoryId"/></td>
						      <td><select name="categoryId" id="categoryId"  style="width:145px;"/></td>
						    </tr>
	                      <tr> <!-- 应付金额 -->
	                        <td nowrap="nowrap"  class="dataLabel"><fmt:message key="orderForm.moneySum"/></td>
	                        <td><input name="orderPublic.moneyRealpay" type="text" id="orderPublic.moneyRealpay" style="width:140px;"></td>
	                      </tr>
	                  </table>
	                  </td>
	                  
	                  
	                <td valign="top"> 
	                 
	                 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
	                    <tbody>
	                      <tr> <!-- 合同编号 -->
	                        <td nowrap="nowrap" class="dataLabel"><fmt:message key="orderForm.contractId"/></td>
	                        <td  width="350px"> 
							<div style="position:relative;overflow:visible;">
								<input name="contract.code" id="contract.code" type=text autocomplete=off style="width:140px;CURSOR: pointer;" >
								<div id="theDiv" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;visibility:hidden;width:390px;border:solid green 2px;background-color:white;z-index:1"></div>
							</div>
	                        </td>
	                      </tr>
						    <tr> <!--客户名称-->
						      <td nowrap="nowrap" class="requiredInput"><fmt:message key="orderForm.customerName"/></td>
						      <td><div id="extCustomerDiv" name="extCustomerDiv"></td>
						    </tr>
	                      </tr>
						    <tr> <!--业务员--> 
						      <td nowrap="nowrap"  class="dataLabel"> <fmt:message key="orderForm.userId"/></td>
						      <td><div id="extUserIdDiv" name="extUserIdDiv"/></td>
						    </tr>
						    
	                      <tr> <!-- 订单备注 -->
	                        <td nowrap="nowrap" class="dataLabel"><fmt:message key="orderForm.orderMeno"/></td>
	                        <td >
	                        <div style="position:relative;overflow:visible">
	                        <input name="orderMeno" type="text" id="orderMeno" style="width:140px;" > 
	                        <div id="theDivOrderMeno" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1">	
	                             <table>
	                             <tr><td>
	                             <textarea id="textareaOrderMeno" rows="9"  style="font-size:12px"></textarea>
	                             </td></tr>
	                             
								 <tr id="leadmemo_lable"><td>领导批注</td></tr>	   
	                             
								 <tr id="leadmemo_const"><td align="middle">
	                             	<textarea id="textareaOrderPublishMemo" rows="5"  style="font-size:12px"></textarea>
	                             </td></tr>	                             
	                             
	                             <tr><td align="midle">
	                       		  <input type="button"    class="button" style="CURSOR: pointer;" id="Btn_save_order_memo" value='保存'">
	                       		  <input type="button"    class="button" style="CURSOR: pointer;" id="Btn_close_order_memo" value='关闭'">
	                             </td></tr>	

	                       		 </table>
	                         </div>

	                        </td>
	                      </tr>	 						    
						    
						  <!-- 已分配金额 -->

	                      

	                      
	                    </tbody>
	                  </table>
	                  </td>
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
	            <fieldset id="order_detail_frm">
	            <legend>订单明细</legend>

	            
	            <table width="100%" border="0" cellpadding="0" cellspacing="0">
	              <tr> 
	                <td width="50%" valign="top" align="left">
	                
	                
	                <table width="1%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
	                    <tbody>

						 <tr>
						      <td nowrap="nowrap"  class="dataLabel">订单子类</td>
						      <td width="0px" align="left" valign="top">
						        <table cellspacing=0 cellpadding=0 border=0>
							        <tr>
							        	<td width="0px"><div id="extorderCategoryIdDiv"/></td>
							        	<td width="0px"><div id="extBrandIdDiv" name="extBrandIdDiv"/></td>
							        </tr>
						        </table>
						      </td>
						     
						 </tr>					    
						    

						    
						    					    
						  <!-- 磁带编码 --> 
	                      <tr>
	                        <td nowrap="nowrap" id="tapCode" class="requiredInput"><fmt:message key="orderDetailForm.matterId"/></td>
	                        <td>
									<table border="0" cellspacing="0" cellpadding="0">
	                                  <tr> 
	                                    <td>
											<div style="position:relative;overflow:visible">
												<input name="matter.tapeCode" id="matter.tapeCode" type=text autocomplete=off style="width:125px;">
												<div id="theDivTapeCode" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:400px;height:300px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
											</div>
	                                    </td>
	                                    
	                                    
	                                    
	                                    <td><img src="<c:url value='/image/search.gif'/>" id="search_adver_cont" width="16" height="16" style="CURSOR: pointer;"></td> 
	                                  </tr>
	                                </table>								
								
							 </td>	
	                      </tr>
	                      
	                      <!-- 广告名称 -->
	                      <tr>  
	                        <td nowrap="nowrap" class="requiredInput"><fmt:message key="orderDetailForm.matterName"/></td>
	                        <td > 
								<div style="position:relative;overflow:visible">
									<input name="matter.name" id="matter.name" type=text autocomplete=off style="width:140px;">
									<div id="theDivMatterName" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:400px;height:300px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
								</div>	                        						  
	                        </td>
	                      </tr>
	                      
	                      <!-- 广告版本 -->
	                      <tr>  
	                        <td nowrap="nowrap" class="dataLabel"><fmt:message key="orderDetailForm.matterEdit"/></td>
	                        <td>
								<div style="position:relative;overflow:visible">
									<input name="matter.edit" id="matter.edit" type=text autocomplete=off style="width:140px;">
									<div id="theDivMatterEdit" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:400px;height:300px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
								</div>		                         
	                        </td>
	                      </tr>
	                      
	                      <!--广告长度-->
						    <tr> 
						      <td nowrap="nowrap" class="requiredInput"><fmt:message key="orderDetailForm.matterLength"/></td>
						      <td> 
								<div style="position:relative;overflow:visible">
									<input name="matterLength" id="matterLength" type=text autocomplete=off style="width:140px;">
									<div id="theDivmatterLength" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:136px;height:300px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
								</div>	                        						  
	                        </td>
						    </tr>
						    
						    <!--行业--> 
						    <tr> 
						      <td nowrap="nowrap" class="requiredInput">行业类别</td>
						      <td><div id="initIndustryComboBoxTree"></td>
						    </tr>  
						    
						  <!-- 价格类别 -->
	                      <tr> 
	                        <td class="dataLabel" nowrap="nowrap"> <fmt:message key="orderDetailForm.resourcePriceType"/></td> 
	                        <td><select name="resourcePriceType" id="resourcePriceType" style="width:145px;"/></td> 
	                      </tr>
	                      
	                      <!-- 播出备注 -->
	                      <tr>        
	                        <td class="dataLabel" nowrap="nowrap"><fmt:message key="orderDetailForm.publishMemo"/></td>
	                       <td  align="left"> <table border="0" cellspacing="0" cellpadding="0" id="screen_dtPublishMemo">
	                            <tr>
	                              <td>
	                              
	                              <!-- input type="text" id="moneyBalance" size="7" value="" class="FieldDisable" -->
	                              <!-- input name="dtPublishMemo" type="text" id="dtPublishMemo" style="width:100px;"  maxlength="16" -->
	                             
	                            
										<div style="position:relative;overflow:visible">
											<input name="dtPublishMemo" id="dtPublishMemo" type=text autocomplete=off style="width:100px;">
											<div id="theDivPublishMemo" style="position:absolute;width:300px;  OVERFLOW: auto;left:0px;top:21px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1">

											<table>
											 <tr><td><textarea id="textareaPublishMemo" rows="6"  style="font-size:12px;width:290px;"></textarea></td></tr>
				                             <!-- tr><td align="midle"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_close_publish_memo" value='关闭'"></td></tr -->	
				                       		 </table>										
										</div>	                        						  
			                                         
	                             
	                             
	                              </td>
	                              
	                              
	                              <td><table border="0" cellspacing="0" cellpadding="0">
	                                  <tr> 
	                                     <!-- 串开 -->
	                                    <td align="right">
	                                     <fmt:message key="orderDetailForm.isSpaceAdver"/>
	                                   
	                                    
	                                    </td>
	                                    <td>
	                                    <input type="checkbox" name="isSpaceAdver" id="isSpaceAdver" value="">
	                                    </td>
	                                  </tr>
	                                </table></td>
	                            </tr>
	                          </table>
	                          </td>
	                          
	                          
	                      </tr>
	                    </tbody>
	                  </table>
	                  
	                  
	                  
	                  </td>
	                  
	                <td valign="top">
	                
	                
	                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
	                    <tbody>
	                       
	                       <!--投放方式-->  
						   <tr>
						      <td nowrap="nowrap" class="dataLabel">广告类型</td>
						      <td style="position:relative;">
						        <table cellspacing=0 cellpadding=0 border=0><tr>
						        	<td width="1px">
			     						 
									      <select name="resourceSortId" id="resourceSortId" style="width:80px;CURSOR: pointer;font-size:12px; " />
									   
						        	</td>
						        	<td width="1px">
						        	   <!-- a id="btn_packeg" href="#" class="button">&nbsp;套装&nbsp;</a -->
			                       	 	<select id="btn_packeg" style="CURSOR: pointer;width:65px;font-size: 12px;" >
											<option  style="CURSOR: pointer;font-size: 12px;" value="1">正常</option>
											<option  style="CURSOR: pointer;font-size: 12px;" value="2">套装</option>
										</select>						        	   
						        	</td>
						        </tr></table>	

						      </td>
						     
						    </tr>
						    
						    <!--广告载体-->  	                    
						   <tr id="carrier_area">
						      <td nowrap="nowrap" class="requiredInput"><fmt:message key="orderDetailForm.carrity"/></td>
						      <td> <div style="position:relative;"><span style="margin-left:100px;width:18px;overflow:hidden;">
						      <select name="carrierId" id="carrierId" style="width:145px;margin-left:-100px;CURSOR: pointer;"/>
						      </span></div>
						      </td>
						    </tr>
						  

						   <!--广告载体-->
						   	<tr id="compages_area_name" style="display:none"> 
						      <td nowrap="nowrap" class="requiredInput"><fmt:message key="orderDetailForm.carrity"/></td>
						      <td> 
						      	<div style="position:relative;overflow:visible" id="compages_diawin">
						      		<input name="carrierName" id="carrierName" type="text" autocomplete=off style="width:140px;"/>
						      		<div id='treeGroup'	style="position:absolute;OVERFLOW: auto;left:0px;top:21px;width:300px;height:300px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1";>
						      				<input name="radiobutton" type="radio" id='composRadioId' checked> <fmt:message key="resourceForm.title.compos"/> 
					        				<input name="radiobutton" type="radio" id='basePosRadioId'><fmt:message key="resourceForm.title.basePos"/>
											<input  style="CURSOR: pointer;" type="button" id="btn_treeConfirm" value="&nbsp;<fmt:message key="button.confim"/>&nbsp;"/> 
					        				<input  style="CURSOR: pointer;" type="button" id="btn_treeCancel" value="&nbsp;<fmt:message key="button.cancel"/>&nbsp;"/>
										
											 <div> <div id="carrierTypeTreebox"/></div></div>
											 <div> <div id="compagesTreebox"/></div> </div>  
											  
									 </div>
								</div>
						      </td>
						    </tr>
					
							<!-- 广告位置 -->
		                    <tr id="resourceInfoId_area"> 
		                        <td class="requiredInput" nowrap="nowrap"><fmt:message key="orderDetailForm.posision"/></td> 
		                        <td> 
		                         <div style="position:relative;"><span style="margin-left:100px;width:18px;overflow:hidden;">
		                          <select name="resourceInfoId" id="resourceInfoId" style="width:145px;margin-left:-100px;CURSOR: pointer;"/>
		                        </span></div>
		                        </td>
		                    </tr>

	                      
	                      <!--广告位置-->  
						   <tr id="compages_area_pos" style="display:none">
						      <td class="requiredInput" nowrap="nowrap"><fmt:message key="orderDetailForm.posision"/></td>
						      <td> 
						      	<div style="position:relative;overflow:visible">
						      		<input name="compages.pos" id="compages.pos" type="text" autocomplete=off style="width:140px;"/>
						      		 <div id="carrierTypeTreebox" style="position:absolute;OVERFLOW: auto;left:0px;top:21px;width:300px;height:300px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"; />
								</div>
						      </td>
						    </tr>                      
							<!--指定-->
						    <!-- tr> 
						      <td nowrap="nowrap" class="dataLabel"><fmt:message key="orderDetailForm.appPosition"/></td>
						      <td><select name="resourceSpecificId" id="resourceSpecificId" style="width:145px;CURSOR: pointer;"/></td>
						    </tr -->
						    

			                <tr> 
	                        	<td class="dataLabel" nowrap="nowrap">指定位置</td>
		                        <td align="left"  width="1px">
		                          <table border="0" cellspacing="0" cellpadding="0">
		                            <tr> 
		                              <td width="1px"><select name="resourceSpecificId" id="resourceSpecificId" style="width:45px;CURSOR: pointer;"/></td>
		                              <td align="left"  width="1px">
		                                  <table border="0" cellspacing="0" cellpadding="0">
		                                  <tr> 
		                                    <td width="1px"><input  type="text" value="次数"  width="46px" class="myLable"></td>
		                                    <td width="1px"><input name="broSumTime" type="text" id="broSumTime" tabindex="10"  style="width:45px;"  readonly="true"></td>
		                                    <td>&nbsp;</td>
		                                  </tr>
		                                 </table>
		                                </td>
		                            </tr>
		                          </table>
		                         </td>
	                      </tr>					    
						    

						    

						    <tr> 
	                        <td class="dataLabel" nowrap="nowrap">刊例价</td>
	                        <td align="left"  width="300px">
	                        
	                        	<table border="0" cellspacing="0" cellpadding="0" id="screen_execPrice">
	                            <tr> 
	                              <td  width="1px">
	                               <input name="sysPrice" type="text" id="sysPrice" tabindex="10" style="width:45px;" maxlength="40"> 
	                               </td>
	                              <td align="left"  width="1px" >
		                                 <table border="0" cellspacing="0" cellpadding="0">
		                                  <tr> 
		                                    <td><input  type="text" value="销售价"  width="46px" class="myLable"></td>
		                                    <td  width="1px"><input name="execPrice" type="text" id="execPrice" style="width:45px;"></td>
		                                    <td>&nbsp;</td>
		                                  </tr>
		                                </table>
	                               </td>
	                               <td>&nbsp;</td> 
	                            </tr>
	                          </table>
	                       
	                       </td>
	                      </tr>
	                      <tr> 
	                        <td class="dataLabel" nowrap="nowrap"> 
	                          <!-- 加收 -->
	                          <fmt:message key="orderDetailForm.appRate"/>%</td>
	                        <td align="left"  width="1px">
	                          <table border="0" cellspacing="0" cellpadding="0" id="screen_appRate">
	                            <tr> 
	                              <td width="1px"> 
	                                <!-- 加收 -->
	                                <input name="dtAppRate" type="text" id="appRate" tabindex="10"   maxlength="40" style="width:45px;"> 
	                              </td>
	                              <td align="left"  width="1px"><table border="0" cellspacing="0" cellpadding="0">
	                                  <tr> 
	                                    <!-- 折扣 -->
	                                    <td width="1px"><input  type="text" value="折扣%"  width="46px" class="myLable"></td>
	                                    <td width="1px"><input name="dtFavourRate" type="text" id="favourRate" tabindex="10"  style="width:45px;"></td>
	                                    <td>&nbsp;</td>
	                                  </tr>
	                                 </table>
	                                </td>
	                            </tr>
	                          </table></td>
	                      </tr>
	                      <tr> 
	                     	
	                        <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 明细刊例总计 -->
                                <fmt:message key="orderDetailForm.moneyBase"/>
                                		
	                        </td>
	                         <td  width="1px">
	                       		<table border="0" cellspacing="0" cellpadding="0" id="screen_appRate">
	                            <tr>
	                              <td  width="1px"><input name="dtMoneyBase" type="text" id="moneyBase" tabindex="10" maxlength="40" style="width:45px;" ></td>
							
							<!-- 补差 -->

	                              <td align="left"  width="1px">
	                                 <table border="0" cellspacing="0" cellpadding="0">
	                                  <tr> 
	                                    <!-- 制作费 -->
	                                  
	                                     <td width="1px"><input  type="text" value="补差"  width="46px" class="myLable"></td>
	                                     <td width="1px"><input name="moneyBalance" type="text" id="moneyBalance" style="width:45px;" ></td>
	                                     <td>&nbsp;</td>
	                                  </tr>
	                                </table></td> 		                        
		                        
		                        
		                        
		                        
		                        
		                        
		                        
		                        
		                      </tr>
	                      </table></td>
	                      </tr>
	                      
	                      
	                       <!-- 明细应收总计 -->
	                      <tr>
	                        <td class="dataLabel" nowrap="nowrap">
	                             <fmt:message key="orderDetailForm.moneyRealpay"/>
	                        </td>
	                        <td>
	                        	<input name="dtMoneyRealpay" type="text" id="moneyRealpay" tabindex="10"  maxlength="40"  style="width:140px;">
	                        </td>           
	                      </tr>
	                      
	                      
	                      
	                      
	                      
		                      <!-- tr> 
	                        	<td class="dataLabel" nowrap="nowrap"> 
	                           <fmt:message key="orderDetailForm.moneyRealpay"/>
	                           </td>
	                        <td align="left"  width="1px">
	                          <table border="0" cellspacing="0" cellpadding="0" id="screen_appRate">
	                            <tr> 
	                              <td width="1px"> 
	                                <input name="dtMoneyRealpay" type="text" id="moneyRealpay" tabindex="10"  maxlength="40"  style="width:45px;">
	                              </td>
	                              <td align="left"  width="1px"><table border="0" cellspacing="0" cellpadding="0">
	                                  <tr> 
	                                  
	                                    <td width="1px"><input  type="text" value="次数"  width="46px" class="myLable"></td>
	                                    <td width="1px"><input name="dtBroTimes" type="text" id="broTimes" tabindex="10"  style="width:45px;" readOnly=1></td>
	                                    <td>&nbsp;</td>
	                                  </tr>
	                                 </table>
	                                </td>
	                            </tr>
	                          </table></td>
	                      </tr -->
	                      

	                      
	                    </tbody>
	                  </table></td>
	              </tr>
	            </table>
	            </fieldset>
	            <!--baseinso end-->
	          </td>
	        </tr>
	      </table></td>
	      
		    <td  valign="top" align="left">
		    
				<!--baseinso start-->
			    <!-- fieldset  id="resOrderDetail" -->
			    
			    <!--legend--><!--订单明细--><!-- fmt:message key="orderForm.legend2"/></legend-->
			    
			    
					<table width="100%" border="0" >
					  <tr>
					    <td width="0px">
					    	<IMG src="image/s.gif"  width=0 id="screen_orderDetail">
					    </td>
					    
					    <td valign="top">    
					    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
					        <tr> 
					          <td align="left">
					          
					          
					          </td>
					        </tr>
				        
				        <tr> 
				          <td ><IMG src="image/s.gif"  width=1 height=5></td>
				        </tr>
				        
				        <!-- tr> 
				          <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
				        </tr -->
				        
				        <tr> 

				        <td align="left">
				              <div id="div_gridbox_detail" style="background-color:white;height:270px">
				             	<div id="gridbox" width="100%" height="100%" style="background-color:white;"></div>
				             </div>
				        </td>
					   </tr>
					   
				        <tr> 
				          <td align="left">

									<table id="pageInfo_orderDetail_table" width="100%" border="0" cellspacing="0" cellpadding="0">
									    
									            <tr><td colspan="12"><IMG src="image/s.gif"  width="100%" height="5px"> </td></tr>
									            
							  				   
						                        <tr>
						                           
						                          <td width="1px"><input  type="text" value="次数:"  class="myLable5" size="3"></td> 
						                          <td width="1px"><input  type="text"  align="left" id="orderPublic.times" value=""  class="myLable6" size="3"></td>
		    
		    																			<td width="1px"><input  type="text" value="占用:"  class="myLable5" size="3"></td> 
						                          <td width="1px"><input  type="text"  align="left" id="orderPublic.usedtimes" value=""  class="myLable6" size="4"></td>				                          
						                          
						                            
						                          <td width="1px"><input  type="text" value="修改人:"  class="myLable5" size="5"></td>    
						                          <td width="1px"><input  type="text" align="left"  id="orderDetail_mod_by" value=""  class="myLable6" size="5"></td>
						                          
						                          <td width="1px"><input  type="text" value="修改:"  class="myLable5" size="3"></td>    
						                          <td width="1px"><input  type="text"  align="left" id="orderDetail_mod_date" value=""  class="myLable6" size="10"></td>
						                          
						                          <td width="1px"><input  type="text"  value="状态:"  class="myLable5" size="3"></td>   
						                    
						                          <td width="1px"><input  type="text"  align="left" id="orderDetail_mod_states" value=""  class="myLable6" size="5"></td>
						                          
						                          <td width="1px"><input  type="text" id="order_check_history1" value="审核历史"  class="myLablehref" size="6"></td>  
						                          
						                          <td>&nbsp;</td>

						                     	</tr>
						                     	
						                     	
						                     	
								  </table>
					          </div>
				            
	            
				        </td>
					   </tr>					   
					   
					   
					   
					</table>
		  		</td>
			</tr>
		</table>
		<!-- /fieldset -->
		</td>
	</tr>
	</table>	
<!-- /fieldset -->
	</td>
  </tr>
  <tr>
    <td>

	
<table width="100%" border="3" cellspacing="1" cellpadding="0" id="orderDayInfo_Array">
        <tr> 
          <td>
          
          
          <table cellspacing=0 cellpadding=0 width="100%" border=0>
              <tbody>
                <tr> 

                  <td width="1px" style="display:none">                     
                     <select name="selectMonth" id="selectMonth"/> 
                  </td> 
                  
                  
                  <td  width="1px">  
                    <!--自动配置-->
                    <div style="position:relative;overflow:visible">
                  
                   <input type="button"    class="button"   id="autoBroArrange" value='配置'>
                    
                    <div id="broArrangeDiv" style="position:absolute;OVERFLOW: auto;left:0px;top:21px;width:380px;height:130px;visibility:hidden;border:solid green 2px;background-color:white;z-index:0";/> 
				
							<table width="100%" border="0">
						  <tr><td><table><tr> 
						    <td width="40%"><fmt:message key="orderForm.publishStartDate"/><input type="text" name="textfield" id="beginDate" size="10"></td>
						    <td width="40%"><fmt:message key="orderForm.publishEndDate"/><input type="text" name="textfield2" id="overDate" size="10"></td>
						    
						    <td><input type="button" name="Submit" id="confim" value='<fmt:message key="button.confim"/>'></td>
						   <td><input type="button" name="broDown" id="broDown" value='<fmt:message key="button.cancel"/>'></td>
						    </tr></table></td>
						  </tr>
						  <tr><td>
						  
						  <table><tr><td id = "selectMode">
						  	<fmt:message key="orderForm.broarrangeMode"/> 
						  	<input type="radio" name="radiobutton" id="radiobutton_year" value="0">
						    <label style="cursor: pointer;width:20px;" for="radiobutton_year">全年</label>
						    <input type="radio" name="radiobutton" id="radiobutton_month" value="1">
						    <label style="cursor: pointer;width:20px;" for="radiobutton_month"><fmt:message key="contractTargetMonthForm.monthDate"/></label>
						    <input type="radio" name="radiobutton" id="radiobutton_day" value="2">
						    <label style="cursor: pointer;width:20px;" for="radiobutton_day"><fmt:message key="broArrange.day"/></label>
						    <input type="radio" name="radiobutton" id="radiobutton_week" value="3">
						    <label style="cursor: pointer;width:20px;" for="radiobutton_week"><fmt:message key="broArrange.week"/></label>
						    <input type="radio" name="radiobutton" id="radiobutton_evenyDay" value="4">
						    <label style="cursor: pointer;width:20px;" for="radiobutton_evenyDay"><fmt:message key="broArrange.evenyDay"/></label>
						   
						    <select id="times">
						    <% for(int i= 1; i< 10;i++){ %>
						   		 <option value="<%=i%>"><%=i%></option>
					            <%}%>
						    </select>
			
					                
						      <fmt:message key="contractPaymentForm.payNumber"/>
						      </td>   
						      </tr></table>
						      
						      </td>
						  </tr>
						 <tr id="monthSelect"> <td><table><tr>
						    <td><input type="checkbox" name="checkbox" id="monthValue1" value="1" onClick="changeAutoArrangeStartAndEnd()">
						    	<label style="cursor: pointer;width:20px;" for="monthValue1"><fmt:message key="business.month.jan"/></label>
						     </td>
						    <td><input type="checkbox" name="checkbox" id="monthValue2" value="2" onClick="changeAutoArrangeStartAndEnd()">
						    <label style="cursor: pointer;width:20px;" for="monthValue2"><fmt:message key="business.month.feb"/></label>
						      </td>
						   
						    <td><input type="checkbox" name="checkbox" id="monthValue3" value="3" onClick="changeAutoArrangeStartAndEnd()">
						    <label style="cursor: pointer;width:20px;" for="monthValue3"><fmt:message key="business.month.mar"/></label>
						      </td>
						    <td><input type="checkbox" name="checkbox" id="monthValue4" value="4" onClick="changeAutoArrangeStartAndEnd()">
						    <label style="cursor: pointer;width:20px;" for="monthValue4"><fmt:message key="business.month.apr"/></label>
						   </td>
						     <td><input type="checkbox" name="checkbox" id="monthValue5" value="5" onClick="changeAutoArrangeStartAndEnd()">
						     <label style="cursor: pointer;width:20px;" for="monthValue5"><fmt:message key="business.month.may"/></label>
						     </td>
						    <td><input type="checkbox" name="checkbox" id="monthValue6" value="6" onClick="changeAutoArrangeStartAndEnd()">
						    <label style="cursor: pointer;width:20px;" for="monthValue6"><fmt:message key="business.month.jun"/></label>
						      </td>
						   </tr>
						   <tr>
						    <td><input type="checkbox" name="checkbox" id="monthValue7" value="7" onClick="changeAutoArrangeStartAndEnd()">
						    <label style="cursor: pointer;width:20px;" for="monthValue7"><fmt:message key="business.month.jul"/></label>
						      </td>
						    <td><input type="checkbox" name="checkbox" id="monthValue8" value="8" onClick="changeAutoArrangeStartAndEnd()">
						    <label style="cursor: pointer;width:20px;" for="monthValue8"><fmt:message key="business.month.aug"/></label>
						   </td>
						     <td><input type="checkbox" name="checkbox" id="monthValue9" value="9" onClick="changeAutoArrangeStartAndEnd()">
						     <label style="cursor: pointer;width:20px;" for="monthValue9"><fmt:message key="business.month.sep"/></label>
						     </td>
						    <td><input type="checkbox" name="checkbox" id="monthValue10" value="10" onClick="changeAutoArrangeStartAndEnd()">
						    <label style="cursor: pointer;width:20px;" for="monthValue10"><fmt:message key="business.month.oct"/></label>
						      </td>
						   
						    <td><input type="checkbox" name="checkbox" id="monthValue11" value="11" onClick="changeAutoArrangeStartAndEnd()">
						     <label style="cursor: pointer;width:20px;" for="monthValue11"><fmt:message key="business.month.nov"/></label>
						      </td>
						    <td><input type="checkbox" name="checkbox" id="monthValue12" value="12" onClick="changeAutoArrangeStartAndEnd()">
						     <label style="cursor: pointer;width:20px;" for="monthValue12"><fmt:message key="business.month.dec"/></label>
						   </td>
						 	</tr></table></td>
						  </tr>
						  <tr id="daySelect"> 
						    <td colspan="6">
						      <input type="radio" name="checkbox" id="checkbox_111" value="1">
						      <label style="cursor: pointer;width:20px;" for="checkbox_111"><fmt:message key="broArrange.oneday"/></label>
						      <input type="radio" name="checkbox" id="checkbox_222" value="2">
						      <label style="cursor: pointer;width:20px;" for="checkbox_222"><fmt:message key="broArrange.twoday"/></label>
						      
						  </tr>
						  <tr id="weekSelect"> <td><table><tr>
						    <td>
						      <input type="checkbox" name="checkbox_week" id="week_chose_1" value="1">
						      <label style="cursor: pointer;width:20px;" for="week_chose_1"><fmt:message key="workspanForm.monLength"/></label>
						      <input type="checkbox" name="checkbox_week" id="week_chose_2" value="2">
						      <label style="cursor: pointer;width:20px;" for="week_chose_2"><fmt:message key="workspanForm.tueLength"/></label>
						      <input type="checkbox" name="checkbox_week" id="week_chose_3" value="3">
						      <label style="cursor: pointer;width:20px;" for="week_chose_3"><fmt:message key="workspanForm.wenLength"/></label>
						      <input type="checkbox" name="checkbox_week" id="week_chose_4" value="4">
						      <label style="cursor: pointer;width:20px;" for="week_chose_4"><fmt:message key="workspanForm.thiLength"/></label>
						      </td>
						      </tr>
						      <tr>
						      <td>
						      <input type="checkbox" name="checkbox_week" id="week_chose_5" value="5">
						      <label style="cursor: pointer;width:20px;" for="week_chose_5"><fmt:message key="workspanForm.friLength"/></label>
						      <input type="checkbox" name="checkbox_week" id="week_chose_6" value="6">
						      <label style="cursor: pointer;width:20px;" for="week_chose_6"><fmt:message key="workspanForm.satLength"/></label>
						      <input type="checkbox" name="checkbox_week" id="week_chose_0" value="0">
						      <label style="cursor: pointer;width:20px;" for="week_chose_0"><fmt:message key="workspanForm.sunLength"/></label>
						      </td>
						      </tr></table></td>
						  </tr>
						  <!--tr> 
						    <td colspan="6">
							 <div align="center">
						        <input type="button" name="Submit" value='<fmt:message key="button.confim"/>'>
						        <input type="submit" name="button" value='<fmt:message key="button.cancel"/>'>
						      </div>
							 </td>
						  </tr-->
						</table>					
									 
				</div>
			
			 </td> 
		
			
			 
                     <td  width="1px">   <input type="button"    class="button" id="cleanBroArrange" value='清除排期'></td>
                     <td  width="1px">  <input type="button"    class="button" id="resumeBroArrange" value='恢复排期'></td>
                     <td  width="1px"> <input type="button"    class="button" id="addBroArrange" value='增加月份'></td>
					 <td  width="1px"> <input type="button"    class="button" id="isDisplayLeavTimes" value='显示星期' alt="111"></td>
                    
                   
                    <td  width="1px"><input  type="text" value="标准"  width="30px" class="myLable2"></td> <td  width="1px"><input name="dayTotalTime" id="dayTotalTime" size="3"> </td>
                    <td  width="1px"><input  type="text" value="占用"  width="30px" class="myLable2">  </td> <td  width="1px"><input name="dayUsedTime"   id="dayUsedTime" size="2" type="text"  readonly="true"> </td>
                  	<td  width="1px"><input  type="text" value="剩余"  width="30px" class="myLable2"> </td> <td  width="1px"><input name="dayLeaveTime"   id="dayLeaveTime" size="2"  type="text"  readonly="true"> </td>
                    <!-- td  width="1px"><input  type="text" value="次数"  width="30px" class="myLable2"> </td> <td  width="1px"><input type="text"  id="broSumTime" name="broSumTime" size="2" readonly="true"/> </td -->
                    <td  width="1px"><input  type="text" value="星期"  width="30px" class="myLable2"> </td> <td  width="1px"><input type="text"  id="broWeekTime" name="broWeekTime" size="1" readonly="true"/> </td>

                  <td>&nbsp;</td>
                    
                  <td align="right">
						<TABLE cellSpacing=0 cellPadding=0  border=0 class="arrange">
						  <TBODY>
						  <TR> 
						    
						    <TD class="forcetime" align=middle width="1px"><input  type="text" value="过期"  width="30px" class="myLable2"></TD>
						    <TD class="weekend"   align=middle width="1px"><input  type="text" value="周末"  width="30px" class="myLable2"></TD><!--周末-->
						    <TD class="notday"    align=middle width="1px"><input  type="text" value="无效"  width="30px" class="myLable3"></TD><!--无效-->
						    <TD class="specific"  align=middle width="1px"><input  type="text" value="指定"  width="30px" class="myLable3"></TD><!--指定-->
						    <TD class="fulltime"  align=middle width="1px"><input  type="text" value="占满"  width="30px" class="myLable3"></TD><!--占满-->
						    <TD class="overtime"  align=middle width="1px"><input  type="text" value="超时"  width="30px" class="myLable3"></TD><!--超时-->
						   </TR>
						   </TBODY>
						</TABLE>
                    </td>
                  
                </tr>
                
                <tr> 
                  <td colspan=12><img height=1 src="image/s.gif" width=1></td>
                </tr>
              </tbody>
            </table>	
	
	
	</td>
  </tr>
  <tr>
    <td align="top" valign="middle">



				<table width="100%" border="1" id="orderDayInfoTable" cellpadding="0" cellspacing="0"  class=arrange>
			
		              <tr> 
		                <!-- 播出月份 -->
		                <th nowrap width="5%" class="gridHead" ><fmt:message key="orderDayInfoForm.broMonth"/></th>
		                <!-- 播出日期 -->
		                <% for(int i= 1; i< 32;i++){ %>
		                   <th nowrap width="22px"  class="gridHead" frame=below><center><%=i%></th>
		                <%}%>
		                <!-- 总次数 -->
		                <th nowrap width="5%" class="gridHead" ><fmt:message key="orderDayInfoForm.monthTimes"/></th>
		                <!-- 刊例价 -->
		                <th nowrap width="5%"  class="gridHead"><fmt:message key="orderDetailForm.sysPrice"/></th>
		                <!-- 销售价格 -->
		                <th nowrap width="5%" class="gridHead"><fmt:message key="orderDetailForm.execPrice"/></th>                
		              </tr>

		              <TBODY id="orderDayInfoTbody" name="orderDayInfoTbody" class="arrange"/>
	   
		            </table>

	   
	  	
	
	</td>

  </tr>
</table>


	</td>
  </tr>
</table>
<!-- /fieldset -->

     
            <!--   table end -->

			   	 <div id="gridbox1" width="100%" height="100%" style="background-color:white;"></div>		

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
      </table>

    
      </td>
  </tr>
</table>







<div style="display:none;">


<!-- div id="pos_flt_box"><select  style="width:130%;margin-left:0px;CURSOR: pointer;" onclick="(arguments[0]||window.event).cancelBubble=true;" ></select></div -->
<div id="pos_flt_box"><input type="text" style="width:130%;margin-left:0px;CURSOR: pointer;height:16px;"  value="" onclick="(arguments[0]||window.event).cancelBubble=true;"></div>

<div id="name_flt_box"><select  style="width:130%;margin-left:0px;CURSOR: pointer;height:20px;"  onclick="(arguments[0]||window.event).cancelBubble=true;" ></select></div>

<!-- div id="edit_flt_box"><select  style="width:130%;margin-left:0px;CURSOR: pointer;height:13px;" onclick="(arguments[0]||window.event).cancelBubble=true;" ></select></div -->
<div id="edit_flt_box"><input type="text" style="width:130%;margin-left:0px;CURSOR: pointer;height:16px;"  value="" onclick="(arguments[0]||window.event).cancelBubble=true;"></div>

<div id="len_flt_box"><select  style="width:180%;margin-left:0px;CURSOR: pointer;height:20px;" onclick="(arguments[0]||window.event).cancelBubble=true;" ></select></div>

<div id="spec_flt_box"><select  style="width:160%;margin-left:0px;CURSOR: pointer;height:20px;" onclick="(arguments[0]||window.event).cancelBubble=true;" ></select></div>
<div id="satrt_flt_box"><select  style="width:160%;margin-left:0px;CURSOR: pointer;height:20px;" onclick="(arguments[0]||window.event).cancelBubble=true;" ></select></div>
<div id="end_flt_box"><select  style="width:160%;margin-left:0px;CURSOR: pointer;height:20px;" onclick="(arguments[0]||window.event).cancelBubble=true;" ></select></div>
<div id="time_flt_box"><select  style="width:180%;margin-left:0px;CURSOR: pointer;height:20px;" onclick="(arguments[0]||window.event).cancelBubble=true;" ></select></div>


<div id="grid2_flt_box0"><select  style="width:160%;margin-left:0px;CURSOR: pointer;height:20px;" onclick="(arguments[0]||window.event).cancelBubble=true;" ></select></div>
<div id="grid2_flt_box1"><select  style="width:160%;margin-left:0px;CURSOR: pointer;height:20px;" onclick="(arguments[0]||window.event).cancelBubble=true;" ></select></div>
<div id="grid2_flt_box2"><select  style="width:160%;margin-left:0px;CURSOR: pointer;height:20px;" onclick="(arguments[0]||window.event).cancelBubble=true;" ></select></div>
<div id="grid2_flt_box3"><select  style="width:160%;margin-left:0px;CURSOR: pointer;height:20px;" onclick="(arguments[0]||window.event).cancelBubble=true;" ></select></div>
<div id="grid2_flt_box4"><select  style="width:160%;margin-left:0px;CURSOR: pointer;height:20px;" onclick="(arguments[0]||window.event).cancelBubble=true;" ></select></div>
<div id="grid2_flt_box5"><select  style="width:160%;margin-left:0px;CURSOR: pointer;height:20px;" onclick="(arguments[0]||window.event).cancelBubble=true;" ></select></div>
<div id="grid2_flt_box6"><select  style="width:160%;margin-left:0px;CURSOR: pointer;height:20px;" onclick="(arguments[0]||window.event).cancelBubble=true;" ></select></div>
<div id="grid2_flt_box7"><select  style="width:160%;margin-left:0px;CURSOR: pointer;height:20px;" onclick="(arguments[0]||window.event).cancelBubble=true;" ></select></div>
<div id="grid2_flt_box8"><select  style="width:200%;margin-left:0px;CURSOR: pointer;height:20px;" onclick="(arguments[0]||window.event).cancelBubble=true;" ></select></div>
<div id="grid2_flt_box9"><select  style="width:200%;margin-left:0px;CURSOR: pointer;height:20px;" onclick="(arguments[0]||window.event).cancelBubble=true;" ></select></div>
<div id="grid2_flt_box10"><select  style="width:200%;margin-left:0px;CURSOR: pointer;height:20px;" onclick="(arguments[0]||window.event).cancelBubble=true;" ></select></div>
<div id="grid2_flt_box11"><select  style="width:200%;margin-left:0px;CURSOR: pointer;height:20px;" onclick="(arguments[0]||window.event).cancelBubble=true;" ></select></div>


<form name="ReportForm" id="ReportForm">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="orderId" id="orderId" value="">
	<input type="hidden" name="copys" id="copys" value="">
	<input type="hidden" name="printOrgid" id="printOrgid" value="">
</form>


<!-- 定单信息 -->
order.contractId   <input type="text" id="order.contractId"> <br>
order.contractCode <input type="text" id="order.contractCode"> <br>
dt_orderId         <!-- input type="text" id="dt_orderId"> <br -->
dt_orderDetailId   <!-- input type="text" id="dt_orderDetailId"> <br -->
orderPublic.moneyIn<input name="orderPublic.moneyIn" type="text" id="orderPublic.moneyIn"><br> <!-- 已分配金额 -->
orderStartDate     <input  id="orderPublic.publishStartDate"  type="text"> <br>
orderEndDate	   <input  id="orderPublic.publishEndDate"  type="text"> <br>
orderMoneyBase:    <input  id="orderPublic.moneyBase"  type="text"> <br>
isCkecked	   <input  id="isCkecked"  type="text"> <br>
isManualPrice	   <input id="isManualPrice" type="checkbox"> 
matterType	   <input  id="matterType"  type="text"> <br>



PriceBaseLine:    <input  id="dtPriceBaseLine" type="text">
NormalAgentPrice: <input type="text" id="dtNormalAgentPrice">
MonthAgentPrice:  <input  type="text" id="dtMonthAgentPrice">


carrierId:<input name="carrierId" id="carrierId" type="text"/>

length:<input type="text" id="length"> <br>
dt_matter.id       <input type="text" id="dt_matter.id"> <br>

<!-- 播出信息 -->			
startDate:<input type="text" id = "broArrangeStartDate" name="broArrangeStartDate"/>
endDate:<input type="text" id = "broArrangeEndDate" name="broArrangeEndDate"/>
sumMonthBasePrice <input type="text" id = "sumMonthBasePrice" name="sumMonthBasePrice"/>
sumMonthRealPrice<input type="text" id = "sumMonthRealPrice" name="sumMonthRealPrice"/>



<!-- 合同付款信息 -->		
paymentId:<input name="paymentId" type="text" id="paymentId">
moneyPay:<input name="contractPayment.moneyPay" type="text" id="contractPayment.moneyPay"/>
moneyIn:<input name="contractPayment.moneyIn" type="text" id="contractPayment.moneyIn"/>
payDate:<input name="contractPayment.payDate" type="text" id="contractPayment.payDate"/>
contractMoneySum:<input name="contractPayment.contractMoneySum" type="text" id="contractPayment.contractMoneySum"/>


<!-- 套装信息 -->	
compagesId:<input name="compagesId" type="text" id="compagesId">
isAutoPrice:<input type="checkbox" id="compages.isAutoPrice" value="">
positions:<input type="text" id="compages.resourceIds" value="">
parentId:<input  type="text" id="parentId">
compagesMoneyRealpay:<input  type="text" id="compagesMoneyRealpay">

priceId:<input name="text" id="packagePriceId" value="">
priceDetailId:<input name="text" id="priceDetailId" value="">
customerId:<input name="customerId" type="text" id="customerId">
customerCategoryId:<input name="customerCategoryId" type="text" id="customerCategoryId">
lowestRate:<input name="lowestRate" type="text" id="lowestRate">

ageRate:<input name="ageRate" type="text" id="ageRate" tabindex="10"  size="5" maxlength="40">
lastCarrierId:<input name="text" id="lastCarrierId" value="">



	<iframe src='about:blank'   scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>


	<table width="100%" border="0" cellpadding="0" cellspacing="0" id="regCustomer_table">
	
 			 <tr> <td colspan="2">&nbsp;</td> </tr>   

           <tr> 
	           <td  colspan="2" id="regCustomerCategoryName_td"> 
		            <!-- fieldset><legend></legend> </fieldset -->
		          		 <div id="regCustomerCategoryName">
	           </td> 
           </tr>
           <tr> 
	           <td heigth="2px" bgcolor="black" colspan="2"></td> 
           </tr>
           
      		 <tr> <td colspan="2">&nbsp;</td> </tr>
      		  
            <tr> 
              <td><div id="regCustomerDiv" name="regCustomerDiv"></td> 
              <td><div id="regCustomerAreaDiv" name="regCustomerAreaDiv"></td> 
            </tr>
            
             <tr> <td colspan="2">&nbsp;</td> </tr>
             
             <tr> 
	            
	             <td><div id="regCustomterLinkManOfficeTelDiv" name="regCustomterLinkManOfficeTelDiv"></td> 
	              <td><div id="regCustomterLinkManDiv" name="regCustomterLinkManDiv"></td> 
             </tr>
             
           <tr> <td colspan="2">&nbsp;</td> </tr>
           
            <tr> <td colspan="2"><div id="regCustomterAddressDiv" name="regCustomterAddressDiv"></td> </tr>
           
            <tr> <td colspan="2">&nbsp;</td> </tr>
           
           
           <tr> 
            <td width="100%" colspan="2">
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

    
    
    
