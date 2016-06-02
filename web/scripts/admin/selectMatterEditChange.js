

var org = new SysOrg();
var matter = new Matter();
var matterType = new MatterType();
var orderDetail = new OrderDetail();
var orderDayInfo = new OrderDayInfo();
var resource = new Resource();
var order = new Order();
var specific = new Specific();

var matterCommand;
var matterCommandImgSearch;


var matterLengthCommand;
var resourceCommandTree;
var specCommand;
var order_year;
var start_date;
var end_date;
var end_date_grid;
var mygrid;
var mygrid1;
var orderDayInfos;
var sum_times;
var orderDetailId;
var adv_name;
var adv_edit;
var adv_length;
var customer_id = 0;
var matter_type =1;
var matter_id = 0;
var brand_id = 0;  
var orgId =1;
var create_by = 1;
var calStart;
var calEnd;
var order_ckecked;
var order_state_name;
var order_id;
var resource_info_id;

var search_adver_win;


//Ext.onReady(function(){
//            new Ext.Button({
//            	id:"btn_add",
//                text:"添 加",
//                 type:"button", //按钮类型：可以是submit, reset or button 　默认是 button
//                //将BUTTON画在BODY中
//                renderTo:"btn_add",
//                fn: function(){alert()} ,
////                minWidth:50,
//                icon: Ext.MessageBox.INFO
//        });
//
// });

callOnLoad(init);	
   
function init(){	
// 	config_username = $("config_username").value;
// 	useMoreCarrierSortParam = $("config_useMoreCarrierSortParam").value;
// 	
// 	
// 	 config_useMoreCarrierSortParam = $("config_useMoreCarrierSortParam").value;
//	config_useMoreCarrierSortParam = config_useMoreCarrierSortParam==""?0:config_useMoreCarrierSortParam;	 	
//
////	if(useMoreCarrierSortParam == 1 && config_username =='admin'){
//		org.makeSelect(org.obj,"orgId","submit",callBackFun);	
////	}
     var src = window.location.href;
     var  cnt = getParamFromUrl(src,"cnt");
     orgId = getParamFromUrl(src,"orgId");
//     ctxPath =  getParamFromUrl(src,"ctxPath");
     order_year =    getParamFromUrl(src,"order_year");
     orderDetailId = getParamFromUrl(src,"orderDetailId");
     

	 customer_id =  getParamFromUrl(src,"customerId");
	 matter_type = getParamFromUrl(src,"matterType");
	 brand_id =  getParamFromUrl(src,"brandId");
	 adv_name=  decodeURI(getParamFromUrl(src,"advname"));
	 adv_edit=  decodeURI(getParamFromUrl(src,"edit"));
	 adv_length =  getParamFromUrl(src,"advlength");
	 create_by =  getParamFromUrl(src,"createBy");
	 
	 order_ckecked =  getParamFromUrl(src,"order_ckecked");	 
	 order_state_name =  getParamFromUrl(src,"order_state_name");	
	 
	 order_id=  getParamFromUrl(src,"order_id");	
		resource_info_id =   getParamFromUrl(src,"resource_info_id");	
	 
	 
	 
	 tvNameParam =  _app_params.sysParam.tvNameParam;
	config_adverCodeModelParam =  _app_params.sysParam.adverCodeModelParam;
	config_permitModAdverParam = _app_params.sysParam.permitModAdverParam; //协议合同类型
    config_allowModiyPassedOrderParam =  _app_params.sysParam.allowModiyPassedOrderParam; 
    config_industryLevelParam =  _app_params.sysParam.industryLevelParam;
    
    config_serviceDate = _app_params.serviceDate.def;
    
    config_yearFirstDate = _app_params.serviceDate.yearFirstDate;
    config_yearLastDate = _app_params.serviceDate.yearLastDate;
  
           

    
    
    ctxPath = _app_params.ctxPath;	
	loginUserName =  _app_params.user.username;
	loginUserFullName =  _app_params.user.fullName;
	loginUserId =  _app_params.user.id;

     
  	function func(objs){
		orderDayInfos = objs;
	}
	orderDayInfo.obj.orderDetailId = orderDetailId;
	orderDayInfo.getOrderDayInfosArray(orderDayInfo.obj,func);   
     
     var winW = parent.change_edit_win.getInnerWidth()-13;   
     var winH = parent.change_edit_win.getInnerHeight()-31;

//	 $("gridbox_div").style.height = window.innerHeight*0.9  +"px";	
//	 $("gridbox_div1").style.height = window.innerHeight*0.9  +"px";	
	
	 
  	 $("gridbox_div").style.width = winW +"px";	
   	 $("gridbox_div").style.height = winH+"px";  		 
	 
  	 $("gridbox_div1").style.width = winW +"px";	
   	 $("gridbox_div1").style.height = winH+"px";  	 
	
     var s = cnt.split(",");
     
     matter_id = s[7];
		initSpecCom();
    initLengthCom();
    initEditCom();
    initResourceComTree();
	initGrid(s);
	
	initGrid1();
	showGrid(1);
	
	buttonEventFill();
	
	
//	function onItemCheck(item){
//        Ext.MessageBox.alert("点击事件",String.format("您选择了{0}",item.text));
//    }
//	var menu = new Ext.menu.Menu({
//	    id: 'mainMenu',
//	    items: [
//	        {
//	            text: 'menu1',
//	            handler: onItemCheck
//	        },
//	        {
//	            text: 'menu2',
//	            handler: onItemCheck
//	        }]
//	});
//	var button=new Ext.Button({
//		id:'bbccdd',
//	    renderTo:'matterEditDivBtn',
//	    text:'按我',
//	    menu:'mainMenu'
//	});
	

}

function initResourceComTree(){
	  function callFunction(){
   	   	        
   		} 
   	 resource.obj.version=	order_year;
	 resourceCommandTree = resource.getResourceCmdTree(orgId,resource.obj,'search_resource_cmd','search_resource_tree',false,"resourceDiv",'resourceId','选择时段...',200,false,true,true,callFunction);
	 resourceCommandTree.hide();
}

	

function initEditCom(){
      matter.reset();
      matter.obj.orgId = orgId;
      
      if(tvNameParam !='hbtv'){
      	 matter.obj.name = adv_name ;
                }
     
      matter.obj.length = adv_length;
//      var length =  Ext.fly('lengthcmd').dom.value; 
      
//      alert(length);
//      matter.obj.length = length;
      
       var mode = 'remote';
//      matter.storeOrderCategory =  new Ext.data.Store();
       var store = matter.getStoreMatterEditByName(mode,matter.obj);    
        
//		Ext.namespace('ux');  
//		Ext.ux.DefaultingComboBox = function(config) {  
//		    Ext.ux.DefaultingComboBox.superclass.constructor.call(this, config);  
//		};  
//		  
//		Ext.extend(Ext.ux.DefaultingComboBox, Ext.form.ComboBox, {  
//		    setValue : function(v) {  
//		        // 如果远程数据还没有加载,在设值之前先加载一次   
//		        if (this.mode == 'remote' && this.store.getCount() == 0) {  
//		            this.store.on("load", function() {  
//		                Ext.ux.DefaultingComboBox.superclass.setValue.call(this, v);  
//		            }, this, {  
//		                single : true  
//		            });  
//		            this.doQuery(this.allQuery, true);  
//		        } else {  
//		            Ext.ux.DefaultingComboBox.superclass.setValue.call(this, v);  
//		        }  
//		    }  
//		});          
        
        

	 if(!matterCommand){ 
	 	 if(tvNameParam !='hbtv'){
		     matterCommand = new Ext.form.ComboBox({
				 id:'editcmd',
				 name:'editcmd',
		        store: store,
		        width: '100%',
		        listWidth:270,
		        valueField: 'id',
		        displayField: 'edit',
//		        typeAhead: true,
		        mode: mode,
		        lastQuery:'-1',
		        forceAll:true,
		        triggerAction: 'all',
		        emptyText: '请选择...',
		        forceSelection: false,
		          editable: true,
//		        selectOnFocus: true,
		        msgTarget: 'side',
		        allowBlank: false,
//		        lazyRender: false,
		        blankText: '不能为空！',
		        minChars:1,
		        renderTo: 'matterEditDiv',
//		        displayFields:[0,1],
//		        tpl:tpl2,
		        displayFields:['edit','length'],
		        filterFiled:'edit',
		        filterFiled2:'helpCodeEdit',
				params:matter.obj,
//				hiddenName : 'id',  
//				hiddenId :'id',
				listeners:{beforequery:matter.comboFilterBy2.createDelegate(this)} 
		    });
	 	 }else{
					matterCommand = new Ext.form.ClearableComboBox({
				 	  id:'editcmd',
				 	  name:'editcmd',
				 	  renderTo: 'matterEditDiv',
					  listWidth:300,
					  store:store,
					  editable: true,
					  lastQuery:'-1',
					  displayField:'edit',
					  valueField:'id',
					  mode:mode,
				      width: '100%',
				      listWidth:270,
					  allowBlank:false, 
					  emptyText:'请选择...',
					  minChars:2,
					  filterFiled:'edit',
					  filterFiled2:'helpCodeEdit',
					  params:matter.obj,
					  listeners:{
					  	beforequery:matter.comboFilterBy2.createDelegate(this)}
					  	
				 });		    
	 	 }
		    
	
		    
		 matterCommandImgSearch = $("search_adver_cont"); 
		    
		    
		    
//		    matterCommand.store
		    
		    
//		    function kkk(cmd){
//		    	alert(11111111)
//		    	alert( matterCommand.getValue());
//		    	alert( matterCommand.getRawValue());
////		    	alert( cmd.getValue());getRawValue。
//		    }
////		    
//		       matterCommand.on("blur",kkk,this);	
		    
		    
//	 if(!matterCommand){ 		    
//
// 			  matterCommand = new Ext.form.ComboBox({
//// 			  fieldLabel: '待注册客户',
// 			  hideLabels:true,
//		 	  id:'editcmd',
//		 	  name:'editcmd',
//			  renderTo:'matterEditDiv',
//			  tiggerAction:'all',
//			  store:store,
//			  editable: true,
//			  triggerAction: 'all', //query all
//			  lastQuery:'-1',
//			  displayField:'edit',
//			  valueField:'id',
//			  mode:mode,
//			  width:'100%',
//			  forceSelection:false, 
//			  allowBlank:false,
//			  emptyText:'请选择...',
//			  minChars:1,
//			  filterFiled:'edit',
//			  params:matter.obj,
//			  listeners:{ beforequery:matter.comboFilterBy2.createDelegate(this)} 
//			  	
//			 });       	
    
		    
		    
//		     function aaaa(this){
//		     	  alert(2222222)
////		     	  this.getRawValue();
//		     }
//		    
		   

		    
//		    matterCommand.on("blur",checkedit_test2,this);	

//           function resetStire(cmd){
//             	cmd.getStore().reload();	
//           }
//            matterCommand.on("expand",resetStire,this);	
	
	        	    
	 }
      
}


 

function initSpecCom(){
   

		var mode = 'local';
//      matter.storeOrderCategory =  new Ext.data.Store();
        var store = specific.getStoreMap(mode,specific.obj);  
 
	 if(!specCommand){        
		     specCommand =  new Ext.form.ClearableComboBox({
				 id:'specComman',
				 name:'specComman',
		        store: store,
		        width: 100,
		        valueField: 'id',
		        displayField: 'name',
		        typeAhead: true,
		        editable: true,
		        mode: mode,
		        lastQuery:'-1',
//		        forceAll:true,
		        triggerAction: 'all',
		        emptyText: '请选择指定...',
		        forceSelection: false,
		        selectOnFocus: true,
		        msgTarget: 'side',
		        allowBlank: false,
//		        lazyRender: false,
		        blankText: '不能为空！',
		        minChars:100,
		        renderTo: 'specCommanDiv',
		        filterFiled:'value',
				params:matter.obj
//				,listeners:{ beforequery:matter.comboFilterBy2.createDelegate(this)} 
		    });
	 }

}

function initLengthCom(){
      matter.reset();
      matter.obj.orgId = orgId;
      matter.obj.name = adv_name ;

		var mode = 'local';
//      matter.storeOrderCategory =  new Ext.data.Store();
        var store = matter.getStoreMatterLengthByName(mode,matter.obj);    

	 if(!matterLengthCommand){        
		     matterLengthCommand = new Ext.form.ComboBox({
				 id:'lengthcmd',
				 name:'lengthcmd',
		        store: store,
		        width: 45,
		        valueField: 'key',
		        displayField: 'value',
		        typeAhead: true,
		        editable: true,
		        mode: mode,
		        lastQuery:'-1',
//		        forceAll:true,
		        triggerAction: 'all',
		        emptyText: '请选择广告版本...',
		        forceSelection: false,
		        selectOnFocus: true,
		        msgTarget: 'side',
		        allowBlank: false,
//		        lazyRender: false,
		        blankText: '不能为空！',
		        minChars:100,
		        renderTo: 'matterLengthDiv',
		        filterFiled:'value',
				params:matter.obj
//				,listeners:{ beforequery:matter.comboFilterBy2.createDelegate(this)} 
		    });
		    
		    matterLengthCommand.setValue(adv_length);
		    
		    
		    function resetCmd(combo){
           
		    		var len =  Ext.fly('lengthcmd').dom.value; 
//				    var id2 =  Ext.getCmp('lengthcmd').getValue();	
                    if(!isDigit(len)){
                    	extjMessage("广告长度必须数字");
                    	 return false;
                    }
				    if(len ==''){
				    	extjMessage("广告长度不能空");
				    	return false;
				    }else{
					    var cmd2 =  Ext.getCmp('editcmd');
						var store2 = cmd2.getStore();	
						store2.baseParams.dwrParams[0].length = combo.getValue(); 
						cmd2.clearValue(); 
						store2.reload();	
//			    	    matterCommand.onTriggerClick();	
				    }
               
//		    	matterCommand.fireEvent("select",matterCommand); 
//		    	matterCommand.reload();
		    }
		    matterLengthCommand.on("select",resetCmd,this);
//		    matterLengthCommand.on("blur",resetCmd,this);	
		    matterLengthCommand.on("change",resetCmd,this);	
		    
		    
		    if(order_ckecked == 1 || order_ckecked == 3)  matterLengthCommand.disable();
		    
//		    if(tvNameParam =='hntv') matterLengthCommand.disable();
		    
//		     matterLengthCommand.on("select",resetCmd,this);	
   	    
	 }
      
}





function checkedit(callBackFun){
	
	
//	Ext.getCmp('bbccdd').fireEvent('click',this); 
	
//	matterLengthCommand.focus();
//		alert(111)
//	matterCommand.fireEvent('change',this); 
//	matterCommand.onTriggerClick(); 
//		alert(222)
//	matterLengthCommand.onTriggerClick(); 
//	onComboBoxBlur: function(field){
//     field.setValue(field.getRawValue());
//    }
//	
	
	var edit =  Ext.fly('editcmd').dom.value; 
	var id =  Ext.getCmp('editcmd').getValue();	
	var length =  matterLengthCommand.getValue(); 
	
//	var edtCmd = Ext.getCmp('editcmd');
//    var index = edtCmd.store.find('id', id); 
//	var record = edtCmd.store.getAt(index);
//	var advName = record.get("name");
//	alert(record.data.name)
//	alert(record.get("name"));
//	console.log(record);
//	var ed_it = record.get
		
	

   if(!isDigit(length)){
//      extjMessage("广告长度必须数字");
      matterLengthCommand.onTriggerClick(); 
      return false;
   }	
   
   if('请选择...' == edit && edit !=''){
//			extjMessage('"请选择版本!');
			matterCommand.onTriggerClick(); 
			return false;
   }

	 function callBakFun(id){
		inti_set_edit(id,adv_name,edit,length);

//		var cmd2 =  Ext.getCmp('editcmd');
//		var store2 = cmd2.getStore();	
//		store2.reload();	
		  if(callBackFun) callBackFun();
		  return  true;
//		if(a) 	save();  
	}	
	
	


	if((id == edit && id !='')||(id == '' && edit !='')){
			var cut = (new Matter()).obj;
			
			cut.orgId = orgId*1;			
			cut.name = adv_name;
			cut.edit = edit;
			cut.length = length;		

			var obj =  matter.getMatterByNameVerLen(cut);			
			
//			console.log(obj)

			if(obj != null){
				   if(obj.id >0){
					 extjMessage('"版本已存在!');
					 return false;
				   }
			}		
			
			cut.id = 0;
			cut.enable = true;
			cut.version = order_year*1;
			cut.brandId = brand_id*1;
			cut.customerId = customer_id*1;
			cut.matterType = matter_type*1;
			cut.createBy =  create_by*1;
			cut.modifyBy =  create_by*1;
			cut.createDate =  new Date();
			cut.modifyDate =  new Date();
			cut.memo =  '';
	
//			if(!confirm("此版本为新版本，是否注册")) return false;

	        
		    Ext.MessageBox.confirm('系统提示', '此版本为新版本，是否注册？', function(btn) {
		    	
 			  if (btn == 'yes') {
				if(config_adverCodeModelParam == 0){
					var vv = prompt("请输入磁带号");
					if(vv !=''){
						 cut.tapeCode = vv;
					}else{
						 return false;
					}
				}
	
		        matter.saveMatter2(cut,callBakFun);
              }	  
              
                	
		     });	        

         
	}else{
		if(id == ''){
			extjMessage('"请选择版本!');
			return false;
		}
		 if(callBackFun) callBackFun();
	}
	

	if(id == ''){
		extjMessage('"请选择版本!');
		return false;
	}


//	alert("checkOrderSubCate 1 显示值="+industry.treecombo.getRawValue()+"   真实值="+industry.treecombo.passField.getValue());

}


function inti_set_edit(id,name,edit,length){
	

	var rc1 = Ext.data.Record.create(matter.fileds);
    var rc = new rc1({
           id : id,
           edit : edit,
           name :name,
           length : length
     });
      
    if(!matterCommand){
    	initEditCom()
    }
    
//       matterCommand.clearValue(); 
   	   matterCommand.store.add(rc);
   	   matterCommand.setValue(id);  	

}


function initGrid(s){
	
	mygrid = new dhtmlXGridObject('gridbox');

	mygrid.setImagePath(ctxPath+"image/grid/");

	var flds = "序号,版本,长度,开始,结束,次数";
	var columnIds = "id,edit,start,end,num";
	mygrid.setHeader(flds);
	mygrid.setColumnIds(columnIds);
    mygrid.setInitWidthsP("10,40,10,15,15,10");
	mygrid.setColAlign("center,left,center,center,center,center");
//	mygrid.setColTypes("ed,ed,calendar,ed,ed");
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed");
	mygrid.setEditable(false);
	mygrid.selMultiRows = false;
	mygrid.setSkin("modern2");
	mygrid.enableAlterCss("even","uneven");
	mygrid.setOnEditCellHandler(doOnCellEdit);
	
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
	
    mygrid.loadXMLString(createTables(s));

  
}

function initGrid1(){

	mygrid1 = new dhtmlXGridObject('gridbox1');
	mygrid1.selMultiRows = false;
	mygrid1.setImagePath(ctxPath+"image/grid/");
	var	flds = ",序,位置,名称,版本,秒,指定,开始,结束,次";
	var	columnIds =  "ch,seq,pos,name,edit,len,spec,start,end,times";  
	mygrid1.setHeader(flds);
	mygrid1.setColumnIds(columnIds);
    mygrid1.setInitWidthsP("4,5,21,11,21,5,9,9,9,6");
    mygrid1.setColSorting("na,int,int,str,str,str,str,int,str,str,int");
	mygrid1.setColAlign("center,center,left,left,left,center,center,center,center,center,center");
	mygrid1.setColTypes("ch,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
	mygrid1.setEditable(false);
	mygrid1.setOnRowSelectHandler(onRowSelectd,true);

	mygrid1.setSkin("modern2");
	mygrid1.enableAlterCss("even","uneven");
	mygrid1.init();	
    attachHeaderNew(mygrid1);
}


function attachHeaderNew(grid){
	var htm ="<center><input type='checkBox' id='detailAllSelect' value='0' onclick= 'javascript:selectCheckBoxAll(1)'></center>,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan";
	var h = htm.split(",");
	var z =  grid.hdr.rows[1];
	
	for(var cin = 0; cin<h.length;cin++){
		if(h[cin].indexOf("#rspan") != 0) {
			var c = z.cells[z._childIndexes?z._childIndexes[parseInt(cin)]:cin];
			c.innerHTML = h[cin];		
		}

	}
	
}


function selectCheckBoxAll(type){
	var el = $("detailAllSelect");
	var grid = mygrid1;
	var col = el.value;
	var rows = grid.getRowsNum();
	for(var i=0; i< rows;i++){
		var ch =  grid.cells2(i,0);
		if(grid.getRowByIndex(i).style.display ==""){
		     ch.setValue(el.checked);
		}else{
		     ch.setValue(0);
		} 
	}	
}	
function onRowSelectd(id,cellInd){
	var cell = mygrid1.cells(id,0);
	var v = cell.getValue()==0?1:0;
	cell.setValue(v);	
}


function selectdSameMatter(matterId,userDataFiled){
	var grid = mygrid1;
	for(var i = 0; i< grid.getRowsNum();i++){
		var detailId = grid.getRowId(i);
	
			var matter_id = grid.getUserData(detailId,userDataFiled);
			if(matterId == matter_id){
				grid.cells(detailId,0).setValue(1);	
			}else{
				grid.cells(detailId,0).setValue(0);	
			}


	}

}
function unSelectdGrid1(){
	var grid = mygrid1;
	for(var i = 0; i< grid.getRowsNum();i++){
		grid.cells2(i,0).setValue(0);	
	}
}




function showGrid(i){
    var start = _app_params.serviceDate.def;
    var end = _app_params.serviceDate.def;
    var model =1;
    
//    $("change_time").hide();
//    $("change_time_end").onblur();
       
//      $("change_time").blur();

//    window.calendar.hide();

	if(i == 1){
		$("gridbox_div").show();
		$("btn_add").show();
		$("gridbox_div1").hide();
		  start = start_date;
  		  end = end_date;
  		  model = 1;
	}else{
		$("gridbox_div").hide();
		$("btn_add").hide();
		$("gridbox_div1").show();

		 start = config_yearFirstDate;
  		 end = config_yearLastDate;
  		 model = 2;
	}
	getDate_change_time(start,end,model);
	

}

//获得表
function getOrderDetailTable(orderId,detailIds,callBackFun){	

	var paramObj = new OrderDetail();
	mygrid1.clearAll();
	Ext.getBody().mask('数据处理中……', 'x-mask-loading'); 	   	
	var fnc = function(xml){
		mygrid1.loadXMLString(xml,callBackFun);
//		unSelectdGrid1();
		Ext.getBody().unmask(); 
//		mygrid.loadSizeFromCookie();
	}	

	paramObj.obj.orderId = orderId;
	paramObj.obj.parentId = 0;
	paramObj.obj.loginUser = loginUserName; 
	paramObj.obj.orgId = orgId;
	paramObj.obj.tableModel = 1;
	paramObj.obj.detailIds = detailIds;
	

	paramObj.getOrderDetailsForFztv(fnc);	
	
};

	
	

function buttonEventFill(){
	


	var Btn_add = $("btn_add");
	Btn_add.onclick = checkedit_test;
	
	var Btn_search_adver_cont = $("search_adver_cont");
	Btn_search_adver_cont.onclick = search_adver_cont;	
	
	
	var Btn_execPrice = $("execPrice");
	var Btn_favourRate = $("favourRate");
	var Btn_appRate = $("appRate");
	

	Btn_execPrice.onblur = isDigit2;	
	Btn_favourRate.onblur = isDigit2;	
	Btn_appRate.onblur = isDigit2;	
	
	Btn_execPrice.onfocus = function(){

		Btn_execPrice.style.backgroundColor="#ffffff";
		Btn_favourRate.style.backgroundColor="#c0c0c0";
		Btn_appRate.style.backgroundColor="#c0c0c0";
		Btn_favourRate.value = "";
		Btn_appRate.value = "";
		
	}
	Btn_favourRate.onfocus = function(){
		Btn_favourRate.style.backgroundColor="#ffffff";
		Btn_appRate.style.backgroundColor="#ffffff";
		Btn_execPrice.style.backgroundColor="#c0c0c0";
		Btn_execPrice.value = "";
	}	
	Btn_appRate.onfocus = function(){
		Btn_favourRate.style.backgroundColor="#ffffff";
		Btn_appRate.style.backgroundColor="#ffffff";
		Btn_execPrice.style.backgroundColor="#c0c0c0";
		Btn_execPrice.value = "";
	}	
//	
//	Btn_execPrice.onfocus = function(e){
//
//	};

	
}



function search_adver_cont(){
   var matter_fin = new Matter();
   var industry_fin = new Industry();
   var customer_fin = new Customer();
   var  customerId = '';	
   var customerName =  ''; 

   

   function callFunction(params){
   	   	   document.getElementById('matteriframe2').contentWindow.loadGridData(params);	        
   	}  
   
   if(!search_adver_win){

       var urlStr= ctxPath + "selectPopup/selectMatters.html?orgId="+orgId+"&customerId="+customerId+"&version="+ order_year;
       urlStr = urlStr + "&customerName="+customerName;
       
   	   var addNewBtn ={text: '新添素材',handler: function(){
			document.getElementById('matteriframe2').contentWindow.save_new_matter();	 
		}};
		
   	   var closeBtn ={text: '关闭',handler:close_search_adver_winWin};
   	   
   	   var resetBtn ={text: '重置',handler:function(){
			document.getElementById('matteriframe2').contentWindow.resetQueryWhere();	
   	   }};
   	   
   	   var copyBtn ={text: '复制素材',handler:function(){
			document.getElementById('matteriframe2').contentWindow.copyQueryWhere();	

   	   }};
   	   

   	   customer_fin.obj.orgId = orgId;
   	   matter_fin.obj.orgId = orgId;
   	   
   	   var customerCmd = customer_fin.initCustomerCmd(matter_fin.obj,'search_adver_customer',null,'remote',null,'customerName',1,133,300,'请选择客户...',callFunction);
   	   var nameCmd = matter_fin.getCommandForSelect('search_adver_name','广告名称...','name',1,110,callFunction);
   	   var editCmd = matter_fin.getCommandForSelect('search_adver_edit','请输入广告版本...','edit',1,190,callFunction);
   	   var lengthCmd = matter_fin.getCommandForSelect('search_adver_len','长度...','length',1,70,callFunction);
   	   var tapecodeCmd = matter_fin.getCommandForSelect('search_adver_tapecode','磁带...','tapeCode',2,70,callFunction);
   	   var industryCmd = industry_fin.getIndustryCmd(matter_fin.obj,'search_adver_brandId_cmd','search_adver_brandId_tree',true,null,config_industryLevelParam,'brandId','选择行业...',100,callFunction);
	   var matterTypeCmd = matterType.getMatterTypeCmd(matter_fin.obj,null,'search_adver_matterType','matterType',70,'分类...',callFunction);
//	   matterTypeCmd.setValue(1);
	 
  
	   search_adver_win =new Ext.Window({
			title:"素材库-(广告名称、广告版本可以用汉字声母查询，选择素材时用鼠标双击)",
			modal : true,
			resizable : false,
			closeAction:'hide',
			closable: true,
			width : 750,
			height : 390, 
//			tbar:[tapecodeCmd,'-',nameCmd,'-',nameCmd,'-',editCmd,'-',lengthCmd,'-',industryCmd],
			tbar:[customerCmd,nameCmd,editCmd,lengthCmd,tapecodeCmd,industryCmd,matterTypeCmd],
			buttons: [addNewBtn,'-',closeBtn], 
			contentEl : Ext.DomHelper.append(document.body, {
			    tag : 'iframe',
			     id : 'matteriframe2',
			    style : "border 0px none;scrollbar:true",
			    src : urlStr,
			    height : "100%",
			    width : "100%"
			   })
		});
//		 this.search_adver_win = search_adver_win;
		 search_adver_win.on({'close': {fn: close_search_adver_winWin}});
//		 if(customerName !='') Ext.getCmp('search_adver_customer').setValue(customerName); 
		 search_adver_win.show();

		 
   }else{
//   	    if(customerName !=''){
//   	    	 Ext.getCmp('search_adver_customer').setValue(customerName); 
//   	   		 Ext.getCmp("search_adver_tapecode").params.customerName = customerName;
//   	    }
   	    callFunction(Ext.getCmp("search_adver_tapecode").params);
   	   	search_adver_win.show(this);
   }


}


function close_search_adver_winWin(p,my_grid_matter){

	if(p == 1 || p == 2){
		
		var rowId =(p == 1)? my_grid_matter.getSelectedId():my_grid_matter.id;
		
		var customerName =  (p == 1)?my_grid_matter.cells(rowId,0).getValue():my_grid_matter.customerName;
		var name = (p == 1)?my_grid_matter.cells(rowId,1).getValue():my_grid_matter.name;
		var edit = (p == 1)?my_grid_matter.cells(rowId,2).getValue():my_grid_matter.edit;
		var length = (p == 1)?my_grid_matter.cells(rowId,3).getValue():my_grid_matter.length;
		var tapeCode = (p == 1)?my_grid_matter.cells(rowId,4).getValue():my_grid_matter.tapeCode;
		var industryName = (p == 1)?my_grid_matter.cells(rowId,5).getValue():my_grid_matter.industryName;
		
		var brandId =  (p == 1)?my_grid_matter.getUserData(rowId,"brandId"):my_grid_matter.brandId;
		var matterType =  (p == 1)?my_grid_matter.getUserData(rowId,"matterType"):my_grid_matter.matterType;
		var customerId =  (p == 1)?my_grid_matter.getUserData(rowId,"customerId"):my_grid_matter.customerId;
		var customerCategoryId =  (p == 1)?my_grid_matter.getUserData(rowId,"customerCategoryId"):my_grid_matter.customerCategoryId;
		

		inti_set_edit(rowId,name,edit,length);
		
		matterLengthCommand.setValue(length); 
   matterLengthCommand.setRawValue(length); 



//		$("dt_matter.id").value = rowId;
//		$("matter.tapeCode").value = tapeCode;
//		$("matter.name").value = name;
//		$("matter.edit").value = edit;
//		
//		var isChanged = mattersAutoCompleteChange(length);
//		$("matterLength").value =length;	
//		$("matterType").value = matterType;
//
// 		industry.treecombo.passField.value =  brandId;
//   		industry.treecombo.setValue(industryName);	
//   		
//
////   		if(my_grid_matter.initCustomer){
////   			  inti_set_customer(null,1,customerId,customerName,customerCategoryId); 
////   		}
//		if(isChanged) copyBroTimesToCurBroArrange();
	}
	
	search_adver_win.hide();
}  	
function _2dg(val){
		 if(val.toString().length==1)
		 return("0"+val.toString());
		 return val;
}


function otherFocus(){
	$("change_time").focus();	
}

function grid_add_row(){
	
	otherFocus();

	var edit =  Ext.fly('editcmd').dom.value; 
	var matterId =  Ext.getCmp('editcmd').getValue();	
	var preId = mygrid.getRowId(mygrid.getRowsNum()-1);
	var length =  matterLengthCommand.getValue(); 
	    
	var start = $("change_time").value
//	var end = getFormatDay(end_date,'y/m/d');
    var end = $("change_time_end").value

	if(getFormatDay(start,'ymd')*1 ==  getFormatDay(mygrid.cells(preId,3).getValue(),'ymd')*1 &&  preId != matterId){
		    Ext.MessageBox.confirm('系统提示', '增加的版本开始时间相同,是否替换原来的版本？', function(btn) {
 			  if (btn == 'yes') {
				mygrid.changeRowId(preId,matterId);
				mygrid.cells(matterId,1).setValue(edit);
				mygrid.cells(matterId,2).setValue(length);
              }	    	
		     });		
		return;
	}
	

	
	if(mygrid.isItemExists(matterId)){
		extjMessage('"版本已存在,请选择其它的版本!');
		return;
	}
	
	
	
	
//	mygrid.addRow(123,"text1,text2",1); 
	var id = (new Date()).valueOf();
	start_date =  getFormatDay(start,'ymd'); 
	var end_tt = getFormatDay(end,'ymd'); 
	
	if(start_date > end_tt){
		extjMessage('"开始时间不能大于结束时间!');
		return;	
	}
	
	

    var  newDate=  new   Date(Date.parse(start.replace(/-/g,   "/")));   
    var   z   =   DateAdd( "d ",-1,newDate);
    var preEndDateStr = ("y/m/d").replace("m",_2dg((z.getMonth()*1+1))).replace("d",_2dg(z.getDate())).replace("y",_2dg((z.getFullYear()*1)));

//	alert(preId);
//	alert(preEndDateStr);
	
    mygrid.cells(preId,4).setValue(preEndDateStr); 
    var times1 = getTimeByDay(getFormatDay(mygrid.cells(preId,3).getValue(),'ymd')*1 ,getFormatDay(preEndDateStr,'ymd')*1);
    mygrid.cells(preId,5).setValue(times1);   
    
     var times2 = 0;
    
      if(end_tt < end_date){
 	     times2 = getTimeByDay(start_date,end_tt);	
      }else{
      	 times2 = getTimeByDay(start_date,end_date);	
      }  
      
	if(times2 == 0 ){
		extjMessage(start+"至" +end+'"开区间没有播出,请检查!');
		return;	
	}        
 	  mygrid.addRow(matterId,[mygrid.getRowsNum()+1,edit,length,start,end,times2],mygrid.getRowsNum());
   
    
//    if(end_tt < end_date){
//    	
// 	    var times2 = getTimeByDay(start_date,end_tt);	
//		mygrid.addRow(matterId,[mygrid.getRowsNum()+1,edit,length,start,end,times2],mygrid.getRowsNum());   
		
//	    var  newDateStart=  new   Date(Date.parse(end.replace(/-/g,   "/")));    
//	    var   z   =   DateAdd( "d ",-1,newDateStart);
//	    var preStartDateStr = ("y/m/d").replace("m",_2dg((z.getMonth()*1+1))).replace("d",_2dg(z.getDate())).replace("y",_2dg((z.getFullYear()*1)));		
//		
// 	    var times2 = getTimeByDay(getFormatDay(preStartDateStr,'ymd')*1,end_date);	
//		mygrid.addRow(matterId,[mygrid.getRowsNum()+1,matter_id,length,preStartDateStr,getFormatDay(end_date,"y/m/d"),times2],mygrid.getRowsNum());  			
        
    	
//    }else{
//	    var times2 = getTimeByDay(start_date,end_date);	
//		mygrid.addRow(matterId,[mygrid.getRowsNum()+1,edit,length,start,end,times2],mygrid.getRowsNum());
//		
//    }
    
   $("change_time").value  = end;
   $("change_time_end").value  = getFormatDay(end_date,'y/m/d'); 
   
    if(end_tt < end_date){
	    var  newDateStart=  new   Date(Date.parse(end.replace(/-/g,   "/")));    
	    var   z   =   DateAdd( "d ",+1,newDateStart);
	    var preStartDateStr = ("y/m/d").replace("m",_2dg((z.getMonth()*1+1))).replace("d",_2dg(z.getDate())).replace("y",_2dg((z.getFullYear()*1))); 	
    	end_date_grid = preStartDateStr;
    }
   
   

}



function checkedit_test(){
	 checkedit(grid_add_row);
}


function checkedit_test2(){
	 checkedit();
}


function doOnCellEdit(stage,rowId,cellInd){
	   
	    if(cellInd !=2) return;
	    
	    
	
//		if(stage==0){
//			alert("User starting cell editing: row id is"+rowId+", cell index is "+cellInd)
//		}else if(stage==1){
//			alert("Cell editor opened");
//		}else if(stage==2){
//			alert("Cell editor closed");
//			var z=window.calendar.date;
//			alert(z);
//		}
		return true;
}

function createTables(s){
 
  var rowId = s[0];
  var name = s[1];
  var edit = s[2];
  var length = s[3];
  var start = s[4];
  var end = s[5];
  var num = s[6];
  var matterId = s[7];
  
  
  
  
//  start =  order_year +"/" + start;
//  end =  order_year +"/" + end;
  
  start_date = start;
  end_date = end;
  sum_times  = num;
  
//  adv_name = name;
  adv_length = length;
  
  

  getDate_change_time(start,end,1);
  
  
  var sb;
  
  			sb = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			sb = sb + "<rows>";  
			sb = sb + "<row  id=\""+ matterId +"\"" +">";
	
			sb = sb + "<cell><![CDATA["+ 1   +"]]></cell>";
//			sb = sb + "<cell><![CDATA["+ decodeURI(name)    +"]]></cell>";
			sb = sb + "<cell><![CDATA["+ decodeURI(edit)   +"]]></cell>";
			sb = sb + "<cell><![CDATA["+ length   +"]]></cell>";
			start = (start ==null || start =="null")?"":getFormatDay(start,"y/m/d");
			sb = sb + "<cell><![CDATA["+ start +"]]></cell>";
			end = (end ==null || end == "null")?"":getFormatDay(end,"y/m/d");
			sb = sb + "<cell><![CDATA["+ end   +"]]></cell>";
			
			sb = sb + "<cell><![CDATA["+ num   +"]]></cell>";
			sb = sb + "</row>";		
		    sb = sb + "</rows>";  					
							
 return sb; 
}

function dateDisabledFunc(date){
//	    alert(date);
        var calDate = date.print("%Y%m%d")*1;
        return !(calDate >= start_date*1 && calDate <= end_date*1);	 

//	    
//	    
////	  var spval = getFormatDay(start_date,'y/m/d'); 
////	  var epval = getFormatDay(end_date,'y/m/d'); 
////	  var sd =  new   Date(Date.parse(pval.replace(/-/g,   "/"))); 
////	  var ed =  new   Date(Date.parse(pval.replace(/-/g,   "/"))); 
//      var rowIndex= mygrid.getRowsNum()-1;
//      
//      alert();
//      var startDate = mygrid.cells(rowIndex,2).getValue();
//      var spval = getFormatDay(startDate,'ymd'); 
//        
//      alert(spval);
	  
//      return (date.getDate() >= 5 && date.getDate() <= 15);	  
	    
}
function save(isRes,closeFun){

	
//	if(config_allowModiyPassedOrderParam ==0 && tvNameParam !='hntv'){
//		
//		alert("不能保存") 
//	}


	var details =new Array();
	var rowCount= mygrid.getRowsNum();

	var sumT = 0;
//	orderDetail

	for(var i=0;i< rowCount;i++){

		var detail = (new OrderDetail()).obj;
		if(i == 0) {detail.id = orderDetailId;}  
		var rowId = mygrid.getRowId(i);
		detail.matterId = rowId;
		detail.matterLength = mygrid.cells(rowId,2).getValue();
		detail.publishStartDate =  getFormatDay( mygrid.cells(rowId,3).getValue(),'ymd'); 
		detail.publishEndDate = getFormatDay( mygrid.cells(rowId,4).getValue(),'ymd'); 
		detail.memo = mygrid.cells(rowId,1).getValue();
		detail.resourceInfoId = resource_info_id;

		
		var d = finFirstLastDate(detail.publishStartDate,detail.publishEndDate);
		detail.publishStartDate =  d[0];
		detail.publishEndDate = d[1];
		
		detail.sumTimes = mygrid.cells(rowId,5).getValue();
		details.push(detail);
		
		sumT = sumT + detail.sumTimes*1;
		
//		alert(detail.id +"_"+ detail.matterId+"_"+ detail.publishStartDate+"_"+ detail.publishEndDate+"_"+ detail.sumTimes +"_"+sumT);
		
	}
	
	if(sumT < sum_times){
//		extjMessage("总播出次数为【" + sum_times +"】当前次数为【" + sumT +"】不符,请检查");
		
		var leaveTime = sum_times - sumT;
		if(leaveTime > 0){
			var start =end_date_grid;
			var end = getFormatDay(end_date,"y/m/d")
			Ext.MessageBox.hide(); 
			Ext.MessageBox.confirm('系统提示', start+'至'+end+'期间版本未定,是否依旧使用旧版本？', function(btn) {
 			  if (btn == 'yes') {
			 		var detail = (new OrderDetail()).obj;
					detail.id = orderDetailId;
					detail.resourceInfoId = resource_info_id;
					detail.matterId = matter_id;
					detail.matterLength = adv_length;
					detail.publishStartDate =  getFormatDay(end_date_grid,'ymd');  
					detail.publishEndDate = end_date; 
					var d = finFirstLastDate(detail.publishStartDate,detail.publishEndDate);
					detail.publishStartDate =  d[0];
					detail.publishEndDate = d[1];
					detail.sumTimes = getTimeByDay(detail.publishStartDate,detail.publishEndDate);
					details.push(detail);   
					save_new(isRes,orderDetailId,details,closeFun);
              }else{
         	  	 return;
              }	
			})
		}

	}else{
		save_new(isRes,orderDetailId,details,closeFun);
	}

}

function save_new(isRes,orderDetailId,details,closeFun){
	
	

	
	var rowCount= mygrid.getRowsNum();
	
	var detail = (new OrderDetail()).obj;
	
	var startDate =  getFormatDay($("change_time").value,'ymd');  
	var endDate =  getFormatDay($("change_time_end").value,'ymd');  
	
//	alert(orderDetailId)
	
	detail.id = orderDetailId*1;
	detail.orderDetailBak = getOrderDetailBak(orderDetailId,matter_id,resource_info_id,start_date,end_date,adv_edit,adv_length);
	detail.memo = Ext.fly('editcmd').dom.value; ;
	detail.matterLength =  Ext.getCmp('lengthcmd').getValue();	
	detail.orderId = order_id;
	detail.resourceInfoId = resource_info_id;
	detail.publishStartDate = startDate*1;
	detail.publishEndDate = endDate*1;
 detail.loginUser = loginUserName;		
	


	function func(s){closeFun(s);}
	
	if(rowCount == 1){
		if(mygrid.isItemExists(matter_id)){
			extjMessage('"版本已存在,请选择其它的版本!');
			return;
		}else{
			orderDetail.saveOrderDetailM(isRes,detail,details,func);
		}
	}else{

		 orderDetail.saveOrderDetailM(isRes,detail,details,func);
	}
}

function getOrderDetailBak(orderDetailId,matterId,resourceInfoId,start,end,edit,length){
	
    var detailBak = (new OrderDetail()).obj;
    detailBak.matterId = matterId;	
    detailBak.resourceInfoId=resourceInfoId;
		 detailBak.publishStartDate = start;	
		 detailBak.publishEndDate = end;	
		 detailBak.memo = edit;	
    detailBak.matterLength = length;	
    detailBak.isCkecked = order_ckecked*1;	
    detailBak.orderState = {name:order_state_name};
    detailBak.modifyBy =  create_by*1; 
    detailBak.orderId = order_id*1;
    detailBak.id = orderDetailId;
    detailBak.loginUser = loginUserName;
    
    
    return detailBak;
}

function save_more(isRes,orderId,closeFun){
	var grid = mygrid1;
	var startDate =  getFormatDay($("change_time").value,'ymd');  
	var endDate =  getFormatDay($("change_time_end").value,'ymd');  
	
	var edit =  Ext.fly('editcmd').dom.value; 
	var newMatterId =  Ext.getCmp('editcmd').getValue();	
	var matterLength =  Ext.getCmp('lengthcmd').getValue();	
	var newResourceId =  resource.treecombo.passField.getValue();

	var resource_cmd_id = parent.change_edit_win.getTopToolbar().findById('resource_cmd').getValue();
//	var resource_cmd = parent.change_edit_win.getTopToolbar().getComponent('resource_cmd').getValue();
//	parent.change_edit_win.getTopToolbar().findById('resource_cmd').getValue()

//    matter_id = isRes?resource_cmd_id:matter_id;

	var details =new Array();	
	var detail = (new OrderDetail()).obj;
	detail.id = 0;
	detail.orderId = orderId;
	detail.matterId = newMatterId;
	detail.resourceInfoId = newResourceId;
	detail.matterLength = matterLength;
	
	detail.publishStartDate = startDate*1;
	detail.publishEndDate = endDate*1;
	
//	detail.resourceType = 0;
//	detail.matteType = 0;
//	detail.sumTimes = 0;
//	detail.matteType = 0;	
//	detail.needPublish = 0;	
//	detail.version = 0;	
//	detail.publishStartDate = 0;	
//	detail.publishEndDate = 0;	
	

	detail.orderDetailBak =  getOrderDetailBak(orderDetailId,matter_id,resource_cmd_id,start_date,end_date,adv_edit,adv_length);
	detail.memo = edit;
	detail.loginUser = loginUserName;
	
	
	
	for(var i=0; i< grid.getRowsNum();i++){
		var v = grid.cells2(i,0).getValue();
		if(v == 1){

			var det = (new OrderDetail()).obj;
			det.id = grid.getRowId(i)*1;

			var matterId = grid.getUserData(det.id,"matterId");
			var resourceInfoId = grid.getUserData(det.id,"resourceInfoId");
			var start = grid.getUserData(det.id,"startDate");
 			var end = grid.getUserData(det.id,"endDate");
 			var ed = grid.getUserData(det.id,"edit");
 			var length = grid.getUserData(det.id,"length");	

 			if(start >0){
				det.orderDetailBak = getOrderDetailBak(det.id,matterId,resourceInfoId,start,end,ed,length);
				details.push(det); 
 			}
  
		}
	}
	


	if(details.length > 0){
		function func(s){
			closeFun(s);Ext.getBody().unmask();
		}
		Ext.getBody().mask('数据处理中……', 'x-mask-loading'); 


		orderDetail.saveOrderDetailM(isRes,detail,details,func);
	}else{
		extjMessage('"没有选择需要更换的记录!');
	}

}

function save_more_paragraph(isRes,orderId,closeFun){
	
	var ids = mygrid1.getCheckedRows(0).split(",");

	if(ids[0] > 0){
	//	save_more(orderId,closeFun);
		
		function save(){
			save_more(isRes,orderId,closeFun);
		}
		
	//	Ext.getCmp('editcmd').fireEvent('blur',this); 
	    if(isRes){
	    	save();
	    }else{
	    	checkedit(save);
	    }
		
	}else{
		extjMessage('"请选择需要更换的记录!');
		return false;
	}

}
	

function save_stop_bro(ord,closeFun){

	var ids = mygrid1.getCheckedRows(0).split(",");
	var startDate =  getFormatDay($("change_time").value,'ymd')+'';  
	var endDate =  getFormatDay($("change_time_end").value,'ymd')+'';  
	


	if(ids[0] > 0){
		
		function func(s){
			closeFun(s,true);Ext.getBody().unmask();
		}
		Ext.getBody().mask('数据处理中……', 'x-mask-loading'); 



//		order.saveOrderStopBro(obj,ids,startDate,endDate,func);


		var order2 = new Order();
		
		order2.setObject2(ord);

			parent.getOrderValue(order2.obj,false);

    order2.obj.orderCategory = (new OrderCategory()).obj;
    order2.obj.orderCategory.value = ord.orderCategory.value;
    
    order2.obj.orderPublic = (new OrderPublic()).obj;
    order2.obj.orderPublic.moneyRealpay = ord.orderPublic.moneyRealpay;

    
    order2.obj.orderState = (new OaWorkFlowCheckState()).obj;
    order2.obj.orderState.name = ord.orderState.name;  

		
//		order.saveOrderStopBro2(order2.obj,func);
		
		order.saveOrderStopBro(order2.obj,ids,startDate,endDate,func);

		
	}else{
		extjMessage('"请选择需要停播的记录!');
		return false;
	}

}


function save_moid_spec(ord,closeFun){

	var ids = mygrid1.getCheckedRows(0).split(",");
	var startDate =  getFormatDay($("change_time").value,'ymd')+'';  
	var endDate =  getFormatDay($("change_time_end").value,'ymd')+'';  
	var specValue = getValueFromStoreById(Ext.getCmp("specComman"),"position");
	var specId = Ext.getCmp('specComman').getValue();	
  var specTXT = Ext.getCmp('specComman').getRawValue();
  if(specValue == '') specTXT ="";
 
	if(ids[0] > 0){
		
		function func(s){
			closeFun(s,true);Ext.getBody().unmask();
		}
		Ext.getBody().mask('数据处理中……', 'x-mask-loading'); 



//		order.saveOrderStopBro(obj,ids,startDate,endDate,func);


		var order2 = new Order();
		
		order2.setObject2(ord);

			parent.getOrderValue(order2.obj,false);

    order2.obj.orderCategory = (new OrderCategory()).obj;
    order2.obj.orderCategory.value = ord.orderCategory.value;
    
    order2.obj.orderPublic = (new OrderPublic()).obj;
    order2.obj.orderPublic.moneyRealpay = ord.orderPublic.moneyRealpay;

    
    order2.obj.orderState = (new OaWorkFlowCheckState()).obj;
    order2.obj.orderState.name = ord.orderState.name;  

//		order.saveOrderStopBro2(order2.obj,func);

	
		order.saveOrderSpec(order2.obj,ids,startDate,endDate,specValue,specId,specTXT,func);

		
	}else{
		extjMessage('"请选择需要停播的记录!');
		return false;
	}

}



function save_moid_price(ord,closeFun){
	
	var ids = mygrid1.getCheckedRows(0).split(",");
	var startDate =  getFormatDay($("change_time").value,'ymd')+'';  
	var endDate =  getFormatDay($("change_time_end").value,'ymd')+'';  
	var specValue = getValueFromStoreById(Ext.getCmp("specComman"),"position");
	var specId = Ext.getCmp('specComman').getValue();	
	var specTXT = Ext.getCmp('specComman').getRawValue();
	if(specValue == '') specTXT ="";
 
	if(ids[0] > 0){
		
			function func(s){
				closeFun(s,true);Ext.getBody().unmask();
			}
			Ext.getBody().mask('数据处理中……', 'x-mask-loading'); 


			var order2 = new Order();
			
			order2.setObject2(ord);

			parent.getOrderValue(order2.obj,false);
		
		    order2.obj.orderCategory = (new OrderCategory()).obj;
		    order2.obj.orderCategory.value = ord.orderCategory.value;
		    
		    order2.obj.orderPublic = (new OrderPublic()).obj;
		    order2.obj.orderPublic.moneyRealpay = ord.orderPublic.moneyRealpay;
		
		    
		    order2.obj.orderState = (new OaWorkFlowCheckState()).obj;
		    order2.obj.orderState.name = ord.orderState.name;  

//		order.saveOrderStopBro2(order2.obj,func);

          var execPrice = $("execPrice").value;
          execPrice = execPrice==''?0:execPrice;
          var favourRate = $("favourRate").value;
          favourRate = favourRate==''?0:favourRate/100;
          var appRate = $("appRate").value;
          appRate = appRate==''?0:appRate/100;
          
		  order.saveOrderPrice(order2.obj,ids,startDate,endDate,execPrice,favourRate,appRate,func);

		
	}else{
		extjMessage('"请选择需要修改的记录!');
		return false;
	}

}


function getTimeByDay(start,end){
	var sum = 0;

		for(var i=0;i< orderDayInfos.length;i++){
			
			var t = orderDayInfos[i].adDayTimes;	
			var publishDate =  orderDayInfos[i].publishDate;

				
			if(publishDate >= start && publishDate <= end){
				sum = sum + t*1;
			}
		}

	return sum;
}
function finFirstLastDate(start,end){
		var d = [];
		var s1 = 100000000;
		var s2 = 0;

		for(var i=0;i< orderDayInfos.length;i++){
			
			var t = orderDayInfos[i].adDayTimes;	
			var publishDate =  orderDayInfos[i].publishDate;
			
			
			if(publishDate >= start && publishDate <= end){
				if(publishDate < s1) s1 = publishDate;
				if(publishDate  > s2) s2 = publishDate;
			}			
			
		}
    d[0] = s1; d[1] = s2;
	return d ;
}

function getDate_change_time(startDate,endDate,model){
	
   if(startDate == null || startDate == 'null') startDate = config_serviceDate;
   if(endDate == null  || endDate == 'null') endDate = config_serviceDate;

   if(config_serviceDate>startDate && config_serviceDate<=endDate){
  	 	startDate = config_serviceDate;
   }
   


   var pval = getFormatDay(startDate,'y/m/d'); 
   pval =''+pval;
   

   
   var d =  new   Date(Date.parse(pval.replace(/-/g,   "/")));   
	
		
  Calendar.setup({
		inputField  : "change_time",	  // id of the input field
		singleClick	  : true,
//		date:d,
		range:[order_year],
		firstDay:1,
//		position: this.getPosition(this.inputField)+this.inputField.offsetHeight,
//		dateDisabledFunc : dateDisabledFunc,
		dateDisabledFunc      : function(date) {
                      // disable all dates between 5 and 15 every month
                      if(model == 2) return false;
                      return dateDisabledFunc(date);
//                      return (date.getDate() >= 5 &&
//                              date.getDate() <= 15);
              },
		button	  : "change_time"	// id of the button
	});

	$("change_time").value = pval; 
	
	
   var pval2 = getFormatDay(endDate,'y/m/d'); 
   pval2 =''+pval2;
   var d =  new   Date(Date.parse(pval2.replace(/-/g,   "/")));   	
	
   Calendar.setup({
		inputField  : "change_time_end",	  // id of the input field
		singleClick	  : true,
		range:[order_year],
		firstDay:1,
		dateDisabledFunc      : function(date) {
					  if(model == 2) return false;
                      return dateDisabledFunc(date);
              },
		button	  : "change_time_end"	// id of the button
	});

	$("change_time_end").value = pval2; 	
	
	
	
	
	
	
	


}

//  
//function submit(){
//  		$("resourceTypeForm").submit();
//}
//
//function callBackFun(){
//	
//	
//		    
//	  		
//	  		var orgId =  getParamFromUrl(window.location.href,"orgId");
//	  		
//	  	
//	  		
//	  		
//	  		$("orgId").value = orgId ;
//	  		
//	  		if(orgId > 0){
//	  			
//	  		}else{
//	  			submit();
//	  		}
//	  		
//	  		
//	  		if(config_useMoreCarrierSortParam == 0|| $('orgId').options.length<2){
//				$('orgId_td').hide();
//		    }
//
//
//	}