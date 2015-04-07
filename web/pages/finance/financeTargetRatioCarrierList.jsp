<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/sysParam.jsp" %>


<title><fmt:message key="financeTargetAnalyze"/></title>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>


		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />


		<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
		<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
        <script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>  
        

	    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/ext-all.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/xtheme-gray.css'/>" />


	    <script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/adapter/ext/ext-base.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-all.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-lang-zh_CN.js'/>" charset="utf-8"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/TreeCheckNodeUI.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.form.ClearableComboBox.js'/>"></script>
		

		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.ux.form.LovCombo.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.ux.plugins.js'/>"></script>
		<script>Ext.BLANK_IMAGE_URL = '<c:url value='/scripts/ext/3.2.0/resources/images/default/s.gif'/>';</script>
		<script type="text/javascript" src="<c:url value='/scripts/common/dwr-lib.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/common/extutils.js'/>"></script>
		
		

		<script type="text/javascript" src="<c:url value='/dwr/interface/SysParamUtil.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/admin/sysParams.js'/>"></script>    
		<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script> 
		




<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_math.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/popupWindow.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>   



<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/FinanceTargetRatioManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomePurposeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceChannelManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomePurpose.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/financeTargetRatio.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resourceChannel.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/finance/financeTargetRatioCarrierService.js'/>"></script>




<content tag="heading">年度指标</content>

<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                  
                   <td width="1px" id="orgId_td"> <select id="orgId"/></td>		
                   <td width="1px"><select id="target_year"  style="CURSOR: pointer;" /></td>
                   
                   <td width="1px" ><div id="theDivMonth" name="theDivMonth"/></td>
                   
                   <!-- td width="1px"><select id="target_month"  style="CURSOR: pointer;" /></td -->
                    <td width="35px" align="right">频道:</td>
                   <td width="1px" ><div id="theDivChannel" name="theDivChannel"/></td>
                   
       
                   <!-- td width="1px" ><div id="theDivCustomerName" name="theDivCustomerName"/></td -->
                   <td width="35px" align="right">客户:</td>
                   <td width="1px"><input id="customerName" name="customerName"/></td>
                   <td width="1px"><input type="button" id="BtnClear" value="清空"></td>
                   
                   <td width="35px" align="right">用途:</td>
                   <td width="1px" ><div id="theDivIncomePurpose" name="theDivIncomePurpose"/></td>
                    
                    
                    <td width="1px"><input  type="button"   class="button"  name="Btn_searche" id="Btn_searche" value='&nbsp;&nbsp;查询&nbsp;&nbsp;'> </td>        
		
					 <td width="1px" ><div id="printReportDiv" name="printReportDiv"/></td>
					 
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
            
			  <table border="0" cellspacing="0" cellpadding="0" align="center">
			  <tr>
			    <td  valign="top"> 
			    <div>
			    <div id="gridbox" width="100%" height="400" style="background-color:white;"/> 
			    </div>
			    </td>
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
</table>


<div  style="display:none"  >		
<select name="select" id="carrierName"/>
</div>
