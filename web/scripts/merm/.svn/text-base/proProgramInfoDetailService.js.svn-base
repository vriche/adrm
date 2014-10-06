var proProgramType = new ProProgramType();
var proProgram = new ProProgram();
var proProgramDetail = new ProProgramDetail();
var ctxPath;
callOnLoad(init);


function init(){
	programId=getParamFromUrl(document.location.href,"programId");
	getServiceDate();
	config_serviceDate = $("config_serviceDate").value;

	ctxPath = $F("ctxPath");
	initToolbar();
    	getDate();
	buttonEventFill();
	if(programId!=null){
		getAllValueById();
	}

}


function buttonEventFill(){
	var btn_content = $("content");
	btn_content.onclick=displayContentDiv;
	
	var btn_opinion = $("opinion");
	btn_opinion.onclick=displayOpinionDiv;
	
	var btn_textareaContent = $("textareaContent");
	btn_textareaContent.onblur=closeContentDiv;
	btn_textareaContent.onkeypress = displayContent;
	
	var btn_textareaOpinion = $("textareaOpinion");
	btn_textareaOpinion.onblur=closeOpinionDiv;
	btn_textareaOpinion.onkeypress = displayOpinion;
	
}
function displayContentDiv(ev){
	var oDiv = $("theDivContent");	
	oDiv.style.visibility = "visible";
	oDiv.style.width = $("content").offsetWidth*2.6 +"px";
	$("textareaContent").style.width = oDiv.style.width;
	oDiv.style.heigth = $("textareaContent").style.height +"px";
	
	$("textareaContent").focus();	

	$("textareaContent").value = $("content").value;
}
function displayOpinionDiv(ev){
	var oDiv = $("theDivOpinion");	
	oDiv.style.visibility = "visible";
	oDiv.style.width = $("opinion").offsetWidth*2.6 +"px";
	$("textareaOpinion").style.width = oDiv.style.width;
	oDiv.style.heigth = $("textareaOpinion").style.height +"px";
	
	$("textareaOpinion").focus();	
	$("textareaOpinion").value = $("opinion").value;
}

function closeContentDiv(ev){
	var oDiv = $("theDivContent");	
	oDiv.style.visibility = "hidden";
	$("content").value = 	$("textareaContent").value;
}
function closeOpinionDiv(ev){
	var oDiv = $("theDivOpinion");	
	oDiv.style.visibility = "hidden";
	$("opinion").value = 	$("textareaOpinion").value;
}

function displayContent(ev){
	if(ev.keyCode == 13){
		$("content").value = $("textareaContent").value;
	}
}
function displayOpinion(ev){
	if(ev.keyCode == 13){
		$("opinion").value = $("textareaOpinion").value;
	}
} 
 function getServiceDate(){
 	var fuc = function(d){
 		$("config_serviceDate").value = d;
 	}
 	DWREngine.setAsync(false);
 	DateUtil.getServiceDate(fuc);
 	DWREngine.setAsync(true);
 }

function getDate(){
	
	Calendar.setup({
		inputField  : "inputDate",	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "inputDate"	// id of the button
	});
	Calendar.setup({
		inputField  : "firstDate",	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "firstDate"	// id of the button
	});
	
	$("inputDate").value = getFormatDay(config_serviceDate,'y/m/d');
	$("firstDate").value = getFormatDay(config_serviceDate,'y/m/d');
}

function getAllValueById()
	{        proProgramDetail.obj.programId=programId;
		 function getFun(objs){
		 		$("inputDate").value = objs.inputDate==null?"":getFormatDay(objs.inputDate,'y/m/d');
		 		$("firstDate").value = objs.firstDate==null?"":getFormatDay(objs.firstDate,'y/m/d');
		 		$("director").value = objs.director;
		 		$("actor").value = objs.actor;
		 		$("content").value = objs.content;
		 		$("opinion").value = objs.opinion;
		 		$("incomeMoney").value = objs.incomeMoney==null?"":objs.incomeMoney;
		 		$("rate").value = objs.rate==null?"":objs.rate;
                $("commendLevel").value = objs.commendLevel;
   				    }
   				     	proProgramDetail.getProgramDetail(proProgramDetail.obj,getFun);
                     	
	}

function initToolbar(){
	       	   		var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml"
		var aToolBar=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo"); 
		aToolBar.setOnClickHandler(onButtonClick);

		aToolBar.loadXML(toolbarDataPath,callBack);
		 
		function callBack(){
			aToolBar.hideButtons(); 

				aToolBar.showButtons("2_delete,3_save");  
	               		 aToolBar.showButtons("div_2,div_3");          
		}
		
		
		 aToolBar.showBar();  
}

function onButtonClick(itemId,itemValue)
	{              
		if(itemId=='2_delete') deletePrProgramDetail();
		if(itemId=='3_save') saveProgramDetail();
	}

function deletePrProgramDetail()
{  
	   if(programId!=null&&programId!=""){
	   var ans = confirm("请确认是否删除这条记录？");
	   if (ans)  proProgramDetail.removeProgramDetail(programId,callBackFun);
	   }
	  function callBackFun(){
	   	window.location.href=ctxPath+"merm/proProgramInfoList.jsp?programId="+getParamFromUrl(document.location.href,"programId"); 
	   }
	
}

function saveProgramDetail()
	{  
	proProgramDetail.reset();
	
	proProgramDetail.programId = getParamFromUrl(document.referrer,"programId");
	proProgramDetail.inputDate = getFormatDay($("inputDate").value,'ymd');
	proProgramDetail.firstDate = getFormatDay($("firstDate").value,'ymd');
	proProgramDetail.director = $("director").value;

    proProgramDetail.actor = $("actor").value;
    proProgramDetail.content = $("content").value;
    proProgramDetail.opinion = $("opinion").value;

	proProgramDetail.incomeMoney = $("incomeMoney").value;
	proProgramDetail.rate = $("rate").value;
	proProgramDetail.commendLevel = $("commendLevel").value;
	proProgramDetail.version=getFormatDay(config_serviceDate,'y');

	        proProgramDetail.saveProProgramDetail(proProgramDetail,setFun);

		function setFun(id){
					alert("保存成功");				
					window.location.href=ctxPath+"merm/proProgramInfoList.jsp?programId="+getParamFromUrl(document.referrer,"programId"); 

		}

	 
}