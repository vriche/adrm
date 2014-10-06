<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="foretArrearageList.title"/></title>
<content tag="heading"><fmt:message key="foretArrearageList.heading"/></content>
<meta name="menu" content="ForetArrearageMenu"/>

	
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_drag.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_srnd.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_start.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
 <script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
 <script type="text/javascript" src="<c:url value='/scripts/class/foretArrearage.js'/>"></script>
 
  <script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
 <script type="text/javascript" src="<c:url value='/dwr/interface/ForetArrearageManager.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/finance/foretArrearageListService.js'/>"></script> 

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editForetArrearage.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tbody>
                  <tr> 
                  	<td>
                  	
                  	
                     <!--²éÑ¯-->
		    <div style="position:relative;overflow:visible"> 
                  
                     
                   <table width="100%" id="check_types">
		                  <tr>
		                    <td align="left">
		 						<div style="position:relative;overflow:visible;">
								<fmt:message key="orderForm.customerName"/><input size="12px" name="customer_name" id="customer_name" type=text  value="">
								<div id="theDivCustomerName" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:340px;height:250px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
								<input type ="hidden" id ="customerId">
								</div>		
		                    </td>
                    			<td align="left">
						
							
						    <select id="year">
						    <option value="<%=0%>">==select year==</option>
						    <% for(int i= 0; i< 10;i++){ %>
						   		 <option value="<%=2008+i%>"><%=2008+i%></option>
					            <%}%>
						    </select>				
							
			     			</td>	
			     			<td align="left">
			     			<a href="#"  id="btn_searche"  class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="publishArrangeDownload.query"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>  
			
							<c:out value="${buttons}" escapeXml="false"/>
			     			</td>
			     			
			     			<td align="left">
			     				<input type="radio" name="radorRN" id="payMoneyRN" value="1">
			     				 <label style="cursor: pointer;width:20px;" for="payMoneyRN"><fmt:message key="foretArrearageForm.payMoney"/>
			     			</td>
			     			<td align="left">
			     				<input type="radio" name="radorRN" id="incomeMoneyRN" value="2">
			     				<label style="cursor: pointer;width:20px;" for="incomeMoneyRN"><fmt:message key="foretArrearageForm.incomeMoney"/>
			     			</td>
			     			<td align="left">
			     				<input type="radio" name="radorRN" id="moneyLeftRN" value="3">
			     				<label style="cursor: pointer;width:20px;" for="moneyLeftRN"><fmt:message key="contractPaymentForm.moneyLeft"/>
			     			</td>
			     			<td align="left">
			     				<input type="radio" name="radorRN" id="seeAllRN" value="4" checked>
			     				<label style="cursor: pointer;width:20px;" for="seeAllRN"><fmt:message key="foretArrearageForm.seeAll"/>
			     			</td>
			     			
                   
                    </tr></table>
 	                                                      
                     
                    
                    </td>
                  </tr>
                </tbody>
              </table>
               
              
              </td>
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

<legend> </legend>
	<table width="100%" border="1" cellspacing="0" cellpadding="0">

		<tr>
			<td width="22%">
			  <table width="100%" border="0"  cellspacing="0" cellpadding="0">
				 <tr>
	             
					 
					 <td  id="analyCarriermatter_div" valign="top" width="78%">
						<fieldset style="width: 97%" id="analyCarriermatterBox"> 
          						 <legend></legend>	
						 
							<div id="gridbox" width="100%" height="100%" style="background-color:white;"></div>
							
							</fieldset>
						
					
					
							<fieldset style="width: 97%" id="analyCarriermatterBox2"> 
          						 <legend></legend>	
						 
							<div id="gridbox2" width="100%" height="100%" style="background-color:white;"></div>
							
							</fieldset>
					
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
</table>  	 



<script type="text/javascript">
    highlightTableRows("foretArrearageList");
</script>
