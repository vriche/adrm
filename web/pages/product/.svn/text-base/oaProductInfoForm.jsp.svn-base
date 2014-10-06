<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaProductInfoDetail.title"/></title>
<content tag="heading"><fmt:message key="oaProductInfoDetail.heading"/></content>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" href="sample.css" type="text/css"/>

<html:form action="saveOaProductInfo" method="post" styleId="oaProductInfoForm" onsubmit="return validateOaProductInfoForm(this)">

<html:hidden property="version"/>
<html:hidden property="id"/>

<ul>


<script>

  callOnLoad(init);	
  function init(){
	   getDate();
	   getDate2();
	} 
	
function getDate(){
	Calendar.setup({
		inputField  : "stockDate",	  // id of the input field
		ifFormat	: "%Y%m%d",	  // the date format
		button	  : "stockDate"	// id of the button
	});
	//$("stockDate").value=curDate;
}
function getDate2(){
	Calendar.setup({
		inputField  : "storageDate",	  // id of the input field
		ifFormat	: "%Y%m%d",	  // the date format
		button	  : "storageDate"	// id of the button
	});
	
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
		    	<fmt:message key="oaProductInfoForm.fittings"/>:       	
	        </td>
	        <td>
		        <html:errors property="fittings"/>
		        <html:text property="fittings" styleId="fittings"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaProductInfoForm.memo"/>:       	
	        </td>
	        <td>
		        <html:errors property="memo"/>
		        <html:text property="memo" styleId="memo"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaProductInfoForm.picture"/>:       	
	        </td>
	        <td>
		        <html:errors property="picture"/>
		        <html:text property="picture" styleId="picture"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaProductInfoForm.price"/>:       	
	        </td>
	        <td>
		        <html:errors property="price"/>
		        <html:text property="price" styleId="price"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaProductInfoForm.productTypeId"/>:       	
	        </td>
	        <td>
		        <html:errors property="productTypeId"/>
		        <html:text property="productTypeId" styleId="productTypeId"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaProductInfoForm.provider"/>:       	
	        </td>
	        <td>
		        <html:errors property="provider"/>
		        <html:text property="provider" styleId="provider"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaProductInfoForm.quantity"/>:       	
	        </td>
	        <td>
		        <html:errors property="quantity"/>
		        <html:text property="quantity" styleId="quantity"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaProductInfoForm.stockDate"/>:       	
	        </td>
	        <td>		       	
	        	<html:text property="stockDate" styleId="stockDate"  readonly="true"/> 
				
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaProductInfoForm.stockUser"/>:       	
	        </td>
	        <td>
				<div style="position:relative;">
					<span style="margin-left:100px;width:18px;overflow:hidden;">
					  	<adrm_order:selectList name="users" key="2"  toScope="page"/> 
					     <html:select property="stockUser" styleId="userId"  style="width:140px;margin-left:-100px"> 
					     <html:option value=""/> <html:options collection="users"  property="value" labelProperty="label"/> 
					     </html:select> 								
					</span>
				</div>  
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaProductInfoForm.storageDate"/>:       	
	        </td>
	        <td>		       	
	        	<html:text property="storageDate" styleId="storageDate"  readonly="true"/> 
			
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="oaProductInfoForm.unit"/>:       	
	        </td>
	        <td>
		        <html:errors property="unit"/>
		        <html:text property="unit" styleId="unit"/>
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
		
		        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('OaProductInfo')">
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
    Form.focusFirstElement($("oaProductInfoForm"));
</script>

<html:javascript formName="oaProductInfoForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
