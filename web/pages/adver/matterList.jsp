<%@ include file="/common/taglibs.jsp"%>

<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title><fmt:message key="matterList.title"/></title>
<content tag="heading"><fmt:message key="matterList.heading"/></content>
<meta name="menu" content="MatterMenu"/>

<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterTypeManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/matter.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/matterType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/adver/matterService.js'/>"></script>

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
                  <td width="1px" id="orgId_td"> <select id="orgId" name="orgId"/> </td>
				  <td width="1px">    
						<!-- a href="editMatter.html" class="button">&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;</a -->
						<input type="button"   class="button" id="btn_add" value='<fmt:message key="button.add"/>' >
					</td>
					
		  			<td width="1px">
	<div style="position:relative;overflow:visible">    
	<input type="button"   class="button" id="btnSearche" value='<fmt:message key="publishArrangeDownload.query"/>'>		

			
	<div id="theDivSearch" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:550px;height:400px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1">	
                    
                 
        <table width="100%">
	                 
		<tr><td align="left" colspan="3">&nbsp</td></tr>
		
		<tr style="display:none">	
		    <td align="left" width="70px"><fmt:message key="customer.info"/>:</td>
		    <td width="1px"><div id="customerCmd" name="customerCmd"/><!-- select id="customerCmd" name="customerCmd" --></td>
			<td >&nbsp;</td>
		</tr>
		
		<tr>
		  	<td align="left" width="70px"><font color="" size="2.5"><fmt:message key="matterForm.name"/>:</font></td>
            <td width="1px"> 
							<div style="position:relative;overflow:visible">
								<input name="matter.name" id="matter.name" type=text autocomplete=off>
								<div id="theDivMatterName" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:250px;height:250px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
							</div>	                        
            </td>
            <td >&nbsp;</td>
        </tr>
                    
        <tr>     
        
			<td align="left" width="70px"><font color="" size="2.5"><fmt:message key="orderDetailForm.matterEdit"/>:</font></td>
                <td width="1px"> 
							<div style="position:relative;overflow:visible">
								<input name="matter.edit" id="matter.edit" type=text autocomplete=off>
								<div id="theDivMatterEditName" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:250px;height:250px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1"></div>
							</div>	                        
           </td> 
           <td >&nbsp;</td>  
       </tr>
       

      	
       <tr>	
           <td align="left" width="70px"><font color="" size="2.5"><fmt:message key="matterForm.matterType"/>:</font></td>
		   <td align="left" width="1px"><select name="select" id="MatterTypeRN"/></td>
		</tr>	
					
		<tr><td align="left" colspan="3">&nbsp</td></tr>
		<tr><td align="left" colspan="3">&nbsp</td></tr>
		<tr><td align="left" colspan="3">&nbsp</td></tr>
				
		<tr>	
		
		    <td  width="1px">
				<input  style="CURSOR: pointer;" type="button" name="searchMatter" id="searchMatter" value='&nbsp;&nbsp;<fmt:message key="oaCalendarEventForm.query"/>&nbsp;&nbsp;'>
			</td>
			<td align="left" width="1px">
				<input  style="CURSOR: pointer;" type="button" id="btnSearcheClose" value='&nbsp;&nbsp;<fmt:message key="button.cancel"/>&nbsp;&nbsp;'>
            </td>            
			   <td >&nbsp;</td>  
		 </tr>
 
	    </table>		 
				
</div></div>
	 	   			</td>
	 	   			
	 	   			<td width="1px" ><div id="printReportDiv" name="printReportDiv"/></td>
	 	   			
	 				<td align="left">&nbsp;</td>
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
			                  <!--版本-->
			                  <TH><fmt:message key="matterForm.edit"/></TH>
			                  <!--长度-->
			                  <TH><fmt:message key="matterForm.length"/></TH>
			                  <!--磁带编号-->
			                  <TH><fmt:message key="matterForm.tapeCode"/></TH>
			                  <!--类型-->
			                  <TH><fmt:message key="matterForm.matterType"/></TH>
			                  <!--行业-->
			                  <TH><fmt:message key="customerForm.industryTypeId"/></TH>
			                  <!--备注-->
			                  <TH>播出位置</TH> 
			                  
			                   <TH>创建日期</TH>
			                   
			                   <TH>现用</TH>
			                   
			                  <!--有效-->
			                  <TH><fmt:message key="matterForm.enable"/></TH>
			                  
			                  
			                  
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
				                        <tr  bgcolor="#eee">
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
<input name="customerName" type="text" id="customerName">

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

<div style="display:none;">

	<iframe src='about:blank'   scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
	
<form name="ReportForm" id="ReportForm" method="post">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="reportType" id="reportType" value="">
	<input type="hidden" name="matterNameForm" id="matterNameForm" value="">
	<input type="hidden" name="customerIdForm" id="customerIdForm" value="">
	<input type="hidden" name="matterEditForm" id="matterEditForm" value="">
	<input type="hidden" name="matterTypeForm" id="matterTypeForm" value="">
	
</form>
</div>
