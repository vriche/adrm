<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="javax.servlet.http.*" %>

<html>
<head>

</head>
<body>

<%
		String startDate = request.getParameter("beginDateForm");
		String endDate = request.getParameter("overDateForm");
		String customerId = request.getParameter("customerIdForm");
		String carrierName = request.getParameter("carrierNameForm");
		String channelModelParam = request.getParameter("channelModelForm");
		String userName = request.getParameter("userNameForm");
		
		String isPutYear = (String)request.getParameter("putYear");
		String returnValue = (String)request.getParameter("returnValue");
		String purpose = (String)request.getParameter("purpose");
		String userId = (String)request.getParameter("userIdForm");
		String orgId = (String)request.getParameter("orgIdForm");
		
			  
			  
		
		String model = request.getParameter("model");
		
		request.getSession().setAttribute("userName",userName);
		request.getSession().setAttribute("channelModelParam",channelModelParam);
		request.getSession().setAttribute("startDate",startDate); 
		request.getSession().setAttribute("endDate",endDate);
		request.getSession().setAttribute("customerId",customerId); 
		request.getSession().setAttribute("carrierName",carrierName); 
		
		request.getSession().setAttribute("isPutYear",isPutYear);
		request.getSession().setAttribute("returnValue",returnValue); 
		request.getSession().setAttribute("purpose",purpose); 
		request.getSession().setAttribute("userId",userId); 
		request.getSession().setAttribute("orgId",orgId); 
		
		request.getSession().setAttribute("model",model); 
 		
%>
<%if(model.equals("print")){%>
<APPLET  name="broReport1"  CODE ="PublishViewerApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar,report.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
    <PARAM NAME = CODE VALUE ="PublishPrintApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar,report.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">  
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../channIncome">
</APPLET>
<%}%>

<%if(model.equals("view")){%>
<APPLET  name="broReport2"  CODE ="PublishViewerApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar,report.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
    <PARAM NAME = CODE VALUE ="PublishViewerApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar,report.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">  
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../channIncome">
</APPLET>
<%}%>

<%
if(model.equals("export")){
	response.sendRedirect("../../reports/channIncome");
}
%>

</body>
</html>