
 var matter = new Matter();

 var mygrid;
 var scrollTop = 0;
 var posStart = 0;
 var total_count = 0;
 var fromEditRowId = 0;
 var initparamObj ={};
 var f_int = false;
 var ctxPath;
 var order_check_right;
 var defOrgIds;
 var order_year;
 var loginUserId;
 var loadMarsk;
 var orgId = 1;
 var version = 0;
 var customerId = 0;
 var customerName = '';

 var orderId = 0;
 var adlength = 0;
 

    
callOnLoad(init);	
  
 function init(){
 	
 	ctxPath =  _app_params.ctxPath;	 	
 	
 	config_serviceDate = _app_params.serviceDate.def;
 	
 	userName =  _app_params.user.username;
 	loginUserId =  _app_params.user.id;
 	
 	channelModelParam = _app_params.sysParam.channelModelParam;
 	tvNameParam =  _app_params.sysParam.tvNameParam;
 	withoutSubmit =  _app_params.sysParam.withoutSubmit;
 	useCarrierAliname =  _app_params.sysParam.useCarrierAliname;
 	useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
 	useLanmuSingleParam = _app_params.sysParam.useLanmuSingleParam;
 	
 	order_check_right =  _app_params.rights.tag_orderList_check;
 	tag_orderDetail_save =  _app_params.rights.tag_orderDetail_save;
    tag_orderList_new =  _app_params.rights.tag_orderList_new;
    tag_order_submitbtn =  _app_params.rights.tag_order_submitbtn;
    tag_order_leadmemo =  _app_params.rights.tag_order_leadmemo;
    
    config_adverCodeModelParam = _app_params.sysParam.adverCodeModelParam;
    config_industryLevelParam =  _app_params.sysParam.industryLevelParam;
 	

 	 var srcStr= window.location.href;
 	 
 	 model = getParamFromUrl(srcStr,"model");	
 	      
 	 scrollTop  = getParamFromUrl(srcStr,"scrollTop");	
 	 posStart = getParamFromUrl(srcStr,"posStart");	
     total_count = getParamFromUrl(srcStr,"total_count");	
     orgId = getParamFromUrl(srcStr,"orgId");	
     customerId = getParamFromUrl(srcStr,"customerId");	
     version = getParamFromUrl(srcStr,"version");	
     customerName = getParamFromUrl(srcStr,"customerName");	
     orderCkeckState = getParamFromUrl(srcStr,"orderCkeckState");	
     adLength = getParamFromUrl(srcStr,"adLength");	
     
     
//     orderId = getParamFromUrl(srcStr,"orderId");	
//     adlength = getParamFromUrl(srcStr,"adlength");	
//     alert(adlength);
//     if(adlength>0){
//    	 tb.getComponent('search_adver_len').disabled = true;
//     }


  


//     alert(customerName)
//     if(customerName !='') {
//     	alert(customerName)
//     	parent.search_adver_win.getTopToolbar().getComponent('search_adver_customer').setRawValue(customerName);	
////     	Ext.getCmp('search_adver_customer').setValue(customerName); 
//     }
      
//     customerName = parent.search_adver_win.getTopToolbar().getComponent('search_adver_customer').getRawValue();	
     
	setMatterPara(matter);	
	


 	initGrid();	
 	
 	resetHeigth();
 	
 	
    var tb = parent.search_adver_win.getTopToolbar();
//  alert(orderCkeckState)
    

  
   if(adLength >0){
 	  tb.getComponent('search_adver_len').setRawValue(adLength);
 	  tb.getComponent('search_adver_len').setValue(adLength);
 	  tb.getComponent('search_adver_len').onTriggerClick();
   }
  
  if(orderCkeckState ==1 || orderCkeckState ==3){
 	 tb.getComponent('search_adver_len').setDisabled(true);
  }
 	
// 	var params =  (new Matter()).obj; 
// 	params.customerName = customerName==''?null:customerName;
// 	loadGridData(params);
 	
// 	loadMarsk = new Ext.LoadMask(document.body, {
//	     	msg : '正在加载数据，请稍候。。。。。。',
//	     	removeMask : true// 完成后移除
// 	});

 }
 



 function onRowDblClicked(id,cellInd){
 
	if(customerId == null || customerId == '' || customerId == '0' ){
// 	if(customerId == null || customerId == '' || customerId == '0' || customerName ==''){
 		mygrid.initCustomer = true;
 	}
 	
 	
 	    model = getParamFromUrl( window.location.href,"model");	
     
    	parent.close_search_adver_winWin(1,mygrid,model);

}


 function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = false;
	mygrid.setMultiLine(false);
	mygrid.setImagePath(ctxPath+"image/grid/");

	    
//		var	flds  = "客户名称,广告名称,版本,长度,磁带号,行业,分类,创建时间,用";
		var	flds  = "品牌,广告名称,版本,长度,磁带号,行业,分类,创建时间,用";
	    var	columnIds =  "customer_name,name,edit,length,tape_code,adver_product_brand_id,adver_matter_type,create_date,use_end_date";  
		mygrid.setHeader(flds);
		mygrid.setColumnIds(columnIds);
	    mygrid.setInitWidthsP("17,15,25,7,8,7,7,10,4");
//	    mygrid.setColSorting("str,str,str,str,str,str");
		mygrid.setColAlign("left,left,left,center,center,center,center,center,center");
		mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,img");
//	    mygrid.setColSorting("str,str,str,int,str,str,str,str,str") ;  
		
		
	    
	    
	    
	    
	    
	    
	    
	    
	    
	
	mygrid.setEditable(false);
//	mygrid.setOnScrollHandler(OnScrollHandler);
	mygrid.setSkin("modern2");
	mygrid.enableAlterCss("even","uneven");

	mygrid.enableMultiselect(true); 
//	mygrid.enableLightMouseNavigation(true);  
	mygrid.enableKeyboardSupport(true);  
	mygrid.setOnRowDblClickedHandler(onRowDblClicked,true);
//	mygrid.enableAutoSizeSaving();
//	mygrid.enableSmartRendering(true,100);


	mygrid.init();	
	

}




 function resetHeigth(){
    var winW = parent.search_adver_win.getInnerWidth()-10;   
    var winH = parent.search_adver_win.getInnerHeight()-5;
    var gridbox = $("gridbox");
    gridbox.style.width = winW +"px";	
    gridbox.style.height = winH+"px";  	
    mygrid.setSizes();	
} 




 function getLoadDataParams(i){
	var tb = parent.search_adver_win.getTopToolbar();
	var brandId2 = tb.getComponent('search_brand_cmd').getValue();
    var name = tb.getComponent('search_adver_name').getRawValue();
    var edit = tb.getComponent('search_adver_edit').getRawValue();
    var length = tb.getComponent('search_adver_len').getRawValue();
	var tapeCode =  tb.getComponent('search_adver_tapecode').getRawValue();
	var brandId =  tb.getComponent('search_adver_brandId_cmd').passField.value;
	var industryName =  tb.getComponent('search_adver_brandId_cmd').getValue();
	var industryTreeNodeLevel =  tb.getComponent('search_adver_brandId_cmd').nodeLevel;
	var matterType =   tb.getComponent('search_adver_matterType').getValue();
//	var customer_name =   tb.getComponent('search_adver_customer').getRawValue();
	var initCustomer =false;
    var cutid = customerId;
    var paramObj = {};
	if(i ==1){
			 paramObj = {
					orgId:orgId,
					customerId:cutid,
					brandId2:brandId2,
			        tapeCode:tapeCode,
			        matterType:matterType,
				 	name: name,
		            edit: edit,
		            length:length,
		            brandId:brandId,
		            industryName:industryName,
		            initCustomer:initCustomer,
		            industryTreeNodeLevel:industryTreeNodeLevel
		};	
	}else{
			 paramObj = {
					orgId:orgId,
					brandId2:brandId2,
			        tapeCode:tapeCode,
			        matterType:matterType,
				 	name: name,
		            edit: edit,
		            length:length,
		            brandId:brandId
		};	
	}


	return paramObj;

 }
 
 
function checkTapeCode(params){
	var isBug = false;
	var curtapeCode = params.tapeCode;
//	var cutid = params.customerId;
//	var customer_name = params.customerName;
	var brandId = params.brandId;
	var brandId2 = params.brandId2;
	var length = params.length;
	var name = params.name;
	var matterType = params.matterType;
	var industryTreeNodeLevel = params.industryTreeNodeLevel;
	
	curtapeCode = curtapeCode == ""?null:curtapeCode;

	
	if(matterType ==null || matterType ==0 || matterType ==''){
		extjMessage('新选素材分类!');isBug = true;
	}
	
	if(config_adverCodeModelParam == 0){
		if(curtapeCode ==null || curtapeCode ==0 || curtapeCode ==''){
			extjMessage('新输入磁带号!');isBug = true;
		}	
	}
	
	if(!(length >=0)){
		extjMessage('新输入广告长度!');isBug = true;
	}	
	
	if(name ==null || name ==0 || name ==''){
		extjMessage('新输入广告名称!');isBug = true;
	}	
	
	
	if(config_industryLevelParam == 1){
		if(industryTreeNodeLevel == 1){
			extjMessage('请选择行业类别的子类!');isBug = true;
		}
	}
	
	if(brandId ==null || brandId ==0 || brandId ==''){
		extjMessage('新选择行业类别!');isBug = true;
	}	
	
	if(brandId2 ==null || brandId2 ==0 || brandId2 ==''){
		extjMessage('新选择品牌分类!');isBug = true;
	}	
		
	

    var matterOBJ = (new Matter()).obj;
    matterOBJ.orgId =params.orgId;
    matterOBJ.edit =params.edit;
    matterOBJ.length =params.length;
    matterOBJ.name =params.name;     

	var obj =  matter.getMatterByNameVerLen(matterOBJ);

	if(obj != null){
		obj.tapeCode = obj.tapeCode == ""?null:obj.tapeCode;
		if(curtapeCode != obj.tapeCode && obj.tapeCode != null){
			extjMessage('素材已存在,已存在的磁带号为:['+ obj.tapeCode +']');isBug = true;
		}
	}else{
		if(curtapeCode != null && config_adverCodeModelParam == 0){
			
			var matterObj = (new Matter().obj);	
			matterObj.tapeCode = curtapeCode;
			var object =  matter.getMatterByTapeCode(matterObj);
	
			if(object != null){
				object.tapeCode = object.tapeCode == ""?null:object.tapeCode;
				if(curtapeCode == object.tapeCode){
					extjMessage('输入的磁带号已存在,请重新输入新的磁带号!');isBug = true;
				}
			}
		}
	}
	return isBug;
}

function save_new_matter(){
	var params = getLoadDataParams(1);

	function callBackFun(obj){
		params.id = obj.id;
		params.tapeCode = obj.tapeCode;
		parent.close_search_adver_winWin(2,params);
	}
	
	
	if(!checkTapeCode(params)){
		params.id = null;
		params.enable = true;
		params.createBy = loginUserId;
		params.modifyBy = loginUserId;
		
//		alert(params.brandId)
//		alert(params.brandId2)
		
		Ext.MessageBox.confirm('系统提示', '请确认是否注册此新广告素材？', function(btn) {
 			  if (btn == 'yes') {
 				 matter.saveMatter3(params,callBackFun);
              }
              return false; 	
		 });
		
	}
}

 

 function loadGridData(params){ 
	  var params = getLoadDataParams(2);
//	 alert( params.brandId2)

// 	    var fid = params.tapeCode !=null || params.name !=null || params.edit !=null  || params.length !=null|| params.brandId !=null|| params.matterType !=null|| params.customerName !=null;
 	   var fid = params.tapeCode !=null || params.name !=null || params.edit !=null  || params.length !=null|| params.brandId !=null|| params.matterType !=null|| params.brandId2 !=null;

 	   if(params.brandId2 == 0) params.brandId2 = null;

// 	    alert(fid)
 	    mygrid.clearAll();
 	    if(!fid) return false;
 	    
 	   
        var loadDataURL = ctxPath + "servlet/matterListServlet?" + $H(params).toQueryString();	
		mygrid.enableSmartRendering(true);
//		mygrid.setSortImgState(true,0,"ASC"); 
		mygrid.loadXML(loadDataURL);
		
//		mygrid.setColumnHidden(0,true);
		mygrid.setSizes();	
 }


function resetQueryWhere(){
	var tb = parent.search_adver_win.getTopToolbar();
//	tb.getComponent('search_adver_customer').setValue('');
	tb.getComponent('search_adver_name').setValue('');	
	tb.getComponent('search_adver_edit').setValue('');
	tb.getComponent('search_adver_len').setValue('');		
	tb.getComponent('search_adver_tapecode').setValue('');
	tb.getComponent('search_adver_brandId_cmd').setValue('');		
	tb.getComponent('search_adver_matterType').setValue(1);  
	
	   	


//	var customerCmd = tb.getComponent('search_adver_customer');
//	customerCmd.params.customerName = null;
//	customerCmd.params.name = null;
//	customerCmd.params.edit = null;
//	customerCmd.params.length = null;
//	customerCmd.params.tapeCode = null;
//	customerCmd.params.brandId = 0;
//	customerCmd.params.matterType = 0;
}

function copyQueryWhere(){
	var tb = parent.search_adver_win.getTopToolbar();
 	 
 	var rowId =  mygrid.getSelectedId();
 	
   	   	 if(rowId > 0){
   	   	 	
//   	   	 	var customerCmd = tb.getComponent('search_adver_customer');
//   	   	 	var customerName = mygrid.cells(rowId,0).getValue();
//   	   	 	var customerId = mygrid.getUserData(rowId,"customerId");
//   	   	 	var customerCategoryId = mygrid.getUserData(rowId,"customerCategoryId");
   	   	 	
   	   	 	var name = mygrid.cells(rowId,1).getValue();
   	   	 	var edit = mygrid.cells(rowId,2).getValue();
   	   	 	var length = mygrid.cells(rowId,3).getValue();
   	   	 	var tapeCode = mygrid.cells(rowId,4).getValue();
   	   	 	var brandId = mygrid.getUserData(rowId,"brandId");
   	   	 	var matterType = mygrid.getUserData(rowId,"matterType");
   	   	 	
//   	   	 	parent.inti_set_customer(customerCmd,2,customerId,customerName,customerCategoryId); 
//   	   	  	tb.getComponent('search_adver_name').setValue(name);
   	   	   	tb.getComponent('search_adver_edit').setValue(edit);
   	   	    tb.getComponent('search_adver_len').setValue(length);
   	   	    tb.getComponent('search_adver_tapecode').setValue(tapeCode);
   	   	    
   	   	    var industryCmd = tb.getComponent('search_adver_brandId_cmd');
   	   	    industryCmd.setValue(mygrid.cells(rowId,5).getValue());
	   	    industryCmd.passField.value =  brandId;
          
          
   	   	    tb.getComponent('search_adver_matterType').setValue(matterType); 

//   	   	    customerCmd.params.customerName = customerName;
   	   	    customerCmd.params.name = name;
   	   	    customerCmd.params.edit = edit;
   	   	    customerCmd.params.length = length;
   	   	    customerCmd.params.tapeCode = tapeCode;
   	   	    customerCmd.params.brandId = brandId;
   	   	    customerCmd.params.matterType = matterType;
   	   	    
   	   	 }
}



 
 function setMatterPara(obj){
	 obj.className  = "matter";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "matterId";
}

