<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaDocumentFileDetail.title"/></title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/oaDocumentFile.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/oaDocument.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/category.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/document/publishService.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/OaDocumentFileManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaDocumentManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaDocumentCatalogManager.js'/>"></script>

<content tag="heading"><fmt:message key="oaDocumentFileDetail.heading"/></content>


	<table width="100%" border="1">
        <TR class=Header>  
			<td width="20%" vAlign="top">
					<div id="categoryTreebox" 
						 style="width:100%; 
						 height:500px;
						 background-color:#f5f5f5;
						 border :1px solid Silver;"/>											
			</td>
			<td vAlign="top">
				<fieldset style="width:97%" id="oaDocumentFileForm">
				<html:form action="saveOaDocumentFile" method="post" styleId="oaDocumentFileForm" onsubmit="return validateOaDocumentFileForm(this)">
				
				
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
				                  <!--文档编号-->
				                  <!--TH><fmt:message key="oaDocumentForm.documentCode"/></TH-->
				                  <!--备注-->
				                  <!--TH><fmt:message key="oaDocumentForm.memo"/></TH-->
		                  	
		                                   
				                  <TH id="button_add_new_obj"  style="cursor:hand" colspan="2" onclick="button_add_new_obj(0)"> 
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
							<input type="button" id="Btn_save_catalog" value="<fmt:message key="button.save"/>">
							<input type="button" id="Btn_delete_catalog" value="<fmt:message key="button.delete"/>">
						</fieldset>	
				</span>
	   		    
				</html:form>
				</fieldset>
		    </td>	                  
        </TR>       
	</table>  