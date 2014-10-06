<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaBusinessCardList.title"/></title>
<content tag="heading"><fmt:message key="oaBusinessCardList.heading"/></content>
<meta name="menu" content="OaBusinessCardMenu"/>


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
                   
                    <a href="editOaBusinessCard.html" class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
                    
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
 
			<display:table name="oaBusinessCardList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
			    id="oaBusinessCardList" pagesize="25" class="tableDisplay oaBusinessCardList"
			    export="false" requestURI="">
			
			    <display:column property="firstName" sortable="true" headerClass="sortable"
			    	url="/editOaBusinessCard.html" paramId="id" paramProperty="id"
			         titleKey="oaBusinessCardForm.firstName"/>		<!--firstName-->
			    <display:column property="lastName" sortable="true" headerClass="sortable"
			         titleKey="oaBusinessCardForm.lastName"/>		<!--lastName--> 
			    <display:column property="sex" sortable="true" headerClass="sortable"
			         titleKey="oaBusinessCardForm.sex"/>		<!--sex-->          
			    <!-- display:column property="birthdayDate" sortable="true" headerClass="sortable"
			    	 url="/editOaBusinessCard.html" paramId="id" paramProperty="id"
			         titleKey="oaBusinessCardForm.birthdayDate"/ -->		<!--birthdayDate--> 
			    <!-- display:column property="birthdayMonth" sortable="true" headerClass="sortable"
			         titleKey="oaBusinessCardForm.birthdayMonth"/ -->		<!--birthdayMonth--> 
			    <!-- display:column property="birthdayYear" sortable="true" headerClass="sortable"
			         titleKey="oaBusinessCardForm.birthdayYear"/ -->		<!--birthdayYear-->         
			    <display:column property="headship" sortable="true" headerClass="sortable"
			         titleKey="oaBusinessCardForm.headship"/>		<!--headship--> 
			    <display:column property="mob" sortable="true" headerClass="sortable"
			         titleKey="oaBusinessCardForm.mob"/>		<!--mob--> 
			    <display:column property="tel1" sortable="true" headerClass="sortable"
			         titleKey="oaBusinessCardForm.tel1"/>		<!--tel1-->  
			    <display:column property="work" sortable="true" headerClass="sortable"
			         titleKey="oaBusinessCardForm.work"/>		<!--work--> 
			    <display:column property="businessCardTypId" sortable="true" headerClass="sortable"
			         titleKey="oaBusinessCardForm.businessCardTypId"/>		<!--businessCardTypId--> 
			    <!-- display:column property="tel2" sortable="true" headerClass="sortable"
			         titleKey="oaBusinessCardForm.tel2"/ -->		<!--tel2--> 
			    <!-- display:column property="tel3" sortable="true" headerClass="sortable"
			         titleKey="oaBusinessCardForm.tel3"/ -->		<!--tel3-->
			    <display:setProperty name="paging.banner.item_name" value="oaBusinessCard"/>
			    <display:setProperty name="paging.banner.items_name" value="oaBusinessCards"/>
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
    highlightTableRows("oaBusinessCardList");
</script>
