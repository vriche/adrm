<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<head>
    <title><fmt:message key="login.title"/></title>
    <meta name="menu" content="Login"/>
    
    
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/virtualkeyboard.css'/>" />
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/ext-all.css'/>" />
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/xtheme-gray.css'/>" />
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/ext-patch.css'/>" />
	
	<style type="text/css">

	</style>

	
	<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/adapter/ext/ext-base.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-all.js'/>"></script>

    <script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/virtualkeyboard.js'/>"></script>    
    <script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/virtualkeyboard_plus.js'/>"></script>    
	<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.util.md5.js'/>"></script>        
    <script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.ux.Crypto.SHA1.js'/>"></script> 
  	<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.ux.form.IconCombo.js'/>"></script>          
    <script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.ux.LoginWindow_1.6.js'/>"></script>
    
    <script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
	<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
    <script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>

    <script type="text/javascript" src="<c:url value='/dwr/interface/SysParamUtil.js'/>"></script>

    <script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>   
     
    <script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>

    <script type="text/javascript">   
    	Ext.onReady( function() {
    	
    	  
     		try {
				showLoginWin(null,false);
			} catch (e) {

			} 	        
    	        
    	        
    	        
    	        
		});  	
	 </script>


</head>
<body id="login"/>

<input type="hidden" name="logo_org_names" id="logo_org_names" value="<c:out value='${appConfig["LOGO_ORG_NAME"]}'/>"/>

