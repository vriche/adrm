  

//实例化对象
 var orderdetail = new OrderDetail;
  
 callOnLoad(init);	
 function init(){
 	setOrderDetailPara(orderdetail); 	//设置常量
	getOrderDetailTable(orderdetail); //获得表

}

//设置常量
function setOrderDetailPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className  = "orderdetail";	
	 obj.IdPrefix 	= obj.className + "Id";
	 
	 obj.fillObjName= obj.className + "Body";
	 obj.color1 	= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 	= "BACKGROUND-COLOR: #ECEFF4";
	 
	 obj.tBody 		= $(obj.fillObjName);
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "4";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);

}


//动作填充 
function button_add_new_obj(type){

	if(type == 0){
		orderdetail.addNewRow('new',null);
	}
}

//翻页处理
function goNextPage(pageIndex,pageInfoName){
	
	if(pageInfoName == orderdetail.pageInfo){
		var page = new Page(orderdetail.pageInfo,orderdetail.pageSize);
		page.goNextPage(pageIndex);
		orderdetail.page = page;
		getOrderDetailTable(orderdetail);
	}
}


//获得列表
function getOrderDetailTable(orderdetail){
	orderdetail.getOrderDetails(orderdetail.obj);  
}
