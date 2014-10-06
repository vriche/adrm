

var org = new SysOrg();
  
callOnLoad(init);	
   
function init(){	
 	config_username =  _app_params.user.username;
	useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;	
	 ctxPath =  _app_params.ctxPath;	 	
	
	 _make_org_select("orgId",100,"submit");	   
	 	


	 $("version").onchange = submit;
	 $("btn_add").onclick = function(){
	 	window.location.href = ctxPath + "editResourceType.html?version="+$("version").value +"&orgId="+$("orgId").value;
	 };
	 
	
	
	 callBackFun();
	 

//	if(useMoreCarrierSortParam == 1 && config_username =='admin'){
//		org.makeSelect(org.obj,"orgId","submit",callBackFun);	
//	}

	
	
}
  
function submit(){
  		$("resourceTypeForm").submit();
}

function callBackFun(){
	
	
		    
	  		
	  		var orgId =  getParamFromUrl(window.location.href,"orgId");
	  		$("orgId").value = orgId ;
	  		
	  		 var version =  getParamFromUrl(window.location.href,"version");

	  		if(version >0){
	  			$("version").value = version ;
	  		}else{
	  			$("version").value =  _app_params.serviceDate.year; 
	  		}

	  		
	  		if(orgId > 0){
	  			("orgId").value = orgId ;
	  		}else{
	  			submit();
	  		}
	  		
//	  		
//	  		if(useMoreCarrierSortParam == 0|| $('orgId').options.length<2){
//				$('orgId_td').hide();
//		    }


	}