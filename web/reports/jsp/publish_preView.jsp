<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="javax.servlet.http.*" %>

<html>
<head>

</head>
<body>

<%
 String carrierName = request.getParameter("carrierName");
 String resourceIds = request.getParameter("resourceIds");
 String publishDate = request.getParameter("publishDate");
 String model = request.getParameter("model");
  
 request.getSession().setAttribute("carrierName",carrierName);
 request.getSession().setAttribute("resourceIds",resourceIds);
 request.getSession().setAttribute("publishDate",publishDate);
 request.getSession().setAttribute("model",model);
%>

<APPLET  name="mytest"  CODE ="PublishViewerApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar,report.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
    <PARAM NAME = CODE VALUE ="PublishViewerApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar,report.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">  
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../printPublish">
</APPLET>

</body>
</html>