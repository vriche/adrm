
var aToolBar;

callOnLoad(init_toolBar);

function init_toolBar(){
	
	aToolBar=new dhtmlXToolbarObject(document.getElementById('toolbar_zone'),'100%',30,"¿ì½Ý·½Ê½");

	aToolBar.setOnClickHandler(onButtonClick);
	aToolBar.loadXML("toolbar.xml");
//	var str ="\<?xml version='1.0' encoding='iso-8859-1'?\>";
//	str =str +"<toolbar name=\"¿ì½Ý·½Ê½\" width=\"100%\" disableType=\"image\" absolutePosition=\"auto\" toolbarAlign=\"left\">";
//	
//	str =str +"<ImageButton src=\"iconSave.gif\" height=\"25\" width=\"25\" id=\"0_save\" tooltip=\"Save\"/>";
////	str =str +"<SelectButton id=\"0_select\" width=\"150px\" height=\"16px\"><option value=\"0\">Mode 0</option>";
////	str =str +"<option value=\"1\">Mode 1</option>";
////	str =str +"<option value=\"2\">Mode 2</option>";
////	str =str +"<option value=\"3\">Mode 3</option>";						
////	str =str +"</SelectButton>";
//	str =str +"<divider id=\"div_1\"/>";
//	str =str +"\</toolbar\>";
//	alert(str);
//	aToolBar.loadXMLString(str);
	aToolBar.showBar();

	
}

function onButtonClick(itemId,itemValue){
	alert("itemId = " + itemId);
	
	alert("itemValue = " + itemValue);
}


