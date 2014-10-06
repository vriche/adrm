<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="linkManList.title"/></title>
<content tag="heading"><fmt:message key="linkManList.heading"/></content>
<meta name="menu" content="LinkManMenu"/>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/linkMan.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/LinkManManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/crm/linkManService.js'/>"></script>


<html:form action="linkMans" method="post" styleId="linkManForm">

<html:hidden property="orgId" styleId="orgId"/>


<c:set var="buttons">


        
         <input type="button"   class="button" id="btn_display" value="<fmt:message key="button.add"/>" onclick="location.href='<c:url  value="/editLinkMan.html"> <c:param name="orgId" value="${linkManForm.orgId}"/> </c:url>'">   
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
                         <td width="1%" id="orgId_td"> <select id="orgIdCmd"/></td>
                         
                            <td>
                    			<c:out value="${buttons}" escapeXml="false"/>
							</td>
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
            
            
							<table id="linkmanList" class=ListShort width="100%" cellpadding="0" >
					              <thead>
					                <TR class=Header>   
					                  <!--联系人姓名-->
					                  <TH><fmt:message key="linkManForm.linkmanName"/></TH>
					                  <!--客户名称-->
					                  <TH><fmt:message key="linkManForm.customerId"/></TH>
					                  <!--职务描述-->
					                  <TH><fmt:message key="linkManForm.jobTitle"/></TH>
					                  <!--国家-->
					                  <TH><fmt:message key="linkManForm.homeCountry"/></TH>
					                  <!--区域-->
					                  <TH><fmt:message key="linkManForm.homeProvince"/></TH>
					                  <!--街道-->
					                  <TH><fmt:message key="linkManForm.homeScarriert"/></TH>
					                  <!--邮编-->
					                  <TH><fmt:message key="linkManForm.homeZip"/></TH>
					                  <!--住宅电话-->
					                  <TH><fmt:message key="linkManForm.homeTel"/></TH>
									  <!--工作电话 -->
									  <TH><fmt:message key="linkManForm.officeTel"/></TH>
					                  <!--移动电话 -->
					                  <TH><fmt:message key="linkManForm.mobile"/></TH>									  
					                  <!--首选电子邮箱-->
					                  <TH><fmt:message key="linkManForm.favorEmail"/></TH>
					                  <!--个人爱好-->
					                  <TH><fmt:message key="linkManForm.memo"/></TH>
					                  				                  
					                </TR>
					                
					              </thead>
					              
					              <tbody id="linkmanBody"/>
			
									<tbody>
										<tr height="2"><td colspan="12">
										   <table width="100%" border="0" cellspacing="0" cellpadding="0">
							                        <tr  bgcolor="#eee"> 
							                          <td align="right"> 
							                              <div id="pageInfo_linkman"></div>
							                          </td>
							                      </tr>
										   </table>	  						
										</td></tr>
									</tbody>
						</table>
            
            
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

</html:form>     