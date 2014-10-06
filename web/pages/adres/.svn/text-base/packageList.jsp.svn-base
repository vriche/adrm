<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="packageForm.heading"/></title>
<content tag="heading"><fmt:message key="packageForm.info"/></content>
<meta name="menu" content="OrderMenu"/>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/priceDetail.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/compages.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrierType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/price.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resourceSort.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/priceType.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/PriceManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/PriceDetailManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CompagesManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceSortManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/PriceTypeManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/adres/compageService.js'/>"></script>

<input id="ctxPath" type="hidden" value="<c:url value="/"/>">   

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                   <td width="1px" id="orgId_td"> <select id="orgId"/> </td>  
                   
                   <td width="1px"><select id="resource_year"  style="CURSOR: pointer;" /></td>
                   


                     <td width="1px"> <select name="resourceSortId" id="resourceSortId" style="width:80px;margin-left:-100px;CURSOR: pointer;font-size:13px; " /></td>   
                     <td width="1px"><input type="button"    class="button"id="Btn_addCompages" value='新添套装'></td>         
                    
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
    <td>
    
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td background="images/table1/textbox_left.gif" width="14"></td>
            <td bgcolor="#f4f3f4">


<table width="100%" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td width="20%" valign="top">
    	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	        <tr>
	          <td valign="middle">
	                  <!--baseinso start-->
	                  <div align="center"> 
	                  
	                    <table width="96%" border="0" cellspacing="0" cellpadding="0">
                      <tr> 
                       <td>&nbsp;</td>
                       <td style="CURSOR: pointer;">
                       
                           <input name="radiobutton" id="radiobutton1" type="radio" onClick="window.location.href='resources.html'" value="radiobutton" checked>
                           <label for="radiobutton1" class="choice">时段</label>
						 </td>
						<td>&nbsp;</td>
                        <td style="CURSOR: pointer;"><input name="radiobutton" id="radiobutton2" type="radio" value="radiobutton" onClick="window.location.href='javascript:void 0'">
                   
						
						  <label for="radiobutton2" class="choice">套装</label>
						  </td>
                      </tr>
	                    </table>
	                    
	                    
	                    
	                    
	
                    
                    
	                    
	                  </div>
                  <!--baseinso end-->
	          </td>
	        </tr>
	        <tr>
	          <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
	         		<tr><td>
	                        	<div id="compagesTreebox" 
								 style="width:100%; 
								 height:475px;
								 background-color:#f5f5f5;
								 border :1px solid Silver;"/>
					</td></tr></table>			 
			  </td>
	        </tr>
        </table>
    </td>
    <td width="80%" valign="top">
    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	        <tr> 
	          <td>
				<table width="100%" border="0">
	              <tr>
	               
	               	<td width="60px" align="right">价格类别:</td>
	               	<td width="1px"><select name="resourcePriceType" id="resourcePriceType"/></td>
	         
					<td width="60px" align="right">套装名称:</td>
		            <td width="1px"><input type="text" name="packageName" id="packageName"></td>
		         
					<td width="55px" align="right"><font color="#000000" size="1.5">是否有效:</font></td>
		            <td width="1px"><input type="checkbox" name="checkbox"  id="enable" value="checkbox"></td>
		        
					<td width="55px" align="right"><font color="#000000" size="1.5">手动价格:</font></td>
	                <td width="1px"><input type="checkbox" name="checkbox" id="isAutoPrice" value="checkbox"></td>
	                
	                <td>&nbsp;</td>
	              </tr>
	            </table>	          
	          </td>
	        </tr>
	        
	        <tr> 
	          <td valign="top">



				<fieldset style="width:100%" id="manin_body">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
	              <tr> 
	                <td width="80%" valign="top">
	                	<table width="100%" border="1" cellspacing="0" cellpadding="0">
	                		<tr>
	                			<td>
				                  <table  id="priceDetailList" class=ListShort width="100%" border="0" cellspacing="0" cellpadding="0" >
				                    <thead>
				                      <tr class=Header> 
				                        <!--长度-->
				                        <th><fmt:message key="orderDetailForm.tb.len"/></th>
				                        <!-- 价格 -->
				                        <th><fmt:message key="resourceForm.title.price"/></th>
				                        <th id="button_add_new_obj"  style="cursor:hand" colspan="2" onClick="button_add_new_obj(1)"> 
				                          <img id="priceDetailImgAdd" name="priceDetailImgAdd"  src="image/CRM_ADD.GIF" border="0"> 
				                        </th>
				                      </tr>
				                      <tr> 
				                        <td colspan="4"> <table width="100%" border="0" cellspacing="0" cellpadding="0">
				                            <tr> 
				                              <td class=blackLine><img src="image/s.gif"  width=1 height=1></td>
				                            </tr>
				                          </table></td>
				                      </tr>
				                      
				                      <tbody id="priceDetailBody"/>
				                    
				                    </thead>
				                  	 <tbody>
								          <tr><td colspan="4">
												<table width="100%" border="0" cellspacing="0" cellpadding="0">
										  				 <tr>
										  				 	 <td colspan="2"><IMG src="image/s.gif"  width="100%" height="2">
										  				 	 </td>
										  				 </tr>
								                        <tr  bgcolor="#D8DFE7">
								                          <td align="right"> 
								                              <div id="pageInfopriceDetail"></div>
								                          </td>
								                     	</tr>
											  </table>
											  </td>
								          </tr>
								    </tbody>
				          
				          			</table>
				                  
		                  		</td>
		                  	</tr>
	                    </table>
	                </td>
	                
	        
	                
	                <td width="32%" valign="top" align="right"> 
	                	<table border="0" cellspacing="0" cellpadding="0">
	                		<tr>
	                			<td>
	                				<div id="carrierTypeTreebox" 
										 style="width:200px; 
										 height:300px;
										 background-color:#f5f5f5;
										 border :1px solid Silver;"/></td>
								</td>
							</tr>
						</table>
					</td>
	              </tr>
	            </table>
	            
	          </td>
	      </tr> 
	     </table>   
	     </fieldset>
	     
	     
	     
	     	<table border="0" width="100%">
	     		<tr>
	     			<td>	     		
		              <div align="center"> 
		              <input type="button"    class="button" id="Bt_Save" value='保存'>
		              <input type="button"    class="button"  id="Bt_Delete" value='删除'> 

		              </div>		
	     			</td>
	     		</tr>
	     	</table>
	
	     
<div style="display:none;">

compagesId:<input name="text" id="packageId" value=""/>
priceId:<input name="text" id="packagePriceId" value=""/>
priceDetailId:<input name="text" id="priceDetailId" value=""/>

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