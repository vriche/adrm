<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<html>

<head>
	<title>FusionCharts Free Documentation</title>
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dtree.css'/>" /> 
	<script type="text/javascript" src="<c:url value='/scripts/merm/Tree/dtree.js'/>"></script>
</head>

<body leftMargin='20' background="<c:url value='/images/body_bg.jpg'/>">

<div class="dtree">

<!-- p><a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a></p -->

	<script type="text/javascript">
		<!--
		
		var path ="<c:url value="/"/>" +"merm/"

		    

		//id, pid, name, url, title, target, icon, iconOPne, open,

		d = new dTree('d');
		d.config.target="right";		
		d.config.folderLinks = false;
		
// ----------------- INTRODUCTION ------------------//
		d.add(0,-1,'<B>节目管理</B>','','FusionCharts Free Documentation');
		
		d.add(1,0,'客户管理','','Introduction','','','',false);
		d.add(101,1,'添加客户',path + 'editCustomer.jsp',' ');
		d.add(102,1,'节目供应商','customerList.jsp?type=1',' ');
		d.add(103,1,'购买节目客户','customerList.jsp?type=2',' ');
		
		

// --------------- SAMPLE CHARTS -------------------- //
		d.add(2,0,'节目采购','','','',false);		
		d.add(201,2,'添加节目',path + 'proProgramEdit.jsp',' ');
		d.add(202,2,'节目搜索',path + 'proProgramSearch.jsp',' ');
		d.add(203,2,'播出计划',path + 'proPublishPlan.jsp',' ');


// ------- CREATING YOUR FIRST CHART -------------//
		d.add(3,0,'订单管理');
		d.add(301,3,'采购',path+'proOrderList.jsp?type=1');
		d.add(302,3,'销售',path+'proOrderList.jsp?type=2');

		
// -------------------- FUSIONCHARTS AND XML ------------------//
		d.add(4,0,'财务结算','');
		d.add(401,4,'到款分配',path + 'incomePulls.jsp','');
		d.add(402,4,'欠款查询',path + 'paymentList.jsp','');


// -------------- MECHANISM --------------		
		d.add(5,0,'统计分析');
		d.add(501,5,'节目成本分析',path + 'proProgramCostAnalyze.jsp',' ');
		d.add(502,5,'节目收入分析',path + 'proProgramIncomeAnalyze.jsp',' ');
		d.add(503,5,'节目收视分析',path + 'proProgramAudienceAnalyze.jsp',' ');
		d.add(504,5,'成本收入收视对比',path + 'proProgramCostIncomeAudienceAnalyze.jsp',' ');
 
		
// --------------------- CHART SPECIFICATION SHEETS -----------------------//
		d.add(6,0,'系统维护','');
		d.add(601,6,'节目状态',path + 'proProgramStatusList.jsp');
		d.add(602,6,'节目分类',path + 'programTypeList.jsp');
		d.add(603,6,'费用分类',path + 'proExpenseTypeList.jsp');
		d.add(604,6,'收视率',path + 'audienceRatList.jsp');
		d.add(605,6,'上传',path + 'audienceRatImport.jsp');			
			
		document.write(d);

		//-->
		
		
		d.openAll();
		
	</script>
	
</div>
</body>

</html>