function ResourceChannel(){
	//创建对象
	this.obj ={
		id:null,
		name:null,
	    value:null,
	    memo:null,
        enable:null,
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
ResourceChannel.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.value = null;
  	this.obj.memo = null;
	this.obj.enable = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
}

ResourceChannel.prototype.getResourceChannels =function(obj,callback){
	ResourceChannelManager.getResourceChannels(callback,obj);
}



ResourceChannel.prototype.makeSelectItemAnalyze = function(obj,name,event){
	//DWREngine.setAsync(false);
	ResourceChannelManager.getResourceChannelsSelectItem(fillFun,obj);
	//DWREngine.setAsync(true);
	
	function fillFun(objs){
		//makeSelectHtmlAnalyze(objs,name,event);
		makeSelectHtmlWidth(objs,name,event,100);
	}
}



ResourceChannel.prototype.getStoreMap = function(mode,paramObj){
	paramObj = paramObj || {};
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: ResourceChannelManager.getResourceChannelsSelectItem}),
		reader: new Ext.data.MapReader(),
	});
	
	
	if(mode == 'remote'){
	  	store.on('beforeload', function(){
	    	Ext.apply(this.baseParams, {dwrParams:[paramObj]});
		}); 
		store.load();		
	}else{
		store.load({params:{dwrParams:[paramObj]}});	
	}	
	
	return store;
}



ResourceChannel.prototype.getLovCombo = function(id,width,mode,checkBox,renderTo){
		 var OBJ = this;
  	     var paramObj = this.obj;
         var store = this.getStoreMap(mode,paramObj);
//		 var resourceTypeCmd;
//		 var conf = {
//	 	     fieldLabel: '频道'
//			 ,id:id
//			,name:id
//			,width:150
//			,hideOnSelect:false
//			,maxHeight:200
//			,readOnly: false 
//	  		,editable: false
//	  		,typeAhead: true
//			,emptyText: '请选择...' 
//			,store:store
//			,triggerAction:'all'
//			,valueField:'id'
//			,displayField:'aliasName'
//			,mode:'local'		  	
//			};
//	 
//	 if(checkBox){
//		  resourceTypeCmd = new Ext.ux.form.LovCombo(conf);		
//	 }else{
//		  resourceTypeCmd =  new Ext.form.ClearableComboBox(conf);		
//	 }
	 
	 
		 var conf = {
	 	     fieldLabel: '频道'
			 ,id:id
			,name:id
			,width:width
			,hideOnSelect:false
			,maxHeight:200
			,readOnly: false 
	  		,editable: false
	  		,typeAhead: true
			,emptyText: '请选择...' 
			,store:store
			,triggerAction:'all'
			,valueField:'key'
			,displayField:'value'
			,mode:mode 		  	
		};
	
    if(renderTo) conf.renderTo = renderTo;
			
	var cmd;
    if(checkBox){
    	  cmd = new Ext.ux.form.LovCombo(conf);
    }else{
    	  cmd = new Ext.form.ClearableComboBox(conf);	
    }
  	
  	return cmd;		

	
}



ResourceChannel.prototype.saveChannelConfig = function(channelId,func){
	ResourceChannelManager.saveChannelConfig(channelId,this.channelConfigs,func);
}

ResourceChannel.prototype.getResourceChannelConfigGridXML = function(channelId,func){
	ResourceChannelManager.getResourceChannelConfigsGridXML(channelId,func);
}

ResourceChannel.prototype.remove_resourceChannelConf = function(id,func){
	ResourceChannelManager.removeResourceChannelConf(id,func);
}





