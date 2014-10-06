<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/sysParam.jsp" %>

<script type="text/javascript" src="<c:url value='/scripts/class/order.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/user.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CustomerManager.js'/>"></script>

	<adrm_order:authorizeTag res="tag_distance_order">
		<c:redirect url="/selectPopup/orderIndex.html"/>
	</adrm_order:authorizeTag>
	
	<c:redirect url="/mainMenu.html"/>