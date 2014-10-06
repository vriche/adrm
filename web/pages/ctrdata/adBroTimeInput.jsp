<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title>广告时间录入</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<content tag="heading">广告时间录入</content>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>




<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_start.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_nxml.js'/>"></script>    
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_splt.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_drag.js'/>"></script>  
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_srnd.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/ext/dhtmlXgrid_colspan.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/ext/dhtmlxgrid_group.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/class/carrierType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customerProduct.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resourceChannel.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resourceSort.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderCategory.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/ctrData.js'/>"></script>


<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>		        
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDayInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceChannelManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceSortManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderCategoryManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/PublishArrangeManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/extutils.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/ComboBoxTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.plugins.GridCombox.js'/>"></script>




<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/gridfilters/menu/ListMenu.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/gridfilters/menu/RangeMenu.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/gridfilters/GridFilters.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/gridfilters/filter/Filter.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/gridfilters/filter/StringFilter.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/gridfilters/filter/NumericFilter.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/gridfilters/filter/DateFilter.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/gridfilters/filter/ListFilter.js'/>"></script>





<script type="text/javascript" src="<c:url value='/scripts/adver/adBroTimeInputService.js'/>"></script>


<style type="text/css">  
   .textfield-align-center{  
            text-align:center  
        }  
        
		.textfield-align-right{
    text-align: right;
    background: yellow;
    cursor: pointer;
    font-weight : bold;
    
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
	                 <td width="1px" > &nbsp; </td>
	                 <td width="1px" > <div id="year_render_div"/></td>
	                 <td width="1px" id="orgId_td"> <select id="orgId"/></td>
	                 <td  width="50px"> 播出时间 </td>
	                 <td width="1px"> <div id="resource_date_render_div"/> </td>
	                 <td  id="shiduan_desc" align="left" style=""> </td>
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
            
            <div id="adBroTimeInput_const_div" style="height:100%">
                          
 
								 <table width="100%" border="0" cellspacing="0" cellpadding="0">
								      <tr>
								      
									    <td valign="top" width="25%">
																	<div id="resource_grid_render_div"/>
									     </td>	
 
									    <td valign="top" width="45%">
																	 <div id="adResCount" style="width:100%" >
																			 <div id="gridbox" width="100%" height="100%" align="left" style="background-color: white; overflow: hidden"></div>
																		</div>	 
									     </td>			
									     							     
									     							     
										    <td valign="top" width="30%">
																			<div id="ctrdata_grid_render_div"/>
									     </td>									     
									     
								    </tr>
								 </table>
								 
 							<div>
 
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


										 <div id="adResCount2" style="width:1%;display:none" >
																			 <div id="gridbox2" width="100%" height="100%" align="left" style="background-color: white; overflow: hidden"></div>
											</div>

