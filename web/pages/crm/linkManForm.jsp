<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="linkManDetail.title"/></title>

<script type="text/javascript" src="<c:url value='/scripts/class/customer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>

<content tag="heading"><fmt:message key="linkManDetail.heading"/></content>

<html:form action="saveLinkMan" method="post" styleId="linkManForm" onsubmit="return validateLinkManForm(this)">

<html:hidden property="version"/>
<html:hidden property="id"/>
 <html:hidden property="customerId"  styleId="customerId" />
 <html:hidden property="orgId"  styleId="orgId" />
<script>

callOnLoad(init);

	function oncustomerCmdchange(){
	
		$("customerId").value = $("customerCmd").value;
	}


function init(){

    var customer = new Customer();
	var dialogcontent = $("dialogcontentDiv");
	var orgId =  getParamFromUrl(window.location.href,"orgId")+'';
    loginUser = $("config_username").value;		
	
	
	function setCustomerSelected(){
	   $("customerCmd").value =  $("customerId").value;
	    if($("orgId").value ==''){
	  		  $("orgId").value  = orgId;
	    }else{
	   		 orgId = $("orgId").value;
	    }
	    
	   $("customerCmd").remove(0);
	    
	}
	
	   if(orgId ==''||orgId =='null'){
	  		  orgId =  $("orgId").value;
	    }else{
	   		$("orgId").value = orgId;
	    }
	    

	
	customer.obj.orgId = orgId;
	customer.obj.loginUser = loginUser;
	customer.makeSelectAnalyzeWidth(customer.obj,"customerCmd","oncustomerCmdchange","180",setCustomerSelected);
	

	
	
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
                    
                  

								<html:submit styleClass="button" property="method.save" onclick="bCancel=false">
									&nbsp;&nbsp;<fmt:message key="button.save"/>&nbsp;&nbsp;
								</html:submit>
						
								<html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('LinkMan')">
									&nbsp;&nbsp;<fmt:message key="button.delete"/>&nbsp;&nbsp;
								</html:submit>
						
								<html:cancel styleClass="button" onclick="bCancel=true">
									&nbsp;&nbsp;<fmt:message key="button.cancel"/>&nbsp;&nbsp;
								</html:cancel>
                        
                    
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
            
            <!--table start-->
            

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td width="50%"> <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr> 
                <td width="48%" valign="top"> 
                  <fieldset  width="99%">
                  <legend><!-- ��Ҫ��Ϣ --><fmt:message key="linkManForm.title.mainInfo"/></legend>
                  <table width="99%" border="0" cellpadding="0" cellspacing="0">
                    <tr> 
                      <td width="50%" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                          <tbody>
                            <tr> 
                              <td  nowrap="nowrap" class="dataLabel">
							  <!-- ���� -->
							  <fmt:message key="linkManForm.linkmanName"/>: </td>
                              <td width="1px"> 
							      <html:errors property="linkmanName"/>
       							 <html:text property="linkmanName" styleId="linkmanName" styleClass="text medium"/>
                              </td>
                               <td>&nbsp;</td>				
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="requiredInput">
                                <!-- �ǳ� -->
								<fmt:message key="linkManForm.nickleName"/>:
                              </td>
                              <td>
								<html:errors property="nickleName"/>
								<html:text property="nickleName" styleId="nickleName" styleClass="text medium"/>							  
							  </td>
							  <td>&nbsp;</td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- �Ա� -->
							  <fmt:message key="linkManForm.sex"/>:
							   </td>
                              <td>
							    
							    <html:radio property="sex" value="1"/>
                                <!-- �� --> <fmt:message key="linkManForm.sexJ"/>
                                <html:radio property="sex" value="2"/>
                                <!-- Ů --><fmt:message key="linkManForm.sexM"/>
								</td>
								<td>&nbsp;</td>
                            </tr>
                            <tr> 
                              <td  width="10%"  nowrap="nowrap" class="dataLabel">
							  <!-- �������� -->
							  <fmt:message key="linkManForm.birthday"/>
							   </td>
                              <td>

		                  		<adrm_order:selectList name="birthdayYears" key="19"  toScope="page"/> 
		                          <html:select property="birthdayYear" styleId="birthdayYear"> 
		                          <html:option value=""/> <html:options collection="birthdayYears"  property="value" labelProperty="label"/> 
		                        </html:select>   
		                        
                                <!-- �� --> <fmt:message key="linkManForm.birthdayYear"/>
                                
 		  						<adrm_order:selectList name="birthdayMonths" key="10"  toScope="page"/> 
		                          <html:select property="birthdayMonth" styleId="birthdayMonth"> 
		                          <html:option value=""/> <html:options collection="birthdayMonths"  property="value" labelProperty="label"/> 
		                        </html:select>
		                        
                                <!-- �� --> <fmt:message key="linkManForm.birthdayMonth"/>

 		  						 <adrm_order:selectList name="birthdayDays" key="11"  toScope="page"/> 
		                          <html:select property="birthdayDay" styleId="birthdayDay"> 
		                          <html:option value=""/> <html:options collection="birthdayDays"  property="value" labelProperty="label"/> 
		                        </html:select>	
		                        
                                <!-- �� --> <fmt:message key="linkManForm.birthdayDay"/>
                                
                                <label id=chk_bmonth></label> &nbsp;&nbsp; <label id=chk_bday></label> 
                                
                                
                                
                              </td>
                              
                              <td width="1%">&nbsp;</td>
                              
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- ������� -->
							  <fmt:message key="linkManForm.anni"/>:
							  </td>
                              <td>
		                  		<adrm_order:selectList name="anniYears" key="19"  toScope="page"/> 
		                          <html:select property="anniYear" styleId="anniYear"> 
		                          <html:option value=""/> <html:options collection="anniYears"  property="value" labelProperty="label"/> 
		                        </html:select> 
		                        
                                <!-- �� --> <fmt:message key="linkManForm.anniYear"/>
                                
 		  						<adrm_order:selectList name="anniMonths" key="10"  toScope="page"/> 
		                          <html:select property="anniMonth" styleId="anniMonth"> 
		                          <html:option value=""/> <html:options collection="anniMonths"  property="value" labelProperty="label"/> 
		                        </html:select>
		                        
                                <!-- �� --> <fmt:message key="linkManForm.anniMonth"/>
                                
 		  						<adrm_order:selectList name="anniDays" key="11"  toScope="page"/> 
		                          <html:select property="anniDay" styleId="anniDay"> 
		                          <html:option value=""/> <html:options collection="anniDays"  property="value" labelProperty="label"/> 
		                        </html:select>	
		                        
                                <!-- �� --> <fmt:message key="linkManForm.anniDay"/>
                                <label id=chk_bmonth></label> &nbsp;&nbsp; <label id=chk_bday></label></td>
                                
                                <td>&nbsp;</td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- ���˰��� -->
							  <fmt:message key="linkManForm.memo"/>:
							  </td>
                              <td>
							     <html:errors property="memo"/>
       							 <html:text property="memo" styleId="memo" styleClass="text medium"/>
							  </td>
							  <td>&nbsp;</td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- ��˾���� -->
							  <fmt:message key="linkManForm.companyName"/>:
							  </td>
                              <td>
	                            <select id="customerCmd" name="customerCmd">
	                            
	                           
	                           
                               <!-- div style="position:relative;">
								<span style="margin-left:100px;width:18px;overflow:hidden;">
		  						  <adrm_order:selectList name="customers" key="8"  toScope="page"/> 
		                          <html:select property="customerId" styleId="customerId"  style="width:178px;margin-left:-100px"> 
		                          <html:option value=""/> <html:options collection="customers"  property="value" labelProperty="label"/> 
		                          </html:select> 								
								</span>
								</div -->								
								
								
							  </td>
							  <td>&nbsp;</td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- ְ������ -->
							  <fmt:message key="linkManForm.jobTitle"/>:
							  </td>
                              <td>
								<html:errors property="jobTitle"/>
								<html:text property="jobTitle" styleId="jobTitle" styleClass="text medium"/>
							  </td>
							  <td>&nbsp;</td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- ��˾��ַ -->
							  <fmt:message key="linkManForm.companyWebsite"/>:
							  </td>
                              <td>
							      <html:errors property="companyWebsite"/>
       							 <html:text property="companyWebsite" styleId="companyWebsite" styleClass="text medium"/>
							  </td>
							  <td>&nbsp;</td>
                            </tr>
                            
                            
                            
                            
                            <tr> 
                              <td></td><td></td>
                            </tr>
                          </tbody>
                        </table></td>
                    </tr>
                  </table>
                  </fieldset>
                  
                </td>
              </tr>
            </table></td>
          <td valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr> 
                <td width="48%" valign="top"> 
                  <!--baseinso start-->
                  <fieldset  width="99%">
                  <legend><!-- ��ϵ��ʽ --><fmt:message key="linkManForm.title.linkFun"/></legend>
                  <table width="99%" border="0" cellpadding="0" cellspacing="0">
                    <tr> 
                      <td width="50%" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                          <tbody>
                            <tr> 
                              <td width="10%">
							  <!-- סլ�绰 -->
							  <fmt:message key="linkManForm.homeTel"/>:
							   </td>
                              <td width="1px">
								<html:errors property="homeTel"/>
								<html:text property="homeTel" styleId="homeTel" styleClass="text medium"/>
							   </td>
							    <td>&nbsp;</td>		
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="requiredInput">
							  <!-- �����绰 -->
							   <fmt:message key="linkManForm.officeTel"/>:
							  </td>
                              <td>
								<html:errors property="officeTel"/>
								<html:text property="officeTel" styleId="officeTel" styleClass="text medium"/>
							  </td>
							   <td>&nbsp;</td>		
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="requiredInput">
							  <!-- �ƶ��绰 -->
							   <fmt:message key="linkManForm.mobile"/>:
                              </td>
                              <td>
								<html:errors property="mobile"/>
								<html:text property="mobile" styleId="mobile" styleClass="text medium"/>
							   </td>
							    <td>&nbsp;</td>		
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- ��Ҫ�绰 -->
							  <fmt:message key="linkManForm.mainTel"/>:
							  </td>
                              <td>
                              
       							<html:select property="mainTel" styleId="mainTel"> 
		                          <html:option value="0"> <fmt:message key="linkManForm.homeTel"/></html:option>
		                          <html:option value="1"> <fmt:message key="linkManForm.officeTel"/></html:option>
		                          <html:option value="2"> <fmt:message key="linkManForm.mobile"/></html:option>
		                         </html:select> 								                         

                                </td>
                                 <td>&nbsp;</td>		
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- ��ѡ�������� -->
							  <fmt:message key="linkManForm.favorEmail"/>:
							  </td>
                              <td>
								<html:errors property="favorEmail"/>
								<html:text property="favorEmail" styleId="favorEmail" styleClass="text medium"/>
							  </td>
							   <td>&nbsp;</td>		
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- ���õ������� -->
							  <fmt:message key="linkManForm.bakEmail"/>:
							   </td>
                              <td>
								<html:errors property="bakEmail"/>
								<html:text property="bakEmail" styleId="bakEmail" styleClass="text medium"/>
							  </td>
							   <td>&nbsp;</td>		
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">MSN: </td>
                              <td>
								<html:errors property="msn"/>
								<html:text property="msn" styleId="msn" styleClass="text medium"/>
							  </td>
							   <td>&nbsp;</td>		
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">ICQ</td>
                              <td>
								<html:errors property="oicq"/>
								<html:text property="oicq" styleId="oicq" styleClass="text medium"/>
							  </td>
							   <td>&nbsp;</td>		
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- ������ַ --><fmt:message key="linkManForm.homePage"/>:
							  </td>
                              <td>
								<html:errors property="homePage"/>
								<html:text property="homePage" styleId="homePage" styleClass="text medium"/>
							  </td>
							   <td>&nbsp;</td>		
                            </tr>
                          </tbody>
                        </table></td>
                    </tr>
                  </table>
                  </fieldset>
                  <!--baseinso end-->
                </td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td width="50%"> <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr> 
                <td width="50%"> 
                  <!--baseinso start-->
                  <fieldset  width="99%">
                  <legend><!-- סլ��ַ --><fmt:message key="linkManForm.title.homeAddress"/></legend>
                  <table width="99%" border="0" cellpadding="0" cellspacing="0">
                    <tr> 
                      <td width="50%" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                          <tbody>
                            <tr> 
                              <td  width="11%" nowrap="nowrap" class="dataLabel"> 
                                <!-- ���� -->
                                <fmt:message key="linkManForm.companyCountry"/>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                              </td>
                              <td  width="1px">
	                              <html:errors property="companyCountry"/>
	                              <html:text property="companyCountry" styleId="companyCountry" styleClass="text medium"/> 
                              </td>
                              <td>&nbsp;</td>		
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- �ʱ� -->
                                <fmt:message key="linkManForm.companyZip"/>:</td>
                              <td> <html:errors property="companyZip"/> <html:text property="companyZip" styleId="companyZip" styleClass="text medium"/> 
                              </td>
                              <td>&nbsp;</td>		
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- ���� -->
                                <fmt:message key="linkManForm.companyProvince"/>:
                              </td>
                              <td> <html:errors property="companyProvince"/> <html:text property="companyProvince" styleId="companyProvince" styleClass="text medium"/> 
                              </td>
                              <td>&nbsp;</td>		
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- ���� -->
                                <fmt:message key="linkManForm.companyCity"/>:
                              </td>
                              <td> <html:errors property="companyCity"/> <html:text property="companyCity" styleId="companyCity" styleClass="text medium"/> 
                              </td>
                              <td>&nbsp;</td>		
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap" valign="top"> 
                                <!-- �ֵ� -->
                                <fmt:message key="linkManForm.companyScarriert"/>:
                              </td>
                              <td valign="top"> <html:errors property="companyScarriert"/> 
                                <html:text property="companyScarriert" styleId="companyScarriert" styleClass="text medium"/> 
                              </td>
                              <td>&nbsp;</td>		
                            </tr>
                          </tbody>
                        </table></td>
                    </tr>
                  </table>
                  </fieldset>
                  <!--baseinso end-->
                </td>
              </tr>
            </table></td>
   
            
          <td width="50%">
          
          <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr> 
                <td width="50%"> 
                  <!--baseinso start-->
                  <fieldset  width="99%">
                  <legend><!-- ������ַ --><fmt:message key="linkManForm.title.workAddress"/></legend>
                  <table width="99%" border="0" cellpadding="0" cellspacing="0">
                    <tr> 
                      <td width="50%" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                          <tbody>
                            <tr> 
                              <td width="11%" nowrap="nowrap" class="dataLabel"> 
                                <!-- ���� -->
                                <fmt:message key="linkManForm.homeCountry"/>: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                              </td>
                              <td  width="1px"> <html:errors property="homeCountry"/> <html:text property="homeCountry" styleId="homeCountry" styleClass="text medium"/> 
                              </td>
                               <td>&nbsp;</td>	
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- �ʱ� -->
                                <fmt:message key="linkManForm.homeZip"/>: </td>
                              <td> <html:errors property="homeZip"/> <html:text property="homeZip" styleId="homeZip" styleClass="text medium"/> 
                              </td>
                               <td>&nbsp;</td>	
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- ���� -->
                                <fmt:message key="linkManForm.homeProvince"/>: 
                              </td>
                              <td> <html:errors property="homeProvince"/> <html:text property="homeProvince" styleId="homeProvince" styleClass="text medium"/> 
                              </td>
                               <td>&nbsp;</td>	
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- ���� -->
                                <fmt:message key="linkManForm.homeCity"/>: </td>
                              <td> <html:errors property="homeCity"/> <html:text property="homeCity" styleId="homeCity" styleClass="text medium"/> 
                              </td>
                               <td>&nbsp;</td>	
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap" valign="top"> 
                                <!-- �ֵ� -->
                                <fmt:message key="linkManForm.homeScarriert"/>: 
                              </td>
                              <td valign="top"> <html:errors property="homeScarriert"/> 
                                <html:text property="homeScarriert" styleId="homeScarriert" styleClass="text medium"/> 
                              </td>
                               <td>&nbsp;</td>	
                            </tr>
                          </tbody>
                        </table></td>
                    </tr>
                  </table>
                  </fieldset>
                  <!--baseinso end-->
                </td>
              </tr>
            </table></td>
        </tr>
      </table>

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
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("linkManForm"));
</script>

<html:javascript formName="linkManForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
