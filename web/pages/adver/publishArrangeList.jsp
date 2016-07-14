<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title><fmt:message key="publishArrangeList.title"/></title>
<content tag="heading"><fmt:message key="publishArrangeList.heading"/></content>
<meta name="menu" content="PublishArrangeMenu"/>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXMenu/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/prototypeUI/ptotoyeUI.css'/>" / >

<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

 
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_drag.js'/>"></script>  
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_srnd.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_start.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/hashMap.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/contractpayment.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrierType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/publishArrange.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/publishArrangeDetail.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/matter.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/matterType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/order.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/ContractPaymentManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDetailManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/PublishArrangeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/PublishArrangeDetailManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/WorkspanManager.js'/>"></script>  

<script type="text/javascript" src="<c:url value='/scripts/localStorage/store.min.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/adver/publishArrangeService.js'/>"></script>



<content tag="heading"><fmt:message key="publishedInfoList.heading"/></content>
<meta name="menu" content="PublishedInfoMenu"/>

<input id="ctxPath" type="hidden" value="<c:url value="/"/>">
<style>
	body {font-size:12px}
	.{font-family:arial;font-size:12px}
	h1 {cursor:hand;font-size:16px;margin-left:10px;line-height:10px}
	xmp {color:green;font-size:12px;margin:0px;font-family:courier;background-color:#e6e6fa;padding:2px}
	div.hdr{
		background-color:lightgrey;
		margin-bottom:10px;
		padding-left:10px;
	}
</style>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 

                     <td width="1px"><input style="cursor: pointer;" name="radiobutton" id="radiobutton1" type="radio"  value="radiobutton" checked></td> 
                     <td width="1px"> <input  type="text" value="编排"  width="30px" class="myLable2" style="cursor: pointer;" id="Lable_radiobutton1"></td> 
                     <td width="1px"> <input style="cursor: pointer;" name="radiobutton" id="radiobutton2" type="radio" value="radiobutton"></td>     
                     <td width="1px"><input  type="text" value="垫片"  width="30px" class="myLable2" style="cursor: pointer;" id="Lable_radiobutton2"></td> 
                     <td width="1px"> <input style="cursor:" size=10 name="bro_date" id="bro_date" type="text" readonly="true" ></td>   
                     
                     <td width="1px" id="buttonTable">   
          
                         <table border="0" cellpadding="0" cellspacing="0" width="1px">
                         <tr>
                          <td width="1px" id="div_auto_publicAD_auto">
                              <table border="0" cellpadding="0" cellspacing="0" width="1px" >
                                <tr>
    		                      <td width="1px"><input style="cursor: pointer;" name="Checkbox_publicAdAutoFill" id="Checkbox_publicAdAutoFill" type="checkbox"  value="0" checked> </td> 
    		                      <td width="1px"><label for="Btn_publicAdAutoFill" style="cursor: pointer;" >
    		                      <input name="Btn_publicAdAutoFill" id="Btn_publicAdAutoFill"  type="text" value="自动公益"  style="width:56px;cursor: pointer;" class="myLable2" >
    		                      </label></td>
    		                      </tr>
    		                      </table>
		                       </td>   
		                     
		                      <td width="1px"> <input class="button" name="Btn_build_bro" id="Btn_build_bro" type="button" value='建立'></td>   
		                      <td width="1px"> <input class="button" name="Btn_build_bro_backup" id="Btn_build_bro_backup" type="button" value='载入备份'></td>
		     
		                      
		                     <adrm_order:authorizeTag res="tag_publish_arrange">  
		 					 <td width="1px"> <input class="button" name="Btn_save_bro" id="Btn_save_bro" type="button" value='保存'></td>   
		                     </adrm_order:authorizeTag>  
		                     
		                     <!-- td width="1px"> <input class="button" name="Btn_preView_bro" id="Btn_preView_bro" type="button" value='预览'></td>   
		                     <td width="1px"> <input class="button" name="Btn_print_bro" id="Btn_print_bro" type="button" value='打印'></td>   
		                     <td width="1px"> <input class="button" name="Btn_export_bro" id="Btn_export_bro" type="button" value='导出'></td -->   
		                    
		                      <td width="1px">
						             <div id="theDivExport" style="position:absolute;  OVERFLOW: auto;right:340px;top:100px;width:300px;height:150px;visibility:hidden;border:solid blue 1px;background-color:white;z-index:1">	
								             <input type='radio' name='export' id='allExport'> AllExport<br/>  
					            		 	 <input type='radio' name='export' id='timeExport' checked> TimeExport <br/>   
					            		 	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;startTime	<input type='text' name='startTimeExportH' id='startTimeExportH' value='08' size=3>:<input type='text' name='startTimeExportM' id='startTimeExportM' size=3 value='00'><br/>
					            		 	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;endsTime	<input type='text' name='endTimeExportH' id='endTimeExportH' value='18' size=3>:<input type='text' name='endTimeExportM' id='endTimeExportM' size=3 value='00'><br/>
					            		 	 <input type='radio' name='export' id='importExport'> ImportExport	<br/>  
					            		         <br/>     <br/>
					            		 	 <input class="button" type="button" id="btn_exportFile" value="&nbsp;&nbsp;&nbsp;OK &nbsp;&nbsp;&nbsp;"> 
					        				 <input  class="button"  type="button" id="btn_cancelExport" value="&nbsp;CANCEL &nbsp;">   
				            		 </div>
		                      </td>   
		                      
		                       <td width="1px"> <input name="Btn_move_up" id="Btn_move_up" type="hidden" value='move up'></td> 
		                       <td width="1px"> <input  name="Btn_move_down" id="Btn_move_down" type="hidden" value='move down'></td> 
		                       <td width="1px"> <input  name="bro_date_history" id="bro_date_history" type="hidden" onclick="getDate2('bro_date_history')" size='12'></td>   
		                       <td width="1px"> <input  name="Btn_load_history" id="Btn_load_history" type="hidden"  value='参考历史'></td>  
		                        
		                     
		                        <!-- td width="1px"> <input  class="button" name="displayTree" id="displayTree" type="hidden" value="隐藏"></td -->   
						        <adrm_order:authorizeTag res="tag_publishArrange_print2">
		                  		   <td width="1px"> <input class="button" name="Btn_forPrint" id="Btn_forPrint" type="button" value='<fmt:message key="publishedInfoForm.button.print2"/>'></td>   
		                       </adrm_order:authorizeTag>
	                       
                           </tr>
                           </table>
                       
                    </td>        
                       
                        <td width="1px"> <input class="button" name="Btn_removeRow" id="Btn_removeRow" type="button" value='删除'></td>   
                      
                        
                        <td width="1px" id="buttonImport">
                        
	                         <table border="0" cellpadding="0" cellspacing="0" width="100%">
	                         <tr>
			                     <!--导入-->
			                     <td width="1px"  style="display:none"><input  style="CURSOR: pointer;" type="button" id="btn_import" value="&nbsp;<fmt:message key="publishArrangeList.import"/>...&nbsp;"> </td>   
								<td width="1px" style="display:none">
						            <div id="theDivSearch" style="position:absolute;  OVERFLOW: auto;right:140px;top:100px;width:500px;height:300px;visibility:hidden;border:solid blue 1px;background-color:white;z-index:1">	
						                    <iframe style="display:none;" src='about:blank'   scrolling="no" height="0" width="0" name="targetForm" id="targetForm"></iframe>
						                    <form name="myform" id="myform" action="<c:url value='/importExcelServlet'/>" enctype="multipart/form-data" method="post" >  
						        					<input   class="button" type="hidden" name="type" id="type" value="1"/>
													<input   class="button" type="hidden" name="userId" id="userId"/>           
													<input   class="button" type="hidden" name="publishDates" id="publishDates"/>
													<input   class="button" type="hidden" name="carrierIds" id="carrierIds"/>
						        					<fmt:message key="orderDayInfoForm.pickMonth"/><fmt:message key="audienceRat.startProgress"/><input class="default" type="file" id="file1" name="file1"/><br/><br/><br/><br/>
						        					<input   class="button" style="CURSOR: pointer;" type="button" id="btn_importFile" value="&nbsp;<fmt:message key="button.confim"/>&nbsp;"> 
						        					<input   class="button" style="CURSOR: pointer;" type="button" id="btn_cancelImport" value="&nbsp;<fmt:message key="button.cancel"/>&nbsp;"> 
											</form>
						            </div> 
					            </td>   
					            <td width="1px"> <input   class="button" type="button" id="btn_deleteImport" value="&nbsp;<fmt:message key="button.delete"/><fmt:message key="publishArrangeList.import"/>&nbsp;"></td>   

                           </tr>
                           </table>
                        </td> 
                       <td width="1px" ><div id="printReportDiv" name="printReportDiv"/></td>  
                        <td width="1px"> <input style="cursor:" size=12 name="reference_date" id="reference_date" type="text" readonly="true" ></td>   
                        <td width="1px"> <input class="button" name="Btn_reference" id="Btn_reference" type="button" value='参考编排'></td>   
                      <td>&nbsp;</td>  
                      <td width="1px" id="orgId_td"><select id="orgId"/></td>                

                      
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
  
    <td  valign="top" id="treeBoxTd" >
    
    
    
    
    
    
    
    
    
    
    
    
		    <table width="100%" border="0" cellpadding="0" cellspacing="0"  id="treeTable">
		        <tr> 
		          <td align="center" >
		          
						<table width="100%" id="carrierTypeTreeTable">
						  <tr>
						    <td >
						        <!-- resource tree -->
			                	<div id="carrierTypeTreebox" ;
									  style="width:200px;display:block; 
									 height:400px;
									 background-color:#f5f5f5;
									 border :1px solid Silver;"/>
								
							</td>
						  </tr>
						</table>          
		
				  </td>
		        </tr>
				
				<tr>
					<td>
						<table width="100%" id="matterTypeTreeboxTable">
						  <tr>
						    <td>
			                	<div id="matterTypeTreebox"; 
									 style="width:200px; display:none; 
									 height:400px;
									 background-color:#f5f5f5;
									 border :1px solid Silver;"/>
							</td>
						  </tr>
						</table> 
					</td>
				</tr>
		      </table>
      
      </td>
      
      
    <td valign="top"> 
      <!-- grid -->
	  <div id="gridbox" width="100%" height="100%" style="background-color:white;border:1px "></div>
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



<iframe style="display:none;" src='about:blank'   scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
<form name="ReportForm" id="ReportForm">

<input type="hidden" name="carrierLevelFirstId" id="carrierLevelFirstId" value="">
<input type="hidden" name="carrierName" id="carrierName" value="">
<input type="hidden" name="parentName" id="parentName" value="">
<input type="hidden" name="resourceIds" id="resourceIds" value="">
<input type="hidden" name="publishDate" id="publishDate" value="">
<input type="hidden" name="bianpainame" id="bianpainame" value="">
<input type="hidden" name="model" id="model" value="">
<input type="hidden" name="carrierId" id="carrierId" value="">
<input type="hidden" name="importType" id="importType" value="">
<input type="hidden" name="startTime" id="startTime" value="">
<input type="hidden" name="endTime" id="endTime" value="">
<input type="hidden" name="printOrgid" id="printOrgid" value="">
<input type="hidden" name="version" id="version" value="">

</form>

