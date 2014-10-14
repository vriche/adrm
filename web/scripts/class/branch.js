

function Branch(){
	//��������
	this.obj ={
		id:null,
		name:null,
		makeSelect:null,
		parentId:null,
		treeLevel:null,
		displayNo:null,
		createBy:null,
		version:null
	}

	this.treebox = null;
	this.tree = null;
		
	this.tBody = null;
	this.IdPrefix = null;
	this.fillObjName = null;
	this.selectName =null;
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
Branch.prototype.reset = function(){
	this.obj.id = null;
	this.obj.name = null;
	this.obj.orgId = null;
	this.obj.parentId = null;
	this.obj.treeLevel = null;
	this.obj.displayNo = null;
	this.obj.createBy = null;
	this.obj.version = null;
}

/*******************************************
*			����Ļ�����������                
*******************************************/

Branch.prototype.getBranch = function(id){
	var o = null;
	this.reset();
	DWRUtil.setValues(this.obj);

	DWREngine.setAsync(false);
	BranchManager.getBranch(id,setValueFun);
	DWREngine.setAsync(true);	
	function setValueFun(obj){
		DWRUtil.setValues(obj);
		o = obj;
	}
	return o;
}
/* ����б�
 * obj �������
 * fillObjName ���� TBODY ��ID��
 */
Branch.prototype.getBranchs = function(){
	var OBJ = this;
	var obj = this.obj;
	var page   = this.page;
	var tBody  = this.tBody;
	var color1 = this.color1;
	var color2 = this.color2;

    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		BranchManager.getBranchsPage(obj,page.pageIndex,page.pageSize,fillTalbe);
    }else{
		BranchManager.getBranchs(obj,fillTalbe);	
    }

   
	//��֯�б� objs �Ƿ��صĶ������飬��DWRUtil.addRows����
    function fillTalbe(objs){
		 //���е����ݷŵ��е�������
		 //row �Ǵ������ж���  options��������
		 function putRowDataInHidden(row,rowData){
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("name", rowData.name);
//		 	row.setAttribute("treeLevel", rowData.treeLevel);
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
			OBJ.removeBranch(id,delRow);
		}
		
		//һ���У�����Ԫ�񷵻ص�����
		var cellTable=[
						function(obj){ return obj.name;},
					    function(obj) {
					    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"");
					    	if(OBJ.enableEdit) editImg.onclick = edit;
					    	return editImg;}, 
					    function(obj) {
							var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"");
							if(OBJ.enableDel) deleImg.onclick = del;
					    	return deleImg;} 
				];	
		
		//��ɾ�� tobdy		
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
}
/* ����
 * obj ��װ�����ݵĶ���
 * mode ����ģʽ  ״̬Ϊ new ʱ�������� id = null
 */
Branch.prototype.saveBranch = function(mode){
	var OBJ = this;
	var obj =  this.obj;
	var id = null;

	if (mode == 'new') obj.id = null;
	
	DWREngine.setAsync(false);
	BranchManager.saveBranch(obj,saveFun);
	DWREngine.setAsync(true);

	function saveFun(newId){
		OBJ.reset();
		id = newId;
	}
	return id;
}

Branch.prototype.saveBranchUser = function(orgId,userId,branchId){
	DWREngine.setAsync(false);
	BranchManager.saveBranchUser(orgId,userId,branchId,saveFun);
	DWREngine.setAsync(true);
	function saveFun(){}
}

Branch.prototype.removeBranchUser = function(userId,branchId){
	BranchManager.removeBranchUser(userId,branchId,saveFun);
	function saveFun(){}
}

Branch.prototype.saveBranchRelation = function(parentId){
	var obj = this.obj
	var o = this.getBranch(obj.id);
	o.parentId = parentId;
//	alert(o.parentId);
	this.obj = o;
	this.saveBranch(o,saveFun);
	function saveFun(){}
}

Branch.prototype.saveBranchRelation2 = function(parentId,orgId){
	var obj = this.obj
	var o = this.getBranch(obj.id);
	o.parentId = parentId;
	o.orgId = orgId;
	if(obj.displayNo == ''|| isUndefined(obj.displayNo)) o.displayNo = 0;
	this.obj = o;
	this.saveBranch(o,saveFun);
	function saveFun(){}
}

Branch.prototype.saveUserOrg = function(orgId_old,orgId,branchId){
	BranchManager.saveUserOrg(orgId_old,orgId,branchId,saveFun);
	function saveFun(){}
}



/* ɾ��
 * ����idɾ������
 */
Branch.prototype.removeBranch = function(id,delRow){
	var OBJ = this;
	var obj = this.obj;
	var page = this.page;
	var curRow = OBJ.tBody.rows.length;
	
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie������ delRow.remove();
	curRow--;
	BranchManager.removeBranch(id,removeFun);	
	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
		OBJ.getBranchs(obj);
   }
}
/* �ܼ�¼��
 * 
 */
Branch.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	BranchManager.getBranchsCount(obj,getCountFun);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}
/* ������� �༭��ɾ�� 
 * 
 */
Branch.prototype.addNewRow = function(mode,editRow){
    var OBJ = this;
	var obj = this.obj;
	var page = this.page;
	var tBody = this.tBody;
	
	if (!checkEeitState('btn_SaveImgTd')) return false;
	
	function getRowDataInObj(editRow){
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.name = editRow.getAttribute("name");
//	 	obj.treeLevel = editRow.getAttribute("treeLevel");
	 }	 
	 
	function save(event){
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");
		var id = saveImgTd.getAttribute("paraId");

		DWRUtil.getValues(obj);

		OBJ.saveBranch(obj,mode);
	}	 
	
	function cannel(event){
		 OBJ.reset();
		 OBJ.getBranchs();
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

	cell[j++] =  makeInputTextTd("name","text","10px",obj.name,"");
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
	var btn_SaveImgTd =$("btn_SaveImgTd"); btn_SaveImgTd.onclick = save;
	var btn_CannelImgTd =$("btn_CannelImgTd"); btn_CannelImgTd.onclick = cannel;	
	
	if(mode =='edit'){
		btn_SaveImgTd.setAttribute("mode","edit")
	}else{
		btn_SaveImgTd.setAttribute("mode","new")
	}

	setColors(tBody,this.color1,this.color2);
}


 Branch.prototype.makeSelect = function(obj,name,event,callBakFun) {
	DWREngine.setAsync(false);
	BranchManager.getBranchSelect(obj,setValueFun);
	DWREngine.setAsync(true);	
	
	function setValueFun(objs){
		// makeSelectHtml(objs,name,event);
		makeSelectHtmlWidth(objs,name,event,100)
		 if(callBakFun) callBakFun();
	}
}    
   
 Branch.prototype.makeSelect2 = function(obj,name,event,callBakFun) {
		DWREngine.setAsync(false);
		BranchManager.getBranchSelect(obj,setValueFun);
		DWREngine.setAsync(true);	
		
		function setValueFun(objs){
			makeSelectHtmlWidth(objs,name,event,155)
			 if(callBakFun) callBakFun();
		}
	}  

/***********************************************
* 		       ���δ���                               
************************************************/
/* ����������Ϣ	
 * �ȳ�ʼ���������ټ�������
 */
Branch.prototype.getTreeXML = function(){
	var OBJ = this;
	var treeXMLString;

	DWREngine.setAsync(false);
	BranchManager.getBranchsXML(this.obj,this.IdPrefix,getxml);
	DWREngine.setAsync(true);
	
	function getxml(treeXML){ 
		
		OBJ.tree.treeXML = treeXML; 
		treeXMLString = treeXML;
	} 
	

    return treeXMLString;
}


Branch.prototype.getTreeXML2 = function(getxml){

	BranchManager.getBranchsXML(this.obj,this.IdPrefix,callBakFun);
	DWREngine.setAsync(true);
	
	function callBakFun(treeXML){ 
		if(getxml) getxml(treeXML)
	} 

}



////�ڵ�õ����㣬�������¼�
//Branch.prototype.doOnSelectTree = function(itemId){
//	var dhtmlTree = branch.tree.dhtmlTree;
//	dhtmlTree.setItemColor(itemId,"red","pink"); 
//	
//}
////�ڵ�ı�ʱ���������¼�
//Branch.prototype.doOnTextChangeTree  = function(itemId){
//	var dhtmlTree = branch.tree.dhtmlTree;
//	
//	branch.obj.parentId = 0;
//	branch.obj.id = 0;
//	branch.obj.name = dhtmlTree.getItemText(itemId);
//	branch.saveBranch(branch);
//}
////�ڵ㱻�϶�ǰ���������¼�
//Branch.prototype.doOnBeforeDropTree  = function(itemId,parentId){
//	var dhtmlTree = branch.tree.dhtmlTree;
//
//}

Branch.prototype.getBranchLists = function(o){
	var OBJ = o;
	var obj = this.obj;
	var page   = this.page;
	var tBody  = this.tBody;
	var color1 = this.color1;
	var color2 = this.color2;


    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		BranchManager.getBranchsPage(obj,page.pageIndex,page.pageSize,fillTalbe);
    }else{
		BranchManager.getBranchs(obj,fillTalbe);	
    }


   
	//��֯�б� objs �Ƿ��صĶ������飬��DWRUtil.addRows����
    function fillTalbe(objs){
		 //���е����ݷŵ��е�������
		 //row �Ǵ������ж���  options��������
		 function putRowDataInHidden(row,rowData){
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("name", rowData.name);
//		 	row.setAttribute("treeLevel", rowData.treeLevel);
		 }	
		 
		//�༭ͼ��Ĵ������¼�
		function edit(event){
			var e = event || window.event;
			var editImg = Event.element(e);
			var id = editImg.getAttribute("paraId"); 
			
			var editRow = $(OBJ.IdPrefix + id);
//			OBJ.addNewRow("edit",editRow);
		}
		//ɾ��ͼ��Ĵ������¼�
		function del(event){
			var e = event || window.event;
			var deleImg = Event.element(e);
			var id = deleImg.getAttribute("paraId"); 
			var delRow = deleImg.parentNode.parentNode;
			OBJ.removeBranch(id,delRow);
		}
		
		//һ���У�����Ԫ�񷵻ص�����
		var cellTable=[
						function(obj){ return obj.name;},
						function(obj){ return obj.displayNo;},
						function(obj){ 
							var ck = makeInputCheckBox("treeLevel_2","checkbox","1",obj.treeLevel,null);
							return ck;
							},
					    function(obj) {
//					    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"edit('branchId"+obj.id+"')");
					    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"edit('"+obj.id+"')");
//					    	if(OBJ.enableEdit) editImg.onclick = edit;
					    	return editImg;}, 
					    function(obj) {
							var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"delBranch");
//							if(OBJ.enableDel) deleImg.onclick = del;
					    	return deleImg;} 
				];	
		
		//��ɾ�� tobdy		
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
}


Branch.prototype.saveBranchList = function(obj,callBackFun){

BranchManager.saveBranch(obj,saveFun);

	function saveFun(newId){
		
		callBackFun(newId);
		
	}

}
Branch.prototype.getBranchMenu= function(id,callBackFun){
	this.reset();
	DWRUtil.setValues(this.obj);
	BranchManager.getBranch(id,setValueFun);
	function setValueFun(obj){
		callBackFun(obj);
	}
}

Branch.prototype.removeBranchList = function(id,delRow,parentId,branch){
	var OBJ = this;
	var obj = this.obj;
	var page = this.page;
	var curRow = OBJ.tBody.rows.length;
	
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie������ delRow.remove();
	curRow--;
	BranchManager.removeBranch(id,removeFun);	
	function removeFun(){
//		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
//		var fid = branch.tree.getSelectedItemId(branch.IdPrefix) == -1?0:branch.tree.getSelectedItemId(branch.IdPrefix);
//		branch.obj.parentId = parentId;
//		OBJ.getBranchLists(obj);
//		page.pageIndex  = 0;

		branch.tree.dhtmlTree.selectItem(parentId);		
	
		
   }
}











 	