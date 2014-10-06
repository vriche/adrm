<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaProductInfoList.title"/></title>
<content tag="heading"><fmt:message key="oaProductInfoList.heading"/></content>
<meta name="menu" content="OaProductInfoMenu"/>


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
                   
                    <a href="editOaProductInfo.html" class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
                    
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
 
			<display:table name="oaProductInfoList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
			    id="oaProductInfoList" pagesize="25" class="tableDisplay oaProductInfoList"
			    export="false" requestURI="">
		
		    <display:column property="fittings" sortable="true" headerClass="sortable"
		    	 url="/editOaProductInfo.html" paramId="id" paramProperty="id"
		         titleKey="oaProductInfoForm.fittings"/>		<!--fittings--> 
		    <display:column property="memo" sortable="true" headerClass="sortable"
		         titleKey="oaProductInfoForm.memo"/>		<!--memo--> 
		    <display:column property="picture" sortable="true" headerClass="sortable"
		         titleKey="oaProductInfoForm.picture"/>		<!--picture--> 
		    <display:column property="price" sortable="true" headerClass="sortable"
		         titleKey="oaProductInfoForm.price"/>		<!--price--> 
		    <display:column property="productTypeId" sortable="true" headerClass="sortable"
		         titleKey="oaProductInfoForm.productTypeId"/>		<!--productTypeId--> 
		    <display:column property="provider" sortable="true" headerClass="sortable"
		         titleKey="oaProductInfoForm.provider"/>		<!--provider--> 
		    <display:column property="quantity" sortable="true" headerClass="sortable"
		         titleKey="oaProductInfoForm.quantity"/>		<!--quantity--> 
		    <display:column property="stockDate" sortable="true" headerClass="sortable"
		         titleKey="oaProductInfoForm.stockDate"/>		<!--stockDate--> 
		    <display:column property="stockUser" sortable="true" headerClass="sortable"
		         titleKey="oaProductInfoForm.stockUser"/>		<!--stockUser--> 
		    <display:column property="storageDate" sortable="true" headerClass="sortable"
		         titleKey="oaProductInfoForm.storageDate"/>		<!--storageDate--> 
		    <display:column property="unit" sortable="true" headerClass="sortable"
		         titleKey="oaProductInfoForm.unit"/>		<!--unit-->
		    <display:setProperty name="paging.banner.item_name" value="oaProductInfo"/>
		    <display:setProperty name="paging.banner.items_name" value="oaProductInfos"/>
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
    highlightTableRows("oaProductInfoList");
</script>
