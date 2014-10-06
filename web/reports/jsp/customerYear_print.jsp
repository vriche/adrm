<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="javax.servlet.http.*" %>

<html>
<head>

</head>
<body>

<%
		String type = request.getParameter("type");
		String size = request.getParameter("size");
		String userName = request.getParameter("userName");
		String customerIdForm = request.getParameter("customerIdForm");
		String channelModelParam = request.getParameter("channelModelParam");
		String isPutYear = (String)request.getParameter("putYearForm");
		String returnValue = (String)request.getParameter("returnValue");
		String purpose = (String)request.getParameter("incomPurs");
		String headers = (String)request.getParameter("headers");
		
		String model = request.getParameter("model");
		
		request.getSession().setAttribute("headers",headers); 
		request.getSession().setAttribute("customerIdForm",customerIdForm); 
		request.getSession().setAttribute("userName",userName);
		request.getSession().setAttribute("channelModelParam",channelModelParam);
		request.getSession().setAttribute("type",type); 
		request.getSession().setAttribute("size",size);
		request.getSession().setAttribute("isPutYear",isPutYear);
		request.getSession().setAttribute("returnValue",returnValue); 
		request.getSession().setAttribute("purpose",purpose); 
		
		request.getSession().setAttribute("model",model); 
 		
%>
<%if(model.equals("print")){%>
<APPLET  name="broReport1"  CODE ="PublishViewerApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar,report.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
    <PARAM NAME = CODE VALUE ="PublishPrintApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar,report.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">  
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../customerYear">
</APPLET>
<%}%>

<%if(model.equals("view")){%>
<APPLET  name="broReport2"  CODE ="PublishViewerApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar,report.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
    <PARAM NAME = CODE VALUE ="PublishViewerApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar,report.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">  
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../customerYear">
</APPLET>
<%}%>

<%
if(model.equals("export")){
	response.sendRedirect("../../reports/customerYear");
}
%>

</body>
</html>