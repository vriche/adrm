<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="resourceChannelDetail.title"/></title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGridCell.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_drag.js'/>"></script>  
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_srnd.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_start.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_link.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_math.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_clist.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTreeGrid/dhtmlXGrid_excell_cntr.js'/>"></script>



<script type="text/javascript" src="<c:url value='/scripts/class/resourceSort.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceSortManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/resourceChannel.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceChannelManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/adres/channelConfigService.js'/>"></script>

<content tag="heading"><fmt:message key="resourceChannelDetail.heading"/></content>





<html:form action="saveResourceChannel" method="post" styleId="resourceChannelForm" onsubmit="return validateResourceChannelForm(this)">

<html:hidden property="id" styleId="id"/>
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
		    	<fmt:message key="resourceChannelForm.name"/>:       	
	        </td>
	        <td>
		        <html:errors property="name"/>
		        <html:text property="name" styleId="name"/>
			</td>
		</tr>
		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="resourceChannelForm.enable"/>:       	
	        </td>
	        <td>
		        <html:errors property="enable"/>
		        <html:checkbox property="activation" styleId="activation"/>
			</td>
		</tr>
		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="resourceChannelForm.value"/>:       	
	        </td>
	        <td>
		        <html:errors property="value"/>

		        <table><tr>  
		          
		        	<td>
						<html:select property="broTimeHour" styleId="broTimeHour" >
							<html:optionsCollection property="hourList"/>
						</html:select>		        	
		        	</td>
		        	  <td>ʱ</td>
		          
		        	<td>
						<html:select property="broTimeMin" styleId="broTimeMin" >
							<html:optionsCollection property="minList"/>
						</html:select>		        	
		        	</td>	
		        	  <td>��</td>	        	
		           
		        	<td>
						<html:select property="broTimeSec" styleId="broTimeSec" >
							<html:optionsCollection property="minList"/>
						</html:select>		        	
		        	</td>	
		        	 <td>��</td>
		         </tr></table>  
			</td>
		</tr>
		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="resourceChannelForm.memo"/>:       	
	        </td>
	        <td>
		        <html:errors property="memo"/>
		        <html:textarea  property="memo" styleId="memo" rows="3" style="width:100%" />
			</td>
		</tr>
		
		
			      <tr> 
		    <td nowrap="nowrap" class="dataLabel">
		    	<adrm_order:label key="carrierTypeForm.orgId"/>:

		        <html:errors property="orgId"/>  	       	
	        </td>
	        <td>
	
				<span style="margin-left:100px;width:18px;overflow:hidden;">
				  	<adrm_order:selectList name="orgs" key="34"  toScope="page"/> 
				     <html:select property="orgId" styleId="orgId"  style="width:160px;margin-left:-100px"> 
				    <html:options collection="orgs"  property="value" labelProperty="label"/> 
				     </html:select> 								
				</span>
		
		
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
			
			        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('ResourceChannel')">
			            <fmt:message key="button.delete"/>
			        </html:submit>
			
			        <html:cancel styleClass="" onclick="bCancel=true">
			            <fmt:message key="button.cancel"/>
			        </html:cancel>
			        
			        
			       
 			
			      </div>
			 </td>
		 </tr>
</table> 


 
 
 
  
  
  
  
  <table width="100%" border="0" cellspacing="0" cellpadding="0" id="dayangBeiboEnableParam_table">
		<tr>
		  	<td><div id="gridbox" width="100%" height="100%" align="left" style="background-color: white; overflow: hidden"></div> </td>
		 </tr>
		<tr>
		  	<td align="center"> <input type="button"   id="btn_bro_conf" value='������ŵ���������'>  </td>
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
    Form.focusFirstElement($("resourceChannelForm"));
</script>

<html:javascript formName="resourceChannelForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>



