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

<!-- p><a href="javascript: d.openAll();">չ������</a> | <a href="javascript: d.closeAll();">�ر�����</a></p -->

	<script type="text/javascript">
		<!--
		
		var path ="<c:url value="/"/>" +"merm/"

		    

		//id, pid, name, url, title, target, icon, iconOPne, open,

		d = new dTree('d');
		d.config.target="right";		
		d.config.folderLinks = false;
		
// ----------------- INTRODUCTION ------------------//
		d.add(0,-1,'<B>��Ŀ����</B>','','FusionCharts Free Documentation');
		
		d.add(1,0,'�ͻ�����','','Introduction','','','',false);
		d.add(101,1,'��ӿͻ�',path + 'editCustomer.jsp',' ');
		d.add(102,1,'��Ŀ��Ӧ��','customerList.jsp?type=1',' ');
		d.add(103,1,'�����Ŀ�ͻ�','customerList.jsp?type=2',' ');
		
		

// --------------- SAMPLE CHARTS -------------------- //
		d.add(2,0,'��Ŀ�ɹ�','','','',false);		
		d.add(201,2,'��ӽ�Ŀ',path + 'proProgramEdit.jsp',' ');
		d.add(202,2,'��Ŀ����',path + 'proProgramSearch.jsp',' ');
		d.add(203,2,'�����ƻ�',path + 'proPublishPlan.jsp',' ');


// ------- CREATING YOUR FIRST CHART -------------//
		d.add(3,0,'��������');
		d.add(301,3,'�ɹ�',path+'proOrderList.jsp?type=1');
		d.add(302,3,'����',path+'proOrderList.jsp?type=2');

		
// -------------------- FUSIONCHARTS AND XML ------------------//
		d.add(4,0,'�������','');
		d.add(401,4,'�������',path + 'incomePulls.jsp','');
		d.add(402,4,'Ƿ���ѯ',path + 'paymentList.jsp','');


// -------------- MECHANISM --------------		
		d.add(5,0,'ͳ�Ʒ���');
		d.add(501,5,'��Ŀ�ɱ�����',path + 'proProgramCostAnalyze.jsp',' ');
		d.add(502,5,'��Ŀ�������',path + 'proProgramIncomeAnalyze.jsp',' ');
		d.add(503,5,'��Ŀ���ӷ���',path + 'proProgramAudienceAnalyze.jsp',' ');
		d.add(504,5,'�ɱ��������ӶԱ�',path + 'proProgramCostIncomeAudienceAnalyze.jsp',' ');
 
		
// --------------------- CHART SPECIFICATION SHEETS -----------------------//
		d.add(6,0,'ϵͳά��','');
		d.add(601,6,'��Ŀ״̬',path + 'proProgramStatusList.jsp');
		d.add(602,6,'��Ŀ����',path + 'programTypeList.jsp');
		d.add(603,6,'���÷���',path + 'proExpenseTypeList.jsp');
		d.add(604,6,'������',path + 'audienceRatList.jsp');
		d.add(605,6,'�ϴ�',path + 'audienceRatImport.jsp');			
			
		document.write(d);

		//-->
		
		
		d.openAll();
		
	</script>
	
</div>
</body>

</html>