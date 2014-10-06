<%@ include file="/common/taglibs.jsp"%>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/ajaxupload.css'/>" />
<script type="text/javascript" src="<c:url value='/dwr/interface/UploadMonitor.js'/>"></script>
<!-- script type="text/javascript" src="<c:url value='/dwr/interface/UploadAction.js'/>"></script -->
<script type="text/javascript" src="<c:url value='/scripts/admin/ajaxuploadService.js'/>"></script>

<title><fmt:message key="upload.title"/></title>
<content tag="heading"><fmt:message key="upload.heading"/></content>
<meta name="menu" content="FileUpload"/>

<!--
    The most important part is to declare your form's enctype to be "multipart/form-data",
    and to have a form:file element that maps to your ActionForm's FormFile property
-->

<html:form action="uploadFile" method="post" styleId="uploadForm" target="actionframe" 
    enctype="multipart/form-data" onsubmit="return validateUploadForm(this)">
<ul>
    <li class="info">
        <fmt:message key="upload.message"/>
    </li>
    <li>
        <adrm_order:label key="uploadForm.name" styleClass="desc"/>
        <html:text property="name" styleId="name" styleClass="text medium"/>
    </li>
    <li>
        <adrm_order:label key="uploadForm.file" styleClass="desc"/>
        <html:file property="file" styleClass="file medium" styleId="file" />
        
        <div id="progressBar" style="display: none;">
					<div id="theMeter">
						<div id="progressBarBox">
							<div id="progressBarBoxContent"></div>
						</div>
					</div>
		</div>
		
				
    </li>
    <li class="buttonBar">
        <html:submit styleClass="" styleId="save" onclick="bCancel=false">
            <fmt:message key="button.upload"/>
        </html:submit>
        <html:cancel styleClass="" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>




<input type="button" id="save" onClick="save_file()" value="save_file"/>

<iframe name="actionframe" id="actionframe" frameborder="0" width="100%" height="0"></iframe>

<script type="text/javascript">
    Form.focusFirstElement($('uploadForm'));
    highlightFormElements();
    
    function save_file(){
         alert(1);
       	 $('uploadForm').submit();
         startProgress('file','save');
    }
    
 
    
    
</script>


<html:javascript formName="uploadForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script>
