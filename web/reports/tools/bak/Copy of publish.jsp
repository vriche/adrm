<%@ page contentType="text/html; charset=GBK" %>
<html>
<head>

</head>
<body bgcolor="#ffffff">


<APPLET  CODE ="PrinterApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar" WIDTH ="300" HEIGHT ="40"></XMP>
    <PARAM NAME = CODE VALUE ="PrinterApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../printPublish">
</APPLET>

<script language="javascript">
  var action='<%=request.getParameter("action").toString()%>';

  if(action == 'preView')
     document.applets[0].preView();
  else if(action == 'print')
     document.applets[0].print();
     
   //window.parent.close();   
</script>


<APPLET  CODE =" EmbeddedViewerApplet.class" CODEBASE ="../applets" ARCHIVE =" jasperreports-1.2.8-applet.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
	<PARAM NAME = CODE VALUE =" EmbeddedViewerApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE =" jasperreports-1.2.8-applet.jar" >
	<PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">
	<PARAM NAME="scriptable" VALUE="false">
	<PARAM NAME =" REPORT_URL" VALUE ="../printPublish">
</APPLET>


</APPLET>

</body>
</html>
