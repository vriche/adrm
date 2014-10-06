<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaDocumentDetail.title"/></title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/ajaxupload.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/oaDocumentFile.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/oaDocument.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/oaDocumentCatalog.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/document/publishService.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/OaDocumentFileManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaDocumentManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaDocumentCatalogManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>

<!-- script type="text/javascript" src="<c:url value='/dwr/interface/UploadMonitor.js'/>"></script -->
<script type="text/javascript" src="<c:url value='/dwr/interface/UploadAction.js'/>"></script>
<!-- script type="text/javascript" src="<c:url value='/scripts/admin/ajaxuploadService.js'/>"></script -->

<content tag="heading"><fmt:message key="oaDocumentDetail.heading"/></content>
<meta name="menu" content="FileUpload"/>

				    
	<table width="100%" border="1" cellspacing="0" cellpadding="0">
        <TR class=Header>  
			<td width="20%" vAlign="top">
					<div id="oaDocumentCatalogTreebox" 
						 style="width:100%; 
						 height:500px;
						 background-color:#f5f5f5;
						 border :1px solid Silver;"/>											
			</td>
			<td vAlign="top">
				<fieldset style="width:97%" id="oaDocumentFileForm">
				
				<input type="hidden" id="documentId">
				
				<!--文档信息-->
				<span id="viewDocumentFileSchem" style="display:block;">
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
				</span>
				
				<!--文件信息-->
				<span id="viewDocumentFileSchem" style="display:block;">
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
	   		    </span>
	   		    
				<span id="viewDocumentFileSchem" style="display:block;">
						<fieldset style="width: 97%">
				            <legend></legend>
				            <input type="button" id="Btn_add_document" value="<fmt:message key="button.add"/>" name="add">
							<input type="button" id="Btn_save_document" value="<fmt:message key="button.save"/>" name="edit">
						</fieldset>
				</span>
				
				</fieldset>
		    </td>
        </TR>
	</table>

