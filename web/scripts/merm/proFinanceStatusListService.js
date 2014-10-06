var ctxPath;
var proCustomer = new ProCustomer();
var proExpenseProgram = new ProExpenseProgram();
var proOrder = new ProOrder();
var proProgramType = new ProProgramType();
var proCusId;
callOnLoad(init);


function init(){
		ctxPath = $F("ctxPath");
		programId= getParamFromUrl(document.location.href,"programId");
			getServiceDate();
	config_serviceDate = $("config_serviceDate").value;
        initGrid();
        initToolbar();
        getMoneyByProgramId();

}
 function getServiceDate(){
 	var fuc = function(d){
 		$("config_serviceDate").value = d;
 	}
 	DWREngine.setAsync(false);
 	DateUtil.getServiceDate(fuc);
 	DWREngine.setAsync(true);
 }
function initToolbar(){
	var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml" ;
	var aToolBar1=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo");
	aToolBar1.setOnClickHandler(onButtonClick);
	aToolBar1.loadXML(toolbarDataPath,callBack);
	function callBack(){
		aToolBar1.hideButtons(); 
        aToolBar1.showButtons("3_save");  
        aToolBar1.showButtons("div_3"); 
	}
	aToolBar1.showBar();  
}
function onButtonClick(itemId,itemValue){
              
		if(itemId=='3_save'&&programId!=0) saveExpenseMoney();
}

function getCellValue(rowId,col){ 
	return mygrid.cells(rowId,col).getValue();
}
function saveExpenseMoney(){
	var expenseId;
	var rowId=mygrid.getRowId(0);
	
	proExpenseProgram.obj.programId=programId;
	proExpenseProgram.obj.expenseId=1;
	proExpenseProgram.obj.expenseMoney=getCellValue(rowId,1);
	proExpenseProgram.obj.version=getDayPar(config_serviceDate,'y');
	
		var callBackFun=function(){
		alert("保存成功");
	}
	proExpenseProgram.saveProExpenseMoney(proExpenseProgram.obj,callBackFun);
	
}
function initGrid(){
		var imagePath = ctxPath + "image/grid/";
		mygrid = new dhtmlXGridObject('gridbox');
		mygrid.setImagePath(imagePath);
		mygrid.setHeader("节目名称,宣传支出,采购支出,销售收入,广告收入,收视率,盈利");
		mygrid.setInitWidthsP("16,14,14,14,14,14,14,14")
		mygrid.setColAlign("left,left,right,right,right,right,right")
		mygrid.setColTypes("ro,ed,ro,ro,ro,ro,ed[=c4+c3-c1-c2]");
		mygrid.setColSorting("str,int,int,int,int,int,int")
		mygrid.setMultiLine(false);
		//mygrid.setEditable(false);
		mygrid.init();
//		mygrid.loadXML("sampleData/payment_grid.xml");
		
		mygrid.setSkin("modern2");
		mygrid.enableAlterCss("even","uneven");
		//mygrid.setOnRowDblClickedHandler(rowDblClick);
}
function getMoneyByProgramId(){

		 var func = function(xml){
				mygrid.clearAll();
				mygrid.loadXMLString(xml);
				
		 }    			
		 if(programId!=0){
		         proOrder.getMoneyByProgramId(programId,func)
		 }
}
 