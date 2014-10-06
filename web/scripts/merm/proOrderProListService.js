var proOrder = new ProOrder();
var proCustomer = new ProCustomer();
var proProgram = new ProProgram();
var ctxPath;
var programId;

callOnLoad(init);



function init(){
	ctxPath = $F("ctxPath");
	programId = getParamFromUrl(document.location.href,"programId");
        initGrid();
        getProOrderByprogramId();
}




function initGrid(){
	var imagePath = ctxPath + "image/grid/";
		mygrid = new dhtmlXGridObject('gridbox');
		mygrid.setImagePath(imagePath);
		mygrid.setHeader("�������,��������,�ͻ�����,Ӧ�����,������,ҵ��Ա,ǩ������,Ӧ������,��������");
		mygrid.setInitWidthsP("15,10,15,10,10,10,10,10,10")
		mygrid.setColAlign("left,left,left,right,right,left,right,right,right")
		mygrid.setColTypes("ro,ro,ro,ro,ro,ro,ro,ro,ro");
		mygrid.setColSorting("str,str,str,int,int,str,date,date,date")
		mygrid.enableMultiselect(true)
		mygrid.init();
		//mygrid.loadXML("sampleData/order_grid.xml");
		
		mygrid.setSkin("modern2");
		mygrid.enableAlterCss("even","uneven");
}
function getProOrderByprogramId(){
     proOrder.obj.programId=programId;
	 function getFun(xml){
    	    	mygrid.clearAll();
	        mygrid.loadXMLString(xml);
    }	
            proOrder.getProOrderXMLByProgramId(proOrder.obj,getFun);
}

