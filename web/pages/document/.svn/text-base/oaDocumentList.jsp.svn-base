<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaDocumentList.title"/></title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/ajaxupload.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/OaDocumentFileManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaDocumentManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaDocumentCatalogManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/oaDocumentFile.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/oaDocument.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/oaDocumentCatalog.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>

<!-- script type="text/javascript" src="<c:url value='/dwr/interface/UploadMonitor.js'/>"></script -->
<script type="text/javascript" src="<c:url value='/dwr/interface/UploadAction.js'/>"></script>
<!-- script type="text/javascript" src="<c:url value='/scripts/admin/ajaxuploadService.js'/>"></script -->

<script type="text/javascript" src="<c:url value='/scripts/document/documentService.js'/>"></script>

<content tag="heading"><fmt:message key="oaDocumentList.heading"/></content>

<html:form action="uploadFile" method="post" styleId="uploadForm" target="actionframe" 
    enctype="multipart/form-data">


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



<table width="100%" >

  <tr>
  
	<td width="20%" vAlign="top">
		<table width="100%">
		  <tr> 
		    <td> <div id="oaDocumentCatalogTreebox" 
				 style="width:100%; 
				 height:500px;
				 background-color:#f5f5f5;
				 border :1px solid Silver;"/>
			</td>
		  </tr>
		</table>											
	</td>
	
    <td align="top" valign="top">
					
	 <fieldset style="width: 97%" id="oaDocumentList"> 
           <legend></legend>
           <table width="100%" border="1" cellpadding="0" cellspacing="0">
           
		        <tr> 
		          <td width="30%"> 	
			<table  id="oaDocumentTable" class=ListShort width="100%" cellpadding="0" >
			
              <thead>
                <TR class=Header>  
                  <!--标题-->
                  <TH><fmt:message key="oaDocumentForm.title"/></TH>
                  <!--文档编号-->
                  <TH><fmt:message key="oaDocumentForm.documentCode"/></TH>
                  <!--备注-->
                  <TH><fmt:message key="oaDocumentForm.memo"/></TH>
                  
                                   
                  <TH id="addNewDocument" colspan="2"> 
                  		<img src="image/CRM_ADD.GIF" border="0"> 
                  </TH>
                </TR>
                
                <tr > 
                  	<td colspan="5">
	                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                      <tr> 
	                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
	                      </tr>
	                    </table>
                	</td>
                </tr>
              </thead>
              
              <tbody id="oaDocumentBody"/> 
		
	          <tbody>
	          <tr height="20"><td colspan="5">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  				 <tr>
		  				 	 <td colspan="2"><IMG src="image/s.gif"  width="100%" height="2">
		  				 	 </td>
		  				 </tr>
                        <tr  bgcolor="#D8DFE7">
                          <td align="right"> 
                              <div id="oaDocumentPageInfo"></div>
                          </td>
                     	</tr>   	
				  </table>
	          </tr>
	          </tbody>
     </table>
     
           </td>
        </tr>
	</table>      
	 </fieldset>	
			
	<fieldset style="width:97%" id="oaDocumentForm">
			
			<input type="hidden" id="documentId">
			
				<!--文档信息-->
					<fieldset style="width: 97%">
			              <legend><fmt:message key="resourceForm.title.baseInfo"/></legend>	
				          <table width="30%">
				          	<!--标题-->
					        <tr> 
					          <td><fmt:message key="oaDocumentForm.title"/></td>
					          <td><input name="text" type="text" id="title"></td>
					        </tr>
					        <!--文档编号-->
				          	<tr>
					          <td><fmt:message key="oaDocumentForm.documentCode"/></td>
					          <td><input name="text" type="text" id="documentCode"></td>
				          	</tr>
				          	<!--备注-->
				          	<tr>
					          <td><fmt:message key="oaDocumentForm.memo"/></td>
					          <td><input name="text" type="text" id="memo"></td>					          	
				          	</tr>
				          </table>
					</fieldset>	
				
				<!--文件信息-->
					<fieldset style="width: 97%"> 
			           <legend><fmt:message key="oaDocumentForm.documentFileId"/></legend>	
			             	
					<table  id="oaDocumentFileTable" class=ListShort width="100%" cellpadding="0" >
		              <thead>
			              <tr class=Header>
			                  <!--文件名-->
			                  <TH><fmt:message key="oaDocumentFileForm.fileName"/></TH>
			                  <TH></TH>  
			                  <TH id="button_add_new_obj"  style="cursor:hand" colspan="2" onclick="button_add_new_obj(1)"> 
			                  		<img id="oaDocumentFileImgAdd" name="oaDocumentFileImgAdd"  src="image/CRM_ADD.GIF" border="0"> 
			                  </TH>	
			                  
			                  
		                  </tr>
		                  <tr > 
			                  <td colspan="10">
				                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
				                      <tr> 
				                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
				                      </tr>
				                    </table>
			                    </td>
			              </tr>
		                
		              	  <tbody id="oaDocumentFileBody"/>
		              
		              </thead>
				    </table>
	
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
			  				    <tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
		                        <tr  bgcolor="#D8DFE7">
		                          <td align="right">
		                              <div id="pageInfo_oaDocumentFile"></div>
		                          </td>
			                    </tr>
			    	</table>
			    </fieldset>
			    
					<fieldset style="width: 97%">
			            <legend></legend>
			            <input type="button" id="Btn_add_document" value="<fmt:message key="button.add"/>" name="add">
						<input type="button" id="Btn_save_document" value="<fmt:message key="button.save"/>" name="edit">
						<input type="button" id="Btn_cancel_Edit" value="<fmt:message key="button.cancel"/>" name="">
						<!-- input type="button" id="Btn_delete" value="<fmt:message key="button.delete"/>" name="" -->
					</fieldset>
				
		</fieldset>
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

<iframe name="actionframe" id="actionframe" frameborder="0" width="100%" height="0"></iframe>

<script type="text/javascript">
    Form.focusFirstElement($('uploadForm'));
    highlightFormElements();

</script>


<html:javascript formName="uploadForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script>
