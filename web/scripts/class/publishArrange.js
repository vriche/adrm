
function PublishArrange(){

	this.obj = {
		id:null,
		publishDate:null,
	    carrierId:null,
	    resourceId:null,
	    
	    
	    carrierName:null,
		resourceName:null,
		resourceMeno:null,
	    resourceTotalTimes:null,
	    resourceUsedTimes:null,
	    filePath:null,
	    memo:null,	    
		isEnable:null,
		isLocked:null,

	    createBy:null,
	    createDate:null,
		modifyBy:null,
		modifyDate:null,
	    version:null,
	    publishArrangeDetails:null,
	    details:null,
	    resourceIds:null,
	    isArranged:null
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
	
	this.selectName = null;
	
	this.pageInfo =""
	this.pageSize ="20"
	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	
	
	//this.resourceIds = null;
	
	return this;	
}	    
//清空对象
PublishArrange.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.publishDate = null;
  	this.obj.carrierId = null;
  	this.obj.resourceId = null;
  	
  	this.obj.carrierName = null;
	this.obj.resourceName = null;
  	this.obj.resourceMeno = null;
  	this.obj.resourceTotalTimes = null;
  	this.obj.resourceUsedTimes = null;
  	this.obj.filePath = null;
	this.obj.memo = null;
  	this.obj.isEnable = null;
  	this.obj.isLocked = null;
  	this.obj.selectName = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.publishArrangeDetails = null;
  	this.obj.details = null;
  	this.obj.resourceIds = null;
  	this.obj.isArranged = null;
  	
}

PublishArrange.prototype.saveAllLock = function(carrierId,publishDate,isLock,callbackFunc){
//	alert(objs.length);
	PublishArrangeManager.saveAllLock(carrierId,publishDate,isLock,setFun);
	function setFun(){callbackFunc();} 
}


PublishArrange.prototype.getTreeGrid = function(obj,resPrefix,adverIdPrefix,rebuid,isRoll,onlyHistory,callBackFun){
	PublishArrangeManager.getTreeGrid(obj,resPrefix,adverIdPrefix,rebuid,isRoll,onlyHistory,setFun);
	function setFun(treeGridXML){ callBackFun(treeGridXML);} 
}

PublishArrange.prototype.savePublishArrange = function(obj,callBackFun){
	PublishArrangeManager.savePublishArrange(obj,setFun);
	function setFun(id){ callBackFun(id);} 
}

PublishArrange.prototype.savePublishArrangeObjArray = function(objs,callBackFun){
	var obj = this.obj;
	PublishArrangeManager.savePublishArrangeObjArray(obj,objs,setFun);
	function setFun(){ callBackFun();} 
}

PublishArrange.prototype.getPublishArranges = function(obj,callBackFun){
	PublishArrangeManager.getPublishArranges(obj,setFun);
	function setFun(objs){callBackFun(objs);} 
}

PublishArrange.prototype.getPublishArrangesByIdListFromHistory = function(obj,callBackFun){
	PublishArrangeManager.getPublishArrangesByIdListFromHistory(obj,setFun);
	function setFun(objs){callBackFun(objs);} 
}


PublishArrange.prototype.removePublishArrange = function(id,callBackFun){
	PublishArrangeManager.removePublishArranges(setFun,id);
	function setFun(){callBackFun();} 
}

PublishArrange.prototype.deletePublishArrange = function(id,callBackFun){
	PublishArrangeManager.deleteArrangeAndDetail(setFun,id);
	function setFun(){callBackFun();} 
}

//根据资源数组和日期
PublishArrange.prototype.removePublishArranges = function(obj,callBackFun){
	PublishArrangeManager.removePublishArranges(setFun,obj);
	function setFun(){callBackFun();} 
}
PublishArrange.prototype.getPublishArrangesPage = function(OBJ,callBackFun){
	var obj = OBJ.obj;
	var page   = OBJ.page;

	 function makePage(size){
			page.size = size;
			page.MakePageNav(page.pageIndex,page.pageInfo);
	 }

    if (page.pageSize > 0){
		this.getCount(obj,makePage);
		PublishArrangeManager.getPublishArrangesPage(callBackFun,obj,page.pageIndex,page.pageSize);
		
    }else{
		PublishArrangeManager.getPublishArranges(callBackFun,obj);	
    } 
   
}

PublishArrange.prototype.getCount = function(obj,callBackFun){
	PublishArrangeManager.getPublishArrangesCount(getCountFun,obj);	
	function getCountFun(size){ callBackFun(size);}
 	
   
}

PublishArrange.prototype.fillTalbe = function(objs){
	var OBJ = publishArrange;
	var obj = OBJ.obj;
	var tBody  = publishArrange.tBody;
	var color1 = publishArrange.color1;
	var color2 = publishArrange.color2;
//	var myDate = new MyDate();
//	var calendar  = new Calendar();
//	calendar.setDateFormat("yyyy/MM/dd");
	
	

	
	
	 //把行的数据放到行的性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("rowData",rowData);
	 	row.rowDate = rowData;
	 	row.setAttribute("resourceId",rowData.resourceId);
	 	row.setAttribute("publishDate",rowData.publishDate);
	 }	
//	 alert("fillTalbe");

	//一行中，各单元格返回的内容
	var cellTable=[
					//function(obj){ return obj.publishDate},
					function(obj){ return obj.carrierName},
					function(obj){ return obj.resourceName},
//					function(obj){  
//						
//						 var dftDate =obj.createDate;
//						 var y = dftDate.getFullYear();
//						 var m = dftDate.getMonth()+1;
//						 var d = dftDate.getDate();
//						return y+"/"+m+"/"+d;
//						},
//					function(obj){ return  myDate.formatDate(obj.createDate,"yyyy/MM/dd")},
//					function(obj){ return obj.createBy},
					function(obj){ return obj.resourceTotalTimes},
					function(obj){ return obj.resourceUsedTimes},
					function(obj){ return obj.resourceTotalTimes*1 - obj.resourceUsedTimes*1},
					function(obj){ return cheng((obj.resourceUsedTimes / obj.resourceTotalTimes*100),2) +"%"},
					//function(obj){ return '<a href="javascript:void 0" onClick="fileInfo(\''+ obj.resourceId + '\',\''+obj.publishDate+'\')">' + obj.filePath +'</a>'},
					function(obj){ return makeInputCheckBox(OBJ.checkBoxName,"checkbox",obj.id,obj.isLocked,"setLockState")},
					 function(obj) {
						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deleteArrange","18","18",obj.id,"deleteArrange");
						if(!OBJ.enableDel) deleImg.onclick = function(){return false};
				    	return deleImg;} 

			];	
	
	//先删除 tbody		
	DWRUtil.removeAllRows(tBody);
	//再重新构造新的表
	
	var cellIndex = 0;
	DWRUtil.addRows(tBody,objs,cellTable,{
				rowCreator:function(options) {  
						   var row = document.createElement("tr"); 
				           putRowDataInHidden(row,options.rowData);
				           cellIndex = 0;
//				           row.setAttribute("onclick","javascript:editInfo("+ options.rowData.id +"," + options.rowData.customerCategoryId+ ")");
						   return row;  
					  },  
					  
				cellCreator:function(options) {  
						    var td = document.createElement("td"); 
						    cellIndex ++;

						    if(cellIndex == 2){
						    	 td.setAttribute("style","text-align:left;");
						    }else if(cellIndex == 2 || cellIndex == 6){
						    	 td.setAttribute("style","text-align:right;");
						    }else{
						    	 td.setAttribute("style","text-align:center;");
						    }
	    
						    return td;  
					  }  
				});
				
	//给表格每一行上颜色，调用 global.js 中的setColors函数
	setColors(tBody, color1, color2);
}

PublishArrange.prototype.savePublishArrangeLock = function(obj){
	PublishArrangeManager.savePublishArrange(obj)
}	

PublishArrange.prototype.getPublishArrange = function(id,callBackFun){
	PublishArrangeManager.getPublishArrange(id,setFun);
	function setFun(obj){
		callBackFun(obj);
	} 
}

PublishArrange.prototype.makeSelect = function(obj,name,event){
	var OBJ = this;
	var obj = this.obj;
	PublishArrangeManager.getPublishArrangeSelect(fillFun,obj);	
	
	function fillFun(objs){
		makeSelectHtml(objs,name,event);
	}
}

PublishArrange.prototype.getFileInfo = function(id,date){
	PublishArrangeManager.getFileInfo(id,date);
}


PublishArrange.prototype.downloadAdvers = function(obj,type,callBackFun){
	 PublishArrangeManager.downloadAdvers(obj,type,callBackFun);
}

PublishArrange.prototype.uploadFiles = function(server,prot,user,pass,publishDate,callBackFun){
	PublishArrangeManager.uploadFiles(server,prot,user,pass,publishDate,callBackFun);  
}

