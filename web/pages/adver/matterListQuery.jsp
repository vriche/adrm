<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="matterList.title"/></title>
<content tag="heading"><fmt:message key="matterList.heading"/></content>
<meta name="menu" content="MatterMenu"/>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterTypeManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/matter.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/matterType.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/sample/broArrange.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/adver/matterQueryService.js'/>"></script>

<c:set var="buttons">



<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
					<td>   
					<table>
					
					<tr> 
					
					<td><fmt:message key="matterForm.date"/> </td>
					<td><input type ="text" id ="beginDate" size=12> </td>
					
                    <td><input type="button"   class="button" id="searchMatterBegin" value='<fmt:message key="matterForm.begin"/>'>	  </td>
                    
                     <td><input type="button"   class="button" id="searchMatterOver" value='<fmt:message key="matterForm.over"/>'>	  </td>
                     
                   
                    <td>
                    	<fmt:message key="matterForm.after"/>
                    </td>
                    <td>
                    <select name="days" id = "days">
                    	<option><fmt:message key="matterForm.today"/></option>
                    	<option>1</option>
        				<option>2</option>
                    	<option>3</option>
        				<option>4</option>
                    	<option>5</option>
        				<option>6</option>
                    	<option>7</option>
                    </select>            
                    </td>
                      </tr></table>             
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
                   
</c:set>

<c:out value="${buttons}" escapeXml="false"/>



<table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td width="30%"> 
			          	<table id="matterList" class=ListShort width="100%" cellpadding="0" >
			              <thead>
			                <TR class=Header> 
			                  <!--素材名称-->
			                  <TH><fmt:message key="matterForm.name"/></TH>
			                  <!--客户-->
			                  <TH><fmt:message key="matterForm.customerId"/></TH>
			                  <!--开始日期-->
			                  <TH><fmt:message key="orderForm.publishStartDate"/></TH>
			                  <!--结束日期-->
			                  <TH><fmt:message key="orderForm.publishEndDate"/></TH>
			                  <!--版本-->
			                  <TH><fmt:message key="matterForm.edit"/></TH>
			                  <!--长度-->
			                  <TH><fmt:message key="matterForm.length"/></TH>
			                  <!--磁带编号-->
			                  <TH><fmt:message key="matterForm.tapeCode"/></TH>

			                  <!--有效-->
			                  <TH><fmt:message key="matterForm.days"/></TH>
			                  
			                  
			                  
			                  <!-- TH id="incomeListRow" name="incomeListRow" style="cursor:hand" colspan="2">
			                  		<fmt:message key="button.operation"/> </TH -->
			                </TR>
			                
			                  <tr> 
				                  <td colspan="11">
					                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                      <tr> 
					                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
					                      </tr>
					                    </table>
				                    </td>
				              </tr>
				              
			              
			              <tbody id="matterBody"/>
			              
			              </thead>
				          <tbody>
				          <tr height="20"><td colspan="11">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
						  				 <tr>
						  				 	 <td colspan="2"><IMG src="image/s.gif"  width="100%" height="2">
						  				 	 </td>
						  				 </tr>
				                        <tr  bgcolor="#D8DFE7">
				                          <td align="right"> 
				                              <div id="pageInfomatter"></div>
				                          </td>
				                     	</tr>
							  </table>
							  </td>
				          </tr>
				          </tbody>
				          
				          </table>
<div style="display:none;">
customerId:<input name="customerId" type="text" id="customerId">
matter.name<input type="text" id="matter.name">
matter.edit:<input type="text" id="matter.edit">
matterTypeId:<input name="matterTypeId" type="text" id="matterTypeId">
customerCategoryId:<input name="customerCategoryId" type="text" id="customerCategoryId">
</div>   				          
          </td>
        </tr>
</table>
			
           
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
    highlightTableRows("matterList");
</script>
