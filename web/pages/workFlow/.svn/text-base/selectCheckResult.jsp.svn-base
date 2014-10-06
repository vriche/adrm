<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title><fmt:message key="oaWorkFlowForm.checkResult"/></title>

<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar.js'/>"></script>

<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/theme.css'/>" />

<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/oaWorkFlowCheck.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/OaWorkFlowCheckManager.js'/>"></script>

<script>

var workFlowCheck = new OaWorkFlowCheck();
var mydate = new MyDate();

function init(){
	setWorkFlowCheckPara(workFlowCheck);
	
	var url = window.location.href;
	var startPos = url.indexOf("=");
	var endPos = url.length;

    var contractId = url.substring(startPos+1,endPos)*1;
    
	getResultInfo(contractId);
} 
function setWorkFlowCheckPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 obj.className  = "workFlowCheck";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.fillObjName = obj.className + "Body";
	 obj.tableName =  "workFlowCheckList";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.pageInfo 	= "pageInfo" + obj.className;
	 obj.pageSize 	= "4";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}

function getResultInfo(contractId){

	 var func = function(objs){
	 	workFlowCheck.fillTalbe(objs,workFlowCheck);
	 }
	workFlowCheck.getOaWorkFlowCheckByContractId(contractId,func);
}

function formatDate(date){
	var newDate = mydate.formatDate(date,"yyyy-MM-dd hh:mm:ss");

	return newDate;
}

</script>

</head>

<body onload="init()">

<table  id="orderList" class=ListShort width="100%" cellpadding="0" >
      <thead>
        <TR class=Header>
          <!--序号-->
          <TH><fmt:message key="oaWorkFlowCheckForm.id"/></TH>
          <TH><fmt:message key="oaWorkFlowCheckForm.checkUser"/></TH>
          <TH><fmt:message key="oaWorkFlowCheckForm.checkIdea"/></TH>
          <TH><fmt:message key="oaWorkFlowCheckForm.checkResult"/></TH>
          <TH><fmt:message key="oaWorkFlowCheckForm.createDate"/></TH>
          
          <!-- TH id="button_add_new_obj"  style="cursor:hand" colspan="3" onclick="button_add_new_obj(2)"> 
          		<img id="orderImgAdd" name="orderImgAdd"  src="image/CRM_ADD.GIF" border="0"> 
          </TH -->
          
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
          
      
      <tbody id="workFlowCheckBody"/>
      
      </thead>
      <tbody>
      <tr height="20"><td colspan="5">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  				 <tr>
		  				 	 <td colspan="2"><IMG src="image/s.gif"  width="100%" height="2">
		  				 	 </td>
		  				 </tr>
                        <tr  bgcolor="#D8DFE7">
                          <td align="right"> 
                              <div id="pageInfoworkFlowCheck"></div>
                          </td>
                     	</tr>
		  </table>
      </tr>
      </tbody>
				          
 </table>
				          
				     
</body>
</html>