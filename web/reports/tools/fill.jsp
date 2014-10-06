<html>
<head>
<title>
JasperReports - Web Application Sample
</title>
<link rel="stylesheet" type="text/css" href="stylesheet.css" title="Style">
</head>

<body bgcolor="white">
<a name="top">

<table width="700" cellpadding="0" cellspacing="0" border="0">
  <tr class="doc">
    <td width="100" align="center"><img src="images/jasperreports.gif" border="0" width="139" height="25"/></td>
    <td width="600">&nbsp;&nbsp;&nbsp;<span class="header">fill report</span></td>
  </tr>
  <tr valign="top">
    <td class="doc">
      <table width="100%" cellpadding="1" cellspacing="1" border="0">
        <tr><td class="doc">&nbsp;</td></tr>
        <tr><td class="menu">&nbsp;<a href="index.html" class="menu">home</span></a></td></tr>
        <tr><td class="menu">&nbsp;<a href="compile.html" class="menu">compile JRXML</span></a></td></tr>
        <tr><td class="menu">&nbsp;<a href="fill.html" class="menu">fill report</span></a></td></tr>
        <tr><td class="menu">&nbsp;<a href="export.html" class="menu">export report</span></a></td></tr>
        <tr><td class="menu">&nbsp;<a href="applets.html" class="menu">applet viewer</span></a></td></tr>
      </table>
    </td>
    <td>

<table width="100%" cellpadding="0" cellspacing="0" border="0">
  <tr>
    <td width="5%">&nbsp;</td>
    <td width="90%">
      <br>
      <span class="title">&nbsp;</span>
      <br>
    </td>
    <td width="5%">&nbsp;</td>
  </tr>
  <tr valign="top">
    <td>&nbsp;</td>
    <td class="justify">
      <span class="title">Filling Reports with Data</span>
      <br>
      <br>
      <span class="desc">The servlet and the JSP below both show how a compiled report template (<code>.jasper</code> file) could be filled with data. They place the resulting <code>net.sf.jasperreports.engine.JasperPrint</code> object onto the HTTP session from where subsequent report viewing and exporting servlets and JSPs in this sample application will reuse it.</span>
      <br>
      <br>
      <table width="100%" cellpadding="0" cellspacing="0" border="0">
        <tr>
          <td><span class="desc">JSP Example</span></td>
          <td><a href="jsp/fill.jsp" target="_blank"><img src="images/execute.gif" border="0" align="top"></a></td>
          <td><a href="jsp/fill.jsp" target="_blank"><span class="desc">execute</span></a></td>
          <td><a href="jsp/source.jsp?filename=/jsp/fill.jsp" target="_blank"><img src="images/source.gif" border="0" align="top"></a></td>
          <td><a href="jsp/source.jsp?filename=/jsp/fill.jsp" target="_blank"><span class="desc">source</span></a></td>
        </tr>
        <tr>
          <td><span class="desc">Servlet Example</span></td>
          <td><a href="fill" target="_blank"><img src="images/execute.gif" border="0" align="top"></a></td>
          <td><a href="fill" target="_blank"><span class="desc">execute</span></a></td>
          <td><a href="jsp/source.jsp?filename=/WEB-INF/classes/servlets/FillServlet.java" target="_blank"><img src="images/source.gif" border="0" align="top"></a></td>
          <td><a href="jsp/source.jsp?filename=/WEB-INF/classes/servlets/FillServlet.java" target="_blank"><span class="desc">source</span></a></td>
        </tr>
      </table>
      <br>
      <br>
    </td>
    <td>&nbsp;</td>
  </tr>
</table>

      <br>
      <br>
    </td>
  </tr>
  <tr><td colspan="2"><hr size="1"></td></tr>
  <tr><td colspan="2" align="center"><span class="small">Copyright &copy; 2001-2006 JasperSoft Corporation </span><a href="http://www.jaspersoft.com" target="_blank"><span class="small">www.jaspersoft.com</span></a></td></tr>
</table>

</body>
</html>
