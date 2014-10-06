<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="orderCategoryList.title"/></title>
<content tag="heading"><fmt:message key="orderCategoryList.heading"/></content>
<meta name="menu" content="OrderCategoryMenu"/>


<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/orderCategory.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrderCategoryManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/admin/orderCategoryService.js'/>"></script>


<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                
                  <tr> 
                  
                  <td width="1px"><select id="order_year"  style="CURSOR: pointer;" /></td>
                  
      
                    <td width="1%" id="orgId_td"> <select id="orgId" name="orgId"/></td>
                    
                    <td align="left" valign="left">
                    	<a  id="Btn_add"  class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
                    </td>
                    
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


<table width="100%" border="1">
  <tr>
	<td width="20%" vAlign="top">
			<div id="orderCategoryTreebox" 
				 style="width:100%; 
				 height:500px;
				 background-color:#f5f5f5;
				 border :1px solid Silver;"/>
				 								
	</td>
	<td vAlign="top">  
	
	 <fieldset style="width: 97%" id="orderCategoryList"> 
           <legend></legend>	
			<table  id="orderCategoryTable" class=ListShort width="100%" cellpadding="0" >
              <thead>
                <TR class=Header>  
                  <!--标题-->
                  <TH><fmt:message key="orderCategoryForm.name"/></TH>
                  <!--文档编号-->
                  <TH><fmt:message key="orderCategoryForm.value"/></TH>
                  <!--备注-->
                  <TH><fmt:message key="orderCategoryForm.calculateAuto"/></TH>
                  
                                   
                  <TH id="Image_add" colspan="2"> 
                  		<img src="image/CRM_ADD.GIF" border="0"> 
                  </TH>
                </TR>
                
                <tr > 
                  <td colspan="10">
	                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                      <tr> 
	                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
	                      </tr>
	                    </table>
                    </td>
                </tr>
              </thead>
              
              <tbody id="orderCategoryBody"/> 
		
	          <tbody>
	          <tr height="20"><td colspan="7">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
			  				 <tr>
				  				 	 <td colspan="2"><IMG src="image/s.gif"  width="100%" height="2">
				  				 	 </td>
				  				 </tr>
		                        <tr  bgcolor="#D8DFE7"> 
		                          <td align="right"> 
		                              <div id="orderCategoryPageInfo"></div>
		                          </td>
		                     	</tr>
				  </table>
	          </tr>
	          </tbody>
     </table>  
	 </fieldset>
		
	 <fieldset style="width: 97%" id="orderCategoryForm"> 
           <legend></legend>
        <fieldset>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
		   <tr> 
		   <td width="50%">	    
		
			<table width="30%" border="0" cellspacing="0" cellpadding="0">
			<tbody>
			    <tr> 
				    <td nowrap="nowrap" class="requiredInput">
				    	<fmt:message key="orderCategoryForm.name"/>:       	
			        </td>
			        <td><input name="text" type="text" id="name"></td>
				</tr>
			    <tr> 
				    <td nowrap="nowrap" class="requiredInput">
				    	<fmt:message key="orderCategoryForm.value"/>:       	
			        </td>
			        <td><input name="text" type="text" id="value"></td>
				</tr>
			    <tr> 
				    <td width="50%" nowrap="nowrap" class="dataLabel">
				    	<fmt:message key="orderCategoryForm.calculateAuto"/>:       	
			        </td>
			        <td><input name="text" type="text" id="calculateAuto"></td>
				</tr>
			</tbody>
		 </table>
		 </td></tr>
		 </table>
		</fieldset>
		&nbsp;&nbsp;
		<fieldset>
		<table width="26%" border="0" cellspacing="0" cellpadding="0">
			 <tr>
				<td align="center">
				        
						<input type="button" id="Btn_save_orderCategory" value="<fmt:message key="button.save"/>" >
						<input type="button" id="Btn_cancel_Edit" value="<fmt:message key="button.cancel"/>">
		
				 </td>
			</tr>
		</table>
		</fieldset>
 	</fieldset>
 
	<div style="display:none;">
	
	displayNo:<input name="text" type="text" id="displayNo">
	nodeLevel:<input name="text" type="text" id="nodeLevel">
	nodePath:<input name="text" type="text" id="nodePath">
	parentId:<input name="text" type="text" id="parentId">
	version:<input name="text" type="text" id="version" value='0'>
	
	
	<br>
	
	categoryId:<input name="text" type="text" id="category_id">
	 
	</div>    
           
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
