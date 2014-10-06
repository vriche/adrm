<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="linkManDetail.title"/></title>
<content tag="heading"><fmt:message key="linkManDetail.heading"/></content>

<html:form action="saveLinkMan" method="post" styleId="linkManForm" onsubmit="return validateLinkManForm(this)">

<html:hidden property="version"/>
<html:hidden property="id"/>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td width="50%"> <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr> 
                <td width="50%"> 
                  <!--baseinso start-->
                  <fieldset>
                  <legend><!-- 主要信息 --><fmt:message key="linkManForm.title.mainInfo"/></legend>
                  <table width="99%" border="0" cellpadding="0" cellspacing="0">
                    <tr> 
                      <td width="50%" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                          <tbody>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- 姓名 -->
							  <fmt:message key="linkManForm.linkmanName"/>: </td>
                              <td > 
							      <html:errors property="linkmanName"/>
       							 <html:text property="linkmanName" styleId="linkmanName" styleClass="text medium"/>
                              </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="requiredInput">
                                <!-- 昵称 -->
								<fmt:message key="linkManForm.nickleName"/>:
                              </td>
                              <td>
								<html:errors property="nickleName"/>
								<html:text property="nickleName" styleId="nickleName" styleClass="text medium"/>							  
							  </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- 性别 -->
							  <fmt:message key="linkManForm.sex"/>:
							   </td>
                              <td>
							    
							    <html:radio property="sex" value="1"/>
                                <!-- 男 --> <fmt:message key="linkManForm.sexJ"/>
                                <html:radio property="sex" value="2"/>
                                <!-- 女 --><fmt:message key="linkManForm.sexM"/>
								</td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- 出生日期 -->
							  <fmt:message key="linkManForm.birthday"/>
							   </td>
                              <td>

		                  		<adrm_order:selectList name="birthdayYears" key="19"  toScope="page"/> 
		                          <html:select property="birthdayYear" styleId="birthdayYear"> 
		                          <html:option value=""/> <html:options collection="birthdayYears"  property="value" labelProperty="label"/> 
		                        </html:select>   
		                        
                                <!-- 年 --> <fmt:message key="linkManForm.birthdayYear"/>
                                
 		  						<adrm_order:selectList name="birthdayMonths" key="10"  toScope="page"/> 
		                          <html:select property="birthdayMonth" styleId="birthdayMonth"> 
		                          <html:option value=""/> <html:options collection="birthdayMonths"  property="value" labelProperty="label"/> 
		                        </html:select>
		                        
                                <!-- 月 --> <fmt:message key="linkManForm.birthdayMonth"/>

 		  						 <adrm_order:selectList name="birthdayDays" key="11"  toScope="page"/> 
		                          <html:select property="birthdayDay" styleId="birthdayDay"> 
		                          <html:option value=""/> <html:options collection="birthdayDays"  property="value" labelProperty="label"/> 
		                        </html:select>	
		                        
                                <!-- 日 --> <fmt:message key="linkManForm.birthdayDay"/>
                                
                                <label id=chk_bmonth></label> &nbsp;&nbsp; <label id=chk_bday></label> 
                              </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- 周年纪念 -->
							  <fmt:message key="linkManForm.anni"/>:
							  </td>
                              <td>
		                  		<adrm_order:selectList name="anniYears" key="19"  toScope="page"/> 
		                          <html:select property="anniYear" styleId="anniYear"> 
		                          <html:option value=""/> <html:options collection="anniYears"  property="value" labelProperty="label"/> 
		                        </html:select> 
		                        
                                <!-- 年 --> <fmt:message key="linkManForm.anniYear"/>
                                
 		  						<adrm_order:selectList name="anniMonths" key="10"  toScope="page"/> 
		                          <html:select property="anniMonth" styleId="anniMonth"> 
		                          <html:option value=""/> <html:options collection="anniMonths"  property="value" labelProperty="label"/> 
		                        </html:select>
		                        
                                <!-- 月 --> <fmt:message key="linkManForm.anniMonth"/>
                                
 		  						<adrm_order:selectList name="anniDays" key="11"  toScope="page"/> 
		                          <html:select property="anniDay" styleId="anniDay"> 
		                          <html:option value=""/> <html:options collection="anniDays"  property="value" labelProperty="label"/> 
		                        </html:select>	
		                        
                                <!-- 日 --> <fmt:message key="linkManForm.anniDay"/>
                                <label id=chk_bmonth></label> &nbsp;&nbsp; <label id=chk_bday></label></td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- 个人爱好 -->
							  <fmt:message key="linkManForm.memo"/>:
							  </td>
                              <td>
							     <html:errors property="memo"/>
       							 <html:text property="memo" styleId="memo" styleClass="text medium"/>
							  </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- 公司名称 -->
							  <fmt:message key="linkManForm.companyName"/>:
							  </td>
                              <td>
	
                               <div style="position:relative;">
								<span style="margin-left:100px;width:18px;overflow:hidden;">
		  						  <adrm_order:selectList name="customers" key="8"  toScope="page"/> 
		                          <html:select property="customerId" styleId="customerId"  style="width:178px;margin-left:-100px"> 
		                          <html:option value=""/> <html:options collection="customers"  property="value" labelProperty="label"/> 
		                          </html:select> 								
								</span>
								</div>								
								
								
							  </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- 职务描述 -->
							  <fmt:message key="linkManForm.jobTitle"/>:
							  </td>
                              <td>
								<html:errors property="jobTitle"/>
								<html:text property="jobTitle" styleId="jobTitle" styleClass="text medium"/>
							  </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- 公司网址 -->
							  <fmt:message key="linkManForm.companyWebsite"/>:
							  </td>
                              <td>
							      <html:errors property="companyWebsite"/>
       							 <html:text property="companyWebsite" styleId="companyWebsite" styleClass="text medium"/>
							  </td>
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
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr> 
                <td width="50%"> 
                  <!--baseinso start-->
                  <fieldset>
                  <legend><!-- 联系方式 --><fmt:message key="linkManForm.title.linkFun"/></legend>
                  <table width="99%" border="0" cellpadding="0" cellspacing="0">
                    <tr> 
                      <td width="50%" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                          <tbody>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- 住宅电话 -->
							  <fmt:message key="linkManForm.homeTel"/>:
							   </td>
                              <td >
								<html:errors property="homeTel"/>
								<html:text property="homeTel" styleId="homeTel" styleClass="text medium"/>
							   </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="requiredInput">
							  <!-- 工作电话 -->
							   <fmt:message key="linkManForm.officeTel"/>:
							  </td>
                              <td>
								<html:errors property="officeTel"/>
								<html:text property="officeTel" styleId="officeTel" styleClass="text medium"/>
							  </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="requiredInput">
							  <!-- 移动电话 -->
							   <fmt:message key="linkManForm.mobile"/>:
                              </td>
                              <td>
								<html:errors property="mobile"/>
								<html:text property="mobile" styleId="mobile" styleClass="text medium"/>
							   </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- 主要电话 -->
							  <fmt:message key="linkManForm.mainTel"/>:
							  </td>
                              <td>
                              
       							<html:select property="mainTel" styleId="mainTel"> 
		                          <html:option value="0"> <fmt:message key="linkManForm.homeTel"/></html:option>
		                          <html:option value="1"> <fmt:message key="linkManForm.officeTel"/></html:option>
		                          <html:option value="2"> <fmt:message key="linkManForm.mobile"/></html:option>
		                         </html:select> 								                         

                                </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- 首选电子信箱 -->
							  <fmt:message key="linkManForm.favorEmail"/>:
							  </td>
                              <td>
								<html:errors property="favorEmail"/>
								<html:text property="favorEmail" styleId="favorEmail" styleClass="text medium"/>
							  </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- 备用电子信箱 -->
							  <fmt:message key="linkManForm.bakEmail"/>:
							   </td>
                              <td>
								<html:errors property="bakEmail"/>
								<html:text property="bakEmail" styleId="bakEmail" styleClass="text medium"/>
							  </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">MSN: </td>
                              <td>
								<html:errors property="msn"/>
								<html:text property="msn" styleId="msn" styleClass="text medium"/>
							  </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">ICQ</td>
                              <td>
								<html:errors property="oicq"/>
								<html:text property="oicq" styleId="oicq" styleClass="text medium"/>
							  </td>
                            </tr>
                            <tr> 
                              <td nowrap="nowrap" class="dataLabel">
							  <!-- 个人网址 --><fmt:message key="linkManForm.homePage"/>:
							  </td>
                              <td>
								<html:errors property="homePage"/>
								<html:text property="homePage" styleId="homePage" styleClass="text medium"/>
							  </td>
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
                  <fieldset>
                  <legend><!-- 住宅地址 --><fmt:message key="linkManForm.title.homeAddress"/></legend>
                  <table width="99%" border="0" cellpadding="0" cellspacing="0">
                    <tr> 
                      <td width="50%" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                          <tbody>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 国家 -->
                                <fmt:message key="linkManForm.companyCountry"/>:
                              </td>
                              <td>
                              <html:errors property="companyCountry"/>
                              <html:text property="companyCountry" styleId="companyCountry" styleClass="text medium"/> 
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 邮编 -->
                                <fmt:message key="linkManForm.companyZip"/>:</td>
                              <td> <html:errors property="companyZip"/> <html:text property="companyZip" styleId="companyZip" styleClass="text medium"/> 
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 区域 -->
                                <fmt:message key="linkManForm.companyProvince"/>:
                              </td>
                              <td> <html:errors property="companyProvince"/> <html:text property="companyProvince" styleId="companyProvince" styleClass="text medium"/> 
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 城市 -->
                                <fmt:message key="linkManForm.companyCity"/>:
                              </td>
                              <td> <html:errors property="companyCity"/> <html:text property="companyCity" styleId="companyCity" styleClass="text medium"/> 
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap" valign="top"> 
                                <!-- 街道 -->
                                <fmt:message key="linkManForm.companyScarriert"/>:
                              </td>
                              <td valign="top"> <html:errors property="companyScarriert"/> 
                                <html:text property="companyScarriert" styleId="companyScarriert" styleClass="text medium"/> 
                              </td>
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
          <td width="50%"><table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr> 
                <td width="50%"> 
                  <!--baseinso start-->
                  <fieldset>
                  <legend><!-- 工作地址 --><fmt:message key="linkManForm.title.workAddress"/></legend>
                  <table width="99%" border="0" cellpadding="0" cellspacing="0">
                    <tr> 
                      <td width="50%" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" id="ep">
                          <tbody>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 国家 -->
                                <fmt:message key="linkManForm.homeCountry"/>: 
                              </td>
                              <td> <html:errors property="homeCountry"/> <html:text property="homeCountry" styleId="homeCountry" styleClass="text medium"/> 
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 邮编 -->
                                <fmt:message key="linkManForm.homeZip"/>: </td>
                              <td> <html:errors property="homeZip"/> <html:text property="homeZip" styleId="homeZip" styleClass="text medium"/> 
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 区域 -->
                                <fmt:message key="linkManForm.homeProvince"/>: 
                              </td>
                              <td> <html:errors property="homeProvince"/> <html:text property="homeProvince" styleId="homeProvince" styleClass="text medium"/> 
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap"> 
                                <!-- 城市 -->
                                <fmt:message key="linkManForm.homeCity"/>: </td>
                              <td> <html:errors property="homeCity"/> <html:text property="homeCity" styleId="homeCity" styleClass="text medium"/> 
                              </td>
                            </tr>
                            <tr> 
                              <td class="dataLabel" nowrap="nowrap" valign="top"> 
                                <!-- 街道 -->
                                <fmt:message key="linkManForm.homeScarriert"/>: 
                              </td>
                              <td valign="top"> <html:errors property="homeScarriert"/> 
                                <html:text property="homeScarriert" styleId="homeScarriert" styleClass="text medium"/> 
                              </td>
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
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td ><table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr> 
                <td width="98%"> 
                  <!--baseinso start-->
                  <fieldset style="width:98%">
                  <legend></legend>
                  <table width="99%" border="0" cellpadding="0" cellspacing="0">
                    <tr> 
                      <td width="50%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr> 
                            <td><div align="center">    
								<html:submit styleClass="" property="method.save" onclick="bCancel=false">
									<fmt:message key="button.save"/>
								</html:submit>
						
								<html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('LinkMan')">
									<fmt:message key="button.delete"/>
								</html:submit>
						
								<html:cancel styleClass="" onclick="bCancel=true">
									<fmt:message key="button.cancel"/>
								</html:cancel>
          </div>
		  </td>
                          </tr>
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
      <p>&nbsp;</p></td>
  </tr>
</table>


</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("linkManForm"));
</script>

<html:javascript formName="linkManForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
