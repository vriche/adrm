<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="javax.servlet.http.*" %>

<html>
<head>

</head>
<body>

<%
 String carrierName = request.getParameter("carrierName");
 String parentName = request.getParameter("parentName");
 String resourceIds = request.getParameter("resourceIds");
 String publishDate = request.getParameter("publishDate");
 String model = request.getParameter("model");
 String bianpainame = request.getParameter("bianpainame");
 String carrierId = request.getParameter("carrierId");
  String orgId = request.getParameter("printOrgid");
  
 request.getSession().setAttribute("carrierId",carrierId);  
 request.getSession().setAttribute("carrierName",carrierName);
 request.getSession().setAttribute("parentName",parentName);
 request.getSession().setAttribute("resourceIds",resourceIds);
 request.getSession().setAttribute("publishDate",publishDate);
 request.getSession().setAttribute("model",model);
 request.getSession().setAttribute("bianpainame",bianpainame);
request.getSession().setAttribute("orgId",orgId);
 
 
%>

<%if(model.equals("print")){%>
<APPLET  name="broReport1"  CODE ="PublishViewerApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar,report.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
    <PARAM NAME = CODE VALUE ="PublishPrintApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar,report.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">  
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../printArrange2">
</APPLET>
<%}%>

<%if(model.equals("view")){%>
<APPLET  name="broReport2"  CODE ="PublishViewerApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar,report.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
    <PARAM NAME = CODE VALUE ="PublishViewerApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar,report.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">  
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../printArrange2">
</APPLET>
<%}%>

<%
if(model.equals("export")){
	response.sendRedirect("../../reports/printArrange2");
}
%>

</body>
</html>