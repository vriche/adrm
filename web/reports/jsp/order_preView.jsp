<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="javax.servlet.http.*" %>

<html>
<head>

</head>
<body>

<%
 String model = request.getParameter("model");
 String orderId = request.getParameter("orderId");
 String copys = request.getParameter("copys");
 String orgId = request.getParameter("printOrgid");

 request.getSession().setAttribute("model",model); 
 request.getSession().setAttribute("orderId",orderId);
 request.getSession().setAttribute("copys",copys);
  request.getSession().setAttribute("orgId",orgId);
 
%>


<%if(model.equals("print")){%>
<APPLET  name="orderReport1"  CODE ="PublishViewerApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar,report.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
    <PARAM NAME = CODE VALUE ="PublishPrintApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar,report.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">  
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../printOrder">
</APPLET>
<%}%>

<%if(model.equals("view")){%>
<APPLET  name="orderReport2"  CODE ="PublishViewerApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar,report.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
    <PARAM NAME = CODE VALUE ="PublishViewerApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar,report.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">  
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../printOrder">
</APPLET>
<%}%>

<%
if(model.equals("export")){
	response.sendRedirect("../../reports/printOrder");
}
%>

</body>
</html>