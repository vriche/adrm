  
  
//实例化对象
 var payment = new PayMent();
 
 var target = new Target()
 
 callOnLoad(init);	
 function init(){
 	setPayMentPara(payment); 	//设置常量
 	setTargetPara(target);
 	
	getPayMentTable(payment); //获得表
	getTargetTable(target);
}

//设置常量
function setPayMentPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 
	 obj.className = "payment";
	 obj.IdPrefix 	= obj.className + "Id";
	 
	 obj.fillObjName = obj.className + "Body";
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.tBody 		= $(obj.fillObjName);
	 
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "4";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
	 obj.incomePurpose = new IncomePurpose();
}


function setTargetPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className = "target";	
	 obj.IdPrefix 	= obj.className + "Id";
	 
	 obj.fillObjName = obj.className + "Body";
	 obj.color1 	 = "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 	 = "BACKGROUND-COLOR: #ECEFF4";
	 obj.tBody 		 = $(obj.fillObjName);
	 
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "4";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
	 obj.carrier = new Carrier();
	 obj.industry = new Industry();

}


//动作填充 
function button_add_new_obj(type){
	
	if(type == 0){
		payment.addNewRow('new',null);
	}
	if(type == 1){
		target.addNewRow('new',null);
	}
}
//翻页处理
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == payment.pageInfo){
		var page = new Page(payment.pageInfo,payment.pageSize);
		page.goNextPage(pageIndex);
		payment.page = page;
		getPayMentTable(payment);
	}
	
	if(pageInfoName == target.pageInfo){
		var page = new Page(target.pageInfo,target.pageSize);
		page.goNextPage(pageIndex);
		target.page = page;
		getTargetTable(target);
	}
}

//获得列表
function getPayMentTable(payment){
	payment.obj.contractId = $("contractId").value;
	payment.getContractPayments();  
}

function getTargetTable(target){
	target.obj.contractId = $("contractId").value;
	target.getTargets();  
}


