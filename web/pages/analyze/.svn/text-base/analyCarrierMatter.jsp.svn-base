<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="analyCarrierMatter.title"/></title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>


<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>		        
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/dwr/interface/analyzeClassManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/AnalyCarrierMatterManager.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>	


<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_drag.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_srnd.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_start.js'/>"></script>        
		        
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/analyzeClass.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrierType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/analyze/analyCarrierMatterService.js'/>"></script>

<content tag="heading"><fmt:message key="carrierScopeAnalyze.title"/></content>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                  
                 	 <td width="1%"><input type="text" value="开始"  width="120px" class="myLable2"/></td>
					 <td width="1%"><input type ="text" id ="beginDate" name="beginDate" size=10></td>
				
 					 <td width="1%"><input  type="text" value="结束"  size="6" class="myLable2"/></td>
					 <td width="1%"><input type ="text" id ="overDate" name="overDate" size=10></td>      
                  
   					 <!-- td width="1%"> <select name="userOwner" id="userOwner" /></td>
					 <td width="1%"><select name="select" id="carrierName"/></td -->           
                  
                    <td width="1%"><input type="button"   class="button" id="search" value='查询'>	</td>   
                    
                     <td width="1%"><input type="button"   class="button" id="Btn_view_order" value='预览'>	</td> 
                     <td width="1%"><input type="button"   class="button" id="Btn_print_order" value='打印'>	</td> 
                     <td width="1%"><input type="button"   class="button" id="Btn_export_order" value='导出'></td> 
                      
	                  <td>&nbsp;</td>
	                  
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

	 <fieldset id="adResCount">
	 
	<legend> </legend>
	<table width="100%" border="1" cellspacing="0" cellpadding="0">

		<tr>
			<td width="22%">
			  <table width="100%" border="0"  cellspacing="0" cellpadding="0">
				 <tr>
	              	<td id="treebox">			  
		              	<table width="100%" border="1">
							 <tr>
				              	<td align="left">
									<div id="carrierTypeTreebox" 
										 style="width:100%; 
										 height:470px;
										 background-color:#f5f5f5;
										 border :1px solid Silver;"/>
								 </td>
						     </tr>
					     </table>
					 </td>
					 
					 <td  id="analyCarriermatter_div" valign="top" width="78%">
						
						 
							<div id="gridbox" width="100%" height="100%" style="background-color:white;"></div>
							
						
					 </td>
					 
			     </tr>
			   </table>
			</td>
		</tr>
	</table>
</fieldset>	

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
<form name="ReportForm" id="ReportForm" method="post">
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="reportType" id="reportType" value="">
	<input type="hidden" name="resourceIdForm" id="resourceIdForm" value="">
	<input type="hidden" name="startForm" id="startForm" value="">
	<input type="hidden" name="endForm" id="endForm" value="">
	
</form>


  	  	    