//实例化对象
var org = new SysOrg();
var income = new Income();
var incomeMode = new IncomeMode();
var incomePurpose = new IncomePurpose();
var customer = new Customer();
var category = new Category();
var user = new User();
var incomePull = new IncomePull();
var carrier = new Carrier();
var branch = new Branch();
var resourceType = new ResourceType();
var channelParam;
var channelPullParam;
var moreChannelNoPullParam;
var config_serviceDate;
var tag_orderList_finance;
var loginUser;
var firstInit =0;
var config_incomeCodeModelParam;
var config_incomeMessageAlertParam;
var regCustomerWin;
var orgId = 1;
var orgIdRel = 1;



callOnLoad(init);

function init(){
	
	resetHeigth();
	
	setIncomePara(income);
	setIncomeModePara(incomeMode);
	setIncomePurposePara(incomePurpose);
	setIncomePullPara(incomePull);
	setCustomerPara(customer);
	setUserPara(user);	
	setCarrierPara(carrier);
	//setBranchPara(branch);

	loginUser =  _app_params.user.username;
	tvNameParam =  _app_params.sysParam.tvNameParam;	
    config_serviceDate = _app_params.serviceDate.def;
    
    
    config_incomeMessageAlertParam = _app_params.sysParam.incomeMessageAlertParam;
    config_useCarrierAliname = _app_params.sysParam.useCarrierAliname;

	config_incomeCodeModelParam = _app_params.sysParam.incomeCodeModelParam;
	config_isSignUserBalance = _app_params.sysParam.isSignUserBalance;
	config_useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
	
	config_withResourceSort = _app_params.sysParam.withResourceSort;
	config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;
		
		
	channelParam = _app_params.sysParam.channelModelParam;
	channelPullParam = _app_params.sysParam.channelPullParam;
	moreChannelNoPullParam = _app_params.sysParam.moreChannelNoPullParam;
	tag_orderList_finance =  _app_params.rights.tag_orderList_finance;
	config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;

//    orgId =  getParamFromUrl(window.location.href,"orgId");
//    inc_id =  getParamFromUrl(window.location.href,"id");
	

	if(config_oneOrgMoreSuborgsParam == '1'){
		orgId =  '1'; 
		orgIdRel = getParamFromUrl(window.location.href,"orgId")+'';
	}else{
		orgId =  getParamFromUrl(window.location.href,"orgId")+'';
	}
	
	getDate();
	
	 buttonEventFill();
	 	

			
	 var id = $("id").value;
	 

	 
//	 showPullTable(id);
	 
	 
	 
	 
	 
	 
	 
	 _make_org_select("orgId2",142,"getresourceType");	
	 $("orgId2").show();
	 



	 if(orgId > 0){
	 	$("orgId2").value = config_oneOrgMoreSuborgsParam == '1'?orgIdRel:orgId;
	 }
	 
	 
//	 alert(id);
	  getresourceType();
	
//	if(orgId =='') {
//	 	orgId = $("orgId2").value; 
//	 }else{
//	 	$("orgId2").value = orgId;
//	 }
	 

//	  getresourceType();
	 
//	 org.makeSelectWidth(org.obj,"orgId2","getresourceType","138",function(){
//	 	if(orgId > 0){
//	 		 $("orgId2").value = orgId;
//	 		 getresourceType();
//	 	}
//	 });
//
//	 if(config_useMoreCarrierSortParam == 0){$('orgId_td').hide();}

     
     
          
//	  var incomeid = $("incomeId").value;
			
	
		//多频道不划帐
		if(moreChannelNoPullParam == 1){
				var fct = function(){
                    initUser2();
				}			
		 	    initCarrier(fct);
		}else{
//		 	    $("carrierName_row").style.visibility = "hidden";
		 	    $("carrierName_row").style.cssText ="visibility:hidden;display:none";
		 	    $("carrierName2").hide();
	            initUser2();
		}	
		
	
		initCustomer(orgId);
		
		
		incomeMode.makeSelectFromMap(incomeMode.obj,"incomeModeId","",142,null);
		
		
		 incomePurpose.obj.version = getFormatDay($("incomeDates").value,'y');
	    
		incomePurpose.makeSelectFromMap(incomePurpose.obj,"incomePurposeId","",142,null);
		
		
		if(tvNameParam =='fztv'){
			income.makeSelectFromMap({},"accountId","",142,null);
			user.makeSelectFromMapLimit("createName","",142,setCurUserId);
	//		initGrid();
		}else{
			$("bank_id").hide();
			$('user_id').hide();
			$('income_no').hide();
		}
		
		if(config_incomeMessageAlertParam == 0){
			$("sendMsg2User_lable").hide();
			$("sendMsg2User").hide();
		}
		
		//user.makeSelectFromMapLimit(user.selectName,"",setCurUserId);	
		
		if(!tag_orderList_finance){
			$("btn_save").hide();
			$("btn_delete").hide();
			$("btn_pull").hide();
			$("btn_export").hide();
		}
		
//	   if(config_incomeCodeModelParam == 1){
//	   	 $("incomeCode").disabled = true;
//	   }       
	
	showPullTable(id);
	  
	  if(firstInit == 0) getIncome();	
	  
	    firstInit++; 
		



//        initCustomer(orgId);
	 	

}

//
//function onselectOrgCmd(){
//	getresourceType();
//	reloadCustomerCmd();
//}
//
//function reloadCustomerCmd(){
//	customer.obj.orgId = $("orgId2").value;
//	customer.customerCommand.params = customer.obj;
//	customer.customerCommand.store.reload();
//}


function initCustomer(orgId){
        customer.obj.orgId = orgId;
//	    customer.obj.customerName ="local";
	    customer.storeCustomer = customer.getStoreCustomersAnalyze('remote',customer.obj);   
	    
	    if(!customer.customerCommand){
			customer.customerCommand =new Ext.form.ComboBox({
			 	  id:'extCustomer',
			 	  name:'extCustomer',
				  renderTo:'extCustomerDiv',
				  tiggerAction:'all',
				  store:customer.storeCustomer,
				  editable: true,
				  triggerAction: 'all', //query all
				  lastQuery:'1',
				  displayField:'customerName',
				  valueField:'id',
				  mode:'remote',
				  allowBlank:false,
				   width:142,
				   listWidth:300,
				   forceSelection:false, 
				  allowBlank:false,
		
				  emptyText:'请选择...',
				  minChars:2,
				  hiddenName:'helpCode', //提交传过去的值 
				  filterFiled:'customerName',
				   params:customer.obj,
				  listeners:{beforequery:customer.comboFilterBy2.createDelegate(this)}	
			 });
	    } 

		 	
        
//         inti_set_customer(id,customerName);
	 	

	       function getcheckCustomer(){
	       		checkCustomer();
	       }
			
			customer.customerCommand.on("blur",getcheckCustomer,this);	
			
//			inti_set_customer(1,$("customerId").value,$("customer.customerName").value,$("customerCategoryId").value);
		 
		 
//		  	customer.storeCustomer.on('load', function(){
//					 Ext.getCmp("extCustomer").setValue($("customerId").value);			
//			}); 	
			
			 customer.customerCommand.on("select" , function(box)
		    {
//		    	 var customerId = box.getValue();
                 resetUserCom();
		    	 user.userCommand.onTriggerClick(); 
//		    	 initUser(customerId);
		    });
	 			
}



 	function getresourceType(){
 		
 	    var id = $("id").value;
// 	    alert($("orgId2").value);
   
 	    
	    if(config_withResourceSort == 1){
	    				var ort_id =     config_oneOrgMoreSuborgsParam == '1'?orgId:$("orgId2").value;
	    	    resourceType.obj.orgId = ort_id;
//	    	    resourceType.obj.orgId = $("orgId2").value;
	    	    resourceType.obj.version =getFormatDay($("incomeDates").value,'y');
	    	    resourceType.makeSelectItemAnalyze2(resourceType.obj,"resourceTypeName","",100,0);
	    }else{
				carrier.obj.nodeLevel =1;
//				carrier.obj.orgId = $("orgId2").value;
					carrier.obj.orgId = config_oneOrgMoreSuborgsParam == '1'?orgId:$("orgId2").value;
				
				
				
//				carrier.getCarriersAllFromMap(carrier.obj,false,true,$("carrierName"));    	
//               alert(id);
	    	
	    		if(id > 0){
					carrier.makeSelectItemAnalyze5(carrier.obj,"carrierName","",142,false,loginUser,null);
				}else{
					carrier.makeSelectItemAnalyze6(carrier.obj,"carrierName","",142,false,loginUser,null);
				}

	    }
	    
	
	    
	  	var cutcmd =  Ext.getCmp('extCustomer');
  	    var usercmd =  Ext.getCmp('signUser'); 
  	    if(cutcmd){
  	    	 cutcmd.clearValue(); 
//  	    	 cutcmd.params.orgId = $("orgId2").value;
  	    	 cutcmd.params.orgId = config_oneOrgMoreSuborgsParam == '1'?orgId:$("orgId2").value;
  	    	 
  	    	 
  	    	 cutcmd.store.reload();
  	    	 
//  	    	 cutcmd.load(); //加载井下拉框的store     
  	    }
	    if(usercmd){
	    	 usercmd.clearValue(); 
//	    	 resetUserCom();
	    }
	    	
	    
	
     		
 	}
//function inti_set_customer(id,customerName){
//	var rc1 = Ext.data.Record.create(customer.fileds);
//    var rc = new rc1({
//           id : id,
//           customerName:customerName
//     });
//     
//
//       customer.customerCommand.clearValue(); 
//   	   customer.customerCommand.store.add(rc);
//   	   customer.customerCommand.setValue(id);  
//	   $("customerId").value = id;
//}
//


function initBranch(){
	var fct = function(){}
	 branch.makeSelect(branch.obj,branch.selectName,"");
//	 user.getUserByCarrier($("carrierName2").value,$(user.selectName),fct,"");
}


function initUser(customerId){
	//var fct = function(){setCurUserId()}
	 var carrierId = $("carrierName2").value;
	 customerId = customerId ==''|| isUndefined(customerId)||customerId == '0'?null:customerId;
	 user.getUserByCarrier(carrierId,customerId,$(user.selectName),setCurUserId,"");
//	if(firstInit == 0) getIncome();	
//	firstInit++;
	 
//	 initUser2();
}


function initUser2(){
	
	 var cutcmd =  Ext.getCmp('extCustomer');
//	 
//		var org_id = config_oneOrgMoreSuborgsParam == '1'
	 user.obj.orgId = $("orgId2").value;
//     user.obj.orgId = orgId;
     
     
//     if(moreChannelNoPullParam == 1){
//     	     user.obj.passwordHint = $("carrierName2").value;
//     }
     

     
     if(cutcmd){ 
     	 var customerId =   Ext.getCmp('extCustomer').getValue();	
     	  if(customerId>0){
     	  	user.obj.username =   customerId;	
     	  }
     }

     
//      alert(user.obj.orgId);
//     alert(user.obj.passwordHint);
//      alert( user.obj.username );
     
     
      user.storeUser = user.getStoreUsersAnalyze('local',user.obj);
//      var store = new Ext.data.Store();
     user.storeUser2 = user.getStoreUsersAnalyze('remote',user.obj);
     
     
//     if(!user.userCommand){
//	 		user.userCommand  = new Ext.form.ComboBox({
//        			xtype:"combo",
//	                fieldLabel: '用户名称',
//	                emptyText:'请选择...',
//	                renderTo:'signUserDiv',
//	                name: 'signUser',
//	                id:'signUser',
//	                width:138,
//                    store: new Ext.data.Store(),
//                    displayField: 'fullName',
//                    valueField:'id',
//                    editable: true,
//                    triggerAction: 'all',
//                    mode: 'local',
//                    allowBlank:false,
//                     filterFiled:'fullName',
//                     params:user.obj
//		            });	
//     }

     if(!user.userCommand){
	      	user.userCommand  =    new Ext.form.ClearableComboBox({
        store: new Ext.data.Store(),
        id:'signUser',
        name:'signUser',
        width:142,
        displayField:'fullName',
         valueField:'id',
        typeAhead: true,
        mode: 'local',
        forceSelection: true,
        triggerAction: 'all',
        fieldLabel: '用户名称',
        emptyText:'请选择...',
        selectOnFocus:true,
         mode: 'local',
         params:user.obj,
         filterFiled:'fullName',
        renderTo:'signUserDiv'
//        params:paramObj
//		filterFiled:'fullName',
//		listeners:{beforequery:OBJ.comboFilterBy2.createDelegate(this)}	
    });
     }	
	


		            
		      user.userCommand.on("beforequery" , function(box)
		    {           
		    	     
//		    	      if(!user.storeUser2){
//		    	      	     user.storeUser2= user.getStoreUsersAnalyze('remote',user.obj);
//		    	      }
		    	 
		    	      
                       var uname =   Ext.fly('signUser').dom.value.Trim();
                  
                        if(uname.length >0){
                            this.mode ='remote';
                                                                
	                        this.params ={orgId:orgId,firstName:uname};
	                        this.bindStore(user.storeUser2);     
	                        user.comboFilterBy2(box);                	
                        }else{
                        	this.mode ='local';
                        	resetUserCom();
                        }

                    	
                    
		    });           
		            
			user.userCommand.on("select" , function(box)
		    {
                    		 if(config_isSignUserBalance != 1){
                    		 	$(user.selectName).value = customer.customerCommand.accountBank;
                    		 }
		    });    
		    
		    
		     
		     user.userCommand.on("blur",checkUserIsExits,this);	
		    
		            
//		    user.storeUser.on("load",function(){
////		     	alert(income.obj.userId);
//		    	 Ext.getCmp("signUser").setValue(income.obj.userId);       
//		    });
		            
		    	  
	
 	
}


function checkUserIsExits(){
    var id =  Ext.getCmp('signUser').getValue();	
	var name =  Ext.fly('signUser').dom.value; 
	
	if(id == name && id !=''){
			Ext.MessageBox.show(
								 	{title:'系统提示!',msg:"业务员: {"+ name +"} 还未注册,不能保存!",width:310,heigth:200,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
			);  
			return true;
	}
	     
}

function initCarrier(fct){
    carrier.obj.nodeLevel =1;
//    carrier.obj.orgId = $("orgId2").value;
    carrier.obj.orgId =  config_oneOrgMoreSuborgsParam == '1'?orgId:$("orgId2").value;
    
   
	//根据是否分频道，取得频道下拉列表
	function fnct(){
		var carrierId = getParamFromUrl(window.location.href,"resourceCarrierId");
		if(carrierId > 0) $("carrierName2").value = carrierId;
		if(fct) fct();
	}
	if(channelPullParam ==0){
		carrier.makeSelectItemFromMapOrderList(carrier.obj,"carrierName2","resetUserCom",fnct);
	}else{  
		var id = $("id").value;
		if(id > 0){
//				carrier.makeSelectItemAnalyze5(carrier.obj,"carrierName2","resetUserCom",142,true,fnct);
				carrier.makeSelectItemAnalyze5(carrier.obj,"carrierName2","resetUserCom",142,false,loginUser,fnct);
		}else{
				carrier.makeSelectItemAnalyze6(carrier.obj,"carrierName2","resetUserCom",142,true,loginUser,fnct);
		}
//			var fnct = function(){};
	}	
		
}



function resetUserCom(){
	
	
//	if(!user.storeUser){
//		 user.storeUser = user.getStoreUsersAnalyze('local',user.obj);
//	}
	
	var cutcmd =  Ext.getCmp('extCustomer');
	var usercmd =  Ext.getCmp('signUser');

	 
	var fun = function(box){
		 Ext.getCmp("signUser").setValue('');
	}  
     user.userCommand.clearValue(); 
     user.obj.orgId = $("orgId2").value;
//     user.obj.orgId = config_oneOrgMoreSuborgsParam == '1'?orgId:$("orgId2").value;
    
     
     if(moreChannelNoPullParam == 1){
     	     user.obj.passwordHint = $("carrierName2").value;
     }

     if(cutcmd){ 
     	 var customerId =   Ext.getCmp('extCustomer').getValue();	
     	  if(customerId>0){
     	  	user.obj.username =   customerId;	
     	  }
     }
     
     
     if(usercmd){ 
     	usercmd.mode ='local';
     	user.obj.firstName =  null; 
     }
         
     
     user.userCommand.params  =  user.obj;
     user.userCommand.bindStore(user.storeUser);
     user.userCommand.store.on("load",fun);
     user.userCommand.store.reload();
}


function format_income(ev){
//	onblurText(ev);
	var el = getElementByEvent(ev);
	if(el.name=='incomeMoney'){
		var value = el.value*1;
//		alert(value.format());
//		el.value =value.format();
		el.value = fmoney(value,"###,###,###,###");	
	}
}
 
function buttonEventFill(){
	var btn_save = $("btn_save");
	btn_save.onclick = saveIncome;
	
	var btn_delete = $("btn_delete");
	btn_delete.onclick = deleteIncome;
	
	var btn_cancel = $("btn_cancel");
	btn_cancel.onclick = cancelIncome;
	
	var btn_pull = $("btn_pull");
	btn_pull.onclick = moneyPull;
	
	var txt_incomeCode = $("incomeCode");
	txt_incomeCode.onkeypress = getIncomeByCode;
	
//	var txt_incomeMoney = $("incomeMoney");
//	txt_incomeMoney.onkeyup = format_income;	
//	txt_incomeMoney.onafterpaste = format_income;	
	
	
	
	//var Btn_customerName = $("customerName");
	//Btn_customerName.onclick = resetText;
	//Btn_customerName.onkeypress = getCustomerAutoCompltByName;
	
//	var incomeMoneyText = $("incomeMoney");
//	incomeMoneyText.onblur = onblurText;
	
	var btn_export = $("btn_export");
	btn_export.onclick = button_print_export;
	
	var btn_add = $("btn_addIncome");
	btn_add.onclick = newIncome;
	
}

function  newIncome(){
	    $("incomeId").value ='';
	    var carrierId = getParamFromUrl(window.location.href,"resourceCarrierId");

		strUrl = $('ctxPath').value+'editIncome.html?resourceCarrierId='+ carrierId +'&customerId=&orgId='+$("orgId").value;
		window.location.href= strUrl;
//		getresourceType();
}


function addIncome(){
	 $("incomeId").value ='';
//	 orgId = $("orgId2").value;
	 orgId = config_oneOrgMoreSuborgsParam == '1'?orgId:$("orgId2").value;
	 
	income.id = null;
	 $("id").value = 0;
	$("incomeCode").value = '';
	$("incomeCode").value = '';
	 
//	 getIncomePullTable(0);
	 DWRUtil.removeAllRows(incomePull.tBody);
	
}



function button_print_export(){
		if($("incomeId").value=='') return false;
		window.location.href=getReportURL('export');
}

function getReportURL(model){

		var url = $('ctxPath').value;
		
		var a = {
			 	model: model,
                reportType: "incomeForm_report",
                headers:'到款日期,收入编号,客户名称,频道,业务员,订单编号,到款金额,到款类型,到款用途,备注',
                displaySumColum:'0,0,0,0,0,0,0,0,0,0',
                isSum:true,
                isVertical:false,
                incomeId:$("incomeId").value
		};		
		var h = $H(a); 
		url = url +"reports/printServlet?"+ encodeURI(h.toQueryString());
		
		return url;
}
function onblurText(){
	var isd = isDigit3($("incomeMoney").value);
	if(!isd){
		alert("必须数字!");	
		$("incomeMoney").value="";
	}
}


function moneyPull(){
    var incomeMoney = $("incomeMoney").value;
    if(incomeMoney > 0){
	    //var customerId = $("customerId").value;
	    var customerId = customer.customerCommand.getValue();
	    customerId = customerId==''|| !isDigit(customerId)?0:customerId;
	    
	    if(customerId > 0){
	    	 var customerName = escape(customer.customerCommand.getRawValue());
	    	 var ort_id =     $("orgId2").value;
	    	 parent.location.href ="incomePulls.html?customerId=" +customerId +"&orgId="+ ort_id +"&customerName="+customerName;
	    }
    }else{
      alert("请先输入发票金额!");
    
    }

}

function showPullTable(id){
//	if(channelPullParam == 0||moreChannelNoPullParam == 1){
//    alert(channelPullParam);
//    alert(channelPullParam);
    if(channelPullParam == 0){
		$("incomePull_div").hide();
	}else{
		$("incomePull_div").show();
		getIncomePullTable(id);
	}
	
	if(tvNameParam =='fztv') $("btn_export").show();
}

function getIncome(){
	
	//var id = getParamFromUrl(parent.location.href,"id");
	var id = $("id").value;

	$("incomeId").value = id;
 	if(id > 0){
		var func = function(o){
			setIncome(o);
		}
		income.getIncome(func,id);	
 	}else{
 		
// 		if(config_incomeCodeModelParam == 1){
//	  		var fun = function(nextCode){
//	 			$("incomeCode").value = nextCode;
//	 		}
//	 		var year = substring($("incomeDates").value,1,4);
//	 		
//	 		SysSequenceManager.getSysSequenceByObjectNew(orgId,'sequence_tb_income',year,fun);			
// 		}
 		
// 		customer.customerCommand.setValue('');

 	}
 	
}


function getIncomeByCode(ev){
	var incomeCode = $("incomeCode").value.Trim();
	if(ev.keyCode == 13){
		if(incomeCode != '') {
			var func = function(o){
				if(o){
						setIncome(o);
				}else{
					alert("没有找到匹配的数据");
				}
			
				}
			var year = getFormatDay($("incomeDates").value,'y');
			if(config_incomeCodeModelParam == 1){
				income.getIncomeByCodeAuto(func,$("orgId2").value,year,incomeCode);
			}else{
				income.getIncomeByCode(func,incomeCode);
			}
			
		}
	}
}

function setIncome(o){
	
	income.setObject(o);
	
	DWRUtil.setValues(o);
	//$("customerName").value = o.customer.customerName;
	//var customerName2 = Ext.fly('customerName2');
	//customer.customerCommand.setValue(o.customer.customerName);  
	
//	if(!customer.customerCommand)initCustomer(income.obj.orgId);
		

//	Ext.fly('extCustomer').value= o.customer.customerName;
	
//	 Ext.getCmp("signUser").setValue(o.userId); 
	 
	inti_set_customer(1,o.customerId, o.customer.customerName);
	
	customer.customerCommand.setValue(o.customerId);
	$("customerId").value = o.customerId;
	
	
//	if(!user.userCommand)initUser2();
	
	inti_set_signUser(o.userId, o.user.fullName);
	
	
	if(o.incomeDate ==null) o.incomeDate ="";
	$("incomeDates").value=getFormatDay(o.incomeDate+'','y/m/d') ;
	if(o.incomePullDate ==null) o.incomePullDate ="";
	$("incomePullDate").value=getFormatDay(o.incomePullDate+'','y/m/d') ;
	$("incomeId").value = o.id;
	//alert(o.userId);
	$(user.selectName).value = o.userId;
	//income.obj.userId = o.userId;
 
	$("accountId").value=o.modifyBy;
	
	$("sendMsg2User").checked=true;
	
	
//	getIncomePullTable(o.id);
//	getOrdersTable(o.id);
}

function getIncomePullTable(incomeId){
	
//    alert(incomeId);
	
	var func = function(objs){
        incomePull.tvNameParam = tvNameParam;
		incomePull.fillTalbe(objs);
		
		var ic = getIncomePullMoneyIn(objs);
		
		if(objs.length>0 && moreChannelNoPullParam == 1){
			
		
	
			if(config_withResourceSort == 0){
				incomePull.obj.resourceCarrierId = objs[0].resourceCarrierId;
				$("carrierName2").value = incomePull.obj.resourceCarrierId;
			}else{
				 incomePull.obj.resourceCarrierId = 0;
				 incomePull.obj.resourceTypeId = objs[0].resourceTypeId;
				 
//				$("resourceTypeName").value = incomePull.obj.resourceTypeId;
			}

			
			initUser();	
		}
			

		if(ic > 0){
			
			if(config_withResourceSort == 0){
				$("carrierName2").disabled = true;
				$("carrierName").disabled = true;
			}else{
				$("resourceTypeName").disabled = true;
			}
			//$("customerName").disabled = true;
			customer.customerCommand.disable();  
		}else{
			if(config_withResourceSort == 0){
				$("carrierName2").disabled = false;
				$("carrierName").disabled = false;
			}else{
				$("resourceTypeName").disabled = true;				
			}


			//$("customerName").disabled = false;
			if(customer.customerCommand) customer.customerCommand.enable();
			 	 
		}		
		
	}
	
	incomePull.reset();
	incomePull.obj.incomeId = incomeId;
	incomePull.getIncomePullsByIncomeId(incomePull.obj,func);
}
function getOrdersTable(incomeId){
	
	var func = function(xml){alert(xml);
		mygrid.clearAll();	
		mygrid.loadXMLString(xml);
	}
	incomePull.getOrdersByIncomeId(incomeId,func);
}
function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");

	var flds = "序,订单编号,业务员,新闻频道,影视频道,生活频道,少儿频道";
	mygrid.setHeader(flds);
	
	var columnIds = "sort,orderCode,userName,carrier1,carrier2,carrier3,carrier4";
	mygrid.setColumnIds(columnIds);

	mygrid.setInitWidthsP("5,10,9,19,19,19,19");         
	mygrid.setColAlign("center,left,left,right,right,right,right")
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed");
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	mygrid.setDragBehavior("nextSibling"); //nextSibling complex
	mygrid.enableDragAndDrop(false);
	mygrid.init();	 
}
function getIncomePullMoneyIn(objs){
	var ic = 0;
	for(var i = 0;i<objs.length;i++){
		ic =+ objs[i].moneyIn;
	}
	return ic;
}


//判断是否允许保存
function saveIncomeCheck(isNew){


	//var customerName = $("customerName").value;
	var customerName = Ext.fly('extCustomer').getValue();
	if(customerName == '请选择...') customerName='';
	if(customerName == ''){alert('客户不能为空!');return true;}	
	
//检测客户是否注册
	var customerName =  Ext.fly('extCustomer').dom.value; 
	var customerId =  Ext.getCmp('extCustomer').getValue();

	if(customerId == customerName){
		checkCustomer();
		return true;
	}
		
	
	 if(checkUserIsExits()) return true ;
	
	
	
//	var userId =  $("userId").value;
//	if(userId == 0){alert('请选择业务员!');return true;}		
	
	if(config_incomeCodeModelParam == 0){
		var incomeCode = $("incomeCode").value.Trim();
		if(incomeCode == ""){alert('收入编号不能为空!');return true;}			
	}

	
	var incomeMoney = $("incomeMoney").value;
	incomeMoney = incomeMoney ==""?0:incomeMoney;
	if(incomeMoney == 0){alert('到款金额必填!');return true;}
	
	var isd = isDigit3(incomeMoney);
	if(!isd){
		alert("必须数字!");	
		$("incomeMoney").value="";
	}
	
	
	if(channelPullParam == 0){
		if(!isNew){
			var trs = incomePull.tBody.getElementsByTagName("tr");
			var moneyPull = $("incomeMoney").value*1;
			var moneyIn = getCellValue(trs[0],2)*1;
			if(tvNameParam=='fztv'){
					moneyIn=getCellValue(trs[0],4)*1;  
			}
			if(moneyPull >0 && moneyIn > 0 && moneyPull<moneyIn){
				alert("到账金额不能小于平账金额!"); return true;
			}	
		}
	}else{
		
		var btn_SaveIncomePull = $("btn_SaveIncomePull");
		
		if(!isUndefined(btn_SaveIncomePull)){
			//var pullObj =  $("carrierName").parentNode.parentNode.obj;
			var moneyPull = $("moneyPull").value*1;
			var moneyIn = $("moneyIn").value*1;
			var incomePullId = btn_SaveIncomePull.getAttribute("paraId");	
			var incomeMoney = $("incomeMoney").value;
			var moneyPullSum = getMoneyPullSum(incomePullId);
			
			incomePullId = incomePullId == 'null'?null:incomePullId;
			
			
			
			if(moneyPull == 0){alert('划账金额不能为0!');return true;}
			
			if(config_withResourceSort == 0){
//					if($("carrierName").value == 0 && tvNameParam!='fztv' ){alert("请选择频道");return true;}	
			}else{
				
			}

			
//			if($("resourceTypeName").value == 0 && tvNameParam == 'xmtv' ){alert("请选择分类");return true;}	
			
			if(moneyIn>0 && moneyPull<moneyIn) {alert('划帐金额不能小于已分配金额!'); $("moneyPull").value = $("moneyIn").value;return true;}
			//alert(moneyPullSum+"  1  "+incomeMoney);
			if(moneyPullSum>0&& moneyPullSum>incomeMoney){alert("划账金额总和不能大于到款金额!");return true;}
			if(moneyPullSum<0&& moneyPullSum<incomeMoney){alert("划账金额总和不能小于于到款金额!");return true;}
			
			

			if(incomePullId !="" && incomePullId != null && config_withResourceSort == 0){
				var carrierId =  $("carrierName").value;
				var carrierId_old = $("carrierName").parentNode.parentNode.obj.resourceCarrierId;
				if(moneyIn>0 && carrierId != carrierId_old){
					alert("已有分配，不允许调整频道");	
					$("carrierName").value = carrierId_old;
					return true;
				}	
			}


			if(incomePullId !="" && incomePullId != null && config_withResourceSort == 1){
				var resourceTypeId =  $("resourceTypeName").value;
				var resourceTypeId_old = $("resourceTypeName").parentNode.parentNode.obj.resourceTypeId;
				if(moneyIn>0 && resourceTypeId != resourceTypeId_old){
					alert("已有分配，不允许改变分类");	
					$("resourceTypeName").value = resourceTypeId_old;
					return true;
				}				
				
			}	
			

			
		}else{
		     var incomePullId = 0;
		     var incomeMoney = $("incomeMoney").value;
		     var moneyPullSum = getMoneyPullSum(incomePullId);
		     var moneyInSum = getMoneyInSum(incomePullId);
		     //alert(incomeMoney); alert(moneyPullSum);

		     if(incomeMoney*1>0 && moneyInSum*1 > incomeMoney*1){
		     	alert("到款金额不能小于已分配金额!");
		     	$("incomeMoney").value = income.obj.incomeMoney;
		     	return true;
		     }		     
		     
		     
		     if(incomeMoney>0 && moneyPullSum>incomeMoney && moreChannelNoPullParam != 1){
		     	alert("划账金额总和不能大于到款金额!");
		     	$("incomeMoney").value = income.obj.incomeMoney;
		     	return true;
		     }
		}
		
	}
	
	
	
//	if(ckeckIncomeCode()){ return true}

}

//检测编号重复
function ckeckIncomeCode(){
	var incomeCode = $("incomeCode").value.Trim();
	var incomeId = $("incomeId").value;
	var pass = false;

	if(income.obj.incomeCode == incomeCode.Trim()) return false;
		
	
	
	
	
	income.obj.incomeCode = incomeCode;
	var callback = function(objs){
		if(objs.length>0){
			for(var i = 0;i<objs.length;i++){
				if(incomeCode == objs[i].incomeCode){
				  pass = true;
				  break;	
				}
					
			}
			
			if(pass) alert("收入编号重复！");		

//			if(incomeId!=objs[0].id){
//				 alert("收入编号重复！");
//				 pass = true;
//			 }
		}
	}
	income.CheckIncomeForIncomeCode(income.obj,callback);
	return pass;
}


function saveIncome(){
	
	var incomeId = $("incomeId").value;
    	var isNew = incomeId == 0|| incomeId =="" || incomeId == null?true:false;
	var permitSave = saveIncomeCheck(isNew);
	if(permitSave) return false;
	
	
//	 function callBackFun(){
//	 	    //alert("保存成功1");
//			//if(channelPullParam == 0) cancelIncome();
//			if(channelPullParam == 0 || tvNameParam =='hntv'){
//			    var incomeMoney = $("incomeMoney").value;
//			    if(incomeMoney > 0){
//				    var msg = "请确认是否进入分配?";
//				    ans = confirm(msg);
//				    if (ans) {
//				        moneyPull();
//				    } else {
//						addIncome();
//				
////				       $("incomeId").value = 0;
////				       income.id = null;
////				       $("id").value = 0;
////				        $("incomeCode").value = '';
////				         $("incomeCode").value = '';
////				       DWRUtil.removeAllRows(incomePull.tBody);
//				       
////				      return false;
//				    }		
//			    }else{
//			     	cancelIncome();
//			  
//			    }
//			    
//			}else{
//			       
//				addIncome();
//			}
//			
//	
//	}
		
	
	var func = function(income_Id){

		$("id").value = income_Id;
		$("incomeId").value = income_Id;
		
		if(tvNameParam =='fztv'){
			var callback = function(objs){
				var userName = '';
				for(var i=0;i<objs.length;i++){
					userName+='<'+objs[i].fullName+'>';
				}
				if(userName==''){
					alert("该笔到款的客户没有签过订单,请与业务员联系。");
				}else{
					alert("该笔到款与业务员"+userName+"有关");
				}
			}
			var customerId = customer.customerCommand.getValue();
			customerId = customerId==''|| !isDigit(customerId)?0:customerId;
			
			//var customerId = $("customerId").value==''?0:$("customerId").value;
			user.getUserNameByCustomerId(customerId,callback);
		}
		

		
		var Btn_saveIncomePull= $("btn_SaveIncomePull");
		var isEditPull = !isUndefined(Btn_saveIncomePull);
		var incomePullId  = '';
		//这是河南台情况
		if(!isEditPull && moreChannelNoPullParam){
			var trs = incomePull.tBody.getElementsByTagName("tr");
			if(trs.length==1)incomePullId = trs[0].obj.id;
		}else{
			incomePullId = Btn_saveIncomePull.getAttribute("paraId");
		}
		
		var callbak =function(){
			 if(channelPullParam == 0) {
			 	 cannelIncomePull();
			  	 Ext.MessageBox.show({title:'系统提示!',msg:"保存完成!",width:300,heigth:200,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO});  
			 }else{
			 	 getIncomePullTable(income_Id);
//				 ans = confirm("保存完成,是否使用当前的数据继续录入?");
                 
//				 Ext.MessageBox.confirm({title:'系统提示!',msg:"保存完成,是否使用当前的数据继续录入?!",width:300,heigth:200,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO});  

	             Ext.MessageBox.confirm('系统提示','保存完成,是否使用当前的数据继续录入?',function (value){  
	             if(value == 'yes'){  
	                  addIncome();
	               }
   				})        
	             
	             
	             
			 }
		};

		if(isEditPull || moreChannelNoPullParam){
			 if(incomePullId =='null') incomePullId = null;
			 saveIncomePull(income_Id,incomePullId,callbak);
		}else{
			incomePull.reset();
		    incomePull.obj.incomeId = income_Id;
		    incomePull.obj.version = getFormatDay(income.obj.incomeDate,'y');
		    incomePull.saveIncomePullVersion(incomePull.obj,callbak);			
		}



	}
	
	income.reset();
	DWRUtil.getValues(income.obj);
	
	var customerId = customer.customerCommand.getValue();
	customerId = customerId==''|| !isDigit(customerId)?0:customerId;
	
	
			
	income.obj.id = incomeId ==""?null:incomeId;
	//income.obj.customerId = income.obj.customerId;
	income.obj.customerId = customerId;
	income.obj.customer = (new Customer()).obj;
	//income.obj.customer.customerName = $("customerName").value;
	income.obj.customer.customerName = Ext.fly('extCustomer').getValue();
	income.obj.userId =  Ext.getCmp('signUser').getValue();	
	
	income.obj.customer.customerCategoryId = 4;
	income.obj.modifyBy = $("accountId").value;
	income.obj.createBy= Ext.getCmp('signUser').getValue();	
	income.obj.incomeDate = getFormatDay($("incomeDates").value,'ymd');
	income.obj.incomePullDate = getFormatDay($("incomePullDate").value,'ymd');
	income.obj.version = getFormatDay(income.obj.incomeDate,'y');
	income.obj.orgId = $("orgId2").value;
	
	
	if(config_incomeMessageAlertParam == 1){
		income.obj.state = $("sendMsg2User").checked?1:0;
	}
	
  
	
	income.saveIncome(income.obj,func);	
}


function saveIncomePull(incomeId,incomePullId,callBackFun){

	var func = function(){
		$("incomeId").value= incomeId;
		
		if(config_withResourceSort == 0){
				$("hiddenArea").appendChild($("carrierName"));	
		}else{
				$("hiddenAreaa2").appendChild($("resourceTypeName"));
		}

		
		if(tvNameParam=='fztv') $("hiddenUser").appendChild($("createName"));
		if(callBackFun) callBackFun();  

//		if(channelPullParam != 0) getIncomePullTable(incomeId);
		
	}

	
    //单频道,不需要频道划账
	if(channelPullParam == 0){
		incomePull.obj.moneyPull = $("incomeMoney").value;
		incomePull.obj.resourceCarrierId = 0;
		incomePull.obj.resourceTypeId = 0;
	}else{
			
		var trs = incomePull.tBody.getElementsByTagName("tr");
		
		if(moreChannelNoPullParam == 1||trs.length==0){
			incomePull.obj.moneyPull = $("incomeMoney").value;
			incomePull.obj.resourceCarrierId = $("carrierName2").value;
			incomePull.obj.resourceTypeId = 0;
			if(tvNameParam=='fztv') incomePull.obj.createBy = $("createName").value;
		}else{
		        
			if(trs.length>0 ){
				var Btn_saveIncomePull= $("btn_SaveIncomePull");
				if(isUndefined(Btn_saveIncomePull)){
					moneyPull = trs[0].obj.moneyPull;
					if(config_withResourceSort == 0){
						carrierName = trs[0].obj.resourceCarrierId;
					}else{
						resourceType = trs[0].obj.resourceTypeId;
					}
					
					
					
					createBy = trs[0].obj.createBy;
				}else{
					moneyPull = $("moneyPull").value;
					if(config_withResourceSort == 0){
						carrierName = $("carrierName").value;
					}else{
						resourceType = $("resourceTypeName").value;
					}
					createBy = $("createName").value;
				}
			}
		        //alert(carrierName)
			incomePull.obj.moneyPull = moneyPull;
			incomePull.obj.resourceCarrierId = (config_withResourceSort == 0)?carrierName:0;
			incomePull.obj.resourceTypeId = (config_withResourceSort == 1)?resourceType:0;
			if(tvNameParam=='fztv') incomePull.obj.createBy = createBy;
		}
		
	}
	

	DWRUtil.getValues(incomePull.obj);
	incomePull.obj.id = incomePullId==''?null:incomePullId;
	incomePull.obj.incomeId = incomeId;
	incomePull.obj.moneyIn = 0;
//	incomePull.obj.createBy = $("createName").value;
	incomePull.obj.version = getFormatDay($("incomeDates").value,'y');

	//alert(incomePull.obj.version);
	incomePull.saveIncomePull(incomePull.obj,func);	
}


function getMoneyPullSum(incomePullId){
	var trs = incomePull.tBody.getElementsByTagName("tr");
	var moneyPull = 0;
	var sumMoney = 0;
	for(var i = 0;i<trs.length;i++){
		if(incomePullId >0){
			var inpullid = trs[i].obj.id;
			if(inpullid == incomePullId){
				moneyPull=$("moneyPull").value;
			}else{
				if(tvNameParam=='fztv'){
					moneyPull = getCellValue(trs[i],3) == ''?0:getCellValue(trs[i],3)*1;
				}else{
					moneyPull = getCellValue(trs[i],1) == ''?0:getCellValue(trs[i],1)*1;
				}
				
			}
			sumMoney =(sumMoney*100+moneyPull*100)/100;
		}else{
		
		   	if(tvNameParam=='fztv'){
					if(i == trs.length-1 && channelPullParam == 1 && moreChannelNoPullParam !=1){
						moneyPull=$("moneyPull")==null?getCellValue(trs[i],3)*1:$("moneyPull").value*1;
					}else{
						moneyPull = getCellValue(trs[i],3)*1;
					}
			}else{
					if(i == trs.length-1 && channelPullParam == 1 && moreChannelNoPullParam !=1){
						moneyPull=$("moneyPull")==null?getCellValue(trs[i],1)*1:$("moneyPull").value*1;
					}else{
						moneyPull = getCellValue(trs[i],1)*1;
					}
			}    
			sumMoney =(sumMoney*100+moneyPull*100)/100;
		}
	}
	return sumMoney;	
}

function getMoneyInSum(incomePullId){
	var trs = incomePull.tBody.getElementsByTagName("tr");
	var moneyIn = 0;
	var sumMoney = 0;
	for(var i = 0;i<trs.length;i++){
		if(incomePullId >0){
			var inpullid = trs[i].obj.id;
			if(inpullid == incomePullId){
				moneyIn=$("moneyIn").value*1;
			}else{
				if(tvNameParam=='fztv'){
					moneyIn = getCellValue(trs[i],4) == ''?0:getCellValue(trs[i],4)*1;
				}else{
					moneyIn = getCellValue(trs[i],2) == ''?0:getCellValue(trs[i],2)*1;
				}
				
			}
			sumMoney =(sumMoney*100+moneyIn*100)/100;
		}else{
			//if(i == trs.length-1){
				//moneyPull=$("moneyPull").value;
			//}else{
				if(tvNameParam=='fztv'){
					moneyIn = getCellValue(trs[i],4)*1;
				}else{
					moneyIn = getCellValue(trs[i],2)*1;
				}
				
				
			//}
			sumMoney =(sumMoney*100+moneyIn*100)/100;
		}
	}
	return sumMoney;	
}

function deleteIncome(ev){
	    var incomeId = $("incomeId").value;
	    var tr = getElementByEvent(ev);
	   // alert(tr.obj.moneyIn);
	    if(checkMoneyIn()>0){alert("此项到款已分配不能删除!");return false;}
	    var ans = confirm("请确认是否删除这笔到账 ?");
	    if (ans) {
		    var callback = function(){ cancelIncome(); }
			var func = function(){ income.removeIncome(incomeId,callback); }
			incomePull.removeIncomePullByIncomeId(incomeId,func);
	    } else {
	        return false;
	    }
}

function cancelIncome(){
	var urlPara = window.location.href;
	urlPara= urlPara.substring(urlPara.indexOf("&")+1,urlPara.length);
	parent.location.href ="incomes.html?"+urlPara;
    //parent.location.href =document.referrer;
    
    
}
function cannelIncomePull(){

	
	if(config_withResourceSort == 0){
		$("hiddenArea").appendChild($("carrierName"));
	}else{
		$("hiddenAreaa2").appendChild($("resourceTypeName"));
	}	

	if(tvNameParam=='fztv'){
    		$("hiddenUser").appendChild($("createName"));
    }  
	var incomeId = $("incomeId").value;
	getIncomePullTable(incomeId);
}

function button_add_new_obj(type){
		if(type == 0){
			if(moreChannelNoPullParam == 1) return false;
			incomePull.addNewRow('new',null);
		}
}
function checkMoneyIn(){
	var trs = incomePull.tBody.getElementsByTagName("tr");
	var moneyIn = 0;
	for(var i = 0;i<trs.length;i++){
		if(tvNameParam=='fztv'){
			if(getCellValue(trs[i],4)!=0&&getCellValue(trs[i],4)!='') moneyIn ++;	
		}else{
			if(getCellValue(trs[i],2)!=0&&getCellValue(trs[i],2)!='') moneyIn ++;	
		}
		
	}
	return moneyIn;	
}
function resetText(ev){
	 $("customerName").value = null;
	 $("customerId").value = null;
}




function resetHeigth(){
    var dialogcontent = $("dialogcontentDiv");
    var incomePull_div = $("incomePull_div");
    incomePull_div.style.width = dialogcontent.offsetWidth *0.6 +"px";
    incomePull_div.style.height = dialogcontent.offsetHeight * 0.3 +"px";	
    $("incomePullTable").style.width =  incomePull_div.offsetWidth - 20 +"px";
    

    var main_concst = $("main_concst");
//    var value = dialogcontent.offsetHeight * 0.85 +"px";	
    main_concst.style.height = dialogcontent.offsetHeight * 0.85 +"px";	

//    main_concst.setAttribute("height",value);    
    
    
    //$("incomePullTable").style.height = dialogcontent.offsetHeight+"px";
} 

function setCurUserId(){
	var incomeId = $("incomeId").value;
	
	var fnc = function(id){
		
	     $(user.selectName).value = id;
	     user.obj.id = id;
	      $("createName").value =id;
	}

	var curUserName = loginUser;
      
        if(incomeId ==''){
        	user.getCurUserId(curUserName,function(id){fnc(id)});	
        }else{
            // alert(income.obj.userId);
             $(user.selectName).value = income.obj.userId;
	}
	
}

function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}
function setUserPara(obj){
	 obj.className  = "user";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "userId";
}
function setIncomePullPara(obj){
	 obj.className  = "incomePull";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.fillObjName = obj.className + "Body";
	 obj.tBody 		= $(obj.fillObjName);
}
function setIncomePara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className   = "income";	
	 obj.IdPrefix 	 = obj.className + "Id";
	 obj.fillObjName = obj.className + "Body";
	 obj.tableName   = "incomeList";
	 obj.tBody 		 = $(obj.fillObjName);
	 obj.color1 	 = "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 	 = "BACKGROUND-COLOR: #ECEFF4";
}
function setIncomeModePara(obj){
	 obj.className   = "incomeMode";	
	 obj.IdPrefix 	 = obj.className + "Id";
	 obj.selectName =  "incomeModeId";
}
function setIncomePurposePara(obj){
	 obj.className   = "incomePurpose";	
	 obj.IdPrefix 	 = obj.className + "Id";
	 obj.selectName =  "incomePurposeId";
}
function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
}
function setBranchPara(obj){
	 obj.className  = "branch";
	 obj.IdPrefix 	= obj.className + "Id";
     obj.selectName ="branchParentIdRN";
}

function getDate(){
	Calendar.setup({
		inputField  : "incomeDates",	  // id of the input field
//		ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		firstDay:1,
		button	  : "incomeDates"	// id of the button
	});
		Calendar.setup({
		inputField  : "incomePullDate",	  // id of the input field
//		ifFormat	: "%Y%m%d",	  // the date format
		firstDay:1,
		singleClick	  : true,
		button	  : "incomePullDate"	// id of the button
	});
	$("incomeDates").value = getFormatDay(config_serviceDate,'y/m/d'); 
	$("incomePullDate").value = getFormatDay(config_serviceDate,'y/m/d'); 
}



function getCustomerAutoCompltByName(ev){
	var customerName =$("customerName").value;
	customer.obj.customerName = customerName;
	
	if(ev.keyCode == 13){
		customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
		$("customerName").value="";
	}
}




function checkCustomer(){
	
	var dialogcontent = $("dialogcontentDiv");
	var dialogcontentW = dialogcontent.offsetWidth;
	var dialogcontentH = dialogcontent.offsetHeight;
	var winW= dialogcontentW * 0.3;
	var winH = dialogcontentH*0.3;
	var customerName =  Ext.fly('extCustomer').dom.value; 
	var customerId =  Ext.getCmp('extCustomer').getValue();	


//	alert('customerId>>>'+customerId);
//		alert('customerName>>'+customerName);
//	alert('customerId'+$("customerId").value);
//	!isInteger(customerId) && 
	

	if(customerId == customerName && customerId !=''){

			var cut = (new Customer()).obj;
			
			 var closeBtn ={text: '取消',handler: function(){regCustomerWin.hide();}};
			
			 var regBtn ={text: '注册',handler: function(){

			 	    cut.id = null;
			 	     var ort_id =     config_oneOrgMoreSuborgsParam == '1'?orgId:$("orgId2").value;
//			 	    cut.orgId = $("orgId2").value;
			 	     cut.orgId = ort_id;
			 	    
			 	    
			 	    
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
//			 	    	alert(id);
			 	    	inti_set_customer(1,id,cut.customerName,cut.customerCategoryId);
//			 	    	order.obj.customerId = id;
			 	    	$("customerId").value = id;
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


function inti_set_customer(i,id,customerName,customerCategoryId){
	var rc1 = Ext.data.Record.create(customer.fileds);
	

	
    var rc = new rc1({
           id : id,
           customerCategoryId : customerCategoryId,
           customerName:customerName
     });
     
   if(i == 1){
       customer.customerCommand.clearValue(); 
   	   customer.customerCommand.store.add(rc);
   	   customer.customerCommand.setValue(id);  
   }else{
   	   customer.regcustomerCommand.clearValue(); 
   	   customer.regcustomerCommand.store.add(rc);
   	   customer.regcustomerCommand.setValue(id);  
   }
   
	$("customerId").value = id;
//	$("customerCategoryId").value = customerCategoryId;

}
function inti_set_signUser(id,fullName){
	var rc1 = Ext.data.Record.create(user.fileds);
    var rc = new rc1({
           id : id,
           fullName : fullName
     });
      
  
       user.userCommand.clearValue(); 
   	   user.userCommand.store.add(rc);
   	   user.userCommand.setValue(id);  


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
		 inti_set_customer(2,id,customerName,customerCategoryId);
	}

     $("gridbox_regCustomer").style.height =  0 +"px";
    $("gridbox_regCustomer").style.width =  winW*0.98 +"px";


}

function regCustomerComboBox(winW,customerName){

        var mode = 'remote';
        var ort_id =     config_oneOrgMoreSuborgsParam == '1'?orgId:$("orgId2").value;
//        customer.obj.orgId = $("orgId2").value;
    	customer.obj.orgId = ort_id;

        
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
	            
//		customer.regcustomerCommand.on("select",callBack,this);	
//		customer.regcustomerCommand.on("collapse",callBack,this);	

}