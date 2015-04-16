<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<head>
    <title><fmt:message key="mainMenu.title"/></title>
    <content tag="heading">&nbsp;</content>
    <meta name="menu" content="MainMenu"/>
    
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/sdmenu.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/lytebox.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/prototypeUI/ptotoyeUI.css'/>" / >

<script type="text/javascript" src="<c:url value='/scripts/prototypeUI/window.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/prototypeUI/utils.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/winjs/effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_ext.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/debug.js'/>"></script>




<script type="text/javascript" src="<c:url value='/scripts/common/popupWindow.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/popupWindow.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/dwr-lib.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/extutils.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/class/oaInfo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/order.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resourceType.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/OrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/sdmenu.js'/>"></script>  
<script type="text/javascript" src="<c:url value='/scripts/lytebox.js'/>"></script>  
<script type="text/javascript" src="<c:url value='/scripts/admin/mainMenu.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/extutils.js'/>"></script>	


<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceTypeManager.js'/>"></script>





<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/ComboBoxTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/MessageBox.js'/>"></script>


    
</head> 
<!-- p><fmt:message key="mainMenu.message"/></p -->





<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                    <td><span class="tile1"></span>
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
 


<table width="100%" border="0" >
  <tr>
    <td width="80%" id="main_page_fram"  align="center" valign="center">
	    
	    <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
	        <tr> 
	          <td><div align="center"><img src="image/main/customer.png" onclick="window.location.href='customers.html'" width="100" height="100" style="cursor: pointer;"></div></td>
	          <td><div align="center"><img src="image/main/documents.png" onclick="window.location.href='contracts.html'" width="100" height="100" style="cursor: pointer;"></div></td>
	          <td><div align="center"><img src="image/main/order.png"  onclick="window.location.href='orders.html'" width="100" height="100" style="cursor: pointer;"></div></td>
	          
	        </tr>
	        <tr> 
	          <td><div align="center"><strong><font size="4"><strong><fmt:message key="customer.info"/></strong></font></strong></div></td>
	          <td><div align="center"><strong><font size="4"><strong><fmt:message key="contractTargetDetail.heading"/></strong></font></strong></div></td>
	          <td height="57"> <div align="center"><font size="4"><strong><fmt:message key="customerForm.tabs.orders"/></strong></font></div></td>
	          
	        </tr>
	        <tr> 

			   	
	        <td><div align="center"><img id="main_menus_fince_img" src="image/main/finace.png" onclick="window.location.href='<adrm_order:authorizeTag res="tag_role_fince">incomes.html</adrm_order:authorizeTag>'" width="100" height="100" style="cursor: pointer;"></div></td>
			 
			   	
		<!-- td><div align="center"><img src="image/main/finace.png" onclick="window.location.href='incomes.html'" width="100" height="100" style="cursor: pointer;"></div></td -->
			 	
			     
	        
	        

	          <td><div align="center"><img id="main_menus_arrange_img" src="image/main/matter.png" onclick="window.location.href='<adrm_order:authorizeTag res="tag_publish_arrange">publishArranges.html</adrm_order:authorizeTag>'" width="100" height="100" style="cursor: pointer;"></div></td>
	          <td><div align="center"><img src="image/main/analyze2.png" onclick="window.location.href='oaWorkFlowChecks.html'" width="100" height="100" style="cursor: pointer;"></div></td>
	        </tr>
	        <tr> 
	          <td><div align="center"><strong><font size="4"><strong><fmt:message key="mainMenu.incomeIn"/></strong></font></strong></div></td>
	          <td height="40"><div align="center"><strong><font size="4"><strong><fmt:message key="mainMenu.adverEdit"/></strong></font></strong></div></td>
	          <td><div align="center"><strong><font size="4"><strong><fmt:message key="mainMenu.workFlowCheck"/></strong></font></strong></div></td>
	        </tr>
	      </table> 
      
    </td>
    <td align="center" valign="top">
    
          <!-- 日期 -->
	      <table width="100%"  border="0">

	        <tr> 
	          <td>
		        <div id="display" style="float: right; clear: both; width:100%;"></div>   
		  	  </td>
	        </tr>
	        
	        
	   <tr> 
	          <td>       
	          
	           
	         <div style="float: left" id="my_menu" class="sdmenu">
		      <div onclick="getOaInfoSelect(this)" class="collapsed">
		        <span>最新通知</span>
		        <lable id="selectNotice"></lable>
		      </div>
		      <div id="evenId" onclick="getOrders(this)" class="collapsed">
		        <span>事件提示</span>
			<lable id="checkNotic"></lable>
		      </div>
		      <div>
		        <span>个人工具</span>
				<a href="#" id="btn_modifyPwd">修改密码</a>
				<a href="#" id="btn_calculator">资源查询</a>
				<a href="#" id="btn_contractPayment">催款信息</a>
				<a href="#" id="btn_fastSignOrder">快速下单</a>
		      </div>
		      
		      
		      
		      
		 </div>
		    
    	  </td>
	        </tr>
    
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


<div id="hello-win2" class="x-hidden"/>

 <input type="hidden" id="contPath" value="<c:url value="/"/>">	
 <input id="tag_orderList_finance" type="hidden" value="0">
 <adrm_order:authorizeTag res="tag_orderList_finance">
	<script>$("tag_orderList_finance").value = 1 ;</script>
</adrm_order:authorizeTag>