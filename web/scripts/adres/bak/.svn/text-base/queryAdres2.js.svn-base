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
	myUtils = new MyUtils(config_serviceDate);
	_make_org_select("orgId",100,"resetStore");	
	
	this.myprint.buildButtons2(this,"printReportDiv",[0,1,2,8],60);
	

	
//	buttonEventFill();

   showSearchWin();
    
//	 initGrid();
	
}

function resetHeigth(){
    var dialogcontent = $("dialogcontentDiv");
    var gridbox = $("adResCount");
    gridbox.style.height = dialogcontent.offsetHeight * 0.85 +"px";	
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
		case 0:dateweek += "周日";break;
		case 1:dateweek += "周一";break;
		case 2:dateweek += "周二";break;
		case 3:dateweek += "周三";break;
		case 4:dateweek += "周四";break;
		case 5:dateweek += "周五";break;
		case 6:dateweek += "周六";break;
		}
return dateweek;

}








function getGridParams(){
	
			var gridParams ={};
		
			var dateField_start = Ext.getCmp('start_date_query');
 			var dateField_end = Ext.getCmp('end_date_query');
 			
 			var s1;
			var s2;
						
 			if(!dateField_start){
					 s1 =   myDate.parseDate(getFormatDay(_app_params.serviceDate.format2,"y-m-d"));
					 s2 =   myDate.parseDate(getFormatDay(_app_params.serviceDate.format2,"y-m-d"));
					 s1.setDate(s1.getDate()+7);
 			}else{
					 s1 = dateField_end.getValue();
					 s2 = dateField_start.getValue();
 			}
 			

			
			
			var time= s1.getTime() - s2.getTime();  
			var days = parseInt(time / (1000 * 60 * 60 * 24));  
			var days2 = new Array();
			
		

			
			
			if(days < 0){
				alert("结束日期不能小于开始日期!");return false;
			}
			

		 for(var i = 0 ;i < days;i++){
		 	   var s3 =  myDate.formatDate(s2,"MM/dd");
					var day ={dy:s3,wk:getDateWeek(s2)};
		 	   days2.push(day);
		 	   s2.setDate(s2.getDate()+1);
		 }
		 

		 

//   for(var i = 0 ;i < days2.length;i++){
//		 	        alert(days2[i]);
//		}            
 		  	var size = days2.length;
 		  	var s = 70/size+'';
				var w = s.replace(/(\.\d)\d+/ig,"$1")*1;
				var s2 = w*size+'';
				var w2 = s2.replace(/(\.\d)\d+/ig,"$1")*1;
				var oneWidth= 80-w2;
				oneWidth = oneWidth+'';
				oneWidth= oneWidth.replace(/(\.\d)\d+/ig,"$1")*1;
				
				
					var stylecss ='text-align:left;'
					var stylecss1 ='text-align:center;font-family: Arial, Helvetica, sans-serif;font-weight: bold;font-size: 7pt;'
					var stylecss2 ='text-align:right; font-family: Arial, Helvetica, sans-serif;font-weight: bold;font-size: 7pt;'
 

 		    gridParams.heads = "时段,段位描述,规定,";
 		    gridParams.widths = "5,"+oneWidth+",4,";
 		    gridParams.colTypes ="ed,ed,ed,";
 		    gridParams.colAlign ="left,left,center,";
 		    gridParams.colSorting ="str,str,str,";
 		    gridParams.attachHeader ="#rspan,#rspan,#rspan,";
 		    gridParams.attachFooter =",合计:, , ";
// 		    gridParams.attachFooter2 = new Array();
 		    gridParams.attachFooter2 =stylecss1+","+stylecss1+","+stylecss2+",";
 		    


// 		    gridParams.attachFooter2.push(stylecss);
// 		    gridParams.attachFooter2.push(stylecss1);
// 		    gridParams.attachFooter2.push(stylecss1);
 		    
 		
 		    
 		    
 		    for(var i = 0 ;i < size;i++){
		 		    	gridParams.heads +=days2[i].dy+",";
		 		    	gridParams.widths +=w+",";
		 		    	gridParams.colTypes +="ed"+",";
		 		    	gridParams.colAlign +="right"+",";
		 		    	gridParams.colSorting +="int"+",";
		 		    	gridParams.attachHeader +=days2[i].wk+",";
		 		    	gridParams.attachFooter +="<div id='month"+ (i+1) +"'/>"+",";
		 		    	gridParams.attachFooter2 +=stylecss+",";
//		 		    	gridParams.attachFooter2.push(stylecss);
 		    			}
 		    			
 		    			
 		    			
				gridParams.heads +="总使用,饱和度"
				gridParams.widths +="6,5";
				gridParams.colTypes +="ed,ed";
				gridParams.colAlign +="right,right";
				gridParams.colSorting +="int,int";
				gridParams.attachHeader +="#rspan,#rspan";
				gridParams.attachFooter +="<div id='totalUsed'/>,<div id='totalRate'/>";
				gridParams.attachFooter2 += stylecss2+","+stylecss2;
//				gridParams.attachFooter2.push(stylecss2);
//				gridParams.attachFooter2.push(stylecss2);
				

		 		    	
				return gridParams;
}

function initGrid(){

						var gridParams = getGridParams();   
						
						    	
						
						if(!mygrid) mygrid = new dhtmlXGridObject('gridbox');

						
						mygrid.selMultiRows = true;
						mygrid.setImagePath("image/grid/");
						mygrid.setHeader(gridParams.heads);
						mygrid.setInitWidthsP(gridParams.widths);
						mygrid.setColTypes(gridParams.colTypes);
						mygrid.setColAlign(gridParams.colAlign);
						mygrid.setColSorting(gridParams.colSorting) ;
						mygrid.setMultiLine(false);
						mygrid.setEditable(false);
						mygrid.setSkin("modern2");
						mygrid.enableAlterCss("even","uneven"); 
						mygrid.init();	 		
						


					 	mygrid.clearAll();
					 	mygrid.detachFooter(0);	
						mygrid.setSortImgState(true,0,"ASC"); 
						mygrid.attachFooter(gridParams.attachFooter,gridParams.attachFooter2);		
						mygrid.attachHeader(gridParams.attachHeader,null,"_aHead");		
						mygrid.setSizes();	 

}




function getParams(){

	var orgId = $("orgId").value;
	var comTimeSort= 	Ext.getCmp('unitss').getValue();
	var year = Ext.getCmp('year').getValue();
	var startDate = Ext.getCmp('start_date_query').getValue();
	var endDate = Ext.getCmp('end_date_query').getValue();

	startDate = myDate.myFormatDate(startDate,myDate.dateFormat);
	endDate = myDate.myFormatDate(endDate,myDate.dateFormat);   
	if(endDate =='') endDate = myDate.myFormatDate(def_Date_end,myDate.dateFormat);

	var resourceIds =  Ext.getCmp('res_select_cmd').getValue();
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
	
	return paramObj;
}

function loadGridData(){
	
	 initGrid();

	 function callBackFun(){
	  	
	  }
	  
	 var paramObj =  getParams();

	 if(paramObj.value3 ==''){
	 	 extjMessage('没有选择广告资源!');return false;
	 }
	 
	 var queryString =  $H(paramObj).toQueryString();	

	function callBackFun(xml){

				mygrid.clearAll();
				mygrid.loadXMLString(xml,calculateFooterValues);
				mygrid.setSizes();	 
				Ext.getBody().unmask();

    }
	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	resource.getResourcesForQueryXml(queryString,1,callBackFun);
	
}
 
function calculateFooterValues(){
//        var nrQ = document.getElementById("nr_q");
//        nrQ.innerHTML = sumColumn(1)
//        var srQ = document.getElementById("sr_q");
//        srQ.innerHTML = sumColumn(2);
//        for(var i=0;i<13;i++){
//        	var el = $("month"+(i+1));
//        	el.innerHTML = sumColumn(i+1);
//        }
        return true;
}
    
function sumColumn(ind){
        var out = 0;
        for(var i=0;i<mygrid.getRowsNum();i++){
       	var value =mygrid.cells2(i,ind).getValue()==""?0:mygrid.cells2(i,ind).getValue();
            out+= parseFloat(value)
        }
        return out/10000;
 }

function initGrid_bak(){
	
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath(ctxPath+"image/grid/");
	var dialogcontent = $("dialogcontentDiv");
	var wd = $("gridbox").offsetWidth;

	var flds = "位置,月,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,标准,总规定,总使用,饱和度";
	mygrid.setHeader(flds);

	var columnIds = "resourceName,month,dayTimes[0]," 
					+"dayTimes[1],dayTimes[2],dayTimes[3],dayTimes[4],dayTimes[5],"
					+"dayTimes[6],dayTimes[7],dayTimes[8],dayTimes[9],dayTimes[10],"
					+"dayTimes[11],dayTimes[12],dayTimes[13],dayTimes[14],dayTimes[15],"
					+"dayTimes[16],dayTimes[17],dayTimes[18],dayTimes[19],dayTimes[20],"
					+"dayTimes[21],dayTimes[22],dayTimes[23],dayTimes[24],dayTimes[25],"
					+"dayTimes[26],dayTimes[27],dayTimes[28],dayTimes[29],dayTimes[30],"
					+"stand,total,sumUsed,full";
	mygrid.setColumnIds(columnIds);

	var dw = 2.6;  //0.775
	var dw2 = 3;  //0.175 
	var dw3 = 6; 	
	var ss =[dw3,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw,dw2,dw2,dw2,dw2];
	mygrid.setInitWidthsP(ss.join(","));
	mygrid.setColAlign("left,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,center,right,right,right,right")
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
//	mygrid.setOnEditCellHandler(doOnEditCell);
	mygrid.init();	 
	mygrid.enableAlterCss("even","uneven");
	mygrid.setSizes();

}


function printReport(mode){
//	 var s=['view','print','excel'];
	 
	if(mode =="view"){
		btn_view_queryAdre();
	}
	if(mode =="print"){
		btn_print_queryAdre();
	}
	if(mode =="excel"){
		btn_export_queryAdre();
	}
	
	if(mode =="chart"){
		getFusionChartObjs();
	}	
	if(mode =="query"){
	  Ext.onReady(function(){showSearchWin();});
	}	   
}

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
	
	
	var cmd4 =  Ext.getCmp('carrier_cmd');
	var store4 = cmd4.getStore();
	if(store4.baseParams){
		if(store4.baseParams.dwrParams){
			store4.baseParams.dwrParams[0].orgId =  $("orgId").value;
			store4.reload();
			cmd4.clearValue(); 	 			
		}
	}	
	
	var cmd5 =  Ext.getCmp('resourceSort_cmd');
	var store5 = cmd5.getStore();
	if(store5.baseParams){
		if(store5.baseParams.dwrParams){
			store5.baseParams.dwrParams[0].orgId =  $("orgId").value;
			store5.reload();
			cmd5.clearValue(); 	 			
		}
	}		
	
	resetResourceStore();
	

 
}




function showSearchWin(){

	if(!queryWindow){
 	
	var items = new Array();
	
	var my_cur_year =_app_params.serviceDate.year;
	var comTimeSort = myUtils.getComTimeSort('unitss','统计单位',180,1);  	
	var comYear = myUtils.getComYear('year','年份',180,my_cur_year);  	
	comYear.on("select" , function(box){resetStore();});	

	var def_start_Dat =   myDate.parseDate(getFormatDay(_app_params.serviceDate.format2,"y-m-d"));
	var def_end_Dat =   myDate.parseDate(getFormatDay(_app_params.serviceDate.format2,"y-m-d"));
	

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
  


	def_end_Dat.setDate(def_end_Dat.getDate()+7);
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

	orderCategory.obj.orgId = config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;	
 	orderCategory.obj.version = comYear.getValue();
	var categoryCommand  =	orderCategory.makeSubCategoryFromOrder(null,"orderCategoryId",180,'remote',function(){});	

	var customerCommand  = getCustomerCmd('customerName','userId1',false);
	var userCommand = getUserCmd('customerName','userId1',false);  
	
	
	var comboxGrid = getComBoxGrid();
	
	items.push(comTimeSort);
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
				    width:450,
				    height:400,
				    modal:true,
				    closeAction:'hide',
				    layout:'fit',
				    buttons:[
				    		{text:'查询',handler:function(){ loadGridData();queryWindow.hide();}},
								{text:'重置',handler:function(){fromPannel.form.reset();}},
								{text:'关闭',handler:function(){queryWindow.hide(); }}
				            ],
						items:fromPannel  
		});	
		
    }


 queryWindow.show(this);
 
 

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



function resetResourceStore(){
	var cmd6 =  Ext.getCmp('resource_cmd');
	var store6 = cmd6.getStore();
	if(store6.baseParams){
		if(store6.baseParams.dwrParams){
			var sortId = Ext.getCmp('resourceSort_cmd').getValue()== ""?null: Ext.getCmp('resourceSort_cmd').getValue();
			store6.baseParams.dwrParams[0].orgId =  config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;	
			store6.baseParams.dwrParams[0].version =   Ext.getCmp('year').getValue();
			store6.baseParams.dwrParams[0].carrierId =   Ext.getCmp('carrier_cmd').getValue()== ""?null: Ext.getCmp('carrier_cmd').getValue();
			store6.baseParams.dwrParams[0].resourceSort = sortId;

			var cmd7 =  Ext.getCmp('resource_start_cmd');
			var store7 = cmd7.getStore();
			Ext.apply(store7,store6);	
			store6.reload();
			cmd6.clearValue(); 	 
//					resource.getFitterStore(store6,sortId);		
		}
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
	
	var okBtn ={text: '确定',idth : 30,handler: function(){Ext.getCmp('res_select_cmd').collapse();}};	
	var closeBtn ={text: '关闭',handler: function(){  Ext.getCmp('res_select_cmd').collapse();}};
	

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
    typeAhead : false,  
//    forceFit:true,
    fieldLabel : '时段名称',  
    hiddenName : 'id',  
    hideOnSelect:false,
    triggerAction : 'all',  
    lazyRender : true,  
    width:180,  
    displayField:'name',  
    valueField:'id',  
    store:store,  
    mode : 'local',  
    listWidth:450,
    listClass : 'x-combo-list-small',  
    selectedClass:'',   
    allowBlank : false,  
    emptyText:'请选择...',
    tbar:[carrierCmd,resourceSortCmd,resourceStartCmd,resourceEndCmd,okBtn,closeBtn],
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
	
	   var res_select_cmd =  Ext.getCmp('res_select_cmd');
	   res_select_cmd.setValue(str);
   	});		
   
	
	
	return c;

}
	