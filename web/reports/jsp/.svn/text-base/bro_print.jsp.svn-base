<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="javax.servlet.http.*" %>

<html>
<head>

</head>
<body>

<%
 String model = request.getParameter("model");
 String orderId = request.getParameter("orderId");
 String beginDate = request.getParameter("beginDate_bro");
 String endDate = request.getParameter("endDate_bro");
 String copys = request.getParameter("copys");
 String isRelPrice = request.getParameter("isRelPrice");
 String carrierId = request.getParameter("carrierId");
 String isCustomer = request.getParameter("isCustomer");
 String orgId = request.getParameter("orgId");
 

 request.getSession().setAttribute("carrierId",carrierId); 
 request.getSession().setAttribute("isCustomer",isCustomer);
 request.getSession().setAttribute("model",model); 
 request.getSession().setAttribute("orderId",orderId);
 request.getSession().setAttribute("beginDate",beginDate);
 request.getSession().setAttribute("endDate",endDate);
 request.getSession().setAttribute("copys",copys);
 request.getSession().setAttribute("isRelPrice",isRelPrice);
 request.getSession().setAttribute("orgId",orgId);
%>


<%if(model.equals("print")){%>
<APPLET  name="broReport1"  CODE ="PublishViewerApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar,report.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
    <PARAM NAME = CODE VALUE ="PublishPrintApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar,report.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">  
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../printBro">
</APPLET>
<%}%>

<%if(model.equals("view")){%>
<APPLET  name="broReport2"  CODE ="PublishViewerApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar,report.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
    <PARAM NAME = CODE VALUE ="PublishViewerApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar,report.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">  
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../printBro">
</APPLET>
<%}%>

<%
if(model.equals("export")){
	response.sendRedirect("../../reports/printBro");
}
%>

</body>
</html>