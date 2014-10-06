

var resource = new Resource();
var carrier = new Carrier();
var carrierType = new CarrierType();
var specific = new Specific();
var orderDetail = new OrderDetail();
var orderCategory = new OrderCategory();

var matter_fin = new Matter();
var industry_fin = new Industry();
var customer_fin = new Customer();
var matterType = new MatterType();
var myUtils = new MyUtils();


var search_adver_win;

 var winW;
 var winH;
 var orgId =1;
 var mygrid;
 var mygrid1;
 var mygrid2;
 var compagesDiaWin;
 var displayWeek = false;
 var copy_grid1_rowid = -1;
 

 
 callOnLoad(init);	

 
  
	function init(){
		
	

		var srcStr = decodeURI(window.location.href);
		ctxPath = _app_params.ctxPath;	
		
		tvNameParam =  _app_params.sysParam.tvNameParam;	
		loginUserName =  _app_params.user.username;
		loginUserFullName =  _app_params.user.fullName;
		loginUserId =  _app_params.user.id;
		config_orderModCategoryParam =  _app_params.config_orderModCategoryParam;
		
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
		
		orderCategoryMain = getParamFromUrl(srcStr,"orderCategoryMain");
		signUser = getParamFromUrl(srcStr,"signUser");
		
		
		if(orderCategoryMain != 0){
			parent.document.getElementById("paymoney_for_paraArray").readOnly = true;
		}else{
			parent.document.getElementById("paymoney_for_paraArray").readOnly = false;
		}
		
		paramFromUrl ={};
		
			paramFromUrl.orgId = orgId;
			paramFromUrl.isLock = false;
			paramFromUrl.version = version;
			paramFromUrl.orderCategoryMain = orderCategoryMain;	
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
			
			

	
		resetHeigth();
		initGrid1();
		initGrid2();
		resetHeigth();
		
		addGrid1NewRow();
  }
  
 
function createGrid1(param,caFun){
	 var objs =  param.resources;
	 var rs_cindex = mygrid1.getColIndexById('resourceName');

	 for(var i = 0;i<objs.length;i++){
	 	 var row_id = addGrid1NewRow();
	 	 var  resourceName = objs[i].broTime +' '+ objs[i].resourceMemo  +' '+ objs[i].resourceName;
		 mygrid1.cells(row_id,rs_cindex).setValue(resourceName);
		 mygrid1.setUserData(row_id,"resourceId",objs[i].id);
		 mygrid1.setUserData(row_id,"pos",objs[i].resourceMemo);
	 }
}

function createGrid1_bak(param,caFun){
 
        var objs =  param.resources;

//       <?xml version="1.0"?>
//	  	mygrid1.clearAll();
		var sb;
		sb = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
//		sb =  "<?xml version=\"1.0\"?>";
		sb = sb + "<rows>";  
//		var seq = Math.random();
		for(var i = 0;i<objs.length;i++){
//			    var row_id =  mygrid1.uid(); 
			    var row_id =   (new Date()).valueOf();
			    alert(row_id)
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
 



function reset_grid1_sumPay(rowId,cellIndex,wasChanged,calculateauto){

					var sumTime_cindex = mygrid1.getColIndexById('sumTime');
					var sumPay_cindex = mygrid1.getColIndexById('sumPay');
					var stantPrice_cindex = mygrid1.getColIndexById('stantPrice');
					var realPrice_cindex = mygrid1.getColIndexById('realPrice');
					
					var favace_cindex = mygrid1.getColIndexById('favace');
					var appRae_cindex = mygrid1.getColIndexById('appRae');

					
					var  sumTime = mygrid1.cells(rowId,sumTime_cindex).getValue();
					var  stantPrice = mygrid1.cells(rowId,stantPrice_cindex).getValue();
					var  relpay = mygrid1.cells(rowId,realPrice_cindex).getValue();
					
					var  favace = mygrid1.cells(rowId,favace_cindex).getValue();
					var  appRae = mygrid1.cells(rowId,appRae_cindex).getValue();
					
					
//					var paymoney_for_paraArray = $("paymoney_for_paraArray");
					
//					if(cellIndex== favace_cindex || cellIndex== appRae_cindex){

			
					
						favace = favace > 0 ? favace/100:favace;
						appRae = appRae > 0 ? appRae/100:appRae;
						favace = favace ==""?1:favace;
						appRae = appRae ==""?0:appRae;
						relpay = stantPrice*favace*(1+appRae*1);	
					

//					}
					
			       
			        
					sumTime = sumTime ==""?0:sumTime;	
					relpay = relpay ==""?0:relpay;

					var sum_pay = sumTime * relpay;
					relpay = relpay ==0?"":relpay;
					sum_pay = sum_pay ==0?"":sum_pay;
				
				
			
					if(orderCategoryMain != 0){
						relpay = (calculateauto == 1)?relpay:"";
						sum_pay = (calculateauto == 1)?sum_pay:"";
						mygrid1.cells(rowId,realPrice_cindex).setValue(relpay);
						mygrid1.cells(rowId,sumPay_cindex).setValue(sum_pay); 

						var rowId2s =  getRowByUserData(mygrid2,"grid1_rowId",rowId);
						for (var j = 0; j < rowId2s.length; j++){
							var td_time = mygrid2.cells(rowId2s[j],35).cell;
							var td_month_pay = mygrid2.cells(rowId2s[j],36).cell;
							var times = td_time.innerHTML;
							times = times ==""?"0":times;
							relpay = relpay ==""?0:relpay;
							var month_pay =  times * relpay;
							month_pay = month_pay ==0?"":month_pay;
							td_month_pay.innerHTML = (calculateauto == 1)?month_pay:"";
						}						 
						 
					}else{
						 mygrid1.cells(rowId,realPrice_cindex).setValue('');
						 mygrid1.cells(rowId,sumPay_cindex).setValue('');
						 var rowId2s =  getRowByUserData(mygrid2,"grid1_rowId",rowId);
						 for (var j = 0; j < rowId2s.length; j++){
							var td_month_pay = mygrid2.cells(rowId2s[j],36).cell;
							td_month_pay.innerHTML = "";
						 }
					}
					
				
			
		if(orderCategoryMain != 0){
			var sum_paymoney= 0;			
			for (var j = 0; j <mygrid1.getRowsNum(); j++){	
				var v = mygrid1.cells2(j,sumPay_cindex).getValue(); 
				v = v ==""?0:v;
				sum_paymoney = sum_paymoney +v*1;
			}		
			parent.document.getElementById("paymoney_for_paraArray").value = sum_paymoney;

		}			
	
									 
}

function build_grid_menuStr(){
	 	var sb;
	sb = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	sb = sb + "<menu id=\"0\">"
	sb = sb + "<item text=\"设置段位\" img=\"red.gif\"  id=\"btnChoseResource\"/>";
	sb = sb + "<item text=\"设置版本\" img=\"green.gif\"  id=\"btnChoseEdit\"/>";
	sb = sb + "<item text=\"设置指定\" img=\"green.gif\"  id=\"btnChoseApp\"/>";
	sb = sb + "<item text=\"设置排期\" img=\"green.gif\"  id=\"btnChoseArray\"/>";
	sb = sb + "<item text=\"复制\" img=\"green.gif\"  id=\"copy\"/>";
	sb = sb + "<item text=\"粘贴\" img=\"green.gif\"  id=\"post\">";
		sb = sb + "<item text=\"段位\" img=\"green.gif\"  id=\"post_pos\"/>";
		sb = sb + "<item text=\"版本\" img=\"green.gif\"  id=\"post_edit\"/>";
		sb = sb + "<item text=\"排期\" img=\"green.gif\"  id=\"post_arr\"/>";
		sb = sb + "<item text=\"所以\" img=\"green.gif\"  id=\"post_all\"/>";
	sb = sb + "</item>";
	
	sb = sb + "<item text=\"复制并新添\" img=\"green.gif\"  id=\"copy_post\"/>";	
	
	sb = sb + "</menu>";
	return sb;
}
	
 function initGrid1(){
 	
 	function onButtonClick(menuitemId, type) {
 		
 		
	    var data = mygrid1.contextID.split("_");

	    if(menuitemId =='copy'|| menuitemId =='copy_post'){
	    	 if(mygrid1.selectedRows.length >1) {alert('只能选择一条记录！');return false;}
	    	 copy_grid1_rowid = data[0];
	    }
	
 		 if(menuitemId =='btnChoseResource'){    
 		 	displayCompagesTree2(1);
 		 }
	 	 if(menuitemId =='btnChoseEdit'){    
 		 	parent.search_adver_cont(1);
 		 }
 		  if(menuitemId =='btnChoseApp'){    
// 		 	displayCompagesTree2(1);
 		 }
 		 if(menuitemId =='btnChoseArray'){    
 		 	setAutoBroArray();
// 		 	displayCompagesTree2(1);
 		 }    
	    
	    
	    
	    if(menuitemId =='post_pos' || menuitemId =='post_edit' || menuitemId =='post_arr' || menuitemId =='post_all' || menuitemId =='copy_post'){
	    	
	    	if(copy_grid1_rowid ==-1){alert('请选择要复制记录！');return false;}	
	    	
	    	for(var i = 0;i<mygrid1.selectedRows.length;i++){
	    		var stantPrice_cindex = mygrid1.getColIndexById('stantPrice');

	    		var row_id = menuitemId =='copy_post'?addGrid1NewRow():mygrid1.selectedRows[i].idd;
	    		
	    		if(copy_grid1_rowid != row_id){
	    			
					if(menuitemId =='post_pos'){
		    	 		var rs_cindex = mygrid1.getColIndexById('resourceName');
		    	 		var len_cindex = mygrid1.getColIndexById('len');
		    	  	 	var rs_txt = mygrid1.cells(copy_grid1_rowid,rs_cindex).getValue();
		    	  	 	var len_txt = mygrid1.cells(copy_grid1_rowid,len_cindex).getValue();
		    	  	 	var resId = mygrid1.getUserData(copy_grid1_rowid,"resourceId");
		    	  	 	var pos = mygrid1.getUserData(copy_grid1_rowid,"pos");
		    	  	 	var stantPrice = mygrid1.cells(copy_grid1_rowid,stantPrice_cindex).getValue();
		    	  	 	
		    	  	 	mygrid1.cells(row_id,rs_cindex).setValue(rs_txt);
		    	  	 	if(len_txt>0){
		    	  	 		mygrid1.cells(row_id,stantPrice_cindex).setValue(stantPrice);
		    	  	 	}
		    	  	 	mygrid1.setUserData(row_id,"resourceId",resId);
		    	  	 	mygrid1.setUserData(row_id,"pos",pos);
		    	  	 	
		    	  	 	reset_mygrid2_row(row_id);
		    	  	}
		    	 	if( menuitemId =='post_edit' ){
						var edit_cindex = mygrid1.getColIndexById('edit');
						var len_cindex = mygrid1.getColIndexById('len');
						var matterId = mygrid1.getUserData(copy_grid1_rowid,"matterId");
						var edit_txt = mygrid1.cells(copy_grid1_rowid,edit_cindex).getValue();
						var len_txt = mygrid1.cells(copy_grid1_rowid,len_cindex).getValue();
		    	  	 	var stantPrice = mygrid1.cells(copy_grid1_rowid,stantPrice_cindex).getValue();
		    	  	 	
	
		    	  	 	
		    	  	 	mygrid1.cells(row_id,edit_cindex).setValue(edit_txt);
		    	  	 	mygrid1.cells(row_id,len_cindex).setValue(len_txt);
		    	  	 	mygrid1.cells(row_id,stantPrice_cindex).setValue(stantPrice);
						mygrid1.setUserData(row_id,"matterId",matterId);
						
						reset_mygrid2_row(row_id);
				
		    	  	}
		    	 	if(menuitemId =='post_arr'){
		    	    	reset_mygrid2_row(row_id,copy_grid1_rowid);
		    	  	}
		    	 	if(menuitemId =='post_all'){
		    	 		var apppos_cindex = mygrid1.getColIndexById('apppos');
		    	 		var apppo_id = mygrid1.cells(copy_grid1_rowid,apppos_cindex).getValue();
		    	 		
		    	    	mygrid1.copyRowContent(copy_grid1_rowid,row_id);
		    	    	
		    	    	var matterId = mygrid1.getUserData(copy_grid1_rowid,"matterId");
		    	    	var resourceId = mygrid1.getUserData(copy_grid1_rowid,"resourceId");
		    	    	var pos = mygrid1.getUserData(copy_grid1_rowid,"pos");
		    	    	
		    	    	mygrid1.setUserData(row_id,"matterId",matterId);
		    	    	mygrid1.setUserData(row_id,"resourceId",resourceId);
		    	    	mygrid1.setUserData(row_id,"pos",pos);
		    	    	if(apppo_id > 0 ){
		    	    		mygrid1.cells(row_id,apppos_cindex).setValue(0);
		    	    	}
		    	    	
		    	    	
		   	    	
		    	    	reset_mygrid2_row(row_id,copy_grid1_rowid);
		    	  	}	
		    	  	
		    	 	if(menuitemId =='copy_post'){

		    	 		var apppos_cindex = mygrid1.getColIndexById('apppos');
		    	 		var apppo_id = mygrid1.cells(copy_grid1_rowid,apppos_cindex).getValue();
		    	 		
		    	    	mygrid1.copyRowContent(copy_grid1_rowid,row_id);
		    	    	
		    	    	var matterId = mygrid1.getUserData(copy_grid1_rowid,"matterId");
		    	    	var resourceId = mygrid1.getUserData(copy_grid1_rowid,"resourceId");
		    	    	var pos = mygrid1.getUserData(copy_grid1_rowid,"pos");
		    	    	
		    	    	mygrid1.setUserData(row_id,"matterId",matterId);
		    	    	mygrid1.setUserData(row_id,"resourceId",resourceId);
		    	    	mygrid1.setUserData(row_id,"pos",pos);
		    	    	if(apppo_id > 0 ){
		    	    		mygrid1.cells(row_id,apppos_cindex).setValue(0);
		    	    	}
		    	    	
		    	    	
		   	    	
		    	    	reset_mygrid2_row(row_id,copy_grid1_rowid);
		    	  	}		    	  	
		    	  	    	  	
	    		}
	    	} 
	    	
	    	copy_grid1_rowid = -1;
	    }	    
	    
	    mygrid1.setRowTextStyle(data[0], "color:" + menuitemId.split("_")[1]);
	    return true;
	}


	
	menu = new dhtmlXMenuObject("", "dhx_web");
	menu.setIconsPath(ctxPath+"scripts/dhtml/2.6/dhtmlxGrid/codebase/imgs/");
	menu.renderAsContextMenu();
//	menu.attachEvent("onClick", onButtonClick)
	menu.loadXMLString(build_grid_menuStr());  
	menu.attachEvent("onClick", onButtonClick)	

 	var wd = $("gridbox1").offsetWidth;
	mygrid1 = new dhtmlXGridObject('gridbox1');
	mygrid1.enableContextMenu(menu);
	
	
	function doOnRowSelected(rid,cellIndex){
		mygrid2.unmarkAll();
		mygrid2._HideSelection();
	}
	
	
	
	
	
	function OnEditCell(state,rowId,cellIndex){
	
		if(this.getColumnId(cellIndex)=='sumTime' || this.getColumnId(cellIndex)=='sumPay'){
			return false;
		}else{
//			columnIds = "resourceName,edit,len,apppos,start,end,stantPrice,realPrice,favace,appRae,sumTime,sumPay"
			var wasChanged = this.cells(rowId,cellIndex).wasChanged();
			


			if(this.getColumnId(cellIndex)=='resourceName'){
				displayCompagesTree2(1,wasChanged);return false; 
			}else if(this.getColumnId(cellIndex)=='edit'){
				 parent.search_adver_cont(1,wasChanged);return false;  
			}else if(this.getColumnId(cellIndex)=='realPrice'){
				if(orderCategoryMain == 0) return false;
				if(state == 2) reset_grid1_sumPay(rowId,cellIndex,wasChanged,calculateauto);return true;
			}else if(this.getColumnId(cellIndex)=='stantPrice'){
				if(state == 2) reset_grid1_sumPay(rowId,cellIndex,wasChanged,calculateauto);return true;
			}else if(this.getColumnId(cellIndex)=='favace'){
				if(orderCategoryMain == 0) return false;
				if(state == 2) reset_grid1_sumPay(rowId,cellIndex,wasChanged,calculateauto);return true;
			}else if(this.getColumnId(cellIndex)=='appRae'){
				if(orderCategoryMain == 0) return false;
				if(state == 2) reset_grid1_sumPay(rowId,cellIndex,wasChanged,calculateauto);return true;
			}else if(this.getColumnId(cellIndex)=='start' || this.getColumnId(cellIndex)=='end'){
				if(state == 2 && wasChanged)reset_mygrid2_row(rowId);return true;	
			}else if(this.getColumnId(cellIndex)=='ordersubcate'){
				if(state == 2 && wasChanged){
//					var c_index = this.getColIndexById('ordersubcate');
					var command = this.getCombo(cellIndex);
					var calculateauto_key = this.cells(rowId,cellIndex).getValue();
					var calculateauto = command.calculateauto[calculateauto_key];
					 reset_grid1_sumPay(rowId,cellIndex,wasChanged,calculateauto);return true;
				}
			}

			else{
				return true;
			}
			
		}
		
		
	}
	
	function onBlockSelected(){
		this.setActive(true);
		for (var i=this._selectionArea.LeftTopRow; i<=this._selectionArea.RightBottomRow; i++) {
			for (var j=this._selectionArea.LeftTopCol; j<=this._selectionArea.RightBottomCol; j++) {
                var cell =  this.cells2(i,j);
                this.selectRow(i, false, true, false);
			}
		}
		this._HideSelection();
	}	
	
		
	mygrid1.setImagePath(ctxPath+"scripts/dhtml/2.6/dhtmlxGrid/codebase/imgs/");
	mygrid1.setHeader("广告位置,广告版本,长度,指定,开始时间,结束时间,类别,刊例价,销售价,折扣,加收,次数,应收");
	var columnIds = "resourceName,edit,len,apppos,start,end,ordersubcate,stantPrice,realPrice,favace,appRae,sumTime,sumPay"
	mygrid1.setColumnIds(columnIds);
	var ss =[wd*0.17,wd*0.2,wd*0.04,wd*0.05,wd*0.08,wd*0.08,wd*0.08,wd*0.06,wd*0.06,wd*0.04,wd*0.04,wd*0.04,wd*0.05];
	mygrid1.setInitWidths(ss.join(","));

	mygrid1.setColAlign("left,left,center,center,center,center,center,center,right,right,right,right,right");
	mygrid1.setColTypes("ed,ed,ed,coro,calendar,calendar,coro,ed,ed,ed,ed,ed,ed");
	mygrid1.setColSorting("str,str,str");
	
	mygrid1.enableMultiselect(true); // false by default
	mygrid1.enableBlockSelection(true); // true|false 
	
	mygrid1.attachEvent("onRowSelect", doOnRowSelected);
	mygrid1.attachEvent("OnEditCell", OnEditCell);
	mygrid1.attachEvent("onBlockSelected", onBlockSelected);
	
	mygrid1.enableAlterCss("even","uneven");
	
	getSpecCmd(3);
	getSpecCmd(6);
	
	mygrid1.init();

 }

function initGrid2(){
	
	function onBlockSelected(cell){
		this.unmarkAll();
		this.setActive(true);
	}
	
	function mygrid2OnKeyPressed(keyCode,ctrlKey,shiftKey,ev){
		
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
	    			cell._cellIndex = cindex;
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
	}	
	
	
	
	var wd = $("gridbox2").offsetWidth;
	mygrid2 = new dhtmlXGridObject('gridbox2');
	mygrid2.selMultiRows = true;
//	mygrid2.setImagePath(ctxPath+"image/grid/");
	mygrid2.setImagePath(ctxPath+"scripts/dhtml/2.6/dhtmlxGrid/codebase/imgs/");
    mygrid2.enableMultiselect(true);
    
	var wd = $("gridbox2").offsetWidth;
	var flds = "版本,段位,年,月,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,次,应收,grid1_id";
	mygrid2.setHeader(flds);

	var columnIds = "seq,pos,year,month," 
					+"dayTimes[1],dayTimes[2],dayTimes[3],dayTimes[4],dayTimes[5],"
					+"dayTimes[6],dayTimes[7],dayTimes[8],dayTimes[9],dayTimes[10],"
					+"dayTimes[11],dayTimes[12],dayTimes[13],dayTimes[14],dayTimes[15],"
					+"dayTimes[16],dayTimes[17],dayTimes[18],dayTimes[19],dayTimes[20],"
					+"dayTimes[21],dayTimes[22],dayTimes[23],dayTimes[24],dayTimes[25],"
					+"dayTimes[26],dayTimes[27],dayTimes[28],dayTimes[29],dayTimes[30],"
					+"times,realPrice,edit,grid1_id";
	mygrid2.setColumnIds(columnIds);
	
	
	var dw = wd*0.026;  //2.6*31=80.6
	var dw2 = wd*0.03;  //3*2 = 6
//	var dw3 = 9+4.8;  
//		80.6 + 6 + 5 = 91.6  8.4
	

//	var ss =[3,4.8,3.5,2.5,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw2,dw2,0];
	
	var ss =[wd*0.03,wd*0.048,wd*0.035,wd*0.025,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw2,dw2,150];
	mygrid2.setInitWidths(ss.join(","));
	mygrid2.setColAlign("center,center,centercenter,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,right,right,left")
	mygrid2.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
//	mygrid2.setOnEditCellHandler(doOnEditCell);
    mygrid2.setColSorting("str,str,str,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int,int") ;
//    mygrid2.sortField(37,false);
    
//    mygrid2.sortRows(37,"str","des");
    
//    mygrid2.setSortImgState(true,37,"ASC"); 
//	mygrid2.setEditable(true);

//	mygrid2.enableRowspan(true);
//	mygrid2.enableColSpan(true);
	mygrid2.enableMarkedCells(true); // true|false 
//	mygrid2.enableMercyDrag(true); // true|false 
	mygrid2.enableBlockSelection(true); // true|false 
//	mygrid2.enableLightMouseNavigation(true); // true|false 
	mygrid2.enableStableSorting(true); // true|false 
	mygrid2.sortRows(37,"int","asc");    // sort by the sibling column
	mygrid2.setColumnHidden(37,true);

    var ss_header = "BORDER-RIGHT: #000000 2px solid; 1px solid;  BORDER-BOTTOM: #000000 2px solid;  BORDER-TOP: #000000 2px solid;TEXT-ALIGN: center;"
    var ss_grid = "BORDER-RIGHT: #000000 1px solid; 1px solid; BORDER-BOTTOM: #000000 1px solid; TEXT-ALIGN: center;"
    var ss_selCell ="-moz-opacity: 0.5;filter: alpha(opacity = 50);background-color:yellow;opacity:0.5;border: 1px dotted black;"
//      var ss_selCell ="BORDER-RIGHT: #FF0000 1px solid;BORDER-TOP: #FF0000 1px solid;BORDER-LEFT: #FF0000 2px solid; BORDER-BOTTOM: #FF0000 2px solid; background-color:white;";
     var ss_mark ="BORDER-RIGHT: #FF0000 1px solid;BORDER-TOP: #FF0000 1px solid;BORDER-LEFT: #FF0000 2px solid; BORDER-BOTTOM: #FF0000 2px solid;";
	mygrid2.setStyle(ss_header,ss_grid,ss_selCell,ss_mark);



	mygrid2.attachEvent("onBlockSelected", onBlockSelected);
	mygrid2.attachEvent("onBeforeSelect",function(rowId,psid){ return false }); 	
	
	

	mygrid2.customGroupFormat = function(text, count) {
//		return false
	    return "Grouped by " + text + ", there are " + count + " related records";
	};
	
 	
    mygrid2.attachEvent("onKeyPress", mygrid2OnKeyPressed);
    mygrid2.attachEvent("onRightClick", onRightClick);
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




function setSelectGridChecked(){
	var selectedRowsCount = mygrid1.selectedRows.length;
	if(selectedRowsCount == 0){
	    Ext.MessageBox.alert('系统提示','请选择需要处理的记录!',function(){});     
		return false;
	}else{
		return true;
	}
}



function getAllResourceMonthInfos(){
    mygrid2.clearAll();
	var rowCount = mygrid1.getRowsNum();

	for(var i = 0;i<rowCount;i++){
		var row_id = mygrid1.getRowId(i);
		getOneResourceMonthInfos(row_id,0,true,rowCount,i,[]);
	}	
}

	
		 		

function getOneResourceMonthInfos(row_id,cindex,isMore,rowCount,rowIndex,bak_arr){
   

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
	startDate = (startDate+'').substring(0,6)+"01";
	var endDate = getFormatDay(mygrid1.cells(row_id,e_cindex).getValue(),'ymd')*1;
	var edit = mygrid1.cells(row_id,edit_cindex).getValue();
	
	
	
	
//	 mygrid1.editStop();

//	if(!isMore){
//		for(var i=0;i<mygrid1.selectedRows.length;i++){
//		 	mygrid1.selectedRows[i].className=mygrid1.selectedRows[i].className.replace(/rowselected2/g,"");
//		}
//		mygrid1.getRowById(row_id).className+= " rowselected2"		
//	}


	
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
//		if(!isMore) mygrid2.clearAll();

		for(var i = 0;i<objs.length;i++){
			objs[i].grid1_rowId = row_id;
	  		objs[i].pos = pos;
	  		objs[i].edit = edit;
	  		objs[i].matterId = matterId;
	  			
//	  		if(matterId > 0){
	  			objs[i].bak_arr = bak_arr;
	  			createMonthRow(objs[i]);
//	  		}
//			  if((rowCount-1) == rowIndex && i == objs.length -1 ) mygrid2.groupBy(1);
		}
		
		mygrid2.sortRows(37,"int","asc");    // sort by the sibling column
		
		if((rowCount-1) == rowIndex){
//			mygrid2.groupBy(37);
			 mygrid2.setColumnHidden(37,true);
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
		  rowArray2.push(grid1_rowId);
		  

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
        
	        if(obj.bak_arr.length>0){
	        	var bak_arr = obj.bak_arr;
	        	for(var i = 0;i< bak_arr.length;i++){
	        		for(var j = 0;j<31;j++){
		        		var cellIndex = j+4;
		        		var values = bak_arr[i][j].split('_');
		        		var value_day = values[0]
		        		var value = values[1]
		        		
						var cell =  mygrid2.cells(row_id,cellIndex);
						var row =  mygrid2.getRowById(row_id);
						var td = cell.cell;
						var day = td.dayObj.dayDate;
						
						cell._cellIndex = cellIndex;
						if(value >0 && value_day == day){
							var keyCode = 48 + value*1;
						 	var event ={keyCode:keyCode,ctrlKey:false,shiftKey:false,target:td};
						 	mygrid2onKeypressClick(event);		
						}
	        		}
	        	}
	        }
        

}






function getSpecCmd(cindex){
	
	if(cindex == 3){
		function callfn(){
			var el = $("resourceSpecificId");
			var inputs = el.getElementsByTagName("option");
			var c_index = mygrid1.getColIndexById('apppos');
			var command = mygrid1.getCombo(c_index);
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
	
	if(cindex == 6){
		function callfn(objs){
			var c_index = mygrid1.getColIndexById('ordersubcate');
			var command = mygrid1.getCombo(c_index);
			command.clear();
			command.calculateauto = new Array();
			var defvalue = 0;
			for(var i = 0;i< objs.length;i++){
				var txt = objs[i].name;
				command.put(objs[i].id,objs[i].name);
				command.calculateauto[objs[i].id] = objs[i].calculateAuto;
//				if(txt =="正常") defvalue = objs[i].id;
		    }	
//		    command.obj.value="正常"
//		    command.list.selectedIndex = 1;
	
//			command.setValue(defvalue)
		    
//		    alert(command.getIndexByValue(defvalue))
		    	
		}
		orderCategory.obj.orgId = orgId;
		orderCategory.obj.version = version;
		orderCategory.obj.parentId = parent.document.getElementById("categoryId_for_paraArray").value; 
		OrderCategoryManager.getStore(orderCategory.obj,callfn);
//		orderCategory.makeSelectFromMap5(orderCategory.obj,"orderSubCategoryId","",callfn)
	}
	
	
	

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
	 	
	 	var closeBtn ={text: '关闭',handler: function(){compagesDiaWin.hide(this);}};
	 	var okBtn ={text: '确定',id:'compagesDiaWin_ok',handler: function(){clos_win_res_tree(model);}};

		 compagesDiaWin = new Ext.Window({
			   title : '选择时段',
			   width : 400,
			   height : 500,
			   isTopContainer : true, 
			   modal : true,
			   closeAction:'hide',
			   resizable : false,
			   buttons: [closeBtn,okBtn],
			   contentEl :  $("carrierTypeTreebox2")
		  	}); 	
	 }
	 
	
	 compagesDiaWin.buttons[1].handler = function(){clos_win_res_tree(model)};


	 
	 
	 
	 
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
			 getCarrierTypeTree(carrierType,model);  
			 $("carrierTypeTreebox2").style.height = compagesDiaWin.getInnerHeight()+"px";;
	}else{
			if(carrierType.tree.model != model){
				getCarrierTypeTree(carrierType,model);  
			}
	}
	
	carrierType.tree.model = model;
		
	
		
		



		
		
//		if(carrierType.tree !=null && carrierType.tree.dhtmlTree.getXMLState() && changed){
//			 carrierType.tree.refreshTree();
//		}    


};




function set_resInfo_to_grid1(resources){
		var res_cindex = mygrid1.getColIndexById('resourceName');
		var len_cindex = mygrid1.getColIndexById('len');
		var resourceIds = new Array();
		var count = mygrid1.selectedRows.length; 
		var res_obj = resources[0];
		
		for(var i = 0; i< count;i++){
			var row_id =  mygrid1.selectedRows[i].idd;
			var resourceName =  res_obj.broTime +' '+ res_obj.resourceMemo  +' '+res_obj.resourceName;
 			mygrid1.cells(row_id,res_cindex).setValue(resourceName);
			mygrid1.setUserData(row_id,"resourceId",res_obj.id)
			mygrid1.setUserData(row_id,"pos",res_obj.resourceMemo)
			resourceIds.push(res_obj.id);
			var length = mygrid1.cells(row_id,len_cindex).getValue();
			
			if(length >0){
				var matterOj={length:length};
				setBasePrices(resourceIds,matterOj);
			}
            

			reset_mygrid2_row(row_id);
		}
		

		 
}

function reset_mygrid2_row(rowId1,copy_grid1_rowid){
	var rowids = getRowByUserData(mygrid2,"grid1_rowId",rowId1);
     var bak_arr = new Array();
	if(rowids.length>0){
//		var aa = backup_bro_array();
		var remove_row_index= -1;

        if(copy_grid1_rowid > 0){
        	 bak_arr = get_bak_arr_by_grid1rowid(copy_grid1_rowid);	
        }else{
        	 bak_arr = get_bak_arr_by_grid1rowid(rowId1);	
        }		 	

		for(var i = 0;i<rowids.length;i++){
			mygrid2.deleteRow(rowids[i]);
		}
		
		getOneResourceMonthInfos(rowId1,0,true,mygrid1.getRowsNum(),0,bak_arr); 
		
	}else{

        if(copy_grid1_rowid > 0){
        	 bak_arr = get_bak_arr_by_grid1rowid(copy_grid1_rowid);	
        }
		getOneResourceMonthInfos(rowId1,0,true,mygrid1.getRowsNum(),0,bak_arr); 
	}
}


function get_bak_arr_by_grid1rowid(rowId1){
		var bak_arr = new Array();  
		var rowids = getRowByUserData(mygrid2,"grid1_rowId",rowId1);
	
		if(rowids.length>0){
				for(var i = 0;i<rowids.length;i++){
					bak_arr[i] = new Array();  
				    for(var j = 0 ;j < 31;j++){
				    	 var cell = mygrid2.cells(rowids[i],j+4);
				    	 var td = cell.cell;
				    	 var v = td.innerHTML;
				    	 var day = td.dayObj.dayDate;
			             bak_arr[i][j] = day+'_'+v;
			        }				
				}
		}
		
		return bak_arr;	
}


//function get_bak_arr_by_grid1rowid(rowId1){
//		var bak_arr = new Array();  
//		var rowids = getRowByUserData(mygrid2,"grid1_rowId",rowId1);
//	
//		if(rowids.length>0){
//				for(var i = 0;i<rowids.length;i++){
//					bak_arr[i] = new Array();  
//				    for(var j = 0 ;j < 31;j++){
//				    	 var cell = mygrid2.cells(rowids[i],j+4);
//				    	 var v = cell.cell.innerHTML;
//			             bak_arr[i][j] = v;
//			        }				
//				}
//		}
//		
//		return bak_arr;	
//}

function clos_win_res_tree(model){

			var tree = carrierType.tree.dhtmlTree;
			var resourceIds = new Array();
			
			if(model == 1){
				resourceIds = [carrierType.tree.getSelectedItemId("resourceId")];
			}else{
			 	resourceIds = carrierType.tree.getAllCheckedBranches("resourceId");				
			}

            
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
            
            if(model == 1){
            	set_resInfo_to_grid1(resources);
            }else{
            	createGrid1(paramFromUrl);
            }
	 	
	 		
	 		compagesDiaWin.hide(this);
		
	}

function getCarrierTypeTree(obj,model){
	
		var obj_tree = obj.tree.dhtmlTree;	
		var rootId = obj_tree.rootId;
		if(model == 1){
					obj_tree.enableCheckBoxes(false);
		}else{
					obj_tree.enableCheckBoxes(true);
					obj_tree.enableThreeStateCheckboxes(true);
//					obj_tree.enableSmartCheckboxes(true);		
		}	
		
		function doOnSelect(itemId){
				        if(itemId == "root") return false;
				        var isItemChecked = obj_tree.isItemChecked(itemId);
						obj_tree.setSubChecked(itemId,!isItemChecked);
		}
		obj_tree.setOnClickHandler(doOnSelect);//set function to call on dbl click		
		
		function doOnDblClick(itemId){
			compagesDiaWin.hide(this);
			if(model == 1){
				clos_win_res_tree(model);
			}
		}
		obj_tree.setOnDblClickHandler(doOnDblClick);		

		obj_tree.setImagePath(ctxPath+"scripts/dhtml/2.6/dhtmlxTree/codebase/imgs/");



	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	var getxml = function(strXML){		
		obj_tree.deleteChildItems(0);
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
			reset_mygrid2_row(row_id);
//			var bak_arr = get_bak_arr_by_grid1rowid(row_id);
//			getOneResourceMonthInfos(row_id,0,true,count,i,bak_arr);
		}
		setBasePrices(resourceIds,matterOj);
//		getAllResourceMonthInfos();
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
	
	
		 var ordersubcate_cindex = mygrid1.getColIndexById('ordersubcate');
	 //		 myrid1.cells(row_id,ordersubcate_cindex).setValue(19);
//		 var command = mygrid1.getCombo(ordersubcate_cindex);
//		 alert(command.setValue)
//		 command.setValue("正常");
//		 command.get[19];


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
		}else if(j == ordersubcate_cindex){
			var command = mygrid1.getCombo(ordersubcate_cindex); 
			var id = command.keys[0];
		 	rowArray.push(id); 
		}
		
		else{
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
    
    return row_id;

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



function set_grid2_month_times(td,bak_value,curValue){
			    var row = td.parentNode;
				var cells = row.cells;
				var realPrice_cindex = mygrid1.getColIndexById('realPrice');
				var sumTime_cindex = mygrid1.getColIndexById('sumTime');
				var sumPay_cindex = mygrid1.getColIndexById('sumPay');
				var ordersubcate_index = mygrid1.getColIndexById('ordersubcate');
				
				var grid1_row_id = cells[37].innerHTML; 
				var calculateauto_key = mygrid1.cells(grid1_row_id,ordersubcate_index).getValue();
				var command = mygrid1.getCombo(ordersubcate_index);
				var calculateauto = command.calculateauto[calculateauto_key];

//				var  relpay = mygrid1.cells(grid1_row_id,realPrice_cindex).getValue();
//				relpay = relpay ==""?0:relpay;
				

				bak_value = bak_value == ""|| bak_value == "&nbsp;"?0:bak_value*1;	
				curValue = curValue ==""?0:curValue*1;
				var v = curValue - bak_value;
				var times = cells[35].innerHTML;
				if(curValue !=  bak_value){
					times = times == ""|| times == "&nbsp;"?0:times*1;	
					var sumTime = times*1 + v;

//						var sumPay = sumTime * relpay;	
//						sumPay = sumPay ==0?"":sumPay;
//						cells[36].innerHTML = sumPay;	
				
					
					sumTime = sumTime == 0?"":sumTime;
					cells[35].innerHTML = sumTime;	
					
					
					var rowId2s =  getRowByUserData(mygrid2,"grid1_rowId",grid1_row_id);
					var sumTime_grid2 = 0;
					for (var j = 0; j < rowId2s.length; j++){
						var v = cells[35].innerHTML; 
						v = v ==""?0:v;
						sumTime_grid2 = v*1 + sumTime_grid2*1;
						
					}					
				    sumTime_grid2 = sumTime_grid2 ==0?"":sumTime_grid2;
					mygrid1.cells(grid1_row_id,sumTime_cindex).setValue(sumTime_grid2);
//					
					
					reset_grid1_sumPay(grid1_row_id,0,true,calculateauto);

//					var sumPay_grid1 = relpay*sumTime_grid2;
//					sumPay_grid1 = sumPay_grid1 ==0?"":sumPay_grid1;
//					mygrid1.cells(grid1_row_id,sumPay_cindex).setValue(sumPay_grid1);
					
					
				}
				
				
				

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
		
	
		
		if(!ev.button){
			if(td._cellIndex < start_cellIndex || td._cellIndex > end_cellIndex){
				 ev.cancelBubble=true;
				 return false;
			}
		}

		if(keyCode>= 48 && keyCode <= 58 ){
			
			var row = td.parentNode;
			var cells = row.cells;
			var bak_value = cells[td._cellIndex].innerHTML;

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
				

				set_grid2_month_times(td,bak_value,v);
//				v = v == 0?"":v;
//				var cell = that.cells2(td.parentNode.rowIndex,td._cellIndex)
//				that.cells2(td.parentNode.rowIndex,td._cellIndex).setValue(v);

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
	
	
	
	
	
	


	function search_adver_cont(model){
	   var  customerId = '';	
	   var customerName =  ''; 

	   function callFunction(params){
	   	   	   document.getElementById('matteriframe').contentWindow.loadGridData(params);	        
	   	}  
	   	
	   	
	function close_search_adver_winWin(p,my_grid_matter,model){
   	   	var rowId = my_grid_matter.id;
   	   	var edit = (p == 1)?my_grid_matter.cells(rowId,2).getValue():my_grid_matter.edit;
		var length = (p == 1)?my_grid_matter.cells(rowId,3).getValue():my_grid_matter.length;
		var matterOj = {id:rowId,edit:edit,length:length};
		adver_win_close_fun(matterOj);
	}   	
	   	

      var urlStr= ctxPath + "selectPopup/selectMatters.html?orgId="+orgId+"&customerId="+customerId+"&version="+order_year; 
       urlStr = urlStr + "&customerName="+customerName;
       urlStr = urlStr + "&model=1";

   if(!search_adver_win){

   	   var addNewBtn ={text: '新添素材',handler: function(){
			document.getElementById('matteriframe').contentWindow.save_new_matter();	 
		}};
		
   	   var closeBtn ={text: '关闭',handler:close_search_adver_winWin};


   	   var resetBtn ={text: '重置',handler:function(){
			document.getElementById('matteriframe').contentWindow.resetQueryWhere();	
   	   }};

   	   

   	   customer_fin.obj.orgId = orgId;
   	   matter_fin.obj.orgId = orgId;
   	   
   	   
	

   	   var customerCmd = customer_fin.initCustomerCmd(matter_fin.obj,'search_adver_customer',null,'remote',null,'customerName',1,133,300,'请选择客户...',callFunction);
   	  alert(2)
   	  
   	   var nameCmd = matter_fin.getCommandForSelect('search_adver_name','广告名称...','name',1,110,callFunction);
   	   alert(2)
   	   var editCmd = matter_fin.getCommandForSelect('search_adver_edit','请输入广告版本...','edit',1,190,callFunction);
   	   alert(3)
   	   var lengthCmd = matter_fin.getCommandForSelect('search_adver_len','长度...','length',1,70,callFunction);
   	   alert(4)
   	   var tapecodeCmd = matter_fin.getCommandForSelect('search_adver_tapecode','磁带...','tapeCode',2,70,callFunction);
   	   alert(5)
   	   var industryCmd = industry_fin.getIndustryCmd(matter_fin.obj,'search_adver_brandId_cmd','search_adver_brandId_tree',true,null,config_industryLevelParam,'brandId','选择行业...',100,callFunction);
	   alert(6)
	   var matterTypeCmd = matterType.getMatterTypeCmd(matter_fin.obj,null,'search_adver_matterType','matterType',70,'分类...',callFunction);


	   search_adver_win =new Ext.Window({
			title:"素材库-(广告名称、广告版本可以用汉字声母查询，选择素材时用鼠标双击)",
			modal : true,
			resizable : false,
			closeAction:'hide',
			closable: true,
			width : 800,
			height : 500, 
//			tbar:[tapecodeCmd,'-',nameCmd,'-',nameCmd,'-',editCmd,'-',lengthCmd,'-',industryCmd],
			tbar:[customerCmd,nameCmd,editCmd,lengthCmd,tapecodeCmd,industryCmd,matterTypeCmd],
			buttons: [addNewBtn,'-',closeBtn], 
			contentEl : Ext.DomHelper.append(document.body, {
			    tag : 'iframe',
			     id : 'matteriframe',
			    style : "border 0px none;scrollbar:true",
			    src : urlStr,
			    height : "100%",
			    width : "100%"
			   })
		});

		 search_adver_win.on({'close': {fn: close_search_adver_winWin}});
		 search_adver_win.show(this);
		 
   }
   

}


function reset_orderCategoryMain(e){
	orderCategoryMain = getSelectParamFromAttribute(e,"calculateauto");//根据付款分配应收
	var ordersubcate_index = mygrid1.getColIndexById('ordersubcate');
	var command = mygrid1.getCombo(ordersubcate_index);
	
	if(orderCategoryMain != 0){
			parent.document.getElementById("paymoney_for_paraArray").readOnly = true;
	}else{
			parent.document.getElementById("paymoney_for_paraArray").readOnly = false;
	}

	for(var i = 0;i<mygrid1.getRowsNum();i++){
		var grid1_row_id = mygrid1.getRowId(i);
		var calculateauto_key = mygrid1.cells(grid1_row_id,ordersubcate_index).getValue();
		var calculateauto = command.calculateauto[calculateauto_key];			
		reset_grid1_sumPay(grid1_row_id,0,true,calculateauto); 
	}

}


function setAutoBroArray(){
	
	function handleActivate(tab){
        alert(tab.title + ' was activated.');
    }
    
   var tabs2 = new Ext.TabPanel({
        renderTo: document.body,
        activeTab: 0,
//        width:400,
//        height:250,
        plain:true,
        defaults:{autoScroll: true},
        items:[{
                title: 'Normal Tab',
                html: "My content was added during construction."
            },{
                title: 'Ajax Tab 1',
                autoLoad:'ajax1.htm'
            },{
                title: 'Ajax Tab 2',
                autoLoad: {url: 'ajax2.htm', params: 'foo=bar&wtf=1'}
            },{
                title: 'Event Tab',
                listeners: {activate: handleActivate},
                html: "I am tab 4's content. I also have an event listener attached."
            },{
                title: 'Disabled Tab',
                disabled:true,
                html: "Can't see me cause I'm disabled"
            }
        ]
    });
    
    
    
    
       var def_Date_start =   myUtils.parseDate2(getFormatDay(startDate2,"y-m-d"));
	 var def_Date_end =    myUtils.parseDate2(getFormatDay(endDate,"y-m-d"));  
	 
	 
//	 alert(def_Date_start)
    
    var top = new Ext.FormPanel({
    	
    	 labelWidth: 40,
         labelAlign: 'right',
      
//        labelAlign: 'top',
        frame:true,
//        title: '投放期间',
        bodyStyle:'padding:5px 5px 0',
        width: 460,
        items: [{
            layout:'column',
            items:[
            
            {
                columnWidth:.4,
                layout: 'form',
                items: [
                
			        { fieldLabel: '开始日期',
			        name: 'startdt',
			        id: 'startdt',
			        xtype:'datefield',
			        format : 'Y-m-d',
			         anchor:'95%',
			        endDateField: 'enddt',// id of the end date field
			        enableKeyEvents : true,
			        value:def_Date_start
			      	}
                
                ]
            },{
                columnWidth:.4,
                layout: 'form',
                items: [
                
							{fieldLabel: '结束日期',
							        name: 'enddt',
							        id: 'enddt',
							        xtype:'datefield',
							        format : 'Y-m-d',
							         anchor:'95%',
							        startDateField: 'startdt', // id of the start date field
							//        value:def_Date_end
							//         enableKeyEvents : true,
							        value:def_Date_end
							  }
                
                
                ]
            },{
                columnWidth:.2,
                layout: 'form',
                labelWidth: 30,
                items: [
                
							{fieldLabel: '次数',
							        name: 'bro_timssss',
							        id: 'bro_timssss',
							        xtype:'textfield',
							         anchor:'95%'
							  }
                
                
                		]
           		 }
            
            
            ]
        }],

//        buttons: [{
//            text: 'Save'
//        },{
//            text: 'Cancel'
//        }]
    });
    
    
     var btnSave = {text: '保存',handler: function(){removeWin();} };
 	var btnClose = {text: '关闭',handler: function(){removeWin();} };
 	 
    
//   var top_div = $("auto_array_top_div"); 

//   alert(document.getElementById("auto_array_beginDate"))
   
   var fieldset = {
            xtype:'fieldset',
            checkboxToggle:false,
//            title: '投放期间',
            autoHeight:true,
//            height:300,
//            defaults: {width: 210},
            defaultType: 'textfield',
            collapsed: false,
            items :[top]
        } 
    
    

 	 var auto_bro_array_win=new Ext.Window({
			title:"自动排期",
			modal : true,
			resizable : false,
			closeAction:'hide',
			closable: true,
			width : 500,
			height : 500, 
			items:tabs2,
			tbar:[top],
//			tbar:[tapecodeCmd,'-',nameCmd,'-',nameCmd,'-',editCmd,'-',lengthCmd,'-',industryCmd],
//			tbar:[customerCmd,nameCmd,editCmd,lengthCmd,tapecodeCmd,industryCmd,matterTypeCmd],
			buttons: [btnSave,'-',btnClose], 

		});   

		auto_bro_array_win.show(this);
		
//	 if(!auto_bro_array_win){
//            win = new Ext.Window({
//                applyTo:'hello-win',
//                layout:'fit',
//                width:500,
//                height:300,
//                closeAction:'hide',
//                plain: true,
//
//                items: new Ext.TabPanel({
//                    applyTo: 'hello-tabs',
//                    autoTabs:true,
//                    activeTab:0,
//                    deferredRender:false,
//                    border:false
//                }),
//
//                buttons: [{
//                    text:'Submit',
//                    disabled:true
//                },{
//                    text: 'Close',
//                    handler: function(){
//                        win.hide();
//                    }
//                }]
//            });
//        }
//        win.show(this);
//    });	
		
		
		
		
		
		
		
		
		
		
		
    
    
}
	