<%@ include file="/common/taglibs.jsp"%>
<title><fmt:message key="adResourceQuery.title"/></title>
<content tag="heading"><fmt:message key="adResourceQuery.heading"/></content>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/class/carrierType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/matter.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resourceType.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>		        
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDayInfoManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/order/resourceAnalyzeService.js'/>"></script>


<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
				  	<td><font color="#000000" size="1.5"><fmt:message key="orderDayInfoForm.startDate"/>:</font></td>
				  	<td ><input type ="text" id ="beginDate"></td>
				  	<td><font color="#000000" size="1.5"><fmt:message key="orderDayInfoForm.endDate"/>:</font></td>
				  	<td><input type ="text" id ="overDate"></td>
				  	<td>
				  		<fmt:message key="orderForm.customerName"/>:			  		
				  	</td>
				  	 <td>
						<div style="position:relative;overflow:visible">
							<input name="customerName" id="customerName" type=text autocomplete=off value="">
							<div name="theDivCustomerName" id="theDivCustomerName" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:400px;height:250px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
						</div>
				    </td>
				    <td><fmt:message key="matterForm.name"/>:</td>
                        <td> 
							<div style="position:relative;overflow:visible">
								<input name="matter.name" id="matter.name" type=text autocomplete=off>
								<div id="theDivMatterName" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:250px;height:250px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
							</div>	                        
                    </td>	
                    <td><span class="tile1">
                    
                    	<a  id="searchRes"  class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="orderDayInfoForm.button.search"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
                    
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


<fieldset id="adResCount">
	 
	<legend> </legend>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">

		<tr>
			<td>
			  <table width="100%" border="0"  cellspacing="0" cellpadding="0">
				 <tr>
	              	<td id="treebox">			  
		              	<table width="100%" border="1">
		              	<tr>
		              	    <td>
		              	    <table>
		              	    <tr>
		              	    	<td>
	                				<select name="select" id="carrierTypeName"/>
	                	    	</td>
		              	    	<td>
	                				<select name="select" id="carrierName"/>
	                	    	</td>
	                	    	<td>
	                				<select name="select" id="resourceTypeName"/>
	                			</td>
	                		</tr>
	                		</table>
	                	    </td>
		              	</tr>
							 <tr>
				              	<td align="left">
									<div id="carrierTypeTreebox" 
										 style="width:100%; 
										 height:470px;
										 background-color:#f5f5f5;
										 border :1px solid Silver;"/>
								 </td>
						     </tr>
					     </table>
					 </td>
					 
					 <td valign="top" >
					 <div id="customerProduct_div" style="position:relative;OVERFLOW: auto;visibility:inherit;border:solid gray 2px;background-color:#f5f5f5;z-index:0">
			     			
						 <table id="customerProductTitle" class=ListShort width="100%" cellpadding="0" >
					              <thead>
					                <tr class=Header> 
					                  <!--播出位置-->
					                  <th><fmt:message key="resource.Position"/></th>					           		      
					                   <!-- 刊例价格-->
					                  <th ><fmt:message key="resource.price"/></th>
					                  <!-- 实收金额-->
					                  <th><fmt:message key="resource.realprice"/></th>
					                  <!-- 已平账金额-->
					                  <th><fmt:message key="resource.arriersPrice"/></th> 
					                     <!-- 欠款-->
					                   <th><fmt:message key="orderDayInfoForm.qiankuan"/></th>
					                    <!-- 累计时间-->
					                   <th><fmt:message key="resource.totalTime"/></th>  
					                </tr>
					              </thead>
					              <tbody id="customerProductTBody"/>
					              <tbody>
									<tr height="2">
									<td colspan="36">
										<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
											<tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
											<!--tr bgcolor="#D8DFE7"> 
												<td align="right"> 
													<div id="pageInfo_customerProduct"></div>
												</td>
											</tr-->
											
										</table>	              
									</td>
									</tr>
							</tbody>
						 </table>
						 </div> 
					 </td>
					 
			     </tr>
			   </table>
			</td>
		</tr>
	</table>
</fieldset>						

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
  
<div style="display:none;">
customerId:<input name="customerId" type="text" id="customerId">
matter.name<input type="text" id="dt_matter.id">
matter.edit:<input type="text" id="matter.edit">
matterTypeId:<input name="matterTypeId" type="text" id="matterTypeId">
customerCategoryId:<input name="customerCategoryId" type="text" id="customerCategoryId">
</div>
  
</table>











































