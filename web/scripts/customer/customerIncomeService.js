var editMode;
var ctxPath;
var income = new Income();
callOnLoad(init);


function init(){
	ctxPath = getCtxPath();
	$("CusId").value = getParamFromUrl(document.location.href,"cusId");
    initGrid();
    
    getIncomeByCustomerId();

}

	
function initGrid(){
	var imagePath = ctxPath + "image/grid/";
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath(imagePath);
//到款日期   	收入编号   	到款金额   	到款类型  	到款用途  	备注
	var flds = "到款日期,收入编号,到款金额,到款类型,到款用途,备注";
	mygrid.setHeader(flds);

	mygrid.setInitWidthsP("16,17,17,17,17,15");
	mygrid.setColAlign("left,left,left,left,left,left");
	mygrid.setColTypes("ed,link,ed,ed,ed,ed");
	mygrid.enableAlterCss("even","uneven"); 
	mygrid.setColSorting("str,str,str,str,str,str") ;
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	//mygrid.enableDragAndDrop(false);
	mygrid.setSkin("modern2");
	mygrid.init();	 
	mygrid.setSortImgState(true,0,"ASC"); 
	
}

function getIncomeByCustomerId(){
	var cusId = $("CusId").value ==null||$("CusId").value ==""?0:$("CusId").value;
	var func = function(xml){
		mygrid.clearAll();
		mygrid.loadXMLString(xml);
	}
	
		income.reset();
		income.obj.customerId = cusId;
		income.getIncomesListXML(income.obj,func);	
	
}
