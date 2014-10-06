

function OrderPublic(){
	//创建对象
	this.obj ={
		publishStartDate:null,
		publishEndDate:null,
	    times:null,
	    moneyBase:null,
	    moneyRealpay:null,
	    moneyIn:null

	}

	return this;
}

//清空对象
OrderPublic.prototype.reset = function(){
	this.obj.publishStartDate = null;
  	this.obj.publishEndDate = null;
  	this.obj.times = null;
  	this.obj.moneyBase = null;
  	this.obj.moneyRealpay = null;
  	this.obj.moneyIn = null;
}

OrderPublic.prototype.backupObject = function(sourObj,targObj){
	targObj.publishStartDate = sourObj.publishStartDate;
  	targObj.publishEndDate = sourObj.publishEndDate;
  	targObj.times = sourObj.times;
  	targObj.moneyBase = sourObj.moneyBase;
  	targObj.moneyRealpay = sourObj.moneyRealpay;
  	targObj.moneyIn = sourObj.moneyIn;
  	return 	targObj;

}