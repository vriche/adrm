//Ext.override(Ext.form.NumberField, {
//    baseChars: "0123456789,",
//    setValue: function(v){
//        v = typeof v == 'number' ? v : String(v).replace(this.decimalSeparator, ".").replace(/,/g, "");
//        //v = isNaN(v) ? '' : String(v).replace(".", this.decimalSeparator);
//        v = isNaN(v) ? '' : Ext.util.Format.number(this.fixPrecision(String(v)), "0,000,000.00");
//            this.setRawValue(v);
//        return Ext.form.NumberField.superclass.setValue.call(this, v);
//    },
//    fixPrecision: function(value){
//        var nan = isNaN(value);
//        if (!this.allowDecimals || this.decimalPrecision == -1 || nan || !value) {
//            return nan ? '' : value;
//        }
//        return parseFloat(value).toFixed(this.decimalPrecision);
//    },
//    validateValue: function(value){
//        if (!Ext.form.NumberField.superclass.validateValue.call(this, value)) {
//            return false;
//        }
//        if (value.length < 1) { // if it's blank and textfield didn't flag it then it's valid
//            return true;
//        }
//        value = String(value).replace(this.decimalSeparator, ".").replace(/,/g, "");
//        if (isNaN(value)) {
//            this.markInvalid(String.format(this.nanText, value));
//            return false;
//        }
//        var num = this.parseValue(value);
//        if (num < this.minValue) {
//            this.markInvalid(String.format(this.minText, this.minValue));
//            return false;
//        }
//        if (num > this.maxValue) {
//            this.markInvalid(String.format(this.maxText, this.maxValue));
//            return false;
//        }
//        return true;
//    },
//    parseValue: function(value){
//        value = parseFloat(String(value).replace(this.decimalSeparator, ".").replace(/,/g, ""));
//        return isNaN(value) ? '' : value;
//    }
//});

			String.prototype.replaceall=function(s1,s2)
			{
			 var demo=this
			  while(demo.indexOf(s1)!=-1)
			  demo=demo.replace(s1,s2);
			  return demo;
			}

//			String.prototype.replaceAll = function(s1,s2){   
//					return this.replace(new RegExp(s1,"gm"),s2);   
//			}


    Ext.ux.NuberFiledFormat=Ext.extend(Ext.form.NumberField, {  
        baseChars: "0123456789,.",  
//        setValue: function(v){  
//            v = typeof v == 'number' ? v : String(v).replace(this.decimalSeparator, ".").replace(/,/g, "");  
//             v = isNaN(v) ? '' : rendererZhMoney(v);  
//              
//            //Ext.util.Format.number(this.fixPrecision(String(v)), "0,000,000.00");此为ext 4.0   
//                this.setRawValue(v);  
//            return Ext.form.NumberField.superclass.setValue.call(this, v);  
//                        },  


    setValue: function(v){
        v = typeof v == 'number' ? v : String(v).replace(this.decimalSeparator, ".").replace(/,/g, "");
        //v = isNaN(v) ? '' : String(v).replace(".", this.decimalSeparator);
        v = isNaN(v) ? '' : Ext.util.Format.number(this.fixPrecision(String(v)), "0,000,000,000.00");
            this.setRawValue(v);
        return Ext.form.NumberField.superclass.setValue.call(this, v);
    				},
        getValue:function(){ 
            //alert((String(Ext.form.NumberField.superclass.getValue.call(this)).replace(",",""))); 
            var str = String(Ext.form.NumberField.superclass.getValue.call(this)); 
            
											str = str.replaceall(",","");
								
											            
//            var reg = new RegExp(str,",");
//            return str.replace(reg,"");
                       
                                              
                     return str;
            
//            return string.replace(new RegExp(String(Ext.form.NumberField.superclass.getValue.call(this)),","),"")) 
                         
//            return (String(Ext.form.NumberField.superclass.getValue.call(this)).replace(",","")); 
            
            
        }, 
       
        fixPrecision: function(value){  
            var nan = isNaN(value);  
            if (!this.allowDecimals || this.decimalPrecision == -1 || nan || !value) {  
                return nan ? '' : value;  
            }  
            return parseFloat(value).toFixed(this.decimalPrecision);  
        },  
        validateValue: function(value){  
        	
//            if (!Ext.form.NumberField.superclass.validateValue.call(this, value)) {  
//                return false;  
//            					}  
            if (value.length < 1) { // if it's blank and textfield didn't flag it then it's valid  
                return true;  
            					}  
            value = String(value).replace(this.decimalSeparator, ".").replace(/,/g, "");  
            if (isNaN(value)) {  
                this.markInvalid(String.format(this.nanText, value));  
                return false;  
            					}  
            var num = this.parseValue(value);  
            if (num < this.minValue) {  
                this.markInvalid(String.format(this.minText, this.minValue));  
                return false;  
            					}  
            if (num > this.maxValue) {  
                this.markInvalid(String.format(this.maxText, this.maxValue));  
                return false;  
            					}  
            					
            return true;  
       				 },  
        parseValue: function(value){  
            value = parseFloat(String(value).replace(this.decimalSeparator, ".").replace(/,/g, ""));  
            return isNaN(value) ? '' : value;  
        }  
    });  
    //注册扩展后的数字控件  
    Ext.reg('numberFieldFormat', Ext.ux.NuberFiledFormat);  



var org = new SysOrg();
var customer = new Customer();
var income = new Income();
var carrier = new Carrier();
var channel = new ResourceChannel();
var payment = new PayMent();
var myDate = new MyDate();

//var customer = new Customer();
var user = new User();
var myUtils = new MyUtils();
var incomePull = new IncomePull();

var mygrid;
var mygrid2;
var mygrid3;
var mygrid4;
var mygrid5;

var fromPannel;
var queryWindow;
var incomeWindow;
var regCustomerWin;
var winWidth;
var winHeight;
var report = new MyPrint();
var resourceType = new ResourceType();
var category = new Category();
var orderDetail = new OrderDetail();

var incomeMode = new IncomeMode();
var incomePurpose = new IncomePurpose();

var utils;

var orgId = 1;

var ctxPath;
var paramObjForSort;


var scrollTop;	
var posStart;	
var total_count;	
var fromEditRowId = 0;	


var banlanceWin;
var shiduanWin;

callOnLoad(init);	

function init(){

	moreChannelNoPullParam = _app_params.sysParam.moreChannelNoPullParam;
	config_useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
	config_incomeCodeModelParam = _app_params.sysParam.incomeCodeModelParam;
	config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;
	isSignUserBalance = _app_params.sysParam.isSignUserBalance;
	loginUser =  _app_params.user.username;	
	loginUserId =  _app_params.user.id;
    tvNameParam =  _app_params.sysParam.tvNameParam;
    ctxPath =  _app_params.ctxPath;	 	
    config_serviceDate = _app_params.serviceDate.def;
    config_withResourceSort =  _app_params.sysParam.withResourceSort;
    utils = new MyUtils( _app_params.sysParam.serviceDate);
    this.ctxPath = _app_params.ctxPath;    
    $("order_year").value = _app_params.serviceDate.year;
    
    	_make_adrm_sys_year_select("order_year",_app_params.serviceDate.adrmSysYear);
    
 
    curYear = _app_params.serviceDate.year;
    getDate(_app_params.serviceDate.def);
    
    $("order_year").hide();
		 $("month").hide();
//    $("Btn_modIncome").hide();
		 $("Btn_deleteIncome").hide();		 
		 $("btn_returnPuton").hide();				 
		 

                        
		 

    
    function funOrg(){orgId = $("orgId").value; };
    _make_org_select("orgId",100,"onChangeOrg");	
    orgId = $("orgId").value;
    $("fenpeiInfo").value = 1;
    
       
    
	setIncomePara(income);
	setCustomerPara(customer);
	setCarrierPara(carrier);
	
	
	buttonEventFill();


  	 
  
//     	var fct = function(){loadGridData();}
     	
//     	initCustomerCommand();

     	
//     	if(config_withResourceSort == 1){
//     		initResourceType(); 
//     		 $("carrierName").hide();
//     	}else{
//     		if(moreChannelNoPullParam == 1) {
//     				 initCarrier(fct); 	
//     				 $("extResourceTypeIdDiv").hide();
//     		}else{
//     			 $("carrierName").hide();
//     		}
//     	}

// 		if(moreChannelNoPullParam == 1) {
// 			 $("putToChannel").hide();
// 		}
 	

  	this.report.buildButtons(this,"printReportDiv",[0,1,2],70);
    
		initGrid();
 	
		initGrid2();
 	
		initGrid3();
		
		initGrid4();
		
		initGrid5();

		resetHeigth();	
 	
		loadGridData();
 
 }
 
 
 function onChangeOrg(){

 	orgId = config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;	
 	var carrierCmd =  Ext.getCmp('carrier_id');  
 	if(carrierCmd){
 		carrierCmd.clearValue(); 
		var store1 = carrierCmd.getStore();
		store1.baseParams.dwrParams[0].orgId = orgId; 
		store1.reload();
 	}
 	
 	
 	loadGridData();
 }
 
function resetHeigth(){
    var dialogcontent = $("dialogcontentDiv");

    $("gridbox").style.height = dialogcontent.offsetHeight * 0.5 +"px";
//    $("gridbox2").style.height = $("gridbox").style.height;	
    $("gridbox3").style.height = dialogcontent.offsetHeight * 0.35 +"px";	
//    $("gridbox4").style.height = dialogcontent.offsetHeight * 0.35 +"px";	
//    $("gridbox5").style.height = dialogcontent.offsetHeight * 0.35 +"px";	
    
 	var dialogcontent = $("dialogcontentDiv");
	var dialogcontentW = dialogcontent.offsetWidth;
	var dialogcontentH = dialogcontent.offsetHeight;
	winWidth= dialogcontentW * 0.7;
	winHeight = dialogcontentH*0.8;     
} 
 


//function initCustomerCommand(func){
// 	    var paramObJ2 ={};
//	 	paramObJ2.version = $("order_year").value;
//	 	paramObJ2.orgId =  $("orgId").value;
//	 	paramObJ2.loginUser = loginUser;
//	 	customer.obj = paramObJ2;
//	 	
//	   customer.getCustomerFromOrder("extCustomerDiv","customerName2",150,function(){})	
// }
 
//  function initCarrier(fnct){
//    carrier.obj.nodeLevel = 1;
//    carrier.obj.orgId = orgId;
//	//根据是否分频道，取得频道下拉列表
//	carrier.makeSelectItemAnalyze5(carrier,"carrierName","loadGridData",100,false,loginUser,fnct);
//
//}


// function initResourceType(fnct){
// 	  	var paramObj3 ={};
//	 	paramObj3.version =  $("order_year").value;
//	 	paramObj3.orgId = $("orgId").value;
//	 	resourceType.obj = paramObj3;
//	    var resourceTypeCmd = resourceType.getLovCombo('resourceTypeId',true);
//	    resourceTypeCmd.separator="_";	
//	    resourceTypeCmd.render('extResourceTypeIdDiv');
//	    
// }
 
 
//function initGrid_bak(){
//	
//	mygrid = new dhtmlXGridObject('gridbox');
//	mygrid.selMultiRows = true;
//	mygrid.delim ="*"
//	mygrid.setImagePath(ctxPath+"image/grid/");
//	var flds = "序号,到款编号,到款日期,划归年份,客户名称,业务员,频道,到款金额,分配金额,余款,用途,用途,备注";
//	mygrid.setHeader(flds);
//	var columnIds = "filed1,filed2,filed3,filed4,filed5,filed6,filed7,filed8,filed9,filed10,filed11,filed12,filed13";
//	mygrid.setColumnIds(columnIds);
//	
//    mygrid.setInitWidthsP("4,8,8,8,16,8,4,8,8,8,5,5,10");
//	mygrid.setColAlign("center,right,center,center,left,right,right,right,right,right,center,center,left");
//	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
//
//   	mygrid.setEditable(false);
//	mygrid.setOnScrollHandler(OnScrollHandler);
//	mygrid.setSkin("modern2"); 
//	mygrid.enableAlterCss("even","uneven"); 
//	mygrid.enableMultiselect(true); 
//	mygrid.enableKeyboardSupport(true);  
//	mygrid.setOnRowSelectHandler(onRowSelected,true);
//	mygrid.setOnRowDblClickedHandler(onRowDblClicked,true); 
//
//	mygrid.init();	 
//}

function initGrid(){
	
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.delim ="*"
	mygrid.setImagePath(ctxPath+"image/grid/");
	var flds = "序号*到款编号*到款日期*划归年份*客户名称*业务员*频道*到款金额*分配金额*余款*用途*用途*备注";
	mygrid.setHeader(flds);
	var columnIds = "filed1*filed2*filed3*filed4*filed5*filed6*filed7*filed8*filed9*filed10*filed11*filed12*filed13";
	mygrid.setColumnIds(columnIds);
	
    mygrid.setInitWidthsP("4*8*8*8*16*8*4*8*8*8*5*5*10");
	mygrid.setColAlign("center*right*center*center*left*left*right*right*right*right*center*center*left");
	mygrid.setColTypes("ed*ed*ed*ed*ed*ed*ed*ed*ed*ed*ed*ed*ed");

   	mygrid.setEditable(false);
	mygrid.setOnScrollHandler(OnScrollHandler);
	mygrid.setSkin("modern2"); 
	mygrid.enableAlterCss("even","uneven"); 
	mygrid.enableMultiselect(true); 
	mygrid.enableKeyboardSupport(true);  
	mygrid.setOnRowSelectHandler(onRowSelected,true);
	mygrid.setOnRowDblClickedHandler(onRowDblClicked,true); 

	mygrid.init();	 
}

function OnScrollHandler(sLeft,sTop){
//	posStart = mygrid.posStart2;
//	console.log(posStart);
//	scrollTop = mygrid.objBox.scrollTop;
    fromEditRowId = 0;
}
function onRowSelected(incomeId,cellInd){
	 var incomeUsed = mygrid.getUserData(incomeId,"incomeUsed");
	 var func = function(objs){
		
	 }	  
//	incomePull.reset();
//	incomePull.obj.incomeId = incomeId;
//	incomePull.getIncomePullsByIncomeId(incomePull.obj,func);	 

//	$("incomeUsedAllSelect3").checked = false;
//	$("incomeUsedAllSelect3").value = 0;	 

     fromEditRowId = incomeId;
     
     
  
	 if(incomeUsed >0){
//	 	    loadFenpeiInfo(id); 
            mygrid.iddd = incomeId;
          
			loadGridData3(0,incomeId,false);
//	 	    orderDetail.getMonthDetailByIncomeId(incomeId,callBack);
//	 	    
//	 	    function callBack(){
//	 	    	
//	 	    }
	 }else{
	 	mygrid3.clearAll();
	 	mygrid3.detachFooter(0);
	 }
}




 function loadGridData3(posStart,incomeId,fromSearch){
       
//        var paramObj = getLoadDataParams(posStart);

         if(incomeId == ''||incomeId == '0') incomeId = null;
        
         var paramObj = getLoadDataParams(posStart,fromSearch);
         
        
         
		if(incomeId > 0){
         	 paramObj.incomeId = incomeId;
         }
        
      
//		 paramObj = {
//	                version:$("order_year").value,
//	                incomeId: incomeId
//		 }        
         
         
        
	 	mygrid3.clearAll();
	 	mygrid3.detachFooter(0);

//	if(incomeId > 0){
//    mygrid3.enableSmartRendering(false);  
//	}else{
    mygrid3.enableSmartRendering(true);  
//	} 	
	   
	 	
//	 	if(posStart > 0 || posStart == 0){
//	 		 mygrid3.posStart = posStart;
//	 		 mygrid3.scrollTop = scrollTop;
//	 		 mygrid3.fromEditRowId = fromEditRowId; 
//	 		 mygrid3.enableSmartRendering(true,total_count);
//		}else{
//			 mygrid3.enableSmartRendering(true);
//		}	

		 loadDataURL ="servlet/incomeUsedListServlet?" + $H(paramObj).toQueryString();	
		 mygrid3.loadXML(loadDataURL);
		 mygrid3.setSizes();	
		
		

//		closeSearchDiv();        
 }	 
 
 
 
 function getBalanceMoney(id){
 	

 	
//  			var leaveMoney = mygrid.getUserData(id,"leaveMoney");			
// 			var txt = Ext.getCmp('leaveMoney_txt');
  			var leaveMoney = Ext.getCmp('leaveMoney_txt2').getValue(); 			
  			
			  var col = 0;
			  var col2 = 10;
			  var grid = mygrid2;
			  var rows = grid.getRowsNum();


			  try {
			  	
				  	for(var i=0; i< rows;i++){
				  		
						var ch =  grid.cells2(i,col);
						var banCell =  grid.cells2(i,col2);	
						var v = ch.getValue();
					  var id2 = grid.getRowId(i);
						if(v == 1){
								
								var cuikuan = grid.getUserData(id2,"cuikuan");
								var balancMoney = 0;
								var balancMoney_str ="";
							
								if(leaveMoney > 0){
									if(leaveMoney - cuikuan >= 0){
										balancMoney = cuikuan;
										leaveMoney = leaveMoney - cuikuan;
										ch.setValue(1);
									}else{
										balancMoney = leaveMoney;
										leaveMoney = 0;
										ch.setValue(0);
									}	
	//								balancMoney = parseInt(balancMoney, 10); 
									balancMoney = parseFloat(balancMoney);
									balancMoney_str = fmoney(balancMoney,2);
	
									banCell.setValue(balancMoney_str);
									
//									alert('id2>>>>'+id2 +'  balancMoney>>>'+balancMoney)
									grid.setUserData(id2,"ban_value",balancMoney);
									
									if(balancMoney > 0){
									   ch.setValue(1);	
									}else{
									   ch.setValue(0);
									}
									
									
									
								}else{
									banCell.setValue(0);
									grid.setUserData(id2,"ban_value",0);
									ch.setValue(0);
								}
							}else{
								    banCell.setValue(0);
								    grid.setUserData(id2,"ban_value",0);
								    ch.setValue(0);
							}
							
//								var banValue = grid.getUserData(id2,"ban_value");
//								alert('id2>>>>'+id2 +'  banValue>>>'+banValue)

					}
					
					
//					Ext.getCmp('leaveMoney_txt3').setValue(leaveMoney);	  
				
			  	} catch (e) {
			    	
			    }				
 }
 
 
  function saveBalanceMoney(){

			  var col = 0;
			  var col2 = 10;
			  var grid = mygrid2;
			  var rows = grid.getRowsNum();
			  var params ={};
			  var querStrs = [];
			  var k = 0;
			  var banValueSum = 0;
			 
			  var income_id = mygrid.getUserData(mygrid.iddd,"incomeId");	
			  var pull_id = mygrid.getUserData(mygrid.iddd,"pullId");	
			  
		

			  try {
			  	
				  	for(var i=0; i< rows;i++){
				  		
						var id2 = grid.getRowId(i);
						var ch =  grid.cells2(i,col);
						var banCell =  grid.cells2(i,col2);	
//						var banValue = banCell.getValue();
						var banValue = grid.getUserData(id2,"ban_value");
					
						var v = ch.getValue();
						
//								alert('id2>>'+id2+ '       V>>'+v+ "   banValue>>"+banValue)
					

//.replace(",","")
						if(v == 1 && banValue >0){
							
							var order_id = grid.getUserData(id2,"order_id");
							var customer_id = grid.getUserData(id2,"customer_id"); 
							var resource_mediaorg_id = grid.getUserData(id2,"resource_mediaorg_id");
							var order_user_id = grid.getUserData(id2,"order_user_id");
							var adver_matter_id = grid.getUserData(id2,"adver_matter_id");
							var publish_month = grid.getUserData(id2,"publish_month");
							var resort_id = grid.getUserData(id2,"resort_id");	
							var payment_id = grid.getUserData(id2,"payment_id");	
							var resourceInfo_id = grid.getUserData(id2,"resourceInfo_id");
							

					
									
                            params ={
                            	orderId:order_id,
                            	customerId:customer_id,
                            	channelId:resource_mediaorg_id,
                            	userId:order_user_id,
                            	matterId:adver_matter_id,
                            	resortId:resort_id,
                            	incomeMonthDay:publish_month,
																			resourceInfoId:resourceInfo_id,
                            	incomeId:income_id,
                            	pullId:pull_id,
                            	paymentId:payment_id,
                            	ban_value:banValue
                            }
                            querStrs[k++] = $H(params).toQueryString();
                            banValueSum = banValueSum + banValue;
						}

					}
					
					function callBack(){
//						var posStart = mygrid.posStart;
////						mygrid.fromEditRowId = mygrid.iddd;
//						loadGridData(posStart);
//						banlanceWin.hide();
						       var mygrid_id = mygrid.iddd;
						       
						       var leaveSum = Ext.getCmp('leaveMoney_txt2').getValue()- banValueSum;
//						       alert(leaveSum)
//						       var leaveSum = mygrid.getUserData(mygrid_id,"leaveMoney");
						       Ext.getCmp('leaveMoney_txt2').setValue(leaveSum);	
						       Ext.getCmp('leaveMoney_txt2').setMaxValue(leaveSum);	
//						       Ext.getCmp('leaveMoney_txt3').setValue(Ext.getCmp('leaveMoney_txt1').getValue()-Ext.getCmp('leaveMoney_txt2').getValue());	
						       
//						       mygrid.setUserData(mygrid_id,"leaveMoney",leaveSum);
						       
										 if(leaveSum == 0){
										 	    banlanceWin.hide();
										 	    Ext.getBody().unmask();
										 	    
										 	    
										 }else{
										 	      
										 	      
															 var paramObj = getMygrid3ParamObj(mygrid_id);
															
															var func = function(xml){
																
																mygrid2.clearAll();
																mygrid2.loadXMLString(xml);
																Ext.getBody().unmask();
																mygrid2.setSizes();	
																restHeadComnand();
																
																if(mygrid2.getRowsNum() == 0){
														 	    banlanceWin.hide();
														 	    Ext.getBody().unmask();
																}
														  
														   
//																var leaveMoney2 = mygrid.getUserData(mygrid.iddd,"leaveMoney");
//																var txt2 = Ext.getCmp('leaveMoney_txt2');
//																txt2.setMaxValue(leaveSum);	
//																txt2.setValue(leaveSum); 	

																getBalanceMoney();
																
															}											 	

													orderDetail.getOrderDetailMonthXml(paramObj,func);	 
										  }

								    mygrid.posStart = mygrid.posStart2;
                mygrid.scrollTop  = mygrid.scrollTop2;
								    mygrid._limitC=mygrid.limit= mygrid.count2;
								    mygrid.fromEditRowId = income_id;
	              loadGridData();							
						
						
						
					}
					
					
			
					if(querStrs.length > 0){
						Ext.getBody().mask('数据加载中……', 'x-mask-loading');
						payment.savePuton_months(querStrs,callBack); 
					}
				
			  	} catch (e) {
			    	
			    }				
 }
 
   function saveBackPutonMonths(){

			  var col = 0;
			  var col2 = 8;
			  var col3 = 9;
			  var grid = mygrid3;
//			  var rows = grid.getRowsNum();
  		 	var rows = grid.getCheckedRows(0).split(",");
			  var params ={};
			  var querStrs = [];
			  var k = 0;
			  var mygrid_rowId = mygrid.getSelectedId();
			  

			 
//			  var income_id = mygrid.getUserData(mygrid.iddd,"incomeId");	
//			  var pull_id = mygrid.getUserData(mygrid.iddd,"pullId");	

 				var incomeMoney = 0;	
			  var moneyIn = 0;	
			  var leaveMoney = 0;	
			  var index = 0;
			  var banCella = null;	
			  var banCellb =  null;	
			  
			  if(mygrid_rowId >0){
			  	 incomeMoney = mygrid.getUserData(mygrid_rowId,"incomeMoney");	
				   moneyIn = mygrid.getUserData(mygrid_rowId,"moneyIn");	
				   leaveMoney = mygrid.getUserData(mygrid_rowId,"leaveMoney");	
						index = mygrid.getRowIndex(mygrid_rowId);
						banCella =  mygrid.cells2(index,col2);	
						banCellb =  mygrid.cells2(index,col3);					   
			   }
			  
	 
  	 

		

			  try {
			  	
//				  	for(var i=0; i< rows;i++){
//						var ch =  grid.cells2(i,col);
//						var v = ch.getValue();
//						var id2 = grid.getRowId(i);
//						var isDisplay =  grid.getRowByIndex(i).style.display =="";
						

				  	for(var i=0; i< rows.length;i++){
				  		
									var id2 = rows[i];
//									var ch =  grid.cells(rows[i],col);
//									var v = ch.getValue();
									

					
//						    if(v == 1){
										if(id2 >0){
											
										var resource_mediaorg_id = grid.getUserData(id2,"channelId");
										var adver_matter_id = grid.getUserData(id2,"matterId");
										var publish_month = grid.getUserData(id2,"publish_month");
										var moneyIn2 = grid.getUserData(id2,"moneyIn");
										
										var income_id = grid.getUserData(id2,"incomeId");
										var pull_id = grid.getUserData(id2,"incomePullId");
										var order_id = grid.getUserData(id2,"orderId");
										var resourceInfo_id = grid.getUserData(id2,"resourceInfoId");
										var customer_id = grid.getUserData(id2,"customerId");
										
									

										
										
										

										if(mygrid_rowId >0){
											
					
												moneyIn =  parseFloat(moneyIn) - parseFloat(moneyIn2); 
									
//												moneyIn =  parseFloat(moneyIn).toFixed(2);
//												moneyIn_str =  fmoney(moneyIn,2);
//												leaveMoney =  parseFloat(leaveMoney) + parseFloat(moneyIn2) ;
//												leaveMoney =  parseFloat(leaveMoney).toFixed(2);
//												leaveMoney_str =  fmoney(leaveMoney,2);
										}
 
//			           params ={
//			
//			                            	channelId:resource_mediaorg_id,
//			                            	matterId:adver_matter_id,
//			//                            	resortId:resort_id,
//			                            	incomeMonthDay:publish_month,
//			                            	incomeId:income_id,
//			                            	customerId:customer_id,
//			                            	resourceInfoId:resourceInfo_id,
//			                            	orderId:order_id,
//			                            	pullId:pull_id
//			                            }
			                            
				           params ={
			
			                            	channelId:null,
			                            	matterId:null,
			//                            	resortId:resort_id,
			                            	incomeMonthDay:null,
			                            	incomeId:income_id,
			                            	customerId:null,
			                            	resourceInfoId:null,
			                            	orderId:null,
			                            	pullId:pull_id
			                            }		                            
			                            
			                            
           
									  querStrs[k++] = $H(params).toQueryString();
								}
						
						

					}
					
					


				
					
							function callBack(){
								
		//						    var rowId = mygrid.iddd;
		//						    var posStart = mygrid.posStart;
		//						    	mygrid.setSelectedRow(rowId);
		                                      
											if(mygrid_rowId >0){
												  var rowId = mygrid.getUserData(mygrid_rowId,"incomeId")
												  loadGridData3(0,rowId);
											}else{
												  loadGridData3(0);
											}
								    	
									 Ext.getBody().unmask();
									
		//							     banlanceWin.hide();
		//								    mygrid.posStart = mygrid.posStart2;
		//                mygrid.scrollTop  = mygrid.scrollTop2;
		//								    mygrid._limitC=mygrid.limit= mygrid.count2;
		//								    mygrid.fromEditRowId = Ext.getCmp('incomeId').getValue();
		//	              	loadGridData();							
		
									
		//							loadGridData(posStart);
		//							mygrid.setSelectedRow(rowId);
							}
					

		
//                           alert(mygrid_rowId)

							if(querStrs.length > 0){
		//						banCella.setValue(moneyIn);
		//						banCellb.setValue(leaveMoney);
									if(mygrid_rowId >0){
										
//										alert(incomeMoney)
//										alert(moneyIn)
//										leaveMoney = incomeMoney - moneyIn;
										
										leaveMoney = incomeMoney;
										moneyIn = 0;
										
										banCella.setValue(fmoney(moneyIn,2));
								  	banCellb.setValue(fmoney(leaveMoney,2));					
										mygrid.setUserData(mygrid_rowId,"moneyIn",moneyIn);	
										mygrid.setUserData(mygrid_rowId,"leaveMoney",leaveMoney);	
									}
		                             
		           Ext.getBody().mask('数据加载中……', 'x-mask-loading');
		                     
		          
								  payment.saveBack_months(querStrs,callBack); 
							}
				
			  	} catch (e) {
			  		
			  		
			    	
			    }				
 }


 function getMygrid3ParamObj(id){
 	
     var incomeId = mygrid.getUserData(id,"incomeId");
    var pullId = mygrid.getUserData(id,"pullId"); 
	var channelId = mygrid.getUserData(id,"channelId");
	var resourceTypeId = mygrid.getUserData(id,"resourceTypeId");
	var customerId = mygrid.getUserData(id,"customerId");
	var userId = mygrid.getUserData(id,"userId");
	

	
//    var allchecked = $("incomeUsedAllSelect3")?$("incomeUsedAllSelect3").checked:false;
//    allchecked = allchecked?1:0;
	


	var paramObj2 = {
		incomeId: incomeId,
		pullId:  pullId,
		channelId: channelId,
		resourceTypeId:  resourceTypeId,
		customerId:customerId,
		loginUser:loginUser,
		loginUserId:loginUserId,
		userId:userId
	}	
	
//	console.log(paramObj);
	
	paramObj2 = $H(paramObj2).toQueryString();	
	
	return paramObj2;
 }

 
 function onRowDblClicked(id,cellInd){
//	 load_data(id);
//	 var url = mygrid.getUserData(id,"href");
//     var param = $H(url.toQueryParams());
//	 scrollTop  = param.get("scrollTop");	
//	 posStart = param.get("posStart");	
//	 total_count = param.get("total_count");	
//	 fromEditRowId = 1;	
     mygrid2.clearAll();
     
     var paramObjRowDbl = getMygrid3ParamObj(id);
    	var leaveMoney = mygrid.getUserData(id,"leaveMoney");    


	
	   mygrid.iddd = id;
	
	 if(!banlanceWin){
	 	
		var closeBtn = {text: '关闭',handler: function(){banlanceWin.hide();}};
		var regBtn = {text: '重新分配',handler: function(){getBalanceMoney(id);}};	
		var saveBtn = {text: '保存',handler: function(){saveBalanceMoney();}};		
		
	var config = {  
//	        title:'到帐信息',  
	        labelSeparator:':',  
	        labelWidth:60,  
	        bodyStyle:'padding:5 5 5 5',  
	        frame:true,  
	        height:60,  
	        width:220,  
//	        layout:'fit',
//	        renderTo:'form',  
	        items:[  
	            {  
              	    id:'leaveMoney_txt1',
              	    name:'leaveMoney_txt1',
              	    xtype:"numberFieldFormat",   
	                fieldLabel:'到帐金额',  
//	                unitText : ' 元', //单位
	                readOnly:true
//	                allowDecimals:false,               //不允许输入小数   
//	                nanText:'请输入有效整数',           //无效数字提示   
//	                allowNegative:false                //不允许输入负数   
	            },  
	      {
              	  id:'leaveMoney_txt2',
              	  name:'leaveMoney_txt2',
              	  xtype:"numberFieldFormat",   
                  fieldLabel: '平账金额',
//                  width: 60,
//                 decimalPrecision: 1,
//                 minValue: 0,
//                 maxValue: 0,
//                 allowDecimals:true,  //不允许输入小数
//                 allowNegative:false,       //不允许输入负数
//                 nanText:"请输入有效数字",
//                 unitText: ' cm',
//                 allowBlank: false,
                 value: 0,
                 listeners: {  
						        change: function(field, value) {  
						            var value = parseFloat(value).toFixed(2);  
						            var maxValue = field.maxValue;
						            var minValue = field.minValue;
						            if(value > maxValue || value < minValue){
						            	field.setValue(maxValue);  
						            }else{
						            	field.setValue(value);  
						          						  }
						        				}  
			   								 },  
                 blankText: '请输入'
             },  
//	           { 
//	                fieldLabel:'平账余额',  
//	                xtype:"numberFieldFormat",   
//              	    id:'leaveMoney_txt3',
//              	    name:'leaveMoney_txt3',
//              	    disabled:true
////	                nanText:'请输入有效数字',  
////	                baseChars:'12345'                   //输入数字范围   
//	            }
	        ]  
	    }  		
		 var numberForm = new Ext.form.FormPanel(config);  
		 

		banlanceWin = new Ext.Window({
				   title : '平帐',
				   width : 750,
				   height : 500,
				   isTopContainer : true,
				   modal : true,
				   resizable : false,
				   	        closable : false,
				   loadMask: true,
				   buttons: [numberForm,regBtn,saveBtn,closeBtn],
				   contentEl :  $("gridbox2")
		}) 	
	 }
	
	
      
	var func = function(xml){
//		mygrid2.clearAll();
		mygrid2.loadXMLString(xml);
		Ext.getBody().unmask();
		mygrid2.setSizes();	
		restHeadComnand();
		
   var incomeMoney = mygrid.getUserData(mygrid.iddd,"incomeMoney");	
		var leaveMoney2 = mygrid.getUserData(mygrid.iddd,"leaveMoney");
		Ext.getCmp('leaveMoney_txt1').setValue(incomeMoney);	
		var txt2 = Ext.getCmp('leaveMoney_txt2');
		txt2.setMaxValue(leaveMoney2);	
		txt2.setValue(leaveMoney2);	
		getBalanceMoney(id);
		
	}	
	
	
	if(leaveMoney > 0){
		banlanceWin.show();
		Ext.getBody().mask('数据加载中……', 'x-mask-loading');
		orderDetail.getOrderDetailMonthXml(paramObjRowDbl,func);	
	
	}else{
		 banlanceWin.hide();
	}

}


function load_data(id){
	 var url = mygrid.getUserData(id,"href");
     var param = $H(url.toQueryParams());
	 param.set("scrollTop",mygrid.objBox.scrollTop);
	 url =  ctxPath + "editOrder.html?" + param.toQueryString();	
	 self.location = url;	
	 
	 
}




function initGrid2(){
	mygrid2 = new dhtmlXGridObject('gridbox2');
	mygrid2.selMultiRows = true;
	mygrid2.setImagePath(ctxPath+"image/grid/");

	var flds = "<input type='checkBox' id='incomeUsedAllSelect2' name='incomeUsedAllSelect2' value='1' onclick= 'javascript:selectCheckBoxAll(this)' checked=true>";
	var flds =flds+",订单号,年月,业务员,频道,属性,广告名称,版本,长度,欠款,分配金额";
	mygrid2.setHeader(flds);
	mygrid2.newHeads = flds.split(",");
	
	var columnIds = "filed0,filed1,filed2,filed3,filed4,filed5,filed6,filed7,filed8,filed9,filed10";
	mygrid2.setColumnIds(columnIds);
	mygrid2.setInitWidthsP("3,10,8,8,8,8,14,12,5,12,12");         
	mygrid2.setColAlign("center,center,center,center,center,center,left,left,center,right,right")
	mygrid2.setColTypes("ch,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
	        
    mygrid2.enableAlterCss("even","uneven"); 
	mygrid2.setMultiLine(false);
	mygrid2.setEditable(true);
	mygrid2.setOnRowSelectHandler(onRowSelected2,true);
	mygrid2.init();	 
	

	attachHeaderNew(mygrid2,"#rspan,<div id='orderId_flt'></div>,<div id='month_flt'></div>,#rspan,<div id='channel_flt'></div>,<div id='resort_flt'></div>,<div id='adname_flt'></div>,#rspan,#rspan,#rspan,#rspan");

	authFlt1 = document.getElementById("orderId_flt").appendChild(document.getElementById("orderId_flt_box").childNodes[0])
	authFlt2 = document.getElementById("month_flt").appendChild(document.getElementById("month_flt_box").childNodes[0]);
	authFlt4 = document.getElementById("channel_flt").appendChild(document.getElementById("channel_flt_box").childNodes[0]);
	authFlt5 = document.getElementById("resort_flt").appendChild(document.getElementById("resort_flt_box").childNodes[0]);
	authFlt6 = document.getElementById("adname_flt").appendChild(document.getElementById("adname_flt_box").childNodes[0]);  
	 
//	restHeadComnand();
	
}

function restHeadComnand(){

	populateSelectWithAuthors(authFlt1,1);
	populateSelectWithAuthors(authFlt2,2);
	populateSelectWithAuthors(authFlt4,4);
	populateSelectWithAuthors(authFlt5,5);
	populateSelectWithAuthors(authFlt6,6);
}
function replace(s){
	var index = s.indexOf("^");
	if(index >-1 ) s = s.substring(0,index);
	return s;
}
function populateSelectWithAuthors(selObj,col){
		DWRUtil.removeAllOptions(selObj);

		var mygrid = mygrid2;
	
//		var opt = new Option("=="+mygrid.newHeads[col] +"==","0");
//		var opt = new Option("="+mygrid.newHeads[col] +"=","0");
		var opt = new Option(" "+mygrid.newHeads[col] +" ","0");
	
		selObj.options.add(opt);
		var usedAuthAr = new dhtmlxArray();
		for(var i=0;i<mygrid.getRowsNum();i++){
			var id = mygrid.getRowId(i);
			var authNm = replace(mygrid.cells2(i,col).getValue());
			var authVal  = authNm;
			if(usedAuthAr._dhx_find(authNm)==-1){
				selObj.options.add(new Option(authNm,authVal));
				usedAuthAr[usedAuthAr.length] = authNm;
			}
		}
}
	
function filterBy(){
		var pVal = document.getElementById("orderId_flt").childNodes[0].value.toLowerCase();
		var tVal = document.getElementById("month_flt").childNodes[0].value.toLowerCase();
		var aVal = document.getElementById("channel_flt").childNodes[0].value.toLowerCase();
		var uVal = document.getElementById("resort_flt").childNodes[0].value.toLowerCase();
		var dVal = document.getElementById("adname_flt").childNodes[0].value.toLowerCase();
        
        var mygrid = mygrid2;
        
		for(var i=0; i< mygrid.getRowsNum();i++){
			var id = mygrid.getRowId(i);
			var pStr = mygrid.cells2(i,1).getValue().toString().toLowerCase();
			var tStr =  mygrid.cells2(i,2).getValue().toString().toLowerCase();
			var aStr =  mygrid.cells2(i,4).getValue().toString().toLowerCase();
			var uStr = mygrid.cells2(i,5).getValue().toString().toLowerCase();
			var dStr = mygrid.cells2(i,6).getValue().toString().toLowerCase();

			if((pVal=="0" || pStr.indexOf(pVal)==0) &&(tVal=="0" || tStr==tVal) && (aVal=="0" || aStr.indexOf(aVal)==0)
			&& (uVal=="0" || uStr.indexOf(uVal)==0)&& (dVal=="0" || dStr.indexOf(dVal)==0)){
				//alert(aVal); alert(aStr)
				mygrid.setRowHidden(mygrid.getRowId(i),false);
			}else{
				mygrid.setRowHidden(mygrid.getRowId(i),true);
				//隐藏的行要清除复选框

			}
		}
		
		selectCheckBoxAll($("incomeUsedAllSelect2"));
		
		getBalanceMoney();

}	

function initGrid3(){
	mygrid3 = new dhtmlXGridObject('gridbox3');
	mygrid3.selMultiRows = true;
	mygrid3.delim ="*"
	mygrid3.setImagePath(ctxPath+"image/grid/");

	var flds = "<input type='checkBox' id='incomeUsedAllSelect3' name='incomeUsedAllSelect3' value='1'  checked=true onclick ='javascript:selectCheckBoxAll(this)'>*到款编号*订单号*年月*客户名称*业务员*频道*时段*广告名称*版本*长度*应付*分配";
	mygrid3.setHeader(flds);
	
	var columnIds = "filed0*filed1*filed2*filed3*filed4*filed5*filed6*filed7*filed8*filed9*filed10*filed11*filed12";
	mygrid3.setColumnIds(columnIds);

	mygrid3.setInitWidthsP("2*8*8*8*15*5*5*9*10*10*5*8*7");         
	mygrid3.setColAlign("center*center*center*center*left*center*center*left*left*left*left*right*right")
	mygrid3.setColTypes("ch*ed*ed*ed*ed*ed*ed*ed*ed*ed*ed*ed*ed");
    
	mygrid3.setMultiLine(false);
	mygrid3.setEditable(false);
	mygrid3.setSkin("modern2"); 
	mygrid3.enableMultiselect(true); 
	mygrid3.enableKeyboardSupport(true);  
	mygrid3.enableAlterCss("even","uneven"); 
	mygrid3.setOnRowSelectHandler(onRowSelected3,true);
	mygrid3.setOnScrollHandler(OnScrollHandler3);
//	mygrid3.setDragBehavior("nextSibling"); //nextSibling complex
//	mygrid3.enableDragAndDrop(false);
	mygrid3.init();	 
	

	
//	var incomeUsedAllSelect = $("incomeUsedAllSelect");
//	incomeUsedAllSelect.onclick = selectCheckBoxAll;
//	attachHeaderNew(mygrid3,"<center><input type='checkBox' id='incomeUsedAllSelect' value='0' onclick= 'javascript:selectCheckBoxAll(2)'></center>,"+mygrid3.flds);
	
}

function initGrid4(){
	mygrid4 = new dhtmlXGridObject('gridbox4');
	mygrid4.selMultiRows = true;
	mygrid4.delim ="*"
	mygrid4.setImagePath(ctxPath+"image/grid/");

	var flds = "频道*时段属性*分配*比率*余款"; 
	mygrid4.setHeader(flds);
	
	mygrid4.setColspan(0); 
	
	var columnIds = "filed0*filed1*filed2*filed3*filed4";
	mygrid4.setColumnIds(columnIds);

	mygrid4.setInitWidthsP("20*20*20*20*20");         
	mygrid4.setColAlign("left*center*right*right*right");
	mygrid4.setColTypes("ed*ed*ed*ed*ed");
    
	mygrid4.setMultiLine(false);
	mygrid4.setEditable(false);
	mygrid4.setSkin("modern2"); 
	mygrid4.enableMultiselect(true); 
	mygrid4.enableKeyboardSupport(true);  
	mygrid4.enableAlterCss("even","uneven"); 
	mygrid4.init();	 

	mygrid4.attachFooter('*合计:* * * *   ',['text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;']);
	mygrid4.setSizes();	
	
//	$("gridbox4").hide();
}



function initGrid5(){
	mygrid5 = new dhtmlXGridObject('gridbox5');
	mygrid5.selMultiRows = true;
	mygrid5.delim ="*"
	mygrid5.setImagePath(ctxPath+"image/grid/");

	var flds = "频道*时段属性*时段*段位描述*分配*比率*余款";
	mygrid5.setHeader(flds);
	
	mygrid5.setColspan(0); 
	
	var columnIds = "filed0*filed1*filed2*filed3*filed4*filed5*filed6";
	mygrid5.setColumnIds(columnIds);

	mygrid5.setInitWidthsP("15*15*5*15*15*15");         
	mygrid5.setColAlign("center*center*center*left*right*right");
	mygrid5.setColTypes("ed*ed*ed*ed*ed*ed");
    
	mygrid5.setMultiLine(false);
	mygrid5.setEditable(false);
	mygrid5.setSkin("modern2"); 
	mygrid5.enableMultiselect(true); 
	mygrid5.enableKeyboardSupport(true);  
	mygrid5.enableAlterCss("even","uneven"); 
	mygrid5.init();	 

	mygrid5.attachFooter(' * * *合计:*  * ',['text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;']);
	mygrid5.setSizes();	
	
//	$("gridbox4").hide();
}




function attachHeaderNew44(grid){
	var rows = grid.getRowsNum();
	var lastId = grid.getRowId(rows-1);
	var cl_1 = (rows == 0)?"": grid.cells(lastId,1).getValue();
	var cl_2 = (rows == 0)?"": grid.cells(lastId,2).getValue();
	var cl_4 = (rows == 0)?"": grid.cells(lastId,4).getValue();
	var htm ="#rspan*"+ cl_1 +"*"+ cl_2 +"*#rspan*"+ cl_4;
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




function selectCheckBoxAll(el,isDisable,isShowTable){
  var grid = el.name =='incomeUsedAllSelect3'?mygrid3:mygrid2;
	var col = 0;
	var rows = grid.getRowsNum();

	  try {
		  	for(var i=0; i< rows;i++){
				var ch =  grid.cells2(i,col);
		
				if(ch){
					if(grid.getRowByIndex(i).style.display ==""){
					     ch.setValue(el.checked);
					}else{
					     ch.setValue(0);
					} 	
				}
		//		if(!isUndefined(isDisable)) ch.setDisabled(isDisable); 
			}		
	  	} catch (e) {
	    	
	    }

	
	
}

function onRowSelected2(id,cellInd){
	var cell = mygrid2.cells(id,0);
	var v = cell.getValue()==0?1:0;
	cell.setValue(v);   
}
function onRowSelected3(id,cellInd){
	var cell = mygrid3.cells(id,0);
	var v = cell.getValue()==0?1:0;
	cell.setValue(v);   
}

function OnScrollHandler3(sLeft,sTop){

}


//function loadDate(){ 
//	var page = income.page;
//	
//	income.reset();
//	income.page = page;
//	income.obj.orgId = $("orgId").value;
//
//	
//	mygrid.clearAll();
//	mygrid.detachFooter(0);
//	mygrid.enableSmartRendering(true);
//		
//	var  loadDataURL =contPath+"servlet/paymentListServlet?" + $H(paramObj).toQueryString();
//	mygrid.loadXML(loadDataURL);
//	mygrid.setSizes();		
//	
//}


function get_start_day(){
	  var def_Dat =   myDate.parseDate(getFormatDay(_app_params.serviceDate.format2,"y-m-d"));
   var def_Dat_start = myDate.parseDate(myDate.getStartDay3(def_Dat,"yyyy-MM-01")); 
	 var startCmp = Ext.getCmp('start_date_query');
	 var startValue = startCmp?startCmp.getValue():def_Dat_start;
 return startValue;
}


function get_end_day(){
	 var def_Dat =   myDate.parseDate(getFormatDay(_app_params.serviceDate.format2,"y-m-d"));
	 var def_Dat_end  =  myDate.parseDate(myDate.getEndDay3(def_Dat,"yyyy-MM-dd"));
	 var endCmp = Ext.getCmp('end_date_query');
	 var endValue = endCmp?endCmp.getValue():def_Dat_end;
     return endValue;
}


function getLoadDataParams(posStart,fromSearch){


//	var carrierId = $("carrierName").value;
//	carrierId = carrierId == 'undefined' ||isUndefined(carrierId)||carrierId==null?'':carrierId;
//
//    var customerId =  Ext.getCmp("customer_name").getValue();
//    var customerName = Ext.getCmp("customer_name").getRawValue();

//	if(customerId =='') customerName = null;


//	var parentOrgId = tvNameParam =='sjz'&& isNew?1:$("orgId").value;
	var orgId = $("orgId").value;

  var customerCmp =  Ext.getCmp('customerName');
//  var customerId = Ext.getCmp('customerName')?Ext.getCmp('customerName').getValue():null;
//	 customerId = customerId == ''?null:customerId;
	 
	 var customerIds = customerCmp?customerCmp.getCheckedValue():null;
	 customerIds = customerIds == ''?null:customerIds;


	var customerName = null;
//	customerName = customerName ? customerName:null;
	
//	var userId = null;
//	var userCmp = Ext.getCmp('userId1');
//	if(userCmp){
//		var userId =Ext.fly('userId1').getValue();
//	}
//	var userId   =  Ext.getCmp('userId1')?Ext.getCmp('userId1').getValue():null;
	
		 var userIds =  Ext.getCmp('userId1')? Ext.getCmp('userId1').getCheckedValue():null;
	 userIds = userIds == ''?null:userIds;
	
	
	var carriers =  Ext.getCmp('carrier_cmd')?Ext.getCmp('carrier_cmd').getCheckedValue():null;
	
	var channels =  Ext.getCmp('channel_cmd')?Ext.getCmp('channel_cmd').getCheckedValue():null;
	channels = channels ==""?null:channels;


//	userId = userId >0 ? userId:null; 

//  var incomeMonthDay = $("order_year").value+''+$("month").value;
//  incomeMonthDay = $("month").value == 0?null:incomeMonthDay;
//  var year = $("order_year").value;
 
    
   
    
     var fenpeiInfo2 = $("fenpeiInfo2").value;  
    
    var incomeCode = null;
    var incomeId = null;
    try {
    	
	    if(!isUndefined(fromSearch)){
	    	
	    			incomeCode = Ext.getCmp('inc_code')?Ext.fly('inc_code').dom.value:null;
	    	
	    	    if(incomeCode){
	    	    	 if(Ext.getCmp('inc_code').getValue() ==''){
		    	    	 	incomeCode = null;
		    	    	 	incomeId = null;
	    	    	 }else{
	    	    	 		incomeId =Ext.getCmp('inc_code').getValue();
	    	    	 			}
	    	    }
	    }else{
	    	
	    }
	    
    } catch (e) {
    	
    }
    
    var allchecked = $("incomeUsedAllSelect3")?$("incomeUsedAllSelect3").checked:false;
    allchecked = allchecked?1:0;
    
    
//    alert($("incomeUsedAllSelect3").checked);


//       var start_day =  myDate.formatDate(get_start_day(),"yyyyMMdd");
//       var end_day =  myDate.formatDate(get_end_day(),"yyyyMMdd");
//                   
//				 if(!fromSearch){
//				 	   start_day = null; end_day = null;
//				 	   if($("month").value > 0){
//				 	        year = null;
//							}
//							
//				 }else{
//				    	incomeMonthDay= null;
//				    	year = null;
//				    	$("month").value = 0;
////				    	$("fenpeiInfo").value = 0;
//				 }
				 
				 
				  var fenpeiInfo = $("fenpeiInfo").value;
//			  	var start_day=getFormatDay($("beginDate").value,'ymd');
//        var end_day=getFormatDay($("overDate").value,'ymd');	   
				var start_day =  myDate.formatDate(Ext.getCmp('start_date_query').getValue(),'yyyyMMdd');
				var end_day =  myDate.formatDate(Ext.getCmp('end_date_query').getValue(),'yyyyMMdd');
				  



	 		  paramObj = {
				 	customerName: customerName,
//				 	customerId: customerId,
				 	customerIds: customerIds,
//				 	userIds:  userId,
				 	userIds:  userIds,
				 	year:null,

					groupModel:0,
				 	incomeMonthDay:null,
				 	startDay:start_day,
				 	endDay:end_day,
				 	fenpeiInfo:fenpeiInfo,
				 	fenpeiInfo2:fenpeiInfo2,
				 	carriers: carriers,
	                channels: channels,
	                incomeId:incomeId,
//	                version:$("order_year").value,
	                orgId: orgId,
	                loginUser:loginUser,
	                allchecked:allchecked,
	                fromEditRowId:fromEditRowId
//	                posStart:posStart
		}
		
//		alert(paramObj.toSource())
		paramObjForSort = paramObj;

		return paramObj;

 }
 
 

 function loadGridData(posStart,fromSearch){
 	
// 	     alert(mygrid.posStart)
//       obj.selectRow(obj.getRowById(obj.fromEditRowId),true);


	 	
//	 	if(posStart == null) posStart = 0;
	 	
		var paramObj = getLoadDataParams(posStart,fromSearch);  
		mygrid.paramObj = paramObj;
	 	mygrid.clearAll();
	 	mygrid.detachFooter(0);
   $("fenpeiInfo2").value =1;
	 	
//	 	alert(posStart);  
//	 	alert(scrollTop);    
//	 	alert(fromEditRowId);  
//	 		 		alert(total_count);
//	 
//	 		 		
//	 	if(fromEditRowId > 0){
//	 		 mygrid.fromEditRowId = fromEditRowId; 
//	 	}

   

	 	
//	 	if(posStart > 0 || posStart == 0){
	 		 //mygrid.posStart = posStart;
//	 		 mygrid.scrollTop = scrollTop;
//	 		 mygrid.fromEditRowId = fromEditRowId; 
	 		 mygrid.enableSmartRendering(true);

//		}else{
//			 mygrid.enableSmartRendering(true);
//		}	

		 loadDataURL ="servlet/incomeListServlet?" + $H(paramObj).toQueryString();	
        
//        
//   function afterCall(){
//   				 alert(fromEditRowId)
//   					alert(mygrid.posStart)
//         	if(fromEditRowId > 0 && isUndefined(mygrid.posStart)){
//         		mygrid.setSizes();	
//         		               alert(scrollTop)
//								mygrid.objBox.scrollTop = scrollTop;  
//         		mygrid.selectRow(mygrid.getRowById(fromEditRowId),true);
//         				}
//         }
	
	
//	    alert(' mygrid.loadXML')
		 mygrid.loadXML(loadDataURL);
//	   mygrid.loadXML(loadDataURL,afterCall);
//		 mygrid.setSizes();	
		 
		 
//	 	 mygrid3.clearAll();
//	 	 mygrid3.detachFooter(0);		
		
//		closeSearchDiv();        
 }



 
function buttonEventFill(){

	var Btn_addIncome = $("Btn_addIncome");
	Btn_addIncome.onclick = function(){editIncomeInfo(true);};	
	
	var Btn_modIncome = $("Btn_modIncome");
	Btn_modIncome.onclick = function(){editIncomeInfo(false);};		
	
	var Btn_deleteIncome = $("Btn_deleteIncome");
	Btn_deleteIncome.onclick = removeIncome;			

	var Btn_query = $("btn_searche");
	Btn_query.onclick = showSearchWin;
	
		var Btn_refresh = $("btn_refresh");
	Btn_refresh.onclick = loadGridData;
	
	
	var btn_returnPuton = $("btn_returnPuton");
	btn_returnPuton.onclick = saveBackPutonMonths;
	
	
	var Btn_order_year = $("order_year");
	Btn_order_year.onchange = loadGridData;	
	
	var Btn_month = $("month");
	Btn_month.onchange = loadGridData;
	
	var Btn_fenpeiInfo = $("fenpeiInfo");
	Btn_fenpeiInfo.onchange = loadGridData;
	
	
	var Btn_fenpeiInfo2 = $("fenpeiInfo2");
	Btn_fenpeiInfo2.onchange = choseGrid;
	
	
	
	
	buildContextmenu();

}


function buildContextmenu(){
	
	var	items =[
	        {  
	            text:"新签",  
	            iconCls:'admin-tool-add',
	            handler:function(){editIncomeInfo(true,1);}  
	        }
		];
	items[items.length] ={  
	            text:"修改",  
	            iconCls:'admin-tool-edit',
	            handler:function(){editIncomeInfo(false,0);}  
	};	
	
	items[items.length] ={  
	            text:"删除",  
	            iconCls:'admin-tool-delete',
	            handler:function(){removeIncome(false);}  
	};	
	
	items[items.length] ={  
	            text:"返款",  
	            iconCls:'admin-tool-refresh',
	            handler:function(){saveBackPutonMonths();}  
	};	
	

	var menu = new Ext.menu.Menu({  
	        minWidth:200,  
	        width:150,
	        items:items 
	});  
	
	         //作用于页面上的鼠标右键  
	Ext.getDoc().on("contextmenu",function(e){  
	    	e.stopEvent();//终止之前的事件响应，不然还会在页面上弹出讨厌的ie右键菜单  
	    	menu.showAt(e.getXY()); 
	});  	
	
}

function choseGrid(ev){
	var me = getElementByEvent(ev);
	var value = me.value;	
	
//	if(value == 1){
//		$("gridbox3").show();
////		$("gridbox4").hide();
////		$("gridbox5").hide();
//		loadGridData3(0);
//	}
	
	if(value == 2 || value == 3 || value == 4){
//		$("gridbox4").show();
//		$("gridbox3").hide();
//		$("gridbox5").hide();
		paramObjForSort.fenpeiInfo2 = value;
		
	
		show_balance_grid();
		
	}	

}    

function displaySearchDiv(){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "visible";
}
function closeSearchDiv(){
	var oDiv = $("theDivSearch");
	oDiv.style.visibility = "hidden";	
}



function showSearchWin(){
	
	
	    if(!queryWindow){
	    	
		var items = new Array();
	
//  var my_cur_year =_app_params.serviceDate.year;
  
//  var comYear = myUtils.getComYear('income_year','到款年份',150,my_cur_year);  	

//	 var def_Dat =   myDate.parseDate(getFormatDay(_app_params.serviceDate.format2,"y-m-d"));
//
//	 var startDateFileld =  new Ext.form.DateField({
//	        fieldLabel : '开始日期',
//	        id : 'start_date_query',
//	        enableKeyEvents : true,
//	        width : 180,
//	        allowBlank : false,    
//	        format : 'Y-m-d',
//	       	value:myDate.getStartDay3(def_Dat,"yyyy-MM-01")
//	       });  
//  
//  	var endDateFileld =  new Ext.form.DateField({
//	        fieldLabel : '开始日期',
//	        id : 'end_date_query',
//	        enableKeyEvents : true,
//	        width : 180,
//	        allowBlank : false,    
//	        format : 'Y-m-d',
//	       	value: myDate.getEndDay3(def_Dat,"yyyy-MM-dd")
//	       });  
 

  
//   user.obj.username = loginUser;
//   user.obj.version = 1;
//   user.storeUser = user.getStoreMap('local',user.obj);
   
//   var def_id =  mygrid.getSelectedId();
//   var def_income_code =  mygrid.getUserData(def_id,"incomeCode")
//   def_income_code =  def_income_code ?def_income_code:"";
//   def_id =  def_id ?def_id:"";


		var paramObj1 ={
			orgId: $("orgId").value,
//			year: $("order_year").value, 
			incomeCode:null
		}

//	var incomeCodeCommand = income.getIncomeCodeCom(180,null,"inc_code",paramObj,def_id,def_income_code);
	
	var incomeCodeCommand = income.getIncomeCodeCom(180,null,"inc_code",paramObj1);
		 
//		 incomeCodeCommand.on("select" , function(box){var incomeId = box.getValue(); });
//		 incomeCodeCommand.setValue(def_income_code);
		  customer.obj.orgId = $('orgId').value;
	    
//  carrier.obj.callback = function aa(){};
//  var carrierCmd = carrier.getLovCombo('carrier_cmd',true);      
	var channelCmd = channel.getLovCombo('channel_cmd',180,'local',true); 
	var customerCommand  = getCustomerCmd('customerName','userId1',false);
	var userCommand = getUserCmd('customerName','userId1',false);  
	
	
//	items.push(startDateFileld);	
//	items.push(endDateFileld);	
	items.push(incomeCodeCommand);	      
	items.push(channelCmd);	
	items.push(customerCommand);	 
	items.push(userCommand);	
	
//	items.push(startDateFileld);	 
// 	items.push(startDateFileld);	 
//	items.push(startDateFileld);	  	
// 	items.push(startDateFileld);	 
// 	items.push(startDateFileld);	 
//	items.push(startDateFileld);	  		
 	
 	     
//  var userCommand = new Ext.form.ClearableComboBox({
//        			xtype:"combo",
//	                fieldLabel: '业务员',
//	                name: 'userId1',
//	                id:'userId1',
//	                width:150,
//	                emptyText: '请选择...',
//                    store: user.storeUser,
//                    displayField: 'value',
//                    valueField:'key',
//                    editable: true,
//                    triggerAction: 'all',
//                    mode: 'local',
//                    allowBlank:false
//	});
		   
//	user.storeUser.on('load', function() {
//	    	        var userId = Ext.fly('userId');
//	    	        if(!userId){
//	    	        	 Ext.getCmp('userId').setValue(cur_userId);
//	    	        }
//   		 });
   		  

 
 
   
//    customer.storeCustomer = customer.getStoreCustomersAnalyze('remote',customer.obj);    
    
    
    
//	var customerCommand =new Ext.form.ClearableComboBox({
//		  xtype:'combo',
//		  fieldLabel: '客户名称',
//		  emptyText: '请选择...',		  
//	 	  id:'customerName',
//	 	  name:'customerName',
//		  tiggerAction:'all',
//		  store:customer.storeCustomer,
//		  editable: true,
//		  triggerAction: 'all', //query all
//		  lastQuery:'1',
//		  displayField:'customerName',
//		  valueField:'id',
//		  mode:'remote',
//		  allowBlank:false,
//		   width:150,
//		   forceSelection:false, 
//		  allowBlank:false,
//		  emptyText:'',
//		  minChars:2,
//		  hiddenName:'helpCode', //提交传过去的值 
//		  filterFiled:'customerName',
//		   params:customer.obj,
//		  listeners:{beforequery:customer.comboFilterBy2.createDelegate(this)}	
//	 });
 
 

 
 
 
 
 
 
 
	

//    if(!fromPannel) {
   		 fromPannel = new Ext.FormPanel({   
				xtype:'tabpanel',
                labelWidth: 75, 
                frame:true,   
                title: '',  
                bodyStyle:'padding: 0',   
                width: 350,   
                labelSeparator:'',   
                items: items
				});  	   	
//    }
   

    	
		queryWindow = new Ext.Window({
				    title:'查询单据',
//				    width:winWidth*0.5,
//				    height:winHeight*0.5,
				    width:450,
				    height:400,
				    modal:true,
				    closeAction:'hide',
				    layout:'fit',
				    buttons:[{text:'查询到款',handler:function(){
					    	loadGridData(0,true);
					    	queryWindow.hide();
				    	}},
				    		{text:'查询分配',handler:function(){
				    			
//				    			var incomeId = Ext.getCmp('inc_code').getValue();
				    			loadGridData3(0,0,true);
				    			queryWindow.hide();}},
				            {text:'重置',handler:function(){fromPannel.form.reset();}},
				            {text:'关闭',handler:function(){queryWindow.hide(); }
				            }
				            ],
				          items:fromPannel  
//							items:{html:$("aaaaaaaaaa") }
		
				
				 
		});	
    }

			
     queryWindow.show(this);
  
//  function removeWin(){queryWin.destroy();	} ;
//  queryWin.on({'close': {fn: removeWin}});   	
}



function editIncomeInfo(isNew,type){

 if(!incomeWindow){
 	
 		var conf_incomeId = {
	     fieldLabel:'系统编号',
	     id:'incomeId',
	     name:'incomeId',
	     allowBlank:true,
	     width : 180,             
	     blankText:''            
	    }	
	    var incomeIdTxt =new Ext.form.Hidden(conf_incomeId);
	    
 		var conf_iincomeUsed = {
	     fieldLabel:'分配金额',
	     id:'incomeUsed',
	     name:'incomeUsed',
	     allowBlank:true,
	     width : 180,             
	     blankText:''            
	    }	
	    var incomeUsedTxt =new Ext.form.Hidden(conf_iincomeUsed);	    
	    
	    
	     
	     
 		var conf_memo = {
	     fieldLabel:'备注',
  		 xtype:'textArea',
	     id:'incomeMemo',
	     name:'incomeMemo',
	     allowBlank:true,
	     width : 180,
	     maxLength: 500,
         height: 70,       
	     blankText:''            
	    }	
	     var incomeMenoTextArea =new Ext.form.TextArea(conf_memo);	     
	     


     var conf_TextField = {
	     fieldLabel:'到款编号',
	     id:'incomeCode',
	     name:'incomeCode',
	     selectOnFocus:true,  //得到焦点自动选择文本
	     allowBlank:false,
	     width : 180,             
	     blankText:'待定......'            
	    }	
	    
		if(config_incomeCodeModelParam == 1){ 
           conf_TextField.disabled = true;
           conf_TextField.blankText = '自动生成..';
           conf_TextField.allowBlank = true;
		}else{
			 conf_TextField.blankText = '请输入..。';
			 conf_TextField.allowBlank = false;
		}	    
	    
	 var incomeCodeTxt =new Ext.form.TextField(conf_TextField);

        var cutCmd =   getCustomerCmd('extCustomer','signUser',true);
       var ucmmd  = getUserCmd('extCustomer','signUser',true);


	  	  var def_Date_start =   myDate.parseDate(getFormatDay(_app_params.serviceDate.format2,"y-m-d"));

//	      var startDateFileld =    new Ext.form.DateField({
//	        fieldLabel : '到款日期',
//	        name : 'incomeDate',
//	        id : 'incomeDate',
//	        enableKeyEvents : true,
//	        width : 180,
//	        allowBlank : false,    
//	        format : 'Y-m-d'
////	       	value:def_Date_start
//	       })     
	       
	    var startDateFileld =  new Ext.form.DateField({
	        fieldLabel : '到款日期',
//	        name : 'incomeDate',
	        id : 'incomeDate',
	        enableKeyEvents : true,
	        width : 180,
	        allowBlank : false,    
	        format : 'Y-m-d',
	       	value:new Date()
	       });
	       
	       

       
	       
//	        var startDateFileld ={
//	        	xtype : "datefield",
//			    fieldLabel : "到款日期",
//			    name : "incomeDate",
//			    id:"incomeDate",
//			    xtype:'datefield',
//			    width : 180,
//			    format:'Y-m-d',
//			    value:new Date()
//   			};
	       
//  	  		var incomeMoneyTxt = new Ext.form.NumberField({ 
//	                fieldLabel:'到款金额',  
//              	    id:'incomeMoney',
//              	    name:'incomeMoney',
//              	    width : 180,   
//              	    disabled:false,
//              	    allowBlank : false
////	                nanText:'请输入有效数字'
////	                baseChars:'1234567890'                   //输入数字范围   
//	            });  
  	  		var incomeMoneyTxt = { 
	                  fieldLabel:'到款金额',  
              	    id:'incomeMoney',
              	    name:'incomeMoney',
              	    width : 180,   
              	    disabled:false,
              	    allowBlank : false,
              	    allowDecimals : true,
              	    xtype:"numberFieldFormat",  
              	     unitText : ' 元', //单位 
              	    allowDecimals: true, // 是否与许小数 
//              	    allowNegative:false,  
              	    nanText :'' //无效数字提示   
//	                baseChars:'1234567890'                   //输入数字范围   
	            };  
	            
	            

	            
	            
	            
//  	  		var incomeMoneyTxt ={ 
//	                fieldLabel:'到款金额',  
//	                xtype:"numberFieldFormat",  
//              	    id:'incomeMoney',
//              	    name:'incomeMoney',
//              	    width : 180,   
//              	    disabled:false
////	                nanText:'请输入有效数字',  
////	                baseChars:'1234567890'                   //输入数字范围   
//	            };    
	               
//          var dataArray = _app_params.serviceDate.adrmSysYear.split(",");
          var comYear = utils.getComYear('cuikuan_year','归属年份',180,curYear,null,_app_params.serviceDate.adrmSysYear);  
	      var yyyy = comYear.getValue();
	      
//	      var channelCmd = channel.getLovCombo('channel_id',180,'local',false);    
          carrier.obj.orgId = config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;	
	      var carrierCmd = carrier.getLovCombo2('carrier_id',180,'remote',false);     
	         
	     
	      function callBackFun(){};

	      var incomePurposeCmd = incomePurpose.getCombo('incomePurpose_id',180,false);
		    var incomeModeCmd = incomeMode.getIncomeModeCmd(null,'incomeMode_id',180,callBackFun);
	      
	      var items = new Array();
	      
	      items.push(incomeIdTxt);
	      items.push(incomeCodeTxt);
	      items.push(cutCmd);
	      items.push(ucmmd);
          items.push(startDateFileld); 
	      items.push(comYear);
//	      items.push(channelCmd);
	      items.push(carrierCmd);
	      items.push(incomePurposeCmd);
		  items.push(incomeModeCmd);
	      items.push(incomeMoneyTxt);
	      items.push(incomeUsedTxt);
	      items.push(incomeMenoTextArea);
	      
//	      user.userCommand,
          
   		 var fromPannel = new Ext.FormPanel({   
				xtype:'tabpanel',
                labelWidth: 65, 
                 id:'income_fromPannel',
              	 name:'income_fromPannel',
                frame:true,   
                title: '',  
                bodyStyle:'padding: 0',   
                width: 350,   
                labelSeparator:'',   
                items: items 
				});  

			incomeWindow = new Ext.Window({
			    title:'到款录入',
			    width:winWidth*0.5,
			    height:winHeight*0.9,
			    modal:true,
			    closable : false,
			    closeAction:'hide',
			    layout:'fit',
			    buttons:[
			    		{text:'保存', handler:function(){saveIncome();}  },
							{text:'重置',handler:function(){fromPannel.form.reset();}},
							{text:'取消',handler:function(){

										 incomeWindow.hide();
								    mygrid.posStart = mygrid.posStart2;
                mygrid.scrollTop  = mygrid.scrollTop2;
										// posStart = mygrid.posStart;
								    mygrid._limitC=mygrid.limit= mygrid.count2;
								    var id =  mygrid.getSelectedId();
								    mygrid.fromEditRowId = id;
	             	 loadGridData();								

								
								}}
			            ],
			    items:fromPannel  

			});
			
       }
       
       else{
//       	  Ext.getCmp('income_fromPannel').form.reset();
//       	  Ext.getCmp('incomeDate').setValue(def_Date_start);
              incomeFormReset(type);
       }
       
//       incomeWindow.show();		
 
    
       
       if(!isNew){
       	 	var incomeId = mygrid.getUserData(mygrid.getSelectedId(),"incomeId"); 
       	 	
      

					 	if(incomeId > 0){
					 		
						incomeFormLoadData(incomeId);
						
						incomeWindow.show();	

						}      	 
       }else{
       	
       	   incomeWindow.show();		
       				}
}

function incomeFormReset(type){
	          
   try {
   	
   							 Ext.getCmp('extCustomer').enable();
								  Ext.getCmp('incomeCode').enable();
								  Ext.getCmp('incomeMoney').enable();
								  Ext.getCmp('incomeMoney').setMinValue(0);
								  Ext.getCmp('incomeUsed').enable();
								  Ext.getCmp('signUser').enable();
								  Ext.getCmp('incomeDate').enable();
								  Ext.getCmp('carrier_id').enable();
								  Ext.getCmp('incomePurpose_id').enable();
								  Ext.getCmp('incomeMode_id').enable();
								  Ext.getCmp('incomeMemo').enable();				
   						
   	
   	
	          if(type == 1){
									Ext.getCmp('incomeId').setValue('');
	          		Ext.getCmp('incomeCode').setValue('');
	          }else{
	          	  var def_Date_start =   myDate.parseDate(getFormatDay(_app_params.serviceDate.format2,"y-m-d"));
		         	 Ext.getCmp('incomeId').setValue('');
								  Ext.getCmp('extCustomer').clearValue();
								  Ext.getCmp('incomeCode').setValue('');
								  Ext.getCmp('incomeMoney').setValue('0');
								  Ext.getCmp('incomeUsed').setValue('0');
								  Ext.getCmp('signUser').setValue('');
								  Ext.getCmp('incomeDate').setValue(def_Date_start);	
								  Ext.getCmp('carrier_id').setValue('');
					//			  Ext.getCmp('channel_id').setValue('');
								  Ext.getCmp('incomePurpose_id').setValue('1');
								  Ext.getCmp('incomeMode_id').setValue('5');
								  Ext.getCmp('incomeMemo').setValue('');
								  
	         				 } 
   } catch (e) {
    	
    }	
   
   
   
             

}

function incomeFormLoadData(incomeId){


   
   
	 function func(o){

	 	
	 		inti_set_customer('extCustomer',1,o.customerId, o.customer.customerName);
	 		inti_set_signUser('signUser',o.userId, o.user.fullName);
	 		
	 		 var incomeDate =   myDate.parseDate(getFormatDay(o.incomeDate,"y-m-d"));
	 		 var incomePullDate = o.incomePullDate.toString().substring(0,4);
//			customer.customerCommand.setValue(o.customerId);
              
        
              
              var incomeIdCmp =  Ext.getCmp('incomeId');
              var incomeCodeCmp =  Ext.getCmp('incomeCode');
              var incomeCustomerCmp =  Ext.getCmp('extCustomer');
              var incomeMoneyCmp =  Ext.getCmp('incomeMoney');
              var incomeUsedCmp =  Ext.getCmp('incomeUsed');
              var incomeSignUserCmp =  Ext.getCmp('signUser');
              var incomeDateCmp =  Ext.getCmp('incomeDate');
              var incomePullDateCmp =  Ext.getCmp('cuikuan_year');
              var carrIdCmp =  Ext.getCmp('carrier_id');
              var incomePurposeCmp =  Ext.getCmp('incomePurpose_id');
              var incomeModeCmp =  Ext.getCmp('incomeMode_id');
              var incomeMemoCmp =  Ext.getCmp('incomeMemo');
              
                 
        o.incomeUsed =  parseFloat(o.incomeUsed).toFixed(2);
        
    
        
				  incomeIdCmp.setValue(o.id);
				  incomeCodeCmp.setValue(o.incomeCode);
				  incomeCustomerCmp.setValue(o.customerId);
				  incomeMoneyCmp.setValue(o.incomeMoney);
				  incomeUsedCmp.setValue(o.incomeUsed);
				  incomeSignUserCmp.setValue(o.userId);
				  incomeDateCmp.setValue(incomeDate);
				  incomePullDateCmp.setValue(incomePullDate);
	//			  Ext.getCmp('carrier_id').setValue(o.resourceCarrierId);
	//			  Ext.getCmp('channel_id').setValue(o.resourceChannelId);
				  carrIdCmp.setValue(o.resourceChannelId);
				  incomePurposeCmp.setValue(o.incomePurposeId);
				  incomeModeCmp.setValue(o.incomeModeId);	 	
				  incomeMemoCmp.setValue(o.memo);	
	  
	
				  

				  
			if(o.incomeUsed == 0 || o.incomeUsed == null || isNaN(o.incomeUsed)){
				
						 incomeMoneyCmp.setMinValue(0);
	 				  incomeIdCmp.enable(); 
					  incomeCodeCmp.enable(); 
					  incomeCustomerCmp.enable(); 
					  incomeMoneyCmp.enable(); 
					  incomeUsedCmp.enable(); 
					  incomeSignUserCmp.enable(); 
					  incomeDateCmp.enable(); 
					  incomePullDateCmp.enable(); 
					  carrIdCmp.enable(); 
					  incomePurposeCmp.enable(); 
					  incomeModeCmp.enable(); 
					  incomeMemoCmp.enable(); 

					  
		 }else{
	              	                          
	        incomeMoneyCmp.setMinValue(o.incomeUsed);      
	                        
//			    if(o.incomeUsed == o.incomeMoney) {
//			 					incomeMoneyCmp.disable();
//						}else{
//								incomeMoneyCmp.setMinValue(o.incomeUsed);
//			           }   	                         

	 				  incomeIdCmp.disable();
					  incomeCodeCmp.disable();
					  incomeCustomerCmp.disable();
//					  incomeMoneyCmp.disable();
					  incomeUsedCmp.disable();
					  incomeSignUserCmp.disable();
//					  incomeDateCmp.disable();
//					  incomePullDateCmp.disable();
					  carrIdCmp.disable();
//					  incomePurposeCmp.disable();
//					  incomeModeCmp.disable();
//					  incomeMemoCmp.disable();
	              }

			  
	 }



	income.getIncome5(incomeId,func);	
  
	
}

function saveIncome(){
    var incomeId = Ext.getCmp('incomeId').getValue();
    var isNew = incomeId == 0|| incomeId =="" || incomeId == null?true:false;
		 var permitSave = saveIncomeCheck(isNew);
    if(permitSave) return false;
    if(!Ext.getCmp('income_fromPannel').getForm().isValid()) return false;

	income.reset();
//	var customerId = Ext.fly('extCustomer').getValue();
	var customerId = Ext.getCmp('extCustomer').getValue();
	customerId = customerId==''|| !isDigit(customerId)?0:customerId;
	
	
//	alert(Ext.getCmp('extCustomer').getValue());
//	alert(Ext.fly('extCustomer').getValue());

	
	
	income.obj.id = incomeId ==""?null:incomeId;
	income.obj.customerId = customerId;
	income.obj.customer = (new Customer()).obj;
	income.obj.customer.customerName = Ext.fly('extCustomer').getValue();
	income.obj.userId =  Ext.getCmp('signUser').getValue();	
	income.obj.customer.customerCategoryId = 4;
	income.obj.modifyBy = loginUserId;
	income.obj.createBy= loginUserId;	
	var incomeDate =   Ext.getCmp('incomeDate').getValue();	
	income.obj.incomeDate = myDate.formatDate(incomeDate,'yyyyMMdd');
	
	
	var incomePullDate =   Ext.getCmp('cuikuan_year').getValue();	
	income.obj.incomePullDate = incomePullDate +'0101';
	income.obj.version = getFormatDay(income.obj.incomeDate,'y');
	income.obj.orgId = $("orgId").value;	
	income.obj.incomeMoney =  Ext.getCmp('incomeMoney').getValue(); 
	
//	alert(income.obj.incomeMoney);

	income.obj.incomeModeId =  Ext.getCmp('incomeMode_id').getValue();
	income.obj.incomePurposeId =  Ext.getCmp('incomePurpose_id').getValue();
	income.obj.incomeCode =  Ext.getCmp('incomeCode').getValue();	
	income.obj.memo =  Ext.getCmp('incomeMemo').getValue();	
	
//	alert(income.obj.toSource());
	
//	console.log(income.obj);

    var func = function(income_Id){
	    	var incomePullId = null;
	    	
//	    	alert(income_Id)
	    	
	    Ext.getCmp('incomeId').setValue(income_Id);
	    	

	    	
	    	if(!isNew){
	             incomePullId = mygrid.getUserData(mygrid.getSelectedId(),"pullId"); 
	    		}
	    		
				$("order_year").value =  myDate.formatDate(incomeDate,'yyyy');
				$("month").value =  myDate.formatDate(incomeDate,'MM');
				
	    	
	    	saveIncomePull(income_Id,incomePullId);
    		}
	
	income.saveIncome(income.obj,func);	


}

function saveIncomePull(incomeId,incomePullId){
	
	  var callbak =function(){
	  	
//	  	  if(callBackFun) callBackFun();
   
	       Ext.MessageBox.confirm('系统提示','保存完成,是否使用当前的数据继续录入?',function (value){  
	             if(value == 'yes'){  
	                 editIncomeInfo(true,1);
	             }else{

	             	incomeWindow.hide();
								    mygrid.posStart = mygrid.posStart2;
								    
                mygrid.scrollTop  = mygrid.scrollTop2;
										// posStart = mygrid.posStart;
										 
								    mygrid._limitC=mygrid.limit= mygrid.count2;
								    mygrid.fromEditRowId = Ext.getCmp('incomeId').getValue();
	             	loadGridData();
	             }
   				})        

		};
		 
//	var carrier_id = Ext.getCmp('carrier_id').getValue();	
//	var channel_id = Ext.getCmp('channel_id').getValue();	
//	var carrier_id =
//	carrier_id =  carrier_id.split(",")[0];
//	if(carrier_id == "") {
//		carrier_id = 0;	
//	}
//    var carrierStore = Ext.getCmp('carrier_id').store;
    var carrier_id = getValueFromStoreById(Ext.getCmp('carrier_id'),'id');
    
    
    
	var moneyPull = Ext.getCmp('incomeMoney').getValue();
	incomePull.obj.id = incomePullId;
	incomePull.obj.incomeId = incomeId;
	incomePull.obj.moneyPull = moneyPull;
	incomePull.obj.moneyIn = 0;	
	incomePull.obj.resourceCarrierId = carrier_id;
//	incomePull.obj.resourceTypeId = (config_withResourceSort == 1)?resourceType:0;	
	incomePull.obj.resourceTypeId = 0;	
	incomePull.obj.version = Ext.getCmp('incomeDate').getValue().getFullYear();

//   console.log(incomePull.obj)
//    alert(11)
//   alert(incomePull.obj.toSource())

//	incomePull.obj.createBy = $("createName").value;
//    console.log(incomePull.obj);
   incomePull.saveIncomePull(incomePull.obj,callbak);	
	
		
}


function removeIncome(){
	var id  = mygrid.getSelectedId();
	if(id > 0) {
		function func(v){
			 if(v == 'ok') {
			 	var func = function(){ 
			 		income.removeIncome(id,loadGridData); 
			 	}
				incomePull.removeIncomePullByIncomeId(id,func);
			 }
		}
		myUtils.myMessage2("请确认是否删除!",func); 
	}else{
		myUtils.myMessage("请选择要删除的记录!"); 
	}

}




//function attachHeaderNew(grid){
//	var rows = grid.getRowsNum();
//	var lastId = grid.getRowId(rows-1);
//	var cl_6 = (rows == 0)?"": grid.cells(lastId,6).getValue()*1;
//	var cl_7 = (rows == 0)?"": grid.cells(lastId,7).getValue()*1;
//	var htm ="#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,"+ cl_6 +","+ cl_7+",#rspan,#rspan,#rspan"+"";
//	var h = htm.split(",");
//	var z =  grid.ftr.rows[1];
//
//	for(var cin = 0; cin<h.length;cin++){
//		if(h[cin].indexOf("#rspan") != 0) {
//			var c = z.cells[z._childIndexes?z._childIndexes[parseInt(cin)]:cin];
//			c.innerHTML = h[cin];		
//		}
//	}
//	grid.deleteRow(lastId);
//	
//}


function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}
function setIncomePara(obj){
	 obj.className   = "income";	
	 obj.IdPrefix 	 = obj.className + "Id";
//	 obj.pageInfo 	= "pageInfo_" + obj.className;
//	 obj.pageSize 	= "10";
//	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}

function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
}
function setOrderDetailPara(obj){
	 obj.className  = "orderDetail";	
	 obj.IdPrefix 	= obj.className + "Id";
//	 obj.pageInfo 	= "pageInfo_" + obj.className;
//	 obj.pageSize 	= "10";
//	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}



function getCustomerCmd(el_id,el_uid,noSearch){
	
      customer.obj.orgId = config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;	
//	    customer.storeCustomer = customer.getStoreCustomersAnalyze('remote',customer.obj);   
	    
	    var customerCmp =  Ext.getCmp(el_id);

	     var storeCustomer = customer.getStoreCustomersAnalyze('remote',customer.obj);   
	            
	            
	    if(!customerCmp){

				 	var conf ={
					 	  id:el_id,
					 	  name:el_id,
						  tiggerAction:'all',
						  fieldLabel: '客户名称',
						  store:storeCustomer,
						  editable: true,
						  triggerAction: 'all', //query all
						  lastQuery:'1',
						  displayField:'customerName',
						  valueField:'id',
						  mode:'remote',
						  allowBlank:false,
						   width:180,
						   listWidth:300,
						   forceSelection:false, 
						  allowBlank:false,
				
						  emptyText:'请选择...',
						  minChars:2,
						  hiddenName:'helpCode', //提交传过去的值 
						  filterFiled:'customerName',
						   params:customer.obj,
						  listeners:{beforequery:customer.comboFilterBy2.createDelegate(this)}	
					 };
					 
					 
				  if(noSearch){
	    			 customerCmp =  new Ext.form.ClearableComboBox(conf);
	    		}else{
	    			 customerCmp =  new Ext.ux.form.LovCombo(conf);
	    			}		 
					 
	    } 

	   function getcheckCustomer(){checkCustomer(el_id); }
			
			if(noSearch){
					customerCmp.on("blur",getcheckCustomer,this);	
			}
			
			
			customerCmp.on("select" , function(box)
		    {
		    	
	
		    	if(noSearch){
		    	    	resetUserCom(el_id,el_uid,noSearch);
		    	    	Ext.getCmp(el_uid).onTriggerClick(); 
		    	    	  
		    	}else{
		    		 Ext.getCmp(el_uid).clearValue();
		    	}
		    	
//		    	Ext.getCmp(el_uid).onTriggerClick(); 
		    	
//		    	else{
//		    	    	 Ext.getCmp(el_uid).clear();
//		    	    }
                     
//         Ext.fly(el_uid).onTriggerClick(); 
//         Ext.getCmp(el_uid).onTriggerClick(); 
       
//        Ext.getCmp(el_uid).onTriggerClick(); 

	
		    });
		    
		    
		 customerCmp.on("clear" , function(box)
		    {
		    	
		    	
		    	
		    	if(!noSearch){

		    	    	resetUserCom(el_id,el_uid,noSearch);
//						 Ext.getCmp(el_uid).clearValue(); 
//						 Ext.getCmp(el_uid).getStore().reload();
		    	    }

		    });
		    
		    
	    return customerCmp;
	 			
}


function checkCustomer(el_id){
	
	var dialogcontent = $("dialogcontentDiv");
	var dialogcontentW = dialogcontent.offsetWidth;
	var dialogcontentH = dialogcontent.offsetHeight;
	var winW= dialogcontentW * 0.3;
	var winH = dialogcontentH*0.3;
	var customerName =  Ext.fly(el_id).dom.value; 
	var customerId =  Ext.getCmp(el_id).getValue();	

	if(customerId == customerName && customerId !=''){

			var cut = (new Customer()).obj;
			
			 var closeBtn ={text: '取消',handler: function(){regCustomerWin.hide();}};
			
			 var regBtn ={text: '注册',handler: function(){

			 	    cut.id = null;
			 	    cut.orgId = config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;	
			 	    cut.customerName = Ext.fly('regCustomerName').dom.value.Trim();
			 	    cut.customerCategoryId = getRadioValue($("regCustomerCategoryName_td"));
			 	    cut.parentId = 0;
			 	    
  
			 	    if(cut.customerCategoryId =='' || cut.customerCategoryId == null){
			 	    	Ext.MessageBox.hide(); 
						Ext.MessageBox.show(
								 	{title:'系统提示!',msg:"请选择客户类型!",width:300,heigth:200,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
						);  
			 	    	return false;
			 	    }
			
			
			
				   var regcustomerName =  Ext.fly('regCustomerName').dom.value; 
				   var regcustomerId =  Ext.getCmp('regCustomerName').getValue();	
	               if(regcustomerId == regcustomerName && regcustomerId !=''){
	               	  customer.saveCustomerForm(cut,callBakFun);
	               }else{
	               	  callBakFun(regcustomerId);
	               }
			 	   

			 }};	
			 
			 function callBakFun(id){
			 	    	inti_set_customer(el_id,1,id,cut.customerName,cut.customerCategoryId);
			 	    	regCustomerWin.hide();

			 }	


    
     if(!regCustomerWin){
     	
     	  buildRegCustomer(winW,winH*0.8,customerName);
     	  
		  regCustomerWin = new Ext.Window({
			   title : '此客户还未注册，请为它选择客户类别',
			   width : winW,
			   height : winH,
			   isTopContainer : true,
			   modal : true,
			   resizable : false,
			    buttons: [regBtn,closeBtn],
			   contentEl :  $("regCustomer_table")
		  	})     	
     }else{
     	 customer.regcustomerCommand.setValue(customerName);  

     }


 	regCustomerWin.show(); 	

	
}
	
}




function buildRegCustomer(winW,height,customerName){
//	ctxPath = $("ctxPath").value;
	
	//创建客户类别
	category.makeOptionsCallBackFun(category,fillFun);	
	function fillFun(objs){
			makeOptionsHtml(objs,"radio","regCustomerCategoryName","categoryName","id","","",[1]);
			setRadioCheckedByValue($("regCustomerCategoryName_td"),2);
	}	
	

	regCustomerComboBox(winW,customerName);
	
	
	
	function onRowSelectd(id,cellInd){
		 var customerName = this.getUserData(id,"customerName");
		 var customerCategoryId = this.getUserData(id,"customerCategoryId"); 
		 inti_set_customer('extCustomer',2,id,customerName,customerCategoryId);
	}

     $("gridbox_regCustomer").style.height =  0 +"px";
    $("gridbox_regCustomer").style.width =  winW*0.98 +"px";


}

function regCustomerComboBox(winW,customerName){

        var mode = 'remote';
        customer.obj.orgId = config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;	

        if(!customer.regcustomerCommand){
        	var storeCustomer = customer.getStoreCustomersAnalyze(mode,customer.obj);    
 			customer.regcustomerCommand = new Ext.form.ClearableComboBox({
 			  fieldLabel: '待注册客户',
		 	  id:'regCustomerName',
		 	  name:'regCustomerName',
		 	  renderTo:'regCustomerDiv',
			  tiggerAction:'all',
			  store:storeCustomer,
			  editable: true,
			  triggerAction: 'all', //query all
			  lastQuery:'1',
			  displayField:'customerName',
			  valueField:'id',
			  mode:mode,
			  width:winW*0.7,
//			  readOnly:true,
			  forceSelection:false, 
			  typeAhead: true,
//			  blankText: "不能为空，请填写",
			  allowBlank:false,
			  emptyText:'请选择...',
			  minChars:2,
			  hiddenName:'helpCode', //提交传过去的值 
			  filterFiled:'customerName',
			  params:customer.obj,
//			  valueNotFoundText:"新客户",
			  listeners:{
			  beforequery:customer.comboFilterBy2.createDelegate(this)}
			  	
			 });       	
        }
        

		 customer.regcustomerCommand.setValue(customerName);  
		 
		function callBack(cbo,e){
		  	    var id = cbo.value;
	            var rec = cbo.store.getById(id)

	    }


}



function inti_set_customer(el_id,i,id,customerName,customerCategoryId){
		var rc1 = Ext.data.Record.create(customer.fileds);
		var cutcmd =  Ext.getCmp(el_id);
		var rc = new rc1({
           id : id,
           customerCategoryId : customerCategoryId,
           customerName:customerName
     });
     
   if(i == 1){
       cutcmd.clearValue(); 
   	   cutcmd.store.add(rc);
   	   cutcmd.setValue(id);  
   }else{
   	   customer.regcustomerCommand.clearValue(); 
   	   customer.regcustomerCommand.store.add(rc);
   	   customer.regcustomerCommand.setValue(id);  
   }

}


function getUserCmd(el_cutId,el_uid,noSearch){
	
	 			var cutcmd =  Ext.getCmp(el_cutId);

     user.obj.orgId = $("orgId").value;	

     if(cutcmd){ 
     	 var customerId =   cutcmd.getValue();	
     	  if(customerId>0){
     	  			user.obj.username =   customerId;	
     	  				}
     		}

      user.storeUser = user.getStoreUsersAnalyze('local',user.obj);
      user.storeUser2 = user.getStoreUsersAnalyze('remote',user.obj);

     var userCmd =  Ext.getCmp(el_uid);
     
     if(!userCmd){
     	
			    var conf  =   {
		        store: new Ext.data.Store(),
		        id:el_uid,
		        name:el_uid,
		        width:180,
		        displayField:'fullName',
		         valueField:'id',
		        typeAhead: true,
		        mode: 'local',
		//        forceSelection: true,
		        triggerAction: 'all',
		        fieldLabel: '业务员',
		        emptyText:'请选择...',
		        selectOnFocus:true,
		         mode: 'local',
		         params:user.obj,
		         filterFiled:'fullName'
		//         renderTo:'signUserDiv'
		    };
		    
		    
					if(noSearch){
	    			 userCmd =  new Ext.form.ClearableComboBox(conf);
	    		}else{
	    			 userCmd =  new Ext.ux.form.LovCombo(conf);
	    			}		
		    
		    
		    
    	 }	
	


		            
	  userCmd.on("beforequery" , function(box){           
		    	                                            
		    	                                             
                       var uname =   Ext.fly(el_uid).dom.value.Trim();
                       
                       	

                        if(uname.length >0){
                            this.mode ='remote';
			                        this.params ={orgId:$("orgId").value,firstName:uname};
			                        this.bindStore(user.storeUser2);     
			                        user.comboFilterBy2(box);                	
                        }else{
	                        	this.mode ='local';
	                        
																		resetUserCom(el_cutId,el_uid,noSearch);
																		
                        										}
                    
		    });           
		            
//			userCmd.on("select" , function(box){});  
// 
// 

       function checkUserIs_Exits(){
       	      checkUserIsExits(el_cutId,el_uid);
                }

 
			 
		 if(noSearch){
		 	    userCmd.on("blur",checkUserIs_Exits,this);	
		 }

		    
		    
		return userCmd;
		    
		    
}


function checkUserIsExits(el_cutId,el_id){
    var id =  Ext.getCmp(el_id).getValue();	
	var name =  Ext.fly(el_id).dom.value; 
	
	if(id == name && id !=''){
			Ext.MessageBox.show(
								 	{title:'系统提示!',msg:"业务员: {"+ name +"} 还未注册,不能保存!",width:310,heigth:200,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
			);  
			return true;
	}   
}


function resetUserCom(el_cutId,el_id,noSearch){

	var cutcmd =  Ext.getCmp(el_cutId);
	var usercmd =  Ext.getCmp(el_id);
	var fun = function(box){usercmd.setValue('');}  
	

	
 	usercmd.clearValue(); 
	user.obj.orgId = $("orgId").value;
     
	if(cutcmd){ 
		
  		
		
  		if(noSearch){

     	 var customerId =   cutcmd.getValue();	
     	          
     	 if(customerId>0){
	     	 	user.obj.username =   customerId;	
	     	 	user.obj.customerIds =   null;	
     	 			}
     	 
			}else{
				 
				 
     	 var customerIds =   cutcmd.getCheckedValue();	
     	          
     	 if(customerIds != ''){
     	 			user.obj.customerIds =   customerIds;	
     	 			user.obj.username = null;
					}else{
     	 			user.obj.customerIds =   null;	
     	 			user.obj.username = null;
     	 			}
//     	 if(userIds>0){user.obj.userIds =   customerId;	}
  			}
     }

  if(usercmd){ 
     	usercmd.mode ='local';
     	user.obj.firstName =  null; 
     }

    usercmd.params  =  user.obj;
    usercmd.bindStore(user.storeUser);
    usercmd.store.on("load",fun);
    usercmd.store.reload();
    
    
    
    
    
  	
	var cutcmd =  Ext.getCmp(el_cutId);
	var usercmd =  Ext.getCmp(el_id);

	 
	var fun = function(box){
			usercmd.setValue('');
	}  
	
	usercmd.clearValue(); 
	user.obj.orgId = $("orgId").value;	
     


     if(cutcmd){ 
     	 var customerId =   cutcmd.getValue();	
     	  if(customerId>0){
     	  	user.obj.username =   customerId;	
     	  }
     }
     
     
     if(usercmd){ 
     	usercmd.mode ='local';
     	user.obj.firstName =  null; 
     }
         
     
     usercmd.params  =  user.obj;
     usercmd.bindStore(user.storeUser);
     usercmd.store.on("load",fun);
     usercmd.store.reload();  
    
    
    
    
    
}


//判断是否允许保存
function saveIncomeCheck(isNew){


//检测客户是否注册
	var customerName =  Ext.fly('extCustomer').dom.value; 
	var customerId =  Ext.getCmp('extCustomer').getValue();

	if(customerId == customerName){
		alert('请选择客户名称!');
		return true;
	}
	if(customerId == ""){alert('客户名称不能为空!');return true;}	

	
	if(config_incomeCodeModelParam == 0){
		var incomeCode = Ext.getCmp('incomeCode').getValue().Trim();
		if(incomeCode == ""){alert('收入编号不能为空!');return true;}	
//		return ckeckIncomeCode();
	}

	
	var incomeMoney = Ext.getCmp('incomeMoney').getValue();
	incomeMoney = incomeMoney ==""?0:incomeMoney;
	if(incomeMoney == 0){alert('到款金额必填!');return true;}
	
	
	
	var userId =   Ext.getCmp('signUser').getValue();
//	alert(userId)
	if(userId == ""){alert('业务员不能为空!');return true;}	
    var incomeDate =   Ext.getCmp('incomeDate').getValue();	
    if(incomeDate == ""){alert('到款日期不能为空!');return true;}	
    
//	var carrier_id =   Ext.getCmp('carrier_id').getValue();	
//	carrier_id =  carrier_id.split(",");
//	if(carrier_id == "") carrier_id = 0;

	var incomePurpose_id =   Ext.getCmp('incomePurpose_id').getValue();	

	if(incomePurpose_id == ""){alert('到款用途不能为空!');return true;}	
	
	var incomeMode_id =   Ext.getCmp('incomeMode_id').getValue();	

	if(incomeMode_id == ""){alert('到款类型不能为空!');return true;}	
}

//检测编号重复
function ckeckIncomeCode(){
	
	var incomeCode =  Ext.getCmp('incomeCode').getValue().Trim();
	var pass = false;

	income.obj.incomeCode = incomeCode;
	income.obj.orgId = $("orgId").value;
	var callback = function(objs){
		if(objs.length>0){
			for(var i = 0;i<objs.length;i++){
				if(incomeCode == objs[i].incomeCode){
				  pass = true;
				  break;	
				}	
			}
			if(pass) alert("收入编号重复！");		

		}
	}
	
	income.CheckIncomeForIncomeCode(income.obj,callback);
	
	return pass;
}

function inti_set_signUser(el_id,id,fullName){
	var cmd =  Ext.getCmp('incomeCode')
	var ucmd =  Ext.getCmp(el_id)
	
	var rc1 = Ext.data.Record.create(user.fileds);
    var rc = new rc1({
           id : id,
           fullName : fullName
     });
      
  
        ucmd.clearValue(); 
   	   ucmd.store.add(rc);
   	   ucmd.setValue(id);  


}



function printReport(mode){
//	 var s=['view','print','excel'];
	 
	if(mode =="view"){
		button_view_order();
	}
	if(mode =="print"){
		button_print_order();
	}
	if(mode =="excel"){
		button_print_export();
	}
	   
}
function button_view_order(){
//	 $("model").value = "view";
//	 $("reportType").value = "orderList";
	 button_print("view");
}	
function button_print_order(){
//	 $("model").value = "print";
//	 $("reportType").value = "orderList";
	 button_print("print");
}
function button_print_export(){
//	 $("model").value = "export";
//	 $("reportType").value = "orderList";
	 button_print("export");
}

//function button_view_order(){
//	 $("model").value = "view";
//	 $("reportType").value = "income_report";
//	 button_print();
//}	
//function button_print_order(){
//	 $("model").value = "print";
//	 $("reportType").value = "income_report";
//	 button_print();
//}
//function button_print_export(){
//	 $("model").value = "export";
//	 $("reportType").value = "income_report";
//	 button_print();
//}
//function button_print(){
//	$("customerIdForm").value = $("customerId").value;
//	$("customerNameForm").value = $("customerName1").value;
//	$("resourceCarrierIdForm").value = $("resourceCarrierId").value;  
//	if(moreChannelNoPullParam == 0){
//		$("resourceCarrierIdForm").value = $("resourceCarrierId").value==0?-100:$("resourceCarrierId").value;
//	}
//	$("startDateForm").value = getFormatDay($("beginDate").value,'ymd');
//	$("endDateForm").value = getFormatDay($("overDate").value,'ymd');
//	$("startDatePullForm").value = getFormatDay($("beginDatePull").value,'ymd');
//	$("endDatePullForm").value = getFormatDay($("overDatePull").value,'ymd');
//	$("currentUser").value = $("config_username").value;
//	$("incomePullDateForm").value = $("incomePullDate").value;
//	
//	var tarForm =  $("tarForm");
//	var reportForm = $("ReportForm");
//
//	reportForm.target = tarForm;
//	reportForm.action="reports/jsp/common_reports.jsp";
//	reportForm.submit(); 	
//}


function button_print(model){
	

	 
	 var paramObjprint = getLoadDataParams();
	  
//   paramObjprint.print2 = mygrid4.print2;
   
   var titleArray = new Array();
   titleArray[2] = "频道*时段属性*分配*比率*余款";
    titleArray[3] = "行业*时段属性*分配*比率*余款";
     titleArray[4] = "年度*月份*分配*比率*余款";

	 var printParam ={};
	 
	 			if(paramObjprint.fenpeiInfo2 ==2){
					shiduanWin.title = '时段分类';
					var flds = titleArray[paramObjprint.fenpeiInfo2];
				 mygrid4.setHeader(flds);
				 mygrid4.setColAlign("left*center*right*right*right");
			}
			if(paramObjprint.fenpeiInfo2 ==3){
					shiduanWin.title = '行业分类';
					var flds = titleArray[paramObjprint.fenpeiInfo2];
					mygrid4.setHeader(flds);
					mygrid4.setColAlign("left*center*right*right*right");
			}
	 
			if(paramObjprint.fenpeiInfo2 ==4){ 
					shiduanWin.title = '年度月份';
					var flds = titleArray[paramObjprint.fenpeiInfo2];
					mygrid4.setHeader(flds);
					mygrid4.setColAlign("left*center*right*right*right");
			}	 
			
	
	 
	 if($("fenpeiInfo2").value>1){

	 		 	 var headers = titleArray[paramObjprint.fenpeiInfo2];
	 		 	 headers=headers.replace(/\*/ig,',');
	 	 
			printParam = {
														model:model,
														title:shiduanWin.title,
			                reportType: "income_new_report2",
			                reportFile:'',
			                headers:headers,
			                displaySumColum:"0,0,0,0,0",
			                colAlign:"left,center,right,right,right",
			                colTypes:"ed,ed,ed,ed,ed",
			                widthsP:"20,20,20,20,20",
			                isSum:false,
			                isVertical:false
		}; 
			printParam.prit2 =2;
	 }else{
			printParam ={
														model:model,
														title:'到款信息',
			                reportType: "income_new_report1",
			                reportFile:'',
			                headers:"序号,到款编号,到款日期,划归年份,客户名称,业务员,频道,到款金额,分配金额,余款,用途,用途,备注", 
			                displaySumColum:"0,0,0,0,0,0,0,1,1,1,0,0,0",
			                colAlign:"center,right,center,center,left,left,right,right,right,right,center,center,left",
			                colTypes:"ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed",
			                widthsP:"4,8,8,8,16,8,4,8,8,8,5,5,10",
			                isSum:false,
			                isVertical:false
		}; 
		 printParam.prit2 =1;
	 }


		  



	 

	 
    var aa = Object.extend(paramObjprint,printParam);
 	 
//	  var h = $H(aa);	
//     
//	  alert(h.toQueryString());
        

	 report.loadApplet(aa,ctxPath,800,500);	
	        
	
}




function show_balance_grid(){
	


     mygrid4.clearAll();
     
//      paramObj = getLoadDataParams();
//      paramObjForSort.print2 =2;
//      mygrid4.print2 =2;
	
	 if(!shiduanWin){
	 	
			var closeBtn = {text: '关闭',handler: function(){
				shiduanWin.hide();
//			 mygrid4.print2=1;
			 $("fenpeiInfo2").value =1;  
			}};
			var regBtn = {text: '重新分配',handler: function(){getBalanceMoney(id);}};	
			var saveBtn = {text: '保存',handler: function(){saveBalanceMoney();}};		
			
			
			
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
			

		 	var rd = {

            xtype: 'radiogroup',
            fieldLabel: 'Auto Layout',
								style:'margin-left:100px;align:middle;CURSOR:pointer;', 
								vertical :false, 
								width : 150,
								columns : 2, 
								name:'opt_package',
								id:"opt_package",
            items: [
	                {boxLabel: '总览', name: 'cb-auto-1',inputValue:1,width :40,checked: true,listeners : {
	                     	 check : function(checkbox, checked) { 
	                     	 		  if (checked) {paramObjForSort.groupModel = 0;showOtherGrid(paramObjForSort);  } 
	                     	 	  }
	                     }               
	
	                },
	                {boxLabel: '明细', name: 'cb-auto-1',inputValue:2,width :40,listeners : {
	                     	 check : function(checkbox, checked) { 
	                     	 		  if (checked) {paramObjForSort.groupModel =1;showOtherGrid(paramObjForSort); } 
	                     	 	  }
	                     }      
	                
	                },
            	]
       		 };
       		 
			shiduanWin = new Ext.Window({
					   title : '时段分类',
					   width : 750,
					   height : 500,
					   isTopContainer : true,
					   modal : true,
					   resizable : false,
					   	        closable : false,
					   loadMask: true,
					   buttons: [rd,printBtn,exportBtn,closeBtn],
					   contentEl :  $("gridbox4")
			}) 	
	 }
	
	   
	     
			if(paramObjForSort.fenpeiInfo2 ==2){
					shiduanWin.setTitle('时段分类');
					var flds = "频道*时段属性*分配*比率*余款";
				 mygrid4.setHeader(flds);
				 mygrid4.setColAlign("left*center*right*right*right");
			}
			if(paramObjForSort.fenpeiInfo2 ==3){
					shiduanWin.setTitle('行业分类');
					var flds = "行业*时段属性*分配*比率*余款";
					mygrid4.setHeader(flds);
					mygrid4.setColAlign("left*center*right*right*right");
			}
			if(paramObjForSort.fenpeiInfo2 ==4){
					shiduanWin.setTitle('月份分类');
					var flds = "年度*月份*分配*比率*余款";
					mygrid4.setHeader(flds);
					mygrid4.setColAlign("left*center*right*right*right");
			}
			mygrid4.init();
			
			showOtherGrid(paramObjForSort);
			


}


function showOtherGrid(paramObj){
	
	   paramObj.fenpeiInfo2= $("fenpeiInfo2").value;
	   
			function setRowColor(){
				
		
					var rows = mygrid4.getRowsNum();
					

						for(var i=0;i<rows-1;i++){
							
							var standTime = mygrid4.cells2(i,1).getValue();
					
							
							if(standTime =='小计'){
//								var row_id = mygrid4.getRowId(i);
							
									for(var j=1;j<5;j++){
//											mygrid4.cells2(i,j).setBgColor("red");
               	mygrid4.cells2(i,j).setTextColor("red");
//											mygrid4.setRowColor(row_id,"red");
//											mygrid4.cells2(i,j).setCellTextStyle(i,j,"font-size:12px;");
									}	
							}

						}
			}
      
			var func = function(xml){
				mygrid4.clearAll();
				mygrid4.loadXMLString(xml,setRowColor);
				Ext.getBody().unmask();
				attachHeaderNew44(mygrid4);
				mygrid4.setSizes();	
			}	

			shiduanWin.show();
			Ext.getBody().mask('数据加载中……', 'x-mask-loading');
			income.getBalanceParaSortXml($H(paramObj).toQueryString(),func);	
}






//function getDate(serviceDate){
//	 var def_Dat =   myDate.parseDate(getFormatDay(_app_params.serviceDate.format2,"y-m-d"));
//	$("beginDate").value = getFormatDay(myDate.getNewDayStartDay1(serviceDate),'y/m/d');
////	$("overDate").value=   getFormatDay(myDate.getNewDayEndDay1(serviceDate),'y/m/d');
//	$("overDate").value= myDate.getEndDay3(def_Dat,"yyyy/MM/dd")
//	
////getFormatDay(_app_params.serviceDate.format2,"y-m-d")
//
//
////	 var def_Dat_end  =  myDate.parseDate(myDate.getEndDay3(def_Dat,"yyyy-MM-dd"));
//
//	Calendar.setup({
//		inputField  : "beginDate",	  // id of the input field
//		//ifFormat	: "%Y%m%d",	  // the date format
//		firstDay:1,
//		singleClick	  : true,
//		button	  : "beginDate"// id of the button
//	});
//	
//	Calendar.setup({
//		inputField  : "overDate",	  // id of the input field
//		firstDay:1,
//		//ifFormat	: "%Y%m%d",	  // the date format
//		singleClick	  : true,
//		button	  : "overDate"	// id of the button
//
//	});
//
//
//}

function getDate(serviceDate){

	 var def_Dat =   myDate.parseDate(getFormatDay(_app_params.serviceDate.format2,"y-m-d"));

	 var startDateFileld =  new Ext.form.DateField({
	        fieldLabel : '开始日期',
	        id : 'start_date_query',
	        enableKeyEvents : true,
	        width : 90,
	        allowBlank : false,    
	        format : 'Y-m-d',
	        renderTo:'beginDateDiv',
	       	value:myDate.getStartDay3(def_Dat,"yyyy-MM-01")
	       });  
  
  	var endDateFileld =  new Ext.form.DateField({
	        fieldLabel : '开始日期',
	        id : 'end_date_query',
	        enableKeyEvents : true,
	        width : 90,
	        allowBlank : false,    
	        format : 'Y-m-d',
	        renderTo:'overDateDiv',
	       	value: myDate.getEndDay3(def_Dat,"yyyy-MM-dd")
	       });  

}







