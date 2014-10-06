<%@ include file="/common/taglibs.jsp"%>
<title><fmt:message key="orderDayInfoForm.customer.title"/></title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/prototypeUI/ptotoyeUI.css'/>" / >

<script type="text/javascript" src="<c:url value='/scripts/prototypeUI/window.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/prototypeUI/utils.js'/>"></script>


<script type="text/javascript" src="<c:url value='/dwr/interface/FusionChartsManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FusionCharts.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FCColors.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FusionChartsCreator.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/Charts.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/analyze/customerChartsService.js'/>"></script>



<content tag="heading"><fmt:message key="orderDayInfoForm.customer.title"/></content>

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
                   	<td width="30px" align="right"><fmt:message key="chart.style"/>:</td>
                    <td width="1px"><div id="chartTypeDiv"> </td>
		        	<td width="30px" align="right"><fmt:message key="chart.fontsize"/>: </td>
		             <td width="1px" align="right"><div id="baseFontSizeDiv"></td>
		         
		          <!-- td width="1px">
		           <input name="btnMax" type="button"  style="width:50px;" onclick="javaScript:showMax();" value="<fmt:message key="chart.max"/>"/>
		         </td -->
		             
		         <td width="1px">
		       		<input  style="CURSOR: pointer;" name="paste2" type="button"  style="width:60px;" onclick="javaScript:replaceCaption();" value=<fmt:message key="chart.changecaption"/>>
		         </td>
		         
		          <td width="1px" align="right">
		          	<input  style="CURSOR: pointer;" id="showValues"  name="showValues" type="checkbox" value='0'  onclick="javaScript:renderFromQS();"/>
		          </td>
		         
		         <td width="40px" align="left">
		               <label style="cursor: pointer;" for="showValues">
		          	 <fmt:message key="chart.showValues"/>
		          	</label>
		          </td>
		          
		        <td width="1px"><div id="clums" /> </td>
		         
		        <td>&nbsp;</td>
					

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
			<div id="chartdiv" align="center" border-style="none" >
             
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