<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title><fmt:message key="matterDetail.title"/></title>
<content tag="heading"><fmt:message key="matterDetail.heading"/></content>




<script type="text/javascript" src="<c:url value='/scripts/class/matter.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/brand.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/BrandManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/industry.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/IndustryManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/ComboBoxTree.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/adver/matterFormService.js'/>"></script>





<html:form action="saveMatter" method="post" styleId="matterForm" onsubmit="return validateMatterForm(this)">

<html:hidden property="id" styleId="id"/>
<html:hidden property="version"/>
<html:hidden property="brandId" styleId="brandId"/>
<html:hidden property="brandId2" styleId="brandId2"/>
<html:hidden property="orgId" styleId="orgId"/>
<html:hidden property="customerId" styleId="customerId"/>

<ul>


<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                   
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
        		
	        </td>
 			<td width="1%" id="orgId_td"> <select id="org_Id"></select></td>
		</tr> 

  		<tr> 
		    <td nowrap="nowrap" class="requiredInput">
        		<adrm_order:label styleClass="" key="matterForm.customerId"/>:       	
	        </td>
	        
	        <td>
	         <select id="customerCmd" name="customerCmd">
	         </td>
	         
	        <!-- td>
		        <div style="position:relative;">
				<span style="margin-left:100px;width:18px;overflow:hidden;">
				  	  <adrm_order:selectList name="customers" key="8" toScope="page"/> 
                      <html:select property="customerId" styleId="customerId" style="width:145px;margin-left:-100px"> 
                      	<html:option value=""/> 
                      	<html:options collection="customers" property="value" labelProperty="label"/> 
				      </html:select> 								
				</span>
				<html:errors property="customerId"/>
				</div>  	
			</td -->
		</tr> 
		
		
		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">Æ·ÅÆ: </td>
	        <td><div id="extBrandIdDiv"></td>
		</tr>		
		

	    <tr> 
		    <td nowrap="nowrap" class="requiredInput">
		    	<fmt:message key="matterForm.name"/>:       	
	        </td>
	        <td>
		        <html:errors property="name"/>
		        <html:text property="name" styleId="name"/>
			</td>
		</tr>
    
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="matterForm.edit"/>:       	
	        </td>
	        <td>
		        <html:errors property="edit"/>
		        <html:text property="edit" styleId="edit"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="matterForm.length"/>:       	
	        </td>
	        <td>
		        <html:errors property="length"/>
		        <html:text property="length" styleId="length"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="matterForm.memo"/>:       	
	        </td>
	        <td>
		        <html:errors property="memo"/>
		        <html:text property="memo" styleId="memo"/>
			</td>
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="matterForm.tapeCode"/>:       	
	        </td>
	        <td>
		        <html:errors property="tapeCode"/>
		        <html:text property="tapeCode" styleId="tapeCode"/>
			</td>
		</tr>
		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="customerForm.industryTypeId"/>:       	
	        </td>
	        
	        <td><div id="initIndustryComboBoxTree"></td>
          
		</tr>
		
	
		
		
		
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="matterForm.matterType"/>:       	
	        </td>
         	<td> 
	            
           
         	  <div style="position:relative;">			
					<span style="margin-left:100px;width:18px;overflow:hidden;">
					  	<adrm_order:selectList name="matterTypes" key="41"  toScope="page"/> 
					     <html:select property="matterType" styleId="matterType"  style="width:145px;margin-left:-100px"> 
					     <html:option value=""/> <html:options collection="matterTypes"  property="value" labelProperty="label"/> 
					     </html:select> 								
					</span>
				</div>
            </td>
           
           
		</tr>
	    <tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="matterForm.enable"/>:       	
	        </td>
	        <td>
		        <html:errors property="enable"/>
		        <html:checkbox property="enable"  styleId="enable"/>
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
			
			<adrm_order:authorizeTag res="tag_matter_button1">
			
		        <html:submit styleClass="" property="method.save" onclick="bCancel=false; return checkTapeCode()" styleId="save1">
		            <fmt:message key="button.save"/>
		        </html:submit>
		
		        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('Matter')" styleId="delete">
		            <fmt:message key="button.delete"/>
		        </html:submit>
		
		        <html:button styleClass="" property="method.save" styleId="save2">
		            <fmt:message key="button.save"/>
		        </html:button>
		      </adrm_order:authorizeTag>
		      
		        <html:cancel styleClass="" onclick="bCancel=true">
		            <fmt:message key="button.cancel"/>
		        </html:cancel>
		        
		     <adrm_order:authorizeTag res="tag_matter_button2">
		        <html:button styleClass="" property="method.save" styleId="save">
		            <fmt:message key="button.forcesave"/>
		        </html:button>
		    </adrm_order:authorizeTag> 
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
    Form.focusFirstElement($("matterForm"));
</script>

<html:javascript formName="matterForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>

<script type="text/javascript">
 
</script>
