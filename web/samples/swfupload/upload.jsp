<%@ include file="../../common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>




		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/ext-all.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/xtheme-gray.css'/>" />
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/adapter/ext/ext-base.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-all.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-lang-zh_CN.js'/>" charset="utf-8"></script>
		<script type="text/javascript" src="<c:url value='/scripts/common/dwr-lib.js'/>"></script>

		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/TreeCheckNodeUI.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.form.ClearableComboBox.js'/>"></script>
		
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/ComboBoxTree.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/samples/swfupload/UploadPanel.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/samples/swfupload/swfupload.js'/>"></script>

		<script type="text/javascript" src="<c:url value='/scripts/samples/swfupload/plugins/swfupload.speed.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/samples/swfupload/plugins/swfupload.queue.js'/>"></script>

<script type="text/javascript">

Ext.onReady(function(){
	new Ext.Window({
		width : 650,
		title : 'swfUpload demo',
		height : 300,
		layout : 'fit',
		items : [
			{
				xtype:'fileuploadPanel',
				border : false,
				fileSize : 1024*4000,
				uploadUrl : 'upload-files.shtml',
				flashUrl : 'swfupload.swf',
				filePostName : 'uploads', 
				fileTypes : '*.*',
				postParams : {savePath:'upload\\'} 
			}
		]
	}).show();
	
});
</script>
</head>
<body>
<div id="div1"></div>
</body>
</html>