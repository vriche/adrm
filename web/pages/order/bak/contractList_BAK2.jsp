<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="contractList.title"/></title>
<content tag="heading"><fmt:message key="contractList.heading"/></content>
<meta name="menu" content="ContractMenu"/>



<c:set var="buttons">
           <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td><div align="right"> 
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr> 
                    <td width="30%">
	                    <!--合同编号--><fmt:message key="contractForm.code"/>
	                    <input type="text" name="textfield">
	                    <!--搜 索--> 
	    				<input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'" value="<fmt:message key="button.search"/>"/>
	                    </td>
                    <td>&nbsp;</td>
                    <td> 
                    	<div align="right"> 
                        <!--查找未审-->
                        <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'" value="<fmt:message key="button.searchNoChecked"/>"/>
                        <!--提交审核-->
                        <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'" value="<fmt:message key="button.submitChecked"/>"/>
                      </div></td>
                  </tr>
                </table>
          </c:set>
          <c:out value="${buttons}" escapeXml="false"/>
              </div></td>
          </tr>
          <tr> 
            <td class=blackLine><IMG src="../image/s.gif"  width=1 height=1></td>
          </tr>
          <tr> 
              <td class=blackLine><IMG src="../image/s.gif"  width=1 height=1></td>
           </tr>
          <tr> 
            <td><TABLE class=ListShort>
                <TBODY>
                  <TR class=Header> 
                    <TH><input type="checkbox" name="checkbox2" value="checkbox"></TH>
                    <!--合同编号--><TH><fmt:message key="contractForm.code"/></TH>
                    <!--客户名称--><TH><fmt:message key="contractForm.customerId"/></TH>
                    <!--预投放总金额--><TH><fmt:message key="contractForm.moneySum"/></TH>
                    <!--已投放金额--><TH><fmt:message key="contractForm.moneyExec"/></TH>
                    <!--已分配金额--><TH><fmt:message key="contractForm.moneyIn"/></TH>
                    <!--合同开始日期--><TH><fmt:message key="contractForm.startDate"/></TH>
                    <!--合同结束日期--><TH><fmt:message key="contractForm.endDate"/></TH>
                    <TH width="10%"><fmt:message key="button.done"/><img onClick="window.location='contractEdit.htm'"  src="../image/CRM_ADD.GIF" border="0" height="14" width="14"></TH>
                  </TR>
                  	
                  	<%int i = 0;String myClass = "DataLight";%>
                  	
	                <logic:iterate id="contractList" name="contractList">

	                <% if(i++%2 == 0){myClass = "DataDark";}else{myClass = "DataLight";}%>
	                <TR class=<%=myClass%> onClick="selectpos()"> 
		                <TD  width="2%"><input type="checkbox" name="checkbox" value="checkbox"></TD>
		                <TD>
		                 	 <html:link paramId="id" paramName="contractList" paramProperty="id" page="/editContract.html">
		                 	 <bean:write name="contractList" property="code"/></html:link>
		                </TD>
	                    <TD>
		                 	<c:out value="${contractList.customer[customerName]}"/>
		                 		
		                 	<c:forEach var="ct" items="${contractList.customer}">
								<c:out value="${ct.customerName}"/>
							</c:forEach>
	                    </TD> 
						<TD><bean:write name="contractList" property="moneySum"/></TD>                 				      
	                    <TD><bean:write name="contractList" property="moneyExec"/></TD>
						<TD><bean:write name="contractList" property="moneyIn"/></TD>  
	                    <TD><bean:write name="contractList" property="startDate" format="yyyy/MM/dd hh:mm:ss"/></TD>
						<TD><bean:write name="contractList" property="endDate" format="yyyy/MM/dd hh:mm:ss"/></TD>  
						<TD width="10%">
							  <input name="imageField65525552" type="image" src="../image/button_delete.gif" width="17" height="17" border="0" >
		                      <img   style="cursor:hand" onClick="window.location='contractEdit.htm'"   src="../image/EDIT.GIF" alt="版本拆分" width="16" height="16">
                      	</TD>
					</TR>								      
				    </logic:iterate>
                </TBODY>
              </TABLE></td>
          </tr>
          <tr> 
            <td><TABLE width="100%" class=ListShort>
                <TBODY>
                  <TR class="Header"> 
                    <TD colspan="9"><div align="right">共2条记录 第1/1页 首页 尾页 跳转到 
                        <select name="select">
                          <option selected>1</option>
                          <option>2</option>
                          <option>3</option>
                        </select>
                        页 </div></TD>
                  </TR>
                </TBODY>
              </TABLE></td>
          </tr>
          <tr> 
            <td>&nbsp;</td>
          </tr>
        </table>

	
					        
<br>
<display:table name="contractList" cellspacing="0" cellpadding="0" requestURI="" 
    defaultsort="1" id="users" pagesize="25">
    <display:column property="code" titleKey="contractForm.code" />
    <display:column property="customer[accountAddress]" titleKey="contractForm.customerId"/>
</display:table>
				        

<script type="text/javascript">
    highlightTableRows("contractList");
</script>
