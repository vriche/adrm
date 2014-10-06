<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="javax.servlet.http.*" %>

<html>
<head>

</head>
<body>

<%
		String model = request.getParameter("model");
		String startDate = request.getParameter("startForm");
		String endDate = request.getParameter("endForm");
		String carrierIds = request.getParameter("carrierIdsForm");
		String userId = request.getParameter("userId");
	 	String userName = request.getParameter("userName");
		String isPrint = request.getParameter("isPrint");
		String isDetail = request.getParameter("isDetail");
		String weekStr = request.getParameter("weekStrForm");
		
		
		
		request.getSession().setAttribute("model",model); 
		request.getSession().setAttribute("isPrint",isPrint); 
		request.getSession().setAttribute("userId",userId); 
		request.getSession().setAttribute("userName",userName); 
		request.getSession().setAttribute("startDate",startDate); 
		request.getSession().setAttribute("endDate",endDate);
		request.getSession().setAttribute("carrierIds",carrierIds); 
		request.getSession().setAttribute("isDetail",isDetail);
		request.getSession().setAttribute("weekStr",weekStr);
 		
%>
<%if(model.equals("print")){%>
<APPLET  name="broReport1"  CODE ="PublishViewerApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar,report.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
    <PARAM NAME = CODE VALUE ="PublishPrintApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar,report.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">  
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../resourceAnalyze">
</APPLET>
<%}%>

<%if(model.equals("view")){%>
<APPLET  name="broReport2"  CODE ="PublishViewerApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar,report.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
    <PARAM NAME = CODE VALUE ="PublishViewerApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar,report.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">  
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../resourceAnalyze">
</APPLET>
<%}%>

<%
if(model.equals("export")){
	response.sendRedirect("../../reports/resourceAnalyze");
}
%>

</body>
</html>