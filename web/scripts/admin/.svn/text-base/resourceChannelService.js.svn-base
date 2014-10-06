

var org = new SysOrg();
  
callOnLoad(init);	
   
function init(){	
	
 	config_username =  _app_params.user.username;
	useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
	
	 _make_org_select("orgId",120,"submit");	
	 
	 
			 if(useMoreCarrierSortParam == 0 || $('orgId').options.length<2){
					$('orgId_td').hide();
			}	 
	 
	 var orgId =  getParamFromUrl(window.location.href,"orgId");
	
	 
	  		if(orgId > 0){
	  			 $("orgId").value = orgId ;
	  		}else{
	  			submit();
	  		}	 
	  		
		
//	org.makeSelect(org.obj,"orgId","submit",callBackFun);	
}
  
function submit(){
  		$("resourceChannelForm").submit();
}

function callBackFun(){
	
			 if(useMoreCarrierSortParam == 0 || $('orgId').options.length<2){
					$('orgId_td').hide();
			}
			
	  		
	  		var orgId =  getParamFromUrl(window.location.href,"orgId");
	  		$("orgId").value = orgId ;
	  		
	  		if(orgId > 0){
	  			
	  		}else{
	  			submit();
	  		}


	}