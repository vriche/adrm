<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!--<!DOCTYPE HTML>-->
<!--<html>-->
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script src="<c:url value='/grid_report/CreateControl.js'/>" type="text/javascript"></script>
<script src="<c:url value='/grid_report/GRInstall.js'/>" type="text/javascript"></script>

<script language="javascript" type="text/javascript">
    Install_InsertReport();
    
</script>




</head>
<body>
<script type="text/javascript">

		var Installed = Install_Detect();
		if ( Installed )
			CreateReport("Report");

		window.onload=function(){
			var href = document.getElementById("url").value;
			window.location.href = href;
		}

</script>
<form>
	<input id="url" name="url" type="hidden" value="<%=request.getParameter("url")%>"/>
</form>
</body>
</html>
