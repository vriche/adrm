
var financeTarget = new FinanceTargetRatio();
var carrier = new Carrier();
var user = new User();
var customer = new Customer();
var incomePurpose = new IncomePurpose();
var channel = new ResourceChannel();
var myprint = new MyPrint();

var userName;
var targetYear;
var mygrid;

callOnLoad(init);

function init(){
	    this.ctxPath =  _app_params.ctxPath;
		var config_serviceDate = _app_params.serviceDate.def;
		
		 _make_org_select("orgId",120,"onChangeOrg");	
		 orgId = $("orgId").value;
		_make_adrm_sys_year_select("target_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);
		myprint.buildButtons(this,"printReportDiv",[0,1,2,6],80);
 	
		targetYear =  _app_params.serviceDate.year*1;
		channelModelParam = _app_params.sysParam.channelModelParam;
		userName =  _app_params.user.username;
		
		
		
		setCarrierPara(carrier);
		buttonEventFill();
		initGrid();
	 	resetHeigth();
//	 	buildcustomerCommand();
	 	var cmd = incomePurpose.getCombo('incomePurpose_id',120,true,'theDivIncomePurpose');
	 	cmd.selectAll();
	 	var channelCmd = channel.getLovCombo('channel_cmd',90,'local',true,"theDivChannel"); 
	 	channelCmd.selectAll();
//	 	myprint.getComMonth('month_id',"月分",20,2,1,'theDivMonth');
//	 	myprint.getComMonth('month_id',"月分",20,2,1,'theDivMonth');
	 	myprint.getComMonth(1,true,'month_id',"月分",80,_app_params.serviceDate.month*1,false,'theDivMonth');
//	 	global_bulid_month('target_month',20,_app_params.serviceDate.month*1);
	 	
	 	 show_cut_win();	
	 	                
}


function buildcustomerCommand(){
   	customer.obj.orgId = $("orgId").value;
 	customer.obj.version = targetYear;
 	customer.obj.loginUser = userName;
 	customer.obj.model = "3";

 	var callBackFun = function(){};
 	var cmd = customer.getCustomerRemote("theDivCustomerName","customer_name",180,function(){});	
 		
 	cmd.on("select",getTable,this);	
 	cmd.on("clear",getTable,this);	
	 
  }

function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}

function buttonEventFill(){
	
	setSelectByValue($("target_year"),targetYear );
	
	var btn_targetYear = $("target_year");
	btn_targetYear.onchange = getTable;
	
	var Btn_searche=$("Btn_searche");
	Btn_searche.onclick = getTable;	
	
	var BtnClear=$("BtnClear");
	BtnClear.onclick = function(){
		$("customerName").value="";
	};	
	

}


function initGrid(){
    
	mygrid = new dhtmlXGridObject('gridbox');

	mygrid.selMultiRows = true;
	
	mygrid.setImagePath("../image/grid/");

	var flds = "频道名称,月份,公司收入总计,公司转台比率,公司转台金额,留存金额";
	mygrid.flds  = flds;
	mygrid.setHeader(flds);

	mygrid.setInitWidthsP("20,16,16,16,16,16");
	mygrid.setColAlign("left,center,right,right,right,right");
	mygrid.setColTypes("coro,ed,ed,ed,ed,ed");
	mygrid.enableAlterCss("even","uneven"); 
	mygrid.setColSorting("str,int,int,int,int,int") ;
 
// 	makeCarrierSelectItem();
 	
	mygrid.setSkin("modern2");
	//mygrid.enableAutoHeigth(true); 
	
	mygrid.enableMathEditing(true); 
	mygrid.setOnEditCellHandler(calculateFooterValues);
	mygrid.attachFooter("合计(万),<div id='month1'/>,<div id='month2'/>,<div id='month3'/>,<div id='month4'/>,<div id='month5'/>");
	mygrid.init();	 
	//mygrid.attachFooter('合计:, , , , , , , , , , , , , , , ',['text-align:center;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;']);
}

function resetHeigth(){
   	var dialogcontent = parent.document.getElementById("dialogcontentDiv");
   	$("gridbox").style.height = dialogcontent.offsetHeight*0.8+"px";
} 

function onChangeOrg(){
	getTable();
}

function show_cut_win(){
	customer.obj.orgId = $("orgId").value;
	var params =[{accountName:'',accountBank:'',customerName:'',orgId:$("orgId").value},{orgId:$("orgId").value}];
	
	
	function setvalue(ids){
		
		var isMoreCustomer = true;

		if(isMoreCustomer){
			if($("customerName").value == ''){
				$("customerName").value = ids;
			}else{
				$("customerName").value = $("customerName").value+"," +ids;
			}
			
		}else{
			$("customerName").value = ids;
		}
		
	}
	customer.showWin('customerName',params,userName,true,setvalue);
}

function getTable(){
		 var param =  getParams();
		 var paramQueryString =  $H(param).toQueryString();

	    function getFun(xml){
	    	mygrid.clearAll();
		    mygrid.loadXMLString(xml,calculateFooterValues);
		    Ext.getBody().unmask();
	    }
		Ext.getBody().mask('数据加载中……', 'x-mask-loading');
		financeTarget.getFinanceTargetRatioCarrierXML(paramQueryString,getFun)
}



function getCellValue(rowId,col){ 
	return mygrid.cells(rowId,col).getValue();
}

function getResourceIds(){
	var rows = mygrid.getRowsNum();
    var ids = new Array();
	for(var i=0;i<rows;i++){
		var id = mygrid.getRowId(i);
		ids.push(id);
	}
	return ids;
}


function calculateFooterValues(){
        for(var i=0;i<5;i++){
        	var el = $("month"+(i+1));
        	if( i != 0 &&  i != 2){
        		el.innerHTML = sumColumn(i+1);
        	}
        }
        return true;
    }
    
function sumColumn(ind){
        var out = 0;
        for(var i=0;i<mygrid.getRowsNum();i++){
       	var value =mygrid.cells2(i,ind).getValue()==""?0:mygrid.cells2(i,ind).getValue();
            out+= parseFloat(value)
        }
        return ForDight(out/10000,2);;
 }




function printReport(mode){
//	 var s=['view','print','excel'];
	 
	if(mode =="view"){
		 button_print("view");
	}
	if(mode =="print"){
		 button_print("print");
	}
	if(mode =="excel"){
		 button_print("export");
	}
   
}


function getParams(){
	
	var year = $("target_year").value;
	
	var months =  Ext.getCmp('month_id')?Ext.getCmp('month_id').getCheckedValue():null;
	months = months ==""?null:months;
  
	var customerIds = $("customerName").value;
	var incomePurposeIds = Ext.getCmp("incomePurpose_id").getValue();
	incomePurposeIds = incomePurposeIds ==""?null:incomePurposeIds;
	var channels =  Ext.getCmp('channel_cmd')?Ext.getCmp('channel_cmd').getCheckedValue():null;
	channels = channels ==""?null:channels;

	

	var paramObj = {
					year: year,
					months:months,
					channelId:channels,
					customerIds:customerIds,
					incomePurposeIds:incomePurposeIds,
					channels : channels
	};	
	return paramObj;	
	
}


function button_print(model){
	 var heads = mygrid.flds.replace(/\*/g,",");

	 var paramObj = getParams();
	 
	 var printParam = {
					model:  model,
					title:paramObj.year + "("+paramObj.months+")月"+'公司上报数',
	                reportType: "financeTargetRatioCarrierList",
	                reportFile:'',
	                headers:heads, 
	                displaySumColum:"0,0,1,0,1,1",
	                colAlign:"center,center,right,right,right,right",
	                colTypes:"ed,ed,ed,ed,ed,ed",
	                widthsP:"20,16,16,16,16,16",
	                isSum:true,
	                isVertical:false
	 	}; 
	
		 

   var a = Object.extend(paramObj,printParam);

   myprint.loadApplet(a,ctxPath,800,500);	
	        
	
}


