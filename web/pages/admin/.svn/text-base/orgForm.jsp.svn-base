<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

  <%@   page   import="java.sql.*"   %>    
  <%@   page   import="java.util.*"%>    
  <%@   page   import="java.text.*"%>    
  <%@   page   import="java.io.*"%> 

<title><fmt:message key="orgDetail.title"/></title>
<content tag="heading"><fmt:message key="orgDetail.heading"/></content>

<html:form enctype="multipart/form-data"  action="saveOrg"  method="post"   styleId="orgForm" onsubmit="return validateOrgForm(this)">
 
 
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
					    <td width="50%" nowrap="nowrap" class="dataLabel">
					    	<fmt:message key="orgForm.name"/>:       	
				        </td>
				        <td>
					        <html:errors property="name"/>
				    		<html:text property="name" styleId="name"/>
						</td>
					</tr>	
					
					<tr> 
					    <td nowrap="nowrap" class="requiredInput">
					    	<adrm_order:label key="orgForm.bankCode"/>:	    	       	
				        </td>
				        <td>
					        <html:errors property="bankCode"/>
					        <html:text property="bankCode" styleId="bankCode"/>
						</td>
					</tr>	
				
					<tr> 
					    <td width="50%" nowrap="nowrap" class="dataLabel">
					    	<fmt:message key="orgForm.bankName"/>:       	
				        </td>
				        <td>
							<html:errors property="bankName"/>
					        <html:text property="bankName" styleId="bankName"/>
						</td>
					</tr>
				   
					<tr> 
					    <td width="50%" nowrap="nowrap" class="dataLabel">
					    	<fmt:message key="orgForm.fax"/>:       	
				        </td>
				        <td>
					        <html:errors property="fax"/>
				        	<html:text property="fax" styleId="fax"/>
						</td>
					</tr>
					
					<tr> 
					    <td width="50%" nowrap="nowrap" class="dataLabel">
					    	<fmt:message key="customerForm.ownerAgent"/>:  
					    	     	
				        </td>
				        <td>
					      	<html:errors property="linkMan"/>
				    		<html:text property="linkMan" styleId="linkMan"/>
						</td>
					</tr>
				
				
				
					<tr> 
					    <td width="50%" nowrap="nowrap" class="dataLabel">
					    	<fmt:message key="orgForm.tel"/>:       	
				        </td>
				        <td>
					        <html:errors property="tel"/>
					        <html:text property="tel" styleId="tel"/>
						</td>
					</tr>
					
					<tr> 
					    <td width="50%" nowrap="nowrap" class="dataLabel">
					    	<fmt:message key="orgForm.addressForm.address"/>:       	
				        </td>
				        <td>
					        <html:errors property="addressForm.address"/>
					        <html:text property="addressForm.address" styleId="addressForm.address"/>
						</td>
					</tr>
					
					<tr> 
						<td nowrap="nowrap" class="dataLabel">
							<!--国家--!>
							<adrm_order:label styleClass="" key="orgForm.addressForm.city"/>:       	
						</td>
						<td>
							<div style="position:relative;">
							<span style="margin-left:100px;width:18px;overflow:hidden;">
						  		 <adrm_order:country name="countries" toScope="page"/>
						                <html:select property="addressForm.city" styleId="counctryId" style="width:136px;margin-left:-100px">
						                    <html:option value=""/>
						                    <html:options collection="countries" property="value" labelProperty="label"/>
						    			</html:select>
						    </span>
						    <html:errors property="addressForm.city"/>
							</div> 
						</td>
					</tr>
				
					<tr> 
						<td width="50%" nowrap="nowrap" class="dataLabel">
							<!--城市名称--!>
							<adrm_order:label styleClass="" key="orgForm.addressForm.country"/>:       	
						</td>
						<td>	
							<div style="position:relative;">
							<span style="margin-left:100px;width:18px;overflow:hidden;">
						  	<adrm_order:selectList name="areaCitys" key="27"  toScope="page"/> 
						     <html:select property="addressForm.country" styleId="areaCityId"  style="width:136px;margin-left:-100px"> 
							     <html:option value=""/>
							     <html:options collection="areaCitys"  property="value" labelProperty="label"/> 
						     </html:select> 								
						</span>
						<html:errors property="addressForm.country"/>
						</div>
						</td>
					</tr>
					
					<tr> 

						<td width="50%" nowrap="nowrap" class="dataLabel">
							<fmt:message key="orgForm.addressForm.postalCode"/>: 
						</td> 
						<td>
							<html:errors property="addressForm.postalCode"/>
					        <html:text property="addressForm.postalCode" styleId="addressForm.address"/>
						</td>
					</tr>
					
					<tr> 
						<td width="50%" nowrap="nowrap" class="dataLabel">
							<fmt:message key="orgForm.addressForm.province"/>:       	
						</td>
						<td>
						    <html:errors property="addressForm.province"/>
						    <html:text property="addressForm.province" styleId="addressForm.province"/>
						</td>
					</tr>
					
					<tr> 
					    <td width="50%" nowrap="nowrap" class="dataLabel">
					    	<fmt:message key="orgForm.reportTitle"/>:       	
				        </td>
				        <td>
					        <html:errors property="reportTitle"/>
				    		<html:text property="reportTitle" styleId="reportTitle"/>
						</td>
					</tr>	
					
					
						<tr> 
					    <td width="50%" nowrap="nowrap" class="dataLabel">
					    	<fmt:message key="orgForm.reportSignature"/>:        	
				        </td>
				        <td>
					        <html:errors property="reportSignature"/>
				    		<html:text property="reportSignature" styleId="reportSignature"/>
						</td>
					</tr>					
						
					
					<!--tr> 
					    <td width="50%" nowrap="nowrap" class="dataLabel">
					    	<fmt:message key="orgForm.picture"/>:       	
				        </td>
				        <td>
					        <html:errors property="reportTitle"/>
				    		<html:file property="reportTitle" styleId="reportTitle"/>
						</td>
						
						
				</tr -->	
				
	 						<tr> 		
						<td width="50%" nowrap="nowrap" class="dataLabel">
					    	组织性质:   
				        </td>
				          
								<td>
									<div style="position:relative;">
										<span style="margin-left:100px;width:18px;overflow:hidden;">
										   
											  	<adrm_order:selectList name="orgTypes" key="44" level="0" toScope="page"/> 
											     <html:select property="orgType" styleId="orgType"  style="width:136px;margin-left:-100px"> 
											     <html:options collection="orgTypes"  property="value" labelProperty="label"/> 
											     </html:select> 	
					
										</span>
									</div>   
									
								</td>
								
							</tr>	   			
				
				    
 <c:if test="${pageContext.request.remoteUser == 'admin'}">   
		               
						<tr> 		
						<td width="50%" nowrap="nowrap" class="dataLabel">
					    	<fmt:message key="orgForm.admin"/>:         
				        </td>
				          
								<td>
									<div style="position:relative;">
										<span style="margin-left:100px;width:18px;overflow:hidden;">
										   
											  	<adrm_order:selectList name="users" key="2" level="0" toScope="page"/> 
											     <html:select property="createBy" styleId="createBy"  style="width:136px;margin-left:-100px"> 
											     <html:option value=""/> <html:options collection="users"  property="value" labelProperty="label"/> 
											     </html:select> 	
								
										
										       
										     							
										</span>
									</div>   
									
								</td>
								
							</tr>	
								
		              
        </c:if>               
				         


 <c:if test="${pageContext.request.remoteUser != 'admin'}">   
		               
						<tr style="display:none"> 		
						<td width="50%" nowrap="nowrap" class="dataLabel">
					    	<fmt:message key="orgForm.admin"/>:         
				        </td>
				          
								<td>
									<div style="position:relative;">
										<span style="margin-left:100px;width:18px;overflow:hidden;">
											  	<adrm_order:selectList name="users" key="2" level="0" toScope="page"/> 
											     <html:select property="createBy" styleId="createBy"  style="width:136px;margin-left:-100px;" > 
											     <html:option value=""/> <html:options collection="users"  property="value" labelProperty="label"/> 
											     </html:select> 						
										</span>
									</div>   
									
								</td>
								
							</tr>	
								
		              
        </c:if>     
        
        
        
        
	 						<tr> 		
						<td width="50%" nowrap="nowrap" class="dataLabel">
					    	父组织:   
				        </td>
				          
								<td>
									<div style="position:relative;">
										<span style="margin-left:100px;width:18px;overflow:hidden;">
										   
											  	<adrm_order:selectList name="orgParentIds" key="45" level="0" toScope="page"/> 
											     <html:select property="parentId" styleId="parentId"  style="width:136px;margin-left:-100px"> 
												      <html:options collection="orgParentIds"  property="value" labelProperty="label"/> 
											     </html:select> 	
					
										</span>
									</div>   
									
								</td>
								
							</tr>	   	        
        
        
	 		<tr> 
			    <td nowrap="nowrap" class="dataLabel">
			    	<fmt:message key="branchForm.displayNo"/>:       	
		        </td>
		        <td>
			        <html:errors property="displayNo"/>
			        <html:text property="displayNo" styleId="displayNo"/>
				</td>
			</tr>   
        
        
        
        
        
        
        
                  
				       
				       
					
					</tbody>
				 </table>
				 </td>
				 <td valign="top" align="left"> 
				 <table>
				 
				 	<tr> 
					    <td width="10px"><fmt:message key="orgForm.picture"/></td>
						<td>&nbsp;</td>
					</tr>
					
					<tr> 

				        <td width="1px">
							<INPUT   TYPE="hidden"   NAME="logo" id="logo" >
	  		 				<INPUT   TYPE="file"   NAME="image" id="image" onchange="changeLogo(this)">
						</td>
						
						<td>&nbsp;</td>
					</tr>

					<tr> 

				        <td><img src="<c:out  value="${orgForm.logFile}"/>" width="100px" heigth="100px"></td>
						<td>&nbsp;</td>
					</tr>
										
				</table>	
				 
				 
				 
				 </td>
				 </tr>
				 
				 </table>
				
				&nbsp;&nbsp;
				
				
				<table width="26%" border="0" cellspacing="0" cellpadding="0">
						  <tr>
						  	<td>
						  		<div align="center"> 
							        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
							            <fmt:message key="button.save"/>
							        </html:submit>
							        
							        
							        
							        <c:if test="${pageContext.request.remoteUser == 'admin'}">
			      						 <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('Org')">
	          								  <fmt:message key="button.delete"/>
	      							 	 </html:submit>
		           					 </c:if> 
					
							
							        <html:cancel styleClass="button" onclick="bCancel=true">
							            						返回
							        </html:cancel>
							      </div>
							 </td>
						 </tr>
				</table> 



				<!-- img src="images/logo.jpg" width="100" height="100" -->




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
    Form.focusFirstElement($("orgForm"));
    
    function changeLogo(e){
      $("logo").value = e.value;
    }
</script>

<html:javascript formName="orgForm" cdata="false" dynamicJavascript="false" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
