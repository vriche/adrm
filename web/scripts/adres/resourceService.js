
var carrierType = new CarrierType();
var resource = new Resource();
var resourceType = new ResourceType();
var resourceSort = new ResourceSort();

var carrier = new Carrier(); 
var workspan = new Workspan();
var date = new Date();
var myDate = new MyDate();
var price = new Price();
var priceDetail = new PriceDetail();
var resourceLimit = new ResourceLimit();
var org = new SysOrg();
var media = new MediaOrg();
var channel = new ResourceChannel();
var myprint =new MyPrint();
var priceType = new PriceType();

var config_resourceDisplayParam;
var config_resourceReLimitParam;
var resource_year;
var config_serviceDate;
var ctxPath;
var mygrid;

callOnLoad(init);

function init(){

	tvNameParam =  _app_params.sysParam.tvNameParam;
	ctxPath =  _app_params.ctxPath;	 

	config_signCompages = _app_params.sysParam.signCompages; //是否启用套装参数(启用1,不启用0)系统参数默认是0;
	config_withBroPoint = _app_params.sysParam.withBroPoint; //是否启用播出入点(启用1,不启用0)系统参数默认是0;
	config_withResourceSort = _app_params.sysParam.withResourceSort;//是否启用播出入点(启用1,不启用0)系统参数默认是0;
	config_resourceDisplayParam = _app_params.sysParam.resourceDisplayParam;
	config_resourceReLimitParam = _app_params.sysParam.resourceReLimitParam;
	config_useCarrierAliname = _app_params.sysParam.useCarrierAliname;
	config_useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
	config_serviceDate = _app_params.serviceDate.def;
	config_autoPriceTypeParam =  _app_params.sysParam.autoPriceTypeParam;
	config_useLanmuSingleParam= _app_params.sysParam.useLanmuSingleParam;
	config_moreChannelParam = _app_params.sysParam.moreChannelParam;
	

	
	winHeight = self.innerHeight*0.93; 
	winWidth  = self.innerWidth*0.98;
	setCarrierTypePara(carrierType);
	setResourcePara(resource);
	setCarrierPara(carrier);
	setWorkspanPara(workspan);
	setPricePara(price);
	setPriceDetailPara(priceDetail);
	setResourceLimitPara(resourceLimit);
	
	
	_make_adrm_sys_year_select("resource_year",_app_params.serviceDate.adrmSysYear);
	
	_make_adrm_sys_year_select("resource_price_year",_app_params.serviceDate.adrmSysYear);
	
	

	get_cur_year();
	
    _make_org_select("orgId",120,"getResourceTree");	
	 
	//alert($("resource_year").value);	
//	initResourceTree();
	
//	org.makeSelect(org.obj,"orgId","getResourceTree",callBackFun);	
	
	 
//	priceType.makeSelectFromMap(priceType.obj,"resourcePriceType","145","onResourceChange",function(){
//		if(config_autoPriceTypeParam > 0){
//			$("resourcePriceType").value = config_autoPriceTypeParam;
//		}else{
//			$("resourcePriceType").value = 1;
//		}
//
//	});
	
	
//	function callBackFun(){
		    initResourceTree();
		    
			buttonEventFill(); 
			
			media.obj.orgId = $('orgId').value;
			media.makeSelectItemAnalyze(media.obj,"mediaOrgId","");
				
			resourceType.obj.orgId = $('orgId').value;
			resourceType.obj.version = resource_year;
			resourceType.makeSelectItemAnalyze2(resourceType.obj,"resourceType","",100,0);
			
			
			resourceSort.makeSelectFromMap5("resourceSortId",50,"",function(){});
			
//			channel.obj.orgId = $('orgId').value;
//			channel.makeSelectItemAnalyze(channel.obj,"channelId","");
			
//				$('orgId_td').hide();
//			if(config_useMoreCarrierSortParam == 0|| $('orgId').options.length<2){
//				$('orgId_td').hide();
//			}
			
			
	
			$('td4').hide();
			$('td3').hide();
			
			if(config_moreChannelParam == '0'){
				$("carrier_displayMode").hide();
			}		
			
			
			
			if(config_withResourceSort==1){
		//		$('td1').hide();
		//		$('td2').hide();
				$('other').hide();
				 initResourceType();

			}else{
		//		$('td3').hide();
		//		$('td4').hide();
				$('fztv').hide();  

				$('resourceTypeName').hide();
				$('btn_config').hide();
			}
			
			if(config_signCompages ==1){
				$('resourceCompages').style.display = 'block';
				$('radiobutton1').defaultChecked= true;
			
			}
			
			
			if(config_useLanmuSingleParam !=1){
				$('mediaOrgId').disabled = true;
			}
	
			resetHeigth();
			
		//	price.obj.version =$("resource_year").value;
		//	price.makeSelectItemAnalyze(price.obj,"priceName",'');
//			getPriceNameByYear();	
//	}

	  	this.myprint.buildButtons(this,"printReportDiv",[0,1,2],80);
	
	    initGridWorkSpan();
	
}





function doOnCellEdit(stat,rowId,col){

     var isNewRow = false;
	 if((rowId+'').indexOf("new_")== 0){isNewRow = true}
	 
//	 alert(stat)
	             
    if(stat == 2){
    	if(col >1 && col< 12){
	    	var myCell = mygrid.cells(rowId,col);
	    	var totalTime = myCell.getValue();
	    	var isNum = isDigit(totalTime);
	    	if(isNum){
			   if(col == 5 && isNewRow){
					for(var j =col;j<col+7;j++){
						mygrid.cells(rowId,j).setValue(totalTime);
					}
				}		
	    	}else{
	    		myCell.setValue('');
	    	}
    	 }

    }

	return true;
	
}

function initGridWorkSpan(){ 
	
	mygrid = new dhtmlXGridObject('gridbox');

	mygrid.setImagePath(ctxPath+"image/grid/");
	
	var save_btn = "<img onclick='grid_wspand_save()' src='"+ ctxPath +"image/save.png' width='20' heigth='20' alt='保存'/>";

	var flds = "开始日期,结束日期,播出入点,#cspan,#cspan,星期一,星期二,星期三,星期四,星期五,星期六,星期日,属性,播出描述,"+ save_btn;
	var columnIds = "start,end,brotime1,brotime2,brotime3,mon,tu,wen,for,fri,sat,sun,type,desc,oper";
//	var columnIds = "start,end,brotime1,brotime2,brotime3,mon,tu,wen,for,fri,sat,sun,desc,oper";
	
	mygrid.setColumnIds(columnIds);
//	mygrid.enableHeaderImages(true);
//	mygrid.setHeader("column_b.asc.gif,,,,,,,,,,,");
	mygrid.setHeader(flds);
	
	mygrid.setInitWidthsP("11,11,5,5,5,5,5,5,5,5,5,5,7,16,5");
//    mygrid.setInitWidthsP("11,11,5,5,5,5,5,5,5,5,5,5,23,5");
	mygrid.setColAlign("center,center,center,center,center,center,center,center,center,center,center,center,center,left,center");
	
//	mygrid.setColAlign("center,center,center,center,center,center,center,center,center,center,center,center,left,center");
//	mygrid.setColTypes("ed,ed,calendar,ed,ed");
//	mygrid.setColTypes("calendar,calendar,coro,coro,coro,ed,ed,ed,ed,ed,ed,ed,coro,ed,img");
	mygrid.setColTypes("calendar,calendar,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,coro,ed,img");
//	mygrid.setColTypes("calendar,calendar,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,img");
//	mygrid.setEditable(true);
	mygrid.selMultiRows = true;
	mygrid.enableMathEditing(true); 
	mygrid.enableAlterCss("even","uneven");
	mygrid.setOnEditCellHandler(doOnCellEdit);
//	mygrid.setOnEnterPressedHandler(doOnCellEdit);
	
	
//	mygrid.enableTooltips("true,true,true,true,true,true")
	
//	mygrid.dhtmlxEvent("onMouseOver",function(el,event,handler){
//		alert(el);alert(event);alert(handler);
//	});
	
	
//	mygrid.attachEvent("onMouseOver", function(id,ind)
//	{
//	    if (ind == 0)
//	        this.cells(id,ind).cell.title = 'Hello world';
//	});

	mygrid.init();	
	

	
	mygrid.setSkin("modern2");
	
// 	mygrid.attachHeader(["#rspan","#rspan","时","分","秒","#rspan","#rspan","#rspan","#rspan","#rspan","#rspan","#rspan","#rspan","<img onclick='grid_wspand_add()' src='"+ ctxPath +"image/CRM_ADD.GIF' alt='新添'>"]);
 mygrid.attachHeader(["#rspan","#rspan","时","分","秒","#rspan","#rspan","#rspan","#rspan","#rspan","#rspan","#rspan","#rspan","#rspan","<img onclick='grid_wspand_add()' src='"+ ctxPath +"image/CRM_ADD.GIF' alt='新添'>"]);
 

//     document.getElementById("wokspan_add_img").appendChild(document.getElementById("pulldate_flt_box").childNodes[0]);
	
 
   mygrid.setSizes();
   

//    var command= mygrid.getCombo(2);
//    for(var i = 1 ;i<25;i++){
//    		command.put(i,i);
//    }
//    
//    var command2= mygrid.getCombo(3);
//    for(var i = 1 ;i<61;i++){
//    		command2.put(i,i);
//    }
//    
//    var command3= mygrid.getCombo(4);
//    for(var i = 1 ;i<61;i++){
//    		command3.put(i,i);
//    }
	

	var command4 = mygrid.getCombo(12);
	function func(objs){
		for(var i = 0;i<objs.length;i++){
			var obj = objs[i];
			command4.put(obj.id,obj.name);			
		}
	}
	resourceSort.getResourceSorts(func);
}
 


function _2dg(val){
		 if(val.toString().length==1)
		 return("0"+val.toString());
		 return val;
}

function grid_wspand_add(){
	var rowCount = mygrid.getRowsNum();
	var to_row_id = "new_" + (new Date()).valueOf();
//	var frRow = mygrid.getRowByIndex(mygrid.getRowsNum()-1);
//	alert(mygrid.getRowsNum());
    if(rowCount >0 ){
    	
    	var from_row_id = mygrid.getRowId(rowCount-1);
    	
    	var end = mygrid.cells(from_row_id,1).getValue();
//    	end = end.replace(/-/g,"/");  
    	
//    	alert(end)

        var   z;
        var preStartDateStr;
        
    	if((end+'').indexOf("/") == -1){
    		z   =   DateAdd( "d ",+1,end);
     		preStartDateStr = ("y/m/d").replace("m",_2dg((z.getMonth()*1+1))).replace("d",_2dg(z.getDate())).replace("y",_2dg((z.getFullYear()*1))); 	
    	}else{
	  		var  newDateStart=  new   Date(Date.parse(end.replace(/-/g,   "/")));    
		    z   =   DateAdd( "d ",+1,newDateStart);
		    preStartDateStr = ("y/m/d").replace("m",_2dg((z.getMonth()*1+1))).replace("d",_2dg(z.getDate())).replace("y",_2dg((z.getFullYear()*1))); 	
    	}

    	
    	if(getFormatDay(end,'ymd')*1 == (resource_year+'1231')*1){
    		alert('结束时间已是最后天，无法添加');
    		return false;
    	}
    
    	
    	mygrid.addRow(to_row_id,[],rowCount);
//    	var newRow = mygrid.getRowByIndex(rowCount);
    	mygrid.copyRowContent(from_row_id,to_row_id);
//    	mygrid.setRowId(rowCount,to_row_id);
	    mygrid.cells(to_row_id,0).setValue(preStartDateStr);
    	mygrid.cells(to_row_id,1).setValue(getFormatDay(resource_year+'1231','y/m/d'));
    	
    	var memo = $("resourceName").value;
    	mygrid.cells(to_row_id,13).setValue(memo);
    	
    }else{
    	
    	var startDate =  getFormatDay(resource_year+'0101','y/m/d');
    	var endDate =  getFormatDay(resource_year+'1231','y/m/d');
//    	var memo =  $("resourceName").value + $("memo").value; 
    	var memo =  $("resourceName").value ;  
    	var delImg = ctxPath+"image/button_delete.gif^删除^javascript:_remove_work_span();^_self";
    	mygrid.addRow(to_row_id,[startDate,endDate,'','','','','','','','','','','',memo,delImg],rowCount);
    }
}

function checkEndTime(){

	var rowNum =  mygrid.getRowsNum();

	var lastDate;
	
	for(var i=0;i<rowNum;i++){
		
		var rowId = mygrid.getRowId(i);           
		var startTime= getFormatDay(mygrid.cells(rowId,0).getValue(),'ymd')*1;
		var endTime = getFormatDay(mygrid.cells(rowId,1).getValue(),'ymd')*1;

	    //当前行
		if(endTime < startTime){
			extjMessage('开始日期不能大于结束日期!');
	  		return false
	  	}
	  	
	  	//与上一行结束日期比对
	  	if(i>0){
			if(startTime <= lastDate){
  				 extjMessage("开始日期必须大于第[" + i+ " ]行的结束日期");
  				 return false
  		    }    	
	  	}

	  	lastDate = endTime;
	}

  	return true;

}


function grid_wspand_save(callBakFun){
	
	    
	
	if (!checkEndTime())return false;
	
	var rowCount= mygrid.getRowsNum();

	function func(){
		
		loadWorkSpances($("resourceId").value);
		
		if(callBakFun) callBakFun();
	}	
	

	
	for(var i=0;i< rowCount;i++){
		
                 var rowId = mygrid.getRowId(i);
                 
                 var id = rowId;
                 
	        	 DWRUtil.getValues(workspan.obj);

	        	 var id_temp = id+'';
	             if(id_temp.indexOf("new_")== 0){
	             	id = null;	
	             }
               
               
	             
	        	workspan.obj.id = id;
	        	workspan.obj.version = resource_year; 
	        	workspan.obj.beginDate = getFormatDay(mygrid.cells(rowId,0).getValue(),'ymd')*1;
	        	workspan.obj.endDate = getFormatDay(mygrid.cells(rowId,1).getValue(),'ymd')*1;
	        	workspan.obj.broadcastStartTh = mygrid.cells(rowId,2).getValue();
	        	workspan.obj.broadcastStartTm = mygrid.cells(rowId,3).getValue();
	        	workspan.obj.broadcastStartTs = mygrid.cells(rowId,4).getValue();
	        	workspan.obj.monLength = mygrid.cells(rowId,5).getValue();
	        	workspan.obj.tueLength = mygrid.cells(rowId,6).getValue();
	        	workspan.obj.wenLength = mygrid.cells(rowId,7).getValue();
	        	workspan.obj.thiLength = mygrid.cells(rowId,8).getValue();
	        	workspan.obj.friLength = mygrid.cells(rowId,9).getValue();
	        	workspan.obj.satLength = mygrid.cells(rowId,10).getValue();
	        	workspan.obj.sunLength = mygrid.cells(rowId,11).getValue();
	        	workspan.obj.resourceType = mygrid.cells(rowId,12).getValue();
//				workspan.obj.resourceType = 0;
				
				 if(id_temp.indexOf("new_")== 0 || i < rowCount-1){
	             	workspan.obj.memo = mygrid.cells(rowId,13).getValue();
				}else{
//	             	var memo =  $("resourceName").value + $("memo").value;  
	             	var memo = $("resourceName").value;
//	             	if(tvNameParam =='hntv'){
//	             		 memo =  $("resourceName").value;
//	             	}
	             	workspan.obj.memo = memo !=''?memo:mygrid.cells(rowId,13).getValue();
	             }
	             
	        	
	        	
	        	
				if(config_withBroPoint != 1){
					 workspan.obj.broadcastEndTime = $("broadcastStartTime").value;
					 workspan.obj.broadcastStartTime = 0;
				}
				
//				console.log(workspan.obj);
                
                function callbak(){
                	
//                	if(rowCount == i){
  
                		 func();
                		 Ext.MessageBox.alert('系统提示', '保存完毕', function(btn) {});
//                	}
                	
                }
                
//                var wasChanged = false;
//                for(var j = 0;j< 14;j++){
//                	  if(!wasChanged) wasChanged =mygrid.cells(rowId,j).wasChanged();
//                }
				
		
//				if(wasChanged || id == null){
                    if(rowCount == i+1){
                    	workspan.saveWorkspan(workspan.obj,callbak);
                    }else{
                    	workspan.saveWorkspan(workspan.obj,function(){});
                    }
					
//				}	
				
	}	
	
					
			
				
				
}

function _remove_work_span(){
	
	            var id = mygrid.getSelectedId();
	            
	    		Ext.MessageBox.confirm('系统提示', '请确认是否删除这条记录？', function(btn) {
	    		 
	 			  if (btn == 'yes') {
	// 				 remove_orderDetail_fun(id);
	                 var id_temp = id+'';
	                 if(id_temp.indexOf("new_")==-1){
	                 	 workspan.remove_workspan(id,function(){mygrid.deleteRow(id);});
	                 }else{
	                 	mygrid.deleteRow(id);
	                 }
	              }
	              return false; 	
				 });  	
}

//function createTables(s){
//	
//	   mygrid.loadXMLString(createTables(s));
//  var sb;
//  
//  			sb = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
//			sb = sb + "<rows>";  
//			sb = sb + "<row  id=\""+ matterId +"\"" +">";
//	
//			sb = sb + "<cell><![CDATA["+ 1   +"]]></cell>";
////			sb = sb + "<cell><![CDATA["+ decodeURI(name)    +"]]></cell>";
//			sb = sb + "<cell><![CDATA["+ decodeURI(edit)   +"]]></cell>";
//			sb = sb + "<cell><![CDATA["+ length   +"]]></cell>";
//			sb = sb + "<cell><![CDATA["+ getFormatDay(start,"y/m/d")  +"]]></cell>";
//			sb = sb + "<cell><![CDATA["+ getFormatDay(end,"y/m/d")   +"]]></cell>";
//			sb = sb + "<cell><![CDATA["+ num   +"]]></cell>";
//			sb = sb + "</row>";		
//		    sb = sb + "</rows>";  					
//							
// return sb; 	
//}
//function onOrgChange(){
//	
//	initResourceType();
//	
//	getResourceTree();
//
//}


function initResourceType(){
	
	if(config_withResourceSort==1){
		
		resourceType.obj.orgId = $('orgId').value;
		resourceType.obj.version = $('resource_year').value;
		resourceType.makeSelectItemAnalyze2(resourceType.obj,"resourceType","",105,0);
				
		resourceType.obj.orgId = $('orgId').value;
		resourceType.obj.version = $('resource_year').value;
		resourceType.makeSelectItemAnalyze2(resourceType.obj,"resourceTypeName","reLoadTree",80,1);

	}else{
					$('resourceType').hide();
			$('resourceTypeName').hide();
	}
	
	
	

}

function getPriceNameByYear(){
	
	price.obj.version =$("resource_price_year").value;
	
	
	price.obj.orgId = $("orgId").value;
//	price.makeSelectItemAnalyze(price.obj,"priceName",'');
	price.getPricesForImport(price.obj,"priceName",'');
}

function getCarrierTypeTree(){

}
function get_cur_year(){
	config_serviceDate = config_serviceDate;
	var yyyy = getDayPar(config_serviceDate,'y');
	setSelectByValue($("resource_year"),yyyy);
	resource_year = $("resource_year").value;
	
	$("resource_price_year").value = resource_year; 
}

function buttonEventFill(){
	//保存载体
	var Bt_saveCarrierInfo = $("Bt_saveCarrierInfo");
	Bt_saveCarrierInfo.onclick=button_saveCarrier;
	//删除载体
	var Bt_removeCarrierInfo = $("Bt_removeCarrierInfo");
	Bt_removeCarrierInfo.onclick=button_removeCarrier;
	//载体增加子级
	var Bt_addCarrierChild = $("Bt_addCarrierChild");
	Bt_addCarrierChild.setAttribute("href","javascript:void 0");
	Bt_addCarrierChild.onclick=button_addCarrierChild;
	
	//资源增加子级
	var Bt_addResourceChild = $("Bt_addResourceChild");
	Bt_addResourceChild.setAttribute("href","javascript:void 0");
	Bt_addResourceChild.onclick=button_addResourceChild;	
	//删除资源
	var Bt_removeResource = $("Bt_removeResource");
	Bt_removeResource.onclick=button_removeResource;
	//保存资源
	var Bt_saveResource = $("Bt_saveResource");
	Bt_saveResource.onclick=button_saveResource;
	//价格导入
	var Bt_importPrice = $("Bt_importPrice");
	Bt_importPrice.onclick=display_importPrice;
	
	var btn_closePrice = $("btn_closePrice");
	btn_closePrice.onclick=close_importPrice;
	
	//价格导入确认
	var btn_importPrice = $("btn_importPrice");
	btn_importPrice.onclick=button_importPrice;
	
	var btn_resource_price_year = $("resource_price_year");
	btn_resource_price_year.onchange=getPriceNameByYear;
	
	
	
	//判断资源
	var change_resourceType = $("resourcePriceType");
	change_resourceType.onchange=selectResourceType;
	//建立串联单
	var Bn_isBuildLevel = $("isBuildLevel");
	Bn_isBuildLevel.onclick = isBuildLevel;
	
//	var Btn_view_resource = $("Btn_view_resource");
//	Btn_view_resource.onclick = button_view_resource;
//
//	var Btn_print_resource = $("Btn_print_resource");
//	Btn_print_resource.onclick = button_print_resource;	
//	
//	var Btn_export_resource = $("Btn_export_resource");
//	Btn_export_resource.onclick = button_print_export;	
	
	var change_resource_year = $("resource_year");
	change_resource_year.onchange = rest_resource_tree;
	
	var carrier_displayMode = $("carrier_displayMode");
	carrier_displayMode.onchange = rest_resource_tree;	
	
	
	
	$("isValidate").onclick = button_saveEnable;   
	
	var btn_config = $("btn_config");
	btn_config.onclick = selectCarrTreeResTypeRel;
	
	
	var btn_radiobutton1 = $("radiobutton1");
	btn_radiobutton1.onclick = select_reeResType;
	
	var btn_radiobutton2 = $("radiobutton2");
	btn_radiobutton2.onclick = select_reeResType;	
	
	
	var Bt_reload = $("Bt_reload");
	 Bt_reload.onclick = reload_params;	
	 
//	 	var Bt_reload2 = $("Bt_reload2");
//	 Bt_reload2.onclick = reload_params;	

     $("Bt_ckeckAllTime").removeAttribute("disabled");
	 var Bt_ckeck_all_time111 = $("Bt_ckeckAllTime");
	 Bt_ckeck_all_time111.removeAttribute("disabled");
	 Bt_ckeck_all_time111.onclick = check_all_adTimes;	  

	
	
//	$("memo").onblur = button_compareMemo;
}

function check_all_adTimes(){
	workspan.check_all_adTimes($("Bt_ckeckAllTime"),$("resource_year").value)
}
function reload_params(){
//     window.local.href=ctxPath+ "reload.html";
     window.location.href=ctxPath+ "reload.html";
   
}
function printReport(mode){
//	 var s=['view','print','excel'];
	 
	if(mode =="view"){
		button_view_resource();
	}
	if(mode =="print"){
		button_print_resource();
	}
	if(mode =="excel"){
		button_print_export();
	}

   
}
function select_reeResType(){
	var url = ctxPath + 'resources.html'
	var btn_radiobutton1 = $("radiobutton1");

	if(btn_radiobutton1.checked == false){
		url= ctxPath +'compages.html?orgId='+$("orgId").value;

	}
    window.location.href = url;

}


function button_saveEnable(){
	resource.updateEnable($("resourceId").value,$("isValidate").checked);
}
function button_compareMemo(){
	var obj_tree = carrierType.tree.dhtmlTree;
	var arr = obj_tree.getAllSubItems($("compareMemo").value).split(',');
	for(var i=0;i < arr.length-1;i++){
		var memo = obj_tree.getItemText(arr[i]);
		if($("memo").value==memo) {
			var s=confirm("备注重复");
			if(!s)
				$("memo").value="";
			break;
		}
	}
}
function rest_resource_tree(){
	 resource_year = $("resource_year").value;
	 reLoadTree();
	 $("resource_price_year").value= resource_year;
	 getPriceNameByYear();
	 
//	 getPriceNameByYear();
}	

function button_view_resource(){
		var carrierid = $("carrierIdForm").value;
		if(carrierid.indexOf("d")>-1||carrierid==""){
			alert("请选择载体!");
			return false;
		}
		var title ="";
		var urlStr = getReportURL('view');
//		 openNewWin(title,urlStr);					
}

function button_print_resource(){
		var carrierid = $("carrierIdForm").value;
		if(carrierid.indexOf("d")>-1||carrierid==""){
			alert("请选择载体!");
			return false;
		}
		var title ="";
		var urlStr = getReportURL('print');
//		openNewWin(title,urlStr);			
}	
function button_print_export(){
		var carrierid = $("carrierIdForm").value;
		if(carrierid.indexOf("d")>-1||carrierid==""){
			alert("请选择载体!");
			return false;
		}
//		window.location.href=getReportURL('export');
		getReportURL('export');
}



function printReport(mode){
//	 var s=['view','print','excel'];
	 
	if(mode =="view"){
		button_view_resource();
	}
	if(mode =="print"){
		button_print_resource();
	}
	if(mode =="excel"){
		button_print_export();
	}
	
	if(mode =="chart"){
		getFusionChartObjs();
	}	
   
}


function openNewWin(title,urlStr,w,h) {
   
   w = w > 0?w:winWidth;
   h = h > 0?w:winHeight;

   var parameters ={
   	title:"<strong>" + title +"</strong>",
   	className:"alphacube",
	width:w,
	height:h,
	draggable:false,
	minimizable:false,
	maximizable:false,
	closable:true
   	// parameters.effectOptions = {className: "popup_effect1"};
   };

	myWin = new Window(parameters);
	myWin.setURL(urlStr);
	myWin.showCenter(true);
	
}

function getReportURL(model,isChart){
	
        var url = ctxPath;
        var carrierid = $("carrierIdForm").value;
//		if(carrierid.indexOf("d")>-1){
//			alert("请选择载体!");
//			return false;
//		}
	var carrierIds= new Array();
	var obj_tree = carrierType.tree.dhtmlTree;
	var carrierId = obj_tree.getSelectedItemId();
	var parentId=obj_tree.getParentId(carrierId);
	var carrierName = obj_tree.getSelectedItemText();
	var parentName = obj_tree.getItemText(parentId);
	if(parentId=="carrierTypeId1"){
		var str=obj_tree.getSubItems(carrierId).split(",");
		for(var i=0;i<str.length;i++)
			carrierIds.push(getRealIdByTreeId(str[i],2));
	}else{
		carrierIds.push(carrierid);
		carrierName = parentName+"/"+carrierName;
	}
	var priceLengths=resource.getPriceLength(carrierIds);
	var headers="频道/载体,位置,备注,";
	var displaySumColum="0,0,0,";
	var colAlignSum = "left,right,right,"
	var widthsPSum = "10,15,15,"
	var colWidth = 45/priceLengths.length;
	var priceStr = "";
	for(var i=0;i<priceLengths.length;i++){
		if(i>=8) {break;}
		if(priceLengths[i]!=null){
			if(priceLengths[i]!=""){
				priceStr += priceLengths[i]+",";
				headers += priceLengths[i]+"秒,";
			}else{
				priceStr += ",";
				headers += "非刊例价,";
			}	
			displaySumColum += "1,";
			colAlignSum += "center,";
			widthsPSum += colWidth+",";
		}
	}
	headers+="周几有效";
	displaySumColum += "0";
	colAlignSum += "left";
	var leaveW = 60 - colWidth*priceLengths.length;
  widthsPSum+= leaveW+"";

	if(priceLengths.length>8){
		var price="";
		var displaySum = "";
		var priceLength= "";
		for(var i=8;i<priceLengths.length;i++){
			if(priceLengths[i]!=null){
				priceLength += priceLengths[i]+",";
			}
			price += priceLengths[i]+"秒,";
			displaySum += "1,";
		}
//		alert("因为页面限制,无法列出下列数据:"+price.substring(0,price.length-1));
		var msg = "因为页面限制,无法一次列出全部数据\n\n点击<确定>显示 "+headers.substring(12,headers.length-5)+"\n点击<取消>显示 "+price.substring(0,price.length-1);
		var isHeader=confirm(msg);
		if(!isHeader){
			headers = "频道/载体,位置,备注,"+price+"周几有效";
			displaySumColum = "0,0,0,"+displaySum+"0";
			priceStr = priceLength;
		}
	}
	
	
	

		                
	
		var a = {
//			 	model: model,
//                reportType: "resource_report",
//                headers:headers,
//                displaySumColum:displaySumColum,
//                isSum:true,
//                isVertical:false,
                
                
                	model: model,
				 	title:'时段配置信息',
	                reportType: "resource_report",
	                reportFile:'',
	                headers:headers,
	                displaySumColum:displaySumColum,
	                
	                colAlign:colAlignSum,
	            			widthsP:widthsPSum, 
	            	
	                isSum:true,
	                isVertical:false,	   
                
                
                carrierIds:carrierIds.toString(),
                priceLengths:priceStr.substring(0,priceStr.length-1),
                carrierName:carrierName
		};
		

//		if(priceStr=="") a.priceLengths="undefined";
		var h = $H(a);	
		if(isChart){
			url = ctxPath +"/merm/proOrderChart.jsp?"+ encodeURI(h.toQueryString());	
		}else{
			url = ctxPath +"/reports/printServlet?"+ encodeURI(h.toQueryString());	
		}


 		myprint.loadApplet(a,ctxPath,800,500);	 
 		
//		return url;
}
//function button_view_resource(){
//	 $("model").value = "view";
////	 $("reportType").value = "customerAnalyze";
//	 button_print();
//}	
//function button_print_resource(){
//	 $("model").value = "print";
////	 $("reportType").value = "customerAnalyze";
//	 button_print();
//}
//function button_print_export(){
//	 $("model").value = "export";
////	 $("reportType").value = "customerAnalyze";
//	 button_print();
//}
//function button_print(){
//	var tarForm =  $("tarForm");
//	var reportForm = $("ReportForm");
//	var carrierid = $("carrierIdForm").value;
//	//alert(carrierid.indexOf("d")>-1);
//	if(carrierid.indexOf("d")>-1){
//		alert("请选择载体!");
//		return false;
//	}
//	reportForm.target = tarForm;
//	reportForm.action="reports/jsp/resource_print.jsp";
//	reportForm.submit(); 	
//}

function isBuildLevel(){
//	var nodeLevel =  $("nodeLevel").value;
//	var func = function(isbuild){
//		if(!isbuild){
//			alert("请您在载体类别下面选择正确的载体级别以便建立串联单");
//			return false;
//		}
//	}
//	
//	carrier.isBuildLevel(func,nodeLevel);
}

function resetHeigth(){
	
   	var dialogcontent = $("dialogcontentDiv");
    var treebox = $("carrierTypeTreebox");
    
    
    var Bt_addCarrierChild = $("Bt_addCarrierChild");
    var v = Bt_addCarrierChild.offsetHeight*3;
    var r = 1;
    
   // treebox.style.height = dialogcontent.offsetHeight -(dialogcontent.offsetTop - treebox.offsetTop) - v +"px";	
   if(config_signCompages == 1){
   	  treebox.style.height = dialogcontent.offsetHeight * 0.8 +"px";
   	  r = 0.84;
   }else{
   	  treebox.style.height = dialogcontent.offsetHeight * 0.87 +"px";
   	  r = 0.87;
   }
   
    var carrierBody = $("carrierBody");
	carrierBody.style.height =  dialogcontent.offsetHeight*r +"px";	    
    var resourceBody = $("resourceBody");
	resourceBody.style.height =  carrierBody.style.height;
       	
       	
} 


function setCarrierTypePara(obj){
	 obj.className  = "carrierType";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 		= new Tree(obj.treebox); 
}
function setResourcePara(obj){
	 obj.className  = "resource";
	 obj.IdPrefix 	= obj.className + "Id";
}

function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
}
function setPriceDetailPara(obj){
	 obj.className  = "priceDetail";
	 obj.IdPrefix 	= obj.className + "Id";
}




function initResourceTree(){
	var obj_tree = carrierType.tree.dhtmlTree;
	obj_tree.dadmode=2;
	obj_tree.enableCheckBoxes(false);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.enableItemEditor(false);
	obj_tree.enableDragAndDrop(true);
//	obj_tree.enableKeyboardNavigation(true); //this need dhtmlxtree_kn.js
	obj_tree.setOnClickHandler(doOnSelect);//set function to call on dbl click
	obj_tree.setDragHandler(doOnBeforeDrop);
	
	getResourceTree(carrierType);
}

function getResourceTree(){
	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	var obj_tree = carrierType.tree.dhtmlTree;
	var getxml = function(strXML){
		obj_tree.deleteChildItems(0);	
		carrierType.tree.dhtmlTree.loadXMLString(strXML);
		Ext.getBody().unmask();
	}
	carrierType.reset();

	carrierType.obj.parentId = 0;
	carrierType.obj.nodeLevel = 0;
	carrierType.obj.orgId = $("orgId").value;
	carrierType.obj.memo = $("carrier_displayMode").value;

	
	 getPriceNameByYear();
	 
	 initResourceType();
	
	if(config_withResourceSort==1){
//	if(tvNameParam=='fztv' ||tvNameParam=='xmtv'){
        var resourceType = $('resourceTypeName').value; 
        if(resourceType =='add') $('resourceTypeName').value = 999;
		carrierType.obj.nodeLevel=$('resourceTypeName').value;  //普通、栏目、专题进行分类，以此生成树。
//		alert(carrierType.obj.nodeLevel);
//		if($('resourceTypeName').value == '') {
//			carrierType.obj.nodeLevel= 999;
//		}
//		alert(carrierType.obj.nodeLevel);
		
		if($('resourceTypeName').value == 0 || $('resourceTypeName').value == 999){
			carrierType.tree.dhtmlTree.enableDragAndDrop(true);
					
			$("Bt_addCarrierChild").show();
			$("Bt_addResourceChild").show();
//			$("Btn_view_resource").show();
//			$("Btn_print_resource").show();
//			$("Btn_export_resource").show();
		}else{
			carrierType.tree.dhtmlTree.enableDragAndDrop(false);
			
			$("Bt_addCarrierChild").hide();
			$("Bt_addResourceChild").hide();
//			$("Btn_view_resource").hide();
//			$("Btn_print_resource").hide();
//			$("Btn_export_resource").hide();
		}  
	}
	
//	alert($('resourceTypeName').value)
	
	if($('resourceTypeName').value == '' ||$('resourceTypeName').value =='999') {
			carrierType.obj.nodeLevel= 999;
	}
	
	carrierType.getTreeXMLByYear(carrier.IdPrefix,resource.IdPrefix,resource_year,getxml);
	
	
	channel.obj.orgId = $('orgId').value;
	channel.makeSelectItemAnalyze(channel.obj,"channelId","");
			
}         

function reLoadTree(el){
	if(el){
		if(el.value =='add'){
			selectCarrTreeResTypeRel();
		}else{
			carrierType.tree.dhtmlTree.deleteChildItems(0);
			getResourceTree(carrierType);
		}
	}else{
		carrierType.tree.dhtmlTree.deleteChildItems(0);
		getResourceTree(carrierType);
	}

}



function selectCarrTreeResTypeRel(){
  var orgId = $("orgId").value;
  var urlStr="selectPopup/selectCarrTreeResTypeRel.html?mode=1&orgId="+orgId+"&resourceYear="+resource_year;
  var okBtn ={text: '保存',handler: function(){document.getElementById('userReliframe').contentWindow.saveResCarrTypeRel();}};	
  var closeBtn ={text: '关闭',handler: function(){removeWin();}};
  
        
 var win = new Ext.Window({
   title : '广告分类与段位关系',
   //maximizable : true,
   // maximized : true,
   width : 300,
   height : 500,
   isTopContainer : true,
   modal : true,
   resizable : false,
    buttons: [okBtn,closeBtn],
   contentEl : Ext.DomHelper.append(document.body, {
    tag : 'iframe',
     id : 'userReliframe',
    style : "border 0px none;scrollbar:true",
    src : urlStr,
    height : "100%",
    width : "100%"
   })
  })
  win.show(); 
  
   function removeWin(){
  		win.destroy();
   	} 
   win.on({'close': {fn: removeWin}});   
  
  
}



function setWorkspanPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className  = "workspan";	
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.tableName   = obj.className +"Table";
	 obj.fillObjName= obj.className + "Body";
	 obj.color1 	= "BACKGROUND-COLOR: white";
	 obj.color2 	= "BACKGROUND-COLOR: #eee";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "10";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}

function setPricePara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className  = "price";	
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.tableName   = obj.className +"Table";
	 obj.fillObjName= obj.className + "Body";
	 obj.color1 	= "BACKGROUND-COLOR: white";
	 obj.color2 	= "BACKGROUND-COLOR: #eee";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "10";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}

function setResourceLimitPara(obj){
	 obj.className  = "resourceLimit";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.fillObjName= obj.className + "Body";
	 obj.color1 	= "BACKGROUND-COLOR: white";
	 obj.color2 	= "BACKGROUND-COLOR: #eee";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "10";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);	  
}



function doOnSelect(itemId){
	var obj_tree = carrierType.tree.dhtmlTree;
	var newItemId = carrierType.tree.newItemId;
	var selectNodeType1 = getNodeType(itemId);
	$("carrierIdForm").value = carrierType.tree.getIdByPrefix(itemId,carrier.IdPrefix);
//	$("resourceIdForm").value = carrierType.tree.getIdByPrefix(itemId,resource.IdPrefix);
	if(itemId!=newItemId){
		if(obj_tree.getLevel(newItemId) != 0){
			if(confirm("你是否想要保存改变信息?")){//save changes to new item		
			    var selectNodeType2 =  getNodeType(newItemId);
			    			    
	            obj_tree.selectItem(newItemId,false);
	            
				if(selectNodeType2 == 1 || selectNodeType2 == 2) button_saveCarrier(); 
				if(selectNodeType2 == 3) button_saveResource();

				return;
			}
			obj_tree.deleteItem(newItemId);	
		}
	}else{
		obj_tree.setItemColor(itemId,"red","pink");
	}
	switchDest(selectNodeType1,itemId);
}

function doOnBeforeDrop(id,parentId){
	var obj_tree = carrierType.tree.dhtmlTree;
	var newItemId = carrierType.tree.newItemId;

	if(id==newItemId||obj_tree.getLevel(newItemId)!=0){
		   if(id!=newItemId){
		   		if(confirm("你是否想要保存改变信息?")){//save changes to new item
				    var selectNodeType2 =  getNodeType(newItemId);
		            obj_tree.selectItem(newItemId,false);
					if(selectNodeType2 == 1 || selectNodeType2 == 2) button_saveCarrier(); 
					if(selectNodeType2 == 3) button_saveResource();
					return;
			}
			obj_tree.deleteItem(newItemId);
		   }
		return false;
		
	}else{
		var selectedNodeType =  getNodeType(id);
		var parentNodeType =  getNodeType(parentId);

        if(selectedNodeType == 1 && (isUndefined(parentNodeType)|| parentNodeType == 0 || parentNodeType == 1|| parentNodeType == 2|| parentNodeType == 3)) return false;
		if(selectedNodeType == 2 && (isUndefined(parentNodeType)|| parentNodeType == 0 || parentNodeType == 3)) return false;
		if(selectedNodeType == 3 && (isUndefined(parentNodeType)|| parentNodeType == 0 || parentNodeType == 1 )) return false;

		var gParentId = getRealIdByTreeId(parentId,parentNodeType);
		var selectId = getRealIdByTreeId(id,selectedNodeType);
		var gFatherNodeType = parentNodeType;

		//拖动载体
		if(selectedNodeType == 2){
			
			var resetCarrier = function(carrierObj){
	           //DWRUtil.setValues(carrierObj);	
	           doOnSelect(id);
				if(gFatherNodeType == 1) {
					 carrierObj.carrierTypeId = gParentId;
					 carrierObj.parentId = 0;
					 $("carrierTypeId").value = gParentId;
					 $("parentId").value = 0;
				}
				if(gFatherNodeType == 2){
					  carrierObj.parentId = gParentId;
					  $("parentId").value = gParentId;
				}
				
				var func = function(){}
				
				carrier.saveCarrier(func,carrierObj);
			}
			
			carrier.getCarrier(resetCarrier,selectId);					
		}
		//拖动资源
		if(selectedNodeType == 3){
			if(gFatherNodeType == 3) return false;
			var resetResource = function(resourceObj){
				
	            //DWRUtil.setValues(resourceObj);
	            doOnSelect(id);
				if(gFatherNodeType == 2||gFatherNodeType == 3) {
					 resourceObj.carrierId = gParentId;
					 resourceObj.parentId = 0;
					 $("carrierId").value = gParentId;
					 $("parentId").value = 0;
				}
				if(gFatherNodeType == 4){
					  resourceObj.parentId = gParentId;
					  $("parentId").value = gParentId;
				}
				
				var func = function(){
					if(tvNameParam != 'fztv'){
						var resourceIdsOnly=new Array();
						var resourceIds=obj_tree.getAllLeafs().split(',');
						for(var i=0;i<resourceIds.length;i++){
							if(resourceIds[i]==id){
								$("displayNo").value=i+1;
							}
							resourceIdsOnly.push(getRealIdByTreeId(resourceIds[i],3));
						}
						resource.updateDisplayNo(resourceIdsOnly);
					} 
					getPriceNameByYear();
				}
				if(tvNameParam=='fztv'){ 
					resource.obj.displayNo = $("overTime").value;
					resource.obj.propertiyTime = $("keepTime").value;
				}     
				resource.obj.enable = $("isValidate").checked;
				resource.obj.resourceSortId = $("resourceSortId").value;
				resource.saveResource(func,resourceObj);
			}
			resource.getResourceById(resetResource,selectId);					
		}

		return true;
	}	
}
function getRealIdByTreeId(itemId,nodeType){
  	if(nodeType == 1) return carrierType.tree.getIdByPrefix(itemId,carrierType.IdPrefix);
  	if(nodeType == 2) return carrierType.tree.getIdByPrefix(itemId,carrier.IdPrefix);
  	if(nodeType == 3) return carrierType.tree.getIdByPrefix(itemId,resource.IdPrefix);
}	
function button_saveCarrier(){
	
	var func = function(newId){
		if (newId) {
			$("carrierId").value = newId;
			//修改数节点信息
			doUpdateItemCarrier(newId);
		}
	}

	carrier.reset();
	carrier.obj.id = $("carrierId").value;
	carrier.obj.carrierName = $("carrierName").value;
	carrier.obj.parentId =$("parentId").value;
	carrier.obj.enable = $("carrierEnable").checked;
	carrier.obj.isBuildLevel = $("isBuildLevel").checked;
	carrier.obj.carrierTypeId = $("carrierTypeId").value;
//	if(tvNameParam=='fztv' ||tvNameParam=='xmtv'){
//		carrier.obj.memo = $("isBasePos").checked?1:0;
//	}
	carrier.obj.aliasName = $("aliasName").value;
	carrier.obj.channelId = $("channelId").value;
	carrier.obj.mediaOrgId = $("mediaOrgId").value;
	
	
    var selectId = carrierType.tree.dhtmlTree.getSelectedItemId();
    var nodeLevel = getCarrierParent(selectId,0);
   
	
//	if(tvNameParam =='xmtv' && (carrier.obj.mediaOrgId ==''||carrier.obj.mediaOrgId == 0)){ 
//		alert('请选择载体类型');
//		var myObj = $("mediaOrgId");
//		 myObj.focus();	
////		 myObj.size = myObj.length;
//		return false;
//	}
	
	var myObj = $("aliasName");
	var aliasName = myObj.value;
	if(nodeLevel == 1){
		if(aliasName ==''|| aliasName ==null){ 
			alert('请输入频道别名');
			aliasName.focus();	
		}
	}
	
 	carrier.obj.nodeLevel = nodeLevel;	
	carrier.obj.version = resource_year;
	carrier.saveCarrier(func,carrier.obj);
}


function getCarrierParent(itemId,i){
	var obj_tree = carrierType.tree.dhtmlTree;
	var parentId = obj_tree.getParentId(itemId);
	var parent_id = obj_tree.getUserData(parentId,"parentId");
    var k = 0;

	var type = getNodeType(parentId);

	if(type == 1){
		i = i+1
		k = i;
	   	return k;
	}else{
		i = i+1
		k = i;
	 	return getCarrierParent(parentId,i);

	}
}

//
//function getCarrierParent(itemId,i){
//	var obj_tree = carrierType.tree.dhtmlTree;
//	var parentId = obj_tree.getParentId(itemId);
//	var parent_id = obj_tree.getUserData(parentId,"parentId");
//    var k = 0;
//    
//	
//
//	var type = getNodeType(parentId);
//   
//	if (type == 2){
//		i=i+1;
//		k = i;
//	 	getCarrierParent(parentId,i);
//	 	return k;
//	}
//	
//	if (type == 1 && parent_id>0){
//		i=i+1;
//		k = i;
//	 	getCarrierParent(parentId,i);
//	 	return k;
//	}
//	
//	return k;
//}
function getCarrierLevel(){
	var carrierLevel = 0;
    var selectId = carrierType.tree.dhtmlTree.getSelectedItemId();
    var nodeType = getNodeType(selectId);
    if(nodeType == 2){
		carrierLevel = carrierType.tree.dhtmlTree.getLevel(selectId);
    }
    return carrierLevel;	
}


function button_removeCarrier(){
	
	var obj_tree = carrierType.tree.dhtmlTree;
	var newItemId = carrierType.tree.newItemId;
	
	if(obj_tree.getSelectedItemId()!=newItemId){//delete node from db
		if(!confirmDelete('Carrier')) return false;
		var id =$("carrierId").value;			
		carrier.removeCarrier(id);
		doDeleteTreeItem(carrier.IdPrefix+id);
	}else{
		doDeleteTreeItem(newItemId);
	}	
}
//从树删除节点
function doDeleteTreeItem(id){
	var obj_tree = carrierType.tree.dhtmlTree;
	var pId = obj_tree.getParentId(id);
	obj_tree.deleteItem(id);
	if(pId!="0")
		obj_tree.selectItem(pId,true);
}
//修改数节点信息
function doUpdateItemCarrier(id){
	var obj_tree = carrierType.tree.dhtmlTree;
	var newId = carrier.IdPrefix + id;
	var name = $("carrierName").value;

	obj_tree.changeItemId(obj_tree.getSelectedItemId(),newId);
    obj_tree.setUserData(newId,"id",id);
	obj_tree.setItemText(newId,name);
	obj_tree.setUserData(newId,"type",2);
	obj_tree.setItemColor(newId,"black","white");
}

//根据节点类型切换载体 或广告资源
function switchDest(nodeType,itemId){
	
  	//显示载体信息
	if(nodeType == 0||nodeType == 1){
	 	$("carrierBody").hide();
	 	$("resourceBody").hide();
	}
	if(nodeType == 2){
	    $("carrierBody").show();
	    $("resourceBody").hide();
		$("resourceId").value = "";
		var carrierId = carrierType.tree.getIdByPrefix(itemId,carrier.IdPrefix);
		loadCarrierDetails(carrierId);
		loadResourceLimits(carrierId);
	}
	//显示资源信息
	if(nodeType == 3){
		$("carrierBody").hide();
	    $("resourceBody").show();
		var resourceId = carrierType.tree.getIdByPrefix(itemId,resource.IdPrefix);
		loadResourceDetails(resourceId);
	}
}

function loadCarrierDetails(carrierId){
	
	var func = function(carrierInfo){
		DWRUtil.setValues(carrierInfo);
//		$("isBasePos").checked = carrierInfo.memo==1?true:false;
		$("carrierId").value = carrierInfo.id;
		$("isBuildLevel").checked =carrierInfo.isBuildLevel==1?true:false;
	}
	carrier.getCarrier(func,carrierId);
}


function loadResourceLimits(carrierId){
	var level = getCarrierLevel();	
	
	var tree = carrierType.tree.dhtmlTree;
	var selectedId = tree.getSelectedItemId();
	var parentId = tree.getParentId(selectedId);
	var nodeType =  getNodeType(parentId);

	if(config_resourceReLimitParam == 1 && nodeType ==1){
		
		$("resourceLimitList_div").style.visibility = "visible";
		
		var func = function(objs){
			resourceLimit.fillTalbe(objs);
		}
		if(config_resourceReLimitParam == 1 ){
			resourceLimit.reset();
			resourceLimit.obj.carrierId = carrierId;
			resourceLimit.getResourceLimits(func,1);
		}		
		
	}else{
		$("resourceLimitList_div").style.visibility = "hidden";	
	}

}


function loadResourceDetails(resourceId){
	
	var func = function(resourceInfo){
		DWRUtil.setValues(resourceInfo);
		
		$("beforehand").value = resourceInfo.beforehand;

		if(tvNameParam=='fztv'){
			$("overTime").value = resourceInfo.displayNo;
			$("keepTime").value = resourceInfo.propertiyTime;
		}
		
		$("resourceId").value = resourceInfo.id;
		if(resourceInfo.enable){
			$("isValidate").checked =true;
		}else{
			$("isValidate").checked =false;
		}
		var id = resourceInfo.id;

		if(id !=''){
			loadWorkSpances(id);
			loadPrices(id);
		}
	}
	
	resource.getResourceById(func,resourceId);
}

function loadWorkSpances(id){

//	var func = function(objs){		
//		workspan.fillTable(objs);
//	}
//	workspan.reset();
	
//	workspan.getWorkspansByResId(id,func);
	
	workspan.getWorkspansByResId2(mygrid,id);
}

function loadPrices(id){
	
	var func = function(objs){
		$("hiddenArea").appendChild($("resourcePriceType"));
		price.fillTable(objs);
	}
	price.reset();
	price.getPricesByResId(id,func);
}

function button_add_new_obj(type){

	if(type == 1){
		workspan.addNewRow('new',null);
		getDate();
	}
	if(type == 2){
		price.addNewRow('new',null);
	}
}

function button_add_new_resourceLimit(){
	resourceLimit.addNewRow('new',null);
}

function saveResourceLimit(id){
	    resourceLimit.reset();
		DWRUtil.getValues(resourceLimit.obj);
		if(id> 0) resourceLimit.obj.id = id;
		function f(){
			var carrierId = $("carrierId").value;
			loadResourceLimits(carrierId);
		}
		resourceLimit.saveResourceLimit(f);
}	

function cannelResourceLimit(){
	var carrierId = $("carrierId").value;
	loadResourceLimits(carrierId);
}
	

function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == workspan.pageInfo){
		var page = new Page(workspan.pageInfo,workspan.pageSize);
		page.goNextPage(pageIndex);
		workspan.page = page;
		loadWorkSpances($("resourceId").value);
	}
	
	if(pageInfoName == price.pageInfo){
		var page = new Page(price.pageInfo,price.pageSize);
		page.goNextPage(pageIndex);
		price.page = page;
		loadPrices($("resourceId").value);
	}
}
function button_addCarrierChild(){
	var obj_tree = carrierType.tree.dhtmlTree;
	var newItemId = carrierType.tree.newItemId;
	
	var newItemLabel = carrierType.tree.newItemLabel;
	
	if(obj_tree.getLevel(newItemId)!= 0){
		alert("未保存载体已存在！")
		return false;	
	}
	
	var selectedId = obj_tree.getSelectedItemId();
	var nodeType = getNodeType(selectedId);
	var curSelectId = carrierType.tree.getIdByPrefix(selectedId,carrier.IdPrefix);
	var carrierTypeId;
	


//	alert("selectedId = " + selectedId);
//	alert("nodeType = " + nodeType);
//	alert("curSelectId = " + curSelectId);

    //只有选择载体类别和载体，才可以增加
    if(nodeType == 1 || nodeType == 2) {
        if(selectedId!=""){	
        	if(nodeType == 1) carrierTypeId = carrierType.tree.getIdByPrefix(selectedId,carrierType.IdPrefix);
        	if(nodeType == 2) carrierTypeId = carrierType.tree.getIdByPrefix(obj_tree.getParentId(selectedId),carrierType.IdPrefix);
        	$("carrierId").value = 0;
			//判断谁是新生儿的父亲
			if(nodeType == 1) var parentId = 0;
			if(nodeType == 2) var parentId = curSelectId;
			$("parentId").value = parentId;
			$("carrierName").value = newItemLabel;
			$("aliasName").value = null;
			$("channelId").value = null;
			$("mediaOrgId").value = null;
			$("carrierTypeId").value = carrierTypeId;
			$("isBuildLevel").checked = false;
			$("carrierBody").show();
			$("resourceBody").hide();

          
          
//            obj_tree.insertNewItem(selectedId,newItemId,newItemLabel,"","book.gif","books_open.gif","books_close.gif","SELECT,CALL",0);	
            obj_tree.insertNewItem(selectedId,newItemId,newItemLabel,"","magazines_close.gif","magazines_open.gif","magazines_close.gif","SELECT,CALL",0);	
        
         
          
			
			
			
			//由于要根据类别，来切换界面
			obj_tree.setUserData(newItemId,"type",2);

		}else{
			alert("请选择被增加的节点");
		}
    }
}
function getNodeType(itemId){
  	var obj_tree = carrierType.tree.dhtmlTree;
	return obj_tree.getUserData(itemId,"type");
}	

function button_addResourceChild(){
	
	var obj_tree = carrierType.tree.dhtmlTree;
	var newItemLabel = carrierType.tree.newItemLabel;
	var newItemId = carrierType.tree.newItemId;
	
	if(obj_tree.getLevel(newItemId)!=0){//check if unsaved item already exists
		alert("未保存资源已存在！")
		return false;
	}
	
	var selectedId = obj_tree.getSelectedItemId();
	$("compareMemo").value = selectedId;
    var nodeType =  getNodeType(selectedId);

    var curSelectResId = carrierType.tree.getIdByPrefix(selectedId,resource.IdPrefix);
//	var curSelectCarrId = carrierType.tree.getIdByPrefix(selectedId,carrier.IdPrefix);

    //只有选择载体类别和载体，才可以增加
    if(nodeType == 2) {
        if(selectedId!=""){
        	$("resourceId").value = -1;
        	
			//判断谁是新生儿的父亲
			if(nodeType == 2) var parentId = 0;
			if(nodeType == 3) var parentId =  curSelectResId;
			
			$("parentId").value = parentId;
			$("resourceName").value = newItemLabel;	
			
			$("carrierId").value = carrierType.tree.getIdByPrefix(selectedId,carrier.IdPrefix);
			
			
			$("memo").value = null;
			$("resourceType").value = null;
			$("resourceSortId").value = 1;
			$("isValidate").checked = true;
//			$("enable").checked = true;
			$("isSeralized").checked = true;
			$("isOverweight").checked = true;
			$("isManual").checked = false;
			$("isClosed").checked = true;	
			$("displayNo").value = 0;
			

			obj_tree.insertNewItem(selectedId,newItemId,newItemLabel,"","","","","SELECT,CALL",0);	
			obj_tree.setUserData(newItemId,"type",3);
			$("carrierBody").hide();
			$("resourceBody").show();

			loadWorkSpances($("resourceId").value);
			loadPrices($("resourceId").value);
			
			button_add_new_obj(1);
			
		}else{
			alert("请选择被增加的节点");
		}
    }	
    
     if(nodeType == 3) {
     	  var parentId = obj_tree.getParentId(selectedId);
     	  obj_tree.selectItem(parentId);
     	  button_addResourceChild();
      }
}



function getResParentText(){
	var v = "";
	var tree = carrierType.tree.dhtmlTree;
	var selectedId = tree.getSelectedItemId();
	var level = tree.getLevel(selectedId);

	if(level>2){

		if(level>3){
			var parentId = tree.getParentId(selectedId);
			var vs =[];
			for(var i = level;i>3;i--){
				var nodeType =  getNodeType(parentId);
				if(nodeType == 2){
					v = tree.getItemText(parentId) +"_"+v;
					parentId = tree.getParentId(parentId);	
				}
			}
		}
		if(level==3){
			v = tree.getItemText(selectedId);
		}	
	}
	return v;
}

function button_saveResource(){
	
	
	var callbak_func = function(newId){
		if (newId>-1) {
			//修改数节点信息
			doUpdateItemResource(newId);
			$("resourceId").value = newId;
				   //全体排序---开始---
				   if(tvNameParam !='fztv'){
				   		if($("displayNo").value==0){
							var obj_tree = carrierType.tree.dhtmlTree;
							var resourceIdsOnly=new Array();
							var resourceIds=obj_tree.getAllLeafs().split(',');
							for(var i=0;i<resourceIds.length;i++){
								if(resourceIds[i]=="resourceId"+newId){
									$("displayNo").value=i+1;
								}
								resourceIdsOnly.push(getRealIdByTreeId(resourceIds[i],3));
							}
							resource.updateDisplayNo(resourceIdsOnly);
							
				   		}
				   }

					//全体排序---结束---
			//判断有效信息是否处于编辑状态,新添有效信息
			
			
			function callbak_save_price(){
	        //判断有价格信息是否处于编辑状态,新添有效信息
	        var Btn_savePrices = $("Btn_savePrices");
	        
	        if(!isUndefined(Btn_savePrices)){
	        	
			        	var tr =Btn_savePrices.parentNode.parentNode;
				        var paraId = Btn_savePrices.getAttribute("paraId");
				
			        	DWRUtil.getValues(price.obj);
			        	price.obj.id=paraId;
			        	price.obj.resource = resource.getResource($("resourceId").value);
			        	price.obj.version = resource_year;
			        	
									var func = function(){
										loadPrices($("resourceId").value);
										
										getPriceNameByYear();
									}
						
		           price.savePrice(price.obj,func); 
	        				}	
			}
			
			
			
			
			
			grid_wspand_save(callbak_save_price);
			
//			var Btn_SaveWorkSpan = $("Btn_SaveWorkspan");
//			
//	        if(!isUndefined(Btn_SaveWorkSpan)){
//	        	
//	        	if (!checkEndTime())return false;
//
//	        	var tr =Btn_SaveWorkSpan.parentNode.parentNode;
//		        var paraId = Btn_SaveWorkSpan.getAttribute("paraId");
//
//	        	DWRUtil.getValues(workspan.obj);
//	        	workspan.obj.id=paraId;
//	        	workspan.obj.version = resource_year;
//	        	
//				var func = function(){
//					loadWorkSpances($("resourceId").value);
//				}
//				
//				
//				if(config_withBroPoint != 1){
//					 workspan.obj.broadcastEndTime = $("broadcastStartTime").value;
//					 workspan.obj.broadcastStartTime = 0;
//				}
//				
//				
//				
//					
//				workspan.saveWorkspan(workspan.obj,func);
//	        }
	        

		}
		
		
	}
	
	
	

	DWRUtil.getValues(resource.obj);
	resource.obj.beforehand = $("beforehand").value;
//	alert(resource.obj.beforehand);
	
	resource.obj.id = $("resourceId").value;
	resource.obj.displayNo = $("displayNo").value;
	if(tvNameParam=='fztv'){ 
		resource.obj.displayNo = $("overTime").value;
		resource.obj.propertiyTime = $("keepTime").value;
	}
	resource.obj.createDate = myDate.parseDate(getFormatDay(config_serviceDate,"yyyy-mm-dd"));
	resource.obj.version = resource_year;
	resource.obj.enable = $("isValidate").checked;
	resource.obj.resourceSortId = $("resourceSortId").value;

//	if(tvNameParam =='xmtv' && (resource.obj.resourceType ==''||resource.obj.resourceType == 0)){ 
//		alert('请选择资源类型');
//		 $("resourceType").focus();	
//		return false;
//	}
	
	
	resource.saveResource(callbak_func,resource.obj);
	
}

function doUpdateItemResource(id){
	var obj_tree = carrierType.tree.dhtmlTree;
	var newId = resource.IdPrefix + id;
	var name = $("resourceName").value;
	var meno = $("memo").value;

	obj_tree.changeItemId(obj_tree.getSelectedItemId(),newId);
    obj_tree.setUserData(newId,"id",id);
    
    if(config_resourceDisplayParam>0){
    	obj_tree.setItemText(newId,meno);
    }else{
    	obj_tree.setItemText(newId,name);
    }
        
	
	
	
	obj_tree.setUserData(newId,"type",3);
	obj_tree.setItemColor(newId,"black","white");
}
function display_importPrice(){
	$('theDivSearch').style.visibility = "visible";
}
function close_importPrice(){
	$('theDivSearch').style.visibility = "hidden";
}
function button_importPrice(){
	var callback =function(){loadPrices($("resourceId").value);}
	if($("resourceId").value>0&&$('priceName').value>0){
		price.saveResourcePriceRel($("resourceId").value,$('priceName').value,callback);
		$('theDivSearch').style.visibility = "hidden";
	}
	
}

function button_removeResource(){
	var obj_tree = carrierType.tree.dhtmlTree;
	var newItemId = carrierType.tree.newItemId;
	
	if(obj_tree.getSelectedItemId()!=newItemId){//delete node from db
		if(!confirmDelete('Resource')) return false;
		var id =$("resourceId").value;				
		resource.removeResource(id);
		doDeleteTreeItem(resource.IdPrefix+id);
	}else{
		doDeleteTreeItem(newItemId);
	}	
}

function getCurYearFirstDay(){

	//var year = date.getFullYear();
	var firstDay = resource_year+"/01/01";
	
	return firstDay;
}

function getCurYearLastDay(){

	//var year = date.getFullYear();
	var lastDay = resource_year+"/12/31";
	
	return lastDay;
}

function getDate(){
	Calendar.setup({
		inputField  : "beginDate",	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "beginDate"	// id of the button
	});
	
	Calendar.setup({
		inputField  : "endDate",	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "endDate"	// id of the button
	});
}
function changeOtherLength(event){
		var length = $("monLength").value;  
		$("tueLength").value = length;
		$("wenLength").value = length;
		$("thiLength").value = length;
		$("friLength").value = length;
		$("satLength").value = length;
		$("sunLength").value = length;
}
function cannelAddandEdit(){
	loadWorkSpances($("resourceId").value);
}

function saveAddandEditWorkspan(event){
	
	if (!checkEndTime())return false;

	var e = event || window.event;
	var saveImgTd = Event.element(e);		
	var mode = saveImgTd.getAttribute("mode");
	var id = saveImgTd.getAttribute("paraId");


	if(mode =="new") $("Btn_SaveWorkspan").onclick =function(){}

	DWRUtil.getValues(workspan.obj);
	workspan.obj.id = id;
	workspan.obj.version= resource_year;
	
	

	
	if($("resourceId").value ==-1){
		DWRUtil.getValues(resource.obj);
		resource.obj.beforehand = $("beforehand").value;
		resource.obj.id = $("resourceId").value;
		resource.obj.version = resource_year;
		if(tvNameParam=='fztv'){ 
			resource.obj.displayNo = $("overTime").value;
			resource.obj.propertiyTime = $("keepTime").value;
		}
		
		
		var func = function(newId){
			if (newId>-1) {
				doUpdateItemResource(newId);
				$("resourceId").value = newId;
				
				//判断有效信息是否处于编辑状态,新添有效信息
				
//				grid_wspand_save();
				
//				var Btn_SaveWorkSpan = $("Btn_SaveWorkspan");
//				
//		        if(!isUndefined(Btn_SaveWorkSpan)){
//		        	
//		        	if (!checkEndTime())return false;
//
//		        	var tr =Btn_SaveWorkSpan.parentNode.parentNode;
//			        var paraId = tr.getAttribute("paraId");
//			        
//		        	DWRUtil.getValues(workspan.obj);
//		        	workspan.obj.id=paraId;
//		        	workspan.obj.version=resource_year;
		        	
					var funct = function(){
//						loadWorkSpances(newId);
						if(tvNameParam != 'fztv'){
							//全体排序---开始---
							var obj_tree = carrierType.tree.dhtmlTree;
							var resourceIdsOnly=new Array();
							var resourceIds=obj_tree.getAllLeafs().split(',');
							for(var i=0;i<resourceIds.length;i++){
								if(resourceIds[i]=="resourceId"+newId){
									$("displayNo").value=i+1;
								}
								resourceIdsOnly.push(getRealIdByTreeId(resourceIds[i],3));
							}
							resource.updateDisplayNo(resourceIdsOnly);
							
							//全体排序---结束---
						} 
						getPriceNameByYear();
					}
//					if(config_withBroPoint != 1){
//						 workspan.obj.broadcastEndTime = $("broadcastStartTime").value;
//						 workspan.obj.broadcastStartTime = 0;
//					}
					grid_wspand_save(funct);
//					workspan.saveWorkspan(workspan.obj,funct);
//		        }

			}	
		}
		resource.obj.enable = $("isValidate").checked;
		resource.obj.resourceSortId = $("resourceSortId").value;
		resource.saveResource(func,resource.obj);
	}else{	
		
		grid_wspand_save(null);
		
//		var func = function(){
//			loadWorkSpances($("resourceId").value);
//		}
//			
//		if(config_withBroPoint != 1){
//			 workspan.obj.broadcastEndTime = $("broadcastStartTime").value;
//			 workspan.obj.broadcastStartTime = 0;
//		}
//		workspan.saveWorkspan(workspan.obj,func);
	}

}
function deleteWorkspan(deleImg){
	
	var id = deleImg.getAttribute("paraId"); 
	var delRow = deleImg.parentNode.parentNode;
	
	workspan.removeWorkspan(id,delRow);
	
	loadWorkSpances($("resourceId").value);
}

function button_displayPriceDetail(obj){

		var tr = obj.parentNode.parentNode;
        var rowIndex = tr.rowIndex;
        var id = tr.getAttribute("paraId");
        $("pricesId").value = id;
        
	    button_hidenPriceDetail();  
	    
	    var hidenLink = "<a href='javascript:void 0' id=\"Btn_hidenPriceDetailLink\" onclick=\"button_hidenPriceDetail(this)\">隐 藏</a>";
	    
	    obj.parentNode.innerHTML = hidenLink;

        var container = document.createElement("span"); 
        
 	    var tr2 =  document.createElement("tr"); 
 	    var td2 =  document.createElement("td"); 
 	    tr2.setAttribute("id","priceDetail_row"); 
        td2.setAttribute("id","priceDetail_row_cell"); 
        td2.setAttribute("colspan","7"); 
        td2.setAttribute("align","right"); 
        td2.setAttribute("width","100%"); 
        tr2.style.cssText = tr.style.cssText;
     
        
        tr2.appendChild(td2);
        container.appendChild(tr2);	
		
        new Insertion.After($("pricesRow"+id),container.innerHTML); 	    

        loadPrice_Details(id);
}
function button_hidenPriceDetail(){
	    var hidenLink = $("Btn_hidenPriceDetailLink");	 
		
 	    if(!isUndefined(hidenLink)){
 		  	var displayLink = "<a href='javascript:void 0' id=\"Btn_displayPriceDetailLink\" onclick=\"button_displayPriceDetail(this)\">显 示</a>";
			
			hidenLink.parentNode.innerHTML = displayLink;		    	
 	    }
 	    
 	    var priceDetail_row = $("priceDetail_row");
 	   
 	    if(!isUndefined(priceDetail_row)){
            $("priceDetail_row").remove();
 	    }	
}
function loadPrice_Details(priceId){
	
	var func = function(objs){
		$("hiddenArea").appendChild($("resourcePriceType"));
		fillPriceDetailTab(objs);
	}
	
	 price.getPriceDetailByPriceId(func,priceId);
}
function fillPriceDetailTab(data){
	
	    var cont = document.createElement("span");
	    var priceDetail_row_cell = $("priceDetail_row_cell");
	    
	    var priceDetail_row_tab_4 = $("priceDetail_row_tab_4");
	    if(!isUndefined(priceDetail_row_tab_4)){
	    	priceDetail_row_tab_4.remove();
	    }
	    
	    
	    var tb = document.createElement("table"); 
	    var tr1 = document.createElement("tr");
	    var tr2 = document.createElement("tr");
	    var tr3 = document.createElement("tr");
	    var tr4 = document.createElement("tr");
	    tb.setAttribute("id","priceDetail_row_tab_4"); 
	    tb.setAttribute("width","90%"); 
	    tb.setAttribute("class","FieldLabl1");
	    tr1.setAttribute("class","FieldLabl1");
	    tr2.setAttribute("class","FieldLable2");
	    tr3.setAttribute("class","FieldLable2");
	    tr4.setAttribute("class","FieldLable2");


        var cell1 =  makeInputTextTd("priceDetailId","hidden","10px","");
        var cell2 =  makeInputTextTd("priceDetailLength","text","5","");
   
        var cell3 =  makeInputTextTd("priceDetailPrice","text","5","");

        var cell4 = makeInputButtonTd("add_price_detail","button","10px","新添","add_price_detail_fun");
        var cell5 = makeInputButtonTd("mod_price_detail","button","10px","修改","mod_price_detail_fun");
        
	    var size = data.length;
	    for (var i = 0;i<size;i++){
	    	priceDetail.obj = data[i];
	    	var leng =   makeTextTd(priceDetail.obj.length);
//	    	leng.setAttribute("class","FieldLabl1");
	    	leng.setAttribute("id","priceDetail_length" + priceDetail.obj.id);
	    	leng.setAttribute("value",priceDetail.obj.length);
	    	leng.setAttribute("width","5px");
	    	
			var price =  makeTextTd(priceDetail.obj.price);
			price.setAttribute("id","priceDetail_price"+priceDetail.obj.id);
			price.setAttribute("value",priceDetail.obj.price);
		    var editImg = makeImagHtml("image/edit.png","Btn_editPriceDetail_ID","18","18",priceDetail.obj.id,"button_priceDetail_edit"); 
            var deleteImg = makeImagHtml("image/button_delete.gif","Btn_deletePriceDetail_ID","18","18",priceDetail.obj.id,"button_priceDetail_delete"); 
	    	tr1.appendChild(leng);
	    	tr2.appendChild(price);	
	    	var tddo = document.createElement("td");
	    	tddo.appendChild(editImg);tddo.appendChild(deleteImg);
	    	tr3.appendChild(tddo);
	    }
       
       var td = document.createElement("td");
       td.setAttribute("colspan",size*1+1);
       td.setAttribute("align","right");
       td.innerHTML =    cell1.innerHTML + "长度:"+ cell2.innerHTML + "价格:"+ cell3.innerHTML + cell4.innerHTML+ cell5.innerHTML
       tr4.appendChild(td);

       tb.appendChild(tr1);
       tb.appendChild(tr2);
       tb.appendChild(tr3);
       tb.appendChild(tr4);
       priceDetail_row_cell.appendChild(tb);
       
       $("priceDetailLength").onblur = isDigit2;	
       $("priceDetailPrice").onblur = isDigit2;
        
}	

function cannelAddandEditPrice(){
	loadPrices($("resourceId").value);
}

function saveAddandEditPrice(event){
	var e = event || window.event;
	var saveImgTd = Event.element(e);	
	var id = saveImgTd.getAttribute("paraId");
	
	var func = function(priceId){
		$("pricesId").value = priceId;
		loadPrices($("resourceId").value);
		//重新载入价格名称
		getPriceNameByYear();
	}

	price.obj.id = id;
	DWRUtil.getValues(price.obj);

	price.obj.resource = resource.getResource($("resourceId").value);

	if($("resourcePriceType").value == ''){
		alert("价格类别不能为空");
		return false;
	}
	
	price.obj.version = resource_year;
	price.savePrice(price.obj,func);
}	
function deletePrice(deleImg){
	var id = deleImg.getAttribute("paraId"); 
	var delRow = deleImg.parentNode.parentNode;
	
//	price.removePrice(id,delRow);
	price.removeResourcePriceRel(id,$("resourceId").value,delRow);
	loadPrices($("resourceId").value);
}
function selectResourceType(){
		
	var values = [];

	var rows = $("priceBody").getElementsByTagName("tr");
	var selectedText;
	
    for(var j=0;j<rows.length;j++){
    	var trObj = rows[j];
		var priceName = getCellValue(trObj,2);
     	var obj = getCellObj(trObj,2);

     	if(isUndefined(obj)){
     		values.push(priceName);
     	}
    }
    
     for(var i=0;i<$("resourcePriceType").options.length;i++){
     	var opt = $("resourcePriceType").options[i];
     	
     	var lastIndexOf = opt.text.lastIndexOf("||");
     	
     	var resourceName = opt.text.substring(0,lastIndexOf);
     	
     	if(opt.selected){
     		selectedText = resourceName.Trim();
     	}
     }

     var without = values.indexOf(selectedText);

     if(without > -1){
     	 alert("价格类别只能唯一");
     	 $("resourcePriceType").value = '';
     }	 
}
function add_price_detail_fun(){
	
	var func = function(){
		var pricesId = $("pricesId").value;
		loadPrice_Details(pricesId);
	}
	
	priceDetail.reset();
	priceDetail.obj.priceId = $("pricesId").value;
	priceDetail.obj.id = -1;
	priceDetail.obj.length = $("priceDetailLength").value;
	
	var trs = price.tBody.getElementsByTagName("tr");

	var priceDetailLength = $("priceDetailLength").value;
	var cells = trs[1].getElementsByTagName("th");
	for(var i = 0;i < cells.length; i++){
		if(priceDetailLength==cells[i].innerHTML){
			alert("广告长度不能相同，请您重新输入！");
			return false;
		}
	}
	priceDetail.obj.price = $("priceDetailPrice").value;
	priceDetail.obj.version = resource_year;
	priceDetail.savePriceDetail(priceDetail.obj,'new',func);
	
}	
	
function mod_price_detail_fun(){
	var func = function(){
		var pricesId = $("pricesId").value;
		
		loadPrice_Details(pricesId);
	}
	
	priceDetail.reset();
	priceDetail.obj.id = $("priceDetailId").value;
	if(priceDetail.obj.id == '') return false;
	priceDetail.obj.length = $("priceDetailLength").value;
	priceDetail.obj.price = $("priceDetailPrice").value;	
	priceDetail.obj.version = resource_year;
	priceDetail.savePriceDetail(priceDetail.obj,'edit',func);
}	
	
function button_priceDetail_edit(editImg){
    var id = editImg.getAttribute("paraId");
        	
	$("priceDetailId").value = id;
	$("priceDetailLength").value = $("priceDetail_length"+id).getAttribute("value");
	$("priceDetailPrice").value = $("priceDetail_price"+id).getAttribute("value");
}	
	
function button_priceDetail_delete(deleteImg){
	if (!confirmDelete('PriceDetail')) return false;
	var func = function(){
		var pricesId = $("pricesId").value;
		
		loadPrice_Details(pricesId);
	}
	var id = deleteImg.getAttribute("paraId");

	priceDetail.removePriceDetailById(id,func);
}