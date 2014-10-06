<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="sysResourceList.title"/></title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />

<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/RoleManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/SysResourceManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_math.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/role.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/address.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/sysResource.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/admin/permitService.js'/>"></script>



<content tag="heading"><fmt:message key="sysResourceList.heading"/></content>
<meta name="menu" content="SysResourceMenu"/>

<html:form action="sysResources.html"  target="actionframe">

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                    <td id="orgId_td" width="1px"><select id="orgId"/></td>
                    
                     <c:if test="${pageContext.request.remoteUser == 'admin'}">
                   	  <td width="1px"><input type="button"    class="button" style="width:120px;" id="Btn_load_default" value='载入默认权限列表'></td> 
                      </c:if>  
                    <td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_roleMan" value='职位管理'></td>   
                    
                    <td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_save_role_user_res" value="保存"></td>
    
     				<td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_del_res" value="删除"></td>
                                    
                  	<td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Btn_add_res" value="新添"></td>
                       
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


<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
	<td width="20%" align="left"  valign="top">

		<table width="100%" >
		  <tr> 
		    <td  valign="top" aligm="middle">
			<fieldset style="width:99%">
				<table width="100%">
					<tr> 
					   <td>&nbsp;</td>
					  <td><input type="radio" name="radioRole" id="radioResources"  checked>
						<label for="radioResources"><fmt:message key="sysResourceList.heading"/></label></td>
					  <td><input type="radio" name="radioRole" id="radioUsers">
						<label for="radioUsers"><fmt:message key="branchForm.users"/></label></td>
					</tr>
				  </table>	
			</fieldset>
			</td>
		  </tr>
		  <tr> 
		    <td> <div id="roleTreebox" 
					style="width:100%; 
					height:500px;
					background-color:#f5f5f5;
					border :1px solid Silver;"/></td>
		  </tr>
		</table>
		
	</td>	

    <td align="top" valign="top">
    
  	 	<table class=ListShort width="100%" cellpadding="0" id="sysResourceTable" style="display:none">

	              <tr height="20"><td>
		              <div id="gridbox2" width="100%" height="100%" style="background-color:white;"></div>
	              </td></tr>
  
		</table>         

        
	 	<table class=ListShort width="100%" cellpadding="0" id="sysResourceTable"  style="display:none">
	 	

	 	
	              <thead>
	                <TR class=Header> 
	                  <!-- checkBox-->
	                  <TH><center><input type="checkBox" id="sysResourceAllSelect"> </TH>
	                  <!--名称-->
	                  <TH><fmt:message key="sysResourceForm.name"/></TH>
	                  <!--类型-->
	                  <TH><fmt:message key="sysResourceForm.resType"/></TH>
	                  <!--资源-->
	                  <TH><fmt:message key="sysResourceForm.resString"/></TH>
	                  <!--备注-->
	                  <TH><fmt:message key="sysResourceForm.memo"/></TH>
	                  <TH width="10%"  colspan="2" onclick="button_add_new(0)"> 
	                  <img id="orderDetailImgAdd" name="orderDetailImgAdd"  src="image/CRM_ADD.GIF" border="0"> 
	                  </TH>
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
	              
	              <tbody id="sysResourceTbody"/>
	              <tbody>
	              <tr height="20"><td colspan="7">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
						<tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
						<tr bgcolor="#eee"> 
							<td align="right"> 
					         	<div id="sysResourcePageInfo"></div>
							</td>
						</tr>
					</table>	              
	              </td></tr>
	               </tbody>
	              
		</table> 
	   
 	
		
		
        
	 	<table class=ListShort width="100%" cellpadding="0" id="userTable" style="display:none">

	              <tr height="20"><td>
		              <div id="gridbox" width="100%" height="100%" style="background-color:white;"></div>
	              </td></tr>
  
		</table>        
		
	 	<table class=ListShort width="100%" cellpadding="0" id="userTable2" style="display:none">
	              <thead>
	                <TR class=Header> 
	                  <!-- checkBox-->
	                  <TH><center><input type="checkBox" id="userAllSelect"> </TH>
	                  <TH><fmt:message key="userForm.username"/></TH>
	                  <TH><fmt:message key="activeUsers.fullName"/></TH>
	                  <TH><fmt:message key="userForm.email"/></TH>
	                  <TH><fmt:message key="userForm.enabled"/></TH>
	                  <TH width="10%"  onclick="button_add_new(1)"  colspan="2"> 
	                  
	                  </TH>
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
	              <tr height="20"><td colspan="7">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr><td colspan="3"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
							<tr bgcolor="#D8DFE7"> 
								<td align="right"> 
						         	<div id="userPageInfo"></div>
								</td>
							</tr>
						</table>		              
	              </td></tr>
	              </tbody>	              
	              
	              
	              
		</table> 
	   
	    <!--page info-->
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
			<tr bgcolor="#D8DFE7"> 
				<td align="right"> 
		         	<div id="userPageInfo"></div>
				</td>
			</tr>
		</table>			
		
	
	<fieldset style="width:99.5%">
	   
	    
	 	<table  width="100%" cellpadding="0" >
	              <tr>
	                 <td width="50px">资源名称</td>
	                 <td width="1px"><input name="name" id="name" type="text" size="35"></td>
	                 <td width="50px">资源类型</td>
	                 <td width="1px">
	                               <select id="resType" style="CURSOR: pointer;width:50px;" >
										<option value="URL">URL</option>
										<option value="TAG">TAG</option>
										<option value="METHOD">METHOD</option>
									</select>
					</td>
	                 <td width="50px">系统资源</td>
	                 <td  width="1px"><input name="resString" id="resString" type="text" ></td>
	             	 <td width="25px">备注</td>
	                 <td width="1px">
		              	<input name="memo" id="memo" type="text" style="CURSOR: pointer;width:116px;height:15px" size="120">
	                </td>
	                <td><input name="id" id="id" type="hidden"></td>
	                <td>&nbsp;</td>
	                
	              </tr>

  
		</table>   	 
		   

	</fieldset>	
	    
    		<!-- table  width="100%" cellpadding="0" >
	              <tr>
	                 <td  align="center">
		               <input type="button"    class="button" style="CURSOR: pointer;" id="Btn_save_role_user_res" value="保存">
	                </td>
	              </tr>
 
		   </table -->   	
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
	</html:form>



