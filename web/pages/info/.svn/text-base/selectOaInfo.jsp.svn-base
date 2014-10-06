<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title><fmt:message key="oaInfoForm.content"/></title>

<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/oaInfo.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/OaInfoManager.js'/>"></script>

</head>
<script>
var oaInfo = new OaInfo();
    callOnLoad(init);	
	function init(){
		oaInfo.reset();
		oaInfo.obj.id = getOaInfoIdByURL();
		var func = function(obj){
			$("oaInfoContent").value = obj.content;
		}
		oaInfo.getOaInfo(oaInfo.obj,func);
	}
	
	function getOaInfoIdByURL(){
		var url = window.location.href;
		var startPos = url.indexOf("=");
		var oaInfoId = null;
		oaInfoId = url.substring(startPos+1,url.length)*1;
		return  oaInfoId;
	}
</script>
<body>
<table class=ListShort width="100%"  cellspacing="0" cellpadding="0">
	           <thead>
	                <TR class=Header> 
	                  <TH><fmt:message key="oaInfoForm.content"/></TH>
	                </TR>
			        <tr> 
			            <td align="center"> 
			               	<textarea  cols="69" rows="18" id="oaInfoContent" ></textarea>
			            </td>
		            </tr>
	            </thead>
		</table>  
</body>
</html>