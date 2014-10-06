<%@ include file="/common/taglibs.jsp"%>
<%@ page import="java.io.*"%> 
<title><fmt:message key="publishArrangeDownload.title"/></title>
<content tag="heading"><fmt:message key="publishArrangeDownload.heading"/></content>
<meta name="menu" content="BrandMenu"/>

<!-- 日历 -->
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
		<!--script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script-->
		
<script type="text/javascript" src="<c:url value='/dwr/interface/PublishArrangeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/PublishArrangeDetailManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/publishArrange.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/adver/publishArrangeDownloadService.js'/>"></script>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                        <td width="1%" id="orgId_td"> <select id="orgId"/></td>
						<td align="left"  width="1%" >
	 						<select name="select" id="carrierName"/>
	                    </td>
	                    <td width="50%" nowrap="nowrap" class="dataLabel">
						    	<fmt:message key="publishArrangeDownload.date"/>:       	
					       
								<input name="publisDate" type="text" id="publisDate"  size="18" readonly="true">
    							<a id="query"  class="button">&nbsp;&nbsp;<fmt:message key="publishArrangeDownload.query"/>&nbsp;&nbsp;</a> 
								<a id="saveFiles"  class="button">&nbsp;&nbsp;<fmt:message key="button.save"/>&nbsp;&nbsp;</a>  
	                            <a id="downlaod"  class="button">&nbsp;&nbsp;<fmt:message key="publishArrangeDownload.downLoad"/>&nbsp;&nbsp;</a> 
								
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

								<a id="preView"  class="button">&nbsp;&nbsp;<fmt:message key="publishedInfoForm.button.preView"/>&nbsp;&nbsp;</a>
								<a id="print"  class="button">&nbsp;&nbsp;<fmt:message key="publishedInfoForm.button.print"/>&nbsp;&nbsp;</a> 
								<a id="export"  class="button">&nbsp;&nbsp;<fmt:message key="publishedInfoForm.button.export"/>&nbsp;&nbsp;</a>
									 	 

	                            <input id="downloadurl" type="hidden" value="<c:url value='/download/advers/ZIP'/>">
							
					
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


            
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
			        <tr> 
			          <td> 
			          	<table class=ListShort width="100%" cellpadding="0" id="publishArrangeTable">
				             <thead>
				                <tr class=Header> 

					                  <!--载体-->
					                  <TH><fmt:message key="publishArrangeDownload.carrier"/></TH>
					                  <!--资源-->
					                  <TH><fmt:message key="publishArrangeDownload.resource"/></TH>
					                  <!--编排日期-->
					                  <!--TH><fmt:message key="publishArrangeDownload.createDate"/></TH -->
					                  <!--编排人员-->
					                  <!-- TH><fmt:message key="publishArrangeDownload.createBy"/></TH  -->
					                  <!--总时间-->
					                  <TH><fmt:message key="publishArrangeDownload.totleTime"/></TH>
					                  <!--占用时间-->
					                  <TH><fmt:message key="publishArrangeDownload.usedTimes"/></TH>
					                  <!--剩余时间-->
					                  <TH><fmt:message key="publishArrangeDownload.shengyuTime"/></TH>
					                  <!--饱和度-->
					                  <TH><fmt:message key="publishArrangeDownload.rate"/></TH>
					                  <!--锁定-->
					                  <TH><fmt:message key="publishArrangeDownload.lock"/></TH>
					                  <TH><fmt:message key="button.delete"/></TH>
			          			</tr>	
			          			
			          			<tbody id="publishArrangeBody"/>
			          		</thead>
			          		<tbody>
					          <tr><td colspan="10">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
							  				 <tr>
							  				 	 <td colspan="2"><IMG src="image/s.gif"  width="100%" height="2">
							  				 	 </td>
							  				 </tr>
					                        <tr  bgcolor="#eee">
					                          <td align="right"> 
					                              <div id="publishArrangePageInfo"></div>
					                          </td>
					                     	</tr>
								  </table>
								  </td>
					          </tr>
				          </tbody>
				       </table>
				          
		          </td>
		         </tr>
		    </table>      
		   





		   
		              </td>
            <td width="14" background="images/table1/textbox_right.gif"></td>
          </tr>
        </tbody>
      </table></td>
  </tr> 
		    
</td>
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




<iframe style="display:none;"  src='about:blank'   scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
<form name="ReportForm" id="ReportForm">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="carrierId" id="carrierId" value="">
	<input type="hidden" name="publishDate" id="publishDate" value="">
	<input type="hidden" name="dayOrNeit" id="dayOrNeit" value="">
	<input type="hidden" name="orgIdForm" id="orgIdForm" value="">
	
</form>	  
		    