<%@ include file="/common/taglibs.jsp"%>
<title><fmt:message key="industryProductRelIncome.title"/></title>

<content tag="heading"><fmt:message key="industryProductRelIncome.title"/></content>



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

	//System.out.println(request.getQueryString());
	String url = request.getQueryString();

	String startDate = url.substring(url.lastIndexOf("=")+1,url.lastIndexOf("&"));
	String endDate = url.substring(url.lastIndexOf("&")+1,url.lastIndexOf("$"));
	String carrierName = url.substring(url.lastIndexOf("$")+1,url.lastIndexOf("?"));
	String userId = url.substring(url.lastIndexOf("?")+1,url.lastIndexOf("@"));
	String tOrd = url.substring(url.lastIndexOf("@")+1,url.lastIndexOf("*"));
	String channelModelParam = url.substring(url.lastIndexOf("*")+1,url.lastIndexOf("!"));
	String userName = url.substring(url.lastIndexOf("!")+1,url.length());
	
	String userId1 = userId.equals("null")?null:userId;
	String carrierName1 = carrierName.equals("null")?null:carrierName;
	
	ArrayList nameList = new ArrayList();
	if(tOrd.equals("true")){
		nameList = jFreeChart.getIndustryName(userName,channelModelParam,startDate,endDate,userId1,carrierName1);
	}
    //System.out.println("nameList = " + nameList.size());
	
	
	String cusName = request.getParameter("hitIndustryName");
	if (cusName == null) cusName = "All";
	
	String dName = null;
	dName = cusName;
	String filename ;

	if(tOrd.equals("true")){
		//System.out.println("tOrd = " + tOrd);
		filename = jFreeChart.industryProductRelChart(userName,channelModelParam,dName,startDate,endDate,userId1,carrierName1,session, new PrintWriter(out));
		//System.out.println("filename = " + filename);
	}else{
		filename = jFreeChart.industryProductRelChartTotal(userName,channelModelParam,dName,startDate,endDate,userId1,carrierName1,session, new PrintWriter(out));
	}
	
	//System.out.println("filename = " + filename);
	//System.out.println(tOrd.equals("true"));
	String graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + filename;

%>

<img src="images/top_bar.png" width=1004 height=75 border=0>


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
                    
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
								<%	if(tOrd.equals("true")){%>
									<form method=POST action="">
										<tr>										
											<td>
												<b><fmt:message key="chooseIndustryType"/>:</b>
												<select name=hitIndustryName class=pullDown style="width:80px;">
												<option>All</option>

								
								
<%				Iterator iter = nameList.listIterator();
				while (iter.hasNext()) {
					String optionName = (String)iter.next();
					if (optionName.equals(dName)) { %>
						<option selected><%= optionName %></option>
<%					} else { %>
						<option><%= optionName %></option>
<%					} %>
<%				} %>
								
								
												</select>
										
												<input type="submit" name="Submit" value="<fmt:message key="submitQuery"/>">
											</td>
												
										</tr>
									</form>
									<%}%>
								</table>
                    
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




			<table width="45%" border="0">
			  <tr>
			    <td>
					<table border = "0" id="grafTable">
						<tr>
							<td width=60><img src="images/spacer.png" width=170 height=1></td>
							<td>
								<table border=0>
									<tr><td width=170 align=center><b><fmt:message key="orderDayInfoForm.bankroll"/></b></td></tr>
									<tr><td>
										<img id="bankroll_img" src="<%= graphURL %>" width=800 height=300 border=0 usemap="#<%= filename %>">
										
									</td></tr>
								</table>	
							</td>	
						</tr>
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

<script>
   	var dialogcontent = $("dialogcontentDiv");
    var bankroll_img = $("bankroll_img");
    bankroll_img.style.height = dialogcontent.offsetHeight * 0.45 +"px";
    bankroll_img.style.width = dialogcontent.offsetWidth * 0.85 +"px";
</script>