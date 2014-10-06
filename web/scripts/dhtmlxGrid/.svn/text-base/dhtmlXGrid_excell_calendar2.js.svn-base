/*
Copyright Scand LLC http://www.scbr.com
This version of Software is free for using in GNU GPL applications. For other use or to get Professional Edition please contact info@scbr.com to obtain license
*/ 

function eXcell_calendar(cell){
 try{
	 this.cell = cell;
	 this.grid = this.cell.parentNode.grid;
	 this.daFormat="Y/m/d";
	 
	 var myCell = this.cell;
	 var OBJ = this;
	 this.uuuu = function(){
//	 	 if(myCell._cediton)myCell._cediton=false;
//		 else return;
		 myCell._cediton=false;
		 
		 if(OBJ.val!=OBJ.getValue()){
 			myCell.wasChanged = true;
		 }
 		 var z=window.calendar.date;
		 window.calendar.hide();
		 if(!z.getFullYear())return;
//		 myCell.val=new Date(z.valueOf());
		 myCell.val= OBJ._date2str(z);
		 OBJ.setCValue(OBJ._date2str(z),z);
		 myCell.innerHTML = OBJ._date2str(z);
		
	
//		 alert(OBJ._date2str(z));
//		 return OBJ.val.valueOf()!=z.valueOf();
		
	}
//     

//	 var tt = this;
	 
	 Calendar.setup({
			inputField  : this.cell,	  // id of the input field
	//		ifFormat	: "%Y%m%d",	  // the date format
	        daFormat: "%Y/%m/%d",
	        eventName:"dblclick",
//	        range:[theYear],
//	        firstDay:1,
//			showsTime:true,
            onClose:this.uuuu,
			singleClick	  : true
//			position: this.grid.getPosition(this.cell)+this.cell.offsetHeight
//			onSelect:function(){ tt.cell.innerHTML = this.date.print(this.params.daFormat);this.hide();}
//			onClose:function(){ tt.cell.innerHTML = this.date.print(this.params.daFormat);this.hide();}
		});    
		

 
 
}catch(er){}

	this.isDateSimple = function(v){
		var dt = new Date(v);
		if(isNaN(dt)){return false;}else{return true;}
	}
	
	this.edit = function(){
	    var pval=this.cell.val||new Date();
        pval =''+pval;
		var d =  new   Date(Date.parse(pval.replace(/-/g,   "/")));   
		window.calendar.setDate(d);
		var arPos = this.grid.getPosition(this.cell);
		window.calendar.showAt(arPos[0], arPos[1]+ this.cell.offsetHeight);
		this.cell._cediton=true;
		this.val=this.cell.val;
	}

	this.getValue = function(){
		if(this.cell.val)return this.cell.val;
		return this.cell.innerHTML.toString()._dhx_trim()
		
	}
	


	this.parseDate = function(str, fmt) {

		if (!fmt)
			fmt = this.dateFormat;
		return Date.parseDate(str, fmt);
	}
	 this.detach = function(){

		 if(this.cell._cediton)this.cell._cediton=false;
		 else return;
		 var z=window.calendar.date;
		 window.calendar.hide();
		 if(!z.getFullYear())return;
		
		 this.cell.val=new Date(z.valueOf());
		 this.setCValue(this._date2str(z),z);
		 return this.val.valueOf()!=z.valueOf();
	}
		
	 this._2dg=function(val){
		 if(val.toString().length==1)
		 return("0"+val.toString());
		 return val;
	}
	 this._date2str2=function(z){
	 	return("y/m/d").replace("m",this._2dg((z.getMonth()*1+1))).replace("d",this._2dg(z.getDate())).replace("y",this._2dg((z.getFullYear()*1)));
	}
	 this._date2str=function(z){
	 	return(this.grid._dtmask||"y/m/d").replace("m",this._2dg((z.getMonth()*1+1))).replace("d",this._2dg(z.getDate())).replace("y",this._2dg((z.getFullYear()*1)));
	}	
	

}
eXcell_calendar.prototype = new eXcell;

eXcell_calendar.prototype.setValue = function(val){

	if(!val || val.toString()._dhx_trim()=="") val="";
		 this.cell.val=val.toString();
		 if(this.cell.val=="NaN"){
		 this.cell.val="";
		 this.cell.innerHTML="&nbsp;";
	}else if(this.cell.val==""){
		this.cell.val="";
		this.cell.innerHTML="&nbsp;";
	}else{
	 this.cell.innerHTML = this.cell.val;
	}

}
