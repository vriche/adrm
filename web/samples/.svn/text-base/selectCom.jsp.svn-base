<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="contractDetail.title"/></title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/ajaxupload.css'/>" />
<script type="text/javascript" src="<c:url value='/scripts/admin/ajaxuploadService.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UploadMonitor.js'/>"></script>

<content tag="heading"><fmt:message key="contractDetail.heading"/></content>

<html:form action="saveContract" method="post" styleId="contractForm" onsubmit="return validateContractForm(this)">
<html:hidden property="id"/>

 

<fieldset  style="width: 98%">
<legend><!-- selectBox -->selectBox</legend>

    
    
    
      
    <!--订单类别--!>          
    <div style="position:relative;">
    categoryMains
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="categoryMains" key="0"  toScope="page" prompt="==select=="/> 
		     <html:select property="customerId" styleId="categoryMainId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="categoryMains"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>   
	
      <!--订单子类别--!>          
    <div style="position:relative;">
    categoryMains
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="categorySubs" key="1" level="0" toScope="page"/> 
		     <html:select property="customerId" styleId="categorySubId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="categorySubs"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>   
	
	                        
	<!--业务员--!>
	<div style="position:relative;">
	users
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="users" key="2"  toScope="page"/> 
		     <html:select property="customerId" styleId="userId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="users"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    
	
	<!--载体--!>	
	<div style="position:relative;">
	carriers
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="carriers" key="3"  level="0" toScope="page"/> 
		     <html:select property="customerId" styleId="carrierId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="carriers"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    
	

	<!--广告位置--!>		
	<div style="position:relative;">
	positions
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="positions" key="4"  level="" toScope="page"/> 
		     <html:select property="customerId" styleId="resourceId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="positions"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    
	

	<!--指定位置--!>		
	<div style="position:relative;">
	species
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="species" key="5"  toScope="page"/> 
		     <html:select property="customerId" styleId="specieId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="species"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    
	
	<!--行业--!>	
	<div style="position:relative;">
	industrys
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="industrys" key="6"  toScope="page"/> 
		     <html:select property="customerId" styleId="industryId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="industrys"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    
	
	<!--价格类别--!>		
	<div style="position:relative;">
	priceTypes
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="priceTypes" key="7"  toScope="page"/> 
		     <html:select property="customerId" styleId="priceTypesId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="priceTypes"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>   
	 
	<!--客户名称--!>		
	<div style="position:relative;">
	customers
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="customers" key="8"  toScope="page"/> 
		     <html:select property="customerId" styleId="customerId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="customers"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    
	
	<!--客户类别--!>		
	<div style="position:relative;">
	customerTypes
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="customerTypes" key="9"  toScope="page"/> 
		     <html:select property="customerId" styleId="customerTypeId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="customerTypes"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    
	
	

	<!--月份--!>		
	<div style="position:relative;">
	months
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="months" key="10"  toScope="page"/> 
		     <html:select property="customerId" styleId="monthId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="months"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    
	
	<!--日 31天--!>		
	<div style="position:relative;">
	days
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="days" key="11"  toScope="page"/> 
		     <html:select property="customerId" styleId="dayId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="days"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    
	
	
	<!--客户分类--!>		
	<div style="position:relative;">
	customerCategorys
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="customerCategorys" key="12" level="0" toScope="page"/> 
		     <html:select property="customerId" styleId="customerCategoryId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="customerCategorys"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    
	
	<!--载体类别--!>		
	<div style="position:relative;">
	carrierTypes
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="carrierTypes" key="13"  level="0" toScope="page"/> 
		     <html:select property="customerId" styleId="carrierTypeId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="carrierTypes"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    
	
	<!--媒体机构--!>		
	<div style="position:relative;">
	mediaOrgs
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="mediaOrgs" key="14"  toScope="page"/> 
		     <html:select property="customerId" styleId="mediaOrgId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="mediaOrgs"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    	
	
	<!--频道 一套 二套--!>		
	<div style="position:relative;">
	resourceChannels
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="resourceChannels" key="15"  toScope="page"/> 
		     <html:select property="customerId" styleId="resourceChannelId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="resourceChannels"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    
	
	<!--资源类别 如黄金--!>		
	<div style="position:relative;">
	resourceTypes
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="resourceTypes" key="16"  toScope="page"/> 
		     <html:select property="customerId" styleId="resourceTypeId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="resourceTypes"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    
	
	<!--到款方式--!>		
	<div style="position:relative;">
	incomeModes
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="incomeModes" key="17"  toScope="page"/> 
		     <html:select property="customerId" styleId="incomeModeId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="incomeModes"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    
	
	<!--到款用途--!>		
	<div style="position:relative;">
	incomePurposes
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="incomePurposes" key="18"  toScope="page"/> 
		     <html:select property="customerId" styleId="incomePurposeId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="incomePurposes"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    
	
	<!--年--!>		
	<div style="position:relative;">
	years
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="years" key="19"  toScope="page"/> 
		     <html:select property="customerId" styleId="yearId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="years"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    	
	
	<!--信息类别--!>		
	<div style="position:relative;">
	infoTypes
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="infoTypes" key="20"  toScope="page"/> 
		     <html:select property="customerId" styleId="infoTypeId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="infoTypes"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    
	
	<!--工作流类别--!>		
	<div style="position:relative;">
	workFlowTypes
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="workFlowTypes" key="21"  toScope="page"/> 
		     <html:select property="customerId" styleId="workFlowTypeId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="workFlowTypes"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    	
	
	<!--审批结果状态--!>		
	<div style="position:relative;">
	workFlowCheckResults
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="workFlowCheckResults" key="22"  toScope="page"/> 
		     <html:select property="customerId" styleId="workFlowCheckResultId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="workFlowCheckResults"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    		
	
	<!--用品类别--!>		
	<div style="position:relative;">
	customers
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="productTypes" key="23"  toScope="page"/> 
		     <html:select property="customerId" styleId="customerId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="customers"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    
	
	<!--资产类别--!>		
	<div style="position:relative;">
	assetsTypes
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="assetsTypes" key="24"  toScope="page"/> 
		     <html:select property="customerId" styleId="assetsTypeId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="assetsTypes"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    	
	
	<!--资产状态--!>		
	<div style="position:relative;">
	assetsStates
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="assetsStates" key="25"  toScope="page"/> 
		     <html:select property="customerId" styleId="assetsStateId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="assetsStates"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    					
	<!--目录权限类别--!>		
	<div style="position:relative;">
	documentCatalogPermitTypes
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="documentCatalogPermitTypes" key="26"  toScope="page"/> 
		     <html:select property="customerId" styleId="documentCatalogPermitTypeId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="documentCatalogPermitTypes"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    

	<!--国家--!>  
     <div style="position:relative;">
    countries
		<span style="margin-left:100px;width:18px;overflow:hidden;">
  		 <adrm_order:country name="countries" toScope="page"/>
                <html:select property="customerId" styleId="counctryId" style="width:140px;margin-left:-100px">
                    <html:option value=""/>
                    <html:options collection="countries" property="value" labelProperty="label"/>
    </html:select>
		</span>
	</div>    	
	
	<!--城市名称--!>	
	<div style="position:relative;">
	areaCitys
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="areaCitys" key="27"  toScope="page"/> 
		     <html:select property="customerId" styleId="areaCityId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="areaCitys"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    	
	
	<!--邮政编码--!>		
	<div style="position:relative;">
	areaPcs
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="areaPcs" key="28"  toScope="page"/> 
		     <html:select property="customerId" styleId="areaPcId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="areaPcs"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    	
	
	<!--用户类别表--!>		
	<div style="position:relative;">
	sysUserTypes
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="sysUserTypes" key="29"  toScope="page"/> 
		     <html:select property="customerId" styleId="sysUserTypeId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="sysUserTypes"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>   
	
	 		
	<!--部门表--!>		
	<div style="position:relative;">
	branchs
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="branchs" key="30"  toScope="page"/> 
		     <html:select property="customerId" styleId="branchId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="branchs"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    	
	
	<!--系统事件类型--!>		
	<div style="position:relative;">
	systemEventTypes
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="systemEventTypes" key="31"  toScope="page"/> 
		     <html:select property="customerId" styleId="sysEventTypeId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="systemEventTypes"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    		
		     
	<!--事件执行状态表--!>		
	<div style="position:relative;">
	 sysEventStates
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="sysEventStates" key="32"  toScope="page"/> 
		     <html:select property="customerId" styleId="sysEventStateId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="sysEventStates"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>    	
	<!--系统提示方式--!>		
	<div style="position:relative;">
	sysPromptModes
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="sysPromptModes" key="33"  toScope="page"/> 
		     <html:select property="customerId" styleId="sysPromptModeId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="sysPromptModes"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>  
	
	
	<!--组织--!>		
	<div style="position:relative;">
	orgs
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="orgs" key="34"  toScope="page"/> 
		     <html:select property="customerId" styleId="orgId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="orgs"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>  	
	<!--广告类别--!>	
	<div style="position:relative;">
	matterType
		<span style="margin-left:100px;width:18px;overflow:hidden;">
		  	<adrm_order:selectList name="matterTypes" key="41"  toScope="page"/> 
		     <html:select property="customerId" styleId="matterTypeId"  style="width:140px;margin-left:-100px"> 
		     <html:option value=""/> <html:options collection="matterTypes"  property="value" labelProperty="label"/> 
		     </html:select> 								
		</span>
	</div>  	
	
	
				
</html:form>










<html:form action="uploadFile" method="post" styleId="uploadForm" target="actionframe" 
    enctype="multipart/form-data" onsubmit="return validateUploadForm(this)">
<ul>
    <li class="info">
        <fmt:message key="upload.message"/>
    </li>
    <li>
        <adrm_order:label key="uploadForm.name" styleClass="desc"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>
    </li>
    <li>
        <adrm_order:label key="uploadForm.file" styleClass="desc"/>
        <html:file property="file" styleClass="file medium" styleId="file" />
        
        <div id="progressBar" style="display: none;">
					<div id="theMeter">
						<div id="progressBarBox">
							<div id="progressBarBoxContent"></div>
						</div>
					</div>
		</div>
		
				
    </li>
    <li class="buttonBar">
        <html:submit styleClass="button" styleId="save" onclick="bCancel=false">
            <fmt:message key="button.upload"/>
        </html:submit>
        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>



<input type="button" id="save" onClick="save_file()" value="save_file"/>

<iframe name="actionframe" id="actionframe" frameborder="0" width="100%" height="0"></iframe>

<script type="text/javascript">
    Form.focusFirstElement($('uploadForm'));
    highlightFormElements();
    
    function save_file(){
         alert(1);
       	 $('uploadForm').submit();
         startProgress('file','save');
    }
    
 
    
    
</script>















<script type="text/javascript">
    Form.focusFirstElement($("contractForm"));
</script>

<html:javascript formName="contractForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>

