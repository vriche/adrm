var carrierType = new CarrierType();
var carrier =new  Carrier();
var channel = new ResourceChannel();
var resourceSort = new ResourceSort();
var user = new User();
var resource = new Resource();
var customerProduct = new CustomerProduct();
var customer = new Customer();
var orderCategory = new OrderCategory();
var myDate = new MyDate();
var myUtils;
var config_serviceDate;
var tvNameParam;
var myprint =new MyPrint();
var winAdver;
var ctxPath;
var mygrid;
var default_days = 31;
var def_show_win_init_days = 6;
var cur_days = 0;
var print_isVertical = false;
var _gobal_colSumUsed = new Array();
var _gobal_colSumTotal = new Array();
var _gobal_colSumRate = new Array();
var _gobal_query_param ={};
//var gridParams ={};


var queryWindow;

callOnLoad(init);	

function init(){
	config_serviceDate = _app_params.serviceDate.def;
	channelModelParam = _app_params.sysParam.channelModelParam;
	config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;
	tvNameParam =  _app_params.sysParam.tvNameParam;
	loginUser =  _app_params.user.username;	
	
	resetHeigth();
	
	ctxPath = _app_params.ctxPath;	 	
	myUtils = new MyUtils(_app_params.sysParam.serviceDate);
	_make_org_select("orgId",100,"resetStore");	
	
//	this.myprint.buildButtons2(this,"printReportDiv",[0,1,2,8],60);

	this.myprint.buildButtons3(this,"printReportDiv1",[8],60);
	this.myprint.buildButtons3(this,"printReportDiv2",[1],60);
	this.myprint.buildButtons3(this,"printReportDiv3",[2],60);
	this.myprint.buildButtons3(this,"printReportDiv7",[0],60);
	this.myprint.buildButtons3(this,"printReportDiv4",[6],60);
	
	buttonEventFill();


   initGrid(0);
	 
   showSearchWin(); 
    

	
}

function buttonEventFill(){	
	var btn_seach_type = $("seach_type");
	btn_seach_type.onchange = loadGridData;
	
	var btn_unitss = $("unitss");
	btn_unitss.onchange = loadGridData;
	
}
function resetHeigth(){
    var dialogcontent = $("dialogcontentDiv");
    var gridbox = $("adResCount");
    gridbox.style.height = dialogcontent.offsetHeight * 0.85 +"px";	
    if(mygrid) mygrid.setSizes(); 
} 

function parseNumber(number, splitChar) {
  var n = number + '';
  var s = splitChar == null ? '.' : splitChar;
  var nArr = n.split(s);
  if (nArr.length == 2) {//2.1
     return parseInt(nArr[0]) + 1;
  }
  else {//2.0
  return number;
  }
}

function formatFloat(src, pos)
{
    return Math.round(src*Math.pow(10, pos))/Math.pow(10, pos);
}





function getDateWeek(todayDate)
{
	 var dateweek ="";
  switch(todayDate.getDay())
		{
//		case 0:dateweek += "周日";break;
//		case 1:dateweek += "周一";break;
//		case 2:dateweek += "周二";break;
//		case 3:dateweek += "周三";break;
//		case 4:dateweek += "周四";break;
//		case 5:dateweek += "周五";break;
//		case 6:dateweek += "周六";break;
		case 0:dateweek += "日";break;
		case 1:dateweek += "一";break;
		case 2:dateweek += "二";break;
		case 3:dateweek += "三";break;
		case 4:dateweek += "四";break;
		case 5:dateweek += "五";break;
		case 6:dateweek += "六";break;
		}
return dateweek;

}








function getGridParams(){
	
			var gridParams ={};
		
			var dateField_start = Ext.getCmp('start_date_query');
 			var dateField_end = Ext.getCmp('end_date_query');
 			
// 			var hed1 = $("seach_type").value == 1?"占用":"剩余";
 			var hed1 ="饱和度";
 			
 			
 			var s1;
			var s2;
			
			
			
//			startDate1 = _app_params.serviceDate.defStartDate;
//
//		endDate1 = _app_params.serviceDate.defEndDate;	


        
						
 			if(!dateField_start){
					 s1 =   myDate.parseDate(getFormatDay(_app_params.serviceDate.format2,"y-m-d"));
					 s2 =   myDate.parseDate(getFormatDay(_app_params.serviceDate.format2,"y-m-d"));
					 s1.setDate(s1.getDate()+default_days);
 			}else{
					 s1 = dateField_end.getValue();
					 s2 = dateField_start.getValue();
 			}
 			

			var time= s1.getTime() - s2.getTime();  
			var days = parseInt(time / (1000 * 60 * 60 * 24))+1;  
			var days2 = new Array();
			

			if(days < 0){
				extjMessage("结束日期不能小于开始日期!");return false;
			}
			

			if(days > (default_days+1)){
				extjMessage("为不影响界打印效果,限制只能查询31天内的信息!");return false;
			}	
			
			
			if(days>15){
				print_isVertical = false;
			}else{
				print_isVertical = true;
			}
         
            cur_days = days;
         
		 for(var i = 0 ;i < days;i++){
		 	   var sm =  myDate.formatDate(s2,"MM");
		 	   var sd =  myDate.formatDate(s2,"dd");
		 	   var s3 =  myDate.formatDate(s2,"MM/dd");
		 	   var s4 =  getFormatDay(myDate.formatDate(s2,"yyyy-MM-dd"),'ymd');
		 	   var s5 = myDate.formatDate(s2,"yyyy-MM-dd")
		 	   
			    var day ={sm:sm,sd:sd,dy:s3,dy2:s4,dy3:s5,wk:getDateWeek(s2)};
		 	   days2.push(day);
		 	   s2.setDate(s2.getDate()+1);
		 }
		 

		 

//   for(var i = 0 ;i < days2.length;i++){
//		 	        alert(days2[i]);
//		}            
 		  	var size = days2.length;
 		  	var s = 82/size+'';
				var w = s.replace(/(\.\d)\d+/ig,"$1")*1;
				var s2 = w*size+'';
				var w2 = s2.replace(/(\.\d)\d+/ig,"$1")*1;
				var oneWidth= 86-w2;
				oneWidth = oneWidth+'';
				oneWidth= oneWidth.replace(/(\.\d)\d+/ig,"$1")*1;
				
				
					var stylecss ='text-align:left;';
					var stylecss0 ='text-align:right;font-weight: bold;';
					var stylecss1 ='text-align:center;font-family: Arial, Helvetica, sans-serif;font-weight: bold;font-size: 8px;';
//					var stylecss2 ='text-align:right; font-family: Arial, Helvetica, sans-serif;font-weight: bold;font-size: 7pt;';
					var stylecss1 ='text-align:center;';
					var stylecss2 ='text-align:right;font-size: 8px;';
					var stylecss3 ='text-align:right;text-vlign:center;';
				
					
 

 		    gridParams.heads = "时段,描述,规定,";  
 		    gridParams.columnIds = "posTime,pos,stand,";
 		    gridParams.headsPrint = "时段,描述,规定,";
 		    gridParams.headsPrint2 = "0,0,0,";
 		    gridParams.widths = "4,"+oneWidth+",3,";
 		    gridParams.colTypes ="ed,ed,ed,";
 		    gridParams.colAlign ="left,left,center,";
 		    gridParams.colSorting ="str,str,str,";
 		    gridParams.attachHeader ="#rspan,#rspan,#rspan,";
 		    gridParams.attachHeader2 ="#rspan,#rspan,#rspan,";
 		    gridParams.displaySumColum ="0,0,0,";
 	
// 		    gridParams.attachFooter ="总使用:,#cspan,<div id='month_stand_time'/> , ";
//			gridParams.attachFooter2 ="饱和度:,#cspan,<div id='month_stand_time2'/> , ";
			gridParams.attachFooter ="总计:,#cspan,#cspan, ";
			gridParams.attachFooter2 ="总规定:,#cspan,#cspan, ";
			gridParams.attachFooter3 =hed1+":,#cspan,#cspan, ";
 
// 		    gridParams.attachFooter2 = new Array();
 		    gridParams.attachFooterStyle =stylecss0+","+stylecss1+","+stylecss1+",";
 		    
 		    gridParams.chartColoum=[];
 		     gridParams.chartColoum2=[];


// 		    gridParams.attachFooter2.push(stylecss);
// 		    gridParams.attachFooter2.push(stylecss1);
// 		    gridParams.attachFooter2.push(stylecss1);
 		    
 		
 		     
 		    
 		    for(var i = 0 ;i < size;i++){
 		    	
//		 		    	gridParams.heads +=days2[i].dy+",";
		 		    	gridParams.heads +=days2[i].sm*1+",";
		 		    	gridParams.headsPrint +=days2[i].dy+",";
		 		    	gridParams.chartColoum.push(days2[i].dy);
		 		    	gridParams.chartColoum2.push(i+3);
		 		    	
		 		    	gridParams.headsPrint2 +=days2[i].dy3+",";
		 		    	gridParams.widths +=w+",";
		 		    	gridParams.colTypes +="ed"+",";
		 		    	gridParams.colAlign +="right"+",";
		 		    	gridParams.colSorting +="int"+",";
		 		    	gridParams.attachHeader +=days2[i].sd+",";
		 		    	gridParams.attachHeader2 +=days2[i].wk+",";
						gridParams.displaySumColum +="0,";
						gridParams.columnIds += "dayTimes_"+days2[i].dy2+" ,";
		 		    	gridParams.attachFooter +="<div id='day_use"+ (i+1) +"' style='font-size:8px;'/>"+",";
		 		    	gridParams.attachFooter2 +="<div  style='font-size:8px;text-align:center;' id='day_total"+ (i+1) +"'/>"+",";
		 		    	gridParams.attachFooter3 +="<div  style='font-size:8px;text-align:center;' id='day_rate"+ (i+1) +"'/>"+",";
		 		    	gridParams.attachFooterStyle +=stylecss2+",";
//		 		    	gridParams.attachFooter2.push(stylecss);
 		    			}
 		    			
 		   
 		    			
				gridParams.heads +="总计,"+hed1+"";
				gridParams.headsPrint+="总计,"+ hed1 +"";
				gridParams.headsPrint2+="0,0";
				gridParams.widths +="4,3";
				gridParams.displaySumColum +="0,0";
				gridParams.colTypes +="ed,ed";
				gridParams.colAlign +="right,right";
				gridParams.colSorting +="sort_custom,int";
				gridParams.attachHeader +="#rspan,#rspan";
				gridParams.attachHeader2 +="#rspan,#rspan";
				gridParams.columnIds += "total_used,total_rate";
				
				
				gridParams.attachFooter +="<div  style='font-size:8px;text-align:center;' id='day_total_use'/>,#cspan";
				gridParams.attachFooter2 +="<div  style='font-size:8px;text-align:center;' id='day_total'/>,#cspan";
				gridParams.attachFooter3 +="<div  style='font-size:8px;text-align:center;' id='day_rate'/>,#cspan";
				gridParams.attachFooterStyle += stylecss2+","+stylecss2;
//				gridParams.attachFooter2.push(stylecss2);
//				gridParams.attachFooter2.push(stylecss2);
				

		 		    	
				return gridParams;
}

function getCahrtParams(){
	var paramObj = getParams();
	var gridParams = getGridParams();
	
	return cahrtParams;
}


function getAdvers(resourceId,publishDate,orgId){
//	$('CNZZ_AD_BOTTOM_').show();

		var dialogcontent = $("dialogcontentDiv");
		var dialogcontentW = dialogcontent.offsetWidth;
		var dialogcontentH = dialogcontent.offsetHeight; 
		var winW= dialogcontentW * 0.6;
		var winH = dialogcontentH*0.8;

// 		var paramObj =  getParams(); 
		var title = getTitle2(publishDate*1); 
		var urlStr =  getCtxPath()+"selectPopup/checkAdver.html?publishDate="+publishDate*1+"&workSpanId=0&resourceId="+ resourceId*1+"&orgId="+orgId;//$('CNZZ_AD_content_box').src=urlStr;
  
            
 	function removeWin(){winAdver.destroy();} 		
 	

    winAdver = new Ext.Window({
            	id:'moduleId',
            	title:title,
                 modal:true,
                layout:'fit',
                width:winW,
                height:winH,
                closeAction:'destroy',
                plain: true,

				x:myprint.getWinX(winW),
				y:myprint.getWinY(winH),
				minimizable:true,
				maximizable: false,
    			html:"<iframe id='openwin' src='"+ urlStr +"' scrolling='auto' style='width:100%;height:100%;margin:0;padding:0'></iframe>",  
                buttons: [{
                    text: '关闭',
                    handler: function(){
                        removeWin();
                    }
                }]
            });
//        }		
		 		
          		

   winAdver.show();
		
}


function sort_custom(a,b,order){ 
								if(order=="asc") return a>b?1:-1; else return a<b?1:-1; 
} 
							
function initGrid(model){

						var gridParams = getGridParams(model);  
						 

						if(!mygrid){
							
							


							function doOnEditCell(states,rowId,cellIndex){
								
//								console.log(mygrid.cells(rowId,cellIndex));
//								 mygrid.setCellTextStyle("row1",0,"color:red;border:1px solid gray;");
								var cln = mygrid.getColumnId(cellIndex);
								var resourceId = rowId;

								if(states == 0 && cln.indexOf('dayTimes') > -1 && resourceId >0){
		
									var value = mygrid.cells(rowId,cellIndex).getValue()==""?0:mygrid.cells(rowId,cellIndex).getValue();

									if(value != ''){
										var clumn2 = cln.split("_");
										var publishDate = clumn2[1];
										var name =  rowId +"_"+ publishDate*1;
									
//									    alert(mygrid.getUserData(rowId,name))
									    
//									     alert(mygrid.getUserData(rowId,"1242_20130802"))
									
										getAdvers(resourceId,publishDate,1);
									}
								}
								return false;
							}							
														
							
							 mygrid = new dhtmlXGridObject('gridbox');
							 mygrid.selMultiRows = true;
							 mygrid.setImagePath("image/grid/");
							 mygrid.setMultiLine(false);
//							 mygrid.setEditable(false);
//							 mygrid.setSkin("modern2");
							 mygrid.enableAlterCss("even","uneven"); 
							 mygrid.setOnEditCellHandler(doOnEditCell);
							
//							 mygrid.enableStableSorting(true); // true|false 
//			
	
						}
 



 
						mygrid.setHeader(gridParams.heads);
						mygrid.setColumnIds(gridParams.columnIds);
						mygrid.setInitWidthsP(gridParams.widths);
						mygrid.setColTypes(gridParams.colTypes);
						mygrid.setColAlign(gridParams.colAlign);
						mygrid.setColSorting(gridParams.colSorting) ;
						mygrid.setCustomSorting(sort_custom,0);
						
						mygrid.init();	 		
	 					mygrid.setSortImgState(true,0,"ASC"); 
	 					
					 	mygrid.clearAll();
					 
					 	mygrid.detachFooter(0);	
						mygrid.detachFooter(0);	
						mygrid.detachFooter(0);
					
//						mygrid.sortRows(0,sort_custom,"asc");    // sort by the sibling column
						mygrid.attachFooter(gridParams.attachFooter,gridParams.attachFooterStyle.split(','));		
						mygrid.attachFooter(gridParams.attachFooter2,gridParams.attachFooterStyle.split(','));		
						mygrid.attachFooter(gridParams.attachFooter3,gridParams.attachFooterStyle.split(','));		
						mygrid.attachHeader(gridParams.attachHeader,null,"_aHead");	
						mygrid.setSizes();	 	
						mygrid.attachHeader(gridParams.attachHeader2,null,"_aHead");		
						mygrid.setSizes();	 
		
						
						
						

}




function getParams(){

	var orgId = $("orgId").value;
	var seach_type = $("seach_type").value;
//	var comTimeSort= 	Ext.getCmp('unitss').getValue();
	var comTimeSort= 	$('unitss').value;
	
	 
	 
	var year = Ext.getCmp('year').getValue();
	var startDate = Ext.getCmp('start_date_query').getValue();
	var endDate = Ext.getCmp('end_date_query').getValue();

	startDate = myDate.myFormatDate(startDate,myDate.dateFormat);
	endDate = myDate.myFormatDate(endDate,myDate.dateFormat);   
	if(endDate =='') endDate = myDate.myFormatDate(def_Date_end,myDate.dateFormat);

//	var resourceIds =  Ext.getCmp('res_select_cmd').getValue();

	
//	var resourceIds =  Ext.getCmp('search_resource_tree').getAllCheckedIds(3).split('_').join(',');
	var resourceIds =  Ext.getCmp('search_resource_tree').getAllCheckedIds(3).split('_').join(',');
	

	
	var userIds =  Ext.getCmp('userId1').getValue();
	var customerIds = 	Ext.getCmp('customerName').getValue();
	var inWeekDates = Ext.getCmp('weekCheckBox').getCheckedValue();
	var orderCategoryIds = 	Ext.getCmp('orderCategoryId').getValue();
	




	var paramObj= {};

	paramObj.orgId = orgId;
	paramObj.loginUser = loginUser;
	paramObj.whereModel = 0;
	paramObj.displayModel = comTimeSort;

	paramObj.value1 = startDate;
	paramObj.value2 = endDate;
	paramObj.value3 = resourceIds;
	paramObj.value4 = userIds;
	paramObj.value5 = customerIds;
	paramObj.value6 = inWeekDates;	
	paramObj.value7 = orderCategoryIds;	
	paramObj.value8 = seach_type;	
	//合计行 
	paramObj.value9 = _gobal_colSumUsed.join(',');
	paramObj.value10 = _gobal_colSumTotal.join(',');
	paramObj.value11 = _gobal_colSumRate.join(',');
	
	paramObj.chartType = "queryAdres2";
	_gobal_query_param = paramObj;

	
	
	var title = getTitle1();
	DWRUtil.setValue("title",title);
    paramObj.title = title;
	return paramObj;
}

function loadGridData(){

	 initGrid();

// 	 Ext.getCmp('res_select_cmd').collapse();
 	Ext.getCmp('search_resource_cmd').collapse();
 
	 var paramObj =  getParams();
	 
	

//	 if(paramObj.value3 ==''){
//	 	 Ext.getCmp('res_select_cmd').onTriggerClick();  
//	 	 var rows= Ext.getCmp('res_grid_cmd').getSelectionModel().getSelections(); //获取所有选中行，
//	 	 if(rows == 0 || rows ==''|| rows ==null){
//	 	 	Ext.getCmp('carrier_cmd').onTriggerClick();  
//	 	 }
////	 	 Ext.getCmp('carrier_cmd').onTriggerClick();  
////	 	 extjMessage('没有选择广告资源!');
//	 	 return false;
//	 }
	 
	 var queryString =  $H(paramObj).toQueryString();	

	function callBackFun(xml){
                
				mygrid.clearAll();
				mygrid.loadXMLString(xml,calculateFooterValues);
				mygrid.setSizes();	 
				Ext.getBody().unmask();
	

    }
    
    queryWindow.hide();
	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	resource.getResourcesForQueryXml(queryString,1,callBackFun);
	
}
 
//function calculateFooterValues(){
//		var comTimeSort= 	Ext.getCmp('unitss').getValue();
//		
////        var nrQ = document.getElementById("month_stand_time");
////        nrQ.innerHTML = sumColumn(2,comTimeSort); 
//
//        var srQ = document.getElementById("day_total_use");
//        srQ.innerHTML = sumColumn(cur_days+3,comTimeSort);
//        
////         var srQ = document.getElementById("sr_q");
////        srQ.innerHTML = sumColumn(cur_days+4);       
//
//        for(var i=0;i< cur_days;i++){ 
//        	var el = $("day_use"+(i+1));
//        	el.innerHTML = sumColumn(i+3,comTimeSort);
//        }
//        
//		mygrid.sortRows(0,sort_custom,"asc");    // sort by the sibling column
//        
//        setCellColor();
//        
//        
//        
//        return true;
//}


function setCellColor(){
	
	  for(var i=0;i< mygrid.getRowsNum();i++){
	  	 var rowId = mygrid.getRowId(i);

	  	 for(var j=3;j< mygrid.getColumnsNum()-2;j++){
	  	 	var value = mygrid.cells(rowId,j).getValue()==""?0:mygrid.cells(rowId,j).getValue();

	  	 	if(value !=0){
	  	 		var cln = mygrid.getColumnId(j);
				var clumn2 = cln.split("_");
				var publishDate = clumn2[1];
				var name =  rowId +"_"+ publishDate*1;
				var name2 =  name+"_used";
				var name3 =  name+"_leave";
				var dayStandard = mygrid.getUserData(rowId,name);
				var usedTime = mygrid.getUserData(rowId,name2);
	  	 		var leave = mygrid.getUserData(rowId,name3);
                var color = "black";
                var font = "";
				if(leave < 0){
					color = "red";
					font = "underline";
				}
				if(leave > 0 && usedTime>0){color = "green";}
				if(leave == 0){font = "line-through";}
				
				
//				if(dayStandard - usedTime == 0 && usedTime>0){color = "black";}
				mygrid.cells(rowId,j).setTextColor(color);
				mygrid.cells(rowId,j).cell.style.textDecoration = font;
				
//				mygrid.cells(rowId,j).setFont("TEXT-underline");
				
		
				
	  	 	}
	  	 }
	  	
	 
	  }
}


function calculateFooterValues(){

//		var comTimeSort= 	Ext.getCmp('unitss').getValue();
		var comTimeSort= $("unitss").value;

		var temMap = 	 sumColumn();
		var map1 = temMap.get(1);
		var map2 = temMap.get(2);
		
		var arr1 = temMap.get(1);
		var arr2 = temMap.get(2);		

        var sumArrUsed = new Array();
        var sumArrTotal = new Array();
        
        
        _gobal_colSumUsed = new Array();
 		_gobal_colSumTotal = new Array();
	 	_gobal_colSumRate = new Array();
        
        for(var i =0;i<3;i++){
        	if(i == 1){
	        	 _gobal_colSumUsed.push('总计:');
	        	 _gobal_colSumTotal.push('总规定:');
	        	 _gobal_colSumRate.push('比例');
        	}else{
	        	 _gobal_colSumUsed.push('');
	        	 _gobal_colSumTotal.push('');
	        	 _gobal_colSumRate.push('');
        	}

        }
        
        
        for(var i=0;i< cur_days;i++){ 
        	var el = $("day_use"+(i+1));
        	var e2 = $("day_total"+(i+1));
        	var v1 = arr1[i+3];
        	var v2 = arr2[i+3];
			v1 = isDigit(v1)?v1:0;
        	v2 = isDigit(v2)?v2:0;
        	sumArrUsed.push(v1);
        	sumArrTotal.push(v2);
        	
        	var el_v =  "";
        	var e2_v =  "";
        	if(comTimeSort == 1){
           	 el_v =  isDigit(v1) && v1 >0  ?myUtils.FormatDateTime(v1):"";
        	 e2_v =  isDigit(v2) && v2 >0 ?myUtils.FormatDateTime(v2):"";
        	}else{
           	 el_v =  isDigit(v1) && v1 >0 ?v1:"";
        	 e2_v =  isDigit(v2) && v2 >0 ?v2:"";
        	}


        	el.innerHTML =  el_v;
        	e2.innerHTML =   e2_v;
        	
             _gobal_colSumUsed.push(el_v);
        	 _gobal_colSumTotal.push(e2_v);   	
        	
        }
        
         for(var i = 0;i<sumArrTotal.length;i++){
         	 var vv1 =  sumArrUsed[i]; 
         	 vv1 = (vv1=='')?0:vv1;
         	 var vv2 =  sumArrTotal[i]; 
         	 vv2 = (vv2==''||vv2==0)?1:vv2;
         	 var e3_v =  isDigit(vv1) &&  isDigit(vv2) && vv1 > 0?ForDight((vv1/vv2)*100,0)+"%":"";
	         document.getElementById("day_rate"+(i+1)).innerHTML = e3_v;
	          _gobal_colSumRate.push(e3_v);   
        }        
        
        
        var vv =0;
        for(var i = 0;i<sumArrUsed.length;i++){
        	var test =  sumArrUsed[i];
        	vv += isDigit(test)?test:0;
        }
		var srQ = document.getElementById("day_total_use"); 
		var srQ_v1 =  isDigit(vv) && vv>0 ?myUtils.FormatDateTime(vv):"";    
        srQ.innerHTML =  srQ_v1;
        
        var vv2 =0;
         for(var i = 0;i<sumArrTotal.length;i++){
         	var test =  sumArrTotal[i];
        	vv2 += isDigit(test)?test:0;
        }
		var srQ = document.getElementById("day_total");
		var srQ_v2 = isDigit(vv2)&& vv2>0?myUtils.FormatDateTime(vv2):""; 
        srQ.innerHTML =   srQ_v2


        var srQ = document.getElementById("day_rate");
        vv2 = vv2==''||vv2==0?1:vv2;
        var srQ_v3 =isDigit(vv) &&  isDigit(vv2) && vv > 0?ForDight((vv/vv2)*100,0)+"%":"";  
        srQ.innerHTML =   srQ_v3;
        
        

        _gobal_colSumUsed.push(srQ_v1);
        _gobal_colSumTotal.push(srQ_v2);
        _gobal_colSumRate.push(srQ_v3);       
        _gobal_colSumUsed.push(' ');
        _gobal_colSumTotal.push(' ');
        _gobal_colSumRate.push(' ');           

//		mygrid.sortRows(0,sort_custom,"asc");    // sort by the sibling column
        
        
        
        setCellColor();
        
        
        
        return true;
}
 function sumColumn(){
	    var seach_type = $("seach_type").value*1;
         var out = 0;
         var  temMap = new HashMap();
         var colSumUsed = new Array();
         var colSumTotal = new Array();
         
	     for(var i=0;i< mygrid.getRowsNum();i++){
	     	
		  	 var rowId = mygrid.getRowId(i);
	
		  	 for(var j=3;j< mygrid.getColumnsNum()-2;j++){

		  	 	var value = mygrid.cells(rowId,j).getValue()==""?0:mygrid.cells(rowId,j).getValue();
	
//		  	 	if(value !=0){
		  	 		var cln = mygrid.getColumnId(j);
					var clumn2 = cln.split("_");
					var publishDate = clumn2[1];
					var name =  rowId +"_"+ publishDate*1;
					var name2 =  name+"_used";
					var name3 =  name+"_leave";
					var totalTime = mygrid.getUserData(rowId,name);
					var usedTime = mygrid.getUserData(rowId,name2);
		  	 		var leave = mygrid.getUserData(rowId,name3);
		  	 		
		  	 		if(seach_type == 2) usedTime = leave;

 					colSumUsed[j]= 	colSumUsed[j]?colSumUsed[j]:0;	
 					colSumUsed[j] += parseFloat(usedTime);
 					
  					colSumTotal[j]= 	colSumTotal[j]?colSumTotal[j]:0;	
 					colSumTotal[j] += parseFloat(totalTime);					
 					
//		  	 	}
		  	 }
	     }
        if(out >0){
        	 out = myUtils.FormatDateTime(out);
        }else{
        	out ='';
        }
        
//        temMap.put("1",colSumUseMap);
//        temMap.put("2",colSumTotalMap);
         temMap.put("1",colSumUsed);
        temMap.put("2",colSumTotal);       
        return temMap;
 }   
//function sumColumn(ind,comTimeSort){
//
//        var out = 0;
//        for(var i=0;i< mygrid.getRowsNum();i++){
//        	
//       		var value = mygrid.cells2(i,ind).getValue()==""?0:mygrid.cells2(i,ind).getValue();
//       		
//       		if(cur_days+3 == ind){
//       			if(comTimeSort == 1){
//       				if(value !=0){
//		       			 var values = (value+'').split(':');
//		       			 value = values[0]*3600 + values[1]*60 + values[2]*1; 
//		       			 out+= parseFloat(value)
//       				}
//       			}else{
//       				 out+= parseFloat(value);
//       			}	       	    
//       		}else{
//	       	    if(comTimeSort == 1){
//	       	    	if(value !=0){
//	       	    		 var values = (value+'').split('\'');
//	       	    	 	 value = values[0]*60+values[1].substring(0,2)*1; 
//	       	    	 	 out+= parseFloat(value);
//	       	    	}
//	       	    }else{
//	       	    	  out+= parseFloat(value);
//	       	    }
//
//       		}
//       		
//
//          
//        }
//        
//        if(out >0){
//        	 out = myUtils.FormatDateTime(out);
//        }else{
//        	out ='';
//        }
//       
//        
//        return out;
// }







function resetStore(){
	
	var orgId =   $("orgId").value;
	var version =  Ext.getCmp('year').getValue();

    var dateField_start = Ext.getCmp('start_date_query');
    var dateField_end = Ext.getCmp('end_date_query');
    
    var startDate =    dateField_start.getValue();
    var endDate =    dateField_end.getValue();

	  var myDate=new Date();
	  myDate.setFullYear(version,startDate.getMonth(),startDate.getDate());
	  dateField_start.setValue(myDate); 
	  var myDate=new Date();
      myDate.setFullYear(version,endDate.getMonth(),endDate.getDate());
	  dateField_end.setValue(myDate); 	
	  
	var cmd1 =  Ext.getCmp('orderCategoryId');
	var store1 = cmd1.getStore();
	store1.baseParams.dwrParams[0].orgId = config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;	
	store1.baseParams.dwrParams[0].version = version;
	store1.reload();
	cmd1.clearValue(); 	  
	
	var cmd2 =  Ext.getCmp('customerName');
	var store2 = cmd2.getStore();
	store2.baseParams.dwrParams[0].orgId =  config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;
	store2.reload();
	cmd2.clearValue(); 	
	
	var cmd3 =  Ext.getCmp('userId1');
	var store3 = cmd3.getStore();
	if(store3.baseParams){
		if(store3.baseParams.dwrParams){
			store3.baseParams.dwrParams[0].orgId =  $("orgId").value;
			store3.reload();
			cmd3.clearValue(); 	 			
		}
	}
	
	
//	var cmd4 =  Ext.getCmp('carrier_cmd');
//	var store4 = cmd4.getStore();
//	if(store4.baseParams){
//		if(store4.baseParams.dwrParams){
//			store4.baseParams.dwrParams[0].orgId =  $("orgId").value;
//			store4.reload();
//			cmd4.clearValue(); 	 			
//		}
//	}	
//	
//	var cmd5 =  Ext.getCmp('resourceSort_cmd');
//	var store5 = cmd5.getStore();
//	if(store5.baseParams){
//		if(store5.baseParams.dwrParams){
//			store5.baseParams.dwrParams[0].orgId =  $("orgId").value;
//			store5.reload();
//			cmd5.clearValue(); 	 			
//		}
//	}		
	
//	resetResourceStore();
	rest_resource_tree();
	

 
}




function showSearchWin(){
	
	
   var test = false;
	if(!queryWindow){
// 	test = true;
	var items = new Array();
	
	var my_cur_year =_app_params.serviceDate.year;
//	var comTimeSort = myUtils.getComTimeSort('unitss','统计单位',180,1);  	

	var comYear = myUtils.getComYear('year','年份',180,my_cur_year,null, _app_params.serviceDate.adrmSysYear);  	
	comYear.on("select" , function(box){resetStore();});	

	var def_start_Dat =   myDate.parseDate(getFormatDay(_app_params.serviceDate.format2,"y-m-d"));
	var def_end_Dat =   myDate.parseDate(getFormatDay(_app_params.serviceDate.format2,"y-m-d"));
	def_end_Dat.setDate(def_end_Dat.getDate()+ def_show_win_init_days);
	
	function close_res_list(){
//		Ext.getCmp('res_select_cmd').collapse();
		Ext.getCmp('search_resource_cmd').collapse();
	}
	

	var startDateFileld =  new Ext.form.DateField({
	        fieldLabel : '开始日期',
	        id : 'start_date_query',
	        enableKeyEvents : true,
	        width : 180,
	        allowBlank : false,    
	        format : 'Y-m-d',
//	       	value:myDate.getStartDay3(def_Dat,"yyyy-MM-dd")
	       	value:def_start_Dat
	       });  
  


//	def_end_Dat.setDate(def_end_Dat.getDate()+7);
	var endDateFileld =  new Ext.form.DateField({
	        fieldLabel : '结束日期',
	        id : 'end_date_query',
	        enableKeyEvents : true,
	        width : 180,
	        allowBlank : false,    
	        format : 'Y-m-d',
//	       	value: myDate.getEndDay3(def_Dat,"yyyy-MM-dd")
	       	value: def_end_Dat
	       });  
	       


 var weekCmd = this.myprint.getWeekCheckBox(null,"weekCheckBox","星期",180,"");
 weekCmd.on("focus" , function(box){close_res_list()});
 

	orderCategory.obj.orgId = config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;	
 	orderCategory.obj.version = comYear.getValue();
	var categoryCommand  =	orderCategory.makeSubCategoryFromOrder(null,"orderCategoryId",180,'remote',function(){});	

	var customerCommand  = getCustomerCmd('customerName','userId1',false);
	var userCommand = getUserCmd('customerName','userId1',false);  
	
	
//	var comboxGrid = getComBoxGrid();
	resource.obj.version = comYear.getValue();
    var comboxGrid = resource.getResourceCmdTree(orderCategory.obj.orgId,resource.obj,'search_resource_cmd','search_resource_tree',true,null,'resourceId','选时段...',180,true,false,true,function callFunction(){});
	
//	items.push(comTimeSort);
	items.push(comYear);
	items.push(startDateFileld);	
	items.push(endDateFileld);	 
	items.push(weekCmd);	 
//	items.push(channelCmd);	
//	items.push(carrierCmd);	
		items.push(comboxGrid);
//	items.push(resourceSortCmd);	
//	items.push(resourceCmd);	
	items.push(categoryCommand);	
	items.push(customerCommand);	 
	items.push(userCommand);	

	
	
  var fromPannel = new Ext.FormPanel({   
				xtype:'tabpanel',
                labelWidth: 75, 
                frame:true,   
                title: '',  
                bodyStyle:'padding: 0',   
                width: 350,   
                labelSeparator:'',   
                items: items
				});  	   	

   

    	
		queryWindow = new Ext.Window({
				    title:'查询单据',
				    width:560,
				    height:455,
				    modal:true,
				    closeAction:'hide',
				    layout:'fit',
				    buttons:[
				    			{text:'确定',handler:function(){ 
				    				
//				    				Ext.getCmp('res_select_cmd').collapse();
				    				Ext.getCmp('search_resource_cmd').collapse();
				    				
				    				
				    				
				    				queryWindow.hide();
				    				
				    				if(queryWindow.query_model == 1){
				    					loadGridData();
				    				}else{
				    					printReport(queryWindow.query_model);
				    				}
				    				
				    				
				    				}},
								{text:'重置',handler:function(){fromPannel.form.reset();}},
								{text:'关闭',handler:function(){queryWindow.hide();
								
//								Ext.getCmp('res_select_cmd').collapse(); 
								Ext.getCmp('search_resource_cmd').collapse();
								
								}}
				            ],
						items:fromPannel  
		});	
		
		
		
    }


 queryWindow.show(this);
 queryWindow.query_model = 1;
 
// if(test){
//  	 Ext.getCmp('res_select_cmd').onTriggerClick(); 
//     Ext.getCmp('carrier_cmd').onTriggerClick();  	
// }else{
// 	 Ext.getCmp('res_select_cmd').onTriggerClick(); 
// }

 

 
 

}


function getCustomerCmd(el_id,el_uid,noSearch){
	
      customer.obj.orgId = config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;	
//	    customer.storeCustomer = customer.getStoreCustomersAnalyze('remote',customer.obj);   
				var customerCmp =  Ext.getCmp(el_id);
				var storeCustomer = customer.getStoreCustomersAnalyze('remote',customer.obj);   
				
	    if(!customerCmp){
			 
				 	customerCmp =new Ext.form.ClearableComboBox({
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
						  allowBlank:true,
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
					 });
	    } 

			customerCmp.on("select" , function(box)
		    {
		    	if(noSearch){resetUserCom(el_id,el_uid);}
				Ext.getCmp(el_uid).onTriggerClick(); 
		    });
		    
	    return customerCmp;
	 			
}



function getUserCmd(el_cutId,el_uid,noSearch){
	
	var cutcmd =  Ext.getCmp(el_cutId);

     user.obj.orgId = $("orgId").value;	

     if(cutcmd){ 
     	 var customerId =   cutcmd.getValue();	
     	  if(customerId>0){user.obj.username =   customerId}
	}

      user.storeUser = user.getStoreUsersAnalyze('local',user.obj);
      user.storeUser2 = user.getStoreUsersAnalyze('remote',user.obj);

     var userCmd =  Ext.getCmp(el_uid);
     
     if(!userCmd){
     	
			    userCmd  =    new Ext.form.ClearableComboBox({
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
		    });
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
								resetUserCom(el_cutId,el_uid);							
						}
		    });           
 
		return userCmd;
 
}




function resetUserCom(el_cutId,el_id){

	var cutcmd =  Ext.getCmp(el_cutId);
	var usercmd =  Ext.getCmp(el_id);
	var fun = function(box){usercmd.setValue('');}  

    usercmd.clearValue(); 
    user.obj.orgId = $("orgId").value;
     
   if(cutcmd){ 
     	 var customerId =   cutcmd.getValue();	
     	 if(customerId>0){user.obj.username =   customerId;	}
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



//function resetResourceStore(){
//	var cmd6 =  Ext.getCmp('resource_cmd');
//	var store6 = cmd6.getStore();
//	if(store6.baseParams){
//		if(store6.baseParams.dwrParams){
//			var sortId = Ext.getCmp('resourceSort_cmd').getValue()== ""?null: Ext.getCmp('resourceSort_cmd').getValue();
//			store6.baseParams.dwrParams[0].orgId =  config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;	
//			store6.baseParams.dwrParams[0].version =   Ext.getCmp('year').getValue();
//			store6.baseParams.dwrParams[0].carrierId =   Ext.getCmp('carrier_cmd').getValue()== ""?null: Ext.getCmp('carrier_cmd').getValue();
//			store6.baseParams.dwrParams[0].resourceSort = sortId;
//
//			var cmd7 =  Ext.getCmp('resource_start_cmd');
//			var store7 = cmd7.getStore();
//			Ext.apply(store7,store6);	
//			store6.reload();
//			cmd6.clearValue(); 	 
////					resource.getFitterStore(store6,sortId);		
//		}
//	}	
//}


function rest_resource_tree(){
	var resource_year = Ext.getCmp('year').getValue();
//	var startDate = Ext.getCmp('start_date_query').getValue();
//	var endDate = Ext.getCmp('end_date_query').getValue();
//	startDate = myDate.myFormatDate(startDate,myDate.dateFormat);
//	endDate = myDate.myFormatDate(endDate,myDate.dateFormat);  
	
	 var cmdRes = Ext.getCmp('search_resource_tree');
	 if(cmdRes) {
		 cmdRes.loader.params.orgId = $("orgId").value;
		 cmdRes.loader.params.version = resource_year;
		 resource.obj.version = resource_year;
		 cmdRes.root.attributes.version = resource_year;
	 	 cmdRes.root.reload();
	 	 mygrid.clearAll();
	 }
	
	 
	 
}




function getComBoxGrid(){
	


	var sm = new Ext.grid.CheckboxSelectionModel();
//	var cm = new Ext.grid.ColumnModel([  
//	 sm,
//  {header:'编号',dataIndex:'id',menuDisabled:false, filterable: true},  
//  {header:'性别',dataIndex:'name',menuDisabled:false,filterable: true},  
//  {header:'名称',dataIndex:'descn',menuDisabled:true},  
//  {header:'描述',dataIndex:'date',menuDisabled:true}  
// ]); 

    
// var store = new Ext.data.Store({  
//        proxy: new Ext.data.HttpProxy({url:ctxPath+'samples/json/8.jsp'}),  
//        reader: new Ext.data.JsonReader({  
//            totalProperty: 'totalCount',  
//            root: 'items',  
//            id:id  
//        }, [  
//          {name: 'id', type: 'int'},  
//          {name: 'name', type: 'string'},  
//          {name: 'descn', type: 'string'},  
//          {name: 'date', type: 'string'}  
//        ]),  
//        baseParams:{  
//         start:0,limit:100  
//        }  
//    });   
    
    
	carrier.obj.callback = function aa(){};
	carrier.obj.orgId =  config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;
	var carrierCmd = carrier.getLovCombo3('carrier_cmd',120,'remote',false,'频道名称','请选择频道...' );  
	carrierCmd.on("select" , function(box){resetResourceStore();});		
	carrierCmd.on("clear" , function(box){resetResourceStore();});		
         
    resourceSort.obj.orgId =  config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;	
	var resourceSortCmd  = resourceSort.getResourceSortCmd('resourceSort_cmd','remote',90,'时段属性','时段属性...');
	resourceSortCmd.on("select" , function(box){resetResourceStore2(0);});		
 	resourceSortCmd.on("clear" , function(box){resetResourceStore2(-1);});		
 	

 	
	resource.obj.orgId =  config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;	
	resource.obj.version = Ext.getCmp('year').getValue();
	resource.obj.carrierId =  Ext.getCmp('carrier_cmd').getValue() == ""?null: Ext.getCmp('carrier_cmd').getValue();
	resource.obj.resourceSort = resourceSortCmd.getValue() == ""?null:resourceSortCmd.getValue();
	
	
	
	var resourceCmd  = resource.getResourceCmd('resource_cmd','local',180,'时段名称','请选择...');	
	var store = resourceCmd.getStore();
	var storeBak = new Ext.data.Store();	
	Ext.apply(storeBak,store);	
	var store1 = new Ext.data.Store();
	Ext.apply(store1,store);
	var resourceStartCmd  = resource.getResourceTimeCmd(store1,'resource_start_cmd','local',70,'开播时间','开播时间...');	
	var resourceEndCmd  = resource.getResourceTimeCmd(store1,'resource_end_cmd','local',70,'结束时间','结束时间...');	
	store.on("load" , function(box){resetResourceStore2(-1);});	
	
	
	function resetResourceStore2(i){

			
			if(i == -1){
					var sortId = resourceSortCmd.getValue();
					Ext.apply(store,storeBak);	
					Ext.apply(store1,storeBak);	
					resource.getFitterStore(store,sortId);		
					resetBrocatTime(store);
			}		
			if(i == 0){
					var sortId = resourceSortCmd.getValue();
					resource.getFitterStore(store,sortId);		
					resource.getFitterStore(store1,sortId);		
					resetBrocatTime(store1);
			}		


			if(i == 1){
					var sortId = resourceSortCmd.getValue();
					var min = resourceStartCmd.getValue();
					var max = resourceEndCmd.getValue();
					resource.getFitterStore(store,sortId,min,max);			
			}		
			
			
			if(i == 2 ||i == 3){
					var sortId = resourceSortCmd.getValue();
					var min = 0;
					var max = 0;
					
					Ext.apply(store,storeBak);	
					resource.getFitterStore(store,sortId);		
					Ext.apply(store1,store);	
					resetBrocatTime(store,i);
					var min = resourceStartCmd.getValue();
					var max = resourceEndCmd.getValue();	
					resource.getFitterStore(store,sortId,min,max);										
			}				

	}

	resourceStartCmd.on("select" , function(box){resetResourceStore2(1);});	
	resourceEndCmd.on("select" , function(box){resetResourceStore2(1);});
	resourceStartCmd.on("clear" , function(box){resetResourceStore2(2);});
	resourceEndCmd.on("clear" , function(box){resetResourceStore2(3);});


	
	
	function getMinMaxTime(store ,i){
		var min = 1000000;
		var max = 0;
		var v = 0;
		store.each(function(record) {
					var vv = record.get('broadcastStartTime');
		    if(i == 1){
						min = vv < min?vv:min;  v= min;    
					}else{
						max = vv > max?vv:max;   		v= max;      		  	
		  		  }
		});
		
		return v;
	}
	
	function resetBrocatTime(store,i){

				var min = getMinMaxTime(store,1);
				var max = getMinMaxTime(store,2);
				if(i){
						if(i ==2){
							 resourceStartCmd.setValue(min);
						}else{
								resourceEndCmd.setValue(max);
						}
				}else{
						resourceStartCmd.setValue(min);
						resourceEndCmd.setValue(max);
				}

		
	}

	store.on("load" , function(store,recs,opts){resetBrocatTime(store)});		
	
//	var okBtn ={text: '确定',idth : 30,handler: function(){Ext.getCmp('res_select_cmd').collapse();}};	
	var closeBtn ={text: '关 闭',xtype:'button',iconCls:'admin-tool-delete',handler: function(){ 
		
//		Ext.getCmp('res_select_cmd').collapse();
		Ext.getCmp('search_resource_cmd').collapse();
		
	}};
//	var searchBtn = {text:'查询',handler:function(){ loadGridData();}};

	var cm = new Ext.grid.ColumnModel([  
	 sm,
	 {header:'播出时间',dataIndex:'broadStartTimeS',menuDisabled:true,width:70,filterable: true},
//  {header:'播出时间',dataIndex:'broadcastT',menuDisabled:true, filterable: true},  
  {header:'段位',dataIndex:'resourceName',menuDisabled:true,filterable: true,width:200},  
  {header:'描述',dataIndex:'memo',menuDisabled:true,filterable: true,width:145}
 ]); 	
 
 

          
 var c = new Ext.form.ComboBox({  
 		id : 'res_select_cmd',  
 		name : 'res_select_cmd', 
 		gridId : 'res_grid_cmd',   
//    typeAhead : false,  
//    forceFit:true,
    fieldLabel : '时段名称',  
    hiddenName : 'id',  
    hideOnSelect:false,
    editable: false,
    triggerAction : 'all',  
    lazyRender : true,  
    forceSelection:true,
    typeAhead: true,
    width:180,  
    listWidth:450,
    displayField:'name',  
    valueField:'id',  
    store:store,  
    mode : 'local',  
    listClass : 'x-combo-list-small',  
    selectedClass:'',   
    allowBlank : false,  
    emptyText:'请选择...',
    tbar:[carrierCmd,resourceSortCmd,resourceStartCmd,resourceEndCmd,closeBtn],

//	bbar:[{text:'查询',handler:function(){ loadGridData();}},{text:'关闭',handler:function(){queryWindow.hide(); }}],    

//	filters:filters,
			sm:sm,  
    cm:cm,  
//    paging:true,  
    onSelect:function(record,rowIndex){  
     c.setValue(record.get("id"));  
     c.setRawValue(record.get("name"));  
    },  
    plugins : [new Ext.plugins.GridCombox()]  
   });    
   

   
	c.on("collapse" , function(box){
			var rows= Ext.getCmp('res_grid_cmd').getSelectionModel().getSelections(); //获取所有选中行，
		var str = '';
	   for(var i=0;i <rows.length;i++){
	    	if(i <rows.length-1){
	    		str = str + rows[i].get('id') + ',';
			}else{
	    		str = str + rows[i].get('id');
	    	}
	    }
	
	 if(rows.length == 1) str = str +','
		
	   var res_select_cmd =  Ext.getCmp('res_select_cmd');
	   res_select_cmd.setValue(str);
   	});		
   
	
	
	return c;

}


//function printReport(mode){
////	 var s=['view','print','excel'];
//
//	if(mode =="view"){
//		button_print('view');
//	}
//	if(mode =="print"){
//		{button_print('print');
//	}
//	if(mode =="excel"){
//		button_print('export');
//	}
//	
//	if(mode =="chart"){
//		getFusionChartObjs();
//	}	
//	if(mode =="query"){
//	  Ext.onReady(function(){showSearchWin();});
//	}	   
//}

function getTitle1(){
	    var seach_type = $("seach_type").value*1;
		var startDate = Ext.getCmp('start_date_query').getValue();
		var endDate = Ext.getCmp('end_date_query').getValue();
		startDate = myDate.myFormatDate(startDate,myDate.dateFormat);
		endDate = myDate.myFormatDate(endDate,myDate.dateFormat);  
		
		
		var temp = seach_type ==1?"占用":"剩余";
//		var  title1 = Ext.getCmp('carrier_cmd').getRawValue()+'时段'+temp +"时间";
		var  title1 ='时段'+temp +"时间";
        var  titleSub = "(" + getFormatDay(startDate,"y-m-d") +"至"+ getFormatDay(endDate,"y-m-d") +")";
		var  title = title1+"  "+titleSub;
		return title;
}

function getTitle2(publishDate){
//		var  title1 = Ext.getCmp('carrier_cmd').getRawValue()+'播出的广告';
		var  title1 = "";
        var  titleSub = "(" + getFormatDay(publishDate +'',"y-m-d")  +")";
		var  title = title1+"  "+titleSub;
		return title;
}

function printReport(model){
	
	
	function check(paramObj,query_model){
		 if(paramObj.value3 ==''){
		 	 queryWindow.show(this);
		 	 queryWindow.query_model = model;
		 	 Ext.getCmp('res_select_cmd').onTriggerClick();  
		 	 var rows= Ext.getCmp('res_grid_cmd').getSelectionModel().getSelections(); //获取所有选中行，
		 	 if(rows == 0 || rows ==''|| rows ==null){
		 	 	Ext.getCmp('carrier_cmd').onTriggerClick();  
		 	 }
		 	 return false;
		 }else{
		 	return true;
		 }
	}

	if(model =="query"){
		 Ext.onReady(function(){showSearchWin();});
		 
	}else if(model =="chart"){

		var paramObj = getParams();
		var paramObjGrid = getGridParams();
		
//		if(!check(paramObj,3)){
//			 return false;
//		}
		
		chartParam = {
			model:  1,
			title:paramObj.title,
			chartType: "queryAdres2",
			defChartType:"scrollcombidy2d",
			defFontSie:12,
			defcolunmCheck:paramObjGrid.chartColoum.join(','),
			FCharts_LabelsData_cols : paramObjGrid.chartColoum.join(','),
			FCharts_LabelsData_parentYAxisP : paramObjGrid.chartColoum2.join(','),
			FCharts_LabelsData_parentYAxisS :""
		}; 	
		
		var chartParams = Object.extend(paramObj,chartParam);		
		
		module_chart_service_win = get_analyze_chart_win(ctxPath,chartParams);
		module_chart_service_win.show(this);
		
//		var resetChatPageFun =document.getElementById('open_chart_win_fram').contentWindow.resetHeigth;
//		Ext.EventManager.onWindowResize(resetChatPageFun, module_chart_service_win); //window大小改变时，重新设置坐标
		
	}else{
		if(model =="excel"){
			mygrid.toExcel(ctxPath + 'servlet/dhtmlExcelGeneratorServlet');
			return false;
		}
		
		
		var paramObj = getParams();
		var paramObjGrid = getGridParams();
		var title = getTitle1();

//		if(!check(paramObj,2)) return false;
		


		printParam = {
							model:  model,
						 	title:title,
			                reportType: "queryAdres2",
			                reportFile:'',
			                headers:paramObjGrid.headsPrint,
			                headers2:paramObjGrid.headsPrint2,
			                displaySumColum:paramObjGrid.displaySumColum,
			                colAlign:paramObjGrid.colAlign,
			                colTypes:paramObjGrid.colTypes,
			                widthsP:paramObjGrid.widths,
			                fontSize:8,
			                isSum:false,
			                isVertical:false
		}; 	
		
		var a = Object.extend(paramObj,printParam);
		
		
	
	    myprint.loadApplet(a,ctxPath,800,500);	
	}
	
}



	