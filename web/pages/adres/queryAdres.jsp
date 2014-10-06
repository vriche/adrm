<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title><fmt:message key="adResourceQuery.title"/></title>
<content tag="heading"><fmt:message key="adResourceQuery.heading"/></content>




<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
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



<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>	


<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_start.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_nxml.js'/>"></script>  
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXTreeGrid.js'/>"></script>    



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

<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/ComboBoxTree.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/adres/adResourceService.js'/>"></script>


<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                  
                  <td width="1px" id="orgId_td"> <select id="orgId"/></td>
 				  <td width="1px"><select id="resource_year"  style="CURSOR: pointer;" /></td>	  
                    

	       
							
                 	 <td width="1%"><input type="text" value="开始"  width="120px" class="myLable2"/></td>
					 <td width="1%"><input type ="text" id ="beginDate" name="beginDate" size=10></td>
				
 					 <td width="1px"><input  type="text" value="结束"  size="6" class="myLable2"/></td>
					 <td width="1px"><input type ="text" id ="overDate" name="overDate" size=10></td> 
						    
	 			
				    <td width="1px" align="left"><div id="weekDiv" name="weekDiv"/></TD>	           
                   
               
 	 				
 	 				<td width="1px" align="left"><div id="resource_tree_id" style="position:relative;overflow:visible;"></TD>
	
                   
					<td align="left" width="1px"><div id="theDivCustomerName" style="position:relative;overflow:visible;"></td>	        
                
                    
                    
                   <td width="1%">
							<select id="order_by"  style="CURSOR: pointer;">
							     <option value="0">默认顺序</option>
						   		 <option value="1">备注排序</option>
					             <option value="2">时间排序</option>
						    </select>
               </td>                  
                  
                  
          
	           <td width="1px">
					    <select id="seach_type"  style="CURSOR: pointer;">
						   		 <option value="1"><fmt:message key="orderDayInfoForm.usedTimee"/></option>
					             <option value="2"><fmt:message key="orderDayInfoForm.leaveTime"/></option>
						 </select>
               </td>  	 
               
               
               
     			<td width="1px">
					    <select id="btn_sum"  style="CURSOR: pointer;">
						   		 <option value="1">明细</option>
										 <option value="2">汇总</option>
						 	</select>
						</td>  	 
               

						
	                 <td  width="1%"><div id="printReportDiv" name="printReportDiv"/></td> 
                     
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
             <div id="test_gridbox"></div>
			
			
										<div>
									 <div id="gridbox" width="99%" height="350px" align="left" style="background-color: white; overflow: hidden"></div>
			              	</div>
									<div>
					 						<div id="gridbox1" width="99%" height="350px" align="left" style="background-color: white; overflow: hidden"></div>
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




<div style="display:none">
<iframe src='about:blank'   scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
</div>
<form name="ReportForm" id="ReportForm">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="reportType" id="reportType" value="">
	<input type="hidden" name="startDateForm" id="startDateForm" value="">
	<input type="hidden" name="endDateForm" id="endDateForm" value="">
	<input type="hidden" name="resourceIdForm" id="resourceIdForm" value="">
	<input type="hidden" name="customerName" id="customerName" value="">
	<input type="hidden" name="type" id="type" value="">
	<input type="hidden" name="mode" id="mode" value="">
	<input type="hidden" name="weekdays" id="weekdays" value="">
	<input type="hidden" name="orderBy" id="orderBy" value="">
	
</form>

<div style="display:none;background: transparent none repeat scroll 0% 0%; overflow: hidden; left: 10px; bottom: 0px; width: 578px; height: 300px; z-index: 9999; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial; position: fixed;" id="CNZZ_AD_BOTTOM_">

<div id="CNZZ_AD_BOTTOM__inner">
<div id="CnZZ_Ad_Popwin" style="border: 1px solid rgb(159, 185, 218); padding: 3px; background: rgb(237, 248, 252) none repeat scroll 0% 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
<div style="padding: 2px 2px 0pt; width: 466px;">
<iframe src="" id="CNZZ_AD_content_box" style="height: 422px; width: 568px;" scrolling="yes" frameborder="0">
</iframe>
</div>
<div class="CNZZ_AD_BUTTONS" id="CNZZ_AD_BOTTOM__c_buttons" style="position: absolute; top: 6px; left: 0px; width: 14px; text-align: left; z-index: 9999;" onclick="close_CNZZ_adw()">
<!-- img src="close.gif" width="16" border="0" height="16" -->
</div>
<div class="CNZZ_AD_BUTTONS" id="CNZZ_AD_BOTTOM__buttons" style="width: 14px; position: absolute; top: 6px; right: 5px;"> 
<!-- img style="border: 0pt none ; cursor: pointer;" id="CNZZ_AD_BOTTOM__handle" src="/style/main/logout1.gif" onmouseover="_CNZZ_AD_.exchange('CNZZ_AD_BOTTOM_')" -->

</div>
</div></div></div>