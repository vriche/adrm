
function DayInfoArray(){

	this.obj = {
		year:null,
		month:null,
		
	    day:null,
	    dayDate:null,
	    dayShort:null,
	    
	    adLength:null,
	    adUsedTime:null,
	    adTimes:null,
		adPrice:null,
		adSpecific:null,
	    adDayInfoId:null,
	    
	    resourceDayId:null,
	    rsTotalTime:null,
	    rsUsedTime:null,
	    rsSpecific:null,
	    rsAlert:null,
	    rsColor:null	    
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
DayInfoArray.prototype.reset = function(){
	this.obj.year = null;
  	this.obj.month = null;
  	
  	this.obj.day = null;
  	this.obj.dayDate = null;
  	this.obj.dayShort = null;
  	
  	this.obj.adLength = null;
  	this.obj.adUsedTime = null;
  	this.obj.adTimes = null;
  	this.obj.adPrice = null;
  	this.obj.adSpecific = null;
  	this.obj.adDayInfoId = null;
  	
  	this.obj.resourceDayId = null;
  	this.obj.rsTotalTime = null;
  	this.obj.rsUsedTime = null;
  	this.obj.rsSpecific = null;
  	this.obj.rsAlert = null;
  	this.obj.rsColor = null;
}	