var orderDetailColl = new OrderDetailColl();
var mygrid;

callOnLoad(init);

function init(){

	tvNameParam =  _app_params.sysParam.tvNameParam;
	
	initGrid();
	getOrderDetailTable();
}

function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");
	
	var flds = "序,品牌,版本,磁带号,载体,时段,指定,长度,月份,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,总次数";
//	if(tvNameParam=='fztv') flds = "频道,时段,广告内容,版本,应付,指定,长度,月份,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,总次数";
	mygrid.setHeader(flds);  

	var columnIds = "ind,advName,tapCode,carrier,resource,memo,specific,length,month," 
					+"day1,day2,day3,day4,day5,"
					+"day6,day7,day8,day9,day10,"
					+"day11,day12,day13,day14,day15,"
					+"day16,day17,day18,day19,day20,"
					+"day21,day22,day23,day24,day25,"
					+"day26,day27,day28,day29,day30,"
					+"day31,monthTimes";
	mygrid.setColumnIds(columnIds);
//	if(tvNameParam=='fztv'){       
//		mygrid.setInitWidthsP("5,7,7,7,5,3,3,3,1.5,1.5,1.5,1.5,1.5,1.5,1.5,1.5,1.5,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,4");
//	}else{    
		mygrid.setInitWidthsP("2,4,6,4,4,7,3,3,3,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,4");
//	}
	
//    mygrid.setInitWidths("90,40,40,50,30,30,40,30,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,40");
	mygrid.setColAlign("center,left,center,left,left,left,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,right");
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
    
    mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	mygrid.setDragBehavior("nextSibling"); //nextSibling complex
	mygrid.enableDragAndDrop(false);
	mygrid.enableAutoSizeSaving();
	
    mygrid.setOnRowSelectHandler(doOnRowSelected);
    mygrid.setOnRowDblClickedHandler(doOnReturn);
    mygrid.setColSorting("str,str,str,str,int,str,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int") ;

	mygrid.init();
	
//	mygrid.splitAt(2);
	
//	mygrid.setSortImgState(true,0,"ASC"); 
}
function doOnReturn(id){
	mygrid.setRowTextStyle(id,'background-color:white;font-size:12px;');
	
}
function doOnRowSelected(id){
	
	//alert(id);
	mygrid.setRowTextStyle(id,'background-color:#FFCC99;font-size:13px;');
      }


function getOrderDetailTable(){
	
	var orgId =  getParamFromUrl(window.location.href,"orgId")+'';
	var orderId =  getParamFromUrl(window.location.href,"id")+'';
//	var orderId = getOrderIdURL();
	var func = function(xml){

		mygrid.loadXMLString(xml);
	}
	orderDetailColl.getOrderDetailXml(orgId,orderId,func);


}


function getOrderIdURL(){
	var url = window.location.href;
	var startPos = url.indexOf("=");
//	var endPos = url.lastIndexOf("&");
	var orderId = url.substring(startPos+1,url.length)*1;
	return  orderId;
}	

//function changeColor(rowIndex){
//	var trs = $(orderDetailColl.fillObjName).getElementsByTagName("tr");
//	var trnum = trs.length; 
//	var co = trs[rowIndex].style.cssText;
//     if(co =="background-color: rgb(3, 209, 9);"){
//	          if(rowIndex%2 == 0) { 
//	          		trs[rowIndex].style.cssText="BACKGROUND-COLOR: #f5f5f5";
//	          	}else{
//	          		trs[rowIndex].style.cssText="BACKGROUND-COLOR: #ECEFF4";
//	          	}
//	}else{
//	trs[rowIndex].style.cssText="BACKGROUND-COLOR: #03D109";
//}
//}