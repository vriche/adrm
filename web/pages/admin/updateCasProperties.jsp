<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<%@ include file="/common/taglibs.jsp"%>

<title>CAS</title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/prototypeUI/ptotoyeUI.css'/>" / >

<script type="text/javascript" src="<c:url value='/dwr/interface/CronTriggerRunnerManager.js'/>"></script>
<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>

<script type="text/javascript" src="<c:url value='/scripts/admin/updateCaspropertService.js'/>"></script>



<content tag="heading">CAS</content>
<ul>


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


				<table width="100%" border="0" cellpadding="0" cellspacing="0">
				   <tr> 
				   	<td width="50%">	    
				
						<table width="20%" border="0" cellspacing="0" cellpadding="0">
							<tbody>
								 <tr><td>
								 	启 用：<input id="startup" type="checkbox" value="0">
								 </td></tr>
             						<tr><td> &nbsp;&nbsp; </td></tr>
							         <tr><td>
							         	从 LDAP 导入：<input id="ldap" type="checkbox" value="0">
							         </td></tr>
							<tr><td> &nbsp;&nbsp; </td></tr>       
							         <tr><td>登录 URL</td></tr>
							         <tr><td><input name="casLoginUrl" id="casLoginUrl" type="text" style="CURSOR: pointer;width:300px;height:15px" size="20"></td></tr>
							<tr><td> &nbsp;&nbsp; </td></tr>   
							         <tr><td>注销 URL</td></tr>
							         <tr><td><input name="casLogoutUrl" id="casLogoutUrl" type="text" style="CURSOR: pointer;width:300px;height:15px" size="20"></td></tr>
							<tr><td> &nbsp;&nbsp; </td></tr>    
							         <tr><td>服务器名称</td></tr>
							         <tr><td><input name="casServerName" id="casServerName" type="text" style="CURSOR: pointer;width:300px;height:15px" size="20"></td></tr>
							<tr><td> &nbsp;&nbsp; </td></tr>     
							         <tr><td>服务器 URL</td></tr>
							         <tr><td><input name="casServiceUrl" id="casServiceUrl" type="text" style="CURSOR: pointer;width:300px;height:15px" size="20"></td></tr>
							<tr><td> &nbsp;&nbsp; </td></tr>  
							         <tr><td>验证 URL</td></tr>
							         <tr><td><input name="casValidateUrl" id="casValidateUrl" type="text" style="CURSOR: pointer;width:300px;height:15px" size="20"></td></tr>
							<tr><td> &nbsp;&nbsp; </td></tr>   
							</tbody>
					 	</table>
				   	</td>
				   </tr>
				 </table>
		
		&nbsp;&nbsp;
		
				<table width="26%" border="0" cellspacing="0" cellpadding="0">
					 <tr>
						<td>
							<div align="center">
							   <input style="CURSOR: pointer;" type="button"  id="btn_mody" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.confim"/>&nbsp;&nbsp;&nbsp;&nbsp;'>
					        	</div>
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
