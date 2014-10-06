
function Workspan(){

	this.obj = {
		carrierId:null,
		resourceId:null,
		resourceType:null,
		propertiyTime:null,
		beginDate:null,
		endDate:null,
		broadcastStartTime:null,
		broadcastEndTime:null,
		broadcastStartT:null,
		broadcastStartTh:null,
		broadcastStartTm:null,
		broadcastStartTs:null,

		monLength:null,
		tueLength:null,
		wenLength:null,
		thiLength:null,
		
		friLength:null,
		satLength:null,
		sunLength:null,
		
		dayInfos:null,
		
		id:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    memo:null
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
Workspan.prototype.reset = function(){
  	this.obj.carrierId = null;
  	this.obj.resourceId = null;
  	this.obj.resourceType = null;
  	this.obj.propertiyTime = null;
  	this.obj.beginDate = null;
  	this.obj.endDate = null;
  	this.obj.broadcastStartTime = null;
  	
  	this.obj.broadcastEndTime = null;
   	this.obj.broadcastStartT = null;
  	this.obj.broadcastStartTh = null;
  	this.obj.broadcastStartTm = null;
  	this.obj.broadcastStartTs = null; 	
		
  	this.obj.sunLength = null;
  	this.obj.monLength = null;
  	this.obj.tueLength = null;
  	this.obj.thiLength = null;
  	this.obj.wenLength = null;
  	this.obj.friLength = null;
  	this.obj.satLength = null;
  	
  	this.obj.dayInfos = null;
  	
	this.obj.id = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.memo = null;
}

Workspan.prototype.getResourceDayInfo = function(publishDate,resourceId,func){
	WorkspanManager.getResourceDayInfo(func,publishDate,resourceId);
}

Workspan.prototype.getWorkspan = function(id,func){
	WorkspanManager.getWorkspan(func,id);
}

Workspan.prototype.getWorkspans = function(o,func){
	WorkspanManager.getWorkspans(func,o);
}

Workspan.prototype.getWorkspansByResourceId = function(resId){
	
	var OBJ = this;
	WorkspanManager.getWorkspansByResourceId(OBJ.fillTable,resId);
}

Workspan.prototype.getWorkspansByResId = function(resId,func){
	var page = this.page;	
		
    if (page.pageSize > 0){
		var size = this.getCountByResId(resId);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);	
		
		WorkspanManager.getWorkspanPageByResoruceId(func,resId,page.pageIndex,page.pageSize);
    }
}


Workspan.prototype.getWorkspansByResId2 = function(grid,resId){

     grid.clearAll();
     


	function func(objs){
		
		
//		alert(objs.length)

			var sb;
		  	sb = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			sb = sb + "<rows>";  
			
		    for(var i=0;i<objs.length;i++){
		    	
		    	var obj = objs[i];
		    	
				sb = sb + "<row  id=\""+ obj.id +"\"" +">";
				sb = sb + "<cell><![CDATA["+ getFormatDay(obj.beginDate,'y/m/d')  +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ getFormatDay(obj.endDate,'y/m/d')   +"]]></cell>";

//				if(config_withBroPoint == 1){
//					sb = sb + "<cell><![CDATA["+ obj.broadcastStartT   +"]]></cell>";
//				}else{
//					sb = sb + "<cell><![CDATA["+ obj.broadcastEndTime   +"]]></cell>";
//				}				
				
				sb = sb + "<cell><![CDATA["+ obj.broadcastStartTh   +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ obj.broadcastStartTm   +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ obj.broadcastStartTs   +"]]></cell>";
	
				
				sb = sb + "<cell><![CDATA["+ obj.monLength   +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ obj.tueLength   +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ obj.wenLength   +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ obj.thiLength   +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ obj.friLength   +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ obj.satLength   +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ obj.sunLength   +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ obj.resourceType   +"]]></cell>"; 
				sb = sb + "<cell><![CDATA["+ decodeURI(obj.memo)   +"]]></cell>";

				sb = sb + "<cell>"+ctxPath+"image/button_delete.gif^删除^javascript:_remove_work_span();^_self</cell>";
				
//				sb = sb + "<cell>删除^javascript:_remove_work_span("+ obj.id +");^_self</cell>";
				
				
				sb = sb + "</row>";			    	
		    }
		    sb = sb + "</rows>"; 
		    
		    grid.loadXMLString(sb);
			
	}
	
	 

	WorkspanManager.getWorkspanPageByResoruceId(resId,1,60,func);
  
}


Workspan.prototype.getCountByResId = function(resId){
	var count;
	DWREngine.setAsync(false);
	WorkspanManager.getWorkspanCountByResoruceId(getCountFun,resId);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}

Workspan.prototype.saveWorkspan = function(obj,func){
	var start = getFormatDay(obj.beginDate,'ymd');
	var end = getFormatDay(obj.endDate,'ymd');
	obj.beginDate = start;
	obj.endDate = end;
	
	WorkspanManager.saveWorkspan(func,obj);
} 

Workspan.prototype.removeWorkspan = function(id,delRow){
	var OBJ = this;
	var page = this.page;
	var curRow = this.tBody.rows.length;
	var obj = this.obj;
	
//	if (!checkEeitState('Btn_SaveWorkspan')) return false;
	
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	
	DWREngine.setAsync(false);
	WorkspanManager.removeWorkspan(removeFun,id);	
	DWREngine.setAsync(true);
	
	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
   }
}

Workspan.prototype.remove_workspan = function(id,remove_fun){
	function removeFun(){
		if(remove_fun) remove_fun();
	}
	WorkspanManager.removeWorkspan(id,removeFun);	
}


//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
Workspan.prototype.fillTable = function(objs){	
	var OBJ = workspan;
	var obj = OBJ.obj;
	var tBody  = workspan.tBody;
	var color1 = workspan.color1;
	var color2 = workspan.color2;
	
	
	
	//把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	
	 	//getFormatDay(rowData.beginDate,'ymd')
	        //getFormatDay(rowData.beginDate,'y/m/d')
	 	
	 	
	 	//row.setAttribute("beginDate", rowData.beginDate);
	 	//row.setAttribute("endDate", rowData.endDate);
	 	row.setAttribute("beginDate", getFormatDay(rowData.beginDate,'y/m/d'));
	 	row.setAttribute("endDate", getFormatDay(rowData.endDate,'y/m/d'));	 	
	 	
	 	
	 	row.setAttribute("broadcastEndTime", rowData.broadcastEndTime);
	 	
	 	row.setAttribute("broadcastStartTime", rowData.broadcastStartTime);
	 	row.setAttribute("broadcastStartT", rowData.broadcastStartT);
	 	row.setAttribute("broadcastStartTh", rowData.broadcastStartTh);
	 	row.setAttribute("broadcastStartTm", rowData.broadcastStartTm);
	 	row.setAttribute("broadcastStartTs", rowData.broadcastStartTs);
	 	
	 	row.setAttribute("monLength", rowData.monLength);
	 	row.setAttribute("tueLength", rowData.tueLength);
	 	row.setAttribute("wenLength", rowData.wenLength);
	 	row.setAttribute("thiLength", rowData.thiLength);
	 	row.setAttribute("friLength", rowData.friLength);
	 	row.setAttribute("satLength", rowData.satLength);
	 	row.setAttribute("sunLength", rowData.sunLength);
	 }	
	 
	//编辑图标的触发的事件
	function edit(event){
		var e = event || window.event;
		var editImg = Event.element(e);
		var id = editImg.getAttribute("paraId"); 
		
		var editRow = $(OBJ.IdPrefix + id);
		OBJ.addNewRow("edit",editRow);
		getDate();
	}
	//删除图标的触发的事件
	function del(event){
		var e = event || window.event;
		var deleImg = Event.element(e);
		var id = deleImg.getAttribute("paraId"); 
		var delRow = deleImg.parentNode.parentNode;
		OBJ.removeWorkspan(id,delRow);
	}
	
	//一行中，各单元格返回的内容
	var cellTable=[
				  	//function(obj) { return  obj.beginDate },
				 	//function(obj) { return obj.endDate },
				 	
				 	
				 	function(obj) { return getFormatDay(obj.beginDate,'y/m/d') },
				 	function(obj) { return getFormatDay(obj.endDate,'y/m/d') },
				 	
				 	function(obj) { 
						 	 if(config_withBroPoint == 1){
						 		return obj.broadcastStartT;
						 	}else{
						 		return obj.broadcastEndTime; 
						 	}
				 		},
				    function(obj) { return obj.monLength },
				  	function(obj) { return obj.tueLength },
				    function(obj) { return obj.wenLength },
				    function(obj) { return obj.thiLength },
				    function(obj) { return obj.friLength },
				    function(obj) { return obj.satLength },
				    function(obj) { return obj.sunLength },
				    function(obj) {
				    	var editImg = makeImagHtml("image/edit.png","Btn_editWorkspans","18","18",obj.id,"");
				    	if(OBJ.enableEdit) editImg.onclick = edit;
				    	return editImg;}, 
				    function(obj) {
						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deleteWorkspans","18","18",obj.id,"deleteWorkspan");
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

Workspan.prototype.addNewRow = function(mode,editRow){
    var OBJ = this;
    var obj = this.obj;
	var page = this.page;
	var tBody = this.tBody;
	
//	if (!checkEeitState('Btn_SaveWorkspan')) return false;
	
	function getRowDataInObj(editRow){
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.beginDate = editRow.getAttribute("beginDate");
	 	obj.endDate = editRow.getAttribute("endDate");
	 	//getFormatDay(editRow.getAttribute("beginDate"),'ymd')
		//obj.beginDate = editRow.getAttribute("beginDate");
	 	//obj.endDate = editRow.getAttribute("endDate"); 	
	 	
	 	obj.broadcastStartTime = editRow.getAttribute("broadcastStartTime");
	 	obj.broadcastEndTime = editRow.getAttribute("broadcastEndTime");
	 	

	 	obj.broadcastStartTh = editRow.getAttribute("broadcastStartTh");
	 	obj.broadcastStartTm = editRow.getAttribute("broadcastStartTm");
	 	obj.broadcastStartTs = editRow.getAttribute("broadcastStartTs");
	 		 	
	 	obj.monLength = editRow.getAttribute("monLength");
	 	obj.tueLength = editRow.getAttribute("tueLength");
	 	obj.wenLength = editRow.getAttribute("wenLength");
	 	obj.thiLength = editRow.getAttribute("thiLength");
	 	obj.friLength = editRow.getAttribute("friLength");
	 	obj.satLength = editRow.getAttribute("satLength");
	 	obj.sunLength = editRow.getAttribute("sunLength");
	 }	 
	 
	function save(event){
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");
		var id = saveImgTd.getAttribute("paraId");

		DWRUtil.getValues(obj);
		obj.id = id;

//		OBJ.savePriceDetail(obj,mode);
	}	 
	
	function cannel(event){
		 OBJ.reset();
//		 OBJ.getPriceDetails();
	}	 	
	 
	//从编辑行中获得数据，来添对象
	if(mode =='edit'){ 
		getRowDataInObj(editRow);
	}


//////////////////构造新行 start //////////////////
	
	var container = document.createElement("span");
	var newRow = document.createElement("tr");
	//给新行设置ID属性
	newRow.setAttribute("id",obj.id);
		
	var cell = []; var j = 0;
		
	var saveImgTd = makeImagTd("image/save.png","Btn_SaveWorkspan","18","18",obj.id,"");
	var cannelImgTd =makeImagTd("image/restore.png","btn_CannelWorkspan","18","18",0,"");
	
	var start_date = mode=='new'?getCurYearFirstDay():obj.beginDate;
	var end_date = mode=='new'?getCurYearLastDay():obj.endDate; 
	 	
    
    cell[j++] =  makeInputTextTd3("beginDate","text","8px",start_date,"")
    cell[j++] =  makeInputTextTd3("endDate","text","8px",end_date,"")
    
    
    
	if(config_withBroPoint != 1 ){
		cell[j++] =  makeInputTextTd3("broadcastStartTime","text","5px",obj.broadcastEndTime,"");
	}else{
		var td1 = document.createElement("td"); 
		td1.setAttribute("width","10%");
		td1.appendChild(makeInputText2("broadcastStartTh","text","2px",obj.broadcastStartTh,""));
		td1.appendChild(makeInputText2("broadcastStartTm","text","2px",obj.broadcastStartTm,""));
		td1.appendChild(makeInputText2("broadcastStartTs","text","2px",obj.broadcastStartTs,""));
		cell[j++] = td1;
		//cell[j++] =  makeInputTextTd("broadcastStartTime","text","5px",obj.broadcastEndTime,"");
	}    
//	cell[j++] =  makeInputTextTd("broadcastStartTime","text","5px",obj.broadcastStartTime,"");
	
	cell[j++] =  makeInputTextTd3("monLength","text","5px",obj.monLength,"");
	cell[j++] =  makeInputTextTd3("tueLength","text","5px",obj.tueLength,"");
	cell[j++] =  makeInputTextTd3("wenLength","text","5px",obj.wenLength,"");
	cell[j++] =  makeInputTextTd3("thiLength","text","5px",obj.thiLength,"");
	cell[j++] =  makeInputTextTd3("friLength","text","5px",obj.friLength,"");
	cell[j++] =  makeInputTextTd3("satLength","text","5px",obj.satLength,"");
	cell[j++] =  makeInputTextTd3("sunLength","text","5px",obj.sunLength,"");
	cell[j++] =  saveImgTd;
	cell[j++] =  cannelImgTd;

	for (var i = 0;i < cell.length;i++ ){
		newRow.appendChild(cell[i]);
	}
	container.appendChild(newRow);
	
//////////////////构造新行 end ///////////////////

	
	//编辑状态：追加新行，删除旧行	
	if(mode =='edit'){
		new Insertion.After(editRow,container.innerHTML);
		editRow.remove();	
	}else{
	//新添状态，直接追加新行
		if(tBody.rows.length == page.pageSize) DWRUtil.removeAllRows(tBody);
		tBody.appendChild(newRow);
	}
		
	//只能在新行添完后，才能给对象添加事件
	var btn_SaveImgTd = $("Btn_SaveWorkspan"); btn_SaveImgTd.onclick = saveAddandEditWorkspan;
	var btn_CannelImgTd = $("btn_CannelWorkspan"); btn_CannelImgTd.onclick = cannelAddandEdit;	
	
	$("monLength").addEventListener("keyup",changeOtherLength,false);
//	$("monLength").addEventListener("mouseover",changeOtherLength,false);
	
	if(mode =='edit'){
		btn_SaveImgTd.setAttribute("mode","edit")
	}else{
		btn_SaveImgTd.setAttribute("mode","new")
	}

	setColors(tBody,this.color1,this.color2);
}

     
Workspan.prototype.check_all_adTimes = function(el,year){

   		var callBack=function(){
	   			el.disabled = false;
	   			el.removeAttribute("disabled");
	   			Ext.MessageBox.alert('系统提示','校对完成！',function(){});     
   		}

   		Ext.MessageBox.hide();	

		Ext.MessageBox.confirm('系统提示','校正所有的段位的广告时间可能需要比较长的时间，是否继续？', function(btn) {
 			  if (btn == 'yes') {
	   			el.disabled = true;
	   			try{
	   				WorkspanManager.resetAllSpecByOrderDayInfo(year,callBack);
	   			}catch(e){
	   				Ext.MessageBox.alert('系统提示','系统发生意外错误',function(){});     
	   				el.disabled = false;
	   			}
	   			
              }else{
				 return false; 	
              } 
		 });
}
