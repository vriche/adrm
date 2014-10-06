var linkman = new LinkMan();
var org = new SysOrg();

callOnLoad(init);
 
function init(){
	
	setLinkManPara(linkman);	
	
	config_useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;	

	_make_org_select("orgIdCmd",143,"getLinkmanTable");
		
//	function callBackFun(){
//		
//		if(config_useMoreCarrierSortParam == 0 || $('orgIdCmd').options.length<2){
//				$('orgId_td').hide();
//		}	
//		
//
//		if( $('orgId').value*1>0) {
//			$("orgIdCmd").value= $('orgId').value;
//		}else{
//			 $('orgId').value = $("orgIdCmd").value;
//		}
//		
//			getLinkmanTable();
//	}

//	org.makeSelect(org.obj,"orgIdCmd","getLinkmanTable",callBackFun);	
	


//		if(config_useMoreCarrierSortParam == 0 || $('orgIdCmd').options.length<2){
//				$('orgId_td').hide();
//		}	
		

		if( $('orgId').value*1>0) {
			$("orgIdCmd").value= $('orgId').value;
		}else{
			 $('orgId').value = $("orgIdCmd").value;
		}
		
			getLinkmanTable();		
}





function setLinkManPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 
	 obj.className ="linkman";
	 obj.IdPrefix 	 = obj.className + "Id";
	 obj.fillObjName = obj.className + "Body";
	 obj.tableName   = "linkmanList";
	 obj.tBody 		 = $(obj.fillObjName);
	 obj.color1 	 = "BACKGROUND-COLOR: #white";
	 obj.color2 	 = "BACKGROUND-COLOR: #eee";
	 
	 obj.pageInfo 	 = "pageInfo_" + obj.className;
	 obj.pageSize 	 = "18";
	 obj.page        = new Page(obj.pageInfo,obj.pageSize);
}
function getLinkmanTable(){
//	linkman.reset();
	
	var func = function(objs){
		linkman.fillTableCS(objs); 
	}
	
	 $('orgId').value = $("orgIdCmd").value;
	linkman.obj.orgId = $("orgId").value;
	linkman.getLinkMans(linkman,func);
}
//∑≠“≥¥¶¿Ì
function goNextPage(pageIndex,pageInfoName){
	
	if(pageInfoName == linkman.pageInfo){
		var page = new Page(linkman.pageInfo,linkman.pageSize);
		page.goNextPage(pageIndex);
		linkman.page = page;
		getLinkmanTable();
	}
}

function editInfo(id){
	parent.location.href ="editLinkMan.html?id="+id +"&orgId=" +$("orgId").value;
}



