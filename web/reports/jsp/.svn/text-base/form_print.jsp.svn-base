<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="javax.servlet.http.*" %>

<html>
<head>

</head>
<body>

<%
 String model = request.getParameter("model");
 String carrierId = request.getParameter("carrierId");
 String publishDate = request.getParameter("publishDate");
 String dayOrNeit = request.getParameter("dayOrNeit");
 String orgIdForm = request.getParameter("orgIdForm");


 request.getSession().setAttribute("model",model); 
 request.getSession().setAttribute("carrierId",carrierId);
 request.getSession().setAttribute("publishDate",publishDate);
 request.getSession().setAttribute("dayOrNeit",dayOrNeit); 
 request.getSession().setAttribute("orgId",orgIdForm); 

%>


<%if(model.equals("view")){%>
<APPLET  name="mytest1"  CODE ="PublishViewerApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar,report.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
    <PARAM NAME = CODE VALUE ="PublishViewerApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar,report.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">  
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../printTimes">
</APPLET>
<%}%>

<%if(model.equals("print")){%>
<APPLET  name="mytest2"  CODE ="PublishPrintApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar,report.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
    <PARAM NAME = CODE VALUE ="PublishPrintApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar,report.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">  
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../printTimes">
</APPLET>
<%}%>
<%
if(model.equals("export")){
	response.sendRedirect("../../reports/printTimes");
}
%>




<input type="hidden" id="model" value=<%=model%>>
<!-- script>
   var model = document.getElementById("model").value;
   if(model == 'print') window.close();
</script -->


</body>
</html>