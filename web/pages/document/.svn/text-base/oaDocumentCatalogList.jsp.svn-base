<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaDocumentCatalogList.title"/></title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>



<script type="text/javascript" src="<c:url value='/dwr/interface/OaDocumentCatalogManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaDocumentManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaDocumentFileManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaDocumentCatalogPermitTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/oaDocumentCatalog.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/oaDocument.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/oaDocumentFile.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/oaDocumentCatalogPermitType.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/address.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/document/documentCatalogService.js'/>"></script>

<content tag="heading"><fmt:message key="oaDocumentCatalogList.heading"/></content>


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
                    
                     <a id="Btn_addCatalogChild" class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
                       
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


<table width="100%" border="1">
  <tr>
	<td width="20%" vAlign="top">
			<div id="oaDocumentCatalogTreebox" 
				 style="width:100%; 
				 height:500px;
				 background-color:#f5f5f5;
				 border :1px solid Silver;"/>
				 								
	</td>
    <td vAlign="top">
    &nbsp;
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="11%" align="right"><font size="1.5" color="#000000"><fmt:message key="oaDocumentCatalogForm.name"/>:</font></td>
	            <td width="89%"><input type="text" name="documentCatelogName" id="documentCatelogName"></td>
			</tr>
		</table>	
    	&nbsp;
    	<hr>
    

						<table width="50%" border="0" cellpadding="0" cellspacing="0">
			              <tr>
			              	<td width="1%"></td>
			              	<td width="15%" align="left">
			              				<div id="userTreebox" 
										 style="width:50%; 
										 height:250px;
										 background-color:#CCCCCC;
										 border :1px solid Silver;"/>
							 </td>		
			              </tr>
			            </table>			      

    	<hr>
				<table width="50%" border="0" id="oaDocumentCatalogPermitTypeTable">
					<tr>
					<td width="1%"></td>
						<td>
											<span id="userPermitType"/>
						</td>
					</tr>
				</table>	
    	&nbsp;
    	<hr>
				
		<table width="50%" border="0">
			<tr>
			<td width="1%"></td>
				<td>
		
							<input type="button" id="Btn_save_catalog" value="<fmt:message key="button.save"/>">
							<input type="button" id="Btn_delete_catalog" value="<fmt:message key="button.delete"/>">

				</td>
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