
function ResourceLimit(){
	//��������
	this.obj ={
		id:null,
        version:null,
        startTime:null,
        endTime:null,
        limitTime:null,
        carrierId:null,
        starT:null,
        starTh:null,
        starTm:null,
        starTs:null,
        endT:null,
        endTh:null,
        endTm:null,
        endTs:null,
        limitT:null,
        limitTh:null,
        limitTm:null,
        limitTs:null,
        usedT:null,
        preT:null,
        resourceLimitIdList:new Array()
	}
	
    this.className = null;
	this.tableName = null;	
	this.tBody = null;
	this.IdPrefix = null;
	this.fillObjName = null;
	this.pageInfo ="";
	this.pageSize ="20";
	this.page = null;
	
	return this;
}


//��ն���
ResourceLimit.prototype.reset = function(){
	this.obj.id = null;
    this.obj.version = null;
      
    this.obj.startTime = null;
    this.obj.endTime = null;
    this.obj.limitTime = null;
    this.obj.carrierId = null;

    this.obj.starT = null;
    this.obj.starTh = null;
    this.obj.starTm = null;
    this.obj.starTs = null;
    this.obj.endT = null;
    this.obj.endTh = null;
    this.obj.endTm = null;
    this.obj.endTs = null;
    this.obj.limitT = null;
    this.obj.limitTh = null;
    this.obj.limitTm = null;
    this.obj.limitTs = null;
    this.obj.usedT = null;
    this.obj.preT = null;
    this.obj.resourceLimitIdList = new Array();
}

//������ֵ
ResourceLimit.prototype.setObject = function(sourObj){
	this.obj.id = sourObj.id;
	this.obj.version = sourObj.version;
	    
    this.obj.startTime = sourObj.startTime;
    this.obj.endTime = sourObj.endTime;
    this.obj.limitTime = sourObj.limitTime;
    this.obj.carrierId = sourObj.carrierId;

    this.obj.starT = sourObj.starT;
    this.obj.starTh = sourObj.starTh;
    this.obj.starTm = sourObj.starTm;
    this.obj.starTs = sourObj.starTs;
    this.obj.endT = sourObj.endT;
    this.obj.endTh = sourObj.endTh;
    this.obj.endTm = sourObj.endTm;
    this.obj.endTs = sourObj.endTs;
    this.obj.limitT = sourObj.limitT;
    this.obj.limitTh = sourObj.limitTh;
    this.obj.limitTm = sourObj.limitTm;
    this.obj.limitTs = sourObj.limitTs;    
    
    this.obj.usedT = sourObj.usedT;
    this.obj.preT = sourObj.preT;
}

/*******************************************
*			����Ļ�����������                
*******************************************/

ResourceLimit.prototype.getResourceLimit = function(callBackFun){
	ResourceLimitManager.getResourceLimit(callBackFun,this.obj.id);
}
/* ����б�*/
ResourceLimit.prototype.getResourceLimits = function(callBackFun,type){
    var page = this.page;
    var obj = this.obj;
    if (page.pageSize > 0){
    	function getCountFun(size){ 
			page.size = size;
			page.MakePageNav(page.pageIndex,page.pageInfo);
			if(type ==2){
				ResourceLimitManager.getResourceLimitsPageXML(callBackFun,obj,page.pageIndex-1,page.pageSize);
			}else{
				ResourceLimitManager.getResourceLimitsPage(callBackFun,obj,page.pageIndex-1,page.pageSize);
			}
		}
    	ResourceLimitManager.getResourceLimitsCount(getCountFun,obj);	
    }else{
  		if(type ==2){
				ResourceLimitManager.getResourceLimitsXML(callBackFun,obj);
		}else{
				ResourceLimitManager.getResourceLimits(callBackFun,obj);
		}     
    }
}

/* ����*/
ResourceLimit.prototype.saveResourceLimit = function(callBackFun){
	ResourceLimitManager.saveResourceLimit(this.obj,callBackFun);
}
/* ɾ��*/
ResourceLimit.prototype.removeResourceLimit = function(callBackFun){
	ResourceLimitManager.removeResourceLimit(callBackFun,this.obj.id);	
}
ResourceLimit.prototype.getResourceLimitsForXML = function(callBackFun,obj,type){
	ResourceLimitManager.getResourceLimitsForXML(callBackFun,obj,type);
}



	//��֯�б� objs �Ƿ��صĶ������飬��DWRUtil.addRows����
ResourceLimit.prototype.fillTalbe = function(objs){
	var OBJ = this;
	var tBody  = this.tBody;
	var color1 = this.color1;
	var color2 = this.color2;

		//�༭ͼ��Ĵ������¼�
		function edit(event){
			var e = event || window.event;
			var editImg = Event.element(e);
			var editRow = editImg.parentNode.parentNode;
			OBJ.addNewRow("edit",editRow);
		}
		//ɾ��ͼ��Ĵ������¼�
		function del(event){
			var e = event || window.event;
			var deleImg = Event.element(e);
			var delRow = deleImg.parentNode.parentNode;
			var id = delRow.obj.id;
			OBJ.obj.id = id;
			function cannel(){
				cannelResourceLimit();
			}
			OBJ.removeResourceLimit(cannel);
		}
		
		//һ���У�����Ԫ�񷵻ص�����
		var cellTable=[
						function(obj){ return obj.starT;},
						function(obj){ return obj.endT;},
						function(obj){ return obj.limitT;},  
						
					    function(obj) {
					    	var editImg = makeImagHtml("image/edit.png","Btn_editResourceLimits","18","18",obj.id,"");
					    	editImg.onclick = edit;
					    	return editImg;}, 
					    function(obj) {
							var deleImg = makeImagHtml("image/button_delete.gif","Btn_deleteResourceLimits","18","18",obj.id,"");
							deleImg.onclick = del;
					    	return deleImg;} 
				];	
		
		//��ɾ�� tobdy		
		DWRUtil.removeAllRows(tBody);
		//�����¹����µı�
		DWRUtil.addRows(tBody,objs,cellTable,{
					rowCreator:function(options) {  
							   var row = document.createElement("tr"); 
							   row.obj = options.rowData;
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

/* ������� �༭��ɾ�� 
 * 
 */
ResourceLimit.prototype.addNewRow = function(mode,editRow){
    var OBJ = this;
	var page = this.page;
	var tBody = this.tBody;
	var obj = this.obj;
	
	if (!checkEeitState('btn_SaveImgTd')) return false;

	function save(event){
		var e = event || window.event;
		var editImg = Event.element(e);
		var editRow = editImg.parentNode.parentNode;
		var id = editRow.getAttribute("id");
		saveResourceLimit(id);
	}	 
	
	function cannel(event){
		cannelResourceLimit();
	}	 	
	 
	//�ӱ༭���л�����ݣ��������
	if(mode =='edit'){ 
	 	obj  = editRow.obj;
	}


	//////////////////�������� start //////////////////
	
	var container = document.createElement("span");
	var newRow = document.createElement("tr");
	//����������ID����
	newRow.setAttribute("id",obj.id);
		
	var cell = []; var j = 0;
		
	var saveImgTd = makeImagTd("image/save.png","btn_SaveImgTd","18","18",0,"");
	var cannelImgTd =makeImagTd("image/restore.png","btn_CannelImgTd","18","18",0,"");

    var td1 = document.createElement("td"); 
	td1.appendChild(makeInputText2("starTh","text","2px",obj.starTh,""));
	td1.appendChild(makeInputText2("starTm","text","2px",obj.starTm,""));
	td1.appendChild(makeInputText2("starTs","text","2px",obj.starTs,""));
	cell[j++] = td1;
	
	
    var td2 = document.createElement("td"); 
	td2.appendChild(makeInputText2("endTh","text","2px",obj.endTh,""));
	td2.appendChild(makeInputText2("endTm","text","2px",obj.endTm,""));
	td2.appendChild(makeInputText2("endTs","text","2px",obj.endTs,""));
	cell[j++] = td2;	
	
	
    var td3 = document.createElement("td"); 
	td3.appendChild(makeInputText2("limitTh","text","2px",obj.limitTh,""));
	td3.appendChild(makeInputText2("limitTm","text","2px",obj.limitTm,""));
	td3.appendChild(makeInputText2("limitTs","text","2px",obj.limitTs,""));
	cell[j++] = td3;
	
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