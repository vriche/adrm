<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title>61号令</title>
<content tag="heading">61号令</content>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_drag.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_srnd.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_start.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/class/carrierType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customerProduct.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>		        
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDayInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/adres/resourceLimitSearch61Service.js'/>"></script>


<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                  
                 
					<td width="1px"><select id="resource_year"  style="CURSOR: pointer;" /></td>	  
                   
				 <td  width="1px">				    
						    <select id="seach_type"  style="CURSOR: pointer;">
						   		 <option value="1"><fmt:message key="orderDayInfoForm.usedTimee"/></option>
					             <option value="2"><fmt:message key="orderDayInfoForm.leaveTime"/></option>
						    </select>
		    	</td>			    
                  
                  
                  
                    <td  width="1px">
                    
               		<div style="position:relative;overflow:visible">   
               		
               		
               		 <input type="button"   class="button" id="btnSearche" value='查询'> 
			
 				
						<div id="theDivSearch" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:500px;height:300px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1">	
                    
                 
               			 <table width="100%">
	                 
			              	 <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
			              	 
			                 <tr>
			                 <td>客户名称：</td>
			                 <td>			                 	
							<input  style="CURSOR: pointer;"  size="15px" name="customer_name" id="customer_name" type=text  value="==<fmt:message key="orderForm.customerName"/>==">
							<div id="theDivCustomerName" style="position:absolute;  OVERFLOW: auto;left:0px;top:45px;width:450px;height:250px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
					
					</td>
					<td>频道名称：</td>
					<td>
							<select name="select" id="carrierName"/>
					</td>
			                  		
					</tr> 					
								 
				                <tr>
				                 <td>开始日期：</td>
				                 <td>   
						  	<input  style="CURSOR: pointer;"  type ="text" size="15" id ="beginDate">			  	
						 </td>
						 <td>结束日期：</td>
						 <td>
						 <input  style="CURSOR: pointer;"  type ="text" size="15" id ="overDate">
						 </td>
						</tr>
						
						<tr> 
  
 <td><fmt:message key="resourceLimitForm.startTime"/>：</td>
			 <td align="left">
			 <select name="startTime_h" id="startTime_h" style="font-size:12px;CURSOR: pointer;">
		 	    <% for(int i= 0; i< 24;i++){ %>
			   		 <option value="<%=i%>"><%=i%></option>
			            <%}%>
			</select><fmt:message key="audienceRat.hour"/>
			 <select name="startTime_m" id="startTime_m" style="font-size:12px;CURSOR: pointer;">
		 	    <% for(int i= 0; i< 60;i++){ %>
			   		 <option value="<%=i%>"><%=i%></option>
		            <%}%>
			</select><fmt:message key="audienceRat.minute"/>
	         </td>
	         
	         <td><fmt:message key="resourceLimitForm.endTime"/>：</td>
			 <td align="left">
			 <select name="endTime_h" id="endTime_h" style="font-size:12px;CURSOR: pointer;">
		 	    <% for(int i= 0; i< 24;i++){ %>
			   		 <option value="<%=i%>"><%=i%></option>
		            <%}%>
			</select><fmt:message key="audienceRat.hour"/>
			 <select name="endTime_m" id="endTime_m" style="font-size:12px;CURSOR: pointer;">
		 	    <% for(int i= 0; i< 60;i++){ %>
			   		 <option value="<%=i%>"><%=i%></option>
		            <%}%>
		</select><fmt:message key="audienceRat.minute"/>
         	</td> 
  </tr>
						
						<tr><td>&nbsp;</td><td></td><td></td><td></td></tr>
						<tr><td>&nbsp;</td><td></td><td></td><td></td></tr>	
				                 <tr>
				                 <td></td>
				                 <td align="right">
				                    <input  style="CURSOR: pointer;" type="button"  id="query" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="orderDayInfoForm.button.search"/>&nbsp;&nbsp;&nbsp;&nbsp;'>
			                            </td>
			                            <td>
			                            <input  style="CURSOR: pointer;" type="button" id="btnSearcheClose" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.cancel"/>&nbsp;&nbsp;&nbsp;&nbsp;'>
				                 </td>
				                <td></td>
				                 </tr>				
			
			</table>   
                     </div>	 
					 </td>
                    
                    
                    <td>
                      <input  style="CURSOR: pointer;"  type="button" name="Btn_view_queryAdre" id="Btn_view_queryAdre" value='&nbsp;&nbsp;<fmt:message key="publishedInfoForm.button.preView"/>&nbsp;&nbsp;'> 
			          <input  style="CURSOR: pointer;"  type="button" name="Btn_print_queryAdre" id="Btn_print_queryAdre" value='&nbsp;&nbsp;<fmt:message key="publishedInfoForm.button.print"/>&nbsp;&nbsp;'> 
			          <input  style="CURSOR: pointer;"  type="button" name="Btn_export_queryAdre" id="Btn_export_queryAdre" value='&nbsp;&nbsp;<fmt:message key="publishedInfoForm.button.export"/>&nbsp;&nbsp;'> 
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


<div id="adResCount">
	 
	
	<table width="100%" border="1" cellspacing="0" cellpadding="0">

		<tr>
			<td width="100%">
			  <table width="100%" border="0"  cellspacing="0" cellpadding="0">
				 <tr>
					 
					 <td  id="customerProduct_div" valign="top" width="100%">
						
						 
							<div id="gridbox" width="100%" height="100%" style="background-color:white;"></div>
							
						
					 </td>
					 
			     </tr>
			   </table>
			</td>
		</tr>
	</table>
</div>						

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

<input type ="hidden" id ="customerId">
<div style="display:none">
<iframe src='about:blank'   scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
</div>
<form name="ReportForm" id="ReportForm">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="reportType" id="reportType" value="">
	<input type="hidden" name="startDateForm" id="startDateForm" value="">
	<input type="hidden" name="endDateForm" id="endDateForm" value="">
	<input type="hidden" name="startTimeForm" id="startTimeForm" value="">
	<input type="hidden" name="endTimeForm" id="endTimeForm" value="">
	<input type="hidden" name="carrierIdForm" id="carrierIdForm" value="">
	<input type="hidden" name="customerName" id="customerName" value="">
	<input type="hidden" name="type" id="type" value="">
	<input type="hidden" name="mode" id="mode" value="">
	<input type="hidden" name="resourceIdForm" id="resourceIdForm" value="">
</form>