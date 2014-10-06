<!-- HTTP 1.1 -->
        <meta http-equiv="Cache-Control" content="no-store"/>
<!-- HTTP 1.0 -->
        <meta http-equiv="Pragma" content="no-cache"/>
<!-- Prevents caching at the Proxy Server -->
        <meta http-equiv="Expires" content="0"/>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/sysParam.jsp" %>

<title><fmt:message key="userList.title"/></title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />


<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>

<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/DateUtil.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>
<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>


<script type="text/javascript" src="<c:url value='/scripts/class/address.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/admin/updatePasswordService.js'/>"></script>

<meta name="menu" content="OrgMenu"/>

  <!-- style type='text/css'>
  body { 
	  background: url('<c:url value='/images/body_bg.jpg'/>') repeat; 
		margin:0;
		padding:0;
  }
  </style -->

<body>
           <BR>
           <BR>
           <BR>
            <!--   table start -->
		 <table width="50%" border="0" align="center" cellpadding="0" cellspacing="1" >
	     			
						  <tr> <!-- 用户名 -->
	                        <td  aling="right" ><fmt:message key="userForm.username"/></td>
	                        <td aling="left"><input type="text" id="username" value="<authz:authentication operation="username"/>"> 
	                        </td>
	                      </tr>
	                      
	  					  <tr> <!-- 旧密码 -->
	                        <td><fmt:message key="userForm.oldPassword"/></td>
							<td><input type="password" id="oldPassword"></td>
	                       </tr>  	                      

	  					  <tr> <!-- 新密码 -->
	                        <td  aling="right"><fmt:message key="userForm.newPassword"/></td>
							<td aling="left"><input type="password" id="newPassword"></td>
	                       </tr>  	                                          

						  <tr><!--确认密码-->
						      <td  aling="right"><fmt:message key="userForm.confirmPassword"/></td>	
						      <td aling="left"><input type="password" id="confirmPassword"></td>
						  </tr>

	                  </table>
	                  
	                 <center>
	                 <br>
	                 
	                 <input style="CURSOR: pointer;" type="hidden"  id="btn_mody" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.confim"/>&nbsp;&nbsp;&nbsp;&nbsp;'>

                     <!-- input style="CURSOR: pointer;" type="button" id="btn_close" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.cancel"/>&nbsp;&nbsp;&nbsp;&nbsp;' -->
                    
	            	
           
            <!--   table end -->
            
            
  </body>
	
	


