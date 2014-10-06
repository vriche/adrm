//定义对象
var documentCatalog = 
	{
	id:null, 					
	name:null,
	//permitTypeId:null,
	parentId:null, 
	createBy:null, 					
	createDate:null,
	modifyBy:null,
	permitTypes:[],
	permitUsers:[],
	modifyDate:null
};


//清空对象
function reset(){
	documentCatalog.id = null;
	documentCatalog.name = null;
	//documentCatalog.permitTypeId = null;
	documentCatalog.parentId = null;
	documentCatalog.createBy = null;
	documentCatalog.createDate = null;
	documentCatalog.modifyBy = null;
	documentCatalog.permitUsers = [];
	documentCatalog.permitTypes = [];
	documentCatalog.modifyDate = null;
}

////////////////////////////////////////////////////

//初始化      
    callOnLoad(init);	

//动作填充 
	function buttonEventFill(){
		//增加目录子级
		var Btn_addCatalogChild = $("Btn_addCatalogChild");
		Btn_addCatalogChild.setAttribute("href","javascript:void 0");
		Btn_addCatalogChild.onclick=btn_addCatalogChild;
		
		//保存目录
		var Btn_save_catalog = $("Btn_save_catalog");
		Btn_save_catalog.onclick=button_saveDocument;
		
		//删除目录
		var Btn_delete_catalog = $("Btn_delete_catalog");
		Btn_delete_catalog.onclick=button_removeDocument;
		
		//取消
		var Btn_view_catalog = $("Btn_view_catalog");
		Btn_view_catalog.onclick=button_viewDocuments;		
					
	}  
	
	function init(){
//   	    preLoadImages();
   	    buttonEventFill();
   	    documentCatalog.parentId = 0;
   	    OaDocumentCatalogManager.getOaDocumentCatalogsXML(documentCatalog,getxml);
//		UserManager.getUsersXML(user,IdPrefix,getUserXML);
		getPermitType();
   }
   
	
	function getDocumentCatalogs(id){
	    reset();
	    DWRUtil.setValues(documentCatalog);
		OaDocumentCatalogManager.getOaDocumentCatalog(
			function(documentCatalog){
				DWRUtil.setValues(documentCatalog);
				
				if(documentCatalog.permitUsers == '' || documentCatalog.permitUsers == null){
					 idsUserPermit =[];
				}
				
				loadDataTree(treeUserPermit,documentCatalog.permitUsers);
				getPermitTypeId(permitType,documentCatalog.permitTypes);
			},
		id);	
	}
  
  
  		
	
	function convertIdByPrefix(ids,IdPrefix){

	var id = [];
	for(var i =0;i<ids.length;i++){
		var source = ids[i];
		var fixLen = IdPrefix.length;
		var end  = source.length;
		id[i] = source.substring(fixLen,end);
	}
	
	return id;
}
	
   
   
//保存目录
   function button_saveDocument(){
   		if(validateOaDocumentCatalogForm()){
	   		DWRUtil.getValues(documentCatalog);
	   		
//	 		var idsUserPermit = treeUserPermit.getAllChecked().split(",");
	 		var idsUserPermit = convertIdByPrefix(treeUserPermit.getAllChecked().split(","),IdPrefix);
	 		
//	 		if(idsUserPermit == '') idsUserPermit =[];
	 		documentCatalog.permitUsers = idsUserPermit;
	 		
	 		documentCatalog.permitTypes = getPermitTypeIdArray();
	 		
	   		documentCatalog.id = $("id").value;
	   		OaDocumentCatalogManager.saveOaDocumentCatalog(documentCatalog,documentCatalogsaveFun);
   		}	
   }
   
   function documentCatalogsaveFun(newId){
   	    
		if (newId) {
			$("id").value = newId;
			doUpdateItemDocumentCatalog(newId);
		}
   }
  
//修改目录节点信息   
   function doUpdateItemDocumentCatalog(id){
   		var newId = 'dc'+ id;
		tree.changeItemId(tree.getSelectedItemId(),newId);
        tree.setUserData(newId,"id",id);
//        tree.setUserData(newId,"permitTypeId",$("permitTypeId").value);
		tree.setItemText(newId,$("name").value);
		tree.setItemColor(newId,"black","white");
   }
   
//增加目录子级
   function btn_addCatalogChild(){
   		refreshTree(treeUserPermit);
		if(tree.getLevel(newItemId)!=0){//check if unsaved item already exists
			alert("New Item (unsaved) already exists");
			return false;
		} 
	
		var selectedId = tree.getSelectedItemId();

		if(selectedId != ""){
	    	DWRUtil.setValues(documentCatalog);
	    	$("id").value = 0;
	    	
			var parentId = tree.getUserData(selectedId,"id");
	    	
			$("parentId").value = parentId;
			$("name").value = newItemLabel;
//			$("permitTypeId").value = tree.getUserData(selectedId,"permitTypeId");
	   		tree.insertNewItem(selectedId,newItemId,newItemLabel,"","book.gif","books_open.gif","books_close.gif","SELECT,CALL",0);
		}else{
			alert("请选择被增加的节点");
		}	
   }	
   
//删除目录  
	function button_removeDocument(){
		if(tree.getSelectedItemId()!=newItemId){
			if(!confirmDelete('DocumentCatalog')) return false;
			
			var id =$("id").value;	
					
			OaDocumentCatalogManager.removeOaDocumentCatalog(id);
			doDeleteTreeItem('dc'+id);
		}else{
			doDeleteTreeItem(newItemId);
		}	
		DWRUtil.setValues(documentCatalog);	
		
		$("id").value = documentCatalog.id;	
	}     
   
	function doDeleteTreeItem(id){
		
		var pId = tree.getParentId(id);
		tree.deleteItem(id);
		if(pId!="root")
			tree.selectItem(pId,true);
			
		DWRUtil.setValues(documentCatalog);	
		$("id").value = 0;
	}
   
//取消   
	function button_viewDocuments(){

		var docuCatalogId = tree.getSelectedItemId();
		var id = tree.getUserData(docuCatalogId,"id");
		getDocumentCatalogs(id);
	}

//刷新树	
	function refreshTree(treeName){
				// -1 是root 节点 id
				var secondNodeId = getItemIdByIndex(treeName,0);
				treeName.setCheck(secondNodeId,0);
	}	
	  
	function getItemIdByIndex(treeName,index){
	            var rootId = treeName.rootId;
	            var i = treeName.getChildItemIdByIndex(rootId,0);
				return i;
	}	  


//判断
	function validateOaDocumentCatalogForm() {
	    if ($("name").value =='') { 
	    	alert('目录名为必填项')
	        return false; 
	    } else{
	    	return true; 
	    }
	}   
  
  
  
   