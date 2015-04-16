<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="javax.servlet.http.*" %>

<html>
<head>

</head>
<body>

<%
 String model = request.getParameter("model");
 String reportType = request.getParameter("reportType");
 
 	  if(reportType.equals("matter_report")){
 	  
	  	String name = request.getParameter("matterNameForm");
		String customerId = request.getParameter("customerIdForm");
	 	String edit = request.getParameter("matterEditForm");
	  	String matterType = request.getParameter("matterTypeForm");
			 	
	 	request.getSession().setAttribute("name",name); 
	 	request.getSession().setAttribute("customerId",customerId); 
		request.getSession().setAttribute("edit",edit);
	 	request.getSession().setAttribute("matterType",matterType);
	 }
 
	if(reportType.equals("orderList")){
		String orderStates = request.getParameter("orderStatesForm");
		String userId = request.getParameter("userIdForm");
		String customerName = request.getParameter("customerNameForm");
		String orderCode = request.getParameter("orderCodeForm");
		String contractCode = request.getParameter("contractCodeForm");
		String startDate = request.getParameter("startDateForm");
		String endDate = request.getParameter("endDateForm");
		String isArrears = request.getParameter("isArriersForm");
		String moneyRPay = request.getParameter("moneyRPayForm");
		String userName = request.getParameter("userNameForm");
		String category = request.getParameter("categoryForm");
		String matterName = request.getParameter("matterNameForm");
		String carrierId = request.getParameter("carrierIdForm");
		String relationCode = request.getParameter("relationCodeForm");
		String channelModel = request.getParameter("channelModelForm");
		String selectImportOrderForm = request.getParameter("selectImportOrderForm");
		
		request.getSession().setAttribute("relationCode",relationCode); 
		request.getSession().setAttribute("channelModel",channelModel);
		request.getSession().setAttribute("carrierId",carrierId); 
		request.getSession().setAttribute("matterName",matterName); 
		request.getSession().setAttribute("category",category); 
		request.getSession().setAttribute("userName",userName); 
		request.getSession().setAttribute("isArrears",isArrears); 
		request.getSession().setAttribute("moneyRPay",moneyRPay); 
		request.getSession().setAttribute("startDate",startDate); 
		request.getSession().setAttribute("endDate",endDate);
		request.getSession().setAttribute("orderStates",orderStates); 
		request.getSession().setAttribute("userId",userId);
		request.getSession().setAttribute("customerName",customerName); 
		request.getSession().setAttribute("orderCode",orderCode);
		request.getSession().setAttribute("contractCode",contractCode);
		request.getSession().setAttribute("selectImportOrderForm",selectImportOrderForm);
	 }
	 if(reportType.equals("customerAnalyze")){
	 	String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String userIdForm = request.getParameter("userIdForm");
		String userName = request.getParameter("userName");
		String carrierName = request.getParameter("carrierNameForm");
		String customerId = request.getParameter("customerIdForm");
		String channelModeId = request.getParameter("channelModelParam");
		String nowUser = request.getParameter("nowUser");
		String sortStr = request.getParameter("sortStr");
		String putYear = request.getParameter("putYear");
		String incomPurs = request.getParameter("incomPurs");
		String returnValue = request.getParameter("returnValue");
		
		request.getSession().setAttribute("nowUser",nowUser);
		request.getSession().setAttribute("channelModeId",channelModeId);
		request.getSession().setAttribute("customerId",customerId); 
		request.getSession().setAttribute("startDate",startDate); 
		request.getSession().setAttribute("endDate",endDate);
		request.getSession().setAttribute("userIdForm",userIdForm); 
		request.getSession().setAttribute("carrierName",carrierName);
		request.getSession().setAttribute("userName",userName); 
		request.getSession().setAttribute("sortStr",sortStr); 
		request.getSession().setAttribute("putYear",putYear); 
		request.getSession().setAttribute("incomPurs",incomPurs); 
		request.getSession().setAttribute("returnValue",returnValue); 
		
	 }	 
	 
	 
	  if(reportType.equals("carrierTarget")){
	 	String yearForm = request.getParameter("yearForm");
	 	String startDate = request.getParameter("startDate");
	 	String endDate = request.getParameter("endDate");
		String userIdForm = request.getParameter("userIdForm");
		String userName = request.getParameter("userNameForm");
		String carrierName = request.getParameter("carrierNameForm");
		String customerId = request.getParameter("customerIdForm");
		String channelModeId = request.getParameter("channelModelForm");
		String putYear = request.getParameter("putYear");
		String incomPurs = request.getParameter("purpose");
		String returnValue = request.getParameter("returnValue");
		String isDetail = request.getParameter("isDetail");
		String orgId = request.getParameter("orgIdForm");
		
		request.getSession().setAttribute("channelModeId",channelModeId);
		request.getSession().setAttribute("customerId",customerId); 
		request.getSession().setAttribute("yearForm",yearForm); 
		request.getSession().setAttribute("startDate",startDate); 
		request.getSession().setAttribute("endDate",endDate); 
		request.getSession().setAttribute("userIdForm",userIdForm); 
		request.getSession().setAttribute("carrierName",carrierName);
		request.getSession().setAttribute("userName",userName); 
		request.getSession().setAttribute("putYear",putYear); 
		request.getSession().setAttribute("incomPurs",incomPurs); 
		request.getSession().setAttribute("returnValue",returnValue); 
		request.getSession().setAttribute("isDetail",isDetail);
		request.getSession().setAttribute("orgId",orgId);
		
	 }	 
	 
	  if(reportType.equals("customerProduct")){
	 	String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String userId = request.getParameter("userId");
		String carrierIds = request.getParameter("carrierIdsForm");
	 	String userName = request.getParameter("userName");
		String isPrint = request.getParameter("isPrint");
		String channelModel = request.getParameter("channelModelForm");
		String isDetail = request.getParameter("isDetail");
		String orgId = request.getParameter("orgIdForm");
		
		request.getSession().setAttribute("orgId",orgId);
		request.getSession().setAttribute("carrierIds",carrierIds);
		request.getSession().setAttribute("channelModel",channelModel);
		request.getSession().setAttribute("isPrint",isPrint); 
		request.getSession().setAttribute("userId",userId);
		request.getSession().setAttribute("userName",userName); 
		request.getSession().setAttribute("startDate",startDate); 
		request.getSession().setAttribute("endDate",endDate);
		request.getSession().setAttribute("isDetail",isDetail);
	 }
	 
	  if(reportType.equals("orderCategoryCustomer_report")){
	 	String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String userId = request.getParameter("userId");
		String carrierIds = request.getParameter("carrierIdsForm");
	 	String userName = request.getParameter("userName");
		String isPrint = request.getParameter("isPrint");
		String channelModel = request.getParameter("channelModelForm");
		String isDetail = request.getParameter("isDetail");
		
		request.getSession().setAttribute("carrierIds",carrierIds);
		request.getSession().setAttribute("channelModel",channelModel);
		request.getSession().setAttribute("isPrint",isPrint); 
		request.getSession().setAttribute("userId",userId);
		request.getSession().setAttribute("userName",userName); 
		request.getSession().setAttribute("startDate",startDate); 
		request.getSession().setAttribute("endDate",endDate);
		request.getSession().setAttribute("isDetail",isDetail);
	 }
	 
	 if(reportType.equals("areaCustomerAnalyze_report")){
	 	String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String userId = request.getParameter("userId");
		String carrierIds = request.getParameter("carrierIdsForm");
	 	String userName = request.getParameter("userName");
		String isPrint = request.getParameter("isPrint");
		String channelModel = request.getParameter("channelModelForm");
		String yearForm = request.getParameter("yearForm");
		String isDetail = request.getParameter("isDetail");
		
		request.getSession().setAttribute("carrierIds",carrierIds);
		request.getSession().setAttribute("channelModel",channelModel);
		request.getSession().setAttribute("isPrint",isPrint); 
		request.getSession().setAttribute("userId",userId);
		request.getSession().setAttribute("userName",userName); 
		request.getSession().setAttribute("startDate",startDate); 
		request.getSession().setAttribute("endDate",endDate);
		request.getSession().setAttribute("yearForm",yearForm);
		request.getSession().setAttribute("isDetail",isDetail);
	 }
	 
	 if(reportType.equals("orderCategoryCarrier_report")){
	 	String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
	 	String customerIdsForm = request.getParameter("customerIdsForm");
	 	String yearForm = request.getParameter("yearForm");
	 	//String yearOrQuarterForm = request.getParameter("yearOrQuarterForm");
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String carrierName = request.getParameter("carrierNameForm");
		String channelModel = request.getParameter("channelModelParam");
		String sortStr = request.getParameter("sortStr");
		//String putYear = request.getParameter("putYear");
		//String incomPurs = request.getParameter("incomPurs");
		//String returnValue = request.getParameter("returnValue");
		
		request.getSession().setAttribute("startDate",startDate); 
		request.getSession().setAttribute("endDate",endDate);
		request.getSession().setAttribute("channelModel",channelModel); 
	 	request.getSession().setAttribute("customerIdsForm",customerIdsForm); 
		request.getSession().setAttribute("yearForm",yearForm);
		//request.getSession().setAttribute("yearOrQuarterForm",yearOrQuarterForm);
		request.getSession().setAttribute("userId",userId); 
		request.getSession().setAttribute("carrierName",carrierName);
		request.getSession().setAttribute("userName",userName); 
		request.getSession().setAttribute("sortStr",sortStr); 
		//request.getSession().setAttribute("putYear",putYear); 
		//request.getSession().setAttribute("incomPurs",incomPurs); 
		//request.getSession().setAttribute("returnValue",returnValue); 
	 }
	 if(reportType.equals("yearAnalyze_report")){
	    String type = request.getParameter("type");
	 	String customerIdsForm = request.getParameter("customerIdsForm");
	 	String yearForm = request.getParameter("yearForm");
	 	//String yearOrQuarterForm = request.getParameter("yearOrQuarterForm");
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String carrierName = request.getParameter("carrierNameForm");
		String channelModel = request.getParameter("channelModelParam");
		String sortStr = request.getParameter("sortStr");
		String putYear = request.getParameter("putYear");
		String incomPurs = request.getParameter("incomPurs");
		String returnValue = request.getParameter("returnValue");
		String resourceSortId = request.getParameter("resourceSortId");
		String orgId = request.getParameter("orgIdForm");
		
		request.getSession().setAttribute("type",type);
		request.getSession().setAttribute("channelModel",channelModel); 
	 	request.getSession().setAttribute("customerIdsForm",customerIdsForm); 
		request.getSession().setAttribute("yearForm",yearForm);
		//request.getSession().setAttribute("yearOrQuarterForm",yearOrQuarterForm);
		request.getSession().setAttribute("userId",userId); 
		request.getSession().setAttribute("carrierName",carrierName);
		request.getSession().setAttribute("userName",userName); 
		request.getSession().setAttribute("sortStr",sortStr); 
		request.getSession().setAttribute("putYear",putYear); 
		request.getSession().setAttribute("incomPurs",incomPurs); 
		request.getSession().setAttribute("returnValue",returnValue); 
		request.getSession().setAttribute("resourceSortId",resourceSortId); 
		request.getSession().setAttribute("orgId",orgId); 
		
	 }
	  if(reportType.equals("businessAnalyze_report")){
		String type = request.getParameter("type");
	 	String startDate = request.getParameter("startForm");
	 	String endDate = request.getParameter("endForm");
	 	String userId = request.getParameter("userId");
		String carrierName = request.getParameter("carrierNameForm");
	 	String isPutOnORIncomeForm = request.getParameter("isPutOnORIncomeForm");
	 	String userName = request.getParameter("userName");
	 	String channelModelParam = request.getParameter("channelModelForm");
	 	String sortStr = request.getParameter("sortStr");
	 	String incomPurs = request.getParameter("incomPurs");
		String returnValue = request.getParameter("returnValue1");
		String orgId = request.getParameter("orgIdForm");
		String putYear = request.getParameter("putYear");
		

		request.getSession().setAttribute("type",type);
	 	request.getSession().setAttribute("channelModelParam",channelModelParam);
	 	request.getSession().setAttribute("startDate",startDate); 
		request.getSession().setAttribute("endDate",endDate);
		request.getSession().setAttribute("isPutOnORIncome",isPutOnORIncomeForm);
		request.getSession().setAttribute("userId",userId); 
		request.getSession().setAttribute("carrierName",carrierName);
		request.getSession().setAttribute("userName",userName); 
		request.getSession().setAttribute("sortStr",sortStr); 
		request.getSession().setAttribute("incomPurs",incomPurs); 
		request.getSession().setAttribute("returnValue",returnValue); 
		request.getSession().setAttribute("orgId",orgId); 
		request.getSession().setAttribute("putYear",putYear); 
		
	 }
	 if(reportType.equals("industryTypeProduct")){
	 	String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String totalOrdetailForm = request.getParameter("totalOrdetailForm");
		String userId = request.getParameter("userId");
		String carrierName = request.getParameter("carrierNameForm");
	 	String userName = request.getParameter("userName");
		String isPrint = request.getParameter("isPrint");
		String channelModel = request.getParameter("channelModelForm");
		String isDetail = request.getParameter("isDetail");
		
		request.getSession().setAttribute("isDetail",isDetail); 
		request.getSession().setAttribute("channelModel",channelModel); 
		request.getSession().setAttribute("isPrint",isPrint); 
		request.getSession().setAttribute("userId",userId); 
		request.getSession().setAttribute("carrierName",carrierName);
		request.getSession().setAttribute("userName",userName); 
		request.getSession().setAttribute("startDate",startDate); 
		request.getSession().setAttribute("endDate",endDate);
		request.getSession().setAttribute("totalOrdetail",totalOrdetailForm);
	 }
	 if(reportType.equals("carrierBasalAnalyze")){
	 	String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String userId = request.getParameter("userId");
		String carrierName = request.getParameter("carrierNameForm");
	 	String userName = request.getParameter("userName");
		String isPrint = request.getParameter("isPrint");
		String channelModel = request.getParameter("channelModelForm");
		String isDetail = request.getParameter("isDetail");
		
		request.getSession().setAttribute("channelModel",channelModel); 
		request.getSession().setAttribute("isPrint",isPrint); 
		request.getSession().setAttribute("userId",userId); 
		request.getSession().setAttribute("carrierName",carrierName);
		request.getSession().setAttribute("userName",userName); 
		request.getSession().setAttribute("startDate",startDate); 
		request.getSession().setAttribute("endDate",endDate);
		request.getSession().setAttribute("isDetail",isDetail);
	 }
	   if(reportType.equals("carrierScopeAnalyze_report")){
	 	String startDate = request.getParameter("startForm");
		String endDate = request.getParameter("endForm");
		String carrierIds = request.getParameter("carrierIdsForm");
		String userId = request.getParameter("userId");
		
	 	String userName = request.getParameter("userName");
		String isPrint = request.getParameter("isPrint");
		String orderCategoryId = request.getParameter("orderCategoryIdForm");
		
		
		request.getSession().setAttribute("isPrint",isPrint); 
		request.getSession().setAttribute("userId",userId); 
		
		request.getSession().setAttribute("userName",userName); 
		request.getSession().setAttribute("startDate",startDate); 
		request.getSession().setAttribute("endDate",endDate);
		request.getSession().setAttribute("carrierIds",carrierIds); 
		request.getSession().setAttribute("orderCategoryId",orderCategoryId); 
		
	 }
	 if(reportType.equals("resourceAudienceAnalyze_report")){
	 	String startDate = request.getParameter("startForm");
		String endDate = request.getParameter("endForm");
		String carrierIds = request.getParameter("carrierIdsForm");
		String userId = request.getParameter("userId");
	 	String userName = request.getParameter("userName");
		String isPrint = request.getParameter("isPrint");
		
		
		
		request.getSession().setAttribute("isPrint",isPrint); 
		request.getSession().setAttribute("userId",userId); 
		request.getSession().setAttribute("userName",userName); 
		request.getSession().setAttribute("startDate",startDate); 
		request.getSession().setAttribute("endDate",endDate);
		request.getSession().setAttribute("carrierIds",carrierIds); 
	 }
	  if(reportType.equals("carrierAllYearAnalyze_report")){
	 	String carrierIdsForm = request.getParameter("carrierIdsForm");
	 	String yearForm = request.getParameter("yearForm");
	 	String userId = request.getParameter("userId");
	 	String userName = request.getParameter("userName");
		String isPrint = request.getParameter("isPrint");
		String isType = request.getParameter("isType");
		String isDetail = request.getParameter("isDetail");
		
		request.getSession().setAttribute("isPrint",isPrint); 
		request.getSession().setAttribute("userId",userId); 
		request.getSession().setAttribute("userName",userName); 
	 	request.getSession().setAttribute("carrierIds",carrierIdsForm); 
		request.getSession().setAttribute("yearForm",yearForm);
		request.getSession().setAttribute("isType",isType);
		request.getSession().setAttribute("isDetail",isDetail);
	 }
	  if(reportType.equals("income_report")){
	  	String startDate = request.getParameter("startDateForm");
		String endDate = request.getParameter("endDateForm");
		String startDatePull = request.getParameter("startDatePullForm");
		String endDatePull = request.getParameter("endDatePullForm");
	 	String customerIdForm = request.getParameter("customerIdForm");
	  	String customerName = request.getParameter("customerNameForm");
		String resourceCarrierId = request.getParameter("resourceCarrierIdForm");
		String currentUser = request.getParameter("currentUser");
		String incomePullDate = request.getParameter("incomePullDateForm");
		String orgId = request.getParameter("orgIdForm");
		String incomeCode = request.getParameter("incomeCodeForm");
			 	
	 	request.getSession().setAttribute("customerId",customerIdForm); 
	 	request.getSession().setAttribute("startDate",startDate); 
		request.getSession().setAttribute("endDate",endDate);
		request.getSession().setAttribute("startDatePull",startDatePull); 
		request.getSession().setAttribute("endDatePull",endDatePull);
	 	request.getSession().setAttribute("customerName",customerName); 
		request.getSession().setAttribute("resourceCarrierId",resourceCarrierId);		
		request.getSession().setAttribute("currentUser",currentUser);
		request.getSession().setAttribute("incomePullDate",incomePullDate); 
	    request.getSession().setAttribute("orgId",orgId);
	    request.getSession().setAttribute("incomeCode",incomeCode);
	 }
	 if(reportType.equals("advTypeProductRelIncome_report")){
	 	String startDate = request.getParameter("startForm");
		String endDate = request.getParameter("endForm");
		String userId = request.getParameter("userId");
		String carrierName = request.getParameter("carrierNameForm");
	 	String userName = request.getParameter("userName");
	 	String channelModelParam = request.getParameter("channelModelForm");
		
		request.getSession().setAttribute("channelModelParam",channelModelParam); 
		request.getSession().setAttribute("userId",userId); 
		request.getSession().setAttribute("carrierName",carrierName);
		request.getSession().setAttribute("userName",userName); 
		request.getSession().setAttribute("startDate",startDate); 
		request.getSession().setAttribute("endDate",endDate);
	 }
	 
	 if(reportType.equals("resourceLimit_report")){
	 	String startDate = request.getParameter("startDateForm");
		String endDate = request.getParameter("endDateForm");
		String carrierId = request.getParameter("carrierIdForm");
	 	String year = request.getParameter("yearForm");
	 	String type = request.getParameter("typeFrom");

		request.getSession().setAttribute("startDate",startDate); 
		request.getSession().setAttribute("endDate",endDate);
		request.getSession().setAttribute("carrierId",carrierId); 
		request.getSession().setAttribute("year",year);
		request.getSession().setAttribute("type",type);
	 }	 
	 
	 if(reportType.equals("brandAnalyze_report")){
	 	String startDate = request.getParameter("startForm");
		String endDate = request.getParameter("endForm");
		String userId = request.getParameter("userId");
		String carrierIdsForm = request.getParameter("carrierIdsForm");
		String customerIdsForm = request.getParameter("customerIdsForm");
		String matterNamesForm = request.getParameter("matterNamesForm");
	 	String userName = request.getParameter("userName");
	 	String version = request.getParameter("version");

		request.getSession().setAttribute("startDate",startDate); 
		request.getSession().setAttribute("endDate",endDate); 
		request.getSession().setAttribute("userId",userId);
		request.getSession().setAttribute("carrierIds",carrierIdsForm);
		request.getSession().setAttribute("customerIds",customerIdsForm);
		request.getSession().setAttribute("matterNames",matterNamesForm);
		request.getSession().setAttribute("userName",userName); 
		request.getSession().setAttribute("version",version); 
	 }	 
	 	
	  if(reportType.equals("financeTargetAnalyze_report")){
	 	String yearForm = request.getParameter("yearForm");
		String carrierIdsForm = request.getParameter("carrierIdsForm");
		String userNameForm = request.getParameter("userNameForm");
		String channelModelForm = request.getParameter("channelModelForm");

		request.getSession().setAttribute("yearForm",yearForm); 
		request.getSession().setAttribute("userName",userNameForm); 
		request.getSession().setAttribute("carrierIds",carrierIdsForm); 
		request.getSession().setAttribute("channelModelForm",channelModelForm); 
	 }	 
	 
	 if(reportType.equals("resourceAdverAnalyze_report")){
	 	String startDate = request.getParameter("startForm");
		String endDate = request.getParameter("endForm");
		String userId = request.getParameter("userId");
		String carrierIdsForm = request.getParameter("carrierIdsForm");
		String customerNameForm = request.getParameter("customerNameForm");
	 	String userName = request.getParameter("userName");
	 	String version = request.getParameter("version");
	 	String weekStr = request.getParameter("weekStrForm");

		request.getSession().setAttribute("startDate",startDate); 
		request.getSession().setAttribute("endDate",endDate); 
		request.getSession().setAttribute("userId",userId);
		request.getSession().setAttribute("carrierIds",carrierIdsForm);
		request.getSession().setAttribute("customerName",customerNameForm);
		request.getSession().setAttribute("userName",userName); 
		request.getSession().setAttribute("version",version);
		request.getSession().setAttribute("weekStr",weekStr); 
	 }	 
	 

 request.getSession().setAttribute("model",model); 
 request.getSession().setAttribute("reportType",reportType);

%>


<%if(model.equals("view")){%>
<APPLET  name="mytest1"  CODE ="PublishViewerApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar,report.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
    <PARAM NAME = CODE VALUE ="PublishViewerApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar,report.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">  
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../commonReport">
</APPLET>
<%}%>

<%if(model.equals("print")){%>
<APPLET  name="mytest2"  CODE ="PublishPrintApplet.class" CODEBASE ="../applets" ARCHIVE ="jasperreports-1.2.8-applet.jar,report.jar" WIDTH ="100%" HEIGHT ="100%"></XMP>
    <PARAM NAME = CODE VALUE ="PublishPrintApplet.class" >
	<PARAM NAME = CODEBASE VALUE ="../applets" >
	<PARAM NAME = ARCHIVE VALUE ="jasperreports-1.2.8-applet.jar,report.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.8">  
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME ="REPORT_URL" VALUE ="../commonReport">
</APPLET>
<%}%>
<%
if(model.equals("export")){
	response.sendRedirect("../../reports/commonReport");
}
%>




<input type="hidden" id="model" value=<%=model%>>
<!-- script>
   var model = document.getElementById("model").value;
   if(model == 'print') window.close();
</script -->


</body>
</html>