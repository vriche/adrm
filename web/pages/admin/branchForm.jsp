<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="branchDetail.title"/></title>
<content tag="heading"><fmt:message key="branchDetail.heading"/></content>

<html:form action="saveBranch" method="post" styleId="branchForm" onsubmit="return validateBranchForm(this)">
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
		    <td nowrap="nowrap" aling="right" bgcolor="red">
		    	<fmt:message key="branchForm.name"/>:       	
	        </td>
	        <td  aling="left" valign="left">
		        <html:errors property="name"/>
		        <html:text property="name" styleId="name"/>
			</td>
		</tr>

  		<tr> 
		    <td nowrap="nowrap" class="dataLabel">
				<!--组织--!>
				<adrm_order:label styleClass="" key="branchForm.orgId"/>:       	
	        </td>
	        <td  aling="left">
	        	<div style="position:relative;">
				<span style="margin-left:100px;width:18px;overflow:hidden;">
			  	<adrm_order:selectList name="orgs" key="34"  toScope="page"/> 
				     <html:select property="orgId" styleId="orgId"  style="width:140px;margin-left:-100px"> 
				     	<html:option value=""/> 
				     	<html:options collection="orgs"  property="value" labelProperty="label"/> 
				     </html:select> 								
				</span>
				<html:errors property="orgId"/>
				</div> 	
			</td>
		</tr> 

      	<tr> 
		    <td nowrap="nowrap" class="dataLabel">
        		<!--部门表--!>
			   	<adrm_order:label styleClass="" key="branchForm.parentId"/>:       	
	        </td>
	        <td aling="left">		
				<div style="position:relative;display:none;">
				<span style="margin-left:100px;width:18px;overflow:hidden;">
				  	<adrm_order:selectList name="branchs" key="30"  toScope="page"/> 
				     <html:select property="parentId" styleId="ParentId" style="width:140px;margin-left:-100px"> 
				     <html:option value=""/> <html:options collection="branchs"  property="value" labelProperty="label"/> 
				     </html:select> 								
				</span>
				<html:errors property="parentId"/>
				</div>   	
			</td>
		</tr> 

		<tr> 
		    <td nowrap="nowrap" class="dataLabel">
		    	部门统计:   	
	        </td>
	        <td  aling="left">
		        <html:errors property="treeLevel"/>
		        <html:text property="treeLevel" styleId="treeLevel"/>
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
		
		        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('Branch')">
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
    Form.focusFirstElement($("branchForm"));
</script>

<html:javascript formName="branchForm" cdata="false" dynamicJavascript="false" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
