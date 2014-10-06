<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="order.title"/></title>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/order.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderCategory.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/order/orders.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/OrderManager.js'/>"></script>


<content tag="heading"><fmt:message key="orderForm.legend1"/></content>
<html:form action="saveOrder"  method="get" styleId="orderForm" onsubmit="return validateOrderForm(this)">

	 <table  id="orderTable" class=ListShort width="100%" cellpadding="0" >
              <thead>

                <TR class=Header> 
                          
		          <div id="hiddenArea" style="display:none">
		 				 <adrm_order:selectList name="selects" key="18" toScope="page"/> 
	                     <html:select property="userId" styleId="orderRelation" style="width:137px;margin-left:-100px">
	                     	<html:option value=""/> 
	                     	<html:options collection="selects" property="value" labelProperty="label"/> 
		                 </html:select> <html:errors property="userId"/>
		                 
			 			  <adrm_order:selectList name="categoryMains" key="0"  toScope="page"/> 
	                          <html:select property="categoryId" styleId="orderCategoryMain"> 
	                          <html:option value=""/> <html:options collection="categoryMains" property="value" labelProperty="label"/> 
                          </html:select> <html:errors property="categoryId"/>                                                   
		           </div>        
                
                  <!--定单编号-->
                  <TH><fmt:message key="orderForm.orderCode"/></TH>
                  <!--关联编号-->
                  <TH><fmt:message key="orderForm.relationCode"/></TH>
                  <!--定单类别-->
                  <TH><fmt:message key="orderForm.categoryId"/></TH>
                  <!--定单备注-->
                  <TH><fmt:message key="orderForm.orderMeno"/></TH>
                  <!--合同编号-->
                  <TH><fmt:message key="orderForm.contractId"/></TH>
                  <!--业务员-->
                  <TH><fmt:message key="orderForm.userId"/></TH>
                  
                  <TH id="button_add_new_obj"  style="cursor:hand" colspan="2" onclick="button_add_new_obj(0)"> 
                  		<img id="orderImgAdd" name="orderImgAdd"  src="image/CRM_ADD.GIF" border="0"> 
                  </TH>
                </TR>
                <tr > 
                  <td colspan="10"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr> 
                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
                      </tr>
                    </table></td>
                </tr>
              </thead>
              
              <tbody id="orderBody"/>
      </table>
	
	
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		  				    <tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
	                        <tr  bgcolor="#D8DFE7"> 
	                          <td align="right"> 
	                              <div id="pageInfo_order"></div>
	                          </td>
	                      </tr>
	  </table>   
	  
</html:form>
