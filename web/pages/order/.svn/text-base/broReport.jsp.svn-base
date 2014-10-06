<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="broReport.title"/></title>
<content tag="heading"><fmt:message key="broReport.heading"/></content>


<script type="text/javascript" src="<c:url value='/scripts/common/popupWindow.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/matter.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/order.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderPublic.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/popupWindow.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>

<!-- 日历 -->
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/order/broReportService.js'/>"></script>







<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1">
                <tbody><!--tr><td> <table  align="center" -->
                  <tr> 
   
                    <td id="orgId_td"> <select id="orgIdCmd"/></td>
                    	
		            <td width="80px">
		                
		                
		             <!--查询-->
				    <div style="position:relative;overflow:visible">                 	
                        <input type="button"   class="button" id="btn_searche" value='查询'>
			 			
						<div id="theDivSearch" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:400px;height:300px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1">	
			                            
			             <table width="50%">
				                  <tr>
										<td width="10px"><fmt:message key="orderForm.customerName"/></td>
						                <td  width="1px"><div id="extCustomerDiv" name="extCustomerDiv" /></td>		
						                				                 
                                  </tr>
	                                     <td width="10px">频道名称</td>
										 <td><select name="select" id="carrierName"/></td>
 				                  <tr>
										 <td width="10px"><fmt:message key="brandForm.name"/></td>
										 <td>
										 	<div style="position:relative;overflow:visible">
												<input size="18px" name="matterName" id="matterName" type=text autocomplete=off style="width:140px;">
												<div id="theDivMatterName" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:250px;height:150px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
											</div>
										 </td>
                                  </tr>

 				                 <tr>
                                   <td width="10px"><fmt:message key="orderForm.publishStartDate"/></td>
                                   <td><input type="text" name="startDate" id="startDate" style="width:140px;"></td>
   				                 </tr>   
				                  
                                   <tr>   
                                   <td width="10px"><fmt:message key="orderForm.publishEndDate"/></td>
                                   <td><input type="text" name="endDate" id="endDate" style="width:140px;"></td>
   				                   </tr>   				                  
									



   				                   

   				                   
                                    <tr>  
	                                   <td width="10px">&nbsp;</td>
	                                   <td>&nbsp; </td>
   				                    </tr>   				                   
   				                    						
                                  <tr>   
                                   <td width="10px"><input style="CURSOR: pointer;" type="button"  id="Submit" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.confim"/>&nbsp;&nbsp;&nbsp;&nbsp;'></td>
                                   <td><input style="CURSOR: pointer;" type="button" id="btn_searche_close" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.cancel"/>&nbsp;&nbsp;&nbsp;&nbsp;'></td>
   				                   </tr>                           
                            </table>                                        

                         </div>         	
                    </td>	    

   				                    
  					
 				    <td  width="1px"><input type="checkbox" name="iscustomerCheck" id="iscustomerCheck" value="iscustomer" checked></td>
 				    <td width="50px"><label style="cursor: pointer;width:20px;" for="iscustomerCheck"><fmt:message key="orderForm.iscustomer"/></label></td>

 				    
 				    <td width="1px">&nbsp; </td>
   					
 				    <td width="1px"><input type="checkbox" name="isRelPriceCheck" id="isRelPriceCheck" value="checkbox" checked></td>  
 				    <td width="50px"><label style="cursor: pointer;width:20px;" for="isRelPriceCheck"><fmt:message key="orderForm.isRelPrice"/></label></td>     
 				     <td width="1px">&nbsp; </td>   

                    <td width="25px">开始</td>
                    <td width="1px"><input type="text" name="printDateStart" id="printDateStart" style="width:80px;"> </td>
                                   
                    <td width="25px">截止</td>
                    <td width="1px"><input type="text" name="printDate" id="printDate" style="width:80px;"> </td>	
                    
                    
   		    		<!-- td width="1px" ><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_view_order" value='预览'  onmouseover="this.className='button mouseover'"  onmouseout="this.className='button'"></td> 
					<td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_print_order" value='打印'  onmouseover="this.className='button mouseover'"  onmouseout="this.className='button'"></td> 
					<td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_export_order" value='导出'  onmouseover="this.className='button mouseover'"  onmouseout="this.className='button'"></td --> 
                    
                    		                  	
                    	
                    <td  width="1px" ><div id="printReportDiv" name="printReportDiv"/></td>	

						
                  </tr><!--/table></td></tr--> 
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
          <td width="30%"> 
			          	<table id="orderList" class=ListShort width="100%" cellpadding="1" >
			              <thead>
			                <TR class=Header> 
			                  <!--素材名称-->
			                  <TH><fmt:message key="orderForm.orderCode"/></TH>
			                  <!--客户-->
			                  <TH><fmt:message key="orderForm.contractId"/></TH>
			                  <!--类型-->
			                  <TH>广告名称</TH>
			                  <!--版本--> 
			                  <TH><fmt:message key="orderForm.publishStartDate"/></TH>
			                  <!--长度-->
			                  <TH><fmt:message key="orderForm.publishEndDate"/></TH>
			                  <!--磁带编号-->
			                  <TH><fmt:message key="orderForm.moneySum"/></TH>

			                  <!--备注-->
			                  <TH><fmt:message key="orderForm.moneyIn"/></TH>
			                  <!--有效-->
			                  <TH><fmt:message key="orderForm.isCkecked"/></TH>
			                  
			                  <!--fmt:message key="publishedInfoForm.button.preView"/-->
			                  
			                  <!-- TH id="incomeListRow" name="incomeListRow" style="cursor:hand" colspan="3" align="center">
			                  		<fmt:message key="button.operation"/> </TH -->
			                </TR>
			                
			                  <tr> 
				                  <td colspan="8">
					                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                      <tr> 
					                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
					                      </tr>
					                    </table>
				                    </td>
				              </tr>
				              
			              
			              <tbody id="orderBody"/>
			              
			              </thead>
				          <tbody>
				          <tr height="20"><td colspan="8">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
						  				 <tr>
						  				 	 <td colspan="2"><IMG src="image/s.gif"  width="100%" height="2">
						  				 	 </td>
						  				 </tr>
				                        <tr  bgcolor="#eee">
				                          <td align="right"> 
				                              <div id="pageInfoorder"></div>
				                          </td>
				                     	</tr>
							  </table>
							  </td>
				          </tr>
				          </tbody>
				          
				          </table>
				          
		          
				          
<div style="display:none;">
customerId:<input name="customerId" type="text" id="customerId">
customerCategoryId:<input name="customerCategoryId" type="text" id="customerCategoryId">
matterId<input type="text" id="matterId" name="matterId">


使用<input type="checkbox" name="man_date" id="man_date" value="checkbox"> 
 <iframe src='about:blank'   scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
</div>   				          
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
  

<form name="ReportForm" id="ReportForm">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="orderId" id="orderId" value="">
	<input type="hidden" name="copys" id="copys" value="">
	<input type="hidden" name="beginDate_bro" id="beginDate_bro" value="">
	<input type="hidden" name="endDate_bro" id="endDate_bro" value="">
	<input type="hidden" name="isRelPrice" id="isRelPrice" value="">
	<input type="hidden" name="carrierId" id="carrierId" value="">
	<input type="hidden" name="matterNameForm" id="matterNameForm" value="">
	<input type="hidden" name="isCustomer" id="isCustomer" value="">
	<input type="hidden" name="orgId" id="orgId" value="">
</form>	
  
  
  
  
  
</table>