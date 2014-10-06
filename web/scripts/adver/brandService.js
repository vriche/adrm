
var brand = new Brand();


callOnLoad(init);

function init(){
	setBrandPara(brand);
	
	getBrandTable();

}

function setBrandPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 
	 obj.className ="brand";
	 obj.IdPrefix 	 = obj.className + "Id";
	 obj.fillObjName = obj.className + "Body";
	 obj.tableName   = obj.className + "List";
	 obj.tBody 		 = $(obj.fillObjName);
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 
	 obj.pageInfo 	 = "pageInfo_" + obj.className;
	 obj.pageSize 	 = "18";
	 obj.page        = new Page(obj.pageInfo,obj.pageSize); 
}

function getBrandTable(){
	brand.reset();
	
	var func = function(objs){
		brand.fillTable(objs);
	}
	
	brand.getBrands(brand.obj,func);
}

function editInfo(id){
	parent.location.href = "editBrand.html?id=" + id;
}

function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == brand.pageInfo){
		var page = new Page(brand.pageInfo,brand.pageSize);
		page.goNextPage(pageIndex);
		brand.page = page;
		getBrandTable();
	}
}








