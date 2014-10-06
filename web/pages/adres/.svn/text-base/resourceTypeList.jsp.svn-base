<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="resourceTypeList.title"/></title>

<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/admin/resourceTypeService.js'/>"></script>	

<content tag="heading"><fmt:message key="resourceTypeList.heading"/></content>
<meta name="menu" content="ResourceTypeMenu"/>

<html:form action="resourceTypes" method="get"  styleId="resourceTypeForm" >


 
                          <c:set var="buttons">
							    <input type="button" style="margin-right: 5px"
							        onclick="location.href='<c:url value="/editResourceType.html"/>'" value="&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;"/>
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
                  
                     
                   
 	                   <td width="1px">
	                     <select id="version"  name="version">
							     <% for(int i= 2010; i< 2015;i++){ %>
							   		 <option  value="<%=i%>"><%=i%></option>
						         <%}%>
						 </select>
	                  </td>                   
                   
                    <td width="1px" id="orgId_td"><select id="orgId" name="orgId"/>  
                    <td> <input type="button"    class="button" style="CURSOR: pointer;" id="btn_add" value='ÐÂÌí'> </td>
                     

                    
                    
                    
                  
                    
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
 
			<display:table name="resourceTypeList" cellspacing="0" cellpadding="0"
			    id="resourceTypeList" pagesize="25" class="tableDisplay resourceTypeList"
			    export="true" requestURI="">
			
			<display:column property="name" sortable="true" headerClass="sortable"
		    	 url="/editResourceType.html" paramId="id" paramProperty="id"
		         titleKey="resourceTypeForm.name"/>
		         
		    <display:column property="value" sortable="true" headerClass="sortable"
		         titleKey="customerCategoryForm.displayNo"/>
		         
		         
		    <display:column property="version" sortable="true" headerClass="sortable"
		         titleKey="yearAnalyze.year"/>     

		         
			<display:column  titleKey="resourceTypeForm.enable"  headerClass="sortable"  media="html"> 
			     <c:if test="${resourceTypeList.enable == 1}">ÊÇ</c:if>
			     <c:if test="${resourceTypeList.enable == 0}">·ñ</c:if>
			</display:column> 
					         
		    <display:column property="memo" sortable="true" headerClass="sortable"  titleKey="resourceTypeForm.memo"/>
		         
		         
		      <display:column property="org.name" sortable="true" headerClass="sortable" titleKey="carrierTypeForm.orgId"/>
		         
		    <display:setProperty name="paging.banner.item_name" value="resourceType"/>
		    <display:setProperty name="paging.banner.items_name" value="resourceTypes"/>
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
    highlightTableRows("resourceTypeList");
</script>
