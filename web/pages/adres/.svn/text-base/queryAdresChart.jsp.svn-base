<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/sysParam.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title><fmt:message key="adResourceQuery.title"/></title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/global.css'/>" />	
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/winjs/theme.css'/>" />

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_ext.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/debug.js'/>"></script>

<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/SysParamUtil.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/admin/sysParams.js'/>"></script>    

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

<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FusionCharts.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FCColors.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FusionChartsCreator.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/Charts.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/carrierType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customerProduct.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>


<script type="text/javascript" src="<c:url value='/dwr/interface/FusionChartsManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>		        
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDayInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>


		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/ext-all.css'/>" />

		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/adapter/ext/ext-base.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-all.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-lang-zh_CN.js'/>" charset="utf-8"></script>


<script type="text/javascript" src="<c:url value='/scripts/adres/adResourceChartService.js'/>"></script>

<input type="hidden" id="contPath" value="<c:url value="/"/>">	
<input type="hidden" id="caption"  value="">	

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                  	<td>
	                  	<div style="display:none">
		              		<input style="CURSOR: pointer;" type="button" id="btn_display" value='&nbsp;&nbsp;<fmt:message key="button.display1"/>&nbsp;&nbsp;'>
		              		<input style="CURSOR: pointer;" type="button" id="btn_hidden" value='&nbsp;&nbsp;<fmt:message key="button.hidden"/>&nbsp;&nbsp;'>
		        	  	</div>
	        	  	</td>
                   
			
			           
			            <td width="1px" style="display:none"><div id="chartTypeDiv"></td>
					         	
					    <td  width="1px"><div id="baseFontSizeDiv" style="display:none"></td>
					          	
					          	
					    <td  width="1px">
						    <div style="display:none">
						       	<input  style="CURSOR: pointer;" name="paste2" type="button"  style="width:60px;" onclick="javaScript:replaceCaption();">
						        <input  style="CURSOR: pointer;" id="showValues"  name="showValues" type="checkbox" value='0'  onclick="javaScript:renderFromQS();"/>
						    </div>
						</td>
					    
					     <td  width="1px">
 							<div id="clums" style="display:none">
						</td>

	
                   
                  </tr>
                </tbody>
              </table></td>
            
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
	 
	
	<table width="100%" border="0" cellspacing="0" cellpadding="0">

		<tr>
			<td width="22%">
			  <table width="100%" border="0"  cellspacing="0" cellpadding="0">
				 <tr>
				    <td width="1px" id="orgId_td"><select id="orgId"/></td>  
			  		<td width="6px"><fmt:message key="mainMenu.date"/>:<input  type ="text" size="10" id ="searchDate"></td>
			  		<td width="1px" align="left"> </td>
			  		<td>&nbsp;</td>
			     </tr>
				
				 <tr>
	              	<td id="treebox" colspan="2">			  
		              	<table width="100%" border="0">
							 <tr>
				              	<td align="left">
									<div id="carrierTypeTreebox" 
										 style="width:100%; 
										 height:470px;
										 width:220px;
										 background-color:#f5f5f5;
										 border :1px solid Silver;"/>
								 </td>
						     </tr>
					     </table>
					 </td>
					 
					 <td  id="customerProduct_div" valign="top" width="78%" colspan="2">
						
						 <div id="chartdiv" align="center" width="100%" height="100%"  border-style="none" >
							
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
          
        </tbody>
      </table></td>
  </tr>
</table>
