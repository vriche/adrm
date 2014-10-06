<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="matterTypeList.title"/></title>
<content tag="heading"><fmt:message key="matterTypeList.heading"/></content>
<meta name="menu" content="MatterTypeMenu"/>


<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
					<td width="10%">    
						<a href="editMatterType.html" class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
					</td>
		  				
				   
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






<c:out value="${buttons}" escapeXml="false"/>

<display:table name="matterTypeList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="matterTypeList" pagesize="25" class="tableDisplay matterTypeList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editMatterType.html" paramId="id" paramProperty="id"
        titleKey="matterTypeForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="matterTypeForm.name"/>		<!--name--> 
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="matterTypeForm.value"/>		<!--value--> 
   
</display:table>



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
    highlightTableRows("matterTypeList");
</script>
