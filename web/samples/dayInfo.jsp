
<%@ include file="/common/taglibs.jsp"%>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/broArrange.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/DayInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDayInfoManager.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/class/dayInfo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderDayInfo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/sample/broArrange.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/sample/dayInfoService.js'/>"></script>


<!-- link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" / -->
<!-- script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script -->
<!-- script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script -->
<!-- <script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script -->






<title><fmt:message key="orderDetail.title"/></title>

<head>
<style>
tbody .day {
/* Cells <TD> containing month days dates */
	font-family: verdana, tahoma, sans-serif;
	width: 2em;
	color: #000;
	text-align: right;
	padding: 2px 4px 2px 2px;
}
</style>


</head>
<content tag="heading"><fmt:message key="orderDetail.heading"/></content>


<table width="100%" border="1">
  <tr>
    <td>
	
	
<table width="100%" border="5" cellspacing="0" cellpadding="0">
        <tr> 
          <td><table cellspacing=0 cellpadding=0 width="100%" border=0>
              <tbody>
                <tr> 
                  <td align=left nowrap> 
                    <!--ѡ��-->
                    <fmt:message key="orderDayInfoForm.pickMonth"/>
                  </td> 
                  <td>                     
                     <select name="selectMonth" id="selectMonth"/> 
                  </td> 
                  <td>  
                    <!--�������-->
                    <input type="button" value='<fmt:message key="button.order.clean"/>' id="cleanBroArrange"> 
                    <!--�ָ�����-->
                    <input  type="button" value='<fmt:message key="orderDayInfoForm.resumeMonthInfo"/>' id="resumeBroArrange">	
                    <!--�Զ�����-->
                    <!-- input type="button"  value='<fmt:message key="button.order.autoPlay"/>' name="Submit2" -->
                    <!--��ʾ����-->
                    <!-- input  type="button" value='<fmt:message key="button.order.displayW"/>' name=cc -->
                    <!--ʣ��ʱ��-->
                    <!-- input type="button" value='<fmt:message key="button.order.releve"/>' name=c -->
                    <!--�����·�-->
                    <input  type="button" value='<fmt:message key="orderDayInfoForm.addNextMonth"/>' id="addBroArrange"> 
                    <!--��ʾʣ��ʱ��-->
                    <!-- input type="checkbox" name="isDisplayLeavTimes" id="isDisplayLeavTimes" -->
                    <!--��׼-->
                    <fmt:message  key="orderDayInfoForm.totalTime"/>: <input name="dayTotalTime" id="dayTotalTime" size="3"> 
                    <!--ռ��-->
                    <!-- fmt:message key="orderDayInfoForm.usedTimee"/ -->
                    <input name="dayUsedTime"   id="dayUsedTime" size="3" type="hidden"> 
                    <!--ʣ��-->
                    <fmt:message  key="orderDayInfoForm.leaveTime"/>: 
                    	<input name="dayLeaveTime"   id="dayLeaveTime" size="3"> 
                    <!--�ܴ���-->
                    <fmt:message key="orderDetailForm.tb.total"/>:
                     <input type="text" class="FieldxShort" id="broSumTime" name="broSumTime"   size="2"/> 
                    <!--��ʾʣ��ʱ��-->
                    <fmt:message key="orderDayInfoForm.displayLeavTimes"/> 
                    <input name="isDisplayLeavTimes" id="isDisplayLeavTimes" type="checkbox"> 
                  </td>
                  <td align="right">
						<TABLE cellSpacing=0 cellPadding=0 width=180 border=0 class="arrange">
						  <TBODY>
						  <TR>
						    <TD class=forcetime align=middle width=30><fmt:message key="orderForm.color.lable1"/></TD><!--����-->
						    <TD class=weekend   align=middle width=30><fmt:message key="orderForm.color.lable2"/></TD><!--��ĩ-->
						    <TD class=notday    align=middle width=30><fmt:message key="orderForm.color.lable3"/></TD><!--��Ч-->
						    <TD class=specific  align=middle width=30><fmt:message key="orderForm.color.lable4"/></TD><!--ָ��-->
						    <TD class=fulltime  align=middle width=30><fmt:message key="orderForm.color.lable5"/></TD><!--ռ��-->
						    <TD class=overtime  align=middle width=30><fmt:message key="orderForm.color.lable6"/></TD><!--��ʱ-->
						   </TR>
						   </TBODY>
						</TABLE>
	
                    </td>
                </tr>
                <tr> 
                  <td colspan=4><img height=1 src="image/s.gif" 
              width=1></td>
                </tr>
              </tbody>
            </table>	
	
	
	</td>
  </tr>
  <tr>
    <td>
	
				<table width="98%" border="1" id="orderDayInfoTable" cellpadding="0" cellspacing="0"  class=ListShort>
		              <tr> 
		                <!-- �����·� -->
		                <th nowrap width="5%" bgcolor="#D8DFE7" align="center"><fmt:message key="orderDayInfoForm.broMonth"/></th>
		                <!-- �������� -->
		                <% for(int i= 1; i< 32;i++){ %>
		                   <th nowrap width="22" bgcolor="#D8DFE7" align="center"><%=i%></th>
		                <%}%>
		                <!-- �ܴ��� -->
		                <th nowrap width="5%" bgcolor="#D8DFE7" align="center"><fmt:message key="orderDayInfoForm.monthTimes"/></th>
		                <!-- ������ -->
		                <th nowrap width="5%" bgcolor="#D8DFE7" align="center"><fmt:message key="orderDetailForm.sysPrice"/></th>
		                <!-- ���ۼ۸� -->
		                <th nowrap width="5%" bgcolor="#D8DFE7" align="center"><fmt:message key="orderDetailForm.execPrice"/></th>                
		              </tr>
		              <TBODY id="orderDayInfoTbody" name="orderDayInfoTbody" class="arrange"/>
		
		            </table>
            </td>
        </tr>
      </table>
	  
	  	
	
	</td>
  </tr>
</table>

<div style="display:block;">			
startDate:<input type="text" id = "broArrangeStartDate" name="broArrangeStartDate"/>
startDate:<input type="text" id = "broArrangeEndDate" name="broArrangeEndDate"/>
sumMonthBasePrice <input type="text" id = "sumMonthBasePrice" name="sumMonthBasePrice"/>
sumMonthRealPrice<input type="text" id = "sumMonthRealPrice" name="sumMonthRealPrice"/>
<input type="button" value="new orderDetail" id="addNewOrderDayInfo"> 
<input type="button" value="save orderDetail" id="saveOrderDayInfo"> 
</div>





     
















