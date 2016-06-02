<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!--<!DOCTYPE HTML>-->
<!--<html>-->
<head>
<title>Web报表(B/S报表)演示 - 锐浪WEB报表插件支持多浏览器，包括IE、Chrome与FireFox等</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta name="Description" content="锐浪WEB报表插件各种格式报表演示， WEB报表支持ASP.NET,Java,ASP,PHP等,供报表打印、数据统计、数据导出、图表与条形码等功能，还提供独有的报表查询显示功能，是开发中国式复杂表格报表的最佳报表工具。"/>
<meta name="Keywords" content="WEB报表,B/S报表,报表插件,报表工具,WEB打印,ASP.NET报表,JAVA报表"/>
<script src="CreateControl.js" type="text/javascript"></script>
<script src="GRInstall.js" type="text/javascript"></script>
<style type="text/css">
h1 {
    text-align: center;
    margin-top:-10px; /*位置上移，占据掉隐藏的插件所占据的空间*/
}
h2 {
}
h3 {
    color: white;
    background-color: #404080;
    height: 1.6em;
    padding-top: 0.5em;
    margin-bottom: 0; 
}

.text-content {
    font-size: 10pt; 
}

.table-report {
    width: 100%; 
    font-size: 10pt; 
    border: black medium solid;
    border-collapse: collapse;
}
.table-title-row {
    background-color: #e6e6fa;
    text-align: center;
    font-weight:bold;
    height: 32px; 
}
.table-title-cell { 
    border: black thin solid; 
}
.table-data-row {
    height: 21px; 
}
.table-data-cell { 
    border: black thin solid;
}

.table-colwidth-report {
    width: 30%;
}
.table-colwidth-display {
    width: 5%;
}
.table-colwidth-print {
    width: 5%;
}
.table-colwidth-memo {
    width: 60%;
}

.table2-colwidth-name {
    width: 20%;
}
.table2-colwidth-memo {
    width: 50%;
}
.table2-colwidth-file {
    width: 30%;
}
</style>

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

<h1>Grid++Report Web 报表功能演示</h1>   
<p class="text-content ">
初次访问会自动下载安装WEB报表插件，需要等待几分钟。始终不能看到演示报表，<a href="http://www.rubylong.cn/WebReport/doc/setie.htm" target="_blank">
请看关于IE 安全设置</a>。WEB报表相关资料与例子在产品安装中，<a href="http://www.rubylong.cn/Download.htm" target="_blank">
下载最新版锐浪报表Grid++Report</a>, WEB报表例子包括asp.net(c#,vb)、asp、php、jsp。访问<a href="http://www.rubylong.cn" target="_blank">
锐浪软件首页</a>,了解更多关于锐浪报表的信息。锐浪报表是集成多语言支持的，在启动时根据当前电脑设置自动选择匹配的界面语言，
也可以专门指定界面语言，选择界面语言为：
<select id="cmbLanguage" style="width: 97px" onchange="return cmbLanguage_onchange()">
  <option selected="selected"></option>
  <option value="2052">简体中文</option>
  <option value="1028">繁体中文</option>
  <option value="1033">英文</option>
</select></p>
<h2>一、各种格式报表演示</h2>
<p class="text-content ">
下面演示各种格式的报表，Grid++Report报表展现分两种模式：报表打印展现与报表查询展现。点击报表名称列下的链接文字进入对应报表的打印展现模式。点击图标[查询]列下的链接图标进入对应报表的查询展现模式。报表查询展现模式一般用于明细表格类的报表展现，以连续不分页的方式查阅报表数据。
</p>

<h3>各种基础报表</h3>

<c:url value='/grid_report'/>


<table class="table-report">
<tr class="table-title-row">
    <th class="table-title-cell table-colwidth-report">报表(打印预览)</th>
    <th class="table-title-cell table-colwidth-display">查询显示</th>
    <th class="table-title-cell table-colwidth-print">报表设计</th>
    <th class="table-title-cell table-colwidth-memo">说明</th>
</tr>




<tr class="table-data-row">
<td class="table-data-cell"><a href="General/PrintReport.jsp?report=resourceUseRate4.grf&amp;data=/data/xmlUser2.jsp?ids=1548,1626" target="_blank">1a.简单表格</a></td>
<td class="table-data-cell" align="center"><a href="General/DisplayReport.jsp?report=resourceUseRate4.grf&amp;data=/data/xmlUser2.jsp?ids=1548,1626" target="_blank">[查询]</a></td>
<td class="table-data-cell" align="center"><a href="General/DesignReport.jsp?report=resourceUseRate4.grf&amp;data=data/xmlUser2.jsp?ids=1548,1626" target="_blank">[设计]</a></td>
<td class="table-data-cell">一个简单的表格报表。</td>
</tr>








</table>
</body>
</html>
