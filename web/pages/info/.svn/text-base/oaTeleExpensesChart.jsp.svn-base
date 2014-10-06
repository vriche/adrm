<%@ include file="/common/taglibs.jsp"%>
<title><fmt:message key="orderDayInfoForm.customer.title"/></title>

<content tag="heading"><fmt:message key="orderDayInfoForm.customer.title"/></content>

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


<%@ page import = "com.vriche.adrm.service.JFreeChartService" %>
<%@ page import = "java.io.PrintWriter" %>
<%@ page import = "java.text.ParseException" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.util.Iterator" %>
<%@ page import = "java.util.Locale" %>
<%@ page import = "org.springframework.context.ApplicationContext" %>
<%@ page import = "org.springframework.web.context.support.WebApplicationContextUtils" %>

<%

	ApplicationContext ctx = 
    	WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletConfig().getServletContext());

    JFreeChartService jFreeChart = (JFreeChartService)ctx.getBean("jFreeChartService");

	String url = request.getQueryString();

	String startDate = url.substring(url.lastIndexOf("=")+1,url.lastIndexOf("&"));
	String endDate = url.substring(url.lastIndexOf("&")+1,url.length());
	
	String filename = jFreeChart.teleExpensesChart(startDate,endDate,session, new PrintWriter(out));
	String graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + filename;

%>

<img src="images/top_bar.png" width=1004 height=75 border=0>
<table border = "0" id="grafTable">
	<tr>
		<td width=60><img src="images/spacer.png" width=170 height=1></td>
		<td>
			<table border=0>
				<tr><td width=170 align=center><fmt:message key="oaTeleExpensesForm.expenses"/></td></tr>
				<tr><td>
					<img src="<%= graphURL %>" width=500 height=300 border=0 usemap="#<%= filename %>">
					
				</td></tr>
			</table>	
		</td>	
	</tr>
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