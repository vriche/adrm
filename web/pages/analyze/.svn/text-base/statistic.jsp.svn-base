<%@ include file="/common/taglibs.jsp"%>

<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title>汇总统计</title>
<content tag="heading">统计</content>
<meta name="menu" content="statisticMenu"/>

<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/extutils.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/paramObj.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/AnalyseSumManager.js'/>"></script>





<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FusionCharts.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FCColors.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/FusionChartsCreator.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/fusionCharts/js/Charts.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/TreeCheckNodeUI.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.form.ClearableComboBox.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/ComboBoxTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.ux.grid.GridSummary.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.ux.grid.GroupSummary.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/analyzesum/statisticSum.js'/>"></script>
<!-- script type="text/javascript" src="<c:url value='/scripts/analyzesum/channelSum.js'/>"></script -->

<script type="text/javascript" src="<c:url value='/scripts/analyze/statisticService.js'/>"></script>


<div name="mainDive" id="mainDive" style="background-color: red; ">




<div id="theDivChart" style="position:absolute;  OVERFLOW: auto;width:100%;height:100%;visibility:hidden;border:solid green 0px;background-color:white;z-index:1">	
              
<input type="hidden" id="contPath" value="<c:url value="/"/>">	
<input type="hidden" id="caption"  value="">	

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td>

            <table border="0" cellpadding="0" cellspacing="1" width="100%">
          
                  <tr> 
                   	<td width="30px" align="right"><fmt:message key="chart.style"/>:</td>
                    <td width="1px"><div id="chartTypeDiv"> </td>
		        	<td width="30px" align="right"><fmt:message key="chart.fontsize"/>: </td>
		            <td width="1px" align="right"><div id="baseFontSizeDiv"></td>
		         
			        <td width="1px">
			       		<input  style="CURSOR: pointer;" name="paste2" type="button"  style="width:60px;" onclick="javaScript:replaceCaption();" value=<fmt:message key="chart.changecaption"/>>
			        </td>
		         
		           <td width="1px" align="right">
		          		<input  style="CURSOR: pointer;" id="showValues"  name="showValues" type="checkbox" value='0'  onclick="javaScript:renderFromQS();"/>
		           </td>
		         
		          <td width="40px" align="left">
		               <label style="cursor: pointer;" for="showValues"><fmt:message key="chart.showValues"/></label>
		          </td>
		          
		          <td width="1px"><div id="clums" /> </td>
		         
		          <td>&nbsp;</td>					

                  </tr>
            
              </table>
              
         </td>
  </tr>
  <tr>
    <td>
	    <table border="0" cellpadding="0" cellspacing="0" width="100%">
	          <tr><td><div id="chartdiv" align="center" border-style="none" style="width:100%;heigth:98%;"></td></tr>
	    </table>
      </td>
  </tr>
</table>
</div>




