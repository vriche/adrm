<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaAreaCityDetail.title"/></title>
<content tag="heading"><fmt:message key="oaAreaCityDetail.heading"/></content>

<html:form action="saveOaAreaCity" method="post" styleId="oaAreaCityForm" onsubmit="return validateOaAreaCityForm(this)">
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

<html:hidden property="id"/>

   <li>
   
   
		<!--³ÇÊÐÃû³Æ--!>	
		<!--div style="position:relative;">
		<adrm_order:label styleClass="" key="oaAreaCityForm.name"/>
			<span style="margin-left:100px;width:18px;overflow:hidden;">
			  	<adrm_order:selectList name="areaCitys" key="27"  toScope="page"/> 
			     <html:select property="name" styleId="areaCityId"  style="width:140px;margin-left:-100px"> 
			     <html:option value=""/> <html:options collection="areaCitys"  property="value" labelProperty="label"/> 
			     </html:select> 								
			</span>
			
		</div-->   
		
		
		
		 <fmt:message key="oaAreaCityForm.name"/>:
		 <html:errors property="name"/>
		 <html:text property="name" styleId="name"/>
		 

    </li>
    

		 
    <li>
        <adrm_order:label styleClass="code" key="oaAreaCityForm.code"/>
        <html:errors property="code"/>
        <html:text property="code" styleId="code" styleClass="text medium"/>
    </li>		 
		 

<html:hidden property="version"/>

    <li class="buttonBar bottom">
        <html:submit styleClass="" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('OaAreaCity')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
    
    
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
    Form.focusFirstElement($("oaAreaCityForm"));
</script>

<html:javascript formName="oaAreaCityForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
