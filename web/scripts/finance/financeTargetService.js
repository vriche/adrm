var financeTarget =new FinanceTarget();
var carrier = new Carrier();
var user = new User();
var userName;
var targetYear;
var mygrid;
// var myprint =new MyPrint();

callOnLoad(init);

function init(){

// 	this.myprint.buildButtons(this,"printReportDiv",[0,1,2,6],80);
 	
	targetYear = getParamFromUrl(window.location.href,"year")*1;
	orgId = getParamFromUrl(window.location.href,"orgId")*1;

	channelModelParam = _app_params.sysParam.channelModelParam;
	userName =  _app_params.user.username;
	
	setCarrierPara(carrier);
	

		
	initGrid();
	buttonEventFill();
 	getFinanceTargetList();
 	
 	resetHeigth();
 	

 	
}

function makeCarrierSelectItem(){
	//根据是否分频道，取得频道下拉列表
	carrier.obj.orgId = orgId;
	
	if(channelModelParam!=1){
		carrier.makeSelectItemAnalyze(carrier.obj,carrier.selectName,"",setCarrierSelect);
	}else{
		carrier.makeSelectItemAnalyze2(carrier,carrier.selectName,"",setCarrierSelect);
	}
}
function setCarrierSelect(){
	
	getCarrierCombo(true);
}

function buttonEventFill(){

	
	//var Btn_save=$("Btn_save");
	//Btn_save.onclick=btnSave;
	
	//var Btn_add_row=$("Btn_add_row");
	//Btn_add_row.onclick=btnAddRow;
	
	//var Btn_delete_row=$("Btn_delete_row");
	//Btn_delete_row.onclick=btnDeleteRow;
}

function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}

function resetHeigth(){
   	//var dialogcontent = $("dialogcontentDiv");
   	var dialogcontent = parent.document.getElementById("dialogcontentDiv");
   	$("gridbox").style.height = dialogcontent.offsetHeight*0.8+"px";
} 

function btnSave(){

	// var arrCarrierCom = getCarrierComboIds($(carrier.selectName));
//	var carrierId = $(carrier.selectName).value==null||$(carrier.selectName).value==""?0:$(carrier.selectName).value;
         var arr = getCarrierIds();
         var arrNew = arr.uniq();
         if(arrNew.length < arr.length) {
         	alert("频道名称有重复，不能保存，请检查!");
         	return false;
         }
         
         
         
         
	var financeTargets = getfinanceTargetsGrid();
	function callBackFun(){
		//getCarrierCombo($(carrier.selectName));
		}
	if(financeTargets.length> 0 ) financeTarget.saveFinanceTargets(financeTargets,channelModelParam,userName,callBackFun);
	
	
	
}
function getfinanceTargetsGrid(){ 

	var financeTargets = new Array();
	var rows = getResourceIds();

	
	  		
		    
		  for(var i =0;i< rows.length;i++){
			var row_id = rows[i];
		
			var financeT = (new FinanceTarget()).obj;
			var tarMoney = new Array();

			// alert(1111);
				financeT.carrierId = getCellValue(row_id,0); 
				
//				financeT.targetDateYear = getCellValue(row_id,1);
				financeT.targetDateYear = targetYear;
				for(var j =1;j< 13;j++){
					tarMoney[j-1] = getCellValue(row_id,j);
					tarMoney[j-1] = tarMoney[j-1] == ""?"0":tarMoney[j-1];
				}
			  	financeT.tarMonths = tarMoney;
		
			financeTargets.push(financeT);
		  }

	return financeTargets;
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



function btnAddRow(){
	getCarrierCombo(true);
	var command = mygrid.getCombo(0);
	if(command.keys.length > 0){
		var id = command.keys[0];
		mygrid.addRow((new Date()).valueOf(),[id],mygrid.getRowsNum()+1);
		//calculateFooterValues();
	}


}

function btnDeleteRow(){
	var id = mygrid.getSelectedId();
	if(id > 0){
		var msg = "请确认是否删除这条记录 ?";
		
		ans = confirm(msg);
	    if (ans) {
	    	var financeT = (new FinanceTarget()).obj;
		financeT.carrierId = getCellValue(id,0); 
		financeT.targetDateYear = targetYear;
		
		mygrid.deleteSelectedItem(); 

		function callBackFun(){
			Ext.getBody().unmask();
			//getCarrierCombo($(carrier.selectName));
			}
	    Ext.getBody().mask('数据加载中……', 'x-mask-loading');		
		financeTarget.deleteFinanceTarget(financeT,callBackFun);
	    } 
	}
}


function initGrid(){
     
	mygrid = new dhtmlXGridObject('gridbox');

	mygrid.selMultiRows = true;
	
	mygrid.setImagePath("../image/grid/");

	var flds = "频道名称,一月,二月,三月,四月,五月,六月,七月,八月,九月,十月,十一月,十二月,全年";
	mygrid.setHeader(flds);

	mygrid.setInitWidthsP("8,7,7,7,7,7,7,7,7,7,7,7,7,7");
	mygrid.setColAlign("left,right,right,right,right,right,right,right,right,right,right,right,right,right");
	mygrid.setColTypes("coro,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed[=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12]");
	mygrid.enableAlterCss("even","uneven"); 
	mygrid.setColSorting("str,int,int,int,int,int,int,int,int,int,int,int,int,int,int") ;
 
 	makeCarrierSelectItem();
 	
	mygrid.setSkin("modern2");
	//mygrid.enableAutoHeigth(true); 
	
	mygrid.enableMathEditing(true); 
	mygrid.setOnEditCellHandler(calculateFooterValues);
	mygrid.attachFooter("合计(万),<div id='month1'/>,<div id='month2'/>,<div id='month3'/>,<div id='month4'/>,<div id='month5'/>,<div id='month6'/>,<div id='month7'/>,<div id='month8'/>,<div id='month9'/>,<div id='month10'/>,<div id='month11'/>,<div id='month12'/>,<div id='month13'/>");
	mygrid.init();	 
	//mygrid.attachFooter('合计:, , , , , , , , , , , , , , , ',['text-align:center;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;']);
}

function calculateFooterValues(){
//        var nrQ = document.getElementById("nr_q");
//        nrQ.innerHTML = sumColumn(1)
//        var srQ = document.getElementById("sr_q");
//        srQ.innerHTML = sumColumn(2);
        for(var i=0;i<13;i++){
        	var el = $("month"+(i+1));
        	el.innerHTML = sumColumn(i+1);
        }
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

function getFinanceTargetList(year){
	
	if(year > 0 ) targetYear = year;
//	financeTarget.targetDateYear = targetYear*1;
	var carrierId = $(carrier.selectName).value==null||$(carrier.selectName).value==""?0:$(carrier.selectName).value;
    function getFun(xml){
    	    mygrid.clearAll();
	    mygrid.loadXMLString(xml,calculateFooterValues);
	    Ext.getBody().unmask();
	    //setCarrierSelect();
    }
	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	financeTarget.getFinanceTargetsXML(targetYear,carrierId,channelModelParam,userName,getFun)
	
}

function getCarrierCombo(fitter){
	var el = $(carrier.selectName);
	var inputs = el.getElementsByTagName("option");
	var command = mygrid.getCombo(0);
	var arr = getCarrierIds();
	//alert(arr);
	command.clear();
	inputs = $A(inputs);
	inputs.each(function(ip){
		if(ip.value!=0){
			if(fitter){
				if(arr.indexOf(ip.value)== -1){
					command.put(ip.value,el.options[ip.index].text);	
				}			
			}else{
				command.put(ip.value,el.options[ip.index].text);
			}

		}	
		}
	);
}
 
 function getCarrierIds(){
	var rows = mygrid.getRowsNum();
   	 var ids = new Array();
	for(var i=0;i<rows;i++){
		var id = mygrid.getRowId(i); 
		ids.push(getCellValue(id,0));
	}
	return ids;
}

function printReport(mode){
//	 var s=['view','print','excel'];
	 
	if(mode =="view"){
		button_view_target();
	}
	if(mode =="print"){
		button_print_target();
	}
	if(mode =="excel"){
		button_export_target();
	}
	
	if(mode =="chart"){
		getTargetChartObjs();
	}	
	
	   
}

function button_view_target(){
	 $("model").value = "view";
	 $("reportType").value = "financeTargetAnalyze_report";
	 button_print();
}	
function button_print_target(){
	 $("model").value = "print";
	 $("reportType").value = "financeTargetAnalyze_report";
	 button_print();
}
function button_export_target(){
	 $("model").value = "export";
	 $("reportType").value = "financeTargetAnalyze_report";
	 button_print();
}
function button_print(){
	$("yearForm").value = targetYear;
	$("channelModelForm").value = channelModelParam;
    $("userNameForm").value = userName;
    $("carrierIdsForm").value = $(carrier.selectName).value==null||$(carrier.selectName).value==""?0:$(carrier.selectName).value;

	var tarForm =  $("tarForm1");
	var reportForm = $("ReportForm");
	
	reportForm.target = tarForm;
	reportForm.action="../reports/jsp/common_reports.jsp";
	reportForm.submit(); 	
}

function getTargetChartObjs(){
	
	var yearForm = targetYear;
	var carrierId = $(carrier.selectName).value==null||$(carrier.selectName).value==""?0:$(carrier.selectName).value;
	
	function func(objs){
		fusionChartObjects = objs;
		alert(fusionChartObjects.length);
	}
	
	//startDate,endDate,sorCol,sorType,putYear
		
		var a = {
                
                yearForm: yearForm,
                carrierId:carrierId,
                userName: userName,
				channelModelParam:channelModelParam
		};		

        var h = $H(a);
		var url = "financeTargetChart.html?"+h.toQueryString();
		window.open(url);

}


