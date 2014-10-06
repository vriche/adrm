
function OaCalendarEvent(){

	this.obj = {
		id:null,
		title:null,
		eventStateId:null,
		content:null,
	
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    type:null,
	    indexDate:null,
	    indexTime:null
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
	
	this.enableEdit = true;
	this.enableDel = true;
	this.pageHTML = null;
	this.weekHTML = null;
	this.dayHTML = null;
	this.monthHTML = null;
	this.curDate = null;
	
	return this;	
}	

//清空对象
OaCalendarEvent.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.title = null;
	this.obj.eventStateId = null;
  	this.obj.content = null;
  	
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.type = null;
  	this.obj.indexDate = null;
  	this.obj.indexTime = null;
}

OaCalendarEvent.prototype.getOaCalendarEvent = function(id,setValueFun){
	
	OaCalendarEventManager.getOaCalendarEvent(setValueFun,id);
		
}
	
/* 获得列表
 * obj 对象参数
 * fillObjName 界面 TBODY 的ID名
 */
OaCalendarEvent.prototype.getOaCalendarEvents = function(o){
	var OBJ = o;
	var obj = OBJ.obj;
	var objs;
	
	DWREngine.setAsync(false);
	OaCalendarEventManager.getOaCalendarEvents(getObjs,obj);
	DWREngine.setAsync(true);
	
	function getObjs(os){
		objs = os;
	}
	return objs;
}

OaCalendarEvent.prototype.getOaCalendarEventsByWeek = function(beginDate,lastDate,type,createBy){
	var objs;
	
	DWREngine.setAsync(false);
	OaCalendarEventManager.getOaCalendarEventsByWeek(getObjs,beginDate,lastDate,type,createBy);
	DWREngine.setAsync(true);
	
	function getObjs(os){
		objs = os;
	}
	return objs;
}
//动态画day表；
OaCalendarEvent.prototype.fillDayTable = function(objs){
		
	
		
	var str = "<table>";
		
		for(var i = 8 ;i<=18;i++){
			str += "<tr>";
				str += "<td>";
				str += '<a href="javascript:void 0" onClick="editDayInfo(\'' + getId(i,objs) + '\',\'' + getCurTime(i) + '\')">'+ i + ":00" + "</a>";
				str += "</td>";
				str += "<td>";
				str += "&nbsp";
				str += "</td>";
				str += "<td>";
				str += getTitle(i,objs);
				str += "</td>";
			str += "</tr>";
		}
	str += "</table>";
	
	this.pageHTML = str;	 
}
//动态画week表；
OaCalendarEvent.prototype.fillWeekTable = function(objs){
	
	var str = "<table>";
		str += "<tr>";
		str += "<td>";
		str += getCurWeekNum();
		str += "</td>";
		str += "<td>";
		str += getCurNum();
		str += "</td>";
		str += "</tr>";
		str += "&nbsp";
		for(var i = 0 ;i<=6;i++){
			str += "<tr>";
				str += "<td>";
				str += '星期' + this.changeWeek(i); 
				str += "</td>";
				str += "<td>";
				str += getCurWeekDate(i);
				str += "</td>";
				str += "<td>";
				str += getWeekTitle(objs,getCurWeekDate(i)) ;
				str += "</td>";
			str += "</tr>";
			str += "<tr>";
				str += "<td>";
				str += "</td>";
				str += "<td>";
				str += '<a href="javascript:void 0" onClick="editWeekInfo(\'' + getWeekTypeId(getCurWeekDate(i),objs) + '\',\'' + getCurTime(i) + '\',\'' + i +'\')">'+ '[添加]' + "</a>"; 
				str += "</td>";
			str += "</tr>";
		}
	str += "</table>";
	
	return str; 
}
//转换星期
OaCalendarEvent.prototype.changeWeek = function(num){
	var n = '';
	
	if(num == 0){n = '日';}
	if(num == 1){n = '一';}
	if(num == 2){n = '二';}
	if(num == 3){n = '三';}
	if(num == 4){n = '四';}
	if(num == 5){n = '五';}
	if(num == 6){n = '六';}
		
	return n;
}
//动态画month表；
OaCalendarEvent.prototype.fillMonthTable = function(){
	
	var str = "<table width=100% border=1 cellpadding=0 cellspacing=0>";
			str += "<tr align=center>";
				str += "<td>";
				str += getDate();
				str += "</td>";
			str += "</tr>";
			str += "<tr>";
				str += "<td>";
				str += "<table width=100% border=0>"
				str += "<tr>";
				for(var i = 0 ;i<=6;i++){
						str += "<td align=center>";
						str += '星期' + this.changeWeek(i); 
						str += "</td>";
				}
				str += "</tr>";	
				str += "</table>";
				str += "</td>";
			str += "</tr>";
			str += "<tr>";
				str += "<td>";
				str += "<table width=100% border=0>"
				str += "<tr>";
//					str += "<td width=3%>";
//						str += "<table width=100% height=260 border=1>"
//						for(var m = 0 ;m<=4;m++){
//							str += "<tr>";
//								str += "<td>";
//								str += getWeekNum(m);
//								str += "</td>";
//							str += "</tr>";
//						}
//						str += "</table>";	
//					str += "</td>";
					str += "<td>";
						str += "<table width=100% height=260 border=0>"
						for(var i = 0 ;i<=4;i++){
							str += "<tr>";
								for(var j = 0;j<=6;j++){
									str += "<td>";
									str += '<a href="javascript:void 0" onClick="editMonthDate()">'+ '[添加]' + "</a>";
									str += "</td>";
								}
							str += "</tr>";
						}
					str += "</td>";
				str += "</tr>";	
				str += "</table>";
				str += "</td>";
			str += "</tr>";
			
	str += "</table>";
	
	return str; 
}
//OaCalendarEvent.prototype.fillYearTable = function(){
//	var str = "<table width=100% border=1>";
//}
OaCalendarEvent.prototype.saveOaCalendarEvent = function(o,mode,saveFun){
	var OBJ = o;
	var obj = OBJ.obj;	
	
	if (mode == 'new') obj.id = null;
	
	OaCalendarEventManager.saveOaCalendarEvent(obj,saveFun);

}	
OaCalendarEvent.prototype.removeOaCalendarEvent = function(id){
	var OBJ = this;
	var obj = this.obj;
	
	if(!confirmDelete(OBJ.className)) return false;
	
	DWREngine.setAsync(false);
	OaCalendarEventManager.removeOaCalendarEvent(removeFun,id);	
	DWREngine.setAsync(true);

	function removeFun(){
		OBJ.reset();
   }
   
}

OaCalendarEvent.prototype.getOaCalendarEventsByDate = function(o,func){
	var OBJ = this;
	var obj = o;
	var page = this.page;

    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		OaCalendarEventManager.getOaCalendarEventsPage(func,obj,page.pageIndex,page.pageSize);
    }else{
		OaCalendarEventManager.getOaCalendarEvents(func,obj);	
    }
}
/* 总记录数
 * 
 */
OaCalendarEvent.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	OaCalendarEventManager.getOaCalendarEventsCount(getCountFun,obj);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}
//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
OaCalendarEvent.prototype.fillTalbe = function(objs){	
	var OBJ = this;
	var obj = OBJ.obj;
	var tBody  = this.tBody;
	var color1 = this.color1;
	var color2 = this.color2;

	
	//把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("indexDate", rowData.indexDate);
	 	row.setAttribute("title", rowData.title);
	 	row.setAttribute("content", rowData.content);
	 	row.setAttribute("type", rowData.type);
	 	row.setAttribute("eventStateId", rowData.eventStateId);
	 }	
	 
	//编辑图标的触发的事件
	function edit(event){
		var e = event || window.event;
		var editImg = Event.element(e);
		var id = editImg.getAttribute("paraId"); 
		
		var editRow = $(OBJ.IdPrefix + id);
		OBJ.addNewRow("edit",editRow);
	}
	//删除图标的触发的事件
	function del(event){
		var e = event || window.event;
		var deleImg = Event.element(e);
		var id = deleImg.getAttribute("paraId"); 
		var delRow = deleImg.parentNode.parentNode;
		OBJ.removeOaDocument(id,delRow);
	}
	
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){return obj.indexDate;},
					function(obj){return obj.title},
					function(obj){return obj.content},
					function(obj){return obj.type;},
					function(obj){return obj.eventStateId},
				    function(obj) {
				    	var editImg = makeImagHtml("image/edit.png","Btn_editOaCalendarEvent","18","18",obj.id,"editOaCalendarEvent");
//				    	if(OBJ.enableEdit) editImg.onclick = edit;
				    	return editImg;}, 
				    function(obj) {
						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deleteOaCalendarEvent","18","18",obj.id,"delOaCalendarEvent");
//						if(OBJ.enableDel) deleImg.onclick = del;
				    	return deleImg;} 
			];	
				
	//先删除 tbody		
	DWRUtil.removeAllRows(tBody);
	//再重新构造新的表
	DWRUtil.addRows(tBody,objs,cellTable,{
				rowCreator:function(options) {  
						   var row = document.createElement("tr"); 
				           putRowDataInHidden(row,options.rowData);
						   return row;  
					  },  
					  
				cellCreator:function(options) {
						    var td = document.createElement("td"); 
						    return td;
					  }  
				});
				
	//给表格每一行上颜色，调用 global.js 中的setColors函数
	setColors(tBody, color1, color2);
}

OaCalendarEvent.prototype.getOaCalendarEventsByBeginAndEndDate = function(beginDate,endDate,func){
	OaCalendarEventManager.getOaCalendarEventsByBeginAndEndDate(func,beginDate,endDate);
}


