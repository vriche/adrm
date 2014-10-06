<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title><fmt:message key="contractPaymentDetail.heading"/></title>


<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>


<script type="text/javascript" src="<c:url value='/dwr/interface/SysParamUtil.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/admin/sysParams.js'/>"></script>   

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>


<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />


<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/contractpayment.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomePurpose.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/specific.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDetail.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderPublic.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resourceType.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDetailManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/ContractPaymentManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceTypeManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/order/contractPaymentService.js'/>"></script>

</head>

<body>



	<table class=ListShort width="100%"  cellspacing="0" cellpadding="0">
	              <thead>
	                <TR class=Header2> 
	                
			          <div id="hiddenArea" name="hiddenArea" style="display:none">
			 				<adrm_order:selectList name="incomePurposeIds" key="18" toScope="page"/> 
			                <html:select property="incomePurposeId" styleId="incomePurposeId" name="incomePurposeId"  value="0"> 
				                <html:option value=""/> 
				                <html:options collection="incomePurposeIds" property="value" labelProperty="label"/> 
			                </html:select>                                               
			           </div> 
			           
			           
			           	<div id="hiddenArea2" name="hiddenArea2" style="display:none">           
							     <select name="select" id="resourceType"/>                                 
			           </div> 
			           
			      
			          <TH style="width:100%;heigth:100%;display:none" id="xmtvBranch"><fmt:message key='branchList.heading'/></TH>
			                           
	                  <!--次数-->
	                  <TH><fmt:message key="contractPaymentForm.payNumber"/></TH>
	                  <!--应付款日期-->
	                  <TH><fmt:message key="contractPaymentForm.payDate"/></TH>
	                  <!--付款类型-->
	                  <TH><fmt:message key="contractPaymentForm.incomeModeId"/></TH>
	                  <!--付款金额-->
	                  <TH><fmt:message key="contractPaymentForm.moneyPay"/></TH>
	                  <!--已分配金额-->
	                  <TH><fmt:message key="contractPaymentForm.moneyIn"/></TH>
	                  
	                  <TH id="button_add_new_obj"  style="cursor:hand" colspan="3" onclick="button_add_new_obj(0)"> 
	                  		<img id="orderImgAdd" name="orderImgAdd"  src="../image/CRM_ADD.GIF" border="0"> 
	                  </TH>
	                  
	                </TR>
	                
			                <tr > 
	                  <td colspan="10">
		                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
		                      <tr> 
		                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
		                      </tr>
		                    </table>
	                    </td>
	                </tr>
	              </thead>
	              
	              <tbody id="paymentBody"/>
	              
		</table>  


	   <table width="100%" border="0" cellspacing="0" cellpadding="0">
		  				    <tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
	                        <tr  bgcolor="#D8DFE7"> 
	                          <td align="right"> 
	                              <div id="pageInfo_payment"></div>
	                          </td>
	                      </tr>
	   </table>	 
	   
	   <table width="100%" border="0" cellspacing="0" cellpadding="0">
		  				    <tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
	                        <tr  bgcolor="#D8DFE7"> 
	                          <td align="center"> 
	                              <span size="5" id="persent" />
	                          </td>
	                      </tr>
	   </table>
	   
	   
	  
	   
</body>
</html>