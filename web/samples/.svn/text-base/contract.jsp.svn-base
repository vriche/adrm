<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="contractList.title"/></title>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/payment.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/target.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomePurpose.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/industry.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/contract/contract.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/ContractPaymentManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ContractTargetManager.js'/>"></script>


<content tag="heading"><fmt:message key="contractDetail.heading"/></content>
<html:form action="saveContract" method="post" styleId="contractForm" onsubmit="return validateContractForm(this)">

	<table  id="contractPaymentTable" class=ListShort width="100%" cellpadding="0" >
              <thead>
                <TR class=Header>   
                
		          <div id="hiddenArea" style="display:none">
		 				<adrm_order:selectList name="selects" key="18" toScope="page"/> 
		                     <html:select property="id" styleId="incomePurposeId" styleClass="select"> 
		                     <html:option value=""/> <html:options collection="selects" property="value" labelProperty="label"/> 
		                </html:select>
		                <html:errors property="id"/>                                               
		           </div> 
		           
		               
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
                  
                  <TH id="button_add_new_obj"  style="cursor:hand" colspan="2" onclick="button_add_new_obj(0)"> 
                  		<img id="contractPaymentImgAdd" name="contractPaymentImgAdd"  src="image/CRM_ADD.GIF" border="0"> 
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
	
	
	
	
	 <br> 
	  
	  
	  
	  
	<table  id="contractTargetTable" class=ListShort width="100%" cellpadding="0" >
              <thead>
                <TR class=Header>   
                
             	   <div id="hiddenArea" style="display:none"> 
		                
		                  <adrm_order:selectList name="carriers" key="3"  level="0" toScope="page"/> 
	                          <html:select property="id" styleId="carrierId" name="carrierId" value="0" > 
	                          <html:option value=""/> <html:options collection="carriers"  property="value" labelProperty="label"/> 
                          </html:select>
                          <html:errors property="id"/>
                          
                          
                          <adrm_order:selectList name="industryTypes" key="6" level="0" toScope="page"/> 
		                      <html:select property="id" styleId="industryTypeId" name="industryTypeId"  value="0" > 
		                      <html:option value=""/> <html:options collection="industryTypes"  property="value" labelProperty="label"/> 
	                      </html:select> 
	                      <html:errors property="carrierId"/>	                                                                
		           </div>  
		           
		               
                  <!--载体编号-->
                  <TH><fmt:message key="contractTargetForm.carrierId"/></TH>
                  <!--行业类型-->
                  <TH><fmt:message key="contractTargetForm.industryTypeId"/></TH>
                  <!--投放量-->
                  <TH><fmt:message key="contractTargetForm.target"/></TH>
                                    
                  <TH id="button_add_new_obj"  style="cursor:hand" colspan="2" onclick="button_add_new_obj(1)"> 
                  		<img id="contractTargetImgAdd" name="contractTargetImgAdd"  src="image/CRM_ADD.GIF" border="0"> 
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
              
              <tbody id="targetBody"/>
              
	</table>  
	
	
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  				    <tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
	                        <tr  bgcolor="#D8DFE7"> 
	                          <td align="right"> 
	                              <div id="pageInfo_target"></div>
	                          </td>
	                      </tr>
	  </table>  
 
	  
	  
</html:form>
	  
	 <br> 
							 

<script type="text/javascript">
    highlightTableRows("sysResourceList");
</script>
