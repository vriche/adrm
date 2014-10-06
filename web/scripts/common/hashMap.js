
var Class = { 
	create: function() {
			 return function() { 
			 	this.initialize.apply(this, arguments); 
			 }
	 	 }
};


var Extend = function(desc, src) {
	for (var property in src) {
		desc[property] = src[property];
	}
	return desc;
};




var Base = function(){};

Base.prototype.extend = function(obj) {
	return Extend.apply(this, [this, obj]);
};

var Map = Class.create();

Map.prototype = (new Base()).extend({

	initialize : function() {
		this.length = 0;
		this.maxLength = Number.MAX_VALUE;
		this.container = {};
	},

	put : function (objName,objValue){
		try{
			if(this.length >= this.maxLength){
				throw new Error("[Error HashMap] : Map Datas  count overflow !]");
			}
				
			if(objValue && objName && objName != ""){
				this.container[objName] = objValue;
				this.length ++ ;
			}
		}catch(e){
			return e;
		}
	},

	get : function(objName){
		try{
			if(this.container[objName])
				return this.container[objName];
		}catch(e){
			return e;
		}
	},

	size : function(){
		return this.length;
	},

	remove : function(objName){
		try{
			if(this.container[objName]){
				 this.container[objName];
				this.length -- ;
			}
		}catch(e){
			return e;
		}
	}
});

var HashMap = Class.create();

HashMap.prototype = (new Map()).extend({
constructor:HashMap,
	keySet : function(){
		var arrKeySet = new Array();
		var index = 0;
		for(var strKey in this.container){
				arrKeySet[index++] = strKey;
		}
		return arrKeySet.length == 0 ? null : arrKeySet;
	},

	pop : function(objName){
		try{
			var ov = this.container[objName];
			if(ov){
				 this.container[objName];
				this.length -- ;
				return ov;
			}
			return null;
		}catch(e){
			return e;
		}
	},

	isEmpty : function(){
		if(this.length === 0)
			return true;
		else
			return false;
	},

	runIn : function(fun){
		try{
			if(!fun)
				throw new Error("[Error HashMap] : The paramer is null !");
			for(var p in this.container){
				var ov = this.container[p];
				fun(ov);
			}
		}catch(e){
			return e;
		}
	},

	values : function() {
		var arrValues = new Array();
		var index = 0;
		for(var strKey in this.container){
			arrValues[index++] = this.container[strKey];
		}
		return arrValues.length == 0 ? null : arrValues;
	},
	
	contains :  function(objValue){
		try{
			for(var p in this.container){
				if(this.container[p] === objValue)
					return true;
			}
			return false;
		}catch(e){
			return e;
		}
	},
	
	removeAll : function(){
			this.clear();
	},

	clear : function(){
		try{
			 this.container;
			this.container = {};
			this.length = 0;
		}catch(e){
			return e;
		}
	},

	putAll : function(map){
		if(map == null)
			return;
		if(map.constructor != HashMap)
			return;
		var arrKey = map.keySet();
		var arrValue = map.values();
		for(var i in arrKey)
		   this.put(arrKey[i],arrValue[i]);
	}
});