var publishArrange = new PublishArrange();

var carrier = new Carrier();
var order = new Order();

var publish_year;

callOnLoad(init);

function init(){
	tvNameParam =  _app_params.sysParam.tvNameParam;

	
	config_serviceDate = _app_params.serviceDate.def;
	config_piblishExportModelParam =  _app_params.sysParam.piblishExportModelParam;
	getDate();
	get_cur_year();
	
	 _make_org_select("orgId",120,"reload_carrier");	
	 
	setCarrierPara(carrier);
	setPublishedInfo(publishArrange);
//	carrier.makeSelect(carrier.obj,"carrierName","");
//	carrier.obj.nodeLevel =1;
	//carrier.obj.nodeLevel =2;
	//carrier.makeSelectItem(carrier.obj,"carrierName","");
	
	init_resourceCarrier();

	
	
//    var carrierSelect = $("carrierName");
//	if(carrierSelect.options.length >-1 )carrierSelect.value = getSelectByIndex(carrierSelect,0,1);
	 
//	publishArrange.makeSelect(publishArrange.obj,"carrierName","");
	
//	$("publisDate").value = curDate;
	
	getPublishArrangeTable();

	buttonEventFill()
}



function reload_carrier(){
	init_resourceCarrier();
	
}

function get_cur_year(){
	publish_year =  _app_params.serviceDate.year;;
	$("publisDate").value =  _app_params.serviceDate.format1;
}

function buttonEventFill(){
	
	var Bt_query = $("query");
	Bt_query.setAttribute("href","javascript:void 0");
	Bt_query.onclick = getPublishArrangeTable;	
	
	
	var Bt_saveFiles = $("saveFiles");
	Bt_saveFiles.setAttribute("href","javascript:void 0");
	Bt_saveFiles.onclick= saveFiles;
	
	
	var Bt_unLockAll = $("unLockAll");
	Bt_unLockAll.setAttribute("href","javascript:void 0");
	Bt_unLockAll.onclick= unLockAll;
	
		
		
	
	var Bt_downlaod = $("downlaod");
	Bt_downlaod.setAttribute("href","javascript:void 0");
	Bt_downlaod.onclick= downLoadFiles;	
	
	var Bt_preView = $("preView");
	Bt_preView.setAttribute("href","javascript:void 0");
	Bt_preView.onclick= formPrintView;
	
	var Bt_print = $("print");
	Bt_print.setAttribute("href","javascript:void 0");
	Bt_print.onclick= formPrint;
	
	var Bt_export = $("export");
	Bt_export.setAttribute("href","javascript:void 0");
	Bt_export.onclick= formExport;	
		
	var change_order_year = $("publisDate");
	change_order_year.onchange = rest_order_year;
	
}



function checkOrderState(resourceIds,dateStr,build_fnc){
	var isStop =false;
	var orgId =  $('orgId').value;
	
	var callback=function(obj){
		if(obj.length>0){
			var dialogcontent = $("dialogcontentDiv");
			var dialogcontentW = dialogcontent.offsetWidth;
			var dialogcontentH = dialogcontent.offsetHeight;
			var winW= dialogcontentW * 0.6;
			var winH = dialogcontentH*0.8;
			var title = "下面列出了今天需要播出但还没有审核的订单:"; 
			var urlStr = "selectPopup/checkForm.html?dateStr="+dateStr+"&resourceIds="+resourceIds+"&orgId="+ orgId;
			var closeBtn ={text: '关闭',handler: function(){win.hide();}};
    
			 var win = new Ext.Window({
			   title : '下面列出了今天需要播出但还没有审核的订单',
			   width : winW,
			   height : winH,
			   isTopContainer : true,
			   modal : true,
			   resizable : false,
			    buttons: [closeBtn],
			   contentEl : Ext.DomHelper.append(document.body, {
			    tag : 'iframe',
			    style : "border 0px none;scrollbar:true",
			    src : urlStr,
			    height : "100%",
			    width : "100%"
			   })
			  })
			  
				win.show(); 					

			if(build_fnc) build_fnc(true);
		}else{
			if(build_fnc) build_fnc(false);
		}
	};
	
	if(resourceIds=="") resourceIds = 0;
	
	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	
	order.getOrderCodeByCheckState1(1,dateStr,resourceIds,callback);	 

}

function init_resourceCarrier(){
	var fuc = function(){
		
	}

    if(tvNameParam =='catv'){
		carrier.obj.version = publish_year;
		carrier.obj.nodeLevel =2;
		carrier.obj.orgId = $("orgId").value;
		carrier.makeSelectItem(carrier.obj,"carrierName",""); 	
		
    }else{
		carrier.obj.version = publish_year;
		carrier.obj.nodeLevel =1;
		carrier.obj.orgId = $("orgId").value;
		carrier.makeSelectItem(carrier.obj,"carrierName","");    	
    }


	
	//carrier.obj.enable = true;
	//carrier.obj.version = publish_year;
	//carrier.makeSelectFromMap2(carrier.obj,$("carrierName"),fuc,"");		
}

function rest_order_year(){
	var publish_year_new = $("publisDate").value;
	publish_year_new = publish_year_new.substring(0,4);
	if(publish_year_new != publish_year){
		publish_year = publish_year_new;
		init_resourceCarrier();
	}
	
}

function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}

function setPublishedInfo(obj){
	 obj.className  = "publishArrange";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.enableDel	= true;
	 obj.fillObjName = obj.className + "Body";
	 obj.tableName   = obj.className + "Table";
	 obj.tBody 		 = $(obj.fillObjName);
	 obj.color1 		= "BACKGROUND-COLOR: #white";
	 obj.color2 		= "BACKGROUND-COLOR: #eee";
	 
	 obj.selectName = obj.className +"RN";
	 
	 obj.pageInfo 	= obj.className +"PageInfo";
	 obj.pageSize 	= "16";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}


function getDate(){
	Calendar.setup({
		inputField  : "publisDate",	  // id of the input field
//		ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "publisDate"	// id of the button
	});


}

function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == publishArrange.pageInfo){
		var page = new Page(publishArrange.pageInfo,publishArrange.pageSize);
		page.goNextPage(pageIndex);
		publishArrange.page = page;
		getPublishArrangeTable();
	}
}

function getPublishArrangeTable(){
	publishArrange.reset();
	publishArrange.obj.publishDate = getFormatDay($("publisDate").value,'ymd');
	//publishArrange.obj.publishDate = (getFormatDay($("publisDate").value,'ymd'))==""?null:$(getFormatDay($("publisDate").value,'ymd'));
//	publishArrange.obj.carrierName = $("carrierName").value==""||$("carrierName").value=="0"?null:$("carrierName").value;
//alert($("carrierName").value);
//	$("carrierName").selectedIndex==2||$("carrierName").selectedIndex==3){
	
	if(tvNameParam == 'catv'){
		if(getSelectParamFromText($("carrierName"),"||",2)=="白天"||getSelectParamFromText($("carrierName"),"||",2)=="晚间"){
//			alert("请选择电影频道，次项为打印时选用！");
			extjMessage('请选择电影频道，次项为打印时选用！');
			return false;
		}	
	}

	
	 
	publishArrange.obj.carrierId = $("carrierName").value;
	publishArrange.obj.isArranged = true;  
	var callBackFun=function(objs){
		publishArrange.fillTalbe(objs);
	}
	publishArrange.getPublishArrangesPage(publishArrange,callBackFun);
}
function deleteArrange(deleImg){  
	var arrangeId = deleImg.getAttribute("paraId");
	//alert(arrangeId);
	var func = function(){
		getPublishArrangeTable();
		
	}
	if(!confirmDelete(publishArrange.className)) return false;
	publishArrange.deletePublishArrange(arrangeId,func);
	
	
}

function setLockState(e){
	var callBackFun=function(obj){
		obj.isLocked = e.checked;
		publishArrange.savePublishArrangeLock(obj);
	}
	publishArrange.obj.id = e.value;

	publishArrange.getPublishArrange(publishArrange.obj.id,callBackFun);
}
	
function unLockAll(){
	
	
    var carrierId = $("carrierName").value;
    var publishDate = getFormatDay($("publisDate").value,'ymd')
    var func = function(){
		var parnetObjName = publishArrange.tableName;
			var mode = false;
			var i = [];
			var j = 0;
			var inputs = $(parnetObjName).getElementsByTagName("input");
			inputs = $A(inputs);
			inputs.each(function(ip){ip.checked  = mode;});	
			Ext.getBody().unmask();
	}  
    if(carrierId > 0 && publishDate >0){
    	publishArrange.saveAllLock(carrierId,publishDate,false,func);
    }else{
    	alert('请选择频道')
    }


    

}
function saveFiles(){
			
	    var carrierId = $("carrierName").value;
	    var publishDate = getFormatDay($("publisDate").value,'ymd')
	    var isLock = 1;
	    
	    $("downlaod").hide();
	    
	    var type = config_piblishExportModelParam;
	    
//        alert(type);
	    
	    
		
		
	    
	    
	    //福州电视台只需要频道级别的数据！所以可以不用求出各个resourceIds,从而提高速度！
	    if(type == 3){

			function  downloadAdversFun(isStop){

				if(isStop){
					Ext.getBody().unmask();
					return false;
				}
				
		    	var saveFuc = function(state){

		    		if(state == 1){
		    			 Ext.getBody().unmask();
						 throw "FTP 服务器连接失败,无法自动锁定";
						 return false;
					}
		    		
		    		
					$("downlaod").show();
					
					var func = function(){
						var parnetObjName = publishArrange.tableName;
							var mode = true
							var i = [];
							var j = 0;
							var inputs = $(parnetObjName).getElementsByTagName("input");
							inputs = $A(inputs);
							inputs.each(function(ip){ip.checked  = mode;});	
							Ext.getBody().unmask();
					}  
					if(state == 0){
						publishArrange.saveAllLock(carrierId,publishDate,true,func);
					}
				}
		    	
				publishArrange.reset();
				publishArrange.obj.publishDate = publishDate;
				publishArrange.obj.resourceIds = [];
				publishArrange.obj.carrierName = $("carrierName").options[$("carrierName").selectedIndex].text;
				publishArrange.obj.carrierId=$("carrierName").value;  
				
				try
				  {
					publishArrange.downloadAdvers(publishArrange.obj,type,saveFuc);	

				  }
				catch(err)
				  {
				     alert(err)
				  }
							
			}	    	

	    	
	    	function callBackFun(objs){
	    		var resArray= new Array();
	    		var carriers= new Array();
	    		var carrierNames = getArrayFromObjs(objs,"carrierId","carrierName",carrierId);

	    		for(var i = 0; i<carrierNames.length; i++){
					if(carriers.indexOf(carrierNames[i]) == -1) carriers.push(carrierNames[i]);
				} 	
	    		for(var i = 0; i<carriers.length; i++){
	    			var resIds = getArrayFromObjs(objs,"carrierName","resourceId",carriers[i]); 
	    			resArray = resArray.concat(resIds);  
	    		}
	    		checkOrderState(resArray,publishDate,downloadAdversFun);
	    	}
	    	
	    	
	    	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	    	
			publishArrange.reset();
			publishArrange.obj.carrierId = carrierId;
			publishArrange.obj.publishDate = publishDate;
			publishArrange.getPublishArranges(publishArrange.obj,callBackFun);	
	    	

			
	    }else{
	    	
			function callBackFun(objs){
				var carriers= new Array();
				var carrierNames = getArrayFromObjs(objs,"carrierId","carrierName",carrierId);

	
				for(var i = 0; i<carrierNames.length; i++){
					if(carriers.indexOf(carrierNames[i]) == -1) carriers.push(carrierNames[i]);
				} 	

				for(var i = 0; i < carriers.length; i++){
					var isLast = (i== carriers.length-1)?true:false;
					saveFile(carriers[i],publishDate,type,isLast);
				} 	
				var func = function(){
					var parnetObjName = publishArrange.tableName;
						
						var mode = true
						var i = [];
						var j = 0;
						var inputs = $(parnetObjName).getElementsByTagName("input");
					
						inputs = $A(inputs);
					
						inputs.each(function(ip){
								ip.checked  = mode;
							}
						);	
						
						Ext.getBody().unmask();
				}
					publishArrange.saveAllLock(carrierId,publishDate,func);
			}
			
			publishArrange.reset();
			publishArrange.obj.carrierId = carrierId;
			publishArrange.obj.publishDate = publishDate;
			publishArrange.getPublishArranges(publishArrange.obj,callBackFun);	
		
	    }
}	


function saveFile(carrierName,publishDate,type,isLast){
		function callBackFun(objs){
			var resIds = getArrayFromObjs(objs,"carrierName","resourceId",carrierName);
			var saveFuc = function(){
				//alert(isLast);
				if(isLast) $("downlaod").show();
			}
			 
			publishArrange.reset();
			publishArrange.obj.publishDate = publishDate;
			publishArrange.obj.resourceIds = resIds;
			publishArrange.obj.carrierName = carrierName;
			publishArrange.obj.carrierId=$("carrierName").value;
			publishArrange.downloadAdvers(publishArrange.obj,type,saveFuc);		
		}
		
		publishArrange.reset();
		publishArrange.obj.carrierName = carrierName;
		publishArrange.obj.publishDate = publishDate;
		
		Ext.getBody().mask('数据加载中……', 'x-mask-loading');
		publishArrange.getPublishArranges(publishArrange.obj,callBackFun);
}	

function downLoadFiles(carr){
//	if(tvNameParam =='fztv'){
//		var publishDate = getFormatDay($("publisDate").value,'ymd');     
////		var server = "172.17.6.99";  
////		var server = "127.0.0.1";  
////		var port ="21";
////		var user = "linux";
////		var pass = "linux";
//		var server = "172.16.1.249";  
//		var port ="21";
//		var user = "new";
//		var pass = "123456";
//		
//		var callback = function(){ 
////			alert("上传完毕!");
//				extjMessage('上传完毕！');
//		}
//	
//		publishArrange.uploadFiles(server,port,user,pass,publishDate,callback);  
//	}else{
//		var base = $("downloadurl").value;
//		var fileName = getFormatDay($("publisDate").value,'ymd') +".zip";
//	    window.location.href=base + "/"+ fileName;
//	}

	var base = $("downloadurl").value;
	var fileName = getFormatDay($("publisDate").value,'ymd') +".zip";
    window.location.href=base + "/"+ fileName;
	
}	

function formPrintView(){
	var carrierSelect = $(carrier.selectName).value;
	$("carrierId").value = carrierSelect;
	var carrierId = $("carrierId").value;
	var publisDate =getFormatDay($("publisDate").value,'ymd');
//	alert(carrierId+"   "+publisDate);
	formPrintViews(publisDate,carrierId);
//	alert("   zxczxczc   ");
}	

function formPrint(){
	var carrierSelect = $(carrier.selectName).value;
	$("carrierId").value = carrierSelect;
	var carrierId = $("carrierId").value;
	var publisDate = getFormatDay($("publisDate").value,'ymd');
//	alert(carrierId+"   "+publisDate);
	formPrints(publisDate,carrierId);
}
function formExport(){
	var carrierSelect = $(carrier.selectName).value;
	$("carrierId").value = carrierSelect;
	var carrierId = $("carrierId").value;
	var publisDate = getFormatDay($("publisDate").value,'ymd');
//	alert(carrierId+"   "+publisDate);
	formExports(publisDate,carrierId);
}


function formPrintViews(publisDate,carrierId)
{
//	 alert("formPrintView");
	 $("model").value = "view";
	 $("publishDate").value = publisDate;
	 $("carrierId").value =  carrierId;
	 $("dayOrNeit").value = getSelectParamFromText($("carrierName"),"||",2);
	 $("orgIdForm").value =   $("orgId").value;
	 
//alert($("dayOrNeit").value);
	var tarForm =  $("tarForm");
	var ReportForm = $("ReportForm");

	//$("carrierName").value=1;
	ReportForm.target = tarForm;
	ReportForm.action="reports/jsp/form_print.jsp";
	ReportForm.submit(); 	
}

function formPrints(publisDate,carrierId){
//	 alert("formPrint");
	 $("model").value = "print";
	 $("publishDate").value = publisDate;
	 $("carrierId").value =  carrierId;
	 $("orgIdForm").value =   $("orgId").value;

	var tarForm =  $("tarForm");
	var ReportForm = $("ReportForm");


	ReportForm.target = tarForm;
	ReportForm.action="reports/jsp/form_print.jsp";
	ReportForm.submit(); 	
}

function formExports(publisDate,carrierId){
//	alert("formExport");
    $("model").value = "export";
	$("publishDate").value = publisDate;
	$("carrierId").value =  carrierId;
	$("orgIdForm").value =   $("orgId").value;

	var tarForm =  $("tarForm");
	var ReportForm = $("ReportForm");


	ReportForm.target = tarForm;
	ReportForm.action="reports/jsp/form_print.jsp";
	ReportForm.submit(); 	
}

