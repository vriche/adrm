<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<%@ include file="/common/sysParam.jsp" %>

<title><fmt:message key="adResourceQuery.title"/></title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/global.css'/>" />	
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/winjs/theme.css'/>" />



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



<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>


<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_drag.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_srnd.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_start.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_link.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FusionCharts.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FCColors.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FusionChartsCreator.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/Charts.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/carrierType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customerProduct.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/class/category.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/FusionChartsManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>		        
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDayInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CategoryManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/extutils.js'/>"></script>

		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/ext-all.css'/>" />

		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/adapter/ext/ext-base.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-all.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-lang-zh_CN.js'/>" charset="utf-8"></script>
		<script type="text/javascript" src="<c:url value='/scripts/common/dwr-lib.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/ComboBoxTree.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/MessageBox.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.form.ClearableComboBox.js'/>"></script>
		

<script type="text/javascript" src="<c:url value='/scripts/admin/setUserResourceUseRateService.js'/>"></script>







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
				    <td width="0px" id="orgId_td" bgcolor=""><select id="orgId"/></td>  
				    <!-- select id="resource_year"  style="CURSOR: pointer;" / -->
	        	     <td width="50px" align="left" bgcolor="">类别</td>
	        	     <td width="1px" align="left" bgcolor=""><div id="extUserIdDiv" name="extUserIdDiv"/></td>
	        	     <td width="100px" align="left">使用比率</td>
	        	     <td width="10px">
	        	     <input id="rate" type="text" value=""/>
	        	     <input id="save" type="button" value="批量保存"/>
	        	     <input id="remove" type="button" value="批量删除"/>
	        	     <input id="print" type="button" value="&nbsp;&nbsp;总&nbsp;&nbsp;览&nbsp;&nbsp;"/> 
	        	     </td>

	        	     <td width="1px" align="left"></td>
	        	    
	        		 <td width="0px" align="left" style="display:no">
		                   <select id="carrier_displayMode">
								   		 <option value="1">显示启用频道</option>
							             <option value="2">显示所有频道</option>
							</select>
					</td>	

			  		<td>&nbsp; </td>
			  		
			
			     </tr>
				
				 <tr>
	              	<td id="treebox" colspan="4">			  
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
					 
					 <td   valign="top" width="100%" colspan="4">
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr><td>
							<div id="gridbox" width="100%" height="100%" style="background-color:white;z-index:0"></div>
						</td></tr>
					 	</table>
							
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
<form name="form2" id="form2" action="#" method="post" target="_bank">  

<input id="url" name="url" type="hidden" value=""/>
</form>