var proOrder = new ProOrder();
var proCustomer = new ProCustomer();
var proProgram = new ProProgram();
var proProgramDetail=new ProProgramDetail();
var ctxPath;
var programId;

callOnLoad(init);



function init(){
	ctxPath = $F("ctxPath");
	programId = getParamFromUrl(document.location.href,"programId");
        initGrid();

        getProProgramDetail();
}

function initGrid(){
	var imagePath = ctxPath + "image/grid/";
		mygrid = new dhtmlXGridObject('gridbox');
		mygrid.setImagePath(imagePath);
		mygrid.setHeader("输入日期,首映日期,导演,主演,内容简介,评价,票房,平均收视率,推荐指数");
		mygrid.setInitWidthsP("10,10,10,15,10,10,10,15,10")
		mygrid.setColAlign("left,left,left,left,left,left,left,left,left")
		mygrid.setColTypes("ro,ro,ro,ro,ro,ro,ro,ro,ro");
		mygrid.setColSorting("date,date,str,str,str,str,int,int,str")
		mygrid.enableMultiselect(true)
		mygrid.init();
		
		mygrid.setSkin("modern2");
		mygrid.enableAlterCss("even","uneven");
		mygrid.setOnRowSelectHandler(onRowSelectd,true)
}
function onRowSelectd(){
	window.location.href=ctxPath+"merm/proProgramInfoDetail.jsp?programId="+programId;
}
function initToolbar(){
	var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml" ;
	var aToolBar=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo"); 
	aToolBar.setOnClickHandler(onButtonClick);
	aToolBar.loadXML(toolbarDataPath,callBack);
	 
	function callBack(){
		aToolBar.hideButtons(); 
        aToolBar.showButtons("1_new");   
	}
	aToolBar.showBar();  
}
function onButtonClick(itemId,itemValue)
	{
		if(itemId=='1_new') window.location.href=ctxPath+"merm/proProgramInfoDetail.jsp";
	}


function getProProgramDetail(){
     proProgramDetail.obj.programId=programId;
	 function getFun(xml){
    	    	mygrid.clearAll();
	        mygrid.loadXMLString(xml);
	        if(mygrid.getRowsNum()==0)
	                initToolbar();
    }	
            proProgramDetail.getProgramDetailXML(proProgramDetail.obj,getFun);
}

