<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="mediaOrgList.title"/></title>

<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/admin/mediaOrgService.js'/>"></script>	


<content tag="heading"><fmt:message key="mediaOrgList.heading"/></content>
<meta name="menu" content="MediaOrgMenu"/>


<html:form action="mediaOrgs" method="get"  styleId="mediaOrgForm" >

                          <c:set var="buttons">
							    <input type="button" style="margin-right: 5px"
							        onclick="location.href='<c:url value="/editMediaOrg.html"/>'"
							        value="&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;"/>
							</c:set>
							
							

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                  
                    <td>
                    	<c:out value="${buttons}" escapeXml="false"/>
                     </td>
                     
                     <td width="1px" id="orgId_td"> <select id="orgId" name="orgId"/> </td>
                    
                     <td width="100%">&nbsp;&nbsp;</td>
                    
                    
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
 
		<display:table name="mediaOrgList" cellspacing="0" cellpadding="0"
		    id="mediaOrgList" pagesize="25" class="tableDisplay mediaOrgList"
		    export="true" requestURI="">
		
		    <display:column property="name" sortable="true" headerClass="sortable"
		        url="/editMediaOrg.html" paramId="id" paramProperty="id"
		        titleKey="mediaOrgForm.name"/>
		        
		    <display:column property="value" sortable="true" headerClass="sortable"
		         titleKey="mediaOrgForm.value"/>

		    <display:column property="memo" sortable="true" headerClass="sortable"
		         titleKey="mediaOrgForm.memo"/>
		         
		    <display:column property="enable" sortable="true" headerClass="sortable"
		         titleKey="mediaOrgForm.enable"/>


		         
		  <display:column property="org.name" sortable="true" headerClass="sortable"
         		titleKey="carrierTypeForm.orgId"/>
		    <display:setProperty name="paging.banner.item_name" value="mediaOrg"/>
		    <display:setProperty name="paging.banner.items_name" value="mediaOrgs"/>
		</display:table>
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

</html:form>


<script type="text/javascript">
    highlightTableRows("mediaOrgList");
</script>
