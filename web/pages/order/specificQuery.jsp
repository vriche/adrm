



<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title><fmt:message key="specific.info"/></title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_start.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>




<script type="text/javascript" src="<c:url value='/dwr/interface/SpecificManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/WorkspanManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>	        


<script type="text/javascript" src="<c:url value='/scripts/class/specific.js'/>"></script>		    
<script type="text/javascript" src="<c:url value='/scripts/class/matterType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/workspan.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/order.js'/>"></script>
    
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDayInfo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrierType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderCategory.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/analyze/specificQueryService.js'/>"></script>













<content tag="heading"><fmt:message key="specific.info"/></content>



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
 				 
			
					 <td width="1px"><input type ="text" id ="beginDate" name="beginDate" size=10></td>
				
 					 <td width="1px"><input  type="text" value="结束"  size="6" class="myLable2"/></td>
 			
					 <td width="1px"><input type ="text" id ="overDate" name="overDate" size=10></td>      
				
					  <td width="1px"><input type="text" value="指定"  width="120px" class="myLable2"></td>

                    <td width="1px"> <select name="resourceSpecificId" id="resourceSpecificId" style="width:140px;"/> </td>
                    
                    <td width="1px"><div><div id="userRenderDiv" /></div></td>
                    <td width="1px"><div><div id="customerRenderDiv" /></div></td>
                    <td width="1px" >
                    	<input size="8px" name="publishMemo" id="publishMemo" type=text value="播出备注" onFocus="this.select();">
                    </td>
                     

                    <td width="1px"><input type="button"   class="button" id="search" value='查询'>	</td>   
                    
                    <td width="1px" ><div><div id="printReportDiv" name="printReportDiv"/></div></td>
					
                   <td></td>
                      
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

	        

      
            <td bgcolor="#f4f3f4"  valing="top">
              				<div id="carrierTypeTreebox" 
							 style="width:100%; 
							 height:300px;
							 width:200px;
							 background-color:#f5f5f5;
							 border :1px solid Silver;z-index:1"/>
			
	  		</td>
	  
			<td valign="top"  bgcolor="#f4f3f4">
				
				<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
				<tr><td><div id="adResCount" >
										
					<div id="gridbox" width="100%" height="100%" style="background-color:white;z-index:0"/>
				</div>		</td></tr>
										
				</table>	

            </td>

      
      
      
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
	<input id="ctxPath" type="hidden" value="<c:url value="/"/>">
</div>


<iframe src='about:blank' style="display:none"  scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
<form name="ReportForm" id="ReportForm" method="post">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="reportType" id="reportType" value="">
	<input type="hidden" name="carrierIdForm" id="carrierIdForm" value="">
	<input type="hidden" name="startForm" id="startForm" value="">
	<input type="hidden" name="endForm" id="endForm" value="">
	
	<input type="hidden" name="isPrint" id="isPrint" value="">
	
	<input type="hidden" name="userId" id="userId" value="">
	<input type="hidden" name="userName" id="userName" value="">
	<input type="hidden" name="carrierNameForm" id="carrierNameForm" value="">
	
</form>


