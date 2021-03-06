<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <%@ include file="/common/meta.jsp" %>
  	       
       
        	
        <title><decorator:title/> | 博瑞广告经营管理系统</title>

        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/theme.css'/>" />
        <!-- link  rel="stylesheet" type="text/css"  media="all"  href="<c:url value='/styles/${appConfig["theme"]}/tab/common.css'/>" / -->
 		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/ext-all.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/xtheme-gray.css'/>" />
		
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/lovCombo/Ext.ux.form.LovCombo.css'/>" />   
		
		<!-- link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/virtualkeyboard.css'/>" / -->				

	    <!-- link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/ext-patch.css'/>" / -->

		<!-- script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/virtualkeyboard.js'/>"></script -->    
	    <!-- script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/virtualkeyboard_plus.js'/>"></script -->    
		<!-- script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.util.md5.js'/>"></script -->        
	    <!-- script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.ux.Crypto.SHA1.js'/>"></script --> 
	  	<!-- script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.ux.form.IconCombo.js'/>"></script -->          
	    <!-- script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.ux.LoginWindow_1.6.js'/>"></script -->   
	    
	      

        
		<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
		<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
        <script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>    

        
        <script type="text/javascript" src="<c:url value='/scripts/common/json/json-sans-eval.js'/>"></script>
        <!-- script type="text/javascript" src="<c:url value='/scripts/common/hashMap.js'/>"></script -->
        
        
        
        
        
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
		
		<script type="text/javascript" src="<c:url value='/scripts/admin/decoratorsService.js'/>"></script>
		
	
	
		 
        <decorator:head/>
    </head>
    
<body<decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class" writeEntireProperty="true"/>>

    <div id="page">
        
         <div id="content">
        
            <%@ include file="/common/messages.jsp" %>

            <table class="dialog" cellpadding="0" cellspacing="0">
				<tr>
				   <td>
					<table class="dialogbox" cellpadding="0" cellspacing="0">
					        <tr>
					        <td>
							<div class="dialoghead" unselectable="on">
								<decorator:getProperty property="page.heading"/>  
							</div>
							
							
							
							<table width="100%" border="0" cellpadding="0" cellspacing="0">
							  <tr>
							    <td width="70%">
							        <!-- %String menuContent = (String) application.getAttribute("menuContent");% -->
							   		 <adrm_order:mymenu name="my_adrm_menu" toScope="session"/>

							     <td>
									
		                  			  |<font style="font-weight:bold;text-shadow:Red;"><fmt:message key="user.status"/><span id="loginUser_fullName"/></font>|
		            				
							      </td>
							    <td>
									<!-- table width="100%" border="0" cellpadding="0" cellspacing="0">
									  <tr>
									    <td>
									    	<a href="mainMenu.html" onMouseOut="MM_nbGroup('out');"  onMouseOver="MM_nbGroup('over','tt1','image/main/home2.gif','image/main/home2.gif',1);" title="<fmt:message key="adrm.index"/>" ><img name="tt1" src="image/main/home1.gif" border="0"></a>
										</td>
									    <td>
									    	<a href="javascript:location.reload();" onMouseOut="MM_nbGroup('out');"  onMouseOver="MM_nbGroup('over','tt2','image/main/refresh2.gif','image/main/refresh2.gif',1);" title="<fmt:message key="adrm.refurbish"/>" ><img name="tt2" src="image/main/refresh1.gif" border="0"></a>
										</td>
									    <td>
									   		 <a href="javascript:history.go(-1);" onMouseOut="MM_nbGroup('out');"  onMouseOver="MM_nbGroup('over','tt3','image/main/goback2.gif','image/main/goback2.gif',1);" title="<fmt:message key="adrm.back"/>" ><img name="tt3" src="image/main/goback1.gif" border="0"></a>
										</td>
									    <td>
									    	<a href="javascript:history.forward();" onMouseOut="MM_nbGroup('out');"  onMouseOver="MM_nbGroup('over','tt4','image/main/forword2.gif','image/main/forword2.gif',1);" title="<fmt:message key="adrm.forword"/>" ><img name="tt4" src="image/main/forword1.gif" border="0"></a>
										</td>
									    <td>
											<a href="logout.jsp" onMouseOut="MM_nbGroup('out');"  onMouseOver="MM_nbGroup('over','tt5','image/main/logout2.gif','image/main/logout2.gif',1);" title="<fmt:message key="adrm.logout"/>" ><img name="tt5" src="image/main/logout1.gif" border="0"></a>
										</td>
									  </tr>
									</table -->
									
									
									
									<table width="100%" border="0" cellpadding="0" cellspacing="0">
									  <tr>
									    <td>
									    	<a href="mainMenu.html" title="<fmt:message key="adrm.index"/>" ><img name="tt1" src="image/main/home1.gif" border="0"></a>
										</td>
									    <td>
									    	<a href="javascript:location.reload();"  title="<fmt:message key="adrm.refurbish"/>" ><img name="tt2" src="image/main/refresh1.gif" border="0"></a>
										</td>
									    <td>
									   		 <a href="javascript:history.go(-1);" title="<fmt:message key="adrm.back"/>" ><img name="tt3" src="image/main/goback1.gif" border="0"></a>
										</td>
									    <td>
									    	<a href="javascript:history.forward();"  title="<fmt:message key="adrm.forword"/>" ><img name="tt4" src="image/main/forword1.gif" border="0"></a>
										</td>
									    <td>
											<a href="#"  id="main_body_close_id" title="<fmt:message key="adrm.logout"/>" ><img name="tt5" src="image/main/logout1.gif" border="0"></a>
										</td>
									  </tr>
									</table>									
									
									
									
									
									
									
									
									
									
									
								</td>
							  </tr>
							</table>						
							
							
		
							<div class="dialogcontent" unselectable="on" id="dialogcontentDiv">
								<decorator:body/>
							</div>

					       </td></tr>
				      </table>
				  </td>
				</tr>
			</table>

        </div>
    
 		<!-- %@ include file="/common/sysParam.jsp" % -->
 		 <div style="display:none;">
        <input type="text" id="config_username"  name="config_username"  value=""> <br>  
          </div>
        <div id="footer">
            <c:import url="/common/footer.jsp"/>
        </div>
        
    </div>
    
	<!--CalendarPopup-->
	<center>
	<div id="testdiv1" style="position: absolute; background-color: white; left: 55px; top: 806px; visibility: hidden;">
	<table class="cpBorder" borderwidth="1" border="1" cellpadding="1" cellspacing="0" width="144">
	
		
	
</body>
</html>


