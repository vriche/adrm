
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
var auto_bro_array_win;
var specific_tree_win;

var build_more_paraArray;

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
		
		order_id = getParamFromUrl(srcStr,"orderId");
	
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
		
		
		if(order_id >0){
			
		}else{
			addGrid1NewRow();
		}
		
		
//		alert(Ext.lib.Dom.getViewWidth())
  }
   
 
 
 function initPosition_compagesDiaWin(){
	   var doc = document, bd = (doc.body || doc.documentElement);
//		var left = bd.scrollLeft + Ext.lib.Dom.getViewWidth()-2-compagesDiaWin.width;
		var top = bd.scrollTop + Ext.lib.Dom.getViewHeight()-6-compagesDiaWin.height;

	  compagesDiaWin.setPosition(bd.scrollLeft+2,top);	
 }

  function initPosition_auto_bro_array_win(){

		if(compagesDiaWin){
			if(!compagesDiaWin.hidden){
				 var left =  compagesDiaWin.width+2;
				 var top = 2;		
				 auto_bro_array_win.setPosition(left,top);	
			}
			
		}

 }
 
function createGrid1(param,caFun){
	 var objs =  param.resources;
	 var rs_cindex = mygrid1.getColIndexById('resourceName');
	 var newIdArray = new Array();

	 for(var i = 0;i<objs.length;i++){
	 	 var row_id = addGrid1NewRow();
	 	 newIdArray.push(row_id);
	 	 var  resourceName = objs[i].broTime +' '+ objs[i].resourceMemo  +' '+ objs[i].resourceName;
		 mygrid1.cells(row_id,rs_cindex).setValue(resourceName);
		 mygrid1.setUserData(row_id,"resourceId",objs[i].id);
		 mygrid1.setUserData(row_id,"pos",objs[i].resourceMemo);
	 }
	 return newIdArray;
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
 		 	getSpecificTreeWin();
 		 }
 		 if(menuitemId =='btnChoseArray'){    
 		 	setAutoBroArray();
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
		    	  	 	
		    	  	 	reset_mygrid2_row(row_id,1);
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
						
						reset_mygrid2_row(row_id,1);
				
		    	  	}
		    	 	if(menuitemId =='post_arr'){
		    	    	reset_mygrid2_row(row_id,2,copy_grid1_rowid);
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
		    	    	
		    	    	
		   	    	
		    	    	reset_mygrid2_row(row_id,2,copy_grid1_rowid);
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
		    	    	
		    	    	
		   	    	
		    	    	reset_mygrid2_row(row_id,2,copy_grid1_rowid);
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
				if(state == 2 && wasChanged)reset_mygrid2_row(rowId,1);return true;	
			}else if(this.getColumnId(cellIndex)=='ordersubcate'){
				if(state == 2 && wasChanged){
//					var c_index = this.getColIndexById('ordersubcate');
					var command = this.getCombo(cellIndex);
					var calculateauto_key = this.cells(rowId,cellIndex).getValue();
					var calculateauto = command.calculateauto[calculateauto_key];
					 reset_grid1_sumPay(rowId,cellIndex,wasChanged,calculateauto);return true;
				}
			}else if(this.getColumnId(cellIndex)=='apppos'){
				if(state == 2 && wasChanged)reset_mygrid2_row(rowId,1);return true;	
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
//		                this.mark(rowId,cellIndex,true);
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
    
    
//    function onRowDblClicked(){
////    	mygrid2.setActive(true);
////alert(this.isActive)
//    }
//    mygrid2.attachEvent("onRowDblClicked", onRowDblClicked);
    
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
	
	return true; 
	var selectedRowsCount = mygrid1.selectedRows.length;
	if(selectedRowsCount == 0){
//		if(compagesDiaWin){
//					if(!compagesDiaWin.hidden){
//						return 	true;
//					}
//		}else{
//			 Ext.MessageBox.alert('系统提示','请选择需要处理的记录!',function(){}); 
//			 return false;   
//		}
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
	var apppos_cindex = mygrid1.getColIndexById('apppos');
	
	
	var specificValue = mygrid1.cells(row_id,apppos_cindex).getValue();
	specificValue = specificValue==null||specificValue==''?0:specificValue;


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
//	orderDetail_obj.version = order_year;
	orderDetail_obj.orderDetailStates = orderDetailStates;



	var getMonthsFun = function(objs){
//		console.log(objs)
//    	parent.backup_cur_info(null,null,objs);	
//		if(!isMore) mygrid2.clearAll();

		for(var i = 0;i<objs.length;i++){
			
			
				
			var month_obj = objs[i];
			month_obj.grid1_rowId = row_id;
	  		month_obj.pos = pos;
	  		month_obj.edit = edit;
	  		month_obj.matterId = matterId;
	  		
	        	
	  		
	  		var year = month_obj.year;
	  		var month = month_obj.month;
	  		month = month<10?'0'+month:month;
	  		var key = 	year +''+ month;
//	  		if(matterId > 0){
	  			month_obj.bak_arr = bak_arr;
	  			


	  			if(bak_arr.length > 0){
		  			var used_months = getMonthFrom_bak_arr(bak_arr);
		  			 max = Math.max.apply(Math,used_months);
					 min = Math.min.apply(Math,used_months); 
		  			 var new_start_month = (''+startDate).substring(0,6);
		  			 var new_end_month = (''+endDate).substring(0,6);
//                   alert(used_months+"  "+key)
//				  alert(used_months.contains(key))
		  			//只加有排期的月份
		  			if(used_months.contains(key)){
		  				createMonthRow(month_obj);
		  			}else{
//		  				alert(new_start_month)
//		  				alert(key)
		  				if(new_start_month*1 < min*1 || new_end_month*1 > max*1){
		  					createMonthRow(month_obj);
		  				}
		  			}
	  			}else{

	  				createMonthRow(month_obj);
	  			}

	  			
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
		  
//		  var row_id = rowCount+1;
		  var row_id =  (new Date()).valueOf();
		  var color ="#CCCCCC";
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
//                        alert(cellIndex+ '_'+ j)
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
	 	var okBtn ={text: '确定',id:'compagesDiaWin_ok',handler: function(){}};

		 compagesDiaWin = new Ext.Window({
			   title : '选择时段',
			   width : 400,
			   height : 500,
			   isTopContainer : true, 
			   modal : true,
			   closeAction:'hide',
			   resizable : false,
			   buttons: [okBtn,closeBtn],
			   contentEl :  $("carrierTypeTreebox2")
		  	}); 
		  	
	    Ext.EventManager.onWindowResize(initPosition_compagesDiaWin, this); //window大小改变时，重新设置坐标
	    Ext.EventManager.on(window, 'scroll', initPosition_compagesDiaWin, this); //window移动滚动条时，重新设置坐标		  	
		  		
	 }
	 
	
	 compagesDiaWin.buttons[0].handler = function(){clos_win_res_tree(model)};

	 initPosition_compagesDiaWin();

	compagesDiaWin.show(this);
	
	
//	if(model ==1){
//		compagesDiaWin.buttons[0].show();
//		compagesDiaWin.buttons[1].hide();
//	}else{
//		compagesDiaWin.buttons[0].hide();
//		compagesDiaWin.buttons[1].show();
//	}
	

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




function set_resInfo_to_grid1(resources,is2win){
		var res_cindex = mygrid1.getColIndexById('resourceName');
		var len_cindex = mygrid1.getColIndexById('len');
		var resourceIds = new Array();
		var count = mygrid1.selectedRows.length; 
		var res_obj = resources[0];
		
		var newIdArray = new Array();
		
		for(var i = 0; i< count;i++){
			var row_id =  mygrid1.selectedRows[i].idd;

			var resourceName =  res_obj.broTime +' '+ res_obj.resourceMemo  +' '+res_obj.resourceName;
 			mygrid1.cells(row_id,res_cindex).setValue(resourceName);
			mygrid1.setUserData(row_id,"resourceId",res_obj.id)
			mygrid1.setUserData(row_id,"pos",res_obj.resourceMemo)
			resourceIds.push(res_obj.id);
			var length = mygrid1.cells(row_id,len_cindex).getValue();
			
			if(length >0){
				function cafn(){
						if(!is2win)reset_mygrid2_row(row_id,1);
				}
				var matterOj={length:length};
				setBasePrices(resourceIds,matterOj,cafn);
			}else{
				if(!is2win)reset_mygrid2_row(row_id,1);
			}

			newIdArray.push(row_id);
		}
		
      return newIdArray;
		 
}



function reset_mygrid2_row(rowId1,mode,copy_grid1_rowid,new_arr){

	var rowids = getRowByUserData(mygrid2,"grid1_rowId",rowId1);
	
//	alert(rowids)
	
    var bak_arr = new Array();

		if(mode == 1){  //备份当前
			bak_arr = get_bak_arr_by_grid1rowid(rowId1);	
		}else if(mode == 2){ //copy_post
			bak_arr = get_bak_arr_by_grid1rowid(copy_grid1_rowid);	
		}else if(mode == 3){//自动配置
			bak_arr = new_arr;	 
		}

		for(var i = 0;i<rowids.length;i++){
			mygrid2.deleteRow(rowids[i]);
		}	
		
		getOneResourceMonthInfos(rowId1,0,true,mygrid1.getRowsNum(),0,bak_arr); 

}


function get_bak_arr_by_grid1rowid(rowId1){
		var bak_arr = new Array();  
		var rowids = getRowByUserData(mygrid2,"grid1_rowId",rowId1);
		var have = false;

		if(rowids.length>0){
				for(var i = 0;i<rowids.length;i++){
					bak_arr[i] = new Array();  
				    for(var j = 0 ;j < 31;j++){
				    	 var cell = mygrid2.cells(rowids[i],j+4);
				    	 var td = cell.cell;
				    	 var v = td.innerHTML;
				    	 v = (v =='&nbsp;' || v =='')?0:v;
				    	 var day = td.dayObj.dayDate;
			             bak_arr[i][j] = day+'_'+v;
			             if(v > 0) have = true;
			        }				
				}
		}
		bak_arr = have?bak_arr:[];
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

function clos_win_res_tree(model,is2win){
	
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
            
            
            var newIdArray = new Array();
            
            
            if(model == 1){
            	newIdArray = set_resInfo_to_grid1(resources,is2win);
            }else{
            	newIdArray = createGrid1(paramFromUrl);
            }
	 	
	 		
	 		compagesDiaWin.hide(this);
	 		
	 		return newIdArray;
		
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
			if(model == 2){
				        if(itemId == "root") return false;
				        var isItemChecked = obj_tree.isItemChecked(itemId);
						obj_tree.setSubChecked(itemId,!isItemChecked);	
			}

		}
		obj_tree.setOnClickHandler(doOnSelect);//set function to call on dbl click		
		
		function doOnDblClick(itemId){
			var type = obj_tree.getUserData(itemId,"type");
			if(type != 3) return false;
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
			reset_mygrid2_row(row_id,1);
//			var bak_arr = get_bak_arr_by_grid1rowid(row_id);
//			getOneResourceMonthInfos(row_id,0,true,count,i,bak_arr);
		}
		setBasePrices(resourceIds,matterOj);
//		getAllResourceMonthInfos();
}


function setBasePrices(resourceIds,matterOj,callFun){
	
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
		
		if(callFun) callFun();			
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
	var row_index =  mygrid1.getRowsNum()*1 ;

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

    
    if(count ==1){
    	
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
			
//			that.setActive(true)
			
//			alert(row.idd)
//			 that.mark(row.idd,td._cellIndex,true);
			
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
		
//		console.log( Ext.getCmp('mainRadiogroup'))
		
		if(tab.id == 'mainTab_1'){
			  Ext.getCmp('mainRadiogroup').setValue(2);//把是选中
		}
		if(tab.id == 'mainTab_2'){
			Ext.getCmp('mainRadiogroup_week').reset();
 			Ext.getCmp('mainRadiogroup').setValue(3);//把是选中
		}
		if(tab.id == 'mainTab_3'){
			Ext.getCmp('mainRadiogroup_month').reset();
 			Ext.getCmp('mainRadiogroup').setValue(4);//把是选中
		}	

//        alert(tab.title + ' was activated.');
    }

    var radioGroup_one_two = {
            xtype: 'radiogroup',
            id:'mainRadiogroup_one_two',
            labelWidth: 60,
            items: [
            	{boxLabel: '单日', name: 'rb-auto', inputValue: 1 ,checked: true},
            	{boxLabel: '双日', name: 'rb-auto', inputValue: 2}
            ]
        };  
        
//        var weekCom = myUtils.getComWeek("bro_week","星期",45,1);
//        alert(weekCom)


		var checkboxgroup_week ={
            xtype: 'checkboxgroup',
            id:'mainRadiogroup_week',
            items: [
                {boxLabel: '星期一', name: 'cb-week-1', inputValue:'1'},
                {boxLabel: '星期二', name: 'cb-week-2', inputValue:'2'},
                {boxLabel: '星期三', name: 'cb-week-3', inputValue:'3'},
                {boxLabel: '星期四', name: 'cb-week-4', inputValue:'4'},
                {boxLabel: '星期五', name: 'cb-week-5', inputValue:'5'},
                {boxLabel: '星期六', name: 'cb-week-6', inputValue:'6'},
                {boxLabel: '星期日', name: 'cb-week-0', inputValue:'0'}
            ]
        };
        
      function monthCheckboxActivate(checkBox,checked){
      	var objs = Ext.getCmp('mainRadiogroup_month').getValue();
      	if(objs.length == 0){
      		setDateFiled();
      	}else{
      		setDateFiled(2);
      	}
    
      }
  
  		var checkboxgroup_month ={
            xtype: 'checkboxgroup',
            id:'mainRadiogroup_month',
            columns: 6,
            items: [
                {boxLabel: '一月', name: 'cb-month-1', inputValue:'1' ,listeners: {check: monthCheckboxActivate}},
                {boxLabel: '二月', name: 'cb-month-2', inputValue:'2' ,listeners: {check: monthCheckboxActivate}},
                {boxLabel: '三月', name: 'cb-month-3', inputValue:'3' ,listeners: {check: monthCheckboxActivate}},
                {boxLabel: '四月', name: 'cb-month-4', inputValue:'4' ,listeners: {check: monthCheckboxActivate}},
                {boxLabel: '五月', name: 'cb-month-5', inputValue:'5' ,listeners: {check: monthCheckboxActivate}},
                {boxLabel: '六月', name: 'cb-month-6', inputValue:'6' ,listeners: {check: monthCheckboxActivate}},
                {boxLabel: '七月', name: 'cb-month-1', inputValue:'7' ,listeners: {check: monthCheckboxActivate}},
                {boxLabel: '八月', name: 'cb-month-2', inputValue:'8' ,listeners: {check: monthCheckboxActivate}},
                {boxLabel: '九月', name: 'cb-month-3', inputValue:'9' ,listeners: {check: monthCheckboxActivate}},
				{boxLabel: '十月', name: 'cb-month-4', inputValue:'10' ,listeners: {check: monthCheckboxActivate}},
                {boxLabel: '十一月', name: 'cb-month-4', inputValue:'11' ,listeners: {check: monthCheckboxActivate}},
                {boxLabel: '十二月', name: 'cb-month-5', inputValue:'12' ,listeners: {check: monthCheckboxActivate}},
            ]
        };      
        
        
      var fieldset_one_two = {
            xtype:'fieldset',
             title: '1 ',
            checkboxToggle:false,
//            autoHeight:true,
			height:80,
            defaultType: 'textfield',
            collapsed: false,
            items :[radioGroup_one_two]
        }  
        
         var fieldset_week = {
            xtype:'fieldset',
             title: '1',
             layout: 'fit',
//            checkboxToggle:true,
//            autoHeight:true,
			height:80,
            defaultType: 'checkbox',
            collapsed: false,
            items :[checkboxgroup_week]
        }       
        var fieldset_month = {
            xtype:'fieldset',
             title: '1',
             layout: 'fit',
//            autoHeight:true,
			height:80,
            defaultType: 'checkbox',
            collapsed: false,
            items :[checkboxgroup_month]
        }                  
        
        
        
   var tabPanel = new Ext.TabPanel({
//        activeTab: 0,
        plain:true,
        id:"mainTab",
        defaults:{autoScroll: true},
        items:[{
                title: '单双日',
                id:"mainTab_1",
                items:[fieldset_one_two],
//                html: "My content was added during construction.",
//                disabled:true,
                listeners: {activate: handleActivate}
            },{
                title: '星期',
                id:"mainTab_2",
				items:[fieldset_week],
//                 disabled:true,
                 listeners: {activate: handleActivate}
            },{
                title: '月份',
                id:"mainTab_3",
				items:[fieldset_month],
//                  disabled:true,
                  listeners: {activate: handleActivate}
            }
        ]
    });
    
    
    
    
     var def_Date_start =   myUtils.parseDate2(getFormatDay(startDate2,"y-m-d"));
	 var def_Date_end =    myUtils.parseDate2(getFormatDay(endDate,"y-m-d"));  
	 var timeCom = myUtils.getComMonth("bro_timssss","次数",45,1);
	 var starDateItem =  { fieldLabel: '开始日期',
			        name: 'startdt',
			        id: 'startdt',
			        xtype:'datefield',
			        format : 'Y-m-d',
			         anchor:'95%',
			        endDateField: 'enddt',// id of the end date field
			        enableKeyEvents : true,
			        value:def_Date_start
			      	};
	var endDateItem = {fieldLabel: '结束日期',
							        name: 'enddt',
							        id: 'enddt',
							        xtype:'datefield',
							        format : 'Y-m-d',
							         anchor:'95%',
							        startDateField: 'startdt', // id of the start date field
							        value:def_Date_end
					};		      	
	 
//	 alert(def_Date_start)


     var fieldset_week = {
            xtype:'fieldset',
            checkboxToggle:false,
//            title: '投放期间',
            autoHeight:true,
//            height:300,
//            defaults: {width: 210},
            defaultType: 'textfield',
            collapsed: false,
            items :[{title: 'Normal Tab',html: "My content was added during construction."}]
        }   

   	var listeners_opt = {check : function(checkbox, checked) {if (checked) {displayModel =1;search();  }}}  ; 
	var handler =  function(checkbox, checked) {if(checked){
	   	var groupValue = checkbox.getGroupValue();
		var tabs = Ext.getCmp("mainTab");  
		
		
		
	    tabs.setDisabled(false)
	   	if(groupValue == 2 ){tabs.setActiveTab(0);}
	    if(groupValue == 3 ){tabs.setActiveTab(1);} 
		if(groupValue == 4 ){tabs.setActiveTab(2);} 
		if(groupValue == 1 || groupValue == 5 ){
			tabs.setDisabled(true);
		}
		//月份及全年

		//月份及全年
		if(groupValue == 5){ 
			setDateFiled(1);
		}		
		
   	}};       
   var radioGroup_main = {
            xtype: 'radiogroup',
            id:'mainRadiogroup',
            labelWidth: 60,
            fieldLabel: '选择模式',
            items: [
            	{boxLabel: '每天', name: 'rb-auto', inputValue: 1 ,checked: true,handler:handler},
            	{boxLabel: '单双日', name: 'rb-auto', inputValue: 2,handler:handler},
            	{boxLabel: '星期', name: 'rb-auto', inputValue: 3,handler:handler},
            	{boxLabel: '月份', name: 'rb-auto', inputValue: 4,handler:handler},
                {boxLabel: '全年', name: 'rb-auto', inputValue: 5,handler:handler}
            ]
        };      
        
   var fp_bbar = new Ext.FormPanel({
        frame: true,
        labelWidth: 50,
        width: 480,
        bodyStyle: 'padding:0 10px 0;',
        items: [radioGroup_main]
    });     

   var win_tbar = new Ext.FormPanel({
		labelWidth: 40,
		labelAlign: 'right', //'top'
        frame:true,
        bodyStyle:'padding:5px 5px 0',
        width: 500,
        bbar:fp_bbar,
        items: [{
            layout:'column',
            items:[
	            {
	                columnWidth:.4,
	                layout: 'form',
	                items: [starDateItem]
	            },{
	                columnWidth:.4,
	                layout: 'form',
	                items: [endDateItem]
	            },{
	                columnWidth:.2,
	                layout: 'form',
	                labelWidth: 30,
	                items: [timeCom]
	           	  }
            ]
        }]
    });


	function getAuoArraySelectedValue(mode){
		var selectValue = new Array();
		if(mode == 2){selectValue = [Ext.getCmp('mainRadiogroup_one_two').getValue().inputValue];} //单双日
		if(mode == 3){selectValue = getCheckboxgroupValue('mainRadiogroup_week');} //星期
		if(mode == 4){selectValue  = getCheckboxgroupValue('mainRadiogroup_month');} //月份
		return selectValue;
	}

 	if(!auto_bro_array_win){
 		var closeFun = function(){
 			auto_bro_array_win.destroy();
 			auto_bro_array_win = null;
 		};
		var btnSave = {text: '确定',handler: function(){

				var startDate = Ext.getCmp('startdt').getValue();
				var endDate = Ext.getCmp('enddt').getValue();
				var times = Ext.getCmp('bro_timssss').getValue();
				var mode = Ext.getCmp('mainRadiogroup').getValue().inputValue;
				var selectValue = getAuoArraySelectedValue(mode);
				
				
				if(compagesDiaWin){
						if(!compagesDiaWin.hidden){
							var model = carrierType.tree.model;

							if(model == 2){
								var newIdArray = new Array();
								newIdArray = clos_win_res_tree(model,true);
								mygrid1.clearSelection();
								for(var i = 0;i<newIdArray.length;i++){
	//								mygrid1.selectRowById(newIdArray[i]);
									var row = mygrid1.getRowById(newIdArray[i]);
									mygrid1.selectRow(row, false, true, false);
								}	
							}else{
								clos_win_res_tree(model,true);
							}

							
						}
				}
				
				
			
				fillBroArrange(mygrid1,mygrid2,startDate,endDate,times,mode,selectValue);

				closeFun();				

			} 
		};
		var btnClose = {text: '关闭',handler: closeFun };
		auto_bro_array_win = new Ext.Window({
				title:"自动配置",
				modal : true,
				resizable : false,
				closeAction:'destroy',
				closable: true,
				width : 500,
				height : 270, 
				items:[tabPanel],
				tbar:[win_tbar],
				buttons: [btnSave,'-',btnClose], 
	
			});   		
 	}

	auto_bro_array_win.show(this);
	initPosition_auto_bro_array_win();
	mygrid2.setActive(true);
}

function fillBroArrange(grid1,grid2,startDt,endDt,times,mode,selectValue){	
	var s_cindex = grid1.getColIndexById('start');
	var e_cindex = grid1.getColIndexById('end');
	var startDate = myUtils.formatDateSimple(startDt,'');
	var endDate = myUtils.formatDateSimple(endDt,'');   
				

	var rows = grid1.selectedRows;
	var rowCount = rows.length;
	for (var i = 0; i < rowCount; i++){
		
		var rowId1 = rows[i].idd;

		 startDate = getFormatDay(startDate,'y/m/d');
		 endDate = getFormatDay(endDate,'y/m/d');
		 
		grid1.cells(rowId1,s_cindex).setValue(startDate);
		grid1.cells(rowId1,e_cindex).setValue(endDate);
		
//		var rowId2s =  getRowByUserData(grid2,"grid1_rowId",rowId1);
//		for (var j = 0; j < rowId2s.length; j++){
//			mygrid2.deleteRow(rowId2s[j]); 
//		}
		
		var new_arr = get_bro_arr_by_grid1rowid(rowId1,startDt,endDt,times,mode,selectValue);

	
		reset_mygrid2_row(rowId1,3,null,new_arr);

	} 	
	    
}

 function get_bro_arr_by_grid1rowid(rowId1,startDt,endDt,times,mode,selectValue){
	var new_arr = new Array();  
	var yearDiff = endDt.getFullYear() - startDt.getFullYear();
	var monthDiff = myUtils.monthDiff(startDt,endDt);
	
	var startDate = myUtils.formatDateSimple(startDt,'');
	var endDate = myUtils.formatDateSimple(endDt,''); 

	var start_year =  startDt.getFullYear();
 	var start_month =  startDt.getMonth()+1;

 	var mm = ""; 
 	var dd = "";  
 	var isMatch =false;

    for(var y = 0; y < yearDiff + 1;y++){
    	
		for(var i = 0;i< (monthDiff+1);i++){

	
			new_arr[i] = new Array();  
			mm = start_month<10?'0'+start_month:start_month;

			for(var j = 0 ;j < 31;j++){
				dd = j<10?'0'+(j+1):j+1;
	            var day =   start_year +''+ mm +''+dd;
	            isMatch = false;
	              
	            if(mode == 2){ //单双
	            	var oneOrtwo = selectValue[0]==1?1:0;
	            	if((j+1)%2 == oneOrtwo && day*1 >= startDate*1 && day*1 <= endDate*1){
	            		new_arr[i][j] = day+'_'+times; isMatch = true;
	            	}
	            }else if(mode == 3){ //星期
	            	var dd_week = new Date(start_year, start_month-1, j+1, 0, 0, 0);
	            	var week = ''+dd_week.getDay();
	            	
	            	if(selectValue.contains(week) && day*1 >= startDate*1 && day*1 <= endDate*1){
	            		new_arr[i][j] = day+'_'+times; isMatch = true;
	            	}	            	
	            }else if(mode == 4){ //月份
	            	if(selectValue.contains(''+start_month) && day*1 >= startDate*1 && day*1 <= endDate*1){
	            		new_arr[i][j] = day+'_'+times; isMatch = true;
	            	}	            	
	            }else{
	            	if(day*1 >= startDate*1 && day*1 <= endDate*1){
	            		new_arr[i][j] = day+'_'+times; isMatch = true;
	            	}	  
	            }	            
	            
	            if(!isMatch)new_arr[i][j] = day+'_0';

			}	
			
			start_month  += 1;			
		}
		start_year += 1;
    }

	
	return new_arr;	
}  
function getCheckboxgroupValue(id) {
	var objs = Ext.getCmp(id).getValue();
	var v = [];
	for (var i = 0; i < objs.length; i++) {
		if (objs[i].checked) { v.push(objs[i].inputValue);}
	}
	return v;
}     

function setDateFiled(mode){
			var startDt =  Ext.getCmp('startdt');
			var endDt =  Ext.getCmp('enddt');
			var d1 = new Date();
			var d2 = new Date();	
			
			if(mode == 1){
				 var year = startDt.getValue().getFullYear();
				 d1 = new Date(year,"0","1");
				 d2 = new Date(year,"11","31");	
			}else if(mode == 2){
				var selectValue  = getCheckboxgroupValue('mainRadiogroup_month');
				var min =  startDt.getValue().getMonth();
				var max =  endDt.getValue().getMonth();
				
				var yy1 = startDt.getValue().getFullYear();
				var dd1 = startDt.getValue().getDate();
				
				var yy2 = endDt.getValue().getFullYear();
				var dd2 = endDt.getValue().getDate();			
								 
				if(selectValue.length>0){
					 max = Math.max.apply(Math,selectValue);
					 min = Math.min.apply(Math,selectValue); 
				}
				
				 d1 = new Date(yy1,min-1,dd1);
				 d2 = new Date(yy2,max-1,dd2);			
			}else{
				
				 var startDate1 = _app_params.serviceDate.defStartDate;
				 var endDate = _app_params.serviceDate.defEndDate;

				 var yy1 = startDate1.substring(0,4);
				 var mm1 = startDate1.substring(4,6);
				 var dd1 = startDate1.substring(6,8);
				 
				 var yy2 = endDate.substring(0,4);
				 var mm2 = endDate.substring(4,6);
				 var dd2 = endDate.substring(6,8);		
			 
				 d1 = new Date(yy1,mm1-1,dd1);
				 d2 = new Date(yy2,mm2-1,dd2);
			}

			startDt.setValue(d1);
			endDt.setValue(d2);       
      }   
 
	function getMonthFrom_bak_arr(bak_arr){
		var arr = new Array();
 			var map = new HashMap();
	        	for(var i = 0;i< bak_arr.length;i++){
	        		for(var j = 0;j<31;j++){
		        		var cellIndex = j+4;
//                        alert(cellIndex+ '_'+ j)
		        		var values = bak_arr[i][j].split('_');
		        		var value_day = values[0];
		        		var value = values[1];
						if(value*1 >0){
							map.put(value_day.substring(0,6),value);
						}
	        		}
	        	}
	        	
	        	
	      arr = map.keySet();   
	  
	      arr = arr == null?[]:arr;
	      return arr; 
	}
		
		
		
function save_more_orderDetail(){
	
}


function getSpecificTreeWin() {

	if(!specific_tree_win){

 		var closeFun = function(){
 			specific_tree_win.hide(this);
 		};		

		var btnClose = {text: '关闭',handler: closeFun }; 

		specific_tree_win = new Ext.Window({
			   title : '选择指定',
			   width : 400,
			   height : 500,
			   isTopContainer : true, 
			   modal : true,
			   closeAction:'hide',
			   resizable : false,
			   buttons: [btnClose],
			   contentEl : $("specificTreebox2")
		}); 		

		initSpecificTree();
	}
 	
	specific_tree_win.show(this);
} 



function set_spec_to_grid1(spec_id){
		var apppos_cindex = mygrid1.getColIndexById('apppos');
		var count = mygrid1.selectedRows.length; 
		for(var i = 0; i< count;i++){
			var row_id =  mygrid1.selectedRows[i].idd;
 			mygrid1.cells(row_id,apppos_cindex).setValue(spec_id);
//			mygrid1.setUserData(row_id,"pos",res_obj.resourceMemo)
			reset_mygrid2_row(row_id,1);
		}
}


function initSpecificTree(){
	specific.tree = new Tree("specificTreebox2");  
	var obj_tree = specific.tree.dhtmlTree;	
	obj_tree.setImagePath(ctxPath+"scripts/dhtml/2.6/dhtmlxTree/codebase/imgs/");
	
//	function doOnSelect(itemId){
// 		if(itemId == "root") return false;
//	}
//	obj_tree.setOnClickHandler(doOnSelect);//set function to call on dbl click	
		function doOnDblClick(itemId){
			if(itemId == "root") return false;
			specific_tree_win.hide(this);
			var position = obj_tree.getUserData(itemId,"position");
			set_spec_to_grid1(itemId);
		}
	obj_tree.setOnDblClickHandler(doOnDblClick);
	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	
	var getxml = function(strXML){		
//		obj_tree.deleteChildItems(0);
		obj_tree.loadXMLString(strXML);   
		Ext.getBody().unmask(); 
	}
	
	specific.getSpecificsXML(getxml);
}




function setup(paramObj){


	var urlStr =  ctxPath +"selectPopup/buildMorePara.html?"+$H(paramObj).toQueryString();//$('CNZZ_AD_content_box').src=urlStr;

 	function removeWin(){build_more_paraArray.destroy();} 	
 	function save_more_orderDetail(){save_more_orderDetail();}	
 	function setSelectGridChecked(){ return setSelectGridChecked();}
 		
 	var btnAddResource = {xtype:'button',text: '增加段位',iconCls:'admin-tool-add',handler: function(){
 		displayCompagesTree2(2);} 
 		};

    var btnAddGrid1NewRow = {xtype:'button',text: '增加空行',iconCls:'admin-tool-add',handler: function(){
    	addGrid1NewRow();} }; 

    var btnChoseResource = {xtype:'button',text: '设置段位',iconCls:'admin-tool-add',handler: function(){
 		if(setSelectGridChecked()) displayCompagesTree2(1);} }; 	

 	var btnChoseEdit = {xtype:'button',text: '设置版本',iconCls:'admin-tool-add',handler: function(){
 		if(setSelectGridChecked()) parent.search_adver_cont(1);} 
 	};
 	
 	var btnChoseApp = {xtype:'button',text: '设置指定',iconCls:'admin-tool-add',handler: function(){
 		if(setSelectGridChecked()) getSpecificTreeWin();} }; 
 	
 	var btnChoseArray = {xtype:'button',text: '设置排期',iconCls:'admin-tool-add',handler: function(){
 		if(setSelectGridChecked()) setAutoBroArray();} };

    var btnRemove = {xtype:'button',text: ' 删 除 ',iconCls:'admin-tool-delete',handler: function(){
    	if(setSelectGridChecked()) removeGrid1NewRow();} };


 	
 	var btnSave = {text: '保存',handler: function(){save_more_orderDetail();} };
 	var btnClose = {text: '关闭',handler: function(){removeWin();} };
 	
	var fitterComboBox = report.getFtiterSort('fitter_cmd_id','分组:',120);
	fitterComboBox.on("select",function(cbo){mygrid1.groupBy(cbo.value)},this);	
	fitterComboBox.on("clear",function(){
		mygrid1.unGroup();
//		document.getElementById('openwinMorePara_fram').contentWindow.mygrid2.setSizes();
		},this);	 
	
	
	function call_bak_fun(select){
		select.options[1].remove();
	}
	var def_orderModCategoryParam = $("categoryId").value; //config_orderModCategoryParam
	var cateMain_com = _make_order_cateMain_select(orgId,"categoryId_for_paraArray",reset_orderCategoryMain,call_bak_fun,def_orderModCategoryParam,80);
	
	var paymoney_text = "<div id='paymoney_for_paraArray_div'>金额<input type='text' id='paymoney_for_paraArray' size=6 style='height:16'/></div>"
	
	var tbar =[btnAddResource,btnAddGrid1NewRow,btnChoseResource,btnChoseEdit,btnChoseApp,btnChoseArray,btnRemove,fitterComboBox,cateMain_com,paymoney_text];
	
	
//	fitterComboBox.on()

    build_more_paraArray = new Ext.Window({
            	id:'moduleIdwinMoreParaArray',
            	title:'播出',
                //applyTo:'print-win',
//                renderTo: desktopEl,
                 modal:true,
                layout:'fit',
                width:1024,
                height:600,
                closeAction:'destroy',
                plain: false,
				tbar:tbar,
				x:report.getWinX(1024),
				y:report.getWinY(600),
				minimizable:true,
				maximizable: false,
//                items: {html:applet},
    			html:"<iframe id='openwinMorePara_fram' src='"+ urlStr +"' scrolling='auto' style='width:100%;height:100%;margin:0;padding:0'></iframe>",    
    			buttonAlign:"left",
                buttons: [btnSave,btnClose]
            });
//        }		


   build_more_paraArray.show();
}

		
		