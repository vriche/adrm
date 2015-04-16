<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<script src="<c:url value='/grid_report/CreateControl.js'/>" type="text/javascript"></script>
<script src="<c:url value='/grid_report/GRInstall.js'/>" type="text/javascript"></script>
<script language="javascript" type="text/javascript">
    Install_InsertReport();
    
	function cmbLanguage_onchange() 
	{
		Report.Language = cmbLanguage.value;
	}
</script>

</head>
<body>
<script type="text/javascript">
	var Installed = Install_Detect();
	if ( Installed )
		CreateReport("Report");
</script>


<h1>Grid++Report Web</h1> 
<a href="<c:url value='/grid_report/General/PrintReport.jsp'/>?report=1a.grf&amp;data=<c:url value='/grid_report/data/xmlCustomer.jsp'/>" target="_blank">111</a>
</table>
</body>
</html>
