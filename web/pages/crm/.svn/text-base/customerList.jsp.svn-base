<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title><fmt:message key="customerList.title"/></title>
<content tag="heading"><fmt:message key="customerList.heading"/></content>
<meta name="menu" content="CustomerMenu"/>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/category.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/linkMan.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/CategoryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/LinkManManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/order/broArrange.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/crm/customerService.js'/>"></script>




<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                    <td>
                    	<table width="100%" border="0" cellpadding="0" cellspacing="0">
                    		<tr width="1%">
                    		
                    			<td width="1px" id="orgId_td"> <select id="orgId" name="orgId"/> </td>
                   				<td width="1px" align="left"><select name="categoryRN" id="categoryRN"/></td>
							    <td width="1px"><div style="position:relative;overflow:visible"><div id="extCustomerDiv2" name="extCustomerDiv2"/></div></td>
					  			<td width="100px"><fmt:message key="customerForm.customerMainLinkMan"/>:</font></td>
			                    <td align="left" width="1px"> 
										<div style="position:relative;overflow:visible">
											<input name="linkmanName" id="linkmanName" type=text size="15" autocomplete=off>
											<div id="theDivMainLinkMan" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:150px;height:150px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
										</div>	                        
			                    </td>
			                    <td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_addNew" value='添加'></td> 
			                    <td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="btn_searche" value='查询'></td> 
			  				    <td>&nbsp;</td> 	
                 			</tr>
                 		</table>		
                    </td>
                  </tr>
                </tbody>
              </table></td>
            <td width="115"><img src="images/table1/textbox_top_right.jpg" height="27"></td>
          </tr>
        </tbody>
      </table>
    </td>
  </tr>
  <tr>
    <td><table border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td background="images/table1/textbox_left.gif" width="14"></td>
            <td bgcolor="#f4f3f4">
            
            <!--   table start -->
 
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
	        <tr> 
	          <td width="30%"> 
				          	<table id="customerList" class=ListShort width="100%" cellpadding="0" >
				              <thead>
				                <TR class=Header> 
				                  <!--客户名称-->
				                  <TH><fmt:message key="customerForm.customerName"/></TH>
				                  <!--客户-->
				                  <TH><fmt:message key="customerForm.helpCode"/></TH>
				                  <!--长度-->
				                  <TH><fmt:message key="customerForm.telephone"/></TH>
				                  <!--磁带编号-->
				                  <TH><fmt:message key="customerForm.fax"/></TH>
	
				                  <!--备注-->
				                  <TH><fmt:message key="customerForm.creditAccount"/></TH>
				                  <!--有效-->
				                  <TH><fmt:message key="customerForm.ownerAgent"/></TH>
				                  
				                  <!--备注-->
				                  <TH><fmt:message key="customerForm.customerState"/></TH>
				                  <!--有效-->
				                  <TH><fmt:message key="customerForm.customerCategoryId"/></TH>
				                  <!--版本-->
				                  <TH><fmt:message key="customerForm.customerMainLinkMan"/></TH>
				                         
				                  <!-- TH id="incomeListRow" name="incomeListRow" style="cursor:hand" colspan="2">
				                  		<fmt:message key="button.operation"/> </TH -->
				                </TR>
				                
				                  <tr> 
					                  <td colspan="11">
						                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
						                      <tr> 
						                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
						                      </tr>
						                    </table>
					                    </td>
					              </tr>
					              
				              
				              <tbody id="customerBody"/>
				              
				              </thead>
					          <tbody>
					          <tr height="20"><td colspan="11">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
							  				 <tr>
							  				 	 <td colspan="2"><IMG src="image/s.gif"  width="100%" height="2">
							  				 	 </td>
							  				 </tr>
					                        <tr  bgcolor="#eee">
					                          <td align="right"> 
					                              <div id="pageInfocustomer"></div>
					                          </td>
					                     	</tr>
								  </table>
								  </td>
					          </tr>
					          </tbody>
					          
					          </table>
					          
	          </td>
	        </tr>
	</table> 
           
            <!--   table end -->
            
            
<div style="display:none;">
customerId:<input name="customerId" type="text" id="customerId">
linkManId:<input type="text" id="linkManId">
customerCategoryId:<input name="customerCategoryId" type="text" id="customerCategoryId">
</div>            
            
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





      
<input name="customerCategoryId" type="hidden" id="customerCategoryId">  


<script type="text/javascript">
    highlightTableRows("customerList");
</script>
        