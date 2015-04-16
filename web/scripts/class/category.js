function Category(){
	//创建对象
	this.obj ={
		id:null,
		categoryName:null,
	    parentId:null,
	    treeLevel:null,
	    displayNo:null,
	    categoryCode:null,
	    adResourcePriceType:null,
	    memo:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null
	}

	
    this.className = null;
	this.treebox = null;
	this.tree = null;
	this.tableName = null;	
	this.tBody = null;
	this.checkBoxTarg = null;
	this.checkBoxName = null;
	this.checkBox =null;
	this.radioTarg = null;
	this.radioName = null;
	this.selectTarg = null;
	this.selectName = null;
	
	this.IdPrefix = null;
	this.fillObjName = null;
	this.color1 = null;
	this.color2 = null;
	
	this.pageInfo =""
	this.pageSize ="20"
	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;
		this.fileds =
	[
			{name: "id", type: "int"},
			{name: "categoryName", type: "string"}
			
	];	
	return this;
}

//清空对象
Category.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.categoryName = null;
  	this.obj.parentId = null;
  	this.obj.treeLevel = null;
  	this.obj.displayNo = null;
  	this.obj.categoryCode = null;
  	this.obj.adResourcePriceType = null;
  	this.obj.memo = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
}


Category.prototype.makeOptions = function(targetName,type,event,styleClass,without){
	var OBJ = this;
	var obj = this.obj;
	
	CategoryManager.getCategorys(obj,fillFun);	
	
	function fillFun(objs){
		makeOptionsHtml(objs,type,targetName,"categoryName","id",styleClass,event,without);
	}
}

Category.prototype.makeSelectAnalyze = function(name,event,callBackFun) {

	CategoryManager.getCategorySelectLimit(this.obj,setValueFun);
	
	function setValueFun(objs){

		 makeSelectHtmlAnalyze(objs,name,event);
		 callBackFun();
	}
}

Category.prototype.makeSelectAnalyze2 = function(name,event,callBackFun) {

	CategoryManager.getCategorySelectLimit2(this.obj,setValueFun);
	
	function setValueFun(objs){
		 makeSelectHtmlAnalyze(objs,name,event);
		 callBackFun();
	}
}


Category.prototype.getCategorySelectLimitList = function(obj,callBackFun){

	CategoryManager.getCategorySelectLimitList(obj,callBackFun);	
}

Category.prototype.makeOptionsCallBackFun = function(obj,callBackFun){

	CategoryManager.getCategorys(obj,callBackFun);	
}

Category.prototype.getCategoryTreeXML = function(OBJ,customerIdPrefix,callBackFun){
//	alert("ssss1");
	var obj = OBJ.obj;
	CategoryManager.getCategoryTreeXML(obj,OBJ.IdPrefix,customerIdPrefix,fillFun);
	function fillFun(treeXML){
		callBackFun(treeXML);
	}
}	




Category.prototype.getCategorys = function(callBackFun) {
	
    DWREngine.setAsync(false);
	CategoryManager.getCategorys(this.obj,setValueFun);
	DWREngine.setAsync(true);
	
	function setValueFun(objs){
		 callBackFun(objs);
	}
}



Category.prototype.getStore = function(mode,paramObj){
	paramObj = [paramObj || {}];
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: CategoryManager.getCategorys}),
		reader: new Ext.data.DWRObjectReader({id: "id"},fileds)
	});
	if(mode == 'remote'){
	  	store.on('beforeload', function(){
	    	Ext.apply(this.baseParams, {dwrParams:paramObj});
		}); 
		store.load();			
	}else{
		store.load({params:{dwrParams:paramObj}});
	}
		return store;
};

Category.prototype.getCmd =  function(rederId,elname,width,callBackFun,xtype){
    var OBJ = this;
	var paramObj = this.obj;
    var store = OBJ.getStore('remote',paramObj);


	
	 var conf = {
	   store: store,
	   id:elname,
	   name:elname,
	   width:width,
	   lazyRender: true,
	   displayField:'categoryName',
	    valueField:'id',
	   typeAhead: true,
	   forceSelection: false,
	   triggerAction: 'all',
	   fieldLabel: '客户分类',
	   emptyText:'请选择...',
	   selectOnFocus:true,
	    mode: 'local',
	    minChars:1
	
	};

	if (rederId) conf.renderTo = rederId;

	store.on('load', function() {callBackFun();});

	if (xtype) {
		conf.xtype = 'clearableComboBox';
		conf.listeners = {
			mousedown : function() {this.onTriggerClick()}
		};
		return conf;
	} else {
		var comboBox = new Ext.form.ClearableComboBox(conf);
		comboBox.on("mousedown", function() {cmd.onTriggerClick();});

		return comboBox;
	}

};






