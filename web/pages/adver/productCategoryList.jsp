<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="productCategoryList.title"/></title>
<content tag="heading"><fmt:message key="productCategoryList.heading"/></content>
<meta name="menu" content="ProductCategoryMenu"/>


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
                   
                    <a href="editProductCategory.html" class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
   
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/productCategorys.html"/>'"
        value="<fmt:message key="button.search"/>"/>
        
                        
                        

                    
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
 
			<display:table name="productCategoryList" cellspacing="1" cellpadding="0"
			    id="productCategoryList" pagesize="9" class="tableDisplay productCategoryList"
			    export="false" requestURI="">
			    <display:column property="id" sortable="true" headerClass="sortable"
			        url="/editProductCategory.html" paramId="id" paramProperty="id"
			        titleKey="productCategoryForm.id"/>
			    <display:column property="name" sortable="true" headerClass="sortable"
			         titleKey="productCategoryForm.name"/>
			    <!-- display:column property="modifyDate" sortable="true" headerClass="sortable"
			         titleKey="productCategoryForm.modifyDate"/ -->
			    <display:column property="memo" sortable="true" headerClass="sortable"
			         titleKey="productCategoryForm.memo"/>
			    <display:column property="enable" sortable="true" headerClass="sortable"
			         titleKey="productCategoryForm.enable"/>
			    <display:setProperty name="paging.banner.item_name" value="productCategory"/>
			    <display:setProperty name="paging.banner.items_name" value="productCategorys"/>
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
    highlightTableRows("productCategoryList");
</script>
