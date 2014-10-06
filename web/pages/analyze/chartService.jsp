<!-- HTTP 1.1 -->
        <meta http-equiv="Cache-Control" content="no-store"/>
<!-- HTTP 1.0 -->
        <meta http-equiv="Pragma" content="no-cache"/>
<!-- Prevents caching at the Proxy Server -->
        <meta http-equiv="Expires" content="0"/>
<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<%@ include file="/common/sysParam.jsp" %>


	 <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/theme.css'/>" />
        <!-- link  rel="stylesheet" type="text/css"  media="all"  href="<c:url value='/styles/${appConfig["theme"]}/tab/common.css'/>" / -->
 		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/ext-all.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/xtheme-gray.css'/>" />
		
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/lovCombo/Ext.ux.form.LovCombo.css'/>" />   
	 <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/prototypeUI/ptotoyeUI.css'/>" / >

        
		<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
		<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
        <script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>    

        
        <script type="text/javascript" src="<c:url value='/scripts/common/json/json-sans-eval.js'/>"></script>
        
        
        
        
 		<script type="text/javascript" src="<c:url value='/scripts/effects.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/scripts/scriptaculous.js'/>"></script>  
             
     
        <script type="text/javascript" src="<c:url value='/scripts/CalendarPopup.js'/>"></script>
        <script language="JavaScript" src="<c:url value='/menu/includes/js/JSCookMenu.js'/>" type="text/javascript"></script>
	    <script language="JavaScript" src="<c:url value='/menu/includes/js/theme.js'/>" type="text/javascript"></script>

		<script language="JavaScript">var RTLsupport = false ;</script> 
		


		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/adapter/ext/ext-base.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-all.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-lang-zh_CN.js'/>" charset="utf-8"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/TreeCheckNodeUI.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.form.ClearableComboBox.js'/>"></script>
		

		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.ux.form.LovCombo.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.ux.plugins.js'/>"></script>
		<script>Ext.BLANK_IMAGE_URL = '<c:url value='/scripts/ext/3.2.0/resources/images/default/s.gif'/>';</script>
		<script type="text/javascript" src="<c:url value='/scripts/common/dwr-lib.js'/>"></script>
		
  		<script type="text/javascript" src="<c:url value='/dwr/interface/SysParamUtil.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/admin/sysParams.js'/>"></script>    
		 <script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
		 
		 


<script type="text/javascript" src="<c:url value='/scripts/prototypeUI/window.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/prototypeUI/utils.js'/>"></script>


<script type="text/javascript" src="<c:url value='/dwr/interface/FusionChartsManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FusionCharts.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FCColors.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FusionChartsCreator.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/Charts.js'/>"></script>
	




<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>





		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/ext-all.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/xtheme-gray.css'/>" />
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/adapter/ext/ext-base.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-all.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-lang-zh_CN.js'/>" charset="utf-8"></script>
		
	    
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/TreeCheckNodeUI.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.form.ClearableComboBox.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/common/dwr-lib.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.ux.form.LovCombo.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.ux.plugins.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/ComboBoxTree.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/MessageBox.js'/>"></script>
		
	


<script type="text/javascript" src="<c:url value='/scripts/analyze/chartService.js'/>"></script>
		

  <style type='text/css'>
	  body { 
			margin:0;
			padding:0;
	  }
  </style>
  
  
  <body>
  
  
	<input type="hidden" id="contPath" value="<c:url value="/"/>">	
	<input type="hidden" id="caption"  value="">
	              
	<table border="0" cellspacing="0" cellpadding="0" align="center">
		  	<tr>
		   	            <td style="border:solid black 1px;background-color:#f4f3f4;">
						<div id="chartdiv" align="center" border-style="none" ></td>
		  	</tr>
	</table>           
	              
	              
	              
	              
	              
	              
	        
	
</body>	