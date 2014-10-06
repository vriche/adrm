<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="customerForm.unify"/></title>
<content tag="heading"><fmt:message key="customerForm.unify"/></content>
<meta name="menu" content="Customer"/>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>"

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXTree_ed.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_drag.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_srnd.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_start.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/popupWindow.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/crm/customerUnifyService.js'/>"></script>


<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                 
                    <td valign="top"> <fmt:message key="customerForm.customerName"/>
                    	 <input name="customerName" id="customerName" type=text>
						
						<input type="button"  id="unify" value='<fmt:message key="customerForm.unify"/>'>
						<fmt:message key="customerForm.unifyName"/>
						<input name="customerName2" id="customerName2" type=text>	
						
						<input type="hidden"  id="customerId">
						
						
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



<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="20%">
    
    
		<table width="100%" border="0" cellpadding="0" cellspacing="0"> 	       
		<tr>
		<td>
				      <table border="0" cellpadding="0" cellspacing="0">
		                  <tr>  <!-- 客户信息 -->
		                    <td align="left" ><fmt:message key="customerForm.unifyName"/></td>
		                 
		                  </tr>
					    </table>
				  </td>
		        </tr>
		 
		        <tr>
		          <td width="20%" vAlign="top">
		          
					<div id="customer2Treebox" 
						 style="width:100%; 
						 height:470px;
						 width:220px;
						 background-color:#f5f5f5;
						 border :1px solid Silver;"/>
		          
		          </td>
		         </tr>
	        </table>
	    </td>    
	    
	      <td>&nbsp;&nbsp;</td> 
	      <td>&nbsp;&nbsp;</td> 
	      <td>&nbsp;&nbsp;</td>
	    
	    <td valign="top">
	    
			      <table border="0" cellpadding="0" cellspacing="0">
		                  <tr>  <!-- 客户信息 -->
		                    <td align="left"><fmt:message key="customerForm.unifyedName"/></td>
		                 
		                  </tr>
					    </table>
					    
		     		<div id="customerTreebox" 
						 style="width:100%; 
						 height:470px;
						 width:220px;
						 background-color:#f5f5f5;
						 border :1px solid Silver;"/>             
			
		               
			
	 
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