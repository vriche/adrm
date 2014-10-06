var editMode;
var ctxPath;
var feedbackInfo = new FeedbackInfo();
callOnLoad(init);


function init(){
	ctxPath = getCtxPath();	
	var cusId = getParamFromUrl(document.location.href,"cusId");
	 cusId = cusId ==null||cusId ==""?0:cusId;
	
    initGrid();
    
    getContractPaymentByCustomerId(cusId);

}

	
function initGrid(){
	var imagePath = ctxPath + "image/grid/";
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath(imagePath);
//问题提交日期   	信息反馈人   	反馈内容   	问题处理日期  	满意度
	var flds = "问题提交日期,信息反馈人,反馈内容,问题处理日期,满意度";
	mygrid.setHeader(flds);

	mygrid.setInitWidthsP("19,20,20,20,20");
	mygrid.setColAlign("left,left,left,left,left");
	mygrid.setColTypes("ed,ed,ed,ed,ed");
	mygrid.enableAlterCss("even","uneven"); 
	mygrid.setColSorting("str,str,str,str,str") ;
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	//mygrid.enableDragAndDrop(false);
	mygrid.setSkin("modern2");
	mygrid.init();	 
	mygrid.setSortImgState(true,0,"ASC"); 
	
	 resetHeigth();
	
}


function resetHeigth(){

    var dialogcontent = parent.document.getElementById("details");
    
    var gridbox = $("gridbox");
 
    gridbox.style.height = dialogcontent.offsetHeight * 0.85 +"px";	
   
} 

function getContractPaymentByCustomerId(cusId){
	
	var func = function(xml){
		mygrid.clearAll();
		mygrid.loadXMLString(xml);
	}
	
	
	feedbackInfo.reset();
	feedbackInfo.obj.customerId = cusId*1;
	feedbackInfo.getFeedbackInfosListXML(feedbackInfo.obj,func);	

	
}
