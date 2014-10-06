<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script type="text/javascript" src="<c:url value='/scripts/common/popupWindow.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>
<meta name="menu" content="OrgMenu"/>
<script>
       var popupcenter = new Popupcenter();
       callOnLoad(init);
       callOnFocus(closePopup);
        
     function init(){
		var src = "selectPopup/updatePassword.html";
		popupcenter.url = src;
		popupcenter.model = 4;
		popupcenter.popupcenter(popupcenter);
     }
	
	function closePopup(){
		popupcenter.closePopup(popupcenter);
		window.location.href="mainMenu.html";
	}
</script>

</head>

<body>
</body>
</html>
