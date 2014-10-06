<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaAssetsDetail.title"/></title>
<content tag="heading"><fmt:message key="oaAssetsDetail.heading"/></content>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" href="sample.css" type="text/css"/>


<html:form action="saveOaAssets" method="post" styleId="oaAssetsForm" onsubmit="return validateOaAssetsForm(this)">
<ul>
<html:hidden property="id"/>
<html:hidden property="version"/>

<script>

  callOnLoad(init);	
  function init(){
	   getDate();
	} 
	
function getDate(){
	Calendar.setup({
		inputField  : "purchaseDate",	  // id of the input field
		ifFormat	: "%Y%m%d",	  // the date format
		button	  : "purchaseDate"	// id of the button
	});
	//$("purchaseDate").value=curDate;
}
	
</script>



<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                    <td><span class="tile1">
                    </span>
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
   <td width="50%">	    

	<table width="20%" border="0" cellspacing="0" cellpadding="0">
	<tbody>
	
	    <tr> 
		    <td nowrap="nowrap" class="requiredInput">
		    	<fmt:message key="oaAssetsForm.assetsName"/>:       	
	        </td>
	        <td>
		        <html:errors property="assetsName"/>
		        <html:text property="assetsName" styleId="assetsName"/>
			</td>
		</tr>
	    <tr> 
		    <td nowrap="nowrap" class="requiredInput">
		    	<fmt:message key="oaAssetsForm.assetsCode"/>:       	
	        </td>
	        <td>
		        <html:errors property="assetsCode"/>
		        <html:text property="assetsCode" styleId="assetsCode"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaAssetsForm.purchaseDate"/>:       	
	        </td>
	        <td>		       	
	        	<html:text property="purchaseDate" styleId="purchaseDate"  readonly="true" />
	        	<!--onclick="button_showdate('purchaseDate','anchorCsignDate')"/> 
				<span id="anchorCsignDate" name="anchorCsignDate"></span-->
			</td>
		</tr>
  		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
				<!--资产状态--!>
				<adrm_order:label styleClass="" key="oaAssetsForm.assetsStateId"/>:
	        </td>
	        <td>
	        	<div style="position:relative;">
					<span style="margin-left:100px;width:18px;overflow:hidden;">
					  	<adrm_order:selectList name="assetsStates" key="25"  toScope="page"/> 
					     <html:select property="assetsStateId" styleId="assetsStateId"  style="width:140px;margin-left:-100px"> 
					     <html:option value=""/> <html:options collection="assetsStates"  property="value" labelProperty="label"/> 
					     </html:select> 								
					</span>
					<html:errors property="assetsStateId"/>
				</div>  
			</td>
		</tr> 

  		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
				<!--资产类别--!>
				<adrm_order:label styleClass="" key="oaAssetsForm.assetsTypeId"/>:
	        </td>
	        <td>
	        	<div style="position:relative;">
					<span style="margin-left:100px;width:18px;overflow:hidden;">
					  	<adrm_order:selectList name="assetsTypes" key="24"  toScope="page"/> 
					     <html:select property="assetsTypeId" styleId="assetsTypeId"  style="width:140px;margin-left:-100px"> 
					     <html:option value=""/> <html:options collection="assetsTypes"  property="value" labelProperty="label"/> 
					     </html:select> 								
					</span>
					<html:errors property="assetsTypeId"/>
				</div>    
			</td>
		</tr> 

		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaAssetsForm.depreciation"/>:       	
	        </td>
	        <td>
		        <html:errors property="depreciation"/>
		        <html:text property="depreciation" styleId="depreciation"/>
			</td>
		</tr>
  		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaAssetsForm.memo"/>:       	
	        </td>
	        <td>
		        <html:errors property="memo"/>
		        <html:text property="memo" styleId="memo"/>
			</td>
		</tr>
		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaAssetsForm.oldValue"/>:       	
	        </td>
	        <td>
		        <html:errors property="oldValue"/>
		        <html:text property="oldValue" styleId="oldValue"/>
			</td>
		</tr>
		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaAssetsForm.provider"/>:       	
	        </td>
	        <td>
		        <html:errors property="provider"/>
		        <html:text property="provider" styleId="provider"/>
			</td>
		</tr>
		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaAssetsForm.purchaseMoney"/>:       	
	        </td>
	        <td>
		        <html:errors property="purchaseMoney"/>
		        <html:text property="purchaseMoney" styleId="purchaseMoney"/>
			</td>
		</tr>
		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaAssetsForm.standard"/>:       	
	        </td>
	        <td>
		        <html:errors property="standard"/>
		        <html:text property="standard" styleId="standard"/>
			</td>
		</tr>
		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaAssetsForm.storage"/>:       	
	        </td>
	        <td>
		        <html:errors property="storage"/>
		        <html:text property="storage" styleId="storage"/>
			</td>
		</tr>
		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaAssetsForm.surplusValue"/>:       	
	        </td>
	        <td>
		        <html:errors property="surplusValue"/>
		        <html:text property="surplusValue" styleId="surplusValue"/>
			</td>
		</tr>
		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaAssetsForm.useYearFixed"/>:       	
	        </td>
	        <td>
		        <html:errors property="useYearFixed"/>
		        <html:text property="useYearFixed" styleId="useYearFixed"/>
			</td>
		</tr>
		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaAssetsForm.voucher"/>:       	
	        </td>
	        <td>
		        <html:errors property="voucher"/>
		        <html:text property="voucher" styleId="voucher"/>
			</td>
		</tr>
	</tbody>
 </table>
 </td></tr>
 </table>

&nbsp;&nbsp;

<table width="26%" border="0" cellspacing="0" cellpadding="0">
	 <tr>
		<td>
			<div align="center">
		        <html:submit styleClass="" property="method.save" onclick="bCancel=false">
		            <fmt:message key="button.save"/>
		        </html:submit>
		
		        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('OaAssets')">
		            <fmt:message key="button.delete"/>
		        </html:submit>
		
		        <html:cancel styleClass="" onclick="bCancel=true">
		            <fmt:message key="button.cancel"/>
		        </html:cancel>
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


</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("oaAssetsForm"));
</script>

<html:javascript formName="oaAssetsForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
