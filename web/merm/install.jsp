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
<script type="text/javascript" src="<c:url value='/dwr/interface/BrandManager.js'/>"></script>
<html>
<head>

<script>
   function initdb(){
   		if(confirm("���Ҫ��ʼ����Ŀ���ݱ�ô��"))
   			UpdateSystemManager.excuteSqlMermDB();
   }
   function initdistance(){
   		if(confirm("���Ҫ��ʼ��Զ��ǩ��ô��"))
   			UpdateSystemManager.excuteSqlDistanceDB();
   }
   function clearData(){
   		if(confirm("���Ҫ���ҵ������ô��"))
   			UpdateSystemManager.excuteSqlClearDataDB();
   }
   function clearDataOrder(){
   		if(confirm("���Ҫ��ն�������ô��"))
   			UpdateSystemManager.excuteSqlClearDataDBorder();
   }

   function transferData(){
   			var datestr=prompt("��ѡ��ת�ƶ�������ǰ�ıಥ����:Ĭ��Ϊ60\nע:���[ȡ��]��ת������","60");
   			if(datestr==null) return false;
   			$("btn_transferdata").disabled=true;
   			UpdateSystemManager.excuteSqlTransferDataDB();
   			getServiceDate(datestr);
   			var callBack=function(){$("btn_transferdata").disabled=false;}
   			PublishArrangeManager.moveArrangeAndDetailsToBak($("config_serviceDate").value,callBack);
   				
   }
   
   
 function xmbalance(){
   			var callBack=function(){
   			$("btn_xmbalance").disabled=false;
   			alert("����");
   			}
   			ContractPaymentManager.testXMTV(callBack);
   				
   }
   
   
    function resetAllSpecByOrderDayInfo(){
   			var callBack=function(){
   			$("btn_ resetAllSpec").disabled=false;
   			alert("����");
   			}
   			WorkspanManager.resetAllSpecByOrderDayInfo(callBack);
   				
   }
  
   function saveResourceFromOtherYear(sourceYear, tagYear){
     		var sourceYear = prompt("��ѡ��ת����Դ","2013");
     		var tagYear = prompt("��ѡ��ת����Դ","2014");
     		
   			if(sourceYear==null||sourceYear=="") return false;
   			if(tagYear==null || tagYear=="") return false;
   			

   			var callBack=function(){
   				$("btn_saveResource").disabled=false;
   				alert("����");
   			}
   			$("btn_saveResource").disabled=true;
   			ResourceManager.saveResourceFromOtherYear(sourceYear,tagYear,callBack);
   				
   }
   
     function cearOrderByYear(){
     		var tagYear = prompt("������Ҫ��������","2008");
   			if(tagYear==null || tagYear=="") return false;
   			
   			if(confirm("���Ҫ���"+ tagYear +"��������ô��")){
	   			var callBack=function(){
	   				$("btn_clearOrderByYear").disabled=false;
	   				alert("����");
	   			}
	   			$("btn_clearOrderByYear").disabled=true;
	   			UpdateSystemManager.clearOrderByYear(tagYear,callBack);   			
   			}
   				
   } 
   
   
   
   
      function saveBrandHelpCode(){
    
   
   			var callBack=function(){
   				$("btn_saveBrandHelpCode").disabled=false;
   				alert("����");
   			}
   			$("btn_saveBrandHelpCode").disabled=true;
   			BrandManager.saveBrandHelpCode();
   				
   }
   
   
    function saveMattersAllindayang2zero(){
   			var callBack=function(){
   				$("btn_saveMatterAll2dayang").disabled=false;
   				alert("����");
   			}
   			$("btn_saveMatterAll2dayang").disabled=true;
   			MatterManager.saveMattersAllindayang2zero();
   				
   }  
   
   
       function saveMattersAll2dayang2(){
   			var callBack=function(){
   				$("btn_saveMatterAll2dayang2").disabled=false;
   				alert("����");
   			}
   			$("btn_saveMatterAll2dayang2").disabled=true;
   			MatterManager.saveMattersAll2dayang2_test();
   				
   }   
       
       
      function saveDayinfoByWorkspan(){

  			var tagYear = prompt("������Ҫ���","2008");
   			if(tagYear==null || tagYear=="") return false;
   			
   			if(confirm("���Ҫ����"+ tagYear +"����ô��")){
	   			var callBack=function(){
	   				$("btn_saveDayinfoByWorkspan").disabled=false;
	   				alert("����");
	   			}
	   			$("btn_saveDayinfoByWorkspan").disabled=true;
	   			WorkspanManager.saveDayinfoByWorkspan(tagYear,callBack);   			
   			}			

  }     
       
       
   
   
   
   function getServiceDate(datestr){
 	var fuc = function(d){
 		$("config_serviceDate").value = d;
 	}
 	DWREngine.setAsync(false);
 	DateUtil.getSelectedDate(-datestr,fuc);
 	DWREngine.setAsync(true);
 }
</script>

</head>
<title>����</title>

<body>
<input id="btn_initdb" type="button" value="��ʼ����Ŀ���ݱ�" onclick="javascript:initdb()">
<input id="btn_initdistance" type="button" value="��ʼ��Զ��ǩ��" onclick="javascript:initdistance()">
<input id="btn_cleardata" type="button" value="�����������" onclick="javascript:clearData()">
<input id="btn_cleardataOrder" type="button" value="��ն�������" onclick="javascript:clearDataOrder()">
<input id="btn_transferdata" type="button" value="ת��60��ǰ�ıಥ����" onclick="javascript:transferData()">
<input id="btn_xmbalance" type="button" value="���ŷ��䵽��" onclick="javascript:xmbalance()">
<input id="btn_ resetAllSpec" type="button" value="У�Թ��ʱ��" onclick="javascript:resetAllSpecByOrderDayInfo()">
<input id="btn_saveResource" type="button" value="��λ����" onclick="javascript:saveResourceFromOtherYear('2012','2013')">



<input id="btn_saveMatterAll2dayang" type="button" value="���ñ��浽�����ز�" onclick="javascript:saveMattersAllindayang2zero()">

<input id="btn_saveMatterAll2dayang2" type="button" value="���浽�����ز�����11" onclick="javascript:saveMattersAll2dayang2()">

<input id="btn_saveBrandHelpCode" type="button" value="��ʼ��Ʒ��������" onclick="javascript:saveBrandHelpCode()">

<input id="btn_clearOrderByYear" type="button" value="���ĳһ��Ķ���" onclick="javascript:cearOrderByYear()">

<input id="btn_saveDayinfoByWorkspan" type="button" value="���ݶ�λ������������Ϣ" onclick="javascript:saveDayinfoByWorkspan()">



</body>
</html>











