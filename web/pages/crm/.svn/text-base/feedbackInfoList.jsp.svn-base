<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="feedbackInfoList.title"/></title>
<content tag="heading"><fmt:message key="feedbackInfoList.heading"/></content>
<meta name="menu" content="FeedbackInfoMenu"/>

<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>

<script>

var org = new SysOrg();

callOnLoad(init);

function init(){


		config_useMoreCarrierSortParam =  _app_params.sysParam.useMoreCarrierSortParam;	
	
	
	function callBackFun(){
		if(config_useMoreCarrierSortParam == 0 || $('orgIdCmd').options.length<2){
				$('orgId_td').hide();
		}	
		
		
		if( $('orgId').value*1>0) {
			$("orgIdCmd").value= $('orgId').value;
		}else{
			 $('orgId').value = $("orgIdCmd").value;
		}
			
	}

	org.makeSelect(org.obj,"orgIdCmd","this_form_submit",callBackFun);	

}

function this_form_submit(){
     
     
       $('orgId').value = $("orgIdCmd").value;
     
       $("feedbackInfoForm").submit();

}
</script>

<html:form action="feedbackInfos" method="post" styleId="feedbackInfoForm">

<html:hidden property="orgId" styleId="orgId"/>

</html:form>

			          

<c:set var="buttons">


        
         <input type="button"   class="button" id="btn_display" value="<fmt:message key="button.add"/>" onclick="location.href='<c:url  value="/editFeedbackInfo.html"> <c:param name="orgId" value="${linkManForm.orgId}"/> </c:url>'">   
        
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
                  
                   <td width="1%" id="orgId_td"> <select id="orgIdCmd"/></td>
                    <td><span class="tile1">
 						  <c:out value="${buttons}" escapeXml="false"/>
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
 
			<display:table name="feedbackInfoList" cellspacing="2" cellpadding="2"
			    id="feedbackInfoList" pagesize="9" class="tableDisplay feedbackInfoList"
			    export="false" requestURI="">
			
	
			        
	
		      
		      
		        <display:column   titleKey="feedbackInfoForm.id" headerClass="sortable">  
			      <c:url var="viewurl" value="/editFeedbackInfo.html">  
	                      <c:param name="id" value="${feedbackInfoList.id}"/>  
	                      <c:param name="orgId" value="${feedbackInfoList.orgId}"/>  
	              </c:url>       
              
                 <a href='<c:out value="${viewurl}"/>'> <c:out value="${feedbackInfoList.id}"/>  </a> 
		        </display:column>			
		      
		      
		      
		      
		              
			        
			        
			    <display:column property="customerId" sortable="true" headerClass="sortable"
			         titleKey="feedbackInfoForm.customerId"/>
			    <display:column property="feeder" sortable="true" headerClass="sortable"
			         titleKey="feedbackInfoForm.feeder"/>
			    <!--display:column property="dealDate" sortable="true" headerClass="sortable"
			         titleKey="feedbackInfoForm.dealDate"/-->  
			    <display:column property="feedContent" sortable="true" headerClass="sortable"
			         titleKey="feedbackInfoForm.feedContent"/>  
			    <!--display:column property="submitDate" sortable="true" headerClass="sortable"
			         titleKey="feedbackInfoForm.submitDate"/-->
			   
			
			         
			    <display:setProperty name="paging.banner.item_name" value="feedbackInfo"/>
			    <display:setProperty name="paging.banner.items_name" value="feedbackInfos"/>
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
    highlightTableRows("feedbackInfoList");
</script>
