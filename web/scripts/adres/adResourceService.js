var carrierType = new CarrierType();
var carrier =new  Carrier();
var resource = new Resource();
var customerProduct = new CustomerProduct();
var customer = new Customer();
var myDate = new MyDate();
var config_serviceDate;
var tvNameParam;
var myprint =new MyPrint();
var winAdver;

var shiduanWin;

var mygrid;
var mygrid1;

callOnLoad(init);	

function init(){
//	$("btn_display").hide();
//	$("btn_hidden").show();

	ctxPath =  _app_params.ctxPath;	
	get_cur_year();
	channelModelParam = _app_params.sysParam.channelModelParam;
	tvNameParam =  _app_params.sysParam.tvNameParam;
	userName =  _app_params.user.username;
	
	_make_adrm_sys_year_select("resource_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);

	_make_org_select("orgId",100,"resetStore");	
	
	    config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;
    if(config_oneOrgMoreSuborgsParam == '1'){$('orgId').hide();}
	
//	setCarrierTypePara(carrierType);
	setCarrierPara(carrier);
	setResourcePara(resource);
	setCustomerProductPara(customerProduct);
	setCustomerPara(customer);
//	customer.getCustomerAutoComplet(payCustomerAutoComplet,customer.obj);
	//getCarrierTypeTree(carrierType); 
//	initResourceTree();
	getDate();
	
	buttonEventFill();
	initGrid();
	
	initGrid1();
//	changeButton(false);

    resetHeigth();
     function callFunction(){} 
     
    resource.obj.version = $("resource_year").value;
    orgId = config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;
    
   
    
    resourceCommandTree = resource.getResourceCmdTree(orgId,resource.obj,'search_resource_cmd','search_resource_tree',true,'resource_tree_id','resourceId','选时段...',80,true,false,true,callFunction);
//    resourceCommandTree.fieldLabel = '广告位置';
 

    this.myprint.buildButtons2(this,"printReportDiv",[0,1,2,8],60);
    
  	var cmd = customer.getCustomerRemote("theDivCustomerName","customer_name",80,function(){});   
    
    this.myprint.getWeekCheckBox("weekDiv","weekCheckBox","星期",80,"");
    
    
    $("gridbox1").hide();
    
    
}
function rest_year(){
	var year = $("resource_year").value;
     var end = year + ''+ $("overDate").value.substring(5,7)+''+$("overDate").value.substring(8,10);
     
     getDate(year,end);
	
	 var beginDate= $("beginDate").value;
	 var overDate= $("overDate").value;
	 beginDate = year  + beginDate.substring(4,beginDate.length);
	 overDate = year  + overDate.substring(4,overDate.length);
	 $("beginDate").value = beginDate;
	 $("overDate").value = overDate;

	 resetStore();

}
 function resetStore(){
 	
 	 mygrid.clearAll();
 	
 	
	var orgId =   $("orgId").value;
	var version =  $("resource_year").value;
	

//    var dateField_start = Ext.getCmp('startDate');
//    var dateField_end = Ext.getCmp('endDate');
//    
//    var startDate =    dateField_start.getValue();
//    var endDate =    dateField_end.getValue();
//
//	  var myDate=new Date();
//	  myDate.setFullYear(version,startDate.getMonth(),startDate.getDate());
//	  dateField_start.setValue(myDate); 
//	  var myDate=new Date();
//      myDate.setFullYear(version,endDate.getMonth(),endDate.getDate());
//	  dateField_end.setValue(myDate); 

	var cmd1 =  Ext.getCmp('search_resource_cmd');
	var tree = Ext.getCmp('search_resource_tree');
	
		tree.root.attributes.orgId = orgId;
		tree.root.attributes.version = version;
			
	if(tree.root.isLoaded()){
		cmd1.clearValue(); 
		tree.root.reload(); 
	}

}



function get_cur_year(){
	config_serviceDate =  _app_params.serviceDate.def;
	$("resource_year").value =  _app_params.serviceDate.year;
	resource_year = _app_params.serviceDate.year;
}

function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");
	 	var dialogcontent = $("dialogcontentDiv");
//	var wd = (dialogcontent.offsetWidth)*1.029;   
	var wd = $("gridbox").offsetWidth;

//	var dw = wd*0.025;  //0.775
//	var dw2 = wd*0.035;  //0.175 
//	var dw3 = wd*0.05; 
//    mygrid.setSkin("xp");
//    mygrid.enableAlterCss("even","uneven"); 
    

	var flds = "位置,月,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,标准,总规定,总使用,饱和度";
	mygrid.setHeader(flds);
	
//    mygrid.attachHeader("#rspan,#rspan,发站,发站,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan");	
	
	
	var columnIds = "resourceName,month,dayTimes[0]," 
					+"dayTimes[1],dayTimes[2],dayTimes[3],dayTimes[4],dayTimes[5],"
					+"dayTimes[6],dayTimes[7],dayTimes[8],dayTimes[9],dayTimes[10],"
					+"dayTimes[11],dayTimes[12],dayTimes[13],dayTimes[14],dayTimes[15],"
					+"dayTimes[16],dayTimes[17],dayTimes[18],dayTimes[19],dayTimes[20],"
					+"dayTimes[21],dayTimes[22],dayTimes[23],dayTimes[24],dayTimes[25],"
					+"dayTimes[26],dayTimes[27],dayTimes[28],dayTimes[29],dayTimes[30],"
					+"stand,total,sumUsed,full";
	mygrid.setColumnIds(columnIds);
	
	
	var dw = 2.6;  //0.775
	var dw2 = 3;  //0.175 
	var dw3 = 6; 	
	
//	mygrid.setInitWidthsP("4.8,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,2.6,3,3,3,3");

//    mygrid.setInitWidths("100,25,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,50,58,58,58");
//	mygrid.setInitWidthsP("11,4,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,4,4.5,4.5,4.5");
	var ss =[dw3,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw2,dw2,dw2,dw2];
	mygrid.setInitWidthsP(ss.join(","));
//	mygrid.setInitWidths(wd*0.11,wd*0.04,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.03,wd*0.04,wd*0.045,wd*0.045,wd*0.045);

//	mygrid.setInitWidths(ss.join(","));
	
	
	mygrid.setColAlign("left,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,right,right,right,right")
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
    
//	mygrid.setMultiLine(false);
//	mygrid.setEditable(false);
    mygrid.setOnEditCellHandler(doOnEditCell);
//	mygrid.setDragBehavior("nextSibling"); //nextSibling complex
//	mygrid.enableRowsHover(true,'grid_hover')
//	mygrid.setOnRowSelectHandler(doOnRowSelected);
//	mygrid.enableDragAndDrop(false);
//	mygrid.setOnRowSelectHandler(doOnRowSelected,true);
//    mygrid.setDragHandler(do_drag);
//    mygrid.setDropHandler(do_drop);
//  mygrid.lockRow(3,true);
//mygrid.setSkin("modern2");
	mygrid.init();	 
	mygrid.enableAlterCss("even","uneven");
//	mygrid.setSkin("modern2");
//	mygrid.splitAt(2);
	mygrid.setSizes();
//	mygrid.setSizes();	("light"); modern2
	
}


function doOnRowSelected(id){
	var row = mygrid.getRowById(id);
	var s = row.getAttribute("mybgcolor");
	

	
	if(isUndefined(s)) s ="";

	if(s == 'red') {
		row.setAttribute("mybgcolor","");
		var css = row.className.indexOf(mygrid._cssUnEven) >-1 ?"background-color:#eee;":"background-color:white;";
		mygrid.setRowTextStyle(id,css); 
	}else{
		row.setAttribute("mybgcolor","red");
		mygrid.setRowTextStyle(id,'background-color:#FFCC99;font-size:13px;');
	}

}


function initGrid1(){
	mygrid1 = new dhtmlXGridObject('gridbox1');
	mygrid1.selMultiRows = true;
//	mygrid1.setImagePath("image/grid/");
	mygrid1.setImagePath("image/grid/");
	flds = "频道,月份,标准,使用,剩余,饱和度"; 
	mygrid1.setInitWidthsP("10,10,20,20,20,20");
	mygrid1.setHeader(flds);
	mygrid1.flds = flds;
	
	var columnIds = "channel,month,stan,utime,leave,rate";
	mygrid1.setColumnIds(columnIds);

	mygrid1.setColAlign("center,center,right,right,right,right");
	mygrid1.setColTypes("tree,ed,ed,ed,ed,ed"); 

	mygrid1.setMultiLine(false);
	mygrid1.setEditable(false);
//	mygrid1.setDragBehavior("nextSibling"); //nextSibling complex

	mygrid1.enableAlterCss("even","uneven");   
	mygrid1.setSkin("modern2");  
	mygrid1.init();  
	
	mygrid1.attachFooter('合计:, , , , , ',['text-align:center;','text-align:left;','text-align:right;','text-align:right;','text-align:right;','text-align:right;']);
	
	
//		mygrid.setSortImgState(true,0,"ASC"); 
}

function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
//    var adResCount = $("adResCount");
//    var carrierTypeTreebox = $("carrierTypeTreebox");
//    var customerProduct_div = $("customerProduct_div");
    var gridbox = $("gridbox");
     
//     $("test_gridbox").style.width =  gridbox.style.width-1 +"px";	
     gridbox.style.height =  (dialogcontent.offsetHeight -dialogcontent.offsetTop)*0.92 +"px";	
     
     $("gridbox1").style.height =  (dialogcontent.offsetHeight -dialogcontent.offsetTop)*0.92 +"px";	
     
//     $("gridbox1").style.height =  (dialogcontent.offsetHeight -dialogcontent.offsetTop)*0.92 +"px";	
     
//     carrierTypeTreebox.hide();
     
     if(mygrid)  mygrid.setSizes();	
//     if(mygrid1)  mygrid1.setSizes();	


} 
function setCarrierTypePara(obj){
	obj.className  = "carrierType";
	obj.IdPrefix   = obj.className + "Id";
	obj.treebox	   = obj.className + "Treebox";
	obj.tree = new Tree(obj.treebox); 
}
function getCarrierTypeTree(obj){
	var obj_tree = obj.tree.dhtmlTree;	
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.enableItemEditor(false);
	obj_tree.enableDragAndDrop(false);
	obj.reset();
	obj.obj.parentId = 0;
	
	var func = function(treeXml){
		obj_tree.loadXMLString(treeXml);
		 mygrid.setSizes();	
	}
	//分频道显示树
	if(channelModelParam!=1){
			obj.getTreeXMLFromMap(carrier.IdPrefix,resource.IdPrefix,func);
	}else{
			obj.getTreeXMLForChannel(carrier.IdPrefix,resource.IdPrefix,channelModelParam);
			obj_tree.loadXMLString(obj.tree.treeXML);
	}
	
	
////	obj.getTreeXML(carrier.IdPrefix,resource.IdPrefix);
//	obj.getTreeXMLFromMap(carrier.IdPrefix,resource.IdPrefix,func);
}


function doOnEditCell(states,rowId,cellIndex){
	var cln = mygrid.getColumnId(cellIndex);
	var resourceId = mygrid.getUserData(rowId,"resourceId");
	if(states == 0 && cln.indexOf('dayTimes') > -1 && resourceId >0){
		var v = mygrid.cells(rowId,cellIndex).getValue();
		
		if(v != 0){
			var month = mygrid.getUserData(rowId,"month");
			var day = ((cellIndex-1)+'').length ==1?'0'+(cellIndex-1):cellIndex-1;
			var publishDate = month + ''+day;
			getAdvers(resourceId,publishDate,orgId);
		}
	}
	return false;
}



function getAdvers(resourceId,publishDate,orgId){
//	$('CNZZ_AD_BOTTOM_').show();
		var dialogcontent = $("dialogcontentDiv");
		var dialogcontentW = dialogcontent.offsetWidth;
		var dialogcontentH = dialogcontent.offsetHeight;
		var winW= dialogcontentW * 0.6;
		var winH = dialogcontentH*0.8;
		var title = "";            
		var urlStr =  getCtxPath()+"selectPopup/checkAdver.html?publishDate="+publishDate+"&resourceId="+resourceId+"&orgId="+orgId;//$('CNZZ_AD_content_box').src=urlStr;
//		openWindow(urlStr,title,'width='+winW+',height='+winH);	
		
		
//    var win = new Ext.Window({  
//                id:'win',  
//                width:700,  
//                height:600,  
//                modal:true,  
//                html:"<iframe id='openwin' src='one.jsp' scrolling='auto' style='width:100%;height:100%;margin:0;padding:0'></iframe>",  
//                renderTo:Ext.getBody(),  
//                defaults: {  
//                    border:false  
//                }  
//            })  
            
 	function removeWin(){winAdver.destroy();} 		
 	

    winAdver = new Ext.Window({
            	id:'moduleId',
            	title:'播出的广告',
                //applyTo:'print-win',
//                renderTo: desktopEl,
                 modal:true,
                layout:'fit',
                width:winW,
                height:winH,
                closeAction:'destroy',
                plain: true,

				x:myprint.getWinX(winW),
				y:myprint.getWinY(winH),
				minimizable:true,
				maximizable: false,
//                items: {html:applet},
    			html:"<iframe id='openwin' src='"+ urlStr +"' scrolling='auto' style='width:100%;height:100%;margin:0;padding:0'></iframe>",  
                buttons: [{
                    text: '关闭',
                    handler: function(){
                        removeWin();
                    }
                }]
            });
//        }		
		 		
          		

   winAdver.show();
		
}
function initResourceTree(){
	var obj =carrierType;
	var obj_tree = obj.tree.dhtmlTree;	         
//	obj_tree.enableCheckBoxes(true);
//	obj_tree.enableThreeStateCheckboxes(true);
//	obj_tree.enableItemEditor(false);
//	obj_tree.enableDragAndDrop(true);
//	obj_tree.setOnClickHandler(doOnSelect);//set function to call on dbl click
//	obj_tree.setOnDblClickHandler(doOnDblClick);//set function to call on dbl click

//    obj_tree.enableItemEditor(false);
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableDragAndDrop(false);	
	obj_tree.enableMercyDrag(true);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.setOnClickHandler(doOnSelect);//set function to call on dbl click
	
	obj_tree.enableAutoTooltips(true);
	
	
	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	//obj_tree.setDragHandler(doOnBeforeDrop);
	if(tvNameParam =='fztv'){
		getResourceTreeForFztv(obj);
	}else{
		$('order_by').hide();
		getResourceTree(obj);
	}
}
function getResourceTree(){
	var obj =carrierType;
	
	var getxml = function(strXML){ 
		obj.tree.dhtmlTree.deleteChildItems(0);	
		obj.tree.dhtmlTree.loadXMLString(strXML);
		Ext.getBody().unmask();
	} 
//	obj.reset();
//	obj.obj.parentId = 0;
//	obj.obj.orgId = $("orgId").value;
//	obj.getTreeXMLFromMapByYear2(carrier.IdPrefix,resource.IdPrefix,resource_year,true,getxml);
	
	
	carrierType.reset();
	carrierType.obj.parentId = 0;
	carrierType.obj.nodeLevel = 999;
	carrierType.obj.orgId = $("orgId").value;
	
	carrierType.obj.memo = "3";
	carrierType.obj.enable = 0;
	carrierType.obj.fitterCarrier = 1;
	carrierType.obj.loginUser = userName;	
	carrierType.obj.isFineRes = 1;		
	carrierType.getTreeXMLByYear(carrier.IdPrefix,resource.IdPrefix,resource_year,getxml);	
	
	
	
}
function getResourceTreeForFztv(obj){
	var getxml = function(strXML){ 
		obj.tree.dhtmlTree.loadXMLString(strXML);
		Ext.getBody().unmask();
	} 
	obj.reset();
	obj.obj.parentId = 0;
	obj.obj.nodeLevel=4;
	if($('order_by').value==1){
		obj.obj.displayNo = 1;
	}
	
	obj.getTreeXMLByYear(carrier.IdPrefix,resource.IdPrefix,resource_year,getxml); 
}
function doOnSelect(itemId){
	        if(itemId == "root") return false;
	        var isItemChecked = carrierType.tree.dhtmlTree.isItemChecked(itemId);
		carrierType.tree.dhtmlTree.setSubChecked(itemId,!isItemChecked);
}
//function doOnDblClick(itemId){
//	        var isOpenState = this.getOpenState(itemId);
//	        if(isOpenState == -1){
//	        	this.openItem(itemId);	
//	        }else{
//	        	this.closeItem(itemId);
//		}	
//}

function setCustomerProductPara(obj){
	obj.enableEdit	= true;
	obj.enableDel	= true;
	 
	obj.className = "customerProduct";
	obj.IdPrefix 	= obj.className + "Id";
	obj.tableName   = obj.className + "List";
//	obj.fillObjName = obj.className + "TBody";
	obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
//	obj.tBody 		= $(obj.fillObjName);
	 
	obj.pageInfo 	= "pageInfo_" + obj.className;
	obj.pageSize 	= "20";
	 
	obj.page = new Page(obj.pageInfo,obj.pageSize);

}
function setCarrierPara(obj){
	obj.className  = "carrier";
	obj.IdPrefix 	= obj.className + "Id";
}
function setResourcePara(obj){
	obj.className  = "resource";
 	obj.IdPrefix 	= obj.className + "Id";
}

function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "customerId";
	// obj.treebox	= obj.className + "Treebox";
//	 obj.tree 		= new Tree(obj.treebox); 
} 

function getDate(){

//    var month = theMonth-1;
//	var endDay = getMonthEndDay(theYear,month);
	
	Calendar.setup({
		inputField  : "beginDate",	  // id of the input field
//		ifFormat	: "%Y%        m%d",	  // the date format
		singleClick	  : true,
		button	  : "beginDate"	// id of the button
	});
	
	Calendar.setup({
		inputField  : "overDate",	  // id of the input field
//		ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "overDate"	// id of the button
	});

	$("beginDate").value = getFormatDay(myDate.getNewDayStartDay1(config_serviceDate),'y/m/d');
	$("overDate").value = getFormatDay(myDate.getNewDayEndDay1(config_serviceDate),'y/m/d');	
	
}
//function getMonthEndDay(theYear,month){
//	//Date._MD = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
//	var days = new Array();
//	days.push(31);
//	days.push(28);
//	days.push(31);
//	days.push(30);
//	days.push(31);
//	days.push(30);
//	days.push(31);
//	days.push(31);
//	days.push(30);
//	days.push(31);
//	days.push(30);
//	days.push(31);
//	if (typeof month == "undefined") {
//		month = this.getMonth();
//	}
//	if (((0 == (theYear % 4)) && ( (0 != (theYear % 100)) || (0 == (theYear % 400)))) && month == 1) {
//		return 29;
//	} else {
//		return days[month];
//	}
//}
function weekSelectQuery(){
	closeSearchDiv();
	search();
}



function printReport(mode){
//	 var s=['view','print','excel'];
	 
	if(mode =="view"){
		btn_view_queryAdre();
	}
	if(mode =="print"){
		btn_print_queryAdre();
	}
	if(mode =="excel"){
		btn_export_queryAdre();
	}
	
	if(mode =="chart"){
		getFusionChartObjs();
	}	
	if(mode =="query"){
		search();
	}	   
}



function buttonEventFill(){
//	var btn_search=$("searchRes");
//	btn_search.onclick=search;
	
//	var weekSelect_query = $("weekSelect_query");
//	weekSelect_query.onclick=weekSelectQuery;
	
//	var btn_display = $("btn_display");
//	btn_display.onclick = changeButtonDisplay;
//	
//	var btn_hidden = $("btn_hidden");
//	btn_hidden.onclick = changeButtonHidden;
	
//	var btn_weekSelect = $("btn_weekSelect");
//	btn_weekSelect.onclick = displaySearchDiv;
	
//	var btn_weekSelect_close = $("btn_weekSelect_close");
//	btn_weekSelect_close.onclick = closeSearchDiv;
	
//	var Btn_view_queryAdre = $("Btn_view_queryAdre");
//	Btn_view_queryAdre.onclick = btn_view_queryAdre;
//
//	var Btn_print_queryAdre = $("Btn_print_queryAdre");
//	Btn_print_queryAdre.onclick = btn_print_queryAdre;	
//	
//	var Btn_export_queryAdre = $("Btn_export_queryAdre");
//	Btn_export_queryAdre.onclick = btn_export_queryAdre;	
	
	
//	var Btn_customerName = $("customer_name");
//	Btn_customerName.onkeypress= getCustomerAutoCompltByName;
//	Btn_customerName.onclick = resetText;
	
	 
	 //Btn_customerName.onblur = function (){
	 	//$("customerName").value = $("customer_name").value;
	 //}
	 
//	 		resourceCommandTree.on("select" , function(box){resetStore(); }); 
	var change_resource_year = $("resource_year");
	change_resource_year.onchange = rest_year;
	
	
	var Btn_btn_sum = $("btn_sum");
	Btn_btn_sum.onchange = show_sum_grid;
	
//	var change_order_by = $("order_by");
//	change_order_by.onchange = rest_resource_tree;
}
















function rest_resource_tree(){
	 resource_year = $("resource_year").value;
//	 reLoadTree(carrierType);
	 var beginDate= $("beginDate").value;
	 var overDate= $("overDate").value;
	 beginDate = resource_year  + beginDate.substring(4,beginDate.length);
	 overDate = resource_year  + overDate.substring(4,overDate.length);
	 $("beginDate").value = beginDate;
	 $("overDate").value = overDate;
	
	 var cmdRes = Ext.getCmp('search_resource_tree');
	 if(cmdRes) {
		 cmdRes.loader.params.orgId = $("orgId").value;
		 cmdRes.loader.params.version = resource_year;
		 resource.obj.version = resource_year;
		 cmdRes.root.attributes.version = resource_year;
	 	 cmdRes.root.reload();
	 	 mygrid.clearAll();
	 }
	
	 
	 
}
function reLoadTree(obj){
	obj.tree.dhtmlTree.deleteChildItems(0);
	if(tvNameParam =='fztv'){
		getResourceTreeForFztv(obj);
	}else{
		getResourceTree(obj);
	}
//	getResourceTree(obj);
}

//function resetText(ev){
//	 $("customer_name").value = null;
//	 $("customerId").value = null;
//}

function btn_view_queryAdre(){
	 $("model").value = "view";
	// $("reportType").value = "queryAdre_report";
	 button_print("view");
}	
function btn_print_queryAdre(){
	 $("model").value = "print";
	 //$("reportType").value = "queryAdre_report";
	 button_print("print");
}
function btn_export_queryAdre(){
	 $("model").value = "export";
	// $("reportType").value = "queryAdre_report";
	 button_print("export");
}
function button_print(model){     
	
	var i = $("btn_sum").value;
	
	if(i == 1){
//	alert(11);
//	$("resourceIdForm").value = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
	$("resourceIdForm").value = Ext.getCmp('search_resource_tree').getAllCheckedIds(3).split('_').join(',');

	
	$("startDateForm").value = getFormatDay($("beginDate").value,'ymd');
	$("endDateForm").value = getFormatDay($("overDate").value,'ymd');
//	$("customerName").value = $("customerId").value;
    $("customerName").value = Ext.getCmp("customer_name").getRawValue();		
	
	
	$("mode").value  = $("seach_type").value;
	$("type").value  = 0;
	$("weekdays").value  = Ext.getCmp('weekCheckBox').getCheckedValue();
	$("orderBy").value  =  $("order_by").value;
	
	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");

//	alert(22);
	reportForm.target = tarForm;
	reportForm.action="reports/jsp/queryAdress_print.jsp";
	reportForm.submit(); 			
	}
	if(i == 2){
		  
			var paramObj ={}; var printParam ={};
			paramObj.orgId = $("orgId").value;
			paramObj.year = $("resource_year").value;
			paramObj.type = "report";
//			paramObj.resIds = Ext.getCmp('search_resource_tree').getAllCheckedIds(3).split('_').join(',');		
			 printParam = {
						model:  model,
					 	title:'时间汇总',
		                reportType: "adresourceSum",
		                reportFile:'',
		                headers:mygrid1.flds, 
		                displaySumColum:"0,0,1,1,1,1",
		                colAlign:"center,center,right,right,right,right",
		                colTypes:"ed,ed,ed,ed,ed,ed",
		                widthsP:"10,10,20,20,20,20",
		                isSum:false,
		                isVertical:false
		 				}; 	
		 				
	var a = Object.extend(paramObj,printParam);
	myprint.loadApplet(a,ctxPath,800,500);		 					
			
	}
}




function search(){
	var i = $("btn_sum").value;
		
	show_sum_grid();
	
	var beginDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
//	var customerName = $("customerId").value;
	
    var customerId =  Ext.getCmp("customer_name").getValue();
    var customerName = Ext.getCmp("customer_name").getRawValue();	
	
	
	var mode = $("seach_type").value;
	 rebuild = true;
	var isRoll = true;
	var onlyHistory = false;
//	var resIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
	var resIds =  Ext.getCmp('search_resource_tree').getAllCheckedIds(3).split('_');
	var orderBy = $("order_by").value;
	

	
//	var weekIds = getWeekIds();

	var weekStr = Ext.getCmp('weekCheckBox').getCheckedValue();

	 
//	alert(resIds);
	if(resIds != null && resIds!='' && i==1){
	
		if(beginDate != '' && endDate != '' && i==1){
			if(beginDate > endDate){
				alert("开始日期不能大于结束日期");
				return false;
			}

		//	customerProduct.getResourceByDate(beginDate,endDate,resIds,func);
			
		}else{
//			alert("请选择日期");
			extjMessage('请选择日期!');return false;
		}
	}else{
//		alert("没有可供查询的广告资源!");
		if(i==1){
					extjMessage('请先选择时段!');
				Ext.getCmp('search_resource_cmd').fireEvent('select',this); 
				return false;
		}

	}
	
	
					var func = function(xml){
								changeButtonHidden();
								//alert(xml);
							    grid.clearAll();
							    
				
								grid.loadXMLString(xml);
								
				//				mygrid.setCellTextStyle(2,2,"font-size:11px;")
								//mygrid.cells2(2,2).setBgColor("red");
								//mygrid.cells2(2,2).setTextColor("red");
								if(i == 1) {
									setFontColor();
								}else{
									attachHeaderNew44(grid);
								}
								
				
								
								Ext.getBody().unmask();
								grid.setSizes();	
				
							}
						Ext.getBody().mask('数据加载中……', 'x-mask-loading');
						
					if(i == 1){
							customerProduct.getTreeGrid($("orgId").value,weekStr,beginDate,endDate,resIds,customerName,mode,orderBy,func);	
					}else{
							var paramObj ={};
							paramObj.orgId = $("orgId").value;
							paramObj.year = $("resource_year").value;
//							paramObj.resIds = resIds.join(",");
							paramObj.type = "data";
							
							customerProduct.getTreeGridSum($H(paramObj).toQueryString(),func);	
					}		
	
	
	
	
}
//function  getWeekIds(){
//	var week0 = $("week_chose_0").checked?1:"";
//	var week1 = $("week_chose_1").checked?2:"";
//	var week2 = $("week_chose_2").checked?3:"";
//	var week3 = $("week_chose_3").checked?4:"";
//	var week4 = $("week_chose_4").checked?5:"";
//	var week5 = $("week_chose_5").checked?6:"";
//	var week6 = $("week_chose_6").checked?7:"";
//	return ""+week0+week1+week2+week3+week4+week5+week6;
//}

function  setFontColor(){
	var mode = $("seach_type").value;
	var rows = mygrid.getRowsNum();
	if(mode =="1"){
		for(var i=0;i<rows-1;i++){
			var standTime = mygrid.cells2(i,33).getValue();
			
			for(var j=2;j<33;j++){
				var usedTime = mygrid.cells2(i,j).getValue()*1;
				
				var dayStandard =  mygrid.getUserData(mygrid.getRowId(i),"dayStandard"+(j-2))*1;
				
				if(dayStandard - usedTime < 0 && dayStandard>0){
				  	mygrid.cells2(i,j).setTextColor("red");
				}
				if(dayStandard - usedTime > 0 && usedTime>0){
				  	mygrid.cells2(i,j).setTextColor("green");
				}
				
				if(dayStandard - usedTime == 0 && usedTime>0){
				  	mygrid.cells2(i,j).setTextColor("black");
				}
				
			}
		}	
	}else{
		for(var i=0;i<rows-1;i++){
			var standTime = mygrid.cells2(i,33).getValue();
			
			for(var j=2;j<33;j++){
				var usedTime = mygrid.cells2(i,j).getValue()*1;
				
				var dayStandard =  mygrid.getUserData(mygrid.getRowId(i),"dayStandard"+(j-2))*1;
				
				if(usedTime < 0 && dayStandard>0){
				  	mygrid.cells2(i,j).setTextColor("red");
				}
				if(usedTime > 0 && dayStandard>0){
				  	mygrid.cells2(i,j).setTextColor("green");
				}
				
				if(dayStandard == usedTime && dayStandard>0){
				  	mygrid.cells2(i,j).setTextColor("black");
				}
				
			}
		}		
	
	
	}
	
	
	
	
}

function changeButtonDisplay(){
//		$("btn_display").hide();
//		$("btn_hidden").show();
		showTree(true);
}

function changeButtonHidden(){
//		$("btn_display").show();
//		$("btn_hidden").hide();
		showTree(false);
}

function showTree(bln){
	
//	$("treebox").hide();
//	if(bln){
//		$("treebox").show();
////		$("customerProduct_div").hide();
//	}else{
//		$("treebox").hide();
////		var dialogcontent = $("dialogcontentDiv");
////		$("treebox").hide();
// 
////		$("customerProduct_div").show();
////		$("customerProduct_div").style.width=dialogcontent.offsetWidth*0.9+"px";
//		

		
//	}
	
//			resetHeigth();
}


function show_sum_grid(){
		var i = $("btn_sum").value;
	if(i == 1){
		 grid = mygrid;
		 $("gridbox").show();
		 $("gridbox1").hide();
	}else{
		 grid = mygrid1;
		 $("gridbox").hide();
		 $("gridbox1").show();
	}
}




function show_sum_grid_bak(){
	

 	gridbox1.clearAll();
     
//	var paramObj = getLoadDataParams();
	
		var paramObj ={};
	
	paramObj.print2 =2;
	gridbox1.print2 =2;
	
	 if(!shiduanWin){
	 	
			var closeBtn = {text: '关闭',handler: function(){
				shiduanWin.hide();
			 gridbox1.print2=1;
			}};
			

			
	  var printBtn = new Ext.Action({
		    text:'打印',
		    tooltip:'打印报表',
		    handler:function(){
		    button_print("print");
    		}
		});
		
	 var exportBtn = new Ext.Action({
		    text:'导出',
		    tooltip:'导出报表',
		    handler:function(){
		    button_print("export");
    			}
    			
		});			
			

	
			shiduanWin = new Ext.Window({
					   title : '时间汇总',
					   width : 750,
					   height : 500,
					   isTopContainer : true,
					   modal : true,
					   resizable : false,
							closable : false,
					   loadMask: true,
					   buttons: [printBtn,exportBtn,closeBtn],
					   contentEl :  $("gridbox1")
			}) 	
	 }
	
	   

			
			function setRowColor(){
				
			}
      
			var func = function(xml){
				mygrid1.loadXMLString(xml,setRowColor);
				Ext.getBody().unmask();
//				attachHeaderNew44(mygrid1);
//				mygrid1.setSizes();	
			}	

			shiduanWin.show();
			Ext.getBody().mask('数据加载中……', 'x-mask-loading');
			income.getBalanceParaSortXml($H(paramObj).toQueryString(),func);	

}


function attachHeaderNew44(grid){
	var rows = grid.getRowsNum();
	var lastId = grid.getRowId(rows-1);
	var cl_2 = (rows == 0)?"": grid.cells(lastId,2).getValue();
	var cl_3 = (rows == 0)?"": grid.cells(lastId,3).getValue();
	var cl_4 = (rows == 0)?"": grid.cells(lastId,4).getValue();
	var cl_5 = (rows == 0)?"": grid.cells(lastId,5).getValue();			
	var htm ="#rspan*#rspan*"+ cl_2 +"*"+ cl_3+"*"+ cl_4+"*"+ cl_5;
	var h = htm.split("*");
	var z =  grid.ftr.rows[1];
	
	for(var cin = 0; cin<h.length;cin++){
		if(h[cin].indexOf("#rspan") != 0) {
			var c = z.cells[z._childIndexes?z._childIndexes[parseInt(cin)]:cin];
			c.innerHTML = h[cin];		
		}

	}
	
	grid.deleteRow(lastId);
	
}


//function getCustomerAutoCompltByName(ev){
//	var customerName =$("customer_name").value;
//	customer.obj.customerName = customerName;
//
//	if(ev.keyCode == 13){
//		customer.getCustomerAutoComplet(payCustomerAutoComplet,customer.obj);
//		$("customer_name").value="";
//	}
//}
//function payCustomerAutoComplet(objs)
//{
//	var oText = $("customer_name");
//	var oDiv = $("theDivCustomerName");
//
//	var indexColumName_customerName = ["helpCode"];
//	var allColumsName_customerName =["id","helpCode","customerName","customerCategoryId","category.categoryName"];
//	var hidenColumName = ["id","customerCategoryId","helpCode"];
//	var allColumsTitle = ["客户名称","客户类别"];
//	
//	var onDivMouseDown_customerId = function(ev){
//
//		var tr = getElementByEvent(ev);
//		$("customerId").value = getCellValue(tr,0);
//		oText.value = getCellValue(tr,2);
//
//	}
//	
//	var onTextBlur = function(ev){
//
//		oDiv.style.visibility = "hidden";
//		
//		if(trim(oText.value) == "" ){
//			$("customerId").value = '';
//		}
//	}
//   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown_customerId,onTextBlur,hidenColumName,indexColumName_customerName,allColumsName_customerName,allColumsTitle);
//
//}


//function displaySearchDiv(){
//	var oDiv = $("weekSelectDiv");	
//	oDiv.style.visibility = "visible";
//}
//
//function closeSearchDiv(){
//	var oDiv = $("weekSelectDiv");
//	oDiv.style.visibility = "hidden";
//}
