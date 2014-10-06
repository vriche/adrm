<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="industryList.title"/></title>
<content tag="heading"><fmt:message key="industryList.heading"/></content>
<meta name="menu" content="IndustryMenu"/>




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
                   
                    <a href="editIndustry.html" class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
   
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
 
			<display:table name="industryList"  partialList="true" size="resultSize" cellspacing="1" cellpadding="0" 
			    id="industryList" pagesize="19" class="tableDisplay" 
			    export="false" requestURI="/industrys.html">
			
			    <display:column property="id" sortable="true" headerClass="sortable"
			        url="/editIndustry.html" paramId="id" paramProperty="id" 
			        titleKey="industryForm.id"/>
			        
			    <!-- display:column property="id" href="editIndustry.html" paramId="id" paramName="industry" paramScope="request" 
			     sortable="true" headerClass="sortable"  titleKey="industryForm.id"/ --> 
			
			    <display:column property="name" sortable="true" headerClass="sortable "
			         titleKey="industryForm.name"/>
			    <display:column property="code" sortable="true" headerClass="sortable"
			         titleKey="industryForm.code"/>
			         
			    <display:setProperty name="paging.banner.group_size" value="6"/>
			    <display:setProperty name="paging.banner.item_name" value="industry"/>
			    <display:setProperty name="paging.banner.items_name" value="industrys"/>
			    
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
    highlightTableRows("industryList");
</script>
