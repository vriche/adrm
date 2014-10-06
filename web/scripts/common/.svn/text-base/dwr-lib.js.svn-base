//	        function getList(){
//				 var con = new Ext.data.DWRConnection();
////				 DWREngine.setErrorHandler(con.handleFailure);
//				  con.request(
//				  {
//				  url:BrandManager.test,
//				  params:{dwrParams:[1,2,3]},
//				  callback:function(o,success,val){
//					  	if(success){
//					  		Ext.MessageBox.hide();   
//	                        Ext.MessageBox.alert("友情提示","信息保存成功");  
//					  	}else{
//					  		 Ext.MessageBox.hide();   
//	                         Ext.MessageBox.alert("错误提示",val);  
//					  	}
//				  	}
//
//				  }
//				
//				  );
//	        }




Ext.data.DWRConnection = function(config){
    Ext.apply(this, config);
    this.addEvents({
        "beforerequest" : true,
        "requestcomplete" : true,
        "requestexception" : true
    });
    Ext.data.DWRConnection.superclass.constructor.call(this);
};
//
Ext.extend(Ext.data.DWRConnection, Ext.util.Observable, {
    timeout : 30000,
    request : function(options){
        if(this.fireEvent("beforerequest", this, options) !== false){            
            this.scope= options.spoce||this;
        	this.argument= {options: options};
			var success= this.handleResponse.createDelegate(this.scope);
            var failure= this.handleFailure.createDelegate(this.scope);
            var callParams = new Array();
             
            var params = options.params?options.params.dwrParams||(this.params?this.params.dwrParams||[]:[]):(this.params?this.params.dwrParams||[]:[]);
            


            if(options.params){
            	if(options.params.limit > 0){
            		params = params.concat([options.params.start||0,options.params.limit]);
            	}
            	if(options.params.sort && options.params.dir){
            		params = params.concat([options.params.sort,options.params.dir])
            	}
            }    
            

            
            params[params.length]={callback:success,errorHandler:failure};        

            
            var url = options.url || this.url;
            
            if(this.autoAbort !== false){
                this.abort();
            }
            this.transId = true;
            url.apply(this,params);
        }else{
            if(typeof options.callback == "function"){
                options.callback.call(options.scope||window, options, null, null);
            }
        }
    },

    /**
     * Determine whether this object has a request outstanding.
     * @return {Boolean} True if there is an outstanding request.
     */
    isLoading : function(){
        return this.transId ? true : false;  
    },
    abort : function(){
        if(this.isLoading()){
            Ext.lib.Ajax.abort(this.transId);
        }
    },
    // private
    handleResponse : function(response){
        this.transId = false;
        var options = this.argument.options;
        this.fireEvent("requestcomplete", this, response, options);
        if(typeof options.callback == "function"){
            options.callback.call(options.scope||window, options, true, response);
        }
    },
    // private
    handleFailure : function(response, e){
        this.transId = false;
        var options = this.argument.options;
        this.fireEvent("requestexception", this, response, options, e);
        if(typeof options.callback == "function"){
            options.callback.call(options.scope||window, options, false, response);
        }
    }
});

//淇敼鑷?HttpProxy锛屼富瑕佽畩鏇磍oad閮ㄥ垎
Ext.data.DWRHttpProxy = function(conn){
    Ext.data.DWRHttpProxy.superclass.constructor.call(this);
    // is conn a conn config or a real conn?
    this.conn = conn.events ? conn : new Ext.data.DWRConnection(conn);
};

Ext.extend(Ext.data.DWRHttpProxy, Ext.data.DataProxy, {
    // private
    getConnection : function(){
        return this.conn;
    },
    load : function(params, reader, callback, scope, arg){
        if(this.fireEvent("beforeload", this, params) !== false){
            this.conn.request({
                params : params || {}, 
                dwrParams:params.dwrParams||[],
                request: {
                    callback : callback,
                    scope : scope,
                    arg : arg
                },
                reader: reader,
                callback : this.loadResponse,
                scope: this
            });
        }else{
            callback.call(scope||this, null, arg, false);
        }
    },
    
    // private
    loadResponse : function(o, success, response){
        if(!success){
            this.fireEvent("loadexception", this, o, response);
            o.request.callback.call(o.request.scope, null, o.request.arg, false);
            return;
        }
        var result;
        try {
            result = o.reader.read(response);
        }catch(e){
            this.fireEvent("loadexception", this, o, response, e);
            o.request.callback.call(o.request.scope, null, o.request.arg, false);
            return;
        }
        this.fireEvent("load", this, o, o.request.arg);
        o.request.callback.call(o.request.scope, result, o.request.arg, true);
    },
    
    // private
    update : function(dataSet){
        
    },
    
    // private
    updateResponse : function(dataSet){
        
    }
});
//DWRJsonReader
Ext.data.DWRJsonReader = function(meta, recordType){
	this.dataSum = 0;//add
    Ext.data.DWRJsonReader.superclass.constructor.call(this, meta, recordType);
};
Ext.extend(Ext.data.DWRJsonReader, Ext.data.DataReader, {
    read : function(response){
    	//response宸茬稉鏄祼鏋滀簡锛屼笉鐢ㄩ€忛亷 response.responseText;
        return this.readRecords(response);
    },
    simpleAccess: function(obj, subsc) {
    	return obj[subsc];
    },
    getJsonAccessor: function(){
        var re = /[\[\.]/;
        return function(expr) {
            try {
                return(re.test(expr))
                    ? new Function("obj", "return obj." + expr)
                    : function(obj){
                        return obj[expr];
                    };
            } catch(e){}
            return Ext.emptyFn;
        };
    }(),

    readRecords : function(o){
    	

    	 
        this.jsonData = o;
        var s = this.meta, Record = this.recordType,
            f = Record.prototype.fields, fi = f.items, fl = f.length;
        if (!this.ef) {
        	
  			if(s.dataSum){
                this.dataSum = o.dataSum;
            }
        	
            if(s.totalProperty) {
	            this.getTotal = this.getJsonAccessor(s.totalProperty);
	        }
	        if(s.successProperty) {
	            this.getSuccess = this.getJsonAccessor(s.successProperty);
	        }
	        this.getRoot = s.root ? this.getJsonAccessor(s.root) : function(p){return p;};
	        if (s.id) {
	        	var g = this.getJsonAccessor(s.id);
	        	this.getId = function(rec) {
	        		var r = g(rec);
		        	return (r === undefined || r === "") ? null : r;
	        	};
	        } else {
	        	this.getId = function(){return null;};
	        }
            this.ef = [];
           
            for(var i = 0; i < fl; i++){
                f = fi[i];
                var map = (f.mapping !== undefined && f.mapping !== null) ? f.mapping : f.name;
                this.ef[i] = this.getJsonAccessor(map);
            }
        }

    	var root = this.getRoot(o), c = root.length, totalRecords = c, success = true;
    	if(s.totalProperty){
            var v = parseInt(this.getTotal(o), 10);
            if(!isNaN(v)){
                totalRecords = v;
            }
        }
        if(s.successProperty){
            var v = this.getSuccess(o);
            if(v === false || v === 'false'){
                success = false;
            }
        }
        var records = [];
	    for(var i = 0; i < c; i++){
		    var n = root[i];
	        var values = {};
	        var id = this.getId(n);
	        for(var j = 0; j < fl; j++){
	            f = fi[j];
                var v = this.ef[j](n);
                values[f.name] = f.convert((v !== undefined) ? v : f.defaultValue);
	        }
	        var record = new Record(values, id);
	        record.json = n;
	        records[i] = record;
	    }
	    return {
	        success : success,
	        records : records,
	        totalRecords : totalRecords
	    };
    }
});

//new Ext.form.ComboBox({
//	displayField: 'value',
//	valueField: 'key',
//	store: store,				       	
//        fieldLabel: 'Devices',
//        emptyText:'Select devices...'
//})

Ext.data.MapReader = function(){
    Ext.data.MapReader.superclass.constructor.call(this, null, [
		{name: 'key', mapping: 'key'},
		{name: 'value', mapping: 'value'}
	]);
};
Ext.extend(Ext.data.MapReader, Ext.data.DataReader, {
    read : function(response) {

    	var records = [];

	    if(isNaN(response.length)){
	 		for (var dataItem in response) {
		        var record = new this.recordType({ key: dataItem, value: response[dataItem] }, null);
		        records[records.length] = record;
		    }
	    }else{
	    	for(var i=0;i<response.length;i++){
	    		var index = response[i].indexOf(',');
	    		var record = new this.recordType({ key: response[i].substring(0,index),value: response[i].substring(index+1)}, null);
		        records[records.length] = record;
    		}
	    }

	    return {
	        records : records,
	        totalRecords : records.length
	    };
    }
});

Ext.data.DWRObjectReader = function(meta, recordType){
	
    meta = meta || {};
    Ext.data.DWRObjectReader.superclass.constructor.call(this, meta, recordType);
  
};
Ext.extend(Ext.data.DWRObjectReader, Ext.data.ArrayReader, {
    read : function(response){

    var sid = this.meta ? this.meta.id : null;
    var recordType = this.recordType, fields = recordType.prototype.fields;
    var records = [];
   
    var root = response;
   
    for(var i = 0; i < root.length; i++){
    var obj = root[i];
        var values = {};
        var id = obj[sid];
       
        for(var j = 0, jlen = fields.length; j < jlen; j++){
                var f = fields.items[j];
                var k = f.mapping !== undefined && f.mapping !== null ? f.mapping : f.name;
                
                var idx = k.indexOf(".");
                var v = null;
                
                if (idx == -1) {
					v = obj[k] !== undefined ? obj[k] : f.defaultValue;
				}else{
					var k1 = k.substr(0, idx);
					var k2 = k.substr(idx + 1);
					if (obj[k1] == undefined) {
						v = f.defaultValue;
					}
					else {
						var obj2 = obj[k1];
						v = obj2[k2] !== undefined ? obj2[k2] : f.defaultValue;
					}
					
				}
                v = f.convert(v);
                values[f.name] = v;
               
            }
        var record = new recordType(values, id);
        records[records.length] = record;
    }
    return {
        records : records,
        totalRecords : records.length
    };
    }
}); 

//----- DWRTreeLoader

//Ext.tree.DWRTreeLoader = function(config) {
//  Ext.tree.DWRTreeLoader.superclass.constructor.call(this, config);
//};
//
//Ext.extend(Ext.tree.DWRTreeLoader, Ext.tree.TreeLoader, {

Ext.tree.DWRTreeLoader = function(config){
    this.baseParams = {};
    this.requestMethod = "POST";
    Ext.apply(this, config);
    
    this.addEvents({
        "beforeload" : true,
        "load" : true,
        "loadexception" : true
    });
    
    
   Ext.tree.DWRTreeLoader.superclass.constructor.call(this);
};

Ext.extend(Ext.tree.DWRTreeLoader, Ext.util.Observable, {
    uiProviders : {},
    clearOnLoad : true,
    load : function(node, callback){
        if(this.clearOnLoad){
            while(node.firstChild){
                node.removeChild(node.firstChild);
            }
        }
        
        if(node.attributes.children){ // preloaded json children
            var cs = node.attributes.children;
            for(var i = 0, len = cs.length; i < len; i++){
                node.appendChild(this.createNode(cs[i]));
            }
            if(typeof callback == "function"){
                callback();
            }
        }else if(this.dwrMethod){
//        	alert(node);
            this.requestData(node, callback);
        }
    },
    
//        doPreload : function(node){
//        if(node.attributes.children){
//            if(node.childNodes.length < 1){ // preloaded?
//                var cs = node.attributes.children;
//                node.beginUpdate();
//                for(var i = 0, len = cs.length; i < len; i++){
//                    var cn = node.appendChild(this.createNode(cs[i]));
//                    if(this.preloadChildren){
//                        this.doPreload(cn);
//                    }
//                }
//                node.endUpdate();
//            }
//            return true;
//        }else {
//            return false;
//        }
//    },
    
//    getParams: function(node){
//        var buf = [], bp = this.baseParams;
//        for(var key in bp){
//            if(typeof bp[key] != "function"){
//                buf.push(encodeURIComponent(key), "=", encodeURIComponent(bp[key]), "&");
//            }
//        }
//        buf.push(encodeURIComponent(node.id));
//        return buf.join("");
//    },
    
    getParams: function(node){
    	var buf = [], bp = this.params;

    	if(bp instanceof Array){
          
    		if(bp.length == 0)   bp[0] = {};
//    		     alert(node.attributes.orgId)
  		    	 bp[0].nodeId = encodeURIComponent(node.id);
  		    	 bp[0].version = node.attributes.version?node.attributes.version:0;
  		    	 bp[0].orgId = node.attributes.orgId?node.attributes.orgId:1;
		    	 bp[0].nodeType = node.attributes.type?node.attributes.type:0;
		    	 bp[0].nodelevel = node.attributes.level?node.attributes.level:0;
		    	 bp[0].realId = node.attributes.realId?node.attributes.realId:0;
		    	 bp[0].searchTarg = node.attributes.searchTarg?node.attributes.searchTarg:[];
		    	 buf.push(bp[0]);  		

	    	 
//    		Ext.apply(bb,node.attributes,{year:2010,nodeId:node.id,level:0});  
            if(bp.length == 2){
            	if(bp[1]) buf.push(bp[1]);
            }
    	 	
    	 
    	}else{
//    		alert("传入参数必需为数组，不应为json格式");
    		buf.push(encodeURIComponent(node.id));
    	}
//    	buf.push(encodeURIComponent(node.id));
//    	if(bp == null || bp.length == 0) 

//    	buf.push(bp);
    	return buf;
    },
    
    requestData : function(node, callback){
        if(this.fireEvent("beforeload", this, node, callback) !== false){
        	
        	
                this.params = this.getParams(node);
                this.success = this.handleResponse.createDelegate(this, [node, callback], 1);
      			this.failure = this.handleFailure.createDelegate(this, [node, callback], 1);
                this.scope= this;
                
              
        		this.argument= {callback: callback, node: node};
        		
//        		var callParams = new Array();
        		var callParams =this.params.slice();
//      		callParams.push(this.params);
			    callParams.push({callback:this.success, errorHandler:this.failure}); 
			    
			    
                this.transId = true;

                //测试参数是否匹配
//                function testArgs(fn){
//                 	if(fn.length != callParams.length && callParams[0].length ==0 && fn.length>1){
//                 		Ext.MessageBox.alert("传递的参数个数不匹配，请检查!");
//                 	}
//                 }
//                 testArgs(this.dwrMethod);
                
                this.dwrMethod.apply(this,callParams);  
                
//                 console.log(callParams[0])      
            
        }else{
            // if the load is cancelled, make sure we notify 
            // the node that we are done
            if(typeof callback == "function"){
                callback();
            }
        }
    },
    
    isLoading : function(){
        return this.transId ? true : false;  
    },
    
//     isLoading : function(){
//        return !!this.transId;
//    },   
    
    
    abort : function(){
        if(this.isLoading()){
            Ext.lib.Ajax.abort(this.transId);
        }
    },

    /**
    * Override this function for custom TreeNode node implementation
    */
//    createNode : function(attr){
//    	
//        if(this.applyLoader !== false){
//            attr.loader = this;
//        }
//        if(typeof attr.uiProvider == 'string'){
//           attr.uiProvider = this.uiProviders[attr.uiProvider] || eval(attr.uiProvider);
//        }else{
//        	attr.uiProvider = this.baseAttrs; 
//        }
//        
//        if(attr.hrefTarget===undefined){   
//                        attr.hrefTarget='#';            
//         }   
//        return(attr.leaf ?
//                        new Ext.tree.TreeNode(attr) : 
//                        new Ext.tree.AsyncTreeNode(attr));  
//    },


    createNode : function(attr){
    	
//      if(attr.id == 1){
//        		alert(attr.nodeType)
//       }
    	
        // apply baseAttrs, nice idea Corey!
        if(this.baseAttrs){
            Ext.applyIf(attr, this.baseAttrs);
        }
        
    	
        if(this.applyLoader !== false){
            attr.loader = this;
        }
        if(typeof attr.uiProvider == 'string'){
           attr.uiProvider = this.uiProviders[attr.uiProvider] || eval(attr.uiProvider);
        }
        
        
//        alert(attr.attributes.iconCls);
//         if(attr.attributes.iconCls)
//	     {
//	          attr.getUI().iconNode.className = attr.attributes.iconCls;
//	     }      
        
        
        
        if(attr.nodeType){
            return new Ext.tree.TreePanel.nodeTypes[attr.nodeType](attr);
        }else{
            return attr.leaf ?
                        new Ext.tree.TreeNode(attr) :
                        new Ext.tree.AsyncTreeNode(attr);
        }
    },
    
    processResponse : function(response, node, callback){

        var o =response;
        try {
//            node.beginUpdate();
	        for(var i = 0, len = o.length; i < len; i++){
                var n = this.createNode(o[i]);
                if(n){
                    node.appendChild(n); 
                }
	        }
//	        node.endUpdate();
	        if(typeof callback == "function"){
                callback(this, node);
            }
        }catch(e){
            this.handleFailure(response);
        }
    },
    
    handleResponse : function(response,node,callback){
        this.transId = false;
//        var a = this.argument;
        this.processResponse(response, node, callback);
        this.fireEvent("load", this, node, response);
    },
    
    handleFailure : function(response, node, callback){
        this.transId = false;
//        var a = this.argument;
        this.fireEvent("loadexception", this, node, response);
        if(typeof callback == "function"){
            callback(this, node);
        }
    }
});




