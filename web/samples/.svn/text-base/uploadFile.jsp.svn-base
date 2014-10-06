<%@ include file="/common/taglibs.jsp"%>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/ajaxupload.css'/>" />
<script type="text/javascript" src="<c:url value='/dwr/interface/UploadMonitor.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/admin/ajaxuploadService.js'/>"></script>


<title><fmt:message key="sysResourceList.title"/></title>

<html:form action="selectFile" enctype="multipart/form-data" method="POST" 
		   onsubmit="startProgress('imageFile','save')" >
		   
		   <input type="hidden" name="method" value="save"/>
		   

		   <input type="file" id="imageFile" name="imageFile">
				<div id="progressBar" style="display: none;">
					<div id="theMeter">
						<div id="progressBarBox">
							<div id="progressBarBoxContent"></div>
						</div>
					</div>
				</div>
				
				
				<html:textarea property="descn" rows="10" cols="40"/>
				
	</div>
</html:form>