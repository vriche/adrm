
function Tree(treeBoxName){
	this.treeBoxName = treeBoxName;
	this.width = "100%";
	this.heigth = "100%";
	this.rootId = treeBoxName;
	this.newItemId = "-1";
	this.newItemLabel = "New Item";
	
	
	this.preLoadImages = this.preLoadImages();
	this.dhtmlTree =  new dhtmlXTreeObject(this.treeBoxName,this.width,this.heigth,0);
	this.dhtmlTree.setImagePath("image/tree/");
	this.treeXML ="";
	
	this.curSelectItemId ="";
	
	return this;
}   

Tree.prototype.loadTree = function(treeXML){
		this.dhtmlTree.loadXMLString(treeXML);
}


Tree.prototype.refreshTree = function(){
	   //root节点下的第一节点
		var parentId = this.getItemIdByIndex(0);
//		alert(parentId);
		//刷新树
		this.dhtmlTree.setCheck(parentId,0);	
}

Tree.prototype.loadDataTreeArray1 = function(IdPrefix,array1){
		
		this.refreshTree();
		
		for (var i = 0; i < array1.length; i++){
			this.dhtmlTree.setCheck(IdPrefix + array1[i],1);					
		}	
}

Tree.prototype.loadDataTreeArray2 = function(IdPrefix,array2){

		//this.refreshTree();
		
		for (var i = 0; i < array2.length; i++){
			this.loadDataTreeArray1(IdPrefix,array2[i]);
		}	
}
Tree.prototype.loadDataTreeArray3 = function(orgId,array1,refresh){
		
		if(!refresh)this.refreshTree();

		var ids = this.dhtmlTree.getAllLeafs().split(",");

//		var ids2 = this.dhtmlTree.getAllSubItems(rootId);
		 


		for (var i = 0; i < ids.length; i++){
	   var ogid = ids[i].split("_")[0];
	   
	   if(ogid == orgId){
	   	
				var uid = this.dhtmlTree.getUserData(ids[i],"id");
				
				if(array1.contains(uid)) this.dhtmlTree.setCheck(ids[i],1);	
	   		}

		}	
		
		
//		for (var i = 0; i < array1.length; i++){
//	
//			this.dhtmlTree.setCheck(IdPefix + array1[i],1);					
//		}	
}

Tree.prototype.preLoadImages =function(){
	var imSrcAr = new Array("line1.gif","line2.gif","line3.gif","line4.gif","minus2.gif","minus3.gif","minus4.gif","plus2.gif","plus3.gif","plus4.gif","book.gif","books_open.gif","books_close.gif","magazines_open.gif","magazines_close.gif","tombs.gif","tombs_mag.gif","book_titel.gif","iconCheckAll.gif")
	var imAr = new Array(0);
		for(var i=0;i<imSrcAr.length;i++){
			imAr[imAr.length] = new Image();
			imAr[imAr.length-1].src = "image/tree/"+imSrcAr[i];
		}
}

Tree.prototype.getItemIdByIndex = function(index){
	var rootId = this.dhtmlTree.rootId;
	var i = this.dhtmlTree.getChildItemIdByIndex(rootId,index);
	return i;
}
	
	
Tree.prototype.getIdByPrefix = function(itemId,IdPrefix){
    if(itemId.indexOf(IdPrefix)>-1){
		var fixLen = IdPrefix.length;
		var end  = itemId.length;
		if(end>0){
			var id = itemId.substring(fixLen,end);
			return id;
		}else{
			return 0;
		}
    }else{
    	return 0;
    }


}	


Tree.prototype.refresh =function(rootId){
	var secondNodeId = this.getItemIdByIndex(treeName,0);
	this.dhtmlTree.setCheck(secondNodeId,0);
}	

Tree.prototype.loadDataByIdArray1 = function(ids){	
	for (var i = 0; i < ids.length; i++){
		alert(IdPrefix);
		this.dhtmlTree.setCheck(IdPrefix + ids[i],1);	
	}
}	

Tree.prototype.loadDataByIdArray2 = function(ids){
	for (var i = 0; i < ids.length; i++){
		this.loadDataByIdArray1(ids);			
	}
}	

Tree.prototype.getSelectedItemId = function(IdPrefix){
	var itemId = this.dhtmlTree.getSelectedItemId();
	var id = this.getIdByPrefix(itemId,IdPrefix);
    return id;
}	

Tree.prototype.setCurSelectItemId = function(IdPrefix){
	var id = this.getSelectedItemId(IdPrefix);
	this.curSelectItemId = id;
}	

Tree.prototype.getAllCheckedBranches = function(IdPrefix){
	var idStr=  this.dhtmlTree.getAllCheckedBranches();
	var type;
	
	if(idStr.substring(idStr.length-1,idStr.length) == ","){
		idStr = idStr.substring(0,idStr.length-1);
	}
	var ids = idStr.split(",");

	if (ids == ""){
		 return null;
	}else{
		return this.convertIdsByPrefix(ids,IdPrefix);
	}
}

Tree.prototype.getAllBranchesByPrefix = function(IdPrefix){
	
	var idStr=  this.dhtmlTree.getAllLeafs();
	var type;
	
	if(idStr.substring(idStr.length-1,idStr.length) == ","){
		idStr = idStr.substring(0,idStr.length-1);
	}
	var ids = idStr.split(",");

	if (ids == ""){
		 return null;
	}else{
		return this.convertIdsByPrefix(ids,IdPrefix);
	}
}


Tree.prototype.getAllCheckedBranchesText = function(){
	var values = new Array();
	
	var idStr =  this.dhtmlTree.getAllCheckedBranches();

	if(idStr.substring(idStr.length-1,idStr.length) == ","){
		idStr = idStr.substring(0,idStr.length-1);
	}
	var ids = idStr.split(",");
	
	for(var i = 0;i<ids.length;i++){
		values.push(this.dhtmlTree.getItemText(ids[i]));
	}

	return values;
}	
	

//root 下的第一个孩子
Tree.prototype.getSecondNodeId = function(){
	var rootId = this.dhtmlTree.rootId;
	var k = this.dhtmlTree.getChildItemIdByIndex(rootId,0);
	return k;
}	


Tree.prototype.convertIdsByPrefix = function(ids,IdPrefix){
//	alert("ids=="+ids);
	var id = new Array();
    var k = this.getSecondNodeId();

    var j = 0;
	for(var i =0;i<ids.length;i++){
		var source = ids[i];
		var fixLen = IdPrefix.length;
		var end  = source.length;
		
		var index = source.indexOf(IdPrefix);
		
//		alert("source==="+source);alert("fixLen\===="+fixLen);alert("end==="+end);
		if(k != source && index > -1 ){
			id[j++] = source.substring(index+fixLen,end);
//			id[j++] = source.substring(fixLen,end);
		}
//	alert("id=="+id)
	}
	return id;
}

Tree.prototype.removeNodeItem = function(ItemId){
	var parentId = this.dhtmlTree.getParentId(ItemId);
	this.dhtmlTree.deleteItem(ItemId);
	if(parentId != this.dhtmlTree.rootId){
	  this.dhtmlTree.selectItem(parentId,true);
	}
}	

Tree.prototype.removeNodeFromTree = function(id,IdPrefix){
	var itemId = IdPrefix + id;
	this.removeNodeItem(itemId);
}	


Tree.prototype.insertNewItem = function(parentId,newItemId,newItemLabel,img,imgopen,imgClose,rootId){
	this.dhtmlTree.insertNewItem(parentId,newItemId,newItemLabel,"",img,imgopen,imgClose,"SELECT,CALL",rootId);	
}	

Tree.prototype.getCurNodeType = function(){
	var selectedItemId = this.dhtmlTree.getSelectedItemId();
	var nodeType = org.tree.dhtmlTree.getUserData(selectedItemId,"type");
	return nodeType;
}	

Tree.prototype.disableRootEdit = function(){
	var selectedItemId = this.dhtmlTree.getSelectedItemId();
	var secondNodeId = this.getSecondNodeId();

	if(selectedItemId == secondNodeId){
		 this.dhtmlTree.enableItemEditor(false);
	}else{
		 this.dhtmlTree.enableItemEditor(true);
	}
}

Tree.prototype.getNodeTxtByRelIds = function(IdPrefix,ids){
	var arr = new Array();
   	for(var i = 0;i < ids.length; i++){
   		var itemId = IdPrefix + ids[i];
   		arr.push(this.dhtmlTree.getItemText(itemId));
   	}
   return arr;
}



