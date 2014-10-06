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

<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/carrierType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/publishedInfo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/matter.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterManager.js'/>"></script>
<!-- script type="text/javascript" src="<c:url value='/dwr/interface/WorkspanManager.js'/>"></script -->
<!-- script type="text/javascript" src="<c:url value='/dwr/interface/PriceManager.js'/>"></script -->
<!-- script type="text/javascript" src="<c:url value='/dwr/interface/PriceDetailManager.js'/>"></script -->

<script type="text/javascript" src="<c:url value='/dwr/interface/PublishedInfoManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/adver/publishService.js'/>"></script>



<content tag="heading"><fmt:message key="publishedInfoList.heading"/></content>
<meta name="menu" content="PublishedInfoMenu"/>

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
                    <span class="tile1" id="buttonTable">
                    
		 	
				             &nbsp;&nbsp;<fmt:message key="publishedInfoForm.title.broDate"/>:
				             <input name="bro_date" id="bro_date" value="" size="15" type="text" onclick="getDate()" readonly="true">
				             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						     <input type="button" name="Btn_build_bro" id="Btn_build_bro" value="<fmt:message key="publishedInfoForm.button.buid"/>"> 
						     <input type="button" name="Btn_print_bro" id="Btn_save_bro" value="<fmt:message key="publishedInfoForm.button.save"/>"> 
				             <input type="button" name="Btn_preView_bro" id="Btn_preView_bro" value="<fmt:message key="publishedInfoForm.button.preView"/>"> 
				             <input type="button" name="Btn_print_bro" id="Btn_print_bro" value="<fmt:message key="publishedInfoForm.button.print"/>">
				             <input type="button" name="Btn_export_bro" id="Btn_export_bro" value="export">  
				             <span id="progressMsg" style="display:none;"><img alt="Indicator" src="<c:url value='image/indicator.gif'/>"  width="14" heigth="14"/> Loading...</span>
		                 
                    
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


<table width="100%" border="1" cellpadding="0" cellspacing="0">
  <tr> 
    <td rowspan="2" valign="top" width="22%">
    <table width="100%" border="0" cellpadding="0" cellspacing="0"  id="treeTable">
        <tr> 
          <td>
          
          	<table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr><td><table width="100%">
              			 <tr>
			                <td align="center">
			                    <input style="cursor: pointer;" name="radiobutton" id="radiobutton1" type="radio"  value="radiobutton" checked>
			                    <!-- ±àÅÅ -->
								<label style="cursor: pointer;width:20px;" for="radiobutton1"><fmt:message key="publishedInfoForm.title.edit"/></label>
								</td>
			                <td align="center">
			                    <input style="cursor: pointer;" name="radiobutton" id="radiobutton2" type="radio" value="radiobutton">
			                    <!-- µæÆ¬ -->
								<label style="cursor: pointer;width:20px;" for="radiobutton2"><fmt:message key="publishedInfoForm.title.forceIn"/></label>
							</td>
			              </tr>
              		 </table>
              	  </td>
              </tr>	  	 	
               <tr> 
                <td colspan="2" ><hr></td>
               </tr> 
                
                 
            </table>
            
            </td>
        </tr>
        <tr> 
          <td align="center">
          
				<table width="98%" id="carrierTypeTreeTable">
				  <tr>
				    <td>
				        <!-- resource tree -->
	                	<div id="carrierTypeTreebox" 
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
			<td>
				<table width="98%" id="matterTreeTable">
				  <tr>
				    <td>
	                	<div id="matterTreebox" 
							 style="width:100%; 
							 height:100px;
							 background-color:#f5f5f5;
							 border :1px solid Silver;"/>
					</td>
				  </tr>
				</table> 
			</td>
		</tr>
        
        <tr> 
          <td align="center">
          
            <!---------------------------------------------------->     

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


<iframe src='about:blank'   scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
<form name="ReportForm" id="ReportForm">
<input type="hidden" name="carrierName" id="carrierName" value="">
<input type="hidden" name="resourceIds" id="resourceIds" value="">
<input type="hidden" name="publishDate" id="publishDate" value="">
<input type="hidden" name="model" id="model" value="">
</form>
