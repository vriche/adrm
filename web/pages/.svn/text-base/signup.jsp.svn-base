<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="<c:url value='/scripts/common/popupWindow.js'/>"></script>

<html:form action="/signup" styleId="userForm" onsubmit="return validateUserForm(this)">

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/global.css'/>" /> 
<body id="signup"/>
<p>&nbsp;</p>
<p>&nbsp;</p>
<ul>
<script> 
var popupcenter = new Popupcenter();
    callOnLoad(init);	
  function init(){
	   helpPage();
	}  
 function helpPage(){
	popupcenter.url = "help/index.jsp";
	popupcenter.model = 11;
	popupcenter.popupcenter(popupcenter);
}
</script>
<table width="750" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td>
			<TABLE width=260 height=37 border=0 align="right" cellPadding=0 cellSpacing=0>
				<TBODY>
					<TR> 
						<TD colSpan=21 height=16></TD>
					</TR>
					<TR> 
						<TD width=2 height=21><IMG height=21 src="image/login/bgru04.jpg"  width=2></TD>
							<TD vAlign=bottom align=middle width=49 background=image/login/bgru01.jpg>
							<a href="login.jsp">
							
								<fmt:message key="button.login"/>
							
							</a>
						</TD>
										          
						<TD width=8><IMG height=21 src="image/login/bgru02.jpg" width=8></TD>
						<TD vAlign=bottom align=middle width=49 background=image/login/bgru01.jpg>
							<a href="signup.html">
							
								<fmt:message key="button.register"/>
							 
							</a>
						</TD>
													
						<TD width=8><IMG height=21 src="image/login/bgru02.jpg" width=10 height=19></TD>
						<TD vAlign=bottom align=middle width=49 background=image/login/bgru01.jpg>
							<a href="remin.htm">
								<fmt:message key="login.passwordfind"/>
							</a>
						</TD>       
										                        
						<TD width=8><IMG height=21 src="image/login/bgru02.jpg" width=8></TD>
						<TD vAlign=bottom align=middle width=49 background=image/login/bgru01.jpg>
							  <a href="javascript:void 0" onClick="helpPage()">
								<fmt:message key="button.help"/>
							</a>
						</TD>				          	
						<TD width=6><IMG height=21 src="image/login/bgru03.jpg" width=6></TD>
					</TR>
				</TBODY>
			</TABLE>
		</td>
	</tr>
</table>

<table border="0" cellpadding="0" cellspacing="0" height="1" width="750" align="center">
	<tbody><tr><td class="bg02"></td></tr>
	</tbody>
</table>

<table width="750" height="9" border="0" align="center" cellpadding="0" cellspacing="0">
	<tbody><tr><td class="bg02" width="1"></td>
		<td class="bg01" width="748"></td>
		<td class="bg02" width="1"></td></tr>
	</tbody>
</table>

<table width="750" height="9" border="0" align="center" cellpadding="0" cellspacing="0">
	<tbody>
	  	<tr>
	  		<td class="bg02" width="1"></td>
			<td class="bg01" width="748"></td>
			<td class="bg02" width="1"></td>
		</tr>
	</tbody>
</table>

<table width="750" border="0" align="center" cellpadding="0" cellspacing="0" background="image/main/normal-bg.gif">
	<tbody>
		<TR>
			<td width="1" height="371" class="bg02"></td>
			<td class="bg01" width="8"></td>
        
			<TD width="732" align="center" valign="top">
				<TABLE cellSpacing=0 cellPadding=0 width=100% align=center border=0>
					<TBODY>		          
					<TR> 
							<TD><table border="0" cellpadding="0" cellspacing="2" height="40" width="100%">
			                  <tbody>
			                    <tr> 
			                      <td align="right" width="20"><img src="image/login/reg_ico_01.gif" height="12" width="12"></td>
			                      <td class="f14">
										<fmt:message key="signup.message"/>
								  </td>
			                      <td class="f14" align="right"><b></b></td>
			                    </tr>
			                  </tbody>
			                </table>
			               </TD>
            		</TR>
            													
					<TR>
						<TD bgColor=#ffffff><table border="0" cellpadding="0" cellspacing="2" width="100%">
						<tbody>
                    	<tr> 
                      		<td background="image/login/reg_s_04.gif" height="1"></td>
                    	</tr>
                  		</tbody>
                		</table>
                		
                		<TABLE cellSpacing=0 cellPadding=4 width="100%" border=0>
                  			<TBODY>
                  			<TD><table border="0" cellpadding="0" cellspacing="2" height="40" width="70%">
                  
                    		<TR > 
                      			<TD colspan="2"  align="center">&nbsp;</TD>
                    		</TR>
                    		
                    		<TR> 
		                      <TD align=right>
									
											        <adrm_order:label key="userForm.username"/>
											        <html:errors property="username"/>
											        <html:text styleClass="text large" property="username" styleId="username"/>
											        						
							  </TD>
							</TR>
							<TR> 
		                      <TD align=right>
		            						
											        <div>
											            <div class="left">
											                <adrm_order:label key="userForm.password"/>
											                <html:errors property="password"/>
											                <html:password styleClass="text medium" property="password" styleId="password" redisplay="true"/>
											            </div>
											            &nbsp;
											            <div>
											                <adrm_order:label key="userForm.confirmPassword"/>
											                <html:errors property="confirmPassword"/>
											                <html:password styleClass="text medium" property="confirmPassword" styleId="confirmPassword" redisplay="true"/>
											            </div>
											        </div>
											    
		        					
							  </TD>
							</TR>
							<TR> 
		                      <TD align=right>
											
											        <adrm_order:label  key="userForm.passwordHint"/>
											        <html:errors property="passwordHint"/>
											        <html:text styleClass="text large" property="passwordHint" styleId="passwordHint"/>
											
		        			 </TD>
							</TR>  
							<TR> 
		                      <TD align=right>
										
											        <div>
											            <div class="left">
											                <adrm_order:label key="userForm.lastName"/>
											                <html:errors property="firstName"/>
											                <html:text styleClass="text medium" property="firstName" styleId="firstName" maxlength="50"/>
											            </div>
											            &nbsp;
											            <div>
											                <adrm_order:label key="userForm.firstName"/>
											                <html:errors property="lastName"/>
											                <html:text styleClass="text medium" property="lastName" styleId="lastName" maxlength="50"/>
											            </div>
											            &nbsp;
											            <div>
											            <div class="left">
											                <adrm_order:label key="userForm.email"/>
											                <html:errors property="email"/>
											                <html:text styleClass="text medium" property="email" styleId="email"/>
											            </div>
											        </div>
									 

							  </TD>
							</TR>
							
							</table>
							</TD>
							<td><table border="0" cellpadding="0" cellspacing="2" height="40" width="50%">
							
							<TR > 
                      			<TD colspan="2"  align="center">&nbsp;</TD>
                    		</TR>
							<TR> 
		                      <TD align=right>
										    <div>
									                <adrm_order:label key="userForm.phoneNumber"/>
									                <html:errors property="phoneNumber"/>
									                <html:text property="phoneNumber" styleId="phoneNumber"/>
									            </div>
									        </div>
									    
							  </TD>
							</TR>							
							<TR> 
		                      <TD align=right>
										   <div>
									                <adrm_order:label key="userForm.website"/>
									                <html:errors property="website"/>
									                <html:text property="website" styleId="website"/>
									            </div>
							  </TD>
							</TR>
							
							<TR> 
		                      <TD align=right>
											<div>
									            	<adrm_order:label key="userForm.addressForm.address"/>
									                <html:text property="addressForm.address"
									                    styleId="addressForm.address"/>
									                <html:errors property="addressForm.address"/>
									                
									        </div>
		        			 </TD>
							</TR>
						
							<TR> 
		                      <TD align=right>
										
									        <div class="group">
									            
									            <div class="left">
									            	<adrm_order:label key="userForm.addressForm.city"/>
									                <html:text styleClass="text medium" property="addressForm.city"
									                    styleId="addressForm.city"/>
									                <html:errors property="addressForm.city"/>
									                
									            </div>
									            &nbsp;
									            <div>
									            	<adrm_order:label key="userForm.addressForm.province"/>
									                <html:text styleClass="text state" property="addressForm.province"
									                    styleId="addressForm.province" size="2"/>
									                <html:errors property="addressForm.province"/>
									                
									            </div>
									            &nbsp;
									            <div class="left">
									            	<adrm_order:label key="userForm.addressForm.postalCode"/>
									                <html:text styleClass="text zip" property="addressForm.postalCode"
									                    styleId="addressForm.postalCode"/>
									                <html:errors property="addressForm.postalCode"/>
									                
									            </div>
									            &nbsp;
									            <div class="left">
									                <adrm_order:country name="countries" toScope="page"/>
									                <adrm_order:label key="userForm.addressForm.country"/>
									                <html:select property="addressForm.country" styleClass="select">
									                    <html:option value=""/>
									                    <html:options collection="countries" property="value" labelProperty="label"/>
									                </html:select>
									                <html:errors property="addressForm.country"/>
									                
									            </div>
									        </div>
									   
							  </TD>
							</TR>
							</table>
							</td>
							<TR> 
				              <TD ><table border="0" cellpadding="0" cellspacing="2" width="100%">
				                  <tbody>
				                    <tr> 
				                      <td background="image/login/reg_s_04.gif" height="1"></td>
				                    </tr>
				                  </tbody>
				                </table></TD>
				                					  
			                      <td valign="top"> 
			                        <table border="0" cellpadding="0" cellspacing="0">
			                          <tbody>
			                          
			                            <tr> 
			                              <td align="center" valign="top" width="70">
			                                <table border="0" cellpadding="0" cellspacing="0">
			                                  <tbody>
			                                    <tr> 
			                                      <td align="center" bgcolor="#ffffff" height="25" valign="center" width="44"> 
			                                        <!-- SCRIPT language=javascript>document.write("<img src=/cgi_bin/RndValidCode.asp?time=" + Math.random() + " width=40,height=16>");</SCRIPT -->
			                                      </td>
			
			                                    </tr>
			                                  </tbody>
			                                </table>
			                             </td>
			                           </tr>                                                      
			                         </tbody>                         
			                      </table>                    
			                    </td>
				            </TR>
				            <TR> 
				              <TD align=middle > <div align="center">
				                  
							        <html:submit styleClass="" onclick="bCancel=false">
							            <fmt:message key="button.register"/>
							        </html:submit>
							
							        <!-- html:cancel styleClass="" onclick="bCancel=true" -->
							            <!-- fmt:message key="button.cancel"/ -->
							        <!-- /html:cancel -->
							    
				              </div>
				              </TD>
				            </TR> 							
	
						</tbody>
					</table>
				</TD>				
			</TR>
			<TR> 
				<TD>
				     <table border="0" cellpadding="0" cellspacing="2" width="100%">
					      <tbody>
						      <tr> 
						         <td  background="image/login/reg_s_04.gif" height="1"></td>
						      </tr>
					      </tbody>
				     </table>
				</TD>
			</TR>	
			</TBODY>
		</TABLE>
		</TD>
		<td class="bg01" width="8"></td>
		<td class="bg02" width="1"></td>
		</TR>
	</TBODY>
</TABLE>	

<table align="center" border="0" cellpadding="0" cellspacing="0" height="9" width="750">
	<tbody><tr><td class="bg02" width="1"></td>
		<td class="bg01" width="748"></td>
		<td class="bg02" width="1"></td></tr>
	</tbody>
</table>
	
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($('userForm'));
</script>
<html:javascript formName="userForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script>
