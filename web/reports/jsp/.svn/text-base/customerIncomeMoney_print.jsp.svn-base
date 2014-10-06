<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="javax.servlet.http.*" %>

<html>
<head>

</head>
<body>

<%
		
		String model = request.getParameter("model"); 
		
        String startDate = request.getParameter("startDateForm");
		String endDate = request.getParameter("endDateForm");
		String customerId = request.getParameter("customerIdForm");
		String carrierName = request.getParameter("carrierNameForm");
		String userOwner = request.getParameter("userOwnerForm");
		String arrears = request.getParameter("arrearsForm");
		String incomepurpose = request.getParameter("incomepurposeForm");
		String usrName = request.getParameter("usrNameForm");
		String channelModelParam = request.getParameter("channelModelParam");
		String putYear = request.getParameter("putYear");
		String orgId = request.getParameter("orgIdForm");
		
		
		
		request.getSession().setAttribute("model",model);
		
		request.getSession().setAttribute("usrName",usrName);
		request.getSession().setAttribute("channelModelParam",channelModelParam); 
		request.getSession().setAttribute("startDate",startDate);
		request.getSession().setAttribute("endDate",endDate); 
		request.getSession().setAttribute("customerId",customerId);
		request.getSession().setAttribute("carrierName",carrierName);
		request.getSession().setAttribute("userOwner",userOwner);
		request.getSession().setAttribute("arrears",arrears);
		request.getSession().setAttribute("incomepurpose",incomepurpose);
		
		request.getSession().setAttribute("putYear",putYear);
		request.getSession().setAttribute("orgId",orgId);
		 
		
		
 		
%>
<%if(model.equals("print")){%>
<APPLET  name="broReport1"  CODE ="PublishViewerApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar,report.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
    <PARAM NAME = CODE VALUE ="PublishPrintApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar,report.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">  
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../customerIncomeMoney">
</APPLET>
<%}%>

<%if(model.equals("view")){%>
<APPLET  name="broReport2"  CODE ="PublishViewerApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar,report.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
    <PARAM NAME = CODE VALUE ="PublishViewerApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar,report.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">  
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../customerIncomeMoney">
</APPLET>
<%}%>

<%
if(model.equals("export")){
	response.sendRedirect("../../reports/customerIncomeMoney");
}
%>

</body>
</html>