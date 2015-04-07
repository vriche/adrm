
function MyUtils(serviceDate){
	this.dateFormat = "yyyyMMdd";
	this.serviceDate = (serviceDate)?serviceDate:new Date();
	this.curDate = this.getCurDate();
	this.curDate2 = this.getCurDate2();
 	return this;
}

MyUtils.prototype.myMessage =function(msg){
	Ext.MessageBox.hide(); 
	return Ext.MessageBox.show(
			 	{title:'系统提示',msg:msg,width:300,heigth:200,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
	); 
	   
};

MyUtils.prototype.myMessage2 =function(msg,callBack){
	Ext.MessageBox.hide(); 
    Ext.MessageBox.show(
			 	{title:'系统提示',msg:msg,width:300,heigth:200,buttons: Ext.Msg.OKCANCEL, icon: Ext.MessageBox.INFO,fn:callBack}
	); 
	   
};

MyUtils.prototype.disabledButton = function(items,bln,nums){
        if(nums){
        	for (var i = 0; i < nums.length; i ++){
	    		var btn = items.get(nums[i]);
	    		if(btn.type == 'button'){
	    			if(bln){btn.disable();}else{btn.enable();};
	    		}	
        	}
        }else{
	    	for (var i = 0; i < items.length; i ++){
	    		var btn = items.get(i);
	    		if(btn.type == 'button'){
	    			if(bln){btn.disable();}else{btn.enable();};
	    		}			
	    	}	
        }

};

MyUtils.prototype.dwrConnection =function(fn,par,msg,callback){

	var con = new Ext.data.DWRConnection();
	var dwrParams ={dwrParams:par};
	var self = this;
 	con.request(
		{
			url:fn,
			params:dwrParams,
			callback:function(o,success,val){
				if(success){
					if(msg){self.myMessage(msg);}
				}else{
					self.myMessage(val);
				}
				if(callback){callback(o,success,val);}
			}
		}
	); 		
};

MyUtils.prototype.getStoreFileds =function(arrFields){
	var ret = [];
	var fields = [];
	var columns = [];
	var headers = [];
	var dataIndexs = [];
	if(!Ext.isArray(arrFields)) arrFields = [];
	for(var i=0; i<arrFields.length; i++){
		var field = {};
		field.name = arrFields[i].name;
		if(arrFields[i].type) {field.type = arrFields[i].type;}
		if(arrFields[i].dateFormat) {field.dateFormat = arrFields[i].dateFormat;}
		fields.push(field);		
		
         if(arrFields[i].label){
          	 var column = {};
          	 column.header = arrFields[i].label;
          	 column.dataIndex = arrFields[i].name;
          	 if(arrFields[i].width) column.width = arrFields[i].width;
          	 if(arrFields[i].align) column.align = arrFields[i].align;
          	 if(arrFields[i].sortable) column.sortable = arrFields[i].sortable;
          	 if(arrFields[i].renderer) column.renderer = arrFields[i].renderer;
          	 if(arrFields[i].editor) column.editor = arrFields[i].editor;
          	 if(arrFields[i].summaryType) column.summaryType = arrFields[i].summaryType;
          	 if(arrFields[i].summaryRenderer) column.summaryRenderer = eval(arrFields[i].summaryRenderer);
          	 
          	 headers.push(arrFields[i].label);
          	 dataIndexs.push(arrFields[i].name);
          	 columns.push(column);
          }
	}
	ret.push(fields);	ret.push(columns);	ret.push(headers);	ret.push(dataIndexs);	
	return ret;
}
//loaded 鏄惁绔嬪嵆鍔犺浇 true/false
//readerType reader鏂瑰紡  1,2,default 

MyUtils.prototype.getStore =function(fn,fileds,mode,loaded,paramObj,readerType,limit,sortInfo){
//    if(!Ext.isArray(paramObj)) paramObj = [paramObj];
     var store;  
     if(readerType == 3){
     	store= new Ext.data.GroupingStore();
     }else{
     	store = new Ext.data.Store();
     }
   

    store.proxy = new Ext.data.DWRHttpProxy({url: fn});
    
    if(readerType == 1 || readerType == 3){
		store.reader = new Ext.data.DWRJsonReader({id:'id',root:'data',totalProperty:'totalSize',dataSum: 'dataSum'},fileds);
    }else if(readerType == 2){
		store.reader = new Ext.data.MapReader();
    }else{
    	store.reader = new Ext.data.DWRObjectReader({id: "id"},fileds);
    }
    if(limit){ store.baseParams = {limit:limit};}
    if(sortInfo){
	    if(mode == 'remote'){ store.remoteSort = true;}
	    store.sortInfo = sortInfo;
    }

 
//	var store = new Ext.data.Store({
//			proxy: new Ext.data.DWRHttpProxy({url: fn}),
//			reader: new Ext.data.DWRObjectReader({id: "id"},fileds)
//	});    	  

    if(mode == 'remote'){
		store.on('beforeload', function(a,b){
//		  		var paramObj = b || {};
//		  		if(!Ext.isArray(paramObj)) paramObj = [paramObj];
		  		var callback = paramObj.callback;
		  		if(callback){
		  			Ext.apply(this.baseParams, {dwrParams:[paramObj],callback:callback});
		  		}else{
		  			Ext.apply(this.baseParams, {dwrParams:[paramObj]});
		  		}
		    	
		}); 
		if(loaded) {store.load();}
    }else{
    	if(loaded) {store.load({params:{dwrParams:[paramObj]}});}
    }

//	store.load();
	return store;
};



MyUtils.prototype.getFitterStore = function(store,filed,value){
	store.filterBy(function(record,id){         
					if(record.get(filed) == value){          
						return true;         
					} else return false;  });		
};   
MyUtils.prototype.getFitterStore1 = function(store,filed,min,max){
					store.filterBy(function(record,id){         
					if(record.get(filed)>= min && record.get(filed)<= max){          
						return true;         
					} else return false;  });		
};  

MyUtils.prototype.getRecoredFromJsonStore =function(fn,fileds,paramObj,msg,callback){
	paramObj = paramObj || {};	
    var store = new Ext.data.JsonStore({id:'id',fields: fileds});
    this.dwrConnection(fn,[paramObj],msg,callbackFn);
	function callbackFn(o,success,data){
		if(success){
			store.loadData(data);
			var rec = store.getById(paramObj.id)
			if(callback) {callback(rec);}
		}
	}
};


MyUtils.prototype.getChecked =function(tree,proty,node,type){
	  		var checkedNodes = tree.getChecked(proty,node);  
	  		var ids = [];
	  		var parentId = node.id;
	  		if(type){
	  			for(var i =1;i<checkedNodes.length;i++){
	  				 var s = checkedNodes[i];
	  				 var start = s.indexOf('_');
	  				 var t = s.substring(0,start);
	  				 if(type == t)ids.push(s.substring(start+1,s.length))
	  			}
	  		}else{
	  			for(var i =1;i<checkedNodes.length;i++){
	  				 ids.push(checkedNodes[i]);
	  			}
	  		}
//	  		alert(node.text+" = "+ ids);
//	   		alert(node.text+" = "+ checkedNodes);
//		    alert(node.text+" = "+ node.attributes.level);

	return ids;
};
MyUtils.prototype.getComYear = function(comboBox_ID,fieldLabel,width,defValue,xtype){

    Ext.QuickTips.init();
        
//        var store = new Ext.data.SimpleStore
//        ({
//            fields:["id","name"],
//            data:names
//        });    
// 
//			                    	beforequery:customer.comboFilterBy.createDelegate(this),
//									collapse:comboCollapse.createDelegate(this) //涓嬫媺妗嗘秷澶辨椂
//									select:comboCollapse.createDelegate(this), //涓嬫媺妗嗘秷澶辨椂

		var conf = {    
        	fieldLabel: fieldLabel,    
            id:comboBox_ID,
            name: comboBox_ID,
//            emptyText: '请选择...',
            editable:false,
            allowBlank:false,
            store:["2006","2007","2008","2009","2010","2011","2012","2013","2014"],
            mode: 'local',
            typeAhead: true,
            triggerAction: 'all',
            selectOnFocus:true,
//            renderTo:renderTo,
            width:width,
            frame:true,
            resizable:true
        };

	    if(xtype){
	    	conf.xtype = 'combo';
	    	 if(defValue)  conf.value = defValue;  
	    	return conf;
	    }else{
		    var comboBox =   new Ext.form.ComboBox(conf);
		    if(defValue)  comboBox.setValue(defValue);  
		    return comboBox
	    }         
        
};

MyUtils.prototype.getComMonth = function(comboBox_ID,fieldLabel,width,defValue,model,renderTo){


	 
    Ext.QuickTips.init();
	
    var store  = new Ext.data.SimpleStore({
        fields : ['value', 'text'],
        data :  [[1,"1"],[2,"2"],[3,"3"],[4,"4"],[5,"5"],[6,"6"],[7,"7"],[8,"8"],[9,"9"],[10,"10"],[11,"11"],[12,"12"]]
    });
    
 
         if(model ==1){
         	store.data= [[1,'一月'], [2,'二月'], [3,'三月'], [4,'四月'], [5,'五月'], [6,'六月'], [7,'七月'], [8,'八月'],[9,'九月'], [10,'十月'], [11,'十一月'], [12,'十二月']];
         }else if(model ==2){
         	store.data = [[1,"01"],[2,"02"],[3,"03"],[4,"04"],[5,"05"],[6,"06"],[7,"07"],[8,"08"],[9,"9"],[10,"10"],[11,"11"],[12,"12"]]; 
         }


    
		 var comboBox = new Ext.form.ComboBox({    
        	fieldLabel: fieldLabel,    
            id:comboBox_ID,
            name: comboBox_ID,
//            emptyText: '请选择...',
            editable:false,
            allowBlank:false,
            store:store,
            mode: 'local',
            typeAhead: true,
            triggerAction: 'all',
            selectOnFocus:true,
            displayField : 'text',
        	valueField : 'value',
//            renderTo:renderTo,
            width:width,
//            anchor:'95%',
            frame:true,
            resizable:true
        });
    

		if(renderTo) comboBox.renderTo = renderTo;  

        if(defValue) comboBox.setValue(defValue);  
    
        return comboBox;
};

MyUtils.prototype.getComWeek = function(comboBox_ID,fieldLabel,width,defValue,model){

    Ext.QuickTips.init();

    var store  = new Ext.data.SimpleStore({
        fields : ['value', 'text'],
        data :  [[1,"星期一"],[2,"星期二"],[3,"星期三"],[4,"星期四"],[5,"星期五"],[6,"星期六"],[0,"星期日"]]
    });
    

         if(model ==1){
         	store.data= [[1,"周一"],[2,"周二"],[3,"周三"],[4,"周四"],[5,"周五"],[6,"周六"],[0,"周日"]];
         }else if(model ==2){
         	store.data =  [[1,"一"],[2,"二"],[3,"三"],[4,"四"],[5,"五"],[6,"六"],[0,"日"]];
         }

		 var comboBox = new Ext.form.ComboBox({    
        	fieldLabel: fieldLabel,    
            id:comboBox_ID,
            name: comboBox_ID,
//            emptyText: '请选择...',
            editable:false,
            allowBlank:false,
            store:store,
            mode: 'local',
            typeAhead: true,
            triggerAction: 'all',
            selectOnFocus:true,
            displayField : 'text',
        	valueField : 'value',
//            renderTo:renderTo,
            width:width,
//            anchor:'95%',
            frame:true,
            resizable:true
        });
	
//        if(defValue) comboBox.setValue(defValue);  
        return comboBox;
};

MyUtils.prototype.getComTimeSort = function(comboBox_ID,fieldLabel,width,defValue){

    Ext.QuickTips.init();
    var names = [['1','分钟'],['2','秒']];
    var store = new Ext.data.SimpleStore({fields:["id","name"],data:names});    
		 var comboBox = new Ext.form.ComboBox({    
        	fieldLabel: fieldLabel,    
            id:comboBox_ID,
            name: comboBox_ID,
//            emptyText: '请选择...',
            editable:false,
            allowBlank:false,
            store:store,
            mode: 'local',
            typeAhead: true,
            triggerAction: 'all',
            selectOnFocus:true,
            width:width,
            frame:true,
								displayField:'name',
			  				valueField:'id',
            resizable:true
        });
	
        if(defValue) comboBox.setValue(defValue);  
        return comboBox;
};




MyUtils.prototype.getValues = function(form) {

  //瀹氫箟ele鍙橀噺锛?
  var ele;
  var data = form.el.dom;
//濡傛灉ele鏄釜HTML鍏冪礌瀵硅薄锛岄?甯稿簲璇ユ槸涓?釜form瀵硅薄
  if (DWRUtil._isHTMLElement(data)){ ele = data;}

 if (ele != null) {
    //濡傛灉ele涓嶆槸form瀵硅薄锛岃繑鍥烇紝鍙湁form瀵硅薄鎵嶆湁elements 灞炴?
    if (ele.elements == null) {
      alert("getValues() requires an object or reference to a form element.");
      return null;
    }
    //瀹氫箟涓?釜绌哄璞eply
    var reply = {};
    //瀹氫箟涓?釜瀵硅薄鏀緆ey
    var value;
    //閬嶅巻form,灏嗚〃鍗昸ey-value鏀惧叆reply锛屽拷鐣?input type="image"/>
    for (var i = 0; i < ele.elements.length; i++) {
      if (ele[i].name != null) {value = ele[i].name;}
//      else if (ele[i].name != null) value = ele[i].name;
      else if (ele[i].value != null){ value = ele[i].value;}
      else {value = "element" + i;}
//      reply[value] = DWRUtil.getValue(ele[i]);
      reply[value] = form.findField(ele[i].name).getValue();
    }
    return reply;
  }else{
  	return {};
  }

};


MyUtils.prototype.newRecord = function(fileds,initValues) {
	 if(fileds){
	 	 var rc = Ext.data.Record.create(fileds);
         if(initValues) {return new rc(initValues);}
	 }
	 return null;	 
};


MyUtils.prototype.isFormChanged = function (formPanel){
 var form = formPanel.getForm();
 var dirty = false;
 if(form) {
  form.items.each(function(item){
   if(!dirty) {dirty = item.isDirty();}
  });
 }
 return dirty;
};

//鑾峰彇鍙傛暟
MyUtils.prototype.getParamFromUrl = function(srcStr,paramName) {
 var pos, paramStr, paramArr, paramValue, tempStr;
 pos = srcStr.indexOf("?");
 paramStr = srcStr.substring(pos+1);
 paramArr = paramStr.split("&");
 parameValue = "";
 tempStr = "";
 for (var i=0; i<paramArr.length; i++) {
  tempStr = paramArr[i];
  pos = tempStr.indexOf("=");
  if(tempStr.substring(0,pos) == paramName) {
   paramValue = tempStr.substring(pos+1);
   return paramValue;
  }
 }
 return null;
};

MyUtils.prototype.converData=function(rec){
	var reply = {};
	var obj = rec.data;
	var fields = rec.fields;
//	if(!Ext.isArray(fields)) return reply;
	for(key in obj){
		var v =  obj[key];
		var field = fields.get(key);
		if(field.type == 'date'){
			var format = field.dateFormat;
			format = (format =='Ymd')?this.dateFormat:format;
 			reply[key] = this.formatDate(v,format);
		}else{
 			reply[key] = v;
		}
	}
 	return reply;		
 };






//return date type
MyUtils.prototype.getCurDate = function() {
	 var df = this.serviceDate;
	 var dt = this.getDateFromFormat(df,this.dateFormat);
	 return new Date(dt);
};
//return format string type
MyUtils.prototype.getCurDate2 = function(format) {
	 var df = this.serviceDate;
	 var format =(format)?format:this.dateFormat
	 var dt = this.getDateFromFormat(df,this.dateFormat);
	 return this.formatDate(new Date(dt),format);
};


MyUtils.prototype.isDateSimple = function(v){
	var dt = new Date(v);
	if(isNaN(dt)){return false;}else{return true;}
};


MyUtils.prototype.isDate = function(val,format) {
	if(format){
		var date = this.getDateFromFormat(val,format);
		if (date==0) { return false; }
		return true;
	}else{
		return this.isDateSimple(val);
	}
};

MyUtils.prototype.compareDates = function(date1,dateformat1,date2,dateformat2) {
	var d1=  this.getDateFromFormat(date1,dateformat1);
	var d2=  this.getDateFromFormat(date2,dateformat2);
	if (d1==0 || d2==0) {
		return -1;
		}
	else if (d1 > d2) {
		return 1;
		}
	return 0;
};
MyUtils.prototype.yearFirstDay = function(year){
	 var year = (year)?year:this.curDate.getFullYear();
	 var d = new Date(year,"0","1");	
	 return d;
};
MyUtils.prototype.yearFirstDayFormat = function(year){
	 var year = (year)?year:this.curDate.getFullYear();
	 var d = new Date(year,"0","1");
	 return this.formatDate(d,this.dateFormat);
};
MyUtils.prototype.yearLastDay = function(year){
	 var year = (year)?year:this.curDate.getFullYear();
	 var d = new Date(year,"11","31");
	 return d;
};
MyUtils.prototype.yearLastDayFormat = function(year){
	 var year = (year)?year:this.curDate.getFullYear();
	 var d = new Date(year,"11","31");
	 return this.formatDate(d,this.dateFormat);
};

MyUtils.prototype.getYear = function(date){
	 var date = (date)?date:this.curDate;
	 var dt = this.getDateFromFormat(date,this.dateFormat);
	 var d = new Date(dt);
	 return  d.getFullYear();
};
MyUtils.prototype.getMonth = function(date){
	 var date = (date)?date:this.curDate;
	 var dt = this.getDateFromFormat(date,this.dateFormat);
	 var d = new Date(dt);
	 return  d.getMonth()+1;
};
MyUtils.prototype.getDay = function(date){
	 var date = (date)?date:this.curDate;
	 var dt = this.getDateFromFormat(date,this.dateFormat);
	 var d = new Date(dt);
	 return  d.getDay();
};
MyUtils.prototype.getStartDay = function(date,month){
	 var date = (date)?date:this.curDate;
	 var month = (month)?month: date.getMonth();
     var dt = this.getDateFromFormat(date,this.dateFormat);
     var d = new Date(dt);
     d.setMonth(month)
     d.setDay(1);
	 return d;
};
MyUtils.prototype.getStartDayFormat = function(date,month){
	 var date = (date)?date:this.curDate;
	 var month = (month)?month: date.getMonth();
     var dt = this.getDateFromFormat(date,this.dateFormat);
     var d = new Date(dt);
     d.setMonth(month)
     d.setDay(1);
	 return this.formatDate(d,this.dateFormat);
};
MyUtils.prototype.getEndDay = function(date,month){
	 var date = (date)?date:this.curDate;
	 var month = (month)?month: date.getMonth();
     var dt = this.getDateFromFormat(date,this.dateFormat);
     var d = new Date(dt);
     d.setMonth(month)
     d.setDay(d.getMonthDays(d.getMonth()))
	 return d;
};
MyUtils.prototype.getEndDayFormat = function(date,month){
	 var date = (date)?date:this.curDate;
	 var month = (month)?month: date.getMonth();
     var dt = this.getDateFromFormat(date,this.dateFormat);
     var d = new Date(dt);
     d.setMonth(month)
     d.setDay(d.getMonthDays(d.getMonth()))
	 return this.formatDate(d,this.dateFormat);
};
MyUtils.prototype.getNextMonthDay = function(date){
	 var date = (date)?date:this.curDate;
	 var dt = this.getDateFromFormat(date,this.dateFormat);
	 var d = new Date(dt);
	 var month = d.getMonth()+1;
	 if (month == 12){ 
       alert("宸叉槸鏈?悗涓?釜鏈堬紝涓嶈兘鍐嶅鍔狅紒") ;
       return false;
     }
     var monthDays = d.getMonthDays(month);
     var dd = new Date(d.getFullYear(),month++,monthDays);
	 return dd;
};
MyUtils.prototype.getNextMonthDayFormat = function(date){
	 var date = (date)?date:this.curDate;
	 var dt = this.getDateFromFormat(date,this.dateFormat);
	 var d = new Date(dt);
	 var month = d.getMonth()+1;
	 if (month == 12){ 
       alert("宸叉槸鏈?悗涓?釜鏈堬紝涓嶈兘鍐嶅鍔狅紒") ;
       return false;
     }
     var monthDays = d.getMonthDays(month);
     var dd = new Date(d.getFullYear(),month++,monthDays);
	 return this.formatDate(dd,this.dateFormat);
};

MyUtils.prototype.parseDate=function(str){  
  if(typeof str == 'string'){  
     var results = str.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) *$/);  
     if(results && results.length>3)  
       return new Date(parseInt(results[1]),parseInt(results[2]) -1,parseInt(results[3]));   
     results = str.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) +(\d{1,2}):(\d{1,2}):(\d{1,2}) *$/);  
     if(results && results.length>6)  
       return new Date(parseInt(results[1]),parseInt(results[2]) -1,parseInt(results[3]),parseInt(results[4]),parseInt(results[5]),parseInt(results[6]));   
     results = str.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) +(\d{1,2}):(\d{1,2}):(\d{1,2})\.(\d{1,9}) *$/);  
     if(results && results.length>7)  
       return new Date(parseInt(results[1]),parseInt(results[2]) -1,parseInt(results[3]),parseInt(results[4]),parseInt(results[5]),parseInt(results[6]),parseInt(results[7]));   
   }  
   return null;
 };

 

 
 
MyUtils.prototype.formatDate = function(date,format) {
	if(typeof date == 'string') date = this.parseDate(date);  
	var MONTH_NAMES = new Array('一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月','九月', '十月', '十一月', '十二月','一', '二', '三', '四', '五', '六', '七', '八','九', '十', '十一', '十二');  
	var DAY_NAMES= new Array('星期日','星期一','星期二','星期三','星期四','星期五','星期六','日','一','二','三','四','五','六'); 	function LZ(x) {return(x<0||x>9?"":"0")+x};
	
	var format = (format)?format:this.dateFormat;
	
	if(date instanceof Date){ 
		format=format+"";
		var result="";
		var i_format=0;
		var c="";
		var token="";
		var y=date.getYear()+"";
		var M=date.getMonth()+1;
		var d=date.getDate();
		var E=date.getDay();
		var H=date.getHours();
		var m=date.getMinutes();
		var s=date.getSeconds();
		var yyyy,yy,MMM,MM,dd,hh,h,mm,ss,ampm,HH,H,KK,K,kk,k;
		// Convert real date parts into formatted versions
		var value=new Object();
		if (y.length < 4) {y=""+(y-0+1900);}
		value["y"]=""+y;
		value["yyyy"]=y;
		value["yy"]=y.substring(2,4);
		value["M"]=M;
		value["MM"]=LZ(M);
		value["MMM"]=MONTH_NAMES[M-1];
		value["NNN"]=MONTH_NAMES[M+11];
		value["d"]=d;
		value["dd"]=LZ(d);
		value["E"]=DAY_NAMES[E+7];
		value["EE"]=DAY_NAMES[E];
		value["H"]=H;
		value["HH"]=LZ(H);
		if (H==0){value["h"]=12;}
		else if (H>12){value["h"]=H-12;}
		else {value["h"]=H;}
		value["hh"]=LZ(value["h"]);
		if (H>11){value["K"]=H-12;} else {value["K"]=H;}
		value["k"]=H+1;
		value["KK"]=LZ(value["K"]);
		value["kk"]=LZ(value["k"]);
		if (H > 11) { value["a"]="PM"; }
		else { value["a"]="AM"; }
		value["m"]=m;
		value["mm"]=LZ(m);
		value["s"]=s;
		value["ss"]=LZ(s);
		while (i_format < format.length) {
			c=format.charAt(i_format);
			token="";
			while ((format.charAt(i_format)==c) && (i_format < format.length)) {
				token += format.charAt(i_format++);
				}
			if (value[token] != null) { result=result + value[token]; }
			else { result=result + token; }
			}
		return result;
	}else{
		return date;
	}

};

MyUtils.prototype.getDateFromFormat  = function(val,format) {
	val=val+"";
	format=format+"";
	var i_val=0;
	var i_format=0;
	var c="";
	var token="";
	var token2="";
	var x,y;
	var now=new Date();
	var year=now.getYear();
	var month=now.getMonth()+1;
	var date=1;
	var hh=now.getHours();
	var mm=now.getMinutes();
	var ss=now.getSeconds();
	var ampm="";
	
	var MONTH_NAMES = new Array('一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月','九月', '十月', '十一月', '十二月','一', '二', '三', '四', '五', '六', '七', '八','九', '十', '十一', '十二');  
	var DAY_NAMES= new Array('星期日','星期一','星期二','星期三','星期四','星期五','星期六','日','一','二','三','四','五','六');   
	
	// ------------------------------------------------------------------  
	// Utility functions for parsing in getDateFromFormat()  
	// ------------------------------------------------------------------  
	function _isInteger(val) {  
	    var digits="1234567890";  
	    for (var i=0; i < val.length; i++) {  
	        if (digits.indexOf(val.charAt(i))==-1) { return false; }  
	        }  
	    return true;  
	    }  
	function _getInt(str,i,minlength,maxlength) {  
	    for (var x=maxlength; x>=minlength; x--) {  
	        var token=str.substring(i,i+x);  
	        if (token.length < minlength) { return null; }  
	        if (_isInteger(token)) { return token; }  
	        }  
	    return null;  
	}  		
	
	
	while (i_format < format.length) {
		// Get next token from format string
		c=format.charAt(i_format);
		token="";
		while ((format.charAt(i_format)==c) && (i_format < format.length)) {
			token += format.charAt(i_format++);
			}
		// Extract contents of value based on format token
		if (token=="yyyy" || token=="yy" || token=="y") {
			if (token=="yyyy") { x=4;y=4; }
			if (token=="yy")   { x=2;y=2; }
			if (token=="y")    { x=2;y=4; }
			year=_getInt(val,i_val,x,y);
			if (year==null) { return 0; }
			i_val += year.length;
			if (year.length==2) {
				if (year > 70) { year=1900+(year-0); }
				else { year=2000+(year-0); }
				}
			}
		else if (token=="MMM"||token=="NNN"){
			month=0;
			for (var i=0; i<MONTH_NAMES.length; i++) {
				var month_name=MONTH_NAMES[i];
				if (val.substring(i_val,i_val+month_name.length).toLowerCase()==month_name.toLowerCase()) {
					if (token=="MMM"||(token=="NNN"&&i>11)) {
						month=i+1;
						if (month>12) { month -= 12; }
						i_val += month_name.length;
						break;
						}
					}
				}
			if ((month < 1)||(month>12)){return 0;}
			}
		else if (token=="EE"||token=="E"){
			for (var i=0; i<DAY_NAMES.length; i++) {
				var day_name=DAY_NAMES[i];
				if (val.substring(i_val,i_val+day_name.length).toLowerCase()==day_name.toLowerCase()) {
					i_val += day_name.length;
					break;
					}
				}
			}
		else if (token=="MM"||token=="M") {
			month=_getInt(val,i_val,token.length,2);
			if(month==null||(month<1)||(month>12)){return 0;}
			i_val+=month.length;}
		else if (token=="dd"||token=="d") {
			date=_getInt(val,i_val,token.length,2);
			if(date==null||(date<1)||(date>31)){return 0;}
			i_val+=date.length;}
		else if (token=="hh"||token=="h") {
			hh=_getInt(val,i_val,token.length,2);
			if(hh==null||(hh<1)||(hh>12)){return 0;}
			i_val+=hh.length;}
		else if (token=="HH"||token=="H") {
			hh=_getInt(val,i_val,token.length,2);
			if(hh==null||(hh<0)||(hh>23)){return 0;}
			i_val+=hh.length;}
		else if (token=="KK"||token=="K") {
			hh=_getInt(val,i_val,token.length,2);
			if(hh==null||(hh<0)||(hh>11)){return 0;}
			i_val+=hh.length;}
		else if (token=="kk"||token=="k") {
			hh=_getInt(val,i_val,token.length,2);
			if(hh==null||(hh<1)||(hh>24)){return 0;}
			i_val+=hh.length;hh--;}
		else if (token=="mm"||token=="m") {
			mm=_getInt(val,i_val,token.length,2);
			if(mm==null||(mm<0)||(mm>59)){return 0;}
			i_val+=mm.length;}
		else if (token=="ss"||token=="s") {
			ss=_getInt(val,i_val,token.length,2);
			if(ss==null||(ss<0)||(ss>59)){return 0;}
			i_val+=ss.length;}
		else if (token=="a") {
			if (val.substring(i_val,i_val+2).toLowerCase()=="am") {ampm="AM";}
			else if (val.substring(i_val,i_val+2).toLowerCase()=="pm") {ampm="PM";}
			else {return 0;}
			i_val+=2;}
		else {
			if (val.substring(i_val,i_val+token.length)!=token) {return 0;}
			else {i_val+=token.length;}
			}
		}
	// If there are any trailing characters left in the value, it doesn't match
	if (i_val != val.length) { return 0; }
	// Is date valid for month?
	if (month==2) {
		// Check for leap year
		if ( ( (year%4==0)&&(year%100 != 0) ) || (year%400==0) ) { // leap year
			if (date > 29){ return 0; }
			}
		else { if (date > 28) { return 0; } }
		}
	if ((month==4)||(month==6)||(month==9)||(month==11)) {
		if (date > 30) { return 0; }
		}
	// Correct hours value
	if (hh<12 && ampm=="PM") { hh=hh-0+12; }
	else if (hh>11 && ampm=="AM") { hh-=12; }
	var newdate=new Date(year,month-1,date,hh,mm,ss);
	return newdate.getTime();
};

MyUtils.prototype.formatDateSimple=function(v,sep){
   if(typeof v == 'string') v = this.parseDate(v);  
   if(v instanceof Date){  
     var y = v.getFullYear();  
     var m = v.getMonth() + 1;  
     var d = v.getDate();
     m = m<10?'0'+m:m;
     d = d<10?'0'+d:d;
     return y + sep + m + sep + d;  
   }  
   return v;  
 }
// MyUtils.prototype.monthDiff=function(d1, d2){
//    var months;
//    months = (d2.getFullYear() - d1.getFullYear()) * 12;
//    months -= d1.getMonth() + 1;
//    months += d2.getMonth();
//    return months <= 0 ? 0 : months;
// }
// 
// 
 MyUtils.prototype.monthDiff=function(firstDate, secondDate){
        var fm = firstDate.getMonth();
        var fy = firstDate.getFullYear();
        var sm = secondDate.getMonth();
        var sy = secondDate.getFullYear();
        var months = Math.abs(((fy - sy) * 12) + fm - sm);
        var firstBefore = firstDate > secondDate;
//        firstDate.setFullYear(sy);
//        firstDate.setMonth(sm);
        firstBefore ? firstDate < secondDate ? months-- : "" : secondDate < firstDate ? months-- : "";
        return months;
 }
 


///** Returns the number of the week in year, as defined in ISO 8601. */
MyUtils.prototype.getWeekNumber = function(d1) {
	var d = new Date(d1.getFullYear(), d1.getMonth(), d1.getDate(), 0, 0, 0);
	var DoW = d.getDay();
	d.setDate(d.getDate() - (DoW + 6) % 7 + 3);
	// Nearest Thu
	var ms = d.valueOf();
	// GMT
	d.setMonth(0);
	d.setDate(4);

	// Thu in Week 1
	return Math.round((ms - d.valueOf()) / (7 * 864e5)) + 1;
}; 


//返回两个日期相差的天数  
MyUtils.prototype.getDateDiff = function(d1) {
	//这里的date1、date2为日期的字符串  
	//将date1,date2转换为Date对象  
	var _dt1=new Date(date1);  
	var _dt2=new Date(date2);  
	var dt1=_dt1.getTime();  
	var dt2=_dt2.getTime();  
	return parseInt(Math.abs(dt1- dt2)/1000/60/60/24);//这里是计算天数,如果想获得周数则在该返回值上再除以7  
}; 


MyUtils.prototype.CreateCheckBoxWin = function(store, colnum,title) {    
        var count = store.getCount();    
        var myCheckboxItems = [];    
        for (var i = 0; i < count; i++) {    
            var boxLabel = store.getAt(i).get("name");    
            var name = store.getAt(i).get("id");    
            myCheckboxItems.push({    
                        boxLabel : boxLabel,    
                        name : name    
                    });    
        }    
        var myCheckboxGroup = new Ext.form.CheckboxGroup({    
                    xtype : 'checkboxgroup',    
                    itemCls : 'x-check-group-alt',    
                    columns : colnum,    
                    items : myCheckboxItems    
                });    
        var form = new Ext.FormPanel({    
                    border : true,    
                    frame : true,    
                    labelAlign : "right",    
                    buttonAlign : 'right',    
                    layout : 'column',    
                    width : 500,    
                    items : [myCheckboxGroup],    
                    buttons : [{    
                        xtype : 'button',    
                        text : '确定',    
                        handler : function() {    
                            var ids = [];    
                            var cbitems = myCheckboxGroup.items;    
                            for (var i = 0; i < cbitems.length; i++) {    
                                if (cbitems.itemAt(i).checked) {    
                                    ids.push(cbitems.itemAt(i).name);    
                                }    
                            }    
                            win.destroy();    
                            if (ids.length) {    
                                Ext.Msg.alert("消息", "选中状态的id组合字符串为:"   
                                                + ids.toString());    
                            }    
                        }    
       
                    }, {    
                        xtype : 'button',    
                        text : '取消',    
                        handler : function() {    
                            win.destroy();    
                        }    
       
                    }]    
       
                });    
        var win = new Ext.Window({    
                    modal : true,    
                    layout : 'fit',    
                    title : title,    
                    width : 500,    
                    height : 300,    
                    plain : true,    
                    items : [form]    
                });    
        win.show();    
      
    }  










MyUtils.prototype.parseDate2  = function(val) {
	var preferEuro=(arguments.length==2)?arguments[1]:false;
	generalFormats=new Array('y-M-d','MMM d, y','MMM d,y','y-MMM-d','d-MMM-y','MMM d');
	monthFirst=new Array('M/d/y','M-d-y','M.d.y','MMM-d','M/d','M-d');
	dateFirst =new Array('d/M/y','d-M-y','d.M.y','d-MMM','d/M','d-M');
	var checkList=new Array('generalFormats',preferEuro?'dateFirst':'monthFirst',preferEuro?'monthFirst':'dateFirst');
	var d=null;
	for (var i=0; i<checkList.length; i++) {
		var l=window[checkList[i]];
		for (var j=0; j<l.length; j++) {
			d=this.getDateFromFormat(val,l[j]);
			if (d!=0) { return new Date(d); }
			}
		}
	return null;
};
 
MyUtils.prototype.getDateTimeArray=function(v){
   if(typeof v == 'string') v = this.parseDate(v);  
   if(v instanceof Date){  
     var y = v.getFullYear();  
     var m = v.getMonth() + 1;  
     var d = v.getDate();
     var h = v.getHours();  
     var i = v.getMinutes();  
     var s = v.getSeconds();  
     var ms = v.getMilliseconds();
     m = m<10?'0'+m:m;
     d = d<10?'0'+d:d;
     h = h<10?'0'+h:h;
     i = i<10?'0'+i:i;
     s = s<10?'0'+s:s;
     return [y,m,d,h,i,s,ms];
   }else{
   	   return ['1999','01','01','00','00','00','0'];
   }
 
};
MyUtils.prototype.makeOptionsCheckBoxHtml=function(objs,type,dom,fName,fId,styleClass,event,without){
        var parnetNode = dom.firstChild.firstChild;
        var span = document.createElement("span");
 	    
		for(var i = 0;i < objs.length;i++){    
			eval("var filedName = objs[i]." + fName);
			eval("var filedId = objs[i]." + fId);
			var input = document.createElement("input");
			var lab = document.createElement("label");
			var txt = document.createTextNode(filedName);
			
			input.setAttribute("type",type);
			input.setAttribute("name",name);
			input.setAttribute("id",name+filedId);
			input.setAttribute("value",filedId);
			input.setAttribute("onClick","javascript:"+ event +"(this)");
			input.setAttribute("checked",true);
			lab.appendChild(txt);
			lab.setAttribute("style","cursor: pointer;");
			lab.setAttribute("for", name+filedId);

			var index = without.indexOf(filedId);
			if(index == -1){
				span.appendChild(input);
				span.appendChild(lab);				
			}
		}

		parnetNode.appendChild(span);
}	

MyUtils.prototype.getCheckBoxValues=function(parnetObjName,mode) {
	var i = [];
	var j = 0; 
	var inputs = Ext.fly(parnetObjName).dom.firstChild.firstChild.getElementsByTagName("input");
	inputs = $A(inputs); 
	inputs.each(function(ip){
		 if(mode == 0 && ip.value !='on') i[j++] = ip.value;
		 if(mode == 1 && ip.value !='on') if( ip.checked) i[j++] = ip.value;
		 if(mode == 2 && ip.value !='on') if(!ip.checked) i[j++] = ip.value;
		}
	);	
	return i;
}


MyUtils.prototype.FormatDateTime = function(second,type) {
 		var dd,hh,mm,ss;
        second = typeof second === 'string' ? parseInt(second) : second;
        if(!second || second < 0){
            return;
        }
        //天
        dd = second / (24 * 3600) | 0;
        second = Math.round(second) - dd * 24 * 3600;
        //小时
        hh = second / 3600 | 0;
        second = Math.round(second) - hh * 3600;
        //分
        mm = second / 60 | 0;
        //秒
        ss = Math.round(second) - mm * 60;
        if(type ==1){
	        if(Math.round(dd) < 10){
	            dd = dd > 0 ? '0' + dd : '';
	        }
        }else{
	        if(Math.round(dd) > 0){
	            hh = hh+dd*24;
	        }
        }

        if(Math.round(hh) < 10){
            hh = '0' + hh;
        }
        if(Math.round(mm) < 10){
            mm = '0' + mm;
        }
        if(Math.round(ss) < 10){
            ss = '0' + ss;
        }
        if(type ==1){
        	        return dd + ' ' + hh + ':' + mm + ':' + ss;	
        }else{
        	        return  hh + ':' + mm + ':' + ss;	
        }

}
MyUtils.prototype.getTreeGrid =function(dwrMethod,columns,dataIn){

		var treeload = new Ext.ux.tree.TreeGridLoader({
			dwrMethod: dwrMethod,
			params: dataIn
		});
  
		var treeGrid = new Ext.ux.tree.TreeGrid({
			    height :500,
			    width:500,
			    border:false,
			    rootVisible:false, 
			    autoScroll:true, 
			    enableDD: true,
 				columns:columns, 
			    loader: treeload,
	 	});

   return treeGrid;
};
MyUtils.prototype.getArrayFromObjs = function(objs,indexColName,targColName,where){
	var v = new Array();
	for(var i =0 ;i<objs.length;i++){
		var obj = objs[i];
		eval("var value1=obj."+ indexColName);
		eval("var value2=obj."+ targColName);
		if(value1 == where) v.push(value2);
	}
	return v;
}
MyUtils.prototype.a=function(o){
	var ss='';
	for(var i in o){
		if(typeof(o[i])!='function')    
				ss+=i+':'+o[i]+'\n';
	}
	alert(ss);
};
a = MyUtils.prototype.a; 
getArrayFromObjs = MyUtils.prototype.getArrayFromObjs;