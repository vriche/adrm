<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title><fmt:message key="adResourceQuery.title"/></title>
<content tag="heading"><fmt:message key="adResourceQuery.heading"/></content>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/common/hashMap.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_start.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_nxml.js'/>"></script>    
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_splt.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/ext/dhtmlxgrid_export.js'/>"></script>




<script type="text/javascript" src="<c:url value='/scripts/class/carrierType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customerProduct.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resourceChannel.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resourceSort.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/orderCategory.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>		        
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderDayInfoManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceChannelManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceSortManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderCategoryManager.js'/>"></script>

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




<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/plus/gridfilters/css/GridFilters.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/plus/gridfilters/css/RangeMenu.css'/>" />


<script type="text/javascript" src="<c:url value='/scripts/adres/queryAdres2.js'/>"></script>

  <style type='text/css'>
  
  .red {
	BORDER-RIGHT: #000000 2px solid; BORDER-TOP: #d0d0d0 2px solid; BORDER-LEFT: #d0d0d0
	2px solid; COLOR: #ffffff; BORDER-BOTTOM: #000000 2px solid; BACKGROUND-COLOR: red;
  } 
   .green {
	BORDER-RIGHT: #000000 2px solid; BORDER-TOP: #d0d0d0 2px solid; BORDER-LEFT: #d0d0d0
	2px solid; COLOR: #ffffff; BORDER-BOTTOM: #000000 2px solid; BACKGROUND-COLOR: green;
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
                  
                  <td width="1px" id="orgId_td"> <select id="orgId"/></td>

	                 <td  width="1%"><div id="printReportDiv1" name="printReportDiv1"/></td> 
	                 <td  width="1%"><div id="printReportDiv7" name="printReportDiv7"/></td> 
	                 <td  width="1%"><div id="printReportDiv2" name="printReportDiv2"/></td> 
	                 <td  width="1%"><div id="printReportDiv3" name="printReportDiv3"/></td> 
	                 <td  width="1%"><div id="printReportDiv4" name="printReportDiv4"/></td> 
				     <td width="1px">
							    <select id="seach_type"  style="CURSOR: pointer;">
								   		 <option value="1"><fmt:message key="orderDayInfoForm.usedTimee"/></option>
							             <option value="2"><fmt:message key="orderDayInfoForm.leaveTime"/></option>
								 </select>
		             </td>       
		             
				     <td width="1px">
							    <select id="unitss"  style="CURSOR: pointer;">
								   		 <option value="2" selected>��</option>
								   		 <option value="1" >����</option>
								 </select>
		             </td>  
		             		                       
                     <td  width="98%" align="center"  valign="center"><span id="title" style="font-weight: bold;"/></td> 
                     

                     <td>&nbsp;</td>		
                     
	   				 <td class="red"   align="middle" width="1px"><input  type="text" value="��ʱ"  width="30px" class="myLable2"></td><!--��ʱ-->
					 <td class="green" align="middle" width="1px"><input  type="text" value="ʣ��"  width="30px" class="myLable3"></td><!--ʣ��-->
			                 			

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
            
		 						<div id="adResCount" >
									 <div id="gridbox" width="100%" height="100%" align="left" style="background-color: white; overflow: hidden"></div>
								</div>	           
            

		


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


