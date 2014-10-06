<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="yearTargetAnalyze.title"/></title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />



<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>		        
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/dwr/interface/FinanceTargetManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/IncomePurposeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceChannelManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>	

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_start.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_nxml.js'/>"></script>  
<!-- script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/ext/dhtmlXgrid_colspan.js'/>"></script -->  
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/ext/dhtmlxgrid_group.js'/>"></script>  
 
		        
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/financeTarget.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/incomePurpose.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resourceChannel.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/analyze/adIncomeRelpayQiankService.js'/>"></script>	        
 
<content tag="heading">汇总分析</content> 
 
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr>   
                  
                    <td width="1px" id="orgId_td"> <select id="orgId"/></td>	
                    <td width="1px"><select id="order_year"  style="CURSOR: pointer;" /></td>	
                    
                                                                                 
                    <td width="50px">截止月份</td>	
					<td align="left" width="1px">
                      			<select name="month" id="month">  
	                      			<option value="01"><fmt:message key="business.month.jan"/></option>
	                      			<option value="02"><fmt:message key="business.month.feb"/></option>
									<option value="03"><fmt:message key="business.month.mar"/></option>
									<option value="04"><fmt:message key="business.month.apr"/></option>
	                      			<option value="05"><fmt:message key="business.month.may"/></option>
									<option value="06"><fmt:message key="business.month.jun"/></option>
									<option value="07"><fmt:message key="business.month.jul"/></option>
	                      			<option value="08"><fmt:message key="business.month.aug"/></option>
									<option value="09"><fmt:message key="business.month.sep"/></option>
									<option value="10"><fmt:message key="business.month.oct"/></option>
	                      			<option value="11"><fmt:message key="business.month.nov"/></option>
									<option value="12"><fmt:message key="business.month.dec"/></option> 
								</select>
            		</td>
                    
					<td width="1px"> <input type="button"   class="button" id="btnSearche" value='查询'></td>
					
					<td  width="1px" ><div id="printReportDiv" name="printReportDiv"/></td>
	                 
	                 <td> &nbsp; </td>
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
 
 
			 <table width="100%" border="0" cellspacing="0" cellpadding="0">
			      <tr>
				    <td valign="top">
						<table width="100%" border="0">
							<tr>
							<td>
									
								<div id="gridbox" width="100%" height="100%" style="background-color:white;z-index:0"></div>		
										
								
			
				      		</td>
				      		</tr>
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

