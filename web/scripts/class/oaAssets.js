
function OaAssets(){

	this.obj = {
		id:null,
		assetsCode:null,
		assetsName:null,
		assetsTypeId:null,
		standard:null,
		depreciation:null,
		voucher:null,
		useYearFixed:null,
		purchaseMoney:null,
		purchaseDate:null,
		oldValue:null,
		surplusValue:null,
		provider:null,
		storage:null,
		assetsStateId:null,
		oaAssetsState:null,
		oaAssetsType:null,
		oaProductInfos:null,
		signUser:null,
		
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    memo:null
	}
	
    this.className = null;
	this.treebox = null;
	this.tree = null;
	this.tableName = null;	
	this.tBody = null;
	this.checkBoxName = null;
	this.checkBox =null;
	this.IdPrefix = null;
	this.fillObjName = null;
	this.color1 = null;
	this.color2 = null;
	
	this.pageInfo =""
	this.pageSize ="20"
	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	
	return this;	
}	

//Çå¿Õ¶ÔÏó
OaAssets.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.assetsCode = null;
  	this.obj.assetsName = null;
  	this.obj.assetsTypeId = null;
  	this.obj.standard = null;
  	this.obj.depreciation = null;
  	
  	this.obj.voucher = null;
  	this.obj.useYearFixed = null;
  	this.obj.purchaseMoney = null;
  	this.obj.purchaseDate = null;
  	this.obj.oldValue = null;
  	
  	this.obj.surplusValue = null;
  	this.obj.provider = null;
  	this.obj.storage = null;
  	this.obj.assetsStateId = null;
  	
  	this.obj.oaAssetsState = null;
  	this.obj.oaAssetsType = null;
  	this.obj.oaProductInfos = null;
  	this.obj.signUser = null;
  	
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.memo = null;
}	
	