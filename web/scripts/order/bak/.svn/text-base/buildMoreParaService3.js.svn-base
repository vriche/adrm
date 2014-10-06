

var resource = new Resource();
var carrier = new Carrier();
var carrierType = new CarrierType();
var specific = new Specific();
var orderDetail = new OrderDetail();

 var winW;
 var winH;
 var orgId =1;
 var mygrid;
 var mygrid1;
 var mygrid2;
 var compagesDiaWin;
 var displayWeek = false;
 

 
 callOnLoad(init);	

 
  
	function init(){
		
	

		var srcStr = decodeURI(window.location.href);
		ctxPath = _app_params.ctxPath;	
		
		tvNameParam =  _app_params.sysParam.tvNameParam;	
		loginUserName =  _app_params.user.username;
		loginUserFullName =  _app_params.user.fullName;
		loginUserId =  _app_params.user.id;
		
		tag_time_out =  _app_params.rights.tag_time_out;

		order_year = getParamFromUrl(srcStr,"order_year");
	
		orgId = getParamFromUrl(srcStr,"orgId");
		resourceIds = getParamFromUrl(srcStr,"resourceIds");
		matterId = getParamFromUrl(srcStr,"matterId");
		matterName = getParamFromUrl(srcStr,"matterName");
		edit = getParamFromUrl(srcStr,"edit");
		respecId = getParamFromUrl(srcStr,"respecId");

		version = getParamFromUrl(srcStr,"version");
		
//		startDate = getParamFromUrl(srcStr,"startDate"); 
//		endDate = getParamFromUrl(srcStr,"endDate"); 
		
		startDate1 = _app_params.serviceDate.defStartDate;
		startDate2 = _app_params.serviceDate.def;
		endDate = _app_params.serviceDate.defEndDate;

		specificValue = getParamFromUrl(srcStr,"specificValue");
		adLength = getParamFromUrl(srcStr,"adLength");
		basePrice = getParamFromUrl(srcStr,"basePrice");	
		realPrice = getParamFromUrl(srcStr,"realPrice");
		appRate = getParamFromUrl(srcStr,"appRate");
		favourRate = getParamFromUrl(srcStr,"favourRate");
		moneyBalance = getParamFromUrl(srcStr,"moneyBalance");
		priceTypeId = getParamFromUrl(srcStr,"priceTypeId");
		
		paramFromUrl ={};
		
			paramFromUrl.orgId = orgId;
			paramFromUrl.isLock = false;
			paramFromUrl.version = version;
			paramFromUrl.startDate = startDate1;
			paramFromUrl.endDate = endDate;
			paramFromUrl.resourceIds = resourceIds.replace(/%2C/g, ',');
			paramFromUrl.respecId =respecId;
			paramFromUrl.specificValue = specificValue;
			paramFromUrl.priceTypeId = priceTypeId;	
			
			paramFromUrl.matterId = matterId;		
			paramFromUrl.matterName = matterName;
			paramFromUrl.edit = edit;			
			paramFromUrl.adLength = adLength;
			paramFromUrl.basePrice = basePrice;
			paramFromUrl.realPrice = realPrice;
			paramFromUrl.appRate = appRate;
			paramFromUrl.favourRate = favourRate;
			paramFromUrl.moneyBalance = moneyBalance;
			paramFromUrl.isTimeOutRight = tag_time_out;	

//			resourceIds = resourceIds.replace(/,/g, "%2C"); 
//			resourceIds = resourceIds.replace(/%2C/g, ','); 

						
		resetHeigth();

		initGrid1();
		
		initGrid1ContextMenu();

		initGrid2();
//		var arr =[];
//		for(var i = 0;i<37;i++){
//			arr.push(0);
//		}
//		 mygrid2.addRow(1,arr,1);
		var iddd= (new Date()).valueOf();
		 mygrid2.addRow(iddd,[],-1);
		 
		 
		 for(var j = 0;j<37;j++){
           	  var cell = mygrid2.cells(iddd,j);
           	  var td = cell.cell;
				dhtmlxEvent(td,"click", mygrid2onKeypressClick)
           }
         

//		initGrid3();
		
		resetHeigth();
		
//		createGrid1(paramFromUrl);
		
//		Ext.getDoc().on("contextmenu",function(e){  
//	    	e.stopEvent();//终止之前的事件响应，不然还会在页面上弹出讨厌的ie右键菜单  
//	    }); 
	    
//	    resetHeigth();
//	    getBroArrangeStarEndDate(_app_params);


//		buidArray(resourceIds,startDate,endDate,matterId,respecId,realPrice);
  }
  
 
 function initGrid3(){
  	mygrid = new dhtmlXGridObject('gridbox2');
//	mygrid2.setImagePath("../../codebase/imgs/");
	mygrid.setImagePath(ctxPath+"scripts/dhtml/2.6/dhtmlxGrid/codebase/imgs/");
	mygrid.setHeader("Sales,Book Title,Author,Price,In Store,Shipping,Bestseller,Date of Publication");
	mygrid.setInitWidths("50,150,100,80,80,80,80,200");
	mygrid.setColAlign("right,left,left,right,center,left,center,center");
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed");
//	mygrid.setColSorting("na,str,str,int,int,int,na,na");
	mygrid.init();
	mygrid.setSkin("dhx_skyblue");
	var sb;
	sb = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	sb = sb + "<rows>"
		sb = sb + "<row id=1>"
		sb = sb + "<cell><![CDATA[-1500]]</cell>"
		sb = sb + "<cell><![CDATA[A Time to Kill]]</cell>"
		sb = sb + "<cell><![CDATA[John Grisham]]</cell>"
		sb = sb + "<cell><![CDATA[12.99]]</cell>"
		sb = sb + "<cell><![CDATA[1]]</cell>"
		sb = sb + "<cell><![CDATA[24]]</cell>"
		sb = sb + "<cell><![CDATA[0]]</cell>"
		sb = sb + "<cell><![CDATA[05/01/1998]]</cell>"
	sb = sb + "</row>"
	sb = sb + "<row id=2>"
		sb = sb + "<cell><![CDATA[1000]]</cell>"
		sb = sb + "<cell><![CDATA[Blood and Smoke]]</cell>"
		sb = sb + "<cell><![CDATA[Stephen King]]</cell>"
		sb = sb + "<cell><![CDATA[0]]</cell>"
		sb = sb + "<cell><![CDATA[1]]</cell>"
		sb = sb + "<cell><![CDATA[24]]</cell>"
		sb = sb + "<cell><![CDATA[0]]</cell>"
		sb = sb + "<cell><![CDATA[01/01/2000]]</cell>"
	sb = sb + "</row>"
	sb = sb + "</rows>";
	
//	function callFun(){
//		alert(11)
//		 mygrid.groupBy(2);
//	}
//	mygrid.loadXMLString(sb,callFun);	
//		alert((new Date()).valueOf())
	mygrid.addRow((new Date()).valueOf(),[1,'我','John Grisham',3,1,1,1,0],-1);
	mygrid.addRow((new Date()).valueOf(),[1,'我','你',3,1,1,1,0],-1);
	
//	mygrid.loadXML(ctxPath+"scripts/dhtml/2.6/dhtmlxGrid/samples/common/grid.xml", function() {
////    mygrid.groupBy(2);
//})
 } 
  
;

//  function createGrid1(param,caFun){
// 
//        var objs =  param.resources;
//        
////       <?xml version="1.0"?>
////	  	mygrid1.clearAll();
//		var sb;
////		sb = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
//		sb =  "<?xml version=\"1.0\"?>";
//		sb = sb + "<rows>";  
////		var seq = Math.random();
//		for(var i = 0;i<objs.length;i++){
//			    var row_id =  mygrid1.uid();
//				sb = sb + "<row  id=\""+ row_id +"\"" +">";
//				sb = sb + "<cell>1</cell>";    //edit
//				sb = sb + "<cell>2</cell>";    //edit
//				sb = sb + "<cell>3</cell>";    //edit
//				sb = sb + "<cell>4</cell>";    //edit
//				sb = sb + "</row>";		
//		}	
//		
//		
//				sb = sb + "</rows>";  	
//		function callFun(){
//				mygrid1.setSizes();	
//				if(caFun) caFun();
//				mygrid1.uncheckAll();
//		}
//
////        alert(mygrid1.doLoadDetails)
//		mygrid1.loadXMLString(sb,callFun);		
//		mygrid1.setSizes();		
//
//  }
function createGrid1(param,caFun){
 
        var objs =  param.resources;
        
//       <?xml version="1.0"?>
//	  	mygrid1.clearAll();
		var sb;
		sb = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
//		sb =  "<?xml version=\"1.0\"?>";
		sb = sb + "<rows>";  
//		var seq = Math.random();
		for(var i = 0;i<objs.length;i++){
			    var row_id =  mygrid1.uid();
				sb = sb + "<row  id=\""+ row_id +"\"" +">";
//				sb = sb + "<cell><![CDATA["+ "0"  +"]]></cell>";
				sb = sb + "<cell><![CDATA["+  objs[i].broTime +' '+ objs[i].resourceMemo  +' '+ objs[i].resourceName +"]]></cell>";
				sb = sb + "<cell><![CDATA["+  ""   +"]]></cell>";    //edit
				sb = sb + "<cell><![CDATA["+  ""  +"]]></cell>";    //adLength
				sb = sb + "<cell><![CDATA["+  ""  +"]]></cell>";  //specificValue
				sb = sb + "<cell><![CDATA["+ getFormatDay(param.startDate,'y/m/d')   +"]]></cell>";  //getFormatDay(param.startDate,'y/m/d')
				sb = sb + "<cell><![CDATA["+ getFormatDay(param.endDate,'y/m/d')    +"]]></cell>";   //getFormatDay(param.endDate,'y/m/d')
				sb = sb + "<cell><![CDATA["+ "0"   +"]]></cell>";
				sb = sb + "<cell><![CDATA[0]]></cell>";	
				sb = sb + "<cell><![CDATA["+ 0   +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ 0   +"]]></cell>";
				sb = sb + "<cell><![CDATA["+ 0   +"]]></cell>";		
//				sb = sb + "<cell><![CDATA["+ "<a href=\"javascript:void(0);\" onclick=\"deleteRow();\">删除选中行</a>"   +"]]></cell>";	
				
				sb = sb + "<userdata name=\"resourceId\"><![CDATA["+ objs[i].id   +"]]></userdata>";		
			    sb = sb + "<userdata name=\"id\">0</userdata>";
			    sb = sb + "<userdata name=\"matterId\"><![CDATA["+ "0"   +"]]></userdata>";		
			    sb = sb + "<userdata name=\"pos\"><![CDATA["+ objs[i].resourceMemo   +"]]></userdata>";		
				sb = sb + "</row>";		
		}	
		
		
				sb = sb + "</rows>";  	
		function callFun(){
				mygrid1.setSizes();	
				if(caFun) caFun();
//				mygrid1.uncheckAll();
		}

//        alert(mygrid1.doLoadDetails)
		mygrid1.loadXMLString(sb,callFun);		
		mygrid1.setSizes();		

  }

  
function resetHeigth(){
			winW = parent.build_more_paraArray.getInnerWidth();
			winH = parent.build_more_paraArray.getInnerHeight();
		

			var gridbox1 = $("gridbox1");
			gridbox1.style.width = winW +"px";	
			gridbox1.style.height = winH*0.35+"px";  
				    
			var gridbox2 = $("gridbox2");
			gridbox2.style.width = winW +"px";	
			gridbox2.style.height = winH*0.65+"px";  
		     
 } 
 
  function initGrid1_bak1(){
  	mygrid1 = new dhtmlXGridObject('gridbox1');
//	mygrid.setImagePath("../../codebase/imgs/");
	mygrid1.setHeader("Column A, Column B, Column C, Column D");
	mygrid1.setInitWidths("100,250,80,*");
	mygrid1.setColAlign("right,left,center,right");
	mygrid1.setColTypes("ro,ed,ch,price");
	mygrid1.setColSorting("int,str,str,str");
//	mygrid.attachEvent("onRowSelect", doOnRowSelected);
//	mygrid.attachEvent("onEditCell", doOnCellEdit);
//	mygrid.attachEvent("onEnter", doOnEnter);
//	mygrid.attachEvent("onCheckbox", doOnCheck);
//	mygrid.attachEvent("onBeforeRowDeleted", doBeforeRowDeleted);
	mygrid1.init();
//	mygrid.setSkin("dhx_skyblue");
  }

 
 
 
 function initGrid1(){
 	
      

 	var sb;
	sb = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	sb = sb + "<menu id=\"0\">"
	sb = sb + "<item text=\"设置段位\" img=\"red.gif\"  id=\"edit_Red\"/>";
	sb = sb + "<item text=\"设置版本\" img=\"green.gif\"  id=\"edit_Green\"/>";
	sb = sb + "<item text=\"设置指定\" img=\"green.gif\"  id=\"edit_pos\"/>";
	sb = sb + "<item text=\"设置排期\" img=\"green.gif\"  id=\"edit_arr\"/>";
	sb = sb + "</menu>";
	
	menu = new dhtmlXMenuObject("", "dhx_web");
	menu.setIconsPath(ctxPath+"scripts/dhtml/2.6/dhtmlxGrid/codebase/imgs/");
	menu.renderAsContextMenu();
//	menu.attachEvent("onClick", onButtonClick)
	menu.loadXMLString(sb);  
	
	function onButtonClick(menuitemId, type) {
	    var data = mygrid1.contextID.split("_");
	    mygrid1.setRowTextStyle(data[0], "color:" + menuitemId.split("_")[1]);
	    return true;
	}
	menu.attachEvent("onClick", onButtonClick)	

 	var wd = $("gridbox1").offsetWidth;
	mygrid1 = new dhtmlXGridObject('gridbox1');
	

	
	mygrid1.setImagePath(ctxPath+"scripts/dhtml/2.6/dhtmlxGrid/codebase/imgs/");
	mygrid1.setHeader("广告位置,广告版本,长度,指定,开始时间,结束时间,刊例价,销售价,折扣,加收,次数,应收");
	var columnIds = "resourceName,edit,len,apppos,start,end,stantPrice,realPrice,favace,appRae,sumTime,sumPay"
	mygrid1.setColumnIds(columnIds);
	var ss =[wd*0.23,wd*0.22,wd*0.04,wd*0.05,wd*0.08,wd*0.08,wd*0.06,wd*0.06,wd*0.04,wd*0.04,wd*0.04,wd*0.05];
	mygrid1.setInitWidths(ss.join(","));

	mygrid1.setColAlign("left,left,center,center,center,right,right,right,right,right,right,center");
	mygrid1.setColTypes("ed,ed,ed,coro,calendar,calendar,ed,ed,ed,ed,ed,ed");
	mygrid1.setColSorting("str,str,str");
	
	function doOnRowSelected(rid,cellIndex){
		mygrid2.unmarkAll();
		mygrid2._HideSelection();
	}
	mygrid1.attachEvent("onRowSelect", doOnRowSelected);

//	function onRightClick(rowId,cellIndex,ev){
//		var cell = this.cells(rowId,cellIndex);
//		var e = cell.cell;
//		if(e){
//			var pos = this.getPosition(e);
//			grid1_contextmenu.showAt(ev.getXY()); 
//		}
//		
//	}
//	mygrid1.attachEvent("onRightClick", onRightClick);


	mygrid1.enableContextMenu(menu);
	
//	function my_pre_func(rowId, celInd, grid) {
//	    return true;
//	}
//	mygrid1.attachEvent("onBeforeContextMenu", my_pre_func)
//	mygrid1.attachEvent("onEditCell", doOnCellEdit);
//	mygrid1.attachEvent("onEnter", doOnEnter);
//	mygrid1.attachEvent("onCheckbox", doOnCheck);
//	mygrid1.attachEvent("onBeforeRowDeleted", doBeforeRowDeleted);
	mygrid1.enableMultiselect(true); // false by default
	mygrid1.enableBlockSelection(true); // true|false 
//	mygrid1.enableEditEvents(true);
//	mygrid1.enableBlockSelection(false);
//	mygrid1.enableAlterCss("even","uneven");
	function onBlockSelected(){
		this.setActive(true);
		for (var i=this._selectionArea.LeftTopRow; i<=this._selectionArea.RightBottomRow; i++) {
			for (var j=this._selectionArea.LeftTopCol; j<=this._selectionArea.RightBottomCol; j++) {
                var cell =  this.cells2(i,j);
//                var rowid = this.getRowId(i);
                this.selectRow(i, false, true, false);
			}
		}
		this._HideSelection();
	}
	
	mygrid1.attachEvent("onBlockSelected", onBlockSelected);
	mygrid1.init();
	
	
//	mygrid1.setSkin("dhx_skyblue");
//	mygrid1.loadXML("../common/grid.xml");s

//	var z =  mygrid1.hdr.rows[1];
//	var c = z.cells[0];
//	mygrid1._in_header_master_checkbox(c,0,['','']);
 }

function initGrid2(){
	var wd = $("gridbox2").offsetWidth;
	mygrid2 = new dhtmlXGridObject('gridbox2');
	mygrid2.selMultiRows = true;
//	mygrid2.setImagePath(ctxPath+"image/grid/");
	mygrid2.setImagePath(ctxPath+"scripts/dhtml/2.6/dhtmlxGrid/codebase/imgs/");
    mygrid2.enableMultiselect(true);
    
	var wd = $("gridbox2").offsetWidth;
	


	var flds = "版本,段位,年,月,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,次,应收";
	mygrid2.setHeader(flds);

	var columnIds = "seq,pos,year,month," 
					+"dayTimes[1],dayTimes[2],dayTimes[3],dayTimes[4],dayTimes[5],"
					+"dayTimes[6],dayTimes[7],dayTimes[8],dayTimes[9],dayTimes[10],"
					+"dayTimes[11],dayTimes[12],dayTimes[13],dayTimes[14],dayTimes[15],"
					+"dayTimes[16],dayTimes[17],dayTimes[18],dayTimes[19],dayTimes[20],"
					+"dayTimes[21],dayTimes[22],dayTimes[23],dayTimes[24],dayTimes[25],"
					+"dayTimes[26],dayTimes[27],dayTimes[28],dayTimes[29],dayTimes[30],"
					+"times,realPrice,edit";
	mygrid2.setColumnIds(columnIds);
	
	
	var dw = wd*0.026;  //2.6*31=80.6
	var dw2 = wd*0.03;  //3*2 = 6
//	var dw3 = 9+4.8;  
//		80.6 + 6 + 5 = 91.6  8.4
	

//	var ss =[3,4.8,3.5,2.5,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw2,dw2,0];
	
	var ss =[wd*0.03,wd*0.048,wd*0.035,wd*0.025,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw2,dw2];
	mygrid2.setInitWidths(ss.join(","));
	mygrid2.setColAlign("center,center,centercenter,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,right,right")
	mygrid2.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
//	mygrid2.setOnEditCellHandler(doOnEditCell);
//    mygrid2.setColSorting("int,str,int,int") ;
//    mygrid2.sortField(0,false);
//    mygrid2.setSortImgState(true,0,"ASC"); 
//	mygrid2.setEditable(true);

//	mygrid2.enableRowspan(true);
//	mygrid2.enableColSpan(true);
	mygrid2.enableMarkedCells(true); // true|false 
//	mygrid2.enableMercyDrag(true); // true|false 
	mygrid2.enableBlockSelection(true); // true|false 
	
//		mygrid2.attachEvent("onClick",function(rowId,psid){alert(11) });  
	
//	mygrid2.attachEvent("onBeforeSelect",function(rowId,psid){ return false });  
	
//	mygrid2.attachEvent("onBeforeSelect",function(rowId,psid){ return false });  
//	mygrid2.attachEvent("click",function(rowId,psid){ alert(111) });  


	
	
	function onBlockSelected(cell){
		this.unmarkAll();
		this.setActive(true);
	}
	
	mygrid2.attachEvent("onBlockSelected", onBlockSelected);
	

//	function onBeforeSelect(rid,cindex){
//		//		 alert(cindex)
//	}
//	
//	mygrid2.attachEvent("onBeforeSelect", onBeforeSelect);
	
//	mygrid2.attachEvent("onKeyPress", onKeyPress);
	
//	mygrid2.enableEditEvents(true);
	
//	mygrid2.enableEditTabOnly(true);
	
	
//	function onCellUnMarked(rid,cindex){
////		 alert(cindex)
//	}
//	mygrid2.attachEvent("onCellUnMarked", onCellUnMarked);
	
	
	
	
	
	
//	function onSelectionMove(cell){
//		
//		if(cell) alert(cell.navtype)
//			
//	}
//	
//	mygrid2.attachEvent("onSelectionMove", onSelectionMove);
	
	
	
//	enableLightMouseNavigation
	
	//grid.setStyle(ss_header, ss_grid, ss_selCell, ss_selRow);
//	 mygrid2.setStyle("", "","color:red;", "color:red;");

    var ss_header = "BORDER-RIGHT: #000000 2px solid; 1px solid;  BORDER-BOTTOM: #000000 2px solid;  BORDER-TOP: #000000 2px solid;TEXT-ALIGN: center;"
    var ss_grid = "BORDER-RIGHT: #000000 1px solid; 1px solid; BORDER-BOTTOM: #000000 1px solid; TEXT-ALIGN: center;"
    var ss_selCell ="-moz-opacity: 0.5;filter: alpha(opacity = 50);background-color:yellow;opacity:0.5;border: 1px dotted black;"
//      var ss_selCell ="BORDER-RIGHT: #FF0000 1px solid;BORDER-TOP: #FF0000 1px solid;BORDER-LEFT: #FF0000 2px solid; BORDER-BOTTOM: #FF0000 2px solid; background-color:white;";
     var ss_mark ="BORDER-RIGHT: #FF0000 1px solid;BORDER-TOP: #FF0000 1px solid;BORDER-LEFT: #FF0000 2px solid; BORDER-BOTTOM: #FF0000 2px solid;";
	mygrid2.setStyle(ss_header,ss_grid,ss_selCell,ss_mark);

	mygrid2.customGroupFormat = function(text, count) {
//		return false
	    return "Grouped by " + text + ", there are " + count + " related records";
	};

//	function mygrid2OnKeyPressed2(rowId,cind,e){
//		alert(cind)
//	}
	
	function mygrid2OnKeyPressed(keyCode,ctrlKey,shiftKey,ev){
//		alert(ctrlKey)

		if(ctrlKey||shiftKey) return false;
	
		if (this._selectionArea!= null) {
			for (var i=this._selectionArea.LeftTopRow; i<=this._selectionArea.RightBottomRow; i++) {
				for (var j=this._selectionArea.LeftTopCol; j<=this._selectionArea.RightBottomCol; j++) {
	                var cell =  this.cells2(i,j).cell;
				 	var event ={keyCode:keyCode,ctrlKey:ctrlKey,shiftKey:shiftKey,target:cell}
				 	mygrid2onKeypressClick(event);
				}
			}

			this._HideSelection();

	    }else if (this.markedRowsArr.length >1) {
	    	
	    	var marked = this.getMarked();
	    	for(var ri = 0; ri < marked.length; ri++){
	    		var rowCells = marked[ri];
	    		for(var ci = 0; ci < rowCells.length; ci++){
	    			var rid = rowCells[0]
	    			var cindex = rowCells[1]
	    			var cell =  this.cells(rid,cindex).cell;
//	    			cell._cellIndex = cindex;
	    			
					var event ={keyCode:keyCode,ctrlKey:ctrlKey,shiftKey:shiftKey,target:cell};
					mygrid2onKeypressClick(event);	    			
	    		}
	    		
	    	}

			this.unmarkAll();

	    } 
	    
	    else{
			var rowId = this.lastMarkedRow;
			var cellIndex = this.lastMarkedColumn;
			var cell = this.cells(rowId,cellIndex);
			var row = this.getRowById(rowId);
			var td = cell.cell;
		 	var event ={keyCode:keyCode,ctrlKey:ctrlKey,shiftKey:shiftKey,target:td}
		 	mygrid2onKeypressClick(event);
		 	
		 
		 	if(!shiftKey.button){
	            cell.parentNode = row;
	            cell._cellIndex = cellIndex;
				var z = getNextCell(cell, 1);
				if (z){
					this.selectCell(z.parentNode, z._cellIndex, (this.row != z.parentNode), false, true);
				};
			}

	    } 

	}
	
	

	
	function onRightClick(rowId,cellIndex,ev){


			var row = this.getRowById(rowId);
			var cell = this.cells(rowId,cellIndex);
			var td = cell.cell;

		 	this.unmarkAll();	
		 	
			if (this._selectionArea!= null) {
				for (var i=this._selectionArea.LeftTopRow; i<=this._selectionArea.RightBottomRow; i++) {
					for (var j=this._selectionArea.LeftTopCol; j<=this._selectionArea.RightBottomCol; j++) {
		                var cell =  this.cells2(i,j).cell;
					 	var event ={keyCode:48,ctrlKey:false,shiftKey:false,target:cell,button:2};
					 	mygrid2onKeypressClick(event);
					}
				}
			
				this._HideSelection();
		    } else{
			 	this.mark(rowId,cellIndex,true);
			 	var event ={keyCode:48,ctrlKey:false,shiftKey:false,target:td,button:2};
			 	mygrid2onKeypressClick(event);
		    }		 	
		 	
		 	
		 	
//           cell.parentNode = row;
//	        cell._cellIndex = cellIndex;
//		 	this.selectCell(cell.parentNode, cell._cellIndex, (this.row != cell.parentNode), false, true);
		 	

	}
    mygrid2.attachEvent("onKeyPress", mygrid2OnKeyPressed);
    mygrid2.attachEvent("onRightClick", onRightClick);
    
    	
    
//    function onKeyPressed(code,ctrl,shift){
//		alert(code)
//		return true;
//    }
//    
//    mygrid2.attachEvent("onKeyPress",onKeyPressed);
    
//	addEvent(mygrid2, "keypress", mygrid2OnKeyPressed);  				
//	mygrid2.addEventListener("keydown",mygrid2OnKeyPressed, false); 
//				td.addEventListener("keypress",mygrid2onKeypressClick, false); 



// 	mygrid2.enableBlockSelection();
//    mygrid2.setOnKeyPressed(mygrid2OnKeyPressed2);
// 	mygrid2.setOnRowSelectHandler(OnRowSelectHandler2,true);
// 	mygrid2.setOnRowDblClickedHandler(OnRowDblClicked2);
//   function onrowSelected(){alert(1)};
// 	mygrid2.setOnRowSelectHandler(onrowSelected);
//	mygrid2.enableAlterCss("even","uneven");
//	mygrid2.setSizes();
//	mygrid2.setSkin("broAaay");
//    mygrid2.setSkin("clear");
//	mygrid2.enableContextMenu(true);
//	mygrid2.setOnLeftClick(OnLeftClick);
//	mygrid2.setOnRightClick(OnLeftClick);
	mygrid2.init();	
	
	
	
//	mygrid2.setColumnHidden(37,true);
//	mygrid2.enableRowspan(true);
//	mygrid2.enableRowspan();
	
//	 mygrid2.customGroupFormat = function(text, count) {
//       return "Record " + text + "; containing " + count + " related text segments";
//   };
//	mygrid2.setSkin("dhx_skyblue");
	mygrid2.setSizes();

	
	
}



function initGrid1_bak(){
	
	mygrid1 = new dhtmlXGridObject('gridbox1');
	mygrid1.selMultiRows = true;
//	mygrid1.setImagePath(ctxPath+"scripts/dhtml/3.6/grid/sources/imgs/");
//	var dialogcontent = $("dialogcontentDiv");
//	var wd = $("gridbox1").offsetWidth;

	var flds = "序,广告位置,广告版本,长度,指定,开始时间,结束时间,刊例价,销售价,折扣,加收,次数,应收";
	mygrid1.setHeader(flds);
//	var columnIds = "seq,resourceName,edit,len,apppos,start,end,stantPrice,realPrice,favace,appRae,sumTime,sumPay"
//	mygrid1.setColumnIds(columnIds);
    var dw1 = 5; 
    var dw2 = 8; 	
	var dw3 = 6; 	

//	var ss =[3,20,22,4,5,dw2,dw2,dw3,dw3,4,4,4,6];
//	mygrid1.setInitWidthsP(ss.join(","));
	mygrid1.setInitWidthsP("3,20,22,4,5,8,8,6,6,4,4,4,6");
	mygrid1.setColAlign("center,left,left,center,center,center,right,right,right,right,right,right,center")
	mygrid1.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
//	mygrid1.setColTypes("ch,ed,ed,ed,coro,calendar,calendar,ed,ed,ed,ed,ed,ed");
	
//    mygrid1.setSkin("broAaay");
	
	
//	mygrid1.enableBlockSelection();
		
//	mygrid1.enableAlterCss("even","uneven");
	
//	mygrid1.setOnRowDblClickedHandler(OnRowDblClicked);
//	mygrid1.setOnRowSelectHandler(onRowSelectHandler,true);
	
//	mygrid1.attachEvent("onRowSelect", onRowSelectHandler);
//	mygrid1.attachEvent("onRowDblClicked", OnRowDblClicked);
//	mygrid.attachEvent("onEditCell", doOnCellEdit);
//	mygrid.attachEvent("onEnter", doOnEnter);
//	mygrid.attachEvent("onCheckbox", doOnCheck);
//	mygrid.attachEvent("onBeforeRowDeleted", doBeforeRowDeleted);
	
	
	
	
		
//	mygrid1.setOnEditCellHandler(doOnEditCell);
	mygrid1.init();	 
	
//	mygrid1.setSkin("dhx_skyblue");
	
//	getSpecCmd(3);
	
//	var z =  mygrid1.hdr.rows[1];
//	var c = z.cells[0];
//	mygrid1._in_header_master_checkbox(c,0,['',''])


	//add second row to header  //#rspan - include cell in rowspan //#cspan - include cell in colspan
//	var styles ="height:10px;,height:10px;color:red;,height:10px;color:red;,height:10px;color:red;,height:10px;,height:10px;,height:10px;,height:10px;,height:10px;,height:10px;,height:10px;,height:10px;,height:10px;,height:10px;,height:10px;"
//	mygrid1.attachHeader("#rspan,<div id='orderDetail_grid_title_flt1'>,<div id='orderDetail_grid_title_flt2'>,<div id='orderDetail_grid_title_flt3'>,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan",styles); //call this method if row was added after grid initialization
//	$("orderDetail_grid_title_flt1").appendChild(document.getElementById("edit_flt_box_1"));
//	$("orderDetail_grid_title_flt2").appendChild(document.getElementById("edit_flt_box_2"));
//	$("orderDetail_grid_title_flt3").appendChild(document.getElementById("edit_flt_box_3"));
	
//	mygrid1.setSizes();
}



function setSelectGridChecked(){
	var selectedRowsCount = mygrid1.selectedRows.length;
	if(selectedRowsCount == 0){
	    Ext.MessageBox.alert('系统提示','请选择需要处理的记录!',function(){});     
		return false;
	}else{
		return true;
	}
}
//
//function onRowSelectHandler(rowId,cIndex){
//	
////	alert(cIndex)
//
//	for(var i=0;i<mygrid1.selectedRows.length;i++){
//		 	mygrid1.selectedRows[i].className = mygrid1.selectedRows[i].className.replace(/rowselected2/g,"");
//	}
//	
//	
//	for(var i=0;i<mygrid1.selectedRows.length;i++){
//		mygrid1.selectedRows[i].className+= " rowselected2"	
//	}
//	
////	console.log(mygrid1.getRowById(rowId).firstChild);
//	
//   
////	var fitter_tyep  = parent.build_more_paraArray.buttons[0].getValue();
////
////	if(fitter_tyep == 1){
////		for(var i=0; i< mygrid2.getRowsNum();i++){
////				mygrid2.setRowHidden(mygrid2.getRowId(i),false);
////		}
////		mygrid1.clearSelection();
////	}
////
////		
////	if(fitter_tyep == 2){
////		 var row_id = mygrid1.getSelectedId();
////
////		 var seq_cindex1 = mygrid1.getColIndexById('seq');
////		 var seq_cindex2 = mygrid2.getColIndexById('seq');
////		 var seq1 = mygrid1.cells(row_id,seq_cindex1).getValue()*1;
////
////		for(var i=0;i<mygrid1.selectedRows.length;i++){
////		 	mygrid1.selectedRows[i].className=mygrid1.selectedRows[i].className.replace(/rowselected2/g,"");
////		}
////		mygrid1.getRowById(row_id).className+= " rowselected2"		
////		
////
////		for(var i=0; i < mygrid2.getRowsNum();i++){
////			row_id  = mygrid2.getRowId(i);
////			var seq2 = mygrid2.cells(row_id,seq_cindex2).getValue()*1;
////			
////			if(seq1 == seq2){
////				mygrid2.setRowHidden(mygrid2.getRowId(i),false);
////			}else{
////				mygrid2.setRowHidden(mygrid2.getRowId(i),true);
////			}
////			
////		}
////	}
//
//}




function getAllResourceMonthInfos(){
    mygrid2.clearAll();
	var rowCount = mygrid1.getRowsNum();

	for(var i = 0;i<rowCount;i++){
		var row_id = mygrid1.getRowId(i);
		getOneResourceMonthInfos(row_id,0,true,rowCount,i);
	}	
}

	
		 		

function getOneResourceMonthInfos(row_id,cindex,isMore,rowCount,rowIndex){
   

//alert(rowIndex)
	var orderDetail_obj =(new OrderDetail()).obj;
//	var row_id = mygrid1.getRowId(rowIndex);
	var orderDetail_id = mygrid1.getUserData(row_id,"id");
	var resourceId = mygrid1.getUserData(row_id,"resourceId");
	
	if(resourceId == null || resourceId =='null' || resourceId == 0) return false;
	
	var matterId = mygrid1.getUserData(row_id,"matterId");
	var pos = mygrid1.getUserData(row_id,"pos");
	var orderDetailStates = 0;
	var s_cindex = mygrid1.getColIndexById('start');
	var e_cindex = mygrid1.getColIndexById('end');
	var edit_cindex = mygrid1.getColIndexById('edit');
	

	var startDate = getFormatDay(mygrid1.cells(row_id,s_cindex).getValue(),'ymd')*1;
	var endDate = getFormatDay(mygrid1.cells(row_id,e_cindex).getValue(),'ymd')*1;
	var edit = mygrid1.cells(row_id,edit_cindex).getValue();
	
	
	
	
//	 mygrid1.editStop();

	if(!isMore){
		for(var i=0;i<mygrid1.selectedRows.length;i++){
		 	mygrid1.selectedRows[i].className=mygrid1.selectedRows[i].className.replace(/rowselected2/g,"");
		}
		mygrid1.getRowById(row_id).className+= " rowselected2"		
	}


	
//    mygrid1.clearSelection();
// 	mygrid1.editStop();
// 	alert()
//	 for(var i=0;i<mygrid1.selectedRows.length;i++){
//	 	var id = mygrid1.selectedRows[i].id;
////	 	mygrid1.selectedRows[i].className=mygrid1.selectedRows[i].className.replace(/rowselected/g,"");
//	 	mygrid1.setRowColor(id,"white");
//	 }
	 
//    var id = mygrid1.getSelectedId();
//    mygrid1.setRowColor(id,"white");

//	mygrid1.setRowTextStyle(row_id,"background-color:#e1e0d7;color:black;");
//	mygrid1.setRowColor(row_id,"#e1e0d7");

//    this.row.className+= " rowselected"

	orderDetail_obj.id = orderDetail_id;
	orderDetail_obj.publishStartDate = startDate;
	orderDetail_obj.publishEndDate = endDate;
	orderDetail_obj.resourceInfoId = resourceId;
	orderDetail_obj.specific.position = specificValue == null?'':specificValue;
	orderDetail_obj.compagesId = 0;
	orderDetail_obj.version = order_year;
	orderDetail_obj.orderDetailStates = orderDetailStates;



	var getMonthsFun = function(objs){
//		console.log(objs)
//    	parent.backup_cur_info(null,null,objs);	
		if(!isMore) mygrid2.clearAll();

		for(var i = 0;i<objs.length;i++){
			objs[i].grid1_rowId = row_id;
	  		objs[i].pos = pos;
	  		objs[i].edit = edit;
	  		objs[i].matterId = matterId;
	  		
	  		if(matterId > 0){
	  			createMonthRow(objs[i]);
	  		}
//			  if((rowCount-1) == rowIndex && i == objs.length -1 ) mygrid2.groupBy(1);
		}
		
		if((rowCount-1) == rowIndex){
//			mygrid2.groupBy(37);
//			 mygrid2.setColumnHidden(37,true);
//			 mygrid2.groupBy(0);
//			 mygrid2.setColspan(1,0,1);
//             mygrid2.setRowspan(1,0,0);
//			mygrid2.setRowspan(1, 0 ,mygrid2.getRowsNum());
//			 mygrid2.forEachRow(function(id){               	// for each row in the grid
//			 					
//									mygrid2.setRowspan(id, 1,5);
//				 })
		}
		 
		mygrid2.setSizes();
	
    }	
	
	orderDetail.getMonthInfos(orderDetail_obj,getMonthsFun);
}


function createMonthRow(obj){

	  var grid1_rowId = obj.grid1_rowId;
	  var pos = obj.pos;
	  var edit = obj.edit;
	   
	  var year = obj.year;
 	  var month = obj.month;
 	  var monthStr = obj.monthStr;
	  var monthTims = obj.monthTims;	 
	  var monthPay = obj.monthPay;	
	  
	  monthTims = monthTims == null || monthTims == 'null'?'':monthTims;
	  monthPay = monthPay == null || monthPay == 'null'?'':monthPay;
	  
	  var rowArray = new Array();
	  var rowArray2 = new Array();
	  var rowCount = mygrid2.getRowsNum();
	  
	
	  
	  if(displayWeek){
	  	  rowArray.push('');
	  	  rowArray.push(pos);
	  	  rowArray.push(year);
	  	  rowArray.push(month);
	  	  
//		  rowArray.push(monthStr);
		  for(var j = 0;j<31;j++){
		  	 rowArray.push(obj.days[j].weakStr);
		  }
		  rowArray.push('');
		  rowArray.push('');
		  rowArray.push('');
		  
		  var row_id = rowCount+1; color ="#CCCCCC";
		  mygrid2.addRow(row_id,rowArray,-1);
		  mygrid2.setRowColor(row_id,color);
		  mygrid2.lockRow(row_id,true);
//			for(var j = 0;j<33;j++){
//				var cell = mygrid2.cells(row_id,j);
//				cell.setDisabled(false);
//			}			  
//		  for(var j = 0;j<31;j++){
//				var cell = mygrid2.cells(row_id,j+1);
//				var td = cell.cell;
//				console.log(cell);
////				td.className = td.className.replace(/cellselected/g,"");
//		  }	  
 
	  }
	      if(displayWeek){
		  	  rowArray2.push('');
		  	  rowArray2.push('');
		  	  rowArray2.push('');
		  	  rowArray2.push('');	
	      }else{
		  	  rowArray2.push(edit);
		  	  rowArray2.push(pos);
		  	  rowArray2.push(year);
		  	  rowArray2.push(month);	      	
	      	
	      }
		  for(var j = 0;j<31;j++){
		  	 rowArray2.push('');
		  }
		  rowArray2.push(monthTims);
		  rowArray2.push(monthPay);
		  

//		  var row_id =  mygrid2.getRowsNum()*1 + 1;
		   var row_id =   (new Date()).valueOf();
		 
		
		  mygrid2.addRow(row_id,rowArray2,-1);
		  mygrid2.setUserData(row_id,"grid1_rowId",grid1_rowId);


		 for(var j = 0;j<37;j++){
		 	
				var cell = mygrid2.cells(row_id,j);
				var td = cell.cell;
				
				if(j>3 && j <35){
					var data = obj.days[j-4];
					var disabled = data.disabled;
					disabled = disabled == null || disabled == 'null'?false:disabled;
					var adTimes = data.adTimes;
					var bgColor = data.rsColor;
					adTimes = adTimes == null || adTimes == 'null'?'':adTimes;
	
					td.navtype = 1;
					td.dayObj = data;
	
					cell.setBgColor(bgColor);
					cell.setValue(adTimes);
				}

				
				dhtmlxEvent(td,"click", mygrid2onKeypressClick);

				 
//				if(j>10){
//					td.readonly = true;
//					
//				}
				
//				cell.setDisabled(disabled);
//				function func(){};
//				td.removeEventListener('click',func);//Mozilla下，删除事件func  
//				 td.removeEventListener("click", function () {  //无效！
//    				return false;
//				}, false);  
				
//				console.log(cell.firstChild)
//				td.firstChild.disabled = true;
//				cell.setDisabled(disabled);
//				cell.setEditable(false);
//				td.disabled  = disabled;
				
			}
        
        
        

}






function getSpecCmd(cindex){
	
	function callfn(){
		var el = $("resourceSpecificId");
		var inputs = el.getElementsByTagName("option");
		var cindex = mygrid1.getColIndexById('apppos');
		var command = mygrid1.getCombo(cindex);
		command.clear();
		inputs = $A(inputs);
		inputs.each(function(ip){
				if(ip.value!=0){
						command.put(ip.value,el.options[ip.index].text);
				}else{
					command.put('',el.options[ip.index].text);
				}
			}
		);	
	}
	specific.makeSelectFromMap3(specific.obj,"resourceSpecificId","145",callfn,"");	

}


//function OnRowDblClicked(rowId,cellIndex){
//
//	
//		if(cellIndex == 1) {
//			displayCompagesTree2(1);
//		}
//		
//		if(cellIndex == 2) {
////            alert(parent.search_adver_cont())
//            parent.search_adver_cont(1);
////			parent.contentWindow.search_adver_cont();
//		}
//		
//		
//		if(cellIndex == 2) {
//			return false;
//		}else{
//			return true;
//		}
//		
//		
//}





/** keyboard navigation, only for popup calendars */


 function isEnableCellClick(el,ev,adLength,isResChangedOnEdit){

//    if(isUndefined(el)) return false;
//	if(el.navtype == "-1") return false;
	
	var dayObj = el.dayObj;
	if(dayObj == null) return false;
	var dayDate = ''+dayObj.dayDate;
	var rsTotalTime =  dayObj.rsTotalTime == null || dayObj.rsTotalTime == "" ? 0: dayObj.rsTotalTime; //资源标准
	var rt = true;
	var K =  (ev.type == "keydown" || ev.type == "keypress")? ev.keyCode : ev.which;
	var isKeypress = (ev.type == "keydown");
	var t;

  	var curValue = (el.innerHTML >0) ? el.innerHTML*1 : 0;
//  	el.innerHTML = (curValue + step) > 0 ? curValue + step :"&nbsp";

	

	if(ev.type == "keydown"  || ev.type == "keypress"){
		if(K >=96 && K<=105)  K = K-48;
		if(K == 32 ||K == 8 || K == 110) K = 48;
		
		t = String.fromCharCode(K);	
		if(dayObj.curSpecificed && dayObj.isResSpecificed && dayObj.isAdSpecificed && t >0 && isResChangedOnEdit)  rt =  false;
		if(dayObj.curSpecificed && dayObj.isResSpecificed && dayObj.isAdSpecificed && t >0 && isSpecifChangedOnEdit)  rt =  false;	
		
		if(dayObj.curSpecificed && !dayObj.isResSpecificed && dayObj.isAdSpecificed && t >1 && isSpecifChangedOnEdit)  rt =  false;	
			
		if(dayObj.curSpecificed && dayObj.isResSpecificed && dayObj.isAdSpecificed && t >1 )  rt =  false;
		if(dayObj.curSpecificed && dayObj.isResSpecificed && !dayObj.isAdSpecificed && t >0 )  rt =  false;
		if(dayObj.curSpecificed && !dayObj.isResSpecificed && !dayObj.isAdSpecificed && t >1 )  rt =  false;
	}else{

		t = (K == 1) ? 1 : -1;
		if(dayObj.curSpecificed && dayObj.isResSpecificed && dayObj.isAdSpecificed && (t + curValue) >0 && isResChangedOnEdit)  rt =  false;
		if(dayObj.curSpecificed && dayObj.isResSpecificed && dayObj.isAdSpecificed && (t + curValue) >0 && isSpecifChangedOnEdit)  rt =  false;
		
		if(dayObj.curSpecificed && !dayObj.isResSpecificed && dayObj.isAdSpecificed && (t + curValue) >1 && isSpecifChangedOnEdit)  rt =  false;
		
		if(dayObj.curSpecificed && dayObj.isResSpecificed && dayObj.isAdSpecificed &&  (t + curValue) >1 )  rt =  false;
		if(dayObj.curSpecificed && dayObj.isResSpecificed && !dayObj.isAdSpecificed && (t + curValue) >0  )  rt =  false;
		if(dayObj.curSpecificed && !dayObj.isResSpecificed && !dayObj.isAdSpecificed && (t + curValue) >1  )  rt =  false;
		

		
	}
	

	var changeTimes =0;//添加该变量是为了实现：就算该资源已经超时,但是没有超时权限的人依然可以编辑订单（占用的时间只能改小或不变）.
	var afterLeaveTimes =0;
	var groupLeaveTimes = 0;
	var oldValue = dayObj.adTimes*1;
	if(dayObj.dayShort ==null) dayObj.dayShort = 0;
	if(isKeypress){
		
		//alert(isResChangedOnEdit);
		//alert(adLength);
	  afterLeaveTimes = dayObj.rsReleave - adLength * (t*1 -oldValue*1);
	  groupLeaveTimes = dayObj.dayShort - adLength * (t*1 -oldValue*1);
	  
	  if(!isResChangedOnEdit){
	  	changeTimes = t*adLength -oldValue*dayObj.adLength;
	  	afterLeaveTimes = dayObj.rsReleave - (t*adLength -oldValue*dayObj.adLength);
	  	groupLeaveTimes = dayObj.dayShort - (t*adLength -oldValue*dayObj.adLength);
	  }
	  
	  if(isResChangedOnEdit){ 
	  	changeTimes = adLength * t;
	  	afterLeaveTimes = dayObj.rsReleave - adLength * t;
	  	groupLeaveTimes = dayObj.dayShort - adLength * t;
	   }
	  
	
	}else{
	    if(isResChangedOnEdit){
			  changeTimes = adLength * (t*1 + curValue*1)
			  afterLeaveTimes = dayObj.rsReleave - adLength * (t*1 + curValue*1);
			  groupLeaveTimes = dayObj.dayShort - adLength * (t*1 + curValue*1);			
		}else{
	 		  changeTimes = adLength * (t*1 + curValue*1)-dayObj.adLength*oldValue*1;
	  		  afterLeaveTimes = dayObj.rsReleave - adLength * (t*1 + curValue*1)+dayObj.adLength*oldValue*1;
	  		  groupLeaveTimes = dayObj.dayShort - adLength * (t*1 + curValue*1)+dayObj.adLength*oldValue*1;
		}
	  //afterLeaveTimes = dayObj.rsReleave - adLength * (t*1 + curValue*1-oldValue*1);
	}
	if(dayObj.dayShort ==0) groupLeaveTimes=100000;
	//alert(dayObj.rsReleave);
	//alert(afterLeaveTimes);
    if(tvNameParam=='fztv' ){
    	
    	var overTime= dayObj.rsAlert-0;
    	if(isFree) overTime=0;   
    	if(dayObj.isLimit && (afterLeaveTimes+overTime < 0||groupLeaveTimes<0)&& rsTotalTime > 0){ 
				//alert(getFormatDay(dayDate,"yyyy-mm-dd")+"的广告超时!");
				//注释了上面一行
				//下面两个if语句是为了实现根据个人选择来决定是否继续提示"广告超时".
				//isAlert,isConfirm这两个字段在最上面定义了.
				
//				if(broArrange.isAlert){
					if(!isKeypress){
						if(groupLeaveTimes<0){
							rt =  false;         
							alert("该时段组"+getFormatDay(dayDate,"yyyy-mm-dd")+"的广告可用时间只有"+(groupLeaveTimes+overTime+adLength*1)+"秒");
						}else if(afterLeaveTimes+overTime < 0&&groupLeaveTimes==100000){
							rt =  false;
							alert("该时段"+getFormatDay(dayDate,"yyyy-mm-dd")+"的广告可用时间只有"+(afterLeaveTimes+overTime+adLength*1)+"秒");
						}
					}else{
						if(groupLeaveTimes<0){
							rt =  false;         
						}else if(afterLeaveTimes+overTime < 0&&groupLeaveTimes==100000){
							rt =  false;
						}
					}

		}

    }else{
    	      	
    	  if(dayObj.isLimit && afterLeaveTimes< 0 && rsTotalTime > 0){
				//alert(getFormatDay(dayDate,"yyyy-mm-dd")+"的广告超时!");
				//注释了上面一行
				//下面两个if语句是为了实现根据个人选择来决定是否继续提示"广告超时".
				//isAlert,isConfirm这两个字段在最上面定义了.
				if(broArrange.isAlert){
//					alert("该时段"+getFormatDay(dayDate,"yyyy-mm-dd")+"的广告超时!");
					extjMessage("该时段"+getFormatDay(dayDate,"yyyy-mm-dd")+"的广告超时!"); 
				}   
				if(broArrange.isConfirm){
//					broArrange.isAlert = confirm("是否继续提示广告超时？");

					Ext.MessageBox.confirm('系统提示', '是否继续提示广告超时？', function(btn) {
			 			  if (btn == 'yes') {
			 				 broArrange.isAlert = true;
			 				 broArrange.isConfirm = false;
			              }else{
			              	 broArrange.isAlert = false;
			              	 broArrange.isConfirm = false;
			              }
			              rt =  false;	
					 });
//						

					
				}
		  
				if(!BroArrange.isTimeOutRight && changeTimes>0){
					 rt =  false;
				}
		}		
	}


		
	if(dayObj.isPublish) rt =  false;

	//没有维护广告时
	if(rsTotalTime == 0 && t >0) rt =  false;

//	alert(dayObj.isPublish) 
//	alert(t);
//	alert(dayObj.curSpecificed);
//	alert(dayObj.isResSpecificed);
//	alert(dayObj.isAdSpecificed);
//	alert(dayObj.adSpecific != null);
//	alert(dayObj.isSpecificed);
//	alert(dayObj.isLimit);
//	alert(dayObj.isPublish);
//	alert(afterLeaveTimes);
//	alert(rt);
	return rt;
}




function displayCompagesTree2(model){


//	if(cellIndex !=1) return false;

	 if(!compagesDiaWin){
	 	
	 	var closeBtn ={text: '关闭',handler: function(){compagesDiaWin.hide();}};
	 	var okBtn ={text: '确定',handler: function(){
			var resourceIds = carrierType.tree.getAllCheckedBranches("resourceId");
			
		
			var tree = carrierType.tree.dhtmlTree;
			paramFromUrl.resourceIds = resourceIds+'';

			var resources = new Array();
			for(var i = 0; i< resourceIds.length;i++){
				var obj ={};
				var itemId = 'resourceId' + resourceIds[i];
				obj.id =  resourceIds[i];
				obj.broTime = tree.getUserData(itemId,"broTime");
				obj.resourceName = tree.getUserData(itemId,"resourceName");
				obj.resourceMemo = tree.getUserData(itemId,"resourceMemo");
				resources.push(obj);
			}
			
			paramFromUrl.resources = resources;
			
	 		createGrid1(paramFromUrl);
	 		
	 		compagesDiaWin.hide();
	 	}};
	 	
	 	
		 compagesDiaWin = new Ext.Window({
			   title : '选择时段',
			   width : 400,
			   height : 500,
			   isTopContainer : true, 
			   modal : true,
			   resizable : false,
			   buttons: [closeBtn,okBtn],
			   contentEl :  $("carrierTypeTreebox2")
		  	}); 	
	 }
	 
	compagesDiaWin.show(this);
	
	if(model ==1){
		compagesDiaWin.buttons[0].show();
		compagesDiaWin.buttons[1].hide();
	}else{
		compagesDiaWin.buttons[0].hide();
		compagesDiaWin.buttons[1].show();
	}
	

		if(carrierType.tree==null){
		
			 carrierType.className  = "carrierType";
			 carrierType.IdPrefix 	= carrierType.className + "Id";
			 carrierType.treebox	= carrierType.className + "Treebox2";
			 carrierType.tree 		= new Tree(carrierType.treebox); 
  
			 getCarrierTypeTree(carrierType);  
			 
			 $("carrierTypeTreebox2").style.height = compagesDiaWin.getInnerHeight()+"px";;
		}
		if(model ==1){
			carrierType.tree.dhtmlTree.enableCheckBoxes(false);
//			carrierType.tree.dhtmlTree.enableCheckBoxes(0);
		}else{
			carrierType.tree.dhtmlTree.enableCheckBoxes(true);
			carrierType.tree.dhtmlTree.enableThreeStateCheckboxes(true);

			function doOnSelect(itemId){
		        if(itemId == "root") return false;
		        var isItemChecked = carrierType.tree.dhtmlTree.isItemChecked(itemId);
				carrierType.tree.dhtmlTree.setSubChecked(itemId,!isItemChecked);
			}
			carrierType.tree.dhtmlTree.setOnClickHandler(doOnSelect);//set function to call on dbl click
			
		}


		
		
//		if(carrierType.tree !=null && carrierType.tree.dhtmlTree.getXMLState() && changed){
//			 carrierType.tree.refreshTree();
//		}    


};

function getCarrierTypeTree(obj){
	var obj_tree = obj.tree.dhtmlTree;	
	obj_tree.setImagePath(ctxPath+"scripts/dhtml/2.6/dhtmlxTree/codebase/imgs/");

//	obj_tree.setImagePath(ctxPath+"scripts/dhtml/3.6/grid/codebase/imgs/");

	
	function doOnDblClick(itemId){
		compagesDiaWin.hide(this);
//		var isItemChecked = obj_tree.isItemChecked(itemId);
//		obj_tree.setSubChecked(itemId,!isItemChecked);
	}
	obj_tree.setOnDblClickHandler(doOnDblClick);

	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	var getxml = function(strXML){
		obj_tree.loadXMLString(strXML);   
		Ext.getBody().unmask(); 
	}   

	obj.obj.parentId = 0;
	obj.obj.nodeLevel = 999;
	obj.obj.orgId = orgId;
	obj.obj.memo = "3";
	obj.obj.enable = 1;
	obj.obj.fitterCarrier = 1;
	obj.obj.loginUser = loginUserName;
	
	obj.getTreeXMLByYear("carrierId","resourceId",order_year,getxml);

}


function buidArray(resourceIds,startDate,endDate,matterId,respecId,realPrice){

//	var func  = function(xml){
//			mygrid.clearAll();
//			mygrid.loadXMLString(xml);
//	}
	            

//	PublishArrangeManager.getAdversByResourceId(resourceId,publishDate,orgId,func);	
}


function getMonthInfos(param,func){
	
	param.isLock =false;
	param.resourceId =resourceId;
	param.specificValue =specificValue == null?'':specificValue;
	param.version =version;
	param.startDate =startDate;
	param.endDate = endDate;
	
	param.adLength = adLength;
	param.basePrice =basePrice;
	param.realPrice =realPrice;
	param.ageRate =ageRate;
	param.moneyBalance =moneyBalance;
	param.isTimeOutRight =tag_time_out;



	var getMonthsFun = function(objs){
    	
    	parent.backup_cur_info(null,null,objs);	
    	 
    }
 

	var orderDetail_obj = (new OrderDetail()).obj;
	orderDetail_obj.id = null;
	orderDetail_obj.publishStartDate = param.startDate;
	orderDetail_obj.publishEndDate = param.endDate;
	orderDetail_obj.resourceInfoId = param.resourceId;
	orderDetail_obj.specific.position = param.specificValue;
	orderDetail_obj.compagesId = 0;
	orderDetail_obj.version = param.version;
	orderDetail_obj.orderDetailStates = 3;
	orderDetail_obj.compagesId =999;

	orderDetail.getMonthInfos(orderDetail_obj,getMonthsFun);

};


function adver_win_close_fun(matterOj){
		var ed_cindex = mygrid1.getColIndexById('edit');
		var len_cindex = mygrid1.getColIndexById('len');
		var resourceIds = new Array();
		var count = mygrid1.selectedRows.length;
		for(var i = 0; i< count;i++){
			var row_id =  mygrid1.selectedRows[i].idd;
 			mygrid1.cells(row_id,ed_cindex).setValue(matterOj.edit);
			mygrid1.cells(row_id,len_cindex).setValue(matterOj.length);
			mygrid1.setUserData(row_id,"matterId",matterOj.id)
			var rsId = mygrid1.getUserData(row_id,"resourceId");
			resourceIds.push(rsId);
		}
		setBasePrices(resourceIds,matterOj);
		getAllResourceMonthInfos();
}


function setBasePrices(resourceIds,matterOj){
	
	var map = new HashMap();
	var adlen = matterOj.length;

	function callBakFun(objs){
				for(var i = 0;i<objs.length;i++){
					 var rsid = objs[i].value1;
					 var price =  objs[i].value4;
					 var key = rsid +''+ adlen;
					 map.put(key,price);
				}
		var count = mygrid1.selectedRows.length;		
		var stantPrice_cindex = mygrid1.getColIndexById('stantPrice');
		
		for(var i=0;i<count;i++){
			  var row_id = mygrid1.selectedRows[i].idd;
			  var rsId = mygrid1.getUserData(row_id,"resourceId");
			  var key = rsId +''+ adlen;
			  mygrid1.cells(row_id,stantPrice_cindex).setValue(map.get(key));
		}				
	};
	
	paramFromUrl.version = version;
	paramFromUrl.priceTypeId = priceTypeId;	
	paramFromUrl.adLength = adlen;
	paramFromUrl.resourceIds = resourceIds.join(',');

	var queryString = $H(paramFromUrl).toQueryString();
	resource.getResourcesByIds(queryString,callBakFun);			

}


function addGrid1NewRow(){

	var group_value = parent.build_more_paraArray.getTopToolbar().getComponent("fitter_cmd_id").getValue();

//	mygrid1.uncheckAll();

	var rowArray = new Array();
//	var row_id =  mygrid1.uid();
	var row_id =  (new Date()).valueOf();

//	alert(row_id)
	

	 
	var row_index =  mygrid1.getRowsNum()*1 ;
//	rowArray.push(row_index+1);
	for(var j = 0;j<10;j++){
		
		if(j == 4){
			rowArray.push(getFormatDay(startDate2,'y/m/d')); 
		}else if(j == 5){
		 	rowArray.push(getFormatDay(endDate,'y/m/d')); 
		}else{
			 rowArray.push(''); 
		}
		  	
	}
   
    
    var count = mygrid1.selectedRows.length;	

    
    if(count >0){
    	
    	var sel_id = mygrid1.getSelectedRowId(); 

		var rsId = mygrid1.getUserData(sel_id,"resourceId");
		var rs_pos =  mygrid1.getUserData(sel_id,"pos");
		var rs_cindex = mygrid1.getColIndexById('resourceName');
		var rs_txt = mygrid1.cells(sel_id,rs_cindex).getValue();
			
		var matterId = mygrid1.getUserData(sel_id,"matterId");
		var edit_cindex = mygrid1.getColIndexById('edit');
		var edit_txt = mygrid1.cells(sel_id,edit_cindex).getValue();
			
	   	if(group_value == 0){
			rowArray[rs_cindex] = rs_txt;
		}
		if(group_value == 1){
			rowArray[edit_cindex] = edit_txt;
		}	
		
		 mygrid1.addRow(row_id,rowArray,-1);
		   
	   	if(group_value == 0){
			mygrid1.setUserData(row_id,"resourceId",rsId);
			mygrid1.setUserData(row_id,"pos",rs_pos);
			mygrid1.cells(row_id,rs_cindex).setValue(rs_txt);
		}
		if(group_value == 1){
			mygrid1.setUserData(row_id,"matterId",matterId);
			mygrid1.cells(row_id,edit_cindex).setValue(edit_txt);
		}			

    }else{
    	  
    	   mygrid1.addRow(row_id,rowArray,-1);
    }
 
 
 
    mygrid1.clearSelection();
    
//    var row = mygrid1.getRowById(row_id);
    mygrid1.selectRowById(row_id);

//    mygrid1.setSelectedRow(rowId,mygrid1.selectedRows);
//    row.className += " rowselected2";
//    mygrid1.cells(row_id,0).setValue(1);
    

    
}


function getRowByUserData(grid,name,rowId1){
	var rowCount = grid.getRowsNum();
	var rowId2s = new Array();
	for(var i = 0;i<rowCount;i++){
		var _rowId2 = grid.getRowId(i)
		var _rowId1 = grid.getUserData(_rowId2,name);
		if(rowId1 == _rowId1){
			rowId2s.push(_rowId2);
		}
	}
	return rowId2s;
}

function removeGrid1NewRow(){
	var rows = mygrid1.selectedRows;
	for (var i = 0; i < rows.length; i++){
		var row = rows[i];
		var rowId1 = row.idd;
		var rowId2s =  getRowByUserData(mygrid2,"grid1_rowId",rowId1);
		
		for (var j = 0; j < rowId2s.length; j++){
			mygrid2.deleteRow(rowId2s[j]);
		}
	}
	mygrid1.deleteSelectedRows();
}



function grid1_groupBy(ColId)
{
	alert(ColId);
	mygrid1.unGroup();
	if(ColId == 0){
		alert(ColId);
		mygrid2.unGroup();
	}else{
		mygrid2.groupBy(ColId);
	}
	
	
	
////   mygrid.unGroup();
//   
//   // Group by column id, and hide the column
//   if (ColId == 1)
//   {   
////      mygrid.setColumnHidden(37,false);
//
//      mygrid.groupBy(1);
//
////      mygrid.setColumnHidden(1,true);
//      
////      mygrid.customGroupFormat = function(text, count) {
////          return "Column '" + text + "'; containing " + count + " related text segments";
////      };      
//   }
//   else
//   {   
////      mygrid.setColumnHidden(1,false);
//      
//      mygrid.groupBy(37);
//
////      mygrid.setColumnHidden(37,true);
//      
////      mygrid.customGroupFormat = function(text, count) {
////          return "Record " + text + "; containing " + count + " related text segments";
////      };      
//   }
   
}


function mygrid2onKeypressClick(ev){
		
		if(ev.button == 0){ev.keyCode = 49;}
		if(ev.button == 2){ev.keyCode = 48;}
		var keyCode = ev.keyCode;
		var ctrlKey = ev.ctrlKey;
		var shiftKey = ev.shiftKey;
		
		var start_cellIndex = 4;
		var end_cellIndex = 34;
		
		
		if(keyCode == 46 || keyCode == 32) keyCode = 48;
		
		var that = mygrid2; 
	
		that.setActive(true);
		
        if(ctrlKey || shiftKey) return false;
		
		var isEnableCell = false;
		var td = ev.target;
		
//		alert(td._cellIndex)
		
		if(!ev.button){
			if(td._cellIndex < start_cellIndex || td._cellIndex > end_cellIndex){
				 ev.cancelBubble=true;
				 return false;
			}
		}

		if(keyCode>= 48 && keyCode <= 58 ){
			
	
			var num =  String.fromCharCode(keyCode);
			
			var v = (num > 0) ? num : '';
			var adLength = 5;
			var ev2 ={type:"keydown",keyCode:keyCode};
			
			isEnableCell = isEnableCellClick(td,ev2,adLength,true);
			
//			alert(v)
			
			if(isEnableCell){
				
				var selectValue = 0;
				if(ev.button == 0){
					 selectValue = td.innerHTML  != "&nbsp;" && td.innerHTML  != "" ? td.innerHTML :0;
					v = selectValue*1 +1;
				}else if(ev.button == 2){
					 selectValue = td.innerHTML  != "&nbsp;" && td.innerHTML  != "" ? td.innerHTML :0;
					 if(selectValue>0){
					 	v = selectValue*1 - 1;
					 }else{
					 	v = "";
					 }
				}
				
				td.innerHTML = v == 0?"":v;
				

			}
			
//			var code = "k"+ev.keyCode+"_"+(ev.ctrlKey ? 1 : 0)+"_"+(ev.shiftKey ? 1 : 0);
			
		}
//		else{
//			return false;
//		}

}


	/**
	*	@desc: 
	*	@type: private
	*/

function getNextCell(acell, dir, i){
	
        var that = mygrid2; 
        
		acell=acell||that.cell;

		var arow = acell.parentNode;

		if (that._tabOrder){
			i=that._tabOrder[acell._cellIndex];

			if (typeof i != "undefined")
				if (i < 0)
					acell=that._nextRowCell(arow, dir, Math.abs(i)-1);
				else
					acell=arow.childNodes[i];
		} else {
			var i = acell._cellIndex+dir;

			if (i >= 4&&i < that._cCount-2){
				if (arow._childIndexes)
					i=arow._childIndexes[acell._cellIndex]+dir;
				acell=arow.childNodes[i];
			} else {

				acell=that._nextRowCell(arow, dir, (dir == 1 ? 4 : (that._cCount-3)));
			}
		}

		if (!acell){
			if ((dir == 1)&&that.tabEnd){
				that.tabEnd.focus();
				that.tabEnd.focus();
				that.setActive(false);
			}

			if ((dir == -1)&&that.tabStart){
				that.tabStart.focus();
				that.tabStart.focus();
				that.setActive(false);
			}
			return null;
		}

		//tab out

		// tab readonly
		if (acell.style.display != "none"
			&&(!that.smartTabOrder||!that.cells(acell.parentNode.idd, acell._cellIndex).isDisabled()))
			return acell;
		return getNextCell(acell, dir);
	// tab readonly

	}