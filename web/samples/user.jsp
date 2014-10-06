<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="userList.title"/></title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />


<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/sample/userTree.js'/>"></script>


<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>


<content tag="heading"><fmt:message key="userList.heading"/></content>
<meta name="menu" content="UserMenu"/>

          	<table width="50%" border="0" cellpadding="0" cellspacing="0">
              <tr>
              	<td width="1%"></td>
              	<td width="15%" align="left">
              				<div id="userTreebox" 
							 style="width:50%; 
							 height:200px;
							 background-color:#CCCCCC;
							 border :1px solid Silver;"/>
							<iframe name="actionframe" id="actionframe" frameborder="0" width="100%" height="0"></iframe>
				 </td>		
              </tr>
            </table>

            
            
							 
							 

<script type="text/javascript">
    highlightTableRows("userList");
</script>
