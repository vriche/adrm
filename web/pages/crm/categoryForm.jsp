<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="customerCategoryDetail.title"/></title>
<content tag="heading"><fmt:message key="customerCategoryDetail.heading"/></content>

<html:form action="saveCategory" method="post" styleId="customerCategoryForm" onsubmit="return validateCategoryForm(this)">
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
	    	<!-- 类别名称 -->
		    <td nowrap="nowrap" class="requiredInput">
		    	<fmt:message key="customerCategoryForm.categoryName"/>:	
	        </td>
	        <td>
		        <html:errors property="categoryName"/>
		        <html:text property="categoryName" styleId="categoryName"/>
			</td>
		</tr>

	    <tr> 
	    	<!-- 显示序号 -->
		    <td nowrap="nowrap" class="requiredInput">
		    	<fmt:message key="customerCategoryForm.displayNo"/>:
	        </td>
	        <td>
		        <html:errors property="displayNo"/>
		        <html:text property="displayNo" styleId="displayNo"/>

			</td>
		</tr>
		
		<tr> 
			<!-- 类别编号 -->
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="customerCategoryForm.categoryCode"/>:       	
	        </td>
	        <td>
		        <html:errors property="categoryCode"/>
		        <html:text property="categoryCode" styleId="categoryCode"/>
			</td>
		</tr>
		
	    <!-- tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="customerCategoryForm.adResourcePriceType"/>:       	
	        </td>
	        <td>
		        <html:errors property="adResourcePriceType"/>
		        <html:text property="adResourcePriceType" styleId="adResourcePriceType"/>
			</td>
		</tr -->
	    <tr> 
	    	<!-- 备注 -->
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="customerCategoryForm.memo"/>:       	
	        </td>
	        <td>
		        <html:errors property="memo"/>
		        <html:text property="memo" styleId="memo"/>

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
		
		        <html:submit styleClass="" property="method.delete" onclick="bCancel=true; return confirmDelete('Category')">
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
    Form.focusFirstElement($("categoryForm"));
</script>

<html:javascript formName="categoryForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
