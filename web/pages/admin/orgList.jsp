<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="orgList.title"/></title>
<content tag="heading"><fmt:message key="orgList.heading"/></content>
<meta name="menu" content="OrgMenu"/>


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
                    
                    <!-- input type="button" value="<fmt:message key="button.add"/>" onclick="javascript:function(){location.href='editOrg.html'}" -->
            
            
              <c:if test="${pageContext.request.remoteUser == 'admin'}">
              
					<c:set var="buttons">
					    <input type="button"  class="button" 
					        onclick="location.href='<c:url value="/editOrg.html"/>'"
					        value="<fmt:message key="button.add"/>"/>
				
					</c:set>
					
					<c:out value="${buttons}" escapeXml="false"/>
             </c:if>      
            

        
            

					
					
					
				
				
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
            
            <!--   table start -->
 
			<display:table name="orgList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
			    id="orgList" pagesize="25" class="tableDisplay orgList"
			    export="false" requestURI="">
			
			    <display:column property="name" sortable="true" headerClass="sortable"
			    	 url="/editOrg.html" paramId="id" paramProperty="id"
			         titleKey="orgForm.name"/>		<!--name--> 
			    <display:column property="bankCode" sortable="true" headerClass="sortable"
			         titleKey="orgForm.bankCode"/>		<!--bankCode--> 
			    <display:column property="bankName" sortable="true" headerClass="sortable"
			         titleKey="orgForm.bankName"/>		<!--bankName--> 
			    <display:column property="fax" sortable="true" headerClass="sortable"
			         titleKey="orgForm.fax"/>		<!--fax--> 
			    <display:column property="linkMan" sortable="true" headerClass="sortable"
			         titleKey="orgForm.linkMan"/>		<!--linkMan--> 
			         
			         
			         
 		         
			         
			    <display:column property="tel" sortable="true" headerClass="sortable"
			         titleKey="orgForm.tel"/>		<!--tel-->     
			         
			   <display:column property="sysAdmin.fullName" sortable="true" headerClass="sortable"
			         titleKey="orgForm.admin"/>	
			         
			         
			    <display:setProperty name="paging.banner.item_name" value="org"/>
			    <display:setProperty name="paging.banner.items_name" value="orgs"/>
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



<script type="text/javascript">
    highlightTableRows("orgList");
</script>
