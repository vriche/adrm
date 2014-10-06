//实例化对象
//var user = new User(); 

callOnLoad(init);	

function init(){	
		
		buttonEventFill(); 
		getCasPropertyTable();
		
}

function buttonEventFill(){
	var btn_btn_mody = $("btn_mody");
	btn_btn_mody.onclick = update;	
}

function getCasPropertyTable(){

	var CasPropertys = new Array();
	
	function getFun(strArray){
		CasPropertys = strArray;
		$("startup").checked  = CasPropertys[0] =="false"?0:1;
		$("ldap").checked  = CasPropertys[1] =="false"?0:1;
		
		$("casLoginUrl").value = CasPropertys[2];
		$("casLogoutUrl").value = CasPropertys[3];
		$("casServerName").value = CasPropertys[4];
		$("casServiceUrl").value = CasPropertys[5];
		$("casValidateUrl").value = CasPropertys[6];
	}
	
	CronTriggerRunnerManager.getParameter(getFun);
}

function update(){

	var startup = $("startup").checked;
	var ldap = $("ldap").checked;
	var casLoginUrl =  $("casLoginUrl").value;  //登录 URL
	var casLogoutUrl = $("casLogoutUrl").value;   //注销 URL
	var casServerName = $("casServerName").value;  //服务器名称
	var casServiceUrl = $("casServiceUrl").value;  //服务器 URL
	var casValidateUrl = $("casValidateUrl").value;  //验证 URL 

		 var func = function(){
				alert("设置成功");	
		 }
	CronTriggerRunnerManager.setParameter(startup,ldap,casLogoutUrl,casLoginUrl,casServiceUrl,casServerName,casValidateUrl,func);
	
 
}

	