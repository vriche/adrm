<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title><fmt:message key="orderDayInfoForm.customer.title"/></title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/global.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/prototypeUI/ptotoyeUI.css'/>" / >


<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>

<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/DateUtil.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/prototypeUI/window.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/prototypeUI/utils.js'/>"></script>


<script type="text/javascript" src="<c:url value='/dwr/interface/ProAnalyzeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FusionCharts.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FCColors.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FusionChartsCreator.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/Charts.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/merm/proProgramAudienceAnalyzeChartService.js'/>"></script>





<input type="hidden" id="contPath" value="<c:url value="/"/>">	
<input type="hidden" id="caption"  value="">	


            
            <table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                   	<td width="30px" align="right">
		          <fmt:message key="chart.style"/>:
		         </td>
                    	 <td width="1px">  
                      		<div id="chartTypeDiv">
		         </td>

		         <td width="30px" align="right">
		          <fmt:message key="chart.fontsize"/>:
		          </td>
		          <td width="1px" align="right">
		          	<div id="baseFontSizeDiv">
		          </td>
		         
		          <!-- td width="1px">
		           <input name="btnMax" type="button"  style="width:50px;" onclick="javaScript:showMax();" value="<fmt:message key="chart.max"/>"/>
		         </td -->
		             
		         <td width="10px">
		       		<input  style="CURSOR: pointer;" name="paste2" type="button"  style="width:60px;" onclick="javaScript:replaceCaption();" value=<fmt:message key="chart.changecaption"/>>
		         </td>
		         
		          <td width="10px" align="right">
		          	<input  style="CURSOR: pointer;" id="showValues"  name="showValues" type="checkbox" value='0'  onclick="javaScript:renderFromQS();"/>
		          </td>
		         
		         <td width="50px" align="left">
		               <label style="cursor: pointer;" for="showValues">
		          	 <fmt:message key="chart.showValues"/>
		          	</label>
		          </td>
		          
		          <td width="30px">
		       		<div id="clums" />
		         </td>
		         
		            <td width="45%">
		               
		          </td>
					

                    </td>
                  </tr>
                </tbody>
              </table>
              
              <br/>
              
              
              
              
              
        <table border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td background="images/table1/textbox_left.gif" width="14"></td>
            <td style="border:solid black 1px;background-color:#f4f3f4;">
			<div id="chartdiv" align="center" border-style="none" >
             
            </td>
            <td width="14" background="images/table1/textbox_right.gif"></td>
          </tr>
        </tbody>
      </table>