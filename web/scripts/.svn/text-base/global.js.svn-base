	/////////////////////////////////////////////////// 
//时间信息
//////////////////////////////////////////////////
  

  
  today=[]; 
  var dftDate = new Date ();
  
  today[0] = dftDate.getFullYear();
  today[1] = dftDate.getMonth()+1;
  today[2] = dftDate.getDate();

  var monthStrLength = today[1].toString().length;
  var dateStrLength = today[2].toString().length;
  if (monthStrLength < 2){today[1] = '0'+ today[1]}
  if (dateStrLength < 2) {today[2] = '0'+ today[2]}
    
  theYear  =  today[0];
  theMonth =  today[1];
  theDay   =  today[2];
  

  curDate = theYear +''+  theMonth +''+theDay;
  

  
  
function getCtxPath(){
	var localObj = window.location;
	var contextPath = localObj.pathname.split("/")[1];
	return '/'+ contextPath +'/';
	
//	var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
//	var server_context=basePath;
}

//function alert(msg){
////    Ext.Msg.minWidth = 230;
//	msg = msg +'<br>';
//	Ext.MessageBox.alert('系统提示','<font color="red">'+ msg +'</font>');
//}


 function extjMessage(msg){
	Ext.MessageBox.hide(); 
	return Ext.MessageBox.show(
			 	{title:'系统提示',msg:msg,width:300,heigth:270,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
	);   
};
  
  
function TimeDiff(start){
    var end = new Date().getTime();
//    var cc = Number((end-start)/1000).toFixed(2);
     var cc = Number(end-start);
	alert("时间间隔为: "+ cc +"ns秒");
}

function myFormatDate(intDate){
	intDate = intDate.substring(0,4)+"/" + intDate.substring(4,6)+"/" + intDate.substring(6,8)
	return intDate;
}
/* This function is used to change the style class of an element */
	function button_showdate(targName,targName2){
	//			var cal1 = new CalendarPopup();
				var cal18 = new CalendarPopup("testdiv1");
				cal18.showNavigationDropdowns;
	//			cal18.setCssPrefix("TEST");
				var targ = $(targName);
				var title = cal18.select(targ,targName2,'yyyyMMdd'); 
				$(targName2).setAttribute("title",title);
	            cal18.select(targ,targName2,'yyyyMMdd'); 
	            return false; 
	}
	


	function button_showdate_input(event){
		var e = event || window.event;
		var obj = Event.element(e);
		var inputName = obj.getAttribute("name");
		var spanName = obj.getAttribute("spanName");
		button_showdate(inputName,spanName);
	}
	
	function button_showdate_input_edit(obj){
		var inputName = obj.getAttribute("name");
		var spanName = obj.getAttribute("spanName");
		button_showdate(inputName,spanName);
	}

   function makeDateInputText(inputName,spanName,value,evt){
   	    var body  = document.createElement("span");
		var input  = document.createElement("input");
		input.setAttribute("readonly","true");
		input.setAttribute("type","text");
		input.setAttribute("name",inputName);
		input.setAttribute("id",inputName);
		input.setAttribute("value",value);
		input.setAttribute("spanName",spanName);
		if(evt !='' && !isUndefined(evt)){input.onclick = evt;}
		input.style.cssText = "width:96%;aling:center;border:none;text-align:left;cursor:hand;";
		var span  = document.createElement("span");
		span.setAttribute("name",spanName);span.setAttribute("id",spanName);
		body.appendChild(input);body.appendChild(span);
		return body;
   }	
   
   function makeDateInputTextHmtl(inputName,spanName,value,evt){
   	    var body  = document.createElement("span");
		var input  = document.createElement("input");
		input.setAttribute("readonly","true");
		input.setAttribute("type","text");
		input.setAttribute("name",inputName);
		input.setAttribute("id",inputName);
		input.setAttribute("value",value);
		input.setAttribute("spanName",spanName);
		input.setAttribute("onClick","javascript:"+ evt +"(this)");
		input.style.cssText = "width:96%;aling:center;border:none;text-align:left;cursor:hand;";
		var span  = document.createElement("span");
		span.setAttribute("name",spanName);span.setAttribute("id",spanName);
		body.appendChild(input);body.appendChild(span);
		return body;
   }	
   
   function makeDateInputTextTd(inputName,spanName,value,evt){
   		var td = document.createElement("td");  
		var input  = document.createElement("input");
		input.setAttribute("readonly","true");
		input.setAttribute("type","text");
		input.setAttribute("name",inputName);
		input.setAttribute("id",inputName);
		input.setAttribute("value",value);
		input.setAttribute("spanName",spanName);
		if(evt !='' && !isUndefined(evt)){input.onclick = evt;}
		input.style.cssText = "width:96%;aling:center;border:none;text-align:left;cursor:hand;";
		var span  = document.createElement("span");
		span.setAttribute("name",spanName);span.setAttribute("id",spanName);
		td.appendChild(input);td.appendChild(span);
		return td;
   }	
   
      function makeTdByObj(obj){
   		var td = document.createElement("td");  
   		obj.setAttribute("style","overflow: visible; width:100%;");
		td.appendChild(obj);
//		td.setAttribute("bgcolor","#FFFF33");
		return td;
   }	
   
       function makeTdByObj_test(obj,width){
   		var td = document.createElement("td");  
   		td.setAttribute("width",width);
   		obj.setAttribute("style","overflow: visible; width:100%;");
		td.appendChild(obj);
//		td.setAttribute("bgcolor","#FFFF33");
		return td;
   }	  
   
//      function makeSpanByObj(obj){
//   		var span = document.createElement("span");  
//		span.appendChild(obj);
//		span.setAttribute("bgcolor","#FFFF33");
////		alert(span);
//		return span;
//  	 }	
   	function formatDateGlobal(s){
   		if(s==''||s==""||s==0||s==null)return "";
		s =s+"";
		var year = s.substring(0,4);
		var month = s.substring(4,6);
		var day = s.substring(6,8);
//		s =  month +"/" + day;
		s = year+ "/" + month +"/" + day;
		return s;
	}
   function formatDateGlobal2(dftDate){
                if(dftDate==''||dftDate==""||dftDate==0||dftDate==null)return "";
		var s = dftDate.getFullYear()+ "-" + (dftDate.getMonth()*1+1) +"-" + dftDate.getDate()+" " +dftDate.getHours() +":" +dftDate.getMinutes();
		return s;
	} 
	
	function formatDateGlobal3(dftDate){
                if(dftDate==''||dftDate==""||dftDate==0||dftDate==null)return "";
                var mm = dftDate.getMonth()*1+1;
//                var dd = dftDate.getDate()+'';
                if(mm.length=1){mm = "0"+mm}
              
		var s = dftDate.getFullYear()+ "/" + mm +"/" + dftDate.getDate();
		return s;
	}
    function formatDateGlobal4(dftDate){
                if(dftDate==''||dftDate==""||dftDate==0||dftDate==null)return "";
		var s = dftDate.getFullYear()+ "/" + (dftDate.getMonth()*1+1) +"/" + dftDate.getDate()+" " +dftDate.getHours() +":" +dftDate.getMinutes();
		return s;
	}  
	
	    function formatDateGlobal5(dftDate){
                if(dftDate==''||dftDate==""||dftDate==0||dftDate==null)return "";
		var s = (dftDate.getMonth()*1+1) +"月" + dftDate.getDate()+" " +dftDate.getHours() +":" +dftDate.getMinutes();
		return s;
	}  
   
   function makeInputText(inputName,type,value,evt){
		var input  = document.createElement("input");
		input.setAttribute("type",type);
		input.setAttribute("name",inputName);
		input.setAttribute("id",inputName);
		input.setAttribute("value",value);
//		input.style.cssText = "width:98%;aling:center;border:none;text-align:left;cursor:pointer;";
		input.setAttribute("style","overflow: visible; width:100%;");
		
		if(evt !='' && !isUndefined(evt)){input.onclick = evt;}
		return input;
	}
	
	function makeInputTextTD_TEST(inputName,type,value,evt,width){
		var td = document.createElement("td");  
		td.setAttribute("width",width);
		var input  = document.createElement("input");
		input.setAttribute("type",type);
		input.setAttribute("name",inputName);
		input.setAttribute("id",inputName);
		input.setAttribute("value",value);
//		input.style.cssText = "width:98%;aling:center;border:none;text-align:left;cursor:pointer;";
		input.setAttribute("style","overflow: visible; width:100%;");
		
		if(evt !='' && !isUndefined(evt)){input.onclick = evt;}
		td.appendChild(input);
			
		return td;
	}
	
	  function makeInputText2(inputName,type,width,value,evt){
		var input  = document.createElement("input");
		input.setAttribute("type",type);
		input.setAttribute("name",inputName);
		input.setAttribute("id",inputName);
		input.setAttribute("value",value);
		input.setAttribute("size",width);
		//input.style.cssText = "aling:center;border:none;text-align:left;cursor:pointer;";
		if(evt !='' && !isUndefined(evt)){input.onclick = evt;}
		return input;
	}	
   function makeInputTextTd(inputName,type,width,value,evt){
   		var td = document.createElement("td");  
//   		td.setAttribute("width","100%");
		var input  = document.createElement("input");
		input.setAttribute("type",type);
		input.setAttribute("name",inputName);
		input.setAttribute("id",inputName);
		input.setAttribute("value",value);
		input.setAttribute("size",width);
//		input.setAttribute("style","overflow: visible; width:100%;");
		
		if(type=='checkbox') {
			if(value=='true')input.setAttribute("checked",value);	
		}		
		
//		input.style.cssText = "width:100%;aling:center;border:1px;text-align:left;cursor:hand;";
		if(evt !='' && !isUndefined(evt)){input.onclick = evt;}
		td.appendChild(input);

		return td;
	}	
	
	   function makeInputTextTdReadOnly(inputName,type,width,value,evt){
   		var td = document.createElement("td");  
//   		td.setAttribute("width","100%");
		var input  = document.createElement("input");
		input.setAttribute("type",type);
		input.setAttribute("name",inputName);
		input.setAttribute("id",inputName);
		input.setAttribute("value",value);
		input.setAttribute("size",width);
		input.setAttribute("disabled",true);
//		input.setAttribute("style","overflow: visible; width:100%;");
		
		if(type=='checkbox') {
			if(value=='true')input.setAttribute("checked",value);	
		}		
		
//		input.style.cssText = "width:100%;aling:center;border:1px;text-align:left;cursor:hand;";
		if(evt !='' && !isUndefined(evt)){input.onclick = evt;}
		td.appendChild(input);

		return td;
	}	
	
	function makeInputTextTd3(inputName,type,width,value,evt,left){
   		var td = document.createElement("td");  
//   		td.setAttribute("width","100%");
		var input  = document.createElement("input");
		input.setAttribute("type",type);
		input.setAttribute("name",inputName);
		input.setAttribute("id",inputName);
		input.setAttribute("value",value);
		input.setAttribute("size",width);
		if(left){
			input.setAttribute("style","overflow: visible; width:100%;text-align:left;");
		}else{
			input.setAttribute("style","overflow: visible; width:100%;text-align:center;");
		}
		
		
		if(type=='checkbox') {
			if(value=='true')input.setAttribute("checked",value);	
		}		
		
//		input.style.cssText = "width:100%;aling:center;border:1px;text-align:left;cursor:hand;";
		if(evt !='' && !isUndefined(evt)){input.onclick = evt;}
		td.appendChild(input);

		return td;
	}	
	
	
	function makeInputTextTd3Money(inputName,type,width,value,evt,read){
   		var td = document.createElement("td");  
//   		td.setAttribute("width","100%");
		var input  = document.createElement("input");
		input.setAttribute("type",type);
		input.setAttribute("name",inputName);
		input.setAttribute("id",inputName);
		input.setAttribute("value",value);
		input.setAttribute("size",width);
		if(read) input.setAttribute("readonly",read);
		input.setAttribute("style","overflow: visible; width:100%;text-align:right;");
//		input.setAttribute("onblur","isDigit2");
		input.onblur = isDigit2;
//	    input.attachEvent('onblur',isDigit2());
	

		
		if(evt !='' && !isUndefined(evt)){input.onclick = evt;}
		td.appendChild(input);

		return td;
	}	
	
	
   function makeRadioTd(inputName,type,width,value,evt){
   		var td = document.createElement("td");  

		var input  = document.createElement("input");
		input.setAttribute("type",type);
		input.setAttribute("name",inputName);
		input.setAttribute("id",inputName);
		
		
		if(value == 1) input.setAttribute("checked",true);
//		if(value == null) input.setAttribute("checked",false);
//		alert("value = " + value);
		input.setAttribute("value",value);
		input.setAttribute("size",width);
//		input.style.cssText = "width:100%;aling:center;border:1px;text-align:left;cursor:hand;";
		if(evt !='' && !isUndefined(evt)){input.onclick = evt;}
		td.appendChild(input);

		return td;
	}		
   function makeInputButtonTd(inputName,type,width,value,evt){
   		var td = document.createElement("td");  
//   		td.setAttribute("width","100%");
		var input  = document.createElement("input");
		input.setAttribute("type",type);
		input.setAttribute("name",inputName);
		input.setAttribute("id",inputName);
		input.setAttribute("value",value);
		if(value == 1|| value == "true" || value == true) input.setAttribute("checked",true);
//		input.setAttribute("width",width);
		input.setAttribute("onClick","javascript:"+ evt +"(this)");
//		if(evt !='' && !isUndefined(evt)){input.onclick = evt;}
		td.appendChild(input);

		return td;
	}	
	
	
   function makeInputCheckBox(inputName,type,idValue,value,evt){
		var input  = document.createElement("input");
		input.setAttribute("type",type);
		input.setAttribute("name",inputName);
		input.setAttribute("id",inputName);
		input.setAttribute("value",idValue);
		if(value == 1|| value == "true" || value == true) input.setAttribute("checked",true);
		if(evt) input.setAttribute("onClick","javascript:"+ evt +"(this)");

		return input;
	}		
	
	
	
   function makeTh(value){
   		var th = document.createElement("th");  
		th.innerHTML = value;
		return th;
	}	
   function makeTextTd(value){
   		var td = document.createElement("td");  
		td.innerHTML = value;
		return td;
	}		
   function makeImag(src,name,width,heigth,id,evt){
	    var img  = document.createElement("img");
		img.setAttribute("src",src);
		img.setAttribute("id",name);
		img.setAttribute("width",width);
		img.setAttribute("heigth",heigth);
		img.setAttribute("paraId",id);
		if(evt !='' && !isUndefined(evt)){img.onclick = evt;}
		return img;
   }	
   

   function makeImagHtml(src,name,width,heigth,id,evt){
	    var img  = document.createElement("img");
		img.setAttribute("src",src);
		img.setAttribute("id",name);
		img.setAttribute("width",width);
		img.setAttribute("heigth",heigth);
		img.setAttribute("paraId",id);
		img.setAttribute("onClick","javascript:"+ evt +"(this)");
		img.setAttribute("style","CURSOR: pointer;");
		return img;
   }
   
   function makeImagTd(src,name,width,heigth,id,evt){
   	    var td = document.createElement("td"); 
   	   
   	    
	    var img  = document.createElement("img");
		img.setAttribute("src",src);
		img.setAttribute("id",name);
		img.setAttribute("width",width);
		img.setAttribute("heigth",heigth);
		img.setAttribute("paraId",id);
		img.setAttribute("onClick","javascript:"+ evt +"(this)");
		img.setAttribute("style","CURSOR: pointer;");
//		td.setAttribute("onClick","javascript:"+ evt +"(this)");
		td.appendChild(img);
		return td;
   }	
   

		

   function makeTextTd(value){
   	    var td = document.createElement("td"); 
		td.innerHTML = value;
		return td;
   }

    function makeOptitions(inputName,type,value,evt,disabled){
		var input  = document.createElement("input");
		input.setAttribute("type",type);
		input.setAttribute("name",inputName);
		input.setAttribute("id",inputName);		
		input.setAttribute("disabled",disabled);	
		if(value == 1|| value == "true" || value == true) input.setAttribute("checked",true);
		input.setAttribute("onClick","javascript:"+ evt +"(this)");
		return input;
   }  
// function makeOptionsHtml(objs,type,name){
//		var html = "";
//		html += "<table width=\"100%\">";		
//		html += "<tr>";	
//		for(var i = 0;i < objs.length;i++){    
//			html += "<td>";	       
//			html += "<input type=\"" + type +"\"  name=\""+ name +"\" id=\""+  objs[i].name +"\" value=\"" + objs[i].id +"\">";	
//			html += "<label class=\"choice\" for=\""+ objs[i].name +"\">";	
//			html +=  objs[i].name;	
//			html += "</label>";	
//			html += "</td>";		
//		}
//		html += "</tr>";
//		html += "</table>";		
//		return 	html;
//}	
   
   
//function buildOptionsByObjs(ele,objs){
//	   if (objs == null) return;
//	 var text;
//     var value;
//     var s;
//	 for (var prop in objs) {
////	 	  text = objs[prop].replace(/\s+/g,"&nbsp;");
//	 	  text = objs[prop];
////	 	  console.log(text.match(/\s/g).length);
//          value = prop;
//       
//	      if (text || value) {
//	      	   s =  s + "<option  value='"+ value +"'><div style='width:200px'>"+ text +"</div></option>";
////	        opt = new Option(text, value);
////	        opt = new Option();
////	        opt.value = value;
////	        opt.text = text;
////	         console.log(text);
////	        console.log(opt.text);
////	        opt.setAttribute("style","font-size:12px;");
////	        ele.options[ele.options.length] = opt;
//	      }
//	 }
//	 ele.innerHTML = s;
//}   
       
function getOptionsItemsByObjs(objs,elName,fName,fId,without,defaultChecked){
	var items =[];
	for(var i = 0;i < objs.length;i++){    
				eval("var filedName = objs[i]." + fName);
				eval("var filedId = objs[i]." + fId);
				var index = without.indexOf(filedId);
				if(index == -1){
				   var obj =   {boxLabel: 'Item 1', name: 'rb-horiz', inputValue: 1};
				   
					obj.boxLabel = filedName;
					obj.name = elName;
					obj.inputValue = filedId;
					
					if(defaultChecked){
						if(defaultChecked == filedId)obj.checked = true;
					} 
					
		            items.push(obj);
		    }
	}
	return items;
}


 function makeOptionsHtml(objs,type,name,fName,fId,styleClass,event,without){
        var parnetNode = $(name).parentNode;
        
        var span = document.createElement("span");
        var isFined = false;
 	   
		for(var i = 0;i < objs.length;i++){    
//			alert(objs[i].name);
			eval("var filedName = objs[i]." + fName);
			eval("var filedId = objs[i]." + fId);
			var input = document.createElement("input");
			var lab = document.createElement("label");
			var txt = document.createTextNode(filedName);
			
			
			input.setAttribute("type",type);
			input.setAttribute("name",name);
//			if(!isFined &&  filedId>0)  {
//			
//			}else{
//				
//			}
			
			input.setAttribute("value",filedId);
			input.setAttribute("onClick","javascript:"+ event +"(this)");

//			lab.innerHTML = objs[i].name ;
			lab.appendChild(txt);
//			"choice" 竖排;
			lab.setAttribute("style","cursor: pointer;");

			if(!isFined &&  filedId>0) {
				input.setAttribute("id",name)
				lab.setAttribute("for", name);	
				input.checked = true;
				isFined = true;
			}else{
				input.setAttribute("id",name+filedId);
				lab.setAttribute("for", name+filedId);	
				
			}			

//			alert(objs[i].name);
		


			var index = without.indexOf(filedId);
			if(index == -1){
				span.appendChild(input);
				span.appendChild(lab);				
			}
		}
	    $(name).remove();
//	    alert(span.innerHTML);
		parnetNode.appendChild(span);
}	

function makeOptionsCheckBoxHtml(objs,type,name,fName,fId,styleClass,event,without){
        var parnetNode = $(name).parentNode;
        var span = document.createElement("span");
 	   
		for(var i = 0;i < objs.length;i++){    
//			alert(objs[i].name);
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
//			lab.innerHTML = objs[i].name ;
			lab.appendChild(txt);
//			"choice" 竖排;
//			lab.setAttribute("class",styleClass);
            if(styleClass !=""){
            	lab.setAttribute("class",styleClass);
            }else{
            	lab.setAttribute("style","cursor: pointer;");
            }
		
//			alert(objs[i].name);
			lab.setAttribute("for", name+filedId);

			var index = without.indexOf(filedId);
			if(index == -1){
				span.appendChild(input);
				span.appendChild(lab);				
			}
		}
	    $(name).remove();
//	    alert(span.innerHTML);
		parnetNode.appendChild(span);
}	






function getDayPar(shortDate,mode){
	if(mode == 'y') return shortDate.substring(0,4);
	if(mode == 'm') return shortDate.substring(4,6);
	if(mode == 'd') return shortDate.substring(6,8);	
}

function getFormatDay(shortDate,format){

	shortDate +='';
	var len = shortDate.length;
	if(len == 0)return null;
	var isFmtt = false;
	if(len > 8) isFmtt = true;
	var y =  shortDate.substring(0,4);
	var m =  isFmtt?shortDate.substring(5,7): shortDate.substring(4,6);
	var d =  isFmtt?shortDate.substring(8,10):shortDate.substring(6,8);
	var isY = format.indexOf("y") > -1;
	var isM = format.indexOf("m") > -1;
	var isD = format.indexOf("d") > -1;
	var sep = "";
	if(format.indexOf("-") > -1) sep="-";
	if(format.indexOf("/") > -1) sep="/";
	if(isY&&isM&&isD) shortDate = y + sep + m + sep + d;
	if(!isY&&isM&&isD) shortDate =  m + sep + d;
	if(isY&&!isM&&!isD) shortDate =  y;
	if(!isY&&isM&&!isD) shortDate =  m;
	if(!isY&&!isM&&isD) shortDate =  d;
	return shortDate;
}
//
//Date.prototype.pattern=function(fmt) {     
//    var o = {     
//    "M+" : this.getMonth()+1, //月份     
//    "d+" : this.getDate(), //日     
//    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时     
//    "H+" : this.getHours(), //小时     
//    "m+" : this.getMinutes(), //分     
//    "s+" : this.getSeconds(), //秒     
//    "q+" : Math.floor((this.getMonth()+3)/3), //季度     
//    "S" : this.getMilliseconds() //毫秒     
//    };     
//    var week = {     
//    "0" : "\u65e5",     
//    "1" : "\u4e00",     
//    "2" : "\u4e8c",     
//    "3" : "\u4e09",     
//    "4" : "\u56db",     
//    "5" : "\u4e94",     
//    "6" : "\u516d"    
//    };     
//    if(/(y+)/.test(fmt)){     
//        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));     
//    }     
//    if(/(E+)/.test(fmt)){     
//        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "\u661f\u671f" : "\u5468") : "")+week[this.getDay()+""]);     
//    }     
//    for(var k in o){     
//        if(new RegExp("("+ k +")").test(fmt)){     
//            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));     
//        }     
//    }     
//    return fmt;     
//}   

function getRadioValue(obj){
	var parnetObj = obj.parentNode;

	var inputs = $A(parnetObj.getElementsByTagName("input"));
    var value="";
	inputs.each(function(ip){
		if(ip.checked) value = ip.value;
		}
	);	
	return value;
}

function setRadioCheckedByValue(obj,selectIndex){
	var parnetObj = obj.parentNode;
	var inputs = $A(parnetObj.getElementsByTagName("input"));
	inputs.each(function(ip){
		if(ip.value == selectIndex) ip.checked = true;
		}
	);	

}
	  
  function makeSelectHtmlAnalyze(objs,name,event){
    var div = document.createElement("div");
    var span = document.createElement("span");
    var parnetNode = $(name).parentNode;
    
    div.setAttribute("style","position:relative;");
    span.setAttribute("style","margin-left:100px;width:18px;overflow:hidden;");
    
    DWRUtil.removeAllOptions(name);
	DWRUtil.addOptions(name, objs);
	var select = $(name);
	select.setAttribute("style","width:100px;margin-left:-100px;CURSOR: pointer;font-size:13px;");
//	select.setAttribute("style","width:138px;margin-left:-100px;CURSOR: pointer;");
	select.setAttribute("onChange","javascript:"+ event +"(this)");
	
	div.appendChild(span);
	span.appendChild(select);
	parnetNode.appendChild(div);
 }
 
  function makeSelectHtml(objs,name,event){
    var div = document.createElement("div");
    var span = document.createElement("span");
    var parnetNode = $(name).parentNode;
    
    div.setAttribute("style","position:relative;");
    span.setAttribute("style","margin-left:100px;width:18px;overflow:hidden;");
    
    DWRUtil.removeAllOptions(name);
	DWRUtil.addOptions(name, objs);
	var select = $(name);
//	select.setAttribute("style","width:138px;margin-left:-100px;font-size:12px;");
	select.setAttribute("style","width:138px;margin-left:-100px;CURSOR: pointer;font-size:13px;");
	
	select.setAttribute("onChange","javascript:"+ event +"(this)");
	
	div.appendChild(span);
	span.appendChild(select);
	parnetNode.appendChild(div);
 }
   
  function makeSelectHtmlWidth_bak(objs,name,event,width){
    var div = document.createElement("div");
    var span = document.createElement("span");
    var parnetNode = $(name).parentNode;
    
    div.setAttribute("style","position:relative;");
    span.setAttribute("style","margin-left:100px;width:18px;overflow:hidden;");
    
    DWRUtil.removeAllOptions(name);
	DWRUtil.addOptions(name, objs);
	var select = $(name);
	select.setAttribute("style","width:"+width+"px;margin-left:-100px;font-size:13px;");
	select.setAttribute("onChange","javascript:"+ event +"(this)");
	
	div.appendChild(span);
	span.appendChild(select);
	parnetNode.appendChild(div);
 }
 
 
 function makeSelectHtmlWidth(objs,name,event,width){
    var el = $(name);
    DWRUtil.removeAllOptions(el);
    DWRUtil.addOptions(el, objs);
    el.setAttribute("onChange","javascript:"+ event +"(this)");
    el.setAttribute("style","font-size:13px;width:"+width+"px;CURSOR: pointer;");
 }
   	
function makeSelectAgain(name,end,step,event){
    var div = document.createElement("div");
    var span = document.createElement("span");
    var parnetNode = $(name).parentNode;
    var select = $(name);
    var obj = [];
    
    
    div.setAttribute("style","position:relative;");
    span.setAttribute("style","margin-left:100px;width:18px;overflow:hidden;");
    
    DWRUtil.removeAllOptions(name);
	for(var i = 1; i <= end/step; i++){
		obj[i] = i*step;
	}
	DWRUtil.addOptions(name, obj);
	
	select.setAttribute("style","width:140px;margin-left:-100px;font-size:13px;");
	select.setAttribute("onChange","javascript:"+ event +"(this)");
//	select.setAttribute("onChange","javascript:"+ event +"");
	
	div.appendChild(span);
	span.appendChild(select);
	parnetNode.appendChild(div);
}

function setColors(tbody, color1, color2){
	
	    var colors  = [color1, color2];
	    var trs     = tbody.getElementsByTagName('TR');
	
	    for(var i=0; i<trs.length; i++){
	        trs[i].style.cssText = colors[i % 2];
	    } 
	    
}
	
	function checkEeitStates(){
			var Btn_Save_ID = $("Btn_Save_ID");
			if(!isUndefined(Btn_Save_ID)){
		        	 alert("已在编辑状态.");
		        	 return false;
		    }
		    return true;
	}	
	
	function checkEeitState(sav_ico_name){
			var Btn_Save_ID = $(sav_ico_name);
			if(!isUndefined(Btn_Save_ID)){
		        	 alert("已在编辑状态.");
		        	 return false;
		    }
		    return true;
	}	
	
	function checkEditState(sav_ico_name){
			var Btn_Save_ID = $(sav_ico_name);
			if(isUndefined(Btn_Save_ID)){
		        	 return false;
		    }
		    return true;
	}
		
function  refreshCheckBox(parnetObjName){
	var inputs = $(parnetObjName).getElementsByTagName("input");
	inputs = $A(inputs);
	inputs.each(function(ip){
		ip.checked = false;
		}
	);
}

function getCheckBoxValues(parnetObjName,mode) {
	var i = [];
	var j = 0;
	var inputs = $(parnetObjName).getElementsByTagName("input");
	inputs = $A(inputs);
	inputs.each(function(ip){
		 if(mode == 0 && ip.value !='on') i[j++] = ip.value;
		 if(mode == 1 && ip.value !='on') if( ip.checked) i[j++] = ip.value;
		 if(mode == 2 && ip.value !='on') if(!ip.checked) i[j++] = ip.value;
		}
	);	
	return i;
}

function allSelectCheckBox(event) {
	var e = event || window.event;
	var obj = Event.element(e);
	var parnetObjName = obj.getAttribute("parnetObjName")
	
	var mode = obj.checked;
	var i = [];
	var j = 0;
	var inputs = $(parnetObjName).getElementsByTagName("input");

	inputs = $A(inputs);

	inputs.each(function(ip){
			ip.checked  = mode;
		}
	);	
	return i;
}


function putValuesInCheckBox(parnetObjName,ids){
	var inputs = $(parnetObjName).getElementsByTagName("input");
	var values = $A(ids.first());
	var nodes  = $A(inputs);  

	var sltNodes = nodes.select(function(node)  
	{   
		return node;  
	});  

	if(values.length > 0){
		sltNodes.each(function(node)  
		{  
			if(values.include(node.value)){ node.checked = true;}}
		); 
	}		
}	


function putValuesInCheckBox2(parnetObjName,ids){
	var inputs = $(parnetObjName).getElementsByTagName("input");
	var values = $A(ids);
	var nodes  = $A(inputs);  


	var sltNodes = nodes.select(function(node)  
	{   
		return node;  
	});  

	if(values.length > 0){
		sltNodes.each(function(node)  
		{    
			if(values.include(node.value)){
				
				 node.checked = true;
				 
				 }}
		); 
	}		
}	


//通过索引编号，获得对象数组中的某一属性的值
function getColValueFromObjs(objs,index,indexColName,targColName){
	var v = null;
	for(var i =0 ;i<objs.length;i++){
		var obj = objs[i];
		eval("var value=obj."+ indexColName);
		if(index == value ){
			eval("var value=obj."+ targColName);
			v = value;
			break;
		}
	}
	return v;
}
	

function getArrayFromObjs(objs,indexColName,targColName,where){
	var v = new Array();
	for(var i =0 ;i<objs.length;i++){
		var obj = objs[i];
		eval("var value1=obj."+ indexColName);
		eval("var value2=obj."+ targColName);
		if(value1 == where) v.push(value2);
	}
	return v;
}
	
function getAbsolutePos(el) {
	var SL = 0, ST = 0;
	var is_div = /^div$/i.test(el.tagName);
	if (is_div && el.scrollLeft)
		SL = el.scrollLeft;
	if (is_div && el.scrollTop)
		ST = el.scrollTop;
	var r = { x: el.offsetLeft - SL, y: el.offsetTop - ST };
	if (el.offsetParent) {
		var tmp = this.getAbsolutePos(el.offsetParent);
		r.x += tmp.x;
		r.y += tmp.y;
	}
	return r;
};


function getElementByEvent(ev) {
//	var f = BroArrange.is_ie ? window.event.srcElement : ev.currentTarget;
   var f =detectOS() ? window.event.srcElement : ev.currentTarget;
	while (f.nodeType != 1 || /^div$/i.test(f.tagName))
		f = f.parentNode;
	return f;
};


 function detectOS(){  
                 if (window.navigator.appName.indexOf('Microsoft')>=0){  
//                                 return "IE";  
								return true
                 }  
                 else if (window.navigator.appName.indexOf('Netscape')>=0){  
//                         return "Mozilla";  
							return false;  
                 }  
 }
         
// function getElementByEvent(evt){  
//                 //根据事件的发起者id查找影响者cellUnit，进而触发数据变化的影响  
//                 var elementId='';  
//                 if (detectOS()=='IE'){  
//                         elementId=evt.srcElement.id;  
//                 }  
//                 else{  
//                         elementId=evt.currentTarget.id;  
//                 }  
//                 return $(elementId);  
//}  


function replaceRestring(sour,dest,fix){
	return sour.gsub(dest, fix);;
}

function getSelectParamFromText(e,fix,len){
	
	var c = ''
	
	if(e.length > 0){
		var index = e.selectedIndex; 
		var sour = e.options[index].text;
		var i = sour.indexOf(fix);
		if (i > 0) c = sour.substring(i+len*1);
	}

    return c.Trim();
}





function getSelectParamFromAttribute(e,attributeName){
	if(e.length > 0){
		var index = e.selectedIndex; 
		eval('var v = e.options[index].'+attributeName);
		return v;
	}else{
		return '';
	}
}


function getSelectByIndex(e,index,mode){
	var v;
	if(mode == 1){
		 v = e.options[index].value;
	}
	if(mode == 2){
		 v = e.options[index].text;
	}
	return  v;
}
function getSelectByValu(e,value){
	if(value == 0) return "";
	var inputs = e.getElementsByTagName("option");
	inputs = $A(inputs);
	var s = "";
	inputs.each(function(ip){
			if(value == ip.value) s = e.options[ip.index].text;
		}
	);	
	return s;	
}

function getSelectIndexByValu2(e,value){
	if(value == 0) return "";
	var inputs = e.getElementsByTagName("option");
	inputs = $A(inputs);
	var s = "";
	inputs.each(function(ip){
			if(value == ip.value.split("_")[0]) s = ip.index;
		}
	);	
	return s;	
}

function getSelectIndexByValu3(e,attName,attValue){
	if(attValue == ''||attValue == null) return 0;
	var inputs = e.getElementsByTagName("option");
	inputs = $A(inputs);
	var s = "";
	inputs.each(function(ip){
		    eval('var v = ip.'+attName);
			if(attValue == v) s = ip.value;
		}
	);	
	return s;	
}




function setSelectByValue(e,value){
	var inputs = e.getElementsByTagName("option");
	inputs = $A(inputs);
	inputs.each(function(ip){
			if(value == ip.value) e.options[ip.index].selected = true;
		}
	);	
}	

function htmlEncode(str)
 {
  if(str==null) return "";
  str=str.replace(/</ig,"&lt;")
  str=str.replace(/>/ig,"&gt;");
  str=str.replace(/"/ig,"&quot;");
  return str;
 }
 

function issafe(str)
 {
	var reg = "/^.*[||/|<|>].*$/";
	return !reg.test(str);
 }
 
 



function swapClass(obj, newStyle) {
    obj.className = newStyle;
}

function isUndefined(value) {   
    var undef;   
    return value == undef; 
}

function null2empty(value) {  
	var v = value;
	if (isUndefined(v)) v = "";
	if (v == null) v = "";
    if (v == 'null') v = ""; 
    return v; 
}

function cheng(num,n){
  var dd=1;  
  var tempnum;  
  for(i=0;i<n;i++)  {  dd*=10;  }  
  tempnum=num*dd;  
  tempnum=Math.round(tempnum);  
  return tempnum/dd;  
  }   
/*  
  *     ForDight(Dight,How):数值格式化函数，Dight要  
  *     格式化的   数字，How要保留的小数位数。  
  */  
  function ForDight(Dight,How){  
	  Dight =  Math.round   (Dight*Math.pow(10,How))/Math.pow(10,How);  
	  return Dight;  
  }   
  
  
  
  //保留两位小数   
 //功能：将浮点数四舍五入，取小数点后2位  
function toDecimal(x) {  
            var f = parseFloat(x);  
            if (isNaN(f)) {return;}  
            f = Math.round(x*100)/100;  
            return f;  
}  
  
  
        //制保留2位小数，如：2，会在2后面补上00.即2.00  
function toDecimal2(x) {  
            var f = parseFloat(x);  
            if (isNaN(f)) {return false;}  
            var f = Math.round(x*100)/100;  
            var s = f.toString();  
            var rs = s.indexOf('.');  
            if (rs < 0) {rs = s.length;s += '.';}  
            while (s.length <= rs + 2) {s += '0';}  
            return s;  
}  
          
function fomatFloat(src,pos){ return Math.round(src*Math.pow(10, pos))/Math.pow(10, pos);     }  
  
//function onlyNum(event)
//{
//  if(!((event.keyCode>=48&&event.keyCode<=57)||(event.keyCode>=96&&event.keyCode<=105)))
//    event.returnValue=false;
//}
//function onlyEng(event)
//{
//  if(!(event.keyCode>=65&&event.keyCode<=90))
//    event.returnValue=false;
//} 

function checkAll(theForm) { // check all the checkboxes in the list
  for (var i=0;i<theForm.elements.length;i++) {
    var e = theForm.elements[i];
		var eName = e.name;
    	if (eName != 'allbox' && 
            (e.type.indexOf("checkbox") == 0)) {
        	e.checked = theForm.allbox.checked;		
		}
	} 
}



function cloneTable(source,target){
   var trs_sour = source.getElementsByTagName("tr");
   var trs_targ = target.getElementsByTagName("tr");

   for(var i = 0; i < trs_targ.length; i++) { 
     target.removeChild(trs_targ[i]);
   }  
   

   for(var i = 0; i < trs_sour.length; i++) { 
      var tr = trs_sour[i].cloneNode(true);
   	  target.appendChild(tr);
   }
}


/* Function to clear a form of all it's values */
function clearForm(frmObj) {
	for (var i = 0; i < frmObj.length; i++) {
        var element = frmObj.elements[i];
		if(element.type.indexOf("text") == 0 || 
				element.type.indexOf("password") == 0) {
					element.value="";
		} else if (element.type.indexOf("radio") == 0) {
			element.checked=false;
		} else if (element.type.indexOf("checkbox") == 0) {
			element.checked = false;
		} else if (element.type.indexOf("select") == 0) {
			for(var j = 0; j < element.length ; j++) {
				element.options[j].selected=false;
			}
            element.options[0].selected=true;
		}
	} 
}

/* Function to get a form's values in a string */
function getFormAsString(frmObj) {
    var query = "";
	for (var i = 0; i < frmObj.length; i++) {
        var element = frmObj.elements[i];
        if (element.type.indexOf("checkbox") == 0 || 
            element.type.indexOf("radio") == 0) { 
            if (element.checked) {
                query += element.name + '=' + escape(element.value) + "&";
            }
		} else if (element.type.indexOf("select") == 0) {
			for (var j = 0; j < element.length ; j++) {
				if (element.options[j].selected) {
                    query += element.name + '=' + escape(element.value) + "&";
                }
			}
        } else {
            query += element.name + '=' 
                  + escape(element.value) + "&"; 
        }
    } 
    return query;
}

/* Function to hide form elements that show through
   the search form when it is visible */
function toggleForm(frmObj, iState) // 1 visible, 0 hidden 
{
	for(var i = 0; i < frmObj.length; i++) {
		if (frmObj.elements[i].type.indexOf("select") == 0 || frmObj.elements[i].type.indexOf("checkbox") == 0) {
            frmObj.elements[i].style.visibility = iState ? "visible" : "hidden";
		}
	} 
}

/* Helper function for re-ordering options in a select */
function opt(txt,val,sel) {
    this.txt=txt;
    this.val=val;
    this.sel=sel;
}

/* Function for re-ordering <option>'s in a <select> */
function move(list,to) {     
    var total=list.options.length;
    index = list.selectedIndex;
    if (index == -1) return false;
    if (to == +1 && index == total-1) return false;
    if (to == -1 && index == 0) return false;
    to = index+to;
    var opts = new Array();
    for (i=0; i<total; i++) {
        opts[i]=new opt(list.options[i].text,list.options[i].value,list.options[i].selected);
    }
    tempOpt = opts[to];
    opts[to] = opts[index];
    opts[index] = tempOpt
    list.options.length=0; // clear
    
    for (i=0;i<opts.length;i++) {
        list.options[i] = new Option(opts[i].txt,opts[i].val);
        list.options[i].selected = opts[i].sel;
    }
    
    list.focus();
} 

/*  This function is to select all options in a multi-valued <select> */
function selectAllCheckBox(elementId) {
    var element = document.getElementById(elementId);
	len = element.length;
	if (len != 0) {
		for (i = 0; i < len; i++) {
			 element.checked = true;
		}
	}
}

function selectAll(elementId) {
    var element = document.getElementById(elementId);
	len = element.length;
	if (len != 0) {
		for (i = 0; i < len; i++) {
			element.options[i].selected = true;
		}
	}
}

/* This function is used to select a checkbox by passing
 * in the checkbox id
 */
function toggleChoice(elementId) {
    var element = document.getElementById(elementId);
    if (element.checked) {
        element.checked = false;
    } else {
        element.checked = true;
    }
}

/* This function is used to select a radio button by passing
 * in the radio button id and index you want to select
 */
function toggleRadio(elementId, index) {
    var element = document.getElementsByName(elementId)[index];
    element.checked = true;
}

/* This function is used to open a pop-up window */
function openWindow(url, winTitle, winParams) {
	winName = window.open(url, winTitle, winParams);
    winName.focus();
}


/* This function is to open search results in a pop-up window */
function openSearch(url, winTitle) {
    var screenWidth = parseInt(screen.availWidth);
    var screenHeight = parseInt(screen.availHeight);

    var winParams = "width=" + screenWidth + ",height=" + screenHeight;
        winParams += ",left=0,top=0,toolbar,scrollbars,resizable,status=yes";

    openWindow(url, winTitle, winParams);
}

/* This function is used to set cookies */
function setCookie(name,value,expires,path,domain,secure) {
  document.cookie = name + "=" + escape (value) +
    ((expires) ? "; expires=" + expires.toGMTString() : "") +
    ((path) ? "; path=" + path : "") +
    ((domain) ? "; domain=" + domain : "") + ((secure) ? "; secure" : "");
}

/* This function is used to get cookies */
function getCookie(name) {
	var prefix = name + "=" 
	var start = document.cookie.indexOf(prefix) 

	if (start==-1) {
		return null;
	}
	
	var end = document.cookie.indexOf(";", start+prefix.length) 
	if (end==-1) {
		end=document.cookie.length;
	}

	var value=document.cookie.substring(start+prefix.length, end) 
	return unescape(value);
}

/* This function is used to delete cookies */
function deleteCookie(name,path,domain) {
  if (getCookie(name)) {
    document.cookie = name + "=" +
      ((path) ? "; path=" + path : "") +
      ((domain) ? "; domain=" + domain : "") +
      "; expires=Thu, 01-Jan-70 00:00:01 GMT";
  }
}

// This function is for stripping leading and trailing spaces
function trim(str) { 
    if (str != null) {
        var i; 
        for (i=0; i<str.length; i++) {
            if (str.charAt(i)!=" ") {
                str=str.substring(i,str.length); 
                break;
            } 
        } 
        for (i=str.length-1; i>=0; i--) {
            if (str.charAt(i)!=" ") {
                str=str.substring(0,i+1); 
                break;
            } 
        } 
        
        if (str.charAt(0)==" ") {
            return ""; 
        } else {
            return str; 
        }
    }
} 

// This function is used by the login screen to validate user/pass
// are entered. 
function validateRequired(form) {                                    
    var bValid = true;
    var focusField = null;
    var i = 0;                                                                                          
    var fields = new Array();                                                                           
    oRequired = new required();                                                                         
                                                                                                        
    for (x in oRequired) {                                                                              
        if ((form[oRequired[x][0]].type == 'text' || form[oRequired[x][0]].type == 'textarea' || form[oRequired[x][0]].type == 'select-one' || form[oRequired[x][0]].type == 'radio' || form[oRequired[x][0]].type == 'password') && form[oRequired[x][0]].value == '') {
           if (i == 0)
              focusField = form[oRequired[x][0]]; 
              
           fields[i++] = oRequired[x][1];
            
           bValid = false;                                                                             
        }                                                                                               
    }                                                                                                   
                                                                                                       
    if (fields.length > 0) {
       focusField.focus();
       alert(fields.join('\n'));                                                                      
    }                                                                                                   
                                                                                                       
    return bValid;                                                                                      
}

// This function is a generic function to create form elements
function createFormElement(element, type, name, id, value, parent) {
    var e = document.createElement(element);
    e.setAttribute("name", name);
    e.setAttribute("type", type);
    e.setAttribute("id", id);
    e.setAttribute("value", value);
    parent.appendChild(e);
}

function confirmDelete(obj) {   
//    var msg = "Are you sure you want to delete this " + obj + "?";
    var msg = "请确认是否删除这条记录 ?";
    ans = confirm(msg);
    if (ans) {
        return true;
    } else {
        return false;
    }
}

//function confirmDelete2(obj) {  
//	var rt = false 
//	Ext.MessageBox.confirm(
//                    "请确认",
//                    "是否真的要删除指定的内容",
//                    function(button,text){
//                        if(button=="yes"){
//                        	rt = true;
//							return true;
//                        }else{
//                        	return false;
//                        }
//                    }
//     )
//     
//  
//   return rt;
//    
//}


function highlightTableRow(row,color){
	var cells =  row.getElementsByTagName("td");
	for(var i = 0;i < cells.length; i++){
		cells[i].style.color = color;
	}
}

function getCellValue(row,cellIndex){
	var cells =  row.getElementsByTagName("td");
	for(var i = 0;i < cells.length; i++){
		if( i == cellIndex) return cells[i].innerHTML;
	}
}
function setCellValue(row,cellIndex,name){
	var cells =  row.getElementsByTagName("td");
	for(var i = 0;i < cells.length; i++){
		if( i == cellIndex) {
			 cells[i].innerHTML = name;
		}
	}
}



function getCellObj(row,cellIndex){
	var cells =  row.getElementsByTagName("td");
	for(var i = 0;i < cells.length; i++){
		if( i == cellIndex) return cells[i].obj;
	}
}

function getCell(row,cellIndex,model){
	var cells =  row.getElementsByTagName("td");
	for(var i = 0;i < cells.length; i++){
		if( i == cellIndex) 
			if(model == 0){
				return cells[i];
			}
			if(model == 1){
				return cells[i].firstChild;
			}
	}
}

function highlightTableRows(tableId) {
    var previousClass = null;
    var table = document.getElementById(tableId); 
    var tbody = table.getElementsByTagName("tbody")[0];
    var rows;
    var j = 0;
    if (tbody == null) {
        rows = table.getElementsByTagName("tr");
    } else {
        rows = tbody.getElementsByTagName("tr");
    }
    // add event handlers so rows light up and are clickable
    for (i=0; i < rows.length; i++) {
        rows[i].onmouseover = function() { previousClass=this.className;this.className+=' over' };
        rows[i].onmouseout = function() { this.className=previousClass };
        rows[i].onclick = function() {
        	if(tableId !='orderList'){
	            var cell = this.getElementsByTagName("td")[j];
	            var link = cell.getElementsByTagName("a")[0];
	            location.href = link.getAttribute("href");
	            this.style.cursor="wait";
        	}

        }
    }
}

function highlightFormElements() {
    // add input box highlighting
    addFocusHandlers(document.getElementsByTagName("input"));
    addFocusHandlers(document.getElementsByTagName("textarea"));
}

function addFocusHandlers(elements) {
    for (i=0; i < elements.length; i++) {
        if (elements[i].type != "button" && elements[i].type != "submit" &&
            elements[i].type != "reset" && elements[i].type != "checkbox" && elements[i].type != "radio") {
            if (!elements[i].getAttribute('readonly') && !elements[i].getAttribute('disabled')) {
                elements[i].onfocus=function() {this.style.backgroundColor='#ffd';this.select()};
                elements[i].onmouseover=function() {this.style.backgroundColor='#ffd'};
                elements[i].onblur=function() {this.style.backgroundColor='';}
                elements[i].onmouseout=function() {this.style.backgroundColor='';}
            }
        }
    }
}

function radio(clicked){
    var form = clicked.form;
    var checkboxes = form.elements[clicked.name];
    if (!clicked.checked || !checkboxes.length) {
        clicked.parentNode.parentNode.className="";
        return false;
    }

    for (i=0; i<checkboxes.length; i++) {
        if (checkboxes[i] != clicked) {
            checkboxes[i].checked=false;
            checkboxes[i].parentNode.parentNode.className="";
        }
    }

    // highlight the row    
    clicked.parentNode.parentNode.className="over";
}

//获取参数
function getParamFromUrl(srcStr,paramName) {
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
}


 function getQueryParamValue(queryString, key) {  
   var result = queryString.match(new RegExp('(?:^|&)' + key + '=(.*?)(?=$|&)'));  
   return result && result[1];  
 } 
 
// function setQueryParamValue(queryString, key, newValue) {  
//			    var newParam = key + '=' + newValue;  
//			      if (!queryString) return newParam;  
//			       
//			      var replaced = false;  
//			     var params = queryString.split('&');  
//			     for (var i = 0; i < params.length; i++) {  
//			       if (params[i].split('=')[0] == key) {  
//			         params[i] = newParam;  
//			        replaced = true;  
//			      }  
//			   }  
//			   if (replaced) return params.join('&');  
//			    return queryString + '&' + newParam;  
// }  
		   
function setQueryParamValue(queryString, key, newValue) {  
   var replaced = false;  
   var newParam = key + '=' + newValue;  
   var result = queryString.replace(new RegExp('(^|&)' + key + '=(.*?)(?=$|&)', 'g'), function (s, p1, p2) {  
     replaced = true;  
     return p1 + newParam;  
   });  
   return replaced && result || queryString && (queryString + '&' + newParam) || newParam;  
}


function getAutoCompleteIdByValue(sourel,targel,v,nameCol,idCol){
		var trs = sourel.firstChild.getElementsByTagName("tr");
		for(var i = 1;i<trs.length;i++){
			 var name = getCellValue(trs[i],nameCol);
			 //alert( getCellValue(trs[i],0));
			if(v == name) targel.value = getCellValue(trs[i],idCol);
		}
}

function convertMonthCN2Num(m){
	switch(m){
		case "一月":
			return 1;break;
		case "二月":
			return 2;break;	
		case "三月":
			return 3;break;
		case "四月":
			return 4;break;				
		case "五月":
			return 5;break;
		case "六月":
			return 6;break;				
		case "七月":
			return 7;break;
		case "八月":
			return 8;break;	
		case "九月":
			return 9;break;
		case "十月":
			return 10;break;				
		case "十一月":
			return 11;break;
		case "十二月":
			return 12;break;
		case "":
		        return 0;				
						
	}
}

function convertQuarterCN2Num(m){
	switch(m){
		case "一季度":
			return 1;break;
		case "二季度":
			return 2;break;	
		case "三季度":
			return 3;break;
		case "四季度":
			return 4;break;				
		case "":
		        return 0;				
						
	}
}



    function isDigit(s){
       		//var p = /^\d*\.$/;
       		var p = /^\d*(\.\d*)?$/;
       		return p.test(s);
	}

	function isDigit2(){
	    	var s  = this.value;
       		//var p = /^\d*\.$/;
       		var p = /^\d*(\.\d*)?$/;
       		if(!p.test(s)){
//       			GmyUtils.myMessage("必须是数字");
       		    alert("必须是数字");
       		    this.value = '';	
       		    this.focus();
       		}
	}
	
function isDigit3(str){
	if(isInteger(str)) return true;
	var re = /^[-]{0,1}(\d+)[\.]+(\d+)$/;
	if (re.test(str)) {
	if(RegExp.$1==0&&RegExp.$2==0) return false;
	return true;
	} else {
	return false;
	}
} 

function isInteger(str){
	var regu = /^[-]{0,1}[0-9]{1,}$/;
	return regu.test(str);
} 	

//select的宽度根据所选的下拉列表来自适应
function   resetSelectWidth(obj){
      var   tempObj=document.createElement( "select ");
      tempObj.length=1;
      tempObj.options[0].text=obj.options[obj.selectedIndex].text
      obj.parentNode.appendChild(tempObj);
      obj.style.width=tempObj.offsetWidth;
      obj.parentNode.removeChild(tempObj);
} 
	
function getValueFromStoreById(cmd,tagFiled){
	 var store = cmd.store;
	 var id = cmd.getValue();
	 

	 var index = 0;
	 if(id > 0){ 
	 	
	 	
	 	
	 	 index = store.find(cmd.valueField, id); 
	 	 
//	 	 alert(cmd.valueField+'_'+index+'_'+id);
	 	 
	 	 var record = store.getAt(index);
	 	 
	 	 if(record){
			 eval('var rt = record.data.' + tagFiled );
			 return rt;
	 	 }else{
	 	 	return 0;
	 	 }
	 	 

	 }else{
	 	return 0;
	 }
}


function getValueFromStoreByText(cmd,text){
		var index = cmd.store.find(cmd.displayField, text); 
		var record = cmd.store.getAt(index);
		cmd.setValue(record.data.id);	
}





function   DateAdd(interval,number,date)
{
/*
  *---------------   DateAdd(interval,number,date)   -----------------
  *   DateAdd(interval,number,date)  
  *   功能:实现VBScript的DateAdd功能.
  *   参数:interval,字符串表达式，表示要添加的时间间隔.
  *   参数:number,数值表达式，表示要添加的时间间隔的个数.
  *   参数:date,时间对象.
  *   返回:新的时间对象.
  *   var   now   =   new   Date();
  *   var   newDate   =   DateAdd( "d ",5,now);
  *   author:wanghr100(灰豆宝宝.net)
  *   update:2004-5-28   11:46
  *---------------   DateAdd(interval,number,date)   -----------------
  */
  
  
//var   now   =   new   Date();
////加五天.
//var   newDate   =   DateAdd( "d ",5,now);
//alert(newDate.toLocaleDateString())
////加两个月.
//newDate   =   DateAdd( "m ",2,now);
//alert(newDate.toLocaleDateString())
////加一年
//newDate   =   DateAdd( "y ",1,now);
//alert(newDate.toLocaleDateString()) 					 
//		
//window.onload = function() {
//    highlightFormElements();
//    if ($('successMessages')) {
//        new Effect.Highlight('successMessages');
//        // causes webtest exception on OS X : http://lists.canoo.com/pipermail/webtest/2006q1/005214.html
//        // window.setTimeout("Effect.DropOut('successMessages')", 3000);
//    }
//    if ($('errorMessages')) {
//        new Effect.Highlight('errorMessages');
//    }
//}  
        switch(interval)
        {
                case   "y "   :   {
                        date.setFullYear(date.getFullYear()+number);
                        return   date;
                        break;
                }
                case   "q "   :   {
                        date.setMonth(date.getMonth()+number*3);
                        return   date;
                        break;
                }
                case   "m "   :   {
                        date.setMonth(date.getMonth()+number);
                        return   date;
                        break;
                }
                case   "w "   :   {
                        date.setDate(date.getDate()+number*7);
                        return   date;
                        break;
                }
                case   "d "   :   {
                        date.setDate(date.getDate()+number);
                        return   date;
                        break;
                }
                case   "h "   :   {
                        date.setHours(date.getHours()+number);
                        return   date;
                        break;
                }
                case   "m "   :   {
                        date.setMinutes(date.getMinutes()+number);
                        return   date;
                        break;
                }
                case   "s "   :   {
                        date.setSeconds(date.getSeconds()+number);
                        return   date;
                        break;
                }
                default   :   {
                        date.setDate(d.getDate()+number);
                        return   date;
                        break;
                }
        }
}

function uniqueArray(data){ 
data = data || []; 
var a = {}; 
len = data.length; 
for (var i=0; i<len;i++){ 
var v = data[i]; 
if (typeof(a[v]) == 'undefined'){ 
a[v] = 1; 
} 
}; 
data.length=0; 
for (var i in a){ 
data[data.length] = i; 
} 
return data; 
} 

function encode_data_xml(strDataXML){
        if (strDataXML == null){return "";}
        strDataXML = strDataXML.replace("&", "&amp;");
        strDataXML = strDataXML.replace("<", "&lt;");
        strDataXML = strDataXML.replace(">", "&gt;");
        strDataXML = strDataXML.replace("'", "&apos;");
        strDataXML = strDataXML.replace("\"", "&quot;");
        return strDataXML;
};

function decode_string_xml(strDataXML){
		if (strDataXML == null){return "";}
        strDataXML = strDataXML.replace("&lt;", "<");
        strDataXML = strDataXML.replace("&gt;", ">");
        strDataXML = strDataXML.replace("&apos;", "'");
        strDataXML = strDataXML.replace("&quot;", "\"");
        strDataXML = strDataXML.replace("&amp;", "&");
		return strDataXML;
};

function set_date_calendar_disable(elName,year,startDate,endDate){
   if(year){
   	 startDate = year+"0101"; endDate = year+"1231";
   }
   
   
   var dateDisabledFunc = function(date){
	    var calDate = date.print("%Y%m%d")*1;
       return !(calDate >= startDate*1 && calDate <= endDate*1);	    
   }
	
   var pval = getFormatDay(startDate,'y/m/d'); 
   pval =''+pval;
   var d =  new   Date(Date.parse(pval.replace(/-/g,   "/")));   

  Calendar.setup({
		inputField  : elName,	  // id of the input field
		singleClick	  : true,
		range:[order_year],
		firstDay:1,
		dateDisabledFunc      : function(date) {
                      // disable all dates between 5 and 15 every month
                      return dateDisabledFunc(date);
              },
		button	  : elName	// id of the button
	});

	$(elName).value = pval; 
}

function showLoginWin(locationUrl,modal){
	
	
//try {
//			} catch (e) {
////				alert(e.name + " : " + e.message); 
//			} 			


			  var logoOrgNameField = 'j_logoOrgName';
			  var softVerisonField = 'j_softVerison';
			  var randCodeField = 'j_randcode';
			  var logoOrgName = $("logo_org_names").value;
			  var winWidth = 435/12*(logoOrgName.length-1);
			   winWidth = winWidth>435?winWidth:435;

	           function call_Bak_Fun(jsonObj,setCooker){
	           	    
//	           	    var logoOrgName = jsonObj.logoOrgName;
//	           	    var logoOrgName = $("logo_org_names").value;
	           	    var softVerison = jsonObj.softVerison;
	           	    var enableRandCode = jsonObj.enableRandCode;

	           	    if(setCooker){
						Ext.state.Manager.set(logoOrgNameField,logoOrgName);
						Ext.state.Manager.set(softVerisonField,softVerison);
						Ext.state.Manager.set(randCodeField,enableRandCode);
	           	    }
//	           	    Ext.state.Manager.set(randCodeField,true);
	           	     
	                url =  getCtxPath()+'j_security_check';
	                
	                if(locationUrl){
	                	url = url+"?spring-security-redirect="+locationUrl;
	                }
	                
	//                var spring_security_redirect = getParamFromUrl(window.location.href,"spring-security-redirect")+'';
	//                
	//                if(spring_security_redirect != '' && spring_security_redirect != null && spring_security_redirect != 'null'){
	//                	url = url+"?spring-security-redirect="+spring_security_redirect;
	//                }
	//                
	//                alert(url);
	
	                Ext.QuickTips.init();
	                
	                var loginWindow = new Ext.ux.LoginWindow({
	                    modal : modal,
	                    constrain: true,
	//                    encryptType: 'md5', // 'md5' ou 'sha1'
	                    //usernameVtype: 'cpf', Se quiser altenticar por cpf descomentar isso
	                    width: winWidth,
	                    enableVirtualKeyboard : true,
	                    //salt: false,
	                    //forceVirtualKeyboard : true,
	                    // formBgcolor:'#f9f9f9',
	                    languageSelection: false,
	                    enableRandCode:enableRandCode,
	                    defaultLanguage: 'zh_CN',
//	                    winBanner: 'logo.png',
	                    winBanner: 'LogoMaker.jpg',
	                    url:  url,
	                    emailUrl:  url,
	                    locationUrl: locationUrl==null && locationUrl !=''? getCtxPath()+'mainMenu.html':locationUrl,
//	                    callBakFun:callBakFun,
	                    basePath: getCtxPath()+'image/login2',
	                    logoOrgName:logoOrgName,
	                    softVerison:softVerison

	                });
	
	                loginWindow.show(); 	
	           }




				var cp = new Ext.state.CookieProvider(); 
				Ext.state.Manager.setProvider(cp); 
//				var logoOrgName = cp.get(logoOrgNameField);
				var softVerison = cp.get(softVerisonField);
				var isInerNetIp = cp.get(randCodeField);

               if(isUndefined(isInerNetIp)){
               	  function call(jsonStr){
               	  	var obj = eval('('+ jsonStr + ')');  
               	  	call_Bak_Fun(obj,true)
               	  };
               	  SysParamUtil.checkIsInnerIP(call);      
               }else{
               	  var obj ={};
	           	  obj.logoOrgName = logoOrgName;
	           	  obj.softVerison = softVerison;
	           	  obj.enableRandCode = isInerNetIp;
               	  call_Bak_Fun(obj);
               }

                
//                 Ext.QuickTips.init();
//                
//                var loginWindow = new Ext.ux.LoginWindow({
//                    modal : false,
//                    constrain: true,
//                    //encryptType: 'md5', // 'md5' ou 'sha1'
//                    //usernameVtype: 'cpf', Se quiser altenticar por cpf descomentar isso
//                    width: 435,
//                    enableVirtualKeyboard : true,
//                    //salt: false,
//                    //forceVirtualKeyboard : true,
//                    // formBgcolor:'#f9f9f9',
//                    languageSelection: false,
//                    defaultLanguage: 'zh_CN',
//                    winBanner: 'logo.png',
//                    url: 'j_security_check',
//                    emailUrl: 'j_security_check',
//                    locationUrl: 'mainMenu.html',
//                    basePath: 'image/login2/'
//                });
//
//                loginWindow.show(); 
       
                
}


//Javascript 格式化金额  
//格式化：  
function fmoney(s, n)  
{  
n = n > 0 && n <= 20 ? n : 2;  
s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";  
var l = s.split(".")[0].split("").reverse(),  
r = s.split(".")[1];  
t = "";  
for(i = 0; i < l.length; i ++ )  
{  
t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");  
}  
return t.split("").reverse().join("") + "." + r;  
}  

//
//function fmoney(number,pattern){
//    var str            = number.toString();
//    var strInt;
//    var strFloat;
//    var formatInt;
//    var formatFloat;
//    if(/\./g.test(pattern)){
//        formatInt        = pattern.split('.')[0];
//        formatFloat        = pattern.split('.')[1];
//    }else{
//        formatInt        = pattern;
//        formatFloat        = null;
//    }
//    if(/\./g.test(str)){
//        if(formatFloat!=null){
//            var tempFloat    = Math.round(parseFloat('0.'+str.split('.')[1])*Math.pow(10,formatFloat.length))/Math.pow(10,formatFloat.length);
//            strInt        = (Math.floor(number)+Math.floor(tempFloat)).toString();                
//            strFloat    = /\./g.test(tempFloat.toString())?tempFloat.toString().split('.')[1]:'0';            
//        }else{
//            strInt        = Math.round(number).toString();
//            strFloat    = '0';
//        }
//    }else{
//        strInt        = str;
//        strFloat    = '0';
//    }
//    if(formatInt!=null){
//        var outputInt    = '';
//        var zero        = formatInt.match(/0*$/)[0].length;
//        var comma        = null;
//        if(/,/g.test(formatInt)){
//            comma        = formatInt.match(/,[^,]*/)[0].length-1;
//        }
//        var newReg        = new RegExp('(\\d{'+comma+'})','g');
//
//        if(strInt.length<zero){
//            outputInt        = new Array(zero+1).join('0')+strInt;
//            outputInt        = outputInt.substr(outputInt.length-zero,zero)
//        }else{
//            outputInt        = strInt;
//        }
//
//        var 
//        outputInt            = outputInt.substr(0,outputInt.length%comma)+outputInt.substring(outputInt.length%comma).replace(newReg,(comma!=null?',':'')+'$1')
//        outputInt            = outputInt.replace(/^,/,'');
//
//        strInt    = outputInt;
//    }
//
//    if(formatFloat!=null){
//        var outputFloat    = '';
//        var zero        = formatFloat.match(/^0*/)[0].length;
//
//        if(strFloat.length<zero){
//            outputFloat        = strFloat+new Array(zero+1).join('0');
//            //outputFloat        = outputFloat.substring(0,formatFloat.length);
//            var outputFloat1    = outputFloat.substring(0,zero);
//            var outputFloat2    = outputFloat.substring(zero,formatFloat.length);
//            outputFloat        = outputFloat1+outputFloat2.replace(/0*$/,'');
//        }else{
//            outputFloat        = strFloat.substring(0,formatFloat.length);
//        }
//
//        strFloat    = outputFloat;
//    }else{
//        if(pattern!='' || (pattern=='' && strFloat=='0')){
//            strFloat    = '';
//        }
//    }
//
//    return strInt+(strFloat==''?'':'.'+strFloat);
//}


// Show the document's title on the status bar
window.defaultStatus=document.title;

