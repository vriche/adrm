<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title><fmt:message key="contractTargetMonthForm.targetInfo"/></title>


<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
<script type='text/javascript' src='/adrm/dwr/engine.js'></script>
<script type='text/javascript' src='/adrm/dwr/util.js'></script>
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/theme.css'/>" />



<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/contractTargetMonth.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/ContractTargetMonthManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/contract/contractTargetMonthService.js'/>"></script>


</head>

<body>



<table class=ListShort width="100%" cellpadding="0" >
			              <thead>
			                <TR class=Header> 
			                
					          <div id="hiddenArea" name="hiddenArea" style="display:none">
					 				<adrm_order:selectList name="monthDates" key="10" toScope="page"/> 
						                <html:select property="monthDate" styleId="monthDate" name="monthDate"  value=""> 
							                <html:option value=""/> 
							                <html:options collection="monthDates" property="value" labelProperty="label"/> 
					                </html:select>   
					                
					 				<adrm_order:selectList name="yearDates" key="19" toScope="page"/> 
						                <html:select property="yearDate" styleId="yearDate" name="yearDate"  value=""> 
							                <html:option value=""/> 
							                <html:options collection="yearDates" property="value" labelProperty="label"/> 
					                </html:select>                                            
					           </div>  
			                
			                
			                  <!--序号-->
			                  <TH><fmt:message key="contractTargetMonthForm.yearDate"/></TH>
			                  <TH><fmt:message key="contractTargetMonthForm.monthDate"/></TH>
			                  <TH><fmt:message key="contractTargetMonthForm.target"/></TH>
			                  <TH><fmt:message key="contractTargetMonthForm.monthReal"/></TH>
			                  
			                  <TH id="button_add_new_obj"  style="cursor:hand" colspan="4" onclick="button_add_new_obj(0)"> 
			                  		<img id="orderImgAdd" name="orderImgAdd"  src="../image/CRM_ADD.GIF" border="0"> 
			                  </TH>
			                  
			                </TR>
			                
			                  <tr > 
				                  <td colspan="7">
					                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                      <tr> 
					                        <td class=blackLine><IMG src="../image/s.gif"  width=1 height=1></td>
					                      </tr>
					                    </table>
				                    </td>
				              </tr>
				              
			              
			              <tbody id="contractTargetMonthBody"/>
			              
			              </thead>
				          <tbody>
				          <tr height="20"><td colspan="7">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
						  				 <tr>
							  				 	 <td colspan="2"><IMG src="../image/s.gif"  width="100%" height="2">
							  				 	 </td>
							  				 </tr>
					                        <tr  bgcolor="#D8DFE7">
					                          <td align="right"> 
					                              <div id="pageInfocontractTargetMonth"></div>
					                          </td>
					                     	</tr>
							  </table>
				          </tr>
				          </tbody>
				          
				          </table>
</body>
</html>