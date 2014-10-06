
 var winW;
 var winH;
 var orgId =1;
 callOnLoad(init);	
  
  function init(){
  	var srcStr = window.location.href;
	 publishDate = getParamFromUrl(srcStr,"publishDate"); 
	resourceId = getParamFromUrl(srcStr,"resourceId");
	workSpanId = getParamFromUrl(srcStr,"workSpanId");
	

	
	orgId = getParamFromUrl(srcStr,"orgId");
	winW = getParamFromUrl(srcStr,"winW");
	winH = getParamFromUrl(srcStr,"winH");
	if(winW == null) winW = 1200;
	if(winH == null) winH = 400;
	

	initGrid();
		resetHeigth();
	getAdversByResourceIdAndPublishDate();
  }
  
  function resetHeigth(){
  	     winH = parent.winAdver.getInnerHeight()-13;
         winW = parent.winAdver.getInnerWidth()-10;
         var gridbox = $("gridbox");
         
         gridbox.style.width = winW +"px";	
         gridbox.style.height = winH+"px";  	         
         
//         gridbox.style.width = winW*0.9 +"px";	
//         gridbox.style.height = winH*0.82 +"px";
  } 
function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath( getCtxPath()+"image/grid/");
	flds = "序,广告名称,版本,长度(秒),业务员,客户名称,订单编号,审核状态"; 
	mygrid.setInitWidthsP("5,15,15,10,10,20,15,10");
	mygrid.setHeader(flds);
	
	var columnIds = "publishSort,matterName,matterEdit,matterLength,ownerUserName,customerName,orderCode,checkState";
	mygrid.setColumnIds(columnIds);

	mygrid.setColAlign("center,left,left,center,center,left,center,center");
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,link,ed"); 

	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	mygrid.setDragBehavior("nextSibling"); //nextSibling complex

	mygrid.enableAlterCss("even","uneven");   
//	mygrid.setSkin("modern");  
	mygrid.init();  
}
function getAdversByResourceIdAndPublishDate(){
	
	var func  = function(xml){
		mygrid.clearAll();
		mygrid.loadXMLString(xml);
	}
	            

   if(workSpanId > 0){
   		OrderDayInfoManager.getAdversByWorkSpanId(workSpanId,publishDate,orgId,func);	
   }else{
   		if(resourceId >0) PublishArrangeManager.getAdversByResourceId(resourceId,publishDate,orgId,func);	
   }
}




