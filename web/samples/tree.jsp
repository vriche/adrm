<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="sysResourceList.title"/></title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />


<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/branch.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/admin/sysResource.js'/>"></script>


<script type="text/javascript" src="<c:url value='/dwr/interface/BranchManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>



<content tag="heading"><fmt:message key="sysResourceList.heading"/></content>
<meta name="menu" content="SysResourceMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editSysResource.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>


	<table  id="orderDetailTable" class=ListShort width="100%" cellpadding="0" >
              <thead>
                <TR class=Header> 
                  <!--编号-->
                  <TH><fmt:message key="orderDetailForm.tb.number"/></TH>
                  <!--位置-->
                  <TH><fmt:message key="orderDetailForm.tb.pos"/></TH>
                  <!--版本-->
                  <TH><fmt:message key="orderDetailForm.tb.ver"/></TH>
                  <!--长度-->
                  <TH><fmt:message key="orderDetailForm.tb.len"/></TH>
                  <!--开始日期-->
                  <TH><fmt:message key="orderDetailForm.tb.start"/></TH>
                  <!--结束日期-->
                  <TH><fmt:message key="orderDetailForm.tb.end"/></TH>
                  <!--次数-->
                  <TH><fmt:message key="orderDetailForm.tb.tim"/></TH>
                  <TH id="button_add_new_branch"  style="cursor:hand" colspan="2" onclick="button_add_new_branch(0)"> 
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
              <tbody id="branchBody"/>
	</table>  
	
	
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  				    <tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
	                        <tr  bgcolor="#D8DFE7"> 
	                          <td align="right"> 
	                              <div id="pageInfo_target"></div>
	                          </td>
	                      </tr>
	  </table>	 
	  
	  
	  
	 <br> 
	 
	 
	 
	 	<table  id="orderDetailTable" class=ListShort width="100%" cellpadding="0" >
              <thead>
                <TR class=Header> 
                  <!--编号-->
                  <TH><fmt:message key="orderDetailForm.tb.number"/></TH>
                  <!--位置-->
                  <TH><fmt:message key="orderDetailForm.tb.pos"/></TH>
                  <!--版本-->
                  <TH><fmt:message key="orderDetailForm.tb.ver"/></TH>
                  <!--长度-->
                  <TH><fmt:message key="orderDetailForm.tb.len"/></TH>
                  <!--开始日期-->
                  <TH><fmt:message key="orderDetailForm.tb.start"/></TH>
                  <!--结束日期-->
                  <TH><fmt:message key="orderDetailForm.tb.end"/></TH>
                  <!--次数-->
                  <TH><fmt:message key="orderDetailForm.tb.tim"/></TH>
                  <TH id="button_add_new_branch"  style="cursor:hand" colspan="2" onclick="button_add_new_branch(1)"> 
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
              <tbody id="branchBody2"/>
	</table>  
	
	
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  				    <tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
	                        <tr  bgcolor="#D8DFE7"> 
	                          <td align="right"> 
	                              <div id="pageInfo_target2"></div>
	                          </td>
	                      </tr>
	  </table>	 
	  
	  
	  
	  
	  
	                                     
            
            

<display:table name="sysResourceList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="sysResourceList" pagesize="25" class="tableDisplay sysResourceList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editSysResource.html" paramId="id" paramProperty="id"
        titleKey="sysResourceForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="sysResourceForm.name"/>		<!--name--> 
    <display:column property="resType" sortable="true" headerClass="sortable"
         titleKey="sysResourceForm.resType"/>		<!--resType--> 
    <display:column property="resString" sortable="true" headerClass="sortable"
         titleKey="sysResourceForm.resString"/>		<!--resString--> 
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="sysResourceForm.memo"/>		<!--memo--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="sysResourceForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="sysResourceForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="sysResourceForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="sysResourceForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="sysResource"/>
    <display:setProperty name="paging.banner.items_name" value="sysResources"/>
</display:table>


          	<table width="50%" border="0" cellpadding="0" cellspacing="0">
              <tr>
              	<td width="1%"></td>
              	<td width="15%" align="left">
              				<div id="branchTreebox" 
							 style="width:50%; 
							 height:200px;
							 background-color:#f5f5f5;
							 border :1px solid Silver;"/>
							<iframe name="actionframe" id="actionframe" frameborder="0" width="100%" height="0"></iframe>
				 </td>		
              </tr>
            </table>
            
            
            
          	<table width="50%" border="0" cellpadding="0" cellspacing="0">
              <tr>
              	<td width="1%"></td>
              	<td width="15%" align="left">
              				<div id="branchTreebox2" 
							 style="width:50%; 
							 height:200px;
							 background-color:#f5f5f5;
							 border :1px solid Silver;"/>
							<iframe name="actionframe" id="actionframe" frameborder="0" width="100%" height="0"></iframe>
				 </td>		
              </tr>
            </table>
            
            
							 
							 

<script type="text/javascript">
    highlightTableRows("sysResourceList");
</script>
