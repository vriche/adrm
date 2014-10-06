<%@ include file="/common/taglibs.jsp"%>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title><fmt:message key="advTypeProductRelIncome.title"/></title>
<content tag="heading"><fmt:message key="advTypeProductRelIncome.title"/></content>

<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>



</head>

<body onload="resetHeight()">

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
	String userName = url.substring(url.lastIndexOf("@")+1,url.lastIndexOf("*"));
	String channelModel = url.substring(url.lastIndexOf("*")+1,url.length());
	
	String userId1 = userId.equals("null")?null:userId;
	String carrierName1 = carrierName.equals("null")?null:carrierName;
	
	ArrayList nameList = jFreeChart.getAdvTypeName(userName,channelModel,startDate,endDate,userId1,carrierName1);
	
	String cusName = request.getParameter("hitAdvTypeName");
	if (cusName == null) cusName = "All";
	
	String dName = null;

	dName = cusName;

	String filename = jFreeChart.advTypeProductRelChart(channelModel,dName,startDate,endDate,userId1,carrierName1,userName,session,new PrintWriter(out));
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
                    
								<table border="0" cellpadding="0" cellspacing="0" 

width="100%">
								
									<form method=POST action="">
										<tr>						

				
											<td>
												<b><fmt:message key="chooseAdvTypeName"/>:</b>
												<select name=hitAdvTypeName class=pullDown style="width:80px;">
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



			<table width="100%" border="0">
			  <tr>
			    <td>
					<table border = "0" id="grafTable">
						<tr>
							<td width=60><img src="images/spacer.png" width=170 height=1></td>
							<td>
								<table border=0>
									<tr><td width=170 align=center><b><fmt:message 

key="orderDayInfoForm.bankroll"/></b></td></tr>
									<tr><td>
									<div id="jfchart" 

style="position:relative;overflow:auto;width:900px;height:365px;visibility:inherit;border:solid white 2px;background-

color:#f5f5f5;z-

index:0">
										<img id="bankroll_img" src="<%= graphURL %>"  

 border=0 usemap="#<%= filename %>">
									</div>	
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

</body>

<script>
   	var dialogcontent = $("dialogcontentDiv");
    var bankroll_img = $("bankroll_img");
    bankroll_img.style.height = dialogcontent.offsetHeight * 0.86 +"px";
    bankroll_img.style.width = dialogcontent.offsetWidth * 0.9 +"px";
</script>



</html>