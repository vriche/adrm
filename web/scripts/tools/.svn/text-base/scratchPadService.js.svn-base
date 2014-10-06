
var scratchpad = new OaScratchpad();
var popupcenter = new Popupcenter();

callOnLoad(init);	
  
function init(){
	
	setScratchPadPara(scratchpad);
	
	buttonEventFill();
	
	getOaScratchpads();
}
function buttonEventFill(){

	var Btn_add = $("Btn_add");
	Btn_add.onclick = add;
	
	document.body.onfocus = closePopup;	
	
}

function setScratchPadPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 
	 obj.className = "scratchpad";
	 obj.IdPrefix 	= obj.className + "Id";
	 
	 obj.fillObjName = obj.className + "Body";
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.tBody 		= $(obj.fillObjName);
	 
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "0";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}

function add(){
	var scratchPad = (new OaScratchpad()).obj;
	scratchPad.id = 0;
	autoBroArrange(scratchPad);
}

function editOaScratchpad(id){
	var scratchPad = (new OaScratchpad()).obj;
	scratchPad.id = id;
	autoBroArrange(scratchPad);
}
function autoBroArrange(o){
	popupcenter.url = "selectPopup/displayScratchPad.html?id=" + o.id;
	popupcenter.model = 6;
	popupcenter.popupcenter(popupcenter);
}
function closePopup(ev){
	popupcenter.closePopup(popupcenter);
}

function getOaScratchpads(){
	
	var func = function(objs){
		
//		alert("len= " + objs.length);
		
		var str = scratchpad.fillTableSC(objs);
		
//		alert("str= " + str);
		
		$(scratchpad.pageHTML).innerHTML = str;
	}
	
	scratchpad.getOaScratchpads(scratchpad,func);
}

function getContent(objs){
	var o;
	var content = "&nbsp";
	for(var i=0;i<objs.length;i++){
		o = objs[i];
		content = o.content;
	}
	
	return content;
}




