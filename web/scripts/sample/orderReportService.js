
var mygrid;

callOnLoad(init);	
  
function init(){
	
	initGrid();
    
}


function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("../image/grid/");
	var flds = "�������,���汾,ʱ��,ָ������,����,�·�,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,�������,ָ��������,�Ż��ۿ���,����,�Żݺ���";
	mygrid.setHeader(flds);
	mygrid.setInitWidths("100,60,50,60,30,30,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,60,70,80,40,80");
    mygrid.enableLightMouseNavigation(true);
	mygrid.setColAlign("left,left,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center");
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
    mygrid.setColTypes("ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro,ro");
    mygrid.setMultiLine(false);
//	mygrid.setOnGridReconstructedHandler(setRow_style);
	mygrid.setDragBehavior("complex");
	
	mygrid.enableDragAndDrop(true);

	mygrid.init();	
}
