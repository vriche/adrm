<%@ include file="/common/taglibs.jsp"%>
<title><fmt:message key="areaCustomerAnalyze.title"/></title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/prototypeUI/ptotoyeUI.css'/>" / >

<script type="text/javascript" src="<c:url value='/scripts/prototypeUI/window.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/prototypeUI/utils.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_start.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_nxml.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/FusionChartsManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FusionCharts.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FCColors.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FusionChartsCreator.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/Charts.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FusionMaps.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/analyze/areaCustomerChartService.js'/>"></script>



<content tag="heading"><fmt:message key="areaCustomerAnalyze.title"/></content>

<input type="hidden" id="contPath" value="<c:url value="/"/>">	
<input type="hidden" id="caption"  value="">	

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
               			
               		<div style="position:relative;overflow:visible">    
			
 						<!--a type="hidden" href="#"  id="btnSearche"  class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="publishArrangeDownload.query"/>&nbsp;&nbsp;&nbsp;&nbsp;</a -->  
			
						<div id="dataGridDiv" style="position:absolute;  OVERFLOW: auto;left:0px;top:21px;width:550px;height:400px;visibility:hidden;border:solid green 2px;background-color:white;z-index:1">	
						<table width="100%" border="0">
							<tr>
								<td>
									<div id="gridbox" width="100%" height="100%" style="background-color:white;z-index:0"></div>
						    	</td>
						    </tr>
						    <tr>
								<td>
									<div id="messanger">&nbsp;</div>
										<input  style="CURSOR: pointer;" type="button"  id="addRow" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;&nbsp;&nbsp;'>
			                       		<input  style="CURSOR: pointer;" type="button" id="eleteSelectedItem" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.delete"/>&nbsp;&nbsp;&nbsp;&nbsp;' -->
				                 
								</td>
							</tr>
							<tr>
								<td align="left">
				                    <input  style="CURSOR: pointer;" type="button"  id="query" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="orderDayInfoForm.button.search"/>&nbsp;&nbsp;&nbsp;&nbsp;'>
			                        <input  style="CURSOR: pointer;" type="button" id="btnSearcheClose" value='&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.cancel"/>&nbsp;&nbsp;&nbsp;&nbsp;' -->
				                 </td>
				           </tr>
					 	</table>
						</div>
                     </div>
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
            
            <td style="border:solid black 1px;background-color:#f4f3f4;">
 				<div id="chartdiv" align="center" style="display:block" >
 	        </td>
            <td style="border:solid black 1px;background-color:#f4f3f4;">
				<div id="chartdiv2" align="center" border-style="none" >
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