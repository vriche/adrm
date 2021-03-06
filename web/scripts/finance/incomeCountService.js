//实例化对象

var incomePull = new IncomePull();
var income = new Income();
var payment = new PayMent();
var customer = new Customer();
var category = new Category();
var incomeUsed = new IncomeUsed();
var popupcenter = new Popupcenter();
var user =new User();
var org = new SysOrg();
var myUtils = new MyUtils();

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
var balanceModel = 1;
var customerCommand;
var incomeCodeCommand;


callOnLoad(init);	

//		Ext.onReady(function(){
//			
//			new Ext.ux.ButtonLite({
//				id:'btn_search',
//				version:'2'
//			});
//			
//			new Ext.ux.ButtonLite({
//				id:'btn_cancel',
//				version:'2'
//			});
//			
////			new Ext.ux.ButtonLite({
////				id:'test22',
////				//extjs2 样式，默认extjs3 样式
////				version:'2'
////			});
//			
//		});



//Ext.onReady(function(){
//            new Ext.Button({
//            	id:"btn_search",
//                text:"分配",
//                //将BUTTON画在BODY中
//                renderTo:"btn_search_test",
//                fn: function(){saveIncomeUsed2();} ,
//                minWidth:100,
//                icon: Ext.MessageBox.INFO
//        });
//
// });


function init(){ 
	
	winHeight = self.innerHeight*0.33; 

	config_serviceDate = _app_params.serviceDate.def;

	_make_adrm_sys_year_select("income_year",_app_params.serviceDate.adrmSysYear);
		
	_make_adrm_sys_year_select("order_year",_app_params.serviceDate.adrmSysYear);
	
	get_cur_year();
	
	
	channelParam =  _app_params.sysParam.channelModelParam;
	channelPullParam = _app_params.sysParam.channelPullParam;
	tvNameParam =  _app_params.sysParam.tvNameParam;
	cur_userId =  _app_params.user.id;
	userName =  _app_params.user.username;
	
    config_useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
    config_withResourceSort = _app_params.sysParam.withResourceSort;
    
    config_isSignUserBalance = _app_params.sysParam.isSignUserBalance;
    config_useCarrierAliname = _app_params.sysParam.useCarrierAliname;
    config_useCarrierAliname = _app_params.sysParam.useCarrierAliname;
	tag_orderList_finance =  _app_params.rights.tag_orderList_finance;
	config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;


	
//	user.getCurUserId(userName,function(id){cur_userId = id;});	
	
	
	
	setIncomePullPara(incomePull);

	setPayMentPara(payment);
	setCustomerPara(customer);
	setIncomeCountPara(payment);
	setIncomeUsedPara(incomeUsed);





	resetHeigth();	



 	initGrid_incomPull();
 	initGrid_payment();
 

    var  orgId = getParamFromUrl(window.location.href,"orgId");
    
    
    	
    	    
    _make_org_select("orgId",100,"resetCustomerCom");	
    
    	  

//    if(config_oneOrgMoreSuborgsParam == '1'){$('orgId').hide();}

    	
    if(orgId >0) $("orgId").value = orgId;

    
	var customerId = getParamFromUrl(window.location.href,"customerId");


	var fun = function(){
		
		getIncomeCodeCom();

		if(customerId > 0){
			var customerName = getParamFromUrl(window.location.href,"customerName");
            customerName = unescape(customerName);
			inti_set_customer(customerId,customerName);
//			Ext.getCmp("customerName").setValue(customerId);
		    $('customerId').value = customerId;
		    getTowTables();
		}

	}	
	
//	if(customerId > 0){
//		$('customerId').value = customerId;
//		getTowTables();
//	}
	
	   
	getCustomerCommand(fun,orgId);	
   
	buttonEventFill();
 	   
 	setGridCheckDisabled();
	


}
function getIncomeCodeCom(){
	



	if(!incomeCodeCommand){
		
		var state = getRadioValue($("chooseCN").parentNode.parentNode);

		var paramObj ={
			orgId: $("orgId").value,
			year: $("income_year").value, 
			state: state,
			incomeCode:null
		}
		
		
		 incomeCodeCommand = income.getIncomeCodeCom(150,"extPaymentCode","inc_code",paramObj);
		 incomeCodeCommand.on("select" , function(box) 
		    {
		        var incomeId = box.getValue();
				var store = this.store;	
				var index =  store.find("id", incomeId);
		        var customerId = store.getAt(index).get("customerId");
		        var customerName = store.getAt(index).get("customer.customerName");
		        
	            inti_set_customer(customerId,customerName);
		        
		        var customerCmd = Ext.getCmp("customerName");
		        var state = getRadioValue($("chooseCN").parentNode.parentNode);
	
		        $("customerId").value = customerId;
		        
	      
		        
		        if(state == 1){
		        	 getIncomePulls();
		        	 mygrid_payment.clearAll();
		        }else{
		        	 getTables(customerId);
		        }
		    });
	}

}

function resetCustomerCom(){
	var orgId = $("orgId").value;
	mygrid_pull.clearAll();
	mygrid_payment.clearAll();
	
	var fun = function(){
		 Ext.getCmp("customerName").setValue('');
	}  
    customerCommand.clearValue(); 
    customer.obj.orgId = orgId;
    customerCommand.store.on("load",fun);
    customerCommand.store.reload();
}

function resetHeigth(){
	var dialogcontent = document.getElementById("dialogcontentDiv");

	document.getElementById("gridbox_incomePull_div").style.height = dialogcontent.offsetHeight*0.82*0.3 +"px";	
	document.getElementById("gridbox_payment_div").style.height = dialogcontent.offsetHeight*0.82*0.6 +"px";
} 
 
 
function setIncomeCountPara(obj){
	
	 var page=Math.round(winHeight* 0.80/20)-2;
	 obj.className  = "IncomeCount";	
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= page;
	 obj.page = new Page(obj.pageInfo,obj.pageSize);	
}

function get_cur_year(){

	var yyyy = _app_params.serviceDate.year;
	
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
	if(config_withResourceSort == 1){
			mygrid_pull.flds = "选择,到款日期,分类,付款编号,业务员,划账金额,剩余金额,划归年份";
	}else{
			mygrid_pull.flds = "选择,到款日期,频道名称,付款编号,业务员,划账金额,剩余金额,划归年份";
	}

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
	
//	 mygrid_pull.enableResizing("true,true,true,true,true,true,true,true,true,true");
    
    mygrid_pull.setOnRowSelectHandler(onRowSelected,true);
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




function initGrid_payment(){

	mygrid_payment = new dhtmlXGridObject('gridbox_payment');
	mygrid_payment.selMultiRows = true;
	mygrid_payment.setImagePath("image/grid/");


	if(config_withResourceSort !='1'){
		mygrid_payment.flds0 = "选择,";
		mygrid_payment.flds1 = "订单编号,合同编号,广告名称,付款次数,付款日期,应付金额,平账金额";
		mygrid_payment.flds = mygrid_payment.flds0 + mygrid_payment.flds1;
		mygrid_payment.newHeads = mygrid_payment.flds.split(",");
		mygrid_payment.setHeader(mygrid_payment.flds);
		var columnIds = "paymentId,orderCode,contractCode,matterName,payNum,payDay,payMoney,balanceMoney";
		mygrid_payment.setColumnIds(columnIds);
		mygrid_payment.setInitWidthsP("5,12,12,23,12,12,12,12");
		mygrid_payment.setColAlign("center,left,left,left,left,center,right,right");
		mygrid_payment.setColTypes("ch,link,ro,ro,ro,ro,ro,ro");
		//mygrid_pull.setColSorting("str,date,str,str")		

	}else{
//		mygrid_payment.flds0 = "选择,";
//		mygrid_payment.flds1 = "订单编号,合同编号,广告名称,付款次数,付款日期,应付金额,平账金额,分类";
//		mygrid_payment.flds = mygrid_payment.flds0 + mygrid_payment.flds1;
//		mygrid_payment.newHeads = mygrid_payment.flds.split(",");
//		mygrid_payment.setHeader(mygrid_payment.flds);
//		var columnIds = "paymentId,orderCode,contractCode,matterName,payNum,payDay,payMoney,balanceMoney,branch";
//		mygrid_payment.setColumnIds(columnIds);
//	
//		mygrid_payment.setInitWidthsP("5,12,12,18,11,12,12,12,6");
//		mygrid_payment.setColAlign("center,left,left,left,left,center,right,right,left");
//		mygrid_payment.setColTypes("ch,link,ro,ro,ro,ro,ro,ro,ro");


		mygrid_payment.flds0 = "选择,";
		mygrid_payment.flds1 = "订单编号,合同编号,广告名称,付款次数,付款日期,应付金额,平账金额,欠款金额,分类";
		mygrid_payment.flds = mygrid_payment.flds0 + mygrid_payment.flds1;
		mygrid_payment.newHeads = mygrid_payment.flds.split(",");
		mygrid_payment.setHeader(mygrid_payment.flds);
		var columnIds = "paymentId,orderCode,contractCode,matterName,payNum,payDay,payMoney,balanceMoney,arrears,branch";
		mygrid_payment.setColumnIds(columnIds);
	
		mygrid_payment.setInitWidthsP("5,11,11,14,8,12,12,11,11,6");
		mygrid_payment.setColAlign("center,left,left,left,left,center,right,right,right,left");
		mygrid_payment.setColTypes("ch,link,ro,ro,ro,ro,ro,ro,ro,ro");
		//mygrid_pull.setColSorting("str,date,str,str")	

	}	

   	mygrid_payment.setOnEditCellHandler(onEditPullGridCellHandler);
    mygrid_payment.setOnRowSelectHandler(onRowSelected,true);
//	mygrid_payment.setMultiLine(false);
	mygrid_payment.setEditable(true);
	mygrid_payment.setSkin("modern2");
	mygrid_payment.enableAlterCss("even","uneven"); 
	mygrid_payment.init();	 
	addPaymentDefaultHead();
//	if(config_withResourceSort =='1'){
//		resetHead(mygrid_payment,1);		
//	}else{
//		resetHead2(mygrid_payment,2);
//	}

}

function addPaymentDefaultHead(){
    attachHeaderNew(mygrid_payment,"<center><input type='checkBox' id='paymentAllSelect' value='0' onclick= 'javascript:selectCheckBoxAll(2)'></center>,"+mygrid_payment.flds1);
}


function onRowSelected(id,cellInd){
	
//	  var balanceModel = getBalanceModel();
	  var type = this.getUserData(id,"type");
      var v =  0;
 	  
      if(balanceModel == 1){
      	 if(type == 1) {
      	 	selectCheckBoxAll(1,false); 
      	 }
      	v = setCellCheck(this,id,0);
      }
      
      if(balanceModel == 2){
      	 if(type == 2){
      	 	 selectCheckBoxAll(2,false); 
      	 }
      	 v = setCellCheck(this,id,0);
      }     
      
      
     if(balanceModel == 3){
      	 v = setCellCheck(this,id,0);
      }   
      

//      if(balanceModel == 3){
//      	 if(type == 1) {
//      	 	selectCheckBoxAll(1,false); 
//      	 }else{
//      	 	v = setCellCheck(this,id,0);
//      	 }
//      }   
//      
//       if(balanceModel == 4){
//      	 if(type == 1) {
//      	 	v = setCellCheck(this,id,0);
//      	 }else{
//      	 	selectCheckBoxAll(2,false); 
//      	 }
//      }        

    
 	  
      if((balanceModel <3 && type == 1) || (balanceModel >2 && $("displayBalanceDetail").checked)){
      		getCarrieridsPullids(this,id,v,1);	
      }     
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


function setGridCheckDisabled(fromLoadGrid){
	
	  balanceModel = getBalanceModel();
	
	  var obj1 = $("incPullAllSelect");
	  var obj2 = $("paymentAllSelect");	
	   
	  setallCheckFalse(1);
	     
	  setallCheckFalse(2);
	       
	  changeButton(balanceModel)

	  
//	  if(balanceModel ==1 || balanceModel ==2){
//		 DWRUtil.setValue("lable_chooseFAPAI1",'一笔款平多份订单');
//		 DWRUtil.setValue("lable_chooseFAPAI2",'多笔款平一份订单'); 	
//	  }else{
//	  	 DWRUtil.setValue("lable_chooseFAPAI1",'返订单');
//	  	 DWRUtil.setValue("lable_chooseFAPAI2",'返发票'); 	
//	  }	  

	  if(balanceModel ==1 ){
	  	 obj1.disabled = true;
	  	 obj2.disabled = false;
	  	 selectCheckBoxAll(1,false); 
	  }
	
	  if(balanceModel ==2 ){
	  	 obj1.disabled = false;
	  	 obj2.disabled = true;
	  	 selectCheckBoxAll(2,false); 

	  }	  
	  
	  if(balanceModel ==3 ){
	  	 obj1.disabled = false;
	  	 obj2.disabled = false;		
	  }

}



function selectCheckBoxAll(type,isDisable,isShowTable){

	var obj;var grid;
	
	if(type == 0) return false;
	
//	var state = getRadioValue($("chooseCN").parentNode.parentNode);

	
	if(type == 1){
		obj = $("incPullAllSelect");
		grid = mygrid_pull;		
	}else{
		obj = $("paymentAllSelect");	
		grid = mygrid_payment;			
	}
	var col = obj.value;
	var rows = grid.getRowsNum();
	
	for(var i=0; i< rows;i++){
		var ch =  grid.cells2(i,0);
//        var disabled = ch.isChecked();
		if(grid.getRowByIndex(i).style.display ==""){
		     ch.setValue(obj.checked);
		}else{
		     ch.setValue(0);
		} 
//	    ch.setDisabled(disabled); 
		if(!isUndefined(isDisable)) ch.setDisabled(isDisable); 
	}	
	

	
	if(type == 1 && balanceModel == 2 ||isShowTable) {
		getCarrieridsPullids(grid,0);
	}


}


//function onRowSelectedPaymentGrid(id){
//		var cell = this.cells(id,0);
//		var v = cell.getValue()==0?1:0;
//		cell.setValue(v);
//}


  

function getCarrierIdsByid(cid,v){
	
	   var change = false;
	   
	   var arr = payment.obj.carrierIds;
	  
	   var carIds = new Array();
	   
		if (config_withResourceSort == 0 && cid != 0){
			
			if(config_useCarrierAliname == 1){
				
				if(cid.indexOf(",")>-1){
					var cids = cid.split(",");
					for(var i = 0;i<cids.length;i++){
						
						 if(!arr.contains(cids[i]) && v ==1){
						 	carIds.push(cids[i]);
						 	change = true;
						 }
						 
						 if(arr.contains(cids[i])&& v ==0){	
						 	arr = removeArrayByItem(arr,cids[i]); 
						 	change = true;
						 }
					}
				}else{
						 if(!arr.contains(cid) && v ==1){
						 	carIds.push(cid);
						 	change = true;
						 }
						 if(arr.contains(cid) && v ==0){	
						 	arr = removeArrayByItem(arr,cid) 
						 	change = true;
						 }						 
						 
				}

			}else{
						 if(!arr.contains(cid) && v ==1){
						 	carIds.push(cid);
						 	change = true;
						 }
						 
						 if(arr.contains(cid) && v ==0){	
						 	arr = removeArrayByItem(arr,cid); 
						 	change = true;
						 }							 
			}
		}else{
						 if(!arr.contains(cid) && v ==1){
						 	carIds.push(cid);
						 	change = true;
						 }
						 if(arr.contains(cid) && v ==0){	
						 	arr = removeArrayByItem(arr,cid); 
						 	change = true;
						 }							 
						 
		}
       
     
//	   if( v ==1){
	   	 payment.obj.carrierIds = payment.obj.carrierIds.concat(carIds);
//	   }else{
//	   	 payment.obj.carrierIds = arr;
//	   }
        
	   return change;
}



function getSameIds(grid,cid){
	var paymentids = new Array();
	for(var i=0; i< grid.getRowsNum();i++){
		var v = grid.cells2(i,0).getValue();
		var uid = grid.getUserData(grid.getRowId(i),"userId");	
		if(v == 1 && cid == uid) return false;
	}
	return true;
}

function getUserIdsByid(cid,v){
	
	   var change = false;
	   
	   var arr = payment.obj.userIds;
	   
	  
	   var carIds = new Array();
	   
	   var ha = false;
	   
	   if(v == 0){
		  ha = getSameIds(mygrid_pull,cid);			 
	    }	   
	   
	   
		if (cid > 0){
			             
			          
	
						 if(!arr.contains(cid) && v ==1){
						 	carIds.push(cid);
						 	change = true;
						 }
						 
			
						 
						 if(arr.contains(cid) && v ==0 && ha){
						 	arr = removeArrayByItem(arr,cid); 
						 	change = true;
						 }							 
			
		}else{
						 if(!arr.contains(cid) && v ==1){
						 	carIds.push(cid);
						 	change = true;
						 }
						 if(arr.contains(cid) && v ==0 && ha){
						 	arr = removeArrayByItem(arr,cid); 
						 	change = true;
						 }							 
						 
		}
       
       if(change){
		   if(v ==1){
		   	 payment.obj.userIds = payment.obj.userIds.concat(carIds);
		   }else{
		   	 payment.obj.userIds = arr;
		   }
       }
     

        
	   return change;
}

function getCarrieridsPullids(grid,id,v,from){
//	var balanceModel = getBalanceModel();
	var gridType = grid.getUserData(id,"type");
	
	var changed = false;
	var uchanged = false;
	
	var o_pid;var o_cid;var o_uid;	
	
	
	  
	

	if(gridType == 1){
		
		var cid =(config_withResourceSort == 1)?mygrid_pull.getUserData(id,"resourceTypeId"):mygrid_pull.getUserData(id,"resourceCarrierId");
		var uid = mygrid_pull.getUserData(id,"userId");		

	        if(balanceModel == 1){
	        	payment.obj.carrierIds.clear();
				payment.obj.userIds.clear();
				payment.obj.incPullIds.clear();
				
				payment.obj.incPullIds.push(id);
				payment.obj.userIds.push(uid);
				changed =  getCarrierIdsByid(cid,v);
				uchanged =  getUserIdsByid(uid,v);
	        }
	        
//	          alert('gridType'+gridType)
//	           alert('balanceModel'+balanceModel)
	        
	        if(balanceModel == 2){

				if(!payment.obj.incPullIds.contains(id)){
					payment.obj.incPullIds.push(id);
				}
//				if(!payment.obj.userIds.contains(uid)){
//					payment.obj.userIds.push(uid);
//				}
				changed =  getCarrierIdsByid(cid,v);
//				alert('changed'+changed)
				uchanged = getUserIdsByid(uid,v);
//				alert('changed'+changed)
	        }
	        
	        if(balanceModel == 3 && $("displayBalanceDetail").checked){
	        	
	        	payment.obj.carrierIds.clear();
				payment.obj.userIds.clear();
				payment.obj.incPullIds.clear();
				
				payment.obj.incPullIds = getPayMentIds(mygrid_pull);
			    
			    if($("displayBalanceDetail").checked) changed = true;

	        }	        
	        

	} // if gridType
	
	
	
	if(id == 0){
			payment.obj.carrierIds.clear();
			payment.obj.incPullIds.clear();
			payment.obj.userIds.clear();
			
//			$("incPullAllSelect").checked =false;
//			selectCheckBoxAll(1)
	
			for(var i=0; i< grid.getRowsNum();i++){
				
				var v  =  grid.cells2(i,0).getValue();
				var id = grid.getRowId(i);
				var cid = (config_withResourceSort == 1)?mygrid_pull.getUserData(id,"resourceTypeId"):mygrid_pull.getUserData(id,"resourceCarrierId");
	
				var uid = mygrid_pull.getUserData(id,"userId");
				var isVisiable = grid.getRowByIndex(i).style.display =="";
				
				if(!payment.obj.carrierIds.contains(cid) && isVisiable && v==1){
					changed =  getCarrierIdsByid(cid,v);
				}
				if(!payment.obj.incPullIds.contains(id) && isVisiable && v==1){
					payment.obj.incPullIds.push(id);
				}
				if(!payment.obj.userIds.contains(uid) && isVisiable && v==1){
					payment.obj.userIds.push(uid);
				}
			} //for			
	        changed = true;
	}
	
	
//       if(payment.obj.carrierIds.size() == 0) payment.obj.carrierIds.push(-1);
//       alert('changed>>>>'+changed);
//        alert('payment.obj.carrierIds>>>>>>>'+payment.obj.carrierIds);
//         alert('payment.obj.incPullIds>>>>>>>>>>>>>>'+payment.obj.incPullIds);		
    

//     alert('changed'+changed)
//     alert('uchanged'+uchanged)
    



    if(channelPullParam == 1 && (changed||uchanged))  getPayments();

	
    
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
		attachHeaderNew(grid,"<center><input type='checkBox' id='paymentAllSelect' value='0' onclick= 'javascript:selectCheckBoxAll(2)'></center>,<input type='text' id='orderCode' style='width:110%;CURSOR: pointer;' onclick=this.value=''  value='订单编号' onkeypress='getPayments_keyPress1(event)' onblur='clear_orderCode()'>, <input type='text' id='contractCode' style='width:110%;CURSOR: pointer;' onclick=this.value=''  value='合同编号' onkeypress='getPayments_keyPress2(event)' onblur='clear_contractCode()'>,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan");
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




function attachHeaderNew(grid,htm){
	var h = htm.split(",");
	
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
           
			var tStr = (config_withResourceSort == 1)?mygrid_pull.getUserData(id,"resourceTypeId"):mygrid_pull.getUserData(id,"resourceCarrierId");
			
//			 alert(tStr); alert(tVal);
			 
			var aStr = mygrid_pull.getUserData(id,"incomeCode").toString().toLowerCase();
//			var aStr = mygrid_pull.cells2(i,3).getValue().toString().toLowerCase();
//			var uStr = mygrid_pull.cells2(i,4).getValue().toString().toLowerCase();
			var uStr = mygrid_pull.getUserData(id,"userId");
			var dStr = mygrid_pull.cells2(i,7).getValue().toString().toLowerCase();
			
//			alert(aStr+'>>>>>>>>>'+aVal);
		
			
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
		
		

		selectCheckBoxAll(1,false,true);
 


		
	}
	
//	function getSelectedValueFromHead(){
//			var signUserId = $("signUserId").value;
//			mygrid_pull.signUserId = signUserId > 0?signUserId:0;
//			
//			if(signUserId > 0){
//				payment.obj.userIds.clear();
//				payment.obj.userIds.push(signUserId);
//			}
//			
//			
//			if (config_withResourceSort == 1){
//				var resourceTypeId = $("resourceTypeId").value;
//				mygrid_pull.resourceTypeId = resourceTypeId > 0?resourceTypeId:0;
//				if(resourceTypeId > 0){
//					payment.obj.carrierIds.clear();
//					payment.obj.carrierIds.push(resourceTypeId);
//				}
//			}else{
//				var carrierId = $("carrierId").value;
//				mygrid_pull.carrierId = carrierId > 0?carrierId:0;
//				if(carrierId > 0){
//					payment.obj.carrierIds.clear();
//					payment.obj.carrierIds.push(carrierId);
//				}				
//			}
//
//			
//	}
	function setSelectedValueFromHead(col){
		if(col == 4){
			if(mygrid_pull.signUserId>0){
				$("signUserId").value = mygrid_pull.signUserId;
//				filterBy();
			}
		}
		if(col == 2){
			if (config_withResourceSort == 1){
				if(mygrid_pull.resourceTypeId>0){
					$("resourceTypeId").value = mygrid_pull.resourceTypeId;
//					filterBy();
				}				
			}else{
				if(mygrid_pull.carrierId>0){
					$("carrierId").value = mygrid_pull.carrierId;
//					filterBy();
				}				
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
			if(col == 3) authNm = mygrid_pull.getUserData(id,"incomeCode");
			
			var authVal  = authNm;
			if(col == 4) authVal = mygrid_pull.getUserData(id,"userId");
			if(col == 2) authVal = (config_withResourceSort == 1)?mygrid_pull.getUserData(id,"resourceTypeId"):mygrid_pull.getUserData(id,"resourceCarrierId");
			

			if(usedAuthAr._dhx_find(authNm)==-1){
				selObj.options.add(new Option(authNm,authVal));
				usedAuthAr[usedAuthAr.length] = authNm;
			}
		}
		setSelectedValueFromHead(col);
	}
	

function getCustomerCommand(fnct,orgId){
	var customerId = $("customerId").value;
	var mode = 'local';
	if(customerId == ''){
		mode = 'remote';
	}else{
		customer.obj.customerName = 'local';
	}
  
 
   customer.obj.orgId =  config_oneOrgMoreSuborgsParam == '1'?1:$('orgId').value;
   var storeCustomer = customer.getStoreCustomersAnalyze(mode,customer.obj);   
    
   if(!customerCommand){
	   customerCommand =new Ext.form.ClearableComboBox({
		 	  id:'customerName',
		 	  name:'customerName',
			  renderTo:'extCustomerDiv2',
			  tiggerAction:'all',
			  store:storeCustomer,
			  editable: true,
//			  triggerAction: 'all', //query all
			  lastQuery:'l',
			  displayField:'customerName',
			  valueField:'id',
			  mode:mode,
			  allowBlank:false,
			   width:200,
			   forceSelection:false, 
			  allowBlank:false,
			  emptyText:'请选择客户...',
			  minChars:2,
			  hiddenName:'helpCode', //提交传过去的值 
			  params:customer.obj,
			  listeners:{beforequery:customer.comboFilterBy.createDelegate(this)}	
		 });
   }

	 
	 
	 customerCommand.on("select" , function(box)
    {
//        alert(box.getValue() + "-" + box.getRawValue());
        var state = getRadioValue($("chooseCN").parentNode.parentNode);
        var customerId = box.getValue();
        $("customerId").value = customerId; 
       
        if(state == 1){
        	 getIncomePulls();
        	 mygrid_payment.clearAll();
        }else{
        	 getTables(customerId);
        }
    });
    
    
   
    
    storeCustomer.on("load",function(){
    	if(fnct) fnct();
    })
    
    if(mode == 'remote'){
    	if(fnct) fnct();
    }
	 
} 



function inti_set_customer(id,customerName){

			 	    	
	var rc1 = Ext.data.Record.create(customer.fileds);
    var rc = new rc1({
           id : id,
           customerName:customerName
     });
     
    var customerCommand = Ext.getCmp("customerName");
    customerCommand.clearValue(); 
   	customerCommand.store.add(rc);
   	customerCommand.setValue(id);  
}



function buttonEventFill(){
	  
	var btn_chooseCN = $("chooseCN"); 
	btn_chooseCN.onclick = choseBalanceMode;
	
	var btn_chooseCN2 = $("chooseCN2");
	btn_chooseCN2.onclick = choseBalanceMode;
	
	$("income_year").onchange = choseBalanceMode;
	$("order_year").onchange = choseBalanceMode;	

	var btn_chooseFAPAI1 = $("chooseFAPAI1"); 
	btn_chooseFAPAI1.onclick = setGridCheckDisabled;
	
	var btn_chooseFAPAI2 = $("chooseFAPAI2");
	btn_chooseFAPAI2.onclick = setGridCheckDisabled;	
	
	
	var btn_search = $("btn_search");
	btn_search.onclick = saveIncomeUsed2;
	
//	var btn_putBack = $("btn_putBack");
//	btn_putBack.onclick = saveIncomeUsed2;
	
	
	var btn_cancel = $("btn_cancel");
	btn_cancel.onclick = cancelIncomePull;
	
	
//	var Btn_orderCode = $("orderCode");
//	Btn_orderCode.onkeypress = getPayments_keyPress1;
//	Btn_orderCode.onblur = clear_orderCode;
//	
//	var Btn_contractCode = $("contractCode");
//	Btn_contractCode.onkeypress = getPayments_keyPress2;
//	Btn_contractCode.onblur = clear_contractCode;
	
	
//	var Btn_addIncome = $("Btn_addIncome");
//	Btn_addIncome.setAttribute("href","javascript:void 0");
//	Btn_addIncome.onclick = addIncome;	

	
	var btn_displayBalanceDetail = $("displayBalanceDetail");
//	btn_displayBalanceDetail.onchange = function(){
//		displayBalanceDetail = btn_displayBalanceDetail.checked;
//		}
		
		
		btn_displayBalanceDetail.onchange =choseBalanceMode;
	
	document.body.onfocus = closePopup;
	
	
	
	
}






//function getSelectCustomerToTree(){
//	var id = Ext.getCmp("customerName").getValue();
//	var parentId = category.tree.getItemIdByIndex(0);
//	category.tree.dhtmlTree.closeAllItems(parentId);
//	category.tree.dhtmlTree.selectItem(customer.IdPrefix+id,true);
//	category.tree.dhtmlTree.focusItem(customer.IdPrefix+id);
//}


//function choseYearPull(){
//		payment.obj.carrierIds  = new Array();
//		payment.obj.incPullIds  = new Array();
//		payment.obj.userIds  = new Array();
//		choseBalanceMode();		
//}

function choseBalanceMode(){
	
	balanceModel = getBalanceModel();
	payment.obj.carrierIds  = new Array();
	payment.obj.incPullIds  = new Array();
	payment.obj.userIds  = new Array();
	
	

		

	if(balanceModel == 3 ){
		
		$("lable_chooseFAPAI1").parentNode.parentNode.hide();

			

		if(config_withResourceSort !='1'){
			resetHead(mygrid_payment,2);		
		}else{
			resetHead2(mygrid_payment,2);
		}		
			
		var Btn_orderCode = $("orderCode");
		Btn_orderCode.onkeypress = getPayments_keyPress1;
		Btn_orderCode.onblur = clear_orderCode;
		
		var Btn_contractCode = $("contractCode");
		Btn_contractCode.onkeypress = getPayments_keyPress2;
		Btn_contractCode.onblur = clear_contractCode;		
		
	}else{
        $("lable_chooseFAPAI1").parentNode.parentNode.show();
		addPaymentDefaultHead();
		
	}
	
	
	
//	$("chooseFAPAI1").checked =true;
	
	 setGridCheckDisabled();
	 
	 getTables($("customerId").value);
}


	 




function getTables(customerId){
	
	$("signUserId").value = 0;
	
	if(config_withResourceSort == 1){
			$("resourceTypeId").value = 0;
	}else{
			$("carrierId").value = 0;
	}


	if(customerId > 0){
		$("customerId").value = customerId;
//		mygrid_payment.clearAll();mygrid_pull.clearAll();
		getTowTables();
	}

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
//			$("btn_putBack").disabled=false;
	}
	
	if(state == 1){
		
		if(pullIds.length <1){
	
			myUtils.myMessage('请选择需要分配的到款记录!');
			return false;
		}
		if(paymentIds.length <1){

			myUtils.myMessage('请选择需要分配的付款记录!');
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
				var carrierId = (config_withResourceSort == 1)?mygrid_pull.getUserData(incomePullId,"resourceTypeId"):mygrid_pull.getUserData(incomePullId,"resourceCarrierId");
				
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
	
			myUtils.myMessage('请选择需要分配的到款记录!');
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
		
			myUtils.myMessage('请先选择要返还的记录,再点返还!');
			return false;
		}
		$("btn_search").disabled=true;
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
		    Ext.getBody().unmask();
			getTowTables();
			$("btn_search").disabled=false;
//			$("btn_putBack").disabled=false;
	}
	
	if(state == 1){
		
//		if(pullId ==0 ||pullId == ''||pullId == null ||pullId == 'null'){
//
//			myUtils.myMessage('请选择需要分配的到款记录!');
//			return false;
//		}
//		
		if(pullIds.length <1){
			myUtils.myMessage('请选择到款记录!');
			return false;
		}
		
		if(paymentIds.length <1){
			myUtils.myMessage('请选择需要分配的订单!');
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
				paymentObj.obj.incomePulls = new Array();
				
				var incomePullId = pullId;
				var incomeId = mygrid_pull.getUserData(incomePullId,"incomeId");
				var carrierId = (config_withResourceSort =='1')?mygrid_pull.getUserData(incomePullId,"resourceTypeId"):mygrid_pull.getUserData(incomePullId,"resourceCarrierId");
				var balanceMoney = mygrid_pull.cells(incomePullId,6).getValue();
				var version = $("order_year").value;
				
				
				
				var paymentId =  mygrid_payment.getRowId(i);
				var moneyPay  =  mygrid_payment.getUserData(paymentId,"moneyPay");
				var moneyIn  =   mygrid_payment.getUserData(paymentId,"moneyIn");
				var contractId = mygrid_payment.getUserData(paymentId,"contractId");
				var orderId =    mygrid_payment.getUserData(paymentId,"orderId");
//				var memo =       mygrid_payment.getUserData(paymentId,"memo");
				var resourceTypeId =  mygrid_payment.getUserData(paymentId,"resourceTypeId");
				
				if(carrierId =="") carrierId = 0;
				if(balanceMoney  =="") balanceMoney  = 0;
				

				
				
			
//					用于后台判断是哪种平账模式
				  //多笔到款平一份订单
					for(var k = 0;k<pullIds.length;k++){
						var incomePullObj = (new IncomePull()).obj;
						var id = pullIds[k];
						var balanceMoney = mygrid_pull.cells(id,6).getValue();
						incomePullObj.id = id;
						incomePullObj.incomeId = mygrid_pull.getUserData(id,"incomeId");
						incomePullObj.moneyPull = balanceMoney == ''||balanceMoney == null?0:balanceMoney;
	                     //carrierId
						incomePullObj.memo  = (config_withResourceSort =='1')?mygrid_pull.getUserData(id,"resourceTypeId"):mygrid_pull.getUserData(id,"resourceCarrierId");
						paymentObj.obj.incomePulls.push(incomePullObj);
					}					
					
					
				
		

                 
				
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
					
					paymentObj.incPullIds = pullIds;
					paymentObj.obj.moneyPay = moneyPay*1;				
					paymentObj.obj.moneyIn = moneyIn*1;
					paymentObj.obj.contractId = contractId;
					paymentObj.obj.orderId = orderId;
//					paymentObj.obj.memo = memo;
                   
					paymentObj.obj.resourceTypeId = resourceTypeId;
					
				
					paymentObj.obj.state = balanceModel;
					

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
			Ext.getBody().mask('数据处理中……', 'x-mask-loading');
    		
			payment.savePutonMoneyByObj(paymentObjs,callBack);
		}else{
			myUtils.myMessage('请选择需要分配的到款记录!');
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
			myUtils.myMessage('请先选择要返还的记录,再点返还!');
			return false;
		}
		$("btn_search").disabled=true;
		Ext.getBody().mask('数据处理中……', 'x-mask-loading');
		payment.saveBackPaymentMoneyByObj(paymentObjs,callBack);

	}	
}



	
function getIncomePulls(){

   	setallCheckFalse(1);
   	mygrid_pull.clearAll();
   	$("incPullAllSelect").checked =false;
   	
	var customerId = Ext.getCmp("customerName").getValue();
	


	
	if(customerId == 0||customerId== '') return false;
	var state = getRadioValue($("chooseCN").parentNode.parentNode);
	var version = $("income_year").value;
        

	var func = function(xml){
		if(xml ==''||isUndefined(xml)){return false;}
		mygrid_pull.loadXMLString(xml);
		restHeadComnand();
	}
	
	
	
		 
	incomePull.reset();
	incomePull.obj.income = (new Income()).obj;
	incomePull.obj.income.customerId = customerId;
	incomePull.obj.income.state = state;
	incomePull.obj.version = version;
	incomePull.obj.id = config_isSignUserBalance;//判断是否业务员平帐
	incomePull.obj.orgId =  $("orgId").value;
	
	var cmd  =  Ext.getCmp("inc_code");
	if(cmd){
		var incomeId =   Ext.getCmp("inc_code").getValue();
		if(incomeId >0 ) incomePull.obj.incomeId =incomeId;
	}

	

	 
	incomePull.getIncomesPullsXML(incomePull.obj,func);

}




function getPayments(){ 
	
  
  
  
	mygrid_payment.clearAll();

	$("paymentAllSelect").checked =false;


	var customerId = Ext.getCmp("customerName").getValue();
	
	
	if(findOrderCode ==true || findContractCode ==true){
		
	}else{

		if(customerId =='') return false;
	}
	
 

	
	var state = getRadioValue($("chooseCN").parentNode.parentNode);
//	if(payment.obj.carrierIds.length == 0 ) payment.obj.carrierIds.push(-1);

  
	var version = $("order_year").value;


	$("btn_search").disabled = true;
    Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	
	var carrierId;
	
	var func = function(xml){

		$("btn_search").disabled = false;
//		if(xml ==''||isUndefined(xml)){return false;}
		mygrid_payment.loadXMLString(xml);
		Ext.getBody().unmask();
	}
	

    
	payment.reset();	
	payment.obj.userIds.clear();
	payment.obj.customerId = customerId;
	payment.obj.version = version;
	payment.obj.state = state;
	payment.obj.orgId =  $("orgId").value;	

	
	if(balanceModel ==1 || balanceModel ==2) payment.obj.incPullIds = new Array();
 


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
	
//	if(config_withResourceSort == '1'){
//		payment.obj.userIds=[userName];
//	}
//
//	payment.obj.userIds=[userName];
	
	
	     

	
	
//	alert(payment.obj.carrierIds);
	
//	if(payment.obj.carrierIds.length == 1 && payment.obj.carrierIds[0]==-1){
//		Ext.getBody().unmask();
//		 return false; 
//	}
//alert(payment.obj.carrierIds)


//	alert('find')
//	alert(payment.obj.carrierIds.length)
//	alert( payment.obj.carrierIds[0]==-1 )


	payment.getContractPaymentXML(payment.obj,func);
		
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
//	payment.obj.carrierIds = new Array();
//	payment.obj.incPullIds =  new Array();
//	payment.obj.userIds  =  new Array();
	getIncomePulls();
	getPayments();	
}


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

}

//function resetText(ev){
//	 $("customerName").value = null;
//	 $("customerId").value = null;
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
	 
	 if(!Ext.isArray(payment.obj.carrierIds)) payment.obj.carrierIds =  new Array();
	 
//	 payment.obj.carrierIds.push(-1);
	  
}


function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "customerId";
}


function changeButton(bln){
	
	


	  
	  
	if(bln == 1 || bln == 2){
		$("displayBalanceDetail").hide();
		$("displayBalanceDetailLabel").hide();
		
//		DWRUtil.setValue("btn_search",'&nbsp;&nbsp;分配&nbsp;&nbsp;');
		$("btn_search").value = "     分配     ";

	}else{
		$("displayBalanceDetail").show();
		$("displayBalanceDetailLabel").show();
		
//		DWRUtil.setValue("btn_search",'&nbsp;&nbsp;返还&nbsp;&nbsp;');
		$("btn_search").value = "     返还     ";
	}
	
	if(!tag_orderList_finance)$("btn_search").hide();
	
}

function getBalanceModel(){
	  var state1 = getRadioValue($("chooseCN").parentNode.parentNode);
	  var state2 = getRadioValue($("chooseFAPAI1").parentNode.parentNode);

	  if(state1 == 1 & state2 == 1) balanceModel = 1;
	  if(state1 == 1 & state2 != 1) balanceModel = 2;
	   if(state1 != 1 ) balanceModel = 3;
//	  if(state1 != 1 & state2 == 1) balanceModel =3;
//	  if(state1 != 1 & state2 != 1) balanceModel =4;
	  
	  return balanceModel;
}

function replace(s){
	var index = s.indexOf("^");
	if(index >-1 ) s = s.substring(0,index);
	return s;
}

function getPayments_keyPress1(ev){ 

	var state = getRadioValue($("chooseCN").parentNode.parentNode);
//	$("chooseFAPAI1").checked =true;
//	setGridCheckDisabled();
	 if(ev.keyCode == 13){
	 	
		 if(getElementByEvent(ev).value.length<3){
			myUtils.myMessage('输入编号位数不能不小于2');
//			Ext.Msg.alert("系统提示","输入编号位数不能不小于2"); 
			return false;
		 }
	
	 	 findOrderCode = true;
	 	 findContractCode = false;
	 	 
	 	 getPayments();		
	 }
}

function getPayments_keyPress2(ev){ 

	var state = getRadioValue($("chooseCN").parentNode.parentNode);
//	$("chooseFAPAI1").checked =true;
//	setGridCheckDisabled();	

	 if(ev.keyCode == 13){
	 	
		 if(getElementByEvent(ev).value.length<3){
			myUtils.myMessage('输入编号位数不能不小于2');
			return false;
		 }	 	
	 	
	 	 findContractCode = true;
	 	 findOrderCode = false;
	 	 
	 	 getPayments();		
	 }
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

function setCellCheck(grid,id,colIndex){
	var cell = grid.cells(id,colIndex);
	var v = cell.getValue()==0?1:0;
	cell.setValue(v);	
	return v;
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

function removeArrayByItem(soure,item)
  {
  	var dx = soure.indexOf(item);

    if(isNaN(dx)||dx>soure.length){return false;}
    for(var i=0,n=0;i<soure.length;i++)
    {
        if(soure[i]!=soure[dx])
        {
            soure[n++]=soure[i]
        }
    }
    soure.length-=1
    
    return soure;
  }