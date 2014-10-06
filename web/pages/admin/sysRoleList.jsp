<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="roleForm.title"/></title>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />

<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>


        <script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
                <script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>    
    <script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>

  		<script type="text/javascript" src="<c:url value='/dwr/interface/SysParamUtil.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/admin/sysParams.js'/>"></script> 
		
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>




<script type="text/javascript" src="<c:url value='/dwr/interface/RoleManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/role.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/admin/roleService.js'/>"></script>	



			<table border="0" cellpadding="0" cellspacing="0" width="100%"  id="orgId_td">
                <tbody>
                  <tr> 
                    <td ><select id="orgId"/></td>
                  </tr>
                </tbody>
              </table>	
              
              
<table class=ListShort width="100%" cellpadding="0" id="roleTable">
	              <thead>
	                <TR class=Header> 
	                  <!--名称-->
	                  <TH><fmt:message key="roleForm.name"/></TH>
	                  <!--名称-->
	                  <TH><fmt:message key="roleForm.lable"/></TH>
	                  <!--描述-->
	                  <TH><fmt:message key="roleForm.description"/></TH>
	                  <TH width="10%"  colspan="2""> 
	                  	&nbsp;
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
	              <tbody id="roleTbody"/>
	              <tbody>
	              <tr height="20"><td colspan="7">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
						<tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
						<tr > 
							<td align="right"> 
					         	<div id="rolePageInfo"></div>
							</td>
						</tr>
					</table>	              
	              </td></tr>
	               </tbody>
	              
</table> 
		
	