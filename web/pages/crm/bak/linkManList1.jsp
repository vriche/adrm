<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="linkManList.title"/></title>
<content tag="heading"><fmt:message key="linkManList.heading"/></content>
<meta name="menu" content="LinkManMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editLinkMan.html"/>'"
        value="<fmt:message key="button.add"/>"/>
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
                    <td><span class="tile1">
                   
                    <a href="editLinkMan.html" class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
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
 
			 <display:table name="linkManList" cellspacing="1" cellpadding="0"
			    id="linkManList" pagesize="9" class="tableDisplay"
			    export="false" requestURI="">
			
			    <display:column property="linkmanName" sortable="true" headerClass="sortable"
			        url="/editLinkMan.html" paramId="id" paramProperty="id"
			        titleKey="linkManForm.linkmanName"/>
			    <display:column property="customerName" sortable="true" headerClass="sortable"
			         titleKey="linkManForm.customerId"/>
			    <display:column property="jobTitle" sortable="true" headerClass="sortable"
			         titleKey="linkManForm.jobTitle"/>
			    <display:column property="homeCountry" sortable="true" headerClass="sortable"
			         titleKey="linkManForm.homeCountry"/>
			    <display:column property="homeProvince" sortable="true" headerClass="sortable"
			         titleKey="linkManForm.homeProvince"/>
			    <display:column property="homeCity" sortable="true" headerClass="sortable"
			         titleKey="linkManForm.homeCity"/>
			    <display:column property="homeScarriert" sortable="true" headerClass="sortable"
			         titleKey="linkManForm.homeScarriert"/>
			    <display:column property="homeZip" sortable="true" headerClass="sortable"
			         titleKey="linkManForm.homeZip"/>
			    <display:column property="homeTel" sortable="true" headerClass="sortable"
			         titleKey="linkManForm.homeTel"/>
			    <display:column property="officeTel" sortable="true" headerClass="sortable"
			         titleKey="linkManForm.officeTel"/>
			    <display:column property="mobile" sortable="true" headerClass="sortable"
			         titleKey="linkManForm.mobile"/>
			    <display:column property="favorEmail" sortable="true" headerClass="sortable"
			         titleKey="linkManForm.favorEmail"/>
			    <display:column property="memo" sortable="true" headerClass="sortable"
			         titleKey="linkManForm.memo"/>
			         
			    <display:setProperty name="paging.banner.item_name" value="linkMan"/>
			    <display:setProperty name="paging.banner.items_name" value="linkMans"/>
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
    highlightTableRows("linkManList");
</script>
