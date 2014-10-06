<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.io.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String FILE_SEP = System.getProperty("file.separator");
%>    
<html>
<head>
    <title>Upload Control</title>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <link rel="stylesheet" type="text/css" href="css/dhtmlXVault.css" />

    <script language="JavaScript" type="text/javascript" src="js/dhtmlXVault.js"></script>

    <script language="JavaScript" type="text/javascript">
        var vault = null;
        function doOnLoad() {
            preLoadImages();
            vault = new dhtmlXVaultObject();
            vault.setServerHandlers("UploadHandler.jsp", "GetInfoHandler.jsp", "GetIdHandler.jsp");
            vault.create("vault1");
	}

	function preLoadImages(){
		var imSrcAr = new Array("btn_add.gif","btn_clean.gif","btn_upload.gif","ico_file.png","ico_image.png","ico_sound.png","ico_video.png","ico_zip.png","pb_back.gif","pb_demoUload.gif","pb_empty.gif");
		var imAr = new Array(0);
		for(var i=0;i<imSrcAr.length;i++){
			imAr[imAr.length] = new Image();
			imAr[imAr.length-1].src = "imgs/"+imSrcAr[i];
		}
	}
    </script>

    <style>
	body {font-size:12px}
	.{font-family:arial;font-size:12px}
	h1 {cursor:hand;font-size:16px;margin-left:10px;line-height:10px}
	xmp {color:green;font-size:12px;margin:0px;font-family:courier;background-color:#e6e6fa;padding:2px}
	.hdr{
		background-color:lightgrey;
		margin-bottom:10px;
		padding-left:10px;
	}
    </style>

</head>
<body onload="doOnLoad()">




<table width="100%" border="0" align="center">
  <tr> 
    <td width="50%"> <div class="hdr">下载文件列表</div> </td>
    <td width="50%"> <div class="hdr">文件上传</div></td>
  </tr>
  <tr> 
    <td valign="top"> <%@ include file="listDownload.jsp" %></td>
    <td rowspan="3" valign="top">
    <div id="vault1">
    </td>
  </tr>
  <tr> 
    <td><div class="hdr">已上传的文件</div></td>
  </tr>
  <tr> 
    <td valign="top"><%@ include file="listUpload.jsp" %></td>
  </tr>
</table>


 

</body>
</html>

