﻿<%@ page contentType="text/html; charset=utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>web报表(b/s报表)演示，在网页中应用报表设计器设计报表 - <%=request.getParameter("report")%></title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<script src="../CreateControl.js" type="text/javascript"></script>
	<script type="text/javascript">
function OnSaveReport()
{
	
	alert("为了保护报表的正常演示，这里放弃了对报表设计的保存！");
	ReportDesigner.DefaultAction = false;
}
	</script>
    <style type="text/css">
        html,body {
            margin:0;
            height:100%;
        }
    </style>
</head>
<body style="margin:0">
	<script type="text/javascript">
	    var Report = "<%=request.getParameter("report")%>";
	    if (Report == "null")
			Report = "";
	    else if (Report != "")
	        Report = "../grf/" + Report;
	        
	    var Data = "<%=request.getParameter("data")%>";
	    if (Data == "null")
			Data = "";
	    else if (Data != "")
	        Data = "../" + Data;
	  //以 ReportDesigner 为 ID 创建报表设计器插件(Designer)，详细请查看帮助中的 IGRDesigner
	  //Width - 插件的显示宽度，"100%"为整个显示区域宽度，"500"表示500个屏幕像素点
	  //Height - 插件的显示高度，"100%"为整个显示区域高度，"500"表示500个屏幕像素点
	  //LoadReportURL - 读取报表模板的URL，运行时从此URL读入报表模板数据并加载到设计器插件
	  //SaveReportURL - 保存报表模板的URL，保存设计后的结果数据，由此URL的服务在WEB服务端将报表模板持久保存
	  //DataURL - 获取报表运行时数据的URL，在设计器中进入打印视图与查询视图时从此URL获取报表数据
	  //ExParams - 指定更多的插件属性阐述,形如: "<param name="%ParamName%" value="%Value%">"这样的参数串
//	  function CreateDesignerEx(Width, Height, LoadReportURL, SaveReportURL, DataURL, ExParams)       
	 // CreateDesignerEx("100%", "100%", Report, "DesignReportSave.jsp?report=<%=request.getParameter("report")%>", Data, "<param name=OnSaveReport value=OnSaveReport>");

//	    alert(ReportExport)
	    
	    
	    CreateDesignerEx("100%", "100%", Report, "DesignReportSave.jsp?report=<%=request.getParameter("report")%>", Data);
		
	  </script>
</body>
</html> 