<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<html>
<head>
<title><fmt:message key="login.title"/></title>
<meta name="menu" content="Login"/>

<title>ExtTop - Desktop Sample App</title>

    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/desktop/core/resources/css/ext-all.css'/>" />
	 <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/desktop/css/desktop.css'/>" />
  
	<script type="text/javascript" src="<c:url value='/desktop/core/builds/ext-core.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/desktop/app-all.js'/>"></script>


    <script type="text/javascript">

        Ext.Loader.setPath({
            'Ext.ux.desktop': 'js',
            MyDesktop: ''
        });

        Ext.require('MyDesktop.App');

        var myDesktopApp;
        Ext.onReady(function () {
            myDesktopApp = new MyDesktop.App();
        });
    </script>
</head>

<body>

    <a href="http://www.sencha.com" target="_blank" alt="Powered by Ext JS"
       id="poweredby"><div></div></a>

</body>
</html>