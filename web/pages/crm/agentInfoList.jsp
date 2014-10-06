<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="agentInfoList.title"/></title>
<content tag="heading"><fmt:message key="agentInfoList.heading"/></content>
<meta name="menu" content="AgentInfoMenu"/>











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
                   
                    <a href="editAgentInfo.html" class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
   
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
 
			<display:table name="agentInfoList" cellspacing="1" cellpadding="0"
			    id="agentInfoList" pagesize="25" class="tableDisplay agentInfoList"
			    export="false" requestURI="">
			
			    <display:column property="id" sortable="true" headerClass="sortable"
			        url="/editAgentInfo.html" paramId="id" paramProperty="id"
			        titleKey="agentInfoForm.id"/>
			    <display:column property="agenetType" sortable="true" headerClass="sortable"
			         titleKey="agentInfoForm.agenetType"/>
			    <display:column property="agentRate" sortable="true" headerClass="sortable"
			         titleKey="agentInfoForm.agentRate"/>
			    <display:column property="beginDate" sortable="true" headerClass="sortable"
			         titleKey="agentInfoForm.beginDate"/>
			    <display:column property="customerId" sortable="true" headerClass="sortable"
			         titleKey="agentInfoForm.customerId"/>
			    <display:column property="endDate" sortable="true" headerClass="sortable"
			         titleKey="agentInfoForm.endDate"/>
			    <display:column property="industryTypeId" sortable="true" headerClass="sortable"
			         titleKey="agentInfoForm.industryTypeId"/>
			    <display:column property="state" sortable="true" headerClass="sortable"
			         titleKey="agentInfoForm.state"/>
			    <display:column property="createBy" sortable="true" headerClass="sortable"
			         titleKey="agentInfoForm.createBy"/>
			    <display:column property="createDate" sortable="true" headerClass="sortable"
			         titleKey="agentInfoForm.createDate"/>
			    <display:column property="modifyBy" sortable="true" headerClass="sortable"
			         titleKey="agentInfoForm.modifyBy"/>
			    <display:column property="modifyDate" sortable="true" headerClass="sortable"
			         titleKey="agentInfoForm.modifyDate"/>
			    <display:setProperty name="paging.banner.item_name" value="agentInfo"/>
			    <display:setProperty name="paging.banner.items_name" value="agentInfos"/>
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
    highlightTableRows("agentInfoList");
</script>
