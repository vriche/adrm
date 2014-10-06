function OaDocumentCatalogPermitType(){
	//创建对象
	this.obj ={
		id:null,
		name:null,
	    value:null,
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
	
	this.enableEdit = false;
	this.enableDel = false;
	
	return this;
}

//清空对象
OaDocumentCatalogPermitType.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.value = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
}

OaDocumentCatalogPermitType.prototype.getOaDocumentCatalogPermitTypes = function(oaDocumentCatalogPermitType){
	var OBJ = this;
	var obj = this.obj;
	
	OaDocumentCatalogPermitTypeManager.getOaDocumentCatalogPermitTypes(fillPermitType,oaDocumentCatalogPermitType);
	
	function fillPermitType(oadocumentcatalogpermittypes){
		
		for (var i = 0;i<oadocumentcatalogpermittypes.length;i++){
			
			var userPermitType = $("userPermitType");
			
			var checkboxPermitType = document.createElement("input");
			checkboxPermitType.setAttribute("id","checkboxPermitType");
			checkboxPermitType.setAttribute("name","checkboxPermitType");
			checkboxPermitType.setAttribute("type","checkbox");
			checkboxPermitType.setAttribute("value",oadocumentcatalogpermittypes[i].id);
			userPermitType.appendChild(checkboxPermitType);
			
			var checkboxPermitTypeText = document.createElement("input");
			checkboxPermitTypeText.setAttribute("type","text");
			checkboxPermitTypeText.style.cssText = "width:30px;aling:center;border:none;background-color:buttonface;text-align:left;cursor:hand;";
			checkboxPermitTypeText.setAttribute("value",oadocumentcatalogpermittypes[i].name);
			userPermitType.appendChild(checkboxPermitTypeText);
			
		}
	}
}

OaDocumentCatalogPermitType.prototype.getPermitTypeIdArray = function(){	
	var checkboxs = document.getElementsByName("checkboxPermitType");
	var checkboxsA = $A(checkboxs);
 	var i = [];
 	var j = 0;
	checkboxsA.each(function(chb){
		if(chb.checked == false){
		}else{
			i[j++] = chb.value;
		}
	});
	return i;	
}	

	

