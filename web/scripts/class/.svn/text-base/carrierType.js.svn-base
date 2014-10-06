function CarrierType(){
	//创建对象
	this.obj ={
		id:null,
		name:null,
	    memo:null,
	    enable:null,
	    parentId:null,
	    nodeLevel:null,
	    displayNo:null,
	    nodePath:null,
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

//清空对象
CarrierType.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.memo = null;
  	this.obj.enable = null;
  	this.obj.parentId = null;
  	this.obj.nodeLevel = null;
  	this.obj.displayNo = null;
  	this.obj.nodePath = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
}

CarrierType.prototype.getTreeXML = function(carrierIdPrefix,resourceIdPrefix){
	var OBJ = this;
	var treeXMLString;
	
	DWREngine.setAsync(false);
	CarrierTypeManager.getCarrierTypeXML(this.obj,this.IdPrefix,carrierIdPrefix,resourceIdPrefix,getxml);
	DWREngine.setAsync(true);
	
	function getxml(treeXML){ 
		OBJ.tree.treeXML = treeXML; 
		treeXMLString = treeXML;
	} 

    return treeXMLString;
}


CarrierType.prototype.getTreeXMLByYear = function(carrierIdPrefix,resourceIdPrefix,year,getFun){

	CarrierTypeManager.getCarrierTypeXMLByYear(this.obj,this.IdPrefix,carrierIdPrefix,resourceIdPrefix,year,getFun);

}


CarrierType.prototype.getTreeXMLFromMap= function(carrierIdPrefix,resourceIdPrefix,callBackFun){
	var OBJ = this;
	CarrierTypeManager.getCarrierTypeXMLFromMap(this.obj,this.IdPrefix,carrierIdPrefix,resourceIdPrefix,getxml);
	function getxml(treeXML){ 
//		OBJ.tree.treeXML = treeXML; 
		callBackFun(treeXML);
	} 
}

CarrierType.prototype.getTreeXMLFromMapByYear= function(carrierIdPrefix,resourceIdPrefix,year,callBackFun){
	CarrierTypeManager.getCarrierTypeXMLFromMapByYear(this.obj,this.IdPrefix,carrierIdPrefix,resourceIdPrefix,year,getxml);
	function getxml(treeXML){ 
//		OBJ.tree.treeXML = treeXML; 
		callBackFun(treeXML);
	} 
}

CarrierType.prototype.getTreeXMLFromMapByYear2= function(carrierIdPrefix,resourceIdPrefix,year,isAccountRes,callBackFun){
	CarrierTypeManager.getCarrierTypeXMLFromMapByYear2(this.obj,this.IdPrefix,carrierIdPrefix,resourceIdPrefix,year,isAccountRes,getxml);
	function getxml(treeXML){ 
//		OBJ.tree.treeXML = treeXML; 
		callBackFun(treeXML);
	} 
}




CarrierType.prototype.makeSelectItemAnalyze = function(obj,name,event){
	CarrierTypeManager.getCarrierTypeSelectItem(obj,fillFun);
	//DWREngine.setAsync(true);
	
	function fillFun(objs){
		makeSelectHtmlAnalyze(objs,name,event);
	}
}


CarrierType.prototype.makeSelectByLoginUser = function(name,event,width,callBack,loginUser,all){

	CarrierTypeManager.getCarrierTypeByLoginUser(loginUser,all,fillFun);

	function fillFun(objs){
//		makeSelectHtmlWidth(objs,name,event,20);
        var el =$(name);
        el.setAttribute("onChange","javascript:"+ event +"(this)");
    	el.setAttribute("style","font-size:12px;width:"+width+"px;CURSOR: pointer;");

        var k = 0;
    	for (var value in objs) {
       		var key = objs[value];
       		el.options.add(new Option(key,value));
       		k++;
    	}
    	if(k == 1){
    		 el.readOnly= true;
    		 $("div_carrierSort").hide();
    	}
    	
		if(callBack) callBack();
	}
}






CarrierType.prototype.getTreeXMLForArrange_bak = function(carrierIdPrefix,resourceIdPrefix,publishDate){
	var OBJ = this;
	var treeXMLString;
	
	DWREngine.setAsync(false);
	CarrierTypeManager.getCarrierTypeXMLForArrange(this.obj,this.IdPrefix,carrierIdPrefix,resourceIdPrefix,publishDate,getxml);
	DWREngine.setAsync(true);
	
	function getxml(treeXML){ 
		OBJ.tree.treeXML = treeXML; 
		treeXMLString = treeXML;
	} 

    return treeXMLString;
}


CarrierType.prototype.getTreeXMLForArrange = function(carrierIdPrefix,resourceIdPrefix,publishDate,callBackFun){

	CarrierTypeManager.getCarrierTypeXMLForArrange(this.obj,this.IdPrefix,carrierIdPrefix,resourceIdPrefix,publishDate,callBackFun);

//	function getxml(treeXML){ 
//        callBackFun(treeXML);
//	} 
}

CarrierType.prototype.getTreeXMLResourceAnalyze = function(obj,carrierIdPrefix,resourceIdPrefix,carrierId,resourceTypeId){
	var OBJ = this;
	var treeXMLString;
	
	DWREngine.setAsync(false);
	CarrierTypeManager.getTreeXMLResourceAnalyze(obj,this.IdPrefix,carrierIdPrefix,resourceIdPrefix,carrierId,resourceTypeId,getxml);
	DWREngine.setAsync(true);
	
	function getxml(treeXML){ 
		OBJ.tree.treeXML = treeXML; 
		treeXMLString = treeXML;
	} 

    return treeXMLString;
}
CarrierType.prototype.getUserCarrirTreeXML= function(carrierIdPrefix){
		var OBJ = this;
		var treeXMLString;
	
	DWREngine.setAsync(false);
	CarrierTypeManager.getUserCarrirXML(this.obj,this.IdPrefix,carrierIdPrefix,getxml);
	DWREngine.setAsync(true);
	
	function getxml(treeXML){ 
		OBJ.tree.treeXML = treeXML; 
		treeXMLString = treeXML;
	} 

    return treeXMLString;
}

CarrierType.prototype.getUserCarrirTreeXML2= function(carrierIdPrefix,fnct){

	CarrierTypeManager.getUserCarrirXML(this.obj,this.IdPrefix,carrierIdPrefix,getxml);
	function getxml(treeXML){ 
		if(fnct) fnct(treeXML);
	} 
}

CarrierType.prototype.getTreeXMLForChannel= function(carrierIdPrefix,resourceIdPrefix,channelModelParam){
		var OBJ = this;
		var treeXMLString;
	
	DWREngine.setAsync(false);
	CarrierTypeManager.getTreeXMLForChannel(this.obj,this.IdPrefix,carrierIdPrefix,resourceIdPrefix,channelModelParam,getxml);
	DWREngine.setAsync(true);
	
	function getxml(treeXML){ 
		OBJ.tree.treeXML = treeXML; 
		treeXMLString = treeXML;
	} 

    return treeXMLString;
}