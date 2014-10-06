<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="sysSequenceList.title"/></title>
<content tag="heading"><fmt:message key="sysSequenceList.heading"/></content>
<meta name="menu" content="SysSequenceMenu"/>

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
						<a href="editSysSequence.html" class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
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

<display:table name="sysSequenceList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="sysSequenceList" pagesize="25" class="tableDisplay sysSequenceList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editSysSequence.html" paramId="id" paramProperty="id"
        titleKey="sysSequenceForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="sysSequenceForm.name"/>		<!--name--> 
    <display:column property="prefix" sortable="true" headerClass="sortable"
         titleKey="sysSequenceForm.prefix"/>		<!--prefix--> 
    <display:column property="startNo" sortable="true" headerClass="sortable"
         titleKey="sysSequenceForm.startNo"/>		<!--startNo--> 
    <display:column property="incrementNo" sortable="true" headerClass="sortable"
         titleKey="sysSequenceForm.incrementNo"/>		<!--incrementNo--> 
    <display:column property="format" sortable="true" headerClass="sortable"
         titleKey="sysSequenceForm.format"/>		<!--format--> 
    <display:column property="currentNext" sortable="true" headerClass="sortable"
         titleKey="sysSequenceForm.currentNext"/>		<!--currentNext--> 
    <display:column property="currentNextSys" sortable="true" headerClass="sortable"
         titleKey="sysSequenceForm.currentNextSys"/>		<!--currentNextSys--> 
    <display:column property="suffix" sortable="true" headerClass="sortable"
         titleKey="sysSequenceForm.suffix"/>		<!--suffix--> 
    <display:setProperty name="paging.banner.item_name" value="sysSequence"/>
    <display:setProperty name="paging.banner.items_name" value="sysSequences"/>
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
    highlightTableRows("sysSequenceList");
</script>
