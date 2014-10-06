<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="customerCategoryList.title"/></title>
<content tag="heading"><fmt:message key="customerCategoryList.heading"/></content>
<meta name="menu" content="CategoryMenu"/>




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
                   
                    <a href="editCategory.html" class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
   
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
 
			<display:table name="categoryList" cellspacing="1" cellpadding="0"
			    id="categoryList" pagesize="18" class="tableDisplay categoryList"
			    export="false" requestURI="">
			
			    <display:column property="categoryName" sortable="true" headerClass="sortable"
			        url="/editCategory.html" paramId="id" paramProperty="id"
			        titleKey="customerCategoryForm.categoryName"/>
			    <display:column property="categoryCode" sortable="true" headerClass="sortable"
			         titleKey="customerCategoryForm.categoryCode"/>
			    <!-- display:column property="adResourcePriceType" sortable="true" headerClass="sortable"
			         titleKey="customerCategoryForm.adResourcePriceType"/ -->
			    <display:column property="memo" sortable="true" headerClass="sortable"
			         titleKey="customerCategoryForm.memo"/>
			    <display:setProperty name="paging.banner.item_name" value="category"/>
			    <display:setProperty name="paging.banner.items_name" value="categorys"/>
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
    highlightTableRows("categoryList");
</script>
