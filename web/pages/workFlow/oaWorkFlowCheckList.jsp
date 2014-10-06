<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="oaApplyInfoList.title"/></title>
<content tag="heading"><fmt:message key="oaApplyInfoList.heading"/></content>
<meta name="menu" content="OaApplyInfoMenu"/>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/prototypeUI/ptotoyeUI.css'/>" / >

<script type="text/javascript" src="<c:url value='/scripts/prototypeUI/window.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/prototypeUI/utils.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/winjs/effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_ext.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/debug.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ContractManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaWorkFlowCheckStateManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaWorkFlowTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaWorkFlowManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaWorkFlowCheckResultManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaWorkFlowCheckManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/popupWindow.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/contract.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/order.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/oaWorkFlowCheckState.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/oaWorkFlow.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/oaWorkFlowType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/oaWorkFlowCheckResult.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/oaWorkFlowCheck.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/workFlow/workFlowCheckService.js'/>"></script>

<html:form action="oaWorkFlowChecks.html" target="actionframe">	

<input type="hidden" name="isEndPoint" id="isEndPoint"/>


<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                    <td width="1px" id="div_orgId"><select name=orgId" id="orgId"/>  </td>
                    
                     <td width="1px"><select id="order_year"  style="CURSOR: pointer;" /></td>
                     

                  
                    <td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="btn_agree" value='<fmt:message key="oaWorkFlowCheckForm.isAgree"/>'></td> 
                    <td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="btn_dissent" value='<fmt:message key="oaWorkFlowCheckForm.dissent"/>'></td> 
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
	           
 
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td bgcolor="#999999"> 
      <div align="center"></div></td>
  </tr>
  <tr> 
    <td><table width="100%" border="0" cellpadding="1" cellspacing="1">
        
    <tr  width="8%"><td  width="8%"></td></tr>
        <tr> 
        
          <td><!--审批类别--> <fmt:message key="oaWorkFlowCheckForm.workFlowTypeId"/></td>
          <td><!--审批类别-->
	           <select name="workFlowTypeId" id="workFlowTypeId"/>
           </td>
        </tr>
        
        
        
        
         <tr> 
          <td><!--流程类别--> <fmt:message key="oaWorkFlowForm.name"/></td>
          <td>
         
	           <select name="workFlowId" id="workFlowId"/>
	            </td>
	            <td>
          	
          	
        </tr>       
        <tr> 
          <td><!-- 审核结果 --><!-- fmt:message key="oaWorkFlowCheckForm.checkStateId"/ --></td>
          <td> </span>
           </td>
        </tr>
       
        
        
        <tr> 
          <td><!--审核用户--> <fmt:message key="oaWorkFlowCheckForm.checkUserId"/></td>
          <td>
	           <select name="checkUserId" id="checkUserId"/>
	           
           </td>
        </tr>
        
        <tr>
        <td></td>
        <td>
        	<table>
        	<tr>
              <td width="1px">
						<div style="position:relative;overflow:visible">
							<input size="12px" name="order_code" id="order_code" type=text autocomplete=off value="==<fmt:message key="orderDetailForm.orderId"/>==">
							<div name="theDivorderCode" id="theDivorderCode" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:250px;height:250px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
						</div>
				    </td>
			  <td align="left" width="1px">
						<div style="position:relative;overflow:visible">
							<input size="12px" name="userName" id="userName" type=text autocomplete=off value="==<fmt:message key="orderForm.userId"/>==">
							<div name="theDivuserName" id="theDivuserName" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:160px;height:250px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
						</div>
				    </td>
				    
				    
				<td>
                     <div><select name="carrierName" id="carrierName"/></div>
                </td>
                
                
 	          <td align="left">
	 						<div style="position:relative;overflow:visible;">
							<input size="12px" name="customer_name" id="customer_name" type=text  value="==<fmt:message key="orderForm.customerName"/>==">
							<div id="theDivCustomerName" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:450px;height:250px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
							</div>		
	          </td>  
	                       
                <td><!--订单编号--> <input  style="CURSOR: pointer;" type="button" name="searchOrder" id="searchOrder" value="&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="publishArrangeDownload.query"/>&nbsp;&nbsp;&nbsp;&nbsp;"/></td>
                      
			</tr>
		 </table>
		 </td>
        </tr>
        <tr>
        <td></td><td>
         <!-- input type="radio" name="OaWorkFlowCheckResultRN" id="OaWorkFlowCheckResultRN" value="" -->
          	 </td>
          	 </tr>
        <tr> <!-- 审批意见 -->
          <td><fmt:message key="oaWorkFlowCheckForm.checkIdea"/></td>
          <td><textarea name="textarea" cols="60%" id="checkIdea" rows="1"></textarea></td>
        </tr>
        
 
      </table></td>
  </tr>
  <tr bgcolor="#CCCCCC">
    <td align="center"> 
       <input type="radio" name="OaWorkFlowCheckStateRN" id="OaWorkFlowCheckStateRN" value="">
    </td>
  </tr>

  <tr> 
    <td>

	<table class=ListShort width="100%" cellpadding="0" id="contractTable">
		<thead>
		<TR class=Header> 
		<!-- checkBox-->
		<TH><center><input type="checkBox" id="contractAllSelect"> </TH>
		<!--合同号-->
		<TH><fmt:message key="contractForm.code"/></TH>
		<!--客户名称-->
		<TH><fmt:message key="contractForm.customerId"/></TH>		
		<!--已投放金额-->
		<TH><fmt:message key="contractForm.moneyExec"/></TH>				
		<!--开始日期-->
		<TH><fmt:message key="contractForm.startDate"/></TH>		
		<!--结束日期-->
		<TH><fmt:message key="contractForm.endDate"/></TH>			
		<!--签订人-->
		<TH><fmt:message key="contractForm.userId"/></TH>
		<!--审核记录-->
		<TH><fmt:message key="oaWorkFlowCheckForm.checkResult"/></TH>
		
		<!--审核状态-->
		<TH><fmt:message key="oaWorkFlowCheckForm.checkStateId"/></TH>
		<TH width="10%"  colspan="2" onclick="button_add_new(0)"> 
		<img id="contractImgAdd" name="contractImgAdd"  src="image/CRM_ADD.GIF" border="0"> 
		</TH>
		</TR>
			<tr > 
			<td colspan="11">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr> 
			 	<td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
			   	</tr>
			   	</table>
			</td>
			</tr>
			</thead>
			
		<tbody id="contractTbody"/>
		
		<tbody>
			<tr height="2"><td colspan="11">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
					<tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
					<tr bgcolor="#eee"> 
						<td align="right"> 
							<div id="contractPageInfo"></div>
						</td>
					</tr>
				</table>	              
			</td></tr>
		</tbody>
		              
	</table> 
	



<table class=ListShort width="100%" cellpadding="0" id="orderTable">
		<thead>
		<TR class=Header> 
		<!-- checkBox-->
		<TH><center><input type="checkBox" id="orderAllSelect"> </TH>
		<!--订单号 orderForm.orderCode-->
		<TH>订单号</TH>
		<!--合同号 orderForm.contractId-->
		<TH>合同号</TH>		
		<!--广告单位-->
		<TH><fmt:message key="orderForm.customerName"/></TH>	
		<!--广告名称-->
		<TH><fmt:message key="orderForm.matterName"/></TH>					
		<!--开始日期-->
		<TH><fmt:message key="orderForm.publishStartDate"/></TH>		
		<!--结束日期-->
		<TH><fmt:message key="orderForm.publishEndDate"/></TH>			
		<!--应付金额 orderForm.moneySum-->
		<TH>应付</TH>
		<!--已付金额 orderForm.moneyIn-->
		<TH>已付</TH>
		<!--审核记录-->
		<TH><fmt:message key="oaWorkFlowCheckForm.checkResult"/></TH>
		<!--业务员-->
		<TH><fmt:message key="orderForm.userId"/></TH>
		
		<TH>备注</TH>
		<!--审核状态 oaWorkFlowCheckForm.checkStateId-->
		<TH>状态</TH>
		<TH   colspan="2" onclick="button_add_new(0)"> 
		   <fmt:message key="orderDetailForm.favourRate"/>
		</TH>
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
			
		<tbody id="orderTbody"/>
		
		<tbody>
			<tr height="2"><td colspan="15">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
					<tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
					<tr bgcolor="#eee"> 
						<td align="right"> 
							<div id="orderPageInfo"></div>
						</td>
					</tr>
				</table>	              
			</td></tr>
		</tbody>
		              
	</table> 	
	
      
      
    </td>
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


</html:form>  	

<div style="display:none">
	<input type="text" name="id" id="id"/>
	<input type="text" name="orderCode" id="orderCode"/>
	<input type="text" name="userId" id="userId"/>

</div>
<script type="text/javascript">
    highlightTableRows("contractTable");
</script>
