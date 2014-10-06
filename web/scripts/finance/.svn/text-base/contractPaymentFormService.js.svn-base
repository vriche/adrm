 var contractPayment = new PayMent();
 var incomePull = new IncomePull();
 var user = new User();
 var customer = new Customer();
 var mygrid;
 var mygrid_pull;
 var winW;
 var winH;
 var config_serviceDate;
 var tag_orderList_finance;
 var loginUser;
 var cur_userId;
 var resourceName;
 var contPath;
 var myPrint = new MyPrint();
 var utils=new MyUtils();
var curYear;


var loadMarsk;


 
 
 callOnLoad(init);	
  
  function init(){

  	loginUser =   _app_params.user.username;
  	cur_userId =  _app_params.user.id;
  	curYear =  _app_params.serviceDate.year;
  	resourceName = "tag_orderList_finance";
  	tag_orderList_finance = _app_params.rights.tag_orderList_finance;
  	contPath = getCtxPath();

 	var srcStr = window.location.href;
	winW = getParamFromUrl(srcStr,"winW");
	winH = getParamFromUrl(srcStr,"winH");
    mode = getParamFromUrl(srcStr,"mode");   
    defOrgId = getParamFromUrl(srcStr,"orgId");  	
    var startDate = getParamFromUrl(srcStr,"startDate");
    var endDate = getParamFromUrl(srcStr,"endDate");    
    var contractSortId = getParamFromUrl(srcStr,"contractSortId");    
    var defaultALL = getParamFromUrl(srcStr,"defaultALL");  
    

//   alert(parent);
//     alert(parent.document);
//    alert(parent.document.getElementById('selectNotice'));  
     winH = parent.cuikuanWin.getInnerHeight()-35;
     winW = parent.cuikuanWin.getInnerWidth()-10;
//     alert(winH);
//      alert(parent.cuikuanWin.getComponent("cuikan_tab").getHeight() );
//     alert(parent.cuikuanWin.getInnerHeight())


//   contentWindow
//    alert(parent.getInnerHeight());
  	
  	 loadMarsk = new Ext.LoadMask(document.body, {
	     	msg : '正在加载数据，请稍候。。。。。。',
	     	removeMask : true// 完成后移除
 	});
  	



   
 	if(winW == null) winW = 1200;
	if(winH == null) winH = 400;
	
	 initGrid(); initGrid_incomPull();
    if(mode == 1){
    	getContractPayment(defOrgId,curYear,'','','',startDate,endDate,contractSortId,defaultALL);

    }else{
    	 var customerIds = getParamFromUrl(srcStr,"customerIds");
    	 var signUserId = getParamFromUrl(srcStr,"signUserId");
    	 var customerName = getParamFromUrl(srcStr,"customerName");
    	 var orgId = getParamFromUrl(srcStr,"orgId");
    	 var year = getParamFromUrl(srcStr,"year");
    	 var resourceTypeId = getParamFromUrl(srcStr,"resourceTypeId");

    	   
    	 resourceTypeId = resourceTypeId=='' ||resourceTypeId=='null' ||resourceTypeId==null ?"0":resourceTypeId;
    	 if(!year) year = curYear;
   

    	
    	 if(customerIds == null){
    	 	 customerIds =[];
    	 }else{
    	 	customerIds = customerIds.split(",");
    	 }
    	 getIncomePulls(orgId,year,resourceTypeId,signUserId,customerName,customerIds,startDate,endDate,contractSortId);
    	 
    }
    	                
	
	resetHeigth(mode); 

  	
//  	buttonEventFill();
  	
  

  }
 
function setCurUserId(){

//	var fnc = function(id){
//		//if($(user.selectName).length<3){
//			$(user.selectName).value = id;
//			
//		//}
//		getContractPayment('','');
//	}
	
	$(user.selectName).value = _app_params.user.id;
//	user.getCurUserId(loginUser,function(id){fnc(id)});	
}

  function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	
	
	
	
	
	mygrid.setImagePath(contPath+"/image/grid/");
//	mygrid.setImagePath("image/grid/");
	
//   if(tag_orderList_finance == 0){
//		var flds = "合同号,订单号,客户名称,业务员,应付日期,应付金额,平账金额,欠款金额";
//		mygrid.setHeader(flds);
//	    mygrid.setInitWidthsP("12,12,15,8,11,14,14,14");
//		mygrid.setColAlign("left,left,left,center,right,right,right,right");
//		mygrid.setColTypes("link,link,ed,ed,ed,ed,ed,ed");	
//		mygrid.setColSorting("str,str,str,str,int,int,int,int");
//   }else{
		var flds = "选择,合同号,订单号,客户名称,广告名称,业务员,分类,应付日期,应付金额,平账金额,欠款金额";
		mygrid.setHeader(flds);
		var columnIds = "incomePullId,payDate,carrierName,payCode,customerName,signUser,filed2,incomeMoney,releaveMoney,yy,opter3";
		mygrid.setColumnIds(columnIds);
	    mygrid.setInitWidthsP("6,9,10,10,11,8,6,10,10,10,10");
		mygrid.setColAlign("center,left,left,left,left,center,right,right,right,right,right");
		mygrid.setColTypes("ch,link,link,ed,ed,ed,ed,ed,ed,ed,ed");
//		mygrid.setColSorting("str,str,str,str,str,str,int,int,int,int");
//   }


    mygrid.setMultiLine(false);
	mygrid.setEditable(false);
//	mygrid.enableDragAndDrop(false);
	

    mygrid.setSkin("modern2");
    mygrid.enableAlterCss("even","uneven");
    mygrid.setOnRowSelectHandler(onRowSelected,true);
    //mygrid.setOnRowDblClickedHandler(onRowSelectd,true);

    
	mygrid.init();	 
	
	

	
//    if(tag_orderList_finance == 0){
//    	mygrid.attachFooter(' , , , , , , , ',[ , , , ,'text-align:center;','text-align:right;','text-align:right;','text-align:right;']);
//    }else{
//    	mygrid.attachFooter(' , , , , , , , , , ',[ , , , , , ,'text-align:center;','text-align:right;','text-align:right;','text-align:right;']);
//    }	
//	attachHeader();

}



function initGrid_incomPull(){
	mygrid_pull = new dhtmlXGridObject('gridbox_incomePull');
	mygrid_pull.selMultiRows = true;
	mygrid_pull.setImagePath(contPath+"/image/grid/");
	//mygrid_pull.flds = "到款日期,频道名称,付款编号,客户名称,业务员,划账金额,剩余金额,划归日期,备注";
	mygrid_pull.flds = "到款日期,分类,付款编号,客户名称,业务员,划归年份,划账金额,剩余金额";
	mygrid_pull.newHeads = mygrid_pull.flds.split(",");
	mygrid_pull.setHeader(mygrid_pull.flds);
	var columnIds = "incomePullId,payDate,carrierName,payCode,customerName,signUser,incomeMoney,releaveMoney,yy";
	mygrid_pull.setColumnIds(columnIds);

	mygrid_pull.setInitWidthsP("10,10,10,18,12,10,15,15");
	mygrid_pull.setColAlign("center,left,left,left,center,center,right,right,right");
	mygrid_pull.setColTypes("ro,ro,link,ro,ro,ro,ro,ro");
	//mygrid_pull.setColSorting("str,date,str,str")
    mygrid.setColSorting("str,str,str,str,str,int,int,int");
//    mygrid_pull.setOnRowSelectHandler(onRowSelected,true);
//	mygrid_pull.setMultiLine(false);
	mygrid_pull.setEditable(false);
//	mygrid_pull.enableDragAndDrop(false);
	mygrid_pull.enableAlterCss("even","uneven"); 
	mygrid_pull.setSkin("modern2");
	
		var s1= "<div id='month1'/>,<div id='month2'/>,<div id='month3'/>,<div id='month4'/>,<div id='month5'/>,合计,<div id='month6'/>,<div id='month7'/>";
	var s2 = [ , , , , ,'text-align:center;','text-align:right;','text-align:right;'];
	mygrid_pull.attachFooter(s1,s2);
	mygrid_pull.init();	 
//	resetHead(mygrid_pull,1);
}


    function onRowSelected(rowId,colIndex){
	//alert(rowId);alert(colIndex);
	//var colName = mygrid.getColumnId(colIndex);
	//var rowIndex = mygrid.getRowIndex(rowId);
	
       //window.location.target="_blank";
       //window.location.href ="/adrm/editOrder.html?id="+rowId;
    var cell = this.cells(rowId,0);
	var v = cell.getValue()==0?1:0;
	cell.setValue(v);

}
  function resetHeigth(){
  	 var gridbox = $("gridbox");
  	 var gridbox2 = $("gridbox_incomePull");
  	 if(mode == 1){
         gridbox2.hide();
//         gridbox.style.width = winW*0.97 +"px";	
//         gridbox.style.height = winH*0.72+"px";  	
         gridbox.style.width = winW +"px";	
         gridbox.style.height = winH+"px";  	
         
  	 }else{
         
          gridbox.hide();
//          gridbox2.style.width = winW*0.97 +"px";	
//          gridbox2.style.height = winH*0.72+"px";    	
         gridbox2.style.width = winW +"px";	
         gridbox2.style.height = winH+"px";    	
  	 }
    
  } 
  
//  function buttonEventFill(){
//
//	var btn_search = $("btn_search");
//	btn_search.onclick = getContractPayment;
//
//	var btn_export = $("btn_export");
//	btn_export.onclick = btn_display;	
//
//
//}

// function getContractPayment_bak(year,userName,customerName){
//// 	var customerName = $("customerName").value;
////  	var userName = $(user.selectName).value;
//  	if(userName =='') userName = 0;
//
// 	loadMarsk.show(); 
//	var fnc = function(xml){
//		mygrid.clearAll();
//
//		mygrid.loadXMLString(xml,function(){
//				attachHeaderNew();
//				loadMarsk.hide(); 
//			}
//		);	
//	}
//	
//	
//	
//  	contractPayment.getContractPaymentFormXml(year,loginUser,userName,resourceName,customerName,fnc);
// }
// 
 
  function getContractPayment(orgId,year,signUserId,customerName,resourceTypeId,startdt,enddt,contractSortId,defaultALL){
  	    if(signUserId =='') signUserId = 0;
	// 	var customerName = $("customerName").value;
	//  var userName = $(user.selectName).value;
//	  	if(userName =='') userName = 0;
    
  	    var paramObj = {orgId:orgId,year:year,loginUser:loginUser,resourceName:resourceName,signUserId:signUserId,customerName:customerName,resourceTypeId:resourceTypeId};
  	    
//  	    paramObj.resourceTypeId =
  	    paramObj.startDate  = startdt;
  	    paramObj.endDate = enddt;
  	    paramObj.contractSortId = contractSortId;
  	    paramObj.defaultALL = defaultALL;
  	    
  	    
	 	mygrid.clearAll();
	 	mygrid.detachFooter(0);
		mygrid.enableSmartRendering(true);
		
	   	var  loadDataURL =contPath+"servlet/paymentListServlet?" + $H(paramObj).toQueryString();
	   	mygrid.loadXML(loadDataURL);
        mygrid.setSizes();	
 }
 
 

 
 

 
 	
function getIncomePulls(orgId,year,resourceTypeId,signUserId,customerName,customerIds,startdt,enddt,contractSortId){
	//setallCheckFalse(1);
	//var state = getRadioValue($("chooseCN").parentNode.parentNode);
	//var customerId = $("customerId").value;
	//var version = $("income_year").value;
	if(!customerIds || customerIds==''){
		 customerIds = [];
	}else{
		customerIds = eval('['+customerIds+']');;
	}

	
//	alert(customerIds);


    loadMarsk.show();    
        
//	if(state == 1){
//		changeButton(true);
//	}else{
//		changeButton(false);
//	}

	var func = function(xml){

		mygrid_pull.clearAll();
		if(xml ==''||isUndefined(xml)){return false;}
		mygrid_pull.loadXMLString(xml);
		loadMarsk.hide(); 
		
		calculateFooterValues();
//		restHeadComnand();
		//filterBy();
	}


	incomePull.reset();
//	incomePull.obj.income = (new Income()).obj;
//	incomePull.obj.income.customerId = customerId;
//	incomePull.obj.income.state = 1;
	//incomePull.obj.version = '';
	incomePull.obj.lastName = loginUser;
//	incomePull.obj.customerIdList = eval('['+customerIds+']');;
	incomePull.obj.customerIdList = customerIds;
	incomePull.obj.customerName = customerName;
	incomePull.obj.firstName = signUserId;
	
	incomePull.obj.orgId = orgId;
	incomePull.obj.version = year;
//	incomePull.obj.resourceTypeId = resourceTypeId;
//    alert(resourceTypeId);
	incomePull.obj.resourceTypeIds = resourceTypeId;
	incomePull.obj.startDate = startdt;
	incomePull.obj.endDate = enddt;


//	 alert('customerIds'+customerIds);
//	  alert('customerName'+customerName);
//	   alert('signUserId'+signUserId);
//	    alert('year'+year);
//	    alert('resourceTypeId'+resourceTypeId);
	
	
	incomePull.getIncomesPullsXM3(incomePull.obj,func);
	
	
	
	//mygrid_payment.clearAll();
}
 
function attachHeader(){	
	
//	 if(tag_orderList_finance ==1){
	 	
	 	var htm ="<center><input type='checkBox' id='paymentAllSelect' value='0' onclick= 'javascript:selectCheckBoxAll()'></center>,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan";
		var h = htm.split(",");
		//alert(h.length);
		var z =  mygrid.hdr.rows[1];
		for(var cin = 0; cin<h.length;cin++){
			if(h[cin].indexOf("#rspan") != 0) {
				var c = z.cells[z._childIndexes?z._childIndexes[parseInt(cin)]:cin];
				c.innerHTML = h[cin];		
			}
	
		}	
	
//	}

}




function selectCheckBoxAll(){
	var obj;
	
	obj = $("paymentAllSelect");	

	var col = obj.value;
	var rows = mygrid.getRowsNum();
	
	for(var i=0; i< rows;i++){
		var ch =  mygrid.cells2(i,0);
		if(mygrid.getRowByIndex(i).style.display ==""){
		     ch.setValue(obj.checked);
		}else{
		     ch.setValue(0);
		} 
	}	
}



 
 function attachHeaderNew(){
	var rows = mygrid.getRowsNum();
	var lastId = mygrid.getRowId(rows-1);

	
//    var k = 0;
//    if(tag_orderList_finance == 1) k = 1;
    var k = 2;
	
	var cl_1 = (rows == 0)?"": mygrid.cells2(lastId,5+k).getValue()*1;
	var cl_2 = (rows == 0)?"": mygrid.cells2(lastId,6+k).getValue()*1;
	var cl_3 = (rows == 0)?"": mygrid.cells2(lastId,7+k).getValue()*1;
	
	//alert(cl_1);alert(cl_2);alert(cl_3);
	
    var htm ="";
//    if(tag_orderList_finance == 0){
//    	 
//		htm ="#rspan,#rspan,#rspan,#rspan,合计,"+ cl_1 +","+ cl_2 +","+ cl_3 +"";
//	
//    }else{
     
		//htm ="#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,合计,"+ cl_1 +","+ cl_2 +","+ cl_3 +"";
		htm ="<div id='sum1'/>,<div id='sum1'/>,<div id='sum1'/>,<div id='sum1'/>,<div id='sum1'/>,<div id='sum1'/>,合计,"+ cl_1 +","+ cl_2 +","+ cl_3 +"";
	
	
    	
//    }
	
	var h = htm.split(",");
	//alert(h.length);
	var z =  mygrid.ftr.rows[1];
	
	for(var cin = 0; cin<h.length;cin++){
		if(h[cin].indexOf("#rspan") != 0) {
			var c = z.cells[z._childIndexes?z._childIndexes[parseInt(cin)]:cin];
			c.innerHTML = h[cin];		
		}

	}
	
	mygrid.deleteRow(lastId);
	
}


function calculateFooterValues(){

        for(var i=6;i<8;i++){
        	var el = $("month"+(i));
        	el.innerHTML = sumColumn(i);
        }
        return true;
    }
    
function sumColumn(ind){
        var out = 0;
        for(var i=0;i<mygrid_pull.getRowsNum();i++){
       		var value =mygrid_pull.cells2(i,ind).getValue()==""?0:mygrid_pull.cells2(i,ind).getValue();
            	out+= parseFloat(value)
        }
        return out;
 }
 

  //函数名称必须为 printReport,因为print.js中用到这个方法名
function btn_display(model,orgId,year,signUserId,customerName,resourceTypeId,startdt,enddt,contractSortId,defaultALL){
	
	   var listFields =[
//			{name:'id',type:'string'},
//			{name:'lable',type:'string',label:'客户名称',sortable: true,width:winW*(1-5*0.16),summaryType: 'count'},
			{name:'value1',type:'string',label:'合同编号',sortable: true,width:winW*0.16,align:'right',summaryType: 'sum'},
			{name:'value2',type:'string',label:'订单编号',sortable: true,width:winW*0.16,align:'right',summaryType: 'sum'},
			{name:'value3',type:'string',label:'客户名称',sortable: true,width:winW*0.16,align:'right',summaryType: 'sum'},
			{name:'value4',type:'string',label:'广告名称',sortable: true,width:winW*0.16,align:'right',summaryType: 'sum'},
			{name:'value5',type:'string',label:'业务员',sortable: true,width:winW*0.16,align:'right',summaryType: 'sum'},		
			{name:'value6',type:'string',label:'分类',sortable: true,width:winW*0.16,align:'right',summaryType: 'sum'},		
			{name:'value7',type:'string',label:'应付日期',sortable: true,width:winW*0.16,align:'right',summaryType: 'sum'},		
			{name:'value8',type:'string',label:'应付金额',sortable: true,width:winW*0.16,align:'right',summaryType: 'sum'},		
			{name:'value9',type:'string',label:'平账金额',sortable: true,width:winW*0.16,align:'right',summaryType: 'sum'},			
			{name:'value10',type:'string',label:'欠款金额',sortable: true,width:winW*0.16,align:'right',summaryType: 'sum'}
         ];

        var fileds = utils.getStoreFileds(listFields);
        this.columns = fileds[1];
        this.headers = fileds[2];
        this.gridPrototype ={gridId:'mygridBusin',columns:this.columns,pageSize:20,title:'业务员统计'};
	
	  
    	//loginUser,userName,resourceName,customerName
// 		var customerName = $("customerName").value;
//  		var userName = $(user.selectName).value;
//  		if(userName =='') userName = 0;
		
		var parObj = {
				model: model,
				reportType: "cuikuan_report",
//				reportFile:'',
				title:this.gridPrototype.title,
				headers:this.headers.join(","),
				displaySumColum:"0,0,0,0,0,0,0,1,1,1",
				
	            colAlign:"left,left,left,left,center,right,right,right,right,right",
	            widthsP:"10,10,15,11,8,6,10,10,10,10", 

				isSum:true,
				isVertical:false,
				loginUser:loginUser,
				orgId:orgId,
				year:year,
				signUserId:signUserId,
				resourceName:resourceName,
				customerName:customerName,
				resourceTypeId:resourceTypeId,
				startDate:startdt,
				endDate:enddt,
				contractSortId:contractSortId,
				defaultALL : defaultALL
		}
		
		if(model == 'chart'){
//			this.charts.loadChart(parObj,chartParam);
		}else if(model == 'list'){
//			this.store.load(parObj);	
		}else{
//			console.log(this.store.data);
			
//                        if(!desktopEl){
//                        	
//                        	desktopEl = Ext.fly('print-win');
//                	}
            if(model == 'view'){
            	return myPrint.loadApplet(parObj,contPath,winW,winH);
            }else{
            	myPrint.loadApplet(parObj,contPath,winW,winH);
            }	
			
		}
}



  //函数名称必须为 printReport,因为print.js中用到这个方法名
function btn_display2(model,orgId,year,signUserId,customerName,resourceTypeId,startdt,enddt){
	
	
//	alert(orgId);alert(year);alert(signUserId);alert(customerName);alert(resourceTypeId);

		var parObj = {
				model: model,
				reportType: "destop_income_report",
//				reportFile:'',
				title:"业务员到款统计",
				headers:"到款日期,分类,付款编号,客户名称,业务员,划归年份,划账金额,剩余金额",
				displaySumColum:"0,0,0,0,0,0,1,1",
				
	            colAlign:"center,center,left,left,center,center,right,right",
	            widthsP:"10,10,10,18,12,10,15,15", 

				
				isSum:true,
				isVertical:false,
				loginUser:loginUser,
				orgId:orgId,
				year:year,
				signUserId:signUserId,
				resourceName:resourceName,
				customerName:customerName,
//				resourceTypeId:resourceTypeId,
				resourceTypeIds :resourceTypeId,
				startDate:startdt,
				endDate:enddt
		}
		
		if(model == 'chart'){
//			this.charts.loadChart(parObj,chartParam);
		}else if(model == 'list'){
//			this.store.load(parObj);	
		}else{
//			console.log(this.store.data);
			
//                        if(!desktopEl){
//                        	
//                        	desktopEl = Ext.fly('print-win');
//                	}
            if(model == 'view'){
            	return myPrint.loadApplet(parObj,contPath,winW,winH);
            }else{
            	myPrint.loadApplet(parObj,contPath,winW,winH);
            }	
			
		}
}

function saveIncomeUsed(grid,searchFun){
	var customerIds = getPayMentIds(grid,"customerId");
	
	if(customerIds.length> 1){
		var msg = "很抱歉! 平帐时一次只能平一个客户";
//		utils.myMessage(msg);
        alert(msg);
		return false;
	}
	
	
	if(customerIds.length==0){
		var msg = "请选择催款记录";
//		utils.myMessage(msg);
		alert(msg);
		return false;
	}	
	
	
	var paymentIds = getPayMentIds(grid,"paymentId2");
	
	var pullId = mygrid_pull.getSelectedId();
	if(pullId > 0){
	
	}else{
	      alert("请选择余款记录"); return false;
	}	
	
	
	
	var callBack = function(s){
//		 loadMarsk.hide(); 
		 searchFun();
		 alert("平帐完成！");
			//getContractPayment(year,userName,customerName);
			//getIncomePulls(userName,customerName,customerIds);
			
	}
	
	
	
	
	var paymentObjs = new Array();
	
	if(paymentIds.length> 0){
				var paymentObj = new PayMent();
				var incomePullId = pullId;
				var incomeId = mygrid_pull.getUserData(incomePullId,"incomeId");
				var version = mygrid_pull.cells(pullId,5).getValue();
				var balanceMoney = mygrid_pull.cells(pullId,7).getValue();
				var carrierId = mygrid_pull.getUserData(incomePullId,"resourceCarrierId");
				if(carrierId =="") carrierId = 0;
				if(balanceMoney  =="") balanceMoney  = 0;
				//alert("paymentIds["+ paymentIds +">");alert("pullId<"+ pullId +">");alert("balanceMoney<"+ balanceMoney +">");alert("carrierId<"+ carrierId +">");
				if (balanceMoney > 0){
					paymentObj.obj.paymentIds = paymentIds;
					paymentObj.obj.incomePullId = incomePullId*1;
					paymentObj.obj.incomeId = incomeId;
					paymentObj.obj.version = version;
					paymentObj.obj.userId = cur_userId;
					paymentObj.obj.moneyPay = balanceMoney*1;
					paymentObj.obj.carrierId = carrierId*1;
					paymentObjs.push(paymentObj.obj);
                 }
                 
      
         if(paymentObjs.length >0){
//         	loadMarsk.show(); 
			contractPayment.savePutonMoneyByObj(paymentObjs,callBack);
		}else{
			var msg = "请选择需要分配的到款记录!";
//			utils.myMessage(msg);
			alert(msg);
			return false;
		}
		
	}else{
			var msg = "请选择余款记录!";
//			utils.myMessage(msg);
			alert(msg);
			return false;
	}
	

	
}
function getPayMentIds(grid,ind){
	var paymentids = new Array();
	var paymentids2 = new Array();
	for(var i=0; i< grid.getRowsNum();i++){
		var v = grid.cells2(i,0).getValue();
		//if(v == 1)paymentids.push(grid.getRowId(i));
		if(v == 1){
			var id = grid.getUserData(grid.getRowId(i),ind);
			var index = paymentids.indexOf(id);
			if(index>-1) paymentids.remove(index);
			paymentids.push(id);
		}
	}
	
	for(var i=0; i< paymentids.length;i++){
		var v = paymentids[i];
		if(v !=null) paymentids2.push(v);
	}
	
	return paymentids2;
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


function sendCuiKuan2SignUser(grid){
	var customerIds = getPayMentIds(grid,"customerId");
		if(customerIds.length==0){
		var msg = "请选择催款记录";
//		utils.myMessage(msg);
		alert(msg);
		return false;
	}	
	
	var payments = new Array();
	for(var i=0; i< grid.getRowsNum();i++){
		var v = grid.cells2(i,0).getValue();
		if(v == 1){
			var payment = new PayMent();
			var rowId = grid.getRowId(i);
			payment.obj.contractCode = grid.getUserData(rowId,'contractCode');
			payment.obj.orderCode = grid.getUserData(rowId,'orderCode');
			payment.obj.customerName = grid.cells2(i,3).getValue();
			payment.obj.memo = grid.cells2(i,4).getValue();
			payment.obj.moneyPay = grid.cells2(i,7).getValue();
			payment.obj.moneyIn = grid.cells2(i,8).getValue();
			payment.obj.orderUser = new User(); 
			payment.obj.orderUser.username = grid.getUserData(rowId,'orderUserName');
			payments.push(payment.obj);		
		}
	}
	loadMarsk.show(); 
	IncomeMsgManager.sendCuiKuan2SignUser(fun,payments,loginUser);
	
	function fun(b){
		loadMarsk.hide(); 
		if(b){
			utils.myMessage("催款通知已成功发送!");
		}else{
			utils.myMessage("发送催款通知失败!");
		}
		
	}
}
