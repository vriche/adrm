function SysMenu(){
	//��������
	this.obj ={
		id:null,
		name:null,
	    parentId:null,
	    treeLevel:null,
	    displayNo:null,
	    description:null,
	    location:null,	    
	    title:null,
	    target:null,
	    onclick:null,
	    onmouseover:null,
	    onmouseout:null,
	    image:null,
	    altImage:null,
	    tooltip:null,
	    roles:null,
	    pageNum:null,
	    width:null,
	    height:null,
	    forward:null,
	    action:null,
	    image:null,
	    isDisplay:null
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

//��ն���
SysMenu.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.parentId = null;
  	this.obj.treeLevel = null;
  	this.obj.title = null;

  	this.obj.displayNo = null;
  	this.obj.description = null;
  	this.obj.nodeLevel = null;
	this.obj.location = null;
	this.obj.target = null;
	this.obj.onclick = null;
	
	this.obj.onmouseover = null;
	this.obj.onmouseout = null;
	this.obj.image =null;
	this.obj.altImage = null;	
	this.obj.tooltip = null;	
	this.obj.roles = null;
	
	
	this.obj.pageNum = null;
	this.obj.width = null;
	this.obj.height = null;	
	this.obj.forward = null;	
	this.obj.action = null;
	this.obj.isDisplay = null;


  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
}

SysMenu.prototype.getSysMenu = function(id,callBackFun){
	this.reset();
	DWRUtil.setValues(this.obj);
	SysMenuManager.getSysMenu(setValueFun,id);
	function setValueFun(obj){
		callBackFun(obj);
	}
}

SysMenu.prototype.getSysMenuById = function(id,parentId,callBackFun){
	var pId =parentId;
	SysMenuManager.getSysMenu(setValueFun,id);
	function setValueFun(obj){
//		alert(pId);
		callBackFun(obj,pId);
	}
}

/* ����б�
 * obj �������
 * fillObjName ���� TBODY ��ID��
 */
SysMenu.prototype.getSysMenus = function(o){
	var OBJ = o;
	var obj = OBJ.obj;
	var page   = this.page;

    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		
		page.MakePageNav(page.pageIndex,page.pageInfo);
		SysMenuManager.getSysMenusPage(OBJ.fillTalbe,obj,page.pageIndex,page.pageSize);
    }else{
		SysMenuManager.getSysMenus(OBJ.fillTalbe,obj);	
    } 
}

SysMenu.prototype.fillTalbe = function(objs){
	var OBJ = sysMenu;
	var obj = OBJ.obj;
	var tBody  = sysMenu.tBody;
	var color1 = sysMenu.color1;
	var color2 = sysMenu.color2;
	
	
	 //���е����ݷŵ��е�������
	 //row �Ǵ������ж���  options��������
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("name", rowData.name);
	 	row.setAttribute("altImage", rowData.altImage);
	 	row.setAttribute("action", rowData.action);
	 	row.setAttribute("title", rowData.title);
	 	row.setAttribute("displayNo", rowData.displayNo);
	 	row.setAttribute("parentId", rowData.parentId);
	 }	
	 
	//�༭ͼ��Ĵ������¼�
	function edit(event){
		var e = event || window.event;
		var editImg = Event.element(e);
		var id = editImg.getAttribute("paraId"); 
		
		var editRow = $(OBJ.IdPrefix + id);
		OBJ.addNewRow("edit",editRow);
	}
	//ɾ��ͼ��Ĵ������¼�
	function del(event){
		var e = event || window.event;
		var deleImg = Event.element(e);
		var id = deleImg.getAttribute("paraId"); 
		var delRow = deleImg.parentNode.parentNode;
		OBJ.removeSysMenu(id,delRow);
	}
	
	//һ���У�����Ԫ�񷵻ص�����
	var cellTable=[
					function(obj){ return obj.name},
					function(obj){ return obj.altImage},
					function(obj){ return obj.action},
					function(obj){ return obj.title},
					function(obj){ return obj.displayNo},
				    function(obj) {
				    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"editSysMenu");
//					    	if(OBJ.enableEdit) editImg.onclick = edit;
				    	return editImg;}, 
				    function(obj) {
						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"delSysMenu");
//							if(OBJ.enableDel) deleImg.onclick = del;
				    	return deleImg;} 
			];	
	
	//��ɾ�� tbody		
	DWRUtil.removeAllRows(tBody);
	//�����¹����µı�
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
				
	//�����ÿһ������ɫ������ global.js �е�setColors����
	setColors(tBody, color1, color2);
}

/* �ܼ�¼��
 * 
 */
SysMenu.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	SysMenuManager.getSysMenusCount(getCountFun,obj);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}

/* ����
 * obj ��װ�����ݵĶ���
 * mode ����ģʽ  ״̬Ϊ new ʱ�������� id = null
 */
SysMenu.prototype.saveSysMenu = function(obj,callBackFun){
	SysMenuManager.saveSysMenu(obj,saveFun);
	function saveFun(newId){
		callBackFun(newId);
	}
}
/*
 * ��sysMenuService.js�е�save_sysMenu�������õ�
 */
SysMenu.prototype.saveMenu = function(o,mode){
	var OBJ = o;
	var obj = OBJ.obj;
	var id;
	
	if (mode == 'new') obj.id = null;
	
	DWREngine.setAsync(false);
	SysMenuManager.saveSysMenu(obj,saveFun);
	DWREngine.setAsync(true);

	function saveFun(newId){
		OBJ.reset();
		id = newId;
	}
	return id;
}



/* ɾ��
 * ����idɾ������
 */
SysMenu.prototype.removeSysMenu = function(id,delRow){
	var OBJ = this;
	var obj = this.obj;
	var page = this.page;
	var curRow = this.tBody.rows.length;
	
	if (!checkEeitState('btn_SaveImgTd')) return false;
	
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie������ delRow.remove();
	curRow--;
	DWREngine.setAsync(false);
	SysMenuManager.removeSysMenu(removeFun,id);	
	DWREngine.setAsync(true);
	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
//		OBJ.getOaDocuments();
   }
   return true;
}

/* 
 * ������� �༭��ɾ�� 
 */
SysMenu.prototype.addNewRow = function(mode,editRow){
    var OBJ = this;
    var obj = this.obj;
	var page = this.page;
	var tBody = this.tBody;

	/*
	 * 
	 */
	if (!checkEeitState('btn_SaveImgTd')) return false;
	
	function getRowDataInObj(editRow){
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.name = editRow.getAttribute("name");
	 }	 
	 
	function save(event){
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");
		var id = saveImgTd.getAttribute("paraId");

		DWRUtil.getValues(obj);

		OBJ.saveSysMenu(obj,mode);
	}	 
	
	function cannel(event){
		 OBJ.reset();
		 OBJ.getSysMenus()
	}	 	
	 
	//�ӱ༭���л�����ݣ��������
	if(mode =='edit'){ 
		getRowDataInObj(editRow);
	}


	//////////////////�������� start //////////////////
	
	var container = document.createElement("span");
	var newRow = document.createElement("tr");
	//����������ID����
	newRow.setAttribute("id",obj.id);
		
	var cell = []; var j = 0;
		
	var saveImgTd = makeImagTd("image/save.png","btn_SaveImgTd","18","18",obj.id,"");
	var cannelImgTd =makeImagTd("image/restore.png","btn_CannelImgTd","18","18",0,"");

	cannelImgTd.onclick = function(){
	    newRow.remove(); 
    	setColors(tBody,color1,color2);
    }

	cell[j++] =  makeInputTextTd("name","text","10px",obj.name,"");
	cell[j++] =  makeInputTextTd("value","text","10px",obj.value,"");
	cell[j++] =  makeInputTextTd("calculateAuto","text","10px",obj.calculateAuto,"");
	cell[j++] =  saveImgTd;
	cell[j++] =  cannelImgTd;

	for (var i = 0;i < cell.length;i++ ){
		newRow.appendChild(cell[i]);
	}
	container.appendChild(newRow);
	
	//////////////////�������� end ///////////////////
	
	
	
	//�༭״̬��׷�����У�ɾ������	
	if(mode =='edit'){
		new Insertion.After(editRow,container.innerHTML);
		editRow.remove();	
	}else{
	//����״̬��ֱ��׷������
		if(tBody.rows.length == page.pageSize) DWRUtil.removeAllRows(tBody);
		tBody.appendChild(newRow);
	}
		
	//ֻ������������󣬲��ܸ���������¼�
	var btn_SaveImgTd = $("btn_SaveImgTd"); btn_SaveImgTd.onclick = save;
	var btn_CannelImgTd = $("btn_CannelImgTd"); btn_CannelImgTd.onclick = cannel;	
	
	if(mode =='edit'){
		btn_SaveImgTd.setAttribute("mode","edit")
	}else{
		btn_SaveImgTd.setAttribute("mode","new")
	}

	setColors(tBody,this.color1,this.color2);
}

SysMenu.prototype.makeSelect = function(obj,name,event){
	
	DWREngine.setAsync(false);
	SysMenuManager.getSysMenuSelect(fillFun,obj);
	DWREngine.setAsync(true);
	
	
	function fillFun(objs){
		makeSelectHtml(objs,name,event);
	}
}

/* ����������Ϣ	
 * �ȳ�ʼ���������ټ�������
 */
SysMenu.prototype.getTreeXML = function(){
	var OBJ = this;
	var treeXMLString;
	
	DWREngine.setAsync(false);
	SysMenuManager.getSysMenuXML(this.obj,this.IdPrefix,getxml);
	DWREngine.setAsync(true);
	
	function getxml(treeXML){ 
		OBJ.tree.treeXML = treeXML; 
		treeXMLString = treeXML;
	} 

    return treeXMLString;
}



SysMenu.prototype.getValueFromCommand = function(selectCommand,type){
	var value = 0;
    var length = selectCommand.length;
 	if (length > 0){   
		for (var i=0; i<length;i++){
			if(selectCommand.item(i).text.indexOf(type) >-1)  value = selectCommand.item(i).value;
		}	
 	}
 	return value;
}


SysMenu.prototype.saveMenuRelation = function(id,parentId){
	
	var O = this;
    
	this.getSysMenuById(id,parentId,callBackFun);
	
	function callBackFun(o,pId){
		o.parentId = pId;
//		alert(o);
//		alert(o.parentId);
		O.saveSysMenu(o,callBackFun);
		function callBackFun(id){
//			alert(id);
		}
	}

}

SysMenu.prototype.saveSysMenuDefault = function(obj,callBackFun){
		SysMenuManager.saveSysMenuDefault(obj,callBackFun);
}

