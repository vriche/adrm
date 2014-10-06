 var orderLog = new OrderLog();
 var mygrid;
 var mygrid2;
 var winW;
 var winH;
 callOnLoad(init);	
  
  function init(){
  	initGrid();
  	initGrid2();
  	var srcStr = window.location.href;
	var orderDetailId = getParamFromUrl(srcStr,"orderDetailId");
	winW = getParamFromUrl(srcStr,"winW");
	winH = getParamFromUrl(srcStr,"winH");
	if(winW == null) winW = 600;
	if(winH == null) winH = 400;
	
	resetHeigth();
	
  	getOrderLogs(orderDetailId);
  }
  
  
  function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");
	
	var flds = "次,操作员,操作时间,访问ip";
	mygrid.setHeader(flds);
	var columnIds = "seq,person,data,ip";
	mygrid.setColumnIds(columnIds);
	
    mygrid.setInitWidthsP("10,20,46,24");
	mygrid.setColAlign("center,center,center,center");
	mygrid.setColTypes("ed,ed,ed,ed");
    
    mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	mygrid.enableDragAndDrop(false);

    mygrid.setOnRowSelectHandler(onRowSelectd,true);
    mygrid.setSkin("modern2");
    mygrid.enableAlterCss("even","uneven");
	mygrid.init();	 
}

  function initGrid2(){
	mygrid2 = new dhtmlXGridObject('gridbox2');
	mygrid2.selMultiRows = true;
	mygrid2.setImagePath("image/grid/");
	
	var flds = "属性,修改前,修改后";
	mygrid2.setHeader(flds);
	var columnIds = "seq,person,data";
	mygrid2.setColumnIds(columnIds);
	
	mygrid2.setInitWidthsP("30,35,35");
	mygrid2.setColAlign("left,left,left");
	mygrid2.setColTypes("ed,ed,ed");
    
    mygrid2.setMultiLine(false);
	mygrid2.setEditable(false);
	mygrid2.enableDragAndDrop(false);
    mygrid2.setSkin("modern2");
    mygrid2.enableAlterCss("even","uneven"); 
	mygrid2.init();	 
}

  function resetHeigth(){
         var gridbox = $("gridbox");
         var gridbox2 = $("gridbox2");
         
         gridbox.style.width = winW*0.45 +"px";	
         gridbox.style.height = winH*0.82 +"px";
         
         gridbox2.style.width = winW*0.5 +"px";	
         gridbox2.style.height = gridbox.style.height;
  } 

 function getOrderLogs(orderDetailId){
  	orderLog.reset();
  	orderLog.obj.orderDetailId = orderDetailId;
  		
	var fnc = function(xml){
		if(xml != null){
			mygrid.loadXMLString(xml,function(){});	
		}else{
		  	mygrid.clearAll();
		}
	}
  	orderLog.getOrderLogXML(orderLog.obj,fnc);
 }

function onRowSelectd(rowId,colIndex){
	var fnc = function(obj){
		var s = obj.changeContent;
		var xml = getXml(s);
		
		mygrid2.clearAll();
		if(xml != null){
			mygrid2.loadXMLString(xml,function(){});	
		}
	}
  	orderLog.getOrderLog(rowId,fnc);
}

function getXml(s){
	var arr = s.split("\n\r");
	var xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	xml += "<rows>";
	for(var i = 0;i < (arr.length - 1);i++){
		var objs = arr[i].split(",");
		xml += "<row  id=\""+ i  +"\">";
		for(var j = 0;j<objs.length;j++){
			var colValue  = (j == 0)? "【"+ objs[j] +"】":objs[j];
			xml += "<cell><![CDATA["+ colValue  +"]]></cell>";
		}
		xml += "</row>";
	}
	xml += "</rows>";
	return xml;
}