
	var viewDocumentSchem  = "";
	
//初始化      
    callOnLoad(init);

//定义对象
var documents = 
	{
	id:null,
	documentCatalogId:null,
	title:null, 
	documentCode:null,
	createBy:null, 					
	createDate:null,
	modifyBy:null,
	modifyDate:null,
	memo:null
};

var documentCatalog = 
	{
	id:null, 					
	name:null,
	parentId:null, 
	createBy:null, 					
	createDate:null,
	modifyBy:null,
	modifyDate:null
};

//清空对象
function reset(){
	documents.id = null;
	documents.documentCatalogId = null;
	documents.title = null;
	documents.documentCode = null;
	documents.createBy = null;
	documents.createDate = null;
	documents.modifyBy = null;
	documents.modifyDate = null;
	documents.memo = null;
}

function reset(){
	documentCatalog.id = null;
	documentCatalog.name = null;
	documentCatalog.parentId = null;
	documentCatalog.createBy = null;
	documentCatalog.createDate = null;
	documentCatalog.modifyBy = null;
	documentCatalog.modifyDate = null;
}



////////////////////////////////////////////////////
	

////动作填充 
//	function buttonEventFill(){
//		
//		//保存目录
//		var Btn_save_catalog = $("Btn_save_catalog");
//		Btn_save_catalog.onclick=button_saveDocument;
//		
//		//删除目录
//		var Btn_delete_catalog = $("Btn_delete_catalog");
//		Btn_delete_catalog.onclick=button_removeDocument;
//		
//		//取消
//		var Btn_view_catalog = $("Btn_view_catalog");
//		Btn_view_catalog.onclick=button_viewDocuments;
//	}  
	
	function init(){
		$("viewDocumentSchem").hide();
		$("oaDocumentForm").show();
   	    preLoadImages();
//   	    buttonEventFill();
   	    documentCatalog.parentId = 0;
   	    OaDocumentCatalogManager.getOaDocumentCatalogsXML(documentCatalog,getxml);
   	}
	
	function getDocuments(id){	
	    reset();
	    documents.documentCatalogId = id;
	    
		OaDocumentManager.getOaDocuments(fillTable,documents);

		var oa_document_table = $("oaDocumentList");
		var document_body = oa_document_table.getElementsByTagName("tbody")[0];
		document_body.setAttribute("id","documentBody");
	    documentBody = $("documentBody");

	}

	function getDocumentEdit(id){
		$("viewDocumentSchem").show();
//		$("oaDocumentForm").hide();
	    reset();
	    alert(1);
	    DWRUtil.setValues(documents);
	    alert(2);
		OaDocumentManager.getOaDocument(
			function(documents)
			{
				DWRUtil.setValue(documents);
			},
		id);
		alert(3);
	}
	
	
////保存目录
//   function button_saveDocument(){
//   		if(validateOaDocumentCatalogForm()){
//	   		DWRUtil.getValues(documentCatalog);
//	 		
//	   		documentCatalog.id = $("id").value;
//	   		OaDocumentCatalogManager.saveOaDocumentCatalog(documentCatalog,documentCatalogsaveFun);
//   		}	
//   }
//   
//   function documentCatalogsaveFun(newId){
//		if (newId) {
//			$("id").value = newId;
//			doUpdateItemDocumentCatalog(newId);
//		}
//   }
//   
////修改目录节点信息   
//   function doUpdateItemDocumentCatalog(id){
//   		var newId = 'dc'+ id;
//		tree.changeItemId(tree.getSelectedItemId(),newId);
//        tree.setUserData(newId,"id",id);
//		tree.setItemText(newId,$("title").value);
//		tree.setItemColor(newId,"black","white");
//   }
//   
////删除目录  
//	function button_removeDocument(){
//		if(tree.getSelectedItemId()!=newItemId){
//			if(!confirmDelete('DocumentCatalog')) return false;
//			var id =$("id").value;			
//			OaDocumentCatalogManager.removeOaDocumentCatalog(id);
//			doDeleteTreeItem('dc'+id);
//		}else{
//			doDeleteTreeItem(newItemId);
//		}	
//		DWRUtil.setValues(documentCatalog);	
//		
//		$("id").value = documentCatalog.id;	
//	}     
//   
//	function doDeleteTreeItem(id){
//		var pId = tree.getParentId(id);
//		tree.deleteItem(id);
//		if(pId!="root")
//			tree.selectItem(pId,true);
//			
//		DWRUtil.setValues(documentCatalog);	
//		$("id").value = 0;
//	}
   
////取消   
//	function button_viewDocuments(){
//		var docuCatalogId = tree.getSelectedItemId();
//		var id = tree.getUserData(docuCatalogId,"id");
//		getDocumentCatalogs(id);
//	}
//
//
////判断
//	function validateOaDocumentCatalogForm() {
//	    if ($("title").value =='') { 
//	    	alert('目录名为必填项')
//	        return false; 
//	    } else{
//	    	return true; 
//	    }
//	}   

    
////////////对表格的操作//////////////////  

function fillTable(documents){
	var color1 = "BACKGROUND-COLOR: #f5f5f5";
	var color2 = "BACKGROUND-COLOR: #ECEFF4";
	
	$("oaDocumentForm").show();
	$("viewDocumentSchem").hide();
	DWRUtil.removeAllRows("documentBody");
	DWRUtil.addRows("documentBody",documents,cellTable,
	{
	rowCreator:function(options) {  
			   var row = document.createElement("tr"); 
	           row.setAttribute("id","documentRow"+options.rowData.id);
	           row.setAttribute("title",options.rowData.title);
	           row.setAttribute("documentCode",options.rowData.documentCode);
	           row.setAttribute("memo",options.rowData.memo);
			   return row;  
		  },  
		  
		  cellCreator:function(options) {  
			    var td = document.createElement("td"); 
			    return td;  
		  }  
	});
	setColors(documentBody,color1,color2);
}
 
var cellTable=[
  	function(documents){
  		
  		return "<a href='javascript:void 0' id='"+ documents.id +"' onClick='getDocumentEdit(" + documents.id + ")'>" + documents.title + "</a>";
  		
  		},
	function(documents){return documents.documentCode;},
	function(documents){return documents.memo}
];

  
  
 
  
  
  
  
   