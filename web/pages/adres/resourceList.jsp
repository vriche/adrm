<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="resourceList.title"/></title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXMenu/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/winjs/alphacube.css'/>" />



<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXMenu/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />


<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>




 
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_drag.js'/>"></script>  
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_srnd.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_start.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_link.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_math.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxGrid/dhtmlXGrid_excell_calendar2.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>

<!-- script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_ext.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/window_effects.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/winjs/debug.js'/>"></script -->

<script type="text/javascript" src="<c:url value='/scripts/class/carrierType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/workspan.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/price.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/priceDetail.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resourceLimit.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resourceType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/mediaOrg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resourceChannel.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/workspan.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/resourceSort.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/WorkspanManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/PriceManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/PriceDetailManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceLimitManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MediaOrgManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceChannelManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/WorkspanManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/PriceTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/priceType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceSortManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/adres/resourceService.js'/>"></script>


<content tag="heading"><fmt:message key="resourceList.heading"/></content>
<meta name="menu" content="ResourceMenu"/>
<input id="ctxPath" type="hidden" value="<c:url value="/"/>">   

<!-- input name="date1" id="date1" value="" size="25" type="text" onclick="button_showdate('date1','anchor1')" -->
<!--  span id="anchor1" name="anchor1"></span -->


<table width="100%" border="0" cellpadding="0" cellspacing="0">   

  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>    
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                  
            <td width="1px" id="orgId_td"><select id="orgId"/></td>      
                
            <td width="1px"><select id="resource_year"  style="CURSOR: pointer;" /></td>     
                
                   
 			 <!-- td width="1px">
                            <select id="resource_year"  >
						    <% for(int i= 2008; i< 2014;i++){ %>
						   		 <option value="<%=i%>"><%=i%></option>
					            <%}%>
						    </select>
			</td -->
			
			<td width="1px">
			                   <select id="carrier_displayMode"  >
									   		 <option value="1">��ʾ����Ƶ��</option>
								             <option value="2">��ʾ����Ƶ��</option>
								</select>
			</td>				
			
			
 			 <td width="1px">
							<select name="resourceTypeName" id="resourceTypeName"/>
			</td>   
			<td width="1px" >
							<input id="btn_config" type="button"  class="button"  value="<fmt:message key="button.order.configType"/>">
			</td>      
			
			<td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Bt_addCarrierChild" value='��������'></td> 
			<td width="1px"><input type="button"    class="button" style="CURSOR: pointer;" id="Bt_addResourceChild" value='������Դ'></td> 		
			      
       		
             <td width="1px"><input type="button"    class="button"  id="Bt_ckeckAllTime" value='У��ʱ��'></td> 
            <td width="1px"><input type="button"    class="button"  id="Bt_reload" value='����ѡ��'></td> 
    		  <td  width="1px" ><div id="printReportDiv" name="printReportDiv"/></td>
           
					
                    
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


<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr> 
    <td  valign="top" align="left">
    
             
        			<table  id="resourceCompages" style="display:none;" width="96%" border="0" cellspacing="0" cellpadding="0">
                      <tr> 
                       <td>&nbsp;</td>
                        <td style="CURSOR: pointer;"><input name="radiobutton" id="radiobutton1" type="radio" value="radiobutton" checked>
                          <!-- ����λ�� --> 
						  
						  
						   <label for="radiobutton1" class="choice">ʱ��</label>
						   
						  </td>
						  
						  <td>&nbsp;</td>
						  
                        <td style="CURSOR: pointer;"><input name="radiobutton" id="radiobutton2" type="radio" value="radiobutton"">
                          <!-- �ײ���� -->						
						  <label for="radiobutton2" class="choice">�ײ�</label>
						  </td>
						  
						  <td>&nbsp;</td>
						   
				  
	
						  
                      </tr>
                    </table>   
          
    
    
    
              				<div id="carrierTypeTreebox" 
							 style="width:100%; 
							 height:470px;
							  width:220px;
							 background-color:#f5f5f5;
							 border :1px solid Silver;"/>
							<iframe name="actionframe" id="actionframe" frameborder="0" width="100%" height="0"></iframe>
      
      </td>
    <td  valign="top">
    
    
<!--main start-->

<fieldset name="resourceBody" id="resourceBody" style="display:none;width:99%;">


<html:form action="resources" target="actionframe2" method="post" styleId="resourceForm" onsubmit="return validateResourceForm(this)">


      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td> 
            <!--baseinso start-->
            <fieldset style="width:99%;">
            <legend> 
            <!-- ������Ϣ -->
            <fmt:message key="resourceForm.title.baseInfo"/> </legend>
            <table width="100%" border="0">
              <tr> 
                <td width="20%">
	                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
	                      <tr> 
	                        <td nowrap="nowrap" class="requiredInput"> 
	                          <!-- λ�� -->
	                          <fmt:message key="resourceForm.resourceName"/>: </td>
	                        <td ><input name="resourceName" type="text"  id="resourceName"></td>
	                      </tr>
	                      <tr> 
	                        <td height="26" nowrap="nowrap" class="dataLabel"> 
	                          <!-- ��ע -->
	                          <fmt:message key="resourceForm.memo"/>: </td>
	                        <td ><input name="memo" type="text"  id="memo"></td>
	                      </tr>

	                  </table>
                  </td>
                <td width="25%" >
	                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" id="ep">
	                      <tr style="display:none"> 
	                        <td align="right" width="50px"> ����:</td>
	                        <td width="1px"><select id="resourceType"/></td>
	                      </tr>
	                      
	                      
	                      
	                      
	                      <tr> 
	                        <td align="right"  width="50px">����:</td>
	                        <td>
		                         <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0"><tr> 
		                           <td width="1px" ><input type="checkbox" name="isValidate" id="isValidate" value="checkbox"></td>
			                        <td  width="1px"><input  type="text" value="Ԥ����"  class="myLable5" size="5"></td>
			                        <td width="1px">
				                        <select id="beforehand" name="beforehand" >
									    <% for(int i= 0; i< 30;i++){ %>
									   		 <option value="<%=i%>"><%=i%></option>
								            <%}%>
									    </select>
									</td>
									  <td>&nbsp;</td>
		                         </tr>
		                         </table>
                            </td>
				
	                      </tr>
	                  </table>
                  </td>
                <td>
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                      <tr> 
                        <td nowrap="nowrap" class="dataLabel"> 
                          <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                          
                          
                          	<tr id='other' style="display:none">
		                        <td  width="18px">ʱ������:</td>
		                        <td >
		                        <select name="resourceSortId" id="resourceSortId" style="width:80px;CURSOR: pointer;font-size:12px; " />
		                        <input type="hidden" name="displayNo" id="displayNo" size="3" value="" readonly>
		                        </td>
	                      </tr>
	                      
	                      
	                      <tr id='fztv'>
		                        <td  width="18px"> 
		                          <!--��ʱ���� -->
		                         <fmt:message key="orderForm.color.lable6"/><fmt:message key="publishedInfoForm.matterLength"/>:</td>
		                        <td align="left"><input type="text" name="overTime" id="overTime" size="5"></td> 
		                        
	                      </tr>
	                      </table>
                          </td>
                        <td ><fmt:message key="resourceForm.isClosed"/>:<input type="checkbox" name="isClosed" id="isClosed"  value="checkbox"></td>
                      </tr>
                      <tr> 
                        <td id='fztv' nowrap="nowrap" class="dataLabel" align="left">  
                          <!-- �������� -->
                          <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                          
                          
                          	<tr style="display:none">  
		                        <td  width="18px">��������:</td>
		                        <td ><input type="text" name="keepTime" id="keepTime" size="3"></td>  
	                      	</tr>
	                      	
	                      	
	                      </table>
                        </td>
                        <td><fmt:message key="resourceForm.isSeralized"/>:<input type="checkbox" name="isSeralized" id="isSeralized" value="checkbox"></td>
                      </tr>
                  </table>
                  
                  </td>
                <td>
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                      <tr> 
                        <td width="30%"  nowrap="nowrap" class="dataLabel"> 
                          <!-- ��Դͳ�� -->
                          <fmt:message key="resourceForm.isResourceAaacount"/>: 
                          <input type="checkbox" name="isOverweight" id="isOverweight" value="checkbox"> 
                        </td>
                      </tr>
                      <tr> 
                        <td width="30%" nowrap="nowrap" class="dataLabel"> 
                          <!-- �ֶ��۸� -->
                          <fmt:message key="resourceForm.isManual"/>: 
                          <input type="checkbox" name="isManual" id="isManual" value="checkbox"> 
                        </td>
                      </tr>
                  </table>
                  
                  </td>
                <td>

                </td>
                

              </tr>
            </table>
            </fieldset>
            <!--baseinso end-->
          </td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr> 
    <td> 
      <!--baseinso start-->
      <fieldset style="width:99%;">
      <legend>
      <!-- ��Ч��Ϣ -->
      <fmt:message key="resourceForm.title.workSpan"/> </legend>
      <div align="center"> 
        
        
        <table width="99%" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td >
            
                 <div style="display:none">
            	<table  id="mytb" class=ListShort width="100%" cellpadding="0" >
                  <thead>
	                  <tr class=Header2> 
	                    <th>
	                      <!-- ��ʼ���� --><fmt:message key="workspanForm.beginDate"/></th>
	                    <th>
	                      <!-- �������� --><fmt:message key="workspanForm.endDate"/></th>
	                    <th>
	                      <!-- ����ʱ�� --><fmt:message key="workspanForm.broadcastStartTime"/></th>
	                    <th>
	                      <!-- ����һ --><fmt:message key="workspanForm.monLength"/></th>
	                    <th>
	                      <!-- ���ڶ� --><fmt:message key="workspanForm.tueLength"/></th>
	                    <th>
	                      <!-- ������ --><fmt:message key="workspanForm.wenLength"/></th>
	                    <th>
	                      <!-- ������ --><fmt:message key="workspanForm.thiLength"/></th>
	                    <th>
	                      <!-- ������ --><fmt:message key="workspanForm.friLength"/></th>
	                    <th>
	                      <!-- ������ --><fmt:message key="workspanForm.satLength"/></th>
	                    <th>
	                      <!-- ������ --><fmt:message key="workspanForm.sunLength"/></th>
	                    
	                    <th width="10%" id="button_add_new_obj"  style="cursor:hand" colspan="2" onclick="button_add_new_obj(1)">
	                    
		                      <fmt:message key="button.operation"/>
		                      <img  name="Bt_addNewRowWorkspance" id="Bt_addNewRowWorkspance" src="image/CRM_ADD.GIF" border="0">
	                    
	                     </th>
	                              
	                  </tr>
						<tr > 
							<td colspan="12">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr> 
							 	<td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
							   	</tr>
							   	</table>
							</td>
						</tr>
				</thead>
			
				<tbody id="workspanBody"/>
			
				<tbody>
					<tr height="2"><td colspan="12">
						<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
							<tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
							<tr bgcolor="#eee"> 
								<td align="right"> 
									<div id="pageInfo_workspan"></div>
								</td>
							</tr>
						</table>	              
					</td></tr>
				</tbody>

        	</table>
        	
        	</div>
        	
        	<div id="gridbox" height="120px" width="100%" style="background-color:white;z-index:0;overflow:hidden"></div>
           
		 </td>
		</tr>
		</table>
      </div>
      </fieldset>
      <!--baseinso end-->
    </td>
  </tr>
</table>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr> 
    <td> 
      <!--baseinso start-->
     <fieldset style="width:99%;">
      <legend> 
      <!-- �۸���Ϣ -->
      <fmt:message key="resourceForm.title.priceInfo"/> </legend>
      <div align="center"> 
        <table width="99%" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
          </tr>
          <tr> 
            <td ><table  id="priceTable" class=ListShort width="100%" cellpadding="0" >
                 <thead>
	                  <tr class=Header> 
	                    <th>
	                      <!-- Ĭ�� -->
	                      <fmt:message key="priceForm.isDefault"/>
	                    </th>
	                    <th>
	                      <!-- �۸��� -->
	                      <fmt:message key="priceForm.name"/>
	                    </th>
	                    <th>
	                      <!-- �۸���� -->
	                      <fmt:message key="priceForm.resourcePriceType"/>
	                    </th>
	                    <th>
	                      <!-- �۸���� -->
	                      <fmt:message key="priceForm.isUseRegular"/>
	                    </th>
	                    <th>
	                      <!-- �۸���ϸ -->
	                      <fmt:message key="priceForm.priceDetails"/>
	                    </th>
	                    <th width="10%" id="button_add_new_obj"  style="cursor:hand" colspan="2" onclick="button_add_new_obj(2)">
	                      <fmt:message key="button.operation"/>
	                      <img  name="Bt_addNewPrice" id="Bt_addNewPrice" src="image/CRM_ADD.GIF" >
	                     </th>
	                  </tr>
						<tr > 
							<td colspan="7">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr> 
							 	<td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
							   	</tr>
							   	</table>
							</td>
						</tr>
				</thead>
			
				<tbody id="priceBody"/>
			
				<tbody>
					<tr height="2"><td colspan="7">
						<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
							<tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
							<tr bgcolor="#eee"> 
								<td align="right"> 
									<div id="pageInfo_price"></div>
								</td>
							</tr>
						</table>	              
					</td></tr>
				</tbody>
        	</table>
		 </td>
		</tr>
		</table>
          
        <table width="100%">
			  <tr>
			    <td>
			    <div align="center">
			    
			         <input type="button"    class="button"  id="Bt_saveResource" value='����'>
			         <input type="button"    class="button"  id="Bt_removeResource" value='ɾ��'>
			         <input type="button"    class="button"  id="Bt_importPrice" value='�۸���'>

			        
			        <div id="theDivSearch" style="OVERFLOW: auto;bottom:103px;right:75px;width:300px;height:28px;visibility:hidden;border:solid blue 1px;background-color:white;z-index:1">
				  			<table>
				  			<tr>
				  			
				  			 <td><select id="resource_price_year"  style="CURSOR: pointer;" /></td>     
				  		
				  			
				  			<td><div><select name="select" id="priceName"/></div></td>
				  			<td><input  style="CURSOR: pointer;" type="button" id="btn_importPrice" value="&nbsp;ȷ��&nbsp;"></td>
				  			<td><input  style="CURSOR: pointer;" type="button" id="btn_closePrice" value="&nbsp;ȡ��&nbsp;"></td>
				  			</tr></table>
				  	</div> 
			      </div>
			      
			      
			      
			      </td>
			  </tr>
		</table>
			
      </div>
      </fieldset>
      <!--baseinso end-->
    </td>
  </tr>
</table>

 <!-- �۸���� -->
<div id="hiddenArea" name="hiddenArea" style="display:none;">




<adrm_order:selectList name="resourcePriceTypes" key="7"  toScope="page"/>
<html:select property="resourcePriceType" styleId="resourcePriceType"  name="resourcePriceType"  value="0">
		<html:option value=""/>
		<html:options collection="resourcePriceTypes"  property="value" labelProperty="label"/>
</html:select>

</div>


</html:form>



</fieldset>	  
<!--main end-->	



<html:form action="saveCarrier" method="post" styleId="carrierForm" onsubmit="return validateCarrierForm(this)">

<!-- ������Ϣ  start-->
<fieldset name="carrierBody" id="carrierBody" style="display:block;width:99%;">

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr> 
    <td> 
      <!--baseinso start-->  
    <fieldset style="width:99%;">
      <legend><!-- ������Ϣ --><fmt:message key="carrierList.heading"/> </legend>
      <table width="99%" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td width="30%" valign="top"> 
          <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
              <tbody>
                <tr> 
                  <td nowrap="nowrap" class="dataLabel">
                  <!-- ���� --><fmt:message key="carrierForm.enable"/>: </td>
                  <td >
				       <input type="checkbox" name="enable" id="carrierEnable" value="checkbox">  
				  </td>
                </tr>
                <tr> 
                  <td nowrap="nowrap" class="requiredInput">
                  <!-- ���� --><fmt:message key="carrierForm.carrierName"/>:</td>
                  <td >
                   <input type="text" name="carrierName" id="carrierName"/>
                  </td>
                </tr>
              </tbody>
            </table></td>
          <td width="20%" valign="top"> 
          <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
              <tbody>
                <tr> 
                  <td nowrap="nowrap" class="dataLabel">�������
                  <!-- ý����� --><!-- fmt:message key="carrierForm.mediaOrgId"/ -->: 
                  </td>
                  <td >
                  
                       <!-- 
				       <adrm_order:selectList name="mediaOrgs" key="14" toScope="page"/>
				                <html:select property="mediaOrgId" styleId="mediaOrgId">       
							           <html:option value=""/>       
				                    <html:options collection="mediaOrgs" property="value" labelProperty="label"/>
				                </html:select>
				       <html:errors property="mediaOrgId"/>	
				       
				       -->
				       
				       
				        <select id="mediaOrgId"/>
				        
                    
                    </td>
                </tr>
                <tr> 
                  <td nowrap="nowrap" class="dataLabel" id='td1'> 
                  	<!-- ���� --><fmt:message key="carrierForm.aliasName"/>:
                  </td>
                  <td id='td2'>
                  	  <input type="text" name="aliasName" id="aliasName"/>
                  </td>
                  
                  <td nowrap="nowrap" class="dataLabel" id='td3'><fmt:message key="resourceForm.title.basePos"/>:</td>
                  <td id='td4'>
				       <input type="checkbox"  name="isBasePos" id="isBasePos" value="">  
				  </td>
                </tr>
              </tbody>
            </table></td>
          <td valign="top">
          
          <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
			  <tbody>	
                <tr> 
                  <td width="80px">Ƶ������:</td>
                  <td width="1px"> <select name="channelId" id="channelId"/></td>
                  <td>&nbsp;</td>      
                </tr>
                <tr> 
                 
                  <td width="80px">��������:</td>
                  <td  width="1px"><input type="checkbox"  name="isBuildLevel" id="isBuildLevel" value="">  </td>
                   <td>&nbsp;</td>  
				  
                </tr>			  
        	  </tbody>
            </table></td>
        	</tr>
      </table>
      </fieldset>
      
    <div id="resourceLimitList_div">  
  	<fieldset style="width:99%;">
      <legend><!-- 13���� -->61���� </legend> 
      
 		<table  id="resourceLimitList" class=ListShort width="100%" cellpadding="0" >
                  <thead>
	                  <tr class=Header> 
	                    <th>
	                      <!-- ��ʼ���� --><fmt:message key="resourceLimitForm.startTime"/></th>
	                    <th>
	                      <!-- �������� --><fmt:message key="resourceLimitForm.endTime"/></th>
	                    <th>
	                      <!-- ʱ������ --><fmt:message key="resourceLimitForm.limitTime"/></th>

	                    <th width="10%" id="button_add_new_resourceLimit"  style="cursor:hand" colspan="2" onclick="button_add_new_resourceLimit(1)">
		                      <fmt:message key="button.operation"/>
		                      <img  name="Bt_addNewRowResourceLimit" id="Bt_addNewRowResourceLimit" src="image/CRM_ADD.GIF" border="0">
	                     </th>   
	                  </tr>
						<tr > 
							<td colspan="12">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr> 
							 	<td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
							   	</tr>
							   	</table>
							</td>
						</tr>
				</thead>
			
				<tbody id="resourceLimitBody"/>

				<tbody>
					<tr height="2"><td colspan="12">
						<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
							<tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
							<tr bgcolor="#eee"> 
								<td align="right"> 
									<div id="pageInfo_resourceLimit"></div>
								</td>
							</tr>
						</table>	              
					</td></tr>
				</tbody>
        	</table>     
        	
 	 </fieldset>    
     </div> 
      
      
      
      
      
      <!--baseinso end-->
    </td>
  </tr>
</table>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr> 
    <td> 
      <!--baseinso start-->

      <div align="center"> 
        <table width="99%" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td><IMG src="image/s.gif"  width=1 height=1></td>
          </tr>
          <tr> 
          	
            <td > 
              <div align="center"> 
                <input type="button"    class="button"  id="Bt_saveCarrierInfo" value='����'>
                <input type="button"    class="button" id="Bt_removeCarrierInfo" value='ɾ��'>
              </div>
              </td>
          </tr>
          <tr> 
            <td ><IMG src="image/s.gif"  width=1 height=5></td>
          </tr>
        </table>
      </div>

      <!--baseinso end-->
    </td>
  </tr>
</table>


</fieldset>


<div  style="display:none;">
 <!-- ��Դ��� -->resourceId:<input type="text" name="resourceId" id="resourceId"/>
 <!-- ������ -->carrierId:<input type="text" name="carrierId" id="carrierId"/>
 <!-- ���ױ�� -->parentId:<input type="text" name="parentId" id="parentId"/> 
 <!-- ��������� -->carrierTypeId:<input type="text" name="carrierTypeId" id="carrierTypeId"/> 
 <!-- �汾 -->version:<input type="text" name="version" id="version"/>    
 <!-- ���弶�� -->nodeLevel:<input type="text" name="nodeLevel" id="nodeLevel"/>  
 <!-- �۸��� -->pricesId:<input type="text" name="pricesId" id="pricesId"/>         
         
<div>
<!-- ������Ϣ  end-->
</html:form>





      
     </td>
  </tr>
  <tr> 
    <td width="15%" ><IMG src="image/s.gif"  width=1 height=5></td>
  </tr>
  <tr> 
    <td colspan="2"></td>
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
	<input type="hidden" name="model" id="model" value="">
	<input type="hidden" name="carrierIdForm" id="carrierIdForm" value="">
	<!--input type="hidden" name="resourceIdForm" id="resourceIdForm" value="">
	<input type="hidden" name="" id="resourceIdForm" value="">
	<input type="hidden" name="carrierNameForm" id="carrierNameForm" value="">
	<input type="hidden" name="startDate" id="startDate" value="">
	<input type="hidden" name="endDate" id="endDate" value=""-->
</form>
<input type="hidden" id="compareMemo" name="compareMemo">
<script type="text/javascript">
    //highlightTableRows("resourceList");
</script>
