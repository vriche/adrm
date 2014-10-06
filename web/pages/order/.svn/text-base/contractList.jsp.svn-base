<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title><fmt:message key="contractList.title"/></title>
<content tag="heading"><fmt:message key="contractList.heading"/></content>
<meta name="menu" content="ContractMenu"/>

<script type="text/javascript" src="<c:url value='/dwr/interface/ContractManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CategoryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/class/contract.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/category.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/contract/contractListService.js'/>"></script>




<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
			         <td width="1px" id="orgId_td"><select id="orgId"/></td>    
					 <td width="1px"><select id="contract_year"  style="CURSOR: pointer;" /></td>	  

                    	<td width="1px">
                             <select id="contract_sort"  style="CURSOR: pointer;">
                                 <option value="">选择类型</option>
                                 <option value="1">协议</option>
						   		 <option value="0">协约合同</option>
							</select>	
						</td>  
						

				                     	
						<td width="1px"  id="TDcustomerCategorys">	<select name="customerCategorys" id="customerCategorys"/></td>
                     	<td width="1px"><select name="carrierName" id="carrierName"/></td>
                     	<td width="1px"><div name="theDivCustomerName" id="theDivCustomerName"/></td >                      	
                      	<td  width="1px" ><div id="printReportDiv" name="printReportDiv"/></td>
                      	
	   					<td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="new" value='添加'></td> 
						<td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="submitChecked" value='提交审核'></td> 
						
					    <td>&nbsp;</td> 	
                  	
            
                  </tr>
                </tbody>
              </table></td>
            <td width="115"><img src="images/table1/textbox_top_right.jpg" height="27"></td>
          </tr>
        </tbody>
      </table></td>
  </tr>
  <tr>
    <td><table border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td background="images/table1/textbox_left.gif" width="14"></td>
            <td bgcolor="#f4f3f4">


	<table class=ListShort width="100%" cellpadding="0" id="contractTable">
		<thead>
		<TR class=Header> 
		<!-- checkBox-->
		<TH><center><input type="checkBox" id="contractAllSelect"> </TH>
		<!--合同号-->
		<TH><fmt:message key="contractForm.code"/></TH>
		<!--客户名称-->
		<TH><fmt:message key="contractForm.customerId"/></TH>
		<!--客户名称-->
		<TH><fmt:message key="contractForm.contractSort"/></TH>		
		<!--签订人-->
		<TH>签订人</TH>	
		<!--已投放金额-->
		<TH><fmt:message key="contractForm.moneySum"/></TH>				
		<!--签订人-->
		<!--TH><fmt:message key="contractForm.moneyExec"/></TH -->
		<!--审核记录-->
		<TH><fmt:message key="contractForm.moneyIn"/></TH>			
		<!--开始日期-->
		<TH><fmt:message key="contractForm.startDate"/></TH>		
		<!--结束日期-->
		<TH><fmt:message key="contractForm.endDate"/></TH>
		<!--审核状态-->
		<TH><fmt:message key="contractForm.state"/></TH>
		
		
		<!-- TH width="10%"  colspan="2" onclick="button_add_new(0)"> 
		<img id="contractImgAdd" name="contractImgAdd"  src="image/CRM_ADD.GIF" border="0"> 
		</TH -->
		</TR>
			<tr > 
			<td colspan="11">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr> 
			 	<td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
			   	</tr>
			   	</table>
			</td>
			</tr>
			</thead>
			
		<tbody id="contractTbody"/>
		
		<tbody>
			<tr height="2"><td colspan="11">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
					<tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
					<tr bgcolor="#eee"> 
						<td align="right"> 
							<div id="contractPageInfo"></div>
						</td>
					</tr>
				</table>	              
			</td></tr>
		</tbody>
		              
	</table> 


            </td>
            <td width="14" background="images/table1/textbox_right.gif"></td>
          </tr>
        </tbody>
      </table></td>
  </tr>
  <tr> 
    <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tbody>
          <tr> 
            <td width="14"><img src="images/table1/textbox_bottom_left.gif" height="19" width="14"></td>
            <td width="100%" background="images/table1/textbox_bottom.gif"></td>
            <td width="14"><img src="images/table1/textbox_bottom_right.gif" height="19" width="14"></td>
          </tr>
        </tbody>
      </table></td>
  </tr>
</table>

<div style="display:none;">
customerId:<input name="customerId" type="text" id="customerId">
customerCategoryId:<input name="customerCategoryId" type="text" id="customerCategoryId">
</div>  
