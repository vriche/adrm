<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title><fmt:message key="orderList.title"/></title>
<content tag="heading"><fmt:message key="orderList.heading"/></content>
<meta name="menu" content="OrderMenu"/>
         
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>


<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_srnd.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_link.js'/>"></script>

<!-- script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_dload.js'/>"></script -->

<!-- script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/ext/dhtmlxgrid_filter.js'/>"></script -->




<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/utils.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customerType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/category.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/matter.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/order.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/oaWorkFlowCheckState.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderCategory.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resourceSort.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrierType.js'/>"></script>


<script type="text/javascript" src="<c:url value='/dwr/interface/OrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaWorkFlowCheckStateManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CategoryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderCategoryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceSortManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/financeTarget.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/FinanceTargetManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/finance/arrearsListService.js'/>"></script>






<title><fmt:message key="orderDetail.title"/></title>
<content tag="heading"><fmt:message key="orderDetail.heading"/></content>

<div style="display:none">
<form name="orderListForm" id="orderListForm" method="post"/>

</div>




<div style="display:block" id="orderListForm_div"  height="100%" width="100%">

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tbody>
                  <tr> 
                  
                  <td width="1px">
                     <select id="order_year"  style="CURSOR: pointer;">
						     <% for(int i= 2008; i< 2014;i++){ %>
						   		 <option value="<%=i%>"><%=i%></option>
					         <%}%>
					 </select>
                  </td>
                  

	    

	      <td width="1px" id="div_orgId" align="left"><select name=orgId" id="orgId"/> </td>

	

					
		   <td width="1px"  align="left" id="TDcustomerCategorys"><select name="customerCategorys" id="customerCategorys"/></td>	
		
		
  			<td align="left" width="60px">¿ªÊ¼:</td>	
			<td align="left" width="10px"><input type ="text" id ="beginDate" size=10/></td>
						
  			<td align="left" width="60px">½áÊø:</td>						
			<td width="10px"><input type ="text" id ="overDate" size=10/> </td>


		    <td align="left" width="60px"><fmt:message key="resourceChannelForm.name"/>:</td>	
	         <td align="left" width="10px"><input name="carrierName" id="carrierName" size="12px" type="text" autocomplete=off/></td>		 
  				
		 <td width="100px" align="left"> 
		   <a href="#"  id="query"  class="button">&nbsp;&nbsp;<fmt:message key="publishArrangeDownload.query"/>&nbsp;&nbsp;</a> 
		 </td>   					
						

		<td width="25px" align="left"><div id="printReportDiv" name="printReportDiv"/></td>
	
		 
		  <td>&nbsp;</td>				
          
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
            
            
            <!--   table start -->
	
			 <div id="gridbox" height="100%" width="99.8%" style="background-color:white;z-index:0;"></div>
           
            <!--   table end -->
            
            
            
            
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



  
  <input id="model" type="hidden" value="">
  <input id="reportType" type="hidden" value="">
  
  </div>





