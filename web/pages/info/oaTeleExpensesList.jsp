<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaTeleExpensesList.title"/></title>
<content tag="heading"><fmt:message key="oaTeleExpensesList.heading"/></content>
<meta name="menu" content="OaTeleExpensesMenu"/>


<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/oaTeleExpenses.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/OaTeleExpensesManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/info/oaTeleExpensesrService.js'/>"></script>



<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                    <td><span class="tile1">
                    
                     <a id="addNew" class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
                       
                    </span>
                    </td>
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
            
            <!--   table start -->

<table width="100%" border="1" cellpadding="0" cellspacing="0">
        <tr> 
          <td width="30%"> 
			          	<table id="oaTeleExpensesList" class=ListShort width="100%" cellpadding="0" >
			              <thead>
			                <TR class=Header> 
			                  <!--编号-->
			                  <TH><fmt:message key="oaTeleExpensesForm.id"/></TH>
			                  <!--部门名称-->
			                  <TH><fmt:message key="oaTeleExpensesForm.branchId"/></TH>
			                  <!--部门话费-->
			                  <TH><fmt:message key="oaTeleExpensesForm.expenses"/></TH>
			                  <!--登记日期-->
			                  <TH><fmt:message key="oaTeleExpensesForm.registerDate"/></TH>
			                  
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
				              
			              
			              <tbody id="oaTeleExpensesBody"/>
			              
			              </thead>
				          <tbody>
				          <tr height="20"><td colspan="11">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
						  				 <tr>
						  				 	 <td colspan="2"><IMG src="image/s.gif"  width="100%" height="2">
						  				 	 </td>
						  				 </tr>
				                        <tr  bgcolor="#D8DFE7">
				                          <td align="right"> 
				                              <div id="pageInfooaTeleExpenses"></div>
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

