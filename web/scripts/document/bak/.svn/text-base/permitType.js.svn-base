

var permitType =
{
	id:null,
	name:null,
	value:null,
	createBy:null,
	createDate:null,
	modifyBy:null,
	modifyDate:null,
	version:null
};

function resetPermitType()
{
	permitType.id = null;
	permitType.name = null;
	permitType.value = null;
	permitType.createBy = null;
	permitType.createDate = null;
	permitType.modifyBy = null;
	permitType.modifyDate = null;
	permitType.version = null;
}

function getPermitType(){

		OaDocumentCatalogPermitTypeManager.getOaDocumentCatalogPermitTypes(fillPermitType,permitType);
}

function fillPermitType(permitTypes){
	
//	alert(permitTypes.length);
	
	for (var i = 0;i<permitTypes.length;i++){
		
		
		
		var userPermitType = $("userPermitType");
		var checkboxPermitType = document.createElement("input");
		checkboxPermitType.setAttribute("id","checkboxPermitType");
		checkboxPermitType.setAttribute("name","checkboxPermitType");
		checkboxPermitType.setAttribute("type","checkbox");
		checkboxPermitType.setAttribute("value",permitTypes[i].id);
		userPermitType.appendChild(checkboxPermitType);
		
		var checkboxPermitTypeText = document.createElement("input");
		checkboxPermitTypeText.setAttribute("type","text");
		checkboxPermitTypeText.style.cssText = "width:30px;aling:center;border:none;background-color:buttonface;text-align:left;cursor:hand;";
		checkboxPermitTypeText.setAttribute("value",permitTypes[i].name);
		userPermitType.appendChild(checkboxPermitTypeText);
		
	}
}

function getPermitTypeIdArray(){
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

function getPermitTypeId(permitType,ids){
	refreshCheckBox();
	var checkboxs = document.getElementsByName("checkboxPermitType");
	var checkboxsA = $A(checkboxs);
	if(ids != '' || ids != null){
		for (var i = 0; i < ids.length; i++){
			for (var j = 0; j < ids[i].length; j++){
				checkboxsA.each(function(chb){
					if(chb.value == ids[i][j]){
						chb.checked=true;
					}
				});
			}
		}
	}
}	
	






