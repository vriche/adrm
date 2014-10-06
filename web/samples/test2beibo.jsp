<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/sysParam.jsp" %>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>	
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/date.js'/>"></script>

<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/UpdateSystemManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/PublishArrangeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ContractPaymentManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/WorkspanManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/DateUtil.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/MatterManager.js'/>"></script>

<html>
<head>

<script>


  callOnLoad(init);	
  
   function init(){
 	   buttonEventFill();
 	}
   
    function saveMattersAllindayang2zero(){
   			var callBack=function(){
   				$("btn_saveMatterAll2dayang").disabled=false;
   				alert("结束");
   			}
   			$("btn_saveMatterAll2dayang").disabled=true;
   			MatterManager.saveMattersAllindayang2zero(callBack);
   				
   }  
   
   
       function saveMattersAll2dayang2(){
   			var callBack=function(){
   				$("btn_saveMatterAll2dayang2").disabled=false;
   				alert("结束");
   			}
   			$("btn_saveMatterAll2dayang2").disabled=true;
   			var total = $("total").value;
   			var ansy = $("ansy").value;
   			MatterManager.saveMattersAll2dayang2_test(total,ansy,callBack);
   				
   }   
   
   
   

 
 
  function buttonEventFill(){
  
  	var btn_1 = $("btn_saveMatterAll2dayang");
	btn_1.setAttribute("href","javascript:void 0");
	btn_1.onclick = saveMattersAllindayang2zero;	
	
	var btn_modifyPwd = $("btn_saveMatterAll2dayang2");
	btn_modifyPwd.setAttribute("href","javascript:void 0");
	btn_modifyPwd.onclick = saveMattersAll2dayang2;	
  }
  
</script>

</head>
<title>测试保存素材到备播</title>

<body>



<input id="btn_saveMatterAll2dayang" type="button" value="重置本地已保存到大洋素材" onclick="javascript:saveMattersAllindayang2zero()">
<br>
<fieldset> 
<table>
<tr>
<td>条数：</td>
<td><input id="total" type="text" value="1000"></td>
<td>
     <select id="ansy"  style="CURSOR: pointer;">
			<option value="1">异步1</option>
			<option value="2">同步2</option>		        
	</select>

</td>
<td><input id="btn_saveMatterAll2dayang2" type="button" value="开始"></td>
</tr>
</fieldset>	



					 

</body>
</html>











