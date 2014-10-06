

var org = new SysOrg();
  
callOnLoad(init);	
   
function init(){	

	
	config_useMoreCarrierSortParam =  _app_params.sysParam.useMoreCarrierSortParam;
	
	loginUserName =  _app_params.user.username;
	loginUserId =  _app_params.user.id;
	
	org.makeSelect(org.obj,"orgId","submit",callBackFun);	

}
  
  	function submit(){
//  		orgId =  $("orgId").value;
  		$("carrierTypeForm").submit();
  		
  		
//  		$("orgIdbak").value = $("orgId").value;
  	
//		window.location.href = "carrierTypes.html?orgId="+orgId;
	}
	  	function callBackFun(){
	  		
	  		var orgId =  getParamFromUrl(window.location.href,"orgId");
	  		$("orgId").value = orgId ;
	  		
	  		if(config_useMoreCarrierSortParam == 0|| $('orgId').options.length<2){
				$('orgId_td').hide();
		    }
		
	  		
	  		if(orgId > 0){
	  			
	  		}else{
	  			submit();
	  		}
	  		
//	  		if(orgId > 0){
//	  			$("orgId").value = orgId ;
//	  		}else{
//	  			
//	  		}
	  		
//	  		if($("orgIdbak").value > 0){
//	  			$("orgId").value = $("orgIdbak").value ;
//	  		}else{
//	  			 $("orgIdbak").value = $("orgId").value;
//	  		}
//  		orgId =  $("orgId").value;

	}