//实例化对象

var incomePull = new IncomePull();
var payment = new PayMent();
var customer = new Customer();
var category = new Category();
var incomeUsed = new IncomeUsed();
var popupcenter = new Popupcenter();
var user =new User();

var cur_userId;
var mygrid_pull;
var mygrid_payment;
var channelParam;
var income_year;
var order_year;
var config_serviceDate;
var findOrderCode = false;
var findContractCode = false;
var displayBalanceDetail = false;
var tag_orderList_finance;
var config_isSignUserBalance;




callOnLoad(init);	


function init(){ 
	winHeight = self.innerHeight*0.33; 
	get_cur_year();
	channelParam = $("config_channelPullParam").value;
	channelParam = (channelParam == ""||channelParam == null)?0:channelParam;
	userName = $("config_username").value;
	config_fztvSpecialParam = $("config_fztvSpecialParam").value;
	tag_orderList_finance = $("tag_orderList_finance").value;
	config_isSignUserBalance = $("config_isSignUserBalance").value;
	config_isSignUserBalance = (config_isSignUserBalance == ""||config_isSignUserBalance == null)?0:config_isSignUserBalance;
	config_useCarrierAliname = $("config_useCarrierAliname").value;
	config_useCarrierAliname = (config_useCarrierAliname == ""||config_useCarrierAliname == null)?0:config_useCarrierAliname;
	tvNameParam = $("config_tvNameParam").value;
	
	
	user.getCurUserId(userName,function(id){cur_userId = id;});	
	resetHeigth();	
	setIncomePullPara(incomePull);
	setPayMentPara(payment);
	setCustomerPara(customer);
//	setCategoryPara(category);
	setIncomeCountPara(payment);
	setIncomeUsedPara(incomeUsed);
	
	
// 	customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
 	initGrid_incomPull();
 	
 	if(tvNameParam =='xmtv'){
 		initGrid_payment2();
 	}else{
 		initGrid_payment();
 	}
 	
 	
 	changeButton(true);

 	buttonEventFill();
 	
// 	doOnSelectedTree();

 	var customerId = getParamFromUrl(window.location.href,"customerId");
 	$("customerId").value = customerId; 
 	
	getTables(customerId);	
	
 	var fun = function(){
 		if(customerId > 0) {
 			 Ext.getCmp("customerName").setValue(customerId);
 		}
 	}
 	getCustomerTree(fun);
 		
 	
 	
// 	 	
// 	var customerId = getParamFromUrl(window.location.href,"customerId");
// 	
// 	var fun = function(){
//	 	
//	 	if(customerId > 0){
//	 		$("customerId").value = customerId;
//	 		doOnSelectedTree(customerId);
////	 		var customerId = Ext.getCmp("customerName").getValue();
//	 	
////	 		doOnSelectedTree(customerId);
////	 		 getSelectCustomerToTree();
//	 	}
// 	}
// 	
// 	getCustomerTree(fun);
 	
 	
 	
 	//$("orderCode").disabled = false;
 	//$("orderCode").setAttressbut("orderCode",)
}


function resetHeigth(){
	var dialogcontent = $("dialogcontentDiv");
	
//	var treebox = $("categoryTreebox");
//	treebox.style.height = dialogcontent.offsetHeight*0.82+"px";	   	
//	$("customerName").style.width =treebox.offsetWidth*0.74 +"px";
	
	$("gridbox_incomePull_div").style.height = dialogcontent.offsetHeight*0.82*0.3 +"px";	
	$("gridbox_payment_div").style.height = dialogcontent.offsetHeight*0.82*0.6 +"px";
} 
 
 
function setIncomeCountPara(obj){
	
	 var page=Math.round(winHeight* 0.80/20)-2;
	 obj.className  = "IncomeCount";	
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= page;
	 obj.page = new Page(obj.pageInfo,obj.pageSize);	
}

function get_cur_year(){
	config_serviceDate = $("config_serviceDate").value;
	var yyyy = getDayPar(config_serviceDate,'y');
	setSelectByValue($("income_year"),yyyy);
	setSelectByValue($("order_year"),yyyy);
	
	income_year = $("income_year").value;
	order_year = $("order_year").value;
}

function getIncomeById(incomeId){
	popupcenter.url = "editIncome.html?id="+incomeId;
	popupcenter.model = 10;
	popupcenter.popupcenter(popupcenter);	
}

function closePopup(ev){
	popupcenter.closePopup(popupcenter);
}

function initGrid_incomPull(){
	mygrid_pull = new dhtmlXGridObject('gridbox_incomePull');
	mygrid_pull.selMultiRows = true;
	mygrid_pull.setImagePath("image/grid/");
	
	//mygrid_pull.flds = "选择,到款日期,频道名称,付款编号,业务员,划账金额,剩余金额,划归日期,备注";
	mygrid_pull.flds = "选择,到款日期,频道名称,付款编号,业务员,划账金额,剩余金额,划归年份";
	mygrid_pull.newHeads = mygrid_pull.flds.split(",");
	mygrid_pull.setHeader(mygrid_pull.flds);
	var columnIds = "incomePullId,payDate,carrierName,payCode,signUser,incomeMoney,releaveMoney";
	mygrid_pull.setColumnIds(columnIds);

	//mygrid_pull.setInitWidthsP("5,15,15,15,13,13,13,13,11");
	mygrid_pull.setInitWidthsP("5,15,15,15,13,13,12,12");
	mygrid_pull.setColAlign("center,left,left,left,center,right,right,center,left");
	//mygrid_pull.setColTypes("ch,ro,ro,link,ro,ro,ro,ro,ro");
	mygrid_pull.setColTypes("ch,ed,ed,link,ed,ed,ed,ed");
	//mygrid_pull.setColSorting("str,date,str,str")
    
    mygrid_pull.setOnRowSelectHandler(onRowSelectedPullGird,true);
//	mygrid_pull.setMultiLine(false);
	mygrid_pull.setEditable(true);
	mygrid_pull.setOnEditCellHandler(onEditPullGridCellHandler);
//	mygrid_pull.enableAutoHeigth(true);
//	mygrid_pull.enableLightMouseNavigation(true);
//	mygrid_pull.enableKeyboardSupport(true);
//	mygrid_pull.enableMathEditing(true);
	
//	mygrid_pull.enableDragAndDrop(false);
	mygrid_pull.enableAlterCss("even","uneven"); 
	mygrid_pull.setSkin("modern2");

	mygrid_pull.init();	 
	resetHead(mygrid_pull,1);
}

function onEditPullGridCellHandler(stage, rowId, cellInd, newValue, oldValue){
   var state = getRadioValue($("chooseCN").parentNode.parentNode);		
   if(state == 2){
		var cell = mygrid_pull.cells(rowId,0);
		var v = cell.getValue()==0?1:0;
		cell.setValue(v);
   }
		
	if(state == 1 && cellInd ==6) return true;
}


function initGrid_payment(){
	mygrid_payment = new dhtmlXGridObject('gridbox_payment');
	mygrid_payment.selMultiRows = true;
	mygrid_payment.setImagePath("image/grid/");
	
	mygrid_payment.flds = "选择,订单编号,合同编号,广告名称,付款次数,付款日期,应付金额,平账金额";
	mygrid_payment.newHeads = mygrid_payment.flds.split(",");
	mygrid_payment.setHeader(mygrid_payment.flds);
	var columnIds = "paymentId,orderCode,contractCode,matterName,payNum,payDay,payMoney,balanceMoney";
	mygrid_payment.setColumnIds(columnIds);

	mygrid_payment.setInitWidthsP("5,12,12,23,12,12,12,12");
	mygrid_payment.setColAlign("center,left,left,left,left,center,right,right");
	mygrid_payment.setColTypes("ch,link,ro,ro,ro,ro,ro,ro");
	//mygrid_pull.setColSorting("str,date,str,str")
    
    mygrid_payment.setOnRowSelectHandler(onRowSelectedPaymentGrid,true);
	mygrid_payment.setMultiLine(false);
	mygrid_payment.setEditable(true);
//	mygrid_payment.enableDragAndDrop(false);
	mygrid_payment.setSkin("modern2");
	mygrid_payment.enableAlterCss("even","uneven"); 
	mygrid_payment.init();	 
	resetHead(mygrid_payment,2);
}



function initGrid_payment2(){
	mygrid_payment = new dhtmlXGridObject('gridbox_payment');
	mygrid_payment.selMultiRows = true;
	mygrid_payment.setImagePath("image/grid/");
	
	mygrid_payment.flds = "选择,订单编号,合同编号,广告名称,付款次数,付款日期,应付金额,平账金额,划归部门";
	mygrid_payment.newHeads = mygrid_payment.flds.split(",");
	mygrid_payment.setHeader(mygrid_payment.flds);
	var columnIds = "paymentId,orderCode,contractCode,matterName,payNum,payDay,payMoney,balanceMoney,branch";
	mygrid_payment.setColumnIds(columnIds);

	mygrid_payment.setInitWidthsP("5,12,12,18,12,12,12,12,5");
	mygrid_payment.setColAlign("center,left,left,left,left,center,right,right,center");
	mygrid_payment.setColTypes("ch,link,ro,ro,ro,ro,ro,ro,ro");
	//mygrid_pull.setColSorting("str,date,str,str")
    
    mygrid_payment.setOnRowSelectHandler(onRowSelectedPaymentGrid,true);
	mygrid_payment.setMultiLine(false);
	mygrid_payment.setEditable(true);
//	mygrid_payment.enableDragAndDrop(false);
	mygrid_payment.setSkin("modern2");
	mygrid_payment.enableAlterCss("even","uneven"); 
	mygrid_payment.init();	 
	resetHead2(mygrid_payment,2);
}





function onRowSelectedPullGird(id,cellInd){
	
//	if(tvNameParam!='xmtv'){
//		var state = getRadioValue($("chooseCN").parentNode.parentNode);
//		var type = this.getUserData(id,"type");
//		
//		//if(state ==2 && type == 1) return false;
//		
//		var cell = this.cells(id,0);
//		var v = cell.getValue()==0?1:0;
//		cell.setValue(v);
//		
//		if(type == 1){
//			getCarrieridsPullids(this,id,v,1);
//		}
//		
//		if(v == 0)  getPayments();
//	}else{ 
//		
//		
//		var cell = this.cells(id,0);
//		var v = cell.getValue()==0?1:0;
//		cell.setValue(v);
//	}

		var state = getRadioValue($("chooseCN").parentNode.parentNode);
		var type = this.getUserData(id,"type");

  

   if(state == 2){
		var cell = this.cells(id,0);
		var v = cell.getValue()==0?1:0;
		cell.setValue(v);
   }

	
	if(tvNameParam!='xmtv' && tvNameParam!='catv'){
		getPayments();
	}

}

function onRowSelectedPaymentGrid(id){
		var cell = this.cells(id,0);
		var v = cell.getValue()==0?1:0;
		cell.setValue(v);
}

function getCarrieridsPullids_allcheckbox(grid){
	var rows = grid.getRowsNum();
	var obj = $("incPullAllSelect");
	//payment.obj.carrierIds = new Array();
	//payment.obj.incPullIds = new Array();
	//payment.obj.userIds = new Array();

	
	
	
	for(var i=0; i< rows;i++){
		var ch =  grid.cells2(i,0);
		//var row = grid.getRowByIndex(i);
		
		//alert(row);
		
		//var ch = row[0];
		var rowId = grid.getRowId(i);
		
		var v = obj.checked;
	
		if(grid.getRowByIndex(i).style.display ==""){
		     ch.setValue(v);
		}else{
		     ch.setValue(0);
		} 
	}
	
	getCarrieridsPullids(grid,0,v,2);
	
	//alert(payment.obj.carrierIds);
	//alert(payment.obj.incPullIds);		
}

function getCarrieridsPullids(grid,id,v,from){
	var pid = id;
	var cid = mygrid_pull.getUserData(id,"resourceCarrierId");
	var uid = mygrid_pull.getUserData(id,"userId");
	var changed = false;
	var uchanged = false;
	var state = getRadioValue($("chooseCN").parentNode.parentNode);
	
	if(from == 1 && v == 1){
		if(payment.obj.carrierIds.indexOf(cid)==-1){
			payment.obj.carrierIds.push(cid);
		    if(state==1) changed = true;
		}
		if(payment.obj.incPullIds.indexOf(pid)==-1){
			payment.obj.incPullIds.push(id);
			if(state==2) changed = true;
		}
		if(payment.obj.userIds.indexOf(uid)==-1){
			payment.obj.userIds.push(uid);
//			changed = true;
//			uchanged = true;
		}
	}else{
	
		
		var o_pid;var o_cid;var o_uid;
		if(id > 0){
			var o_pid = id;
			var o_cid = mygrid_pull.getUserData(id,"resourceCarrierId");
			var o_uid = mygrid_pull.getUserData(id,"userId");
		}
		
		if(v == 0){
	      		changed = (payment.obj.carrierIds.indexOf(o_cid)>-1) && state==1?true:false;
			//changed = (payment.obj.incPullIds.indexOf(o_pid)>-1) && state==2?true:false;
//			changed = (payment.obj.userIds.indexOf(o_uid)==-1)?true:false;
//			uchanged = (payment.obj.userIds.indexOf(o_uid)==-1)?true:false;			
			
		}
		//alert(changed);
		payment.obj.carrierIds.clear();
		payment.obj.incPullIds.clear();
		payment.obj.userIds.clear();
		

		for(var i=0; i< grid.getRowsNum();i++){
			
			var v  =  grid.cells2(i,0).getValue();
			var id = grid.getRowId(i);
			var cid = mygrid_pull.getUserData(id,"resourceCarrierId");
			var uid = mygrid_pull.getUserData(id,"userId");
			var isVisiable = grid.getRowByIndex(i).style.display =="";
			
			if(payment.obj.carrierIds.indexOf(cid)==-1 && isVisiable && v==1){
				payment.obj.carrierIds.push(cid);
				if(state == 1) changed = true;
			}
			if(payment.obj.incPullIds.indexOf(id)==-1 && isVisiable && v==1){
				payment.obj.incPullIds.push(id);
				if(state == 2) changed = true;
			}
			if(payment.obj.userIds.indexOf(uid)==-1 && isVisiable && v==1){
				payment.obj.userIds.push(uid);
//				changed = true;
//				uchanged = true;
			}
		}

		
		
		  
		  
//		var index1 = payment.obj.carrierIds.indexOf(cid);
//		if(payment.obj.carrierIds.indexOf(cid)>-1){
//			payment.obj.carrierIds.remove(index1);
//			changed = true;
//		}
//		var index2 = payment.obj.incPullIds.indexOf(id);
//		if(payment.obj.incPullIds.indexOf(id)>-1){
//			payment.obj.incPullIds.remove(index2);
//			changed = true;
//		}
//		var index3 = payment.obj.userIds.indexOf(uid);
//		if(payment.obj.userIds.indexOf(id)>-1){
//			payment.obj.userIds.remove(index3);
//			changed = true;
//		}			  
	
	
	}
	
	//alert(from);
	var state = getRadioValue($("chooseCN").parentNode.parentNode);
	//来源选择
	if(from == 1 && changed && (channelParam != 0 || (channelParam != 0 &&  state == 2) ))  getPayments();
	if(from == 2 && channelParam != 0 )   getPayments();
	
//	if(changed && (channelParam != 0 || uchanged))  getPayments();
		

}


Array.prototype.remove=function(dx)
　{
　　if(isNaN(dx)||dx>this.length){return false;}
　　for(var i=0,n=0;i<this.length;i++)
　　{
　　　　if(this[i]!=this[dx])
　　　　{
　　　　　　this[n++]=this[i]
　　　　}
　　}
　　this.length-=1
　}

function resetHead(grid,type){	
         
	if(type == 2){
		
		attachHeaderNew(grid,"<center><input type='checkBox' id='paymentAllSelect' value='0' onclick= 'javascript:selectCheckBoxAll(2)'></center>,<input type='text' id='orderCode' style='width:110%;CURSOR: pointer;' onclick=this.value=''  value='订单编号'>, <input type='text' id='contractCode' style='width:110%;CURSOR: pointer;' onclick=this.value=''  value='合同编号'>,#rspan,#rspan,#rspan,#rspan,#rspan");
	}else{
		attachHeaderNew(grid,"<center><input type='checkBox' id='incPullAllSelect' value='0' onclick= 'javascript:selectCheckBoxAll(1)'></center>,<div id='paydt_flt'></div>,<div id='title_flt'></div>,<div id='author_flt'></div>,<div id='signuser_flt'></div>,#rspan,#rspan,<div id='pulldate_flt'></div>,#rspan");
	    //$("incPullAllSelect").onclick= selectCheckBoxAll;
	    //$("paymentSelect").onclick= selectCheckBoxAll;
		//create second header row
		//mygrid_pull.attachHeader("<input type='checkBox' id='incPullAllSelect>,<div id='paydt_flt'></div>,<div id='title_flt'></div>,<div id='author_flt'></div>,#rspan,#rspan");
		authFlt1 = document.getElementById("paydt_flt").appendChild(document.getElementById("paydt_flt_box").childNodes[0])
		//append filter for 2nd column
		authFlt2 = document.getElementById("title_flt").appendChild(document.getElementById("title_flt_box").childNodes[0]);
		//append filter for 3rd column
		authFlt3 = document.getElementById("author_flt").appendChild(document.getElementById("author_flt_box").childNodes[0]);
		
		authFlt4 = document.getElementById("signuser_flt").appendChild(document.getElementById("signuser_flt_box").childNodes[0]);
		
		authFlt7 = document.getElementById("pulldate_flt").appendChild(document.getElementById("pulldate_flt_box").childNodes[0]);
	
		restHeadComnand();
	}

}


function resetHead2(grid,type){	
         
	if(type == 2){
		
		attachHeaderNew(grid,"<center><input type='checkBox' id='paymentAllSelect' value='0' onclick= 'javascript:selectCheckBoxAll(2)'></center>,<input type='text' id='orderCode' style='width:110%;CURSOR: pointer;' onclick=this.value=''  value='订单编号'>, <input type='text' id='contractCode' style='width:110%;CURSOR: pointer;' onclick=this.value=''  value='合同编号'>,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan");
	}else{
		attachHeaderNew(grid,"<center><input type='checkBox' id='incPullAllSelect' value='0' onclick= 'javascript:selectCheckBoxAll(1)'></center>,<div id='paydt_flt'></div>,<div id='title_flt'></div>,<div id='author_flt'></div>,<div id='signuser_flt'></div>,#rspan,#rspan,<div id='pulldate_flt'></div>,#rspan,#rspan");
	    //$("incPullAllSelect").onclick= selectCheckBoxAll;
	    //$("paymentSelect").onclick= selectCheckBoxAll;
		//create second header row
		//mygrid_pull.attachHeader("<input type='checkBox' id='incPullAllSelect>,<div id='paydt_flt'></div>,<div id='title_flt'></div>,<div id='author_flt'></div>,#rspan,#rspan");
		authFlt1 = document.getElementById("paydt_flt").appendChild(document.getElementById("paydt_flt_box").childNodes[0])
		//append filter for 2nd column
		authFlt2 = document.getElementById("title_flt").appendChild(document.getElementById("title_flt_box").childNodes[0]);
		//append filter for 3rd column
		authFlt3 = document.getElementById("author_flt").appendChild(document.getElementById("author_flt_box").childNodes[0]);
		
		authFlt4 = document.getElementById("signuser_flt").appendChild(document.getElementById("signuser_flt_box").childNodes[0]);
		
		authFlt7 = document.getElementById("pulldate_flt").appendChild(document.getElementById("pulldate_flt_box").childNodes[0]);
	
		restHeadComnand();
	}

}
function selectCheckBoxAll(type){
//	var e = event || window.event;
//	var obj = Event.element(e);	
	var obj;var grid;
	
	var state = getRadioValue($("chooseCN").parentNode.parentNode);
//	if(state == 2 && type == 1) return false;	
	
	if(type == 2){
		obj = $("paymentAllSelect");	
		grid = mygrid_payment;		
	}else{
		obj = $("incPullAllSelect");
		grid = mygrid_pull;	
	}
	var col = obj.value;
	var rows = grid.getRowsNum();
	
	for(var i=0; i< rows;i++){
		var ch =  grid.cells2(i,0);
		if(grid.getRowByIndex(i).style.display ==""){
		     ch.setValue(obj.checked);
		}else{
		     ch.setValue(0);
		} 
	}	
	
	
	if(type == 1) {
		getCarrieridsPullids_allcheckbox(mygrid_pull);
		//getPayments();
	}
	

}



function attachHeaderNew(grid,htm){
	var h = htm.split(",");
	//alert(h.length);
	var z =  grid.hdr.rows[1];
	
	for(var cin = 0; cin<h.length;cin++){
		if(h[cin].indexOf("#rspan") != 0) {
			var c = z.cells[z._childIndexes?z._childIndexes[parseInt(cin)]:cin];
			c.innerHTML = h[cin];		
		}

	}
	
}






function restHeadComnand(){
	populateSelectWithAuthors(authFlt1,1);
	populateSelectWithAuthors(authFlt2,2);
	populateSelectWithAuthors(authFlt3,3);
	populateSelectWithAuthors(authFlt4,4);
	populateSelectWithAuthors(authFlt7,7);
}

//filter grid contnet based on values of two filter fields
	function filterBy(){
		var pVal = document.getElementById("paydt_flt").childNodes[0].value.toLowerCase();
		var tVal = document.getElementById("title_flt").childNodes[0].value.toLowerCase();
		var aVal = document.getElementById("author_flt").childNodes[0].value.toLowerCase();
		var uVal = document.getElementById("signuser_flt").childNodes[0].value.toLowerCase();
		var dVal = document.getElementById("pulldate_flt").childNodes[0].value.toLowerCase();

		for(var i=0; i< mygrid_pull.getRowsNum();i++){
			var id = mygrid_pull.getRowId(i);
			var pStr = mygrid_pull.cells2(i,1).getValue().toString().toLowerCase();
//			var tStr = mygrid_pull.cells2(i,2).getValue().toString().toLowerCase();
			var tStr = mygrid_pull.getUserData(id,"resourceCarrierId");
			var aStr = mygrid_pull.getUserData(id,"incomeCode");
//			var aStr = mygrid_pull.cells2(i,3).getValue().toString().toLowerCase();
//			var uStr = mygrid_pull.cells2(i,4).getValue().toString().toLowerCase();
			var uStr = mygrid_pull.getUserData(id,"userId");
			var dStr = mygrid_pull.cells2(i,7).getValue().toString().toLowerCase();
			
			//if((tVal=="" || tStr != tVal) && (aVal=="" || aStr != aVal)){
			if((pVal=="0" || pStr.indexOf(pVal)==0) &&(tVal=="0" || tStr==tVal) && (aVal=="0" || aStr.indexOf(aVal)==0)
			&& (uVal=="0" || uStr.indexOf(uVal)==0)&& (dVal=="0" || dStr.indexOf(dVal)==0)){
				//alert(aVal); alert(aStr)
				mygrid_pull.setRowHidden(mygrid_pull.getRowId(i),false);
			}else{
				mygrid_pull.setRowHidden(mygrid_pull.getRowId(i),true);
				//隐藏的行要清除复选框
				//alert(mygrid_pull.cells2(i,0).getValue());
				//mygrid_pull.cells2(i,0).setValue(false);	
				
			}
		}
		
		
		
		selectCheckBoxAll(1);
		//alert("1<<<<<"+payment.obj.userIds);
		getSelectedValueFromHead();
		//alert("2<<<<<"+payment.obj.userIds);
	}
	
	function getSelectedValueFromHead(){
			var signUserId = $("signUserId").value;
			mygrid_pull.signUserId = signUserId > 0?signUserId:0;
			
			if(signUserId > 0){
				payment.obj.userIds.clear();
				payment.obj.userIds.push(signUserId);
			}
			
			
			var carrierId = $("carrierId").value;
			mygrid_pull.carrierId = carrierId > 0?carrierId:0;
			if(carrierId > 0){
				payment.obj.carrierIds.clear();
				payment.obj.carrierIds.push(carrierId);
			}
			
	}
	function setSelectedValueFromHead(col){
		if(col == 4){
			if(mygrid_pull.signUserId>0){
				$("signUserId").value = mygrid_pull.signUserId;
				filterBy();
			}
		}
		if(col == 2){
			if(mygrid_pull.carrierId>0){
				$("carrierId").value = mygrid_pull.carrierId;
				filterBy();
			}
		}		
		
	}	
	
	//populate filter select box with possible column values
	function populateSelectWithAuthors(selObj,col){
		DWRUtil.removeAllOptions(selObj);
		var opt = new Option("=="+mygrid_pull.newHeads[col] +"==","0");
		//opt.style = "align:center";
		selObj.options.add(opt);
		var usedAuthAr = new dhtmlxArray();
		for(var i=0;i<mygrid_pull.getRowsNum();i++){
			var id = mygrid_pull.getRowId(i);
			var authNm = replace(mygrid_pull.cells2(i,col).getValue());
			if(col == 3){
				 authNm = mygrid_pull.getUserData(id,"incomeCode");
			}
			var authVal  = authNm;
			
			if(col == 4) authVal = mygrid_pull.getUserData(id,"userId");
			if(col == 2) authVal = mygrid_pull.getUserData(id,"resourceCarrierId");
			
			
						
			if(usedAuthAr._dhx_find(authNm)==-1){
				selObj.options.add(new Option(authNm,authVal));
				usedAuthAr[usedAuthAr.length] = authNm;
			}
		}
		setSelectedValueFromHead(col);
	}
	
function replace(s){
	var index = s.indexOf("^");
	if(index >-1 ) s = s.substring(0,index);
	return s;
}

//function getCustomerTree(obj,callBackFun){
//	var obj_tree = obj.tree.dhtmlTree;
//	obj_tree.setOnClickHandler(doOnSelectedTree);
//	obj_tree.enableDragAndDrop(false);	
//	obj_tree.enableMercyDrag(true);
//	obj_tree.enableThreeStateCheckboxes(true);
//	obj.reset();
//	function getxml(treeXML){
//		obj_tree.loadXMLString(treeXML);
//		if(callBackFun) callBackFun();
//	} 
//	obj.getCategoryTreeXML(obj,customer.IdPrefix,getxml);
//}

function getCustomerTree(fnct){
   customer.obj.customerName = 'local';
   var storeCustomer = customer.getStoreCustomersAnalyze('local',customer.obj);    
   var customerCommand =new Ext.form.ComboBox({
	 	  id:'customerName',
	 	  name:'customerName',
		  renderTo:'extCustomerDiv2',
		  tiggerAction:'all',
		  store:storeCustomer,
		  editable: true,
		  triggerAction: 'all', //query all
		  lastQuery:'l',
		  displayField:'customerName',
		  valueField:'id',
		  mode:'local',
		  allowBlank:false,
		   width:200,
		   forceSelection:false, 
		  allowBlank:false,
		  emptyText:'请选择...',
		  minChars:2,
		  hiddenName:'helpCode', //提交传过去的值 
		   params:customer.obj,
		  listeners:{beforequery:customer.comboFilterBy.createDelegate(this)}	
	 });
	 
	 
	 customerCommand.on("select" , function(box)
    {
//        alert(box.getValue() + "-" + box.getRawValue());
        var customerId = box.getValue();
        getTables(customerId);	 	
//	 		var customerId = Ext.getCmp("customerName").getValue();
 
    });
    
    storeCustomer.on("load",function(){
    	if(fnct) fnct();
    })
	 
} 

function buttonEventFill(){
	  
	var btn_chooseCN = $("chooseCN"); 
	btn_chooseCN.onclick = getTowTables;
	
	var btn_chooseCN2 = $("chooseCN2");
	btn_chooseCN2.onclick = getTowTables;

	var btn_search = $("btn_search");
	btn_search.onclick = saveIncomeUsed2;
	
	var btn_putBack = $("btn_putBack");
	btn_putBack.onclick = saveIncomeUsed2;
	
	
	var btn_cancel = $("btn_cancel");
	btn_cancel.onclick = cancelIncomePull;
	
	
//	var Btn_customerName = $("customerName");
//	Btn_customerName.onclick = resetText;
//	Btn_customerName.onkeypress = getCustomerAutoCompltByName;
	
	
	$("income_year").onchange = getIncomePulls;
	$("order_year").onchange = getPayments;
	
	
	var Btn_orderCode = $("orderCode");
	Btn_orderCode.onkeypress = getPayments_keyPress1;
	Btn_orderCode.onblur = clear_orderCode;
	
	var Btn_contractCode = $("contractCode");
	Btn_contractCode.onkeypress = getPayments_keyPress2;
	Btn_contractCode.onblur = clear_contractCode;
	
	
	var btn_displayBalanceDetail = $("displayBalanceDetail");
	btn_displayBalanceDetail.onchange = function(){displayBalanceDetail = btn_displayBalanceDetail.checked;}
	
	document.body.onfocus = closePopup;
	
}

function clear_orderCode(){
	findOrderCode = false;
	$("orderCode").value = "订单编号";
}

function clear_contractCode(){
	findContractCode = false;
	$("contractCode").value = "合同编号";
}


function cancelIncomePull(){
    parent.location.href =document.referrer;
}

function getSelectCustomerToTree(){
	var id = $("customerId").value;
	var parentId = category.tree.getItemIdByIndex(0);
	category.tree.dhtmlTree.closeAllItems(parentId);
	category.tree.dhtmlTree.selectItem(customer.IdPrefix+id,true);
	category.tree.dhtmlTree.focusItem(customer.IdPrefix+id);
}




function setallCheckFalse(type){
	var allCheckobj;
	if(type == 1) {
		allCheckobj = $("incPullAllSelect");	
	}else{
		allCheckobj = $("paymentAllSelect");
	}
	
	
	allCheckobj.checked = false;	
}


function getTables(customerId){
	
	$("signUserId").value = 0;
	$("carrierId").value = 0;
    
//    alert(customerId);
    
	if(customerId > 0){
		$("customerId").value = customerId;
//		var o = customer.getCustomer(customerId);
//		var categoryId = o.customerCategoryId;
		mygrid_payment.clearAll();mygrid_pull.clearAll();
		//mygrid_payment.clearAll();
		//setallCheckFalse();
		getTowTables();
	}

}


//function doOnSelectedTree(selectItemId){
//	
//	$("signUserId").value = 0;
//	$("carrierId").value = 0;
//	
//	var type = category.tree.dhtmlTree.getUserData(selectItemId,"type");
//
//	 if(type == 0 || type == 1){
////		$("customerName").value = '';
//		$("customerId").value = '0';
//		mygrid_payment.clearAll();mygrid_pull.clearAll();
//	}
//
//	if(type == 2){
//		var customerId = category.tree.dhtmlTree.getUserData(selectItemId,"id");
//
//		$("customerId").value = customerId;
//		var o = customer.getCustomer(customerId);
//		var categoryId = o.customerCategoryId;
//		mygrid_payment.clearAll();mygrid_pull.clearAll();
//		//mygrid_payment.clearAll();
//		//setallCheckFalse();
//		getTowTables();
//	}
//
//}

function checkBalanceYear(grid){
	var orderYear = $("order_year").value;
	
	var pullSelectedId = mygrid_pull.getSelectedId();
	
	var pullYear = mygrid_pull.cells(pullSelectedId,7).getValue();
	
//	alert(pullSelectedId);alert(pullYear);
	
	if(orderYear != pullYear ){
		return true;
	}else{
		return false;  
	}
	
//	var years = new Array();
//	for(var i=0; i< grid.getRowsNum();i++){
//		var v = grid.cells2(i,0).getValue();
//		if(v == 1)years.push(grid.cells2(i,7).getValue());
//	}
//	
//	if(!years.contains(orderYear)){
//		 return true;
//	}else{
//		 return false;
//	}
}

function saveIncomeUsed_bak(){
	var state = getRadioValue($("chooseCN").parentNode.parentNode);
	
	
	var paymentIds = getPayMentIds(mygrid_payment);
	var pullIds = getPayMentIds(mygrid_pull);
	var incomeId = 0;
	var paymentObjs = new Array();
	
	function callBack(s){
			getTowTables();
			$("btn_search").disabled=false;
			$("btn_putBack").disabled=false;
	}
	
	if(state == 1){
		
		if(pullIds.length <1){
			alert("请选择需要分配的到款记录!");
			return false;
		}
		if(paymentIds.length <1){
			alert("请选择需要分配的付款记录!");
			return false;
		}
		
		if(checkBalanceYear(mygrid_pull)){
//			alert("到款划归年份与订单年份不一致，请检查!");
		    var msg = "到款划归年份与订单年份不一致,是否继续分配到款 ?";
		    ans = confirm(msg);			
			if (ans) {
//		        return true;
		    } else {
		        return false;
		    }
//			return false;
		}
		

		for(var i=0; i< mygrid_pull.getRowsNum();i++){
			
			var v = mygrid_pull.cells2(i,0).getValue();
			
			if(v == 1 ){
				var paymentObj = new PayMent();
				var incomePullId = mygrid_pull.getRowId(i);
				var incomeId = mygrid_pull.getUserData(incomePullId,"incomeId");
				var balanceMoney = mygrid_pull.cells2(i,6).getValue();
				var version = mygrid_pull.cells2(i,7).getValue();
				var carrierId = mygrid_pull.getUserData(incomePullId,"resourceCarrierId");
				
				if(carrierId =="") carrierId = 0;
				if(balanceMoney  =="") balanceMoney  = 0;
				//alert("paymentIds["+ paymentIds +">");alert("pullId<"+ pullId +">");alert("balanceMoney<"+ balanceMoney +">");alert("carrierId<"+ carrierId +">");
				if (balanceMoney > 0){
					paymentObj.obj.paymentIds = paymentIds;
					paymentObj.obj.incomePullId = incomePullId*1;
					paymentObj.obj.incomeId = incomeId;
					paymentObj.obj.version=version;
					paymentObj.obj.userId = cur_userId;
					paymentObj.obj.moneyPay = balanceMoney*1;
					paymentObj.obj.carrierId = carrierId*1;
					paymentObjs.push(paymentObj.obj);
//					payment.savePutonMoney(paymentIds,balanceMoney,incomeId,incomePullId,carrierId,callBack);
                                }
				
			}
			
		}
		
		if(paymentObjs.length >0){
			$("btn_search").disabled=true;
			payment.savePutonMoneyByObj(paymentObjs,callBack);
		}else{
			alert("请选择需要分配的到款记录!");
			return false;
		}
		
	}else{
		
		//var paymentIds = getPayMentIds();
		
		//if(paymentIds.length <1){
			//alert("请选择需要返还的付款记录!");
			//return false;
		//}
		
		if(pullIds.length > 0){
			for(var i=0; i< pullIds.length;i++){
					var paymentObj = new PayMent();
					//paymentObj.obj.paymentIds = paymentIds;
					paymentObj.obj.incomePullId = pullIds[i]*1;
	//				paymentObj.obj.moneyPay = balanceMoney*1;
	//				paymentObj.obj.carrierId = carrierId*1;
					paymentObjs.push(paymentObj.obj);				
			}
		}else{
				var paymentObj = new PayMent();
				paymentObj.obj.incomePullId = 0;
				paymentObj.obj.paymentIds = paymentIds;
				paymentObjs.push(paymentObj.obj);
		}
		
		if(pullIds.length == 0 && paymentIds.length == 0){
			alert("请先选择要返还的记录,再点返还!");
			return false;
		}
		$("btn_putBack").disabled=true;
		payment.saveBackPaymentMoneyByObj(paymentObjs,callBack);

	}
}



function saveIncomeUsed2(){
	var state = getRadioValue($("chooseCN").parentNode.parentNode);
	var pullIds = getPayMentIds(mygrid_pull);
	var paymentIds = getPayMentIds(mygrid_payment);
	var pullId = mygrid_pull.getSelectedId();
	
	var incomeId = 0;
	var paymentObjs = new Array();
	

    
//    if(pullId ==0 ||pullId == ''||pullId == null ||pullId == 'null'){
//    	if(mygrid_pull.getRowsNum()>0){
//		    var r = mygrid_pull.getRowByIndex(0);
//		    mygrid_pull.selectRow(r);
//		    pullId = mygrid_pull.getSelectedId();   		
//    	}else{
//    		return false;
//    	}
//
//    }

	
	function callBack(s){
			getTowTables();
			$("btn_search").disabled=false;
			$("btn_putBack").disabled=false;
	}
	
	if(state == 1){
		
		if(pullId ==0 ||pullId == ''||pullId == null ||pullId == 'null'){
			alert("请选择需要分配的到款记录!");
			return false;
		}
		if(paymentIds.length <1){
			alert("请选择需要分配的付款记录!");
			return false;
		}
		
		
		if(checkBalanceYear(mygrid_pull)){
//			alert("到款划归年份与订单年份不一致，请检查!");
		    var msg = "到款划归年份与订单年份不一致,是否继续分配到款 ?";
		    ans = confirm(msg);			
			if (ans) {
//		        return true;
		    } else {
		        return false;
		    }
//			return false;
		}
		
		
//			tring year = payment.getVersion().toString();
//			String resourceType = payment.getMemo();
//			String carrierId = payment.getCarrierId().toString();
//			String userId = payment.getUserId().toString();
//			String incomeId = payment.getIncomeId().toString();
//			String pullId = payment.getIncomePullId().toString();
//			String cntractId = payment.getContractId().toString();
//			String orderId = payment.getOrderId().toString();
//			String paymentId = payment.getId().toString();
			

		for(var i=0; i< mygrid_payment.getRowsNum();i++){
			
			var v = mygrid_payment.cells2(i,0).getValue();
			
			if(v == 1 ){
				var paymentObj = new PayMent();
				
				var incomePullId = pullId;
				var incomeId = mygrid_pull.getUserData(incomePullId,"incomeId");
				var carrierId = mygrid_pull.getUserData(incomePullId,"resourceCarrierId");
				var balanceMoney = mygrid_pull.cells(incomePullId,6).getValue();
				var version = $("order_year").value;
				
				
				
				var paymentId =  mygrid_payment.getRowId(i);
				var moneyPay  =  mygrid_payment.getUserData(paymentId,"moneyPay");
				var moneyIn  =   mygrid_payment.getUserData(paymentId,"moneyIn");
				var contractId = mygrid_payment.getUserData(paymentId,"contractId");
				var orderId =    mygrid_payment.getUserData(paymentId,"orderId");
				var memo =       mygrid_payment.getUserData(paymentId,"memo");
			
				
				if(carrierId =="") carrierId = 0;
				if(balanceMoney  =="") balanceMoney  = 0;

				
//				alert("paymentIds["+ paymentIds +">");alert("pullId<"+ pullId +">");alert("balanceMoney<"+ balanceMoney +">");alert("carrierId<"+ carrierId +">");
				if (balanceMoney > 0){
					
					paymentObj.obj.id = paymentId;
					paymentObj.obj.paymentIds = paymentIds;
					paymentObj.obj.incomePullId = incomePullId*1;
					paymentObj.obj.incomeId = incomeId;
					paymentObj.obj.version = version;
					paymentObj.obj.userId = cur_userId;
//					paymentObj.obj.carrierId = carrierId*1;
					paymentObj.obj.carrIds = carrierId;
					
					paymentObj.obj.contractMoneySum = balanceMoney;
					paymentObj.obj.moneyPay = moneyPay*1;				
					paymentObj.obj.moneyIn = moneyIn*1;
					paymentObj.obj.contractId = contractId;
					paymentObj.obj.orderId = orderId;
					paymentObj.obj.memo = memo;
					
					paymentObjs.push(paymentObj.obj);

                 }
                 
                 
//                alert("incomeId["+ incomeId +">");
//				alert("carrierId["+ carrierId +">");
//				alert("incomePullId["+ incomePullId +">");
//				alert("balanceMoney["+ balanceMoney +">");
//				alert("userId["+ cur_userId +">");
//				
//                alert("paymentId["+ paymentId +">");
//                alert("orderId["+ orderId +">");
//                alert("contractId["+ contractId +">");		
//				alert("moneyPay["+ moneyPay +">");
//				alert("moneyIn["+ moneyIn +">");
//				alert("version["+ version +">");
//				alert("paymentIds["+ paymentIds +">");
//				alert("memo["+ memo +">");
				
				
			}
			
		}
		
		if(paymentObjs.length >0){
			$("btn_search").disabled=true;
			payment.savePutonMoneyByObj(paymentObjs,callBack);
		}else{
			alert("请选择需要分配的到款记录!");
			return false;
		}
		
	}else{
		
		//var paymentIds = getPayMentIds();
		
		//if(paymentIds.length <1){
			//alert("请选择需要返还的付款记录!");
			//return false;
		//}
		
		
		if(pullIds.length > 0){
			for(var i=0; i< pullIds.length;i++){
					var paymentObj = new PayMent();
					//paymentObj.obj.paymentIds = paymentIds;
					paymentObj.obj.incomePullId = pullIds[i]*1;
	//				paymentObj.obj.moneyPay = balanceMoney*1;
	//				paymentObj.obj.carrierId = carrierId*1;
					paymentObjs.push(paymentObj.obj);				
			}
		}else{
				var paymentObj = new PayMent();
				paymentObj.obj.incomePullId = 0;
				paymentObj.obj.paymentIds = paymentIds;
				paymentObjs.push(paymentObj.obj);
		}
		
		if(pullIds.length == 0 && paymentIds.length == 0){
			alert("请先选择要返还的记录,再点返还!");
			return false;
		}
		$("btn_putBack").disabled=true;
		payment.saveBackPaymentMoneyByObj(paymentObjs,callBack);

	}	
}

function getPayMentIds(grid){
	var paymentids = new Array();
	for(var i=0; i< grid.getRowsNum();i++){
		var v = grid.cells2(i,0).getValue();
		if(v == 1)paymentids.push(grid.getRowId(i));
	}
	return paymentids;
}



function getTowTables(){
	payment.obj.carrierIds = new Array();
	payment.obj.incPullIds =  new Array();
	payment.obj.userIds  =  new Array();
	getIncomePulls();
	getPayments();	
}

	
function getIncomePulls(){
	setallCheckFalse(1);
	var state = getRadioValue($("chooseCN").parentNode.parentNode);
	var customerId = $("customerId").value;
	var version = $("income_year").value;
        
        
	if(state == 1){
		changeButton(true);
	}else{
		changeButton(false);
	}

	var func = function(xml){
		mygrid_pull.clearAll();
		if(xml ==''||isUndefined(xml)){return false;}
		mygrid_pull.loadXMLString(xml);
		restHeadComnand();
		//filterBy();
	}
		 
	incomePull.reset();
	incomePull.obj.income = (new Income()).obj;
	incomePull.obj.income.customerId = customerId;
	incomePull.obj.income.state = state;
	incomePull.obj.version = version;
	incomePull.obj.id = config_isSignUserBalance;//判断是否业务员平帐
	
	incomePull.getIncomesPullsXML(incomePull.obj,func);
	
	//mygrid_payment.clearAll();
}

function getPayments_keyPress1(ev){ 
	var state = getRadioValue($("chooseCN").parentNode.parentNode);
	
//	 if(ev.keyCode == 13 && state == 2){
	 if(ev.keyCode == 13){
	 	 findOrderCode = true;
	 	 findContractCode = false;
	 	
	 	 getPayments();		
	 }
}

function getPayments_keyPress2(ev){ 
	var state = getRadioValue($("chooseCN").parentNode.parentNode);
	
	//	 if(ev.keyCode == 13 && state == 2){
	 if(ev.keyCode == 13){
	 	
	 	 findContractCode = true;
	 	 findOrderCode = false;
	 	
	 	 getPayments();		
	 }
}


function getPayments(){ 
	$("btn_search").disabled=true;
	setallCheckFalse(2);
	var state = getRadioValue($("chooseCN").parentNode.parentNode);
	var customerId = $("customerId").value;
	var version = $("order_year").value;
   
    Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	
	var carrierId;
	
	var func = function(xml){
		$("btn_search").disabled=false;
		mygrid_payment.clearAll();
		if(xml ==''||isUndefined(xml)){return false;}
		mygrid_payment.loadXMLString(xml);
		Ext.getBody().unmask();
		//restHeadComnand();
	}
	
	payment.reset();	
	payment.obj.customerId = customerId;
	payment.obj.version = version;
	payment.obj.state = state;
	
	
//	alert(customerId);
//	alert(version);
//	alert(state);

	getSelectedValueFromHead();
	
	payment.obj.carrierIds = new Array();
	
	if(channelParam == 0){
		 payment.obj.carrierIds = new Array();
	}else{
		var id = mygrid_pull.getSelectedId();
		var cid = mygrid_pull.getUserData(id,"resourceCarrierId");
		var uid = mygrid_pull.getUserData(id,"userId");
		
		if(config_useCarrierAliname == 1){
			if(cid.indexOf(",")>-1){
				var cids = cid.split(",");
				for(var i = 0;i<cids.length;i++){
					payment.obj.carrierIds.push(cids[i]);
				}
			}else{
				payment.obj.carrierIds.push(cid);
			}

			
		}else{
			payment.obj.carrierIds.push(cid);
		}
		
//		alert(payment.obj.carrierIds);
//		payment.obj.userIds.push(uid);
			
	}
	
	if(state == 1) {
		 //var userId = $("signUserId").value;
		 //payment.obj.userId = userId > 0?userId:null;
		 payment.obj.incPullIds = new Array();
		 payment.obj.userIds = new Array();
	}else{
//	    if(payment.obj.incPullIds.length == 0){
//	    	 mygrid_payment.clearAll();return false;
//	    }
            var selectedId = mygrid_pull.getSelectedId();
            if(displayBalanceDetail && selectedId > 0){
            	payment.obj.incPullIds.clear();
            	payment.obj.incPullIds.push(selectedId);
            }else{
            	payment.obj.incPullIds.clear();
            }
	    payment.obj.carrierIds = new Array();
	    payment.obj.userIds = new Array();

	}
	
	//alert(findOrderCode);alert(findContractCode);
	if(findOrderCode||findContractCode){
		
		payment.obj.carrierIds = new Array();
		payment.obj.incPullIds = new Array();
		payment.obj.userIds = new Array();
		payment.obj.customerId = -1;
		var orderCode = $("orderCode").value;
		orderCode = (orderCode=="订单编号"||orderCode=="")?null:orderCode;
		
		var contractCode = $("contractCode").value;
		contractCode = (contractCode=="合同编号"||contractCode=="")?null:contractCode;
				
		if(findOrderCode && orderCode == null) return false;
		if(findContractCode && contractCode == null) return false;
		
		
		if(findOrderCode){
			 payment.obj.orderCode = orderCode;
			 //payment.obj.contractCode = -1;
			 
			 $("orderCode").value = "订单编号";
			 findOrderCode = false;
		}
		
		
		if(findContractCode){
			 payment.obj.contractCode = contractCode;
			 payment.obj.orderCode = ''
			
			 $("orderCode").value = "订单编号";
			 findContractCode = false;
			}
		
		
		
	}
	var type = 1;
	payment.obj.userIds=[userName];
	payment.getContractPaymentXML(payment.obj,func);	
}

function resetText(ev){
	 $("customerName").value = null;
	 $("customerId").value = null;
}





//function getCustomerAutoCompltByName(ev){
//	var customerName =$("customerName").value;
//	customer.obj.customerName = customerName;
//	
//	
//	if(ev.keyCode == 13){
//		customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
//		$("customerName").value="";
//		
//	}
//}
//
//function customerAutoComplete(objs)
//{
//	var oText = $("customerName");
//	var oDiv = $("theDivCustomerName");
//
//	var indexColumName_customerName = ["helpCode"];
//	var allColumsName_customerName =["id","helpCode","customerName","customerCategoryId","category.categoryName"];
//	var hidenColumName = ["id","helpCode","customerCategoryId"];
//	var allColumsTitle = ["客户名称","客户类别"];
//	
//	var onDivMouseDown_customerId = function(ev){
//
//		var tr = getElementByEvent(ev);
//		$("customerId").value = getCellValue(tr,0);
//		$("customerName").value = getCellValue(tr,2);
//		$("customerCategoryId").value = getCellValue(tr,3);
//		
//		oText.value = getCellValue(tr,2);
//		getSelectCustomerToTree();
//	}
//	
//	var onTextBlur = function(ev){
//		oDiv.style.visibility = "hidden";
//		if(trim(oText.value) == "" ){
//			$("customerId").value = '';
//			$("customerCategoryId").value = '';
//		}
//	}
//   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown_customerId,onTextBlur,hidenColumName,indexColumName_customerName,allColumsName_customerName,allColumsTitle);
//}



function setIncomeUsedPara(obj){
	 obj.className  = "incomeUsed";
	 obj.IdPrefix 	= obj.className + "Id";
}

function setIncomePullPara(obj){
	 obj.className   = "incomePull";	
	 obj.IdPrefix 	 = obj.className + "Id";
	 obj.radioName = obj.className +"RN";
	 obj.income = (new Income()).obj;
}

function setPayMentPara(obj){
	 obj.className = "payment";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.incomePurpose = new IncomePurpose();
}


function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "customerId";
}
//function setCategoryPara(obj){
//	 obj.className ="category";
//	 obj.IdPrefix 	= obj.className + "Id";
//	 obj.treebox	= obj.className + "Treebox";
//	 obj.tree 		= new Tree(obj.treebox);
//}

function changeButton(bln){
	if(bln){
		$("displayBalanceDetail").hide();
		$("displayBalanceDetailLabel").hide();
		$("btn_search").show();
		$("btn_putBack").hide();
	}else{
		$("displayBalanceDetail").show();
		$("displayBalanceDetailLabel").show();
		$("btn_search").hide();
		$("btn_putBack").show();
	}
	if(tag_orderList_finance == 0){
		$("btn_search").hide();
		$("btn_putBack").hide();
	}
}
//function goNextPage(pageIndex,pageInfoName){
//	if(pageInfoName == payment.pageInfo){
//		var page = new Page(payment.pageInfo,payment.pageSize);
//		page.goNextPage(pageIndex);
//		payment.page = page;
//		var func =function(){
//		}
//		loadData(payment,func);
//	}
//}	
//
//function loadData(obj,callBackFun){ 
//	var func = function(xml){
//		$("btn_search").disabled=false;
//		mygrid_payment.clearAll();
//		if(xml ==''||isUndefined(xml)){return false;}
//		mygrid_payment.loadXMLString(xml);
//	}
//	var type = 0;
//	payment.getContractPaymentPageXML(payment.obj,type,func);	
//}