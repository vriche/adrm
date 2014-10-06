<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="publishedInfoList.title"/></title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXMenu/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxMenu/dhtmlXProtobar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxMenu/dhtmlXMenuBar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxMenu/dhtmlXMenuBar_cp.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxMenu/dhtmlXCommon.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_drag.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_srnd.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_start.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/publish.js'/>"></script>


<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/WorkspanManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/PriceManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/PriceDetailManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/PublishedInfoManager.js'/>"></script>


<content tag="heading"><fmt:message key="publishedInfoList.heading"/></content>
<meta name="menu" content="PublishedInfoMenu"/>




<table width="100%" border="1">
  <tr> 
    <td rowspan="2" valign="top" width="22%">
    <table width="100%" border="1"  id="treeTable">
        <tr> 
          <td>
          
          	<table width="100%" cellpadding="0" cellspacing="0">
              <tr> 
                <td align="center">
                    <input name="radiobutton" type="radio"  value="radiobutton" checked>
                    <!-- ±àÅÅ -->
					<fmt:message key="publishedInfoForm.title.edit"/>
					</td>
                <td align="center">
                    <input name="radiobutton" type="radio" value="radiobutton">
                    <!-- µæÆ¬ -->
					<fmt:message key="publishedInfoForm.title.forceIn"/>
					<!-- a href="#" onclick="reloadGrid()">reloadGrid</a -->
					</td>
              </tr>
              
               <tr> 
                <td colspan="2" ><hr></td>
               </tr> 
                
               <tr> 
                <td align="right">
                	&nbsp;&nbsp;<fmt:message key="publishedInfoForm.title.broDate"/>:
                </td>
                <td>
                
                							<!--onclick=" button_showdate('bro_date','anchor1') "-->
					<input name="bro_date" id="bro_date" value="" size="15" type="text" onclick="getDate()" readonly="true">
					<span id="anchor1" name="anchor1"></span>
				</td>
               </tr>             
            </table>
            
            </td>
        </tr>
        <tr> 
          <td align="center">
          
				<table width="98%" >
				  <tr>
				    <td>
				        <!-- resource tree -->
		              	<div id="treebox" 
							 style="width:100%; 
							 height:100px;
							 background-color:#f5f5f5;
							 border :1px solid Silver;"/>
						<iframe name="actionframe" id="actionframe" frameborder="0" width="100%" height="0"></iframe>
					</td>
				  </tr>
				</table>          

		  </td>
        </tr>
        
        
        <tr> 
          <td align="center">
          
		      <table width="100%">
		        <tr> 
		          <td> 
				     <input type="button" name="Btn_build_bro" id="Btn_build_bro" value="<fmt:message key="publishedInfoForm.button.buid"/>"> 
				     <input type="button" name="Btn_print_bro" id="Btn_save_bro" value="<fmt:message key="publishedInfoForm.button.save"/>"> 
		             <input type="button" name="Btn_preView_bro" id="Btn_preView_bro" value="<fmt:message key="publishedInfoForm.button.preView"/>"> 
		             <input type="button" name="Btn_print_bro" id="Btn_print_bro" value="<fmt:message key="publishedInfoForm.button.print"/>"> 
		             <span id="progressMsg" style="display:none;"><img alt="Indicator" src="<c:url value='image/indicator.gif'/>"  width="14" heigth="14"/> Loading...</span>
		            </td>
		        </tr>
		      </table>       

		  </td>
        </tr>        
        
      </table>
      </td>
    <td valign="top"> 
      <!-- grid -->
	  <div id="gridbox" width="100%" height="100%" style="background-color:white;"></div>
    </td>
  </tr>
 
</table>

<iframe src='about:blank'   scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
<form name="ReportForm" id="ReportForm">
<input type="hidden" name="action" id="action" value="preView">
<input type="hidden" name="carrierName" id="carrierName" value="">
<input type="hidden" name="resourceIds" id="resourceIds" value="">
<input type="hidden" name="publishDate" id="publishDate" value="">
</form>
