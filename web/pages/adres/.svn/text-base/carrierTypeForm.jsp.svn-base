<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="carrierTypeDetail.title"/></title>
<content tag="heading"><fmt:message key="carrierTypeDetail.heading"/></content>

<html:form action="saveCarrierType" method="post" styleId="carrierTypeForm" onsubmit="return validateCarrierTypeForm(this)">

<html:hidden property="id"/>
<html:hidden property="version"/>

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
		    	<fmt:message key="carrierTypeForm.name"/>:	
		        <html:errors property="name"/>   	       	
	        </td>
	        <td>
		        <html:text property="name" styleId="name"/>
			</td>
		</tr>
		
		<tr style="display:none;"> 
		    <td nowrap="nowrap" class="dataLabel">
		    	<adrm_order:label key="carrierTypeForm.displayNo"/>:
		        <html:errors property="displayNo"/>	    	       	
	        </td>
	        <td>
		        <html:text property="displayNo" styleId="displayNo" value="0"/>
			</td>
		</tr>
		
		
			<tr style="display:none;"> 
		    <td nowrap="nowrap" class="dataLabel">
		    	<adrm_order:label key="carrierTypeForm.parentId"/>:
		        <html:errors property="parentId"/>	    	       	
	        </td>
	        <td>
		        <html:text property="parentId" styleId="parentId" value="0"/>
			</td>
		</tr>	
		

		
		
		<tr style="display:none;"> 
		    <td nowrap="nowrap" class="dataLabel">
		    	<adrm_order:label key="carrierTypeForm.enable"/>:	
		        <html:errors property="enable"/>    	       	
	        </td>
	        <td>
		        <html:text property="enable" styleId="enable" value="1"/>
			</td>
		</tr>
		<tr> 
		    <td nowrap="nowrap" class="dataLabel">
		    	<adrm_order:label key="carrierTypeForm.memo"/>:	  
		        <html:errors property="memo"/>  	       	
	        </td>
	        <td>
		        <html:text property="memo" styleId="memo"/>
			</td>
		</tr>
		
		
			<tr> 
		    <td nowrap="nowrap" class="dataLabel">
		    	<adrm_order:label key="carrierTypeForm.orgId"/>:	  
		        <html:errors property="orgId"/>  	       	
	        </td>
	        <td>
		        <!-- html:text property="orgId" styleId="orgId"/ -->
		        
				        
				<span style="margin-left:100px;width:18px;overflow:hidden;">
				  	<adrm_order:selectList name="orgs" key="34"  toScope="page"/> 
				     <html:select property="orgId" styleId="orgId"  style="width:160px;margin-left:-100px"> 
				    <html:options collection="orgs"  property="value" labelProperty="label"/> 
				     </html:select> 								
				</span>
		
		
			</td>
		</tr>
		
		
		

		
			
		
		<!-- tr> 
		    <td nowrap="nowrap" class="dataLabel">
		    	<adrm_order:label key="carrierTypeForm.nodePath"/>:	 
		        <html:errors property="nodePath"/>   	       	
	        </td>
	        <td>
		        <html:text property="nodePath" styleId="nodePath"/>
			</td>
		</tr -->
	</tbody>
 </table>
 </td></tr>
 </table>

&nbsp;&nbsp;


<table width="26%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		  	<td align="center">
		  		<div align="center">
			        <html:submit styleClass="" property="method.save" onclick="bCancel=false">
			            <fmt:message key="button.save"/>
			        </html:submit>
			        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('CarrierType')">
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
    Form.focusFirstElement($("carrierTypeForm"));
</script>

<html:javascript formName="carrierTypeForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
