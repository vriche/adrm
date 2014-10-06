var scratchpad = new OaScratchpad();
//var popupcenter = new Popupcenter();

callOnLoad(init);	
  
function init(){
	setScratchPadPara(scratchpad);
	
	getOaScratchpad();
	
	buttonEventFill();
	
	
}
function buttonEventFill(){	
	var Btn_save = $("Btn_save");
	Btn_save.onclick = saveOaScratchpad;
	
	var Btn_dele = $("Btn_dele");
	Btn_dele.onclick = deleteOaScratchpad;	
	
	
}

function setScratchPadPara(obj){
	 obj.className  = "scratchpad";
	 obj.IdPrefix 	= obj.className + "Id";
}

function getOaScratchpadIdByUrl(){
	var url = window.location.href;
		
	var startPos = url.lastIndexOf("=");
	var endPos = url.length;
	var scratchpadId = url.substring(startPos+1,endPos)*1;
	return  scratchpadId;
}

function getOaScratchpad(){
	var id = getOaScratchpadIdByUrl();
		
	if(id == 0){
		return false;
	}else{
		
		var func = function(o){
			 $("content").value = o.content;
		} 
		
		scratchpad.getOaScratchpad(id,func);	
	}
}

function saveOaScratchpad(){
	var scratchpadId = getOaScratchpadIdByUrl();
		
	var mode;	
	
	if(scratchpadId == 0 ){
		mode = 'new';
	}else{
		mode = 'edit';
	}

	var func = function(){
		alert("±£´æ³É¹¦");
		window.close();
	}
	scratchpad.reset();
	scratchpad.obj.id = scratchpadId;
	scratchpad.obj.content = $("content").value;
	scratchpad.saveOaScratchpad(scratchpad.obj,mode,func);
}

function deleteOaScratchpad(){
	var scratchpadId = getOaScratchpadIdByUrl();
	
	var func = function(){
		window.close();
	}
	
	scratchpad.removeOaScratchpad(scratchpadId,func);
}



	