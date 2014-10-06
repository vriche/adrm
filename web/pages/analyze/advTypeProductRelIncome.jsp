<%@ include file="/common/taglibs.jsp"%>

<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="advTypeProductRelIncome.title"/></title>
<content tag="heading"><fmt:message key="advTypeProductRelIncome.heading"/></content>
<meta name="menu" content="CustomerMenu"/>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDetailManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customerProduct.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/analyze/advTypeProductService.js'/>"></script>


<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                  
 				      <td width="1%"><input type="text" value="开始"  width="120px" class="myLable2"/></td>
					 <td width="1%"><input type ="text" id ="beginDate" name="beginDate" size=10></td>
				
 					 <td width="1%"><input  type="text" value="结束"  size="6" class="myLable2"/></td>
					 <td width="1%"><input type ="text" id ="overDate" name="overDate" size=10></td>                   
                  
   					 <td width="1%"> <select name="userOwner" id="userOwner" /></td>
					 <td width="1%"><select name="select" id="carrierName"/></td>    
					 <td width="1%"><input type="button"   class="button" id="search" value='列表'>	</td>         
                    <td width="1%"><input type="button"   class="button" id="displayChar" value='图形'>	</td> 
                    
                     <td width="1%"><input type="button"   class="button" id="Btn_view_order" value='预览'>	</td> 
                      <td width="1%"><input type="button"   class="button" id="Btn_print_order" value='打印'>	</td> 
                       <td width="1%"><input type="button"   class="button" id="Btn_export_order" value='导出'>	</td> 
                  
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


<!--fieldset id="advType"-->
<table width="100%" border="0" cellpadding="1" cellspacing="1">
  <tr>
	<td>
			<table width="100%" border="0">
				<tr><td>
		      		<div id="advTypeProductAnalyze_div" style="height:304px;visibility:text;border:solid black 1px;background-color:white;z-index:3" >
						<table id="advTypeProductTable" class=ListShort width="100%">
							<thead>
							  <tr class=Header>
				                  <!--广告类型-->
				                  <TH><fmt:message key="agentInfoForm.advType"/></TH>
				                  <!--广告品牌-->
				                  <TH><fmt:message key="customerProductRelIncome.adverTradeMark"/></TH>
				                  <!--投放金额-->
				                  <TH><fmt:message key="orderDayInfoForm.bankroll"/></TH>
				                  <!--时间饱和度-->
				                  <TH><fmt:message key="advTypeProductRelIncome.fullTime"/></TH>
				                  <!--定单编号>
				                  <TH><fmt:message key="orderDetailForm.orderId"/></TH-->
							  </tr>
									
				                <tr > 
				                  <td colspan="4">
					                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                      <tr> 
					                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
					                      </tr>
					                    </table>
				                    </td>
				                </tr>
				              </thead>
				              
				              <tbody id="customerProductBody"/>
			              
							<tbody>
								<tr height="2"><td colspan="4">
								   <table width="100%" border="0" cellspacing="0" cellpadding="0">
						  				    <tr><td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td></tr>
					                        <tr  bgcolor="#D8DFE7"> 
					                          <td align="right"> 
					                              <div id="pageInfocustomerProduct"></div>
					                          </td>
					                      </tr>
								   </table>	  						
								</td></tr>
							</tbody>
						</table>
				</div>	
			</td></tr>
		 </table>
    </td>
  </tr>
</table>    
<!--/fieldset-->  


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


<iframe src='about:blank'   style="display:none"  scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
<form name="ReportForm" id="ReportForm" method="post">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="reportType" id="reportType" value="">
	
	<input type="hidden" name="userId" id="userId" value="">
	<input type="hidden" name="carrierNameForm" id="carrierNameForm" value="">
	<input type="hidden" name="userName" id="userName" value="">
	
	<input type="hidden" name="startForm" id="startForm" value="">
	<input type="hidden" name="endForm" id="endForm" value="">
	<input type="hidden" name="channelModelForm" id="channelModelForm" value="">
</form>