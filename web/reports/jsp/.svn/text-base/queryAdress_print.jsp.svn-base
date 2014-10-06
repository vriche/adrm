<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="javax.servlet.http.*" %>

<html>
<head>

</head>
<body>

<%
		String startDate = request.getParameter("startDateForm");
		String endDate = request.getParameter("endDateForm");
		String startTime = request.getParameter("startTimeForm");
		String endTime = request.getParameter("endTimeForm");
		String carrierId = request.getParameter("carrierIdForm");
		String resourceIds = request.getParameter("resourceIdForm");
		String model = request.getParameter("model");
		String type = request.getParameter("type");
		String mode = request.getParameter("mode");
		String weekdays = request.getParameter("weekdays");
		String customerName = request.getParameter("customerName");
		String orderBy = request.getParameter("orderBy");
		
		
		request.getSession().setAttribute("startDate",startDate); 
		request.getSession().setAttribute("endDate",endDate);
		request.getSession().setAttribute("startTime",startTime); 
		request.getSession().setAttribute("endTime",endTime);
		request.getSession().setAttribute("carrierId",carrierId); 
		request.getSession().setAttribute("resourceIds",resourceIds); 
		request.getSession().setAttribute("customerName",customerName); 
		request.getSession().setAttribute("model",model); 
        request.getSession().setAttribute("type",type);
        request.getSession().setAttribute("mode",mode);
        request.getSession().setAttribute("weekdays",weekdays);
        request.getSession().setAttribute("orderBy",orderBy);
 		
%>
<%if(model.equals("print")){%>
<APPLET  name="broReport1"  CODE ="PublishViewerApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar,report.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
    <PARAM NAME = CODE VALUE ="PublishPrintApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar,report.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">  
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../queryAdres">
</APPLET>
<%}%>

<%if(model.equals("view")){%>
<APPLET  name="broReport2"  CODE ="PublishViewerApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar,report.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
    <PARAM NAME = CODE VALUE ="PublishViewerApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar,report.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">  
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../queryAdres">
</APPLET>
<%}%>

<%
if(model.equals("export")){
	response.sendRedirect("../../reports/queryAdres");
}
%>

</body>
</html>