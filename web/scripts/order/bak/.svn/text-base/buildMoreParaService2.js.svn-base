

var resource = new Resource();
var carrier = new Carrier();
var carrierType = new CarrierType();
var specific = new Specific();
var orderDetail = new OrderDetail();


 var winW;
 var winH;
 var orgId =1;
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
		startDate = getParamFromUrl(srcStr,"startDate"); 
		endDate = getParamFromUrl(srcStr,"endDate"); 		
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
			paramFromUrl.startDate = startDate;
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
		
		initGrid2();
		
//		createGrid1(paramFromUrl);
		
		Ext.getDoc().on("contextmenu",function(e){  
	    	e.stopEvent();//终止之前的事件响应，不然还会在页面上弹出讨厌的ie右键菜单  
	    }); 
	    
	    
//	    getBroArrangeStarEndDate(_app_params);


//		buidArray(resourceIds,startDate,endDate,matterId,respecId,realPrice);
  }
  
function createGrid1(param,caFun){

        var objs =  param.resources;
//	  	mygrid1.clearAll();
		var sb;
		sb = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		sb = sb + "<rows>";  
		var seq = Math.random();
		for(var i = 0;i<objs.length;i++){
			    seq++;
				sb = sb + "<row  id=\""+ seq +"\"" +">";
				sb = sb + "<cell><![CDATA["+ "0"  +"]]></cell>";
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
				mygrid1.uncheckAll();
		}
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

function initGrid1(){
	
	mygrid1 = new dhtmlXGridObject('gridbox1');
	mygrid1.selMultiRows = true;
	mygrid1.setImagePath(ctxPath+"image/grid/");
	var dialogcontent = $("dialogcontentDiv");
	var wd = $("gridbox1").offsetWidth;

	var flds = "序,广告位置,广告版本,长度,指定,开始时间,结束时间,刊例价,销售价,折扣,加收,次数,应收";
	mygrid1.setHeader(flds);
	var columnIds = "seq,resourceName,edit,len,apppos,start,end,stantPrice,realPrice,favace,appRae,sumTime,sumPay"
	mygrid1.setColumnIds(columnIds);
    var dw1 = 5; 
    var dw2 = 8; 	
	var dw3 = 6; 	

	var ss =[3,20,22,4,5,dw2,dw2,dw3,dw3,4,4,4,6];
	mygrid1.setInitWidthsP(ss.join(","));
//	mygrid1.setInitWidthsP("10,20,10,10,10,10,10,10,10");
	mygrid1.setColAlign("center,left,left,center,center,center,right,right,right,right,right,right,center,center")
	mygrid1.setColTypes("ch,ed,ed,ed,coro,calendar,calendar,edn,edn,edn,ed,ed,ed");
	
//    mygrid1.setSkin("broAaay");
	
	
	mygrid1.enableBlockSelection();
		
//	mygrid1.enableAlterCss("even","uneven");
	
	mygrid1.setOnRowDblClickedHandler(OnRowDblClicked);
	mygrid1.setOnRowSelectHandler(onRowSelectHandler,true);
		
//	mygrid1.setOnEditCellHandler(doOnEditCell);
	mygrid1.init();	 
	
	getSpecCmd(3);
	
	var z =  mygrid1.hdr.rows[1];
	var c = z.cells[0];
	mygrid1._in_header_master_checkbox(c,0,['',''])


	//add second row to header  //#rspan - include cell in rowspan //#cspan - include cell in colspan
//	var styles ="height:10px;,height:10px;color:red;,height:10px;color:red;,height:10px;color:red;,height:10px;,height:10px;,height:10px;,height:10px;,height:10px;,height:10px;,height:10px;,height:10px;,height:10px;,height:10px;,height:10px;"
//	mygrid1.attachHeader("#rspan,<div id='orderDetail_grid_title_flt1'>,<div id='orderDetail_grid_title_flt2'>,<div id='orderDetail_grid_title_flt3'>,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan",styles); //call this method if row was added after grid initialization
//	$("orderDetail_grid_title_flt1").appendChild(document.getElementById("edit_flt_box_1"));
//	$("orderDetail_grid_title_flt2").appendChild(document.getElementById("edit_flt_box_2"));
//	$("orderDetail_grid_title_flt3").appendChild(document.getElementById("edit_flt_box_3"));
	
	mygrid1.setSizes();
}



function setSelectGridChecked(){
	
//	var selectedRowsCount = mygrid1.selectedRows.length;
//	if(selectedRowsCount >0){
		for(var i=0;i<mygrid1.getRowsNum();i++){
			var rowId = mygrid1.getRowId(i);
			var cell = mygrid1.cells(rowId,0);
			var v = cell.getValue();
			if(v == 1){
				mygrid1.setSelectedRow(rowId,mygrid1.selectedRows);
//				mygrid1.getRowByIndex(i).className+= " rowselected2"	
//				mygrid1.selectedRows[i].className+= " rowselected2"	
			}
//			cell.setValue(0);
		}
		
		
		for(var i=0;i<mygrid1.selectedRows.length;i++){
			var rowId = mygrid1.selectedRows[i].idd;
			mygrid1.cells(rowId,0).setValue(1);
			mygrid1.selectedRows[i].className+= " rowselected2"	
		}

	
	var checkedIds_count = 0;
	var checkedIds = mygrid1.getCheckedRows(0);
	
	if(checkedIds !='') checkedIds_count = checkedIds.split(',').length;
	if(checkedIds_count == 0){
	    Ext.MessageBox.alert('系统提示','请选择需要处理的记录!',function(){});     
		return false;
	}else{
		return true;
	}
}

function onRowSelectHandler(rowId,cIndex){
	
//	alert(cIndex)

	for(var i=0;i<mygrid1.selectedRows.length;i++){
		 	mygrid1.selectedRows[i].className = mygrid1.selectedRows[i].className.replace(/rowselected2/g,"");
	}
	
	
	for(var i=0;i<mygrid1.selectedRows.length;i++){
		mygrid1.selectedRows[i].className+= " rowselected2"	
	}
	
//	console.log(mygrid1.getRowById(rowId).firstChild);
	

	
	
	
	
   
//	var fitter_tyep  = parent.build_more_paraArray.buttons[0].getValue();
//
//	if(fitter_tyep == 1){
//		for(var i=0; i< mygrid2.getRowsNum();i++){
//				mygrid2.setRowHidden(mygrid2.getRowId(i),false);
//		}
//		mygrid1.clearSelection();
//	}
//
//		
//	if(fitter_tyep == 2){
//		 var row_id = mygrid1.getSelectedId();
//
//		 var seq_cindex1 = mygrid1.getColIndexById('seq');
//		 var seq_cindex2 = mygrid2.getColIndexById('seq');
//		 var seq1 = mygrid1.cells(row_id,seq_cindex1).getValue()*1;
//
//		for(var i=0;i<mygrid1.selectedRows.length;i++){
//		 	mygrid1.selectedRows[i].className=mygrid1.selectedRows[i].className.replace(/rowselected2/g,"");
//		}
//		mygrid1.getRowById(row_id).className+= " rowselected2"		
//		
//
//		for(var i=0; i < mygrid2.getRowsNum();i++){
//			row_id  = mygrid2.getRowId(i);
//			var seq2 = mygrid2.cells(row_id,seq_cindex2).getValue()*1;
//			
//			if(seq1 == seq2){
//				mygrid2.setRowHidden(mygrid2.getRowId(i),false);
//			}else{
//				mygrid2.setRowHidden(mygrid2.getRowId(i),true);
//			}
//			
//		}
//	}

}




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
			 mygrid2.setColumnHidden(37,true);
//			 mygrid2.groupBy(37);
			
//			mygrid2.setRowspan(1, 1,rowCount);
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
		  mygrid2.addRow(row_id,rowArray,rowCount);
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
		  	  rowArray2.push('');
		  	  rowArray2.push(pos);
		  	  rowArray2.push(year);
		  	  rowArray2.push(month);	      	
	      	
	      }
	      
		  for(var j = 0;j<31;j++){
		  	 rowArray2.push('');
		  }
		  rowArray2.push(monthTims);
		  rowArray2.push(monthPay);
		  rowArray2.push(edit);

		  var row_id =  mygrid2.getRowsNum()*1 + 1;
		  mygrid2.addRow(row_id,rowArray2,row_id);
		  mygrid2.setUserData(row_id,"grid1_rowId",grid1_rowId);

		 for(var j = 0;j<31;j++){
				var cell = mygrid2.cells(row_id,j+4);
				var td = cell.cell;
				var data = obj.days[j];
				var disabled = data.disabled;
				disabled = disabled == null || disabled == 'null'?false:disabled;
				var adTimes = data.adTimes;
				var bgColor = data.rsColor;
				adTimes = adTimes == null || adTimes == 'null'?'':adTimes;
				
				td.navtype = 1;
				td.dayObj = data;
				
				cell.setBgColor(bgColor);
				cell.setValue(adTimes);
				
//				console.log(cell.firstChild)
				td.firstChild.disabled = true;
				cell.setDisabled(disabled);
//				cell.setEditable(false);
				td.disabled  = disabled;
				
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


function OnRowDblClicked(rowId,cellIndex){

	
		if(cellIndex == 1) {
			displayCompagesTree2(1);
		}
		
		if(cellIndex == 2) {
//            alert(parent.search_adver_cont())
            parent.search_adver_cont(1);
//			parent.contentWindow.search_adver_cont();
		}
		
		
		if(cellIndex == 2) {
			return false;
		}else{
			return true;
		}
		
		
}


function initGrid2(){
	
	mygrid2 = new dhtmlXGridObject('gridbox2');
//	mygrid2.selMultiRows = true;
	mygrid2.setImagePath(ctxPath+"image/grid/");
    mygrid2.enableMultiselect(true);
    
	var wd = $("gridbox2").offsetWidth;
	


	var flds = "序,段位,年,月,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,次,应收,版本";
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
	
	
	var dw = 2.6;  //2.6*31=80.6
	var dw2 = 3;  //3*2 = 6
	var dw3 = 9+4.8;  
//		80.6 + 6 + 5 = 91.6  8.4
	

	var ss =[3,4.8,3.5,2.5,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw2,dw2,0];
	mygrid2.setInitWidthsP(ss.join(","));
	mygrid2.setColAlign("center,center,centercenter,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,right,right,right")
	mygrid2.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
//	mygrid2.setOnEditCellHandler(doOnEditCell);
    mygrid2.setColSorting("int,str,int,int") ;
//    mygrid2.sortField(0,false);
//    mygrid2.setSortImgState(true,0,"ASC"); 
	mygrid2.setEditable(false);

 
// 	mygrid2.enableBlockSelection();
    mygrid2.setOnKeyPressed(mygrid2OnKeyPressed);
// 	mygrid2.setOnRowSelectHandler(OnRowSelectHandler2,true);
// 	mygrid2.setOnRowDblClickedHandler(OnRowDblClicked2);
//   function onrowSelected(){alert(1)};
// 	mygrid2.setOnRowSelectHandler(onrowSelected);
//	mygrid2.enableAlterCss("even","uneven");
//	mygrid2.setSizes();
//	mygrid2.setSkin("broAaay");
//    mygrid2.setSkin("clear");
	mygrid2.enableContextMenu(true);
	mygrid2.setOnLeftClick(OnLeftClick);
	mygrid2.setOnRightClick(OnLeftClick);
	mygrid2.init();	
	
	mygrid2.setColumnHidden(37,true);
//	mygrid2.enableRowspan(true);
//	mygrid2.enableRowspan();
	
//	 mygrid2.customGroupFormat = function(text, count) {
//       return "Record " + text + "; containing " + count + " related text segments";
//   };
	
	mygrid2.setSizes();

	
	
}
function mygrid2OnKeyPressed(keyCode,ctrlKey,shiftKey){
	var grid = this;
	var cellIndex = grid.getSelectedCellIndex();
	var rowId = grid.getSelectedId();
	var cell = grid.cells(rowId,cellIndex);
	var td = cell.cell;
//	var row = this.row;
	
	
//	console.log(cell)
	if((keyCode > 47 && keyCode < 58) ) {
		var num =  String.fromCharCode(keyCode);
		var v = (num > 0) ? num : '';
		var adLength = 5;
		var ev ={type:"keydown",keyCode:keyCode};
		var isEnableCell = isEnableCellClick(td,ev,adLength,true);
		if(isEnableCell){
			cell.setValue(v);
		}
	
		
		this.editStop();
		if (!this.callEvent("onTab",[true])) return true;
		var z = this._getNextCell(null, 1);
		if (z){
			this.selectCell(z.parentNode, z._cellIndex, (this.row != z.parentNode), false, true)
		};
		this._still_active=true;
		this._select_ifpossible();
		
//		grid.selectCell(z.parentNode,z._cellIndex,(this.row!=z.parentNode),false,true);
//		grid._key_events.k9_0_0.call(this);
	}
//	   this.editStop(); 
}


/** keyboard navigation, only for popup calendars */
//BroArrange.prototype._keyEvent = function(keyCode,ctrlKey,shiftKey) {
//	var el = this;
//	var K = keyCode;
////	if(K == 32) K = 48;
//	if(K >=96 && K<=105)  K = K-48;
//	if(K == 32 || K == 110 ) K = 48;
//	if((K > 47 && K < 58)||(!act && K == 8) || K == 110 ) {
////		var isEnableCell = isEnableCellClick(el,ev,adLength,isResChangedOnEdit)
////		if(broArrange.isEnableCellClick(el,ev)){
//		        broArrange.cellClick(el,ev);
//		        var step = 1;
//		        if(K == 8) step = -1; 
//		        var ne = broArrange.getNextDay(el,step);
//		        if(broArrange.isEnableCellClick(ne,ev)) broArrange.cellClick(ne,ev);
////		}
//	}
//	
//	if(act & (K == 37 ||K == 38 ||K == 39 ||K == 40 ) & !ev.ctrlKey ) {
//		if(K == 37) var step = -1; // KEY left
//		if(K == 38) var step = -31; // KEY up
//		if(K == 39) var step = 1; // KEY right
//		if(K == 40) var step = 31; // KEY down
//		if(broArrange.isEnableCellClick(el,ev)){
//			var ne = broArrange.getNextDay(el,step);
//			if(broArrange.isEnableCellClick(ne,ev)) broArrange.cellClick(ne,ev);			
//		}
//	}	
//
//
//	return BroArrange.stopEvent(ev);
//};	


//	if (this.editor) return false;
//	this.selectCell(this.row,this._cCount-1,false,false,true);
//	this._select_ifpossible();

function OnLeftClick(parentNode_idd,cellIndex,ev){
//    var cell = mygrid2.cells(parentNode_idd,cellIndex);
	var cell = mygrid2.cells(parentNode_idd,cellIndex);
	var td = cell.cell;
	var adLength = 5;
	var isResChangedOnEdit = false;
	var isEnableCell = isEnableCellClick(td,ev,adLength,isResChangedOnEdit);

	if(td.navtype == 1 && isEnableCell){
		var dayObj = td.dayObj;
		var v = cell.getValue();
		v = v>0?v:0;
		if(ev.button==0){
			v = v*1 + 1;
		}else{
			v = v*1 - 1;
			v = v>0?v:'';
			mygrid2.selectCell(td.parentNode,cellIndex,true)
		}
		cell.setValue(v);
	}
	
	
		
	
	
	
//	if(displayWeek){
//		
//	}else{
//		
//	}
}
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

function OnRowDblClicked2(rowIndex,cindex){
	return false;
}


function OnRowSelectHandler2(rowIndex,cindex){
//	mygrid2.editStop();

//     alert(mygrid2.selBasedOn)
//	 for(var i=0;i<mygrid2.selectedRows.length;i++){
//	 	mygrid2.selectedRows[i].className=mygrid2.selectedRows[i].className.replace(/rowselected/g,"");
//	}
//	mygrid1.getRowById(rowIndex).className+= " rowselected2"
   
}

function mygrid2OnKeyPressed2(ev,a){
            this.editStop();  
            //daoger_start  
            //modify action of enter key  
            //修改回车键事件，使得敲回车后选择状态或焦点下移  
            var rowInd = this.row.rowIndex;  
            if (rowInd != this.rowsCol.length && rowInd != this.obj.rows.length - 1) {  
                var nrow = this.obj._rows(rowInd);  
                if (nrow._sRow || nrow._rLoad) {  
                    return false;  
                }  
                this.selectCell(nrow, this.cell._cellIndex, true);  
                if (editeabled) {  
                    this.editCell();  
                }  
            } else {  
                if (this.pagingOn && (this.row != this.rowsCol[this.rowsCol.length - 1] || this.rowsBuffer[0].length > 0 || !this.recordsNoMore)) {  
                    this.changePage(this.currentPage + 1);  
                    this.selectCell(this.obj._rows(0), this.cell._cellIndex, true);  
                    if (editeabled) {  
                        this.editCell();  
                    }  
                }  
            }  
            //this.callEvent("onEnter", [this.row.idd, this.cell._cellIndex]);  
            //daoger_end  
            _isIE ? ev.returnValue = false : ev.preventDefault();  

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
	
//		for(var i=0;i<mygrid1.selectedRows.length;i++){
//			var row_id = mygrid1.selectedRows[i].idd;
////			var cell = mygrid1.cells(row_id,0).setValue(1);
//			  mygrid1.cells(row_id,ed_cindex).setValue(matterOj.edit);
//			  mygrid1.cells(row_id,len_cindex).setValue(matterOj.length);
//			  mygrid1.setUserData(row_id,"matterId",matterOj.id)
//			  var rsId = mygrid1.getUserData(row_id,"resourceId");
//			  resourceIds.push(rsId);
//		}	
		
		var count = mygrid1.getRowsNum();
		
		for(var i = 0; i< count;i++){
			var row_id = mygrid1.getRowId(i);
			var v = mygrid1.cells(row_id,0).getValue();
			if(v == 1){
 			  mygrid1.cells(row_id,ed_cindex).setValue(matterOj.edit);
			  mygrid1.cells(row_id,len_cindex).setValue(matterOj.length);
			  mygrid1.setUserData(row_id,"matterId",matterOj.id)
			  var rsId = mygrid1.getUserData(row_id,"resourceId");
			  resourceIds.push(rsId);
			}
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
//					 alert(key +"____________"+price)
					 map.put(key,price);
				}
				
		for(var i=0;i<mygrid1.selectedRows.length;i++){
//			  var len_cindex = mygrid1.getColIndexById('len');
			  var stantPrice_cindex = mygrid1.getColIndexById('stantPrice');
			  var row_id = mygrid1.selectedRows[i].idd;
			  var rsId = mygrid1.getUserData(row_id,"resourceId");
//			  var len =   mygrid1.cells(row_id,len_cindex).getValue;
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
	
	mygrid1.clearSelection();
	mygrid1.uncheckAll();
	
	
	var rowArray = new Array();
	var row_id =  Math.random();
	var row_index =  mygrid1.getRowsNum()*1 + 1;
	for(var j = 0;j<10;j++){
		  	 rowArray.push('');
	}
    mygrid1.addRow(row_id,rowArray,row_index);
    var row = mygrid1.getRowById(row_id);
    mygrid1.selectRow(row,mygrid1.selectedRows);
//    mygrid1.setSelectedRow(rowId,mygrid1.selectedRows);
    row.className += " rowselected2";
    mygrid1.cells(row_id,0).setValue(1);
    

    
}

function removeGrid1NewRow(){
	
	var checkedIds = mygrid1.getCheckedRows(0).split(',');
	var count = checkedIds.length;
	for(var i = 0; i<  count;i++){
		var row_id = checkedIds[i];
		mygrid1.deleteRow(row_id);
	}

//		var count = mygrid1.getRowsNum();;
//		for(var i = 0; i<  count;i++){
//			var row_id = mygrid1.getRowId(i);
//			var v = mygrid1.cells(row_id,0).getValue();
//			alert(row_id+'_____'+v)
//			
//			if(v == 1){
//				
//			}
//		}	
//		
//		
//		mygrid1.deleteRow(row_id);
		
}


function grid1_groupBy(ColId)
{
	
	var mygrid = mygrid2;
	
//   mygrid.unGroup();
   
   // Group by column id, and hide the column
   if (ColId == 1)
   {   
//      mygrid.setColumnHidden(37,false);

      mygrid.groupBy(1);

//      mygrid.setColumnHidden(1,true);
      
//      mygrid.customGroupFormat = function(text, count) {
//          return "Column '" + text + "'; containing " + count + " related text segments";
//      };      
   }
   else
   {   
//      mygrid.setColumnHidden(1,false);
      
      mygrid.groupBy(37);

//      mygrid.setColumnHidden(37,true);
      
//      mygrid.customGroupFormat = function(text, count) {
//          return "Record " + text + "; containing " + count + " related text segments";
//      };      
   }
   
}


