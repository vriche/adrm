<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="resourceList.title"/></title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXMenu/theme.css'/>" />


<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxMenu/dhtmlXProtobar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxMenu/dhtmlXMenuBar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxMenu/dhtmlXMenuBar_cp.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxMenu/dhtmlXCommon.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/adresTree.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/WorkspanManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/PriceManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/PriceDetailManager.js'/>"></script>


<content tag="heading"><fmt:message key="resourceList.heading"/></content>
<meta name="menu" content="ResourceMenu"/>


<!-- input name="date1" id="date1" value="" size="25" type="text" onclick="button_showdate('date1','anchor1')" -->
<!--  span id="anchor1" name="anchor1"></span -->


<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td width="15%" valign="top"><table width="100%" border="1" cellspacing="0" cellpadding="0">
        <tr> 
          <td> <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr> 
                <td> 
                  <!--baseinso start-->
                  <div align="center"> 
                    <table width="96%" border="0" cellspacing="0" cellpadding="0">
                      <tr> 
                        <td ><input name="radiobutton" type="radio" onClick="window.location.href='positionList.htm'" value="radiobutton" checked disabled>
                          <!-- 基本位置 --> 
						  <fmt:message key="resourceForm.title.basePos"/>
						  </td>
                        <td><input name="radiobutton" type="radio" value="radiobutton" onClick="window.location.href='packageList.htm'" disabled>
                          <!-- 套播组合 -->
						  <fmt:message key="resourceForm.title.compos"/>
						  </td>
                        <td><input name="radiobutton" type="radio" value="radiobutton" onClick="window.location.href='priceList.htm'" disabled>
                          <!-- 价格 -->
						   <fmt:message key="resourceForm.title.price"/>
						   </td>
                        <td >&nbsp;</td>
                      </tr>
                    </table>
                  </div>
                  <!--baseinso end-->
                </td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td align="center" >
          	<table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr> 
               <td width="1%"></td>
                <td width="15%" align="left">
                
						<table width="98%" border="0" id="tbBomOpt" >
						  <tr>
						    <td width="100%"><a id="Bt_addCarrierChild"><fmt:message key="resourceForm.title.addCarrier"/></a></td>
						    <td width="100%"><a id="Bt_addResourceChild"><fmt:message key="resourceForm.title.addResource"/></a></td>
						  </tr>
						</table>

                  </td>
              </tr>
              <tr>
              	<td width="1%"></td>
              	<td width="15%" align="left">
              				<div id="treebox" 
							 style="width:96%; 
							 height:500px;
							 background-color:#f5f5f5;
							 border :1px solid Silver;"/>
							<iframe name="actionframe" id="actionframe" frameborder="0" width="100%" height="0"></iframe>
				 </td>		
              </tr>
            </table>
           </td>
        </tr>

      </table>
      </td>
    <td width="50%" valign="top">
    
    
<!--main start-->

<fieldset name="resourceBody" id="resourceBody" style="display:none;">


<html:form action="resources" target="actionframe2" method="post" styleId="resourceForm" onsubmit="return validateResourceForm(this)">


      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td> 
            <!--baseinso start-->
            <fieldset>
            <legend> 
            <!-- 基本信息 -->
            <fmt:message key="resourceForm.title.baseInfo"/> </legend>
            <table width="100%">
              <tr> 
                <td width="20%">
	                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
	                      <tr> 
	                        <td nowrap="nowrap" class="requiredInput"> 
	                          <!-- 位置 -->
	                          <fmt:message key="resourceForm.resourceName"/>: </td>
	                        <td ><input name="resourceName" type="text"  id="resourceName"></td>
	                      </tr>
	                      <tr> 
	                        <td height="26" nowrap="nowrap" class="dataLabel"> 
	                          <!-- 备注 -->
	                          <fmt:message key="resourceForm.memo"/>: </td>
	                        <td ><input name="memo" type="text"  id="memo"></td>
	                      </tr>
	                  </table>
                  </td>
                <td width="20%">
	                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
	                      <tr> 
	                        <td nowrap="nowrap" class="dataLabel"> 
	                          <!-- 分类 -->
	                          <fmt:message key="resourceForm.resourceType"/>: </td>
	                        <td >
	                        
			                	<adrm_order:selectList name="resourceTypes" key="16" toScope="page"/>
							                <html:select property="resourceType" styleId="resourceType">
							                    <html:option value=""/>            
							                    <html:options collection="resourceTypes" property="value" labelProperty="label"/>
							                </html:select>
							     <html:errors property="resourceType"/>	
	                          
	                          </td>
	                      </tr>
	                      <tr> 
	                        <td height="22" nowrap="nowrap" class="dataLabel"> 
	                          <!-- 启用 -->
	                          <fmt:message key="resourceForm.isValidate"/>: </td>
	                        <td ><input type="checkbox" name="isValidate" id="isValidate" value="checkbox"></td>
	                      </tr>
	                  </table>
                  </td>
                <td>
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                      <tr> 
                        <td nowrap="nowrap" class="dataLabel"> 
                          <!-- 超时封签 -->
                          </td>
                        <td ><fmt:message key="resourceForm.isClosed"/>:<input type="checkbox" name="isClosed" id="isClosed"  value="checkbox"></td>
                      </tr>
                      <tr> 
                        <td nowrap="nowrap" class="dataLabel"> 
                          <!-- 出串联单 -->
                          </td>
                        <td><fmt:message key="resourceForm.isSeralized"/>:<input type="checkbox" name="isSeralized" id="isSeralized" value="checkbox"></td>
                      </tr>
                  </table>
                  
                  </td>
                <td>
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                      <tr> 
                        <td width="30%"  nowrap="nowrap" class="dataLabel"> 
                          <!-- 指定加收 -->
                          <fmt:message key="resourceForm.isOverweight"/>: 
                          <input type="checkbox" name="isOverweight" id="isOverweight" value="checkbox"> 
                        </td>
                      </tr>
                      <tr> 
                        <td width="30%" nowrap="nowrap" class="dataLabel"> 
                          <!-- 手动价格 -->
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
      <fieldset>
      <legend>
      <!-- 有效信息 -->
      <fmt:message key="resourceForm.title.workSpan"/> </legend>
      <div align="center"> 
        <table width="99%" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td class=blackLine>
            	<IMG src="image/s.gif"  width=1 height=1>
            </td>
          </tr>
          <tr> 
    
            <td ><table  id="mytb" class=ListShort width="100%" cellpadding="0" >
                  <thead>
                  <tr class=Header> 
                    <th>
                      <!-- 开始日期 --><fmt:message key="workspanForm.beginDate"/></th>
                    <th>
                      <!-- 结束日期 --><fmt:message key="workspanForm.endDate"/></th>
                    <th>
                      <!-- 播出时间 --><fmt:message key="workspanForm.broadcastStartTime"/></th>
                    <th>
                      <!-- 星期一 --><fmt:message key="workspanForm.monLength"/></th>
                    <th>
                      <!-- 星期二 --><fmt:message key="workspanForm.tueLength"/></th>
                    <th>
                      <!-- 星期三 --><fmt:message key="workspanForm.wenLength"/></th>
                    <th>
                      <!-- 星期四 --><fmt:message key="workspanForm.thiLength"/></th>
                    <th>
                      <!-- 星期五 --><fmt:message key="workspanForm.friLength"/></th>
                    <th>
                      <!-- 星期六 --><fmt:message key="workspanForm.satLength"/></th>
                    <th>
                      <!-- 星期日 --><fmt:message key="workspanForm.sunLength"/></th>
                    <th width="10%" colspan=2>
                      <fmt:message key="button.operation"/>
                      <img  name="Bt_addNewRowWorkspance" id="Bt_addNewRowWorkspance" src="image/CRM_ADD.GIF" >
                     </th>
                  </tr>
                  <tr> 
                    <td class=blackLine colspan="12"><IMG src="image/s.gif"  width=1 height=1></td>
                  </tr>
                  </thead>
                 	<tbody id="workSpanceBody"></tbody>
              </table>
              
              </td>
          </tr>
          <tr> 
            <td ><IMG src="image/s.gif"  width=1 height=5></td>
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
      <fieldset>
      <legend> 
      <!-- 价格信息 -->
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
                      <!-- 默认 -->
                      <fmt:message key="priceForm.isDefault"/>
                    </th>
                    <th>
                      <!-- 价格名 -->
                      <fmt:message key="priceForm.name"/>
                    </th>
                    <th>
                      <!-- 价格类别 -->
                      <fmt:message key="priceForm.resourcePriceType"/>
                    </th>
                    <th>
                      <!-- 价格规则 -->
                      <fmt:message key="priceForm.isUseRegular"/>
                    </th>
                    <th>
                      <!-- 价格明细 -->
                      <fmt:message key="priceForm.priceDetails"/>
                    </th>
                    <th width="10%" colspan=2>
                      <fmt:message key="button.operation"/>
                      <img  name="Bt_addNewPrice" id="Bt_addNewPrice" src="image/CRM_ADD.GIF" >
                     </th>
                  </tr>
                  <tr > 
                    <td class=blackLine colspan="7">
                       <IMG src="image/s.gif"  width=1 height=1>
                    </td>
                  </tr>
                   </thead>
                   
                   <tbody id="priceDetailBody"></tbody>

              </table>
            </td>
          </tr>
          <tr> 
            <td ><IMG src="image/s.gif"  width=1 height=5></td>
          </tr>
        </table>
        
        <table width="100%">
			  <tr>
			    <td><div align="center">
			        <input type="button" name="Bt_saveResource"  id="Bt_saveResource" value="<fmt:message key="button.save"/>">
			        <input type="button" name="Bt_removeResource" id="Bt_removeResource" value="<fmt:message key="button.delete"/>">
			      </div></td>
			  </tr>
		</table>
			
      </div>
      </fieldset>
      <!--baseinso end-->
    </td>
  </tr>
</table>

 <!-- 价格类别 -->
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

<!-- 载体信息  start-->
<fieldset name="carrierBody" id="carrierBody" style="display:block;">

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr> 
    <td> 
      <!--baseinso start-->  
      <fieldset>
      <legend><!-- 载体信息 --><fmt:message key="carrierList.heading"/> </legend>
      <table width="99%" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td width="30%" valign="top"> <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
              <tbody>
                <tr> 
                  <td nowrap="nowrap" class="dataLabel">
                  <!-- 启用 --><fmt:message key="carrierForm.enable"/>: </td>
                  <td >
				       <input type="checkbox" name="enable" id="carrierEnable" value="checkbox">  
				  </td>
                </tr>
                <tr> 
                  <td nowrap="nowrap" class="requiredInput">
                  <!-- 名称 --><fmt:message key="carrierForm.carrierName"/>:</td>
                  <td >
                   <input type="text" name="carrierName" id="carrierName"/>
                  </td>
                </tr>
              </tbody>
            </table></td>
          <td width="20%" valign="top"> <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
              <tbody>
                <tr> 
                  <td nowrap="nowrap" class="dataLabel">
                  <!-- 媒体机构 --><fmt:message key="carrierForm.mediaOrgId"/>: 
                  </td>
                  <td >
				       <adrm_order:selectList name="mediaOrgs" key="14" toScope="page"/>
				                <html:select property="mediaOrgId" styleId="mediaOrgId">
				                    <html:option value=""/>				                  
				                    <html:options collection="mediaOrgs" property="value" labelProperty="label"/>
				                </html:select>
				       <html:errors property="mediaOrgId"/>	
                    
                    </td>
                </tr>
                <tr> 
                  <td nowrap="nowrap" class="dataLabel"> 
                  	<!-- 别名 --><fmt:message key="carrierForm.aliasName"/>:
                  </td>
                  <td >
                  	  <input type="text" name="aliasName" id="aliasName"/>
                  </td>
                </tr>
              </tbody>
            </table></td>
          <td valign="top">
          
          <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">

                <tr> 
                  <td nowrap="nowrap" class="dataLabel">
                  <!-- 频道 --><fmt:message key="carrierForm.channelId"/>:</td>
                  <td nowrap="nowrap" class="dataLabel"> 

                  	<adrm_order:selectList name="channels" key="15" toScope="page"/>
				                <html:select property="channelId" styleId="channelId">
				                    <html:option value=""/>            
				                    <html:options collection="channels" property="value" labelProperty="label"/>
				                </html:select>
				     <html:errors property="channelId"/>	
                    </td>
                  <td class="dataLabel">&nbsp; </td>
                </tr>
                <tr> 
                  <td nowrap="nowrap" class="dataLabel">
                  <!-- 启用 --> 
                  </td>
                       
                  </td>
                  <td>&nbsp; </td>
                </tr>

            </table></td>
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
      <fieldset>
      <legend></legend>
      <div align="center"> 
        <table width="99%" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td><IMG src="image/s.gif"  width=1 height=1></td>
          </tr>
          <tr> 
            <td > 
              <div align="center"> 
                <input type="button" name="Bt_saveCarrierInfo" id="Bt_saveCarrierInfo" value="<fmt:message key="button.save"/>">
                <input type="button" name="Bt_removeCarrierInfo" id="Bt_removeCarrierInfo" value="<fmt:message key="button.delete"/>">
              </div>
              </td>
          </tr>
          <tr> 
            <td ><IMG src="image/s.gif"  width=1 height=5></td>
          </tr>
        </table>
      </div>
      </fieldset>
      <!--baseinso end-->
    </td>
  </tr>
</table>


</fieldset>


<div  style="display:none;">
 <!-- 资源编号 -->resourceId:<input type="text" name="resourceId" id="resourceId"/>
 <!-- 载体编号 -->carrierId:<input type="text" name="carrierId" id="carrierId"/>
 <!-- 父亲编号 -->parentId:<input type="text" name="parentId" id="parentId"/> 
 <!-- 载体类别编号 -->carrierTypeId：<input type="text" name="carrierTypeId" id="carrierTypeId"/> 
 <!-- 版本 -->version:<input type="text" name="version" id="version"/>    
 <!-- 价格编号 -->pricesId:<input type="text" name="pricesId" id="pricesId"/>         
         
<div>
<!-- 载体信息  end-->
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



<script type="text/javascript">
    //highlightTableRows("resourceList");
</script>
