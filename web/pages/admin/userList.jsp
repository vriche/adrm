<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title><fmt:message key="userList.title"/></title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />

<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/BranchManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/FinanceTargetManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CategoryManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/popupWindow.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/toolTip.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/address.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/branch.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/financeTarget.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customerType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/category.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/role.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/RoleManager.js'/>"></script>




<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>


<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_math.js'/>"></script>




<script type="text/javascript" src="<c:url value='/scripts/common/utils.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/admin/userService.js'/>"></script>


<content tag="heading"><fmt:message key="sysResourceList.heading"/></content>
<meta name="menu" content="OrgMenu"/>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                    <td width="1px" id="orgId_td"> <select id="orgId"/></td>
                    <td width="1px" id="createOpenFireU_td" style="display:none">   <input type="button" id="createOpenFireU" value="<fmt:message key="userForm.createOpenfireUser"/>"/></td>
                    <td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_addUserr" value='添加用户'></td> 
                    <td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_branchMan" value='部门管理'></td> 
                    <td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_roleMan" value='职位管理'></td> 
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
            <td bgcolor="#f4f3f4" valign="top">

<table width="100%">
  <tr>
  
  
	<td width="20%" align="left" valign="top">

		<table width="100%"  border="0" cellpadding="0" cellspacing="0">
		  <tr> 
		    <td> <div id="sysOrgTreebox" 
					style="width:100%; 
					height:200px;
					width:100%;
					background-color:#f5f5f5;
					border :1px solid Silver;"/></td>
		  </tr>
		</table>
		
	</td>	
	
	

    <td align="middle" valign="top" >
       

 		<fieldset style="width:99%" id="userList">  
 		
 		 <div id="gridbox" width="100%" height="100%" style="background-color:white;"></div>
         <br>
	 	<table class=ListShort width="100%" cellpadding="0" id="userTable" style="display:none">
	              <thead>
	                <TR class=Header> 
	                  <!-- checkBox-->
	                  <TH><center><input type="checkBox" id="userAllSelect"> </TH>
	                  <TH><fmt:message key="userForm.username"/></TH>
	                  <TH><fmt:message key="activeUsers.fullName"/></TH>
	                  <TH><fmt:message key="userForm.email"/></TH>
	                  <TH><fmt:message key="branchForm.name"/></TH>
	                  <TH><fmt:message key="userForm.enabled"/></TH>
			          <TH>删除所在的部门</TH>
	                  <TH>编辑</TH>
	                  <TH>删除此用户</TH>
	                </TR>
	                <tr > 
	                  <td colspan="10">
		                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
		                      <tr> 
		                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
		                      </tr>
		                    </table>
	                    </td>
	                </tr>
	              </thead>
	              <tbody id="userTbody"/>
	              
	              <tbody>
	              <tr height="20">
	              
	              	
			               <td colspan="9">
			   
	              
	              
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
							<tr bgcolor="#eee"> 
								<td align="right"> 
						         	<div id="userPageInfo"></div>
								</td>
							</tr>
						</table>		              
	              </td></tr>
	              </tbody>	              

		</table> 
		
	    </fieldset>		
	    
	    	

<fieldset style="width:99%;display:none" id="userForm">
<table width="100%">
  <tr> 
    <td  valign="top">
    
		<html:form action="users.html"  target="actionframe">
		<html:hidden property="id" styleId="id"/>
		<html:hidden property="version"/>
		<input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>
		<input type="hidden" name="encryptPass" id="encryptPass" value="false"/>
		
		<!-- input type="hidden" name="orgId" id="orgId" / -->
		
		                 
                    

		
		<c:if test="${cookieLogin == 'true'}">
		    <html:hidden property="password"/>
		    <html:hidden property="confirmPassword"/>
		</c:if>
		

		<table width="100%">
		  <tr> 
		    <td align="center"> 
		    <fieldset style="width:97%">
		    <legend><fmt:message key="resourceForm.title.baseInfo"/></legend>
		   
			      <table width="100%" border="0" cellpadding="0" cellspacing="0">
	        <tr> 
	          <td width="50%"> 
					<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
	                    <tbody>
						<tr> <!-- 用户名 -->
	                        <td width="53px"><fmt:message key="userForm.username"/></td>
	                        <td width="1px"><input type="text" id="username"></td>
	                        <td>&nbsp;</td>	    
	                      </tr>
	                      <tr> <!-- 密码 -->
	                        <td nowrap="nowrap" class="requiredInput"><fmt:message key="userForm.password"/></td>
							<td><html:password property="password"  styleId="password" redisplay="true" onchange="passwordChanged(this)"/></td>
							<td>&nbsp;</td>	  
	                        </tr>
						    <tr> <!--密码提示-->
						      <td nowrap="nowrap" class="dataLabel"><fmt:message key="userForm.passwordHint"/></td>	
			         		  <td><input type="text" id="passwordHint"></td>		
			         		  <td>&nbsp;</td>	  
						    </tr>
	                      <tr> <!-- 姓 -->
 							   <td nowrap="nowrap" class="requiredInput"><fmt:message key="userForm.lastName"/></td>	
			         		   <td><input type="text" id="firstName"></td>	         
			         		   <td>&nbsp;</td>	           
					    </tr>
						<tr> <!-- 名 -->
 							   <td nowrap="nowrap" class="requiredInput"><fmt:message key="userForm.firstName"/></td>	
			         		   <td><input type="text" id="lastName"></td>	    
			         		   <td>&nbsp;</td>	                
					    </tr>
	                  </table></td>
	                <td valign="top"> 
					
					
					 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
	                    <tbody>
	                      <tr> <!-- E-Mail -->
	                        <td width="53px"><fmt:message key="userForm.email"/></td>	
	                        <td width="1px"><input type="text" id="email"></td>
	                         <td>&nbsp;</td>	    
	                      </tr>
						    <tr> <!--确认密码-->
						      <td nowrap="nowrap" class="requiredInput"><fmt:message key="userForm.confirmPassword"/></td>	
						      <td><html:password property="confirmPassword" styleId="confirmPassword" redisplay="true"/></td>
						       <td>&nbsp;</td>	    
						    </tr>
	                      </tr>
						    <tr> <!--电话-->  
						      <td nowrap="nowrap" class="dataLabel"> <fmt:message key="userForm.phoneNumber"/></td>	
						      <td><input type="text" id="phoneNumber"></td>
						       <td>&nbsp;</td>	    
						    </tr>
						    
	                      <tr> <!-- 网址 -->
	                        <td nowrap="nowrap" class="dataLabel"><fmt:message key="userForm.website"/></td>	
	                        <td><input name="text" type="text" id="website"></td>	
	                         <td>&nbsp;</td>	                            
	                      </tr>	 						    
						    
						   <tr> <!-- 部门名 -->
	                        <td nowrap="nowrap" class="dataLabel"><fmt:message key="branchForm.name"/></td>	
	                        <td><select id="branchId"/></td>	      
	                         <td>&nbsp;</td>	                      
	                      </tr>
	                      

	                      
	                    </tbody>
	                  </table>
		       </td>
	              </tr>
	            </table>
		     </fieldset>  
		    </td>
		  </tr>
		  <tr> 
		    <td align="center">
		    <fieldset style="width:97%">
		    <legend><fmt:message key="userForm.addressForm.address"/></legend>
		    
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
	        <tr> 
	          <td width="50%"> 
					<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
	                    <tbody>
						<tr> <!-- 地址 -->
	                        <td width="53px"  align="center"><fmt:message key="userForm.addressForm.address"/></td>
	                        <td width="1px"><input name="text" type="text" id="address"> <input name="country" type="hidden" id="country"></td>
	                        <td>&nbsp;</td>	   
	                      </tr>
	           
						    <!-- tr> <!--国家-->
						      <td>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="userForm.addressForm.country"/></td>
			         		   <td>
							   <div style="position:relative;">
								<span style="margin-left:100px;width:18px;overflow:hidden;">
									<adrm_order:country name="countries" toScope="page"/> 
									<html:select property="addressForm.country" style="width:140px;margin-left:-100px" styleId="country"> 
										<html:option value=""/>
										<html:options collection="countries" property="value" labelProperty="label"/>
									 </html:select> 
								</span>
							   </div>   
							   
							</td>	
							<td>&nbsp;</td>	   	
						    </tr -->
						    
						    <tr> <!-- 州省 -->
	                        <td><!-- fmt:message key="userForm.addressForm.province"/ --></td>
	                        <td><input name="text" type="hidden" id="province"></td>
	                        <td>&nbsp;</td>	   
	                        </tr>
	                      
	                  </table></td>
	                <td valign="top"> 
					
					
					 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
	                    <tbody>

						    <tr> <!--邮编-->
						      <td width="53px" align="center"><fmt:message key="userForm.addressForm.postalCode"/></td>
						      <td width="1px"><input name="text" type="text" id="postalCode">
						     	 <input type="hidden" id="city">
						      </td>
						      <td>&nbsp;</td>	  
						    </tr>   
						    
						  <!-- tr> <!-- 城市 -->
	                        <td nowrap="nowrap" class="dataLabel">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="userForm.addressForm.city"/></td>
	                        <td><input type="text" id="city"></td>
	                        <td>&nbsp;</td>	  
	                      </tr --> 
						    
						    <tr> <!--邮编-->
						      <td>&nbsp;</td>
						      <td>&nbsp;</td>
						      <td>&nbsp;</td>	  
						    </tr>                 		    
	                      
	                    </tbody>
	                  </table>
		       </td>
	              </tr>
	            </table>
	            
            
	            
			</fieldset>      
		    </td>
		  </tr>
		  
		  
	 	 <tr> 
		    <td align="center">		  
		   <fieldset style="width:97%">
		    <legend><fmt:message key="userForm.userMessageAlert"/></legend>	            
			 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="isOpenFire" name="isOpenFire">
	        	<tr>
	        	    <td width="5px">&nbsp;</td>	  
	        		<td width="70px">
						<span id="span_province2">
						<input name="text" type="checkbox" id="province2"><label for="province2" class="choice"><fmt:message key="userForm.addressForm.province2"/></label> 
						</span>
					</td>
					<td width="70px">	
		                <span id="span_province1">
						<input name="text" type="checkbox" id="province1"><label for="province1" class="choice"><fmt:message key="userForm.addressForm.province1"/></label>
						</span>				
					</td>
					<td>&nbsp;</td>
				</tr>
	          </table>            
			</fieldset>   	
			</td>
		  </tr>	  
		  
		  <tr> 
		    <td align="center">
			<fieldset style="width:97%">
			<legend><fmt:message key="userProfile.accountSettings"/></legend>
			  <table width="100%">
		        <tr>
		          <td >
			            <html:checkbox styleClass="checkbox" property="enabled" styleId="enabled"/>
			            <label for="enabled" class="choice"><fmt:message key="userForm.enabled"/></label>
				  </td>
		          <td>	
				  		<html:checkbox styleClass="checkbox" property="accountExpired" styleId="accountExpired"/>
			            <label for="accountExpired" class="choice"><fmt:message key="userForm.accountExpired"/></label></td>
		          <td>
						<html:checkbox styleClass="checkbox" property="accountLocked" styleId="accountLocked"/>
			            <label for="accountLocked" class="choice"><fmt:message key="userForm.accountLocked"/></label></td>
		          <td>
				  	    <html:checkbox styleClass="checkbox" property="credentialsExpired" styleId="credentialsExpired"/>
			            <label for="credentialsExpired" class="choice"><fmt:message key="userForm.credentialsExpired"/></label>
				  </td>
		        </tr>
		      </table>
			  </fieldset>
	
			  </td>
		  </tr>
		  
		  
		  
			  <tr> 
		    <td align="center">
			<fieldset style="width:97%">
		    <legend>权限</legend>
			<table width="100%">
		        <tr>
		            <td width="2px">&nbsp;</td> 	
		            <td width="1px"><input type="button"    class="button" style="width:90px;" id="Btn_select_user_rel" value='管理用户授权'></td> 
                    <td width="1px"><input type="button"    class="button" style="width:90px;" id="Btn_select_carrier_rel" value='频道授权'></td> 
                    <td width="1px"><input type="button"    class="button" style="width:90px;" id="Btn_select_customer_rel" value='用户与客户关系'></td> 
                    <td width="1px"><input type="button"    class="button" style="width:90px;" id="Btn_user_year_rel" value='订单年份授权'></td> 
                    <td width="1px"><input type="button"    class="button" style="width:90px;" id="Btn_user_customerType_rel" value='客户类别授权'></td> 
                    
                     <td>&nbsp;</td> 	
		        </tr>
		      </table>
            <br>
			</fieldset>	
	
			  </td>
		  </tr>	  
		  
		  
		  
		<tr> 
		    <td align="center">
				<fieldset style="width:97%">
				    <br>
					<table width="100%">
				        <tr>
				            <td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_add_user" value='添加用户'></td> 
		                    <td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_save_user" value='保存'></td> 
		                     <td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_remove_user" value='删除'></td> 
		                     <td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_cannel_edit_user" value='返回'></td> 
		                     <td>&nbsp;</td> 	
				        </tr>
				      </table>
		            <br>
					</fieldset>	
			
					  </td>
				  </tr>	 
				</table>
				</fieldset>	
		</td>
	  </tr>
	  
	  <!-- tr> 
		    <td align="center"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_cannel_edit_user" value='返回列表'></td>
	  </tr -->	  
	  
	</table>
	</html:form>

   </td>
   
   
   <td width="10%" align="left" valign="top" id="roleTree_div" >
  
			<fieldset id="roleTable" style="width:90%;hieght:100%">
				<legend><fmt:message key="userProfile.assignRoles"/></legend>
 				<div id="roleTable_div" style="position:relative;OVERFLOW: auto;visibility:inherit;border:solid white 2px;background-color:#f5f5f5;z-index:0">
				<table width="90%"  border="0" cellpadding="0" cellspacing="0" id="tableRole">
				  <tr> 
				    <td> 
				   	 <div id="roleTree" width="100%" height="100%"/>
				    </td>
				  </tr>
				</table>
			 </fieldset> 	

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


<!--script type="text/javascript">
    Form.focusFirstElement($('userForm'));
    highlightFormElements(); 
</script -->


