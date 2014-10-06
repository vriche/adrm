
function MyDate(){
	this.dateFormat = "yyyyMMdd";
	this.dftDate = new Date();
	this.today = this.getToday(); 
	this.curDate = this.getdefaultDate("yyyyMMdd");
	this.startDay = this.curDate;
	this.endDay = this.curDate;
	return this;
}

MyDate.prototype.getdefaultDate = function(fmt){
	var df;
	if (isUndefined(fmt)){
		df = this.formatDate(this.dftDate,this.dateFormat);
	}else{
		df = this.formatDate(this.dftDate,fmt);
	}
	return df;
}

MyDate.prototype.getToday = function(){
	 var today = []; 
	 today[0] = this.dftDate.getFullYear();
	 today[1] = this.dftDate.getMonth()+1;
	 today[2] = this.dftDate.getDate();	
	  
	 var monthStrLength = today[1].toString().length;
	 var dateStrLength = today[2].toString().length;
	 if (monthStrLength < 2){today[1] = '0'+ today[1]}
	 if (dateStrLength < 2) {today[2] = '0'+ today[2]}
  
	 return today
}

MyDate.prototype.yearFirstDay = function(year){
	 
	 var d = new Date(year,"0","1");
	 return this.formatDate(d,this.dateFormat);
}

MyDate.prototype.yearLastDay = function(year){
	 var d = new Date(year,"11","31");
	 return this.formatDate(d,this.dateFormat);
}


MyDate.prototype.getNextMonthDay = function(date){
	 var dt = this.getDateFromFormat(date,this.dateFormat);
	 var d = new Date(dt);
	 var month = d.getMonth()+1;
	 if (month == 12){ 
       alert("已是最后一个月，不能再增加！") ;
       return false;
     }
     var monthDays = d.getMonthDays(month);
     var dd = new Date(d.getFullYear(),month++,monthDays);
	 return this.formatDate(dd,this.dateFormat);
}


MyDate.prototype.getYear = function(date){
	 var dt = this.getDateFromFormat(date,this.dateFormat);
	 var d = new Date(dt);
	 return  d.getFullYear();
}
MyDate.prototype.getMonth = function(date){
	 var dt = this.getDateFromFormat(date,this.dateFormat);
	 var d = new Date(dt);
     var df = this.formatDate(d,"yyyyMMdd");
	 return  df.toString().substring(4,6);
}
MyDate.prototype.getDay = function(date){
	 var dt = this.getDateFromFormat(date,this.dateFormat);
	 var d = new Date(dt);
     var df = this.formatDate(d,"yyyyMMdd");
	 return  df.toString().substring(6,8);
}


MyDate.prototype.getStartDay = function(date){
	 date = (date == null)? this.curDate:date;
     var dt = this.getDateFromFormat(date,this.dateFormat);
     var d = new Date(dt);
	 return this.formatDate(d,"yyyyMM01");
}

MyDate.prototype.getEndDay = function(date){
     date = (date == null)? this.curDate:date;
     var dt = this.getDateFromFormat(date,this.dateFormat);
     var d = new Date(dt);
     var year = d.getFullYear();
     var month = d.getMonth();
     var lastDay = d.getMonthDays(month);
     var endDay = new Date(year,month,lastDay);
	 return this.formatDate(endDay,this.dateFormat);
}
MyDate.prototype.getStartDay2 = function(d){
	 return this.formatDate(d,"yyyyMM01");
}

MyDate.prototype.getStartDay3 = function(d,fmt){
	 return this.formatDate(d,fmt);
}


MyDate.prototype.getEndDay2 = function(d){
     var year = d.getFullYear();
     var month = d.getMonth();
     var lastDay = this.getMonthDays2(year,month+1);
     var endDay = new Date(year,month,lastDay);
//     var endDay = this.parseDate(year+'-'+(month+1) +'-'+lastDay)
      return this.formatDate(endDay,this.dateFormat);
//	 return this.formatDate(endDay,this.dateFormat);
}

MyDate.prototype.getEndDay3 = function(d,fmt){
     var year = d.getFullYear();
     var month = d.getMonth();
     var lastDay = this.getMonthDays2(year,month+1);
     var endDay = new Date(year,month,lastDay);
     return this.formatDate(endDay,fmt);
}

MyDate.prototype.getNewDayStartDay = function(date,m){
     var dt = this.getDateFromFormat(date,this.dateFormat);
     var d = new Date(dt);
     var year = d.getFullYear();
     var month = m -1;
     var firstDay = 1;
     var startDay = new Date(year,month,firstDay);
	 return this.formatDate(startDay,this.dateFormat);
}

MyDate.prototype.getNewDayStartDay1 = function(date){
	return this.getNewDayStartDay(date,date.substring(4,6)*1)
}

MyDate.prototype.getNewDayEndDay = function(date,m){
     var dt = this.getDateFromFormat(date,this.dateFormat);
     var d = new Date(dt);
     var year = d.getFullYear();
     var month = m -1;
     var lastDay = d.getMonthDays(month);
     var endDay = new Date(year,month,lastDay);
	 return this.formatDate(endDay,this.dateFormat);
}
MyDate.prototype.getNewDayEndDay1 = function(date){
	return this.getNewDayEndDay(date,date.substring(4,6)*1)
}


MyDate.prototype.isDate = function(val,format) {
	var date=getDateFromFormat(val,format);
	if (date==0) { return false; }
	return true;
	}

// -------------------------------------------------------------------
// compareDates(date1,date1format,date2,date2format)
//   Compare two date strings to see which is greater.
//   Returns:
//   1 if date1 is greater than date2
//   0 if date2 is greater than date1 of if they are the same
//  -1 if either of the dates is in an invalid format
// -------------------------------------------------------------------
MyDate.prototype.compareDates = function(date1,dateformat1,date2,dateformat2) {
	var d1=getDateFromFormat(date1,dateformat1);
	var d2=getDateFromFormat(date2,dateformat2);
	if (d1==0 || d2==0) {
		return -1;
		}
	else if (d1 > d2) {
		return 1;
		}
	return 0;
}





MyDate.prototype.formatDate = function(date,format) {
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
}


MyDate.prototype.myFormatDate  = function(v,format) {
	
	

if(typeof v == 'string') v = parseDate(v);  
if(v instanceof Date){  
	var y = v.getFullYear();  
	var m = v.getMonth() + 1;  
	var d = v.getDate();  
	var h = v.getHours();  
	var i = v.getMinutes();  
	var s = v.getSeconds();  
	var ms = v.getMilliseconds();
	if(format == this.dateFormat){
		if (m.toString().length < 2){m = '0'+ m}
	    if (d.toString().length < 2) {d = '0'+ d}
		return y + '' + m + '' + d;  	
	}else{
		if(ms>0) return y + '-' + m + '-' + d + ' ' + h + ':' + i + ':' + s + '.' + ms;  
		if(h>0 || i>0 || s>0) return y + '-' + m + '-' + d + ' ' + h + ':' + i + ':' + s;  
		return y + '-' + m + '-' + d;  		
	}

  }  

return '';  	
}


	
// ------------------------------------------------------------------
// getDateFromFormat( date_string , format_string )
//
// This function takes a date string and a format string. It matches
// If the date string matches the format string, it returns the 
// getTime() of the date. If it does not match, it returns 0.
// ------------------------------------------------------------------
MyDate.prototype.getDateFromFormat  = function(val,format) {
	val=val+"";
	format=format+"";
	var i_val=0;
	var i_format=0;
	var c="";
	var token="";
	var token2="";
	var x,y;
	var now=new Date();
	var year=now.getFullYear();
	var month=now.getMonth()+1;
	var date=1;
	var hh=now.getHours();
	var mm=now.getMinutes();
	var ss=now.getSeconds();
	var ampm="";
	
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
	}

// ------------------------------------------------------------------
// parseDate( date_string [, prefer_euro_format] )
//
// This function takes a date string and tries to match it to a
// number of possible date formats to get the value. It will try to
// match against the following international formats, in this order:
// y-M-d   MMM d, y   MMM d,y   y-MMM-d   d-MMM-y  MMM d
// M/d/y   M-d-y      M.d.y     MMM-d     M/d      M-d
// d/M/y   d-M-y      d.M.y     d-MMM     d/M      d-M
// A second argument may be passed to instruct the method to search
// for formats like d/M/y (european format) before M/d/y (American).
// Returns a Date object or null if no patterns match.
// ------------------------------------------------------------------
MyDate.prototype.parseDate  = function(val) {
	var preferEuro=(arguments.length==2)?arguments[1]:false;
	generalFormats=new Array('y-M-d','MMM d, y','MMM d,y','y-MMM-d','d-MMM-y','MMM d');
	monthFirst=new Array('M/d/y','M-d-y','M.d.y','MMM-d','M/d','M-d');
	dateFirst =new Array('d/M/y','d-M-y','d.M.y','d-MMM','d/M','d-M');
	var checkList=new Array('generalFormats',preferEuro?'dateFirst':'monthFirst',preferEuro?'monthFirst':'dateFirst');
	var d=null;
	for (var i=0; i<checkList.length; i++) {
		var l=window[checkList[i]];
		for (var j=0; j<l.length; j++) {
			d=getDateFromFormat(val,l[j]);
			if (d!=0) { return new Date(d); }
			}
		}
	return null;
	}


MyDate.prototype.mInList = function(pYear,slist) {
	   var ss1=","+s1+",";
	   var ss2=","+slist+",";
	   ss1 = ss1.toLowerCase();
	   ss2 = ss2.toLowerCase();
	   return ss2.indexOf(ss1)!=-1;	
}
MyDate.prototype.getMonthDays2 = function(pYear,pMonth) {
	

		//判断某年是否是闰年
	function m_IsLeap(pYear){
	    if(pYear % 400 == 0){
	        return true;
	    }
	    else if((pYear % 100 != 0) && (pYear % 4 == 0)){
	        return true;
	    }
	    return false;
	}
	
	//判断是否在字符串列表里：
	// if(mInList("3","1,3,5,7,8,10,12")){   //true
	// if(mInList("2","1,3,5,7,8,10,12")){   //false
	
	function mInList(s1,slist){
	   var ss1=","+s1+",";
	   var ss2=","+slist+",";
	   ss1 = ss1.toLowerCase();
	   ss2 = ss2.toLowerCase();
	   return ss2.indexOf(ss1)!=-1;
	}
	
	
	
    var nDays = 30;
    if(pMonth==2){    //2月单独处理
        if(m_IsLeap(pYear)) nDays = 29;
        else nDays = 28;
    }
    else if(mInList(pMonth,"1,3,5,7,8,10,12")){
        nDays = 31;   
    }
    return nDays;
};

/**
     * @param {} second
     * @return {}
     * @desc 秒转化成dd hh:mm:ss
     */
MyDate.prototype.FormatDate2 = function(second,type) {
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



Date.prototype.pattern=function(fmt) {          //日期格式化函数
    var o = {        
    "M+" : this.getMonth()+1, //月份        
    "d+" : this.getDate(), //日        
    "h+" : this.getHours() == 0 ? 12 : this.getHours(), //小时        
    "H+" : this.getHours(), //小时        
    "m+" : this.getMinutes(), //分        
    "s+" : this.getSeconds(), //秒        
    "q+" : Math.floor((this.getMonth()+3)/3), //季度        
    "S" : this.getMilliseconds() //毫秒        
    };        
    var week = {        
    "0" : "\u65e5",        
    "1" : "\u4e00",        
    "2" : "\u4e8c",        
    "3" : "\u4e09",        
    "4" : "\u56db",        
    "5" : "\u4e94",        
    "6" : "\u516d"       
    };        
    if(/(y+)/.test(fmt)){        
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));        
    }        
    if(/(E+)/.test(fmt)){        
        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "\u661f\u671f" : "\u5468") : "")+week[this.getDay()+""]);        
    }        
    for(var k in o){        
        if(new RegExp("("+ k +")").test(fmt)){        
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));        
        }        
    }        
    return fmt;        
} 






// BEGIN: DATE OBJECT PATCHES


//
//
//
//
///** Adds the number of days array to the Date object. */
//Date._MD = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
//
///** Constants used for time computations */
//Date.SECOND = 1000 /* milliseconds */;
//Date.MINUTE = 60 * Date.SECOND;
//Date.HOUR = 60 * Date.MINUTE;
//Date.DAY = 24 * Date.HOUR;
//Date.WEEK = 7 * Date.DAY;
//
//Date.parseDate = function(str, fmt) {
//	var today = new Date();
//	var y = 0;
//	var m = -1;
//	var d = 0;
//	var a = str.split(/\W+/);
//	var b = fmt.match(/%./g);
//	var i = 0, j = 0;
//	var hr = 0;
//	var min = 0;
//	for (i = 0; i < a.length; ++i) {
//		if (!a[i])
//			continue;
//		switch (b[i]) {
//			case "%d":
//			case "%e":
//				d = parseInt(a[i], 10);
//				break;
//
//			case "%m":
//				m = parseInt(a[i], 10) - 1;
//				break;
//
//			case "%Y":
//			case "%y":
//				y = parseInt(a[i], 10);
//				(y < 100) && (y += (y > 29) ? 1900 : 2000);
//				break;
//
//			case "%b":
//			case "%B":
//				for (j = 0; j < 12; ++j) {
//					if (Calendar._MN[j].substr(0, a[i].length).toLowerCase() == a[i].toLowerCase()) {
//						m = j;
//						break;
//					}
//				}
//				break;
//
//			case "%H":
//			case "%I":
//			case "%k":
//			case "%l":
//				hr = parseInt(a[i], 10);
//				break;
//
//			case "%P":
//			case "%p":
//				if (/pm/i.test(a[i]) && hr < 12)
//					hr += 12;
//				else if (/am/i.test(a[i]) && hr >= 12)
//					hr -= 12;
//				break;
//
//			case "%M":
//				min = parseInt(a[i], 10);
//				break;
//		}
//	}
//	if (isNaN(y)) y = today.getFullYear();
//	if (isNaN(m)) m = today.getMonth();
//	if (isNaN(d)) d = today.getDate();
//	if (isNaN(hr)) hr = today.getHours();
//	if (isNaN(min)) min = today.getMinutes();
//	if (y != 0 && m != -1 && d != 0)
//		return new Date(y, m, d, hr, min, 0);
//	y = 0;
//	m = -1;
//	d = 0;
//	for (i = 0; i < a.length; ++i) {
//		if (a[i].search(/[a-zA-Z]+/) != -1) {
//			var t = -1;
//			for (j = 0; j < 12; ++j) {
//				if (Calendar._MN[j].substr(0, a[i].length).toLowerCase() == a[i].toLowerCase()) {
//					t = j;
//					break;
//				}
//			}
//			if (t != -1) {
//				if (m != -1) {
//					d = m + 1;
//				}
//				m = t;
//			}
//		} else if (parseInt(a[i], 10) <= 12 && m == -1) {
//			m = a[i] - 1;
//		} else if (parseInt(a[i], 10) > 31 && y == 0) {
//			y = parseInt(a[i], 10);
//			(y < 100) && (y += (y > 29) ? 1900 : 2000);
//		} else if (d == 0) {
//			d = a[i];
//		}
//	}
//	if (y == 0)
//		y = today.getFullYear();
//	if (m != -1 && d != 0)
//		return new Date(y, m, d, hr, min, 0);
//	return today;
//};
//
//
//
//
//
///** Returns the number of days in the current month */
//Date.prototype.getMonthDays = function(month) {
//	var year = this.getFullYear();
//	if (typeof month == "undefined") {
//		month = this.getMonth();
//	}
//	if (((0 == (year % 4)) && ( (0 != (year % 100)) || (0 == (year % 400)))) && month == 1) {
//		return 29;
//	} else {
//		return Date._MD[month];
//	}
//};
//
///** Returns the number of day in the year. */
//Date.prototype.getDayOfYear = function() {
//	var now = new Date(this.getFullYear(), this.getMonth(), this.getDate(), 0, 0, 0);
//	var then = new Date(this.getFullYear(), 0, 0, 0, 0, 0);
//	var time = now - then;
//	return Math.floor(time / Date.DAY);
//};
//
///** Returns the number of the week in year, as defined in ISO 8601. */
//Date.prototype.getWeekNumber = function() {
//	var d = new Date(this.getFullYear(), this.getMonth(), this.getDate(), 0, 0, 0);
//	var DoW = d.getDay();
//	d.setDate(d.getDate() - (DoW + 6) % 7 + 3);
//	// Nearest Thu
//	var ms = d.valueOf();
//	// GMT
//	d.setMonth(0);
//	d.setDate(4);
//	// Thu in Week 1
//	return Math.round((ms - d.valueOf()) / (7 * 864e5)) + 1;
//};
//
///** Checks date and time equality */
//Date.prototype.equalsTo = function(date) {
//	return ((this.getFullYear() == date.getFullYear()) &&
//			(this.getMonth() == date.getMonth()) &&
//			(this.getDate() == date.getDate()) &&
//			(this.getHours() == date.getHours()) &&
//			(this.getMinutes() == date.getMinutes()));
//};
//
///** Set only the year, month, date parts (keep existing time) */
//Date.prototype.setDateOnly = function(date) {
//	var tmp = new Date(date);
//	this.setDate(1);
//	this.setFullYear(tmp.getFullYear());
//	this.setMonth(tmp.getMonth());
//	this.setDate(tmp.getDate());
//};
//
///** Prints the date in a string according to the given format. */
//Date.prototype.print = function (str) {
//	var m = this.getMonth();
//	var d = this.getDate();
//	var y = this.getFullYear();
//	var wn = this.getWeekNumber();
//	var w = this.getDay();
//	var s = {};
//	var hr = this.getHours();
//	var pm = (hr >= 12);
//	var ir = (pm) ? (hr - 12) : hr;
//	var dy = this.getDayOfYear();
//	if (ir == 0)
//		ir = 12;
//	var min = this.getMinutes();
//	var sec = this.getSeconds();
//	s["%a"] = Calendar._SDN[w];
//	// abbreviated weekday name [FIXME: I18N]
//	s["%A"] = Calendar._DN[w];
//	// full weekday name
//	s["%b"] = Calendar._SMN[m];
//	// abbreviated month name [FIXME: I18N]
//	s["%B"] = Calendar._MN[m];
//	// full month name
//	// FIXME: %c : preferred date and time representation for the current locale
//	s["%C"] = 1 + Math.floor(y / 100);
//	// the century number
//	s["%d"] = (d < 10) ? ("0" + d) : d;
//	// the day of the month (range 01 to 31)
//	s["%e"] = d;
//	// the day of the month (range 1 to 31)
//	// FIXME: %D : american date style: %m/%d/%y
//	// FIXME: %E, %F, %G, %g, %h (man strftime)
//	s["%H"] = (hr < 10) ? ("0" + hr) : hr;
//	// hour, range 00 to 23 (24h format)
//	s["%I"] = (ir < 10) ? ("0" + ir) : ir;
//	// hour, range 01 to 12 (12h format)
//	s["%j"] = (dy < 100) ? ((dy < 10) ? ("00" + dy) : ("0" + dy)) : dy;
//	// day of the year (range 001 to 366)
//	s["%k"] = hr;
//	// hour, range 0 to 23 (24h format)
//	s["%l"] = ir;
//	// hour, range 1 to 12 (12h format)
//	s["%m"] = (m < 9) ? ("0" + (1 + m)) : (1 + m);
//	// month, range 01 to 12
//	s["%M"] = (min < 10) ? ("0" + min) : min;
//	// minute, range 00 to 59
//	s["%n"] = "\n";
//	// a newline character
//	s["%p"] = pm ? "PM" : "AM";
//	s["%P"] = pm ? "pm" : "am";
//	// FIXME: %r : the time in am/pm notation %I:%M:%S %p
//	// FIXME: %R : the time in 24-hour notation %H:%M
//	s["%s"] = Math.floor(this.getTime() / 1000);
//	s["%S"] = (sec < 10) ? ("0" + sec) : sec;
//	// seconds, range 00 to 59
//	s["%t"] = "\t";
//	// a tab character
//	// FIXME: %T : the time in 24-hour notation (%H:%M:%S)
//	s["%U"] = s["%W"] = s["%V"] = (wn < 10) ? ("0" + wn) : wn;
//	s["%u"] = w + 1;
//	// the day of the week (range 1 to 7, 1 = MON)
//	s["%w"] = w;
//	// the day of the week (range 0 to 6, 0 = SUN)
//	// FIXME: %x : preferred date representation for the current locale without the time
//	// FIXME: %X : preferred time representation for the current locale without the date
//	s["%y"] = ('' + y).substr(2, 2);
//	// year without the century (range 00 to 99)
//	s["%Y"] = y;
//	// year with the century
//	s["%%"] = "%";
//	// a literal '%' character
//
//	var re = /%./g;
//	if (!Calendar.is_ie5 && !Calendar.is_khtml)
//		return str.replace(re, function (par) {
//			return s[par] || par;
//		});
//
//	var a = str.match(re);
//	for (var i = 0; i < a.length; i++) {
//		var tmp = s[a[i]];
//		if (tmp) {
//			re = new RegExp(a[i], 'g');
//			str = str.replace(re, tmp);
//		}
//	}
//
//	return str;
//};
//
//Date.prototype.__msh_oldSetFullYear = Date.prototype.setFullYear;
//Date.prototype.setFullYear = function(y) {
//	var d = new Date(this);
//	d.__msh_oldSetFullYear(y);
//	if (d.getMonth() != this.getMonth())
//		this.setDate(28);
//	this.__msh_oldSetFullYear(y);
//};