<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaInfoTypeList.title"/></title>
<content tag="heading"><fmt:message key="oaInfoTypeList.heading"/></content>
<meta name="menu" content="OaInfoTypeMenu"/>


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
                   
                    <a href="editOaInfoType.html" class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
                    
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
 
			<display:table name="oaInfoTypeList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
			    id="oaInfoTypeList" pagesize="25" class="tableDisplay oaInfoTypeList"
			    export="false" requestURI="">
		
		    <display:column property="name" sortable="true" headerClass="sortable"
		    	 url="/editOaInfoType.html" paramId="id" paramProperty="id"
		         titleKey="oaInfoTypeForm.name"/>		<!--name--> 
		    <display:column property="value" sortable="true" headerClass="sortable"
		         titleKey="oaInfoTypeForm.value"/>		<!--value--> 
		    <display:setProperty name="paging.banner.item_name" value="oaInfoType"/>
		    <display:setProperty name="paging.banner.items_name" value="oaInfoTypes"/>
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
    highlightTableRows("oaInfoTypeList");
</script>
