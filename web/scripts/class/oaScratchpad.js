
function OaScratchpad(){

	this.obj = {
		id:null,
		content:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null
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
	
	this.pageHTML = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	
	return this;	
}	

//清空对象
OaScratchpad.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
}	
OaScratchpad.prototype.getOaScratchpad = function(id,setValueFun){
	
	OaScratchpadManager.getOaScratchpad(setValueFun,id);
		
}	
	
OaScratchpad.prototype.getOaScratchpads = function(o,func){
	var OBJ = o;
	var obj = OBJ.obj;
	var page   = this.page;

    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		OaScratchpadManager.getOaScratchpadsPage(func,obj,page.pageIndex,page.pageSize);
    }else{
		OaScratchpadManager.getOaScratchpads(func,obj);	
    }
}	

//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
OaScratchpad.prototype.fillTalbe = function(objs){	
	var OBJ = scratchpad;
	var obj = OBJ.obj;
	var tBody  = scratchpad.tBody;
	var color1 = scratchpad.color1;
	var color2 = scratchpad.color2;
	
	
	
	//把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("title", rowData.content);
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

				    function(obj) {
						var editImg = makeImagHtml("image/notesico.gif","Btn_editPrices","25","25",obj.id,"");
						return editImg;
 					}, 
					function(obj){
						var content = obj.content;
						
						content = content.substring(0,10);
						
						return 	'<a href="javascript:void 0" onClick="editOaScratchpad(\'' + obj.id + '\')">'+ content + "</a>";
					},
//				    function(obj) {
//						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"");
//						if(OBJ.enableDel) deleImg.onclick = del;
//				    	return deleImg;} 
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
OaScratchpad.prototype.fillTableSC = function(objs){
	var OBJ = scratchpad;
	var obj = OBJ.obj;
	
	var editImg = makeImagHtml("image/notesico.gif","Btn_editPrices","25","25",obj.id,"");
	
	var str = "<table border=1>";
		
		for(var i=0;i<(objs.length/5);i++){
			str += "<tr>";
			for(var j=0;j<5;j++){
				str += "<td>";
				str += editImg;
				str += getContent(objs);
				str += "</td>";
			}
			str += "</tr>";
		}
	
		str += "</table>";
		
	return str; 
}
OaScratchpad.prototype.saveOaScratchpad = function(o,mode,saveFun){	
	
	var OBJ = this;
	var obj = o;	
	
	if (mode == 'new') obj.id = null;
	
	OaScratchpadManager.saveOaScratchpad(obj,saveFun);
	
}

OaScratchpad.prototype.removeOaScratchpad = function(id,fun){	
	var OBJ = this;
	
	if(!confirmDelete(OBJ.className)) return false;
	
	OaScratchpadManager.removeOaScratchpad(fun,id);
}



	