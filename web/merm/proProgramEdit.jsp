<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/sysParam.jsp" %>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title>添加节目</title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/global.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXToolbar.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTabbar.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlxToolbar_xp.css'/>" />	

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/winjs/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/dhtmlXCombo.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTabbar/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTabbar/dhtmlXTabbar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxtabbar/dhtmlXTabbar_start.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/winjs/prototype.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/winjs/effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_ext.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/debug.js'/>"></script>

<script>_js_prefix="../scripts/dhtmlxTreeGrid/"; </script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxCombo/dhtmlXCombo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_acheck.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_calendar.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXCommon.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXProtobar.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxToolbar/dhtmlXToolbar.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>

<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/DateUtil.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProProgramTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProProgramManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProCustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProCustomerTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProOrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaWorkFlowCheckStateManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ProCheckIdeaManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/oaWorkFlowCheckState.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proProgramType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proProgram.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proCustomer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proCustomerType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proOrder.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/proCheckIdea.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/merm/proProgramEditService.js'/>"></script>

<input id="ctxPath" type="hidden" value="<c:url value="/"/>">
<table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">
  <tr>
   <td>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td><div id="toolbar_zone" style="width:100%;border :1px solid Silver;"/>
      </td>
    </tr>
    </table> 
   </td>
  </tr>
  <tr>  
   <td valign="top" class="text">     
    <fieldset id="">
      <legend class="pageHeader">节目基本信息</legend -->
      <div id="customerBase">  
        <table  border="0">
        <tr>
	   	<td nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="customerTypeDetail.heading"/></td>
  		<td><div id="customerTypeDiv" style="width:150px; height:20px;"></td>
  		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</td>
  		 <td nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="proProgramForm.programStatus"/></td>
  		 <td><div id="proProgramStatusDiv" style="width:150px; height:20px;"></td>
		<td><fmt:message key="proProgramForm.isSecondLunch"/></td>
		<td><input id="isSecondLunch" name="isSecondLunch" type='checkbox' value="" /></td>
  		
  		
  		
  	   </tr>
 	   <tr>
 		<td nowrap="nowrap" class="dataLabel" align="right">  
  		<fmt:message key="proOrderForm.proProgramType"/><td><div id="programTypeDiv" style="width:150px; height:20px;"></td>
  		</td>
  		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</td>
  		<td nowrap="nowrap" class="dataLabel" align="right">
		<fmt:message key="proProgramForm.broadcastNum"/> <td><input name="textfield" type="text" id="playFather" style="width:150px; height:20px;"></td>
		</td>
	   </tr>
           <tr>        
		<td nowrap="nowrap" class="dataLabel" align="right">
		<fmt:message key="proOrderForm.program"/> <td><input name="textfield" type="text" id="proName" style="width:150px; height:20px;"></td>
		</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</td>
		<td nowrap="nowrap" class="dataLabel" align="right">
		<fmt:message key="oaProductInfoForm.price"/> <td><input name="textfield" type="text" id="unitPrice" style="width:150px; height:20px;"></td>
		</td>
 	   </tr>
 	   <tr>
		<td nowrap="nowrap" class="dataLabel" align="right">
		<fmt:message key="foretArrearageForm.customerName"/><td><div id="customer" style="width:150px; height:20px;"></div></td>
		</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</td>
		<td nowrap="nowrap" class="dataLabel" align="right">
		<fmt:message key="audienceRat.name"/> <td><input name="textfield" type="text" id="audience" style="width:150px; height:20px;"></td>
		</td>
           </tr> 
          
            
          
	    <tr>  
	          
	     <td nowrap="nowrap" class="dataLabel" align="right">
	     	 <fmt:message key="proProgramForm.TapeupTime"/><td><input name="reachDate" id="reachDate" type="text" size=20 style="width:150px; height:20px; CURSOR: pointer;" readonly ></td>
	     </td>
	     <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</td>
	    <td nowrap="nowrap" class="dataLabel" align="right">  
  			<adrm_order:authorizeTag res="tag_proProgram_check">	
  		 
  		 		<fmt:message key="proProgramForm.checkStatus"/><td><div id="checkStateDiv" style="width:150px; height:20px;"></td>
					                     	  
			</adrm_order:authorizeTag>
  		</td>
	    </tr>         
        </table>
        </div>
     </fieldset>
   </td>
  </tr> 
  <tr>  	 
   <td valign="top" bordercolor="#6699FF" class="text"> 
     <fieldset id="">
	 <legend class="pageHeader">版权基本信息</legend -->  
	   <table  border="0">
	    <tr>  
             <td nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="proProgramForm.copyrightNo"/> <td><input name="textfield" type="text" id="copyrightNum" style="width:150px; height:20px;"></td>
             </td>
             <td nowrap="nowrap" class="dataLabel" align="right">
	     		<fmt:message key="resourceLimitForm.startTime"/> <td><input name="startDate"   id="startDate" type="text" size=20 style="width:150px; height:20px; CURSOR: pointer;"></td>
	     	</td>
	    </tr>
	     <tr>  
             <td nowrap="nowrap" class="dataLabel" align="right"><fmt:message key="proProgramForm.copyrightArea"/><td><input name="textfield" type="text" id="copyrightArea" style="width:150px; height:20px;"></td>
             </td>
              <td nowrap="nowrap" class="dataLabel" align="right">
	     		<fmt:message key="resourceLimitForm.endTime"/> <td><input name="endDate"   id="endDate" type="text" size=20 style="width:150px; height:20px; CURSOR: pointer;"></td>
          	</td>
	    </tr>
	    <tr>        
	     <td nowrap="nowrap" class="dataLabel" align="right">
	     		<fmt:message key="proProgramForm.produceUnit"/> <td><input name="textfield" type="text" id="makeUnit" style="width:150px; height:20px;"></td>
	     </td>
	    </tr>
	    			 
	 </table>
      </fieldset>
  </td>
 </tr> 
   <tr> 
    <td valign="top">
   
	<div id="tabbarconteiner" style="width: 100%; height: 100%; margin: 0 0 0 8px;">
		<div id="a_tabbar" ></div>
	</div>
	
	<iframe src="<c:url value="/blank.jsp"/>" style="height:400px; width:100%" frameborder="0" id="details" name="details"></iframe>
					
    
    </td>
  </tr>
  <tr>
    <td valign="top" class="text">&nbsp;</td>
  </tr>
  <tr> 
    <td valign="top" class="text">&nbsp;</td>
  </tr>
  <!--<tr>
   <td>
    <fieldset id="">
	 <legend class="pageHeader">审核列表</legend   
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  		<tr>
  	
    		<td><div id="toolbar_zone1" style="width:100%;border :1px solid Silver;"/> </td>
 		 </tr>
 		</table> 
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
      <tr>
	    <td valign="top">
		<table width="100%" border="0">
		<tr>
		<td>
		<div id="gridbox" width="100%" height="100px" style="background-color:white;overflow:hidden"></div>
      		</td>
      		</tr>
	      	</table>		
	     </td>	
     </tr>-->
  </table>
 
 </fieldset>
 </td>
 </tr> 
    
</table>

<div style="display:none">
proProgramId:<input name="proProgramId" type="text" id="proProgramId">
proProgramName:<input name="proProgramName" type="text" id="proProgramName">
proCustomerId:<input name="proCustomerId" type="text" id="proCustomerId">
proCustomerTypeId:<input name="proCustomerTypeId" type="text" id="proCustomerTypeId">
proCustomerName:<input name="proCustomerName" type="text" id="proCustomerName">
proCopyrightNum:<input name="proCopyrightNum" type="text" id="proCopyrightNum">
proTypeId:<input name="proTypeId" type="text" id="proTypeId">
proMakeUnit:<input name="proMakeUnit" type="text" id="proMakeUnit">
proStartDate:<input name="proStartDate" type="text" id="proStartDate">
proEndDate:<input name="proEndDate" type="text" id="proEndDate">

checkStateForm:<input name="checkStateForm" type="text" id="checkStateForm">

createBy:<input name="createBy" type="text" id="createBy">
createDate:<input name="createDate" type="text" id="createDate">
version:<input name="version" type="text" id="version">
</div>

 
<div  style="display:none"  >		
<select name="select" id="carrierName"/>
</div>