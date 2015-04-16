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
   		if(confirm("真的要初始化节目数据表么？"))
   			UpdateSystemManager.excuteSqlMermDB();
   }
   function initdistance(){
   		if(confirm("真的要初始化远程签单么？"))
   			UpdateSystemManager.excuteSqlDistanceDB();
   }
   function clearData(){
   		if(confirm("真的要清空业务数据么？"))
   			UpdateSystemManager.excuteSqlClearDataDB();
   }
   function clearDataOrder(){
   		if(confirm("真的要清空订单数据么？"))
   			UpdateSystemManager.excuteSqlClearDataDBorder();
   }

   function transferData(){
   			var datestr=prompt("请选择转移多少天以前的编播数据:默认为60\n注:点击[取消]不转移数据","60");
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
   			alert("结束");
   			}
   			ContractPaymentManager.testXMTV(callBack);
   				
   }
   
   
    function resetAllSpecByOrderDayInfo(){
   			var callBack=function(){
   			$("btn_ resetAllSpec").disabled=false;
   			alert("结束");
   			}
   			WorkspanManager.resetAllSpecByOrderDayInfo(callBack);
   				
   }
  
   function saveResourceFromOtherYear(sourceYear, tagYear){
     		var sourceYear = prompt("请选择转数据源","2013");
     		var tagYear = prompt("请选择转数据源","2014");
     		
   			if(sourceYear==null||sourceYear=="") return false;
   			if(tagYear==null || tagYear=="") return false;
   			

   			var callBack=function(){
   				$("btn_saveResource").disabled=false;
   				alert("结束");
   			}
   			$("btn_saveResource").disabled=true;
   			ResourceManager.saveResourceFromOtherYear(sourceYear,tagYear,callBack);
   				
   }
   
     function cearOrderByYear(){
     		var tagYear = prompt("请输入要清除的年份","2008");
   			if(tagYear==null || tagYear=="") return false;
   			
   			if(confirm("真的要清空"+ tagYear +"订单数据么？")){
	   			var callBack=function(){
	   				$("btn_clearOrderByYear").disabled=false;
	   				alert("结束");
	   			}
	   			$("btn_clearOrderByYear").disabled=true;
	   			UpdateSystemManager.clearOrderByYear(tagYear,callBack);   			
   			}
   				
   } 
   
   
   
   
      function saveBrandHelpCode(){
    
   
   			var callBack=function(){
   				$("btn_saveBrandHelpCode").disabled=false;
   				alert("结束");
   			}
   			$("btn_saveBrandHelpCode").disabled=true;
   			BrandManager.saveBrandHelpCode();
   				
   }
   
   
    function saveMattersAllindayang2zero(){
   			var callBack=function(){
   				$("btn_saveMatterAll2dayang").disabled=false;
   				alert("结束");
   			}
   			$("btn_saveMatterAll2dayang").disabled=true;
   			MatterManager.saveMattersAllindayang2zero();
   				
   }  
   
   
       function saveMattersAll2dayang2(){
   			var callBack=function(){
   				$("btn_saveMatterAll2dayang2").disabled=false;
   				alert("结束");
   			}
   			$("btn_saveMatterAll2dayang2").disabled=true;
   			MatterManager.saveMattersAll2dayang2_test();
   				
   }   
       
       
      function saveDayinfoByWorkspan(){

  			var tagYear = prompt("请输入要年份","2008");
   			if(tagYear==null || tagYear=="") return false;
   			
   			if(confirm("真的要处理"+ tagYear +"数据么？")){
	   			var callBack=function(){
	   				$("btn_saveDayinfoByWorkspan").disabled=false;
	   				alert("结束");
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
<title>管理</title>

<body>
<input id="btn_initdb" type="button" value="初始化节目数据表" onclick="javascript:initdb()">
<input id="btn_initdistance" type="button" value="初始化远程签单" onclick="javascript:initdistance()">
<input id="btn_cleardata" type="button" value="清空所有数据" onclick="javascript:clearData()">
<input id="btn_cleardataOrder" type="button" value="清空订单数据" onclick="javascript:clearDataOrder()">
<input id="btn_transferdata" type="button" value="转移60日前的编播数据" onclick="javascript:transferData()">
<input id="btn_xmbalance" type="button" value="厦门分配到款" onclick="javascript:xmbalance()">
<input id="btn_ resetAllSpec" type="button" value="校对广告时间" onclick="javascript:resetAllSpecByOrderDayInfo()">
<input id="btn_saveResource" type="button" value="段位复制" onclick="javascript:saveResourceFromOtherYear('2012','2013')">



<input id="btn_saveMatterAll2dayang" type="button" value="重置保存到大洋素材" onclick="javascript:saveMattersAllindayang2zero()">

<input id="btn_saveMatterAll2dayang2" type="button" value="保存到大洋素材所有11" onclick="javascript:saveMattersAll2dayang2()">

<input id="btn_saveBrandHelpCode" type="button" value="初始化品牌助记码" onclick="javascript:saveBrandHelpCode()">

<input id="btn_clearOrderByYear" type="button" value="清空某一年的订单" onclick="javascript:cearOrderByYear()">

<input id="btn_saveDayinfoByWorkspan" type="button" value="根据段位批量保存日信息" onclick="javascript:saveDayinfoByWorkspan()">



</body>
</html>











