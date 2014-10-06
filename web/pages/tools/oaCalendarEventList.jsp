<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaCalendarEventList.title"/></title>
<content tag="heading"><fmt:message key="oaCalendarEventList.heading"/></content>
<meta name="menu" content="OaCalendarEventMenu"/>

<link  rel="stylesheet" type="text/css"  media="all"  href="<c:url value='/styles/${appConfig["theme"]}/tab/common.css'/>" />
<link  rel="stylesheet" type="text/css"   media="all" href="<c:url value='/styles/${appConfig["theme"]}/tab/news_style.css'/>" />
<link  rel="stylesheet" type="text/css"   media="all" href="<c:url value='/styles/${appConfig["theme"]}/tab/function_style.css'/>" />


<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>

<!-- 日历 -->
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />


<script type="text/javascript" src="<c:url value='/scripts/tab/tooltip.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/tab/calendar_Event.js'/>"></script>
<script typr="text/javascript" src="<c:url value='/scripts/tab/ajax_inject.js'/>"></script>


<script type="text/javascript" src="<c:url value='/dwr/interface/OaCalendarEventManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/oaCalendarEvent.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/tools/calendarService.js'/>"></script>



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
	<fieldset style="width: 98%" id="calendarEvent" >
	<legend></legend>
	<table width="97%" height="180" border="0" cellpadding="0" cellspacing="0">
		
		<tr>

			<td>            
                    	          	               	
                    	<div id="div1" style="display:none "><input id="txt" type="text" style="width:97%; background-color:#FFFFEF"></div>
                            	
						 <!--bodyTabs start-->    
						<div id="tabcontainer" >
						
						
							<div class="tab-pane" id="top">
							
							<div class="tab-page" >
					      		<h2 class="tab">
				<!-- 日计划 -->       <span   id="top-dayPlan">
									  <fmt:message key="OaCalendarEvent.dayPlan"/>
									  </span>
							  	</h2>
							  
							   <div id="top-dayPlan"> 
								<fieldset id="calendarList">
								<legend><fmt:message key="OaCalendarEvent.todayArange"/></legend>
								
									<div id="day_calendarEvent"/>

									
								</fieldset>
								
				              </div>
							</div>
							
							
					
					
							<div class="tab-page">
									
						      <h2 class="tab">
			<!-- 周计划 -->
				                  <span id="top_weekPlan">
								  	<fmt:message key="OaCalendarEvent.weekPlan"/>
								  </span>
							  </h2>
						      <div id="top-weekPlan"> 
						      
					      		<fieldset id="calendarWeekList">
					      			<legend><fmt:message key="OaCalendarEvent.homeAddress"/></legend>
					      		
					      			<div id="week_calendarEvent"/>
					      								      			
					      		</fieldset>
							      		
						      </div>
						      
							</div>
	
							<!-- div class="tab-page">
								
						      <h2 class="tab">
						      
		<!-- 月计划 -->        <span id="top_monthPlan">
							  	<fmt:message key="OaCalendarEvent.monthPlan"/>
							  </span>
							  </h2>
									
						      <div id="top-monthPlan">
									<fieldset id="calendarMonthList">	
									<legend><fmt:message key="OaCalendarEvent.monthPlan"/></legend>
										<div id="month_calendarEvent"/>
									</fieldset>
						      </div>
							</div -->
						
						
						
							
						    <!-- div class="tab-page"> 
						      <h2 class="tab">
			<!-- 年计划 -->       <span id="top_yearPlan">
								  <fmt:message key="OaCalendarEvent.yearPlan"/>
								 </span>
							  </h2>
									
						      <div id="top-yearPlan"> 
						      	<fieldset></fieldset>
						      </div>
							</div -->
						
						
						
						    <div class="tab-page"> 
						      <h2 class="tab"> 
			<!-- 计划查询 -->		  <span id="top_query">
								  <fmt:message key="OaCalendarEvent.query"/>
								  </span>
							  </h2>
							  <div id="top-query">  
							  	<fieldset id = "queryField">
							  		<legend><fmt:message key="OaCalendarEvent.query"/></legend>
							  		
						      		<table width="100%" border="0">

									  <tr>
									    <td valign="top">
											<table  id="oaDocumentTable" class=ListShort width="100%" cellpadding="0" >
											
								              <thead>
								                <TR class=Header> 
								                  <!--日期-->
								                  <TH><fmt:message key="mainMenu.date"/></TH> 
								                  <!--标题-->
								                  <TH><fmt:message key="oaDocumentForm.title"/></TH>
								                  <!--内容-->
								                  <TH><fmt:message key="oaCalendarEventForm.content"/></TH>
								                  <!--类别-->
								                  <TH><fmt:message key="carrierForm.carrierTypeId"/></TH>
								                  <!--状态-->
								                  <TH><fmt:message key="agentInfoForm.state"/></TH>
								                                   
								                  <TH id="button_add_new_obj"  style="cursor:hand" colspan="2" onclick="button_add_new_obj(0)"> 
								                  		<img id="contractPaymentImgAdd" name="contractPaymentImgAdd"  src="image/CRM_ADD.GIF" border="0"> 
								                  </TH>
								                </TR>
								                
								                <tr > 
								                  	<td colspan="7">
									                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
									                      <tr> 
									                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
									                      </tr>
									                    </table>
								                	</td>
								                </tr>
								              </thead>
								              
								              <tbody id="calendarEventBody"/> 
										
									          <tbody>
									          <tr height="20"><td colspan="7">
													<table width="100%" border="0" cellspacing="0" cellpadding="0">
										  				 <tr>
										  				 	 <td colspan="2"><IMG src="image/s.gif"  width="100%" height="2">
										  				 	 </td>
										  				 </tr>
								                        <tr  bgcolor="#D8DFE7">
								                          <td align="right"> 
								                              <div id="pageInfo_calendarEvent"></div>
								                          </td>
								                     	</tr>   	
												  </table>
									          </tr>
									          </tbody>
								     </table>
									    
									    
									    </td>
									  </tr>
									  <!-- tr>
									    <td>
									    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
											  <tr>
											    <td width="20%"><fmt:message key="userProfile.assignRole"/>:<input name="assignRole" type="text" id="assignRole"></td>
											    <td width="20%">
											    
											    	<fmt:message key="orderDayInfoForm.startDate"/>:
											    	
											    	<input name="beginDate" type="text" id="beginDate" readonly="true" onclick="button_showdate('beginDate','anchorCsignDate')">
											    	<span id="anchorCsignDate" name="anchorCsignDate"></span>
											    </td>
											    <td width="20%">
											    
											    	<fmt:message key="orderDayInfoForm.endDate"/>:
											    	
											    	<input name="overDate" type="text" id="overDate" readonly="true" onclick="button_showdate('overDate','anchorEndDate')">
											    	<span id="anchorEndDate" name="anchorEndDate"></span>
											    </td>
											       
											    <td width="20%"><fmt:message key="orderDayInfoForm.endDate"/>:<input name="overDate" type="text" id="overDate"></td>
											    <td width="10%"><input type="button" id="Btn_query" value="<fmt:message key="oaCalendarEventForm.query"/>"></td>
											  	<td></td>
											  </tr>
											</table>
										</td>
									  </tr -->
									</table>									
									</fieldset>
						      </div>
							</div>
							
							
		<div id="tooltipdiv"></div>  
		
		<div style="display:block;" id="calendarForm">
					<fieldset>
								<!-- 编辑 -->	
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
								   <tr> 
								   <td width="50%">	
								
									<table width="20%" border="0" cellspacing="0" cellpadding="0">
									<tbody>
										<tr> 
											<td width="50%" nowrap="nowrap" class="dataLabel">
												<fmt:message key="oaCalendarEventForm.title"/>:       	
											</td>
											<td>
												<input name="title" type="text" id="title">
											</td>
										</tr>
										
										<tr> 
											<td width="50%" nowrap="nowrap" class="dataLabel">
												<fmt:message key="oaCalendarEventForm.eventStateId"/>:       	
											</td>
											<td>
												<input name="eventStateId" type="text" id="eventStateId">
											</td>
										</tr>
										
										<tr> 
											<td width="50%" nowrap="nowrap" class="dataLabel">
												<fmt:message key="oaCalendarEventForm.content"/>:       	
											</td>
											<td>
												<textarea name="contentId" cols="18" rows="4" id="contentId"></textarea>
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
										  			<input type="button" id="Btn_save" value="<fmt:message key="button.save"/>">
										  			<input type="button" id="Btn_del" value="<fmt:message key="button.delete"/>">
										  			<input type="button" id="Btn_cancel" value="<fmt:message key="button.cancel"/>">
											      </div>
											 </td>
										 </tr>
								</table> 		
				</fieldset>
		
		</div>	
		
		<div style="display:none;">
			<input type="text" id="calendarEventId">
			<input name="type" type="text" id="type">
		</div>
	
		</td>
	</tr>
</table>

		<!--bodyTas  end-->    
</fieldset>

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
