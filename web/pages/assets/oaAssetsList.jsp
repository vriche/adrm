<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaAssetsList.title"/></title>
<content tag="heading"><fmt:message key="oaAssetsList.heading"/></content>
<meta name="menu" content="OaAssetsMenu"/>


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
                   
                    <a href="editOaAssets.html" class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
                    
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
 
			<display:table name="oaAssetsList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
			    id="oaAssetsList" pagesize="25" class="tableDisplay oaAssetsList"
			    export="true" requestURI="">

		    <display:column property="assetsCode" sortable="true" headerClass="sortable"
		    	 url="/editOaAssets.html" paramId="id" paramProperty="id"
		         titleKey="oaAssetsForm.assetsCode"/>		<!--assetsCode--> 
		    <display:column property="assetsName" sortable="true" headerClass="sortable"
		         titleKey="oaAssetsForm.assetsName"/>		<!--assetsName--> 
		    <display:column property="assetsStateId" sortable="true" headerClass="sortable"
		         titleKey="oaAssetsForm.assetsStateId"/>		<!--assetsStateId--> 
		    <display:column property="assetsTypeId" sortable="true" headerClass="sortable"
		         titleKey="oaAssetsForm.assetsTypeId"/>		<!--assetsTypeId--> 
		    <display:column property="depreciation" sortable="true" headerClass="sortable"
		         titleKey="oaAssetsForm.depreciation"/>		<!--depreciation--> 
		    <display:column property="memo" sortable="true" headerClass="sortable"
		         titleKey="oaAssetsForm.memo"/>		<!--memo--> 
		    <display:column property="oldValue" sortable="true" headerClass="sortable"
		         titleKey="oaAssetsForm.oldValue"/>		<!--oldValue--> 
		    <display:column property="provider" sortable="true" headerClass="sortable"
		         titleKey="oaAssetsForm.provider"/>		<!--provider--> 
		    <display:column property="purchaseMoney" sortable="true" headerClass="sortable"
		         titleKey="oaAssetsForm.purchaseMoney"/>		<!--purchaseMoney--> 
		    <display:column property="purchaseDate" sortable="true" headerClass="sortable"
		         titleKey="oaAssetsForm.purchaseDate"/>		<!--purchaseDate--> 
		    <display:column property="standard" sortable="true" headerClass="sortable"
		         titleKey="oaAssetsForm.standard"/>		<!--standard--> 
		    <display:column property="storage" sortable="true" headerClass="sortable"
		         titleKey="oaAssetsForm.storage"/>		<!--storage--> 
		    <display:column property="surplusValue" sortable="true" headerClass="sortable"
		         titleKey="oaAssetsForm.surplusValue"/>		<!--surplusValue--> 
		    <display:column property="useYearFixed" sortable="true" headerClass="sortable"
		         titleKey="oaAssetsForm.useYearFixed"/>		<!--useYearFixed--> 
		    <display:column property="voucher" sortable="true" headerClass="sortable"
		         titleKey="oaAssetsForm.voucher"/>		<!--voucher-->  
		    <display:setProperty name="paging.banner.item_name" value="oaAssets"/>
		    <display:setProperty name="paging.banner.items_name" value="oaAssetss"/>
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
    highlightTableRows("oaAssetsList");
</script>
